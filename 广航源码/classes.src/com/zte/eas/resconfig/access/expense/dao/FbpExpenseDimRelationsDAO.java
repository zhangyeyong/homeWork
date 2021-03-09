package com.zte.eas.resconfig.access.expense.dao;

import com.zte.eas.resconfig.business.expense.model.FbpExpenseDimRelations;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.orm.zorm.ZormTemplate;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import java.util.List;

public class FbpExpenseDimRelationsDAO
  extends BaseDAO
  implements IFbpExpenseDimRelationsDAO
{
  public FbpExpenseDimRelations getFbpExpenseDimRelations(Long paramLong)
  {
    return (FbpExpenseDimRelations)super.getObject(FbpExpenseDimRelations.class, paramLong);
  }
  
  public List getFbpExpenseDimRelationss()
  {
    return super.getObjects(FbpExpenseDimRelations.class);
  }
  
  public List<FbpExpenseDimRelations> getFbpExpenseDimRelationss(int paramInt1, int paramInt2)
  {
    return super.getObjects(FbpExpenseDimRelations.class, paramInt1, paramInt2);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpExpenseDimRelations(FbpExpenseDimRelations paramFbpExpenseDimRelations)
  {
    super.removeObject(paramFbpExpenseDimRelations);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertFbpExpenseDimRelations(FbpExpenseDimRelations paramFbpExpenseDimRelations)
  {
    super.insertObject(paramFbpExpenseDimRelations);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateFbpExpenseDimRelations(FbpExpenseDimRelations paramFbpExpenseDimRelations)
  {
    super.updateObject(paramFbpExpenseDimRelations);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertFbpExpenseDimRelationss(List<FbpExpenseDimRelations> paramList)
  {
    super.insertObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpExpenseDimRelationss(List<FbpExpenseDimRelations> paramList)
  {
    super.removeObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateFbpExpenseDimRelationss(List<FbpExpenseDimRelations> paramList)
  {
    super.updateObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpExpenseDimRelations(Long paramLong)
  {
    super.removeObject(FbpExpenseDimRelations.class, paramLong);
  }
  
  public List<FbpExpenseDimRelations> findByExpenseId(Long paramLong)
  {
    String str = "FROM FbpExpenseDimRelations f where 1=1 and f.expenseId =" + paramLong;
    return getZormTemplate().find(str);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.resconfig.access.expense.dao.FbpExpenseDimRelationsDAO
 * JD-Core Version:    0.7.0.1
 */