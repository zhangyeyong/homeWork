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

    # ======================复位======================================
    def initMachine(self):
        print u"----------------初始化设备开始------------"
        rtn = common.buildFail(u"初始设备失败", "")
        try:
            # recvData = self.sendAndWaitRecvDate("\x1B\x03\xA0\x00\x00\x1C\xA3")
            # print recvData
            # rtn = common.buildSuccess(u"初始设备成功", "")
            rtn = {'isSuccess': True, 'info': '', 'data': '\x1b\x06\xa0\x00\x00\x00\xfe\xff\x1c\xa7'}
        except Exception:
            traceback.print_exc()
        print u"----------------初始化设备结束------------"
        return rtn

    # ======================压痕======================================
    def fixPaper(self):
        print u"----------------装订纸张开始------------"
        rtn = common.buildFail(u"装订纸张失败", "")
        try:
            # recvData = self.sendAndWaitRecvDate("\x1B\x04\xA2\x00\x00\x00\x1C\xA6")
            # print str_to_hex(recvData)
            rtn = common.buildSuccess(u"装订纸张成功", "")
        except Exception:
            traceback.print_exc()
        print u"----------------装订纸张结束------------"
        return rtn

    # ======================回收======================================
    def recyclePaper(self):
        print u"----------------回收纸张开始------------"
        rtn = common.buildFail(u"回收纸张失败", "")
        try:
            # recvData = self.sendAndWaitRecvDate("\x1B\x04\xA2\x00\x00\x02\x1C\xA4")
            # print str_to_hex(recvData)
            rtn = common.buildSuccess(u"回收纸张成功", "")
        except Exception:
            traceback.print_exc()
        print u"----------------回纸张结束------------"
        return rtn

    # ======================退纸======================================
    def backPaper(self):
        print u"----------------退纸开始------------"
        rtn = None
        try:
            # recvData = self.sendAndWaitRecvDate("\x1B\x04\xA2\x00\x00\x01\x1C\xA7")
            # print str_to_hex(recvData)
            rtn = common.buildSuccess(u"退纸张成功", "")
        except Exception:
            traceback.print_exc()
            rtn = common.buildFail(u"退纸张失败", "")
        print u"----------------退纸结束------------"
        return rtn

    # ======================查询柜子状态======================================
    def queryBoxSatus(self):
        print u"----------------查询柜子开始------------"
        rtn = common.buildFail(u"查询柜子失败", "")
        try:
            # recvData = self.sendAndWaitRecvDate("\x1B\x03\xA0\x00\x00\x1C\xA3")
            recvData = "\x1b\x06\xa0\x00\x00\x00\xee\xff\x1c\xa7"
            print str_to_hex(recvData)
            enableStr = fillChar(bin(int(str_to_hex(recvData[6]), 16))[2:], "0", 8)
            openStatusStr = fillChar(bin(int(str_to_hex(recvData[8]), 16))[2:], "0", 8)
            print enableStr
            print openStatusStr
            boxNum = 0
            boxList = []

            for enable in enableStr:
                boxNum += 1
                openStatus = openStatusStr[boxNum - 1]
                box = {
                    "boxNum": boxNum,
                    "enable": enable,
                    "status": openStatus
                }
                boxList.append(box)
            rtn = common.buildSuccess(u"查询柜子成功", boxList)
        except Exception:
            traceback.print_exc()
        print u"----------------查询柜子结束------------"
        return rtn

    # ======================打开柜子======================================
    def openBox(self, orderNum):
        '''
        打开柜子
        :param orderNum: 柜号
        :return:
        '''
        orderNum = int(orderNum)
        print u"----------------打开%d柜子开始------------" % orderNum
        rtn = common.buildFail(u"打开柜子失败", "")
        try:
            if orderNum == 1:
                com = "\x1B\x04\xA1\x00\x00\x01\x1C\xA4"
            elif orderNum == 2:
                com = "\x1B\x04\xA1\x00\x00\x11\x1C\xB4"
            elif orderNum == 3:
                com = "\x1B\x04\xA1\x00\x00\x21\x1C\x84"
            elif orderNum == 4:
                com = "\x1B\x04\xA1\x00\x00\x31\x1C\x94"
            elif orderNum == 5:
                com = "\x1B\x04\xA1\x00\x00\x41\x1C\xE4"
            elif orderNum == 6:
                com = "\x1B\x04\xA1\x00\x00\x51\x1C\xF4"
            elif orderNum == 7:
                com = "\x1B\x04\xA1\x00\x00\x61\x1C\xC4"
            elif orderNum == 8:
                com = "\x1B\x04\xA1\x00\x00\x71\x1C\xD4"
            # recvData = self.sendAndWaitRecvDate(com)
            # print recvData
            # print str_to_hex(recvData)
            rtn = common.buildSuccess(u"打开柜子成功")
        except Exception:
            traceback.print_exc()
        print u"----------------打开柜子%s结束------------" % orderNum
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


def str_to_hex(s):
    return ' '.join([hex(ord(c)).replace('0x', '') for c in s])


def hex_to_str(s):
    return ''.join([chr(i) for i in [int(b, 16) for b in s.split(' ')]])


def formathex(s):
    return "\\x" + s.replace(" ", "\\x")


def fillChar(str, c, length):
    l = len(str)
    if l >= length:
        return str
    return c * (length - l) + str


if __name__ == '__main__':
    import time

    # s = u"\x7A\x79"
    # print s
    # s = "1B 06 A0 00 00 FF FE FF 1C 58"
    # print(formathex(s))

    mds = MeidingSerial(port="COM1")
    # ========================初始化====================
    # mds.initMachine()

    # ================查询柜子状态========================
    rtn = mds.queryBoxSatus()
    print rtn

    # ================打开柜子========================
    # mds.openBox(1)
    # time.sleep(1)
    # mds.openBox(2)
    # time.sleep(1)
    # mds.openBox(3)
    # time.sleep(1)
    # mds.openBox(4)
    # time.sleep(1)
    # mds.openBox(5)
    # time.sleep(1)
    # mds.openBox(6)
    # time.sleep(1)
    # mds.openBox(7)
    # time.sleep(1)
    # mds.openBox(8)

    # ======================压痕======================================
    # mds.fixPaper()

    # ======================回收======================================
    # mds.recyclePaper()

    # ======================退纸======================================
    # mds.backPaper()

    # import time
    # while True:
    #     time.sleep(1)
    #     rtn = mds.recvDate()
    #     data = rtn.get("data")
    #
    #     print ("--------------->",data)
    #     if data:
    #         print "ord(data[2]：",ord(data[2])==160
    #         print "bin(ord(data[2])：",bin(data[2])
    #         for c in data:
    #             print ord(c)

    # rtn = comU.sendAndWaitRecvDate("test by zyy")
    # print("the recv data is ", rtn)
    # comU.closeCom()
    # s = "\x31"
    # # print(hex_to_str(s))
    # print(str_to_hex(hex_to_str(s)))
    # s = hex_to_str(s)
    # for c in s:
    #     print (hex(ord('1'))==hex(ord('1')))
