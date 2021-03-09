package com.zte.evs.ebill.business.eBillManage;

import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.eas.organization.access.countcompanymanage.IFbpCompanyVDAO;
import com.zte.eas.organization.business.countcompanymanage.model.FbpCompanyV;
import com.zte.eas.resconfig.business.periods.model.FbpPeriods;
import com.zte.evs.ebill.access.eBillManage.EvsBookDAO;
import com.zte.evs.ebill.access.eBillManage.EvsVoucherCheckFindDAO;
import com.zte.evs.ebill.access.eBillManage.IEvsPackageDAO;
import com.zte.evs.ebill.access.eBillManage.IEvsVoucherDAO;
import com.zte.evs.ebill.access.eBillManage.IEvsVoucherGenerateDAO;
import com.zte.evs.ebill.access.eBillManage.IEvsVoucherHistoryDAO;
import com.zte.evs.ebill.access.eBillManage.IEvsWarehouseDAO;
import com.zte.evs.ebill.common.EvsObjectUtils;
import com.zte.evs.ebill.common.EvsStatusUtil;
import com.zte.evs.ebill.common.ObjectCopyUtils;
import com.zte.evs.ebill.common.invoice.util.StringUtils;
import com.zte.evs.ebill.model.eBillManage.EvsBook;
import com.zte.evs.ebill.model.eBillManage.EvsBookModel;
import com.zte.evs.ebill.model.eBillManage.EvsBookV;
import com.zte.evs.ebill.model.eBillManage.EvsImage;
import com.zte.evs.ebill.model.eBillManage.EvsPackage;
import com.zte.evs.ebill.model.eBillManage.EvsPackageModel;
import com.zte.evs.ebill.model.eBillManage.EvsPackageV;
import com.zte.evs.ebill.model.eBillManage.EvsVoucher;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherBookPackage;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherV;
import com.zte.evs.ebill.model.eBillManage.EvsWarehouse;
import com.zte.evs.ebill.model.eBillManage.ReturnMessage;
import com.zte.ssb.AccessPropertiesFile;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.util.Util;
import java.io.PrintStream;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class EvsPackageService
  implements IEvsPackageService
{
  private IEvsVoucherDAO evsVoucherDAO;
  private IEvsPackageDAO packageDAO;
  private IEvsVoucherHistoryDAO evsVoucherHistoryDAO;
  private EvsVoucherCheckFindDAO evsVoucherCheckFindDAO;
  private IEvsVoucherGenerateDAO evsVoucherGenerateDAO;
  private IEvsWarehouseDAO warehouseDAO;
  private IFbpCompanyVDAO fbpCompanyVDAO;
  private static final Log log = LogFactory.getLog(EvsPackageService.class);
  private String str = "";
  private String pageMessage = null;
  private String tempMessage = null;
  private static final String USERID = "USERID";
  
  public IEvsPackageDAO getPackageDAO()
  {
    return this.packageDAO;
  }
  
  public void setPackageDAO(IEvsPackageDAO paramIEvsPackageDAO)
  {
    this.packageDAO = paramIEvsPackageDAO;
  }
  
  public TableDataInfo findAllPackage(EvsPackageModel paramEvsPackageModel, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    Map localMap = this.packageDAO.findAllPackage(paramEvsPackageModel, paramInt1, paramInt2);
    localTableDataInfo.setData((List)localMap.get("data"));
    localTableDataInfo.setTotalCount(Integer.parseInt(localMap.get("totalCount").toString()));
    return localTableDataInfo;
  }
  
  public TableDataInfo findPackageList(EvsPackageModel paramEvsPackageModel, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    Map localMap = this.packageDAO.findPackageList(paramEvsPackageModel, paramInt1, paramInt2);
    localTableDataInfo.setData((List)localMap.get("data"));
    localTableDataInfo.setTotalCount(Integer.parseInt(localMap.get("totalCount").toString()));
    return localTableDataInfo;
  }
  
  public TableDataInfo findAllPackageNew(EvsPackageModel paramEvsPackageModel, String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    Map localMap = this.packageDAO.findAllPackageNew(paramEvsPackageModel, paramArrayOfString, paramInt1, paramInt2);
    localTableDataInfo.setData((List)localMap.get("data"));
    localTableDataInfo.setTotalCount(Integer.parseInt(localMap.get("totalCount").toString()));
    return localTableDataInfo;
  }
  
  public TableDataInfo findBookByCode(EvsBook paramEvsBook, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    Map localMap = this.packageDAO.findBookByCode(paramEvsBook, paramInt1, paramInt2);
    localTableDataInfo.setData((List)localMap.get("data"));
    localTableDataInfo.setTotalCount(Integer.parseInt(localMap.get("totalCount").toString()));
    return localTableDataInfo;
  }
  
  public TableDataInfo findAttachmentByVoucherId(EvsVoucher paramEvsVoucher, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    Map localMap = this.packageDAO.findAttachmentByVoucherId(paramEvsVoucher, paramInt1, paramInt2);
    localTableDataInfo.setData((List)localMap.get("data"));
    localTableDataInfo.setTotalCount(Integer.parseInt(localMap.get("totalCount").toString()));
    return localTableDataInfo;
  }
  
  public TableDataInfo findAllBook(EvsBookModel paramEvsBookModel, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    Map localMap = this.packageDAO.findAllBook(paramEvsBookModel, paramInt1, paramInt2);
    localTableDataInfo.setData((List)localMap.get("data"));
    localTableDataInfo.setTotalCount(Integer.parseInt(localMap.get("totalCount").toString()));
    return localTableDataInfo;
  }
  
  public TableDataInfo getBookByBookStatus(EvsBookModel paramEvsBookModel, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    Map localMap = this.packageDAO.getBookByBookStatus(paramEvsBookModel, paramInt1, paramInt2);
    localTableDataInfo.setData((List)localMap.get("data"));
    localTableDataInfo.setTotalCount(Integer.parseInt(localMap.get("totalCount").toString()));
    return localTableDataInfo;
  }
  
  public TableDataInfo findBookByStatus(List<String> paramList, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    TableDataInfo localTableDataInfo = new TableDataInfo();
    Map localMap = null;
    if (paramList.size() > 0) {
      if ((this.tempMessage != null) && (this.tempMessage.length() > 0))
      {
        this.tempMessage = this.tempMessage.replace("updateStatus", "");
        localMap = this.packageDAO.findBookByStatus(this.str, paramInt1, paramInt2);
      }
      else
      {
        for (int i = 0; i < paramList.size(); i++) {
          if (i == 0)
          {
            if (!((String)paramList.get(i)).equals("0")) {
              this.str = (this.str + (String)paramList.get(i) + ",");
            }
            localStringBuffer.append("('" + (String)paramList.get(i));
          }
          else
          {
            this.str = (this.str + (String)paramList.get(i) + ",");
            localStringBuffer.append("','" + (String)paramList.get(i));
          }
        }
        if ((localStringBuffer != null) && (localStringBuffer.length() > 0)) {
          localStringBuffer.append("')");
        }
        localMap = this.packageDAO.findBookByStatus(localStringBuffer.toString(), paramInt1, paramInt2);
      }
    }
    localTableDataInfo.setData((List)localMap.get("data"));
    localTableDataInfo.setTotalCount(Integer.parseInt(localMap.get("totalCount").toString()));
    return localTableDataInfo;
  }
  
  public TableDataInfo findBookByNumber(List<String> paramList, int paramInt1, int paramInt2)
  {
    String str1 = this.str;
    TableDataInfo localTableDataInfo = new TableDataInfo();
    Map localMap = null;
    if ((this.pageMessage != null) && (this.pageMessage.length() > 0))
    {
      this.pageMessage = this.pageMessage.replace("updateStatus", "");
      for (int i = 0; i < paramList.size(); i++) {
        if ((paramList.get(i) != null) && (((String)paramList.get(i)).length() > 0)) {
          if (str1.startsWith((String)paramList.get(i))) {
            str1 = str1.replace((CharSequence)paramList.get(i), "");
          } else {
            str1 = str1.replace("," + (String)paramList.get(i), "");
          }
        }
      }
      if (str1.indexOf("'") != -1) {
        str1 = str1.replaceAll("'", "");
      }
      if (str1.indexOf("(") != -1) {
        str1 = str1.replace("(", "");
      }
      if (str1.indexOf(")") != -1) {
        str1 = str1.replace(")", "");
      }
      if (str1.startsWith(",")) {
        str1 = str1.substring(0, 1);
      }
      if (str1.endsWith(",")) {
        str1 = str1.substring(0, str1.length() - 1);
      }
      this.str = str1;
    }
    String[] arrayOfString = str1.split(",");
    System.out.println("array:::::" + arrayOfString.length + ":::" + arrayOfString[0]);
    str1 = "";
    for (int j = 0; j < arrayOfString.length; j++) {
      if ("".equals(str1)) {
        str1 = "'" + arrayOfString[j] + "'";
      } else {
        str1 = str1 + ",'" + arrayOfString[j] + "'";
      }
    }
    if (!str1.toString().substring(1, 2).equals("(")) {
      str1 = "(" + str1 + ")";
    }
    System.out.println("STR=================" + str1);
    localMap = this.packageDAO.findBookByNumber(str1, paramInt1, paramInt2);
    localTableDataInfo.setData((List)localMap.get("data"));
    localTableDataInfo.setTotalCount(Integer.parseInt(localMap.get("totalCount").toString()));
    return localTableDataInfo;
  }
  
  public TableDataInfo getBookByBookCode(List<String> paramList, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = getAllBookCode(paramList);
    TableDataInfo localTableDataInfo = new TableDataInfo();
    Map localMap = null;
    localMap = this.packageDAO.getBookByBookCode(localStringBuffer.toString(), paramInt1, paramInt2);
    localTableDataInfo.setData((List)localMap.get("data"));
    localTableDataInfo.setTotalCount(Integer.parseInt(localMap.get("totalCount").toString()));
    return localTableDataInfo;
  }
  
  public TableDataInfo getVoucherByVoucherCode(List<String> paramList, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = getAllBookCode(paramList);
    TableDataInfo localTableDataInfo = new TableDataInfo();
    Map localMap = null;
    localMap = this.packageDAO.getVoucherByVoucherCode(localStringBuffer.toString(), paramInt1, paramInt2);
    localTableDataInfo.setData((List)localMap.get("data"));
    localTableDataInfo.setTotalCount(Integer.parseInt(localMap.get("totalCount").toString()));
    return localTableDataInfo;
  }
  
  public String addMessage(String paramString)
  {
    this.pageMessage = paramString;
    this.tempMessage = paramString;
    return this.pageMessage;
  }
  
  public void updateStatusByPackage(List<String> paramList, String paramString)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    StringBuffer localStringBuffer1 = getAllBookCode(paramList);
    List localList1 = this.packageDAO.getBookStatusByBookCode(localStringBuffer1.toString());
    StringBuffer localStringBuffer2 = new StringBuffer();
    if (localList1.size() > 0)
    {
      for (int i = 0; i < localList1.size(); i++) {
        if (i == 0) {
          localStringBuffer2.append("('" + ((EvsBook)localList1.get(i)).getBookId());
        } else {
          localStringBuffer2.append("','" + ((EvsBook)localList1.get(i)).getBookId());
        }
      }
      if ((localStringBuffer2 != null) && (localStringBuffer2.length() > 0)) {
        localStringBuffer2.append("')");
      }
    }
    List localList2 = this.packageDAO.getBookByBookId(localStringBuffer2.toString());
    EvsBook localEvsBook = null;
    for (int j = 0; j < localList2.size(); j++)
    {
      localEvsBook = (EvsBook)this.evsVoucherCheckFindDAO.get(EvsBook.class, Long.valueOf(Long.parseLong(localList2.get(j).toString())));
      this.packageDAO.saveBook(localEvsBook.getBookId().toString());
      this.evsVoucherHistoryDAO.addHistory(localEasUserInfo, 1L, localEvsBook.getBookId().toString(), EvsStatusUtil.getOperName("PACKAG"), localEvsBook.getBookStatus(), "PACKAGED");
    }
    this.packageDAO.updateStatusByPackage(localStringBuffer1.toString(), paramString, "PACKAGED");
  }
  
  public void updateStatusByBook(List<String> paramList)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    StringBuffer localStringBuffer = getAllBookCode(paramList);
    List localList = this.packageDAO.getBookStatusByBookCode(localStringBuffer.toString());
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      EvsBook localEvsBook = (EvsBook)localIterator.next();
      this.packageDAO.saveBook(localEvsBook.getBookId().toString());
      this.evsVoucherHistoryDAO.addHistory(localEasUserInfo, 1L, localEvsBook.getBookId().toString(), EvsStatusUtil.getOperName("PACKAG"), localEvsBook.getBookStatus(), "PACKAGED");
    }
    this.packageDAO.updateStatusByBook(localStringBuffer.toString(), "BOOKED");
  }
  
  public void updateVoucherBookPackageByPackageId(String paramString, List<String> paramList)
  {
    StringBuffer localStringBuffer = getAllBookCode(paramList);
    this.packageDAO.updateVoucherBookPackageByPackageId(paramString, localStringBuffer.toString());
  }
  
  public void updateVoucherStatusByBookCode(List<String> paramList)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    StringBuffer localStringBuffer1 = getAllBookCode(paramList);
    EvsVoucher localEvsVoucher = null;
    List localList = this.packageDAO.getVoucherById(localStringBuffer1.toString());
    StringBuffer localStringBuffer2 = new StringBuffer();
    if (localList.size() > 0)
    {
      for (i = 0; i < localList.size(); i++) {
        if (i == 0) {
          localStringBuffer2.append("('" + localList.get(i));
        } else {
          localStringBuffer2.append("','" + localList.get(i));
        }
      }
      if ((localStringBuffer2 != null) && (localStringBuffer2.length() > 0)) {
        localStringBuffer2.append("')");
      }
      this.evsVoucherCheckFindDAO.saveVoucher(localStringBuffer2.toString());
    }
    for (int i = 0; i < localList.size(); i++)
    {
      localEvsVoucher = (EvsVoucher)this.evsVoucherCheckFindDAO.get(EvsVoucher.class, Long.valueOf(Long.parseLong(localList.get(i).toString())));
      if (localEvsVoucher != null) {
        this.evsVoucherHistoryDAO.addHistory(localEasUserInfo, 0L, localEvsVoucher.getVoucherId().toString(), EvsStatusUtil.getOperName("PACKAG"), localEvsVoucher.getVoucherStatus(), "PACKAGED");
      }
    }
    this.packageDAO.updateVoucherStatusByBookCode(localStringBuffer1.toString());
  }
  
  public void updateVoucherOnPackaged(List<String> paramList)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    StringBuffer localStringBuffer1 = getAllBookCode(paramList);
    EvsVoucher localEvsVoucher = null;
    List localList = this.packageDAO.getVoucherById(localStringBuffer1.toString());
    StringBuffer localStringBuffer2 = new StringBuffer();
    if (localList.size() > 0)
    {
      for (i = 0; i < localList.size(); i++) {
        if (i == 0) {
          localStringBuffer2.append("('" + localList.get(i));
        } else {
          localStringBuffer2.append("','" + localList.get(i));
        }
      }
      if ((localStringBuffer2 != null) && (localStringBuffer2.length() > 0)) {
        localStringBuffer2.append("')");
      }
      this.evsVoucherCheckFindDAO.saveVoucher(localStringBuffer2.toString());
    }
    for (int i = 0; i < localList.size(); i++)
    {
      localEvsVoucher = (EvsVoucher)this.evsVoucherCheckFindDAO.get(EvsVoucher.class, Long.valueOf(Long.parseLong(localList.get(i).toString())));
      if (localEvsVoucher != null) {
        this.evsVoucherHistoryDAO.addHistory(localEasUserInfo, 0L, localEvsVoucher.getVoucherId().toString(), EvsStatusUtil.getOperName("PACKAG"), localEvsVoucher.getVoucherStatus(), "PACKAGED");
      }
    }
    this.packageDAO.updateVoucherOnPackaged(localStringBuffer1.toString());
  }
  
  public void updateReturnStatus(List<String> paramList)
  {
    StringBuffer localStringBuffer = getAllBookCode(paramList);
    this.packageDAO.updateReturnStatus(localStringBuffer.toString());
  }
  
  public void updateStatus(List<String> paramList)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    StringBuffer localStringBuffer = getAllBookCode(paramList);
    if (localEasUserInfo != null) {
      this.packageDAO.updateStatus(localStringBuffer.toString(), localEasUserInfo.getUserInfoPk().toString());
    } else {
      this.packageDAO.updateStatus(localStringBuffer.toString(), "USERID");
    }
  }
  
  public void updateBookStatusByCode(String paramString)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    if (localEasUserInfo != null) {
      this.packageDAO.updateBookStatusByCode(paramString, localEasUserInfo.getUserInfoPk().toString());
    } else {
      this.packageDAO.updateBookStatusByCode(paramString, "USERID");
    }
  }
  
  public void updateStatusByPackageCode(String paramString)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    EvsPackageModel localEvsPackageModel = new EvsPackageModel();
    localEvsPackageModel.setPackageCode(paramString);
    EvsPackage localEvsPackage = this.packageDAO.getPackageByCode(localEvsPackageModel);
    this.packageDAO.savePackageInfo(localEvsPackage.getPackageId().toString());
    this.evsVoucherHistoryDAO.addHistory(localEasUserInfo, 2L, localEvsPackage.getPackageId().toString(), EvsStatusUtil.getOperName("UNPACK"), localEvsPackage.getPackageStatus(), "NOT_PACKAGED");
    this.packageDAO.updateStatusByPackageCode(paramString, "NOT_PACKAGED");
  }
  
  public void updatePackageStatusById(String paramString)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    EvsPackageModel localEvsPackageModel = new EvsPackageModel();
    localEvsPackageModel.setPackageId(Long.valueOf(Long.parseLong(paramString)));
    EvsPackage localEvsPackage = this.packageDAO.getPackageById(localEvsPackageModel);
    this.packageDAO.savePackageInfo(localEvsPackage.getPackageId().toString());
    this.evsVoucherHistoryDAO.addHistory(localEasUserInfo, 2L, localEvsPackage.getPackageId().toString(), EvsStatusUtil.getOperName("PACKAG"), localEvsPackage.getPackageStatus(), "PACKAGED");
    this.packageDAO.updatePackageStatusById(paramString, "PACKAGED");
  }
  
  public void updateBookStatusByPackageId(String paramString)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    List localList1 = this.packageDAO.getBookByPackageId(paramString);
    StringBuffer localStringBuffer = new StringBuffer();
    if (localList1.size() > 0)
    {
      for (int i = 0; i < localList1.size(); i++) {
        if (i == 0) {
          localStringBuffer.append("('" + ((EvsBook)localList1.get(i)).getBookId());
        } else {
          localStringBuffer.append("','" + ((EvsBook)localList1.get(i)).getBookId());
        }
      }
      if ((localStringBuffer != null) && (localStringBuffer.length() > 0)) {
        localStringBuffer.append("')");
      }
    }
    List localList2 = this.packageDAO.getBookByBookId(localStringBuffer.toString());
    EvsBook localEvsBook = null;
    for (int j = 0; j < localList2.size(); j++)
    {
      localEvsBook = (EvsBook)this.evsVoucherCheckFindDAO.get(EvsBook.class, Long.valueOf(Long.parseLong(localList2.get(j).toString())));
      this.packageDAO.saveBook(localEvsBook.getBookId().toString());
      this.evsVoucherHistoryDAO.addHistory(localEasUserInfo, 1L, localEvsBook.getBookId().toString(), EvsStatusUtil.getOperName("UNPACK"), localEvsBook.getBookStatus(), "UNPACKAG");
    }
    this.packageDAO.updateBookStatusByPackageId(paramString, "BOOKED");
  }
  
  public String updateStatusByBookCode(EvsBookModel paramEvsBookModel)
  {
    String str1 = "";
    int i = 0;
    log.debug("update EvsBook bookStatus");
    try
    {
      EvsBook localEvsBook = getBookByCode(paramEvsBookModel);
      if (localEvsBook != null)
      {
        if (localEvsBook.getBookStatus().equals("PACKAGED"))
        {
          str1 = "2";
        }
        else
        {
          String str2 = localEvsBook.getPeriodName() == null ? "" : localEvsBook.getPeriodName();
          String str3 = localEvsBook.getCompanyCode() == null ? "" : localEvsBook.getCompanyCode();
          if ((!str2.equals(paramEvsBookModel.getPeriodName())) || (!str3.equals(paramEvsBookModel.getCompanyCode()))) {
            str1 = "3";
          } else {
            i = 1;
          }
          if (i == 1) {
            if ((localEvsBook.getBookStatus().equals("BOOKED")) || (localEvsBook.getBookStatus().equals("UNPACKAG")) || (localEvsBook.getBookStatus().equals("ALREADY_RECEIVE")) || (localEvsBook.getBookStatus().equals("NOT_RECEIVE"))) {
              str1 = "5";
            } else {
              str1 = "4";
            }
          }
        }
      }
      else {
        str1 = "1";
      }
      log.debug("update bookStatus By bookCode");
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("update failed", localRuntimeException);
      throw localRuntimeException;
    }
    return str1;
  }
  
  public void updatePackageIdByBookCode(EvsBook paramEvsBook)
  {
    this.packageDAO.updatePackageIdByBookCode(paramEvsBook);
  }
  
  public void savePackage(EvsPackage paramEvsPackage)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    EvsPackage localEvsPackage1 = new EvsPackage();
    if (localEasUserInfo != null)
    {
      localEvsPackage1.setPackageEmployeeId(Long.valueOf(Long.parseLong(localEasUserInfo.getUserInfoPk().toString())));
      localEvsPackage1.setCreatedBy(Long.valueOf(Long.parseLong(localEasUserInfo.getUserInfoPk().toString())));
      localEvsPackage1.setLastUpdateBy(Long.valueOf(Long.parseLong(localEasUserInfo.getUserInfoPk().toString())));
      localEvsPackage1.setLastUpdateLogin(Long.valueOf(Long.parseLong(localEasUserInfo.getUserInfoPk().toString())));
    }
    else
    {
      localEvsPackage1.setPackageEmployeeId(Long.valueOf(Long.parseLong("10006")));
      localEvsPackage1.setCreatedBy(Long.valueOf(Long.parseLong("10006")));
      localEvsPackage1.setLastUpdateBy(Long.valueOf(Long.parseLong("10006")));
      localEvsPackage1.setLastUpdateLogin(Long.valueOf(Long.parseLong("10006")));
    }
    FbpCompanyV localFbpCompanyV = this.fbpCompanyVDAO.findByCompCode(paramEvsPackage.getCompanyCode());
    localEvsPackage1.setPackageCode(paramEvsPackage.getPackageCode());
    localEvsPackage1.setTradType(paramEvsPackage.getTradType());
    localEvsPackage1.setPeriodName(paramEvsPackage.getPeriodName());
    localEvsPackage1.setCompanyId(localFbpCompanyV.getCompanyId());
    localEvsPackage1.setPackageDate(new Date());
    localEvsPackage1.setCreationDate(new Date());
    localEvsPackage1.setLastUpdateDate(new Date());
    localEvsPackage1.setPackageStatus("PACKAGED");
    this.packageDAO.savePackage(localEvsPackage1);
    ObjectCopyUtils.setWho(localEvsPackage1);
    EvsPackageModel localEvsPackageModel = new EvsPackageModel();
    localEvsPackageModel.setPackageCode(paramEvsPackage.getPackageCode());
    EvsPackage localEvsPackage2 = this.packageDAO.getPackageByCode(localEvsPackageModel);
    localEasUserInfo.setCheckUnit(localFbpCompanyV.getCompanyId().toString());
    this.evsVoucherHistoryDAO.addHistory(localEasUserInfo, 2L, localEvsPackage2.getPackageId().toString(), EvsStatusUtil.getOperName("PACKAG"), localEvsPackage2.getPackageStatus(), "PACKAGED");
  }
  
  public void saveVoucherBookPackage(EvsVoucherBookPackage paramEvsVoucherBookPackage)
  {
    EvsVoucherBookPackage localEvsVoucherBookPackage = new EvsVoucherBookPackage();
    localEvsVoucherBookPackage.setVoucherId(paramEvsVoucherBookPackage.getVoucherId());
    localEvsVoucherBookPackage.setBookId(Long.valueOf(Long.parseLong("0")));
    localEvsVoucherBookPackage.setPackageId(Long.valueOf(Long.parseLong("0")));
    localEvsVoucherBookPackage.setCreationDate(new Date());
    localEvsVoucherBookPackage.setCreatedBy(Long.valueOf(Long.parseLong("110")));
    localEvsVoucherBookPackage.setLastUpdateDate(new Date());
    localEvsVoucherBookPackage.setLastUpdateBy(Long.valueOf(Long.parseLong("110")));
    localEvsVoucherBookPackage.setLastUpdateLogin(Long.valueOf(Long.parseLong("110")));
    this.packageDAO.saveVoucherBookPackage(localEvsVoucherBookPackage);
  }
  
  public EvsPackage getPackageByCode(EvsPackageModel paramEvsPackageModel)
  {
    return this.packageDAO.getPackageByCode(paramEvsPackageModel);
  }
  
  public TableDataInfo findVoucherByBookCode(EvsVoucherBookPackage paramEvsVoucherBookPackage, int paramInt1, int paramInt2)
  {
    EvsBookDAO localEvsBookDAO = (EvsBookDAO)SSBBus.findDomainService("ebookDAO");
    TableDataInfo localTableDataInfo = new TableDataInfo();
    Map localMap = null;
    EvsBook localEvsBook = localEvsBookDAO.findBookById(Long.valueOf(paramEvsVoucherBookPackage.getBookId().longValue()));
    if (null != localEvsBook)
    {
      localMap = localEvsBookDAO.findFasciculeForL(localEvsBook, paramInt1, paramInt2);
      if (localMap != null)
      {
        localTableDataInfo.setData((List)localMap.get("data"));
        localTableDataInfo.setTotalCount(Integer.parseInt(localMap.get("totalCount").toString()));
        return localTableDataInfo;
      }
    }
    return localTableDataInfo;
  }
  
  public EvsPackage getPackageById(EvsPackageModel paramEvsPackageModel)
  {
    return this.packageDAO.getPackageById(paramEvsPackageModel);
  }
  
  public EvsBook getBookByCode(EvsBookModel paramEvsBookModel)
  {
    return this.packageDAO.getBookByCode(paramEvsBookModel);
  }
  
  public EvsBook getBookById(EvsBook paramEvsBook)
  {
    return this.packageDAO.getBookById(paramEvsBook);
  }
  
  public StringBuffer getAllBookCode(List<String> paramList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i = 0; i < paramList.size(); i++) {
      if (i == 0) {
        localStringBuffer.append("('" + (String)paramList.get(i));
      } else {
        localStringBuffer.append("','" + (String)paramList.get(i));
      }
    }
    if ((localStringBuffer != null) && (localStringBuffer.length() > 0)) {
      localStringBuffer.append("')");
    }
    return localStringBuffer;
  }
  
  public String getGenerarionNmber(String[] paramArrayOfString)
  {
    String str1 = "";
    do
    {
      str1 = this.packageDAO.getGenerarionNmber(paramArrayOfString[0], paramArrayOfString[1], paramArrayOfString[2], paramArrayOfString[3], paramArrayOfString[4], paramArrayOfString[5]);
      EvsPackageModel localEvsPackageModel = new EvsPackageModel();
      localEvsPackageModel.setPackageCode(str1);
      EvsPackage localEvsPackage = this.packageDAO.getPackageByCode(localEvsPackageModel);
      if (localEvsPackage != null) {
        str1 = "";
      }
    } while (str1.equals(""));
    return str1;
  }
  
  public IEvsVoucherHistoryDAO getEvsVoucherHistoryDAO()
  {
    return this.evsVoucherHistoryDAO;
  }
  
  public void setEvsVoucherHistoryDAO(IEvsVoucherHistoryDAO paramIEvsVoucherHistoryDAO)
  {
    this.evsVoucherHistoryDAO = paramIEvsVoucherHistoryDAO;
  }
  
  public EvsVoucherCheckFindDAO getEvsVoucherCheckFindDAO()
  {
    return this.evsVoucherCheckFindDAO;
  }
  
  public void setEvsVoucherCheckFindDAO(EvsVoucherCheckFindDAO paramEvsVoucherCheckFindDAO)
  {
    this.evsVoucherCheckFindDAO = paramEvsVoucherCheckFindDAO;
  }
  
  public List getVoucherById(String paramString)
  {
    return this.packageDAO.getVoucherById(paramString);
  }
  
  public List getBookByBookIds(String paramString)
  {
    return this.packageDAO.getBookByBookIds(paramString);
  }
  
  public List getBookByPackageId(String paramString)
  {
    return this.packageDAO.getBookByPackageId(paramString);
  }
  
  public String getPeriodName()
  {
    return this.packageDAO.getPeriodName();
  }
  
  public String getSetBookOrgId()
  {
    return this.packageDAO.getSetBookOrgId();
  }
  
  public String getCompanyName()
  {
    return this.packageDAO.getCompanyName();
  }
  
  public EvsPackageV getPackageByPackageCode(String paramString)
  {
    return this.packageDAO.getPackageByPackageCode(paramString);
  }
  
  public String getDocTypeById()
  {
    return this.packageDAO.getDocTypeById();
  }
  
  public IEvsVoucherGenerateDAO getEvsVoucherGenerateDAO()
  {
    return this.evsVoucherGenerateDAO;
  }
  
  public void setEvsVoucherGenerateDAO(IEvsVoucherGenerateDAO paramIEvsVoucherGenerateDAO)
  {
    this.evsVoucherGenerateDAO = paramIEvsVoucherGenerateDAO;
  }
  
  public String findBookByIsBookStatus(List<String> paramList)
  {
    StringBuffer localStringBuffer = getAllBookCode(paramList);
    return this.packageDAO.findBookByIsBookStatus(localStringBuffer.toString());
  }
  
  public String getDateByPeriodName(String paramString)
  {
    return this.packageDAO.getDateByPeriodName(paramString);
  }
  
  public TableDataInfo getPackageByPackageId(String[] paramArrayOfString, String paramString, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    PageInfo localPageInfo = this.packageDAO.getPackageByPackageId(paramArrayOfString, paramString, paramInt1, paramInt2);
    localTableDataInfo.setData((List)localPageInfo.getResult());
    localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
    return localTableDataInfo;
  }
  
  public String checkBoxByNum(EvsPackageModel paramEvsPackageModel)
  {
    EvsPackageV localEvsPackageV = this.packageDAO.getPackageByPackageCode(paramEvsPackageModel.getPackageCode());
    try
    {
      if (localEvsPackageV == null) {
        return "NO_DATE";
      }
      if (((localEvsPackageV.getCompanyId() == null) && (paramEvsPackageModel.getCompanyId() != null)) || ((localEvsPackageV.getCompanyId() != null) && (paramEvsPackageModel.getCompanyId() == null)) || (!localEvsPackageV.getCompanyId().toString().equals(paramEvsPackageModel.getCompanyId().toString()))) {
        return "COMPANY_ERROR";
      }
      if ((!"PACKAGED".equals(localEvsPackageV.getPackageStatus())) && (!"WAREHOUSE".equals(localEvsPackageV.getPackageStatus()))) {
        return "STATUS_ERROR";
      }
      return "OK";
    }
    catch (RuntimeException localRuntimeException)
    {
      localRuntimeException.printStackTrace();
    }
    return "exception";
  }
  
  public String checkVoucherByNum(EvsVoucherV paramEvsVoucherV)
  {
    EvsVoucherV localEvsVoucherV = this.packageDAO.getVoucherByJournalNum(paramEvsVoucherV.getJournalNum());
    try
    {
      if (localEvsVoucherV == null) {
        return "NO_DATE";
      }
      if (((localEvsVoucherV.getCompanyId() == null) && (paramEvsVoucherV.getCompanyId() != null)) || ((localEvsVoucherV.getCompanyId() != null) && (paramEvsVoucherV.getCompanyId() == null)) || (!localEvsVoucherV.getCompanyId().toString().equals(paramEvsVoucherV.getCompanyId().toString()))) {
        return "COMPANY_ERROR";
      }
      if ((!"SUBMITED".equals(localEvsVoucherV.getVoucherStatus())) && (!"CHECKED_NO_BOOKED".equals(localEvsVoucherV.getVoucherStatus()))) {
        return "STATUS_ERROR";
      }
      return "OK";
    }
    catch (RuntimeException localRuntimeException)
    {
      localRuntimeException.printStackTrace();
    }
    return "exception";
  }
  
  public List<String> findIdByBoxCode(List<String> paramList)
  {
    String str1 = fmtList(paramList, "'");
    Object localObject = new ArrayList();
    localObject = this.packageDAO.findIdByBoxCode(str1);
    if (((List)localObject).size() == 0) {
      ((List)localObject).add("-1");
    }
    return localObject;
  }
  
  public TableDataInfo findBookByIds(String[] paramArrayOfString, String paramString, int paramInt1, int paramInt2)
  {
    PageInfo localPageInfo = this.packageDAO.findBookByIds(paramArrayOfString, paramString, paramInt1, paramInt2);
    TableDataInfo localTableDataInfo = new TableDataInfo();
    if ((localPageInfo != null) && (localPageInfo.getTotalCount() > 0L))
    {
      localTableDataInfo.setData((List)localPageInfo.getResult());
      localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
    }
    return localTableDataInfo;
  }
  
  public String fmtList(List<String> paramList, String paramString)
  {
    String str1 = "";
    paramString = paramString == null ? "" : paramString;
    paramString = !paramString.equals("'") ? "" : paramString;
    if ((paramList != null) && (paramList.size() > 0))
    {
      for (int i = 0; i < paramList.size(); i++)
      {
        Object localObject = paramList.get(i);
        String str2 = localObject.toString();
        str1 = str1 + paramString + str2 + paramString + ",";
      }
      str1 = str1.substring(0, str1.length() - 1);
    }
    return str1;
  }
  
  public String getImagePageUrl(String paramString)
  {
    if (!Util.isStrEmpty(paramString))
    {
      List localList = this.packageDAO.findImageNumByVoucherId(paramString);
      String str1 = AccessPropertiesFile.getValue("image_page_url", "linkImagePageUrlConfig.properties");
      String str2 = "-1";
      if ((localList != null) && (localList.size() > 0))
      {
        EvsImage localEvsImage = (EvsImage)localList.get(0);
        str2 = localEvsImage.getBarcode();
      }
      return str1 = str1 + "?imageNumber=" + str2;
    }
    return "#";
  }
  
  public TableDataInfo findAllBookNew(EvsBookModel paramEvsBookModel, String[] paramArrayOfString1, String paramString, String[] paramArrayOfString2, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    Object localObject1 = new ArrayList();
    Object localObject2 = new ArrayList();
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    String str1 = "notIncould";
    PageInfo localPageInfo = new PageInfo();
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < paramArrayOfString2.length; i++) {
      localArrayList.add(paramArrayOfString2[i]);
    }
    if ("search".equals(paramString))
    {
      localPageInfo = this.packageDAO.findAllBookNew(paramEvsBookModel, paramInt1, paramInt2, paramArrayOfString1, str1);
      localObject2 = this.packageDAO.findAllBookCodeByWarehouse(paramEvsBookModel, paramArrayOfString1, str1);
      if ((localPageInfo != null) && (localPageInfo.getResult() != null))
      {
        localObject1 = (List)localPageInfo.getResult();
        for (i = 0; i < ((List)localObject1).size(); i++)
        {
          ((EvsBookV)((List)localObject1).get(i)).setBookStatus(EvsStatusUtil.getVoucherStatusName(((EvsBookV)((List)localObject1).get(i)).getBookStatus()));
          if ((!"WAREHOUSE".equals(((EvsBookV)((List)localObject1).get(i)).getBookStatus())) && (!"已入库".equals(((EvsBookV)((List)localObject1).get(i)).getBookStatus()))) {
            ((EvsBookV)((List)localObject1).get(i)).setInvoiceTypeName("N");
          } else {
            ((EvsBookV)((List)localObject1).get(i)).setInvoiceTypeName("Y");
          }
          if (localArrayList.contains(((EvsBookV)((List)localObject1).get(i)).getBookCode())) {
            localArrayList.remove(((EvsBookV)((List)localObject1).get(i)).getBookCode());
          }
        }
      }
    }
    if (localArrayList.size() > 0)
    {
      String str2 = StringUtils.fmtStr(localArrayList);
      if (!StringUtils.isEmpty(str2).booleanValue())
      {
        List localList = this.packageDAO.getBookVByCodeList(str2, "WAREHOUSE");
        if ((localList != null) && (localList.size() > 0))
        {
          Iterator localIterator = localList.iterator();
          while (localIterator.hasNext())
          {
            EvsBookV localEvsBookV = (EvsBookV)localIterator.next();
            ((List)localObject2).add(localEvsBookV.getBookId());
            if ((!"WAREHOUSE".equals(localEvsBookV.getBookStatus())) && (!"已入库".equals(localEvsBookV.getBookStatus()))) {
              localEvsBookV.setInvoiceTypeName("N");
            } else {
              localEvsBookV.setInvoiceTypeName("Y");
            }
            localEvsBookV.setBookStatus(EvsStatusUtil.getVoucherStatusName(localEvsBookV.getBookStatus()));
            ((List)localObject1).add(localEvsBookV);
          }
          localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount() + localList.size());
        }
      }
    }
    if (localTableDataInfo.getTotalCount() == 0) {
      localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
    }
    localEvsObjectUtils.getUserInfoSession().setAttribute("SESSION_WAREHOUSE_BOOKID", localObject2);
    localTableDataInfo.setData((List)localObject1);
    return localTableDataInfo;
  }
  
  public TableDataInfo findAllVoucherNew(EvsVoucherV paramEvsVoucherV, String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    String str1 = "notIncould";
    PageInfo localPageInfo = this.packageDAO.findAllVoucherNew(paramEvsVoucherV, paramInt1, paramInt2, paramArrayOfString, str1);
    TableDataInfo localTableDataInfo = new TableDataInfo();
    if ((localPageInfo != null) && (localPageInfo.getResult() != null))
    {
      List localList = (List)localPageInfo.getResult();
      localTableDataInfo.setData(localList);
      localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
    }
    return localTableDataInfo;
  }
  
  public TableDataInfo findVoucherByNumbs(String[] paramArrayOfString, String paramString, int paramInt1, int paramInt2)
  {
    PageInfo localPageInfo = this.packageDAO.findVoucherByNumbs(paramArrayOfString, paramString, paramInt1, paramInt2);
    TableDataInfo localTableDataInfo = new TableDataInfo();
    if ((localPageInfo != null) && (localPageInfo.getResult() != null))
    {
      List localList = (List)localPageInfo.getResult();
      localTableDataInfo.setData(localList);
      localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
    }
    return localTableDataInfo;
  }
  
  public TableDataInfo findBookByNumbs(String[] paramArrayOfString, String paramString, int paramInt1, int paramInt2)
  {
    PageInfo localPageInfo = this.packageDAO.findBookByNumbs(paramArrayOfString, paramString, paramInt1, paramInt2);
    TableDataInfo localTableDataInfo = new TableDataInfo();
    if ((localPageInfo != null) && (localPageInfo.getResult() != null))
    {
      List localList = (List)localPageInfo.getResult();
      localTableDataInfo.setData(localList);
      localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
    }
    return localTableDataInfo;
  }
  
  public ReturnMessage findBookedPeriod(String paramString1, String paramString2, String paramString3)
  {
    ReturnMessage localReturnMessage = new ReturnMessage();
    String str1 = paramString3.substring(2, 4);
    List localList1 = this.packageDAO.findBookedPeriod(paramString1, paramString2, "MUST_NOT_NULL", false, str1);
    if (!localList1.isEmpty())
    {
      str2 = fmtList(localList1, null);
      localReturnMessage.setPeriodNameS(str2);
      localReturnMessage.setMessage("HIS_BOOLED");
      return localReturnMessage;
    }
    localList1 = this.packageDAO.findBookedPeriod(paramString1, paramString2, "MUST_IS_NULL", true, str1);
    if (localList1.isEmpty())
    {
      localReturnMessage.setMessage("NOT_DATA");
      return localReturnMessage;
    }
    String str2 = fmtList(localList1, "'");
    List localList2 = this.packageDAO.findPeriod(str2);
    if (!localList2.isEmpty())
    {
      Date localDate = ((FbpPeriods)localList2.get(0)).getStartDate();
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MM-yyyy");
      if (localDate != null) {
        localReturnMessage.setPeriodDate(localSimpleDateFormat.format(localDate));
      }
      localReturnMessage.setPeriodName(((FbpPeriods)localList2.get(0)).getPeriodName());
      String str3 = localReturnMessage.getPeriodDate().substring(5, 7);
      List localList3 = this.packageDAO.findPeriodOnYear(str3, false, localReturnMessage.getPeriodName());
      if (!localList3.isEmpty())
      {
        localReturnMessage.setPeriodDate(null);
        localReturnMessage.setPeriodName(null);
        localReturnMessage.setMessage("NOT_DATA");
      }
      return localReturnMessage;
    }
    return localReturnMessage;
  }
  
  public ReturnMessage manageArchiveNumber(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    ReturnMessage localReturnMessage = new ReturnMessage();
    try
    {
      List localList1 = this.packageDAO.findBookByParam(paramString1, paramString2, paramString3);
      if (!localList1.isEmpty())
      {
        Iterator localIterator = localList1.iterator();
        while (localIterator.hasNext())
        {
          EvsBook localEvsBook = (EvsBook)localIterator.next();
          String str1;
          String str2;
          List localList2;
          Object localObject;
          if ("make".equals(paramString4))
          {
            str1 = "";
            str2 = localEvsBook.getInvoiceType();
            localList2 = this.packageDAO.findDocNumb(str2);
            String str3 = localList2.size() == 0 ? "" : (String)localList2.get(0);
            localObject = "JAN-" + paramString3.substring(paramString3.lastIndexOf("-") + 1, paramString3.length());
            str1 = this.packageDAO.getGenerarionNmber(paramString1, str3, str2, (String)localObject, "", "ARCHIVE_NUMBER");
            this.packageDAO.updateBoolArhciveNumber(localEvsBook.getBookCode(), str1);
          }
          if (!"make".equals(paramString4))
          {
            str1 = localEvsBook.getArchiveNumber();
            str2 = str1.substring(0, str1.lastIndexOf("/"));
            localList2 = this.packageDAO.findBookdByArhciveNumberNew(str2);
            List localList3;
            if (localList2.size() > 1)
            {
              localEvsBook.setArchiveNumber(null);
              try
              {
                this.packageDAO.updateBook(localEvsBook);
              }
              catch (RuntimeException localRuntimeException2)
              {
                localRuntimeException2.printStackTrace();
                localReturnMessage.setMessage("ERROR");
                return localReturnMessage;
              }
              localList3 = this.packageDAO.findBookdByArhciveNumberNew(str2);
              localObject = (EvsBook)localList3.get(0);
              str1 = ((EvsBook)localObject).getArchiveNumber();
              str1 = str1.substring(0, str1.lastIndexOf("/"));
              str1 = this.packageDAO.findMaxArchiveNumber(str1);
              List localList4 = this.packageDAO.findBookdByArhciveNumber(str1);
              if (localList4.isEmpty())
              {
                localReturnMessage.setMessage("ERROR");
                return localReturnMessage;
              }
              List localList5 = fomrtArhciveNumber((EvsBook)localList4.get(0));
              this.packageDAO.updateSerials((String)localList5.get(1), (String)localList5.get(0));
            }
            else if (localList2.size() == 1)
            {
              localList3 = fomrtArhciveNumber(localEvsBook);
              this.packageDAO.updateSerials((String)localList3.get(1), "0");
              localEvsBook.setArchiveNumber(null);
              this.packageDAO.updateBook(localEvsBook);
            }
          }
        }
      }
      localReturnMessage.setMessage("OK");
      return localReturnMessage;
    }
    catch (RuntimeException localRuntimeException1)
    {
      localRuntimeException1.printStackTrace();
      localReturnMessage.setMessage("ERROR");
    }
    return localReturnMessage;
  }
  
  public List<String> fomrtArhciveNumber(EvsBook paramEvsBook)
  {
    String str1 = "";
    ArrayList localArrayList = new ArrayList();
    String str2 = paramEvsBook.getArchiveNumber();
    if (Util.isStrEmpty(str2)) {
      return localArrayList;
    }
    String[] arrayOfString1 = str2.split("/");
    String str3 = arrayOfString1[0];
    String[] arrayOfString2 = str3.split("·");
    String str4 = paramEvsBook.getPeriodName();
    String str5 = "JAN-" + str4.substring(str4.lastIndexOf("-") + 1, str4.length());
    str1 = "ARCHIVE_NUMBER_" + paramEvsBook.getCompanyCode() + "_" + arrayOfString2[1] + "_" + arrayOfString2[2] + "_" + str5 + "__·_·_·_" + arrayOfString2[3] + "_·_/" + "_" + arrayOfString2[4] + "_" + arrayOfString2[0];
    localArrayList.add(arrayOfString1[1]);
    localArrayList.add(str1);
    return localArrayList;
  }
  
  public ReturnMessage findRemovePeriod(String paramString1, String paramString2, String paramString3)
  {
    ReturnMessage localReturnMessage = new ReturnMessage();
    String str1 = paramString3.substring(2, 4);
    List localList1 = this.packageDAO.findUnBookPeriod(paramString1, paramString2, str1);
    if (localList1.isEmpty()) {
      localList1 = this.packageDAO.findAllPeriod(paramString1, paramString2, str1);
    }
    if (!localList1.isEmpty())
    {
      String str2 = fmtList(localList1, "'");
      List localList2 = this.packageDAO.findPeriod(str2);
      if (!localList2.isEmpty())
      {
        Date localDate = ((FbpPeriods)localList2.get(localList2.size() - 1)).getStartDate();
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MM-yyyy");
        if (localDate != null) {
          localReturnMessage.setPeriodDate(localSimpleDateFormat.format(localDate));
        }
        localReturnMessage.setPeriodName(((FbpPeriods)localList2.get(localList2.size() - 1)).getPeriodName());
        return localReturnMessage;
      }
    }
    else
    {
      localReturnMessage.setMessage("NOT_DATA");
    }
    return localReturnMessage;
  }
  
  public String checkByBookCode(EvsBookModel paramEvsBookModel)
  {
    String str1 = "";
    int i = 0;
    log.debug("update EvsBook bookStatus");
    try
    {
      List localList = this.packageDAO.findBookByNum(paramEvsBookModel.getBookCode());
      if ((localList == null) || (localList.size() == 0))
      {
        str1 = "1";
        return str1;
      }
      EvsBookV localEvsBookV = (EvsBookV)localList.get(0);
      if (localEvsBookV.getBookStatus() != null)
      {
        if (!localEvsBookV.getBookStatus().equals("WAREHOUSE")) {
          return "STATUS_ERROR";
        }
      }
      else {
        return "STATUS_ERROR";
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("update failed", localRuntimeException);
      throw localRuntimeException;
    }
    return str1;
  }
  
  public List getImage(String paramString)
  {
    Object localObject = new ArrayList();
    if (!Util.isStrEmpty(paramString)) {
      localObject = this.packageDAO.findImageByImageNumer(paramString);
    }
    return localObject;
  }
  
  public String updateStatusByWarehouse(List<String> paramList, String paramString)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    String str1 = "";
    log.debug("update evs_package bookStatus");
    try
    {
      if ((paramList.size() > 0) && (!"".equals(paramString))) {
        for (int i = 0; i < paramList.size(); i++)
        {
          String str2 = ((String)paramList.get(i)).toString();
          EvsPackageModel localEvsPackageModel = new EvsPackageModel();
          localEvsPackageModel.setPackageCode(str2);
          EvsPackage localEvsPackage = this.packageDAO.getPackageByCode(localEvsPackageModel);
          localEasUserInfo.setCheckUnit(localEvsPackage.getCompanyId().toString());
          EvsWarehouse localEvsWarehouse = this.warehouseDAO.getWarehouseCode(paramString);
          this.evsVoucherHistoryDAO.addHistoryNew(localEasUserInfo, 2L, localEvsPackage.getPackageId().toString(), EvsStatusUtil.getOperName("UNWAREHOUSE"), localEvsPackage.getPackageStatus(), "WAREHOUSE", localEvsPackage.getCompanyId(), localEvsWarehouse.getWarehouseId());
          this.packageDAO.updateWarehouse(str2, paramString);
          List localList1 = this.packageDAO.getBookBypackageCode(str2);
          EvsBook localEvsBook = null;
          for (int j = 0; j < localList1.size(); j++)
          {
            localEvsBook = new EvsBook();
            localEvsBook.setBookId(Long.valueOf(localList1.get(j).toString()));
            localEvsBook = getBookById(localEvsBook);
            this.evsVoucherHistoryDAO.addHistoryNew(localEasUserInfo, 1L, localEvsBook.getBookId().toString(), EvsStatusUtil.getOperName("UNWAREHOUSE"), localEvsBook.getBookStatus(), "WAREHOUSE", localEvsPackage.getCompanyId(), localEvsWarehouse.getWarehouseId());
            List localList2 = this.packageDAO.getVoucherById(localList1.get(j).toString());
            List localList3 = this.evsVoucherDAO.findEvsVoucherByVoucherId(localList2);
            for (int k = 0; k < localList3.size(); k++)
            {
              EvsVoucher localEvsVoucher = (EvsVoucher)localList3.get(k);
              this.evsVoucherHistoryDAO.addHistoryNew(localEasUserInfo, 0L, localEvsVoucher.getVoucherId().toString(), EvsStatusUtil.getOperName("UNWAREHOUSE"), localEvsVoucher.getVoucherStatus(), "WAREHOUSE", localEvsPackage.getCompanyId(), localEvsWarehouse.getWarehouseId());
            }
          }
          this.packageDAO.updateBookStatusByPackage(str2, "WAREHOUSE");
          this.packageDAO.updateVoucherStatusByPackage(str2, "WAREHOUSE");
        }
      }
      str1 = "true";
      log.debug("update evs_package By PackageCode");
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("update failed", localRuntimeException);
      throw localRuntimeException;
    }
    return str1;
  }
  
  public TableDataInfo findPackage(EvsPackageModel paramEvsPackageModel, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    Map localMap = this.packageDAO.findPackage(paramEvsPackageModel, paramInt1, paramInt2);
    localTableDataInfo.setData((List)localMap.get("data"));
    localTableDataInfo.setTotalCount(Integer.parseInt(localMap.get("totalCount").toString()));
    return localTableDataInfo;
  }
  
  public String validateVoucherStatus(String paramString)
  {
    return this.packageDAO.validateVoucherStatus(paramString);
  }
  
  public void delPackToBook(List<String> paramList, String paramString)
  {
    StringBuffer localStringBuffer = getAllBookCode(paramList);
    List localList1 = this.packageDAO.findBookByPack(localStringBuffer.toString(), paramString);
    if (localList1.size() > 0)
    {
      EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
      EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
      EvsPackageModel localEvsPackageModel = new EvsPackageModel();
      localEvsPackageModel.setPackageId(Long.valueOf(paramString));
      EvsBook localEvsBook = (EvsBook)localList1.get(0);
      this.evsVoucherHistoryDAO.addHistory(localEasUserInfo, 1L, localEvsBook.getBookId().toString(), EvsStatusUtil.getOperName("PACKAGED"), localEvsBook.getBookStatus(), "BOOKED");
      this.packageDAO.delBookStatusByPackage(localEvsBook.getBookId().toString(), "BOOKED");
      this.packageDAO.cleanVoucherBookPackageByPackageId(localEvsBook.getBookId().toString());
      List localList2 = this.packageDAO.getVoucherById(localEvsBook.getBookId().toString());
      List localList3 = this.evsVoucherDAO.findEvsVoucherByVoucherId(localList2);
      for (int i = 0; i < localList3.size(); i++)
      {
        EvsVoucher localEvsVoucher = (EvsVoucher)localList3.get(i);
        this.evsVoucherHistoryDAO.addHistory(localEasUserInfo, 0L, localEvsVoucher.getVoucherId().toString(), EvsStatusUtil.getOperName("PACKAGED"), localEvsVoucher.getVoucherStatus(), "BOOKED_NO_BOX");
      }
      this.packageDAO.updateVoucherStatusByBookID(localEvsBook.getBookId().toString(), "BOOKED_NO_BOX");
    }
    else
    {
      this.packageDAO.updateReturnStatus(localStringBuffer.toString());
    }
  }
  
  public String validateVoucherStatusList(String paramString1, String paramString2)
  {
    return this.packageDAO.validateVoucherStatusList(paramString1, paramString2);
  }
  
  public List<EvsVoucher> getEvsVoucher(String paramString)
  {
    List localList1 = getVoucherById(paramString);
    List localList2 = this.evsVoucherDAO.findEvsVoucherByVoucherIds(localList1);
    return localList2;
  }
  
  public PageInfo findEvsVoucherByBookId(Long paramLong, int paramInt1, int paramInt2)
  {
    return this.evsVoucherDAO.findEvsVoucherByBookId(paramLong, paramInt1, paramInt2);
  }
  
  public PageInfo findImageByBookId(Long paramLong, int paramInt1, int paramInt2)
  {
    PageInfo localPageInfo = this.evsVoucherDAO.findImageByBookId(paramLong, paramInt1, paramInt2);
    return localPageInfo;
  }
  
  public IEvsVoucherDAO getEvsVoucherDAO()
  {
    return this.evsVoucherDAO;
  }
  
  public void setEvsVoucherDAO(IEvsVoucherDAO paramIEvsVoucherDAO)
  {
    this.evsVoucherDAO = paramIEvsVoucherDAO;
  }
  
  public IEvsWarehouseDAO getWarehouseDAO()
  {
    return this.warehouseDAO;
  }
  
  public void setWarehouseDAO(IEvsWarehouseDAO paramIEvsWarehouseDAO)
  {
    this.warehouseDAO = paramIEvsWarehouseDAO;
  }
  
  public EvsVoucher getVoucherByVoucherId(String paramString)
  {
    return this.evsVoucherDAO.findEvsVoucherVByVoucherId(Long.valueOf(paramString));
  }
  
  public TableDataInfo findVoucherByVoucherId(String paramString, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    Map localMap = null;
    localMap = this.evsVoucherDAO.findVoucherByVoucherId(paramString, paramInt1, paramInt2);
    localTableDataInfo.setData((List)localMap.get("data"));
    localTableDataInfo.setTotalCount(Integer.parseInt(localMap.get("totalCount").toString()));
    return localTableDataInfo;
  }
  
  public String checkSeachLimit(Long paramLong)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    return this.evsVoucherDAO.findEvsManageOrgVS(paramLong + "", localEasUserInfo.getUserInfoPk().toString());
  }
  
  public TableDataInfo findFascicule(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    Map localMap = null;
    localMap = this.evsVoucherDAO.findFascicule(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramInt1, paramInt2);
    List localList = (List)localMap.get("data");
    localTableDataInfo.setData(localList);
    localTableDataInfo.setTotalCount(Integer.parseInt(localMap.get("totalCount").toString()));
    return localTableDataInfo;
  }
  
  public List<EvsVoucherV> findFasciculeList(List<EvsVoucherV> paramList, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    List localList = this.evsVoucherDAO.findFasciculeByList(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < paramList.size(); i++) {
      localArrayList.add(((EvsVoucherV)paramList.get(i)).getVoucherId());
    }
    for (i = 0; i < localList.size(); i++) {
      if ((!paramList.contains(localList.get(i))) && (!localArrayList.contains(((EvsVoucherV)localList.get(i)).getVoucherId())))
      {
        paramList.add(localList.get(i));
        localArrayList.add(((EvsVoucherV)localList.get(i)).getVoucherId());
      }
    }
    for (i = 0; i < paramList.size(); i++)
    {
      EvsVoucherV localEvsVoucherV = (EvsVoucherV)paramList.get(i);
      if ((localEvsVoucherV.getSerialNum() == null) || (localEvsVoucherV.getSerialNum().equals(""))) {
        localEvsVoucherV.setSerialNum(i + 1 + "");
      }
    }
    return paramList;
  }
  
  public String findFasciculeListCheck(String paramString)
  {
    if (this.evsVoucherDAO.findFasciculeListCheck(paramString) == true) {
      return "SUCCESS";
    }
    return "ERROR";
  }
  
  public TableDataInfo getVoucherList(EvsBookModel paramEvsBookModel, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    Map localMap = null;
    localMap = this.evsVoucherDAO.getVoucherList(paramEvsBookModel, paramInt1, paramInt2);
    List localList = (List)localMap.get("data");
    localTableDataInfo.setData(localList);
    localTableDataInfo.setTotalCount(Integer.parseInt(localMap.get("totalCount").toString()));
    return localTableDataInfo;
  }
  
  public List<EvsVoucherV> getVoucherListByArr(EvsBookModel paramEvsBookModel)
  {
    List localList = this.evsVoucherDAO.getVoucherListByList(paramEvsBookModel);
    return localList;
  }
  
  public List<EvsVoucherBookPackage> getVoucherListForL(EvsBookModel paramEvsBookModel)
  {
    return this.evsVoucherDAO.getVoucherListForL(paramEvsBookModel);
  }
  
  public List<EvsVoucherBookPackage> getVoucherListForL2(EvsBookModel paramEvsBookModel)
  {
    return this.evsVoucherDAO.getVoucherListForL2(paramEvsBookModel);
  }
  
  public IFbpCompanyVDAO getFbpCompanyVDAO()
  {
    return this.fbpCompanyVDAO;
  }
  
  public void setFbpCompanyVDAO(IFbpCompanyVDAO paramIFbpCompanyVDAO)
  {
    this.fbpCompanyVDAO = paramIFbpCompanyVDAO;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.eBillManage.EvsPackageService
 * JD-Core Version:    0.7.0.1
 */