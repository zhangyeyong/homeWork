package com.zte.eas.organization.access.organizationmanage.dao;

import com.zte.eas.organization.business.organizationmanage.model.FbpDeptsTl;
import com.zte.eas.organization.business.organizationmanage.model.FbpDeptsTlPk;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import java.util.List;

public class FbpDeptsTlDAO
  extends BaseDAO
  implements IFbpDeptsTlDAO
{
  public FbpDeptsTl getFbpDeptsTl(FbpDeptsTlPk paramFbpDeptsTlPk)
  {
    return (FbpDeptsTl)super.getObject(FbpDeptsTl.class, paramFbpDeptsTlPk);
  }
  
  public List getFbpDeptsTls()
  {
    return super.getObjects(FbpDeptsTl.class);
  }
  
  public List<FbpDeptsTl> getFbpDeptsTls(int paramInt1, int paramInt2)
  {
    return super.getObjects(FbpDeptsTl.class, paramInt1, paramInt2);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpDeptsTl(FbpDeptsTl paramFbpDeptsTl)
  {
    super.removeObject(paramFbpDeptsTl);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertFbpDeptsTl(FbpDeptsTl paramFbpDeptsTl)
  {
    super.insertObject(paramFbpDeptsTl);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateFbpDeptsTl(FbpDeptsTl paramFbpDeptsTl)
  {
    super.updateObject(paramFbpDeptsTl);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertFbpDeptsTls(List<FbpDeptsTl> paramList)
  {
    super.insertObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpDeptsTls(List<FbpDeptsTl> paramList)
  {
    super.removeObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateFbpDeptsTls(List<FbpDeptsTl> paramList)
  {
    super.updateObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpDeptsTl(FbpDeptsTlPk paramFbpDeptsTlPk)
  {
    super.removeObject(FbpDeptsTl.class, paramFbpDeptsTlPk);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.access.organizationmanage.dao.FbpDeptsTlDAO
 * JD-Core Version:    0.7.0.1
 */