package com.zte.evs.ebill.business.eBillManage;

import com.zte.evs.ebill.access.eBillManage.IEvsImageDAO;
import com.zte.evs.ebill.model.eBillManage.EvsImage;

public class EvsImageService
  implements IEvsImageService
{
  IEvsImageDAO evsImageDAO;
  
  public void saveImage(EvsImage paramEvsImage)
  {
    this.evsImageDAO.saveImage(paramEvsImage);
  }
  
  public IEvsImageDAO getEvsImageDAO()
  {
    return this.evsImageDAO;
  }
  
  public void setEvsImageDAO(IEvsImageDAO paramIEvsImageDAO)
  {
    this.evsImageDAO = paramIEvsImageDAO;
  }
  
  public int updateVideoAbate(Long paramLong)
  {
    return this.evsImageDAO.updateVideoAbate(paramLong);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.eBillManage.EvsImageService
 * JD-Core Version:    0.7.0.1
 */