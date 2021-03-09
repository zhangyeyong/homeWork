package com.zte.eas.report.business.print.service;

import com.zte.eas.report.business.print.model.PurchaseOrderPrintModel;
import com.zte.evs.ebill.business.archives.IFbpArchivesHeadersDS;
import com.zte.evs.ebill.business.archives.IFbpArchivesLinesDS;
import com.zte.evs.ebill.model.archives.FbpArchivesHeadersV;
import com.zte.evs.ebill.model.archives.FbpArchivesLinesV;
import com.zte.ssb.framework.SSBBus;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AchervsPrintService
  implements IFinancePrintService
{
  public Object getFinancePrintModel(String paramString, List paramList)
  {
    PurchaseOrderPrintModel localPurchaseOrderPrintModel = new PurchaseOrderPrintModel(paramString);
    Date localDate = new Date();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String str = localSimpleDateFormat.format(localDate);
    localPurchaseOrderPrintModel.setCurrentDate(str);
    FbpArchivesHeadersV localFbpArchivesHeadersV = new FbpArchivesHeadersV();
    DecimalFormat localDecimalFormat = new DecimalFormat();
    localDecimalFormat.applyPattern("#,##0.00");
    try
    {
      IFbpArchivesHeadersDS localIFbpArchivesHeadersDS = (IFbpArchivesHeadersDS)SSBBus.findDomainService("fbpArchivesHeadersDS");
      localFbpArchivesHeadersV = localIFbpArchivesHeadersDS.findFbpArchivesHeadersV(Long.valueOf(Long.parseLong(paramString)));
      if (localFbpArchivesHeadersV != null)
      {
        if (null != localFbpArchivesHeadersV.getArchivesHeaderId()) {
          localPurchaseOrderPrintModel.setBoeHeaderId(localFbpArchivesHeadersV.getArchivesHeaderId().toString());
        }
        if (null != localFbpArchivesHeadersV.getEmployeeId()) {
          localPurchaseOrderPrintModel.setEmployeeId(localFbpArchivesHeadersV.getEmployeeId().toString());
        }
        localPurchaseOrderPrintModel.setEmployeeName(localFbpArchivesHeadersV.getEmployeeId().toString());
        if (null != localFbpArchivesHeadersV.getCreationDate()) {
          localPurchaseOrderPrintModel.setCreationDate(localSimpleDateFormat.format(localFbpArchivesHeadersV.getCreationDate()));
        }
        localPurchaseOrderPrintModel.setCheckUnit(localFbpArchivesHeadersV.getCheckUnit());
        localPurchaseOrderPrintModel.setCheckUnitName(localFbpArchivesHeadersV.getCheckUnit());
        localPurchaseOrderPrintModel.setMobilePhone(localFbpArchivesHeadersV.getMobilePhone());
      }
      IFbpArchivesLinesDS localIFbpArchivesLinesDS = (IFbpArchivesLinesDS)SSBBus.findDomainService("fbpArchivesLinesDS");
      List localList = localIFbpArchivesLinesDS.findFbpArchivesLinessV(Long.valueOf(Long.parseLong(paramString)));
      StringBuffer localStringBuffer = new StringBuffer();
      int i = 1;
      float f1 = 0.0F;
      float f2 = 0.0F;
      float f3 = 0.0F;
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext()) {
        FbpArchivesLinesV localFbpArchivesLinesV = (FbpArchivesLinesV)localIterator.next();
      }
      localPurchaseOrderPrintModel.setBoeLineTable(localStringBuffer.toString());
      localPurchaseOrderPrintModel.setNumberAttribute1Sum(localDecimalFormat.format(f1));
      localPurchaseOrderPrintModel.setNumberAttribute2Sum(localDecimalFormat.format(f2));
      localPurchaseOrderPrintModel.setExpenseAmountSum(localDecimalFormat.format(f3));
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localPurchaseOrderPrintModel;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.report.business.print.service.AchervsPrintService
 * JD-Core Version:    0.7.0.1
 */