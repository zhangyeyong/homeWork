package com.zte.web.service.common;

import com.zte.ssb.aop.AfterReturningAdvice;
import com.zte.ssb.aop.MethodBeforeAdvice;
import com.zte.ssb.aop.ThrowsAdvice;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.log4j.Logger;

public class SevCommonLog
  implements MethodBeforeAdvice, AfterReturningAdvice, ThrowsAdvice
{
  Logger log = Logger.getLogger(getClass());
  
  public void before(Method paramMethod, Object[] paramArrayOfObject, Object paramObject)
    throws Throwable
  {
    this.log = Logger.getLogger(paramObject.getClass());
    this.log.error("------------------" + getDesStr(paramObject) + "开始--------------------");
    for (Object localObject1 : paramArrayOfObject) {
      if (ObjectCommon.isArray(localObject1))
      {
        Object[] arrayOfObject2 = (Object[])localObject1;
        for (Object localObject2 : arrayOfObject2) {
          log(localObject2);
        }
      }
      else
      {
        log(localObject1);
      }
    }
  }
  
  public void afterReturning(Object paramObject1, Method paramMethod, Object[] paramArrayOfObject, Object paramObject2)
    throws Throwable
  {
    log(paramObject1);
    this.log.error("------------------" + getDesStr(paramObject2) + "结束--------------------");
  }
  
  public String getDesStr(Object paramObject)
  {
    String str = "";
    try
    {
      str = paramObject.getClass().getMethod("getDescriptStr", new Class[0]).invoke(paramObject, new Object[0]) + "";
    }
    catch (Exception localException) {}
    return str;
  }
  
  public void afterThrowing(Method paramMethod, Object[] paramArrayOfObject, Object paramObject, Throwable paramThrowable)
  {
    this.log.error("------------------" + getDesStr(paramObject) + "错误信息--------------------");
    this.log.error(paramThrowable);
    paramThrowable.printStackTrace();
    this.log.error("------------------" + getDesStr(paramObject) + "错误信息结束--------------------");
  }
  
  public void log(Object paramObject)
    throws IllegalArgumentException, IllegalAccessException, InvocationTargetException
  {
    if (paramObject != null)
    {
      Class localClass = paramObject.getClass();
      this.log.error("类名=====" + localClass.getName());
      Method[] arrayOfMethod1 = localClass.getMethods();
      for (Method localMethod : arrayOfMethod1) {
        if (localMethod.getName().indexOf("get") == 0) {
          this.log.error(localMethod.getName() + "==" + localMethod.invoke(paramObject, new Object[0]));
        }
      }
      this.log.error("类名=====" + localClass.getName() + "***********");
    }
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.common.SevCommonLog
 * JD-Core Version:    0.7.0.1
 */