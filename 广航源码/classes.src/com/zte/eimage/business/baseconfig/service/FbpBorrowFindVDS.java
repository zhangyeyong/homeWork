package com.zte.eimage.business.baseconfig.service;

import com.zte.eimage.access.baseconfig.dao.IFbpBorrowFindVDAO;
import com.zte.eimage.business.baseconfig.model.FbpBorrowFindV;
import com.zte.eimage.business.baseconfig.model.FbpBorrowFindVL;
import com.zte.ssb.framework.base.BaseDomainService;
import java.util.List;

public class FbpBorrowFindVDS
  extends BaseDomainService
  implements IFbpBorrowFindVDS
{
  private IFbpBorrowFindVDAO fbpBorrowFindVDAO;
  
  public void setFbpBorrowFindVDAO(IFbpBorrowFindVDAO paramIFbpBorrowFindVDAO)
  {
    super.setDao(paramIFbpBorrowFindVDAO);
    this.fbpBorrowFindVDAO = paramIFbpBorrowFindVDAO;
  }
  
  public List<FbpBorrowFindV> getFbpBorrowFindVs(int paramInt1, int paramInt2)
  {
    return this.fbpBorrowFindVDAO.getFbpBorrowFindVs(paramInt1, paramInt2);
  }
  
  public List<FbpBorrowFindV> getFbpBorrowFindVs()
  {
    return this.fbpBorrowFindVDAO.getFbpBorrowFindVs();
  }
  
  public FbpBorrowFindV getFbpBorrowFindV(String paramString)
  {
    return this.fbpBorrowFindVDAO.getFbpBorrowFindV(paramString);
  }
  
  public FbpBorrowFindVL getFbpBorrowFindVL(String paramString)
  {
    return this.fbpBorrowFindVDAO.getFbpBorrowFindVL(paramString);
  }
  
  public void removeFbpBorrowFindV(Long paramLong)
  {
    this.fbpBorrowFindVDAO.removeFbpBorrowFindV(paramLong);
  }
  
  public void removeFbpBorrowFindV(FbpBorrowFindV paramFbpBorrowFindV)
  {
    this.fbpBorrowFindVDAO.removeFbpBorrowFindV(paramFbpBorrowFindV);
  }
  
  public void insertFbpBorrowFindV(FbpBorrowFindV paramFbpBorrowFindV)
  {
    this.fbpBorrowFindVDAO.insertFbpBorrowFindV(paramFbpBorrowFindV);
  }
  
  public void updateFbpBorrowFindV(FbpBorrowFindV paramFbpBorrowFindV)
  {
    this.fbpBorrowFindVDAO.updateFbpBorrowFindV(paramFbpBorrowFindV);
  }
  
  public void insertFbpBorrowFindVs(List<FbpBorrowFindV> paramList)
  {
    this.fbpBorrowFindVDAO.insertFbpBorrowFindVs(paramList);
  }
  
  public void removeFbpBorrowFindVs(List<FbpBorrowFindV> paramList)
  {
    this.fbpBorrowFindVDAO.removeFbpBorrowFindVs(paramList);
  }
  
  public void updateFbpBorrowFindVs(List<FbpBorrowFindV> paramList)
  {
    this.fbpBorrowFindVDAO.updateFbpBorrowFindVs(paramList);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.service.FbpBorrowFindVDS
 * JD-Core Version:    0.7.0.1
 */