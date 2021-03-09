# coding:utf-8
import os
import random
import time
from config.config import db
from config import constants
import copy
from tool import pathJoin
import json
class ImgHeadDao:
    
    def saveImgHead(self, imgHead):
        headNum = imgHead.get("headNum")
        if headNum:
            imgHeadDb = self.getByHeadNum(headNum)
            if imgHeadDb:
                headId = imgHeadDb.get("headId")
                db.update("imgHead", where="headId=$headId", vars={'headId':headId}, **imgHead) 
            else:
                db.insert("imgHead", **imgHead)
    
    def findByHeadNum(self, headNum):
        for head in db.select("imgHead", where="headNum = $headNum", vars={"headNum":headNum}).list():
            return head
        return None
    
    def deleteByHeadId(self, headId):
        imgNames = []
        for line in db.select("imgLine", where="headId = $headId", vars={"headId":headId}).list():
            imgNames.append(line.imgNameP)
            db.delete("ocrResult", where="lineId = $lineId", vars={"lineId":line.lineId})
        db.delete("imgLine", where="headId = $headId", vars={"headId":headId})
        db.delete("imgHead", where="headId = $headId", vars={"headId":headId})
        return imgNames
    
    def deleteByHeadIds(self, headIds):
        ids = ""
        for headId in headIds:
            ids += "," + headId
        ids = ids[1:]
        lineList = db.select("imgLine", where="headId in (" + ids + ")").list()
        for line in lineList:
            db.delete("ocrResult", where="lineId = $lineId", vars={"lineId":line.lineId})
            db.delete("imgLine", where="lineId = $lineId", vars={"lineId":line.lineId})
        db.delete("imgHead", where="headId in (" + ids + ")")
        return lineList
    
    def updateImgHeadNum(self, headId, headNum):
        dbHead = self.getById(headId)
        userForm = json.loads(dbHead.userForm)
        for f in userForm:  
            if str(f.get("groupBy"))=="1":
                f["value"] = headNum 
                break;
        if userForm:
            db.update("imgHead", where="headId=$headId", vars={"headId":headId}, **{"headNum":headNum,"userForm":json.dumps(userForm)})
        else:
            db.update("imgHead", where="headId=$headId", vars={"headId":headId}, **{"headNum":headNum})
        db.update("imgLine", where="headId=$headId", vars={"headId":headId}, **{"headNum":headNum})
    
    def findOtherHeads(self, imgHead):
        cond = {
                "userNum":imgHead.userNum,
                "belong":imgHead.belong,
                "headId":imgHead.headId
                }
        return db.select('imgHead', where="userNum=$userNum and belong = $belong and status in ('TODO','WAIT') and headId!=$headId", vars=cond, order="headOrd").list()
    
    def getById(self, headId):
        for imgHead in db.select('imgHead', where="headId=$headId", vars={"headId":headId}).list():
            return imgHead
        return None
    def getByHeadNum(self, headNum):
        for imgHead in db.select('imgHead', where="headNum=$headNum", vars={"headNum":headNum}).list():
            return imgHead
        return None
    def getMaxOrd(self, cond):
        for o in db.query("select max(headOrd) as headOrd from imgHead where userNum=$userNum and belong = $belong and status in ('TODO','WAIT')", vars=cond):
            return int(o.headOrd) if o.headOrd else 0
        return 0
    
    def getByCond(self, cond):
        for imgHead in db.select("imgHead", where="userNum = $userNum and headNum = $headNum", vars=cond, order="headOrd").list():
            return imgHead
        return None
    
    def findByCond(self, cond):
        imgHeads = db.select("imgHead", where="userNum = $userNum and belong = $belong and status in ('TODO','WAIT') and appCode=$appCode", vars=cond, order="headOrd").list()
        for imgHead in imgHeads:
            headId = imgHead.get('headId')
            for line in db.select("imgLine", where="headId=$headId", vars={'headId':headId}, order="imgOrd", limit=1).list():
                imgHead["imgPath"] = pathJoin("static/images/scan", imgHead.get("headNum"), "s_" + line.get("imgNameP")) + "?r=" + str(random.random())
                break
        return imgHeads;
    def findByPage(self, page):
        # pageNum  当前页
        # pageCount 总页数
        pageSize = page.get("pageSize", constants.pageSize)
        where = "1=1 "
        order = None
        cond = page.get("cond")
        if cond:
            if cond.get("userNum"):
                where = where + " and userNum=$userNum "
            if cond.get("noStatus"):
                where = where + " and status not in $noStatus "
            if cond.get("status"):
                where = where + " and status = $status "
            if cond.get("headNum"):
                where = where + " and headNum like '%' || $headNum  || '%' "
            if cond.get("order"):
                order = cond.get("order")
        print "where: " + str(where)
        print "cond: " + str(cond)
        count = db.select('imgHead', what="count(*) as count", where=where, vars=cond).list()[0].count
        headers = db.select('imgHead', where=where, vars=cond, limit=pageSize, offset=pageSize * (page.get("pageNum", 1) - 1), order=order,).list()
        page["pageCount"] = (count +pageSize - 1) / pageSize
        page["data"] = headers
        return page
    def saveAll(self, imgHeadList):
        from imgLineDao import ImgLineDao 
        imgLineDao = ImgLineDao()
        allLines = []
        for imgHead in imgHeadList:
            imgLines = imgHead.get("imgLines")
            # 头表
            if imgLines or imgLines is not None and len(imgLines) == 0: 
                del imgHead["imgLines"]
            headId = imgHead.get('headId')
            if headId:
                db.update('imgHead', where="headId=$headId", vars={'headId':headId}, **imgHead)
            else:
                headId = db.insert('imgHead', **imgHead)
            # 行表
            if imgLines is None or len(imgLines) == 0:
                continue
            dbLines = imgLineDao.saveAll(headId, imgLines)
            allLines.extend(dbLines)
            self.updateHeadSizeAndQty(headId)
        return allLines
    def saveHeadAndLine(self, imgHead):
        from imgLineDao import ImgLineDao 
        imgLineDao = ImgLineDao()
        allLines = []
        imgLines = imgHead.get("imgLines")
        # 头表
        if imgLines or imgLines is not None and len(imgLines) == 0: 
            del imgHead["imgLines"]
        headId = imgHead.get('headId')
        if headId:
            db.update('imgHead', where="headId=$headId", vars={'headId':headId}, **imgHead)
        else:
            headId = db.insert('imgHead', **imgHead)
        # 行表
        if imgLines is None or len(imgLines) == 0:
            return None
        dbLines = imgLineDao.saveAll(headId, imgLines)
        allLines.extend(dbLines)
        self.updateHeadSizeAndQty(headId)
        return allLines
            
    def updateHeadSizeAndQty(self, headId):
        from imgLineDao import ImgLineDao 
        imgLineDao = ImgLineDao()
        headSize = imgLineDao.getHeadSize(headId)
        imgQty = imgLineDao.getImgQty(headId)
        db.update('imgHead', where="headId=$headId", vars={'headId':headId}, **{"headSize":headSize, "imgQty":imgQty})
        
    def updateStatusByheadId(self, headId, status):
        if headId:
            db.update("imgHead", where="headId=$headId", vars={'headId':headId}, status=status)
    def update(self, imgHead):
        if imgHead and  imgHead.get("headId"):
            db.update("imgHead", where="headId=$headId", vars={'headId':imgHead.get("headId")}, **imgHead)
    def uploading2FailuerByTimeout(self):
        #24*60=1440
        db.query("update imgHead set status='FAILURE', errorMsg='超时，任务终止' where status='UPLOADING' and ((uploadSize<1024 and (julianday('now','localtime')-julianday(uploadTime))*1440>1) or (julianday('now','localtime')-julianday(uploadTime))*1440>20)")
    def addUploadSize(self, headId, uploadSize):
        if headId:
            db.query("update imgHead set uploadSize = uploadSize +"+str(uploadSize)+"  where headId = " + str(headId))
    def uploadFail(self, headId, errorMsg):
        if headId:
            db.query("update imgHead set status='FAILURE', errorMsg='"+str(errorMsg)+"'  where headId = " + str(headId))
if __name__ == "__main__":
    imgHeadDao = ImgHeadDao()
#     imgHeadDao.update({"headId":8, "status":"UPLOADING","uploadTime": time.strftime('%Y-%m-%d %H:%M:%S')})
#     imgHeadDao.addUploadSize(1, 1000)

    page = {"pageNum":1,"pageSize":10}        
    cond = {"userNum":"10000","status":"FAILURE"}
    page["cond"]=cond
    pages = imgHeadDao.findByPage(page)
    headIds = []
    for head in pages.get("data"):
        headIds.append(head.get("headId"))
    print headIds
