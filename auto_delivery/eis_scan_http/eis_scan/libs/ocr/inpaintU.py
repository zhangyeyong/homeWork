# coding=utf-8  
import cv2  
import numpy as np
import houghU  

# img 为灰度图
# threshold 线长，thickness：线粗细    inpaintRadius：修复半径
def inpaint(img, threshold=50, minLineLength=50, maxLineGap=5, thickness=2, inpaintRadius=3):
    edges = cv2.Canny(img, 50, 150, apertureSize=3)  
    # 经验参数  
    lines = cv2.HoughLinesP(edges, 1, np.pi / 180, threshold, minLineLength=minLineLength, maxLineGap=maxLineGap)  
    if lines is None:
        return img
    result = np.zeros(img.shape[:2], np.uint8)
    count = 0
    h, w = img.shape[:2]
    for x1, y1, x2, y2 in lines[0]:
        if y1 + 2 <= h:
            y1 = y1 + 2
        if y2 + 2 <= h:
            y2 = y2 + 2
        cv2.line(img, (x1, y1), (x2, y2), (255, 255, 255), thickness)
    return cv2.inpaint(img, result, inpaintRadius, cv2.INPAINT_TELEA)

