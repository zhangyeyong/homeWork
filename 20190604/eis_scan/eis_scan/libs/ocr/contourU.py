# coding=utf-8  
import cv2  
import numpy as np  
from model import imgRotate
from numpy import math
from i18n.i18nU import _
def fixedPositon(img):
    corners = findCorners(img)
    center = (sum(c[0] for c in corners) / 4, sum(c[1] for c in corners) / 4)
    p1 = np.float32((corners[0][0] + corners[3][0], corners[0][1] + corners[3][1]))
    p2 = np.float32((corners[1][0] + corners[2][0], corners[1][1] + corners[2][1]))
    p3 = np.float32((corners[0][0] + corners[1][0], corners[0][1] + corners[1][1]))
    p4 = np.float32((corners[2][0] + corners[3][0], corners[2][1] + corners[3][1]))
    width = math.sqrt((p2[0] - p1[0]) * (p2[0] - p1[0]) + (p2[1] - p1[1]) * (p2[1] - p1[1])) / 2
    height = math.sqrt((p3[0] - p4[0]) * (p3[0] - p4[0]) + (p3[1] - p4[1]) * (p3[1] - p4[1])) / 2
#             print corners
#             print signetCenter
    cv2.polylines(img, [np.array(corners, np.int32)], True, (0, 0, 0))
    wRate = width / 1195  # (560, 1196)
    hRate = height / 560  # (560, 1196)
    
    h, w = img.shape[:2]
    M = ((corners[1][1] + corners[2][1]) - (corners[0][1] + corners[3][1])) / ((corners[1][0] + corners[2][0]) - (corners[0][0] + corners[3][0])) 
    pi_angle = math.atan(M)
    ang = pi_angle * 180 / np.pi
    return center, wRate, hRate, ang
    raise Exception(_("无法定位发票"))

def findCorners(img):
    rate = img.shape[1] / 1800.0
    minArea = int(500000 * rate)
    lineThreshold = int(460 * rate)
    H, W = img.shape[:2]
    grayImg = cv2.cvtColor(img, cv2.COLOR_RGB2GRAY)
    v, new_img = cv2.threshold(grayImg, 230, 255, cv2.THRESH_BINARY_INV)
    contours0, hierarchy = cv2.findContours(new_img, cv2.RETR_TREE, cv2.CHAIN_APPROX_SIMPLE)
    result = np.ones((H, W), np.uint8) * 255
    result2 = np.zeros((H, W), np.uint8)
#     cv2.imshow("1111", cv2.resize(new_img, (400,300)))
    for cnt in contours0:
        x, y, w, h = cv2.boundingRect(cnt)
        if w > 800 and h > 360:
            cv2.drawContours(result, [cnt], 0, (0), 1)
#     cv2.imshow("xxx", cv2.resize(result, (400,300)))
    edges = cv2.Canny(result, 50, 150, apertureSize=3)  
    lines = cv2.HoughLines(edges, 2, np.pi / 180, lineThreshold)  # 这里对最后一个参数使用了经验型的值  
    if lines is None or len(lines) == 0:
        raise Exception(_("无法定位发票")) 
    for line in lines[0]:  
        rho = line[0]  # 第一个元素是距离rho  
        theta = line[1]  # 第二个元素是角度theta  
        if  (theta < (np.pi / 4.)) or (theta > (3.*np.pi / 4.0)):  # 垂直直线  
            pt1 = (int(rho / np.cos(theta)), 0)  
            pt2 = (int((rho - result.shape[0] * np.sin(theta)) / np.cos(theta)), result.shape[0])  
            cv2.line(result2, pt1, pt2, (255), 1)  
        else:  # 水平直线  
            pt1 = (0, int(rho / np.sin(theta)))  
            pt2 = (result.shape[1], int((rho - result.shape[1] * np.cos(theta)) / np.sin(theta)))  
            cv2.line(result2, pt1, pt2, (255), 1)  
#     cv2.imshow("yyy", cv2.resize(result2, (400,300)))
#     cv2.waitKey()
    contours1, hierarchy1 = cv2.findContours(result2, cv2.RETR_LIST, cv2.CHAIN_APPROX_SIMPLE)  
    for cnt in contours1:
        epsilon = cv2.arcLength(cnt, True)
        approx = cv2.approxPolyDP(cnt, 0.02 * epsilon, True)
        if len(approx) == 4 and cv2.contourArea(approx) > minArea and cv2.isContourConvex(approx):
            cnt = cv2.minAreaRect(cnt)
            corners = cv2.cv.BoxPoints(cnt)
            corners = np.int32(corners)
            arr = [corner[0] + corner[1] for corner in corners]
            firstIndex = arr.index(min(arr))
            cornersB = corners.tolist() * 2
            corners = cornersB[firstIndex:firstIndex + 4]
            corners = np.float32(corners)
            return corners
    raise Exception(_("无法定位发票")) 

def rotateImg(img):
    corners = findCorners(img)
    center = (sum(c[0] for c in corners) / 4, sum(c[1] for c in corners) / 4)
    p1 = np.float32((corners[0][0] + corners[3][0], corners[0][1] + corners[3][1]))
    p2 = np.float32((corners[1][0] + corners[2][0], corners[1][1] + corners[2][1]))
    p3 = np.float32((corners[0][0] + corners[1][0], corners[0][1] + corners[1][1]))
    p4 = np.float32((corners[2][0] + corners[3][0], corners[2][1] + corners[3][1]))
    width = math.sqrt((p2[0] - p1[0]) * (p2[0] - p1[0]) + (p2[1] - p1[1]) * (p2[1] - p1[1])) / 2
    height = math.sqrt((p3[0] - p4[0]) * (p3[0] - p4[0]) + (p3[1] - p4[1]) * (p3[1] - p4[1])) / 2
    h, w = img.shape[:2]
    if width < height:
        center = (center[1], center[0])
        img = imgRotate.rotate(img, 90)
    hsvImg = cv2.cvtColor(img, cv2.COLOR_RGB2HSV)
    hsvImg = cv2.inRange(hsvImg, np.array((90, 60, 50), dtype=np.uint8), np.array((140, 255, 255), dtype=np.uint8))
    c, hy = cv2.findContours(hsvImg, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)
    for cnt in c:
        if len(cnt) < 5:
            continue
        ellipse = cv2.fitEllipse(cnt)
        signetCenter, r, a = ellipse
        if  r[0] < 30 or r[1] < 50 or abs(signetCenter[0] - center[0]) > 50:
            continue
        if signetCenter[1] > center[1]:
            rot_mat = cv2.getRotationMatrix2D((w / 2, h / 2), 180, 1.0)
            img = cv2.warpAffine(img, rot_mat, (w , h), flags=cv2.INTER_LINEAR, borderValue=(255, 255, 255))
        return img
    raise Exception(_("不是增值税发票"))
    
  
# srcImg : RGB图片
def fixedPositonBySignet(srcImg):
    h, w = srcImg.shape[:2]
    img = cv2.cvtColor(srcImg, cv2.COLOR_RGB2HSV)
    img = cv2.inRange(img, np.array((90, 60, 50), dtype=np.uint8), np.array((140, 255, 255), dtype=np.uint8))
    contours0, hierarchy = cv2.findContours(img, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)
    for cnt in contours0:
        if len(cnt) < 5:
            continue
        ellipse = cv2.fitEllipse(cnt)
        center, r, ang = ellipse
        # 角度精确读不足，使用直线检测来确定偏转角度
        chileIm = cv2.getRectSubPix(srcImg, (400, 100), center)
        new_img = cv2.cvtColor(chileIm, cv2.COLOR_RGB2GRAY)
        new_img = cv2.GaussianBlur(new_img, (3, 3), 0)  
        edges = cv2.Canny(new_img, 50, 150, apertureSize=3)  
        lines = cv2.HoughLines(edges, 1, np.pi / 180, 200)
        if lines is not None:
            for line in lines[0]:  
                rho = line[0]  # 第一个元素是距离rho  
                theta = line[1]  # 第二个元素是角度theta  
                if  (theta > (np.pi / 4.)) or (theta < (3.*np.pi / 4.0)):  
                    # 该直线与第一列的交点  
                    pt1 = (0, int(rho / np.sin(theta)))  
                    # 该直线与最后一列的交点  
                    pt2 = (chileIm.shape[1], int((rho - chileIm.shape[1] * np.cos(theta)) / np.sin(theta)))  
                    M = (pt2[1] - pt1[1]) * 1.0 / (pt2[0] - pt1[0])
                    pi_angle = math.atan(M)
                    ang = pi_angle * 180 / np.pi
                    break
        else :
            ang = ang - 270
        if r[0] < 30 or r[1] < 50 or center[1] > h / 2:
            continue
        rate = r[1] / 175.8019256591797
        return center, rate, ang

def bounding(img):
    new_img = np.copy(img)
    new_img = cv2.cvtColor(new_img, cv2.COLOR_RGB2HSV)
    n = 0.0
    new_img = cv2.inRange(new_img, np.array((n, 0., 0.)), np.array((n + 25, 255., 240.)))
    cv2.imshow("new_img", new_img)
#     retval, binary = cv2.threshold(new_img, 128, 255, cv2.THRESH_BINARY)  
    contours0, hierarchy = cv2.findContours(new_img, cv2.RETR_TREE, cv2.CHAIN_APPROX_SIMPLE)
    
    for cnt in contours0:
        x, y, w, h = cv2.boundingRect(cnt)
        # 长宽还要乘缩放比例
        if h > 10 :
            cv2.rectangle(img, (x, y), (x + w, y + h), (0, 0, 0), 1)
            print x, y, w, h
            
def bounding2(img, min_h):
    new_img = cv2.cvtColor(img, cv2.COLOR_RGB2GRAY)
    new_img = cv2.adaptiveThreshold(new_img, 255, cv2.ADAPTIVE_THRESH_MEAN_C, cv2.THRESH_BINARY_INV, 9, 9)
    contours0, hierarchy = cv2.findContours(new_img, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)
    arr = []
    H, W = img.shape[:2]
    for cnt in contours0:
        x, y, w, h = cv2.boundingRect(cnt)
        # 长宽还要乘缩放比例
        if h > min_h and h < H - 2:
            arr.append([x, y, w, h])
    if len(arr) < 1:
        return 0, 0
    minX = arr[0];
    for val in arr:
        if val[0] < minX[0]:
            minX = val
    return minX[0] + minX[2] / 2, minX[1] + minX[3] / 2

# 去除比指定数值小的斑点
def denoise(img, min_w=8, min_h=10):
    retval, new_img = cv2.threshold(img, 100, 255, cv2.THRESH_BINARY_INV)
    contours0, hierarchy = cv2.findContours(new_img, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)
    for cnt in contours0:
        x, y, w, h = cv2.boundingRect(cnt)
        # 长宽还要乘缩放比例
        if h < min_h and w < min_w:
            cv2.rectangle(img, (x, y), (x + w, y + h), (255, 255, 255), -1)
            
def bounding4(img):
    img = cv2.cvtColor(img, cv2.COLOR_RGB2HSV)
    img = cv2.inRange(img, np.array((0., 0., 0.)), np.array((18., 255., 240.)))
    new_img = np.copy(img)
    contours0, hierarchy = cv2.findContours(new_img, cv2.RETR_TREE, cv2.CHAIN_APPROX_SIMPLE)
    flag = True
    arr = []
    for cnt in contours0:
        x, y, w, h = cv2.boundingRect(cnt)
        # 长宽还要乘缩放比例
        if h > 10:
#             cv2.rectangle(img, (x, y), (x + w, y + h), (255), 1)
            arr.append([x, cnt])
    minX = arr[0]
    for val in arr:
        if val[0] < minX[0]:
            minX = val
#     cv2.fillConvexPoly(img, minX[1], (0, 0, 0))
    rect = cv2.minAreaRect(minX[1])
    box = cv2.cv.BoxPoints(rect)
    box = np.int0(box)
    cv2.drawContours(img, [box], 0, (0), -1)
#     x, y, w, h = cv2.boundingRect(minX[1])
#     cv2.rectangle(img, (x, y), (x + w, y + h), (255), 1)
    return img

# 去除指定部分，index ：第几个,img 二值化后的图片
def slicePart(img, index, color=(255, 255, 255)): 
    retval, new_img = cv2.threshold(img, 180, 255, cv2.THRESH_BINARY_INV)
    contours0, hierarchy = cv2.findContours(new_img, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)
    H, W = img.shape[:2]
    arr = []
    for cnt in contours0:
        x, y, w, h = cv2.boundingRect(cnt)
        if h < 10 or w < 3:
            continue
        arr.append([x, y, w, h])
    arr.sort()
    for i in range(len(arr)):
        if i + 1 == index:
            x, y, w, h = arr[i]
            cv2.rectangle(img, (x, 0), (x + w, H), (255, 255, 255), -1)
            break
    
# 去除多余部分
def sliceSpare(img): 
    H, W = img.shape[:2]
    new_img = cv2.cvtColor(img, cv2.COLOR_RGB2GRAY)
    new_img = cv2.adaptiveThreshold(new_img, 255, cv2.ADAPTIVE_THRESH_MEAN_C, cv2.THRESH_BINARY_INV, 9, 9)
    contours0, hierarchy = cv2.findContours(new_img, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)
    for i in range(len(contours0) - 1, -1, -1):
        cnt = contours0[i]
        x, y, w, h = cv2.boundingRect(cnt)
        # 高度小于10的，高度大于H-2的（贯穿整个图片的竖线）排除
        if h < 6 or h >= H - 2 or w < 3 or w >= W - 2:
            contours0.pop(i)
    if len(contours0) == 0:
        return img
    x, y, w, h = cv2.boundingRect(np.concatenate(contours0))
    conter = (x + w / 2, y + h / 2)
    return cv2.getRectSubPix(img, (w, h), conter) 

# slice_part 需要清除的部分，x轴比例，例如：（（a,b）） 从a*w 到 b*w 的部分全部清除
def sliceImg(img, slice_part=None, color=(255, 255, 255)):
    if slice_part is not None:
        h, w = img.shape[:2]
        if isinstance(slice_part[0], float):
            cv2.rectangle(img, (np.int0(slice_part[0] * w), 0), (np.int0((slice_part[1]) * w), h), (255, 255, 255), -1)
        else:
            for part in slice_part:
                cv2.rectangle(img, (np.int0(part[0] * w), 0), (np.int0((part[1]) * w), h), (255, 255, 255), -1)

def adjustMargin(img, width=5, height=5):
    h, w = img.shape[:2]
    vis = np.ones((h + height * 2, w + width * 2), np.uint8) * 255
    vis[height:h + height, width:w + width] = img
    return vis
