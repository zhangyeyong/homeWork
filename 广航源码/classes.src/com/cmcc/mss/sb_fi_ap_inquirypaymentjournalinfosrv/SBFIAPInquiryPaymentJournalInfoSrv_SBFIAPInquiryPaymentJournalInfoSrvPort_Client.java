package com.cmcc.mss.sb_fi_ap_inquirypaymentjournalinfosrv;

import java.io.File;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import javax.xml.namespace.QName;

public final class SBFIAPInquiryPaymentJournalInfoSrv_SBFIAPInquiryPaymentJournalInfoSrvPort_Client
{
  private static final QName SERVICE_NAME = new QName("http://mss.cmcc.com/SB_FI_AP_InquiryPaymentJournalInfoSrv", "SB_FI_AP_InquiryPaymentJournalInfoSrv");
  
  public static void main(String[] paramArrayOfString)
    throws Exception
  {
    URL localURL = SBFIAPInquiryPaymentJournalInfoSrv_Service.WSDL_LOCATION;
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
    Object localObject = new SBFIAPInquiryPaymentJournalInfoSrv_Service(localURL, SERVICE_NAME);
    SBFIAPInquiryPaymentJournalInfoSrv localSBFIAPInquiryPaymentJournalInfoSrv = ((SBFIAPInquiryPaymentJournalInfoSrv_Service)localObject).getSBFIAPInquiryPaymentJournalInfoSrvPort();
    System.out.println("Invoking process...");
    SBFIAPInquiryPaymentJournalInfoSrvRequest localSBFIAPInquiryPaymentJournalInfoSrvRequest = null;
    SBFIAPInquiryPaymentJournalInfoSrvResponse localSBFIAPInquiryPaymentJournalInfoSrvResponse = localSBFIAPInquiryPaymentJournalInfoSrv.process(localSBFIAPInquiryPaymentJournalInfoSrvRequest);
    System.out.println("process.result=" + localSBFIAPInquiryPaymentJournalInfoSrvResponse);
    System.exit(0);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_fi_ap_inquirypaymentjournalinfosrv.SBFIAPInquiryPaymentJournalInfoSrv_SBFIAPInquiryPaymentJournalInfoSrvPort_Client
 * JD-Core Version:    0.7.0.1
 */