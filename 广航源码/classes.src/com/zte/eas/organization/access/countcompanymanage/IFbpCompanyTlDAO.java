package com.zte.eas.organization.access.countcompanymanage;

import com.zte.eas.organization.business.countcompanymanage.model.FbpCompanyTl;
import java.util.List;

public abstract interface IFbpCompanyTlDAO
{
  public abstract void insertFbpCompanyTl(FbpCompanyTl paramFbpCompanyTl);
  
  public abstract <T> void insertFbpCompanyTls(List<FbpCompanyTl> paramList);
  
  public abstract void updateFbpCompanyTl(FbpCompanyTl paramFbpCompanyTl);
  
  public abstract <T> void updateFbpCompanyTls(List<FbpCompanyTl> paramList);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.access.countcompanymanage.IFbpCompanyTlDAO
 * JD-Core Version:    0.7.0.1
 */