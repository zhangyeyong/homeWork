package com.zte.evs.ebill.access.eBillManage;

import com.zte.evs.ebill.model.eBillManage.EvsBillHistoriesV;
import java.util.List;

public abstract interface IEvsBillHistoriesDAO
{
  public abstract List<EvsBillHistoriesV> findHistoryByBoeNum(String paramString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.eBillManage.IEvsBillHistoriesDAO
 * JD-Core Version:    0.7.0.1
 */