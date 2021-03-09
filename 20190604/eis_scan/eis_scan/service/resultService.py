# coding:utf-8
from libs import web
from controllers.controller import render
from model.imgHeadDao import ImgHeadDao
from config import constants
class resultQuery:
    imgHeadDao = ImgHeadDao()
    def GET(self):   
        i = web.input()
        session = web.config._session
        cond = {"order":"headId Desc",'userNum':session.user.get("userNume")}
        if  i.get("headNum") and i.get("headNum").strip()!="":
            cond["headNum"]=i.get("headNum").strip()
        if  i.get("status") and i.get("status").strip()!="":
            cond["status"]=i.get("status").strip()
        else:
            cond["noStatus"]=["TODO","WAIT"]
            
        pageNum = 1
        if not i.get("pageNum") or i.get("pageNum").strip()=="":
            pageNum = 1
        else:
            pageNum = int(i.get("pageNum"))
        page = {"pageNum":pageNum,"cond":cond}
        pageSize = i.get("pageSize")
        if pageSize:
            page["pageSize"]=int(pageSize)    
        page = self.imgHeadDao.findByPage(page)
        page["headStatus"] = constants.headStatusShow 
        return render.modules.result(page)
    def POST(self):
        self.updateTimeoutTask()
        return self.GET()
    def updateTimeoutTask(self):
        self.imgHeadDao.uploading2FailuerByTimeout()
