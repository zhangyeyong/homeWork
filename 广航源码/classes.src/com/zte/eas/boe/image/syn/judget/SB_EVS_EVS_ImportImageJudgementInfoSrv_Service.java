package com.zte.eas.boe.image.syn.judget;

import java.net.URL;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public abstract interface SB_EVS_EVS_ImportImageJudgementInfoSrv_Service
  extends Service
{
  public abstract String getSB_EVS_EVS_ImportImageJudgementInfoSrvPortAddress();
  
  public abstract SB_EVS_EVS_ImportImageJudgementInfoSrv_PortType getSB_EVS_EVS_ImportImageJudgementInfoSrvPort()
    throws ServiceException;
  
  public abstract SB_EVS_EVS_ImportImageJudgementInfoSrv_PortType getSB_EVS_EVS_ImportImageJudgementInfoSrvPort(URL paramURL)
    throws ServiceException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.boe.image.syn.judget.SB_EVS_EVS_ImportImageJudgementInfoSrv_Service
 * JD-Core Version:    0.7.0.1
 */