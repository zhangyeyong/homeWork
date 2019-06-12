# coding:utf-8
from controllers.controller import render
from libs import web
from model.configDao import ConfigDao
from config.constants import configkey
from model import common
import traceback
import json
from model.interface import GhEvsInterface
import re
from i18n.i18nU import _
class configure:
    configDao = ConfigDao()
    evsInterface = GhEvsInterface()
    def GET(self):
        configDict = self.configDao.findAllAsDict()
        print configDict
        return render.modules.configure(configDict)
    def POST(self):
        params = web.input()
        configs = {}
#         configs[configkey.IS_PASV] = params.get(configkey.IS_PASV) 
        configs[configkey.HTTP_UPLOAD_URL] = params.get(configkey.HTTP_UPLOAD_URL) 
        configs[configkey.DS_NAME] = params.get(configkey.DS_NAME) 
        configs[configkey.SERIAL_PORT] = params.get(configkey.SERIAL_PORT)
        configs[configkey.SERIAL_BAUDRATE] = params.get(configkey.SERIAL_BAUDRATE)
        #空白率
        PIXERRATIO = params.get(configkey.PIXERRATIO) 
        if PIXERRATIO:
            configs[configkey.PIXERRATIO] =PIXERRATIO
        configs[configkey.BARCODE_RULE] = params.get(configkey.BARCODE_RULE) 
        try:
            re.compile(str(params.get(configkey.BARCODE_RULE)))
        except:
            traceback.print_exc() 
            return json.dumps(common.buildFail(_(u"条码规则语法错误")))
#         
#         session = web.config._session
#         configs[configkey.COMPANY_CODE + session.user.get("userNum")] = params.get(configkey.COMPANY_CODE + session.user.get("userNum")) 
#         configs[configkey.SITE_ID + session.user.get("userNum")] = params.get(configkey.SITE_ID + session.user.get("userNum")) 
#         configs[configkey.OPERATION_TYPE_CODE + session.user.get("userNum")] = params.get(configkey.OPERATION_TYPE_CODE + session.user.get("userNum"))
        
        rtn = common.buildFail(_(u"保存失败"))
        try:
            self.configDao.save(configs)
            rtn = common.buildSuccess()
            from config import config
            config.reloadConfigDict()
        except Exception:
            traceback.print_exc()  
        return json.dumps(rtn)
