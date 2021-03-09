package com.zte.eas.getData.OranizationUnits.dao;

import com.zte.ssb.framework.base.DAO;

public abstract interface IErrorMessageDAO
  extends DAO
{
  public abstract String getErrInfos(String paramString1, String paramString2);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.getData.OranizationUnits.dao.IErrorMessageDAO
 * JD-Core Version:    0.7.0.1
 */