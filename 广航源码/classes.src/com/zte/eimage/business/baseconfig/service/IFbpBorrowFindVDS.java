package com.zte.eimage.business.baseconfig.service;

import com.zte.eimage.business.baseconfig.model.FbpBorrowFindV;
import com.zte.eimage.business.baseconfig.model.FbpBorrowFindVL;
import com.zte.ssb.framework.base.DomainService;
import java.util.List;

public abstract interface IFbpBorrowFindVDS
  extends DomainService
{
  public abstract FbpBorrowFindV getFbpBorrowFindV(String paramString);
  
  public abstract List<FbpBorrowFindV> getFbpBorrowFindVs(int paramInt1, int paramInt2);
  
  public abstract List<FbpBorrowFindV> getFbpBorrowFindVs();
  
  public abstract void removeFbpBorrowFindV(Long paramLong);
  
  public abstract void removeFbpBorrowFindV(FbpBorrowFindV paramFbpBorrowFindV);
  
  public abstract void insertFbpBorrowFindV(FbpBorrowFindV paramFbpBorrowFindV);
  
  public abstract void updateFbpBorrowFindV(FbpBorrowFindV paramFbpBorrowFindV);
  
  public abstract void insertFbpBorrowFindVs(List<FbpBorrowFindV> paramList);
  
  public abstract void removeFbpBorrowFindVs(List<FbpBorrowFindV> paramList);
  
  public abstract void updateFbpBorrowFindVs(List<FbpBorrowFindV> paramList);
  
  public abstract FbpBorrowFindVL getFbpBorrowFindVL(String paramString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.service.IFbpBorrowFindVDS
 * JD-Core Version:    0.7.0.1
 */