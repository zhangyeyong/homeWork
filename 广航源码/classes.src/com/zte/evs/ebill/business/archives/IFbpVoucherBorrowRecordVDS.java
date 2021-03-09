package com.zte.evs.ebill.business.archives;

import com.zte.evs.ebill.model.archives.FbpVoucherBorrowRecordV;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.DomainService;

public abstract interface IFbpVoucherBorrowRecordVDS
  extends DomainService
{
  public abstract TableDataInfo findVoucherBorrowRecords(FbpVoucherBorrowRecordV paramFbpVoucherBorrowRecordV, String paramString1, String paramString2);
  
  public abstract FbpVoucherBorrowRecordV findVoucherBorrowRecord(String paramString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.archives.IFbpVoucherBorrowRecordVDS
 * JD-Core Version:    0.7.0.1
 */