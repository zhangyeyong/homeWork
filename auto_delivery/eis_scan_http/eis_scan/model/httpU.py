# coding:utf-8
'''
Created on 2017年1月15日

@author: zhang
'''
import time
import traceback
# import urllib
import urllib2
if __name__ == '__main__':
    boundary = '----------%s' % hex(int(time.time() * 1000))
    data = []
#     data.append('--%s' % boundary)
#     
#     data.append('Content-Disposition: form-data; name="%s"\r\n' % 'username')
#     data.append('jack')
#     data.append('--%s' % boundary)
#     
#     data.append('Content-Disposition: form-data; name="%s"\r\n' % 'mobile')
#     data.append('13800138000')
#     data.append('--%s' % boundary)
    
    fr=open(r'd:/3.jpg','rb')
    data.append('Content-Disposition: form-data; name="%s"; filename="3.jpg"' % 'uploadFile')
    data.append('Content-Type: %s\r\n' % 'image/png')
    data.append(fr.read())
    fr.close()
    data.append('--%s--\r\n' % boundary)
    
    http_url='http://127.0.0.1:8080/upload/UploadServlet.do'
    http_body='\r\n'.join(data)
    try:
        #buld http request
        req=urllib2.Request(http_url, data=http_body)
        #header
        req.add_header('Content-Type', 'multipart/form-data; boundary=%s' % boundary)
        req.add_header('User-Agent','Mozilla/5.0')
        req.add_header('Referer','http://127.0.0.1:8080/upload')
        #post data to server
        resp = urllib2.urlopen(req, timeout=5)
        #get response
        qrcont=resp.read()
        print qrcont
        
        
    except Exception,e:
        traceback.print_exc()
        print 'http error'
    pass