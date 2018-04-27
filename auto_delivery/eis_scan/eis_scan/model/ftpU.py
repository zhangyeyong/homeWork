# -*- coding: utf-8 -*- 
from ftplib import FTP
from ftplib import error_perm
import os 
from tool import pathJoin
import traceback
from config import config
import sys
from i18n.i18nU import _
ftpDict = {} 
def upload(user, pwd, srcFileNames, ip, port='21', relativePath=None, targetFileNames=None): 
    ftp = FTP() 
    try:
        ftp.set_debuglevel(2)  # 打开调试级别2，显示详细信息;0为关闭调试信息 
        ftp.connect(str(ip), int(port))  # 连接 
        ftp.login(user, pwd)  # 登录，如果匿名登录则用空串代替即可 
        ftp.set_pasv(config.getIS_PASV())
        if relativePath:    
    #         ftp.cwd(relativePath)  # 选择操作目录
            chdir(relativePath, ftp)
        bufsize = 8192  # 设置缓冲块大小
        needSetDestFileName = False
        if targetFileNames and srcFileNames and len(srcFileNames) == len(targetFileNames):
            needSetDestFileName = True
        index = 0
        for srcfileName in srcFileNames: 
            targetfileName = srcfileName
            file_handler = open(srcfileName, 'rb')  # 以读模式在本地打开文件 
            if needSetDestFileName:
                targetfileName = targetFileNames[index]
            ftp.storbinary('STOR %s' % os.path.basename(targetfileName), file_handler, bufsize)  # 上传文件 
            file_handler.close() 
            index += 1
        return True
    except error_perm:
        return False
    finally:
        ftp.quit() 
        ftp.close() 
def testFtp(remoteHost, remotePort, loginname, loginpassword):
    import common
    ftp = FTP()
    try:  
        ftp.set_debuglevel(2)  # 打开调试级别2，显示详细信息;0为关闭调试信息 
#             ftp.connect(remoteip, remoteport, 60)  #超时时间
        ftp.connect(remoteHost, remotePort, 60)  
        print 'connect success' 
    except Exception, e:
        print >> sys.stderr, "conncet failed1 - %s" % e
        return common.buildFail(_("连接FTP[%s:%s]失败"%(remoteHost,remotePort)))    
    else:    
        try:    
            ftp.login(loginname, loginpassword)    
            ftp.set_pasv(config.getIS_PASV())
            print('login success') 
        except Exception, e:
            print >> sys.stderr, 'login failed - %s' % e
            return common.buildFail(_("FTP用户名或密码错误"))      
        else:
            return common.buildSuccess(_("连接FTP[%s:%s]成功"%(remoteHost,remotePort)), ftp)
def download(user, pwd, fileNames, ip, port='21', relativePath=None): 
    ftp = FTP()
    try: 
        ftp.set_debuglevel(2) 
        ftp.connect(str(ip), int(port)) 
        ftp.login(user, pwd) 
        ftp.set_pasv(config.getIS_PASV())
        if relativePath:    
            ftp.cwd(relativePath)  # 选择操作目录 
        bufsize = 8192 
        for fileName in fileNames: 
            file_handler = open(fileName, 'wb')  # 以写模式在本地打开文件 
            ftp.retrbinary('RETR %s' % os.path.basename(fileName), file_handler.write, bufsize)  # 接收服务器上文件并写入本地文件
            ftp.set_debuglevel(0) 
            file_handler.close()
        return True
    except error_perm:
        traceback.print_exc()
        return False
    finally:
        ftp.quit() 
        ftp.close() 
def download2(user, pwd, localPath, remoteFiles, ip, port='21'): 
    ftp = FTP()
    try: 
        ftp.set_debuglevel(2) 
        ftp.connect(str(ip), int(port),60) 
        ftp.login(user, pwd) 
        ftp.set_pasv(config.getIS_PASV())
        bufsize = 8192 
        for fileName in remoteFiles: 
            file_handler = open(pathJoin(localPath,os.path.basename(fileName)), 'wb')  # 以写模式在本地打开文件 
            ftp.retrbinary('RETR %s' % fileName, file_handler.write, bufsize)  # 接收服务器上文件并写入本地文件
            ftp.set_debuglevel(0) 
            file_handler.close()
        return True
    except error_perm:
        traceback.print_exc()
        return False
    finally:
        ftp.quit() 
        ftp.close() 
    
def chdir(ftp_path, ftp_conn):
    dirs = [d for d in ftp_path.split('/') if d != '']
    for p in dirs:
        check_dir(p, ftp_conn)
def check_dir(dirn, ftp_conn):
    filelist = []
    ftp_conn.retrlines('LIST', filelist.append)
    found = False

    for f in filelist:
        if f.split()[-1].lower() == dirn.lower():
            found = True

    if not found:
        ftp_conn.mkd(dirn)
    ftp_conn.cwd(dirn)

# if __name__ == '__main__':
#     user = "image"
#     pwd = "image"
#     relativePath = "zyy/y2014"
#     ip = "10.18.221.10"
#     port = "21"
#     ftp = FTP() 
#     ftp.set_debuglevel(2) 
#     ftp.connect(ip, port) 
#     ftp.login(user, pwd) 
#     t = 'zyy/for_Vadim/1/2/3/'
#     chdir(t, ftp)    
if __name__ == "__main__":
    import re
    barcode = "GRBC1122"
    regexStr = "^GRBC[\s]*"
    matchObj = re.compile(str(regexStr))
    m = matchObj.match(barcode)
    print m
    if m :
        print barcode
    barcode = "aaaGRBC"
    regexStr = "[a-z]*GRBC$"
    matchObj = re.compile(str(regexStr))
    m = matchObj.match(barcode)
    print m
    if m :
        print barcode
    pass
