# coding:utf-8
# 识别增值税发票后台线程
import threading
import time
import re
import os
import sys


class ImageThread(threading.Thread):
    def __init__(self, bmpPath, targetPath, ext):
        threading.Thread.__init__(self)
        self.isFinish = False
        self.bmpPath = bmpPath
        self.targetPath = targetPath
        self.stopFlag = False
        self.doneMap = {}
        self.ext = ext

    def stop(self):
        self.stopFlag = True

    def bmpToOtherType(self):
        from PIL import Image
        for (root, dirs, files) in os.walk(self.bmpPath):
            for filename in files:
                if self.doneMap.has_key(filename):
                    continue
                (shotname, extension) = os.path.splitext(filename)
                targetFile = os.path.join(self.targetPath, shotname + "." + self.ext)
                Image.open(os.path.join(self.bmpPath, filename)).save(targetFile)
                self.doneMap[filename] = True

    def run(self):
        print u"-----------begin image thread---------------------"
        self.doneMap.clear()
        while not self.stopFlag:
            startTime = time.time()
            self.bmpToOtherType()
            endTime = time.time()
            #             print "总时间%d" % (endTime - startTime)
            #             print self.ocrMap
            time.sleep(0.2)
        self.bmpToOtherType()
        self.isFinish = True
        print u"-----------end image thread---------------------"

    def sleepUnilFinish(self):
        while not self.isFinish:
            print u"the thread has not  done.  sleep 0.1"
            time.sleep(0.1)


if __name__ == "__main__":
    src = "D:\\temp\\image\\src"
    dest = "D:\\temp\\image\\dest"
    imageThread = ImageThread(src, dest, "jpg")
    # imageThread.bmpToOtherType()
    imageThread.start()
    time.sleep(20)
    imageThread.stop()
    imageThread.sleepUnilFinish()
    print"----------------------"
    pass
