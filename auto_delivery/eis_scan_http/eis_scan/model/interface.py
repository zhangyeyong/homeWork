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
            serverUrl = serverUrl + configDict.get(constants.configkey.VIRTUAL_PATH) + "?wsdl"
            client = Client(serverUrl)  # 测试服务是否启动
    except Exception:
        pass
    return client


# def execTime(func):
#     def __decorator(*args, **args2):
#         t0 = time.time()
#         print "@%s, {%s} start" % (time.strftime("%X", time.localtime()), func.__name__)
#         back = func(*args, **args2)
#         print "@%s, {%s} end" % (time.strftime("%X", time.localtime()), func.__name__)
#         print "@%.3fs taken for {%s}" % (time.time() - t0, func.__name__)
#         return back
#     return __decorator
def execRMI(func):
    def __decorator(*args, **args2):
        return func(*args, **args2)

    #         print "The execution method {%s}   params:%s" % (func.__name__,str(args))
    #         client = getClient()
    #         if not client:
    #             return common.buildFail(_("连接服务器失败"))
    #         else:
    #             t0 = time.time()
    #             rtn = None
    #             try:
    #                 rtn = func(*args, **args2)
    #             except Exception, e:
    #                 print e
    #                 traceback.print_exc()
    #                 return common.buildFail("execRMI  {%s} failure." % func.__name__)
    #             print "The execution method {%s} takes %.3fs " % (func.__name__, time.time() - t0)
    #             print "result:", rtn
    #             return rtn
    return __decorator


class GhEvsInterface:
    @execRMI
    def IsLogin(self, ticket):
        #         return common.buildSuccess(data=client.service.IsLogin(ticket))
        if ticket == "10000":
            return common.buildSuccess(data=True)
        else:
            return common.buildSuccess(data=False)

    @execRMI
    def Logout(self, ticket):
        #         return common.buildSuccess(data=client.service.Logout(ticket))
        return common.buildSuccess(data=True)

    @execRMI
    def Login(self, userCd, pwd, lang=None):
        #         rtnJson = client.service.Login(userCd, pwd, lang)
        rtnJson = '''
            {
            "code":"S",
            "errorMsg":"login failure",
            "ticket":"10000",
            "icon":{"width":100,"high":0},
            "appList":[
                    {
                    "appCode":"eis",
                    "appName":"影像系统",
                    "form":[
                            {
                            "label":"隐藏",
                            "type":"hidden",
                            "name":"hidden1",
                            "value":"h1",
                            "required":false,
                            "items":"",
                            "groupBy":0,
                            "autoOcr":"N"
                            },
                            {
                            "label":"报账单号",
                            "type":"input",
                            "name":"headNum",
                            "value":"h0001",
                            "required":true,
                            "items":"",
                            "groupBy":1,
                            "autoOcr":"Y"
                            },
                            {
                            "label":"结算单位",
                            "type":"select",
                            "name":"companyCode",
                            "required":true,
                            "items":[
                                        {
                                            "label":"company1",
                                            "value":"c1"
                                        },
                                        {
                                            "label":"company2",
                                            "value":"c2"
                                        },
                                        {
                                            "label":"company3",
                                            "value":"c3"
                                        }
                                    ],
                            "groupBy":0,
                            "autoOcr":"N"
                            }
                        ]
                    },
                    {
                    "appCode":"cot",
                    "appName":"合同系统",
                    "form":[
                            {
                            "label":"隐藏",
                            "type":"hidden",
                            "name":"hidden21",
                            "value":"h21",
                            "required":false,
                            "items":"",
                            "groupBy":0,
                            "autoOcr":"N"
                            },
                            {
                            "label":"合同编号",
                            "type":"input",
                            "name":"cotNum",
                            "value":"c0001",
                            "required":true,
                            "items":"",
                            "groupBy":1,
                            "autoOcr":"N"
                            },
                            {
                            "label":"供应商",
                            "type":"select",
                            "name":"supplier",
                            "required":true,
                            "items":[
                                        {
                                            "label":"supplier1",
                                            "value":"s1"
                                        },
                                        {
                                            "label":"supplier2",
                                            "value":"s2"
                                        },
                                        {
                                            "label":"supplier3",
                                            "value":"s3"
                                        }
                                    ],
                            "groupBy":0,
                            "autoOcr":"N"
                            }
                        ]
                    }
                ],
            "scanConfig":{"imageFormat":"jpg","dpi":200},
            "ftpMap":{"2000":{"ftpIp":"10.18.221.61","port":"21","userName":"mes","password":"mes"},"2001":{"ftpIp":"10.18.221.60","port":"21","userName":"mes","password":"mes123"}},
            "uploadTime":[{"startTime":"00:00:00","endTime":"03:00:00"},{"startTime":"23:00:00","endTime":"23:30:00"}]
            }
        '''
        rtn = json.loads(rtnJson)
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
        # rtnJson = client.service.FtpInfo(ticket, taskType, jsonParam, lang=None)
        print jsonParam
        rtnJson = '''
            {
            "ftpId":2000,
            "status":"NORMAL",
            "reason":"不能上传的原因",
            "imagePath":"/zyy/image/2015/",
            "iconPath":"/zyy/icon/2015/"
            }
        '''
        rtn = json.loads(rtnJson)
        return common.buildSuccess(data=rtn)

    @execRMI
    def UploadLog(self, ticket, taskType, jsonParam):
        taskType = formatTaskType(taskType)
        # rtnJson = client.service.UploadLog(ticket, taskType, jsonParam)
        print jsonParam
        rtnJson = '''
            {
                "code":"S",
                "errorMsg":"失败原因"
            }
        '''
        rtn = json.loads(rtnJson)
        return common.buildSuccess(data=rtn)

    @execRMI
    def GetServCmdInfo(self, ticket, taskType, pageInfo, jsonParam):
        taskType = formatTaskType(taskType)
        # rtnJson = client.service.GetServCmdInfo(ticket, taskType, pageInfo, jsonParam)
        print "type:%s, jsonParam:%s" % (type, str(jsonParam))
        rtnJson = '''
            {
                "pageInfo":{
                        "pageNum":1,
                        "totalPage":1,
                        "pageSize":10

                    },
                "data":[
                        {"status":"NORMAL","appCode":"eis","remark":"影像不清","form":{"headNum":"B0001","companyCode":"c2"},"ftpId":"2000","imageList":["zyy/image/2015/1.jpg", "zyy/image/2015/2.jpg"],"iconList":["zyy/icon/2015/1.jpg", "zyy/icon/2015/2.jpg"]},
                        {"status":"NORMAL","appCode":"eis","remark":"影像不全","form":{"headNum":"B0002","companyCode":"c1"},"ftpId":"2000","imageList":["zyy/image/2015/3.jpg", "zyy/image/2015/4.jpg"],"iconList":["zyy/icon/2015/3.jpg", "zyy/icon/2015/4.jpg"]}
                    ]
            }
        '''
        rtn = json.loads(rtnJson)
        return common.buildSuccess(data=rtn)


if __name__ == '__main__':
    # note  测试完了后 需要将 execRMI(func): def __decorator(*args, **args2)注释的内容放开
    ghEvsInterface = GhEvsInterface()
    # 测试Login
    print "-----------test Login----------------"
    rtn = ghEvsInterface.Login("111", "8888", "zh_cn")
    print rtn.get("isSuccess")
    print rtn.get("data")

    # 测试ftp
    print "-----------test FtpInfo----------------"
    jsonParam = '''{app:eis,form:{"billName":"0001"}}'''
    ticket = "10000"
    rtn = ghEvsInterface.FtpInfo(ticket, jsonParam)
    print rtn.get("isSuccess")
    print rtn.get("data")
    # 测试GetServCmdInfo
    print "-----------test GetServCmdInfo----------------"
    jsonParam = '''{app:eis,form:{"billName":"0001"}}'''
    ticket = "10000"
    type = "backTask"
    pageinfo = '''
        {
            pageNum:1,
            pageSize:10
        }
    '''
    rtn = ghEvsInterface.GetServCmdInfo(ticket, type, pageinfo, jsonParam)
    print rtn.get("isSuccess")
    userForm = rtn.get("data").get("data")[0].get("form")
    print userForm

    print json.dumps(json.loads('{"status":"NORMAL"}'))
    pass
