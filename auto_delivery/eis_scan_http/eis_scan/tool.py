# coding:utf-8
# 工具类，如自动提取关键字，将字典转换为对象等
from os.path import join 
import os

# 路径join
def pathJoin(a, *p):
    newP = []
    for temp in p:
        if temp.startswith("/") or temp.startswith("\\"):
            newP.append(temp[1:])
        else:
            newP.append(temp)
    return join(a, *newP).replace("\\", "/")
    
if __name__=="__main__":
    aa= "abcd"
    print aa[-1]
    print pathJoin("a/","/b/","\\c/")
    print pathJoin("d:/zz/","/aa")
    print os.path.join("d:/zz/","/aa")