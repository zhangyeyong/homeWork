package com.zte.eimage.business.baseconfig.service;

import com.zte.eimage.business.baseconfig.model.EidAppraiseHistoriesV;
import java.util.List;

public abstract interface IEvsAppraiseHistorisesDS
{
  public abstract EidAppraiseHistoriesV[] findHistoryByImageInfoId(String paramString);
  
  public abstract List<String> getDetailBoeNumber(String paramString);
  
  public abstract String remarkVideo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
  
  public abstract String remarkVideoAppNeed(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.service.IEvsAppraiseHistorisesDS
 * JD-Core Version:    0.7.0.1
 */