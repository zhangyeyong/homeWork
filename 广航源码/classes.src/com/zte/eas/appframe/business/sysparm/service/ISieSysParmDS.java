package com.zte.eas.appframe.business.sysparm.service;

import com.zte.eas.appframe.business.sysparm.model.SieSysParm;
import com.zte.eas.appframe.business.sysparm.model.SysParmTransition;
import com.zte.ssb.framework.base.DomainService;
import java.util.Map;

public abstract interface ISieSysParmDS
  extends DomainService
{
  public abstract Map getSysParmByParmCode(String paramString);
  
  public abstract SysParmTransition findSysParms(SieSysParm paramSieSysParm);
  
  public abstract String saveSysParms(SysParmTransition paramSysParmTransition);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.business.sysparm.service.ISieSysParmDS
 * JD-Core Version:    0.7.0.1
 */