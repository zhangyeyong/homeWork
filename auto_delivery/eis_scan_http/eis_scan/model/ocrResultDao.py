# coding:utf-8
from config.config import db
from config import constants
from config.constants import ocrResultType 
class OcrResultDao:
    
    def findByPage(self, page):
        pageSize = page.get("pageSize", constants.pageSize)
        sql = " FROM imgLine JOIN ocrResult on imgLine.lineId=ocrResult.lineId where 1=1"
        order = None
        cond = page.get("cond")
        if cond:
            if cond.get("userNum"):
                sql = sql + " and imgLine.userNum = $userNum "
            if cond.get("isChecked"):
                sql = sql + " and imgLine.isChecked = $isChecked "
            if cond.get("headNum"):
                sql = sql + " and imgLine.headNum like '%' || $headNum  || '%' "
            if cond.get("order"):
                order = cond.get("order")
        print "where: " + str(sql)
        print "cond: " + str(cond)
        count = db.query('select count(*) as count ' + sql, vars=cond).list()[0].count/2
        offset = pageSize * (page.get("pageNum", 1) - 1)
        pRet = db.query('select * ' + sql + " and ocrType='PROGRAM'" + " limit " + str(offset) + "," + str(pageSize), vars=cond).list()
        cRet = db.query('select * ' + sql + " and ocrType='CHECK'" + " limit " + str(offset) + "," + str(pageSize), vars=cond).list()
        cRetDict = {}
        for ocr_result in cRet:
            cRetDict[ocr_result['lineId']] = ocr_result;
        for ocr_result in pRet:
            cR = cRetDict[ocr_result['lineId']]
            for key, val in ocr_result.items():
                if key[-1] == 'R' and val == '0':
                    ocr_result[key[:-1] + "C"] = 'label label-warning'
            for key, val in cR.items():
                if key[-1] == 'R' and val == '0':
                    ocr_result[key[:-1]] = cR[key[:-1]]
                    ocr_result[key[:-1] + "C"] = 'label label-danger'
        
        page["pageCount"] = (count +pageSize - 1) / pageSize
        page["data"] = pRet
        return page
    
    def getById(self, resultId):
        for result in db.select("ocrResult", where="resultId=$resultId", vars={"resultId":resultId}):
            return result
    def getByLineId(self, lineId):
        results = db.select('ocrResult', where="lineId=$lineId", vars={'lineId':lineId}).list()
        if not results or len(results)<2:
            return None
        programResult = {}
        checkResult = {}
        for ret in results:
            if ret.ocrType == ocrResultType.PROGRAM:
                programResult = ret
            else:
                checkResult = ret
        programResult['resultId'] = checkResult['resultId']
        for key, val in programResult.items():
            if key[-1] == 'R' and val == '0':
                programResult[key[:-1] + 'C'] = 'label-warning'
        for key, val in checkResult.items():
            if key[-1] == 'R' and val == '0':
                programResult[key[:-1]] = checkResult[key[:-1]]
                programResult[key[:-1] + 'C'] = 'label-danger'
        return programResult    
    def saveOcrResult(self, ocrResult):
        return db.insert("ocrResult", **ocrResult)
    def saveOrUpdateOcrResult(self, ocrResult):
        results = None
        if ocrResult and ocrResult.get('lineId') and ocrResult.get('ocrType'):
            results = db.select('ocrResult', where="lineId=$lineId and ocrType=$ocrType", vars={'lineId':ocrResult.get('lineId'), 'ocrType':ocrResult.get('ocrType')}).list()
        else:
            return None
        if results and len(results) > 0:
            ocrResult['resultId'] = results[0].get('resultId')
            self.update(ocrResult)
        else:    
            db.insert("ocrResult", **ocrResult)
    def update(self, ocrResult):
        resultId = ocrResult.get("resultId")
        if resultId:
            db.update("ocrResult", where="resultId=$resultId", vars={'resultId':resultId}, **ocrResult)
