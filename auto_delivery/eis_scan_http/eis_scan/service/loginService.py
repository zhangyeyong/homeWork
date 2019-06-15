# coding:utf-8
import os
import sys
from libs import web
import hashlib
from suds.client import Client 
from controllers.controller import render, initSession
from model.configDao import ConfigDao
from config import constants
from config.constants import configkey, belongType, headStatus, imgType, headStatus2
from config.config import scanPath, imgWidth
from model import common, httpU2
import json
import shutil
import traceback
from model import interface
from model.interface import GhEvsInterface
from model.timer import EisTimer
from model.imgHeadDao import ImgHeadDao
from model.ocrResultDao import OcrResultDao
from tool import pathJoin
from libs.ocr import cv2
from i18n.i18nU import _ 
from config.constants import tickerDict,taskType
import numpy as np

# 定时任务：获取评价任务
servCmdInfoTimer = None
def startServCmdInfoTimer():
    session = web.config._session
    imgHeadDao = ImgHeadDao()
    evsInterface = GhEvsInterface()
    ticket = session.get('ticket')
    userNum = session.user.get("userNum")
    ocrResultDao = OcrResultDao()
    servCmdInfoTimer = EisTimer(getAppraiseTask, (ticket, userNum, imgHeadDao, ocrResultDao, evsInterface))
    servCmdInfoTimer.start()
    print u"评价任务定时器 启动~_~!"
    return True
def formatWidthAndHeight(h, w):
    currentApp = web.config._session.currentApp
    iconDict = currentApp.get("icon",{"width":0,"high":0})
    ih = int(iconDict.get("height",0))
    iw = int(iconDict.get("width",0))  
    height = ih
    width = iw
    if iw==0 and ih==0:
        width = imgWidth
        height = int(imgWidth * 1.0 / w * h)
        if h > w:
            height = 90
            width = int(height * 1.0 / h * w)
    elif iw==0:
        width =  int(ih * 1.0 / h * w)
    elif ih==0:
        height = int(iw * 1.0 / w * h)
    else:
        height = ih
        width = iw
    return height,width
def initUserForm(userForm):
    for f in userForm:
        #初始化select
        if f.get("type") == "select":
            for item in f.get("items"):
                if f.get("value")==item.get("value"):
                    f["value_label"] = item.get("label")
         
    
def generateSmallImg(fileName, filePath=None):
    if not os.path.exists(fileName):
        return
    img = cv2.imread(fileName, -1)
    if not isinstance(img,np.ndarray):
        return
    h, w = img.shape[:2]
    height,width =formatWidthAndHeight(h, w)
    if filePath == None:
        name = os.path.basename(fileName)
        dirPath = os.path.dirname(fileName)
        filePath = pathJoin(dirPath, "s_" + name)
    cv2.imwrite(filePath.encode(sys.getfilesystemencoding()), cv2.resize(img, (width, height)))
def parseToList(result):    
    if not result:
        return []
    obj_list = []
    for taskStr in result.split("];["):
        # [6][test1704][test1704][10.18.221.10][2][][评价类型：影像不清晰 评价描述：测试  影像不清晰][10021][/images/2014/10/test1704][10040][Y][003][02]
        # 0     1        2            3         4  5      6                                      7        8                         9    10 11   12
        # [任务类型][影像文件编号][FTP的IP][影像文件张数][图像批注][任务说明][影像文件对应FTPID] [单据FTP相对根目录的路径][评价任务ID][评价任务状态][结算公司编码][业务类型编码]
        strArray = taskStr.replace("[", "").split("]");
        obj = {}
        obj['TaskType'] = strArray[0]
        obj['Barcode'] = strArray[1]
        obj['ftpIp'] = strArray[3]
        obj["imgSize"] = strArray[4]
        obj['postil'] = strArray[5]
        obj['remark'] = strArray[6]
        obj['ftpId'] = strArray[7]
        obj['filePath'] = strArray[8]
        obj['TaskID'] = strArray[9]
        obj['taskStatus'] = strArray[10]
        obj['companyCode'] = strArray[11]
        obj['operationTypeCode'] = strArray[12]
        obj_list.append(obj)
    return obj_list
def getLineStatusByHeadStatus(headStatus):
    editAble = "1"
    deleteAble="1"
    if headStatus== headStatus2.ADD_ONLY:
        editAble = "0"
        deleteAble="0"
    return (editAble,deleteAble)
def setUserFormByDict(userForm,valDict):
    for f in userForm:
        if valDict.has_key(f.get("name")):
            value = valDict.get(f.get("name"),"not_found")
            if value!="not_found":
                f["value"] = value
                #设置下拉列表的默认值
                if f.get("type") == "select":
                    for item in f.get("items"):
                        if value==item.get("value"):
                            f["value_label"] = item.get("label")
    return userForm
def getAppraiseTask(ticket, userNum, imgHeadDao, ocrResultDao, evsInterface,session,groupName,pageInfo,jsonParam):
    print u"评价任务处理开始~_~!"
    if not ticket:
        print "ticket不存在，评价任务定时器 关闭~_~!"
        return False
    isLogin = evsInterface.IsLogin(ticket).get("data")
    # 不是登录状态， 停止定时任务
    if not isLogin:
        print u"未登录或登录 失效，评价任务定时器 关闭~_~!"
        return False
    ret = evsInterface.GetServCmdInfo(ticket,taskType.BACKTASK, pageInfo,json.dumps(jsonParam))
    result = ret.get("data")
    if result:
        tasks = result.get("data")
        for task in tasks:
            imgHeadList = []
            headNum = task.get("form").get(groupName)
            # 查询是否存在，如果存在,且非WAIT状态的评价任务：删除本地存在的此任务及图片;是WAIT状态的评价任务，跳过
            destPath = pathJoin(scanPath, headNum)
            cond = {
                "userNum":userNum,
                "headNum":headNum
                }
            dbImgHead = imgHeadDao.getByCond(cond)
            if dbImgHead:
                if dbImgHead.get("belong") == belongType.APPRAISE_TASK and dbImgHead.get("status") == headStatus.WAIT:
                    continue
                imgNames = imgHeadDao.deleteByHeadId(dbImgHead.get("headId"))
                for imgname in imgNames:
                    path = pathJoin(destPath, imgname)
                    if os.path.isfile(path):
                        os.remove(path)
            if not os.path.isdir(destPath):  
                os.makedirs(destPath)
            # 下载ftp图片到临时目录,下载失败，就跳过
            fileNames = []
            dirPath = pathJoin(scanPath, "downloadTemp", headNum)
            # 清空文件夹
            if os.path.isdir(dirPath):
                shutil.rmtree(dirPath)
            os.makedirs(dirPath)
                
            ftp = session.get("ftpMap").get(task.get('ftpId'))
            
            remoteFiles = task.get("imageList") 
            tempFiles = [] 
            if remoteFiles:
                index=0
                downloadRtn = None
                isSuccess = True
                for url in remoteFiles:
                    index = index+1
                    fileName = str(index)+".jpg"
                    fileNames.append(fileName)
                    downloadRtn = httpU2.download(url,pathJoin(dirPath, fileName))
                    if not downloadRtn or constants.CODE_SUCCESS!=downloadRtn.get("code"):
                        isSuccess = False
                        break
#                 isSuccess = ftpU.download2(ftp.get("userName"), ftp.get("password"), dirPath, remoteFiles, ftp.get("ftpIp"), ftp.get("port"))
                if not isSuccess:
                    print _(u"任务编号："), headNum, _(u"下载失败")
                    continue
            # 把下载的文件从临时目录移到目标目录
            filelist = os.listdir(dirPath)
            for f in filelist:  
                filePath = pathJoin(dirPath, f)  
                path = pathJoin(destPath, f)
                if os.path.isfile(path):
                    os.remove(path)
                shutil.move(filePath, destPath) 
                generateSmallImg(path)
            if os.path.isdir(dirPath):
                shutil.rmtree(dirPath, True)  
            # 添加主表信息 
            cond = {
                "userNum":userNum,
                "belong":belongType.APPRAISE_TASK
                }
            headOrd = imgHeadDao.getMaxOrd(cond)
            userForm = session.currentApp.get("form")
            setUserFormByDict(userForm, task.get("form"))
            imgHead = {
               "headNum":headNum,
               "belong":belongType.APPRAISE_TASK,
               "status": headStatus.WAIT,
               "remark":task.get('remark',"").decode("utf-8"),
               "userNum":userNum,
               "appCode":task.get("appCode"),
               "headStatus":task.get("status"),
               "userForm":json.dumps(userForm),
               "headOrd":headOrd
            }
            # 添加行表信息 
            editAble,deleteAble = getLineStatusByHeadStatus(task.get("status"))
            lineList = []
            for fileName in fileNames:
                imgNameS = os.path.basename(fileName)
                filePath = pathJoin(destPath, imgNameS)
                imgLine = {
                           "headNum":headNum,
                           "imgType":imgType.ADDED,
                           "imgNameS":imgNameS,
                           "imgNameP":imgNameS,
                           "imgSize":os.path.getsize(filePath),
                           "isChecked":"0",
                           "editAble":editAble,
                           "deleteAble":deleteAble,
                           "userNum":userNum,
                           }
                lineList.append(imgLine)
            imgHead["imgLines"] = lineList
            imgHeadList.append(imgHead)
            # 插入信息
            imgHeadDao.saveAll(imgHeadList)
    print u"评价任务处理结束~_~!"
    return True

class logout:
    evsInterface = GhEvsInterface() 
    def GET(self):
        session = web.config._session
        if session and hasattr(session, "user") and hasattr(session.user, "userNum"): 
            tickerDict[session.user.get("userNum")] = None
        lang = session.get('lang',"zh_CN")
        if hasattr(session, "ticket") and session.ticket:
            self.evsInterface.Logout(session.ticket)
        web.config._session.kill()
        
        return web.seeother("/login?lang=" + lang)
class login:
    configDao = ConfigDao()
    evsInterface = GhEvsInterface()
    def netSet(self, params):
        print params
        configs = {}
        configs[configkey.EIS_IP] = params.get(configkey.EIS_IP) 
        configs[configkey.EIS_PORT] = params.get(configkey.EIS_PORT) 
        configs[configkey.VIRTUAL_PATH] = params.get(configkey.VIRTUAL_PATH) 
        
        rtn = common.buildFail(_(u"保存失败"))
        try:
            self.configDao.save(configs)
            rtn = common.buildSuccess()
        except Exception:
            traceback.print_exc()  
        return rtn
    def testNetSet(self, params):
        serverUrl = "http://" + params.get(configkey.EIS_IP)
        if params.get(configkey.EIS_PORT) and params.get(configkey.EIS_PORT).strip() != "":
            serverUrl = serverUrl + ":" + params.get(configkey.EIS_PORT)
            
        serverUrl = serverUrl + params.get(configkey.VIRTUAL_PATH)
        if not serverUrl.upper().endswith("?WSDL"):
            serverUrl+= "?wsdl"
        print serverUrl
        client = None
        try:
            client = Client(serverUrl)  # 测试服务是否启动
        except Exception:
            traceback.print_exc()  
        if not client:
            return common.buildFail(_(u"连接服务器失败"))
        return common.buildSuccess(_(u"测试成功"))
    def nologin(self,params):
        params={}
        params["userCd"]="10000"
        params["password"]="zte@1234"
        return self.login(params)
    def login(self, params):
        userCd = params.get("userCd")
        password = params.get("password")
        configDict = self.configDao.findAllAsDict()
        ip = configDict.get(configkey.EIS_IP)
        virtual_path = configDict.get(configkey.VIRTUAL_PATH)
        if not ip or ip.strip() == "" or not virtual_path or virtual_path.strip() == "":
            return common.buildFail(u"网络配置不正确")
#         #检查服务器的连通性
#         rtn = self.evsInterface.checkServer()
#         if not rtn.get("isSuccess"):
#             return rtn;
        ticket = None
        session = web.config._session
        if session and  hasattr(session, "ticket"):
            ticket = session.ticket
        # 判断是否登录
        if ticket:
            isLogin = self.evsInterface.IsLogin(ticket).get("data")
            if isLogin:
                self.evsInterface.Logout(ticket)
        # 判断是否登录
        ticket = web.cookies().get('ticket')
        if ticket:
            isLogin = self.evsInterface.IsLogin(ticket).get("data")
            if isLogin:
                self.evsInterface.Logout(ticket)
        ticket = tickerDict.get(userCd)
        if ticket:
            isLogin = self.evsInterface.IsLogin(ticket).get("data")
            if isLogin:
                self.evsInterface.Logout(ticket)
        print hashlib.md5(password).hexdigest().upper()        
        rtn = self.evsInterface.Login(userCd, hashlib.md5(password).hexdigest().upper(),session.get("lang"))
        if not rtn.get("isSuccess"):
            return rtn
        else:
            result = rtn.get("data")
        initSession()
        if not result:
            return common.buildFail(_(u"登录失败，请确认配置是否正确"))
        if result.get("code")==interface.CODE_SUCCESS:
            
            # 校验通过
            # 将登录信息写入到session
            session.user = {"userNum":userCd}
            print "-----------------result.ticket:" + result.get("ticket")
            session.ticket = result.get("ticket")
            session.icon = result.get("icon")
            
            session.appList=result.get("appList")
            session.scanConfig = result.get("scanConfig")
            session.ftpMap= result.get("ftpMap")
            session.uploadTime= result.get("uploadTime")
            
            session.currentApp = session.appList[0]
            currentApp = None
            lastAppCode = configDict.get("appCode")
            if lastAppCode:
                for app in session.appList:
                    if app.get("appCode")==lastAppCode:
                        currentApp = app
                        break
            if not currentApp:
                currentApp = session.appList[0]
            session.currentApp = currentApp
            #初始化
            userFormJson = configDict.get(session.currentApp.get("appCode")+"_forms")
            userForm = session.currentApp.get("form")
            if userFormJson:
                userform_db = json.loads(userFormJson)            
                for f in userForm: 
                    value = userform_db.get(f.get("name"))
                    if value:
                        f["value"] = value
            initUserForm(userForm)
            web.setcookie('ticket', result.get("ticket"))  # 单位是秒  半小时失效
            web.setcookie('userCd',userCd,90*24*3600)  # 单位是秒  半小时失效
            tickerDict[userCd] = result.get("ticket")
            # 登录成功 开启获取评价任务定时器
#             startServCmdInfoTimer()
#             self.reUpload()
            return common.buildSuccess(_(u"登录成功"))
    def reUpload(self):
        from scanService import uploadFile
        from model.uploadTaskDao import UploadTaskDao 
        u = uploadFile()
        uploadTaskDao = UploadTaskDao()
        headIds = uploadTaskDao.findTodoTask()
        if headIds and len(headIds) > 0:
            session = web.config._session
            configDict = self.configDao.findAllAsDict()
            userNum = session.user.get("userNum")
            companyCode = configDict.get(configkey.COMPANY_CODE + userNum)
            ftpId = configDict.get(configkey.SITE_ID + userNum)
            operationCode = configDict.get(configkey.OPERATION_TYPE_CODE + userNum)
            u.doUpload(headIds, session.ticket, userNum, ftpId, companyCode, operationCode, session.get("lang"))
    def GET(self):
        i = web.input()
        lang = i.get('lang')
        if not lang:
            lang = web.config._session.get('lang')
            lang = lang if lang else 'zh_CN'
        elif lang not in ['zh_CN', 'en_US']:
            lang = 'zh_CN'
        # Debug.
        print  'Language:', lang

        web.config._session['lang'] = lang
        from config import config
        web.config._session['appName'] = config.appName
        return render.modules.login(self.configDao.findAllAsDict(), web.cookies().get("userCd") or '')
    def POST(self):
        d = web.input()
        if d.type == "netSet":
            return json.dumps(self.netSet(d))
        elif d.type == "testNetSet":
            return json.dumps(self.testNetSet(d))
        elif d.type == "nologin":
            return json.dumps(self.nologin(d))
        elif d.type == "login":
            return json.dumps(self.login(d))
        elif d.type == "isLogin":
            session = web.config._session
            pathname = d.get("pathname")
            if session.get("user") is None and pathname != "/login":
                return False
            else:
                return True
        
        return web.seeother("/scan")

if __name__ == '__main__':
    fileName = "D:/work/scan_new/eis_scan/static/images/scan/B0002/1.jpg"
    fileName = "D:/3.jpg"
#     generateSmallImg(fileName)
    print hashlib.md5("9527").hexdigest().lower()
    pass
