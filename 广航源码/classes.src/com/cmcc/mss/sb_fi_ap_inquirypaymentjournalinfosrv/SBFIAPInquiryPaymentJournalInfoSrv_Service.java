package com.cmcc.mss.sb_fi_ap_inquirypaymentjournalinfosrv;

import com.zte.ssb.AccessPropertiesFile;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name="SB_FI_AP_InquiryPaymentJournalInfoSrv", wsdlLocation="file:/F:/河南移动/电子凭证/最新WSDL/ERP/WSDL/SB_FI_AP_InquiryPaymentJournalInfoSrv/WSDL/SB_FI_AP_InquiryPaymentJournalInfoSrv.wsdl", targetNamespace="http://mss.cmcc.com/SB_FI_AP_InquiryPaymentJournalInfoSrv")
public class SBFIAPInquiryPaymentJournalInfoSrv_Service
  extends Service
{
  public static final URL WSDL_LOCATION;
  public static final QName SERVICE = new QName("http://mss.cmcc.com/SB_FI_AP_InquiryPaymentJournalInfoSrv", "SB_FI_AP_InquiryPaymentJournalInfoSrv");
  public static final QName SBFIAPInquiryPaymentJournalInfoSrvPort = new QName("http://mss.cmcc.com/SB_FI_AP_InquiryPaymentJournalInfoSrv", "SB_FI_AP_InquiryPaymentJournalInfoSrvPort");
  
  public SBFIAPInquiryPaymentJournalInfoSrv_Service(URL paramURL)
  {
    super(paramURL, SERVICE);
  }
  
  public SBFIAPInquiryPaymentJournalInfoSrv_Service(URL paramURL, QName paramQName)
  {
    super(paramURL, paramQName);
  }
  
  public SBFIAPInquiryPaymentJournalInfoSrv_Service()
  {
    super(WSDL_LOCATION, SERVICE);
  }
  
  @WebEndpoint(name="SB_FI_AP_InquiryPaymentJournalInfoSrvPort")
  public SBFIAPInquiryPaymentJournalInfoSrv getSBFIAPInquiryPaymentJournalInfoSrvPort()
  {
    return (SBFIAPInquiryPaymentJournalInfoSrv)super.getPort(SBFIAPInquiryPaymentJournalInfoSrvPort, SBFIAPInquiryPaymentJournalInfoSrv.class);
  }
  
  @WebEndpoint(name="SB_FI_AP_InquiryPaymentJournalInfoSrvPort")
  public SBFIAPInquiryPaymentJournalInfoSrv getSBFIAPInquiryPaymentJournalInfoSrvPort(WebServiceFeature... paramVarArgs)
  {
    return (SBFIAPInquiryPaymentJournalInfoSrv)super.getPort(SBFIAPInquiryPaymentJournalInfoSrvPort, SBFIAPInquiryPaymentJournalInfoSrv.class, paramVarArgs);
  }
  
  static
  {
    URL localURL = null;
    try
    {
      localURL = new URL(AccessPropertiesFile.getValue("SB_FI_AP_InquiryPaymentJournalInfoSrvPort_address"));
    }
    catch (MalformedURLException localMalformedURLException)
    {
      System.err.println("Can not initialize the default wsdl from file:/F:/河南移动/电子凭证/最新WSDL/ERP/WSDL/SB_FI_AP_InquiryPaymentJournalInfoSrv/WSDL/SB_FI_AP_InquiryPaymentJournalInfoSrv.wsdl");
    }
    WSDL_LOCATION = localURL;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_fi_ap_inquirypaymentjournalinfosrv.SBFIAPInquiryPaymentJournalInfoSrv_Service
 * JD-Core Version:    0.7.0.1
 */