package com.zte.esb.util;

import com.zte.ssb.beans.BeansException;
import com.zte.ssb.beans.factory.config.ConfigurableListableBeanFactory;
import com.zte.ssb.beans.factory.config.PropertyPlaceholderConfigurer;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class MyPropertyPlaceholderConfigurer
  extends PropertyPlaceholderConfigurer
{
  private static Map<String, String> propersMap = new HashMap();
  
  protected void processProperties(ConfigurableListableBeanFactory paramConfigurableListableBeanFactory, Properties paramProperties)
    throws BeansException
  {
    super.processProperties(paramConfigurableListableBeanFactory, paramProperties);
    Iterator localIterator = paramProperties.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      String str1 = localObject.toString();
      String str2 = paramProperties.getProperty(str1);
      System.out.println("================spring开始装载properties文件===============");
      propersMap.put(str1, str2);
    }
    System.out.println(propersMap.size());
  }
  
  public static void setPropersMap(Map<String, String> paramMap)
  {
    propersMap = paramMap;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.util.MyPropertyPlaceholderConfigurer
 * JD-Core Version:    0.7.0.1
 */