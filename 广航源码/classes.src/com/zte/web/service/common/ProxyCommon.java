package com.zte.web.service.common;

public abstract interface ProxyCommon
{
  public abstract Object doProcess(Object paramObject)
    throws Throwable;
  
  public abstract Object imp(Object paramObject)
    throws Throwable;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.common.ProxyCommon
 * JD-Core Version:    0.7.0.1
 */