package com.zte.report.dao;

import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.eas.organization.business.countcompanymanage.model.FbpCompanyV;
import com.zte.evs.ebill.common.EvsObjectUtils;
import com.zte.report.model.BillPostManagerReportV;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang.StringUtils;

public class BillPostManagerReportVDAO
  extends BaseDAO
  implements IBillPostManagerReportVDAO
{
  public List getBillPostManagerReportVs()
  {
    return super.getObjects(BillPostManagerReportV.class);
  }
  
  public List<BillPostManagerReportV> getBillPostManagerReportVs(int paramInt1, int paramInt2)
  {
    return super.getObjects(BillPostManagerReportV.class, paramInt1, paramInt2);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeBillPostManagerReportV(BillPostManagerReportV paramBillPostManagerReportV)
  {
    super.removeObject(paramBillPostManagerReportV);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertBillPostManagerReportV(BillPostManagerReportV paramBillPostManagerReportV)
  {
    super.insertObject(paramBillPostManagerReportV);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateBillPostManagerReportV(BillPostManagerReportV paramBillPostManagerReportV)
  {
    super.updateObject(paramBillPostManagerReportV);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertBillPostManagerReportVs(List<BillPostManagerReportV> paramList)
  {
    super.insertObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeBillPostManagerReportVs(List<BillPostManagerReportV> paramList)
  {
    super.removeObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateBillPostManagerReportVs(List<BillPostManagerReportV> paramList)
  {
    super.updateObjects(paramList);
  }
  
  public PageInfo findBillPostManagerReportV(BillPostManagerReportV paramBillPostManagerReportV, int paramInt1, int paramInt2)
  {
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    StringBuffer localStringBuffer = new StringBuffer("from BillPostManagerReportV t where 1=1");
    ArrayList localArrayList = new ArrayList();
    if (paramBillPostManagerReportV != null)
    {
      boolean bool = "Y".equals(paramBillPostManagerReportV.getIsLikeQuery());
      if (StringUtils.isNotEmpty(paramBillPostManagerReportV.getImageNumber())) {
        if (bool)
        {
          localStringBuffer.append(" and t.imageNumber like ?");
          localArrayList.add("%" + paramBillPostManagerReportV.getImageNumber() + "%");
        }
        else
        {
          localStringBuffer.append(" and t.imageNumber = ?");
          localArrayList.add(paramBillPostManagerReportV.getImageNumber());
        }
      }
      if (StringUtils.isNotEmpty(paramBillPostManagerReportV.getTaskNum())) {
        if (bool)
        {
          localStringBuffer.append(" and t.taskNum like ?");
          localArrayList.add("%" + paramBillPostManagerReportV.getTaskNum() + "%");
        }
        else
        {
          localStringBuffer.append(" and t.taskNum = ?");
          localArrayList.add(paramBillPostManagerReportV.getTaskNum());
        }
      }
      if (paramBillPostManagerReportV.getUploadEmployeeId() != null)
      {
        localStringBuffer.append(" and t.uploadEmployeeId = ?");
        localArrayList.add(paramBillPostManagerReportV.getUploadEmployeeId());
      }
      if (paramBillPostManagerReportV.getUploadDateBegin() != null)
      {
        localStringBuffer.append(" and t.uploadDate >= ?");
        localArrayList.add(paramBillPostManagerReportV.getUploadDateBegin());
      }
      if (paramBillPostManagerReportV.getUploadDateEnd() != null)
      {
        localStringBuffer.append(" and t.uploadDate <= ?");
        localArrayList.add(new Date(paramBillPostManagerReportV.getUploadDateEnd().getTime() + 86399999L));
      }
      if (paramBillPostManagerReportV.getCompanyId() != null)
      {
        localStringBuffer.append(" and t.companyId = ?");
        localArrayList.add(paramBillPostManagerReportV.getCompanyId());
      }
      if (paramBillPostManagerReportV.getOperationTypeId() != null)
      {
        localStringBuffer.append(" and t.operationTypeId = ?");
        localArrayList.add(paramBillPostManagerReportV.getOperationTypeId());
      }
      if (StringUtils.isNotEmpty(paramBillPostManagerReportV.getImageStatus()))
      {
        localStringBuffer.append(" and t.imageStatus = ?");
        localArrayList.add(paramBillPostManagerReportV.getImageStatus());
      }
      if (StringUtils.isNotEmpty(paramBillPostManagerReportV.getJournalNumBegin()))
      {
        localStringBuffer.append(" and t.journalNum >= ?");
        localArrayList.add(paramBillPostManagerReportV.getJournalNumBegin());
      }
      if (StringUtils.isNotEmpty(paramBillPostManagerReportV.getJournalNumEnd()))
      {
        localStringBuffer.append(" and t.journalNum <= ?");
        localArrayList.add(paramBillPostManagerReportV.getJournalNumEnd());
      }
      if (paramBillPostManagerReportV.getJournalDateBegin() != null)
      {
        localStringBuffer.append(" and t.journalDate >= ?");
        localArrayList.add(paramBillPostManagerReportV.getJournalDateBegin());
      }
      if (paramBillPostManagerReportV.getJournalDateEnd() != null)
      {
        localStringBuffer.append(" and t.journalDate <= ?");
        localArrayList.add(new Date(paramBillPostManagerReportV.getJournalDateEnd().getTime() + 86399999L));
      }
    }
    if ((localEasUserInfo != null) && (!"10000".equals(localEasUserInfo.getUserId())))
    {
      localStringBuffer.append(" and exists(select 1 from FbpPseRelationsV fpr where fpr.operationTypeId = t.operationTypeId and fpr.companyId = t.companyId and fpr.posStructureCode = ? and fpr.employeeId = ?)");
      localArrayList.add("IMAGE_QUERY");
      localArrayList.add(Long.valueOf(localEasUserInfo.getUserInfoPk().longValue()));
    }
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1 / paramInt2 + 1, paramInt2, localArrayList.toArray());
    return localPageInfo;
  }
  
  public PageInfo findAllCompanys(FbpCompanyV paramFbpCompanyV, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    String str = "from FbpCompanyV o where o.enabledFlag = 'Y'";
    if ((paramFbpCompanyV.getCompanyName() != null) && (!"".equals(paramFbpCompanyV.getCompanyName())))
    {
      str = str + " and o.companyName like ?";
      localArrayList.add("%" + paramFbpCompanyV.getCompanyName() + "%");
    }
    if ((paramFbpCompanyV.getCompanyCode() != null) && (!"".equals(paramFbpCompanyV.getCompanyCode())))
    {
      str = str + " and o.companyCode like ?";
      localArrayList.add("%" + paramFbpCompanyV.getCompanyCode() + "%");
    }
    paramInt1 = paramInt1 / paramInt2 + 1;
    PageInfo localPageInfo = super.PageInfoQuery(str, paramInt1, paramInt2, localArrayList.toArray());
    return localPageInfo;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.report.dao.BillPostManagerReportVDAO
 * JD-Core Version:    0.7.0.1
 */