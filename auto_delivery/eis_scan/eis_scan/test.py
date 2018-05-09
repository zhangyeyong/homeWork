import serial
import serial.tools.list_ports
if __name__ == '__main__':

    # headPath  = "D:/temp/sess_store"
    #
    # import shutil
    # shutil.rmtree(headPath)



    port_list = list(serial.tools.list_ports.comports())

    if len(port_list) <= 0:
        print
        "The Serial port can't find!"
    else:
        print
        port_list
