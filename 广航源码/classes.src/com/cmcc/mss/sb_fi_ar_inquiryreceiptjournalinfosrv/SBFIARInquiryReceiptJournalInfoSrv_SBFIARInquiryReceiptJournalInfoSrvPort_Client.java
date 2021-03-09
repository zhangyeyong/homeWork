package com.cmcc.mss.sb_fi_ar_inquiryreceiptjournalinfosrv;

import java.io.File;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import javax.xml.namespace.QName;

public final class SBFIARInquiryReceiptJournalInfoSrv_SBFIARInquiryReceiptJournalInfoSrvPort_Client
{
  private static final QName SERVICE_NAME = new QName("http://mss.cmcc.com/SB_FI_AR_InquiryReceiptJournalInfoSrv", "SB_FI_AR_InquiryReceiptJournalInfoSrv");
  
  public static void main(String[] paramArrayOfString)
    throws Exception
  {
    URL localURL = SBFIARInquiryReceiptJournalInfoSrv_Service.WSDL_LOCATION;
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
    Object localObject = new SBFIARInquiryReceiptJournalInfoSrv_Service(localURL, SERVICE_NAME);
    SBFIARInquiryReceiptJournalInfoSrv localSBFIARInquiryReceiptJournalInfoSrv = ((SBFIARInquiryReceiptJournalInfoSrv_Service)localObject).getSBFIARInquiryReceiptJournalInfoSrvPort();
    System.out.println("Invoking process...");
    SBFIARInquiryReceiptJournalInfoSrvRequest localSBFIARInquiryReceiptJournalInfoSrvRequest = null;
    SBFIARInquiryReceiptJournalInfoSrvResponse localSBFIARInquiryReceiptJournalInfoSrvResponse = localSBFIARInquiryReceiptJournalInfoSrv.process(localSBFIARInquiryReceiptJournalInfoSrvRequest);
    System.out.println("process.result=" + localSBFIARInquiryReceiptJournalInfoSrvResponse);
    System.exit(0);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_fi_ar_inquiryreceiptjournalinfosrv.SBFIARInquiryReceiptJournalInfoSrv_SBFIARInquiryReceiptJournalInfoSrvPort_Client
 * JD-Core Version:    0.7.0.1
 */