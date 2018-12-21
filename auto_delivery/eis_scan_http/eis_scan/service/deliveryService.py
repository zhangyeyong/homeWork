# coding:utf-8

from libs import web

from controllers.controller import render, initSession
from config.config import scanPath
import time
import copy
from tool import pathJoin
from model.imgHeadDao import ImgHeadDao
from model.imgLineDao import ImgLineDao
from model.boxDao import BoxDao
from model.uploadTaskDao import UploadTaskDao
from model.uploadTaskLogDao import UploadTaskLogDao
from model.ocrResultDao import OcrResultDao
from model.interface import GhEvsInterface
from config.constants import taskStatus, headStatus, ftpStatus, configkey
from model.ftpU4 import MyFTP
from i18n.i18nU import _
import config.constants as constants
from model.serialU import ComU
from config.config import scanPath
from config import config

import json
from model import common
from model.meidingSerial import MeidingSerial
import os
import traceback


def sendDataBySerial(data):
    configDict = config.getConfigDict()
    SERIAL_PORT = configDict.get(configkey.SERIAL_PORT)
    SERIAL_BAUDRATE = configDict.get(configkey.SERIAL_BAUDRATE)
    comU = ComU(SERIAL_PORT, SERIAL_BAUDRATE)
    rtn = comU.sendAndWaitRecvDate(data)
    comU.closeCom()
    return rtn


class Index:
    def __init__(self):
        pass

    def GET(self):
        return render.modules.delivery.index()

    def POST(self):
        i = web.input()
        method = i.get("method")
        if method == "sendData":
            sendStr = i.get("sendStr")
            return json.dumps(self.sendData(sendStr.encode("utf-8")))
        elif method == "recvDate":
            return json.dumps(self.recvDate())
        elif method == "saveConf":
            port = i.get("port", "COM1")
            baudrate = i.get("baudrate", 9600)
            return json.dumps(self.reloadCom(port, baudrate))


class Scan:
    def __init__(self):
        pass

    def initMachine(self):
        rtn = common.buildSuccess("initMachine ok ")
        # mds = MeidingSerial()
        # rtn = mds.initMachine()
        return json.dumps(rtn)

    def doScan(self):
        mds = MeidingSerial()
        rtn = mds.backPaper()
        return json.dumps(rtn)

    def backPaper(self):
        mds = MeidingSerial()
        rtn = mds.backPaper()
        return json.dumps(rtn)

    def GET(self):
        return render.modules.delivery.scan()

    def POST(self):
        i = web.input()
        method = i.get("method")
        if ("initMachine" == method):
            return self.initMachine()
        if ("backPaper" == method):
            return self.backPaper()


class Refund:
    boxDao = BoxDao()

    def __init__(self):
        pass

    def initMachine(self):
        mds = MeidingSerial()
        rtn = mds.openBox()
        if rtn["isSuccess"]:
            return json.dumps(rtn)
        else:
            return json.dumps(common.buildFail("电机初始化失败"))

        return json.dumps(common.buildSuccess(data=p_data))

    def findAll(self):
        boxs = self.boxDao.findAll()
        return common.buildSuccess(data=boxs)

    def GET(self):
        return render.modules.delivery.refund(self.findAll())

    def POST(self):
        i = web.input()
        method = i.get("method")
        if ("initMachine" == method):
            return self.initMachine()


class MachineError:
    def __init__(self):
        pass

    def GET(self):
        return render.modules.delivery.machineError()

    def POST(self):
        i = web.input()
        method = i.get("method")
        if ("initMachine" == method):
            return self.initMachine()


class PickUp:
    boxDao = BoxDao()

    def __init__(self):
        pass

    def GET(self):
        return render.modules.delivery.machineError()

    def pickUp(self):
        i = web.input()
        pickupCode = i.get("pickupCode")
        if not pickupCode:
            return json.dumps(common.buildFail(u"取件码不能为空！"))
        # 通过取件码查询柜子
        box = self.boxDao.getByPickupCode(pickupCode)
        if not box:
            return json.dumps(common.buildFail(u"取件码错误，请重新输入！"))
        # 发送打开柜子指令
        # mds = MeidingSerial()
        # rtn = mds.openBox()
        rtn = common.buildSuccess()
        return json.dumps(rtn)

    def POST(self):
        i = web.input()
        method = i.get("method")
        if ("pickup" == method):
            return self.pickUp()


class Edit:
    imgLineDao = ImgLineDao()
    imgHeadDao = ImgHeadDao()
    uploadTaskDao = UploadTaskDao()
    uploadTaskLogDao = UploadTaskLogDao()
    evsInterface = GhEvsInterface()

    def __init__(self):
        self.uploadingLineId = None
        pass

    def getImages(self):
        i = web.input()
        headId = i.get("headId")
        lines = self.imgLineDao.findByHeadId2(headId)
        datas = []
        for line in lines:
            data = {
                "alt": "序号" + str(line.get("imgOrd")),
                "pid": line.get("id"),
                "src": "/static/images/scan/" + line.get("headNum") + "/" + line.get("imgNameP"),
                "thumb": "/static/images/scan/" + line.get("headNum") + "/s_" + line.get("imgNameP"),  # 缩略图地址
            }
            datas.append(data)

        p_data = {
            "title": lines[0].get("headNum"),
            "id": headId,
            "start": 0,
            "data": datas
        }
        return json.dumps(common.buildSuccess(data=p_data))

    def callback2(self, buf):
        if self.uploadingLineId:
            imgLineDao = ImgLineDao()
            imgLineDao.addUploadSize(uploadingLineId, len(buf))

    def uploadToFtp(self):
        i = web.input()
        session = web.config._session
        headId = i.get("headId")
        startTime = time.time()
        self.uploadingLineId = headId
        imgHead = self.imgHeadDao.getById(headId)
        # 清空
        imgHead['errorMsg'] = ''
        imgHead["uploadTime"] = time.strftime('%Y-%m-%d %H:%M:%S')
        imgHead['status'] = headStatus.UPLOADING
        self.imgHeadDao.update(imgHead)
        userForm = {}
        for f in json.loads(imgHead.get("userForm")):
            userForm[f.get("name")] = f.get("value")
        jsonParam = {"appCode": imgHead.get("appCode"), "form": userForm}

        t1 = time.time()
        # 询问服务器是否能上传
        ftpRet = self.evsInterface.FtpInfo(session.ticket, imgHead.get("belong"), json.dumps(jsonParam))
        if not ftpRet.get("isSuccess"):
            self.uploadTaskDao.deleteByHeadId(headId)
            imgHead["status"] = headStatus.FAILURE
            imgHead["errorMsg"] = _(u"获取ftp信息失败")
            self.imgHeadDao.update(imgHead)

        ftpInfo = ftpRet.get("data")
        # 不能上传
        if ftpInfo.get('code') == 'F' or ftpInfo.get("status") == ftpStatus.CLOSED:
            self.uploadTaskDao.deleteByHeadId(headId)
            imgHead["status"] = headStatus.FAILURE
            imgHead["errorMsg"] = ftpInfo.get("errorMsg")
            self.imgHeadDao.update(imgHead)
        # 补全ftp信息
        print "-----------ftpInfo", ftpInfo
        print "-----------ftpInfo.get(\"ftpId\")):", ftpInfo.get("ftpId")
        print "-----------str(ftpInfo.get(\"ftpId\"))):", str(ftpInfo.get("ftpId"))
        #             print "-----------self.ftpMap.get(str(ftpInfo.get(\"ftpId\"))):",self.ftpMap.get(str(ftpInfo.get("ftpId")))
        ftpInfo.update(session.ftpMap.get(str(ftpInfo.get("ftpId"))))

        self.uploadTaskDao.updateStatusByHeadId(headId, taskStatus.UPLOADING)
        t2 = time.time()
        print "call uploadTaskDao time :%d" % (t2 - t1)

        imgLines = self.imgLineDao.findByHeadId2(headId)
        imageList = []
        iconList = []
        # 上传影像到ftp
        flag = False
        t1 = time.time()
        #                 ip:,port:,userName:"","password":
        ftpIp = ftpInfo.get("ftpIp")
        ftpPort = int(ftpInfo.get("port"))
        ftpUser = ftpInfo.get("userName")
        ftpPwd = ftpInfo.get("password")
        imagePath = ftpInfo.get("imagePath")
        iconPath = ftpInfo.get("iconPath")

        # 上传原图
        myFtp = MyFTP()
        # 测试ftp
        flagFtp = True
        flagFtp = myFtp.testFtp(ftpIp, ftpPort, ftpUser, ftpPwd)
        if not flagFtp:
            self.uploadTaskDao.uploadFail(headId, _(u"连接ftp[%s]失败" % (str(ftpIp))))
            # 如果是评价任务，删除
        if constants.belongType.get("APPRAISE_TASK") == imgHead.get("belong"):
            print "delete dir ----->iconPath:", iconPath
            myFtp.deletedir(ftpIp, ftpPort, ftpUser, ftpPwd, iconPath)
        for imgLine in imgLines:
            localPath = pathJoin(scanPath, imgHead.headNum, imgLine.imgNameP)
            localIconPath = pathJoin(scanPath, imgHead.headNum, "s_" + imgLine.imgNameP)
            remotePath = pathJoin(imagePath, imgHead.headNum, imgLine.imgNameP)
            imageList.append(remotePath)
            global uploadingLineId
            uploadingLineId = imgLine.lineId
            flagFtp = flagFtp and myFtp.upload(ftpIp, ftpPort, ftpUser, ftpPwd, remotePath, localPath, self.callback2)
            if not flagFtp:
                break
            if iconPath:
                # 上传缩略图
                remoteIconPath = pathJoin(iconPath, imgHead.headNum, imgLine.imgNameP)
                iconList.append(remoteIconPath)
                flagFtp = flagFtp and myFtp.upload(ftpIp, ftpPort, ftpUser, ftpPwd, remoteIconPath, localIconPath)
            # 只要有一个失败当前任务就算失败
            if not flagFtp:
                break
        t2 = time.time()
        print "call ftpU.upload time :%d" % (t2 - t1)
        if flagFtp:
            # 同步上传影像的信息 TODO
            t1 = time.time()
            jsonParam["imageList"] = imageList
            jsonParam["iconList"] = iconList
            #                 uploadLogFlag = self.evsInterface.UploadLog(self.ticket,imgHead.get("belong"), json.dumps(jsonParam))
            UploadLogRtn = self.evsInterface.UploadLog(session.ticket, imgHead.get("belong"), json.dumps(jsonParam))
            uploadLogFlag = False
            if (UploadLogRtn and UploadLogRtn.get("isSuccess") and UploadLogRtn.get("data") and UploadLogRtn.get(
                    "data").get("code") == 'S'):
                uploadLogFlag = True
            t2 = time.time()
            print "call client.service.UploadLog time :%d" % (t2 - t1)
            print "---------->uploadLogFlag:" + str(uploadLogFlag)
            flag = flagFtp and uploadLogFlag
        status = headStatus.FAILURE
        # # 在删除之前，先查询出数据，用于插入日志表
        # uploadTask = self.uploadTaskDao.getByHeadId(headId)
        if flag:
            status = headStatus.SUCCESS
            # 删除任务
            self.uploadTaskDao.deleteByHeadId(headId)
        else:
            # 修改状态
            self.uploadTaskDao.updateStatusByHeadId(headId, status)
        # 插入上传任务历史表
        t1 = time.time()
        # uploadTaskLog = copy.deepcopy(uploadTask)
        # uploadTaskLog.pop("uploadTaskId")
        # uploadTaskLog['status'] = status

        # self.uploadTaskLogDao.save(uploadTaskLog)
        # 修改组状态
        self.imgHeadDao.updateStatusByheadId(headId, status)
        t2 = time.time()
        print "update status time :%d" % (t2 - t1)
        endTime = time.time()
        print u"总时间%d" % (endTime - startTime)
        return status

    def submit(self):
        flag = self.uploadToFtp()
        # self.callCom()
        if not flag:
            return json.dumps(common.buildFail(u"上传FTP失败!"))

        rtn = sendDataBySerial(serial_command.SEND_SCAN_OK)
        if rtn["isSuccess"] and serial_command.SEND_SCAN_OK_RECEIVE == rtn["data"]:
            return json.dumps(rtn)
        else:
            return json.dumps(common.buildFail(u"电机收件失败，请联系管理员"))

    def deleteTaskByHeadId(self, headId):
        head = self.imgHeadDao.getById(headId)
        self.imgHeadDao.deleteByHeadId(headId)
        headPath = pathJoin(scanPath, head.get("headNum"))
        import os
        if os.path.exists(headPath):
            import shutil
            shutil.rmtree(headPath)
        return json.dumps(common.buildSuccess(data=head))

    def cancel(self):
        # 通知电机退票
        # mds = MeidingSerial()
        # rtn = mds.backPaper()
        rtn = common.buildSuccess()
        if rtn["isSuccess"]:
            # 删除任务
            i = web.input()
            head_id = i.get("headId")
            rtn = self.deleteTaskByHeadId(head_id)
        return rtn

    def editNum(self):
        rtn = None
        i = web.input()
        dbHead = self.imgHeadDao.findByHeadNum(i.headNum)
        if dbHead is not None:
            rtn = common.buildFail(_(u"任务编号：") + i.headNum + _(u"已经存在"))
            return json.dumps(rtn)

        try:
            oldDir = pathJoin(scanPath, i.oldNum)
            newDir = pathJoin(scanPath, i.headNum)
            os.rename(oldDir, newDir)
            self.imgHeadDao.updateImgHeadNum(i.headId, i.headNum)
            rtn = common.buildSuccess(u"修改编号成功");
        except:
            traceback.print_exc()
            rtn = common.buildFail(_(u"修改编号失败"))
        return json.dumps(rtn)

    def GET(self):
        i = web.input()
        headId = i.get("headId")
        head = self.imgHeadDao.getById(headId)
        lines = self.imgLineDao.findByHeadId2(headId)
        # headJson = json.dumps(head)
        # linesJson = json.dumps(lines)
        if head:
            return render.modules.delivery.edit(head, lines)
        else:
            return render.modules.delivery.scan()

    def POST(self):
        i = web.input()
        method = i.get("method")
        if ("getImages" == method):
            return self.getImages()
        if ("editNum" == method):
            return self.editNum()
        if ("submit" == method):
            return self.submit()
        if ("cancel" == method):
            return self.cancel()

        pass


if __name__ == '__main__':
    pass
