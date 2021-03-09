package com.zte.esb.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="SendFinancialOrgRequest", propOrder={"financialOrgInfo"})
public class SendFinancialOrgRequest
  implements Serializable
{
  private static final long serialVersionUID = 11082011L;
  @XmlElement(required=true)
  protected List<FinancialOrgInfo> financialOrgInfo;
  
  public List<FinancialOrgInfo> getFinancialOrgInfo()
  {
    if (this.financialOrgInfo == null) {
      this.financialOrgInfo = new ArrayList();
    }
    return this.financialOrgInfo;
  }
  
  public void setFinancialOrgInfo(List<FinancialOrgInfo> paramList)
  {
    this.financialOrgInfo = paramList;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.bean.SendFinancialOrgRequest
 * JD-Core Version:    0.7.0.1
 */