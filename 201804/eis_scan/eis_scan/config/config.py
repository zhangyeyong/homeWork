# coding:utf-8
# 配置，主要是站点、文件系统路径、URL路由以及全局环境的配置
import os
from libs import web
import sys
curPath = os.path.abspath(os.path.dirname(__file__))
n = curPath.rindex('config')
# 根路径
rootPath = curPath[0:n].decode(sys.getfilesystemencoding())
pathList = os.path.normpath(rootPath).split("\\")
temp = ""
for i in range(1,len(pathList)):
    temp = os.path.join(temp,"\"" + pathList[i] +"\"")
rootPathCmd = pathList[0]+"\\"+temp

scanPath = os.path.join(rootPath , "static/images/scan/")
dbPath = os.path.join(rootPath, "data", "data.db")
db = web.database(dbn="sqlite", db=dbPath)

imgWidth = 190

appName = None
def getParentPath(strPath):  
    if not strPath:  
        return None;  
    lsPath = os.path.split(strPath);  
    if lsPath[1]:  
        return lsPath[0];  
    lsPath = os.path.split(lsPath[0]);  
    return lsPath[0];
if not appName: 
    import ConfigParser
    import codecs
    config = ConfigParser.ConfigParser()
    config.readfp(codecs.open(os.path.join(getParentPath(rootPath),'cfg.ini'),"r","cp936"))
    appName = config.get("app","name")
configDict = None 
def getConfigDict():
    global configDict
    if not configDict:
        from model.configDao import ConfigDao
        configDao = ConfigDao()
        configDict = configDao.findAllAsDict()
    return configDict
def reloadConfigDict():
    global configDict
    from model.configDao import ConfigDao
    configDao = ConfigDao()
    configDict = configDao.findAllAsDict()
def getIS_PASV():
    return getConfigDict().get('IS_PASV')=='true'
if __name__ == "__main__":
    print appName
#     ret = ""
#     pathList = os.path.normpath(rootPath).split("\\")
#     print pathList
#     for i in range(1,len(pathList)):
#         ret = os.path.join(ret,"\"" + pathList[i] +"\"")
#     print pathList[0]+"\\"+ret
#     print rootPath
    pass
