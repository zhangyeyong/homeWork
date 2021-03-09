package com.zte.eimage.access.baseconfig.dao;

import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.eimage.business.baseconfig.model.FbpVoucherApproveV;
import com.zte.eimage.business.baseconfig.model.FbpVoucherApproveVL;
import com.zte.evs.ebill.common.EvsObjectUtils;
import com.zte.evs.ebill.model.archives.FbpArchivesHeaders;
import com.zte.evs.ebill.model.archives.FbpArchivesHistories;
import com.zte.evs.ebill.model.archives.FbpArchivesLines;
import com.zte.evs.ebill.model.eBillManage.EvsStorageDocV;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.util.Util;
import com.zte.ssb.orm.zorm.ZormTemplate;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import com.zte.ssb.zorm.Query;
import com.zte.ssb.zorm.SQLQuery;
import com.zte.ssb.zorm.Session;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FbpVoucherApproveVDAO
  extends BaseDAO
  implements IFbpVoucherApproveVDAO
{
  public FbpArchivesHeaders getFbpVoucherApproveV(Long paramLong)
  {
    return (FbpArchivesHeaders)super.getObject(FbpArchivesHeaders.class, paramLong);
  }
  
  public List<FbpVoucherApproveV> getFbpVoucherApproveVs()
  {
    return super.getObjects(FbpVoucherApproveV.class);
  }
  
  public PageInfo getFbpVoucherApproveVs(FbpVoucherApproveV paramFbpVoucherApproveV, int paramInt1, int paramInt2)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    String str = localEasUserInfo.getUserId();
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList();
    localStringBuffer.append(" from FbpVoucherApproveV fv where 1=1");
    if ("Y".equals(paramFbpVoucherApproveV.getCheckFlags()))
    {
      if (!Util.isNullObject(paramFbpVoucherApproveV.getApplyNum()))
      {
        localStringBuffer.append(" and fv.applyNum like ?");
        localArrayList.add("%" + paramFbpVoucherApproveV.getApplyNum() + "%");
      }
      if (!Util.isNullObject(paramFbpVoucherApproveV.getApplyDate()))
      {
        localStringBuffer.append(" and to_char(fv.applyDate,'yyyy-MM-dd') = to_char(?,'yyyy-MM-dd')");
        localArrayList.add(paramFbpVoucherApproveV.getApplyDate());
      }
      if (!Util.isNullObject(paramFbpVoucherApproveV.getCompanyId()))
      {
        localStringBuffer.append(" and fv.companyId like ?");
        localArrayList.add("%" + paramFbpVoucherApproveV.getCompanyId() + "%");
      }
      if (!Util.isNullObject(paramFbpVoucherApproveV.getEmployeeId()))
      {
        localStringBuffer.append(" and fv.employeeId like ?");
        localArrayList.add("%" + paramFbpVoucherApproveV.getEmployeeId() + "%");
      }
    }
    else
    {
      if (!Util.isNullObject(paramFbpVoucherApproveV.getApplyNum()))
      {
        localStringBuffer.append(" and fv.applyNum = ?");
        localArrayList.add(paramFbpVoucherApproveV.getApplyNum());
      }
      if (!Util.isNullObject(paramFbpVoucherApproveV.getApplyDate()))
      {
        localStringBuffer.append(" and to_char(fv.applyDate,'yyyy-MM-dd') = to_char(?,'yyyy-MM-dd')");
        localArrayList.add(paramFbpVoucherApproveV.getApplyDate());
      }
      if (!Util.isNullObject(paramFbpVoucherApproveV.getCompanyId()))
      {
        localStringBuffer.append(" and fv.companyId = ?");
        localArrayList.add(paramFbpVoucherApproveV.getCompanyId());
      }
      if (!Util.isNullObject(paramFbpVoucherApproveV.getEmployeeId()))
      {
        localStringBuffer.append(" and fv.employeeId = ?");
        localArrayList.add(paramFbpVoucherApproveV.getEmployeeId());
      }
    }
    localStringBuffer.append(" order by fv.applyDate desc");
    paramInt1 = paramInt1 / paramInt2 + 1;
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1, paramInt2, localArrayList.toArray());
    return localPageInfo;
  }
  
  public PageInfo getFbpVoucherApproveVs(FbpVoucherApproveVL paramFbpVoucherApproveVL, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList();
    localStringBuffer.append(" from FbpVoucherApproveVL fv where 1=1");
    if (!Util.isNullObject(paramFbpVoucherApproveVL.getApplyNum()))
    {
      localStringBuffer.append(" and fv.applyNum = ?");
      localArrayList.add(paramFbpVoucherApproveVL.getApplyNum());
    }
    if (!Util.isNullObject(paramFbpVoucherApproveVL.getCreationDate()))
    {
      localStringBuffer.append(" and fv.creationDate >= ?");
      localArrayList.add(paramFbpVoucherApproveVL.getCreationDate());
    }
    if (!Util.isNullObject(paramFbpVoucherApproveVL.getCreationDateEnd()))
    {
      localStringBuffer.append(" and fv.creationDate <= ?");
      localArrayList.add(paramFbpVoucherApproveVL.getCreationDateEnd());
    }
    if (!Util.isNullObject(paramFbpVoucherApproveVL.getCompanyId()))
    {
      localStringBuffer.append(" and fv.companyId = ?");
      localArrayList.add(paramFbpVoucherApproveVL.getCompanyId());
    }
    if (!Util.isNullObject(paramFbpVoucherApproveVL.getEmployeeId()))
    {
      localStringBuffer.append(" and fv.employeeId = ?");
      localArrayList.add(paramFbpVoucherApproveVL.getEmployeeId());
    }
    localStringBuffer.append(" order by fv.applyNum desc");
    paramInt1 = paramInt1 / paramInt2 + 1;
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1, paramInt2, localArrayList.toArray());
    return localPageInfo;
  }
  
  public String getObjectList(Long paramLong)
  {
    String str1 = "select fc.employee_number from fbp.fbp_company fc,fbp.fbp_employees fe where fc.employee_number = fe.employee_number and fc.enabled_flag = 'Y' and fe.enabled_flag = 'Y' and fc.company_id = '" + paramLong + "'";
    List localList = getSession().createSQLQuery(str1).list();
    Iterator localIterator = localList.iterator();
    if (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      return str2;
    }
    return "";
  }
  
  public boolean getFbpArchivesHistories(FbpVoucherApproveV paramFbpVoucherApproveV)
  {
    String str = " from FbpArchivesHistories fis where fis.archivesHeaderId = " + paramFbpVoucherApproveV.getArchivesHeaderId();
    List localList = getSession().createQuery(str).list();
    return localList.size() > 0;
  }
  
  public String findApproveEmpl(String paramString)
  {
    String str = " select fel.first_line_no from fbp.fbp_employee_leaders fel where fel.employee_number = '" + paramString + "'";
    List localList = getSession().createSQLQuery(str).list();
    if ((localList != null) && (localList.size() > 0)) {
      return (String)localList.get(0);
    }
    return null;
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpVoucherApproveV(FbpVoucherApproveV paramFbpVoucherApproveV)
  {
    super.removeObject(paramFbpVoucherApproveV);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertFbpVoucherApproveV(FbpArchivesHistories paramFbpArchivesHistories)
  {
    super.insertObject(paramFbpArchivesHistories);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateFbpVoucherApproveV(FbpArchivesHeaders paramFbpArchivesHeaders)
  {
    ArrayList localArrayList = new ArrayList();
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("update fbp.fbp_archives_headers fah set fah.archives_status='" + paramFbpArchivesHeaders.getArchivesStatus() + "'");
    localStringBuffer.append(",fah.VERIFY_STATUS='" + paramFbpArchivesHeaders.getVerifyStatus() + "'");
    if (!Util.isNullObject(paramFbpArchivesHeaders.getAttribute2())) {
      localStringBuffer.append(",fah.GIVE_BACK_DATE=to_date('" + paramFbpArchivesHeaders.getAttribute2() + "','yyyy-MM-dd')");
    }
    localStringBuffer.append(",fah.ATTRIBUTE3='" + paramFbpArchivesHeaders.getAttribute3() + "' where fah.archives_header_id='" + paramFbpArchivesHeaders.getArchivesHeaderId() + "'");
    getSession().createSQLQuery(localStringBuffer.toString()).executeUpdate();
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertFbpVoucherApproveVs(List<FbpArchivesHistories> paramList)
  {
    super.insertObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpVoucherApproveVs(List<FbpVoucherApproveV> paramList)
  {
    super.removeObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateFbpVoucherApproveVs(List<FbpArchivesHeaders> paramList)
  {
    super.updateObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpVoucherApproveV(Long paramLong)
  {
    super.removeObject(FbpVoucherApproveV.class, paramLong);
  }
  
  public List<FbpArchivesLines> getFbpVoucherAll(Long paramLong)
  {
    String str = " from FbpArchivesLines fal where fal.archivesHeaderId = '" + paramLong + "'";
    return getZormTemplate().find(str);
  }
  
  public List<EvsStorageDocV> getEvsStorageDocV(EvsStorageDocV paramEvsStorageDocV)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList();
    localStringBuffer.append("from EvsStorageDocV es where 1=1");
    if (!Util.isStrEmpty(paramEvsStorageDocV.getStorageCode()))
    {
      localStringBuffer.append(" and es.storageCode = ?");
      localArrayList.add(paramEvsStorageDocV.getStorageCode());
    }
    if (!Util.isStrEmpty(paramEvsStorageDocV.getStorageName()))
    {
      localStringBuffer.append(" and es.storageName = ?");
      localArrayList.add(paramEvsStorageDocV.getStorageName());
    }
    if (!Util.isNullObject(paramEvsStorageDocV.getCompanyId()))
    {
      localStringBuffer.append(" and es.companyId = ?");
      localArrayList.add(paramEvsStorageDocV.getCompanyId());
    }
    if (!Util.isNullObject(paramEvsStorageDocV.getCityId()))
    {
      localStringBuffer.append(" and es.cityId = ?");
      localArrayList.add(paramEvsStorageDocV.getCityId());
    }
    if (!Util.isNullObject(paramEvsStorageDocV.getDocAdminId()))
    {
      localStringBuffer.append(" and exists( from EvsDocAdmin eda where es.storageId = eda.storageId and eda.docAdminId = ? )");
      localArrayList.add(Long.valueOf(paramEvsStorageDocV.getDocAdminId()));
    }
    if (!Util.isNullObject(paramEvsStorageDocV.getState()))
    {
      localStringBuffer.append(" and es.state = ?");
      localArrayList.add(paramEvsStorageDocV.getState());
    }
    return getZormTemplate().find(localStringBuffer.toString(), localArrayList.toArray());
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.access.baseconfig.dao.FbpVoucherApproveVDAO
 * JD-Core Version:    0.7.0.1
 */