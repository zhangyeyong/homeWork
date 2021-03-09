package com.zte.eimage.business.baseconfig.service;

import com.zte.eimage.business.baseconfig.model.FbpVoucherBorrowV;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.DomainService;
import java.util.List;

public abstract interface IFbpVoucherBorrowVDS
  extends DomainService
{
  public abstract FbpVoucherBorrowV getFbpVoucherBorrowV(Long paramLong);
  
  public abstract TableDataInfo getFbpVoucherBorrowVs(FbpVoucherBorrowV paramFbpVoucherBorrowV, int paramInt1, int paramInt2);
  
  public abstract TableDataInfo findFbpVoucherBorrowVs(FbpVoucherBorrowV paramFbpVoucherBorrowV, int paramInt1, int paramInt2);
  
  public abstract List<FbpVoucherBorrowV> getFbpVoucherBorrowVs();
  
  public abstract void removeFbpVoucherBorrowV(Long paramLong);
  
  public abstract void removeFbpVoucherBorrowV(FbpVoucherBorrowV paramFbpVoucherBorrowV);
  
  public abstract void insertFbpVoucherBorrowV(FbpVoucherBorrowV paramFbpVoucherBorrowV);
  
  public abstract String updateFbpVoucherBorrowV(FbpVoucherBorrowV paramFbpVoucherBorrowV);
  
  public abstract void insertFbpVoucherBorrowVs(List<FbpVoucherBorrowV> paramList);
  
  public abstract void removeFbpVoucherBorrowVs(List<FbpVoucherBorrowV> paramList);
  
  public abstract String updateFbpVoucherBorrowVs(List<String> paramList);
  
  public abstract String updateFbpVoucherCollar(List<String> paramList);
  
  public abstract String updateFbpVoucherGiveBack(List<String> paramList);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.service.IFbpVoucherBorrowVDS
 * JD-Core Version:    0.7.0.1
 */