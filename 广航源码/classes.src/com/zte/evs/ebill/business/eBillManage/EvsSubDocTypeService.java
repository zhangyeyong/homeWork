package com.zte.evs.ebill.business.eBillManage;

import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.evs.ebill.access.eBillManage.IEvsDocTypeDAO;
import com.zte.evs.ebill.access.eBillManage.IEvsDocTypeMapDAO;
import com.zte.evs.ebill.access.eBillManage.IEvsSubDocTypeDAO;
import com.zte.evs.ebill.common.EvsObjectUtils;
import com.zte.evs.ebill.model.eBillManage.EvsDocType;
import com.zte.evs.ebill.model.eBillManage.EvsDocTypeMap;
import com.zte.evs.ebill.model.eBillManage.EvsSubDocType;
import com.zte.evs.ebill.model.eBillManage.EvsSubDocTypeV;
import com.zte.evs.ebill.model.eBillManage.EvsSubDocTypeVo;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.ssbext.resource.ComResUtil;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class EvsSubDocTypeService
  implements IEvsSubDocTypeService
{
  private IEvsSubDocTypeDAO evsSubDocTypeDAO;
  private IEvsDocTypeMapDAO evsDocTypeMapDAO;
  private IEvsDocTypeDAO evsDocTypeDAO;
  
  public Map getSubDocTypeForSelect()
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    List localList = this.evsSubDocTypeDAO.findSubDocTypeForSelect();
    localArrayList1.add(ComResUtil.getMessage("fbp.lookup.select"));
    localArrayList2.add("");
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        EvsSubDocType localEvsSubDocType = (EvsSubDocType)localIterator.next();
        if (localEvsSubDocType != null)
        {
          localArrayList1.add(localEvsSubDocType.getSubDocName() == null ? "" : localEvsSubDocType.getSubDocName().trim());
          localArrayList2.add(localEvsSubDocType.getSubDocCode());
        }
      }
    }
    localHashMap.put("selectText", localArrayList1);
    localHashMap.put("selectValue", localArrayList2);
    return localHashMap;
  }
  
  public Map getSubDocTypeForSelectByName()
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    List localList = this.evsSubDocTypeDAO.findSubDocTypeForSelect();
    localArrayList1.add(ComResUtil.getMessage("fbp.lookup.select"));
    localArrayList2.add("");
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        EvsSubDocType localEvsSubDocType = (EvsSubDocType)localIterator.next();
        if (localEvsSubDocType != null)
        {
          localArrayList1.add(localEvsSubDocType.getSubDocName() == null ? "" : localEvsSubDocType.getSubDocName().trim());
          localArrayList2.add(localEvsSubDocType.getSubDocName());
        }
      }
    }
    localHashMap.put("selectText", localArrayList1);
    localHashMap.put("selectValue", localArrayList2);
    return localHashMap;
  }
  
  public String saveSubDocType(EvsSubDocTypeVo paramEvsSubDocTypeVo)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    String str = "0";
    EvsSubDocType localEvsSubDocType = new EvsSubDocType();
    localEvsSubDocType.setSubDocCode(paramEvsSubDocTypeVo.getSubDocCode());
    localEvsSubDocType.setSubDocName(paramEvsSubDocTypeVo.getSubDocName());
    localEvsSubDocType.setDeadline(paramEvsSubDocTypeVo.getDeadline());
    localEvsSubDocType.setSubDocMemo(paramEvsSubDocTypeVo.getSubDocMemo());
    localEvsSubDocType.setDocId(Long.valueOf(Long.parseLong(paramEvsSubDocTypeVo.getDocId())));
    localEvsSubDocType.setVoucherType(paramEvsSubDocTypeVo.getVoucherType());
    localEvsSubDocType.setEnabledFlag(paramEvsSubDocTypeVo.getEnabledFlag());
    if ((paramEvsSubDocTypeVo.getSequenceNumber() != null) && (paramEvsSubDocTypeVo.getSequenceNumber() != "") && (!"".equals(paramEvsSubDocTypeVo.getSequenceNumber()))) {
      localEvsSubDocType.setSequenceNumber(Long.valueOf(Long.parseLong(paramEvsSubDocTypeVo.getSequenceNumber())));
    }
    localEvsSubDocType.setCreationDate(new Date());
    localEvsSubDocType.setLastUpdateDate(new Date());
    if (localEasUserInfo != null)
    {
      localEvsSubDocType.setCreatedBy(Long.valueOf(localEasUserInfo.getUserInfoPk().longValue()));
      localEvsSubDocType.setLastUpdateBy(Long.valueOf(Long.parseLong(localEasUserInfo.getUserInfoPk().toString())));
      localEvsSubDocType.setLastUpdateLogin(Long.valueOf(Long.parseLong(localEasUserInfo.getUserInfoPk().toString())));
    }
    else
    {
      localEvsSubDocType.setCreatedBy(Long.valueOf(Long.parseLong("22547")));
      localEvsSubDocType.setLastUpdateBy(Long.valueOf(Long.parseLong("22547")));
      localEvsSubDocType.setLastUpdateLogin(Long.valueOf(Long.parseLong("22547")));
    }
    str = this.evsSubDocTypeDAO.save(localEvsSubDocType);
    if (!"0".equalsIgnoreCase(str)) {
      return "1";
    }
    String[] arrayOfString = paramEvsSubDocTypeVo.getVoucherTypeCode().split(",");
    if ((!"".equals(arrayOfString[0])) && (arrayOfString.length > 0))
    {
      System.out.println(":::" + arrayOfString.length);
      for (int i = 0; i < arrayOfString.length; i++)
      {
        EvsDocTypeMap localEvsDocTypeMap = new EvsDocTypeMap();
        localEvsDocTypeMap.setSubDocId(localEvsSubDocType.getSubDocId());
        localEvsDocTypeMap.setCreatedBy(Long.valueOf(Long.parseLong("0001")));
        localEvsDocTypeMap.setTypeCode(arrayOfString[i]);
        localEvsDocTypeMap.setCreationDate(new Date());
        this.evsDocTypeMapDAO.save(localEvsDocTypeMap);
      }
    }
    return "0";
  }
  
  public String updateSubDocType(EvsSubDocTypeVo paramEvsSubDocTypeVo)
  {
    int i = 0;
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    EvsSubDocType localEvsSubDocType1 = this.evsSubDocTypeDAO.findById(Long.valueOf(Long.parseLong(paramEvsSubDocTypeVo.getSubDocId())));
    if (!localEvsSubDocType1.getSubDocName().equals(paramEvsSubDocTypeVo.getSubDocName().trim()))
    {
      i = this.evsSubDocTypeDAO.getCountName(paramEvsSubDocTypeVo.getSubDocName().trim());
      if (i != 0) {
        return "1";
      }
    }
    EvsSubDocType localEvsSubDocType2 = new EvsSubDocType();
    localEvsSubDocType2.setSubDocId(Long.valueOf(Long.parseLong(paramEvsSubDocTypeVo.getSubDocId())));
    localEvsSubDocType2.setSubDocCode(paramEvsSubDocTypeVo.getSubDocCode());
    localEvsSubDocType2.setSubDocName(paramEvsSubDocTypeVo.getSubDocName());
    localEvsSubDocType2.setDeadline(paramEvsSubDocTypeVo.getDeadline());
    localEvsSubDocType2.setSubDocMemo(paramEvsSubDocTypeVo.getSubDocMemo());
    localEvsSubDocType2.setVoucherType(paramEvsSubDocTypeVo.getVoucherType());
    localEvsSubDocType2.setDocId(Long.valueOf(Long.parseLong(paramEvsSubDocTypeVo.getDocId())));
    localEvsSubDocType2.setEnabledFlag(paramEvsSubDocTypeVo.getEnabledFlag());
    if ((paramEvsSubDocTypeVo.getSequenceNumber() != null) && (paramEvsSubDocTypeVo.getSequenceNumber() != "") && (!"".equals(paramEvsSubDocTypeVo.getSequenceNumber()))) {
      localEvsSubDocType2.setSequenceNumber(Long.valueOf(Long.parseLong(paramEvsSubDocTypeVo.getSequenceNumber())));
    }
    localEvsSubDocType2.setLastUpdateDate(new Date());
    if (localEasUserInfo != null)
    {
      localEvsSubDocType2.setLastUpdateBy(Long.valueOf(Long.parseLong(localEasUserInfo.getUserInfoPk().toString())));
      localEvsSubDocType2.setLastUpdateLogin(Long.valueOf(Long.parseLong(localEasUserInfo.getUserInfoPk().toString())));
    }
    else
    {
      localEvsSubDocType2.setLastUpdateBy(Long.valueOf(Long.parseLong("22547")));
      localEvsSubDocType2.setLastUpdateLogin(Long.valueOf(Long.parseLong("22547")));
    }
    this.evsSubDocTypeDAO.update(localEvsSubDocType2);
    this.evsDocTypeMapDAO.remove(Long.valueOf(Long.parseLong(paramEvsSubDocTypeVo.getSubDocId())));
    String[] arrayOfString = paramEvsSubDocTypeVo.getVoucherTypeCode().split(",");
    if ((!"".equals(arrayOfString[0])) && (arrayOfString.length > 0)) {
      for (int j = 0; j < arrayOfString.length; j++)
      {
        EvsDocTypeMap localEvsDocTypeMap = new EvsDocTypeMap();
        localEvsDocTypeMap.setSubDocId(Long.valueOf(Long.parseLong(paramEvsSubDocTypeVo.getSubDocId())));
        localEvsDocTypeMap.setCreatedBy(Long.valueOf(Long.parseLong("0001")));
        localEvsDocTypeMap.setTypeCode(arrayOfString[j]);
        localEvsDocTypeMap.setCreationDate(new Date());
        this.evsDocTypeMapDAO.save(localEvsDocTypeMap);
      }
    }
    return "0";
  }
  
  public EvsSubDocType findById(Long paramLong)
  {
    EvsSubDocType localEvsSubDocType = this.evsSubDocTypeDAO.findById(paramLong);
    List localList = this.evsDocTypeMapDAO.findEvsDocTypeMapBySubDocId(paramLong);
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject = localList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      EvsDocTypeMap localEvsDocTypeMap = (EvsDocTypeMap)((Iterator)localObject).next();
      if ((localStringBuffer != null) && (localStringBuffer.length() > 0)) {
        localStringBuffer.append(",");
      }
      localStringBuffer.append(localEvsDocTypeMap.getTypeCode());
    }
    localEvsSubDocType.setVoucherTypeCode(localStringBuffer.toString());
    localObject = this.evsDocTypeDAO.findById(localEvsSubDocType.getDocId());
    if (localObject != null) {
      localEvsSubDocType.setDocName(((EvsDocType)localObject).getDocName());
    }
    return localEvsSubDocType;
  }
  
  public TableDataInfo getSubDocTypeQuery(EvsSubDocTypeVo paramEvsSubDocTypeVo, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    Map localMap = this.evsSubDocTypeDAO.findSubDocTypeByQry(paramEvsSubDocTypeVo, paramInt1, paramInt2);
    List localList = (List)localMap.get("data");
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      EvsSubDocTypeV localEvsSubDocTypeV = (EvsSubDocTypeV)localIterator.next();
      if (localEvsSubDocTypeV != null) {
        localEvsSubDocTypeV.setDeadline(this.evsDocTypeDAO.findDeadline(localEvsSubDocTypeV.getDeadline()));
      }
    }
    localTableDataInfo.setData(localList);
    localTableDataInfo.setTotalCount(Integer.parseInt(localMap.get("totalCount").toString()));
    return localTableDataInfo;
  }
  
  public IEvsDocTypeMapDAO getEvsDocTypeMapDAO()
  {
    return this.evsDocTypeMapDAO;
  }
  
  public void setEvsDocTypeMapDAO(IEvsDocTypeMapDAO paramIEvsDocTypeMapDAO)
  {
    this.evsDocTypeMapDAO = paramIEvsDocTypeMapDAO;
  }
  
  public IEvsSubDocTypeDAO getEvsSubDocTypeDAO()
  {
    return this.evsSubDocTypeDAO;
  }
  
  public void setEvsSubDocTypeDAO(IEvsSubDocTypeDAO paramIEvsSubDocTypeDAO)
  {
    this.evsSubDocTypeDAO = paramIEvsSubDocTypeDAO;
  }
  
  public IEvsDocTypeDAO getEvsDocTypeDAO()
  {
    return this.evsDocTypeDAO;
  }
  
  public void setEvsDocTypeDAO(IEvsDocTypeDAO paramIEvsDocTypeDAO)
  {
    this.evsDocTypeDAO = paramIEvsDocTypeDAO;
  }
  
  public String findSubDocTypeByNum(String paramString)
  {
    if (paramString != "") {
      return this.evsSubDocTypeDAO.findSubDocTypeByNum(paramString);
    }
    return null;
  }
  
  public String getMaxNumber()
  {
    return this.evsSubDocTypeDAO.getMaxNumber();
  }
  
  public EvsSubDocTypeV findSubDocTypeByNumber(String paramString)
  {
    if (paramString != "") {
      return this.evsSubDocTypeDAO.findSubDocTypeByNumber(paramString);
    }
    return null;
  }
  
  public void updateSequenceNumberBySubDocId(String paramString1, String paramString2)
  {
    if ((paramString1 != "") && (paramString2 != "")) {
      this.evsSubDocTypeDAO.updateSequenceNumberBySubDocId(paramString1, paramString2);
    }
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.eBillManage.EvsSubDocTypeService
 * JD-Core Version:    0.7.0.1
 */