package com.zte.evs.ebill.business.archives;

import com.zte.eas.appframe.business.accessory.model.FbpAccessoryV;
import com.zte.evs.ebill.model.archives.EvsFindVoucherV;
import com.zte.evs.ebill.model.archives.FbpArchivesHeaders;
import com.zte.evs.ebill.model.archives.FbpArchivesHeadersV;
import com.zte.evs.ebill.model.archives.FbpArchivesLines;
import com.zte.evs.ebill.model.archives.FindEmployeesV;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.DomainService;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public abstract interface IFbpArchivesHeadersDS
  extends DomainService
{
  public abstract void clickSendEmailorSmsOne(String paramString);
  
  public abstract void clickSendEmailorSmsTwo(String paramString);
  
  public abstract void clickSendEmailorSmsFour(String paramString);
  
  public abstract void timerSendEmailorSms();
  
  public abstract String updateArchivesHeadersProccessRejected(String paramString);
  
  public abstract String updateArchivesHeadersProccessBk(String paramString, Date paramDate)
    throws ParseException;
  
  public abstract String updateArchivesHeadersProccess()
    throws ParseException;
  
  public abstract FbpArchivesHeadersV getFbpArchivesHeadersV(Long paramLong);
  
  public abstract List<FbpArchivesHeaders> getFbpArchivesHeaderss(int paramInt1, int paramInt2);
  
  public abstract List<FbpArchivesHeaders> getFbpArchivesHeaderss();
  
  public abstract void removeFbpArchivesHeaders(Long paramLong);
  
  public abstract void removeFbpArchivesHeaders(FbpArchivesHeaders paramFbpArchivesHeaders);
  
  public abstract void insertFbpArchivesHeaders(FbpArchivesHeaders paramFbpArchivesHeaders);
  
  public abstract void updateFbpArchivesHeaders(FbpArchivesHeaders paramFbpArchivesHeaders);
  
  public abstract void insertFbpArchivesHeaderss(List<FbpArchivesHeaders> paramList);
  
  public abstract void removeFbpArchivesHeaderss(List<FbpArchivesHeaders> paramList);
  
  public abstract void updateFbpArchivesHeaderss(List<FbpArchivesHeaders> paramList);
  
  public abstract TableDataInfo findJournalNumByQry(EvsFindVoucherV paramEvsFindVoucherV, int paramInt1, int paramInt2);
  
  public abstract TableDataInfo findFbpArchivesHeadersV(FbpArchivesHeadersV paramFbpArchivesHeadersV, int paramInt1, int paramInt2);
  
  public abstract String updateArchivesHeadersApprove(String paramString1, String paramString2, String paramString3);
  
  public abstract String getArchivesNumber();
  
  public abstract FindEmployeesV findEmployeesLoginV();
  
  public abstract String getSystemDate();
  
  public abstract String submitArchivesBorrow(FbpArchivesHeadersV paramFbpArchivesHeadersV, List<FbpArchivesLines> paramList)
    throws Exception;
  
  public abstract FbpArchivesHeadersV findFbpArchivesHeadersV(Long paramLong);
  
  public abstract String archivesSaveAsDraft(FbpArchivesHeadersV paramFbpArchivesHeadersV, List<FbpArchivesLines> paramList);
  
  public abstract void removeArchivesById(Long paramLong);
  
  public abstract String uploadfile(FbpAccessoryV paramFbpAccessoryV);
  
  public abstract String findArchiveVoucherStatus(String paramString1, String paramString2);
  
  public abstract String updateArchivesByVoucher(String paramString1, String paramString2, Date paramDate);
  
  public abstract String updateArchivesByBook(String paramString1, String paramString2, Date paramDate);
  
  public abstract String updateArchivesToReturn(String paramString1, String paramString2, Date paramDate);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.archives.IFbpArchivesHeadersDS
 * JD-Core Version:    0.7.0.1
 */