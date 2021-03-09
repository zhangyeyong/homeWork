package com.zte.eas.hnyd.business.print.service;

import com.zte.eas.hnyd.business.print.model.CommonPrintModel;
import com.zte.eas.report.business.print.service.IFinancePrintService;
import com.zte.evs.ebill.business.archives.IFbpArchivesHeadersDS;
import com.zte.evs.ebill.business.archives.IFbpArchivesLinesDS;
import com.zte.evs.ebill.model.archives.FbpArchivesHeadersV;
import com.zte.evs.ebill.model.archives.FbpArchivesLinesV;
import com.zte.ssb.framework.SSBBus;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class AchervsPrintService
  implements IFinancePrintService
{
  public static final String BANKROLL_MANAGE = "档案管理";
  public static final String BIGINTEGER = "BigInteger";
  public static final String BIGDECIMAL = "BigDecimal";
  private double applyAmount = 0.0D;
  public static final String EXPENSEAMOUNT = "getexpenseamount";
  
  public Object getFinancePrintModel(String paramString, List paramList)
  {
    CommonPrintModel localCommonPrintModel = new CommonPrintModel(paramString);
    FbpArchivesHeadersV localFbpArchivesHeadersV = new FbpArchivesHeadersV();
    try
    {
      IFbpArchivesHeadersDS localIFbpArchivesHeadersDS = (IFbpArchivesHeadersDS)SSBBus.findDomainService("fbpArchivesHeadersDS");
      localFbpArchivesHeadersV = localIFbpArchivesHeadersDS.findFbpArchivesHeadersV(Long.valueOf(Long.parseLong(paramString)));
      Object localObject1 = new ArrayList();
      IFbpArchivesLinesDS localIFbpArchivesLinesDS = (IFbpArchivesLinesDS)SSBBus.findDomainService("fbpArchivesLinesDS");
      if ((localFbpArchivesHeadersV != null) && (localFbpArchivesHeadersV.getArchivesHeaderId() != null))
      {
        localObject1 = localIFbpArchivesLinesDS.findFbpArchivesLinessV(Long.valueOf(Long.parseLong(paramString)));
        localObject2 = new StringBuffer();
        int i = 1;
        Iterator localIterator = ((List)localObject1).iterator();
        while (localIterator.hasNext())
        {
          FbpArchivesLinesV localFbpArchivesLinesV = (FbpArchivesLinesV)localIterator.next();
          if ((null == localFbpArchivesLinesV.getAttribute2()) || ("".equals(localFbpArchivesLinesV.getAttribute2()))) {
            localFbpArchivesLinesV.setAttribute2("");
          }
          ((StringBuffer)localObject2).append("<tr><td  height='25'>" + i++ + "</td>" + "<td >" + localFbpArchivesLinesV.getJournalNum() + "</td>" + "<td >" + localFbpArchivesLinesV.getDateAttribute1() + "</td>" + "<td >" + localFbpArchivesLinesV.getDateAttribute2() + "</td>" + "<td >" + localFbpArchivesLinesV.getAttribute2() + "</td>" + "</tr>");
        }
        localCommonPrintModel.setCommonLineHtml(((StringBuffer)localObject2).toString());
      }
      localCommonPrintModel.setHApplyAmount(String.valueOf(this.applyAmount));
      localCommonPrintModel.setHBoeNum(localFbpArchivesHeadersV.getApplyNum());
      localCommonPrintModel.setHBoeAbstract(localFbpArchivesHeadersV.getApplyDesc());
      localCommonPrintModel.setHEmail(localFbpArchivesHeadersV.getEmailAddress());
      localCommonPrintModel.setHBApplyAmount(localCommonPrintModel.getHApplyAmount());
      commonHeaders(localCommonPrintModel, localFbpArchivesHeadersV);
      Object localObject2 = new SimpleDateFormat("yyyy-MM-dd");
      localCommonPrintModel.setHCreationDate(((SimpleDateFormat)localObject2).format(localFbpArchivesHeadersV.getCreationDate()));
      localCommonPrintModel.setHLastUpdateDate(((SimpleDateFormat)localObject2).format(localFbpArchivesHeadersV.getApplyDate()));
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localCommonPrintModel;
  }
  
  private void changePaymentType(CommonPrintModel paramCommonPrintModel)
  {
    if ((paramCommonPrintModel.getHPaymentStatusCode() != null) && (paramCommonPrintModel.getHPaymentStatusCode().equals("Y"))) {
      paramCommonPrintModel.setHPaymentStatusCode("已付款");
    } else {
      paramCommonPrintModel.setHPaymentStatusCode("未付款");
    }
  }
  
  private void commonHeaders(CommonPrintModel paramCommonPrintModel, Object paramObject)
    throws Exception
  {
    if (paramObject != null)
    {
      Class localClass1 = paramObject.getClass();
      Class localClass2 = paramCommonPrintModel.getClass();
      Field[] arrayOfField = localClass2.getFields();
      Method[] arrayOfMethod = localClass1.getMethods();
      for (int i = 0; i < arrayOfField.length; i++)
      {
        String str1 = arrayOfField[i].getName();
        if (!str1.equals(""))
        {
          String str2 = "get" + str1.substring(1);
          String str3 = "setH" + str1.substring(1);
          for (int j = 0; j < arrayOfMethod.length; j++)
          {
            Method localMethod1 = arrayOfMethod[j];
            if (str2.toLowerCase().equals(localMethod1.getName().toLowerCase()))
            {
              Object localObject = localMethod1.invoke(paramObject, new Object[0]);
              if (localObject != null)
              {
                String str4 = localObject.toString();
                Method localMethod2 = localClass2.getMethod(str3, new Class[] { String.class });
                if (localMethod2 != null) {
                  localMethod2.invoke(paramCommonPrintModel, new Object[] { str4 });
                } else {
                  arrayOfField[i].set(paramCommonPrintModel, str4);
                }
              }
            }
          }
        }
      }
    }
  }
  
  private void commonLineTable(List paramList1, CommonPrintModel paramCommonPrintModel, List paramList2)
    throws Exception
  {
    if ((paramList1 != null) && (paramList1.size() > 0))
    {
      int i = 1;
      LinkedHashSet localLinkedHashSet = new LinkedHashSet();
      StringBuffer localStringBuffer = new StringBuffer();
      for (int j = 0; j < paramList1.size(); j++)
      {
        localStringBuffer.append("<tr><td>" + i++ + "</td>");
        Object localObject1 = paramList1.get(j);
        Class localClass = localObject1.getClass();
        Field[] arrayOfField = localClass.getDeclaredFields();
        Method[] arrayOfMethod = localClass.getMethods();
        HashMap localHashMap1 = (HashMap)paramList2.get(0);
        HashMap localHashMap2 = (HashMap)paramList2.get(1);
        HashMap localHashMap3 = (HashMap)paramList2.get(2);
        for (int k = 0; k < localHashMap1.size(); k++)
        {
          String str = "get" + (String)localHashMap1.get(String.valueOf(k));
          for (int m = 0; m < arrayOfMethod.length; m++)
          {
            Method localMethod = arrayOfMethod[m];
            if (str.equalsIgnoreCase(localMethod.getName()))
            {
              Object localObject2 = localMethod.invoke(localObject1, new Object[0]);
              if (localObject2 != null)
              {
                if ((localHashMap2.get(String.valueOf(k)) != null) && ("T".trim().equals(localHashMap2.get(String.valueOf(k)))))
                {
                  localStringBuffer.append("<td>" + formatMoney(localObject2) + "</td>");
                  localLinkedHashSet.add(localMethod.getName());
                  break;
                }
                if ((localHashMap3.get(String.valueOf(k)) != null) && ("T".trim().equals(localHashMap3.get(String.valueOf(k)))))
                {
                  localStringBuffer.append("<td>" + formatDate(localObject2) + "</td>");
                  break;
                }
                localStringBuffer.append("<td>" + nullToString(localObject2) + "</td>");
                break;
              }
              if ((localHashMap2.get(String.valueOf(k)) != null) && ("T".trim().equals(localHashMap2.get(String.valueOf(k))))) {
                localLinkedHashSet.add(localMethod.getName());
              }
              localStringBuffer.append("<td></td>");
            }
          }
        }
        localStringBuffer.append("</tr>");
      }
      totalCount(paramList1, paramCommonPrintModel, localLinkedHashSet);
      paramCommonPrintModel.setCommonLineHtml(localStringBuffer.toString());
    }
  }
  
  private void lineAmountTotle(List paramList)
    throws Exception
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      for (int i = 0; i < paramList.size(); i++)
      {
        Object localObject1 = paramList.get(i);
        Class localClass = localObject1.getClass();
        Method[] arrayOfMethod = localClass.getMethods();
        for (int j = 0; j < arrayOfMethod.length; j++)
        {
          Method localMethod = arrayOfMethod[j];
          if ("getexpenseamount".equalsIgnoreCase(localMethod.getName()))
          {
            Object localObject2 = localMethod.invoke(localObject1, new Object[0]);
            if (localObject2 != null) {
              this.applyAmount += Double.parseDouble(localObject2.toString());
            }
          }
        }
      }
    }
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
  
  private void totalCount(List paramList, CommonPrintModel paramCommonPrintModel, Set paramSet)
    throws Exception
  {
    double d1 = 0.0D;
    double d2 = 0.0D;
    double d3 = 0.0D;
    double d4 = 0.0D;
    double d5 = 0.0D;
    double d6 = 0.0D;
    int i = 0;
    if (paramSet.isEmpty())
    {
      paramCommonPrintModel.setCommonTotal1(String.valueOf(d1));
    }
    else
    {
      Iterator localIterator = paramSet.iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        i += 1;
        for (int j = 0; j < paramList.size(); j++)
        {
          Object localObject1 = paramList.get(j);
          Class localClass = localObject1.getClass();
          Method[] arrayOfMethod = localClass.getMethods();
          for (int k = 0; k < arrayOfMethod.length; k++)
          {
            Method localMethod = arrayOfMethod[k];
            if (str1.equalsIgnoreCase(localMethod.getName()))
            {
              String str2 = localMethod.getReturnType().toString();
              switch (i)
              {
              case 1: 
                Object localObject2 = localMethod.invoke(localObject1, new Object[0]);
                d1 += moneyTypeValue(str2, localObject2);
                break;
              case 2: 
                Object localObject3 = localMethod.invoke(localObject1, new Object[0]);
                d2 += moneyTypeValue(str2, localObject3);
                break;
              case 3: 
                Object localObject4 = localMethod.invoke(localObject1, new Object[0]);
                d3 += moneyTypeValue(str2, localObject4);
                break;
              case 4: 
                Object localObject5 = localMethod.invoke(localObject1, new Object[0]);
                d4 += moneyTypeValue(str2, localObject5);
                break;
              case 5: 
                Object localObject6 = localMethod.invoke(localObject1, new Object[0]);
                d5 += moneyTypeValue(str2, localObject6);
                break;
              case 6: 
                Object localObject7 = localMethod.invoke(localObject1, new Object[0]);
                d6 += moneyTypeValue(str2, localObject7);
              }
            }
          }
        }
      }
    }
    paramCommonPrintModel.setCommonTotal1(formatMoney(Double.valueOf(d1)));
    paramCommonPrintModel.setCommonTotal2(formatMoney(Double.valueOf(d2)));
    paramCommonPrintModel.setCommonTotal3(formatMoney(Double.valueOf(d3)));
    paramCommonPrintModel.setCommonTotal4(formatMoney(Double.valueOf(d4)));
    paramCommonPrintModel.setCommonTotal5(formatMoney(Double.valueOf(d5)));
    paramCommonPrintModel.setCommonTotal6(formatMoney(Double.valueOf(d6)));
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
    else if ((paramString.indexOf("BigDecimal") > -1) && (paramObject != null) && (!"".equals(paramObject))) {
      d = ((BigDecimal)paramObject).doubleValue();
    }
    return d;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.hnyd.business.print.service.AchervsPrintService
 * JD-Core Version:    0.7.0.1
 */