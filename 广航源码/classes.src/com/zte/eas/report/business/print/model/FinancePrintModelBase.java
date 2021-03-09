package com.zte.eas.report.business.print.model;

import com.zte.eas.report.business.print.service.PrintCommon;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FinancePrintModelBase
{
  final String CURRENT_DATE_FORMAT = "yyyy-MM-dd";
  public String pageHeaderHTML = "";
  public String FinanceId = "";
  private String corporation = "";
  private String billName = "";
  public String auditLeader = "";
  private String reportNum = "";
  private String printDate = "";
  private String barCodeNum = "";
  public String boePaymentHTML = "";
  public String auditInfoHTML = "";
  public String boeAccessoryHTML = "";
  public String boeCavsHTML = "";
  
  public FinancePrintModelBase(String paramString)
  {
    this.FinanceId = paramString;
    Date localDate = new Date();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    setPrintDate(localSimpleDateFormat.format(localDate));
    setBoeAccessoryHTML(paramString);
    setPageHeaderHTML(paramString);
  }
  
  public String getPageHeaderHTML()
  {
    return this.pageHeaderHTML;
  }
  
  private void setPageHeaderHTML(String paramString)
  {
    if (!PrintCommon.pageHeaderPath.equals(""))
    {
      PrintCommon localPrintCommon = new PrintCommon();
      this.pageHeaderHTML = localPrintCommon.readfile(PrintCommon.pageHeaderPath);
      this.pageHeaderHTML = this.pageHeaderHTML.replace(localPrintCommon.formatString("corporation"), this.corporation);
      this.pageHeaderHTML = this.pageHeaderHTML.replace(localPrintCommon.formatString("reportNum"), this.reportNum);
      this.pageHeaderHTML = this.pageHeaderHTML.replace(localPrintCommon.formatString("printDate"), this.printDate);
      this.pageHeaderHTML = this.pageHeaderHTML.replace(localPrintCommon.formatString("barCodeNum"), this.barCodeNum);
    }
  }
  
  public String getFinanceId()
  {
    return this.FinanceId;
  }
  
  public void setFinanceId(String paramString)
  {
    this.FinanceId = paramString;
  }
  
  public String getAuditLeader()
  {
    return this.auditLeader;
  }
  
  public void setAuditLeader(String paramString)
  {
    this.auditLeader = paramString;
  }
  
  public String getBoePaymentHTML()
  {
    return this.boePaymentHTML;
  }
  
  public String getCorporation()
  {
    return this.corporation;
  }
  
  public void setCorporation(String paramString)
  {
    this.corporation = paramString;
  }
  
  public String getReportNum()
  {
    return this.reportNum;
  }
  
  public void setReportNum(String paramString)
  {
    this.reportNum = paramString;
  }
  
  public String getBillName()
  {
    return this.billName;
  }
  
  public void setBillName(String paramString)
  {
    this.billName = paramString;
  }
  
  public String getBarCodeNum()
  {
    return this.barCodeNum;
  }
  
  public void setBarCodeNum(String paramString)
  {
    this.barCodeNum = paramString;
  }
  
  private String getPrintDate()
  {
    return this.printDate;
  }
  
  private void setPrintDate(String paramString)
  {
    this.printDate = paramString;
  }
  
  public String getBoeAccessoryHTML()
  {
    return this.boeAccessoryHTML;
  }
  
  public void setBoeAccessoryHTML(String paramString) {}
  
  private String nullToString(Object paramObject)
  {
    return paramObject == null ? "" : paramObject.toString();
  }
  
  private String FormatDateToString(Date paramDate)
  {
    DateFormat localDateFormat = null;
    if (paramDate == null) {
      return "";
    }
    localDateFormat = DateFormat.getDateInstance(2, Locale.CHINESE);
    localDateFormat.setLenient(false);
    return localDateFormat.format(paramDate);
  }
  
  public String getAuditInfoHTML()
  {
    return this.auditInfoHTML;
  }
  
  public void setAuditInfoHTML(String paramString)
  {
    this.auditInfoHTML = paramString;
  }
  
  public String getBoeCavsHTML()
  {
    return this.boeCavsHTML;
  }
  
  public void setBoeCavsHTML(String paramString)
  {
    this.boeCavsHTML = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.report.business.print.model.FinancePrintModelBase
 * JD-Core Version:    0.7.0.1
 */