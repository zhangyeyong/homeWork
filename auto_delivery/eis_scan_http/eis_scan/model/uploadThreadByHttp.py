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
from i18n.i18nU import _
import json
import config.constants as constants
import httpU2
from httpU2 import MultiPartForm
import os.path as path
import sys
uploadingHeadId = None
def callback(buf):
    global uploadingHeadId
    if uploadingHeadId:
        imgHeadDao = ImgHeadDao()
        imgHeadDao.addUploadSize(uploadingHeadId, len(buf))
    
class UploadThread(threading.Thread):  # The timer class is derived from the class threading.Thread  
    imgHeadDao = ImgHeadDao()
    imgLineDao = ImgLineDao()
    uploadTaskDao = UploadTaskDao()
    uploadTaskLogDao = UploadTaskLogDao()
    ocrResultDao = OcrResultDao()
    evsInterface = GhEvsInterface()
    def __init__(self, headIds, ticket, uploadUrl):  
        threading.Thread.__init__(self)  
        self.headIds = headIds
        self.ticket = ticket
        self.uploadUrl = uploadUrl 
       
    def toUploadForm(self,url,ticket,headNum,filePath,imgOrd):
        file_obj = None
        form = MultiPartForm()
        try: 
            url = httpU2.unicode2Str(url)
            ticket = httpU2.unicode2Str(ticket)
            headNum = httpU2.unicode2Str(headNum)
            filePath = httpU2.unicode2Str(filePath)
            file_obj=open(filePath,'rb')
            if not path.exists(filePath):
                #return {"code":"F","errorMsg":"file [%s] not exist"%filePath}
                print >> sys.stderr, "toUploadForm failed - file [%s] not exist"%filePath
            fileName = path.basename(filePath)
            fileName = fileName+"?"+str(imgOrd)			
            form.add_field("ticket", ticket) 
            form.add_field("headNum", headNum) 
            form.add_file('uploadFile', fileName, file_obj)
        except Exception, e:
            print >> sys.stderr, "toUploadForm failed - %s" % e
        finally:
            if file_obj:
                file_obj.close()
        return form
    def run(self):  # Overwrite run() method, put what you want the thread do here  
        startTime = time.time()
        global uploadingHeadId
        for headId in self.headIds:
            uploadingHeadId = headId
            imgHead = self.imgHeadDao.getById(headId)
            userForm = {}
            for f in json.loads(imgHead.get("userForm")):
                userForm[f.get("name")]= f.get("value")
            jsonParam = {"appCode":imgHead.get("appCode"),"form":userForm}
            
            t1 = time.time()
            #询问服务器是否能上传
            ftpRet = self.evsInterface.FtpInfo(self.ticket, imgHead.get("headStatus"),json.dumps(jsonParam) )
            if not ftpRet.get("isSuccess"):
                self.uploadTaskDao.deleteByHeadId(headId)
                imgHead["status"] = headStatus.FAILURE
                imgHead["errorMsg"] = _(u"访问接口 FtpInfo 失败 ")
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
#             print "-----------ftpInfo",ftpInfo
#             print "-----------ftpInfo.get(\"ftpId\")):",ftpInfo.get("ftpId")
#             print "-----------str(ftpInfo.get(\"ftpId\"))):",str(ftpInfo.get("ftpId"))
#             print "-----------self.ftpMap.get(str(ftpInfo.get(\"ftpId\"))):",self.ftpMap.get(str(ftpInfo.get("ftpId")))
#             ftpInfo.update(self.ftpMap.get(str(ftpInfo.get("ftpId")))) 
               
            self.uploadTaskDao.updateStatusByHeadId(headId, taskStatus.UPLOADING)
            t2 = time.time()
            print "call uploadTaskDao time :%d" % (t2 - t1)
            
            imgLines = self.imgLineDao.findByHeadId2(headId)
#             imageList = []
#             iconList = []
            # 上传影像到ftp
            flag = False
            t1 = time.time()
#                 ip:,port:,userName:"","password":
#             ftpIp = ftpInfo.get("ftpIp")
#             ftpPort = int(ftpInfo.get("port"))
#             ftpUser = ftpInfo.get("userName")
#             ftpPwd = ftpInfo.get("password")
#             imagePath = ftpInfo.get("imagePath")
#             iconPath = ftpInfo.get("iconPath")
            
            #上传原图
            #测试ftp 
#             flagFtp = True
#             flagFtp = myFtp.testFtp(ftpIp, ftpPort, ftpUser, ftpPwd)
#             if not flagFtp:
#                 self.uploadTaskDao.uploadFail(headId,_("连接ftp[%s]失败"%(str(ftpIp))))
#                 continue      
            #如果是评价任务，删除
#             if constants.belongType.get("APPRAISE_TASK")==imgHead.get("belong"): 
#                 print "delete dir ----->iconPath:",iconPath               
#                 myFtp.deletedir(ftpIp, ftpPort, ftpUser, ftpPwd,iconPath)
            uploadFileFlag = True
            uploadFileRtn = {}
            for imgLine in imgLines:
                #如果曾经已上传成功，则会有uploadId和uploadIconId.则不再上传
                if imgLine["uploadId"] and imgLine["uploadIconId"]:
                    continue
                localPath = pathJoin(scanPath, imgHead.headNum, imgLine.imgNameP)
                localIconPath = pathJoin(scanPath, imgHead.headNum, "s_"+imgLine.imgNameP)
                #上传原图
                form = self.toUploadForm(self.uploadUrl,self.ticket,imgHead.headNum,localPath,imgLine.imgOrd)
                uploadFileRtn = httpU2.upload(self.uploadUrl, form)
                #上传缩略图
                form = self.toUploadForm(self.uploadUrl,self.ticket,imgHead.headNum,localIconPath,imgLine.imgOrd)
                uploadIconFileRtn = httpU2.upload(self.uploadUrl, form)
                #只有一个失败当前任务就算失败
                if not uploadFileRtn or "S"!=uploadFileRtn.get("code"):
                    uploadFileFlag = False
                    break
                #更新上传的文件的大小
                imgLine["uploadSize"] = imgLine["imgSize"]
                if uploadFileRtn and uploadFileRtn.get("data") and uploadFileRtn.get("data").get("imageId"):
                    imgLine["uploadId"] = uploadFileRtn.get("data").get("imageId")
                if uploadIconFileRtn and uploadIconFileRtn.get("data") and uploadIconFileRtn.get("data").get("imageId"):
                    imgLine["uploadIconId"] = uploadIconFileRtn.get("data").get("imageId")
                self.imgLineDao.updateImgLine(imgLine);
                self.imgHeadDao.uploadSize(headId);
            t2 = time.time()
            print "call ftpU.upload time :%d" % (t2 - t1) 
            if not uploadFileFlag:
                #更新状态
                imgHead["status"] = headStatus.FAILURE
                imgHead["errorMsg"] = uploadFileRtn.get("errorMsg")
                self.imgHeadDao.update(imgHead)
                continue
            # 同步上传影像的信息 TODO
            t1 = time.time()
            imgLines = self.imgLineDao.findByHeadId2(headId)
            imageList = []
            iconList = []
            for imgLine in imgLines:
                imageList.append(imgLine["uploadId"])
                iconList.append(imgLine["uploadIconId"])
            jsonParam["imageList"] = imageList
            jsonParam["iconList"] = iconList
            UploadLogRtn = self.evsInterface.UploadLog(self.ticket,imgHead.get("belong"), json.dumps(jsonParam))
            uploadLogFlag = False
            if(UploadLogRtn and UploadLogRtn.get("isSuccess") and UploadLogRtn.get("data") and UploadLogRtn.get("data").get("code")=='S'):
                uploadLogFlag = True
            t2 = time.time()
            print "call client.service.UploadLog time :%d" % (t2 - t1)
            print "---------->uploadLogFlag:" + str(uploadLogFlag)
            if not uploadLogFlag:
                imgHead["status"] = headStatus.FAILURE
                imgHead["errorMsg"] = uploadFileRtn.get("errorMsg")
                self.imgHeadDao.update(imgHead)
                continue
            flag = uploadFileFlag and uploadLogFlag
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
            
            imgHead["status"] = status
            if status == headStatus.FAILURE:
                imgHead["errorMsg"] = uploadFileRtn.get("errorMsg") 
            else:
                imgHead["errorMsg"] = "" #将错误信息清空
            
            self.imgHeadDao.updateStatusAndErrorMsgByheadId(headId,imgHead["status"],imgHead["errorMsg"])
            t2 = time.time()
            print "update status time :%d" % (t2 - t1)
        endTime = time.time()
        print "总时间%d" % (endTime - startTime)
if __name__ == "__main__":
    pass
