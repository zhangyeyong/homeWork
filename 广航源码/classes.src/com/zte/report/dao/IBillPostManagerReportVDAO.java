package com.zte.report.dao;

import com.zte.eas.organization.business.countcompanymanage.model.FbpCompanyV;
import com.zte.report.model.BillPostManagerReportV;
import com.zte.ssb.framework.base.DAO;
import com.zte.ssb.framework.base.util.PageInfo;
import java.util.List;

public abstract interface IBillPostManagerReportVDAO
  extends DAO
{
  public abstract List<BillPostManagerReportV> getBillPostManagerReportVs(int paramInt1, int paramInt2);
  
  public abstract List<BillPostManagerReportV> getBillPostManagerReportVs();
  
  public abstract void removeBillPostManagerReportV(BillPostManagerReportV paramBillPostManagerReportV);
  
  public abstract void insertBillPostManagerReportV(BillPostManagerReportV paramBillPostManagerReportV);
  
  public abstract void updateBillPostManagerReportV(BillPostManagerReportV paramBillPostManagerReportV);
  
  public abstract void insertBillPostManagerReportVs(List<BillPostManagerReportV> paramList);
  
  public abstract void removeBillPostManagerReportVs(List<BillPostManagerReportV> paramList);
  
  public abstract void updateBillPostManagerReportVs(List<BillPostManagerReportV> paramList);
  
  public abstract PageInfo findBillPostManagerReportV(BillPostManagerReportV paramBillPostManagerReportV, int paramInt1, int paramInt2);
  
  public abstract PageInfo findAllCompanys(FbpCompanyV paramFbpCompanyV, int paramInt1, int paramInt2);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.report.dao.IBillPostManagerReportVDAO
 * JD-Core Version:    0.7.0.1
 */