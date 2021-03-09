package com.zte.eimage.business.baseconfig.service;

public abstract interface ISyncSpecialAttachmentDS
{
  public abstract void syncSpecialAttachment(String paramString1, String paramString2);
  
  public abstract void updateSpecialAttachmenFlag(String paramString1, String paramString2, String paramString3);
  
  public abstract void updateWaitSyncFlag(String paramString);
  
  public abstract String getWaitSyncFlag(String paramString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.service.ISyncSpecialAttachmentDS
 * JD-Core Version:    0.7.0.1
 */