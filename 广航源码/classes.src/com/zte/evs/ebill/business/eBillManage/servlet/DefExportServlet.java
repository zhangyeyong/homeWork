package com.zte.evs.ebill.business.eBillManage.servlet;

import com.zte.evs.ebill.business.eBillManage.servlet.handle.IExportHandle;
import com.zte.evs.ebill.business.eBillManage.servlet.handle.SpecialAttachmentExportHandle;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DefExportServlet
  extends HttpServlet
{
  private static final long serialVersionUID = 3931863753798892228L;
  private static final String SPECIAL_ATTACHMENT = "specialattachment";
  private IExportHandle exportHandle = null;
  
  protected void doGet(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
    throws ServletException, IOException
  {
    super.doPost(paramHttpServletRequest, paramHttpServletResponse);
  }
  
  protected void doPost(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
    throws ServletException, IOException
  {
    paramHttpServletRequest.setCharacterEncoding("UTF-8");
    paramHttpServletResponse.setCharacterEncoding("UTF-8");
    String str = paramHttpServletRequest.getParameter("handle");
    if ("specialattachment".equals(str)) {
      this.exportHandle = new SpecialAttachmentExportHandle();
    }
    this.exportHandle.handle(paramHttpServletRequest, paramHttpServletResponse);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.eBillManage.servlet.DefExportServlet
 * JD-Core Version:    0.7.0.1
 */