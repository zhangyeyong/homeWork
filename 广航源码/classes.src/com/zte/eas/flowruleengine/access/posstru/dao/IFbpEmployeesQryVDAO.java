package com.zte.eas.flowruleengine.access.posstru.dao;

import com.zte.eas.flowruleengine.business.posstru.model.FbpEmployeesQryV;
import com.zte.ssb.framework.base.DAO;
import java.util.List;

public abstract interface IFbpEmployeesQryVDAO
  extends DAO
{
  public abstract List getFbpEmployeesQryVs(FbpEmployeesQryV paramFbpEmployeesQryV);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.flowruleengine.access.posstru.dao.IFbpEmployeesQryVDAO
 * JD-Core Version:    0.7.0.1
 */