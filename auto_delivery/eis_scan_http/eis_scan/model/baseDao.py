# coding:utf-8
from config.config import db
from config import constants

class BaseDao():
    def findPageByTableName(self, tableName, where, cond, page):
        # pageNum  当前页
        # pageCount 总页数
        pageSize = page.get("pageSize", constants.pageSize)
        if cond and cond.get("order"):
            order = cond.get("order")
        count = db.select(tableName, what="count(*) as count", where=where, vars=cond).list()[0].count
        data = db.select(tableName, where=where, vars=cond, limit=pageSize, offset=pageSize * (page.get("pageNum", 1) - 1), order=order,).list()
        page["pageCount"] = (count + pageSize - 1) / pageSize
        page["data"] = data
        return page
    def findPageBySql(self, sql, cond, page):
        # pageNum  当前页
        # pageCount 总页数
        pageSize = page.get("pageSize", constants.pageSize)
        sqlCount ="select count(*) as count from ("+sql+")"
        count = db.query(sqlCount, vars=cond)[0].count
        offset=pageSize * (page.get("pageNum", 1) - 1)
        sqlPage = sql + " limit %d,%d"%(offset,pageSize)
        data = db.query(sqlPage, vars=cond)
        page["pageCount"] = (count + pageSize - 1) / pageSize
        page["data"] = data
        return page
