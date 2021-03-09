package com.cmcc.mss.sb_eas_eas_inquiryusersinfosrv;

import com.zte.ssb.AccessPropertiesFile;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name="SB_EAS_EAS_InquiryUsersInfoSrv", wsdlLocation="file:/F:/河南移动/电子凭证/最新WSDL/EAS/WSDL/SB_EAS_EAS_InquiryUsersInfoSrv/WSDL/SB_EAS_EAS_InquiryUsersInfoSrv.wsdl", targetNamespace="http://mss.cmcc.com/SB_EAS_EAS_InquiryUsersInfoSrv")
public class SBEASEASInquiryUsersInfoSrv_Service
  extends Service
{
  public static final URL WSDL_LOCATION;
  public static final QName SERVICE = new QName("http://mss.cmcc.com/SB_EAS_EAS_InquiryUsersInfoSrv", "SB_EAS_EAS_InquiryUsersInfoSrv");
  public static final QName SBEASEASInquiryUsersInfoSrvPort = new QName("http://mss.cmcc.com/SB_EAS_EAS_InquiryUsersInfoSrv", "SB_EAS_EAS_InquiryUsersInfoSrvPort");
  
  public SBEASEASInquiryUsersInfoSrv_Service(URL paramURL)
  {
    super(paramURL, SERVICE);
  }
  
  public SBEASEASInquiryUsersInfoSrv_Service(URL paramURL, QName paramQName)
  {
    super(paramURL, paramQName);
  }
  
  public SBEASEASInquiryUsersInfoSrv_Service()
  {
    super(WSDL_LOCATION, SERVICE);
  }
  
  @WebEndpoint(name="SB_EAS_EAS_InquiryUsersInfoSrvPort")
  public SBEASEASInquiryUsersInfoSrv getSBEASEASInquiryUsersInfoSrvPort()
  {
    return (SBEASEASInquiryUsersInfoSrv)super.getPort(SBEASEASInquiryUsersInfoSrvPort, SBEASEASInquiryUsersInfoSrv.class);
  }
  
  @WebEndpoint(name="SB_EAS_EAS_InquiryUsersInfoSrvPort")
  public SBEASEASInquiryUsersInfoSrv getSBEASEASInquiryUsersInfoSrvPort(WebServiceFeature... paramVarArgs)
  {
    return (SBEASEASInquiryUsersInfoSrv)super.getPort(SBEASEASInquiryUsersInfoSrvPort, SBEASEASInquiryUsersInfoSrv.class, paramVarArgs);
  }
  
  static
  {
    URL localURL = null;
    try
    {
      localURL = new URL(AccessPropertiesFile.getValue("employee_in"));
    }
    catch (MalformedURLException localMalformedURLException)
    {
      System.err.println("Can not initialize the default wsdl from file:/F:/河南移动/电子凭证/最新WSDL/EAS/WSDL/SB_EAS_EAS_InquiryUsersInfoSrv/WSDL/SB_EAS_EAS_InquiryUsersInfoSrv.wsdl");
    }
    WSDL_LOCATION = localURL;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_eas_eas_inquiryusersinfosrv.SBEASEASInquiryUsersInfoSrv_Service
 * JD-Core Version:    0.7.0.1
 */