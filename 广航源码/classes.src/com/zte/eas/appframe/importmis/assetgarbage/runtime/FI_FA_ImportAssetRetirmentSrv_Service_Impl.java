package com.zte.eas.appframe.importmis.assetgarbage.runtime;

import com.zte.eas.appframe.importmis.assetgarbage.FI_FA_ImportAssetRetirmentSrv_PortType;
import com.zte.eas.appframe.importmis.assetgarbage.FI_FA_ImportAssetRetirmentSrv_Service;
import java.rmi.Remote;
import javax.xml.namespace.QName;
import javax.xml.rpc.JAXRPCException;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.handler.HandlerRegistry;
import oracle.j2ee.ws.client.BasicService;
import oracle.j2ee.ws.client.HandlerChainImpl;
import oracle.j2ee.ws.client.ServiceExceptionImpl;
import oracle.j2ee.ws.common.util.exception.LocalizableExceptionAdapter;

public class FI_FA_ImportAssetRetirmentSrv_Service_Impl
  extends BasicService
  implements FI_FA_ImportAssetRetirmentSrv_Service
{
  private static final QName serviceName = new QName("http://eas.zte.com.cn/all/FI_FA_ImportAssetRetirmentSrv", "FI_FA_ImportAssetRetirmentSrv");
  private static final QName ns1_FI_FA_ImportAssetRetirmentSrvPort_QNAME = new QName("http://eas.zte.com.cn/all/FI_FA_ImportAssetRetirmentSrv", "FI_FA_ImportAssetRetirmentSrvPort");
  private static final Class FI_FA_ImportAssetRetirmentSrv_PortType_PortClass = FI_FA_ImportAssetRetirmentSrv_PortType.class;
  
  public FI_FA_ImportAssetRetirmentSrv_Service_Impl()
  {
    super(serviceName, new QName[] { ns1_FI_FA_ImportAssetRetirmentSrvPort_QNAME }, new FI_FA_ImportAssetRetirmentSrv_Service_SerializerRegistry().getRegistry());
  }
  
  public Remote getPort(QName paramQName, Class paramClass)
    throws ServiceException
  {
    try
    {
      if ((paramQName.equals(ns1_FI_FA_ImportAssetRetirmentSrvPort_QNAME)) && (paramClass.equals(FI_FA_ImportAssetRetirmentSrv_PortType_PortClass))) {
        return getFI_FA_ImportAssetRetirmentSrvPort();
      }
    }
    catch (Exception localException)
    {
      throw new ServiceExceptionImpl(new LocalizableExceptionAdapter(localException));
    }
    return super.getPort(paramQName, paramClass);
  }
  
  public Remote getPort(Class paramClass)
    throws ServiceException
  {
    try
    {
      if (paramClass.equals(FI_FA_ImportAssetRetirmentSrv_PortType_PortClass)) {
        return getFI_FA_ImportAssetRetirmentSrvPort();
      }
    }
    catch (Exception localException)
    {
      throw new ServiceExceptionImpl(new LocalizableExceptionAdapter(localException));
    }
    return super.getPort(paramClass);
  }
  
  public FI_FA_ImportAssetRetirmentSrv_PortType getFI_FA_ImportAssetRetirmentSrvPort()
  {
    String[] arrayOfString = new String[0];
    HandlerChainImpl localHandlerChainImpl = new HandlerChainImpl(getHandlerRegistry().getHandlerChain(ns1_FI_FA_ImportAssetRetirmentSrvPort_QNAME));
    localHandlerChainImpl.setRoles(arrayOfString);
    FI_FA_ImportAssetRetirmentSrvBinding_Stub localFI_FA_ImportAssetRetirmentSrvBinding_Stub = new FI_FA_ImportAssetRetirmentSrvBinding_Stub(localHandlerChainImpl);
    try
    {
      localFI_FA_ImportAssetRetirmentSrvBinding_Stub._initialize(this.internalTypeRegistry);
    }
    catch (JAXRPCException localJAXRPCException)
    {
      throw localJAXRPCException;
    }
    catch (Exception localException)
    {
      throw new JAXRPCException(localException.getMessage(), localException);
    }
    return localFI_FA_ImportAssetRetirmentSrvBinding_Stub;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.assetgarbage.runtime.FI_FA_ImportAssetRetirmentSrv_Service_Impl
 * JD-Core Version:    0.7.0.1
 */