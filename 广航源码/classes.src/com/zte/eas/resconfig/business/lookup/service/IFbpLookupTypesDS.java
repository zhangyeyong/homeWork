package com.zte.eas.resconfig.business.lookup.service;

import com.zte.eas.resconfig.business.lookup.model.FbpLookupTypes;
import com.zte.eas.resconfig.business.lookup.model.FbpLookupValues;
import com.zte.eas.resconfig.business.lookup.model.FbpLookupValuesV;
import com.zte.eas.resconfig.business.lookup.model.ResConfigCon;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.DomainService;
import java.util.HashMap;
import java.util.List;

public abstract interface IFbpLookupTypesDS
  extends DomainService, IFbpLookupValuesManage
{
  public abstract FbpLookupTypes findLookupTypeByType(String paramString);
  
  public abstract List<FbpLookupValuesV> findLookupValuesByTypeForLookup(String paramString);
  
  public abstract List<FbpLookupValuesV> findLookupValuesByType(String paramString);
  
  public abstract TableDataInfo findLookupTypesByCon(ResConfigCon paramResConfigCon, String paramString1, String paramString2);
  
  public abstract HashMap findLookupValuesForSelectCtr(String paramString1, String paramString2, String paramString3);
  
  public abstract HashMap findLookupValuesForSelectCtr(String paramString1, String paramString2);
  
  public abstract HashMap findLookupValuesFor(String paramString1, String paramString2);
  
  public abstract String saveLookup(FbpLookupTypes paramFbpLookupTypes, List<FbpLookupValues> paramList, String paramString);
  
  public abstract String clearCatches();
  
  public abstract HashMap findLookupValuesForSelectCtrForFascicule(String paramString1, String paramString2, String paramString3);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.resconfig.business.lookup.service.IFbpLookupTypesDS
 * JD-Core Version:    0.7.0.1
 */