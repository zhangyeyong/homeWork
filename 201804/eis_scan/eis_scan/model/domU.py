# coding:utf-8
from  xml.dom import  minidom
def get_attrvalue(node, attrname):
    return node.getAttribute(attrname) if node else ''

def get_nodevalue(node, index=0):
    return node.childNodes[index].nodeValue if node else ''

def get_xmlnode(node, name):
    return node.getElementsByTagName(name) if node else []
def parseToList(string):
    doc = minidom.parseString(string)
    root = doc.documentElement
    task_nodes = get_xmlnode(root, 'Task')
    obj_list = []
    for node in task_nodes: 
        node_TaskType = get_xmlnode(node, 'TaskType')
        node_Barcode = get_xmlnode(node, 'Barcode')
        node_postil = get_xmlnode(node, 'postil')
        node_remark = get_xmlnode(node, 'remark')
        node_FtpID = get_xmlnode(node, 'FtpID')
        node_TaskID = get_xmlnode(node, 'TaskID')
        node_files = get_xmlnode(get_xmlnode(node, 'Files')[0], 'File')
        Files = []
        for file_node in node_files:
            File = {}
            node_Path = get_xmlnode(file_node, 'Path')
            node_FileType = get_xmlnode(file_node, 'FileType')
            node_Areas_root = get_xmlnode(file_node, 'Areas')
            Areas = []
            if len(node_Areas_root) > 0:
                node_Areas = get_xmlnode(get_xmlnode(file_node, 'Areas')[0], 'Area')
                for node_area  in node_Areas:
                    Area = {}
                    node_AreaName = get_xmlnode(node_area, 'AreaName')
                    node_AreaResult = get_xmlnode(node_area, 'AreaResult')
                    Area['AreaName'], Area['AreaResult'] = (
                        get_nodevalue(node_AreaName[0]).encode('utf-8', 'null'),
                        get_nodevalue(node_AreaResult[0]).encode('utf-8', 'null')
                    )
                    Areas.append(Area)
            File['Path'], File['FileType'], File['Areas'] = (
                 get_nodevalue(node_Path[0]).encode('utf-8', 'null'),
                 get_nodevalue(node_FileType[0]).encode('utf-8', 'null'),
                 Areas
                  )
            Files.append(File)
        obj = {}
        obj['TaskType'], obj['Barcode'], obj['postil'], obj['remark'], obj['FtpID'], obj['TaskID'], obj['Files'] = (
            get_nodevalue(node_TaskType[0]).encode('utf-8', 'null'),
            get_nodevalue(node_Barcode[0]).encode('utf-8', 'null'),
            get_nodevalue(node_postil[0]).encode('utf-8', 'null'),
            get_nodevalue(node_remark[0]).encode('utf-8', 'null'),
            get_nodevalue(node_FtpID[0]).encode('utf-8', 'null'),
            get_nodevalue(node_TaskID[0]).encode('utf-8', 'null'),
            Files
        )
        obj_list.append(obj)
    return obj_list
def parseToXml(obj):
    doc = minidom.Document()
    root_node = doc.createElement("Param")  
    doc.appendChild(root_node)  

    node_Barcode = doc.createElement("Barcode")  
    node_ScanTime = doc.createElement("ScanTime")  
    node_SaveSite = doc.createElement("SaveSite")  
    node_FtpID = doc.createElement("FtpID")  
    node_postil = doc.createElement("postil")
      
    node_Files = doc.createElement("Files")  

    
    node_Barcode.appendChild(doc.createTextNode(obj.get("Barcode",'null')))  
    root_node.appendChild(node_Barcode)  
    
    node_ScanTime.appendChild(doc.createTextNode(obj.get("ScanTime",'null')))  
    root_node.appendChild(node_ScanTime)  
    
    node_SaveSite.appendChild(doc.createTextNode(obj.get("SaveSite",'null')))  
    root_node.appendChild(node_SaveSite)  
    
    node_FtpID.appendChild(doc.createTextNode(obj.get("FtpID",'null')))  
    root_node.appendChild(node_FtpID)  
    
    node_postil.appendChild(doc.createTextNode(obj.get("postil",'null')))  
    root_node.appendChild(node_postil)  
    
    #Files
    for File in obj.get('Files',[]):
        node_File = doc.createElement("File") 
         
        node_Path = doc.createElement("Path")
        node_Path.appendChild(doc.createTextNode(File.get("Path",'null')))  
        node_File.appendChild(node_Path)
          
        node_MD5 = doc.createElement("MD5") 
        node_MD5.appendChild(doc.createTextNode(File.get("MD5",'null')))  
        node_File.appendChild(node_MD5)
         
        node_FileType = doc.createElement("FileType") 
        node_FileType.appendChild(doc.createTextNode(File.get("FileType",'null')))  
        node_File.appendChild(node_FileType)
         
        node_Areas = doc.createElement("Areas")
        for Area in File.get("Areas",[]):
            node_Area = doc.createElement("Area")
            
            node_AreaName = doc.createElement("AreaName")
            node_AreaName.appendChild(doc.createTextNode(Area.get("AreaName",'null')))  
            node_Area.appendChild(node_AreaName)
            
            node_AreaResult = doc.createElement("AreaResult")
            node_AreaResult.appendChild(doc.createTextNode(Area.get("AreaResult",'null')))  
            node_Area.appendChild(node_AreaResult)
            
            node_Areas.appendChild(node_Area)
        node_File.appendChild(node_Areas)
        node_Files.appendChild(node_File)      
    root_node.appendChild(node_Files)  
    return doc.toxml('UTF-8')
if __name__ == '__main__':
    #     '''<Param>
#     <Barcode>222155001308050284</Barcode>
#     <ScanTime>2013-09-21 16:13:29</ScanTime>
#     <SaveSite>1</SaveSite>
#     <FtpID>10040</FtpID>
#     <postil>{}</postil>
#     <Files>
#         <File>
#             <Path>2013/9/21/222155001308050284/222155001308050284_1.jpg</Path>
#             <MD5>8ff703daffc73f35c0bd96eb5b65592b</MD5>
#             <FileType>3</FileType>
#             <Areas>
#                 <Area>
#                     <AreaName>发票代码</AreaName>
#                     <AreaResult>233001100164</AreaResult>
#                 </Area>
#                 <Area>
#                     <AreaName>发票号码</AreaName>
#                     <AreaResult>00747449</AreaResult>
#                 </Area>
#             </Areas>
#         </File>
#     </Files>
# </Param> '''
    obj = {
           'Barcode':'222155001308050284',
           'ScanTime':'2013-09-21 16:13:29',
           'SaveSite':'1',
           'FtpID':'10040',
           'postil':'{}',
           'Files':[{
               'Path':'2013/9/21/222155001308050284/222155001308050284_1.jpg',
               'MD5':'8ff703daffc73f35c0bd96eb5b65592b',
               'FileType':'3',
               'Areas':[{
                   'AreaName':'发票代码',
                   'AreaResult':'233001100164',
                         },
                        {
                   'AreaName':'发票号码',
                   'AreaResult':'00747449',
                         },
                        ],
                     
                     }
                    ],
           }
    print parseToXml(obj)  #测试生成xml 字符串
    
    #测试解析xml
    string = "<Tasks><Task><TaskType>6</TaskType><Barcode>201402240005</Barcode><postil>{}</postil><remark>评价类型：缺少发票 评价描述：影像不清晰</remark><FtpID>10000</FtpID><TaskID>10021</TaskID><Files><File><Path>2014/2/24/201402240005/201402240005_1.jpg</Path><FileType>2</FileType><Areas><Area><AreaName>发票代码</AreaName><AreaResult>3300124620</AreaResult></Area><Area><AreaName>发票号码</AreaName><AreaResult>11411928</AreaResult></Area><Area><AreaName>开票日期</AreaName><AreaResult>2013-06-04</AreaResult></Area><Area><AreaName>发票金额</AreaName><AreaResult>24745.28</AreaResult></Area><Area><AreaName>发票税额</AreaName><AreaResult>1481.72</AreaResult></Area><Area><AreaName>价税合计大写金额</AreaName><AreaResult>贰万陆仟贰佰叁拾圆整</AreaResult></Area><Area><AreaName>价税合计小写金额</AreaName><AreaResult>26230.00</AreaResult></Area><Area><AreaName>购货单位纳税人识别号</AreaName><AreaResult>330165842919654</AreaResult></Area><Area><AreaName>销货单位纳税人识别号</AreaName><AreaResult>330100605215719</AreaResult></Area><Area><AreaName>密码区第一行</AreaName><AreaResult>*274088588-91&gt;73*30*1-5&gt;1</AreaResult></Area><Area><AreaName>密码区第二行</AreaName><AreaResult>9428+7&lt;7&gt;377374/*+938620405</AreaResult></Area><Area><AreaName>密码区第三行</AreaName><AreaResult>36*836&lt;358*51&gt;&lt;9&gt;8-16529++4</AreaResult></Area><Area><AreaName>密码区第四行</AreaName><AreaResult>-*449+464434/3769+*342&gt;7948</AreaResult></Area></Areas></File><File><Path>2014/2/24/201402240005/201402240005_2.jpg</Path><FileType>-1</FileType></File></Files></Task><Task><TaskType>6</TaskType><Barcode>140613-20</Barcode><postil>null</postil><remark>评价类型：附件不全 评价描述：fdv</remark><FtpID>10000</FtpID><TaskID>10100</TaskID><Files></Files></Task><Task><TaskType>6</TaskType><Barcode>201402250005</Barcode><postil>{}</postil><remark>评价类型：附件不全 评价描述：影像不清晰</remark><FtpID>10000</FtpID><TaskID>10020</TaskID><Files></Files></Task><Task><TaskType>6</TaskType><Barcode>140219-34</Barcode><postil>{}</postil><remark>评价类型：缺少发票 评价描述：地</remark><FtpID>10000</FtpID><TaskID>10041</TaskID><Files></Files></Task><Task><TaskType>6</TaskType><Barcode>140219-31</Barcode><postil>{}</postil><remark>评价类型：附件不全 评价描述：影像不清晰</remark><FtpID>10000</FtpID><TaskID>10022</TaskID><Files></Files></Task><Task><TaskType>6</TaskType><Barcode>140219-25</Barcode><postil>{}</postil><remark>评价类型：附件不全 评价描述：00000</remark><FtpID>10000</FtpID><TaskID>10062</TaskID><Files></Files></Task></Tasks>"
    print parseToList(string)
    
    
