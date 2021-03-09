package com.zte.eimage.access.baseconfig.dao;

import com.zte.eimage.business.baseconfig.model.EidImageInfos;
import com.zte.eimage.business.baseconfig.util.EidObjectUtils;
import com.zte.evs.ebill.model.archives.FbpArchivesHeadandhistorV;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.util.Util;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import com.zte.ssb.zorm.Session;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EidFileProccessDAO
  extends BaseDAO
  implements IEidFileProccessDAO
{
  private EidObjectUtils objectUtils;
  
  public EidImageInfos getEidImageInfos(Long paramLong)
  {
    return (EidImageInfos)super.getObject(EidImageInfos.class, paramLong);
  }
  
  public List getEidImageInfoss()
  {
    return super.getObjects(EidImageInfos.class);
  }
  
  public List<EidImageInfos> getEidImageInfoss(int paramInt1, int paramInt2)
  {
    return super.getObjects(EidImageInfos.class, paramInt1, paramInt2);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeEidImageInfos(EidImageInfos paramEidImageInfos)
  {
    super.removeObject(paramEidImageInfos);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public EidImageInfos insertEidImageInfos(EidImageInfos paramEidImageInfos)
  {
    return (EidImageInfos)getSession().save(paramEidImageInfos);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateEidImageInfos(EidImageInfos paramEidImageInfos)
  {
    super.updateObject(paramEidImageInfos);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertEidImageInfoss(List<EidImageInfos> paramList)
  {
    super.insertObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeEidImageInfoss(List<EidImageInfos> paramList)
  {
    super.removeObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateEidImageInfoss(List<EidImageInfos> paramList)
  {
    super.updateObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeEidImageInfos(Long paramLong)
  {
    super.removeObject(EidImageInfos.class, paramLong);
  }
  
  public PageInfo findImageInfosVByQry(FbpArchivesHeadandhistorV paramFbpArchivesHeadandhistorV, int paramInt1, int paramInt2, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append(" From FbpArchivesHeadersV i  where i.attribute1 in('N','实物档案借阅') and i.archivesStatus !='ARCHIVES_AS_DRAFT'");
    if (!Util.isStrEmpty(paramFbpArchivesHeadandhistorV.getApplyNum())) {
      localStringBuffer.append(" AND upper(i.applyNum) LIKE '%" + paramFbpArchivesHeadandhistorV.getApplyNum().toUpperCase() + "%'");
    }
    if (!Util.isNullObject(paramFbpArchivesHeadandhistorV.getArchivesStatusCode()))
    {
      localStringBuffer.append(" AND i.archivesStatus = ?");
      localArrayList.add(paramFbpArchivesHeadandhistorV.getArchivesStatusCode());
    }
    if (!Util.isNullObject(paramFbpArchivesHeadandhistorV.getEmployeeId()))
    {
      localStringBuffer.append(" AND i.employeeId = ?");
      localArrayList.add(paramFbpArchivesHeadandhistorV.getEmployeeId());
    }
    if (!Util.isNullObject(paramFbpArchivesHeadandhistorV.getCompanyId()))
    {
      localStringBuffer.append(" AND i.companyId = ?");
      localArrayList.add(paramFbpArchivesHeadandhistorV.getCompanyId());
    }
    if (!Util.isNullObject(paramFbpArchivesHeadandhistorV.getBeginDate1()))
    {
      localStringBuffer.append(" AND i.applyDate >= ?");
      localArrayList.add(paramFbpArchivesHeadandhistorV.getBeginDate1());
    }
    if (!Util.isNullObject(paramFbpArchivesHeadandhistorV.getEndDate1()))
    {
      localStringBuffer.append(" AND i.applyDate <= ?");
      localArrayList.add(new Date(paramFbpArchivesHeadandhistorV.getEndDate1().getTime() + 86399999L));
    }
    if (!Util.isNullObject(paramFbpArchivesHeadandhistorV.getBeginDate2()))
    {
      localStringBuffer.append(" AND i.useDate >= ?");
      localArrayList.add(paramFbpArchivesHeadandhistorV.getBeginDate2());
    }
    if (!Util.isNullObject(paramFbpArchivesHeadandhistorV.getEndDate2()))
    {
      localStringBuffer.append(" AND i.useDate <= ?");
      localArrayList.add(new Date(paramFbpArchivesHeadandhistorV.getEndDate2().getTime() + 86399999L));
    }
    if (!Util.isNullObject(paramFbpArchivesHeadandhistorV.getBeginDate3()))
    {
      localStringBuffer.append(" AND i.giveBackDate >= ?");
      localArrayList.add(paramFbpArchivesHeadandhistorV.getBeginDate3());
    }
    if (!Util.isNullObject(paramFbpArchivesHeadandhistorV.getEndDate3()))
    {
      localStringBuffer.append(" AND i.giveBackDate <= ?");
      localArrayList.add(new Date(paramFbpArchivesHeadandhistorV.getEndDate3().getTime() + 86399999L));
    }
    localStringBuffer.append(" ORDER BY i.applyDate DESC,i.applyNum DESC");
    paramInt1 = paramInt1 / paramInt2 + 1;
    String str = localStringBuffer.toString();
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1, paramInt2, localArrayList.toArray());
    return localPageInfo;
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
 * Qualified Name:     com.zte.eimage.access.baseconfig.dao.EidFileProccessDAO
 * JD-Core Version:    0.7.0.1
 */