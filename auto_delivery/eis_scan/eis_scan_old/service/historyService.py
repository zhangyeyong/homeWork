# coding:utf-8
from controllers.controller import render
from libs import web
from config import constants
class history:
    def GET(self):   
        i = web.input()
        session = web.config._session
        cond = {"userCd":session.user.get("userCd"),"order":"headerId Desc","noStatus":["TODO","WAIT"]}
        if  i.get("custName") and i.get("custName").strip()!="":
            cond["custName"]=i.get("custName").strip()
        if  i.get("uploadTimeStart") and i.get("uploadTimeStart").strip()!="":
            cond["uploadTimeStart"]=i.get("uploadTimeStart").strip()
        if i.get("uploadTimeEnd") and i.get("uploadTimeEnd").strip()!="":
            cond["uploadTimeEnd"]=i.get("uploadTimeEnd").strip()
        pageNum = 1
        if not i.get("pageNum") or i.get("pageNum").strip()=="":
            pageNum = 1
        else:
            pageNum = int(i.get("pageNum"))
        page = {"pageNum":pageNum,"cond":cond}
        page = self.ImgHeadDao.findByPage(page)
        page["headStatus"] = constants.headStatusShow 
        return render.modules.history(page)
    def POST(self):
        return self.GET()
if __name__ == '__main__':
    import time
    print time.strftime("%J",time.strptime("2014-08-14", "%Y-%m-%d"))  