package com.zte.evs.ebill.access.eBillManage;

import com.zte.evs.ebill.model.eBillManage.EvsAllotRelations;
import com.zte.evs.ebill.model.eBillManage.EvsAllotRelationsV;
import java.util.Map;

public abstract interface IEvsAllotRelationsDAO
{
  public abstract Map findAllotRelationsVByQry(EvsAllotRelationsV paramEvsAllotRelationsV, int paramInt1, int paramInt2);
  
  public abstract EvsAllotRelationsV findAllotRelationsVById(Long paramLong);
  
  public abstract EvsAllotRelations findAllotRelationsById(Long paramLong);
  
  public abstract int getCountByTerm(Long paramLong1, Long paramLong2, String paramString1, String paramString2, Long paramLong3);
  
  public abstract int getCountByTypeId(Long paramLong);
  
  public abstract int getCountBySiteId(Long paramLong);
  
  public abstract void update(EvsAllotRelations paramEvsAllotRelations);
  
  public abstract void save(EvsAllotRelations paramEvsAllotRelations);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.eBillManage.IEvsAllotRelationsDAO
 * JD-Core Version:    0.7.0.1
 */