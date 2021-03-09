package com.zte.eas.appframe.importmis.ap;

import java.util.Calendar;

public class ApClient
{
  public static String runApClient(String paramString, Calendar paramCalendar)
  {
    String str = "SUCCESS";
    try
    {
      AP_ImportApInvoiceSrvPortClient localAP_ImportApInvoiceSrvPortClient = new AP_ImportApInvoiceSrvPortClient();
      AP_ImportApInvoiceSrvProcessRequest localAP_ImportApInvoiceSrvProcessRequest = new AP_ImportApInvoiceSrvProcessRequest();
      localAP_ImportApInvoiceSrvProcessRequest.setBoeHeaderId(paramString);
      localAP_ImportApInvoiceSrvProcessRequest.setInvoiceData(paramCalendar);
      localAP_ImportApInvoiceSrvPortClient.process(localAP_ImportApInvoiceSrvProcessRequest);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      str = "FAILED";
    }
    return str;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.ap.ApClient
 * JD-Core Version:    0.7.0.1
 */