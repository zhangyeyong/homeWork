# coding:utf-8
import compileall
from config import config

# web_ui 路径
web_ui_path = config.rootPath
# client 路径
client_path = config.scanClientPath
print "client_path---->",client_path
# 编译源码
# path = "D:\\code\\Src\\ztessc_scan\\chongqing\\twain_client"
compileall.compile_dir(web_ui_path)
# path = "D:\\code\\Src\\ztessc_scan\\chongqing\\web_ui"
compileall.compile_dir(client_path)