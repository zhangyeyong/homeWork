package com.zte.evs.ebill.access.eBillManage;

import com.zte.evs.ebill.model.eBillManage.EvsDocType;
import com.zte.evs.ebill.model.eBillManage.EvsDocTypeVo;
import java.util.List;
import java.util.Map;

public abstract interface IEvsDocTypeDAO
{
  public abstract EvsDocType findById(Long paramLong);
  
  public abstract Map findDocTypeByQry(EvsDocTypeVo paramEvsDocTypeVo, int paramInt1, int paramInt2);
  
  public abstract String save(EvsDocType paramEvsDocType);
  
  public abstract void update(EvsDocType paramEvsDocType);
  
  public abstract int getCount(String paramString);
  
  public abstract int getCountName(String paramString);
  
  public abstract List<EvsDocType> findDocTypeForSelect();
  
  public abstract List findDocTypeForDeadline();
  
  public abstract String findDeadline(String paramString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.eBillManage.IEvsDocTypeDAO
 * JD-Core Version:    0.7.0.1
 */