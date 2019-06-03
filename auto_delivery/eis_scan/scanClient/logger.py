# coding=utf-8

import logging
import os.path
import time
# from setting.constants import LOG_PATH
LOG_PATH = ".\logs"
class Logger(object):

    def __init__(self, logger):
        self.logger = logging.getLogger(logger)
        self.logger.setLevel(logging.DEBUG)

        #用于写入日志文件
        rq = time.strftime('%Y%m%d', time.localtime(time.time()))
        log_name = os.path.join(LOG_PATH, 'client.log')
        fh = logging.FileHandler(log_name)
        fh.setLevel(logging.INFO)

        # 输出到控制台
        ch = logging.StreamHandler()
        ch.setLevel(logging.INFO)

        #日志输出格式
        formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
        fh.setFormatter(formatter)
        ch.setFormatter(formatter)

        #给logger添加handler
        self.logger.addHandler(fh)
        self.logger.addHandler(ch)



    def getlog(self):
        return self.logger

