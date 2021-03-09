package com.zte.eas.organization.user.syn.model.dao;

import com.cmcc.mss.sb_eas_eas_inquiryusersinfosrv.InquiryUsersInfoSrvOutputItem;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.zorm.Query;
import com.zte.ssb.zorm.SQLQuery;
import com.zte.ssb.zorm.Session;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class UserSynDao
  extends BaseDAO
  implements IUserSynDao
{
  private Logger log = Logger.getLogger(getClass());
  
  public void synUser(List<InquiryUsersInfoSrvOutputItem> paramList)
  {
    Object localObject = new ArrayList();
    if (paramList != null) {
      for (int i = 0; i < paramList.size(); i++) {
        if (paramList.get(i) != null) {
          try
          {
            String str1 = "select * from fbp.FBP_EMPLOYEES where EMPLOYEE_NUMBER='" + ((InquiryUsersInfoSrvOutputItem)paramList.get(i)).getEMPLOYEENUM() + "'";
            localObject = getSession().createSQLQuery(str1).list();
            String str2 = "N";
            if ("1".equals(((InquiryUsersInfoSrvOutputItem)paramList.get(i)).getENABLEDFLAG())) {
              str2 = "Y";
            }
            if (((List)localObject).size() == 0)
            {
              str1 = "insert into FBP.FBP_EMPLOYEES(EMPLOYEE_NUMBER,PASSWORD,MOBILE_PHONE,LAST_UPDATED_BY,EMAIL_ADDRESS,ENABLED_FLAG,LAST_UPDATE_DATE,CREATED_BY,DEPT_ID,OA_ADDRESS,CREATION_DATE,EMPLOYEE_ID) values (?,?,?,10000,?,?,sysdate,10000,?,?,sysdate,FBP.FBP_EMPLOYEES_S.NEXTVAL)";
              getSession().createSQLQuery(str1).setString(0, ((InquiryUsersInfoSrvOutputItem)paramList.get(i)).getEMPLOYEENUM()).setString(1, ((InquiryUsersInfoSrvOutputItem)paramList.get(i)).getPASSWORD()).setString(2, ((InquiryUsersInfoSrvOutputItem)paramList.get(i)).getMOBILEPHONE()).setString(3, ((InquiryUsersInfoSrvOutputItem)paramList.get(i)).getEMAILADDRESS()).setString(4, str2).setBigDecimal(5, ((InquiryUsersInfoSrvOutputItem)paramList.get(i)).getDEPTID()).setString(6, ((InquiryUsersInfoSrvOutputItem)paramList.get(i)).getOAADDRESS()).executeUpdate();
              String str3 = "insert into FBP_EMPLOYEES_TL (CREATION_DATE,LAST_UPDATE_DATE,EMPLOYEE_NAME,CREATED_BY,EMPLOYEE_ID,LAST_UPDATED_BY,SOURCE_LANG,LANGUAGE) values(sysdate,sysdate,'" + ((InquiryUsersInfoSrvOutputItem)paramList.get(i)).getEMPLOYEENAME() + "',10000, FBP.FBP_EMPLOYEES_S.CURRVAL ,10000,'ZHS','ZHS')";
              getSession().createSQLQuery(str3).executeUpdate();
            }
            else
            {
              str1 = "update FBP.FBP_EMPLOYEES set EMPLOYEE_NUMBER=?, PASSWORD=?,MOBILE_PHONE=?,EMAIL_ADDRESS=?,ENABLED_FLAG=?,LAST_UPDATE_DATE=sysdate,DEPT_ID=?,OA_ADDRESS=? where EMPLOYEE_NUMBER='" + ((InquiryUsersInfoSrvOutputItem)paramList.get(i)).getEMPLOYEENUM() + "'";
              getSession().createSQLQuery(str1).setString(0, ((InquiryUsersInfoSrvOutputItem)paramList.get(i)).getEMPLOYEENUM()).setString(1, ((InquiryUsersInfoSrvOutputItem)paramList.get(i)).getPASSWORD()).setString(2, ((InquiryUsersInfoSrvOutputItem)paramList.get(i)).getMOBILEPHONE()).setString(3, ((InquiryUsersInfoSrvOutputItem)paramList.get(i)).getEMAILADDRESS()).setString(4, str2).setBigDecimal(5, ((InquiryUsersInfoSrvOutputItem)paramList.get(i)).getDEPTID()).setString(6, ((InquiryUsersInfoSrvOutputItem)paramList.get(i)).getOAADDRESS());
            }
          }
          catch (Exception localException)
          {
            this.log.error("同步人员更新数据库失败--EMPLOYEENUM:" + ((InquiryUsersInfoSrvOutputItem)paramList.get(i)).getEMPLOYEENUM());
            this.log.error("Exception:", localException);
          }
        }
      }
    }
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.user.syn.model.dao.UserSynDao
 * JD-Core Version:    0.7.0.1
 */