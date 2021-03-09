package com.zte.eas.hnyd.business.print.model;

import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Trans2RMB
{
  public static void main(String[] paramArrayOfString)
  {
    System.out.println("\n--------将数字转换成中文金额的大写形式------------\n");
    Trans2RMB localTrans2RMB = new Trans2RMB();
    String str = localTrans2RMB.cleanZero(localTrans2RMB.splitNum(localTrans2RMB.roundString(localTrans2RMB.getNum())));
    if (!"".equals(str)) {
      System.out.println("转换成中文后为：" + str);
    }
    System.out.println("\n---------------------------------------------");
  }
  
  public String getNum()
  {
    String str = null;
    System.out.println("请输入一个数字（精确到小数点后两位）：");
    Scanner localScanner = new Scanner(System.in);
    str = localScanner.next();
    localScanner.close();
    if (checkNum(str)) {
      return str;
    }
    return "";
  }
  
  public boolean checkNum(String paramString)
  {
    try
    {
      float f = Float.valueOf(paramString).floatValue();
      if (f < 0.0F)
      {
        System.out.println("非法数据，请检查！");
        return false;
      }
      return true;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      System.out.println("非法数据，请检查！");
    }
    return false;
  }
  
  public String splitNum(String paramString)
  {
    if ("".equals(paramString)) {
      return "";
    }
    int i = paramString.indexOf(".");
    String str1 = paramString.substring(0, i);
    String str2 = numFormat(1, str1);
    String str3 = paramString.substring(i + 1);
    String str4 = numFormat(2, str3);
    String str5 = str2 + str4;
    return str5;
  }
  
  public String roundString(String paramString)
  {
    if ("".equals(paramString)) {
      return "";
    }
    double d = Double.parseDouble(paramString);
    d = (d * 100.0D + 0.5D) / 100.0D;
    paramString = new DecimalFormat("##0.000").format(d);
    int i = paramString.indexOf(".");
    String str1 = paramString.substring(0, i);
    if (str1.length() > 13)
    {
      System.out.println("输入数据过大！（整数部分最多13位！）");
      return "";
    }
    String str2 = paramString.substring(i + 1);
    if (str2.length() > 2)
    {
      String str3 = str2.substring(0, 2);
      paramString = str1 + "." + str3;
    }
    return paramString;
  }
  
  public String numFormat(int paramInt, String paramString)
  {
    int i = paramString.length();
    String[] arrayOfString1 = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
    String[] arrayOfString2 = { "元", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "万" };
    String[] arrayOfString3 = { "分", "角" };
    String str = "";
    for (int j = 0; j < i; j++) {
      if (paramInt == 1) {
        str = str + arrayOfString1[(paramString.charAt(j) - '0')] + arrayOfString2[(i - j - 1)];
      } else if (paramInt == 2) {
        str = str + arrayOfString1[(paramString.charAt(j) - '0')] + arrayOfString3[(i - j - 1)];
      }
    }
    return str;
  }
  
  public String cleanZero(String paramString)
  {
    if ("".equals(paramString)) {
      return "";
    }
    while (paramString.charAt(0) == 38646)
    {
      paramString = paramString.substring(2);
      if (paramString.length() == 0) {
        return "零";
      }
    }
    String[] arrayOfString1 = { "零仟", "零佰", "零拾" };
    String[] arrayOfString2 = { "零亿", "零万", "零元" };
    String[] arrayOfString3 = { "亿", "万", "元" };
    String[] arrayOfString4 = { "零角", "零分" };
    for (int i = 0; i < 3; i++) {
      paramString = paramString.replaceAll(arrayOfString1[i], "零");
    }
    for (i = 0; i < 3; i++)
    {
      paramString = paramString.replaceAll("零零零", "零");
      paramString = paramString.replaceAll("零零", "零");
      paramString = paramString.replaceAll(arrayOfString2[i], arrayOfString3[i]);
    }
    for (i = 0; i < 2; i++) {
      paramString = paramString.replaceAll(arrayOfString4[i], "");
    }
    paramString = paramString.replaceAll("亿万", "亿");
    return paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.hnyd.business.print.model.Trans2RMB
 * JD-Core Version:    0.7.0.1
 */