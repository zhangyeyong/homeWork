package com.zte.eas.appframe.business.util;

import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.ssb.servicecontainer.business.server.ISession;
import com.zte.ssb.servicecontainer.business.server.RIAContext;
import com.zte.ssb.ui.uiloader.model.UserInfo;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

public class ObjectCopyUtils
{
  static final String LOGIN_USERINFO = "loginuserinfo";
  static final String EAS_LOGIN_USERINFO = "easloginuserinfo";
  
  public static void copy(Object paramObject1, Object paramObject2)
  {
    Method[] arrayOfMethod1 = paramObject1.getClass().getMethods();
    Method[] arrayOfMethod2 = paramObject2.getClass().getMethods();
    try
    {
      for (int i = 0; i < arrayOfMethod2.length; i++)
      {
        String str1 = arrayOfMethod2[i].getName();
        String str2 = str1.substring(3);
        if (str1.startsWith("set")) {
          for (int j = 0; j < arrayOfMethod1.length; j++)
          {
            String str3 = arrayOfMethod1[j].getName();
            String str4 = str3.substring(3);
            if ((str3.startsWith("get")) && (str4.equals(str2)))
            {
              Object localObject = null;
              localObject = arrayOfMethod1[j].invoke(paramObject1, new Object[0]);
              Object[] arrayOfObject = new Object[1];
              arrayOfObject[0] = localObject;
              arrayOfMethod2[i].invoke(paramObject2, arrayOfObject);
            }
          }
        }
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
    }
    catch (InvocationTargetException localInvocationTargetException) {}
  }
  
  public static void clearWho(Object paramObject)
  {
    Method[] arrayOfMethod = paramObject.getClass().getMethods();
    Object localObject = null;
    try
    {
      for (int i = 0; i < arrayOfMethod.length; i++)
      {
        String str = arrayOfMethod[i].getName();
        if (str.equals("setCreatedBy")) {
          arrayOfMethod[i].invoke(paramObject, new Object[] { localObject });
        } else if (str.equals("setCreationDate")) {
          arrayOfMethod[i].invoke(paramObject, new Object[] { localObject });
        } else if (str.equals("setLastUpdateDate")) {
          arrayOfMethod[i].invoke(paramObject, new Object[] { localObject });
        } else if (str.equals("setLastUpdatedBy")) {
          arrayOfMethod[i].invoke(paramObject, new Object[] { localObject });
        } else if (str.equals("setLastUpdateLogin")) {
          arrayOfMethod[i].invoke(paramObject, new Object[] { localObject });
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static void setWho(Object paramObject)
  {
    Method[] arrayOfMethod = paramObject.getClass().getMethods();
    try
    {
      HashMap localHashMap1 = new HashMap();
      HashMap localHashMap2 = new HashMap();
      for (int i = 0; i < arrayOfMethod.length; i++)
      {
        localObject1 = null;
        localObject2 = arrayOfMethod[i].getName();
        if (((String)localObject2).equals("getCreatedBy"))
        {
          localObject1 = arrayOfMethod[i].invoke(paramObject, new Object[0]);
          localHashMap1.put("getCreatedBy", localObject1);
        }
        else if (((String)localObject2).equals("getCreationDate"))
        {
          localObject1 = arrayOfMethod[i].invoke(paramObject, new Object[0]);
          localHashMap1.put("getCreationDate", localObject1);
        }
        else if (((String)localObject2).equals("getLastUpdateDate"))
        {
          localObject1 = arrayOfMethod[i].invoke(paramObject, new Object[0]);
          localHashMap1.put("getLastUpdateDate", localObject1);
        }
        else if (((String)localObject2).equals("getLastUpdatedBy"))
        {
          localObject1 = arrayOfMethod[i].invoke(paramObject, new Object[0]);
          localHashMap1.put("getLastUpdatedBy", localObject1);
        }
        else if (((String)localObject2).equals("getLastUpdateLogin"))
        {
          localObject1 = arrayOfMethod[i].invoke(paramObject, new Object[0]);
          localHashMap1.put("getLastUpdateLogin", localObject1);
        }
        else if (((String)localObject2).equals("setCreatedBy"))
        {
          localHashMap2.put("getCreatedBy", arrayOfMethod[i]);
        }
        else if (((String)localObject2).equals("setCreationDate"))
        {
          localHashMap2.put("getCreationDate", arrayOfMethod[i]);
        }
        else if (((String)localObject2).equals("setLastUpdateDate"))
        {
          localHashMap2.put("getLastUpdateDate", arrayOfMethod[i]);
        }
        else if (((String)localObject2).equals("setLastUpdatedBy"))
        {
          localHashMap2.put("getLastUpdatedBy", arrayOfMethod[i]);
        }
        else if (((String)localObject2).equals("setLastUpdateLogin"))
        {
          localHashMap2.put("getLastUpdateLogin", arrayOfMethod[i]);
        }
      }
      Set localSet = localHashMap1.keySet();
      Object localObject1 = localSet.iterator();
      Object localObject2 = RIAContext.getCurrentInstance();
      Long localLong = Long.valueOf(1L);
      Object localObject3;
      Object localObject4;
      Object localObject5;
      if (localObject2 != null)
      {
        localObject3 = ((RIAContext)localObject2).getSession();
        localObject4 = (UserInfo)((ISession)localObject3).getSessionAttribute("loginuserinfo");
        localObject5 = (EasUserInfo)((ISession)localObject3).getSessionAttribute("easloginuserinfo");
        localLong = new Long(((EasUserInfo)localObject5).getUserInfoPk().toString());
      }
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (String)((Iterator)localObject1).next();
        localObject4 = localHashMap1.get(localObject3);
        if (((String)localObject3).equals("getCreatedBy"))
        {
          if (localObject4 == null)
          {
            localObject5 = (Method)localHashMap2.get(localObject3);
            ((Method)localObject5).invoke(paramObject, new Object[] { localLong });
          }
        }
        else if (((String)localObject3).equals("getCreationDate"))
        {
          if (localObject4 == null)
          {
            localObject5 = (Method)localHashMap2.get(localObject3);
            ((Method)localObject5).invoke(paramObject, new Object[] { new Date() });
          }
        }
        else if (((String)localObject3).equals("getLastUpdateDate"))
        {
          localObject5 = (Method)localHashMap2.get(localObject3);
          ((Method)localObject5).invoke(paramObject, new Object[] { new Date() });
        }
        else if (((String)localObject3).equals("getLastUpdatedBy"))
        {
          localObject5 = (Method)localHashMap2.get(localObject3);
          ((Method)localObject5).invoke(paramObject, new Object[] { localLong });
        }
        else if (((String)localObject3).equals("getLastUpdateLogin"))
        {
          localObject5 = (Method)localHashMap2.get(localObject3);
          ((Method)localObject5).invoke(paramObject, new Object[] { localLong });
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static void copyOnlyNull(Object paramObject1, Object paramObject2)
  {
    Method[] arrayOfMethod1 = paramObject1.getClass().getMethods();
    Method[] arrayOfMethod2 = paramObject2.getClass().getMethods();
    try
    {
      for (int i = 0; i < arrayOfMethod2.length; i++)
      {
        String str1 = arrayOfMethod2[i].getName();
        String str2 = str1.substring(3);
        if (str1.startsWith("set")) {
          for (int j = 0; j < arrayOfMethod2.length; j++) {
            if (j != i)
            {
              String str3 = arrayOfMethod2[j].getName();
              String str4 = str3.substring(3);
              if ((str3.startsWith("get")) && (str4.equalsIgnoreCase(str2)))
              {
                Object localObject1 = null;
                localObject1 = arrayOfMethod2[j].invoke(paramObject2, new Object[0]);
                if (localObject1 != null) {
                  break;
                }
                for (int k = 0; k < arrayOfMethod1.length; k++)
                {
                  String str5 = arrayOfMethod1[k].getName();
                  String str6 = str5.substring(3);
                  if ((str5.startsWith("get")) && (str6.equals(str2)))
                  {
                    Object localObject2 = null;
                    localObject2 = arrayOfMethod1[k].invoke(paramObject1, new Object[0]);
                    Object[] arrayOfObject = new Object[1];
                    arrayOfObject[0] = localObject2;
                    arrayOfMethod2[i].invoke(paramObject2, arrayOfObject);
                    break;
                  }
                }
                break;
              }
            }
          }
        }
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      localInvocationTargetException.printStackTrace();
    }
  }
  
  public static Boolean objectCheckChange(Object paramObject1, Object paramObject2, Vector paramVector)
  {
    Method[] arrayOfMethod1 = paramObject1.getClass().getMethods();
    Method[] arrayOfMethod2 = paramObject2.getClass().getMethods();
    Boolean localBoolean = Boolean.valueOf(false);
    try
    {
      String str1;
      Object localObject1;
      Object localObject2;
      Object localObject3;
      if (paramVector == null)
      {
        for (int i = 0; i < arrayOfMethod1.length; i++)
        {
          str1 = arrayOfMethod1[i].getName();
          String str2 = arrayOfMethod1[i].getName().substring(3);
          if (str1.startsWith("get"))
          {
            localObject1 = arrayOfMethod1[i].invoke(paramObject1, new Object[0]);
            int k = 0;
            while (k < arrayOfMethod2.length)
            {
              localObject2 = arrayOfMethod2[i].getName();
              String str4 = arrayOfMethod2[i].getName().substring(3);
              if ((((String)localObject2).startsWith("get")) && (str4.equalsIgnoreCase(str2)))
              {
                localObject3 = arrayOfMethod2[i].invoke(paramObject2, new Object[0]);
                if (localObject3.equals(localObject1)) {
                  break;
                }
                return Boolean.valueOf(true);
              }
              i++;
            }
          }
        }
      }
      else
      {
        Iterator localIterator = paramVector.iterator();
        while (localIterator.hasNext())
        {
          str1 = (String)localIterator.next();
          for (int j = 0; j < arrayOfMethod1.length; j++)
          {
            localObject1 = arrayOfMethod1[j].getName();
            String str3 = arrayOfMethod1[j].getName().substring(3);
            if ((((String)localObject1).startsWith("get")) && (str3.equalsIgnoreCase(str1)))
            {
              localObject2 = arrayOfMethod1[j].invoke(paramObject1, new Object[0]);
              int m = 0;
              while (m < arrayOfMethod2.length)
              {
                localObject3 = arrayOfMethod2[j].getName();
                String str5 = arrayOfMethod2[j].getName().substring(3);
                if ((((String)localObject3).startsWith("get")) && (str5.equalsIgnoreCase(str3)))
                {
                  Object localObject4 = arrayOfMethod2[j].invoke(paramObject2, new Object[0]);
                  if (localObject4.equals(localObject2)) {
                    break;
                  }
                  return Boolean.valueOf(true);
                }
                j++;
              }
              break;
            }
          }
        }
      }
    }
    catch (Exception localException) {}
    return localBoolean;
  }
  
  public static void main(String[] paramArrayOfString) {}
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.business.util.ObjectCopyUtils
 * JD-Core Version:    0.7.0.1
 */