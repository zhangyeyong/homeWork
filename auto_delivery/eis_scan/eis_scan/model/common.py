# coding:utf-8
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
if __name__ == '__main__':
    pass