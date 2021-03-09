package com.zte.eimage.business.baseconfig.service;

import com.zte.eimage.business.baseconfig.model.FbpVoucherApproveV;
import com.zte.eimage.business.baseconfig.model.FbpVoucherApproveVL;
import com.zte.evs.ebill.model.archives.FbpArchivesHeaders;
import com.zte.evs.ebill.model.archives.FbpArchivesHistories;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.DomainService;
import java.util.List;

public abstract interface IFbpVoucherApproveVDS
  extends DomainService
{
  public abstract FbpArchivesHeaders getFbpVoucherApproveV(Long paramLong);
  
  public abstract TableDataInfo getFbpVoucherApproveVs(FbpVoucherApproveV paramFbpVoucherApproveV, int paramInt1, int paramInt2);
  
  public abstract TableDataInfo getFbpVoucherApproveVLs(FbpVoucherApproveVL paramFbpVoucherApproveVL, int paramInt1, int paramInt2);
  
  public abstract List<FbpVoucherApproveV> getFbpVoucherApproveVs();
  
  public abstract void removeFbpVoucherApproveV(Long paramLong);
  
  public abstract void removeFbpVoucherApproveV(FbpVoucherApproveV paramFbpVoucherApproveV);
  
  public abstract void insertFbpVoucherApproveV(FbpVoucherApproveV paramFbpVoucherApproveV);
  
  public abstract String fbpVoucherApproveVAgree(FbpVoucherApproveV paramFbpVoucherApproveV, List<String> paramList1, List<String> paramList2)
    throws Exception;
  
  public abstract String fbpVoucherApproveVDisGree(FbpVoucherApproveV paramFbpVoucherApproveV, List<String> paramList1, List<String> paramList2)
    throws Exception;
  
  public abstract void insertFbpVoucherApproveVs(List<FbpArchivesHistories> paramList);
  
  public abstract void removeFbpVoucherApproveVs(List<FbpVoucherApproveV> paramList);
  
  public abstract String fbpVoucherApproveVAgree(FbpVoucherApproveV paramFbpVoucherApproveV, String paramString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.service.IFbpVoucherApproveVDS
 * JD-Core Version:    0.7.0.1
 */