package com.zte.evs.ebill.model.eBillManage;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class EvsManageOrgV
  extends BaseObject
  implements Serializable
{
  private String codeId;
  protected Long employeeId;
  protected String employeeNumber;
  private Long posStruElementId;
  private Long parentPosStruElementId;
  
  public Long getPosStruElementId()
  {
    return this.posStruElementId;
  }
  
  public void setPosStruElementId(Long paramLong)
  {
    this.posStruElementId = paramLong;
  }
  
  public Long getParentPosStruElementId()
  {
    return this.parentPosStruElementId;
  }
  
  public void setParentPosStruElementId(Long paramLong)
  {
    this.parentPosStruElementId = paramLong;
  }
  
  public EvsManageOrgV() {}
  
  public EvsManageOrgV(Long paramLong, String paramString)
  {
    setEmployeeId(paramLong);
    setEmployeeNumber(paramString);
  }
  
  public Long getEmployeeId()
  {
    return this.employeeId;
  }
  
  public void setEmployeeId(Long paramLong)
  {
    this.employeeId = paramLong;
  }
  
  public String getEmployeeNumber()
  {
    return this.employeeNumber;
  }
  
  public void setEmployeeNumber(String paramString)
  {
    this.employeeNumber = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof EvsManageOrgV)) {
      return false;
    }
    EvsManageOrgV localEvsManageOrgV = (EvsManageOrgV)paramObject;
    return new EqualsBuilder().append(this.employeeId, localEvsManageOrgV.employeeId).append(this.employeeNumber, localEvsManageOrgV.employeeNumber).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.employeeId).append(this.employeeNumber).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("employeeId", this.employeeId).append("employeeNumber", this.employeeNumber).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
  
  public String getCodeId()
  {
    return this.codeId;
  }
  
  public void setCodeId(String paramString)
  {
    this.codeId = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsManageOrgV
 * JD-Core Version:    0.7.0.1
 */