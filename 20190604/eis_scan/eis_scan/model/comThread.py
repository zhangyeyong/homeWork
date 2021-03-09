# coding:utf-8
import threading
import time
class SendThread(threading.Thread):  # The timer class is derived from the class threading.Thread  
    ser = None
    def __init__(self, ser):  
        threading.Thread.__init__(self)  
        self.ser = ser
    def run(self):  # Overwrite run() method, put what you want the thread do here 
        count = 0 
        while True:  
            count += 1 
            self.ser.write("abcd" + str(count)) 
            time.sleep(2)
class RecvThread(threading.Thread):  # The timer class is derived from the class threading.Thread  
    def __init__(self, ser, data=[]):  
        threading.Thread.__init__(self)  
        self.ser = ser
        self.data = data
        self.thread_stop =False
    def run(self):  # Overwrite run() method, put what you want the thread do here 
        data = ""  
        while not self.thread_stop:    
            data = self.ser.read(30)    
            if data == '':    
                continue  
            else:  
                self.data.append(data)
            time.sleep(0.02) 
    def stop(self): 
        self.thread_stop = True  
if __name__ == "__main__":
    pass
