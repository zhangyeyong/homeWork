package com.zte.eas.appframe.access.accessory.dao;

import com.zte.eas.appframe.business.accessory.model.FbpAccessoryPaths;
import com.zte.ssb.framework.base.DAO;
import java.math.BigInteger;
import java.util.List;

public abstract interface IFbpAccessoryPathsDAO
  extends DAO
{
  public abstract FbpAccessoryPaths getFbpAccessoryPaths(BigInteger paramBigInteger);
  
  public abstract List<FbpAccessoryPaths> getFbpAccessoryPathss(int paramInt1, int paramInt2);
  
  public abstract List<FbpAccessoryPaths> getFbpAccessoryPathss();
  
  public abstract void removeFbpAccessoryPaths(BigInteger paramBigInteger);
  
  public abstract void removeFbpAccessoryPaths(FbpAccessoryPaths paramFbpAccessoryPaths);
  
  public abstract void insertFbpAccessoryPaths(FbpAccessoryPaths paramFbpAccessoryPaths);
  
  public abstract void updateFbpAccessoryPaths(FbpAccessoryPaths paramFbpAccessoryPaths);
  
  public abstract void insertFbpAccessoryPathss(List<FbpAccessoryPaths> paramList);
  
  public abstract void removeFbpAccessoryPathss(List<FbpAccessoryPaths> paramList);
  
  public abstract void updateFbpAccessoryPathss(List<FbpAccessoryPaths> paramList);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.access.accessory.dao.IFbpAccessoryPathsDAO
 * JD-Core Version:    0.7.0.1
 */