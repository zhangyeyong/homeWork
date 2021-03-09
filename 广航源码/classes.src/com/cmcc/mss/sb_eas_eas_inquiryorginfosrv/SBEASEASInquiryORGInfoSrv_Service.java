package com.cmcc.mss.sb_eas_eas_inquiryorginfosrv;

import com.zte.ssb.AccessPropertiesFile;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name="SB_EAS_EAS_InquiryORGInfoSrv", wsdlLocation="file:/F:/河南移动/电子凭证/最新WSDL/EAS/WSDL/SB_EAS_EAS_InquiryORGInfoSrv/WSDL/SB_EAS_EAS_InquiryORGInfoSrv.wsdl", targetNamespace="http://mss.cmcc.com/SB_EAS_EAS_InquiryORGInfoSrv")
public class SBEASEASInquiryORGInfoSrv_Service
  extends Service
{
  public static final URL WSDL_LOCATION;
  public static final QName SERVICE = new QName("http://mss.cmcc.com/SB_EAS_EAS_InquiryORGInfoSrv", "SB_EAS_EAS_InquiryORGInfoSrv");
  public static final QName SBEASEASInquiryORGInfoSrvPort = new QName("http://mss.cmcc.com/SB_EAS_EAS_InquiryORGInfoSrv", "SB_EAS_EAS_InquiryORGInfoSrvPort");
  
  public SBEASEASInquiryORGInfoSrv_Service(URL paramURL)
  {
    super(paramURL, SERVICE);
  }
  
  public SBEASEASInquiryORGInfoSrv_Service(URL paramURL, QName paramQName)
  {
    super(paramURL, paramQName);
  }
  
  public SBEASEASInquiryORGInfoSrv_Service()
  {
    super(WSDL_LOCATION, SERVICE);
  }
  
  @WebEndpoint(name="SB_EAS_EAS_InquiryORGInfoSrvPort")
  public SBEASEASInquiryORGInfoSrv getSBEASEASInquiryORGInfoSrvPort()
  {
    return (SBEASEASInquiryORGInfoSrv)super.getPort(SBEASEASInquiryORGInfoSrvPort, SBEASEASInquiryORGInfoSrv.class);
  }
  
  @WebEndpoint(name="SB_EAS_EAS_InquiryORGInfoSrvPort")
  public SBEASEASInquiryORGInfoSrv getSBEASEASInquiryORGInfoSrvPort(WebServiceFeature... paramVarArgs)
  {
    return (SBEASEASInquiryORGInfoSrv)super.getPort(SBEASEASInquiryORGInfoSrvPort, SBEASEASInquiryORGInfoSrv.class, paramVarArgs);
  }
  
  static
  {
    URL localURL = null;
    try
    {
      localURL = new URL(AccessPropertiesFile.getValue("dept_in"));
    }
    catch (MalformedURLException localMalformedURLException)
    {
      System.err.println("Can not initialize the default wsdl from file:/F:/河南移动/电子凭证/最新WSDL/EAS/WSDL/SB_EAS_EAS_InquiryORGInfoSrv/WSDL/SB_EAS_EAS_InquiryORGInfoSrv.wsdl");
    }
    WSDL_LOCATION = localURL;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_eas_eas_inquiryorginfosrv.SBEASEASInquiryORGInfoSrv_Service
 * JD-Core Version:    0.7.0.1
 */