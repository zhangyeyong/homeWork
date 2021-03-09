package com.zte.eas.organization.access.organizationmanage.dao;

import com.zte.eas.organization.business.organizationmanage.model.FbpDeptsName;
import com.zte.ssb.framework.base.DAO;
import java.util.List;

public abstract interface IFbpDeptsVlDAO
  extends DAO
{
  public abstract List findDeptsVl();
  
  public abstract List findDownDeptsVl(String paramString);
  
  public abstract FbpDeptsName findFbpDeptsVl(Long paramLong);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.access.organizationmanage.dao.IFbpDeptsVlDAO
 * JD-Core Version:    0.7.0.1
 */