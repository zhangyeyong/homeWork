package com.zte.eas.appframe.importmis.assetgarbage;

import javax.xml.rpc.ServiceFactory;
import junit.framework.TestCase;

public class FI_FA_ImportAssetRetirmentSrv_ServiceTest
  extends TestCase
{
  private FI_FA_ImportAssetRetirmentSrv_Service myFI_FA_ImportAssetRetirmentSrv_Service;
  
  public FI_FA_ImportAssetRetirmentSrv_ServiceTest(String paramString)
  {
    super(paramString);
  }
  
  protected void setUp()
    throws Exception
  {
    ServiceFactory localServiceFactory = ServiceFactory.newInstance();
    this.myFI_FA_ImportAssetRetirmentSrv_Service = ((FI_FA_ImportAssetRetirmentSrv_Service)localServiceFactory.loadService(FI_FA_ImportAssetRetirmentSrv_Service.class));
  }
  
  protected void tearDown()
  {
    this.myFI_FA_ImportAssetRetirmentSrv_Service = null;
  }
  
  public void testFI_FA_ImportAssetRetirmentSrvPortprocess()
    throws Exception
  {
    FI_FA_ImportAssetRetirmentSrv_PortType localFI_FA_ImportAssetRetirmentSrv_PortType = this.myFI_FA_ImportAssetRetirmentSrv_Service.getFI_FA_ImportAssetRetirmentSrvPort();
    FI_FA_ImportAssetRetirmentSrvProcessRequest localFI_FA_ImportAssetRetirmentSrvProcessRequest = null;
    localFI_FA_ImportAssetRetirmentSrv_PortType.process(localFI_FA_ImportAssetRetirmentSrvProcessRequest);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.assetgarbage.FI_FA_ImportAssetRetirmentSrv_ServiceTest
 * JD-Core Version:    0.7.0.1
 */