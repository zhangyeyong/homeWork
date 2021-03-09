package com.zte.evs.ebill.business.eBillManage;

import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.eas.getData.util.EisConsts;
import com.zte.eas.organization.business.countcompanymanage.model.FbpCompanyV;
import com.zte.eas.resconfig.business.lookup.model.FbpLookupValuesV;
import com.zte.eas.resconfig.business.lookup.service.IFbpLookupTypesDS;
import com.zte.eimage.access.baseconfig.dao.IImageCommonDAO;
import com.zte.evs.ebill.access.eBillManage.IEvsDocAccessStorageDAO;
import com.zte.evs.ebill.access.eBillManage.IEvsVoucherBookQueryDAO;
import com.zte.evs.ebill.model.eBillManage.EvsBook;
import com.zte.evs.ebill.model.eBillManage.EvsBookV;
import com.zte.evs.ebill.model.eBillManage.EvsCity;
import com.zte.evs.ebill.model.eBillManage.EvsStorageDoc;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherStatistics;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.util.Util;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class EvsVoucherBookQueryService
  implements IEvsVoucherBookQueryService
{
  private IEvsVoucherBookQueryDAO voucherBookQueryDAO;
  private IFbpLookupTypesDS lookupTypesDS;
  private IEvsDocAccessStorageDAO docAccessStorageDAO;
  
  public TableDataInfo findBookByVoucherType(EvsVoucherStatistics paramEvsVoucherStatistics, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    monthTransition(paramEvsVoucherStatistics);
    Map localMap = this.voucherBookQueryDAO.findBookByVoucherType(paramEvsVoucherStatistics, paramInt1, paramInt2);
    ArrayList localArrayList1 = new ArrayList();
    List localList1 = (List)localMap.get("data");
    String str1 = "select meaning from fbp.fbp_lookup_values where lookup_type='EVS_INVOICE_TYPE' and enabled_flag = 'Y' and lookup_code = ?";
    ArrayList localArrayList2 = new ArrayList();
    String str2 = "select min(journal_num) beginNum,max(journal_num) endNum from evs.evs_voucher v where exists (select 1 from evs.evs_voucher_book_package p where v.voucher_id = p.voucher_id and p.enabled_flag = 'Y' and p.book_id = ?)";
    ArrayList localArrayList3 = new ArrayList();
    IImageCommonDAO localIImageCommonDAO = (IImageCommonDAO)SSBBus.findDomainService("imageCommonDAO");
    for (int i = 0; i < localList1.size(); i++)
    {
      EvsBook localEvsBook = (EvsBook)localList1.get(i);
      EvsBookV localEvsBookV = this.docAccessStorageDAO.findEvsBookModelByBookId(Long.valueOf(localEvsBook.getBookId().longValue()));
      StringBuffer localStringBuffer = new StringBuffer();
      if (!Util.isNullObject(localEvsBookV.getInvCityId()))
      {
        localObject1 = this.docAccessStorageDAO.findCityNameByCityId(localEvsBookV.getInvCityId());
        if (!Util.isNullObject(localObject1)) {
          localStringBuffer.append(((EvsCity)localObject1).getCityName());
        }
      }
      if (!Util.isStrEmpty(localEvsBookV.getInvStorageCode()))
      {
        localStringBuffer.append("-");
        localObject1 = this.docAccessStorageDAO.findStorageDocNameByStoCode(localEvsBookV.getInvStorageCode());
        if (!Util.isNullObject(localObject1)) {
          localStringBuffer.append(((EvsStorageDoc)localObject1).getStorageName());
        }
      }
      if (!Util.isStrEmpty(localEvsBookV.getInvArea()))
      {
        localStringBuffer.append("-");
        localObject1 = this.docAccessStorageDAO.findFbpLookupValues(localEvsBookV.getInvArea());
        if (!Util.isNullObject(localObject1)) {
          localStringBuffer.append(((FbpLookupValuesV)localObject1).getMeaning());
        }
      }
      if (!Util.isStrEmpty(localEvsBookV.getInvRow()))
      {
        localStringBuffer.append("-");
        localObject1 = this.docAccessStorageDAO.findFbpLookupValues(localEvsBookV.getInvRow());
        if (!Util.isNullObject(localObject1)) {
          localStringBuffer.append(((FbpLookupValuesV)localObject1).getMeaning());
        }
      }
      if (!Util.isStrEmpty(localEvsBookV.getInvColumn()))
      {
        localStringBuffer.append("-");
        localObject1 = this.docAccessStorageDAO.findFbpLookupValues(localEvsBookV.getInvColumn());
        if (!Util.isNullObject(localObject1)) {
          localStringBuffer.append(((FbpLookupValuesV)localObject1).getMeaning());
        }
      }
      if (!Util.isStrEmpty(localEvsBookV.getInvLevel()))
      {
        localStringBuffer.append("-");
        localObject1 = this.docAccessStorageDAO.findFbpLookupValues(localEvsBookV.getInvLevel());
        if (!Util.isNullObject(localObject1)) {
          localStringBuffer.append(((FbpLookupValuesV)localObject1).getMeaning());
        }
      }
      localArrayList2.clear();
      localArrayList2.add(localEvsBook.getInvoiceType());
      Object localObject1 = localIImageCommonDAO.findObject(str1, localArrayList2, null);
      String str3 = localEvsBook.getBeginNum();
      String str4 = localEvsBook.getEndNum();
      if (!localEvsBook.getBookBreakFlag().equals("N"))
      {
        localArrayList3.clear();
        localArrayList3.add(localEvsBook.getBookId());
        localObject2 = (Object[])localIImageCommonDAO.findObject(str2, localArrayList3, null);
        str3 = localObject2[0] == null ? "" : localObject2[0].toString();
        str4 = localObject2[1] == null ? "" : localObject2[1].toString();
      }
      str3 = localObject1 + " " + str3;
      str4 = localObject1 + " " + str4;
      Object localObject2 = new EvsVoucherStatistics();
      ((EvsVoucherStatistics)localObject2).setVoucherBookId(localEvsBook.getBookId().toString());
      ((EvsVoucherStatistics)localObject2).setVoucherBook(localEvsBook.getBookCode());
      ((EvsVoucherStatistics)localObject2).setBiginVoucherNumber(str3);
      ((EvsVoucherStatistics)localObject2).setEndVoucherNumber(str4);
      ((EvsVoucherStatistics)localObject2).setBookDate(localEvsBook.getBookDate());
      ((EvsVoucherStatistics)localObject2).setDepositSite(localStringBuffer.toString());
      ((EvsVoucherStatistics)localObject2).setIsBreakNumber(localEvsBook.getBookBreakFlag());
      List localList2 = this.lookupTypesDS.findLookupValuesByTypeForLookup("VOUCHER_STATUS");
      Iterator localIterator = localList2.iterator();
      while (localIterator.hasNext())
      {
        FbpLookupValuesV localFbpLookupValuesV = (FbpLookupValuesV)localIterator.next();
        if (localFbpLookupValuesV.getLookupCode().equals(localEvsBook.getBookStatus())) {
          ((EvsVoucherStatistics)localObject2).setStatus(localFbpLookupValuesV.getMeaning());
        }
      }
      localArrayList1.add(localObject2);
    }
    localTableDataInfo.setData(localArrayList1);
    localTableDataInfo.setTotalCount(Integer.parseInt(localMap.get("totalCount").toString()));
    return localTableDataInfo;
  }
  
  public List<EvsVoucherStatistics> findVoucherBigClassByMonth(EvsVoucherStatistics paramEvsVoucherStatistics)
  {
    ArrayList localArrayList = new ArrayList();
    monthTransition(paramEvsVoucherStatistics);
    List localList = getVoucherType();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      FbpLookupValuesV localFbpLookupValuesV = (FbpLookupValuesV)localIterator.next();
      EvsVoucherStatistics localEvsVoucherStatistics = new EvsVoucherStatistics();
      paramEvsVoucherStatistics.setVoucherBigCode(localFbpLookupValuesV.getLookupCode());
      Long localLong1 = this.voucherBookQueryDAO.getVoucherTotalBookNum(paramEvsVoucherStatistics);
      Long localLong2 = this.voucherBookQueryDAO.getVoucherContrastNum(paramEvsVoucherStatistics);
      Long localLong3 = this.voucherBookQueryDAO.getNotBookNum(paramEvsVoucherStatistics);
      localEvsVoucherStatistics.setVoucherTotalBookNumber(localLong1);
      localEvsVoucherStatistics.setMISVoucher(localLong2);
      localEvsVoucherStatistics.setNotBookNumber(localLong3);
      localEvsVoucherStatistics.setVoucherBigClass(localFbpLookupValuesV.getMeaning());
      localEvsVoucherStatistics.setVoucherBigCode(localFbpLookupValuesV.getLookupCode());
      localArrayList.add(localEvsVoucherStatistics);
    }
    return localArrayList;
  }
  
  public List<EvsVoucherStatistics> findMonthVoucherStatisticsByYear(EvsVoucherStatistics paramEvsVoucherStatistics)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = getAllMonthByYear();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      EvsVoucherStatistics localEvsVoucherStatistics = new EvsVoucherStatistics();
      paramEvsVoucherStatistics.setMonth(str);
      monthTransition(paramEvsVoucherStatistics);
      Long localLong1 = this.voucherBookQueryDAO.getVoucherTotalBookNum(paramEvsVoucherStatistics);
      Long localLong2 = this.voucherBookQueryDAO.getVoucherContrastNum(paramEvsVoucherStatistics);
      Long localLong3 = this.voucherBookQueryDAO.getNotBookNum(paramEvsVoucherStatistics);
      if (localLong3.longValue() == 0L) {
        localEvsVoucherStatistics.setIsCloseBook("Y");
      } else {
        localEvsVoucherStatistics.setIsCloseBook("N");
      }
      localEvsVoucherStatistics.setVoucherTotalBookNumber(localLong1);
      localEvsVoucherStatistics.setERPVoucherNumber(localLong2);
      localEvsVoucherStatistics.setNotBookNumber(localLong3);
      localEvsVoucherStatistics.setMonth(str);
      localArrayList.add(localEvsVoucherStatistics);
    }
    return localArrayList;
  }
  
  public List<String> getAllMonthByYear()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("1月");
    localArrayList.add("2月");
    localArrayList.add("3月");
    localArrayList.add("4月");
    localArrayList.add("5月");
    localArrayList.add("6月");
    localArrayList.add("7月");
    localArrayList.add("8月");
    localArrayList.add("9月");
    localArrayList.add("10月");
    localArrayList.add("11月");
    localArrayList.add("12月");
    return localArrayList;
  }
  
  public EvsVoucherStatistics monthTransition(EvsVoucherStatistics paramEvsVoucherStatistics)
  {
    if ("1月".equals(paramEvsVoucherStatistics.getMonth()))
    {
      paramEvsVoucherStatistics.setMonth("JAN");
      paramEvsVoucherStatistics.setChinaMonth("01");
    }
    else if ("2月".equals(paramEvsVoucherStatistics.getMonth()))
    {
      paramEvsVoucherStatistics.setMonth("FEB");
      paramEvsVoucherStatistics.setChinaMonth("02");
    }
    else if ("3月".equals(paramEvsVoucherStatistics.getMonth()))
    {
      paramEvsVoucherStatistics.setMonth("MAR");
      paramEvsVoucherStatistics.setChinaMonth("03");
    }
    else if ("4月".equals(paramEvsVoucherStatistics.getMonth()))
    {
      paramEvsVoucherStatistics.setMonth("APR");
      paramEvsVoucherStatistics.setChinaMonth("04");
    }
    else if ("5月".equals(paramEvsVoucherStatistics.getMonth()))
    {
      paramEvsVoucherStatistics.setMonth("MAY");
      paramEvsVoucherStatistics.setChinaMonth("05");
    }
    else if ("6月".equals(paramEvsVoucherStatistics.getMonth()))
    {
      paramEvsVoucherStatistics.setMonth("JUN");
      paramEvsVoucherStatistics.setChinaMonth("06");
    }
    else if ("7月".equals(paramEvsVoucherStatistics.getMonth()))
    {
      paramEvsVoucherStatistics.setMonth("JUL");
      paramEvsVoucherStatistics.setChinaMonth("07");
    }
    else if ("8月".equals(paramEvsVoucherStatistics.getMonth()))
    {
      paramEvsVoucherStatistics.setMonth("AUG");
      paramEvsVoucherStatistics.setChinaMonth("08");
    }
    else if ("9月".equals(paramEvsVoucherStatistics.getMonth()))
    {
      paramEvsVoucherStatistics.setMonth("SEP");
      paramEvsVoucherStatistics.setChinaMonth("09");
    }
    else if ("10月".equals(paramEvsVoucherStatistics.getMonth()))
    {
      paramEvsVoucherStatistics.setMonth("OCT");
      paramEvsVoucherStatistics.setChinaMonth("10");
    }
    else if ("11月".equals(paramEvsVoucherStatistics.getMonth()))
    {
      paramEvsVoucherStatistics.setMonth("NOV");
      paramEvsVoucherStatistics.setChinaMonth("11");
    }
    else if ("12月".equals(paramEvsVoucherStatistics.getMonth()))
    {
      paramEvsVoucherStatistics.setMonth("DEC");
      paramEvsVoucherStatistics.setChinaMonth("12");
    }
    return paramEvsVoucherStatistics;
  }
  
  public List<FbpLookupValuesV> getVoucherType()
  {
    List localList = this.lookupTypesDS.findLookupValuesByTypeForLookup("EVS_INVOICE_TYPE");
    return localList;
  }
  
  public List<EvsVoucherStatistics> initTree(EasUserInfo paramEasUserInfo)
  {
    ArrayList localArrayList = new ArrayList();
    List localList1 = this.voucherBookQueryDAO.findAllCompany(paramEasUserInfo);
    if ((null != localList1) && (localList1.size() > 0)) {
      for (int i = 0; i < localList1.size(); i++)
      {
        EvsVoucherStatistics localEvsVoucherStatistics = new EvsVoucherStatistics();
        FbpCompanyV localFbpCompanyV = (FbpCompanyV)localList1.get(i);
        localEvsVoucherStatistics.setCompanyId(localFbpCompanyV.getCompanyId());
        localEvsVoucherStatistics.setCompanyCode(localFbpCompanyV.getCompanyCode());
        localEvsVoucherStatistics.setCompanyName(localFbpCompanyV.getCompanyName());
        Integer[] arrayOfInteger = getYear();
        HashMap localHashMap1 = new HashMap();
        HashMap localHashMap2 = new HashMap();
        for (int j = 0; j < arrayOfInteger.length; j++)
        {
          List localList2 = getAllMonthByYear();
          List localList3 = getVoucherType();
          localHashMap2.put(localList2, localList3);
          localHashMap1.put(arrayOfInteger[j], localHashMap2);
        }
        localEvsVoucherStatistics.setMap(localHashMap1);
        localArrayList.add(localEvsVoucherStatistics);
      }
    }
    return localArrayList;
  }
  
  public Integer[] getYear()
  {
    String str = new SimpleDateFormat("yyyy").format(new Date());
    Integer[] arrayOfInteger = { Integer.valueOf(Integer.parseInt(str) - 2), Integer.valueOf(Integer.parseInt(str) - 1), Integer.valueOf(Integer.parseInt(str)) };
    return arrayOfInteger;
  }
  
  public List<EvsVoucherStatistics> findComanyVoucherInfoByCompanyCode(EvsVoucherStatistics paramEvsVoucherStatistics)
  {
    ArrayList localArrayList = new ArrayList();
    Integer[] arrayOfInteger = getYear();
    for (int i = 0; i < arrayOfInteger.length; i++)
    {
      EvsVoucherStatistics localEvsVoucherStatistics = new EvsVoucherStatistics();
      localEvsVoucherStatistics.setYears(arrayOfInteger[i].toString());
      List localList1 = this.voucherBookQueryDAO.findVoucherNumber(paramEvsVoucherStatistics.getCompanyCode(), localEvsVoucherStatistics.getYears());
      if ((localList1 != null) && (localList1.size() > 0)) {
        for (int j = 0; j < localList1.size(); j++) {
          localEvsVoucherStatistics.setVoucherNumber(((EvsVoucherStatistics)localList1.get(j)).getVoucherNumber());
        }
      }
      List localList2 = this.voucherBookQueryDAO.findVoucherBookNumber(paramEvsVoucherStatistics.getCompanyCode(), localEvsVoucherStatistics.getYears());
      if ((localList2 != null) && (localList2.size() > 0)) {
        for (int k = 0; k < localList2.size(); k++) {
          localEvsVoucherStatistics.setVoucherBookNumber(((EvsVoucherStatistics)localList2.get(k)).getVoucherBookNumber());
        }
      }
      List localList3 = this.voucherBookQueryDAO.findVoucherPageNumber(paramEvsVoucherStatistics.getCompanyCode(), localEvsVoucherStatistics.getYears());
      if ((localList3 != null) && (localList3.size() > 0)) {
        for (int m = 0; m < localList3.size(); m++) {
          localEvsVoucherStatistics.setVoucherPageNumber(((EvsVoucherStatistics)localList3.get(m)).getVoucherPageNumber());
        }
      }
      localArrayList.add(localEvsVoucherStatistics);
    }
    return localArrayList;
  }
  
  public TableDataInfo findVoucherStatistics(FbpCompanyV paramFbpCompanyV, int paramInt1, int paramInt2)
  {
    EasUserInfo localEasUserInfo = EisConsts.getCurrentUser();
    Map localMap = this.voucherBookQueryDAO.findAllCompany(paramFbpCompanyV, localEasUserInfo, paramInt1, paramInt2);
    TableDataInfo localTableDataInfo = new TableDataInfo();
    ArrayList localArrayList = new ArrayList();
    List localList1 = (List)localMap.get("data");
    for (int i = 0; i < localList1.size(); i++)
    {
      FbpCompanyV localFbpCompanyV = (FbpCompanyV)localList1.get(i);
      EvsVoucherStatistics localEvsVoucherStatistics = new EvsVoucherStatistics();
      localEvsVoucherStatistics.setCompanyId(localFbpCompanyV.getCompanyId());
      localEvsVoucherStatistics.setCompanyCode(localFbpCompanyV.getCompanyCode());
      localEvsVoucherStatistics.setCompanyName(localFbpCompanyV.getCompanyName());
      List localList2 = this.voucherBookQueryDAO.findVoucherNumberFHY(localFbpCompanyV.getCompanyCode());
      if ((localList2 != null) && (localList2.size() > 0)) {
        localEvsVoucherStatistics.setVoucherNumberFHY(((EvsVoucherStatistics)localList2.get(0)).getVoucherNumberFHY());
      } else {
        localEvsVoucherStatistics.setVoucherNumberFHY(0L);
      }
      List localList3 = this.voucherBookQueryDAO.findVoucherNumberTY(localFbpCompanyV.getCompanyCode());
      if ((localList3 != null) && (localList3.size() > 0)) {
        localEvsVoucherStatistics.setVoucherNumberTY(((EvsVoucherStatistics)localList3.get(0)).getVoucherNumberTY());
      } else {
        localEvsVoucherStatistics.setVoucherNumberTY(0L);
      }
      List localList4 = this.voucherBookQueryDAO.findVoucherBookFHY(localFbpCompanyV.getCompanyCode());
      if ((localList4 != null) && (localList4.size() > 0)) {
        localEvsVoucherStatistics.setVoucherBookFHY(((EvsVoucherStatistics)localList4.get(0)).getVoucherBookFHY());
      } else {
        localEvsVoucherStatistics.setVoucherBookFHY(Long.valueOf(0L));
      }
      List localList5 = this.voucherBookQueryDAO.findVoucherBookTY(localFbpCompanyV.getCompanyCode());
      if ((localList5 != null) && (localList5.size() > 0)) {
        localEvsVoucherStatistics.setVoucherBookTY(((EvsVoucherStatistics)localList5.get(0)).getVoucherBookTY());
      } else {
        localEvsVoucherStatistics.setVoucherBookTY(Long.valueOf(0L));
      }
      List localList6 = this.voucherBookQueryDAO.findVoucherPageFHY(localFbpCompanyV.getCompanyCode());
      if ((localList6 != null) && (localList6.size() > 0)) {
        localEvsVoucherStatistics.setVoucherPageFHY(((EvsVoucherStatistics)localList6.get(0)).getVoucherPageFHY());
      } else {
        localEvsVoucherStatistics.setVoucherPageFHY(0L);
      }
      List localList7 = this.voucherBookQueryDAO.findVoucherPageTY(localFbpCompanyV.getCompanyCode());
      if ((localList7 != null) && (localList7.size() > 0)) {
        localEvsVoucherStatistics.setVoucherPageTY(((EvsVoucherStatistics)localList7.get(0)).getVoucherPageTY());
      } else {
        localEvsVoucherStatistics.setVoucherPageTY(0L);
      }
      localArrayList.add(localEvsVoucherStatistics);
    }
    localTableDataInfo.setData(localArrayList);
    localTableDataInfo.setTotalCount(Integer.parseInt(localMap.get("totalCount").toString()));
    return localTableDataInfo;
  }
  
  public List<EvsVoucherStatistics> findVoucherStatistics(EasUserInfo paramEasUserInfo)
  {
    Map localMap = this.voucherBookQueryDAO.findAllCompany(null, paramEasUserInfo, 1, 1000000000);
    TableDataInfo localTableDataInfo = new TableDataInfo();
    ArrayList localArrayList = new ArrayList();
    List localList1 = (List)localMap.get("data");
    for (int i = 0; i < localList1.size(); i++)
    {
      FbpCompanyV localFbpCompanyV = (FbpCompanyV)localList1.get(i);
      EvsVoucherStatistics localEvsVoucherStatistics = new EvsVoucherStatistics();
      localEvsVoucherStatistics.setCompanyId(localFbpCompanyV.getCompanyId());
      localEvsVoucherStatistics.setCompanyCode(localFbpCompanyV.getCompanyCode());
      localEvsVoucherStatistics.setCompanyName(localFbpCompanyV.getCompanyName());
      List localList2 = this.voucherBookQueryDAO.findVoucherNumberFHY(localFbpCompanyV.getCompanyCode());
      if ((localList2 != null) && (localList2.size() > 0)) {
        localEvsVoucherStatistics.setVoucherNumberFHY(((EvsVoucherStatistics)localList2.get(0)).getVoucherNumberFHY());
      } else {
        localEvsVoucherStatistics.setVoucherNumberFHY(0L);
      }
      List localList3 = this.voucherBookQueryDAO.findVoucherNumberTY(localFbpCompanyV.getCompanyCode());
      if ((localList3 != null) && (localList3.size() > 0)) {
        localEvsVoucherStatistics.setVoucherNumberTY(((EvsVoucherStatistics)localList3.get(0)).getVoucherNumberTY());
      } else {
        localEvsVoucherStatistics.setVoucherNumberTY(0L);
      }
      List localList4 = this.voucherBookQueryDAO.findVoucherBookFHY(localFbpCompanyV.getCompanyCode());
      if ((localList4 != null) && (localList4.size() > 0)) {
        localEvsVoucherStatistics.setVoucherBookFHY(((EvsVoucherStatistics)localList4.get(0)).getVoucherBookFHY());
      } else {
        localEvsVoucherStatistics.setVoucherBookFHY(Long.valueOf(0L));
      }
      List localList5 = this.voucherBookQueryDAO.findVoucherBookTY(localFbpCompanyV.getCompanyCode());
      if ((localList5 != null) && (localList5.size() > 0)) {
        localEvsVoucherStatistics.setVoucherBookTY(((EvsVoucherStatistics)localList5.get(0)).getVoucherBookTY());
      } else {
        localEvsVoucherStatistics.setVoucherBookTY(Long.valueOf(0L));
      }
      List localList6 = this.voucherBookQueryDAO.findVoucherPageFHY(localFbpCompanyV.getCompanyCode());
      if ((localList6 != null) && (localList6.size() > 0)) {
        localEvsVoucherStatistics.setVoucherPageFHY(((EvsVoucherStatistics)localList6.get(0)).getVoucherPageFHY());
      } else {
        localEvsVoucherStatistics.setVoucherPageFHY(0L);
      }
      List localList7 = this.voucherBookQueryDAO.findVoucherPageTY(localFbpCompanyV.getCompanyCode());
      if ((localList7 != null) && (localList7.size() > 0)) {
        localEvsVoucherStatistics.setVoucherPageTY(((EvsVoucherStatistics)localList7.get(0)).getVoucherPageTY());
      } else {
        localEvsVoucherStatistics.setVoucherPageTY(0L);
      }
      localArrayList.add(localEvsVoucherStatistics);
    }
    return localArrayList;
  }
  
  public IEvsVoucherBookQueryDAO getVoucherBookQueryDAO()
  {
    return this.voucherBookQueryDAO;
  }
  
  public void setVoucherBookQueryDAO(IEvsVoucherBookQueryDAO paramIEvsVoucherBookQueryDAO)
  {
    this.voucherBookQueryDAO = paramIEvsVoucherBookQueryDAO;
  }
  
  public IFbpLookupTypesDS getLookupTypesDS()
  {
    return this.lookupTypesDS;
  }
  
  public void setLookupTypesDS(IFbpLookupTypesDS paramIFbpLookupTypesDS)
  {
    this.lookupTypesDS = paramIFbpLookupTypesDS;
  }
  
  public IEvsDocAccessStorageDAO getDocAccessStorageDAO()
  {
    return this.docAccessStorageDAO;
  }
  
  public void setDocAccessStorageDAO(IEvsDocAccessStorageDAO paramIEvsDocAccessStorageDAO)
  {
    this.docAccessStorageDAO = paramIEvsDocAccessStorageDAO;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.eBillManage.EvsVoucherBookQueryService
 * JD-Core Version:    0.7.0.1
 */