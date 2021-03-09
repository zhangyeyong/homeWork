package com.zte.eas.appframe.access.sysparm.dao;

import com.zte.eas.appframe.business.sysparm.model.SieSysParm;
import com.zte.eas.appframe.business.sysparm.model.SysParmTransition;
import com.zte.ssb.framework.base.DAO;
import java.util.List;

public abstract interface ISieSysParmDAO
  extends DAO
{
  public abstract String getSysParmByParmCode(String paramString);
  
  public abstract List findSysParms(SieSysParm paramSieSysParm);
  
  public abstract void saveSysParms(SysParmTransition paramSysParmTransition);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.access.sysparm.dao.ISieSysParmDAO
 * JD-Core Version:    0.7.0.1
 */