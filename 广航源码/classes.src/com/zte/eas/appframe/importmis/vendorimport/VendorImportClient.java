package com.zte.eas.appframe.importmis.vendorimport;

public class VendorImportClient
{
  public static String runVendorImportClient(String paramString)
  {
    String str = "SUCCESS";
    try
    {
      SC_PO_ImportVendorInfoSrvPortClient localSC_PO_ImportVendorInfoSrvPortClient = new SC_PO_ImportVendorInfoSrvPortClient();
      SC_PO_ImportVendorInfoSrvProcessRequest localSC_PO_ImportVendorInfoSrvProcessRequest = new SC_PO_ImportVendorInfoSrvProcessRequest();
      localSC_PO_ImportVendorInfoSrvProcessRequest.setBoeLineId(paramString);
      localSC_PO_ImportVendorInfoSrvPortClient.process(localSC_PO_ImportVendorInfoSrvProcessRequest);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      str = "FAIL";
    }
    return str;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.vendorimport.VendorImportClient
 * JD-Core Version:    0.7.0.1
 */