package com.zte.evs.ebill.access.archives;

import com.zte.evs.ebill.model.archives.FbpVoucherBorrowRecordV;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.framework.base.util.PageInfo;
import java.util.ArrayList;
import java.util.List;

public class FbpVoucherBorrowRecordVDAO
  extends BaseDAO
  implements IFbpVoucherBorrowRecordVDAO
{
  public PageInfo findVoucherBorrowRecords(FbpVoucherBorrowRecordV paramFbpVoucherBorrowRecordV, Integer paramInteger1, Integer paramInteger2)
  {
    StringBuilder localStringBuilder = new StringBuilder("FROM FbpVoucherBorrowRecordV vbr WHERE 1=1 ");
    ArrayList localArrayList = new ArrayList();
    String str1 = paramFbpVoucherBorrowRecordV.getBlurQuery();
    Boolean localBoolean = Boolean.valueOf("Y".equals(str1));
    String str2 = paramFbpVoucherBorrowRecordV.getApplyNum();
    if ((null != str2) && (!"".equals(str2))) {
      if (localBoolean.booleanValue())
      {
        localStringBuilder.append(" AND vbr.applyNum like ? ");
        localArrayList.add("%" + str2 + "%");
      }
      else
      {
        localStringBuilder.append(" AND vbr.applyNum = ? ");
        localArrayList.add(str2);
      }
    }
    Long localLong1 = paramFbpVoucherBorrowRecordV.getCompanyId();
    if (null != localLong1)
    {
      localStringBuilder.append(" AND vbr.companyId = ? ");
      localArrayList.add(localLong1);
    }
    Long localLong2 = paramFbpVoucherBorrowRecordV.getEmployeeId();
    if (null != localLong2)
    {
      localStringBuilder.append(" AND vbr.employeeId = ? ");
      localArrayList.add(localLong2);
    }
    String str3 = paramFbpVoucherBorrowRecordV.getApplyDateBegin();
    if ((null != str3) && (!"".equals(str3)) && (str3.matches("^\\d{4}-\\d{2}-\\d{2}")))
    {
      localStringBuilder.append(" AND to_char(vbr.applyDate,'yyyy-mm-dd') >= ?");
      localArrayList.add(str3);
    }
    String str4 = paramFbpVoucherBorrowRecordV.getApplyDateEnd();
    if ((null != str4) && (!"".equals(str4)) && (str4.matches("^\\d{4}-\\d{2}-\\d{2}")))
    {
      localStringBuilder.append(" AND to_char(vbr.applyDate,'yyyy-mm-dd') <= ?");
      localArrayList.add(str4);
    }
    String str5 = paramFbpVoucherBorrowRecordV.getArchivesStatus();
    if ((null != str5) && (!"".equals(str5)))
    {
      localStringBuilder.append(" AND vbr.archivesStatus = ? ");
      localArrayList.add(str5);
    }
    localStringBuilder.append(" order by vbr.archivesHeaderId desc ");
    paramInteger1 = Integer.valueOf((paramInteger1.intValue() + paramInteger2.intValue()) / paramInteger2.intValue());
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuilder.toString(), paramInteger1.intValue(), paramInteger2.intValue(), localArrayList.toArray());
    return localPageInfo;
  }
  
  public FbpVoucherBorrowRecordV findVoucherBorrowRecord(Long paramLong)
  {
    String str = "FROM FbpVoucherBorrowRecordV vbr WHERE vbr.archivesHeaderId = ? ";
    FbpVoucherBorrowRecordV localFbpVoucherBorrowRecordV = (FbpVoucherBorrowRecordV)super.find(str, new Object[] { paramLong }).get(0);
    return localFbpVoucherBorrowRecordV;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.archives.FbpVoucherBorrowRecordVDAO
 * JD-Core Version:    0.7.0.1
 */