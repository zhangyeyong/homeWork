package com.zte.eimage.business.baseconfig.service;

import com.zte.eimage.business.baseconfig.model.FbpVoucherRelBorrowV;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.DomainService;
import java.util.List;

public abstract interface IFbpVoucherRelBorrowVDS
  extends DomainService
{
  public abstract FbpVoucherRelBorrowV getFbpVoucherRelBorrowV(String paramString);
  
  public abstract TableDataInfo getFbpVoucherRelBorrowVs(FbpVoucherRelBorrowV paramFbpVoucherRelBorrowV, int paramInt1, int paramInt2);
  
  public abstract List<FbpVoucherRelBorrowV> getFbpVoucherRelBorrowVs();
  
  public abstract void removeFbpVoucherRelBorrowV(String paramString);
  
  public abstract void removeFbpVoucherRelBorrowV(FbpVoucherRelBorrowV paramFbpVoucherRelBorrowV);
  
  public abstract void insertFbpVoucherRelBorrowV(FbpVoucherRelBorrowV paramFbpVoucherRelBorrowV);
  
  public abstract void updateFbpVoucherRelBorrowV(FbpVoucherRelBorrowV paramFbpVoucherRelBorrowV);
  
  public abstract void insertFbpVoucherRelBorrowVs(List<FbpVoucherRelBorrowV> paramList);
  
  public abstract void removeFbpVoucherRelBorrowVs(List<FbpVoucherRelBorrowV> paramList);
  
  public abstract void updateFbpVoucherRelBorrowVs(List<FbpVoucherRelBorrowV> paramList);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.service.IFbpVoucherRelBorrowVDS
 * JD-Core Version:    0.7.0.1
 */