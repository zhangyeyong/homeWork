package com.zte.eas.resconfig.access.lookup.dao;

import com.zte.eas.resconfig.business.lookup.model.FbpLookupTypes;
import com.zte.eas.resconfig.business.lookup.model.ResConfigCon;
import com.zte.ssb.framework.base.DAO;
import java.util.List;

public abstract interface IFbpLookupTypesDAO
  extends DAO
{
  public abstract List<FbpLookupTypes> findFbpLookupTypess(ResConfigCon paramResConfigCon);
  
  public abstract List<FbpLookupTypes> findFbpLookupTypess();
  
  public abstract void removeFbpLookupTypes(FbpLookupTypes paramFbpLookupTypes);
  
  public abstract void insertFbpLookupTypes(FbpLookupTypes paramFbpLookupTypes);
  
  public abstract void updateFbpLookupTypes(FbpLookupTypes paramFbpLookupTypes);
  
  public abstract void insertFbpLookupTypess(List<FbpLookupTypes> paramList);
  
  public abstract void removeFbpLookupTypess(List<FbpLookupTypes> paramList);
  
  public abstract void updateFbpLookupTypess(List<FbpLookupTypes> paramList);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.resconfig.access.lookup.dao.IFbpLookupTypesDAO
 * JD-Core Version:    0.7.0.1
 */