package com.zte.eas.bmsctrl.ws.FbEmployee.dao;

import com.zte.eas.bmsctrl.ws.Fb_SC_CMS_000011.FbpEmployee;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployees;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.zorm.Query;
import com.zte.ssb.zorm.SQLQuery;
import com.zte.ssb.zorm.Session;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class FbpEmployeeDao
  extends BaseDAO
  implements IFbpEmployeeDao
{
  public void insetEmployee(FbpEmployee[] paramArrayOfFbpEmployee)
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = new ArrayList();
    for (int i = 0; i < paramArrayOfFbpEmployee.length; i++)
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      String str1 = localSimpleDateFormat.format(paramArrayOfFbpEmployee[i].getLastUpdateDate());
      String str2 = "select * from fbp.FBP_EMPLOYEES where EMPLOYEE_NUMBER='" + paramArrayOfFbpEmployee[i].getEmployeeNum() + "'";
      localObject1 = getSession().createSQLQuery(str2).list();
      String str3;
      if (((List)localObject1).size() == 0)
      {
        str2 = "insert into FBP.FBP_EMPLOYEES(EMPLOYEE_NUMBER,PASSWORD,MOBILE_PHONE,LAST_UPDATED_BY,EMAIL_ADDRESS,ENABLED_FLAG,LAST_UPDATE_DATE,CREATED_BY,DEPT_ID,OA_ADDRESS,CREATION_DATE,EMPLOYEE_ID) values (?,?,?,10000,?,?,?,10000,?,?,sysdate,FBP.FBP_EMPLOYEES_S.NEXTVAL)";
        getSession().createSQLQuery(str2).setString(0, paramArrayOfFbpEmployee[i].getEmployeeNum()).setString(1, paramArrayOfFbpEmployee[i].getPassword()).setString(2, paramArrayOfFbpEmployee[i].getPhone()).setString(3, paramArrayOfFbpEmployee[i].getEmail()).setString(4, paramArrayOfFbpEmployee[i].getEnabledFlag()).setTimestamp(5, paramArrayOfFbpEmployee[i].getLastUpdateDate()).setLong(6, paramArrayOfFbpEmployee[i].getDeptId().longValue()).setString(7, paramArrayOfFbpEmployee[i].getOaAdress()).executeUpdate();
        str3 = null;
        String str4 = "insert into FBP_EMPLOYEES_TL (CREATION_DATE,LAST_UPDATE_DATE,EMPLOYEE_NAME,SOURCE_LANG,CREATED_BY,EMPLOYEE_ID,LAST_UPDATED_BY) values(sysdate,?,'" + paramArrayOfFbpEmployee[i].getEmployeeName() + "','" + paramArrayOfFbpEmployee[i].getLanguage() + "',10000, FBP.FBP_EMPLOYEES_S.CURRVAL ,10000)";
        getSession().createSQLQuery(str4).setTimestamp(0, paramArrayOfFbpEmployee[i].getLastUpdateDate()).executeUpdate();
      }
      else
      {
        str2 = "select * from fbp.FBP_EMPLOYEES where EMPLOYEE_NUMBER='" + paramArrayOfFbpEmployee[i].getEmployeeNum() + "' and to_char(last_update_date,'yyyy-MM-dd HH24:MI:ss')='" + str1 + "'";
        localObject2 = getSession().createSQLQuery(str2).list();
        if (((List)localObject2).size() == 0)
        {
          str2 = "update FBP.FBP_EMPLOYEES set EMPLOYEE_NUMBER=?, PASSWORD=?,MOBILE_PHONE=?,EMAIL_ADDRESS=?,ENABLED_FLAG=?,LAST_UPDATE_DATE=?,DEPT_ID=?,OA_ADDRESS=?,";
          getSession().createSQLQuery(str2).setString(0, paramArrayOfFbpEmployee[i].getEmployeeNum()).setString(1, paramArrayOfFbpEmployee[i].getPassword()).setString(2, paramArrayOfFbpEmployee[i].getPhone()).setString(3, paramArrayOfFbpEmployee[i].getEmail()).setString(4, paramArrayOfFbpEmployee[i].getEnabledFlag()).setTimestamp(5, paramArrayOfFbpEmployee[i].getLastUpdateDate()).setLong(6, paramArrayOfFbpEmployee[i].getDeptId().longValue()).setString(7, paramArrayOfFbpEmployee[i].getOaAdress());
          str3 = "update FBP_EMPLOYEES_TL set EMPLOYEE_NAME=?,SOURCE_LANG=?";
          getSession().createSQLQuery(str3).setString(0, paramArrayOfFbpEmployee[i].getEmployeeName()).setString(1, paramArrayOfFbpEmployee[i].getLanguage()).executeUpdate();
        }
      }
    }
  }
  
  public FbpEmployees getFbpEmployees(String paramString)
  {
    String str = "from FbpEmployees where employeeNumber =?";
    return (FbpEmployees)super.getSession().createQuery(str).setString(0, paramString).uniqueResult();
  }
  
  public void updateFbpEmployees(FbpEmployees paramFbpEmployees)
  {
    super.updateObject(paramFbpEmployees);
  }
  
  public void insertFbpEmployees(FbpEmployees paramFbpEmployees)
  {
    super.insertObject(paramFbpEmployees);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.bmsctrl.ws.FbEmployee.dao.FbpEmployeeDao
 * JD-Core Version:    0.7.0.1
 */