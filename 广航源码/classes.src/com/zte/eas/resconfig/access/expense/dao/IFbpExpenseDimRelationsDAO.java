package com.zte.eas.resconfig.access.expense.dao;

import com.zte.eas.resconfig.business.expense.model.FbpExpenseDimRelations;
import com.zte.ssb.framework.base.DAO;
import java.util.List;

public abstract interface IFbpExpenseDimRelationsDAO
  extends DAO
{
  public abstract FbpExpenseDimRelations getFbpExpenseDimRelations(Long paramLong);
  
  public abstract List<FbpExpenseDimRelations> getFbpExpenseDimRelationss(int paramInt1, int paramInt2);
  
  public abstract List<FbpExpenseDimRelations> getFbpExpenseDimRelationss();
  
  public abstract void removeFbpExpenseDimRelations(Long paramLong);
  
  public abstract void removeFbpExpenseDimRelations(FbpExpenseDimRelations paramFbpExpenseDimRelations);
  
  public abstract void insertFbpExpenseDimRelations(FbpExpenseDimRelations paramFbpExpenseDimRelations);
  
  public abstract void updateFbpExpenseDimRelations(FbpExpenseDimRelations paramFbpExpenseDimRelations);
  
  public abstract void insertFbpExpenseDimRelationss(List<FbpExpenseDimRelations> paramList);
  
  public abstract void removeFbpExpenseDimRelationss(List<FbpExpenseDimRelations> paramList);
  
  public abstract void updateFbpExpenseDimRelationss(List<FbpExpenseDimRelations> paramList);
  
  public abstract List<FbpExpenseDimRelations> findByExpenseId(Long paramLong);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.resconfig.access.expense.dao.IFbpExpenseDimRelationsDAO
 * JD-Core Version:    0.7.0.1
 */