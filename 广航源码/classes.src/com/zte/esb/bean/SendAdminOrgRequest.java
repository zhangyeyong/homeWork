package com.zte.esb.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="SendAdminOrgRequest", propOrder={"adminOrgInfo"})
public class SendAdminOrgRequest
  implements Serializable
{
  private static final long serialVersionUID = 11082011L;
  @XmlElement(required=true)
  protected List<AdminOrgInfo> adminOrgInfo;
  
  public void setAdminOrgInfo(List<AdminOrgInfo> paramList)
  {
    this.adminOrgInfo = paramList;
  }
  
  public List<AdminOrgInfo> getAdminOrgInfo()
  {
    if (this.adminOrgInfo == null) {
      this.adminOrgInfo = new ArrayList();
    }
    return this.adminOrgInfo;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.bean.SendAdminOrgRequest
 * JD-Core Version:    0.7.0.1
 */