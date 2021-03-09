package com.zte.eas.resconfig.access.expense.dao;

import com.zte.eas.resconfig.business.expense.model.FbpExpenseDimensions;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.orm.zorm.ZormTemplate;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

public class FbpExpenseDimensionsDAO
  extends BaseDAO
  implements IFbpExpenseDimensionsDAO
{
  public FbpExpenseDimensions getFbpExpenseDimensions(Long paramLong)
  {
    return (FbpExpenseDimensions)super.getObject(FbpExpenseDimensions.class, paramLong);
  }
  
  public List getFbpExpenseDimensionss()
  {
    return super.getObjects(FbpExpenseDimensions.class);
  }
  
  public List<FbpExpenseDimensions> getFbpExpenseDimensionss(int paramInt1, int paramInt2)
  {
    return super.getObjects(FbpExpenseDimensions.class, paramInt1, paramInt2);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpExpenseDimensions(FbpExpenseDimensions paramFbpExpenseDimensions)
  {
    super.removeObject(paramFbpExpenseDimensions);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertFbpExpenseDimensions(FbpExpenseDimensions paramFbpExpenseDimensions)
  {
    super.insertObject(paramFbpExpenseDimensions);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateFbpExpenseDimensions(FbpExpenseDimensions paramFbpExpenseDimensions)
  {
    super.updateObject(paramFbpExpenseDimensions);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertFbpExpenseDimensionss(List<FbpExpenseDimensions> paramList)
  {
    super.insertObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpExpenseDimensionss(List<FbpExpenseDimensions> paramList)
  {
    super.removeObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateFbpExpenseDimensionss(List<FbpExpenseDimensions> paramList)
  {
    super.updateObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpExpenseDimensions(Long paramLong)
  {
    super.removeObject(FbpExpenseDimensions.class, paramLong);
  }
  
  public List<FbpExpenseDimensions> findFbpExpenseDimensions(FbpExpenseDimensions paramFbpExpenseDimensions)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramFbpExpenseDimensions == null) {
      return new ArrayList();
    }
    String str = "FROM FbpExpenseDimensions s WHERE 1=1";
    if ((paramFbpExpenseDimensions.getExpenseCode() != null) && (!"".equals(paramFbpExpenseDimensions.getExpenseCode())))
    {
      str = str + " AND s.expenseCode = ? ";
      localArrayList.add(paramFbpExpenseDimensions.getExpenseCode().trim().replaceAll("'", "''"));
    }
    if ((paramFbpExpenseDimensions.getExpenseName() != null) && (!"".equals(paramFbpExpenseDimensions.getExpenseName())))
    {
      str = str + " AND s.expenseName = ? ";
      localArrayList.add(paramFbpExpenseDimensions.getExpenseName().trim().replaceAll("'", "''"));
    }
    if ((paramFbpExpenseDimensions.getExpenseId() != null) && (!"".equals(paramFbpExpenseDimensions.getExpenseId())))
    {
      str = str + " AND s.expenseId != ? ";
      localArrayList.add(paramFbpExpenseDimensions.getExpenseId());
    }
    List localList = getZormTemplate().find(str.toString(), localArrayList.toArray());
    return localList;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.resconfig.access.expense.dao.FbpExpenseDimensionsDAO
 * JD-Core Version:    0.7.0.1
 */