package com.zte.eas.organization.business.countcompanymanage.service;

import com.zte.eas.organization.access.countcompanymanage.FbpCompanyVDAO;
import com.zte.eas.organization.business.countcompanymanage.model.FbpCompanyV;
import java.util.Map;

public abstract interface IFbpCompanyVDS
{
  public abstract void setFbpCompanyVDAO(FbpCompanyVDAO paramFbpCompanyVDAO);
  
  public abstract Map findCompanyByQry(FbpCompanyV paramFbpCompanyV, String paramString1, String paramString2);
  
  public abstract FbpCompanyV findByCompId(String paramString);
  
  public abstract String saveFbpCompamyV(FbpCompanyV paramFbpCompanyV);
  
  public abstract String saveFbpCompamyVForCheck(FbpCompanyV paramFbpCompanyV);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.business.countcompanymanage.service.IFbpCompanyVDS
 * JD-Core Version:    0.7.0.1
 */