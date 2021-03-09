package com.zte.eimage.business.baseconfig.service;

import com.zte.ssb.framework.base.DomainService;
import java.util.List;

public abstract interface IImageCommonDS
  extends DomainService
{
  public abstract List<Object> findObjectBySQL(String paramString, List paramList, Class paramClass);
  
  public abstract Object findObject(String paramString, List paramList, Class paramClass);
  
  public abstract void executeSql(String paramString, List paramList);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.service.IImageCommonDS
 * JD-Core Version:    0.7.0.1
 */