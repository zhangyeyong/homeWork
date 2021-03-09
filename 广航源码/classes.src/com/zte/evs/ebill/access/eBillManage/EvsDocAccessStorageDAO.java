package com.zte.evs.ebill.access.eBillManage;

import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.eas.appframe.business.util.SqlManageUtils;
import com.zte.eas.resconfig.business.lookup.model.FbpLookupValuesV;
import com.zte.eimage.access.baseconfig.dao.IImageCommonDAO;
import com.zte.evs.ebill.common.EvsObjectUtils;
import com.zte.evs.ebill.model.eBillManage.EvsBookModel;
import com.zte.evs.ebill.model.eBillManage.EvsBookV;
import com.zte.evs.ebill.model.eBillManage.EvsCity;
import com.zte.evs.ebill.model.eBillManage.EvsInventory;
import com.zte.evs.ebill.model.eBillManage.EvsLibraryInfo;
import com.zte.evs.ebill.model.eBillManage.EvsStorageDoc;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherHistory;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.util.Util;
import com.zte.ssb.orm.zorm.ZormTemplate;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import com.zte.ssb.zorm.Query;
import com.zte.ssb.zorm.SQLQuery;
import com.zte.ssb.zorm.Session;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.cxf.common.util.StringUtils;

public class EvsDocAccessStorageDAO
  extends BaseDAO
  implements IEvsDocAccessStorageDAO
{
  public List<EvsBookV> findAllBookIsExistByBookCode(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    List localList = null;
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    localStringBuffer.append("FROM EvsBookV bo WHERE 1=1 and  bo.bookStatus = 'BOOKED'");
    if (!"".equals(paramString))
    {
      if (!Util.isStrEmpty(localEasUserInfo.getUserInfoPk().toString())) {
        localStringBuffer.append(" and exists( FROM FbpPseRelationsV f where f.companyId=bo.companyId and f.employeeId = " + localEasUserInfo.getUserInfoPk().toString() + ")");
      } else {
        localStringBuffer.append(" and exists( FROM FbpPseRelationsV f where f.companyId=bo.companyId and f.employeeId = '000' )");
      }
      localStringBuffer.append(" AND bo.bookCode in ('" + paramString + "')");
      Query localQuery = getSession().createQuery(localStringBuffer.toString());
      localList = localQuery.list();
    }
    return localList;
  }
  
  public Map findDelAllBook(EvsBookModel paramEvsBookModel, int paramInt1, int paramInt2)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append(" select * from ( ");
    localStringBuffer.append(" select *　from EVS_BOOK_V bo where bo.book_status = 'BOOKED' and ");
    if ("false".equals(paramEvsBookModel.getIsQuery())) {
      localStringBuffer.append(" 1 = 2 ");
    } else {
      localStringBuffer.append(" 1 = 1 ");
    }
    if ((!Util.isStrEmpty(paramEvsBookModel.getBeginBookCode())) && (!Util.isStrEmpty(paramEvsBookModel.getEndBookCode())))
    {
      localStringBuffer.append(" and bo.book_Code >= '" + paramEvsBookModel.getBeginBookCode() + "' AND bo.book_Code <= '" + paramEvsBookModel.getEndBookCode() + "'");
    }
    else
    {
      if (!Util.isStrEmpty(paramEvsBookModel.getBeginBookCode())) {
        localStringBuffer.append(" and bo.book_Code >= '" + paramEvsBookModel.getBeginBookCode() + "'");
      }
      if (!Util.isStrEmpty(paramEvsBookModel.getEndBookCode())) {
        localStringBuffer.append(" and bo.book_Code >= '" + paramEvsBookModel.getEndBookCode() + "'");
      }
    }
    if (!Util.isStrEmpty(paramEvsBookModel.getBookPeopleId())) {
      localStringBuffer.append(" AND bo.book_employee_id = '" + paramEvsBookModel.getBookPeopleId().toString() + "'");
    }
    if (!Util.isStrEmpty(paramEvsBookModel.getCompanyCode())) {
      localStringBuffer.append(" and bo.company_code ='" + paramEvsBookModel.getCompanyCode() + "'");
    }
    if (!Util.isStrEmpty(paramEvsBookModel.getPeriodName())) {
      localStringBuffer.append(" and bo.period_Name = '" + paramEvsBookModel.getPeriodName() + "'");
    }
    int i;
    if (!Util.isStrEmpty(paramEvsBookModel.getRemoveBookCode()))
    {
      localObject1 = paramEvsBookModel.getRemoveBookCode().split(",");
      localObject2 = new StringBuffer();
      for (i = 0; i < localObject1.length; i++) {
        if (i >= localObject1.length - 1) {
          ((StringBuffer)localObject2).append("'" + localObject1[i] + "'");
        } else {
          ((StringBuffer)localObject2).append("'" + localObject1[i] + "'" + " , ");
        }
      }
      localStringBuffer.append(" AND bo.BOOK_CODE NOT IN (" + localObject2 + ")");
    }
    if (!Util.isStrEmpty(localEasUserInfo.getUserInfoPk().toString())) {
      localStringBuffer.append(" and exists(select * from Fbp_Pse_Relations_V f where f.company_Id=bo.company_Id and f.employee_Id = " + localEasUserInfo.getUserInfoPk().toString() + ")");
    } else {
      localStringBuffer.append(" and exists(SELECT * from Fbp_Pse_Relations_V f where f.company_Id=bo.company_Id and f.employee_Id = '000' )");
    }
    if (!Util.isStrEmpty(paramEvsBookModel.getSetBookName())) {
      localStringBuffer.append(" and bo.set_Book_Name = '" + paramEvsBookModel.getSetBookName() + "'");
    }
    if (!Util.isStrEmpty(paramEvsBookModel.getBookDateStart())) {
      localStringBuffer.append(" AND to_char(bo.book_Date, 'yyyy-mm-dd') >= '" + paramEvsBookModel.getBookDateStart().toString() + "'");
    }
    if (!Util.isStrEmpty(paramEvsBookModel.getBookDateEnd())) {
      localStringBuffer.append(" AND to_char(bo.book_Date, 'yyyy-mm-dd') <= '" + paramEvsBookModel.getBookDateEnd().toString() + "'");
    }
    if (!Util.isStrEmpty(paramEvsBookModel.getBookCodes()))
    {
      localObject1 = paramEvsBookModel.getBookCodes().split(",");
      localObject2 = new StringBuffer();
      for (i = 0; i < localObject1.length; i++) {
        if (i >= localObject1.length - 1) {
          ((StringBuffer)localObject2).append("'" + localObject1[i] + "'");
        } else {
          ((StringBuffer)localObject2).append("'" + localObject1[i] + "'" + " , ");
        }
      }
      localStringBuffer.append(" UNION SELECT * FROM ( ");
      localStringBuffer.append(" SELECT *  FROM EVS_BOOK_V s WHERE s.BOOK_CODE IN ( " + localObject2 + " ) and s.BOOK_STATUS = 'BOOKED'");
      localStringBuffer.append(" ) ");
    }
    localStringBuffer.append(" ) ");
    Object localObject1 = (IImageCommonDAO)SSBBus.findDomainService("imageCommonDAO");
    Object localObject2 = ((IImageCommonDAO)localObject1).pageInfoObjectBySql(localStringBuffer.toString(), localArrayList, EvsBookV.class, paramInt1 / paramInt2 + 1, paramInt2);
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", ((PageInfo)localObject2).getResult());
    localHashMap.put("totalCount", Long.valueOf(((PageInfo)localObject2).getTotalCount()));
    return localHashMap;
  }
  
  public List findAllBookInfo(EvsBookModel paramEvsBookModel)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    StringBuffer localStringBuffer1 = new StringBuffer();
    localStringBuffer1.append(" select *　from EVS_BOOK_V bo where bo.book_status = 'BOOKED'");
    if ("false".equals(paramEvsBookModel.getIsQuery())) {
      localStringBuffer1.append(" and 1 = 2 ");
    } else {
      localStringBuffer1.append(" and 1 = 1 ");
    }
    if ((!Util.isStrEmpty(paramEvsBookModel.getBeginBookCode())) && (!Util.isStrEmpty(paramEvsBookModel.getEndBookCode())))
    {
      localStringBuffer1.append(" and bo.book_Code >= '" + paramEvsBookModel.getBeginBookCode() + "' AND bo.book_Code <= '" + paramEvsBookModel.getEndBookCode() + "'");
    }
    else
    {
      if (!Util.isStrEmpty(paramEvsBookModel.getBeginBookCode())) {
        localStringBuffer1.append(" and bo.book_Code >= '" + paramEvsBookModel.getBeginBookCode() + "'");
      }
      if (!Util.isStrEmpty(paramEvsBookModel.getEndBookCode())) {
        localStringBuffer1.append(" and bo.book_Code >= '" + paramEvsBookModel.getEndBookCode() + "'");
      }
    }
    if (!Util.isStrEmpty(paramEvsBookModel.getBookPeopleId())) {
      localStringBuffer1.append(" AND bo.book_employee_id = '" + paramEvsBookModel.getBookPeopleId().toString() + "'");
    }
    if (!Util.isStrEmpty(paramEvsBookModel.getCompanyCode())) {
      localStringBuffer1.append(" and bo.company_code ='" + paramEvsBookModel.getCompanyCode() + "'");
    }
    if (!Util.isStrEmpty(paramEvsBookModel.getPeriodName())) {
      localStringBuffer1.append(" and bo.period_Name = '" + paramEvsBookModel.getPeriodName() + "'");
    }
    StringBuffer localStringBuffer2;
    int i;
    if (!Util.isStrEmpty(paramEvsBookModel.getRemoveBookCode()))
    {
      localObject = paramEvsBookModel.getRemoveBookCode().split(",");
      localStringBuffer2 = new StringBuffer();
      for (i = 0; i < localObject.length; i++) {
        if (i >= localObject.length - 1) {
          localStringBuffer2.append("'" + localObject[i] + "'");
        } else {
          localStringBuffer2.append("'" + localObject[i] + "'" + " , ");
        }
      }
      localStringBuffer1.append(" AND bo.BOOK_CODE NOT IN (" + localStringBuffer2 + ")");
    }
    if (!Util.isStrEmpty(localEasUserInfo.getUserInfoPk().toString())) {
      localStringBuffer1.append(" and exists(select * from Fbp_Pse_Relations_V f where f.company_Id=bo.company_Id and f.employee_Id = " + localEasUserInfo.getUserInfoPk().toString() + ")");
    } else {
      localStringBuffer1.append(" and exists(SELECT * from Fbp_Pse_Relations_V f where f.company_Id=bo.company_Id and f.employee_Id = '000' )");
    }
    if (!Util.isStrEmpty(paramEvsBookModel.getSetBookName())) {
      localStringBuffer1.append(" and bo.set_Book_Name = '" + paramEvsBookModel.getSetBookName() + "'");
    }
    if (!Util.isStrEmpty(paramEvsBookModel.getBookDateStart())) {
      localStringBuffer1.append(" AND to_char(bo.book_Date, 'yyyy-mm-dd') >= '" + paramEvsBookModel.getBookDateStart().toString() + "'");
    }
    if (!Util.isStrEmpty(paramEvsBookModel.getBookDateEnd())) {
      localStringBuffer1.append(" AND to_char(bo.book_Date, 'yyyy-mm-dd') <= '" + paramEvsBookModel.getBookDateEnd().toString() + "'");
    }
    if (!Util.isStrEmpty(paramEvsBookModel.getBookCodes()))
    {
      localObject = paramEvsBookModel.getBookCodes().split(",");
      localStringBuffer2 = new StringBuffer();
      for (i = 0; i < localObject.length; i++) {
        if (i >= localObject.length - 1) {
          localStringBuffer2.append("'" + localObject[i] + "'");
        } else {
          localStringBuffer2.append("'" + localObject[i] + "'" + " , ");
        }
      }
      localStringBuffer1.append(" UNION SELECT * FROM ( ");
      localStringBuffer1.append(" SELECT *  FROM EVS_BOOK_V s WHERE s.BOOK_CODE IN ( " + localStringBuffer2 + " ) and s.book_status = 'BOOKED'");
      localStringBuffer1.append(" ) ");
    }
    Object localObject = (IImageCommonDAO)SSBBus.findDomainService("imageCommonDAO");
    return ((IImageCommonDAO)localObject).findObjectBySQL(localStringBuffer1.toString(), null, EvsBookV.class);
  }
  
  public String insertInventory(EvsInventory paramEvsInventory)
  {
    super.insertObject(paramEvsInventory);
    return paramEvsInventory.getInvBatchNum();
  }
  
  public void removeBookIdByBatchNum(String paramString)
  {
    String str = "DELETE FROM EVS_INVENTORY EI WHERE EI.INV_BATCH_NUM IN ( ? )";
    super.getSession().createSQLQuery(str).setString(0, paramString).executeUpdate();
  }
  
  public List<EvsInventory> findInventoryByBatchNum(String paramString)
  {
    String str = "FROM EvsInventory ei where ei.invBatchNum=" + paramString + " and ei.enabledFlag='T'";
    return getSession().createQuery(str).list();
  }
  
  public void updateInventory(EvsInventory paramEvsInventory)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(" UPDATE EvsInventory EI SET ");
    localStringBuffer.append(" EI.invCityId=" + paramEvsInventory.getInvCityId() + ",");
    localStringBuffer.append(" EI.invStorageCode='" + paramEvsInventory.getInvStorageCode() + "' , ");
    localStringBuffer.append(" EI.enabledFlag='" + paramEvsInventory.getEnabledFlag() + "'");
    if (!Util.isStrEmpty(paramEvsInventory.getInvArea())) {
      localStringBuffer.append(", EI.invArea='" + paramEvsInventory.getInvArea() + "'");
    } else {
      localStringBuffer.append(", EI.invArea=' '");
    }
    if (!Util.isStrEmpty(paramEvsInventory.getInvRow())) {
      localStringBuffer.append(", EI.invRow='" + paramEvsInventory.getInvRow() + "'");
    } else {
      localStringBuffer.append(", EI.invRow=' '");
    }
    if (!Util.isStrEmpty(paramEvsInventory.getInvColumn())) {
      localStringBuffer.append(", EI.invColumn='" + paramEvsInventory.getInvColumn() + "'");
    } else {
      localStringBuffer.append(", EI.invColumn=' '");
    }
    if (!Util.isStrEmpty(paramEvsInventory.getInvLevel())) {
      localStringBuffer.append(", EI.invLevel='" + paramEvsInventory.getInvLevel() + "'");
    } else {
      localStringBuffer.append(", EI.invLevel=' '");
    }
    localStringBuffer.append(" WHERE EI.inventoryId=" + paramEvsInventory.getInventoryId());
    createQuery(localStringBuffer.toString(), new Object[0]).executeUpdate();
  }
  
  public boolean findLibraryIsExist(EvsInventory paramEvsInventory)
  {
    Integer localInteger1 = Integer.valueOf(0);
    Integer localInteger2 = Integer.valueOf(0);
    StringBuffer localStringBuffer1 = new StringBuffer();
    Object localObject1 = new ArrayList();
    String str1 = "FROM EvsLibraryInfo ei where ei.storageId=" + paramEvsInventory.getInvStorageId() + " and ei.libraryCode in ('" + paramEvsInventory.getInvArea() + "' , '" + paramEvsInventory.getInvRow() + "' , '" + paramEvsInventory.getInvColumn() + "' , '" + paramEvsInventory.getInvLevel() + "') and ei.enabledFlag='Y' and ei.validity = 'Y'";
    localObject1 = getSession().createQuery(str1).list();
    localInteger1 = Integer.valueOf(((List)localObject1).size());
    StringBuffer localStringBuffer2 = new StringBuffer();
    Object localObject2;
    Object localObject3;
    if (!Util.isStrEmpty(paramEvsInventory.getInvArea()))
    {
      localStringBuffer2.append(paramEvsInventory.getInvArea() + "-");
      localObject2 = localInteger2;
      localObject3 = localInteger2 = Integer.valueOf(localInteger2.intValue() + 1);
    }
    if (!Util.isStrEmpty(paramEvsInventory.getInvRow()))
    {
      localStringBuffer2.append(paramEvsInventory.getInvRow() + "-");
      localObject2 = localInteger2;
      localObject3 = localInteger2 = Integer.valueOf(localInteger2.intValue() + 1);
    }
    if (!Util.isStrEmpty(paramEvsInventory.getInvColumn()))
    {
      localStringBuffer2.append(paramEvsInventory.getInvColumn() + "-");
      localObject2 = localInteger2;
      localObject3 = localInteger2 = Integer.valueOf(localInteger2.intValue() + 1);
    }
    if (!Util.isStrEmpty(paramEvsInventory.getInvLevel()))
    {
      localStringBuffer2.append(paramEvsInventory.getInvLevel() + "-");
      localObject2 = localInteger2;
      localObject3 = localInteger2 = Integer.valueOf(localInteger2.intValue() + 1);
    }
    if (localInteger1 == localInteger2)
    {
      localObject2 = new StringBuffer();
      localObject3 = "";
      String str2 = "";
      String str3 = "";
      String str4 = "";
      for (int i = 0; i < ((List)localObject1).size(); i++)
      {
        EvsLibraryInfo localEvsLibraryInfo = (EvsLibraryInfo)((List)localObject1).get(i);
        if (!Util.isStrEmpty(localEvsLibraryInfo.getLibraryCode()))
        {
          if ("AREA".equals(localEvsLibraryInfo.getLibraryAtt())) {
            localObject3 = localEvsLibraryInfo.getLibraryCode();
          }
          if ("ROW".equals(localEvsLibraryInfo.getLibraryAtt())) {
            str3 = localEvsLibraryInfo.getLibraryCode();
          }
          if ("COLUMN".equals(localEvsLibraryInfo.getLibraryAtt())) {
            str2 = localEvsLibraryInfo.getLibraryCode();
          }
          if ("LEVEL".equals(localEvsLibraryInfo.getLibraryAtt())) {
            str4 = localEvsLibraryInfo.getLibraryCode();
          }
        }
      }
      if (!"".equals(localObject3)) {
        ((StringBuffer)localObject2).append((String)localObject3 + "-");
      }
      if (!"".equals(str3)) {
        ((StringBuffer)localObject2).append(str3 + "-");
      }
      if (!"".equals(str2)) {
        ((StringBuffer)localObject2).append(str2 + "-");
      }
      if (!"".equals(str4)) {
        ((StringBuffer)localObject2).append(str4 + "-");
      }
      return localStringBuffer2.toString().equals(((StringBuffer)localObject2).toString());
    }
    return false;
  }
  
  public Integer findBookNum(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(" SELECT COUNT(1) FROM EVS_INVENTORY LI WHERE 1=1");
    if (!Util.isStrEmpty(paramString1)) {
      localStringBuffer.append(" and LI.INV_AREA = '" + paramString1 + "'");
    } else {
      localStringBuffer.append(" and LI.INV_AREA = ' '");
    }
    if (!Util.isStrEmpty(paramString2)) {
      localStringBuffer.append(" and LI.INV_ROW = '" + paramString2 + "'");
    } else {
      localStringBuffer.append(" and LI.INV_ROW = ' '");
    }
    if (!Util.isStrEmpty(paramString3)) {
      localStringBuffer.append(" and LI.INV_COLUMN = '" + paramString3 + "'");
    } else {
      localStringBuffer.append(" and LI.INV_COLUMN = ' '");
    }
    if (!Util.isStrEmpty(paramString4)) {
      localStringBuffer.append(" and LI.INV_LEVEL = '" + paramString4 + "'");
    } else {
      localStringBuffer.append(" and LI.INV_LEVEL = ' '");
    }
    return Integer.valueOf(Integer.parseInt(super.getSession().createSQLQuery(localStringBuffer.toString()).uniqueResult().toString()));
  }
  
  public void updateBookStateByBookId(Long paramLong)
  {
    String str = " UPDATE EvsBook EI SET EI.bookStatus='WAREHOUSE'  WHERE EI.bookId=" + paramLong;
    createQuery(str.toString(), new Object[0]).executeUpdate();
  }
  
  public void updateVoucherStateByBookId(EvsBookV paramEvsBookV)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if ("Y".equals(paramEvsBookV.getBookBreakFlag()))
    {
      localStringBuffer.append(" update EvsVoucher ev set ev.voucherStatus = 'WAREHOUSE' where ev.voucherId in( ");
      localStringBuffer.append(" select evb.voucherId from EvsVoucherBookPackage evb where evb.bookId = " + paramEvsBookV.getBookId());
      localStringBuffer.append(" )");
    }
    else if ("N".equals(paramEvsBookV.getBookBreakFlag()))
    {
      localStringBuffer.append(" update EvsVoucher ev set ev.voucherStatus = 'WAREHOUSE' where 1 = 1 and ");
      localStringBuffer.append(" exists (select evb.beginNum, evb.endNum from EvsVoucherBookPackage evb where evb.bookId = " + paramEvsBookV.getBookId());
      localStringBuffer.append(" and ev.journalNum>=evb.beginNum and ev.journalNum<=evb.endNum)");
    }
    else if ("S".equals(paramEvsBookV.getBookBreakFlag()))
    {
      localStringBuffer.append(" update EvsVoucher ev set ev.voucherStatus = 'WAREHOUSE' where ev.voucherId in( ");
      localStringBuffer.append(" select evb.voucherId from EvsVoucherBookPackage evb where evb.bookId = " + paramEvsBookV.getBookId());
      localStringBuffer.append(" )");
    }
    createQuery(localStringBuffer.toString(), new Object[0]).executeUpdate();
  }
  
  public Map findAllBook(EvsBookModel paramEvsBookModel, int paramInt1, int paramInt2)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append(" select *　from EVS_BOOK_V bo where 1 = 1 and bo.book_status in('WAREHOUSE','NOW_FLITTING')");
    if ((!Util.isNullObject(paramEvsBookModel.getBookId())) && (!Util.isStrEmpty(paramEvsBookModel.getBookCode())))
    {
      localStringBuffer.append(" AND bo.book_id = " + paramEvsBookModel.getBookId() + "");
      localStringBuffer.append(" AND bo.book_Code = '" + paramEvsBookModel.getBookCode() + "'");
    }
    else if ((!Util.isStrEmpty(paramEvsBookModel.getBeginBookCode())) && (!Util.isStrEmpty(paramEvsBookModel.getEndBookCode())))
    {
      localStringBuffer.append(" and bo.book_Code >= '" + paramEvsBookModel.getBeginBookCode() + "' AND bo.book_Code <= '" + paramEvsBookModel.getEndBookCode() + "'");
    }
    else
    {
      if (!Util.isStrEmpty(paramEvsBookModel.getBeginBookCode())) {
        localStringBuffer.append(" and bo.book_Code >= '" + paramEvsBookModel.getBeginBookCode() + "'");
      }
      if (!Util.isStrEmpty(paramEvsBookModel.getEndBookCode())) {
        localStringBuffer.append(" and bo.book_Code >= '" + paramEvsBookModel.getEndBookCode() + "'");
      }
    }
    if (!Util.isStrEmpty(paramEvsBookModel.getBookPeopleId())) {
      localStringBuffer.append(" AND bo.book_employee_id = '" + paramEvsBookModel.getBookPeopleId().toString() + "'");
    }
    if (!Util.isStrEmpty(paramEvsBookModel.getCompanyCode())) {
      localStringBuffer.append(" and bo.company_code ='" + paramEvsBookModel.getCompanyCode() + "'");
    }
    if (!Util.isStrEmpty(paramEvsBookModel.getPeriodName())) {
      localStringBuffer.append(" and bo.period_Name = '" + paramEvsBookModel.getPeriodName() + "'");
    }
    if (!Util.isStrEmpty(localEasUserInfo.getUserInfoPk().toString())) {
      localStringBuffer.append(" and exists(select * from Fbp_Pse_Relations_V f where f.company_Id=bo.company_Id and f.employee_Id = " + localEasUserInfo.getUserInfoPk().toString() + ")");
    } else {
      localStringBuffer.append(" and exists(SELECT * from Fbp_Pse_Relations_V f where f.company_Id=bo.company_Id and f.employee_Id = '000' )");
    }
    if (!Util.isStrEmpty(paramEvsBookModel.getSetBookName())) {
      localStringBuffer.append(" and bo.set_Book_Name = '" + paramEvsBookModel.getSetBookName() + "'");
    }
    if (!Util.isStrEmpty(paramEvsBookModel.getBookDateStart())) {
      localStringBuffer.append(" AND to_char(bo.book_Date, 'yyyy-mm-dd') >= '" + paramEvsBookModel.getBookDateStart().toString() + "'");
    }
    if (!Util.isStrEmpty(paramEvsBookModel.getBookDateEnd())) {
      localStringBuffer.append(" AND to_char(bo.book_Date, 'yyyy-mm-dd') <= '" + paramEvsBookModel.getBookDateEnd().toString() + "'");
    }
    localStringBuffer.append(" ORDER by bo.INV_BATCH_NUM DESC");
    IImageCommonDAO localIImageCommonDAO = (IImageCommonDAO)SSBBus.findDomainService("imageCommonDAO");
    PageInfo localPageInfo = localIImageCommonDAO.pageInfoObjectBySql(localStringBuffer.toString(), localArrayList, EvsBookV.class, paramInt1 / paramInt2 + 1, paramInt2);
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", localPageInfo.getResult());
    localHashMap.put("totalCount", Long.valueOf(localPageInfo.getTotalCount()));
    return localHashMap;
  }
  
  public FbpLookupValuesV findFbpLookupValues(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    String str = "from FbpLookupValuesV s where enabledFlag='Y'";
    if ((paramString != null) && (!paramString.equals("")))
    {
      str = str + " and s.lookupCode = ?";
      localArrayList.add(SqlManageUtils.cleanUpSQL(paramString));
    }
    List localList = getZormTemplate().find(str.toString(), localArrayList.toArray());
    return (FbpLookupValuesV)localList.get(0);
  }
  
  public EvsCity findCityNameByCityId(Long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    String str = "from EvsCity s where enabledFlag='Y'";
    if (paramLong != null)
    {
      str = str + " and s.cityId = ?";
      localArrayList.add(paramLong);
    }
    List localList = getZormTemplate().find(str.toString(), localArrayList.toArray());
    return (EvsCity)localList.get(0);
  }
  
  public EvsStorageDoc findStorageDocNameByStoCode(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    String str = "from EvsStorageDoc s where enabledFlag='Y'";
    if ((paramString != null) && (!paramString.equals("")))
    {
      str = str + " and s.storageCode = ?";
      localArrayList.add(SqlManageUtils.cleanUpSQL(paramString));
    }
    List localList = getZormTemplate().find(str.toString(), localArrayList.toArray());
    return (EvsStorageDoc)localList.get(0);
  }
  
  public EvsInventory findEvsInventoryByBookId(Long paramLong)
  {
    String str = "FROM EvsInventory ei where ei.bookId=" + paramLong + " and ei.enabledFlag='Y'";
    List localList = getSession().createQuery(str).list();
    if ((localList != null) && (localList.size() > 0)) {
      return (EvsInventory)localList.get(0);
    }
    return null;
  }
  
  public EvsInventory findEvsInventoryByVentoryID(Long paramLong)
  {
    String str = "FROM EvsInventory ei where ei.invStorageCode in(select storageCode from EvsStorageDoc ed where ed.storageId=" + paramLong + ") and ei.enabledFlag='Y'";
    List localList = getSession().createQuery(str).list();
    if ((localList != null) && (localList.size() > 0)) {
      return (EvsInventory)localList.get(0);
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
    } else {
      localStringBuffer.append(", EI.invArea=' '");
    }
    if (!Util.isStrEmpty(paramEvsInventory.getInvRow())) {
      localStringBuffer.append(", EI.invRow='" + paramEvsInventory.getInvRow() + "'");
    } else {
      localStringBuffer.append(", EI.invRow=' '");
    }
    if (!Util.isStrEmpty(paramEvsInventory.getInvColumn())) {
      localStringBuffer.append(", EI.invColumn='" + paramEvsInventory.getInvColumn() + "'");
    } else {
      localStringBuffer.append(", EI.invColumn=' '");
    }
    if (!Util.isStrEmpty(paramEvsInventory.getInvLevel())) {
      localStringBuffer.append(", EI.invLevel='" + paramEvsInventory.getInvLevel() + "'");
    } else {
      localStringBuffer.append(", EI.invLevel=' '");
    }
    localStringBuffer.append(" WHERE EI.bookId=" + paramEvsInventory.getBookId());
    localStringBuffer.append(" AND EI.enabledFlag='" + paramEvsInventory.getEnabledFlag() + "'");
    createQuery(localStringBuffer.toString(), new Object[0]).executeUpdate();
  }
  
  public EvsCity findCityNameByCityCode(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    String str = "from EvsCity s where 1=1";
    if (!StringUtils.isEmpty(paramString))
    {
      str = str + " and s.cityCode = ?";
      localArrayList.add(paramString);
    }
    Query localQuery = super.getSession().createQuery(str);
    for (int i = 0; i < localArrayList.size(); i++) {
      localQuery.setParameter(i, localArrayList.get(i));
    }
    List localList = localQuery.list();
    if ((localList == null) || (localList.size() == 0)) {
      return null;
    }
    return (EvsCity)localList.get(0);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertEvsCity(EvsCity paramEvsCity)
  {
    super.insertObject(paramEvsCity);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateEvsCity(EvsCity paramEvsCity)
  {
    super.updateObject(paramEvsCity);
  }
  
  public void insertEvsVoucherHistory(EvsVoucherHistory paramEvsVoucherHistory)
  {
    super.insertObject(paramEvsVoucherHistory);
  }
  
  public EvsBookV findEvsBookModelByBookId(Long paramLong)
  {
    String str = " from EvsBookV bo WHERE 1=1 and bo.bookId=" + paramLong;
    Query localQuery = getSession().createQuery(str.toString());
    return (EvsBookV)localQuery.list().get(0);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.eBillManage.EvsDocAccessStorageDAO
 * JD-Core Version:    0.7.0.1
 */