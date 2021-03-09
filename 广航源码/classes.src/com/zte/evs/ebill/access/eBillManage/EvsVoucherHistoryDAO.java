package com.zte.evs.ebill.access.eBillManage;

import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherHistory;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherHistoryModel;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherHistoryV;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.orm.zorm.ZormTemplate;
import com.zte.ssb.zorm.Session;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvsVoucherHistoryDAO
  extends BaseDAO
  implements IEvsVoucherHistoryDAO
{
  public Map findAllHistory(EvsVoucherHistoryModel paramEvsVoucherHistoryModel, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append("from EvsVoucherHistoryV hst where 1=1");
    localStringBuffer.append(" and hst.beginStatus = '" + paramEvsVoucherHistoryModel.getBeginStatus() + "' or hst.beginStatus = '" + paramEvsVoucherHistoryModel.getEndStatus() + "'");
    localStringBuffer.append(" order by hst.handleDate desc");
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1 / paramInt2 + 1, paramInt2, localArrayList.toArray());
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", localPageInfo.getResult());
    return localHashMap;
  }
  
  public Map findHistoryByPackageId(String paramString, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append("from EvsVoucherHistoryV hst where 1=1");
    localStringBuffer.append(" and hst.objectCode = '" + paramString + "'");
    localStringBuffer.append(" and opObjectType = 2");
    localStringBuffer.append(" order by hst.handleDate desc");
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1 / paramInt2 + 1, paramInt2, localArrayList.toArray());
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", localPageInfo.getResult());
    localHashMap.put("totalCount", Long.valueOf(localPageInfo.getTotalCount()));
    return localHashMap;
  }
  
  public Map findHistoryByObjectCode(String paramString, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append("from EvsVoucherHistoryV hst where 1=1");
    localStringBuffer.append(" and hst.objectCode = '" + paramString + "'");
    localStringBuffer.append(" and opObjectType = 1");
    localStringBuffer.append(" order by hst.handleDate desc");
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1 / paramInt2 + 1, paramInt2, localArrayList.toArray());
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", localPageInfo.getResult());
    localHashMap.put("totalCount", Long.valueOf(localPageInfo.getTotalCount()));
    return localHashMap;
  }
  
  public PageInfo findHistoryByObjectCodeNew(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append("from EvsVoucherHistoryV hst where 1=1");
    localStringBuffer.append(" and hst.objectCode = '" + paramString + "'");
    localStringBuffer.append(" and hst.opObjectType = " + paramInt1);
    localStringBuffer.append(" order by hst.handleDate desc");
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt2 / paramInt3 + 1, paramInt3, localArrayList.toArray());
    return localPageInfo;
  }
  
  public void addHistory(EasUserInfo paramEasUserInfo, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = null;
    EvsVoucherHistory localEvsVoucherHistory = new EvsVoucherHistory();
    try
    {
      if (paramEasUserInfo != null)
      {
        System.out.println("开始读取用户id");
        if (paramEasUserInfo.getUserInfoPk() != null) {
          System.out.println("-----user.getUserInfoPk-------" + paramEasUserInfo.getUserInfoPk());
        } else {
          System.out.println("-----user.getUserInfoPk------- 为空");
        }
        System.out.println("读取用户id结束");
        localEvsVoucherHistory.setOpPeople(Long.valueOf(Long.parseLong(paramEasUserInfo.getUserInfoPk().toString())));
        localEvsVoucherHistory.setPositionsName(str);
      }
      else
      {
        localEvsVoucherHistory.setOpPeople(Long.valueOf(82L));
        localEvsVoucherHistory.setPositionsName(str);
      }
      localEvsVoucherHistory.setHandleDate(new Date());
      if (paramString3 != null) {
        localEvsVoucherHistory.setBeginStatus(paramString3);
      }
      if (paramString4 != null) {
        localEvsVoucherHistory.setEndStatus(paramString4);
      }
      if (paramString2 != null) {
        localEvsVoucherHistory.setAction(paramString2);
      }
      if (paramString1 != null)
      {
        localEvsVoucherHistory.setObjectCode(paramString1);
        localEvsVoucherHistory.setOpObjectType(Long.valueOf(paramLong));
      }
      if (paramEasUserInfo.getCheckUnit() != null) {
        localEvsVoucherHistory.setCompanyId(Long.valueOf(paramEasUserInfo.getCheckUnit()));
      }
      System.out.println("-----------------------------------" + localEvsVoucherHistory);
      getSession().save(localEvsVoucherHistory);
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
  }
  
  public List<EvsVoucherHistory> findHistoryById(Long paramLong, String paramString)
  {
    String str = "from EvsVoucherHistory e where e.opObjectType=" + paramLong + " and e.objectCode='" + paramString + "' order by e.handleDate desc";
    return getZormTemplate().find(str);
  }
  
  public List<EvsVoucherHistoryV> findHistoryVById(Long paramLong, String paramString)
  {
    String str = "from EvsVoucherHistoryV e where e.opObjectType=" + paramLong + " and e.objectCode='" + paramString + "' and e.endStatus = '" + "BACKED" + "' order by e.handleDate desc";
    return getZormTemplate().find(str);
  }
  
  public void addHistoryNew(EasUserInfo paramEasUserInfo, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, Long paramLong1, BigInteger paramBigInteger)
  {
    Object localObject = null;
    EvsVoucherHistory localEvsVoucherHistory = new EvsVoucherHistory();
    localEvsVoucherHistory.setOpPeople(Long.valueOf(Long.parseLong(paramEasUserInfo.getUserInfoPk().toString())));
    try
    {
      localEvsVoucherHistory.setHandleDate(new Date());
      if (paramString3 != null) {
        localEvsVoucherHistory.setBeginStatus(paramString3);
      }
      if (paramString4 != null) {
        localEvsVoucherHistory.setEndStatus(paramString4);
      }
      if (paramString2 != null) {
        localEvsVoucherHistory.setAction(paramString2);
      }
      if (paramString1 != null)
      {
        localEvsVoucherHistory.setObjectCode(paramString1);
        localEvsVoucherHistory.setOpObjectType(Long.valueOf(paramLong));
      }
      localEvsVoucherHistory.setCompanyId(paramLong1);
      localEvsVoucherHistory.setArchivesSiteId(paramBigInteger);
      super.insertObject(localEvsVoucherHistory);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void addHistoryNews(EasUserInfo paramEasUserInfo, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, Long paramLong1, String paramString5)
  {
    Object localObject = null;
    EvsVoucherHistory localEvsVoucherHistory = new EvsVoucherHistory();
    localEvsVoucherHistory.setOpPeople(Long.valueOf(Long.parseLong(paramEasUserInfo.getUserInfoPk().toString())));
    try
    {
      localEvsVoucherHistory.setHandleDate(new Date());
      if (paramString3 != null) {
        localEvsVoucherHistory.setBeginStatus(paramString3);
      }
      if (paramString4 != null) {
        localEvsVoucherHistory.setEndStatus(paramString4);
      }
      if (paramString2 != null) {
        localEvsVoucherHistory.setAction(paramString2);
      }
      if (paramString1 != null)
      {
        localEvsVoucherHistory.setObjectCode(paramString1);
        localEvsVoucherHistory.setOpObjectType(Long.valueOf(paramLong));
      }
      localEvsVoucherHistory.setCompanyId(paramLong1);
      localEvsVoucherHistory.setAddress(paramString5);
      super.insertObject(localEvsVoucherHistory);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void addHistoryNew(EasUserInfo paramEasUserInfo, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, Long paramLong1, BigInteger paramBigInteger, String paramString5)
  {
    Object localObject = null;
    EvsVoucherHistory localEvsVoucherHistory = new EvsVoucherHistory();
    localEvsVoucherHistory.setOpPeople(Long.valueOf(Long.parseLong(paramEasUserInfo.getUserInfoPk().toString())));
    localEvsVoucherHistory.setHandleDate(new Date());
    if (paramString3 != null) {
      localEvsVoucherHistory.setBeginStatus(paramString3);
    }
    if (paramString4 != null) {
      localEvsVoucherHistory.setEndStatus(paramString4);
    }
    if (paramString2 != null) {
      localEvsVoucherHistory.setAction(paramString2);
    }
    if (paramString1 != null)
    {
      localEvsVoucherHistory.setObjectCode(paramString1);
      localEvsVoucherHistory.setOpObjectType(Long.valueOf(paramLong));
    }
    if (paramString5 != null) {
      localEvsVoucherHistory.setCheckComment(paramString5);
    }
    localEvsVoucherHistory.setCompanyId(paramLong1);
    localEvsVoucherHistory.setArchivesSiteId(paramBigInteger);
    super.insertObject(localEvsVoucherHistory);
  }
  
  public void addHistoryNews(EasUserInfo paramEasUserInfo, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, Long paramLong1, String paramString5, String paramString6)
  {
    Object localObject = null;
    EvsVoucherHistory localEvsVoucherHistory = new EvsVoucherHistory();
    localEvsVoucherHistory.setOpPeople(Long.valueOf(Long.parseLong(paramEasUserInfo.getUserInfoPk().toString())));
    localEvsVoucherHistory.setHandleDate(new Date());
    if (paramString3 != null) {
      localEvsVoucherHistory.setBeginStatus(paramString3);
    }
    if (paramString4 != null) {
      localEvsVoucherHistory.setEndStatus(paramString4);
    }
    if (paramString2 != null) {
      localEvsVoucherHistory.setAction(paramString2);
    }
    if (paramString1 != null)
    {
      localEvsVoucherHistory.setObjectCode(paramString1);
      localEvsVoucherHistory.setOpObjectType(Long.valueOf(paramLong));
    }
    if (paramString6 != null) {
      localEvsVoucherHistory.setCheckComment(paramString6);
    }
    localEvsVoucherHistory.setCompanyId(paramLong1);
    localEvsVoucherHistory.setAddress(paramString5);
    super.insertObject(localEvsVoucherHistory);
  }
  
  public Map findHistoryByVoucherId(String paramString, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append("from EvsVoucherHistoryV hst where 1=1");
    localStringBuffer.append(" and hst.objectCode = '" + paramString + "'");
    localStringBuffer.append(" and opObjectType = 0");
    localStringBuffer.append(" order by hst.handleDate desc");
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1 / paramInt2 + 1, paramInt2, localArrayList.toArray());
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", localPageInfo.getResult());
    localHashMap.put("totalCount", Long.valueOf(localPageInfo.getTotalCount()));
    return localHashMap;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.eBillManage.EvsVoucherHistoryDAO
 * JD-Core Version:    0.7.0.1
 */