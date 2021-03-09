package com.zte.evs.ebill.access.archives;

import com.zte.evs.ebill.model.archives.FbpVoucherBorrowRecordV;
import com.zte.ssb.framework.base.DAO;
import com.zte.ssb.framework.base.util.PageInfo;

public abstract interface IFbpVoucherBorrowRecordVDAO
  extends DAO
{
  public abstract PageInfo findVoucherBorrowRecords(FbpVoucherBorrowRecordV paramFbpVoucherBorrowRecordV, Integer paramInteger1, Integer paramInteger2);
  
  public abstract FbpVoucherBorrowRecordV findVoucherBorrowRecord(Long paramLong);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.archives.IFbpVoucherBorrowRecordVDAO
 * JD-Core Version:    0.7.0.1
 */