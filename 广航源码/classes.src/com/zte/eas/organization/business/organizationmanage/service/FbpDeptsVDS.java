package com.zte.eas.organization.business.organizationmanage.service;

import com.zte.eas.appframe.business.util.ObjectCopyUtils;
import com.zte.eas.organization.access.countcompanymanage.FbpCompanyDAO;
import com.zte.eas.organization.access.organizationmanage.dao.IFbpDeptsDAO;
import com.zte.eas.organization.access.organizationmanage.dao.IFbpDeptsTlDAO;
import com.zte.eas.organization.access.organizationmanage.dao.IFbpDeptsVDAO;
import com.zte.eas.organization.access.organizationmanage.dao.IFbpDeptsVlDAO;
import com.zte.eas.organization.business.countcompanymanage.service.DataSourceU;
import com.zte.eas.organization.business.organizationmanage.model.FbpDepts;
import com.zte.eas.organization.business.organizationmanage.model.FbpDeptsTl;
import com.zte.eas.organization.business.organizationmanage.model.FbpDeptsTlPk;
import com.zte.eas.organization.business.organizationmanage.model.FbpDeptsV;
import com.zte.esb.bean.AdminOrgInfo;
import com.zte.esb.bean.SendAdminOrgProcessReult;
import com.zte.esb.bean.SendAdminOrgResponse;
import com.zte.esb.bean.foss.DistrictInfo;
import com.zte.esb.bean.foss.FailInfo;
import com.zte.esb.bean.foss.SyncDistrictResponse;
import com.zte.evs.ebill.access.eBillManage.IEvsDocAccessStorageDAO;
import com.zte.evs.ebill.model.eBillManage.EvsCity;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.BaseDomainService;
import com.zte.ssb.ssbext.lang.LangType;
import com.zte.ssb.ssbext.lang.LangUtil;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class FbpDeptsVDS
  extends BaseDomainService
  implements IFbpDeptsVDS
{
  private IFbpDeptsVDAO fbpDeptsVDAO;
  private IFbpDeptsDAO fbpDeptsDAO;
  private IFbpDeptsVlDAO fbpDeptsVlDAO;
  private IFbpDeptsTlDAO fbpDeptsTlDAO;
  private FbpCompanyDAO fbpCompanyDAO;
  private final String SUCC = "SUCC";
  private final String FAIL = "FAIL";
  private final String SAME_COMP_ERR = "SAME_COMP_ERR";
  private final String ORGCODEREPEAT = "ORGCODEREPEAT";
  private final String ORGNAMEREPEAT = "ORGNAMEREPEAT";
  private String tempParentLongName = "";
  Logger logger = Logger.getLogger(getClass());
  
  public FbpDeptsV findDeptsVById(String paramString)
  {
    FbpDeptsV localFbpDeptsV = this.fbpDeptsVDAO.findDeptsVById(new BigInteger(paramString));
    if ((localFbpDeptsV != null) && (localFbpDeptsV.getDescription() == null)) {
      localFbpDeptsV.setDescription("");
    }
    return localFbpDeptsV;
  }
  
  public String saveDeptsV(FbpDeptsV paramFbpDeptsV)
  {
    List localList = null;
    String str1 = "";
    String str2 = "";
    FbpDeptsTl localFbpDeptsTl1 = null;
    FbpDeptsTlPk localFbpDeptsTlPk = new FbpDeptsTlPk();
    if (null == paramFbpDeptsV) {
      return "FAIL";
    }
    if (StringUtils.isNotBlank(paramFbpDeptsV.getDeptName())) {
      str2 = paramFbpDeptsV.getDeptName();
    }
    FbpDepts localFbpDepts;
    Object localObject;
    if (paramFbpDeptsV.getDeptId() != null)
    {
      FbpDeptsV localFbpDeptsV = this.fbpDeptsVDAO.findDeptsVById(paramFbpDeptsV.getDeptId());
      if (paramFbpDeptsV.getParentDeptId() == null) {
        paramFbpDeptsV.setParentDeptId(new BigInteger("0"));
      }
      if ((paramFbpDeptsV.getDeptCode() != null) && (localFbpDeptsV.getDeptCode() != null) && (!paramFbpDeptsV.getDeptCode().equals(localFbpDeptsV.getDeptCode())))
      {
        localList = this.fbpDeptsVDAO.findDeptsVByCode(paramFbpDeptsV.getDeptCode());
        if ((localList != null) && (localList.size() > 0))
        {
          getClass();
          return "ORGCODEREPEAT";
        }
      }
      if (StringUtils.isNotBlank(paramFbpDeptsV.getAttribute7()))
      {
        this.fbpCompanyDAO.lockCompanyById(new Long(paramFbpDeptsV.getAttribute7()));
        localList = this.fbpDeptsVDAO.findDeptVByCon(paramFbpDeptsV);
        if ((localList != null) && (localList.size() > 0))
        {
          getClass();
          return "SAME_COMP_ERR";
        }
      }
      if ((paramFbpDeptsV.getParentDeptId() != null) && (paramFbpDeptsV.getDeptName() != null) && (!localFbpDeptsV.getDeptName().equals(paramFbpDeptsV.getDeptName())))
      {
        localList = this.fbpDeptsVDAO.findDownDeptsV(paramFbpDeptsV.getParentDeptId(), paramFbpDeptsV.getDeptName());
        if ((localList != null) && (localList.size() > 0))
        {
          getClass();
          return "ORGNAMEREPEAT";
        }
      }
      localFbpDepts = this.fbpDeptsDAO.getFbpDepts(paramFbpDeptsV.getDeptId());
      ObjectCopyUtils.copy(paramFbpDeptsV, localFbpDepts);
      ObjectCopyUtils.setWho(localFbpDepts);
      this.fbpDeptsDAO.updateFbpDepts(localFbpDepts);
      if ((paramFbpDeptsV != null) && (paramFbpDeptsV.getParentDeptId() != null) && (paramFbpDeptsV.getParentDeptId().intValue() != 0))
      {
        localFbpDeptsTlPk.setDeptId(paramFbpDeptsV.getParentDeptId());
        localFbpDeptsTlPk.setLanguage("ZHS");
        localFbpDeptsTl1 = this.fbpDeptsTlDAO.getFbpDeptsTl(localFbpDeptsTlPk);
        if ((localFbpDeptsTl1 != null) && (localFbpDeptsTl1.getDeptLongName() != null)) {
          str2 = localFbpDeptsTl1.getDeptLongName() + "/" + str2;
        }
      }
      localObject = new FbpDeptsTl();
      ObjectCopyUtils.copy(paramFbpDeptsV, localObject);
      ObjectCopyUtils.setWho(localObject);
      ((FbpDeptsTl)localObject).getDeptTlPK().setDeptId(localFbpDepts.getDeptId());
      ((FbpDeptsTl)localObject).setDeptName(paramFbpDeptsV.getDeptName());
      ((FbpDeptsTl)localObject).setDeptLongName(str2);
      ((FbpDeptsTl)localObject).setSourceLang(DataSourceU.getLang(LangUtil.getLocale()));
      ((FbpDeptsTl)localObject).getDeptTlPK().setLanguage(DataSourceU.getLang(LangUtil.getLocale()));
      this.fbpDeptsTlDAO.updateFbpDeptsTl((FbpDeptsTl)localObject);
      if ((localFbpDepts != null) && (localFbpDepts.getDeptId() != null)) {
        str1 = localFbpDepts.getDeptId().toString();
      }
      if ((paramFbpDeptsV != null) && (paramFbpDeptsV.getDeptId() != null)) {
        updateSubOrg(paramFbpDeptsV.getDeptId(), str2);
      }
    }
    else
    {
      if (paramFbpDeptsV.getParentDeptId() == null) {
        paramFbpDeptsV.setParentDeptId(new BigInteger("0"));
      }
      if (paramFbpDeptsV.getDeptCode() != null)
      {
        localList = this.fbpDeptsVDAO.findDeptsVByCode(paramFbpDeptsV.getDeptCode());
        if ((localList != null) && (localList.size() > 0)) {
          return "ORGCODEREPEAT";
        }
      }
      if ((paramFbpDeptsV != null) && (paramFbpDeptsV.getAttribute7() != null))
      {
        localObject = paramFbpDeptsV.getAttribute7();
        if (this.fbpDeptsVDAO.findDeptByCompId((String)localObject) != null) {
          return "SAME_COMP_ERR";
        }
      }
      if ((paramFbpDeptsV.getParentDeptId() != null) && (paramFbpDeptsV.getDeptName() != null))
      {
        localList = this.fbpDeptsVDAO.findDownDeptsV(paramFbpDeptsV.getParentDeptId(), paramFbpDeptsV.getDeptName());
        if ((localList != null) && (localList.size() > 0)) {
          return "ORGNAMEREPEAT";
        }
      }
      localFbpDepts = new FbpDepts();
      ObjectCopyUtils.copy(paramFbpDeptsV, localFbpDepts);
      ObjectCopyUtils.setWho(localFbpDepts);
      ObjectCopyUtils.copy(localFbpDepts, paramFbpDeptsV);
      if ((localFbpDepts != null) && (localFbpDepts.getParentDeptId() != null) && (localFbpDepts.getParentDeptId().intValue() != 0)) {
        localFbpDepts.setDefaultCheckUnit(getDefaultCheckUnit(localFbpDepts.getParentDeptId()));
      }
      this.fbpDeptsDAO.insertFbpDepts(localFbpDepts);
      localObject = LangUtil.listLangTypes();
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        LangType localLangType = (LangType)localIterator.next();
        if ((paramFbpDeptsV != null) && (paramFbpDeptsV.getParentDeptId() != null) && (paramFbpDeptsV.getParentDeptId().intValue() != 0))
        {
          localFbpDeptsTlPk.setDeptId(paramFbpDeptsV.getParentDeptId());
          localFbpDeptsTlPk.setLanguage(DataSourceU.getLang(localLangType.getCode()));
          localFbpDeptsTl1 = this.fbpDeptsTlDAO.getFbpDeptsTl(localFbpDeptsTlPk);
          if ((localFbpDeptsTl1 != null) && (localFbpDeptsTl1.getDeptLongName() != null)) {
            str2 = localFbpDeptsTl1.getDeptLongName() + "/" + str2;
          }
        }
        FbpDeptsTl localFbpDeptsTl2 = new FbpDeptsTl();
        ObjectCopyUtils.copy(paramFbpDeptsV, localFbpDeptsTl2);
        ObjectCopyUtils.setWho(localFbpDeptsTl2);
        localFbpDeptsTl2.getDeptTlPK().setDeptId(localFbpDepts.getDeptId());
        localFbpDeptsTl2.setDeptName(paramFbpDeptsV.getDeptName());
        localFbpDeptsTl2.setDeptLongName(str2);
        localFbpDeptsTl2.setSourceLang(DataSourceU.getLang(localLangType.getCode()));
        localFbpDeptsTl2.getDeptTlPK().setLanguage(DataSourceU.getLang(localLangType.getCode()));
        this.fbpDeptsTlDAO.insertFbpDeptsTl(localFbpDeptsTl2);
        if ((localFbpDepts != null) && (localFbpDepts.getDeptId() != null)) {
          str1 = localFbpDepts.getDeptId().toString();
        }
      }
    }
    return "SUCC," + str1;
  }
  
  private String getDefaultCheckUnit(BigInteger paramBigInteger)
  {
    try
    {
      FbpDepts localFbpDepts = this.fbpDeptsDAO.getFbpDepts(paramBigInteger);
      if ((localFbpDepts != null) && (localFbpDepts.getDefaultCheckUnit() != null) && (!localFbpDepts.getDefaultCheckUnit().equals(""))) {
        return localFbpDepts.getDefaultCheckUnit();
      }
      if ((localFbpDepts != null) && (localFbpDepts.getParentDeptId() != null) && (localFbpDepts.getParentDeptId().intValue() != 0)) {
        return getDefaultCheckUnit(localFbpDepts.getParentDeptId());
      }
      return "";
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
  
  private void updateSubOrg(BigInteger paramBigInteger, String paramString)
  {
    List localList = this.fbpDeptsVDAO.findDownDeptsV(paramBigInteger);
    if ((localList != null) && (localList.size() > 0))
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        FbpDeptsV localFbpDeptsV = (FbpDeptsV)localIterator.next();
        if (localFbpDeptsV != null)
        {
          if (localFbpDeptsV.getDeptName() != null) {
            this.tempParentLongName = (paramString + "/" + localFbpDeptsV.getDeptName());
          }
          FbpDeptsTl localFbpDeptsTl = new FbpDeptsTl();
          ObjectCopyUtils.copy(localFbpDeptsV, localFbpDeptsTl);
          ObjectCopyUtils.setWho(localFbpDeptsTl);
          localFbpDeptsTl.getDeptTlPK().setDeptId(localFbpDeptsV.getDeptId());
          localFbpDeptsTl.setDeptName(localFbpDeptsTl.getDeptName());
          localFbpDeptsTl.setDeptLongName(this.tempParentLongName);
          localFbpDeptsTl.setSourceLang("ZHS");
          localFbpDeptsTl.getDeptTlPK().setLanguage("ZHS");
          this.fbpDeptsTlDAO.updateFbpDeptsTl(localFbpDeptsTl);
          if ((localFbpDeptsV.getDeptId() != null) && (localFbpDeptsV.getDeptId().intValue() != 0)) {
            updateSubOrg(localFbpDeptsV.getDeptId(), this.tempParentLongName);
          }
        }
      }
    }
  }
  
  public SyncDistrictResponse syncFossArea(List<DistrictInfo> paramList)
  {
    int i = paramList.size();
    ArrayList localArrayList = new ArrayList();
    SyncDistrictResponse localSyncDistrictResponse = new SyncDistrictResponse();
    IEvsDocAccessStorageDAO localIEvsDocAccessStorageDAO = (IEvsDocAccessStorageDAO)SSBBus.findDomainService("docAccessStorageDAO");
    for (int j = 0; j < i; j++)
    {
      DistrictInfo localDistrictInfo = (DistrictInfo)paramList.get(j);
      try
      {
        String str = localDistrictInfo.getParentDistrictCode();
        EvsCity localEvsCity1 = null;
        EvsCity localEvsCity2 = null;
        int k = 0;
        if (!StringUtils.isEmpty(str))
        {
          localEvsCity1 = localIEvsDocAccessStorageDAO.findCityNameByCityCode(str);
          if ((localEvsCity1 == null) || ("N".equals(localEvsCity1.getEnabledFlag())))
          {
            FailInfo localFailInfo = new FailInfo();
            localFailInfo.setId(localDistrictInfo.getId());
            localFailInfo.setReason(localDistrictInfo.getParentDistrictCode() + " not exists");
            localArrayList.add(localFailInfo);
            continue;
          }
        }
        localEvsCity2 = localIEvsDocAccessStorageDAO.findCityNameByCityCode(localDistrictInfo.getCode());
        if (localEvsCity2 == null)
        {
          localEvsCity2 = new EvsCity();
          k = 1;
        }
        localEvsCity2.setParentCityId(Long.valueOf(null == localEvsCity1 ? 0L : localEvsCity1.getCityId().longValue()));
        localEvsCity2.setCreationDate(localDistrictInfo.getCreateTime());
        localEvsCity2.setLastUpdateDate(localDistrictInfo.getModifyTime());
        localEvsCity2.setCreatedBy(Long.valueOf(1L));
        localEvsCity2.setLastUpdateLogin(Long.valueOf(1L));
        localEvsCity2.setCityAvailname(localDistrictInfo.getAvailableName());
        localEvsCity2.setCityCode(localDistrictInfo.getCode());
        localEvsCity2.setCityDegree(localDistrictInfo.getDegree());
        localEvsCity2.setCityName(localDistrictInfo.getName());
        localEvsCity2.setCitySimname(localDistrictInfo.getSimpleName());
        localEvsCity2.setEnabledFlag(localDistrictInfo.getActive());
        localEvsCity2.setLastUpdateBy(Long.valueOf(1L));
        localEvsCity2.setPingYin(localDistrictInfo.getPinyin());
        localEvsCity2.setPingyinAbbr(localDistrictInfo.getPinyinAbbr());
        localEvsCity2.setRegionSuffix(localDistrictInfo.getRegionSuffix());
        localEvsCity2.setVesionNo(null == localDistrictInfo.getVersionNo() ? "" : localDistrictInfo.getVersionNo().toString());
        localEvsCity2.setVirDistrict(localDistrictInfo.getVirtualDistrictId());
        if (localEvsCity2.getCityId() == null) {
          localIEvsDocAccessStorageDAO.insertEvsCity(localEvsCity2);
        } else {
          localIEvsDocAccessStorageDAO.updateEvsCity(localEvsCity2);
        }
      }
      catch (Exception localException)
      {
        this.logger.error("系统异常:" + localException.getMessage(), localException);
      }
    }
    localSyncDistrictResponse.setFailInfos(localArrayList);
    return localSyncDistrictResponse;
  }
  
  public SendAdminOrgResponse syncDepts(List<AdminOrgInfo> paramList)
  {
    if (null == paramList) {
      return null;
    }
    int i = paramList.size();
    IFbpDeptsDAO localIFbpDeptsDAO = (IFbpDeptsDAO)SSBBus.findDomainService("fbpDeptsDAO");
    int j = 0;
    int k = 0;
    SendAdminOrgResponse localSendAdminOrgResponse = new SendAdminOrgResponse();
    ArrayList localArrayList = new ArrayList();
    for (int m = 0; m < i; m++)
    {
      AdminOrgInfo localAdminOrgInfo = (AdminOrgInfo)paramList.get(m);
      SendAdminOrgProcessReult localSendAdminOrgProcessReult = new SendAdminOrgProcessReult();
      try
      {
        FbpDepts localFbpDepts1 = localIFbpDeptsDAO.getFbpDeptsByCode(localAdminOrgInfo.getOrgCode());
        String str = localAdminOrgInfo.getParentOrgCode();
        FbpDepts localFbpDepts2 = null;
        if (!StringUtils.isEmpty(str))
        {
          localFbpDepts2 = localIFbpDeptsDAO.getFbpDeptsByCode(localAdminOrgInfo.getParentOrgCode());
          if (localFbpDepts2 == null)
          {
            localSendAdminOrgProcessReult.setOrgChangeId(localAdminOrgInfo.getOrgChangeId());
            localSendAdminOrgProcessReult.setOrgBenchmarkCode(localAdminOrgInfo.getOrgBenchmarkCode());
            localSendAdminOrgProcessReult.setChangeType(localAdminOrgInfo.getChangeType());
            localSendAdminOrgProcessReult.setOrgName(localAdminOrgInfo.getOrgName());
            localSendAdminOrgProcessReult.setReason(str + "not exists");
            localSendAdminOrgProcessReult.setResult(false);
            localArrayList.add(localSendAdminOrgProcessReult);
            k++;
            continue;
          }
        }
        if (null == localFbpDepts1)
        {
          localFbpDepts1 = new FbpDepts();
          if (localFbpDepts2 != null) {
            localFbpDepts1.setParentDeptId(localFbpDepts2.getDeptId());
          } else {
            localFbpDepts1.setParentDeptId(new BigInteger("0"));
          }
          localSendAdminOrgProcessReult = changeValues(localAdminOrgInfo, localFbpDepts1, true);
        }
        else
        {
          if (localFbpDepts2 != null) {
            localFbpDepts1.setParentDeptId(localFbpDepts2.getDeptId());
          } else {
            localFbpDepts1.setParentDeptId(new BigInteger("0"));
          }
          localSendAdminOrgProcessReult = changeValues(localAdminOrgInfo, localFbpDepts1, false);
        }
        j++;
      }
      catch (Exception localException)
      {
        this.logger.error("同步组织异常:" + localException.getMessage(), localException);
        localSendAdminOrgProcessReult.setChangeType(localAdminOrgInfo.getChangeType());
        localSendAdminOrgProcessReult.setOrgBenchmarkCode(localAdminOrgInfo.getOrgBenchmarkCode());
        localSendAdminOrgProcessReult.setOrgChangeId(localAdminOrgInfo.getOrgChangeId());
        localSendAdminOrgProcessReult.setOrgName(localAdminOrgInfo.getOrgName());
        localSendAdminOrgProcessReult.setReason("系统异常：" + localException.getMessage());
        localSendAdminOrgProcessReult.setResult(false);
        k++;
      }
      localArrayList.add(localSendAdminOrgProcessReult);
    }
    localSendAdminOrgResponse.setSuccessCount(j);
    localSendAdminOrgResponse.setFailedCount(k);
    localSendAdminOrgResponse.setProcessResult(localArrayList);
    return localSendAdminOrgResponse;
  }
  
  private SendAdminOrgProcessReult changeValues(AdminOrgInfo paramAdminOrgInfo, FbpDepts paramFbpDepts, boolean paramBoolean)
  {
    SendAdminOrgProcessReult localSendAdminOrgProcessReult = new SendAdminOrgProcessReult();
    IFbpDeptsDAO localIFbpDeptsDAO = (IFbpDeptsDAO)SSBBus.findDomainService("fbpDeptsDAO");
    IFbpDeptsTlDAO localIFbpDeptsTlDAO = (IFbpDeptsTlDAO)SSBBus.findDomainService("fbpDeptsTlDAO");
    paramFbpDepts.setDeptId(paramFbpDepts.getDeptId() == null ? null : paramFbpDepts.getDeptId());
    paramFbpDepts.setCreatedBy(Long.valueOf(1L));
    paramFbpDepts.setLastUpdatedBy(Long.valueOf(1L));
    paramFbpDepts.setDeptCode(paramAdminOrgInfo.getOrgCode());
    paramFbpDepts.setOrgAttribute(paramAdminOrgInfo.getOrgAttribute());
    paramFbpDepts.setOrgBenchmarkCode(paramAdminOrgInfo.getOrgBenchmarkCode());
    paramFbpDepts.setOrgManager(paramAdminOrgInfo.getOrgManager());
    paramFbpDepts.setOrgPhone(paramAdminOrgInfo.getOrgPhone());
    paramFbpDepts.setOrgFax(paramAdminOrgInfo.getOrgFax());
    paramFbpDepts.setSubCompname(paramAdminOrgInfo.getSubCompName());
    paramFbpDepts.setSubCompcode(paramAdminOrgInfo.getSubCompCode());
    paramFbpDepts.setCostCentercode(paramAdminOrgInfo.getCostCenterCode());
    paramFbpDepts.setCostCentername(paramAdminOrgInfo.getCostCenterName());
    paramFbpDepts.setOrgProvince(paramAdminOrgInfo.getOrgProvince());
    paramFbpDepts.setOrgCity(paramAdminOrgInfo.getOrgCity());
    paramFbpDepts.setOrgCountry(paramAdminOrgInfo.getOrgCountry());
    paramFbpDepts.setOrgZipcode(paramAdminOrgInfo.getOrgZipCode());
    paramFbpDepts.setOrgEmail(paramAdminOrgInfo.getOrgEmail());
    paramFbpDepts.setOrgAddress(paramAdminOrgInfo.getOrgAddress());
    String str1 = paramAdminOrgInfo.getOrgStatus();
    paramFbpDepts.setEnabledFlag("2".equals(str1) ? "N" : "Y");
    paramFbpDepts.setCreationDate(null == paramAdminOrgInfo.getValidDate() ? new Date() : paramAdminOrgInfo.getValidDate());
    paramFbpDepts.setLastUpdateDate(paramAdminOrgInfo.getChangeDate());
    paramFbpDepts.setInvalidDate(paramAdminOrgInfo.getInvalidDate());
    paramFbpDepts.setIscareerDept(Long.valueOf(paramAdminOrgInfo.isIsCareerDept() ? 0L : 1L));
    paramFbpDepts.setIsbigArea(Long.valueOf(paramAdminOrgInfo.isIsBigArea() ? 0L : 1L));
    paramFbpDepts.setIssmallArea(Long.valueOf(paramAdminOrgInfo.isIsSmallArea() ? 0L : 1L));
    paramFbpDepts.setAreaCode(paramAdminOrgInfo.getAreaCode());
    if (paramBoolean) {
      localIFbpDeptsDAO.insertFbpDepts(paramFbpDepts);
    } else {
      localIFbpDeptsDAO.updateFbpDepts(paramFbpDepts);
    }
    List localList = LangUtil.listLangTypes();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      LangType localLangType = (LangType)localIterator.next();
      String str2 = DataSourceU.getLang(localLangType.getCode());
      if (str2 != null)
      {
        FbpDeptsTlPk localFbpDeptsTlPk = new FbpDeptsTlPk();
        localFbpDeptsTlPk.setDeptId(paramFbpDepts.getDeptId());
        localFbpDeptsTlPk.setLanguage(str2);
        FbpDeptsTl localFbpDeptsTl = (FbpDeptsTl)localIFbpDeptsTlDAO.getObject(FbpDeptsTl.class, localFbpDeptsTlPk);
        if (null == localFbpDeptsTl)
        {
          localFbpDeptsTl = new FbpDeptsTl();
          localFbpDeptsTl.setDeptTlPK(localFbpDeptsTlPk);
          localFbpDeptsTl.setCreatedBy(Long.valueOf(1L));
          localFbpDeptsTl.setCreationDate(null == paramAdminOrgInfo.getValidDate() ? new Date() : paramAdminOrgInfo.getValidDate());
          localFbpDeptsTl.setDeptId(paramFbpDepts.getDeptId());
          localFbpDeptsTl.setDeptLongName(paramAdminOrgInfo.getOrgName());
          localFbpDeptsTl.setDeptName(paramAdminOrgInfo.getOrgName());
          localFbpDeptsTl.setDescription(paramAdminOrgInfo.getOrgDesc());
          localFbpDeptsTl.setLanguage(str2);
          localFbpDeptsTl.setLastUpdateDate(paramAdminOrgInfo.getChangeDate());
          localFbpDeptsTl.setLastUpdatedBy(Long.valueOf(1L));
          localFbpDeptsTl.setLastUpdateLogin(Long.valueOf(1L));
          localFbpDeptsTl.setSourceLang(str2);
          localIFbpDeptsTlDAO.insertFbpDeptsTl(localFbpDeptsTl);
        }
        else if (null != localFbpDeptsTl)
        {
          localFbpDeptsTl.setLastUpdateDate(paramAdminOrgInfo.getChangeDate());
          localFbpDeptsTl.setDescription(paramAdminOrgInfo.getOrgDesc());
          localFbpDeptsTl.setDeptId(paramFbpDepts.getDeptId());
          localFbpDeptsTl.setDeptLongName(paramAdminOrgInfo.getOrgName());
          localFbpDeptsTl.setDeptName(paramAdminOrgInfo.getOrgName());
          localFbpDeptsTl.setLanguage(str2);
          localIFbpDeptsTlDAO.updateFbpDeptsTl(localFbpDeptsTl);
        }
      }
    }
    localSendAdminOrgProcessReult.setOrgChangeId(paramAdminOrgInfo.getOrgChangeId());
    localSendAdminOrgProcessReult.setOrgBenchmarkCode(paramAdminOrgInfo.getOrgBenchmarkCode());
    localSendAdminOrgProcessReult.setChangeType(paramAdminOrgInfo.getChangeType());
    localSendAdminOrgProcessReult.setOrgName(paramAdminOrgInfo.getOrgName());
    localSendAdminOrgProcessReult.setResult(true);
    localSendAdminOrgProcessReult.setReason(null);
    return localSendAdminOrgProcessReult;
  }
  
  private SendAdminOrgProcessReult exmessageinfo(AdminOrgInfo paramAdminOrgInfo, Exception paramException)
  {
    SendAdminOrgProcessReult localSendAdminOrgProcessReult = new SendAdminOrgProcessReult();
    localSendAdminOrgProcessReult.setOrgChangeId(paramAdminOrgInfo.getOrgChangeId());
    localSendAdminOrgProcessReult.setOrgBenchmarkCode(paramAdminOrgInfo.getOrgBenchmarkCode());
    localSendAdminOrgProcessReult.setChangeType(paramAdminOrgInfo.getChangeType());
    localSendAdminOrgProcessReult.setOrgName(paramAdminOrgInfo.getOrgName());
    localSendAdminOrgProcessReult.setReason(paramException.getMessage());
    localSendAdminOrgProcessReult.setResult(false);
    return localSendAdminOrgProcessReult;
  }
  
  public List findDownDeptsV(BigInteger paramBigInteger)
  {
    return this.fbpDeptsVDAO.findDownDeptsV(paramBigInteger);
  }
  
  public FbpDepts getFbpDepts(BigInteger paramBigInteger)
  {
    return this.fbpDeptsDAO.getFbpDepts(paramBigInteger);
  }
  
  public void updateFbpDepts(FbpDepts paramFbpDepts)
  {
    this.fbpDeptsDAO.updateFbpDepts(paramFbpDepts);
  }
  
  public IFbpDeptsDAO getFbpDeptsDAO()
  {
    return this.fbpDeptsDAO;
  }
  
  public void setFbpDeptsDAO(IFbpDeptsDAO paramIFbpDeptsDAO)
  {
    this.fbpDeptsDAO = paramIFbpDeptsDAO;
  }
  
  public IFbpDeptsTlDAO getFbpDeptsTlDAO()
  {
    return this.fbpDeptsTlDAO;
  }
  
  public void setFbpDeptsTlDAO(IFbpDeptsTlDAO paramIFbpDeptsTlDAO)
  {
    this.fbpDeptsTlDAO = paramIFbpDeptsTlDAO;
  }
  
  public IFbpDeptsVlDAO getFbpDeptsVlDAO()
  {
    return this.fbpDeptsVlDAO;
  }
  
  public void setFbpDeptsVlDAO(IFbpDeptsVlDAO paramIFbpDeptsVlDAO)
  {
    this.fbpDeptsVlDAO = paramIFbpDeptsVlDAO;
  }
  
  public IFbpDeptsVDAO getFbpDeptsVDAO()
  {
    return this.fbpDeptsVDAO;
  }
  
  public void setFbpDeptsVDAO(IFbpDeptsVDAO paramIFbpDeptsVDAO)
  {
    this.fbpDeptsVDAO = paramIFbpDeptsVDAO;
  }
  
  public FbpCompanyDAO getFbpCompanyDAO()
  {
    return this.fbpCompanyDAO;
  }
  
  public void setFbpCompanyDAO(FbpCompanyDAO paramFbpCompanyDAO)
  {
    this.fbpCompanyDAO = paramFbpCompanyDAO;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.business.organizationmanage.service.FbpDeptsVDS
 * JD-Core Version:    0.7.0.1
 */