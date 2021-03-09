package com.zte.evs.ebill.model.eBillManage;

public class BookMenuModel
{
  private String bookMenuId;
  private String bookMenuName;
  private String fatherMenuId;
  private String childrenCount;
  
  public String getBookMenuId()
  {
    return this.bookMenuId;
  }
  
  public void setBookMenuId(String paramString)
  {
    this.bookMenuId = paramString;
  }
  
  public String getBookMenuName()
  {
    return this.bookMenuName;
  }
  
  public void setBookMenuName(String paramString)
  {
    this.bookMenuName = paramString;
  }
  
  public String getFatherMenuId()
  {
    return this.fatherMenuId;
  }
  
  public void setFatherMenuId(String paramString)
  {
    this.fatherMenuId = paramString;
  }
  
  public String getChildrenCount()
  {
    return this.childrenCount;
  }
  
  public void setChildrenCount(String paramString)
  {
    this.childrenCount = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.BookMenuModel
 * JD-Core Version:    0.7.0.1
 */