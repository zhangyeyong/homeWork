# coding:utf-8
# 识别增值税发票后台线程
import os
import threading
import invoiceService
from libs.ocr import validateInv
from ocrResultDao import OcrResultDao
from config.config import scanPath
import traceback
class OcrThread(threading.Thread):  # The timer class is derived from the class threading.Thread  
    ocrResultDao = OcrResultDao()
    def __init__(self, imgLines):  
        threading.Thread.__init__(self)  
        self.imgLines = imgLines  
        
    def run(self):  # Overwrite run() method, put what you want the thread do here  
        for imgLine in self.imgLines:
            imgPath = os.path.join(scanPath, imgLine.headNum, imgLine.imgNameP)
            lineId = str(imgLine.lineId)
            try:    
                ret = invoiceService.read_invoice(imgPath, lineId)
            except:
                traceback.print_exc()
                continue    
            validateInv.check(ret)
            ret["ocrType"] = "PROGRAM"
            ret["userNum"] = imgLine.userNum
            ret["lineId"] = imgLine.lineId
            self.ocrResultDao.saveOrUpdateOcrResult(ret) 
            self.ocrResultDao.saveOrUpdateOcrResult({"ocrType":"CHECK", "lineId":imgLine.lineId,"userNum":imgLine.userNum}) 
     
