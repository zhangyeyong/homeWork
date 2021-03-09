package com.zte.web.service.proxy;

import com.cmcc.mss.sb_fi_ar_inquiryarjournalinfosrv.SBFIARInquiryARJournalInfoSrvRequest;
import com.cmcc.mss.sb_fi_ar_inquiryarjournalinfosrv.SBFIARInquiryARJournalInfoSrvResponse;

public abstract interface ARJournalInfoClient
{
  public abstract SBFIARInquiryARJournalInfoSrvResponse doProccess(SBFIARInquiryARJournalInfoSrvRequest paramSBFIARInquiryARJournalInfoSrvRequest)
    throws Exception;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.proxy.ARJournalInfoClient
 * JD-Core Version:    0.7.0.1
 */