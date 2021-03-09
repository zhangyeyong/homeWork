package com.zte.eas.organization.access.checkunits.dao;

import com.zte.eas.organization.business.checkunits.model.FbpCheckUnitContentsV;
import com.zte.ssb.framework.base.DAO;
import com.zte.ssb.framework.base.util.PageInfo;

public abstract interface IFbpCheckUnitContentsVDAO
  extends DAO
{
  public abstract PageInfo findCheckUnitContentsVByQry(FbpCheckUnitContentsV paramFbpCheckUnitContentsV, int paramInt1, int paramInt2);
  
  public abstract FbpCheckUnitContentsV findCheckUnitContentsVById(long paramLong);
  
  public abstract PageInfo findCheckUnitContentsVByCodeOrName(FbpCheckUnitContentsV paramFbpCheckUnitContentsV);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.access.checkunits.dao.IFbpCheckUnitContentsVDAO
 * JD-Core Version:    0.7.0.1
 */