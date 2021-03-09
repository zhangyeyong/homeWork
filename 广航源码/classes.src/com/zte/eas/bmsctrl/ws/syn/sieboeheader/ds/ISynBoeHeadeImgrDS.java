package com.zte.eas.bmsctrl.ws.syn.sieboeheader.ds;

public abstract interface ISynBoeHeadeImgrDS
{
  public abstract boolean createImg(String paramString1, String paramString2);
  
  public abstract boolean createImg(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
  
  public abstract boolean deleteImg(String paramString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.bmsctrl.ws.syn.sieboeheader.ds.ISynBoeHeadeImgrDS
 * JD-Core Version:    0.7.0.1
 */