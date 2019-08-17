# coding:utf-8

from libs import web

from controllers.controller import render, initSession
from config.config import scanPath
import time
import random
import shutil
import copy
from tool import pathJoin
from model import httpU2
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
from model.huageSerial import HuageSerial
import os
import traceback
from scanService import uploadFile
import scanService
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


class Welcome:
    def __init__(self):
        pass

    def GET(self):
        return render.modules.delivery.welcome()

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
    evsInterface = GhEvsInterface()
    def __init__(self):
        pass

    def initMachine(self):
        configDict = config.getConfigDict()
        serial_port = configDict.get(configkey.SERIAL_PORT)
        serial_baudrate = int(configDict.get(configkey.SERIAL_BAUDRATE))
        mds = HuageSerial(port=serial_port, baudrate=int(serial_baudrate))
        rtn = mds.initMachine()
        return json.dumps(rtn)

    def backPaper(self):
        configDict = config.getConfigDict()
        serial_port = configDict.get(configkey.SERIAL_PORT)
        serial_baudrate = configDict.get(configkey.SERIAL_BAUDRATE)
        mds = HuageSerial(port=serial_port, baudrate=int(serial_baudrate))
        rtn = mds.backPaper()
        return json.dumps(rtn)
    def taskQuery(self,headNum):
        session = web.config._session
        pageNum = 1
        pageInfo = {
            "pageNum": pageNum,
            "pageSize": constants.pageSize
        }

        userForm = scanService.getUserFormByApp(session.currentApp)
        userForm[session.currentApp.get("groupFieldName")] = headNum
        jsonParam = {
            "appCode": session.currentApp.get("appCode"),
            "form": userForm
        }
        belong = belongType.APPRAISE_TASK
        ret = self.evsInterface.GetServCmdInfo(session.ticket, taskType.BACKTASK, json.dumps(pageInfo),json.dumps(jsonParam))
        print u"评价任务查询结果--->",ret
        if len(ret.get("data").get("data"))<1:
            print(u"开始查询无任务")
            ret = self.evsInterface.GetServCmdInfo(session.ticket, taskType.NOTASK, json.dumps(pageInfo),json.dumps(jsonParam))
            belong = belongType.NO_TASK
            print u"无任务查询结果--->",ret
        tasks = ret.get("data").get("data")

        if len(tasks) > 0:
            for task in tasks:
                task['belong'] =belong
        return ret.get("data")
    def downloadTasks(self,tasks):
        import loginService
        session = web.config._session
        userNum = session.user.get("userNum")
        groupName = scanService.getGroupNameByApp(session.currentApp)
        print "----tasks--------->",tasks
        for task in tasks:
            imgHeadList = []
            headNum = task.get("form").get(groupName)
            belong = task.get("belong")
            # 查询是否存在，如果存在,且非WAIT状态的评价任务：删除本地存在的此任务及图片;是WAIT状态的评价任务，跳过
            destPath = pathJoin(scanPath, headNum)
            cond = {
                "userNum": userNum,
                "headNum": headNum
            }
            dbImgHead = self.imgHeadDao.getByCond(cond)
            if dbImgHead:
                if dbImgHead.get("status") == headStatus.WAIT:
                    continue
                # 删除头和行   删除本地图片
                self.imgHeadDao.deleteByHeadId(dbImgHead.get("headId"))
                if not os.path.isdir(destPath):
                    shutil.rmtree(destPath)
            if not os.path.isdir(destPath):
                os.makedirs(destPath)
            # 下载ftp图片到临时目录,下载失败，就跳过
            fileNames = []
            dirPath = pathJoin(scanPath, "downloadTemp", headNum)
            # 清空文件夹
            if os.path.isdir(dirPath):
                shutil.rmtree(dirPath)
            os.makedirs(dirPath)
            remoteFiles = task.get("imageList")
            if remoteFiles:
                index = 0
                downloadRtn = None
                isSuccess = True
                for url in remoteFiles:
                    index = index + 1
                    fileName = str(index) + ".jpg"
                    fileNames.append(fileName)
                    downloadRtn = httpU2.download(url, pathJoin(dirPath, fileName))
                    if not downloadRtn or constants.CODE_SUCCESS != downloadRtn.get("code"):
                        isSuccess = False
                        break
                if not isSuccess:
                    print >> sys.stderr, _("任务编号："), headNum, _("下载失败")
                    continue
            # 把下载的文件从临时目录移到目标目录
            filelist = os.listdir(dirPath)
            for f in filelist:
                filePath = pathJoin(dirPath, f)
                path = pathJoin(destPath, f)
                if os.path.isfile(path):
                    os.remove(path)
                shutil.move(filePath, destPath)
                loginService.generateSmallImg(path)
            if os.path.isdir(dirPath):
                shutil.rmtree(dirPath, True)
                # 添加主表信息
            cond = {
                "userNum": userNum,
                "belong": belong
            }
            headOrd = self.imgHeadDao.getMaxOrd(cond)
            userForm = session.currentApp.get("form")
            loginService.setUserFormByDict(userForm, task.get("form"))
            remark = ""
            if task.get('remark', ""):
                remark = task.get('remark', "").decode("utf-8")
            imgHead = {
                "headNum": headNum,
                "belong": belong,
                "status": headStatus.WAIT,
                "remark": remark,
                "userNum": userNum,
                "appCode": task.get("appCode"),
                "headStatus": task.get("status"),
                "userForm": json.dumps(userForm),
                "headOrd": headOrd
            }
            # 添加行表信息
            editAble, deleteAble = loginService.getLineStatusByHeadStatus(task.get("status"))
            lineList = []
            for fileName in fileNames:
                imgNameS = os.path.basename(fileName)
                filePath = pathJoin(destPath, imgNameS)
                imgLine = {
                    "headNum": headNum,
                    "imgType": imgType.ADDED,
                    "imgNameS": imgNameS,
                    "imgNameP": imgNameS,
                    "imgSize": os.path.getsize(filePath),
                    "isChecked": "0",
                    "editAble": editAble,
                    "deleteAble": deleteAble,
                    "userNum": userNum,
                }
                lineList.append(imgLine)
            imgHead["imgLines"] = lineList
            imgHeadList.append(imgHead)
            # 插入信息
            self.imgHeadDao.saveAll(imgHeadList)
    def queryAndDownload(self,headNum):
        try:
            rtn = self.taskQuery(headNum)
            if rtn:
                tasks = rtn.get("data")
                if tasks and len(tasks)>0:
                    # 通过 headNum查询， 只能是一条数据，多余的不要
                    self.downloadTasks([tasks[0]])
        except ValueError, e:
            print e.message
            return json.dumps(common.buildFail(u"查询服务器出错:"))
    def searchByHeadNum(self,headNum):
        lines = self.imgLineDao.getByHeadNum(headNum)
        for line in lines:
            line['imgPathS'] = pathJoin("/static/images/scan", headNum, "s_" + line.get("imgNameP")) + "?r=" + str(random.random())
            line['imgPathO'] = pathJoin("/static/images/scan", headNum, line.get("imgNameP")) + "?r=" + str(random.random())
            fullName = line.get("imgNameS").split(".")
            line['imgName'] = fullName[0]
            line['imgExt'] = fullName[1]
        return json.dumps(common.buildSuccess(data=lines))
    def GET(self):
        return render.modules.delivery.scan()

    def POST(self):
        i = web.input()
        method = i.get("method")
        if ("initMachine" == method):
            return self.initMachine()
        if ("backPaper" == method):
            return self.backPaper()
        if ("searchByHeadNum" == method):
            i = web.input()
            headNum = i.get("headNum")
            if headNum:
                headNum = headNum.strip()
            # 单机测试
            #先查询接口数据
            try:
                self.queryAndDownload(headNum)
            except BaseException,e:
                print e.message
                return json.dumps(common.buildFail(u"查询服务器出错:"))
            return self.searchByHeadNum(headNum)

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
        print u"------------------------start to upload---------------------------------------------"
        # u = uploadFile()
        i = web.input()
        # belong = getBelong(i.belong)
        headId = json.loads(i.headId)
        session = web.config._session
        userNum = session.user.get("userNum")
        print u"-----------------start --update database----------------------------------"
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
        print u"---------------end ----update database----------------------------------"
        uploadUrl = self.configDao.getValueByKey(configkey.HTTP_UPLOAD_URL)
        #         uploadUrl = "http://127.0.0.1:8080/upload/UploadServlet.do"
        print u"-------------------start call evs  to upload -------------------------------uploadUrl--->",uploadUrl
        head_list = []
        try:
            uploadThread = UploadThread([headId], session.ticket, uploadUrl)
            head_list = uploadThread.run()
        except:
            traceback.print_exc()
            status = headStatus.FAILURE
            errorMsg = u"上传失败"
        print u"-------------------end call evs  to upload -------------------------------"
        if len(head_list)>0:
            status = head_list[0].get("status")
            errorMsg = head_list[0].get("errorMsg")
        else:
            status = headStatus.FAILURE
            errorMsg = u"调用服务器，上传失败"
        print u"-------------------------------end to upload----------------------------"
        return status, errorMsg

    def submit(self):
        # 单机测试
        # status = headStatus.SUCCESS
        # errorMsg = u"测试"
        status, errorMsg = self.upload()
        if headStatus.FAILURE == status:
            print("=========== 上传失败 ===========")
            return json.dumps(common.buildFail(errorMsg))
        configDict = config.getConfigDict()
        serial_port = configDict.get(configkey.SERIAL_PORT)
        serial_baudrate = configDict.get(configkey.SERIAL_BAUDRATE)
        mds = HuageSerial(port=serial_port, baudrate=int(serial_baudrate))
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

    def backPaper(self):
        # 通知电机退票
        configDict = config.getConfigDict()
        serial_port = configDict.get(configkey.SERIAL_PORT)
        serial_baudrate = configDict.get(configkey.SERIAL_BAUDRATE)
        mds = HuageSerial(port=serial_port, baudrate=int(serial_baudrate))
        rtn = mds.backPaper()
        # rtn = common.buildSuccess()
        if rtn["isSuccess"]:
            # 删除任务
            i = web.input()
            head_id = i.get("headId")
            rtn = self.deleteTaskByHeadId(head_id)
        else:
            rtn = json.dumps(rtn)
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
        if ("backPaper" == method):
            return self.backPaper()

        pass

class Test:
    def __init__(self):
        pass

    def GET(self):
        return render.modules.delivery.test()

    def POST(self):
        from model.huageSerial import HuageSerial
        mds = HuageSerial(port="COM1")
        i = web.input()
        method = i.get("method")
        if method == "initMachine":
            # ========================初始化====================
            rtn = mds.initMachine()
            return json.dumps(rtn)
        elif method == "recyclePaper":
            # ========================回收====================
            rtn = mds.recyclePaper()
            return json.dumps(rtn)
        elif method == "backPaper":
            # ========================退件====================
            rtn = mds.backPaper()
            return json.dumps(rtn)
if __name__ == '__main__':
    pass
