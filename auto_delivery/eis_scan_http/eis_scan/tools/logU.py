from config import logConfig
from libs.wsgilog import WsgiLog,LogStdout
import logging
import sys
class Log(WsgiLog):
    def __init__(self, application):
        WsgiLog.__init__(
            self,
            application,
            logformat = logConfig.logformat,
            datefmt = logConfig.datefmt,
            tofile = True,
            file = logConfig.logfile,
            interval = logConfig.interval,
            loglevel = logConfig.loglevel,
            backups = logConfig.backups
            )
        sys.stdout = LogStdout(self.logger, logging.DEBUG)
        sys.stderr = LogStdout(self.logger, logging.ERROR)