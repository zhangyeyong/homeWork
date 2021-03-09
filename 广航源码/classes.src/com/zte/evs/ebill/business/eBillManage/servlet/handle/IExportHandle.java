package com.zte.evs.ebill.business.eBillManage.servlet.handle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract interface IExportHandle
{
  public abstract Object handle(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.eBillManage.servlet.handle.IExportHandle
 * JD-Core Version:    0.7.0.1
 */