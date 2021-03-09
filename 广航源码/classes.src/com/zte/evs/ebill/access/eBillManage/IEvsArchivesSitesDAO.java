package com.zte.evs.ebill.access.eBillManage;

import com.zte.evs.ebill.model.eBillManage.EvsArchivesSites;
import com.zte.evs.ebill.model.eBillManage.EvsArchivesSitesV;
import java.util.Map;

public abstract interface IEvsArchivesSitesDAO
{
  public abstract Map findArchivesSitesVByQry(EvsArchivesSitesV paramEvsArchivesSitesV, int paramInt1, int paramInt2);
  
  public abstract EvsArchivesSitesV findArchivesSitesVById(Long paramLong);
  
  public abstract EvsArchivesSites findArchivesSitesById(Long paramLong);
  
  public abstract int getCountByCode(String paramString);
  
  public abstract int getCountByName(String paramString);
  
  public abstract boolean canEmploySiteById(Long paramLong);
  
  public abstract void update(EvsArchivesSites paramEvsArchivesSites);
  
  public abstract void save(EvsArchivesSites paramEvsArchivesSites);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.eBillManage.IEvsArchivesSitesDAO
 * JD-Core Version:    0.7.0.1
 */