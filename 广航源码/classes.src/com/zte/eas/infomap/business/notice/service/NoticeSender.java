package com.zte.eas.infomap.business.notice.service;

import com.zte.eas.infomap.business.notice.model.FbpNoticesNew;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.BaseDomainService;
import com.zte.ssb.framework.common.log.Log;
import java.util.Date;
import java.util.List;

public class NoticeSender
  extends BaseDomainService
  implements INoticeSender
{
  Log log = SSBBus.getLog(NoticeSender.class);
  private static boolean isWorking = false;
  private static boolean pwWorking = false;
  private static boolean personWorking = false;
  private static boolean approveWorking = false;
  private static boolean erpApproveWorking = false;
  
  public void sendNotices()
  {
    this.log.error("... send notices start");
    long l = 0L;
    try
    {
      synchronized (this)
      {
        if (isWorking)
        {
          this.log.error("Notice Sender is Working..... return!!!");
          return;
        }
      }
      ??? = (IFbpNoticesNewDS)SSBBus.findDomainService("fbpNoticesNewDS");
      List localList = ((IFbpNoticesNewDS)???).findFbpNoticesNews();
      this.log.error("...fbpNoticesNewDS.findFbpNoticesNews() OK");
      INoticeManager localINoticeManager = (INoticeManager)SSBBus.findDomainService("noticeManager");
      int i = localList.size();
      for (int j = 0; j < i; j++)
      {
        this.log.error("... sending (" + (j + 1) + "/" + i + ")");
        this.log.error("... sending id: " + ((FbpNoticesNew)localList.get(j)).getId());
        FbpNoticesNew localFbpNoticesNew = (FbpNoticesNew)localList.get(j);
        localINoticeManager.sendNotice(localFbpNoticesNew);
      }
    }
    catch (Exception localException)
    {
      isWorking = false;
      this.log.error("... send notices error:" + localException.getMessage(), localException);
    }
    finally
    {
      isWorking = false;
    }
    isWorking = false;
    this.log.error("... send notices finished!");
  }
  
  public String testsendNotices()
  {
    IFbpNoticesNewDS localIFbpNoticesNewDS = (IFbpNoticesNewDS)SSBBus.findDomainService("fbpNoticesNewDS");
    List localList = localIFbpNoticesNewDS.findFbpNoticesNews();
    int i = localList.size();
    Date localDate = new Date();
    String str = String.valueOf(localDate.getYear()) + String.valueOf(localDate.getMonth()) + String.valueOf(localDate.getDate()) + String.valueOf(localDate.getHours()) + String.valueOf(localDate.getMinutes());
    for (int j = 0; j < i; j++)
    {
      FbpNoticesNew localFbpNoticesNew = (FbpNoticesNew)localList.get(j);
      localFbpNoticesNew.setAttribute5(str);
    }
    localIFbpNoticesNewDS.updateFbpNoticesNews(localList);
    sendNotices();
    return str;
  }
  
  public void sendPasswordNotices()
  {
    this.log.error("... sendPasswordNotices start");
    long l = 0L;
    try
    {
      synchronized (this)
      {
        if (pwWorking)
        {
          this.log.error("sendPasswordNotices is Working..... return!!!");
          return;
        }
      }
      ??? = (IFbpNoticesNewDS)SSBBus.findDomainService("fbpNoticesNewDS");
      List localList = ((IFbpNoticesNewDS)???).findFbpNoticesNewsPw();
      this.log.error("...fbpNoticesNewDS.findFbpNoticesNewsPw() OK");
      INoticeManager localINoticeManager = (INoticeManager)SSBBus.findDomainService("noticeManagerDS");
      int i = localList.size();
      for (int j = 0; j < i; j++)
      {
        this.log.error("... sendPasswordNotices (" + (j + 1) + "/" + i + ")");
        this.log.error("... sendPasswordNotices id: " + ((FbpNoticesNew)localList.get(j)).getId());
        FbpNoticesNew localFbpNoticesNew = (FbpNoticesNew)localList.get(j);
        localINoticeManager.sendNotice(localFbpNoticesNew);
      }
    }
    catch (Exception localException)
    {
      pwWorking = false;
      this.log.error("... sendPasswordNotices error:" + localException.getMessage(), localException);
    }
    finally
    {
      pwWorking = false;
    }
    pwWorking = false;
    this.log.error("... sendPasswordNotices finished!");
  }
  
  public void sendPersonNotices()
  {
    this.log.error("... sendPersonNotices start");
    long l = 0L;
    try
    {
      synchronized (this)
      {
        if (personWorking)
        {
          this.log.error("sendPersonNotices is Working..... return!!!");
          return;
        }
      }
      ??? = (IFbpNoticesNewDS)SSBBus.findDomainService("fbpNoticesNewDS");
      List localList = ((IFbpNoticesNewDS)???).findFbpNoticesNewsPerson();
      this.log.error("...fbpNoticesNewDS.findFbpNoticesNewsPerson() OK");
      INoticeManager localINoticeManager = (INoticeManager)SSBBus.findDomainService("noticeManagerDS");
      int i = localList.size();
      for (int j = 0; j < i; j++)
      {
        this.log.error("... sendPersonNotices (" + (j + 1) + "/" + i + ")");
        this.log.error("... sendPersonNotices id: " + ((FbpNoticesNew)localList.get(j)).getId());
        FbpNoticesNew localFbpNoticesNew = (FbpNoticesNew)localList.get(j);
        localINoticeManager.sendNotice(localFbpNoticesNew);
      }
    }
    catch (Exception localException)
    {
      personWorking = false;
      this.log.error("... sendPersonNotices error:" + localException.getMessage(), localException);
    }
    finally
    {
      personWorking = false;
    }
    personWorking = false;
    this.log.error("... sendPersonNotices finished!");
  }
  
  public void sendApproveNotices()
  {
    this.log.error("... sendApproveNotices start");
    try
    {
      synchronized (this)
      {
        if (approveWorking)
        {
          this.log.error("sendApproveNotices is Working..... return!!!");
          return;
        }
      }
      ??? = (IFbpNoticesNewDS)SSBBus.findDomainService("fbpNoticesNewDS");
      List localList = ((IFbpNoticesNewDS)???).findFbpNoticesNewsApprove();
      this.log.error("...fbpNoticesNewDS.findFbpNoticesNewsApprove() OK");
      INoticeManager localINoticeManager = (INoticeManager)SSBBus.findDomainService("noticeManagerDS");
      int i = localList.size();
      for (int j = 0; j < i; j++)
      {
        this.log.error("... sendApproveNotices (" + (j + 1) + "/" + i + ")");
        this.log.error("... sendApproveNotices id: " + ((FbpNoticesNew)localList.get(j)).getId());
        FbpNoticesNew localFbpNoticesNew = (FbpNoticesNew)localList.get(j);
        localINoticeManager.sendNotice(localFbpNoticesNew);
      }
    }
    catch (Exception localException)
    {
      approveWorking = false;
      this.log.error("... sendApproveNotices error:" + localException.getMessage(), localException);
    }
    finally
    {
      approveWorking = false;
    }
    approveWorking = false;
    this.log.error("... sendApproveNotices finished!");
  }
  
  public void sendFbpNoticesNewsErpImpError() {}
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.infomap.business.notice.service.NoticeSender
 * JD-Core Version:    0.7.0.1
 */