package com.zte.web.service.esp;

import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import java.util.List;

public abstract interface IEspMessageDS
{
  public abstract TableDataInfo findEspMessageList(String paramString, int paramInt1, int paramInt2);
  
  public abstract List<EspMessage> findEspMessageList(String paramString);
  
  public abstract String findEspUrl();
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.esp.IEspMessageDS
 * JD-Core Version:    0.7.0.1
 */