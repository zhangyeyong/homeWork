# -*- coding: utf-8 -*-
# @File  : meidingSerial.py
# @Author: 张业勇
# @Date  : 2018/12/3
# @Desc  :
from serialU import ComU
from model import common
import traceback


class MeidingSerial(ComU):
    def __init__(self, port="COM1", baudrate=19200):
        ComU.__init__(self, port, baudrate)

    def initMachine(self):
        print u"----------------初始化设备开始------------"
        rtn = common.buildFail(u"初始设备失败", "")
        try:
            # recvData = self.sendAndWaitRecvDate("init machine")
            rtn = common.buildSuccess(u"初始设备成功", "")
            pass
        except Exception:
            traceback.print_exc()
        print u"----------------初始化设备结束------------"
        return rtn

    def existPaper(self):
        print u"----------------读取是否有纸开始------------"
        rtn = common.buildFail(u"读取是否有纸失败", "")
        try:
            recvData = self.sendAndWaitRecvDate("init machine")
            rtn = common.buildSuccess(u"读取是否有纸成功", "")
        except Exception:
            traceback.print_exc()
        print u"----------------读取是否有纸结束------------"
        return rtn

    def transferPaper(self):
        print u"----------------传输纸张开始------------"
        rtn = common.buildFail(u"传输纸张失败", "")
        try:
            recvData = self.sendAndWaitRecvDate("init machine")
            rtn = common.buildSuccess(u"传输纸张成功", "")
        except Exception:
            traceback.print_exc()
        print u"----------------传输纸张结束------------"
        return rtn

    def fixPaper(self):
        print u"----------------装订纸张开始------------"
        rtn = common.buildFail(u"装订纸张失败", "")
        try:
            recvData = self.sendAndWaitRecvDate("init machine")
            rtn = common.buildSuccess(u"装订纸张成功", "")
        except Exception:
            traceback.print_exc()
        print u"----------------装订纸张结束------------"
        return rtn

    def backPaper(self):
        print u"----------------退纸开始------------"
        rtn = common.buildFail(u"退纸张失败", "")
        try:
            recvData = self.sendAndWaitRecvDate("init machine")
            rtn = common.buildSuccess(u"退纸张成功", "")
        except Exception:
            traceback.print_exc()
        print u"----------------退纸结束------------"
        return rtn

    def openBox(self):
        print u"----------------打开柜子开始------------"
        rtn = common.buildFail(u"打开柜子失败", "")
        try:
            recvData = self.sendAndWaitRecvDate("init machine")
            rtn = common.buildSuccess(u"打开柜子成功", "")
        except Exception:
            traceback.print_exc()
        print u"----------------打开柜子结束------------"
        return rtn

    def queryBoxSatus(self):
        print u"----------------查询柜子开始------------"
        rtn = common.buildFail(u"查询柜子失败", "")
        try:
            recvData = self.sendAndWaitRecvDate("init machine")
            rtn = common.buildSuccess(u"查询柜子成功", "")
        except Exception:
            traceback.print_exc()
        print u"----------------查询柜子结束------------"
        return rtn


if __name__ == '__main__':
    comU = MeidingSerial()
    rtn = comU.sendAndWaitRecvDate("test by zyy")
    print("the recv data is ", rtn)
    comU.closeCom()
