package com.zte.web.service.proxy.voucherSer;

import com.cmcc.mss.sb_fi_ap_inquirypaymentjournalinfosrv.InquiryPaymentJournalInfoSrvOutputItem;
import com.zte.evs.ebill.model.eBillManage.EvsVoucher;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherLine;
import java.util.List;

public abstract interface PaymentVoucherFactor
{
  public abstract EvsVoucher impVoucherToEvsVocher(InquiryPaymentJournalInfoSrvOutputItem paramInquiryPaymentJournalInfoSrvOutputItem);
  
  public abstract List<EvsVoucherLine> impVoucherLineToEvsVocherLine(InquiryPaymentJournalInfoSrvOutputItem paramInquiryPaymentJournalInfoSrvOutputItem, long paramLong);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.proxy.voucherSer.PaymentVoucherFactor
 * JD-Core Version:    0.7.0.1
 */