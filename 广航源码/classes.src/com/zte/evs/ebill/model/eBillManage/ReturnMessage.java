package com.zte.evs.ebill.model.eBillManage;

public class ReturnMessage
{
  private String message;
  private String periodName;
  private String periodDate;
  private String periodNameS;
  
  public ReturnMessage() {}
  
  public String getMessage()
  {
    return this.message;
  }
  
  public ReturnMessage(String paramString1, String paramString2, String paramString3)
  {
    this.message = paramString1;
    this.periodName = paramString2;
    this.periodDate = paramString3;
  }
  
  public void setMessage(String paramString)
  {
    this.message = paramString;
  }
  
  public String getPeriodDate()
  {
    return this.periodDate;
  }
  
  public void setPeriodDate(String paramString)
  {
    this.periodDate = paramString;
  }
  
  public String getPeriodName()
  {
    return this.periodName;
  }
  
  public void setPeriodName(String paramString)
  {
    this.periodName = paramString;
  }
  
  public String getPeriodNameS()
  {
    return this.periodNameS;
  }
  
  public void setPeriodNameS(String paramString)
  {
    this.periodNameS = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.ReturnMessage
 * JD-Core Version:    0.7.0.1
 */