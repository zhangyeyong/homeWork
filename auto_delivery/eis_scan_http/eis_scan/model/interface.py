# coding:utf-8
'''
Created on 2014-9-3

@author: ZhangYeyong
'''
# 调用外部接口路径
from config import constants
from suds.client import Client
import time
import traceback
import hashlib
import common
from i18n.i18nU import _
import json

client = None
CODE_SUCCESS = "S"
CODE_FAIL = "F"


def formatTaskType(taskType):
    if taskType == constants.belongType.DAILY_SCAN:
        return constants.taskType.NORMAL
    elif taskType == constants.belongType.APPRAISE_TASK:
        return constants.taskType.BACKTASK
    elif taskType == constants.belongType.NO_TASK:
        return constants.taskType.NOTASK
    else:
        return taskType


def getClient():
    global client
    try:
        if not client:
            from model.configDao import ConfigDao
            configDao = ConfigDao()
            configDict = configDao.findAllAsDict()
            serverUrl = "http://" + configDict.get(constants.configkey.EIS_IP)
            if configDict.get(constants.configkey.EIS_PORT) and configDict.get(
                    constants.configkey.EIS_PORT).strip() != "":
                serverUrl = serverUrl + ":" + configDict.get(constants.configkey.EIS_PORT)
            serverUrl = serverUrl + configDict.get(constants.configkey.VIRTUAL_PATH)
            if not serverUrl.upper().endswith("?WSDL"):
                serverUrl += "?wsdl"
            client = Client(serverUrl)  # 测试服务是否启动
    except Exception:
        pass
    return client


def execTime(func):
    def __decorator(*args, **args2):
        t0 = time.time()
        print "@%s, {%s} start" % (time.strftime("%X", time.localtime()), func.__name__)
        back = func(*args, **args2)
        print "@%s, {%s} end" % (time.strftime("%X", time.localtime()), func.__name__)
        print "@%.3fs taken for {%s}" % (time.time() - t0, func.__name__)
        return back

    return __decorator


def execRMI(func):
    def __decorator(*args, **args2):
        print "The execution method {%s}   params:%s" % (func.__name__, str(args))
        client = getClient()
        if not client:
            return common.buildFail(_("连接服务器失败"))
        else:
            t0 = time.time()
            rtn = None
            try:
                rtn = func(*args, **args2)
            except Exception, e:
                print e
                traceback.print_exc()
                return common.buildFail("execRMI  {%s} failure." % func.__name__)
            print "The execution method {%s} takes %.3fs " % (func.__name__, time.time() - t0)
            print "result:", rtn
            return rtn

    return __decorator


class GhEvsInterface:
    @execRMI
    def IsLogin(self, ticket):
        return common.buildSuccess(data=client.service.IsLogin(ticket))

    @execRMI
    def Logout(self, ticket):
        return common.buildSuccess(data=client.service.Logout(ticket))

    @execRMI
    def Login(self, userCd, pwd, lang=None):
        rtnJson = client.service.Login(userCd, pwd, lang)
        rtn = json.loads(rtnJson)
        print json.dumps(rtn, indent=4, ensure_ascii=False)
        if rtn:
            if rtn.get("code") == CODE_SUCCESS:
                appList = rtn.get("appList")
                for app in appList:
                    for f in app.get("form"):
                        if int(f.get("groupBy", 0)) == 1:
                            app["groupFieldName"] = f.get("name")
                            app["groupFieldLabel"] = f.get("label")
                return common.buildSuccess(data=rtn)
            else:
                return common.buildFail(info=rtn.get("errorMsg"))
        else:
            return common.buildFail(info="返回值异常")

    @execRMI
    def FtpInfo(self, ticket, taskType, jsonParam):
        taskType = formatTaskType(taskType)
        rtnJson = client.service.FtpInfo(ticket, taskType, jsonParam)
        print jsonParam
        rtn = json.loads(rtnJson)
        return common.buildSuccess(data=rtn)

    @execRMI
    def UploadLog(self, ticket, taskType, jsonParam):
        taskType = formatTaskType(taskType)
        rtnJson = client.service.UploadLog(ticket, taskType, jsonParam)
        print jsonParam
        rtn = json.loads(rtnJson)
        return common.buildSuccess(data=rtn)

    @execRMI
    def GetServCmdInfo(self, ticket, taskType, pageInfo, jsonParam):
        taskType = formatTaskType(taskType)
        rtnJson = client.service.GetServCmdInfo(ticket, taskType, pageInfo, jsonParam)
        rtn = json.loads(rtnJson)
        print json.dumps(rtn, indent=4, ensure_ascii=False)
        return common.buildSuccess(data=rtn)


if __name__ == '__main__':
    # note  测试完了后 需要将 execRMI(func): def __decorator(*args, **args2)注释的内容放开
    ghEvsInterface = GhEvsInterface()
    #     print ghEvsInterface.IsLogin(12955)

    #     # 测试Login
    #     print "-----------test Login----------------"
    #     password = hashlib.md5("8888").hexdigest().upper()
    #     rtn = ghEvsInterface.Login("liyun.ah", password , "zh_cn")
    #     print rtn.get("isSuccess")
    #     print rtn.get("info")
    #     print rtn.get("data")
    #
    #     ticket = rtn.get("data").get("ticket")
    #     ticket = 12963
    #     # 测试ftp
    #     print "-----------test FtpInfo----------------"
    #     jsonParam = {'appCode': 'EIS', 'form': {'imageNumber': 'h005', 'siteId': '10024'}}
    #     jsonParamStr = json.dumps(jsonParam)
    #     rtn = ghEvsInterface.FtpInfo(ticket, "NORMAL", jsonParamStr)
    #     print rtn.get("isSuccess")
    #     print rtn.get("info")
    #     print rtn.get("data")
    #     # 测试GetServCmdInfo
    #     print "-----------test GetServCmdInfo----------------"
    #     type = "backTask"
    #     pageinfo = '''
    #         {
    #             pageNum:1,
    #             pageSize:10
    #         }
    #     '''
    #     rtn = ghEvsInterface.GetServCmdInfo(ticket, type, pageinfo, jsonParam)
    #     print rtn.get("isSuccess")
    #     print rtn.get("info")
    #     print rtn.get("data")
    pass
