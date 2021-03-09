package com.zte.eimage.access.baseconfig.dao;

import com.zte.eimage.business.baseconfig.model.FbpBorrowFindV;
import com.zte.eimage.business.baseconfig.model.FbpBorrowFindVL;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import java.util.List;

public class FbpBorrowFindVDAO
  extends BaseDAO
  implements IFbpBorrowFindVDAO
{
  public FbpBorrowFindV getFbpBorrowFindV(String paramString)
  {
    return (FbpBorrowFindV)super.getObject(FbpBorrowFindV.class, Long.valueOf(Long.parseLong(paramString)));
  }
  
  public FbpBorrowFindVL getFbpBorrowFindVL(String paramString)
  {
    return (FbpBorrowFindVL)super.getObject(FbpBorrowFindVL.class, Long.valueOf(Long.parseLong(paramString)));
  }
  
  public List getFbpBorrowFindVs()
  {
    return super.getObjects(FbpBorrowFindV.class);
  }
  
  public List<FbpBorrowFindV> getFbpBorrowFindVs(int paramInt1, int paramInt2)
  {
    return super.getObjects(FbpBorrowFindV.class, paramInt1, paramInt2);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpBorrowFindV(FbpBorrowFindV paramFbpBorrowFindV)
  {
    super.removeObject(paramFbpBorrowFindV);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertFbpBorrowFindV(FbpBorrowFindV paramFbpBorrowFindV)
  {
    super.insertObject(paramFbpBorrowFindV);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateFbpBorrowFindV(FbpBorrowFindV paramFbpBorrowFindV)
  {
    super.updateObject(paramFbpBorrowFindV);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertFbpBorrowFindVs(List<FbpBorrowFindV> paramList)
  {
    super.insertObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpBorrowFindVs(List<FbpBorrowFindV> paramList)
  {
    super.removeObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateFbpBorrowFindVs(List<FbpBorrowFindV> paramList)
  {
    super.updateObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpBorrowFindV(Long paramLong)
  {
    super.removeObject(FbpBorrowFindV.class, paramLong);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.access.baseconfig.dao.FbpBorrowFindVDAO
 * JD-Core Version:    0.7.0.1
 */