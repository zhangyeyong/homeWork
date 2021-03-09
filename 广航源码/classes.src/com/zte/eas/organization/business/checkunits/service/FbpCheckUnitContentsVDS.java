package com.zte.eas.organization.business.checkunits.service;

import com.zte.eas.appframe.business.util.ObjectCopyUtils;
import com.zte.eas.organization.access.checkunits.dao.IFbpCheckUnitContentsDAO;
import com.zte.eas.organization.access.checkunits.dao.IFbpCheckUnitContentsVDAO;
import com.zte.eas.organization.business.checkunits.model.FbpCheckUnitContents;
import com.zte.eas.organization.business.checkunits.model.FbpCheckUnitContentsV;
import com.zte.eas.organization.business.organizationmanage.model.FbpDepts;
import com.zte.eas.organization.business.organizationmanage.model.FbpDeptsV;
import com.zte.eas.organization.business.organizationmanage.service.IFbpDeptsVDS;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.BaseDomainService;
import com.zte.ssb.framework.base.util.PageInfo;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;

public class FbpCheckUnitContentsVDS
  extends BaseDomainService
  implements IFbpCheckUnitContentsVDS
{
  private IFbpCheckUnitContentsVDAO fbpCheckunitContentsVDAO;
  private IFbpCheckUnitContentsDAO fbpCheckUnitContentsDAO;
  private IFbpDeptsVDS fbpDeptsVDS;
  static final String LOGIN_USERINFO = "loginuserinfo";
  static final String INSERTSUCCEED = "INSERTSUCCEED";
  static final String UPDATESUCCEED = "UPDATESUCCEED";
  static final String SAVEFAIL = "SAVEFAIL";
  static final String ISUSER = "Y";
  static final String DO = "启用";
  static final String BAN = "禁用";
  static final String SAMECODE = "SAMECODE";
  static final String SAMENAME = "SAMENAME";
  
  public String saveCheckUnitContentsV(FbpCheckUnitContentsV paramFbpCheckUnitContentsV)
  {
    FbpCheckUnitContents localFbpCheckUnitContents = new FbpCheckUnitContents();
    ObjectCopyUtils.setWho(localFbpCheckUnitContents);
    if ((paramFbpCheckUnitContentsV.getContentId() != null) && (paramFbpCheckUnitContentsV.getContentId().longValue() != 0L)) {
      localFbpCheckUnitContents.setContentId(paramFbpCheckUnitContentsV.getContentId());
    }
    localFbpCheckUnitContents.setErpOrgId(paramFbpCheckUnitContentsV.getErpOrgId());
    localFbpCheckUnitContents.setOrgId(paramFbpCheckUnitContentsV.getOrgId());
    localFbpCheckUnitContents.setErpOrgName(paramFbpCheckUnitContentsV.getErpOrgName());
    localFbpCheckUnitContents.setEnabledFlag(paramFbpCheckUnitContentsV.getEnabledFlag());
    localFbpCheckUnitContents.setCheckUnit(paramFbpCheckUnitContentsV.getCheckUnit());
    localFbpCheckUnitContents.setCheckUnitName(paramFbpCheckUnitContentsV.getCheckUnitName());
    localFbpCheckUnitContents.setAttribute1(paramFbpCheckUnitContentsV.getAttribute1());
    this.fbpDeptsVDS = ((IFbpDeptsVDS)SSBBus.findCommonService("fbpDeptsVDS"));
    try
    {
      if ((paramFbpCheckUnitContentsV.getContentId() == null) || (paramFbpCheckUnitContentsV.getContentId().longValue() == 0L))
      {
        if (!checkCode(paramFbpCheckUnitContentsV.getCheckUnit())) {
          return "SAMECODE";
        }
        if (!checkName(paramFbpCheckUnitContentsV.getCheckUnitName())) {
          return "SAMENAME";
        }
        this.fbpCheckUnitContentsDAO.insertFbpCheckUnitContents(localFbpCheckUnitContents);
        if ((localFbpCheckUnitContents != null) && (localFbpCheckUnitContents.getOrgId() != null)) {
          setDeptCheckUnit(new BigInteger(localFbpCheckUnitContents.getOrgId().toString()), localFbpCheckUnitContents.getCheckUnit() == null ? "" : localFbpCheckUnitContents.getCheckUnit());
        }
        return "INSERTSUCCEED";
      }
      FbpCheckUnitContentsV localFbpCheckUnitContentsV = this.fbpCheckunitContentsVDAO.findCheckUnitContentsVById(paramFbpCheckUnitContentsV.getContentId().longValue());
      if ((!paramFbpCheckUnitContentsV.getCheckUnit().equals(localFbpCheckUnitContentsV.getCheckUnit())) && (!checkCode(paramFbpCheckUnitContentsV.getCheckUnit()))) {
        return "SAMECODE";
      }
      if ((!paramFbpCheckUnitContentsV.getCheckUnitName().equals(localFbpCheckUnitContentsV.getCheckUnitName())) && (!checkName(paramFbpCheckUnitContentsV.getCheckUnitName()))) {
        return "SAMENAME";
      }
      this.fbpCheckUnitContentsDAO.updateFbpCheckUnitContents(localFbpCheckUnitContents);
      if ((localFbpCheckUnitContents != null) && (localFbpCheckUnitContents.getOrgId() != null)) {
        setDeptCheckUnit(new BigInteger(localFbpCheckUnitContents.getOrgId().toString()), localFbpCheckUnitContents.getCheckUnit() == null ? "" : localFbpCheckUnitContents.getCheckUnit());
      }
      return "UPDATESUCCEED";
    }
    catch (Exception localException) {}
    return "SAVEFAIL";
  }
  
  private void setDeptCheckUnit(BigInteger paramBigInteger, String paramString)
  {
    try
    {
      FbpDepts localFbpDepts = this.fbpDeptsVDS.getFbpDepts(paramBigInteger);
      if (localFbpDepts != null)
      {
        localFbpDepts.setDefaultCheckUnit(paramString);
        this.fbpDeptsVDS.updateFbpDepts(localFbpDepts);
        List localList = this.fbpDeptsVDS.findDownDeptsV(paramBigInteger);
        if ((localList != null) && (localList.size() > 0))
        {
          Iterator localIterator = localList.iterator();
          while (localIterator.hasNext())
          {
            FbpDeptsV localFbpDeptsV = (FbpDeptsV)localIterator.next();
            if ((localFbpDeptsV != null) && (localFbpDeptsV.getDeptId() != null)) {
              setDeptCheckUnit(localFbpDeptsV.getDeptId(), paramString);
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private boolean checkCode(String paramString)
  {
    FbpCheckUnitContentsV localFbpCheckUnitContentsV = new FbpCheckUnitContentsV();
    localFbpCheckUnitContentsV.setCheckUnit(paramString);
    localFbpCheckUnitContentsV.setCheckUnitName(null);
    PageInfo localPageInfo = this.fbpCheckunitContentsVDAO.findCheckUnitContentsVByCodeOrName(localFbpCheckUnitContentsV);
    List localList = (List)localPageInfo.getResult();
    return localList.size() <= 0;
  }
  
  private boolean checkName(String paramString)
  {
    FbpCheckUnitContentsV localFbpCheckUnitContentsV = new FbpCheckUnitContentsV();
    localFbpCheckUnitContentsV.setCheckUnit(null);
    localFbpCheckUnitContentsV.setCheckUnitName(paramString);
    PageInfo localPageInfo = this.fbpCheckunitContentsVDAO.findCheckUnitContentsVByCodeOrName(localFbpCheckUnitContentsV);
    List localList = (List)localPageInfo.getResult();
    return localList.size() <= 0;
  }
  
  public FbpCheckUnitContentsV findCheckUnitContentsVById(String paramString)
  {
    if (paramString == null) {
      return new FbpCheckUnitContentsV();
    }
    FbpCheckUnitContentsV localFbpCheckUnitContentsV = this.fbpCheckunitContentsVDAO.findCheckUnitContentsVById(Long.parseLong(paramString));
    return localFbpCheckUnitContentsV;
  }
  
  public TableDataInfo findCheckUnitContentsVByQry(FbpCheckUnitContentsV paramFbpCheckUnitContentsV, String paramString1, String paramString2)
  {
    PageInfo localPageInfo = this.fbpCheckunitContentsVDAO.findCheckUnitContentsVByQry(paramFbpCheckUnitContentsV, new Integer(paramString1).intValue(), new Integer(paramString2).intValue());
    List localList = (List)localPageInfo.getResult();
    for (int i = 0; i < localList.size(); i++)
    {
      FbpCheckUnitContentsV localFbpCheckUnitContentsV = (FbpCheckUnitContentsV)localList.get(i);
      if (localFbpCheckUnitContentsV.getEnabledFlag().equalsIgnoreCase("Y")) {
        localFbpCheckUnitContentsV.setEnabledFlag("启用");
      } else {
        localFbpCheckUnitContentsV.setEnabledFlag("禁用");
      }
    }
    TableDataInfo localTableDataInfo = new TableDataInfo();
    localTableDataInfo.setData((List)localPageInfo.getResult());
    localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
    return localTableDataInfo;
  }
  
  public void setFbpCheckunitContentsVDAO(IFbpCheckUnitContentsVDAO paramIFbpCheckUnitContentsVDAO)
  {
    super.setDao(paramIFbpCheckUnitContentsVDAO);
    this.fbpCheckunitContentsVDAO = paramIFbpCheckUnitContentsVDAO;
  }
  
  public void setFbpCheckUnitContentsDAO(IFbpCheckUnitContentsDAO paramIFbpCheckUnitContentsDAO)
  {
    this.fbpCheckUnitContentsDAO = paramIFbpCheckUnitContentsDAO;
  }
  
  public IFbpCheckUnitContentsVDAO getFbpCheckunitContentsVDAO()
  {
    return this.fbpCheckunitContentsVDAO;
  }
  
  public IFbpCheckUnitContentsDAO getFbpCheckUnitContentsDAO()
  {
    return this.fbpCheckUnitContentsDAO;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.business.checkunits.service.FbpCheckUnitContentsVDS
 * JD-Core Version:    0.7.0.1
 */