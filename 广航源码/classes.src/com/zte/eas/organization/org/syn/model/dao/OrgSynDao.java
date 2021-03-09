package com.zte.eas.organization.org.syn.model.dao;

import com.cmcc.mss.sb_eas_eas_inquiryorginfosrv.InquiryORGInfoSrvOutputItem;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.zorm.Query;
import com.zte.ssb.zorm.SQLQuery;
import com.zte.ssb.zorm.Session;
import com.zte.ssb.zorm.Transaction;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class OrgSynDao
  extends BaseDAO
  implements IOrgSynDao
{
  private Logger log = Logger.getLogger(getClass());
  
  public boolean findOrg(List<InquiryORGInfoSrvOutputItem> paramList)
  {
    Object localObject = new ArrayList();
    if (paramList != null) {
      for (int i = 0; i < paramList.size(); i++)
      {
        String str1 = "select * from fbp_depts where  dept_code='" + ((InquiryORGInfoSrvOutputItem)paramList.get(i)).getDEPTCODE() + "'";
        localObject = getSession().createSQLQuery(str1).list();
        String str2 = "N";
        if ("1".equals(((InquiryORGInfoSrvOutputItem)paramList.get(i)).getENABLEDFLAG())) {
          str2 = "Y";
        }
        try
        {
          if (((List)localObject).size() == 0)
          {
            String str3 = "insert into fbp_depts (LAST_UPDATE_DATE,DEPT_ID,DEPT_CODE,ENABLED_FLAG,CREATED_BY,CREATION_DATE,LAST_UPDATED_BY,PARENT_DEPT_ID)values(sysdate,?,?,?,10000,sysdate,10000,?)";
            getSession().createSQLQuery(str3).setBigDecimal(0, ((InquiryORGInfoSrvOutputItem)paramList.get(i)).getDEPTID()).setString(1, ((InquiryORGInfoSrvOutputItem)paramList.get(i)).getDEPTCODE()).setString(2, str2).setBigDecimal(3, ((InquiryORGInfoSrvOutputItem)paramList.get(i)).getPARENTDEPTID()).executeUpdate();
            String str4 = "insert into FBP_DEPTS_TL(LAST_UPDATE_DATE,CREATED_BY,DEPT_NAME,CREATION_DATE,LAST_UPDATED_BY,dept_id,language,SOURCE_LANG) values(sysdate,10000,?,sysdate,10000,?,'ZHS','ZHS')";
            getSession().createSQLQuery(str4).setString(0, ((InquiryORGInfoSrvOutputItem)paramList.get(i)).getDEPTNAME()).setBigDecimal(1, ((InquiryORGInfoSrvOutputItem)paramList.get(i)).getDEPTID()).executeUpdate();
          }
          else
          {
            str1 = "update fbp_depts set LAST_UPDATE_DATE=sysdate,DEPT_ID=?,ENABLED_FLAG=?,CREATED_BY=10000,CREATION_DATE=sysdate,LAST_UPDATED_BY=10000,PARENT_DEPT_ID=? where DEPT_CODE=?";
            getSession().createSQLQuery(str1).setBigDecimal(0, ((InquiryORGInfoSrvOutputItem)paramList.get(i)).getDEPTID()).setString(1, str2).setBigDecimal(2, ((InquiryORGInfoSrvOutputItem)paramList.get(i)).getPARENTDEPTID()).setString(3, ((InquiryORGInfoSrvOutputItem)paramList.get(i)).getDEPTCODE()).executeUpdate();
            str1 = "update FBP_DEPTS_TL set dept_name=? where dept_id=?";
            getSession().createSQLQuery(str1).setString(0, ((InquiryORGInfoSrvOutputItem)paramList.get(i)).getDEPTNAME()).setBigDecimal(1, ((InquiryORGInfoSrvOutputItem)paramList.get(i)).getDEPTID()).executeUpdate();
          }
        }
        catch (Exception localException)
        {
          getSession().beginTransaction().rollback();
          this.log.error("同步部门更新数据库失败--DEPTID:" + ((InquiryORGInfoSrvOutputItem)paramList.get(i)).getDEPTID() + "DEPTCODE:" + ((InquiryORGInfoSrvOutputItem)paramList.get(i)).getDEPTCODE());
          this.log.error("Exception:", localException);
        }
      }
    }
    return true;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.org.syn.model.dao.OrgSynDao
 * JD-Core Version:    0.7.0.1
 */