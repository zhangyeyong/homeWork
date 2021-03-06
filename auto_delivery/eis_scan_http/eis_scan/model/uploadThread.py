# coding:utf-8
# 识别增值税发票后台线程
import threading
from config.config import scanPath
import time
import copy
from tool import pathJoin
from imgHeadDao import ImgHeadDao
from imgLineDao import ImgLineDao
from uploadTaskDao import UploadTaskDao
from uploadTaskLogDao import UploadTaskLogDao
from ocrResultDao import OcrResultDao
from interface import GhEvsInterface
from config.constants import taskStatus, headStatus, ftpStatus
import ftpU
import traceback
from i18n.i18nU import _
import json
class UploadThread(threading.Thread):  # The timer class is derived from the class threading.Thread  
    imgHeadDao = ImgHeadDao()
    imgLineDao = ImgLineDao()
    uploadTaskDao = UploadTaskDao()
    uploadTaskLogDao = UploadTaskLogDao()
    ocrResultDao = OcrResultDao()
    evsInterface = GhEvsInterface()
    def __init__(self, headIds, ticket, ftpMap):  
        threading.Thread.__init__(self)  
        self.headIds = headIds
        self.ticket = ticket
        self.ftpMap = ftpMap 
    
    def run(self):  # Overwrite run() method, put what you want the thread do here  
        startTime = time.time()
        for headId in self.headIds:
            imgHead = self.imgHeadDao.getById(headId)
            userForm = {}
            for f in json.loads(imgHead.get("userForm")):
                userForm[f.get("name")]= f.get("value")
            jsonParam = {"appCode":imgHead.get("appCode"),"form":userForm}
            
            t1 = time.time()
            #询问服务器是否能上传
            ftpRet = self.evsInterface.FtpInfo(self.ticket, imgHead.get("belong"),json.dumps(jsonParam) )
            if not ftpRet.get("isSuccess"):
                self.uploadTaskDao.deleteByHeadId(headId)
                imgHead["status"] = headStatus.FAILURE
                imgHead["errorMsg"] = _("获取ftp信息失败")
                self.imgHeadDao.update(imgHead)
                continue
            
            ftpInfo = ftpRet.get("data")
            #不能上传
            if ftpInfo.get('code')=='F' or ftpInfo.get("status")==ftpStatus.CLOSED:
                self.uploadTaskDao.deleteByHeadId(headId)
                imgHead["status"] = headStatus.FAILURE
                imgHead["errorMsg"] = ftpInfo.get("errorMsg")
                self.imgHeadDao.update(imgHead)
                continue
            #补全ftp信息
            ftpInfo.update(self.ftpMap.get(str(ftpInfo.get("ftpId")))) 
               
            self.uploadTaskDao.updateStatusByHeadId(headId, taskStatus.UPLOADING)
            t2 = time.time()
            print "call uploadTaskDao time :%d" % (t2 - t1)
            srcFileNames = []
            srcIconFileNames = []
            targetFileNames = []
            

            
            imgLines = self.imgLineDao.findByHeadId2(headId)
            for imgLine in imgLines:
                fileNameTemp = pathJoin(scanPath, imgHead.headNum, imgLine.imgNameP)
                srcFileNames.append(fileNameTemp)
                srcIconFileNames.append(pathJoin(scanPath, imgHead.headNum, "s_"+imgLine.imgNameP))
                targetFileNames.append(imgLine.imgNameP)
            
            # 上传影像到ftp
            flag = False
            try:
                t1 = time.time()
#                 ip:,port:,userName:"","password":
                ftpIp = ftpInfo.get("ftpIp")
                ftpPort = int(ftpInfo.get("port"))
                ftpUser = ftpInfo.get("userName")
                ftpPwd = ftpInfo.get("password")
                imagePath = ftpInfo.get("imagePath")
                iconPath = ftpInfo.get("iconPath")
                
                #上传原图
                flagFtp = ftpU.upload(ftpUser, ftpPwd, srcFileNames, ftpIp, ftpPort, imagePath, targetFileNames)
                if iconPath:
                    #上传缩略图
                    ftpU.upload(ftpUser, ftpPwd, srcIconFileNames, ftpIp, ftpPort, iconPath, targetFileNames)
                t2 = time.time()
                print "call ftpU.upload time :%d" % (t2 - t1) 
                if flagFtp:                
                # 同步上传影像的信息 TODO
                    t1 = time.time()
                    imageList = []
                    iconList = []
                    for fileName in targetFileNames:
                        imageList.append(pathJoin(imagePath,fileName))
                        iconList.append(pathJoin(iconPath,fileName))                        
                    jsonParam["imageList"] = imageList
                    jsonParam["iconList"] = iconList
                    uploadLogFlag = self.evsInterface.UploadLog(self.ticket,imgHead.get("belong"), json.dumps(jsonParam))
                    t2 = time.time()
                    print "call client.service.UploadLog time :%d" % (t2 - t1)
                    print "---------->uploadLogFlag:" + str(uploadLogFlag)
                    flag = flagFtp and uploadLogFlag
            except:
                traceback.print_exc()
                print "upload has exception"
                pass
            status = headStatus.FAILURE 
            # 在删除之前，先查询出数据，用于插入日志表
            uploadTask = self.uploadTaskDao.getByHeadId(headId)
            if flag: 
                status = headStatus.SUCCESS
                # 删除任务
                self.uploadTaskDao.deleteByHeadId(headId)
            else:
                # 修改状态
                self.uploadTaskDao.updateStatusByHeadId(headId, status)
            # 插入上传任务历史表
            t1 = time.time()
            uploadTaskLog = copy.deepcopy(uploadTask)
            uploadTaskLog.pop("uploadTaskId")
            uploadTaskLog['status'] = status
            
            self.uploadTaskLogDao.save(uploadTaskLog)
            # 修改组状态
            self.imgHeadDao.updateStatusByheadId(headId, status)
            t2 = time.time()
            print "update status time :%d" % (t2 - t1)
        endTime = time.time()
        print "总时间%d" % (endTime - startTime)
if __name__ == "__main__":
    pass
