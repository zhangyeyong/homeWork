# coding:utf-8
import socket
import traceback
from thirdSoft import readU
from libs.ocr import cv2
import json
import time

def readInv(param):
    fileName = param.get("fileName")
    img = cv2.imread(fileName)
    lang = param.get("lang")
    mode = param.get("mode")
    whitelist = param.get("whitelist","")
    text = readU.get_text(img, str(lang), str(mode), str(whitelist))
    
    return text
def start(port):
    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)  
    sock.bind(('0.0.0.0', port))  
    sock.listen(5)  
    while True:  
        print "start server"
        connection, address = sock.accept()  
        t0 = time.time()
        try:  
            connection.settimeout(20)  
            buf = connection.recv(1024 * 4)  
            if buf: 
                while buf!="exit":
                    if buf.find("\"type\": \"socket\"")>0:
                        param = json.loads(buf)
                        rtn = ""
                        if param.get("method")=="ocr":
                            rtn = readInv(param)
                        connection.send(rtn)
                    buf = connection.recv(1024 * 4)  
                connection.close()
        except socket.timeout:  
            print 'time out'
        except Exception:
            traceback.print_exc()            
        print "The execution ocr takes %.3fs " % (time.time() - t0) 
            
if __name__ == "__main__":
    start(8002)
