package com.zte.web.service.proxy.syn;

import com.zte.eas.appframe.business.synrequest.model.FbpSynchRequestsV;
import com.zte.evs.ebill.access.eBillManage.IEvsVoucherDAO;

public class VoucherMatchDS
  implements DataSynDS
{
  private IEvsVoucherDAO evsVoucherDAO;
  
  public IEvsVoucherDAO getEvsVoucherDAO()
  {
    return this.evsVoucherDAO;
  }
  
  public void setEvsVoucherDAO(IEvsVoucherDAO paramIEvsVoucherDAO)
  {
    this.evsVoucherDAO = paramIEvsVoucherDAO;
  }
  
  public boolean syn(FbpSynchRequestsV paramFbpSynchRequestsV)
    throws Exception
  {
    this.evsVoucherDAO.vocherMatch();
    return true;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.proxy.syn.VoucherMatchDS
 * JD-Core Version:    0.7.0.1
 */