package com.cmcc.mss.sb_fi_ar_inquiryreceiptjournalinfosrv;

import com.zte.ssb.AccessPropertiesFile;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name="SB_FI_AR_InquiryReceiptJournalInfoSrv", wsdlLocation="file:/F:/河南移动/电子凭证/最新WSDL/ERP/WSDL/SB_FI_AR_InquiryReceiptJournalInfoSrv/WSDL/SB_FI_AR_InquiryReceiptJournalInfoSrv.wsdl", targetNamespace="http://mss.cmcc.com/SB_FI_AR_InquiryReceiptJournalInfoSrv")
public class SBFIARInquiryReceiptJournalInfoSrv_Service
  extends Service
{
  public static final URL WSDL_LOCATION;
  public static final QName SERVICE = new QName("http://mss.cmcc.com/SB_FI_AR_InquiryReceiptJournalInfoSrv", "SB_FI_AR_InquiryReceiptJournalInfoSrv");
  public static final QName SBFIARInquiryReceiptJournalInfoSrvPort = new QName("http://mss.cmcc.com/SB_FI_AR_InquiryReceiptJournalInfoSrv", "SB_FI_AR_InquiryReceiptJournalInfoSrvPort");
  
  public SBFIARInquiryReceiptJournalInfoSrv_Service(URL paramURL)
  {
    super(paramURL, SERVICE);
  }
  
  public SBFIARInquiryReceiptJournalInfoSrv_Service(URL paramURL, QName paramQName)
  {
    super(paramURL, paramQName);
  }
  
  public SBFIARInquiryReceiptJournalInfoSrv_Service()
  {
    super(WSDL_LOCATION, SERVICE);
  }
  
  @WebEndpoint(name="SB_FI_AR_InquiryReceiptJournalInfoSrvPort")
  public SBFIARInquiryReceiptJournalInfoSrv getSBFIARInquiryReceiptJournalInfoSrvPort()
  {
    return (SBFIARInquiryReceiptJournalInfoSrv)super.getPort(SBFIARInquiryReceiptJournalInfoSrvPort, SBFIARInquiryReceiptJournalInfoSrv.class);
  }
  
  @WebEndpoint(name="SB_FI_AR_InquiryReceiptJournalInfoSrvPort")
  public SBFIARInquiryReceiptJournalInfoSrv getSBFIARInquiryReceiptJournalInfoSrvPort(WebServiceFeature... paramVarArgs)
  {
    return (SBFIARInquiryReceiptJournalInfoSrv)super.getPort(SBFIARInquiryReceiptJournalInfoSrvPort, SBFIARInquiryReceiptJournalInfoSrv.class, paramVarArgs);
  }
  
  static
  {
    URL localURL = null;
    try
    {
      localURL = new URL(AccessPropertiesFile.getValue("SB_FI_AR_InquiryReceiptJournalInfoSrvPort_address"));
    }
    catch (MalformedURLException localMalformedURLException)
    {
      System.err.println("Can not initialize the default wsdl from file:/F:/河南移动/电子凭证/最新WSDL/ERP/WSDL/SB_FI_AR_InquiryReceiptJournalInfoSrv/WSDL/SB_FI_AR_InquiryReceiptJournalInfoSrv.wsdl");
    }
    WSDL_LOCATION = localURL;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_fi_ar_inquiryreceiptjournalinfosrv.SBFIARInquiryReceiptJournalInfoSrv_Service
 * JD-Core Version:    0.7.0.1
 */