package com.zte.web.service.proxy.voucherSer;

import com.cmcc.mss.sb_fi_ap_inquiryapjournalinfosrv.InquiryAPJournalInfoSrvOutputItem;
import com.zte.evs.ebill.model.eBillManage.EvsVoucher;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherLine;
import java.util.List;

public abstract interface APVoucherFactor
{
  public abstract EvsVoucher impApVoucherBeanToEvsVocher(InquiryAPJournalInfoSrvOutputItem paramInquiryAPJournalInfoSrvOutputItem);
  
  public abstract List<EvsVoucherLine> impApVoucherLineToEvsVocherLine(InquiryAPJournalInfoSrvOutputItem paramInquiryAPJournalInfoSrvOutputItem, long paramLong);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.proxy.voucherSer.APVoucherFactor
 * JD-Core Version:    0.7.0.1
 */