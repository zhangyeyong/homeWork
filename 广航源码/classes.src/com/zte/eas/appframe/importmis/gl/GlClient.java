package com.zte.eas.appframe.importmis.gl;

import java.util.Calendar;

public class GlClient
{
  public static String runGlClient(String paramString, Calendar paramCalendar)
  {
    String str = "sucess";
    try
    {
      GL_ImportGLInvoiceSrvPortClient localGL_ImportGLInvoiceSrvPortClient = new GL_ImportGLInvoiceSrvPortClient();
      GL_ImportGLInvoiceSrvProcessRequest localGL_ImportGLInvoiceSrvProcessRequest = new GL_ImportGLInvoiceSrvProcessRequest();
      localGL_ImportGLInvoiceSrvProcessRequest.setInvoiceId(paramString);
      localGL_ImportGLInvoiceSrvProcessRequest.setInvoicedate(paramCalendar);
      localGL_ImportGLInvoiceSrvPortClient.process(localGL_ImportGLInvoiceSrvProcessRequest);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      str = "failed";
    }
    return str;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.gl.GlClient
 * JD-Core Version:    0.7.0.1
 */