package com.zte.web.service.common;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.log4j.Logger;

public class ObjectLog
{
  Logger log;
  
  public void log(Object paramObject1, Object paramObject2)
    throws IllegalArgumentException, IllegalAccessException, InvocationTargetException
  {
    this.log = Logger.getLogger(paramObject1.getClass());
    Method[] arrayOfMethod1 = paramObject1.getClass().getMethods();
    for (Method localMethod : arrayOfMethod1) {
      if (localMethod.getName().indexOf("get") == 0) {
        this.log.error(localMethod.getName() + "==" + localMethod.invoke(paramObject1, new Object[0]));
      }
    }
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.common.ObjectLog
 * JD-Core Version:    0.7.0.1
 */