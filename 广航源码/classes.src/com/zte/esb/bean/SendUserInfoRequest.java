package com.zte.esb.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="SendUserInfoRequest", propOrder={"userInfo"})
public class SendUserInfoRequest
  implements Serializable
{
  private static final long serialVersionUID = 11082011L;
  @XmlElement(required=true)
  protected List<UserInfo> userInfo;
  
  public List<UserInfo> getUserInfo()
  {
    if (this.userInfo == null) {
      this.userInfo = new ArrayList();
    }
    return this.userInfo;
  }
  
  public void setUserInfo(List<UserInfo> paramList)
  {
    this.userInfo = paramList;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.bean.SendUserInfoRequest
 * JD-Core Version:    0.7.0.1
 */