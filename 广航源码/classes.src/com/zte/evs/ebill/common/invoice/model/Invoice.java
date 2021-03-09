package com.zte.evs.ebill.common.invoice.model;

import java.awt.Font;

public class Invoice
{
  private int writeX = 0;
  private int writeY = 0;
  private Font font = null;
  private String strValue = "";
  private String strKey = "";
  private int drawX = 0;
  private int drawY = 0;
  private boolean tag = false;
  private boolean codeTag = false;
  
  public Invoice() {}
  
  public Invoice(int paramInt1, int paramInt2, Font paramFont, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.writeX = paramInt1;
    this.writeY = paramInt2;
    this.font = paramFont;
    this.strValue = paramString;
    this.tag = paramBoolean1;
    this.codeTag = paramBoolean2;
  }
  
  public int getWriteX()
  {
    return this.writeX;
  }
  
  public void setWriteX(int paramInt)
  {
    this.writeX = paramInt;
  }
  
  public int getWriteY()
  {
    return this.writeY;
  }
  
  public void setWriteY(int paramInt)
  {
    this.writeY = paramInt;
  }
  
  public Font getFont()
  {
    return this.font;
  }
  
  public void setFont(Font paramFont)
  {
    this.font = paramFont;
  }
  
  public String getStrValue()
  {
    return this.strValue;
  }
  
  public void setStrValue(String paramString)
  {
    this.strValue = paramString;
  }
  
  public boolean getTag()
  {
    return this.tag;
  }
  
  public void setTag(boolean paramBoolean)
  {
    this.tag = paramBoolean;
  }
  
  public boolean getCodeTag()
  {
    return this.codeTag;
  }
  
  public void setCodeTag(boolean paramBoolean)
  {
    this.codeTag = paramBoolean;
  }
  
  public int getDrawX()
  {
    return this.drawX;
  }
  
  public void setDrawX(int paramInt)
  {
    this.drawX = paramInt;
  }
  
  public int getDrawY()
  {
    return this.drawY;
  }
  
  public void setDrawY(int paramInt)
  {
    this.drawY = paramInt;
  }
  
  public String getStrKey()
  {
    return this.strKey;
  }
  
  public void setStrKey(String paramString)
  {
    this.strKey = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.common.invoice.model.Invoice
 * JD-Core Version:    0.7.0.1
 */