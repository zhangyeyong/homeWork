package com.zte.web.service.proxy.voucherSer;

import com.cmcc.mss.sb_fi_gl_pageinquirygljournalinfosrv.PageInquiryGLJournalInfoSrvOutputItem;
import com.zte.evs.ebill.model.eBillManage.EvsVoucher;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherLine;
import java.util.List;

public abstract interface GLVoucherFactor
{
  public abstract EvsVoucher impVoucherToEvsVocher(PageInquiryGLJournalInfoSrvOutputItem paramPageInquiryGLJournalInfoSrvOutputItem);
  
  public abstract List<EvsVoucherLine> impVoucherLineToEvsVocherLine(PageInquiryGLJournalInfoSrvOutputItem paramPageInquiryGLJournalInfoSrvOutputItem, long paramLong);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.proxy.voucherSer.GLVoucherFactor
 * JD-Core Version:    0.7.0.1
 */