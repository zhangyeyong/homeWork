package com.zte.eas.organization.access.checkunits.dao;

import com.zte.eas.organization.business.checkunits.model.FbpCheckUnitContentsAllV;
import com.zte.ssb.framework.base.DAO;
import java.util.List;

public abstract interface IFbpCheckUnitContentsAllVDAO
  extends DAO
{
  public abstract List<FbpCheckUnitContentsAllV> findFbpCheckUnitContentsAllV();
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.access.checkunits.dao.IFbpCheckUnitContentsAllVDAO
 * JD-Core Version:    0.7.0.1
 */