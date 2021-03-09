package com.zte.evs.ebill.access.eBillManage;

import com.zte.evs.ebill.model.eBillManage.EvsAllotTypes;
import com.zte.evs.ebill.model.eBillManage.EvsAllotTypesV;
import java.util.Map;

public abstract interface IEvsAllotTypesDAO
{
  public abstract Map findAllotTypesVByQry(EvsAllotTypesV paramEvsAllotTypesV, int paramInt1, int paramInt2);
  
  public abstract EvsAllotTypesV findAllotTypeVById(Long paramLong);
  
  public abstract EvsAllotTypes findAllotTypeById(Long paramLong);
  
  public abstract EvsAllotTypes findAllotTypeByCode(String paramString1, String paramString2);
  
  public abstract EvsAllotTypes findAllotTypeByName(String paramString1, String paramString2);
  
  public abstract int getCountByName(String paramString);
  
  public abstract int getCountByCode(String paramString);
  
  public abstract boolean canEmployTypeById(Long paramLong);
  
  public abstract void update(EvsAllotTypes paramEvsAllotTypes);
  
  public abstract void save(EvsAllotTypes paramEvsAllotTypes);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.eBillManage.IEvsAllotTypesDAO
 * JD-Core Version:    0.7.0.1
 */