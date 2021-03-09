package com.zte.evs.ebill.business.eBillManage;

import java.util.List;
import java.util.Map;

public abstract interface IEvsVoucherLineQuery
{
  public abstract List<Map<String, String>> findLineByVoucherId(Long paramLong, String paramString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.eBillManage.IEvsVoucherLineQuery
 * JD-Core Version:    0.7.0.1
 */