# coding:utf-8
import os
import common
fileName = common.rootPath + "/data/data.txt"
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
def readById(id):
    try:
        fileHandle = open (fileName)
        fileList = fileHandle.readlines() 
        for fileLine in fileList: 
            index = fileLine.find("'id': '%s'" % id)
            if index != -1:            
                return eval(fileLine)
        return {}
    except IOError:
        pass
    finally:         
        fileHandle.close() 
def appendInvoice(v):
    try:
        fileHandle = open (fileName, "a")
        fileHandle.write(str(v) + "\n")
    except IOError:
        pass
    finally:         
        fileHandle.close() 
def getNextId():
    id = 1
    try:
        fileHandle = open (fileName, "r")
        fileList = fileHandle.readlines() 
        if len(fileList) > 0:
            id = int(eval(fileList[-1]).get("id")) + 1
        return id
    except IOError:
        pass
    finally:         
        fileHandle.close() 
