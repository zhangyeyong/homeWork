package com.zte.evs.ebill.business.eBillManage;

import com.zte.evs.access.month.IEvsVoucherMonthVDAO;
import com.zte.evs.business.baseconfig.model.FasciculeTreeV;
import com.zte.evs.ebill.access.eBillManage.IFasciculeQueryDAO;
import com.zte.evs.ebill.model.eBillManage.FasciculeQueryModel;
import java.io.PrintStream;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class FasciculeQueryDS
  implements IFasciculeQueryDS
{
  private IFasciculeQueryDAO fasciculeQueryDAO;
  private IEvsVoucherMonthVDAO evsVoucherMonthVDAO;
  
  public IEvsVoucherMonthVDAO getEvsVoucherMonthVDAO()
  {
    return this.evsVoucherMonthVDAO;
  }
  
  public void setEvsVoucherMonthVDAO(IEvsVoucherMonthVDAO paramIEvsVoucherMonthVDAO)
  {
    this.evsVoucherMonthVDAO = paramIEvsVoucherMonthVDAO;
  }
  
  public List findPeriodsByThisYear(String paramString1, String paramString2)
  {
    System.out.println(paramString1 + "              " + paramString2);
    List localList = this.fasciculeQueryDAO.quary(paramString1, paramString2);
    ArrayList localArrayList = new ArrayList();
    FasciculeQueryModel localFasciculeQueryModel1 = new FasciculeQueryModel();
    localFasciculeQueryModel1.setMonth("01");
    localFasciculeQueryModel1.setVouchersums(Long.valueOf(0L));
    localFasciculeQueryModel1.setVoucherBooks(Long.valueOf(0L));
    localFasciculeQueryModel1.setVoucherPages(Long.valueOf(0L));
    localFasciculeQueryModel1.setNovouchersums(Long.valueOf(0L));
    FasciculeQueryModel localFasciculeQueryModel2 = new FasciculeQueryModel();
    localFasciculeQueryModel2.setMonth("02");
    localFasciculeQueryModel2.setVouchersums(Long.valueOf(0L));
    localFasciculeQueryModel2.setVoucherBooks(Long.valueOf(0L));
    localFasciculeQueryModel2.setVoucherPages(Long.valueOf(0L));
    localFasciculeQueryModel2.setNovouchersums(Long.valueOf(0L));
    FasciculeQueryModel localFasciculeQueryModel3 = new FasciculeQueryModel();
    localFasciculeQueryModel3.setMonth("03");
    localFasciculeQueryModel3.setVouchersums(Long.valueOf(0L));
    localFasciculeQueryModel3.setVoucherBooks(Long.valueOf(0L));
    localFasciculeQueryModel3.setVoucherPages(Long.valueOf(0L));
    localFasciculeQueryModel3.setNovouchersums(Long.valueOf(0L));
    FasciculeQueryModel localFasciculeQueryModel4 = new FasciculeQueryModel();
    localFasciculeQueryModel4.setMonth("04");
    localFasciculeQueryModel4.setVouchersums(Long.valueOf(0L));
    localFasciculeQueryModel4.setVoucherBooks(Long.valueOf(0L));
    localFasciculeQueryModel4.setVoucherPages(Long.valueOf(0L));
    localFasciculeQueryModel4.setNovouchersums(Long.valueOf(0L));
    FasciculeQueryModel localFasciculeQueryModel5 = new FasciculeQueryModel();
    localFasciculeQueryModel5.setMonth("05");
    localFasciculeQueryModel5.setVouchersums(Long.valueOf(0L));
    localFasciculeQueryModel5.setVoucherBooks(Long.valueOf(0L));
    localFasciculeQueryModel5.setVoucherPages(Long.valueOf(0L));
    localFasciculeQueryModel5.setNovouchersums(Long.valueOf(0L));
    FasciculeQueryModel localFasciculeQueryModel6 = new FasciculeQueryModel();
    localFasciculeQueryModel6.setMonth("06");
    localFasciculeQueryModel6.setVouchersums(Long.valueOf(0L));
    localFasciculeQueryModel6.setVoucherBooks(Long.valueOf(0L));
    localFasciculeQueryModel6.setVoucherPages(Long.valueOf(0L));
    localFasciculeQueryModel6.setNovouchersums(Long.valueOf(0L));
    FasciculeQueryModel localFasciculeQueryModel7 = new FasciculeQueryModel();
    localFasciculeQueryModel7.setMonth("07");
    localFasciculeQueryModel7.setVouchersums(Long.valueOf(0L));
    localFasciculeQueryModel7.setVoucherBooks(Long.valueOf(0L));
    localFasciculeQueryModel7.setVoucherPages(Long.valueOf(0L));
    localFasciculeQueryModel7.setNovouchersums(Long.valueOf(0L));
    FasciculeQueryModel localFasciculeQueryModel8 = new FasciculeQueryModel();
    localFasciculeQueryModel8.setMonth("08");
    localFasciculeQueryModel8.setVouchersums(Long.valueOf(0L));
    localFasciculeQueryModel8.setVoucherBooks(Long.valueOf(0L));
    localFasciculeQueryModel8.setVoucherPages(Long.valueOf(0L));
    localFasciculeQueryModel8.setNovouchersums(Long.valueOf(0L));
    FasciculeQueryModel localFasciculeQueryModel9 = new FasciculeQueryModel();
    localFasciculeQueryModel9.setMonth("09");
    localFasciculeQueryModel9.setVouchersums(Long.valueOf(0L));
    localFasciculeQueryModel9.setVoucherBooks(Long.valueOf(0L));
    localFasciculeQueryModel9.setVoucherPages(Long.valueOf(0L));
    localFasciculeQueryModel9.setNovouchersums(Long.valueOf(0L));
    FasciculeQueryModel localFasciculeQueryModel10 = new FasciculeQueryModel();
    localFasciculeQueryModel10.setMonth("10");
    localFasciculeQueryModel10.setVouchersums(Long.valueOf(0L));
    localFasciculeQueryModel10.setVoucherBooks(Long.valueOf(0L));
    localFasciculeQueryModel10.setVoucherPages(Long.valueOf(0L));
    localFasciculeQueryModel10.setNovouchersums(Long.valueOf(0L));
    FasciculeQueryModel localFasciculeQueryModel11 = new FasciculeQueryModel();
    localFasciculeQueryModel11.setMonth("11");
    localFasciculeQueryModel11.setVouchersums(Long.valueOf(0L));
    localFasciculeQueryModel11.setVoucherBooks(Long.valueOf(0L));
    localFasciculeQueryModel11.setVoucherPages(Long.valueOf(0L));
    localFasciculeQueryModel11.setNovouchersums(Long.valueOf(0L));
    FasciculeQueryModel localFasciculeQueryModel12 = new FasciculeQueryModel();
    localFasciculeQueryModel12.setMonth("12");
    localFasciculeQueryModel12.setVouchersums(Long.valueOf(0L));
    localFasciculeQueryModel12.setVoucherBooks(Long.valueOf(0L));
    localFasciculeQueryModel12.setVoucherPages(Long.valueOf(0L));
    localFasciculeQueryModel12.setNovouchersums(Long.valueOf(0L));
    localArrayList.add(localFasciculeQueryModel1);
    localArrayList.add(localFasciculeQueryModel2);
    localArrayList.add(localFasciculeQueryModel3);
    localArrayList.add(localFasciculeQueryModel4);
    localArrayList.add(localFasciculeQueryModel5);
    localArrayList.add(localFasciculeQueryModel6);
    localArrayList.add(localFasciculeQueryModel7);
    localArrayList.add(localFasciculeQueryModel8);
    localArrayList.add(localFasciculeQueryModel9);
    localArrayList.add(localFasciculeQueryModel10);
    localArrayList.add(localFasciculeQueryModel11);
    localArrayList.add(localFasciculeQueryModel12);
    Iterator localIterator1 = localArrayList.iterator();
    FasciculeQueryModel localFasciculeQueryModel13;
    while (localIterator1.hasNext())
    {
      localFasciculeQueryModel13 = (FasciculeQueryModel)localIterator1.next();
      Iterator localIterator2 = localList.iterator();
      while (localIterator2.hasNext())
      {
        FasciculeQueryModel localFasciculeQueryModel14 = (FasciculeQueryModel)localIterator2.next();
        if (localFasciculeQueryModel13.getMonth().equals(localFasciculeQueryModel14.getMonth()))
        {
          localFasciculeQueryModel13.setVouchersums(localFasciculeQueryModel14.getVouchersums());
          localFasciculeQueryModel13.setVoucherPages(localFasciculeQueryModel14.getVoucherPages());
          localFasciculeQueryModel13.setVoucherBooks(localFasciculeQueryModel14.getVoucherBooks());
          localFasciculeQueryModel13.setNovouchersums(localFasciculeQueryModel14.getNovouchersums());
        }
      }
    }
    localIterator1 = localArrayList.iterator();
    while (localIterator1.hasNext())
    {
      localFasciculeQueryModel13 = (FasciculeQueryModel)localIterator1.next();
      if (localFasciculeQueryModel13.getNovouchersums() == null) {
        localFasciculeQueryModel13.setNovouchersums(Long.valueOf(0L));
      }
      if (localFasciculeQueryModel13.getVouchersums() == null) {
        localFasciculeQueryModel13.setVouchersums(Long.valueOf(0L));
      }
      if (localFasciculeQueryModel13.getVoucherBooks() == null) {
        localFasciculeQueryModel13.setVoucherBooks(Long.valueOf(0L));
      }
      if (localFasciculeQueryModel13.getVoucherPages() == null) {
        localFasciculeQueryModel13.setVoucherPages(Long.valueOf(0L));
      }
    }
    localIterator1 = localArrayList.iterator();
    while (localIterator1.hasNext())
    {
      localFasciculeQueryModel13 = (FasciculeQueryModel)localIterator1.next();
      if (localFasciculeQueryModel13.getNovouchersums().longValue() > 0L) {
        localFasciculeQueryModel13.setFlage("N");
      } else {
        localFasciculeQueryModel13.setFlage("Y");
      }
    }
    localIterator1 = localArrayList.iterator();
    while (localIterator1.hasNext())
    {
      localFasciculeQueryModel13 = (FasciculeQueryModel)localIterator1.next();
      if (localFasciculeQueryModel13.getMonth().equals("01")) {
        localFasciculeQueryModel13.setMonth("1月");
      }
      if (localFasciculeQueryModel13.getMonth().equals("02")) {
        localFasciculeQueryModel13.setMonth("2月");
      }
      if (localFasciculeQueryModel13.getMonth().equals("03")) {
        localFasciculeQueryModel13.setMonth("3月");
      }
      if (localFasciculeQueryModel13.getMonth().equals("04")) {
        localFasciculeQueryModel13.setMonth("4月");
      }
      if (localFasciculeQueryModel13.getMonth().equals("05")) {
        localFasciculeQueryModel13.setMonth("5月");
      }
      if (localFasciculeQueryModel13.getMonth().equals("06")) {
        localFasciculeQueryModel13.setMonth("6月");
      }
      if (localFasciculeQueryModel13.getMonth().equals("07")) {
        localFasciculeQueryModel13.setMonth("7月");
      }
      if (localFasciculeQueryModel13.getMonth().equals("08")) {
        localFasciculeQueryModel13.setMonth("8月");
      }
      if (localFasciculeQueryModel13.getMonth().equals("09")) {
        localFasciculeQueryModel13.setMonth("9月");
      }
      if (localFasciculeQueryModel13.getMonth().equals("10")) {
        localFasciculeQueryModel13.setMonth("10月");
      }
      if (localFasciculeQueryModel13.getMonth().equals("11")) {
        localFasciculeQueryModel13.setMonth("11月");
      }
      if (localFasciculeQueryModel13.getMonth().equals("12")) {
        localFasciculeQueryModel13.setMonth("12月");
      }
    }
    return localArrayList;
  }
  
  public List findPeriodsByThisYear1(String paramString1, String paramString2)
  {
    System.out.println(paramString1 + "              " + paramString2);
    List localList = this.fasciculeQueryDAO.quary1(paramString1, paramString2);
    ArrayList localArrayList = new ArrayList();
    FasciculeQueryModel localFasciculeQueryModel1 = new FasciculeQueryModel();
    localFasciculeQueryModel1.setMonth("01");
    localFasciculeQueryModel1.setVouchersums(Long.valueOf(0L));
    localFasciculeQueryModel1.setVoucherBooks(Long.valueOf(0L));
    localFasciculeQueryModel1.setVoucherPages(Long.valueOf(0L));
    localFasciculeQueryModel1.setNovouchersums(Long.valueOf(0L));
    FasciculeQueryModel localFasciculeQueryModel2 = new FasciculeQueryModel();
    localFasciculeQueryModel2.setMonth("02");
    localFasciculeQueryModel2.setVouchersums(Long.valueOf(0L));
    localFasciculeQueryModel2.setVoucherBooks(Long.valueOf(0L));
    localFasciculeQueryModel2.setVoucherPages(Long.valueOf(0L));
    localFasciculeQueryModel2.setNovouchersums(Long.valueOf(0L));
    FasciculeQueryModel localFasciculeQueryModel3 = new FasciculeQueryModel();
    localFasciculeQueryModel3.setMonth("03");
    localFasciculeQueryModel3.setVouchersums(Long.valueOf(0L));
    localFasciculeQueryModel3.setVoucherBooks(Long.valueOf(0L));
    localFasciculeQueryModel3.setVoucherPages(Long.valueOf(0L));
    localFasciculeQueryModel3.setNovouchersums(Long.valueOf(0L));
    FasciculeQueryModel localFasciculeQueryModel4 = new FasciculeQueryModel();
    localFasciculeQueryModel4.setMonth("04");
    localFasciculeQueryModel4.setVouchersums(Long.valueOf(0L));
    localFasciculeQueryModel4.setVoucherBooks(Long.valueOf(0L));
    localFasciculeQueryModel4.setVoucherPages(Long.valueOf(0L));
    localFasciculeQueryModel4.setNovouchersums(Long.valueOf(0L));
    FasciculeQueryModel localFasciculeQueryModel5 = new FasciculeQueryModel();
    localFasciculeQueryModel5.setMonth("05");
    localFasciculeQueryModel5.setVouchersums(Long.valueOf(0L));
    localFasciculeQueryModel5.setVoucherBooks(Long.valueOf(0L));
    localFasciculeQueryModel5.setVoucherPages(Long.valueOf(0L));
    localFasciculeQueryModel5.setNovouchersums(Long.valueOf(0L));
    FasciculeQueryModel localFasciculeQueryModel6 = new FasciculeQueryModel();
    localFasciculeQueryModel6.setMonth("06");
    localFasciculeQueryModel6.setVouchersums(Long.valueOf(0L));
    localFasciculeQueryModel6.setVoucherBooks(Long.valueOf(0L));
    localFasciculeQueryModel6.setVoucherPages(Long.valueOf(0L));
    localFasciculeQueryModel6.setNovouchersums(Long.valueOf(0L));
    FasciculeQueryModel localFasciculeQueryModel7 = new FasciculeQueryModel();
    localFasciculeQueryModel7.setMonth("07");
    localFasciculeQueryModel7.setVouchersums(Long.valueOf(0L));
    localFasciculeQueryModel7.setVoucherBooks(Long.valueOf(0L));
    localFasciculeQueryModel7.setVoucherPages(Long.valueOf(0L));
    localFasciculeQueryModel7.setNovouchersums(Long.valueOf(0L));
    FasciculeQueryModel localFasciculeQueryModel8 = new FasciculeQueryModel();
    localFasciculeQueryModel8.setMonth("08");
    localFasciculeQueryModel8.setVouchersums(Long.valueOf(0L));
    localFasciculeQueryModel8.setVoucherBooks(Long.valueOf(0L));
    localFasciculeQueryModel8.setVoucherPages(Long.valueOf(0L));
    localFasciculeQueryModel8.setNovouchersums(Long.valueOf(0L));
    FasciculeQueryModel localFasciculeQueryModel9 = new FasciculeQueryModel();
    localFasciculeQueryModel9.setMonth("09");
    localFasciculeQueryModel9.setVouchersums(Long.valueOf(0L));
    localFasciculeQueryModel9.setVoucherBooks(Long.valueOf(0L));
    localFasciculeQueryModel9.setVoucherPages(Long.valueOf(0L));
    localFasciculeQueryModel9.setNovouchersums(Long.valueOf(0L));
    FasciculeQueryModel localFasciculeQueryModel10 = new FasciculeQueryModel();
    localFasciculeQueryModel10.setMonth("10");
    localFasciculeQueryModel10.setVouchersums(Long.valueOf(0L));
    localFasciculeQueryModel10.setVoucherBooks(Long.valueOf(0L));
    localFasciculeQueryModel10.setVoucherPages(Long.valueOf(0L));
    localFasciculeQueryModel10.setNovouchersums(Long.valueOf(0L));
    FasciculeQueryModel localFasciculeQueryModel11 = new FasciculeQueryModel();
    localFasciculeQueryModel11.setMonth("11");
    localFasciculeQueryModel11.setVouchersums(Long.valueOf(0L));
    localFasciculeQueryModel11.setVoucherBooks(Long.valueOf(0L));
    localFasciculeQueryModel11.setVoucherPages(Long.valueOf(0L));
    localFasciculeQueryModel11.setNovouchersums(Long.valueOf(0L));
    FasciculeQueryModel localFasciculeQueryModel12 = new FasciculeQueryModel();
    localFasciculeQueryModel12.setMonth("12");
    localFasciculeQueryModel12.setVouchersums(Long.valueOf(0L));
    localFasciculeQueryModel12.setVoucherBooks(Long.valueOf(0L));
    localFasciculeQueryModel12.setVoucherPages(Long.valueOf(0L));
    localFasciculeQueryModel12.setNovouchersums(Long.valueOf(0L));
    localArrayList.add(localFasciculeQueryModel1);
    localArrayList.add(localFasciculeQueryModel2);
    localArrayList.add(localFasciculeQueryModel3);
    localArrayList.add(localFasciculeQueryModel4);
    localArrayList.add(localFasciculeQueryModel5);
    localArrayList.add(localFasciculeQueryModel6);
    localArrayList.add(localFasciculeQueryModel7);
    localArrayList.add(localFasciculeQueryModel8);
    localArrayList.add(localFasciculeQueryModel9);
    localArrayList.add(localFasciculeQueryModel10);
    localArrayList.add(localFasciculeQueryModel11);
    localArrayList.add(localFasciculeQueryModel12);
    Iterator localIterator1 = localArrayList.iterator();
    FasciculeQueryModel localFasciculeQueryModel13;
    while (localIterator1.hasNext())
    {
      localFasciculeQueryModel13 = (FasciculeQueryModel)localIterator1.next();
      Iterator localIterator2 = localList.iterator();
      while (localIterator2.hasNext())
      {
        FasciculeQueryModel localFasciculeQueryModel14 = (FasciculeQueryModel)localIterator2.next();
        if (localFasciculeQueryModel13.getMonth().equals(localFasciculeQueryModel14.getMonth()))
        {
          localFasciculeQueryModel13.setVouchersums(localFasciculeQueryModel14.getVouchersums());
          localFasciculeQueryModel13.setVoucherPages(localFasciculeQueryModel14.getVoucherPages());
          localFasciculeQueryModel13.setVoucherBooks(localFasciculeQueryModel14.getVoucherBooks());
          localFasciculeQueryModel13.setNovouchersums(localFasciculeQueryModel14.getNovouchersums());
        }
      }
    }
    localIterator1 = localArrayList.iterator();
    while (localIterator1.hasNext())
    {
      localFasciculeQueryModel13 = (FasciculeQueryModel)localIterator1.next();
      if (localFasciculeQueryModel13.getNovouchersums() == null) {
        localFasciculeQueryModel13.setNovouchersums(Long.valueOf(0L));
      }
      if (localFasciculeQueryModel13.getVouchersums() == null) {
        localFasciculeQueryModel13.setVouchersums(Long.valueOf(0L));
      }
      if (localFasciculeQueryModel13.getVoucherBooks() == null) {
        localFasciculeQueryModel13.setVoucherBooks(Long.valueOf(0L));
      }
      if (localFasciculeQueryModel13.getVoucherPages() == null) {
        localFasciculeQueryModel13.setVoucherPages(Long.valueOf(0L));
      }
    }
    localIterator1 = localArrayList.iterator();
    while (localIterator1.hasNext())
    {
      localFasciculeQueryModel13 = (FasciculeQueryModel)localIterator1.next();
      if (localFasciculeQueryModel13.getNovouchersums().longValue() > 0L) {
        localFasciculeQueryModel13.setFlage("N");
      } else {
        localFasciculeQueryModel13.setFlage("Y");
      }
    }
    localIterator1 = localArrayList.iterator();
    while (localIterator1.hasNext())
    {
      localFasciculeQueryModel13 = (FasciculeQueryModel)localIterator1.next();
      if (localFasciculeQueryModel13.getMonth().equals("01")) {
        localFasciculeQueryModel13.setMonth("1月");
      }
      if (localFasciculeQueryModel13.getMonth().equals("02")) {
        localFasciculeQueryModel13.setMonth("2月");
      }
      if (localFasciculeQueryModel13.getMonth().equals("03")) {
        localFasciculeQueryModel13.setMonth("3月");
      }
      if (localFasciculeQueryModel13.getMonth().equals("04")) {
        localFasciculeQueryModel13.setMonth("4月");
      }
      if (localFasciculeQueryModel13.getMonth().equals("05")) {
        localFasciculeQueryModel13.setMonth("5月");
      }
      if (localFasciculeQueryModel13.getMonth().equals("06")) {
        localFasciculeQueryModel13.setMonth("6月");
      }
      if (localFasciculeQueryModel13.getMonth().equals("07")) {
        localFasciculeQueryModel13.setMonth("7月");
      }
      if (localFasciculeQueryModel13.getMonth().equals("08")) {
        localFasciculeQueryModel13.setMonth("8月");
      }
      if (localFasciculeQueryModel13.getMonth().equals("09")) {
        localFasciculeQueryModel13.setMonth("9月");
      }
      if (localFasciculeQueryModel13.getMonth().equals("10")) {
        localFasciculeQueryModel13.setMonth("10月");
      }
      if (localFasciculeQueryModel13.getMonth().equals("11")) {
        localFasciculeQueryModel13.setMonth("11月");
      }
      if (localFasciculeQueryModel13.getMonth().equals("12")) {
        localFasciculeQueryModel13.setMonth("12月");
      }
    }
    return localArrayList;
  }
  
  public List findPeriodsByThisYear2(String paramString1, String paramString2, String paramString3)
  {
    return this.fasciculeQueryDAO.findPeriodsByThisYear2(paramString1, paramString2, paramString3);
  }
  
  public List findPeriodsByThisYear3(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return this.fasciculeQueryDAO.findPeriodsByThisYear3(paramString1, paramString2, paramString3, paramString4);
  }
  
  public IFasciculeQueryDAO getFasciculeQueryDAO()
  {
    return this.fasciculeQueryDAO;
  }
  
  public void setFasciculeQueryDAO(IFasciculeQueryDAO paramIFasciculeQueryDAO)
  {
    this.fasciculeQueryDAO = paramIFasciculeQueryDAO;
  }
  
  public List findfasciculeQuaryInfoByContentId(String paramString1, String paramString2)
  {
    System.out.println(paramString1 + "++++" + paramString2);
    List localList = this.fasciculeQueryDAO.searchDate(paramString1, paramString2);
    ArrayList localArrayList = new ArrayList();
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
    localArrayList.add(localFasciculeQueryModel1);
    localArrayList.add(localFasciculeQueryModel2);
    localArrayList.add(localFasciculeQueryModel3);
    Iterator localIterator1 = localArrayList.iterator();
    FasciculeQueryModel localFasciculeQueryModel4;
    while (localIterator1.hasNext())
    {
      localFasciculeQueryModel4 = (FasciculeQueryModel)localIterator1.next();
      Iterator localIterator2 = localList.iterator();
      while (localIterator2.hasNext())
      {
        FasciculeQueryModel localFasciculeQueryModel5 = (FasciculeQueryModel)localIterator2.next();
        if (localFasciculeQueryModel4.getMonth().equals(localFasciculeQueryModel5.getMonth()))
        {
          localFasciculeQueryModel4.setVouchersums(localFasciculeQueryModel5.getVouchersums());
          localFasciculeQueryModel4.setVoucherPages(localFasciculeQueryModel5.getVoucherPages());
          localFasciculeQueryModel4.setVoucherBooks(localFasciculeQueryModel5.getVoucherBooks());
          localFasciculeQueryModel4.setOuId(localFasciculeQueryModel5.getOuId());
        }
      }
    }
    localIterator1 = localArrayList.iterator();
    while (localIterator1.hasNext())
    {
      localFasciculeQueryModel4 = (FasciculeQueryModel)localIterator1.next();
      if (localFasciculeQueryModel4.getVouchersums() == null) {
        localFasciculeQueryModel4.setVouchersums(Long.valueOf(0L));
      }
      if (localFasciculeQueryModel4.getVoucherBooks() == null) {
        localFasciculeQueryModel4.setVoucherBooks(Long.valueOf(0L));
      }
      if (localFasciculeQueryModel4.getVoucherPages() == null) {
        localFasciculeQueryModel4.setVoucherPages(Long.valueOf(0L));
      }
    }
    return localArrayList;
  }
  
  public List findfasciculeQuaryInfo()
  {
    List localList1 = this.fasciculeQueryDAO.quaryDate();
    ArrayList localArrayList = new ArrayList();
    Date localDate = new Date();
    Long localLong1 = Long.valueOf(0L);
    Long localLong2 = Long.valueOf(0L);
    Long localLong3 = Long.valueOf(0L);
    Long localLong4 = Long.valueOf(0L);
    Long localLong5 = Long.valueOf(0L);
    Long localLong6 = Long.valueOf(0L);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM");
    String[] arrayOfString = localSimpleDateFormat.format(localDate).split("-");
    FasciculeTreeV localFasciculeTreeV = (FasciculeTreeV)this.evsVoucherMonthVDAO.findList("河南移动").get(0);
    List localList2 = this.evsVoucherMonthVDAO.findDownDeptsVl(new BigInteger(localFasciculeTreeV.getTtid().toString()));
    Iterator localIterator1 = localList1.iterator();
    Object localObject;
    while (localIterator1.hasNext())
    {
      localObject = (FasciculeQueryModel)localIterator1.next();
      if (((FasciculeQueryModel)localObject).getVouchersums() == null) {
        ((FasciculeQueryModel)localObject).setVouchersums(Long.valueOf(0L));
      }
      if (((FasciculeQueryModel)localObject).getVoucherBooks() == null) {
        ((FasciculeQueryModel)localObject).setVoucherBooks(Long.valueOf(0L));
      }
      if (((FasciculeQueryModel)localObject).getVoucherPages() == null) {
        ((FasciculeQueryModel)localObject).setVoucherPages(Long.valueOf(0L));
      }
      if (((FasciculeQueryModel)localObject).getVouchersums_sb() == null) {
        ((FasciculeQueryModel)localObject).setVouchersums_sb(Long.valueOf(0L));
      }
      if (((FasciculeQueryModel)localObject).getVoucherBooks_sb() == null) {
        ((FasciculeQueryModel)localObject).setVoucherBooks_sb(Long.valueOf(0L));
      }
      if (((FasciculeQueryModel)localObject).getVoucherPages_sb() == null) {
        ((FasciculeQueryModel)localObject).setVoucherPages_sb(Long.valueOf(0L));
      }
      localLong4 = ((FasciculeQueryModel)localObject).getVoucherBooks();
      localLong5 = ((FasciculeQueryModel)localObject).getVouchersums();
      localLong6 = ((FasciculeQueryModel)localObject).getVoucherPages();
      localLong1 = ((FasciculeQueryModel)localObject).getVoucherBooks_sb();
      localLong2 = ((FasciculeQueryModel)localObject).getVouchersums_sb();
      localLong3 = ((FasciculeQueryModel)localObject).getVoucherPages_sb();
      ((FasciculeQueryModel)localObject).setVoucherBooks(localLong1);
      ((FasciculeQueryModel)localObject).setVoucherBooks_sb(localLong4);
      ((FasciculeQueryModel)localObject).setVouchersums(localLong2);
      ((FasciculeQueryModel)localObject).setVouchersums_sb(localLong5);
      ((FasciculeQueryModel)localObject).setVoucherPages(localLong3);
      ((FasciculeQueryModel)localObject).setVoucherPages_sb(localLong6);
    }
    localIterator1 = localList2.iterator();
    while (localIterator1.hasNext())
    {
      localObject = (FasciculeTreeV)localIterator1.next();
      Iterator localIterator2 = localList1.iterator();
      while (localIterator2.hasNext())
      {
        FasciculeQueryModel localFasciculeQueryModel1 = (FasciculeQueryModel)localIterator2.next();
        FasciculeQueryModel localFasciculeQueryModel2 = (FasciculeQueryModel)this.evsVoucherMonthVDAO.findList1(localFasciculeQueryModel1.getOuId()).get(0);
        if (localFasciculeQueryModel2.getCheckUnit().equals(((FasciculeTreeV)localObject).getCheckunit())) {
          localArrayList.add(localFasciculeQueryModel1);
        }
      }
    }
    return localArrayList;
  }
  
  public List findfasciculeTree(String paramString)
  {
    if (paramString == null) {
      paramString = "0";
    }
    List localList = this.fasciculeQueryDAO.findTree(new BigInteger(paramString));
    return localList;
  }
  
  public List findfasciculeQuaryInfoByContentId1(Long paramLong)
  {
    List localList = this.fasciculeQueryDAO.searchDate1(paramLong);
    ArrayList localArrayList = new ArrayList();
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
    localArrayList.add(localFasciculeQueryModel1);
    localArrayList.add(localFasciculeQueryModel2);
    localArrayList.add(localFasciculeQueryModel3);
    Iterator localIterator1 = localArrayList.iterator();
    FasciculeQueryModel localFasciculeQueryModel4;
    while (localIterator1.hasNext())
    {
      localFasciculeQueryModel4 = (FasciculeQueryModel)localIterator1.next();
      Iterator localIterator2 = localList.iterator();
      while (localIterator2.hasNext())
      {
        FasciculeQueryModel localFasciculeQueryModel5 = (FasciculeQueryModel)localIterator2.next();
        System.out.println(localFasciculeQueryModel5.getNovouchersums() + "))))))))))))))))))");
        if (localFasciculeQueryModel4.getMonth().equals(localFasciculeQueryModel5.getMonth()))
        {
          localFasciculeQueryModel4.setVouchersums(localFasciculeQueryModel5.getVouchersums());
          localFasciculeQueryModel4.setVoucherPages(localFasciculeQueryModel5.getVoucherPages());
          localFasciculeQueryModel4.setVoucherBooks(localFasciculeQueryModel5.getVoucherBooks());
          localFasciculeQueryModel4.setOuId(localFasciculeQueryModel5.getOuId());
        }
      }
    }
    localIterator1 = localArrayList.iterator();
    while (localIterator1.hasNext())
    {
      localFasciculeQueryModel4 = (FasciculeQueryModel)localIterator1.next();
      System.out.println(localFasciculeQueryModel4.getVoucherPages() + "))))))))))))))))))");
      if (localFasciculeQueryModel4.getVouchersums() == null) {
        localFasciculeQueryModel4.setVouchersums(Long.valueOf(0L));
      }
      if (localFasciculeQueryModel4.getVoucherBooks() == null) {
        localFasciculeQueryModel4.setVoucherBooks(Long.valueOf(0L));
      }
      if (localFasciculeQueryModel4.getVoucherPages() == null) {
        localFasciculeQueryModel4.setVoucherPages(Long.valueOf(0L));
      }
    }
    return localArrayList;
  }
  
  public List findQuaryInfoByMonth(String paramString1, String paramString2, String paramString3)
  {
    return this.fasciculeQueryDAO.findPeriodsByThisYear2(paramString1, paramString2, paramString3);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.eBillManage.FasciculeQueryDS
 * JD-Core Version:    0.7.0.1
 */