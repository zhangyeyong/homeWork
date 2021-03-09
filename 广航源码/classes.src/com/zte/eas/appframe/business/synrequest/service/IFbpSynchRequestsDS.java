package com.zte.eas.appframe.business.synrequest.service;

import com.zte.eas.appframe.business.synrequest.model.FbpSynchRequestsV;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.DomainService;

public abstract interface IFbpSynchRequestsDS
  extends DomainService
{
  public abstract FbpSynchRequestsV findSynchRequestsVById(String paramString);
  
  public abstract TableDataInfo findSynchRequestsVByCon(FbpSynchRequestsV paramFbpSynchRequestsV, String paramString1, String paramString2);
  
  public abstract String startupSynchRequest(String paramString);
  
  public abstract String runSynchRequest(String paramString);
  
  public abstract String autoRunSynchRequest(FbpSynchRequestsV paramFbpSynchRequestsV);
  
  public abstract String saveSynchRequest(FbpSynchRequestsV paramFbpSynchRequestsV);
  
  public abstract String hangupSynchRequest(String paramString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.business.synrequest.service.IFbpSynchRequestsDS
 * JD-Core Version:    0.7.0.1
 */