package com.zte.evs.ebill.access.archives;

import com.zte.evs.ebill.model.archives.EvsFindVoucherV;
import com.zte.evs.ebill.model.archives.FbpArchivesHeaders;
import com.zte.evs.ebill.model.archives.FbpArchivesHeadersV;
import com.zte.evs.ebill.model.eBillManage.EvsAllotHeaders;
import com.zte.evs.ebill.model.eBillManage.EvsVoucher;
import com.zte.ssb.framework.base.DAO;
import com.zte.ssb.framework.base.util.PageInfo;
import java.util.Date;
import java.util.List;

public abstract interface IFbpArchivesHeadersDAO
  extends DAO
{
  public abstract List<FbpArchivesHeaders> getFbpArchivesHeadersByHeaderId(String paramString);
  
  public abstract FbpArchivesHeaders getFbpArchivesHeaders(String paramString);
  
  public abstract String findEmployeeLeaders(String paramString);
  
  public abstract List<FbpArchivesHeaders> findFbpArchivesHeadersListWaitApp();
  
  public abstract List<FbpArchivesHeaders> findFbpArchivesHeadersListNTwo();
  
  public abstract List<FbpArchivesHeaders> findFbpArchivesHeadersListN();
  
  public abstract List<FbpArchivesHeaders> findFbpArchivesHeadersList();
  
  public abstract String updateArchivesHeadersProccessRejected(String paramString);
  
  public abstract FbpArchivesHeadersV getFbpArchivesHeadersV(Long paramLong);
  
  public abstract EvsVoucher getEvsVoucher(Long paramLong);
  
  public abstract List getFbpArchivesHeadersV(String paramString);
  
  public abstract EvsAllotHeaders findEvsAllotHeadersList(String paramString);
  
  public abstract List<FbpArchivesHeaders> getFbpArchivesHeaderss(int paramInt1, int paramInt2);
  
  public abstract List<FbpArchivesHeaders> getFbpArchivesHeaderss();
  
  public abstract void removeFbpArchivesHeaders(Long paramLong);
  
  public abstract PageInfo findJournalNumByQry(EvsFindVoucherV paramEvsFindVoucherV, int paramInt1, int paramInt2);
  
  public abstract String findApproveEmpl(String paramString);
  
  public abstract String getArchivesNumber();
  
  public abstract FbpArchivesHeaders getFbpArchivesHeadersByNum(Long paramLong);
  
  public abstract List<EvsVoucher> findArchivesLinesVListByHeaderId(String paramString1, String paramString2, String paramString3);
  
  public abstract void removeFbpArchivesHeaders(FbpArchivesHeaders paramFbpArchivesHeaders);
  
  public abstract void insertFbpArchivesHeaders(FbpArchivesHeaders paramFbpArchivesHeaders);
  
  public abstract void updateFbpArchivesHeaders(FbpArchivesHeaders paramFbpArchivesHeaders);
  
  public abstract void saveOrUpdate(Object paramObject);
  
  public abstract void insertFbpArchivesHeaderss(List<FbpArchivesHeaders> paramList);
  
  public abstract void removeFbpArchivesHeaderss(List<FbpArchivesHeaders> paramList);
  
  public abstract void updateFbpArchivesHeaderss(List<FbpArchivesHeaders> paramList);
  
  public abstract PageInfo findFbpArchivesHeadersV(FbpArchivesHeadersV paramFbpArchivesHeadersV, int paramInt1, int paramInt2);
  
  public abstract String updateArchivesHeadersApprove(String paramString1, String paramString2, String paramString3);
  
  public abstract String updateArchivesHeadersProccess(String paramString1, String paramString2);
  
  public abstract String updateArchivesHeadersProccessBk(String paramString1, String paramString2);
  
  public abstract FbpArchivesHeadersV findFbpArchivesHeadersV(Long paramLong);
  
  public abstract String findEvsManageOrgV(String paramString);
  
  public abstract void updateArchivesHeadersStatus(String paramString1, String paramString2, String paramString3, Date paramDate);
  
  public abstract void updateArchivesHeadersStatusByReturn(String paramString1, String paramString2, String paramString3, Date paramDate);
  
  public abstract void updateVoucherStatus(String paramString1, String paramString2);
  
  public abstract void insertFbpArchivesHistories(String paramString1, Long paramLong, String paramString2);
  
  public abstract void updateVoucherStatus(String paramString);
  
  public abstract void removeFbpArchivesLines(Long paramLong);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.archives.IFbpArchivesHeadersDAO
 * JD-Core Version:    0.7.0.1
 */