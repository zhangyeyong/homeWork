package com.cmcc.mss.sb_fi_ar_inquiryarjournalinfosrv;

import com.zte.ssb.AccessPropertiesFile;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name="SB_FI_AR_InquiryARJournalInfoSrv", wsdlLocation="file:/F:/河南移动/电子凭证/最新WSDL/ERP/WSDL/SB_FI_AR_InquiryARJournalInfoSrv/WSDL/SB_FI_AR_InquiryARJournalInfoSrv.wsdl", targetNamespace="http://mss.cmcc.com/SB_FI_AR_InquiryARJournalInfoSrv")
public class SBFIARInquiryARJournalInfoSrv_Service
  extends Service
{
  public static final URL WSDL_LOCATION;
  public static final QName SERVICE = new QName("http://mss.cmcc.com/SB_FI_AR_InquiryARJournalInfoSrv", "SB_FI_AR_InquiryARJournalInfoSrv");
  public static final QName SBFIARInquiryARJournalInfoSrvPort = new QName("http://mss.cmcc.com/SB_FI_AR_InquiryARJournalInfoSrv", "SB_FI_AR_InquiryARJournalInfoSrvPort");
  
  public SBFIARInquiryARJournalInfoSrv_Service(URL paramURL)
  {
    super(paramURL, SERVICE);
  }
  
  public SBFIARInquiryARJournalInfoSrv_Service(URL paramURL, QName paramQName)
  {
    super(paramURL, paramQName);
  }
  
  public SBFIARInquiryARJournalInfoSrv_Service()
  {
    super(WSDL_LOCATION, SERVICE);
  }
  
  @WebEndpoint(name="SB_FI_AR_InquiryARJournalInfoSrvPort")
  public SBFIARInquiryARJournalInfoSrv getSBFIARInquiryARJournalInfoSrvPort()
  {
    return (SBFIARInquiryARJournalInfoSrv)super.getPort(SBFIARInquiryARJournalInfoSrvPort, SBFIARInquiryARJournalInfoSrv.class);
  }
  
  @WebEndpoint(name="SB_FI_AR_InquiryARJournalInfoSrvPort")
  public SBFIARInquiryARJournalInfoSrv getSBFIARInquiryARJournalInfoSrvPort(WebServiceFeature... paramVarArgs)
  {
    return (SBFIARInquiryARJournalInfoSrv)super.getPort(SBFIARInquiryARJournalInfoSrvPort, SBFIARInquiryARJournalInfoSrv.class, paramVarArgs);
  }
  
  static
  {
    URL localURL = null;
    try
    {
      localURL = new URL(AccessPropertiesFile.getValue("SB_FI_AR_InquiryARJournalInfoSrvPort_address"));
    }
    catch (MalformedURLException localMalformedURLException)
    {
      System.err.println("Can not initialize the default wsdl from file:/F:/河南移动/电子凭证/最新WSDL/ERP/WSDL/SB_FI_AR_InquiryARJournalInfoSrv/WSDL/SB_FI_AR_InquiryARJournalInfoSrv.wsdl");
    }
    WSDL_LOCATION = localURL;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_fi_ar_inquiryarjournalinfosrv.SBFIARInquiryARJournalInfoSrv_Service
 * JD-Core Version:    0.7.0.1
 */