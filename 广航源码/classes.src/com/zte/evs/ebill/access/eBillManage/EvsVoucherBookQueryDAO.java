package com.zte.evs.ebill.access.eBillManage;

import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.eas.getData.util.EisConsts;
import com.zte.eas.organization.business.countcompanymanage.model.FbpCompanyV;
import com.zte.eimage.access.baseconfig.dao.IImageCommonDAO;
import com.zte.evs.ebill.model.eBillManage.EvsBook;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherStatistics;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.util.Util;
import com.zte.ssb.zorm.Query;
import com.zte.ssb.zorm.Session;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvsVoucherBookQueryDAO
  extends BaseDAO
  implements IEvsVoucherBookQueryDAO
{
  private StringBuffer year = null;
  
  public Map findBookByVoucherType(EvsVoucherStatistics paramEvsVoucherStatistics, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(" select * from evs_book bv");
    localStringBuffer.append(" where bv.book_status <> 'UNBOOK'");
    if (!Util.isStrEmpty(paramEvsVoucherStatistics.getCompanyCode())) {
      localStringBuffer.append(" and bv.company_code = '" + paramEvsVoucherStatistics.getCompanyCode() + "'");
    }
    if (!Util.isStrEmpty(paramEvsVoucherStatistics.getVoucherBigCode())) {
      localStringBuffer.append(" and bv.invoice_type = '" + paramEvsVoucherStatistics.getVoucherBigCode() + "'");
    }
    if (!Util.isStrEmpty(paramEvsVoucherStatistics.getYears()))
    {
      localStringBuffer.append(" and decode(INSTR(bv.Period_Name, '-'), 0,substr(bv.Period_Name, 1, 4),substr(bv.Period_Name, 5, 6)) =");
      localStringBuffer.append(" decode(INSTR(bv.Period_Name, '-'), 0, '" + paramEvsVoucherStatistics.getYears() + "', '" + paramEvsVoucherStatistics.getYears().substring(2, 4) + "')");
    }
    if (!Util.isStrEmpty(paramEvsVoucherStatistics.getMonth()))
    {
      localObject = Integer.valueOf(paramEvsVoucherStatistics.getMonth()).intValue() < 10 ? "0" + paramEvsVoucherStatistics.getMonth() : paramEvsVoucherStatistics.getMonth();
      localStringBuffer.append(" and decode(INSTR(bv.Period_Name, '-'),0,substr(bv.Period_Name, 5, 6),substr(bv.Period_Name, 1, 3)) =");
      localStringBuffer.append(" decode(INSTR(bv.Period_Name, '-'),0,'" + (String)localObject + "', '" + EisConsts.getCMonth(Integer.valueOf(paramEvsVoucherStatistics.getMonth()).intValue()) + "')");
    }
    Object localObject = (IImageCommonDAO)SSBBus.findDomainService("imageCommonDAO");
    PageInfo localPageInfo = ((IImageCommonDAO)localObject).pageInfoObjectBySql(localStringBuffer.toString(), null, EvsBook.class, paramInt1 / paramInt2 + 1, paramInt2);
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", localPageInfo.getResult());
    localHashMap.put("totalCount", Long.valueOf(localPageInfo.getTotalCount()));
    return localHashMap;
  }
  
  public Long getNotBookNum(EvsVoucherStatistics paramEvsVoucherStatistics)
  {
    Connection localConnection = null;
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(" select count(ev.voucher_id) total");
    localStringBuffer.append(" from evs_voucher ev where  1=1");
    if (!Util.isStrEmpty(paramEvsVoucherStatistics.getCompanyCode())) {
      localStringBuffer.append(" and ev.company_code = '" + paramEvsVoucherStatistics.getCompanyCode() + "'");
    }
    localStringBuffer.append(" and ev.voucher_status in ('UNMATCH', 'MATCHED')");
    if (!Util.isStrEmpty(paramEvsVoucherStatistics.getYears())) {
      localStringBuffer.append(" and decode(INSTR(ev.Period_Name, '-'),0,substr(ev.Period_Name, 1, 4),substr(ev.Period_Name, 5, 6)) = decode(INSTR(ev.Period_Name, '-'),0,'" + paramEvsVoucherStatistics.getYears() + "','" + paramEvsVoucherStatistics.getYears().substring(2, 4) + "')");
    }
    if (!Util.isStrEmpty(paramEvsVoucherStatistics.getMonth())) {
      localStringBuffer.append(" and decode(INSTR(ev.Period_Name, '-'),0,substr(ev.Period_Name, 5, 6),substr(ev.Period_Name, 1, 3))  = decode(INSTR(ev.Period_Name, '-'),0, '" + paramEvsVoucherStatistics.getChinaMonth() + "' , '" + paramEvsVoucherStatistics.getMonth() + "')");
    }
    if (!Util.isStrEmpty(paramEvsVoucherStatistics.getVoucherBigCode())) {
      localStringBuffer.append(" and ev.invoice_type_code = '" + paramEvsVoucherStatistics.getVoucherBigCode() + "'");
    }
    try
    {
      localConnection = getSession().connection();
      localPreparedStatement = localConnection.prepareStatement(localStringBuffer.toString());
      localResultSet = localPreparedStatement.executeQuery();
      if (localResultSet.next())
      {
        Long localLong = Long.valueOf(localResultSet.getLong("total"));
        return localLong;
      }
      return Long.valueOf(0L);
    }
    catch (SQLException localSQLException)
    {
      localSQLException.printStackTrace();
    }
    finally
    {
      try
      {
        localPreparedStatement.close();
        localConnection.close();
        localResultSet.close();
      }
      catch (Exception localException4)
      {
        localException4.printStackTrace();
      }
    }
  }
  
  public Long getVoucherContrastNum(EvsVoucherStatistics paramEvsVoucherStatistics)
  {
    Connection localConnection = null;
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(" select count(ev.voucher_id) total");
    localStringBuffer.append(" from evs_voucher ev where 1=1 ");
    if (!Util.isStrEmpty(paramEvsVoucherStatistics.getCompanyCode())) {
      localStringBuffer.append(" and ev.company_code = '" + paramEvsVoucherStatistics.getCompanyCode() + "'");
    }
    if (!Util.isStrEmpty(paramEvsVoucherStatistics.getYears())) {
      localStringBuffer.append(" and decode(INSTR(ev.Period_Name, '-'),0,substr(ev.Period_Name, 1, 4),substr(ev.Period_Name, 5, 6)) = decode(INSTR(ev.Period_Name, '-'),0,'" + paramEvsVoucherStatistics.getYears() + "','" + paramEvsVoucherStatistics.getYears().substring(2, 4) + "')");
    }
    if (!Util.isStrEmpty(paramEvsVoucherStatistics.getMonth())) {
      localStringBuffer.append(" and decode(INSTR(ev.Period_Name, '-'),0,substr(ev.Period_Name, 5, 6),substr(ev.Period_Name, 1, 3))  = decode(INSTR(ev.Period_Name, '-'),0, '" + paramEvsVoucherStatistics.getChinaMonth() + "' , '" + paramEvsVoucherStatistics.getMonth() + "')");
    }
    if (!Util.isStrEmpty(paramEvsVoucherStatistics.getVoucherBigCode())) {
      localStringBuffer.append(" and ev.invoice_type_code = '" + paramEvsVoucherStatistics.getVoucherBigCode() + "'");
    }
    try
    {
      localConnection = getSession().connection();
      localPreparedStatement = localConnection.prepareStatement(localStringBuffer.toString());
      localResultSet = localPreparedStatement.executeQuery();
      if (localResultSet.next())
      {
        Long localLong = Long.valueOf(localResultSet.getLong("total"));
        return localLong;
      }
      return Long.valueOf(0L);
    }
    catch (SQLException localSQLException)
    {
      localSQLException.printStackTrace();
    }
    finally
    {
      try
      {
        localPreparedStatement.close();
        localConnection.close();
        localResultSet.close();
      }
      catch (Exception localException4)
      {
        localException4.printStackTrace();
      }
    }
  }
  
  public Long getVoucherTotalBookNum(EvsVoucherStatistics paramEvsVoucherStatistics)
  {
    Connection localConnection = null;
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(" select count(eb.book_id) total");
    localStringBuffer.append(" from evs_book eb");
    localStringBuffer.append(" where 1=1 ");
    if (!Util.isStrEmpty(paramEvsVoucherStatistics.getCompanyCode())) {
      localStringBuffer.append(" and eb.company_code = '" + paramEvsVoucherStatistics.getCompanyCode() + "'");
    }
    localStringBuffer.append(" and eb.book_status not in ('UNBOOK')");
    if (!Util.isStrEmpty(paramEvsVoucherStatistics.getYears())) {
      localStringBuffer.append(" and decode(INSTR(eb.Period_Name, '-'),0,substr(eb.Period_Name, 1, 4),substr(eb.Period_Name, 5, 6)) = decode(INSTR(eb.Period_Name, '-'),0,'" + paramEvsVoucherStatistics.getYears() + "','" + paramEvsVoucherStatistics.getYears().substring(2, 4) + "')");
    }
    if (!Util.isStrEmpty(paramEvsVoucherStatistics.getMonth())) {
      localStringBuffer.append(" and decode(INSTR(eb.Period_Name, '-'),0,substr(eb.Period_Name, 5, 6),substr(eb.Period_Name, 1, 3))  = decode(INSTR(eb.Period_Name, '-'),0, '" + paramEvsVoucherStatistics.getChinaMonth() + "' , '" + paramEvsVoucherStatistics.getMonth() + "')");
    }
    if (!Util.isStrEmpty(paramEvsVoucherStatistics.getVoucherBigCode())) {
      localStringBuffer.append(" and eb.invoice_type = '" + paramEvsVoucherStatistics.getVoucherBigCode() + "'");
    }
    try
    {
      localConnection = getSession().connection();
      localPreparedStatement = localConnection.prepareStatement(localStringBuffer.toString());
      localResultSet = localPreparedStatement.executeQuery();
      if (localResultSet.next())
      {
        Long localLong = Long.valueOf(localResultSet.getLong("total"));
        return localLong;
      }
      return Long.valueOf(0L);
    }
    catch (SQLException localSQLException)
    {
      localSQLException.printStackTrace();
    }
    finally
    {
      try
      {
        localPreparedStatement.close();
        localConnection.close();
        localResultSet.close();
      }
      catch (Exception localException4)
      {
        localException4.printStackTrace();
      }
    }
  }
  
  public List<EvsVoucherStatistics> findVoucherNumber(String paramString1, String paramString2)
  {
    Connection localConnection = null;
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(" select decode(INSTR(tt.Period_Name, '-'),0,substr(tt.Period_Name, 1, 4),'20'||substr(tt.Period_Name, 5, 6)) years, count(1) total");
    localStringBuffer.append(" from evs_voucher tt");
    localStringBuffer.append(" where 1 = 1 and tt.company_code = ?");
    localStringBuffer.append(" and decode(INSTR(tt.Period_Name, '-'),0,substr(tt.Period_Name, 1, 4),'20'||substr(tt.Period_Name, 5, 6)) =?");
    localStringBuffer.append(" group by decode(INSTR(tt.Period_Name, '-'),0,substr(tt.Period_Name, 1, 4),'20'||substr(tt.Period_Name, 5, 6))");
    localConnection = getSession().connection();
    localArrayList = new ArrayList();
    try
    {
      localPreparedStatement = localConnection.prepareStatement(localStringBuffer.toString());
      localPreparedStatement.setString(1, paramString1);
      localPreparedStatement.setString(2, paramString2);
      localResultSet = localPreparedStatement.executeQuery();
      while (localResultSet.next())
      {
        this.year = new StringBuffer(new SimpleDateFormat("yyyy").format(new Date()).substring(0, 2));
        EvsVoucherStatistics localEvsVoucherStatistics = new EvsVoucherStatistics();
        localEvsVoucherStatistics.setYears(localResultSet.getString("years"));
        localEvsVoucherStatistics.setVoucherNumber(Long.valueOf(localResultSet.getLong("total")));
        localArrayList.add(localEvsVoucherStatistics);
      }
      return localArrayList;
    }
    catch (SQLException localSQLException)
    {
      localSQLException.printStackTrace();
    }
    finally
    {
      try
      {
        if (localPreparedStatement != null) {
          localPreparedStatement.close();
        }
        if (localConnection != null) {
          localConnection.close();
        }
        if (localResultSet != null) {
          localResultSet.close();
        }
      }
      catch (Exception localException3)
      {
        localException3.printStackTrace();
      }
    }
  }
  
  public List<EvsVoucherStatistics> findVoucherBookNumber(String paramString1, String paramString2)
  {
    Connection localConnection = null;
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(" select decode(INSTR(b.Period_Name, '-'),0,substr(b.Period_Name, 1, 4),'20'||substr(b.Period_Name, 5, 6)) years,  count(1) total from evs.evs_book b where ");
    localStringBuffer.append(" b.book_status <> 'UNBOOK' and b.company_code = ? and decode(INSTR(b.Period_Name, '-'),0,substr(b.Period_Name, 1, 4),'20'||substr(b.Period_Name, 5, 6)) =? ");
    localStringBuffer.append("  group by  decode(INSTR(b.Period_Name, '-'),0,substr(b.Period_Name, 1, 4),'20'||substr(b.Period_Name, 5, 6))");
    localConnection = getSession().connection();
    localArrayList = new ArrayList();
    try
    {
      localPreparedStatement = localConnection.prepareStatement(localStringBuffer.toString());
      localPreparedStatement.setString(1, paramString1);
      localPreparedStatement.setString(2, paramString2);
      localResultSet = localPreparedStatement.executeQuery();
      while (localResultSet.next())
      {
        EvsVoucherStatistics localEvsVoucherStatistics = new EvsVoucherStatistics();
        localEvsVoucherStatistics.setYears(localResultSet.getString("years"));
        localEvsVoucherStatistics.setVoucherBookNumber(Long.valueOf(localResultSet.getLong("total")));
        localArrayList.add(localEvsVoucherStatistics);
      }
      return localArrayList;
    }
    catch (SQLException localSQLException2)
    {
      localSQLException2.printStackTrace();
    }
    finally
    {
      try
      {
        if (localPreparedStatement != null) {
          localPreparedStatement.close();
        }
        if (localConnection != null) {
          localConnection.close();
        }
        if (localResultSet != null) {
          localResultSet.close();
        }
      }
      catch (SQLException localSQLException4)
      {
        localSQLException4.printStackTrace();
      }
    }
  }
  
  public List<EvsVoucherStatistics> findVoucherPageNumber(String paramString1, String paramString2)
  {
    Connection localConnection = null;
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(" select tt.last_update_date years , count(1) total");
    localStringBuffer.append(" from (select decode(INSTR(ev.Period_Name, '-'),0,substr(ev.Period_Name, 1, 4),'20'||substr(ev.Period_Name, 5, 6)) last_update_date, ev.voucher_id ");
    localStringBuffer.append(" from evs_voucher ev, evs_image image");
    localStringBuffer.append(" where image.voucher_id = ev.voucher_id");
    localStringBuffer.append(" and image.barcode is null");
    localStringBuffer.append(" and ev.company_code = ?) tt");
    localStringBuffer.append(" where tt.last_update_date =?");
    localStringBuffer.append(" group by tt.last_update_date");
    localConnection = getSession().connection();
    localArrayList = new ArrayList();
    try
    {
      localPreparedStatement = localConnection.prepareStatement(localStringBuffer.toString());
      localPreparedStatement.setString(1, paramString1);
      localPreparedStatement.setString(2, paramString2);
      localResultSet = localPreparedStatement.executeQuery();
      while (localResultSet.next())
      {
        this.year = new StringBuffer(new SimpleDateFormat("yyyy").format(new Date()).substring(0, 2));
        EvsVoucherStatistics localEvsVoucherStatistics = new EvsVoucherStatistics();
        localEvsVoucherStatistics.setYears(localResultSet.getString("years"));
        localEvsVoucherStatistics.setVoucherPageNumber(Long.valueOf(localResultSet.getLong("total")));
        localArrayList.add(localEvsVoucherStatistics);
      }
      return localArrayList;
    }
    catch (SQLException localSQLException2)
    {
      localSQLException2.printStackTrace();
    }
    finally
    {
      try
      {
        if (localPreparedStatement != null) {
          localPreparedStatement.close();
        }
        if (localConnection != null) {
          localConnection.close();
        }
        if (localResultSet != null) {
          localResultSet.close();
        }
      }
      catch (SQLException localSQLException4)
      {
        localSQLException4.printStackTrace();
      }
    }
  }
  
  public List<EvsVoucherStatistics> findVoucherNumberFHY(String paramString)
  {
    Connection localConnection = null;
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(" select count(1) total");
    localStringBuffer.append(" from (select decode(INSTR(ev.Period_Name, '-'),0,substr(ev.Period_Name, 1, 4),'20'||substr(ev.Period_Name, 5, 6)) last_update_date, ev.voucher_id");
    localStringBuffer.append(" from evs_voucher ev");
    localStringBuffer.append(" where ev.company_code = ?) tt");
    localStringBuffer.append(" where tt.last_update_date = substr(to_char(sysdate, 'yyyy') - 1, 1, 4)");
    localConnection = getSession().connection();
    localArrayList = new ArrayList();
    try
    {
      localPreparedStatement = localConnection.prepareStatement(localStringBuffer.toString());
      localPreparedStatement.setString(1, paramString);
      localResultSet = localPreparedStatement.executeQuery();
      while (localResultSet.next())
      {
        EvsVoucherStatistics localEvsVoucherStatistics = new EvsVoucherStatistics();
        localEvsVoucherStatistics.setVoucherNumberFHY(localResultSet.getLong("total"));
        localArrayList.add(localEvsVoucherStatistics);
      }
      return localArrayList;
    }
    catch (SQLException localSQLException2)
    {
      localSQLException2.printStackTrace();
    }
    finally
    {
      try
      {
        localPreparedStatement.close();
        localConnection.close();
        localResultSet.close();
      }
      catch (SQLException localSQLException4)
      {
        localSQLException4.printStackTrace();
      }
    }
  }
  
  public List<EvsVoucherStatistics> findVoucherNumberTY(String paramString)
  {
    Connection localConnection = null;
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(" select count(1) total");
    localStringBuffer.append(" from evs_voucher tt");
    localStringBuffer.append(" where decode(INSTR(tt.Period_Name, '-'),0,substr(tt.Period_Name, 1, 4),'20'||substr(tt.Period_Name, 5, 6)) =");
    localStringBuffer.append(" substr(to_char(sysdate, 'yyyy'), 1, 4)");
    localStringBuffer.append(" and tt.company_code = ?");
    localConnection = getSession().connection();
    localArrayList = new ArrayList();
    try
    {
      localPreparedStatement = localConnection.prepareStatement(localStringBuffer.toString());
      localPreparedStatement.setString(1, paramString);
      localResultSet = localPreparedStatement.executeQuery();
      while (localResultSet.next())
      {
        EvsVoucherStatistics localEvsVoucherStatistics = new EvsVoucherStatistics();
        localEvsVoucherStatistics.setVoucherNumberTY(localResultSet.getLong("total"));
        localArrayList.add(localEvsVoucherStatistics);
      }
      return localArrayList;
    }
    catch (SQLException localSQLException2)
    {
      localSQLException2.printStackTrace();
    }
    finally
    {
      try
      {
        localPreparedStatement.close();
        localConnection.close();
        localResultSet.close();
      }
      catch (SQLException localSQLException4)
      {
        localSQLException4.printStackTrace();
      }
    }
  }
  
  public List<EvsVoucherStatistics> findVoucherBookFHY(String paramString)
  {
    Connection localConnection = null;
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(" select count(eb.book_id) total");
    localStringBuffer.append(" from evs.evs_book eb");
    localStringBuffer.append(" where decode(INSTR(eb.Period_Name, '-'),0,substr(eb.Period_Name, 1, 4),'20'||substr(eb.Period_Name, 5, 6)) =");
    localStringBuffer.append(" substr(to_char(sysdate, 'yyyy') - 1, 1, 4)");
    localStringBuffer.append(" and eb.company_code = ?");
    localStringBuffer.append(" group by decode(INSTR(eb.Period_Name, '-'),0,substr(eb.Period_Name, 1, 4),'20'||substr(eb.Period_Name, 5, 6))");
    localConnection = getSession().connection();
    localArrayList = new ArrayList();
    try
    {
      localPreparedStatement = localConnection.prepareStatement(localStringBuffer.toString());
      localPreparedStatement.setString(1, paramString);
      localResultSet = localPreparedStatement.executeQuery();
      while (localResultSet.next())
      {
        EvsVoucherStatistics localEvsVoucherStatistics = new EvsVoucherStatistics();
        localEvsVoucherStatistics.setVoucherBookFHY(Long.valueOf(localResultSet.getLong("total")));
        localArrayList.add(localEvsVoucherStatistics);
      }
      return localArrayList;
    }
    catch (SQLException localSQLException2)
    {
      localSQLException2.printStackTrace();
    }
    finally
    {
      try
      {
        localPreparedStatement.close();
        localConnection.close();
        localResultSet.close();
      }
      catch (SQLException localSQLException4)
      {
        localSQLException4.printStackTrace();
      }
    }
  }
  
  public List<EvsVoucherStatistics> findVoucherBookTY(String paramString)
  {
    Connection localConnection = null;
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(" select count(eb.book_id) total");
    localStringBuffer.append(" from evs.evs_book eb");
    localStringBuffer.append(" where decode(INSTR(eb.Period_Name, '-'),0,substr(eb.Period_Name, 1, 4),'20'||substr(eb.Period_Name, 5, 6)) =");
    localStringBuffer.append(" substr(to_char(sysdate, 'yyyy'), 1, 4)");
    localStringBuffer.append(" and eb.company_code = ?");
    localStringBuffer.append(" group by decode(INSTR(eb.Period_Name, '-'),0,substr(eb.Period_Name, 1, 4),'20'||substr(eb.Period_Name, 5, 6))");
    localConnection = getSession().connection();
    localArrayList = new ArrayList();
    try
    {
      localPreparedStatement = localConnection.prepareStatement(localStringBuffer.toString());
      localPreparedStatement.setString(1, paramString);
      localResultSet = localPreparedStatement.executeQuery();
      while (localResultSet.next())
      {
        EvsVoucherStatistics localEvsVoucherStatistics = new EvsVoucherStatistics();
        localEvsVoucherStatistics.setVoucherBookTY(Long.valueOf(localResultSet.getLong("total")));
        localArrayList.add(localEvsVoucherStatistics);
      }
      return localArrayList;
    }
    catch (SQLException localSQLException2)
    {
      localSQLException2.printStackTrace();
    }
    finally
    {
      try
      {
        localPreparedStatement.close();
        localConnection.close();
        localResultSet.close();
      }
      catch (SQLException localSQLException4)
      {
        localSQLException4.printStackTrace();
      }
    }
  }
  
  public List<EvsVoucherStatistics> findVoucherPageFHY(String paramString)
  {
    Connection localConnection = null;
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(" select count(1) total");
    localStringBuffer.append(" from (select decode(INSTR(ev.Period_Name, '-'),0,substr(ev.Period_Name, 1, 4),'20'||substr(ev.Period_Name, 5, 6)) last_update_date, ev.voucher_id");
    localStringBuffer.append(" from evs_voucher ev, evs_image image");
    localStringBuffer.append(" where image.voucher_id = ev.voucher_id");
    localStringBuffer.append(" and image.barcode is null");
    localStringBuffer.append(" and ev.company_code = ?) tt");
    localStringBuffer.append(" where tt.last_update_date = substr(to_char(sysdate, 'yyyy') - 1, 1, 4)");
    localConnection = getSession().connection();
    localArrayList = new ArrayList();
    try
    {
      localPreparedStatement = localConnection.prepareStatement(localStringBuffer.toString());
      localPreparedStatement.setString(1, paramString);
      localResultSet = localPreparedStatement.executeQuery();
      while (localResultSet.next())
      {
        EvsVoucherStatistics localEvsVoucherStatistics = new EvsVoucherStatistics();
        localEvsVoucherStatistics.setVoucherPageFHY(localResultSet.getLong("total"));
        localArrayList.add(localEvsVoucherStatistics);
      }
      return localArrayList;
    }
    catch (SQLException localSQLException2)
    {
      localSQLException2.printStackTrace();
    }
    finally
    {
      try
      {
        localPreparedStatement.close();
        localConnection.close();
        localResultSet.close();
      }
      catch (SQLException localSQLException4)
      {
        localSQLException4.printStackTrace();
      }
    }
  }
  
  public List<EvsVoucherStatistics> findVoucherPageTY(String paramString)
  {
    Connection localConnection = null;
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(" select count(1) total");
    localStringBuffer.append(" from (select decode(INSTR(ev.Period_Name, '-'),0,substr(ev.Period_Name, 1, 4),'20'||substr(ev.Period_Name, 5, 6)) last_update_date, ev.voucher_id");
    localStringBuffer.append(" from evs_voucher ev, evs_image image");
    localStringBuffer.append(" where image.voucher_id = ev.voucher_id");
    localStringBuffer.append(" and image.barcode is null");
    localStringBuffer.append(" and ev.company_code = ?) tt");
    localStringBuffer.append(" where tt.last_update_date = substr(to_char(sysdate, 'yyyy'), 1, 4)");
    localConnection = getSession().connection();
    localArrayList = new ArrayList();
    try
    {
      localPreparedStatement = localConnection.prepareStatement(localStringBuffer.toString());
      localPreparedStatement.setString(1, paramString);
      localResultSet = localPreparedStatement.executeQuery();
      while (localResultSet.next())
      {
        EvsVoucherStatistics localEvsVoucherStatistics = new EvsVoucherStatistics();
        localEvsVoucherStatistics.setVoucherPageTY(localResultSet.getLong("total"));
        localArrayList.add(localEvsVoucherStatistics);
      }
      return localArrayList;
    }
    catch (SQLException localSQLException2)
    {
      localSQLException2.printStackTrace();
    }
    finally
    {
      try
      {
        localPreparedStatement.close();
        localConnection.close();
        localResultSet.close();
      }
      catch (SQLException localSQLException4)
      {
        localSQLException4.printStackTrace();
      }
    }
  }
  
  public Map findAllCompany(FbpCompanyV paramFbpCompanyV, EasUserInfo paramEasUserInfo, int paramInt1, int paramInt2)
  {
    String str = "from FbpCompanyV fc where 1=1 AND fc.companyId > 1 and fc.enabledFlag = 'Y'";
    ArrayList localArrayList = new ArrayList();
    paramInt1 = paramInt1 / paramInt2 + 1;
    if (!"10000".equals(paramEasUserInfo.getUserId()))
    {
      str = str + " and exists(select 1 from FbpPseRelationsV p where fc.companyId = p.companyId and p.posStructureCode=? and p.employeeId = ?)";
      localArrayList.add("VOUCHER_QUERY");
      localArrayList.add(Long.valueOf(paramEasUserInfo.getUserInfoPk().longValue()));
    }
    str = str + " order by nlssort(company_name,'NLS_SORT=SCHINESE_PINYIN_M') asc";
    PageInfo localPageInfo = super.PageInfoQuery(str, paramInt1, paramInt2, localArrayList.toArray());
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", localPageInfo.getResult());
    localHashMap.put("totalCount", Long.valueOf(localPageInfo.getTotalCount()));
    return localHashMap;
  }
  
  public List<FbpCompanyV> findAllCompany(EasUserInfo paramEasUserInfo)
  {
    Object localObject = new ArrayList();
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("from FbpCompanyV fc where 1=1 AND fc.companyId != 1 and fc.enabledFlag = 'Y'");
    ArrayList localArrayList = new ArrayList();
    if (!"10000".equals(paramEasUserInfo.getUserId()))
    {
      localStringBuffer.append(" and exists(select 1 from FbpPseRelationsV p where fc.companyId = p.companyId and p.posStructureCode=? and p.employeeId = ?)");
      localArrayList.add("VOUCHER_QUERY");
      localArrayList.add(Long.valueOf(paramEasUserInfo.getUserInfoPk().longValue()));
    }
    localStringBuffer.append(" order by nlssort(company_name,'NLS_SORT=SCHINESE_PINYIN_M') asc");
    Query localQuery = getSession().createQuery(localStringBuffer.toString());
    if ((localArrayList != null) && (!localArrayList.isEmpty())) {
      for (int i = 0; i < localArrayList.size(); i++) {
        localQuery.setParameter(i, localArrayList.get(i));
      }
    }
    localObject = localQuery.list();
    return localObject;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.eBillManage.EvsVoucherBookQueryDAO
 * JD-Core Version:    0.7.0.1
 */