package com.zte.report.ds;

import com.zte.eas.organization.business.countcompanymanage.model.FbpCompanyV;
import com.zte.report.dao.IBillPostManagerReportVDAO;
import com.zte.report.model.BillPostManagerReportV;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.BaseDomainService;
import com.zte.ssb.framework.base.util.PageInfo;
import java.util.List;

public class BillPostManagerReportVDS
  extends BaseDomainService
  implements IBillPostManagerReportVDS
{
  private IBillPostManagerReportVDAO billPostManagerReportVDAO;
  
  public void setBillPostManagerReportVDAO(IBillPostManagerReportVDAO paramIBillPostManagerReportVDAO)
  {
    super.setDao(paramIBillPostManagerReportVDAO);
    this.billPostManagerReportVDAO = paramIBillPostManagerReportVDAO;
  }
  
  public List<BillPostManagerReportV> getBillPostManagerReportVs(int paramInt1, int paramInt2)
  {
    return this.billPostManagerReportVDAO.getBillPostManagerReportVs(paramInt1, paramInt2);
  }
  
  public List<BillPostManagerReportV> getBillPostManagerReportVs()
  {
    return this.billPostManagerReportVDAO.getBillPostManagerReportVs();
  }
  
  public void removeBillPostManagerReportV(BillPostManagerReportV paramBillPostManagerReportV)
  {
    this.billPostManagerReportVDAO.removeBillPostManagerReportV(paramBillPostManagerReportV);
  }
  
  public void insertBillPostManagerReportV(BillPostManagerReportV paramBillPostManagerReportV)
  {
    this.billPostManagerReportVDAO.insertBillPostManagerReportV(paramBillPostManagerReportV);
  }
  
  public void updateBillPostManagerReportV(BillPostManagerReportV paramBillPostManagerReportV)
  {
    this.billPostManagerReportVDAO.updateBillPostManagerReportV(paramBillPostManagerReportV);
  }
  
  public void insertBillPostManagerReportVs(List<BillPostManagerReportV> paramList)
  {
    this.billPostManagerReportVDAO.insertBillPostManagerReportVs(paramList);
  }
  
  public void removeBillPostManagerReportVs(List<BillPostManagerReportV> paramList)
  {
    this.billPostManagerReportVDAO.removeBillPostManagerReportVs(paramList);
  }
  
  public void updateBillPostManagerReportVs(List<BillPostManagerReportV> paramList)
  {
    this.billPostManagerReportVDAO.updateBillPostManagerReportVs(paramList);
  }
  
  public TableDataInfo findBillPostManagerReportV(BillPostManagerReportV paramBillPostManagerReportV, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    PageInfo localPageInfo = this.billPostManagerReportVDAO.findBillPostManagerReportV(paramBillPostManagerReportV, paramInt1, paramInt2);
    localTableDataInfo.setData((List)localPageInfo.getResult());
    localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
    return localTableDataInfo;
  }
  
  public TableDataInfo findAllCompanys(FbpCompanyV paramFbpCompanyV, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    PageInfo localPageInfo = this.billPostManagerReportVDAO.findAllCompanys(paramFbpCompanyV, paramInt1, paramInt2);
    localTableDataInfo.setData((List)localPageInfo.getResult());
    localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
    return localTableDataInfo;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.report.ds.BillPostManagerReportVDS
 * JD-Core Version:    0.7.0.1
 */