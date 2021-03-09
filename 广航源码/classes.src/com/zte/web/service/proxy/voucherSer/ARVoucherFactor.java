package com.zte.web.service.proxy.voucherSer;

import com.cmcc.mss.sb_fi_ar_inquiryarjournalinfosrv.InquiryARJournalInfoSrvOutputItem;
import com.zte.evs.ebill.model.eBillManage.EvsVoucher;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherLine;
import java.util.List;

public abstract interface ARVoucherFactor
{
  public abstract EvsVoucher impVoucherToEvsVocher(InquiryARJournalInfoSrvOutputItem paramInquiryARJournalInfoSrvOutputItem);
  
  public abstract List<EvsVoucherLine> impVoucherLineToEvsVocherLine(InquiryARJournalInfoSrvOutputItem paramInquiryARJournalInfoSrvOutputItem, long paramLong);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.proxy.voucherSer.ARVoucherFactor
 * JD-Core Version:    0.7.0.1
 */