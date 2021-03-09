package com.zte.evs.ebill.business.eBillManage;

import com.zte.evs.ebill.access.eBillManage.IEvsPackageDAO;
import com.zte.evs.ebill.common.EvsStatusUtil;
import com.zte.evs.ebill.model.eBillManage.CommonPrintModel;
import com.zte.evs.ebill.model.eBillManage.EvsAddBookV;
import com.zte.evs.ebill.model.eBillManage.EvsBookV;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherV;
import com.zte.ssb.framework.SSBBus;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CommonPrintService
  implements IFinancePrintService
{
  public static final String BIGINTEGER = "BigInteger";
  public static final String BIGDECIMAL = "BigDecimal";
  public static final String STRING = "String";
  
  public Object getFinancePrintModel(String paramString)
  {
    System.out.println("************************************************************ getFinancePrintModel start");
    CommonPrintModel localCommonPrintModel = new CommonPrintModel();
    try
    {
      IEvsPackageDAO localIEvsPackageDAO = (IEvsPackageDAO)SSBBus.findDaoService("packageDAO");
      EvsAddBookV localEvsAddBookV = new EvsAddBookV();
      localEvsAddBookV.setPackageId(Long.valueOf(Long.parseLong(paramString)));
      Object localObject = new ArrayList();
      localObject = localIEvsPackageDAO.printBookByCode(localEvsAddBookV);
      commonLineTable((List)localObject, localCommonPrintModel);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localCommonPrintModel;
  }
  
  private void commonLineTable(List paramList, CommonPrintModel paramCommonPrintModel)
    throws Exception
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 1;
    for (int j = 0; j < paramList.size(); j++)
    {
      EvsAddBookV localEvsAddBookV = (EvsAddBookV)paramList.get(j);
      String str1 = null != localEvsAddBookV.getBookCode() ? localEvsAddBookV.getBookCode() : "";
      String str2 = null != localEvsAddBookV.getUnitName() ? localEvsAddBookV.getUnitName() : "";
      String str3 = null != localEvsAddBookV.getPeriodName() ? localEvsAddBookV.getPeriodName() : "";
      String str4 = null != localEvsAddBookV.getSmaName() ? localEvsAddBookV.getSmaName().toString() : "";
      String str5 = null != localEvsAddBookV.getBookPeople() ? localEvsAddBookV.getBookPeople() : "";
      String str6 = null != localEvsAddBookV.getBookDate() ? localSimpleDateFormat.format(localEvsAddBookV.getBookDate()) : "";
      String str7 = null != localEvsAddBookV.getBeginNum() ? localEvsAddBookV.getBeginNum() : "";
      String str8 = null != localEvsAddBookV.getEndNum() ? localEvsAddBookV.getEndNum() : "";
      String str9 = null != localEvsAddBookV.getStatusName() ? localEvsAddBookV.getStatusName() : "";
      String str10 = null != localEvsAddBookV.getDeadline() ? localEvsAddBookV.getDeadline() : "";
      String str11 = null != localEvsAddBookV.getArchiveNumber() ? localEvsAddBookV.getArchiveNumber() : "";
      String str12 = null != localEvsAddBookV.getPackageCode() ? localEvsAddBookV.getPackageCode() : "";
      String str13 = null != localEvsAddBookV.getBookStatus() ? localEvsAddBookV.getBookStatus() : "";
      localStringBuffer.append("<tr><td>" + i++ + "</td>" + "<td>" + str1 + "</td>" + "<td>" + str2 + "</td>" + "<td>" + str3 + "</td>" + "<td>" + str5 + "</td>" + "<td>" + str6 + "</td>" + "<td>" + EvsStatusUtil.getVoucherStatusName(str13) + "</td>" + "</tr>");
    }
    paramCommonPrintModel.setCommonLineHtml(localStringBuffer.toString());
  }
  
  public Object getBookPrintModel(String paramString)
  {
    System.out.println("************************************************************ getBookPrintModel start");
    CommonPrintModel localCommonPrintModel = new CommonPrintModel();
    try
    {
      IEvsPackageDAO localIEvsPackageDAO = (IEvsPackageDAO)SSBBus.findDaoService("packageDAO");
      EvsBookV localEvsBookV = new EvsBookV();
      localEvsBookV.setBookCode(paramString);
      Object localObject = new ArrayList();
      localObject = localIEvsPackageDAO.findVoucherByBookCodeNwe(localEvsBookV);
      commonLineTableBook((List)localObject, localCommonPrintModel);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localCommonPrintModel;
  }
  
  private void commonLineTableBook(List<EvsVoucherV> paramList, CommonPrintModel paramCommonPrintModel)
    throws Exception
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 1;
    for (int j = 0; j < paramList.size(); j++)
    {
      EvsVoucherV localEvsVoucherV = (EvsVoucherV)paramList.get(j);
      String str1 = null != localEvsVoucherV.getJournalNum() ? localEvsVoucherV.getJournalNum() : "";
      String str2 = null != localEvsVoucherV.getCompanyName() ? localEvsVoucherV.getCompanyName() : "";
      String str3 = null != localEvsVoucherV.getInvoiceType() ? localEvsVoucherV.getInvoiceType().toString() : "";
      String str4 = null != localEvsVoucherV.getPeriodName() ? localEvsVoucherV.getPeriodName() : "";
      String str5 = null != localEvsVoucherV.getUserName() ? localEvsVoucherV.getUserName() : "";
      String str6 = null != localEvsVoucherV.getCreatedDate() ? localSimpleDateFormat.format(localEvsVoucherV.getCreatedDate()) : "";
      String str7 = null != localEvsVoucherV.getLastUpdateDate() ? localSimpleDateFormat.format(localEvsVoucherV.getLastUpdateDate()) : "";
      localStringBuffer.append("<tr><td>" + i++ + "</td>" + "<td>" + str1 + "</td>" + "<td>" + str2 + "</td>" + "<td>" + str3 + "</td>" + "<td>" + str4 + "</td>" + "<td>" + str5 + "</td>" + "<td>" + str6 + "</td>" + "<td>" + str5 + "</td>" + "<td>" + str7 + "</td>" + "</tr>");
    }
    paramCommonPrintModel.setCommonLineHtml(localStringBuffer.toString());
  }
  
  private String nullToString(Object paramObject)
  {
    return paramObject == null ? "" : paramObject.toString();
  }
  
  private String formatMoney(Object paramObject)
    throws Exception
  {
    DecimalFormat localDecimalFormat = new DecimalFormat();
    if ((paramObject == null) || ("".equals(paramObject))) {
      return "0.00";
    }
    if (paramObject.equals("-0.00")) {
      return "0.00";
    }
    Double localDouble = Double.valueOf(Double.parseDouble(paramObject.toString()));
    localDecimalFormat.applyPattern("#,##0.00");
    return localDecimalFormat.format(localDouble);
  }
  
  private String formatDate(Object paramObject)
  {
    DateFormat localDateFormat = null;
    if (paramObject == null) {
      return "";
    }
    localDateFormat = DateFormat.getDateInstance(2, Locale.CHINESE);
    localDateFormat.setLenient(false);
    return localDateFormat.format((Date)paramObject);
  }
  
  private double moneyTypeValue(String paramString, Object paramObject)
  {
    double d = 0.0D;
    if (paramString.indexOf("BigInteger") > -1)
    {
      if ((paramObject != null) && (!"".equals(paramObject))) {
        d = ((BigInteger)paramObject).doubleValue();
      }
    }
    else if (paramString.indexOf("BigDecimal") > -1)
    {
      if ((paramObject != null) && (!"".equals(paramObject))) {
        d = ((BigDecimal)paramObject).doubleValue();
      }
    }
    else if ((paramString.indexOf("String") > -1) && (paramObject != null) && (!"".equals(paramObject))) {
      d = Double.parseDouble(paramObject.toString());
    }
    return d;
  }
  
  public static void main(String[] paramArrayOfString) {}
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.eBillManage.CommonPrintService
 * JD-Core Version:    0.7.0.1
 */