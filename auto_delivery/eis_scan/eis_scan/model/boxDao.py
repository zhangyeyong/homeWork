# coding:utf-8
import os
import random
import time
from config.config import db
from config import constants
import copy
from tool import pathJoin
import json
class BoxDao:
    
    def findAll(self):
        return db.select("box").list()
    

if __name__ == "__main__":
    boxDao = BoxDao()
    boxs = boxDao.findAll()
    for box in boxs:
        print(box)
