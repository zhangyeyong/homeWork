# coding:utf-8
from libs.web.utils import Storage
from i18n.i18nU import _
pageSize = 10
#以下3个参数为判断空白页参数，非空白占有率、边框长度、阈值
pixerRatio = 0.5
blackBorderWidth = 10
threshold = 230

tickerDict={}
CODE_SUCCESS = "S"
CODE_FAILURE = "F"
imgType = Storage({
                   "ADDED":'ADDED',
                   "COMMON":"COMMON"
                   })
ocrResultType = Storage({
                         "PROGRAM":'PROGRAM',
                         "CHECK":'CHECK'
                         })
belongType = Storage({
                         "DAILY_SCAN":'DAILY_SCAN',
                         "APPRAISE_TASK":'APPRAISE_TASK',
                         "NO_TASK":'NO_TASK'
                         })
belongTypeShow = Storage({
                         "DAILY_SCAN":_('日常扫描'),
                         "APPRAISE_TASK":_('评价任务'),
                         "NO_TASK":_('无任务补扫')
                         })
headStatus = Storage({
                       "TODO":"TODO",
                       "WAIT":"WAIT",
                       "UPLOADING":"UPLOADING",
                       "SUCCESS":"SUCCESS",
                       "FAILURE":"FAILURE",
                       "BACK":"BACK"
                    })
#headStatus :1 正常的normal，可增，删，改，2.只能补扫 （add_only）    3.closed:不能下载，不能上传      
headStatus2 = Storage({
                       "NORMAL":"NORMAL",
                       "ADD_ONLY":"ADD_ONLY",
                       "CLOSED":"CLOSED"
                    })
# 任务状态（等待WAITING，上传UPLOADING）
taskStatus = Storage({
                       "WAITING":"WAITING",
                       "UPLOADING":"UPLOADING"
                    })

headStatusShow = Storage({
                       "TODO":_("初始状态"),
                       "WAIT":_("待上传"),
                       "WAITING":_("等待上传"),
                       "UPLOADING":_("正在上传"),
                       "SUCCESS":_("上传成功"),
                       "FAILURE":_("上传失败"),
                       "BACK":_("退回")
                    })
configkey = Storage({
                       "IS_PASV":"IS_PASV",
                       "HTTP_UPLOAD_URL":"HTTP_UPLOAD_URL",
                       "EIS_IP":"EIS_IP",
                       "EIS_PORT":"EIS_PORT",
                       "VIRTUAL_PATH":"VIRTUAL_PATH",
                       "DS_NAME":"DS_NAME",
                       "PIXERRATIO":"PIXERRATIO",
                       "BARCODE_RULE":"BARCODE_RULE",
                       "COMPANY_CODE":"COMPANY_CODE_",
                       "SITE_ID":"SITE_ID_",
                       "OPERATION_TYPE_CODE":"OPERATION_TYPE_CODE_",
                       "SCAN_CONFIG":"SCAN_CONFIG",
                       "DPI":"DPI",
                       "CONTRAST":"CONTRAST",
                       "COMPRESS":"COMPRESS"
                    }) 
#定时TIME，实时NOW
taskType = Storage({
                       "NOW":"NOW",
                       "TIME":"TIME",
                       "NORMAL":"NORMAL",
                       "BACKTASK":"BACKTASK",
                       "NOTASK":"NOTASK"
                    }) 
#headStatus :1 正常的normal，可增，删，改，2.只能补扫 （add_only）    3.closed:不能下载，不能上传      
ftpStatus = Storage({
                       "NORMAL":"NORMAL",
                       "ADD_ONLY":"ADD_ONLY",
                       "CLOSED":"CLOSED"
                    })
