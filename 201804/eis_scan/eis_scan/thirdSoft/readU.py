# coding:utf-8
import tesseract
from libs.ocr.cv2 import cv
from tool import pathJoin 
from config.config import rootPath

api = tesseract.TessBaseAPI()
# api.Init("D:\devTool\OCR\Tesseract-OCR", "num1+num2+num5+eng", tesseract.OEM_DEFAULT)

mode_param = {
              'AUTO':tesseract.PSM_AUTO,
              'SINGLE_LINE':tesseract.PSM_SINGLE_LINE,
              'SINGLE_BLOCK':tesseract.PSM_SINGLE_BLOCK
              }

def get_text(img, lang, mode, whitelist=""):
    api.Init(str(pathJoin(rootPath, "thirdSoft/Tesseract-OCR")), lang, tesseract.OEM_DEFAULT)
    api.SetVariable("tessedit_char_whitelist", whitelist)
    api.SetPageSegMode(mode_param[mode])
    cvmat_image = cv.fromarray(img)
    image = cv.GetImage(cvmat_image)
    tesseract.SetCvImage(image, api)
    text = api.GetUTF8Text()
    return text
