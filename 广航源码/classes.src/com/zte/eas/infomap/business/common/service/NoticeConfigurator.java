package com.zte.eas.infomap.business.common.service;

import com.zte.eas.infomap.business.notice.service.INoticeConfigurator;
import java.util.HashMap;
import java.util.Map;

public class NoticeConfigurator
  implements INoticeConfigurator
{
  private Map<String, String> configs = new HashMap();
  
  public NoticeConfigurator()
  {
    this.configs.put("mail.sender", "Just a test!");
  }
  
  public String getConfig(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString)) || (!this.configs.containsKey(paramString))) {
      return "";
    }
    return (String)this.configs.get(paramString);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.infomap.business.common.service.NoticeConfigurator
 * JD-Core Version:    0.7.0.1
 */