package com.zte.evs.ebill.common.invoice.action;

import com.zte.evs.ebill.model.eBillManage.EvsVoucher;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public abstract interface IImageThreadDS
  extends Callable<Integer>
{
  public abstract void setEvsVoucherList(List<EvsVoucher> paramList);
  
  public abstract void setMapList(List<Map<String, Object>> paramList);
  
  public abstract void buildImage()
    throws Exception;
  
  public abstract Map<String, Object> getMap(Long paramLong);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.common.invoice.action.IImageThreadDS
 * JD-Core Version:    0.7.0.1
 */