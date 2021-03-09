package com.cmcc.mss.sb_eas_eas_inquiryorginfosrv;

import java.io.File;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import javax.xml.namespace.QName;

public final class SBEASEASInquiryORGInfoSrv_SBEASEASInquiryORGInfoSrvPort_Client
{
  private static final QName SERVICE_NAME = new QName("http://mss.cmcc.com/SB_EAS_EAS_InquiryORGInfoSrv", "SB_EAS_EAS_InquiryORGInfoSrv");
  
  public static void main(String[] paramArrayOfString)
    throws Exception
  {
    URL localURL = SBEASEASInquiryORGInfoSrv_Service.WSDL_LOCATION;
    if (paramArrayOfString.length > 0)
    {
      localObject = new File(paramArrayOfString[0]);
      try
      {
        if (((File)localObject).exists()) {
          localURL = ((File)localObject).toURI().toURL();
        } else {
          localURL = new URL(paramArrayOfString[0]);
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        localMalformedURLException.printStackTrace();
      }
    }
    Object localObject = new SBEASEASInquiryORGInfoSrv_Service(localURL, SERVICE_NAME);
    SBEASEASInquiryORGInfoSrv localSBEASEASInquiryORGInfoSrv = ((SBEASEASInquiryORGInfoSrv_Service)localObject).getSBEASEASInquiryORGInfoSrvPort();
    System.out.println("Invoking process...");
    SBEASEASInquiryORGInfoSrvRequest localSBEASEASInquiryORGInfoSrvRequest = null;
    SBEASEASInquiryORGInfoSrvResponse localSBEASEASInquiryORGInfoSrvResponse = localSBEASEASInquiryORGInfoSrv.process(localSBEASEASInquiryORGInfoSrvRequest);
    System.out.println("process.result=" + localSBEASEASInquiryORGInfoSrvResponse);
    System.exit(0);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_eas_eas_inquiryorginfosrv.SBEASEASInquiryORGInfoSrv_SBEASEASInquiryORGInfoSrvPort_Client
 * JD-Core Version:    0.7.0.1
 */