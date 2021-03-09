package com.zte.esb.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="SendRoleInfoRequest", propOrder={"roleInfo"})
public class SendRoleInfoRequest
  implements Serializable
{
  private static final long serialVersionUID = 11082011L;
  @XmlElement(required=true)
  protected List<RoleInfo> roleInfo;
  
  public List<RoleInfo> getRoleInfo()
  {
    if (this.roleInfo == null) {
      this.roleInfo = new ArrayList();
    }
    return this.roleInfo;
  }
  
  public void setRoleInfo(List<RoleInfo> paramList)
  {
    this.roleInfo = paramList;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.bean.SendRoleInfoRequest
 * JD-Core Version:    0.7.0.1
 */