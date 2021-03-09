package com.zte.eas.flowruleengine.business.posstru.service;

import com.zte.eas.flowruleengine.business.posstru.model.FbpEmployeesQryV;
import com.zte.eas.flowruleengine.business.posstru.model.FbpPosStruElementsV;
import com.zte.eas.flowruleengine.business.posstru.model.FbpPseHoldersV;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.DomainService;
import java.util.List;

public abstract interface IFbpPosStruElementsMgrDS
  extends DomainService
{
  public abstract List findPosStruElementsVByQry(String paramString1, String paramString2, String paramString3);
  
  public abstract FbpPosStruElementsV findPosStruElementsVById(String paramString);
  
  public abstract Long findVirtualCompanyId(String paramString1, String paramString2);
  
  public abstract String savePosStruElements(FbpPosStruElementsV paramFbpPosStruElementsV);
  
  public abstract String savePseHolders(String paramString, List<FbpEmployeesQryV> paramList);
  
  public abstract TableDataInfo findPseHoldersVByElementId(String paramString1, String paramString2, String paramString3);
  
  public abstract String saveRelations(String paramString, List<FbpPseHoldersV> paramList);
  
  public abstract String removePseHolders(String paramString);
  
  public abstract String deletePseHolders(String paramString1, String paramString2, Long paramLong);
  
  public abstract TableDataInfo getFbpEmployeesQryVByQry(FbpEmployeesQryV paramFbpEmployeesQryV, String paramString1, String paramString2);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.flowruleengine.business.posstru.service.IFbpPosStruElementsMgrDS
 * JD-Core Version:    0.7.0.1
 */