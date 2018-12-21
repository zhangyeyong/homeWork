# coding:utf-8
def buildFail(info, data=None):
    rtn = {}
    rtn["isSuccess"] = False
    rtn["info"] = info
    rtn["data"] = data
    return rtn
def buildSuccess(info=None, data=None):
    rtn = {}
    rtn["isSuccess"] = True
    rtn["info"] = info
    rtn["data"] = data
    return rtn
if __name__ == '__main__':
    for i in range(5):
        for j in range(5):
            for k in range(5):
                if i == j == k == 3:
                    break
                else:
                    print i, '----', j, '----', k
            else: continue
            break
        else: continue
        break
    pass