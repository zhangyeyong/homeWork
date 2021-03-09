package com.zte.eimage.access.baseconfig.dao;

import com.zte.eimage.business.baseconfig.model.FbpVoucherApproveV;
import com.zte.eimage.business.baseconfig.model.FbpVoucherApproveVL;
import com.zte.evs.ebill.model.archives.FbpArchivesHeaders;
import com.zte.evs.ebill.model.archives.FbpArchivesHistories;
import com.zte.evs.ebill.model.archives.FbpArchivesLines;
import com.zte.evs.ebill.model.eBillManage.EvsStorageDocV;
import com.zte.ssb.framework.base.DAO;
import com.zte.ssb.framework.base.util.PageInfo;
import java.util.List;

public abstract interface IFbpVoucherApproveVDAO
  extends DAO
{
  public abstract FbpArchivesHeaders getFbpVoucherApproveV(Long paramLong);
  
  public abstract PageInfo getFbpVoucherApproveVs(FbpVoucherApproveV paramFbpVoucherApproveV, int paramInt1, int paramInt2);
  
  public abstract PageInfo getFbpVoucherApproveVs(FbpVoucherApproveVL paramFbpVoucherApproveVL, int paramInt1, int paramInt2);
  
  public abstract List<FbpVoucherApproveV> getFbpVoucherApproveVs();
  
  public abstract void removeFbpVoucherApproveV(Long paramLong);
  
  public abstract void removeFbpVoucherApproveV(FbpVoucherApproveV paramFbpVoucherApproveV);
  
  public abstract void insertFbpVoucherApproveV(FbpArchivesHistories paramFbpArchivesHistories);
  
  public abstract void updateFbpVoucherApproveV(FbpArchivesHeaders paramFbpArchivesHeaders);
  
  public abstract void insertFbpVoucherApproveVs(List<FbpArchivesHistories> paramList);
  
  public abstract void removeFbpVoucherApproveVs(List<FbpVoucherApproveV> paramList);
  
  public abstract void updateFbpVoucherApproveVs(List<FbpArchivesHeaders> paramList);
  
  public abstract boolean getFbpArchivesHistories(FbpVoucherApproveV paramFbpVoucherApproveV);
  
  public abstract String getObjectList(Long paramLong);
  
  public abstract List<FbpArchivesLines> getFbpVoucherAll(Long paramLong);
  
  public abstract List<EvsStorageDocV> getEvsStorageDocV(EvsStorageDocV paramEvsStorageDocV);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.access.baseconfig.dao.IFbpVoucherApproveVDAO
 * JD-Core Version:    0.7.0.1
 */