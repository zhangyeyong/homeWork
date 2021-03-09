package com.zte.web.service.proxy;

import com.cmcc.mss.msgheader.MsgHeader;
import com.cmcc.mss.sb_fi_ap_inquiryapjournalinfosrv.InquiryAPJournalInfoSrvOutputCollection;
import com.cmcc.mss.sb_fi_ap_inquiryapjournalinfosrv.SBFIAPInquiryAPJournalInfoSrv;
import com.cmcc.mss.sb_fi_ap_inquiryapjournalinfosrv.SBFIAPInquiryAPJournalInfoSrvRequest;
import com.cmcc.mss.sb_fi_ap_inquiryapjournalinfosrv.SBFIAPInquiryAPJournalInfoSrvResponse;
import com.cmcc.mss.sb_fi_ap_inquiryapjournalinfosrv.SBFIAPInquiryAPJournalInfoSrv_Service;
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

public class APJournalInfoClientImp
  implements APJournalInfoClient
{
  private Logger log = Logger.getLogger(getClass());
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:ms");
  
  public SBFIAPInquiryAPJournalInfoSrvResponse doProccess(SBFIAPInquiryAPJournalInfoSrvRequest paramSBFIAPInquiryAPJournalInfoSrvRequest)
    throws Exception
  {
    this.log.error("------SB_FI_AP_InquiryAPJournalInfo查询应付凭证信息服务 开始-----");
    Long localLong1 = Long.valueOf(System.currentTimeMillis());
    Date localDate1 = new Date();
    this.log.error("read connection time =" + AccessPropertiesFile.getValue("Connection_Timeout"));
    this.log.error("read Receive time =" + AccessPropertiesFile.getValue("Receive_Timeout"));
    SBFIAPInquiryAPJournalInfoSrv_Service localSBFIAPInquiryAPJournalInfoSrv_Service = new SBFIAPInquiryAPJournalInfoSrv_Service();
    SBFIAPInquiryAPJournalInfoSrv localSBFIAPInquiryAPJournalInfoSrv = localSBFIAPInquiryAPJournalInfoSrv_Service.getSBFIAPInquiryAPJournalInfoSrvPort();
    Client localClient = ClientProxy.getClient(localSBFIAPInquiryAPJournalInfoSrv);
    HTTPConduit localHTTPConduit = (HTTPConduit)localClient.getConduit();
    HTTPClientPolicy localHTTPClientPolicy = new HTTPClientPolicy();
    localHTTPClientPolicy.setConnectionTimeout(Long.valueOf(AccessPropertiesFile.getValue("Connection_Timeout")).longValue());
    localHTTPClientPolicy.setAllowChunking(false);
    localHTTPClientPolicy.setReceiveTimeout(Long.valueOf(AccessPropertiesFile.getValue("Receive_Timeout")).longValue());
    localHTTPConduit.setClient(localHTTPClientPolicy);
    this.log.error("Request MsgHeader SOURCE_SYSTEM_ID:" + paramSBFIAPInquiryAPJournalInfoSrvRequest.getMsgHeader().getSOURCESYSTEMID());
    this.log.error("Request MsgHeader SOURCE_SYSTEM_NAME:" + paramSBFIAPInquiryAPJournalInfoSrvRequest.getMsgHeader().getSOURCESYSTEMNAME());
    this.log.error("Request MsgHeader USER_ID:" + paramSBFIAPInquiryAPJournalInfoSrvRequest.getMsgHeader().getUSERID());
    this.log.error("Request MsgHeader USER_NAME:" + paramSBFIAPInquiryAPJournalInfoSrvRequest.getMsgHeader().getUSERNAME());
    this.log.error("Request MsgHeader SUBMIT_DATE:" + paramSBFIAPInquiryAPJournalInfoSrvRequest.getMsgHeader().getSUBMITDATE().toGregorianCalendar().getTime());
    this.log.error("Request JOURNAL_NUM:" + paramSBFIAPInquiryAPJournalInfoSrvRequest.getJOURNALNUM());
    this.log.error("Request START_LAST_UPDATE_DATE:" + paramSBFIAPInquiryAPJournalInfoSrvRequest.getSTARTLASTUPDATEDATE().toGregorianCalendar().getTime());
    this.log.error("Request END_LAST_UPDATE_DATE:" + paramSBFIAPInquiryAPJournalInfoSrvRequest.getENDLASTUPDATEDATE().toGregorianCalendar().getTime());
    SBFIAPInquiryAPJournalInfoSrvResponse localSBFIAPInquiryAPJournalInfoSrvResponse = localSBFIAPInquiryAPJournalInfoSrv.process(paramSBFIAPInquiryAPJournalInfoSrvRequest);
    Long localLong2 = Long.valueOf(System.currentTimeMillis());
    Date localDate2 = new Date();
    this.log.error("request time=" + this.sdf.format(localDate1));
    this.log.error("response time=" + this.sdf.format(localDate2));
    this.log.error("凭证发起请求到收到响应所用的时间 response time=" + (localLong2.longValue() - localLong1.longValue()) / 1000L + "秒");
    if (localSBFIAPInquiryAPJournalInfoSrvResponse != null)
    {
      this.log.error("Response INSTANCE_ID:" + localSBFIAPInquiryAPJournalInfoSrvResponse.getINSTANCEID());
      this.log.error("Response SERVICE_FLAG:" + localSBFIAPInquiryAPJournalInfoSrvResponse.getSERVICEFLAG());
      this.log.error("Response SERVICE_MESSAGE:" + localSBFIAPInquiryAPJournalInfoSrvResponse.getSERVICEMESSAGE());
      this.log.error("Response APJournal size:" + localSBFIAPInquiryAPJournalInfoSrvResponse.getInquiryAPJournalInfoSrvOutputCollection().getInquiryAPJournalInfoSrvOutputItem().size());
    }
    this.log.error("----SB_FI_AP_InquiryAPJournalInfo查询应付凭证信息服务 结束----");
    return localSBFIAPInquiryAPJournalInfoSrvResponse;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.proxy.APJournalInfoClientImp
 * JD-Core Version:    0.7.0.1
 */