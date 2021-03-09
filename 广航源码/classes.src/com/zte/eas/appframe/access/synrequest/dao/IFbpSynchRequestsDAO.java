package com.zte.eas.appframe.access.synrequest.dao;

import com.zte.eas.appframe.business.synrequest.model.FbpSynchRequests;
import com.zte.ssb.framework.base.DAO;
import java.util.Date;

public abstract interface IFbpSynchRequestsDAO
  extends DAO
{
  public abstract void insert(FbpSynchRequests paramFbpSynchRequests);
  
  public abstract void update(FbpSynchRequests paramFbpSynchRequests);
  
  public abstract void syncAttachment();
  
  public abstract boolean syncVoucher(Date paramDate);
  
  public abstract boolean syncImage();
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.access.synrequest.dao.IFbpSynchRequestsDAO
 * JD-Core Version:    0.7.0.1
 */