package com.zte.eas.resconfig.access.lookup.dao;

import com.zte.eas.resconfig.business.lookup.model.FbpLookupValues;
import com.zte.ssb.framework.base.DAO;
import java.util.List;

public abstract interface IFbpLookupValuesDAO
  extends DAO
{
  public abstract FbpLookupValues findFbpLookupValues(Long paramLong);
  
  public abstract List<FbpLookupValues> findFbpLookupValuess(String paramString);
  
  public abstract List<FbpLookupValues> findFbpLookupValuess();
  
  public abstract void removeFbpLookupValues(Long paramLong);
  
  public abstract void removeFbpLookupValues(FbpLookupValues paramFbpLookupValues);
  
  public abstract void insertFbpLookupValues(FbpLookupValues paramFbpLookupValues);
  
  public abstract void updateFbpLookupValues(FbpLookupValues paramFbpLookupValues);
  
  public abstract void insertFbpLookupValuess(List<FbpLookupValues> paramList);
  
  public abstract void removeFbpLookupValuess(List<FbpLookupValues> paramList);
  
  public abstract void updateFbpLookupValuess(List<FbpLookupValues> paramList);
  
  public abstract Object findFbpLookupValues(String paramString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.resconfig.access.lookup.dao.IFbpLookupValuesDAO
 * JD-Core Version:    0.7.0.1
 */