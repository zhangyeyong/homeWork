package com.zte.eas.organization.access.organizationmanage.dao;

import com.zte.eas.organization.business.organizationmanage.model.FbpDepts;
import com.zte.eas.organization.business.organizationmanage.model.FbpDeptsTl;
import com.zte.eas.organization.business.organizationmanage.model.FbpDeptsV;
import com.zte.ssb.framework.base.DAO;
import java.math.BigInteger;
import java.util.List;

public abstract interface IFbpDeptsDAO
  extends DAO
{
  public abstract List findOffspringDepts(BigInteger paramBigInteger, String paramString);
  
  public abstract FbpDepts getFbpDepts(BigInteger paramBigInteger);
  
  public abstract List<FbpDepts> getFbpDeptss(int paramInt1, int paramInt2);
  
  public abstract FbpDepts getFbpDeptsByCode(String paramString);
  
  public abstract List<FbpDepts> getFbpDeptss();
  
  public abstract void removeFbpDepts(BigInteger paramBigInteger);
  
  public abstract void removeFbpDepts(FbpDepts paramFbpDepts);
  
  public abstract void insertFbpDepts(FbpDepts paramFbpDepts);
  
  public abstract void updateFbpDepts(FbpDepts paramFbpDepts);
  
  public abstract void insertFbpDeptss(List<FbpDepts> paramList);
  
  public abstract void removeFbpDeptss(List<FbpDepts> paramList);
  
  public abstract void updateFbpDeptss(List<FbpDepts> paramList);
  
  public abstract FbpDeptsV findDeptByCompId(String paramString);
  
  public abstract void insertFbpDeptsTl(FbpDeptsTl paramFbpDeptsTl);
  
  public abstract void updateFbpDeptsTl(FbpDeptsTl paramFbpDeptsTl);
  
  public abstract FbpDeptsTl findFbpDeptsTls(BigInteger paramBigInteger, String paramString);
  
  public abstract List<FbpDepts> findOffspringDepts(BigInteger paramBigInteger);
  
  public abstract boolean findWayBill(String paramString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.access.organizationmanage.dao.IFbpDeptsDAO
 * JD-Core Version:    0.7.0.1
 */