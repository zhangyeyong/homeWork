package com.zte.eas.resconfig.business.expense.service;

import com.zte.eas.resconfig.business.expense.model.FbpExpenseDimensionsV;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.DomainService;
import java.util.List;
import java.util.Map;

public abstract interface IFbpExpenseDimensionsVDS
  extends DomainService
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
  
  public abstract TableDataInfo findFbpExpenseDimensionsVByCon(FbpExpenseDimensionsV paramFbpExpenseDimensionsV, int paramInt1, int paramInt2);
  
  public abstract Map<String, Object> saveExpenseDimension(FbpExpenseDimensionsV paramFbpExpenseDimensionsV);
  
  public abstract TableDataInfo findFbpExpenseRelationVByExpenseId(String paramString, int paramInt1, int paramInt2);
  
  public abstract String addByExpenseIdAndRelatedId(String paramString1, String paramString2);
  
  public abstract String deleteRults(String paramString);
  
  public abstract String checkSubject(String paramString);
  
  public abstract FbpExpenseDimensionsV getFbpExpenseDimensionsVByExpenseId(String paramString);
  
  public abstract String checkSubjectRelations(FbpExpenseDimensionsV paramFbpExpenseDimensionsV);
  
  public abstract Map<String, Object> updateExpenseDimension(FbpExpenseDimensionsV paramFbpExpenseDimensionsV);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.resconfig.business.expense.service.IFbpExpenseDimensionsVDS
 * JD-Core Version:    0.7.0.1
 */