# coding:utf-8
from config.config import db
from config import constants
from baseDao import BaseDao

class UploadTaskLogDao(BaseDao):
    def find(self, page, cond=None):
        results = db.query("SELECT COUNT(*) AS count FROM uploadTaskLog")
        page.setTotal(results[0].count)
        sql = "SELECT uploadTaskLog.*,invGroup.groupNum,invGroup.scanTime,invGroup.scanBy,invGroup.imgQty,invGroup.groupSize FROM uploadTaskLog JOIN invGroup on uploadTaskLog.groupId = invGroup.groupId where 1=1"
#         if cond:
#             c = copy.deepcopy(cond)
#             if c.get('status'):
#                 sql += ' and status=' + c.get('status')
#             if c.get('groupNum'):
#                 c['groupNum'] = "%" + c['groupNum'].upper() + "%"
#                 sql += ' and upper(groupNum) like ' + c['groupNum']
        sql += " limit " + str(page.getOffset()) + "," + str(page.size)
        sql += " order by uploadTaskLog.startTime DESC"
        page.data = db.query(sql).list()
        return page
    def save(self, uploadTaskLog):
        db.insert("uploadTaskLog", **uploadTaskLog)
    def findByPage(self, page):
        sql = "SELECT log.*,imgHead.headNum,imgHead.imgQty,imgHead.headSize,imgHead.belong FROM uploadTaskLog log JOIN imgHead on log.headId = imgHead.headId where imgHead.userNum=$userNum"
        return self.findPageBySql(sql, page.get("cond"), page)      
if __name__=="__main__":
#     uploadTaskLogDao = UploadTaskLogDao()
#     uploadTaskLogDao.findByPage(page)
    i = 6940355
    print round(i/1024,2)
    print round(i/1024.0,2)
    pass 