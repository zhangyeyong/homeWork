package com.zte.evs.ebill.common.invoice.util;

import com.sun.image.codec.jpeg.ImageFormatException;
import com.zte.evs.ebill.common.BarCodeImage;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class StringUtils
{
  private static DecimalFormat decimalFormat = new DecimalFormat("###,###.00");
  private static String ZERO = ".00";
  
  public static String formatDate(String paramString1, String paramString2)
  {
    String str = "";
    if ((paramString2 != null) && (paramString2.indexOf("(") >= 0) && (paramString2.indexOf(")") >= 0)) {
      paramString2 = paramString2.substring(paramString2.indexOf("(") + 1, paramString2.indexOf(")"));
    }
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    try
    {
      Date localDate = new Date(paramString1);
      localSimpleDateFormat = new SimpleDateFormat(paramString2);
      str = localSimpleDateFormat.format(localDate);
    }
    catch (Exception localException) {}
    if ((str == null) || (str.length() <= 0)) {
      str = paramString1;
    }
    return str;
  }
  
  public static String getLocalFilePath()
  {
    String str = "";
    try
    {
      str = StringUtils.class.getResource("").getPath();
      str = str.replaceAll("/WEB-INF/classes/com/zte/evs/ebill/common/invoice/util/", "/common/");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return str;
  }
  
  public static BufferedImage getBarCodeBuffeeredImage(String paramString)
  {
    BarCodeImage localBarCodeImage = new BarCodeImage();
    if (paramString == null) {
      paramString = "";
    }
    BufferedImage localBufferedImage = localBarCodeImage.buildCodeBarImg(paramString, 1, 30, 5, 20);
    try
    {
      Graphics2D localGraphics2D = localBufferedImage.createGraphics();
      localGraphics2D.setBackground(Color.WHITE);
      localGraphics2D.setColor(Color.black);
      localGraphics2D.setFont(new Font("Serif", 0, 12));
      int i = (localBufferedImage.getWidth() - paramString.getBytes().length * 7) / 2;
      int j = localBufferedImage.getHeight() - 2;
      localGraphics2D.drawString(paramString, i, j);
      localGraphics2D.dispose();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localBufferedImage;
  }
  
  public static BufferedImage getBarCodeBuffeeredImageForPrint(String paramString)
  {
    BarCodeImage localBarCodeImage = new BarCodeImage();
    if (paramString == null) {
      paramString = "";
    }
    BufferedImage localBufferedImage = localBarCodeImage.buildCodeBarImg(paramString, 1, 46, 10, 20);
    try
    {
      Graphics2D localGraphics2D = localBufferedImage.createGraphics();
      localGraphics2D.setBackground(Color.WHITE);
      localGraphics2D.setColor(Color.black);
      localGraphics2D.setFont(new Font("Serif", 0, 12));
      int i = (localBufferedImage.getWidth() - paramString.getBytes().length * 6) / 2;
      int j = localBufferedImage.getHeight() - 2;
      localGraphics2D.drawString(paramString, i, j);
      localGraphics2D.dispose();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localBufferedImage;
  }
  
  public static String getFormatNumber(String paramString)
  {
    String str = "";
    try
    {
      if (Double.parseDouble(paramString) < 0.0D)
      {
        str = "-";
        paramString = Math.abs(Double.parseDouble(paramString)) + "";
      }
    }
    catch (Exception localException) {}
    StringBuffer localStringBuffer = new StringBuffer();
    String[] arrayOfString = paramString.trim().split("\\.");
    if ((localStringBuffer != null) && (arrayOfString.length >= 1))
    {
      char[] arrayOfChar = arrayOfString[0].toCharArray();
      int i = 0;
      for (int j = arrayOfChar.length - 1; j >= 0; j--)
      {
        if ((j >= 0) && (i != 0) && (i % 3 == 0))
        {
          localStringBuffer.insert(0, ",");
          i = 0;
        }
        localStringBuffer.insert(0, arrayOfChar[j]);
        i++;
      }
    }
    if (arrayOfString.length > 1) {
      localStringBuffer.append("." + arrayOfString[1]);
    } else {
      localStringBuffer.append(".00");
    }
    return str + localStringBuffer.toString();
  }
  
  public static String getPageContent(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      URL localURL = new URL(paramString);
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)localURL.openConnection();
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localHttpURLConnection.getInputStream()));
      int i;
      while ((i = localBufferedReader.read()) != -1) {
        localStringBuffer.append((char)i);
      }
      localBufferedReader.close();
    }
    catch (MalformedURLException localMalformedURLException)
    {
      localMalformedURLException.printStackTrace();
      return null;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return null;
    }
    return localStringBuffer.toString().trim();
  }
  
  public static String numberToChinese(double paramDouble)
  {
    String str1 = "";
    if (paramDouble < 0.0D)
    {
      paramDouble = Math.abs(paramDouble);
      str1 = "负";
    }
    String[] arrayOfString1 = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
    String[] arrayOfString2 = { "仟", "佰", "拾", "万", "仟", "佰", "拾", "亿", "仟", "佰", "拾", "万", "仟", "佰", "拾", "元", "角", "分" };
    String[] arrayOfString3 = new String[40];
    String[] arrayOfString4 = new String[40];
    int[] arrayOfInt = new int[20];
    double d1 = 1000000000000000.0D;
    StringBuffer localStringBuffer = new StringBuffer("");
    String str2;
    if (paramDouble == 0.0D)
    {
      str2 = "零元整";
    }
    else
    {
      paramDouble *= 100.0D;
      while (d1 >= 1.0D)
      {
        double d2 = paramDouble / d1;
        if (d2 >= 1.0D) {
          break;
        }
        d1 /= 10.0D;
      }
      for (double d3 = 0; d1 >= 1.0D; d3++)
      {
        d4 = paramDouble / d1;
        arrayOfInt[d3] = ((int)d4);
        paramDouble %= d1;
        d1 /= 10.0D;
      }
      double d4 = d3;
      int j = d4 * 2 - 1;
      int k = 17;
      for (d3 = d4 - 1; d3 >= 0; d3--)
      {
        arrayOfString3[j] = arrayOfString2[k];
        j--;
        arrayOfString3[j] = arrayOfString1[arrayOfInt[d3]];
        j--;
        k--;
      }
      d4 *= 2;
      j = 0;
      k = 0;
      for (d3 = 0; d3 < i; d3++) {
        if (arrayOfString3[d3].compareTo("零") == 0)
        {
          if (arrayOfString3[(d3 + 1)] != null) {
            if ((arrayOfString3[(d3 + 1)].compareTo("万") != 0) && (arrayOfString3[(d3 + 1)].compareTo("亿") != 0) && (arrayOfString3[(d3 + 1)].compareTo("元") != 0))
            {
              arrayOfString4[j] = arrayOfString3[d3];
              d3++;
              j++;
            }
            else
            {
              d3++;
              arrayOfString4[j] = arrayOfString3[d3];
              j++;
            }
          }
        }
        else
        {
          arrayOfString4[j] = arrayOfString3[d3];
          j++;
        }
      }
      for (j = 0; arrayOfString4[j] != null; j++) {
        if ((arrayOfString4[j].compareTo("零") == 0) && (arrayOfString4[(j + 1)] != null) && ((arrayOfString4[(j + 1)].compareTo("万") == 0) || (arrayOfString4[(j + 1)].compareTo("亿") == 0) || (arrayOfString4[(j + 1)].compareTo("元") == 0) || (arrayOfString4[(j + 1)].compareTo("零") == 0))) {
          arrayOfString4[j] = "_";
        }
      }
      if (arrayOfString4[(j - 1)].compareTo("零") == 0) {
        arrayOfString4[(j - 1)] = "_";
      }
      j = 0;
      d3 = 0;
      while (arrayOfString4[j] != null)
      {
        if (arrayOfString4[j].compareTo("_") != 0)
        {
          arrayOfString3[d3] = arrayOfString4[j];
          d3++;
        }
        j++;
      }
      int i = d3;
      for (int m = 0; m < i; m++)
      {
        localStringBuffer.append(arrayOfString3[m]);
        if ((arrayOfString3[m].compareTo("亿") == 0) && (arrayOfString3[(m + 1)].compareTo("万") == 0)) {
          arrayOfString3[(m + 1)] = "";
        }
      }
      String str3 = localStringBuffer.toString().substring(localStringBuffer.length() - 1, localStringBuffer.length());
      if (str3.equals("元")) {
        str2 = "整";
      } else {
        str2 = localStringBuffer.toString();
      }
    }
    return str1 + str2;
  }
  
  public static int indexOfNumber(String paramString)
  {
    String[] arrayOfString = paramString.split("");
    for (int i = 0; i < arrayOfString.length; i++)
    {
      String str = arrayOfString[i];
      try
      {
        Long.valueOf(str);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        continue;
      }
      return i - 1;
    }
    return -1;
  }
  
  public static String formatAmount(String paramString)
  {
    if (isEmpty(paramString).booleanValue()) {
      return "";
    }
    BigDecimal localBigDecimal = BigDecimal.ZERO;
    try
    {
      localBigDecimal = BigDecimal.valueOf(Double.valueOf(paramString).doubleValue());
    }
    catch (Exception localException) {}
    String str = decimalFormat.format(localBigDecimal);
    if (ZERO.equals(str)) {
      str = "";
    }
    if (str.indexOf(".") == 0) {
      str = "0" + str;
    }
    if ((Double.valueOf(paramString).doubleValue() < 0.0D) && (str.substring(0, str.indexOf(".")).equals("-"))) {
      str = str.substring(0, 1) + "0" + str.substring(1);
    }
    return str;
  }
  
  public static Boolean isEmpty(String paramString)
  {
    return Boolean.valueOf((paramString == null) || ("".equals(paramString.trim())));
  }
  
  public static String fmtStr(List paramList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if ((paramList != null) && (paramList.size() > 0)) {
      for (int i = 0; i < paramList.size(); i++) {
        if (i == 0) {
          localStringBuffer.append("'").append(paramList.get(i)).append("'");
        } else {
          localStringBuffer.append(",").append("'").append(paramList.get(i)).append("'");
        }
      }
    } else {
      return null;
    }
    return localStringBuffer.toString();
  }
  
  public static void main(String[] paramArrayOfString)
    throws ImageFormatException, IOException
  {
    System.out.println(formatAmount("-1"));
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.common.invoice.util.StringUtils
 * JD-Core Version:    0.7.0.1
 */