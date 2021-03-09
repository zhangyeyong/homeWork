package com.zte.evs.ebill.business.eBillManage;

import com.zte.evs.ebill.model.eBillManage.EvsSubDocType;
import com.zte.evs.ebill.model.eBillManage.EvsSubDocTypeV;
import com.zte.evs.ebill.model.eBillManage.EvsSubDocTypeVo;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import java.util.Map;

public abstract interface IEvsSubDocTypeService
{
  public abstract Map getSubDocTypeForSelect();
  
  public abstract String saveSubDocType(EvsSubDocTypeVo paramEvsSubDocTypeVo);
  
  public abstract String updateSubDocType(EvsSubDocTypeVo paramEvsSubDocTypeVo);
  
  public abstract EvsSubDocType findById(Long paramLong);
  
  public abstract Map getSubDocTypeForSelectByName();
  
  public abstract TableDataInfo getSubDocTypeQuery(EvsSubDocTypeVo paramEvsSubDocTypeVo, int paramInt1, int paramInt2);
  
  public abstract String getMaxNumber();
  
  public abstract String findSubDocTypeByNum(String paramString);
  
  public abstract EvsSubDocTypeV findSubDocTypeByNumber(String paramString);
  
  public abstract void updateSequenceNumberBySubDocId(String paramString1, String paramString2);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.eBillManage.IEvsSubDocTypeService
 * JD-Core Version:    0.7.0.1
 */