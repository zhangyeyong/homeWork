package com.zte.eas.resconfig.access.lookup.dao;

import com.zte.eas.resconfig.business.lookup.model.FbpLookupValuesV;
import com.zte.eas.resconfig.business.lookup.model.ResConfigCon;
import com.zte.ssb.framework.base.DAO;
import java.util.List;

public abstract interface IFbpLookupValuesVDAO
  extends DAO
{
  public abstract List<FbpLookupValuesV> findFbpLookupValuesVByCon(ResConfigCon paramResConfigCon);
  
  public abstract List<FbpLookupValuesV> findFbpLookupValuess(String paramString);
  
  public abstract FbpLookupValuesV findFbpLookupValues(String paramString1, String paramString2);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.resconfig.access.lookup.dao.IFbpLookupValuesVDAO
 * JD-Core Version:    0.7.0.1
 */