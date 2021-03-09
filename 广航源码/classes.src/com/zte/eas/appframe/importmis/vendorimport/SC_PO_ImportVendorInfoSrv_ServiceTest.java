package com.zte.eas.appframe.importmis.vendorimport;

import javax.xml.rpc.ServiceFactory;
import junit.framework.TestCase;

public class SC_PO_ImportVendorInfoSrv_ServiceTest
  extends TestCase
{
  private SC_PO_ImportVendorInfoSrv_Service mySC_PO_ImportVendorInfoSrv_Service;
  
  public SC_PO_ImportVendorInfoSrv_ServiceTest(String paramString)
  {
    super(paramString);
  }
  
  protected void setUp()
    throws Exception
  {
    ServiceFactory localServiceFactory = ServiceFactory.newInstance();
    this.mySC_PO_ImportVendorInfoSrv_Service = ((SC_PO_ImportVendorInfoSrv_Service)localServiceFactory.loadService(SC_PO_ImportVendorInfoSrv_Service.class));
  }
  
  protected void tearDown()
  {
    this.mySC_PO_ImportVendorInfoSrv_Service = null;
  }
  
  public void testSC_PO_ImportVendorInfoSrvPortprocess()
    throws Exception
  {
    SC_PO_ImportVendorInfoSrv_PortType localSC_PO_ImportVendorInfoSrv_PortType = this.mySC_PO_ImportVendorInfoSrv_Service.getSC_PO_ImportVendorInfoSrvPort();
    SC_PO_ImportVendorInfoSrvProcessRequest localSC_PO_ImportVendorInfoSrvProcessRequest = null;
    localSC_PO_ImportVendorInfoSrv_PortType.process(localSC_PO_ImportVendorInfoSrvProcessRequest);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.vendorimport.SC_PO_ImportVendorInfoSrv_ServiceTest
 * JD-Core Version:    0.7.0.1
 */