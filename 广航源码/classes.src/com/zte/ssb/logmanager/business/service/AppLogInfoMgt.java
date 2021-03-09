package com.zte.ssb.logmanager.business.service;

import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.container.SSBConfig;
import com.zte.ssb.framework.common.queue.IQueue;
import com.zte.ssb.framework.common.queue.IQueueFactory;
import com.zte.ssb.framework.util.Util;
import com.zte.ssb.logmanager.access.dao.IAppLogMgtDA;
import com.zte.ssb.logmanager.business.model.AppLogInfoEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class AppLogInfoMgt
  implements IAppLogInfoMgt
{
  IQueue q = SSBBus.getQueueFactory().createQueue("queueName", AppLogInfoEntity.class, false, SSBConfig.getQueueCacheDir());
  public static List logList = new Vector();
  private static final String logName = "queueName";
  private IAppLogMgtDA dao;
  public static int count = 0;
  
  public void setAppLogMgtDA(IAppLogMgtDA paramIAppLogMgtDA)
  {
    this.dao = paramIAppLogMgtDA;
  }
  
  public boolean writeLog(AppLogInfoEntity paramAppLogInfoEntity)
  {
    try
    {
      synchronized (this.dao)
      {
        this.dao.insertObject(paramAppLogInfoEntity);
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return true;
  }
  
  public synchronized void saveToDB()
  {
    try
    {
      while (this.q.getFirst() != null) {
        synchronized (this.dao)
        {
          logList.add((AppLogInfoEntity)this.q.remove());
          this.dao.writeLog(logList);
          logList.clear();
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public TableDataInfo getAppLogList(AppLogInfoEntity paramAppLogInfoEntity, String paramString1, String paramString2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("from AppLogInfoEntity a where 1=1 ");
    ArrayList localArrayList = new ArrayList();
    if ((!"".equals(paramAppLogInfoEntity.getUserName())) && (null != paramAppLogInfoEntity.getUserName()))
    {
      localStringBuffer.append("and a.userName like ? ");
      localArrayList.add("%" + paramAppLogInfoEntity.getUserName().trim() + "%");
    }
    if ((!"".equals(paramAppLogInfoEntity.getUserId())) && (null != paramAppLogInfoEntity.getUserId()))
    {
      localStringBuffer.append("and a.userId like ? ");
      localArrayList.add("%" + paramAppLogInfoEntity.getUserId().trim() + "%");
    }
    if ((!"".equals(paramAppLogInfoEntity.getUserIp())) && (null != paramAppLogInfoEntity.getUserIp()))
    {
      localStringBuffer.append("and a.userIp like ? ");
      localArrayList.add("%" + paramAppLogInfoEntity.getUserIp().trim() + "%");
    }
    if ((!"".equals(paramAppLogInfoEntity.getOptObject())) && (null != paramAppLogInfoEntity.getOptObject()))
    {
      localStringBuffer.append("and a.optObject like ? ");
      localArrayList.add("%" + paramAppLogInfoEntity.getOptObject().trim() + "%");
    }
    if ((!"".equals(paramAppLogInfoEntity.getOptObjecttype())) && (null != paramAppLogInfoEntity.getOptObjecttype()))
    {
      localStringBuffer.append("and a.optObjecttype like ? ");
      localArrayList.add("%" + paramAppLogInfoEntity.getOptObjecttype().trim() + "%");
    }
    if ((!"".equals(paramAppLogInfoEntity.getOptType())) && (null != paramAppLogInfoEntity.getOptType()))
    {
      localStringBuffer.append("and a.optType like ? ");
      localArrayList.add("%" + paramAppLogInfoEntity.getOptType().trim() + "%");
    }
    if ((!"".equals(paramAppLogInfoEntity.getId())) && (null != paramAppLogInfoEntity.getId()))
    {
      localStringBuffer.append("and a.optDetail like ? ");
      localArrayList.add("%" + paramAppLogInfoEntity.getId().trim() + "%");
    }
    if ((!Util.isStrEmpty(paramAppLogInfoEntity.getStartTime())) && (!Util.isStrEmpty(paramAppLogInfoEntity.getEndTime())))
    {
      localStringBuffer.append("and a.optTime >= ?");
      localStringBuffer.append("and a.optTime <= ?");
      String[] arrayOfString1 = paramAppLogInfoEntity.getStartTime().trim().split("-");
      Date localDate1 = new Date(Integer.parseInt(arrayOfString1[0]) - 1900, Integer.parseInt(arrayOfString1[1]) - 1, Integer.parseInt(arrayOfString1[2]), 0, 0, 0);
      String[] arrayOfString2 = paramAppLogInfoEntity.getEndTime().trim().split("-");
      Date localDate2 = new Date(Integer.parseInt(arrayOfString2[0]) - 1900, Integer.parseInt(arrayOfString2[1]) - 1, Integer.parseInt(arrayOfString2[2]), 23, 59, 59);
      localArrayList.add(localDate1);
      localArrayList.add(localDate2);
    }
    int i = Integer.parseInt(paramString1) / Integer.parseInt(paramString2) + 1;
    return this.dao.getAppLogList(i, Integer.parseInt(paramString2), localStringBuffer.toString(), localArrayList.toArray());
  }
  
  public AppLogInfoEntity getAppLogById(String paramString)
  {
    return this.dao.getAppLogById(paramString);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.ssb.logmanager.business.service.AppLogInfoMgt
 * JD-Core Version:    0.7.0.1
 */