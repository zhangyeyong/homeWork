# coding:utf-8
import os
import sys
from socket import *
import copy
from libs.ocr import *
from numpy import math
import numpy as np
import time
import json

from tool import pathJoin
from config.config import rootPath as curPath

FLANN_INDEX_KDTREE = 1  # bug: flann enums are missing

flann_params = dict(algorithm=FLANN_INDEX_KDTREE,
                    trees=4)
# 增值税发票要取得的数据：dataName : [起始坐标 ， 偏移量]
lang = "eng"
initial_params = {
               'code':{'border':(250, 50), 'offset':(-350, -374), 'lang':'code0' },
               'num':{'border':(200, 50), 'offset':(390, -376), 'lang':'num0+num' },
               'bTaxPayer':{'border':(330, 125), 'offset':(-230, -213), 'lang':'taxPayer0+taxPayer' },
#                'bTaxPayer':{'border':(330, 30), 'offset':(-215, -231), 'lang':'taxPayer0+taxPayer' },
               'sTaxPayer':{'border':(330, 115), 'offset':(-230, 221), 'lang':'taxPayer0+taxPayer'  },
               'invDate':{'border':(180, 40), 'offset':(489, -314), 'lang':'eng' },
               'apwd':{'border':(458, 120), 'offset':(356, -220), 'lang':'pwd0+pwd' },
               'lpwd':{'border':(330, 120), 'offset':(293, -220), 'lang':'pwd0+pwd'  },
               'rpwd':{'border':(134, 120), 'offset':(518, -220), 'lang':'code0'  },
               'amount':{'border':(170, 35), 'offset':(274, 92), 'lang':'eng+amount2'  },
               'taxAmount':{'border':(166, 35), 'offset':(512, 92), 'lang':'eng+amount2'   },
               'totalCh':{'border':(280, 40), 'offset':(-145, 134), 'lang':'eng+amount2'},
               'total':{'border':(200, 34), 'offset':(443, 135), 'lang':'eng+amount2'  },
               'tax':{'border':(52, 35), 'offset':(395, -111), 'lang':'eng+amount2'  }
               }
data_params = {}

def data_rotate_angle(dataImg):
    dataImg = cv2.medianBlur(dataImg, 5) 
    h, w = dataImg.shape[:2]
    points = []
    for h1 in range(0, h, 1):
        for w1 in range(0, w, 1):
            if dataImg[h1, w1] < 210:
                points.append([w1, h1])
    points = np.float32(np.vstack(points))
    cluster_n = 1
    em = cv2.EM(points, params=dict(nclusters=cluster_n, cov_mat_type=cv2.EM_COV_MAT_GENERIC))
    means = em.getMeans()
    x, y = means[0]
    x_offset = x - (w - 1) / 2.0
    y_offset = (h - 1) / 2.0 - y
    print "h,w:", h, w
    print "x,y:", x, y
    print "xy offset:", x_offset, y_offset
    return x_offset, y_offset

def handle_img1(img):
    retval, img = cv2.threshold(img, 200, 255, cv2.THRESH_BINARY);   
#         retIm = cv2.bitwise_not(retIm);   
    return img

def handle_img2(img):
    kernel = cv2.getStructuringElement(cv2.MORPH_RECT, (3, 3))  
    img = cv2.erode(img, kernel) 
    img = cv2.dilate(img, kernel)
    return img

def get_sub_img(img, img_name, center):
    param = data_params[img_name]
    value = param['offset']
    child_img = cv2.getRectSubPix(img, param['border'], (center[0] + value[0], center[1] + value[1]))
    return child_img

def adaptiveThreshold(key, img, wRate):
    img = cv2.cvtColor(img, cv2.COLOR_RGB2GRAY)
    if key in ['code']:
        img = cv2.adaptiveThreshold(img, 255, cv2.ADAPTIVE_THRESH_GAUSSIAN_C, cv2.THRESH_BINARY, 9, 5)
    elif key in ['num']:
        img = cv2.adaptiveThreshold(img, 255, cv2.ADAPTIVE_THRESH_MEAN_C, cv2.THRESH_BINARY, 15, 11)
    elif key in ['invDate']:
        img = cv2.adaptiveThreshold(img, 255, cv2.ADAPTIVE_THRESH_MEAN_C, cv2.THRESH_BINARY, 7, 5)
        slice_part = ((42.0 / 149, 64.0 / 149), (87.0 / 149, 107.0 / 149), (132.0 / 149, 1.0))
        contourU.sliceImg(img, slice_part)
    elif key in ['taxAmount', 'amount', 'total']:
        cv2.imwrite("xxxx.jpg", img)
        img = cv2.imread("xxxx.jpg", 0)
        img = cv2.adaptiveThreshold(img, 255, cv2.ADAPTIVE_THRESH_MEAN_C, cv2.THRESH_BINARY, 9, 7)
        contourU.denoise(img)
        img = inpaintU.inpaint(img)
        contourU.slicePart(img, 1)
    elif key in ['tax']:
        img = cv2.adaptiveThreshold(img, 255, cv2.ADAPTIVE_THRESH_MEAN_C, cv2.THRESH_BINARY, 7, 5)
        h, w = img.shape[:2]
        if abs(h * 2 - w) > 5:
            slice_part = (0.5, 1.0)
        else:    
            slice_part = (1.0 - 11 * wRate / w, 1.0)
        contourU.sliceImg(img, slice_part)
    elif key in ['apwd', 'lpwd']:
        img = cv2.adaptiveThreshold(img, 255, cv2.ADAPTIVE_THRESH_MEAN_C, cv2.THRESH_BINARY, 13, 11)
    elif key in ['rpwd']:
        img = cv2.adaptiveThreshold(img, 255, cv2.ADAPTIVE_THRESH_GAUSSIAN_C, cv2.THRESH_BINARY, 5, 6)
    else:
        img = cv2.adaptiveThreshold(img, 255, cv2.ADAPTIVE_THRESH_MEAN_C, cv2.THRESH_BINARY, 9 , 9)
    img = contourU.adjustMargin(img)
    if key not in ['taxAmount', 'amount', 'tax', 'total', 'apwd', 'lpwd']:
        contourU.denoise(img)
    return img
    
def src_img_save(key, img, id):
    path = pathJoin(curPath, "static/images/", key)
    if not os.path.isdir(path):
        os.makedirs(path)
    imName = pathJoin(path, "v" + id + "_" + key + ".jpg")
    cv2.imwrite(imName, img)
    return imName
    
def gray_img_save(key, img, id):
    path = pathJoin(curPath, "static/grayImage/", key)
    if not os.path.isdir(path):
        os.makedirs(path)
    imName = pathJoin(path, "v" + id + "_" + key + ".jpg")
    cv2.imwrite(imName, img)
    return imName

def fixedPositon(findType, img):
    img = contourU.rotateImg(img)
    center, wRate, hRate, ang = findType(img)
    print "center, wRate, hRate, ang:", center, wRate, hRate, ang
    h, w = img.shape[:2]
    rot_mat = cv2.getRotationMatrix2D(center, ang, 1.0)
    img = cv2.warpAffine(img, rot_mat, (w , h), flags=cv2.INTER_LINEAR, borderValue=(255, 255, 255))
    cv2.imwrite(curPath + "/static/images/img_src.jpg", img)
    return center, wRate, hRate, img

def adjustParam(wRate, hRate):
    global data_params
    data_params = copy.deepcopy(initial_params)
    for value in data_params.values():
        b = value['border']
        o = value['offset']
        value['border'] = (np.int32(b[0] * wRate), np.int32(b[1] * hRate))
        value['offset'] = (np.int32(o[0] * wRate), np.int32(o[1] * hRate))

# 检查用户上传的图片是否符合条件
def checkOriginal(img):
    h, w = img.shape[:2]
    if w < h:
        h, w = w, h
    if w < 1170 or h < 850:
        raise Exception("分辨率不能低于1170*850", True)
    
def read_invoice(fn2, id):
    ocrLog = {"invId":id}
    startTime = time.time()
    original = cv2.imread(fn2, -1)
    checkOriginal(original)
    center, wRate, hRate, img_src = fixedPositon(contourU.fixedPositon, original)
    adjustParam(wRate, hRate)
    posTime = time.time()
    ocrLog["position"] = posTime - startTime

    srcImages = {}  # 存放原图
    grayImages = {}  # 存放二值化后的图片
    for key in ['code', 'num']:
        lang = data_params[key]['lang']
        cIm = get_sub_img(img_src, key, center)
        cIm = contourU.sliceSpare(cIm)
        srcImages[key] = cIm
        cIm = adaptiveThreshold(key, cIm, wRate)
        grayImages[key] = cIm
    codeNumTime = time.time()
    
    
#     totalCh_1 = get_sub_img(img_src, 'totalCh', center)
#     cv2.imwrite("static/images/totalCh_1.jpg", totalCh_1)
#     ang = emU.data_rotate_angle(totalCh_1)
#     print "ang_2:", ang
#     rot_mat = cv2.getRotationMatrix2D(center, ang, 1.0)
#     H, W = img_src.shape[:2]
#     img_src = cv2.warpAffine(img_src, rot_mat, (W , H), flags=cv2.INTER_LINEAR)
    
    totalCh_2 = get_sub_img(img_src, 'totalCh', center)
    cv2.imwrite(curPath + "/static/images/totalCh_2.jpg", totalCh_2)
    x, y = contourU.bounding2(totalCh_2, 10)
    print x, y
    x_offset = x - 41 * wRate
    y_offset = y - (totalCh_2.shape[0] * 1.0) / 2
    print "x_offset,y_offset", x_offset, y_offset
    
    offsetTime = time.time()
    ocrLog["offset"] = offsetTime - codeNumTime
    
    for key, value in data_params.items():
        if key in ['code', 'num', 'totalCh']:
            continue
        border = value['border']
        o = value['offset']
        lang = value['lang']
        retIm = cv2.getRectSubPix(img_src, border, (center[0] + o[0], center[1] + o[1]))
        if key in ['bTaxPayer', 'sTaxPayer']:
            retIm = cutImgU.cutTaxPayer(retIm)
        else:
            retIm = contourU.sliceSpare(retIm)
        srcImages[key] = retIm
        retIm = adaptiveThreshold(key, retIm, wRate)
        grayImages[key] = retIm
    # 图片处理
    handleImgTime = time.time()
    ocrLog["handleImg"] = handleImgTime - offsetTime + codeNumTime - posTime
    
    serverHost = '127.0.0.1'
    serverPort = 8002
    #建立一个tcp/ip套接字对象
    sockobj = socket(AF_INET, SOCK_STREAM)
    #连结至服务器及端口
    sockobj.connect((serverHost, serverPort))
    # 识别
    dictRet = {}
    
    # 图片保存
    for key, value in srcImages.items():
        src_img_save(key, value, id)
    for key, value in grayImages.items():
        imName = gray_img_save(key, value, id)
        lang = data_params[key]['lang']
        mode = 'SINGLE_BLOCK'
        param = {
                 "type" : "socket",
                 "method" : "ocr",
                 "fileName" : imName,
                 "lang" : lang,
                 "mode" : mode,
                 }
        if key in ['invDate', 'amount', 'tax', 'taxAmount', 'total']:
            param['whitelist'] = "0123456789"
        print "strat get_text"
        #经过套按字发送line至服务端
        sockobj.send(json.dumps(param))
        #从服务端接收到的数据，上限为1k
        text = sockobj.recv(1024)
        print "ocr Result:", text
        print "end get_text"
        dictRet[key] = text
    sockobj.send("exit")
    sockobj.close()
    saveImgTime = time.time()
    ocrLog["saveImg"] = saveImgTime - handleImgTime    
#     readUClass = readU.ReadU()    
    
#     for key, value in grayImages.items():
#         lang = data_params[key]['lang']
#         mode = 'SINGLE_BLOCK'
#         print "strat get_text"
#         if key in ['invDate', 'amount', 'tax', 'taxAmount', 'total']:
#             text = readUClass.get_text(value, lang, mode, "0123456789")
#         else:
#             text = readUClass.get_text(value, lang, mode)
#         print "end get_text"
#         dictRet[key] = text
        
    readTime = time.time()
    ocrLog["read"] = readTime - saveImgTime
    
    ocrLog["totalTime"] = readTime - startTime
    return dictRet
