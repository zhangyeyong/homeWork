package com.zte.eas.report.business.print.service;

import com.zte.eas.hnyd.business.print.model.CommonPrintModel;
import com.zte.ssb.Util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.SAXException;

public class PrintCommon
{
  final String PAGE_NEXT = "<br/><div class='PageNext'><!--[if IE 7]><br style='height:0; line-height:0'><![endif]--></div>";
  final String FILE_CONFIG_PRINT_SERVICE = "WEB-INF/classes/printBillImp.xml";
  final String FOLDER_TEMPLATES = "apps/ebill/print/templates/";
  final String PAGE_HEADER_FILE_NAME = "pageHeader.htm";
  public final String PRINT_DATA_FIELD_FORMAT = "#?{0}?#";
  public static String pageHeaderPath = "";
  private HttpSession currentSession;
  
  public String getAllFinanceTableHTML(String paramString1, String paramString2, HttpSession paramHttpSession, String paramString3)
  {
    this.currentSession = paramHttpSession;
    if (pageHeaderPath.equals("")) {
      pageHeaderPath = this.currentSession.getServletContext().getRealPath("apps/ebill/print/templates/pageHeader.htm");
    }
    String str1 = "";
    String str2 = "";
    String str3 = "";
    String[] arrayOfString1 = paramString1.split(",");
    String[] arrayOfString2 = paramString2.split(",");
    for (int i = 0; i < arrayOfString1.length; i++)
    {
      str2 = singleFinanceTableHTML(arrayOfString1[i], arrayOfString2[i], paramString3);
      if (str1.toString() == "") {
        str3 = "";
      } else {
        str3 = "<br/><div class='PageNext'><!--[if IE 7]><br style='height:0; line-height:0'><![endif]--></div>";
      }
      str1 = str1 + str3 + str2;
    }
    return str1;
  }
  
  private String singleFinanceTableHTML(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      String[] arrayOfString = getFinanceTableTemplateName(paramString2);
      List localList = getLineTableParam(paramString2);
      String str1 = arrayOfString[0];
      String str2 = arrayOfString[1];
      String str3 = arrayOfString[2];
      String str4 = getTemplateFileFullName(str1, paramString2, paramString3);
      String str5 = readfile(str4);
      String str6 = str5;
      Object localObject = getPrintModel(paramString1, str2, localList);
      if (localObject != null) {
        str6 = fillPrintTableHTML(str6, localObject);
      }
      str6 = str6.replace(formatString("billName"), str3);
      if (("imprestLoan".equals(paramString2)) || ("imprestCash".equals(paramString2)) || ("imprestOutgo".equals(paramString2)))
      {
        CommonPrintModel localCommonPrintModel = (CommonPrintModel)localObject;
        if ((localCommonPrintModel.getBoePaymentImprestHTML().indexOf("现金支付") != -1) || ("imprestCash".equals(paramString2))) {
          str6 = str6 + "<table name=\"printTableqm\" id=\"printTableqm\" type=\"multiRows\" headerType=\"all\" border=\"0\" width=\"100%\"><tr> <td width=\"70%\"  align=\"right\" style=\"font-size: 12px\">领款人签名：</td> <td width=\"30%\"></td> </tr><tr> <td width=\"70%\"  align=\"right\" style=\"font-size: 12px\"></td> <td width=\"30%\"></td> </tr><tr> <td width=\"70%\"  align=\"right\" style=\"font-size: 12px\"></td> <td width=\"30%\"></td> </tr> </table>";
        }
      }
      return str6;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
  
  private List getLineTableParam(String paramString)
  {
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    HashMap localHashMap3 = new HashMap();
    ArrayList localArrayList = new ArrayList();
    List localList1 = readXMLFile();
    for (int i = 0; i < localList1.size(); i++)
    {
      Document localDocument = (Document)localList1.get(i);
      if (localDocument != null)
      {
        List localList2 = localDocument.selectNodes("//printService/param");
        for (int j = 0; j < localList2.size(); j++)
        {
          Element localElement1 = (Element)localList2.get(j);
          String str = localElement1.attributeValue("type");
          if ((str.toLowerCase().equals(paramString.toLowerCase())) && (localElement1.elementIterator().hasNext()))
          {
            List localList3 = localElement1.selectNodes("LineParams/param");
            int k = 0;
            for (int m = 0; m < localList3.size(); m++)
            {
              Element localElement2 = (Element)localList3.get(m);
              localHashMap1.put(String.valueOf(k), localElement2.attributeValue("name"));
              localHashMap2.put(String.valueOf(k), localElement2.attributeValue("money"));
              localHashMap3.put(String.valueOf(k), localElement2.attributeValue("date"));
              k++;
            }
          }
        }
      }
    }
    localArrayList.add(localHashMap1);
    localArrayList.add(localHashMap2);
    localArrayList.add(localHashMap3);
    return localArrayList;
  }
  
  private String[] getFinanceTableTemplateName(String paramString)
    throws ParserConfigurationException, IOException, SAXException
  {
    String[] arrayOfString = new String[3];
    String str1 = "";
    String str2 = "";
    String str3 = "";
    List localList1 = readXMLFile();
    for (int i = 0; i < localList1.size(); i++)
    {
      Document localDocument = (Document)localList1.get(i);
      if (localDocument != null)
      {
        List localList2 = localDocument.selectNodes("//printService/param");
        for (int j = 0; j < localList2.size(); j++)
        {
          Element localElement = (Element)localList2.get(j);
          String str4 = localElement.attributeValue("type");
          if (str4.toLowerCase().equals(paramString.toLowerCase()))
          {
            str1 = localElement.attributeValue("template");
            str2 = localElement.attributeValue("className");
            str3 = localElement.attributeValue("name");
            break;
          }
        }
      }
    }
    arrayOfString[0] = str1;
    arrayOfString[1] = str2;
    arrayOfString[2] = str3;
    return arrayOfString;
  }
  
  private String getTemplateFileFullName(String paramString1, String paramString2, String paramString3)
  {
    String str = paramString3 + "apps" + File.separator + "ebill" + File.separator + paramString2;
    return str + File.separator + paramString1;
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
          if (str1.indexOf("hAttribute1") > 1) {
            System.out.println();
          }
          MessageFormat localMessageFormat = new MessageFormat("#?{0}?#");
          Object[] arrayOfObject = { str1 };
          String str3 = localMessageFormat.format(arrayOfObject);
          System.out.println(str3);
          System.out.println(str2);
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
  
  private Object getPrintModel(String paramString1, String paramString2, List paramList)
    throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException, InstantiationException
  {
    Object localObject = null;
    try
    {
      IFinancePrintService localIFinancePrintService = null;
      Class localClass = Class.forName(paramString2);
      localIFinancePrintService = (IFinancePrintService)localClass.newInstance();
      localObject = localIFinancePrintService.getFinancePrintModel(paramString1, paramList);
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
  
  private List readXMLFile()
  {
    SAXReader localSAXReader = new SAXReader();
    Document localDocument = null;
    ArrayList localArrayList = new ArrayList();
    try
    {
      localDocument = localSAXReader.read(getStream("printBillImp.xml"));
      List localList = localDocument.selectNodes("//beans/import");
      InputStream localInputStream = null;
      for (int i = 0; i < localList.size(); i++)
      {
        Element localElement = (Element)localList.get(i);
        String str = localElement.attributeValue("resource");
        localInputStream = getStream(str);
        localDocument = localSAXReader.read(localInputStream);
        localArrayList.add(localDocument);
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localArrayList;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.report.business.print.service.PrintCommon
 * JD-Core Version:    0.7.0.1
 */