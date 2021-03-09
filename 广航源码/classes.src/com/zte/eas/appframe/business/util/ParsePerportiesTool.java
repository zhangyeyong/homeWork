package com.zte.eas.appframe.business.util;

import com.zte.ssb.servicecontainer.business.server.RIAContext;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ParsePerportiesTool
{
  public static final Map ACCESSORYPATHS_MAP = new HashMap();
  
  static
  {
    if (ACCESSORYPATHS_MAP.isEmpty())
    {
      Properties localProperties = new Properties();
      try
      {
        RIAContext localRIAContext = RIAContext.getCurrentInstance();
        String str1 = localRIAContext.getRealPath("WEB-INF" + File.separator + "classes" + File.separator + "accessoryPaths.properties");
        BufferedInputStream localBufferedInputStream = new BufferedInputStream(new FileInputStream(str1));
        localProperties.load(localBufferedInputStream);
        Enumeration localEnumeration = localProperties.propertyNames();
        while (localEnumeration.hasMoreElements())
        {
          String str2 = (String)localEnumeration.nextElement();
          String str3 = localProperties.getProperty(str2);
          ACCESSORYPATHS_MAP.put(str2, str3);
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.business.util.ParsePerportiesTool
 * JD-Core Version:    0.7.0.1
 */