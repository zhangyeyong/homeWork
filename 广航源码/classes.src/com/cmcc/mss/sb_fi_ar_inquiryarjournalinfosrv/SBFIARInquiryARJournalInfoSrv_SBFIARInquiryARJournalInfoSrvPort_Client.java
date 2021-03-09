package com.cmcc.mss.sb_fi_ar_inquiryarjournalinfosrv;

import java.io.File;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import javax.xml.namespace.QName;

public final class SBFIARInquiryARJournalInfoSrv_SBFIARInquiryARJournalInfoSrvPort_Client
{
  private static final QName SERVICE_NAME = new QName("http://mss.cmcc.com/SB_FI_AR_InquiryARJournalInfoSrv", "SB_FI_AR_InquiryARJournalInfoSrv");
  
  public static void main(String[] paramArrayOfString)
    throws Exception
  {
    URL localURL = SBFIARInquiryARJournalInfoSrv_Service.WSDL_LOCATION;
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
    Object localObject = new SBFIARInquiryARJournalInfoSrv_Service(localURL, SERVICE_NAME);
    SBFIARInquiryARJournalInfoSrv localSBFIARInquiryARJournalInfoSrv = ((SBFIARInquiryARJournalInfoSrv_Service)localObject).getSBFIARInquiryARJournalInfoSrvPort();
    System.out.println("Invoking process...");
    SBFIARInquiryARJournalInfoSrvRequest localSBFIARInquiryARJournalInfoSrvRequest = null;
    SBFIARInquiryARJournalInfoSrvResponse localSBFIARInquiryARJournalInfoSrvResponse = localSBFIARInquiryARJournalInfoSrv.process(localSBFIARInquiryARJournalInfoSrvRequest);
    System.out.println("process.result=" + localSBFIARInquiryARJournalInfoSrvResponse);
    System.exit(0);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_fi_ar_inquiryarjournalinfosrv.SBFIARInquiryARJournalInfoSrv_SBFIARInquiryARJournalInfoSrvPort_Client
 * JD-Core Version:    0.7.0.1
 */