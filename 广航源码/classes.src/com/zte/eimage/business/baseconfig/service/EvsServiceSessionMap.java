package com.zte.eimage.business.baseconfig.service;

import com.zte.eimage.access.common.dao.IFbploginsDAO;
import com.zte.eimage.business.common.model.Fbplogins;
import com.zte.ssb.AccessPropertiesFile;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.util.Util;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.apache.axis.session.Session;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class EvsServiceSessionMap
{
  private static int outTime = 0;
  private static int defaultOutTime = 1800000;
  public static final String USER_NUMBER = "USER_NUMBER";
  public static final String USER_ID = "USER_ID";
  public static final String USER_PWD = "USER_PWD";
  public static final String REQUEST_TIME = "REQUEST_TIME";
  public static final String SESSION_ID = "SESSION_ID";
  public static final Long APP_ID = Long.valueOf(123456789L);
  static Log log = LogFactory.getLog(EvsServiceSessionMap.class);
  static IFbploginsDAO loginDao = (IFbploginsDAO)SSBBus.findDaoService("fbploginsDAO");
  
  public static boolean checkUeryIsLogin(String paramString)
  {
    Fbplogins localFbplogins = loginDao.getFbplogins(paramString);
    if (localFbplogins != null)
    {
      if (!isOutTime(localFbplogins.getActiveTime(), outTime)) {
        return true;
      }
      localFbplogins.setLogoutTime(new Date());
      loginDao.updateFbplogins(localFbplogins);
    }
    return false;
  }
  
  public static Fbplogins getFbplogins(String paramString)
  {
    Fbplogins localFbplogins = loginDao.getFbplogins(paramString);
    return localFbplogins;
  }
  
  public static Fbplogins getLoginInfo(String paramString)
  {
    if (!Util.isStrEmpty(paramString))
    {
      Long localLong = Long.valueOf(paramString);
      Date localDate = new Date();
      Fbplogins localFbplogins = loginDao.getFbplogins(BigInteger.valueOf(localLong.longValue()));
      if (localFbplogins == null) {
        return null;
      }
      if (localFbplogins.getLogoutTime() != null) {
        return null;
      }
      if (!isOutTime(localFbplogins.getActiveTime(), outTime))
      {
        localFbplogins.setActiveTime(localDate);
        loginDao.updateFbplogins(localFbplogins);
        return localFbplogins;
      }
      localFbplogins.setLogoutTime(new Date());
      loginDao.updateFbplogins(localFbplogins);
    }
    return null;
  }
  
  public static Session removeSessionByKey(String paramString)
  {
    if (!Util.isStrEmpty(paramString))
    {
      Long localLong = Long.valueOf(paramString);
      Date localDate = new Date();
      Fbplogins localFbplogins = loginDao.getFbplogins(BigInteger.valueOf(localLong.longValue()));
      if (localFbplogins == null) {
        return null;
      }
      localFbplogins.setLogoutTime(localDate);
      loginDao.updateFbplogins(localFbplogins);
    }
    return null;
  }
  
  public static Fbplogins addLogin(Fbplogins paramFbplogins)
  {
    loginDao.insertObject(paramFbplogins);
    return paramFbplogins;
  }
  
  public static boolean isOutTime(Date paramDate, int paramInt)
  {
    Date localDate = new Date();
    GregorianCalendar localGregorianCalendar1 = new GregorianCalendar();
    localGregorianCalendar1.setTime(localDate);
    try
    {
      GregorianCalendar localGregorianCalendar2 = new GregorianCalendar();
      localGregorianCalendar2.setTime(paramDate);
      if (localGregorianCalendar1.get(1) != localGregorianCalendar2.get(1)) {
        return true;
      }
      if (localGregorianCalendar1.get(2) != localGregorianCalendar2.get(2)) {
        return true;
      }
      if (localGregorianCalendar1.get(5) != localGregorianCalendar2.get(5)) {
        return true;
      }
      int i = localGregorianCalendar1.get(11) - localGregorianCalendar2.get(11);
      int j = localGregorianCalendar1.get(12) - localGregorianCalendar2.get(12);
      int k = localGregorianCalendar1.get(13) - localGregorianCalendar2.get(13);
      int m = localGregorianCalendar1.get(14) - localGregorianCalendar2.get(14);
      int n = i * 60 * 60 * 1000 + j * 60000 + k * 1000 + m;
      if (n > paramInt) {
        return true;
      }
    }
    catch (Exception localException)
    {
      log.error(localException.getMessage(), localException);
      return true;
    }
    return false;
  }
  
  static
  {
    if (outTime == 0)
    {
      String str = AccessPropertiesFile.getValue("outTime");
      if ((str == null) || (str.trim().length() == 0)) {
        outTime = defaultOutTime;
      } else {
        try
        {
          outTime = Integer.parseInt(str);
        }
        catch (Exception localException)
        {
          outTime = defaultOutTime;
        }
      }
    }
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.service.EvsServiceSessionMap
 * JD-Core Version:    0.7.0.1
 */