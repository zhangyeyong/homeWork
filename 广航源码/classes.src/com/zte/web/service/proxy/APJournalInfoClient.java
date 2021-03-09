package com.zte.web.service.proxy;

import com.cmcc.mss.sb_fi_ap_inquiryapjournalinfosrv.SBFIAPInquiryAPJournalInfoSrvRequest;
import com.cmcc.mss.sb_fi_ap_inquiryapjournalinfosrv.SBFIAPInquiryAPJournalInfoSrvResponse;

public abstract interface APJournalInfoClient
{
  public abstract SBFIAPInquiryAPJournalInfoSrvResponse doProccess(SBFIAPInquiryAPJournalInfoSrvRequest paramSBFIAPInquiryAPJournalInfoSrvRequest)
    throws Throwable;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.proxy.APJournalInfoClient
 * JD-Core Version:    0.7.0.1
 */