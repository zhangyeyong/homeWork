package com.zte.eas.organization.business.checkunits.service;

import com.zte.eas.organization.business.checkunits.model.FbpCheckUnitContentsV;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.DomainService;

public abstract interface IFbpCheckUnitContentsVDS
  extends DomainService
{
  public abstract FbpCheckUnitContentsV findCheckUnitContentsVById(String paramString);
  
  public abstract TableDataInfo findCheckUnitContentsVByQry(FbpCheckUnitContentsV paramFbpCheckUnitContentsV, String paramString1, String paramString2);
  
  public abstract String saveCheckUnitContentsV(FbpCheckUnitContentsV paramFbpCheckUnitContentsV);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.business.checkunits.service.IFbpCheckUnitContentsVDS
 * JD-Core Version:    0.7.0.1
 */