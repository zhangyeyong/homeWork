package com.zte.evs.ebill.access.eBillManage;

import com.zte.evs.business.month.model.EvsVoucherMonthV;
import com.zte.evs.ebill.model.eBillManage.EvsBook;
import com.zte.evs.ebill.model.eBillManage.FasciculeQueryModel;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.zorm.Query;
import com.zte.ssb.zorm.Session;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class FasciculeQueryDAO
  extends BaseDAO
  implements IFasciculeQueryDAO
{
  public List findList1(String paramString1, String paramString2)
  {
    Connection localConnection = null;
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    String str = "select substr(tt.Period_Name, 1, 3) months,substr(tt.Period_Name, 5, 6) years,count(*) aa from evs_voucher tt where tt.ou_id = " + paramString2 + " group by substr(tt.Period_Name, 1, 3), substr(tt.Period_Name, 5, 6)";
    localConnection = getSession().connection();
    ArrayList localArrayList = new ArrayList();
    try
    {
      localPreparedStatement = localConnection.prepareStatement(str.toString());
      localResultSet = localPreparedStatement.executeQuery();
      while (localResultSet.next())
      {
        FasciculeQueryModel localFasciculeQueryModel1 = new FasciculeQueryModel();
        localFasciculeQueryModel1.setYears(localResultSet.getString("years"));
        localFasciculeQueryModel1.setMonths(localResultSet.getString("months"));
        localFasciculeQueryModel1.setVouchersums(Long.valueOf(localResultSet.getLong("aa")));
        localArrayList.add(localFasciculeQueryModel1);
      }
      localPreparedStatement.close();
      localConnection.close();
      localResultSet.close();
    }
    catch (SQLException localSQLException)
    {
      localSQLException.printStackTrace();
    }
    Iterator localIterator = localArrayList.iterator();
    FasciculeQueryModel localFasciculeQueryModel2;
    while (localIterator.hasNext())
    {
      localFasciculeQueryModel2 = (FasciculeQueryModel)localIterator.next();
      if (localFasciculeQueryModel2.getMonths().equals("JAN")) {
        localFasciculeQueryModel2.setMonths("01");
      } else if (localFasciculeQueryModel2.getMonths().equals("FEB")) {
        localFasciculeQueryModel2.setMonths("02");
      } else if (localFasciculeQueryModel2.getMonths().equals("MAR")) {
        localFasciculeQueryModel2.setMonths("03");
      } else if (localFasciculeQueryModel2.getMonths().equals("APR")) {
        localFasciculeQueryModel2.setMonths("04");
      } else if (localFasciculeQueryModel2.getMonths().equals("MAY")) {
        localFasciculeQueryModel2.setMonths("05");
      } else if (localFasciculeQueryModel2.getMonths().equals("JUN")) {
        localFasciculeQueryModel2.setMonths("06");
      } else if (localFasciculeQueryModel2.getMonths().equals("JUL")) {
        localFasciculeQueryModel2.setMonths("07");
      } else if (localFasciculeQueryModel2.getMonths().equals("AUG")) {
        localFasciculeQueryModel2.setMonths("08");
      } else if (localFasciculeQueryModel2.getMonths().equals("SEP")) {
        localFasciculeQueryModel2.setMonths("09");
      } else if (localFasciculeQueryModel2.getMonths().equals("OCT")) {
        localFasciculeQueryModel2.setMonths("10");
      } else if (localFasciculeQueryModel2.getMonths().equals("NOV")) {
        localFasciculeQueryModel2.setMonths("11");
      } else if (localFasciculeQueryModel2.getMonths().equals("DEC")) {
        localFasciculeQueryModel2.setMonths("12");
      }
    }
    localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      localFasciculeQueryModel2 = (FasciculeQueryModel)localIterator.next();
      localFasciculeQueryModel2.setTimes("20" + localFasciculeQueryModel2.getYears() + "-" + localFasciculeQueryModel2.getMonths());
    }
    return localArrayList;
  }
  
  public List findList2(String paramString1, String paramString2)
  {
    Connection localConnection = null;
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    String str = "  select substr(b.Period_Name, 1, 3) months, substr(b.Period_Name, 5, 6) years, count(*) aa  from evs.evs_book b where b.ou_name =" + paramString2 + " group by substr(b.Period_Name, 1, 3),substr(b.Period_Name, 5, 6)";
    System.out.println(str);
    localConnection = getSession().connection();
    ArrayList localArrayList = new ArrayList();
    try
    {
      localPreparedStatement = localConnection.prepareStatement(str.toString());
      localResultSet = localPreparedStatement.executeQuery();
      while (localResultSet.next())
      {
        FasciculeQueryModel localFasciculeQueryModel1 = new FasciculeQueryModel();
        localFasciculeQueryModel1.setYears(localResultSet.getString("years"));
        localFasciculeQueryModel1.setMonths(localResultSet.getString("months"));
        localFasciculeQueryModel1.setVoucherBooks(Long.valueOf(localResultSet.getLong("aa")));
        localArrayList.add(localFasciculeQueryModel1);
      }
      localPreparedStatement.close();
      localConnection.close();
      localResultSet.close();
    }
    catch (SQLException localSQLException)
    {
      localSQLException.printStackTrace();
    }
    Iterator localIterator = localArrayList.iterator();
    FasciculeQueryModel localFasciculeQueryModel2;
    while (localIterator.hasNext())
    {
      localFasciculeQueryModel2 = (FasciculeQueryModel)localIterator.next();
      if (localFasciculeQueryModel2.getMonths().equals("JAN")) {
        localFasciculeQueryModel2.setMonths("01");
      } else if (localFasciculeQueryModel2.getMonths().equals("FEB")) {
        localFasciculeQueryModel2.setMonths("02");
      } else if (localFasciculeQueryModel2.getMonths().equals("MAR")) {
        localFasciculeQueryModel2.setMonths("03");
      } else if (localFasciculeQueryModel2.getMonths().equals("APR")) {
        localFasciculeQueryModel2.setMonths("04");
      } else if (localFasciculeQueryModel2.getMonths().equals("MAY")) {
        localFasciculeQueryModel2.setMonths("05");
      } else if (localFasciculeQueryModel2.getMonths().equals("JUN")) {
        localFasciculeQueryModel2.setMonths("06");
      } else if (localFasciculeQueryModel2.getMonths().equals("JUL")) {
        localFasciculeQueryModel2.setMonths("07");
      } else if (localFasciculeQueryModel2.getMonths().equals("AUG")) {
        localFasciculeQueryModel2.setMonths("08");
      } else if (localFasciculeQueryModel2.getMonths().equals("SEP")) {
        localFasciculeQueryModel2.setMonths("09");
      } else if (localFasciculeQueryModel2.getMonths().equals("OCT")) {
        localFasciculeQueryModel2.setMonths("10");
      } else if (localFasciculeQueryModel2.getMonths().equals("NOV")) {
        localFasciculeQueryModel2.setMonths("11");
      } else if (localFasciculeQueryModel2.getMonths().equals("DEC")) {
        localFasciculeQueryModel2.setMonths("12");
      }
    }
    localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      localFasciculeQueryModel2 = (FasciculeQueryModel)localIterator.next();
      localFasciculeQueryModel2.setTimes("20" + localFasciculeQueryModel2.getYears() + "-" + localFasciculeQueryModel2.getMonths());
    }
    return localArrayList;
  }
  
  public List findList3(String paramString1, String paramString2)
  {
    Connection localConnection = null;
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    String str = "select substr(tt.Period_Name, 1, 3) months,substr(tt.Period_Name, 5, 6) years,count(*) aa from evs_voucher tt where tt.ou_id = 112 and tt.voucher_status in('UNMATCH','MATCHED','SUBMITED','CHECKED','BACKED','UNBOOKED') group by substr(tt.Period_Name, 1, 3), substr(tt.Period_Name, 5, 6)";
    localConnection = getSession().connection();
    ArrayList localArrayList = new ArrayList();
    try
    {
      localPreparedStatement = localConnection.prepareStatement(str.toString());
      localResultSet = localPreparedStatement.executeQuery();
      while (localResultSet.next())
      {
        FasciculeQueryModel localFasciculeQueryModel1 = new FasciculeQueryModel();
        localFasciculeQueryModel1.setYears(localResultSet.getString("years"));
        localFasciculeQueryModel1.setMonths(localResultSet.getString("months"));
        localFasciculeQueryModel1.setNovouchersums(Long.valueOf(localResultSet.getLong("aa")));
        localArrayList.add(localFasciculeQueryModel1);
      }
      localPreparedStatement.close();
      localConnection.close();
      localResultSet.close();
    }
    catch (SQLException localSQLException)
    {
      localSQLException.printStackTrace();
    }
    Iterator localIterator = localArrayList.iterator();
    FasciculeQueryModel localFasciculeQueryModel2;
    while (localIterator.hasNext())
    {
      localFasciculeQueryModel2 = (FasciculeQueryModel)localIterator.next();
      if (localFasciculeQueryModel2.getMonths().equals("JAN")) {
        localFasciculeQueryModel2.setMonths("01");
      } else if (localFasciculeQueryModel2.getMonths().equals("FEB")) {
        localFasciculeQueryModel2.setMonths("02");
      } else if (localFasciculeQueryModel2.getMonths().equals("MAR")) {
        localFasciculeQueryModel2.setMonths("03");
      } else if (localFasciculeQueryModel2.getMonths().equals("APR")) {
        localFasciculeQueryModel2.setMonths("04");
      } else if (localFasciculeQueryModel2.getMonths().equals("MAY")) {
        localFasciculeQueryModel2.setMonths("05");
      } else if (localFasciculeQueryModel2.getMonths().equals("JUN")) {
        localFasciculeQueryModel2.setMonths("06");
      } else if (localFasciculeQueryModel2.getMonths().equals("JUL")) {
        localFasciculeQueryModel2.setMonths("07");
      } else if (localFasciculeQueryModel2.getMonths().equals("AUG")) {
        localFasciculeQueryModel2.setMonths("08");
      } else if (localFasciculeQueryModel2.getMonths().equals("SEP")) {
        localFasciculeQueryModel2.setMonths("09");
      } else if (localFasciculeQueryModel2.getMonths().equals("OCT")) {
        localFasciculeQueryModel2.setMonths("10");
      } else if (localFasciculeQueryModel2.getMonths().equals("NOV")) {
        localFasciculeQueryModel2.setMonths("11");
      } else if (localFasciculeQueryModel2.getMonths().equals("DEC")) {
        localFasciculeQueryModel2.setMonths("12");
      }
    }
    localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      localFasciculeQueryModel2 = (FasciculeQueryModel)localIterator.next();
      localFasciculeQueryModel2.setTimes("20" + localFasciculeQueryModel2.getYears() + "-" + localFasciculeQueryModel2.getMonths());
    }
    return localArrayList;
  }
  
  public List findList4(Long paramLong)
  {
    Connection localConnection = null;
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    String str = "  select last_update_date, count(1) aa, ou_id from ( select * from (select substr(ev.Period_Name, 5, 6) last_update_date, ev.voucher_id, ev.ou_id  from evs_image imag, evs_voucher ev where imag.voucher_id = ev.voucher_id and ev.ou_id = " + paramLong + ") tt) group by last_update_date, ou_id";
    localConnection = getSession().connection();
    ArrayList localArrayList = new ArrayList();
    try
    {
      localPreparedStatement = localConnection.prepareStatement(str.toString());
      localResultSet = localPreparedStatement.executeQuery();
      while (localResultSet.next())
      {
        FasciculeQueryModel localFasciculeQueryModel1 = new FasciculeQueryModel();
        localFasciculeQueryModel1.setTimes(localResultSet.getString("last_update_date"));
        localFasciculeQueryModel1.setVoucherPages(Long.valueOf(localResultSet.getLong("aa")));
        localFasciculeQueryModel1.setOuId(Long.valueOf(localResultSet.getLong("ou_id")));
        localArrayList.add(localFasciculeQueryModel1);
      }
      localPreparedStatement.close();
      localConnection.close();
      localResultSet.close();
    }
    catch (SQLException localSQLException)
    {
      localSQLException.printStackTrace();
    }
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      FasciculeQueryModel localFasciculeQueryModel2 = (FasciculeQueryModel)localIterator.next();
      localFasciculeQueryModel2.setTimes("20" + localFasciculeQueryModel2.getTimes());
    }
    return localArrayList;
  }
  
  public List quary(String paramString1, String paramString2)
  {
    Connection localConnection = null;
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    String str1 = "select tt.ERP_ORG_ID from FBP_CHECK_UNIT_CONTENTS tt where tt.CHECK_UNIT='" + paramString2 + "'";
    System.out.println(str1);
    localConnection = getSession().connection();
    ArrayList localArrayList1 = new ArrayList();
    try
    {
      localPreparedStatement = localConnection.prepareStatement(str1.toString());
      localResultSet = localPreparedStatement.executeQuery();
      while (localResultSet.next())
      {
        FasciculeQueryModel localFasciculeQueryModel1 = new FasciculeQueryModel();
        localFasciculeQueryModel1.setOuId(Long.valueOf(localResultSet.getLong("ERP_ORG_ID")));
        localArrayList1.add(localFasciculeQueryModel1);
      }
      localPreparedStatement.close();
      localConnection.close();
      localResultSet.close();
    }
    catch (SQLException localSQLException)
    {
      localSQLException.printStackTrace();
    }
    Long localLong = ((FasciculeQueryModel)localArrayList1.get(0)).getOuId();
    ArrayList localArrayList2 = new ArrayList();
    List localList1 = findList1(paramString1, localLong.toString());
    List localList2 = findList2(paramString1, localLong.toString());
    List localList3 = findList3(paramString1, localLong.toString());
    Date localDate = new Date();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String str2 = localSimpleDateFormat.format(localDate);
    String[] arrayOfString1 = str2.split("-");
    Object localObject = null;
    FasciculeQueryModel localFasciculeQueryModel2 = null;
    for (int i = 1; i <= 12; i++)
    {
      localFasciculeQueryModel2 = new FasciculeQueryModel();
      if (i < 10) {
        localFasciculeQueryModel2.setMonth("0" + i);
      } else {
        localFasciculeQueryModel2.setMonth(i + "");
      }
      localArrayList2.add(localFasciculeQueryModel2);
    }
    Iterator localIterator1 = localList1.iterator();
    FasciculeQueryModel localFasciculeQueryModel3;
    Iterator localIterator2;
    FasciculeQueryModel localFasciculeQueryModel4;
    String[] arrayOfString2;
    while (localIterator1.hasNext())
    {
      localFasciculeQueryModel3 = (FasciculeQueryModel)localIterator1.next();
      System.out.println(localFasciculeQueryModel3.getTimes() + "00000000000000");
      localIterator2 = localArrayList2.iterator();
      while (localIterator2.hasNext())
      {
        localFasciculeQueryModel4 = (FasciculeQueryModel)localIterator2.next();
        if (localFasciculeQueryModel3.getTimes() != null)
        {
          arrayOfString2 = localFasciculeQueryModel3.getTimes().split("-");
          System.out.println(localFasciculeQueryModel3.getTimes() + "++++++++++++" + arrayOfString2[1] + "          " + localFasciculeQueryModel4.getMonth() + "       " + paramString1);
          if ((arrayOfString2[0].equals(paramString1)) && (arrayOfString2[1].equals(localFasciculeQueryModel4.getMonth())))
          {
            System.out.println("进来过了");
            localFasciculeQueryModel4.setVouchersums(localFasciculeQueryModel3.getVouchersums());
          }
        }
      }
    }
    localIterator1 = localList2.iterator();
    while (localIterator1.hasNext())
    {
      localFasciculeQueryModel3 = (FasciculeQueryModel)localIterator1.next();
      localIterator2 = localArrayList2.iterator();
      while (localIterator2.hasNext())
      {
        localFasciculeQueryModel4 = (FasciculeQueryModel)localIterator2.next();
        arrayOfString2 = localFasciculeQueryModel3.getTimes().split("-");
        System.out.println(arrayOfString2[1] + "uuuuuuuuuuuuu" + localFasciculeQueryModel4.getMonth());
        arrayOfString2 = localFasciculeQueryModel3.getTimes().split("-");
        if ((localFasciculeQueryModel4.getMonth().equals(arrayOfString2[1])) && (arrayOfString2[0].equals(paramString1)))
        {
          System.out.println("进来过了11111111");
          localFasciculeQueryModel4.setVoucherBooks(localFasciculeQueryModel3.getVoucherBooks());
        }
      }
    }
    localIterator1 = localList3.iterator();
    while (localIterator1.hasNext())
    {
      localFasciculeQueryModel3 = (FasciculeQueryModel)localIterator1.next();
      arrayOfString2 = localFasciculeQueryModel3.getTimes().split("-");
      localIterator2 = localArrayList2.iterator();
      while (localIterator2.hasNext())
      {
        localFasciculeQueryModel4 = (FasciculeQueryModel)localIterator2.next();
        arrayOfString2 = localFasciculeQueryModel3.getTimes().split("-");
        System.out.println(arrayOfString2[0] + "uuuuuuuuuuuuu" + localFasciculeQueryModel4.getMonth());
        if ((localFasciculeQueryModel4.getMonth().equals(arrayOfString2[1])) && (arrayOfString2[0].equals(paramString1))) {
          localFasciculeQueryModel4.setNovouchersums(localFasciculeQueryModel3.getNovouchersums());
        }
      }
    }
    return localArrayList2;
  }
  
  public List quary1(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    List localList1 = findList1(paramString1, paramString2);
    List localList2 = findList2(paramString1, paramString2);
    List localList3 = findList3(paramString1, paramString2);
    Date localDate = new Date();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String str = localSimpleDateFormat.format(localDate);
    String[] arrayOfString1 = str.split("-");
    Object localObject = null;
    FasciculeQueryModel localFasciculeQueryModel1 = null;
    for (int i = 1; i <= 12; i++)
    {
      localFasciculeQueryModel1 = new FasciculeQueryModel();
      if (i < 10) {
        localFasciculeQueryModel1.setMonth("0" + i);
      } else {
        localFasciculeQueryModel1.setMonth(i + "");
      }
      localArrayList.add(localFasciculeQueryModel1);
    }
    Iterator localIterator1 = localList1.iterator();
    FasciculeQueryModel localFasciculeQueryModel2;
    Iterator localIterator2;
    FasciculeQueryModel localFasciculeQueryModel3;
    String[] arrayOfString2;
    while (localIterator1.hasNext())
    {
      localFasciculeQueryModel2 = (FasciculeQueryModel)localIterator1.next();
      System.out.println(localFasciculeQueryModel2.getTimes() + "00000000000000");
      localIterator2 = localArrayList.iterator();
      while (localIterator2.hasNext())
      {
        localFasciculeQueryModel3 = (FasciculeQueryModel)localIterator2.next();
        if (localFasciculeQueryModel2.getTimes() != null)
        {
          arrayOfString2 = localFasciculeQueryModel2.getTimes().split("-");
          if ((arrayOfString2[0].equals(paramString1)) && (arrayOfString2[1].equals(localFasciculeQueryModel3.getMonth()))) {
            localFasciculeQueryModel3.setVouchersums(localFasciculeQueryModel2.getVouchersums());
          }
        }
      }
    }
    localIterator1 = localList2.iterator();
    while (localIterator1.hasNext())
    {
      localFasciculeQueryModel2 = (FasciculeQueryModel)localIterator1.next();
      localIterator2 = localArrayList.iterator();
      while (localIterator2.hasNext())
      {
        localFasciculeQueryModel3 = (FasciculeQueryModel)localIterator2.next();
        arrayOfString2 = localFasciculeQueryModel2.getTimes().split("-");
        arrayOfString2 = localFasciculeQueryModel2.getTimes().split("-");
        if ((localFasciculeQueryModel3.getMonth().equals(arrayOfString2[1])) && (arrayOfString2[0].equals(paramString1))) {
          localFasciculeQueryModel3.setVoucherBooks(localFasciculeQueryModel2.getVoucherBooks());
        }
      }
    }
    localIterator1 = localList3.iterator();
    while (localIterator1.hasNext())
    {
      localFasciculeQueryModel2 = (FasciculeQueryModel)localIterator1.next();
      arrayOfString2 = localFasciculeQueryModel2.getTimes().split("-");
      localIterator2 = localArrayList.iterator();
      while (localIterator2.hasNext())
      {
        localFasciculeQueryModel3 = (FasciculeQueryModel)localIterator2.next();
        arrayOfString2 = localFasciculeQueryModel2.getTimes().split("-");
        if ((localFasciculeQueryModel3.getMonth().equals(arrayOfString2[1])) && (arrayOfString2[0].equals(paramString1))) {
          localFasciculeQueryModel3.setNovouchersums(localFasciculeQueryModel2.getNovouchersums());
        }
      }
    }
    return localArrayList;
  }
  
  public List search(Long paramLong1, Long paramLong2)
  {
    ArrayList localArrayList = new ArrayList();
    List localList1 = findList5(paramLong2);
    List localList2 = findList6(paramLong2);
    List localList3 = findList7(paramLong2);
    Date localDate = new Date();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String str = localSimpleDateFormat.format(localDate);
    String[] arrayOfString1 = str.split("-");
    FasciculeQueryModel localFasciculeQueryModel1 = null;
    Iterator localIterator1 = localList1.iterator();
    FasciculeQueryModel localFasciculeQueryModel2;
    String[] arrayOfString2;
    while (localIterator1.hasNext())
    {
      localFasciculeQueryModel2 = (FasciculeQueryModel)localIterator1.next();
      arrayOfString2 = localFasciculeQueryModel2.getTimes().split("-");
      localFasciculeQueryModel1 = new FasciculeQueryModel();
      if (arrayOfString2[0].equals(paramLong1))
      {
        System.out.println("进来过了");
        localFasciculeQueryModel1.setMonth(arrayOfString2[1]);
        localFasciculeQueryModel1.setVouchersums(localFasciculeQueryModel2.getVouchersums());
        localArrayList.add(localFasciculeQueryModel1);
      }
    }
    localIterator1 = localList2.iterator();
    Iterator localIterator2;
    FasciculeQueryModel localFasciculeQueryModel3;
    while (localIterator1.hasNext())
    {
      localFasciculeQueryModel2 = (FasciculeQueryModel)localIterator1.next();
      localIterator2 = localArrayList.iterator();
      while (localIterator2.hasNext())
      {
        localFasciculeQueryModel3 = (FasciculeQueryModel)localIterator2.next();
        arrayOfString2 = localFasciculeQueryModel2.getTimes().split("-");
        if (localFasciculeQueryModel3.getMonth().equals(arrayOfString2[1])) {
          localFasciculeQueryModel3.setVoucherBooks(localFasciculeQueryModel2.getVoucherBooks());
        }
      }
    }
    localIterator1 = localList3.iterator();
    while (localIterator1.hasNext())
    {
      localFasciculeQueryModel2 = (FasciculeQueryModel)localIterator1.next();
      localIterator2 = localArrayList.iterator();
      while (localIterator2.hasNext())
      {
        localFasciculeQueryModel3 = (FasciculeQueryModel)localIterator2.next();
        arrayOfString2 = localFasciculeQueryModel2.getTimes().split("-");
        if (localFasciculeQueryModel3.getMonth().equals(arrayOfString2[1])) {
          localFasciculeQueryModel3.setNovouchersums(localFasciculeQueryModel2.getNovouchersums());
        }
      }
    }
    return localArrayList;
  }
  
  public List findList5(Long paramLong)
  {
    Connection localConnection = null;
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    String str = "select cc.last_update_date,count(cc.voucher_id)aa from (select to_char(tt.last_update_date,'yyyy-MM') last_update_date, tt.voucher_id from evs_voucher tt where tt.ou_id=" + paramLong + ") cc  group by cc.last_update_date order by last_update_date";
    localConnection = getSession().connection();
    ArrayList localArrayList = new ArrayList();
    try
    {
      localPreparedStatement = localConnection.prepareStatement(str.toString());
      localResultSet = localPreparedStatement.executeQuery();
      while (localResultSet.next())
      {
        FasciculeQueryModel localFasciculeQueryModel = new FasciculeQueryModel();
        localFasciculeQueryModel.setTimes(localResultSet.getString("last_update_date"));
        localFasciculeQueryModel.setVoucherBooks(Long.valueOf(localResultSet.getLong("aa")));
        localArrayList.add(localFasciculeQueryModel);
      }
      localPreparedStatement.close();
      localConnection.close();
      localResultSet.close();
    }
    catch (SQLException localSQLException)
    {
      localSQLException.printStackTrace();
    }
    return localArrayList;
  }
  
  public List findList6(Long paramLong)
  {
    Connection localConnection = null;
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    String str = "select count(eb.book_id) aa, to_char(ev.last_update_date, 'yyyy-MM') last_update_date from evs.evs_voucher ev, evs.evs_book  eb, evs.evs_voucher_book_package evbp where ev.voucher_id = evbp.voucher_id  and eb.book_id = evbp.book_id and ev.ou_id=" + paramLong + " group by   to_char(ev.last_update_date, 'yyyy-MM')";
    localConnection = getSession().connection();
    ArrayList localArrayList = new ArrayList();
    try
    {
      localPreparedStatement = localConnection.prepareStatement(str.toString());
      localResultSet = localPreparedStatement.executeQuery();
      while (localResultSet.next())
      {
        FasciculeQueryModel localFasciculeQueryModel = new FasciculeQueryModel();
        localFasciculeQueryModel.setTimes(localResultSet.getString("last_update_date"));
        localFasciculeQueryModel.setVouchersums(Long.valueOf(localResultSet.getLong("aa")));
        localArrayList.add(localFasciculeQueryModel);
      }
      localPreparedStatement.close();
      localConnection.close();
      localResultSet.close();
    }
    catch (SQLException localSQLException)
    {
      localSQLException.printStackTrace();
    }
    return localArrayList;
  }
  
  public List findList7(Long paramLong)
  {
    Connection localConnection = null;
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    String str = "select cc.last_update_date,count(cc.voucher_id)aa from (select to_char(tt.last_update_date,'yyyy-MM') last_update_date,tt.voucher_id  from evs_voucher tt WHERE  tt.ou_id=" + paramLong + " and tt.voucher_status in('UNMATCH','MATCHED','SUBMITED','CHECKED','BACKED','UNBOOKED')  )cc  group by cc.last_update_date order by cc.last_update_date";
    localConnection = getSession().connection();
    ArrayList localArrayList = new ArrayList();
    try
    {
      localPreparedStatement = localConnection.prepareStatement(str.toString());
      localResultSet = localPreparedStatement.executeQuery();
      while (localResultSet.next())
      {
        FasciculeQueryModel localFasciculeQueryModel = new FasciculeQueryModel();
        localFasciculeQueryModel.setTimes(localResultSet.getString("last_update_date"));
        localFasciculeQueryModel.setNovouchersums(Long.valueOf(localResultSet.getLong("aa")));
        localArrayList.add(localFasciculeQueryModel);
      }
      localPreparedStatement.close();
      localConnection.close();
      localResultSet.close();
    }
    catch (SQLException localSQLException)
    {
      localSQLException.printStackTrace();
    }
    return localArrayList;
  }
  
  public List findList10(Long paramLong)
  {
    return null;
  }
  
  public static void main(String[] paramArrayOfString) {}
  
  public List findList8(Long paramLong)
  {
    Connection localConnection = null;
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    String str = "  select substr(b.Period_Name, 5, 6) years, count(*) aa, b.ou_name ou_id  from evs.evs_book b  where b.ou_name = " + paramLong + " group by   substr(b.Period_Name, 5, 6),b.ou_name";
    System.out.println(str);
    localConnection = getSession().connection();
    ArrayList localArrayList = new ArrayList();
    try
    {
      localPreparedStatement = localConnection.prepareStatement(str.toString());
      localResultSet = localPreparedStatement.executeQuery();
      while (localResultSet.next())
      {
        FasciculeQueryModel localFasciculeQueryModel1 = new FasciculeQueryModel();
        localFasciculeQueryModel1.setYears(localResultSet.getString("years"));
        localFasciculeQueryModel1.setVoucherBooks(Long.valueOf(localResultSet.getLong("aa")));
        localFasciculeQueryModel1.setOuId(Long.valueOf(localResultSet.getLong("ou_id")));
        localArrayList.add(localFasciculeQueryModel1);
      }
      localPreparedStatement.close();
      localConnection.close();
      localResultSet.close();
    }
    catch (SQLException localSQLException)
    {
      localSQLException.printStackTrace();
    }
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      FasciculeQueryModel localFasciculeQueryModel2 = (FasciculeQueryModel)localIterator.next();
      localFasciculeQueryModel2.setTimes("20" + localFasciculeQueryModel2.getYears());
    }
    return localArrayList;
  }
  
  public List findList9(Long paramLong)
  {
    Connection localConnection = null;
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    String str = "select substr(tt.Period_Name, 5, 6) years,count(*) aa,tt.ou_name,tt.ou_id from evs_voucher tt where tt.ou_id =" + paramLong + "  group by  substr(tt.Period_Name, 5, 6),tt.ou_name,tt.ou_id";
    localConnection = getSession().connection();
    ArrayList localArrayList = new ArrayList();
    try
    {
      localPreparedStatement = localConnection.prepareStatement(str.toString());
      localResultSet = localPreparedStatement.executeQuery();
      while (localResultSet.next())
      {
        FasciculeQueryModel localFasciculeQueryModel1 = new FasciculeQueryModel();
        localFasciculeQueryModel1.setYears(localResultSet.getString("years"));
        localFasciculeQueryModel1.setVouchersums(Long.valueOf(localResultSet.getLong("aa")));
        localFasciculeQueryModel1.setOuId(Long.valueOf(localResultSet.getLong("ou_id")));
        localArrayList.add(localFasciculeQueryModel1);
      }
      localPreparedStatement.close();
      localConnection.close();
      localResultSet.close();
    }
    catch (SQLException localSQLException)
    {
      localSQLException.printStackTrace();
    }
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      FasciculeQueryModel localFasciculeQueryModel2 = (FasciculeQueryModel)localIterator.next();
      localFasciculeQueryModel2.setTimes("20" + localFasciculeQueryModel2.getYears());
    }
    return localArrayList;
  }
  
  public List searchDate(String paramString1, String paramString2)
  {
    Connection localConnection = null;
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    String str = "select tt.ERP_ORG_ID from FBP_CHECK_UNIT_CONTENTS tt where tt.CHECK_UNIT='" + paramString1 + "'";
    localConnection = getSession().connection();
    ArrayList localArrayList1 = new ArrayList();
    try
    {
      localPreparedStatement = localConnection.prepareStatement(str.toString());
      localResultSet = localPreparedStatement.executeQuery();
      while (localResultSet.next())
      {
        FasciculeQueryModel localFasciculeQueryModel1 = new FasciculeQueryModel();
        localFasciculeQueryModel1.setOuId(Long.valueOf(localResultSet.getLong("ERP_ORG_ID")));
        localArrayList1.add(localFasciculeQueryModel1);
      }
      localPreparedStatement.close();
      localConnection.close();
      localResultSet.close();
    }
    catch (SQLException localSQLException)
    {
      localSQLException.printStackTrace();
    }
    Long localLong = ((FasciculeQueryModel)localArrayList1.get(0)).getOuId();
    ArrayList localArrayList2 = new ArrayList();
    List localList1 = findList8(localLong);
    List localList2 = findList9(localLong);
    List localList3 = findList4(localLong);
    FasciculeQueryModel localFasciculeQueryModel2 = null;
    Iterator localIterator1;
    FasciculeQueryModel localFasciculeQueryModel3;
    Iterator localIterator2;
    FasciculeQueryModel localFasciculeQueryModel4;
    if (!paramString2.toString().equals("-1"))
    {
      localIterator1 = localList2.iterator();
      while (localIterator1.hasNext())
      {
        localFasciculeQueryModel3 = (FasciculeQueryModel)localIterator1.next();
        localFasciculeQueryModel2 = new FasciculeQueryModel();
        localFasciculeQueryModel2.setOuId(localFasciculeQueryModel3.getOuId());
        localFasciculeQueryModel2.setMonth(localFasciculeQueryModel3.getTimes());
        localFasciculeQueryModel2.setVouchersums(localFasciculeQueryModel3.getVouchersums());
        localArrayList2.add(localFasciculeQueryModel2);
      }
      localIterator1 = localList1.iterator();
      while (localIterator1.hasNext())
      {
        localFasciculeQueryModel3 = (FasciculeQueryModel)localIterator1.next();
        localIterator2 = localArrayList2.iterator();
        while (localIterator2.hasNext())
        {
          localFasciculeQueryModel4 = (FasciculeQueryModel)localIterator2.next();
          if (localFasciculeQueryModel4.getMonth().equals(localFasciculeQueryModel3.getTimes())) {
            localFasciculeQueryModel4.setVoucherBooks(localFasciculeQueryModel3.getVoucherBooks());
          }
        }
      }
      localIterator1 = localList3.iterator();
      while (localIterator1.hasNext())
      {
        localFasciculeQueryModel3 = (FasciculeQueryModel)localIterator1.next();
        localIterator2 = localArrayList2.iterator();
        while (localIterator2.hasNext())
        {
          localFasciculeQueryModel4 = (FasciculeQueryModel)localIterator2.next();
          System.out.println(localFasciculeQueryModel3.getVoucherPages() + "page");
          localFasciculeQueryModel4.setVoucherPages(localFasciculeQueryModel3.getVoucherPages());
        }
      }
    }
    else
    {
      localIterator1 = localList2.iterator();
      while (localIterator1.hasNext())
      {
        localFasciculeQueryModel3 = (FasciculeQueryModel)localIterator1.next();
        localFasciculeQueryModel2 = new FasciculeQueryModel();
        localFasciculeQueryModel2.setOuId(localFasciculeQueryModel3.getOuId());
        localFasciculeQueryModel2.setMonth(localFasciculeQueryModel3.getTimes());
        localFasciculeQueryModel2.setVouchersums(localFasciculeQueryModel3.getVouchersums());
        localArrayList2.add(localFasciculeQueryModel2);
      }
      localIterator1 = localList1.iterator();
      while (localIterator1.hasNext())
      {
        localFasciculeQueryModel3 = (FasciculeQueryModel)localIterator1.next();
        localIterator2 = localArrayList2.iterator();
        while (localIterator2.hasNext())
        {
          localFasciculeQueryModel4 = (FasciculeQueryModel)localIterator2.next();
          if (localFasciculeQueryModel4.getMonth().equals(localFasciculeQueryModel3.getTimes())) {
            localFasciculeQueryModel4.setVoucherBooks(localFasciculeQueryModel3.getVoucherBooks());
          }
        }
      }
      localIterator1 = localList3.iterator();
      while (localIterator1.hasNext())
      {
        localFasciculeQueryModel3 = (FasciculeQueryModel)localIterator1.next();
        localIterator2 = localArrayList2.iterator();
        while (localIterator2.hasNext())
        {
          localFasciculeQueryModel4 = (FasciculeQueryModel)localIterator2.next();
          if (localFasciculeQueryModel4.getMonth().equals(localFasciculeQueryModel3.getTimes())) {
            localFasciculeQueryModel4.setVoucherPages(localFasciculeQueryModel3.getVoucherPages());
          }
        }
      }
    }
    return localArrayList2;
  }
  
  public List searchDate1(Long paramLong)
  {
    ArrayList localArrayList1 = new ArrayList();
    List localList1 = findList8(paramLong);
    List localList2 = findList9(paramLong);
    List localList3 = findList4(paramLong);
    System.out.println(localList1.size() + "---------------" + localList2.size() + "------------" + localList3.size());
    Object localObject = null;
    ArrayList localArrayList2 = new ArrayList();
    FasciculeQueryModel localFasciculeQueryModel1 = new FasciculeQueryModel();
    localFasciculeQueryModel1.setMonth("2009");
    localFasciculeQueryModel1.setVouchersums(Long.valueOf(0L));
    localFasciculeQueryModel1.setVoucherBooks(Long.valueOf(0L));
    localFasciculeQueryModel1.setVoucherPages(Long.valueOf(0L));
    localFasciculeQueryModel1.setOuId(Long.valueOf(0L));
    FasciculeQueryModel localFasciculeQueryModel2 = new FasciculeQueryModel();
    localFasciculeQueryModel2.setMonth("2010");
    localFasciculeQueryModel2.setVouchersums(Long.valueOf(0L));
    localFasciculeQueryModel2.setVoucherBooks(Long.valueOf(0L));
    localFasciculeQueryModel2.setVoucherPages(Long.valueOf(0L));
    localFasciculeQueryModel2.setOuId(Long.valueOf(0L));
    FasciculeQueryModel localFasciculeQueryModel3 = new FasciculeQueryModel();
    localFasciculeQueryModel3.setMonth("2011");
    localFasciculeQueryModel3.setVouchersums(Long.valueOf(0L));
    localFasciculeQueryModel3.setVoucherBooks(Long.valueOf(0L));
    localFasciculeQueryModel3.setVoucherPages(Long.valueOf(0L));
    localFasciculeQueryModel3.setOuId(Long.valueOf(0L));
    localArrayList2.add(localFasciculeQueryModel1);
    localArrayList2.add(localFasciculeQueryModel2);
    localArrayList2.add(localFasciculeQueryModel3);
    Iterator localIterator1 = localList2.iterator();
    FasciculeQueryModel localFasciculeQueryModel4;
    Iterator localIterator2;
    FasciculeQueryModel localFasciculeQueryModel5;
    while (localIterator1.hasNext())
    {
      localFasciculeQueryModel4 = (FasciculeQueryModel)localIterator1.next();
      localIterator2 = localArrayList2.iterator();
      while (localIterator2.hasNext())
      {
        localFasciculeQueryModel5 = (FasciculeQueryModel)localIterator2.next();
        System.out.println(localFasciculeQueryModel4.getTimes());
        if ((localFasciculeQueryModel4.getTimes() != null) && (!localFasciculeQueryModel4.getTimes().equals("")) && (localFasciculeQueryModel4.getTimes().equals(localFasciculeQueryModel5.getMonth())))
        {
          localFasciculeQueryModel5.setOuId(localFasciculeQueryModel4.getOuId());
          localFasciculeQueryModel5.setVouchersums(localFasciculeQueryModel4.getVouchersums());
        }
      }
    }
    localIterator1 = localList1.iterator();
    while (localIterator1.hasNext())
    {
      localFasciculeQueryModel4 = (FasciculeQueryModel)localIterator1.next();
      localIterator2 = localArrayList2.iterator();
      while (localIterator2.hasNext())
      {
        localFasciculeQueryModel5 = (FasciculeQueryModel)localIterator2.next();
        if (localFasciculeQueryModel5.getMonth().equals(localFasciculeQueryModel4.getTimes())) {
          localFasciculeQueryModel5.setVoucherBooks(localFasciculeQueryModel4.getVoucherBooks());
        }
      }
    }
    localIterator1 = localList3.iterator();
    while (localIterator1.hasNext())
    {
      localFasciculeQueryModel4 = (FasciculeQueryModel)localIterator1.next();
      localIterator2 = localArrayList2.iterator();
      while (localIterator2.hasNext())
      {
        localFasciculeQueryModel5 = (FasciculeQueryModel)localIterator2.next();
        if (localFasciculeQueryModel5.getMonth().equals(localFasciculeQueryModel4.getTimes())) {
          localFasciculeQueryModel5.setVoucherPages(localFasciculeQueryModel4.getVoucherPages());
        }
      }
    }
    return localArrayList2;
  }
  
  public List find()
  {
    Connection localConnection = null;
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    String str = "   select   count(*) aa,  tt.ou_id,   tt.ou_name from evs_voucher tt where substr(tt.Period_Name, 5, 6)=substr(to_char(sysdate,'yyyy')-1,3,4) group by tt.ou_id,tt.ou_name";
    localConnection = getSession().connection();
    ArrayList localArrayList = new ArrayList();
    try
    {
      localPreparedStatement = localConnection.prepareStatement(str.toString());
      localResultSet = localPreparedStatement.executeQuery();
      while (localResultSet.next())
      {
        FasciculeQueryModel localFasciculeQueryModel = new FasciculeQueryModel();
        localFasciculeQueryModel.setVouchersums(Long.valueOf(localResultSet.getLong("aa")));
        localFasciculeQueryModel.setOuId(Long.valueOf(localResultSet.getLong("ou_id")));
        localFasciculeQueryModel.setOuName(localResultSet.getString("ou_name"));
        localArrayList.add(localFasciculeQueryModel);
      }
      localPreparedStatement.close();
      localConnection.close();
      localResultSet.close();
    }
    catch (SQLException localSQLException)
    {
      localSQLException.printStackTrace();
    }
    return localArrayList;
  }
  
  public List find3()
  {
    Connection localConnection = null;
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    String str = "select   count(*) aa,  tt.ou_id,tt.ou_name from evs_voucher tt where substr(tt.Period_Name, 5, 6)=substr(to_char(sysdate,'yyyy'),3,4)   group by tt.ou_id,tt.ou_name";
    localConnection = getSession().connection();
    ArrayList localArrayList = new ArrayList();
    try
    {
      localPreparedStatement = localConnection.prepareStatement(str.toString());
      localResultSet = localPreparedStatement.executeQuery();
      while (localResultSet.next())
      {
        FasciculeQueryModel localFasciculeQueryModel = new FasciculeQueryModel();
        localFasciculeQueryModel.setVouchersums(Long.valueOf(localResultSet.getLong("aa")));
        localFasciculeQueryModel.setOuId(Long.valueOf(localResultSet.getLong("ou_id")));
        localFasciculeQueryModel.setOuName(localResultSet.getString("ou_name"));
        localFasciculeQueryModel.setVouchersums(Long.valueOf(localResultSet.getLong("aa")));
        localArrayList.add(localFasciculeQueryModel);
      }
      localPreparedStatement.close();
      localConnection.close();
      localResultSet.close();
    }
    catch (SQLException localSQLException)
    {
      localSQLException.printStackTrace();
    }
    return localArrayList;
  }
  
  public List find1()
  {
    Connection localConnection = null;
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    String str = "  select a.*, ch.check_unit_name ou_name from (select substr(eb.Period_Name, 5, 6) last_update_date, count(eb.book_id) aa,  eb.ou_name ou_id from evs.evs_book eb where substr(eb.Period_Name, 5, 6)=substr(to_char(sysdate,'yyyy')-1,3,4) group by substr(eb.Period_Name, 5, 6), eb.ou_name) a, fbp_check_unit_contents ch where ch.erp_org_id = a.ou_id";
    localConnection = getSession().connection();
    ArrayList localArrayList = new ArrayList();
    try
    {
      localPreparedStatement = localConnection.prepareStatement(str.toString());
      localResultSet = localPreparedStatement.executeQuery();
      while (localResultSet.next())
      {
        FasciculeQueryModel localFasciculeQueryModel = new FasciculeQueryModel();
        localFasciculeQueryModel.setVoucherBooks(Long.valueOf(localResultSet.getLong("aa")));
        localFasciculeQueryModel.setOuId(Long.valueOf(localResultSet.getLong("ou_id")));
        localFasciculeQueryModel.setOuName(localResultSet.getString("ou_name"));
        localArrayList.add(localFasciculeQueryModel);
      }
      localPreparedStatement.close();
      localConnection.close();
      localResultSet.close();
    }
    catch (SQLException localSQLException)
    {
      localSQLException.printStackTrace();
    }
    return localArrayList;
  }
  
  public List find4()
  {
    Connection localConnection = null;
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    String str = "   select a.*, ch.check_unit_name ou_name from (select substr(eb.Period_Name, 5, 6) last_update_date, count(eb.book_id) aa,  eb.ou_name ou_id from evs.evs_book eb where substr(eb.Period_Name, 5, 6)=substr(to_char(sysdate,'yyyy'),3,4) group by substr(eb.Period_Name, 5, 6), eb.ou_name) a, fbp_check_unit_contents ch where ch.erp_org_id = a.ou_id";
    localConnection = getSession().connection();
    ArrayList localArrayList = new ArrayList();
    try
    {
      localPreparedStatement = localConnection.prepareStatement(str.toString());
      localResultSet = localPreparedStatement.executeQuery();
      while (localResultSet.next())
      {
        FasciculeQueryModel localFasciculeQueryModel = new FasciculeQueryModel();
        localFasciculeQueryModel.setVoucherBooks(Long.valueOf(localResultSet.getLong("aa")));
        localFasciculeQueryModel.setOuId(Long.valueOf(localResultSet.getLong("ou_id")));
        localFasciculeQueryModel.setOuName(localResultSet.getString("ou_name"));
        localArrayList.add(localFasciculeQueryModel);
      }
      localPreparedStatement.close();
      localConnection.close();
      localResultSet.close();
    }
    catch (SQLException localSQLException)
    {
      localSQLException.printStackTrace();
    }
    return localArrayList;
  }
  
  public List find2()
  {
    Connection localConnection = null;
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    String str = "   select count(1) aa, ou_id,ou_name from ( select * from (select substr(ev.Period_Name, 5, 6) last_update_date,imag.voucher_id,ev.ou_id,ev.ou_name from evs_image imag, evs_voucher ev  where imag.voucher_id = ev.voucher_id) tt where tt.last_update_date = substr(to_char(sysdate, 'yyyy') - 1, 3, 4) ) group by last_update_date, ou_id, ou_name";
    localConnection = getSession().connection();
    ArrayList localArrayList = new ArrayList();
    try
    {
      localPreparedStatement = localConnection.prepareStatement(str.toString());
      localResultSet = localPreparedStatement.executeQuery();
      while (localResultSet.next())
      {
        FasciculeQueryModel localFasciculeQueryModel = new FasciculeQueryModel();
        localFasciculeQueryModel.setVoucherPages(Long.valueOf(localResultSet.getLong("aa")));
        localFasciculeQueryModel.setOuId(Long.valueOf(localResultSet.getLong("ou_id")));
        localFasciculeQueryModel.setOuName(localResultSet.getString("ou_name"));
        localArrayList.add(localFasciculeQueryModel);
      }
      localPreparedStatement.close();
      localConnection.close();
      localResultSet.close();
    }
    catch (SQLException localSQLException)
    {
      localSQLException.printStackTrace();
    }
    return localArrayList;
  }
  
  public List find5()
  {
    Connection localConnection = null;
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    String str = "  select count(1) aa, ou_id,ou_name from ( select * from (select substr(ev.Period_Name, 5, 6) last_update_date,imag.voucher_id,ev.ou_id,ev.ou_name from evs_image imag, evs_voucher ev  where imag.voucher_id = ev.voucher_id) tt where tt.last_update_date = substr(to_char(sysdate, 'yyyy'), 3, 4) ) group by last_update_date, ou_id, ou_name";
    localConnection = getSession().connection();
    ArrayList localArrayList = new ArrayList();
    try
    {
      localPreparedStatement = localConnection.prepareStatement(str.toString());
      localResultSet = localPreparedStatement.executeQuery();
      while (localResultSet.next())
      {
        FasciculeQueryModel localFasciculeQueryModel = new FasciculeQueryModel();
        localFasciculeQueryModel.setVoucherPages(Long.valueOf(localResultSet.getLong("aa")));
        localFasciculeQueryModel.setOuId(Long.valueOf(localResultSet.getLong("ou_id")));
        localFasciculeQueryModel.setOuName(localResultSet.getString("ou_name"));
        localArrayList.add(localFasciculeQueryModel);
      }
      localPreparedStatement.close();
      localConnection.close();
      localResultSet.close();
    }
    catch (SQLException localSQLException)
    {
      localSQLException.printStackTrace();
    }
    return localArrayList;
  }
  
  public List tt()
  {
    Connection localConnection = null;
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    String str = "   select ch.erp_org_id ou_id,ch.check_unit_name ou_name from fbp_check_unit_contents ch";
    localConnection = getSession().connection();
    ArrayList localArrayList = new ArrayList();
    try
    {
      localPreparedStatement = localConnection.prepareStatement(str.toString());
      localResultSet = localPreparedStatement.executeQuery();
      while (localResultSet.next())
      {
        FasciculeQueryModel localFasciculeQueryModel = new FasciculeQueryModel();
        localFasciculeQueryModel.setOuId(Long.valueOf(localResultSet.getLong("ou_id")));
        localFasciculeQueryModel.setOuName(localResultSet.getString("ou_name"));
        localArrayList.add(localFasciculeQueryModel);
      }
      localPreparedStatement.close();
      localConnection.close();
      localResultSet.close();
    }
    catch (SQLException localSQLException)
    {
      localSQLException.printStackTrace();
    }
    return localArrayList;
  }
  
  public List quaryDate()
  {
    List localList1 = find();
    List localList2 = find1();
    List localList3 = find2();
    List localList4 = find3();
    List localList5 = find4();
    List localList6 = find5();
    ArrayList localArrayList = new ArrayList();
    List localList7 = tt();
    FasciculeQueryModel localFasciculeQueryModel1 = null;
    Iterator localIterator1 = localList7.iterator();
    while (localIterator1.hasNext())
    {
      localObject = (FasciculeQueryModel)localIterator1.next();
      localFasciculeQueryModel1 = new FasciculeQueryModel();
      localFasciculeQueryModel1.setOuId(((FasciculeQueryModel)localObject).getOuId());
      localFasciculeQueryModel1.setOuName(((FasciculeQueryModel)localObject).getOuName());
      localArrayList.add(localFasciculeQueryModel1);
    }
    localIterator1 = null;
    Object localObject = localArrayList.iterator();
    FasciculeQueryModel localFasciculeQueryModel2;
    Iterator localIterator2;
    FasciculeQueryModel localFasciculeQueryModel3;
    while (((Iterator)localObject).hasNext())
    {
      localFasciculeQueryModel2 = (FasciculeQueryModel)((Iterator)localObject).next();
      localIterator2 = localList1.iterator();
      while (localIterator2.hasNext())
      {
        localFasciculeQueryModel3 = (FasciculeQueryModel)localIterator2.next();
        if ((localFasciculeQueryModel3.getOuId() != null) && (localFasciculeQueryModel3.getOuName() != null) && (localFasciculeQueryModel3.getOuId() == localFasciculeQueryModel2.getOuId()) && (localFasciculeQueryModel3.getOuName().equals(localFasciculeQueryModel2.getOuName()))) {
          localFasciculeQueryModel2.setVouchersums(localFasciculeQueryModel3.getVouchersums());
        }
      }
    }
    localObject = localArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localFasciculeQueryModel2 = (FasciculeQueryModel)((Iterator)localObject).next();
      localIterator2 = localList2.iterator();
      while (localIterator2.hasNext())
      {
        localFasciculeQueryModel3 = (FasciculeQueryModel)localIterator2.next();
        if ((localFasciculeQueryModel2.getOuId() != null) && (localFasciculeQueryModel2.getOuName() != null) && (localFasciculeQueryModel3.getOuId() == localFasciculeQueryModel2.getOuId()) && (localFasciculeQueryModel3.getOuName().equals(localFasciculeQueryModel2.getOuName()))) {
          localFasciculeQueryModel2.setVoucherBooks(localFasciculeQueryModel3.getVoucherBooks());
        }
      }
    }
    localObject = localArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localFasciculeQueryModel2 = (FasciculeQueryModel)((Iterator)localObject).next();
      localIterator2 = localList3.iterator();
      while (localIterator2.hasNext())
      {
        localFasciculeQueryModel3 = (FasciculeQueryModel)localIterator2.next();
        if ((localFasciculeQueryModel2.getOuId() != null) && (localFasciculeQueryModel2.getOuName() != null) && (localFasciculeQueryModel3.getOuId() == localFasciculeQueryModel2.getOuId()) && (localFasciculeQueryModel3.getOuName().equals(localFasciculeQueryModel2.getOuName()))) {
          localFasciculeQueryModel2.setVoucherPages(localFasciculeQueryModel3.getVoucherPages());
        }
      }
    }
    localObject = localArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localFasciculeQueryModel2 = (FasciculeQueryModel)((Iterator)localObject).next();
      localIterator2 = localList4.iterator();
      while (localIterator2.hasNext())
      {
        localFasciculeQueryModel3 = (FasciculeQueryModel)localIterator2.next();
        if ((localFasciculeQueryModel2.getOuId() != null) && (localFasciculeQueryModel2.getOuName() != null) && (!localFasciculeQueryModel2.getOuName().equals("")) && (localFasciculeQueryModel3.getOuId() != null) && (localFasciculeQueryModel3.getOuId() == localFasciculeQueryModel2.getOuId())) {
          localFasciculeQueryModel2.setVouchersums_sb(localFasciculeQueryModel3.getVouchersums());
        }
      }
    }
    localObject = localArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localFasciculeQueryModel2 = (FasciculeQueryModel)((Iterator)localObject).next();
      localIterator2 = localList5.iterator();
      while (localIterator2.hasNext())
      {
        localFasciculeQueryModel3 = (FasciculeQueryModel)localIterator2.next();
        if ((localFasciculeQueryModel2.getOuId() != null) && (localFasciculeQueryModel2.getOuName() != null) && (localFasciculeQueryModel3.getOuId() == localFasciculeQueryModel2.getOuId()) && (localFasciculeQueryModel3.getOuName().equals(localFasciculeQueryModel2.getOuName()))) {
          localFasciculeQueryModel2.setVoucherBooks_sb(localFasciculeQueryModel3.getVoucherBooks());
        }
      }
    }
    localObject = localArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localFasciculeQueryModel2 = (FasciculeQueryModel)((Iterator)localObject).next();
      localIterator2 = localList6.iterator();
      while (localIterator2.hasNext())
      {
        localFasciculeQueryModel3 = (FasciculeQueryModel)localIterator2.next();
        if ((localFasciculeQueryModel2.getOuId() != null) && (localFasciculeQueryModel2.getOuName() != null) && (localFasciculeQueryModel3.getOuId() == localFasciculeQueryModel2.getOuId()) && (localFasciculeQueryModel3.getOuName().equals(localFasciculeQueryModel2.getOuName()))) {
          localFasciculeQueryModel2.setVoucherPages_sb(localFasciculeQueryModel3.getVoucherPages());
        }
      }
    }
    return localArrayList;
  }
  
  public List findTree(BigInteger paramBigInteger)
  {
    System.out.println(paramBigInteger);
    return getSession().createQuery("from FasciculeTreeV b where b.parentId =:deptId").setBigInteger("deptId", paramBigInteger).list();
  }
  
  public List findPeriodsByThisYear2(String paramString1, String paramString2, String paramString3)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    if (paramString2 != null) {
      paramString2 = paramString2.toString().substring(2);
    } else {
      paramString2 = "-1";
    }
    if (paramString3.equals("1月")) {
      paramString3 = "JAN";
    } else if (paramString3.equals("2月")) {
      paramString3 = "FEB";
    } else if (paramString3.equals("3月")) {
      paramString3 = "MAR";
    } else if (paramString3.equals("4月")) {
      paramString3 = "APR";
    } else if (paramString3.equals("5月")) {
      paramString3 = "MAY";
    } else if (paramString3.equals("6月")) {
      paramString3 = "JUN";
    } else if (paramString3.equals("7月")) {
      paramString3 = "JUL";
    } else if (paramString3.equals("8月")) {
      paramString3 = "AUG";
    } else if (paramString3.equals("9月")) {
      paramString3 = "SEP";
    } else if (paramString3.equals("10月")) {
      paramString3 = "OCT";
    } else if (paramString3.equals("11月")) {
      paramString3 = "NOV";
    } else if (paramString3.equals("12月")) {
      paramString3 = "DEC";
    }
    String str = paramString3 + "-" + paramString2.toString();
    List localList1 = find11(str, paramString1);
    List localList2 = find12(str, paramString1);
    List localList3 = find13(str, paramString1);
    List localList4 = find14();
    Iterator localIterator1 = localList1.iterator();
    EvsVoucherMonthV localEvsVoucherMonthV1;
    Iterator localIterator2;
    EvsVoucherMonthV localEvsVoucherMonthV2;
    while (localIterator1.hasNext())
    {
      localEvsVoucherMonthV1 = (EvsVoucherMonthV)localIterator1.next();
      System.out.println(localEvsVoucherMonthV1.getBookNumber() + "++++++++++++++++=============");
      localIterator2 = localList4.iterator();
      while (localIterator2.hasNext())
      {
        localEvsVoucherMonthV2 = (EvsVoucherMonthV)localIterator2.next();
        if (localEvsVoucherMonthV1.getJournalName().equals(localEvsVoucherMonthV2.getJournalName())) {
          localEvsVoucherMonthV2.setBookNumber(localEvsVoucherMonthV1.getBookNumber());
        }
      }
    }
    localIterator1 = localList2.iterator();
    while (localIterator1.hasNext())
    {
      localEvsVoucherMonthV1 = (EvsVoucherMonthV)localIterator1.next();
      localIterator2 = localList4.iterator();
      while (localIterator2.hasNext())
      {
        localEvsVoucherMonthV2 = (EvsVoucherMonthV)localIterator2.next();
        System.out.println(localEvsVoucherMonthV1.getMarkNumber() + "++++++++++++++++");
        if (localEvsVoucherMonthV1.getJournalName().equals(localEvsVoucherMonthV2.getJournalName())) {
          localEvsVoucherMonthV2.setMarkNumber(localEvsVoucherMonthV1.getMarkNumber());
        }
      }
    }
    localIterator1 = localList3.iterator();
    while (localIterator1.hasNext())
    {
      localEvsVoucherMonthV1 = (EvsVoucherMonthV)localIterator1.next();
      localIterator2 = localList4.iterator();
      while (localIterator2.hasNext())
      {
        System.out.println(localEvsVoucherMonthV1.getBooknotNumber() + "++++++++++++++++---------------");
        localEvsVoucherMonthV2 = (EvsVoucherMonthV)localIterator2.next();
        if (localEvsVoucherMonthV1.getJournalName().equals(localEvsVoucherMonthV2.getJournalName())) {
          localEvsVoucherMonthV2.setBooknotNumber(localEvsVoucherMonthV1.getBooknotNumber());
        }
      }
    }
    localIterator1 = localList4.iterator();
    while (localIterator1.hasNext())
    {
      localEvsVoucherMonthV1 = (EvsVoucherMonthV)localIterator1.next();
      if (localEvsVoucherMonthV1.getMarkNumber() == null) {
        localEvsVoucherMonthV1.setMarkNumber(new BigDecimal("0"));
      }
      if (localEvsVoucherMonthV1.getBookNumber() == null) {
        localEvsVoucherMonthV1.setBookNumber(new BigDecimal("0"));
      }
      if (localEvsVoucherMonthV1.getBooknotNumber() == null) {
        localEvsVoucherMonthV1.setBooknotNumber(new BigDecimal("0"));
      }
    }
    System.out.println(localList4.size() + "新的");
    return localList4;
  }
  
  public List findPeriodsByThisYear3(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Connection localConnection = null;
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    if (paramString2 != null) {
      paramString2 = paramString2.toString().substring(2);
    } else {
      paramString2 = "-1";
    }
    if (paramString3.equals("1月")) {
      paramString3 = "JAN";
    } else if (paramString3.equals("2月")) {
      paramString3 = "FEB";
    } else if (paramString3.equals("3月")) {
      paramString3 = "MAR";
    } else if (paramString3.equals("4月")) {
      paramString3 = "APR";
    } else if (paramString3.equals("5月")) {
      paramString3 = "MAY";
    } else if (paramString3.equals("6月")) {
      paramString3 = "JUN";
    } else if (paramString3.equals("7月")) {
      paramString3 = "JUL";
    } else if (paramString3.equals("8月")) {
      paramString3 = "AUG";
    } else if (paramString3.equals("9月")) {
      paramString3 = "SEP";
    } else if (paramString3.equals("10月")) {
      paramString3 = "OCT";
    } else if (paramString3.equals("11月")) {
      paramString3 = "NOV";
    } else if (paramString3.equals("12月")) {
      paramString3 = "DEC";
    }
    String str1 = paramString3 + "-" + paramString2.toString();
    System.out.println(paramString4 + "===" + str1 + "---------" + paramString1);
    localConnection = getSession().connection();
    ArrayList localArrayList = new ArrayList();
    String str2 = "select e2.BOOK_ID,e2.BOOK_CODE,e2.ARCHIVE_NUMBER,e2.BEGIN_NUM,e2.END_NUM,e2.BOOK_DATE,e2.BOOK_BREAK_FLAG,(select f.meaning from apps.fbp_lookup_values_v f where f.lookup_code=e2.BOOK_STATUS) as book_status from Evs_book e2 where e2.book_id in (select distinct ee.book_id from EVS_VOUCHER_BOOK_PACKAGE ee  where ee.voucher_id in (select e.voucher_id from Evs_Voucher e where e.journal_name = '" + paramString4 + "')) and e2.period_name='" + str1 + "' and e2.ou_name=" + paramString1;
    try
    {
      localPreparedStatement = localConnection.prepareStatement(str2.toString());
      localResultSet = localPreparedStatement.executeQuery();
      while (localResultSet.next())
      {
        EvsBook localEvsBook = new EvsBook();
        localEvsBook.setBookId(Long.valueOf(localResultSet.getLong("BOOK_ID")));
        localEvsBook.setBookCode(localResultSet.getString("BOOK_CODE"));
        localEvsBook.setArchiveNumber(localResultSet.getString("ARCHIVE_NUMBER"));
        localEvsBook.setBeginNum(localResultSet.getString("BEGIN_NUM"));
        localEvsBook.setEndNum(localResultSet.getString("END_NUM"));
        localEvsBook.setBookDate(localResultSet.getDate("BOOK_DATE"));
        localEvsBook.setBookBreakFlag(localResultSet.getString("BOOK_BREAK_FLAG"));
        localEvsBook.setBookStatus(localResultSet.getString("BOOK_STATUS"));
        localArrayList.add(localEvsBook);
      }
      System.out.println(localArrayList.size() + "..................");
      localPreparedStatement.close();
      localConnection.close();
      localResultSet.close();
    }
    catch (SQLException localSQLException)
    {
      localSQLException.printStackTrace();
    }
    return localArrayList;
  }
  
  public List findQuaryInfoByMonth(String paramString1, String paramString2, String paramString3)
  {
    Connection localConnection = null;
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    if (paramString2 != null) {
      paramString2 = paramString2.toString().substring(2);
    } else {
      paramString2 = "-1";
    }
    if (paramString3.equals("1月")) {
      paramString3 = "JAN";
    } else if (paramString3.equals("2月")) {
      paramString3 = "FEB";
    } else if (paramString3.equals("3月")) {
      paramString3 = "MAR";
    } else if (paramString3.equals("4月")) {
      paramString3 = "APR";
    } else if (paramString3.equals("5月")) {
      paramString3 = "MAY";
    } else if (paramString3.equals("6月")) {
      paramString3 = "JUN";
    } else if (paramString3.equals("7月")) {
      paramString3 = "JUL";
    } else if (paramString3.equals("8月")) {
      paramString3 = "AUG";
    } else if (paramString3.equals("9月")) {
      paramString3 = "SEP";
    } else if (paramString3.equals("10月")) {
      paramString3 = "OCT";
    } else if (paramString3.equals("11月")) {
      paramString3 = "NOV";
    } else if (paramString3.equals("12月")) {
      paramString3 = "DEC";
    }
    String str1 = paramString3 + "-" + paramString2.toString();
    System.out.println(str1 + "----------------------------------");
    String str2 = " select sum(b.book_number) book_number,sum(b.mark_number) mark_number,sum(b.booknot_number) booknot_number,b.journal_name from evs_voucher_month_v b where b.last_update_date= '" + str1 + "'and b.ou_id = " + paramString1 + " group by b.journal_name";
    System.out.println(str2);
    localConnection = getSession().connection();
    ArrayList localArrayList = new ArrayList();
    try
    {
      localPreparedStatement = localConnection.prepareStatement(str2.toString());
      localResultSet = localPreparedStatement.executeQuery();
      while (localResultSet.next())
      {
        EvsVoucherMonthV localEvsVoucherMonthV = new EvsVoucherMonthV();
        localEvsVoucherMonthV.setJournalName(localResultSet.getString("journal_name"));
        localEvsVoucherMonthV.setMarkNumber(localResultSet.getBigDecimal("mark_number"));
        localEvsVoucherMonthV.setBookNumber(localResultSet.getBigDecimal("book_number"));
        localEvsVoucherMonthV.setBooknotNumber(localResultSet.getBigDecimal("booknot_number"));
        localArrayList.add(localEvsVoucherMonthV);
      }
      System.out.println(localArrayList.size() + "..................");
      localPreparedStatement.close();
      localConnection.close();
      localResultSet.close();
    }
    catch (SQLException localSQLException)
    {
      localSQLException.printStackTrace();
    }
    return localArrayList;
  }
  
  public List find11(String paramString1, String paramString2)
  {
    Connection localConnection = null;
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    localConnection = getSession().connection();
    ArrayList localArrayList = new ArrayList();
    String str = " select count(distinct b.book_id) book_number, h.journal_name,b.ou_name,b.period_name from EVS_VOUCHER h ,EVS_VOUCHER_BOOK_PACKAGE bp ,evs_book b where h.VOUCHER_ID = bp.voucher_id and bp.book_id = b.book_id and b.period_name='" + paramString1 + "' and b.ou_name=" + paramString2 + "group by h.journal_name,b.ou_name,b.period_name";
    System.out.println(str);
    try
    {
      localPreparedStatement = localConnection.prepareStatement(str.toString());
      localResultSet = localPreparedStatement.executeQuery();
      while (localResultSet.next())
      {
        EvsVoucherMonthV localEvsVoucherMonthV = new EvsVoucherMonthV();
        localEvsVoucherMonthV.setBookNumber(localResultSet.getBigDecimal("book_number"));
        localEvsVoucherMonthV.setJournalName(localResultSet.getString("journal_name"));
        localEvsVoucherMonthV.setOuId(Long.valueOf(localResultSet.getLong("ou_name")));
        localEvsVoucherMonthV.setPeriodName(localResultSet.getString("period_name"));
        localArrayList.add(localEvsVoucherMonthV);
      }
      localPreparedStatement.close();
      localConnection.close();
      localResultSet.close();
    }
    catch (SQLException localSQLException)
    {
      localSQLException.printStackTrace();
    }
    return localArrayList;
  }
  
  public List find12(String paramString1, String paramString2)
  {
    Connection localConnection = null;
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    localConnection = getSession().connection();
    ArrayList localArrayList = new ArrayList();
    String str = "select count(ev.voucher_id) mark_number, ev.journal_name,ev.ou_id, ev.period_name from evs.evs_voucher ev where ev.ou_id=" + paramString2 + " and ev.period_name= '" + paramString1 + "' group by ev.journal_name,ev.ou_id, ev.period_name";
    System.out.println(str);
    try
    {
      localPreparedStatement = localConnection.prepareStatement(str.toString());
      localResultSet = localPreparedStatement.executeQuery();
      while (localResultSet.next())
      {
        EvsVoucherMonthV localEvsVoucherMonthV = new EvsVoucherMonthV();
        localEvsVoucherMonthV.setMarkNumber(localResultSet.getBigDecimal("mark_number"));
        localEvsVoucherMonthV.setJournalName(localResultSet.getString("journal_name"));
        localEvsVoucherMonthV.setOuId(Long.valueOf(localResultSet.getLong("ou_id")));
        localEvsVoucherMonthV.setPeriodName(localResultSet.getString("period_name"));
        localArrayList.add(localEvsVoucherMonthV);
      }
      localPreparedStatement.close();
      localConnection.close();
      localResultSet.close();
    }
    catch (SQLException localSQLException)
    {
      localSQLException.printStackTrace();
    }
    return localArrayList;
  }
  
  public List find13(String paramString1, String paramString2)
  {
    Connection localConnection = null;
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    localConnection = getSession().connection();
    ArrayList localArrayList = new ArrayList();
    String str = "select count(ev.voucher_id) booknot_number,ev.journal_name,ev.ou_id,ev.period_name from evs.evs_voucher ev where  ev.voucher_status in('UNMATCH','MATCHED','SUBMITED','CHECKED','BACKED','UNBOOKED')  and ev.period_name= '" + paramString1 + "' and ev.ou_id=" + paramString2 + " group by ev.journal_name,ev.ou_id,ev.period_name";
    System.out.println(str);
    try
    {
      localPreparedStatement = localConnection.prepareStatement(str.toString());
      localResultSet = localPreparedStatement.executeQuery();
      while (localResultSet.next())
      {
        EvsVoucherMonthV localEvsVoucherMonthV = new EvsVoucherMonthV();
        localEvsVoucherMonthV.setBooknotNumber(localResultSet.getBigDecimal("booknot_number"));
        localEvsVoucherMonthV.setJournalName(localResultSet.getString("journal_name"));
        localEvsVoucherMonthV.setOuId(Long.valueOf(localResultSet.getLong("ou_id")));
        localEvsVoucherMonthV.setPeriodName(localResultSet.getString("period_name"));
        localArrayList.add(localEvsVoucherMonthV);
      }
      localPreparedStatement.close();
      localConnection.close();
      localResultSet.close();
    }
    catch (SQLException localSQLException)
    {
      localSQLException.printStackTrace();
    }
    return localArrayList;
  }
  
  public List find14()
  {
    Connection localConnection = null;
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    localConnection = getSession().connection();
    ArrayList localArrayList = new ArrayList();
    String str = "select e.journal_name  from evs_voucher e group by e.journal_name";
    try
    {
      localPreparedStatement = localConnection.prepareStatement(str.toString());
      localResultSet = localPreparedStatement.executeQuery();
      while (localResultSet.next())
      {
        EvsVoucherMonthV localEvsVoucherMonthV = new EvsVoucherMonthV();
        localEvsVoucherMonthV.setJournalName(localResultSet.getString("journal_name"));
        localArrayList.add(localEvsVoucherMonthV);
      }
      localPreparedStatement.close();
      localConnection.close();
      localResultSet.close();
    }
    catch (SQLException localSQLException)
    {
      localSQLException.printStackTrace();
    }
    return localArrayList;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.eBillManage.FasciculeQueryDAO
 * JD-Core Version:    0.7.0.1
 */