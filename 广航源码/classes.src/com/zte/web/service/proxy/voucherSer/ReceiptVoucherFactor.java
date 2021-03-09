package com.zte.web.service.proxy.voucherSer;

import com.cmcc.mss.sb_fi_ar_inquiryreceiptjournalinfosrv.InquiryReceiptJournalInfoSrvOutputItem;
import com.zte.evs.ebill.model.eBillManage.EvsVoucher;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherLine;
import java.util.List;

public abstract interface ReceiptVoucherFactor
{
  public abstract EvsVoucher impVoucherToEvsVocher(InquiryReceiptJournalInfoSrvOutputItem paramInquiryReceiptJournalInfoSrvOutputItem);
  
  public abstract List<EvsVoucherLine> impVoucherLineToEvsVocherLine(InquiryReceiptJournalInfoSrvOutputItem paramInquiryReceiptJournalInfoSrvOutputItem, long paramLong);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.proxy.voucherSer.ReceiptVoucherFactor
 * JD-Core Version:    0.7.0.1
 */