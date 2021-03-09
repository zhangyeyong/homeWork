package com.zte.eas.appframe.importmis.assetoutcompany;

import javax.xml.rpc.ServiceFactory;
import junit.framework.TestCase;

public class FI_FA_ImportAssetTransferIntercompanysSrv_ServiceTest
  extends TestCase
{
  private FI_FA_ImportAssetTransferIntercompanysSrv_Service myFI_FA_ImportAssetTransferIntercompanysSrv_Service;
  
  public FI_FA_ImportAssetTransferIntercompanysSrv_ServiceTest(String paramString)
  {
    super(paramString);
  }
  
  protected void setUp()
    throws Exception
  {
    ServiceFactory localServiceFactory = ServiceFactory.newInstance();
    this.myFI_FA_ImportAssetTransferIntercompanysSrv_Service = ((FI_FA_ImportAssetTransferIntercompanysSrv_Service)localServiceFactory.loadService(FI_FA_ImportAssetTransferIntercompanysSrv_Service.class));
  }
  
  protected void tearDown()
  {
    this.myFI_FA_ImportAssetTransferIntercompanysSrv_Service = null;
  }
  
  public void testFI_FA_ImportAssetTransferIntercompanysSrvPortprocess()
    throws Exception
  {
    FI_FA_ImportAssetTransferIntercompanysSrv_PortType localFI_FA_ImportAssetTransferIntercompanysSrv_PortType = this.myFI_FA_ImportAssetTransferIntercompanysSrv_Service.getFI_FA_ImportAssetTransferIntercompanysSrvPort();
    FI_FA_ImportAssetTransferIntercompanysSrvProcessRequest localFI_FA_ImportAssetTransferIntercompanysSrvProcessRequest = null;
    localFI_FA_ImportAssetTransferIntercompanysSrv_PortType.process(localFI_FA_ImportAssetTransferIntercompanysSrvProcessRequest);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.assetoutcompany.FI_FA_ImportAssetTransferIntercompanysSrv_ServiceTest
 * JD-Core Version:    0.7.0.1
 */