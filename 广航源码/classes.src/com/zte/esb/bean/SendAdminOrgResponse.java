package com.zte.esb.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="SendAdminOrgResponse", propOrder={"successCount", "failedCount", "processResult"})
@XmlRootElement
public class SendAdminOrgResponse
  implements Serializable
{
  private static final long serialVersionUID = 11082011L;
  protected int successCount;
  protected int failedCount;
  @XmlElement(required=true)
  protected List<SendAdminOrgProcessReult> processResult;
  
  public void setProcessResult(List<SendAdminOrgProcessReult> paramList)
  {
    this.processResult = paramList;
  }
  
  public int getSuccessCount()
  {
    return this.successCount;
  }
  
  public void setSuccessCount(int paramInt)
  {
    this.successCount = paramInt;
  }
  
  public int getFailedCount()
  {
    return this.failedCount;
  }
  
  public void setFailedCount(int paramInt)
  {
    this.failedCount = paramInt;
  }
  
  public List<SendAdminOrgProcessReult> getProcessResult()
  {
    if (this.processResult == null) {
      this.processResult = new ArrayList();
    }
    return this.processResult;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.bean.SendAdminOrgResponse
 * JD-Core Version:    0.7.0.1
 */