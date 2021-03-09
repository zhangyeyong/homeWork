package com.zte.eimage.access.baseconfig.dao;

import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesV;
import com.zte.eimage.business.baseconfig.model.EidAppraiseHistories;
import com.zte.eimage.business.baseconfig.model.EidAppraiseTasks;
import com.zte.eimage.business.baseconfig.model.EidApprovalImageInfosV;
import com.zte.eimage.business.baseconfig.model.EidImageInfos;
import com.zte.eimage.business.baseconfig.model.EidImageInfosV;
import com.zte.eimage.business.baseconfig.model.EidMyApprovalImageInfosV;
import com.zte.eimage.business.baseconfig.model.EidMyboeImageInfosV;
import com.zte.eimage.business.baseconfig.model.EidOrgeImageInfosV;
import com.zte.eimage.business.baseconfig.model.EidSites;
import com.zte.eimage.business.baseconfig.util.EidObjectUtils;
import com.zte.evs.ebill.model.eBillManage.SpecialAttachmentV;
import com.zte.ssb.framework.SSBBus;
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
import org.apache.commons.lang.StringUtils;

public class EidImageInfosDAO
  extends BaseDAO
  implements IEidImageInfosDAO
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
  
  public EidImageInfos findEidImageInfoByImageNumber(String paramString)
  {
    String str = "from EidImageInfos img where img.imageNumber=? and img.enabledFlag = 'Y'";
    List localList = find(str, new Object[] { paramString });
    if (localList.isEmpty()) {
      return null;
    }
    return (EidImageInfos)localList.get(0);
  }
  
  public EidImageInfos findEidImageInfoByTaskNumber(String paramString)
  {
    String str = "select * from EID_IMAGE_INFOS img where img.task_Num=? and img.enabled_Flag = 'Y' UNION select * from EID_IMAGE_INFOS img1 where img1.image_Number=? and img1.enabled_Flag = 'Y'";
    SQLQuery localSQLQuery = super.getSession().createSQLQuery(str);
    localSQLQuery.setString(0, paramString);
    localSQLQuery.setString(1, paramString);
    localSQLQuery.addEntity(EidImageInfos.class);
    List localList = localSQLQuery.list();
    if (localList.isEmpty()) {
      return null;
    }
    return (EidImageInfos)localList.get(0);
  }
  
  public Object findEidImageInfoByCode(String paramString1, String paramString2, String paramString3)
  {
    String str = "from " + paramString1 + " f where f." + paramString2 + "='" + paramString3 + "' and f.enabledFlag = 'Y'";
    List localList = getSession().createQuery(str).list();
    if ((localList == null) || (localList.size() <= 0) || (localList.get(0) == null)) {
      return null;
    }
    return localList.get(0);
  }
  
  public List<EidImageInfos> findEidImageInfoByHql(String paramString)
  {
    Session localSession = super.getSession();
    Query localQuery = localSession.createQuery(paramString);
    return localQuery.list();
  }
  
  public PageInfo findImageInfosVByQry(EidImageInfosV paramEidImageInfosV, int paramInt1, int paramInt2, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append(" From EidImageInfosV i WHERE 1=1");
    int i = 0;
    if ((paramEidImageInfosV.getBlurQuery() != null) && (paramEidImageInfosV.getBlurQuery().equals("Y"))) {
      i = 1;
    }
    if (!Util.isStrEmpty(paramEidImageInfosV.getImageNumber())) {
      if ((paramEidImageInfosV.getBlurQuery() != null) && (paramEidImageInfosV.getBlurQuery().equals("Y")))
      {
        localStringBuffer.append(" AND i.imageNumber like ? ");
        localArrayList.add("%" + paramEidImageInfosV.getImageNumber() + "%");
      }
      else
      {
        localStringBuffer.append(" AND i.imageNumber = ? ");
        localArrayList.add(paramEidImageInfosV.getImageNumber());
      }
    }
    if (!Util.isStrEmpty(paramEidImageInfosV.getTaskNum())) {
      if (i != 0)
      {
        localStringBuffer.append(" and i.taskNum like ?");
        localArrayList.add("%" + paramEidImageInfosV.getTaskNum() + "%");
      }
      else
      {
        localStringBuffer.append(" and i.taskNum = ?");
        localArrayList.add(paramEidImageInfosV.getTaskNum());
      }
    }
    if (!Util.isStrEmpty(paramEidImageInfosV.getAppraiseNode()))
    {
      localStringBuffer.append(" AND i.appraiseNode = ?");
      localArrayList.add(paramEidImageInfosV.getAppraiseNode());
    }
    if (!Util.isStrEmpty(paramEidImageInfosV.getImageStatus()))
    {
      localStringBuffer.append(" AND i.imageStatus = ?");
      localArrayList.add(paramEidImageInfosV.getImageStatus());
    }
    if (!Util.isNullObject(paramEidImageInfosV.getUploadEmployeeId()))
    {
      localStringBuffer.append(" AND i.uploadEmployeeId = ?");
      localArrayList.add(paramEidImageInfosV.getUploadEmployeeId());
    }
    if (!Util.isNullObject(paramEidImageInfosV.getBeginDate()))
    {
      localStringBuffer.append(" AND i.uploadDate >= ?");
      localArrayList.add(paramEidImageInfosV.getBeginDate());
    }
    if (!Util.isNullObject(paramEidImageInfosV.getEndDate()))
    {
      localStringBuffer.append(" AND i.uploadDate <= ?");
      localArrayList.add(new Date(paramEidImageInfosV.getEndDate().getTime() + 86399999L));
    }
    if (!Util.isNullObject(paramEidImageInfosV.getCompanyId()))
    {
      localStringBuffer.append(" AND i.companyId = ?");
      localArrayList.add(paramEidImageInfosV.getCompanyId());
    }
    if (!Util.isNullObject(paramEidImageInfosV.getOperationTypeId()))
    {
      localStringBuffer.append(" AND i.operationTypeId = ?");
      localArrayList.add(paramEidImageInfosV.getOperationTypeId());
    }
    if (!Util.isNullObject(paramEidImageInfosV.getDeptId()))
    {
      localStringBuffer.append(" AND i.deptId = ?");
      localArrayList.add(paramEidImageInfosV.getDeptId());
    }
    if (!Util.isNullObject(paramEidImageInfosV.getAppraiseType()))
    {
      localStringBuffer.append(" AND i.appraiseType = ?");
      localArrayList.add(paramEidImageInfosV.getAppraiseType());
    }
    EidObjectUtils localEidObjectUtils = (EidObjectUtils)SSBBus.findDaoService("eidObjectUtils");
    Long localLong = Long.valueOf(Long.parseLong(localEidObjectUtils.getEmployeeBySession().getEmployeeId().toString()));
    if (!localEidObjectUtils.getEmployeeBySession().getEmployeeNumber().equals("10000"))
    {
      localStringBuffer.append("and exists(from FbpPseRelationsV f where f.companyId=i.companyId and f.operationTypeId = i.operationTypeId and f.posStructureCode = ? and f.employeeId = ? )");
      localArrayList.add("IMAGE_QUERY");
      localArrayList.add(localLong);
    }
    if ((paramEidImageInfosV.getOrderBy() != null) && (paramEidImageInfosV.getOrderBy().equals("ASC"))) {
      localStringBuffer.append(" ORDER BY i.uploadDate ASC");
    } else {
      localStringBuffer.append(" ORDER BY i.uploadDate DESC");
    }
    paramInt1 = paramInt1 / paramInt2 + 1;
    String str = localStringBuffer.toString();
    System.out.print(str);
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1, paramInt2, localArrayList.toArray());
    return localPageInfo;
  }
  
  public PageInfo findMyBoeInfosVByQry(EidMyboeImageInfosV paramEidMyboeImageInfosV, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append(" From EidMyboeImageInfosV i WHERE 1=1 AND i.uploadEmployeeId =" + paramEidMyboeImageInfosV.getUploadEmployeeId());
    int i = 0;
    if ((paramEidMyboeImageInfosV.getBlurQuery() != null) && (paramEidMyboeImageInfosV.getBlurQuery().equals("Y"))) {
      i = 1;
    }
    if (!Util.isStrEmpty(paramEidMyboeImageInfosV.getImageNumber())) {
      if ((paramEidMyboeImageInfosV.getBlurQuery() != null) && (paramEidMyboeImageInfosV.getBlurQuery().equals("Y")))
      {
        localStringBuffer.append(" AND upper(i.imageNumber) LIKE '%" + paramEidMyboeImageInfosV.getImageNumber().toUpperCase() + "%'");
      }
      else
      {
        localStringBuffer.append(" AND i.imageNumber = ? ");
        localArrayList.add(paramEidMyboeImageInfosV.getImageNumber());
      }
    }
    if (!Util.isStrEmpty(paramEidMyboeImageInfosV.getTaskNum())) {
      if (i != 0)
      {
        localStringBuffer.append(" and upper(i.taskNum) like ?");
        localArrayList.add("%" + paramEidMyboeImageInfosV.getTaskNum().toUpperCase() + "%");
      }
      else
      {
        localStringBuffer.append(" AND i.taskNum = ? ");
        localArrayList.add(paramEidMyboeImageInfosV.getTaskNum());
      }
    }
    if (!Util.isNullObject(paramEidMyboeImageInfosV.getCompanyId()))
    {
      localStringBuffer.append(" AND i.companyId = ?");
      localArrayList.add(paramEidMyboeImageInfosV.getCompanyId());
    }
    if (!Util.isNullObject(paramEidMyboeImageInfosV.getOperationTypeId()))
    {
      localStringBuffer.append(" AND i.operationTypeId = ?");
      localArrayList.add(paramEidMyboeImageInfosV.getOperationTypeId());
    }
    if (!Util.isStrEmpty(paramEidMyboeImageInfosV.getImageStatus()))
    {
      localStringBuffer.append(" AND i.imageStatus = ?");
      localArrayList.add(paramEidMyboeImageInfosV.getImageStatus());
    }
    if (!Util.isStrEmpty(paramEidMyboeImageInfosV.getAppraiseNode()))
    {
      localStringBuffer.append(" AND i.appraiseNode = ?");
      localArrayList.add(paramEidMyboeImageInfosV.getAppraiseNode());
    }
    if (!Util.isNullObject(paramEidMyboeImageInfosV.getAppraiseType()))
    {
      localStringBuffer.append(" AND i.appraiseType = ?");
      localArrayList.add(paramEidMyboeImageInfosV.getAppraiseType());
    }
    if (!Util.isNullObject(paramEidMyboeImageInfosV.getBeginDate()))
    {
      localStringBuffer.append(" AND i.uploadDate >= ?");
      localArrayList.add(paramEidMyboeImageInfosV.getBeginDate());
    }
    if (!Util.isNullObject(paramEidMyboeImageInfosV.getEndDate()))
    {
      localStringBuffer.append(" AND i.uploadDate <= ?");
      localArrayList.add(new Date(paramEidMyboeImageInfosV.getEndDate().getTime() + 86399999L));
    }
    if (!Util.isNullObject(paramEidMyboeImageInfosV.getFileBeginDate()))
    {
      localStringBuffer.append(" AND i.appraiseDate >= ?");
      localArrayList.add(paramEidMyboeImageInfosV.getFileBeginDate());
    }
    if (!Util.isNullObject(paramEidMyboeImageInfosV.getFileEndDate()))
    {
      localStringBuffer.append(" AND i.appraiseDate <= ?");
      localArrayList.add(new Date(paramEidMyboeImageInfosV.getFileEndDate().getTime() + 86399999L));
    }
    localStringBuffer.append(" ORDER BY i.uploadDate DESC");
    paramInt1 = paramInt1 / paramInt2 + 1;
    String str = localStringBuffer.toString();
    System.out.print(str);
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1, paramInt2, localArrayList.toArray());
    return localPageInfo;
  }
  
  public PageInfo findOrgeInfosVByQry(EidOrgeImageInfosV paramEidOrgeImageInfosV, int paramInt1, int paramInt2, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append(" From EidOrgeImageInfosV i WHERE 1=1 ");
    if (!Util.isStrEmpty(paramEidOrgeImageInfosV.getImageNumber())) {
      if ((paramEidOrgeImageInfosV.getBlurQuery() != null) && (paramEidOrgeImageInfosV.getBlurQuery().equals("Y")))
      {
        localStringBuffer.append(" AND upper(i.imageNumber) LIKE '%" + paramEidOrgeImageInfosV.getImageNumber().toUpperCase() + "%'");
      }
      else
      {
        localStringBuffer.append(" AND i.imageNumber = ? ");
        localArrayList.add(paramEidOrgeImageInfosV.getImageNumber());
      }
    }
    if (!Util.isStrEmpty(paramEidOrgeImageInfosV.getTaskNum())) {
      if ((paramEidOrgeImageInfosV.getBlurQuery() != null) && (paramEidOrgeImageInfosV.getBlurQuery().equals("Y")))
      {
        localStringBuffer.append(" and upper(i.taskNum) like ?");
        localArrayList.add("%" + paramEidOrgeImageInfosV.getTaskNum().toUpperCase() + "%");
      }
      else
      {
        localStringBuffer.append(" AND i.taskNum = ? ");
        localArrayList.add(paramEidOrgeImageInfosV.getTaskNum());
      }
    }
    if (!Util.isNullObject(paramEidOrgeImageInfosV.getCompanyId()))
    {
      localStringBuffer.append(" AND i.companyId = ?");
      localArrayList.add(paramEidOrgeImageInfosV.getCompanyId());
    }
    if (!Util.isNullObject(paramEidOrgeImageInfosV.getOperationTypeId()))
    {
      localStringBuffer.append(" AND i.operationTypeId = ?");
      localArrayList.add(paramEidOrgeImageInfosV.getOperationTypeId());
    }
    if (!Util.isNullObject(paramEidOrgeImageInfosV.getBeginDate()))
    {
      localStringBuffer.append(" AND i.uploadDate >= ?");
      localArrayList.add(paramEidOrgeImageInfosV.getBeginDate());
    }
    if (!Util.isNullObject(paramEidOrgeImageInfosV.getEndDate()))
    {
      localStringBuffer.append(" AND i.uploadDate <= ?");
      localArrayList.add(new Date(paramEidOrgeImageInfosV.getEndDate().getTime() + 86399999L));
    }
    if (!Util.isNullObject(paramEidOrgeImageInfosV.getUploadEmployeeId()))
    {
      localStringBuffer.append(" AND i.uploadEmployeeId = ?");
      localArrayList.add(paramEidOrgeImageInfosV.getUploadEmployeeId());
    }
    EidObjectUtils localEidObjectUtils = (EidObjectUtils)SSBBus.findDaoService("eidObjectUtils");
    Long localLong = Long.valueOf(Long.parseLong(localEidObjectUtils.getEmployeeBySession().getEmployeeId().toString()));
    localStringBuffer.append("and exists(from FbpPseRelation f where f.enabledFlag='Y' and f.companyId=i.companyId and f.operationTypeId = i.operationTypeId and f.employeeId = ? )");
    localArrayList.add(localLong);
    localStringBuffer.append(" ORDER BY i.uploadDate DESC");
    paramInt1 = paramInt1 / paramInt2 + 1;
    String str = localStringBuffer.toString();
    System.out.print(str);
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1, paramInt2, localArrayList.toArray());
    return localPageInfo;
  }
  
  public PageInfo findNeedApprovalInfosVByQry(EidApprovalImageInfosV paramEidApprovalImageInfosV, int paramInt1, int paramInt2, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append(" From EidApprovalImageInfosV i WHERE 1=1 ");
    if (!Util.isStrEmpty(paramEidApprovalImageInfosV.getImageNumber())) {
      if ((paramEidApprovalImageInfosV.getBlurQuery() != null) && (paramEidApprovalImageInfosV.getBlurQuery().equals("Y")))
      {
        localStringBuffer.append(" AND upper(i.imageNumber) LIKE '%" + paramEidApprovalImageInfosV.getImageNumber().toUpperCase() + "%'");
      }
      else
      {
        localStringBuffer.append(" AND i.imageNumber = ? ");
        localArrayList.add(paramEidApprovalImageInfosV.getImageNumber());
      }
    }
    if (!Util.isStrEmpty(paramEidApprovalImageInfosV.getTaskNum())) {
      if ((paramEidApprovalImageInfosV.getBlurQuery() != null) && (paramEidApprovalImageInfosV.getBlurQuery().equals("Y")))
      {
        localStringBuffer.append(" and upper(i.taskNum) like ?");
        localArrayList.add("%" + paramEidApprovalImageInfosV.getTaskNum().toUpperCase() + "%");
      }
      else
      {
        localStringBuffer.append(" AND i.taskNum = ? ");
        localArrayList.add(paramEidApprovalImageInfosV.getTaskNum());
      }
    }
    if (!Util.isNullObject(paramEidApprovalImageInfosV.getCompanyId()))
    {
      localStringBuffer.append(" AND i.companyId = ?");
      localArrayList.add(paramEidApprovalImageInfosV.getCompanyId());
    }
    if (!Util.isNullObject(paramEidApprovalImageInfosV.getOperationTypeId()))
    {
      localStringBuffer.append(" AND i.operationTypeId = ?");
      localArrayList.add(paramEidApprovalImageInfosV.getOperationTypeId());
    }
    if (!Util.isNullObject(paramEidApprovalImageInfosV.getBeginDate()))
    {
      localStringBuffer.append(" AND i.uploadDate >= ?");
      localArrayList.add(paramEidApprovalImageInfosV.getBeginDate());
    }
    if (!Util.isNullObject(paramEidApprovalImageInfosV.getEndDate()))
    {
      localStringBuffer.append(" AND i.uploadDate <= ?");
      localArrayList.add(new Date(paramEidApprovalImageInfosV.getEndDate().getTime() + 86399999L));
    }
    if (!Util.isNullObject(paramEidApprovalImageInfosV.getUploadEmployeeId()))
    {
      localStringBuffer.append(" AND i.uploadEmployeeId = ?");
      localArrayList.add(paramEidApprovalImageInfosV.getUploadEmployeeId());
    }
    EidObjectUtils localEidObjectUtils = (EidObjectUtils)SSBBus.findDaoService("eidObjectUtils");
    Long localLong = Long.valueOf(Long.parseLong(localEidObjectUtils.getEmployeeBySession().getEmployeeId().toString()));
    localStringBuffer.append("and exists(from FbpPseRelationsV f where f.companyId=i.companyId and f.operationTypeId = i.operationTypeId and f.posStructureCode = ? and f.employeeId = ? )");
    localArrayList.add("IMAGE_QUERY");
    localArrayList.add(localLong);
    localStringBuffer.append(" ORDER BY i.lastUpdateDate ");
    paramInt1 = paramInt1 / paramInt2 + 1;
    String str = localStringBuffer.toString();
    System.out.print(str);
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1, paramInt2, localArrayList.toArray());
    return localPageInfo;
  }
  
  public PageInfo findMyApprovalInfosVByQry(EidMyApprovalImageInfosV paramEidMyApprovalImageInfosV, int paramInt1, int paramInt2, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append(" From EidMyApprovalImageInfosV i WHERE 1=1 AND (i.imageStatus = 'ALREADY_FILING' or i.imageStatus = 'BACKED' or i.imageStatus = 'COMPLEMENT_FOR_FILING') AND i.appraiseEmployeeId =" + paramEidMyApprovalImageInfosV.getAppraiseEmployeeId());
    if (!Util.isStrEmpty(paramEidMyApprovalImageInfosV.getTaskNum())) {
      if ((paramEidMyApprovalImageInfosV.getBlurQuery() != null) && (paramEidMyApprovalImageInfosV.getBlurQuery().equals("Y")))
      {
        localStringBuffer.append(" AND upper(i.taskNum) LIKE '%" + paramEidMyApprovalImageInfosV.getTaskNum().toUpperCase() + "%'");
      }
      else
      {
        localStringBuffer.append(" AND i.taskNum = ? ");
        localArrayList.add(paramEidMyApprovalImageInfosV.getTaskNum());
      }
    }
    if (!Util.isStrEmpty(paramEidMyApprovalImageInfosV.getImageNumber())) {
      if ((paramEidMyApprovalImageInfosV.getBlurQuery() != null) && (paramEidMyApprovalImageInfosV.getBlurQuery().equals("Y")))
      {
        localStringBuffer.append(" AND upper(i.imageNumber) LIKE '%" + paramEidMyApprovalImageInfosV.getImageNumber().toUpperCase() + "%'");
      }
      else
      {
        localStringBuffer.append(" AND i.imageNumber = ? ");
        localArrayList.add(paramEidMyApprovalImageInfosV.getImageNumber());
      }
    }
    if (!Util.isNullObject(paramEidMyApprovalImageInfosV.getCompanyId()))
    {
      localStringBuffer.append(" AND i.companyId = ?");
      localArrayList.add(paramEidMyApprovalImageInfosV.getCompanyId());
    }
    if (!Util.isNullObject(paramEidMyApprovalImageInfosV.getOperationTypeId()))
    {
      localStringBuffer.append(" AND i.operationTypeId = ?");
      localArrayList.add(paramEidMyApprovalImageInfosV.getOperationTypeId());
    }
    if (!Util.isNullObject(paramEidMyApprovalImageInfosV.getUploadEmployeeId()))
    {
      localStringBuffer.append(" AND i.uploadEmployeeId = ?");
      localArrayList.add(paramEidMyApprovalImageInfosV.getUploadEmployeeId());
    }
    if (!Util.isNullObject(paramEidMyApprovalImageInfosV.getBeginDate()))
    {
      localStringBuffer.append(" AND i.uploadDate >= ?");
      localArrayList.add(paramEidMyApprovalImageInfosV.getBeginDate());
    }
    if (!Util.isNullObject(paramEidMyApprovalImageInfosV.getEndDate()))
    {
      localStringBuffer.append(" AND i.uploadDate <= ?");
      localArrayList.add(new Date(paramEidMyApprovalImageInfosV.getEndDate().getTime() + 86399999L));
    }
    if (!Util.isNullObject(paramEidMyApprovalImageInfosV.getFileBeginDate()))
    {
      localStringBuffer.append(" AND i.appraiseDate >= ?");
      localArrayList.add(paramEidMyApprovalImageInfosV.getFileBeginDate());
    }
    if (!Util.isNullObject(paramEidMyApprovalImageInfosV.getFileEndDate()))
    {
      localStringBuffer.append(" AND i.appraiseDate <= ?");
      localArrayList.add(new Date(paramEidMyApprovalImageInfosV.getFileEndDate().getTime() + 86399999L));
    }
    if (!Util.isNullObject(paramEidMyApprovalImageInfosV.getSigeBeginDate()))
    {
      localStringBuffer.append(" AND i.signDate >= ?");
      localArrayList.add(paramEidMyApprovalImageInfosV.getSigeBeginDate());
    }
    if (!Util.isNullObject(paramEidMyApprovalImageInfosV.getSigeEndDate()))
    {
      localStringBuffer.append(" AND i.signDate <= ?");
      localArrayList.add(new Date(paramEidMyApprovalImageInfosV.getSigeEndDate().getTime() + 86399999L));
    }
    localStringBuffer.append(" ORDER BY i.uploadDate DESC");
    paramInt1 = paramInt1 / paramInt2 + 1;
    String str = localStringBuffer.toString();
    System.out.print(str);
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
  
  public List<EidImageInfos> findEidImageInfoByFlag()
  {
    String str = "from EidImageInfos img where img.enabledFlag = 'Y' and img.easImageFlag = 'N' and img.imageStatus not in('TO_SIGN_FOR', 'BACKED') and rownum <= 30";
    List localList = getSession().createQuery(str).list();
    return localList;
  }
  
  public List<EidImageInfos> findWaitDeleteImageInfo()
  {
    String str = "from EidImageInfos img where img.enabledFlag = 'Y' and img.deleteImageFlag = 'N' and img.imageStatus = 'BACKED' and rownum <= 30";
    List localList = getSession().createQuery(str).list();
    return localList;
  }
  
  public void deleteMyImage(Long paramLong)
  {
    String str = "from EidImageInfos img where img.imageInfoId = " + paramLong;
    List localList = getSession().createQuery(str).list();
    if (localList.size() > 0)
    {
      EidImageInfos localEidImageInfos = (EidImageInfos)localList.get(0);
      localEidImageInfos.setEnabledFlag("N");
      localEidImageInfos.setLastUpdateDate(new Date());
      updateObject(localEidImageInfos);
    }
  }
  
  public List<Object[]> findImageByUser(String paramString, Long paramLong)
  {
    String str = "select inf.image_number, inf.task_num, es.site_id, inf.image_count, fc.company_code, fct.company_name, fot.operation_type_code, fott.operation_type_name, inf.is_boe, (select image_path from eid.eid_images ei where ei.image_info_id = inf.image_info_id and rownum=1) as image_path,inf.MEMO  from eid_image_infos        inf, fbp_company            fc, fbp_company_tl         fct, Fbp_Operation_Types    fot, fbp_operation_types_tl fott, eid_sites              es where inf.company_id = fc.company_id and fc.company_id = fct.company_id and fct.language = userenv('LANG') and inf.operation_type_id = fot.operation_type_id and inf.operation_type_id = fott.operation_type_id and fott.language = userenv('LANG') and inf.company_id = es.company_id and inf.enabled_flag = 'Y' and inf.TASK_NUM like ? and inf.UPLOAD_EMPLOYEE_ID = ?";
    return super.getSession().createSQLQuery(str).setString(0, "%" + paramString + "%").setLong(1, paramLong.longValue()).list();
  }
  
  public String getImageSeqNo()
  {
    String str1 = "select eid.eid_image_seq_no_s.nextval from dual";
    String str2 = String.valueOf((BigDecimal)super.getSession().createSQLQuery(str1).uniqueResult());
    return str2;
  }
  
  public String getLanguage()
  {
    String str = "select userenv('LANG') from dual";
    return (String)super.getSession().createSQLQuery(str).uniqueResult();
  }
  
  public PageInfo fetchSpecialAttachments(SpecialAttachmentV paramSpecialAttachmentV, int paramInt1, int paramInt2)
  {
    if (null == paramSpecialAttachmentV) {
      return new PageInfo();
    }
    StringBuilder localStringBuilder = new StringBuilder("from SpecialAttachmentV sav where 1=1 ");
    ArrayList localArrayList = new ArrayList();
    String str1 = paramSpecialAttachmentV.getBlurQuery();
    Boolean localBoolean = Boolean.valueOf((StringUtils.isNotEmpty(str1)) && (str1.equalsIgnoreCase("Y")));
    String str2 = paramSpecialAttachmentV.getImageNumber();
    if (StringUtils.isNotEmpty(str2)) {
      if (localBoolean.booleanValue())
      {
        localStringBuilder.append(" AND sav.imageNumber like ? ");
        localArrayList.add("%" + str2 + "%");
      }
      else
      {
        localStringBuilder.append(" AND sav.imageNumber = ? ");
        localArrayList.add(str2);
      }
    }
    String str3 = paramSpecialAttachmentV.getTaskNum();
    if (StringUtils.isNotEmpty(str3)) {
      if (localBoolean.booleanValue())
      {
        localStringBuilder.append(" AND sav.taskNum like ? ");
        localArrayList.add("%" + str3 + "%");
      }
      else
      {
        localStringBuilder.append(" AND sav.taskNum = ? ");
        localArrayList.add(str3);
      }
    }
    Long localLong1 = paramSpecialAttachmentV.getCompanyId();
    if (null != localLong1)
    {
      localStringBuilder.append(" AND sav.companyId = ? ");
      localArrayList.add(localLong1);
    }
    Long localLong2 = paramSpecialAttachmentV.getOperationTypeId();
    if (null != localLong2)
    {
      localStringBuilder.append(" AND sav.operationTypeId = ? ");
      localArrayList.add(localLong2);
    }
    Long localLong3 = paramSpecialAttachmentV.getUploadEmployeeId();
    if (null != localLong3)
    {
      localStringBuilder.append(" AND sav.uploadEmployeeId = ? ");
      localArrayList.add(localLong3);
    }
    String str4 = paramSpecialAttachmentV.getUploadDateBegin();
    if (StringUtils.isNotEmpty(str4))
    {
      localStringBuilder.append(" AND to_char(sav.uploadDate,'yyyy-MM-dd') >= ? ");
      localArrayList.add(str4);
    }
    String str5 = paramSpecialAttachmentV.getUploadDateEnd();
    if (StringUtils.isNotEmpty(str5))
    {
      localStringBuilder.append(" AND to_char(sav.uploadDate,'yyyy-MM-dd') <= ? ");
      localArrayList.add(str5);
    }
    String str6 = paramSpecialAttachmentV.getImageStatus();
    if (StringUtils.isNotEmpty(str6))
    {
      localStringBuilder.append(" AND sav.imageStatus = ? ");
      localArrayList.add(str6);
    }
    String str7 = paramSpecialAttachmentV.getJournalDateBegin();
    if (StringUtils.isNotEmpty(str7))
    {
      localStringBuilder.append(" AND to_char(sav.journalDate,'yyyy-MM-dd') >= ? ");
      localArrayList.add(str7);
    }
    String str8 = paramSpecialAttachmentV.getJournalDateEnd();
    if (StringUtils.isNotEmpty(str8))
    {
      localStringBuilder.append(" AND to_char(sav.journalDate,'yyyy-MM-dd') <= ? ");
      localArrayList.add(str8);
    }
    Long localLong4 = paramSpecialAttachmentV.getAppraiseEmployeeId();
    if (null != localLong4)
    {
      localStringBuilder.append(" AND sav.appraiseEmployeeId = ? ");
      localArrayList.add(localLong4);
    }
    String str9 = paramSpecialAttachmentV.getAppraiseDateBegin();
    if (StringUtils.isNotEmpty(str9))
    {
      localStringBuilder.append(" AND to_char(sav.appraiseDate,'yyyy-MM-dd') >= ? ");
      localArrayList.add(str9);
    }
    String str10 = paramSpecialAttachmentV.getAppraiseDateEnd();
    if (StringUtils.isNotEmpty(str10))
    {
      localStringBuilder.append(" AND to_char(sav.appraiseDate,'yyyy-MM-dd') <= ? ");
      localArrayList.add(str10);
    }
    paramInt1 = paramInt1 / paramInt2 + 1;
    String str11 = localStringBuilder.toString();
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuilder.toString(), paramInt1, paramInt2, localArrayList.toArray());
    return localPageInfo;
  }
  
  public String operationTypeInLimit(String paramString)
  {
    String str1 = "select attribute3 from fbp_operation_types t,eid.eid_image_infos i where t.operation_type_id = i.operation_Type_id and i.image_info_id = ?";
    SQLQuery localSQLQuery = super.getSession().createSQLQuery(str1);
    localSQLQuery.setLong(0, Long.valueOf(paramString).longValue());
    String str2 = (String)localSQLQuery.uniqueResult();
    return str2;
  }
  
  public PageInfo findEspecialInfosVByQry(EidImageInfosV paramEidImageInfosV, int paramInt1, int paramInt2, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append(" From EidImageInfosV i WHERE 1=1 ");
    if (!Util.isStrEmpty(paramEidImageInfosV.getImageNumber())) {
      if ((paramEidImageInfosV.getBlurQuery() != null) && (paramEidImageInfosV.getBlurQuery().equals("Y")))
      {
        localStringBuffer.append(" AND upper(i.imageNumber) LIKE '%" + paramEidImageInfosV.getImageNumber().toUpperCase() + "%'");
      }
      else
      {
        localStringBuffer.append(" AND i.imageNumber = ? ");
        localArrayList.add(paramEidImageInfosV.getImageNumber());
      }
    }
    if (!Util.isStrEmpty(paramEidImageInfosV.getTaskNum())) {
      if ((paramEidImageInfosV.getBlurQuery() != null) && (paramEidImageInfosV.getBlurQuery().equals("Y")))
      {
        localStringBuffer.append(" and upper(i.taskNum) like ?");
        localArrayList.add("%" + paramEidImageInfosV.getTaskNum().toUpperCase() + "%");
      }
      else
      {
        localStringBuffer.append(" AND i.taskNum = ? ");
        localArrayList.add(paramEidImageInfosV.getTaskNum());
      }
    }
    if (!Util.isNullObject(paramEidImageInfosV.getCompanyId()))
    {
      localStringBuffer.append(" AND i.companyId = ?");
      localArrayList.add(paramEidImageInfosV.getCompanyId());
    }
    if (!Util.isNullObject(paramEidImageInfosV.getOperationTypeId()))
    {
      localStringBuffer.append(" AND i.operationTypeId = ?");
      localArrayList.add(paramEidImageInfosV.getOperationTypeId());
    }
    if (!Util.isNullObject(paramEidImageInfosV.getBeginDate()))
    {
      localStringBuffer.append(" AND i.uploadDate >= ?");
      localArrayList.add(paramEidImageInfosV.getBeginDate());
    }
    if (!Util.isNullObject(paramEidImageInfosV.getEndDate()))
    {
      localStringBuffer.append(" AND i.uploadDate <= ?");
      localArrayList.add(new Date(paramEidImageInfosV.getEndDate().getTime() + 86399999L));
    }
    if (!Util.isNullObject(paramEidImageInfosV.getUploadEmployeeId()))
    {
      localStringBuffer.append(" AND i.uploadEmployeeId = ?");
      localArrayList.add(paramEidImageInfosV.getUploadEmployeeId());
    }
    EidObjectUtils localEidObjectUtils = (EidObjectUtils)SSBBus.findDaoService("eidObjectUtils");
    Long localLong = Long.valueOf(Long.parseLong(localEidObjectUtils.getEmployeeBySession().getEmployeeId().toString()));
    localStringBuffer.append("and exists(from FbpPseRelation f where f.enabledFlag='Y' and f.companyId=i.companyId and f.operationTypeId = i.operationTypeId and f.employeeId = ? ) ");
    localArrayList.add(localLong);
    localStringBuffer.append(" AND i.enabledFlag='Y' ");
    localStringBuffer.append("AND i.imageStatus='ALREADY_FILING'");
    localStringBuffer.append(" ORDER BY i.uploadDate DESC");
    paramInt1 = paramInt1 / paramInt2 + 1;
    String str = localStringBuffer.toString();
    System.out.print(str);
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1, paramInt2, localArrayList.toArray());
    return localPageInfo;
  }
  
  public void updateImageInfoReject(String paramString1, String paramString2)
  {
    String str = "select * from eid.eid_image_infos ei where ei.enabled_flag = 'Y' and ei.task_num = ?";
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString1);
    IImageCommonDAO localIImageCommonDAO = (IImageCommonDAO)SSBBus.findDomainService("imageCommonDAO");
    EidImageInfos localEidImageInfos = (EidImageInfos)localIImageCommonDAO.findObject(str, localArrayList, EidImageInfos.class);
    if ((localEidImageInfos == null) || ("BACKED".equals(localEidImageInfos.getImageStatus()))) {
      return;
    }
    EidAppraiseHistories localEidAppraiseHistories = new EidAppraiseHistories();
    localEidAppraiseHistories.setLastUpdateDate(new Date());
    localEidAppraiseHistories.setLastUpdatedBy(Long.valueOf(1L));
    localEidAppraiseHistories.setCreationDate(new Date());
    localEidAppraiseHistories.setCreatedBy(Long.valueOf(1L));
    localEidAppraiseHistories.setLastUpdateLogin(Long.valueOf(1L));
    localEidAppraiseHistories.setEnabledFlag("Y");
    localEidAppraiseHistories.setImageInfoId(localEidImageInfos.getImageInfoId());
    localEidAppraiseHistories.setAppraiseEmployeeId(Long.valueOf(1L));
    localEidAppraiseHistories.setAppraiseDate(new Date());
    localEidAppraiseHistories.setImageStatus("BACKED");
    localEidAppraiseHistories.setActionCode("HEAVY_AND");
    localEidAppraiseHistories.setAppraiseNode("HEAVY_AND");
    localEidAppraiseHistories.setAppraiseDesc(paramString2);
    super.insertObject(localEidAppraiseHistories);
    localEidImageInfos.setImageStatus("BACKED");
    localEidImageInfos.setAppraiseNode("HEAVY_AND");
    super.updateObject(localEidImageInfos);
    EidAppraiseTasks localEidAppraiseTasks = new EidAppraiseTasks();
    localEidAppraiseTasks.setLastUpdateDate(new Date());
    localEidAppraiseTasks.setLastUpdatedBy(Long.valueOf(1L));
    localEidAppraiseTasks.setCreationDate(new Date());
    localEidAppraiseTasks.setCreatedBy(Long.valueOf(1L));
    localEidAppraiseTasks.setLastUpdateLogin(Long.valueOf(1L));
    localEidAppraiseTasks.setEnabledFlag("Y");
    ISiteDao localISiteDao = (ISiteDao)SSBBus.findDaoService("siteDao");
    EidSites localEidSites = localISiteDao.findSiteByCompanyId(localEidImageInfos.getCompanyId());
    if (null != localEidSites)
    {
      localEidAppraiseTasks.setFtpId(Long.valueOf(localEidSites.getSiteId().longValue()));
      localEidAppraiseTasks.setFtpPath(localEidSites.getFtpSite());
    }
    localEidAppraiseTasks.setImageCount(localEidImageInfos.getImageCount());
    localEidAppraiseTasks.setImageMemo(localEidImageInfos.getMemo());
    localEidAppraiseTasks.setImageNum(localEidImageInfos.getImageNumber());
    localEidAppraiseTasks.setTaskDesc(paramString2);
    localEidAppraiseTasks.setTaskStatus("NONCOMPLETE");
    localEidAppraiseTasks.setTaskType("6");
    super.insertObject(localEidAppraiseTasks);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.access.baseconfig.dao.EidImageInfosDAO
 * JD-Core Version:    0.7.0.1
 */