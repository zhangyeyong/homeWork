package com.zte.evs.ebill.business.eBillManage;

import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.eas.appframe.business.util.ObjectCopyUtils;
import com.zte.eas.infomap.business.notice.model.FbpNoticesNew;
import com.zte.eas.infomap.business.notice.service.IFbpNoticesNewDS;
import com.zte.eas.organization.access.countcompanymanage.IFbpCompanyVDAO;
import com.zte.eas.organization.access.employeemanage.dao.FbpEmployeesVDAO;
import com.zte.eas.organization.business.countcompanymanage.model.FbpCompanyV;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployees;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesTl;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesV;
import com.zte.eas.resconfig.access.lookup.dao.IFbpLookupValuesVDAO;
import com.zte.eas.resconfig.business.lookup.model.FbpLookupValuesV;
import com.zte.evs.ebill.access.eBillManage.EvsVoucherCheckFindDAO;
import com.zte.evs.ebill.access.eBillManage.EvsVoucherHistoryDAO;
import com.zte.evs.ebill.access.eBillManage.IEvsVoucherLineDAO;
import com.zte.evs.ebill.access.eBillManage.IFbpImagesDAO;
import com.zte.evs.ebill.common.EvsObjectUtils;
import com.zte.evs.ebill.common.EvsStatusUtil;
import com.zte.evs.ebill.common.invoice.util.InvoiceAction;
import com.zte.evs.ebill.model.eBillManage.EvsImage;
import com.zte.evs.ebill.model.eBillManage.EvsImageModel;
import com.zte.evs.ebill.model.eBillManage.EvsImageV;
import com.zte.evs.ebill.model.eBillManage.EvsVoucher;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherCheckHistories;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherHistory;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherHistoryV;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherInvoice;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherLine;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherListV;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherPrint;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherSelect;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherV;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.servicecontainer.business.server.ISession;
import com.zte.ssb.servicecontainer.business.server.RIAContext;
import com.zte.ssb.ssbext.resource.ComResUtil;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

public class EvsVoucherCheckService
  implements IEvsVoucherCheckService
{
  private Logger log = Logger.getLogger(getClass());
  private static final String BACKED = "BACKED";
  private static final String CANCLE_MSG_ERR01 = "非复核状态不能退回";
  private static final String I = "I";
  private static final String SUBMITED = "SUBMITED";
  private static final String Y = "Y";
  private static final String S = "S";
  private EvsVoucherCheckFindDAO evsVoucherCheckFindDAO;
  private EvsVoucherHistoryDAO evsVoucherHistoryDAO;
  private FbpEmployeesVDAO fbpEmployeesVDAO;
  private IFbpCompanyVDAO fbpCompanyVDAO;
  private IFbpImagesDAO fbpImagesDAO;
  private IEvsVoucherLineDAO evsVoucherLineDAO;
  public static final String CURRENCY_CODE_CNY = "RMB";
  public final Integer pageSize = Integer.valueOf(10);
  private static final String CURRENCY_CODE_LABEL = "CURRENCY_CODE_LABEL";
  private IFbpLookupValuesVDAO lookupValuesVDAO;
  private static final String EAS_LOGIN_USERINFO = "easloginuserinfo";
  private static final String UNTREAD_CAUSE = "UNTREAD_CAUSE";
  
  public FbpEmployeesVDAO getFbpEmployeesVDAO()
  {
    return this.fbpEmployeesVDAO;
  }
  
  public void setFbpEmployeesVDAO(FbpEmployeesVDAO paramFbpEmployeesVDAO)
  {
    this.fbpEmployeesVDAO = paramFbpEmployeesVDAO;
  }
  
  public EvsVoucherHistoryDAO getEvsVoucherHistoryDAO()
  {
    return this.evsVoucherHistoryDAO;
  }
  
  public void setEvsVoucherHistoryDAO(EvsVoucherHistoryDAO paramEvsVoucherHistoryDAO)
  {
    this.evsVoucherHistoryDAO = paramEvsVoucherHistoryDAO;
  }
  
  public TableDataInfo getVoucherByScan(EvsVoucherSelect paramEvsVoucherSelect, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    Map localMap = this.evsVoucherCheckFindDAO.findEmployeeHeaderByScanCode(paramEvsVoucherSelect, paramInt1, paramInt2);
    localTableDataInfo.setData((List)localMap.get("data"));
    localTableDataInfo.setTotalCount(Integer.parseInt(localMap.get("totalCount").toString()));
    return localTableDataInfo;
  }
  
  public boolean updateCheck(List<String> paramList)
  {
    boolean bool = false;
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramList.size() == 0) {
      return false;
    }
    for (int i = 0; i < paramList.size(); i++) {
      if (i == 0) {
        localStringBuffer.append("(" + (String)paramList.get(i));
      } else {
        localStringBuffer.append("," + (String)paramList.get(i));
      }
    }
    if ((localStringBuffer != null) && (localStringBuffer.length() > 0)) {
      localStringBuffer.append(")");
    }
    String str = localEasUserInfo.getUserId();
    Object localObject;
    if ((str == null) || (str.trim().length() == 0))
    {
      this.log.error("ID为" + localEasUserInfo.getUserInfoPk() + "的员工在session中找不到工号....................");
      if (localEasUserInfo.getUserInfoPk() != null)
      {
        localObject = (FbpEmployees)this.fbpEmployeesVDAO.getObject(FbpEmployees.class, localEasUserInfo.getUserInfoPk());
        str = ((FbpEmployees)localObject).getEmployeeNumber();
      }
    }
    try
    {
      localObject = null;
      for (int j = 0; j < paramList.size(); j++)
      {
        localObject = (EvsVoucher)this.evsVoucherCheckFindDAO.get(EvsVoucher.class, Long.valueOf(Long.parseLong((String)paramList.get(j))));
        this.evsVoucherHistoryDAO.addHistory(localEasUserInfo, 0L, ((EvsVoucher)localObject).getVoucherId().toString(), EvsStatusUtil.getVoucherStatusName("CHECKED"), ((EvsVoucher)localObject).getVoucherStatus(), "CHECKED_NO_BOOKED");
        ((EvsVoucher)localObject).setApprover(localEasUserInfo.getUserName());
        ((EvsVoucher)localObject).setApproverNumber(str);
        ((EvsVoucher)localObject).setApproverDate(new Date());
        this.evsVoucherCheckFindDAO.updateObject(localObject);
      }
      this.evsVoucherCheckFindDAO.update("CHECKED_NO_BOOKED", localStringBuffer.toString());
      this.evsVoucherCheckFindDAO.saveVoucher(localStringBuffer.toString());
      bool = true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return bool;
  }
  
  public boolean updateCheckStatus(List<String> paramList)
  {
    boolean bool = false;
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i = 0; i < paramList.size(); i++) {
      if (i == 0) {
        localStringBuffer.append("(" + (String)paramList.get(i));
      } else {
        localStringBuffer.append("," + (String)paramList.get(i));
      }
    }
    if ((localStringBuffer != null) && (localStringBuffer.length() > 0)) {
      localStringBuffer.append(")");
    }
    String str = localEasUserInfo.getUserId();
    Object localObject;
    if ((str == null) || (str.trim().length() == 0))
    {
      this.log.error("ID为" + localEasUserInfo.getUserInfoPk() + "的员工在session中找不到工号....................");
      if (localEasUserInfo.getUserInfoPk() != null)
      {
        localObject = (FbpEmployees)this.fbpEmployeesVDAO.getObject(FbpEmployees.class, localEasUserInfo.getUserInfoPk());
        str = ((FbpEmployees)localObject).getEmployeeNumber();
      }
    }
    try
    {
      localObject = null;
      for (int j = 0; j < paramList.size(); j++)
      {
        localObject = (EvsVoucher)this.evsVoucherCheckFindDAO.get(EvsVoucher.class, Long.valueOf(Long.parseLong((String)paramList.get(j))));
        this.evsVoucherHistoryDAO.addHistory(localEasUserInfo, 0L, ((EvsVoucher)localObject).getVoucherId().toString(), EvsStatusUtil.getVoucherStatusName("CHECKED"), ((EvsVoucher)localObject).getVoucherStatus(), "CHECKED_NO_BOOKED");
        ((EvsVoucher)localObject).setApprover(localEasUserInfo.getUserName());
        ((EvsVoucher)localObject).setApproverNumber(str);
        ((EvsVoucher)localObject).setApproverDate(new Date());
        this.evsVoucherCheckFindDAO.updateObject(localObject);
      }
      this.evsVoucherCheckFindDAO.updateCheckStatus("CHECKED_NO_BOOKED", localStringBuffer.toString());
      this.evsVoucherCheckFindDAO.saveVoucher(localStringBuffer.toString());
      bool = true;
    }
    catch (Exception localException) {}
    return bool;
  }
  
  public EvsVoucher getEvsVoucher(Long paramLong)
  {
    return (EvsVoucher)this.evsVoucherCheckFindDAO.getObject(EvsVoucher.class, paramLong);
  }
  
  public TableDataInfo getCheckList(EvsVoucherV paramEvsVoucherV, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    try
    {
      PageInfo localPageInfo = this.evsVoucherCheckFindDAO.findHeaderByQry(paramEvsVoucherV, paramInt1, paramInt2);
      localTableDataInfo.setData((List)localPageInfo.getResult());
      localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
      return localTableDataInfo;
    }
    catch (RuntimeException localRuntimeException)
    {
      localRuntimeException.printStackTrace();
    }
    return localTableDataInfo;
  }
  
  public String findHeader()
  {
    String str = "";
    List localList = this.evsVoucherCheckFindDAO.findHeader();
    if (localList.size() > 0)
    {
      str = ((EvsVoucherV)localList.get(0)).getJournalNum() + "," + ((EvsVoucherV)localList.get(0)).getVoucherId() + "," + ((EvsVoucherV)localList.get(0)).getBarcode();
      return str;
    }
    return str;
  }
  
  public TableDataInfo findCheckedList(EvsVoucherV paramEvsVoucherV, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    try
    {
      PageInfo localPageInfo = this.evsVoucherCheckFindDAO.findHeaderByCondition(paramEvsVoucherV, paramInt1, paramInt2);
      localTableDataInfo.setData((List)localPageInfo.getResult());
      localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
      return localTableDataInfo;
    }
    catch (RuntimeException localRuntimeException)
    {
      localRuntimeException.printStackTrace();
    }
    return localTableDataInfo;
  }
  
  public EvsVoucherCheckFindDAO getEvsVoucherCheckFindDAO()
  {
    return this.evsVoucherCheckFindDAO;
  }
  
  public void setEvsVoucherCheckFindDAO(EvsVoucherCheckFindDAO paramEvsVoucherCheckFindDAO)
  {
    this.evsVoucherCheckFindDAO = paramEvsVoucherCheckFindDAO;
  }
  
  public boolean updateBack(List<String> paramList)
  {
    boolean bool = false;
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i = 0; i < paramList.size(); i++) {
      if (i == 0) {
        localStringBuffer.append("(" + (String)paramList.get(i));
      } else {
        localStringBuffer.append("," + (String)paramList.get(i));
      }
    }
    if ((localStringBuffer != null) && (localStringBuffer.length() > 0)) {
      localStringBuffer.append(")");
    }
    try
    {
      EvsVoucher localEvsVoucher = null;
      for (int j = 0; j < paramList.size(); j++)
      {
        localEvsVoucher = (EvsVoucher)this.evsVoucherCheckFindDAO.get(EvsVoucher.class, Long.valueOf(Long.parseLong((String)paramList.get(j))));
        this.evsVoucherHistoryDAO.addHistory(localEasUserInfo, 0L, localEvsVoucher.getVoucherId().toString(), EvsStatusUtil.getOperName("BACK"), localEvsVoucher.getVoucherStatus(), "BACKED");
      }
      this.evsVoucherCheckFindDAO.update("BACKED", localStringBuffer.toString());
      this.evsVoucherCheckFindDAO.saveVoucher(localStringBuffer.toString());
      bool = true;
    }
    catch (Exception localException) {}
    return bool;
  }
  
  public TableDataInfo findEntry(EvsVoucherSelect paramEvsVoucherSelect, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    Map localMap = this.evsVoucherCheckFindDAO.findEntry(paramEvsVoucherSelect, paramInt1, paramInt2);
    List localList = (List)localMap.get("data");
    EvsImageV localEvsImageV = new EvsImageV();
    localEvsImageV.setBarname("无影像附件");
    localList.add(localEvsImageV);
    localTableDataInfo.setData(localList);
    localTableDataInfo.setTotalCount(Integer.parseInt(localMap.get("totalCount").toString()) + 1);
    return localTableDataInfo;
  }
  
  public TableDataInfo findImageInf(EvsImageModel paramEvsImageModel, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    Map localMap = this.evsVoucherCheckFindDAO.findImageInf(paramEvsImageModel, paramInt1, paramInt2);
    List localList = (List)localMap.get("data");
    ArrayList localArrayList = new ArrayList();
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        Object[] arrayOfObject = (Object[])localIterator.next();
        EvsImageModel localEvsImageModel = new EvsImageModel();
        localEvsImageModel.setBarcode(arrayOfObject[0] == null ? "" : arrayOfObject[0].toString());
        localEvsImageModel.setImageNumber(arrayOfObject[1] == null ? "" : arrayOfObject[1].toString());
        localEvsImageModel.setCompanyCode(arrayOfObject[2] == null ? "" : arrayOfObject[2].toString());
        localEvsImageModel.setSelected(arrayOfObject[3] == null ? "" : arrayOfObject[3].toString());
        localArrayList.add(localEvsImageModel);
      }
    }
    localTableDataInfo.setData(localArrayList);
    localTableDataInfo.setTotalCount(Integer.parseInt(localMap.get("totalCount").toString()));
    return localTableDataInfo;
  }
  
  public TableDataInfo findInvoices(EvsVoucherSelect paramEvsVoucherSelect, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    Map localMap = this.evsVoucherCheckFindDAO.findInvoices(paramEvsVoucherSelect, paramInt1, paramInt2);
    localTableDataInfo.setData((List)localMap.get("data"));
    localTableDataInfo.setTotalCount(Integer.parseInt(localMap.get("totalCount").toString()));
    return localTableDataInfo;
  }
  
  public String updateBatchVoucher(List<EvsVoucherSelect> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      EvsVoucherSelect localEvsVoucherSelect = (EvsVoucherSelect)localIterator.next();
      updateVoucher(localEvsVoucherSelect, null);
    }
    return "suc";
  }
  
  public void updateVoucher(EvsVoucherSelect paramEvsVoucherSelect, String paramString)
  {
    System.out.println(paramString);
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    EvsVoucher localEvsVoucher = (EvsVoucher)this.evsVoucherCheckFindDAO.get(EvsVoucher.class, paramEvsVoucherSelect.getVoucherId());
    if ("MATCHED".equals(localEvsVoucher.getVoucherStatus())) {
      this.evsVoucherHistoryDAO.addHistory(localEasUserInfo, 0L, localEvsVoucher.getVoucherId().toString(), EvsStatusUtil.getOperName("MATCH"), localEvsVoucher.getVoucherStatus(), "MATCHED");
    }
    if ("UNMATCH".equals(localEvsVoucher.getVoucherStatus()))
    {
      localEvsVoucher.setVoucherStatus("MATCHED");
      localEvsVoucher.setLastUpdateDate(new Date());
      localEvsVoucher.setLastUpdateBy(Long.valueOf(localEasUserInfo.getUserInfoPk().longValue()));
      localEvsVoucher.setLastUpdateLogin(Long.valueOf(localEasUserInfo.getUserInfoPk().longValue()));
      this.evsVoucherHistoryDAO.addHistory(localEasUserInfo, 0L, localEvsVoucher.getVoucherId().toString(), EvsStatusUtil.getOperName("MATCH"), localEvsVoucher.getVoucherStatus(), "UNMATCH");
      this.evsVoucherHistoryDAO.addHistory(localEasUserInfo, 0L, localEvsVoucher.getVoucherId().toString(), EvsStatusUtil.getOperName("SUBMIT"), localEvsVoucher.getVoucherStatus(), "MATCHED");
    }
    if ("无影像附件".equals(paramEvsVoucherSelect.getBarcode()))
    {
      localEvsVoucher.setBarcode("NOIMAGE");
      localEvsVoucher.setVoucherStatus("MATCHED");
      this.evsVoucherCheckFindDAO.updateImageByVoucherId(paramEvsVoucherSelect.getVoucherId());
    }
    localEvsVoucher.setMatchMode("手动匹配");
    this.evsVoucherCheckFindDAO.updateImageByVoucherId(paramEvsVoucherSelect.getVoucherId());
    if ((paramString != null) && (!"".equals(paramString.trim())))
    {
      String[] arrayOfString = paramString.split(",");
      StringBuffer localStringBuffer = new StringBuffer();
      for (int i = 0; i < arrayOfString.length; i++) {
        if (i == 0) {
          localStringBuffer.append("('" + arrayOfString[i]);
        } else {
          localStringBuffer.append("','" + arrayOfString[i]);
        }
      }
      if ((localStringBuffer != null) && (localStringBuffer.length() > 0)) {
        localStringBuffer.append("')");
      }
      this.evsVoucherCheckFindDAO.updateImage(paramEvsVoucherSelect.getVoucherId(), localStringBuffer.toString());
    }
    this.evsVoucherCheckFindDAO.updateEntry(localEvsVoucher);
  }
  
  public List<EvsVoucherV> findEvsVoucherVByVoucherId(String paramString)
  {
    return this.evsVoucherCheckFindDAO.findEvsVoucherVList(paramString);
  }
  
  public boolean addcheckComment(List<String> paramList)
  {
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    ISession localISession = localRIAContext.getSession();
    EasUserInfo localEasUserInfo = (EasUserInfo)localISession.getSessionAttribute("easloginuserinfo");
    FbpEmployeesV localFbpEmployeesV = this.fbpEmployeesVDAO.findEmployeesByNumber(localEasUserInfo.getUserId());
    ArrayList localArrayList = new ArrayList();
    try
    {
      if (paramList != null)
      {
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          EvsVoucherCheckHistories localEvsVoucherCheckHistories = new EvsVoucherCheckHistories();
          ObjectCopyUtils.setWho(localEvsVoucherCheckHistories);
          Long localLong = Long.valueOf(Long.parseLong(str));
          localEvsVoucherCheckHistories.setCheckEmployeeId(Long.valueOf(localFbpEmployeesV.getEmployeeId().longValue()));
          localEvsVoucherCheckHistories.setCheckEmployeeNum(localFbpEmployeesV.getEmployeeNumber());
          localEvsVoucherCheckHistories.setCheckEmployeeName(localFbpEmployeesV.getEmployeeName());
          localEvsVoucherCheckHistories.setVoucherId(localLong);
          localEvsVoucherCheckHistories.setCheckDate(new Date());
          localEvsVoucherCheckHistories.setEnabledFlag("Y");
          localEvsVoucherCheckHistories.setCheckComment("复核通过");
          localArrayList.add(localEvsVoucherCheckHistories);
        }
      }
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        this.evsVoucherHistoryDAO.insertObjects(localArrayList);
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return false;
    }
    return true;
  }
  
  public boolean addcheckCommentNote(String paramString1, String paramString2, String paramString3)
  {
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    ISession localISession = localRIAContext.getSession();
    EasUserInfo localEasUserInfo = (EasUserInfo)localISession.getSessionAttribute("easloginuserinfo");
    FbpEmployeesV localFbpEmployeesV1 = this.fbpEmployeesVDAO.findEmployeesByNumber(localEasUserInfo.getUserId());
    FbpLookupValuesV localFbpLookupValuesV = this.lookupValuesVDAO.findFbpLookupValues("UNTREAD_CAUSE", paramString2);
    if (localFbpLookupValuesV != null) {
      paramString2 = localFbpLookupValuesV.getDescription();
    }
    IFbpNoticesNewDS localIFbpNoticesNewDS = (IFbpNoticesNewDS)SSBBus.findDomainService("fbpNoticesNewDS");
    EvsVoucher localEvsVoucher = this.evsVoucherCheckFindDAO.findEvsVoucher(paramString1);
    List localList1 = this.fbpImagesDAO.findImageByImage(Long.valueOf(Long.parseLong(paramString1)));
    List localList2 = this.evsVoucherCheckFindDAO.findEvsVoucherInvoice(paramString1);
    EvsVoucherHistory localEvsVoucherHistory = new EvsVoucherHistory();
    FbpEmployeesV localFbpEmployeesV2 = new FbpEmployeesV();
    if (!localEvsVoucher.getUserNumber().equals("")) {
      localFbpEmployeesV2 = this.fbpEmployeesVDAO.findEmployeesByNumber(localEvsVoucher.getUserNumber());
    } else {
      localFbpEmployeesV2 = null;
    }
    try
    {
      if (paramString1 != null)
      {
        ObjectCopyUtils.setWho(localEvsVoucherHistory);
        localEvsVoucherHistory.setOpObjectType(Long.valueOf(0L));
        localEvsVoucherHistory.setOpPeople(Long.valueOf(localFbpEmployeesV1.getEmployeeId().longValue()));
        localEvsVoucherHistory.setObjectCode(localEvsVoucher.getVoucherId().toString());
        localEvsVoucherHistory.setAction("退回");
        localEvsVoucherHistory.setHandleDate(new Date());
        localEvsVoucherHistory.setBeginStatus(localEvsVoucher.getVoucherStatus());
        localEvsVoucherHistory.setEndStatus("BACKED");
        localEvsVoucherHistory.setCheckComment(paramString2);
        localEvsVoucherHistory.setDescribe(paramString3);
        this.evsVoucherHistoryDAO.insertObject(localEvsVoucherHistory);
        localEvsVoucher.setLastUpdateDate(new Date());
        localEvsVoucher.setLastUpdateBy(Long.valueOf(localFbpEmployeesV1.getEmployeeId().longValue()));
        localEvsVoucher.setLastUpdateLogin(Long.valueOf(localFbpEmployeesV1.getEmployeeId().longValue()));
        localEvsVoucher.setVoucherStatus("BACKED");
        localEvsVoucher.setBarcode("");
        this.evsVoucherCheckFindDAO.updateObject(localEvsVoucher);
        Iterator localIterator;
        Object localObject;
        if (localList1.size() > 0)
        {
          localIterator = localList1.iterator();
          while (localIterator.hasNext())
          {
            localObject = (EvsImage)localIterator.next();
            ((EvsImage)localObject).setLastUpdateDate(new Date());
            ((EvsImage)localObject).setLastUpdateBy(Long.valueOf(localFbpEmployeesV1.getEmployeeId().longValue()));
            ((EvsImage)localObject).setLastUpdateLogin(Long.valueOf(localFbpEmployeesV1.getEmployeeId().longValue()));
            ((EvsImage)localObject).setVoucherId(null);
            this.evsVoucherCheckFindDAO.updateObject(localObject);
          }
        }
        if (localList2.size() > 0)
        {
          localIterator = localList2.iterator();
          while (localIterator.hasNext())
          {
            localObject = (EvsVoucherInvoice)localIterator.next();
            ((EvsVoucherInvoice)localObject).setLastUpdateDate(new Date());
            ((EvsVoucherInvoice)localObject).setLastUpdateBy(Long.valueOf(localFbpEmployeesV1.getEmployeeId().longValue()));
            ((EvsVoucherInvoice)localObject).setLastUpdateLogin(Long.valueOf(localFbpEmployeesV1.getEmployeeId().longValue()));
            ((EvsVoucherInvoice)localObject).setEnabledFlag("N");
            this.evsVoucherCheckFindDAO.updateObject(localObject);
          }
        }
        if (localFbpEmployeesV2 != null)
        {
          this.log.error("××××凭证复核 退回××××");
          this.log.error(paramString1 + "退回时短信/邮件通知经办人 BEGIN");
          FbpNoticesNew localFbpNoticesNew = new FbpNoticesNew();
          SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
          StringBuilder localStringBuilder = new StringBuilder("您好，").append(localEvsVoucher.getJournalNum()).append("单号的业务由于").append(paramString2).append("（原因）已退单，请及时整改后重新提交");
          this.log.error("退回时短信/邮件通知经办人 info :" + localStringBuilder.toString());
          localFbpNoticesNew.setContent(localStringBuilder.toString());
          localFbpNoticesNew.setToUserId(localFbpEmployeesV2.getEmployeeId().toString());
          localFbpNoticesNew.setFromUserId(Long.valueOf(localFbpEmployeesV1.getEmployeeId().longValue()));
          localFbpNoticesNew.setBoeHeaderId(Long.valueOf(localEvsVoucher.getVoucherId().longValue()));
          localFbpNoticesNew.setTemplateId("BACKED");
          localFbpNoticesNew.setId(null);
          localFbpNoticesNew.setNoticeType("1");
          localIFbpNoticesNewDS.insertFbpNoticesNew(localFbpNoticesNew);
          localFbpNoticesNew.setTemplateId("BACKED");
          localFbpNoticesNew.setNoticeType("2");
          localFbpNoticesNew.setId(null);
          localIFbpNoticesNewDS.insertFbpNoticesNew(localFbpNoticesNew);
          this.log.error(paramString1 + "退回时短信/邮件通知经办人 END");
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return false;
    }
    return true;
  }
  
  public List<EvsVoucherHistoryV> findAppraiseDesc(String paramString)
  {
    return this.evsVoucherHistoryDAO.findHistoryVById(Long.valueOf(0L), paramString);
  }
  
  public boolean addcheckCommentBack(List<String> paramList, String paramString)
  {
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    ISession localISession = localRIAContext.getSession();
    EasUserInfo localEasUserInfo = (EasUserInfo)localISession.getSessionAttribute("easloginuserinfo");
    FbpEmployeesV localFbpEmployeesV = this.fbpEmployeesVDAO.findEmployeesByNumber(localEasUserInfo.getUserId());
    ArrayList localArrayList = new ArrayList();
    try
    {
      if (paramList != null)
      {
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          EvsVoucherCheckHistories localEvsVoucherCheckHistories = new EvsVoucherCheckHistories();
          ObjectCopyUtils.setWho(localEvsVoucherCheckHistories);
          Long localLong = Long.valueOf(Long.parseLong(str));
          localEvsVoucherCheckHistories.setCheckEmployeeId(Long.valueOf(localFbpEmployeesV.getEmployeeId().longValue()));
          localEvsVoucherCheckHistories.setCheckEmployeeNum(localFbpEmployeesV.getEmployeeNumber());
          localEvsVoucherCheckHistories.setCheckEmployeeName(localFbpEmployeesV.getEmployeeName());
          localEvsVoucherCheckHistories.setVoucherId(localLong);
          localEvsVoucherCheckHistories.setCheckDate(new Date());
          localEvsVoucherCheckHistories.setEnabledFlag("Y");
          localEvsVoucherCheckHistories.setCheckComment(paramString);
          localArrayList.add(localEvsVoucherCheckHistories);
        }
      }
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        this.evsVoucherHistoryDAO.insertObjects(localArrayList);
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return false;
    }
    return true;
  }
  
  public void createInvoice()
  {
    try
    {
      new InvoiceAction().buildInvoiceById(1L);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public String createInvoice(Long paramLong)
  {
    try
    {
      new InvoiceAction().buildInvoiceById(paramLong.longValue());
    }
    catch (Exception localException)
    {
      this.log.error(paramLong + "生成凭证封面错误", localException);
      throw new RuntimeException(localException.getMessage());
    }
    return "凭证封面生成成功";
  }
  
  public TableDataInfo getCheckList(EvsVoucherSelect paramEvsVoucherSelect, int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public List<String> getCheckedInvoiceArr(Long paramLong)
  {
    List localList = this.evsVoucherCheckFindDAO.getCheckedInvoiceArr(paramLong);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      BigDecimal localBigDecimal = (BigDecimal)localIterator.next();
      localArrayList.add(localBigDecimal.toString());
    }
    return localArrayList;
  }
  
  public String saveInvoice(Long paramLong, List<String> paramList)
  {
    this.evsVoucherCheckFindDAO.deleteInvoice(paramLong);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = paramList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject3 = new EvsVoucherInvoice();
      ObjectCopyUtils.setWho(localObject3);
      ((EvsVoucherInvoice)localObject3).setVoucherId(paramLong);
      ((EvsVoucherInvoice)localObject3).setInvoiceId(new Long((String)localObject2));
      ((EvsVoucherInvoice)localObject3).setEnabledFlag("Y");
      ((EvsVoucherInvoice)localObject3).setRelationType("I");
      localArrayList.add(localObject3);
    }
    if (!localArrayList.isEmpty()) {
      this.evsVoucherCheckFindDAO.insertObjects(localArrayList);
    }
    localObject1 = "SUBMITED";
    Object localObject2 = (EvsVoucher)this.evsVoucherCheckFindDAO.getObject(EvsVoucher.class, paramLong);
    ((EvsVoucher)localObject2).setMatchMode("手动匹配");
    Object localObject3 = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    if (("UNMATCH".equals(((EvsVoucher)localObject2).getVoucherStatus())) || ("BACKED".equals(((EvsVoucher)localObject2).getVoucherStatus())))
    {
      this.evsVoucherHistoryDAO.addHistory(localEasUserInfo, 0L, ((EvsVoucher)localObject2).getVoucherId().toString(), EvsStatusUtil.getOperName("MATCH"), ((EvsVoucher)localObject2).getVoucherStatus(), "MATCHED");
      this.evsVoucherHistoryDAO.addHistory(localEasUserInfo, 0L, ((EvsVoucher)localObject2).getVoucherId().toString(), EvsStatusUtil.getOperName("SUBMIT"), "MATCHED", "SUBMITED");
    }
    ObjectCopyUtils.setWho(localObject2);
    FbpCompanyV localFbpCompanyV = this.fbpCompanyVDAO.findByCompCode(((EvsVoucher)localObject2).getCompanyCode());
    if ((localFbpCompanyV != null) && ("N".equals(localFbpCompanyV.getIsCheck())))
    {
      this.evsVoucherHistoryDAO.addHistory(localEasUserInfo, 0L, ((EvsVoucher)localObject2).getVoucherId().toString(), EvsStatusUtil.getOperName("CHECK"), "SUBMITED", "CHECKED_NO_BOOKED");
      localObject1 = "CHECKED_NO_BOOKED";
    }
    ObjectCopyUtils.setWho(localObject2);
    ((EvsVoucher)localObject2).setVoucherStatus((String)localObject1);
    this.evsVoucherCheckFindDAO.updateObject(localObject2);
    return "S";
  }
  
  public TableDataInfo findcheckedInvoices(Long paramLong, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    PageInfo localPageInfo = this.evsVoucherCheckFindDAO.findcheckedInvoices(paramLong, paramInt1, paramInt2);
    localTableDataInfo.setData((List)localPageInfo.getResult());
    localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
    return localTableDataInfo;
  }
  
  public String cancelVoucher(Long paramLong)
  {
    EvsVoucher localEvsVoucher = (EvsVoucher)this.evsVoucherCheckFindDAO.getObject(EvsVoucher.class, paramLong);
    if (!"SUBMITED".equals(localEvsVoucher.getVoucherStatus())) {
      return "非复核状态不能退回";
    }
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    this.evsVoucherHistoryDAO.addHistory(localEasUserInfo, 0L, localEvsVoucher.getVoucherId().toString(), EvsStatusUtil.getOperName("BACKED"), localEvsVoucher.getVoucherStatus(), "BACKED");
    ObjectCopyUtils.setWho(localEvsVoucher);
    localEvsVoucher.setVoucherStatus("BACKED");
    this.evsVoucherCheckFindDAO.updateObject(localEvsVoucher);
    return ComResUtil.getMessage("Evs.Voucher.Check.Service.msg1");
  }
  
  public List<EvsVoucherListV> getEvsVoucherListVByIds(List<String> paramList)
  {
    for (int i = 0; i < paramList.size(); i++)
    {
      String str = (String)paramList.get(i);
      updateVoucherStatus(Long.valueOf(str));
    }
    return this.evsVoucherCheckFindDAO.getEvsVoucherListVByIds(paramList);
  }
  
  public String printValiate(List<String> paramList)
  {
    return this.evsVoucherCheckFindDAO.printValiate(paramList);
  }
  
  public static String getBoeNum(String paramString)
  {
    if ((paramString == null) || (paramString.trim().length() < 3)) {
      return "";
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("F01", "F01");
    localHashMap.put("F02", "F02");
    localHashMap.put("A01", "A01");
    localHashMap.put("A02", "A02");
    localHashMap.put("C01", "C01");
    String str = paramString.substring(0, 3);
    if (localHashMap.containsKey(str)) {
      return paramString;
    }
    return "";
  }
  
  public List<EvsVoucherPrint> getPrintList(String paramString)
  {
    String[] arrayOfString = paramString.split(",");
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    Calendar localCalendar = Calendar.getInstance();
    DecimalFormat localDecimalFormat = new DecimalFormat();
    localDecimalFormat.applyPattern("#,##0.00");
    Map localMap = getCurrencyCodeLabel();
    for (int j = 0; j < arrayOfString.length; j++)
    {
      Long localLong = Long.valueOf(arrayOfString[j]);
      EvsVoucher localEvsVoucher = (EvsVoucher)this.evsVoucherCheckFindDAO.getObject(EvsVoucher.class, localLong);
      updateVoucherStatus(localLong);
      List localList = this.evsVoucherLineDAO.findPrintListByVoucherId(localLong);
      i = localList.size() / this.pageSize.intValue() + (localList.size() % this.pageSize.intValue() == 0 ? 0 : 1);
      BigDecimal localBigDecimal1 = BigDecimal.ZERO;
      BigDecimal localBigDecimal2 = BigDecimal.ZERO;
      BigDecimal localBigDecimal3 = null;
      for (int k = 0; k < i; k++)
      {
        EvsVoucherPrint localEvsVoucherPrint = new EvsVoucherPrint();
        localEvsVoucherPrint.setDocSequenceValue(localEvsVoucher.getVoucherSeqValue());
        if (localEvsVoucher.getJournalDate() != null) {
          localCalendar.setTime(localEvsVoucher.getJournalDate());
        }
        localEvsVoucherPrint.setJournalYear(localCalendar.get(1) + "");
        localEvsVoucherPrint.setJournalMonth(localCalendar.get(2) + 1 + "");
        localEvsVoucherPrint.setJournalDate(localCalendar.get(5) + "");
        localEvsVoucherPrint.setCurrencyCode(localEvsVoucher.getCurrencyCode());
        localEvsVoucherPrint.setPageNum(k + 1 + "/" + i);
        localEvsVoucherPrint.setBoeNum(getBoeNum(localEvsVoucher.getBoeNum()));
        FbpCompanyV localFbpCompanyV = null;
        if (org.apache.commons.lang.StringUtils.isNotBlank(localEvsVoucher.getCompanyCode())) {
          localFbpCompanyV = this.fbpCompanyVDAO.findByCompCode(localEvsVoucher.getCompanyCode());
        }
        localEvsVoucherPrint.setJournalNum(localEvsVoucher.getJournalNum());
        if (localFbpCompanyV != null)
        {
          localEvsVoucherPrint.setCompany(localFbpCompanyV.getCompany());
          localEvsVoucherPrint.setCompanyName(localFbpCompanyV.getCompanyName());
          if ("U8,NC".indexOf(localFbpCompanyV.getSetOfBooksCode() + "") > -1) {
            localEvsVoucherPrint.setJournalNum(localEvsVoucher.getInvoiceType() + "&nbsp;" + localEvsVoucher.getJournalNum());
          } else {
            localEvsVoucherPrint.setJournalNum(localEvsVoucher.getInvoiceType() + "&nbsp;" + localEvsVoucher.getJournalNum());
          }
        }
        localEvsVoucherPrint.setConvertRate(localEvsVoucher.getConvertRate() + "");
        localEvsVoucherPrint.setBillNum(localEvsVoucher.getBillNum());
        if (org.apache.commons.lang.StringUtils.isNotBlank(localEvsVoucher.getUserName()))
        {
          localEvsVoucherPrint.setUserName(localEvsVoucher.getUserName());
        }
        else
        {
          FbpEmployeesTl localFbpEmployeesTl = this.fbpEmployeesVDAO.getFbpEmployeesTl(localEvsVoucher.getUserNumber());
          if (localFbpEmployeesTl != null) {
            localEvsVoucherPrint.setUserName(localFbpEmployeesTl.getEmployeeName());
          }
        }
        localEvsVoucherPrint.setFinanceController(localEvsVoucher.getFinanceController());
        localEvsVoucherPrint.setFinanceExecutive(localEvsVoucher.getFinanceExecutive());
        localEvsVoucherPrint.setCashier(localEvsVoucher.getCashier());
        localEvsVoucherPrint.setApprover(localEvsVoucher.getApprover());
        localEvsVoucherPrint.setOrgCharge(localEvsVoucher.getOrgCharge());
        if ((org.apache.commons.lang.StringUtils.isNotBlank(localEvsVoucher.getCashierNumber())) && (this.fbpImagesDAO.getFbpImagesByEmployeeNumber(localEvsVoucher.getCashierNumber()) != null)) {
          localEvsVoucherPrint.setCashierNumber(localEvsVoucher.getCashierNumber());
        }
        int m = (k + 1) * this.pageSize.intValue() > localList.size() ? localList.size() : (k + 1) * this.pageSize.intValue();
        EvsVoucherLine[] arrayOfEvsVoucherLine = new EvsVoucherLine[m - k * this.pageSize.intValue()];
        for (int n = k * this.pageSize.intValue(); n < m; n++)
        {
          EvsVoucherLine localEvsVoucherLine = (EvsVoucherLine)localList.get(n);
          if (localEvsVoucherLine.getAccCr() != null)
          {
            localBigDecimal2 = localBigDecimal2.add(localEvsVoucherLine.getAccCr());
            localEvsVoucherLine.setAccCrStr(localDecimalFormat.format(localEvsVoucherLine.getAccCr().doubleValue()));
          }
          if (localEvsVoucherLine.getAccDr() != null)
          {
            localBigDecimal1 = localBigDecimal1.add(localEvsVoucherLine.getAccDr());
            localEvsVoucherLine.setAccDrStr(localDecimalFormat.format(localEvsVoucherLine.getAccDr().doubleValue()));
          }
          if (localEvsVoucherLine.getCurrencyAmount() != null)
          {
            if (localBigDecimal3 == null) {
              localBigDecimal3 = BigDecimal.ZERO;
            }
            localBigDecimal3 = localBigDecimal3.add(localEvsVoucherLine.getCurrencyAmount());
            localEvsVoucherLine.setCurrencyAmountStr(localDecimalFormat.format(localEvsVoucherLine.getCurrencyAmount().doubleValue()));
          }
          setNull2Empty(localEvsVoucherLine);
          if ("RMB".equals(localEvsVoucherPrint.getCurrencyCode())) {
            localEvsVoucherLine.setCurrencyAmountStr("");
          }
          arrayOfEvsVoucherLine[(n % this.pageSize.intValue())] = localEvsVoucherLine;
        }
        localEvsVoucherPrint.setVoucherLines(arrayOfEvsVoucherLine);
        if (k == i - 1)
        {
          localEvsVoucherPrint.setAccCrTotal(localDecimalFormat.format(localBigDecimal2));
          localEvsVoucherPrint.setAccCrZh((localMap.get("RMB") == null ? "" : (String)localMap.get("RMB")) + com.zte.evs.ebill.common.invoice.util.StringUtils.numberToChinese(localBigDecimal2.doubleValue()));
          localEvsVoucherPrint.setAccDrTotal(localDecimalFormat.format(localBigDecimal1));
          localEvsVoucherPrint.setAccDrZh((localMap.get("RMB") == null ? "" : (String)localMap.get("RMB")) + com.zte.evs.ebill.common.invoice.util.StringUtils.numberToChinese(localBigDecimal1.doubleValue()));
          if (localBigDecimal3 != null)
          {
            localBigDecimal3 = localBigDecimal3.divide(BigDecimal.valueOf(2L));
            localEvsVoucherPrint.setCurrencyAmountTotal(localDecimalFormat.format(localBigDecimal3));
            localEvsVoucherPrint.setCurrencyAmountZh((localMap.get(localEvsVoucher.getCurrencyCode()) == null ? "" : (String)localMap.get(localEvsVoucher.getCurrencyCode())) + com.zte.evs.ebill.common.invoice.util.StringUtils.numberToChinese(localBigDecimal3.doubleValue()));
          }
        }
        setNull2Empty(localEvsVoucherPrint);
        if ("RMB".equals(localEvsVoucherPrint.getCurrencyCode()))
        {
          localEvsVoucherPrint.setCurrencyAmountZh(localEvsVoucherPrint.getAccDrZh());
          localEvsVoucherPrint.setCurrencyAmountTotal("");
        }
        localArrayList.add(localEvsVoucherPrint);
      }
    }
    return localArrayList;
  }
  
  public static Map<String, String> getCurrencyCodeLabel()
  {
    HashMap localHashMap = new HashMap();
    IFbpLookupValuesVDAO localIFbpLookupValuesVDAO = (IFbpLookupValuesVDAO)SSBBus.findDomainService("lookupValuesVDAO");
    List localList = localIFbpLookupValuesVDAO.findFbpLookupValuess("CURRENCY_CODE_LABEL");
    if ((localList != null) && (!localList.isEmpty()))
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        FbpLookupValuesV localFbpLookupValuesV = (FbpLookupValuesV)localIterator.next();
        localHashMap.put(localFbpLookupValuesV.getLookupCode(), localFbpLookupValuesV.getMeaning());
      }
    }
    return localHashMap;
  }
  
  public String totalPrintValiate(List<String> paramList)
  {
    return this.evsVoucherCheckFindDAO.totalPrintValiate(paramList).size() + "";
  }
  
  public List<EvsVoucherPrint> getTotalPrintList(String paramString)
  {
    String[] arrayOfString = paramString.split(",");
    ArrayList localArrayList = new ArrayList();
    Map localMap = getCurrencyCodeLabel();
    int i = 0;
    Calendar localCalendar = Calendar.getInstance();
    DecimalFormat localDecimalFormat = new DecimalFormat();
    localDecimalFormat.applyPattern("#,##0.00");
    Long localLong = Long.valueOf(arrayOfString[0]);
    for (int j = 0; j < arrayOfString.length; j++) {
      updateVoucherStatus(Long.valueOf(arrayOfString[j]));
    }
    EvsVoucher localEvsVoucher = (EvsVoucher)this.evsVoucherCheckFindDAO.getObject(EvsVoucher.class, localLong);
    List localList1 = this.evsVoucherCheckFindDAO.totalTotalPrintList(Arrays.asList(arrayOfString));
    i = localList1.size() / this.pageSize.intValue() + (localList1.size() % this.pageSize.intValue() == 0 ? 0 : 1);
    BigDecimal localBigDecimal1 = BigDecimal.ZERO;
    BigDecimal localBigDecimal2 = BigDecimal.ZERO;
    BigDecimal localBigDecimal3 = null;
    for (int k = 0; k < i; k++)
    {
      EvsVoucherPrint localEvsVoucherPrint = new EvsVoucherPrint();
      if (localEvsVoucher.getJournalDate() != null) {
        localCalendar.setTime(localEvsVoucher.getJournalDate());
      }
      localEvsVoucherPrint.setTotalFlag("（汇总）");
      localEvsVoucherPrint.setCurrencyCode(localEvsVoucher.getCurrencyCode());
      localEvsVoucherPrint.setPageNum(k + 1 + "/" + i);
      localEvsVoucherPrint.setConvertRate(localEvsVoucher.getConvertRate() + "");
      FbpCompanyV localFbpCompanyV = null;
      if (org.apache.commons.lang.StringUtils.isNotBlank(localEvsVoucher.getCompanyCode())) {
        localFbpCompanyV = this.fbpCompanyVDAO.findByCompCode(localEvsVoucher.getCompanyCode());
      }
      if (localFbpCompanyV != null) {
        localEvsVoucherPrint.setCompanyName(localFbpCompanyV.getCompanyName());
      }
      localEvsVoucherPrint.setCompany(localFbpCompanyV.getCompany());
      localEvsVoucherPrint.setCompanyName(localFbpCompanyV.getCompanyName());
      if (arrayOfString.length == 1)
      {
        localEvsVoucherPrint.setJournalYear(localCalendar.get(1) + "");
        localEvsVoucherPrint.setJournalMonth(localCalendar.get(2) + 1 + "");
        localEvsVoucherPrint.setJournalDate(localCalendar.get(5) + "");
        localEvsVoucherPrint.setDocSequenceValue(localEvsVoucher.getVoucherSeqValue());
        localEvsVoucherPrint.setJournalNum(localEvsVoucher.getJournalNum());
        if ((localFbpCompanyV != null) && ("U8,NC".indexOf(localFbpCompanyV.getSetOfBooksCode() + "") > -1)) {
          localEvsVoucherPrint.setJournalNum(localEvsVoucher.getInvoiceType() + localEvsVoucher.getJournalNum());
        } else {
          localEvsVoucherPrint.setJournalNum(localEvsVoucher.getInvoiceTypeCode() + localEvsVoucher.getJournalNum());
        }
      }
      else
      {
        localList2 = this.evsVoucherCheckFindDAO.totalTotalBoeNum(Arrays.asList(arrayOfString));
        localEvsVoucherPrint.setJournalNum("");
        if (localList2.size() == 1) {
          localEvsVoucherPrint.setJournalNum("参照号：" + (String)localList2.get(0));
        }
      }
      List localList2 = this.evsVoucherCheckFindDAO.totalPrintValiate(Arrays.asList(arrayOfString));
      localEvsVoucherPrint.setBillNum(localList2.get(0) + "");
      localEvsVoucherPrint.setUserName(localEvsVoucher.getUserName());
      if ((org.apache.commons.lang.StringUtils.isNotBlank(localEvsVoucher.getUserNumber())) && (this.fbpImagesDAO.getFbpImagesByEmployeeNumber(localEvsVoucher.getUserNumber()) != null)) {
        localEvsVoucherPrint.setUserNumber(localEvsVoucher.getUserNumber());
      }
      int m = (k + 1) * this.pageSize.intValue() > localList1.size() ? localList1.size() : (k + 1) * this.pageSize.intValue();
      EvsVoucherLine[] arrayOfEvsVoucherLine = new EvsVoucherLine[m - k * this.pageSize.intValue()];
      for (int n = k * this.pageSize.intValue(); n < m; n++)
      {
        Object[] arrayOfObject = (Object[])localList1.get(n);
        EvsVoucherLine localEvsVoucherLine = new EvsVoucherLine();
        localEvsVoucherLine.setAccCr((BigDecimal)arrayOfObject[0]);
        localEvsVoucherLine.setAccDr((BigDecimal)arrayOfObject[1]);
        localEvsVoucherLine.setCurrencyAmount((BigDecimal)arrayOfObject[2]);
        localEvsVoucherLine.setSubjectCode(arrayOfObject[3] + "");
        localEvsVoucherLine.setSubjectDetail(arrayOfObject[4] + "");
        localEvsVoucherLine.setLineDesc(arrayOfObject[5] + "");
        if (localEvsVoucherLine.getAccCr() != null)
        {
          localBigDecimal2 = localBigDecimal2.add(localEvsVoucherLine.getAccCr());
          localEvsVoucherLine.setAccCrStr(localDecimalFormat.format(localEvsVoucherLine.getAccCr().doubleValue()));
        }
        if (localEvsVoucherLine.getAccDr() != null)
        {
          localBigDecimal1 = localBigDecimal1.add(localEvsVoucherLine.getAccDr());
          localEvsVoucherLine.setAccDrStr(localDecimalFormat.format(localEvsVoucherLine.getAccDr().doubleValue()));
        }
        if (localEvsVoucherLine.getCurrencyAmount() != null)
        {
          if (localBigDecimal3 == null) {
            localBigDecimal3 = BigDecimal.ZERO;
          }
          localBigDecimal3 = localBigDecimal3.add(localEvsVoucherLine.getCurrencyAmount());
          localEvsVoucherLine.setCurrencyAmountStr(localDecimalFormat.format(localEvsVoucherLine.getCurrencyAmount().doubleValue()));
        }
        setNull2Empty(localEvsVoucherLine);
        if ("RMB".equals(localEvsVoucherPrint.getCurrencyCode())) {
          localEvsVoucherLine.setCurrencyAmountStr("");
        }
        arrayOfEvsVoucherLine[(n % this.pageSize.intValue())] = localEvsVoucherLine;
      }
      localEvsVoucherPrint.setVoucherLines(arrayOfEvsVoucherLine);
      if (k == i - 1)
      {
        localEvsVoucherPrint.setAccCrTotal(localDecimalFormat.format(localBigDecimal2));
        localEvsVoucherPrint.setAccCrZh((localMap.get("RMB") == null ? "" : (String)localMap.get("RMB")) + com.zte.evs.ebill.common.invoice.util.StringUtils.numberToChinese(localBigDecimal2.doubleValue()));
        localEvsVoucherPrint.setAccDrTotal(localDecimalFormat.format(localBigDecimal1));
        localEvsVoucherPrint.setAccDrZh((localMap.get("RMB") == null ? "" : (String)localMap.get("RMB")) + com.zte.evs.ebill.common.invoice.util.StringUtils.numberToChinese(localBigDecimal1.doubleValue()));
        if (localBigDecimal3 != null)
        {
          localBigDecimal3 = localBigDecimal3.divide(BigDecimal.valueOf(2L));
          localEvsVoucherPrint.setCurrencyAmountTotal(localDecimalFormat.format(localBigDecimal3));
          localEvsVoucherPrint.setCurrencyAmountZh((localMap.get(localEvsVoucher.getCurrencyCode()) == null ? "" : (String)localMap.get(localEvsVoucher.getCurrencyCode())) + com.zte.evs.ebill.common.invoice.util.StringUtils.numberToChinese(localBigDecimal3.doubleValue()));
        }
        else
        {
          localEvsVoucherPrint.setCurrencyAmountTotal("");
          localEvsVoucherPrint.setCurrencyAmountZh("");
        }
      }
      setNull2Empty(localEvsVoucherPrint);
      if ("RMB".equals(localEvsVoucherPrint.getCurrencyCode()))
      {
        localEvsVoucherPrint.setCurrencyAmountZh(localEvsVoucherPrint.getAccCrZh());
        localEvsVoucherPrint.setCurrencyAmountTotal("");
      }
      localArrayList.add(localEvsVoucherPrint);
    }
    return localArrayList;
  }
  
  public static void setNull2Empty(Object paramObject)
  {
    try
    {
      BeanInfo localBeanInfo = Introspector.getBeanInfo(paramObject.getClass());
      PropertyDescriptor[] arrayOfPropertyDescriptor1 = localBeanInfo.getPropertyDescriptors();
      for (PropertyDescriptor localPropertyDescriptor : arrayOfPropertyDescriptor1)
      {
        String str = localPropertyDescriptor.getName();
        Method localMethod1 = localPropertyDescriptor.getReadMethod();
        Method localMethod2 = localPropertyDescriptor.getWriteMethod();
        if (!str.equalsIgnoreCase("class"))
        {
          Object localObject = localMethod1.invoke(paramObject, new Object[0]);
          if ((localPropertyDescriptor.getPropertyType() == String.class) && (localObject == null)) {
            localMethod2.invoke(paramObject, new Object[] { "" });
          }
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public EvsVoucher findEvsVoucher(String paramString)
  {
    return this.evsVoucherCheckFindDAO.findEvsVoucher(paramString);
  }
  
  public void updateVoucherStatus(Long paramLong)
  {
    this.evsVoucherCheckFindDAO.updateVoucherStatus(paramLong);
  }
  
  public IFbpCompanyVDAO getFbpCompanyVDAO()
  {
    return this.fbpCompanyVDAO;
  }
  
  public void setFbpCompanyVDAO(IFbpCompanyVDAO paramIFbpCompanyVDAO)
  {
    this.fbpCompanyVDAO = paramIFbpCompanyVDAO;
  }
  
  public IFbpImagesDAO getFbpImagesDAO()
  {
    return this.fbpImagesDAO;
  }
  
  public void setFbpImagesDAO(IFbpImagesDAO paramIFbpImagesDAO)
  {
    this.fbpImagesDAO = paramIFbpImagesDAO;
  }
  
  public IEvsVoucherLineDAO getEvsVoucherLineDAO()
  {
    return this.evsVoucherLineDAO;
  }
  
  public void setEvsVoucherLineDAO(IEvsVoucherLineDAO paramIEvsVoucherLineDAO)
  {
    this.evsVoucherLineDAO = paramIEvsVoucherLineDAO;
  }
  
  public IFbpLookupValuesVDAO getLookupValuesVDAO()
  {
    return this.lookupValuesVDAO;
  }
  
  public void setLookupValuesVDAO(IFbpLookupValuesVDAO paramIFbpLookupValuesVDAO)
  {
    this.lookupValuesVDAO = paramIFbpLookupValuesVDAO;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.eBillManage.EvsVoucherCheckService
 * JD-Core Version:    0.7.0.1
 */