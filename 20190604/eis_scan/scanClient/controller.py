# coding:utf-8
from libs import web
import os

urls = (
    '/', 'scanService.scan',
)


class ZtesscApplication(web.application):
    def run(self, port=8001, *middleware):
        func = self.wsgifunc(*middleware)
        return web.httpserver.runsimple(func, ('0.0.0.0', port))


def initSession():
    if web.config.get('_session') is None:
        web.config._session = web.session.Session(
            app,
            web.session.DiskStore('sessions'),
        )


app = ZtesscApplication(urls, globals())
initSession()
render = web.template.render('templates/')
web.template.Template.globals['render'] = render
web.template.Template.globals['session'] = web.config._session


# 500
def internalerror():
    return web.internalerror(str(render.internalError()))


# 404
def notfound():
    return web.notfound(str(render.notFound()))


app.notfound = notfound
app.internalerror = internalerror
