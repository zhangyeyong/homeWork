package com.zte.eas.organization.business.organizationmanage.service;

import com.zte.ssb.framework.base.DomainService;
import java.util.List;

public abstract interface IFbpDeptsVlDS
  extends DomainService
{
  public abstract List findDeptsVl();
  
  public abstract List findDownDeptsVl(String paramString1, String paramString2);
  
  public abstract List findAllDeptsVl(String paramString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.business.organizationmanage.service.IFbpDeptsVlDS
 * JD-Core Version:    0.7.0.1
 */