package com.zte.evs.ebill.access.eBillManage;

import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.eas.resconfig.business.lookup.model.FbpLookupValuesV;
import com.zte.eimage.access.baseconfig.dao.IImageCommonDAO;
import com.zte.eimage.business.baseconfig.util.EidObjectUtils;
import com.zte.evs.ebill.common.EvsObjectUtils;
import com.zte.evs.ebill.model.eBillManage.EvsBook;
import com.zte.evs.ebill.model.eBillManage.EvsBookModel;
import com.zte.evs.ebill.model.eBillManage.EvsBookVoucherDetailV;
import com.zte.evs.ebill.model.eBillManage.EvsCity;
import com.zte.evs.ebill.model.eBillManage.EvsManageOrgV;
import com.zte.evs.ebill.model.eBillManage.EvsStorageDoc;
import com.zte.evs.ebill.model.eBillManage.EvsVoucher;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherBookPackage;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherLineV;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherQueryV;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherSearchV;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherV;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherVo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.util.Util;
import com.zte.ssb.orm.zorm.ZormTemplate;
import com.zte.ssb.util.Assert;
import com.zte.ssb.zorm.Query;
import com.zte.ssb.zorm.SQLQuery;
import com.zte.ssb.zorm.Session;
import com.zte.ssb.zorm.engine.SessionFactoryImplementor;
import com.zte.ssb.zorm.hql.ast.QueryTranslatorImpl;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.axis.utils.StringUtils;
import org.apache.log4j.Logger;

public class EvsVoucherDAO
  extends BaseDAO
  implements IEvsVoucherDAO
{
  private EidObjectUtils objectUtils;
  private IEvsDocAccessStorageDAO docAccessStorageDAO;
  Logger logger = Logger.getLogger(EvsVoucherDAO.class);
  
  public List<EvsVoucherV> getBoeInfo(String paramString1, String paramString2)
  {
    String str1 = "FROM EvsVoucherV e where 1=1";
    if (!Util.isStrEmpty(paramString1))
    {
      localObject = paramString1.split(",");
      str1 = str1 + " and  e.boeNum in (";
      if (localObject.length > 0) {
        for (int i = 0; i < localObject.length; i++)
        {
          String str2 = localObject[i];
          if (i == 0) {
            str1 = str1 + "'" + str2 + "'";
          } else {
            str1 = str1 + ",'" + str2 + "'";
          }
        }
      }
      str1 = str1 + ")";
    }
    if ((paramString2 != null) && (!"".equals(paramString2))) {
      str1 = str1 + " and e.periodName='" + paramString2 + "'";
    }
    Object localObject = getZormTemplate().find(str1);
    return localObject;
  }
  
  public List<EvsVoucherV> getApVouchers(String paramString)
  {
    String str1 = "FROM EvsVoucherV e ";
    if (!Util.isStrEmpty(paramString))
    {
      localObject = paramString.split(",");
      if (localObject.length > 0)
      {
        str1 = str1 + " where 1=1 and  e.boeNum in (";
        for (int i = 0; i < localObject.length; i++)
        {
          String str2 = localObject[i];
          if (i == 0) {
            str1 = str1 + "'" + str2 + "'";
          } else {
            str1 = str1 + ",'" + str2 + "'";
          }
        }
        str1 = str1 + ") ";
      }
      else
      {
        str1 = str1 + "where 1=2";
      }
    }
    else
    {
      str1 = str1 + "where 1=2";
    }
    str1 = str1 + " and e.subDocName='应付凭证'";
    Object localObject = getZormTemplate().find(str1);
    return localObject;
  }
  
  public List<EvsVoucherV> getPaymentVouchers(String paramString)
  {
    String str1 = "FROM EvsVoucherV e ";
    if (!Util.isStrEmpty(paramString))
    {
      localObject1 = paramString.split(",");
      if (localObject1.length > 0)
      {
        int i = 0;
        str1 = str1 + " where 1=1 and (";
        for (String str2 : localObject1) {
          if (i == 0)
          {
            str1 = str1 + "  e.apJournalNum like '%" + str2 + "%'";
            i++;
          }
          else
          {
            str1 = str1 + " or e.apJournalNum like '%" + str2 + "%'";
          }
        }
        str1 = str1 + " )";
      }
      else
      {
        str1 = str1 + "  where 1=2 ";
      }
    }
    else
    {
      str1 = str1 + " where 1=2";
    }
    str1 = str1 + " and e.subDocName='付款凭证'";
    Object localObject1 = getZormTemplate().find(str1);
    return localObject1;
  }
  
  public EvsVoucherV findEvsVoucherVByJournalNum(String paramString)
  {
    String str = "FROM EvsVoucherV e where 1=1";
    if ((paramString != null) && (!"".equals(paramString))) {
      str = str + " and e.journalNum = '" + paramString + "'";
    }
    List localList = getZormTemplate().find(str);
    if (localList.size() > 0)
    {
      if (localList.size() == 1) {
        return (EvsVoucherV)localList.get(0);
      }
      return (EvsVoucherV)localList.get(1);
    }
    return null;
  }
  
  public List<EvsVoucherV> findEvsVoucherVByJournalNum(Long paramLong)
  {
    String str = "select ee.* From evs.evs_voucher_book_package e,apps.evs_voucher_V ee where e.book_id= " + paramLong + " and e.voucher_id=ee.voucher_id order by ee.invoice_Type_code,ee.journal_num";
    List localList = getSession().createSQLQuery(str.toString()).addEntity(EvsVoucherV.class).list();
    return localList;
  }
  
  public EvsVoucher findEvsVoucherVByVoucherId(Long paramLong)
  {
    String str = "FROM EvsVoucher e where 1=1";
    if ((paramLong != null) && (!"".equals(paramLong))) {
      str = str + " and e.voucherId =" + paramLong;
    }
    List localList = getZormTemplate().find(str);
    if (localList.size() > 0) {
      return (EvsVoucher)localList.get(0);
    }
    return null;
  }
  
  public List<EvsVoucher> findEvsVoucherVByBookId(Long paramLong)
  {
    String str = "FROM EvsVoucher e where 1=1";
    if ((paramLong != null) && (!"".equals(paramLong)))
    {
      str = str + " AND exists (select evb.beginNum, evb.endNum from EvsVoucherBookPackage evb where evb.bookId = " + paramLong;
      str = str + " and e.journalNum>=evb.beginNum and e.journalNum<=evb.endNum)";
    }
    List localList = getSession().createQuery(str).list();
    return localList;
  }
  
  public Map findVoucherQueryV(EvsVoucherVo paramEvsVoucherVo, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer1 = new StringBuffer();
    ArrayList localArrayList1 = new ArrayList(18);
    boolean bool = "Y".equals(paramEvsVoucherVo.getIsLikeQuery());
    localStringBuffer1.append("FROM EvsVoucherQueryV t WHERE 1=1");
    if (!Util.isStrEmpty(paramEvsVoucherVo.getBeginID()))
    {
      localStringBuffer1.append(" AND t.journalNum >= ?");
      localArrayList1.add(paramEvsVoucherVo.getBeginID().toUpperCase());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getEndID()))
    {
      localStringBuffer1.append(" AND t.journalNum <= ?");
      localArrayList1.add(paramEvsVoucherVo.getEndID().toUpperCase());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getBeginBook()))
    {
      localStringBuffer1.append(" AND t.bookCode >= ?");
      localArrayList1.add(paramEvsVoucherVo.getBeginBook());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getEndBook()))
    {
      localStringBuffer1.append(" AND t.bookCode <= ?");
      localArrayList1.add(paramEvsVoucherVo.getEndBook());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getCompanyCode()))
    {
      localStringBuffer1.append(" AND t.companyCode = ?");
      localArrayList1.add(paramEvsVoucherVo.getCompanyCode());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getMatchMode()))
    {
      localStringBuffer1.append(" AND t.matchMode = ?");
      localArrayList1.add(paramEvsVoucherVo.getMatchMode());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getPeriod_name()))
    {
      localStringBuffer1.append(" AND t.periodName = ?");
      localArrayList1.add(paramEvsVoucherVo.getPeriod_name());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getUser_name()))
    {
      localStringBuffer1.append(" AND t.userName = ?");
      localArrayList1.add(paramEvsVoucherVo.getUser_name());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getStatus()))
    {
      localStringBuffer1.append(" AND t.voucherStatus = ?");
      localArrayList1.add(paramEvsVoucherVo.getStatus());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getApprover()))
    {
      localStringBuffer1.append(" AND t.approver = ?");
      localArrayList1.add(paramEvsVoucherVo.getApprover());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getBookStatus()))
    {
      localStringBuffer1.append(" AND t.voucherStatus = ?");
      localArrayList1.add(paramEvsVoucherVo.getBookStatus());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getBoxStatus()))
    {
      localStringBuffer1.append(" AND t.voucherStatus = ?");
      localArrayList1.add(paramEvsVoucherVo.getBoxStatus());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getBegin_created_date()))
    {
      localStringBuffer1.append(" AND to_char(t.createdDate, 'yyyy-mm-dd') >= ?");
      localArrayList1.add(paramEvsVoucherVo.getBegin_created_date());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getEnd_created_date()))
    {
      localStringBuffer1.append(" AND to_char(t.createdDate, 'yyyy-mm-dd') <= ?");
      localArrayList1.add(paramEvsVoucherVo.getEnd_created_date());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getBegin_approver_date()))
    {
      localStringBuffer1.append(" AND to_char(t.approverDate, 'yyyy-mm-dd')  >= ?");
      localArrayList1.add(paramEvsVoucherVo.getBegin_approver_date());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getEnd_approver_date()))
    {
      localStringBuffer1.append(" AND to_char(t.approverDate, 'yyyy-mm-dd')  <= ?");
      localArrayList1.add(paramEvsVoucherVo.getEnd_approver_date());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getBarcode())) {
      if (bool)
      {
        localStringBuffer1.append(" AND t.voucherId in(select voucherId from EvsImage e where e.imageInfoId in(select ii.imageInfoId from EidImageInfos ii where ii.taskNum like ?))");
        localArrayList1.add("%" + paramEvsVoucherVo.getBarcode() + "%");
      }
      else
      {
        localStringBuffer1.append(" AND t.voucherId in(select voucherId from EvsImage e where e.imageInfoId in(select ii.imageInfoId from EidImageInfos ii where ii.taskNum = ?))");
        localArrayList1.add(paramEvsVoucherVo.getBarcode());
      }
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getVoucherMarker()))
    {
      localStringBuffer1.append(" AND t.voucherMarker = ?");
      localArrayList1.add(paramEvsVoucherVo.getVoucherMarker());
    }
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    String str = "";
    if (null == localEasUserInfo) {
      str = paramEvsVoucherVo.getUserInfoPk();
    } else {
      str = localEasUserInfo.getUserInfoPk().toString();
    }
    if (!Util.isStrEmpty(str))
    {
      if (!"10000".equals(localEasUserInfo.getUserId())) {
        localStringBuffer1.append(" and exists(from FbpPseRelationsV f where f.companyId=t.companyId and f.employeeId = " + str + ")");
      }
    }
    else {
      localStringBuffer1.append(" and exists(from FbpPseRelationsV f where f.companyId=t.companyId and f.employeeId = '000' )");
    }
    localStringBuffer1.append(" ORDER BY t.invoiceTypeCode,t.journalNum");
    PageInfo localPageInfo = PageInfoQueryForArray(localStringBuffer1.toString(), paramInt1 / paramInt2 + 1, paramInt2, localArrayList1.toArray());
    List localList = (List)localPageInfo.getResult();
    ArrayList localArrayList2 = new ArrayList();
    int i = localList.size();
    for (int j = 0; j < i; j++)
    {
      StringBuffer localStringBuffer2 = new StringBuffer();
      EvsVoucherQueryV localEvsVoucherQueryV = (EvsVoucherQueryV)localList.get(j);
      Object localObject;
      if (!Util.isNullObject(localEvsVoucherQueryV.getInvCityId()))
      {
        localObject = this.docAccessStorageDAO.findCityNameByCityId(Long.valueOf(StringUtils.isEmpty(localEvsVoucherQueryV.getInvCityId()) ? 0L : Long.valueOf(localEvsVoucherQueryV.getInvCityId()).longValue()));
        localStringBuffer2.append(((EvsCity)localObject).getCityName());
      }
      if (!Util.isStrEmpty(localEvsVoucherQueryV.getInvStorageCode()))
      {
        localStringBuffer2.append("-");
        localObject = this.docAccessStorageDAO.findStorageDocNameByStoCode(localEvsVoucherQueryV.getInvStorageCode());
        localStringBuffer2.append(((EvsStorageDoc)localObject).getStorageName());
      }
      if (!Util.isStrEmpty(localEvsVoucherQueryV.getInvArea()))
      {
        localStringBuffer2.append("-");
        localObject = this.docAccessStorageDAO.findFbpLookupValues(localEvsVoucherQueryV.getInvArea());
        localStringBuffer2.append(((FbpLookupValuesV)localObject).getMeaning());
      }
      if (!Util.isStrEmpty(localEvsVoucherQueryV.getInvRow()))
      {
        localStringBuffer2.append("-");
        localObject = this.docAccessStorageDAO.findFbpLookupValues(localEvsVoucherQueryV.getInvRow());
        localStringBuffer2.append(((FbpLookupValuesV)localObject).getMeaning());
      }
      if (!Util.isStrEmpty(localEvsVoucherQueryV.getInvColumn()))
      {
        localStringBuffer2.append("-");
        localObject = this.docAccessStorageDAO.findFbpLookupValues(localEvsVoucherQueryV.getInvColumn());
        localStringBuffer2.append(((FbpLookupValuesV)localObject).getMeaning());
      }
      if (!Util.isStrEmpty(localEvsVoucherQueryV.getInvLevel()))
      {
        localStringBuffer2.append("-");
        localObject = this.docAccessStorageDAO.findFbpLookupValues(localEvsVoucherQueryV.getInvLevel());
        localStringBuffer2.append(((FbpLookupValuesV)localObject).getMeaning());
      }
      localEvsVoucherQueryV.setStoreAddress(localStringBuffer2.toString());
      localArrayList2.add(localEvsVoucherQueryV);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", localArrayList2);
    localHashMap.put("totalCount", Long.valueOf(localPageInfo.getTotalCount()));
    return localHashMap;
  }
  
  public Map findVoucherByQry(EvsVoucherVo paramEvsVoucherVo, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer1 = new StringBuffer();
    ArrayList localArrayList1 = new ArrayList(18);
    boolean bool = "Y".equals(paramEvsVoucherVo.getIsLikeQuery());
    localStringBuffer1.append("FROM EvsVoucherSearchV t WHERE 1=1");
    if (!Util.isStrEmpty(paramEvsVoucherVo.getBeginID()))
    {
      localStringBuffer1.append(" AND t.journalNum >= ?");
      localArrayList1.add(paramEvsVoucherVo.getBeginID().toUpperCase());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getEndID()))
    {
      localStringBuffer1.append(" AND t.journalNum <= ?");
      localArrayList1.add(paramEvsVoucherVo.getEndID().toUpperCase());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getBeginBook()))
    {
      localStringBuffer1.append(" AND t.bookCode >= ?");
      localArrayList1.add(paramEvsVoucherVo.getBeginBook());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getEndBook()))
    {
      localStringBuffer1.append(" AND t.bookCode <= ?");
      localArrayList1.add(paramEvsVoucherVo.getEndBook());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getBeginBox()))
    {
      localStringBuffer1.append(" AND t.packageCode >= ?");
      localArrayList1.add(paramEvsVoucherVo.getBeginBox());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getEndBox()))
    {
      localStringBuffer1.append(" AND t.packageCode <= ?");
      localArrayList1.add(paramEvsVoucherVo.getEndBox());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getSet_book_name()))
    {
      localStringBuffer1.append(" AND t.setBookName = ?");
      localArrayList1.add(paramEvsVoucherVo.getSet_book_name());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getCompanyCode()))
    {
      localStringBuffer1.append(" AND t.companyCode = ?");
      localArrayList1.add(paramEvsVoucherVo.getCompanyCode());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getMatchMode()))
    {
      localStringBuffer1.append(" AND t.matchMode = ?");
      localArrayList1.add(paramEvsVoucherVo.getMatchMode());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getPeriod_name()))
    {
      localStringBuffer1.append(" AND t.periodName = ?");
      localArrayList1.add(paramEvsVoucherVo.getPeriod_name());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getSource_code()))
    {
      localStringBuffer1.append(" AND t.source = ?");
      localArrayList1.add(paramEvsVoucherVo.getSource_code());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getBoeNum())) {
      if (bool)
      {
        localStringBuffer1.append(" AND t.boeNum like ?");
        localArrayList1.add("%" + paramEvsVoucherVo.getBoeNum() + "%");
      }
      else
      {
        localStringBuffer1.append(" AND t.boeNum = ?");
        localArrayList1.add(paramEvsVoucherVo.getBoeNum());
      }
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getInvoiceFstTypeName()))
    {
      localStringBuffer1.append(" AND t.subDocName = ?");
      localArrayList1.add(paramEvsVoucherVo.getInvoiceFstTypeName());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getInvoiceType()))
    {
      localStringBuffer1.append(" AND t.invoiceTypeCode = ?");
      localArrayList1.add(paramEvsVoucherVo.getInvoiceType());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getUser_name()))
    {
      localStringBuffer1.append(" AND t.userName = ?");
      localArrayList1.add(paramEvsVoucherVo.getUser_name());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getStatus()))
    {
      localStringBuffer1.append(" AND t.voucherStatus = ?");
      localArrayList1.add(paramEvsVoucherVo.getStatus());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getApprover()))
    {
      localStringBuffer1.append(" AND t.approver = ?");
      localArrayList1.add(paramEvsVoucherVo.getApprover());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getBookStatus()))
    {
      localStringBuffer1.append(" AND t.voucherStatus = ?");
      localArrayList1.add(paramEvsVoucherVo.getBookStatus());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getBoxStatus()))
    {
      localStringBuffer1.append(" AND t.voucherStatus = ?");
      localArrayList1.add(paramEvsVoucherVo.getBoxStatus());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getBegin_created_date()))
    {
      localStringBuffer1.append(" AND to_char(t.createdDate, 'yyyy-mm-dd') >= ?");
      localArrayList1.add(paramEvsVoucherVo.getBegin_created_date());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getEnd_created_date()))
    {
      localStringBuffer1.append(" AND to_char(t.createdDate, 'yyyy-mm-dd') <= ?");
      localArrayList1.add(paramEvsVoucherVo.getEnd_created_date());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getBegin_approver_date()))
    {
      localStringBuffer1.append(" AND to_char(t.approverDate, 'yyyy-mm-dd')  >= ?");
      localArrayList1.add(paramEvsVoucherVo.getBegin_approver_date());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getEnd_approver_date()))
    {
      localStringBuffer1.append(" AND to_char(t.approverDate, 'yyyy-mm-dd')  <= ?");
      localArrayList1.add(paramEvsVoucherVo.getEnd_approver_date());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getBarcode())) {
      if (bool)
      {
        localStringBuffer1.append(" AND t.voucherId in(select voucherId from EvsImage e where e.imageInfoId in(select ii.imageInfoId from EidImageInfos ii where ii.taskNum like ?))");
        localArrayList1.add("%" + paramEvsVoucherVo.getBarcode() + "%");
      }
      else
      {
        localStringBuffer1.append(" AND t.voucherId in(select voucherId from EvsImage e where e.imageInfoId in(select ii.imageInfoId from EidImageInfos ii where ii.taskNum = ?))");
        localArrayList1.add(paramEvsVoucherVo.getBarcode());
      }
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getVoucherMarker()))
    {
      localStringBuffer1.append(" AND t.voucherMarker = ?");
      localArrayList1.add(paramEvsVoucherVo.getVoucherMarker());
    }
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    String str = "";
    if (null == localEasUserInfo) {
      str = paramEvsVoucherVo.getUserInfoPk();
    } else {
      str = localEasUserInfo.getUserInfoPk().toString();
    }
    if (!Util.isStrEmpty(str))
    {
      if (!"10000".equals(localEasUserInfo.getUserId())) {
        localStringBuffer1.append(" and exists(from FbpPseRelationsV f where f.companyId=t.companyId and f.employeeId = " + str + ")");
      }
    }
    else {
      localStringBuffer1.append(" and exists(from FbpPseRelationsV f where f.companyId=t.companyId and f.employeeId = '000' )");
    }
    if ((!Util.isStrEmpty(paramEvsVoucherVo.getOu_id())) && ("ORDER".equals(paramEvsVoucherVo.getOu_id().toString()))) {
      localStringBuffer1.append(" ORDER BY t.bookCode,CASE WHEN t.source IN ('GVS', 'HOPE') THEN t.userName   WHEN t.source IN ('U8', 'NC') THEN  DECODE(t.invoiceType, '收', '1', '付', '2', '转', '3', '9') WHEN t.source = 'LES' THEN t.journalNum ELSE t.voucherSeqValue END, CASE WHEN t.source IN ('GVS', 'HOPE') THEN t.journalNum WHEN t.source IN ('U8', 'NC') THEN t.journalNum  END");
    } else {
      localStringBuffer1.append(" ORDER BY t.journalNum");
    }
    PageInfo localPageInfo = PageInfoQueryForArray(localStringBuffer1.toString(), paramInt1 / paramInt2 + 1, paramInt2, localArrayList1.toArray());
    List localList = (List)localPageInfo.getResult();
    ArrayList localArrayList2 = new ArrayList();
    int i = localList.size();
    for (int j = 0; j < i; j++)
    {
      StringBuffer localStringBuffer2 = new StringBuffer();
      EvsVoucherSearchV localEvsVoucherSearchV = (EvsVoucherSearchV)localList.get(j);
      Object localObject;
      if (!Util.isNullObject(localEvsVoucherSearchV.getInvCityId()))
      {
        localObject = this.docAccessStorageDAO.findCityNameByCityId(localEvsVoucherSearchV.getInvCityId());
        localStringBuffer2.append(((EvsCity)localObject).getCityName());
      }
      if (!Util.isStrEmpty(localEvsVoucherSearchV.getInvStorageCode()))
      {
        localStringBuffer2.append("-");
        localObject = this.docAccessStorageDAO.findStorageDocNameByStoCode(localEvsVoucherSearchV.getInvStorageCode());
        localStringBuffer2.append(((EvsStorageDoc)localObject).getStorageName());
      }
      if (!Util.isStrEmpty(localEvsVoucherSearchV.getInvArea()))
      {
        localStringBuffer2.append("-");
        localObject = this.docAccessStorageDAO.findFbpLookupValues(localEvsVoucherSearchV.getInvArea());
        localStringBuffer2.append(((FbpLookupValuesV)localObject).getMeaning());
      }
      if (!Util.isStrEmpty(localEvsVoucherSearchV.getInvRow()))
      {
        localStringBuffer2.append("-");
        localObject = this.docAccessStorageDAO.findFbpLookupValues(localEvsVoucherSearchV.getInvRow());
        localStringBuffer2.append(((FbpLookupValuesV)localObject).getMeaning());
      }
      if (!Util.isStrEmpty(localEvsVoucherSearchV.getInvColumn()))
      {
        localStringBuffer2.append("-");
        localObject = this.docAccessStorageDAO.findFbpLookupValues(localEvsVoucherSearchV.getInvColumn());
        localStringBuffer2.append(((FbpLookupValuesV)localObject).getMeaning());
      }
      if (!Util.isStrEmpty(localEvsVoucherSearchV.getInvLevel()))
      {
        localStringBuffer2.append("-");
        localObject = this.docAccessStorageDAO.findFbpLookupValues(localEvsVoucherSearchV.getInvLevel());
        localStringBuffer2.append(((FbpLookupValuesV)localObject).getMeaning());
      }
      localEvsVoucherSearchV.setStoreAddress(localStringBuffer2.toString());
      localEvsVoucherSearchV.setBoeNum(localEvsVoucherSearchV.getBoeNum() == null ? "" : localEvsVoucherSearchV.getBoeNum());
      localArrayList2.add(localEvsVoucherSearchV);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", localArrayList2);
    localHashMap.put("totalCount", Long.valueOf(localPageInfo.getTotalCount()));
    return localHashMap;
  }
  
  public int findBookCountByQry(EvsVoucherVo paramEvsVoucherVo)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(18);
    localStringBuffer.append("select t.bookCode,count(*) FROM EvsVoucherSearchV t WHERE 1=1");
    if (!Util.isStrEmpty(paramEvsVoucherVo.getBeginID()))
    {
      localStringBuffer.append(" AND t.journalNum >= ?");
      localArrayList.add(paramEvsVoucherVo.getBeginID().toUpperCase());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getEndID()))
    {
      localStringBuffer.append(" AND t.journalNum <= ?");
      localArrayList.add(paramEvsVoucherVo.getEndID().toUpperCase());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getBeginBook()))
    {
      localStringBuffer.append(" AND t.bookCode >= ?");
      localArrayList.add(paramEvsVoucherVo.getBeginBook());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getEndBook()))
    {
      localStringBuffer.append(" AND t.bookCode <= ?");
      localArrayList.add(paramEvsVoucherVo.getEndBook());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getBeginBox()))
    {
      localStringBuffer.append(" AND t.packageCode >= ?");
      localArrayList.add(paramEvsVoucherVo.getBeginBox());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getEndBox()))
    {
      localStringBuffer.append(" AND t.packageCode <= ?");
      localArrayList.add(paramEvsVoucherVo.getEndBox());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getSet_book_name()))
    {
      localStringBuffer.append(" AND t.setBookName = ?");
      localArrayList.add(paramEvsVoucherVo.getSet_book_name());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getCompanyCode()))
    {
      localStringBuffer.append(" AND t.companyCode = ?");
      localArrayList.add(paramEvsVoucherVo.getCompanyCode());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getMatchMode()))
    {
      localStringBuffer.append(" AND t.matchMode = ?");
      localArrayList.add(paramEvsVoucherVo.getMatchMode());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getPeriod_name()))
    {
      localStringBuffer.append(" AND t.periodName = ?");
      localArrayList.add(paramEvsVoucherVo.getPeriod_name());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getSource_code()))
    {
      localStringBuffer.append(" AND t.source = ?");
      localArrayList.add(paramEvsVoucherVo.getSource_code());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getBoeNum()))
    {
      localStringBuffer.append(" AND t.boeNum = ?");
      localArrayList.add(paramEvsVoucherVo.getBoeNum());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getInvoiceFstTypeName()))
    {
      localStringBuffer.append(" AND t.subDocName = ?");
      localArrayList.add(paramEvsVoucherVo.getInvoiceFstTypeName());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getInvoiceType()))
    {
      localStringBuffer.append(" AND t.invoiceTypeCode = ?");
      localArrayList.add(paramEvsVoucherVo.getInvoiceType());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getUser_name()))
    {
      localStringBuffer.append(" AND t.userName like ?");
      localArrayList.add("%" + paramEvsVoucherVo.getUser_name() + "%");
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getStatus()))
    {
      localStringBuffer.append(" AND t.voucherStatus = ?");
      localArrayList.add(paramEvsVoucherVo.getStatus());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getApprover()))
    {
      localStringBuffer.append(" AND t.approver like ?");
      localArrayList.add("%" + paramEvsVoucherVo.getApprover() + "%");
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getBookStatus()))
    {
      localStringBuffer.append(" AND t.voucherStatus = ?");
      localArrayList.add(paramEvsVoucherVo.getBookStatus());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getBoxStatus()))
    {
      localStringBuffer.append(" AND t.voucherStatus = ?");
      localArrayList.add(paramEvsVoucherVo.getBoxStatus());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getBegin_created_date()))
    {
      localStringBuffer.append(" AND to_char(t.createdDate, 'yyyy-mm-dd') >= ?");
      localArrayList.add(paramEvsVoucherVo.getBegin_created_date());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getEnd_created_date()))
    {
      localStringBuffer.append(" AND to_char(t.createdDate, 'yyyy-mm-dd') <= ?");
      localArrayList.add(paramEvsVoucherVo.getEnd_created_date());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getBegin_approver_date()))
    {
      localStringBuffer.append(" AND to_char(t.approverDate, 'yyyy-mm-dd')  >= ?");
      localArrayList.add(paramEvsVoucherVo.getBegin_approver_date());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getEnd_approver_date()))
    {
      localStringBuffer.append(" AND to_char(t.approverDate, 'yyyy-mm-dd')  <= ?");
      localArrayList.add(paramEvsVoucherVo.getEnd_approver_date());
    }
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    if (!Util.isStrEmpty(localEasUserInfo.getUserInfoPk().toString())) {
      localStringBuffer.append(" and exists(from FbpPseRelationsV f where f.companyId=t.companyId and f.employeeId = " + localEasUserInfo.getUserInfoPk().toString() + ")");
    } else {
      localStringBuffer.append(" and exists(from FbpPseRelationsV f where f.companyId=t.companyId and f.employeeId = '000' )");
    }
    localStringBuffer.append(" and t.bookCode is not null  GROUP BY t.bookCode ");
    int i = 0;
    List localList = find(localStringBuffer.toString(), localArrayList.toArray());
    if (localList != null) {
      i = localList.size();
    }
    return i;
  }
  
  public List<EvsVoucherLineV> findVoucherWhereNeedCreate(int paramInt)
  {
    String str = "select * from EVS_VOUCHER_LINE_V where update_Status='0' and rownum < ?";
    List localList = super.getSession().createSQLQuery(str).addEntity(EvsVoucherLineV.class).setParameter(0, Integer.valueOf(paramInt + 1)).list();
    return localList;
  }
  
  public List<EvsVoucher> findHistoryWhereNeedCreate(int paramInt)
  {
    return getSession().createQuery("FROM EvsVoucher v WHERE v.updateHistoryStatus='0' and rownum<=" + paramInt).list();
  }
  
  public void updateVoucherUpdateStatus(Long paramLong, int paramInt)
  {
    getSession().createSQLQuery("update EVS_VOUCHER v set v.UPDATE_STATUS = '" + paramInt + "' where v.VOUCHER_ID=" + paramLong).executeUpdate();
  }
  
  public void updateVoucherHisUpdateStatus(Long paramLong, int paramInt)
  {
    getSession().createSQLQuery("update EVS_VOUCHER v set v.HISTORY_UPDATE_STATUS = '" + paramInt + "' where v.VOUCHER_ID=" + paramLong).executeUpdate();
  }
  
  public Map findAllHistoryForVoucher(String paramString, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append("from EvsVoucherHistoryV hst where 1=1");
    localStringBuffer.append(" and hst.opObjectType = 0 and hst.objectCode = '" + paramString + "'");
    localStringBuffer.append(" order by hst.handleDate desc");
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1 / paramInt2 + 1, paramInt2, localArrayList.toArray());
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", localPageInfo.getResult());
    localHashMap.put("totalCount", Long.valueOf(localPageInfo.getTotalCount()));
    return localHashMap;
  }
  
  public List<EvsVoucher> findEvsVoucherByVoucherId(List paramList)
  {
    String str1 = "";
    String str2 = "";
    ArrayList localArrayList = new ArrayList();
    Object localObject = new ArrayList();
    if (paramList.size() == 0)
    {
      str2 = "from EvsVoucher e where e.voucherId =0 ";
    }
    else
    {
      for (int i = 0; i < paramList.size(); i++)
      {
        String str3 = paramList.get(i).toString();
        Long localLong = Long.valueOf(Long.parseLong(str3));
        str1 = str1 + localLong + ",";
        if ((i > 0) && (i % 999 == 0))
        {
          if (str1.endsWith(",")) {
            str1 = str1.substring(0, str1.length() - 1);
          }
          localArrayList.add(str1);
          str1 = "";
        }
      }
      if ((str1 != null) && (str1.trim().length() > 0))
      {
        if (str1.endsWith(",")) {
          str1 = str1.substring(0, str1.length() - 1);
        }
        localArrayList.add(str1);
      }
      str2 = "from EvsVoucher e where 1=1";
      for (i = 0; i < localArrayList.size(); i++) {
        if (i == 0) {
          str2 = str2 + " and (e.voucherId in(" + (String)localArrayList.get(i) + ")";
        } else {
          str2 = str2 + " or e.voucherId in(" + (String)localArrayList.get(i) + ")";
        }
      }
      str2 = str2 + ")";
    }
    localObject = getSession().createQuery(str2).list();
    return localObject;
  }
  
  public PageInfo findEvsVoucherByBookId(Long paramLong, int paramInt1, int paramInt2)
  {
    IImageCommonDAO localIImageCommonDAO = (IImageCommonDAO)SSBBus.findDomainService("imageCommonDAO");
    EvsBook localEvsBook = (EvsBook)getObject(EvsBook.class, paramLong);
    if ((localEvsBook != null) && (localEvsBook.getBookBreakFlag().equals("S")))
    {
      localObject = "select t.* from apps.evs_voucher_v t,(select b.book_id,b.book_code, v.voucher_id, v.journal_num,b.book_date,b.book_status,b.period_name,b.begin_num,b.end_num, b.company_code,b.invoice_type,b.book_break_flag from evs.evs_voucher v, evs.evs_book b, evs.evs_voucher_book_package p where v.voucher_id = p.voucher_id and b.book_id = p.book_id and b.book_status <> 'UNBOOK' and p.enabled_flag = 'Y') fv where t.voucher_id = fv.voucher_id and fv.book_id=" + paramLong;
      localObject = (String)localObject + "order by t.invoice_Type_code,t.journal_num";
      localArrayList = new ArrayList();
      localPageInfo = localIImageCommonDAO.pageInfoObjectBySql(((String)localObject).toString(), localArrayList, EvsVoucherV.class, paramInt1 / paramInt2 + 1, paramInt2);
      return localPageInfo;
    }
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("select t.* from apps.evs_voucher_v t, apps.evs_book_voucher_v b where t.voucher_id = b.voucher_id and b.book_id = ? order by t.invoice_Type_code,t.journal_num");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramLong);
    PageInfo localPageInfo = localIImageCommonDAO.pageInfoObjectBySql(((StringBuffer)localObject).toString(), localArrayList, EvsVoucherV.class, paramInt1 / paramInt2 + 1, paramInt2);
    return localPageInfo;
  }
  
  public List<EvsVoucher> findEvsVoucherByVoucherIds(List paramList)
  {
    String str1 = "";
    String str2 = "";
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject1 = new ArrayList();
    EvsVoucher localEvsVoucher = null;
    Object localObject2;
    if (paramList.size() == 0)
    {
      str2 = "from EvsVoucher e where e.voucherId =0 ";
    }
    else
    {
      for (int i = 0; i < paramList.size(); i++)
      {
        localObject2 = paramList.get(i).toString();
        Long localLong = Long.valueOf(Long.parseLong((String)localObject2));
        str1 = str1 + localLong + ",";
        if ((i > 0) && (i % 999 == 0))
        {
          if (str1.endsWith(",")) {
            str1 = str1.substring(0, str1.length() - 1);
          }
          localArrayList1.add(str1);
          str1 = "";
        }
      }
      if ((str1 != null) && (str1.trim().length() > 0))
      {
        if (str1.endsWith(",")) {
          str1 = str1.substring(0, str1.length() - 1);
        }
        localArrayList1.add(str1);
      }
      str2 = "from EvsVoucherV t where 1=1";
      for (i = 0; i < localArrayList1.size(); i++) {
        if (i == 0) {
          str2 = str2 + " and (t.voucherId in(" + (String)localArrayList1.get(i) + ")";
        } else {
          str2 = str2 + " or t.voucherId in(" + (String)localArrayList1.get(i) + ")";
        }
      }
      str2 = str2 + ") ";
      str2 = str2 + " ORDER BY  CASE WHEN t.source IN ('GVS', 'HOPE') THEN t.userName   WHEN t.source IN ('U8', 'NC') THEN  DECODE(t.invoiceType, '收', '1', '付', '2', '转', '3', '9') WHEN t.source = 'LES' THEN t.journalNum ELSE t.voucherSeqValue END, CASE WHEN t.source IN ('GVS', 'HOPE') THEN t.journalNum WHEN t.source IN ('U8', 'NC') THEN t.journalNum  END";
      System.out.println("\n\n" + str2 + "\n\n");
      localObject1 = getSession().createQuery(str2).list();
    }
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      Iterator localIterator = ((List)localObject1).iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (EvsVoucherV)localIterator.next();
        localEvsVoucher = new EvsVoucher();
        localEvsVoucher.setVoucherId(((EvsVoucherV)localObject2).getVoucherId());
        localEvsVoucher.setJournalNum(((EvsVoucherV)localObject2).getJournalNum());
        localEvsVoucher.setPeriodName(((EvsVoucherV)localObject2).getPeriodName());
        localEvsVoucher.setInvoiceType(((EvsVoucherV)localObject2).getInvoiceType());
        localEvsVoucher.setCompanyCode(((EvsVoucherV)localObject2).getCompanyCode());
        localEvsVoucher.setVoucherStatus(((EvsVoucherV)localObject2).getVoucherStatus());
        localArrayList2.add(localEvsVoucher);
      }
    }
    return localArrayList2;
  }
  
  public PageInfo findImageByBookId(Long paramLong, int paramInt1, int paramInt2)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append("from EvsVoucher e where 1=1 and e.voucherId in (select ev.voucherId from EvsVoucherBookPackage ev where ev.bookId=?)");
    localArrayList.add(paramLong);
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1, paramInt2, localArrayList.toArray());
    return localPageInfo;
  }
  
  public PageInfo findVoucherByQryCondition(EvsBookVoucherDetailV paramEvsBookVoucherDetailV, int paramInt1, int paramInt2, int paramInt3)
  {
    Connection localConnection = null;
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    localPageInfo1 = null;
    try
    {
      StringBuffer localStringBuffer1 = new StringBuffer();
      StringBuffer localStringBuffer2 = new StringBuffer();
      ArrayList localArrayList = new ArrayList(25);
      localStringBuffer1.append("select * FROM Evs_Book_Voucher_Detail_V t WHERE 1=1");
      if (paramInt1 == 1)
      {
        localStringBuffer2.append("select get_book_lost_detail(eb.begin_num,eb.end_num,eb.ou_name,eb.book_id) cu from evs_book eb where eb.book_break_flag='Y' and eb.ou_name='" + paramEvsBookVoucherDetailV.getOuId() + "'");
        localConnection = getSession().connection();
        localPreparedStatement = localConnection.prepareStatement(localStringBuffer2.toString());
        localResultSet = localPreparedStatement.executeQuery();
        String[] arrayOfString = null;
        String str = "";
        while (localResultSet.next())
        {
          arrayOfString = localResultSet.getString(1).split(",");
          for (int i = 0; i < arrayOfString.length; i++) {
            str = str + "'" + arrayOfString[i] + "',";
          }
        }
        if (str.endsWith(",")) {
          str = str.substring(0, str.length() - 1);
        }
        localStringBuffer1 = new StringBuffer();
        if (str != "")
        {
          localStringBuffer1.append("select rownum as num,t.voucher_Id,k.book_Code,t.book_id,t.package_Code,t.journal_Num,t.sub_doc_name,t.SET_BOOK_NAME,t.source,t.ou_Id,t.check_Unit,t.ou_Name,t.period_Name,t.invoice_Type,t.match_Mode,t.user_Name,t.approver,t.created_Date,t.approver_Date,t.barcode,t.voucher_Status,t.bookStatus,t.boxStatus,t.archive_Number,t.begin_Num,t.end_Num,t.book_Date,t.book_Employee_Id from Evs_Book_Voucher_Detail_V t,Evs_Book_Voucher_Lost_V k where k.cu like '%'||t.journal_Num||'%'");
          localStringBuffer1.append(" and t.journal_Num in(" + str + ")");
        }
        else
        {
          PageInfo localPageInfo2 = localPageInfo1;
          return localPageInfo2;
        }
      }
      else if (paramInt1 == 2)
      {
        localStringBuffer1.append(" AND t.voucher_Status ='UNMATCH'");
      }
      else
      {
        localStringBuffer1.append(" AND t.match_Mode ='手动匹配'");
      }
      if (!Util.isStrEmpty(paramEvsBookVoucherDetailV.getBegin_Book_Date()))
      {
        localStringBuffer1.append(" AND to_char(t.book_date, 'yyyy-mm-dd') >= ?");
        localArrayList.add(paramEvsBookVoucherDetailV.getBegin_Book_Date());
      }
      if (!Util.isStrEmpty(paramEvsBookVoucherDetailV.getEnd_Book_Date()))
      {
        localStringBuffer1.append(" AND to_char(t.book_date, 'yyyy-mm-dd') <= ?");
        localArrayList.add(paramEvsBookVoucherDetailV.getEnd_Book_Date());
      }
      if (!Util.isStrEmpty(paramEvsBookVoucherDetailV.getBookEmployeeId()))
      {
        localStringBuffer1.append(" AND t.book_employee_id = ?");
        localArrayList.add(paramEvsBookVoucherDetailV.getBookEmployeeId());
      }
      if (!Util.isStrEmpty(paramEvsBookVoucherDetailV.getSetBookName()))
      {
        localStringBuffer1.append(" AND t.set_Book_Name = ?");
        localArrayList.add(paramEvsBookVoucherDetailV.getSetBookName());
      }
      if (!Util.isStrEmpty(paramEvsBookVoucherDetailV.getOuId()))
      {
        localStringBuffer1.append(" AND t.ou_Id = ?");
        localArrayList.add(paramEvsBookVoucherDetailV.getOuId());
      }
      if (!Util.isStrEmpty(paramEvsBookVoucherDetailV.getPeriodName()))
      {
        localStringBuffer1.append(" AND t.period_Name = ?");
        localArrayList.add(paramEvsBookVoucherDetailV.getPeriodName());
      }
      if (!Util.isStrEmpty(paramEvsBookVoucherDetailV.getSource()))
      {
        localStringBuffer1.append(" AND t.source = ?");
        localArrayList.add(paramEvsBookVoucherDetailV.getSource());
      }
      if (!Util.isStrEmpty(paramEvsBookVoucherDetailV.getInvoiceFstTypeName()))
      {
        localStringBuffer1.append(" AND t.sub_Doc_Name = ?");
        localArrayList.add(paramEvsBookVoucherDetailV.getInvoiceFstTypeName());
      }
      if (!Util.isStrEmpty(paramEvsBookVoucherDetailV.getInvoiceType()))
      {
        localStringBuffer1.append(" AND t.invoice_Type = ?");
        localArrayList.add(paramEvsBookVoucherDetailV.getInvoiceType());
      }
      localStringBuffer1.append(" order by t.voucher_Id");
      localPageInfo1 = PageInfoFromArrayBySQL(localStringBuffer1.toString(), paramInt2 / paramInt3 + 1, paramInt3, localArrayList.toArray());
      return localPageInfo1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    finally
    {
      try
      {
        if (localPreparedStatement != null) {
          localPreparedStatement.close();
        }
        if (localResultSet != null) {
          localResultSet.close();
        }
      }
      catch (SQLException localSQLException4)
      {
        localSQLException4.printStackTrace();
      }
    }
  }
  
  public EidObjectUtils getObjectUtils()
  {
    return this.objectUtils;
  }
  
  public void setObjectUtils(EidObjectUtils paramEidObjectUtils)
  {
    this.objectUtils = paramEidObjectUtils;
  }
  
  public PageInfo PageInfoFromArrayBySQL(String paramString, int paramInt1, int paramInt2, Object[] paramArrayOfObject)
  {
    return PageInfoQueryForArraySQL(paramString, fixRangeStart(paramInt1, paramInt2), paramInt2, paramArrayOfObject);
  }
  
  public int fixRangeStart(int paramInt1, int paramInt2)
  {
    return paramInt1 / paramInt2 + 1;
  }
  
  private PageInfo PageInfoQueryForArraySQL(String paramString, int paramInt1, int paramInt2, Object[] paramArrayOfObject)
  {
    if (paramString != null) {
      Assert.hasText(paramString);
    }
    if (paramInt1 < 1) {
      paramInt1 = 1;
    }
    String str = " select count (*) " + new StringBuilder().append(" from (").append(paramString).append(") s").toString();
    long l1 = 0L;
    long l2 = System.currentTimeMillis();
    l1 = getMyDataTotal(str, paramArrayOfObject).longValue();
    long l3 = System.currentTimeMillis();
    System.out.println("total spend time :" + (l3 - l2) / 1000L);
    if (l1 < 1L) {
      return new PageInfo();
    }
    int i = PageInfo.getStartOfPageInfo(paramInt1, paramInt2);
    SQLQuery localSQLQuery = getSession().createSQLQuery(paramString);
    if (paramArrayOfObject != null) {
      for (int j = 0; j < paramArrayOfObject.length; j++) {
        localSQLQuery.setParameter(j, paramArrayOfObject[j]);
      }
    }
    List localList = localSQLQuery.setFirstResult(i).setMaxResults(paramInt2).list();
    return new PageInfo(i, l1, paramInt2, localList);
  }
  
  private Long getMyDataTotal(String paramString, Object[] paramArrayOfObject)
  {
    SQLQuery localSQLQuery = getSession().createSQLQuery(paramString);
    for (int i = 0; i < paramArrayOfObject.length; i++) {
      localSQLQuery.setParameter(i, paramArrayOfObject[i]);
    }
    List localList = localSQLQuery.list();
    BigDecimal localBigDecimal = (localList == null) || (localList.size() <= 0) ? new BigDecimal(0) : (BigDecimal)localList.get(0);
    return Long.valueOf(localBigDecimal.longValue());
  }
  
  public PageInfo PageInfoQueryForArray(String paramString, int paramInt1, int paramInt2, Object[] paramArrayOfObject)
  {
    if (paramString != null) {
      Assert.hasText(paramString);
    }
    if (paramInt1 < 1) {
      paramInt1 = 1;
    }
    String str1 = " select count (*) " + removeSelect(removeOrders(paramString));
    long l1 = 0L;
    String str2 = paramString.toLowerCase();
    int i = str2.indexOf(" distinct ");
    int j = str2.indexOf(" group by ");
    long l2 = System.currentTimeMillis();
    if ((i > 0) || (j > 0))
    {
      l1 = getDataTotal(paramString, paramArrayOfObject).longValue();
    }
    else
    {
      List localList1 = getZormTemplate().find(str1, paramArrayOfObject);
      l1 = ((Long)localList1.get(0)).longValue();
    }
    long l3 = System.currentTimeMillis();
    System.out.println("total spend time :" + (l3 - l2) / 1000L);
    if (l1 < 1L) {
      return new PageInfo();
    }
    int k = PageInfo.getStartOfPageInfo(paramInt1, paramInt2);
    Query localQuery = null;
    if (paramArrayOfObject == null) {
      localQuery = createQuery(paramString, new Object[0]);
    } else {
      localQuery = createQuery(paramString, paramArrayOfObject);
    }
    List localList2 = localQuery.setFirstResult(k).setMaxResults(paramInt2).list();
    return new PageInfo(k, l1, paramInt2, localList2);
  }
  
  private static String removeSelect(String paramString)
  {
    Assert.hasText(paramString);
    int i = paramString.toLowerCase().indexOf("from");
    Assert.isTrue(i != -1, " hql : " + paramString + " must has a keyword 'from'");
    return paramString.substring(i);
  }
  
  private static String removeOrders(String paramString)
  {
    Assert.hasText(paramString);
    Pattern localPattern = Pattern.compile("order\\s*by[\\w|\\W|\\s|\\S]*", 2);
    Matcher localMatcher = localPattern.matcher(paramString);
    StringBuffer localStringBuffer = new StringBuffer();
    while (localMatcher.find()) {
      localMatcher.appendReplacement(localStringBuffer, "");
    }
    localMatcher.appendTail(localStringBuffer);
    return localStringBuffer.toString();
  }
  
  public Long getDataTotal(String paramString, Object[] paramArrayOfObject)
  {
    QueryTranslatorImpl localQueryTranslatorImpl = new QueryTranslatorImpl(paramString, paramString, Collections.EMPTY_MAP, (SessionFactoryImplementor)getSessionFactory());
    localQueryTranslatorImpl.compile(Collections.EMPTY_MAP, false);
    String str1 = localQueryTranslatorImpl.getSQLString();
    String str2 = "select count(*) from (" + str1 + ") tmp_count_t";
    SQLQuery localSQLQuery = getSession().createSQLQuery(str2);
    for (int i = 0; i < paramArrayOfObject.length; i++) {
      localSQLQuery.setParameter(i, paramArrayOfObject[i]);
    }
    List localList = localSQLQuery.list();
    BigDecimal localBigDecimal = (localList == null) || (localList.size() <= 0) ? new BigDecimal(0) : (BigDecimal)localList.get(0);
    return Long.valueOf(localBigDecimal.longValue());
  }
  
  public EvsVoucher getEvsVoucherByCode(String paramString)
  {
    EvsVoucher localEvsVoucher = null;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("from EvsVoucher t where t.journalNum='");
    localStringBuilder.append(paramString).append("'");
    List localList = super.getSession().createQuery(localStringBuilder.toString()).list();
    if ((localList != null) && (localList.size() > 0)) {
      localEvsVoucher = (EvsVoucher)localList.get(0);
    }
    return localEvsVoucher;
  }
  
  public void insertObject(EvsVoucher paramEvsVoucher)
  {
    super.insertObject(paramEvsVoucher);
  }
  
  public java.util.Date getLastDateByType(String paramString)
  {
    java.sql.Date localDate = null;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SELECT MAX(t.last_update_date) FROM evs_voucher t WHERE 1=1");
    if ((paramString != null) && (!"".equals(paramString)))
    {
      localStringBuilder.append(" and t.Invoice_Type='").append(paramString).append("'");
      localStringBuilder.append(" group by t.Invoice_Type");
    }
    List localList = super.getSession().createSQLQuery(localStringBuilder.toString()).list();
    if ((localList != null) && (localList.size() > 0)) {
      localDate = (java.sql.Date)localList.get(0);
    }
    return localDate;
  }
  
  public void vocherMatch()
    throws SQLException
  {
    Connection localConnection = super.getSession().connection();
    CallableStatement localCallableStatement = null;
    localCallableStatement = localConnection.prepareCall("{call EVS_VOUCHER_MATCH_IMAGE_PKG.EVS_JOURNAL_IMAGE}");
    localCallableStatement.execute();
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
  
  public EvsVoucherLineV findVoucherVById(long paramLong)
  {
    return (EvsVoucherLineV)super.getObject(EvsVoucherLineV.class, Long.valueOf(paramLong));
  }
  
  public Map findFasciculeByQry(EvsVoucherVo paramEvsVoucherVo, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(18);
    localStringBuffer.append("FROM EvsVoucherSearchV t WHERE 1=1");
    if (!Util.isStrEmpty(paramEvsVoucherVo.getBookId())) {
      localStringBuffer.append(" AND t.bookId = " + paramEvsVoucherVo.getBookId());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getCompanyCode()))
    {
      localStringBuffer.append(" AND t.companyCode = ?");
      localArrayList.add(paramEvsVoucherVo.getCompanyCode());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getDeptId()))
    {
      localStringBuffer.append(" AND t.deptName like ?");
      localArrayList.add("%" + paramEvsVoucherVo.getDeptId() + "%");
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getUser_name()))
    {
      localStringBuffer.append(" AND t.userName like ?");
      localArrayList.add("%" + paramEvsVoucherVo.getUser_name() + "%");
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getBegin_created_date()))
    {
      localStringBuffer.append(" AND to_char(t.journalDate, 'yyyy-mm-dd') >= ?");
      localArrayList.add(paramEvsVoucherVo.getBegin_created_date());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getEnd_created_date()))
    {
      localStringBuffer.append(" AND to_char(t.journalDate, 'yyyy-mm-dd') <= ?");
      localArrayList.add(paramEvsVoucherVo.getEnd_created_date());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getPeriod_name()))
    {
      localStringBuffer.append(" AND t.periodName = ?");
      localArrayList.add(paramEvsVoucherVo.getPeriod_name());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getBegin_approver_date()))
    {
      localStringBuffer.append(" AND to_char(t.approverDate, 'yyyy-mm-dd')  >= ?");
      localArrayList.add(paramEvsVoucherVo.getBegin_approver_date());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getEnd_approver_date()))
    {
      localStringBuffer.append(" AND to_char(t.approverDate, 'yyyy-mm-dd')  <= ?");
      localArrayList.add(paramEvsVoucherVo.getEnd_approver_date());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getBeginID()))
    {
      localStringBuffer.append(" AND t.journalNum >= ?");
      localArrayList.add(paramEvsVoucherVo.getBeginID().toUpperCase());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getEndID()))
    {
      localStringBuffer.append(" AND t.journalNum <= ?");
      localArrayList.add(paramEvsVoucherVo.getEndID().toUpperCase());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getBoeNum()))
    {
      localStringBuffer.append(" AND t.boeNum = ?");
      localArrayList.add(paramEvsVoucherVo.getBoeNum());
    }
    localStringBuffer.append(" and t.voucherStatus in('CHECKED_NO_BOOKED','CHECKED','BOOKED_NO_BOX')");
    if (!Util.isStrEmpty(paramEvsVoucherVo.getTheMaxTotal())) {
      paramInt2 = Integer.valueOf(paramEvsVoucherVo.getTheMaxTotal()).intValue();
    }
    localStringBuffer.append(" ORDER BY  CASE WHEN t.source IN ('GVS', 'HOPE') THEN t.userName   WHEN t.source IN ('U8', 'NC') THEN  DECODE(t.invoiceType, '收', '1', '付', '2', '转', '3', '9') WHEN t.source = 'LES' THEN t.journalNum ELSE t.voucherSeqValue END, CASE WHEN t.source IN ('GVS', 'HOPE') THEN t.journalNum WHEN t.source IN ('U8', 'NC') THEN t.journalNum  END");
    PageInfo localPageInfo = PageInfoQueryForArray(localStringBuffer.toString(), paramInt1 / paramInt2 + 1, paramInt2, localArrayList.toArray());
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", localPageInfo.getResult());
    localHashMap.put("totalCount", Long.valueOf(localPageInfo.getTotalCount()));
    return localHashMap;
  }
  
  public Map findVoucherList(EvsVoucherVo paramEvsVoucherVo, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(18);
    localStringBuffer.append("FROM EvsVoucherV t WHERE 1=1 ");
    if (!Util.isStrEmpty(paramEvsVoucherVo.getCompanyCode()))
    {
      localStringBuffer.append(" AND t.companyCode = ?");
      localArrayList.add(paramEvsVoucherVo.getCompanyCode());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getPeriod_name()))
    {
      localStringBuffer.append(" AND t.periodName = ?");
      localArrayList.add(paramEvsVoucherVo.getPeriod_name());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getBeginID()))
    {
      localStringBuffer.append(" AND t.journalNum >= ?");
      localArrayList.add(paramEvsVoucherVo.getBeginID().toUpperCase());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getEndID()))
    {
      localStringBuffer.append(" AND t.journalNum <= ?");
      localArrayList.add(paramEvsVoucherVo.getEndID().toUpperCase());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getInvoiceType()))
    {
      localStringBuffer.append(" AND t.invoiceTypeCode = ?");
      localArrayList.add(paramEvsVoucherVo.getInvoiceType());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getMatchMode()))
    {
      localStringBuffer.append(" AND t.matchMode = ?");
      localArrayList.add(paramEvsVoucherVo.getMatchMode());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getDeptId()))
    {
      localStringBuffer.append(" AND t.deptName like ?");
      localArrayList.add("%" + paramEvsVoucherVo.getDeptId() + "%");
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getUser_name()))
    {
      localStringBuffer.append(" AND t.userName like ?");
      localArrayList.add("%" + paramEvsVoucherVo.getUser_name() + "%");
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getBegin_created_date()))
    {
      localStringBuffer.append(" AND to_char(t.journalDate, 'yyyy-mm-dd') >= ?");
      localArrayList.add(paramEvsVoucherVo.getBegin_created_date());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getEnd_created_date()))
    {
      localStringBuffer.append(" AND to_char(t.journalDate, 'yyyy-mm-dd') <= ?");
      localArrayList.add(paramEvsVoucherVo.getEnd_created_date());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getBegin_approver_date()))
    {
      localStringBuffer.append(" AND to_char(t.approverDate, 'yyyy-mm-dd')  >= ?");
      localArrayList.add(paramEvsVoucherVo.getBegin_approver_date());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getEnd_approver_date()))
    {
      localStringBuffer.append(" AND to_char(t.approverDate, 'yyyy-mm-dd')  <= ?");
      localArrayList.add(paramEvsVoucherVo.getEnd_approver_date());
    }
    if (!Util.isStrEmpty(paramEvsVoucherVo.getBoeNum()))
    {
      localStringBuffer.append(" AND t.boeNum like ?");
      localArrayList.add("%" + paramEvsVoucherVo.getBoeNum() + "%");
    }
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    if (!Util.isStrEmpty(localEasUserInfo.getUserInfoPk().toString())) {
      localStringBuffer.append(" and exists(from FbpPseRelationsV f where f.companyId=t.companyId and f.employeeId = " + localEasUserInfo.getUserInfoPk().toString() + ")");
    } else {
      localStringBuffer.append(" and exists(from FbpPseRelationsV f where f.companyId=t.companyId and f.employeeId = '000' )");
    }
    localStringBuffer.append(" and t.voucherStatus in('CHECKED_NO_BOOKED','CHECKED')");
    localStringBuffer.append(" and t.voucherId not in ( select e.voucherId FROM EvsVoucherBookPackage e WHERE 1=1  ");
    if (!Util.isStrEmpty(paramEvsVoucherVo.getBookId())) {
      localStringBuffer.append(" AND e.bookId = " + paramEvsVoucherVo.getBookId());
    }
    localStringBuffer.append(" ) ");
    if (!Util.isStrEmpty(paramEvsVoucherVo.getTheMaxTotal())) {
      paramInt2 = Integer.valueOf(paramEvsVoucherVo.getTheMaxTotal()).intValue();
    }
    localStringBuffer.append(" ORDER BY  CASE WHEN t.source IN ('GVS', 'HOPE') THEN t.userName   WHEN t.source IN ('U8', 'NC') THEN  DECODE(t.invoiceType, '收', '1', '付', '2', '转', '3', '9') WHEN t.source = 'LES' THEN t.journalNum ELSE t.voucherSeqValue END, CASE WHEN t.source IN ('GVS', 'HOPE') THEN t.journalNum WHEN t.source IN ('U8', 'NC') THEN t.journalNum  END");
    PageInfo localPageInfo = PageInfoQueryForArray(localStringBuffer.toString(), paramInt1 / paramInt2 + 1, paramInt2, localArrayList.toArray());
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", localPageInfo.getResult());
    localHashMap.put("totalCount", Long.valueOf(localPageInfo.getTotalCount()));
    return localHashMap;
  }
  
  public Map findVoucherByVoucherId(String paramString, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append("from EvsVoucherV v where v.voucherId = " + paramString);
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1 / paramInt2 + 1, paramInt2, localArrayList.toArray());
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", localPageInfo.getResult());
    localHashMap.put("totalCount", Long.valueOf(localPageInfo.getTotalCount()));
    return localHashMap;
  }
  
  public String findEvsManageOrgVS(String paramString1, String paramString2)
  {
    Object localObject1 = new ArrayList();
    String str = "select distinct e.companyId from FbpPseRelationsV e where e.employeeId='" + paramString2 + "' and e.posStructureCode = 'VOUCHER_QUERY'";
    localObject1 = getZormTemplate().find(str);
    if (((List)localObject1).size() != 0)
    {
      Iterator localIterator = ((List)localObject1).iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        if (paramString1.equals(localObject2.toString())) {
          return "true";
        }
      }
    }
    return "false";
  }
  
  public PageInfo findVoucherInspect(EvsVoucherVo paramEvsVoucherVo, int paramInt1, int paramInt2)
  {
    PageInfo localPageInfo = null;
    new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    try
    {
      StringBuffer localStringBuffer1 = new StringBuffer();
      StringBuffer localStringBuffer2 = new StringBuffer();
      ArrayList localArrayList = new ArrayList();
      localStringBuffer1.append("SELECT A.COMPANY_CODE, A.COMPANY_NAME ,SUM(UNMATCH) A1,SUM(BACKED) A2,SUM(WAREHOUSE) A3,SUM(BORROWING) A4,SUM(NOW_FLITTING) A5,SUM(BOOKED) A6,SUM(MATCHED) A7,SUM(COUNTS) COUNTS FROM (SELECT F.COMPANY_CODE, T.COMPANY_NAME,decode(EV.VOUCHER_STATUS,'UNMATCH',COUNT(EV.VOUCHER_STATUS),'0') UNMATCH,decode(EV.VOUCHER_STATUS,'BACKED',COUNT(EV.VOUCHER_STATUS),'0') BACKED,decode(EV.VOUCHER_STATUS,'WAREHOUSE',COUNT(EV.VOUCHER_STATUS),'0') WAREHOUSE,decode(EV.VOUCHER_STATUS,'BORROWING',COUNT(EV.VOUCHER_STATUS),'0') BORROWING,decode(EV.VOUCHER_STATUS,'NOW_FLITTING',COUNT(EV.VOUCHER_STATUS),'0') NOW_FLITTING,decode(EV.VOUCHER_STATUS,'BOOKED',COUNT(EV.VOUCHER_STATUS),'0') BOOKED,decode(EV.VOUCHER_STATUS,'MATCHED',COUNT(EV.VOUCHER_STATUS),'0') MATCHED,to_number(decode(EV.VOUCHER_STATUS,'UNMATCH', COUNT(EV.VOUCHER_STATUS),'0'))+to_number(decode(EV.VOUCHER_STATUS,'BACKED', COUNT(EV.VOUCHER_STATUS), '0'))+to_number(decode(EV.VOUCHER_STATUS,'WAREHOUSE', COUNT(EV.VOUCHER_STATUS), '0'))+to_number(decode(EV.VOUCHER_STATUS,'BORROWING', COUNT(EV.VOUCHER_STATUS), '0'))+to_number(decode(EV.VOUCHER_STATUS,'NOW_FLITTING', COUNT(EV.VOUCHER_STATUS), '0'))+to_number(decode(EV.VOUCHER_STATUS,'BOOKED', COUNT(EV.VOUCHER_STATUS), '0'))+to_number(decode(EV.VOUCHER_STATUS,'MATCHED', COUNT(EV.VOUCHER_STATUS), '0')) COUNTS  FROM FBP_COMPANY F, FBP_COMPANY_TL T, EVS_VOUCHER EV, FBP_PERIODS FP WHERE F.COMPANY_ID = T.COMPANY_ID   AND F.COMPANY_CODE = EV.COMPANY_CODE   AND EV.PERIOD_NAME = FP.PERIOD_NAME  AND F.ENABLED_FLAG = 'Y'   AND T.LANGUAGE = ZAS_ENV_PKG.getLang()   AND FP.PERIOD_TYPE = '22'");
      if (paramEvsVoucherVo != null)
      {
        if ((paramEvsVoucherVo.getCompanyCode() != null) && (paramEvsVoucherVo.getCompanyCode().trim().length() > 0))
        {
          localStringBuffer1.append(" and ev.company_code = ?");
          localArrayList.add(paramEvsVoucherVo.getCompanyCode());
        }
        if ((paramEvsVoucherVo.getPeriod_name() != null) && (paramEvsVoucherVo.getPeriod_name().trim().length() > 0))
        {
          localStringBuffer1.append(" and ev.period_name = ?");
          localArrayList.add(paramEvsVoucherVo.getPeriod_name());
        }
      }
      if (!"10000".equals(localEasUserInfo.getUserId()))
      {
        localStringBuffer1.append(" and exists(select 1 from apps.fbp_pse_relations_v v where f.company_id = v.company_id and v.pos_structure_code = ? and v.employee_id = ?)");
        localArrayList.add("VOUCHER_QUERY");
        localArrayList.add(localEasUserInfo.getUserInfoPk());
      }
      localStringBuffer1.append(" GROUP BY F.COMPANY_CODE, T.COMPANY_NAME,EV.VOUCHER_STATUS) A WHERE 1=1 GROUP BY A.COMPANY_CODE, A.COMPANY_NAME");
      localPageInfo = PageInfoFromArrayBySQL(localStringBuffer1.toString(), paramInt1, paramInt2, localArrayList.toArray());
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localPageInfo;
  }
  
  public String checkFascicule(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = "FROM EvsVoucherV e where 1=1 and e.voucherStatus in('MATCHED','UNBOOK') ";
    if (!Util.isStrEmpty(paramString1)) {
      str = str + " and e.journalNum='" + paramString1 + "'";
    }
    if ((paramString2 != null) && (!"".equals(paramString2))) {
      str = str + " and e.periodName='" + paramString2 + "'";
    }
    if ((paramString3 != null) && (!"".equals(paramString3))) {
      str = str + " and e.companyCode='" + paramString3 + "'";
    }
    if ((paramString4 != null) && (!"".equals(paramString4))) {
      str = str + " and e.invoiceType='" + paramString4 + "'";
    }
    List localList = getZormTemplate().find(str);
    if (localList.size() > 0) {
      return "true";
    }
    return "false";
  }
  
  public Map findFascicule(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("select * FROM EVS_VOUCHER_V e WHERE 1=1 and e.voucher_Status in('MATCHED','UNBOOK') ");
    if (!Util.isStrEmpty(paramString1)) {
      localStringBuffer.append(" AND e.period_Name= '" + paramString1 + "'");
    }
    if (!Util.isStrEmpty(paramString2)) {
      localStringBuffer.append(" AND e.company_code= '" + paramString2 + "'");
    }
    if (!Util.isStrEmpty(paramString3)) {
      localStringBuffer.append(" AND e.INVOICE_TYPE_CODE= '" + paramString3 + "'");
    }
    if (!Util.isStrEmpty(paramString6)) {
      localStringBuffer.append(" AND e.VOUCHER_SEQ_VALUE= '" + paramString6 + "'");
    }
    if (!Util.isStrEmpty(paramString4))
    {
      localObject1 = paramString4.split(",");
      if (localObject1.length > 0)
      {
        localStringBuffer.append(" and  e.journal_num in ( ");
        for (int i = 0; i < localObject1.length; i++)
        {
          localObject2 = localObject1[i];
          if (i == 0) {
            localStringBuffer.append("'" + (String)localObject2 + "'");
          } else {
            localStringBuffer.append(",'" + (String)localObject2 + "'");
          }
        }
        localStringBuffer.append(")");
      }
    }
    if (!Util.isStrEmpty(paramString5))
    {
      localStringBuffer.append(" UNION ALL (select * FROM EVS_VOUCHER_V ev WHERE 1=1 and ev.voucher_Status in('BOOKED') ");
      localStringBuffer.append(" AND ev.period_Name= '" + paramString1 + "'");
      localStringBuffer.append(" AND ev.company_code= '" + paramString2 + "'");
      localStringBuffer.append(" and ev.voucher_Id  in ( select t.voucher_Id FROM Evs_Voucher_Book_Package t WHERE 1=1  ");
      localStringBuffer.append(" AND t.book_Id = " + paramString5 + ")) ");
    }
    Object localObject1 = getSession().createSQLQuery(localStringBuffer.toString()).addEntity(EvsVoucherV.class);
    ((Query)localObject1).setFirstResult(paramInt1);
    ((Query)localObject1).setMaxResults(paramInt2);
    List localList = ((Query)localObject1).list();
    Object localObject2 = new HashMap();
    ((Map)localObject2).put("data", localList);
    ((Map)localObject2).put("totalCount", Integer.valueOf(localList.size()));
    return localObject2;
  }
  
  public List<EvsVoucherV> findFasciculeByList(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("select * FROM EVS_VOUCHER_V e WHERE 1=1 and e.voucher_Status in('MATCHED','UNBOOK') ");
    if (!Util.isStrEmpty(paramString1)) {
      localStringBuffer.append(" AND e.period_Name= '" + paramString1 + "'");
    }
    if (!Util.isStrEmpty(paramString2)) {
      localStringBuffer.append(" AND e.company_code= '" + paramString2 + "'");
    }
    if (!Util.isStrEmpty(paramString3)) {
      localStringBuffer.append(" AND e.INVOICE_TYPE_CODE= '" + paramString3 + "'");
    }
    if (!Util.isStrEmpty(paramString6)) {
      localStringBuffer.append(" AND e.VOUCHER_SEQ_VALUE= '" + paramString6 + "'");
    }
    if (!Util.isStrEmpty(paramString4))
    {
      localObject = paramString4.split(",");
      if (localObject.length > 0)
      {
        localStringBuffer.append(" and  e.journal_num in ( ");
        for (int i = 0; i < localObject.length; i++)
        {
          String str = localObject[i];
          if (i == 0) {
            localStringBuffer.append("'" + str + "'");
          } else {
            localStringBuffer.append(",'" + str + "'");
          }
        }
        localStringBuffer.append(")");
      }
    }
    if (!Util.isStrEmpty(paramString5))
    {
      localStringBuffer.append(" UNION ALL (select * FROM EVS_VOUCHER_V ev WHERE 1=1 and ev.voucher_Status in('BOOKED') ");
      localStringBuffer.append(" AND ev.period_Name= '" + paramString1 + "'");
      localStringBuffer.append(" AND ev.company_code= '" + paramString2 + "'");
      localStringBuffer.append(" and ev.voucher_Id  in ( select t.voucher_Id FROM Evs_Voucher_Book_Package t WHERE 1=1  ");
      localStringBuffer.append(" AND t.book_Id = " + paramString5 + ")) ");
    }
    Object localObject = getSession().createSQLQuery(localStringBuffer.toString()).addEntity(EvsVoucherV.class);
    List localList = ((Query)localObject).list();
    return localList;
  }
  
  public boolean findFasciculeListCheck(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("select * FROM EVS_VOUCHER_V e WHERE 1=1 and e.voucher_Status in('MATCHED','UNBOOK') ");
    if (!Util.isStrEmpty(paramString)) {
      localStringBuffer.append(" AND e.VOUCHER_SEQ_VALUE= '" + paramString + "'");
    }
    SQLQuery localSQLQuery = getSession().createSQLQuery(localStringBuffer.toString()).addEntity(EvsVoucherV.class);
    List localList = localSQLQuery.list();
    return localList.size() > 0;
  }
  
  public Map getVoucherList(EvsBookModel paramEvsBookModel, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList();
    localStringBuffer.append("FROM EvsVoucherV e WHERE 1=1 and e.voucherStatus in('BOOKED') ");
    localStringBuffer.append(" and e.voucherId  in ( select t.voucherId FROM EvsVoucherBookPackage t WHERE 1=1  ");
    if (!Util.isStrEmpty(paramEvsBookModel.getBookId())) {
      localStringBuffer.append(" AND t.bookId = " + paramEvsBookModel.getBookId() + ") ");
    }
    if (!Util.isStrEmpty(paramEvsBookModel.getPeriodName()))
    {
      localStringBuffer.append(" AND e.periodName= ?");
      localArrayList.add(paramEvsBookModel.getPeriodName());
    }
    if (!Util.isStrEmpty(paramEvsBookModel.getCompanyCode()))
    {
      localStringBuffer.append(" AND e.companyCode= ?");
      localArrayList.add(paramEvsBookModel.getCompanyCode());
    }
    PageInfo localPageInfo = PageInfoQueryForArray(localStringBuffer.toString(), paramInt1 / paramInt2 + 1, paramInt2, localArrayList.toArray());
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", localPageInfo.getResult());
    localHashMap.put("totalCount", Long.valueOf(localPageInfo.getTotalCount()));
    return localHashMap;
  }
  
  public List<EvsVoucherV> getVoucherListByList(EvsBookModel paramEvsBookModel)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList();
    localStringBuffer.append("FROM EvsVoucherV e WHERE 1=1 and e.voucherStatus in('BOOKED') ");
    localStringBuffer.append(" and e.voucherId  in ( select t.voucherId FROM EvsVoucherBookPackage t WHERE 1=1  ");
    if (!Util.isStrEmpty(paramEvsBookModel.getBookId())) {
      localStringBuffer.append(" AND t.bookId = " + paramEvsBookModel.getBookId() + ") ");
    }
    if (!Util.isStrEmpty(paramEvsBookModel.getPeriodName()))
    {
      localStringBuffer.append(" AND e.periodName= ?");
      localArrayList.add(paramEvsBookModel.getPeriodName());
    }
    if (!Util.isStrEmpty(paramEvsBookModel.getCompanyCode()))
    {
      localStringBuffer.append(" AND e.companyCode= ?");
      localArrayList.add(paramEvsBookModel.getCompanyCode());
    }
    return getZormTemplate().find(localStringBuffer.toString(), localArrayList.toArray());
  }
  
  public List<EvsVoucherBookPackage> getVoucherListForL(EvsBookModel paramEvsBookModel)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList();
    localStringBuffer.append("FROM EvsVoucherBookPackage t WHERE 1=1 and t.enabledFlag<>'N' ");
    if (!Util.isStrEmpty(paramEvsBookModel.getBookId())) {
      localStringBuffer.append(" AND t.bookId = " + paramEvsBookModel.getBookId() + ") ");
    }
    return getSession().createQuery(localStringBuffer.toString()).list();
  }
  
  public List<EvsVoucherBookPackage> getVoucherListForL2(EvsBookModel paramEvsBookModel)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str = "";
    List localList = getEvsBook(paramEvsBookModel.getArchiveNumber());
    for (int i = 0; i < localList.size(); i++) {
      if (i != localList.size() - 1) {
        str = str + ((EvsBook)localList.get(i)).getBookId() + ",";
      } else {
        str = str + ((EvsBook)localList.get(i)).getBookId();
      }
    }
    localStringBuffer.append("FROM EvsVoucherBookPackage t WHERE 1=1 and t.enabledFlag<>'N' ");
    localStringBuffer.append(" AND t.bookId in ( " + str + ") ");
    localStringBuffer.append(" order by t.bookId");
    return getSession().createQuery(localStringBuffer.toString()).list();
  }
  
  public List<EvsBook> getEvsBook(String paramString)
  {
    String str = new String();
    ArrayList localArrayList = new ArrayList();
    str = "FROM EvsBook b where 1=1 and b.archiveNumber = " + paramString;
    return getSession().createQuery(str.toString()).list();
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
 * Qualified Name:     com.zte.evs.ebill.access.eBillManage.EvsVoucherDAO
 * JD-Core Version:    0.7.0.1
 */