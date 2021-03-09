package com.zte.eas.organization.access.employeemanage.dao;

import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesTl;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesTlPk;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import java.util.List;

public class FbpEmployeesTlDAO
  extends BaseDAO
  implements IFbpEmployeesTlDAO
{
  public FbpEmployeesTl getFbpEmployeesTl(FbpEmployeesTlPk paramFbpEmployeesTlPk)
  {
    return (FbpEmployeesTl)super.getObject(FbpEmployeesTl.class, paramFbpEmployeesTlPk);
  }
  
  public List getFbpEmployeesTls()
  {
    return super.getObjects(FbpEmployeesTl.class);
  }
  
  public List<FbpEmployeesTl> getFbpEmployeesTls(int paramInt1, int paramInt2)
  {
    return super.getObjects(FbpEmployeesTl.class, paramInt1, paramInt2);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpEmployeesTl(FbpEmployeesTl paramFbpEmployeesTl)
  {
    super.removeObject(paramFbpEmployeesTl);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertFbpEmployeesTl(FbpEmployeesTl paramFbpEmployeesTl)
  {
    super.insertObject(paramFbpEmployeesTl);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateFbpEmployeesTl(FbpEmployeesTl paramFbpEmployeesTl)
  {
    super.updateObject(paramFbpEmployeesTl);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertFbpEmployeesTls(List<FbpEmployeesTl> paramList)
  {
    super.insertObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpEmployeesTls(List<FbpEmployeesTl> paramList)
  {
    super.removeObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateFbpEmployeesTls(List<FbpEmployeesTl> paramList)
  {
    super.updateObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpEmployeesTl(FbpEmployeesTlPk paramFbpEmployeesTlPk)
  {
    super.removeObject(FbpEmployeesTl.class, paramFbpEmployeesTlPk);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.access.employeemanage.dao.FbpEmployeesTlDAO
 * JD-Core Version:    0.7.0.1
 */