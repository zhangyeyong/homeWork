# coding:utf-8
import os
import sys
import time
import json
import copy
import random
import shutil
import re
from tool import pathJoin  
from libs import web
from controllers.controller import render, pureRender
from model.imgHeadDao import ImgHeadDao
from model.imgLineDao import ImgLineDao
from model.configDao import ConfigDao
from model.uploadTaskDao import UploadTaskDao
from model.uploadTaskLogDao import UploadTaskLogDao
from model.ocrResultDao import OcrResultDao
from model import imgRotate
from config.config import rootPath, scanPath, imgWidth, rootPathCmd
from config import  config
from config.constants import *
from model.uploadThread2 import UploadThread 
from model.interface import GhEvsInterface
from model.invoiceService import initial_params
from model import common, ftpU
from libs.ocr import cv2
from i18n.i18nU import _
from config import constants


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
class scan:
    def GET(self):
        return render.modules.scan()
    def POST(self):
        i = web.input()
        belong = getBelong(i.belong)
        return renderScan2(belong)
    
def renderScan2(belong):
    imgHeadDao = ImgHeadDao()
    session = web.config._session
    cond = {
            "userNum":session.user.get("userNum"),
            "appCode":session.currentApp.get("appCode"),
            "belong":belong
            }
    imgHeads = imgHeadDao.findByCond(cond)
    return pureRender.modules.scan2(imgHeads)

class dailyScan:
    imgHeadDao = ImgHeadDao()
    imgLineDao = ImgLineDao()
    configDao = ConfigDao()
    def makedirs(self, headNum):
        originalPath2 = pathJoin(scanPath, headNum)
        if not os.path.isdir(originalPath2):
            os.makedirs(originalPath2)
        sFilePath = pathJoin(scanPath, headNum)
        if not os.path.isdir(sFilePath):
            os.makedirs(sFilePath)
    def detectBlackPage(self, filename, pixerRatio, blackBorderWidth=10, threshold=230):
        img = cv2.imread(filename, 0)
        h, w = img.shape[:2]
        img = img[blackBorderWidth:h - blackBorderWidth, blackBorderWidth:w - blackBorderWidth]
        retval , img = cv2.threshold(img, threshold, 255, cv2.THRESH_BINARY_INV)
        contours, hierarchy = cv2.findContours(img, cv2.RETR_LIST, cv2.CHAIN_APPROX_SIMPLE)  
        areaSum = 0
        for cnt in contours:
            epsilon = cv2.arcLength(cnt, True)
            approx = cv2.approxPolyDP(cnt, 0.01 * epsilon, True)
            areaSum += cv2.contourArea(approx)
        isBlank = areaSum * 100.0 / (h * w) < float(pixerRatio)
        print "非空白率：----------------------------", areaSum * 100.0 / (h * w)
        return isBlank
    def readBarCode(self, fileName, regexStr):
#         img = cv2.imread(fileName,0)
#         h,w =img.shape[:2]
#         imgNew = img[h/5:h/3,w/4:3*w/4]
#         cv2.imwrite("temp.jpg",imgNew)
        path = pathJoin(rootPathCmd, "libs/zbar/zbarimg")
        cmd = path + " -D \"" + fileName + "\""
        output = os.popen(cmd.encode(sys.getfilesystemencoding()))
        barcode = output.read()
        if barcode:
            if not regexStr:
                return barcode.split("\n")[0].split(":")[1]
            else:
                matchObj = re.compile(str(regexStr))
                for ll in barcode.split("\n"):
                    if ll.find(":") != -1:
                        ret = ll.split(":")[1]
                        m = matchObj.match(ret)
                        if m :
                            return ret
        return None 
    def getGroupInfo(self, app):
        groupInfo = {}
        userform = app.get("form")
        for f in userform:
            if f.get("groupBy") and str(f.get("groupBy")) == "1":
                groupInfo["groupBy"] = f.get("name")
                groupInfo["value"] = f.get("value")
                groupInfo["autoOcr"] = f.get("autoOcr").upper() if f.get("autoOcr", "") else ""
        return groupInfo 
    def addimg(self, belong, appCode, headNum, imges, userForm):
        retDict = {"isSuccess":True}
#         #i = web.input()
#         data = json.loads(i.data)
        session = web.config._session
        userNum = session.user.get("userNum")
        imgHead = self.imgHeadDao.getByHeadNum(headNum)
        if not imgHead:
            imgHead = {
               "headNum": headNum,
               "appCode": appCode,
               "status": headStatus.WAIT,
               "headStatus": headStatus2.NORMAL,
               "belong":belong,
               "userNum": userNum,
               "imgQty":0
            }
            self.makedirs(imgHead.get('headNum'))
        imgHead["userForm"] = userForm
        # 新增扫描的图片
        WaterCode = 0
        imgLineList = []
        for image in imges:
            path = image.get("path")
            if path and not os.path.isfile(path):
                continue
            fileNameS = os.path.basename(path)
            WaterCode += 1
            WaterCodeStr = str(WaterCode)
            if len(WaterCodeStr) < 3:
                for i in range(3 - len(WaterCodeStr)):
                    WaterCodeStr = "0" + WaterCodeStr
            fileNameP = userNum + "_" + time.strftime('%Y%m%d%H%M%S') + WaterCodeStr + "." + fileNameS.split(".")[-1]
            originalPath = pathJoin(scanPath, imgHead.get('headNum'), fileNameP)
            smallPath = pathJoin(scanPath, imgHead.get('headNum'), "s_" + fileNameP)
            img = cv2.imread(path, -1)
            h, w = img.shape[:2]
            width = imgWidth
            height = int(imgWidth * 1.0 / w * h)
            if h > w:
                height = 90
                width = int(height * 1.0 / h * w)
            cv2.imwrite(originalPath.encode(sys.getfilesystemencoding()), img)
#             shutil.move(path, originalPath.encode(sys.getfilesystemencoding())) 
            cv2.imwrite(smallPath.encode(sys.getfilesystemencoding()), cv2.resize(img, (width, height)))
            imgLine = {
                       "headNum":imgHead.get('headNum'),
                       "imgType":imgType.ADDED,
                       "imgNameS":fileNameS,
                       "imgNameP":fileNameP,
                       "scanTime":time.strftime('%Y-%m-%d %H:%M:%S'),
                       "imgSize":os.path.getsize(originalPath.encode(sys.getfilesystemencoding())),
                       "isChecked":"0",
                       "editAble":"1",
                       "deleteAble":"1",
                       "userNum":userNum,
                       }
            imgLineList.append(imgLine)
        imgHead["imgLines"] = imgLineList
        self.imgHeadDao.saveHeadAndLine(imgHead)
        return True

    def POST(self):
        session = web.config._session
        i = web.input()
        data = json.loads(i.data)
        retDict = {"isSuccess":True}
        groupInfo = self.getGroupInfo(session.currentApp)
        # 如果无需自动分组，而需要用groupby 字段对应的值
        if "Y" != groupInfo.get("autoOcr") and groupInfo.get("value"):
            self.addimg(belongType.DAILY_SCAN, session.currentApp.get("appCode"), groupInfo.get("value"), data, json.dumps(session.currentApp.get("form")))
            retDict["info"] = renderScan2(belongType.DAILY_SCAN)
            return json.dumps(retDict)
        
        userNum = session.user.get("userNum")
        cond = {
                "userNum":userNum,
                "appCode":session.currentApp.get("appCode"),
                "belong":belongType.DAILY_SCAN
                }
        headOrd = self.imgHeadDao.getMaxOrd(cond)
        dbHeads = self.imgHeadDao.findByCond(cond)
        dbHeadDict = {}
        for dbHead in dbHeads:
            dbHeadDict[dbHead.headNum] = dbHead
        userForm = session.currentApp.get("form")
        imgHead = {
               "status": headStatus.WAIT,
               "belong":belongType.DAILY_SCAN,
               "headStatus": headStatus2.NORMAL,
               "userNum": userNum,
               "imgQty":0
            }
        curImgHead = None
        imgHeadList = []
        # 1、检查是否是资料类型，是：创建目录，不保存图片；不是：保存进当前资料类型中
        WaterCode = 0
        t1 = time.time()
        so = 0
        k = 0
        configDict = config.getConfigDict()
        regexStr = configDict.get(configkey.BARCODE_RULE)
        pixer_ratio = configDict.get(configkey.PIXERRATIO)
        if not pixer_ratio:
            pixer_ratio = pixerRatio 
        headNumWaterCode = 0
        for file in data:
            path = file.get("path")
            if path and not os.path.isfile(path):
                continue
            fileNameS = os.path.basename(path)
            to1 = time.time()
            to2 = time.time()
            so = so + (to2 - to1)
            isBlack = self.detectBlackPage(path, pixer_ratio, blackBorderWidth, threshold)
            if not isBlack:
                barcode = self.readBarCode(path, regexStr)
                if barcode:  
                    # 查询是否已经存在
                    imgHeadTmp = dbHeadDict.get(barcode)
                    # 添加文件夹
                    if imgHeadTmp is None:
                        imgHeadTmp = copy.deepcopy(imgHead)
                        imgHeadTmp["headNum"] = barcode
                        headOrd += 1
                        imgHeadTmp["headOrd"] = headOrd
                    curImgHead = imgHeadTmp
                    
                    
                    userForm = setUserFormValue(userForm, groupInfo.get("groupBy"), imgHeadTmp.get("headNum"))
                    imgHeadTmp["userForm"] = json.dumps(userForm)
                    imgHeadTmp["appCode"] = session.currentApp.get("appCode")
                    
                    imgHeadList.append(imgHeadTmp)
                    self.makedirs(imgHeadTmp.get('headNum'))
                    if imgHeadTmp.get("imgPath"):
                        # 删除查询时多加的属性
                        del imgHeadTmp["imgPath"]
                    if imgHeadTmp.get("headId"):
                        # 当票据号已经存在 将不再保存此图片
                        continue
            
            if isBlack or curImgHead is None:
                curImgHead = copy.deepcopy(imgHead)
                headNumWaterCode += 1
                curImgHead["headNum"] = time.strftime('%Y%m%d%H%M%S') + str(headNumWaterCode)
                headOrd += 1
                curImgHead["headOrd"] = headOrd
                userForm = setUserFormValue(userForm, groupInfo.get("groupBy"), curImgHead.get("headNum"))
                curImgHead["userForm"] = json.dumps(userForm)
                curImgHead["appCode"] = session.currentApp.get("appCode")
                imgHeadList.append(curImgHead)
                self.makedirs(curImgHead.get('headNum'))
            if isBlack:
                # 空白页没有行记录
                print _("空白页：") + path
                continue
            # imgLine
            WaterCode += 1
            WaterCodeStr = str(WaterCode)
            if len(WaterCodeStr) < 3:
                for i in range(3 - len(WaterCodeStr)):
                    WaterCodeStr = "0" + WaterCodeStr
            fileNameP = userNum + "_" + time.strftime('%Y%m%d%H%M%S') + WaterCodeStr + "." + fileNameS.split(".")[-1]
            filePath = pathJoin(scanPath, curImgHead.get('headNum'), fileNameP)
            sFilePath = pathJoin(scanPath, curImgHead.get('headNum'), "s_" + fileNameP)
            k1 = time.time()
            img = cv2.imread(path, -1)
            h, w = img.shape[:2]
            width = imgWidth
            height = int(imgWidth * 1.0 / w * h)
            if h > w:
                height = 90
                width = int(height * 1.0 / h * w)
            cv2.imwrite(filePath.encode(sys.getfilesystemencoding()), img)
#             shutil.move(path, filePath.encode(sys.getfilesystemencoding()))   
            cv2.imwrite(sFilePath.encode(sys.getfilesystemencoding()), cv2.resize(img, (width, height)))
            k2 = time.time()
            k += k2 - k1
            imgLine = {
                       "headNum":curImgHead.get('headNum'),
                       "imgType":imgType.ADDED,
                       "imgNameS":fileNameS,
                       "imgNameP":fileNameP,
                       "scanTime":time.strftime('%Y-%m-%d %H:%M:%S'),
                       "imgSize":os.path.getsize(filePath.encode(sys.getfilesystemencoding())),
                       "isChecked":"0",
                       "editAble":"1",
                       "deleteAble":"1",
                       "userNum":userNum,
                       }
            if curImgHead.get("imgLines") is None:
                curImgHead["imgLines"] = []
            curImgHead["imgLines"].append(imgLine)
            
        t2 = time.time()
        print " 保存图片：%d" % k
        print " barcode 识别：%d" % so
        print " 处理图片：%d" % (t2 - t1)
        # 2、更新头表，插入行表
        allLines = self.imgHeadDao.saveAll(imgHeadList) 
        # 3、识别发票，插入信息
#         ocrThread = OcrThread(allLines)
#         ocrThread.start() 
        t3 = time.time()
        print " 保存数据：%d" % (t3 - t2)         
        # 查询出当前用户的全部展示信息
        retDict["info"] = renderScan2(belongType.DAILY_SCAN)
        if len(allLines) > 0:
            retDict["headId"] = allLines[0].get("headId")
        return json.dumps(retDict)
    
class rescan:
    imgLineDao = ImgLineDao()
    imgHeadDao = ImgHeadDao()
    def removeDirChildren(self, dirPath):
        filelist = os.listdir(dirPath)
        for f in filelist:  
            filepath = pathJoin(dirPath, f)  
            if os.path.isfile(filepath):  
                os.remove(filepath)  
            elif os.path.isdir(filepath):  
                shutil.rmtree(filepath, True)  
    
    def POST(self):
        retDict = {"isSuccess":True}
        i = web.input()
        headId = i.headId
        curPage = i.curPage
        belong = getBelong(i.belong)
        data = json.loads(i.data)
        session = web.config._session
        imgHead = self.imgHeadDao.getById(headId)
        # 删除资料组下的图片
        # 如果不存在图片，终止操作
        if data and len(data) > 0:
            path = data[0].get("path")
            if path and not os.path.isfile(path):
                if curPage == "groups":
                    retDict["info"] = renderScan2(belong)
                else :
                    retDict["info"] = updateScan3(self.imgLineDao, headId)
                return json.dumps(retDict)
        lineList = self.imgLineDao.findByHeadId2(headId)
        delAllFileByImgLine(lineList)
        # 新增扫描的图片
        originalDirPath = pathJoin(scanPath, imgHead.get('headNum'))
        smallDirPath = pathJoin(scanPath, imgHead.get('headNum'))
        WaterCode = 0
        imgOrd = 0
        imgLineList = []
        userNum = session.user.get("userNum")
        for file in data:
            path = file.get("path")
            fileNameS = os.path.basename(path)
            WaterCode += 1
            WaterCodeStr = str(WaterCode)
            if len(WaterCodeStr) < 3:
                for i in range(3 - len(WaterCodeStr)):
                    WaterCodeStr = "0" + WaterCodeStr
            fileNameP = userNum + "_" + time.strftime('%Y%m%d%H%M%S') + WaterCodeStr + "." + fileNameS.split(".")[-1]
            originalPath = pathJoin(originalDirPath, fileNameP)
            smallPath = pathJoin(smallDirPath, "s_" + fileNameP)
            img = cv2.imread(path, -1)
            h, w = img.shape[:2]
            width = imgWidth
            height = int(imgWidth * 1.0 / w * h)
            if h > w:
                height = 90
                width = int(height * 1.0 / h * w)
            cv2.imwrite(originalPath.encode(sys.getfilesystemencoding()), img)
#             shutil.move(path, originalPath.encode(sys.getfilesystemencoding()))  
            cv2.imwrite(smallPath.encode(sys.getfilesystemencoding()), cv2.resize(img, (width, height)))
            imgOrd += 1
            imgLine = {
                       "headId":headId,
                       "headNum":imgHead.get('headNum'),
                       "imgType":imgType.ADDED,
                       "imgNameS":fileNameS,
                       "imgNameP":fileNameP,
                       "scanTime":time.strftime('%Y-%m-%d %H:%M:%S'),
                       "imgSize":os.path.getsize(originalPath.encode(sys.getfilesystemencoding())),
                       "isChecked":"0",
                       "userNum":userNum,
                       "imgOrd" :imgOrd,
                       }
            imgLineList.append(imgLine)
        
        self.imgLineDao.deleteByHeadId(headId)
        allLines = self.imgLineDao.saveAll(headId, imgLineList)
        self.imgHeadDao.updateHeadSizeAndQty(headId)
        # 识别发票，插入信息
#         ocrThread = OcrThread(allLines)
#         ocrThread.start() 
        if curPage == "groups":
            retDict["info"] = renderScan2(belong)
        else :
            retDict["info"] = updateScan3(self.imgLineDao, headId)
        return json.dumps(retDict)
    
class addScan:
    imgLineDao = ImgLineDao()
    imgHeadDao = ImgHeadDao()
    def POST(self):
        retDict = {"isSuccess":True}
        i = web.input()
        headId = i.headId
        curPage = i.curPage
        belong = getBelong(i.belong)
        data = json.loads(i.data)
        session = web.config._session
        imgHead = self.imgHeadDao.getById(headId)
        # 新增扫描的图片
        WaterCode = 0
        imgLineList = []
        userNum = session.user.get("userNum")
        imgOrd = self.imgLineDao.getMaxOrd(headId)
        for file in data:
            path = file.get("path")
            if path and not os.path.isfile(path):
                continue
            fileNameS = os.path.basename(path)
            WaterCode += 1
            WaterCodeStr = str(WaterCode)
            if len(WaterCodeStr) < 3:
                for i in range(3 - len(WaterCodeStr)):
                    WaterCodeStr = "0" + WaterCodeStr
            fileNameP = userNum + "_" + time.strftime('%Y%m%d%H%M%S') + WaterCodeStr + "." + fileNameS.split(".")[-1]
            originalPath = pathJoin(scanPath, imgHead.get('headNum'), fileNameP)
            smallPath = pathJoin(scanPath, imgHead.get('headNum'), "s_" + fileNameP)
            img = cv2.imread(path, -1)
            h, w = img.shape[:2]
            width = imgWidth
            height = int(imgWidth * 1.0 / w * h)
            if h > w:
                height = 90
                width = int(height * 1.0 / h * w)
            cv2.imwrite(originalPath.encode(sys.getfilesystemencoding()), img)
#             shutil.move(path, originalPath.encode(sys.getfilesystemencoding())) 
            cv2.imwrite(smallPath.encode(sys.getfilesystemencoding()), cv2.resize(img, (width, height)))
            imgOrd += 1
            imgLine = {
                       "headId":headId,
                       "headNum":imgHead.get('headNum'),
                       "imgType":imgType.ADDED,
                       "imgNameS":fileNameS,
                       "imgNameP":fileNameP,
                       "scanTime":time.strftime('%Y-%m-%d %H:%M:%S'),
                       "imgSize":os.path.getsize(originalPath.encode(sys.getfilesystemencoding())),
                       "isChecked":"0",
                       "userNum":userNum,
                       "imgOrd" :imgOrd
                       }
            imgLineList.append(imgLine)
        allLines = self.imgLineDao.saveAll(headId, imgLineList)
        self.imgHeadDao.updateHeadSizeAndQty(headId)
        # 识别发票，插入信息
#         ocrThread = OcrThread(allLines)
#         ocrThread.start()
        if curPage == "groups":
            retDict["info"] = renderScan2(belong)
        else:
            retDict["info"] = updateScan3(self.imgLineDao, headId)
        return json.dumps(retDict)
class replaceScan:
    imgLineDao = ImgLineDao()
    imgHeadDao = ImgHeadDao()
    def POST(self):
        retDict = {"isSuccess":True}
        i = web.input()
        headId = i.headId
        lineIds = eval(i.lineIds)
        data = json.loads(i.data)
        # 如果不存在图片，终止操作
        if data and len(data) > 0:
            path = data[0].get("path")
            if path and not os.path.isfile(path):
                retDict["info"] = updateScan3(self.imgLineDao, headId)
                return json.dumps(retDict)
        if len(lineIds) != len(data):
            retDict["isSuccess"] = False
            retDict["msg"] = u"扫描到的影像数量为:%d,选择替扫的影像数量：%d. 两者必须相同" % (len(data), len(lineIds))
            return json.dumps(retDict)
        session = web.config._session
        imgHead = self.imgHeadDao.getById(headId)
        lineList = self.imgLineDao.findByIds(lineIds)
        delAllFileByImgLine(lineList)
        # 新增扫描的图片
        WaterCode = 0
        userNum = session.user.get("userNum")
        lineDict = {}
        for line in lineList:
            lineDict[line.lineId] = line
        for k in range(len(data)):
            file = data[k]
            lineId = lineIds[k]
            imgLine = lineDict[int(lineId)]
            
            path = file.get("path")
            if path and not os.path.isfile(path):
                continue
            fileNameS = os.path.basename(path)
            WaterCode += 1
            WaterCodeStr = str(WaterCode)
            if len(WaterCodeStr) < 3:
                for i in range(3 - len(WaterCodeStr)):
                    WaterCodeStr = "0" + WaterCodeStr
            fileNameP = userNum + "_" + time.strftime('%Y%m%d%H%M%S') + WaterCodeStr + "." + fileNameS.split(".")[-1]
            originalPath = pathJoin(scanPath, imgHead.get('headNum'), fileNameP)
            smallPath = pathJoin(scanPath, imgHead.get('headNum'), "s_" + fileNameP)
            img = cv2.imread(path, -1)
            h, w = img.shape[:2]
            width = imgWidth
            height = int(imgWidth * 1.0 / w * h)
            if h > w:
                height = 90
                width = int(height * 1.0 / h * w)
            cv2.imwrite(originalPath.encode(sys.getfilesystemencoding()), img)
#             shutil.move(path, originalPath.encode(sys.getfilesystemencoding())) 
            cv2.imwrite(smallPath.encode(sys.getfilesystemencoding()), cv2.resize(img, (width, height)))
            imgLine.imgNameS = fileNameS
            imgLine.imgNameP = fileNameP
            imgLine.scanTime = time.strftime('%Y-%m-%d %H:%M:%S')
            imgLine.imgSize = os.path.getsize(originalPath.encode(sys.getfilesystemencoding()))
            
        allLines = self.imgLineDao.saveAll(headId, lineList)
        self.imgHeadDao.updateHeadSizeAndQty(headId)
        # 识别发票，插入信息
#         ocrThread = OcrThread(allLines)
#         ocrThread.start()
        retDict["info"] = updateScan3(self.imgLineDao, headId)
        return json.dumps(retDict)
        
class importImg:
    imgLineDao = ImgLineDao()
    imgHeadDao = ImgHeadDao()
    def GET(self):
        return pureRender.modules.importImg()
    def POST(self):
        input = web.webapi.rawinput()
        headId = web.input().headId
        imgHead = self.imgHeadDao.getById(headId)
        files = input.imgFiles
        if not isinstance(files, list):
            files = [files]
        WaterCode = 0
        session = web.config._session
        userNum = session.user.get("userNum")
        imgLineList = []
        imgOrd = self.imgLineDao.getMaxOrd(headId)
        for f in files:
            fileNameS = f.filename.decode("utf-8")
            fileNameS = os.path.basename(fileNameS)
            WaterCode += 1
            WaterCodeStr = str(WaterCode)
            if len(WaterCodeStr) < 3:
                for i in range(3 - len(WaterCodeStr)):
                    WaterCodeStr = "0" + WaterCodeStr
            fileNameP = userNum + "_" + time.strftime('%Y%m%d%H%M%S') + WaterCodeStr + "." + fileNameS.split(".")[-1]
            # 图片保存
            originalPath = pathJoin(scanPath, imgHead.get('headNum'), fileNameP)
            fout = open(originalPath, 'wb') 
            fout.write(f.file.read())
            fout.close() 
            smallPath = pathJoin(scanPath, imgHead.get('headNum'), "s_" + fileNameP)
            img = cv2.imread(originalPath, -1)
            if img is None:
                return render.modules.importImg({}, _("无法导入图片：") + fileNameS)
            h, w = img.shape[:2]
            width = imgWidth
            height = int(imgWidth * 1.0 / w * h)
            if h > w:
                height = 90
                width = int(height * 1.0 / h * w)
            cv2.imwrite(smallPath.encode(sys.getfilesystemencoding()), cv2.resize(img, (width, height)))
            imgOrd += 1
            imgLine = {
                       "headId":headId,
                       "headNum":imgHead.get('headNum'),
                       "imgType":imgType.ADDED,
                       "imgNameS":fileNameS,
                       "imgNameP":fileNameP,
                       "scanTime":time.strftime('%Y-%m-%d %H:%M:%S'),
                       "imgSize":os.path.getsize(originalPath.encode(sys.getfilesystemencoding())),
                       "isChecked":"0",
                       "userNum":userNum,
                       "imgOrd" :imgOrd
                       }
            imgLineList.append(imgLine)
        allLines = self.imgLineDao.saveAll(headId, imgLineList)
        self.imgHeadDao.updateHeadSizeAndQty(headId)
        # 识别发票，插入信息
#         ocrThread = OcrThread(allLines)
#         ocrThread.start()
        ret = {
             "headId":headId,
             "curPage":web.input().curPage,
             "belong": web.input().belong
             }  
        return pureRender.modules.importImg(ret)
        
class uploadFile:
    evsInterface = GhEvsInterface()
    imgHeadDao = ImgHeadDao()
    configDao = ConfigDao()
    uploadTaskDao = UploadTaskDao()
    def auToUpload(self, ticket, userNum, ftpMap):
        print "auto upload timer start ~_~!"
        if not ticket:
            print "ticket不存在，upload任务定时器 关闭~_~!"
            return False
        isLogin = self.evsInterface.IsLogin(ticket).get("data")
        # 不是登录状态， 停止定时任务
        if not isLogin:
            print "no login, auto upload timer  close~_~!"
            return False
        # 清理超时的单据，置成失败
        self.imgHeadDao.uploading2FailuerByTimeout()
        
        # 查询自己的失败的单据        
        page = {"pageNum":1,"pageSize":20}        
        cond = {"userNum":userNum,"status":headStatus.FAILURE}
        page["cond"]=cond
        pages = self.imgHeadDao.findByPage(page)
        headIds = []
        for head in pages.get("data"):
            headIds.append(head.get("headId"))
        # TODO 清理线程
        
        # 启动新线程上传
        self.doUpload(headIds, ticket, userNum, ftpMap)
        return True
        
    def doUpload(self, headIds, ticket, userNum, ftpMap):
        for headId in headIds:
            self.imgHeadDao.update({"headId":headId, "status":headStatus.UPLOADING, "uploadTime": time.strftime('%Y-%m-%d %H:%M:%S')})
            uploadTask = {
              "headId":headId,
               "status":taskStatus.WAITING,
               "userNum": userNum,
               "taskType":taskType.NOW
                          }
            self.uploadTaskDao.deleteByHeadId(headId)
            self.uploadTaskDao.save(uploadTask)
        uploadThread = UploadThread(headIds, ticket, ftpMap)
        uploadThread.start()
    def POST(self):
        i = web.input()
        belong = getBelong(i.belong)
        headIds = json.loads(i.headIds)
        session = web.config._session
        userNum = session.user.get("userNum")
        self.doUpload(headIds, session.ticket, userNum, session.ftpMap)
        return renderScan2(belong)
class reUploadFile:
    uploadFileS = uploadFile()
    def GET(self):
        self.POST()
    def POST(self):
        i = web.input()
        session = web.config._session
        userNum = session.user.get("userNum")
        headId = i.get("headId")
        self.uploadFileS.doUpload([headId], session.ticket, userNum, session.ftpMap)
        return json.dumps(common.buildSuccess(info="ok"))
class backForModify:
    imgHeadDao = ImgHeadDao()
    def GET(self):
        self.POST()
    def POST(self):
        i = web.input()
        headId = i.get("headId")
        self.imgHeadDao.updateStatusByheadId(headId, headStatus.WAIT)
        return json.dumps(common.buildSuccess(info="ok"))
class delTaskOnResultPage:
    imgHeadDao = ImgHeadDao()
    def GET(self):
        self.POST()
    def POST(self):
        i = web.input()
        headId = i.get("headId")
        imgHead = self.imgHeadDao.getById(headId)
        # 返回要删除的行记录
        lineList = self.imgHeadDao.deleteByHeadIds([headId])
        delAllFileByImgLine(lineList)
        # 清空文件夹
        dirPath = pathJoin(scanPath, imgHead.get("headNum"))
        if os.path.isdir(dirPath):
            shutil.rmtree(dirPath)
        return json.dumps(common.buildSuccess(info="ok"))
class changeapp:
    configDao = ConfigDao()
    def GET(self):
        self.POST()
    def POST(self):
        i = web.input()
        session = web.config._session
        
        # 保存用户填写的参数值
        for app in session.appList:
            if app.get("appCode") == i.appCode:
                session.currentApp = app
        return json.dumps(common.buildSuccess(info="ok"))
class saveUserForm:
    configDao = ConfigDao()
    def GET(self):
        self.POST()
    def POST(self):
        i = web.input()
        session = web.config._session
        
        # 保存用户填写的参数值
        for app in session.appList:
            if app.get("appCode") == i.appCode:
                userform_db = {}
                for f in app.get("form"):
                    value = i.get(f.get("name"))
                    userform_db[f.get("name")] = value
                    f["value"] = value
                    if f.get("type") == "select":
                        for item in f.get("items"):
                            if value == item.get("value"):
                                f["value_label"] = item.get("label")
                self.configDao.save({app.get("appCode") + "_forms":json.dumps(userform_db), "appCode":i.appCode})
                #只要保存过，就不再执行自动保存
                session.autoSaveUserForm=False 
                
                session.currentApp = app
        return json.dumps(common.buildSuccess())
class saveUserFormByHead:
    imgHeadDao = ImgHeadDao()
    imgLineDao = ImgLineDao()
    def GET(self):
        self.POST()
    def POST(self):
        i = web.input()
        headId = i.get("headId")
        imghead = self.imgHeadDao.getById(headId)
        imghead["appCode"] = i.get("appCode") 
        oldHeadNum = imghead.get("headNum");

        
        headNum = None
        # 保存用户填写的参数值
        userForm = json.loads(imghead.userForm)
        for f in userForm:
            value = i.get(f.get("name"))
            f["value"] = value
            if int(f.get("groupBy", 0)) == 1:
                headNum = value
            if f.get("type") == "select":
                for item in f.get("items"):
                    if value == item.get("value"):
                        f["value_label"] = item.get("label")
        imghead["userForm"] = json.dumps(userForm)                
        if headNum:
            imghead["headNum"] = headNum
        # 如果编号相同，只要更新userForm,  否则要更新其他信息
        if oldHeadNum == headNum:
            self.imgHeadDao.update(imghead)
        else:        
            tempHead = self.imgHeadDao.findByHeadNum(headNum)
            if tempHead is not None:
                return json.dumps(common.buildFail(info=_("任务编号：") + headNum + _("已经存在")))
            self.imgHeadDao.update(imghead)
            self.imgLineDao.updateImgHeadNum(headId, headNum)
            
            # 重命名文件夹
            oldDir = pathJoin(scanPath, oldHeadNum)
            newDir = pathJoin(scanPath, headNum)
            os.rename(oldDir, newDir)
        
        return json.dumps(common.buildSuccess())
        
class showImages:
    imgLineDao = ImgLineDao()
    def POST(self):
        i = web.input()
        headId = i.headId
        return updateScan3(self.imgLineDao, headId)
        
class addTask:
    imgHeadDao = ImgHeadDao()
    def POST(self):
        retDict = {"isSuccess":True}
        i = web.input()
        dbHead = self.imgHeadDao.findByHeadNum(i.headNum)
        if dbHead is not None:
            retDict["isSuccess"] = False
            retDict["msg"] = _("任务编号：") + i.headNum + _("已经存在")
            return json.dumps(retDict)
        session = web.config._session
        userNum = session.user.get("userNum")
        belong = getBelong(i.belong)
        cond = {
                "userNum":userNum,
                "belong":belong
                }
        headOrd = self.imgHeadDao.getMaxOrd(cond)
        userForm = session.currentApp.get("form")
        for f in userForm:
            if int(f.get("groupBy", 0)) == 1:
                f["value"] = i.headNum
        imghead = {
                  "headNum":i.headNum,
                   "status": headStatus.WAIT,
                   "belong":belong,
                   "userNum": userNum,
                   "imgQty":0,
                   "headSize":0,
                   "headOrd":headOrd,
                   "headStatus":headStatus2.NORMAL,
                   "appCode":session.currentApp.get("appCode"),
                   "userForm":json.dumps(userForm),
                  }
        self.imgHeadDao.saveImgHead(imghead)
        newDir = pathJoin(scanPath, i.headNum)
        if not os.path.isdir(newDir):
            os.makedirs(newDir)
        retDict["info"] = renderScan2(belong)
        return json.dumps(retDict)
    
class delTask:
    imgHeadDao = ImgHeadDao()
    def POST(self):
        i = web.input()
        headIds = eval(i.headIds)
        # 返回要删除的行记录
        lineList = self.imgHeadDao.deleteByHeadIds(headIds)
        delAllFileByImgLine(lineList)
        return renderScan2(getBelong(i.belong))

def delAllFileByImgLine(lineList):
    ocrDirList = initial_params.keys()
    for line in lineList:
        path1 = pathJoin(scanPath, line.get("headNum"), line.get("imgNameP"))
        path2 = pathJoin(scanPath, line.get("headNum"), "s_" + line.get("imgNameP"))
        if os.path.isfile(path1):
            os.remove(path1)
        if os.path.isfile(path2):
            os.remove(path2)
        for ocrDir in ocrDirList:
            path3 = pathJoin(rootPath, "static/images", ocrDir, "v" + str(line.get("lineId")) + "_" + ocrDir + ".jpg")  
            path4 = pathJoin(rootPath, "static/grayImage", ocrDir, "v" + str(line.get("lineId")) + "_" + ocrDir + ".jpg")  
            if os.path.isfile(path3):
                os.remove(path3)
            if os.path.isfile(path4):
                os.remove(path4)
def getGroupNameByApp(app):
    groupName = None
    for f in app.get("form"):  
        if str(f.get("groupBy")) == "1":
            groupName = f.get("name")
    return groupName              
def getUserFormByApp(app):
    userForm = {}
    for f in app.get("form"):  
        userForm[f.get("name")] = f.get("value")
    return userForm              
def getUserFormHiddenValueByApp(app):
    userForm = {}
    for f in app.get("form"):  
        if f.get("type") == "hidden":
            userForm[f.get("name")] = f.get("value")
    return userForm              
class getTask():
    imgHeadDao = ImgHeadDao()
    evsInterface = GhEvsInterface()
    ocrResultDao = OcrResultDao()
    configDao = ConfigDao()
    def POST(self):
        retDict = {"isSuccess":True}
        session = web.config._session
        ticket = session.get('ticket')
        userNum = session.user.get("userNum")
        from loginService import getAppraiseTask
        pageInfo = {
            "pageNum":1,
            "pageSize":100
        }
        
        jsonParam = {
          "appCode":session.currentApp.get("appCode"),
#           "form":getUserFormByApp(session.currentApp)          
          "form":getUserFormHiddenValueByApp(session.currentApp)          
        }
        ret = getAppraiseTask(ticket, userNum, self.imgHeadDao, self.ocrResultDao, self.evsInterface, session, getGroupNameByApp(session.currentApp), json.dumps(pageInfo), jsonParam)
        if ret :
            retDict["info"] = renderScan2(getBelong(web.input().belong))
            return json.dumps(retDict)
        else:
            retDict["isSuccess"] = False
            retDict["msg"] = _("获取任务失败")
            return json.dumps(retDict)
    
class editNum:
    imgHeadDao = ImgHeadDao()
    def POST(self):
        retDict = {"isSuccess":True}
        i = web.input()
        dbHead = self.imgHeadDao.findByHeadNum(i.headNum)
        if dbHead is not None:
            retDict["isSuccess"] = False
            retDict["msg"] = _("任务编号：") + i.headNum + _("已经存在")
            return json.dumps(retDict)
        self.imgHeadDao.updateImgHeadNum(i.headId, i.headNum)
        oldDir = pathJoin(scanPath, i.oldNum)
        newDir = pathJoin(scanPath, i.headNum)
        os.rename(oldDir, newDir)
        retDict["info"] = renderScan2(getBelong(i.belong))
        return json.dumps(retDict)
    
class deleteImg:
    imgHeadDao = ImgHeadDao()
    imgLineDao = ImgLineDao()
    def POST(self):
        i = web.input()
        headId = i.headId
        lineIds = eval(i.lineIds)
        lineList = self.imgLineDao.findByIds(lineIds)
        self.imgLineDao.deleteByLineIds(headId, lineIds)
        self.imgHeadDao.updateHeadSizeAndQty(headId)
        delAllFileByImgLine(lineList)
        return updateScan3(self.imgLineDao, headId)
        
class editImg:
    imgLineDao = ImgLineDao()
    def POST(self):
        i = web.input()
        headId = self.imgLineDao.editImgLine(i.lineId, i.imgOrd, i.imgNameS)
        return updateScan3(self.imgLineDao, headId)
        
class moveImg:
    imgHeadDao = ImgHeadDao()
    imgLineDao = ImgLineDao()
    def POST(self):
        i = web.input()
        lineIds = eval(i.lineIds)
        destHeadId = i.destHeadId
        headId, imgPathList, posDir = self.imgLineDao.moveImgLine(destHeadId, lineIds)
        pos1 = pathJoin(scanPath, posDir)
        for path in imgPathList:
            path1 = pathJoin(scanPath, path)
            if os.path.exists(path1): 
                shutil.move(path1, pos1) 
        return updateScan3(self.imgLineDao, headId)
    
class refreshDocGroup:
    def POST(self):
        return renderScan2()
    
class refreshPhoto:
    imgLineDao = ImgLineDao()
    def POST(self):
        i = web.input()
        return updateScan3(self.imgLineDao, i.headId)

def updateScan3(imgLineDao, headId):
    imghead, otherHeads, imgLines = imgLineDao.findByHeadId(headId)
    session = web.config._session
    headApp = None
    for app in session.appList:
        if app.get("appCode") == imghead.get("appCode"):
            headApp = app
    userForm = json.loads(imghead.userForm)
    return pureRender.modules.scan3(imghead, otherHeads, imgLines, headApp, userForm)
        
class rotateImg:
    def POST(self):
        i = web.input()
        imgPath = i.imgPath.split("?")[0]
        originalPath = pathJoin(rootPath, imgPath)
        imgRotate.rotateImgFile(originalPath, float(i.angle))
        img = cv2.imread(originalPath, -1)
        h, w = img.shape[:2]
        width = imgWidth
        height = int(imgWidth * 1.0 / w * h)
        if h > w:
            height = 90
            width = int(height * 1.0 / h * w)
        n = originalPath.rfind("/")
        fileName = originalPath[n + 1:]
        smallFile = originalPath[:n + 1] + "s_" + fileName
        cv2.imwrite(smallFile, cv2.resize(img, (width, height)))
        return imgPath + "?r=" + str(random.random())
class goToImg:
    def POST(self):
        i = web.input()
        imgPath = i.imgPath.split("?")[0]
        originalPath = pathJoin(rootPath, imgPath)
        imgRotate.rotateImgFile(originalPath, float(i.angle))
        img = cv2.imread(originalPath, -1)
        h, w = img.shape[:2]
        width = imgWidth
        height = int(imgWidth * 1.0 / w * h)
        if h > w:
            height = 90
            width = int(height * 1.0 / h * w)
        n = originalPath.rfind("/")
        fileName = originalPath[n + 1:]
        smallFile = originalPath[:n + 1] + "s_" + fileName
        cv2.imwrite(smallFile, cv2.resize(img, (width, height)))
        return imgPath + "?r=" + str(random.random())

class getClientParams:
    configDao = ConfigDao()
    evsInterface = GhEvsInterface()
    def POST(self):
        session = web.config._session
        ticket = session.get('ticket')
        params = "method=scan"
        for key, val in session.scanConfig.items():
            params += "&" + key + "=" + str(val)
        configDict = self.configDao.findAllAsDict()
        if configDict.get("DS_NAME"):
            params += "&ds_name=" + configDict.get("DS_NAME")
        else:
            return _("请先到系统配置选择扫描仪")
#         params += "&dpi=" + configDict.get("DPI")
#         params += "&contrast=" + configDict.get("CONTRAST")
        return params
    
class appraiseTaskQuery:
    imgHeadDao = ImgHeadDao()
    evsInterface = GhEvsInterface()
    def POST(self):
        i = web.input()
        session = web.config._session
        pageNum = int(i.pageNum)
        groupFieldValue = ""
        if i.groupFieldValue and i.groupFieldValue.strip() != "":
            groupFieldValue = i.groupFieldValue.strip()
        pageInfo = {
            "pageNum":pageNum,
            "pageSize":constants.pageSize
        }
        
        userForm = getUserFormByApp(session.currentApp)
        userForm[session.currentApp.get("groupFieldName")] = groupFieldValue
        jsonParam = {
          "appCode":session.currentApp.get("appCode"),
          "form": userForm        
        }
        
        ret = self.evsInterface.GetServCmdInfo(session.ticket, taskType.BACKTASK, json.dumps(pageInfo), json.dumps(jsonParam))
        result = ret.get("data")
        tasks = []
        pageCount = 0
        if result:
            tasks = result.get("data")
            for t in tasks:
                t["appraiseTaskValStr"] = json.dumps(t)
            pageCount = result.get("pageInfo").get("totalPage")
        return pureRender.widgets.appraiseTaskLov(groupFieldValue, pageNum, pageCount, tasks)
class appraiseTaskAddScan:
    imgHeadDao = ImgHeadDao()
    evsInterface = GhEvsInterface()
    def POST(self):
        import loginService
        session = web.config._session
        i = web.input()
        appraiseTasks = eval(i.appraiseTasks)
        ticket = session.ticket
        if not session.ticket:
            print "ticket不存在，评价任务定时器 关闭~_~!"
            return False
        isLogin = self.evsInterface.IsLogin(ticket).get("data")
        # 不是登录状态， 停止定时任务
        if not isLogin:
            print "未登录或登录 失效，评价任务定时器 关闭~_~!"
            return False
        userNum = session.user.get("userNum")
        groupName = getGroupNameByApp(session.currentApp)
        for task in appraiseTasks:
#         for task in tasks:
            task = json.loads(task)
            imgHeadList = []
            headNum = task.get("form").get(groupName)
            # 查询是否存在，如果存在,且非WAIT状态的评价任务：删除本地存在的此任务及图片;是WAIT状态的评价任务，跳过
            destPath = pathJoin(scanPath, headNum)
            cond = {
                "userNum":userNum,
                "headNum":headNum
                }
            dbImgHead = self.imgHeadDao.getByCond(cond)
            if dbImgHead:
                if dbImgHead.get("belong") == belongType.APPRAISE_TASK and dbImgHead.get("status") == headStatus.WAIT:
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
                
            ftp = session.get("ftpMap").get(task.get('ftpId'))
            if not ftp:
                print >> sys.stderr, "connot get ftp info by ftpId:[%s]" % (task.get('ftpId'))
                return json.dumps(common.buildFail(_("获取FTP信息失败，请确认是否配置FTP信息")))
            # 测试连通性
            testRtn = ftpU.testFtp(ftp.get("ftpIp"), int(ftp.get("port")), ftp.get("userName"), ftp.get("password"))
            if not testRtn or not testRtn.get("isSuccess"):
                return json.dumps(testRtn)
            remoteFiles = task.get("imageList") 
            if remoteFiles:
                for f in remoteFiles:
                    fileNames.append(os.path.basename(f))
                isSuccess = ftpU.download2(ftp.get("userName"), ftp.get("password"), dirPath, remoteFiles, ftp.get("ftpIp"), ftp.get("port"))
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
                "userNum":userNum,
                "belong":belongType.APPRAISE_TASK
                }
            headOrd = self.imgHeadDao.getMaxOrd(cond)
            userForm = session.currentApp.get("form")
            loginService.setUserFormByDict(userForm, task.get("form"))
            imgHead = {
               "headNum":headNum,
               "belong":belongType.APPRAISE_TASK,
               "status": headStatus.WAIT,
               "remark":task.get('remark', "").decode("utf-8"),
               "userNum":userNum,
               "appCode":task.get("appCode"),
               "headStatus":task.get("status"),
               "userForm":json.dumps(userForm),
               "headOrd":headOrd
            }
            # 添加行表信息 
            editAble, deleteAble = loginService.getLineStatusByHeadStatus(task.get("status"))
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
            self.imgHeadDao.saveAll(imgHeadList)
        return json.dumps(common.buildSuccess())
class noTaskQuery:
    imgHeadDao = ImgHeadDao()
    evsInterface = GhEvsInterface()
    def POST(self):
        i = web.input()
        session = web.config._session
        pageNum = int(i.pageNum)
        groupFieldValue = ""
        if i.groupFieldValue and i.groupFieldValue.strip() != "":
            groupFieldValue = i.groupFieldValue.strip()
        pageInfo = {
            "pageNum":pageNum,
            "pageSize":constants.pageSize
        }
        
        userForm = getUserFormByApp(session.currentApp)
        userForm[session.currentApp.get("groupFieldName")] = groupFieldValue
        jsonParam = {
          "appCode":session.currentApp.get("appCode"),
          "form": userForm        
        }
        
        ret = self.evsInterface.GetServCmdInfo(session.ticket, taskType.NOTASK, json.dumps(pageInfo), json.dumps(jsonParam))
        result = ret.get("data")
        tasks = []
        pageCount = 0
        if result:
            tasks = result.get("data")
            for t in tasks:
                t["noTaskValStr"] = json.dumps(t)
            pageCount = result.get("pageInfo").get("totalPage")
        return pureRender.widgets.noTaskLov(groupFieldValue, pageNum, pageCount, tasks)
    
class noTaskAddScan:
    imgHeadDao = ImgHeadDao()
    evsInterface = GhEvsInterface()
    def POST(self):
        import loginService
        session = web.config._session
        i = web.input()
        noTasks = eval(i.noTasks)
#         for noTask in noTasks:
#             userForm = noTask.get("form")
#             noTask = json.loads(noTask)
#             headNum = userForm.get(session.currentApp.get("groupFieldName"))
#             imgHead = self.imgHeadDao.getByHeadNum(headNum)
#             if imgHead:
#                 pass
#             imgHead = {
#                       "headId":headId,
#                       "status":headStatus.WAIT,
#                       "belong":belongType.NO_TASK,
#                       }
#             self.imgHeadDao.update(imgHead)
        print "无任务处理开始~_~!"
        ticket = session.ticket
        if not session.ticket:
            print "ticket不存在，评价任务定时器 关闭~_~!"
            return False
        isLogin = self.evsInterface.IsLogin(ticket).get("data")
        # 不是登录状态， 停止定时任务
        if not isLogin:
            print "未登录或登录 失效，评价任务定时器 关闭~_~!"
            return False
        userNum = session.user.get("userNum")
        for task in noTasks:
            task = json.loads(task)
            imgHeadList = []
            headNum = task.get("form").get(session.currentApp.get("groupFieldName"))
            # 查询是否存在，如果存在,且非WAIT状态的评价任务：删除本地存在的此任务及图片;是WAIT状态的评价任务，跳过
            destPath = pathJoin(scanPath, headNum)
            cond = {
                "userNum":userNum,
                "headNum":headNum
                }
            dbImgHead = self.imgHeadDao.getByCond(cond)
            if dbImgHead:
                imgNames = self.imgHeadDao.deleteByHeadId(dbImgHead.get("headId"))
                for imgName in imgNames:
                    path = pathJoin(destPath, imgName)
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
            if remoteFiles:
                for f in remoteFiles:
                    fileNames.append(os.path.basename(f))
                isSuccess = ftpU.download2(ftp.get("userName"), ftp.get("password"), dirPath, remoteFiles, ftp.get("ftpIp"), ftp.get("port"))
                if not isSuccess:
                    print _("任务编号："), headNum, _("下载失败")
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
                "userNum":userNum,
                "belong":belongType.APPRAISE_TASK
                }
            headOrd = self.imgHeadDao.getMaxOrd(cond)
            userForm = session.currentApp.get("form")
            loginService.setUserFormByDict(userForm, task.get("form"))
            imgHead = {
               "headNum":headNum,
               "belong":belongType.NO_TASK,
               "status": headStatus.WAIT,
               "remark":"" if not task.get('remark', "") else  task.get('remark', "").decode("utf-8"),
               "userNum":userNum,
               "appCode":task.get("appCode"),
               "headStatus":task.get("status"),
               "userForm":json.dumps(userForm),
               "headOrd":headOrd
            }
            # 添加行表信息 
            editAble, deleteAble = loginService.getLineStatusByHeadStatus(task.get("status"))
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
            self.imgHeadDao.saveAll(imgHeadList)
        print "无任务处理结束~_~!"
        return True

class editHead:
    imgHeadDao = ImgHeadDao()
    def POST(self):
        i = web.input()
        imgHead = {
                 "headId" :i.headId,
                 "headDesc" :i.headDesc,
                  }
        self.imgHeadDao.update(imgHead)
    
class queue:
    uploadTaskDao = UploadTaskDao()
    uploadTaskLogDao = UploadTaskLogDao()
    evsInterface = GhEvsInterface()
    configDao = ConfigDao()
    def getQueueList(self):
        i = web.input()
        session = web.config._session
        cond = {"userNum":session.user.get("userNum"), "order":"headId Desc"}
        if  i.get("custName") and i.get("custName").strip() != "":
            cond["custName"] = i.get("custName").strip()
        pageNum = 1
        if not i.get("pageNum") or i.get("pageNum").strip() == "":
            pageNum = 1
        else:
            pageNum = int(i.get("pageNum"))
        page = {"pageNum":pageNum, "cond":cond}
        page = self.uploadTaskDao.findByPage(page)
        queueList = page.get("data")
        html = '''
        <div style="height:330px;">
        <table>
                <thead>
                <tr>
                    <th>%s</th>
                    <th>%s</th>
                    <th>%s</th>
                    <th>%s</th>
                    <th>%s</th>
                    <th>%s</th>
                    <th>%s</th>
                </tr>
            </thead>
            <tbody>
            ''' % (_('序号'), _('票据号'), _('图像页数'), _('图像大小'), _('任务类型'), _('状态'), _('操作'))
        for index, queue in enumerate(queueList):
            html += "<tr>"
            html += "<td>"
            html += str(index + 1)
            html += "</td>"
            
            html += "<td>"
            html += queue.get("headNum")
            html += "</td>"
            
            html += "<td>"
            html += str(queue.get("imgQty"))
            html += "</td>"
            
            html += "<td>"
            html += str(queue.get("headSize"))
            html += "</td>"
            
            html += "<td>"
            html += belongTypeShow.get(queue.get("belong"))
            html += "</td>"
            spanStart = ""
            spanEnd = ""
            operate = "&nbsp;"
            
            if queue.get("status") == "FAILURE":
                spanStart = "<span class=\"red\">"
                spanEnd = "</span>"
#                 operate = "<a href=\"#\" onclick=\"loadQueueData('queueList'," + str(pageNum) + "," + str(queue.get("headId")) + ");\">重新上传</a>"
                
            html += "<td>" + spanStart
            html += headStatusShow.get(queue.get("status"))
            html += spanEnd + "</td>"
            
            html += "<td>"
            html += operate
            html += "</td>"
            
            html += "</tr>"
        html += "</tbody>"
        html += "</table>"
        html += "</div>"
        html += self.getPageTailHtml("queueList", page)
        return html
    def getTaskLogList(self):
        i = web.input()
        session = web.config._session
        cond = {"userNum":session.user.get("userNum"), "order":"headId Desc"}
        if  i.get("custName") and i.get("custName").strip() != "":
            cond["custName"] = i.get("custName").strip()
        pageNum = 1
        if not i.get("pageNum") or i.get("pageNum").strip() == "":
            pageNum = 1
        else:
            pageNum = int(i.get("pageNum"))
        page = {"pageNum":pageNum, "cond":cond}
        page = self.uploadTaskLogDao.findByPage(page)
        print page
        taskLogList = page.get("data")
        html = '''
        <div style="height:330px;">
        <table>
                <thead>
                <tr>
                    <th>%s</th>
                    <th>%s</th>
                    <th>%s</th>
                    <th>%s(K)</th>
                    <th>%s</th>
                    <th>%s</th>
                </tr>
            </thead>
            <tbody>
            ''' % (_('序号'), _('票据号'), _('图像页数'), _('图像大小'), _('任务类型'), _('状态'))
        for index, taskLog in enumerate(taskLogList):
            html += "<tr>"
            html += "<td>"
            html += str(index + 1)
            html += "</td>"
            
            html += "<td>"
            html += taskLog.get("headNum")
            html += "</td>"
            
            html += "<td>"
            html += str(taskLog.get("imgQty"))
            html += "</td>"
            
            html += "<td>"
            html += str(round(taskLog.get("headSize") / 1024.0, 2))
            html += "</td>"
            
            html += "<td>"
            html += belongTypeShow.get(taskLog.get("belong"))
            html += "</td>"
            
            html += "<td>"
            html += headStatusShow.get(taskLog.get("status"))
            html += "</td>"
            
            html += "</tr>"
        html += "</tbody>"
        html += "</table>"
        html += "</div>"
        html += self.getPageTailHtml("taskLogList", page)
        return html
    def getPageTailHtml(self, tabName, page):
        pageNum = page.get("pageNum")
        pageCount = page.get("pageCount")
        html = '<div class="pagination fr mt10">'
        if pageNum != 1: 
            html += '<a class="page-prev" href="javaScript:loadQueueData(\'' + tabName + '\',' + str(pageNum - 1) + ')"><span>&lt; ' + _('上一页') + '</span></a>' 
        else:
            html += '<a class="page-prev unclick-l"><span>&lt; ' + _('上一页') + '</span></a>' 
        for i in range(pageCount):
            if pageNum == i + 1: 
                html += '<input type="hidden" id="pageNum" value="' + str(pageNum) + '"/><span class="page-cur">' + str(i + 1) + '</span>'
            else:     
                html += '<a href="javaScript:loadQueueData(\'' + tabName + '\',' + str(i + 1) + ')">' + str(i + 1) + '</a>' 
        if pageNum == pageCount or pageCount == 0:
            html += '<a class="page-next  unclick-l" href="#"><span>' + _('下一页') + ' &gt;</span></a>'
        else:
            html += '<a class="page-next" href="javaScript:loadQueueData(\'' + tabName + '\',' + str(pageNum + 1) + ')"><span>' + _('下一页') + ' &gt;</span></a>'
        html += '</div>' 
        return html
    def getTimeList(self):
        session = web.config._session
        timeIntervalList = session.uploadTime
        html = '''
        <div style="height:380px;">
        <table>
                <thead>
                <tr>
                    <th>%s</th>
                    <th>%s</th>
                    <th>%s</th>
                </tr>
            </thead>
            <tbody>
            ''' % (_('序号'), _('开始时间'), _('结束时间'))
        for index, timeInterval in enumerate(timeIntervalList):
            html += "<tr>"
            html += "<td>"
            html += str(index + 1)
            html += "</td>"
            
            html += "<td>"
            html += timeInterval.get("startTime")
            html += "</td>"
            
            html += "<td>"
            html += timeInterval.get("endTime")
            html += "</td>"
            
            html += "</tr>"
        html += "</tbody>"
        html += "</table>"
        html += "</div>"
        return html
    def GET(self):
        i = web.input()
#         headId = i.get("headId")
#         if headId:
#             u = uploadFile()
#             session = web.config._session
#             configDict = self.configDao.findAllAsDict()
#             userNum = session.user.get("userNum")
#             companyCode = configDict.get(configkey.COMPANY_CODE + userNum)
#             ftpId = configDict.get(configkey.SITE_ID + userNum)
#             operationCode = configDict.get(configkey.OPERATION_TYPE_CODE + userNum)
#             u.doUpload([headId], session.ticket, userNum, ftpId, companyCode, operationCode, session.get("lang"))
            
        tabName = i.get("tabName")
        if "queueList" == tabName:
            return self.getQueueList();
        elif "taskLogList" == tabName:
            return self.getTaskLogList();
        elif "timeList" == tabName:
            return self.getTimeList();
    def POST(self):
        return self.GET()
if __name__ == "__main__":
    d = dailyScan()
    regexStr = "^YZC\d*$"
    fileName = "C:/Users/zhang/Desktop/Desktop/2200087_20160731175337001.jpg"
    print d.readBarCode(fileName, regexStr)
    