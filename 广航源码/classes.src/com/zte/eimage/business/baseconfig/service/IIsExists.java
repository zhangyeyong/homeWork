package com.zte.eimage.business.baseconfig.service;

import com.zte.eimage.business.baseconfig.model.IsExistsResponse;

public abstract interface IIsExists
{
  public abstract IsExistsResponse[] IsExist(String paramString1, String paramString2, String paramString3);
  
  public abstract String getImageSeqNo(String paramString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.service.IIsExists
 * JD-Core Version:    0.7.0.1
 */