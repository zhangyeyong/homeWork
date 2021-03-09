package com.zte.eas.appframe.importmis.assetadd;

import javax.xml.rpc.ServiceFactory;
import junit.framework.TestCase;

public class FI_FA_ImportAssetMassAddtionSrv_ServiceTest
  extends TestCase
{
  private FI_FA_ImportAssetMassAddtionSrv_Service myFI_FA_ImportAssetMassAddtionSrv_Service;
  
  public FI_FA_ImportAssetMassAddtionSrv_ServiceTest(String paramString)
  {
    super(paramString);
  }
  
  protected void setUp()
    throws Exception
  {
    ServiceFactory localServiceFactory = ServiceFactory.newInstance();
    this.myFI_FA_ImportAssetMassAddtionSrv_Service = ((FI_FA_ImportAssetMassAddtionSrv_Service)localServiceFactory.loadService(FI_FA_ImportAssetMassAddtionSrv_Service.class));
  }
  
  protected void tearDown()
  {
    this.myFI_FA_ImportAssetMassAddtionSrv_Service = null;
  }
  
  public void testFI_FA_ImportAssetMassAddtionSrvPortprocess()
    throws Exception
  {
    FI_FA_ImportAssetMassAddtionSrv_PortType localFI_FA_ImportAssetMassAddtionSrv_PortType = this.myFI_FA_ImportAssetMassAddtionSrv_Service.getFI_FA_ImportAssetMassAddtionSrvPort();
    FI_FA_ImportAssetMassAddtionSrvProcessRequest localFI_FA_ImportAssetMassAddtionSrvProcessRequest = null;
    localFI_FA_ImportAssetMassAddtionSrv_PortType.process(localFI_FA_ImportAssetMassAddtionSrvProcessRequest);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.assetadd.FI_FA_ImportAssetMassAddtionSrv_ServiceTest
 * JD-Core Version:    0.7.0.1
 */