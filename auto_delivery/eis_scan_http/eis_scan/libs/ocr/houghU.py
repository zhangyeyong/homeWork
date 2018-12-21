# coding=utf-8  
import cv2  
import numpy as np    
  
def houghLines(img):
    img = cv2.GaussianBlur(img, (3, 3), 0)  
    edges = cv2.Canny(img, 50, 150, apertureSize=3)  
    lines = cv2.HoughLines(edges, 1, np.pi / 180, 118)  # 这里对最后一个参数使用了经验型的值  
    result = img.copy()  
    for line in lines[0]:  
        rho = line[0]  # 第一个元素是距离rho  
        theta = line[1]  # 第二个元素是角度theta  
        if  (theta < (np.pi / 4.)) or (theta > (3.*np.pi / 4.0)):  # 垂直直线  
                    # 该直线与第一行的交点  
            pt1 = (int(rho / np.cos(theta)), 0)  
            # 该直线与最后一行的焦点  
            pt2 = (int((rho - result.shape[0] * np.sin(theta)) / np.cos(theta)), result.shape[0])  
            # 绘制一条白线  
            cv2.line(result, pt1, pt2, (0),2)  
        else:  # 水平直线  
            # 该直线与第一列的交点  
            pt1 = (0, int(rho / np.sin(theta)))  
            # 该直线与最后一列的交点  
            pt2 = (result.shape[1], int((rho - result.shape[1] * np.cos(theta)) / np.sin(theta)))  
            # 绘制一条直线  
            cv2.line(result, pt1, pt2, (0), 2)  
    return result  
   
def houghLinesP(img):
    img = cv2.GaussianBlur(img, (3, 3), 0)  
    edges = cv2.Canny(img, 50, 150, apertureSize=3)  
    # 经验参数  
    minLineLength = 100
    maxLineGap = 30  
    lines = cv2.HoughLinesP(edges, 2, np.pi / 180, 70, minLineLength=minLineLength, maxLineGap=maxLineGap)  
    for x1, y1, x2, y2 in lines[0]:  
        cv2.line(img, (x1, y1), (x2, y2), (37, 42, 191), 1) 
    return img   
 
def clear_horizontal_line(img):
    h, w = img.shape[:2]
    img = cv2.resize(img, (w * 2, h * 2))
    edges = cv2.Canny(img, 50, 150, apertureSize=5)
    lines = cv2.HoughLines(edges, 1, np.pi / 180, 118)
    minLineLength = w / 2
    maxLineGap = 10
    lines = cv2.HoughLinesP(edges, 1, np.pi / 180, 90, lines, minLineLength, maxLineGap)
    if lines == None:
        return img
    h, w = img.shape[:2]
    yArr = []
    for x1, y1, x2, y2 in lines[0]:
        yArr.append(y1)
    rp = []
    yMin = min(yArr)
    yMin = yMin - 1 if yMin > 1 else 0
    yMax = max(yArr)
    yMax = yMax + 2 if h - yMax > 2 else yMax
    for x1, y1, x2, y2 in lines[0]:
        for k in range(yMin, max(yArr)):
            rArr = []
            for g in range(w):
                rArr.append(img[k][g])
            rArr.sort()
            rp.append(rArr[len(rArr) / 2])
    minR = min(rp)
    rgb_threshold = 20
    for k in range(yMin, yMax):
        for g in range(w):
            if img[k][g] >= minR - rgb_threshold:
                img[k][g] = 255
#     img = cv2.medianBlur(img, 3)  
    img = cv2.resize(img, (w / 2, h / 2))
    return img 
