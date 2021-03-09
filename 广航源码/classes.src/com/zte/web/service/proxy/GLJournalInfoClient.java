package com.zte.web.service.proxy;

import com.cmcc.mss.sb_fi_gl_pageinquirygljournalinfosrv.SBFIGLPageInquiryGLJournalInfoSrvRequest;
import com.cmcc.mss.sb_fi_gl_pageinquirygljournalinfosrv.SBFIGLPageInquiryGLJournalInfoSrvResponse;

public abstract interface GLJournalInfoClient
{
  public abstract SBFIGLPageInquiryGLJournalInfoSrvResponse doProccess(SBFIGLPageInquiryGLJournalInfoSrvRequest paramSBFIGLPageInquiryGLJournalInfoSrvRequest)
    throws Throwable;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.proxy.GLJournalInfoClient
 * JD-Core Version:    0.7.0.1
 */