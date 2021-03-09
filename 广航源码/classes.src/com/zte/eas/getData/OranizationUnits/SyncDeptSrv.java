package com.zte.eas.getData.OranizationUnits;

import com.zte.eas.getData.OranizationUnits.model.Message;
import com.zte.eas.getData.OranizationUnits.model.OrganizationUnits;

public class SyncDeptSrv
{
  public Message[] syncDepts(OrganizationUnits[] paramArrayOfOrganizationUnits)
  {
    Message[] arrayOfMessage = new Message[1];
    Message localMessage = new Message();
    localMessage.setErrInfos("输入不能为空");
    arrayOfMessage[0] = localMessage;
    return arrayOfMessage;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.getData.OranizationUnits.SyncDeptSrv
 * JD-Core Version:    0.7.0.1
 */