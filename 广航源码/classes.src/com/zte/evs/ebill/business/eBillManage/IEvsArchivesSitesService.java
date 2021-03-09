package com.zte.evs.ebill.business.eBillManage;

import com.zte.evs.ebill.model.eBillManage.EvsArchivesSitesV;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;

public abstract interface IEvsArchivesSitesService
{
  public abstract TableDataInfo getArchivesSitesVQuery(EvsArchivesSitesV paramEvsArchivesSitesV, int paramInt1, int paramInt2);
  
  public abstract EvsArchivesSitesV getArchivesSitesVById(String paramString);
  
  @Transactional(propagation=Propagation.REQUIRED)
  public abstract String updateArchivesSite(EvsArchivesSitesV paramEvsArchivesSitesV);
  
  @Transactional(propagation=Propagation.REQUIRED)
  public abstract String saveArchivesSite(EvsArchivesSitesV paramEvsArchivesSitesV);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.eBillManage.IEvsArchivesSitesService
 * JD-Core Version:    0.7.0.1
 */