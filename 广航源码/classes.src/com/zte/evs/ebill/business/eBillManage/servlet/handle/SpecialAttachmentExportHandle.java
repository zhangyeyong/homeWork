package com.zte.evs.ebill.business.eBillManage.servlet.handle;

import com.zte.eimage.business.baseconfig.service.IEidImageInfosDS;
import com.zte.evs.ebill.model.eBillManage.SpecialAttachmentV;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletOutputStream;
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

public class SpecialAttachmentExportHandle
  implements IExportHandle
{
  private List<SpecialAttachmentV> savList;
  private SpecialAttachmentV sav;
  private int contentIndex = 0;
  
  private static String firstLetterToUpper(String paramString)
  {
    char[] arrayOfChar = paramString.toCharArray();
    int tmp7_6 = 0;
    char[] tmp7_5 = arrayOfChar;
    tmp7_5[tmp7_6] = ((char)(tmp7_5[tmp7_6] - ' '));
    return String.valueOf(arrayOfChar);
  }
  
  private static Method fetchMethod(String paramString)
  {
    Method[] arrayOfMethod1 = SpecialAttachmentV.class.getDeclaredMethods();
    Object localObject = null;
    for (Method localMethod : arrayOfMethod1)
    {
      String str = localMethod.getName();
      if ((str.startsWith("set")) && (str.equals(paramString)))
      {
        localObject = localMethod;
        break;
      }
    }
    return localObject;
  }
  
  private static void wrapParams(HttpServletRequest paramHttpServletRequest, SpecialAttachmentV paramSpecialAttachmentV)
  {
    String str1 = paramHttpServletRequest.getParameter("imageNumberBak");
    String str2 = paramHttpServletRequest.getParameter("taskNumBak");
    String str3 = paramHttpServletRequest.getParameter("companyIdBak");
    String str4 = paramHttpServletRequest.getParameter("operationTypeIdBak");
    String str5 = paramHttpServletRequest.getParameter("uploadEmployeeIdBak");
    String str6 = paramHttpServletRequest.getParameter("uploadDateBeginBak");
    String str7 = paramHttpServletRequest.getParameter("uploadDateEndBak");
    String str8 = paramHttpServletRequest.getParameter("imageStatusBak");
    String str9 = paramHttpServletRequest.getParameter("journalDateBeginBak");
    String str10 = paramHttpServletRequest.getParameter("journalDateEndBak");
    String str11 = paramHttpServletRequest.getParameter("appraiseEmployeeIdBak");
    String str12 = paramHttpServletRequest.getParameter("appraiseDateBeginBak");
    String str13 = paramHttpServletRequest.getParameter("appraiseDateEndBak");
    String str14 = paramHttpServletRequest.getParameter("blurQueryBak");
    paramSpecialAttachmentV.setImageNumber(str1);
    paramSpecialAttachmentV.setTaskNum(str2);
    if (StringUtils.isNotEmpty(str3)) {
      paramSpecialAttachmentV.setCompanyId(Long.valueOf(str3));
    }
    if (StringUtils.isNotEmpty(str4)) {
      paramSpecialAttachmentV.setOperationTypeId(Long.valueOf(str4));
    }
    if (StringUtils.isNotEmpty(str5)) {
      paramSpecialAttachmentV.setUploadEmployeeId(Long.valueOf(str5));
    }
    if (StringUtils.isNotEmpty(str11)) {
      paramSpecialAttachmentV.setAppraiseEmployeeId(Long.valueOf(str11));
    }
    paramSpecialAttachmentV.setUploadDateBegin(str6);
    paramSpecialAttachmentV.setUploadDateEnd(str7);
    paramSpecialAttachmentV.setImageStatus(str8);
    paramSpecialAttachmentV.setJournalDateBegin(str9);
    paramSpecialAttachmentV.setJournalDateEnd(str10);
    paramSpecialAttachmentV.setAppraiseDateBegin(str12);
    paramSpecialAttachmentV.setAppraiseDateEnd(str13);
    paramSpecialAttachmentV.setBlurQuery(str14);
  }
  
  public Object handle(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
  {
    this.sav = new SpecialAttachmentV();
    wrapParams(paramHttpServletRequest, this.sav);
    queryData(this.sav);
    WritableWorkbook localWritableWorkbook = null;
    try
    {
      ServletOutputStream localServletOutputStream = paramHttpServletResponse.getOutputStream();
      localWritableWorkbook = Workbook.createWorkbook(localServletOutputStream);
    }
    catch (IOException localIOException1)
    {
      localIOException1.printStackTrace();
    }
    WritableSheet localWritableSheet = localWritableWorkbook.createSheet("第一页", 0);
    buildExcelHeader(localWritableSheet);
    parseData(localWritableSheet);
    paramHttpServletResponse.setContentType("application/vnd.ms-exce");
    try
    {
      paramHttpServletResponse.setHeader("Content-disposition", "attachment; filename=" + URLEncoder.encode("特殊附件管理报表.xls", "UTF-8"));
      localWritableWorkbook.write();
      localWritableWorkbook.close();
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    catch (IOException localIOException2)
    {
      localIOException2.printStackTrace();
    }
    catch (WriteException localWriteException)
    {
      localWriteException.printStackTrace();
    }
    return null;
  }
  
  private void queryData(SpecialAttachmentV paramSpecialAttachmentV)
  {
    IEidImageInfosDS localIEidImageInfosDS = (IEidImageInfosDS)SSBBus.findCommonService("imageInfosDS");
    this.savList = localIEidImageInfosDS.fetchSpecialAttachments(paramSpecialAttachmentV, -2147483648, 2147483647).getData();
  }
  
  private void parseData(WritableSheet paramWritableSheet)
  {
    WritableFont localWritableFont1 = new WritableFont(WritableFont.ARIAL, 20, WritableFont.BOLD);
    WritableFont localWritableFont2 = new WritableFont(WritableFont.ARIAL, 10);
    WritableCellFormat localWritableCellFormat1 = new WritableCellFormat(localWritableFont2);
    WritableCellFormat localWritableCellFormat2 = new WritableCellFormat(localWritableFont1);
    WritableCellFormat localWritableCellFormat3 = new WritableCellFormat(localWritableFont2);
    try
    {
      localWritableCellFormat2.setAlignment(Alignment.CENTRE);
      localWritableCellFormat3.setAlignment(Alignment.RIGHT);
    }
    catch (WriteException localWriteException1)
    {
      localWriteException1.printStackTrace();
    }
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Label localLabel = null;
    Object localObject2;
    Object localObject3;
    try
    {
      localLabel = new Label(0, 0, "特殊附件管理报表", localWritableCellFormat2);
      paramWritableSheet.addCell(localLabel);
      String str1 = this.sav.getJournalDateBegin();
      localObject1 = this.sav.getJournalDateEnd();
      localObject2 = "";
      localObject3 = "";
      if (StringUtils.isNotEmpty(str1))
      {
        localObject2 = str1.substring(0, str1.lastIndexOf("-"));
        localObject2 = ((String)localObject2).replaceFirst("-", "年");
        localObject2 = (String)localObject2 + "月";
      }
      if (StringUtils.isNotEmpty((String)localObject1))
      {
        localObject3 = (String)localObject3 + ((String)localObject1).substring(0, ((String)localObject1).lastIndexOf("-"));
        localObject3 = ((String)localObject3).replaceFirst("-", "年");
        localObject3 = (String)localObject3 + "月";
      }
      localLabel = new Label(0, 3, "会计期间: " + (String)localObject2 + " - " + (String)localObject3, localWritableCellFormat3);
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
    int i = 1;
    Object localObject1 = this.savList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (SpecialAttachmentV)((Iterator)localObject1).next();
      localObject3 = ((SpecialAttachmentV)localObject2).getJournalDate();
      String str2 = null != localObject3 ? localSimpleDateFormat.format((Date)localObject3) : "";
      String str3 = ((SpecialAttachmentV)localObject2).getJournalNum();
      Long localLong = ((SpecialAttachmentV)localObject2).getAttachmentCount();
      String str4 = ((SpecialAttachmentV)localObject2).getTaskNum();
      String str5 = ((SpecialAttachmentV)localObject2).getCompanyCode();
      String str6 = ((SpecialAttachmentV)localObject2).getCompanyName();
      str2 = StringUtils.isEmpty(str2) ? "" : str2;
      str3 = StringUtils.isEmpty(str3) ? "" : str3;
      str4 = StringUtils.isEmpty(str4) ? "" : str4;
      str5 = StringUtils.isEmpty(str5) ? "" : str5;
      str6 = StringUtils.isEmpty(str6) ? "" : str6;
      try
      {
        localLabel = new Label(0, this.contentIndex, String.valueOf(i++), localWritableCellFormat1);
        paramWritableSheet.addCell(localLabel);
        localLabel = new Label(1, this.contentIndex, str2, localWritableCellFormat1);
        paramWritableSheet.addCell(localLabel);
        localLabel = new Label(2, this.contentIndex, str3, localWritableCellFormat1);
        paramWritableSheet.addCell(localLabel);
        localLabel = new Label(3, this.contentIndex, localLong.toString(), localWritableCellFormat1);
        paramWritableSheet.addCell(localLabel);
        localLabel = new Label(4, this.contentIndex, str4, localWritableCellFormat1);
        paramWritableSheet.addCell(localLabel);
        localLabel = new Label(5, this.contentIndex, str5, localWritableCellFormat1);
        paramWritableSheet.addCell(localLabel);
        localLabel = new Label(6, this.contentIndex, str6, localWritableCellFormat1);
        paramWritableSheet.addCell(localLabel);
      }
      catch (RowsExceededException localRowsExceededException3)
      {
        localRowsExceededException3.printStackTrace();
      }
      catch (WriteException localWriteException4)
      {
        localWriteException4.printStackTrace();
      }
      this.contentIndex += 1;
    }
    int j = this.contentIndex + 4;
    try
    {
      paramWritableSheet.mergeCells(0, j, 6, j);
      localLabel = new Label(0, j++, "说明：以上台账按照法人公司、月度整理，台账明细及相关附件原始凭证由接收方装订归档。", localWritableCellFormat1);
      paramWritableSheet.addCell(localLabel);
      paramWritableSheet.mergeCells(0, j, 1, j);
      localLabel = new Label(0, j, "内部传递", localWritableCellFormat1);
      paramWritableSheet.addCell(localLabel);
      paramWritableSheet.mergeCells(2, j, 3, j);
      localLabel = new Label(2, j, "交接人：", localWritableCellFormat1);
      paramWritableSheet.addCell(localLabel);
      paramWritableSheet.mergeCells(4, j, 5, j);
      localLabel = new Label(4, j, "接收人：", localWritableCellFormat1);
      paramWritableSheet.addCell(localLabel);
      localLabel = new Label(6, j++, "交接日期：", localWritableCellFormat1);
      paramWritableSheet.addCell(localLabel);
      paramWritableSheet.mergeCells(0, j, 1, j);
      localLabel = new Label(0, j, "转总账主管", localWritableCellFormat1);
      paramWritableSheet.addCell(localLabel);
      paramWritableSheet.mergeCells(2, j, 3, j);
      localLabel = new Label(2, j, "交接人: ", localWritableCellFormat1);
      paramWritableSheet.addCell(localLabel);
      paramWritableSheet.mergeCells(4, j, 5, j);
      localLabel = new Label(4, j, "接收人: ", localWritableCellFormat1);
      paramWritableSheet.addCell(localLabel);
      localLabel = new Label(6, j++, "交接日期: ", localWritableCellFormat1);
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
  }
  
  private void buildExcelHeader(WritableSheet paramWritableSheet)
  {
    Label localLabel = null;
    WritableFont localWritableFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);
    WritableCellFormat localWritableCellFormat = new WritableCellFormat(localWritableFont);
    try
    {
      paramWritableSheet.mergeCells(0, 0, 6, 2);
      paramWritableSheet.mergeCells(0, 3, 6, 3);
      localLabel = new Label(0, 4, "序号", localWritableCellFormat);
      paramWritableSheet.addCell(localLabel);
      localLabel = new Label(1, 4, "记帐日期", localWritableCellFormat);
      paramWritableSheet.addCell(localLabel);
      localLabel = new Label(2, 4, "ERP凭证号", localWritableCellFormat);
      paramWritableSheet.setColumnView(2, 15);
      paramWritableSheet.addCell(localLabel);
      localLabel = new Label(3, 4, "附件张数", localWritableCellFormat);
      paramWritableSheet.addCell(localLabel);
      localLabel = new Label(4, 4, "报帐单号", localWritableCellFormat);
      paramWritableSheet.setColumnView(4, 15);
      paramWritableSheet.addCell(localLabel);
      localLabel = new Label(5, 4, "公司代码", localWritableCellFormat);
      paramWritableSheet.addCell(localLabel);
      localLabel = new Label(6, 4, "结算公司", localWritableCellFormat);
      paramWritableSheet.setColumnView(6, 35);
      paramWritableSheet.addCell(localLabel);
      this.contentIndex = 5;
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
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.eBillManage.servlet.handle.SpecialAttachmentExportHandle
 * JD-Core Version:    0.7.0.1
 */