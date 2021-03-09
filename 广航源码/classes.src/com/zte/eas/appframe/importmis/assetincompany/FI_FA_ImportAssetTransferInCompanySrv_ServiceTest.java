package com.zte.eas.appframe.importmis.assetincompany;

import javax.xml.rpc.ServiceFactory;
import junit.framework.TestCase;

public class FI_FA_ImportAssetTransferInCompanySrv_ServiceTest
  extends TestCase
{
  private FI_FA_ImportAssetTransferInCompanySrv_Service myFI_FA_ImportAssetTransferInCompanySrv_Service;
  
  public FI_FA_ImportAssetTransferInCompanySrv_ServiceTest(String paramString)
  {
    super(paramString);
  }
  
  protected void setUp()
    throws Exception
  {
    ServiceFactory localServiceFactory = ServiceFactory.newInstance();
    this.myFI_FA_ImportAssetTransferInCompanySrv_Service = ((FI_FA_ImportAssetTransferInCompanySrv_Service)localServiceFactory.loadService(FI_FA_ImportAssetTransferInCompanySrv_Service.class));
  }
  
  protected void tearDown()
  {
    this.myFI_FA_ImportAssetTransferInCompanySrv_Service = null;
  }
  
  public void testFI_FA_ImportAssetTransferInCompanySrvPortprocess()
    throws Exception
  {
    FI_FA_ImportAssetTransferInCompanySrv_PortType localFI_FA_ImportAssetTransferInCompanySrv_PortType = this.myFI_FA_ImportAssetTransferInCompanySrv_Service.getFI_FA_ImportAssetTransferInCompanySrvPort();
    FI_FA_ImportAssetTransferInCompanySrvProcessRequest localFI_FA_ImportAssetTransferInCompanySrvProcessRequest = null;
    localFI_FA_ImportAssetTransferInCompanySrv_PortType.process(localFI_FA_ImportAssetTransferInCompanySrvProcessRequest);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.assetincompany.FI_FA_ImportAssetTransferInCompanySrv_ServiceTest
 * JD-Core Version:    0.7.0.1
 */