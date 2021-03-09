package com.zte.web.service.proxy;

import com.zte.web.service.client.getUrlServiceSrv.FileModel;
import com.zte.web.service.client.getUrlServiceSrv.GetFileAndContractUrlDS;
import com.zte.web.service.client.getUrlServiceSrv.GetFileAndContractUrlDSServiceLocator;
import com.zte.web.service.client.getUrlServiceSrv.RequestModel;
import com.zte.web.service.client.getUrlServiceSrv.ResponseModel;
import com.zte.web.service.common.SevCommonLog;
import java.rmi.RemoteException;
import javax.xml.rpc.ServiceException;
import org.apache.log4j.Logger;

public class GetUrlServiceClientImp
  implements GetUrlServiceClient
{
  private Logger log = Logger.getLogger(getClass());
  private SevCommonLog cLog = new SevCommonLog();
  
  public ResponseModel getUrl(RequestModel paramRequestModel)
    throws ServiceException, RemoteException
  {
    this.log.error("------------------查询单据附件 开始-----------------------");
    try
    {
      this.cLog.log(paramRequestModel);
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
      this.log.error(localException1);
    }
    ResponseModel localResponseModel = null;
    GetFileAndContractUrlDSServiceLocator localGetFileAndContractUrlDSServiceLocator = new GetFileAndContractUrlDSServiceLocator();
    GetFileAndContractUrlDS localGetFileAndContractUrlDS = localGetFileAndContractUrlDSServiceLocator.getGetUrlService();
    localResponseModel = localGetFileAndContractUrlDS.getUrl(paramRequestModel);
    try
    {
      this.cLog.log(localResponseModel);
      for (FileModel localFileModel : localResponseModel.getFile())
      {
        this.cLog.log(localFileModel);
        this.cLog.log(localFileModel.getACCESSORY_NAME());
      }
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
      this.log.error(localException2);
    }
    this.log.error("------------------查询单据附件 结束-----------------------");
    return localResponseModel;
  }
  
  public SevCommonLog getSevCommonLog()
  {
    return this.cLog;
  }
  
  public void setSevCommonLog(SevCommonLog paramSevCommonLog)
  {
    this.cLog = paramSevCommonLog;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.proxy.GetUrlServiceClientImp
 * JD-Core Version:    0.7.0.1
 */