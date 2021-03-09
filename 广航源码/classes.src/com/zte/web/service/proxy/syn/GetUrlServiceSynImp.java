package com.zte.web.service.proxy.syn;

import com.zte.web.service.client.getUrlServiceSrv.RequestModel;
import com.zte.web.service.client.getUrlServiceSrv.ResponseModel;
import com.zte.web.service.proxy.GetUrlServiceClientImp;
import org.apache.log4j.Logger;

public class GetUrlServiceSynImp
  implements GetUrlServiceSyn
{
  Logger log = Logger.getLogger(getClass());
  
  public ResponseModel GetUrlService(String paramString)
  {
    RequestModel localRequestModel = new RequestModel();
    localRequestModel.setBoeNum(paramString);
    GetUrlServiceClientImp localGetUrlServiceClientImp = new GetUrlServiceClientImp();
    try
    {
      ResponseModel localResponseModel = localGetUrlServiceClientImp.getUrl(localRequestModel);
      if ((localResponseModel.getFile() == null) || (localResponseModel.getFile().length == 0)) {
        return null;
      }
      return localResponseModel;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.log.error(localException.getMessage());
    }
    return null;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.proxy.syn.GetUrlServiceSynImp
 * JD-Core Version:    0.7.0.1
 */