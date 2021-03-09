package com.zte.evs.ebill.common;

public class Content
{
  private long key;
  private String name;
  
  public Content(long paramLong, String paramString)
  {
    this.key = paramLong;
    this.name = paramString;
  }
  
  public long getKey()
  {
    return this.key;
  }
  
  public void setKey(long paramLong)
  {
    this.key = paramLong;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.common.Content
 * JD-Core Version:    0.7.0.1
 */