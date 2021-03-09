package com.zte.web.service.proxy;

import com.cmcc.mss.sb_fi_ap_inquirypaymentjournalinfosrv.SBFIAPInquiryPaymentJournalInfoSrvRequest;
import com.cmcc.mss.sb_fi_ap_inquirypaymentjournalinfosrv.SBFIAPInquiryPaymentJournalInfoSrvResponse;

public abstract interface PaymentJournalInfoClient
{
  public abstract SBFIAPInquiryPaymentJournalInfoSrvResponse doProccess(SBFIAPInquiryPaymentJournalInfoSrvRequest paramSBFIAPInquiryPaymentJournalInfoSrvRequest)
    throws Exception;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.proxy.PaymentJournalInfoClient
 * JD-Core Version:    0.7.0.1
 */