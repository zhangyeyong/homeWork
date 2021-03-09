package com.zte.eimage.business.baseconfig.service;

import com.zte.eimage.business.baseconfig.model.Site;
import com.zte.eimage.business.baseconfig.model.SiteV;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import java.util.HashMap;

public abstract interface ISiteService
{
  public abstract void insertSite(Site paramSite);
  
  public abstract Site getSiteById(Integer paramInteger);
  
  public abstract SiteV getSiteVById(Integer paramInteger);
  
  public abstract HashMap getAllSite(String paramString);
  
  public abstract HashMap getAllSite(String paramString1, String paramString2);
  
  public abstract void updateSite(Site paramSite);
  
  public abstract TableDataInfo findSite(Site paramSite, String paramString1, String paramString2);
  
  public abstract Integer isExistsSiteName(String paramString);
  
  public abstract Integer isNOtOnetoOne(String paramString1, String paramString2);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.service.ISiteService
 * JD-Core Version:    0.7.0.1
 */