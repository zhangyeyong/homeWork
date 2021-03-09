package com.zte.web.service.proxy.syn;

import com.zte.eas.appframe.business.synrequest.model.FbpSynchRequestsV;

public abstract interface DataSynDS
{
  public abstract boolean syn(FbpSynchRequestsV paramFbpSynchRequestsV)
    throws Exception;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.proxy.syn.DataSynDS
 * JD-Core Version:    0.7.0.1
 */