package com.zte.evs.ebill.business.eBillManage;

import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.eas.organization.business.countcompanymanage.model.FbpCompanyV;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherStatistics;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import java.util.List;

public abstract interface IEvsVoucherBookQueryService
{
  public abstract TableDataInfo findVoucherStatistics(FbpCompanyV paramFbpCompanyV, int paramInt1, int paramInt2);
  
  public abstract List<EvsVoucherStatistics> findVoucherStatistics(EasUserInfo paramEasUserInfo);
  
  public abstract List<EvsVoucherStatistics> findComanyVoucherInfoByCompanyCode(EvsVoucherStatistics paramEvsVoucherStatistics);
  
  public abstract List<EvsVoucherStatistics> initTree(EasUserInfo paramEasUserInfo);
  
  public abstract List<EvsVoucherStatistics> findMonthVoucherStatisticsByYear(EvsVoucherStatistics paramEvsVoucherStatistics);
  
  public abstract List<EvsVoucherStatistics> findVoucherBigClassByMonth(EvsVoucherStatistics paramEvsVoucherStatistics);
  
  public abstract TableDataInfo findBookByVoucherType(EvsVoucherStatistics paramEvsVoucherStatistics, int paramInt1, int paramInt2);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.eBillManage.IEvsVoucherBookQueryService
 * JD-Core Version:    0.7.0.1
 */