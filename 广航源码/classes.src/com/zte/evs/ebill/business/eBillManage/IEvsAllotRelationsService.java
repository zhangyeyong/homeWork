package com.zte.evs.ebill.business.eBillManage;

import com.zte.evs.ebill.model.eBillManage.EvsAllotRelationsV;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;

public abstract interface IEvsAllotRelationsService
{
  public abstract TableDataInfo getAllotRelationsVQuery(EvsAllotRelationsV paramEvsAllotRelationsV, int paramInt1, int paramInt2);
  
  public abstract EvsAllotRelationsV getAllotRelationsVById(String paramString);
  
  @Transactional(propagation=Propagation.REQUIRED)
  public abstract String updateAllotRelation(EvsAllotRelationsV paramEvsAllotRelationsV);
  
  @Transactional(propagation=Propagation.REQUIRED)
  public abstract String saveallotRelation(EvsAllotRelationsV paramEvsAllotRelationsV);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.eBillManage.IEvsAllotRelationsService
 * JD-Core Version:    0.7.0.1
 */