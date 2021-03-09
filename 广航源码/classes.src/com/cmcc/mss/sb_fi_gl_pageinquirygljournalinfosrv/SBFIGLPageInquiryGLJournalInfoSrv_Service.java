package com.cmcc.mss.sb_fi_gl_pageinquirygljournalinfosrv;

import com.zte.ssb.AccessPropertiesFile;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name="SB_FI_GL_PageInquiryGLJournalInfoSrv", wsdlLocation="file:/F:/河南移动/电子凭证/最新WSDL/ERP/WSDL/SB_FI_GL_PageInquiryGLJournalInfoSrv/WSDL/SB_FI_GL_PageInquiryGLJournalInfoSrv.wsdl", targetNamespace="http://mss.cmcc.com/SB_FI_GL_PageInquiryGLJournalInfoSrv")
public class SBFIGLPageInquiryGLJournalInfoSrv_Service
  extends Service
{
  public static final URL WSDL_LOCATION;
  public static final QName SERVICE = new QName("http://mss.cmcc.com/SB_FI_GL_PageInquiryGLJournalInfoSrv", "SB_FI_GL_PageInquiryGLJournalInfoSrv");
  public static final QName SBFIGLPageInquiryGLJournalInfoSrvPort = new QName("http://mss.cmcc.com/SB_FI_GL_PageInquiryGLJournalInfoSrv", "SB_FI_GL_PageInquiryGLJournalInfoSrvPort");
  
  public SBFIGLPageInquiryGLJournalInfoSrv_Service(URL paramURL)
  {
    super(paramURL, SERVICE);
  }
  
  public SBFIGLPageInquiryGLJournalInfoSrv_Service(URL paramURL, QName paramQName)
  {
    super(paramURL, paramQName);
  }
  
  public SBFIGLPageInquiryGLJournalInfoSrv_Service()
  {
    super(WSDL_LOCATION, SERVICE);
  }
  
  @WebEndpoint(name="SB_FI_GL_PageInquiryGLJournalInfoSrvPort")
  public SBFIGLPageInquiryGLJournalInfoSrv getSBFIGLPageInquiryGLJournalInfoSrvPort()
  {
    return (SBFIGLPageInquiryGLJournalInfoSrv)super.getPort(SBFIGLPageInquiryGLJournalInfoSrvPort, SBFIGLPageInquiryGLJournalInfoSrv.class);
  }
  
  @WebEndpoint(name="SB_FI_GL_PageInquiryGLJournalInfoSrvPort")
  public SBFIGLPageInquiryGLJournalInfoSrv getSBFIGLPageInquiryGLJournalInfoSrvPort(WebServiceFeature... paramVarArgs)
  {
    return (SBFIGLPageInquiryGLJournalInfoSrv)super.getPort(SBFIGLPageInquiryGLJournalInfoSrvPort, SBFIGLPageInquiryGLJournalInfoSrv.class, paramVarArgs);
  }
  
  static
  {
    URL localURL = null;
    try
    {
      localURL = new URL(AccessPropertiesFile.getValue("SB_FI_GL_PageInquiryGLJournalInfoSrvPort_address"));
    }
    catch (MalformedURLException localMalformedURLException)
    {
      System.err.println("Can not initialize the default wsdl from file:/F:/河南移动/电子凭证/最新WSDL/ERP/WSDL/SB_FI_GL_PageInquiryGLJournalInfoSrv/WSDL/SB_FI_GL_PageInquiryGLJournalInfoSrv.wsdl");
    }
    WSDL_LOCATION = localURL;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_fi_gl_pageinquirygljournalinfosrv.SBFIGLPageInquiryGLJournalInfoSrv_Service
 * JD-Core Version:    0.7.0.1
 */