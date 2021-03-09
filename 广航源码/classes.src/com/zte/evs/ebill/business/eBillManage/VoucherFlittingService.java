package com.zte.evs.ebill.business.eBillManage;

import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.eas.infomap.business.notice.model.FbpNoticesNew;
import com.zte.eas.infomap.business.notice.service.IFbpNoticesNewDS;
import com.zte.eas.organization.business.countcompanymanage.model.FbpCompanyV;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesLovV;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesV;
import com.zte.evs.ebill.access.eBillManage.EvsVoucherDAO;
import com.zte.evs.ebill.access.eBillManage.EvsVoucherHistoryDAO;
import com.zte.evs.ebill.access.eBillManage.GenerateNumberModel;
import com.zte.evs.ebill.access.eBillManage.IEvsBookDAO;
import com.zte.evs.ebill.access.eBillManage.IEvsPackageDAO;
import com.zte.evs.ebill.access.eBillManage.IEvsVoucherHistoryDAO;
import com.zte.evs.ebill.access.eBillManage.IGenerateNumberDAO;
import com.zte.evs.ebill.access.eBillManage.IVoucherFlittingDAO;
import com.zte.evs.ebill.business.archives.IFbpArchivesHeadersDS;
import com.zte.evs.ebill.common.EvsObjectUtils;
import com.zte.evs.ebill.common.EvsStatusUtil;
import com.zte.evs.ebill.common.JsonUtils;
import com.zte.evs.ebill.model.archives.FindEmployeesV;
import com.zte.evs.ebill.model.eBillManage.DepositAddressModel;
import com.zte.evs.ebill.model.eBillManage.EvsAllotDetails;
import com.zte.evs.ebill.model.eBillManage.EvsAllotHeaders;
import com.zte.evs.ebill.model.eBillManage.EvsAllotHeadersV;
import com.zte.evs.ebill.model.eBillManage.EvsBook;
import com.zte.evs.ebill.model.eBillManage.EvsBookModel;
import com.zte.evs.ebill.model.eBillManage.EvsBookV;
import com.zte.evs.ebill.model.eBillManage.EvsInventory;
import com.zte.evs.ebill.model.eBillManage.EvsPackageModel;
import com.zte.evs.ebill.model.eBillManage.EvsPackageV;
import com.zte.evs.ebill.model.eBillManage.EvsStorageDoc;
import com.zte.evs.ebill.model.eBillManage.EvsVoucher;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherBookPackage;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherHistory;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherHistoryV;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.util.Util;
import com.zte.ssb.servicecontainer.business.server.ISession;
import com.zte.ssb.servicecontainer.business.server.RIAContext;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class VoucherFlittingService
  implements IVoucherFlittingService
{
  private IVoucherFlittingDAO voucherFlittingDAO;
  public static final String EAS_LOGIN_USERINFO = "easloginuserinfo";
  private IEvsPackageDAO packageDAO;
  private IEvsVoucherHistoryDAO evsVoucherHistoryDAO;
  private IEvsBookDAO bookDAO;
  IFbpArchivesHeadersDS fbpArchivesHeadersDS;
  
  public IFbpArchivesHeadersDS getFbpArchivesHeadersDS()
  {
    return this.fbpArchivesHeadersDS;
  }
  
  public void setFbpArchivesHeadersDS(IFbpArchivesHeadersDS paramIFbpArchivesHeadersDS)
  {
    this.fbpArchivesHeadersDS = paramIFbpArchivesHeadersDS;
  }
  
  public IEvsBookDAO getBookDAO()
  {
    return this.bookDAO;
  }
  
  public void setBookDAO(IEvsBookDAO paramIEvsBookDAO)
  {
    this.bookDAO = paramIEvsBookDAO;
  }
  
  public IEvsVoucherHistoryDAO getEvsVoucherHistoryDAO()
  {
    return this.evsVoucherHistoryDAO;
  }
  
  public void setEvsVoucherHistoryDAO(IEvsVoucherHistoryDAO paramIEvsVoucherHistoryDAO)
  {
    this.evsVoucherHistoryDAO = paramIEvsVoucherHistoryDAO;
  }
  
  public IEvsPackageDAO getPackageDAO()
  {
    return this.packageDAO;
  }
  
  public void setPackageDAO(IEvsPackageDAO paramIEvsPackageDAO)
  {
    this.packageDAO = paramIEvsPackageDAO;
  }
  
  public List<String> findEmpCheckUtil(String paramString)
  {
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    ISession localISession = localRIAContext.getSession();
    EasUserInfo localEasUserInfo = (EasUserInfo)localISession.getSessionAttribute("easloginuserinfo");
    String str;
    if ((paramString != null) && (!"".equals(paramString))) {
      str = paramString;
    } else {
      str = localEasUserInfo.getUserId();
    }
    return this.voucherFlittingDAO.findEmpCheckUtil(str);
  }
  
  public List<String[]> findAllotType(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return this.voucherFlittingDAO.findAllotType(paramString1, paramString2, paramString3, paramString4);
  }
  
  public List<String[]> findStoreCheckUnit(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return this.voucherFlittingDAO.findStoreCheckUnit(paramString1, paramString2, paramString3, paramString4);
  }
  
  public List<String[]> findStoreSit(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return this.voucherFlittingDAO.findStoreSit(paramString1, paramString2, paramString3, paramString4);
  }
  
  public String getFlittingBoeNum(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    ISession localISession = localRIAContext.getSession();
    EasUserInfo localEasUserInfo = (EasUserInfo)localISession.getSessionAttribute("easloginuserinfo");
    FbpEmployeesV localFbpEmployeesV = this.voucherFlittingDAO.getEmpVInfo(localEasUserInfo.getUserId());
    IGenerateNumberDAO localIGenerateNumberDAO = (IGenerateNumberDAO)SSBBus.findDomainService("generateNumberDAO");
    GenerateNumberModel localGenerateNumberModel = new GenerateNumberModel();
    localGenerateNumberModel.setDeptCode(localFbpEmployeesV.getDeptCode());
    localGenerateNumberModel.setNumberType("EVS-FLITTING_BOE");
    localGenerateNumberModel.setPeriodName(paramString2);
    localGenerateNumberModel.setDepotFold(paramString3);
    localGenerateNumberModel.setDepotMove(paramString4);
    String str = localIGenerateNumberDAO.generateNumber(localGenerateNumberModel);
    return str;
  }
  
  public String getFlittingAllotBoeNum(String paramString)
  {
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    ISession localISession = localRIAContext.getSession();
    EasUserInfo localEasUserInfo = (EasUserInfo)localISession.getSessionAttribute("easloginuserinfo");
    FbpEmployeesV localFbpEmployeesV = this.voucherFlittingDAO.getEmpVInfo(localEasUserInfo.getUserId());
    String str = this.packageDAO.getGenerarionAllotNmber(localFbpEmployeesV.getEmployeeId().toString());
    return str;
  }
  
  public String updateFlittingBoeForBook(EvsAllotHeaders paramEvsAllotHeaders, String paramString, EvsInventory paramEvsInventory)
    throws Exception
  {
    try
    {
      EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
      List localList1 = (List)localEvsObjectUtils.getUserInfoSession().getAttribute("SESSION_WAREHOUSE_CODE");
      if ((localList1 != null) && (localList1.size() > 0))
      {
        EvsBook localEvsBook1 = this.bookDAO.getBookByCode((String)localList1.get(0));
        RIAContext localRIAContext = RIAContext.getCurrentInstance();
        ISession localISession = localRIAContext.getSession();
        EasUserInfo localEasUserInfo = (EasUserInfo)localISession.getSessionAttribute("easloginuserinfo");
        FbpEmployeesV localFbpEmployeesV = this.voucherFlittingDAO.getEmpVInfo(localEasUserInfo.getUserId());
        EvsInventory localEvsInventory = this.voucherFlittingDAO.getEvsInventoryCan(localEvsBook1.getBookId().toString());
        String str1 = null;
        String str2 = null;
        String str3 = "";
        DepositAddressModel localDepositAddressModel = new DepositAddressModel();
        if (paramEvsInventory != null)
        {
          localDepositAddressModel.setInvArea(paramEvsInventory.getInvArea());
          localDepositAddressModel.setInvCityId(paramEvsInventory.getInvCityId());
          localDepositAddressModel.setInvColumn(paramEvsInventory.getInvColumn());
          localDepositAddressModel.setInvLevel(paramEvsInventory.getInvLevel());
          localDepositAddressModel.setInvRow(paramEvsInventory.getInvRow());
          localDepositAddressModel.setInvStorageCode(paramEvsInventory.getInvStorageCode());
          localObject1 = new EvsStorageDoc();
          ((EvsStorageDoc)localObject1).setStorageCode(paramEvsInventory.getInvStorageCode());
          localObject2 = this.bookDAO.findEvsStorageDocByEvsStorageDoc((EvsStorageDoc)localObject1);
          str1 = paramEvsInventory.getInvStorageCode();
          if ((str1 != null) && (str1.length() > 2)) {
            str3 = str3 + str1.substring(0, 2);
          }
          if (localObject2 != null) {
            paramEvsAllotHeaders.setAttribute8(((EvsStorageDoc)localObject2).getStorageId() + "");
          }
        }
        if (localEvsInventory != null)
        {
          str2 = localEvsInventory.getInvStorageCode();
          if ((str2 != null) && (str2.length() > 2)) {
            str3 = str3 + "#" + str2.substring(0, 2);
          }
        }
        Object localObject1 = JsonUtils.beanToJson(localDepositAddressModel);
        paramEvsAllotHeaders = addFlittingInvoicesHeader(paramEvsAllotHeaders, localFbpEmployeesV, "FLITTING_FOR_BOOK", str3);
        this.evsVoucherHistoryDAO.addHistoryNews(localEasUserInfo, 3L, paramEvsAllotHeaders.getAllotHeaderId().toString(), "调拨", "NOW_FLITTING", "NOW_FLITTING", paramEvsAllotHeaders.getCompanyId(), (String)localObject1);
        Object localObject2 = new EvsAllotDetails();
        if ((localList1 != null) && (localList1.size() > 0))
        {
          Iterator localIterator = localList1.iterator();
          while (localIterator.hasNext())
          {
            String str4 = (String)localIterator.next();
            try
            {
              str4 = str4.trim();
              EvsBook localEvsBook2 = this.bookDAO.getBookByCode(str4);
              if (localEvsBook2 != null)
              {
                localObject2 = addFlittingInvoicesLine(paramEvsAllotHeaders, localEvsBook2.getBookId().toString(), "FLITTING_FOR_BOOK", localFbpEmployeesV);
                this.packageDAO.updateStatusByBookId(str4, "NOW_FLITTING");
                this.evsVoucherHistoryDAO.addHistoryNews(localEasUserInfo, 1L, localEvsBook2.getBookId().toString(), "调拨", localEvsBook2.getBookStatus(), "NOW_FLITTING", paramEvsAllotHeaders.getCompanyId(), (String)localObject1);
                List localList2 = this.packageDAO.getVoucherById(localEvsBook2.getBookId().toString());
                if ((localList2 != null) && (localList2.size() > 0))
                {
                  for (int i = 0; i < localList2.size(); i++)
                  {
                    String str5 = localList2.get(i) == null ? "" : localList2.get(i).toString();
                    EvsVoucher localEvsVoucher = this.bookDAO.findVoucherById(str5);
                    if (localEvsVoucher != null) {
                      this.evsVoucherHistoryDAO.addHistoryNews(localEasUserInfo, 0L, str5, "调拨", localEvsVoucher.getVoucherStatus(), "NOW_FLITTING", paramEvsAllotHeaders.getCompanyId(), (String)localObject1);
                    }
                  }
                  this.packageDAO.updateVoucherStatusByBookCodeNew(localEvsBook2.getBookId().toString(), "NOW_FLITTING");
                }
                paramEvsInventory.setBookId(localEvsBook2.getBookId());
                this.voucherFlittingDAO.updateInventoryByBookId(paramEvsInventory);
              }
            }
            catch (Exception localException2)
            {
              localException2.printStackTrace();
              throw localException2;
            }
          }
        }
        else
        {
          this.voucherFlittingDAO.delFlittingInvoicesHeader(paramEvsAllotHeaders.getAllotHeaderId());
          return "no";
        }
      }
      else
      {
        return "no";
      }
      return paramEvsAllotHeaders.getAllotNum();
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
      throw localException1;
    }
  }
  
  public EvsAllotHeaders findEvsAllotHeaders(String paramString)
  {
    EvsAllotHeaders localEvsAllotHeaders = this.voucherFlittingDAO.getEvsAllotHeadersByAllotNum(paramString);
    if (localEvsAllotHeaders != null)
    {
      EvsStorageDoc localEvsStorageDoc = this.bookDAO.findEvsStorageDoc(Long.valueOf(localEvsAllotHeaders.getAttribute8()));
      if (localEvsStorageDoc != null) {
        localEvsAllotHeaders.setStorageStr(localEvsStorageDoc.getStorageName());
      }
      FbpEmployeesLovV localFbpEmployeesLovV = this.voucherFlittingDAO.getEmpLovVInfo(localEvsAllotHeaders.getReceiveBy().toString());
      if (localFbpEmployeesLovV != null) {
        localEvsAllotHeaders.setReceiveByStr(localFbpEmployeesLovV.getEmployeeName());
      }
      FbpCompanyV localFbpCompanyV = this.voucherFlittingDAO.getCompanyById(localEvsAllotHeaders.getAttribute7());
      if (localFbpCompanyV != null) {
        localEvsAllotHeaders.setCompanyStr(localFbpCompanyV.getCompanyName());
      }
    }
    return localEvsAllotHeaders;
  }
  
  public String saveFlittingBoeForBook(EvsAllotHeaders paramEvsAllotHeaders, String paramString)
    throws Exception
  {
    try
    {
      EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
      List localList = (List)localEvsObjectUtils.getUserInfoSession().getAttribute("SESSION_WAREHOUSE_BOOKID");
      if ((localList != null) && (localList.size() > 0))
      {
        EvsBook localEvsBook1 = this.bookDAO.getEvsBookById((Long)localList.get(0));
        RIAContext localRIAContext = RIAContext.getCurrentInstance();
        ISession localISession = localRIAContext.getSession();
        EasUserInfo localEasUserInfo = (EasUserInfo)localISession.getSessionAttribute("easloginuserinfo");
        FbpEmployeesV localFbpEmployeesV = this.voucherFlittingDAO.getEmpVInfo(localEasUserInfo.getUserId());
        EvsInventory localEvsInventory = this.voucherFlittingDAO.getEvsInventoryCan(localEvsBook1.getBookId().toString());
        String str1 = null;
        String str2 = null;
        String str3 = "";
        DepositAddressModel localDepositAddressModel = new DepositAddressModel();
        if ((paramEvsAllotHeaders.getAttribute8() != null) && (!"".equals(paramEvsAllotHeaders.getAttribute8())))
        {
          localObject1 = this.bookDAO.findEvsStorageDoc(Long.valueOf(paramEvsAllotHeaders.getAttribute8()));
          if (localObject1 != null)
          {
            localDepositAddressModel.setInvStorageCode(((EvsStorageDoc)localObject1).getStorageCode());
            localDepositAddressModel.setInvCityId(((EvsStorageDoc)localObject1).getCityId() + "");
            str1 = ((EvsStorageDoc)localObject1).getStorageCode();
            str3 = str3 + str1;
          }
        }
        if (localEvsInventory != null)
        {
          str2 = localEvsInventory.getInvStorageCode();
          str3 = str3 + "#" + str2;
        }
        Object localObject1 = JsonUtils.beanToJson(localDepositAddressModel);
        paramEvsAllotHeaders = addFlittingInvoicesHeader(paramEvsAllotHeaders, localFbpEmployeesV, "FLITTING_FOR_BOOK", str3);
        this.evsVoucherHistoryDAO.addHistoryNews(localEasUserInfo, 3L, paramEvsAllotHeaders.getAllotHeaderId().toString(), "调拨", "NOW_FLITTING", "NOW_FLITTING", paramEvsAllotHeaders.getCompanyId(), (String)localObject1);
        EvsAllotDetails localEvsAllotDetails = new EvsAllotDetails();
        if ((localList != null) && (localList.size() > 0))
        {
          Iterator localIterator = localList.iterator();
          while (localIterator.hasNext())
          {
            Long localLong = (Long)localIterator.next();
            try
            {
              EvsBook localEvsBook2 = this.bookDAO.getEvsBookById(localLong);
              if (localEvsBook2 != null)
              {
                localEvsAllotDetails = addFlittingInvoicesLine(paramEvsAllotHeaders, localEvsBook2.getBookId().toString(), "FLITTING_FOR_BOOK", localFbpEmployeesV);
                this.packageDAO.updateStatusByBookId(localLong.toString(), "NOW_FLITTING");
                this.evsVoucherHistoryDAO.addHistoryNews(localEasUserInfo, 1L, localEvsBook2.getBookId().toString(), "调拨", localEvsBook2.getBookStatus(), "NOW_FLITTING", paramEvsAllotHeaders.getCompanyId(), (String)localObject1);
                EvsVoucherDAO localEvsVoucherDAO = (EvsVoucherDAO)SSBBus.findDomainService("evsVoucherDAO");
                Object localObject3;
                Object localObject4;
                if (localEvsBook2.getBookBreakFlag().equals("Y"))
                {
                  localObject2 = this.voucherFlittingDAO.getEvsVoucherByBookId(localEvsBook2.getBookId());
                  localObject3 = ((List)localObject2).iterator();
                  while (((Iterator)localObject3).hasNext())
                  {
                    localObject4 = (EvsVoucherBookPackage)((Iterator)localObject3).next();
                    EvsVoucher localEvsVoucher = localEvsVoucherDAO.findEvsVoucherVByVoucherId(((EvsVoucherBookPackage)localObject4).getVoucherId());
                    this.evsVoucherHistoryDAO.addHistoryNews(localEasUserInfo, 0L, ((EvsVoucherBookPackage)localObject4).getVoucherId().toString(), "调拨", localEvsVoucher.getVoucherStatus(), "NOW_FLITTING", paramEvsAllotHeaders.getCompanyId(), (String)localObject1);
                    localEvsVoucher.setVoucherStatus("NOW_FLITTING");
                    this.voucherFlittingDAO.updateEvsVoucher(localEvsVoucher);
                  }
                }
                else if (localEvsBook2.getBookBreakFlag().equals("N"))
                {
                  localObject2 = localEvsVoucherDAO.findEvsVoucherVByBookId(localEvsBook2.getBookId());
                  localObject3 = ((List)localObject2).iterator();
                  while (((Iterator)localObject3).hasNext())
                  {
                    localObject4 = (EvsVoucher)((Iterator)localObject3).next();
                    this.evsVoucherHistoryDAO.addHistoryNews(localEasUserInfo, 0L, ((EvsVoucher)localObject4).getVoucherId().toString(), "调拨", ((EvsVoucher)localObject4).getVoucherStatus(), "NOW_FLITTING", paramEvsAllotHeaders.getCompanyId(), (String)localObject1);
                    ((EvsVoucher)localObject4).setVoucherStatus("NOW_FLITTING");
                    this.voucherFlittingDAO.updateEvsVoucher((EvsVoucher)localObject4);
                  }
                }
                Object localObject2 = new EvsInventory();
                ((EvsInventory)localObject2).setBookId(Long.valueOf(localLong.longValue()));
                if ((paramEvsAllotHeaders.getAttribute8() != null) && (!"".equals(paramEvsAllotHeaders.getAttribute8())))
                {
                  localObject3 = this.bookDAO.findEvsStorageDoc(Long.valueOf(paramEvsAllotHeaders.getAttribute8()));
                  if (localObject3 != null)
                  {
                    ((EvsInventory)localObject2).setInvStorageCode(((EvsStorageDoc)localObject3).getStorageCode());
                    ((EvsInventory)localObject2).setInvCityId(((EvsStorageDoc)localObject3).getCityId() + "");
                  }
                }
                this.voucherFlittingDAO.updateInventoryByBookId((EvsInventory)localObject2);
              }
            }
            catch (Exception localException2)
            {
              localException2.printStackTrace();
              throw localException2;
            }
          }
        }
        else
        {
          this.voucherFlittingDAO.delFlittingInvoicesHeader(paramEvsAllotHeaders.getAllotHeaderId());
          return "no";
        }
        return paramEvsAllotHeaders.getAllotNum();
      }
      return "no";
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
      throw localException1;
    }
  }
  
  public String saveFlittingBoeForVoucher(EvsAllotHeaders paramEvsAllotHeaders, String[] paramArrayOfString, String paramString)
  {
    try
    {
      RIAContext localRIAContext = RIAContext.getCurrentInstance();
      ISession localISession = localRIAContext.getSession();
      EasUserInfo localEasUserInfo = (EasUserInfo)localISession.getSessionAttribute("easloginuserinfo");
      FbpEmployeesV localFbpEmployeesV = this.voucherFlittingDAO.getEmpVInfo(localEasUserInfo.getUserId());
      paramEvsAllotHeaders = addFlittingInvoicesHeader(paramEvsAllotHeaders, localFbpEmployeesV, "FLITTING_FOR_VOUCHER", paramString);
      this.evsVoucherHistoryDAO.addHistoryNew(localEasUserInfo, 3L, paramEvsAllotHeaders.getAllotHeaderId().toString(), "调拨", "NOW_FLITTING", "NOW_FLITTING", paramEvsAllotHeaders.getCompanyId(), paramEvsAllotHeaders.getArchivesSiteId());
      EvsAllotDetails localEvsAllotDetails = new EvsAllotDetails();
      if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {
        for (String str : paramArrayOfString)
        {
          EvsVoucherDAO localEvsVoucherDAO = (EvsVoucherDAO)SSBBus.findDomainService("evsVoucherDAO");
          EvsVoucher localEvsVoucher = localEvsVoucherDAO.getEvsVoucherByCode(str);
          localEvsAllotDetails = addFlittingInvoicesLine(paramEvsAllotHeaders, localEvsVoucher.getVoucherId().toString(), "FLITTING_FOR_VOUCHER", localFbpEmployeesV);
          this.evsVoucherHistoryDAO.addHistoryNew(localEasUserInfo, 0L, localEvsVoucher.getVoucherId().toString(), "调拨", localEvsVoucher.getVoucherStatus(), "NOW_FLITTING", paramEvsAllotHeaders.getCompanyId(), paramEvsAllotHeaders.getArchivesSiteId());
          localEvsVoucher.setVoucherStatus("NOW_FLITTING");
          localEvsVoucherDAO.updateObject(localEvsVoucher);
        }
      }
      return paramEvsAllotHeaders.getAllotNum();
    }
    catch (RuntimeException localRuntimeException)
    {
      localRuntimeException.printStackTrace();
    }
    return "";
  }
  
  public EvsAllotHeaders addFlittingInvoicesHeader(EvsAllotHeaders paramEvsAllotHeaders, FbpEmployeesV paramFbpEmployeesV, String paramString1, String paramString2)
  {
    try
    {
      EvsAllotHeaders localEvsAllotHeaders = null;
      if (paramEvsAllotHeaders == null) {
        paramEvsAllotHeaders = new EvsAllotHeaders();
      }
      if (paramEvsAllotHeaders.getAllotNum() != null) {
        localEvsAllotHeaders = this.voucherFlittingDAO.getEvsAllotHeadersByAllotNum(paramEvsAllotHeaders.getAllotNum());
      }
      if (paramEvsAllotHeaders.getAllotHeaderId() != null) {
        localEvsAllotHeaders = this.voucherFlittingDAO.getEvsAllotHeaders(paramEvsAllotHeaders.getAllotHeaderId());
      }
      if (localEvsAllotHeaders != null) {
        paramEvsAllotHeaders.setAllotHeaderId(localEvsAllotHeaders.getAllotHeaderId());
      }
      paramEvsAllotHeaders.setLastUpdateDate(new Date());
      paramEvsAllotHeaders.setLastUpdatedBy(Long.valueOf(paramFbpEmployeesV.getEmployeeId().longValue()));
      paramEvsAllotHeaders.setCreationDate(new Date());
      paramEvsAllotHeaders.setAllotDate(new Date());
      paramEvsAllotHeaders.setCompanyId(paramFbpEmployeesV.getCompanyId());
      paramEvsAllotHeaders.setCreatedBy(Long.valueOf(paramFbpEmployeesV.getEmployeeId().longValue()));
      paramEvsAllotHeaders.setEnabledFlag("Y");
      String str1 = "";
      if (paramEvsAllotHeaders.getAllotNum() != null)
      {
        str1 = paramEvsAllotHeaders.getAllotNum();
      }
      else
      {
        String str2 = null;
        String str3 = null;
        if ((paramString2 != null) && (paramString2.indexOf("#") > -1))
        {
          String[] arrayOfString = paramString2.split("#");
          if (arrayOfString.length > 1)
          {
            str2 = arrayOfString[0];
            str3 = arrayOfString[1];
          }
        }
        str1 = getFlittingBoeNum(paramString2, "", str2, str3);
        if (!Util.isNullObject(str1))
        {
          if (str1.equals("-2")) {
            return null;
          }
          if (str1.equals("-")) {
            return null;
          }
        }
        paramEvsAllotHeaders.setAllotNum(str1);
      }
      paramEvsAllotHeaders.setAllotBy(paramFbpEmployeesV.getEmployeeId());
      paramEvsAllotHeaders.setAllotMode(paramString1);
      paramEvsAllotHeaders.setAllotStatus("NOW_FLITTING");
      this.voucherFlittingDAO.addFlittingInvoicesHeader(paramEvsAllotHeaders);
      this.voucherFlittingDAO.delEvsAllotHeadersByDetails(paramEvsAllotHeaders.getAllotHeaderId());
      if (this.fbpArchivesHeadersDS == null) {
        this.fbpArchivesHeadersDS = ((IFbpArchivesHeadersDS)SSBBus.findDomainService("fbpArchivesHeadersDS"));
      }
      this.fbpArchivesHeadersDS.clickSendEmailorSmsOne(str1);
      return paramEvsAllotHeaders;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
  }
  
  public EvsAllotDetails addFlittingInvoicesLine(EvsAllotHeaders paramEvsAllotHeaders, String paramString1, String paramString2, FbpEmployeesV paramFbpEmployeesV)
  {
    try
    {
      EvsAllotDetails localEvsAllotDetails = new EvsAllotDetails();
      localEvsAllotDetails.setLastUpdateDate(new Date());
      localEvsAllotDetails.setLastUpdatedBy(Long.valueOf(paramFbpEmployeesV.getEmployeeId().longValue()));
      localEvsAllotDetails.setCreationDate(new Date());
      localEvsAllotDetails.setCreatedBy(Long.valueOf(paramFbpEmployeesV.getEmployeeId().longValue()));
      localEvsAllotDetails.setEnabledFlag("Y");
      localEvsAllotDetails.setAllotHeaderId(paramEvsAllotHeaders.getAllotHeaderId());
      localEvsAllotDetails.setRelationType(paramString2);
      this.packageDAO.updateStatusByBookId(paramString1, "ALREADY_FLITTING");
      localEvsAllotDetails.setRelationId(Long.valueOf(Long.parseLong(paramString1)));
      this.voucherFlittingDAO.addFlittingInvoicesLine(localEvsAllotDetails);
      return localEvsAllotDetails;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
  }
  
  public String saveFlittingBoeForBox(EvsAllotHeaders paramEvsAllotHeaders, String[] paramArrayOfString, String paramString)
  {
    try
    {
      RIAContext localRIAContext = RIAContext.getCurrentInstance();
      ISession localISession = localRIAContext.getSession();
      EasUserInfo localEasUserInfo = (EasUserInfo)localISession.getSessionAttribute("easloginuserinfo");
      FbpEmployeesV localFbpEmployeesV = this.voucherFlittingDAO.getEmpVInfo(localEasUserInfo.getUserId());
      paramEvsAllotHeaders = addFlittingInvoicesHeader(paramEvsAllotHeaders, localFbpEmployeesV, "FLITTING_FOR_BOX", paramString);
      this.evsVoucherHistoryDAO.addHistoryNew(localEasUserInfo, 3L, paramEvsAllotHeaders.getAllotHeaderId().toString(), "调拨", "NOW_FLITTING", "NOW_FLITTING", paramEvsAllotHeaders.getCompanyId(), paramEvsAllotHeaders.getArchivesSiteId());
      EvsAllotDetails localEvsAllotDetails = new EvsAllotDetails();
      if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {
        for (String str1 : paramArrayOfString)
        {
          localEvsAllotDetails = addFlittingInvoicesLine(paramEvsAllotHeaders, str1, "FLITTING_FOR_BOX", localFbpEmployeesV);
          PageInfo localPageInfo = this.packageDAO.getPackageByPackageId(new String[] { str1 }, "FLITTING", 1, 2);
          List localList1 = (List)localPageInfo.getResult();
          if ((localList1 != null) && (localList1.size() > 0)) {
            this.evsVoucherHistoryDAO.addHistoryNew(localEasUserInfo, 2L, str1, "调拨", ((EvsPackageV)localList1.get(0)).getPackageStatus(), "NOW_FLITTING", paramEvsAllotHeaders.getCompanyId(), paramEvsAllotHeaders.getArchivesSiteId());
          }
          List localList2 = this.packageDAO.getBookByPackageId(str1);
          if ((localList2 != null) && (localList2.size() > 0))
          {
            Iterator localIterator = localList2.iterator();
            while (localIterator.hasNext())
            {
              EvsBook localEvsBook = (EvsBook)localIterator.next();
              this.evsVoucherHistoryDAO.addHistoryNew(localEasUserInfo, 1L, localEvsBook.getBookId().toString(), "调拨", localEvsBook.getBookStatus(), "NOW_FLITTING", paramEvsAllotHeaders.getCompanyId(), paramEvsAllotHeaders.getArchivesSiteId());
              List localList3 = this.packageDAO.getVoucherById(localEvsBook.getBookId().toString());
              if ((localList3 != null) && (localList3.size() > 0)) {
                for (int k = 0; k < localList3.size(); k++)
                {
                  String str2 = localList3.get(k) == null ? "" : localList3.get(k).toString();
                  this.evsVoucherHistoryDAO.addHistoryNew(localEasUserInfo, 0L, str2, "调拨", localEvsBook.getBookStatus(), "NOW_FLITTING", paramEvsAllotHeaders.getCompanyId(), paramEvsAllotHeaders.getArchivesSiteId());
                }
              }
              this.packageDAO.updateVoucherStatusByBookCodeNew(localEvsBook.getBookId().toString(), "NOW_FLITTING");
            }
          }
          this.packageDAO.updateBookStatusByPackageIdNew(str1, "NOW_FLITTING");
          this.packageDAO.updateStatusByPackageId(str1, "NOW_FLITTING");
        }
      }
      return paramEvsAllotHeaders.getAllotNum();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
  
  public TableDataInfo findAllotHeaders(EvsAllotHeadersV paramEvsAllotHeadersV, String paramString1, String paramString2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    if ((paramString1 != null) && (!"".equals(paramString1)) && (paramString2 != null) && (!"".equals(paramString2)))
    {
      PageInfo localPageInfo = this.voucherFlittingDAO.findAllotHeaders(paramEvsAllotHeadersV, new Integer(paramString1), new Integer(paramString2));
      List localList1 = (List)localPageInfo.getResult();
      for (int i = 0; i < localList1.size(); i++)
      {
        EvsAllotHeaders localEvsAllotHeaders = (EvsAllotHeaders)localList1.get(i);
        if ("ALREADY_RETURN".equals(localEvsAllotHeaders.getAllotStatus()))
        {
          localObject = this.voucherFlittingDAO.findHistoryByObjectCodeNew(localEvsAllotHeaders.getAllotHeaderId().toString(), 3, 1, 2);
          if ((localObject != null) && (((PageInfo)localObject).getResult() != null))
          {
            List localList2 = (List)((PageInfo)localObject).getResult();
            if ((localList2 != null) && (localList2.size() > 0))
            {
              EvsVoucherHistoryV localEvsVoucherHistoryV = (EvsVoucherHistoryV)localList2.get(0);
              String str = localEvsVoucherHistoryV.getCheckComment();
              if (!Util.isStrEmpty(str)) {
                ((EvsAllotHeaders)localList1.get(i)).setAttribute8(str);
              }
            }
          }
        }
        else
        {
          ((EvsAllotHeaders)localList1.get(i)).setAttribute8("");
        }
        if ("NOW_FLITTING".equals(localEvsAllotHeaders.getAllotStatus())) {
          ((EvsAllotHeaders)localList1.get(i)).setAttribute8(localEvsAllotHeaders.getAllotDesc());
        }
        Object localObject = this.voucherFlittingDAO.getEmpLovVInfo(localEvsAllotHeaders.getAllotBy().toString());
        if (localObject != null) {
          ((EvsAllotHeaders)localList1.get(i)).setAttribute5(((FbpEmployeesLovV)localObject).getEmployeeName());
        }
        ((EvsAllotHeaders)localList1.get(i)).setAttribute6(EvsStatusUtil.getVoucherStatusName(localEvsAllotHeaders.getAllotStatus()));
      }
      localTableDataInfo.setData(localList1);
      localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
    }
    return localTableDataInfo;
  }
  
  public EvsAllotHeaders findAllotHeaders1(BigInteger paramBigInteger)
  {
    return this.voucherFlittingDAO.getEvsAllotHeaders(paramBigInteger);
  }
  
  public TableDataInfo findAllotHeadersV2(EvsAllotHeadersV paramEvsAllotHeadersV, String paramString1, String paramString2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    if ((paramString1 != null) && (!"".equals(paramString1)) && (paramString2 != null) && (!"".equals(paramString2)))
    {
      PageInfo localPageInfo = this.voucherFlittingDAO.findAllotHeadersV2(paramEvsAllotHeadersV, new Integer(paramString1), new Integer(paramString2));
      FindEmployeesV localFindEmployeesV = this.voucherFlittingDAO.findEmployeesLoginV();
      List localList = (List)localPageInfo.getResult();
      for (int i = 0; i < localList.size(); i++)
      {
        EvsAllotHeadersV localEvsAllotHeadersV = (EvsAllotHeadersV)localList.get(i);
        localEvsAllotHeadersV.setUserLoginId(localFindEmployeesV.getEmployeeId());
      }
      localTableDataInfo.setData(localList);
      localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
    }
    return localTableDataInfo;
  }
  
  public TableDataInfo findAllotHeadersByIncept(EvsAllotHeadersV paramEvsAllotHeadersV, String paramString1, String paramString2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    if ((paramString1 != null) && (!"".equals(paramString1)) && (paramString2 != null) && (!"".equals(paramString2)))
    {
      PageInfo localPageInfo = this.voucherFlittingDAO.findAllotHeadersByIncept(paramEvsAllotHeadersV, new Integer(paramString1), new Integer(paramString2));
      localTableDataInfo.setData((List)localPageInfo.getResult());
      localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
    }
    return localTableDataInfo;
  }
  
  public String removeAllotHeadersById(Long paramLong)
  {
    String str1 = "fail";
    if ((paramLong == null) || (paramLong.equals(""))) {
      return str1;
    }
    EvsAllotHeaders localEvsAllotHeaders = this.voucherFlittingDAO.getEvsAllotHeaders(BigInteger.valueOf(paramLong.longValue()));
    if ("REMOVE_FLITTING".equals(localEvsAllotHeaders.getAllotStatus()))
    {
      str1 = "alreadyRemove";
      return str1;
    }
    if ("ALREADY_RECEIVE".equals(localEvsAllotHeaders.getAllotStatus()))
    {
      str1 = "alreadyIncept";
      return str1;
    }
    if (localEvsAllotHeaders != null)
    {
      String str2 = "";
      PageInfo localPageInfo = this.voucherFlittingDAO.findHistoryByObjectCodeNew(localEvsAllotHeaders.getAllotHeaderId().toString(), 3, 0, 5);
      List localList1 = (List)localPageInfo.getResult();
      if ((localList1 != null) && (localList1.size() > 0)) {
        for (int i = 0; i < localList1.size(); i++) {
          if (!Util.isStrEmpty(((EvsVoucherHistoryV)localList1.get(i)).getAddress()))
          {
            str2 = ((EvsVoucherHistoryV)localList1.get(0)).getAddress();
            break;
          }
        }
      }
      RIAContext localRIAContext = RIAContext.getCurrentInstance();
      ISession localISession = localRIAContext.getSession();
      EasUserInfo localEasUserInfo = (EasUserInfo)localISession.getSessionAttribute("easloginuserinfo");
      this.evsVoucherHistoryDAO.addHistoryNews(localEasUserInfo, 3L, localEvsAllotHeaders.getAllotHeaderId().toString(), "撤销", "NOW_FLITTING", "REMOVE_FLITTING", localEvsAllotHeaders.getCompanyId(), str2);
      localEvsAllotHeaders.setAllotStatus("REMOVE_FLITTING");
      localEvsAllotHeaders.setLastUpdateDate(new Date());
      localEvsAllotHeaders.setLastUpdatedBy(Long.valueOf(Long.parseLong(localEasUserInfo.getUserInfoPk().toString())));
      this.voucherFlittingDAO.updateFlittingInvoicesHeader(localEvsAllotHeaders);
      if (localEvsAllotHeaders.getAllotMode().equals("FLITTING_FOR_BOOK"))
      {
        EvsVoucherHistoryDAO localEvsVoucherHistoryDAO = (EvsVoucherHistoryDAO)SSBBus.findDomainService("evsVoucherHistoryDAO");
        EvsVoucherDAO localEvsVoucherDAO = (EvsVoucherDAO)SSBBus.findDomainService("evsVoucherDAO");
        List localList2 = this.voucherFlittingDAO.findBookByAllotId(paramLong);
        Iterator localIterator1 = localList2.iterator();
        while (localIterator1.hasNext())
        {
          EvsBook localEvsBook = (EvsBook)localIterator1.next();
          this.evsVoucherHistoryDAO.addHistoryNews(localEasUserInfo, 1L, localEvsBook.getBookId().toString(), "撤销", localEvsBook.getBookStatus(), "REMOVE_FLITTING", localEvsAllotHeaders.getCompanyId(), str2);
          localEvsBook.setBookStatus("WAREHOUSE");
          localEvsVoucherDAO = (EvsVoucherDAO)SSBBus.findDomainService("evsVoucherDAO");
          List localList3;
          Iterator localIterator2;
          Object localObject;
          if (localEvsBook.getBookBreakFlag().equals("Y"))
          {
            localList3 = this.voucherFlittingDAO.getEvsVoucherByBookId(localEvsBook.getBookId());
            localIterator2 = localList3.iterator();
            while (localIterator2.hasNext())
            {
              localObject = (EvsVoucherBookPackage)localIterator2.next();
              EvsVoucher localEvsVoucher = localEvsVoucherDAO.findEvsVoucherVByVoucherId(((EvsVoucherBookPackage)localObject).getVoucherId());
              this.evsVoucherHistoryDAO.addHistoryNews(localEasUserInfo, 0L, ((EvsVoucherBookPackage)localObject).getVoucherId().toString(), "撤销", localEvsVoucher.getVoucherStatus(), "REMOVE_FLITTING", localEvsAllotHeaders.getCompanyId(), str2);
              localEvsVoucher.setVoucherStatus("REMOVE_FLITTING");
              this.voucherFlittingDAO.updateEvsVoucher(localEvsVoucher);
            }
          }
          else if (localEvsBook.getBookBreakFlag().equals("N"))
          {
            localList3 = localEvsVoucherDAO.findEvsVoucherVByBookId(localEvsBook.getBookId());
            localIterator2 = localList3.iterator();
            while (localIterator2.hasNext())
            {
              localObject = (EvsVoucher)localIterator2.next();
              this.evsVoucherHistoryDAO.addHistoryNews(localEasUserInfo, 0L, ((EvsVoucher)localObject).getVoucherId().toString(), "撤销", ((EvsVoucher)localObject).getVoucherStatus(), "REMOVE_FLITTING", localEvsAllotHeaders.getCompanyId(), str2);
              ((EvsVoucher)localObject).setVoucherStatus("REMOVE_FLITTING");
              this.voucherFlittingDAO.updateEvsVoucher((EvsVoucher)localObject);
            }
          }
          this.packageDAO.updateVoucherStatus(localEvsBook, "WAREHOUSE");
          this.voucherFlittingDAO.updateObject(localEvsBook);
        }
      }
    }
    return str1;
  }
  
  public String updateAllotHeadersById2(Long paramLong, String paramString)
  {
    String str1 = "fail";
    if ((paramLong == null) || (paramLong.equals(""))) {
      return str1;
    }
    EvsAllotHeaders localEvsAllotHeaders = this.voucherFlittingDAO.getEvsAllotHeaders(BigInteger.valueOf(paramLong.longValue()));
    if ("REMOVE_FLITTING".equals(localEvsAllotHeaders.getAllotStatus()))
    {
      str1 = "alreadyRemove";
      return str1;
    }
    if ("ALREADY_RECEIVE".equals(localEvsAllotHeaders.getAllotStatus()))
    {
      str1 = "alreadyIncept";
      return str1;
    }
    if ("ALREADY_RETURN".equals(localEvsAllotHeaders.getAllotStatus()))
    {
      str1 = "alreadyReturn";
      return str1;
    }
    if (localEvsAllotHeaders != null)
    {
      RIAContext localRIAContext = RIAContext.getCurrentInstance();
      ISession localISession = localRIAContext.getSession();
      EasUserInfo localEasUserInfo = (EasUserInfo)localISession.getSessionAttribute("easloginuserinfo");
      this.evsVoucherHistoryDAO.addHistoryNew(localEasUserInfo, 3L, localEvsAllotHeaders.getAllotHeaderId().toString(), "退回", "NOW_FLITTING", "ALREADY_RETURN", localEvsAllotHeaders.getCompanyId(), localEvsAllotHeaders.getArchivesSiteId(), paramString);
      localEvsAllotHeaders.setAllotStatus("ALREADY_RETURN");
      localEvsAllotHeaders.setLastUpdateDate(new Date());
      localEvsAllotHeaders.setLastUpdatedBy(Long.valueOf(Long.parseLong(localEasUserInfo.getUserInfoPk().toString())));
      this.voucherFlittingDAO.updateFlittingInvoicesHeader(localEvsAllotHeaders);
      if (localEvsAllotHeaders.getAllotMode().equals("FLITTING_FOR_BOOK"))
      {
        localObject1 = (EvsVoucherHistoryDAO)SSBBus.findDomainService("evsVoucherHistoryDAO");
        localObject2 = (EvsVoucherDAO)SSBBus.findDomainService("evsVoucherDAO");
        localObject3 = this.voucherFlittingDAO.findBookByAllotId(paramLong);
        Iterator localIterator = ((List)localObject3).iterator();
        while (localIterator.hasNext())
        {
          EvsBook localEvsBook = (EvsBook)localIterator.next();
          List localList = null;
          if (localEvsBook.getBookId() != null) {
            localList = ((EvsVoucherHistoryDAO)localObject1).findHistoryById(Long.valueOf(1L), localEvsBook.getBookId().toString());
          }
          Object localObject4;
          Object localObject5;
          if (localList.size() > 0)
          {
            localObject4 = (EvsVoucherHistory)localList.get(0);
            localObject5 = ((EvsVoucherHistory)localObject4).getBeginStatus();
            this.evsVoucherHistoryDAO.addHistoryNew(localEasUserInfo, 1L, localEvsBook.getBookId().toString(), "退回", localEvsBook.getBookStatus(), (String)localObject5, localEvsAllotHeaders.getCompanyId(), localEvsAllotHeaders.getArchivesSiteId());
            localEvsBook.setBookStatus((String)localObject5);
          }
          Object localObject6;
          Object localObject7;
          Object localObject8;
          if (localEvsBook.getBookBreakFlag().equals("Y"))
          {
            localObject4 = this.voucherFlittingDAO.getEvsVoucherByBookId(localEvsBook.getBookId());
            localObject5 = ((List)localObject4).iterator();
            while (((Iterator)localObject5).hasNext())
            {
              localObject6 = (EvsVoucherBookPackage)((Iterator)localObject5).next();
              localObject7 = ((EvsVoucherDAO)localObject2).findEvsVoucherVByVoucherId(((EvsVoucherBookPackage)localObject6).getVoucherId());
              if (((EvsVoucher)localObject7).getVoucherId() != null) {
                localList = ((EvsVoucherHistoryDAO)localObject1).findHistoryById(Long.valueOf(0L), ((EvsVoucher)localObject7).getVoucherId().toString());
              }
              if (localList.size() > 0)
              {
                localObject8 = (EvsVoucherHistory)localList.get(0);
                String str2 = ((EvsVoucherHistory)localObject8).getBeginStatus();
                this.evsVoucherHistoryDAO.addHistoryNew(localEasUserInfo, 0L, ((EvsVoucher)localObject7).getVoucherId().toString(), "退回", ((EvsVoucher)localObject7).getVoucherStatus(), str2, localEvsAllotHeaders.getCompanyId(), localEvsAllotHeaders.getArchivesSiteId());
                ((EvsVoucher)localObject7).setVoucherStatus(str2);
                this.voucherFlittingDAO.updateEvsVoucher((EvsVoucher)localObject7);
              }
            }
          }
          else if (localEvsBook.getBookBreakFlag().equals("N"))
          {
            localObject4 = ((EvsVoucherDAO)localObject2).findEvsVoucherVByBookId(localEvsBook.getBookId());
            localObject5 = ((List)localObject4).iterator();
            while (((Iterator)localObject5).hasNext())
            {
              localObject6 = (EvsVoucher)((Iterator)localObject5).next();
              if (((EvsVoucher)localObject6).getVoucherId() != null) {
                localList = ((EvsVoucherHistoryDAO)localObject1).findHistoryById(Long.valueOf(0L), ((EvsVoucher)localObject6).getVoucherId().toString());
              }
              if (localList.size() > 0)
              {
                localObject7 = (EvsVoucherHistory)localList.get(0);
                localObject8 = ((EvsVoucherHistory)localObject7).getBeginStatus();
                this.evsVoucherHistoryDAO.addHistoryNew(localEasUserInfo, 0L, ((EvsVoucher)localObject6).getVoucherId().toString(), "退回", ((EvsVoucher)localObject6).getVoucherStatus(), (String)localObject8, localEvsAllotHeaders.getCompanyId(), localEvsAllotHeaders.getArchivesSiteId());
                ((EvsVoucher)localObject6).setVoucherStatus((String)localObject8);
                this.voucherFlittingDAO.updateEvsVoucher((EvsVoucher)localObject6);
              }
            }
          }
          this.voucherFlittingDAO.updateObject(localEvsBook);
        }
      }
      Object localObject1 = (IFbpNoticesNewDS)SSBBus.findDomainService("fbpNoticesNewDS");
      Object localObject2 = new FbpNoticesNew();
      Object localObject3 = new StringBuilder("您好，").append(localEvsAllotHeaders.getAllotNum()).append("单号的业务因为").append(paramString).append("原因已经撤销，请您及时进行处理");
      ((FbpNoticesNew)localObject2).setContent(((StringBuilder)localObject3).toString());
      ((FbpNoticesNew)localObject2).setFromUserId(localEvsAllotHeaders.getCreatedBy());
      ((FbpNoticesNew)localObject2).setToUserId(localEasUserInfo.getUserId());
      ((FbpNoticesNew)localObject2).setBoeHeaderId(paramLong);
      ((FbpNoticesNew)localObject2).setTemplateId("BACKED");
      ((FbpNoticesNew)localObject2).setNoticeType("2");
      ((FbpNoticesNew)localObject2).setId(null);
      ((IFbpNoticesNewDS)localObject1).insertFbpNoticesNew((FbpNoticesNew)localObject2);
    }
    return str1;
  }
  
  public String updateInceptAllot(Long paramLong)
  {
    String str = "fail";
    if ((paramLong == null) || (paramLong.equals(""))) {
      return str;
    }
    EvsAllotHeaders localEvsAllotHeaders = this.voucherFlittingDAO.getEvsAllotHeaders(BigInteger.valueOf(paramLong.longValue()));
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    ISession localISession = localRIAContext.getSession();
    EasUserInfo localEasUserInfo = (EasUserInfo)localISession.getSessionAttribute("easloginuserinfo");
    if ("REMOVE_FLITTING".equals(localEvsAllotHeaders.getAllotStatus()))
    {
      str = "alreadyRemove";
      return str;
    }
    if ("ALREADY_RECEIVE".equals(localEvsAllotHeaders.getAllotStatus()))
    {
      str = "alreadyIncept";
      return str;
    }
    if ("ALREADY_RETURN".equals(localEvsAllotHeaders.getAllotStatus()))
    {
      str = "alreadyReturn";
      return str;
    }
    if (localEvsAllotHeaders != null)
    {
      this.evsVoucherHistoryDAO.addHistoryNew(localEasUserInfo, 3L, localEvsAllotHeaders.getAllotHeaderId().toString(), "接收", "NOW_FLITTING", "ALREADY_RECEIVE", localEvsAllotHeaders.getCompanyId(), localEvsAllotHeaders.getArchivesSiteId());
      localEvsAllotHeaders.setAllotStatus("ALREADY_RECEIVE");
      localEvsAllotHeaders.setReceiveDate(new Date());
      this.voucherFlittingDAO.updateFlittingInvoicesHeader(localEvsAllotHeaders);
    }
    if (localEvsAllotHeaders.getAllotMode().equals("FLITTING_FOR_BOOK"))
    {
      EvsVoucherDAO localEvsVoucherDAO = (EvsVoucherDAO)SSBBus.findDomainService("evsVoucherDAO");
      List localList1 = this.voucherFlittingDAO.findBookByAllotId(paramLong);
      Iterator localIterator1 = localList1.iterator();
      while (localIterator1.hasNext())
      {
        EvsBook localEvsBook = (EvsBook)localIterator1.next();
        this.evsVoucherHistoryDAO.addHistoryNew(localEasUserInfo, 1L, localEvsBook.getBookId().toString(), "接收", localEvsBook.getBookStatus(), "BOOKED", localEvsAllotHeaders.getCompanyId(), localEvsAllotHeaders.getArchivesSiteId());
        localEvsBook.setBookStatus("BOOKED");
        this.voucherFlittingDAO.updateObject(localEvsBook);
        this.voucherFlittingDAO.updateInventory(localEvsBook.getBookId());
        List localList2;
        Iterator localIterator2;
        Object localObject;
        if (localEvsBook.getBookBreakFlag().equals("Y"))
        {
          localList2 = this.voucherFlittingDAO.getEvsVoucherByBookId(localEvsBook.getBookId());
          localIterator2 = localList2.iterator();
          while (localIterator2.hasNext())
          {
            localObject = (EvsVoucherBookPackage)localIterator2.next();
            EvsVoucher localEvsVoucher = localEvsVoucherDAO.findEvsVoucherVByVoucherId(((EvsVoucherBookPackage)localObject).getVoucherId());
            this.evsVoucherHistoryDAO.addHistoryNew(localEasUserInfo, 0L, ((EvsVoucherBookPackage)localObject).getVoucherId().toString(), "接收", localEvsVoucher.getVoucherStatus(), "BOOKED", localEvsAllotHeaders.getCompanyId(), localEvsAllotHeaders.getArchivesSiteId());
            localEvsVoucher.setVoucherStatus("BOOKED");
            this.voucherFlittingDAO.updateEvsVoucher(localEvsVoucher);
          }
        }
        else if (localEvsBook.getBookBreakFlag().equals("N"))
        {
          localList2 = localEvsVoucherDAO.findEvsVoucherVByBookId(localEvsBook.getBookId());
          localIterator2 = localList2.iterator();
          while (localIterator2.hasNext())
          {
            localObject = (EvsVoucher)localIterator2.next();
            this.evsVoucherHistoryDAO.addHistoryNew(localEasUserInfo, 0L, ((EvsVoucher)localObject).getVoucherId().toString(), "接收", ((EvsVoucher)localObject).getVoucherStatus(), "BOOKED", localEvsAllotHeaders.getCompanyId(), localEvsAllotHeaders.getArchivesSiteId());
            ((EvsVoucher)localObject).setVoucherStatus("BOOKED");
            this.voucherFlittingDAO.updateEvsVoucher((EvsVoucher)localObject);
          }
        }
      }
    }
    return str;
  }
  
  public String updateInceptAllotBoe(List<String> paramList)
  {
    String str1 = "fail";
    Object localObject1 = paramList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject3 = Long.valueOf(Long.parseLong(localObject2.toString()));
      if ((localObject3 == null) || (((Long)localObject3).equals(""))) {
        return str1;
      }
      localObject4 = this.voucherFlittingDAO.getEvsAllotHeaders(BigInteger.valueOf(((Long)localObject3).longValue()));
      if ("REMOVE_FLITTING".equals(((EvsAllotHeaders)localObject4).getAllotStatus()))
      {
        str1 = "alreadyRemove";
        return str1;
      }
      if ("ALREADY_RECEIVE".equals(((EvsAllotHeaders)localObject4).getAllotStatus()))
      {
        str1 = "alreadyIncept";
        return str1;
      }
      if ("ALREADY_RETURN".equals(((EvsAllotHeaders)localObject4).getAllotStatus()))
      {
        str1 = "alreadyReturn";
        return str1;
      }
    }
    localObject1 = RIAContext.getCurrentInstance();
    Object localObject2 = ((RIAContext)localObject1).getSession();
    Object localObject3 = (EasUserInfo)((ISession)localObject2).getSessionAttribute("easloginuserinfo");
    Object localObject4 = paramList.iterator();
    while (((Iterator)localObject4).hasNext())
    {
      String str2 = (String)((Iterator)localObject4).next();
      Long localLong = Long.valueOf(Long.parseLong(str2.toString()));
      EvsAllotHeaders localEvsAllotHeaders = this.voucherFlittingDAO.getEvsAllotHeaders(BigInteger.valueOf(localLong.longValue()));
      if (localEvsAllotHeaders != null)
      {
        this.evsVoucherHistoryDAO.addHistoryNew((EasUserInfo)localObject3, 3L, localEvsAllotHeaders.getAllotHeaderId().toString(), "接收", "NOW_FLITTING", "ALREADY_RECEIVE", localEvsAllotHeaders.getCompanyId(), localEvsAllotHeaders.getArchivesSiteId());
        localEvsAllotHeaders.setAllotStatus("ALREADY_RECEIVE");
        localEvsAllotHeaders.setReceiveDate(new Date());
        this.voucherFlittingDAO.updateFlittingInvoicesHeader(localEvsAllotHeaders);
      }
      if (localEvsAllotHeaders.getAllotMode().equals("FLITTING_FOR_BOOK"))
      {
        EvsVoucherDAO localEvsVoucherDAO = (EvsVoucherDAO)SSBBus.findDomainService("evsVoucherDAO");
        List localList1 = this.voucherFlittingDAO.findBookByAllotId(localLong);
        Iterator localIterator1 = localList1.iterator();
        while (localIterator1.hasNext())
        {
          EvsBook localEvsBook = (EvsBook)localIterator1.next();
          this.evsVoucherHistoryDAO.addHistoryNew((EasUserInfo)localObject3, 1L, localEvsBook.getBookId().toString(), "接收", localEvsBook.getBookStatus(), "BOOKED", localEvsAllotHeaders.getCompanyId(), localEvsAllotHeaders.getArchivesSiteId());
          localEvsBook.setBookStatus("BOOKED");
          this.voucherFlittingDAO.updateObject(localEvsBook);
          this.voucherFlittingDAO.updateInventory(localEvsBook.getBookId());
          List localList2;
          Iterator localIterator2;
          Object localObject5;
          if (localEvsBook.getBookBreakFlag().equals("Y"))
          {
            localList2 = this.voucherFlittingDAO.getEvsVoucherByBookId(localEvsBook.getBookId());
            localIterator2 = localList2.iterator();
            while (localIterator2.hasNext())
            {
              localObject5 = (EvsVoucherBookPackage)localIterator2.next();
              EvsVoucher localEvsVoucher = localEvsVoucherDAO.findEvsVoucherVByVoucherId(((EvsVoucherBookPackage)localObject5).getVoucherId());
              this.evsVoucherHistoryDAO.addHistoryNew((EasUserInfo)localObject3, 0L, ((EvsVoucherBookPackage)localObject5).getVoucherId().toString(), "接收", localEvsVoucher.getVoucherStatus(), "BOOKED", localEvsAllotHeaders.getCompanyId(), localEvsAllotHeaders.getArchivesSiteId());
              localEvsVoucher.setVoucherStatus("BOOKED");
              this.voucherFlittingDAO.updateEvsVoucher(localEvsVoucher);
            }
          }
          else if (localEvsBook.getBookBreakFlag().equals("N"))
          {
            localList2 = localEvsVoucherDAO.findEvsVoucherVByBookId(localEvsBook.getBookId());
            localIterator2 = localList2.iterator();
            while (localIterator2.hasNext())
            {
              localObject5 = (EvsVoucher)localIterator2.next();
              this.evsVoucherHistoryDAO.addHistoryNew((EasUserInfo)localObject3, 0L, ((EvsVoucher)localObject5).getVoucherId().toString(), "接收", ((EvsVoucher)localObject5).getVoucherStatus(), "BOOKED", localEvsAllotHeaders.getCompanyId(), localEvsAllotHeaders.getArchivesSiteId());
              ((EvsVoucher)localObject5).setVoucherStatus("BOOKED");
              this.voucherFlittingDAO.updateEvsVoucher((EvsVoucher)localObject5);
            }
          }
        }
      }
    }
    return str1;
  }
  
  public TableDataInfo findBookByAllotNum(String paramString1, String paramString2, String paramString3)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    if ((!Util.isStrEmpty(paramString2)) && (!Util.isStrEmpty(paramString3)))
    {
      PageInfo localPageInfo = this.voucherFlittingDAO.findBookByAllotNum(paramString1, new Integer(paramString2), new Integer(paramString3));
      localTableDataInfo.setData((List)localPageInfo.getResult());
      localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
    }
    return localTableDataInfo;
  }
  
  public TableDataInfo findVoucherByAllotNum(String paramString1, String paramString2, String paramString3)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    if ((!Util.isStrEmpty(paramString2)) && (!Util.isStrEmpty(paramString3)))
    {
      PageInfo localPageInfo = this.voucherFlittingDAO.findVoucherByAllotNum(paramString1, new Integer(paramString2), new Integer(paramString3));
      localTableDataInfo.setData((List)localPageInfo.getResult());
      localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
    }
    return localTableDataInfo;
  }
  
  public TableDataInfo findBookByAllotNumNew(String paramString, List<String> paramList, int paramInt1, int paramInt2)
  {
    String str = fmtList(paramList, "'");
    List localList = this.voucherFlittingDAO.findRelationIdByAllotNumNew(paramString, str);
    TableDataInfo localTableDataInfo = new TableDataInfo();
    if ((localList != null) && (localList.size() > 0))
    {
      PageInfo localPageInfo = this.voucherFlittingDAO.findBookByNumbs(localList, "RECEIVE", paramInt1, paramInt2);
      localTableDataInfo.setData((List)localPageInfo.getResult());
      localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
    }
    return localTableDataInfo;
  }
  
  public EvsAllotHeadersV findOneAllotBoe(String paramString1, String paramString2)
  {
    EvsAllotHeadersV localEvsAllotHeadersV1 = new EvsAllotHeadersV();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    if ((paramString1 != null) && (!"".equals(paramString1))) {
      localEvsAllotHeadersV1.setAllotHeaderId(new BigInteger(paramString1));
    }
    localEvsAllotHeadersV1.setFlag(paramString2);
    PageInfo localPageInfo = this.voucherFlittingDAO.findAllotHeadersV2(localEvsAllotHeadersV1, Integer.valueOf(1), Integer.valueOf(2));
    List localList = (List)localPageInfo.getResult();
    if ((localList != null) && (localList.size() > 0))
    {
      EvsAllotHeadersV localEvsAllotHeadersV2 = (EvsAllotHeadersV)localList.get(0);
      localEvsAllotHeadersV2.setAllotDateStr(localSimpleDateFormat.format(localEvsAllotHeadersV2.getAllotDate()));
      return localEvsAllotHeadersV2;
    }
    return null;
  }
  
  public TableDataInfo findBoxByAllotNum(String paramString, int paramInt1, int paramInt2)
  {
    PageInfo localPageInfo = this.voucherFlittingDAO.findBoxByAllotNum(paramString, paramInt1, paramInt2);
    TableDataInfo localTableDataInfo = new TableDataInfo();
    localTableDataInfo.setData((List)localPageInfo.getResult());
    localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
    return localTableDataInfo;
  }
  
  public EvsPackageV findBoxByAllotNum(String paramString)
  {
    EvsPackageV localEvsPackageV = new EvsPackageV();
    PageInfo localPageInfo = this.voucherFlittingDAO.findBoxByAllotNum(paramString, 1, 10);
    List localList = (List)localPageInfo.getResult();
    if ((localList != null) && (localList.size() > 0)) {
      return localEvsPackageV = (EvsPackageV)localList.get(0);
    }
    return null;
  }
  
  public String checkBoxOnReceive(String paramString1, String paramString2)
  {
    try
    {
      EvsPackageModel localEvsPackageModel = new EvsPackageModel();
      PageInfo localPageInfo = this.packageDAO.getPackageByPackageId(new String[] { paramString2 }, "RECEIVE", 0, 1);
      Object localObject = new ArrayList();
      if (localPageInfo != null) {
        localObject = (List)localPageInfo.getResult();
      }
      List localList = this.voucherFlittingDAO.findRelationIdByAllotNum(Long.valueOf(Long.parseLong(paramString1)));
      int i = 0;
      if (((List)localObject).size() > 0)
      {
        EvsPackageV localEvsPackageV = (EvsPackageV)((List)localObject).get(0);
        String str = localEvsPackageV.getPackageId().toString();
        i = localList.toString().indexOf(str) >= 1 ? 1 : 0;
        if (!"ALREADY_FLITTING".equals(localEvsPackageV.getPackageStatus())) {
          return "STATUS_ERROR";
        }
        if (i == 0) {
          return "NONENTITY";
        }
      }
      else
      {
        return "NO_DATE";
      }
      return "OK";
    }
    catch (RuntimeException localRuntimeException)
    {
      localRuntimeException.printStackTrace();
    }
    return "exception";
  }
  
  public String saveDataToReceive(EvsAllotHeaders paramEvsAllotHeaders, String[] paramArrayOfString, String paramString)
  {
    try
    {
      if ((paramEvsAllotHeaders == null) || (paramEvsAllotHeaders.getAllotHeaderId() == null)) {
        return "DataError";
      }
      String str1 = "ALREADY_RECEIVE";
      String str2 = "接收";
      if ((paramString != null) && ("REJECT".equals(paramString)))
      {
        str1 = "NOT_RECEIVE";
        str2 = "退回";
      }
      List localList1 = this.voucherFlittingDAO.findRelationIdByAllotNum(Long.valueOf(Long.parseLong(paramEvsAllotHeaders.getAllotHeaderId().toString())));
      if (localList1.size() != paramArrayOfString.length) {
        return "DataHalf-baked";
      }
      int i = 0;
      for (int j = 0; j < localList1.size(); j++) {
        for (int k = 0; k < paramArrayOfString.length; k++)
        {
          localObject = localList1.get(j);
          if (paramArrayOfString[k].equals(localObject.toString()))
          {
            i = 1;
            break;
          }
          i = 0;
        }
      }
      if (i == 0) {
        return "DataHalf-baked";
      }
      RIAContext localRIAContext = RIAContext.getCurrentInstance();
      ISession localISession = localRIAContext.getSession();
      Object localObject = (EasUserInfo)localISession.getSessionAttribute("easloginuserinfo");
      FbpEmployeesV localFbpEmployeesV = this.voucherFlittingDAO.getEmpVInfo(((EasUserInfo)localObject).getUserId());
      EvsAllotHeaders localEvsAllotHeaders = this.voucherFlittingDAO.getEvsAllotHeaders(paramEvsAllotHeaders.getAllotHeaderId());
      localEvsAllotHeaders.setArchivesSiteId(paramEvsAllotHeaders.getArchivesSiteId());
      localEvsAllotHeaders.setReceiveBy(localFbpEmployeesV.getEmployeeId());
      localEvsAllotHeaders.setReceiveDate(new Date());
      localEvsAllotHeaders.setStoreCheckUnit(paramEvsAllotHeaders.getStoreCheckUnit());
      localEvsAllotHeaders.setReceiveTypeId(paramEvsAllotHeaders.getReceiveTypeId());
      localEvsAllotHeaders.setAllotStatus(str1);
      this.voucherFlittingDAO.updateFlittingInvoicesHeader(localEvsAllotHeaders);
      this.evsVoucherHistoryDAO.addHistoryNew((EasUserInfo)localObject, 3L, paramEvsAllotHeaders.getAllotHeaderId().toString(), str2, "ALREADY_FLITTING", str1, paramEvsAllotHeaders.getCompanyId(), paramEvsAllotHeaders.getArchivesSiteId());
      if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {
        for (String str3 : paramArrayOfString)
        {
          PageInfo localPageInfo = this.packageDAO.getPackageByPackageId(new String[] { str3 }, str1, 1, 2);
          List localList2 = (List)localPageInfo.getResult();
          if ((localList1 != null) && (localList1.size() > 0)) {
            this.evsVoucherHistoryDAO.addHistoryNew((EasUserInfo)localObject, 2L, str3, str2, ((EvsPackageV)localList2.get(0)).getPackageStatus(), str1, paramEvsAllotHeaders.getCompanyId(), paramEvsAllotHeaders.getArchivesSiteId());
          }
          List localList3 = this.packageDAO.getBookByPackageId(str3);
          if ((localList3 != null) && (localList3.size() > 0))
          {
            Iterator localIterator = localList3.iterator();
            while (localIterator.hasNext())
            {
              EvsBook localEvsBook = (EvsBook)localIterator.next();
              this.evsVoucherHistoryDAO.addHistoryNew((EasUserInfo)localObject, 1L, localEvsBook.getBookId().toString(), str2, localEvsBook.getBookStatus(), str1, paramEvsAllotHeaders.getCompanyId(), paramEvsAllotHeaders.getArchivesSiteId());
              List localList4 = this.packageDAO.getVoucherById(localEvsBook.getBookId().toString());
              if ((localList4 != null) && (localList4.size() > 0)) {
                for (int i1 = 0; i1 < localList4.size(); i1++)
                {
                  String str4 = localList4.get(i1) == null ? "" : localList4.get(i1).toString();
                  EvsVoucher localEvsVoucher = this.bookDAO.findVoucherById(str4);
                  this.evsVoucherHistoryDAO.addHistoryNew((EasUserInfo)localObject, 0L, str4, str2, localEvsVoucher.getVoucherStatus(), str1, paramEvsAllotHeaders.getCompanyId(), paramEvsAllotHeaders.getArchivesSiteId());
                }
              }
              this.packageDAO.updateVoucherStatusByBookCodeNew(localEvsBook.getBookId().toString(), str1);
            }
          }
          this.packageDAO.updateBookStatusByPackageIdNew(str3, str1);
          this.packageDAO.updateStatusByPackageId(str3, str1);
        }
      }
      return "OK";
    }
    catch (RuntimeException localRuntimeException)
    {
      localRuntimeException.printStackTrace();
    }
    return "exception";
  }
  
  public EvsBook findBookByCode(String paramString)
  {
    EvsBookModel localEvsBookModel = new EvsBookModel();
    localEvsBookModel.setBookCode(paramString);
    EvsBook localEvsBook = this.packageDAO.getBookByCode(localEvsBookModel);
    return localEvsBook;
  }
  
  public String checkBookOnReceive(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramString1.equals("")) || (paramString2.equals(""))) {
      return "DataError";
    }
    EvsBookModel localEvsBookModel = new EvsBookModel();
    localEvsBookModel.setBookCode(paramString2);
    EvsBook localEvsBook = this.packageDAO.getBookByCode(localEvsBookModel);
    if (localEvsBook == null) {
      return "DataError";
    }
    if (!"ALREADY_FLITTING".equals(localEvsBook.getBookStatus())) {
      return "statusError";
    }
    String str = localEvsBook.getBookId().toString();
    List localList = this.voucherFlittingDAO.findRelationIdByAllotNum(Long.valueOf(Long.parseLong(paramString1)));
    int i = localList.toString().indexOf(str);
    if (i < 1) {
      return "NONENTITY";
    }
    return localEvsBook.getBookId().toString();
  }
  
  public String saveDataToReceiveForBook(EvsAllotHeaders paramEvsAllotHeaders, String[] paramArrayOfString, String paramString)
  {
    try
    {
      if ((paramEvsAllotHeaders == null) || (paramEvsAllotHeaders.getAllotHeaderId() == null)) {
        return "DataError";
      }
      String str1 = "ALREADY_RECEIVE";
      String str2 = "接收";
      if ((paramString != null) && ("REJECT".equals(paramString)))
      {
        str1 = "NOT_RECEIVE";
        str2 = "退回";
      }
      List localList1 = this.voucherFlittingDAO.findRelationIdByAllotNum(Long.valueOf(Long.parseLong(paramEvsAllotHeaders.getAllotHeaderId().toString())));
      if (localList1.size() != paramArrayOfString.length) {
        return "DataHalf-baked";
      }
      int i = 0;
      for (int j = 0; j < localList1.size(); j++) {
        for (int k = 0; k < paramArrayOfString.length; k++)
        {
          localObject = localList1.get(j);
          if (paramArrayOfString[k].equals(localObject.toString()))
          {
            i = 1;
            break;
          }
          i = 0;
        }
      }
      if (i == 0) {
        return "DataHalf-baked";
      }
      RIAContext localRIAContext = RIAContext.getCurrentInstance();
      ISession localISession = localRIAContext.getSession();
      Object localObject = (EasUserInfo)localISession.getSessionAttribute("easloginuserinfo");
      FbpEmployeesV localFbpEmployeesV = this.voucherFlittingDAO.getEmpVInfo(((EasUserInfo)localObject).getUserId());
      EvsAllotHeaders localEvsAllotHeaders = this.voucherFlittingDAO.getEvsAllotHeaders(paramEvsAllotHeaders.getAllotHeaderId());
      localEvsAllotHeaders.setArchivesSiteId(paramEvsAllotHeaders.getArchivesSiteId());
      localEvsAllotHeaders.setReceiveBy(localFbpEmployeesV.getEmployeeId());
      localEvsAllotHeaders.setReceiveDate(new Date());
      localEvsAllotHeaders.setStoreCheckUnit(paramEvsAllotHeaders.getStoreCheckUnit());
      localEvsAllotHeaders.setReceiveTypeId(paramEvsAllotHeaders.getReceiveTypeId());
      localEvsAllotHeaders.setAllotStatus(str1);
      this.voucherFlittingDAO.updateFlittingInvoicesHeader(localEvsAllotHeaders);
      this.evsVoucherHistoryDAO.addHistoryNew((EasUserInfo)localObject, 3L, paramEvsAllotHeaders.getAllotHeaderId().toString(), str2, "ALREADY_FLITTING", str1, paramEvsAllotHeaders.getCompanyId(), paramEvsAllotHeaders.getArchivesSiteId());
      if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {
        for (String str3 : paramArrayOfString)
        {
          this.packageDAO.updateStatusByBookId(str3, str1);
          this.evsVoucherHistoryDAO.addHistoryNew((EasUserInfo)localObject, 1L, str3, str2, "ALREADY_FLITTING", str1, paramEvsAllotHeaders.getCompanyId(), paramEvsAllotHeaders.getArchivesSiteId());
          List localList2 = this.packageDAO.getVoucherById(str3);
          if ((localList2 != null) && (localList2.size() > 0)) {
            for (int i1 = 0; i1 < localList2.size(); i1++)
            {
              String str4 = localList2.get(i1) == null ? "" : localList2.get(i1).toString();
              EvsVoucher localEvsVoucher = this.bookDAO.findVoucherById(str4);
              this.evsVoucherHistoryDAO.addHistoryNew((EasUserInfo)localObject, 0L, str4, str2, localEvsVoucher.getVoucherStatus(), str1, paramEvsAllotHeaders.getCompanyId(), paramEvsAllotHeaders.getArchivesSiteId());
            }
          }
          this.packageDAO.updateVoucherStatusByBookCodeNew(str3, str1);
        }
      }
      return "OK";
    }
    catch (RuntimeException localRuntimeException)
    {
      localRuntimeException.printStackTrace();
    }
    return "exception";
  }
  
  public TableDataInfo findBoxByAllotNumNew(String paramString, List<String> paramList, int paramInt1, int paramInt2)
  {
    PageInfo localPageInfo = this.voucherFlittingDAO.findBoxByAllotNumNew(paramString, paramList, paramInt1, paramInt2);
    TableDataInfo localTableDataInfo = new TableDataInfo();
    localTableDataInfo.setData((List)localPageInfo.getResult());
    localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
    return localTableDataInfo;
  }
  
  public IVoucherFlittingDAO getVoucherFlittingDAO()
  {
    return this.voucherFlittingDAO;
  }
  
  public void setVoucherFlittingDAO(IVoucherFlittingDAO paramIVoucherFlittingDAO)
  {
    this.voucherFlittingDAO = paramIVoucherFlittingDAO;
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
        String str2 = localObject == null ? "-1" : localObject.toString().trim();
        str1 = str1 + paramString + str2 + paramString + ",";
      }
      str1 = str1.substring(0, str1.length() - 1);
    }
    return str1;
  }
  
  public EvsAllotHeaders findAllotBoeBySubId(String paramString)
  {
    List localList = this.voucherFlittingDAO.findAllotBoeBySubId(paramString);
    if ((localList != null) && (localList.size() > 0)) {
      return (EvsAllotHeaders)localList.get(0);
    }
    return null;
  }
  
  public String findExportData(String[] paramArrayOfString)
  {
    EvsAllotHeadersV localEvsAllotHeadersV = null;
    List localList = null;
    HSSFWorkbook localHSSFWorkbook = new HSSFWorkbook();
    HSSFSheet localHSSFSheet = localHSSFWorkbook.createSheet();
    localHSSFWorkbook.setSheetName(0, "firstSheet", (short)1);
    HSSFRow localHSSFRow = localHSSFSheet.createRow(0);
    HSSFCell localHSSFCell = localHSSFRow.createCell((short)0);
    localHSSFCell.setCellType(1);
    localHSSFCell.setEncoding((short)1);
    localHSSFCell.setCellValue("调拨单号");
    localHSSFCell = localHSSFRow.createCell((short)1);
    localHSSFCell.setCellType(1);
    localHSSFCell.setEncoding((short)1);
    localHSSFCell.setCellValue("分册编号");
    localHSSFCell = localHSSFRow.createCell((short)2);
    localHSSFCell.setCellType(1);
    localHSSFCell.setEncoding((short)1);
    localHSSFCell.setCellValue("公司名称");
    localHSSFCell = localHSSFRow.createCell((short)3);
    localHSSFCell.setCellType(1);
    localHSSFCell.setEncoding((short)1);
    localHSSFCell.setCellValue("分册人");
    localHSSFCell = localHSSFRow.createCell((short)4);
    localHSSFCell.setCellType(1);
    localHSSFCell.setEncoding((short)1);
    localHSSFCell.setCellValue("会计期间");
    localHSSFCell = localHSSFRow.createCell((short)5);
    localHSSFCell.setCellType(1);
    localHSSFCell.setEncoding((short)1);
    localHSSFCell.setCellValue("分册日期");
    localHSSFCell = localHSSFRow.createCell((short)6);
    localHSSFCell.setCellType(1);
    localHSSFCell.setEncoding((short)1);
    localHSSFCell.setCellValue("调拨人");
    localHSSFCell = localHSSFRow.createCell((short)7);
    localHSSFCell.setCellType(1);
    localHSSFCell.setEncoding((short)1);
    localHSSFCell.setCellValue("调拨日期");
    localHSSFCell = localHSSFRow.createCell((short)8);
    localHSSFCell.setCellType(1);
    localHSSFCell.setEncoding((short)1);
    localHSSFCell.setCellValue("调拨状态");
    localHSSFCell = localHSSFRow.createCell((short)9);
    localHSSFCell.setCellType(1);
    localHSSFCell.setEncoding((short)1);
    localHSSFCell.setCellValue("操作说明");
    localHSSFCell = localHSSFRow.createCell((short)10);
    int i = 0;
    for (int j = 0; j < paramArrayOfString.length; j++)
    {
      localObject = Long.valueOf(paramArrayOfString[j]);
      localEvsAllotHeadersV = this.voucherFlittingDAO.findAllotHeadersById((Long)localObject);
      localList = this.voucherFlittingDAO.findBookByAllotIdForExport((Long)localObject);
      for (int k = 0; k < localList.size(); k++)
      {
        localHSSFRow = localHSSFSheet.createRow((short)(i + 1));
        localHSSFCell = localHSSFRow.createCell((short)0);
        localHSSFCell.setCellType(1);
        localHSSFCell.setEncoding((short)1);
        localHSSFCell.setCellValue(localEvsAllotHeadersV.getAllotNum());
        localHSSFCell = localHSSFRow.createCell((short)1);
        localHSSFCell.setCellType(1);
        localHSSFCell.setEncoding((short)1);
        localHSSFCell.setCellValue(((EvsBookV)localList.get(k)).getBookCode());
        localHSSFCell = localHSSFRow.createCell((short)2);
        localHSSFCell.setCellType(1);
        localHSSFCell.setEncoding((short)1);
        localHSSFCell.setCellValue(((EvsBookV)localList.get(k)).getCompanyName());
        localHSSFCell = localHSSFRow.createCell((short)3);
        localHSSFCell.setCellType(1);
        localHSSFCell.setEncoding((short)1);
        localHSSFCell.setCellValue(((EvsBookV)localList.get(k)).getBookPeople());
        localHSSFCell = localHSSFRow.createCell((short)4);
        localHSSFCell.setCellType(1);
        localHSSFCell.setEncoding((short)1);
        localHSSFCell.setCellValue(((EvsBookV)localList.get(k)).getPeriodName());
        localHSSFCell = localHSSFRow.createCell((short)5);
        localHSSFCell.setCellType(1);
        localHSSFCell.setEncoding((short)1);
        localHSSFCell.setCellValue(((EvsBookV)localList.get(k)).getBookDate().toString());
        localHSSFCell = localHSSFRow.createCell((short)6);
        localHSSFCell.setCellType(1);
        localHSSFCell.setEncoding((short)1);
        localHSSFCell.setCellValue(localEvsAllotHeadersV.getEmployeeName());
        localHSSFCell = localHSSFRow.createCell((short)7);
        localHSSFCell.setCellType(1);
        localHSSFCell.setEncoding((short)1);
        localHSSFCell.setCellValue(localEvsAllotHeadersV.getAllotDate().toString());
        localHSSFCell = localHSSFRow.createCell((short)8);
        localHSSFCell.setCellType(1);
        localHSSFCell.setEncoding((short)1);
        localHSSFCell.setCellValue(localEvsAllotHeadersV.getAllotStatusMeaning());
        localHSSFCell = localHSSFRow.createCell((short)9);
        localHSSFCell.setCellType(1);
        localHSSFCell.setEncoding((short)1);
        localHSSFCell.setCellValue(localEvsAllotHeadersV.getAllotDesc());
        i++;
      }
    }
    FileOutputStream localFileOutputStream = null;
    Object localObject = null;
    try
    {
      RIAContext localRIAContext = RIAContext.getCurrentInstance();
      String str = localRIAContext.getRealPath("/UserFiles");
      localObject = str + File.separator + getRandByTime() + ".xls";
      localFileOutputStream = new FileOutputStream((String)localObject);
      localHSSFWorkbook.write(localFileOutputStream);
      localFileOutputStream.flush();
      localFileOutputStream.close();
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    System.out.println("文件生成...");
    return localObject;
  }
  
  public static String getRandByTime()
  {
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(2) + 1;
    String str1 = i + "";
    if (i < 10) {
      str1 = "0" + i;
    }
    int j = localCalendar.get(5);
    String str2 = j + "";
    if (j < 10) {
      str2 = "0" + j;
    }
    String str3 = localCalendar.get(1) + str1 + str2 + localCalendar.get(10) + localCalendar.get(12) + localCalendar.get(13) + localCalendar.get(14);
    return str3;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.eBillManage.VoucherFlittingService
 * JD-Core Version:    0.7.0.1
 */