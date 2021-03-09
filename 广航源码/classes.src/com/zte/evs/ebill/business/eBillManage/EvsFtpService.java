package com.zte.evs.ebill.business.eBillManage;

import com.zte.evs.ebill.access.eBillManage.IEvsFtpDAO;
import com.zte.evs.ebill.model.eBillManage.EvsFtp;

public class EvsFtpService
  implements IEvsFtpService
{
  private IEvsFtpDAO evsFtpDAO;
  
  public EvsFtp getFtpUser()
  {
    return this.evsFtpDAO.getFtpUser();
  }
  
  public IEvsFtpDAO getEvsFtpDAO()
  {
    return this.evsFtpDAO;
  }
  
  public void setEvsFtpDAO(IEvsFtpDAO paramIEvsFtpDAO)
  {
    this.evsFtpDAO = paramIEvsFtpDAO;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.eBillManage.EvsFtpService
 * JD-Core Version:    0.7.0.1
 */