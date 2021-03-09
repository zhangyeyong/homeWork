package com.zte.evs.ebill.business.eBillManage;

import com.zte.ssb.Util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

public class PrintCommon
{
  final String PAGE_NEXT = "<br/><div class='PageNext'><!--[if IE 7]><br style='height:0; line-height:0'><![endif]--></div>";
  final String FOLDER_TEMPLATES = "apps/ebill/manage/report/print/templates/";
  final String PAGE_HEADER_FILE_NAME = "pageHeader.htm";
  final String BATCH_PRINT_FILE_NAME = "batchPrint.htm";
  final String BOOK_PRINT_FILE_NAME = "BookPrint.htm";
  final String BOOK_PRINT = "BOOK";
  public final String PRINT_DATA_FIELD_FORMAT = "#?{0}?#";
  public static String pageHeaderPath = "";
  private HttpSession currentSession;
  
  public String getAllFinanceTableHTML(String paramString1, String paramString2, String paramString3, String paramString4, HttpSession paramHttpSession)
  {
    this.currentSession = paramHttpSession;
    if (pageHeaderPath.equals("")) {
      pageHeaderPath = this.currentSession.getServletContext().getRealPath("apps/ebill/manage/report/print/templates/pageHeader.htm");
    }
    String str1 = "";
    String str2 = "";
    String str3 = "";
    String[] arrayOfString1 = paramString1.split(",");
    String[] arrayOfString2 = paramString2.split(",");
    String[] arrayOfString3 = paramString3.split(",");
    String[] arrayOfString4 = paramString4.split(",");
    for (int i = 0; i < arrayOfString1.length; i++)
    {
      if ("BOOK".equals(arrayOfString3[i])) {
        str2 = singleBookTableHTML(arrayOfString1[i], arrayOfString2[i], arrayOfString3[i], arrayOfString4[i]);
      } else {
        str2 = singleFinanceTableHTML(arrayOfString1[i], arrayOfString2[i], arrayOfString3[i], arrayOfString4[i]);
      }
      if (str1.toString() == "") {
        str3 = "";
      } else {
        str3 = "<br/><div class='PageNext'><!--[if IE 7]><br style='height:0; line-height:0'><![endif]--></div>";
      }
      str1 = str1 + str3 + str2;
    }
    return str1;
  }
  
  private String singleFinanceTableHTML(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      String str1 = readfile(this.currentSession.getServletContext().getRealPath("apps/ebill/manage/report/print/templates/batchPrint.htm"));
      String str2 = str1;
      Object localObject = getPrintModel(paramString1);
      if (localObject != null) {
        str2 = fillPrintTableHTML(str2, localObject);
      }
      str2 = str2.replace(formatString("billName"), paramString2);
      str2 = str2.replace(formatString("billCode"), paramString2);
      str2 = str2.replace(formatString("bookPreson"), paramString3);
      str2 = str2.replace(formatString("bookDate"), paramString4);
      return str2;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
  
  private String singleBookTableHTML(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      String str1 = readfile(this.currentSession.getServletContext().getRealPath("apps/ebill/manage/report/print/templates/BookPrint.htm"));
      String str2 = str1;
      Object localObject = getBookPrintModel(paramString2);
      if (localObject != null) {
        str2 = fillPrintTableHTML(str2, localObject);
      }
      str2 = str2.replace(formatString("billName"), paramString2);
      str2 = str2.replace(formatString("billCode"), paramString2);
      return str2;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
  
  private Object getBookPrintModel(String paramString)
    throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException, InstantiationException
  {
    Object localObject = null;
    try
    {
      IFinancePrintService localIFinancePrintService = null;
      Class localClass = Class.forName("com.zte.evs.ebill.business.eBillManage.CommonPrintService");
      localIFinancePrintService = (IFinancePrintService)localClass.newInstance();
      localObject = localIFinancePrintService.getBookPrintModel(paramString);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localObject;
  }
  
  public String readfile(String paramString)
  {
    String str1 = "";
    try
    {
      File localFile = new File(paramString);
      FileReader localFileReader = new FileReader(localFile);
      String str2 = localFileReader.getEncoding();
      FileInputStream localFileInputStream = new FileInputStream(localFile);
      InputStreamReader localInputStreamReader = new InputStreamReader(localFileInputStream, "utf-8");
      BufferedReader localBufferedReader = new BufferedReader(localInputStreamReader);
      String str3 = null;
      while ((str3 = localBufferedReader.readLine()) != null) {
        str1 = str1 + str3 + "\n";
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return str1;
  }
  
  private String fillPrintTableHTML(String paramString, Object paramObject)
    throws IllegalAccessException
  {
    try
    {
      Class localClass = paramObject.getClass();
      Field[] arrayOfField = localClass.getFields();
      for (int i = 0; i < arrayOfField.length; i++)
      {
        String str1 = arrayOfField[i].getName();
        if (!str1.equals(""))
        {
          String str2 = "";
          Object localObject = arrayOfField[i].get(paramObject);
          if (localObject != null) {
            str2 = localObject.toString();
          }
          MessageFormat localMessageFormat = new MessageFormat("#?{0}?#");
          Object[] arrayOfObject = { str1 };
          String str3 = localMessageFormat.format(arrayOfObject);
          paramString = paramString.replace(str3, str2);
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      paramString = paramString + localException.getMessage();
    }
    return paramString;
  }
  
  private Object getPrintModel(String paramString)
    throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException, InstantiationException
  {
    Object localObject = null;
    try
    {
      IFinancePrintService localIFinancePrintService = null;
      Class localClass = Class.forName("com.zte.evs.ebill.business.eBillManage.CommonPrintService");
      localIFinancePrintService = (IFinancePrintService)localClass.newInstance();
      localObject = localIFinancePrintService.getFinancePrintModel(paramString);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localObject;
  }
  
  public String formatString(String paramString)
  {
    MessageFormat localMessageFormat = new MessageFormat("#?{0}?#");
    Object[] arrayOfObject = { paramString };
    String str = localMessageFormat.format(arrayOfObject);
    return str;
  }
  
  private InputStream getStream(String paramString)
  {
    InputStream localInputStream = Util.class.getClassLoader().getResourceAsStream(paramString);
    if (localInputStream == null)
    {
      PrintCommon.class.getClassLoader();
      localInputStream = ClassLoader.getSystemResourceAsStream(paramString);
    }
    return localInputStream;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.eBillManage.PrintCommon
 * JD-Core Version:    0.7.0.1
 */