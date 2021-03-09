package com.zte.evs.ebill.access.eBillManage;

import com.zte.evs.business.baseconfig.model.FasciculeTreeV;

public abstract interface IEFasciculeTreeVDAO
{
  public abstract FasciculeTreeV findFasciculeTreeVById(String paramString);
  
  public abstract String findFasciculeTreeVByCheckunit(String paramString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.eBillManage.IEFasciculeTreeVDAO
 * JD-Core Version:    0.7.0.1
 */