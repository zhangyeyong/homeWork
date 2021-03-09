package com.zte.eimage.business.baseconfig.model;

import java.io.Serializable;

public class FbpEmpCompanyOperaV
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected Long pseRelationId;
  protected Long employeeId;
  protected String employeeNumber;
  protected Long companyId;
  protected String companyCode;
  protected String companyName;
  protected Long operationTypeId;
  protected String operationTypeCode;
  protected String operationTypeName;
  
  public FbpEmpCompanyOperaV() {}
  
  public FbpEmpCompanyOperaV(Long paramLong1, Long paramLong2, String paramString1, Long paramLong3, String paramString2, String paramString3, Long paramLong4, String paramString4, String paramString5)
  {
    setPseRelationId(paramLong1);
    setEmployeeId(paramLong2);
    setEmployeeNumber(paramString1);
    setCompanyId(paramLong3);
    setCompanyCode(paramString2);
    setCompanyName(paramString3);
    setOperationTypeId(paramLong4);
    setOperationTypeCode(paramString4);
    setOperationTypeName(paramString5);
  }
  
  public Long getPseRelationId()
  {
    return this.pseRelationId;
  }
  
  public void setPseRelationId(Long paramLong)
  {
    this.pseRelationId = paramLong;
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
  
  public Long getCompanyId()
  {
    return this.companyId;
  }
  
  public void setCompanyId(Long paramLong)
  {
    this.companyId = paramLong;
  }
  
  public String getCompanyCode()
  {
    return this.companyCode;
  }
  
  public void setCompanyCode(String paramString)
  {
    this.companyCode = paramString;
  }
  
  public String getCompanyName()
  {
    return this.companyName;
  }
  
  public void setCompanyName(String paramString)
  {
    this.companyName = paramString;
  }
  
  public Long getOperationTypeId()
  {
    return this.operationTypeId;
  }
  
  public void setOperationTypeId(Long paramLong)
  {
    this.operationTypeId = paramLong;
  }
  
  public String getOperationTypeCode()
  {
    return this.operationTypeCode;
  }
  
  public void setOperationTypeCode(String paramString)
  {
    this.operationTypeCode = paramString;
  }
  
  public String getOperationTypeName()
  {
    return this.operationTypeName;
  }
  
  public void setOperationTypeName(String paramString)
  {
    this.operationTypeName = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.model.FbpEmpCompanyOperaV
 * JD-Core Version:    0.7.0.1
 */