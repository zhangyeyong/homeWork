package com.zte.eas.appframe.access.synrequest.dao;

import com.zte.eas.appframe.business.synrequest.model.FbpSynchRequestsV;
import com.zte.ssb.framework.base.DAO;
import com.zte.ssb.framework.base.util.PageInfo;
import java.util.List;

public abstract interface IFbpSynchRequestsVDAO
  extends DAO
{
  public abstract FbpSynchRequestsV findSynchRequestsVById(String paramString);
  
  public abstract PageInfo findSynchRequestsVByCon(FbpSynchRequestsV paramFbpSynchRequestsV, int paramInt1, int paramInt2);
  
  public abstract FbpSynchRequestsV findSynchRequestsVByReqNum(String paramString);
  
  public abstract List<FbpSynchRequestsV> findAllFbpSynchRequestsV();
  
  public abstract List<FbpSynchRequestsV> findFbpSynchRequestsByAP();
  
  public abstract List<FbpSynchRequestsV> findFbpSynchRequestsByAR();
  
  public abstract List<FbpSynchRequestsV> findFbpSynchRequestsByGL();
  
  public abstract List<FbpSynchRequestsV> findFbpSynchRequestsByRC();
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.access.synrequest.dao.IFbpSynchRequestsVDAO
 * JD-Core Version:    0.7.0.1
 */