package com.zte.web.service.proxy;

import com.cmcc.mss.msgheader.MsgHeader;
import com.cmcc.mss.sb_fi_ar_inquiryreceiptjournalinfosrv.InquiryReceiptJournalInfoSrvOutputCollection;
import com.cmcc.mss.sb_fi_ar_inquiryreceiptjournalinfosrv.SBFIARInquiryReceiptJournalInfoSrv;
import com.cmcc.mss.sb_fi_ar_inquiryreceiptjournalinfosrv.SBFIARInquiryReceiptJournalInfoSrvRequest;
import com.cmcc.mss.sb_fi_ar_inquiryreceiptjournalinfosrv.SBFIARInquiryReceiptJournalInfoSrvResponse;
import com.cmcc.mss.sb_fi_ar_inquiryreceiptjournalinfosrv.SBFIARInquiryReceiptJournalInfoSrv_Service;
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

public class ReceiptJournalInfoClientImp
  implements ReceiptJournalInfoClient
{
  private Logger log = Logger.getLogger(getClass());
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:ms");
  
  public SBFIARInquiryReceiptJournalInfoSrvResponse doProccess(SBFIARInquiryReceiptJournalInfoSrvRequest paramSBFIARInquiryReceiptJournalInfoSrvRequest)
    throws Exception
  {
    this.log.error("--SB_FI_AR_InquiryReceiptJournalInfoSrv查询收款凭证信息服务 开始--");
    Long localLong1 = Long.valueOf(System.currentTimeMillis());
    Date localDate1 = new Date();
    this.log.error("read connection time =" + AccessPropertiesFile.getValue("Connection_Timeout"));
    this.log.error("read Receive time =" + AccessPropertiesFile.getValue("Receive_Timeout"));
    SBFIARInquiryReceiptJournalInfoSrvResponse localSBFIARInquiryReceiptJournalInfoSrvResponse = null;
    SBFIARInquiryReceiptJournalInfoSrv_Service localSBFIARInquiryReceiptJournalInfoSrv_Service = new SBFIARInquiryReceiptJournalInfoSrv_Service();
    SBFIARInquiryReceiptJournalInfoSrv localSBFIARInquiryReceiptJournalInfoSrv = localSBFIARInquiryReceiptJournalInfoSrv_Service.getSBFIARInquiryReceiptJournalInfoSrvPort();
    Client localClient = ClientProxy.getClient(localSBFIARInquiryReceiptJournalInfoSrv);
    HTTPConduit localHTTPConduit = (HTTPConduit)localClient.getConduit();
    HTTPClientPolicy localHTTPClientPolicy = new HTTPClientPolicy();
    localHTTPClientPolicy.setConnectionTimeout(Long.valueOf(AccessPropertiesFile.getValue("Connection_Timeout")).longValue());
    localHTTPClientPolicy.setAllowChunking(false);
    localHTTPClientPolicy.setReceiveTimeout(Long.valueOf(AccessPropertiesFile.getValue("Receive_Timeout")).longValue());
    localHTTPConduit.setClient(localHTTPClientPolicy);
    this.log.error("Request MsgHeader SOURCE_SYSTEM_ID:" + paramSBFIARInquiryReceiptJournalInfoSrvRequest.getMsgHeader().getSOURCESYSTEMID());
    this.log.error("Request MsgHeader SOURCE_SYSTEM_NAME:" + paramSBFIARInquiryReceiptJournalInfoSrvRequest.getMsgHeader().getSOURCESYSTEMNAME());
    this.log.error("Request MsgHeader USER_ID:" + paramSBFIARInquiryReceiptJournalInfoSrvRequest.getMsgHeader().getUSERID());
    this.log.error("Request MsgHeader USER_NAME:" + paramSBFIARInquiryReceiptJournalInfoSrvRequest.getMsgHeader().getUSERNAME());
    this.log.error("Request MsgHeader SUBMIT_DATE:" + paramSBFIARInquiryReceiptJournalInfoSrvRequest.getMsgHeader().getSUBMITDATE().toGregorianCalendar().getTime());
    this.log.error("Request JOURNAL_NUM:" + paramSBFIARInquiryReceiptJournalInfoSrvRequest.getJOURNALNUM());
    this.log.error("Request START_LAST_UPDATE_DATE:" + paramSBFIARInquiryReceiptJournalInfoSrvRequest.getSTARTLASTUPDATEDATE().toGregorianCalendar().getTime());
    this.log.error("Request END_LAST_UPDATE_DATE:" + paramSBFIARInquiryReceiptJournalInfoSrvRequest.getENDLASTUPDATEDATE().toGregorianCalendar().getTime());
    localSBFIARInquiryReceiptJournalInfoSrvResponse = localSBFIARInquiryReceiptJournalInfoSrv.process(paramSBFIARInquiryReceiptJournalInfoSrvRequest);
    Long localLong2 = Long.valueOf(System.currentTimeMillis());
    Date localDate2 = new Date();
    this.log.error("request time=" + this.sdf.format(localDate1));
    this.log.error("response time=" + this.sdf.format(localDate2));
    this.log.error("凭证发起请求到收到响应所用的时间 response time=" + (localLong2.longValue() - localLong1.longValue()) / 1000L + "秒");
    if (localSBFIARInquiryReceiptJournalInfoSrvResponse != null)
    {
      this.log.error("Response INSTANCE_ID:" + localSBFIARInquiryReceiptJournalInfoSrvResponse.getINSTANCEID());
      this.log.error("Response SERVICE_FLAG:" + localSBFIARInquiryReceiptJournalInfoSrvResponse.getSERVICEFLAG());
      this.log.error("Response SERVICE_MESSAGE:" + localSBFIARInquiryReceiptJournalInfoSrvResponse.getSERVICEMESSAGE());
      this.log.error("Response ReceiptJournal size:" + localSBFIARInquiryReceiptJournalInfoSrvResponse.getInquiryReceiptJournalInfoSrvOutputCollection().getInquiryReceiptJournalInfoSrvOutputItem().size());
    }
    this.log.error("--SB_FI_AR_InquiryReceiptJournalInfoSrv查询收款凭证信息服务 结束--");
    return localSBFIARInquiryReceiptJournalInfoSrvResponse;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.proxy.ReceiptJournalInfoClientImp
 * JD-Core Version:    0.7.0.1
 */