package com.zte.eas.flowruleengine.business.posstru.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpPseRelationsV
  extends BaseObject
  implements Serializable
{
  protected Long pseRelationId;
  protected String posStructureCode;
  protected Long companyId;
  protected Long operationTypeId;
  protected Long employeeId;
  
  public FbpPseRelationsV() {}
  
  public FbpPseRelationsV(Long paramLong1, String paramString, Long paramLong2, Long paramLong3, Long paramLong4)
  {
    setPseRelationId(paramLong1);
    setPosStructureCode(paramString);
    setCompanyId(paramLong2);
    setOperationTypeId(paramLong3);
    setEmployeeId(paramLong4);
  }
  
  public Long getPseRelationId()
  {
    return this.pseRelationId;
  }
  
  public void setPseRelationId(Long paramLong)
  {
    this.pseRelationId = paramLong;
  }
  
  public String getPosStructureCode()
  {
    return this.posStructureCode;
  }
  
  public void setPosStructureCode(String paramString)
  {
    this.posStructureCode = paramString;
  }
  
  public Long getCompanyId()
  {
    return this.companyId;
  }
  
  public void setCompanyId(Long paramLong)
  {
    this.companyId = paramLong;
  }
  
  public Long getOperationTypeId()
  {
    return this.operationTypeId;
  }
  
  public void setOperationTypeId(Long paramLong)
  {
    this.operationTypeId = paramLong;
  }
  
  public Long getEmployeeId()
  {
    return this.employeeId;
  }
  
  public void setEmployeeId(Long paramLong)
  {
    this.employeeId = paramLong;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FbpPseRelationsV)) {
      return false;
    }
    FbpPseRelationsV localFbpPseRelationsV = (FbpPseRelationsV)paramObject;
    return new EqualsBuilder().append(this.pseRelationId, localFbpPseRelationsV.pseRelationId).append(this.posStructureCode, localFbpPseRelationsV.posStructureCode).append(this.companyId, localFbpPseRelationsV.companyId).append(this.operationTypeId, localFbpPseRelationsV.operationTypeId).append(this.employeeId, localFbpPseRelationsV.employeeId).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.pseRelationId).append(this.posStructureCode).append(this.companyId).append(this.operationTypeId).append(this.employeeId).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("pseRelationId", this.pseRelationId).append("posStructureCode", this.posStructureCode).append("companyId", this.companyId).append("operationTypeId", this.operationTypeId).append("employeeId", this.employeeId).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.flowruleengine.business.posstru.model.FbpPseRelationsV
 * JD-Core Version:    0.7.0.1
 */