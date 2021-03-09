package com.zte.esb.client;

import com.zte.eimage.business.baseconfig.service.IEidImageInfosDS;
import com.zte.esb.bean.fssc.EisGetResponse;
import com.zte.esb.trans.EisGetResponseTrans;
import com.zte.esb.util.ExceptionUtil;
import com.zte.esb.util.StatusUtils;
import com.zte.ssb.framework.SSBBus;
import com.zte.web.service.client.createImage.ds.CreateImageSrv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.jms.Message;
import javax.jms.TextMessage;

public class FsscNewImageResponseListener
{
  public void onMessage(Message paramMessage)
  {
    TextMessage localTextMessage = (TextMessage)paramMessage;
    StatusUtils.send(paramMessage, "ST_502");
    String str1 = null;
    EisGetResponse localEisGetResponse = null;
    try
    {
      str1 = localTextMessage.getText();
      Object localObject1;
      if (paramMessage.getIntProperty("resultCode") == 0) {
        localObject1 = ExceptionUtil.toMessage(str1);
      }
      if (paramMessage.getIntProperty("resultCode") == 1)
      {
        localEisGetResponse = EisGetResponseTrans.toMessage(str1);
        StatusUtils.send(paramMessage, "ST_505");
        if (localEisGetResponse != null)
        {
          localObject1 = new CreateImageSrv();
          HashMap localHashMap = new HashMap();
          String str2 = localEisGetResponse.getSuccessMark().booleanValue() ? "Y" : "N";
          if (!localEisGetResponse.getSuccessMark().booleanValue())
          {
            localObject2 = localEisGetResponse.getFailtureReason();
            if (localObject2 != null)
            {
              Object localObject3 = ((String)localObject2).length() > 3 ? ((String)localObject2).substring(0, 3) : null;
              if ("111".equals(localObject3))
              {
                IEidImageInfosDS localIEidImageInfosDS = (IEidImageInfosDS)SSBBus.findDomainService("imageInfosDS");
                localIEidImageInfosDS.updateImageInfoReject(localEisGetResponse.getClaimBillNumber(), ((String)localObject2).substring(3));
              }
            }
          }
          Object localObject2 = new ArrayList();
          ((List)localObject2).add(localEisGetResponse.getClaimBillNumber());
          localHashMap.put(str2, localObject2);
          ((CreateImageSrv)localObject1).updateFlag(localHashMap);
        }
        StatusUtils.send(paramMessage, "ST_999");
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.client.FsscNewImageResponseListener
 * JD-Core Version:    0.7.0.1
 */