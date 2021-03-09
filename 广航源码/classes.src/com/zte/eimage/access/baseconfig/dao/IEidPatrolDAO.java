package com.zte.eimage.access.baseconfig.dao;

import com.zte.eimage.business.baseconfig.model.EidPatrol;
import com.zte.ssb.framework.base.DAO;
import java.util.List;

public abstract interface IEidPatrolDAO
  extends DAO
{
  public abstract List<EidPatrol> findPatrolByImageInfoId(Integer paramInteger);
  
  public abstract String insertForUpdatePatrol(List<EidPatrol> paramList);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.access.baseconfig.dao.IEidPatrolDAO
 * JD-Core Version:    0.7.0.1
 */