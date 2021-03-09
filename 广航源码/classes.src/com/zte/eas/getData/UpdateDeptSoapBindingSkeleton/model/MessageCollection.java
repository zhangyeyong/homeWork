package com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.model;

import com.zte.eas.getData.OranizationUnits.model.Message;
import org.apache.commons.lang.builder.ToStringBuilder;

public class MessageCollection
{
  private Message[] messageList;
  
  public String toString()
  {
    return new ToStringBuilder(this).append("messageList", this.messageList).toString();
  }
  
  public Message[] getMessageList()
  {
    return this.messageList;
  }
  
  public void setMessageList(Message[] paramArrayOfMessage)
  {
    this.messageList = paramArrayOfMessage;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.model.MessageCollection
 * JD-Core Version:    0.7.0.1
 */