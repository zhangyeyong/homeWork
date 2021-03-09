package com.zte.eas.organization.access.countcompanymanage;

import com.zte.eas.organization.business.countcompanymanage.model.FbpCompanyTl;
import com.zte.ssb.framework.base.BaseDAO;
import java.util.List;

public class FbpCompanyTlDAO
  extends BaseDAO
  implements IFbpCompanyTlDAO
{
  public void insertFbpCompanyTl(FbpCompanyTl paramFbpCompanyTl)
  {
    super.insertObject(paramFbpCompanyTl);
  }
  
  public <T> void insertFbpCompanyTls(List<FbpCompanyTl> paramList)
  {
    super.insertObjects(paramList);
  }
  
  public void updateFbpCompanyTl(FbpCompanyTl paramFbpCompanyTl)
  {
    super.updateObject(paramFbpCompanyTl);
  }
  
  public <T> void updateFbpCompanyTls(List<FbpCompanyTl> paramList)
  {
    super.updateObjects(paramList);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.access.countcompanymanage.FbpCompanyTlDAO
 * JD-Core Version:    0.7.0.1
 */