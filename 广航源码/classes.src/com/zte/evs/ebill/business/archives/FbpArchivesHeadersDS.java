package com.zte.evs.ebill.business.archives;

import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.eas.appframe.access.syscommon.dao.IFbpEmployeesLoginVDAO;
import com.zte.eas.appframe.business.accessory.model.FbpAccessoryV;
import com.zte.eas.appframe.business.accessory.service.IFbpAccessoriesDS;
import com.zte.eas.appframe.business.syscommon.model.FbpEmployeesLoginV;
import com.zte.eas.appframe.business.util.ParsePerportiesTool;
import com.zte.eas.getData.util.ArchivesUtils;
import com.zte.eas.infomap.business.notice.model.FbpNoticesNew;
import com.zte.eas.infomap.business.notice.service.IFbpNoticesNewDS;
import com.zte.eas.organization.access.employeemanage.dao.IFbpEmployeesDAO;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployees;
import com.zte.eimage.access.baseconfig.dao.IImageCommonDAO;
import com.zte.eimage.business.baseconfig.service.IImageCommonDS;
import com.zte.evs.ebill.access.archives.IFbpArchivesHeadersDAO;
import com.zte.evs.ebill.access.eBillManage.EvsVoucherHistoryDAO;
import com.zte.evs.ebill.common.EvsObjectUtils;
import com.zte.evs.ebill.common.ObjectCopyUtils;
import com.zte.evs.ebill.model.archives.EvsFindVoucherV;
import com.zte.evs.ebill.model.archives.FbpArchivesHeaders;
import com.zte.evs.ebill.model.archives.FbpArchivesHeadersV;
import com.zte.evs.ebill.model.archives.FbpArchivesHistories;
import com.zte.evs.ebill.model.archives.FbpArchivesLines;
import com.zte.evs.ebill.model.archives.FbpArchivesLinesV;
import com.zte.evs.ebill.model.archives.FindEmployeesV;
import com.zte.evs.ebill.model.eBillManage.EvsAllotHeaders;
import com.zte.evs.ebill.model.eBillManage.EvsBook;
import com.zte.evs.ebill.model.eBillManage.EvsVoucher;
import com.zte.ssb.AccessPropertiesFile;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.BaseDomainService;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.util.Util;
import com.zte.ssb.servicecontainer.business.server.ISession;
import com.zte.ssb.servicecontainer.business.server.RIAContext;
import com.zte.web.service.client.adjustCreditSrv.AdjustCreditSrv;
import com.zte.web.service.client.adjustCreditSrv.AdjustCreditSrvRequest;
import com.zte.web.service.client.adjustCreditSrv.AdjustCreditSrvResponse;
import com.zte.web.service.client.adjustCreditSrv.AdjustCreditSrvServiceLocator;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import javax.xml.rpc.ServiceException;
import org.apache.commons.fileupload.FileItem;
import org.apache.log4j.Logger;

public class FbpArchivesHeadersDS
  extends BaseDomainService
  implements IFbpArchivesHeadersDS
{
  private final String ARCHIVES_WAIT_APPROVE = "ARCHIVES_WAIT_APPROVE";
  private final String ARCHIVES_AS_DRAFT = "ARCHIVES_AS_DRAFT";
  private static final String EASLOGIN_USERINFO = "easloginuserinfo";
  private static final String UPLOADFILEFAILD = "uploadfaild";
  private static final String UPLOADFILESUCESS = "uploadsucess";
  Log log = SSBBus.getLog(getClass());
  private String DATE;
  private IFbpArchivesHeadersDAO fbpArchivesHeadersDAO;
  private EvsVoucherHistoryDAO evsVoucherHistoryDAO;
  Logger logger = Logger.getLogger(FbpArchivesHeadersDS.class);
  
  public void setFbpArchivesHeadersDAO(IFbpArchivesHeadersDAO paramIFbpArchivesHeadersDAO)
  {
    super.setDao(paramIFbpArchivesHeadersDAO);
    this.fbpArchivesHeadersDAO = paramIFbpArchivesHeadersDAO;
  }
  
  public List<FbpArchivesHeaders> getFbpArchivesHeaderss(int paramInt1, int paramInt2)
  {
    return this.fbpArchivesHeadersDAO.getFbpArchivesHeaderss(paramInt1, paramInt2);
  }
  
  public List<FbpArchivesHeaders> getFbpArchivesHeaderss()
  {
    return this.fbpArchivesHeadersDAO.getFbpArchivesHeaderss();
  }
  
  public FbpArchivesHeadersV getFbpArchivesHeadersV(Long paramLong)
  {
    return this.fbpArchivesHeadersDAO.getFbpArchivesHeadersV(paramLong);
  }
  
  public void removeFbpArchivesHeaders(Long paramLong)
  {
    this.fbpArchivesHeadersDAO.removeFbpArchivesHeaders(paramLong);
  }
  
  public void removeArchivesById(Long paramLong)
  {
    removeFbpArchivesHeaders(paramLong);
    IFbpArchivesLinesDS localIFbpArchivesLinesDS = (IFbpArchivesLinesDS)SSBBus.findDomainService("fbpArchivesLinesDS");
    List localList = localIFbpArchivesLinesDS.findFbpArchivesLinessV(paramLong);
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      FbpArchivesLinesV localFbpArchivesLinesV = (FbpArchivesLinesV)localIterator.next();
      Long localLong = localFbpArchivesLinesV.getArchivesLineId();
      localIFbpArchivesLinesDS.removeFbpArchivesLines(localLong);
    }
  }
  
  public void removeFbpArchivesHeaders(FbpArchivesHeaders paramFbpArchivesHeaders)
  {
    this.fbpArchivesHeadersDAO.removeFbpArchivesHeaders(paramFbpArchivesHeaders);
  }
  
  public void insertFbpArchivesHeaders(FbpArchivesHeaders paramFbpArchivesHeaders)
  {
    this.fbpArchivesHeadersDAO.insertFbpArchivesHeaders(paramFbpArchivesHeaders);
  }
  
  public void updateFbpArchivesHeaders(FbpArchivesHeaders paramFbpArchivesHeaders)
  {
    this.fbpArchivesHeadersDAO.updateFbpArchivesHeaders(paramFbpArchivesHeaders);
  }
  
  public void insertFbpArchivesHeaderss(List<FbpArchivesHeaders> paramList)
  {
    this.fbpArchivesHeadersDAO.insertFbpArchivesHeaderss(paramList);
  }
  
  public void removeFbpArchivesHeaderss(List<FbpArchivesHeaders> paramList)
  {
    this.fbpArchivesHeadersDAO.removeFbpArchivesHeaderss(paramList);
  }
  
  public void updateFbpArchivesHeaderss(List<FbpArchivesHeaders> paramList)
  {
    this.fbpArchivesHeadersDAO.updateFbpArchivesHeaderss(paramList);
  }
  
  public String updateArchivesHeadersProccess()
    throws ParseException
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String str = localSimpleDateFormat.format(new Date());
    ArrayList localArrayList = new ArrayList();
    if (this.fbpArchivesHeadersDAO == null) {
      this.fbpArchivesHeadersDAO = ((IFbpArchivesHeadersDAO)SSBBus.findDomainService("fbpArchivesHeadersDAO"));
    }
    List localList = this.fbpArchivesHeadersDAO.getFbpArchivesHeadersV(str);
    if (localList.size() <= 0) {
      return "false";
    }
    for (int i = 0; i < localList.size(); i++)
    {
      FbpArchivesHeaders localFbpArchivesHeaders = (FbpArchivesHeaders)localList.get(i);
      localFbpArchivesHeaders.setArchivesStatus("ARCHIVES_ALREADY_REVERT");
      localFbpArchivesHeaders.setLastUpdateDate(new Date());
      localArrayList.add(localFbpArchivesHeaders);
    }
    if (localArrayList.size() > 0) {
      this.fbpArchivesHeadersDAO.updateFbpArchivesHeaderss(localArrayList);
    }
    return "true";
  }
  
  public String updateArchivesHeadersProccessBk(String paramString, Date paramDate)
    throws ParseException
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String str1 = localSimpleDateFormat.format(paramDate);
    String str2 = this.fbpArchivesHeadersDAO.updateArchivesHeadersProccessBk(paramString, str1);
    if (str2 == "false") {
      return "false";
    }
    String[] arrayOfString = paramString.split(",");
    for (int i = 0; i < arrayOfString.length; i++)
    {
      FbpArchivesHistories localFbpArchivesHistories = new FbpArchivesHistories();
      ObjectCopyUtils.setWho(localFbpArchivesHistories);
      localFbpArchivesHistories.setEnabledFlag("Y");
      localFbpArchivesHistories.setArchivesHeaderId(Long.valueOf(arrayOfString[i]));
      FindEmployeesV localFindEmployeesV = findEmployeesLoginV();
      localFbpArchivesHistories.setEmployeeId(localFindEmployeesV.getEmployeeId());
      localFbpArchivesHistories.setEmployeeNumber(localFindEmployeesV.getEmployeeNumber());
      localFbpArchivesHistories.setEmployeeName(localFindEmployeesV.getEmployeeName());
      localFbpArchivesHistories.setArchivesStatus("ARCHIVES_ALREADY_REVERT");
      this.fbpArchivesHeadersDAO.insertObject(localFbpArchivesHistories);
    }
    return str2;
  }
  
  public String updateArchivesHeadersProccessRejected(String paramString)
  {
    String str = this.fbpArchivesHeadersDAO.updateArchivesHeadersProccessRejected(paramString);
    FbpArchivesHistories localFbpArchivesHistories = new FbpArchivesHistories();
    ObjectCopyUtils.setWho(localFbpArchivesHistories);
    localFbpArchivesHistories.setEnabledFlag("Y");
    localFbpArchivesHistories.setArchivesHeaderId(Long.valueOf(paramString));
    FindEmployeesV localFindEmployeesV = findEmployeesLoginV();
    localFbpArchivesHistories.setEmployeeId(localFindEmployeesV.getEmployeeId());
    localFbpArchivesHistories.setEmployeeNumber(localFindEmployeesV.getEmployeeNumber());
    localFbpArchivesHistories.setEmployeeName(localFindEmployeesV.getEmployeeName());
    localFbpArchivesHistories.setArchivesStatus("ARCHIVES_ALREADY_CANCEL");
    this.fbpArchivesHeadersDAO.insertObject(localFbpArchivesHistories);
    return str;
  }
  
  public TableDataInfo findJournalNumByQry(EvsFindVoucherV paramEvsFindVoucherV, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    PageInfo localPageInfo = this.fbpArchivesHeadersDAO.findJournalNumByQry(paramEvsFindVoucherV, paramInt1, paramInt2);
    localTableDataInfo.setData((List)localPageInfo.getResult());
    localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
    return localTableDataInfo;
  }
  
  public TableDataInfo findFbpArchivesHeadersV(FbpArchivesHeadersV paramFbpArchivesHeadersV, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    PageInfo localPageInfo = this.fbpArchivesHeadersDAO.findFbpArchivesHeadersV(paramFbpArchivesHeadersV, paramInt1, paramInt2);
    localTableDataInfo.setData((List)localPageInfo.getResult());
    localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
    return localTableDataInfo;
  }
  
  public String submitArchivesBorrow(FbpArchivesHeadersV paramFbpArchivesHeadersV, List<FbpArchivesLines> paramList)
    throws Exception
  {
    String str = "N";
    Long localLong = paramFbpArchivesHeadersV.getArchivesHeaderId();
    if (null != localLong)
    {
      FbpArchivesHeaders localFbpArchivesHeaders = this.fbpArchivesHeadersDAO.getFbpArchivesHeadersByNum(localLong);
      localFbpArchivesHeaders.setEmailAddress(paramFbpArchivesHeadersV.getEmailAddress());
      localFbpArchivesHeaders.setNumberAttribute1(paramFbpArchivesHeadersV.getNumberAttribute1());
      localFbpArchivesHeaders.setMobilePhone(paramFbpArchivesHeadersV.getMobilePhone());
      localFbpArchivesHeaders.setApplyDesc(paramFbpArchivesHeadersV.getApplyDesc());
      localFbpArchivesHeaders.setAttribute1(paramFbpArchivesHeadersV.getAttribute1());
      localFbpArchivesHeaders.setArchivesStatus("ARCHIVES_WAIT_APPROVE");
      this.fbpArchivesHeadersDAO.updateFbpArchivesHeaders(localFbpArchivesHeaders);
      this.fbpArchivesHeadersDAO.removeFbpArchivesLines(localFbpArchivesHeaders.getArchivesHeaderId());
      ArrayList localArrayList = new ArrayList();
      if ((paramList != null) && (paramList.size() > 0))
      {
        localObject1 = paramList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (FbpArchivesLines)((Iterator)localObject1).next();
          localArrayList.add(createNewFbpArchivesLines(localFbpArchivesHeaders.getArchivesHeaderId(), (FbpArchivesLines)localObject2));
        }
      }
      if (localArrayList.size() >= 0) {
        this.fbpArchivesHeadersDAO.insertObjects(localArrayList);
      }
      Object localObject1 = new FbpArchivesHistories();
      ObjectCopyUtils.setWho(localObject1);
      ((FbpArchivesHistories)localObject1).setEnabledFlag("Y");
      ((FbpArchivesHistories)localObject1).setArchivesHeaderId(localFbpArchivesHeaders.getArchivesHeaderId());
      Object localObject2 = findEmployeesLoginV();
      ((FbpArchivesHistories)localObject1).setEmployeeId(((FindEmployeesV)localObject2).getEmployeeId());
      ((FbpArchivesHistories)localObject1).setEmployeeNumber(((FindEmployeesV)localObject2).getEmployeeNumber());
      ((FbpArchivesHistories)localObject1).setEmployeeName(((FindEmployeesV)localObject2).getEmployeeName());
      ((FbpArchivesHistories)localObject1).setArchivesStatus(localFbpArchivesHeaders.getArchivesStatus());
      ((FbpArchivesHistories)localObject1).setAttribute8("SUBMIT");
      ((FbpArchivesHistories)localObject1).setApproveCommand("COMMIT");
      this.fbpArchivesHeadersDAO.insertObject(localObject1);
      str = ArchivesUtils.doSubmit(localFbpArchivesHeaders.getApplyNum());
      if (!"Y".equals(str)) {
        throw new Exception(str);
      }
      return "Y";
    }
    paramFbpArchivesHeadersV.setAttribute8("SUBMIT");
    str = archivesSaveAsDraft(paramFbpArchivesHeadersV, paramList);
    str = "Y";
    return str;
  }
  
  public String archivesSaveAsDraft(FbpArchivesHeadersV paramFbpArchivesHeadersV, List<FbpArchivesLines> paramList)
  {
    String str1 = "N";
    String str2 = paramFbpArchivesHeadersV.getAttribute1();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    try
    {
      Long localLong = paramFbpArchivesHeadersV.getArchivesHeaderId();
      Object localObject3;
      if (null != localLong)
      {
        localFbpArchivesHeaders = this.fbpArchivesHeadersDAO.getFbpArchivesHeadersByNum(localLong);
        localFbpArchivesHeaders.setEmailAddress(paramFbpArchivesHeadersV.getEmailAddress());
        localFbpArchivesHeaders.setNumberAttribute1(paramFbpArchivesHeadersV.getNumberAttribute1());
        localFbpArchivesHeaders.setMobilePhone(paramFbpArchivesHeadersV.getMobilePhone());
        localFbpArchivesHeaders.setApplyDesc(paramFbpArchivesHeadersV.getApplyDesc());
        localFbpArchivesHeaders.setAttribute1(paramFbpArchivesHeadersV.getAttribute1());
        this.fbpArchivesHeadersDAO.updateFbpArchivesHeaders(localFbpArchivesHeaders);
        this.fbpArchivesHeadersDAO.removeFbpArchivesLines(localFbpArchivesHeaders.getArchivesHeaderId());
        localObject1 = new ArrayList();
        if ((paramList != null) && (paramList.size() > 0))
        {
          localObject2 = paramList.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (FbpArchivesLines)((Iterator)localObject2).next();
            ((List)localObject1).add(createNewFbpArchivesLines(localFbpArchivesHeaders.getArchivesHeaderId(), (FbpArchivesLines)localObject3));
          }
        }
        if (((List)localObject1).size() >= 0) {
          this.fbpArchivesHeadersDAO.insertObjects((List)localObject1);
        }
        return localFbpArchivesHeaders.getArchivesHeaderId() + "#" + localFbpArchivesHeaders.getAttribute1();
      }
      FbpArchivesHeaders localFbpArchivesHeaders = new FbpArchivesHeaders();
      ObjectCopyUtils.copy(paramFbpArchivesHeadersV, localFbpArchivesHeaders);
      localFbpArchivesHeaders.setAttribute1(str2);
      localFbpArchivesHeaders.setArchivesStatus("ARCHIVES_AS_DRAFT");
      localFbpArchivesHeaders.setEnabledFlag("Y");
      localFbpArchivesHeaders.setApplyDate(localSimpleDateFormat.parse(this.DATE));
      localFbpArchivesHeaders.setCreationDate(localSimpleDateFormat.parse(this.DATE));
      ObjectCopyUtils.setWho(localFbpArchivesHeaders);
      Object localObject1 = this.fbpArchivesHeadersDAO.findApproveEmpl(paramFbpArchivesHeadersV.getEmployeeNumber());
      this.fbpArchivesHeadersDAO.insertFbpArchivesHeaders(localFbpArchivesHeaders);
      Object localObject2 = new ArrayList();
      if ((paramList != null) && (paramList.size() > 0))
      {
        localObject3 = paramList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          FbpArchivesLines localFbpArchivesLines = (FbpArchivesLines)((Iterator)localObject3).next();
          ((List)localObject2).add(createNewFbpArchivesLines(localFbpArchivesHeaders.getArchivesHeaderId(), localFbpArchivesLines));
        }
      }
      if (((List)localObject2).size() >= 0) {
        this.fbpArchivesHeadersDAO.insertObjects((List)localObject2);
      }
      if (paramFbpArchivesHeadersV.getAttribute8() == "SUBMIT")
      {
        localObject3 = new FbpArchivesHeadersV();
        ObjectCopyUtils.copy(localFbpArchivesHeaders, localObject3);
        ((FbpArchivesHeadersV)localObject3).setAttribute1(str2);
        submitArchivesBorrow((FbpArchivesHeadersV)localObject3, (List)localObject2);
      }
      if ((localObject1 == null) || ("".equals(localObject1))) {
        str1 = "M";
      }
      return localFbpArchivesHeaders.getArchivesHeaderId() + "#" + localFbpArchivesHeaders.getAttribute1();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return str1;
  }
  
  private FbpArchivesLines createNewFbpArchivesLines(Long paramLong, FbpArchivesLines paramFbpArchivesLines)
    throws Exception
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    FbpArchivesLines localFbpArchivesLines = new FbpArchivesLines();
    ObjectCopyUtils.copy(paramFbpArchivesLines, localFbpArchivesLines);
    localFbpArchivesLines.setArchivesHeaderId(paramLong);
    if ((paramFbpArchivesLines.getAttribute1() != null) && (!"".equals(paramFbpArchivesLines.getAttribute1().trim()))) {
      localFbpArchivesLines.setAttribute1(paramFbpArchivesLines.getAttribute1());
    }
    if ((paramFbpArchivesLines.getAttribute2() != null) && (!"".equals(paramFbpArchivesLines.getAttribute2().trim()))) {
      localFbpArchivesLines.setAttribute2(paramFbpArchivesLines.getAttribute2());
    }
    if ((paramFbpArchivesLines.getAttribute3() != null) && (!"".equals(paramFbpArchivesLines.getAttribute3().trim()))) {
      localFbpArchivesLines.setDateAttribute1(localSimpleDateFormat.parse(paramFbpArchivesLines.getAttribute3()));
    }
    if ((paramFbpArchivesLines.getAttribute4() != null) && (!"".equals(paramFbpArchivesLines.getAttribute4().trim()))) {
      localFbpArchivesLines.setDateAttribute2(localSimpleDateFormat.parse(paramFbpArchivesLines.getAttribute4()));
    }
    localFbpArchivesLines.setEnabledFlag("Y");
    ObjectCopyUtils.setWho(localFbpArchivesLines);
    return localFbpArchivesLines;
  }
  
  public String updateArchivesHeadersApprove(String paramString1, String paramString2, String paramString3)
  {
    IFbpArchivesHistoriesDS localIFbpArchivesHistoriesDS = (IFbpArchivesHistoriesDS)SSBBus.findDomainService("fbpArchivesHistoriesDS");
    ArrayList localArrayList = new ArrayList();
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    IFbpEmployeesLoginVDAO localIFbpEmployeesLoginVDAO = (IFbpEmployeesLoginVDAO)SSBBus.findDomainService("fbpEmployeesLoginVDAO");
    FbpEmployeesLoginV localFbpEmployeesLoginV = new FbpEmployeesLoginV();
    localFbpEmployeesLoginV = localIFbpEmployeesLoginVDAO.findEmployeeByUserId(localEasUserInfo.getUserId());
    String[] arrayOfString = paramString1.split("_");
    paramString1 = "";
    String str = null;
    if (arrayOfString.length > 0)
    {
      for (int i = 0; i < arrayOfString.length; i++)
      {
        FbpArchivesHistories localFbpArchivesHistories = new FbpArchivesHistories();
        localFbpArchivesHistories.setArchivesHeaderId(Long.valueOf(Long.parseLong(arrayOfString[i])));
        localFbpArchivesHistories.setEmployeeId(Long.valueOf(Long.parseLong(localFbpEmployeesLoginV.getEmployeeId().toString())));
        localFbpArchivesHistories.setApproveComment(paramString3);
        localFbpArchivesHistories.setArchivesStatus(paramString2);
        if ((null != paramString3) && (!"".equals(paramString3))) {
          localFbpArchivesHistories.setApproveCommand("DIS_AGREE");
        } else {
          localFbpArchivesHistories.setApproveCommand("AGREE");
        }
        localFbpArchivesHistories.setCreatedBy(Long.valueOf(Long.parseLong(localFbpEmployeesLoginV.getEmployeeId().toString())));
        localFbpArchivesHistories.setLastUpdateDate(new Date());
        localFbpArchivesHistories.setCreationDate(new Date());
        localFbpArchivesHistories.setLastUpdatedBy(Long.valueOf(Long.parseLong(localFbpEmployeesLoginV.getEmployeeId().toString())));
        localFbpArchivesHistories.setLastUpdateLogin(Long.valueOf(Long.parseLong(localFbpEmployeesLoginV.getEmployeeId().toString())));
        localFbpArchivesHistories.setEmployeeName(localFbpEmployeesLoginV.getEmployeeName());
        localFbpArchivesHistories.setEmployeeNumber(localFbpEmployeesLoginV.getEmployeeNumber());
        localFbpArchivesHistories.setEnabledFlag("Y");
        localArrayList.add(localFbpArchivesHistories);
        if ("".equals(paramString1)) {
          paramString1 = arrayOfString[i];
        } else {
          paramString1 = paramString1 + "," + arrayOfString[i];
        }
      }
      str = this.fbpArchivesHeadersDAO.updateArchivesHeadersApprove(paramString1, paramString2, paramString3);
      localIFbpArchivesHistoriesDS.insertFbpArchivesHistoriess(localArrayList);
    }
    return str;
  }
  
  public String getArchivesNumber()
  {
    return this.fbpArchivesHeadersDAO.getArchivesNumber();
  }
  
  public String getSystemDate()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    this.DATE = localSimpleDateFormat.format(new Date());
    return this.DATE;
  }
  
  public FindEmployeesV findEmployeesLoginV()
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    return (FindEmployeesV)getObject(FindEmployeesV.class, Long.valueOf(localEasUserInfo.getUserInfoPk().longValue()));
  }
  
  public void clickSendEmailorSmsOne(String paramString)
  {
    IFbpNoticesNewDS localIFbpNoticesNewDS = (IFbpNoticesNewDS)SSBBus.findDomainService("fbpNoticesNewDS");
    EvsAllotHeaders localEvsAllotHeaders = this.fbpArchivesHeadersDAO.findEvsAllotHeadersList(paramString);
    if (localEvsAllotHeaders == null) {
      return;
    }
    FbpNoticesNew localFbpNoticesNew = new FbpNoticesNew();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MM/dd");
    String str = localSimpleDateFormat.format(localEvsAllotHeaders.getAllotDate());
    StringBuilder localStringBuilder = new StringBuilder("您好，实物凭证调拨单").append(localEvsAllotHeaders.getAllotNum()).append("已经于").append(str.substring(0, 2)).append("月").append(str.substring(3, 5)).append("日").append("，提交，请您在接收到实物凭证后及时进行凭证调拨接收。");
    localFbpNoticesNew.setContent(localStringBuilder.toString());
    localFbpNoticesNew.setToUserId(localEvsAllotHeaders.getReceiveBy().toString());
    if (localEvsAllotHeaders.getAllotBy() != null) {
      localFbpNoticesNew.setFromUserId(Long.valueOf(localEvsAllotHeaders.getAllotBy().toString()));
    }
    localFbpNoticesNew.setStatus(Integer.valueOf(0));
    if (localEvsAllotHeaders.getAllotHeaderId() != null) {
      localFbpNoticesNew.setBoeHeaderId(Long.valueOf(localEvsAllotHeaders.getAllotHeaderId().toString()));
    }
    localFbpNoticesNew.setTemplateId("tpdsubmit");
    localFbpNoticesNew.setNoticeType("2");
    localFbpNoticesNew.setId(null);
    localIFbpNoticesNewDS.insertFbpNoticesNew(localFbpNoticesNew);
  }
  
  public void clickSendEmailorSmsTwo(String paramString)
  {
    IFbpNoticesNewDS localIFbpNoticesNewDS = (IFbpNoticesNewDS)SSBBus.findDomainService("fbpNoticesNewDS");
    List localList = this.fbpArchivesHeadersDAO.getFbpArchivesHeadersByHeaderId(paramString);
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      FbpArchivesHeaders localFbpArchivesHeaders = (FbpArchivesHeaders)localIterator.next();
      FbpNoticesNew localFbpNoticesNew;
      SimpleDateFormat localSimpleDateFormat;
      String str;
      StringBuilder localStringBuilder;
      if ("Y".equals(localFbpArchivesHeaders.getAttribute1()))
      {
        localFbpNoticesNew = new FbpNoticesNew();
        localSimpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        str = localSimpleDateFormat.format(localFbpArchivesHeaders.getApplyDate());
        localStringBuilder = new StringBuilder("您好，您").append(str.substring(0, 4)).append("年").append(str.substring(5, 7)).append("月").append(str.substring(8)).append("日").append("申请的凭证借阅单已经审批通过，请您在借阅有效期内查阅电子凭证，借阅完毕后及时归还。");
        localFbpNoticesNew.setContent(localStringBuilder.toString());
        localFbpNoticesNew.setToUserId(localFbpArchivesHeaders.getEmployeeId().toString());
        if (localFbpArchivesHeaders.getLastUpdatedBy() != null) {
          localFbpNoticesNew.setFromUserId(Long.valueOf(localFbpArchivesHeaders.getLastUpdatedBy().toString()));
        }
        localFbpNoticesNew.setStatus(Integer.valueOf(0));
        if (localFbpArchivesHeaders.getArchivesHeaderId() != null) {
          localFbpNoticesNew.setBoeHeaderId(Long.valueOf(localFbpArchivesHeaders.getArchivesHeaderId().toString()));
        }
        localFbpNoticesNew.setTemplateId("pzdspe");
        localFbpNoticesNew.setNoticeType("2");
        localIFbpNoticesNewDS.insertFbpNoticesNew(localFbpNoticesNew);
      }
      else if ("N".equals(localFbpArchivesHeaders.getAttribute1()))
      {
        localFbpNoticesNew = new FbpNoticesNew();
        localSimpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        str = localSimpleDateFormat.format(localFbpArchivesHeaders.getApplyDate());
        localStringBuilder = new StringBuilder("您好，您").append(str.substring(0, 4)).append("年").append(str.substring(5, 7)).append("月").append(str.substring(8)).append("日").append("申请的凭证借阅单已经审批通过，请您及时联系档案管理员领取实物凭证，借阅完毕后及时归还。");
        localFbpNoticesNew.setContent(localStringBuilder.toString());
        localFbpNoticesNew.setToUserId(localFbpArchivesHeaders.getEmployeeId().toString());
        if (localFbpArchivesHeaders.getLastUpdatedBy() != null) {
          localFbpNoticesNew.setFromUserId(Long.valueOf(localFbpArchivesHeaders.getLastUpdatedBy().toString()));
        }
        localFbpNoticesNew.setStatus(Integer.valueOf(0));
        if (localFbpArchivesHeaders.getArchivesHeaderId() != null) {
          localFbpNoticesNew.setBoeHeaderId(Long.valueOf(localFbpArchivesHeaders.getArchivesHeaderId().toString()));
        }
        localFbpNoticesNew.setTemplateId("swpzdspe");
        localFbpNoticesNew.setNoticeType("2");
        localFbpNoticesNew.setId(null);
        localIFbpNoticesNewDS.insertFbpNoticesNew(localFbpNoticesNew);
      }
    }
  }
  
  public void clickSendEmailorSmsFour(String paramString)
  {
    String str2 = null;
    IFbpNoticesNewDS localIFbpNoticesNewDS = (IFbpNoticesNewDS)SSBBus.findDomainService("fbpNoticesNewDS");
    FbpArchivesHeaders localFbpArchivesHeaders = this.fbpArchivesHeadersDAO.getFbpArchivesHeaders(paramString);
    if (localFbpArchivesHeaders != null)
    {
      FbpNoticesNew localFbpNoticesNew = new FbpNoticesNew();
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
      String str3 = "";
      if ("Y".equals(localFbpArchivesHeaders.getAttribute1())) {
        str3 = "电子";
      } else if ("N".equals(localFbpArchivesHeaders.getAttribute1())) {
        str3 = "实物凭证";
      }
      String str1 = localSimpleDateFormat.format(localFbpArchivesHeaders.getApplyDate());
      StringBuilder localStringBuilder = new StringBuilder("您好，").append(str3).append("借阅单").append(localFbpArchivesHeaders.getApplyNum()).append("已经于").append(str1.substring(0, 4)).append("年").append(str1.substring(5, 7)).append("月").append(str1.substring(8)).append("日").append("提交成功，请您及时到系统中进行审批。");
      localFbpNoticesNew.setContent(localStringBuilder.toString());
      if (localFbpArchivesHeaders.getEmployeeId() != null) {
        str2 = this.fbpArchivesHeadersDAO.findEmployeeLeaders(localFbpArchivesHeaders.getAttribute3());
      }
      localFbpNoticesNew.setToUserId(str2);
      if (localFbpArchivesHeaders.getEmployeeId() != null) {
        localFbpNoticesNew.setFromUserId(Long.valueOf(localFbpArchivesHeaders.getEmployeeId().toString()));
      }
      localFbpNoticesNew.setStatus(Integer.valueOf(0));
      if (localFbpArchivesHeaders.getArchivesHeaderId() != null) {
        localFbpNoticesNew.setBoeHeaderId(Long.valueOf(localFbpArchivesHeaders.getArchivesHeaderId().toString()));
      }
      localFbpNoticesNew.setTemplateId("pzjydtje");
      localFbpNoticesNew.setNoticeType("2");
      localFbpNoticesNew.setId(null);
      localIFbpNoticesNewDS.insertFbpNoticesNew(localFbpNoticesNew);
    }
  }
  
  public void voucherBorrowTimeOut()
  {
    String str1 = "036";
    String str2 = "037";
    String str3 = "select * from FBP.FBP_ARCHIVES_HEADERS v where v.ARCHIVES_STATUS='ARCHIVES_BORROWING' and v.ATTRIBUTE1='N' and trunc(v.GIVE_BACK_DATE)+1=trunc(sysdate,'dd') or attribute4 is not null";
    String str4 = "select * from FBP.FBP_ARCHIVES_HEADERS v where v.ARCHIVES_STATUS='ARCHIVES_BORROWING' and v.ATTRIBUTE1='N' and trunc(v.GIVE_BACK_DATE)+1 < trunc(sysdate,'dd') or attribute5 is not null";
    IImageCommonDS localIImageCommonDS = (IImageCommonDS)SSBBus.findDomainService("imageCommonDS");
    if (this.fbpArchivesHeadersDAO == null) {
      this.fbpArchivesHeadersDAO = ((IFbpArchivesHeadersDAO)SSBBus.findDomainService("fbpArchivesHeadersDAO"));
    }
    List localList1 = localIImageCommonDS.findObjectBySQL(str3, null, FbpArchivesHeaders.class);
    List localList2 = localIImageCommonDS.findObjectBySQL(str4, null, FbpArchivesHeaders.class);
    AdjustCreditSrvServiceLocator localAdjustCreditSrvServiceLocator = new AdjustCreditSrvServiceLocator();
    AdjustCreditSrv localAdjustCreditSrv = null;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    try
    {
      localAdjustCreditSrv = localAdjustCreditSrvServiceLocator.getadjustCreditSrv();
      IFbpEmployeesDAO localIFbpEmployeesDAO = (IFbpEmployeesDAO)SSBBus.findDomainService("fbpEmployeesDAO");
      FbpArchivesHeaders localFbpArchivesHeaders;
      FbpEmployees localFbpEmployees;
      AdjustCreditSrvResponse localAdjustCreditSrvResponse;
      if ((localList1 != null) && (!localList1.isEmpty())) {
        for (i = 0; i < localList1.size(); i++)
        {
          localObject = new AdjustCreditSrvRequest();
          localFbpArchivesHeaders = (FbpArchivesHeaders)localList1.get(i);
          ((AdjustCreditSrvRequest)localObject).setAssessCode(str1);
          localFbpEmployees = localIFbpEmployeesDAO.getFbpEmployees(BigInteger.valueOf(localFbpArchivesHeaders.getEmployeeId().longValue()));
          if ((localFbpEmployees == null) || (localFbpEmployees.getEmployeeId() == null))
          {
            localFbpArchivesHeaders.setAttribute4("该借阅单在fbp_employees表中找不到借阅人");
            localArrayList1.add(localFbpArchivesHeaders);
          }
          else
          {
            ((AdjustCreditSrvRequest)localObject).setEmployeeNumber(localFbpEmployees.getEmployeeNumber());
            localAdjustCreditSrvResponse = localAdjustCreditSrv.adjustCredit((AdjustCreditSrvRequest)localObject);
            if (!"Y".equals(localAdjustCreditSrvResponse.getErrorFlag()))
            {
              localFbpArchivesHeaders.setAttribute4("接口调用成功,但是服务方校验失败，返回" + localAdjustCreditSrvResponse.getErrorMessage());
              localArrayList1.add(localFbpArchivesHeaders);
            }
            else
            {
              localFbpArchivesHeaders.setAttribute4(null);
              localArrayList1.add(localFbpArchivesHeaders);
            }
          }
        }
      }
      if ((localList2 != null) && (!localList2.isEmpty())) {
        for (i = 0; i < localList2.size(); i++)
        {
          localObject = new AdjustCreditSrvRequest();
          localFbpArchivesHeaders = (FbpArchivesHeaders)localList2.get(i);
          ((AdjustCreditSrvRequest)localObject).setAssessCode(str2);
          localFbpEmployees = localIFbpEmployeesDAO.getFbpEmployees(BigInteger.valueOf(localFbpArchivesHeaders.getEmployeeId().longValue()));
          if ((localFbpEmployees == null) || (localFbpEmployees.getEmployeeId() == null))
          {
            localFbpArchivesHeaders.setAttribute5("该借阅单在fbp_employees表中找不到借阅人");
            localArrayList2.add(localFbpArchivesHeaders);
          }
          else
          {
            ((AdjustCreditSrvRequest)localObject).setEmployeeNumber(localFbpEmployees.getEmployeeNumber());
            localAdjustCreditSrvResponse = localAdjustCreditSrv.adjustCredit((AdjustCreditSrvRequest)localObject);
            if (!"Y".equals(localAdjustCreditSrvResponse.getErrorFlag()))
            {
              localFbpArchivesHeaders.setAttribute5("接口调用成功,但是服务方校验失败，返回" + localAdjustCreditSrvResponse.getErrorMessage());
              localArrayList2.add(localFbpArchivesHeaders);
            }
            else
            {
              localFbpArchivesHeaders.setAttribute5(null);
              localArrayList2.add(localFbpArchivesHeaders);
            }
          }
        }
      }
    }
    catch (ServiceException localServiceException)
    {
      for (i = 0; i < localList1.size(); i++)
      {
        localObject = (FbpArchivesHeaders)localList1.get(i);
        ((FbpArchivesHeaders)localObject).setAttribute4("连接接口服务失败，请检查接口服务地址：" + AccessPropertiesFile.getValue("adjustCreditSrv_address"));
        localArrayList1.add(localObject);
      }
      for (i = 0; i < localList2.size(); i++)
      {
        localObject = (FbpArchivesHeaders)localList1.get(i);
        ((FbpArchivesHeaders)localObject).setAttribute5("连接接口服务失败，请检查接口服务地址：" + AccessPropertiesFile.getValue("adjustCreditSrv_address"));
        localArrayList2.add(localObject);
      }
      this.logger.error("connect service fail:" + localServiceException.getMessage(), localServiceException);
    }
    catch (RemoteException localRemoteException)
    {
      Object localObject;
      for (int i = 0; i < localList1.size(); i++)
      {
        localObject = (FbpArchivesHeaders)localList1.get(i);
        ((FbpArchivesHeaders)localObject).setAttribute4("调用接口服务失败，请检查网络配置和服务提供方的协议文件");
        localArrayList1.add(localObject);
      }
      for (i = 0; i < localList2.size(); i++)
      {
        localObject = (FbpArchivesHeaders)localList2.get(i);
        ((FbpArchivesHeaders)localObject).setAttribute5("调用接口服务失败，请检查网络配置和服务提供方的协议文件");
        localArrayList2.add(localObject);
      }
      this.logger.error("call service fail:" + localRemoteException.getMessage(), localRemoteException);
    }
    if ((localArrayList1 != null) && (!localArrayList1.isEmpty())) {
      this.fbpArchivesHeadersDAO.updateObjects(localArrayList1);
    }
    if ((localArrayList2 != null) && (!localArrayList2.isEmpty())) {
      this.fbpArchivesHeadersDAO.updateObjects(localArrayList2);
    }
  }
  
  public void timerSendEmailorSms()
  {
    try
    {
      updateArchivesHeadersProccess();
    }
    catch (ParseException localParseException)
    {
      this.logger.error("自动归还凭证：" + localParseException.getMessage(), localParseException);
    }
    try
    {
      voucherBorrowTimeOut();
    }
    catch (Exception localException)
    {
      this.logger.error("凭证超期未还：" + localException.getMessage(), localException);
    }
    IFbpNoticesNewDS localIFbpNoticesNewDS = (IFbpNoticesNewDS)SSBBus.findDomainService("fbpNoticesNewDS");
    List localList = this.fbpArchivesHeadersDAO.findFbpArchivesHeadersListNTwo();
    if (localList.size() > 0)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        FbpArchivesHeaders localFbpArchivesHeaders = (FbpArchivesHeaders)localIterator.next();
        FbpNoticesNew localFbpNoticesNew1 = new FbpNoticesNew();
        FbpNoticesNew localFbpNoticesNew2 = new FbpNoticesNew();
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String str1 = localSimpleDateFormat.format(localFbpArchivesHeaders.getApplyDate());
        String str2 = localSimpleDateFormat.format(localFbpArchivesHeaders.getGiveBackDate());
        StringBuilder localStringBuilder = new StringBuilder("您好，您").append(str1.substring(0, 4)).append("年").append(str1.substring(5, 7)).append("月").append(str1.substring(8)).append("日").append("申请的凭证借阅单将于").append(str2.substring(0, 4)).append("年").append(str2.substring(5, 7)).append("月").append(str2.substring(8)).append("日").append("到期，请及时归还，否则会影响信用等级。");
        localFbpNoticesNew1.setContent(localStringBuilder.toString());
        localFbpNoticesNew1.setToUserId(localFbpArchivesHeaders.getEmployeeId().toString());
        if (localFbpArchivesHeaders.getLastUpdatedBy() != null) {
          localFbpNoticesNew1.setFromUserId(Long.valueOf(localFbpArchivesHeaders.getLastUpdatedBy().toString()));
        }
        localFbpNoticesNew1.setStatus(Integer.valueOf(0));
        if (localFbpArchivesHeaders.getArchivesHeaderId() != null) {
          localFbpNoticesNew1.setBoeHeaderId(Long.valueOf(localFbpArchivesHeaders.getArchivesHeaderId().toString()));
        }
        localFbpNoticesNew1.setTemplateId("pzjyddq");
        localFbpNoticesNew1.setId(null);
        localFbpNoticesNew1.setNoticeType("1");
        localIFbpNoticesNewDS.insertFbpNoticesNew(localFbpNoticesNew1);
        ObjectCopyUtils.copy(localFbpNoticesNew1, localFbpNoticesNew2);
        localFbpNoticesNew2.setTemplateId("pzjyddq");
        localFbpNoticesNew2.setNoticeType("2");
        localFbpNoticesNew2.setId(null);
        localIFbpNoticesNewDS.insertFbpNoticesNew(localFbpNoticesNew2);
        localFbpNoticesNew1 = null;
        localSimpleDateFormat = null;
        str1 = null;
        localStringBuilder = null;
      }
    }
  }
  
  public FbpArchivesHeadersV findFbpArchivesHeadersV(Long paramLong)
  {
    FbpArchivesHeadersV localFbpArchivesHeadersV = new FbpArchivesHeadersV();
    localFbpArchivesHeadersV = this.fbpArchivesHeadersDAO.findFbpArchivesHeadersV(paramLong);
    return localFbpArchivesHeadersV;
  }
  
  public String uploadfile(FbpAccessoryV paramFbpAccessoryV)
  {
    Object localObject1 = null;
    InputStream localInputStream = null;
    FileOutputStream localFileOutputStream = null;
    Object localObject2 = null;
    String str1 = (String)ParsePerportiesTool.ACCESSORYPATHS_MAP.get("accessoriesPath");
    String str2 = RIAContext.getCurrentInstance().getRealPath("/");
    StringBuffer localStringBuffer = new StringBuffer(str2);
    localStringBuffer.append("accessoriesPath").append(File.separatorChar);
    str1 = localStringBuffer.toString();
    File localFile = new File(str1);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    String str3 = null;
    try
    {
      RIAContext localRIAContext = RIAContext.getCurrentInstance();
      localObject3 = localRIAContext.getSession();
      EasUserInfo localEasUserInfo = (EasUserInfo)((ISession)localObject3).getSessionAttribute("easloginuserinfo");
      List localList = (List)localRIAContext.getRequest().getAttribute("FileItemList");
      Iterator localIterator = localList.iterator();
      FileItem localFileItem = null;
      localInputStream = null;
      while (localIterator.hasNext())
      {
        localObject4 = Long.valueOf(new Random().nextLong());
        String str4 = ((Long)localObject4).toString().substring(2, 5);
        String str6 = new Date().getTime() + str4;
        byte[] arrayOfByte = new byte[1024];
        localFileItem = (FileItem)localIterator.next();
        String str7 = splitString(localFileItem.getName(), ".");
        String str8 = splitString(localFileItem.getName(), "\\");
        String str9 = str6;
        if (str7 != null) {
          str9 = str6 + "." + str7;
        }
        paramFbpAccessoryV.setAccessoryActualPath(str1);
        paramFbpAccessoryV.setAccessoryFileName(str9);
        paramFbpAccessoryV.setAccessoryOldFileName(str8);
        Long localLong = Long.valueOf(localFileItem.getSize());
        String str10 = localLong.toString();
        if (localLong.longValue() == 0L) {
          str3 = "uploadfaild";
        }
        int i = localLong.intValue() / 1024;
        if (i <= 0) {
          i = 1;
        }
        paramFbpAccessoryV.setEmployeeName(localEasUserInfo.getUserName());
        paramFbpAccessoryV.setCreationDate(new Date());
        paramFbpAccessoryV.setAccessorySize(new BigInteger(String.valueOf(i)));
        paramFbpAccessoryV.setAttribute10(paramFbpAccessoryV.getAccessorySize().toString() + "KB");
        if ((paramFbpAccessoryV.getAccessoryTitle() == null) || ("".equals(paramFbpAccessoryV.getAccessoryTitle().trim()))) {
          paramFbpAccessoryV.setAccessoryTitle(str8);
        }
        paramFbpAccessoryV.setEnabledFlag("Y");
        paramFbpAccessoryV.setExtendedName(str7);
        localInputStream = localFileItem.getInputStream();
        localFileOutputStream = new FileOutputStream(str1 + File.separator + str9);
        int j = 0;
        while ((j = localInputStream.read(arrayOfByte, 0, 1024)) != -1) {
          localFileOutputStream.write(arrayOfByte, 0, j);
        }
      }
      if ((str3 != null) && (str3.length() > 0))
      {
        localObject4 = str3;
        return localObject4;
      }
      Object localObject4 = (IFbpAccessoriesDS)SSBBus.findCommonService("accessoriesDS");
      ((IFbpAccessoriesDS)localObject4).insertFbpAccessories(paramFbpAccessoryV);
      String str5 = "uploadsucess";
      return str5;
    }
    catch (Exception localException1)
    {
      this.log.error(localException1.getMessage(), localException1);
      Object localObject3 = "uploadfaild";
      return localObject3;
    }
    finally
    {
      if (localInputStream != null) {
        try
        {
          localInputStream.close();
          localInputStream = null;
        }
        catch (Exception localException8)
        {
          this.log.error(localException8.getMessage(), localException8);
        }
      }
      if (localFileOutputStream != null) {
        try
        {
          localFileOutputStream.close();
          localFileOutputStream = null;
        }
        catch (Exception localException9)
        {
          this.log.error(localException9.getMessage(), localException9);
        }
      }
    }
  }
  
  private String splitString(String paramString1, String paramString2)
  {
    int i = paramString1.lastIndexOf(paramString2);
    return paramString1.substring(i + 1);
  }
  
  public String findArchiveVoucherStatus(String paramString1, String paramString2)
  {
    IImageCommonDAO localIImageCommonDAO = (IImageCommonDAO)SSBBus.findDomainService("imageCommonDAO");
    String str = "select voucher_status from evs.evs_voucher ev,fbp.FBP_ARCHIVES_LINES al where ev.voucher_id = al.voucher_id";
    ArrayList localArrayList = new ArrayList();
    if ("BOOK".equals(paramString2)) {
      str = str + " and ev.voucher_status not in('UNMATCH','MATCHED','BORROWING','NOW_FLITTING')";
    } else {
      str = str + " and ev.voucher_status not in('UNMATCH','BORROWING','NOW_FLITTING')";
    }
    str = str + " and al.ARCHIVES_HEADER_ID in(" + paramString1 + ")";
    List localList = localIImageCommonDAO.findObjectBySQL(str, null, null);
    if ((localList == null) || (localList.isEmpty())) {
      return "N";
    }
    return "Y";
  }
  
  public String updateArchivesByVoucher(String paramString1, String paramString2, Date paramDate)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    this.fbpArchivesHeadersDAO.updateArchivesHeadersStatus(paramString1, "ARCHIVES_WAIT_REVERT", paramString2, paramDate);
    this.fbpArchivesHeadersDAO.updateVoucherStatus(paramString1, "BORROWING");
    String[] arrayOfString1 = paramString1.split(",");
    String str1 = "N";
    for (String str2 : arrayOfString1)
    {
      System.err.println("{" + str2 + "}");
      if (!Util.isStrEmpty(str2))
      {
        this.fbpArchivesHeadersDAO.insertFbpArchivesHistories(null, Long.valueOf(str2), "ARCHIVES_WAIT_REVERT");
        str1 = "Y";
      }
    }
    return str1;
  }
  
  public String updateArchivesByBook(String paramString1, String paramString2, Date paramDate)
  {
    List localList = getArchivesVoucherByBook(paramString1);
    if ((localList == null) || (localList.size() < 1)) {
      return "W";
    }
    this.fbpArchivesHeadersDAO.updateArchivesHeadersStatus(paramString1, "ARCHIVES_WAIT_REVERT", paramString2, paramDate);
    Object localObject;
    for (int i = 0; i < localList.size(); i++)
    {
      localObject = (EvsVoucher)localList.get(i);
      ((EvsVoucher)localObject).setVoucherStatus("BORROWING");
      this.fbpArchivesHeadersDAO.updateObject(localObject);
    }
    String[] arrayOfString = paramString1.split(",");
    for (String str : arrayOfString) {
      this.fbpArchivesHeadersDAO.insertFbpArchivesHistories(null, Long.valueOf(str), "ARCHIVES_WAIT_REVERT");
    }
    return "Y";
  }
  
  private List<Object> getArchivesVoucherByBook(String paramString)
  {
    IImageCommonDAO localIImageCommonDAO = (IImageCommonDAO)SSBBus.findDomainService("imageCommonDAO");
    StringBuffer localStringBuffer1 = new StringBuffer();
    localStringBuffer1.append("select *");
    localStringBuffer1.append("  from evs_book b");
    localStringBuffer1.append(" where b.book_status not in ('NOT_FASCICULE', 'NOW_FLITTING')");
    localStringBuffer1.append("   and exists");
    localStringBuffer1.append(" (select 1");
    localStringBuffer1.append("          from evs.Evs_Voucher_Book_Package bp, fbp.fbp_archives_lines al");
    localStringBuffer1.append("         where bp.voucher_id = al.voucher_id");
    localStringBuffer1.append("         AND BP.BOOK_ID = b.book_id");
    localStringBuffer1.append("         and bp.ENABLED_FLAG = 'Y'");
    localStringBuffer1.append("         AND AL.ARCHIVES_HEADER_ID in (?))");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    List localList1 = localIImageCommonDAO.findObjectBySQL(localStringBuffer1.toString(), localArrayList, EvsBook.class);
    if ((localList1 == null) || (localList1.isEmpty())) {
      return null;
    }
    StringBuffer localStringBuffer2 = new StringBuffer();
    for (int i = 0; i < localList1.size(); i++)
    {
      localObject = (EvsBook)localList1.get(i);
      if (i < localList1.size() - 1) {
        localStringBuffer2.append(((EvsBook)localObject).getBookId()).append(",");
      } else {
        localStringBuffer2.append(((EvsBook)localObject).getBookId());
      }
    }
    StringBuffer localStringBuffer3 = new StringBuffer();
    localStringBuffer3.append("select * 　from evs_voucher ev where exists (select 1");
    localStringBuffer3.append(" from evs.evs_voucher_book_package bp");
    localStringBuffer3.append(" where ev.voucher_id =");
    localStringBuffer3.append(" bp.voucher_id");
    localStringBuffer3.append(" and bp.book_id in (?))");
    Object localObject = new ArrayList();
    ((List)localObject).add(localStringBuffer2.toString());
    List localList2 = localIImageCommonDAO.findObjectBySQL(localStringBuffer3.toString(), (List)localObject, EvsVoucher.class);
    if ((localList2 == null) || (localList2.isEmpty())) {
      return null;
    }
    return localList2;
  }
  
  public String updateArchivesToReturn(String paramString1, String paramString2, Date paramDate)
  {
    IImageCommonDAO localIImageCommonDAO = (IImageCommonDAO)SSBBus.findDomainService("imageCommonDAO");
    String str = "select count(1) from Fbp_Archives_Headers o where o.archives_header_id in (" + paramString1 + ") and o.use_date<=?";
    ArrayList localArrayList1 = new ArrayList();
    localArrayList1.add(paramDate);
    List localList1 = localIImageCommonDAO.findObjectBySQL(str, localArrayList1, null);
    if ((localList1 == null) || (localList1.isEmpty())) {
      return "F";
    }
    this.fbpArchivesHeadersDAO.updateArchivesHeadersStatusByReturn(paramString1, "ARCHIVES_ALREADY_REVERT", null, paramDate);
    Object localObject2;
    int i;
    ArrayList localArrayList2;
    if ("按册".equals(paramString2))
    {
      localObject1 = getArchivesVoucherByBook(paramString1);
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        localObject2 = new StringBuffer("select end_status from evs_voucher_history h where op_object_type='0' and end_status is not null and object_code =? and rownum = 1 order by history_id desc");
        for (i = 0; i < ((List)localObject1).size(); i++)
        {
          EvsVoucher localEvsVoucher = (EvsVoucher)((List)localObject1).get(i);
          localArrayList2 = new ArrayList();
          localArrayList2.add(localEvsVoucher.getVoucherId().toString());
          List localList2 = localIImageCommonDAO.findObjectBySQL(((StringBuffer)localObject2).toString(), localArrayList2, null);
          if ((localList2 != null) && (!localList2.isEmpty()))
          {
            localEvsVoucher.setVoucherStatus(String.valueOf(localList2.get(0)));
            this.fbpArchivesHeadersDAO.updateObject(localEvsVoucher);
          }
        }
      }
    }
    else
    {
      this.fbpArchivesHeadersDAO.updateVoucherStatus(paramString1);
    }
    Object localObject1 = paramString1.split(",");
    for (localArrayList2 : localObject1) {
      this.fbpArchivesHeadersDAO.insertFbpArchivesHistories(null, Long.valueOf(localArrayList2), "ARCHIVES_ALREADY_REVERT");
    }
    return "Y";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.archives.FbpArchivesHeadersDS
 * JD-Core Version:    0.7.0.1
 */