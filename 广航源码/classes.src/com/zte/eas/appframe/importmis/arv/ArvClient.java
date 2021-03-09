package com.zte.eas.appframe.importmis.arv;

import com.zte.eas.appframe.importmis.arv.types.com.zte.eas.arimport.fiarimportartransactionsrv.FiArImportARTransactionSrvRequest;
import java.io.PrintStream;
import java.util.Calendar;
import java.util.Date;

public class ArvClient
{
  public static String processArv(String paramString, Date paramDate)
  {
    try
    {
      FI_AR_ImportARTransactionSrvPortClient localFI_AR_ImportARTransactionSrvPortClient = new FI_AR_ImportARTransactionSrvPortClient();
      System.out.println("calling " + localFI_AR_ImportARTransactionSrvPortClient.getEndpoint());
      FiArImportARTransactionSrvRequest localFiArImportARTransactionSrvRequest = new FiArImportARTransactionSrvRequest();
      localFiArImportARTransactionSrvRequest.setBoeHeaders(paramString);
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTime(new Date());
      localFiArImportARTransactionSrvRequest.setImportDate(localCalendar);
      localFI_AR_ImportARTransactionSrvPortClient.process(localFiArImportARTransactionSrvRequest);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "success";
  }
  
  public static void main(String[] paramArrayOfString)
  {
    processArv("10000", null);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.arv.ArvClient
 * JD-Core Version:    0.7.0.1
 */