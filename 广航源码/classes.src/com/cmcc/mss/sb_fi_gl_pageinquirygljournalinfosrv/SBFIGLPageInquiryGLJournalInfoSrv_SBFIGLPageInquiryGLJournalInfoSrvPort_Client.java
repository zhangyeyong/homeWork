package com.cmcc.mss.sb_fi_gl_pageinquirygljournalinfosrv;

import java.io.File;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import javax.xml.namespace.QName;

public final class SBFIGLPageInquiryGLJournalInfoSrv_SBFIGLPageInquiryGLJournalInfoSrvPort_Client
{
  private static final QName SERVICE_NAME = new QName("http://mss.cmcc.com/SB_FI_GL_PageInquiryGLJournalInfoSrv", "SB_FI_GL_PageInquiryGLJournalInfoSrv");
  
  public static void main(String[] paramArrayOfString)
    throws Exception
  {
    URL localURL = SBFIGLPageInquiryGLJournalInfoSrv_Service.WSDL_LOCATION;
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
    Object localObject = new SBFIGLPageInquiryGLJournalInfoSrv_Service(localURL, SERVICE_NAME);
    SBFIGLPageInquiryGLJournalInfoSrv localSBFIGLPageInquiryGLJournalInfoSrv = ((SBFIGLPageInquiryGLJournalInfoSrv_Service)localObject).getSBFIGLPageInquiryGLJournalInfoSrvPort();
    System.out.println("Invoking process...");
    SBFIGLPageInquiryGLJournalInfoSrvRequest localSBFIGLPageInquiryGLJournalInfoSrvRequest = null;
    SBFIGLPageInquiryGLJournalInfoSrvResponse localSBFIGLPageInquiryGLJournalInfoSrvResponse = localSBFIGLPageInquiryGLJournalInfoSrv.process(localSBFIGLPageInquiryGLJournalInfoSrvRequest);
    System.out.println("process.result=" + localSBFIGLPageInquiryGLJournalInfoSrvResponse);
    System.exit(0);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_fi_gl_pageinquirygljournalinfosrv.SBFIGLPageInquiryGLJournalInfoSrv_SBFIGLPageInquiryGLJournalInfoSrvPort_Client
 * JD-Core Version:    0.7.0.1
 */