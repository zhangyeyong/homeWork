package com.zte.evs.ebill.access.eBillManage;

import com.zte.evs.ebill.model.eBillManage.EvsVoucher;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherLine;
import java.util.List;

public abstract interface IEvsVoucherLineDAO
{
  public abstract List<EvsVoucherLine> findLineByVoucherId(Long paramLong, String paramString);
  
  public abstract List<EvsVoucherLine> findPrintListByVoucherId(Long paramLong);
  
  public abstract void inserEvsVoucherLines(List<EvsVoucherLine> paramList);
  
  public abstract EvsVoucher getEvsVoucher(Long paramLong);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.eBillManage.IEvsVoucherLineDAO
 * JD-Core Version:    0.7.0.1
 */