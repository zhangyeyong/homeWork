package com.zte.eas.organization.access.countcompanymanage;

import com.zte.eas.organization.business.countcompanymanage.model.FbpCompany;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.zorm.Query;
import com.zte.ssb.zorm.SQLQuery;
import com.zte.ssb.zorm.Session;
import java.util.List;

public class FbpCompanyDAO
  extends BaseDAO
  implements IFbpCompanyDAO
{
  public void insertFbpCompany(FbpCompany paramFbpCompany)
  {
    super.insertObject(paramFbpCompany);
  }
  
  public <T> void insertFbpCompanys(List<FbpCompany> paramList)
  {
    super.insertObjects(paramList);
  }
  
  public void updateFbpCompany(FbpCompany paramFbpCompany)
  {
    super.updateObject(paramFbpCompany);
  }
  
  public <T> void updateFbpCompanys(List<FbpCompany> paramList)
  {
    super.updateObjects(paramList);
  }
  
  public void lockCompanyById(Long paramLong)
  {
    getSession().createQuery("update FbpCompany y set y.companyCode=y.companyCode where y.companyId=? ").setLong(0, paramLong.longValue()).executeUpdate();
  }
  
  public FbpCompany getFbpCompany(String paramString)
  {
    String str = "select * from fbp.fbp_company fc where fc.company_code = ?";
    return (FbpCompany)super.getSession().createSQLQuery(str).addEntity(FbpCompany.class).setString(0, paramString).uniqueResult();
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.access.countcompanymanage.FbpCompanyDAO
 * JD-Core Version:    0.7.0.1
 */