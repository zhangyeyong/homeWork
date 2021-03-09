package com.zte.evs.ebill.business.eBillManage;

import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.eimage.access.baseconfig.dao.IImageCommonDAO;
import com.zte.eimage.business.baseconfig.util.EidObjectUtils;
import com.zte.evs.business.baseconfig.model.FasciculeTreeV;
import com.zte.evs.ebill.access.eBillManage.EFasciculeTreeVDAO;
import com.zte.evs.ebill.access.eBillManage.EvsBookDAO;
import com.zte.evs.ebill.access.eBillManage.EvsVoucherHistoryDAO;
import com.zte.evs.ebill.access.eBillManage.IEvsVoucherDAO;
import com.zte.evs.ebill.access.eBillManage.IEvsVoucherGenerateDAO;
import com.zte.evs.ebill.common.EvsObjectUtils;
import com.zte.evs.ebill.common.EvsStatusUtil;
import com.zte.evs.ebill.common.ObjectCopyUtils;
import com.zte.evs.ebill.model.eBillManage.BookMenuModel;
import com.zte.evs.ebill.model.eBillManage.EvsBook;
import com.zte.evs.ebill.model.eBillManage.EvsBookModel;
import com.zte.evs.ebill.model.eBillManage.EvsBookStatisticV;
import com.zte.evs.ebill.model.eBillManage.EvsBookV;
import com.zte.evs.ebill.model.eBillManage.EvsVoucher;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherBookPackage;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherBookV;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherSelect;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherV;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.util.Util;
import java.io.PrintStream;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.axis.utils.StringUtils;

public class EvsBookService
  implements IEvsBookService
{
  private IEvsVoucherGenerateDAO evsVoucherGenerateDAO;
  private EvsBookDAO ebookDAO;
  private EFasciculeTreeVDAO efasciculeQueryDAO;
  private EvsVoucherHistoryDAO evsVoucherHistoryDAO;
  private EidObjectUtils objectUtils;
  static final String DEFAUTSELECTVALUE = "";
  static final String tempBookCode = "C999999999999";
  private static boolean isFlag = true;
  static final String EVSBOOK = "EVS-BOOK";
  
  public EvsBookDAO getEbookDAO()
  {
    return this.ebookDAO;
  }
  
  public void setEbookDAO(EvsBookDAO paramEvsBookDAO)
  {
    this.ebookDAO = paramEvsBookDAO;
  }
  
  public EvsVoucherHistoryDAO getEvsVoucherHistoryDAO()
  {
    return this.evsVoucherHistoryDAO;
  }
  
  public void setEvsVoucherHistoryDAO(EvsVoucherHistoryDAO paramEvsVoucherHistoryDAO)
  {
    this.evsVoucherHistoryDAO = paramEvsVoucherHistoryDAO;
  }
  
  public String getBookArchiveNumberByCode(EvsBookModel paramEvsBookModel)
  {
    String str = "";
    if ((paramEvsBookModel != null) && (paramEvsBookModel.getBookCode() != null) && (!"".equals(paramEvsBookModel.getBookCode())))
    {
      String[] arrayOfString = paramEvsBookModel.getBookCode().split(",");
      if ((arrayOfString != null) && (arrayOfString.length > 0)) {
        for (int i = 0; i < arrayOfString.length; i++)
        {
          EvsBook localEvsBook = this.ebookDAO.getBookByCode(arrayOfString[i]);
          if ((localEvsBook.getArchiveNumber() != null) && (!"".equals(localEvsBook.getArchiveNumber())))
          {
            str = str + localEvsBook.getArchiveNumber().toString();
            if (i + 1 <= arrayOfString.length) {
              str = str + ";";
            }
          }
        }
      }
    }
    return str;
  }
  
  public String getBookVoucherByCode(EvsBookModel paramEvsBookModel)
  {
    String str = "";
    if ((paramEvsBookModel != null) && (paramEvsBookModel.getBookCode() != null) && (!"".equals(paramEvsBookModel.getBookCode())))
    {
      String[] arrayOfString = paramEvsBookModel.getBookCode().split(",");
      if ((arrayOfString != null) && (arrayOfString.length > 0)) {
        for (int i = 0; i < arrayOfString.length; i++)
        {
          EvsBook localEvsBook = this.ebookDAO.getBookByCode(arrayOfString[i]);
          if ((localEvsBook.getBeginNum() != null) && (!"".equals(localEvsBook.getBeginNum())))
          {
            if ((localEvsBook.getEndNum() != null) && (!"".equals(localEvsBook.getEndNum()))) {
              str = str + localEvsBook.getBeginNum().toString() + "," + localEvsBook.getEndNum().toString();
            }
            if (i + 1 <= arrayOfString.length) {
              str = str + ";";
            }
          }
        }
      }
    }
    return str;
  }
  
  public String getBookInFoById(EvsBookModel paramEvsBookModel)
  {
    String str = "";
    if ((paramEvsBookModel != null) && (paramEvsBookModel.getBookId() != null) && (!"".equals(paramEvsBookModel.getBookId())))
    {
      EvsBook localEvsBook = this.ebookDAO.getBookById(paramEvsBookModel.getBookId());
      if ((localEvsBook.getBookCode() != null) && (localEvsBook.getBookCode() != null))
      {
        str = localEvsBook.getBookCode().toString();
        if ("C999999999999".equals(str)) {
          str = "true";
        }
      }
    }
    return str;
  }
  
  public String getDocNameBySubName(EvsBookModel paramEvsBookModel)
  {
    String str1 = "";
    if ((paramEvsBookModel.getSubdocname() != null) && (!"".equals(paramEvsBookModel.getSubdocname())))
    {
      String str2 = paramEvsBookModel.getSubdocname();
      if ((str2 != null) && (!"".equals(str2))) {
        str1 = this.ebookDAO.getDocNameBySubName(str2);
      }
    }
    return str1;
  }
  
  public List getDocName(EvsBookModel paramEvsBookModel)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramEvsBookModel.getSubdoccode() != null) && (!"".equals(paramEvsBookModel.getSubdoccode())))
    {
      String[] arrayOfString = paramEvsBookModel.getSubdoccode().split(",");
      String str = null;
      for (int i = 0; i < arrayOfString.length; i++)
      {
        str = arrayOfString[i];
        if ((str != null) && (!"".equals(str)) && (this.ebookDAO.getDocName(str) != null) && (!"".equals(this.ebookDAO.getDocName(str)))) {
          localArrayList.add(this.ebookDAO.getDocName(str));
        }
      }
    }
    return localArrayList;
  }
  
  public String isVoucherBooked(EvsBookModel paramEvsBookModel)
  {
    return this.ebookDAO.isVoucherBooked(paramEvsBookModel);
  }
  
  public TableDataInfo getBookQuery(EvsBookModel paramEvsBookModel, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    Object localObject = new ArrayList();
    PageInfo localPageInfo = this.ebookDAO.findEmployeesByQry(paramEvsBookModel, paramInt1, paramInt2);
    localObject = (List)localPageInfo.getResult();
    if (((List)localObject).size() > 0)
    {
      localTableDataInfo.setData((List)localObject);
      localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
    }
    return localTableDataInfo;
  }
  
  public List<String> getJournalNum(List<EvsBookModel> paramList)
  {
    Object localObject = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    EvsBookModel localEvsBookModel = new EvsBookModel();
    if (paramList.size() > 0) {
      for (int i = 0; i < paramList.size(); i++)
      {
        localEvsBookModel = (EvsBookModel)paramList.get(i);
        localObject = this.ebookDAO.getJournalNum(localEvsBookModel);
        if (((List)localObject).size() > 0) {
          for (int j = 0; j < ((List)localObject).size(); j++)
          {
            localArrayList.add(String.valueOf(((List)localObject).get(j)));
            if (j == ((List)localObject).size() - 1) {
              localArrayList.add(";");
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  public TableDataInfo getHeaders(EvsBookModel paramEvsBookModel, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    Map localMap = null;
    if (!paramEvsBookModel.getBookId().equals(""))
    {
      localMap = this.ebookDAO.findEvsHeaderByQry(paramEvsBookModel, paramInt1, paramInt2);
      if (localMap != null)
      {
        localTableDataInfo.setData((List)localMap.get("data"));
        localTableDataInfo.setTotalCount(Integer.parseInt(localMap.get("totalCount").toString()));
        return localTableDataInfo;
      }
    }
    return localTableDataInfo;
  }
  
  public TableDataInfo getHeaderForL(EvsBookModel paramEvsBookModel, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    Map localMap = null;
    List localList = this.ebookDAO.findBookByArchiveNumber(paramEvsBookModel.getArchiveNumber());
    if (null != localList)
    {
      for (int j = 0; j < localList.size(); j++)
      {
        EvsBook localEvsBook = (EvsBook)localList.get(j);
        localMap = this.ebookDAO.findFasciculeForL(localEvsBook, paramInt1, paramInt2);
        if (localMap != null)
        {
          i += Integer.parseInt(localMap.get("totalCount").toString());
          localArrayList.addAll((List)localMap.get("data"));
        }
      }
      localTableDataInfo.setData(localArrayList);
      localTableDataInfo.setTotalCount(i);
    }
    return localTableDataInfo;
  }
  
  public TableDataInfo getHeaderForYB(EvsVoucherSelect paramEvsVoucherSelect, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    Long localLong = null;
    EvsBookModel localEvsBookModel = new EvsBookModel();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    Map localMap = null;
    List localList = this.ebookDAO.findBookByArchiveNumber(paramEvsVoucherSelect.getArchiveNumber());
    Object localObject1 = localList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (EvsBook)((Iterator)localObject1).next();
      localLong = ((EvsBook)localObject2).getBookId();
      localEvsBookModel.setBookId(Long.toString(localLong.longValue()));
      localMap = this.ebookDAO.findEvsVoucherByNum(localEvsBookModel, paramInt1, paramInt2);
    }
    localObject1 = (List)localMap.get("data");
    Object localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      EvsVoucherBookV localEvsVoucherBookV = (EvsVoucherBookV)((Iterator)localObject2).next();
      localEvsVoucherBookV.setTempBookId(localLong);
    }
    localTableDataInfo.setData((List)localObject1);
    localTableDataInfo.setTotalCount(Integer.parseInt(localMap.get("totalCount").toString()));
    return localTableDataInfo;
  }
  
  public void insertBook(List<String> paramList, EvsBookModel paramEvsBookModel)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    EvsBook localEvsBook = null;
    Object localObject = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      if (paramEvsBookModel.getBookId() != null) {
        localEvsBook = this.ebookDAO.insertBook(paramEvsBookModel);
      }
      localObject = this.evsVoucherGenerateDAO.getEvsVoucherBookPackageByBookId(Long.valueOf(paramEvsBookModel.getBookId()));
      for (int i = 0; i < ((List)localObject).size(); i++)
      {
        paramEvsBookModel.setVoucherId(String.valueOf(((List)localObject).get(i)));
        if (paramEvsBookModel != null) {
          updateHeaderInfo(paramEvsBookModel);
        }
      }
      if (localEvsBook != null)
      {
        Long localLong = localEvsBook.getBookId();
        if (localLong.longValue() > 0L) {
          this.evsVoucherHistoryDAO.addHistory(localEasUserInfo, 1L, localLong.toString(), EvsStatusUtil.getOperName("BOOKED"), "BOOKED", "BOOKED");
        }
      }
    }
  }
  
  public Long insertBooks(String paramString1, String paramString2, String paramString3, String[] paramArrayOfString, String paramString4, String paramString5)
  {
    EvsBook localEvsBook = null;
    String str = "";
    Object localObject2;
    for (localObject2 : paramArrayOfString) {
      str = str + (String)localObject2 + ",";
    }
    ??? = paramArrayOfString;
    ArrayList localArrayList = new ArrayList();
    if (!Util.isStrEmpty(paramString5))
    {
      if ((null != str) && (!"".equals(str)))
      {
        localObject1 = this.ebookDAO.isVoucherDelet(paramString5, str);
        if (((List)localObject1).size() > 0)
        {
          localObject2 = ((List)localObject1).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            EvsVoucherBookPackage localEvsVoucherBookPackage = (EvsVoucherBookPackage)((Iterator)localObject2).next();
            localEvsVoucherBookPackage.setEnabledFlag("N");
          }
          this.ebookDAO.updateObjects((List)localObject1);
        }
      }
      Object localObject1 = new EvsBook();
      ((EvsBook)localObject1).setBookId(Long.valueOf(paramString5));
      this.ebookDAO.insertBookPackage((EvsBook)localObject1, ???);
      return Long.valueOf(paramString5);
    }
    localEvsBook = this.ebookDAO.insertBooks(paramString1, paramString2, paramString3, paramString4);
    this.ebookDAO.insertBookPackage(localEvsBook, ???);
    return localEvsBook.getBookId();
  }
  
  public Long insertBooksForL(EvsBookModel paramEvsBookModel, List<EvsBookModel> paramList, String paramString1, String paramString2)
  {
    EvsBook localEvsBook = null;
    Object localObject = new ArrayList();
    if ((null != paramString2) && (!"".equals(paramString2))) {
      localObject = this.ebookDAO.findBooksForL(paramString2);
    }
    if (((List)localObject).size() > 0)
    {
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        EvsVoucherBookPackage localEvsVoucherBookPackage = (EvsVoucherBookPackage)localIterator.next();
        localEvsVoucherBookPackage.setEnabledFlag("N");
      }
      this.ebookDAO.updateObjects((List)localObject);
    }
    localEvsBook = this.ebookDAO.insertBooksForL(paramEvsBookModel.getPeriodName(), paramEvsBookModel.getCompanyCode(), paramEvsBookModel.getInvoiceType(), paramString1, paramEvsBookModel);
    this.ebookDAO.insertBookPackageList(paramList, localEvsBook.getBookId());
    return localEvsBook.getBookId();
  }
  
  public String insertBooksForL2(EvsBookModel paramEvsBookModel, List<EvsBookModel> paramList)
  {
    Date localDate = new Date();
    String str1 = "";
    String str2 = "";
    Object localObject2;
    Object localObject3;
    if ((null != paramEvsBookModel.getArchiveNumber()) && (!"".equals(paramEvsBookModel.getArchiveNumber())))
    {
      str1 = paramEvsBookModel.getArchiveNumber();
      localObject1 = "delete from evs.evs_book where archive_number = ?";
      localObject2 = new ArrayList();
      ((List)localObject2).add(str1);
      localObject3 = (IImageCommonDAO)SSBBus.findDomainService("imageCommonDAO");
      ((IImageCommonDAO)localObject3).executeSql((String)localObject1, (List)localObject2);
    }
    else
    {
      str1 = Long.toString(localDate.getTime()) + Math.random() * 100.0D;
    }
    paramEvsBookModel.setArchiveNumber(str1);
    Object localObject1 = paramList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (EvsBookModel)((Iterator)localObject1).next();
      localObject3 = "";
      ((EvsBookModel)localObject2).setCompanyCode(paramEvsBookModel.getCompanyCode());
      ((EvsBookModel)localObject2).setPeriodName(paramEvsBookModel.getPeriodName());
      EvsBook localEvsBook = null;
      localEvsBook = this.ebookDAO.insertBooksForL(paramEvsBookModel.getPeriodName(), paramEvsBookModel.getCompanyCode(), paramEvsBookModel.getInvoiceType(), (String)localObject3, paramEvsBookModel, (EvsBookModel)localObject2);
      this.ebookDAO.insertBookPackageList((EvsBookModel)localObject2, localEvsBook.getBookId());
    }
    System.out.println(str1 + "--------------------------------------------------");
    return str1;
  }
  
  public String insertBooksForYB(EvsVoucherSelect paramEvsVoucherSelect, String paramString1, String paramString2)
  {
    Date localDate = new Date();
    String str1 = "";
    String str2 = "";
    String str3 = "";
    EvsBook localEvsBook1 = null;
    String str4 = "";
    String str5 = "";
    if ((null != paramEvsVoucherSelect.getArchiveNumber()) && (!"".equals(paramEvsVoucherSelect.getArchiveNumber()))) {
      str2 = paramEvsVoucherSelect.getArchiveNumber();
    } else {
      str2 = Long.toString(localDate.getTime()) + Math.random() * 100.0D;
    }
    paramEvsVoucherSelect.setArchiveNumber(str2);
    IEvsVoucherGenerateService localIEvsVoucherGenerateService = (IEvsVoucherGenerateService)SSBBus.findDomainService("evsVoucherGenerateServiceDS");
    List localList1 = localIEvsVoucherGenerateService.getHeaderListForFascicileByList(paramEvsVoucherSelect);
    String str6 = "";
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = new String[localList1.size()];
    for (int i = 0; i < localList1.size(); i++) {
      if (i < localList1.size() - 1) {
        arrayOfString[i] = (((EvsVoucherV)localList1.get(i)).getVoucherId() + "");
      } else {
        arrayOfString[i] = (((EvsVoucherV)localList1.get(i)).getVoucherId().toString() + "");
      }
    }
    String str7 = "";
    for (int j = 0; j < arrayOfString.length; j++)
    {
      str7 = str7 + arrayOfString[j] + ",";
      if (j == arrayOfString.length - 1) {
        str7 = str7 + arrayOfString[j];
      }
      long l = Long.valueOf(arrayOfString[j]).longValue();
      EvsVoucherV localEvsVoucherV1 = this.evsVoucherGenerateDAO.queryEvsVoucherList(l);
      localArrayList.add(localEvsVoucherV1);
      if (j == 0)
      {
        paramString2 = localEvsVoucherV1.getCompanyCode();
        str6 = localEvsVoucherV1.getInvoiceType();
      }
      if ((arrayOfString.length == 1) && (arrayOfString.length != 0))
      {
        str4 = localEvsVoucherV1.getJournalNum();
        str5 = str4;
      }
      else if ((arrayOfString.length > 1) && (arrayOfString.length != 0))
      {
        str4 = ((EvsVoucherV)localArrayList.get(0)).getJournalNum();
        if (arrayOfString.length == localArrayList.size()) {
          str5 = ((EvsVoucherV)localArrayList.get(arrayOfString.length - 1)).getJournalNum();
        }
      }
    }
    EvsBookModel localEvsBookModel = new EvsBookModel();
    localEvsBookModel.setCompanyCode(paramString2);
    localEvsBookModel.setPeriodName(paramString1);
    int k = 0;
    int m = 0;
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      EvsVoucherV localEvsVoucherV2 = (EvsVoucherV)localIterator.next();
      paramEvsVoucherSelect.setVoucherId(localEvsVoucherV2.getVoucherId());
      paramEvsVoucherSelect.setBeginNum(str4);
      paramEvsVoucherSelect.setEndNum(str5);
      String str8 = "";
      localEvsBookModel.setCompanyCode(paramEvsVoucherSelect.getCompanyCode());
      localEvsBookModel.setPeriodName(paramString1);
      if (str1 != "") {
        str3 = str1.substring(0, str1.length() - 1);
      }
      if (k == 0)
      {
        EvsBook localEvsBook2 = null;
        if ((paramEvsVoucherSelect.getBookId() != null) && (!paramEvsVoucherSelect.getBookId().toString().equals("0"))) {
          localEvsBook2 = (EvsBook)this.ebookDAO.getObject(EvsBook.class, paramEvsVoucherSelect.getBookId());
        }
        if (null != localEvsBook2)
        {
          str8 = localEvsBook2.getBookCode();
          str1 = str1 + "'" + str8 + "',";
          m = 1;
          this.ebookDAO.deleteEvsBook(localEvsBook2);
        }
        else
        {
          EvsBook localEvsBook3 = this.ebookDAO.getBookByStatusNew(paramString2, paramString1);
          if (localEvsBook3 != null)
          {
            str8 = localEvsBook3.getBookCode();
            str1 = str1 + "'" + str8 + "',";
            List localList2 = this.ebookDAO.findBooksForL(localEvsBook3.getBookId().toString());
            if (localList2.size() > 0) {
              this.ebookDAO.removeObjects(localList2);
            }
            this.ebookDAO.deleteEvsBook(localEvsBook3);
          }
          else
          {
            str8 = getGenerarionNmber(localEvsBookModel);
            str1 = str1 + "'" + str8 + "',";
          }
        }
        k = 1;
      }
      if (localEvsBook1 != null)
      {
        this.ebookDAO.insertBookPackageList(paramEvsVoucherSelect, localEvsBook1.getBookId());
      }
      else
      {
        localEvsBook1 = this.ebookDAO.insertBooksForYB(localEvsVoucherV2.getPeriodName(), localEvsVoucherV2.getCompanyCode(), localEvsVoucherV2.getInvoiceType(), str8, paramEvsVoucherSelect, localEvsVoucherV2, str4, str5);
        this.ebookDAO.insertBookPackageList(paramEvsVoucherSelect, localEvsBook1.getBookId());
      }
    }
    this.ebookDAO.deleteBookPackageVoucherByBookId(localEvsBook1.getBookId(), arrayOfString);
    System.out.println(str2 + "--------------------------------------------------");
    return str2;
  }
  
  public String updateEvsBookForS(EvsVoucherSelect paramEvsVoucherSelect, String paramString1, String paramString2)
  {
    EvsBookModel localEvsBookModel1 = new EvsBookModel();
    boolean bool = false;
    localEvsBookModel1.setBookId(String.valueOf(paramEvsVoucherSelect.getBookId()));
    bool = updateBookVoucherInfoByCodeForS(localEvsBookModel1);
    Date localDate = new Date();
    String str1 = "";
    String str2 = "";
    String str3 = "";
    EvsBook localEvsBook = null;
    String str4 = "";
    String str5 = "";
    if ((null != paramEvsVoucherSelect.getArchiveNumber()) && (!"".equals(paramEvsVoucherSelect.getArchiveNumber()))) {
      str2 = paramEvsVoucherSelect.getArchiveNumber();
    } else {
      str2 = Long.toString(localDate.getTime()) + Math.random() * 100.0D;
    }
    paramEvsVoucherSelect.setArchiveNumber(str2);
    IEvsVoucherGenerateService localIEvsVoucherGenerateService = (IEvsVoucherGenerateService)SSBBus.findDomainService("evsVoucherGenerateServiceDS");
    List localList = localIEvsVoucherGenerateService.getHeaderListForFascicileByList(paramEvsVoucherSelect);
    String str6 = "";
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = new String[localList.size()];
    for (int i = 0; i < localList.size(); i++) {
      if (i < localList.size() - 1) {
        arrayOfString[i] = (((EvsVoucherV)localList.get(i)).getVoucherId() + "");
      } else {
        arrayOfString[i] = (((EvsVoucherV)localList.get(i)).getVoucherId().toString() + "");
      }
    }
    String str7 = "";
    for (int j = 0; j < arrayOfString.length; j++)
    {
      str7 = str7 + arrayOfString[j] + ",";
      if (j == arrayOfString.length - 1) {
        str7 = str7 + arrayOfString[j];
      }
      long l = Long.valueOf(arrayOfString[j]).longValue();
      localObject = this.evsVoucherGenerateDAO.queryEvsVoucherList(l);
      localArrayList.add(localObject);
      if (j == 0)
      {
        paramString1 = ((EvsVoucherV)localObject).getPeriodName();
        paramString2 = ((EvsVoucherV)localObject).getCompanyCode();
        str6 = ((EvsVoucherV)localObject).getInvoiceType();
      }
      if ((arrayOfString.length == 1) && (arrayOfString.length != 0))
      {
        str4 = ((EvsVoucherV)localObject).getJournalNum();
        str5 = str4;
      }
      else if ((arrayOfString.length > 1) && (arrayOfString.length != 0))
      {
        str4 = ((EvsVoucherV)localArrayList.get(0)).getJournalNum();
        if (arrayOfString.length == localArrayList.size()) {
          str5 = ((EvsVoucherV)localArrayList.get(arrayOfString.length - 1)).getJournalNum();
        }
      }
    }
    EvsBookModel localEvsBookModel2 = new EvsBookModel();
    localEvsBookModel2.setCompanyCode(paramString2);
    localEvsBookModel2.setPeriodName(paramString1);
    Object localObject = localArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      EvsVoucherV localEvsVoucherV = (EvsVoucherV)((Iterator)localObject).next();
      paramEvsVoucherSelect.setVoucherId(localEvsVoucherV.getVoucherId());
      paramEvsVoucherSelect.setBeginNum(str4);
      paramEvsVoucherSelect.setEndNum(str5);
      String str8 = "";
      localEvsBookModel2.setCompanyCode(paramEvsVoucherSelect.getCompanyCode());
      localEvsBookModel2.setPeriodName(paramEvsVoucherSelect.getPeriod_name());
      if (str1 != "") {
        str3 = str1.substring(0, str1.length() - 1);
      }
      if (bool)
      {
        str8 = paramEvsVoucherSelect.getBookCode();
        str1 = str1 + "'" + str8 + "',";
      }
      if (localEvsBook != null)
      {
        this.ebookDAO.insertBookPackageList(paramEvsVoucherSelect, localEvsBook.getBookId());
      }
      else
      {
        localEvsBook = this.ebookDAO.insertBooksForYB(localEvsVoucherV.getPeriodName(), localEvsVoucherV.getCompanyCode(), localEvsVoucherV.getInvoiceType(), str8, paramEvsVoucherSelect, localEvsVoucherV, str4, str5);
        this.ebookDAO.insertBookPackageList(paramEvsVoucherSelect, localEvsBook.getBookId());
      }
    }
    this.ebookDAO.deleteBookPackageVoucherByBookId(localEvsBook.getBookId(), arrayOfString);
    System.out.println(str2 + "--------------------------------------------------");
    localObject = this.ebookDAO.getBookByStatusNew(paramEvsVoucherSelect.getCompanyCode(), paramEvsVoucherSelect.getPeriod_name());
    if (null != localObject) {
      this.ebookDAO.deleteEvsBook((EvsBook)localObject);
    }
    return str2;
  }
  
  public EvsBookV getBookInfoByCode(EvsBookModel paramEvsBookModel)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    EvsBookV localEvsBookV = this.ebookDAO.getBookInfoByCode(paramEvsBookModel);
    EvsBook localEvsBook = new EvsBook();
    if ((paramEvsBookModel.getBookCode() != null) && (!"".equals(paramEvsBookModel.getBookCode()))) {
      localEvsBook = this.ebookDAO.getBookByCode(paramEvsBookModel.getBookCode());
    }
    if (localEvsBookV != null)
    {
      if ((localEvsBook.getBookCount() != null) && (!"".equals(localEvsBook.getBookCount()))) {
        localEvsBookV.setBookCount(localEvsBook.getBookCount().toString());
      }
      if ((localEvsBook.getBookSum() != null) && (!"".equals(localEvsBook.getBookSum()))) {
        localEvsBookV.setBookSum(localEvsBook.getBookSum().toString());
      }
      return localEvsBookV;
    }
    return null;
  }
  
  public EvsBookV getBookInfoByArchiveNumber(EvsBookModel paramEvsBookModel)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    EvsBookV localEvsBookV = this.ebookDAO.getBookInfoByArchiveNumber(paramEvsBookModel);
    EvsBook localEvsBook = new EvsBook();
    return localEvsBookV;
  }
  
  public EvsBookV getBookInfoByBookId(EvsBookModel paramEvsBookModel)
  {
    return this.ebookDAO.getBookInfoByBookId(paramEvsBookModel);
  }
  
  public List<String> updateHeaderInfo(EvsBookModel paramEvsBookModel)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    Object localObject = new ArrayList();
    EvsBook localEvsBook = null;
    StringBuffer localStringBuffer = new StringBuffer();
    if ((paramEvsBookModel.getBookCode() != null) && (!paramEvsBookModel.getBookCode().equals("")))
    {
      localEvsBook = this.ebookDAO.getBookById(paramEvsBookModel.getBookId());
      if (this.evsVoucherGenerateDAO.update(localEvsBook, paramEvsBookModel))
      {
        String[] arrayOfString1 = paramEvsBookModel.getVoucherId().split(",");
        for (int i = 0; i < arrayOfString1.length; i++) {
          if (i == 0) {
            localStringBuffer.append("(" + arrayOfString1[i]);
          } else {
            localStringBuffer.append("," + arrayOfString1[i]);
          }
        }
        for (i = 0; i < arrayOfString1.length; i++) {
          this.evsVoucherHistoryDAO.addHistory(localEasUserInfo, 0L, arrayOfString1[i].toString(), EvsStatusUtil.getOperName("BOOKED"), "UNBOOK", "BOOKED");
        }
        if ((localStringBuffer != null) && (localStringBuffer.length() > 0)) {
          localStringBuffer.append(")");
        }
        this.evsVoucherGenerateDAO.saveVoucher(localStringBuffer.toString());
        this.ebookDAO.saveVoucherBookPackages(localEvsBook, paramEvsBookModel.getVoucherId());
        Map localMap;
        String[] arrayOfString2;
        if ((localEvsBook.getBeginNum() != null) && (localEvsBook.getEndNum() != null))
        {
          localMap = this.ebookDAO.getVoucherMaxMinJournalNum(paramEvsBookModel.getVoucherId());
          if (localMap.get("min").hashCode() < localEvsBook.getBeginNum().hashCode()) {
            localEvsBook.setBeginNum(localMap.get("min").toString());
          }
          if (localMap.get("max").hashCode() > localEvsBook.getEndNum().hashCode()) {
            localEvsBook.setEndNum(localMap.get("max").toString());
          }
          this.ebookDAO.update(localEvsBook);
          arrayOfString2 = new String[] { localEvsBook.getBeginNum(), localEvsBook.getEndNum() };
          localObject = this.ebookDAO.getJournalNumByVoucherId(paramEvsBookModel.getVoucherId());
        }
        else
        {
          localMap = this.ebookDAO.getVoucherMaxMinJournalNum(paramEvsBookModel.getVoucherId());
          localEvsBook.setBeginNum(localMap.get("min").toString());
          localEvsBook.setEndNum(localMap.get("max").toString());
          this.ebookDAO.update(localEvsBook);
          arrayOfString2 = new String[] { localEvsBook.getBeginNum(), localEvsBook.getEndNum() };
          localObject = this.ebookDAO.getJournalNumByVoucherId(paramEvsBookModel.getVoucherId());
        }
      }
    }
    return localObject;
  }
  
  public TableDataInfo getVoucherInfoByCode(EvsBookModel paramEvsBookModel, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    Object localObject = null;
    if ((paramEvsBookModel.getBookCode() != null) && (!paramEvsBookModel.getBookCode().equals("")))
    {
      Map localMap = this.ebookDAO.findEvsVoucherByNum(paramEvsBookModel, paramInt1, paramInt2);
      localTableDataInfo.setData((List)localMap.get("data"));
      localTableDataInfo.setTotalCount(Integer.parseInt(localMap.get("totalCount").toString()));
    }
    return localTableDataInfo;
  }
  
  public TableDataInfo getVoucherInfoByCodeForL(EvsBookModel paramEvsBookModel, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    Map localMap = null;
    EvsBook localEvsBook = this.ebookDAO.findBookById(Long.valueOf(paramEvsBookModel.getBookId()));
    if (null != localEvsBook)
    {
      localMap = this.ebookDAO.findFasciculeForL(localEvsBook, paramInt1, paramInt2);
      if (localMap != null)
      {
        localTableDataInfo.setData((List)localMap.get("data"));
        localTableDataInfo.setTotalCount(Integer.parseInt(localMap.get("totalCount").toString()));
        return localTableDataInfo;
      }
    }
    return localTableDataInfo;
  }
  
  public TableDataInfo getVoucherInfoByCodeForS(EvsBookModel paramEvsBookModel, int paramInt1, int paramInt2)
  {
    String str = "";
    List localList = this.ebookDAO.findBooksForL(paramEvsBookModel.getBookId());
    Object localObject1 = localList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (EvsVoucherBookPackage)((Iterator)localObject1).next();
      str = str + ((EvsVoucherBookPackage)localObject2).getVoucherId() + ",";
    }
    localObject1 = str.split(",");
    Object localObject2 = new TableDataInfo();
    Object localObject3 = null;
    Map localMap = null;
    localMap = this.ebookDAO.findFasciculeForLYB(null, (String[])localObject1, paramInt1, paramInt2);
    ((TableDataInfo)localObject2).setData((List)localMap.get("data"));
    ((TableDataInfo)localObject2).setTotalCount(Integer.parseInt(localMap.get("totalCount").toString()));
    return localObject2;
  }
  
  public EvsBook updateBookInfoForS(String paramString)
  {
    List localList = this.ebookDAO.findBooksForL(paramString);
    Object localObject = localList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      EvsVoucherBookPackage localEvsVoucherBookPackage = (EvsVoucherBookPackage)((Iterator)localObject).next();
      this.evsVoucherGenerateDAO.updateVoucherFlag(localEvsVoucherBookPackage.getVoucherId().longValue(), "N");
    }
    localObject = new EvsBook();
    localObject = this.ebookDAO.getBookById(paramString);
    return localObject;
  }
  
  public boolean updateBookVoucherInfoByCode(EvsBookModel paramEvsBookModel)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    boolean bool = false;
    if ((!"".equals(paramEvsBookModel.getBookId())) && (null != paramEvsBookModel.getBookId()))
    {
      List localList1 = this.ebookDAO.findBooksForL(paramEvsBookModel.getBookId());
      if (localList1.size() > 0) {
        this.ebookDAO.deleteVoucherBookPackages(localList1);
      }
      EvsBook localEvsBook = this.ebookDAO.findBookById(Long.valueOf(paramEvsBookModel.getBookId()));
      this.ebookDAO.updateEvsBook(localEvsBook);
      List localList2 = this.ebookDAO.findEvsVoucherForL(localEvsBook);
      Iterator localIterator = localList2.iterator();
      while (localIterator.hasNext())
      {
        EvsVoucher localEvsVoucher = (EvsVoucher)localIterator.next();
        this.evsVoucherHistoryDAO.addHistory(localEasUserInfo, 0L, localEvsVoucher.getVoucherId().toString(), EvsStatusUtil.getOperName("UNBOOK"), "BOOKED", "MATCHED");
        localEvsVoucher.setVoucherStatus("MATCHED");
        this.ebookDAO.updateEvsVoucher(localEvsVoucher);
      }
      this.evsVoucherHistoryDAO.addHistory(localEasUserInfo, 1L, paramEvsBookModel.getBookId(), EvsStatusUtil.getOperName("UNBOOK"), "UNBOOK", "UNBOOK");
      bool = true;
    }
    return bool;
  }
  
  public boolean updateBookVoucherInfoByCodeForS(EvsBookModel paramEvsBookModel)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    EvsBook localEvsBook = this.ebookDAO.findBookById(Long.valueOf(paramEvsBookModel.getBookId()));
    boolean bool = false;
    if ((!"".equals(paramEvsBookModel.getBookId())) && (null != paramEvsBookModel.getBookId()))
    {
      List localList1 = this.ebookDAO.findBooksForL(paramEvsBookModel.getBookId());
      ArrayList localArrayList = new ArrayList();
      EvsVoucher localEvsVoucher;
      for (int i = 0; i < localList1.size(); i++)
      {
        localEvsVoucher = this.ebookDAO.getVoucherForS(((EvsVoucherBookPackage)localList1.get(i)).getVoucherId());
        if (localEvsVoucher != null) {
          localArrayList.add(localEvsVoucher);
        }
      }
      if (localList1.size() > 0) {
        this.ebookDAO.deleteVoucherBookPackages(localList1);
      }
      this.ebookDAO.updateEvsBook(localEvsBook);
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        localEvsVoucher = (EvsVoucher)localIterator.next();
        this.evsVoucherHistoryDAO.addHistory(localEasUserInfo, 0L, localEvsVoucher.getVoucherId().toString(), EvsStatusUtil.getOperName("UNBOOK"), "BOOKED", "MATCHED");
        List localList2 = this.ebookDAO.checkVoucherForS(localEvsVoucher.getVoucherId());
        if (localList2.size() > 1)
        {
          localEvsVoucher.setVoucherStatus("BOOKED");
          this.ebookDAO.updateEvsVoucher(localEvsVoucher);
        }
        else
        {
          localEvsVoucher.setVoucherStatus("MATCHED");
          this.ebookDAO.updateEvsVoucher(localEvsVoucher);
        }
      }
      this.evsVoucherHistoryDAO.addHistory(localEasUserInfo, 1L, paramEvsBookModel.getBookId(), EvsStatusUtil.getOperName("UNBOOK"), "UNBOOK", "UNBOOK");
      bool = true;
    }
    return bool;
  }
  
  public boolean updateBookVoucherInfoByCodeForD(EvsBookModel paramEvsBookModel)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    boolean bool = false;
    if ((!"".equals(paramEvsBookModel.getBookId())) && (null != paramEvsBookModel.getBookId()))
    {
      List localList = this.ebookDAO.findBooksForL(paramEvsBookModel.getBookId());
      String str = "";
      if (localList.size() > 0)
      {
        localObject1 = localList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (EvsVoucherBookPackage)((Iterator)localObject1).next();
          str = str + ((EvsVoucherBookPackage)localObject2).getVoucherId() + ",";
        }
        this.ebookDAO.deleteVoucherBookPackages(localList);
      }
      Object localObject1 = this.ebookDAO.findBookById(Long.valueOf(paramEvsBookModel.getBookId()));
      this.ebookDAO.deleteEvsBook((EvsBook)localObject1);
      Object localObject2 = this.ebookDAO.findEvsVoucher(str, paramEvsBookModel);
      Iterator localIterator = ((List)localObject2).iterator();
      while (localIterator.hasNext())
      {
        EvsVoucher localEvsVoucher = (EvsVoucher)localIterator.next();
        localEvsVoucher.setVoucherStatus("MATCHED");
        this.ebookDAO.updateEvsVoucher(localEvsVoucher);
      }
      this.evsVoucherHistoryDAO.addHistory(localEasUserInfo, 1L, paramEvsBookModel.getBookId(), EvsStatusUtil.getOperName("UNBOOK"), "UNBOOK", "UNBOOK");
      bool = true;
    }
    return bool;
  }
  
  public TableDataInfo getVoucherHistoryByCode(EvsBookModel paramEvsBookModel, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    Object localObject = null;
    if ((paramEvsBookModel.getBookCode() != null) && (!paramEvsBookModel.getBookCode().equals("")))
    {
      Map localMap = this.ebookDAO.getVoucherHistoryByCode(paramEvsBookModel, paramInt1, paramInt2);
      localTableDataInfo.setData((List)localMap.get("data"));
      localTableDataInfo.setTotalCount(Integer.parseInt(localMap.get("totalCount").toString()));
      return localTableDataInfo;
    }
    return null;
  }
  
  public String isBreakNum(String[] paramArrayOfString)
  {
    String str = this.ebookDAO.isBreakNum(paramArrayOfString);
    if (!str.equals("")) {
      return str;
    }
    return null;
  }
  
  public String getGenerarionNmber(EvsBookModel paramEvsBookModel)
  {
    String str1 = "";
    String str2 = "select * from (select * from evs.evs_book b where book_Status = 'UNBOOK' and company_Code = ? and period_Name =? and archive_number <> ? order by book_Id) where rownum = 1";
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramEvsBookModel.getCompanyCode());
    localArrayList.add(paramEvsBookModel.getPeriodName());
    localArrayList.add(paramEvsBookModel.getArchiveNumber());
    IImageCommonDAO localIImageCommonDAO = (IImageCommonDAO)SSBBus.findDomainService("imageCommonDAO");
    EvsBook localEvsBook = (EvsBook)localIImageCommonDAO.findObject(str2, localArrayList, EvsBook.class);
    if (localEvsBook != null)
    {
      if (!StringUtils.isEmpty(localEvsBook.getBookCode())) {
        str1 = localEvsBook.getBookCode();
      }
      this.ebookDAO.deleteEvsBook(localEvsBook);
    }
    if ("".equals(str1))
    {
      if (!isFlag) {
        return null;
      }
      isFlag = false;
      paramEvsBookModel.setCompanyCode(paramEvsBookModel.getCompanyCode());
      paramEvsBookModel.setDeptCode("");
      paramEvsBookModel.setSubdoccode("");
      paramEvsBookModel.setPeriodDate("");
      paramEvsBookModel.setBoeTypeCode(paramEvsBookModel.getPeriodName());
      paramEvsBookModel.setUnitCode("EVS-BOOK");
      str1 = this.ebookDAO.getGenerarionNmber(paramEvsBookModel);
      isFlag = true;
    }
    return str1;
  }
  
  public String getGenerarionNmberYB(EvsVoucherSelect paramEvsVoucherSelect)
  {
    String str = "";
    if ("".equals(str))
    {
      if (!isFlag) {
        return null;
      }
      isFlag = false;
      paramEvsVoucherSelect.setCompanyCode(paramEvsVoucherSelect.getCompanyCode());
      paramEvsVoucherSelect.setDeptCode("");
      paramEvsVoucherSelect.setSubdoccode("");
      paramEvsVoucherSelect.setPeriodDate("");
      paramEvsVoucherSelect.setBoeTypeCode(paramEvsVoucherSelect.getPeriod_name());
      paramEvsVoucherSelect.setUnitCode("EVS-BOOK");
      str = this.ebookDAO.getGenerarionNmberYB(paramEvsVoucherSelect);
      isFlag = true;
    }
    return str;
  }
  
  public List getJournalNumByVoucherId(String paramString)
  {
    return this.ebookDAO.getJournalNumByVoucherId(paramString);
  }
  
  public String getBookTotal(EvsBookModel paramEvsBookModel)
  {
    return this.ebookDAO.getBookTotal(paramEvsBookModel);
  }
  
  public String isBreakNums(EvsBookModel paramEvsBookModel)
  {
    Object localObject1 = null;
    Object localObject2 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    String str1 = "N";
    if ((paramEvsBookModel.getBeginBookCode() != null) && (!"".equals(paramEvsBookModel.getBeginBookCode())) && (paramEvsBookModel.getEndBookCode() != null) && (!"".equals(paramEvsBookModel.getEndBookCode())))
    {
      String str2 = "select get_interval('" + paramEvsBookModel.getBeginBookCode() + "','" + paramEvsBookModel.getEndBookCode() + "','" + paramEvsBookModel.getCompanyCode() + "','" + paramEvsBookModel.getPeriodName() + "','" + paramEvsBookModel.getSubdoccode() + "') from dual ";
      try
      {
        localObject2 = this.ebookDAO.getLogicUserInfo(str2);
        if (((List)localObject2).size() > 0)
        {
          String str3 = null;
          for (int i = 0; i < ((List)localObject2).size(); i++) {
            str3 = (String)((List)localObject2).get(i);
          }
          if (str3 != null) {
            str1 = "Y";
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return str1;
  }
  
  public List<BookMenuModel> setSessionBookInfo(EvsBookV paramEvsBookV)
  {
    ArrayList localArrayList = new ArrayList();
    BookMenuModel localBookMenuModel1 = new BookMenuModel();
    localBookMenuModel1.setBookMenuId("1");
    localBookMenuModel1.setBookMenuName("<img src='../../../../images/tree/gobal.gif'/>装订序号");
    localBookMenuModel1.setChildrenCount("3");
    localBookMenuModel1.setFatherMenuId("0");
    localArrayList.add(localBookMenuModel1);
    String[] arrayOfString = paramEvsBookV.getBookCode().split(",");
    for (int i = 0; i < arrayOfString.length; i++)
    {
      BookMenuModel localBookMenuModel2 = new BookMenuModel();
      localBookMenuModel2.setBookMenuId(String.valueOf(i + 2));
      localBookMenuModel2.setBookMenuName(arrayOfString[i]);
      localBookMenuModel2.setChildrenCount("0");
      localBookMenuModel2.setFatherMenuId("1");
      localArrayList.add(localBookMenuModel2);
    }
    return localArrayList;
  }
  
  public List<String> getLogicUserInfo()
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    Object localObject = null;
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    String str1 = null;
    if (localEasUserInfo != null) {
      str1 = "select a.lookup_code, a.meaning , t.check_unit_name,t.erp_org_id ,t.check_unit  from fbp_check_unit_contents t,  fbp_organization_units  b,   fbp_lookup_values   a  where t.erp_org_id =" + localEasUserInfo.getOrgId() + " and a.lookup_type = 'EVS_SET_OF_BOOK' " + "   and  b.org_id= " + localEasUserInfo.getOrgId() + "  and a.lookup_code=b.set_of_books_name ";
    } else {
      str1 = "select a.lookup_code, a.meaning , t.check_unit_name,t.erp_org_id ,t.check_unit  from fbp_check_unit_contents t,  fbp_organization_units  b,   fbp_lookup_values   a  where t.erp_org_id = 82  and a.lookup_type = 'EVS_SET_OF_BOOK'    and  b.org_id=102   and a.lookup_code=b.set_of_books_name ";
    }
    List localList1 = this.ebookDAO.getLogicUserInfo(str1);
    ArrayList localArrayList = new ArrayList();
    Object[] arrayOfObject = null;
    if (localList1.size() > 0)
    {
      arrayOfObject = (Object[])localList1.get(0);
      for (int i = 0; i < arrayOfObject.length; i++) {
        localArrayList.add(arrayOfObject[i].toString());
      }
    }
    if (localEasUserInfo != null)
    {
      if (localEasUserInfo.getOrgId() != null) {
        localArrayList.add(String.valueOf(localEasUserInfo.getOrgId()));
      }
    }
    else {
      localArrayList.add("82");
    }
    String str2 = "select period_name ,to_char(start_date,'yymm') period_date,period_year from FBP_PERIODS t where period_type = '22'  and t.start_date <= to_date(to_char(add_months(sysdate, -1), 'yyyy-mm-dd'), 'yyyy-mm-dd')  and t.end_date >= to_date(to_char(add_months(sysdate, -1), 'yyyy-mm-dd'), 'yyyy-mm-dd')";
    List localList2 = this.ebookDAO.getLogicUserInfo(str2);
    if ((localList2 != null) && (localList2.size() > 0))
    {
      arrayOfObject = (Object[])localList2.get(0);
      if ((arrayOfObject != null) && (!"".equals(arrayOfObject)))
      {
        localArrayList.add(arrayOfObject[0].toString());
        localArrayList.add(arrayOfObject[1].toString());
        localArrayList.add(arrayOfObject[2].toString());
      }
    }
    return localArrayList;
  }
  
  public List<String> getNextNum(List<EvsBookModel> paramList)
  {
    EvsBookModel localEvsBookModel = (EvsBookModel)paramList.get(0);
    String str = null;
    Object localObject = new ArrayList();
    if (localEvsBookModel != null)
    {
      str = localEvsBookModel.getEndBookCode();
      localObject = this.ebookDAO.getNextJournalNum(localEvsBookModel);
    }
    return localObject;
  }
  
  public boolean isVoucherByParam(EvsBookModel paramEvsBookModel)
  {
    Object localObject = new ArrayList();
    String str1 = null;
    boolean bool = false;
    try
    {
      str1 = " select voucher_Id from Evs_Voucher  where 1=1 and journal_Num is not null  and journal_Num = '";
      if ((paramEvsBookModel.getBeginBookCode() != null) && (!"".equals(paramEvsBookModel.getBeginBookCode())) && ("1".equals(paramEvsBookModel.getIsFlag()))) {
        str1 = str1 + paramEvsBookModel.getBeginBookCode();
      } else if ((paramEvsBookModel.getEndBookCode() != null) && (!"".equals(paramEvsBookModel.getEndBookCode())) && ("2".equals(paramEvsBookModel.getIsFlag()))) {
        str1 = str1 + paramEvsBookModel.getEndBookCode();
      }
      str1 = str1 + "' and voucher_Status in ('UNBOOK','CHECKED') AND ou_Name ='";
      if ((paramEvsBookModel.getCompanyCode() != null) && (!"".equals(paramEvsBookModel.getCompanyCode()))) {
        str1 = str1 + paramEvsBookModel.getCompanyCode();
      }
      str1 = str1 + "'  AND ou_Id ='";
      if ((paramEvsBookModel.getBookPeople() != null) && (!"".equals(paramEvsBookModel.getBookPeople()))) {
        str1 = str1 + paramEvsBookModel.getBookPeople();
      }
      str1 = str1 + "'  AND period_Name ='";
      if ((paramEvsBookModel.getPeriodName() != null) && (!"".equals(paramEvsBookModel.getPeriodName()))) {
        str1 = str1 + paramEvsBookModel.getPeriodName();
      }
      str1 = str1 + "' and  instr((select voucher_Type from Evs_Sub_Doc_Type   where sub_Doc_Name='";
      if ((paramEvsBookModel.getSubdocname() != null) && (!"".equals(paramEvsBookModel.getSubdocname()))) {
        str1 = str1 + paramEvsBookModel.getSubdocname();
      }
      str1 = str1 + "' and rownum=1 ),invoice_Type)>0  order by voucher_Id";
      localObject = this.ebookDAO.isVoucherByParam(str1);
      if (((List)localObject).size() == 0)
      {
        String str2;
        if ((paramEvsBookModel.getBeginBookCode() != null) && (!"".equals(paramEvsBookModel.getBeginBookCode())) && ("1".equals(paramEvsBookModel.getIsFlag())))
        {
          str2 = "select count(*) from evs_book t where 1=1 and t.end_num='" + paramEvsBookModel.getBeginBookCode() + "'" + " and t.begin_num != '" + paramEvsBookModel.getBeginBookCode() + "'";
          localObject = this.ebookDAO.isVoucherByParam(str2);
          if (((List)localObject).size() == 1) {
            bool = true;
          }
          if (((List)localObject).size() == 0) {
            bool = true;
          }
        }
        if ((paramEvsBookModel.getEndBookCode() != null) && (!"".equals(paramEvsBookModel.getEndBookCode())) && ("2".equals(paramEvsBookModel.getIsFlag())))
        {
          str2 = "select count(*) from evs_book t where 1=1 and t.begin_num='" + paramEvsBookModel.getEndBookCode() + "'" + " and t.end_num != '" + paramEvsBookModel.getEndBookCode() + "'";
          localObject = this.ebookDAO.isVoucherByParam(str2);
          if (((List)localObject).size() == 1) {
            bool = true;
          }
          if (((List)localObject).size() == 0) {
            bool = true;
          }
        }
      }
      else if (((List)localObject).size() > 0)
      {
        bool = true;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return bool;
  }
  
  public List<String> lookBreakNums(EvsBookModel paramEvsBookModel)
  {
    Object localObject = new ArrayList();
    try
    {
      localObject = this.ebookDAO.lookBreakNums(paramEvsBookModel);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localObject;
  }
  
  public List<String> getBreakNum(EvsBookModel paramEvsBookModel)
  {
    Object localObject = new ArrayList();
    try
    {
      localObject = this.ebookDAO.getBreakNum(paramEvsBookModel);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localObject;
  }
  
  public List<String> getBreakNums(EvsBookV paramEvsBookV)
  {
    Object localObject = new ArrayList();
    try
    {
      localObject = this.ebookDAO.getBreakNums(paramEvsBookV);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localObject;
  }
  
  public List insertVoucher(EvsBookModel paramEvsBookModel)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    Object localObject = new ArrayList();
    if (paramEvsBookModel != null)
    {
      localObject = updateHeaderInfo(paramEvsBookModel);
      if ((((List)localObject).size() > 0) && (paramEvsBookModel.getBookCode() != null) && (!"".equals(paramEvsBookModel.getBookCode())))
      {
        EvsBook localEvsBook = this.ebookDAO.getBookByCode(paramEvsBookModel.getBookCode());
        localEvsBook.setBookStatus("BOOKED");
        if ((localEvsBook.getBeginNum() != null) && (!"".equals(localEvsBook.getBeginNum())) && (localEvsBook.getEndNum() != null) && (!"".equals(localEvsBook.getEndNum())))
        {
          String str1 = " select get_book_interval('" + localEvsBook.getBeginNum() + "','" + localEvsBook.getEndNum() + "','" + localEvsBook.getCompanyCode() + "','" + localEvsBook.getPeriodName() + "','" + localEvsBook.getInvoiceType() + "','" + localEvsBook.getBookId() + "') from dual ";
          List localList = this.ebookDAO.getLogicUserInfo(str1);
          if (localList.size() > 0)
          {
            String str2 = null;
            for (int i = 0; i < localList.size(); i++) {
              str2 = (String)localList.get(i);
            }
            if (str2 != null) {
              localEvsBook.setBookBreakFlag("Y");
            } else {
              localEvsBook.setBookBreakFlag("N");
            }
          }
        }
        localEvsBook.setBookCount(Long.valueOf(paramEvsBookModel.getBookCount()));
        localEvsBook.setBookSum(Long.valueOf(paramEvsBookModel.getBookSum()));
        this.ebookDAO.update(localEvsBook);
        ObjectCopyUtils.setWho(localEvsBook);
        this.evsVoucherHistoryDAO.addHistory(localEasUserInfo, 1L, localEvsBook.getBookId().toString(), EvsStatusUtil.getOperName("BOOKED"), "BOOKED", "BOOKED");
        localObject = this.ebookDAO.getJournalNumByVoucherId(paramEvsBookModel.getVoucherId());
      }
    }
    return localObject;
  }
  
  public IEvsVoucherGenerateDAO getEvsVoucherGenerateDAO()
  {
    return this.evsVoucherGenerateDAO;
  }
  
  public void setEvsVoucherGenerateDAO(IEvsVoucherGenerateDAO paramIEvsVoucherGenerateDAO)
  {
    this.evsVoucherGenerateDAO = paramIEvsVoucherGenerateDAO;
  }
  
  public String getSysTime()
  {
    String str1 = null;
    String str2 = "select to_char(add_months(sysdate,-6),'yyyy-MM-dd') from dual";
    try
    {
      List localList = this.ebookDAO.getLogicUserInfo(str2);
      str1 = localList.get(0).toString();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return str1;
  }
  
  public String findVoucherByIsVoucherStatus(String paramString)
  {
    if (paramString != null) {
      return this.ebookDAO.findVoucherByIsVoucherStatus(paramString);
    }
    return null;
  }
  
  public boolean isVoucherCodeByBook(EvsBookModel paramEvsBookModel)
  {
    String str = null;
    List localList = null;
    boolean bool = true;
    if (paramEvsBookModel != null)
    {
      if ((paramEvsBookModel.getIsFlag().equals("start")) && (paramEvsBookModel.getBeginBookCode() != null) && (!"".equals(paramEvsBookModel.getBeginBookCode())))
      {
        str = " select * from evs_book t where t.begin_num!=t.end_num and t.begin_num= '" + paramEvsBookModel.getBeginBookCode() + "' and rownum=1 ";
        localList = this.ebookDAO.getLogicUserInfo(str);
      }
      else if ((paramEvsBookModel.getIsFlag().equals("end")) && (paramEvsBookModel.getEndBookCode() != null) && (!"".equals(paramEvsBookModel.getEndBookCode())))
      {
        str = " select * from evs_book t where t.begin_num!=t.end_num and t.end_num= '" + paramEvsBookModel.getEndBookCode() + "' and rownum=1 ";
        localList = this.ebookDAO.getLogicUserInfo(str);
      }
      if (localList.size() == 0) {
        bool = false;
      }
    }
    return bool;
  }
  
  public TableDataInfo getStatistic(EvsBookStatisticV paramEvsBookStatisticV, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    Map localMap = null;
    localMap = this.ebookDAO.findQueryBookStatistic(paramEvsBookStatisticV, paramInt1, paramInt2);
    if (localMap != null)
    {
      localTableDataInfo.setData((List)localMap.get("data"));
      localTableDataInfo.setTotalCount(Integer.parseInt(localMap.get("totalCount").toString()));
    }
    return localTableDataInfo;
  }
  
  public TableDataInfo getEvsBooks2(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    TableDataInfo localTableDataInfo = new TableDataInfo();
    EvsBook localEvsBook = null;
    ArrayList localArrayList = new ArrayList();
    FasciculeTreeV localFasciculeTreeV = null;
    localFasciculeTreeV = this.efasciculeQueryDAO.findFasciculeTreeVById(paramString1);
    String str1 = null;
    Object localObject1 = null;
    String str2 = localFasciculeTreeV.getYea().toString();
    String str3 = localFasciculeTreeV.getMon();
    if (str2 != null) {
      str1 = str2.substring(2);
    }
    if (str3 != null) {
      localObject1 = str3;
    }
    if (((String)localObject1).equals("01")) {
      localObject1 = "JAN";
    }
    if (((String)localObject1).equals("02")) {
      localObject1 = "FEB";
    }
    if (((String)localObject1).equals("03")) {
      localObject1 = "MAR";
    }
    if (((String)localObject1).equals("04")) {
      localObject1 = "APR";
    }
    if (((String)localObject1).equals("05")) {
      localObject1 = "MAY";
    }
    if (((String)localObject1).equals("06")) {
      localObject1 = "JUN";
    }
    if (((String)localObject1).equals("07")) {
      localObject1 = "JUL";
    }
    if (((String)localObject1).equals("08")) {
      localObject1 = "AGU";
    }
    if (((String)localObject1).equals("09")) {
      localObject1 = "SEP";
    }
    if (((String)localObject1).equals("10")) {
      localObject1 = "OCT";
    }
    if (((String)localObject1).equals("11")) {
      localObject1 = "NOV";
    }
    if (((String)localObject1).equals("12")) {
      localObject1 = "DEC";
    }
    String str4 = (String)localObject1 + "-" + str1;
    Object localObject2 = null;
    String str5 = this.efasciculeQueryDAO.findFasciculeTreeVByCheckunit(localFasciculeTreeV.getCheckunit()).toString();
    if (str5 != null) {
      localObject2 = str5;
    }
    PageInfo localPageInfo = this.ebookDAO.findEvsBookBySubDocName(paramString2, localObject2, str4, paramInt1, paramInt2);
    Iterator localIterator = ((List)localPageInfo.getResult()).iterator();
    while (localIterator.hasNext())
    {
      Object[] arrayOfObject = (Object[])localIterator.next();
      if (arrayOfObject != null)
      {
        localEvsBook = new EvsBook();
        if (arrayOfObject[0] != null) {
          localEvsBook.setBookId(Long.valueOf(Long.parseLong(arrayOfObject[0].toString())));
        }
        if (arrayOfObject[1] != null) {
          localEvsBook.setBookCode(arrayOfObject[1].toString());
        }
        if (arrayOfObject[2] != null) {
          localEvsBook.setArchiveNumber(arrayOfObject[2].toString());
        }
        if (arrayOfObject[3] != null) {
          localEvsBook.setBeginNum(arrayOfObject[3].toString());
        }
        if (arrayOfObject[4] != null) {
          localEvsBook.setEndNum(arrayOfObject[4].toString());
        }
        if (arrayOfObject[5] != null) {
          try
          {
            localEvsBook.setBookDate(localSimpleDateFormat.parse(arrayOfObject[5].toString()));
          }
          catch (ParseException localParseException)
          {
            localParseException.printStackTrace();
          }
        }
        if (arrayOfObject[6] != null) {
          localEvsBook.setBookBreakFlag(arrayOfObject[6].toString());
        }
        if (arrayOfObject[7] != null) {
          localEvsBook.setBookStatus(arrayOfObject[7].toString());
        }
        localArrayList.add(localEvsBook);
      }
    }
    localTableDataInfo.setData(localArrayList);
    localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
    return localTableDataInfo;
  }
  
  public Long save()
  {
    String str = "C999999999999";
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    EvsBook localEvsBook = this.ebookDAO.getBookByCodeAndEmployee(str, localEasUserInfo.getUserInfoPk().toString());
    if (localEvsBook == null)
    {
      localEvsBook = new EvsBook();
      localEvsBook.setBookCode(str);
      if (localEasUserInfo != null)
      {
        if ((localEasUserInfo.getUserInfoPk() != null) && (!"".equals(localEasUserInfo.getUserInfoPk())))
        {
          System.out.println("~~~~~~~~~~~获取当前用户信息~~~~~~~~~~~~~");
          localEvsBook.setBookEmployeeId(Long.valueOf(localEasUserInfo.getUserInfoPk().toString()));
          localEvsBook.setCreatedBy(Long.valueOf(localEasUserInfo.getUserInfoPk().toString()));
          localEvsBook.setLastUpdateBy(Long.valueOf(localEasUserInfo.getUserInfoPk().toString()));
          localEvsBook.setLastUpdateLogin(Long.valueOf(localEasUserInfo.getUserInfoPk().toString()));
        }
      }
      else
      {
        localEvsBook.setBookEmployeeId(Long.valueOf("82".toString()));
        localEvsBook.setCreatedBy(Long.valueOf("82".toString()));
        localEvsBook.setLastUpdateBy(Long.valueOf("82".toString()));
        localEvsBook.setLastUpdateLogin(Long.valueOf("82".toString()));
      }
      this.ebookDAO.save(localEvsBook);
    }
    else
    {
      localEvsBook.setCreationDate(new Date());
      localEvsBook.setLastUpdateDate(new Date());
      this.ebookDAO.update(localEvsBook);
    }
    localEvsBook = this.ebookDAO.getBookByCodeAndEmployee(str, localEasUserInfo.getUserInfoPk().toString());
    return localEvsBook.getBookId();
  }
  
  public void deltempFence(String paramString1, String paramString2, String paramString3)
  {
    if ("EVSBOOK".equals(paramString3)) {
      this.ebookDAO.deltempFence(paramString1);
    }
    String[] arrayOfString1 = paramString2.split(",");
    for (String str : arrayOfString1)
    {
      this.ebookDAO.deleteVoucherBookPackage(paramString1, str);
      this.ebookDAO.updateVoucherStatus("CHECKED_NO_BOOKED", str);
    }
  }
  
  public void deleteVoucherByBook(String paramString)
  {
    paramString = "C999999999999";
    this.ebookDAO.deleteVoucherByBook(paramString);
  }
  
  public void vouAddFence(String paramString1, String paramString2)
  {
    EvsBook localEvsBook = new EvsBook();
    localEvsBook.setBookId(Long.valueOf(paramString1));
    this.ebookDAO.saveVoucherBookPackages(localEvsBook, paramString2);
  }
  
  public String updateVoucher(EvsBookModel paramEvsBookModel)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    String str1 = "";
    String str2 = paramEvsBookModel.getBookId();
    EvsBook localEvsBook = this.ebookDAO.findBookById(Long.valueOf(str2));
    localEvsBook.setBookStatus("BOOKED");
    this.ebookDAO.update(localEvsBook);
    List localList = this.ebookDAO.findEvsVoucherBookPackageForD(Long.valueOf(str2));
    String str3 = "";
    if (localList.size() > 0)
    {
      this.ebookDAO.deleteVoucherBookPackages(localList);
      localObject1 = localList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (EvsVoucherBookPackage)((Iterator)localObject1).next();
        str3 = str3 + ((EvsVoucherBookPackage)localObject2).getVoucherId() + ",";
      }
      localObject1 = this.ebookDAO.findEvsVoucher(str3, paramEvsBookModel);
      localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (EvsVoucher)((Iterator)localObject2).next();
        ((EvsVoucher)localObject3).setVoucherStatus("MATCHED");
        this.ebookDAO.updateEvsVoucher((EvsVoucher)localObject3);
      }
    }
    Object localObject1 = this.ebookDAO.findEvsVoucherBookPackage(Long.valueOf(str2));
    Object localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (EvsVoucherBookPackage)((Iterator)localObject2).next();
      str1 = str1 + ((EvsVoucherBookPackage)localObject3).getVoucherId() + ",";
      ((EvsVoucherBookPackage)localObject3).setEnabledFlag("Y");
      this.ebookDAO.updateObject(localObject3);
    }
    localObject2 = this.ebookDAO.findEvsVoucher(str1, paramEvsBookModel);
    Object localObject3 = ((List)localObject2).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      EvsVoucher localEvsVoucher = (EvsVoucher)((Iterator)localObject3).next();
      localEvsVoucher.setVoucherStatus("BOOKED");
      this.ebookDAO.updateEvsVoucher(localEvsVoucher);
    }
    this.evsVoucherHistoryDAO.addHistory(localEasUserInfo, 1L, str2.toString(), EvsStatusUtil.getOperName("BOOKED"), "BOOKED", "BOOKED");
    return "true";
  }
  
  public String updateVoucherForL(EvsBookModel paramEvsBookModel)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    String str1 = "";
    String str2 = paramEvsBookModel.getBookId();
    EvsBook localEvsBook = this.ebookDAO.findBookById(Long.valueOf(str2));
    localEvsBook.setBookStatus("BOOKED");
    this.ebookDAO.update(localEvsBook);
    List localList = this.ebookDAO.findEvsVoucherBookPackageForD(Long.valueOf(str2));
    String str3 = "";
    if (localList.size() > 0)
    {
      localObject1 = localList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (EvsVoucherBookPackage)((Iterator)localObject1).next();
        str3 = str3 + ((EvsVoucherBookPackage)localObject2).getVoucherId() + ",";
      }
      this.ebookDAO.deleteVoucherBookPackages(localList);
      localObject1 = this.ebookDAO.findEvsVoucher(str3, paramEvsBookModel);
      localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (EvsVoucher)((Iterator)localObject2).next();
        ((EvsVoucher)localObject3).setVoucherStatus("MATCHED");
        this.ebookDAO.updateEvsVoucher((EvsVoucher)localObject3);
      }
    }
    Object localObject1 = this.ebookDAO.findEvsVoucherBookPackage(Long.valueOf(str2));
    Object localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (EvsVoucherBookPackage)((Iterator)localObject2).next();
      ((EvsVoucherBookPackage)localObject3).setEnabledFlag("N");
      this.ebookDAO.updateObject(localObject3);
    }
    localObject2 = this.ebookDAO.findEvsVoucherForL(localEvsBook);
    Object localObject3 = ((List)localObject2).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      EvsVoucher localEvsVoucher = (EvsVoucher)((Iterator)localObject3).next();
      localEvsVoucher.setVoucherStatus("BOOKED");
      this.ebookDAO.updateEvsVoucher(localEvsVoucher);
    }
    this.evsVoucherHistoryDAO.addHistory(localEasUserInfo, 1L, str2.toString(), EvsStatusUtil.getOperName("BOOKED"), "BOOKED", "BOOKED");
    return "true";
  }
  
  public String updateVoucherForL2(EvsBookModel paramEvsBookModel)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    String str1 = "";
    String str2 = paramEvsBookModel.getArchiveNumber();
    List localList1 = this.ebookDAO.findBookByArchiveNumber(str2);
    for (int i = 0; i < localList1.size(); i++)
    {
      EvsBook localEvsBook = (EvsBook)localList1.get(i);
      EvsBookModel localEvsBookModel = new EvsBookModel();
      localEvsBookModel.setArchiveNumber(localEvsBook.getArchiveNumber());
      localEvsBookModel.setBeginNum(localEvsBook.getBeginNum());
      localEvsBookModel.setEndNum(localEvsBook.getEndNum());
      localEvsBookModel.setCompanyCode(localEvsBook.getCompanyCode());
      localEvsBookModel.setCreationDate(localEvsBook.getCreationDate());
      localEvsBookModel.setInvoiceType(localEvsBook.getInvoiceType());
      localEvsBookModel.setBookCount(localEvsBook.getBookCount() == null ? null : localEvsBook.getBookCount().toString());
      localEvsBookModel.setBookSum(localEvsBook.getBookSum() == null ? null : localEvsBook.getBookSum().toString());
      localEvsBookModel.setPeriodName(localEvsBook.getPeriodName());
      String str3 = getGenerarionNmber(localEvsBookModel);
      Long localLong = localEvsBook.getBookId();
      localEvsBook.setBookStatus("BOOKED");
      localEvsBook.setBookCode(str3);
      this.ebookDAO.update(localEvsBook);
      List localList2 = this.ebookDAO.findEvsVoucherBookPackageForD(localLong);
      String str4 = "";
      if (localList2.size() > 0)
      {
        localObject1 = localList2.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (EvsVoucherBookPackage)((Iterator)localObject1).next();
          str4 = str4 + ((EvsVoucherBookPackage)localObject2).getVoucherId() + ",";
        }
        this.ebookDAO.deleteVoucherBookPackages(localList2);
        localObject1 = this.ebookDAO.findEvsVoucher(str4, paramEvsBookModel);
        localObject2 = ((List)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (EvsVoucher)((Iterator)localObject2).next();
          ((EvsVoucher)localObject3).setVoucherStatus("MATCHED");
          this.ebookDAO.updateEvsVoucher((EvsVoucher)localObject3);
        }
      }
      Object localObject1 = this.ebookDAO.findEvsVoucherBookPackage(localLong);
      Object localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (EvsVoucherBookPackage)((Iterator)localObject2).next();
        ((EvsVoucherBookPackage)localObject3).setEnabledFlag("Y");
        this.ebookDAO.updateObject(localObject3);
      }
      localObject2 = this.ebookDAO.findEvsVoucherForL(localEvsBook);
      Object localObject3 = ((List)localObject2).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        EvsVoucher localEvsVoucher = (EvsVoucher)((Iterator)localObject3).next();
        this.evsVoucherHistoryDAO.addHistory(localEasUserInfo, 0L, localEvsVoucher.getVoucherId().toString(), EvsStatusUtil.getOperName("BOOKED"), "MATCHED", "BOOKED");
        localEvsVoucher.setVoucherStatus("BOOKED");
        this.ebookDAO.updateEvsVoucher(localEvsVoucher);
      }
      this.evsVoucherHistoryDAO.addHistory(localEasUserInfo, 1L, localLong.toString(), EvsStatusUtil.getOperName("BOOKED"), "BOOKED", "BOOKED");
    }
    return str2;
  }
  
  public String updateVoucherForYB2(EvsVoucherSelect paramEvsVoucherSelect)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    String str1 = "";
    String str2 = paramEvsVoucherSelect.getArchiveNumber();
    List localList1 = this.ebookDAO.findBookByArchiveNumber(str2);
    for (int i = 0; i < localList1.size(); i++)
    {
      EvsBook localEvsBook = (EvsBook)localList1.get(i);
      Long localLong = localEvsBook.getBookId();
      localEvsBook.setBookStatus("BOOKED");
      this.ebookDAO.update(localEvsBook);
      List localList2 = this.ebookDAO.findEvsVoucherBookPackage(localLong);
      IEvsVoucherDAO localIEvsVoucherDAO = (IEvsVoucherDAO)SSBBus.findDomainService("evsVoucherDAO");
      Iterator localIterator = localList2.iterator();
      while (localIterator.hasNext())
      {
        EvsVoucherBookPackage localEvsVoucherBookPackage = (EvsVoucherBookPackage)localIterator.next();
        localEvsVoucherBookPackage.setEnabledFlag("Y");
        this.ebookDAO.updateObject(localEvsVoucherBookPackage);
        EvsVoucher localEvsVoucher = localIEvsVoucherDAO.findEvsVoucherVByVoucherId(localEvsVoucherBookPackage.getVoucherId());
        this.evsVoucherHistoryDAO.addHistory(localEasUserInfo, 0L, localEvsVoucher.getVoucherId().toString(), EvsStatusUtil.getOperName("BOOKED"), "MATCHED", "BOOKED");
        localEvsVoucher.setVoucherStatus("BOOKED");
        localEvsVoucher.setAddVoucherFlag("N");
        this.ebookDAO.updateEvsVoucher(localEvsVoucher);
      }
      this.evsVoucherHistoryDAO.addHistory(localEasUserInfo, 1L, localLong.toString(), EvsStatusUtil.getOperName("BOOKED"), "BOOKED", "BOOKED");
    }
    return str2;
  }
  
  public List getBookByArchiveNumber(String paramString)
  {
    List localList = this.ebookDAO.findBookVByArchiveNumber(paramString);
    return localList;
  }
  
  public List findVouchersList(String paramString)
  {
    List localList = this.ebookDAO.findVouchersList(paramString);
    return localList;
  }
  
  public String deleteTempVoucher(EvsBookModel paramEvsBookModel)
  {
    List localList = this.ebookDAO.findEvsVoucherBookPackageForD(Long.valueOf(paramEvsBookModel.getBookId()));
    if (localList.size() > 0)
    {
      localObject1 = localList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (EvsVoucherBookPackage)((Iterator)localObject1).next();
        ((EvsVoucherBookPackage)localObject2).setEnabledFlag("Y");
      }
      this.ebookDAO.updateObjects(localList);
    }
    Object localObject1 = this.ebookDAO.findEvsVoucherBookPackage(Long.valueOf(paramEvsBookModel.getBookId()));
    if (((List)localObject1).size() > 0) {
      this.ebookDAO.deleteVoucherBookPackages((List)localObject1);
    }
    Object localObject2 = this.ebookDAO.findBookById(Long.valueOf(paramEvsBookModel.getBookId()));
    if (null != localObject2)
    {
      ((EvsBook)localObject2).setBookStatus("BOOKED");
      this.ebookDAO.updateObject(localObject2);
    }
    return "true";
  }
  
  public String checkVoucherNumIsD(EvsBookModel paramEvsBookModel, List<EvsBookModel> paramList)
  {
    String str1 = "true";
    for (int i = 0; i < paramList.size(); i++)
    {
      String str2 = this.ebookDAO.isBreakNumForL(paramEvsBookModel, (EvsBookModel)paramList.get(i));
      if (str2 == "fail")
      {
        str1 = "第" + (i + 1) + "行,起止凭证编号存在断号！";
        return str1;
      }
    }
    return str1;
  }
  
  public EFasciculeTreeVDAO getEfasciculeQueryDAO()
  {
    return this.efasciculeQueryDAO;
  }
  
  public void setEfasciculeQueryDAO(EFasciculeTreeVDAO paramEFasciculeTreeVDAO)
  {
    this.efasciculeQueryDAO = paramEFasciculeTreeVDAO;
  }
  
  public EidObjectUtils getObjectUtils()
  {
    return this.objectUtils;
  }
  
  public void setObjectUtils(EidObjectUtils paramEidObjectUtils)
  {
    this.objectUtils = paramEidObjectUtils;
  }
  
  public List<EvsBookV> getEvsBookVByBookCode(String paramString)
  {
    String str1 = "";
    Object localObject = new ArrayList();
    if ((paramString != null) && (!paramString.equals(""))) {
      if (paramString.indexOf("%") > 0)
      {
        for (int i = 0; i < paramString.split("%").length; i++)
        {
          String str2 = paramString.split("%")[i].toString();
          if (i == paramString.split("%").length - 1) {
            str1 = str1 + "'" + str2 + "'";
          } else {
            str1 = str1 + "'" + str2 + "',";
          }
        }
        localObject = this.ebookDAO.getEvsBookVByBookCodes(str1);
      }
      else
      {
        localObject = this.ebookDAO.getEvsBookVByBookCode("'" + paramString + "'");
      }
    }
    return localObject;
  }
  
  public List<String> checkBookExists(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = this.ebookDAO.findEvsVoucherBookPackageForYB(Long.valueOf(paramLong));
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      EvsVoucherBookPackage localEvsVoucherBookPackage = (EvsVoucherBookPackage)localIterator.next();
      EvsVoucherV localEvsVoucherV = this.evsVoucherGenerateDAO.queryEvsVoucherList(localEvsVoucherBookPackage.getVoucherId().longValue());
      if (localEvsVoucherV.getVoucherStatus().equals("BOOKED")) {
        localArrayList.add("CHECK_MESSAGE凭证类型:" + localEvsVoucherV.getInvoiceType() + localEvsVoucherV.getJournalNum() + "已被分册过");
      }
    }
    return localArrayList;
  }
  
  public List<String> checkBookExistsByVoucherId(String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < paramArrayOfString.length; i++)
    {
      Long localLong = Long.valueOf(Long.parseLong(paramArrayOfString[i]));
      List localList = this.ebookDAO.findEvsVoucherBookPackageForYBByVouId(localLong);
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        EvsVoucherBookPackage localEvsVoucherBookPackage = (EvsVoucherBookPackage)localIterator.next();
        EvsVoucherV localEvsVoucherV = this.evsVoucherGenerateDAO.queryEvsVoucherList(localEvsVoucherBookPackage.getVoucherId().longValue());
        if (localEvsVoucherV.getVoucherStatus().equals("BOOKED"))
        {
          localArrayList.add("CHECK_MESSAGE凭证类型:" + localEvsVoucherV.getInvoiceType() + localEvsVoucherV.getJournalNum() + "已被分册过");
          break;
        }
      }
    }
    return localArrayList;
  }
  
  public String checkComPeriod(String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList();
    String str1 = "";
    String str2 = "";
    if (paramArrayOfString.length == 0) {
      return "WITHDATA";
    }
    for (int i = 0; i < paramArrayOfString.length; i++)
    {
      long l = Long.valueOf(paramArrayOfString[i]).longValue();
      if (paramArrayOfString.length == 1) {
        return "SUCCESS";
      }
      EvsVoucherV localEvsVoucherV = this.evsVoucherGenerateDAO.queryEvsVoucherList(l);
      if (i == 0)
      {
        str1 = localEvsVoucherV.getCompanyCode();
        str2 = localEvsVoucherV.getPeriodName();
      }
      if ((!str1.equals(localEvsVoucherV.getCompanyCode())) || (!str2.equals(str2))) {
        return "UNSUCCESS";
      }
    }
    return "SUCCESS";
  }
  
  public String findEvsVoucherVByJournalNum(Long paramLong)
  {
    String str = "";
    IEvsVoucherDAO localIEvsVoucherDAO = (IEvsVoucherDAO)SSBBus.findDomainService("evsVoucherDAO");
    if ((paramLong != null) && (!paramLong.toString().equals("")))
    {
      List localList = localIEvsVoucherDAO.findEvsVoucherVByJournalNum(paramLong);
      for (int i = 0; i < localList.size(); i++)
      {
        EvsVoucherV localEvsVoucherV = null;
        if (i == 0)
        {
          localEvsVoucherV = (EvsVoucherV)localList.get(i);
          str = str + localEvsVoucherV.getInvoiceType();
        }
        if (i == localList.size() - 1)
        {
          str = str + ",";
          localEvsVoucherV = (EvsVoucherV)localList.get(i);
          str = str + localEvsVoucherV.getInvoiceType();
        }
      }
    }
    return str;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.eBillManage.EvsBookService
 * JD-Core Version:    0.7.0.1
 */