package com.zte.eas.getData.util;

import com.deppon.bpms.module.shared.domain.BpmsParticipant;
import com.deppon.bpmsapi.module.client.api.IParticipantRuleManager;
import com.deppon.bpmsapi.module.client.domain.ParticipantRule;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ParticipantRuleManagerImpl
  implements IParticipantRuleManager
{
  public Map<String, BpmsParticipant[]> getParticipants(ParticipantRule[] paramArrayOfParticipantRule, Map paramMap)
  {
    HashMap localHashMap = new HashMap();
    for (int i = 0; i < paramArrayOfParticipantRule.length; i++) {
      try
      {
        String[] arrayOfString = paramArrayOfParticipantRule[i].getRule().split("#");
        Class localClass = Class.forName(arrayOfString[0].replaceAll("BIZ_", ""));
        Object localObject = localClass.newInstance();
        Method localMethod = localClass.getMethod(arrayOfString[1], new Class[] { ParticipantRule.class, Map.class });
        BpmsParticipant[] arrayOfBpmsParticipant = (BpmsParticipant[])localMethod.invoke(localObject, new Object[] { paramArrayOfParticipantRule[i], paramMap });
        localHashMap.put(paramArrayOfParticipantRule[i].getNextActivityDefId(), arrayOfBpmsParticipant);
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
    }
    return localHashMap;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.getData.util.ParticipantRuleManagerImpl
 * JD-Core Version:    0.7.0.1
 */