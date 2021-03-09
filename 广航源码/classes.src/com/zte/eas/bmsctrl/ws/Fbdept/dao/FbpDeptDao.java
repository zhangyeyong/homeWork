package com.zte.eas.bmsctrl.ws.Fbdept.dao;

import com.zte.eas.bmsctrl.ws.Fbdept_SC_CMS_00001.FbpDeptsVll;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.zorm.Query;
import com.zte.ssb.zorm.SQLQuery;
import com.zte.ssb.zorm.Session;
import com.zte.ssb.zorm.Transaction;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class FbpDeptDao
  extends BaseDAO
  implements IFbpDeptDao
{
  public void insertDept(FbpDeptsVll[] paramArrayOfFbpDeptsVll)
  {
    Object localObject1 = null;
    Object localObject2 = new ArrayList();
    Object localObject3 = new ArrayList();
    for (int i = 0; i < paramArrayOfFbpDeptsVll.length; i++)
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      String str1 = localSimpleDateFormat.format(paramArrayOfFbpDeptsVll[i].getLastUpdateDate());
      String str2 = "select * from fbp_depts where  dept_code='" + paramArrayOfFbpDeptsVll[i].getDeptCode() + "'";
      String str3 = "select * from fbp_depts where to_char(last_update_date,'yyyy-MM-dd HH24:MI:ss')='" + str1 + "' AND dept_code='" + paramArrayOfFbpDeptsVll[i].getDeptCode() + "'";
      localObject2 = getSession().createSQLQuery(str2).list();
      if (((List)localObject2).size() == 0)
      {
        try
        {
          String str4 = "insert into fbp_depts (LAST_UPDATE_DATE,DEPT_ID,DEPT_CODE,DEFAULT_CHECK_UNIT,ENABLED_FLAG,CREATED_BY,CREATION_DATE,LAST_UPDATED_BY,PARENT_DEPT_ID)values(?,?,?,?,?,10000,sysdate,10000,?)";
          getSession().createSQLQuery(str4).setTimestamp(0, paramArrayOfFbpDeptsVll[i].getLastUpdateDate()).setLong(1, paramArrayOfFbpDeptsVll[i].getDeptId().longValue()).setString(2, paramArrayOfFbpDeptsVll[i].getDeptCode()).setString(3, paramArrayOfFbpDeptsVll[i].getDefaultCheckUnit()).setString(4, paramArrayOfFbpDeptsVll[i].getEnabledFlag()).setLong(5, paramArrayOfFbpDeptsVll[i].getParentId().longValue()).executeUpdate();
          String str5 = "insert into FBP_DEPTS_TL(LAST_UPDATE_DATE,CREATED_BY,DEPT_NAME,CREATION_DATE,LAST_UPDATED_BY,SOURCE_LANG,dept_id) values(?,10000,?,sysdate,10000,?,?)";
          getSession().createSQLQuery(str5).setTimestamp(0, paramArrayOfFbpDeptsVll[i].getLastUpdateDate()).setString(1, paramArrayOfFbpDeptsVll[i].getDeptName()).setString(2, paramArrayOfFbpDeptsVll[i].getLanguage()).setLong(3, paramArrayOfFbpDeptsVll[i].getDeptId().longValue()).executeUpdate();
        }
        catch (Exception localException)
        {
          getSession().beginTransaction().rollback();
          localException.printStackTrace();
        }
      }
      else
      {
        localObject3 = getSession().createSQLQuery(str3).list();
        if (((List)localObject3).size() == 0)
        {
          str2 = "update fbp_depts set LAST_UPDATE_DATE=?,DEPT_ID=?,DEFAULT_CHECK_UNIT=?,ENABLED_FLAG=?,CREATED_BY=10000,CREATION_DATE=sysdate,LAST_UPDATED_BY=10000,PARENT_DEPT_ID=? where DEPT_CODE=?";
          getSession().createSQLQuery(str2).setTimestamp(0, paramArrayOfFbpDeptsVll[i].getLastUpdateDate()).setLong(1, paramArrayOfFbpDeptsVll[i].getDeptId().longValue()).setString(2, paramArrayOfFbpDeptsVll[i].getDefaultCheckUnit()).setString(3, paramArrayOfFbpDeptsVll[i].getEnabledFlag()).setLong(4, paramArrayOfFbpDeptsVll[i].getParentId().longValue()).setString(5, paramArrayOfFbpDeptsVll[i].getDeptCode()).executeUpdate();
        }
      }
    }
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.bmsctrl.ws.Fbdept.dao.FbpDeptDao
 * JD-Core Version:    0.7.0.1
 */