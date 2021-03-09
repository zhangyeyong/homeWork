package com.cmcc.mss.sb_fi_ap_inquiryapjournalinfosrv;

import com.zte.ssb.AccessPropertiesFile;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name="SB_FI_AP_InquiryAPJournalInfoSrv", wsdlLocation="file:/F:/河南移动/电子凭证/最新WSDL/ERP/WSDL/SB_FI_AP_InquiryAPJournalInfoSrv/WSDL/SB_FI_AP_InquiryAPJournalInfoSrv.wsdl", targetNamespace="http://mss.cmcc.com/SB_FI_AP_InquiryAPJournalInfoSrv")
public class SBFIAPInquiryAPJournalInfoSrv_Service
  extends Service
{
  public static final URL WSDL_LOCATION;
  public static final QName SERVICE = new QName("http://mss.cmcc.com/SB_FI_AP_InquiryAPJournalInfoSrv", "SB_FI_AP_InquiryAPJournalInfoSrv");
  public static final QName SBFIAPInquiryAPJournalInfoSrvPort = new QName("http://mss.cmcc.com/SB_FI_AP_InquiryAPJournalInfoSrv", "SB_FI_AP_InquiryAPJournalInfoSrvPort");
  
  public SBFIAPInquiryAPJournalInfoSrv_Service(URL paramURL)
  {
    super(paramURL, SERVICE);
  }
  
  public SBFIAPInquiryAPJournalInfoSrv_Service(URL paramURL, QName paramQName)
  {
    super(paramURL, paramQName);
  }
  
  public SBFIAPInquiryAPJournalInfoSrv_Service()
  {
    super(WSDL_LOCATION, SERVICE);
  }
  
  @WebEndpoint(name="SB_FI_AP_InquiryAPJournalInfoSrvPort")
  public SBFIAPInquiryAPJournalInfoSrv getSBFIAPInquiryAPJournalInfoSrvPort()
  {
    return (SBFIAPInquiryAPJournalInfoSrv)super.getPort(SBFIAPInquiryAPJournalInfoSrvPort, SBFIAPInquiryAPJournalInfoSrv.class);
  }
  
  @WebEndpoint(name="SB_FI_AP_InquiryAPJournalInfoSrvPort")
  public SBFIAPInquiryAPJournalInfoSrv getSBFIAPInquiryAPJournalInfoSrvPort(WebServiceFeature... paramVarArgs)
  {
    return (SBFIAPInquiryAPJournalInfoSrv)super.getPort(SBFIAPInquiryAPJournalInfoSrvPort, SBFIAPInquiryAPJournalInfoSrv.class, paramVarArgs);
  }
  
  static
  {
    URL localURL = null;
    try
    {
      localURL = new URL(AccessPropertiesFile.getValue("SB_FI_AP_InquiryAPJournalInfoSrvPort_address"));
    }
    catch (MalformedURLException localMalformedURLException)
    {
      System.err.println("Can not initialize the default wsdl from file:/F:/河南移动/电子凭证/最新WSDL/ERP/WSDL/SB_FI_AP_InquiryAPJournalInfoSrv/WSDL/SB_FI_AP_InquiryAPJournalInfoSrv.wsdl");
    }
    WSDL_LOCATION = localURL;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_fi_ap_inquiryapjournalinfosrv.SBFIAPInquiryAPJournalInfoSrv_Service
 * JD-Core Version:    0.7.0.1
 */