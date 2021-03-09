# coding:utf-8
# 服务模块，初始化系统，处理URL请求逻辑
from libs import web
from libs.web.utils import Storage
from controllers.controller import render
from model.ocrResultDao import OcrResultDao
from model.imgLineDao import ImgLineDao

class recognitionQuery:
    ocrResultDao = OcrResultDao()
    def GET(self):
        session = web.config._session
        userNum = session.user.get("userNum")
        page = {
                "cond": {
                      "userNum":userNum,
                      },
                "pageNum":1,
               }
        recognition = session.get("recognition")
        if recognition:
            page["pageNum"] = recognition.get("pageNum")
            page["cond"]["headNum"] = recognition.get("headNum")
            page["cond"]["isChecked"] = recognition.get("isChecked")
        ret = self.ocrResultDao.findByPage(page)
        return render.modules.recognition(Storage(ret))
    def POST(self):
        i = web.input()
        session = web.config._session
        userNum = session.user.get("userNum")
        pageNum = int(i.pageNum) if i.pageNum else 1
        page = {
                "cond": {
                      "headNum":i.headNum,
                      "userNum":userNum,
                      "isChecked":i.isChecked
                      },
                "pageNum":pageNum,
               }
        session['recognition'] = {
                                "headNum":i.headNum,
                                "isChecked":i.isChecked,
                                "pageNum":pageNum,
                                }
        ret = self.ocrResultDao.findByPage(page)
        return render.modules.recognition(Storage(ret))
    
class recognitionDetail:
    ocrResultDao = OcrResultDao()
    def GET(self, lineId):
        ret = self.ocrResultDao.getByLineId(lineId)
        return render.modules.recognitionDetail(ret)
    def POST(self, lineId):
        i = web.input()
        ocrResult = {}
        ocrResult[i['code']] = i['val']
        ocrResult[i['code'] + 'R'] = '0'
        ocrResult["resultId"] = i["resultId"]
        self.ocrResultDao.update(ocrResult)
        return True
    
class confirmRecognition:
    imgLineDao = ImgLineDao()
    def GET(self, lineId):
        imgLine = {
                    "lineId":lineId,
                    "isChecked":"1",
                    }
        self.imgLineDao.updateImgLine(imgLine)
        return web.seeother("/recognition")
