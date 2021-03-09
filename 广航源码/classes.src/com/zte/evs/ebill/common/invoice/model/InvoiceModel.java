package com.zte.evs.ebill.common.invoice.model;

import java.awt.Font;

public class InvoiceModel
{
  private int startX;
  private int startY;
  private int endX;
  private int endY;
  private boolean tag = false;
  private boolean codeTag = false;
  private int fontSize = 12;
  private int fontType;
  private Font font;
  private int type;
  private int tabNum;
  private String strName;
  private String alignType;
  private String valignType;
  private String strValue;
  private String modelUrl;
  private String filePath;
  
  public InvoiceModel() {}
  
  public InvoiceModel(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, int paramInt5, int paramInt6, Font paramFont, int paramInt7, int paramInt8, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.startX = paramInt1;
    this.startY = paramInt2;
    this.endX = paramInt3;
    this.endY = paramInt4;
    this.tag = paramBoolean1;
    this.codeTag = paramBoolean2;
    this.fontSize = paramInt5;
    this.fontType = paramInt6;
    this.font = paramFont;
    this.type = paramInt7;
    this.tabNum = paramInt8;
    this.strName = paramString1;
    this.alignType = paramString2;
    this.valignType = paramString3;
    this.strValue = paramString4;
    this.modelUrl = paramString5;
    this.filePath = paramString6;
  }
  
  public String getModelUrl()
  {
    return this.modelUrl;
  }
  
  public void setModelUrl(String paramString)
  {
    this.modelUrl = paramString;
  }
  
  public String getFilePath()
  {
    return this.filePath;
  }
  
  public void setFilePath(String paramString)
  {
    this.filePath = paramString;
  }
  
  public int getStartX()
  {
    return this.startX;
  }
  
  public void setStartX(int paramInt)
  {
    this.startX = paramInt;
  }
  
  public int getStartY()
  {
    return this.startY;
  }
  
  public void setStartY(int paramInt)
  {
    this.startY = paramInt;
  }
  
  public int getEndX()
  {
    return this.endX;
  }
  
  public void setEndX(int paramInt)
  {
    this.endX = paramInt;
  }
  
  public int getEndY()
  {
    return this.endY;
  }
  
  public void setEndY(int paramInt)
  {
    this.endY = paramInt;
  }
  
  public boolean getTag()
  {
    return this.tag;
  }
  
  public void setTag(boolean paramBoolean)
  {
    this.tag = paramBoolean;
  }
  
  public String getAlignType()
  {
    return this.alignType;
  }
  
  public void setAlignType(String paramString)
  {
    this.alignType = paramString;
  }
  
  public String getValignType()
  {
    return this.valignType;
  }
  
  public void setValignType(String paramString)
  {
    this.valignType = paramString;
  }
  
  public String getStrName()
  {
    return this.strName;
  }
  
  public void setStrName(String paramString)
  {
    this.strName = paramString;
  }
  
  public int getFontType()
  {
    return this.fontType;
  }
  
  public void setFontType(int paramInt)
  {
    this.fontType = paramInt;
  }
  
  public String getStrValue()
  {
    return this.strValue;
  }
  
  public void setStrValue(String paramString)
  {
    this.strValue = paramString;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public int getFontSize()
  {
    return this.fontSize;
  }
  
  public void setFontSize(int paramInt)
  {
    this.fontSize = paramInt;
  }
  
  public Font getFont()
  {
    return this.font;
  }
  
  public void setFont(Font paramFont)
  {
    this.font = paramFont;
  }
  
  public int getTabNum()
  {
    return this.tabNum;
  }
  
  public void setTabNum(int paramInt)
  {
    this.tabNum = paramInt;
  }
  
  public boolean getCodeTag()
  {
    return this.codeTag;
  }
  
  public void setCodeTag(boolean paramBoolean)
  {
    this.codeTag = paramBoolean;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.common.invoice.model.InvoiceModel
 * JD-Core Version:    0.7.0.1
 */