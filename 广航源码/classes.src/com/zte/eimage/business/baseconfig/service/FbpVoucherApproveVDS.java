package com.zte.eimage.business.baseconfig.service;

import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.eas.getData.util.ArchivesUtils;
import com.zte.eas.infomap.business.notice.model.FbpNoticesNew;
import com.zte.eas.infomap.business.notice.service.IFbpNoticesNewDS;
import com.zte.eimage.access.baseconfig.dao.IFbpVoucherApproveVDAO;
import com.zte.eimage.business.baseconfig.model.FbpVoucherApproveV;
import com.zte.eimage.business.baseconfig.model.FbpVoucherApproveVL;
import com.zte.evs.ebill.access.archives.IFbpArchivesHeadersDAO;
import com.zte.evs.ebill.business.archives.IFbpArchivesHeadersDS;
import com.zte.evs.ebill.common.EvsObjectUtils;
import com.zte.evs.ebill.common.ObjectCopyUtils;
import com.zte.evs.ebill.model.archives.FbpArchivesHeaders;
import com.zte.evs.ebill.model.archives.FbpArchivesHistories;
import com.zte.evs.ebill.model.archives.FbpArchivesLines;
import com.zte.evs.ebill.model.eBillManage.EvsStorageDocV;
import com.zte.evs.ebill.model.eBillManage.EvsVoucher;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.BaseDomainService;
import com.zte.ssb.framework.base.util.PageInfo;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class FbpVoucherApproveVDS
  extends BaseDomainService
  implements IFbpVoucherApproveVDS
{
  private IFbpVoucherApproveVDAO fbpVoucherApproveVDAO;
  private IFbpArchivesHeadersDAO fbpArchivesHeadersDAO;
  String flag;
  
  public void setFbpVoucherApproveVDAO(IFbpVoucherApproveVDAO paramIFbpVoucherApproveVDAO)
  {
    super.setDao(paramIFbpVoucherApproveVDAO);
    this.fbpVoucherApproveVDAO = paramIFbpVoucherApproveVDAO;
  }
  
  public TableDataInfo getFbpVoucherApproveVs(FbpVoucherApproveV paramFbpVoucherApproveV, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    try
    {
      PageInfo localPageInfo = this.fbpVoucherApproveVDAO.getFbpVoucherApproveVs(paramFbpVoucherApproveV, paramInt1, paramInt2);
      localTableDataInfo.setData((List)localPageInfo.getResult());
      localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return null;
    }
    return localTableDataInfo;
  }
  
  public TableDataInfo getFbpVoucherApproveVLs(FbpVoucherApproveVL paramFbpVoucherApproveVL, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    try
    {
      PageInfo localPageInfo = this.fbpVoucherApproveVDAO.getFbpVoucherApproveVs(paramFbpVoucherApproveVL, paramInt1, paramInt2);
      localTableDataInfo.setData((List)localPageInfo.getResult());
      localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return null;
    }
    return localTableDataInfo;
  }
  
  public List<FbpVoucherApproveV> getFbpVoucherApproveVs()
  {
    return this.fbpVoucherApproveVDAO.getFbpVoucherApproveVs();
  }
  
  public FbpArchivesHeaders getFbpVoucherApproveV(Long paramLong)
  {
    return this.fbpVoucherApproveVDAO.getFbpVoucherApproveV(paramLong);
  }
  
  public void removeFbpVoucherApproveV(Long paramLong)
  {
    this.fbpVoucherApproveVDAO.removeFbpVoucherApproveV(paramLong);
  }
  
  public void removeFbpVoucherApproveV(FbpVoucherApproveV paramFbpVoucherApproveV)
  {
    this.fbpVoucherApproveVDAO.removeFbpVoucherApproveV(paramFbpVoucherApproveV);
  }
  
  public void insertFbpVoucherApproveV(FbpVoucherApproveV paramFbpVoucherApproveV)
  {
    FbpArchivesHistories localFbpArchivesHistories = new FbpArchivesHistories();
    this.fbpVoucherApproveVDAO.insertFbpVoucherApproveV(localFbpArchivesHistories);
  }
  
  public String fbpVoucherApproveVAgree(FbpVoucherApproveV paramFbpVoucherApproveV, List<String> paramList1, List<String> paramList2)
    throws Exception
  {
    int i = 0;
    ArrayList localArrayList1 = new ArrayList();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    String str1 = String.valueOf(localEasUserInfo.getUserInfoPk());
    this.flag = "Y";
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    StringBuffer localStringBuffer = new StringBuffer();
    for (int j = 0; j < paramList1.size(); j++)
    {
      FbpArchivesHistories localFbpArchivesHistories = new FbpArchivesHistories();
      ObjectCopyUtils.copy(paramFbpVoucherApproveV, localFbpArchivesHistories);
      localFbpArchivesHistories.setEnabledFlag("Y");
      localFbpArchivesHistories.setEmployeeNumber(localEasUserInfo.getUserId());
      localFbpArchivesHistories.setEmployeeName(localEasUserInfo.getUserName());
      localFbpArchivesHistories.setEmployeeId(Long.valueOf(localEasUserInfo.getUserInfoPk().longValue()));
      FbpArchivesHeaders localFbpArchivesHeaders = this.fbpVoucherApproveVDAO.getFbpVoucherApproveV(Long.valueOf(Long.parseLong((String)paramList1.get(j))));
      String str2 = ArchivesUtils.approve(0, localFbpArchivesHeaders.getApplyNum());
      if (!"Y".equals(str2))
      {
        if ("M".equals(str2)) {
          return "找不到对应的档案管理员!";
        }
        return str2;
      }
      EvsStorageDocV localEvsStorageDocV1 = new EvsStorageDocV();
      localEvsStorageDocV1.setCompanyId(paramFbpVoucherApproveV.getCompanyId());
      List localList = this.fbpVoucherApproveVDAO.getEvsStorageDocV(localEvsStorageDocV1);
      if (localList != null)
      {
        localObject = localList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          EvsStorageDocV localEvsStorageDocV2 = (EvsStorageDocV)((Iterator)localObject).next();
          String str3 = localEvsStorageDocV2.getDocAdminId();
          if (str3 != null)
          {
            str3 = str3.trim();
            String[] arrayOfString1 = str3.split(",");
            for (String str4 : arrayOfString1)
            {
              localArrayList1.add(str4);
              if (str1.equals(str4)) {
                i = 1;
              }
            }
          }
        }
      }
      localFbpArchivesHistories.setProcessId(localFbpArchivesHeaders.getProcessId());
      localFbpArchivesHistories.setWorkItemId(localFbpArchivesHeaders.getWorkItemId());
      localFbpArchivesHistories.setApproveCommand("AGREE");
      localFbpArchivesHistories.setApproveComment(null);
      ObjectCopyUtils.setWho(localFbpArchivesHeaders);
      Object localObject = (IFbpArchivesHeadersDS)SSBBus.findDomainService("fbpArchivesHeadersDS");
      int k = 0;
      if (("Y".equals(paramFbpVoucherApproveV.getAttribute1())) || ("电子档案借阅".equals(paramFbpVoucherApproveV.getAttribute1().trim())))
      {
        k = 1;
        localFbpArchivesHeaders.setAttribute1("Y");
        paramFbpVoucherApproveV.setAttribute1("Y");
      }
      else
      {
        k = 0;
        localFbpArchivesHeaders.setAttribute1("N");
        paramFbpVoucherApproveV.setAttribute1("N");
      }
      if (i != 0)
      {
        if ("M".equals(localFbpArchivesHeaders.getVerifyStatus())) {
          return "M_OK";
        }
        if ("U".equals(localFbpArchivesHeaders.getVerifyStatus()))
        {
          if ("N".equals(localFbpArchivesHeaders.getAttribute1()))
          {
            localStringBuffer = approveAgree(localFbpArchivesHeaders, "1", localStringBuffer);
            if ("N".equals(str2)) {
              continue;
            }
          }
          if (k != 0)
          {
            localFbpArchivesHeaders.setArchivesStatus("ARCHIVES_ALREADY_APPROVE");
            localFbpArchivesHistories.setArchivesStatus("ARCHIVES_ALREADY_APPROVE");
          }
          else
          {
            localFbpArchivesHeaders.setArchivesStatus("ARCHIVES_WAIT_BORROW");
            localFbpArchivesHistories.setArchivesStatus("ARCHIVES_WAIT_BORROW");
            localFbpArchivesHeaders.setVerifyStatus("M");
          }
        }
        if (("".equals(localFbpArchivesHeaders.getVerifyStatus())) || (localFbpArchivesHeaders.getVerifyStatus() == null))
        {
          if ("N".equals(localFbpArchivesHeaders.getAttribute1()))
          {
            localStringBuffer = approveAgree(localFbpArchivesHeaders, "0", localStringBuffer);
            if ("N".equals(str2)) {
              continue;
            }
            paramFbpVoucherApproveV.setAttribute1("N");
          }
          else
          {
            paramFbpVoucherApproveV.setAttribute1("Y");
          }
          localFbpArchivesHeaders.setVerifyStatus("U");
        }
        this.fbpVoucherApproveVDAO.updateFbpVoucherApproveV(localFbpArchivesHeaders);
        ((IFbpArchivesHeadersDS)localObject).clickSendEmailorSmsTwo(localFbpArchivesHeaders.getArchivesHeaderId().toString());
      }
      else
      {
        if ("N".equals(localFbpArchivesHeaders.getAttribute1()))
        {
          localStringBuffer = approveAgree(localFbpArchivesHeaders, "0", localStringBuffer);
          if ("N".equals(str2)) {
            continue;
          }
        }
        if ("U".equals(localFbpArchivesHeaders.getVerifyStatus())) {
          return "U_OK";
        }
        if ("M".equals(localFbpArchivesHeaders.getVerifyStatus())) {
          return "M_OK";
        }
        localFbpArchivesHeaders.setVerifyStatus("U");
        this.fbpVoucherApproveVDAO.updateFbpVoucherApproveV(localFbpArchivesHeaders);
      }
      localFbpArchivesHistories.setArchivesHeaderId(Long.valueOf(Long.parseLong((String)paramList1.get(j))));
      localFbpArchivesHistories.setAttribute8("OPERATION_APPROVE");
      ObjectCopyUtils.setWho(localFbpArchivesHistories);
      localArrayList3.add(localFbpArchivesHistories);
      this.fbpVoucherApproveVDAO.insertFbpVoucherApproveVs(localArrayList3);
      if (localStringBuffer.length() == 0) {
        appraiseAfterSendEmailorSmsOne(localFbpArchivesHeaders);
      }
    }
    if (localStringBuffer.length() > 0) {
      return "不允许借阅!";
    }
    return "Y";
  }
  
  public void appraiseAfterSendEmailorSmsOne(FbpArchivesHeaders paramFbpArchivesHeaders)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MM月dd日");
    IFbpNoticesNewDS localIFbpNoticesNewDS = (IFbpNoticesNewDS)SSBBus.findDomainService("fbpNoticesNewDS");
    if ((paramFbpArchivesHeaders == null) || (paramFbpArchivesHeaders.getEmployeeId() == null)) {
      return;
    }
    FbpNoticesNew localFbpNoticesNew = new FbpNoticesNew();
    StringBuilder localStringBuilder = new StringBuilder("您好，档案借阅申请单").append(paramFbpArchivesHeaders).append("已经于").append(localSimpleDateFormat.format(new Date())).append("审批完成，请您及时查看。");
    localFbpNoticesNew.setContent(localStringBuilder.toString());
    localFbpNoticesNew.setToUserId(paramFbpArchivesHeaders.getEmployeeId().toString());
    localFbpNoticesNew.setFromUserId(Long.valueOf(Long.parseLong("0")));
    localFbpNoticesNew.setStatus(Integer.valueOf(0));
    if (paramFbpArchivesHeaders.getArchivesHeaderId() != null) {
      localFbpNoticesNew.setBoeHeaderId(paramFbpArchivesHeaders.getArchivesHeaderId());
    }
    localFbpNoticesNew.setId(null);
    localFbpNoticesNew.setNoticeType("1");
    localIFbpNoticesNewDS.insertFbpNoticesNew(localFbpNoticesNew);
    localFbpNoticesNew.setTemplateId("tpdsubmit");
    localFbpNoticesNew.setNoticeType("2");
    localFbpNoticesNew.setId(null);
    localIFbpNoticesNewDS.insertFbpNoticesNew(localFbpNoticesNew);
  }
  
  public String fbpVoucherApproveVAgree(FbpVoucherApproveV paramFbpVoucherApproveV, String paramString)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    this.flag = "Y";
    ArrayList localArrayList = new ArrayList();
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      FbpArchivesHistories localFbpArchivesHistories = new FbpArchivesHistories();
      ObjectCopyUtils.copy(paramFbpVoucherApproveV, localFbpArchivesHistories);
      localFbpArchivesHistories.setEnabledFlag("Y");
      localFbpArchivesHistories.setEmployeeNumber(localEasUserInfo.getUserId());
      localFbpArchivesHistories.setEmployeeName(localEasUserInfo.getUserName());
      localFbpArchivesHistories.setEmployeeId(Long.valueOf(localEasUserInfo.getUserInfoPk().longValue()));
      FbpArchivesHeaders localFbpArchivesHeaders = this.fbpVoucherApproveVDAO.getFbpVoucherApproveV(Long.valueOf(Long.parseLong(paramString)));
      localFbpArchivesHistories.setApproveCommand("AGREE");
      localFbpArchivesHistories.setApproveComment(null);
      ObjectCopyUtils.setWho(localFbpArchivesHeaders);
      String str = this.fbpVoucherApproveVDAO.getObjectList(localFbpArchivesHeaders.getNumberAttribute1());
      IFbpArchivesHeadersDS localIFbpArchivesHeadersDS = (IFbpArchivesHeadersDS)SSBBus.findDomainService("fbpArchivesHeadersDS");
      if ((str == null) || ("".equals(str)))
      {
        localStringBuffer.append("M");
        return localStringBuffer.toString();
      }
      if (str.equals(localEasUserInfo.getUserId()))
      {
        localFbpArchivesHeaders.setArchivesStatus("ARCHIVES_ALREADY_APPROVE");
        localFbpArchivesHistories.setArchivesStatus("ARCHIVES_ALREADY_APPROVE");
        if ("N".equals(localFbpArchivesHeaders.getAttribute1())) {
          localStringBuffer = approveAgree(localFbpArchivesHeaders, "1", localStringBuffer);
        }
        this.fbpVoucherApproveVDAO.updateFbpVoucherApproveV(localFbpArchivesHeaders);
        localIFbpArchivesHeadersDS.clickSendEmailorSmsTwo(localFbpArchivesHeaders.getArchivesHeaderId().toString());
      }
      else
      {
        localFbpArchivesHeaders.setAttribute3(str);
        localFbpArchivesHistories.setArchivesStatus(localFbpArchivesHeaders.getArchivesStatus());
        if ("N".equals(localFbpArchivesHeaders.getAttribute1())) {
          localStringBuffer = approveAgree(localFbpArchivesHeaders, "0", localStringBuffer);
        }
        this.fbpVoucherApproveVDAO.updateFbpVoucherApproveV(localFbpArchivesHeaders);
        localIFbpArchivesHeadersDS.clickSendEmailorSmsFour(localFbpArchivesHeaders.getApplyNum());
      }
      localFbpArchivesHistories.setArchivesHeaderId(Long.valueOf(Long.parseLong(paramString)));
      ObjectCopyUtils.setWho(localFbpArchivesHistories);
      localArrayList.add(localFbpArchivesHistories);
      this.fbpVoucherApproveVDAO.insertFbpVoucherApproveVs(localArrayList);
      if (localStringBuffer.length() > 0) {
        return "不允许借阅!";
      }
      return "Y";
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localStringBuffer.append("N");
    }
    return localStringBuffer.toString();
  }
  
  public String fbpVoucherApproveVDisGree(FbpVoucherApproveV paramFbpVoucherApproveV, List<String> paramList1, List<String> paramList2)
    throws Exception
  {
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i = 0; i < paramList1.size(); i++)
    {
      FbpArchivesHistories localFbpArchivesHistories = new FbpArchivesHistories();
      ObjectCopyUtils.copy(paramFbpVoucherApproveV, localFbpArchivesHistories);
      localFbpArchivesHistories.setEnabledFlag("Y");
      localFbpArchivesHistories.setEmployeeNumber(localEasUserInfo.getUserId());
      localFbpArchivesHistories.setEmployeeName(localEasUserInfo.getUserName());
      localFbpArchivesHistories.setEmployeeId(Long.valueOf(localEasUserInfo.getUserInfoPk().longValue()));
      localFbpArchivesHistories.setApproveCommand("DIS_AGREE");
      localFbpArchivesHistories.setArchivesHeaderId(Long.valueOf(Long.parseLong((String)paramList1.get(i))));
      localFbpArchivesHistories.setArchivesStatus("ARCHIVES_ALREADY_REJECTED");
      ObjectCopyUtils.setWho(localFbpArchivesHistories);
      localArrayList2.add(localFbpArchivesHistories);
      FbpArchivesHeaders localFbpArchivesHeaders = this.fbpVoucherApproveVDAO.getFbpVoucherApproveV(Long.valueOf(Long.parseLong((String)paramList1.get(i))));
      localFbpArchivesHeaders.setArchivesStatus("ARCHIVES_ALREADY_REJECTED");
      localFbpArchivesHeaders.setVerifyStatus("");
      ObjectCopyUtils.setWho(localFbpArchivesHeaders);
      localFbpArchivesHistories.setProcessId(localFbpArchivesHeaders.getProcessId());
      localFbpArchivesHistories.setWorkItemId(localFbpArchivesHeaders.getWorkItemId());
      String str = ArchivesUtils.approve(1, localFbpArchivesHeaders.getApplyNum());
      if (!"Y".equals(str)) {
        return str;
      }
      localArrayList1.add(localFbpArchivesHeaders);
    }
    if (localArrayList1.size() > 0)
    {
      this.fbpVoucherApproveVDAO.insertFbpVoucherApproveVs(localArrayList2);
      this.fbpVoucherApproveVDAO.updateFbpVoucherApproveVs(localArrayList1);
    }
    return "Y";
  }
  
  public StringBuffer approveAgree(FbpArchivesHeaders paramFbpArchivesHeaders, String paramString, StringBuffer paramStringBuffer)
  {
    List localList = this.fbpVoucherApproveVDAO.getFbpVoucherAll(paramFbpArchivesHeaders.getArchivesHeaderId());
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      FbpArchivesLines localFbpArchivesLines = (FbpArchivesLines)localIterator.next();
      EvsVoucher localEvsVoucher = this.fbpArchivesHeadersDAO.getEvsVoucher(localFbpArchivesLines.getVoucherId());
      String str1 = localEvsVoucher.getVoucherStatus();
      if (("BORROWING".equals(str1)) || ("NOW_FLITTING".equals(str1)))
      {
        String str2 = "";
        if ("BORROWING".equals(str1)) {
          str2 = "借阅中";
        }
        if ("NOW_FLITTING".equals(str1)) {
          str2 = "调拨中";
        }
        paramStringBuffer.append(" \n单号：" + paramFbpArchivesHeaders.getApplyNum() + "的凭证号：" + localEvsVoucher.getJournalNum() + " " + str2 + ",");
        this.flag = "N";
        return paramStringBuffer;
      }
      localEvsVoucher.setVoucherStatus("BORROWING");
      ObjectCopyUtils.setWho(localEvsVoucher);
      localArrayList.add(localEvsVoucher);
    }
    try
    {
      if (("1".equals(paramString)) && (localArrayList.size() > 0))
      {
        updateObjects(localArrayList);
        this.flag = "Y";
      }
      return paramStringBuffer;
    }
    catch (Exception localException) {}
    return paramStringBuffer;
  }
  
  public void insertFbpVoucherApproveVs(List<FbpArchivesHistories> paramList)
  {
    this.fbpVoucherApproveVDAO.insertFbpVoucherApproveVs(paramList);
  }
  
  public void removeFbpVoucherApproveVs(List<FbpVoucherApproveV> paramList)
  {
    this.fbpVoucherApproveVDAO.removeFbpVoucherApproveVs(paramList);
  }
  
  public IFbpArchivesHeadersDAO getFbpArchivesHeadersDAO()
  {
    return this.fbpArchivesHeadersDAO;
  }
  
  public void setFbpArchivesHeadersDAO(IFbpArchivesHeadersDAO paramIFbpArchivesHeadersDAO)
  {
    this.fbpArchivesHeadersDAO = paramIFbpArchivesHeadersDAO;
  }
  
  public IFbpVoucherApproveVDAO getFbpVoucherApproveVDAO()
  {
    return this.fbpVoucherApproveVDAO;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.service.FbpVoucherApproveVDS
 * JD-Core Version:    0.7.0.1
 */