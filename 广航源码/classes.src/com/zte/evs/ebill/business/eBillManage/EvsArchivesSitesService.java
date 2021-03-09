package com.zte.evs.ebill.business.eBillManage;

import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesV;
import com.zte.evs.ebill.access.eBillManage.IEvsAllotRelationsDAO;
import com.zte.evs.ebill.access.eBillManage.IEvsArchivesSitesDAO;
import com.zte.evs.ebill.common.EvsObjectUtils;
import com.zte.evs.ebill.model.eBillManage.EvsArchivesSites;
import com.zte.evs.ebill.model.eBillManage.EvsArchivesSitesV;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.util.Util;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class EvsArchivesSitesService
  implements IEvsArchivesSitesService
{
  private EvsObjectUtils evsObjectUtils;
  private IEvsArchivesSitesDAO archivesSitesDAO;
  private IEvsAllotRelationsDAO allotRelationsDAO;
  
  public TableDataInfo getArchivesSitesVQuery(EvsArchivesSitesV paramEvsArchivesSitesV, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    Map localMap = this.archivesSitesDAO.findArchivesSitesVByQry(paramEvsArchivesSitesV, paramInt1, paramInt2);
    localTableDataInfo.setData((List)localMap.get("data"));
    localTableDataInfo.setTotalCount(Integer.parseInt(localMap.get("totalCount").toString()));
    return localTableDataInfo;
  }
  
  public EvsArchivesSitesV getArchivesSitesVById(String paramString)
  {
    if ((paramString != null) && (!paramString.trim().equals("")))
    {
      Long localLong = Long.valueOf(Long.parseLong(paramString));
      return this.archivesSitesDAO.findArchivesSitesVById(localLong);
    }
    return null;
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public String updateArchivesSite(EvsArchivesSitesV paramEvsArchivesSitesV)
  {
    if ((null == paramEvsArchivesSitesV) || (Util.isNullObject(paramEvsArchivesSitesV.getArchivesSiteId())) || (Util.isStrEmpty(paramEvsArchivesSitesV.getArchivesSiteCode())) || (Util.isStrEmpty(paramEvsArchivesSitesV.getArchivesSiteName())) || (Util.isStrEmpty(paramEvsArchivesSitesV.getAddress())) || (Util.isStrEmpty(paramEvsArchivesSitesV.getProperty())) || (Util.isStrEmpty(paramEvsArchivesSitesV.getCheckUnit())) || (Util.isStrEmpty(paramEvsArchivesSitesV.getEnabledFlag()))) {
      return null;
    }
    try
    {
      int i = 0;
      EvsArchivesSites localEvsArchivesSites = this.archivesSitesDAO.findArchivesSitesById(paramEvsArchivesSitesV.getArchivesSiteId());
      if (localEvsArchivesSites != null)
      {
        if (!localEvsArchivesSites.getArchivesSiteName().equals(paramEvsArchivesSitesV.getArchivesSiteName().trim()))
        {
          i = this.archivesSitesDAO.getCountByName(paramEvsArchivesSitesV.getArchivesSiteName().trim());
          if (i != 0) {
            return "1";
          }
        }
        if (!"Y".equals(paramEvsArchivesSitesV.getEnabledFlag()))
        {
          i = this.allotRelationsDAO.getCountBySiteId(paramEvsArchivesSitesV.getArchivesSiteId());
          if (i != 0) {
            return "2";
          }
        }
        FbpEmployeesV localFbpEmployeesV = this.evsObjectUtils.getEmployeeBySession();
        localEvsArchivesSites.setArchivesSiteId(paramEvsArchivesSitesV.getArchivesSiteId());
        localEvsArchivesSites.setArchivesSiteCode(paramEvsArchivesSitesV.getArchivesSiteCode().trim());
        localEvsArchivesSites.setArchivesSiteName(paramEvsArchivesSitesV.getArchivesSiteName().trim());
        localEvsArchivesSites.setAddress(paramEvsArchivesSitesV.getAddress().trim());
        localEvsArchivesSites.setProperty(paramEvsArchivesSitesV.getProperty());
        localEvsArchivesSites.setCheckUnit(paramEvsArchivesSitesV.getCheckUnit());
        localEvsArchivesSites.setVendorId(paramEvsArchivesSitesV.getVendorId());
        localEvsArchivesSites.setEnabledFlag(paramEvsArchivesSitesV.getEnabledFlag());
        localEvsArchivesSites.setDescription(paramEvsArchivesSitesV.getDescription().trim());
        localEvsArchivesSites.setLastUpdateLogin(Long.valueOf(Long.parseLong(localFbpEmployeesV.getEmployeeId().toString())));
        localEvsArchivesSites.setLastUpdatedBy(Long.valueOf(Long.parseLong(localFbpEmployeesV.getEmployeeId().toString())));
        localEvsArchivesSites.setLastUpdateDate(new Date());
        this.archivesSitesDAO.update(localEvsArchivesSites);
        return "0";
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public String saveArchivesSite(EvsArchivesSitesV paramEvsArchivesSitesV)
  {
    try
    {
      int i = 0;
      if ((paramEvsArchivesSitesV != null) && (paramEvsArchivesSitesV.getArchivesSiteCode() != null) && (paramEvsArchivesSitesV.getArchivesSiteName() != null) && (paramEvsArchivesSitesV.getCheckUnit() != null) && (paramEvsArchivesSitesV.getAddress() != null) && (paramEvsArchivesSitesV.getProperty() != null) && (paramEvsArchivesSitesV.getEnabledFlag() != null))
      {
        i = this.archivesSitesDAO.getCountByCode(paramEvsArchivesSitesV.getArchivesSiteCode().trim());
        if (i != 0) {
          return "1";
        }
        i = this.archivesSitesDAO.getCountByName(paramEvsArchivesSitesV.getArchivesSiteName().trim());
        if (i != 0) {
          return "2";
        }
        FbpEmployeesV localFbpEmployeesV = this.evsObjectUtils.getEmployeeBySession();
        Date localDate = new Date();
        EvsArchivesSites localEvsArchivesSites = new EvsArchivesSites();
        localEvsArchivesSites.setArchivesSiteCode(paramEvsArchivesSitesV.getArchivesSiteCode().trim());
        localEvsArchivesSites.setArchivesSiteName(paramEvsArchivesSitesV.getArchivesSiteName().trim());
        localEvsArchivesSites.setAddress(paramEvsArchivesSitesV.getAddress().trim());
        localEvsArchivesSites.setProperty(paramEvsArchivesSitesV.getProperty());
        localEvsArchivesSites.setCheckUnit(paramEvsArchivesSitesV.getCheckUnit());
        localEvsArchivesSites.setVendorId(paramEvsArchivesSitesV.getVendorId());
        localEvsArchivesSites.setEnabledFlag(paramEvsArchivesSitesV.getEnabledFlag());
        localEvsArchivesSites.setDescription(paramEvsArchivesSitesV.getDescription().trim());
        localEvsArchivesSites.setCreatedBy(Long.valueOf(Long.parseLong(localFbpEmployeesV.getEmployeeId().toString())));
        localEvsArchivesSites.setCreationDate(localDate);
        localEvsArchivesSites.setLastUpdateLogin(Long.valueOf(Long.parseLong(localFbpEmployeesV.getEmployeeId().toString())));
        localEvsArchivesSites.setLastUpdatedBy(Long.valueOf(Long.parseLong(localFbpEmployeesV.getEmployeeId().toString())));
        localEvsArchivesSites.setLastUpdateDate(localDate);
        this.archivesSitesDAO.save(localEvsArchivesSites);
        return "0";
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public IEvsArchivesSitesDAO getArchivesSitesDAO()
  {
    return this.archivesSitesDAO;
  }
  
  public void setArchivesSitesDAO(IEvsArchivesSitesDAO paramIEvsArchivesSitesDAO)
  {
    this.archivesSitesDAO = paramIEvsArchivesSitesDAO;
  }
  
  public EvsObjectUtils getEvsObjectUtils()
  {
    return this.evsObjectUtils;
  }
  
  public void setEvsObjectUtils(EvsObjectUtils paramEvsObjectUtils)
  {
    this.evsObjectUtils = paramEvsObjectUtils;
  }
  
  public IEvsAllotRelationsDAO getAllotRelationsDAO()
  {
    return this.allotRelationsDAO;
  }
  
  public void setAllotRelationsDAO(IEvsAllotRelationsDAO paramIEvsAllotRelationsDAO)
  {
    this.allotRelationsDAO = paramIEvsAllotRelationsDAO;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.eBillManage.EvsArchivesSitesService
 * JD-Core Version:    0.7.0.1
 */