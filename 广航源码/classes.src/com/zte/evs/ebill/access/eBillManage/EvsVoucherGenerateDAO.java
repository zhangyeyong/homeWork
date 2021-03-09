package com.zte.evs.ebill.access.eBillManage;

import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.eimage.access.baseconfig.dao.IImageCommonDAO;
import com.zte.eimage.access.common.dao.IImageDisplayDAO;
import com.zte.eimage.business.baseconfig.model.EidImageInfos;
import com.zte.evs.ebill.common.Content;
import com.zte.evs.ebill.common.ContentComparator;
import com.zte.evs.ebill.common.EvsObjectUtils;
import com.zte.evs.ebill.model.eBillManage.EvsBook;
import com.zte.evs.ebill.model.eBillManage.EvsBookModel;
import com.zte.evs.ebill.model.eBillManage.EvsManageOrgV;
import com.zte.evs.ebill.model.eBillManage.EvsVoucher;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherCheckHistories;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherImageV;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherSelect;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherV;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherVSec;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.util.Util;
import com.zte.ssb.orm.zorm.ZormTemplate;
import com.zte.ssb.servicecontainer.business.server.RIAContext;
import com.zte.ssb.zorm.Query;
import com.zte.ssb.zorm.SQLQuery;
import com.zte.ssb.zorm.Session;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class EvsVoucherGenerateDAO
  extends BaseDAO
  implements IEvsVoucherGenerateDAO
{
  private static final Log log = LogFactory.getLog(EvsVoucherGenerateDAO.class);
  private IImageDisplayDAO imageDisplayDAO;
  
  public Map findEmployeeHeaderByQry(EvsVoucherSelect paramEvsVoucherSelect, int paramInt1, int paramInt2)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList1 = new ArrayList(1);
    localStringBuffer.append("from EvsVoucherV e where 1=1");
    ArrayList localArrayList2 = new ArrayList();
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getBeginID()))
    {
      localStringBuffer.append(" AND e.journalNum >= ?");
      localArrayList1.add(paramEvsVoucherSelect.getBeginID().toUpperCase());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getEndID()))
    {
      localStringBuffer.append(" AND e.journalNum <= ?");
      localArrayList1.add(paramEvsVoucherSelect.getEndID().toUpperCase());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getSet_book_name()))
    {
      localStringBuffer.append(" AND e.setBookName = ?");
      localArrayList1.add(paramEvsVoucherSelect.getSet_book_name().toString());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getOu_id()))
    {
      localStringBuffer.append(" AND e.ouName = ?");
      localArrayList1.add(paramEvsVoucherSelect.getOu_id());
    }
    if (StringUtils.isNotBlank(paramEvsVoucherSelect.getBoeNum()))
    {
      localStringBuffer.append(" AND e.boeNum like ?");
      localArrayList1.add(("%" + paramEvsVoucherSelect.getBoeNum() + "%").toUpperCase());
    }
    if (StringUtils.isNotBlank(paramEvsVoucherSelect.getCompanyCode()))
    {
      localStringBuffer.append(" AND e.companyCode = ?");
      localArrayList1.add(paramEvsVoucherSelect.getCompanyCode());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getPeriod_name()))
    {
      localStringBuffer.append(" AND e.periodName = ?");
      localArrayList1.add(paramEvsVoucherSelect.getPeriod_name().toString());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getUser_name()))
    {
      localStringBuffer.append(" AND e.userName like ? ");
      localArrayList1.add("%" + paramEvsVoucherSelect.getUser_name() + "%");
    }
    if (paramEvsVoucherSelect.getUserId() != null)
    {
      localStringBuffer.append(" AND e.userId = ? ");
      localArrayList1.add(paramEvsVoucherSelect.getUserId());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getSource_code()))
    {
      localStringBuffer.append(" AND e.source = ?");
      localArrayList1.add(paramEvsVoucherSelect.getSource_code().toString());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getInvoiceType()))
    {
      localStringBuffer.append(" AND e.invoiceTypeCode = ?");
      localArrayList1.add(paramEvsVoucherSelect.getInvoiceType());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getVoucherStatus()))
    {
      localStringBuffer.append(" AND e.voucherStatus = ?");
      localArrayList1.add(paramEvsVoucherSelect.getVoucherStatus().toString());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getBegin_created_date()))
    {
      localStringBuffer.append(" AND to_char(e.createdDate,'yyyy-mm-dd') >= ?");
      localArrayList1.add(paramEvsVoucherSelect.getBegin_created_date().toString());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getEnd_created_date()))
    {
      localStringBuffer.append(" AND to_char(e.createdDate,'yyyy-mm-dd') <= ?");
      localArrayList1.add(paramEvsVoucherSelect.getEnd_created_date().toString());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getJournalSubName()))
    {
      localStringBuffer.append(" AND ( e.journalSubName like ? ) ");
      localArrayList1.add("%" + paramEvsVoucherSelect.getJournalSubName().toUpperCase() + "%");
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getInvoiceNum()))
    {
      localStringBuffer.append(" AND e.invoiceNum like ? ");
      localArrayList1.add("%" + paramEvsVoucherSelect.getInvoiceNum().toUpperCase() + "%");
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getMatchModes()))
    {
      localStringBuffer.append(" AND e.matchMode = ? ");
      localArrayList1.add(paramEvsVoucherSelect.getMatchModes());
    }
    if ((localEasUserInfo != null) && (!"10000".equals(localEasUserInfo.getUserId())))
    {
      localStringBuffer.append(" and exists(select 1 from FbpPseRelationsV fpr where fpr.companyId= e.companyId and fpr.posStructureCode = ? and fpr.employeeId = ?)");
      localArrayList1.add("VOUCHER_QUERY");
      localArrayList1.add(Long.valueOf(localEasUserInfo.getUserInfoPk().longValue()));
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getApprover()))
    {
      localStringBuffer.append(" AND e.approver like ?");
      localArrayList1.add("%" + paramEvsVoucherSelect.getApprover() + "%");
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getBegin_approver_date()))
    {
      localStringBuffer.append(" AND e.approverDate >= to_date(?,'yyyy-mm-dd')");
      localArrayList1.add(paramEvsVoucherSelect.getBegin_approver_date());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getEnd_approver_date()))
    {
      localStringBuffer.append(" AND e.approverDate <= to_date(?,'yyyy-mm-dd')+1");
      localArrayList1.add(paramEvsVoucherSelect.getEnd_approver_date());
    }
    localStringBuffer.append(" order by e.journalNum");
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1 / paramInt2 + 1, paramInt2, localArrayList1.toArray());
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", localPageInfo.getResult());
    localHashMap.put("totalCount", Long.valueOf(localPageInfo.getTotalCount()));
    return localHashMap;
  }
  
  public void update(String paramString1, String paramString2)
  {
    log.debug("update THeader header");
    try
    {
      String str = " update EVS_VOUCHER set voucher_status ='" + paramString1 + "'  where voucher_id = " + paramString2 + "";
      getSession().createSQLQuery(str).executeUpdate();
      log.debug("update successful");
      getSession().flush();
      getSession().clear();
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("update failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  private List getNewVoucherid(String[] paramArrayOfString)
  {
    Object localObject = new ArrayList();
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {
      for (int i = 0; i < paramArrayOfString.length; i++)
      {
        int j = 1;
        if (i < paramArrayOfString.length) {
          for (int k = i + 1; k < paramArrayOfString.length; k++) {
            if (paramArrayOfString[i].equals(paramArrayOfString[k])) {
              j = 0;
            }
          }
        }
        if (j != 0) {
          ((List)localObject).add(paramArrayOfString[i]);
        }
      }
    }
    localObject = getVoucheridByDesc((List)localObject);
    return localObject;
  }
  
  private List getVoucheridByDesc(List paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    for (int i = 0; i < paramList.size(); i++) {
      localArrayList1.add(new Content(Long.valueOf(paramList.get(i).toString()).longValue(), String.valueOf(i)));
    }
    ContentComparator localContentComparator = new ContentComparator();
    Collections.sort(localArrayList1, localContentComparator);
    ArrayList localArrayList2 = new ArrayList();
    for (int j = 0; j < localArrayList1.size(); j++)
    {
      Content localContent = (Content)localArrayList1.get(j);
      localArrayList2.add(Long.valueOf(localContent.getKey()));
    }
    return localArrayList2;
  }
  
  public List<Long> getEvsVoucherBookPackageByBookId(Long paramLong)
  {
    String str = "select voucher_id from EVS.EVS_VOUCHER_BOOK_PACKAGE t where t.book_id = ?";
    return super.getSession().createSQLQuery(str).setLong(0, paramLong.longValue()).list();
  }
  
  public boolean update(EvsBook paramEvsBook, EvsBookModel paramEvsBookModel)
  {
    log.debug("update EvsVoucher evsVoucher");
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    boolean bool = false;
    try
    {
      String[] arrayOfString = paramEvsBookModel.getVoucherId().split(",");
      List localList1 = getNewVoucherid(arrayOfString);
      String str1 = "select t.journal_num from evs_voucher t where t.voucher_id in (" + paramEvsBookModel.getVoucherId() + ")";
      List localList2 = getSession().createSQLQuery(str1).list();
      if ((localList1 != null) && (localList1.size() > 0))
      {
        for (int i = 0; i < localList1.size(); i++)
        {
          String str2;
          SQLQuery localSQLQuery;
          if ((((String)localList2.get(i)).toString().equals(paramEvsBook.getBeginNum())) || (((String)localList2.get(i)).toString().equals(paramEvsBook.getEndNum())))
          {
            str2 = "update evs_voucher set voucher_status = 'BOOKED_NO_BOX', book_end_flag ='1'  where voucher_id = " + localList1.get(i).toString() + "";
            localSQLQuery = getSession().createSQLQuery(str2);
            localSQLQuery.executeUpdate();
          }
          else
          {
            str2 = "update evs_voucher set voucher_status = 'BOOKED_NO_BOX',book_end_flag ='0'  where voucher_id = " + localList1.get(i).toString();
            try
            {
              localSQLQuery = getSession().createSQLQuery(str2);
              localSQLQuery.executeUpdate();
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
          }
          if (localEasUserInfo != null)
          {
            str2 = " update EVS_VOUCHER set LAST_UPDATE_DATE = sysdate , LAST_UPDATE_BY = " + localEasUserInfo.getUserInfoPk() + " , LAST_UPDATE_LOGIN = " + localEasUserInfo.getUserInfoPk() + " where  voucher_id =" + localList1.get(i).toString();
            getSession().createSQLQuery(str2).executeUpdate();
            log.debug("update successful");
          }
          else
          {
            str2 = " update EVS_VOUCHER set LAST_UPDATE_DATE = sysdate , LAST_UPDATE_BY = 0 , LAST_UPDATE_LOGIN = 0 where  voucher_id  =" + localList1.get(i).toString();
            getSession().createSQLQuery(str2).executeUpdate();
            log.debug("update successful");
          }
        }
        bool = true;
      }
      getSession().flush();
      getSession().clear();
      log.debug("update successful");
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("update failed", localRuntimeException);
      throw localRuntimeException;
    }
    return bool;
  }
  
  public List findImage(Long paramLong, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append("select localPath,imageUrl,webhostUrl,barcode from EvsImage i where voucherId = " + paramLong + " and barcode is null order by i.voucherId,i.barcode desc,i.originImageId,i.imageId");
    List localList1 = getSession().createQuery(localStringBuffer.toString()).list();
    if ((paramString != null) && (paramString.trim().length() > 0))
    {
      String str = "select localPath,imageUrl,webhostUrl,barcode from EvsImage where barcode like '%" + paramString + "%'  order by i.voucherId,i.barcode desc,i.originImageId,i.imageId";
      List localList2 = getSession().createQuery(str).list();
      localList1.addAll(localList2);
    }
    return localList1;
  }
  
  public List findImage(Long paramLong)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append("select localPath,imageUrl,webhostUrl,barcode from EvsImage where voucherId = " + paramLong + " order by barcode desc, lastUpdateDate,imageId asc");
    List localList = getSession().createQuery(localStringBuffer.toString()).list();
    return localList;
  }
  
  public Map findVoucherSubmit(EvsVoucherSelect paramEvsVoucherSelect, int paramInt1, int paramInt2)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    ArrayList localArrayList1 = new ArrayList();
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList2 = new ArrayList(1);
    localStringBuffer.append("from EvsVoucherV e where 2>1 ");
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getScanVoucherNum()))
    {
      localObject1 = new StringBuffer();
      localObject2 = paramEvsVoucherSelect.getScanVoucherNum().split(",");
      for (int i = 0; i < localObject2.length; i++) {
        if (i == 0)
        {
          ((StringBuffer)localObject1).append("?");
          localArrayList2.add(localObject2[i]);
        }
        else
        {
          ((StringBuffer)localObject1).append(" ,?");
          localArrayList2.add(localObject2[i]);
        }
      }
      localStringBuffer.append(" and e.journalNum in (" + ((StringBuffer)localObject1).toString() + ") ");
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getBeginID()))
    {
      localStringBuffer.append(" AND e.journalNum >= ?");
      localArrayList2.add(paramEvsVoucherSelect.getBeginID().toUpperCase());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getEndID()))
    {
      localStringBuffer.append(" AND e.journalNum <= ?");
      localArrayList2.add(paramEvsVoucherSelect.getEndID().toUpperCase());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getSet_book_name()))
    {
      localStringBuffer.append(" AND e.setBookName = ?");
      localArrayList2.add(paramEvsVoucherSelect.getSet_book_name().toString());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getOu_id()))
    {
      localStringBuffer.append(" AND e.ouName = ?");
      localArrayList2.add(paramEvsVoucherSelect.getOu_id());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getPeriod_name()))
    {
      localStringBuffer.append(" AND e.periodName = ?");
      localArrayList2.add(paramEvsVoucherSelect.getPeriod_name().toString());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getInvoiceFstTypeName()))
    {
      localStringBuffer.append(" AND e.subDocName = ?");
      localArrayList2.add(paramEvsVoucherSelect.getInvoiceFstTypeName().toString());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getSource_code()))
    {
      localStringBuffer.append(" AND e.source = ?");
      localArrayList2.add(paramEvsVoucherSelect.getSource_code().toString());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getInvoiceType()))
    {
      localStringBuffer.append(" AND e.invoiceType = ?");
      localArrayList2.add(paramEvsVoucherSelect.getInvoiceType().toString());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getJournalSubName()))
    {
      localStringBuffer.append(" AND ( e.journalSubName like ? ) ");
      localArrayList2.add("%" + paramEvsVoucherSelect.getJournalSubName().toUpperCase() + "%");
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getInvoiceNum()))
    {
      localStringBuffer.append(" AND e.invoiceNum like ? ");
      localArrayList2.add("%" + paramEvsVoucherSelect.getInvoiceNum().toUpperCase() + "%");
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getVoucherStatus()))
    {
      localStringBuffer.append(" AND e.voucherStatus = ?");
      localArrayList2.add(paramEvsVoucherSelect.getVoucherStatus().toString());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getBegin_created_date()))
    {
      localStringBuffer.append(" AND to_char(e.createdDate,'yyyy-mm-dd') >= ?");
      localArrayList2.add(paramEvsVoucherSelect.getBegin_created_date().toString());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getEnd_created_date()))
    {
      localStringBuffer.append(" AND to_char(e.createdDate,'yyyy-mm-dd') <= ?");
      localArrayList2.add(paramEvsVoucherSelect.getEnd_created_date().toString());
    }
    if (localEasUserInfo != null) {
      if (localEasUserInfo.getUserId().equals("10000"))
      {
        localStringBuffer.append(" AND e.userName like ? ");
        localArrayList2.add("%%");
      }
      else
      {
        localStringBuffer.append(" AND e.userName = ? ");
        localArrayList2.add(localEasUserInfo.getUserName());
      }
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getUser_name()))
    {
      localStringBuffer.append(" AND e.userName like ? ");
      localArrayList2.add("%" + paramEvsVoucherSelect.getUser_name() + "%");
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getApprover()))
    {
      localStringBuffer.append(" AND e.approver like ?");
      localArrayList2.add("%" + paramEvsVoucherSelect.getApprover() + "%");
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getBegin_approver_date()))
    {
      localStringBuffer.append(" AND to_char(e.approverDate,'yyyy-mm-dd') >= ?");
      localArrayList2.add(paramEvsVoucherSelect.getBegin_approver_date().toString());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getMatchModes()))
    {
      localStringBuffer.append(" AND e.matchMode = ? ");
      localArrayList2.add(paramEvsVoucherSelect.getMatchModes());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getEnd_approver_date()))
    {
      localStringBuffer.append(" AND to_char(e.approverDate,'yyyy-mm-dd') <= ?");
      localArrayList2.add(paramEvsVoucherSelect.getEnd_approver_date().toString());
    }
    localStringBuffer.append(" and voucherStatus in ('MATCHED','UNMATCH','BACKED') ORDER BY e.journalNum desc");
    Object localObject1 = super.PageInfoQuery(localStringBuffer.toString(), paramInt1 / paramInt2 + 1, paramInt2, localArrayList2.toArray());
    Object localObject2 = new HashMap();
    ((Map)localObject2).put("data", ((PageInfo)localObject1).getResult());
    ((Map)localObject2).put("totalCount", Long.valueOf(((PageInfo)localObject1).getTotalCount()));
    return localObject2;
  }
  
  public Map findEmployeeHeaderByPyVc(EvsVoucherSelect paramEvsVoucherSelect, int paramInt1, int paramInt2)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append("from EvsVoucherV e where 2>1  AND e.subDocName='付款凭证'");
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getBeginID()))
    {
      localStringBuffer.append(" AND e.journalNum >= ?");
      localArrayList.add(paramEvsVoucherSelect.getBeginID().toUpperCase());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getEndID()))
    {
      localStringBuffer.append(" AND e.journalNum <= ?");
      localArrayList.add(paramEvsVoucherSelect.getEndID().toUpperCase());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getSet_book_name()))
    {
      localStringBuffer.append(" AND e.setBookName = ?");
      localArrayList.add(paramEvsVoucherSelect.getSet_book_name().toString());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getOu_id()))
    {
      localStringBuffer.append(" AND e.ouName = ?");
      localArrayList.add(paramEvsVoucherSelect.getOu_id());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getPeriod_name()))
    {
      localStringBuffer.append(" AND e.periodName = ?");
      localArrayList.add(paramEvsVoucherSelect.getPeriod_name().toString());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getInvoiceFstTypeName())) {
      if ("付款凭证".equals(paramEvsVoucherSelect.getInvoiceFstTypeName()))
      {
        localStringBuffer.append(" AND e.subDocName = '付款凭证'");
      }
      else
      {
        localStringBuffer.append(" AND e.subDocName = ?");
        localArrayList.add("过滤其他凭证");
      }
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getSource_code()))
    {
      localStringBuffer.append(" AND e.source = ?");
      localArrayList.add(paramEvsVoucherSelect.getSource_code().toString());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getInvoiceType()))
    {
      localStringBuffer.append(" AND e.invoiceType = ?");
      localArrayList.add(paramEvsVoucherSelect.getInvoiceType().toString());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getVoucherStatus()))
    {
      localStringBuffer.append(" AND e.voucherStatus = ?");
      localArrayList.add(paramEvsVoucherSelect.getVoucherStatus().toString());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getBegin_created_date()))
    {
      localStringBuffer.append(" AND to_char(e.createdDate,'yyyy-mm-dd') >= ?");
      localArrayList.add(paramEvsVoucherSelect.getBegin_created_date().toString());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getEnd_created_date()))
    {
      localStringBuffer.append(" AND to_char(e.createdDate,'yyyy-mm-dd') <= ?");
      localArrayList.add(paramEvsVoucherSelect.getEnd_created_date().toString());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getJournalSubName()))
    {
      localStringBuffer.append(" AND ( e.journalSubName like ? ) ");
      localArrayList.add("%" + paramEvsVoucherSelect.getJournalSubName().toUpperCase() + "%");
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getInvoiceNum()))
    {
      localStringBuffer.append(" AND e.invoiceNum like ? ");
      localArrayList.add("%" + paramEvsVoucherSelect.getInvoiceNum().toUpperCase() + "%");
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getMatchModes()))
    {
      localStringBuffer.append(" AND e.matchMode = ? ");
      localArrayList.add(paramEvsVoucherSelect.getMatchModes());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getUser_name()))
    {
      localStringBuffer.append(" AND e.userName like ? ");
      localArrayList.add("%" + paramEvsVoucherSelect.getUser_name() + "%");
    }
    if (localEasUserInfo != null) {
      if (localEasUserInfo.getUserId().equals("10000"))
      {
        localStringBuffer.append(" AND e.userName like ? ");
        localArrayList.add("%%");
      }
      else
      {
        localStringBuffer.append(" AND e.userName = ? ");
        localArrayList.add(localEasUserInfo.getUserName());
      }
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getApprover()))
    {
      localStringBuffer.append(" AND e.approver like ?");
      localArrayList.add("%" + paramEvsVoucherSelect.getApprover() + "%");
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getBegin_approver_date()))
    {
      localStringBuffer.append(" AND to_char(e.approverDate,'yyyy-mm-dd') >= ?");
      localArrayList.add(paramEvsVoucherSelect.getBegin_approver_date().toString());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getEnd_approver_date()))
    {
      localStringBuffer.append(" AND to_char(e.approverDate,'yyyy-mm-dd') <= ?");
      localArrayList.add(paramEvsVoucherSelect.getEnd_approver_date().toString());
    }
    localStringBuffer.append(" ORDER BY e.journalNum desc");
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1 / paramInt2 + 1, paramInt2, localArrayList.toArray());
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", localPageInfo.getResult());
    localHashMap.put("totalCount", Long.valueOf(localPageInfo.getTotalCount()));
    return localHashMap;
  }
  
  public void saveVoucher(String paramString)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    log.debug("update EvsVoucher voucher");
    try
    {
      String str;
      if (localEasUserInfo != null)
      {
        str = " update EVS_VOUCHER set LAST_UPDATE_DATE = sysdate , LAST_UPDATE_BY = " + localEasUserInfo.getUserInfoPk() + " , LAST_UPDATE_LOGIN = " + localEasUserInfo.getUserInfoPk() + " where voucher_id in " + paramString + "";
        getSession().createSQLQuery(str).executeUpdate();
        getSession().flush();
        getSession().clear();
        log.debug("update successful");
      }
      else
      {
        str = " update EVS_VOUCHER set LAST_UPDATE_DATE = sysdate , LAST_UPDATE_BY = 0 , LAST_UPDATE_LOGIN = 0 where voucher_id in " + paramString + "";
        getSession().createSQLQuery(str).executeUpdate();
        log.debug("update successful");
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("update failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public List findImageByVoucherId(Long paramLong)
  {
    String str = "select localPath,imageUrl,webhostUrl from EvsImage i where voucherId = " + paramLong + " and barcode is null order by i.voucherId,i.barcode desc,i.originImageId,i.imageId";
    List localList = getSession().createQuery(str).list();
    return localList;
  }
  
  public List findVoucherByVoucherId(Long paramLong)
  {
    String str = "select localPath,imageUrl,webhostUrl from EvsImage i where voucherId = " + paramLong + " order by i.voucherId,i.barcode desc,i.originImageId,i.imageId";
    List localList = getSession().createQuery(str).list();
    return localList;
  }
  
  public List getImageList(List paramList)
  {
    String str1 = "";
    for (int i = 0; i < paramList.size(); i++)
    {
      localObject = (EvsVoucher)paramList.get(i);
      str1 = str1 + ((EvsVoucher)localObject).getVoucherId();
      if (i < paramList.size() - 1) {
        str1 = str1 + ",";
      }
      System.out.println(str1);
    }
    String str2 = "select e.local_path,e.image_url,e.webhost_url from evs_image e  where e.voucher_id in(" + str1 + ")";
    System.out.println(str2);
    Object localObject = getSession().createSQLQuery(str2).list();
    System.out.println(((List)localObject).size() + "****");
    return localObject;
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
  
  public List<EvsVoucherCheckHistories> findVoucherId(Long paramLong)
  {
    String str = "FROM EvsVoucherCheckHistories evch WHERE evch.voucherId=" + paramLong + " order by evch.lastUpdateDate desc";
    List localList = super.getZormTemplate().find(str);
    if ((null != localList) && (localList.size() > 0)) {
      return localList;
    }
    return localList;
  }
  
  public String getCheckPersonName(String paramString)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    String str1 = "select CHECK_PERSON_ID from fbp.fbp_check_person where EMPLOYEE_ID=(select EMPLOYEE_ID from fbp_employees where EMPLOYEE_NUMBER='" + localEasUserInfo.getUserId() + "'" + ") and JOURNAL_NAME='" + paramString + "' and ENABLED_FLAG='Y'";
    SQLQuery localSQLQuery = getSession().createSQLQuery(str1);
    List localList = localSQLQuery.list();
    String str2 = "";
    if ((localList != null) && (!localList.isEmpty())) {
      if (localList.get(0) != null) {
        str2 = localList.get(0).toString();
      } else {
        str2 = "";
      }
    }
    return str2;
  }
  
  public void saveVoucherByVoucherId(String paramString1, String paramString2)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    log.debug("update EvsVoucher voucher");
    try
    {
      String str;
      if (localEasUserInfo != null)
      {
        str = " update EVS_VOUCHER set LAST_UPDATE_DATE = sysdate , LAST_UPDATE_BY = " + localEasUserInfo.getUserInfoPk() + " , LAST_UPDATE_LOGIN = " + localEasUserInfo.getUserInfoPk() + " , CHECK_PERSON_ID=" + paramString1 + " , SUBMIT_PERSON_ID=" + localEasUserInfo.getUserInfoPk() + " where voucher_id =(" + paramString2 + ")";
        getSession().createSQLQuery(str).executeUpdate();
        getSession().flush();
        getSession().clear();
        log.debug("update successful");
      }
      else
      {
        str = " update EVS_VOUCHER set LAST_UPDATE_DATE = sysdate , LAST_UPDATE_BY = 0 , LAST_UPDATE_LOGIN = 0 where voucher_id = " + paramString2 + "";
        getSession().createSQLQuery(str).executeUpdate();
        log.debug("update successful");
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("update failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public String getsubDocName(String paramString)
  {
    String str1 = "select (select SUB_DOC_NAME  from EVS_SUB_DOC_TYPE   where instr(voucher_type || ',', invoice_Type || ',') > 0    and rownum = 1) as SUB_DOC_NAME     from evs.evs_voucher evh where evh.VOUCHER_ID=" + paramString;
    SQLQuery localSQLQuery = getSession().createSQLQuery(str1);
    List localList = localSQLQuery.list();
    String str2 = "";
    if ((localList != null) && (!localList.isEmpty())) {
      if (localList.get(0) != null) {
        str2 = (String)localList.get(0);
      } else {
        str2 = "";
      }
    }
    return str2;
  }
  
  public PageInfo getImageAccessory(String paramString, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder("from EvsImage ei where  1=1 ");
    ArrayList localArrayList = new ArrayList();
    localStringBuilder.append(" and ei.barcode = ? ");
    if (StringUtils.isBlank(this.imageDisplayDAO.getRoleId())) {
      localStringBuilder.append(" and ( ei.isShowImage is null or ei.isShowImage = 'Y')");
    }
    localStringBuilder.append("order by ei.voucherId,ei.barcode desc,ei.originImageId,ei.imageId");
    localArrayList.add(paramString);
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuilder.toString(), paramInt1, paramInt2, localArrayList.toArray());
    return localPageInfo;
  }
  
  public Map findPrintVoucher(EvsVoucherSelect paramEvsVoucherSelect, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if ((paramEvsVoucherSelect != null) && (paramEvsVoucherSelect.getNumberType() != null) && (paramEvsVoucherSelect.getNumberType().trim().length() > 0))
    {
      localObject1 = new ArrayList();
      StringBuffer localStringBuffer = new StringBuffer();
      localObject2 = null;
      int i;
      if ("TASK_NUM".equals(paramEvsVoucherSelect.getNumberType()))
      {
        localStringBuffer.append("select * From Evs_Voucher_V_Sec t  where t.task_Num in (#task_Num#)");
        localObject3 = new StringBuffer();
        localObject4 = paramEvsVoucherSelect.getNumber().split(",");
        localStringBuffer.append("order by  case");
        for (i = 0; i < localObject4.length; i++)
        {
          if (i == localObject4.length - 1) {
            ((StringBuffer)localObject3).append("'").append(localObject4[i]).append("'");
          } else {
            ((StringBuffer)localObject3).append("'").append(localObject4[i]).append("'").append(",");
          }
          localStringBuffer.append("  when task_Num = ? then ?");
          ((List)localObject1).add(localObject4[i]);
          ((List)localObject1).add(Integer.valueOf(i));
        }
        localStringBuffer.append(" end");
        localObject2 = localStringBuffer.toString().replace("#task_Num#", ((StringBuffer)localObject3).toString());
      }
      else if ("IMAGE_NUM".equals(paramEvsVoucherSelect.getNumberType()))
      {
        localStringBuffer.append("select * From Evs_Voucher_V_Sec t  where t.image_number in (#image_number#)");
        localObject3 = new StringBuffer();
        localStringBuffer.append("order by  case");
        localObject4 = paramEvsVoucherSelect.getNumber().split(",");
        for (i = 0; i < localObject4.length; i++)
        {
          if (i == localObject4.length - 1) {
            ((StringBuffer)localObject3).append("'").append(localObject4[i]).append("'");
          } else {
            ((StringBuffer)localObject3).append("'").append(localObject4[i]).append("'").append(",");
          }
          localStringBuffer.append("  when image_number = ? then ?");
          ((List)localObject1).add(localObject4[i]);
          ((List)localObject1).add(Integer.valueOf(i));
        }
        localStringBuffer.append(" end");
        localObject2 = localStringBuffer.toString().replace("#image_number#", ((StringBuffer)localObject3).toString());
      }
      localObject3 = (IImageCommonDAO)SSBBus.findDomainService("imageCommonDAO");
      localObject4 = ((IImageCommonDAO)localObject3).pageInfoObjectBySql((String)localObject2, (List)localObject1, EvsVoucherVSec.class, paramInt1 / paramInt2 + 1, paramInt2);
      localHashMap.put("data", ((PageInfo)localObject4).getResult());
      localHashMap.put("totalCount", Long.valueOf(((PageInfo)localObject4).getTotalCount()));
    }
    else
    {
      localObject1 = new EvsObjectUtils();
      boolean bool = "Y".equals(paramEvsVoucherSelect.getIsLikeQuery());
      localObject2 = EvsObjectUtils.getUserInfoBySession();
      localObject3 = new StringBuffer();
      localObject4 = new ArrayList(1);
      ((StringBuffer)localObject3).append("from EvsVoucherV e where 1=1");
      ArrayList localArrayList = new ArrayList();
      if (!Util.isStrEmpty(paramEvsVoucherSelect.getBarcode())) {
        if (bool)
        {
          ((StringBuffer)localObject3).append(" and exists(select 1 from EvsImage i where e.voucherId=i.voucherId and i.barcode like ?)");
          ((List)localObject4).add("%" + paramEvsVoucherSelect.getBarcode() + "%");
        }
        else
        {
          ((StringBuffer)localObject3).append(" and exists(select 1 from EvsImage i where e.voucherId=i.voucherId and i.barcode like ?)");
          ((List)localObject4).add(paramEvsVoucherSelect.getBarcode());
        }
      }
      if (!Util.isStrEmpty(paramEvsVoucherSelect.getBeginID()))
      {
        ((StringBuffer)localObject3).append(" AND e.journalNum >= ?");
        ((List)localObject4).add(paramEvsVoucherSelect.getBeginID().toUpperCase());
      }
      if (!Util.isStrEmpty(paramEvsVoucherSelect.getEndID()))
      {
        ((StringBuffer)localObject3).append(" AND e.journalNum <= ?");
        ((List)localObject4).add(paramEvsVoucherSelect.getEndID().toUpperCase());
      }
      if (!Util.isStrEmpty(paramEvsVoucherSelect.getSet_book_name()))
      {
        ((StringBuffer)localObject3).append(" AND e.setBookName = ?");
        ((List)localObject4).add(paramEvsVoucherSelect.getSet_book_name().toString());
      }
      if (!Util.isStrEmpty(paramEvsVoucherSelect.getOu_id()))
      {
        ((StringBuffer)localObject3).append(" AND e.ouName = ?");
        ((List)localObject4).add(paramEvsVoucherSelect.getOu_id());
      }
      if (StringUtils.isNotBlank(paramEvsVoucherSelect.getBoeNum()))
      {
        ((StringBuffer)localObject3).append(" AND e.boeNum like ?");
        ((List)localObject4).add((paramEvsVoucherSelect.getBoeNum() + "%").toUpperCase());
      }
      if (StringUtils.isNotBlank(paramEvsVoucherSelect.getCompanyCode()))
      {
        ((StringBuffer)localObject3).append(" AND e.companyCode = ?");
        ((List)localObject4).add(paramEvsVoucherSelect.getCompanyCode());
      }
      if (!Util.isStrEmpty(paramEvsVoucherSelect.getPeriod_name()))
      {
        ((StringBuffer)localObject3).append(" AND e.periodName = ?");
        ((List)localObject4).add(paramEvsVoucherSelect.getPeriod_name().toString());
      }
      if (!Util.isStrEmpty(paramEvsVoucherSelect.getUser_name()))
      {
        ((StringBuffer)localObject3).append(" AND e.userName like ? ");
        ((List)localObject4).add("%" + paramEvsVoucherSelect.getUser_name() + "%");
      }
      if (!Util.isStrEmpty(paramEvsVoucherSelect.getSource_code()))
      {
        ((StringBuffer)localObject3).append(" AND e.source = ?");
        ((List)localObject4).add(paramEvsVoucherSelect.getSource_code().toString());
      }
      if (!Util.isStrEmpty(paramEvsVoucherSelect.getInvoiceType()))
      {
        ((StringBuffer)localObject3).append(" AND e.invoiceTypeCode = ?");
        ((List)localObject4).add(paramEvsVoucherSelect.getInvoiceType().toString());
      }
      if (!Util.isStrEmpty(paramEvsVoucherSelect.getVoucherStatus()))
      {
        ((StringBuffer)localObject3).append(" AND e.voucherStatus = ?");
        ((List)localObject4).add(paramEvsVoucherSelect.getVoucherStatus().toString());
      }
      if (!Util.isStrEmpty(paramEvsVoucherSelect.getVoucherMarker()))
      {
        ((StringBuffer)localObject3).append(" AND e.voucherMarker = ?");
        ((List)localObject4).add(paramEvsVoucherSelect.getVoucherMarker().toString());
      }
      if (!Util.isStrEmpty(paramEvsVoucherSelect.getBegin_created_date()))
      {
        ((StringBuffer)localObject3).append(" AND to_char(e.createdDate,'yyyy-mm-dd') >= ?");
        ((List)localObject4).add(paramEvsVoucherSelect.getBegin_created_date().toString());
      }
      if (!Util.isStrEmpty(paramEvsVoucherSelect.getEnd_created_date()))
      {
        ((StringBuffer)localObject3).append(" AND to_char(e.createdDate,'yyyy-mm-dd') <= ?");
        ((List)localObject4).add(paramEvsVoucherSelect.getEnd_created_date().toString());
      }
      if (!Util.isStrEmpty(paramEvsVoucherSelect.getJournalSubName()))
      {
        ((StringBuffer)localObject3).append(" AND ( e.journalSubName like ? ) ");
        ((List)localObject4).add("%" + paramEvsVoucherSelect.getJournalSubName().toUpperCase() + "%");
      }
      if (!Util.isStrEmpty(paramEvsVoucherSelect.getInvoiceNum()))
      {
        ((StringBuffer)localObject3).append(" AND e.invoiceNum like ? ");
        ((List)localObject4).add("%" + paramEvsVoucherSelect.getInvoiceNum().toUpperCase() + "%");
      }
      if (!Util.isStrEmpty(paramEvsVoucherSelect.getMatchModes()))
      {
        ((StringBuffer)localObject3).append(" AND e.matchMode = ? ");
        ((List)localObject4).add(paramEvsVoucherSelect.getMatchModes());
      }
      if (!Util.isStrEmpty(paramEvsVoucherSelect.getApprover()))
      {
        ((StringBuffer)localObject3).append(" AND e.approver like ?");
        ((List)localObject4).add("%" + paramEvsVoucherSelect.getApprover() + "%");
      }
      if (!Util.isStrEmpty(paramEvsVoucherSelect.getBegin_approver_date()))
      {
        ((StringBuffer)localObject3).append(" AND e.approverDate >= to_date(?,'yyyy-mm-dd')");
        ((List)localObject4).add(paramEvsVoucherSelect.getBegin_approver_date());
      }
      if (!Util.isStrEmpty(paramEvsVoucherSelect.getEnd_approver_date()))
      {
        ((StringBuffer)localObject3).append(" AND e.approverDate <= to_date(?,'yyyy-mm-dd')+1");
        ((List)localObject4).add(paramEvsVoucherSelect.getEnd_approver_date());
      }
      if ((localObject2 != null) && (!"10000".equals(((EasUserInfo)localObject2).getUserId())))
      {
        ((StringBuffer)localObject3).append(" AND exists (select 1 from FbpPseRelationsV f,FbpCompany c where f.companyId=c.companyId and c.companyCode=e.companyCode and f.employeeId=? and c.enabledFlag='Y' and f.posStructureCode='VOUCHER_QUERY')");
        ((List)localObject4).add(Long.valueOf(((EasUserInfo)localObject2).getUserInfoPk().longValue()));
      }
      ((StringBuffer)localObject3).append(" order by e.journalNum");
      PageInfo localPageInfo = super.PageInfoQuery(((StringBuffer)localObject3).toString(), paramInt1 / paramInt2 + 1, paramInt2, ((List)localObject4).toArray());
      localHashMap.put("data", localPageInfo.getResult());
      localHashMap.put("totalCount", Long.valueOf(localPageInfo.getTotalCount()));
    }
    return localHashMap;
  }
  
  public PageInfo findImageByVoucherId(Long paramLong, int paramInt1, int paramInt2)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append("from EvsImage e where voucherId=? and barcode is null order by e.voucherId,e.barcode desc,e.originImageId,e.imageId");
    localArrayList.add(paramLong);
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1, paramInt2, localArrayList.toArray());
    return localPageInfo;
  }
  
  public PageInfo findImage(Long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append("from EvsImage ei where (voucherId = ?)");
    localArrayList.add(paramLong);
    if ((StringUtils.isNotBlank(paramString)) && ("ALL".equals(paramString)))
    {
      if (StringUtils.isBlank(this.imageDisplayDAO.getRoleId())) {
        localStringBuffer.append(" and ( ei.isShowImage is null or ei.isShowImage = 'Y')");
      }
    }
    else {
      localStringBuffer.append(" and  barcode is null");
    }
    localStringBuffer.append("  order by ei.voucherId,ei.barcode desc,ei.originImageId,ei.imageId");
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1, paramInt2, localArrayList.toArray());
    return localPageInfo;
  }
  
  public Map<String, Object> getAllImageByVoucherId(Long paramLong1, Long paramLong2, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("DATA_COUNT", Integer.valueOf(0));
    localHashMap.put("DATA", new ArrayList());
    IImageCommonDAO localIImageCommonDAO = (IImageCommonDAO)SSBBus.findDomainService("imageCommonDAO");
    StringBuffer localStringBuffer1 = new StringBuffer();
    Object localObject = null;
    StringBuffer localStringBuffer2 = new StringBuffer();
    localStringBuffer2.append("select t.* from apps.EVS_VOUCHER_IMAGE_V t,apps.evs_book_voucher_v v where t.voucher_id = v.voucher_id and v.book_id = ?");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramLong2);
    localStringBuffer1.append("select count(1) from (").append(localStringBuffer2).append(")");
    List localList1 = localIImageCommonDAO.findObjectBySQL(localStringBuffer1.toString(), localArrayList, null);
    if ((localList1 != null) && (!localList1.isEmpty())) {
      localObject = localList1.get(0);
    }
    if ((localObject == null) || (Long.valueOf(localObject.toString()).longValue() < 1L)) {
      return localHashMap;
    }
    localStringBuffer2.append(" and t.voucher_id = ?").append(" order by v.journal_num,decode(t.image_barcode, null, '1', '2'),image_id");
    localArrayList.add(paramLong1);
    List localList2 = localIImageCommonDAO.findObjectBySQL(localStringBuffer2.toString(), localArrayList, EvsVoucherImageV.class);
    localHashMap.put("DATA_COUNT", localObject);
    localHashMap.put("DATA", localList2);
    return localHashMap;
  }
  
  public String findImageCurPage(Long paramLong1, Long paramLong2, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("select rn1");
    localStringBuffer.append("  from (select image_id, rownum rn1");
    localStringBuffer.append("          from (select i.image_id");
    localStringBuffer.append("                  from apps.evs_book_voucher_v b, evs.evs_image i");
    localStringBuffer.append("                 where b.voucher_id = i.voucher_id");
    localStringBuffer.append("                   and b.book_id = ?");
    localStringBuffer.append("                 order by b.journal_num, decode(i.barcode, null, '1', '2'),i.image_id))");
    localStringBuffer.append("  where image_id = ?");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramLong1);
    localArrayList.add(paramLong2);
    IImageCommonDAO localIImageCommonDAO = (IImageCommonDAO)SSBBus.findDomainService("imageCommonDAO");
    List localList = localIImageCommonDAO.findObjectBySQL(localStringBuffer.toString(), localArrayList, null);
    if ((localList != null) && (!localList.isEmpty()))
    {
      Object localObject = localList.get(0);
      return localObject == null ? "0" : localObject.toString();
    }
    return "0";
  }
  
  public PageInfo getAllImageByBookIdNew(Long paramLong, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer1 = new StringBuffer();
    localStringBuffer1.append("(select voucher_id");
    localStringBuffer1.append("  FROM (select t.*, rownum rn");
    localStringBuffer1.append("          FROM (select t.voucher_id");
    localStringBuffer1.append("                  from apps.Evs_Voucher_V           t,");
    localStringBuffer1.append("                       evs.Evs_Voucher_Book_Package p,");
    localStringBuffer1.append("                       fbp.Fbp_Company              c");
    localStringBuffer1.append("                 where t.company_Code = c.company_Code");
    localStringBuffer1.append("                   and t.voucher_Id = p.voucher_Id");
    localStringBuffer1.append("                   and p.book_Id = ?");
    localStringBuffer1.append("                 ORDER BY t.journal_num) t");
    localStringBuffer1.append("         where rownum <= ?)");
    localStringBuffer1.append(" where rn > ?) a");
    StringBuffer localStringBuffer2 = new StringBuffer("(select t.* from apps.Evs_Voucher_Image_V t,fbp.Fbp_Company c where t.company_Code = c.company_Code");
    localStringBuffer2.append(" order by case when t.origin_image_id is null then t.voucher_id else t.origin_image_id end) b");
    StringBuffer localStringBuffer3 = new StringBuffer("select b.* from ");
    localStringBuffer3.append(localStringBuffer1).append(",").append(localStringBuffer2);
    localStringBuffer3.append(" where a.voucher_id = b.voucher_id");
    int i = (paramInt1 - 1) * paramInt2;
    int j = paramInt1 * paramInt2;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramLong);
    localArrayList.add(Integer.valueOf(j));
    localArrayList.add(Integer.valueOf(i));
    IImageCommonDAO localIImageCommonDAO = (IImageCommonDAO)SSBBus.findDomainService("imageCommonDAO");
    List localList = null;
    localList = localIImageCommonDAO.findObjectBySQL(localStringBuffer3.toString(), localArrayList, EvsVoucherImageV.class);
    Integer localInteger = Integer.valueOf(localList.size());
    if ((localInteger == null) || (localInteger.intValue() == 0)) {
      return null;
    }
    PageInfo localPageInfo = new PageInfo(PageInfo.getStartOfPageInfo(paramInt1 / paramInt2 + 1, paramInt2), localInteger.intValue(), paramInt2, localList);
    return localPageInfo;
  }
  
  public PageInfo getAllImageByBookId(String paramString, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList1 = new ArrayList();
    IEvsPackageDAO localIEvsPackageDAO = (IEvsPackageDAO)SSBBus.findDomainService("packageDAO");
    List localList = localIEvsPackageDAO.getVoucherById(paramString);
    ArrayList localArrayList2 = new ArrayList(1);
    if ((localList == null) || (localList.isEmpty())) {
      return null;
    }
    IImageDisplayDAO localIImageDisplayDAO = (IImageDisplayDAO)SSBBus.findDomainService("imageDisplayDAO");
    StringBuffer localStringBuffer1 = new StringBuffer("from EvsVoucherImageV v where 1=1 ");
    StringBuffer localStringBuffer2 = new StringBuffer(" and (v.voucherId in (");
    for (int i = 0; i < localList.size(); i++)
    {
      localStringBuffer2.append("'" + localList.get(i) + "'" + ",");
      if ((i > 0) && (i % 999 == 0) && (i < localList.size() - 1))
      {
        localStringBuffer2 = new StringBuffer(localStringBuffer2.substring(0, localStringBuffer2.length() - 1));
        localStringBuffer2.append(") or v.voucherId in (");
      }
    }
    localStringBuffer2 = new StringBuffer(localStringBuffer2.substring(0, localStringBuffer2.length() - 1) + ")) ");
    localStringBuffer1.append(localStringBuffer2);
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    if (localRIAContext != null)
    {
      localObject = localIImageDisplayDAO.getRoleId();
      if ((localObject == null) || (((String)localObject).equals("")) || ((localObject != null) && (!((String)localObject).equals("100000")))) {
        localStringBuffer1.append(" and ( v.isShowImage is null or v.isShowImage = 'Y')");
      }
    }
    localStringBuffer1.append(" order by v.voucherId,v.barcode desc,v.originImageId,v.imageId");
    Object localObject = super.PageInfoQuery(localStringBuffer1.toString(), paramInt1 / paramInt2 + 1, paramInt2, localArrayList2.toArray());
    System.out.print("页码：" + paramInt1 + "值1：" + (paramInt1 / paramInt2 + 1) + "值2：" + paramInt2);
    return localObject;
  }
  
  public PageInfo getImageNuberList(Long paramLong, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList();
    localStringBuffer.append("select ei.*  from eid_image_infos ei, (select distinct barcode, image_info_id \tfrom evs_image where 1=1 and barcode is not null and voucher_id = ?) v where ei.image_info_id = v.image_Info_id");
    localArrayList.add(paramLong);
    IImageCommonDAO localIImageCommonDAO = (IImageCommonDAO)SSBBus.findDomainService("imageCommonDAO");
    PageInfo localPageInfo = localIImageCommonDAO.pageInfoObjectBySql(localStringBuffer.toString(), localArrayList, EidImageInfos.class, paramInt1 / paramInt2 + 1, paramInt2);
    return localPageInfo;
  }
  
  public IImageDisplayDAO getImageDisplayDAO()
  {
    return this.imageDisplayDAO;
  }
  
  public void setImageDisplayDAO(IImageDisplayDAO paramIImageDisplayDAO)
  {
    this.imageDisplayDAO = paramIImageDisplayDAO;
  }
  
  public List<EvsVoucherV> getAllInfoPrint(EvsVoucherSelect paramEvsVoucherSelect)
  {
    List localList = null;
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    boolean bool = "Y".equals(paramEvsVoucherSelect.getIsLikeQuery());
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList1 = new ArrayList(1);
    localStringBuffer.append("from EvsVoucherV e where 1=1 ");
    ArrayList localArrayList2 = new ArrayList();
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getBarcode())) {
      if (bool)
      {
        localStringBuffer.append(" and exists(select 1 from EvsImage i where e.voucherId=i.voucherId and i.barcode like ?)");
        localArrayList1.add("%" + paramEvsVoucherSelect.getBarcode() + "%");
      }
      else
      {
        localStringBuffer.append(" and exists(select 1 from EvsImage i where e.voucherId=i.voucherId and i.barcode like ?)");
        localArrayList1.add(paramEvsVoucherSelect.getBarcode());
      }
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getBeginID()))
    {
      localStringBuffer.append(" AND e.journalNum >= ?");
      localArrayList1.add(paramEvsVoucherSelect.getBeginID().toUpperCase());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getEndID()))
    {
      localStringBuffer.append(" AND e.journalNum <= ?");
      localArrayList1.add(paramEvsVoucherSelect.getEndID().toUpperCase());
    }
    if (StringUtils.isNotBlank(paramEvsVoucherSelect.getBoeNum()))
    {
      localStringBuffer.append(" AND e.boeNum like ?");
      localArrayList1.add(("%" + paramEvsVoucherSelect.getBoeNum() + "%").toUpperCase());
    }
    if (StringUtils.isNotBlank(paramEvsVoucherSelect.getCompanyCode()))
    {
      localStringBuffer.append(" AND e.companyCode = ?");
      localArrayList1.add(paramEvsVoucherSelect.getCompanyCode());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getUser_name()))
    {
      localStringBuffer.append(" AND e.userName like ? ");
      localArrayList1.add("%" + paramEvsVoucherSelect.getUser_name() + "%");
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getInvoiceType()))
    {
      localStringBuffer.append(" AND e.invoiceType = ?");
      localArrayList1.add(paramEvsVoucherSelect.getInvoiceType().toString());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getVoucherStatus()))
    {
      localStringBuffer.append(" AND e.voucherStatus = ?");
      localArrayList1.add(paramEvsVoucherSelect.getVoucherStatus().toString());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getVoucherMarker()))
    {
      localStringBuffer.append(" AND e.voucherMarker = ?");
      localArrayList1.add(paramEvsVoucherSelect.getVoucherMarker().toString());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getBegin_created_date()))
    {
      localStringBuffer.append(" AND to_char(e.createdDate,'yyyy-mm-dd') >= ?");
      localArrayList1.add(paramEvsVoucherSelect.getBegin_created_date().toString());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getEnd_created_date()))
    {
      localStringBuffer.append(" AND to_char(e.createdDate,'yyyy-mm-dd') <= ?");
      localArrayList1.add(paramEvsVoucherSelect.getEnd_created_date().toString());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getMatchModes()))
    {
      localStringBuffer.append(" AND e.matchMode = ? ");
      localArrayList1.add(paramEvsVoucherSelect.getMatchModes());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getApprover()))
    {
      localStringBuffer.append(" AND e.approver like ?");
      localArrayList1.add("%" + paramEvsVoucherSelect.getApprover() + "%");
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getBegin_approver_date()))
    {
      localStringBuffer.append(" AND e.approverDate >= to_date(?,'yyyy-mm-dd')");
      localArrayList1.add(paramEvsVoucherSelect.getBegin_approver_date());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getEnd_approver_date()))
    {
      localStringBuffer.append(" AND e.approverDate <= to_date(?,'yyyy-mm-dd')+1");
      localArrayList1.add(paramEvsVoucherSelect.getEnd_approver_date());
    }
    if ((localEasUserInfo != null) && (!"10000".equals(localEasUserInfo.getUserId())))
    {
      localStringBuffer.append(" AND exists (select 1 from FbpPseRelationsV f,FbpCompany c where f.companyId=c.companyId and c.companyCode=e.companyCode and f.employeeId=? and c.enabledFlag='Y' and f.posStructureCode='VOUCHER_QUERY')");
      localArrayList1.add(Long.valueOf(localEasUserInfo.getUserInfoPk().longValue()));
    }
    localStringBuffer.append(" order by e.journalNum");
    localList = super.getZormTemplate().find(localStringBuffer.toString(), localArrayList1.toArray());
    return localList;
  }
  
  public Map findByTaskNumOrImageNum(List<EvsVoucherV> paramList, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    StringBuffer localStringBuffer = new StringBuffer();
    String str = null;
    EvsVoucherV localEvsVoucherV = (EvsVoucherV)paramList.get(0);
    int i;
    if ((!StringUtils.isEmpty(localEvsVoucherV.getImageNumber())) && (StringUtils.isEmpty(localEvsVoucherV.getTaskNum())))
    {
      localStringBuffer.append("select * From Evs_Voucher_V t  where t.image_number in (#image_number#)");
      localObject1 = new StringBuffer();
      localStringBuffer.append("order by  case");
      for (i = 0; i < paramList.size(); i++)
      {
        localObject2 = (EvsVoucherV)paramList.get(i);
        if (i == paramList.size() - 1) {
          ((StringBuffer)localObject1).append("'").append(((EvsVoucherV)localObject2).getImageNumber()).append("'");
        } else {
          ((StringBuffer)localObject1).append("'").append(((EvsVoucherV)localObject2).getImageNumber()).append("'").append(",");
        }
        localStringBuffer.append("  when image_number = ? then ?");
        localArrayList.add(((EvsVoucherV)localObject2).getImageNumber());
        localArrayList.add(Integer.valueOf(i));
      }
      localStringBuffer.append(" end");
      str = localStringBuffer.toString().replace("#image_number#", ((StringBuffer)localObject1).toString());
    }
    if ((StringUtils.isEmpty(localEvsVoucherV.getImageNumber())) && (!StringUtils.isEmpty(localEvsVoucherV.getTaskNum())))
    {
      localStringBuffer.append("select * From Evs_Voucher_V t  where t.task_Num in (#task_Num#)");
      localObject1 = new StringBuffer();
      localStringBuffer.append("order by  case");
      for (i = 0; i < paramList.size(); i++)
      {
        localObject2 = (EvsVoucherV)paramList.get(i);
        if (i == paramList.size() - 1) {
          ((StringBuffer)localObject1).append("'").append(((EvsVoucherV)localObject2).getTaskNum()).append("'");
        } else {
          ((StringBuffer)localObject1).append("'").append(((EvsVoucherV)localObject2).getTaskNum()).append("'").append(",");
        }
        localStringBuffer.append("  when task_Num = ? then ?");
        localArrayList.add(((EvsVoucherV)localObject2).getTaskNum());
        localArrayList.add(Integer.valueOf(i));
      }
      localStringBuffer.append(" end");
      str = localStringBuffer.toString().replace("#task_Num#", ((StringBuffer)localObject1).toString());
    }
    Object localObject1 = (IImageCommonDAO)SSBBus.findDomainService("imageCommonDAO");
    PageInfo localPageInfo = ((IImageCommonDAO)localObject1).pageInfoObjectBySql(str, localArrayList, EvsVoucherV.class, paramInt1 / paramInt2 + 1, paramInt2);
    Object localObject2 = new HashMap();
    ((Map)localObject2).put("data", localPageInfo.getResult());
    ((Map)localObject2).put("totalCount", Long.valueOf(localPageInfo.getTotalCount()));
    return localObject2;
  }
  
  public Map findVoucherForFascicule(EvsVoucherSelect paramEvsVoucherSelect, int paramInt1, int paramInt2)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList1 = new ArrayList(1);
    localStringBuffer.append("from EvsVoucherV e where 1=1");
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    if (paramEvsVoucherSelect.getIsLikeQuery() != null) {
      i = "Y".equals(paramEvsVoucherSelect.getIsLikeQuery().trim()) ? 1 : 0;
    }
    if (((!Util.isStrEmpty(paramEvsVoucherSelect.getBeginID().toUpperCase())) || (!Util.isStrEmpty(paramEvsVoucherSelect.getBeginID().toLowerCase()))) && (i == 0))
    {
      localStringBuffer.append(" AND e.journalNum >= ?");
      localArrayList1.add(paramEvsVoucherSelect.getBeginID().trim());
    }
    else
    {
      localStringBuffer.append(" AND e.journalNum like ?");
      localArrayList1.add("%" + paramEvsVoucherSelect.getBeginID().trim() + "%");
    }
    if (((!Util.isStrEmpty(paramEvsVoucherSelect.getEndID().toUpperCase())) || (!Util.isStrEmpty(paramEvsVoucherSelect.getEndID().toLowerCase()))) && (i == 0))
    {
      localStringBuffer.append(" AND e.journalNum <= ?");
      localArrayList1.add(paramEvsVoucherSelect.getEndID().trim());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getSet_book_name()))
    {
      localStringBuffer.append(" AND e.setBookName = ?");
      localArrayList1.add(paramEvsVoucherSelect.getSet_book_name().toString());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getOu_id()))
    {
      localStringBuffer.append(" AND e.ouName = ?");
      localArrayList1.add(paramEvsVoucherSelect.getOu_id());
    }
    if (StringUtils.isNotBlank(paramEvsVoucherSelect.getBoeNum()))
    {
      localStringBuffer.append(" AND e.boeNum like ?");
      localArrayList1.add(("%" + paramEvsVoucherSelect.getBoeNum() + "%").toUpperCase());
    }
    if (StringUtils.isNotBlank(paramEvsVoucherSelect.getCompanyCode()))
    {
      localStringBuffer.append(" AND e.companyCode = ?");
      localArrayList1.add(paramEvsVoucherSelect.getCompanyCode());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getPeriod_name()))
    {
      localStringBuffer.append(" AND e.periodName = ?");
      localArrayList1.add(paramEvsVoucherSelect.getPeriod_name().toString());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getUser_name()))
    {
      localStringBuffer.append(" AND e.userName like ? ");
      localArrayList1.add("%" + paramEvsVoucherSelect.getUser_name() + "%");
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getSource_code()))
    {
      localStringBuffer.append(" AND e.source = ?");
      localArrayList1.add(paramEvsVoucherSelect.getSource_code().toString());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getInvoiceType()))
    {
      localStringBuffer.append(" AND e.invoiceTypeCode = ?");
      localArrayList1.add(paramEvsVoucherSelect.getInvoiceType());
    }
    System.out.println("赵建奕调试:" + paramEvsVoucherSelect.getVoucherStatus());
    if ((paramEvsVoucherSelect.getVoucherStatus() != null) && (!paramEvsVoucherSelect.getVoucherStatus().equals("")))
    {
      localStringBuffer.append(" AND e.voucherStatus = ?");
      localArrayList1.add(paramEvsVoucherSelect.getVoucherStatus());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getBegin_created_date()))
    {
      localStringBuffer.append(" AND to_char(e.createdDate,'yyyy-mm-dd') >= ?");
      localArrayList1.add(paramEvsVoucherSelect.getBegin_created_date().toString());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getEnd_created_date()))
    {
      localStringBuffer.append(" AND to_char(e.createdDate,'yyyy-mm-dd') <= ?");
      localArrayList1.add(paramEvsVoucherSelect.getEnd_created_date().toString());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getJournalSubName()))
    {
      localStringBuffer.append(" AND ( e.journalSubName like ? ) ");
      localArrayList1.add("%" + paramEvsVoucherSelect.getJournalSubName().toUpperCase() + "%");
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getInvoiceNum()))
    {
      localStringBuffer.append(" AND e.invoiceNum like ? ");
      localArrayList1.add("%" + paramEvsVoucherSelect.getInvoiceNum().toUpperCase() + "%");
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getMatchModes()))
    {
      localStringBuffer.append(" AND e.matchMode = ? ");
      localArrayList1.add(paramEvsVoucherSelect.getMatchModes());
    }
    if ((localEasUserInfo != null) && (!"10000".equals(localEasUserInfo.getUserId())))
    {
      localStringBuffer.append(" and exists(select 1 from FbpPseRelationsV fpr where fpr.companyId= e.companyId and fpr.posStructureCode = ? and fpr.employeeId = ?)");
      localArrayList1.add("VOUCHER_QUERY");
      localArrayList1.add(Long.valueOf(localEasUserInfo.getUserInfoPk().longValue()));
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getApprover()))
    {
      localStringBuffer.append(" AND e.approver like ?");
      localArrayList1.add("%" + paramEvsVoucherSelect.getApprover() + "%");
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getBegin_approver_date()))
    {
      localStringBuffer.append(" AND e.approverDate >= to_date(?,'yyyy-mm-dd')");
      localArrayList1.add(paramEvsVoucherSelect.getBegin_approver_date());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getEnd_approver_date()))
    {
      localStringBuffer.append(" AND e.approverDate <= to_date(?,'yyyy-mm-dd')+1");
      localArrayList1.add(paramEvsVoucherSelect.getEnd_approver_date());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getCompanyId())) {
      localStringBuffer.append("AND e.companyId = " + paramEvsVoucherSelect.getCompanyId());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getAddVoucherFlag())) {
      localStringBuffer.append("AND e.addVoucherFlag = 'Y' ");
    } else {
      localStringBuffer.append("AND (e.addVoucherFlag != 'Y' or e.addVoucherFlag is null)");
    }
    if (paramEvsVoucherSelect.getMaxNum() != null) {
      localStringBuffer.append("  and rownum<=" + paramEvsVoucherSelect.getMaxNum());
    }
    localStringBuffer.append(" AND e.voucherStatus not in('UNMATCH','WAREHOUSE','NOW_FLITTING','BORROWING')");
    localStringBuffer.append(" order by e.invoiceTypeCode, e.journalNum");
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1 / paramInt2 + 1, paramInt2, localArrayList1.toArray());
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", localPageInfo.getResult());
    localHashMap.put("totalCount", Long.valueOf(localPageInfo.getTotalCount()));
    return localHashMap;
  }
  
  public void updateVoucherFlag(long paramLong, String paramString)
  {
    String str = "";
    str = "from EvsVoucher e where 1=1 and e.voucherId=" + paramLong;
    List localList = getZormTemplate().find(str);
    EvsVoucher localEvsVoucher = null;
    if (localList.size() > 0)
    {
      localEvsVoucher = (EvsVoucher)localList.get(0);
      if (paramString.equals("Y")) {
        localEvsVoucher.setAddVoucherFlag("N");
      } else {
        localEvsVoucher.setAddVoucherFlag("Y");
      }
    }
    if (localEvsVoucher != null) {
      updateObject(localEvsVoucher);
    }
  }
  
  public EvsVoucherV queryEvsVoucherList(long paramLong)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append("from EvsVoucherV e where 1=1 ");
    localStringBuffer.append(" and  e.voucherId=" + paramLong);
    List localList = getZormTemplate().find(localStringBuffer.toString());
    return (EvsVoucherV)localList.get(0);
  }
  
  public List<EvsVoucherV> findVoucherForFasciculeByList(EvsVoucherSelect paramEvsVoucherSelect)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList1 = new ArrayList(1);
    localStringBuffer.append("from EvsVoucherV e where 1=1");
    ArrayList localArrayList2 = new ArrayList();
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getBeginID()))
    {
      localStringBuffer.append(" AND e.journalNum >= ?");
      localArrayList1.add(paramEvsVoucherSelect.getBeginID().toUpperCase());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getEndID()))
    {
      localStringBuffer.append(" AND e.journalNum <= ?");
      localArrayList1.add(paramEvsVoucherSelect.getEndID().toUpperCase());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getSet_book_name()))
    {
      localStringBuffer.append(" AND e.setBookName = ?");
      localArrayList1.add(paramEvsVoucherSelect.getSet_book_name().toString());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getOu_id()))
    {
      localStringBuffer.append(" AND e.ouName = ?");
      localArrayList1.add(paramEvsVoucherSelect.getOu_id());
    }
    if (StringUtils.isNotBlank(paramEvsVoucherSelect.getBoeNum()))
    {
      localStringBuffer.append(" AND e.boeNum like ?");
      localArrayList1.add(("%" + paramEvsVoucherSelect.getBoeNum() + "%").toUpperCase());
    }
    if (StringUtils.isNotBlank(paramEvsVoucherSelect.getCompanyCode()))
    {
      localStringBuffer.append(" AND e.companyCode = ?");
      localArrayList1.add(paramEvsVoucherSelect.getCompanyCode());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getPeriod_name()))
    {
      localStringBuffer.append(" AND e.periodName = ?");
      localArrayList1.add(paramEvsVoucherSelect.getPeriod_name().toString());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getUser_name()))
    {
      localStringBuffer.append(" AND e.userName like ? ");
      localArrayList1.add("%" + paramEvsVoucherSelect.getUser_name() + "%");
    }
    if (paramEvsVoucherSelect.getUserId() != null)
    {
      localStringBuffer.append(" AND e.userId = ? ");
      localArrayList1.add(paramEvsVoucherSelect.getUserId());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getSource_code()))
    {
      localStringBuffer.append(" AND e.source = ?");
      localArrayList1.add(paramEvsVoucherSelect.getSource_code().toString());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getInvoiceType()))
    {
      localStringBuffer.append(" AND e.invoiceTypeCode = ?");
      localArrayList1.add(paramEvsVoucherSelect.getInvoiceType());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getVoucherStatus()))
    {
      localStringBuffer.append(" AND e.voucherStatus = ?");
      localArrayList1.add(paramEvsVoucherSelect.getVoucherStatus().toString());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getBegin_created_date()))
    {
      localStringBuffer.append(" AND to_char(e.createdDate,'yyyy-mm-dd') >= ?");
      localArrayList1.add(paramEvsVoucherSelect.getBegin_created_date().toString());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getEnd_created_date()))
    {
      localStringBuffer.append(" AND to_char(e.createdDate,'yyyy-mm-dd') <= ?");
      localArrayList1.add(paramEvsVoucherSelect.getEnd_created_date().toString());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getJournalSubName()))
    {
      localStringBuffer.append(" AND ( e.journalSubName like ? ) ");
      localArrayList1.add("%" + paramEvsVoucherSelect.getJournalSubName().toUpperCase() + "%");
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getInvoiceNum()))
    {
      localStringBuffer.append(" AND e.invoiceNum like ? ");
      localArrayList1.add("%" + paramEvsVoucherSelect.getInvoiceNum().toUpperCase() + "%");
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getMatchModes()))
    {
      localStringBuffer.append(" AND e.matchMode = ? ");
      localArrayList1.add(paramEvsVoucherSelect.getMatchModes());
    }
    if ((localEasUserInfo != null) && (!"10000".equals(localEasUserInfo.getUserId())))
    {
      localStringBuffer.append(" and exists(select 1 from FbpPseRelationsV fpr where fpr.companyId= e.companyId and fpr.posStructureCode = ? and fpr.employeeId = ?)");
      localArrayList1.add("VOUCHER_QUERY");
      localArrayList1.add(Long.valueOf(localEasUserInfo.getUserInfoPk().longValue()));
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getApprover()))
    {
      localStringBuffer.append(" AND e.approver like ?");
      localArrayList1.add("%" + paramEvsVoucherSelect.getApprover() + "%");
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getBegin_approver_date()))
    {
      localStringBuffer.append(" AND e.approverDate >= to_date(?,'yyyy-mm-dd')");
      localArrayList1.add(paramEvsVoucherSelect.getBegin_approver_date());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getEnd_approver_date()))
    {
      localStringBuffer.append(" AND e.approverDate <= to_date(?,'yyyy-mm-dd')+1");
      localArrayList1.add(paramEvsVoucherSelect.getEnd_approver_date());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getCompanyId())) {
      localStringBuffer.append("AND e.companyId = " + paramEvsVoucherSelect.getCompanyId());
    }
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getAddVoucherFlag())) {
      localStringBuffer.append("AND e.addVoucherFlag = 'Y' ");
    }
    if (paramEvsVoucherSelect.getMaxNum() != null) {
      localStringBuffer.append("  and rownum<=" + paramEvsVoucherSelect.getMaxNum());
    }
    localStringBuffer.append(" AND e.voucherStatus not in('UNMATCH','WAREHOUSE','NOW_FLITTING','BORROWING')");
    localStringBuffer.append(" order by e.invoiceTypeCode, e.journalNum");
    return getZormTemplate().find(localStringBuffer.toString(), localArrayList1.toArray());
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.eBillManage.EvsVoucherGenerateDAO
 * JD-Core Version:    0.7.0.1
 */