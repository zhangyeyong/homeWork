package com.zte.eas.appframe.importmis.arr;

import com.zte.eas.appframe.importmis.arr.types.com.zte.eas.arimport.fiarimportarreciptssrv.FiArImportARReciptsSrvRequest;
import java.util.Calendar;
import java.util.Date;

public class ArrClient
{
  public static String processArr(String paramString, Date paramDate)
  {
    try
    {
      FI_AR_ImportARReciptsSrvPortClient localFI_AR_ImportARReciptsSrvPortClient = new FI_AR_ImportARReciptsSrvPortClient();
      FiArImportARReciptsSrvRequest localFiArImportARReciptsSrvRequest = new FiArImportARReciptsSrvRequest();
      localFiArImportARReciptsSrvRequest.setBoeHeaders(paramString);
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTime(new Date());
      localFiArImportARReciptsSrvRequest.setImportDate(localCalendar);
      localFI_AR_ImportARReciptsSrvPortClient.process(localFiArImportARReciptsSrvRequest);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "success";
  }
  
  public static void main(String[] paramArrayOfString)
  {
    processArr("100026", null);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.arr.ArrClient
 * JD-Core Version:    0.7.0.1
 */