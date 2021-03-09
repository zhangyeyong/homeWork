package com.zte.evs.ebill.access.eBillManage;

import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesV;
import com.zte.eimage.access.baseconfig.dao.IImageCommonDAO;
import com.zte.eimage.business.baseconfig.util.EidObjectUtils;
import com.zte.evs.ebill.common.EvsObjectUtils;
import com.zte.evs.ebill.model.eBillManage.EvsImageModel;
import com.zte.evs.ebill.model.eBillManage.EvsManageOrgV;
import com.zte.evs.ebill.model.eBillManage.EvsVoucher;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherInvoice;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherListV;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherSelect;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherV;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.util.Util;
import com.zte.ssb.orm.zorm.ZormTemplate;
import com.zte.ssb.zorm.Query;
import com.zte.ssb.zorm.SQLQuery;
import com.zte.ssb.zorm.Session;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class EvsVoucherCheckFindDAO
  extends BaseDAO
  implements IEvsVoucherCheckFindDAO
{
  private static final Log log = LogFactory.getLog(EvsVoucherCheckFindDAO.class);
  
  public Map findEmployeeHeaderByScanCode(EvsVoucherSelect paramEvsVoucherSelect, int paramInt1, int paramInt2)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append("from EvsVoucherV e where 2>1 ");
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getScanVoucherNum()))
    {
      localObject1 = new StringBuffer();
      localObject2 = paramEvsVoucherSelect.getScanVoucherNum().split(",");
      for (int i = 0; i < localObject2.length; i++) {
        if (i == 0)
        {
          ((StringBuffer)localObject1).append("?");
          localArrayList.add(localObject2[i]);
        }
        else
        {
          ((StringBuffer)localObject1).append(" ,?");
          localArrayList.add(localObject2[i]);
        }
      }
      localStringBuffer.append(" and e.journalNum in (" + ((StringBuffer)localObject1).toString() + ") ");
    }
    if (localEasUserInfo != null) {
      localStringBuffer.append(" and e.ouId = " + localEasUserInfo.getOrgId() + " ORDER BY e.journalNum desc");
    } else {
      localStringBuffer.append(" ORDER BY e.journalNum desc");
    }
    Object localObject1 = super.PageInfoQuery(localStringBuffer.toString(), paramInt1 / paramInt2 + 1, paramInt2, localArrayList.toArray());
    Object localObject2 = new HashMap();
    ((Map)localObject2).put("data", ((PageInfo)localObject1).getResult());
    ((Map)localObject2).put("totalCount", Long.valueOf(((PageInfo)localObject1).getTotalCount()));
    return localObject2;
  }
  
  public EvsVoucher findVoucherIdByJornalNum(String paramString)
  {
    String str = "from EvsVoucher e where 1=1";
    if ((!paramString.equals("")) && (paramString != null)) {
      str = str + " and e.jornalNum='" + paramString + "'";
    }
    List localList = getZormTemplate().find(str);
    if (localList.size() > 0) {
      return (EvsVoucher)localList.get(0);
    }
    return new EvsVoucher();
  }
  
  public PageInfo findHeaderByCondition(EvsVoucherV paramEvsVoucherV, int paramInt1, int paramInt2)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append("from EvsVoucherV e where 1=1 ");
    if (!Util.isStrEmpty(paramEvsVoucherV.getBeginID().toUpperCase())) {
      if ((paramEvsVoucherV.getBlurQuery() != null) && (paramEvsVoucherV.getBlurQuery().equals("Y")))
      {
        localStringBuffer.append(" AND e.journalNum  LIKE '%" + paramEvsVoucherV.getBeginID().toUpperCase() + "%'");
      }
      else
      {
        localStringBuffer.append(" AND e.journalNum >= ?");
        localArrayList.add(paramEvsVoucherV.getBeginID().toUpperCase());
      }
    }
    if (!Util.isStrEmpty(paramEvsVoucherV.getEndID().toUpperCase())) {
      if ((paramEvsVoucherV.getBlurQuery() != null) && (paramEvsVoucherV.getBlurQuery().equals("Y")))
      {
        localStringBuffer.append(" AND e.journalNum  LIKE '%" + paramEvsVoucherV.getEndID().toUpperCase() + "%'");
      }
      else
      {
        localStringBuffer.append(" AND e.journalNum <= ?");
        localArrayList.add(paramEvsVoucherV.getEndID().toUpperCase());
      }
    }
    if (!Util.isNullObject(paramEvsVoucherV.getCompanyId()))
    {
      localStringBuffer.append(" AND e.companyId = ?");
      localArrayList.add(paramEvsVoucherV.getCompanyId());
    }
    if (!Util.isStrEmpty(paramEvsVoucherV.getPeriodName()))
    {
      localStringBuffer.append(" AND e.periodName = ?");
      localArrayList.add(paramEvsVoucherV.getPeriodName());
    }
    if (!Util.isStrEmpty(paramEvsVoucherV.getMatchMode()))
    {
      localStringBuffer.append(" AND e.matchMode = ? ");
      localArrayList.add(paramEvsVoucherV.getMatchMode());
    }
    if (!Util.isStrEmpty(paramEvsVoucherV.getInvoiceTypeCode()))
    {
      localStringBuffer.append(" AND e.invoiceTypeCode = ?");
      localArrayList.add(paramEvsVoucherV.getInvoiceTypeCode());
    }
    if (!Util.isStrEmpty(paramEvsVoucherV.getBegin_created_date()))
    {
      localStringBuffer.append(" AND to_char(e.createdDate,'yyyy-mm-dd') >= ?");
      localArrayList.add(paramEvsVoucherV.getBegin_created_date());
    }
    if (!Util.isStrEmpty(paramEvsVoucherV.getEnd_created_date()))
    {
      localStringBuffer.append(" AND to_char(e.createdDate,'yyyy-mm-dd') <= ?");
      localArrayList.add(paramEvsVoucherV.getEnd_created_date());
    }
    if (!Util.isStrEmpty(paramEvsVoucherV.getUserName())) {
      if ((paramEvsVoucherV.getBlurQuery() != null) && (paramEvsVoucherV.getBlurQuery().equals("Y")))
      {
        localStringBuffer.append(" AND e.userName  LIKE '%" + paramEvsVoucherV.getUserName() + "%'");
      }
      else
      {
        localStringBuffer.append(" AND e.userName = ? ");
        localArrayList.add(paramEvsVoucherV.getUserName());
      }
    }
    if ((paramEvsVoucherV.getVoucherAmountFrom() != null) && (!"".equals(paramEvsVoucherV.getVoucherAmountFrom())))
    {
      localStringBuffer.append(" AND e.voucherAmount>=?");
      localArrayList.add(paramEvsVoucherV.getVoucherAmountFrom());
    }
    if ((paramEvsVoucherV.getVoucherAmountTo() != null) && (!"".equals(paramEvsVoucherV.getVoucherAmountTo())))
    {
      localStringBuffer.append(" AND e.voucherAmount<=?");
      localArrayList.add(paramEvsVoucherV.getVoucherAmountTo());
    }
    localStringBuffer.append("and e.voucherStatus in('CHECKED_NO_BOOKED')");
    EidObjectUtils localEidObjectUtils = (EidObjectUtils)SSBBus.findDaoService("eidObjectUtils");
    Long localLong = Long.valueOf(Long.parseLong(localEidObjectUtils.getEmployeeBySession().getEmployeeId().toString()));
    localStringBuffer.append(" and exists(from FbpPseRelationsV f where f.companyId=e.companyId and f.employeeId = " + localLong + ")");
    localStringBuffer.append(" ORDER BY e.journalNum ");
    paramInt1 = paramInt1 / paramInt2 + 1;
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1, paramInt2, localArrayList.toArray());
    return localPageInfo;
  }
  
  public PageInfo findHeaderByQry(EvsVoucherV paramEvsVoucherV, int paramInt1, int paramInt2)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append("from EvsVoucherV e where 1=1 ");
    if (!Util.isStrEmpty(paramEvsVoucherV.getBeginID().toUpperCase())) {
      if ((paramEvsVoucherV.getBlurQuery() != null) && (paramEvsVoucherV.getBlurQuery().equals("Y")))
      {
        localStringBuffer.append(" AND e.journalNum  LIKE '%" + paramEvsVoucherV.getBeginID().toUpperCase() + "%'");
      }
      else
      {
        localStringBuffer.append(" AND e.journalNum >= ?");
        localArrayList.add(paramEvsVoucherV.getBeginID().toUpperCase());
      }
    }
    if (!Util.isStrEmpty(paramEvsVoucherV.getEndID().toUpperCase())) {
      if ((paramEvsVoucherV.getBlurQuery() != null) && (paramEvsVoucherV.getBlurQuery().equals("Y")))
      {
        localStringBuffer.append(" AND e.journalNum  LIKE '%" + paramEvsVoucherV.getEndID().toUpperCase() + "%'");
      }
      else
      {
        localStringBuffer.append(" AND e.journalNum <= ?");
        localArrayList.add(paramEvsVoucherV.getEndID().toUpperCase());
      }
    }
    if (!Util.isNullObject(paramEvsVoucherV.getCompanyId()))
    {
      localStringBuffer.append(" AND e.companyId = ?");
      localArrayList.add(paramEvsVoucherV.getCompanyId());
    }
    if (!Util.isStrEmpty(paramEvsVoucherV.getPeriodName()))
    {
      localStringBuffer.append(" AND e.periodName = ?");
      localArrayList.add(paramEvsVoucherV.getPeriodName());
    }
    if (!Util.isStrEmpty(paramEvsVoucherV.getMatchMode()))
    {
      localStringBuffer.append(" AND e.matchMode = ? ");
      localArrayList.add(paramEvsVoucherV.getMatchMode());
    }
    if (!Util.isStrEmpty(paramEvsVoucherV.getInvoiceTypeCode()))
    {
      localStringBuffer.append(" AND e.invoiceTypeCode = ?");
      localArrayList.add(paramEvsVoucherV.getInvoiceTypeCode());
    }
    if (!Util.isStrEmpty(paramEvsVoucherV.getBegin_created_date()))
    {
      localStringBuffer.append(" AND to_char(e.createdDate,'yyyy-mm-dd') >= ?");
      localArrayList.add(paramEvsVoucherV.getBegin_created_date());
    }
    if (!Util.isStrEmpty(paramEvsVoucherV.getEnd_created_date()))
    {
      localStringBuffer.append(" AND to_char(e.createdDate,'yyyy-mm-dd') <= ?");
      localArrayList.add(paramEvsVoucherV.getEnd_created_date());
    }
    if (!Util.isStrEmpty(paramEvsVoucherV.getUserName())) {
      if ((paramEvsVoucherV.getBlurQuery() != null) && (paramEvsVoucherV.getBlurQuery().equals("Y")))
      {
        localStringBuffer.append(" AND e.userName  LIKE '%" + paramEvsVoucherV.getUserName() + "%'");
      }
      else
      {
        localStringBuffer.append(" AND e.userName = ? ");
        localArrayList.add(paramEvsVoucherV.getUserName());
      }
    }
    if ((paramEvsVoucherV.getVoucherAmountFrom() != null) && (!"".equals(paramEvsVoucherV.getVoucherAmountFrom())))
    {
      localStringBuffer.append(" AND e.voucherAmount>=?");
      localArrayList.add(paramEvsVoucherV.getVoucherAmountFrom());
    }
    if ((paramEvsVoucherV.getVoucherAmountTo() != null) && (!"".equals(paramEvsVoucherV.getVoucherAmountTo())))
    {
      localStringBuffer.append(" AND e.voucherAmount<=?");
      localArrayList.add(paramEvsVoucherV.getVoucherAmountTo());
    }
    localStringBuffer.append("and e.voucherStatus in ('SUBMITED')");
    EidObjectUtils localEidObjectUtils = (EidObjectUtils)SSBBus.findDaoService("eidObjectUtils");
    Long localLong = Long.valueOf(Long.parseLong(localEidObjectUtils.getEmployeeBySession().getEmployeeId().toString()));
    localStringBuffer.append(" and exists(from FbpPseRelationsV f where f.companyId=e.companyId and f.employeeId = " + localLong + ")");
    localStringBuffer.append(" ORDER BY e.lastUpdateDate ,e.journalNum");
    paramInt1 = paramInt1 / paramInt2 + 1;
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1, paramInt2, localArrayList.toArray());
    return localPageInfo;
  }
  
  public void update(String paramString1, String paramString2)
  {
    log.debug("update EvsHeader header");
    try
    {
      String str = " update EVS_VOUCHER set voucher_Status ='" + paramString1 + "'  where voucher_id in " + paramString2 + "";
      getSession().createSQLQuery(str).executeUpdate();
      log.debug("update successful");
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("update failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public void updateCheckStatus(String paramString1, String paramString2)
  {
    log.debug("update EvsHeader header");
    try
    {
      String str = " update EVS_VOUCHER set VOUCHER_STATUS ='" + paramString1 + "', APPROVER_DATE=sysdate  where voucher_id in " + paramString2 + "";
      getSession().createSQLQuery(str).executeUpdate();
      log.debug("update successful");
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("update failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public Map findEntry(EvsVoucherSelect paramEvsVoucherSelect, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append("from EvsImageV where 1=1");
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getSelectbarCode()))
    {
      localStringBuffer.append(" and barcode like ? ");
      localArrayList.add("%" + paramEvsVoucherSelect.getSelectbarCode() + "%");
    }
    localStringBuffer.append(" and  companyCode =?");
    localArrayList.add(paramEvsVoucherSelect.getCompanyCode());
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1 / paramInt2 + 1, paramInt2, localArrayList.toArray());
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", localPageInfo.getResult());
    localHashMap.put("totalCount", Long.valueOf(localPageInfo.getTotalCount()));
    return localHashMap;
  }
  
  public Map findInvoices(EvsVoucherSelect paramEvsVoucherSelect, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append("from EvsInvoices t where 1=1");
    if (!Util.isStrEmpty(paramEvsVoucherSelect.getSelectbarCode()))
    {
      localStringBuffer.append(" and invoiceNum like ? ");
      localArrayList.add("%" + paramEvsVoucherSelect.getSelectbarCode() + "%");
    }
    localStringBuffer.append(" and  buyCompanyCode =? and not exists(select 1 from EvsVoucherInvoice v where v.invoiceId=t.invoiceId and v.voucherId!=?)");
    localArrayList.add(paramEvsVoucherSelect.getCompanyCode());
    localArrayList.add(paramEvsVoucherSelect.getVoucherId());
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1 / paramInt2 + 1, paramInt2, localArrayList.toArray());
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", localPageInfo.getResult());
    localHashMap.put("totalCount", Long.valueOf(localPageInfo.getTotalCount()));
    return localHashMap;
  }
  
  public void updateEntry(EvsVoucher paramEvsVoucher)
  {
    log.debug("update EvsVoucher voucher");
    try
    {
      getSession().update(paramEvsVoucher);
      log.debug("update successful");
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("update failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public void updateImage(Long paramLong, String paramString)
  {
    log.debug("update EvsImage image");
    try
    {
      String str = " update EVS_Image set voucher_id ='" + paramLong + "' where barcode in " + paramString + "";
      getSession().createSQLQuery(str).executeUpdate();
      log.debug("update successful");
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("update failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public void deleteImage(Long paramLong)
  {
    log.debug("update EvsImage image");
    try
    {
      String str = " update EVS_Image set barcode = null where voucher_id ='" + paramLong + "'";
      getSession().createSQLQuery(str).executeUpdate();
      log.debug("update successful");
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("update failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public Object get(Class paramClass, Serializable paramSerializable)
  {
    Object localObject = null;
    try
    {
      localObject = getSession().get(paramClass, paramSerializable);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localObject;
  }
  
  public void updateImageByVoucherId(Long paramLong)
  {
    log.debug("update EvsImage image");
    try
    {
      String str = " update EVS_Image set voucher_id ='' where voucher_id = '" + paramLong + "'  and BARCODE is not null";
      getSession().createSQLQuery(str).executeUpdate();
      log.debug("update successful");
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("update failed", localRuntimeException);
      throw localRuntimeException;
    }
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
        str = " update EVS_VOUCHER set LAST_UPDATE_DATE = sysdate ,LAST_UPDATE_BY = " + localEasUserInfo.getUserInfoPk() + " ,LAST_UPDATE_LOGIN = " + localEasUserInfo.getUserInfoPk() + " where voucher_id in " + paramString + "";
        getSession().createSQLQuery(str).executeUpdate();
        log.debug("update successful");
      }
      else
      {
        str = " update EVS_VOUCHER set LAST_UPDATE_DATE = sysdate ,LAST_UPDATE_BY = 0 ,LAST_UPDATE_LOGIN = 0 where voucher_id in " + paramString + "";
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
  
  public void saveImage(String paramString)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    log.debug("update EvsImage image");
    try
    {
      String str;
      if (localEasUserInfo != null)
      {
        str = " update EVS_IMAGE set LAST_UPDATE_DATE = sysdate , LAST_UPDATE_BY = " + localEasUserInfo.getUserInfoPk() + " , LAST_UPDATE_LOGIN = " + localEasUserInfo.getUserInfoPk() + " where barcode = '" + paramString + "'";
        getSession().createSQLQuery(str).executeUpdate();
        log.debug("update successful");
      }
      else
      {
        str = " update EVS_IMAGE set LAST_UPDATE_DATE = sysdate , LAST_UPDATE_BY = 0 , LAST_UPDATE_LOGIN = 0 where barcode = '" + paramString + "'";
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
  
  public List<EvsVoucherV> findEvsVoucherVList(String paramString)
  {
    Object localObject = null;
    String str = "";
    if (paramString != "") {
      str = " from EvsVoucherV where voucherId = " + Long.parseLong(paramString) + "";
    }
    List localList = getSession().createQuery(str).list();
    return localList;
  }
  
  public EvsVoucher findEvsVoucher(String paramString)
  {
    EvsVoucher localEvsVoucher = null;
    List localList = super.getZormTemplate().find("from EvsVoucher where voucherId =?", Long.valueOf(Long.parseLong(paramString)));
    getSession().clear();
    if ((null != localList) && (localList.size() > 0)) {
      localEvsVoucher = (EvsVoucher)localList.get(0);
    }
    return localEvsVoucher;
  }
  
  public List<EvsVoucherInvoice> findEvsVoucherInvoice(String paramString)
  {
    Object localObject = null;
    String str = "from EvsVoucherInvoice evi where evi.enabledFlag='Y' and  evi.voucherId =" + Long.parseLong(paramString);
    List localList = getSession().createQuery(str).list();
    return localList;
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
  
  public PageInfo findEmployeeHeaderByScanCode(EvsVoucherV paramEvsVoucherV, int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public Map findHeaderByQry(EvsVoucherSelect paramEvsVoucherSelect, int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public List<BigDecimal> getCheckedInvoiceArr(Long paramLong)
  {
    String str = "SELECT t.Invoice_Id FROM evs_voucher_invoice t WHERE t.voucher_id=?";
    SQLQuery localSQLQuery = super.getSession().createSQLQuery(str);
    localSQLQuery.setLong(0, paramLong.longValue());
    List localList = localSQLQuery.list();
    return localList;
  }
  
  public void deleteInvoice(Long paramLong)
  {
    String str = "delete FROM EvsVoucherInvoice t WHERE t.voucherId=?";
    Query localQuery = super.getSession().createQuery(str);
    localQuery.setLong(0, paramLong.longValue());
    localQuery.executeUpdate();
  }
  
  public PageInfo findcheckedInvoices(Long paramLong, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append("select t from EvsInvoices t,EvsVoucherInvoice s where s.invoiceId=t.invoiceId and s.voucherId=? order by t.invoiceNum");
    localArrayList.add(paramLong);
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1 / paramInt2 + 1, paramInt2, localArrayList.toArray());
    return localPageInfo;
  }
  
  public List<EvsVoucherListV> getEvsVoucherListVByIds(List<String> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("from EvsVoucherListV t where t.voucherId in");
    String[] arrayOfString = new String[paramList.size()];
    Arrays.fill(arrayOfString, "?");
    localStringBuilder.append(Arrays.toString(arrayOfString).replace("[", "(").replace("]", ")"));
    Query localQuery = super.getSession().createQuery(localStringBuilder.toString());
    for (int i = 0; i < paramList.size(); i++) {
      localQuery.setLong(i, Long.valueOf((String)paramList.get(i)).longValue());
    }
    return localQuery.list();
  }
  
  public String printValiate(List<String> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SELECT 1 FROM evs_voucher t WHERE t.voucher_id IN").append(Arrays.toString(paramList.toArray()).replace("[", "(").replace("]", ")")).append(" GROUP BY t.company_code,t.year,t.month  ");
    List localList = super.getSession().createSQLQuery(localStringBuilder.toString()).list();
    return localList.size() + "";
  }
  
  public List<BigDecimal> totalPrintValiate(List<String> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SELECT sum(t.bill_num) FROM evs_voucher t WHERE t.voucher_id IN").append(Arrays.toString(paramList.toArray()).replace("[", "(").replace("]", ")")).append(" GROUP BY t.company_code,t.CURRENCY_CODE,t.USER_NAME  ");
    List localList = super.getSession().createSQLQuery(localStringBuilder.toString()).list();
    return localList;
  }
  
  public List totalTotalPrintList(List<String> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SELECT k.acc_cr,k.acc_dr,k.currency_amount,k.subject_code,k.subject_detail,l.line_desc,k.voucher_id FROM (");
    localStringBuilder.append("SELECT NULL acc_cr,SUM(t.acc_dr) acc_dr,SUM(t.currency_amount) currency_amount,subject_code,subject_detail,MIN(t.line_id) line_id,t.voucher_id");
    localStringBuilder.append("  FROM evs_voucher_line t WHERE t.voucher_id IN").append(Arrays.toString(paramList.toArray()).replace("[", "(").replace("]", ")"));
    localStringBuilder.append(" AND (t.acc_cr IS NULL or t.acc_cr = 0) GROUP BY t.subject_code,t.subject_detail,voucher_id");
    localStringBuilder.append(" UNION ALL ");
    localStringBuilder.append(" SELECT sum(acc_cr) acc_cr, NULL acc_dr,SUM(t.currency_amount) currency_amount,t.subject_code,t.subject_detail,MIN(t.line_id) line_id, t.voucher_id ");
    localStringBuilder.append(" FROM evs_voucher_line t WHERE t.voucher_id IN").append(Arrays.toString(paramList.toArray()).replace("[", "(").replace("]", ")"));
    localStringBuilder.append(" AND (t.acc_dr IS NULL or t.acc_dr = 0) GROUP BY t.subject_code,t.subject_detail,voucher_id)k ,evs_voucher_line l WHERE k.line_id=l.line_id order by nvl2(k.acc_dr,1,2),k.subject_code DESC");
    List localList = super.getSession().createSQLQuery(localStringBuilder.toString()).list();
    return localList;
  }
  
  public List<String> totalTotalBoeNum(List<String> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SELECT boe_num FROM evs_voucher t WHERE t.voucher_id IN").append(Arrays.toString(paramList.toArray()).replace("[", "(").replace("]", ")")).append(" GROUP BY t.company_code,t.CURRENCY_CODE,t.USER_NUMBER,t.boe_num ");
    List localList = super.getSession().createSQLQuery(localStringBuilder.toString()).list();
    return localList;
  }
  
  public List<EvsVoucherV> findHeader()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    EidObjectUtils localEidObjectUtils = (EidObjectUtils)SSBBus.findDaoService("eidObjectUtils");
    Long localLong = Long.valueOf(Long.parseLong(localEidObjectUtils.getEmployeeBySession().getEmployeeId().toString()));
    localStringBuilder.append(" from EvsVoucherV e where e.voucherStatus in ('SUBMITED')");
    localStringBuilder.append(" and exists(from FbpPseRelationsV f where f.companyId=e.companyId and f.employeeId = " + localLong + ")");
    localStringBuilder.append(" ORDER BY e.createdDate desc ,e.journalNum");
    List localList = super.getSession().createQuery(localStringBuilder.toString()).list();
    return localList;
  }
  
  public void updateVoucherStatus(Long paramLong)
  {
    String str = " update EVS_VOUCHER set VOUCHER_MARKER ='Y' where VOUCHER_ID=?";
    getSession().createSQLQuery(str).setLong(0, paramLong.longValue()).executeUpdate();
  }
  
  public Map findImageInf(EvsImageModel paramEvsImageModel, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList();
    IImageCommonDAO localIImageCommonDAO = (IImageCommonDAO)SSBBus.findDomainService("imageCommonDAO");
    localStringBuffer.append("SELECT * FROM (SELECT ei.barcode, ei.image_number, ei.company_code, 'N' as selected, 1 as ord ");
    localStringBuffer.append("from evs_image ei where ei.voucher_id is null ");
    localStringBuffer.append(" and ei.company_code = '" + paramEvsImageModel.getCompanyCode() + "' ");
    if (!Util.isStrEmpty(paramEvsImageModel.getBarname()))
    {
      localStringBuffer.append(" and ei.barcode like ?");
      localArrayList.add("%" + paramEvsImageModel.getBarname() + "%");
    }
    if (!Util.isStrEmpty(paramEvsImageModel.getImageNumber()))
    {
      localStringBuffer.append(" and ei.IMAGE_NUMBER like ? ");
      localArrayList.add("%" + paramEvsImageModel.getImageNumber() + "%");
    }
    localStringBuffer.append("group by ei.barcode, ei.image_number, ei.company_code");
    localStringBuffer.append(" union ALL SELECT ei.barcode, ei.image_number, ei.company_code, 'Y' as selected, 0 as ord ");
    localStringBuffer.append(" from evs_image ei ");
    localStringBuffer.append(" where ei.voucher_id = " + paramEvsImageModel.getVoucherId() + " ");
    localStringBuffer.append(" and ei.company_code = '" + paramEvsImageModel.getCompanyCode() + "' ");
    localStringBuffer.append(" group by ei.barcode, ei.image_number, ei.company_code ) t where 1=1 ");
    localStringBuffer.append(" order by ord");
    Map localMap = localIImageCommonDAO.pageObjectBySql(localStringBuffer.toString(), localArrayList, null, paramInt1 / paramInt2 + 1, paramInt2);
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", localMap.get("DATA"));
    localHashMap.put("totalCount", Integer.valueOf(localMap.get("DATA_COUNT").toString()));
    return localHashMap;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.eBillManage.EvsVoucherCheckFindDAO
 * JD-Core Version:    0.7.0.1
 */