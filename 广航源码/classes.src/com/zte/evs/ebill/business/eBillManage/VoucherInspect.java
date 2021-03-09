package com.zte.evs.ebill.business.eBillManage;

import java.io.Serializable;

public class VoucherInspect
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String companyCode;
  private String companyName;
  private String a1;
  private String a2;
  private String a3;
  private String a4;
  private String a5;
  private String a6;
  private String a7;
  private String a8;
  private String a9;
  private String COUNTS;
  
  public VoucherInspect(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12)
  {
    this.companyCode = paramString1;
    this.companyName = paramString2;
    this.a1 = paramString3;
    this.a2 = paramString4;
    this.a3 = paramString5;
    this.a4 = paramString6;
    this.a5 = paramString7;
    this.a6 = paramString8;
    this.a7 = paramString9;
    this.a8 = paramString10;
    this.a9 = paramString11;
    this.COUNTS = paramString12;
  }
  
  public VoucherInspect() {}
  
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
  
  public String getA1()
  {
    return this.a1;
  }
  
  public void setA1(String paramString)
  {
    this.a1 = paramString;
  }
  
  public String getA2()
  {
    return this.a2;
  }
  
  public void setA2(String paramString)
  {
    this.a2 = paramString;
  }
  
  public String getA3()
  {
    return this.a3;
  }
  
  public void setA3(String paramString)
  {
    this.a3 = paramString;
  }
  
  public String getA4()
  {
    return this.a4;
  }
  
  public void setA4(String paramString)
  {
    this.a4 = paramString;
  }
  
  public String getA5()
  {
    return this.a5;
  }
  
  public void setA5(String paramString)
  {
    this.a5 = paramString;
  }
  
  public String getA6()
  {
    return this.a6;
  }
  
  public void setA6(String paramString)
  {
    this.a6 = paramString;
  }
  
  public String getA7()
  {
    return this.a7;
  }
  
  public void setA7(String paramString)
  {
    this.a7 = paramString;
  }
  
  public String getA8()
  {
    return this.a8;
  }
  
  public void setA8(String paramString)
  {
    this.a8 = paramString;
  }
  
  public String getA9()
  {
    return this.a9;
  }
  
  public void setA9(String paramString)
  {
    this.a9 = paramString;
  }
  
  public String getCOUNTS()
  {
    return this.COUNTS;
  }
  
  public void setCOUNTS(String paramString)
  {
    this.COUNTS = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.eBillManage.VoucherInspect
 * JD-Core Version:    0.7.0.1
 */