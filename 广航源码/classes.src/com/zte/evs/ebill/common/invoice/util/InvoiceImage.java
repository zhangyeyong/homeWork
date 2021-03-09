package com.zte.evs.ebill.common.invoice.util;

import com.zte.evs.ebill.business.eBillManage.EvsVoucherCheckService;
import com.zte.evs.ebill.common.invoice.model.Invoice;
import com.zte.evs.ebill.common.invoice.model.InvoiceLine;
import com.zte.evs.ebill.common.invoice.model.InvoiceModel;
import com.zte.evs.ebill.common.invoice.model.InvoicePageContext;
import com.zte.evs.ebill.common.invoice.model.InvoicePageModel;
import java.awt.Font;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.Logger;

public class InvoiceImage
{
  private Logger log = Logger.getLogger(getClass());
  private Map<String, String> strList = null;
  private List<Map<String, String>> dataResult = null;
  private List<InvoicePageContext> invoicePageContexts = new ArrayList();
  private XmlReader xmlReader;
  private List<InvoicePageModel> invoicePageModels = new ArrayList();
  private List<Invoice> listInvoice = null;
  private List<Invoice> invoiceOnePage = null;
  private int totalPage = 0;
  private int totalCount = 0;
  private int curPage = 1;
  private int pageSize = 10;
  private int invoice_type = 0;
  
  public InvoiceImage(int paramInt, Map<String, String> paramMap, List<Map<String, String>> paramList)
  {
    this.invoice_type = paramInt;
    if (4 == paramInt) {
      this.pageSize = 15;
    } else {
      this.pageSize = 10;
    }
    this.xmlReader = new XmlReader(paramInt);
    this.strList = new HashMap();
    this.dataResult = new ArrayList();
    this.strList = paramMap;
    this.dataResult = paramList;
    if ((paramList != null) && (paramList.size() > 0))
    {
      setTotalCount(paramList.size());
      setTotalPage(getTotalCount() % this.pageSize == 0 ? getTotalCount() / this.pageSize : getTotalCount() / this.pageSize + 1);
    }
    setInvoiceXMLModels(paramInt);
  }
  
  private void setInvoiceXMLModels(int paramInt)
  {
    this.log.error("XML模板为:" + paramInt);
    if (1 == paramInt)
    {
      if (this.totalPage == 1)
      {
        this.invoicePageModels.add(setInvoicePageMode(this.xmlReader.template_invoice_pay_begin_and_end));
      }
      else if (this.totalPage == 2)
      {
        this.invoicePageModels.add(setInvoicePageMode(this.xmlReader.template_invoice_pay_begin));
        this.invoicePageModels.add(setInvoicePageMode(this.xmlReader.template_invoice_pay_end));
      }
      else if (this.totalPage >= 3)
      {
        this.invoicePageModels.add(setInvoicePageMode(this.xmlReader.template_invoice_pay_begin));
        this.invoicePageModels.add(setInvoicePageMode(this.xmlReader.template_invoice_pay_middle));
        this.invoicePageModels.add(setInvoicePageMode(this.xmlReader.template_invoice_pay_end));
      }
    }
    else if (3 == paramInt)
    {
      if (this.totalPage == 1)
      {
        this.invoicePageModels.add(setInvoicePageMode(this.xmlReader.template_invoice_pre_begin_and_end));
      }
      else if (this.totalPage == 2)
      {
        this.invoicePageModels.add(setInvoicePageMode(this.xmlReader.template_invoice_pre_begin));
        this.invoicePageModels.add(setInvoicePageMode(this.xmlReader.template_invoice_pre_end));
      }
      else if (this.totalPage >= 3)
      {
        this.invoicePageModels.add(setInvoicePageMode(this.xmlReader.template_invoice_pre_begin));
        this.invoicePageModels.add(setInvoicePageMode(this.xmlReader.template_invoice_pre_middle));
        this.invoicePageModels.add(setInvoicePageMode(this.xmlReader.template_invoice_pre_end));
      }
    }
    else if (2 == paramInt)
    {
      if (this.totalPage == 1)
      {
        this.invoicePageModels.add(setInvoicePageMode(this.xmlReader.template_invoice_total_begin_and_end));
      }
      else if (this.totalPage == 2)
      {
        this.invoicePageModels.add(setInvoicePageMode(this.xmlReader.template_invoice_total_begin));
        this.invoicePageModels.add(setInvoicePageMode(this.xmlReader.template_invoice_total_end));
      }
      else if (this.totalPage >= 3)
      {
        this.invoicePageModels.add(setInvoicePageMode(this.xmlReader.template_invoice_total_begin));
        this.invoicePageModels.add(setInvoicePageMode(this.xmlReader.template_invoice_total_middle));
        this.invoicePageModels.add(setInvoicePageMode(this.xmlReader.template_invoice_total_end));
      }
    }
    else if (5 == paramInt)
    {
      if (this.totalPage == 1)
      {
        this.invoicePageModels.add(setInvoicePageMode(this.xmlReader.template_invoice_ar_begin_and_end));
      }
      else if (this.totalPage == 2)
      {
        this.invoicePageModels.add(setInvoicePageMode(this.xmlReader.template_invoice_ar_begin));
        this.invoicePageModels.add(setInvoicePageMode(this.xmlReader.template_invoice_ar_end));
      }
      else if (this.totalPage >= 3)
      {
        this.invoicePageModels.add(setInvoicePageMode(this.xmlReader.template_invoice_ar_begin));
        this.invoicePageModels.add(setInvoicePageMode(this.xmlReader.template_invoice_ar_middle));
        this.invoicePageModels.add(setInvoicePageMode(this.xmlReader.template_invoice_ar_end));
      }
    }
    else if (6 == paramInt)
    {
      if (this.totalPage == 1)
      {
        this.invoicePageModels.add(setInvoicePageMode(this.xmlReader.template_invoice_rec_begin_and_end));
      }
      else if (this.totalPage == 2)
      {
        this.invoicePageModels.add(setInvoicePageMode(this.xmlReader.template_invoice_rec_begin));
        this.invoicePageModels.add(setInvoicePageMode(this.xmlReader.template_invoice_rec_end));
      }
      else if (this.totalPage >= 3)
      {
        this.invoicePageModels.add(setInvoicePageMode(this.xmlReader.template_invoice_rec_begin));
        this.invoicePageModels.add(setInvoicePageMode(this.xmlReader.template_invoice_rec_middle));
        this.invoicePageModels.add(setInvoicePageMode(this.xmlReader.template_invoice_rec_end));
      }
    }
    else if (4 == paramInt) {
      this.invoicePageModels.add(setInvoicePageMode(this.xmlReader.template_invoice_history_begin_and_end));
    }
  }
  
  public InvoicePageModel setInvoicePageMode(Map<String, InvoiceModel> paramMap)
  {
    InvoicePageModel localInvoicePageModel = new InvoicePageModel();
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    localHashMap2.putAll(paramMap);
    Object localObject = null;
    Set localSet = localHashMap2.keySet();
    Iterator localIterator = localSet.iterator();
    String str = "";
    InvoiceModel localInvoiceModel = null;
    while (localIterator.hasNext())
    {
      str = ((String)localIterator.next()).toString();
      localInvoiceModel = (InvoiceModel)localHashMap2.get(str);
      if (localInvoiceModel != null)
      {
        this.log.error("现可见的key值===" + str + ";对应的值为:" + localInvoiceModel.getModelUrl());
        if ("Model_Url".equals(str))
        {
          localInvoicePageModel.setModelUrl(localInvoiceModel.getModelUrl());
          localHashMap2.put(str, null);
        }
        if ("File_Path".equals(str))
        {
          localInvoicePageModel.setFilePath(localInvoiceModel.getFilePath());
          localHashMap2.put(str, null);
        }
        if (localInvoiceModel.getType() == 3) {
          ((InvoiceModel)localHashMap2.get(str)).setTag(true);
        }
        if (localInvoiceModel.getType() == 4) {
          ((InvoiceModel)localHashMap2.get(str)).setCodeTag(true);
        }
        if (localInvoiceModel.getTabNum() == 3)
        {
          localHashMap1.put(str, localInvoiceModel);
          localHashMap2.put(str, null);
        }
        if (localInvoiceModel.getType() == 5)
        {
          localObject = localInvoiceModel;
          localHashMap2.put(str, null);
        }
      }
    }
    localInvoicePageModel.setInvoiceListModels(localHashMap1);
    localInvoicePageModel.setInvoicePropertyModels(localHashMap2);
    localInvoicePageModel.setPageInvoiceModel(localObject);
    return localInvoicePageModel;
  }
  
  public void setInvoiceProperty(Map<String, InvoiceModel> paramMap)
  {
    this.listInvoice = new ArrayList();
    Invoice localInvoice = null;
    Set localSet = paramMap.keySet();
    Iterator localIterator = localSet.iterator();
    String str1 = "";
    Map localMap = EvsVoucherCheckService.getCurrencyCodeLabel();
    while (localIterator.hasNext())
    {
      str1 = ((String)localIterator.next()).toString();
      if (paramMap.get(str1) != null)
      {
        ((InvoiceModel)paramMap.get(str1)).setFont(setFont(((InvoiceModel)paramMap.get(str1)).getFontType()));
        ((InvoiceModel)paramMap.get(str1)).setFontSize(setFontSize(((InvoiceModel)paramMap.get(str1)).getFontType()));
        if (this.strList.containsKey(str1)) {
          if ((((InvoiceModel)paramMap.get(str1)).getType() == 8) && (((InvoiceModel)paramMap.get(str1)).getStrValue() != null)) {
            ((InvoiceModel)paramMap.get(str1)).setStrValue(StringUtils.formatDate((String)this.strList.get(str1), ((InvoiceModel)paramMap.get(str1)).getStrValue()));
          } else {
            ((InvoiceModel)paramMap.get(str1)).setStrValue((String)this.strList.get(str1));
          }
        }
        if ((this.invoice_type == 2) && (("BATCH_NAME".equals(((InvoiceModel)paramMap.get(str1)).getStrName())) || ("JOURNAL_SUB_NAME".equals(((InvoiceModel)paramMap.get(str1)).getStrName()))))
        {
          this.listInvoice.addAll(setValignTypeInvoice((InvoiceModel)paramMap.get(str1)));
        }
        else
        {
          localInvoice = new Invoice();
          localInvoice.setStrKey(str1);
          if (((InvoiceModel)paramMap.get(str1)).getCodeTag())
          {
            localInvoice.setDrawX(((InvoiceModel)paramMap.get(str1)).getEndX() - ((InvoiceModel)paramMap.get(str1)).getStartX());
            localInvoice.setDrawY(((InvoiceModel)paramMap.get(str1)).getEndY() - ((InvoiceModel)paramMap.get(str1)).getStartY());
          }
          localInvoice.setFont(((InvoiceModel)paramMap.get(str1)).getFont());
          if ((((InvoiceModel)paramMap.get(str1)).getStrValue() != null) && (!"null".equals(((InvoiceModel)paramMap.get(str1)).getStrValue())))
          {
            if (((InvoiceModel)paramMap.get(str1)).getType() == 6) {
              localInvoice.setStrValue(StringUtils.formatAmount(((InvoiceModel)paramMap.get(str1)).getStrValue()));
            } else if (((InvoiceModel)paramMap.get(str1)).getType() == 7) {
              try
              {
                if (!"CURRENCY_AMOUNT_CN".equals(str1)) {
                  if (("ACC_CR_CN".equals(str1)) || ("ACC_DR_CN".equals(str1)))
                  {
                    String str2 = (String)localMap.get("RMB");
                    localInvoice.setStrValue((str2 == null ? "" : str2) + StringUtils.numberToChinese(Double.parseDouble(((InvoiceModel)paramMap.get(str1)).getStrValue())));
                  }
                  else
                  {
                    localInvoice.setStrValue(StringUtils.numberToChinese(Double.parseDouble(((InvoiceModel)paramMap.get(str1)).getStrValue())));
                  }
                }
              }
              catch (Exception localException)
              {
                localException.printStackTrace();
                ((InvoiceModel)paramMap.get(str1)).setStrValue("");
              }
            } else {
              localInvoice.setStrValue(((InvoiceModel)paramMap.get(str1)).getStrValue());
            }
          }
          else {
            localInvoice.setStrValue("");
          }
          ((InvoiceModel)paramMap.get(str1)).setStrValue(localInvoice.getStrValue());
          localInvoice.setWriteY(setValignType((InvoiceModel)paramMap.get(str1)));
          if ("ACC_CR_CN,CURRENCY_AMOUNT_CN".indexOf(str1) > -1)
          {
            this.listInvoice.addAll(setValignTypeInvoice((InvoiceModel)paramMap.get(str1)));
          }
          else
          {
            localInvoice.setWriteX(setAlignType((InvoiceModel)paramMap.get(str1)));
            localInvoice.setTag(((InvoiceModel)paramMap.get(str1)).getTag());
            localInvoice.setCodeTag(((InvoiceModel)paramMap.get(str1)).getCodeTag());
            this.listInvoice.add(localInvoice);
          }
        }
      }
    }
  }
  
  public void setInvoicePropertyHis(Map<String, InvoiceModel> paramMap)
  {
    this.listInvoice = new ArrayList();
    Invoice localInvoice = null;
    Set localSet = paramMap.keySet();
    Iterator localIterator = localSet.iterator();
    String str = "";
    while (localIterator.hasNext())
    {
      str = ((String)localIterator.next()).toString();
      if (paramMap.get(str) != null)
      {
        ((InvoiceModel)paramMap.get(str)).setFont(setFont(((InvoiceModel)paramMap.get(str)).getFontType()));
        ((InvoiceModel)paramMap.get(str)).setFontSize(setFontSize(((InvoiceModel)paramMap.get(str)).getFontType()));
        if (this.strList.containsKey(str))
        {
          if ((((InvoiceModel)paramMap.get(str)).getType() == 8) && (((InvoiceModel)paramMap.get(str)).getStrValue() != null))
          {
            if (this.strList.get(str) != null) {
              ((InvoiceModel)paramMap.get(str)).setStrValue(StringUtils.formatDate((String)this.strList.get(str), ((InvoiceModel)paramMap.get(str)).getStrValue()));
            } else {
              ((InvoiceModel)paramMap.get(str)).setStrValue("");
            }
          }
          else {
            ((InvoiceModel)paramMap.get(str)).setStrValue((String)this.strList.get(str));
          }
          this.listInvoice.addAll(setValignTypeInvoice((InvoiceModel)paramMap.get(str)));
        }
        else
        {
          localInvoice = new Invoice();
          localInvoice.setWriteY(setValignType((InvoiceModel)paramMap.get(str)));
          localInvoice.setWriteX(setAlignType((InvoiceModel)paramMap.get(str)));
          localInvoice.setFont(((InvoiceModel)paramMap.get(str)).getFont());
          if ((((InvoiceModel)paramMap.get(str)).getStrValue() != null) && (!"null".equals(((InvoiceModel)paramMap.get(str)).getStrValue()))) {
            localInvoice.setStrValue(((InvoiceModel)paramMap.get(str)).getStrValue());
          } else {
            localInvoice.setStrValue("");
          }
          localInvoice.setTag(((InvoiceModel)paramMap.get(str)).getTag());
          localInvoice.setCodeTag(((InvoiceModel)paramMap.get(str)).getCodeTag());
          this.listInvoice.add(localInvoice);
        }
      }
    }
  }
  
  public int setAlignType(InvoiceModel paramInvoiceModel)
  {
    int i = paramInvoiceModel.getStartX();
    if ((paramInvoiceModel != null) && ("CURRENCY_AMOUNT".equals(paramInvoiceModel.getStrName()))) {
      System.out.println(paramInvoiceModel.getStrName());
    }
    if ((!paramInvoiceModel.getTag()) && (!paramInvoiceModel.getCodeTag())) {
      if (paramInvoiceModel.getType() == 6)
      {
        int j = getSubSize(paramInvoiceModel);
        if (paramInvoiceModel.getAlignType().equals("LEFT")) {
          i = paramInvoiceModel.getStartX() + 1;
        }
        if (paramInvoiceModel.getAlignType().equals("RIGHT")) {
          i = paramInvoiceModel.getEndX() - paramInvoiceModel.getStrValue().getBytes().length * (paramInvoiceModel.getFontSize() / 2) - paramInvoiceModel.getFontSize() / 2 - j;
        }
        if (paramInvoiceModel.getAlignType().equals("CENTER")) {
          i = paramInvoiceModel.getStartX() + (paramInvoiceModel.getEndX() - paramInvoiceModel.getStartX() - paramInvoiceModel.getStrValue().getBytes().length * paramInvoiceModel.getFontSize() / 2) / 2;
        }
      }
      else
      {
        if (paramInvoiceModel.getAlignType().equals("LEFT")) {
          i = paramInvoiceModel.getStartX() + 1;
        }
        if (paramInvoiceModel.getAlignType().equals("RIGHT")) {
          i = paramInvoiceModel.getEndX() - paramInvoiceModel.getStrValue().getBytes().length * (paramInvoiceModel.getFontSize() / 2) - paramInvoiceModel.getFontSize() / 2;
        }
        if (paramInvoiceModel.getAlignType().equals("CENTER")) {
          i = paramInvoiceModel.getStartX() + (paramInvoiceModel.getEndX() - paramInvoiceModel.getStartX() - paramInvoiceModel.getStrValue().getBytes().length * paramInvoiceModel.getFontSize() / 2) / 2;
        }
      }
    }
    return i;
  }
  
  public int setValignType(InvoiceModel paramInvoiceModel)
  {
    int i = paramInvoiceModel.getStartY();
    if ((!paramInvoiceModel.getTag()) && (!paramInvoiceModel.getCodeTag()))
    {
      if (paramInvoiceModel.getValignType().equals("TOP")) {
        i = paramInvoiceModel.getStartY() + 1 + paramInvoiceModel.getFontSize();
      }
      if (paramInvoiceModel.getValignType().equals("BUTTOM")) {
        i = paramInvoiceModel.getEndY() - 1;
      }
      if (paramInvoiceModel.getValignType().equals("MIDDLE")) {
        i = paramInvoiceModel.getEndY() - (paramInvoiceModel.getEndY() - paramInvoiceModel.getStartY() - paramInvoiceModel.getFontSize()) / 2;
      }
    }
    return i;
  }
  
  private int getSubSize(InvoiceModel paramInvoiceModel)
  {
    int i = 0;
    if ((paramInvoiceModel.getStrValue() != null) && (paramInvoiceModel.getType() == 6))
    {
      int j = paramInvoiceModel.getStrValue().getBytes().length;
      if (j > 11) {
        i = 9;
      } else if (j > 9) {
        i = 6;
      } else if (j > 7) {
        i = 4;
      } else if (j > 5) {
        i = 2;
      }
    }
    i = 0;
    return i;
  }
  
  public List<Invoice> setValignTypeInvoice(InvoiceModel paramInvoiceModel)
  {
    ArrayList localArrayList = new ArrayList();
    if ((!paramInvoiceModel.getTag()) && (!paramInvoiceModel.getCodeTag()) && (paramInvoiceModel.getStrValue() != null))
    {
      StringBuffer localStringBuffer = new StringBuffer(paramInvoiceModel.getStrValue());
      int i = getSubSize(paramInvoiceModel);
      if ((paramInvoiceModel != null) && ("CURRENCY_AMOUNT".equals(paramInvoiceModel.getStrName()))) {
        System.out.println(paramInvoiceModel.getStrName());
      }
      Object localObject;
      if ((localStringBuffer != null) && (paramInvoiceModel.getStrValue().getBytes().length * paramInvoiceModel.getFontSize() / 2 + i > paramInvoiceModel.getEndX() - paramInvoiceModel.getStartX()))
      {
        localObject = splitStrValues(paramInvoiceModel);
        Invoice localInvoice = null;
        int j = ((List)localObject).size();
        int k = paramInvoiceModel.getEndY() - paramInvoiceModel.getStartY();
        int m = k <= j * paramInvoiceModel.getFontSize() + (j - 1) ? paramInvoiceModel.getStartY() + (j - 1) / 2 : (k - (j * paramInvoiceModel.getFontSize() + (j - 1))) / 2 + paramInvoiceModel.getStartY();
        if ("TOP".equals(paramInvoiceModel.getValignType())) {
          m = paramInvoiceModel.getStartY();
        } else if ("BUTTOM".equals(paramInvoiceModel.getValignType())) {
          m = k <= j * paramInvoiceModel.getFontSize() + (j - 1) ? paramInvoiceModel.getStartY() : k - (j * paramInvoiceModel.getFontSize() + (j - 1)) + paramInvoiceModel.getStartY();
        }
        for (int n = 0; n < ((List)localObject).size(); n++)
        {
          localInvoice = new Invoice();
          localInvoice.setFont(paramInvoiceModel.getFont());
          localInvoice.setTag(paramInvoiceModel.getTag());
          localInvoice.setCodeTag(paramInvoiceModel.getCodeTag());
          localInvoice.setStrValue(((String)((List)localObject).get(n)).toString());
          localInvoice.setWriteX(setAlignType(paramInvoiceModel));
          localInvoice.setStrKey(paramInvoiceModel.getStrName());
          localInvoice.setWriteY(m + (n + 1) * paramInvoiceModel.getFontSize());
          localArrayList.add(localInvoice);
        }
      }
      else
      {
        localObject = new Invoice();
        ((Invoice)localObject).setFont(paramInvoiceModel.getFont());
        ((Invoice)localObject).setStrValue(paramInvoiceModel.getStrValue());
        ((Invoice)localObject).setStrKey(paramInvoiceModel.getStrName());
        ((Invoice)localObject).setTag(paramInvoiceModel.getTag());
        ((Invoice)localObject).setCodeTag(paramInvoiceModel.getCodeTag());
        ((Invoice)localObject).setWriteX(setAlignType(paramInvoiceModel));
        ((Invoice)localObject).setWriteY(setValignType(paramInvoiceModel));
        localArrayList.add(localObject);
      }
    }
    return localArrayList;
  }
  
  private List<String> splitStrValues(InvoiceModel paramInvoiceModel)
  {
    ArrayList localArrayList = new ArrayList();
    String str1 = paramInvoiceModel.getStrValue();
    int i = getSubSize(paramInvoiceModel);
    int j = str1.getBytes().length * (paramInvoiceModel.getFontSize() / 2) + i;
    int k = paramInvoiceModel.getEndX() - paramInvoiceModel.getStartX();
    int m = j / k + (j % k == 0 ? 0 : 1);
    StringBuffer localStringBuffer1 = new StringBuffer(str1);
    StringBuffer localStringBuffer2 = new StringBuffer();
    int n = (paramInvoiceModel.getEndY() - paramInvoiceModel.getStartY()) / paramInvoiceModel.getFontSize();
    n = n > 0 ? n : 1;
    int i1 = k / (paramInvoiceModel.getFontSize() / 2);
    String str2 = "";
    int i2 = 0;
    for (int i3 = 0; i3 < m; i3++)
    {
      for (int i4 = 0; (i4 < i1) && (localStringBuffer1.length() > 0); i4++)
      {
        str2 = localStringBuffer1.substring(0, 1);
        if (str2.length() != str2.getBytes().length) {
          i2 += 2;
        } else {
          i2++;
        }
        if (i2 >= i1) {
          break;
        }
        localStringBuffer2.append(str2);
        localStringBuffer1.delete(0, 1);
      }
      if (localStringBuffer2 != null)
      {
        localArrayList.add(localStringBuffer2.toString());
        localStringBuffer2 = new StringBuffer();
      }
      i2 = 0;
      localStringBuffer2 = new StringBuffer();
      if (n == localArrayList.size()) {
        return localArrayList;
      }
    }
    return localArrayList;
  }
  
  public Font setFont(int paramInt)
  {
    Font localFont = null;
    switch (paramInt)
    {
    case 0: 
    case 1: 
      localFont = new Font("宋体", 0, 13);
      break;
    case 2: 
      localFont = new Font("宋体", 0, 13);
      break;
    case 3: 
      localFont = new Font("宋体", 0, 13);
      break;
    case 4: 
      localFont = new Font("宋体", 0, 13);
      break;
    case 5: 
      localFont = new Font("黑体", 0, 13);
      break;
    case 6: 
      localFont = new Font("黑体", 0, 13);
      break;
    case 7: 
      localFont = new Font("黑体", 0, 12);
    }
    return localFont;
  }
  
  public int setFontSize(int paramInt)
  {
    int i = 30;
    switch (paramInt)
    {
    case 0: 
    case 1: 
      break;
    case 2: 
      i = 13;
      break;
    case 3: 
      i = 13;
      break;
    case 4: 
      i = 13;
      break;
    case 5: 
      i = 13;
      break;
    case 6: 
      i = 13;
      break;
    case 7: 
      i = 12;
    }
    return i;
  }
  
  private InvoicePageContext setInvoicePageContext(InvoicePageModel paramInvoicePageModel)
  {
    InvoicePageContext localInvoicePageContext = new InvoicePageContext();
    this.invoiceOnePage = new ArrayList();
    if (4 == this.invoice_type) {
      setInvoicePropertyHis(paramInvoicePageModel.getInvoicePropertyModels());
    } else {
      setInvoiceProperty(paramInvoicePageModel.getInvoicePropertyModels());
    }
    this.invoiceOnePage = this.listInvoice;
    setPageInvoiceModel(paramInvoicePageModel.getPageInvoiceModel());
    if (4 == this.invoice_type) {
      localInvoicePageContext.setInvoiceLine(setInvoiceListTables(paramInvoicePageModel.getInvoiceListModels()));
    }
    setInvoiceListModels(paramInvoicePageModel.getInvoiceListModels());
    localInvoicePageContext.setInvoice(this.invoiceOnePage);
    localInvoicePageContext.setCurPage(this.curPage - 1 > 1 ? this.curPage - 1 : 1);
    localInvoicePageContext.setTotalCount(this.totalCount);
    localInvoicePageContext.setTotalPage(this.totalPage);
    localInvoicePageContext.setModelUrl(paramInvoicePageModel.getModelUrl());
    localInvoicePageContext.setFilePath(paramInvoicePageModel.getFilePath());
    return localInvoicePageContext;
  }
  
  private void setPageInvoiceModel(InvoiceModel paramInvoiceModel)
  {
    if (paramInvoiceModel != null)
    {
      InvoiceModel localInvoiceModel = new InvoiceModel(paramInvoiceModel.getStartX(), paramInvoiceModel.getStartY(), paramInvoiceModel.getEndX(), paramInvoiceModel.getEndY(), paramInvoiceModel.getTag(), paramInvoiceModel.getCodeTag(), paramInvoiceModel.getFontSize(), paramInvoiceModel.getFontType(), paramInvoiceModel.getFont(), paramInvoiceModel.getType(), paramInvoiceModel.getTabNum(), paramInvoiceModel.getStrName(), paramInvoiceModel.getAlignType(), paramInvoiceModel.getValignType(), paramInvoiceModel.getStrValue(), paramInvoiceModel.getModelUrl(), paramInvoiceModel.getFilePath());
      String str = localInvoiceModel.getStrValue();
      str = str.replaceAll("&p", " " + this.curPage + " ");
      str = str.replaceAll("&t", " " + this.totalPage + " ");
      localInvoiceModel.setStrValue(str);
      localInvoiceModel.setFont(setFont(localInvoiceModel.getFontType()));
      localInvoiceModel.setFontSize(setFontSize(localInvoiceModel.getFontType()));
      Invoice localInvoice = new Invoice();
      localInvoice.setWriteY(setValignType(localInvoiceModel));
      localInvoice.setWriteX(setAlignType(localInvoiceModel));
      localInvoice.setFont(localInvoiceModel.getFont());
      localInvoice.setStrValue(str);
      this.invoiceOnePage.add(localInvoice);
    }
  }
  
  private void setInvoiceListModels(Map<String, InvoiceModel> paramMap)
  {
    Object localObject = null;
    int i = 0;
    int j = 1;
    int k = 0;
    int m = 0;
    int n = 5;
    for (int i1 = (this.curPage - 1) * this.pageSize; i1 < (this.curPage * this.pageSize < this.totalCount ? this.curPage * this.pageSize : this.totalCount); i1++)
    {
      localObject = new HashMap();
      localObject = (Map)this.dataResult.get(i1);
      Set localSet = paramMap.keySet();
      Iterator localIterator = localSet.iterator();
      String str = "";
      while (localIterator.hasNext())
      {
        str = ((String)localIterator.next()).toString();
        if (paramMap.get(str) != null)
        {
          InvoiceModel localInvoiceModel = new InvoiceModel(((InvoiceModel)paramMap.get(str)).getStartX(), ((InvoiceModel)paramMap.get(str)).getStartY(), ((InvoiceModel)paramMap.get(str)).getEndX(), ((InvoiceModel)paramMap.get(str)).getEndY(), ((InvoiceModel)paramMap.get(str)).getTag(), ((InvoiceModel)paramMap.get(str)).getCodeTag(), ((InvoiceModel)paramMap.get(str)).getFontSize(), ((InvoiceModel)paramMap.get(str)).getFontType(), ((InvoiceModel)paramMap.get(str)).getFont(), ((InvoiceModel)paramMap.get(str)).getType(), ((InvoiceModel)paramMap.get(str)).getTabNum(), ((InvoiceModel)paramMap.get(str)).getStrName(), ((InvoiceModel)paramMap.get(str)).getAlignType(), ((InvoiceModel)paramMap.get(str)).getValignType(), ((InvoiceModel)paramMap.get(str)).getStrValue(), ((InvoiceModel)paramMap.get(str)).getModelUrl(), ((InvoiceModel)paramMap.get(str)).getFilePath());
          if (j != 0)
          {
            k = localInvoiceModel.getStartY();
            m = localInvoiceModel.getEndY();
            j = 0;
          }
          localInvoiceModel.setFont(setFont(localInvoiceModel.getFontType()));
          localInvoiceModel.setFontSize(setFontSize(localInvoiceModel.getFontType()));
          if ((((Map)localObject).get(str) != null) && (!"null".equals(((Map)localObject).get(str))))
          {
            if (localInvoiceModel.getType() == 6) {
              localInvoiceModel.setStrValue(StringUtils.formatAmount((String)((Map)localObject).get(str)));
            } else {
              localInvoiceModel.setStrValue((String)((Map)localObject).get(str));
            }
          }
          else {
            localInvoiceModel.setStrValue("");
          }
          localInvoiceModel.setStartY(k + (m - k) * i + i * n);
          localInvoiceModel.setEndY(m + (m - k) * i + i * n);
          this.invoiceOnePage.addAll(setValignTypeInvoice(localInvoiceModel));
        }
      }
      i++;
    }
    this.curPage += 1;
  }
  
  private List<InvoiceLine> setInvoiceListTables(Map<String, InvoiceModel> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 1;
    int j = 0;
    int k = 0;
    for (int m = 0; m < (this.totalCount <= this.pageSize ? this.totalCount : this.pageSize); m++)
    {
      InvoiceLine localInvoiceLine = null;
      Set localSet = paramMap.keySet();
      Iterator localIterator = localSet.iterator();
      String str = "";
      while (localIterator.hasNext())
      {
        str = ((String)localIterator.next()).toString();
        if (paramMap.get(str) != null)
        {
          InvoiceModel localInvoiceModel = new InvoiceModel(((InvoiceModel)paramMap.get(str)).getStartX(), ((InvoiceModel)paramMap.get(str)).getStartY(), ((InvoiceModel)paramMap.get(str)).getEndX(), ((InvoiceModel)paramMap.get(str)).getEndY(), ((InvoiceModel)paramMap.get(str)).getTag(), ((InvoiceModel)paramMap.get(str)).getCodeTag(), ((InvoiceModel)paramMap.get(str)).getFontSize(), ((InvoiceModel)paramMap.get(str)).getFontType(), ((InvoiceModel)paramMap.get(str)).getFont(), ((InvoiceModel)paramMap.get(str)).getType(), ((InvoiceModel)paramMap.get(str)).getTabNum(), ((InvoiceModel)paramMap.get(str)).getStrName(), ((InvoiceModel)paramMap.get(str)).getAlignType(), ((InvoiceModel)paramMap.get(str)).getValignType(), ((InvoiceModel)paramMap.get(str)).getStrValue(), ((InvoiceModel)paramMap.get(str)).getModelUrl(), ((InvoiceModel)paramMap.get(str)).getFilePath());
          if (i != 0)
          {
            j = localInvoiceModel.getStartY();
            k = localInvoiceModel.getEndY();
            i = 0;
          }
          localInvoiceLine = new InvoiceLine(localInvoiceModel.getStartX(), j + (k - j) * m, localInvoiceModel.getEndX(), k + (k - j) * m, 4);
          localArrayList.add(localInvoiceLine);
        }
      }
    }
    return localArrayList;
  }
  
  public List<InvoicePageContext> getInvoicePageContext()
  {
    if (this.invoicePageModels == null) {
      return null;
    }
    if (this.totalPage > 1) {
      for (int i = 1; i <= this.totalPage; i++) {
        if (i == 1)
        {
          if (this.invoicePageModels.get(0) != null) {
            addToInvoicePageContexts(setInvoicePageContext((InvoicePageModel)this.invoicePageModels.get(0)));
          }
        }
        else if (i == this.totalPage)
        {
          if (i == 2)
          {
            if (this.invoicePageModels.get(1) != null) {
              addToInvoicePageContexts(setInvoicePageContext((InvoicePageModel)this.invoicePageModels.get(1)));
            }
          }
          else if (this.invoicePageModels.get(2) != null) {
            addToInvoicePageContexts(setInvoicePageContext((InvoicePageModel)this.invoicePageModels.get(2)));
          }
        }
        else if (this.invoicePageModels.get(1) != null) {
          addToInvoicePageContexts(setInvoicePageContext((InvoicePageModel)this.invoicePageModels.get(1)));
        }
      }
    } else if ((this.totalPage == 1) && (this.invoicePageModels.get(0) != null)) {
      addToInvoicePageContexts(setInvoicePageContext((InvoicePageModel)this.invoicePageModels.get(0)));
    }
    return this.invoicePageContexts;
  }
  
  private void addToInvoicePageContexts(InvoicePageContext paramInvoicePageContext)
  {
    this.invoicePageContexts.add(paramInvoicePageContext);
  }
  
  public int getTotalPage()
  {
    return this.totalPage;
  }
  
  public void setTotalPage(int paramInt)
  {
    this.totalPage = paramInt;
  }
  
  public int getTotalCount()
  {
    return this.totalCount;
  }
  
  public void setTotalCount(int paramInt)
  {
    this.totalCount = paramInt;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.common.invoice.util.InvoiceImage
 * JD-Core Version:    0.7.0.1
 */