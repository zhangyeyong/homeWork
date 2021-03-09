package com.zte.eimage.business.baseconfig.service;

import com.zte.eas.bmsctrl.ws.Fb_SC_CMS_00001.DS.IFbpEmployeeDS;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployees;
import com.zte.ssb.AccessPropertiesFile;
import com.zte.ssb.framework.SSBBus;
import java.util.Calendar;
import java.util.Date;

public class PasswordStrategyUtil
{
  private static Integer PASS_ERROR_COUNT = null;
  private static Integer AUTO_UNLOCK_DATE = Integer.valueOf(AUTO_UNLOCK_DATE.intValue() / 1000);
  private static final Integer DEFAULT_PASS_ERROR_COUNT = Integer.valueOf(5);
  private static final Integer DEFAULT_AUTO_UNLOCK_DATE = Integer.valueOf(150000);
  public static final String UNLOCK_TYPE_1 = "1";
  public static final String UNLOCK_TYPE_2 = "2";
  
  public static FbpEmployees updateLockUser(String paramString)
  {
    IFbpEmployeeDS localIFbpEmployeeDS = (IFbpEmployeeDS)SSBBus.findDomainService("fbpEmployeeDS");
    FbpEmployees localFbpEmployees = localIFbpEmployeeDS.getFbpEmployees(paramString);
    localFbpEmployees.setScanPassErrorDate(new Date());
    int i = (localFbpEmployees.getScanPassErrorCount() == null ? 0 : localFbpEmployees.getScanPassErrorCount().intValue()) + 1;
    localFbpEmployees.setScanPassErrorCount(Integer.valueOf(i));
    localIFbpEmployeeDS.updateFbpEmployees(localFbpEmployees);
    return localFbpEmployees;
  }
  
  public static void updateUnlockUser(String paramString1, String paramString2)
  {
    IFbpEmployeeDS localIFbpEmployeeDS = (IFbpEmployeeDS)SSBBus.findDomainService("fbpEmployeeDS");
    FbpEmployees localFbpEmployees = localIFbpEmployeeDS.getFbpEmployees(paramString1);
    Date localDate = localFbpEmployees.getScanPassErrorDate();
    if (localDate == null) {
      return;
    }
    if ("1".equals(paramString2))
    {
      Calendar localCalendar1 = Calendar.getInstance();
      Calendar localCalendar2 = Calendar.getInstance();
      localCalendar2.setTime(localDate);
      if (getSecondsDiff(localCalendar1, localCalendar2).intValue() > AUTO_UNLOCK_DATE.intValue())
      {
        localFbpEmployees.setScanPassErrorCount(Integer.valueOf(0));
        localFbpEmployees.setScanPassErrorDate(null);
        localIFbpEmployeeDS.updateFbpEmployees(localFbpEmployees);
      }
    }
    else if ("2".equals(paramString2))
    {
      localFbpEmployees.setScanPassErrorCount(Integer.valueOf(0));
      localFbpEmployees.setScanPassErrorDate(null);
      localIFbpEmployeeDS.updateFbpEmployees(localFbpEmployees);
    }
  }
  
  public static boolean getUserIsLock(String paramString)
  {
    IFbpEmployeeDS localIFbpEmployeeDS = (IFbpEmployeeDS)SSBBus.findDomainService("fbpEmployeeDS");
    FbpEmployees localFbpEmployees = localIFbpEmployeeDS.getFbpEmployees(paramString);
    Integer localInteger = Integer.valueOf(localFbpEmployees.getScanPassErrorCount() == null ? 0 : localFbpEmployees.getScanPassErrorCount().intValue());
    return localInteger.intValue() >= PASS_ERROR_COUNT.intValue();
  }
  
  public static Object[] getLockInfo(String paramString)
  {
    Object[] arrayOfObject = new Object[3];
    IFbpEmployeeDS localIFbpEmployeeDS = (IFbpEmployeeDS)SSBBus.findDomainService("fbpEmployeeDS");
    FbpEmployees localFbpEmployees = localIFbpEmployeeDS.getFbpEmployees(paramString);
    Date localDate = localFbpEmployees.getScanPassErrorDate();
    Integer localInteger = Integer.valueOf(localFbpEmployees.getScanPassErrorCount() == null ? 0 : localFbpEmployees.getScanPassErrorCount().intValue());
    arrayOfObject[0] = localInteger;
    arrayOfObject[2] = PASS_ERROR_COUNT;
    if (localDate == null)
    {
      arrayOfObject[1] = Integer.valueOf(0);
      return arrayOfObject;
    }
    Calendar localCalendar1 = Calendar.getInstance();
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTime(localDate);
    arrayOfObject[1] = Integer.valueOf(AUTO_UNLOCK_DATE.intValue() - getSecondsDiff(localCalendar1, localCalendar2).intValue());
    return arrayOfObject;
  }
  
  private static Long getSecondsDiff(Calendar paramCalendar1, Calendar paramCalendar2)
  {
    Calendar localCalendar2 = (Calendar)paramCalendar2.clone();
    Calendar localCalendar1 = (Calendar)paramCalendar1.clone();
    long l = localCalendar1.getTimeInMillis() - localCalendar2.getTimeInMillis();
    return Long.valueOf(l / 1000L);
  }
  
  static
  {
    if (PASS_ERROR_COUNT == null) {
      try
      {
        PASS_ERROR_COUNT = Integer.valueOf(AccessPropertiesFile.getValue("PASS_ERROR_COUNT"));
      }
      catch (Exception localException1)
      {
        PASS_ERROR_COUNT = DEFAULT_PASS_ERROR_COUNT;
      }
    }
    if (AUTO_UNLOCK_DATE == null) {
      try
      {
        AUTO_UNLOCK_DATE = Integer.valueOf(AccessPropertiesFile.getValue("AUTO_UNLOCK_DATE"));
      }
      catch (Exception localException2)
      {
        AUTO_UNLOCK_DATE = DEFAULT_AUTO_UNLOCK_DATE;
      }
    }
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.service.PasswordStrategyUtil
 * JD-Core Version:    0.7.0.1
 */