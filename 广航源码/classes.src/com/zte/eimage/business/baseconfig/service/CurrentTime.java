package com.zte.eimage.business.baseconfig.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CurrentTime
  implements ICurrentTime
{
  Log log = LogFactory.getLog(CurrentTime.class);
  
  public String CurrentTime(String paramString)
  {
    this.log.error("\n\n++++++++++++++++++++++++++++ CurrentTime 获取服务器当前时间 begin +++++++++++++++++++++++++++++++++++++++++++++");
    String str = null;
    this.log.error("sessionID:  " + paramString);
    Calendar localCalendar = Calendar.getInstance();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    localCalendar = Calendar.getInstance(Locale.CHINESE);
    str = localSimpleDateFormat.format(localCalendar.getTime()).trim();
    this.log.error("returnValue:  " + str);
    this.log.error("++++++++++++++++++++++++++++ CurrentTime 获取服务器当前时间 end +++++++++++++++++++++++++++++++++++++++++++++\n\n");
    return str;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.service.CurrentTime
 * JD-Core Version:    0.7.0.1
 */