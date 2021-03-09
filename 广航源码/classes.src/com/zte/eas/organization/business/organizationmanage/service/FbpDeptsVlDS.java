package com.zte.eas.organization.business.organizationmanage.service;

import com.zte.eas.organization.access.organizationmanage.dao.IFbpDeptsTreeVDAO;
import com.zte.eas.organization.access.organizationmanage.dao.IFbpDeptsVlDAO;
import com.zte.ssb.framework.base.BaseDomainService;
import java.math.BigInteger;
import java.util.List;

public class FbpDeptsVlDS
  extends BaseDomainService
  implements IFbpDeptsVlDS
{
  private IFbpDeptsVlDAO dao;
  private IFbpDeptsTreeVDAO fbpDeptsTreeVDAO;
  
  public List findDeptsVl()
  {
    return this.dao.findDeptsVl();
  }
  
  public List findDownDeptsVl(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      paramString1 = "0";
    }
    return this.fbpDeptsTreeVDAO.findDownDeptsVl(new BigInteger(paramString1), paramString2);
  }
  
  public List findAllDeptsVl(String paramString)
  {
    return this.fbpDeptsTreeVDAO.findAllDeptsVl(paramString);
  }
  
  public IFbpDeptsVlDAO getDao()
  {
    return this.dao;
  }
  
  public void setDao(IFbpDeptsVlDAO paramIFbpDeptsVlDAO)
  {
    this.dao = paramIFbpDeptsVlDAO;
  }
  
  public IFbpDeptsTreeVDAO getFbpDeptsTreeVDAO()
  {
    return this.fbpDeptsTreeVDAO;
  }
  
  public void setFbpDeptsTreeVDAO(IFbpDeptsTreeVDAO paramIFbpDeptsTreeVDAO)
  {
    this.fbpDeptsTreeVDAO = paramIFbpDeptsTreeVDAO;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.business.organizationmanage.service.FbpDeptsVlDS
 * JD-Core Version:    0.7.0.1
 */