package com.zte.evs.ebill.business.eBillManage;

import com.zte.evs.ebill.model.eBillManage.EvsDocType;
import com.zte.evs.ebill.model.eBillManage.EvsDocTypeVo;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import java.util.Map;

public abstract interface IEvsDocTypeService
{
  public abstract TableDataInfo getDocTypeQuery(EvsDocTypeVo paramEvsDocTypeVo, int paramInt1, int paramInt2);
  
  public abstract String saveDocType(EvsDocTypeVo paramEvsDocTypeVo);
  
  public abstract EvsDocType findById(Long paramLong);
  
  public abstract String updateDocType(EvsDocTypeVo paramEvsDocTypeVo);
  
  public abstract Map getDocTypeForSelect();
  
  public abstract Map getDocTypeForDeadline();
  
  public abstract String getDocTypeDeadline(Long paramLong);
  
  public abstract String getDeadlineName(String paramString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.eBillManage.IEvsDocTypeService
 * JD-Core Version:    0.7.0.1
 */