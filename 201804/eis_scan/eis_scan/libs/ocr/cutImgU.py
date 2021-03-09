# coding=utf-8  
import cv2  
import numpy as np  

def cutTaxPayer(img):
    new_img = cv2.cvtColor(img, cv2.COLOR_RGB2GRAY)
    new_img = cv2.adaptiveThreshold(new_img, 255, cv2.ADAPTIVE_THRESH_GAUSSIAN_C, cv2.THRESH_BINARY_INV, 9 , 9)
    contours0, hierarchy = cv2.findContours(new_img, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)
    H, W = img.shape[:2]
    result = np.zeros((H, W), np.uint8)
    for i in range(len(contours0) - 1, -1, -1):
        cnt = contours0[i]
        x, y, w, h = cv2.boundingRect(cnt)
        if w < 10 or h < 10:
            contours0.pop(i)
        else :
            cv2.rectangle(result, (x, y), (x + w, y + h), (255), 1)
            
    for h in range(H):
        for w in range(W):
            if  result[h][w] == 255:
                cv2.line(result, (0, h), (W, h), (255))
                break
    contours1, hierarchy1 = cv2.findContours(result, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)
    # for cnt in contours1:
    #     x, y, w, h = cv2.boundingRect(cnt)  
    #     cv2.rectangle(img, (x, y), (x + w, y + h), (0, 0, 0), 1)
    #     print x, y
    # cv2.imshow("xxx1", img)
    if len(contours1) < 2:
        return np.ones((H / 4, W * 3 / 4, 3), np.uint8) * 255 
    x, y, w, h = cv2.boundingRect(contours1[-2])  
    conter = (x + w / 2, y + h / 2)
    img = cv2.getRectSubPix(img, (w, h), conter)
    return img
