package com.zte.eas.getData.OranizationUnits.validator;

import com.zte.eas.appframe.business.util.ObjectCopyUtils;
import com.zte.eas.getData.OranizationUnits.model.Message;
import com.zte.eas.getData.OranizationUnits.model.OrganizationUnits;
import com.zte.eas.getData.util.EisConsts;
import com.zte.eas.organization.access.organizationmanage.dao.IFbpDeptsDAO;
import com.zte.eas.organization.business.organizationmanage.model.FbpDepts;
import com.zte.eas.organization.business.organizationmanage.model.FbpDeptsTl;
import com.zte.eas.organization.business.organizationmanage.model.FbpDeptsTlPk;
import com.zte.ssb.framework.SSBBus;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

public class OrganizationUnitsServiceValidatorImpl
  extends BasicValidatorImpl
  implements ObjectServiceValidator<FbpDepts, OrganizationUnits>, IOrganizationUnitsServiceValidatorImpl
{
  private IFbpDeptsDAO deptDao;
  final Integer HAIER_GROUP_ID = Integer.valueOf(10001);
  
  public void updateParentDept(OrganizationUnits[] paramArrayOfOrganizationUnits)
  {
    if ((paramArrayOfOrganizationUnits != null) && (paramArrayOfOrganizationUnits.length > 0))
    {
      ArrayList localArrayList = new ArrayList();
      for (OrganizationUnits localOrganizationUnits : paramArrayOfOrganizationUnits) {
        if ((localOrganizationUnits.getAttribute3() != null) && (localOrganizationUnits.getAttribute3().trim().length() > 0))
        {
          FbpDepts localFbpDepts1 = getDeptDao().getFbpDeptsByCode(localOrganizationUnits.getDeptCode());
          FbpDepts localFbpDepts2 = getDeptDao().getFbpDeptsByCode(localOrganizationUnits.getAttribute3());
          if ((localFbpDepts1 != null) && (localFbpDepts1.getDeptId() != null) && (localFbpDepts2 != null) && (localFbpDepts2.getDeptId() != null))
          {
            localFbpDepts1.setParentDeptId(localFbpDepts2.getDeptId());
            localArrayList.add(localFbpDepts1);
          }
        }
      }
      getDeptDao().updateFbpDeptss(localArrayList);
    }
  }
  
  public Message validator(OrganizationUnits paramOrganizationUnits)
  {
    this.log.error("数据： " + (paramOrganizationUnits == null ? null : paramOrganizationUnits.toString()));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("deptCode");
    localArrayList.add("attribute2");
    Message localMessage = valueIsNull(paramOrganizationUnits, localArrayList);
    if (!"True".equals(localMessage.getResult())) {
      return localMessage;
    }
    if (StringUtils.isBlank(paramOrganizationUnits.getEnabledFlag())) {
      paramOrganizationUnits.setEnabledFlag("Y");
    }
    if ((!"Y".equals(paramOrganizationUnits.getEnabledFlag())) && (!"N".equals(paramOrganizationUnits.getEnabledFlag()))) {
      return buildMessage("EAS000003", "enabledFlag");
    }
    if ((paramOrganizationUnits.getAttribute3() != null) && (paramOrganizationUnits.getDeptCode().equals(paramOrganizationUnits.getAttribute3())))
    {
      localMessage.setErrCode("EAS000003");
      localMessage.setErrInfos("上级部门不能为本身：" + paramOrganizationUnits.getAttribute3());
      localMessage.setResult("False");
      return localMessage;
    }
    this.log.error(" 数据验证全部通过。");
    localMessage.setResult("True");
    return localMessage;
  }
  
  public FbpDepts saveOrUpdate(OrganizationUnits paramOrganizationUnits)
  {
    if (paramOrganizationUnits == null) {
      return null;
    }
    FbpDepts localFbpDepts1 = getDeptDao().getFbpDeptsByCode(paramOrganizationUnits.getDeptCode());
    if (localFbpDepts1 == null)
    {
      localFbpDepts1 = new FbpDepts();
      localFbpDepts1.setCreationDate(paramOrganizationUnits.getCreationDate() == null ? new Date() : paramOrganizationUnits.getCreationDate());
    }
    localFbpDepts1.setParentDeptId(BigInteger.valueOf(this.HAIER_GROUP_ID.intValue()));
    localFbpDepts1.setDeptCode(paramOrganizationUnits.getDeptCode());
    localFbpDepts1.setEnabledFlag(paramOrganizationUnits.getEnabledFlag());
    localFbpDepts1.setLastUpdateDate(new Date());
    localFbpDepts1.setLastUpdatedBy(Long.valueOf(1L));
    localFbpDepts1.setLastUpdateLogin(Long.valueOf(1L));
    localFbpDepts1.setCreatedBy(Long.valueOf(1L));
    Object localObject;
    FbpDepts localFbpDepts2;
    if (localFbpDepts1.getDeptId() == null)
    {
      getDeptDao().insertFbpDepts(localFbpDepts1);
    }
    else if ("N".equals(localFbpDepts1.getEnabledFlag()))
    {
      localObject = getDeptDao().findOffspringDepts(localFbpDepts1.getDeptId());
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = ((List)localObject).iterator();
        while (localIterator.hasNext())
        {
          localFbpDepts2 = (FbpDepts)localIterator.next();
          localFbpDepts2.setEnabledFlag("N");
          localArrayList.add(localFbpDepts2);
        }
        getDeptDao().updateFbpDeptss(localArrayList);
      }
    }
    else
    {
      getDeptDao().updateFbpDepts(localFbpDepts1);
    }
    for (localFbpDepts2 : EisConsts.LANGUAGE_LIST)
    {
      FbpDeptsTl localFbpDeptsTl = getDeptDao().findFbpDeptsTls(localFbpDepts1.getDeptId(), localFbpDepts2);
      if ((localFbpDeptsTl == null) || (localFbpDeptsTl.getDeptTlPK() == null) || (localFbpDeptsTl.getDeptTlPK().getDeptId() == null))
      {
        localFbpDeptsTl = new FbpDeptsTl();
        ObjectCopyUtils.setWho(localFbpDeptsTl);
        localFbpDeptsTl.setLastUpdateDate(paramOrganizationUnits.getLastUpdateDate() == null ? new Date() : paramOrganizationUnits.getLastUpdateDate());
        localFbpDeptsTl.setDeptId(localFbpDepts1.getDeptId());
        localFbpDeptsTl.setLanguage("ZHS");
        localFbpDeptsTl.setSourceLang("ZHS");
        localFbpDeptsTl.setDeptName(paramOrganizationUnits.getAttribute2());
        localFbpDeptsTl.setDeptLongName(paramOrganizationUnits.getAttribute2());
        FbpDeptsTlPk localFbpDeptsTlPk = new FbpDeptsTlPk();
        localFbpDeptsTlPk.setDeptId(localFbpDepts1.getDeptId());
        localFbpDeptsTlPk.setLanguage(localFbpDepts2);
        localFbpDeptsTl.setDeptTlPK(localFbpDeptsTlPk);
        getDeptDao().insertFbpDeptsTl(localFbpDeptsTl);
      }
      else
      {
        localFbpDeptsTl.setLastUpdateDate(paramOrganizationUnits.getLastUpdateDate() == null ? new Date() : paramOrganizationUnits.getLastUpdateDate());
        localFbpDeptsTl.setDeptId(localFbpDepts1.getDeptId());
        localFbpDeptsTl.setLanguage("ZHS");
        localFbpDeptsTl.setSourceLang("ZHS");
        localFbpDeptsTl.setDeptName(paramOrganizationUnits.getAttribute2());
        localFbpDeptsTl.setDeptLongName(paramOrganizationUnits.getAttribute2());
        getDeptDao().updateFbpDeptsTl(localFbpDeptsTl);
      }
    }
    return localFbpDepts1;
  }
  
  public String areaName(String paramString)
  {
    String str = null;
    if ("E".equals(paramString)) {
      str = "开发";
    } else if ("F".equals(paramString)) {
      str = "生产";
    } else if ("L".equals(paramString)) {
      str = "管理";
    } else if ("V".equals(paramString)) {
      str = "销售";
    }
    return str;
  }
  
  public FbpDepts[] saveOrUpdateList(OrganizationUnits[] paramArrayOfOrganizationUnits)
  {
    FbpDepts[] arrayOfFbpDepts = new FbpDepts[paramArrayOfOrganizationUnits.length];
    FbpDepts localFbpDepts = null;
    for (int i = 0; i < paramArrayOfOrganizationUnits.length; i++)
    {
      OrganizationUnits localOrganizationUnits = paramArrayOfOrganizationUnits[i];
      if (localOrganizationUnits != null)
      {
        localFbpDepts = saveOrUpdate(localOrganizationUnits);
        arrayOfFbpDepts[i] = localFbpDepts;
      }
    }
    return arrayOfFbpDepts;
  }
  
  public Message[] validatorList(OrganizationUnits[] paramArrayOfOrganizationUnits)
  {
    Integer localInteger = EisConsts.getLength(paramArrayOfOrganizationUnits);
    Message[] arrayOfMessage = new Message[localInteger.intValue()];
    Message localMessage = new Message();
    for (int i = 0; i < paramArrayOfOrganizationUnits.length; i++)
    {
      OrganizationUnits localOrganizationUnits = paramArrayOfOrganizationUnits[i];
      localMessage = validator(localOrganizationUnits);
      arrayOfMessage[i] = localMessage;
      if (!"True".equals(localMessage.getResult()))
      {
        paramArrayOfOrganizationUnits[i] = null;
        this.log.error("数据验证失败：" + (localOrganizationUnits == null ? null : localOrganizationUnits.getDeptCode()));
      }
    }
    return arrayOfMessage;
  }
  
  public IFbpDeptsDAO getDeptDao()
  {
    if (this.deptDao == null) {
      this.deptDao = ((IFbpDeptsDAO)SSBBus.findDaoService("fbpDeptsDAO"));
    }
    return this.deptDao;
  }
  
  public void setDeptDao(IFbpDeptsDAO paramIFbpDeptsDAO)
  {
    this.deptDao = paramIFbpDeptsDAO;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.getData.OranizationUnits.validator.OrganizationUnitsServiceValidatorImpl
 * JD-Core Version:    0.7.0.1
 */