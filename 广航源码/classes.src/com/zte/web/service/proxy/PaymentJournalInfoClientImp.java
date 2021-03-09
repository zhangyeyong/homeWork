package com.zte.web.service.proxy;

import com.cmcc.mss.msgheader.MsgHeader;
import com.cmcc.mss.sb_fi_ap_inquirypaymentjournalinfosrv.InquiryPaymentJournalInfoSrvOutputCollection;
import com.cmcc.mss.sb_fi_ap_inquirypaymentjournalinfosrv.SBFIAPInquiryPaymentJournalInfoSrv;
import com.cmcc.mss.sb_fi_ap_inquirypaymentjournalinfosrv.SBFIAPInquiryPaymentJournalInfoSrvRequest;
import com.cmcc.mss.sb_fi_ap_inquirypaymentjournalinfosrv.SBFIAPInquiryPaymentJournalInfoSrvResponse;
import com.cmcc.mss.sb_fi_ap_inquirypaymentjournalinfosrv.SBFIAPInquiryPaymentJournalInfoSrv_Service;
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

public class PaymentJournalInfoClientImp
  implements PaymentJournalInfoClient
{
  private Logger log = Logger.getLogger(getClass());
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:ms");
  
  public SBFIAPInquiryPaymentJournalInfoSrvResponse doProccess(SBFIAPInquiryPaymentJournalInfoSrvRequest paramSBFIAPInquiryPaymentJournalInfoSrvRequest)
    throws Exception
  {
    this.log.error("-----SB_FI_AP_InquiryPaymentJournalInfoSrv查询付款凭证信息服务 开始------");
    Long localLong1 = Long.valueOf(System.currentTimeMillis());
    Date localDate1 = new Date();
    this.log.error("read connection time =" + AccessPropertiesFile.getValue("Connection_Timeout"));
    this.log.error("read Receive time =" + AccessPropertiesFile.getValue("Receive_Timeout"));
    SBFIAPInquiryPaymentJournalInfoSrvResponse localSBFIAPInquiryPaymentJournalInfoSrvResponse = null;
    SBFIAPInquiryPaymentJournalInfoSrv_Service localSBFIAPInquiryPaymentJournalInfoSrv_Service = new SBFIAPInquiryPaymentJournalInfoSrv_Service();
    SBFIAPInquiryPaymentJournalInfoSrv localSBFIAPInquiryPaymentJournalInfoSrv = localSBFIAPInquiryPaymentJournalInfoSrv_Service.getSBFIAPInquiryPaymentJournalInfoSrvPort();
    Client localClient = ClientProxy.getClient(localSBFIAPInquiryPaymentJournalInfoSrv);
    HTTPConduit localHTTPConduit = (HTTPConduit)localClient.getConduit();
    HTTPClientPolicy localHTTPClientPolicy = new HTTPClientPolicy();
    localHTTPClientPolicy.setConnectionTimeout(Long.valueOf(AccessPropertiesFile.getValue("Connection_Timeout")).longValue());
    localHTTPClientPolicy.setAllowChunking(false);
    localHTTPClientPolicy.setReceiveTimeout(Long.valueOf(AccessPropertiesFile.getValue("Receive_Timeout")).longValue());
    localHTTPConduit.setClient(localHTTPClientPolicy);
    this.log.error("Request MsgHeader SOURCE_SYSTEM_ID:" + paramSBFIAPInquiryPaymentJournalInfoSrvRequest.getMsgHeader().getSOURCESYSTEMID());
    this.log.error("Request MsgHeader SOURCE_SYSTEM_NAME:" + paramSBFIAPInquiryPaymentJournalInfoSrvRequest.getMsgHeader().getSOURCESYSTEMNAME());
    this.log.error("Request MsgHeader USER_ID:" + paramSBFIAPInquiryPaymentJournalInfoSrvRequest.getMsgHeader().getUSERID());
    this.log.error("Request MsgHeader USER_NAME:" + paramSBFIAPInquiryPaymentJournalInfoSrvRequest.getMsgHeader().getUSERNAME());
    this.log.error("Request MsgHeader SUBMIT_DATE:" + paramSBFIAPInquiryPaymentJournalInfoSrvRequest.getMsgHeader().getSUBMITDATE().toGregorianCalendar().getTime());
    this.log.error("Request JOURNAL_NUM:" + paramSBFIAPInquiryPaymentJournalInfoSrvRequest.getJOURNALNUM());
    this.log.error("Request START_LAST_UPDATE_DATE:" + paramSBFIAPInquiryPaymentJournalInfoSrvRequest.getSTARTLASTUPDATEDATE().toGregorianCalendar().getTime());
    this.log.error("Request END_LAST_UPDATE_DATE:" + paramSBFIAPInquiryPaymentJournalInfoSrvRequest.getENDLASTUPDATEDATE().toGregorianCalendar().getTime());
    localSBFIAPInquiryPaymentJournalInfoSrvResponse = localSBFIAPInquiryPaymentJournalInfoSrv.process(paramSBFIAPInquiryPaymentJournalInfoSrvRequest);
    Long localLong2 = Long.valueOf(System.currentTimeMillis());
    Date localDate2 = new Date();
    this.log.error("request time=" + this.sdf.format(localDate1));
    this.log.error("response time=" + this.sdf.format(localDate2));
    this.log.error("凭证发起请求到收到响应所用的时间 response time=" + (localLong2.longValue() - localLong1.longValue()) / 1000L + "秒");
    if (localSBFIAPInquiryPaymentJournalInfoSrvResponse != null)
    {
      this.log.error("Response INSTANCE_ID:" + localSBFIAPInquiryPaymentJournalInfoSrvResponse.getINSTANCEID());
      this.log.error("Response SERVICE_FLAG:" + localSBFIAPInquiryPaymentJournalInfoSrvResponse.getSERVICEFLAG());
      this.log.error("Response SERVICE_MESSAGE:" + localSBFIAPInquiryPaymentJournalInfoSrvResponse.getSERVICEMESSAGE());
      this.log.error("Response PaymentJournal size:" + localSBFIAPInquiryPaymentJournalInfoSrvResponse.getInquiryPaymentJournalInfoSrvOutputCollection().getInquiryPaymentJournalInfoSrvOutputItem().size());
    }
    this.log.error("----SB_FI_AP_InquiryPaymentJournalInfoSrv查询付款凭证信息服务 结束-----");
    return localSBFIAPInquiryPaymentJournalInfoSrvResponse;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.proxy.PaymentJournalInfoClientImp
 * JD-Core Version:    0.7.0.1
 */