package com.zte.eimage.business.baseconfig.service;

import com.zte.eimage.access.baseconfig.dao.IFbpVoucherRelBorrowVDAO;
import com.zte.eimage.business.baseconfig.model.FbpVoucherRelBorrowV;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.BaseDomainService;
import com.zte.ssb.framework.base.util.PageInfo;
import java.util.List;

public class FbpVoucherRelBorrowVDS
  extends BaseDomainService
  implements IFbpVoucherRelBorrowVDS
{
  private IFbpVoucherRelBorrowVDAO fbpVoucherRelBorrowVDAO;
  
  public void setFbpVoucherRelBorrowVDAO(IFbpVoucherRelBorrowVDAO paramIFbpVoucherRelBorrowVDAO)
  {
    super.setDao(paramIFbpVoucherRelBorrowVDAO);
    this.fbpVoucherRelBorrowVDAO = paramIFbpVoucherRelBorrowVDAO;
  }
  
  public TableDataInfo getFbpVoucherRelBorrowVs(FbpVoucherRelBorrowV paramFbpVoucherRelBorrowV, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    try
    {
      PageInfo localPageInfo = this.fbpVoucherRelBorrowVDAO.getFbpVoucherRelBorrowVs(paramFbpVoucherRelBorrowV, paramInt1, paramInt2);
      localTableDataInfo.setData((List)localPageInfo.getResult());
      localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return null;
    }
    return localTableDataInfo;
  }
  
  public List<FbpVoucherRelBorrowV> getFbpVoucherRelBorrowVs()
  {
    return this.fbpVoucherRelBorrowVDAO.getFbpVoucherRelBorrowVs();
  }
  
  public FbpVoucherRelBorrowV getFbpVoucherRelBorrowV(String paramString)
  {
    return this.fbpVoucherRelBorrowVDAO.getFbpVoucherRelBorrowV(paramString);
  }
  
  public void removeFbpVoucherRelBorrowV(String paramString)
  {
    this.fbpVoucherRelBorrowVDAO.removeFbpVoucherRelBorrowV(paramString);
  }
  
  public void removeFbpVoucherRelBorrowV(FbpVoucherRelBorrowV paramFbpVoucherRelBorrowV)
  {
    this.fbpVoucherRelBorrowVDAO.removeFbpVoucherRelBorrowV(paramFbpVoucherRelBorrowV);
  }
  
  public void insertFbpVoucherRelBorrowV(FbpVoucherRelBorrowV paramFbpVoucherRelBorrowV)
  {
    this.fbpVoucherRelBorrowVDAO.insertFbpVoucherRelBorrowV(paramFbpVoucherRelBorrowV);
  }
  
  public void updateFbpVoucherRelBorrowV(FbpVoucherRelBorrowV paramFbpVoucherRelBorrowV)
  {
    this.fbpVoucherRelBorrowVDAO.updateFbpVoucherRelBorrowV(paramFbpVoucherRelBorrowV);
  }
  
  public void insertFbpVoucherRelBorrowVs(List<FbpVoucherRelBorrowV> paramList)
  {
    this.fbpVoucherRelBorrowVDAO.insertFbpVoucherRelBorrowVs(paramList);
  }
  
  public void removeFbpVoucherRelBorrowVs(List<FbpVoucherRelBorrowV> paramList)
  {
    this.fbpVoucherRelBorrowVDAO.removeFbpVoucherRelBorrowVs(paramList);
  }
  
  public void updateFbpVoucherRelBorrowVs(List<FbpVoucherRelBorrowV> paramList)
  {
    this.fbpVoucherRelBorrowVDAO.updateFbpVoucherRelBorrowVs(paramList);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.service.FbpVoucherRelBorrowVDS
 * JD-Core Version:    0.7.0.1
 */