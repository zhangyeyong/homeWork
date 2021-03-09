package com.zte.eas.resconfig.access.expense.dao;

import com.zte.eas.resconfig.business.expense.model.FbpExpenseDimensionsV;
import com.zte.ssb.framework.base.DAO;
import com.zte.ssb.framework.base.util.PageInfo;
import java.util.List;

public abstract interface IFbpExpenseDimensionsVDAO
  extends DAO
{
  public abstract FbpExpenseDimensionsV getFbpExpenseDimensionsV(Long paramLong);
  
  public abstract List<FbpExpenseDimensionsV> getFbpExpenseDimensionsVs(int paramInt1, int paramInt2);
  
  public abstract List<FbpExpenseDimensionsV> getFbpExpenseDimensionsVs();
  
  public abstract void removeFbpExpenseDimensionsV(Long paramLong);
  
  public abstract void removeFbpExpenseDimensionsV(FbpExpenseDimensionsV paramFbpExpenseDimensionsV);
  
  public abstract void insertFbpExpenseDimensionsV(FbpExpenseDimensionsV paramFbpExpenseDimensionsV);
  
  public abstract void updateFbpExpenseDimensionsV(FbpExpenseDimensionsV paramFbpExpenseDimensionsV);
  
  public abstract void insertFbpExpenseDimensionsVs(List<FbpExpenseDimensionsV> paramList);
  
  public abstract void removeFbpExpenseDimensionsVs(List<FbpExpenseDimensionsV> paramList);
  
  public abstract void updateFbpExpenseDimensionsVs(List<FbpExpenseDimensionsV> paramList);
  
  public abstract PageInfo findFbpExpenseDimensionsVByCon(FbpExpenseDimensionsV paramFbpExpenseDimensionsV, int paramInt1, int paramInt2);
  
  public abstract PageInfo findFbpExpenseRelationVByExpenseId(Long paramLong, int paramInt1, int paramInt2);
  
  public abstract List findFbpExpenseDimRelationByAccount(Long paramLong);
  
  public abstract List findRelationSubject(FbpExpenseDimensionsV paramFbpExpenseDimensionsV);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.resconfig.access.expense.dao.IFbpExpenseDimensionsVDAO
 * JD-Core Version:    0.7.0.1
 */