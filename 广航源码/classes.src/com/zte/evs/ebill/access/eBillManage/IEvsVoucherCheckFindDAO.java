package com.zte.evs.ebill.access.eBillManage;

import com.zte.evs.ebill.model.eBillManage.EvsVoucher;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherInvoice;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherSelect;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherV;
import com.zte.ssb.framework.base.util.PageInfo;
import java.util.List;
import java.util.Map;

public abstract interface IEvsVoucherCheckFindDAO
{
  public abstract Map findHeaderByQry(EvsVoucherSelect paramEvsVoucherSelect, int paramInt1, int paramInt2);
  
  public abstract PageInfo findHeaderByCondition(EvsVoucherV paramEvsVoucherV, int paramInt1, int paramInt2);
  
  public abstract void update(String paramString1, String paramString2);
  
  public abstract void updateCheckStatus(String paramString1, String paramString2);
  
  public abstract void updateEntry(EvsVoucher paramEvsVoucher);
  
  public abstract void updateImage(Long paramLong, String paramString);
  
  public abstract void updateImageByVoucherId(Long paramLong);
  
  public abstract Map findEntry(EvsVoucherSelect paramEvsVoucherSelect, int paramInt1, int paramInt2);
  
  public abstract void saveVoucher(String paramString);
  
  public abstract void saveImage(String paramString);
  
  public abstract List<EvsVoucherV> findEvsVoucherVList(String paramString);
  
  public abstract EvsVoucher findEvsVoucher(String paramString);
  
  public abstract List<EvsVoucherInvoice> findEvsVoucherInvoice(String paramString);
  
  public abstract PageInfo findEmployeeHeaderByScanCode(EvsVoucherV paramEvsVoucherV, int paramInt1, int paramInt2);
  
  public abstract PageInfo findHeaderByQry(EvsVoucherV paramEvsVoucherV, int paramInt1, int paramInt2);
  
  public abstract List<EvsVoucherV> findHeader();
  
  public abstract void updateVoucherStatus(Long paramLong);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.eBillManage.IEvsVoucherCheckFindDAO
 * JD-Core Version:    0.7.0.1
 */