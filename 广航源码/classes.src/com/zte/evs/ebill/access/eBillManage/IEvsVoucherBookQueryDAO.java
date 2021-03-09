package com.zte.evs.ebill.access.eBillManage;

import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.eas.organization.business.countcompanymanage.model.FbpCompanyV;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherStatistics;
import java.util.List;
import java.util.Map;

public abstract interface IEvsVoucherBookQueryDAO
{
  public abstract List<EvsVoucherStatistics> findVoucherNumberFHY(String paramString);
  
  public abstract List<EvsVoucherStatistics> findVoucherNumberTY(String paramString);
  
  public abstract List<EvsVoucherStatistics> findVoucherBookFHY(String paramString);
  
  public abstract List<EvsVoucherStatistics> findVoucherBookTY(String paramString);
  
  public abstract List<EvsVoucherStatistics> findVoucherPageFHY(String paramString);
  
  public abstract List<EvsVoucherStatistics> findVoucherPageTY(String paramString);
  
  public abstract List<FbpCompanyV> findAllCompany(EasUserInfo paramEasUserInfo);
  
  public abstract Map findAllCompany(FbpCompanyV paramFbpCompanyV, EasUserInfo paramEasUserInfo, int paramInt1, int paramInt2);
  
  public abstract List<EvsVoucherStatistics> findVoucherNumber(String paramString1, String paramString2);
  
  public abstract List<EvsVoucherStatistics> findVoucherBookNumber(String paramString1, String paramString2);
  
  public abstract List<EvsVoucherStatistics> findVoucherPageNumber(String paramString1, String paramString2);
  
  public abstract Long getVoucherContrastNum(EvsVoucherStatistics paramEvsVoucherStatistics);
  
  public abstract Long getVoucherTotalBookNum(EvsVoucherStatistics paramEvsVoucherStatistics);
  
  public abstract Long getNotBookNum(EvsVoucherStatistics paramEvsVoucherStatistics);
  
  public abstract Map findBookByVoucherType(EvsVoucherStatistics paramEvsVoucherStatistics, int paramInt1, int paramInt2);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.eBillManage.IEvsVoucherBookQueryDAO
 * JD-Core Version:    0.7.0.1
 */