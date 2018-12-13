# coding:utf-8
import serial
import serial.tools.list_ports
from model.serialU import ComU
import time

if __name__ == '__main__':

    # headPath  = "D:/temp/sess_store"
    #
    # import shutil
    # shutil.rmtree(headPath)

    port_list = list(serial.tools.list_ports.comports())

    # if len(port_list) <= 0:
    #     print
    #     "The Serial port can't find!"
    # else:
    #     print
    #     port_list
    s = "\x7A\x79"
    # s = "open"
    comU = ComU()
    # comU.reloadCom()
    comU.sendData(s)

    starttime = time.time()
    while True:
        comData = comU.recvDate()
        # 一分钟还未返回信息，直接退出

        if time.time() - starttime > 60:
            break
        time.sleep(0.5)
