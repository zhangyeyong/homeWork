# coding:utf-8

def loop_data1(img, h, w):
    arr = []
    for y in range(h - 1, -1, -1):
        for x in range(w - 1, -1, -1):
            if img[y][x] < 200 :
                if len(arr) > 0 and (abs(arr[-1][0] - x) > 1 or abs(arr[-1][1] - y) > 1):
                    arr = []
                arr.append([x, y])
                if len(arr) >= 5:
                    for k in arr:
                        if k[1] >= h - 1:
                            return []
                    return arr

def loop_data2(img, h, w):
    arr = []
    for y in range(h):
        for x in range(w - 1, -1, -1):
            if img[y][x] < 200 :
                if len(arr) > 0 and (abs(arr[-1][0] - x) > 1 or abs(arr[-1][1] - y) > 1):
                    arr = []
                arr.append([x, y])
                if len(arr) >= 5:
                    for k in arr:
                        if k[1] <= 1:
                            return []
                    return arr
                
def get_yoffset(img):
    h, w = img.shape[0:2]
    arr = loop_data1(img, h, w)
    n = -1
    if arr == []:
        arr = loop_data2(img, h, w)
        n = 1
    num = arr[0][1] - h * 1.0 / 2 + 1
    print arr
    offset = num + n * (h + 1) * 8.0 / 50  
    print offset
    return int(offset)

def get_xoffset(img):
    h, w = img.shape[0:2]
    arr = loop_data1(img, h, w)
    n = -1
    if arr == []:
        arr = loop_data2(img, h, w)
        n = 1
    num = arr[0][1] - h * 1.0 / 2
    offset = num + n * (h + 1) * 8.0 / 50  
    return int(offset)
