package com.zte.evs.ebill.business.eBillManage;

import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesV;
import com.zte.evs.ebill.access.eBillManage.IEvsAllotRelationsDAO;
import com.zte.evs.ebill.access.eBillManage.IEvsAllotTypesDAO;
import com.zte.evs.ebill.access.eBillManage.IEvsArchivesSitesDAO;
import com.zte.evs.ebill.common.EvsObjectUtils;
import com.zte.evs.ebill.model.eBillManage.EvsAllotRelations;
import com.zte.evs.ebill.model.eBillManage.EvsAllotRelationsV;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.util.Util;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class EvsAllotRelationsService
  implements IEvsAllotRelationsService
{
  private EvsObjectUtils evsObjectUtils;
  private IEvsAllotRelationsDAO allotRelationsDAO;
  private IEvsAllotTypesDAO allotTypesDAO;
  private IEvsArchivesSitesDAO archivesSitesDAO;
  
  public TableDataInfo getAllotRelationsVQuery(EvsAllotRelationsV paramEvsAllotRelationsV, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    Map localMap = this.allotRelationsDAO.findAllotRelationsVByQry(paramEvsAllotRelationsV, paramInt1, paramInt2);
    localTableDataInfo.setData((List)localMap.get("data"));
    localTableDataInfo.setTotalCount(Integer.parseInt(localMap.get("totalCount").toString()));
    return localTableDataInfo;
  }
  
  public EvsAllotRelationsV getAllotRelationsVById(String paramString)
  {
    if ((paramString != null) && (!paramString.trim().equals("")))
    {
      Long localLong = Long.valueOf(Long.parseLong(paramString));
      return this.allotRelationsDAO.findAllotRelationsVById(localLong);
    }
    return null;
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public String updateAllotRelation(EvsAllotRelationsV paramEvsAllotRelationsV)
  {
    if ((null == paramEvsAllotRelationsV) || (Util.isNullObject(paramEvsAllotRelationsV.getAllotRelationId())) || (Util.isNullObject(paramEvsAllotRelationsV.getAllotTypeId())) || (Util.isNullObject(paramEvsAllotRelationsV.getArchivesSiteId())) || (Util.isStrEmpty(paramEvsAllotRelationsV.getSourceCheckUnit())) || (Util.isStrEmpty(paramEvsAllotRelationsV.getStoreName())) || (Util.isStrEmpty(paramEvsAllotRelationsV.getEnabledFlag()))) {
      return null;
    }
    try
    {
      int i = 0;
      if ((paramEvsAllotRelationsV.getAllotRelationId() != null) && (!paramEvsAllotRelationsV.getAllotRelationId().equals("")))
      {
        i = this.allotRelationsDAO.getCountByTerm(paramEvsAllotRelationsV.getAllotRelationId(), paramEvsAllotRelationsV.getAllotTypeId(), paramEvsAllotRelationsV.getSourceCheckUnit().trim(), paramEvsAllotRelationsV.getStoreCheckUnit().trim(), paramEvsAllotRelationsV.getArchivesSiteId());
        if (i != 0) {
          return "1";
        }
        if ("Y".equals(paramEvsAllotRelationsV.getEnabledFlag()))
        {
          if (!this.allotTypesDAO.canEmployTypeById(paramEvsAllotRelationsV.getAllotTypeId())) {
            return "2";
          }
          if (!this.archivesSitesDAO.canEmploySiteById(paramEvsAllotRelationsV.getArchivesSiteId())) {
            return "3";
          }
        }
        EvsAllotRelations localEvsAllotRelations = this.allotRelationsDAO.findAllotRelationsById(paramEvsAllotRelationsV.getAllotRelationId());
        if (localEvsAllotRelations != null)
        {
          FbpEmployeesV localFbpEmployeesV = this.evsObjectUtils.getEmployeeBySession();
          localEvsAllotRelations.setAllotRelationId(paramEvsAllotRelationsV.getAllotRelationId());
          localEvsAllotRelations.setAllotTypeId(paramEvsAllotRelationsV.getAllotTypeId());
          localEvsAllotRelations.setSourceCheckUnit(paramEvsAllotRelationsV.getSourceCheckUnit().trim());
          localEvsAllotRelations.setStoreCheckUnit(paramEvsAllotRelationsV.getStoreCheckUnit().trim());
          localEvsAllotRelations.setArchivesSiteId(paramEvsAllotRelationsV.getArchivesSiteId());
          localEvsAllotRelations.setEnabledFlag(paramEvsAllotRelationsV.getEnabledFlag());
          localEvsAllotRelations.setLastUpdateLogin(Long.valueOf(Long.parseLong(localFbpEmployeesV.getEmployeeId().toString())));
          localEvsAllotRelations.setLastUpdatedBy(Long.valueOf(Long.parseLong(localFbpEmployeesV.getEmployeeId().toString())));
          localEvsAllotRelations.setLastUpdateDate(new Date());
          this.allotRelationsDAO.update(localEvsAllotRelations);
          return "0";
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public String saveallotRelation(EvsAllotRelationsV paramEvsAllotRelationsV)
  {
    try
    {
      int i = 0;
      if ((paramEvsAllotRelationsV != null) && (paramEvsAllotRelationsV.getAllotTypeId() != null) && (paramEvsAllotRelationsV.getSourceCheckUnit() != null) && (paramEvsAllotRelationsV.getStoreCheckUnit() != null) && (paramEvsAllotRelationsV.getArchivesSiteId() != null) && (paramEvsAllotRelationsV.getEnabledFlag() != null))
      {
        i = this.allotRelationsDAO.getCountByTerm(null, paramEvsAllotRelationsV.getAllotTypeId(), paramEvsAllotRelationsV.getSourceCheckUnit().trim(), paramEvsAllotRelationsV.getStoreCheckUnit().trim(), paramEvsAllotRelationsV.getArchivesSiteId());
        if (i != 0) {
          return "1";
        }
        FbpEmployeesV localFbpEmployeesV = this.evsObjectUtils.getEmployeeBySession();
        Date localDate = new Date();
        EvsAllotRelations localEvsAllotRelations = new EvsAllotRelations();
        localEvsAllotRelations.setAllotTypeId(paramEvsAllotRelationsV.getAllotTypeId());
        localEvsAllotRelations.setSourceCheckUnit(paramEvsAllotRelationsV.getSourceCheckUnit().trim());
        localEvsAllotRelations.setStoreCheckUnit(paramEvsAllotRelationsV.getStoreCheckUnit().trim());
        localEvsAllotRelations.setArchivesSiteId(paramEvsAllotRelationsV.getArchivesSiteId());
        localEvsAllotRelations.setEnabledFlag(paramEvsAllotRelationsV.getEnabledFlag());
        localEvsAllotRelations.setCreatedBy(Long.valueOf(Long.parseLong(localFbpEmployeesV.getEmployeeId().toString())));
        localEvsAllotRelations.setCreationDate(localDate);
        localEvsAllotRelations.setLastUpdateLogin(Long.valueOf(Long.parseLong(localFbpEmployeesV.getEmployeeId().toString())));
        localEvsAllotRelations.setLastUpdatedBy(Long.valueOf(Long.parseLong(localFbpEmployeesV.getEmployeeId().toString())));
        localEvsAllotRelations.setLastUpdateDate(localDate);
        this.allotRelationsDAO.save(localEvsAllotRelations);
        return "0";
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public IEvsAllotRelationsDAO getAllotRelationsDAO()
  {
    return this.allotRelationsDAO;
  }
  
  public void setAllotRelationsDAO(IEvsAllotRelationsDAO paramIEvsAllotRelationsDAO)
  {
    this.allotRelationsDAO = paramIEvsAllotRelationsDAO;
  }
  
  public EvsObjectUtils getEvsObjectUtils()
  {
    return this.evsObjectUtils;
  }
  
  public void setEvsObjectUtils(EvsObjectUtils paramEvsObjectUtils)
  {
    this.evsObjectUtils = paramEvsObjectUtils;
  }
  
  public IEvsAllotTypesDAO getAllotTypesDAO()
  {
    return this.allotTypesDAO;
  }
  
  public void setAllotTypesDAO(IEvsAllotTypesDAO paramIEvsAllotTypesDAO)
  {
    this.allotTypesDAO = paramIEvsAllotTypesDAO;
  }
  
  public IEvsArchivesSitesDAO getArchivesSitesDAO()
  {
    return this.archivesSitesDAO;
  }
  
  public void setArchivesSitesDAO(IEvsArchivesSitesDAO paramIEvsArchivesSitesDAO)
  {
    this.archivesSitesDAO = paramIEvsArchivesSitesDAO;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.eBillManage.EvsAllotRelationsService
 * JD-Core Version:    0.7.0.1
 */