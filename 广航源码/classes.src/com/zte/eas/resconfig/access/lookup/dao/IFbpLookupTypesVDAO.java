package com.zte.eas.resconfig.access.lookup.dao;

import com.zte.eas.resconfig.business.lookup.model.ResConfigCon;
import com.zte.ssb.framework.base.DAO;
import com.zte.ssb.framework.base.util.PageInfo;

public abstract interface IFbpLookupTypesVDAO
  extends DAO
{
  public abstract PageInfo findLookupValuesByType(ResConfigCon paramResConfigCon, int paramInt1, int paramInt2);
  
  public abstract String getDescriptions(String paramString1, String paramString2);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.resconfig.access.lookup.dao.IFbpLookupTypesVDAO
 * JD-Core Version:    0.7.0.1
 */