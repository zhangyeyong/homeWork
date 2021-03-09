package com.zte.eimage.access.baseconfig.dao;

import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.eimage.business.baseconfig.model.EidAppraiseHistories;
import com.zte.eimage.business.baseconfig.model.EidAppraiseHistoryV;
import com.zte.eimage.business.baseconfig.util.EidObjectUtils;
import com.zte.evs.ebill.common.EvsObjectUtils;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.util.Util;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import com.zte.ssb.zorm.Query;
import com.zte.ssb.zorm.SQLQuery;
import com.zte.ssb.zorm.Session;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EidAppraiseHistoriesDAO
  extends BaseDAO
  implements IEidAppraiseHistoriesDAO
{
  private EidObjectUtils objectUtils;
  
  public EidAppraiseHistories getEidAppraiseHistories(Long paramLong)
  {
    return (EidAppraiseHistories)super.getObject(EidAppraiseHistories.class, paramLong);
  }
  
  public List getEidAppraiseHistoriess()
  {
    return super.getObjects(EidAppraiseHistories.class);
  }
  
  public List<EidAppraiseHistories> getEidAppraiseHistoriess(int paramInt1, int paramInt2)
  {
    return super.getObjects(EidAppraiseHistories.class, paramInt1, paramInt2);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeEidAppraiseHistories(EidAppraiseHistories paramEidAppraiseHistories)
  {
    super.removeObject(paramEidAppraiseHistories);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertEidAppraiseHistories(EidAppraiseHistories paramEidAppraiseHistories)
  {
    super.insertObject(paramEidAppraiseHistories);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateEidAppraiseHistories(EidAppraiseHistories paramEidAppraiseHistories)
  {
    super.updateObject(paramEidAppraiseHistories);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertEidAppraiseHistoriess(List<EidAppraiseHistories> paramList)
  {
    super.insertObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeEidAppraiseHistoriess(List<EidAppraiseHistories> paramList)
  {
    super.removeObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateEidAppraiseHistoriess(List<EidAppraiseHistories> paramList)
  {
    super.updateObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeEidAppraiseHistories(Long paramLong)
  {
    super.removeObject(EidAppraiseHistories.class, paramLong);
  }
  
  public Long findEmployeeByNum(String paramString)
  {
    String str = "select em.EMPLOYEE_ID from fbp_employees em where em.EMPLOYEE_NUMBER=?";
    List localList = getSession().createSQLQuery(str).setString(0, paramString).list();
    if ((localList == null) || (localList.isEmpty())) {
      return Long.valueOf(0L);
    }
    return Long.valueOf(((BigDecimal)localList.get(0)).longValue());
  }
  
  public PageInfo findAppraiseHistoriesVLByQry(EidAppraiseHistoryV paramEidAppraiseHistoryV, int paramInt1, int paramInt2, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append(" From EidAppraiseHistoryV i WHERE 1=1");
    int i = 0;
    if ((paramEidAppraiseHistoryV.getBlurQuery() != null) && (paramEidAppraiseHistoryV.getBlurQuery().equals("Y"))) {
      i = 1;
    }
    if (!Util.isStrEmpty(paramEidAppraiseHistoryV.getTaskNum())) {
      if (i != 0)
      {
        localStringBuffer.append(" and upper(i.taskNum) like ?");
        localArrayList.add("%" + paramEidAppraiseHistoryV.getTaskNum().toUpperCase() + "%");
      }
      else
      {
        localStringBuffer.append(" AND i.taskNum = ? ");
        localArrayList.add(paramEidAppraiseHistoryV.getTaskNum());
      }
    }
    if (!Util.isStrEmpty(paramEidAppraiseHistoryV.getImageNumber())) {
      if (i != 0)
      {
        localStringBuffer.append(" and upper(i.imageNumber) like ?");
        localArrayList.add("%" + paramEidAppraiseHistoryV.getImageNumber().toUpperCase() + "%");
      }
      else
      {
        localStringBuffer.append(" AND i.imageNumber = ? ");
        localArrayList.add(paramEidAppraiseHistoryV.getImageNumber());
      }
    }
    if (!Util.isStrEmpty(paramEidAppraiseHistoryV.getCompanyName()))
    {
      localStringBuffer.append(" AND i.companyName = ?");
      localArrayList.add(paramEidAppraiseHistoryV.getCompanyName());
    }
    if (!Util.isStrEmpty(paramEidAppraiseHistoryV.getAppraiseType()))
    {
      localStringBuffer.append(" AND i.appraiseType = ?");
      localArrayList.add(paramEidAppraiseHistoryV.getAppraiseType());
    }
    if (!Util.isStrEmpty(paramEidAppraiseHistoryV.getAppraiseNode()))
    {
      localStringBuffer.append(" AND i.appraiseNode = ?");
      localArrayList.add(paramEidAppraiseHistoryV.getAppraiseNode());
    }
    if (!Util.isStrEmpty(paramEidAppraiseHistoryV.getFormerAppraiseNode()))
    {
      localStringBuffer.append(" AND i.formerAppraiseNode = ?");
      localArrayList.add(paramEidAppraiseHistoryV.getFormerAppraiseNode());
    }
    if (!Util.isStrEmpty(paramEidAppraiseHistoryV.getImageStatus()))
    {
      localStringBuffer.append(" AND i.imageStatus = ?");
      localArrayList.add(paramEidAppraiseHistoryV.getImageStatus());
    }
    if (!Util.isStrEmpty(paramEidAppraiseHistoryV.getFormerImageStatus()))
    {
      localStringBuffer.append(" AND i.formerImageStatus = ?");
      localArrayList.add(paramEidAppraiseHistoryV.getFormerImageStatus());
    }
    if (!Util.isNullObject(paramEidAppraiseHistoryV.getUploadEmployeeId()))
    {
      localStringBuffer.append(" AND i.uploadEmployeeId = ?");
      localArrayList.add(paramEidAppraiseHistoryV.getUploadEmployeeId());
    }
    if (!Util.isNullObject(paramEidAppraiseHistoryV.getUploadBeginDate()))
    {
      localStringBuffer.append(" AND i.uploadDate >= ?");
      localArrayList.add(paramEidAppraiseHistoryV.getUploadBeginDate());
    }
    if (!Util.isNullObject(paramEidAppraiseHistoryV.getUploadEndDate()))
    {
      localStringBuffer.append(" AND i.uploadDate <= ?");
      localArrayList.add(new Date(paramEidAppraiseHistoryV.getUploadEndDate().getTime() + 86399999L));
    }
    if (!Util.isNullObject(paramEidAppraiseHistoryV.getAppraiseEmployeeId()))
    {
      localStringBuffer.append(" AND i.appraiseEmployeeId = ?");
      localArrayList.add(paramEidAppraiseHistoryV.getAppraiseEmployeeId());
    }
    if (!Util.isNullObject(paramEidAppraiseHistoryV.getAppraiseBeginDate()))
    {
      localStringBuffer.append(" AND i.appraiseDate >= ?");
      localArrayList.add(paramEidAppraiseHistoryV.getAppraiseBeginDate());
    }
    if (!Util.isNullObject(paramEidAppraiseHistoryV.getAppraiseEndDate()))
    {
      localStringBuffer.append(" AND i.appraiseDate <= ?");
      localArrayList.add(new Date(paramEidAppraiseHistoryV.getAppraiseEndDate().getTime() + 86399999L));
    }
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    if (!"10000".equals(localEasUserInfo.getUserId())) {
      if (!Util.isStrEmpty(localEasUserInfo.getUserInfoPk().toString()))
      {
        localStringBuffer.append(" and exists(select 1 from FbpPseRelationsV f where f.companyId=i.companyId and f.operationTypeId = i.operationTypeId and f.posStructureCode = ? and f.employeeId = ?)");
        localArrayList.add("IMAGE_CHECK");
        localArrayList.add(Long.valueOf(localEasUserInfo.getUserInfoPk().longValue()));
      }
      else
      {
        localStringBuffer.append(" and 1=2");
      }
    }
    localStringBuffer.append(" ORDER BY i.uploadDate DESC, i.imageNumber DESC, i.appraiseDate DESC");
    paramInt1 = paramInt1 / paramInt2 + 1;
    String str = localStringBuffer.toString();
    System.out.print(str);
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1, paramInt2, localArrayList.toArray());
    return localPageInfo;
  }
  
  public List<EidAppraiseHistoryV> findHistoryVByImageNumber(String paramString)
  {
    String str = " From EidAppraiseHistoryV i WHERE i.imageNumber = '" + paramString.trim() + "' ORDER BY i.appraiseDate DESC,i.appraiseHistoryId desc";
    List localList = getSession().createQuery(str).list();
    return localList;
  }
  
  public EidObjectUtils getObjectUtils()
  {
    return this.objectUtils;
  }
  
  public void setObjectUtils(EidObjectUtils paramEidObjectUtils)
  {
    this.objectUtils = paramEidObjectUtils;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.access.baseconfig.dao.EidAppraiseHistoriesDAO
 * JD-Core Version:    0.7.0.1
 */