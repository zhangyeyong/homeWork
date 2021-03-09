package com.zte.eas.resconfig.access.expense.dao;

import com.zte.eas.resconfig.business.expense.model.FbpExpenseDimensions;
import com.zte.ssb.framework.base.DAO;
import java.util.List;

public abstract interface IFbpExpenseDimensionsDAO
  extends DAO
{
  public abstract FbpExpenseDimensions getFbpExpenseDimensions(Long paramLong);
  
  public abstract List<FbpExpenseDimensions> getFbpExpenseDimensionss(int paramInt1, int paramInt2);
  
  public abstract List<FbpExpenseDimensions> getFbpExpenseDimensionss();
  
  public abstract void removeFbpExpenseDimensions(Long paramLong);
  
  public abstract void removeFbpExpenseDimensions(FbpExpenseDimensions paramFbpExpenseDimensions);
  
  public abstract void insertFbpExpenseDimensions(FbpExpenseDimensions paramFbpExpenseDimensions);
  
  public abstract void updateFbpExpenseDimensions(FbpExpenseDimensions paramFbpExpenseDimensions);
  
  public abstract void insertFbpExpenseDimensionss(List<FbpExpenseDimensions> paramList);
  
  public abstract void removeFbpExpenseDimensionss(List<FbpExpenseDimensions> paramList);
  
  public abstract void updateFbpExpenseDimensionss(List<FbpExpenseDimensions> paramList);
  
  public abstract List<FbpExpenseDimensions> findFbpExpenseDimensions(FbpExpenseDimensions paramFbpExpenseDimensions);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.resconfig.access.expense.dao.IFbpExpenseDimensionsDAO
 * JD-Core Version:    0.7.0.1
 */