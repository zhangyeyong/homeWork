package com.zte.eas.organization.access.countcompanymanage;

import com.zte.eas.organization.business.countcompanymanage.model.FbpCompany;
import java.util.List;

public abstract interface IFbpCompanyDAO
{
  public abstract void insertFbpCompany(FbpCompany paramFbpCompany);
  
  public abstract <T> void insertFbpCompanys(List<FbpCompany> paramList);
  
  public abstract void updateFbpCompany(FbpCompany paramFbpCompany);
  
  public abstract <T> void updateFbpCompanys(List<FbpCompany> paramList);
  
  public abstract void lockCompanyById(Long paramLong);
  
  public abstract FbpCompany getFbpCompany(String paramString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.access.countcompanymanage.IFbpCompanyDAO
 * JD-Core Version:    0.7.0.1
 */