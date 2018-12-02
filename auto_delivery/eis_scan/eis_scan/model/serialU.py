# coding:utf-8
from model import common
import traceback
import serial
import sys
import time

if sys.getdefaultencoding() != 'utf-8':
    reload(sys)
    sys.setdefaultencoding('utf-8')


class ComU:
    def __init__(self, port="COM1", baudrate=9600):
        # self.ser = serial.Serial(port, baudrate, timeout=0.5)
        self.port = port
        self.baudrate = baudrate

    def reloadCom(self):

        rtn = common.buildFail(u"初始串口失败！ port=COM1, baudrate=9600", "")
        try:
            if self.ser is not None:
                self.ser.close();
            #             ser = serial.Serial("COM3", 9600, timeout=0.5)
            ser = serial.Serial(self.port, self.baudrate, timeout=0.5)
            rtn = common.buildSuccess(u"初始串口成功", "")
        except Exception:
            traceback.print_exc()
        rtn["data"] = {"port": self.port, "baudrate": self.baudrate}
        return rtn

    def closeCom(self):

        rtn = common.buildFail(u"关闭串口失败！")
        try:
            if self.ser is not None and self.ser.isOpen():
                self.ser.close()
                self.ser = None
            rtn = common.buildSuccess(u"关闭串口成功", "")
        except Exception:
            traceback.print_exc()
        return rtn

    def sendData(self, dataStr):
        self.ser.write(dataStr)
        return common.buildSuccess("", dataStr)

    def recvDate(self):
        rtn = common.buildFail(u"读串数据失败", "")
        try:
            comData = self.ser.read(30)
            if None != comData and len(comData) > 0:
                rtn = common.buildSuccess("", comData)
            else:
                rtn = common.buildSuccess("", "")
        except Exception:
            traceback.print_exc()
        return rtn

    def sendAndWaitRecvDate(self, dataStr):
        rtn = common.buildFail(u"读串数据失败", "")
        try:
            self.ser = serial.Serial(self.port, self.baudrate, timeout=0.5)
            self.ser.write(dataStr)
            comData = self.ser.readline()
            starttime = time.time()
            while not comData.strip():
                comData = self.ser.readline()
                # 一分钟还未返回信息，直接退出
                if time.time() - starttime > 60:
                    break
                time.sleep(0.5)

            if comData is not None and len(comData) > 0:
                rtn = common.buildSuccess("", comData)
            else:
                rtn = common.buildFail(u"未读到串数据", "")
        except Exception:
            traceback.print_exc()
        return rtn


if __name__ == '__main__':
    comU = ComU()
    rtn = comU.sendAndWaitRecvDate("zyy")
    print("the recv data is ",rtn)
    comU.closeCom()
    # import serial.tools.list_ports
    #
    # port_list = list(serial.tools.list_ports.comports())
    # print(port_list[0])
    # if len(port_list) <= 0:
    #     print
    #     "The Serial port can't find!"
    # else:
    #     print
    #     len(port_list)
