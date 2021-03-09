package com.zte.eimage.access.baseconfig.dao;

import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.eimage.business.baseconfig.model.FbpVoucherBorrowV;
import com.zte.evs.ebill.common.EvsObjectUtils;
import com.zte.evs.ebill.model.archives.FbpArchivesHeaders;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.util.Util;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FbpVoucherBorrowVDAO
  extends BaseDAO
  implements IFbpVoucherBorrowVDAO
{
  public Object getFbpVoucherBorrowV(Long paramLong)
  {
    return (FbpArchivesHeaders)super.getObject(FbpArchivesHeaders.class, paramLong);
  }
  
  public List<FbpVoucherBorrowV> getFbpVoucherBorrowVs()
  {
    return super.getObjects(FbpVoucherBorrowV.class);
  }
  
  public PageInfo getFbpVoucherBorrowVs(FbpVoucherBorrowV paramFbpVoucherBorrowV, int paramInt1, int paramInt2)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    BigInteger localBigInteger = localEasUserInfo.getUserInfoPk();
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList();
    localStringBuffer.append(" from FbpVoucherBorrowV fv where 1=1");
    if ("Y".equals(paramFbpVoucherBorrowV.getCheckFlags()))
    {
      if (!Util.isNullObject(paramFbpVoucherBorrowV.getApplyNum()))
      {
        localStringBuffer.append(" and fv.applyNum like ?");
        localArrayList.add("%" + paramFbpVoucherBorrowV.getApplyNum() + "%");
      }
      if (!Util.isNullObject(paramFbpVoucherBorrowV.getApplyNumEnd()))
      {
        localStringBuffer.append(" and fv.applyNum like ?");
        localArrayList.add("%" + paramFbpVoucherBorrowV.getApplyNumEnd() + "%");
      }
    }
    else
    {
      if (!Util.isNullObject(paramFbpVoucherBorrowV.getApplyNum()))
      {
        localStringBuffer.append(" and fv.applyNum >= ?");
        localArrayList.add(paramFbpVoucherBorrowV.getApplyNum());
      }
      if (!Util.isNullObject(paramFbpVoucherBorrowV.getApplyNumEnd()))
      {
        localStringBuffer.append(" and fv.applyNum <= ?");
        localArrayList.add(paramFbpVoucherBorrowV.getApplyNumEnd());
      }
    }
    if (!Util.isNullObject(paramFbpVoucherBorrowV.getAttribute1()))
    {
      localStringBuffer.append(" and fv.attribute1 = ?");
      localArrayList.add(paramFbpVoucherBorrowV.getAttribute1());
    }
    if (!Util.isNullObject(paramFbpVoucherBorrowV.getCompanyId()))
    {
      localStringBuffer.append(" and fv.companyId = ?");
      localArrayList.add(paramFbpVoucherBorrowV.getCompanyId());
    }
    if (!Util.isNullObject(paramFbpVoucherBorrowV.getUseDate()))
    {
      localStringBuffer.append(" and fv.useDate >= ?");
      localArrayList.add(clearTime(paramFbpVoucherBorrowV.getUseDate()));
    }
    if (!Util.isNullObject(paramFbpVoucherBorrowV.getUseDateEnd()))
    {
      localStringBuffer.append(" and fv.useDate < ?");
      localArrayList.add(clearTime(addDay(paramFbpVoucherBorrowV.getUseDateEnd(), 1)));
    }
    if (!Util.isNullObject(paramFbpVoucherBorrowV.getGiveBackDate()))
    {
      localStringBuffer.append(" and fv.giveBackDate >= ?");
      localArrayList.add(clearTime(paramFbpVoucherBorrowV.getGiveBackDate()));
    }
    if (!Util.isNullObject(paramFbpVoucherBorrowV.getApplyDate()))
    {
      localStringBuffer.append(" and fv.applyDate >= ?");
      localArrayList.add(clearTime(paramFbpVoucherBorrowV.getApplyDate()));
    }
    if (!Util.isNullObject(paramFbpVoucherBorrowV.getApplyDateEnd()))
    {
      localStringBuffer.append(" and fv.applyDate <= ?");
      localArrayList.add(clearTime(paramFbpVoucherBorrowV.getApplyDateEnd()));
    }
    if (!Util.isNullObject(paramFbpVoucherBorrowV.getGiveBackDateEnd()))
    {
      localStringBuffer.append(" and fv.giveBackDate < ?");
      localArrayList.add(clearTime(addDay(paramFbpVoucherBorrowV.getGiveBackDateEnd(), 1)));
    }
    localStringBuffer.append(" and fv.employeeId = ? order by fv.applyDate DESC");
    localArrayList.add(Long.valueOf(Long.parseLong(localBigInteger.toString())));
    paramInt1 = paramInt1 / paramInt2 + 1;
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1, paramInt2, localArrayList.toArray());
    return localPageInfo;
  }
  
  public PageInfo findFbpVoucherBorrowVs(FbpVoucherBorrowV paramFbpVoucherBorrowV, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList();
    localStringBuffer.append(" from FbpVoucherBorrowV fv where 1=1");
    if ("Y".equals(paramFbpVoucherBorrowV.getCheckFlags()))
    {
      if (!Util.isNullObject(paramFbpVoucherBorrowV.getApplyNum()))
      {
        localStringBuffer.append(" and fv.applyNum like ?");
        localArrayList.add("%" + paramFbpVoucherBorrowV.getApplyNum() + "%");
      }
      if (!Util.isNullObject(paramFbpVoucherBorrowV.getApplyNumEnd()))
      {
        localStringBuffer.append(" and fv.applyNum like ?");
        localArrayList.add("%" + paramFbpVoucherBorrowV.getApplyNumEnd() + "%");
      }
    }
    else
    {
      if (!Util.isNullObject(paramFbpVoucherBorrowV.getApplyNum()))
      {
        localStringBuffer.append(" and fv.applyNum >= ?");
        localArrayList.add(paramFbpVoucherBorrowV.getApplyNum());
      }
      if (!Util.isNullObject(paramFbpVoucherBorrowV.getApplyNumEnd()))
      {
        localStringBuffer.append(" and fv.applyNum <= ?");
        localArrayList.add(paramFbpVoucherBorrowV.getApplyNumEnd());
      }
    }
    if (!Util.isNullObject(paramFbpVoucherBorrowV.getEmployeeId()))
    {
      localStringBuffer.append(" and fv.employeeId = ?");
      localArrayList.add(paramFbpVoucherBorrowV.getEmployeeId());
    }
    if (!Util.isNullObject(paramFbpVoucherBorrowV.getCompanyId()))
    {
      localStringBuffer.append(" and fv.companyId = ?");
      localArrayList.add(paramFbpVoucherBorrowV.getCompanyId());
    }
    if (!Util.isNullObject(paramFbpVoucherBorrowV.getUseDate()))
    {
      localStringBuffer.append(" and fv.useDate >= ?");
      localArrayList.add(clearTime(paramFbpVoucherBorrowV.getUseDate()));
    }
    if (!Util.isNullObject(paramFbpVoucherBorrowV.getUseDateEnd()))
    {
      localStringBuffer.append(" and fv.useDate < ?");
      localArrayList.add(clearTime(addDay(paramFbpVoucherBorrowV.getUseDateEnd(), 1)));
    }
    if (!Util.isNullObject(paramFbpVoucherBorrowV.getGiveBackDate()))
    {
      localStringBuffer.append(" and fv.giveBackDate >= ?");
      localArrayList.add(clearTime(paramFbpVoucherBorrowV.getGiveBackDate()));
    }
    if (!Util.isNullObject(paramFbpVoucherBorrowV.getGiveBackDateEnd()))
    {
      localStringBuffer.append(" and fv.giveBackDate < ?");
      localArrayList.add(clearTime(addDay(paramFbpVoucherBorrowV.getGiveBackDateEnd(), 1)));
    }
    localStringBuffer.append(" and fv.archivesStatus in ('ARCHIVES_ALREADY_APPROVE','ARCHIVES_BORROWING') and fv.attribute1 = 'N'");
    localStringBuffer.append(" order by fv.giveBackDate asc");
    paramInt1 = paramInt1 / paramInt2 + 1;
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1, paramInt2, localArrayList.toArray());
    return localPageInfo;
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpVoucherBorrowV(FbpVoucherBorrowV paramFbpVoucherBorrowV)
  {
    super.removeObject(paramFbpVoucherBorrowV);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertFbpVoucherBorrowV(FbpVoucherBorrowV paramFbpVoucherBorrowV)
  {
    super.insertObject(paramFbpVoucherBorrowV);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateFbpVoucherBorrowV(FbpArchivesHeaders paramFbpArchivesHeaders)
  {
    super.updateObject(paramFbpArchivesHeaders);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertFbpVoucherBorrowVs(List<FbpVoucherBorrowV> paramList)
  {
    super.insertObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpVoucherBorrowVs(List<FbpVoucherBorrowV> paramList)
  {
    super.removeObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateFbpVoucherBorrowVs(List<FbpArchivesHeaders> paramList)
  {
    super.updateObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpVoucherBorrowV(Long paramLong)
  {
    super.removeObject(FbpVoucherBorrowV.class, paramLong);
  }
  
  public void removeFbpVoucherBorrowV() {}
  
  public Date clearTime(Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    int i = localCalendar.get(1);
    int j = localCalendar.get(2);
    int k = localCalendar.get(5);
    localCalendar.clear();
    localCalendar.set(1, i);
    localCalendar.set(2, j);
    localCalendar.set(5, k);
    return localCalendar.getTime();
  }
  
  public static Date addDay(Date paramDate, int paramInt)
  {
    if (paramDate == null) {
      return null;
    }
    if (paramInt == 0) {
      return paramDate;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    localCalendar.add(5, paramInt);
    return localCalendar.getTime();
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.access.baseconfig.dao.FbpVoucherBorrowVDAO
 * JD-Core Version:    0.7.0.1
 */