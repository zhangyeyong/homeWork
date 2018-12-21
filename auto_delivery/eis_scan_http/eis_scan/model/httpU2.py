# coding:utf-8
'''
Created on 2017年1月15日

@author: zhang
'''
import time
import traceback
# import urllib
import urllib2
import itertools
import mimetools
import mimetypes
import os.path as path
import json
import sys

class MultiPartForm():

    def __init__(self):
        self.form_fields = []
        self.files = []
        self.boundary = mimetools.choose_boundary()

    def add_field(self, name, value):
        """添加field数据到form表单"""
        self.form_fields.append((name, value))

    def add_file(self, fieldname, filename, file_obj, mimetype=None):
        """添加文件到表单"""
        if not mimetype:
            mimetype = mimetypes.guess_type(filename)[0] or 'application/octet-stream'
            mimetype = 'image/png'
        self.files.append((fieldname, filename, mimetype, file_obj.read()))

    def __str__(self):
        """拼接form报文"""
        parts = []
        part_boundary = "--%s" % self.boundary

        # 添加fields
        parts.extend(
            [part_boundary,
            'Content-Disposition: form-data; name="%s"' %name,
            '',
            value,] for name, value in self.form_fields
            )       

        # 添加要上传的files
        parts.extend(
            [part_boundary,
            'Content-Disposition: form-data; name="%s"; filename="%s"' % (field_name, filename),
            'Content-Type: %s' % content_type,
            '',
            body,] for field_name, filename, content_type, body in self.files
            )

        # 压平parts添加boundary终止符
        flattened = list(itertools.chain(*parts))
        flattened.append('--%s--' % self.boundary)
        flattened.append('')
        return '\r\n'.join(flattened)
def download(url,filePath):
    file_obj = None
    try: 
        f = urllib2.urlopen(url) 
        data = f.read() 
        with open(filePath, "wb") as file_obj:     
            file_obj.write(data)
        return {"code":"S"}
    except Exception, e:
        print >> sys.stderr, "download failed - %s" % e
        traceback.print_exc()
        return {"code":"F","errorMsg":"upload fail :%s"%e}
    finally:
        if file_obj:
            file_obj.close()
def doGet(url):
    try: 
        request = urllib2.Request(url)
#         request.add_data(body)
        rtn = urllib2.urlopen(request).read()
        print "-------------->rtn:",rtn
        return json.loads(rtn)
    except Exception, e:
        print >> sys.stderr, "upload failed - %s" % e
        traceback.print_exc()
        return {"code":"F","errorMsg":"upload fail :%s"%e}
    finally:
        pass
def upload(url,form):
    file_obj = None
    try: 
        url = unicode2Str(url)
        body = str(form)
        time.sleep(0.1)
        request = urllib2.Request(url,data=body)
        request.add_header('Content-type', 'multipart/form-data; boundary=%s' % form.boundary)
        request.add_header('Content-length', len(body))
#         request.add_data(body)
        rtn = urllib2.urlopen(request).read()
        print "-------------->rtn:",rtn
        return json.loads(rtn)
    except Exception, e:
        print >> sys.stderr, "upload failed - %s" % e
        traceback.print_exc()
        return {"code":"F","errorMsg":"upload fail :%s"%e}
    finally:
        if file_obj:
            file_obj.close()
def upload2(url,filePath):
    file_obj = None
    if isinstance(filePath, unicode):
        filePath = filePath.encode("utf-8")
    boundary = '----------%s' % hex(int(time.time() * 1000))
    data = []
    data.append('--%s' % boundary)
    
    data.append('Content-Disposition: form-data; name="%s"\r\n' % 'ticket')
    data.append('9e977c24-905b-4433-8030-1bd13f2398c4')
    data.append('--%s' % boundary)
    
    data.append('Content-Disposition: form-data; name="%s"\r\n' % 'headNum')
    data.append('10000')
    data.append('--%s' % boundary)
    
    file_obj=open(filePath,'rb')
    data.append('Content-Disposition: form-data; name="%s"; filename="test.png"' % 'uploadFile')
    data.append('Content-Type: %s\r\n' % 'image/png')
    data.append(file_obj.read())
    data.append('--%s--\r\n' % boundary)

    http_body='\r\n'.join(data)
    try: 
        #buld http request
        request=urllib2.Request(url, data=http_body)
        #header
        request.add_header('Content-Type', 'multipart/form-data; boundary=%s' % boundary)
        request.add_header('User-Agent','Mozilla/5.0')
        request.add_header('Referer',url)
        #post data to server
            
        rtn = urllib2.urlopen(request,timeout=60).read()
        print "-------------->rtn:",rtn
        return json.loads(rtn)
    except Exception, e:
        print >> sys.stderr, "upload failed - %s" % e
        traceback.print_exc()
        return {"code":"F","errorMsg":"upload fail :%s"%e}
    finally:
        if file_obj:
            file_obj.close()
def unicode2Str(unicodeStr):
    if isinstance(unicodeStr, unicode):
        unicodeStr = unicodeStr.encode("utf-8")
    return unicodeStr       
def toUploadForm(url,ticket,headNum,filePath):
    file_obj = None
    form = MultiPartForm()
    try: 
        url = unicode2Str(url)
        ticket = unicode2Str(ticket)
        headNum = unicode2Str(headNum)
        filePath = unicode2Str(filePath)
        file_obj=open(filePath,'rb')
        if not path.exists(filePath):
            #return {"code":"F","errorMsg":"file [%s] not exist"%filePath}
            print >> sys.stderr, "toUploadForm failed - file [%s] not exist"%filePath
        fileName = path.basename(filePath)  
        form.add_field("ticket", ticket) 
        form.add_field("headNum", headNum) 
        form.add_file('uploadFile', fileName, file_obj)
    except Exception, e:
        print >> sys.stderr, "toUploadForm failed - %s" % e
    finally:
        if file_obj:
            file_obj.close()
    return form    
if __name__ == '__main__':
#     测试 下载
#     url="http://10.18.221.157:8080/evs/images/image/test.png"
#     filePath = "d:/zy3.jpg"
#     print download(url, filePath)
#   测试上传
#     print
#     filePath = u"D:/work/scan_new/eis_scan/static/images/scan/test/9527_20170120152610001.jpg"
#     filePath = "d:/3.jpg"
#     url = 'http://127.0.0.1:8080/upload/UploadServlet.do'
#     form = MultiPartForm()
#     ticket = "123456"
#     headNum = u"testHeadNum"
#     file_obj=open(filePath,'rb')
#     if not path.exists(filePath):
#         #return {"code":"F","errorMsg":"file [%s] not exist"%filePath}
#         print >> sys.stderr, "toUploadForm failed - file [%s] not exist"%filePath
#     fileName = path.basename(filePath)  
#     form.add_field("ticket", ticket) 
#     form.add_field("headNum", headNum) 
#     form.add_file('uploadFile', fileName, file_obj)
#     form = toUploadForm(url,ticket,headNum,filePath)
#     print 
#     print 'Response'
#     print upload(url,form)
#     print upload2(url,filePath)
#     测试 getUrl
    url="http://127.0.0.1:8001/?method%3DisAlive&_=1485325247158"
    print doGet(url)
    pass