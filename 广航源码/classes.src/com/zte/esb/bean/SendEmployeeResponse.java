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
@XmlType(name="SendEmployeeResponse", propOrder={"successCount", "failedCount", "processResult"})
@XmlRootElement
public class SendEmployeeResponse
  implements Serializable
{
  private static final long serialVersionUID = 11082011L;
  protected int successCount;
  protected int failedCount;
  @XmlElement(required=true)
  protected List<SendEmployeeProcessReult> processResult;
  
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
  
  public List<SendEmployeeProcessReult> getProcessResult()
  {
    if (this.processResult == null) {
      this.processResult = new ArrayList();
    }
    return this.processResult;
  }
  
  public void setProcessResult(List<SendEmployeeProcessReult> paramList)
  {
    this.processResult = paramList;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.bean.SendEmployeeResponse
 * JD-Core Version:    0.7.0.1
 */