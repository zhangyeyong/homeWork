package com.zte.eas.getData;

import com.zte.eas.getData.EmployeeSync.validator.IEmployeesServiceValidatorImpl;
import com.zte.eas.getData.OranizationUnits.model.OrganizationUnits;
import com.zte.eas.getData.OranizationUnits.services.Depts;
import com.zte.eas.getData.OranizationUnits.validator.IOrganizationUnitsServiceValidatorImpl;
import com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.services.EmployeeDept;
import com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.services.EmployeeDeptCollection;
import com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.services.MessageCollection;
import com.zte.eas.getData.util.EisConsts;
import com.zte.eas.organization.access.employeemanage.dao.IFbpEmployeesDAO;
import com.zte.eas.organization.access.organizationmanage.dao.IFbpDeptsDAO;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployees;
import com.zte.eas.organization.business.organizationmanage.model.FbpDepts;
import com.zte.evs.ebill.common.ObjectCopyUtils;
import com.zte.ssb.framework.SSBBus;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;

public class SyncDataDS
  implements ISyncDataDS
{
  Logger logger = Logger.getLogger(SyncDataDS.class);
  
  public com.zte.eas.getData.EmployeeSync.services.Message[] syncEmployees(com.zte.eas.getData.EmployeeSync.services.Employees[] paramArrayOfEmployees)
  {
    com.zte.eas.getData.EmployeeSync.services.Message[] arrayOfMessage = new com.zte.eas.getData.EmployeeSync.services.Message[1];
    if ((paramArrayOfEmployees == null) || (paramArrayOfEmployees.length == 0))
    {
      localObject = new com.zte.eas.getData.EmployeeSync.services.Message();
      ((com.zte.eas.getData.EmployeeSync.services.Message)localObject).setErrCode("EAS000001");
      ((com.zte.eas.getData.EmployeeSync.services.Message)localObject).setErrInfos("输入不能为空");
      ((com.zte.eas.getData.EmployeeSync.services.Message)localObject).setResult("False");
      arrayOfMessage[0] = localObject;
      return arrayOfMessage;
    }
    Object localObject = new ArrayList();
    IEmployeesServiceValidatorImpl localIEmployeesServiceValidatorImpl = (IEmployeesServiceValidatorImpl)SSBBus.findDomainService("employeesServiceValidatorImpl");
    for (int i = 0; i < paramArrayOfEmployees.length; i++)
    {
      com.zte.eas.getData.EmployeeSync.services.Employees localEmployees = paramArrayOfEmployees[i];
      EisConsts.printMsg(localEmployees, this.logger);
      com.zte.eas.getData.EmployeeSync.model.Employees localEmployees1 = new com.zte.eas.getData.EmployeeSync.model.Employees();
      localEmployees1.setAttribute3(localEmployees.getAttribute3());
      localEmployees1.setAttribute5(localEmployees.getAttribute5());
      localEmployees1.setAttribute8(localEmployees.getAttribute8());
      localEmployees1.setDataType(localEmployees.getDataType());
      localEmployees1.setDeptCode(localEmployees.getDeptCode());
      localEmployees1.setEmailAddress(localEmployees.getEmailAddress());
      localEmployees1.setEmployeeName(localEmployees.getEmployeeName());
      localEmployees1.setEmployeeNumber(localEmployees.getEmployeeNumber());
      localEmployees1.setEnabledFlag(localEmployees.getEnabledFlag());
      localEmployees1.setIdCard(localEmployees.getIdCard());
      localEmployees1.setMobilePhone(localEmployees.getMobilePhone());
      localEmployees1.setOaAddress(localEmployees.getOaAddress());
      localEmployees1.setSourceReference(localEmployees.getSourceReference());
      localEmployees1.setSourceType(localEmployees.getSourceType());
      localEmployees1.setSysnceDate(localEmployees.getSysnceDate() == null ? new Date() : localEmployees.getSysnceDate().getTime());
      com.zte.eas.getData.OranizationUnits.model.Message localMessage = localIEmployeesServiceValidatorImpl.validator(localEmployees1);
      com.zte.eas.getData.EmployeeSync.services.Message localMessage2 = new com.zte.eas.getData.EmployeeSync.services.Message();
      if (localMessage != null) {
        ObjectCopyUtils.copy(localMessage, localMessage2);
      }
      if ("True".equals(localMessage2.getResult())) {
        localIEmployeesServiceValidatorImpl.saveOrUpdate(localEmployees1);
      } else {
        ((List)localObject).add(localMessage2);
      }
    }
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      arrayOfMessage = new com.zte.eas.getData.EmployeeSync.services.Message[((List)localObject).size()];
      for (i = 0; i < ((List)localObject).size(); i++)
      {
        arrayOfMessage[i] = ((com.zte.eas.getData.EmployeeSync.services.Message)((List)localObject).get(i));
        EisConsts.printMsg(((List)localObject).get(i), this.logger);
      }
      return arrayOfMessage;
    }
    com.zte.eas.getData.EmployeeSync.services.Message localMessage1 = new com.zte.eas.getData.EmployeeSync.services.Message();
    localMessage1.setErrInfos("数据保存成功");
    localMessage1.setResult("True");
    EisConsts.printMsg(localMessage1, this.logger);
    arrayOfMessage[0] = localMessage1;
    return arrayOfMessage;
  }
  
  public com.zte.eas.getData.OranizationUnits.services.Message[] syncDepts(Depts[] paramArrayOfDepts)
  {
    com.zte.eas.getData.OranizationUnits.services.Message[] arrayOfMessage = new com.zte.eas.getData.OranizationUnits.services.Message[1];
    if ((paramArrayOfDepts == null) || (paramArrayOfDepts.length == 0))
    {
      localObject = new com.zte.eas.getData.OranizationUnits.services.Message();
      ((com.zte.eas.getData.OranizationUnits.services.Message)localObject).setErrCode("EAS000001");
      ((com.zte.eas.getData.OranizationUnits.services.Message)localObject).setErrInfos("输入不能为空");
      ((com.zte.eas.getData.OranizationUnits.services.Message)localObject).setResult("False");
      arrayOfMessage[0] = localObject;
      return arrayOfMessage;
    }
    Object localObject = new ArrayList();
    IOrganizationUnitsServiceValidatorImpl localIOrganizationUnitsServiceValidatorImpl = (IOrganizationUnitsServiceValidatorImpl)SSBBus.findDomainService("organizationUnitsServiceValidatorImpl");
    OrganizationUnits[] arrayOfOrganizationUnits = new OrganizationUnits[paramArrayOfDepts.length];
    for (int i = 0; i < paramArrayOfDepts.length; i++)
    {
      Depts localDepts = paramArrayOfDepts[i];
      EisConsts.printMsg(localDepts, this.logger);
      OrganizationUnits localOrganizationUnits = new OrganizationUnits();
      localOrganizationUnits.setAttribute2(localDepts.getAttribute2());
      localOrganizationUnits.setAttribute3(localDepts.getAttribute3());
      localOrganizationUnits.setAttribute4(localDepts.getAttribute4());
      localOrganizationUnits.setAttribute5(localDepts.getAttribute5());
      localOrganizationUnits.setAttribute6(localDepts.getAttribute6());
      localOrganizationUnits.setAttribute7(localDepts.getAttribute7());
      localOrganizationUnits.setAttribute8(localDepts.getAttribute8());
      localOrganizationUnits.setCreatedBy(localDepts.getCreatedBy());
      localOrganizationUnits.setCreationDate(localDepts.getCreationDate() == null ? new Date() : localDepts.getCreationDate().getTime());
      localOrganizationUnits.setDeptCode(localDepts.getDeptCode());
      localOrganizationUnits.setEnabledFlag(localDepts.getEnabledFlag());
      localOrganizationUnits.setLastUpdateDate(localDepts.getLastUpdateDate() == null ? new Date() : localDepts.getLastUpdateDate().getTime());
      localOrganizationUnits.setLastUpdatedBy(localDepts.getLastUpdatedBy());
      localOrganizationUnits.setLastUpdateLogin(localDepts.getLastUpdateLogin());
      localOrganizationUnits.setSysnceDate(localDepts.getSysnceDate() == null ? new Date() : localDepts.getSysnceDate().getTime());
      arrayOfOrganizationUnits[i] = localOrganizationUnits;
      com.zte.eas.getData.OranizationUnits.model.Message localMessage = localIOrganizationUnitsServiceValidatorImpl.validator(localOrganizationUnits);
      com.zte.eas.getData.OranizationUnits.services.Message localMessage2 = new com.zte.eas.getData.OranizationUnits.services.Message();
      if (localMessage != null) {
        ObjectCopyUtils.copy(localMessage, localMessage2);
      }
      if ("True".equals(localMessage2.getResult())) {
        localIOrganizationUnitsServiceValidatorImpl.saveOrUpdate(localOrganizationUnits);
      } else {
        ((List)localObject).add(localMessage2);
      }
    }
    localIOrganizationUnitsServiceValidatorImpl.updateParentDept(arrayOfOrganizationUnits);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      arrayOfMessage = new com.zte.eas.getData.OranizationUnits.services.Message[((List)localObject).size()];
      for (i = 0; i < ((List)localObject).size(); i++)
      {
        arrayOfMessage[i] = ((com.zte.eas.getData.OranizationUnits.services.Message)((List)localObject).get(i));
        EisConsts.printMsg(((List)localObject).get(i), this.logger);
      }
      return arrayOfMessage;
    }
    com.zte.eas.getData.OranizationUnits.services.Message localMessage1 = new com.zte.eas.getData.OranizationUnits.services.Message();
    localMessage1.setErrInfos("数据保存成功");
    localMessage1.setResult("True");
    EisConsts.printMsg(localMessage1, this.logger);
    arrayOfMessage[0] = localMessage1;
    return arrayOfMessage;
  }
  
  public MessageCollection updateEmployeeDept(EmployeeDeptCollection paramEmployeeDeptCollection)
  {
    MessageCollection localMessageCollection = new MessageCollection();
    if ((paramEmployeeDeptCollection == null) || (paramEmployeeDeptCollection.getEmployeeDeptList() == null) || (paramEmployeeDeptCollection.getEmployeeDeptList().length == 0))
    {
      localObject1 = new com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.services.Message[1];
      com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.services.Message localMessage1 = new com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.services.Message();
      localMessage1.setErrCode("EAS000001");
      localMessage1.setErrInfos("输入不能为空");
      localMessage1.setResult("False");
      localObject1[0] = localMessage1;
      localMessageCollection.setMessageList((com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.services.Message[])localObject1);
      return localMessageCollection;
    }
    Object localObject1 = new ArrayList();
    for (int i = 0; i < paramEmployeeDeptCollection.getEmployeeDeptList().length; i++)
    {
      EmployeeDept localEmployeeDept = paramEmployeeDeptCollection.getEmployeeDeptList()[i];
      EisConsts.printMsg(localEmployeeDept, this.logger);
      Object localObject2;
      if ((localEmployeeDept.getDeptCode() == null) || (localEmployeeDept.getDeptCode().trim().length() == 0))
      {
        localObject2 = new com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.services.Message();
        ((com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.services.Message)localObject2).setErrCode("EAS000001");
        ((com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.services.Message)localObject2).setErrInfos("部门编号不能为空");
        ((com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.services.Message)localObject2).setResult("False");
        ((List)localObject1).add(localObject2);
      }
      else if ((localEmployeeDept.getEmployeeNumber() == null) || (localEmployeeDept.getEmployeeNumber().trim().length() == 0))
      {
        localObject2 = new com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.services.Message();
        ((com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.services.Message)localObject2).setErrCode("EAS000001");
        ((com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.services.Message)localObject2).setErrInfos("员工编号不能为空");
        ((com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.services.Message)localObject2).setResult("False");
        ((List)localObject1).add(localObject2);
      }
      else
      {
        localObject2 = (IFbpDeptsDAO)SSBBus.findDomainService("fbpDeptsDAO");
        FbpDepts localFbpDepts = ((IFbpDeptsDAO)localObject2).getFbpDeptsByCode(localEmployeeDept.getDeptCode());
        Object localObject3;
        if ((localFbpDepts == null) || (localFbpDepts.getDeptId() == null))
        {
          localObject3 = new com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.services.Message();
          ((com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.services.Message)localObject3).setErrCode("EAS000003");
          ((com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.services.Message)localObject3).setErrInfos("部门编号不存在=" + localEmployeeDept.getDeptCode());
          ((com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.services.Message)localObject3).setResult("False");
          ((List)localObject1).add(localObject3);
        }
        else
        {
          localObject3 = (IFbpEmployeesDAO)SSBBus.findDomainService("fbpEmployeesDAO");
          FbpEmployees localFbpEmployees = ((IFbpEmployeesDAO)localObject3).getFbpEmployees(localEmployeeDept.getEmployeeNumber());
          if ((localFbpEmployees == null) || (localFbpEmployees.getEmployeeId() == null))
          {
            com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.services.Message localMessage3 = new com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.services.Message();
            localMessage3.setErrCode("EAS000003");
            localMessage3.setErrInfos("员工编号不存在=" + localEmployeeDept.getEmployeeNumber());
            localMessage3.setResult("False");
            ((List)localObject1).add(localMessage3);
          }
          else
          {
            localFbpEmployees.setDeptId(localFbpDepts.getDeptId());
            ((IFbpEmployeesDAO)localObject3).updateFbpEmployees(localFbpEmployees);
          }
        }
      }
    }
    com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.services.Message[] arrayOfMessage;
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      arrayOfMessage = new com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.services.Message[((List)localObject1).size()];
      for (int j = 0; j < ((List)localObject1).size(); j++)
      {
        arrayOfMessage[j] = ((com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.services.Message)((List)localObject1).get(j));
        EisConsts.printMsg(((List)localObject1).get(j), this.logger);
      }
      localMessageCollection.setMessageList(arrayOfMessage);
    }
    else
    {
      arrayOfMessage = new com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.services.Message[1];
      com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.services.Message localMessage2 = new com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.services.Message();
      localMessage2.setErrInfos("数据保存成功");
      localMessage2.setResult("True");
      arrayOfMessage[0] = localMessage2;
      EisConsts.printMsg(localMessage2, this.logger);
      localMessageCollection.setMessageList(arrayOfMessage);
    }
    return localMessageCollection;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.getData.SyncDataDS
 * JD-Core Version:    0.7.0.1
 */