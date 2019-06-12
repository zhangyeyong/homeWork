# coding:utf-8

from libs import web

from controllers.controller import render, initSession
from config.config import scanPath
import time
import copy
from tool import pathJoin
from model.imgHeadDao import ImgHeadDao
from model.imgLineDao import ImgLineDao
from model.configDao import ConfigDao
from model.boxDao import BoxDao
from model.uploadTaskDao import UploadTaskDao
from model.uploadTaskLogDao import UploadTaskLogDao
from model.ocrResultDao import OcrResultDao
from model.interface import GhEvsInterface
from config.constants import taskStatus, headStatus, ftpStatus, configkey
from config.config import rootPath, scanPath, imgWidth, rootPathCmd
from model.ftpU4 import MyFTP
from i18n.i18nU import _
import config.constants as constants
from model.serialU import ComU
from config.config import scanPath
from config import config
from config.constants import *
import json
import os
import sys
from model import common
from model.meidingSerial import MeidingSerial
# from model.meidingSerial_for_test import MeidingSerial
import os
import traceback
from scanService import uploadFile
from model.uploadThreadByHttp import UploadThread


def sendDataBySerial(data):
    configDict = config.getConfigDict()
    SERIAL_PORT = configDict.get(configkey.SERIAL_PORT)
    SERIAL_BAUDRATE = configDict.get(configkey.SERIAL_BAUDRATE)
    comU = ComU(SERIAL_PORT, SERIAL_BAUDRATE)
    rtn = comU.sendAndWaitRecvDate(data)
    comU.closeCom()
    return rtn


def getBelong(belong):
    if belong == "dailyScanM":
        return belongType.DAILY_SCAN
    elif belong == "appraiseTaskM":
        return belongType.APPRAISE_TASK
    else:
        return belongType.NO_TASK


def setUserFormValue(userForm, name, value):
    for f in userForm:
        if f.get("name") == name:
            f["value"] = value
    return userForm


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
    imgHeadDao = ImgHeadDao()
    imgLineDao = ImgLineDao()
    configDao = ConfigDao()

    def __init__(self):
        pass

    def initMachine(self):
        configDict = config.getConfigDict()
        serial_port = configDict.get(configkey.SERIAL_PORT)
        serial_baudrate = int(configDict.get(configkey.SERIAL_BAUDRATE))
        mds = MeidingSerial(port=serial_port, baudrate=int(serial_baudrate))
        rtn = mds.initMachine()
        return json.dumps(rtn)

    def backPaper(self):
        configDict = config.getConfigDict()
        serial_port = configDict.get(configkey.SERIAL_PORT)
        serial_baudrate = configDict.get(configkey.SERIAL_BAUDRATE)
        mds = MeidingSerial(port=serial_port, baudrate=int(serial_baudrate))
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
        if ("doScan" == method):
            return self.backPaper()


class Refund:
    boxDao = BoxDao()

    def __init__(self):
        pass

    def openBox(self, boxNum):
        configDict = config.getConfigDict()
        serial_port = configDict.get(configkey.SERIAL_PORT)
        serial_baudrate = int(configDict.get(configkey.SERIAL_BAUDRATE))
        mds = MeidingSerial(port=serial_port, baudrate=int(serial_baudrate))
        rtn = mds.openBox(boxNum)
        return json.dumps(rtn)

    def findAll(self):
        boxs = self.boxDao.findAll()
        configDict = config.getConfigDict()
        serial_port = configDict.get(configkey.SERIAL_PORT)
        serial_baudrate = int(configDict.get(configkey.SERIAL_BAUDRATE))
        mds = MeidingSerial(port=serial_port, baudrate=int(serial_baudrate))
        rtn = mds.queryBoxSatus()
        print rtn
        for tmp in rtn.get("data"):
            for box in boxs:
                if int(box.get("boxNum")) == int(tmp.get("boxNum")):
                    box["enable"] = tmp.get("enable")
                    box["status"] = tmp.get("status")
                    break;
        print boxs
        return common.buildSuccess(data=boxs)

    def GET(self):
        return render.modules.delivery.refund(self.findAll())

    def POST(self):
        i = web.input()
        method = i.get("method")
        if ("openBox" == method):
            return self.openBox(int(i.get("boxNum")))


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
        configDict = config.getConfigDict()
        serial_port = configDict.get(configkey.SERIAL_PORT)
        serial_baudrate = configDict.get(configkey.SERIAL_BAUDRATE)
        mds = MeidingSerial(port=serial_port, baudrate=int(serial_baudrate))
        rtn = mds.openBox(box.get("boxNum"))
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
    configDao = ConfigDao()

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

    def upload(self):
        u = uploadFile()
        i = web.input()
        # belong = getBelong(i.belong)
        headId = json.loads(i.headId)
        session = web.config._session
        userNum = session.user.get("userNum")
        self.imgHeadDao.update(
            {"headId": headId, "status": headStatus.UPLOADING, "uploadTime": time.strftime('%Y-%m-%d %H:%M:%S')})
        uploadTask = {
            "headId": headId,
            "status": taskStatus.WAITING,
            "userNum": userNum,
            "taskType": taskType.NOW
        }
        self.uploadTaskDao.deleteByHeadId(headId)
        self.uploadTaskDao.save(uploadTask)
        uploadUrl = self.configDao.getValueByKey(configkey.HTTP_UPLOAD_URL)
        #         uploadUrl = "http://127.0.0.1:8080/upload/UploadServlet.do"
        uploadThread = UploadThread([headId], session.ticket, uploadUrl)
        head_list = uploadThread.run()
        status = head_list[0].get("status")
        errorMsg = head_list[0].get("errorMsg")
        return status, errorMsg

    def submit(self):
        status, errorMsg = self.upload()
        if headStatus.FAILURE == status:
            print("=========== 上传失败 ===========")
            return json.dumps(common.buildFail(errorMsg))
        configDict = config.getConfigDict()
        serial_port = configDict.get(configkey.SERIAL_PORT)
        serial_baudrate = configDict.get(configkey.SERIAL_BAUDRATE)
        mds = MeidingSerial(port=serial_port, baudrate=int(serial_baudrate))
        # =====================压痕======================================
        rtn = mds.fixPaper()
        if not rtn["isSuccess"]:
            return json.dumps(rtn)
        #等待压痕完成
        time.sleep(2)
        # ======================回收======================================
        rtn = mds.recyclePaper()
        if  rtn["isSuccess"]:
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
        configDict = config.getConfigDict()
        serial_port = configDict.get(configkey.SERIAL_PORT)
        serial_baudrate = configDict.get(configkey.SERIAL_BAUDRATE)
        mds = MeidingSerial(port=serial_port, baudrate=int(serial_baudrate))
        rtn = mds.backPaper()
        # rtn = common.buildSuccess()
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
