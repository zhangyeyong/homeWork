package com.zte.evs.ebill.business.eBillManage;

import com.zte.evs.ebill.model.eBillManage.EvsVoucherSearchV;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherVo;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import org.apache.commons.lang.StringUtils;

public class VoucherExportExcelServlet
  extends HttpServlet
{
  private static final long serialVersionUID = -1113925464689337250L;
  private IEvsVoucherQuery evsVoucherQuery = null;
  private WritableWorkbook writableWorkbook = null;
  private WritableSheet writableSheet = null;
  private ServletOutputStream outputStream = null;
  private List<EvsVoucherSearchV> voucherList = null;
  private EvsVoucherVo evsVoucherVo = null;
  
  public void destroy()
  {
    super.destroy();
  }
  
  public void doGet(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
    throws ServletException, IOException
  {
    doPost(paramHttpServletRequest, paramHttpServletResponse);
  }
  
  public void doPost(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
    throws ServletException, IOException
  {
    paramHttpServletRequest.setCharacterEncoding("UTF-8");
    paramHttpServletResponse.setCharacterEncoding("UTF-8");
    exportExcel(paramHttpServletRequest, paramHttpServletResponse);
  }
  
  private void exportExcel(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
  {
    String str1 = paramHttpServletRequest.getParameter("beginIDBak");
    String str2 = paramHttpServletRequest.getParameter("endIDBak");
    String str3 = paramHttpServletRequest.getParameter("companyCodeBak");
    String str4 = paramHttpServletRequest.getParameter("journalDatePeriodBak");
    String str5 = paramHttpServletRequest.getParameter("invoiceTypeBak");
    String str6 = paramHttpServletRequest.getParameter("user_nameBak");
    String str7 = paramHttpServletRequest.getParameter("userInfoPk");
    String str8 = paramHttpServletRequest.getParameter("companyNameBak");
    String str9 = paramHttpServletRequest.getParameter("statusBak");
    String str10 = paramHttpServletRequest.getParameter("period_nameBak");
    String str11 = paramHttpServletRequest.getParameter("bookCodeCountBak");
    str11 = str11 == null ? "0" : str11;
    this.evsVoucherVo = new EvsVoucherVo();
    this.evsVoucherVo.setBeginID(str1);
    this.evsVoucherVo.setEndID(str2);
    this.evsVoucherVo.setCompanyCode(str3);
    this.evsVoucherVo.setJournalDatePeriod(str4);
    this.evsVoucherVo.setInvoiceType(str5);
    this.evsVoucherVo.setUser_name(str6);
    this.evsVoucherVo.setUserInfoPk(str7);
    this.evsVoucherVo.setCompanyName(str8);
    this.evsVoucherVo.setStatus(str9);
    this.evsVoucherVo.setPeriod_name(str10);
    this.evsVoucherVo.setBookCodeCount(str11);
    queryData(this.evsVoucherVo);
    try
    {
      this.outputStream = paramHttpServletResponse.getOutputStream();
      this.writableWorkbook = Workbook.createWorkbook(this.outputStream);
      this.writableSheet = this.writableWorkbook.createSheet("第一页", 0);
      buildExcelHeader(this.writableSheet);
      parseData(this.writableSheet);
      paramHttpServletResponse.setContentType("application/vnd.ms-exce");
      paramHttpServletResponse.setHeader("Content-disposition", "attachment; filename=" + URLEncoder.encode("凭证日志报表.xls", "UTF-8"));
      this.writableWorkbook.write();
      this.writableWorkbook.close();
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    catch (WriteException localWriteException)
    {
      localWriteException.printStackTrace();
    }
  }
  
  private void queryData(EvsVoucherVo paramEvsVoucherVo)
  {
    this.evsVoucherQuery = ((IEvsVoucherQuery)SSBBus.findCommonService("evsVoucherQueryDS"));
    this.voucherList = this.evsVoucherQuery.getVoucherList(paramEvsVoucherVo, 1, 2147483647).getData();
  }
  
  private void parseData(WritableSheet paramWritableSheet)
  {
    WritableFont localWritableFont1 = new WritableFont(WritableFont.ARIAL, 10);
    WritableCellFormat localWritableCellFormat1 = new WritableCellFormat(localWritableFont1);
    WritableFont localWritableFont2 = new WritableFont(WritableFont.ARIAL, 20, WritableFont.BOLD);
    WritableCellFormat localWritableCellFormat2 = new WritableCellFormat(localWritableFont2);
    try
    {
      localWritableCellFormat2.setAlignment(Alignment.CENTRE);
    }
    catch (WriteException localWriteException1)
    {
      localWriteException1.printStackTrace();
    }
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Label localLabel = null;
    Object localObject2;
    String str2;
    try
    {
      String str1 = this.evsVoucherVo.getJournalDatePeriod();
      localObject1 = "XXXX";
      localObject2 = "XX";
      try
      {
        if (StringUtils.isNotEmpty(str1))
        {
          localObject1 = str1.split("-")[0];
          localObject2 = str1.split("-")[1];
        }
      }
      catch (Exception localException) {}
      localLabel = new Label(0, 0, (String)localObject1 + "年" + (String)localObject2 + "月凭证日志", localWritableCellFormat2);
      paramWritableSheet.addCell(localLabel);
      str2 = this.evsVoucherVo.getCompanyName();
      if (StringUtils.isEmpty(str2)) {
        str2 = "XXXX公司";
      } else if (!str2.contains("公司")) {
        str2.concat("公司");
      }
      localLabel = new Label(0, 1, str2, localWritableCellFormat1);
      paramWritableSheet.addCell(localLabel);
      localLabel = new Label(4, 1, "总册数：" + this.evsVoucherVo.getBookCodeCount());
      paramWritableSheet.addCell(localLabel);
    }
    catch (RowsExceededException localRowsExceededException1)
    {
      localRowsExceededException1.printStackTrace();
    }
    catch (WriteException localWriteException2)
    {
      localWriteException2.printStackTrace();
    }
    int i = 3;
    Object localObject1 = this.voucherList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (EvsVoucherSearchV)((Iterator)localObject1).next();
      str2 = ((EvsVoucherSearchV)localObject2).getJournalNum();
      String str3 = ((EvsVoucherSearchV)localObject2).getInvoiceType();
      String str4 = ((EvsVoucherSearchV)localObject2).getDeptName();
      String str5 = ((EvsVoucherSearchV)localObject2).getUserName();
      String str6 = ((EvsVoucherSearchV)localObject2).getBoeNum();
      Date localDate = ((EvsVoucherSearchV)localObject2).getJournalDate();
      String str7 = ((EvsVoucherSearchV)localObject2).getAbstracts();
      String str8 = ((EvsVoucherSearchV)localObject2).getBookCode();
      str2 = StringUtils.isEmpty(str2) ? "" : str2;
      str3 = StringUtils.isEmpty(str3) ? "" : str3;
      str4 = StringUtils.isEmpty(str4) ? "" : str4;
      str5 = StringUtils.isEmpty(str5) ? "" : str5;
      str6 = StringUtils.isEmpty(str6) ? "" : str6;
      str7 = StringUtils.isEmpty(str7) ? "" : str7;
      str8 = StringUtils.isEmpty(str8) ? "" : str8;
      try
      {
        localLabel = new Label(0, i, str2, localWritableCellFormat1);
        paramWritableSheet.addCell(localLabel);
        localLabel = new Label(1, i, str3, localWritableCellFormat1);
        paramWritableSheet.addCell(localLabel);
        localLabel = new Label(2, i, str4, localWritableCellFormat1);
        paramWritableSheet.addCell(localLabel);
        localLabel = new Label(3, i, str5, localWritableCellFormat1);
        paramWritableSheet.addCell(localLabel);
        localLabel = new Label(4, i, str6, localWritableCellFormat1);
        paramWritableSheet.addCell(localLabel);
        localLabel = new Label(5, i, localSimpleDateFormat.format(localDate), localWritableCellFormat1);
        paramWritableSheet.addCell(localLabel);
        localLabel = new Label(6, i, str7, localWritableCellFormat1);
        paramWritableSheet.addCell(localLabel);
        localLabel = new Label(7, i, str8, localWritableCellFormat1);
        paramWritableSheet.addCell(localLabel);
      }
      catch (RowsExceededException localRowsExceededException2)
      {
        localRowsExceededException2.printStackTrace();
      }
      catch (WriteException localWriteException3)
      {
        localWriteException3.printStackTrace();
      }
      i++;
    }
  }
  
  private void buildExcelHeader(WritableSheet paramWritableSheet)
  {
    Label localLabel = null;
    WritableFont localWritableFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);
    WritableCellFormat localWritableCellFormat = new WritableCellFormat(localWritableFont);
    try
    {
      localLabel = new Label(0, 2, "凭证编号", localWritableCellFormat);
      paramWritableSheet.setColumnView(0, 20);
      paramWritableSheet.addCell(localLabel);
      localLabel = new Label(1, 2, "凭证类型", localWritableCellFormat);
      paramWritableSheet.setColumnView(1, 20);
      paramWritableSheet.addCell(localLabel);
      localLabel = new Label(2, 2, "制单部门", localWritableCellFormat);
      paramWritableSheet.setColumnView(2, 20);
      paramWritableSheet.addCell(localLabel);
      localLabel = new Label(3, 2, "制单人", localWritableCellFormat);
      paramWritableSheet.setColumnView(3, 15);
      paramWritableSheet.addCell(localLabel);
      localLabel = new Label(4, 2, "凭证参照", localWritableCellFormat);
      paramWritableSheet.setColumnView(4, 20);
      paramWritableSheet.addCell(localLabel);
      localLabel = new Label(5, 2, "记账日期", localWritableCellFormat);
      paramWritableSheet.setColumnView(5, 12);
      paramWritableSheet.addCell(localLabel);
      localLabel = new Label(6, 2, "抬头文本", localWritableCellFormat);
      paramWritableSheet.setColumnView(6, 20);
      paramWritableSheet.addCell(localLabel);
      localLabel = new Label(7, 2, "分册编号", localWritableCellFormat);
      paramWritableSheet.setColumnView(7, 20);
      paramWritableSheet.addCell(localLabel);
      paramWritableSheet.mergeCells(0, 0, 7, 0);
      paramWritableSheet.mergeCells(0, 1, 3, 1);
      paramWritableSheet.mergeCells(4, 1, 7, 1);
    }
    catch (RowsExceededException localRowsExceededException)
    {
      localRowsExceededException.printStackTrace();
    }
    catch (WriteException localWriteException)
    {
      localWriteException.printStackTrace();
    }
  }
  
  public void init()
    throws ServletException
  {}
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.eBillManage.VoucherExportExcelServlet
 * JD-Core Version:    0.7.0.1
 */