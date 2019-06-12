# coding:utf-8
import common
fileName = common.rootPath + "/data/log.txt"
vlog = {}
import os
import sys
import time
ABSPATH = os.path.abspath(sys.argv[0])
ABSPATH = os.path.dirname(ABSPATH) + "/"
def append(id, key, execTime):
    vlog["id"] = id
    vlog[key] = execTime
def write():
    try:
        vlog["date"] = time.strftime('%Y-%m-%d %H:%M:%S')
        line = str(vlog)
        vlog.clear()
        fileHandle = open (fileName, "a")
        fileHandle.write(line + "\n")
    except IOError:
        pass
    finally:         
        fileHandle.close() 
def read():
    vList = []
    try:
        fileHandle = open (fileName)
        fileList = fileHandle.readlines() 
        for fileLine in fileList[::-1]: 
            vList.append(eval(fileLine))
        return vList
    except IOError:
        pass
    finally:         
        fileHandle.close()
         
def printPath():
    print ABSPATH
