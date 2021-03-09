package com.zte.eas.getData.EmployeeSync.validator;

import com.zte.eas.appframe.business.syscommon.InfoMapEncrypt;
import com.zte.eas.appframe.business.util.ObjectCopyUtils;
import com.zte.eas.getData.EmployeeSync.model.Employees;
import com.zte.eas.getData.OranizationUnits.dao.IEmployeesDAO;
import com.zte.eas.getData.OranizationUnits.model.Message;
import com.zte.eas.getData.OranizationUnits.validator.BasicValidatorImpl;
import com.zte.eas.getData.OranizationUnits.validator.ObjectServiceValidator;
import com.zte.eas.getData.util.EisConsts;
import com.zte.eas.organization.access.countcompanymanage.IFbpCompanyDAO;
import com.zte.eas.organization.access.organizationmanage.dao.IFbpDeptsDAO;
import com.zte.eas.organization.business.countcompanymanage.model.FbpCompany;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployees;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesTl;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesTlPk;
import com.zte.ssb.framework.SSBBus;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmployeesServiceValidatorImpl
  extends BasicValidatorImpl
  implements ObjectServiceValidator<FbpEmployees, Employees>, IEmployeesServiceValidatorImpl
{
  Logger log = LoggerFactory.getLogger(getClass());
  private IEmployeesDAO employeesDAO;
  private IFbpDeptsDAO deptDao;
  
  public Message validator(Employees paramEmployees)
  {
    this.deptDao = getDeptDao();
    this.log.error("数据：" + (paramEmployees == null ? null : paramEmployees.toString()));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("employeeNumber");
    localArrayList.add("employeeName");
    localArrayList.add("attribute5");
    localArrayList.add("attribute3");
    Message localMessage = valueIsNull(paramEmployees, localArrayList);
    if (!"True".equals(localMessage.getResult())) {
      return localMessage;
    }
    if (paramEmployees == null)
    {
      localMessage.setErrCode("EAS000001");
      localMessage.setErrInfos("对象为空： employees:  " + paramEmployees);
      localMessage.setResult("False");
      return localMessage;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("employeeNumber", Integer.valueOf(30));
    localHashMap.put("employeeName", Integer.valueOf(30));
    localMessage = maxLength(paramEmployees, localHashMap);
    if (!"True".equals(localMessage.getResult())) {
      return localMessage;
    }
    if ((paramEmployees != null) && (paramEmployees.getAttribute3() != null) && (!paramEmployees.getAttribute3().equals("")))
    {
      localObject = paramEmployees.getAttribute3();
      if ((!((String)localObject).equals("1")) && (!((String)localObject).equals("2")) && (!((String)localObject).equals("3")) && (!((String)localObject).equals("4")) && (!((String)localObject).equals("9"))) {
        return buildMessage("EAS000003", (String)localObject);
      }
      if ((paramEmployees.getAttribute3().equals("1")) || (paramEmployees.getAttribute3().equals("2"))) {
        paramEmployees.setAttribute3("在职");
      } else if ((paramEmployees.getAttribute3().equals("3")) || (paramEmployees.getAttribute3().equals("4")) || (paramEmployees.getAttribute3().equals("9"))) {
        paramEmployees.setAttribute3("不在职");
      }
    }
    if (StringUtils.isBlank(paramEmployees.getEnabledFlag()))
    {
      this.log.error("enabledFlag 字段为空,则设为默认值:{} 表示启用", "A");
      paramEmployees.setEnabledFlag("Y");
    }
    else if ((!"Y".equals(paramEmployees.getEnabledFlag())) && (!"N".equals(paramEmployees.getEnabledFlag())))
    {
      return buildMessage("EAS000003", "enabledFlag");
    }
    Object localObject = (IFbpCompanyDAO)SSBBus.findDomainService("fbpCompanyDAO");
    FbpCompany localFbpCompany = ((IFbpCompanyDAO)localObject).getFbpCompany(paramEmployees.getAttribute5());
    if ((localFbpCompany == null) || (localFbpCompany.getCompanyId() == null))
    {
      localMessage.setErrCode("EAS000003");
      localMessage.setErrInfos("公司代码错误：" + paramEmployees.getAttribute5());
      localMessage.setResult("False");
      this.log.error("公司代码错误：" + paramEmployees.getAttribute5());
      return localMessage;
    }
    this.log.error(" 数据验证通过: " + paramEmployees.getEmployeeNumber());
    localMessage.setResult("True");
    return localMessage;
  }
  
  public FbpEmployees saveOrUpdate(Employees paramEmployees)
  {
    this.deptDao = getDeptDao();
    FbpEmployees localFbpEmployees = null;
    String str1 = paramEmployees.getEmailAddress();
    String str2 = "";
    localFbpEmployees = getEmployeesDAO().findEmployeesByEmployeeNumber(paramEmployees.getEmployeeNumber());
    Object localObject1;
    String str5;
    Object localObject2;
    if ((localFbpEmployees == null) || (localFbpEmployees.getEmployeeId() == null))
    {
      this.log.error("新增操作，employeeNumber ={}", paramEmployees.getEmployeeNumber());
      localFbpEmployees = new FbpEmployees();
      ObjectCopyUtils.copy(paramEmployees, localFbpEmployees);
      localFbpEmployees.setLastUpdateDate(new Date());
      localFbpEmployees.setLastUpdatedBy(Long.valueOf(1L));
      localFbpEmployees.setCreationDate(new Date());
      localFbpEmployees.setCreatedBy(Long.valueOf(1L));
      if (!StringUtils.isBlank(str1))
      {
        if (str1.indexOf("/") != -1) {
          str2 = str1.substring(0, str1.indexOf("/")) + "@haier.com";
        } else if (str1.indexOf("@") != -1) {
          str2 = str1;
        } else {
          str2 = str1 + "@haier.com";
        }
        localFbpEmployees.setEmailAddress(str2);
      }
      if ((paramEmployees.getSysnceDate() != null) && (paramEmployees.getSysnceDate().equals(""))) {}
      localObject1 = paramEmployees.getIdCard();
      if ((localObject1 != null) && (((String)localObject1).length() > 6)) {
        localObject1 = ((String)localObject1).substring(((String)localObject1).length() - 6);
      }
      String str3 = null;
      if ((localObject1 != null) && (((String)localObject1).length() == 6)) {
        str3 = InfoMapEncrypt.encrypt((String)localObject1);
      }
      if ((str3 != null) && (!str3.trim().equals("")))
      {
        localFbpEmployees.setPassword(str3);
        this.log.error("员工密码初始化成功!");
      }
      getEmployeesDAO().insertObject(localFbpEmployees);
      for (str5 : EisConsts.LANGUAGE_LIST)
      {
        localObject2 = new FbpEmployeesTl();
        FbpEmployeesTlPk localFbpEmployeesTlPk = new FbpEmployeesTlPk();
        ((FbpEmployeesTl)localObject2).setLastUpdateDate(new Date());
        ((FbpEmployeesTl)localObject2).setLastUpdatedBy(Long.valueOf(1L));
        ((FbpEmployeesTl)localObject2).setCreatedBy(Long.valueOf(1L));
        ((FbpEmployeesTl)localObject2).setCreationDate(new Date());
        ((FbpEmployeesTl)localObject2).setSourceLang(str5);
        ((FbpEmployeesTl)localObject2).setEmployeeName(paramEmployees.getEmployeeName());
        localFbpEmployeesTlPk.setEmployeeId(localFbpEmployees.getEmployeeId());
        localFbpEmployeesTlPk.setLanguage(str5);
        ((FbpEmployeesTl)localObject2).setEmployeePkTl(localFbpEmployeesTlPk);
        getEmployeesDAO().insertObject(localObject2);
      }
      return localFbpEmployees;
    }
    if (null != localFbpEmployees)
    {
      this.log.error("修改操作，employeeNumber ={}", paramEmployees.getEmployeeNumber());
      ObjectCopyUtils.copy(paramEmployees, localFbpEmployees);
      localFbpEmployees.setLastUpdateDate(new Date());
      if (((paramEmployees.getSysnceDate() == null) || (!paramEmployees.getSysnceDate().equals(""))) || (!StringUtils.isBlank(str1)))
      {
        if (str1.indexOf("/") != -1) {
          str2 = str1.substring(0, str1.indexOf("/")) + "@haier.com";
        } else if (str1.indexOf("@") != -1) {
          str2 = str1;
        } else {
          str2 = str1 + "@haier.com";
        }
        localFbpEmployees.setEmailAddress(str2);
      }
      getEmployeesDAO().updateObject(localFbpEmployees);
      for (String str4 : EisConsts.LANGUAGE_LIST)
      {
        FbpEmployeesTl localFbpEmployeesTl = getEmployeesDAO().findEmployeesTlByEmployeeId(Long.valueOf(Long.parseLong(localFbpEmployees.getEmployeeId().toString())), str4);
        str5 = "UPDATE";
        if (localFbpEmployeesTl == null)
        {
          localFbpEmployeesTl = new FbpEmployeesTl();
          str5 = "ADD";
        }
        localObject2 = new FbpEmployeesTlPk();
        ((FbpEmployeesTlPk)localObject2).setEmployeeId(localFbpEmployees.getEmployeeId());
        ((FbpEmployeesTlPk)localObject2).setLanguage(str4);
        localFbpEmployeesTl.setEmployeePkTl((FbpEmployeesTlPk)localObject2);
        localFbpEmployeesTl.setCreatedBy(Long.valueOf(1L));
        localFbpEmployeesTl.setCreationDate(new Date());
        localFbpEmployeesTl.setLastUpdatedBy(Long.valueOf(1L));
        localFbpEmployeesTl.setSourceLang(str4);
        localFbpEmployeesTl.setLastUpdateDate(new Date());
        localFbpEmployeesTl.setLastUpdateLogin(Long.valueOf(1L));
        localFbpEmployeesTl.setEmployeeName(paramEmployees.getEmployeeName());
        if ("UPDATE".equals(str5)) {
          getEmployeesDAO().updateObject(localFbpEmployeesTl);
        } else {
          getEmployeesDAO().insertObject(localFbpEmployeesTl);
        }
      }
      return localFbpEmployees;
    }
    return null;
  }
  
  public IEmployeesDAO getEmployeesDAO()
  {
    if (this.employeesDAO == null) {
      this.employeesDAO = ((IEmployeesDAO)SSBBus.findDomainService("employeesDAO"));
    }
    return this.employeesDAO;
  }
  
  public void setEmployeesDAO(IEmployeesDAO paramIEmployeesDAO)
  {
    this.employeesDAO = paramIEmployeesDAO;
  }
  
  public FbpEmployees[] saveOrUpdateList(Employees[] paramArrayOfEmployees)
  {
    FbpEmployees[] arrayOfFbpEmployees = new FbpEmployees[paramArrayOfEmployees.length];
    FbpEmployees localFbpEmployees = null;
    for (int i = 0; i < paramArrayOfEmployees.length; i++)
    {
      Employees localEmployees = paramArrayOfEmployees[i];
      if (localEmployees != null)
      {
        localFbpEmployees = saveOrUpdate(localEmployees);
        arrayOfFbpEmployees[i] = localFbpEmployees;
      }
    }
    return arrayOfFbpEmployees;
  }
  
  public Message[] validatorList(Employees[] paramArrayOfEmployees)
  {
    Integer localInteger = EisConsts.getLength(paramArrayOfEmployees);
    Message[] arrayOfMessage = new Message[localInteger.intValue()];
    Message localMessage = new Message();
    for (int i = 0; i < paramArrayOfEmployees.length; i++)
    {
      Employees localEmployees = paramArrayOfEmployees[i];
      localMessage = validator(localEmployees);
      arrayOfMessage[i] = localMessage;
      if (!"True".equals(localMessage.getResult()))
      {
        paramArrayOfEmployees[i] = null;
        this.log.error("数据验证失败：" + (localEmployees == null ? null : localEmployees.getEmployeeNumber()));
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
 * Qualified Name:     com.zte.eas.getData.EmployeeSync.validator.EmployeesServiceValidatorImpl
 * JD-Core Version:    0.7.0.1
 */