package com.zte.eas.infomap.business.notice.service;

import com.zte.eas.infomap.business.notice.model.FbpNoticesNew;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;
import java.util.Iterator;
import java.util.List;

public class NoticeManager
  implements INoticeManager
{
  private ICustomNoticeFilter customNoticeFilter;
  private INoticeFilter noticeFilter;
  private List<INoticeHandler> noticeHandlers;
  private List<INoticReceiver> noticReceivers;
  private String OPEN = "1";
  private String SHUT = "0";
  private String SMS = "1";
  private String EMAIL = "2";
  private String OATASK = "3";
  Log log = SSBBus.getLog(NoticeManager.class);
  
  public void sendNotice(FbpNoticesNew paramFbpNoticesNew)
  {
    try
    {
      if (this.noticeFilter == null) {
        this.noticeFilter = ((INoticeFilter)SSBBus.findDomainService("noticeFilter"));
      }
      String str1 = this.noticeFilter.doFilter(paramFbpNoticesNew);
      String str2 = "";
      if (paramFbpNoticesNew == null) {
        return;
      }
      INoticeHandler localINoticeHandler = null;
      if (this.SMS.equals(paramFbpNoticesNew.getNoticeType())) {
        localINoticeHandler = (INoticeHandler)SSBBus.findDomainService("smsNoticeHandler");
      } else if (this.EMAIL.equals(paramFbpNoticesNew.getNoticeType())) {
        localINoticeHandler = (INoticeHandler)SSBBus.findDomainService("emailNoticeHandler");
      }
      if (localINoticeHandler != null) {
        localINoticeHandler.diposeNotice(str1, paramFbpNoticesNew);
      }
    }
    catch (Exception localException)
    {
      this.log.error("NoticeManager==>sendNotice");
      this.log.error(localException.getMessage(), localException);
    }
  }
  
  public void receiveNotice(String paramString)
    throws Exception
  {
    Iterator localIterator = this.noticReceivers.iterator();
    while (localIterator.hasNext())
    {
      INoticReceiver localINoticReceiver = (INoticReceiver)localIterator.next();
      localINoticReceiver.doReceive(paramString);
    }
  }
  
  public void setCustomNoticeFilter(ICustomNoticeFilter paramICustomNoticeFilter)
  {
    this.customNoticeFilter = paramICustomNoticeFilter;
  }
  
  public void setNoticeFilter(INoticeFilter paramINoticeFilter)
  {
    this.noticeFilter = paramINoticeFilter;
  }
  
  public ICustomNoticeFilter getCustomNoticeFilter()
  {
    return this.customNoticeFilter;
  }
  
  public INoticeFilter getNoticeFilter()
  {
    return this.noticeFilter;
  }
  
  public List<INoticeHandler> getNoticeHandlers()
  {
    return this.noticeHandlers;
  }
  
  public void setNoticeHandlers(List<INoticeHandler> paramList)
  {
    this.noticeHandlers = paramList;
  }
  
  public List<INoticReceiver> getNoticReceivers()
  {
    return this.noticReceivers;
  }
  
  public void setNoticReceivers(List<INoticReceiver> paramList)
  {
    this.noticReceivers = paramList;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.infomap.business.notice.service.NoticeManager
 * JD-Core Version:    0.7.0.1
 */