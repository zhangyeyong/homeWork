package com.zte.eas.organization.business.checkunits.service;

import com.zte.eas.organization.business.checkunits.model.FbpCheckUnitContentsAllV;
import java.util.HashMap;
import java.util.List;

public abstract interface ICheckUnitsDS
{
  public abstract HashMap findFbpCheckUnitContentsAllV(String paramString);
  
  public abstract List<FbpCheckUnitContentsAllV> findFbpCheckUnitAllVList(String paramString);
  
  public abstract String findFbpCheckUnitByName();
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.business.checkunits.service.ICheckUnitsDS
 * JD-Core Version:    0.7.0.1
 */