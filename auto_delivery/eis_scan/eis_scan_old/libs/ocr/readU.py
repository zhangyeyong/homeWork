# coding:utf-8
import tesseract
import cv2
from libs.ocr.cv2 import cv as cv
from config import config
from tool import pathJoin
from numpy.core.numerictypes import void

api = tesseract.TessBaseAPI()
# api.Init("D:\devTool\OCR\Tesseract-OCR", "num1+num2+num5+eng", tesseract.OEM_DEFAULT)

mode_param = {
              'AUTO':tesseract.PSM_AUTO,
              'SINGLE_LINE':tesseract.PSM_SINGLE_LINE,
              'SINGLE_BLOCK':tesseract.PSM_SINGLE_BLOCK
              }

def get_text(img, lang, mode, whitelist=""):
    api.Init(str(pathJoin(config.rootPath, "thirdSoft/Tesseract-OCR")), lang, tesseract.OEM_DEFAULT)
    api.SetVariable("tessedit_char_whitelist", whitelist)
    api.SetPageSegMode(mode_param[mode])
    cvmat_image = cv.fromarray(img)
    image = cv.GetImage(cvmat_image)
    tesseract.SetCvImage(image, api)
    print "start GetUTF8Text"
    text = api.GetUTF8Text()
    print "end GetUTF8Text"
    return text

if __name__ == "__main__":
    api = tesseract.TessBaseAPI()
    api.Init(str(pathJoin(config.rootPath, "thirdSoft/Tesseract-OCR")), "eng", tesseract.OEM_DEFAULT)
    api.SetPageSegMode(tesseract.PSM_SINGLE_LINE)
    api.SetVariable("save_best_choices", "T")
    img = cv2.imread("1.jpg", 0)
    cvmat_image = cv.fromarray(img)
    image = cv.GetImage(cvmat_image)
    tesseract.SetCvImage(image, api)
    text = api.GetUTF8Text()
    print text
    api.Recognize(None)
    ri = api.GetIterator()
    level = tesseract.RIL_WORD
    count = 0
    while (ri):
        word = ri.GetUTF8Text(level)
        conf = ri.Confidence(level)
        print("[%03d]:\tword(confidence)=%s(%.2f%%)" % (count, word, conf))
        count += 1
        if not ri.Next(level):
            break
