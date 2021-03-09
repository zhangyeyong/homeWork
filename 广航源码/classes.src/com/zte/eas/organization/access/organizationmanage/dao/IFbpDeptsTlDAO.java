package com.zte.eas.organization.access.organizationmanage.dao;

import com.zte.eas.organization.business.organizationmanage.model.FbpDeptsTl;
import com.zte.eas.organization.business.organizationmanage.model.FbpDeptsTlPk;
import com.zte.ssb.framework.base.DAO;
import java.util.List;

public abstract interface IFbpDeptsTlDAO
  extends DAO
{
  public abstract FbpDeptsTl getFbpDeptsTl(FbpDeptsTlPk paramFbpDeptsTlPk);
  
  public abstract List<FbpDeptsTl> getFbpDeptsTls(int paramInt1, int paramInt2);
  
  public abstract List<FbpDeptsTl> getFbpDeptsTls();
  
  public abstract void removeFbpDeptsTl(FbpDeptsTlPk paramFbpDeptsTlPk);
  
  public abstract void removeFbpDeptsTl(FbpDeptsTl paramFbpDeptsTl);
  
  public abstract void insertFbpDeptsTl(FbpDeptsTl paramFbpDeptsTl);
  
  public abstract void updateFbpDeptsTl(FbpDeptsTl paramFbpDeptsTl);
  
  public abstract void insertFbpDeptsTls(List<FbpDeptsTl> paramList);
  
  public abstract void removeFbpDeptsTls(List<FbpDeptsTl> paramList);
  
  public abstract void updateFbpDeptsTls(List<FbpDeptsTl> paramList);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.access.organizationmanage.dao.IFbpDeptsTlDAO
 * JD-Core Version:    0.7.0.1
 */