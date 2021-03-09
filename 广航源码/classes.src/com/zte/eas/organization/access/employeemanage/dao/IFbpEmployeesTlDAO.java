package com.zte.eas.organization.access.employeemanage.dao;

import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesTl;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesTlPk;
import com.zte.ssb.framework.base.DAO;
import java.util.List;

public abstract interface IFbpEmployeesTlDAO
  extends DAO
{
  public abstract FbpEmployeesTl getFbpEmployeesTl(FbpEmployeesTlPk paramFbpEmployeesTlPk);
  
  public abstract List<FbpEmployeesTl> getFbpEmployeesTls(int paramInt1, int paramInt2);
  
  public abstract List<FbpEmployeesTl> getFbpEmployeesTls();
  
  public abstract void removeFbpEmployeesTl(FbpEmployeesTlPk paramFbpEmployeesTlPk);
  
  public abstract void removeFbpEmployeesTl(FbpEmployeesTl paramFbpEmployeesTl);
  
  public abstract void insertFbpEmployeesTl(FbpEmployeesTl paramFbpEmployeesTl);
  
  public abstract void updateFbpEmployeesTl(FbpEmployeesTl paramFbpEmployeesTl);
  
  public abstract void insertFbpEmployeesTls(List<FbpEmployeesTl> paramList);
  
  public abstract void removeFbpEmployeesTls(List<FbpEmployeesTl> paramList);
  
  public abstract void updateFbpEmployeesTls(List<FbpEmployeesTl> paramList);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.access.employeemanage.dao.IFbpEmployeesTlDAO
 * JD-Core Version:    0.7.0.1
 */