package com.zte.eas.appframe.business.fbpLogins.service;

import com.zte.eimage.access.common.dao.IFbploginsDAO;
import com.zte.eimage.business.common.model.Fbplogins;
import com.zte.ssb.framework.base.BaseDomainService;
import com.zte.ssb.servicecontainer.business.server.ISession;
import com.zte.ssb.servicecontainer.business.server.RIAContext;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public class FbploginsDS
  extends BaseDomainService
  implements IFbploginsDS
{
  private IFbploginsDAO fbploginsDAO;
  
  public void setFbploginsDAO(IFbploginsDAO paramIFbploginsDAO)
  {
    super.setDao(paramIFbploginsDAO);
    this.fbploginsDAO = paramIFbploginsDAO;
  }
  
  public List<Fbplogins> getFbploginss(int paramInt1, int paramInt2)
  {
    return this.fbploginsDAO.getFbploginss(paramInt1, paramInt2);
  }
  
  public List<Fbplogins> getFbploginss()
  {
    return this.fbploginsDAO.getFbploginss();
  }
  
  public Fbplogins getFbplogins(BigInteger paramBigInteger)
  {
    return this.fbploginsDAO.getFbplogins(paramBigInteger);
  }
  
  public void removeFbplogins(BigInteger paramBigInteger)
  {
    this.fbploginsDAO.removeFbplogins(paramBigInteger);
  }
  
  public void removeFbplogins(Fbplogins paramFbplogins)
  {
    this.fbploginsDAO.removeFbplogins(paramFbplogins);
  }
  
  public void insertFbplogins(Fbplogins paramFbplogins)
  {
    this.fbploginsDAO.insertFbplogins(paramFbplogins);
  }
  
  public void updateFbplogins(Fbplogins paramFbplogins)
  {
    this.fbploginsDAO.updateFbplogins(paramFbplogins);
  }
  
  public void insertFbploginss(List<Fbplogins> paramList)
  {
    this.fbploginsDAO.insertFbploginss(paramList);
  }
  
  public void removeFbploginss(List<Fbplogins> paramList)
  {
    this.fbploginsDAO.removeFbploginss(paramList);
  }
  
  public void updateFbploginss(List<Fbplogins> paramList)
  {
    this.fbploginsDAO.updateFbploginss(paramList);
  }
  
  public void updateLoginsTime()
  {
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    ISession localISession = localRIAContext.getSession();
    BigInteger localBigInteger = (BigInteger)localISession.getSessionAttribute("loginId");
    if (localBigInteger != null)
    {
      Fbplogins localFbplogins = getFbplogins(localBigInteger);
      if (localFbplogins != null)
      {
        localFbplogins.setActiveTime(new Date());
        this.fbploginsDAO.updateFbplogins(localFbplogins);
      }
    }
  }
  
  public Integer getLoginCount()
  {
    return this.fbploginsDAO.getLoginCount();
  }
  
  public Integer getOnlineLoginCount()
  {
    return this.fbploginsDAO.getOnlineLoginCount();
  }
  
  public void logout() {}
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.business.fbpLogins.service.FbploginsDS
 * JD-Core Version:    0.7.0.1
 */