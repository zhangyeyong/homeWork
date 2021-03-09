package com.zte.evs.ebill.business.eBillManage;

import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesV;
import com.zte.evs.ebill.access.eBillManage.IEvsAllotRelationsDAO;
import com.zte.evs.ebill.access.eBillManage.IEvsAllotTypesDAO;
import com.zte.evs.ebill.common.EvsObjectUtils;
import com.zte.evs.ebill.model.eBillManage.EvsAllotTypes;
import com.zte.evs.ebill.model.eBillManage.EvsAllotTypesV;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.util.Util;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class EvsAllotTypesService
  implements IEvsAllotTypesService
{
  private EvsObjectUtils evsObjectUtils;
  private IEvsAllotTypesDAO allotTypesDAO;
  private IEvsAllotRelationsDAO allotRelationsDAO;
  
  public TableDataInfo getAllotTypesVQuery(EvsAllotTypesV paramEvsAllotTypesV, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    Map localMap = this.allotTypesDAO.findAllotTypesVByQry(paramEvsAllotTypesV, paramInt1, paramInt2);
    localTableDataInfo.setData((List)localMap.get("data"));
    localTableDataInfo.setTotalCount(Integer.parseInt(localMap.get("totalCount").toString()));
    return localTableDataInfo;
  }
  
  public EvsAllotTypesV getAllotTypeVById(String paramString)
  {
    if ((paramString != null) && (!paramString.trim().equals("")))
    {
      Long localLong = Long.valueOf(Long.parseLong(paramString));
      return this.allotTypesDAO.findAllotTypeVById(localLong);
    }
    return null;
  }
  
  public boolean isExistAllotTypeByCode(String paramString)
  {
    boolean bool = false;
    if (this.allotTypesDAO.findAllotTypeByCode(paramString, null) != null) {
      bool = true;
    }
    return bool;
  }
  
  public boolean isExistAllotTypeByCode(String paramString1, String paramString2)
  {
    boolean bool = false;
    if (this.allotTypesDAO.findAllotTypeByCode(paramString1, paramString2) != null) {
      bool = true;
    }
    return bool;
  }
  
  public boolean isExistAllotTypeByName(String paramString)
  {
    boolean bool = false;
    if (this.allotTypesDAO.findAllotTypeByName(paramString, null) != null) {
      bool = true;
    }
    return bool;
  }
  
  public boolean isExistAllotTypeByName(String paramString1, String paramString2)
  {
    boolean bool = false;
    if (this.allotTypesDAO.findAllotTypeByName(paramString1, paramString2) != null) {
      bool = true;
    }
    return bool;
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public String updateAllotType(EvsAllotTypesV paramEvsAllotTypesV)
  {
    int i = 0;
    if ((null == paramEvsAllotTypesV) || (Util.isNullObject(paramEvsAllotTypesV.getAllotTypeId())) || (Util.isStrEmpty(paramEvsAllotTypesV.getAllotTypeCode())) || (Util.isStrEmpty(paramEvsAllotTypesV.getAllotTypeName())) || (Util.isStrEmpty(paramEvsAllotTypesV.getAllotWay())) || (Util.isStrEmpty(paramEvsAllotTypesV.getEnabledFlag()))) {
      return null;
    }
    try
    {
      EvsAllotTypes localEvsAllotTypes = this.allotTypesDAO.findAllotTypeById(paramEvsAllotTypesV.getAllotTypeId());
      if (localEvsAllotTypes != null)
      {
        if (!localEvsAllotTypes.getAllotTypeName().equals(paramEvsAllotTypesV.getAllotTypeName().trim()))
        {
          i = this.allotTypesDAO.getCountByName(paramEvsAllotTypesV.getAllotTypeName().trim());
          if (i != 0) {
            return "1";
          }
        }
        if (!"Y".equals(paramEvsAllotTypesV.getEnabledFlag()))
        {
          i = this.allotRelationsDAO.getCountByTypeId(paramEvsAllotTypesV.getAllotTypeId());
          if (i != 0) {
            return "2";
          }
        }
        FbpEmployeesV localFbpEmployeesV = this.evsObjectUtils.getEmployeeBySession();
        localEvsAllotTypes.setAllotTypeId(paramEvsAllotTypesV.getAllotTypeId());
        localEvsAllotTypes.setAllotTypeCode(paramEvsAllotTypesV.getAllotTypeCode().trim());
        localEvsAllotTypes.setAllotTypeName(paramEvsAllotTypesV.getAllotTypeName().trim());
        localEvsAllotTypes.setAllotWay(paramEvsAllotTypesV.getAllotWay());
        localEvsAllotTypes.setEnabledFlag(paramEvsAllotTypesV.getEnabledFlag());
        localEvsAllotTypes.setDescription(paramEvsAllotTypesV.getDescription().trim());
        localEvsAllotTypes.setLastUpdateLogin(Long.valueOf(Long.parseLong(localFbpEmployeesV.getEmployeeId().toString())));
        localEvsAllotTypes.setLastUpdatedBy(Long.valueOf(Long.parseLong(localFbpEmployeesV.getEmployeeId().toString())));
        localEvsAllotTypes.setLastUpdateDate(new Date());
        this.allotTypesDAO.update(localEvsAllotTypes);
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
  public String saveAllotType(EvsAllotTypesV paramEvsAllotTypesV)
  {
    try
    {
      int i = 0;
      if ((paramEvsAllotTypesV != null) && (paramEvsAllotTypesV.getAllotTypeCode() != null) && (paramEvsAllotTypesV.getAllotTypeName() != null) && (paramEvsAllotTypesV.getAllotWay() != null) && (paramEvsAllotTypesV.getDescription() != null))
      {
        i = this.allotTypesDAO.getCountByCode(paramEvsAllotTypesV.getAllotTypeCode().trim());
        if (i != 0) {
          return "1";
        }
        i = this.allotTypesDAO.getCountByName(paramEvsAllotTypesV.getAllotTypeName().trim());
        if (i != 0) {
          return "2";
        }
        FbpEmployeesV localFbpEmployeesV = this.evsObjectUtils.getEmployeeBySession();
        Date localDate = new Date();
        EvsAllotTypes localEvsAllotTypes = new EvsAllotTypes();
        localEvsAllotTypes.setAllotTypeId(paramEvsAllotTypesV.getAllotTypeId());
        localEvsAllotTypes.setAllotTypeCode(paramEvsAllotTypesV.getAllotTypeCode().trim());
        localEvsAllotTypes.setAllotTypeName(paramEvsAllotTypesV.getAllotTypeName().trim());
        localEvsAllotTypes.setAllotWay(paramEvsAllotTypesV.getAllotWay());
        localEvsAllotTypes.setEnabledFlag(paramEvsAllotTypesV.getEnabledFlag());
        localEvsAllotTypes.setDescription(paramEvsAllotTypesV.getDescription().trim());
        localEvsAllotTypes.setCreatedBy(Long.valueOf(Long.parseLong(localFbpEmployeesV.getEmployeeId().toString())));
        localEvsAllotTypes.setCreationDate(localDate);
        localEvsAllotTypes.setLastUpdateLogin(Long.valueOf(Long.parseLong(localFbpEmployeesV.getEmployeeId().toString())));
        localEvsAllotTypes.setLastUpdatedBy(Long.valueOf(Long.parseLong(localFbpEmployeesV.getEmployeeId().toString())));
        localEvsAllotTypes.setLastUpdateDate(localDate);
        this.allotTypesDAO.save(localEvsAllotTypes);
        return "0";
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public IEvsAllotTypesDAO getAllotTypesDAO()
  {
    return this.allotTypesDAO;
  }
  
  public void setAllotTypesDAO(IEvsAllotTypesDAO paramIEvsAllotTypesDAO)
  {
    this.allotTypesDAO = paramIEvsAllotTypesDAO;
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
 * Qualified Name:     com.zte.evs.ebill.business.eBillManage.EvsAllotTypesService
 * JD-Core Version:    0.7.0.1
 */