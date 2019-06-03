# coding:utf-8
import random
from config.config import db
from tool import pathJoin

class ImgLineDao:
    def updateImgHeadNum(self, headId, headNum):
        db.update("imgLine", where="headId=$headId", vars={"headId":headId}, **{"headNum":headNum})    
    def updateImgLine(self, imgLine):
        lineId = imgLine.get("lineId")
        if lineId:
            db.update("imgLine", where="lineId=$lineId", vars={'lineId':lineId}, **imgLine)
    
    def moveImgLine(self, headId, lineIds):
        if lineIds is None or len(lineIds) == 0:
            return
        retHeadId = None
        imgQty = 0
        imgOrd = self.getMaxOrd(headId)
        imgNameList = []
        ids = ""
        for lineId in lineIds:
            ids += "," + lineId
        ids = ids[1:]
        for line in db.select("imgLine", where="lineId in (" + ids + ")").list():
            if retHeadId is None:
                retHeadId = line["headId"]
            imgQty += 1
            imgOrd += 1
            line["headId"] = headId
            line["imgOrd"] = imgOrd
            db.update('imgLine', where="lineId=$lineId", vars={'lineId':line["lineId"]}, **line)
            imgNameList.append(line.get("imgNameP"))
        imgHeaderDest = self.updateHeadSizeAndQty(headId)
        imgHeaderSrc = self.updateHeadSizeAndQty(retHeadId)
        imgPathList = []
        for imgName in imgNameList:
            imgPathList.append(pathJoin(imgHeaderSrc.get("headNum"), imgName))
            imgPathList.append(pathJoin(imgHeaderSrc.get("headNum"), "s_" + imgName))
        return retHeadId, imgPathList, imgHeaderDest.get("headNum")
    
    def updateHeadSizeAndQty(self, headId):
        headSize = self.getHeadSize(headId)
        imgQty = self.getImgQty(headId)
        db.update('imgHead', where="headId=$headId", vars={'headId':headId}, **{"headSize":headSize, "imgQty":imgQty})
        for head in db.select('imgHead', where="headId=$headId", vars={'headId':headId}).list():
            return head
    
    def editImgLine(self, lineId, imgOrd, imgNameS):
        dbImgLine = db.select("imgLine", where="lineId=$lineId", vars={"lineId":lineId}).list()[0]
        if imgOrd is not None and imgOrd != "":
            imgOrd = int(imgOrd)
            dbImgOrd = dbImgLine["imgOrd"]
            headId = dbImgLine.get("headId")
            if dbImgOrd > imgOrd:
                db.query("update imgLine set imgOrd = imgOrd + 1 where headId = " + str(headId) + " and imgOrd >= " + str(imgOrd) + " and imgOrd <" + str(dbImgOrd))
            elif dbImgOrd < imgOrd:
                db.query("update imgLine set imgOrd = imgOrd - 1 where headId = " + str(headId) + " and imgOrd > " + str(dbImgOrd) + " and imgOrd <=" + str(imgOrd))
            dbImgLine["imgOrd"] = imgOrd
        if imgNameS is not None and imgNameS != "":
            dbImgLine["imgNameS"] = imgNameS
        db.update("imgLine", where="lineId=$lineId", vars={"lineId":dbImgLine.lineId}, **dbImgLine)
        return dbImgLine["headId"]
    
    def deleteByLineIds(self, headId, lineIds):
        ids = ""
        for lineId in lineIds:
            ids += "," + lineId
        ids = ids[1:]
        db.delete("ocrResult", where="lineId in (" + ids + ")")
        db.delete("imgLine", where="lineId in (" + ids + ")")
        self.initImgOrd(headId);
    
    def initImgOrd(self, headId):
        imgOrd = 0
        for line in db.select("imgLine", where="headId = $headId" , vars={"headId":headId}).list():
            imgOrd += 1
            db.update("imgLine", where="lineId=$lineId", vars={"lineId":line.lineId}, **{"imgOrd":imgOrd})
        
    def findByIds(self, lineIds):
        ids = ""
        for lineId in lineIds:
            ids += "," + lineId
        ids = ids[1:]
        return db.select("imgLine", where="lineId in (" + ids + ")").list()
    
    def deleteByHeadId(self, headId):
        # 删除识别结果和行记录
        for line in db.select('imgLine', where="headId=$headId", vars={"headId":headId}).list():
            db.delete("ocrResult", where="lineId = $lineId", vars={"lineId":line.lineId})
        db.delete("imgLine", where="headId = $headId", vars={"headId":headId})
    
    def getMaxOrd(self, headId):
        for o in db.query("select max(imgOrd) as imgOrd from imgLine where headId=$headId", vars={"headId":headId}):
            return int(o.imgOrd) if o.imgOrd else 0
        return 0
    def saveAll(self, headId, imgLines):
        lineIds = []
        dbImgLines = db.select('imgLine', where="headId=$headId", vars={"headId":headId})
        for imgLine in dbImgLines:
            lineIds.append(imgLine.get("lineId"))
        imgOrd = self.getMaxOrd(headId)
        ret = []
        for imgLine in imgLines:
            if imgLine.get("lineId") in lineIds:
                db.update('imgLine', where="lineId=$lineId", vars={'lineId':imgLine.get("lineId")}, **imgLine)
                ret.append(self.getByLineId(imgLine.get("lineId")))
            else:
                imgOrd += 1
                imgLine['imgOrd'] = imgOrd
                imgLine["headId"] = headId
                lineId = db.insert('imgLine', **imgLine)
                ret.append(self.getByLineId(lineId))
        return ret
    def getByLineId(self, lineId):
        for line in db.select('imgLine', where="lineId = $lineId", vars={"lineId":lineId}).list():
            return line
    def getHeadSize(self, headId):
        for o in db.query("select sum(imgSize) as headSize from imgLine where headId=$headId", vars={"headId":headId}):
            return int(o.headSize) if o.headSize else 0
        return 0
    def getImgQty(self, headId):
        for o in db.query("select count(*) as imgQty from imgLine where headId=$headId", vars={"headId":headId}):
            return int(o.imgQty) if o.imgQty else 0
        return 0
    def findByHeadId(self, headId):
        from imgHeadDao import ImgHeadDao 
        imgHeadDao = ImgHeadDao()
        lines = db.select('imgLine', where="headId=$headId", vars={"headId":headId}, order="imgOrd").list()
        imgHead = imgHeadDao.getById(headId)
        for line in lines:
            line['imgPathS'] = pathJoin("static/images/scan", imgHead.get("headNum"), "s_" + line.get("imgNameP")) + "?r=" + str(random.random())
            line['imgPathO'] = pathJoin("static/images/scan", imgHead.get("headNum"), line.get("imgNameP")) + "?r=" + str(random.random())
            fullName = line.get("imgNameS").split(".")
            line['imgName'] = fullName[0]
            line['imgExt'] = fullName[1]
        
        otherHeads = imgHeadDao.findOtherHeads(imgHead)
        return imgHead, otherHeads, lines if lines else []
    def getByHeadNum(self, headNum):
        return db.select('imgLine', where="headNum=$headNum", vars={"headNum":headNum}, order="imgOrd").list()
    def findByHeadId2(self, headId):
        return  db.select('imgLine', where="headId=$headId", vars={"headId":headId}, order="imgOrd").list()
    def addUploadSize(self, lineId,uploadSize):
        if lineId:
            db.query("update imgLine set uploadSize = uploadSize +"+str(uploadSize)+"  where lineId = " + str(lineId))
            db.query("update imgHead  set uploadSize = (select sum(l2.uploadSize) from imgLine l1, imgLine l2 where l1.headId=l2.headId and l1.lineId="+ str(lineId)+")  where headId = (select headId from imgLine where lineId=" + str(lineId)+")")
if __name__ == "__main__":
    imgLineDao = ImgLineDao()
    imgLineDao.uploadSize(7,100)