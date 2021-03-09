package com.zte.evs.ebill.business.eBillManage;

import com.zte.evs.ebill.access.eBillManage.EFasciculeTreeVDAO;

public class EFasciculeTreeVService
  implements IEFasciculeTreeVService
{
  private EFasciculeTreeVDAO efasciculeQueryDAO;
  
  public EFasciculeTreeVDAO getEfasciculeQueryDAO()
  {
    return this.efasciculeQueryDAO;
  }
  
  public void setEfasciculeQueryDAO(EFasciculeTreeVDAO paramEFasciculeTreeVDAO)
  {
    this.efasciculeQueryDAO = paramEFasciculeTreeVDAO;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.eBillManage.EFasciculeTreeVService
 * JD-Core Version:    0.7.0.1
 */