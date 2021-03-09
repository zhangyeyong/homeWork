package com.zte.eas.appframe.access.accessory.dao;

import com.zte.eas.appframe.business.accessory.model.AppFrameCon;
import com.zte.eas.appframe.business.accessory.model.FbpAccessories;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.orm.zorm.ZormTemplate;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class FbpAccessoriesDAO
  extends BaseDAO
  implements IFbpAccessoriesDAO
{
  public FbpAccessories getFbpAccessories(BigInteger paramBigInteger)
  {
    return (FbpAccessories)super.getObject(FbpAccessories.class, paramBigInteger);
  }
  
  public List<FbpAccessories> getFbpAccessoriess()
  {
    return super.getObjects(FbpAccessories.class);
  }
  
  public List<FbpAccessories> getFbpAccessoriess(int paramInt1, int paramInt2)
  {
    return super.getObjects(FbpAccessories.class, paramInt1, paramInt2);
  }
  
  public void removeFbpAccessories(FbpAccessories paramFbpAccessories)
  {
    super.removeObject(paramFbpAccessories);
  }
  
  public void insertFbpAccessories(FbpAccessories paramFbpAccessories)
  {
    super.insertObject(paramFbpAccessories);
  }
  
  public void updateFbpAccessories(FbpAccessories paramFbpAccessories)
  {
    super.updateObject(paramFbpAccessories);
  }
  
  public void insertFbpAccessoriess(List<FbpAccessories> paramList)
  {
    super.insertObjects(paramList);
  }
  
  public void removeFbpAccessoriess(List<FbpAccessories> paramList)
  {
    super.removeObjects(paramList);
  }
  
  public void updateFbpAccessoriess(List<FbpAccessories> paramList)
  {
    super.updateObjects(paramList);
  }
  
  public void removeFbpAccessories(BigInteger paramBigInteger)
  {
    super.removeObject(FbpAccessories.class, paramBigInteger);
  }
  
  public List<FbpAccessories> getFbpAccessoriesByBudgetHeaderId(AppFrameCon paramAppFrameCon)
  {
    String str = "from FbpAccessories acc where acc.enabledFlag='Y'";
    ArrayList localArrayList = new ArrayList();
    if (paramAppFrameCon.getRelationId() == null) {
      return new ArrayList();
    }
    str = str + " and  acc.relationId=?";
    localArrayList.add(paramAppFrameCon.getRelationId());
    if ((paramAppFrameCon.getDeptId() != null) && (!paramAppFrameCon.getDeptId().equals("")))
    {
      str = str + " and  acc.attribute10=?";
      localArrayList.add(paramAppFrameCon.getDeptId());
    }
    if ((paramAppFrameCon.getAccessoryTypes() != null) && (!paramAppFrameCon.getAccessoryTypes().equals("")))
    {
      str = str + " and acc.attribute8=?";
      localArrayList.add(paramAppFrameCon.getAccessoryTypes());
    }
    str = str + " order by acc.lastUpdateDate desc";
    List localList = getZormTemplate().find(str, localArrayList.toArray());
    if (localList == null) {
      return new ArrayList();
    }
    return localList;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.access.accessory.dao.FbpAccessoriesDAO
 * JD-Core Version:    0.7.0.1
 */