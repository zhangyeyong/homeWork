package com.zte.eas.organization.access.checkunits.dao;

import com.zte.eas.organization.business.checkunits.model.FbpCheckUnitContents;
import com.zte.ssb.framework.base.DAO;
import java.util.List;

public abstract interface IFbpCheckUnitContentsDAO
  extends DAO
{
  public abstract FbpCheckUnitContents getFbpCheckUnitContents(Long paramLong);
  
  public abstract List<FbpCheckUnitContents> getFbpCheckUnitContentss(int paramInt1, int paramInt2);
  
  public abstract List<FbpCheckUnitContents> getFbpCheckUnitContentss();
  
  public abstract void insertFbpCheckUnitContents(FbpCheckUnitContents paramFbpCheckUnitContents);
  
  public abstract void updateFbpCheckUnitContents(FbpCheckUnitContents paramFbpCheckUnitContents);
  
  public abstract FbpCheckUnitContents findCheckUnitContentsVByCheckUnit(String paramString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.access.checkunits.dao.IFbpCheckUnitContentsDAO
 * JD-Core Version:    0.7.0.1
 */