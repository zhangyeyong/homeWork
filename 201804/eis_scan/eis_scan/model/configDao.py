# coding:utf-8
from config.config import db

class ConfigDao:
    def findAllAsDict(self):
        configDict = {}
        configList = db.select("config").list()
        for entry in configList:
            configDict[entry.code] = entry.val
        return configDict
    
    def getValueByKey(self, key):
        for config in db.select("config", where="code = $code", vars={"code":key}).list():
            return config.val
    
    def save(self, configs):
#         ret = db.select("config").list()
#         for config in ret:
#             c = configs.get(config.code)
#             if c:
#                 db.delete('config', where="configId=$configId", vars=config)
        for key, val in configs.items():
            db.delete('config', where="code=$code", vars={"code":key})
            db.insert("config", **{'code':key, 'val':val})
if __name__ == '__main__':
    configDao = ConfigDao()
    configs = {"EIS_IP":"10.18.221.146", "EIS_PORT":"80", "VIRTUAL_PATH":"/easp/services/SyncImage"}
    configDao.save(configs)
    print configDao.findAllAsDict()
