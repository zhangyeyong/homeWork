package com.zte.web.service.proxy;

import com.cmcc.mss.msgheader.MsgHeader;
import com.cmcc.mss.sb_fi_ar_inquiryarjournalinfosrv.InquiryARJournalInfoSrvOutputCollection;
import com.cmcc.mss.sb_fi_ar_inquiryarjournalinfosrv.SBFIARInquiryARJournalInfoSrv;
import com.cmcc.mss.sb_fi_ar_inquiryarjournalinfosrv.SBFIARInquiryARJournalInfoSrvRequest;
import com.cmcc.mss.sb_fi_ar_inquiryarjournalinfosrv.SBFIARInquiryARJournalInfoSrvResponse;
import com.cmcc.mss.sb_fi_ar_inquiryarjournalinfosrv.SBFIARInquiryARJournalInfoSrv_Service;
import com.zte.ssb.AccessPropertiesFile;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.xml.datatype.XMLGregorianCalendar;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.apache.log4j.Logger;

public class ARJournalInfoClientImp
  implements ARJournalInfoClient
{
  private Logger log = Logger.getLogger(getClass());
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:ms");
  
  public SBFIARInquiryARJournalInfoSrvResponse doProccess(SBFIARInquiryARJournalInfoSrvRequest paramSBFIARInquiryARJournalInfoSrvRequest)
    throws Exception
  {
    this.log.error("-----SB_FI_AR_InquiryARJournalInfoSrv查询应收凭证信息服务 开始-------");
    Long localLong1 = Long.valueOf(System.currentTimeMillis());
    Date localDate1 = new Date();
    this.log.error("read connection time =" + AccessPropertiesFile.getValue("Connection_Timeout"));
    this.log.error("read Receive time =" + AccessPropertiesFile.getValue("Receive_Timeout"));
    SBFIARInquiryARJournalInfoSrvResponse localSBFIARInquiryARJournalInfoSrvResponse = null;
    SBFIARInquiryARJournalInfoSrv_Service localSBFIARInquiryARJournalInfoSrv_Service = new SBFIARInquiryARJournalInfoSrv_Service();
    SBFIARInquiryARJournalInfoSrv localSBFIARInquiryARJournalInfoSrv = localSBFIARInquiryARJournalInfoSrv_Service.getSBFIARInquiryARJournalInfoSrvPort();
    Client localClient = ClientProxy.getClient(localSBFIARInquiryARJournalInfoSrv);
    HTTPConduit localHTTPConduit = (HTTPConduit)localClient.getConduit();
    HTTPClientPolicy localHTTPClientPolicy = new HTTPClientPolicy();
    localHTTPClientPolicy.setConnectionTimeout(Long.valueOf(AccessPropertiesFile.getValue("Connection_Timeout")).longValue());
    localHTTPClientPolicy.setAllowChunking(false);
    localHTTPClientPolicy.setReceiveTimeout(Long.valueOf(AccessPropertiesFile.getValue("Receive_Timeout")).longValue());
    localHTTPConduit.setClient(localHTTPClientPolicy);
    this.log.error("Request MsgHeader SOURCE_SYSTEM_ID:" + paramSBFIARInquiryARJournalInfoSrvRequest.getMsgHeader().getSOURCESYSTEMID());
    this.log.error("Request MsgHeader SOURCE_SYSTEM_NAME:" + paramSBFIARInquiryARJournalInfoSrvRequest.getMsgHeader().getSOURCESYSTEMNAME());
    this.log.error("Request MsgHeader USER_ID:" + paramSBFIARInquiryARJournalInfoSrvRequest.getMsgHeader().getUSERID());
    this.log.error("Request MsgHeader USER_NAME:" + paramSBFIARInquiryARJournalInfoSrvRequest.getMsgHeader().getUSERNAME());
    this.log.error("Request MsgHeader SUBMIT_DATE:" + paramSBFIARInquiryARJournalInfoSrvRequest.getMsgHeader().getSUBMITDATE().toGregorianCalendar().getTime());
    this.log.error("Request JOURNAL_NUM:" + paramSBFIARInquiryARJournalInfoSrvRequest.getJOURNALNUM());
    this.log.error("Request START_LAST_UPDATE_DATE:" + paramSBFIARInquiryARJournalInfoSrvRequest.getSTARTLASTUPDATEDATE().toGregorianCalendar().getTime());
    this.log.error("Request END_LAST_UPDATE_DATE:" + paramSBFIARInquiryARJournalInfoSrvRequest.getENDLASTUPDATEDATE().toGregorianCalendar().getTime());
    localSBFIARInquiryARJournalInfoSrvResponse = localSBFIARInquiryARJournalInfoSrv.process(paramSBFIARInquiryARJournalInfoSrvRequest);
    Long localLong2 = Long.valueOf(System.currentTimeMillis());
    Date localDate2 = new Date();
    this.log.error("request time=" + this.sdf.format(localDate1));
    this.log.error("response time=" + this.sdf.format(localDate2));
    this.log.error("凭证发起请求到收到响应所用的时间 response time=" + (localLong2.longValue() - localLong1.longValue()) / 1000L + "秒");
    if (localSBFIARInquiryARJournalInfoSrvResponse != null)
    {
      this.log.error("Response INSTANCE_ID:" + localSBFIARInquiryARJournalInfoSrvResponse.getINSTANCEID());
      this.log.error("Response SERVICE_FLAG:" + localSBFIARInquiryARJournalInfoSrvResponse.getSERVICEFLAG());
      this.log.error("Response SERVICE_MESSAGE:" + localSBFIARInquiryARJournalInfoSrvResponse.getSERVICEMESSAGE());
      this.log.error("Response ARJournal size:" + localSBFIARInquiryARJournalInfoSrvResponse.getInquiryARJournalInfoSrvOutputCollection().getInquiryARJournalInfoSrvOutputItem().size());
    }
    this.log.error("----SB_FI_AR_InquiryARJournalInfoSrv查询应收凭证信息服务 结束------");
    return localSBFIARInquiryARJournalInfoSrvResponse;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.proxy.ARJournalInfoClientImp
 * JD-Core Version:    0.7.0.1
 */