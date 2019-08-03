import threading, time
 
class EisTimer(threading.Thread):
    def __init__(self, fn, args=(), sleep=180, lastDo=False):
        threading.Thread.__init__(self)
        self.fn = fn
        self.args = args
        self.sleep = sleep
        self.lastDo = lastDo
        self.setDaemon(True)
         
        self.isPlay = True
        self.fnPlay = False
     
    def __do(self):
        self.fnPlay = True
        if apply(self.fn, self.args) == False:
            self.stop()
        self.fnPlay = False
     
    def run(self):
        while self.isPlay :
            self.__do()
            time.sleep(self.sleep)
     
    def stop(self):
        # stop the loop
        self.isPlay = False
        while True:
            if not self.fnPlay : break
            time.sleep(0.01)
        # if lastDo,do it again
        if self.lastDo : self.__do()
        
if __name__ == "__main__":
    i = 0
    def aaa(i):
        i += 1
        print i
        return True
    t = EisTimer(aaa, [i], sleep=1)
    t.start()
    print "------------"
    
    time.sleep(10000)
