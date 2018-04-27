# coding:utf-8
import re
import math
pattern = re.compile(r'((^((1[8-9]\d{2})|([2-9]\d{3}))([-\/\._])(10|12|0?[13578])([-\/\._])(3[01]|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))([-\/\._])(11|0?[469])([-\/\._])(30|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))([-\/\._])(0?2)([-\/\._])(2[0-8]|1[0-9]|0?[1-9])$)|(^([2468][048]00)([-\/\._])(0?2)([-\/\._])(29)$)|(^([3579][26]00)([-\/\._])(0?2)([-\/\._])(29)$)|(^([1][89][0][48])([-\/\._])(0?2)([-\/\._])(29)$)|(^([2-9][0-9][0][48])([-\/\._])(0?2)([-\/\._])(29)$)|(^([1][89][2468][048])([-\/\._])(0?2)([-\/\._])(29)$)|(^([2-9][0-9][2468][048])([-\/\._])(0?2)([-\/\._])(29)$)|(^([1][89][13579][26])([-\/\._])(0?2)([-\/\._])(29)$)|(^([2-9][0-9][13579][26])([-\/\._])(0?2)([-\/\._])(29)$))')
pNum = re.compile(r'^(-?\d+)(\.\d+)?$')
from aifc import Error
# import sys
# default_encoding = 'utf-8'
# if sys.getdefaultencoding() != default_encoding:
#     reload(sys)
#     sys.setdefaultencoding(default_encoding)

def handle_str(invoiceSet):
    if(invoiceSet == None or invoiceSet == ""):
        return ""
#     return invoiceSet.strip().replace(' ', '')
    return invoiceSet.strip().replace(' ', '').replace('—', '-')

# 判断src中是否包含不在exp中的字符
def error_str(src, exp="0123456789"):
    for c in src:
        if c not in exp:
#             print "src", src, " error char:", c, ' index:', src.index(c), " exp:", exp
            return False
    return True
        
def check(ret):
    if ret == None or len(ret) == 0:
        return
    # 确定密码区类型
    ispwd84 = True
    pwd3 = ret['rpwd']
    pwd3Arr = pwd3.split("\n")
    for i in range(len(pwd3Arr) - 1, -1, -1):
        s = pwd3Arr[i]
        if len(s.strip().replace(' ', '')) < 4:
            pwd3Arr.pop(i)
    if len(pwd3Arr) > 3 :   
        ispwd84 = False 
    if ispwd84:
        ret['apwd'] = ret['lpwd']
        pwd = ret['lpwd']
        ret.pop('lpwd')    
    for key, value in ret.items():
        value = handle_str(value)
        if key in ['rpwd']:  # pwd3 用来校验代码和号码的
            ret[key] = value
            continue
        #字符合法性校验++++++++++++++++++
        exp = "0123456789"
        if key == 'apwd':
            exp += "<>+-/*\n"
        if key == 'bTaxPayer' or key == 'sTaxPayer':
            exp += "xX"
        ret[key + "R"] = error_str(value, exp)
        
        # 格式补全：时间加‘-’，价格加上小数点，税率加上‘%’
        if key == "tax":
            value = value + "%"
        if key == "invDate":
            value = value[:4] + "-" + value[4:6] + "-" + value[6:8]
        if key == "taxAmount" or key == "amount" or key == "total":
            if value != "":
#                 text = filter(lambda ch: ch in "0123456789.", value)
                value = value[:-2] + "." + value[-2:]
        if key == "bTaxPayer" or key == "sTaxPayer":
            if value != "":
                value = value.replace('x', 'X')
        ret[key] = value
    #长度校验++++++++++++++++++    
    # 发票代码
    code = ret['code']
    if len(code) != 10:
        ret['codeR'] = False
    # 发票号码
    num = ret['num']
    if len(num) != 8:
        ret['numR'] = False
    # 购方税号
    bTaxPayer = ret['bTaxPayer']
    if len(bTaxPayer) < 15 or len(bTaxPayer) > 20:
        ret['bTaxPayerR'] = False
    # 销方税号
    sTaxPayer = ret['sTaxPayer']
    if len(sTaxPayer) < 15 or len(sTaxPayer) > 20:
        ret['sTaxPayerR'] = False
    # 密码
    apwd = ret['apwd'].split("\n")
    if len(apwd) != 4:
        ret['apwdR'] = False
    for row in apwd:
        if (ispwd84 and len(row) != 21) or (not ispwd84 and len(row) != 27):
            ret['apwdR'] = False
            break
    # 代码、号码校验
    if ispwd84:
        if len(pwd3Arr) >= 3:
            if pwd3Arr[1] != ret['code']:
                ret['codeR'] = False
            if pwd3Arr[2] != ret['num']:
                ret['numR'] = False
    #格式校验+++++++++++++++++++++++++++
    if pattern.match(ret['invDate']) is None:
        ret['invDateR'] = False
    # 金额 校验+++++++++++++++++++++++++++
    #        1、金额*税率=税额
    #        2、金额+税额=总额
    #        3、金额*（100%+税率）=总额
    #        4、税额/税率+税额=总额
    errorCount = 0
    amount = ret['amount']
    if pNum.match(amount) is None:
        ret['amountR'] = False
        amount = 0
        errorCount += 1
    else :
        amount = float(amount)
    tax = ret['tax'][:-1]
    if pNum.match(tax) is None:
        ret['taxR'] = False
        tax = 0
        errorCount += 1
    else :
        tax = float(tax)
    taxAmount = ret['taxAmount']
    if pNum.match(taxAmount) is None:
        ret['taxAmountR'] = False
        taxAmount = 0
        errorCount += 1
    else :
        taxAmount = float(taxAmount)
    total = ret['total']
    if pNum.match(total) is None:
        ret['totalR'] = False
        total = 0
        errorCount += 1
    else :
        total = float(total)
        
    if errorCount < 2: 
        # 允许偏差的范围数值   
        threshold = 0.04
        flag1 = abs(round(amount * tax / 100, 2) - taxAmount) <= threshold
        flag2 = abs(amount + taxAmount - total) <= threshold
        flag3 = abs(round(amount * tax / 100, 2) + amount - total) <= threshold
        flag4 = False if tax == 0 else abs(round(taxAmount * 100 / tax, 2) + taxAmount - total) <= threshold
        ret['amountR'] = False
        ret['taxAmountR'] = False
        if flag1 == False:
            if flag2 == True:
                ret['taxR'] = False
                ret['amountR'] = True
                ret['taxAmountR'] = True
            if flag3 == True:
                ret['taxAmountR'] = False
                ret['taxR'] = True
                ret['amountR'] = True
            if flag4 == True:
                ret['amountR'] = False
                ret['taxR'] = True
                ret['taxAmountR'] = True
        else:
            ret['taxR'] = True
            ret['amountR'] = True
            ret['taxAmountR'] = True    
    else:
        ret['taxR'] = False
        ret['amountR'] = False
        ret['taxAmountR'] = False
