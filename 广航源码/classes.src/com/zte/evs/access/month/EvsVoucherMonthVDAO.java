package com.zte.evs.access.month;

import com.zte.eimage.business.baseconfig.util.EidObjectUtils;
import com.zte.evs.business.baseconfig.model.FasciculeTreeV;
import com.zte.evs.business.month.model.EvsVoucherMonthV;
import com.zte.evs.ebill.access.eBillManage.FasciculeQueryDAO;
import com.zte.evs.ebill.business.eBillManage.IFasciculeQueryDS;
import com.zte.evs.ebill.model.eBillManage.EvsBook;
import com.zte.evs.ebill.model.eBillManage.EvsManageOrgV;
import com.zte.evs.ebill.model.eBillManage.FasciculeQueryModel;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.orm.zorm.ZormTemplate;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import com.zte.ssb.zorm.Query;
import com.zte.ssb.zorm.Session;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EvsVoucherMonthVDAO
  extends BaseDAO
  implements IEvsVoucherMonthVDAO
{
  private EidObjectUtils objectUtils;
  private FasciculeQueryDAO fasciculeQueryDAO;
  private IFasciculeQueryDS fasciculeQueryDS;
  
  public FasciculeQueryDAO getFasciculeQueryDAO()
  {
    return this.fasciculeQueryDAO;
  }
  
  public void setFasciculeQueryDAO(FasciculeQueryDAO paramFasciculeQueryDAO)
  {
    this.fasciculeQueryDAO = paramFasciculeQueryDAO;
  }
  
  public EvsVoucherMonthV getEvsVoucherMonthV(BigInteger paramBigInteger)
  {
    return (EvsVoucherMonthV)super.getObject(EvsVoucherMonthV.class, paramBigInteger);
  }
  
  public List getEvsVoucherMonthVs()
  {
    return super.getObjects(EvsVoucherMonthV.class);
  }
  
  public List<EvsVoucherMonthV> getEvsVoucherMonthVs(int paramInt1, int paramInt2)
  {
    return super.getObjects(EvsVoucherMonthV.class, paramInt1, paramInt2);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeEvsVoucherMonthV(EvsVoucherMonthV paramEvsVoucherMonthV)
  {
    super.removeObject(paramEvsVoucherMonthV);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertEvsVoucherMonthV(EvsVoucherMonthV paramEvsVoucherMonthV)
  {
    super.insertObject(paramEvsVoucherMonthV);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateEvsVoucherMonthV(EvsVoucherMonthV paramEvsVoucherMonthV)
  {
    super.updateObject(paramEvsVoucherMonthV);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertEvsVoucherMonthVs(List<EvsVoucherMonthV> paramList)
  {
    super.insertObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeEvsVoucherMonthVs(List<EvsVoucherMonthV> paramList)
  {
    super.removeObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateEvsVoucherMonthVs(List<EvsVoucherMonthV> paramList)
  {
    super.updateObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeEvsVoucherMonthV(BigInteger paramBigInteger)
  {
    super.removeObject(EvsVoucherMonthV.class, paramBigInteger);
  }
  
  public void removeEvsVoucherMonthV() {}
  
  public List findDownDeptsVl(BigInteger paramBigInteger)
  {
    StringBuffer localStringBuffer = new StringBuffer("");
    localStringBuffer.append("from FasciculeTreeV b where b.parentId =" + paramBigInteger);
    localStringBuffer.append(" order by b.mon,b.yea,b.checkunitname");
    return getSession().createQuery(localStringBuffer.toString()).list();
  }
  
  public List findMonthById(String paramString1, String paramString2, String paramString3)
  {
    Connection localConnection = null;
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    System.out.println(paramString2 + "------------------" + paramString3);
    if (paramString2 != null) {
      paramString2 = paramString2.toString().substring(2);
    } else {
      paramString2 = "-1";
    }
    if (paramString3 != null)
    {
      paramString3 = paramString3.toString();
      if (paramString3.equals("01")) {
        paramString3 = "JAN";
      } else if (paramString3.equals("02")) {
        paramString3 = "FEB";
      } else if (paramString3.equals("03")) {
        paramString3 = "MAR";
      } else if (paramString3.equals("04")) {
        paramString3 = "APR";
      } else if (paramString3.equals("05")) {
        paramString3 = "MAY";
      } else if (paramString3.equals("06")) {
        paramString3 = "JUN";
      } else if (paramString3.equals("07")) {
        paramString3 = "JUL";
      } else if (paramString3.equals("08")) {
        paramString3 = "AUG";
      } else if (paramString3.equals("09")) {
        paramString3 = "SEP";
      } else if (paramString3.equals("10")) {
        paramString3 = "OCT";
      } else if (paramString3.equals("11")) {
        paramString3 = "NOV";
      } else if (paramString3.equals("12")) {
        paramString3 = "DEC";
      }
    }
    String str1 = paramString3 + "-" + paramString2.toString();
    System.out.println(str1 + "====================================");
    String str2 = " select sum(b.book_number) book_number,sum(b.mark_number) mark_number,sum(b.booknot_number) booknot_number,b.sub_doc_name from evs_voucher_month_v b where b.last_update_date= '" + str1 + "' group by b.sub_doc_name";
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
        localEvsVoucherMonthV.setJournalName(localResultSet.getString("sub_doc_name"));
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
  
  public List findById(BigInteger paramBigInteger)
  {
    System.out.println(paramBigInteger);
    Connection localConnection = null;
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    String str1 = " from FasciculeTreeV tt where 1=1 and tt.ttid=" + paramBigInteger;
    FasciculeTreeV localFasciculeTreeV = (FasciculeTreeV)getZormTemplate().find(str1, null).get(0);
    String str2 = null;
    String str3 = null;
    String str4 = null;
    if (localFasciculeTreeV.getYea() != null) {
      str3 = localFasciculeTreeV.getYea().toString().substring(2);
    } else {
      str3 = "-1";
    }
    if (localFasciculeTreeV.getMon() != null)
    {
      str4 = localFasciculeTreeV.getMon().toString();
      if (str4.equals("01")) {
        str4 = "JAN";
      } else if (str4.equals("02")) {
        str4 = "FEB";
      } else if (str4.equals("03")) {
        str4 = "MAR";
      } else if (str4.equals("04")) {
        str4 = "APR";
      } else if (str4.equals("05")) {
        str4 = "MAY";
      } else if (str4.equals("06")) {
        str4 = "JUN";
      } else if (str4.equals("07")) {
        str4 = "JUL";
      } else if (str4.equals("08")) {
        str4 = "AUG";
      } else if (str4.equals("09")) {
        str4 = "SEP";
      } else if (str4.equals("10")) {
        str4 = "OCT";
      } else if (str4.equals("11")) {
        str4 = "NOV";
      } else if (str4.equals("12")) {
        str4 = "DEC";
      }
    }
    if (localFasciculeTreeV.getCheckunit() != null) {
      str2 = localFasciculeTreeV.getCheckunit().toString();
    }
    String str5 = "select tt.ERP_ORG_ID from FBP_CHECK_UNIT_CONTENTS tt where tt.CHECK_UNIT='" + str2 + "'";
    localConnection = getSession().connection();
    ArrayList localArrayList = new ArrayList();
    try
    {
      localPreparedStatement = localConnection.prepareStatement(str5.toString());
      localResultSet = localPreparedStatement.executeQuery();
      while (localResultSet.next())
      {
        FasciculeQueryModel localFasciculeQueryModel = new FasciculeQueryModel();
        localFasciculeQueryModel.setOuId(Long.valueOf(localResultSet.getLong("ERP_ORG_ID")));
        localArrayList.add(localFasciculeQueryModel);
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
    Long localLong = ((FasciculeQueryModel)localArrayList.get(0)).getOuId();
    System.out.println(localLong + "----------------------");
    System.out.println(localFasciculeTreeV.getNodeLevel() + "**************" + str3 + "=======" + str4 + "----" + str2);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (localFasciculeTreeV.getNodeLevel().intValue() == 0)
    {
      localObject1 = this.fasciculeQueryDS.findfasciculeQuaryInfoByContentId(str2, str3);
      localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (FasciculeQueryModel)((Iterator)localObject2).next();
        System.out.println(((FasciculeQueryModel)localObject3).getOuId());
      }
      return localObject1;
    }
    if (localFasciculeTreeV.getNodeLevel().intValue() != 1)
    {
      if (localFasciculeTreeV.getNodeLevel().intValue() == 2)
      {
        System.out.println(str3 + "------------------" + str4 + "--------------" + localLong);
        localObject1 = str4 + "-" + str3.toString();
        System.out.println((String)localObject1 + "====================================");
        localObject2 = find1((String)localObject1, localLong);
        localObject3 = find2((String)localObject1, localLong);
        List localList1 = find3((String)localObject1, localLong);
        List localList2 = find4();
        Iterator localIterator1 = ((List)localObject2).iterator();
        EvsVoucherMonthV localEvsVoucherMonthV1;
        Iterator localIterator2;
        EvsVoucherMonthV localEvsVoucherMonthV2;
        while (localIterator1.hasNext())
        {
          localEvsVoucherMonthV1 = (EvsVoucherMonthV)localIterator1.next();
          System.out.println(localEvsVoucherMonthV1.getBookNumber() + "++++++++++++++++=============");
          localIterator2 = localList2.iterator();
          while (localIterator2.hasNext())
          {
            localEvsVoucherMonthV2 = (EvsVoucherMonthV)localIterator2.next();
            if (localEvsVoucherMonthV1.getJournalName().equals(localEvsVoucherMonthV2.getJournalName())) {
              localEvsVoucherMonthV2.setBookNumber(localEvsVoucherMonthV1.getBookNumber());
            }
          }
        }
        localIterator1 = ((List)localObject3).iterator();
        while (localIterator1.hasNext())
        {
          localEvsVoucherMonthV1 = (EvsVoucherMonthV)localIterator1.next();
          localIterator2 = localList2.iterator();
          while (localIterator2.hasNext())
          {
            localEvsVoucherMonthV2 = (EvsVoucherMonthV)localIterator2.next();
            System.out.println(localEvsVoucherMonthV1.getMarkNumber() + "++++++++++++++++");
            if (localEvsVoucherMonthV1.getJournalName().equals(localEvsVoucherMonthV2.getJournalName())) {
              localEvsVoucherMonthV2.setMarkNumber(localEvsVoucherMonthV1.getMarkNumber());
            }
          }
        }
        localIterator1 = localList1.iterator();
        while (localIterator1.hasNext())
        {
          localEvsVoucherMonthV1 = (EvsVoucherMonthV)localIterator1.next();
          localIterator2 = localList2.iterator();
          while (localIterator2.hasNext())
          {
            System.out.println(localEvsVoucherMonthV1.getBooknotNumber() + "++++++++++++++++---------------");
            localEvsVoucherMonthV2 = (EvsVoucherMonthV)localIterator2.next();
            if (localEvsVoucherMonthV1.getJournalName().equals(localEvsVoucherMonthV2.getJournalName())) {
              localEvsVoucherMonthV2.setBooknotNumber(localEvsVoucherMonthV1.getBooknotNumber());
            }
          }
        }
        localIterator1 = localList2.iterator();
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
        System.out.println(localList2.size() + "新的");
        return localList2;
      }
      if (localFasciculeTreeV.getNodeLevel().intValue() != 3) {}
    }
    return null;
  }
  
  public List findEvsVoucherMonthVById(String paramString)
  {
    Connection localConnection = null;
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    String str1 = "2010-" + paramString;
    String str2 = " select sum(b.book_number) book_number,sum(b.mark_number) mark_number,sum(b.booknot_number) booknot_number,b.sub_doc_name from evs_voucher_month_v b where b.last_update_date= '" + str1 + "' group by b.sub_doc_name";
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
        localEvsVoucherMonthV.setJournalName(localResultSet.getString("sub_doc_name"));
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
  
  public List findAllEvsVoucherMonthV()
  {
    Connection localConnection = null;
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    String str = "select sum(b.book_number) book_number,sum(b.mark_number) mark_number,sum(b.booknot_number) booknot_number,b.sub_doc_name from evs_voucher_month_v b group by b.sub_doc_name";
    localConnection = getSession().connection();
    ArrayList localArrayList = new ArrayList();
    try
    {
      localPreparedStatement = localConnection.prepareStatement(str.toString());
      localResultSet = localPreparedStatement.executeQuery();
      while (localResultSet.next())
      {
        EvsVoucherMonthV localEvsVoucherMonthV = new EvsVoucherMonthV();
        localEvsVoucherMonthV.setJournalName(localResultSet.getString("sub_doc_name"));
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
  
  public List findEvsVoucherByMonthV(String paramString1, String paramString2)
  {
    Connection localConnection = null;
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    String str1 = " from FasciculeTreeV tt where 1=1 and tt.ttid=" + paramString2;
    FasciculeTreeV localFasciculeTreeV = (FasciculeTreeV)getZormTemplate().find(str1, null).get(0);
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String str5 = null;
    if (localFasciculeTreeV.getCheckunitname() != null) {
      str5 = localFasciculeTreeV.getCheckunitname().toString();
    }
    if (localFasciculeTreeV.getYea() != null) {
      str3 = localFasciculeTreeV.getYea().toString().substring(2);
    } else {
      str3 = "-1";
    }
    if (localFasciculeTreeV.getMon() != null)
    {
      str4 = localFasciculeTreeV.getMon().toString();
      if (str4.equals("01")) {
        str4 = "JAN";
      } else if (str4.equals("02")) {
        str4 = "FEB";
      } else if (str4.equals("03")) {
        str4 = "MAR";
      } else if (str4.equals("04")) {
        str4 = "APR";
      } else if (str4.equals("05")) {
        str4 = "MAY";
      } else if (str4.equals("06")) {
        str4 = "JUN";
      } else if (str4.equals("07")) {
        str4 = "JUL";
      } else if (str4.equals("08")) {
        str4 = "AUG";
      } else if (str4.equals("09")) {
        str4 = "SEP";
      } else if (str4.equals("10")) {
        str4 = "OCT";
      } else if (str4.equals("11")) {
        str4 = "NOV";
      } else if (str4.equals("12")) {
        str4 = "DEC";
      }
    }
    if (localFasciculeTreeV.getCheckunit() != null) {
      str2 = localFasciculeTreeV.getCheckunit().toString();
    }
    String str6 = "select tt.ERP_ORG_ID from FBP_CHECK_UNIT_CONTENTS tt where tt.CHECK_UNIT='" + str2 + "'";
    localConnection = getSession().connection();
    ArrayList localArrayList1 = new ArrayList();
    try
    {
      localPreparedStatement = localConnection.prepareStatement(str6.toString());
      localResultSet = localPreparedStatement.executeQuery();
      while (localResultSet.next())
      {
        FasciculeQueryModel localFasciculeQueryModel = new FasciculeQueryModel();
        localFasciculeQueryModel.setOuId(Long.valueOf(localResultSet.getLong("ERP_ORG_ID")));
        localArrayList1.add(localFasciculeQueryModel);
      }
      System.out.println(localArrayList1.size() + "..................");
      localPreparedStatement.close();
      localConnection.close();
      localResultSet.close();
    }
    catch (SQLException localSQLException1)
    {
      localSQLException1.printStackTrace();
    }
    Long localLong = ((FasciculeQueryModel)localArrayList1.get(0)).getOuId();
    String str7 = str4 + "-" + str3.toString();
    System.out.println(localLong + "-----" + str7 + "-----" + str5);
    String str8 = "select e2.BOOK_ID,e2.BOOK_CODE,e2.ARCHIVE_NUMBER,e2.BEGIN_NUM,e2.END_NUM,e2.BOOK_DATE,e2.BOOK_BREAK_FLAG,(select f.meaning from apps.fbp_lookup_values_v f where f.lookup_code=e2.BOOK_STATUS) as book_status from Evs_book e2 where e2.book_id in (select distinct ee.book_id from EVS_VOUCHER_BOOK_PACKAGE ee  where ee.voucher_id in (select e.voucher_id from Evs_Voucher e where e.journal_name = '" + paramString1 + "')) and e2.period_name='" + str7 + "' and e2.ou_name=" + localLong;
    ArrayList localArrayList2 = new ArrayList();
    try
    {
      localPreparedStatement = localConnection.prepareStatement(str8.toString());
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
        localArrayList2.add(localEvsBook);
      }
      System.out.println(localArrayList2.size() + "..................");
      localPreparedStatement.close();
      localConnection.close();
      localResultSet.close();
    }
    catch (SQLException localSQLException2)
    {
      localSQLException2.printStackTrace();
    }
    return localArrayList2;
  }
  
  public List findEvsVoucherByYearV(String paramString1, String paramString2)
  {
    Connection localConnection = null;
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    String str1 = " from FasciculeTreeV tt where 1=1 and tt.ttid=" + paramString2;
    FasciculeTreeV localFasciculeTreeV = (FasciculeTreeV)getZormTemplate().find(str1, null).get(0);
    String str2 = null;
    String str3 = null;
    String str4 = null;
    if (paramString1.equals("1月")) {
      paramString1 = "JAN";
    } else if (paramString1.equals("2月")) {
      paramString1 = "FEB";
    } else if (paramString1.equals("3月")) {
      paramString1 = "MAR";
    } else if (paramString1.equals("4月")) {
      paramString1 = "APR";
    } else if (paramString1.equals("5月")) {
      paramString1 = "MAY";
    } else if (paramString1.equals("6月")) {
      paramString1 = "JUN";
    } else if (paramString1.equals("7月")) {
      paramString1 = "JUL";
    } else if (paramString1.equals("8月")) {
      paramString1 = "AUG";
    } else if (paramString1.equals("9月")) {
      paramString1 = "SEP";
    } else if (paramString1.equals("10月")) {
      paramString1 = "OCT";
    } else if (paramString1.equals("11月")) {
      paramString1 = "NOV";
    } else if (paramString1.equals("12月")) {
      paramString1 = "DEC";
    }
    if (localFasciculeTreeV.getCheckunitname() != null) {
      str4 = localFasciculeTreeV.getCheckunitname().toString().substring(2);
    }
    if (localFasciculeTreeV.getYea() != null) {
      str3 = localFasciculeTreeV.getYea().toString().substring(2);
    } else {
      str3 = "-1";
    }
    if (localFasciculeTreeV.getCheckunit() != null) {
      str2 = localFasciculeTreeV.getCheckunit().toString();
    }
    String str5 = "select tt.ERP_ORG_ID from FBP_CHECK_UNIT_CONTENTS tt where tt.CHECK_UNIT='" + str2 + "'";
    localConnection = getSession().connection();
    ArrayList localArrayList = new ArrayList();
    try
    {
      localPreparedStatement = localConnection.prepareStatement(str5.toString());
      localResultSet = localPreparedStatement.executeQuery();
      while (localResultSet.next())
      {
        FasciculeQueryModel localFasciculeQueryModel = new FasciculeQueryModel();
        localFasciculeQueryModel.setOuId(Long.valueOf(localResultSet.getLong("ERP_ORG_ID")));
        localArrayList.add(localFasciculeQueryModel);
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
    Long localLong = ((FasciculeQueryModel)localArrayList.get(0)).getOuId();
    String str6 = paramString1 + "-" + str3.toString();
    System.out.println(localLong + "-----" + str6 + "-----" + str4);
    List localList1 = find1(str6, localLong);
    List localList2 = find2(str6, localLong);
    List localList3 = find3(str6, localLong);
    List localList4 = find4();
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
  
  public List fasciculeQuaryInfoByPZ(String paramString1, String paramString2, String paramString3)
  {
    Connection localConnection = null;
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    String str1 = " from FasciculeTreeV tt where 1=1 and tt.ttid=" + paramString1;
    FasciculeTreeV localFasciculeTreeV = (FasciculeTreeV)getZormTemplate().find(str1, null).get(0);
    String str2 = null;
    String str3 = null;
    String str4 = null;
    if (paramString2.equals("1月")) {
      paramString2 = "JAN";
    } else if (paramString2.equals("2月")) {
      paramString2 = "FEB";
    } else if (paramString2.equals("3月")) {
      paramString2 = "MAR";
    } else if (paramString2.equals("4月")) {
      paramString2 = "APR";
    } else if (paramString2.equals("5月")) {
      paramString2 = "MAY";
    } else if (paramString2.equals("6月")) {
      paramString2 = "JUN";
    } else if (paramString2.equals("7月")) {
      paramString2 = "JUL";
    } else if (paramString2.equals("8月")) {
      paramString2 = "AUG";
    } else if (paramString2.equals("9月")) {
      paramString2 = "SEP";
    } else if (paramString2.equals("10月")) {
      paramString2 = "OCT";
    } else if (paramString2.equals("11月")) {
      paramString2 = "NOV";
    } else if (paramString2.equals("12月")) {
      paramString2 = "DEC";
    }
    if (localFasciculeTreeV.getCheckunitname() != null) {
      str4 = localFasciculeTreeV.getCheckunitname().toString();
    }
    if (localFasciculeTreeV.getYea() != null) {
      str3 = localFasciculeTreeV.getYea().toString().substring(2);
    } else {
      str3 = "-1";
    }
    if (localFasciculeTreeV.getCheckunit() != null) {
      str2 = localFasciculeTreeV.getCheckunit().toString();
    }
    String str5 = "select tt.ERP_ORG_ID from FBP_CHECK_UNIT_CONTENTS tt where tt.CHECK_UNIT='" + str2 + "'";
    localConnection = getSession().connection();
    ArrayList localArrayList1 = new ArrayList();
    try
    {
      localPreparedStatement = localConnection.prepareStatement(str5.toString());
      localResultSet = localPreparedStatement.executeQuery();
      while (localResultSet.next())
      {
        FasciculeQueryModel localFasciculeQueryModel = new FasciculeQueryModel();
        localFasciculeQueryModel.setOuId(Long.valueOf(localResultSet.getLong("ERP_ORG_ID")));
        localArrayList1.add(localFasciculeQueryModel);
      }
      System.out.println(localArrayList1.size() + "..................");
      localPreparedStatement.close();
      localConnection.close();
      localResultSet.close();
    }
    catch (SQLException localSQLException1)
    {
      localSQLException1.printStackTrace();
    }
    Long localLong = ((FasciculeQueryModel)localArrayList1.get(0)).getOuId();
    String str6 = paramString2 + "-" + str3.toString();
    System.out.println(localLong + "-----" + str6 + "-----" + str4);
    String str7 = "select e2.BOOK_ID,e2.BOOK_CODE,e2.ARCHIVE_NUMBER,e2.BEGIN_NUM,e2.END_NUM,e2.BOOK_DATE,e2.BOOK_BREAK_FLAG,(select f.meaning from apps.fbp_lookup_values_v f where f.lookup_code=e2.BOOK_STATUS) as book_status from Evs_book e2 where e2.book_id in (select distinct ee.book_id from EVS_VOUCHER_BOOK_PACKAGE ee  where ee.voucher_id in (select e.voucher_id from Evs_Voucher e where e.journal_name = '" + paramString3 + "')) and e2.period_name='" + str6 + "' and e2.ou_name=" + localLong;
    ArrayList localArrayList2 = new ArrayList();
    try
    {
      localPreparedStatement = localConnection.prepareStatement(str7.toString());
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
        localArrayList2.add(localEvsBook);
      }
      System.out.println(localArrayList2.size() + "..................");
      localPreparedStatement.close();
      localConnection.close();
      localResultSet.close();
    }
    catch (SQLException localSQLException2)
    {
      localSQLException2.printStackTrace();
    }
    return localArrayList2;
  }
  
  public List findList(String paramString)
  {
    String str = " from FasciculeTreeV tt where 1=1 and tt.checkunitname='" + paramString + "'";
    return getSession().createQuery(str.toString()).list();
  }
  
  public List findList1(Long paramLong)
  {
    Connection localConnection = null;
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    localConnection = getSession().connection();
    ArrayList localArrayList = new ArrayList();
    String str = "select tt.CHECK_UNIT from fbp_check_unit_contents tt where tt.ERP_ORG_ID=" + paramLong + "";
    try
    {
      localPreparedStatement = localConnection.prepareStatement(str.toString());
      localResultSet = localPreparedStatement.executeQuery();
      while (localResultSet.next())
      {
        FasciculeQueryModel localFasciculeQueryModel = new FasciculeQueryModel();
        localFasciculeQueryModel.setCheckUnit(localResultSet.getString("CHECK_UNIT"));
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
  
  public List find1(String paramString, Long paramLong)
  {
    Connection localConnection = null;
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    localConnection = getSession().connection();
    ArrayList localArrayList = new ArrayList();
    String str = " select count(distinct b.book_id) book_number, h.journal_name,b.ou_name,b.period_name from EVS_VOUCHER h ,EVS_VOUCHER_BOOK_PACKAGE bp ,evs_book b where h.VOUCHER_ID = bp.voucher_id and bp.book_id = b.book_id and b.period_name='" + paramString + "' and b.ou_name=" + paramLong + "group by h.journal_name,b.ou_name,b.period_name";
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
  
  public List find2(String paramString, Long paramLong)
  {
    Connection localConnection = null;
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    localConnection = getSession().connection();
    ArrayList localArrayList = new ArrayList();
    String str = "select count(ev.voucher_id) mark_number, ev.journal_name,ev.ou_id, ev.period_name from evs.evs_voucher ev where ev.ou_id=" + paramLong + " and ev.period_name= '" + paramString + "' group by ev.journal_name,ev.ou_id, ev.period_name";
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
  
  public List find3(String paramString, Long paramLong)
  {
    Connection localConnection = null;
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    localConnection = getSession().connection();
    ArrayList localArrayList = new ArrayList();
    String str = "select count(ev.voucher_id) booknot_number,ev.journal_name,ev.ou_id,ev.period_name from evs.evs_voucher  ev where  ev.voucher_status  in('UNMATCH','MATCHED','SUBMITED','CHECKED','BACKED','UNBOOKED') and ev.period_name= '" + paramString + "' and ev.ou_id=" + paramLong + " group by ev.journal_name,ev.ou_id,ev.period_name";
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
  
  public List find4()
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
  
  public List findDeptsVById()
  {
    EvsVoucherMonthV localEvsVoucherMonthV = new EvsVoucherMonthV();
    localEvsVoucherMonthV.setParentDeptId(BigInteger.valueOf(2011L));
    localEvsVoucherMonthV.setParentDeptName("2011");
    List localList = getObjects(localEvsVoucherMonthV.getClass());
    return localList;
  }
  
  public IFasciculeQueryDS getFasciculeQueryDS()
  {
    return this.fasciculeQueryDS;
  }
  
  public void setFasciculeQueryDS(IFasciculeQueryDS paramIFasciculeQueryDS)
  {
    this.fasciculeQueryDS = paramIFasciculeQueryDS;
  }
  
  public EidObjectUtils getObjectUtils()
  {
    return this.objectUtils;
  }
  
  public void setObjectUtils(EidObjectUtils paramEidObjectUtils)
  {
    this.objectUtils = paramEidObjectUtils;
  }
  
  public List<EvsManageOrgV> findEvsManageOrgV(String paramString)
  {
    Object localObject = new ArrayList();
    String str1 = "from EvsManageOrgV e where e.employeeNumber='" + paramString + "'";
    localObject = getZormTemplate().find(str1);
    String str2 = "";
    if (((List)localObject).size() <= 0) {
      return localObject;
    }
    Iterator localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      EvsManageOrgV localEvsManageOrgV = (EvsManageOrgV)localIterator.next();
      if ("".equals(str2)) {
        str2 = localEvsManageOrgV.getPosStruElementId() + "";
      } else {
        str2 = str2 + "," + localEvsManageOrgV.getPosStruElementId();
      }
    }
    str1 = "from EvsManageOrgV e where e.parentPosStruElementId in(" + str2 + ") or e.posStruElementId in(" + str2 + ")";
    localObject = getZormTemplate().find(str1);
    return localObject;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.access.month.EvsVoucherMonthVDAO
 * JD-Core Version:    0.7.0.1
 */