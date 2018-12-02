# coding:utf-8
# 控制器模块，分发URL请求，并响应响应的视图
from libs import web
from config import config
import os
from i18n import i18nU
urls = (
        '/', 'service.scanService.scan',
        '/login', 'service.loginService.login',
        '/logout', 'service.loginService.logout',
        '/result', 'service.resultService.resultQuery',
        '/scan', 'service.scanService.scan',
        '/dailyScan', 'service.scanService.dailyScan',
        '/asyncScan', 'service.scanService.asyncScan',
        '/rescan', 'service.scanService.rescan',
        '/replaceScan', 'service.scanService.replaceScan',
        '/addScan', 'service.scanService.addScan',
        '/editImg', 'service.scanService.editImg',
        '/importImg', 'service.scanService.importImg',
        '/deleteImg', 'service.scanService.deleteImg',
        '/moveImg', 'service.scanService.moveImg',
        '/rotateImg', 'service.scanService.rotateImg',
        '/goToImg', 'service.scanService.goToImg',
        '/editNum', 'service.scanService.editNum',
        '/editHead', 'service.scanService.editHead',
        '/addTask', 'service.scanService.addTask',
        '/delTask', 'service.scanService.delTask',
        '/getTask', 'service.scanService.getTask',
        '/appraiseTaskQuery', 'service.scanService.appraiseTaskQuery',
        '/appraiseTaskAddScan', 'service.scanService.appraiseTaskAddScan',
        '/noTaskQuery', 'service.scanService.noTaskQuery',
        '/noTaskAddScan', 'service.scanService.noTaskAddScan',
        '/showImages', 'service.scanService.showImages',
        '/getClientParams', 'service.scanService.getClientParams',
        '/uploadFile', 'service.scanService.uploadFile',
        '/reUploadFile', 'service.scanService.reUploadFile',
        '/backForModify', 'service.scanService.backForModify',
        '/delTaskOnResultPage', 'service.scanService.delTaskOnResultPage',
        '/changeapp', 'service.scanService.changeapp',
        '/saveUserForm', 'service.scanService.saveUserForm',
        '/saveUserFormByHead', 'service.scanService.saveUserFormByHead',
        '/recognition', 'service.recognitionService.recognitionQuery',
        '/confirmRecognition/(.*)', 'service.recognitionService.confirmRecognition',
        '/recognitionDetail/(.*)', 'service.recognitionService.recognitionDetail',
        '/configure', 'service.configService.configure',
        '/queue', 'service.scanService.queue',
        '/testCom', 'service.testService.testCom',
        '/delivery/index', 'service.deliveryService.Index',
        '/delivery/scan', 'service.deliveryService.Scan',
        '/delivery/submit', 'service.deliveryService.Submit',
        '/delivery/refund', 'service.deliveryService.Refund',
        '/delivery/machineError', 'service.deliveryService.MachineError',
        '/delivery/edit', 'service.deliveryService.Edit',
        '/exceptImg', 'service.scanService.exceptImg',
        )

def cleanFile(dir_clean):
    list_dirs = os.walk(dir_clean) 
    for root, dirs, files in list_dirs:
        for f in files:
            os.remove(os.path.join(root, f))

class MyApplication(web.application):
    def run(self, port=8080, *middleware):
        func = self.wsgifunc(*middleware)
        return web.httpserver.runsimple(func, ('0.0.0.0', port))

def initSession():
#     cleanFile(os.path.join(config.rootPath,"sessions"))
    if web.config.get('_session') is None:
        web.config._session = web.session.Session(
                                                  app,
                                                  web.session.DiskStore('sessions'),
                                                )
app = MyApplication(urls, globals())
# app = web.application(urls, globals()) 
initSession()
render = web.template.render(
                             os.path.join(config.rootPath, 'templates/'),
                             base='widgets/main'
                            )
pureRender = web.template.render(os.path.join(config.rootPath, 'templates/'))
web.template.Template.globals['_'] = i18nU._
web.template.Template.globals['render'] = pureRender
web.template.Template.globals['session'] = web.config._session
web.template.Template.globals['i18nMap'] = i18nU.getI18nMap


# 500错误定义
def internalerror():
    return web.internalerror(str(render.widgets.internalError()))

# 404错误定义
def notfound():
    return web.notfound(str(render.widgets.notFound()))

def Loginfilter():
    from model.interface import GhEvsInterface
    session = web.config._session
#     if session.get("user") is None and web.ctx.path != "/login":
#         raise web.seeother('/login')
    if hasattr(session, "ticket"):
        evsInterface = GhEvsInterface()
        rtn = evsInterface.IsLogin(session.ticket)
        if rtn.get("isSuccess") and not rtn.get("data") and web.ctx.path != "/login":
            raise web.seeother('/login')
    elif web.ctx.path != "/login":
        raise web.seeother('/login')
    #刷新cookie    
    ticket = web.cookies().get("ticket")
    if ticket:
        web.setcookie('ticket', ticket)
# web.config.session_parameters['timeout'] = 10#86400, #24 * 60 * 60, # 24 hours   in seconds   
# app.add_processor(web.loadhook(Loginfilter))
app.notfound = notfound
app.internalerror = internalerror

