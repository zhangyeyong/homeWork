package com.zte.eas.appframe.business.util;

import java.io.File;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import jxl.Cell;
import jxl.CellType;
import jxl.DateCell;
import jxl.LabelCell;
import jxl.NumberCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.CellFormat;
import jxl.write.DateFormat;
import jxl.write.DateTime;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.NumberFormat;
import jxl.write.NumberFormats;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class AccessExcelUtils
{
  public static List parseExcel2(InputStream paramInputStream, Class paramClass, Vector paramVector)
    throws Exception
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      Workbook localWorkbook = Workbook.getWorkbook(paramInputStream);
      Sheet[] arrayOfSheet = localWorkbook.getSheets();
      for (int i = 0; i < arrayOfSheet.length; i++)
      {
        Sheet localSheet = arrayOfSheet[i];
        int j = localSheet.getRows();
        int k = localSheet.getColumns();
        if ((j > 0) && (k > 0))
        {
          if (k != paramVector.size())
          {
            System.out.println("数据库表字段和Excel表格里字段个数不相等");
            return null;
          }
          HashMap localHashMap = getMethod("set", paramVector, paramClass);
          for (int m = 1; m < j; m++)
          {
            Object localObject1 = paramClass.newInstance();
            for (int n = 0; n < k; n++)
            {
              Cell localCell = localSheet.getCell(n, m);
              Method localMethod = (Method)localHashMap.get(paramVector.get(n));
              CellType localCellType = null;
              Object[] arrayOfObject = new Object[1];
              Object localObject2;
              if (localCell.getType() == CellType.LABEL)
              {
                localCellType = CellType.LABEL;
                localObject2 = (LabelCell)localCell;
                String str = ((LabelCell)localObject2).getString();
                arrayOfObject[0] = str;
              }
              if (localCell.getType() == CellType.NUMBER)
              {
                localCellType = CellType.NUMBER;
                localObject2 = (NumberCell)localCell;
                double d = ((NumberCell)localObject2).getValue();
                Class[] arrayOfClass = localMethod.getParameterTypes();
                Class localClass = arrayOfClass[0];
                if (localClass.equals(BigInteger.class))
                {
                  arrayOfObject[0] = new BigInteger(Long.valueOf(Double.valueOf(d).longValue()).toString());
                }
                else if (localClass.equals(BigDecimal.class))
                {
                  arrayOfObject[0] = new BigDecimal(new Double(d).toString());
                }
                else if (localClass.equals(Long.class))
                {
                  arrayOfObject[0] = new Long(new Double(d).longValue());
                }
                else if (localClass.equals(Double.class))
                {
                  arrayOfObject[0] = new Double(d);
                }
                else if (localClass.equals(Integer.class))
                {
                  arrayOfObject[0] = new Integer(new Double(d).intValue());
                }
                else if (localClass.equals(Float.class))
                {
                  arrayOfObject[0] = new Float(new Double(d).floatValue());
                }
                else
                {
                  arrayOfObject[0] = new BigDecimal(d).toString();
                  if (arrayOfObject[0] != null)
                  {
                    int i1 = ((String)arrayOfObject[0]).indexOf(".");
                    if (i1 > 1) {
                      arrayOfObject[0] = ((String)arrayOfObject[0]).substring(0, i1);
                    }
                  }
                }
              }
              if (localCell.getType() == CellType.DATE)
              {
                localCellType = CellType.DATE;
                localObject2 = (DateCell)localCell;
                Date localDate = ((DateCell)localObject2).getDate();
                arrayOfObject[0] = localDate;
              }
              if (localCellType == null) {
                arrayOfObject[0] = null;
              }
              localMethod.invoke(localObject1, arrayOfObject);
            }
            System.out.println(localObject1);
            localArrayList.add(localObject1);
          }
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      System.out.println("Excel文件解析失败");
      throw new Exception("excel文件导入失败");
    }
    return localArrayList;
  }
  
  public static HashMap getMethod(String paramString, Vector paramVector, Class paramClass)
  {
    HashMap localHashMap = new HashMap();
    Method[] arrayOfMethod = paramClass.getMethods();
    for (int i = 0; i < paramVector.size(); i++) {
      for (int j = 0; j < arrayOfMethod.length; j++) {
        if (arrayOfMethod[j].getName().equalsIgnoreCase(paramString + paramVector.get(i))) {
          localHashMap.put(paramVector.get(i), arrayOfMethod[j]);
        }
      }
    }
    return localHashMap;
  }
  
  public static void createExcel(String paramString1, String paramString2, List paramList, Vector paramVector, String[] paramArrayOfString)
  {
    if ((paramList == null) || (paramList.size() < 1)) {
      return;
    }
    Object localObject1 = paramList.get(0);
    HashMap localHashMap = getMethod("get", paramVector, localObject1.getClass());
    WritableFont localWritableFont1 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);
    WritableCellFormat localWritableCellFormat1 = new WritableCellFormat(localWritableFont1);
    WritableFont localWritableFont2 = new WritableFont(WritableFont.ARIAL, 10);
    WritableCellFormat localWritableCellFormat2 = new WritableCellFormat(localWritableFont2);
    NumberFormat localNumberFormat = new NumberFormat("#.###");
    WritableCellFormat localWritableCellFormat3 = new WritableCellFormat(localNumberFormat);
    DateFormat localDateFormat = new DateFormat("yyyy-mm-dd");
    WritableCellFormat localWritableCellFormat4 = new WritableCellFormat(localDateFormat);
    String str = paramString1 + File.separator + paramString2;
    File localFile1 = new File(str);
    WritableWorkbook localWritableWorkbook;
    WritableSheet localWritableSheet;
    int i;
    Object localObject2;
    Object localObject6;
    Object localObject8;
    if (localFile1.isFile()) {
      try
      {
        Workbook localWorkbook = Workbook.getWorkbook(localFile1);
        localWritableWorkbook = Workbook.createWorkbook(localFile1, localWorkbook);
        localWritableSheet = localWritableWorkbook.getSheet(0);
        i = localWritableSheet.getRows();
        localObject2 = paramList.iterator();
        for (int j = i; ((Iterator)localObject2).hasNext(); j++)
        {
          Object localObject4 = ((Iterator)localObject2).next();
          for (int m = 0; m < paramVector.size(); m++)
          {
            localObject6 = (Method)localHashMap.get(paramVector.get(m));
            Object localObject7 = ((Method)localObject6).invoke(localObject4, new Object[0]);
            if (((localObject7 instanceof String)) || ((localObject7 instanceof BigInteger)) || ((localObject7 instanceof BigDecimal)))
            {
              Label localLabel = new Label(m, j, localObject7.toString(), localWritableCellFormat2);
              localWritableSheet.addCell(localLabel);
            }
            double d2;
            Object localObject9;
            Number localNumber2;
            if (((localObject7 instanceof Integer)) || ((localObject7 instanceof Float)))
            {
              d2 = 0.0D;
              localObject9 = localObject7.getClass().getMethods();
              for (int i1 = 0; i1 < localObject9.length; i1++) {
                if (localObject9[i1].getName().equals("doubleValue")) {
                  d2 = ((Double)localObject9[i1].invoke(localObject7, new Object[0])).doubleValue();
                }
              }
              localNumber2 = new Number(m, j, d2, localWritableCellFormat3);
              localWritableSheet.addCell(localNumber2);
            }
            if ((localObject7 instanceof Double))
            {
              d2 = ((Double)localObject7).doubleValue();
              localObject9 = new Number(m, j, d2, localWritableCellFormat3);
              localWritableSheet.addCell((WritableCell)localObject9);
            }
            if ((localObject7 instanceof Long))
            {
              d2 = ((Long)localObject7).longValue();
              localObject9 = new WritableCellFormat(NumberFormats.INTEGER);
              localNumber2 = new Number(m, j, d2, (CellFormat)localObject9);
              localWritableSheet.addCell(localNumber2);
            }
            if ((localObject7 instanceof Date))
            {
              localObject8 = new DateTime(m, j, (Date)localObject7, localWritableCellFormat4);
              localWritableSheet.addCell((WritableCell)localObject8);
            }
          }
        }
        localWritableWorkbook.write();
        localWritableWorkbook.close();
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        System.out.println("导出Excel失败");
      }
    } else {
      try
      {
        File localFile2 = new File(str);
        localWritableWorkbook = Workbook.createWorkbook(localFile2);
        localWritableSheet = localWritableWorkbook.createSheet("sheet1", 0);
        for (i = 0; i < paramArrayOfString.length; i++)
        {
          localObject2 = new Label(i, 0, paramArrayOfString[i], localWritableCellFormat1);
          localWritableSheet.addCell((WritableCell)localObject2);
        }
        i = 1;
        localObject2 = paramList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = ((Iterator)localObject2).next();
          for (int k = 0; k < paramVector.size(); k++)
          {
            Object localObject5 = ((Method)localHashMap.get(paramVector.get(k))).invoke(localObject3, new Object[0]);
            if (((localObject5 instanceof String)) || ((localObject5 instanceof BigInteger)) || ((localObject5 instanceof BigDecimal)))
            {
              localObject6 = new Label(k, i, (String)localObject5, localWritableCellFormat2);
              localWritableSheet.addCell((WritableCell)localObject6);
            }
            double d1;
            Number localNumber1;
            if (((localObject5 instanceof Integer)) || ((localObject5 instanceof Float)))
            {
              d1 = 0.0D;
              localObject8 = localObject5.getClass().getMethods();
              for (int n = 0; n < localObject8.length; n++) {
                if (localObject8[n].getName().equals("doubleValue")) {
                  d1 = ((Double)localObject8[n].invoke(localObject5, new Object[0])).doubleValue();
                }
              }
              localNumber1 = new Number(k, i, d1, localWritableCellFormat3);
              localWritableSheet.addCell(localNumber1);
            }
            if ((localObject5 instanceof Double))
            {
              d1 = ((Double)localObject5).doubleValue();
              localObject8 = new Number(k, i, d1, localWritableCellFormat3);
              localWritableSheet.addCell((WritableCell)localObject8);
            }
            if ((localObject5 instanceof Long))
            {
              d1 = ((Long)localObject5).longValue();
              localObject8 = new WritableCellFormat(NumberFormats.INTEGER);
              localNumber1 = new Number(k, i, d1, (CellFormat)localObject8);
              localWritableSheet.addCell(localNumber1);
            }
            if ((localObject5 instanceof Date))
            {
              DateTime localDateTime = new DateTime(k, i, (Date)localObject5, localWritableCellFormat4);
              localWritableSheet.addCell(localDateTime);
            }
          }
          i++;
        }
        localWritableWorkbook.write();
        localWritableWorkbook.close();
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        System.out.println("导出Excel失败");
      }
    }
  }
  
  public static void main(String[] paramArrayOfString)
    throws Exception
  {}
  
  public static List parseExcel(InputStream paramInputStream, Class paramClass, Vector paramVector)
    throws Exception
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      HSSFWorkbook localHSSFWorkbook = new HSSFWorkbook(paramInputStream);
      for (int i = 0; i < localHSSFWorkbook.getNumberOfSheets(); i++)
      {
        HSSFSheet localHSSFSheet = localHSSFWorkbook.getSheetAt(i);
        int j = localHSSFSheet.getPhysicalNumberOfRows();
        if (j > 0)
        {
          HashMap localHashMap = getMethod("set", paramVector, paramClass);
          HSSFRow localHSSFRow1 = localHSSFSheet.getRow(0);
          int k = localHSSFRow1.getPhysicalNumberOfCells();
          for (int m = 1; m < j; m++)
          {
            Object localObject1 = paramClass.newInstance();
            HSSFRow localHSSFRow2 = localHSSFSheet.getRow(m);
            int i1;
            for (int n = 0; n < k; i1 = (short)(n + 1))
            {
              HSSFCell localHSSFCell = localHSSFRow2.getCell(n);
              if (localHSSFCell != null)
              {
                Method localMethod = (Method)localHashMap.get(paramVector.get(n));
                int i2 = -50;
                Object[] arrayOfObject = new Object[1];
                if (localHSSFCell.getCellType() == 1)
                {
                  i2 = 1;
                  String str = localHSSFCell.getStringCellValue();
                  arrayOfObject[0] = str;
                }
                double d;
                Object localObject2;
                if (localHSSFCell.getCellType() == 0)
                {
                  i2 = 0;
                  d = localHSSFCell.getNumericCellValue();
                  localObject2 = localMethod.getParameterTypes();
                  Object localObject3 = localObject2[0];
                  if (localObject3.equals(BigInteger.class))
                  {
                    arrayOfObject[0] = new BigInteger(Long.valueOf(Double.valueOf(d).longValue()).toString());
                  }
                  else if (localObject3.equals(BigDecimal.class))
                  {
                    arrayOfObject[0] = new BigDecimal(new Double(d).toString());
                  }
                  else if (localObject3.equals(Long.class))
                  {
                    arrayOfObject[0] = new Long(new Double(d).longValue());
                  }
                  else if (localObject3.equals(Double.class))
                  {
                    arrayOfObject[0] = new Double(d);
                  }
                  else if (localObject3.equals(Integer.class))
                  {
                    arrayOfObject[0] = new Integer(new Double(d).intValue());
                  }
                  else if (localObject3.equals(Float.class))
                  {
                    arrayOfObject[0] = new Float(new Double(d).floatValue());
                  }
                  else
                  {
                    arrayOfObject[0] = new BigDecimal(d).toString();
                    if (arrayOfObject[0] != null)
                    {
                      int i3 = ((String)arrayOfObject[0]).indexOf(".");
                      if (i3 > 1) {
                        arrayOfObject[0] = ((String)arrayOfObject[0]).substring(0, i3);
                      }
                    }
                  }
                }
                if ((localHSSFCell.getCellType() == 0) && (HSSFDateUtil.isCellDateFormatted(localHSSFCell)))
                {
                  i2 = 0;
                  d = localHSSFCell.getNumericCellValue();
                  localObject2 = HSSFDateUtil.getJavaDate(d);
                  arrayOfObject[0] = localObject2;
                }
                if (i2 == -50) {
                  arrayOfObject[0] = null;
                }
                localMethod.invoke(localObject1, arrayOfObject);
              }
            }
            System.out.println(localObject1);
            localArrayList.add(localObject1);
          }
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      System.out.println("Excel文件解析失败");
      throw new Exception("excel文件导入失败");
    }
    return localArrayList;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.business.util.AccessExcelUtils
 * JD-Core Version:    0.7.0.1
 */