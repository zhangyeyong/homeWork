package com.zte.evs.ebill.access.eBillManage;

import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.eas.organization.business.countcompanymanage.model.FbpCompanyV;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesLovV;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesV;
import com.zte.evs.ebill.common.EvsObjectUtils;
import com.zte.evs.ebill.model.archives.FindEmployeesV;
import com.zte.evs.ebill.model.eBillManage.EvsAllotDetails;
import com.zte.evs.ebill.model.eBillManage.EvsAllotHeaders;
import com.zte.evs.ebill.model.eBillManage.EvsAllotHeadersV;
import com.zte.evs.ebill.model.eBillManage.EvsBook;
import com.zte.evs.ebill.model.eBillManage.EvsBookV;
import com.zte.evs.ebill.model.eBillManage.EvsInventory;
import com.zte.evs.ebill.model.eBillManage.EvsPackage;
import com.zte.evs.ebill.model.eBillManage.EvsVoucher;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherBookPackage;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.util.Util;
import com.zte.ssb.orm.zorm.ZormTemplate;
import com.zte.ssb.servicecontainer.business.server.ISession;
import com.zte.ssb.servicecontainer.business.server.RIAContext;
import com.zte.ssb.ui.uiloader.model.UserInfo;
import com.zte.ssb.zorm.Query;
import com.zte.ssb.zorm.SQLQuery;
import com.zte.ssb.zorm.Session;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;

public class VoucherFlittingDAO
  extends BaseDAO
  implements IVoucherFlittingDAO
{
  static final String LOGIN_USERINFO = "loginuserinfo";
  static final String EAS_LOGIN_USERINFO = "easloginuserinfo";
  
  public void addFlittingInvoicesHeader(EvsAllotHeaders paramEvsAllotHeaders)
  {
    super.getZormTemplate().saveOrUpdate(paramEvsAllotHeaders);
  }
  
  public void addFlittingInvoicesLine(EvsAllotDetails paramEvsAllotDetails)
  {
    super.getZormTemplate().save(paramEvsAllotDetails);
  }
  
  public int delFlittingDetailsLine(BigInteger paramBigInteger)
  {
    String str = "delete EVS_ALLOT_DETAILS where ALLOT_DETAIL_ID=" + paramBigInteger;
    return super.getSession().createSQLQuery(str).executeUpdate();
  }
  
  public void delFlittingInvoicesHeader(EvsAllotHeaders paramEvsAllotHeaders)
  {
    super.getZormTemplate().delete(paramEvsAllotHeaders);
  }
  
  public int delFlittingInvoicesHeader(BigInteger paramBigInteger)
  {
    String str = "delete EVS_ALLOT_HEADERS where ALLOT_HEADER_ID=" + paramBigInteger;
    return super.getSession().createSQLQuery(str).executeUpdate();
  }
  
  public void delFlittingInvoicesLine(EvsAllotDetails paramEvsAllotDetails)
  {
    super.getZormTemplate().delete(paramEvsAllotDetails);
  }
  
  public void updateFlittingInvoicesHeader(EvsAllotHeaders paramEvsAllotHeaders)
  {
    super.getZormTemplate().update(paramEvsAllotHeaders);
  }
  
  public void updateFlittingInvoicesLine(EvsAllotDetails paramEvsAllotDetails)
  {
    super.getZormTemplate().update(paramEvsAllotDetails);
  }
  
  public EvsAllotHeaders getEvsAllotHeaders(BigInteger paramBigInteger)
  {
    return (EvsAllotHeaders)super.getSession().get(EvsAllotHeaders.class, paramBigInteger);
  }
  
  public EvsAllotHeaders getEvsAllotHeadersByAllotNum(String paramString)
  {
    String str = "from EvsAllotHeaders eh where eh.allotNum='" + paramString + "'";
    List localList = super.getZormTemplate().find(str);
    if ((localList != null) && (localList.size() > 0)) {
      return (EvsAllotHeaders)localList.get(0);
    }
    return null;
  }
  
  public void updateInventoryByBookId(EvsInventory paramEvsInventory)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(" UPDATE EvsInventory EI SET ");
    localStringBuffer.append(" EI.invCityId=" + paramEvsInventory.getInvCityId() + ",");
    localStringBuffer.append(" EI.invStorageCode='" + paramEvsInventory.getInvStorageCode() + "'");
    if (!Util.isStrEmpty(paramEvsInventory.getInvArea())) {
      localStringBuffer.append(", EI.invArea='" + paramEvsInventory.getInvArea() + "'");
    }
    if (!Util.isStrEmpty(paramEvsInventory.getInvRow())) {
      localStringBuffer.append(", EI.invRow='" + paramEvsInventory.getInvRow() + "'");
    }
    if (!Util.isStrEmpty(paramEvsInventory.getInvColumn())) {
      localStringBuffer.append(", EI.invColumn='" + paramEvsInventory.getInvColumn() + "'");
    }
    if (!Util.isStrEmpty(paramEvsInventory.getInvLevel())) {
      localStringBuffer.append(", EI.invLevel='" + paramEvsInventory.getInvLevel() + "'");
    }
    if (!Util.isStrEmpty(paramEvsInventory.getEnabledFlag())) {
      localStringBuffer.append(", EI.enabledFlag='" + paramEvsInventory.getEnabledFlag() + "'");
    }
    localStringBuffer.append(" WHERE EI.bookId=" + paramEvsInventory.getBookId()).append(" and EI.enabledFlag='Y'");
    int i = createQuery(localStringBuffer.toString(), new Object[0]).executeUpdate();
  }
  
  public EvsInventory getEvsInventoryCan(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer("from EvsInventory e where e.bookId='");
    localStringBuffer.append(paramString);
    localStringBuffer.append("' and e.enabledFlag='Y' order by e.lastUpdateDate desc");
    List localList = super.getZormTemplate().find(localStringBuffer.toString());
    if ((localList != null) && (localList.size() > 0)) {
      return (EvsInventory)localList.get(0);
    }
    return null;
  }
  
  public void delEvsAllotHeadersByDetails(BigInteger paramBigInteger)
  {
    String str = "delete EVS_ALLOT_DETAILS where ALLOT_HEADER_ID=" + paramBigInteger;
    super.getSession().createSQLQuery(str).executeUpdate();
  }
  
  public List<String> getEvsAllotHeadersByDetails(BigInteger paramBigInteger)
  {
    String str = "select relationId from EvsAllotDetails where allotHeaderId=" + paramBigInteger;
    return super.getZormTemplate().find(str);
  }
  
  public List<String> findEmpCheckUtil(String paramString)
  {
    String str = "select lv.check_unit,lv.check_unit_name from apps.fbp_employees_login_v lv where lv.employee_number = '" + paramString + "'";
    List localList = super.getSession().createSQLQuery(str).list();
    ArrayList localArrayList = new ArrayList();
    if ((localList != null) && (localList.size() > 0))
    {
      Object[] arrayOfObject = (Object[])localList.get(0);
      localArrayList.add(arrayOfObject[0] == null ? "" : arrayOfObject[0].toString());
      localArrayList.add(arrayOfObject[1] == null ? "" : arrayOfObject[1].toString());
    }
    return localArrayList;
  }
  
  public List<String[]> findAllotType(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = "  select distinct tp.allot_type_id,tp.allot_type_code,tp.allot_type_name,tp.description from evs.evs_allot_types tp where tp.allot_type_id in ( select ar.allot_type_id from evs.evs_allot_relations ar where 1=1  AND ar.enabled_flag = 'Y'";
    if (!Util.isStrEmpty(paramString1)) {
      str = str + " and ar.source_check_unit='" + paramString1 + "'";
    }
    if (!Util.isStrEmpty(paramString3)) {
      str = str + " and ar.store_check_unit='" + paramString3 + "'";
    }
    if (!Util.isStrEmpty(paramString4)) {
      str = str + " and ar.Archives_Site_Id=" + paramString4;
    }
    str = str + ")";
    if (!Util.isStrEmpty(paramString2)) {
      str = str + " AND TP.ALLOT_WAY = '" + paramString2 + "'";
    }
    List localList = super.getSession().createSQLQuery(str).list();
    ArrayList localArrayList = new ArrayList();
    if ((localList != null) && (localList.size() > 0)) {
      for (int i = 0; i < localList.size(); i++)
      {
        Object[] arrayOfObject = (Object[])localList.get(i);
        String[] arrayOfString = { arrayOfObject[0] == null ? "" : arrayOfObject[0].toString(), arrayOfObject[2] == null ? "" : arrayOfObject[2].toString() };
        localArrayList.add(arrayOfString);
      }
    }
    return localArrayList;
  }
  
  public List<String[]> findStoreCheckUnit(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = " SELECT distinct AR.STORE_CHECK_UNIT,cu.check_unit_name FROM evs.evs_allot_relations AR ,fbp_check_unit_contents cu WHERE AR.STORE_CHECK_UNIT=cu.check_unit(+)  AND AR.enabled_flag = 'Y'";
    if (!Util.isStrEmpty(paramString1)) {
      str = str + "AND AR.SOURCE_CHECK_UNIT ='" + paramString1 + "'";
    }
    if (!Util.isStrEmpty(paramString3)) {
      str = str + "  AND AR.ALLOT_TYPE_ID =" + paramString3;
    }
    if (!Util.isStrEmpty(paramString4)) {
      str = str + " and ar.Archives_Site_Id=" + paramString4;
    }
    if (!Util.isStrEmpty(paramString2)) {
      str = str + " AND EXISTS (select tp.allot_type_id from evs_allot_types tp where tp.allot_way = '" + paramString2 + "' and tp.allot_type_id = AR.ALLOT_TYPE_ID)";
    }
    List localList = super.getSession().createSQLQuery(str).list();
    ArrayList localArrayList = new ArrayList();
    if ((localList != null) && (localList.size() > 0)) {
      for (int i = 0; i < localList.size(); i++)
      {
        Object[] arrayOfObject = (Object[])localList.get(i);
        String[] arrayOfString = { arrayOfObject[0] == null ? "" : arrayOfObject[0].toString(), arrayOfObject[1] == null ? "" : arrayOfObject[1].toString() };
        localArrayList.add(arrayOfString);
      }
    }
    return localArrayList;
  }
  
  public List<String[]> findStoreSit(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = " SELECT distinct ARS.ARCHIVES_SITE_ID, ARS.ARCHIVES_SITE_CODE,ARS.ARCHIVES_SITE_NAME,CU.CHECK_UNIT_NAME   FROM EVS.EVS_ARCHIVES_SITES ARS ,fbp_check_unit_contents cu WHERE ARS.ARCHIVES_SITE_ID IN ( select ar.Archives_Site_Id from evs.evs_allot_relations AR  where 1=1  AND ar.enabled_flag = 'Y' ";
    if (!Util.isStrEmpty(paramString1)) {
      str = str + " AND AR.SOURCE_CHECK_UNIT ='" + paramString1 + "'";
    }
    if (!Util.isStrEmpty(paramString4)) {
      str = str + " AND AR.store_check_unit ='" + paramString4 + "'";
    }
    if (!Util.isStrEmpty(paramString3)) {
      str = str + "  AND AR.ALLOT_TYPE_ID =" + paramString3;
    }
    if (!Util.isStrEmpty(paramString2)) {
      str = str + " AND EXISTS (select tp.allot_type_id from evs_allot_types tp where tp.allot_way = '" + paramString2 + "' and tp.allot_type_id = AR.ALLOT_TYPE_ID)";
    }
    str = str + ") AND ARS.CHECK_UNIT= CU.CHECK_UNIT(+)";
    List localList = super.getSession().createSQLQuery(str).list();
    ArrayList localArrayList = new ArrayList();
    if ((localList != null) && (localList.size() > 0)) {
      for (int i = 0; i < localList.size(); i++)
      {
        Object[] arrayOfObject = (Object[])localList.get(i);
        String[] arrayOfString = { arrayOfObject[0] == null ? "" : arrayOfObject[0].toString(), arrayOfObject[2] == null ? "" : arrayOfObject[2].toString() };
        localArrayList.add(arrayOfString);
      }
    }
    return localArrayList;
  }
  
  public FbpEmployeesV getEmpVInfo(String paramString)
  {
    String str = "FROM FbpEmployeesV EMPV WHERE EMPV.employeeNumber= '" + paramString + "'";
    List localList = super.getSession().createQuery(str).list();
    if ((localList != null) && (localList.size() > 0)) {
      return (FbpEmployeesV)localList.get(0);
    }
    return null;
  }
  
  public FbpEmployeesLovV getEmpLovVInfo(String paramString)
  {
    String str = "FROM FbpEmployeesLovV EMPV WHERE EMPV.employeeId= '" + paramString + "'";
    List localList = super.getSession().createQuery(str).list();
    if ((localList != null) && (localList.size() > 0)) {
      return (FbpEmployeesLovV)localList.get(0);
    }
    return null;
  }
  
  public FbpCompanyV getCompanyById(String paramString)
  {
    String str = "FROM FbpCompanyV cv WHERE cv.companyId= '" + paramString + "'";
    List localList = super.getSession().createQuery(str).list();
    if ((localList != null) && (localList.size() > 0)) {
      return (FbpCompanyV)localList.get(0);
    }
    return null;
  }
  
  public PageInfo findAllotHeaders(EvsAllotHeadersV paramEvsAllotHeadersV, Integer paramInteger1, Integer paramInteger2)
  {
    ArrayList localArrayList = new ArrayList();
    String str = "FROM EvsAllotHeaders HD WHERE 1=1";
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    if (paramEvsAllotHeadersV != null)
    {
      if (paramEvsAllotHeadersV.getAllotHeaderId() != null) {
        str = str + " AND HD.allotHeaderId = " + paramEvsAllotHeadersV.getAllotHeaderId();
      }
      int i = 0;
      if ((!Util.isStrEmpty(paramEvsAllotHeadersV.getAllotNumBegin())) && (!Util.isStrEmpty(paramEvsAllotHeadersV.getAllotNumEnd())) && (paramEvsAllotHeadersV.getAllotNumBegin().equals(paramEvsAllotHeadersV.getAllotNumEnd())))
      {
        str = str + " AND HD.allotNum like ?";
        localArrayList.add(paramEvsAllotHeadersV.getAllotNumEnd());
        i = 1;
      }
      if (i == 0)
      {
        if (!Util.isStrEmpty(paramEvsAllotHeadersV.getAllotNumBegin()))
        {
          str = str + " AND HD.allotNum >= ?";
          localArrayList.add(paramEvsAllotHeadersV.getAllotNumBegin());
        }
        if (!Util.isStrEmpty(paramEvsAllotHeadersV.getAllotNumEnd()))
        {
          str = str + " AND HD.allotNum <= ?";
          localArrayList.add(paramEvsAllotHeadersV.getAllotNumEnd());
        }
      }
      if (paramEvsAllotHeadersV.getAllotTypeId() != null) {
        str = str + " AND HD.allotTypeId=" + paramEvsAllotHeadersV.getAllotTypeId();
      }
      if (paramEvsAllotHeadersV.getAllotBy() != null) {
        str = str + " AND HD.allotBy = " + paramEvsAllotHeadersV.getAllotBy();
      }
      if (!Util.isStrEmpty(paramEvsAllotHeadersV.getAllotMode())) {
        str = str + " AND HD.allotMode = '" + paramEvsAllotHeadersV.getAllotMode() + "'";
      }
      if (!Util.isStrEmpty(paramEvsAllotHeadersV.getBeginDate())) {
        str = str + " AND HD.allotDate >= TO_DATE('" + paramEvsAllotHeadersV.getBeginDate() + "','YYYY-MM-DD')";
      }
      if (!Util.isStrEmpty(paramEvsAllotHeadersV.getEndDate())) {
        str = str + " AND HD.allotDate - 1 <= TO_DATE('" + paramEvsAllotHeadersV.getEndDate() + "','YYYY-MM-DD') ";
      }
      RIAContext localRIAContext = RIAContext.getCurrentInstance();
      ISession localISession = localRIAContext.getSession();
      UserInfo localUserInfo = (UserInfo)localISession.getSessionAttribute("loginuserinfo");
      EasUserInfo localEasUserInfo = (EasUserInfo)localISession.getSessionAttribute("easloginuserinfo");
      Long localLong = new Long(localEasUserInfo.getUserInfoPk().toString());
      if ((localLong != null) && (!localLong.equals("")) && (localLong.longValue() != 0L)) {
        str = str + " AND HD.allotBy= " + localLong;
      }
      str = str + " order by creationDate desc,lastUpdateDate desc";
    }
    return super.PageInfoQuery(str, paramInteger1.intValue() / paramInteger2.intValue() + 1, paramInteger2.intValue(), localArrayList.toArray());
  }
  
  public PageInfo findAllotHeadersV2(EvsAllotHeadersV paramEvsAllotHeadersV, Integer paramInteger1, Integer paramInteger2)
  {
    StringBuilder localStringBuilder = new StringBuilder("FROM EvsAllotHeadersV HD WHERE 1=1");
    ArrayList localArrayList = new ArrayList();
    if (paramEvsAllotHeadersV != null)
    {
      if (null != paramEvsAllotHeadersV.getCompanyId()) {
        localStringBuilder.append(" AND HD.companyId =  ").append(paramEvsAllotHeadersV.getCompanyId());
      }
      if (StringUtils.isNotEmpty(paramEvsAllotHeadersV.getAllotNum())) {
        if (paramEvsAllotHeadersV.getBlurQuery().equalsIgnoreCase("Y")) {
          localStringBuilder.append(" AND HD.allotNum like '%").append(paramEvsAllotHeadersV.getAllotNum()).append("%'");
        } else {
          localStringBuilder.append(" AND HD.allotNum =  '").append(paramEvsAllotHeadersV.getAllotNum()).append("'");
        }
      }
      if (null != paramEvsAllotHeadersV.getAllotBy()) {
        localStringBuilder.append(" AND HD.allotBy = ").append(paramEvsAllotHeadersV.getAllotBy());
      }
      if (StringUtils.isNotEmpty(paramEvsAllotHeadersV.getAllotStatus())) {
        localStringBuilder.append(" AND HD.allotStatus =  '").append(paramEvsAllotHeadersV.getAllotStatus()).append("'");
      }
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
      if (StringUtils.isNotEmpty(paramEvsAllotHeadersV.getBeginDate()))
      {
        localStringBuilder.append(" AND HD.allotDate  >= ?");
        try
        {
          localArrayList.add(localSimpleDateFormat.parseObject(paramEvsAllotHeadersV.getBeginDate()));
        }
        catch (ParseException localParseException1)
        {
          localParseException1.printStackTrace();
        }
      }
      if (StringUtils.isNotEmpty(paramEvsAllotHeadersV.getEndDate()))
      {
        localStringBuilder.append(" AND (HD.allotDate -1) < ?");
        try
        {
          localArrayList.add(localSimpleDateFormat.parse(paramEvsAllotHeadersV.getEndDate()));
        }
        catch (ParseException localParseException2)
        {
          localParseException2.printStackTrace();
        }
      }
      if (StringUtils.isNotEmpty(paramEvsAllotHeadersV.getAllotMode())) {
        localStringBuilder.append(" AND HD.allotMode= '").append(paramEvsAllotHeadersV.getAllotMode()).append("'");
      }
      if (StringUtils.isNotEmpty(paramEvsAllotHeadersV.getRec_beginDate()))
      {
        localStringBuilder.append(" AND HD.receiveDate  >= ?");
        try
        {
          localArrayList.add(localSimpleDateFormat.parseObject(paramEvsAllotHeadersV.getRec_beginDate()));
        }
        catch (ParseException localParseException3)
        {
          localParseException3.printStackTrace();
        }
      }
      if (StringUtils.isNotEmpty(paramEvsAllotHeadersV.getRec_endDate()))
      {
        localStringBuilder.append(" AND (HD.receiveDate -1) < ?");
        try
        {
          localArrayList.add(localSimpleDateFormat.parse(paramEvsAllotHeadersV.getRec_endDate()));
        }
        catch (ParseException localParseException4)
        {
          localParseException4.printStackTrace();
        }
      }
      if (null != paramEvsAllotHeadersV.getReceiveBy()) {
        localStringBuilder.append(" AND HD.receiveBy= ").append(paramEvsAllotHeadersV.getReceiveBy());
      }
      EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
      EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
      if ((!Util.isStrEmpty(localEasUserInfo.getUserInfoPk().toString())) && (!"10000".equals(localEasUserInfo.getUserId()))) {
        localStringBuilder.append(" and exists(from FbpPseRelationsV f where f.posStructureCode = 'VOUCHER_QUERY' and f.companyId=HD.companyId and f.employeeId = ").append(localEasUserInfo.getUserInfoPk().toString()).append(")");
      }
    }
    return super.PageInfoQuery(localStringBuilder.toString(), paramInteger1.intValue() / paramInteger2.intValue() + 1, paramInteger2.intValue(), localArrayList.toArray());
  }
  
  public FindEmployeesV findEmployeesLoginV()
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    return (FindEmployeesV)getObject(FindEmployeesV.class, Long.valueOf(localEasUserInfo.getUserInfoPk().longValue()));
  }
  
  public PageInfo findAllotHeadersByIncept(EvsAllotHeadersV paramEvsAllotHeadersV, Integer paramInteger1, Integer paramInteger2)
  {
    String str = "FROM EvsAllotHeadersV HD WHERE 1=1";
    ArrayList localArrayList = new ArrayList();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    if (paramEvsAllotHeadersV != null)
    {
      if (paramEvsAllotHeadersV.getAllotHeaderId() != null) {
        str = str + " AND HD.allotHeaderId = " + paramEvsAllotHeadersV.getAllotHeaderId();
      }
      if (!Util.isStrEmpty(paramEvsAllotHeadersV.getAllotNum())) {
        if ((paramEvsAllotHeadersV.getBlurQuery() != null) && (paramEvsAllotHeadersV.getBlurQuery().equals("Y")))
        {
          str = str + " AND HD.allotNum like ? ";
          localArrayList.add("%" + paramEvsAllotHeadersV.getAllotNum().trim() + "%");
        }
        else
        {
          str = str + " AND HD.allotNum = ? ";
          localArrayList.add(paramEvsAllotHeadersV.getAllotNum().trim());
        }
      }
      if (!Util.isStrEmpty(paramEvsAllotHeadersV.getAllotNumBegin()))
      {
        str = str + " AND HD.allotNum >= ?";
        localArrayList.add(paramEvsAllotHeadersV.getAllotNumBegin().trim());
      }
      if (!Util.isStrEmpty(paramEvsAllotHeadersV.getAllotNumEnd()))
      {
        str = str + " AND HD.allotNum <= ?";
        localArrayList.add(paramEvsAllotHeadersV.getAllotNumEnd().trim());
      }
      if (paramEvsAllotHeadersV.getAllotTypeId() != null) {
        str = str + " AND HD.allotTypeId=" + paramEvsAllotHeadersV.getAllotTypeId();
      }
      if (paramEvsAllotHeadersV.getAllotBy() != null) {
        str = str + " AND HD.allotBy = " + paramEvsAllotHeadersV.getAllotBy();
      }
      if (!Util.isStrEmpty(paramEvsAllotHeadersV.getAllotStatus())) {
        str = str + " AND HD.allotStatus = '" + paramEvsAllotHeadersV.getAllotStatus() + "'";
      }
      if (!Util.isStrEmpty(paramEvsAllotHeadersV.getAllotMode())) {
        str = str + " AND HD.allotMode = '" + paramEvsAllotHeadersV.getAllotMode() + "'";
      }
      if (!Util.isStrEmpty(paramEvsAllotHeadersV.getBeginDate())) {
        str = str + " AND HD.allotDate >= TO_DATE('" + paramEvsAllotHeadersV.getBeginDate() + "','YYYY-MM-DD')";
      }
      if (!Util.isStrEmpty(paramEvsAllotHeadersV.getEndDate())) {
        str = str + " AND HD.allotDate - 1 <= TO_DATE('" + paramEvsAllotHeadersV.getEndDate() + "','YYYY-MM-DD') ";
      }
      if (!Util.isStrEmpty(paramEvsAllotHeadersV.getRec_beginDate())) {
        str = str + " AND HD.receiveDate >= TO_DATE('" + paramEvsAllotHeadersV.getRec_beginDate() + "','YYYY-MM-DD')";
      }
      if (!Util.isStrEmpty(paramEvsAllotHeadersV.getRec_endDate())) {
        str = str + " AND HD.receiveDate - 1 <= TO_DATE('" + paramEvsAllotHeadersV.getRec_endDate() + "','YYYY-MM-DD')";
      }
      str = str + "AND (HD.allotStatus='NOW_FLITTING' or HD.allotStatus='ALREADY_RECEIVE'  or HD.allotStatus='REMOVE_FLITTING' or HD.allotStatus='ALREADY_RETURN')";
      RIAContext localRIAContext = RIAContext.getCurrentInstance();
      ISession localISession = localRIAContext.getSession();
      UserInfo localUserInfo = (UserInfo)localISession.getSessionAttribute("loginuserinfo");
      EasUserInfo localEasUserInfo = (EasUserInfo)localISession.getSessionAttribute("easloginuserinfo");
      Long localLong = new Long(localEasUserInfo.getUserInfoPk().toString());
      if ((localLong != null) && (!localLong.equals("")) && (localLong.longValue() != 0L)) {
        str = str + " AND HD.receiveBy= " + localLong;
      }
    }
    return super.PageInfoQuery(str, paramInteger1.intValue() / paramInteger2.intValue() + 1, paramInteger2.intValue(), localArrayList.toArray());
  }
  
  public PageInfo findBookByAllotNum(String paramString, Integer paramInteger1, Integer paramInteger2)
  {
    List localList = findRelationIdByAllotNum(Long.valueOf(Long.parseLong(paramString)));
    String str1 = fmtList(localList, null);
    if (Util.isStrEmpty(str1)) {
      return new PageInfo();
    }
    String str2 = "from EvsBookV bo where bo.bookId in (" + str1 + ")";
    return super.PageInfoQuery(str2, paramInteger1.intValue() / paramInteger2.intValue() + 1, paramInteger2.intValue(), null);
  }
  
  public PageInfo findVoucherByAllotNum(String paramString, Integer paramInteger1, Integer paramInteger2)
  {
    List localList = findRelationIdByAllotNum(Long.valueOf(Long.parseLong(paramString)));
    String str1 = fmtList(localList, null);
    if (Util.isStrEmpty(str1)) {
      return new PageInfo();
    }
    String str2 = "from EvsVoucherV bo where bo.voucherId in (" + str1 + ")";
    return super.PageInfoQuery(str2, paramInteger1.intValue() / paramInteger2.intValue() + 1, paramInteger2.intValue(), null);
  }
  
  public List<EvsBook> findBookByAllotId(Long paramLong)
  {
    List localList = findRelationIdByAllotNum(paramLong);
    String str1 = fmtList(localList, null);
    if (Util.isStrEmpty(str1)) {
      return new ArrayList();
    }
    String str2 = "from EvsBook bo where bo.bookId in (" + str1 + ")";
    return super.getZormTemplate().find(str2);
  }
  
  public List<EvsBookV> findBookByAllotIdForExport(Long paramLong)
  {
    List localList = findRelationIdByAllotNum(paramLong);
    String str1 = fmtList(localList, null);
    if (Util.isStrEmpty(str1)) {
      return new ArrayList();
    }
    String str2 = "from EvsBookV bo where bo.bookId in (" + str1 + ")";
    return super.getZormTemplate().find(str2);
  }
  
  public EvsAllotHeadersV findAllotHeadersById(Long paramLong)
  {
    Object localObject = null;
    String str = "from EvsAllotHeadersV h where h.allotHeaderId= " + paramLong;
    List localList = super.getZormTemplate().find(str);
    if (localList.size() > 0) {
      return (EvsAllotHeadersV)localList.get(0);
    }
    return null;
  }
  
  public EvsBook findBookByBookId(Long paramLong)
  {
    if (Util.isStrEmpty(paramLong.toString())) {
      return new EvsBook();
    }
    String str = "from EvsBook bo where bo.bookId = " + paramLong;
    List localList = super.getZormTemplate().find(str);
    if (localList.size() > 0) {
      return (EvsBook)localList.get(0);
    }
    return null;
  }
  
  public List<String> findRelationIdByAllotNum(Long paramLong)
  {
    String str = "SELECT AD.RELATION_ID FROM EVS.EVS_ALLOT_DETAILS AD WHERE AD.ALLOT_HEADER_ID = " + paramLong;
    List localList = super.getSession().createSQLQuery(str).list();
    return localList;
  }
  
  public PageInfo findBoxByAllotNum(String paramString, int paramInt1, int paramInt2)
  {
    List localList = findRelationIdByAllotNum(Long.valueOf(Long.parseLong(paramString)));
    String str1 = fmtList(localList, null);
    if (Util.isStrEmpty(str1)) {
      return new PageInfo();
    }
    String str2 = "from EvsPackageV box where box.packageId in (" + str1 + ")";
    return super.PageInfoQuery(str2, paramInt1 / paramInt2 + 1, paramInt2, null);
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
  
  public List<EvsAllotHeadersV> findAllotByNum(List<String> paramList)
  {
    String str1 = fmtList(paramList, "'");
    if (Util.isStrEmpty(str1)) {
      return new ArrayList();
    }
    String str2 = "FROM EvsAllotHeadersV HD WHERE HD.allotNum in (" + str1 + ")";
    Object localObject = new ArrayList();
    localObject = super.getSession().createQuery(str2).list();
    return localObject;
  }
  
  public List<EvsAllotHeadersV> findAllotById(List<String> paramList)
  {
    String str1 = fmtList(paramList, "'");
    if (Util.isStrEmpty(str1)) {
      return new ArrayList();
    }
    String str2 = "FROM EvsAllotHeadersV HD WHERE HD.allotHeaderId in (" + str1 + ")";
    Object localObject = new ArrayList();
    localObject = super.getSession().createQuery(str2).list();
    return localObject;
  }
  
  public PageInfo findBoxByAllotNumNew(String paramString, List<String> paramList, int paramInt1, int paramInt2)
  {
    String str1 = fmtList(paramList, "'");
    List localList = findRelationIdByAllotNumNew(paramString, str1);
    String str2 = fmtList(localList, null);
    if (Util.isStrEmpty(str2)) {
      return new PageInfo();
    }
    String str3 = "from EvsPackageV box where box.packageId in (" + str2 + ") ";
    return super.PageInfoQuery(str3, paramInt1 / paramInt2 + 1, paramInt2, null);
  }
  
  public List<EvsPackage> findBoxByAllotId(String paramString)
  {
    List localList = findRelationIdByAllotNumNew(paramString);
    String str1 = fmtList(localList, null);
    if (Util.isStrEmpty(str1)) {
      return new ArrayList();
    }
    String str2 = "from EvsPackage box where box.packageId in (" + str1 + ") ";
    return super.getZormTemplate().find(str2);
  }
  
  public List<String> findRelationIdByAllotNumNew(String paramString)
  {
    String str = "SELECT AD.RELATION_ID FROM EVS.EVS_ALLOT_DETAILS AD WHERE AD.ALLOT_HEADER_ID = " + paramString;
    List localList = super.getSession().createSQLQuery(str).list();
    return localList;
  }
  
  public List<String> findRelationIdByAllotNumNew(String paramString1, String paramString2)
  {
    String str = "SELECT AD.RELATION_ID FROM EVS.EVS_ALLOT_DETAILS AD WHERE AD.ALLOT_HEADER_ID = " + paramString1;
    if (!Util.isStrEmpty(paramString2)) {
      str = str + " AND AD.RELATION_ID NOT IN (" + paramString2 + ")";
    }
    List localList = super.getSession().createSQLQuery(str).list();
    return localList;
  }
  
  public PageInfo findBookByNumbs(List<String> paramList, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramList == null) && (paramList.size() < 1)) {
      return new PageInfo();
    }
    String str1 = fmtList(paramList, "'");
    str1 = str1 == null ? "'-1'" : str1;
    str1 = "".equals(str1) ? "'-1'" : str1;
    String str2 = "FROM EvsBookV eb WHERE 1=1 ";
    if ("FLITTING".equals(paramString)) {
      str2 = str2 + " and eb.bookStatus in ('BOOKED','UNPACKAG','ALREADY_RECEIVE','NOT_RECEIVE')";
    } else if ("RECEIVE".equals(paramString)) {
      str2 = str2 + " AND eb.bookStatus in('ALREADY_FLITTING')";
    }
    str2 = str2 + " AND eb.bookId IN(" + str1 + ")";
    return super.PageInfoQuery(str2, paramInt1 / paramInt2 + 1, paramInt2, null);
  }
  
  public List<EvsAllotHeaders> findAllotBoeBySubId(String paramString)
  {
    String str = "FROM EvsAllotHeaders hd where hd.allotHeaderId in (select ds.allotHeaderId from EvsAllotDetails ds where ds.relationId = " + paramString + ")" + " order by hd.lastUpdateDate desc";
    List localList = super.getSession().createQuery(str).list();
    return localList;
  }
  
  public List<EvsAllotDetails> findAllotDetailsByAllotHeaderId(Long paramLong, String paramString)
  {
    String str = "FROM EvsAllotDetails hd where hd.allotHeaderId =" + paramLong + " and hd.relationType='" + paramString + "'";
    List localList = super.getSession().createQuery(str).list();
    return localList;
  }
  
  public List<EvsVoucher> getEvsVoucher(String paramString1, String paramString2)
  {
    String str = " from EvsVoucher e where 1=1 and e.journalNum>='" + paramString1 + "' and journalNum<='" + paramString2 + "'";
    List localList = getZormTemplate().find(str);
    return localList;
  }
  
  public void updateEvsVoucher(EvsVoucher paramEvsVoucher)
  {
    updateObject(paramEvsVoucher);
  }
  
  public void updatePackage(EvsPackage paramEvsPackage)
  {
    updateObject(paramEvsPackage);
  }
  
  public List<EvsVoucherBookPackage> getEvsVoucherByBookId(Long paramLong)
  {
    String str = "from EvsVoucherBookPackage e where 1=1";
    if ((paramLong != null) && (!paramLong.equals(""))) {
      str = str + " and e.bookId=" + paramLong;
    }
    return getZormTemplate().find(str);
  }
  
  public List<EvsVoucherBookPackage> getEvsVoucherByPackageId(Long paramLong)
  {
    String str = "from EvsVoucherBookPackage e where 1=1";
    if ((paramLong != null) && (!paramLong.equals(""))) {
      str = str + " and e.packageId=" + paramLong;
    }
    return getZormTemplate().find(str);
  }
  
  public void updateInventory(Long paramLong)
  {
    String str = "update evs.evs_inventory set enabled_flag = 'N' where inv_book_id = " + paramLong;
    super.getSession().createSQLQuery(str).executeUpdate();
  }
  
  public void updateObject(Object paramObject)
  {
    super.updateObject(paramObject);
  }
  
  public PageInfo findHistoryByObjectCodeNew(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append("from EvsVoucherHistoryV hst where 1=1");
    localStringBuffer.append(" and hst.objectCode = '" + paramString + "'");
    localStringBuffer.append(" and opObjectType = " + paramInt1);
    localStringBuffer.append(" order by hst.handleDate desc");
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt2 / paramInt3 + 1, paramInt3, localArrayList.toArray());
    return localPageInfo;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.eBillManage.VoucherFlittingDAO
 * JD-Core Version:    0.7.0.1
 */