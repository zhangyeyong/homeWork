# coding:utf-8
import twain
from Tkinter import Tk
import os
import time
import config
import traceback

SM = None
SD = None
root = Tk()
pixel_type_map = {'bw': twain.TWPT_BW,
                  'gray': twain.TWPT_GRAY,
                  'color': twain.TWPT_RGB}

def cleanFile(dir_clean):
    list_dirs = os.walk(dir_clean) 
    for root, dirs, files in list_dirs:
        for f in files:
            os.remove(os.path.join(root, f))
def scan(ds_name, paramDict):
    cleanFile(config.scanPath)
    res = []
    fileNamePre = os.path.join(config.scanPath, time.strftime('%Y%m%d%H%M%S_'))
    print "----------------fileNamePre:%s" % fileNamePre
    imageFormat = paramDict.get("imageFormat", "jpg")
    show_ui = paramDict.get("show_ui", False)
    def before(img_info):
        fileName = "%s%d.%s" % (fileNamePre, len(res), imageFormat)
        img_info["path"] = fileName
        res.append(img_info)
        return fileName
    
    def after(more):
        print "---------------------------------"
        print more
        if more == 0:
            raise twain.CancelAll
    SD = getSD(ds_name);
    try:
        print "start init SD"
        initSD(SD, paramDict)
        print "end init SD"
        print "start acquire_file"
        SD.acquire_file(before=before, after=after, show_ui=show_ui)
        print "end acquire_file"
    except twain.excDSTransferCancelled:
        print "excDSTransferCancelled"
    except twain.excTWCC_SEQERROR:
        print "excTWCC_SEQERROR"
    except Exception, e:
        print e
        print traceback.format_exc()
    finally:
        print "start close SD"
        if hasattr(SD, "close"):
            print "SD hasattr close"
            SD.close()
        print "end close SD"
    return res   
def getSM():  
    global SM
    global root
    if not root:
        root = Tk()
    if not SM:        
        SM = twain.SourceManager(root, dsm_name=None)  
    return SM
def getSD(ds_name=None):
    global SD
    if SD and hasattr(SD, "close"):
        SD.close()
        SD = None
    print "start OpenSource"
    if not ds_name or "None" == ds_name.strip():
        dsList = getDsList()
        if dsList and len(dsList) > 0:
            ds_name = dsList[0]       
    SD = getSM().OpenSource(ds_name) 
    print "end OpenSource"   
    return SD
def initSD(SD, paramDict): 
    try: 
        if not paramDict:
            paramDict = {}
        dpi = paramDict.get("dpi", 200)
        pixel_type = paramDict.get("pixel_type", "color")
        bpp = paramDict.get("bpp")
        frame = paramDict.get("frame")  # 默认A4纸
        if not frame:
            frame = (0, 0, 8.17551, 11.45438)
        contrast = paramDict.get("contrast")    
        threshold = paramDict.get("threshold")    
        duplex = paramDict.get("duplex")    
        brightness = paramDict.get("brightness")    
        discardblankpages = paramDict.get("discardblankpages")    
        
        # 单位
        SD.set_capability(twain.ICAP_UNITS, twain.TWTY_UINT16, twain.TWUN_INCHES)
        
        twain_pixel_type = pixel_type_map.get(pixel_type)
        
        # 纸张大小    
        if frame:
            try:
                SD.set_image_layout(frame)
            except twain.CheckStatus:
                print "set_image_layout CheckStatus error"
        
        # 图片类型(在保存图片时的扩展名)
    
        # 分辨率
        if dpi:
            dpi = int(dpi)
            SD.set_capability(twain.ICAP_XRESOLUTION, twain.TWTY_FIX32, dpi)
            SD.set_capability(twain.ICAP_YRESOLUTION, twain.TWTY_FIX32, dpi)
        # 颜色
        if twain_pixel_type:
            SD.set_capability(twain.ICAP_PIXELTYPE, twain.TWTY_UINT16, twain_pixel_type)
        # 双面 Type: TW_BOOL Default Value: FALSE Allowed Values: TRUE or FALSE
        if duplex:
            try:
                duplex = str2bool(duplex)
                SD.set_capability(twain.CAP_DUPLEXENABLED, twain.TWTY_BOOL, duplex)
            except Exception:
                print traceback.format_exc()
        # 默认项？？？？
        # 亮度 Type: TW_FIX32 Default Value: 0 Allowed Values: -1000 to +1000
        if brightness:
            try:
                brightness = int(brightness)-128      
                if brightness>127:
                    brightness=127
                elif brightness<-127:
                    brightness = -127     
                SD.set_capability(twain.ICAP_BRIGHTNESS, twain.TWTY_FIX32, brightness)
            except Exception:
                print traceback.format_exc()
        # 对比度 Type: TW_FIX32 Default Value: 0 Allowed Values: -1000 to +1000
        if contrast: 
            try:
                contrast = int(contrast)-128      
                if contrast>127:
                    contrast=127
                elif contrast<-127:
                    contrast = -127
                SD.set_capability(twain.ICAP_CONTRAST, twain.TWTY_FIX32, contrast)  
            except Exception:
                print traceback.format_exc()
        # 阈值 Type: TW_FIX32 Default Value: 128 Allowed Values: 0 to 255
        if threshold:   
            try:
                threshold = int(threshold)     
                SD.set_capability(twain.ICAP_THRESHOLD, twain.TWTY_FIX32, threshold)  
            except Exception:
                print traceback.format_exc()
        # 压缩比 在应用中使用
        
        if bpp:
            try:
                bpp = int(bpp)     
                SD.set_capability(twain.ICAP_BITDEPTH, twain.TWTY_UINT16, bpp)
            except Exception:
                print traceback.format_exc()
            
        # 删除空白页Type: TW_INT32 Default Value: TW_DISABLE Allowed Values: TWBP_DISABLE TWBP_AUTO Byte count 0 to 231-1
        if discardblankpages:
            try:
                discardblankpages = str2bool(discardblankpages)
                if  discardblankpages:   
                    SD.set_capability(twain.ICAP_AUTODISCARDBLANKPAGES, twain.TWTY_INT32, twain.TWBP_AUTO)
                else:
                    SD.set_capability(twain.ICAP_AUTODISCARDBLANKPAGES, twain.TWTY_INT32, twain.TWBP_DISABLE)
            except Exception:
                    print traceback.format_exc()
    
        try:
            SD.set_capability(twain.ICAP_AUTOMATICROTATE, twain.TWTY_BOOL, True)   
        except:
            print "set_capability ICAP_AUTOMATICROTATE error"
        try:
            SD.set_capability(twain.ICAP_AUTOMATICBORDERDETECTION, twain.TWTY_BOOL, True)
        except:
            print "set_capability ICAP_AUTOMATICBORDERDETECTION error"
    except twain.excDSTransferCancelled:
        print "excDSTransferCancelled"
    except twain.excTWCC_SEQERROR:
        print "excTWCC_SEQERROR"
    except Exception, e:
        print e
        print traceback.format_exc()
def getDsList(dsm_name=None):
    return getSM().GetSourceList()
def str2bool(v):
    return v.lower() in ("yes", "true", "t", "1")
if __name__ == "__main__":
    while True:
        print "start"
        order = raw_input('input order:')
        print "you input:" + order
        print scan(ds_name='FUJITSU fi-6140dj #2',
#                    dpi=300, 
                   pixel_type="color",
                   bpp=None, contrast=None,
                   frame=(0, 0, 8.17551, 11.45438),
                   show_ui=False)
        if order == 'q':
            print "quite"
            break
