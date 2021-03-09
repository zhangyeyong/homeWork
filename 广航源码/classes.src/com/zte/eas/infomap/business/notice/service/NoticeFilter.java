package com.zte.eas.infomap.business.notice.service;

import com.zte.eas.appframe.business.util.ObjectCopyUtils;
import com.zte.eas.infomap.business.notice.model.FbpNoticesNew;
import com.zte.eas.organization.access.employeemanage.dao.IFbpEmployeesVDAO;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesV;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Calendar;

public class NoticeFilter
  implements INoticeFilter
{
  Log log = SSBBus.getLog(NoticeFilter.class);
  private IFbpEmployeesVDAO fbpEmployeesVDAO;
  private static final String SMS = "SMS";
  private static final String EMAIL = "EMAIL";
  private static final String OA = "OA";
  
  public static void main(String[] paramArrayOfString)
  {
    Calendar localCalendar = Calendar.getInstance();
    System.out.println(localCalendar.get(7) - 1);
    System.out.println(localCalendar.get(10));
    System.out.println(localCalendar.get(11));
    System.out.println(localCalendar.get(12));
  }
  
  public String doFilter(FbpNoticesNew paramFbpNoticesNew)
  {
    FbpEmployeesV localFbpEmployeesV = null;
    try
    {
      System.out.println("Start NoticeFilter ==> doFilter");
      String str1 = "{oatask}{email}{sms}";
      String str2 = "";
      String str3 = "";
      int i = 0;
      int j = 0;
      int k = 0;
      int m = 0;
      int n = 0;
      int i1 = 0;
      String str4 = paramFbpNoticesNew.getToUserId();
      String str5 = paramFbpNoticesNew.getNoticeType();
      Calendar localCalendar = Calendar.getInstance();
      int i2 = localCalendar.get(7) - 1;
      n = localCalendar.get(11);
      i1 = localCalendar.get(12);
      localFbpEmployeesV = this.fbpEmployeesVDAO.findEmployeesById(new BigInteger(str4));
      if (null != str5)
      {
        if ("2".equals(str5))
        {
          if ((null == localFbpEmployeesV.getUseEmailFlag()) || ("N".equals(localFbpEmployeesV.getUseEmailFlag()))) {
            return str1;
          }
          return "{sms}{oatask}";
        }
        if ("3".equals(str5)) {
          return "{sms}{email}";
        }
        if ("1".equals(str5))
        {
          if ((localFbpEmployeesV != null) && (!localFbpEmployeesV.equals("")))
          {
            if ((null == localFbpEmployeesV.getMonNoticeFlag()) || ("N".equals(localFbpEmployeesV.getMonNoticeFlag()))) {
              str3 = str3 + "{1}";
            }
            if ((null == localFbpEmployeesV.getTueNoticeFlag()) || ("N".equals(localFbpEmployeesV.getTueNoticeFlag()))) {
              str3 = str3 + "{2}";
            }
            if ((null == localFbpEmployeesV.getWedNoticeFlag()) || ("N".equals(localFbpEmployeesV.getWedNoticeFlag()))) {
              str3 = str3 + "{3}";
            }
            if ((null == localFbpEmployeesV.getThuNoticeFlag()) || ("N".equals(localFbpEmployeesV.getThuNoticeFlag()))) {
              str3 = str3 + "{4}";
            }
            if ((null == localFbpEmployeesV.getFriNoticeFlag()) || ("N".equals(localFbpEmployeesV.getFriNoticeFlag()))) {
              str3 = str3 + "{5}";
            }
            if ((null == localFbpEmployeesV.getSatNoticeFlag()) || ("N".equals(localFbpEmployeesV.getSatNoticeFlag()))) {
              str3 = str3 + "{6}";
            }
            if ((null == localFbpEmployeesV.getSunNoticeFlag()) || ("N".equals(localFbpEmployeesV.getSunNoticeFlag()))) {
              str3 = str3 + "{0}";
            }
          }
          else
          {
            return "{oatask}{email}";
          }
          if (str3.indexOf("{" + i2 + "}") != -1)
          {
            paramFbpNoticesNew.setStatus(Integer.valueOf(-1));
            paramFbpNoticesNew.setmemo("-1:未定制该日期");
            updateFbpNotice(paramFbpNoticesNew);
            return str1;
          }
          i = localFbpEmployeesV.getStartHour().intValue();
          j = localFbpEmployeesV.getStartMin().intValue();
          k = localFbpEmployeesV.getEndHour().intValue();
          m = localFbpEmployeesV.getEndMin().intValue();
          if ((n < i) || (n > k)) {
            str2 = str1;
          }
          if ((n == i) && (i1 < j)) {
            str2 = str1;
          }
          if ((n == k) && (i1 > m)) {
            str2 = str1;
          }
          if (str2.equals(str1)) {
            return str1;
          }
          return "{oatask}{email}";
        }
      }
      return str1;
    }
    catch (Exception localException)
    {
      System.out.println("END NoticeFilter ==> doFilter");
      localException.printStackTrace();
      paramFbpNoticesNew.setStatus(Integer.valueOf(-1));
      paramFbpNoticesNew.setmemo("-1:过滤时出现异常");
      updateFbpNotice(paramFbpNoticesNew);
      this.log.error("NoticeFilter:empV:" + localFbpEmployeesV);
      this.log.error(paramFbpNoticesNew);
      this.log.error(localException.getStackTrace());
    }
    return "{oatask}{email}{sms}";
  }
  
  private void updateFbpNotice(FbpNoticesNew paramFbpNoticesNew)
  {
    IFbpNoticesNewDS localIFbpNoticesNewDS = (IFbpNoticesNewDS)SSBBus.findDomainService("fbpNoticesNewDS");
    FbpNoticesNew localFbpNoticesNew = new FbpNoticesNew();
    ObjectCopyUtils.copy(paramFbpNoticesNew, localFbpNoticesNew);
    localIFbpNoticesNewDS.updateFbpNoticesNew(localFbpNoticesNew);
  }
  
  public IFbpEmployeesVDAO getFbpEmployeesVDAO()
  {
    return this.fbpEmployeesVDAO;
  }
  
  public void setFbpEmployeesVDAO(IFbpEmployeesVDAO paramIFbpEmployeesVDAO)
  {
    this.fbpEmployeesVDAO = paramIFbpEmployeesVDAO;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.infomap.business.notice.service.NoticeFilter
 * JD-Core Version:    0.7.0.1
 */