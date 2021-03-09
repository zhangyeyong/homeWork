/*  1:   */ package com.zte.eas.infomap.business.sso;
/*  2:   */ 
/*  3:   */ import com.zte.evs.ebill.access.eBillManage.IEvsImageDAO;
/*  4:   */ import com.zte.evs.ebill.common.invoice.action.IImageThreadDS;
/*  5:   */ import com.zte.ssb.framework.SSBBus;
/*  6:   */ import java.io.FileInputStream;
/*  7:   */ import java.io.IOException;
/*  8:   */ import java.io.InputStream;
/*  9:   */ import java.sql.Connection;
/* 10:   */ import java.util.Map;
/* 11:   */ import javax.servlet.Filter;
/* 12:   */ import javax.servlet.FilterChain;
/* 13:   */ import javax.servlet.FilterConfig;
/* 14:   */ import javax.servlet.ServletContext;
/* 15:   */ import javax.servlet.ServletException;
/* 16:   */ import javax.servlet.ServletOutputStream;
/* 17:   */ import javax.servlet.ServletRequest;
/* 18:   */ import javax.servlet.ServletResponse;
/* 19:   */ import javax.servlet.http.HttpServletRequest;
/* 20:   */ import net.sf.jasperreports.engine.JasperRunManager;
/* 21:   */ import org.apache.commons.lang.StringUtils;
/* 22:   */ import org.apache.log4j.Logger;
/* 23:   */ 
/* 24:   */ public class ReportFilter
/* 25:   */   implements Filter
/* 26:   */ {
/* 27:   */   public static String jaserPath;
/* 28:35 */   Logger log = Logger.getLogger(ReportFilter.class);
/* 29:   */   
/* 30:   */   public void init(FilterConfig filterConfig)
/* 31:   */     throws ServletException
/* 32:   */   {
/* 33:38 */     jaserPath = filterConfig.getServletContext().getRealPath("/common/report/") + "/";
/* 34:   */   }
/* 35:   */   
/* 36:   */   public void destroy() {}
/* 37:   */   
/* 38:   */   public void doFilter(ServletRequest Req, ServletResponse resp, FilterChain arg2)
/* 39:   */     throws IOException, ServletException
/* 40:   */   {
/* 41:49 */     ServletOutputStream output = resp.getOutputStream();
/* 42:   */     try
/* 43:   */     {
/* 44:51 */       HttpServletRequest request = (HttpServletRequest)Req;
/* 45:52 */       String voucherStr = request.getParameter("voucherId");
/* 46:53 */       if (StringUtils.isNotBlank(voucherStr))
/* 47:   */       {
/* 48:54 */         Long voucherId = Long.valueOf(voucherStr);
/* 49:55 */         String report = "gh_cover.jasper";
/* 50:56 */         IEvsImageDAO evsImageDAO = (IEvsImageDAO)
/* 51:57 */           SSBBus.findDaoService("evsImageDAO");
/* 52:   */         
/* 53:59 */         Connection conn = evsImageDAO.getConnection();
/* 54:60 */         IImageThreadDS imageThreadDS = (IImageThreadDS)SSBBus.findCommonService("imageThreadDS");
/* 55:   */         
/* 56:62 */         Map<String, Object> map = imageThreadDS.getMap(voucherId);
/* 57:   */         
/* 58:64 */         InputStream input = new FileInputStream(jaserPath + report);
/* 59:65 */         JasperRunManager.runReportToPdfStream(input, output, map, conn);
/* 60:66 */         resp.setContentType("application/pdf");
/* 61:67 */         conn.close();
/* 62:68 */         input.close();
/* 63:   */       }
/* 64:   */     }
/* 65:   */     catch (Exception e)
/* 66:   */     {
/* 67:71 */       e.printStackTrace();
/* 68:72 */       this.log.error(e.getMessage(), e);
/* 69:   */     }
/* 70:75 */     output.flush();
/* 71:76 */     output.close();
/* 72:   */   }
/* 73:   */ }


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.infomap.business.sso.ReportFilter
 * JD-Core Version:    0.7.0.1
 */