package com.zte.eas.appframe.access.synrequest.dao;

import com.zte.eimage.business.baseconfig.service.IImageCommonDS;
import com.zte.ssb.framework.SSBBus;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;

public class SyncVoucherThread
  extends Thread
{
  private Date lastRunDate;
  private Long synchRequestId;
  private Logger logger = Logger.getLogger(getClass());
  
  public void run()
  {
    try
    {
      IFbpSynchRequestsDAO localIFbpSynchRequestsDAO = (IFbpSynchRequestsDAO)SSBBus.findDomainService("fbpSynchRequestsDAO");
      boolean bool = localIFbpSynchRequestsDAO.syncVoucher(this.lastRunDate);
      if (!bool) {
        throw new Exception("同步凭证失败!");
      }
    }
    catch (Exception localException)
    {
      this.logger.error(localException.getMessage(), localException);
      String str = "update fbp.fbp_synch_requests set Last_Run_Time=?,Attribute4=? where synch_Request_Id = ?";
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.lastRunDate);
      localArrayList.add("运行失败!");
      localArrayList.add(this.synchRequestId);
      IImageCommonDS localIImageCommonDS = (IImageCommonDS)SSBBus.findDomainService("imageCommonDS");
      localIImageCommonDS.executeSql(str, localArrayList);
    }
  }
  
  public Date getLastRunDate()
  {
    return this.lastRunDate;
  }
  
  public void setLastRunDate(Date paramDate)
  {
    this.lastRunDate = paramDate;
  }
  
  public Long getSynchRequestId()
  {
    return this.synchRequestId;
  }
  
  public void setSynchRequestId(Long paramLong)
  {
    this.synchRequestId = paramLong;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.access.synrequest.dao.SyncVoucherThread
 * JD-Core Version:    0.7.0.1
 */