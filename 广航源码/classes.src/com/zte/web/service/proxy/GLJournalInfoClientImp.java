package com.zte.web.service.proxy;

import com.cmcc.mss.msgheader.MsgHeader;
import com.cmcc.mss.sb_fi_gl_pageinquirygljournalinfosrv.PageInquiryGLJournalInfoSrvOutputCollection;
import com.cmcc.mss.sb_fi_gl_pageinquirygljournalinfosrv.SBFIGLPageInquiryGLJournalInfoSrv;
import com.cmcc.mss.sb_fi_gl_pageinquirygljournalinfosrv.SBFIGLPageInquiryGLJournalInfoSrvRequest;
import com.cmcc.mss.sb_fi_gl_pageinquirygljournalinfosrv.SBFIGLPageInquiryGLJournalInfoSrvResponse;
import com.cmcc.mss.sb_fi_gl_pageinquirygljournalinfosrv.SBFIGLPageInquiryGLJournalInfoSrv_Service;
import com.zte.ssb.AccessPropertiesFile;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.rpc.ServiceException;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.apache.log4j.Logger;

public class GLJournalInfoClientImp
  implements GLJournalInfoClient
{
  private Logger log = Logger.getLogger(getClass());
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:ms");
  
  public SBFIGLPageInquiryGLJournalInfoSrvResponse doProccess(SBFIGLPageInquiryGLJournalInfoSrvRequest paramSBFIGLPageInquiryGLJournalInfoSrvRequest)
    throws ServiceException, RemoteException
  {
    this.log.error("----SB_FI_GL_PageInquiryGLJournalInfoSrv查询总账凭证信息服务 开始-----");
    Long localLong1 = Long.valueOf(System.currentTimeMillis());
    Date localDate1 = new Date();
    this.log.error("read connection time =" + AccessPropertiesFile.getValue("Connection_Timeout"));
    this.log.error("read Receive time =" + AccessPropertiesFile.getValue("Receive_Timeout"));
    SBFIGLPageInquiryGLJournalInfoSrvResponse localSBFIGLPageInquiryGLJournalInfoSrvResponse = null;
    SBFIGLPageInquiryGLJournalInfoSrv_Service localSBFIGLPageInquiryGLJournalInfoSrv_Service = new SBFIGLPageInquiryGLJournalInfoSrv_Service();
    SBFIGLPageInquiryGLJournalInfoSrv localSBFIGLPageInquiryGLJournalInfoSrv = localSBFIGLPageInquiryGLJournalInfoSrv_Service.getSBFIGLPageInquiryGLJournalInfoSrvPort();
    Client localClient = ClientProxy.getClient(localSBFIGLPageInquiryGLJournalInfoSrv);
    HTTPConduit localHTTPConduit = (HTTPConduit)localClient.getConduit();
    HTTPClientPolicy localHTTPClientPolicy = new HTTPClientPolicy();
    localHTTPClientPolicy.setConnectionTimeout(Long.valueOf(AccessPropertiesFile.getValue("Connection_Timeout")).longValue());
    localHTTPClientPolicy.setAllowChunking(false);
    localHTTPClientPolicy.setReceiveTimeout(Long.valueOf(AccessPropertiesFile.getValue("Receive_Timeout")).longValue());
    localHTTPConduit.setClient(localHTTPClientPolicy);
    this.log.error("Request MsgHeader SOURCE_SYSTEM_ID:" + paramSBFIGLPageInquiryGLJournalInfoSrvRequest.getMsgHeader().getSOURCESYSTEMID());
    this.log.error("Request MsgHeader SOURCE_SYSTEM_NAME:" + paramSBFIGLPageInquiryGLJournalInfoSrvRequest.getMsgHeader().getSOURCESYSTEMNAME());
    this.log.error("Request MsgHeader USER_ID:" + paramSBFIGLPageInquiryGLJournalInfoSrvRequest.getMsgHeader().getUSERID());
    this.log.error("Request MsgHeader USER_NAME:" + paramSBFIGLPageInquiryGLJournalInfoSrvRequest.getMsgHeader().getUSERNAME());
    this.log.error("Request MsgHeader SUBMIT_DATE:" + paramSBFIGLPageInquiryGLJournalInfoSrvRequest.getMsgHeader().getSUBMITDATE().toGregorianCalendar().getTime());
    this.log.error("Request JOURNAL_NUM:" + paramSBFIGLPageInquiryGLJournalInfoSrvRequest.getJOURNALNUM());
    this.log.error("Request START_LAST_UPDATE_DATE:" + paramSBFIGLPageInquiryGLJournalInfoSrvRequest.getSTARTLASTUPDATEDATE().toGregorianCalendar().getTime());
    this.log.error("Request END_LAST_UPDATE_DATE:" + paramSBFIGLPageInquiryGLJournalInfoSrvRequest.getENDLASTUPDATEDATE().toGregorianCalendar().getTime());
    localSBFIGLPageInquiryGLJournalInfoSrvResponse = localSBFIGLPageInquiryGLJournalInfoSrv.process(paramSBFIGLPageInquiryGLJournalInfoSrvRequest);
    Long localLong2 = Long.valueOf(System.currentTimeMillis());
    Date localDate2 = new Date();
    this.log.error("request time=" + this.sdf.format(localDate1));
    this.log.error("response time=" + this.sdf.format(localDate2));
    this.log.error("凭证发起请求到收到响应所用的时间 response time=" + (localLong2.longValue() - localLong1.longValue()) / 1000L + "秒");
    if (localSBFIGLPageInquiryGLJournalInfoSrvResponse != null)
    {
      this.log.error("Response INSTANCE_ID:" + localSBFIGLPageInquiryGLJournalInfoSrvResponse.getINSTANCEID());
      this.log.error("Response SERVICE_FLAG:" + localSBFIGLPageInquiryGLJournalInfoSrvResponse.getSERVICEFLAG());
      this.log.error("Response SERVICE_MESSAGE:" + localSBFIGLPageInquiryGLJournalInfoSrvResponse.getSERVICEMESSAGE());
      this.log.error("Response CURRENT_PAGE:" + localSBFIGLPageInquiryGLJournalInfoSrvResponse.getCURRENTPAGE());
      this.log.error("Response PAGE_SIZE:" + localSBFIGLPageInquiryGLJournalInfoSrvResponse.getPAGESIZE());
      this.log.error("Response TOTAL_PAGE:" + localSBFIGLPageInquiryGLJournalInfoSrvResponse.getTOTALPAGE());
      this.log.error("Response TOTAL_RECORD:" + localSBFIGLPageInquiryGLJournalInfoSrvResponse.getTOTALRECORD());
      this.log.error("Response GLJournal size:" + localSBFIGLPageInquiryGLJournalInfoSrvResponse.getPageInquiryGLJournalInfoSrvOutputCollection().getPageInquiryGLJournalInfoSrvOutputItem().size());
    }
    this.log.error("-----SB_FI_GL_PageInquiryGLJournalInfoSrv查询总账凭证信息服务 结束----");
    return localSBFIGLPageInquiryGLJournalInfoSrvResponse;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.proxy.GLJournalInfoClientImp
 * JD-Core Version:    0.7.0.1
 */