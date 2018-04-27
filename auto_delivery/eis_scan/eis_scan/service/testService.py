# coding:utf-8
import os
import sys
from libs import web
import hashlib
from suds.client import Client 
from controllers.controller import render, initSession
from model.configDao import ConfigDao
from config.constants import configkey, belongType, headStatus, imgType, headStatus2
from config.config import scanPath, imgWidth
from model import common, ftpU
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
from config.constants import tickerDict, taskType
import numpy as np

import serial
from model.comThread import RecvThread
ser = None
recvThread = None
class testCom:
    def reloadCom(self, port="COM1", baudrate=9600):
        
        rtn = common.buildFail(u"初始串口失败！ port=COM1, baudrate=9600", "")
        try:
            global ser
            if ser != None:
                ser.close();
#             ser = serial.Serial("COM3", 9600, timeout=0.5)
            ser = serial.Serial(port, baudrate, timeout=0.5)
            # 线程
            rtn = common.buildSuccess(u"初始串口成功", "")
        except Exception:
            traceback.print_exc() 
        rtn["data"]={"port":port, "baudrate":baudrate}
        return rtn 
    def sendData(self, dataStr):
        global ser
        ser.write(dataStr) 
        return common.buildSuccess("", dataStr)
    def recvDate(self):
        rtn = common.buildFail(u"读串数据失败", "")
        try:
            global ser
            comData = ser.read(30)
            if None != comData and len(comData) > 0:   
                rtn = common.buildSuccess("", comData)
            else:
                rtn = common.buildSuccess("", "")
        except Exception:
            traceback.print_exc()  
        return rtn
    def GET(self):
        rtn = self.reloadCom()
        return render.modules.testCom(rtn)
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

if __name__ == '__main__':
    pass
