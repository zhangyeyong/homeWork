package com.zte.eas.organization.access.countcompanymanage;

import com.zte.eas.organization.business.countcompanymanage.model.FbpCompanyV;
import java.util.Map;

public abstract interface IFbpCompanyVDAO
{
  public abstract Map findCompanyByQry(FbpCompanyV paramFbpCompanyV, int paramInt1, int paramInt2);
  
  public abstract FbpCompanyV findByCompId(Long paramLong);
  
  public abstract FbpCompanyV findByCompCode(String paramString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.access.countcompanymanage.IFbpCompanyVDAO
 * JD-Core Version:    0.7.0.1
 */