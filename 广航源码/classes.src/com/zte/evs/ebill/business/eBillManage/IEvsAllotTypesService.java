package com.zte.evs.ebill.business.eBillManage;

import com.zte.evs.ebill.model.eBillManage.EvsAllotTypesV;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;

public abstract interface IEvsAllotTypesService
{
  public abstract TableDataInfo getAllotTypesVQuery(EvsAllotTypesV paramEvsAllotTypesV, int paramInt1, int paramInt2);
  
  public abstract EvsAllotTypesV getAllotTypeVById(String paramString);
  
  public abstract boolean isExistAllotTypeByCode(String paramString);
  
  public abstract boolean isExistAllotTypeByCode(String paramString1, String paramString2);
  
  public abstract boolean isExistAllotTypeByName(String paramString);
  
  public abstract boolean isExistAllotTypeByName(String paramString1, String paramString2);
  
  @Transactional(propagation=Propagation.REQUIRED)
  public abstract String updateAllotType(EvsAllotTypesV paramEvsAllotTypesV);
  
  @Transactional(propagation=Propagation.REQUIRED)
  public abstract String saveAllotType(EvsAllotTypesV paramEvsAllotTypesV);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.eBillManage.IEvsAllotTypesService
 * JD-Core Version:    0.7.0.1
 */