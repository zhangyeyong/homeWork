package com.zte.evs.ebill.common.invoice.util;

import com.zte.evs.ebill.common.invoice.model.InvoiceModel;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlReader
{
  private Logger log = Logger.getLogger(getClass());
  public Map<String, InvoiceModel> template_invoice_total_begin = null;
  public Map<String, InvoiceModel> template_invoice_total_middle = null;
  public Map<String, InvoiceModel> template_invoice_total_begin_and_end = null;
  public Map<String, InvoiceModel> template_invoice_total_end = null;
  public Map<String, InvoiceModel> template_invoice_pay_begin_and_end = null;
  public Map<String, InvoiceModel> template_invoice_pay_begin = null;
  public Map<String, InvoiceModel> template_invoice_pay_middle = null;
  public Map<String, InvoiceModel> template_invoice_pay_end = null;
  public Map<String, InvoiceModel> template_invoice_pre_begin_and_end = null;
  public Map<String, InvoiceModel> template_invoice_pre_begin = null;
  public Map<String, InvoiceModel> template_invoice_pre_middle = null;
  public Map<String, InvoiceModel> template_invoice_pre_end = null;
  public Map<String, InvoiceModel> template_invoice_history_begin_and_end = null;
  public Map<String, InvoiceModel> template_invoice_ar_begin_and_end = null;
  public Map<String, InvoiceModel> template_invoice_ar_begin = null;
  public Map<String, InvoiceModel> template_invoice_ar_middle = null;
  public Map<String, InvoiceModel> template_invoice_ar_end = null;
  public Map<String, InvoiceModel> template_invoice_rec_begin_and_end = null;
  public Map<String, InvoiceModel> template_invoice_rec_begin = null;
  public Map<String, InvoiceModel> template_invoice_rec_middle = null;
  public Map<String, InvoiceModel> template_invoice_rec_end = null;
  private DocumentBuilderFactory factory = null;
  private DocumentBuilder builder = null;
  private Document doc = null;
  private InvoiceModel invoiceModel;
  
  public XmlReader(int paramInt)
  {
    try
    {
      this.factory = DocumentBuilderFactory.newInstance();
      this.builder = this.factory.newDocumentBuilder();
    }
    catch (ParserConfigurationException localParserConfigurationException)
    {
      localParserConfigurationException.printStackTrace();
      System.out.println(localParserConfigurationException.getMessage());
    }
    if (1 == paramInt)
    {
      readTemplatePayBeginAndEnd();
      readTemplatePayBegin();
      readTemplatePayMiddle();
      readTemplatePayEnd();
    }
    if (3 == paramInt)
    {
      readTemplatePreBeginAndEnd();
      readTemplatePreBegin();
      readTemplatePreMiddle();
      readTemplatePreEnd();
    }
    if (2 == paramInt)
    {
      readTemplateTotalBeginAndEnd();
      readTemplateTotalBegin();
      readTemplateTotalMiddle();
      readTemplateTotalEnd();
    }
    if (5 == paramInt)
    {
      readTemplateArBeginAndEnd();
      readTemplateArBegin();
      readTemplateArMiddle();
      readTemplateArEnd();
    }
    if (6 == paramInt)
    {
      readTemplateRecBeginAndEnd();
      readTemplateRecBegin();
      readTemplateRecMiddle();
      readTemplateRecEnd();
    }
    if (4 == paramInt) {
      readTemplateHisBeginAndEnd();
    }
  }
  
  public Map<String, InvoiceModel> readTemplatePayBeginAndEnd()
  {
    if ((isRightFile("template/invoice_template_pay_begin_and_end.xml")) && (this.template_invoice_pay_begin_and_end == null))
    {
      this.template_invoice_pay_begin_and_end = new HashMap();
      this.template_invoice_pay_begin_and_end = readTemplate(readFromFilePath("template/invoice_template_pay_begin_and_end.xml"));
    }
    return this.template_invoice_pay_begin_and_end;
  }
  
  public Map<String, InvoiceModel> readTemplatePayBegin()
  {
    if ((isRightFile("template/invoice_template_pay_begin.xml")) && (this.template_invoice_pay_begin == null))
    {
      this.template_invoice_pay_begin = new HashMap();
      this.template_invoice_pay_begin = readTemplate(readFromFilePath("template/invoice_template_pay_begin.xml"));
    }
    return this.template_invoice_pay_begin;
  }
  
  public Map<String, InvoiceModel> readTemplatePayMiddle()
  {
    if ((isRightFile("template/invoice_template_pay_middle.xml")) && (this.template_invoice_pay_middle == null))
    {
      this.template_invoice_pay_middle = new HashMap();
      this.template_invoice_pay_middle = readTemplate(readFromFilePath("template/invoice_template_pay_middle.xml"));
    }
    return this.template_invoice_pay_middle;
  }
  
  public Map<String, InvoiceModel> readTemplatePayEnd()
  {
    if ((isRightFile("template/invoice_template_pay_end.xml")) && (this.template_invoice_pay_end == null))
    {
      this.template_invoice_pay_end = new HashMap();
      this.template_invoice_pay_end = readTemplate(readFromFilePath("template/invoice_template_pay_end.xml"));
    }
    return this.template_invoice_pay_end;
  }
  
  public Map<String, InvoiceModel> readTemplatePreBeginAndEnd()
  {
    if ((isRightFile("template/invoice_template_pre_begin_and_end.xml")) && (this.template_invoice_pre_begin_and_end == null))
    {
      this.template_invoice_pre_begin_and_end = new HashMap();
      this.template_invoice_pre_begin_and_end = readTemplate(readFromFilePath("template/invoice_template_pre_begin_and_end.xml"));
    }
    return this.template_invoice_pre_begin_and_end;
  }
  
  public Map<String, InvoiceModel> readTemplatePreBegin()
  {
    if ((isRightFile("template/invoice_template_pre_begin.xml")) && (this.template_invoice_pre_begin == null))
    {
      this.template_invoice_pre_begin = new HashMap();
      this.template_invoice_pre_begin = readTemplate(readFromFilePath("template/invoice_template_pre_begin.xml"));
    }
    return this.template_invoice_pre_begin;
  }
  
  public Map<String, InvoiceModel> readTemplatePreMiddle()
  {
    if ((isRightFile("template/invoice_template_pre_middle.xml")) && (this.template_invoice_pre_middle == null))
    {
      this.template_invoice_pre_middle = new HashMap();
      this.template_invoice_pre_middle = readTemplate(readFromFilePath("template/invoice_template_pre_middle.xml"));
    }
    return this.template_invoice_pre_middle;
  }
  
  public Map<String, InvoiceModel> readTemplatePreEnd()
  {
    if ((isRightFile("template/invoice_template_pre_end.xml")) && (this.template_invoice_pre_end == null))
    {
      this.template_invoice_pre_end = new HashMap();
      this.template_invoice_pre_end = readTemplate(readFromFilePath("template/invoice_template_pre_end.xml"));
    }
    return this.template_invoice_pre_end;
  }
  
  public Map<String, InvoiceModel> readTemplateTotalBeginAndEnd()
  {
    if ((isRightFile("template/invoice_template_total_begin_and_end.xml")) && (this.template_invoice_total_begin_and_end == null))
    {
      this.template_invoice_total_begin_and_end = new HashMap();
      this.log.error("文件名信息为=====template/invoice_template_total_begin_and_end.xml");
      this.template_invoice_total_begin_and_end = readTemplate(readFromFilePath("template/invoice_template_total_begin_and_end.xml"));
    }
    return this.template_invoice_total_begin_and_end;
  }
  
  public Map<String, InvoiceModel> readTemplateArBeginAndEnd()
  {
    if ((isRightFile("template/invoice_template_ar_begin_and_end.xml")) && (this.template_invoice_ar_begin_and_end == null))
    {
      this.template_invoice_ar_begin_and_end = new HashMap();
      this.template_invoice_ar_begin_and_end = readTemplate(readFromFilePath("template/invoice_template_ar_begin_and_end.xml"));
    }
    return this.template_invoice_ar_begin_and_end;
  }
  
  public Map<String, InvoiceModel> readTemplateRecBeginAndEnd()
  {
    if ((isRightFile("template/invoice_template_rec_begin_and_end.xml")) && (this.template_invoice_rec_begin_and_end == null))
    {
      this.template_invoice_rec_begin_and_end = new HashMap();
      this.template_invoice_rec_begin_and_end = readTemplate(readFromFilePath("template/invoice_template_rec_begin_and_end.xml"));
    }
    return this.template_invoice_ar_begin_and_end;
  }
  
  public Map<String, InvoiceModel> readTemplateTotalBegin()
  {
    if ((isRightFile("template/invoice_template_total_begin.xml")) && (this.template_invoice_total_begin == null))
    {
      this.template_invoice_total_begin = new HashMap();
      this.template_invoice_total_begin = readTemplate(readFromFilePath("template/invoice_template_total_begin.xml"));
    }
    return this.template_invoice_total_begin;
  }
  
  public Map<String, InvoiceModel> readTemplateArBegin()
  {
    if ((isRightFile("template/invoice_template_ar_begin.xml")) && (this.template_invoice_ar_begin == null))
    {
      this.template_invoice_ar_begin = new HashMap();
      this.template_invoice_ar_begin = readTemplate(readFromFilePath("template/invoice_template_ar_begin.xml"));
    }
    return this.template_invoice_ar_begin;
  }
  
  public Map<String, InvoiceModel> readTemplateRecBegin()
  {
    if ((isRightFile("template/invoice_template_rec_begin.xml")) && (this.template_invoice_rec_begin == null))
    {
      this.template_invoice_rec_begin = new HashMap();
      this.template_invoice_rec_begin = readTemplate(readFromFilePath("template/invoice_template_rec_begin.xml"));
    }
    return this.template_invoice_rec_begin;
  }
  
  public Map<String, InvoiceModel> readTemplateTotalMiddle()
  {
    if ((isRightFile("template/invoice_template_total_middle.xml")) && (this.template_invoice_total_middle == null))
    {
      this.template_invoice_total_middle = new HashMap();
      this.template_invoice_total_middle = readTemplate(readFromFilePath("template/invoice_template_total_middle.xml"));
    }
    return this.template_invoice_total_middle;
  }
  
  public Map<String, InvoiceModel> readTemplateArMiddle()
  {
    if ((isRightFile("template/invoice_template_ar_middle.xml")) && (this.template_invoice_ar_middle == null))
    {
      this.template_invoice_ar_middle = new HashMap();
      this.template_invoice_ar_middle = readTemplate(readFromFilePath("template/invoice_template_ar_middle.xml"));
    }
    return this.template_invoice_ar_middle;
  }
  
  public Map<String, InvoiceModel> readTemplateRecMiddle()
  {
    if ((isRightFile("template/invoice_template_rec_middle.xml")) && (this.template_invoice_rec_middle == null))
    {
      this.template_invoice_rec_middle = new HashMap();
      this.template_invoice_rec_middle = readTemplate(readFromFilePath("template/invoice_template_rec_middle.xml"));
    }
    return this.template_invoice_rec_middle;
  }
  
  public Map<String, InvoiceModel> readTemplateTotalEnd()
  {
    if ((isRightFile("template/invoice_template_total_end.xml")) && (this.template_invoice_total_end == null))
    {
      this.template_invoice_total_end = new HashMap();
      this.template_invoice_total_end = readTemplate(readFromFilePath("template/invoice_template_total_end.xml"));
    }
    return this.template_invoice_total_end;
  }
  
  public Map<String, InvoiceModel> readTemplateArEnd()
  {
    if ((isRightFile("template/invoice_template_ar_end.xml")) && (this.template_invoice_ar_end == null))
    {
      this.template_invoice_ar_end = new HashMap();
      this.template_invoice_ar_end = readTemplate(readFromFilePath("template/invoice_template_ar_end.xml"));
    }
    return this.template_invoice_ar_end;
  }
  
  public Map<String, InvoiceModel> readTemplateRecEnd()
  {
    if ((isRightFile("template/invoice_template_rec_end.xml")) && (this.template_invoice_rec_end == null))
    {
      this.template_invoice_rec_end = new HashMap();
      this.template_invoice_rec_end = readTemplate(readFromFilePath("template/invoice_template_rec_end.xml"));
    }
    return this.template_invoice_rec_end;
  }
  
  public Map<String, InvoiceModel> readTemplateHisBeginAndEnd()
  {
    if ((isRightFile("template/invoice_template_history_begin_and_end.xml")) && (this.template_invoice_history_begin_and_end == null))
    {
      this.template_invoice_history_begin_and_end = new HashMap();
      this.template_invoice_history_begin_and_end = readTemplate(readFromFilePath("template/invoice_template_history_begin_and_end.xml"));
    }
    return this.template_invoice_history_begin_and_end;
  }
  
  public String readFromFilePath(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      File localFile = new File(StringUtils.getLocalFilePath() + paramString);
      FileInputStream localFileInputStream = new FileInputStream(localFile);
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localFileInputStream, "utf-8"));
      for (String str = localBufferedReader.readLine(); str != null; str = localBufferedReader.readLine()) {
        localStringBuffer.append(str);
      }
      localFileInputStream.close();
      localBufferedReader.close();
    }
    catch (IOException localIOException)
    {
      System.out.println(localIOException.getMessage());
      localIOException.printStackTrace();
    }
    return localStringBuffer.toString();
  }
  
  public boolean isRightFile(String paramString)
  {
    String str = StringUtils.getLocalFilePath() + paramString;
    if ((str != null) && (!"".equals(str)))
    {
      File localFile = new File(str);
      if (!localFile.isFile())
      {
        System.out.println("XML读取路径错误！:::" + str);
        return false;
      }
    }
    else
    {
      System.out.println("XML读取路径为空！");
      return false;
    }
    return true;
  }
  
  public Map<String, InvoiceModel> readTemplate(String paramString)
  {
    HashMap localHashMap = new HashMap();
    String str1 = "";
    try
    {
      this.doc = this.builder.parse(new ByteArrayInputStream(paramString.getBytes()));
      this.invoiceModel = new InvoiceModel();
      this.invoiceModel.setStrName("Model_Url");
      this.log.error("所读的Model_Url为:===" + this.doc.getElementsByTagName("Model_Url").item(0).getFirstChild().getNodeValue());
      this.invoiceModel.setModelUrl(StringUtils.getLocalFilePath() + this.doc.getElementsByTagName("Model_Url").item(0).getFirstChild().getNodeValue());
      localHashMap.put("Model_Url", this.invoiceModel);
      this.invoiceModel = new InvoiceModel();
      this.invoiceModel.setStrName("File_Path");
      this.invoiceModel.setFilePath(StringUtils.getLocalFilePath() + this.doc.getElementsByTagName("File_Path").item(0).getFirstChild().getNodeValue());
      localHashMap.put("File_Path", this.invoiceModel);
      int i = this.doc.getElementsByTagName("PJ_Area").getLength();
      for (int j = 0; j < i; j++)
      {
        this.invoiceModel = new InvoiceModel();
        NodeList localNodeList = this.doc.getElementsByTagName("PJ_Area").item(j).getChildNodes();
        for (int k = 0; k < localNodeList.getLength(); k++)
        {
          Object localObject;
          if (localNodeList.item(k).hasChildNodes())
          {
            if ("Name".equals(localNodeList.item(k).getNodeName()))
            {
              str1 = localNodeList.item(k).getFirstChild().getNodeValue();
              this.invoiceModel.setStrName(localNodeList.item(k).getFirstChild().getNodeValue());
            }
            if ("ExtraInfo".equals(localNodeList.item(k).getNodeName()))
            {
              localObject = localNodeList.item(k).getChildNodes();
              for (int m = 0; m < ((NodeList)localObject).getLength(); m++)
              {
                if ("Font".equals(((NodeList)localObject).item(m).getNodeName())) {
                  this.invoiceModel.setFontType(Integer.parseInt(((NodeList)localObject).item(m).getFirstChild().getNodeValue()));
                }
                if ("Align".equals(((NodeList)localObject).item(m).getNodeName()))
                {
                  String str2 = ((NodeList)localObject).item(m).getFirstChild().getNodeValue();
                  this.invoiceModel.setAlignType(getAlignType(str2.substring(0, 1)));
                  this.invoiceModel.setValignType(getValignType(str2.substring(1)));
                }
                if ("Type".equals(((NodeList)localObject).item(m).getNodeName())) {
                  this.invoiceModel.setType(Integer.parseInt(((NodeList)localObject).item(m).getFirstChild().getNodeValue() == null ? "0" : ((NodeList)localObject).item(m).getFirstChild().getNodeValue()));
                }
                if ("Value".equals(((NodeList)localObject).item(m).getNodeName())) {
                  if (this.invoiceModel.getType() == 3) {
                    this.invoiceModel.setStrValue(StringUtils.getLocalFilePath() + ((NodeList)localObject).item(m).getFirstChild().getNodeValue());
                  } else {
                    this.invoiceModel.setStrValue(((NodeList)localObject).item(m).getFirstChild() == null ? "" : ((NodeList)localObject).item(m).getFirstChild().getNodeValue());
                  }
                }
                if ("TabNum".equals(((NodeList)localObject).item(m).getNodeName())) {
                  this.invoiceModel.setTabNum(Integer.parseInt(((NodeList)localObject).item(m).getFirstChild().getNodeValue()));
                }
              }
            }
          }
          else if ("Rect".equals(localNodeList.item(k).getNodeName()))
          {
            localObject = localNodeList.item(k).getAttributes();
            this.invoiceModel.setStartX(((NamedNodeMap)localObject).getNamedItem("Left").getNodeValue() == null ? 0 : Integer.parseInt(((NamedNodeMap)localObject).getNamedItem("Left").getNodeValue()));
            this.invoiceModel.setStartY(((NamedNodeMap)localObject).getNamedItem("Top").getNodeValue() == null ? 0 : Integer.parseInt(((NamedNodeMap)localObject).getNamedItem("Top").getNodeValue()));
            this.invoiceModel.setEndX(((NamedNodeMap)localObject).getNamedItem("Right").getNodeValue() == null ? 0 : Integer.parseInt(((NamedNodeMap)localObject).getNamedItem("Right").getNodeValue()));
            this.invoiceModel.setEndY(((NamedNodeMap)localObject).getNamedItem("Bottom").getNodeValue() == null ? 0 : Integer.parseInt(((NamedNodeMap)localObject).getNamedItem("Bottom").getNodeValue()));
          }
        }
        if (this.invoiceModel != null) {
          localHashMap.put(str1, this.invoiceModel);
        }
      }
    }
    catch (SAXException localSAXException)
    {
      System.out.println(localSAXException.getMessage());
      localSAXException.printStackTrace();
    }
    catch (IOException localIOException)
    {
      System.out.println(localIOException.getMessage());
      localIOException.printStackTrace();
    }
    return localHashMap;
  }
  
  public String getAlignType(String paramString)
  {
    String str = "LEFT";
    if ("1".equals(paramString)) {
      str = "LEFT";
    } else if ("2".equals(paramString)) {
      str = "CENTER";
    } else if ("3".equals(paramString)) {
      str = "RIGHT";
    }
    return str;
  }
  
  public String getValignType(String paramString)
  {
    String str = "MIDDLE";
    if ("1".equals(paramString)) {
      str = "TOP";
    } else if ("2".equals(paramString)) {
      str = "MIDDLE";
    } else if ("3".equals(paramString)) {
      str = "BUTTOM";
    }
    return str;
  }
  
  public static void main(String[] paramArrayOfString)
  {
    new XmlReader(2);
    System.out.println("success");
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.common.invoice.util.XmlReader
 * JD-Core Version:    0.7.0.1
 */