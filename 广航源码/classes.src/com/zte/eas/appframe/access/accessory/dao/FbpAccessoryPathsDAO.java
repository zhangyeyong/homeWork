package com.zte.eas.appframe.access.accessory.dao;

import com.zte.eas.appframe.business.accessory.model.FbpAccessoryPaths;
import com.zte.ssb.framework.base.BaseDAO;
import java.math.BigInteger;
import java.util.List;

public class FbpAccessoryPathsDAO
  extends BaseDAO
  implements IFbpAccessoryPathsDAO
{
  public FbpAccessoryPaths getFbpAccessoryPaths(BigInteger paramBigInteger)
  {
    return (FbpAccessoryPaths)super.getObject(FbpAccessoryPaths.class, paramBigInteger);
  }
  
  public List getFbpAccessoryPathss()
  {
    return super.getObjects(FbpAccessoryPaths.class);
  }
  
  public List<FbpAccessoryPaths> getFbpAccessoryPathss(int paramInt1, int paramInt2)
  {
    return super.getObjects(FbpAccessoryPaths.class, paramInt1, paramInt2);
  }
  
  public void removeFbpAccessoryPaths(FbpAccessoryPaths paramFbpAccessoryPaths)
  {
    super.removeObject(paramFbpAccessoryPaths);
  }
  
  public void insertFbpAccessoryPaths(FbpAccessoryPaths paramFbpAccessoryPaths)
  {
    super.insertObject(paramFbpAccessoryPaths);
  }
  
  public void updateFbpAccessoryPaths(FbpAccessoryPaths paramFbpAccessoryPaths)
  {
    super.updateObject(paramFbpAccessoryPaths);
  }
  
  public void insertFbpAccessoryPathss(List<FbpAccessoryPaths> paramList)
  {
    super.insertObjects(paramList);
  }
  
  public void removeFbpAccessoryPathss(List<FbpAccessoryPaths> paramList)
  {
    super.removeObjects(paramList);
  }
  
  public void updateFbpAccessoryPathss(List<FbpAccessoryPaths> paramList)
  {
    super.updateObjects(paramList);
  }
  
  public void removeFbpAccessoryPaths(BigInteger paramBigInteger)
  {
    super.removeObject(FbpAccessoryPaths.class, paramBigInteger);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.access.accessory.dao.FbpAccessoryPathsDAO
 * JD-Core Version:    0.7.0.1
 */