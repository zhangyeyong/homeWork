package com.zte.evs.ebill.business.eBillManage;

import com.zte.evs.ebill.model.eBillManage.EvsVoucherHistoryModel;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;

public abstract interface IEvsVoucherHistoryService
{
  public abstract TableDataInfo findAllHistory(EvsVoucherHistoryModel paramEvsVoucherHistoryModel, int paramInt1, int paramInt2);
  
  public abstract TableDataInfo findHistoryByObjectCode(String paramString, int paramInt1, int paramInt2);
  
  public abstract TableDataInfo findHistoryByPackageId(String paramString, int paramInt1, int paramInt2);
  
  public abstract TableDataInfo findHistoryByObjectCodeNew(String paramString, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract TableDataInfo findHistoryByVoucherId(String paramString, int paramInt1, int paramInt2);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.eBillManage.IEvsVoucherHistoryService
 * JD-Core Version:    0.7.0.1
 */