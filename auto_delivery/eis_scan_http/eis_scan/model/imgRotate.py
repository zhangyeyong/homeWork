# -*- coding: utf-8 -*- 
from libs.ocr import cv2
import numpy as np
from numpy.ma.core import max
def rotateImgFile(fileName, angle):  
    cv2.imwrite(fileName, rotate(cv2.imread(fileName),angle))
def rotate(img, angle):  
    # 只能是90的倍数
    h, w = img.shape[:2]
    m = max([h, w])
    res = np.zeros((m, m, 3), np.uint8)
    res[(m - h) / 2:(m + h) / 2, (m - w) / 2:(m + w) / 2, :] = img
    center = (m / 2, m / 2)
    rot_mat = cv2.getRotationMatrix2D(center, angle, 1.0)
    res = cv2.warpAffine(res, rot_mat, (m , m), flags=cv2.INTER_LINEAR, borderValue=(255, 255, 255))
    if angle / 90 % 2 == 0:
        return res[(m - h) / 2:(m + h) / 2, (m - w) / 2:(m + w) / 2, :]
    else:
        return res[(m - w) / 2:(m + w) / 2, (m - h) / 2:(m + h) / 2, :]  
if __name__=="__main__":
    img = cv2.imread("E:/Downloads/20140626113100_1.GIF")
    cv2.imshow("aaa", img)
    cv2.waitKey()