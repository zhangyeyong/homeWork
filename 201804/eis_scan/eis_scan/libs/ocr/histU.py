# coding=utf-8  
import cv2  
import numpy as np  

def hist_handle(image):
    lut = np.zeros(256, dtype=image.dtype)  # 创建空的查找表  
    hist = cv2.calcHist([image],  # 计算图像的直方图  
        [0],  # 使用的通道  
        None,  # 没有使用mask  
        [256],  # it is a 1D histogram  
        [0.0, 255.0])  
    
    minBinNo, maxBinNo = 0, 255  
      
    # 计算从左起第一个不为0的直方图柱的位置  
    for binNo, binValue in enumerate(hist):  
        if binValue != 0:  
            minBinNo = binNo  
            break  
    # 计算从右起第一个不为0的直方图柱的位置  
    for binNo, binValue in enumerate(reversed(hist)):  
        if binValue != 0:  
            maxBinNo = 255 - binNo  
            break  
      
    # 生成查找表，方法来自参考文献1第四章第2节  
    for i, v in enumerate(lut):  
        if i < minBinNo:  
            lut[i] = 0  
        elif i > maxBinNo:  
            lut[i] = 255  
        else:  
            lut[i] = int(255.0 * (i - minBinNo) / (maxBinNo - minBinNo) + 0.5)  
      
    # 计算  
    result = cv2.LUT(image, lut) 
    return  result

def np_hist_handle(image):
    lut = np.zeros(256, dtype=image.dtype)  # 创建空的查找表  
    hist, bins = np.histogram(image.flatten(), 256, [0, 256])
    cdf = hist.cumsum()  # 计算累积直方图  
    cdf_m = np.ma.masked_equal(cdf, 0)  # 除去直方图中的0值  
    cdf_m = (cdf_m - cdf_m.min()) * 255 / (cdf_m.max() - cdf_m.min())  # 等同于前面介绍的lut[i] = int(255.0 *p[i])公式  
    cdf = np.ma.filled(cdf_m, 0).astype('uint8')  # 将掩模处理掉的元素补为0  
      
    # 计算  
    result2 = cdf[image]  
    result = cv2.LUT(image, cdf)    
    return result

def cv_hist_handle(image):
    result = cv2.equalizeHist(image)
    return result
