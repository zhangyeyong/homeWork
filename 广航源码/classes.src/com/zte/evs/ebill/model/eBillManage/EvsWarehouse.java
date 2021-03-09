package com.zte.evs.ebill.model.eBillManage;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class EvsWarehouse
  extends BaseObject
  implements Serializable
{
  protected String warehouseCode;
  protected String warehouseName;
  protected String warehouseAddress;
  protected String warehouseMemo;
  protected String warehouseAttribute;
  protected String warehouseResponsible;
  protected String warehouseStatus;
  protected Date creationDate;
  protected Long createdBy;
  protected Date lastUpdateDate;
  protected Long lastUpdateBy;
  protected Long lastUpdateLogin;
  protected BigInteger warehouseId;
  
  public EvsWarehouse() {}
  
  public EvsWarehouse(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, BigInteger paramBigInteger)
  {
    setWarehouseCode(paramString1);
    setWarehouseName(paramString2);
    setWarehouseAddress(paramString3);
    setWarehouseMemo(paramString4);
    setWarehouseAttribute(paramString5);
    setWarehouseResponsible(paramString6);
    setWarehouseStatus(paramString7);
    setCreationDate(paramDate1);
    setCreatedBy(paramLong1);
    setLastUpdateDate(paramDate2);
    setLastUpdateBy(paramLong2);
    setLastUpdateLogin(paramLong3);
    setWarehouseId(paramBigInteger);
  }
  
  public String getWarehouseCode()
  {
    return this.warehouseCode;
  }
  
  public void setWarehouseCode(String paramString)
  {
    this.warehouseCode = paramString;
  }
  
  public String getWarehouseName()
  {
    return this.warehouseName;
  }
  
  public void setWarehouseName(String paramString)
  {
    this.warehouseName = paramString;
  }
  
  public String getWarehouseAddress()
  {
    return this.warehouseAddress;
  }
  
  public void setWarehouseAddress(String paramString)
  {
    this.warehouseAddress = paramString;
  }
  
  public String getWarehouseMemo()
  {
    return this.warehouseMemo;
  }
  
  public void setWarehouseMemo(String paramString)
  {
    this.warehouseMemo = paramString;
  }
  
  public String getWarehouseAttribute()
  {
    return this.warehouseAttribute;
  }
  
  public void setWarehouseAttribute(String paramString)
  {
    this.warehouseAttribute = paramString;
  }
  
  public String getWarehouseResponsible()
  {
    return this.warehouseResponsible;
  }
  
  public void setWarehouseResponsible(String paramString)
  {
    this.warehouseResponsible = paramString;
  }
  
  public String getWarehouseStatus()
  {
    return this.warehouseStatus;
  }
  
  public void setWarehouseStatus(String paramString)
  {
    this.warehouseStatus = paramString;
  }
  
  public Date getCreationDate()
  {
    return this.creationDate;
  }
  
  public void setCreationDate(Date paramDate)
  {
    this.creationDate = paramDate;
  }
  
  public Long getCreatedBy()
  {
    return this.createdBy;
  }
  
  public void setCreatedBy(Long paramLong)
  {
    this.createdBy = paramLong;
  }
  
  public Date getLastUpdateDate()
  {
    return this.lastUpdateDate;
  }
  
  public void setLastUpdateDate(Date paramDate)
  {
    this.lastUpdateDate = paramDate;
  }
  
  public Long getLastUpdateBy()
  {
    return this.lastUpdateBy;
  }
  
  public void setLastUpdateBy(Long paramLong)
  {
    this.lastUpdateBy = paramLong;
  }
  
  public Long getLastUpdateLogin()
  {
    return this.lastUpdateLogin;
  }
  
  public void setLastUpdateLogin(Long paramLong)
  {
    this.lastUpdateLogin = paramLong;
  }
  
  public BigInteger getWarehouseId()
  {
    return this.warehouseId;
  }
  
  public void setWarehouseId(BigInteger paramBigInteger)
  {
    this.warehouseId = paramBigInteger;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof EvsWarehouse)) {
      return false;
    }
    EvsWarehouse localEvsWarehouse = (EvsWarehouse)paramObject;
    return new EqualsBuilder().append(this.warehouseCode, localEvsWarehouse.warehouseCode).append(this.warehouseName, localEvsWarehouse.warehouseName).append(this.warehouseAddress, localEvsWarehouse.warehouseAddress).append(this.warehouseMemo, localEvsWarehouse.warehouseMemo).append(this.warehouseAttribute, localEvsWarehouse.warehouseAttribute).append(this.warehouseResponsible, localEvsWarehouse.warehouseResponsible).append(this.warehouseStatus, localEvsWarehouse.warehouseStatus).append(this.creationDate, localEvsWarehouse.creationDate).append(this.createdBy, localEvsWarehouse.createdBy).append(this.lastUpdateDate, localEvsWarehouse.lastUpdateDate).append(this.lastUpdateBy, localEvsWarehouse.lastUpdateBy).append(this.lastUpdateLogin, localEvsWarehouse.lastUpdateLogin).append(this.warehouseId, localEvsWarehouse.warehouseId).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.warehouseCode).append(this.warehouseName).append(this.warehouseAddress).append(this.warehouseMemo).append(this.warehouseAttribute).append(this.warehouseResponsible).append(this.warehouseStatus).append(this.creationDate).append(this.createdBy).append(this.lastUpdateDate).append(this.lastUpdateBy).append(this.lastUpdateLogin).append(this.warehouseId).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("warehouseCode", this.warehouseCode).append("warehouseName", this.warehouseName).append("warehouseAddress", this.warehouseAddress).append("warehouseMemo", this.warehouseMemo).append("warehouseAttribute", this.warehouseAttribute).append("warehouseResponsible", this.warehouseResponsible).append("warehouseStatus", this.warehouseStatus).append("creationDate", this.creationDate).append("createdBy", this.createdBy).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdateBy", this.lastUpdateBy).append("lastUpdateLogin", this.lastUpdateLogin).append("warehouseId", this.warehouseId).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "warehouseId";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsWarehouse
 * JD-Core Version:    0.7.0.1
 */