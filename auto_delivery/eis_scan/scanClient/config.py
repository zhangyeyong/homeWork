# coding:utf-8
# 配置，主要是站点、文件系统路径、URL路由以及全局环境的配置
import os
import sys

rootPath = os.path.abspath(os.path.dirname(__file__)).decode(sys.getfilesystemencoding())
scanPath = os.path.join(rootPath, "image")
scanPathSrc = os.path.join(rootPath, "image_src")
logsPath = os.path.join(rootPath, "logs")


def mkdir(path):
    path = path.strip()
    path = path.rstrip("\\")
    isExists = os.path.exists(path)
    if not isExists:
        os.makedirs(path)
        return True
    else:
        return False


mkdir(scanPath)
mkdir(logsPath)
mkdir(scanPathSrc)
