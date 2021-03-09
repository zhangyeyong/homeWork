package com.zte.evs.ebill.access.eBillManage;

import com.zte.evs.ebill.model.eBillManage.EvsSubDocType;
import com.zte.evs.ebill.model.eBillManage.EvsSubDocTypeV;
import com.zte.evs.ebill.model.eBillManage.EvsSubDocTypeVo;
import java.util.List;
import java.util.Map;

public abstract interface IEvsSubDocTypeDAO
{
  public abstract List<EvsSubDocType> findSubDocTypeForSelect();
  
  public abstract String save(EvsSubDocType paramEvsSubDocType);
  
  public abstract void update(EvsSubDocType paramEvsSubDocType);
  
  public abstract EvsSubDocType findById(Long paramLong);
  
  public abstract int getCount(String paramString);
  
  public abstract int getCountByDocId(Long paramLong);
  
  public abstract Map findSubDocTypeByQry(EvsSubDocTypeVo paramEvsSubDocTypeVo, int paramInt1, int paramInt2);
  
  public abstract int getCountName(String paramString);
  
  public abstract String getMaxNumber();
  
  public abstract String findSubDocTypeByNum(String paramString);
  
  public abstract EvsSubDocTypeV findSubDocTypeByNumber(String paramString);
  
  public abstract void updateSequenceNumberBySubDocId(String paramString1, String paramString2);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.eBillManage.IEvsSubDocTypeDAO
 * JD-Core Version:    0.7.0.1
 */