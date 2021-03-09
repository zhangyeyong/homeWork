package com.zte.eimage.access.baseconfig.dao;

import com.zte.eimage.business.baseconfig.model.FbpVoucherBorrowV;
import com.zte.evs.ebill.model.archives.FbpArchivesHeaders;
import com.zte.ssb.framework.base.DAO;
import com.zte.ssb.framework.base.util.PageInfo;
import java.util.List;

public abstract interface IFbpVoucherBorrowVDAO
  extends DAO
{
  public abstract Object getFbpVoucherBorrowV(Long paramLong);
  
  public abstract PageInfo getFbpVoucherBorrowVs(FbpVoucherBorrowV paramFbpVoucherBorrowV, int paramInt1, int paramInt2);
  
  public abstract PageInfo findFbpVoucherBorrowVs(FbpVoucherBorrowV paramFbpVoucherBorrowV, int paramInt1, int paramInt2);
  
  public abstract List<FbpVoucherBorrowV> getFbpVoucherBorrowVs();
  
  public abstract void removeFbpVoucherBorrowV(Long paramLong);
  
  public abstract void removeFbpVoucherBorrowV(FbpVoucherBorrowV paramFbpVoucherBorrowV);
  
  public abstract void insertFbpVoucherBorrowV(FbpVoucherBorrowV paramFbpVoucherBorrowV);
  
  public abstract void updateFbpVoucherBorrowV(FbpArchivesHeaders paramFbpArchivesHeaders);
  
  public abstract void insertFbpVoucherBorrowVs(List<FbpVoucherBorrowV> paramList);
  
  public abstract void removeFbpVoucherBorrowVs(List<FbpVoucherBorrowV> paramList);
  
  public abstract void updateFbpVoucherBorrowVs(List<FbpArchivesHeaders> paramList);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.access.baseconfig.dao.IFbpVoucherBorrowVDAO
 * JD-Core Version:    0.7.0.1
 */