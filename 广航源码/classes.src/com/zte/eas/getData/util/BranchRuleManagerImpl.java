package com.zte.eas.getData.util;

import com.deppon.bpmsapi.module.client.api.IBranchRuleManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class BranchRuleManagerImpl
  implements IBranchRuleManager
{
  public boolean[] isTrue(String[] paramArrayOfString, Map paramMap)
  {
    boolean[] arrayOfBoolean = new boolean[paramArrayOfString.length];
    for (int i = 0; i < paramArrayOfString.length; i++) {
      if ((paramArrayOfString[i].equals("true")) || (paramArrayOfString[i].equals("false")))
      {
        arrayOfBoolean[i] = Boolean.parseBoolean(paramArrayOfString[i]);
      }
      else
      {
        boolean bool = false;
        try
        {
          String[] arrayOfString = paramArrayOfString[i].split("#");
          Class localClass = Class.forName(arrayOfString[0].replaceAll("BIZ_", ""));
          Object localObject = localClass.newInstance();
          Method localMethod = localClass.getMethod(arrayOfString[1], new Class[] { Map.class });
          bool = ((Boolean)localMethod.invoke(localObject, new Object[] { paramMap })).booleanValue();
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          localClassNotFoundException.printStackTrace();
        }
        catch (SecurityException localSecurityException)
        {
          localSecurityException.printStackTrace();
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          localNoSuchMethodException.printStackTrace();
        }
        catch (InstantiationException localInstantiationException)
        {
          localInstantiationException.printStackTrace();
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          localIllegalAccessException.printStackTrace();
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          localIllegalArgumentException.printStackTrace();
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          localInvocationTargetException.printStackTrace();
        }
        arrayOfBoolean[i] = bool;
      }
    }
    return arrayOfBoolean;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.getData.util.BranchRuleManagerImpl
 * JD-Core Version:    0.7.0.1
 */