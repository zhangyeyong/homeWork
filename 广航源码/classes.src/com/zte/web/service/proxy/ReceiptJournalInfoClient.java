package com.zte.web.service.proxy;

import com.cmcc.mss.sb_fi_ar_inquiryreceiptjournalinfosrv.SBFIARInquiryReceiptJournalInfoSrvRequest;
import com.cmcc.mss.sb_fi_ar_inquiryreceiptjournalinfosrv.SBFIARInquiryReceiptJournalInfoSrvResponse;

public abstract interface ReceiptJournalInfoClient
{
  public abstract SBFIARInquiryReceiptJournalInfoSrvResponse doProccess(SBFIARInquiryReceiptJournalInfoSrvRequest paramSBFIARInquiryReceiptJournalInfoSrvRequest)
    throws Exception;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.proxy.ReceiptJournalInfoClient
 * JD-Core Version:    0.7.0.1
 */