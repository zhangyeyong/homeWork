# coding:utf-8
from baseDao import BaseDao
from config.config import db
from config.constants import taskStatus
class UploadTaskDao(BaseDao):
    def findTodoTask(self):
        statuss = [taskStatus.WAITING,taskStatus.UPLOADING]
        objs = db.query("select headId  from uploadTask where status in $statuss",vars={"statuss":statuss}).list()
        headIds=[]
        for obj in objs:
            headIds.append(obj.headId)
        return headIds 
    def getById(self, uploadTaskId):
        for uploadTask in db.query("select *  from uploadTask where uploadTaskId=$uploadTaskId", vars={"uploadTaskId":uploadTaskId}).list():
            return uploadTask
    def getByHeadId(self, headId):
        for uploadTask in db.query("select *  from uploadTask where headId=$headId", vars={"headId":headId}).list():
            return uploadTask
    def save(self, uploadTask):
        return self.getById(db.insert("uploadTask", **uploadTask))
    def saveOrUpdate(self, uploadTask):
        uploadTaskDb = None
        if uploadTask and uploadTask.headId:
            uploadTaskDb = self.getByHeadId(uploadTask.headId)
        if uploadTaskDb:
            uploadTask['uploadTaskId'] = uploadTaskDb.uploadTaskId
            db.update("uploadTask", where="uploadTaskId=$uploadTaskId", vars={'uploadTaskId':uploadTaskDb.uploadTaskId}, **uploadTask)    
        else:
            return self.getById(db.insert("uploadTask", **uploadTask))
    def deleteByHeadId(self, headId):
        db.delete('uploadTask', where="headId=" + str(headId))
    def updateStatusByHeadId(self, headId, status):
        if headId:
            db.update("uploadTask", where="headId=$headId", vars={'headId':headId}, status=status) 
    def findAll(self):
        return db.query("SELECT uploadTask.*,imgHead.headNum,imgHead.imgQty,imgHead.headSize,imgHead.belong FROM uploadTask JOIN imgHead on uploadTask.headId = imgHead.headId order by uploadTask.status DESC").list()
    def findByPage(self, page):
        sql = "SELECT task.*,imgHead.headNum,imgHead.imgQty,imgHead.headSize,imgHead.belong FROM uploadTask task JOIN imgHead on task.headId = imgHead.headId where imgHead.userNum=$userNum"
        return self.findPageBySql(sql, page.get("cond"), page)    
    def findByPage2(self, page):
        where = "1=1 "
        cond = page.get("cond")
        if cond:
            for key in cond.keys():
                print key
                pass
        print "where: " + str(where)
        print "cond: " + str(cond)
        tableName = "uploadTask"
        return self.findPageByTableName(tableName, where, cond, page)
    def uploadFail(self, headId, errorMsg):
        if headId:
            db.query("update imgHead set status='FAILURE', errorMsg='"+str(errorMsg)+"'  where headId = " + str(headId))