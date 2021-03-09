package com.zte.eas.resconfig.access.expense.dao;

import com.zte.eas.appframe.business.util.SqlManageUtils;
import com.zte.eas.resconfig.business.expense.model.FbpExpenseDimensionsV;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.orm.zorm.ZormTemplate;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

public class FbpExpenseDimensionsVDAO
  extends BaseDAO
  implements IFbpExpenseDimensionsVDAO
{
  public FbpExpenseDimensionsV getFbpExpenseDimensionsV(Long paramLong)
  {
    return (FbpExpenseDimensionsV)super.getObject(FbpExpenseDimensionsV.class, paramLong);
  }
  
  public List getFbpExpenseDimensionsVs()
  {
    return super.getObjects(FbpExpenseDimensionsV.class);
  }
  
  public List<FbpExpenseDimensionsV> getFbpExpenseDimensionsVs(int paramInt1, int paramInt2)
  {
    return super.getObjects(FbpExpenseDimensionsV.class, paramInt1, paramInt2);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpExpenseDimensionsV(FbpExpenseDimensionsV paramFbpExpenseDimensionsV)
  {
    super.removeObject(paramFbpExpenseDimensionsV);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertFbpExpenseDimensionsV(FbpExpenseDimensionsV paramFbpExpenseDimensionsV)
  {
    super.insertObject(paramFbpExpenseDimensionsV);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateFbpExpenseDimensionsV(FbpExpenseDimensionsV paramFbpExpenseDimensionsV)
  {
    super.updateObject(paramFbpExpenseDimensionsV);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertFbpExpenseDimensionsVs(List<FbpExpenseDimensionsV> paramList)
  {
    super.insertObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpExpenseDimensionsVs(List<FbpExpenseDimensionsV> paramList)
  {
    super.removeObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateFbpExpenseDimensionsVs(List<FbpExpenseDimensionsV> paramList)
  {
    super.updateObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpExpenseDimensionsV(Long paramLong)
  {
    super.removeObject(FbpExpenseDimensionsV.class, paramLong);
  }
  
  public PageInfo findFbpExpenseDimensionsVByCon(FbpExpenseDimensionsV paramFbpExpenseDimensionsV, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    StringBuffer localStringBuffer = new StringBuffer("FROM FbpExpenseDimensionsV fev WHERE 1=1 ");
    if ((paramFbpExpenseDimensionsV.getExpenseCode() != null) && (!"".equals(paramFbpExpenseDimensionsV.getExpenseCode())))
    {
      localStringBuffer.append(" and fev.expenseCode like ? ");
      localArrayList.add("%" + SqlManageUtils.cleanUpSQL(paramFbpExpenseDimensionsV.getExpenseCode()) + "%");
    }
    if ((paramFbpExpenseDimensionsV.getExpenseName() != null) && (!"".equals(paramFbpExpenseDimensionsV.getExpenseName())))
    {
      localStringBuffer.append(" and fev.expenseName like ?");
      localArrayList.add("%" + SqlManageUtils.cleanUpSQL(paramFbpExpenseDimensionsV.getExpenseName()) + "%");
    }
    localStringBuffer.append(" ORDER BY fev.lastUpdateDate DESC");
    paramInt1 = paramInt1 / paramInt2 + 1;
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1, paramInt2, localArrayList.toArray());
    super.clear();
    return localPageInfo;
  }
  
  public PageInfo findFbpExpenseRelationVByExpenseId(Long paramLong, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer(" select f FROM FbpExpenseRelationV f where 1=1 ");
    ArrayList localArrayList = new ArrayList();
    if ((null != paramLong) && (paramLong.longValue() > 0L))
    {
      localStringBuffer.append(" and f.expenseId = ? ");
      localArrayList.add(paramLong);
    }
    localStringBuffer.append(" ORDER BY f.expenseRelationId DESC ");
    paramInt1 = paramInt1 / paramInt2 + 1;
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1, paramInt2, localArrayList.toArray());
    return localPageInfo;
  }
  
  public List findFbpExpenseDimRelationByAccount(Long paramLong)
  {
    StringBuffer localStringBuffer = new StringBuffer("select f FROM FbpExpenseDimRelations f,FbpExpenseDimensions  fe");
    localStringBuffer.append(" where 1=1 and f.expenseId = fe.expenseId and fe.enabledFlag ='Y' ");
    localStringBuffer.append(" and f.accountId = " + paramLong);
    return getZormTemplate().find(localStringBuffer.toString());
  }
  
  public List findRelationSubject(FbpExpenseDimensionsV paramFbpExpenseDimensionsV)
  {
    StringBuffer localStringBuffer = new StringBuffer("select f FROM FbpExpenseDimRelations f,FbpExpenseDimensions fe");
    localStringBuffer.append(" where 1=1 and f.expenseId = fe.expenseId ");
    if ((paramFbpExpenseDimensionsV.getExpenseId() != null) && (paramFbpExpenseDimensionsV.getExpenseId().longValue() > 0L)) {
      localStringBuffer.append("and f.expenseId != " + paramFbpExpenseDimensionsV.getExpenseId());
    }
    localStringBuffer.append(" and fe.enabledFlag ='Y' and f.accountId in (" + paramFbpExpenseDimensionsV.getAccountId() + ")");
    return getZormTemplate().find(localStringBuffer.toString());
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.resconfig.access.expense.dao.FbpExpenseDimensionsVDAO
 * JD-Core Version:    0.7.0.1
 */