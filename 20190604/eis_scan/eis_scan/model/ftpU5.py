# encoding=utf-8
 
from ftplib import FTP    
import sys    
import os.path 
import traceback   
from config import config  
import re 
import time
from compiler.ast import While

class MyFTP(FTP):    
    '''  
    conncet to FTP Server  
    ''' 
    pdir = re.compile("^d.*[^\.]$")
    pfile = re.compile("^-.*")
    def __init__(self):  
        print 'make a object' 
    def ConnectFTP(self, remoteip, remoteport, loginname, loginpassword):    
        ftp = MyFTP()  
        try:  
            ftp.set_debuglevel(2)  # 打开调试级别2，显示详细信息;0为关闭调试信息 
#             ftp.connect(remoteip, remoteport, 60)  #超时时间
            ftp.connect(remoteip, remoteport, 60)  
            print 'connect success' 
        except Exception, e:
            print >> sys.stderr, "conncet failed1 - %s" % e
            return (0, 'conncet failed')    
        else:    
            try:    
                ftp.login(loginname, loginpassword)    
                ftp.set_pasv(config.getIS_PASV())
                print('login success') 
            except Exception, e:
                print >> sys.stderr, 'login failed - %s' % e
                return (0, 'login failed')    
            else:
                return (1, ftp) 
    def testFtp(self,remoteHost, remotePort, loginname, loginpassword):
        res = self.ConnectFTP(remoteHost, remotePort, loginname, loginpassword)    
        if(res[0] != 1):
            print >> sys.stderr, res[1]
            return False
        else:
            return True
    def rmdir(self,remoteHost, remotePort, loginname, loginpassword,remotePath):
        res = self.ConnectFTP(remoteHost, remotePort, loginname, loginpassword)    
        if(res[0] != 1):
            print >> sys.stderr, res[1]
            return False
        try:
            ftp = res[1]
            ftp.rmd(remotePath)
            flag = True
            ftp.voidcmd('NOOP')

        except Exception, e:
                print >> sys.stderr, '----------ftp.ntransfercmd-------- : %s\n' % e
                traceback.print_exc()
        finally:
            ftp.quit()
            ftp.close()
    def deleteDirTree(self,ftp,root):
        parentPath = ftp.pwd()
        ftp.cwd(root)
        dirList = []
        fileList = []
        def callbackDir(content):
            tempname = content.split()[-1];
            if re.match(self.pdir, content):
                dirList.append(tempname)
            if re.match(self.pfile,content):
                fileList.append(tempname)
                
        ftp.dir(None,callbackDir)
        for fileName in fileList:
            ftp.delete(fileName)
        for subDir in dirList:
            self.deleteDirTree(ftp, subDir)
        ftp.cwd(parentPath)     
        ftp.rmd(root)   
    def deletedir(self,remoteHost, remotePort, loginname, loginpassword,root):
        res = self.ConnectFTP(remoteHost, remotePort, loginname, loginpassword)   
        flag=False 
        if(res[0] != 1):
            print >> sys.stderr, res[1]
            return False
        try:
                 
            # change the remote directory and get the remote file size    
            ftp = res[1]
            self.deleteDirTree(ftp,root)
            flag = True
            ftp.voidcmd('NOOP')
        except Exception, e:
                print >> sys.stderr, '----------ftp.deletedir-------- : %s\n' % e
                traceback.print_exc()
        finally:
            ftp.quit()
            ftp.close()
        return flag
 
    def download(self, remoteHost, remotePort, loginname, loginpassword, remotePath, localPath, callback=None):  
        print "download file. remotePath:%s---------------->localPath:%s"%(remotePath,localPath)  
        flag = True
        lwrite = None
        # connect to the FTP Server and check the return    
        res = self.ConnectFTP(remoteHost, remotePort, loginname, loginpassword)    
        if(res[0] != 1):
            print >> sys.stderr, res[1]
            return False
        try:
                 
            # change the remote directory and get the remote file size    
            ftp = res[1]
            dires = self.splitpath(remotePath)
            if dires[0]:
                ftp.cwd(dires[0])  # change remote work dir 
            remotefile = dires[1]  # remote file name
            print dires[0] + ' ' + dires[1]    
            fsize = ftp.size(remotefile)    
            if fsize == 0 :  # localfime's site is 0
                return
                 
            # check local file isn't exists and get the local file size    
            lsize = 0L
            if os.path.exists(localPath):    
                lsize = os.stat(localPath).st_size    
                     
            if lsize >= fsize:    
                print 'local file is bigger or equal remote file'   
                return   
            blocksize = 1024 * 1024
            cmpsize = lsize
            ftp.voidcmd('TYPE I')
            conn = ftp.transfercmd('RETR ' + remotefile, lsize)
            lwrite = open(localPath, 'ab')
            while True:
                data = conn.recv(blocksize)
                if not data:
                    break
                if callback: 
                    callback(data)
                lwrite.write(data)
                cmpsize += len(data)
                print 'download process:%.2f%%\n' % (float(cmpsize) / fsize * 100),
            flag = True
            ftp.voidcmd('NOOP')
            conn.close()
        except Exception, e:
                print >> sys.stderr, '----------ftp.ntransfercmd-------- : %s\n' % e
                traceback.print_exc()
        finally:
            if lwrite:
                lwrite.close()
            ftp.quit()
            ftp.close()
        return flag
 
    def upload(self, remotehost, remoteport, loginname, loginpassword, remotepath, localpath, callback=None):
        print "\nremotepath: %s------->localpath:%s" % (remotepath, localpath)
        flag = False
        datasock = None
        localf = None
        if not os.path.exists(localpath):
            print "Local file doesn't exists"
            return False
        start = time.time()
        res = self.ConnectFTP(remotehost, remoteport, loginname, loginpassword)
        end = time.time()
        print "---------------call connect Ftp :%d" % (end - start)
        if res[0] != 1:
            return False
        try:
            ftp = res[1]
            start = time.time()
            remote = self.splitpath(remotepath)
            if remote and remote[0]:    
                chdir(remote[0], ftp)
            rsize = 0L
            end = time.time()
            print "---------------call chdir :%d" % (end - start)
            start = time.time()
            try:
                rsize = ftp.size(remote[1])
            except:
                pass
            end = time.time()
            print "---------------call size :%d" % (end - start)
            start = time.time()
            if (rsize == None):
                rsize = 0L
            lsize = os.stat(localpath).st_size
            print('rsize : %d, lsize : %d' % (rsize, lsize))
            if (rsize == lsize):
                print 'remote filesize is equal with local'
                return True
            #如果远程文件大于本地文件，证明当次上传的不是同一文件，就可以删除
            if (rsize >= lsize):
                ftp.delete(remote[1]) 
                rsize=0
                print >> sys.stderr, '--- rsize bigger lsize   --------------- delete remote file name : %s\n' % remotepath
#             if (rsize < lsize):
            localf = open(localpath, 'rb')
            localf.seek(rsize)
            ftp.voidcmd('TYPE I')
            datasock = ''
            datasock, esize = ftp.ntransfercmd("STOR " + remote[1], rsize)
            cmpsize = rsize
            blocksize = 1024 * 500
            while True:
                buf = localf.read(blocksize)
                if not len(buf):
                    print '\rno data break'
                    break
                datasock.sendall(buf)
                if callback:
                    callback(buf)
                cmpsize += len(buf)
#                     print 'uploading %.2f%%\n' % (float(cmpsize) / lsize * 100),
                if cmpsize == lsize:
                    print '\rfile size equal break'
                    break
            flag = True
            end = time.time()
            print "---------------call upload :%d" % (end - start)
        except Exception, e:
                print >> sys.stderr, '----------ftp.ntransfercmd-------- : %s\n' % e
                traceback.print_exc()
        finally:
            try:
                if datasock: 
                    datasock.close()
                    print 'close data handle'
                if localf:
                    localf.close()
                    print 'close local file handle'
                count =0
                isOK = False
                while(count<100 and not isOK):
                    try:
                        time.sleep(0.01)
                        count=count+1
                        print "------------count:",count
                        ftp.voidcmd('NOOP')
                        isOK=True
                    except Exception, e:
                        print >> sys.stderr, '----------ftp.NOOP-------- : %s\n' % e
#                 print 'keep alive cmd success'
#                 ftp.voidresp()
                print 'No loop cmd'
                ftp.quit()
            except:
                pass
        return flag
    def getRemoteFileSize(self, remotePath):
        if not remotePath:
            print "Remote path cann't be none"
            return
        self.set_debuglevel(2)
        res = self.ConnectFTP()
        if res[0] != 1:
            print res[1]
            return False
        ftp = res[1]
        print "getRemoteFileSize  start:", ftp.pwd()
        remote = self.splitpath(remotePath)
        if remote and remote[0]:    
            chdir(remote[0], ftp)
        rsize = 0L
        try:
            rsize = ftp.size(remote[1])
        except:
            pass
        print "getRemoteFileSize  end:", ftp.pwd()
        return rsize                    
    def splitpath(self, remotepath):
        position = remotepath.rfind('/')
        return (remotepath[:position + 1], remotepath[position + 1:])
    def deleteRemoteFile(self, remoteHost, remotePort, loginname, loginpassword, remotePath):    
        # connect to the FTP Server and check the return    
        res = self.ConnectFTP(remoteHost, remotePort, loginname, loginpassword)    
        if(res[0] != 1):
            print >> sys.stderr, res[1]
            return False
             
        # change the remote directory and get the remote file size    
        ftp = res[1]
        try:
            remote=self.splitpath(remotePath)
            ftp.cwd(remote[0])
            ftp.delete(remotePath)
        except Exception, e:
            print >> sys.stderr, "delete remote file(%s) fail: %s\n" % (remotePath, e)
        ftp.quit()
class FileItem:
    pattern=re.compile('modify=(?P<modify>\d+);perm=(?P<perm>\w+);size=(?P<size>\d+);type=(?P<type>\w+);\s(?P<filename>.*)')
    def __init__(self,line):
        m=FileItem.pattern.search(line)        
        self.isdir=m.group('type')=='dir'
        self.size='' if self.isdir else m.group('size')
        self.time='' if self.isdir else m.group('modify')
        self.fname=m.group('filename')
        self.ext=os.path.splitext(self.fname)[-1]                
    def GetDesc(self):
        desc=''
        if self.isdir:
            desc='文件夹'
        elif self.ext:
            print "------------------->",self.ext
#             fileType=mimeTypeManager.GetFileTypeFromExtension(self.ext)
#             if fileType:
#                 desc=fileType.GetDescription()
#                 if desc is None:
#                     desc=''
        return desc    
def chdir(ftp_path, ftp_conn):
    dirs = [d for d in ftp_path.split('/') if d != '']
    for p in dirs:
        check_dir(p, ftp_conn)
def check_dir(dirn, ftp_conn):
    filelist = []
    ftp_conn.retrlines('LIST', filelist.append)
    found = False
    for f in filelist:
        if f.split()[-1] == dirn:
            found = True
    if not found:
        ftp_conn.mkd(dirn)
    ftp_conn.cwd(dirn) 

progress = 0L 
def myupload(ftp,localpath,remotepath):
    lsize = 0L
    if os.path.exists(localpath):    
        lsize = os.stat(localpath).st_size 
    rsize = 0
    localf = open(localpath, 'rb')
    localf.seek(rsize)
    ftp.voidcmd('TYPE I')
    datasock = ''
    datasock, esize = ftp.ntransfercmd("STOR " + remotepath, rsize)
    cmpsize = rsize
    blocksize = 1024 * 500
    while True:
        buf = localf.read(blocksize)
        if not len(buf):
            print '\rno data break'
            break
        datasock.sendall(buf)
        if callback:
            callback(buf)
        cmpsize += len(buf)
#                     print 'uploading %.2f%%\n' % (float(cmpsize) / lsize * 100),
        if cmpsize == lsize:
            print '\rfile size equal break'
            break 
    if datasock: 
        datasock.close()
        print 'close data handle'
    if localf:
        localf.close()
        print 'close local file handle'     
    ftp.voidcmd('NOOP')
    ftp.voidresp()
if __name__ == "__main__":
    import time
    import datetime
    def callback(buf):
        global progress
        progress = progress+len(buf)
        print "callback  :%s"%(progress) 
#     localPath = "D:/temp/com.zte.jbundle.builder.zip"
#     remotePath = "zyy/tools/test/com.zte.jbundle.builder.zip"
#     remotePath2 = "/zyy/tools/test2/com.zte.jbundle.builder.zip"
    loginname = "evsftp"
    loginpassword = "123evs"
    remoteHost = "60.2.101.16"
#     loginname = "xtsp"
#     loginpassword = "1"
#     remoteHost = "203.175.149.183"
    remotePort = "9080"
    myftp = MyFTP()
    try:
        start = time.time()*1000
        start_ = time.time()*1000
        res = myftp.ConnectFTP(remoteHost, remotePort, loginname, loginpassword)
        ftp=res[1]
        ftp.cwd("/zyy")
        end = time.time()*1000
        end_= time.time()*1000
        print "-------cwd-------> %d"%(end-start)
        print "-------cwd-------> %d"%(end_-start_)
        filelist = []
        ftp.retrlines('LIST', filelist.append)
        end = time.time()*1000
        print "-----LIST---------> %d"%(end-start)
        print "filelist--------------------->",filelist
        fileName="0132453_20170708171803001.jpg"
        for i in range(5):
            ftp.cwd("/zyy/sub1/sub11/")
            fileName = str(i+1)+".jpg"
            print "-------fileName------>",fileName
            myupload(ftp,"C:/Users/zhang/Desktop/PD1707080507/"+fileName,"/zyy/sub1/sub11/"+fileName)
        end = time.time()*1000
        print "-------myupload-------> %d"%(end-start)
    except Exception, e:
        traceback.print_exc()
        print >> sys.stderr, '----------ftp.download fail-------- : %s' % e    
