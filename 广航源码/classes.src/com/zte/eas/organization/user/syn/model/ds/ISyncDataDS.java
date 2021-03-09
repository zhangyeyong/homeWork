package com.zte.eas.organization.user.syn.model.ds;

import com.zte.esb.bean.SendDegreeRequest;
import com.zte.esb.bean.SendDegreeResponse;
import com.zte.esb.bean.SendPositionRequest;
import com.zte.esb.bean.SendPositionResponse;

public abstract interface ISyncDataDS
{
  public abstract SendPositionResponse syncPositions(SendPositionRequest paramSendPositionRequest);
  
  public abstract SendDegreeResponse syncDegreeInfo(SendDegreeRequest paramSendDegreeRequest);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.user.syn.model.ds.ISyncDataDS
 * JD-Core Version:    0.7.0.1
 */