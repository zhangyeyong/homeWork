package com.zte.evs.ebill.access.eBillManage;

import com.zte.evs.ebill.model.eBillManage.EvsDocTypeMap;
import java.util.List;

public abstract interface IEvsDocTypeMapDAO
{
  public abstract void save(EvsDocTypeMap paramEvsDocTypeMap);
  
  public abstract List findEvsDocTypeMapBySubDocId(Long paramLong);
  
  public abstract void remove(Long paramLong);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.eBillManage.IEvsDocTypeMapDAO
 * JD-Core Version:    0.7.0.1
 */