# coding:utf-8
from controllers import controller
from tools.logU import Log
import sys

if sys.getdefaultencoding() != 'utf-8':
    reload(sys)
    sys.setdefaultencoding('utf-8')
if __name__ == "__main__":
    controller.app.run(8888,Log)
    # controller.app.run(8888)
