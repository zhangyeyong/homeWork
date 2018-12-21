# coding:utf-8
import sqlite3
import os
import sys
from config.config import dbPath
#要将int 替换成 numeric
createImgHeadSQL = '''create table imgHead 
                (
                       headId integer primary key,
                       headNum              varchar(32)                    null,
                       uploadType           varchar(32)                    null,
                       uploadTime           datetime                       null,
                       status               varchar(32)                    null,
                       imgQty               int                            null,
                       headDesc             varchar(256)                   null,
                       headSize             int                            null,
                       errorMsg             varchar(256)                   null,
                       remark               varchar(256)                   null,
                       belong               varchar(32)                    null,
                       userNum              varchar(32)                    not null,
                       headOrd              int                            null,
                       headStatus           varchar(32)                    not null,
                       appCode              varchar(32)                    not null,
                       userForm             varchar(1024)                  null,
                       uploadSize           int DEFAULT 0
                );'''
#headStatus :1 正常的normal，可增，删，改，2.只能补扫 （add_only）    3.closed:不能下载，不能上传            
createImgLineSQL = '''create table imgLine 
                (
                       lineId integer primary key,
                       headId               int                            null,
                       headNum              varchar(32)                    null,
                       imgType              varchar(32)                    null,
                       imgNameS             varchar(256)                   null,
                       imgNameP             varchar(256)                   null,
                       scanTime             dateime                        null,
                       imgSize              int                            null,
                       uploadSize           int                            null,
                       uploadId             int                            null,
                       uploadIconId         int                            null,
                       isChecked            char(1)                        null,
                       imgOrd               int                            null,
                       userNum              varchar(32)                    not null,
                       editAble             char(1)                        null,
                       deleteAble           char(1)                        null
                );'''
createUploadTaskSQL = '''create table uploadTask 
                (
                       uploadTaskId integer primary key,
                       headId               int                            null,
                       status               varchar(32)                    null,
                       startTime            datetime                       null,
                       endTime              datetime                       null,
                       taskType             varchar(32)                    null,
                       userNum              varchar(32)                    not null
                );'''
createUploadTaskLogSQL = '''create table uploadTaskLog 
                (
                       uploadTaskLogId integer primary key,
                       headId               int                            null,
                       status               varchar(32)                    null,
                       startTime            datetime                       null,
                       endTime              datetime                       null,
                       taskType             varchar(32)                    null,
                       userNum              varchar(32)                    not null
                );'''
createOcrResultSQL = '''create table ocrResult(
                       resultId        integer primary key            not null,
                       lineId               int                            null,
                       ocrType              varchar(32)                    null,
                       code                 varchar(32)                    null,
                       num                  varchar(32)                    null,
                       invDate              varchar(32)                    null,
                       amount               varchar(32)                    null,
                       tax                  varchar(32)                    null,
                       taxAmount            varchar(32)                    null,
                       total                varchar(32)                    null,
                       apwd                 varchar(256)                   null,
                       lpwd                 varchar(256)                   null,
                       rpwd                 varchar(256)                   null,
                       sTaxPayer            varchar(32)                    null,
                       bTaxPayer            varchar(32)                    null,
                       codeR                char(1)                        null,
                       numR                 char(1)                        null,
                       invDateR             char(1)                        null,
                       amountR              char(1)                        null,
                       taxR                 char(1)                        null,
                       taxAmountR           char(1)                        null,
                       totalR               char(1)                        null,
                       apwdR                char(1)                        null,
                       lpwdR                char(1)                        null,
                       rpwdR                char(1)                        null,
                       sTaxPayerR           char(1)                        null,
                       bTaxPayerR           char(1)                        null,
                       userNum              varchar(32)                    not null
                       );'''
createOcrLogSQL = '''create table ocrLog 
                    (
                       logId               integer primary key            not null,
                       invId                int                            null,
                       totalTime            float                          null,
                       rotate               float                          null,
                       read                 float                          null,
                       offset               float                          null,
                       position             float                          null,
                       handleImg            float                          null,
                       saveImg              float                          null,
                       logDate              varchar(32)                    null,
                       userNum              varchar(32)                    not null
                    );'''
createConfigSQL = '''create table config 
                    (
                       configId             integer primary key            not null,
                       code                 varchar(32)                    not null,
                       val                  varchar(256)                   not null,
                       userNum              varchar(32)                    null
                    );'''
def initDB():
    if os.path.exists(dbPath) and os.path.isfile(dbPath):
        os.remove(dbPath)
    cx = sqlite3.connect(dbPath)
    cu = cx.cursor()
    cu.execute(createImgHeadSQL)
    cu.execute(createImgLineSQL)
    cu.execute(createUploadTaskSQL)
    cu.execute(createUploadTaskLogSQL)
    cu.execute(createOcrResultSQL)
    cu.execute(createOcrLogSQL)
    cu.execute(createConfigSQL)

if __name__ == '__main__':
    initDB()
    print "init done "
    pass    
