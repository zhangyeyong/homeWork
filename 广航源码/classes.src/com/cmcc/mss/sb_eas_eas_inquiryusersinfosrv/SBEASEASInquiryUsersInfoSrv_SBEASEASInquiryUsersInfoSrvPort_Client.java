package com.cmcc.mss.sb_eas_eas_inquiryusersinfosrv;

import java.io.File;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import javax.xml.namespace.QName;

public final class SBEASEASInquiryUsersInfoSrv_SBEASEASInquiryUsersInfoSrvPort_Client
{
  private static final QName SERVICE_NAME = new QName("http://mss.cmcc.com/SB_EAS_EAS_InquiryUsersInfoSrv", "SB_EAS_EAS_InquiryUsersInfoSrv");
  
  public static void main(String[] paramArrayOfString)
    throws Exception
  {
    URL localURL = SBEASEASInquiryUsersInfoSrv_Service.WSDL_LOCATION;
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
    Object localObject = new SBEASEASInquiryUsersInfoSrv_Service(localURL, SERVICE_NAME);
    SBEASEASInquiryUsersInfoSrv localSBEASEASInquiryUsersInfoSrv = ((SBEASEASInquiryUsersInfoSrv_Service)localObject).getSBEASEASInquiryUsersInfoSrvPort();
    System.out.println("Invoking process...");
    SBEASEASInquiryUsersInfoSrvRequest localSBEASEASInquiryUsersInfoSrvRequest = null;
    SBEASEASInquiryUsersInfoSrvResponse localSBEASEASInquiryUsersInfoSrvResponse = localSBEASEASInquiryUsersInfoSrv.process(localSBEASEASInquiryUsersInfoSrvRequest);
    System.out.println("process.result=" + localSBEASEASInquiryUsersInfoSrvResponse);
    System.exit(0);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_eas_eas_inquiryusersinfosrv.SBEASEASInquiryUsersInfoSrv_SBEASEASInquiryUsersInfoSrvPort_Client
 * JD-Core Version:    0.7.0.1
 */