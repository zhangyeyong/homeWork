package com.cmcc.mss.sb_eas_eas_importimageoperationinfosrv;

import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name="SB_EAS_EAS_ImportImageOperationInfoSrv", wsdlLocation="file:/F:/河南移动/电子凭证/最新WSDL/EAS/WSDL/SB_EAS_EAS_ImportImageOperationInfoSrv/WSDL/SB_EAS_EAS_ImportImageOperationInfoSrv.wsdl", targetNamespace="http://mss.cmcc.com/SB_EAS_EAS_ImportImageOperationInfoSrv")
public class SBEASEASImportImageOperationInfoSrv_Service
  extends Service
{
  public static final URL WSDL_LOCATION;
  public static final QName SERVICE = new QName("http://mss.cmcc.com/SB_EAS_EAS_ImportImageOperationInfoSrv", "SB_EAS_EAS_ImportImageOperationInfoSrv");
  public static final QName SBEASEASImportImageOperationInfoSrvPort = new QName("http://mss.cmcc.com/SB_EAS_EAS_ImportImageOperationInfoSrv", "SB_EAS_EAS_ImportImageOperationInfoSrvPort");
  
  public SBEASEASImportImageOperationInfoSrv_Service(URL paramURL)
  {
    super(paramURL, SERVICE);
  }
  
  public SBEASEASImportImageOperationInfoSrv_Service(URL paramURL, QName paramQName)
  {
    super(paramURL, paramQName);
  }
  
  public SBEASEASImportImageOperationInfoSrv_Service()
  {
    super(WSDL_LOCATION, SERVICE);
  }
  
  @WebEndpoint(name="SB_EAS_EAS_ImportImageOperationInfoSrvPort")
  public SBEASEASImportImageOperationInfoSrv getSBEASEASImportImageOperationInfoSrvPort()
  {
    return (SBEASEASImportImageOperationInfoSrv)super.getPort(SBEASEASImportImageOperationInfoSrvPort, SBEASEASImportImageOperationInfoSrv.class);
  }
  
  @WebEndpoint(name="SB_EAS_EAS_ImportImageOperationInfoSrvPort")
  public SBEASEASImportImageOperationInfoSrv getSBEASEASImportImageOperationInfoSrvPort(WebServiceFeature... paramVarArgs)
  {
    return (SBEASEASImportImageOperationInfoSrv)super.getPort(SBEASEASImportImageOperationInfoSrvPort, SBEASEASImportImageOperationInfoSrv.class, paramVarArgs);
  }
  
  static
  {
    URL localURL = null;
    try
    {
      localURL = new URL("file:wsdl/SB_EAS_EAS_ImportImageOperationInfoSrv.wsdl");
    }
    catch (MalformedURLException localMalformedURLException)
    {
      System.err.println("Can not initialize the default wsdl from file:/F:/河南移动/电子凭证/最新WSDL/EAS/WSDL/SB_EAS_EAS_ImportImageOperationInfoSrv/WSDL/SB_EAS_EAS_ImportImageOperationInfoSrv.wsdl");
    }
    WSDL_LOCATION = localURL;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_eas_eas_importimageoperationinfosrv.SBEASEASImportImageOperationInfoSrv_Service
 * JD-Core Version:    0.7.0.1
 */