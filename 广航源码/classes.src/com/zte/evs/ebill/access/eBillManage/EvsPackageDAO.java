package com.zte.evs.ebill.access.eBillManage;

import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.eas.resconfig.business.periods.model.FbpPeriods;
import com.zte.evs.ebill.common.EvsObjectUtils;
import com.zte.evs.ebill.model.eBillManage.EvsAddBookV;
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
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.util.Util;
import com.zte.ssb.orm.zorm.ZormTemplate;
import com.zte.ssb.zorm.Query;
import com.zte.ssb.zorm.SQLQuery;
import com.zte.ssb.zorm.Session;
import java.io.PrintStream;
import java.math.BigInteger;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class EvsPackageDAO
  extends BaseDAO
  implements IEvsPackageDAO
{
  private static final Log log = LogFactory.getLog(EvsPackageDAO.class);
  private static final String USERID = "USERID";
  
  public Map findAllPackage(EvsPackageModel paramEvsPackageModel, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append("from EvsPackageV pk where 1=1");
    if ((!Util.isStrEmpty(paramEvsPackageModel.getSerialId())) && ("no".equals(paramEvsPackageModel.getSerialId()))) {
      localStringBuffer.append(" and pk.packageDate >= add_months(sysdate,-6) and pk.packageDate <= sysdate");
    }
    if ((paramEvsPackageModel.getPackageCode() != null) && (!Util.isStrEmpty(paramEvsPackageModel.getPackageCode().toUpperCase())))
    {
      localStringBuffer.append(" and pk.packageCode >= ?");
      localArrayList.add(paramEvsPackageModel.getPackageCode().toUpperCase());
    }
    if ((paramEvsPackageModel.getTempCode() != null) && (!Util.isStrEmpty(paramEvsPackageModel.getTempCode().toUpperCase())))
    {
      localStringBuffer.append(" and pk.packageCode <= ?");
      localArrayList.add(paramEvsPackageModel.getTempCode().toUpperCase());
    }
    if (!Util.isStrEmpty(paramEvsPackageModel.getCompanyName()))
    {
      localStringBuffer.append(" and pk.companyName like ?");
      localArrayList.add("%" + paramEvsPackageModel.getCompanyName() + "%");
    }
    if (!Util.isStrEmpty(paramEvsPackageModel.getPeriodName()))
    {
      localStringBuffer.append(" and pk.periodName = ?");
      localArrayList.add(paramEvsPackageModel.getPeriodName());
    }
    if (!Util.isStrEmpty(paramEvsPackageModel.getPackageStatus()))
    {
      localStringBuffer.append(" and pk.packageStatus = ?");
      localArrayList.add(paramEvsPackageModel.getPackageStatus());
    }
    if (!Util.isStrEmpty(paramEvsPackageModel.getPackageEmployeeId()))
    {
      localStringBuffer.append(" and pk.packagePeople like ?");
      localArrayList.add("%" + paramEvsPackageModel.getPackageEmployeeId() + "%");
    }
    if (!Util.isStrEmpty(paramEvsPackageModel.getPackageDate()))
    {
      localStringBuffer.append(" and to_char(pk.packageDate,'yyyy-mm-dd') >= ?");
      localArrayList.add(paramEvsPackageModel.getPackageDate());
    }
    if (!Util.isStrEmpty(paramEvsPackageModel.getTempDate()))
    {
      localStringBuffer.append(" and to_char(pk.packageDate,'yyyy-mm-dd') <= ?");
      localArrayList.add(paramEvsPackageModel.getTempDate());
    }
    localStringBuffer.append(" and pk.packageStatus in ('PACKAGED','UNPACKAG','ALREADY_RECEIVE','NOT_RECEIVE') order by pk.packageCode desc");
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1 / paramInt2 + 1, paramInt2, localArrayList.toArray());
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", localPageInfo.getResult());
    localHashMap.put("totalCount", Long.valueOf(localPageInfo.getTotalCount()));
    return localHashMap;
  }
  
  public Map findAllPackageNew(EvsPackageModel paramEvsPackageModel, String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append("from EvsPackageV pk where 1=1");
    if ((!Util.isStrEmpty(paramEvsPackageModel.getSerialId())) && ("no".equals(paramEvsPackageModel.getSerialId()))) {
      localStringBuffer.append(" and pk.packageDate >= add_months(sysdate,-6) and pk.packageDate <= sysdate");
    }
    if (!Util.isStrEmpty(paramEvsPackageModel.getCompanyId()))
    {
      localStringBuffer.append(" and pk.companyId = ?");
      localArrayList.add(Long.valueOf(Long.parseLong(paramEvsPackageModel.getCompanyId())));
    }
    if (!Util.isStrEmpty(paramEvsPackageModel.getPackageCode()))
    {
      localStringBuffer.append(" and pk.packageCode like ?");
      localArrayList.add("%" + paramEvsPackageModel.getPackageCode() + "%");
    }
    if (!Util.isStrEmpty(paramEvsPackageModel.getPackageEmployeeId()))
    {
      localStringBuffer.append(" and pk.packageEmployeeId = ?");
      localArrayList.add(Long.valueOf(Long.parseLong(paramEvsPackageModel.getPackageEmployeeId())));
    }
    if (!Util.isStrEmpty(paramEvsPackageModel.getIncomeEmployeeId()))
    {
      localStringBuffer.append(" and pk.incomeEmployeeId like ?");
      localArrayList.add(Long.valueOf(Long.parseLong(paramEvsPackageModel.getIncomeEmployeeId())));
    }
    if (!Util.isStrEmpty(paramEvsPackageModel.getPackageDate()))
    {
      localStringBuffer.append(" and to_char(pk.packageDate,'yyyy-mm-dd') >= ?");
      localArrayList.add(paramEvsPackageModel.getPackageDate());
    }
    if (!Util.isStrEmpty(paramEvsPackageModel.getTempDate()))
    {
      localStringBuffer.append(" and to_char(pk.packageDate,'yyyy-mm-dd') <= ?");
      localArrayList.add(paramEvsPackageModel.getTempDate());
    }
    if ((paramEvsPackageModel.getIncomeDate() != null) && (!paramEvsPackageModel.getIncomeDate().equals("")))
    {
      localStringBuffer.append(" and to_char(pk.incomeDate,'yyyy-mm-dd') >= ?");
      localArrayList.add(paramEvsPackageModel.getIncomeDate());
    }
    if ((paramEvsPackageModel.getIncomeTempDate() != null) && (!paramEvsPackageModel.getIncomeTempDate().equals("")))
    {
      localStringBuffer.append(" and to_char(pk.incomeDate,'yyyy-mm-dd') <= ?");
      localArrayList.add(paramEvsPackageModel.getIncomeTempDate());
    }
    if (!Util.isStrEmpty(paramEvsPackageModel.getWarehouseCode()))
    {
      localStringBuffer.append(" and pk.warehouseCode like ?");
      localArrayList.add("%" + paramEvsPackageModel.getWarehouseCode() + "%");
    }
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      localObject1 = "";
      for (Object localObject3 : paramArrayOfString) {
        if ((localObject3 != null) && (!"null".equals(localObject3)) && (!"".equals(localObject3))) {
          localObject1 = (String)localObject1 + localObject3 + ",";
        }
      }
      if (!"".equals(localObject1))
      {
        localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
        localStringBuffer.append(" and pk.packageId not in(" + (String)localObject1 + ")");
      }
    }
    localStringBuffer.append(" and pk.packageStatus in ('WAREHOUSE','PACKAGED') order by pk.packageDate desc");
    Object localObject1 = super.PageInfoQuery(localStringBuffer.toString(), paramInt1 / paramInt2 + 1, paramInt2, localArrayList.toArray());
    ??? = new HashMap();
    ((Map)???).put("data", ((PageInfo)localObject1).getResult());
    ((Map)???).put("totalCount", Long.valueOf(((PageInfo)localObject1).getTotalCount()));
    return ???;
  }
  
  public Map findBookByCode(EvsBook paramEvsBook, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append("from EvsBookV book where 1=1");
    if (!Util.isStrEmpty(paramEvsBook.getPackageId().toString())) {
      localStringBuffer.append(" and book.packageId= " + paramEvsBook.getPackageId() + " order by book.bookCode asc");
    }
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1 / paramInt2 + 1, paramInt2, localArrayList.toArray());
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", localPageInfo.getResult());
    localHashMap.put("totalCount", Long.valueOf(localPageInfo.getTotalCount()));
    return localHashMap;
  }
  
  public List printBookByCode(EvsAddBookV paramEvsAddBookV)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList();
    localStringBuffer.append("from EvsAddBookV book where 1=1");
    localStringBuffer.append(" and book.bookStatus = 'PACKAGED'");
    if (!Util.isStrEmpty(paramEvsAddBookV.getPackageId().toString()))
    {
      localStringBuffer.append(" and book.packageId= ? ");
      localArrayList.add(paramEvsAddBookV.getPackageId());
      localStringBuffer.append(" order by book.bookCode asc");
      return getZormTemplate().find(localStringBuffer.toString(), localArrayList.toArray());
    }
    return null;
  }
  
  public Map findVoucherByBookCode(EvsVoucherBookPackage paramEvsVoucherBookPackage, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append("from EvsVoucherV vou where vou.voucherId in (select hbp.voucherId from EvsVoucherBookPackage hbp where hbp.bookId = " + paramEvsVoucherBookPackage.getBookId() + ") order by vou.journalNum asc");
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1 / paramInt2 + 1, paramInt2, localArrayList.toArray());
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", localPageInfo.getResult());
    localHashMap.put("totalCount", Long.valueOf(localPageInfo.getTotalCount()));
    return localHashMap;
  }
  
  public Map findAttachmentByVoucherId(EvsVoucher paramEvsVoucher, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append("from EvsAttachment att where att.voucherId = " + paramEvsVoucher.getVoucherId() + "");
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1 / paramInt2 + 1, paramInt2, localArrayList.toArray());
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", localPageInfo.getResult());
    localHashMap.put("totalCount", Long.valueOf(localPageInfo.getTotalCount()));
    return localHashMap;
  }
  
  public Map findBookByStatus(String paramString, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append("from EvsBookV bo where 1=1");
    localStringBuffer.append(" and bo.bookStatus in ('BOOKED','UNPACKAG')");
    localStringBuffer.append(" and bo.operateUserId is null order by bo.bookCode asc");
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1 / paramInt2 + 1, paramInt2, localArrayList.toArray());
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", localPageInfo.getResult());
    localHashMap.put("totalCount", Long.valueOf(localPageInfo.getTotalCount()));
    return localHashMap;
  }
  
  public Map findAllBook(EvsBookModel paramEvsBookModel, int paramInt1, int paramInt2)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append("from EvsBookV bo where 1=1");
    if (!Util.isStrEmpty(paramEvsBookModel.getCompanyName())) {
      localStringBuffer.append(" and bo.companyName like '%" + paramEvsBookModel.getCompanyName() + "%'");
    }
    if (!Util.isStrEmpty(paramEvsBookModel.getPeriodName())) {
      localStringBuffer.append(" and bo.periodName = '" + paramEvsBookModel.getPeriodName() + "'");
    }
    if (!Util.isStrEmpty(localEasUserInfo.getUserInfoPk().toString())) {
      localStringBuffer.append(" and exists(from FbpPseRelationsV f where f.companyId=bo.companyId and f.employeeId = " + localEasUserInfo.getUserInfoPk().toString() + ")");
    } else {
      localStringBuffer.append(" and exists(from FbpPseRelationsV f where f.companyId=bo.companyId and f.employeeId = '000' )");
    }
    if (!Util.isStrEmpty(paramEvsBookModel.getBookCode())) {
      localStringBuffer.append(" and bo.bookCode = '" + paramEvsBookModel.getBookCode() + "'");
    }
    localStringBuffer.append(" and bo.bookStatus in ('BOOKED','UNPACKAG','ALREADY_RECEIVE','NOT_RECEIVE')");
    localStringBuffer.append(" and bo.operateUserId is null order by bo.bookCode asc");
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1 / paramInt2 + 1, paramInt2, localArrayList.toArray());
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", localPageInfo.getResult());
    localHashMap.put("totalCount", Long.valueOf(localPageInfo.getTotalCount()));
    return localHashMap;
  }
  
  public Map getBookByBookStatus(EvsBookModel paramEvsBookModel, int paramInt1, int paramInt2)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append("from EvsBookV bo where 1=1 and ( 1=1 ");
    if (!Util.isStrEmpty(paramEvsBookModel.getCompanyName())) {
      localStringBuffer.append(" and bo.companyName like '%" + paramEvsBookModel.getCompanyName() + "%'");
    }
    if (!Util.isStrEmpty(paramEvsBookModel.getPeriodName())) {
      localStringBuffer.append(" and bo.periodName = '" + paramEvsBookModel.getPeriodName() + "'");
    }
    if (localEasUserInfo != null) {
      localStringBuffer.append(" and bo.operateUserId = '" + localEasUserInfo.getUserInfoPk().toString() + "' ");
    } else {
      localStringBuffer.append(" and bo.operateUserId = '" + "USERID" + "'");
    }
    if (!Util.isStrEmpty(paramEvsBookModel.getPackageId())) {
      localStringBuffer.append(" or bo.packageId = " + paramEvsBookModel.getPackageId());
    }
    localStringBuffer.append(") and bo.bookStatus in ('BOOKED','UNPACKAG','ALREADY_RECEIVE','NOT_RECEIVE')");
    localStringBuffer.append(" order by bo.bookCode asc");
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1 / paramInt2 + 1, paramInt2, localArrayList.toArray());
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", localPageInfo.getResult());
    localHashMap.put("totalCount", Long.valueOf(localPageInfo.getTotalCount()));
    return localHashMap;
  }
  
  public Map findBookByNumber(String paramString, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append("from EvsBook bo where 1=1 and bo.bookStatus in ('BOOKED','UNPACKAG')");
    localStringBuffer.append(" and bo.bookCode in " + paramString + "");
    localStringBuffer.append(" order by bo.bookCode asc");
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1 / paramInt2 + 1, paramInt2, localArrayList.toArray());
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", localPageInfo.getResult());
    localHashMap.put("totalCount", Long.valueOf(localPageInfo.getTotalCount()));
    return localHashMap;
  }
  
  public Map getBookByBookCode(String paramString, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append("from EvsBookV bo where bo.bookStatus = 'BOOKED' and bo.bookCode in " + paramString + "");
    localStringBuffer.append(" order by bo.bookCode asc");
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1 / paramInt2 + 1, paramInt2, localArrayList.toArray());
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", localPageInfo.getResult());
    localHashMap.put("totalCount", Long.valueOf(localPageInfo.getTotalCount()));
    return localHashMap;
  }
  
  public Map getVoucherByVoucherCode(String paramString, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append("from EvsVoucherV bo where bo.journalNum in " + paramString + "");
    localStringBuffer.append(" order by bo.journalNum asc");
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1 / paramInt2 + 1, paramInt2, localArrayList.toArray());
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", localPageInfo.getResult());
    localHashMap.put("totalCount", Long.valueOf(localPageInfo.getTotalCount()));
    return localHashMap;
  }
  
  public void updateStatusByPackage(String paramString1, String paramString2, String paramString3)
  {
    log.debug("update EvsBook bookStatus");
    try
    {
      String str = "update evs_book set package_id =" + paramString2 + " ,book_status = '" + paramString3 + "' where book_status='BOOKED' and book_code in " + paramString1 + "";
      getSession().createSQLQuery(str).executeUpdate();
      log.error("update bookStatus By bookCode");
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("update failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public void updateStatusByBook(String paramString1, String paramString2)
  {
    log.debug("update EvsBook bookStatus");
    try
    {
      String str = "update evs_book set book_status = '" + paramString2 + "' where book_code in ('" + paramString1 + "')";
      getSession().createSQLQuery(str).executeUpdate();
      log.error("update bookStatus By bookCode");
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("update failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public void updateStatusByBookId(String paramString1, String paramString2)
  {
    log.debug("update EvsBook bookStatus");
    try
    {
      String str = "update evs_book set book_status = '" + paramString2 + "' where book_id in (" + paramString1 + ")";
      getSession().createSQLQuery(str).executeUpdate();
      log.error("update bookStatus By book_id");
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("update failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public void updateVoucherBookPackageByPackageId(String paramString1, String paramString2)
  {
    log.debug("update VoucherBookPackage packageId");
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      localStringBuffer.append("update Evs_Voucher_Book_Package set package_id = " + paramString1 + " where book_id in");
      localStringBuffer.append(" (select book_id from evs_book where book_status ='PACKAGED' and book_code in " + paramString2 + ")");
      getSession().createSQLQuery(localStringBuffer.toString()).executeUpdate();
      log.error("update VoucherBookPackage By packageId");
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("update failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public void updateVoucherStatusByBookCode(String paramString)
  {
    log.debug("update Voucher BookCode");
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      localStringBuffer.append("update Evs_Voucher set voucher_status = 'PACKAGED_NO_INCOME' where voucher_id in");
      localStringBuffer.append(" (select voucher_id from Evs_Voucher_Book_Package where book_id in " + paramString + ")");
      getSession().createSQLQuery(localStringBuffer.toString()).executeUpdate();
      log.error("update voucherStatus By packageId");
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("update failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public void updateVoucherOnPackaged(String paramString)
  {
    log.debug("update Voucher BookCode");
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      localStringBuffer.append("update Evs_Voucher set voucher_status = 'BOOKED_NO_BOX' where voucher_id in");
      localStringBuffer.append(" (select voucher_id from Evs_Voucher_Book_Package where book_id in " + paramString + ")");
      getSession().createSQLQuery(localStringBuffer.toString()).executeUpdate();
      log.error("update voucherStatus By packageId");
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("update failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public void updateReturnStatus(String paramString)
  {
    log.debug("update EvsBook BookCode");
    try
    {
      String str = "update evs_book set operate_user_id = '' where book_status='BOOKED' and book_code in " + paramString + "";
      getSession().createSQLQuery(str).executeUpdate();
      log.error("update voucherStatus By operateUserId");
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("update failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public void updateStatus(String paramString1, String paramString2)
  {
    log.debug("update EvsBook BookCode");
    try
    {
      String str = "update evs_book set operate_user_id = '" + paramString2 + "' where book_status = 'BOOKED' and book_code in " + paramString1 + "";
      getSession().createSQLQuery(str).executeUpdate();
      log.error("update voucherStatus By operateUserId");
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("update failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public void updateBookStatusByCode(String paramString1, String paramString2)
  {
    log.debug("update EvsBook BookCode");
    try
    {
      String str = "update evs_book set operate_user_id = '" + paramString2 + "' where book_status='BOOKED' and book_code = '" + paramString1 + "'";
      getSession().createSQLQuery(str).executeUpdate();
      log.error("update voucherStatus By operateUserId");
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("update failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public void updatePackageStatusById(String paramString1, String paramString2)
  {
    log.debug("update EvsPackage packageId");
    try
    {
      String str = "update evs_package set package_status = '" + paramString2 + "' where package_id = '" + paramString1 + "'";
      getSession().createSQLQuery(str).executeUpdate();
      log.error("update EvsPackage By packageId");
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("update failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public void updateStatusByPackageCode(String paramString1, String paramString2)
  {
    log.debug("update EvsPackage packageStatus");
    try
    {
      String str = "update evs_package set package_status = '" + paramString2 + "' where package_code = '" + paramString1 + "'";
      getSession().createSQLQuery(str).executeUpdate();
      log.error("update packageStatus By packageCode");
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("update failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public void updateStatusByPackageId(String paramString1, String paramString2)
  {
    log.debug("update EvsPackage packageStatus");
    try
    {
      String str = "update evs_package set package_status = '" + paramString2 + "' where package_id =" + paramString1;
      getSession().createSQLQuery(str).executeUpdate();
      log.error("update packageStatus By packageId");
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("update failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public void updateBookStatusByPackageId(String paramString1, String paramString2)
  {
    log.debug("update EvsBook bookStatus");
    String str = null;
    try
    {
      if (!Util.isStrEmpty(paramString1.toString())) {
        str = "update evs_book set book_status = '" + paramString2 + "',package_id = " + Long.parseLong(paramString1.toString());
      }
      getSession().createSQLQuery(str).executeUpdate();
      log.error("update bookStatus By packageId");
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("update failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public void updateBookStatusByPackageIdNew(String paramString1, String paramString2)
  {
    log.debug("update EvsBook bookStatus");
    String str = null;
    try
    {
      if (!Util.isStrEmpty(paramString1.toString())) {
        str = "update evs_book set book_status = '" + paramString2 + "' where book_status='BOOKED' and book_code in (select book_code from evs_book where package_id = " + Long.parseLong(paramString1.toString()) + ")";
      }
      getSession().createSQLQuery(str).executeUpdate();
      log.error("update bookStatus By packageId");
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("update failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public String updateStatusByBookCode(EvsBookModel paramEvsBookModel, String paramString)
  {
    String str1 = "";
    log.debug("update EvsBook bookStatus");
    String str2 = null;
    try
    {
      if (!Util.isStrEmpty(paramEvsBookModel.getBookCode())) {
        str2 = "update evs_book set book_status = '" + paramString + "' where book_code = '" + paramEvsBookModel.getBookCode() + "'";
      }
      getSession().createSQLQuery(str2).executeUpdate();
      log.error("update bookStatus By bookCode");
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
    log.debug("update EvsBook packageId");
    String str = null;
    try
    {
      str = "update evs_book set package_id = '" + paramEvsBook.getPackageId() + "' where book_status='BOOKED' and book_code = " + paramEvsBook.getBookCode() + "";
      getSession().createSQLQuery(str).executeUpdate();
      log.error("update packageId By bookCode");
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("update failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public void savePackage(EvsPackage paramEvsPackage)
  {
    log.debug("saving EvsPackage instance");
    try
    {
      getSession().save(paramEvsPackage);
      log.debug("save successful");
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("save failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public void saveVoucherBookPackage(EvsVoucherBookPackage paramEvsVoucherBookPackage)
  {
    log.debug("saving EvsVoucherBookPackage instance");
    try
    {
      getSession().save(paramEvsVoucherBookPackage);
      log.debug("save successful 增加关联信息");
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("save EvsVoucherBookPackage Exception", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public EvsPackage getPackageByCode(EvsPackageModel paramEvsPackageModel)
  {
    log.debug("select EvsPackage");
    String str = null;
    EvsPackage localEvsPackage = null;
    try
    {
      if (!Util.isStrEmpty(paramEvsPackageModel.getPackageCode())) {
        str = "from EvsPackage pag where pag.packageCode = '" + paramEvsPackageModel.getPackageCode() + "'";
      }
      List localList = getSession().createQuery(str).list();
      localEvsPackage = localList.size() > 0 ? (EvsPackage)localList.get(0) : null;
      log.debug("select EvsPackage By packageCode");
      return localEvsPackage;
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("select failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public EvsPackage getPackageById(EvsPackageModel paramEvsPackageModel)
  {
    EvsPackage localEvsPackage = null;
    String str = null;
    log.debug("select EvsPackage");
    try
    {
      if (!Util.isStrEmpty(paramEvsPackageModel.getPackageId().toString())) {
        str = "from EvsPackage pag where pag.packageId = '" + paramEvsPackageModel.getPackageId() + "'";
      }
      List localList = getSession().createQuery(str).list();
      localEvsPackage = localList.size() > 0 ? (EvsPackage)localList.get(0) : null;
      log.debug("select EvsPackage By packageId");
      return localEvsPackage;
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("select failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public EvsPackage getPackageById(Long paramLong)
  {
    EvsPackage localEvsPackage = null;
    String str = null;
    log.debug("select EvsPackage");
    try
    {
      if (!Util.isStrEmpty(paramLong.toString())) {
        str = "from EvsPackage pag where pag.packageId = '" + paramLong + "'";
      }
      List localList = getSession().createQuery(str).list();
      localEvsPackage = localList.size() > 0 ? (EvsPackage)localList.get(0) : null;
      log.debug("select EvsPackage By packageId");
      return localEvsPackage;
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("select failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public List<Object[]> getPackageMsg(Long paramLong)
  {
    String str = null;
    log.debug("select EvsPackage");
    try
    {
      if (!Util.isStrEmpty(paramLong.toString())) {
        str = "select ep.package_code,ep.warehouse_code,ev.journal_num,ev.invoice_type from evs.evs_voucher_book_package evbp, evs.evs_package              ep, evs.evs_voucher              ev where evbp.package_id = ep.package_id and evbp.voucher_id = ev.voucher_id and evbp.package_id = '" + paramLong + "'";
      }
      List localList = getSession().createSQLQuery(str).list();
      log.debug("select EvsPackage By packageId");
      return localList;
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("select failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public List<Object[]> getBookMsg(Long paramLong)
  {
    String str = null;
    log.debug("select EvsPackage");
    try
    {
      if (!Util.isStrEmpty(paramLong.toString())) {
        str = "select eb.book_code,ev.journal_num,ev.invoice_type from evs.evs_voucher_book_package evbp, evs.evs_book                 eb, evs.evs_voucher              ev where  evbp.book_id = eb.book_id and evbp.voucher_id = ev.voucher_id and evbp.book_id = '" + paramLong + "'";
      }
      List localList = getSession().createSQLQuery(str).list();
      log.debug("select evsbook By book_id");
      return localList;
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("select failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public EvsBook getBookByCode(EvsBookModel paramEvsBookModel)
  {
    EvsBook localEvsBook = null;
    log.debug("selecet EvsBook");
    String str = "select distinct bo from EvsBook bo where 1=1 ";
    try
    {
      if (!Util.isStrEmpty(paramEvsBookModel.getBookCode())) {
        str = "and bo.bookStatus='BOOKED' and bo.bookCode = '" + paramEvsBookModel.getBookCode().trim() + "'";
      }
      List localList = getSession().createQuery(str).list();
      if (localList != null) {
        localEvsBook = localList.size() > 0 ? (EvsBook)localList.get(0) : null;
      }
      log.debug("select EvsBook By bookCode");
      return localEvsBook;
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("select failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public EvsBookV getBookVByCode(String paramString1, String paramString2)
  {
    EvsBookV localEvsBookV = null;
    log.debug("selecet EvsBookV");
    String str = "select bo from EvsBookV bo where 1=1 ";
    try
    {
      if (!Util.isStrEmpty(paramString1)) {
        str = str + " and bo.bookCode = '" + paramString1 + "'";
      }
      if (!Util.isStrEmpty(paramString2)) {
        str = str + " and bo.bookStatus= '" + paramString2 + "'";
      }
      List localList = getSession().createQuery(str).list();
      if (localList != null) {
        localEvsBookV = localList.size() > 0 ? (EvsBookV)localList.get(0) : null;
      }
      log.debug("select EvsBookV By bookCode");
      return localEvsBookV;
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("select failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public List<EvsBookV> getBookVByCodeList(String paramString1, String paramString2)
  {
    Object localObject = null;
    log.debug("selecet EvsBookV");
    String str = "select bo from EvsBookV bo where 1=1 ";
    try
    {
      if (!Util.isStrEmpty(paramString1)) {
        str = str + " and bo.bookCode in(" + paramString1 + ")";
      }
      if (!Util.isStrEmpty(paramString2)) {
        str = str + " and bo.bookStatus= '" + paramString2 + "'";
      }
      List localList = getSession().createQuery(str).list();
      return localList;
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("select failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public EvsBook getBookById(EvsBook paramEvsBook)
  {
    log.debug("selecet EvsBook");
    EvsBook localEvsBook = null;
    String str = null;
    try
    {
      if ((!Util.isStrEmpty(paramEvsBook.getBookId().toString())) && (!"0".equals(paramEvsBook.getBookId().toString()))) {
        str = "from EvsBook bo where bo.bookId = " + Long.parseLong(paramEvsBook.getBookId().toString()) + "";
      }
      List localList = getSession().createQuery(str).list();
      localEvsBook = localList.size() > 0 ? (EvsBook)localList.get(0) : null;
      log.debug("select EvsBook By bookId");
      return localEvsBook;
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("select failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public List getVoucherById(String paramString)
  {
    log.debug("select EvsVoucherBookPackage");
    String str = null;
    try
    {
      str = "select distinct(voucher_id) from Evs_Voucher_Book_Package evsV where evsV.book_Id in " + paramString + " group by voucher_id ";
      List localList = getSession().createSQLQuery(str).list();
      log.debug("select EvsVoucherBookPackage By bookId");
      return localList;
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("select failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public List getBookByBookIds(String paramString)
  {
    log.debug("selecet EvsBook");
    String str = null;
    try
    {
      str = "select * from evs_book bo where bo.book_Id in " + paramString + "";
      List localList = getSession().createSQLQuery(str).list();
      log.debug("select EvsBook By bookId");
      return localList;
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("select failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public List getBookByBookId(String paramString)
  {
    log.debug("selecet EvsBook");
    String str = null;
    try
    {
      str = "select distinct(book_id) from evs_book bo where bo.book_Id in " + paramString + "";
      List localList = getSession().createSQLQuery(str).list();
      log.debug("select EvsBook By bookId");
      return localList;
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("select failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public List<EvsBook> getBookStatusByBookCode(String paramString)
  {
    log.debug("selecet EvsBook");
    String str = null;
    try
    {
      str = "from EvsBook bo where bo.bookStatus='BOOKED' and bo.bookCode in " + paramString + "";
      List localList = getSession().createQuery(str).list();
      log.debug("select EvsBook By bookId");
      return localList;
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("select failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public List<EvsBook> getBookByPackageId(String paramString)
  {
    log.debug("selecet EvsBook");
    String str = null;
    try
    {
      str = "from EvsBook bo where bo.packageId = " + paramString + "";
      List localList = getSession().createQuery(str).list();
      log.debug("select EvsBook By bookId");
      return localList;
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("select failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public String getGenerarionNmber(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    str1 = "";
    Session localSession = getSession();
    Connection localConnection = localSession.connection();
    CallableStatement localCallableStatement = null;
    try
    {
      localCallableStatement = localConnection.prepareCall("{call EVS_GENERATION_NUMBER_PKG.get_generation_number(?,?,?,?,?,?,?,?,?)}");
      String str2 = "";
      String str3 = "";
      if (paramString1 != null)
      {
        String[] arrayOfString = paramString1.split("#");
        if ((arrayOfString != null) && (arrayOfString.length == 2))
        {
          str2 = arrayOfString[0];
          str3 = arrayOfString[1];
        }
      }
      localCallableStatement.setString(1, "");
      localCallableStatement.setString(2, paramString2);
      localCallableStatement.setString(3, paramString3);
      localCallableStatement.setString(4, paramString4);
      localCallableStatement.setString(5, paramString5);
      localCallableStatement.setString(6, paramString6);
      localCallableStatement.setString(7, str3);
      localCallableStatement.setString(8, str2);
      localCallableStatement.registerOutParameter(9, 12);
      localCallableStatement.execute();
      str1 = localCallableStatement.getString(9);
      localCallableStatement.close();
      localConnection.close();
      return str1;
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
    finally
    {
      try
      {
        if (localCallableStatement != null)
        {
          localCallableStatement.close();
          localCallableStatement = null;
        }
        if (localConnection != null)
        {
          localConnection.close();
          localConnection = null;
        }
      }
      catch (Exception localException4)
      {
        localException4.printStackTrace();
      }
    }
  }
  
  public String getGenerarionAllotNmber(String paramString)
  {
    str = "";
    Session localSession = getSession();
    Connection localConnection = localSession.connection();
    CallableStatement localCallableStatement = null;
    try
    {
      localCallableStatement = localConnection.prepareCall("{call EVS_GENERATION_NUMBER_PKG.get_archives_number(?,?)}");
      localCallableStatement.setString(1, paramString);
      localCallableStatement.registerOutParameter(2, 12);
      localCallableStatement.execute();
      str = localCallableStatement.getString(2);
      localCallableStatement.close();
      localConnection.close();
      return str;
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
    finally
    {
      try
      {
        if (localCallableStatement != null)
        {
          localCallableStatement.close();
          localCallableStatement = null;
        }
        if (localConnection != null)
        {
          localConnection.close();
          localConnection = null;
        }
      }
      catch (Exception localException4)
      {
        localException4.printStackTrace();
      }
    }
  }
  
  public String getGenerarionAllotNmber()
  {
    str = "";
    Session localSession = getSession();
    Connection localConnection = localSession.connection();
    CallableStatement localCallableStatement = null;
    try
    {
      localCallableStatement = localConnection.prepareCall("{call EVS_GENERATION_NUMBER_PKG.get_generation_allot_number(?)}");
      localCallableStatement.registerOutParameter(1, 12);
      localCallableStatement.execute();
      str = localCallableStatement.getString(1);
      localCallableStatement.close();
      localConnection.close();
      return str;
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
    finally
    {
      try
      {
        if (localCallableStatement != null)
        {
          localCallableStatement.close();
          localCallableStatement = null;
        }
        if (localConnection != null)
        {
          localConnection.close();
          localConnection = null;
        }
      }
      catch (Exception localException4)
      {
        localException4.printStackTrace();
      }
    }
  }
  
  public void saveBook(String paramString)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    log.debug("update EvsBook book");
    try
    {
      String str;
      if (localEasUserInfo != null)
      {
        str = " update evs_book set LAST_UPDATE_DATE = sysdate ,LAST_UPDATE_BY = " + localEasUserInfo.getUserInfoPk() + " ,LAST_UPDATE_LOGIN = " + localEasUserInfo.getUserInfoPk() + " where book_id = " + paramString + "";
        getSession().createSQLQuery(str).executeUpdate();
        log.debug("update successful");
      }
      else
      {
        str = " update evs_book set LAST_UPDATE_DATE = sysdate ,LAST_UPDATE_BY = 0 ,LAST_UPDATE_LOGIN = 0 where book_id = " + paramString + "";
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
  
  public void savePackageInfo(String paramString)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    log.debug("update EvsPackage book");
    try
    {
      String str;
      if (localEasUserInfo != null)
      {
        str = " update evs_package set LAST_UPDATE_DATE = sysdate ,LAST_UPDATE_BY = " + localEasUserInfo.getUserInfoPk() + " ,LAST_UPDATE_LOGIN = " + localEasUserInfo.getUserInfoPk() + " where package_id = " + paramString + "";
        getSession().createSQLQuery(str).executeUpdate();
        log.debug("update successful");
      }
      else
      {
        str = " update evs_package set LAST_UPDATE_DATE = sysdate ,LAST_UPDATE_BY = 0 ,LAST_UPDATE_LOGIN = 0 where package_id in " + paramString + "";
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
  
  public String getPeriodName()
  {
    log.debug("selecet PeriodName");
    String str = null;
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      localStringBuffer.append("select period_name ,to_char(start_date,'yymm') period_date,period_year from FBP_PERIODS t where period_type = '22'");
      localStringBuffer.append(" and t.start_date <= to_date(to_char(add_months(sysdate, -1), 'yyyy-mm-dd'), 'yyyy-mm-dd')");
      localStringBuffer.append(" and t.end_date >= to_date(to_char(add_months(sysdate, -1), 'yyyy-mm-dd'), 'yyyy-mm-dd')");
      List localList = getSession().createSQLQuery(localStringBuffer.toString()).list();
      if ((localList != null) && (localList.size() > 0))
      {
        Object[] arrayOfObject = (Object[])localList.get(0);
        if ((arrayOfObject != null) && (arrayOfObject.length > 0))
        {
          str = arrayOfObject[0].toString() + "," + arrayOfObject[1].toString() + "," + arrayOfObject[2].toString();
          System.out.println("pName===============" + str);
        }
      }
      log.debug("select PeriodName");
      return str;
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("select failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public String getCompanyName()
  {
    String str = "";
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    StringBuffer localStringBuffer = new StringBuffer();
    log.debug("selecet CompanyName");
    try
    {
      if (localEasUserInfo != null) {
        localStringBuffer.append("SELECT fd.Attribute7,ct.company_name,fc.company_code FROM fbp.fbp_employees fe, fbp.fbp_depts fd,fbp.fbp_company_tl ct,fbp.fbp_company fc WHERE fe.dept_id=fd.dept_id AND ct.company_id=fd.attribute7  AND ct.language=ZAS_ENV_PKG.getLang()  AND ct.company_id=fc.company_id  AND fe.employee_id=" + localEasUserInfo.getUserInfoPk());
      }
      List localList = getSession().createSQLQuery(localStringBuffer.toString()).list();
      if ((localList != null) && (localList.size() > 0))
      {
        Object[] arrayOfObject = (Object[])localList.get(0);
        if ((arrayOfObject != null) && (arrayOfObject.length > 0)) {
          str = arrayOfObject[0].toString() + "," + arrayOfObject[1].toString() + "," + arrayOfObject[2].toString();
        }
      }
      log.debug("select PeriodName");
      return str;
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("select failed", localRuntimeException);
      localRuntimeException.printStackTrace();
      throw localRuntimeException;
    }
  }
  
  public String getSetBookOrgId()
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    log.debug("selecet SetBookOrgId");
    String str = null;
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      if (localEasUserInfo != null) {
        localStringBuffer.append("select o.SET_OF_BOOKS_NAME as ERP_ORG_ID,l.meaning SET_OF_BOOKS_NAME, c.ERP_ORG_ID as ORG_ID,c.CHECK_UNIT_NAME as CHECK_UNIT_NAME from FBP_CHECK_UNIT_CONTENTS c, FBP_ORGANIZATION_UNITS o ,fbp_lookup_values l where c.ENABLED_FLAG = 'Y' and o.ENABLED_FLAG='Y' and o.ORG_ID=" + localEasUserInfo.getOrgId() + " and c.ERP_ORG_ID = o.ORG_ID  and l.lookup_code=o.set_of_books_name " + "and l.lookup_type='EVS_SET_OF_BOOK'  order by c.CONTENT_ID");
      } else {
        localStringBuffer.append("select o.SET_OF_BOOKS_NAME as ERP_ORG_ID,l.meaning SET_OF_BOOKS_NAME, c.ERP_ORG_ID as ORG_ID,c.CHECK_UNIT_NAME as CHECK_UNIT_NAME from FBP_CHECK_UNIT_CONTENTS c, FBP_ORGANIZATION_UNITS o ,fbp_lookup_values l where c.ENABLED_FLAG = 'Y' and o.ENABLED_FLAG='Y' and o.ORG_ID=82 and c.ERP_ORG_ID = o.ORG_ID  and l.lookup_code=o.set_of_books_name and l.lookup_type='EVS_SET_OF_BOOK'  order by c.CONTENT_ID");
      }
      List localList = getSession().createSQLQuery(localStringBuffer.toString()).list();
      if ((localList != null) && (localList.size() > 0))
      {
        Object[] arrayOfObject = (Object[])localList.get(0);
        if ((arrayOfObject != null) && (arrayOfObject.length > 0)) {
          str = arrayOfObject[0].toString() + "," + arrayOfObject[1].toString() + "," + arrayOfObject[2].toString() + "," + arrayOfObject[3].toString();
        }
      }
      log.debug("select PeriodName");
      return str;
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("select failed", localRuntimeException);
      localRuntimeException.printStackTrace();
      throw localRuntimeException;
    }
  }
  
  public EvsPackageV getPackageByPackageCode(String paramString)
  {
    log.debug("selecet PeriodName");
    EvsPackageV localEvsPackageV = null;
    String str = null;
    try
    {
      if ((paramString != null) && (!"".equals(paramString))) {
        str = "from EvsPackageV pagv where pagv.packageCode = '" + paramString.trim() + "'";
      }
      List localList = getSession().createQuery(str).list();
      localEvsPackageV = localList.size() > 0 ? (EvsPackageV)localList.get(0) : null;
      log.debug("select PeriodName");
      return localEvsPackageV;
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("select failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public EvsVoucherV getVoucherByJournalNum(String paramString)
  {
    log.debug("selecet PeriodName");
    EvsVoucherV localEvsVoucherV = null;
    String str = null;
    try
    {
      if ((paramString != null) && (!"".equals(paramString))) {
        str = "from EvsVoucherV pagv where pagv.journalNum = '" + paramString.trim() + "'";
      }
      List localList = getSession().createQuery(str).list();
      localEvsVoucherV = localList.size() > 0 ? (EvsVoucherV)localList.get(0) : null;
      log.debug("select PeriodName");
      return localEvsVoucherV;
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("select failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public PageInfo getPackageByPackageId(String[] paramArrayOfString, String paramString, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer("from EvsPackageV pk where 1=1");
    ArrayList localArrayList = new ArrayList();
    PageInfo localPageInfo = new PageInfo();
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      String str1 = "";
      for (String str2 : paramArrayOfString) {
        if ((str2 != null) && (!"null".equals(str2)) && (!"".equals(str2))) {
          str1 = str1 + str2 + ",";
        }
      }
      if (!"".equals(str1))
      {
        str1 = str1.substring(0, str1.length() - 1);
        if ("FLITTING".equals(paramString)) {
          localStringBuffer.append(" and pk.packageStatus in ('PACKAGED','WAREHOUSE')");
        }
        localStringBuffer.append(" and pk.packageId  in(" + str1 + ")");
        localStringBuffer.append(" order by pk.packageDate desc");
        localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1 / paramInt2 + 1, paramInt2, localArrayList.toArray());
      }
    }
    return localPageInfo;
  }
  
  public String getDocTypeById()
  {
    log.debug("selecet EvsDocType");
    String str1 = null;
    String str2 = null;
    try
    {
      str2 = "select doc_code,doc_name from evs_doc_type where rownum<=1";
      List localList = getSession().createSQLQuery(str2).list();
      if ((localList != null) && (localList.size() > 0))
      {
        Object[] arrayOfObject = (Object[])localList.get(0);
        if ((arrayOfObject != null) && (arrayOfObject.length > 0)) {
          str1 = arrayOfObject[0].toString() + "," + arrayOfObject[1].toString();
        }
      }
      log.debug("select PeriodName");
      return str1;
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("select failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public String findBookByIsBookStatus(String paramString)
  {
    log.debug("selecet BookStatus");
    String str1 = null;
    String str2 = null;
    try
    {
      str2 = "select COUNT(*) from evs_book where book_code in " + paramString + " and book_status != '" + "PACKAGED" + "'";
      List localList = getSession().createSQLQuery(str2).list();
      if ((localList != null) && (localList.size() > 0)) {
        str1 = localList.get(0).toString();
      }
      log.debug("select BookStatus");
      return str1;
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("select failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public String getDateByPeriodName(String paramString)
  {
    String str1 = null;
    String str2 = "select to_char(start_date, 'yyyy-mm') period_date from FBP_PERIODS t where period_name = '" + paramString + "'";
    List localList = getSession().createSQLQuery(str2).list();
    if ((localList != null) && (localList.size() > 0)) {
      str1 = localList.get(0).toString();
    }
    System.out.println("outNum=====" + str1);
    return str1;
  }
  
  public void updateVoucherStatusByBookCodeNew(String paramString1, String paramString2)
  {
    log.debug("update Voucher BookCode");
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      localStringBuffer.append("update Evs_Voucher set voucher_status = '" + paramString2 + "' where voucher_id in");
      localStringBuffer.append(" (select voucher_id from Evs_Voucher_Book_Package where book_id in " + paramString1 + ")");
      getSession().createSQLQuery(localStringBuffer.toString()).executeUpdate();
      log.error("update voucherStatus By packageId");
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("update failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public List<String> findIdByBoxCode(String paramString)
  {
    String str = "SELECT PK.PACKAGE_ID FROM EVS_PACKAGE PK WHERE PK.PACKAGE_CODE IN (" + paramString + ")";
    return super.getSession().createSQLQuery(str).list();
  }
  
  public PageInfo findBookByIds(String[] paramArrayOfString, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfString == null) && (paramArrayOfString.length < 1)) {
      return new PageInfo();
    }
    String str1 = fmtList(paramArrayOfString, null);
    String str2 = "FROM EvsBookV eb WHERE eb.bookId IN(" + str1 + ")";
    if ("FLITTING".equals(paramString)) {
      str2 = str2 + " and eb.bookStatus in ('BOOKED','UNPACKAG','ALREADY_RECEIVE','NOT_RECEIVE')";
    } else if ("RECEIVE".equals(paramString)) {
      str2 = str2 + " AND eb.bookStatus in('ALREADY_FLITTING')";
    }
    return super.PageInfoQuery(str2, paramInt1 / paramInt2 + 1, paramInt2, null);
  }
  
  public String fmtList(String[] paramArrayOfString, String paramString)
  {
    String str1 = "";
    paramString = paramString == null ? "" : paramString;
    paramString = !paramString.equals("'") ? "" : paramString;
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      for (int i = 0; i < paramArrayOfString.length; i++)
      {
        String str2 = paramArrayOfString[i];
        String str3 = str2 == null ? "-1" : str2.toString().trim();
        if (!Util.isStrEmpty(str3)) {
          str1 = str1 + paramString + str3 + paramString + ",";
        }
      }
      if (!Util.isStrEmpty(str1)) {
        str1 = str1.substring(0, str1.length() - 1);
      }
    }
    return str1;
  }
  
  public List<EvsBookV> findBookByCodeNew(EvsPackageV paramEvsPackageV, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    Object localObject = new ArrayList();
    localStringBuffer.append("from EvsBookV book where 1=1");
    if (paramEvsPackageV != null) {
      localStringBuffer.append(" and book.packageId=" + paramEvsPackageV.getPackageId());
    }
    if (!Util.isStrEmpty(paramString)) {
      localStringBuffer.append(" and book.bookStatus in ('" + paramString + "')");
    }
    localObject = super.getSession().createQuery(localStringBuffer.toString()).list();
    return localObject;
  }
  
  public List<EvsVoucherV> findVoucherByBookCodeNwe(EvsBookV paramEvsBookV)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject = new ArrayList();
    if (paramEvsBookV.getBookCode() != null) {
      localStringBuffer.append("from EvsVoucherV vou where vou.voucherId in (select hbp.voucherId from EvsVoucherBookPackage hbp where hbp.bookId in ( select eb.bookId from EvsBook eb where eb.bookCode ='" + paramEvsBookV.getBookCode() + "')) order by vou.journalNum asc");
    } else {
      localStringBuffer.append("from EvsVoucherV vou where vou.voucherId in (select hbp.voucherId from EvsVoucherBookPackage hbp where hbp.bookId = " + paramEvsBookV.getBookId() + ") order by vou.journalNum asc");
    }
    localObject = super.getSession().createQuery(localStringBuffer.toString()).list();
    return localObject;
  }
  
  public List<EvsImage> findImageNumByVoucherId(String paramString)
  {
    String str = "from EvsImage mg where mg.voucherId in (" + paramString + ")";
    List localList = super.getSession().createQuery(str).list();
    return localList;
  }
  
  public List<String> findEvsBookCodeVByBookCode(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    Object localObject = new ArrayList();
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("select bo.bookCode from EvsBook bo where bo.bookStatus='WAREHOUSE' ");
    String str1 = fmtList(paramArrayOfString1, "'");
    String str2 = fmtList(paramArrayOfString2, "'");
    if (!Util.isStrEmpty(str1)) {
      if ("isIncould".equals(paramString)) {
        localStringBuffer.append(" and bo.bookCode in(" + str1 + ")");
      } else {
        localStringBuffer.append(" and bo.bookCode not in(" + str1 + ")");
      }
    }
    localObject = super.getZormTemplate().find(localStringBuffer.toString());
    return localObject;
  }
  
  public List findAllBookCode(EvsBook paramEvsBook)
  {
    StringBuffer localStringBuffer = new StringBuffer("select distinct bo.bookCode from EvsBook bo where 1=1 ");
    List localList = findRelationIdByAllotNum(paramEvsBook.getBookId());
    String str = fmtList(localList, null);
    if ((str != null) && (!"".equals(str))) {
      localStringBuffer.append(" and bo.bookId in (" + str + ")");
    } else {
      localStringBuffer.append(" and 1=2");
    }
    return super.getZormTemplate().find(localStringBuffer.toString());
  }
  
  public List findAllBookID(EvsBook paramEvsBook)
  {
    StringBuffer localStringBuffer = new StringBuffer("select distinct bo.bookId from EvsBook bo where 1=1 ");
    List localList = findRelationIdByAllotNum(paramEvsBook.getBookId());
    String str = fmtList(localList, null);
    if ((str != null) && (!"".equals(str))) {
      localStringBuffer.append(" and bo.bookId in (" + str + ")");
    } else {
      localStringBuffer.append(" and 1=2");
    }
    return super.getZormTemplate().find(localStringBuffer.toString());
  }
  
  public PageInfo findAllBookNew(EvsBookModel paramEvsBookModel, int paramInt1, int paramInt2, String[] paramArrayOfString, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append("select bo from EvsBookV bo where 1=1");
    if ((paramEvsBookModel.getBookId() != null) && (!"".equals(paramEvsBookModel.getBookId())))
    {
      List localList = findRelationIdByAllotNum(Long.valueOf(Long.parseLong(paramEvsBookModel.getBookId())));
      str = fmtList(localList, null);
      if ((str != null) && (!"".equals(str))) {
        localStringBuffer.append(" and bo.bookId in (" + str + ")");
      } else {
        localStringBuffer.append(" and 1=2");
      }
    }
    else
    {
      localStringBuffer.append(" and bo.bookStatus in ('WAREHOUSE')");
    }
    if ((paramEvsBookModel.getCompanyId() != null) && (!paramEvsBookModel.getCompanyId().equals("")))
    {
      localStringBuffer.append(" and bo.companyId = ?");
      localArrayList.add(Long.valueOf(Long.parseLong(paramEvsBookModel.getCompanyId())));
    }
    if ((paramEvsBookModel.getBookDateStart() != null) && (!paramEvsBookModel.getBookDateStart().equals("")))
    {
      localStringBuffer.append(" and bo.bookDate >= to_date(?,'yyyy-mm-dd')");
      localArrayList.add(paramEvsBookModel.getBookDateStart());
    }
    if ((paramEvsBookModel.getBookDateEnd() != null) && (!paramEvsBookModel.getBookDateEnd().equals("")))
    {
      localStringBuffer.append(" and bo.bookDate <= to_date(?,'yyyy-MM-dd')+1");
      localArrayList.add(paramEvsBookModel.getBookDateEnd());
    }
    if (!Util.isStrEmpty(paramEvsBookModel.getSetBookName())) {
      localStringBuffer.append(" and bo.setBookName = '" + paramEvsBookModel.getSetBookName() + "'");
    }
    if ((paramEvsBookModel.getBookPeopleId() != null) && (!paramEvsBookModel.getBookPeopleId().equals("")))
    {
      localStringBuffer.append(" and bo.bookEmployeeId = ?");
      localArrayList.add(Long.valueOf(Long.parseLong(paramEvsBookModel.getBookPeopleId())));
    }
    int i = 0;
    if ((!Util.isStrEmpty(paramEvsBookModel.getBeginBookCode())) && (!Util.isStrEmpty(paramEvsBookModel.getEndBookCode())) && (paramEvsBookModel.getBeginBookCode().equals(paramEvsBookModel.getEndBookCode())))
    {
      localStringBuffer.append(" AND bo.bookCode like ?");
      localArrayList.add(paramEvsBookModel.getBeginBookCode().trim());
      i = 1;
    }
    if (i == 0)
    {
      if (!Util.isStrEmpty(paramEvsBookModel.getBeginBookCode())) {
        localStringBuffer.append(" AND bo.bookCode >='" + paramEvsBookModel.getBeginBookCode() + "'");
      }
      if (!Util.isStrEmpty(paramEvsBookModel.getEndBookCode())) {
        localStringBuffer.append(" AND bo.bookCode <='" + paramEvsBookModel.getEndBookCode() + "'");
      }
    }
    if (StringUtils.isNotBlank(paramEvsBookModel.getWarehouseCode()))
    {
      localStringBuffer.append(" and bo.warehouseName like ?");
      localArrayList.add("%" + paramEvsBookModel.getWarehouseCode() + "%");
    }
    String str = fmtList(paramArrayOfString, "'");
    if (!Util.isStrEmpty(str)) {
      if ("isIncould".equals(paramString)) {
        localStringBuffer.append("and bo.bookCode in(" + str + ")");
      } else {
        localStringBuffer.append("and bo.bookCode not in(" + str + ")");
      }
    }
    localStringBuffer.append(" order by bo.bookDate desc");
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1 / paramInt2 + 1, paramInt2, localArrayList.toArray());
    return localPageInfo;
  }
  
  public List<String> findRelationIdByAllotNum(Long paramLong)
  {
    String str = "SELECT AD.RELATION_ID FROM EVS.EVS_ALLOT_DETAILS AD WHERE AD.ALLOT_HEADER_ID = " + paramLong;
    List localList = super.getSession().createSQLQuery(str).list();
    return localList;
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
  
  public PageInfo findAllVoucherNew(EvsVoucherV paramEvsVoucherV, int paramInt1, int paramInt2, String[] paramArrayOfString, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append("from EvsVoucherV bo where 1=1");
    if ((paramEvsVoucherV.getCompanyId() != null) && (!paramEvsVoucherV.getCompanyId().equals("")))
    {
      localStringBuffer.append(" and bo.companyId= ? ");
      localArrayList.add(paramEvsVoucherV.getCompanyId());
    }
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    if ((paramEvsVoucherV.getBegin_created_date() != null) && (!paramEvsVoucherV.getBegin_created_date().equals(""))) {
      localStringBuffer.append(" and to_char(bo.createdDate,'yyyy-MM-dd') >='" + localSimpleDateFormat.format(Long.valueOf(Long.parseLong(paramEvsVoucherV.getBegin_created_date()))) + "'");
    }
    if ((paramEvsVoucherV.getEnd_created_date() != null) && (!paramEvsVoucherV.getEnd_created_date().equals(""))) {
      localStringBuffer.append(" and to_char(bo.createdDate,'yyyy-MM-dd') <= '" + localSimpleDateFormat.format(Long.valueOf(Long.parseLong(paramEvsVoucherV.getEnd_created_date()))) + "'");
    }
    if ((paramEvsVoucherV.getJournalNum() != null) && (!paramEvsVoucherV.getJournalNum().equals("")))
    {
      localStringBuffer.append(" and bo.journalNum = ? ");
      localArrayList.add(paramEvsVoucherV.getJournalNum());
    }
    if ((paramEvsVoucherV.getInvoiceTypeCode() != null) && (!paramEvsVoucherV.getInvoiceTypeCode().equals("")))
    {
      localStringBuffer.append(" and bo.invoiceTypeCode = ? ");
      localArrayList.add(paramEvsVoucherV.getInvoiceTypeCode());
    }
    if ((paramEvsVoucherV.getUserId() != null) && (!paramEvsVoucherV.getUserId().equals("")))
    {
      localStringBuffer.append(" and bo.userId = ? ");
      localArrayList.add(paramEvsVoucherV.getUserId());
    }
    localStringBuffer.append(" and bo.voucherStatus in ('SUBMITED','CHECKED_NO_BOOKED')");
    String str = fmtList(paramArrayOfString, "'");
    if (!Util.isStrEmpty(str)) {
      if ("isIncould".equals(paramString)) {
        localStringBuffer.append("and bo.journalNum in(" + str + ")");
      } else {
        localStringBuffer.append("and bo.journalNum not in(" + str + ")");
      }
    }
    localStringBuffer.append(" order by bo.journalNum desc");
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1 / paramInt2 + 1, paramInt2, localArrayList.toArray());
    return localPageInfo;
  }
  
  public List<Long> findAllBookCodeByWarehouse(EvsBookModel paramEvsBookModel, String[] paramArrayOfString, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append("select bo.bookId from EvsBookV bo where 1=1");
    if ((paramEvsBookModel.getBookId() != null) && (!"".equals(paramEvsBookModel.getBookId())))
    {
      List localList = findRelationIdByAllotNum(Long.valueOf(Long.parseLong(paramEvsBookModel.getBookId())));
      str = fmtList(localList, null);
      if ((str != null) && (!"".equals(str)))
      {
        localStringBuffer.append(" and bo.bookId in (" + str + ")");
        localStringBuffer.append(" and bo.bookStatus in ('WAREHOUSE')");
      }
      else
      {
        localStringBuffer.append(" and 1=2");
      }
    }
    else
    {
      localStringBuffer.append(" and bo.bookStatus in ('WAREHOUSE')");
    }
    if ((paramEvsBookModel.getCompanyId() != null) && (!paramEvsBookModel.getCompanyId().equals("")))
    {
      localStringBuffer.append(" and bo.companyId = ?");
      localArrayList.add(Long.valueOf(Long.parseLong(paramEvsBookModel.getCompanyId())));
    }
    if ((paramEvsBookModel.getBookDateStart() != null) && (!paramEvsBookModel.getBookDateStart().equals("")))
    {
      localStringBuffer.append(" and bo.bookDate >= to_date(?,'yyyy-mm-dd')");
      localArrayList.add(paramEvsBookModel.getBookDateStart());
    }
    if ((paramEvsBookModel.getBookDateEnd() != null) && (!paramEvsBookModel.getBookDateEnd().equals("")))
    {
      localStringBuffer.append(" and bo.bookDate <= to_date(?,'yyyy-MM-dd')+1");
      localArrayList.add(paramEvsBookModel.getBookDateEnd());
    }
    if (!Util.isStrEmpty(paramEvsBookModel.getSetBookName())) {
      localStringBuffer.append(" and bo.setBookName = '" + paramEvsBookModel.getSetBookName() + "'");
    }
    if ((paramEvsBookModel.getBookPeopleId() != null) && (!paramEvsBookModel.getBookPeopleId().equals("")))
    {
      localStringBuffer.append(" and bo.bookEmployeeId = ?");
      localArrayList.add(Long.valueOf(Long.parseLong(paramEvsBookModel.getBookPeopleId())));
    }
    int i = 0;
    if ((!Util.isStrEmpty(paramEvsBookModel.getBeginBookCode())) && (!Util.isStrEmpty(paramEvsBookModel.getEndBookCode())) && (paramEvsBookModel.getBeginBookCode().equals(paramEvsBookModel.getEndBookCode())))
    {
      localStringBuffer.append(" AND bo.bookCode like ?");
      localArrayList.add(paramEvsBookModel.getBeginBookCode().trim());
      i = 1;
    }
    if (i == 0)
    {
      if (!Util.isStrEmpty(paramEvsBookModel.getBeginBookCode())) {
        localStringBuffer.append(" AND bo.bookCode >='" + paramEvsBookModel.getBeginBookCode() + "'");
      }
      if (!Util.isStrEmpty(paramEvsBookModel.getEndBookCode())) {
        localStringBuffer.append(" AND bo.bookCode <='" + paramEvsBookModel.getEndBookCode() + "'");
      }
    }
    if (StringUtils.isNotBlank(paramEvsBookModel.getWarehouseCode()))
    {
      localStringBuffer.append(" and bo.warehouseName like ?");
      localArrayList.add("%" + paramEvsBookModel.getWarehouseCode() + "%");
    }
    String str = fmtList(paramArrayOfString, "'");
    if (!Util.isStrEmpty(str)) {
      if ("isIncould".equals(paramString)) {
        localStringBuffer.append("and bo.bookCode in(" + str + ")");
      } else {
        localStringBuffer.append("and bo.bookCode not in(" + str + ")");
      }
    }
    localStringBuffer.append(" order by bo.bookDate desc");
    return super.getZormTemplate().find(localStringBuffer.toString(), localArrayList.toArray());
  }
  
  public PageInfo findVoucherByNumbs(String[] paramArrayOfString, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfString == null) && (paramArrayOfString.length < 1)) {
      return new PageInfo();
    }
    String str1 = fmtList(paramArrayOfString, "'");
    str1 = str1 == null ? "'-1'" : str1;
    str1 = "".equals(str1) ? "'-1'" : str1;
    String str2 = "FROM EvsVoucherV eb WHERE 1=1 ";
    if ("FLITTING".equals(paramString)) {
      str2 = str2 + " and eb.voucherStatus in ('SUBMITED','CHECKED_NO_BOOKED')";
    }
    str2 = str2 + " AND eb.journalNum IN(" + str1 + ")";
    str2 = str2 + " ORDER BY eb.journalNum desc";
    return super.PageInfoQuery(str2, paramInt1 / paramInt2 + 1, paramInt2, null);
  }
  
  public PageInfo findBookByNumbs(String[] paramArrayOfString, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfString == null) && (paramArrayOfString.length < 1)) {
      return new PageInfo();
    }
    String str1 = fmtList(paramArrayOfString, "'");
    str1 = str1 == null ? "'-1'" : str1;
    str1 = "".equals(str1) ? "'-1'" : str1;
    String str2 = "FROM EvsBookV eb WHERE 1=1 ";
    if ("FLITTING".equals(paramString)) {
      str2 = str2 + " and eb.bookStatus in ('BOOKED','PACKAGED','WAREHOUSE')";
    } else if ("RECEIVE".equals(paramString)) {
      str2 = str2 + " AND eb.bookStatus in('ALREADY_FLITTING')";
    }
    str2 = str2 + " AND eb.bookCode IN(" + str1 + ")";
    str2 = str2 + " ORDER BY eb.bookDate desc";
    return super.PageInfoQuery(str2, paramInt1 / paramInt2 + 1, paramInt2, null);
  }
  
  public List<String> findBookedPeriod(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
  {
    String str = "SELECT tb1.period_name FROM( SELECT COUNT(vc.voucher_id) a_countV,vc.period_name FROM evs_voucher vc ";
    if ((!Util.isStrEmpty(paramString2)) && (!Util.isStrEmpty(paramString1)) && (!Util.isStrEmpty(paramString4))) {
      str = str + " WHERE vc.ou_id=" + paramString1 + " AND vc.set_book_name = '" + paramString2 + "'" + " and vc.period_name like '%" + paramString4 + "%'";
    }
    str = str + " GROUP BY vc.period_name ) tb1,(SELECT COUNT(vc.voucher_id) countV,vc.period_name FROM evs_voucher vc ";
    if ("MUST_IS_NULL".equals(paramString3)) {
      str = str + " WHERE vc.voucher_status IN('BOOKED','PACKAGED','UNPACKAG','ALREADY_FLITTING','ALREADY_RECEIVE','NOT_RECEIVE')";
    } else if ("MUST_NOT_NULL".equals(paramString3)) {
      str = str + " WHERE vc.voucher_status NOT IN('BOOKED','PACKAGED','UNPACKAG','ALREADY_FLITTING','ALREADY_RECEIVE','NOT_RECEIVE')";
    }
    if ((!Util.isStrEmpty(paramString2)) && (!Util.isStrEmpty(paramString1)) && (!Util.isStrEmpty(paramString4))) {
      str = str + " AND vc.ou_id=" + paramString1 + " AND vc.set_book_name = '" + paramString2 + "'" + " and vc.period_name like '%" + paramString4 + "%'";
    }
    str = str + " GROUP BY vc.period_name) tb2";
    if ("MUST_IS_NULL".equals(paramString3))
    {
      str = str + ",(SELECT bk.period_name FROM evs_book bk WHERE bk.ARCHIVE_NUMBER IS  NULL ";
      if ((!Util.isStrEmpty(paramString2)) && (!Util.isStrEmpty(paramString1)) && (!Util.isStrEmpty(paramString4))) {
        str = str + " AND bk.ou_name='" + paramString1 + "' AND bk.set_book_name = '" + paramString2 + "'" + " and bk.period_name like '%" + paramString4 + "%'";
      }
      str = str + " GROUP BY bk.period_name) tb3";
    }
    else if ("MUST_NOT_NULL".equals(paramString3))
    {
      str = str + ",(SELECT bk.period_name FROM evs_book bk WHERE bk.ARCHIVE_NUMBER IS NOT NULL  ";
      if ((!Util.isStrEmpty(paramString2)) && (!Util.isStrEmpty(paramString1)) && (!Util.isStrEmpty(paramString4))) {
        str = str + " AND bk.ou_name='" + paramString1 + "' AND bk.set_book_name = '" + paramString2 + "'" + " and bk.period_name like '%" + paramString4 + "%'";
      }
      str = str + " GROUP BY bk.period_name) tb3";
    }
    str = str + " WHERE 1=1 ";
    if (paramBoolean) {
      str = str + " AND tb1.a_countV = tb2.countV ";
    }
    str = str + " AND tb1.period_name = tb2.period_name";
    if (!Util.isStrEmpty(paramString3)) {
      str = str + " AND tb1.period_name = tb3.period_name";
    }
    Object localObject = new ArrayList();
    localObject = super.getSession().createSQLQuery(str).list();
    return localObject;
  }
  
  public List<String> findPeriodOnYear(String paramString1, boolean paramBoolean, String paramString2)
  {
    String str = "SELECT bk.period_name FROM evs_book bk WHERE bk.period_name IN(";
    str = str + "SELECT p.period_name FROM fbp_periods p WHERE p.period_name IN (";
    str = str + "SELECT DISTINCT vc.period_name FROM evs_voucher vc WHERE vc.period_name LIKE '%" + paramString1 + "'";
    if (paramBoolean) {
      str = str + " AND vc.voucher_status NOT IN('BOOKED','PACKAGED','UNPACKAG','ALREADY_FLITTING','ALREADY_RECEIVE','NOT_RECEIVE')";
    }
    if (!Util.isStrEmpty(paramString2)) {
      str = str + " AND p.start_date <(SELECT pd.start_date FROM fbp_periods pd WHERE pd.period_name = '" + paramString2 + "')";
    }
    str = str + "))AND bk.archive_number IS NULL";
    Object localObject = new ArrayList();
    localObject = super.getSession().createSQLQuery(str).list();
    return localObject;
  }
  
  public List<FbpPeriods> findPeriod(String paramString)
  {
    String str = "FROM FbpPeriods fp WHERE fp.periodType='22' AND fp.periodName in(" + paramString + ")";
    str = str + " ORDER BY fp.periodYear ASC,fp.startDate ASC";
    Object localObject = new ArrayList();
    localObject = super.createQuery(str, new Object[0]).list();
    return localObject;
  }
  
  public List<EvsBook> findBookByParam(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = new ArrayList();
    String str = "FROM EvsBook bk where 1=1";
    if ((!Util.isStrEmpty(paramString1)) && (!Util.isStrEmpty(paramString2)) && (!Util.isStrEmpty(paramString3))) {
      str = str + " AND bk.ouName = '" + paramString1 + "' AND bk.setBookName = '" + paramString2 + "' AND bk.periodName='" + paramString3 + "'";
    }
    localObject = super.getSession().createQuery(str).list();
    return localObject;
  }
  
  public List<String> findDocNumb(String paramString)
  {
    String str = "SELECT  E1.doc_code FROM EVS_DOC_TYPE E1, EVS_SUB_DOC_TYPE E2";
    str = str + " WHERE E1.DOC_ID = E2.DOC_ID AND e2.sub_doc_code = '" + paramString + "' AND ROWNUM = 1";
    Object localObject = new ArrayList();
    localObject = super.getSession().createSQLQuery(str).list();
    return localObject;
  }
  
  public String findMaxArchiveNumber(String paramString)
  {
    String str = "SELECT MAX(BK.ARCHIVE_NUMBER) ARCHIVE FROM EVS_BOOK BK WHERE BK.ARCHIVE_NUMBER LIKE '" + paramString + "%'";
    Object localObject1 = new ArrayList();
    localObject1 = super.getSession().createSQLQuery(str).list();
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      Object localObject2 = ((List)localObject1).get(0);
      if ((localObject2 == null) || (localObject2.equals(""))) {
        return null;
      }
      return localObject2.toString();
    }
    return null;
  }
  
  public void updateBoolArhciveNumber(String paramString1, String paramString2)
  {
    String str = "UPDATE EVS_BOOK BK SET bk.archive_number = '" + paramString2 + "' WHERE and book_status='BOOKED' and bk.book_code in ('" + paramString1 + "')";
    super.getSession().createSQLQuery(str).executeUpdate();
  }
  
  public List<String> findDossierNumber(String paramString)
  {
    String str = "SELECT ck.attribute1 FROM fbp_check_unit_contents ck  WHERE ck.erp_org_id =" + paramString;
    Object localObject = new ArrayList();
    localObject = super.getSession().createSQLQuery(str).list();
    return localObject;
  }
  
  public List<String> findAllPeriod(String paramString1, String paramString2, String paramString3)
  {
    String str = "SELECT DISTINCT BK.PERIOD_NAME FROM EVS_BOOK BK WHERE BK.ARCHIVE_NUMBER IS NOT NULL";
    if ((!Util.isStrEmpty(paramString1)) && (!Util.isStrEmpty(paramString2)) && (!Util.isStrEmpty(paramString3))) {
      str = str + " AND BK.SET_BOOK_NAME = '" + paramString2 + "' AND BK.OU_NAME ='" + paramString1 + "'" + " and bk.PERIOD_NAME like '%" + paramString3 + "%'";
    }
    Object localObject = new ArrayList();
    localObject = super.getSession().createSQLQuery(str).list();
    return localObject;
  }
  
  public List<String> findUnBookPeriod(String paramString1, String paramString2, String paramString3)
  {
    String str = "SELECT DISTINCT b.period_name FROM evs_voucher v ,evs_book b";
    str = str + " WHERE b.archive_number IS NOT NULL  AND v.voucher_status NOT IN";
    str = str + " ('BOOKED', 'PACKAGED', 'UNPACKAG', 'ALREADY_FLITTING','ALREADY_RECEIVE', 'NOT_RECEIVE')";
    str = str + "  AND v.voucher_id IN(SELECT vbp.voucher_id FROM evs_voucher_book_package  vbp WHERE vbp.book_id =b.book_id)";
    if ((!Util.isStrEmpty(paramString1)) && (!Util.isStrEmpty(paramString2)) && (!Util.isStrEmpty(paramString3))) {
      str = str + " AND B.SET_BOOK_NAME = '" + paramString2 + "' AND B.OU_NAME ='" + paramString1 + "'" + " and b.period_name like '%" + paramString3 + "%'";
    }
    Object localObject = new ArrayList();
    localObject = super.getSession().createSQLQuery(str).list();
    return localObject;
  }
  
  public List<EvsBook> findBookdByArhciveNumber(String paramString)
  {
    String str = "FROM EvsBook BK WHERE BK.archiveNumber='" + paramString + "'";
    List localList = super.getSession().createQuery(str).list();
    return localList;
  }
  
  public List<EvsBook> findBookdByArhciveNumberNew(String paramString)
  {
    String str = "FROM EvsBook BK WHERE BK.archiveNumber like '" + paramString + "%'";
    List localList = super.getSession().createQuery(str).list();
    return localList;
  }
  
  public void updateSerials(String paramString1, String paramString2)
  {
    String str = " UPDATE FBP_SERIALS TT SET TT.SERIAL_ID = " + paramString2 + ", LAST_UPDATE_DATE = SYSDATE";
    str = str + " WHERE SERIAL_TYPE ='" + paramString1 + "'";
    super.getSession().createSQLQuery(str).executeUpdate();
  }
  
  public void updateBook(EvsBook paramEvsBook)
  {
    super.getSession().update(paramEvsBook);
  }
  
  public List<EvsBookV> findBookByNum(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      return null;
    }
    String str = "FROM EvsBookV BK WHERE BK.bookCode = '" + paramString.trim() + "'";
    List localList = super.getSession().createQuery(str).list();
    return localList;
  }
  
  public List findImageByImageNumer(String paramString)
  {
    String str = "select ei.localPath, ei.imageUrl, ei.webhostUrl from EvsImage ei where ei.barcode like '%" + paramString + "%' order by ei.lastUpdateDate,ei.imageId";
    List localList = getSession().createQuery(str).list();
    return localList;
  }
  
  public void updateWarehouse(String paramString1, String paramString2)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    log.debug("update EvsPackage book");
    try
    {
      String str;
      if (localEasUserInfo != null)
      {
        str = " update evs_package set LAST_UPDATE_DATE = sysdate ,LAST_UPDATE_BY = " + localEasUserInfo.getUserInfoPk() + " ,LAST_UPDATE_LOGIN = " + localEasUserInfo.getUserInfoPk() + " ,WAREHOUSE_CODE = '" + paramString2 + "' ,PACKAGE_STATUS = '" + "WAREHOUSE" + "' ,INCOME_DATE = sysdate" + ",INCOME_EMPLOYEE_ID = " + localEasUserInfo.getUserInfoPk() + "  where PACKAGE_CODE = '" + paramString1 + "'";
        getSession().createSQLQuery(str).executeUpdate();
        log.debug("update successful");
      }
      else
      {
        str = " update evs_package set LAST_UPDATE_DATE = sysdate ,LAST_UPDATE_BY = 0 ,LAST_UPDATE_LOGIN = 0  ,INCOME_DATE = sysdate,INCOME_EMPLOYEE_ID = 0,WAREHOUSE_CODE = '" + paramString2 + "' ,PACKAGE_STATUS = '" + "WAREHOUSE" + "'  where PACKAGE_CODE in (" + paramString1 + ")";
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
  
  public void updateBookStatusByPackage(String paramString1, String paramString2)
  {
    log.debug("update EVS_BOOK packageCode");
    StringBuffer localStringBuffer = new StringBuffer();
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    try
    {
      if (localEasUserInfo != null) {
        localStringBuffer.append("update EVS_BOOK set BOOK_STATUS = '" + paramString2 + "' , LAST_UPDATE_DATE = SYSDATE ,LAST_UPDATE_BY = " + localEasUserInfo.getUserInfoPk() + " ,LAST_UPDATE_LOGIN = " + localEasUserInfo.getUserInfoPk() + "  where BOOK_ID in");
      } else {
        localStringBuffer.append("update EVS_BOOK set BOOK_STATUS = '" + paramString2 + "' , LAST_UPDATE_DATE = SYSDATE ,LAST_UPDATE_BY = 0" + " ,LAST_UPDATE_LOGIN = 0" + " where BOOK_ID in");
      }
      localStringBuffer.append(" (select BOOK_ID from Evs_Voucher_Book_Package where PACKAGE_ID in (SELECT ep.package_id FROM EVS_PACKAGE ep WHERE ep.package_code='" + paramString1 + "')" + ")");
      getSession().createSQLQuery(localStringBuffer.toString()).executeUpdate();
      log.error("update BOOK_STATUS By packageCode");
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("update failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public void updateVoucherStatusByPackage(String paramString1, String paramString2)
  {
    log.debug("update Evs_Voucher packageCode");
    StringBuffer localStringBuffer = new StringBuffer();
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    try
    {
      if (localEasUserInfo != null) {
        localStringBuffer.append("update Evs_Voucher set voucher_status = '" + paramString2 + "' , LAST_UPDATE_DATE = SYSDATE ,LAST_UPDATE_BY = " + localEasUserInfo.getUserInfoPk() + " ,LAST_UPDATE_LOGIN = " + localEasUserInfo.getUserInfoPk() + " where voucher_id in");
      } else {
        localStringBuffer.append("update Evs_Voucher set voucher_status = '" + paramString2 + "' , LAST_UPDATE_DATE = SYSDATE ,LAST_UPDATE_BY = 0" + " ,LAST_UPDATE_LOGIN = 0 " + " where voucher_id in");
      }
      localStringBuffer.append(" (select VOUCHER_ID from Evs_Voucher_Book_Package where PACKAGE_ID in (SELECT ep.package_id FROM EVS_PACKAGE ep WHERE ep.package_code='" + paramString1 + "')" + ")");
      getSession().createSQLQuery(localStringBuffer.toString()).executeUpdate();
      log.error("update Evs_Voucher By packageCode");
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("update failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public Map findPackage(EvsPackageModel paramEvsPackageModel, int paramInt1, int paramInt2)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append("from EvsPackageV pk where 1=1");
    int i = "Y".equals(paramEvsPackageModel.getLikeSelect().trim()) ? 1 : 0;
    if ((!Util.isStrEmpty(paramEvsPackageModel.getSerialId())) && ("no".equals(paramEvsPackageModel.getSerialId()))) {
      localStringBuffer.append(" and pk.packageDate >= add_months(sysdate,-6) and pk.packageDate <= sysdate");
    }
    if ((paramEvsPackageModel.getPackageCode() != null) && (!Util.isStrEmpty(paramEvsPackageModel.getPackageCode().toUpperCase())) && (i != 0))
    {
      localStringBuffer.append(" and pk.packageCode >= ?");
      localArrayList.add(paramEvsPackageModel.getPackageCode().toUpperCase());
    }
    else
    {
      localStringBuffer.append(" and pk.packageCode like ?");
      localArrayList.add("%" + paramEvsPackageModel.getPackageCode().toUpperCase() + "%");
    }
    if ((paramEvsPackageModel.getTempCode() != null) && (!Util.isStrEmpty(paramEvsPackageModel.getTempCode().toUpperCase())) && (i != 0))
    {
      localStringBuffer.append(" and pk.packageCode <= ?");
      localArrayList.add(paramEvsPackageModel.getTempCode().toUpperCase());
    }
    else
    {
      localStringBuffer.append(" and pk.packageCode like ?");
      localArrayList.add("%" + paramEvsPackageModel.getTempCode().toUpperCase() + "%");
    }
    if ((!Util.isStrEmpty(paramEvsPackageModel.getCompanyName())) && (i != 0))
    {
      localStringBuffer.append(" and pk.companyName = ?");
      localArrayList.add(paramEvsPackageModel.getCompanyName());
    }
    else
    {
      localStringBuffer.append(" and pk.companyName like ?");
      localArrayList.add("%" + paramEvsPackageModel.getCompanyName() + "%");
    }
    if (!Util.isStrEmpty(localEasUserInfo.getUserInfoPk().toString())) {
      localStringBuffer.append(" and exists(from FbpPseRelationsV f where f.companyId=pk.companyId and f.employeeId = " + localEasUserInfo.getUserInfoPk().toString() + ")");
    } else {
      localStringBuffer.append(" and exists(from FbpPseRelationsV f where f.companyId=pk.companyId and f.employeeId = '000' )");
    }
    if (!Util.isStrEmpty(paramEvsPackageModel.getPackageStatus()))
    {
      localStringBuffer.append(" and pk.packageStatus = ?");
      localArrayList.add(paramEvsPackageModel.getPackageStatus());
    }
    if ((!Util.isStrEmpty(paramEvsPackageModel.getPackageEmployeeId())) && (i != 0))
    {
      localStringBuffer.append(" and pk.packagePeople = ?");
      localArrayList.add(paramEvsPackageModel.getPackageEmployeeId());
    }
    else
    {
      localStringBuffer.append(" and pk.packagePeople like ?");
      localArrayList.add("%" + paramEvsPackageModel.getPackageEmployeeId() + "%");
    }
    if (!Util.isStrEmpty(paramEvsPackageModel.getPackageDate()))
    {
      localStringBuffer.append(" and to_char(pk.packageDate,'yyyy-mm-dd') >= ?");
      localArrayList.add(paramEvsPackageModel.getPackageDate());
    }
    if (!Util.isStrEmpty(paramEvsPackageModel.getTempDate()))
    {
      localStringBuffer.append(" and to_char(pk.packageDate,'yyyy-mm-dd') <= ?");
      localArrayList.add(paramEvsPackageModel.getTempDate());
    }
    localStringBuffer.append(" and pk.packageStatus in ('PACKAGED','WAREHOUSE') order by pk.packageCode desc");
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1 / paramInt2 + 1, paramInt2, localArrayList.toArray());
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", localPageInfo.getResult());
    localHashMap.put("totalCount", Long.valueOf(localPageInfo.getTotalCount()));
    return localHashMap;
  }
  
  public String validateVoucherStatus(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("FROM EvsVoucher t WHERE 1=1 ");
    localStringBuffer.append(" and t.voucherStatus in('NOW_FLITTING','BORROWING')");
    localStringBuffer.append(" and t.voucherId in ( select e.voucherId FROM EvsVoucherBookPackage e WHERE 1=1  ");
    if (!Util.isStrEmpty(paramString)) {
      localStringBuffer.append(" AND e.packageId = " + paramString + ") ");
    }
    List localList = super.getSession().createQuery(localStringBuffer.toString()).list();
    if (localList.size() > 0) {
      return "true";
    }
    return "false";
  }
  
  public String validateVoucherStatusList(String paramString1, String paramString2)
  {
    StringBuffer localStringBuffer1 = new StringBuffer();
    StringBuffer localStringBuffer2 = new StringBuffer();
    localStringBuffer1.append("FROM EvsVoucher t WHERE 1=1 ");
    localStringBuffer1.append(" and t.voucherStatus in('NOW_FLITTING','BORROWING')");
    localStringBuffer2.append("FROM EvsVoucher t WHERE 1=1 ");
    localStringBuffer2.append(" and t.voucherStatus in('BORROWING')");
    List localList;
    if ("1".equals(paramString2))
    {
      localStringBuffer1.append(" and exists ( select 1 FROM EvsVoucherBookPackage e WHERE t.voucherId = e.voucherId ");
      if (!Util.isStrEmpty(paramString1)) {
        localStringBuffer1.append(" AND exists (select 1 from EvsBook eb where e.bookId = eb.bookId and eb.bookCode in ('" + paramString1 + "') ))");
      }
      localList = super.getSession().createQuery(localStringBuffer1.toString()).list();
      if (localList.size() > 0) {
        return paramString1;
      }
    }
    if ("0".equals(paramString2))
    {
      if (!Util.isStrEmpty(paramString1)) {
        localStringBuffer1.append(" and t.voucherId in ('" + paramString1 + "')  ");
      }
      localList = super.getSession().createQuery(localStringBuffer1.toString()).list();
      if (localList.size() > 0)
      {
        EvsVoucher localEvsVoucher = (EvsVoucher)localList.get(0);
        return localEvsVoucher.getJournalNum();
      }
    }
    if ("3".equals(paramString2))
    {
      localStringBuffer2.append(" and exists ( select 1 FROM EvsVoucherBookPackage e WHERE t.voucherId = e.voucherId ");
      localStringBuffer2.append(" AND e.packageId = " + paramString1 + ") ");
      localList = super.getSession().createQuery(localStringBuffer2.toString()).list();
      if (localList.size() > 0) {
        return "true";
      }
    }
    if ("4".equals(paramString2))
    {
      localStringBuffer2.append(" and exists ( select 1 FROM EvsVoucherBookPackage e WHERE t.voucherId = e.voucherId");
      localStringBuffer2.append(" AND exists (select 1 from EvsBook eb where e.bookId = eb.bookId and eb.bookCode in ('" + paramString1 + "') ))");
      localList = super.getSession().createQuery(localStringBuffer2.toString()).list();
      if (localList.size() > 0) {
        return paramString1;
      }
    }
    return "false";
  }
  
  public Map findPackageList(EvsPackageModel paramEvsPackageModel, int paramInt1, int paramInt2)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append("from EvsPackageV pk where 1=1");
    int i = "Y".equals(paramEvsPackageModel.getLikeSelect().trim()) ? 1 : 0;
    if ((!Util.isStrEmpty(paramEvsPackageModel.getSerialId())) && ("no".equals(paramEvsPackageModel.getSerialId()))) {
      localStringBuffer.append(" and pk.packageDate >= add_months(sysdate,-6) and pk.packageDate <= sysdate");
    }
    if ((paramEvsPackageModel.getPackageCode() != null) && (!Util.isStrEmpty(paramEvsPackageModel.getPackageCode().toUpperCase())) && (i != 0))
    {
      localStringBuffer.append(" and pk.packageCode >= ?");
      localArrayList.add(paramEvsPackageModel.getPackageCode().toUpperCase());
    }
    else
    {
      localStringBuffer.append(" and pk.packageCode like ?");
      localArrayList.add("%" + paramEvsPackageModel.getPackageCode().toUpperCase() + "%");
    }
    if ((paramEvsPackageModel.getTempCode() != null) && (!Util.isStrEmpty(paramEvsPackageModel.getTempCode().toUpperCase())) && (i != 0))
    {
      localStringBuffer.append(" and pk.packageCode <= ?");
      localArrayList.add(paramEvsPackageModel.getTempCode().toUpperCase());
    }
    else
    {
      localStringBuffer.append(" and pk.packageCode like ?");
      localArrayList.add("%" + paramEvsPackageModel.getTempCode().toUpperCase() + "%");
    }
    if ((!Util.isStrEmpty(paramEvsPackageModel.getCompanyName())) && (i != 0))
    {
      localStringBuffer.append(" and pk.companyName = ?");
      localArrayList.add(paramEvsPackageModel.getCompanyName());
    }
    else
    {
      localStringBuffer.append(" and pk.companyName like ?");
      localArrayList.add("%" + paramEvsPackageModel.getCompanyName() + "%");
    }
    if (!Util.isStrEmpty(localEasUserInfo.getUserInfoPk().toString())) {
      localStringBuffer.append(" and exists(from FbpPseRelationsV f where f.companyId=pk.companyId and f.employeeId = " + localEasUserInfo.getUserInfoPk().toString() + ")");
    } else {
      localStringBuffer.append(" and exists(from FbpPseRelationsV f where f.companyId=pk.companyId and f.employeeId = '000' )");
    }
    if (!Util.isStrEmpty(paramEvsPackageModel.getPeriodName()))
    {
      localStringBuffer.append(" and pk.periodName = ?");
      localArrayList.add(paramEvsPackageModel.getPeriodName());
    }
    if (!Util.isStrEmpty(paramEvsPackageModel.getPackageStatus()))
    {
      localStringBuffer.append(" and pk.packageStatus = ?");
      localArrayList.add(paramEvsPackageModel.getPackageStatus());
    }
    if ((!Util.isStrEmpty(paramEvsPackageModel.getPackageEmployeeId())) && (i != 0))
    {
      localStringBuffer.append(" and pk.packagePeople = ?");
      localArrayList.add(paramEvsPackageModel.getPackageEmployeeId());
    }
    else
    {
      localStringBuffer.append(" and pk.packagePeople like ?");
      localArrayList.add("%" + paramEvsPackageModel.getPackageEmployeeId() + "%");
    }
    if (!Util.isStrEmpty(paramEvsPackageModel.getPackageDate()))
    {
      localStringBuffer.append(" and to_char(pk.packageDate,'yyyy-mm-dd') >= ?");
      localArrayList.add(paramEvsPackageModel.getPackageDate());
    }
    if (!Util.isStrEmpty(paramEvsPackageModel.getTempDate()))
    {
      localStringBuffer.append(" and to_char(pk.packageDate,'yyyy-mm-dd') <= ?");
      localArrayList.add(paramEvsPackageModel.getTempDate());
    }
    localStringBuffer.append(" and pk.packageStatus in ('PACKAGED','PACKAGED_NO_INCOME','NOW_FLITTING','BORROWING','WAREHOUSE') order by pk.packageCode desc");
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1 / paramInt2 + 1, paramInt2, localArrayList.toArray());
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", localPageInfo.getResult());
    localHashMap.put("totalCount", Long.valueOf(localPageInfo.getTotalCount()));
    return localHashMap;
  }
  
  public List getBookBypackageCode(String paramString)
  {
    Object localObject = null;
    log.debug("select EvsVoucherBookPackage");
    String str = null;
    try
    {
      str = "select distinct(BOOK_ID) from Evs_Voucher_Book_Package evsV where evsV.package_id in (SELECT ep.package_id FROM EVS_PACKAGE ep WHERE ep.package_code='" + paramString + "')" + " group by BOOK_ID ";
      List localList = getSession().createSQLQuery(str).list();
      log.debug("select EvsVoucherBookPackage By packageCode");
      return localList;
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("select failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public List<EvsBook> findBookByPack(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || ("".equals(paramString1))) {
      return null;
    }
    String str = "FROM EvsBook eb WHERE eb.bookCode in " + paramString1.trim();
    List localList = getSession().createQuery(str).list();
    return localList;
  }
  
  public void delBookStatusByPackage(String paramString1, String paramString2)
  {
    log.debug("update EVS_BOOK packageCode");
    StringBuffer localStringBuffer1 = new StringBuffer();
    StringBuffer localStringBuffer2 = new StringBuffer();
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    try
    {
      if (localEasUserInfo != null) {
        localStringBuffer1.append("update EVS_BOOK set BOOK_STATUS = '" + paramString2 + "' , LAST_UPDATE_DATE = SYSDATE,package_id='',operate_user_id = '',LAST_UPDATE_BY = " + localEasUserInfo.getUserInfoPk() + " ,LAST_UPDATE_LOGIN = " + localEasUserInfo.getUserInfoPk() + "  where BOOK_ID in ");
      } else {
        localStringBuffer1.append("update EVS_BOOK set BOOK_STATUS = '" + paramString2 + "' , LAST_UPDATE_DATE = SYSDATE,package_id='',operate_user_id = '',LAST_UPDATE_BY = 0" + " ,LAST_UPDATE_LOGIN = 0" + " where BOOK_ID in ");
      }
      localStringBuffer1.append(paramString1);
      getSession().createSQLQuery(localStringBuffer1.toString()).executeUpdate();
      log.error("update BOOK_STATUS By packageCode");
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("update failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public void cleanVoucherBookPackageByPackageId(String paramString)
  {
    log.debug("update VoucherBookPackage By PackageId");
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      localStringBuffer.append("update Evs_Voucher_Book_Package SET PACKAGE_ID='' WHERE BOOK_ID in " + paramString);
      getSession().createSQLQuery(localStringBuffer.toString()).executeUpdate();
      log.error("update VoucherBookPackage By PackageId");
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("update failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public void updateVoucherStatusByBookID(String paramString1, String paramString2)
  {
    log.debug("update Evs_Voucher packageCode");
    StringBuffer localStringBuffer = new StringBuffer();
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    try
    {
      if (localEasUserInfo != null) {
        localStringBuffer.append("update Evs_Voucher set voucher_status = '" + paramString2 + "' , LAST_UPDATE_DATE = SYSDATE ,LAST_UPDATE_BY = " + localEasUserInfo.getUserInfoPk() + " ,LAST_UPDATE_LOGIN = " + localEasUserInfo.getUserInfoPk() + " where voucher_id in");
      } else {
        localStringBuffer.append("update Evs_Voucher set voucher_status = '" + paramString2 + "' , LAST_UPDATE_DATE = SYSDATE ,LAST_UPDATE_BY = 0" + " ,LAST_UPDATE_LOGIN = 0 " + " where voucher_id in");
      }
      localStringBuffer.append(" (select VOUCHER_ID from Evs_Voucher_Book_Package where BOOK_ID in " + paramString1 + ")");
      getSession().createSQLQuery(localStringBuffer.toString()).executeUpdate();
      log.error("update Evs_Voucher By packageCode");
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("update failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public void updateVoucherStatus(EvsBook paramEvsBook, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if ("Y".equals(paramEvsBook.getBookBreakFlag()))
    {
      localStringBuffer.append(" update EvsVoucher ev set ev.voucherStatus = '" + paramString + "' where ev.voucherId in( ");
      localStringBuffer.append(" select evb.voucherId from EvsVoucherBookPackage evb where evb.bookId = " + paramEvsBook.getBookId());
      localStringBuffer.append(" )");
    }
    else if ("N".equals(paramEvsBook.getBookBreakFlag()))
    {
      localStringBuffer.append(" update EvsVoucher ev set ev.voucherStatus = '" + paramString + "' where 1 = 1 and ");
      localStringBuffer.append(" exists (select evb.beginNum, evb.endNum from EvsVoucherBookPackage evb where evb.bookId = " + paramEvsBook.getBookId());
      localStringBuffer.append(" and ev.journalNum>=evb.beginNum and ev.journalNum<=evb.endNum)");
    }
    createQuery(localStringBuffer.toString(), new Object[0]).executeUpdate();
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.eBillManage.EvsPackageDAO
 * JD-Core Version:    0.7.0.1
 */