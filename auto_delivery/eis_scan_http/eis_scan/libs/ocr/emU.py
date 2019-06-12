# coding=utf-8  
import cv2  
import numpy as np  

def get_angle(img):
    img = cv2.medianBlur(img, 5) 
    h, w = img.shape[:2]
    points = []
    for h1 in range(0, h, 1):
        for w1 in range(0, w, 1):
            if img[h1, w1] < 210:
                points.append([w1, h1])
    points = np.float32(np.vstack(points))
    cluster_n = 1
    em = cv2.EM(points, params=dict(nclusters=cluster_n, cov_mat_type=cv2.EM_COV_MAT_GENERIC))
    means = em.getMeans()
    x, y = means[0]
    return 49.0 / 2 - y

def data_rotate_angle(dataImg):
    dataImg = cv2.cvtColor(dataImg, cv2.COLOR_RGB2GRAY)
    dataImg = cv2.medianBlur(dataImg, 5) 
    h, w = dataImg.shape[:2]
    points = []
    for h1 in range(0, h, 1):
        for w1 in range(0, w, 1):
            if dataImg[h1, w1] < 240:
                points.append([w1, h1])
    points = np.float32(np.vstack(points))
    cluster_n = 1
    em = cv2.EM(points, params=dict(nclusters=cluster_n, cov_mat_type=cv2.EM_COV_MAT_GENERIC))
    covs = em.getCovs()
    ww, u, vt = cv2.SVDecomp(covs[0])
    ang = np.arctan2(u[1, 0], u[0, 0]) * (180 / np.pi)
    return ang
