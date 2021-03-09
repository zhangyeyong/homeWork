package com.zte.eimage.access.baseconfig.dao;

import com.zte.eimage.business.baseconfig.model.EidImageMemoV;
import com.zte.ssb.framework.base.DAO;
import java.util.List;

public abstract interface IEidImageMemoVDAO
  extends DAO
{
  public abstract EidImageMemoV getEidImageMemoV(String paramString);
  
  public abstract List<EidImageMemoV> getEidImageMemoVs(int paramInt1, int paramInt2);
  
  public abstract List<EidImageMemoV> getEidImageMemoVs();
  
  public abstract void removeEidImageMemoV(String paramString);
  
  public abstract void removeEidImageMemoV(EidImageMemoV paramEidImageMemoV);
  
  public abstract void insertEidImageMemoV(EidImageMemoV paramEidImageMemoV);
  
  public abstract void updateEidImageMemoV(EidImageMemoV paramEidImageMemoV);
  
  public abstract void insertEidImageMemoVs(List<EidImageMemoV> paramList);
  
  public abstract void removeEidImageMemoVs(List<EidImageMemoV> paramList);
  
  public abstract void updateEidImageMemoVs(List<EidImageMemoV> paramList);
  
  public abstract List<EidImageMemoV> getImageMemoInfo(String paramString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.access.baseconfig.dao.IEidImageMemoVDAO
 * JD-Core Version:    0.7.0.1
 */