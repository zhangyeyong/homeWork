package com.zte.web.service.proxy;

import com.zte.web.service.client.getUrlServiceSrv.RequestModel;
import com.zte.web.service.client.getUrlServiceSrv.ResponseModel;

public abstract interface GetUrlServiceClient
{
  public abstract ResponseModel getUrl(RequestModel paramRequestModel)
    throws Throwable;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.proxy.GetUrlServiceClient
 * JD-Core Version:    0.7.0.1
 */