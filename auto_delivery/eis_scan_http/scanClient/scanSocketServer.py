# coding:utf-8
import scanBase
import socket
import json
from urllib import unquote
import traceback
import time
from logger import Logger

def dealsocket(jsonStr):
    param = json.loads(jsonStr)
    if param.get("method") == "scan":
        import config
        if param.get("scanPath"):
            config.scanPath = param.get("scanPath")
        return scan(param)
    elif param.get("method") == "getDsList":
        return getDsList()
    else:
        return buildFail("no effective method")


def str2bool(v):
    return v.lower() in ("yes", "true", "t", "1")


def getDsList():
    import twain
    rtn = None
    try:
        rtn = scanBase.getDsList()
    except twain.excTWCC_NODS:
        return buildFail("Can not find a scanner")
    return buildSuccess("getDsList success", rtn)


def isAlive():
    return buildSuccess("isAlive success")


def test():
    return buildSuccess("isAlive success", {"username": "张业勇", "age": 20})


def scan(paramDict):
    ds_name = paramDict.get("ds_name")
    temp = getDsList()
    print temp
    if temp.get("isSuccess"):
        if ds_name not in temp.get("data"):
            return buildFail("Could not find the scanner:%s" % ds_name)
    else:
        return buildFail(temp.get("info"))
    t1 = time.time()
    # res = scanBase.scan(ds_name, paramDict)
    t2 = time.time()
    print u"scan time：%d" % (t2 - t1)
    log.debug(u"scan time：%d" % (t2 - t1))
    print "-----------res-----------------"
    res = [
               {"path":"D:/temp/image/1.jpg"},
               {"path":"D:/temp/image/2.jpg"},
               {"path":"D:/temp/image/3.jpg"},
    #            {"path":"D:/temp/image/4.jpg"},
    #            {"path":"D:/temp/image/5.jpg"},
    #            {"path":"D:/temp/image/6.jpg"},
    #            {"path":"D:/temp/image/7.jpg"},
               ]
    log.debug("scan: %s" % res)
    return buildSuccess("scan success", res)


def urlToDict(url):
    url = unquote(url)
    params = {}
    try:
        paramUrl = url[2:]
        for paramStr in paramUrl.split('&'):
            tempArr = paramStr.split("=")
            params[tempArr[0]] = tempArr[1]
    except Exception:
        pass
    return params


def buildFail(info, data=None):
    rtn = {}
    rtn["isSuccess"] = False
    rtn["info"] = info
    rtn["data"] = data
    return rtn


def buildSuccess(info=None, data=None):
    rtn = {}
    rtn["isSuccess"] = True
    rtn["info"] = info
    rtn["data"] = data
    return rtn


def buildHtml():
    html = ''' 
    <html>
    <head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    </head>
    <body>
    wetuiop
    </body>
    </html>
    '''
    return html


def send_http(connection, html):
    connection.send("HTTP/1.1 200 OK\r\n")
    connection.send("Content-Type: text/html;charset=UTF-8\r\n")
    connection.send("\r\n")
    connection.send(html)
    connection.send("\r\n")


def start(port):
    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    sock.bind(('0.0.0.0', port))
    sock.listen(5)
    while True:
        print u"start server"
        log.debug(u"start server")
        connection, address = sock.accept()
        try:
            connection.settimeout(1)
            buf = connection.recv(1024 * 4)
            if buf:
                if buf.find("\"type\": \"socket\"") > 0:
                    rtn = dealsocket(buf)
                    connection.send(json.dumps(rtn))
                    connection.close()
                    continue
                firstLine = buf.split('\r\n')[0]
                url = firstLine.split(" ")[1]
                paramDict = urlToDict(url)
                print paramDict
                log.debug("start: %s" % paramDict)
                if not paramDict or len(paramDict) < 1:
                    print u"url error"
                    log.debug(u"url error")
                    connection.send("url error")
                    connection.close()
                    continue
                method = paramDict.get("method", None)
                if not method:
                    print u"not assign method"
                    log.debug(u"not assign method")
                    connection.send("not assign method")
                    connection.close()
                    continue
                callback = paramDict.get("callback", None)  # 获取回调函数地址
                if not callback:
                    print u"not assign callback"
                    log.debug(u"not assign callback")
                    connection.send("not assign callback")
                    connection.close()
                    continue
                rtn = None
                try:
                    if method == "scan":
                        rtn = scan(paramDict)
                    elif method == "getDsList":
                        rtn = getDsList()
                    elif method == "isAlive":
                        rtn = isAlive()
                    elif method == "test":
                        rtn = test()
                except Exception:
                    print traceback.format_exc()
                    rtn = buildFail("Scan Error,method:%s" % method)
                t1 = time.time()
                jsonStr = json.dumps(rtn)  # 返回的json
                print jsonStr
                log.debug(u"start: %s" % jsonStr)
                text = callback + "(" + jsonStr + ")"
                send_http(connection, text)
                connection.close()
                t2 = time.time()
                print u"send mes %d" % (t2 - t1)
                log.debug(u"send mes %d" % (t2 - t1))
            else:
                connection.send('please go out!')
                connection.close()
        except socket.timeout:
            print u'time out'
            log.debug(u'time out')
        connection.close()


import logging.config

logging.config.fileConfig("logging.conf")
# create logger
logger = logging.getLogger("Main")


class LogStdout(object):
    '''File-like object for sending stdout output to a logger.'''

    def __init__(self, logger, level=logging.DEBUG):
        # Set logger level
        if level == logging.DEBUG:
            self.logger = logger.debug
        elif level == logging.CRITICAL:
            self.logger = logger.critical
        elif level == logging.ERROR:
            self.logger = logger.warning
        elif level == logging.WARNING:
            self.logger = logger.warning
        elif level == logging.INFO:
            self.logger = logger.info

    def write(self, info):
        '''Writes non-whitespace strings to logger.'''
        if info.lstrip().rstrip() != '': self.logger(info)


if __name__ == "__main__":
    log = Logger(logger="scanSocketServer").getlog()
    log.debug("Start 8001")
    start(8001)
#     paramDict = {'_': '1412065483163', 'pixel_type': 'color',  'duplex': 'False', 'ds_name': 'FUJITSU fi-6130Zdj', 'callback': 'success_jsonpCallback', 'isDefault': 'True', 'compressionratio': '100', 'dpi': '200', 'threshold': '128', 'discardblankpages': 'False', 'method': 'scan', 'contrast': '0', 'imageFormat': 'JPG'}
#     paramDict = {'ds_name': 'FUJITSU fi-6130Zdj','contrast': '0'}
#     scan(paramDict)
#     url = "GET /?ds_name=FUJITSU%20fi-6140dj%20&callback=success_jsonpCallback&_=1407313117542 HTTP/1.1"
#     url = url.split(" ")[1]
