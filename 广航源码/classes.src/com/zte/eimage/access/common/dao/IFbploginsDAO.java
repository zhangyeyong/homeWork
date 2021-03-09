package com.zte.eimage.access.common.dao;

import com.zte.eimage.business.common.model.Fbplogins;
import com.zte.ssb.framework.base.DAO;
import java.math.BigInteger;
import java.util.List;

public abstract interface IFbploginsDAO
  extends DAO
{
  public abstract Fbplogins getFbplogins(BigInteger paramBigInteger);
  
  public abstract List<Fbplogins> getFbploginss(int paramInt1, int paramInt2);
  
  public abstract List<Fbplogins> getFbploginss();
  
  public abstract void removeFbplogins(BigInteger paramBigInteger);
  
  public abstract void removeFbplogins(Fbplogins paramFbplogins);
  
  public abstract void insertFbplogins(Fbplogins paramFbplogins);
  
  public abstract void updateFbplogins(Fbplogins paramFbplogins);
  
  public abstract void insertFbploginss(List<Fbplogins> paramList);
  
  public abstract void removeFbploginss(List<Fbplogins> paramList);
  
  public abstract void updateFbploginss(List<Fbplogins> paramList);
  
  public abstract Integer getLoginCount();
  
  public abstract Integer getOnlineLoginCount();
  
  public abstract Fbplogins getFbplogins(String paramString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.access.common.dao.IFbploginsDAO
 * JD-Core Version:    0.7.0.1
 */