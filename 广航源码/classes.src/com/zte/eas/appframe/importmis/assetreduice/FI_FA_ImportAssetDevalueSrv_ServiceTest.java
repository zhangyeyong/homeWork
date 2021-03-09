package com.zte.eas.appframe.importmis.assetreduice;

import javax.xml.rpc.ServiceFactory;
import junit.framework.TestCase;

public class FI_FA_ImportAssetDevalueSrv_ServiceTest
  extends TestCase
{
  private FI_FA_ImportAssetDevalueSrv_Service myFI_FA_ImportAssetDevalueSrv_Service;
  
  public FI_FA_ImportAssetDevalueSrv_ServiceTest(String paramString)
  {
    super(paramString);
  }
  
  protected void setUp()
    throws Exception
  {
    ServiceFactory localServiceFactory = ServiceFactory.newInstance();
    this.myFI_FA_ImportAssetDevalueSrv_Service = ((FI_FA_ImportAssetDevalueSrv_Service)localServiceFactory.loadService(FI_FA_ImportAssetDevalueSrv_Service.class));
  }
  
  protected void tearDown()
  {
    this.myFI_FA_ImportAssetDevalueSrv_Service = null;
  }
  
  public void testFI_FA_ImportAssetDevalueSrvPortprocess()
    throws Exception
  {
    FI_FA_ImportAssetDevalueSrv_PortType localFI_FA_ImportAssetDevalueSrv_PortType = this.myFI_FA_ImportAssetDevalueSrv_Service.getFI_FA_ImportAssetDevalueSrvPort();
    FI_FA_ImportAssetDevalueSrvProcessRequest localFI_FA_ImportAssetDevalueSrvProcessRequest = null;
    localFI_FA_ImportAssetDevalueSrv_PortType.process(localFI_FA_ImportAssetDevalueSrvProcessRequest);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.assetreduice.FI_FA_ImportAssetDevalueSrv_ServiceTest
 * JD-Core Version:    0.7.0.1
 */