package com.zte.evs.ebill.business.archives;

import com.zte.evs.ebill.access.archives.IFbpVoucherBorrowRecordVDAO;
import com.zte.evs.ebill.model.archives.FbpVoucherBorrowRecordV;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.BaseDomainService;
import com.zte.ssb.framework.base.util.PageInfo;
import java.util.List;

public class FbpVoucherBorrowRecordVDS
  extends BaseDomainService
  implements IFbpVoucherBorrowRecordVDS
{
  private IFbpVoucherBorrowRecordVDAO voucherBorrowRecordVDAO;
  
  public TableDataInfo findVoucherBorrowRecords(FbpVoucherBorrowRecordV paramFbpVoucherBorrowRecordV, String paramString1, String paramString2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    PageInfo localPageInfo = this.voucherBorrowRecordVDAO.findVoucherBorrowRecords(paramFbpVoucherBorrowRecordV, Integer.valueOf(paramString1), Integer.valueOf(paramString2));
    List localList = (List)localPageInfo.getResult();
    localTableDataInfo.setData(localList);
    localTableDataInfo.setTotalCount(Long.valueOf(localPageInfo.getTotalCount()).intValue());
    return localTableDataInfo;
  }
  
  public void setVoucherBorrowRecordVDAO(IFbpVoucherBorrowRecordVDAO paramIFbpVoucherBorrowRecordVDAO)
  {
    this.voucherBorrowRecordVDAO = paramIFbpVoucherBorrowRecordVDAO;
  }
  
  public FbpVoucherBorrowRecordV findVoucherBorrowRecord(String paramString)
  {
    FbpVoucherBorrowRecordV localFbpVoucherBorrowRecordV = this.voucherBorrowRecordVDAO.findVoucherBorrowRecord(Long.valueOf(paramString));
    return localFbpVoucherBorrowRecordV;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.archives.FbpVoucherBorrowRecordVDS
 * JD-Core Version:    0.7.0.1
 */