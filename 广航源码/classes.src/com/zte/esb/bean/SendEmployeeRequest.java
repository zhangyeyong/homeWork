package com.zte.esb.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="SendEmployeeRequest", propOrder={"employeeInfo"})
public class SendEmployeeRequest
  implements Serializable
{
  private static final long serialVersionUID = 11082011L;
  @XmlElement(required=true)
  protected List<EmployeeInfo> employeeInfo;
  
  public List<EmployeeInfo> getEmployeeInfo()
  {
    if (this.employeeInfo == null) {
      this.employeeInfo = new ArrayList();
    }
    return this.employeeInfo;
  }
  
  public void setEmployeeInfo(List<EmployeeInfo> paramList)
  {
    this.employeeInfo = paramList;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.bean.SendEmployeeRequest
 * JD-Core Version:    0.7.0.1
 */