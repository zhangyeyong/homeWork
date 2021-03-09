package com.zte.eas.appframe.access.accessory.dao;

import com.zte.eas.appframe.business.accessory.model.AppFrameCon;
import com.zte.eas.appframe.business.accessory.model.FbpAccessories;
import com.zte.ssb.framework.base.DAO;
import java.math.BigInteger;
import java.util.List;

public abstract interface IFbpAccessoriesDAO
  extends DAO
{
  public abstract FbpAccessories getFbpAccessories(BigInteger paramBigInteger);
  
  public abstract List<FbpAccessories> getFbpAccessoriess(int paramInt1, int paramInt2);
  
  public abstract List<FbpAccessories> getFbpAccessoriess();
  
  public abstract void removeFbpAccessories(BigInteger paramBigInteger);
  
  public abstract void removeFbpAccessories(FbpAccessories paramFbpAccessories);
  
  public abstract void insertFbpAccessories(FbpAccessories paramFbpAccessories);
  
  public abstract void updateFbpAccessories(FbpAccessories paramFbpAccessories);
  
  public abstract void insertFbpAccessoriess(List<FbpAccessories> paramList);
  
  public abstract void removeFbpAccessoriess(List<FbpAccessories> paramList);
  
  public abstract void updateFbpAccessoriess(List<FbpAccessories> paramList);
  
  public abstract List<FbpAccessories> getFbpAccessoriesByBudgetHeaderId(AppFrameCon paramAppFrameCon);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.access.accessory.dao.IFbpAccessoriesDAO
 * JD-Core Version:    0.7.0.1
 */