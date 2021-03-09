package com.zte.eas.resconfig.access.operationtypes;

import com.zte.eas.resconfig.access.operationtypes.model.FbpOperationTypesTl;
import com.zte.ssb.framework.base.DAO;
import java.util.List;

public abstract interface IFbpOperationTypesTlDAO
  extends DAO
{
  public abstract void removeFbpOperationTypesTl(FbpOperationTypesTl paramFbpOperationTypesTl);
  
  public abstract void insertFbpOperationTypesTl(FbpOperationTypesTl paramFbpOperationTypesTl);
  
  public abstract void updateFbpOperationTypesTl(FbpOperationTypesTl paramFbpOperationTypesTl);
  
  public abstract void updateFbpOperationTypesTls(List<FbpOperationTypesTl> paramList);
  
  public abstract List<FbpOperationTypesTl> findFbpOperationTypesTls(Long paramLong);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.resconfig.access.operationtypes.IFbpOperationTypesTlDAO
 * JD-Core Version:    0.7.0.1
 */