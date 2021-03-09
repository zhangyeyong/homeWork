package com.zte.evs.ebill.access.archives;

import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.eas.appframe.business.util.ObjectCopyUtils;
import com.zte.evs.ebill.common.EvsObjectUtils;
import com.zte.evs.ebill.model.archives.EvsFindVoucherV;
import com.zte.evs.ebill.model.archives.FbpArchivesHeaders;
import com.zte.evs.ebill.model.archives.FbpArchivesHeadersV;
import com.zte.evs.ebill.model.archives.FbpArchivesHistories;
import com.zte.evs.ebill.model.eBillManage.EvsAllotHeaders;
import com.zte.evs.ebill.model.eBillManage.EvsVoucher;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.util.Util;
import com.zte.ssb.orm.zorm.ZormTemplate;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import com.zte.ssb.zorm.Query;
import com.zte.ssb.zorm.SQLQuery;
import com.zte.ssb.zorm.SessionFactory;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class FbpArchivesHeadersDAO
  extends BaseDAO
  implements IFbpArchivesHeadersDAO
{
  public List getFbpArchivesHeadersV(String paramString)
  {
    String str = " from FbpArchivesHeaders fv where fv.archivesStatus in ('ARCHIVES_ALREADY_APPROVE','ARCHIVES_DEPLAYED_APPROVE') and fv.attribute1 = 'Y' and fv.giveBackDate < to_date('" + paramString + "','yyyy-mm-dd')";
    return getSession().createQuery(str).list();
  }
  
  public FbpArchivesHeadersV getFbpArchivesHeadersV(Long paramLong)
  {
    return (FbpArchivesHeadersV)super.getObject(FbpArchivesHeadersV.class, paramLong);
  }
  
  public FbpArchivesHeaders getFbpArchivesHeaders(String paramString)
  {
    List localList = null;
    FbpArchivesHeaders localFbpArchivesHeaders = null;
    String str = "select * from FBP.FBP_ARCHIVES_HEADERS v where v.APPLY_NUM ='" + paramString + "'";
    SQLQuery localSQLQuery = super.getSession().createSQLQuery(str);
    localList = localSQLQuery.addEntity(FbpArchivesHeaders.class).list();
    if (localList.size() > 0) {
      localFbpArchivesHeaders = (FbpArchivesHeaders)localList.get(0);
    }
    return localFbpArchivesHeaders;
  }
  
  public List<FbpArchivesHeaders> getFbpArchivesHeadersByHeaderId(String paramString)
  {
    List localList = null;
    Object localObject = null;
    String str = "select * from FBP.FBP_ARCHIVES_HEADERS v where v.archives_header_id In(" + paramString + ")";
    SQLQuery localSQLQuery = super.getSession().createSQLQuery(str);
    localList = localSQLQuery.addEntity(FbpArchivesHeaders.class).list();
    return localList;
  }
  
  public EvsVoucher getEvsVoucher(Long paramLong)
  {
    return (EvsVoucher)super.getObject(EvsVoucher.class, paramLong);
  }
  
  public FbpArchivesHeaders getFbpArchivesHeadersByNum(Long paramLong)
  {
    Object localObject = new ArrayList();
    String str = " from FbpArchivesHeaders o where o.archivesHeaderId=?";
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramLong);
    localObject = super.getZormTemplate().find(str, localArrayList.toArray());
    FbpArchivesHeaders localFbpArchivesHeaders = new FbpArchivesHeaders();
    if (((List)localObject).size() > 0) {
      localFbpArchivesHeaders = (FbpArchivesHeaders)((List)localObject).get(0);
    }
    return localFbpArchivesHeaders;
  }
  
  public List getFbpArchivesHeaderss()
  {
    return super.getObjects(FbpArchivesHeaders.class);
  }
  
  public List<FbpArchivesHeaders> getFbpArchivesHeaderss(int paramInt1, int paramInt2)
  {
    return super.getObjects(FbpArchivesHeaders.class, paramInt1, paramInt2);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpArchivesHeaders(FbpArchivesHeaders paramFbpArchivesHeaders)
  {
    super.removeObject(paramFbpArchivesHeaders);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertFbpArchivesHeaders(FbpArchivesHeaders paramFbpArchivesHeaders)
  {
    super.insertObject(paramFbpArchivesHeaders);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateFbpArchivesHeaders(FbpArchivesHeaders paramFbpArchivesHeaders)
  {
    super.updateObject(paramFbpArchivesHeaders);
  }
  
  public void saveOrUpdate(Object paramObject)
  {
    getSession().saveOrUpdate(paramObject);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertFbpArchivesHeaderss(List<FbpArchivesHeaders> paramList)
  {
    super.insertObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpArchivesHeaderss(List<FbpArchivesHeaders> paramList)
  {
    super.removeObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpArchivesLines(Long paramLong)
  {
    super.getSessionFactory().getCurrentSession().createSQLQuery("delete FBP_ARCHIVES_LINES where ARCHIVES_HEADER_ID =" + paramLong).executeUpdate();
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateFbpArchivesHeaderss(List<FbpArchivesHeaders> paramList)
  {
    super.updateObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpArchivesHeaders(Long paramLong)
  {
    super.removeObject(FbpArchivesHeaders.class, paramLong);
  }
  
  public PageInfo findJournalNumByQry(EvsFindVoucherV paramEvsFindVoucherV, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(" from EvsFindVoucherV e where 1=1");
    if (!Util.isStrEmpty(paramEvsFindVoucherV.getJournalNum())) {
      localStringBuffer.append(" AND e.journalNum like '%" + paramEvsFindVoucherV.getJournalNum() + "%'");
    }
    if (!Util.isNullObject(paramEvsFindVoucherV.getBookCode())) {
      localStringBuffer.append(" AND e.bookCode like '%" + paramEvsFindVoucherV.getBookCode() + "%'");
    }
    if (!Util.isNullObject(paramEvsFindVoucherV.getPackageCode())) {
      localStringBuffer.append(" AND e.packageCode like '%" + paramEvsFindVoucherV.getPackageCode() + "%'");
    }
    localStringBuffer.append(" and e.companyId = '" + paramEvsFindVoucherV.getCompanyId() + "'");
    localStringBuffer.append(" and e.voucherStatus='WAREHOUSE'");
    localStringBuffer.append(" order by e.periodName,e.invoiceTypeCode,e.journalNum");
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1 / paramInt2 + 1, paramInt2, new Object[0]);
    return localPageInfo;
  }
  
  public String findApproveEmpl(String paramString)
  {
    String str = " select fel.first_line_no from fbp.fbp_employee_leaders fel where ENABLED_FLAG = 'Y' and fel.employee_number = '" + paramString + "'";
    List localList = getSession().createSQLQuery(str).list();
    if ((localList != null) && (localList.size() > 0)) {
      return (String)localList.get(0);
    }
    return null;
  }
  
  public String findEvsManageOrgV(String paramString)
  {
    Object localObject1 = new ArrayList();
    String str = "select distinct e.companyId from FbpPseRelationsV e where e.employeeId='" + paramString + "' and e.posStructureCode = 'VOUCHER_QUERY'";
    localObject1 = getZormTemplate().find(str);
    if (((List)localObject1).size() != 0)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      Iterator localIterator = ((List)localObject1).iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        localStringBuffer.append(localObject2.toString() + ",");
      }
      return localStringBuffer.substring(0, localStringBuffer.lastIndexOf(","));
    }
    return null;
  }
  
  public synchronized String getArchivesNumber()
  {
    String str = "";
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    com.zte.ssb.zorm.Session localSession = getSession();
    Connection localConnection = localSession.connection();
    CallableStatement localCallableStatement = null;
    try
    {
      localCallableStatement = localConnection.prepareCall("{call evs_generation_number_pkg.get_archives_number(?,?)}");
      localCallableStatement.registerOutParameter(2, 12);
      localCallableStatement.setLong(1, localEasUserInfo.getUserInfoPk().longValue());
      localCallableStatement.execute();
      str = localCallableStatement.getString(2);
    }
    catch (SQLException localSQLException3)
    {
      localSQLException3.printStackTrace();
    }
    finally
    {
      if (localCallableStatement != null) {
        try
        {
          localCallableStatement.close();
        }
        catch (SQLException localSQLException6)
        {
          localSQLException6.printStackTrace();
        }
      }
      if (localConnection != null) {
        try
        {
          localConnection.close();
        }
        catch (SQLException localSQLException7)
        {
          localSQLException7.printStackTrace();
        }
      }
      localSession.flush();
      localSession.clear();
    }
    return str;
  }
  
  public List<EvsVoucher> findArchivesLinesVListByHeaderId(String paramString1, String paramString2, String paramString3)
  {
    String str = "select " + paramString2 + " from " + paramString1 + " t where t." + paramString2 + " like '%" + paramString3 + "%'";
    return super.getSession().createQuery(str).list();
  }
  
  public PageInfo findFbpArchivesHeadersV(FbpArchivesHeadersV paramFbpArchivesHeadersV, int paramInt1, int paramInt2)
  {
    PageInfo localPageInfo = new PageInfo();
    ArrayList localArrayList = new ArrayList();
    String str = " from FbpArchivesHeadersV o where archivesStatus='ARCHIVES_WAIT_APPROVE'";
    if ((null != paramFbpArchivesHeadersV.getEmployeeId()) && (!"".equals(paramFbpArchivesHeadersV.getEmployeeId())))
    {
      str = str + " and o.employeeId=?";
      localArrayList.add(paramFbpArchivesHeadersV.getEmployeeId());
    }
    if ((null != paramFbpArchivesHeadersV.getApplyNum()) && (!"".equals(paramFbpArchivesHeadersV.getApplyNum())))
    {
      str = str + " and o.applyNum like ?";
      localArrayList.add(paramFbpArchivesHeadersV.getApplyNum() + "%");
    }
    if ((null != paramFbpArchivesHeadersV.getCheckUnit()) && (!"".equals(paramFbpArchivesHeadersV.getCheckUnit())))
    {
      str = str + " and o.checkUnit=?";
      localArrayList.add(paramFbpArchivesHeadersV.getCheckUnit());
    }
    if ((null != paramFbpArchivesHeadersV.getAttribute3()) && (!"".equals(paramFbpArchivesHeadersV.getAttribute3())))
    {
      str = str + " and o.applyDate>=to_date(?,'yyyy-MM-dd')";
      localArrayList.add(paramFbpArchivesHeadersV.getAttribute3());
    }
    if ((null != paramFbpArchivesHeadersV.getAttribute4()) && (!"".equals(paramFbpArchivesHeadersV.getAttribute4())))
    {
      str = str + " and o.applyDate<=to_date(?,'yyyy-MM-dd')";
      localArrayList.add(paramFbpArchivesHeadersV.getAttribute4());
    }
    str = str + " order by o.applyDate desc ";
    localPageInfo = PageInfoQuery(str, paramInt1 / paramInt2 + 1, paramInt2, localArrayList.toArray());
    return localPageInfo;
  }
  
  public String updateArchivesHeadersApprove(String paramString1, String paramString2, String paramString3)
  {
    String str = " update FbpArchivesHeaders o set o.archivesStatus='" + paramString2 + "',o.lastUpdateDate=sysdate where o.archivesHeaderId in (" + paramString1 + ")";
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString1);
    createQuery(str, new Object[0]).executeUpdate();
    return "suc";
  }
  
  public String updateArchivesHeadersProccess(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (!paramString1.equals("")) && (paramString2 != null) && (!paramString2.equals("")))
    {
      String[] arrayOfString = paramString1.split(",");
      String str1 = "select count(*) from FbpArchivesHeaders o where o.archivesHeaderId in (" + paramString1 + ") and o.apply_date<=to_date('" + paramString2 + "','yyyy-mm-dd')";
      System.out.println(str1);
      Boolean localBoolean = Boolean.valueOf(false);
      Object localObject = getSession().createSQLQuery(str1).uniqueResult();
      BigDecimal localBigDecimal = (BigDecimal)localObject;
      int i = arrayOfString.length;
      for (int j = 0; j < arrayOfString.length; j++)
      {
        localBoolean = Boolean.valueOf(false);
        for (int k = j + 1; k < arrayOfString.length; k++) {
          if (arrayOfString[j].equals(arrayOfString[k])) {
            localBoolean = Boolean.valueOf(true);
          }
        }
        if (localBoolean.booleanValue()) {
          i--;
        }
      }
      if (i != localBigDecimal.intValue()) {
        return "false";
      }
      String str2 = "update FbpArchivesHeaders o set o.archivesStatus='ARCHIVES_WAIT_REVERT',o.useDate=to_date('" + paramString2 + "','yyyy-mm-dd') where o.archivesHeaderId in (" + paramString1 + ")";
      createQuery(str2, new Object[0]).executeUpdate();
    }
    return "suc";
  }
  
  public EvsAllotHeaders findEvsAllotHeadersList(String paramString)
  {
    List localList = null;
    EvsAllotHeaders localEvsAllotHeaders = null;
    String str = "select * from evs.EVS_ALLOT_HEADERS v where v.ALLOT_NUM='" + paramString + "'";
    SQLQuery localSQLQuery = super.getSession().createSQLQuery(str);
    localList = localSQLQuery.addEntity(EvsAllotHeaders.class).list();
    if (localList.size() > 0) {
      localEvsAllotHeaders = (EvsAllotHeaders)localList.get(0);
    }
    return localEvsAllotHeaders;
  }
  
  public List<FbpArchivesHeaders> findFbpArchivesHeadersList()
  {
    List localList = null;
    String str = "select * from FBP.FBP_ARCHIVES_HEADERS v where v.ARCHIVES_STATUS='ARCHIVES_ALREADY_APPROVE' and v.ATTRIBUTE1='Y' and trunc(v.LAST_UPDATE_DATE,'dd')+1=trunc(sysdate,'dd')";
    SQLQuery localSQLQuery = super.getSession().createSQLQuery(str);
    localList = localSQLQuery.addEntity(FbpArchivesHeaders.class).list();
    return localList;
  }
  
  public List<FbpArchivesHeaders> findFbpArchivesHeadersListN()
  {
    List localList = null;
    String str = "select * from FBP.FBP_ARCHIVES_HEADERS v where v.ARCHIVES_STATUS='ARCHIVES_ALREADY_APPROVE' and v.ATTRIBUTE1='N' and trunc(v.LAST_UPDATE_DATE,'dd')+1=trunc(sysdate,'dd')";
    SQLQuery localSQLQuery = super.getSession().createSQLQuery(str);
    localList = localSQLQuery.addEntity(FbpArchivesHeaders.class).list();
    return localList;
  }
  
  public List<FbpArchivesHeaders> findFbpArchivesHeadersListNTwo()
  {
    List localList = null;
    String str = "select * from FBP.FBP_ARCHIVES_HEADERS v where v.ARCHIVES_STATUS IN('ARCHIVES_ALREADY_APPROVE','ARCHIVES_BORROWING') and trunc(fbp_function_pkg.get_date_diff(v.GIVE_BACK_DATE,2))=trunc(sysdate,'dd')";
    SQLQuery localSQLQuery = super.getSession().createSQLQuery(str);
    localList = localSQLQuery.addEntity(FbpArchivesHeaders.class).list();
    return localList;
  }
  
  public List<FbpArchivesHeaders> findFbpArchivesHeadersListWaitApp()
  {
    List localList = null;
    String str = "select * from FBP.FBP_ARCHIVES_HEADERS v where v.ARCHIVES_STATUS='ARCHIVES_WAIT_APPROVE' and trunc(v.GIVE_BACK_DATE,'dd')+1=trunc(sysdate,'dd')";
    SQLQuery localSQLQuery = super.getSession().createSQLQuery(str);
    localList = localSQLQuery.addEntity(FbpArchivesHeaders.class).list();
    return localList;
  }
  
  public String findEmployeeLeaders(String paramString)
  {
    String str1 = "";
    List localList = null;
    String str2 = "select employee_id from fbp_employees e where e.employee_number = ?";
    SQLQuery localSQLQuery = super.getSession().createSQLQuery(str2);
    localList = localSQLQuery.setString(0, paramString).list();
    if (localList.size() > 0)
    {
      BigDecimal localBigDecimal = (BigDecimal)localList.get(0);
      str1 = localBigDecimal == null ? null : localBigDecimal.toString();
    }
    return str1;
  }
  
  public String updateArchivesHeadersProccessRejected(String paramString)
  {
    String str = " update FbpArchivesHeaders o set o.archivesStatus='ARCHIVES_ALREADY_CANCEL' where o.archivesHeaderId in (" + paramString + ")";
    createQuery(str, new Object[0]).executeUpdate();
    return "suc";
  }
  
  public String updateArchivesHeadersProccessBk(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (!paramString1.equals("")) && (paramString2 != null) && (!paramString2.equals("")))
    {
      String[] arrayOfString = paramString1.split(",");
      String str1 = "select count(*) from Fbp_Archives_Headers o where o.archives_header_id in (" + paramString1 + ") and o.use_date<=to_date('" + paramString2 + "','yyyy-mm-dd')";
      Boolean localBoolean = Boolean.valueOf(false);
      Object localObject = getSession().createSQLQuery(str1).uniqueResult();
      BigDecimal localBigDecimal = (BigDecimal)localObject;
      int i = arrayOfString.length;
      for (int j = 0; j < arrayOfString.length; j++)
      {
        localBoolean = Boolean.valueOf(false);
        for (int k = j + 1; k < arrayOfString.length; k++) {
          if (arrayOfString[j].equals(arrayOfString[k]))
          {
            localBoolean = Boolean.valueOf(true);
            break;
          }
        }
        if (localBoolean.booleanValue()) {
          i--;
        }
      }
      if (i != localBigDecimal.intValue()) {
        return "false";
      }
      String str2 = " update FbpArchivesHeaders o set o.archivesStatus='ARCHIVES_ALREADY_REVERT',o.giveBackDate=to_date('" + paramString2 + "','yyyy-mm-dd') where o.archivesHeaderId in (" + paramString1 + ")";
      createQuery(str2, new Object[0]).executeUpdate();
      updateVoucherStatus(paramString1);
    }
    return "suc";
  }
  
  public void updateVoucherStatus(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("UPDATE EVS.EVS_VOUCHER EV");
    localStringBuffer.append("   SET VOUCHER_STATUS =");
    localStringBuffer.append("       (select end_status");
    localStringBuffer.append("          from (select end_status");
    localStringBuffer.append("                  from evs_voucher_history h");
    localStringBuffer.append("                 where op_object_type = '0'");
    localStringBuffer.append("                   and end_status is not null");
    localStringBuffer.append("                   and object_code = ev.voucher_id");
    localStringBuffer.append("                 order by history_id desc)");
    localStringBuffer.append("         where rownum = 1)");
    localStringBuffer.append(" WHERE EXISTS (SELECT 1");
    localStringBuffer.append("          FROM FBP.FBP_ARCHIVES_LINES AL");
    localStringBuffer.append("         WHERE EV.VOUCHER_ID = AL.VOUCHER_ID");
    localStringBuffer.append("           AND AL.ENABLED_FLAG = 'Y'");
    localStringBuffer.append("           AND AL.ARCHIVES_HEADER_ID in (?))");
    super.getSession().createSQLQuery(localStringBuffer.toString()).setString(0, paramString).executeUpdate();
  }
  
  public FbpArchivesHeadersV findFbpArchivesHeadersV(Long paramLong)
  {
    Object localObject = new ArrayList();
    String str = " from FbpArchivesHeadersV o where o.archivesHeaderId=?";
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramLong);
    localObject = super.getZormTemplate().find(str, localArrayList.toArray());
    FbpArchivesHeadersV localFbpArchivesHeadersV = new FbpArchivesHeadersV();
    if (((List)localObject).size() > 0) {
      localFbpArchivesHeadersV = (FbpArchivesHeadersV)((List)localObject).get(0);
    }
    return localFbpArchivesHeadersV;
  }
  
  public void updateArchivesHeadersStatus(String paramString1, String paramString2, String paramString3, Date paramDate)
  {
    ArrayList localArrayList = new ArrayList();
    String str = "update fbp.FBP_ARCHIVES_HEADERS set ARCHIVES_STATUS = ?";
    localArrayList.add(paramString2);
    if (paramString3 != null)
    {
      str = str + " , attribute6 = ?";
      localArrayList.add(paramString3);
    }
    if (paramDate != null)
    {
      str = str + " ,USE_DATE = ?";
      localArrayList.add(paramDate);
    }
    str = str + " where ARCHIVES_HEADER_ID in(" + paramString1 + ")";
    SQLQuery localSQLQuery = getSession().createSQLQuery(str);
    if ((localArrayList != null) && (!localArrayList.isEmpty())) {
      for (int i = 0; i < localArrayList.size(); i++) {
        localSQLQuery.setParameter(i, localArrayList.get(i));
      }
    }
    localSQLQuery.executeUpdate();
  }
  
  public void updateArchivesHeadersStatusByReturn(String paramString1, String paramString2, String paramString3, Date paramDate)
  {
    ArrayList localArrayList = new ArrayList();
    String str = "update fbp.FBP_ARCHIVES_HEADERS set ARCHIVES_STATUS = ?";
    localArrayList.add(paramString2);
    if (paramString3 != null)
    {
      str = str + " , attribute6 = ?";
      localArrayList.add(paramString3);
    }
    if (paramDate != null)
    {
      str = str + " ,give_Back_Date = ?";
      localArrayList.add(paramDate);
    }
    str = str + " where ARCHIVES_HEADER_ID in(" + paramString1 + ")";
    SQLQuery localSQLQuery = getSession().createSQLQuery(str);
    if ((localArrayList != null) && (!localArrayList.isEmpty())) {
      for (int i = 0; i < localArrayList.size(); i++) {
        localSQLQuery.setParameter(i, localArrayList.get(i));
      }
    }
    localSQLQuery.executeUpdate();
  }
  
  public void updateVoucherStatus(String paramString1, String paramString2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("UPDATE EVS.EVS_VOUCHER EV");
    localStringBuffer.append("   SET VOUCHER_STATUS = ?");
    localStringBuffer.append(" WHERE EXISTS (SELECT 1");
    localStringBuffer.append("          FROM FBP.FBP_ARCHIVES_LINES AL");
    localStringBuffer.append("         WHERE EV.VOUCHER_ID = AL.VOUCHER_ID");
    localStringBuffer.append("           AND AL.ENABLED_FLAG = 'Y'");
    localStringBuffer.append("           AND AL.ARCHIVES_HEADER_ID in (?))");
    super.getSession().createSQLQuery(localStringBuffer.toString()).setString(0, paramString2).setString(1, paramString1).executeUpdate();
  }
  
  public void insertFbpArchivesHistories(String paramString1, Long paramLong, String paramString2)
  {
    FbpArchivesHistories localFbpArchivesHistories = new FbpArchivesHistories();
    ObjectCopyUtils.setWho(localFbpArchivesHistories);
    localFbpArchivesHistories.setEnabledFlag("Y");
    localFbpArchivesHistories.setApproveCommand(paramString1);
    localFbpArchivesHistories.setApproveComment(null);
    localFbpArchivesHistories.setArchivesHeaderId(paramLong);
    localFbpArchivesHistories.setArchivesStatus(paramString2);
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    localFbpArchivesHistories.setEmployeeId(Long.valueOf(localEasUserInfo.getUserInfoPk().longValue()));
    localFbpArchivesHistories.setEmployeeName(localEasUserInfo.getUserName());
    localFbpArchivesHistories.setEmployeeNumber(localEasUserInfo.getUserId());
    super.insertObject(localFbpArchivesHistories);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.archives.FbpArchivesHeadersDAO
 * JD-Core Version:    0.7.0.1
 */