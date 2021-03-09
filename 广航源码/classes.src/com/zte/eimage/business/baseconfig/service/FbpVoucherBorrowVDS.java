package com.zte.eimage.business.baseconfig.service;

import com.zte.eimage.access.baseconfig.dao.IFbpVoucherApproveVDAO;
import com.zte.eimage.access.baseconfig.dao.IFbpVoucherBorrowVDAO;
import com.zte.eimage.business.baseconfig.model.FbpVoucherBorrowV;
import com.zte.evs.ebill.access.archives.IFbpArchivesHeadersDAO;
import com.zte.evs.ebill.common.ObjectCopyUtils;
import com.zte.evs.ebill.model.archives.FbpArchivesHeaders;
import com.zte.evs.ebill.model.archives.FbpArchivesLines;
import com.zte.evs.ebill.model.eBillManage.EvsVoucher;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.BaseDomainService;
import com.zte.ssb.framework.base.util.PageInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class FbpVoucherBorrowVDS
  extends BaseDomainService
  implements IFbpVoucherBorrowVDS
{
  private String ARCHIVES_ALREADY_REVERT = "ARCHIVES_ALREADY_REVERT";
  private String ARCHIVES_DEPLAYED_APPROVE = "ARCHIVES_DEPLAYED_APPROVE";
  private String ARCHIVES_BORROWING = "ARCHIVES_BORROWING";
  private IFbpVoucherBorrowVDAO fbpVoucherBorrowVDAO;
  private IFbpVoucherApproveVDAO fbpVoucherApproveVDAO;
  private IFbpArchivesHeadersDAO fbpArchivesHeadersDAO;
  
  public void setFbpVoucherBorrowVDAO(IFbpVoucherBorrowVDAO paramIFbpVoucherBorrowVDAO)
  {
    super.setDao(paramIFbpVoucherBorrowVDAO);
    this.fbpVoucherBorrowVDAO = paramIFbpVoucherBorrowVDAO;
  }
  
  public TableDataInfo getFbpVoucherBorrowVs(FbpVoucherBorrowV paramFbpVoucherBorrowV, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    try
    {
      PageInfo localPageInfo = this.fbpVoucherBorrowVDAO.getFbpVoucherBorrowVs(paramFbpVoucherBorrowV, paramInt1, paramInt2);
      localTableDataInfo.setData((List)localPageInfo.getResult());
      localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
      return localTableDataInfo;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public TableDataInfo findFbpVoucherBorrowVs(FbpVoucherBorrowV paramFbpVoucherBorrowV, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    try
    {
      PageInfo localPageInfo = this.fbpVoucherBorrowVDAO.findFbpVoucherBorrowVs(paramFbpVoucherBorrowV, paramInt1, paramInt2);
      localTableDataInfo.setData((List)localPageInfo.getResult());
      localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
      return localTableDataInfo;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public List<FbpVoucherBorrowV> getFbpVoucherBorrowVs()
  {
    return this.fbpVoucherBorrowVDAO.getFbpVoucherBorrowVs();
  }
  
  public FbpVoucherBorrowV getFbpVoucherBorrowV(Long paramLong)
  {
    return (FbpVoucherBorrowV)this.fbpVoucherBorrowVDAO.getFbpVoucherBorrowV(paramLong);
  }
  
  public void removeFbpVoucherBorrowV(Long paramLong)
  {
    this.fbpVoucherBorrowVDAO.removeFbpVoucherBorrowV(paramLong);
  }
  
  public void removeFbpVoucherBorrowV(FbpVoucherBorrowV paramFbpVoucherBorrowV)
  {
    this.fbpVoucherBorrowVDAO.removeFbpVoucherBorrowV(paramFbpVoucherBorrowV);
  }
  
  public void insertFbpVoucherBorrowV(FbpVoucherBorrowV paramFbpVoucherBorrowV)
  {
    this.fbpVoucherBorrowVDAO.insertFbpVoucherBorrowV(paramFbpVoucherBorrowV);
  }
  
  public String updateFbpVoucherBorrowV(FbpVoucherBorrowV paramFbpVoucherBorrowV)
  {
    Date localDate = new Date();
    FbpArchivesHeaders localFbpArchivesHeaders = (FbpArchivesHeaders)this.fbpVoucherBorrowVDAO.getFbpVoucherBorrowV(paramFbpVoucherBorrowV.getArchivesHeaderId());
    localFbpArchivesHeaders.setArchivesStatus(this.ARCHIVES_DEPLAYED_APPROVE);
    localFbpArchivesHeaders.setAttribute2(paramFbpVoucherBorrowV.getAttribute2());
    localFbpArchivesHeaders.setApplyDesc("延期原因：" + paramFbpVoucherBorrowV.getApplyDesc());
    localFbpArchivesHeaders.setLastUpdateDate(localDate);
    try
    {
      this.fbpVoucherBorrowVDAO.updateFbpVoucherBorrowV(localFbpArchivesHeaders);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return "N";
    }
    return "Y";
  }
  
  public void insertFbpVoucherBorrowVs(List<FbpVoucherBorrowV> paramList)
  {
    this.fbpVoucherBorrowVDAO.insertFbpVoucherBorrowVs(paramList);
  }
  
  public void removeFbpVoucherBorrowVs(List<FbpVoucherBorrowV> paramList)
  {
    this.fbpVoucherBorrowVDAO.removeFbpVoucherBorrowVs(paramList);
  }
  
  public String updateFbpVoucherBorrowVs(List<String> paramList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      FbpArchivesHeaders localFbpArchivesHeaders = (FbpArchivesHeaders)this.fbpVoucherBorrowVDAO.getFbpVoucherBorrowV(Long.valueOf(Long.parseLong(str1)));
      String str2 = localFbpArchivesHeaders.getArchivesStatus();
      if (("ARCHIVES_ALREADY_APPROVE".equals(str2)) || ("ARCHIVES_DEPLAYED_APPROVE".equals(str2)))
      {
        localFbpArchivesHeaders.setArchivesStatus(this.ARCHIVES_ALREADY_REVERT);
        ObjectCopyUtils.setWho(localFbpArchivesHeaders);
        localArrayList.add(localFbpArchivesHeaders);
      }
      else
      {
        localStringBuffer.append(localFbpArchivesHeaders.getApplyNum() + ",");
      }
    }
    try
    {
      if (localArrayList.size() > 0) {
        this.fbpVoucherBorrowVDAO.updateFbpVoucherBorrowVs(localArrayList);
      }
      if (localStringBuffer.length() > 0) {
        return localStringBuffer.toString().substring(0, localStringBuffer.length() - 1);
      }
      return "Y";
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "N";
  }
  
  public String updateFbpVoucherCollar(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      FbpArchivesHeaders localFbpArchivesHeaders = (FbpArchivesHeaders)this.fbpVoucherBorrowVDAO.getFbpVoucherBorrowV(Long.valueOf(Long.parseLong(str)));
      localFbpArchivesHeaders.setArchivesStatus(this.ARCHIVES_BORROWING);
      ObjectCopyUtils.setWho(localFbpArchivesHeaders);
      localArrayList.add(localFbpArchivesHeaders);
    }
    try
    {
      if (localArrayList.size() > 0) {
        this.fbpVoucherBorrowVDAO.updateFbpVoucherBorrowVs(localArrayList);
      }
      return "Y";
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "N";
  }
  
  public String updateFbpVoucherGiveBack(List<String> paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator1 = paramList.iterator();
    while (localIterator1.hasNext())
    {
      String str1 = (String)localIterator1.next();
      FbpArchivesHeaders localFbpArchivesHeaders = (FbpArchivesHeaders)this.fbpVoucherBorrowVDAO.getFbpVoucherBorrowV(Long.valueOf(Long.parseLong(str1)));
      String str2 = localFbpArchivesHeaders.getArchivesStatus();
      localFbpArchivesHeaders.setArchivesStatus(this.ARCHIVES_ALREADY_REVERT);
      ObjectCopyUtils.setWho(localFbpArchivesHeaders);
      List localList = this.fbpVoucherApproveVDAO.getFbpVoucherAll(localFbpArchivesHeaders.getArchivesHeaderId());
      Iterator localIterator2 = localList.iterator();
      while (localIterator2.hasNext())
      {
        FbpArchivesLines localFbpArchivesLines = (FbpArchivesLines)localIterator2.next();
        EvsVoucher localEvsVoucher = this.fbpArchivesHeadersDAO.getEvsVoucher(localFbpArchivesLines.getVoucherId());
        localEvsVoucher.setVoucherStatus(localFbpArchivesLines.getAttribute1());
        ObjectCopyUtils.setWho(localEvsVoucher);
        localArrayList2.add(localEvsVoucher);
      }
      localArrayList1.add(localFbpArchivesHeaders);
    }
    try
    {
      if (localArrayList1.size() > 0) {
        this.fbpVoucherBorrowVDAO.updateFbpVoucherBorrowVs(localArrayList1);
      }
      if (localArrayList2.size() > 0) {
        updateObjects(localArrayList2);
      }
      return "Y";
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "N";
  }
  
  public void setFbpVoucherApproveVDAO(IFbpVoucherApproveVDAO paramIFbpVoucherApproveVDAO)
  {
    this.fbpVoucherApproveVDAO = paramIFbpVoucherApproveVDAO;
  }
  
  public void setFbpArchivesHeadersDAO(IFbpArchivesHeadersDAO paramIFbpArchivesHeadersDAO)
  {
    this.fbpArchivesHeadersDAO = paramIFbpArchivesHeadersDAO;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.service.FbpVoucherBorrowVDS
 * JD-Core Version:    0.7.0.1
 */