package com.cmcc.mss.sb_fi_ap_inquiryapjournalinfosrv;

import java.io.File;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import javax.xml.namespace.QName;

public final class SBFIAPInquiryAPJournalInfoSrv_SBFIAPInquiryAPJournalInfoSrvPort_Client
{
  private static final QName SERVICE_NAME = new QName("http://mss.cmcc.com/SB_FI_AP_InquiryAPJournalInfoSrv", "SB_FI_AP_InquiryAPJournalInfoSrv");
  
  public static void main(String[] paramArrayOfString)
    throws Exception
  {
    URL localURL = SBFIAPInquiryAPJournalInfoSrv_Service.WSDL_LOCATION;
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
    Object localObject = new SBFIAPInquiryAPJournalInfoSrv_Service(localURL, SERVICE_NAME);
    SBFIAPInquiryAPJournalInfoSrv localSBFIAPInquiryAPJournalInfoSrv = ((SBFIAPInquiryAPJournalInfoSrv_Service)localObject).getSBFIAPInquiryAPJournalInfoSrvPort();
    System.out.println("Invoking process...");
    SBFIAPInquiryAPJournalInfoSrvRequest localSBFIAPInquiryAPJournalInfoSrvRequest = null;
    SBFIAPInquiryAPJournalInfoSrvResponse localSBFIAPInquiryAPJournalInfoSrvResponse = localSBFIAPInquiryAPJournalInfoSrv.process(localSBFIAPInquiryAPJournalInfoSrvRequest);
    System.out.println("process.result=" + localSBFIAPInquiryAPJournalInfoSrvResponse);
    System.exit(0);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_fi_ap_inquiryapjournalinfosrv.SBFIAPInquiryAPJournalInfoSrv_SBFIAPInquiryAPJournalInfoSrvPort_Client
 * JD-Core Version:    0.7.0.1
 */