package com.zte.evs.ebill.business.eBillManage;

import com.zte.eas.appframe.business.util.ObjectCopyUtils;
import com.zte.eas.resconfig.business.lookup.model.FbpLookupValuesV;
import com.zte.evs.ebill.access.eBillManage.IEvsDocAccessStorageDAO;
import com.zte.evs.ebill.model.eBillManage.EvsBookModel;
import com.zte.evs.ebill.model.eBillManage.EvsBookV;
import com.zte.evs.ebill.model.eBillManage.EvsCity;
import com.zte.evs.ebill.model.eBillManage.EvsInventory;
import com.zte.evs.ebill.model.eBillManage.EvsStorageDoc;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherHistory;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.util.Util;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

public class EvsDocAccessStorageService
  implements IEvsDocAccessStorageService
{
  private Logger logger = Logger.getLogger(getClass());
  private IEvsDocAccessStorageDAO docAccessStorageDAO;
  
  public String insertBatchEnterDepot(EvsBookModel paramEvsBookModel, String paramString)
  {
    List localList = this.docAccessStorageDAO.findAllBookInfo(paramEvsBookModel);
    String str1 = "Y";
    if ((localList == null) || (localList.size() < 1))
    {
      this.logger.error("没符合条件的数据!");
      str1 = "N";
      return str1;
    }
    long l = new Date().getTime();
    String str2 = "" + l;
    if (!Util.isStrEmpty(paramString)) {
      this.docAccessStorageDAO.removeBookIdByBatchNum(paramString);
    }
    for (int i = 0; i < localList.size(); i++)
    {
      EvsBookV localEvsBookV = (EvsBookV)localList.get(i);
      EvsInventory localEvsInventory = new EvsInventory();
      ObjectCopyUtils.setWho(localEvsInventory);
      localEvsInventory.setInvBatchNum(str2);
      localEvsInventory.setBookId(localEvsBookV.getBookId());
      localEvsInventory.setEnabledFlag("T");
      this.docAccessStorageDAO.insertInventory(localEvsInventory);
    }
    return str2;
  }
  
  public String findAllBookIsExistByBookCode(String paramString)
  {
    String str = "N";
    List localList = this.docAccessStorageDAO.findAllBookIsExistByBookCode(paramString);
    if ((null != localList) && (localList.size() > 0)) {
      str = "Y";
    }
    return str;
  }
  
  public TableDataInfo findDelAllBook(EvsBookModel paramEvsBookModel, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    Map localMap = this.docAccessStorageDAO.findDelAllBook(paramEvsBookModel, paramInt1, paramInt2);
    localTableDataInfo.setData((List)localMap.get("data"));
    localTableDataInfo.setTotalCount(Integer.parseInt(localMap.get("totalCount").toString()));
    return localTableDataInfo;
  }
  
  public void updateData(EvsInventory paramEvsInventory, List<EvsInventory> paramList)
  {
    for (int i = 0; i < paramList.size(); i++)
    {
      EvsInventory localEvsInventory1 = (EvsInventory)paramList.get(i);
      EvsInventory localEvsInventory2 = new EvsInventory();
      localEvsInventory2.setEnabledFlag("Y");
      ObjectCopyUtils.setWho(localEvsInventory2);
      localEvsInventory2.setInventoryId(localEvsInventory1.getInventoryId());
      localEvsInventory2.setInvCityId(paramEvsInventory.getInvCityId());
      localEvsInventory2.setInvStorageCode(paramEvsInventory.getInvStorageCode());
      localEvsInventory2.setInvArea(paramEvsInventory.getInvArea());
      localEvsInventory2.setInvRow(paramEvsInventory.getInvRow());
      localEvsInventory2.setInvColumn(paramEvsInventory.getInvColumn());
      localEvsInventory2.setInvLevel(paramEvsInventory.getInvLevel());
      this.docAccessStorageDAO.updateInventory(localEvsInventory2);
      this.docAccessStorageDAO.updateBookStateByBookId(localEvsInventory1.getBookId());
      EvsBookV localEvsBookV = this.docAccessStorageDAO.findEvsBookModelByBookId(localEvsInventory1.getBookId());
      this.docAccessStorageDAO.updateVoucherStateByBookId(localEvsBookV);
      EvsVoucherHistory localEvsVoucherHistory = new EvsVoucherHistory();
      localEvsVoucherHistory.setOpObjectType(Long.valueOf(1L));
      localEvsVoucherHistory.setObjectCode(localEvsInventory1.getBookId().toString());
      localEvsVoucherHistory.setOpPeople(localEvsInventory1.getCreatedBy());
      localEvsVoucherHistory.setAction("入库");
      localEvsVoucherHistory.setHandleDate(localEvsInventory1.getLastUpdateDate());
      localEvsVoucherHistory.setHistoryId(localEvsInventory1.getLastUpdatedBy());
      localEvsVoucherHistory.setBeginStatus("BOOKED");
      localEvsVoucherHistory.setEndStatus("WAREHOUSE");
      this.docAccessStorageDAO.insertEvsVoucherHistory(localEvsVoucherHistory);
    }
  }
  
  public String updateInventoryBybatchNum(EvsInventory paramEvsInventory)
  {
    List localList = this.docAccessStorageDAO.findInventoryByBatchNum(paramEvsInventory.getInvBatchNum());
    if ((localList == null) && (localList.size() < 1))
    {
      this.logger.error("批次号为" + paramEvsInventory.getInvBatchNum() + "的数据不存在");
      return "T";
    }
    if ((Util.isStrEmpty(paramEvsInventory.getInvArea())) && (Util.isStrEmpty(paramEvsInventory.getInvRow())) && (Util.isStrEmpty(paramEvsInventory.getInvColumn())) && (Util.isStrEmpty(paramEvsInventory.getInvLevel())))
    {
      updateData(paramEvsInventory, localList);
    }
    else
    {
      boolean bool = this.docAccessStorageDAO.findLibraryIsExist(paramEvsInventory);
      if (bool)
      {
        updateData(paramEvsInventory, localList);
      }
      else
      {
        this.logger.error("库位信息不存在");
        return "N";
      }
    }
    return "Y";
  }
  
  public String addInventoryBybatchNum(EvsInventory paramEvsInventory)
  {
    boolean bool = this.docAccessStorageDAO.findLibraryIsExist(paramEvsInventory);
    if (bool)
    {
      List localList = this.docAccessStorageDAO.findInventoryByBatchNum(paramEvsInventory.getInvBatchNum());
      if ((localList == null) && (localList.size() < 1))
      {
        this.logger.error("批次号为" + paramEvsInventory.getInvBatchNum() + "的数据不存在");
        return "T";
      }
      updateData(paramEvsInventory, localList);
    }
    else
    {
      this.logger.error("库位信息不存在");
      return "N";
    }
    return "Y";
  }
  
  public Integer findBookNum(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Integer localInteger = Integer.valueOf(0);
    localInteger = this.docAccessStorageDAO.findBookNum(paramString1, paramString2, paramString3, paramString4);
    return localInteger;
  }
  
  public TableDataInfo findAllBook(EvsBookModel paramEvsBookModel, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    Map localMap = this.docAccessStorageDAO.findAllBook(paramEvsBookModel, paramInt1, paramInt2);
    List localList = (List)localMap.get("data");
    ArrayList localArrayList = new ArrayList();
    int i = localList.size();
    for (int j = 0; j < i; j++)
    {
      EvsBookV localEvsBookV = (EvsBookV)localList.get(j);
      StringBuffer localStringBuffer = new StringBuffer();
      Object localObject;
      if (!Util.isNullObject(localEvsBookV.getInvCityId()))
      {
        localObject = this.docAccessStorageDAO.findCityNameByCityId(localEvsBookV.getInvCityId());
        if (!Util.isNullObject(localObject)) {
          localStringBuffer.append(((EvsCity)localObject).getCityName());
        }
      }
      if (!Util.isStrEmpty(localEvsBookV.getInvStorageCode()))
      {
        localStringBuffer.append("-");
        localObject = this.docAccessStorageDAO.findStorageDocNameByStoCode(localEvsBookV.getInvStorageCode());
        if (!Util.isNullObject(localObject)) {
          localStringBuffer.append(((EvsStorageDoc)localObject).getStorageName());
        }
      }
      if (!Util.isStrEmpty(localEvsBookV.getInvArea()))
      {
        localStringBuffer.append("-");
        localObject = this.docAccessStorageDAO.findFbpLookupValues(localEvsBookV.getInvArea());
        if (!Util.isNullObject(localObject)) {
          localStringBuffer.append(((FbpLookupValuesV)localObject).getMeaning());
        }
      }
      if (!Util.isStrEmpty(localEvsBookV.getInvRow()))
      {
        localStringBuffer.append("-");
        localObject = this.docAccessStorageDAO.findFbpLookupValues(localEvsBookV.getInvRow());
        if (!Util.isNullObject(localObject)) {
          localStringBuffer.append(((FbpLookupValuesV)localObject).getMeaning());
        }
      }
      if (!Util.isStrEmpty(localEvsBookV.getInvColumn()))
      {
        localStringBuffer.append("-");
        localObject = this.docAccessStorageDAO.findFbpLookupValues(localEvsBookV.getInvColumn());
        if (!Util.isNullObject(localObject)) {
          localStringBuffer.append(((FbpLookupValuesV)localObject).getMeaning());
        }
      }
      if (!Util.isStrEmpty(localEvsBookV.getInvLevel()))
      {
        localStringBuffer.append("-");
        localObject = this.docAccessStorageDAO.findFbpLookupValues(localEvsBookV.getInvLevel());
        if (!Util.isNullObject(localObject)) {
          localStringBuffer.append(((FbpLookupValuesV)localObject).getMeaning());
        }
      }
      localEvsBookV.setSavaPlace(localStringBuffer.toString());
      localArrayList.add(localEvsBookV);
    }
    localTableDataInfo.setData(localArrayList);
    localTableDataInfo.setTotalCount(Integer.parseInt(localMap.get("totalCount").toString()));
    return localTableDataInfo;
  }
  
  public EvsInventory findEvsInventoryByBookId(Long paramLong)
  {
    EvsInventory localEvsInventory = this.docAccessStorageDAO.findEvsInventoryByBookId(paramLong);
    if (!Util.isNullObject(localEvsInventory))
    {
      EvsCity localEvsCity = this.docAccessStorageDAO.findCityNameByCityId(Long.valueOf(Long.parseLong(localEvsInventory.getInvCityId())));
      EvsStorageDoc localEvsStorageDoc = this.docAccessStorageDAO.findStorageDocNameByStoCode(localEvsInventory.getInvStorageCode());
      localEvsInventory.setInvCityName(localEvsCity.getCityName());
      localEvsInventory.setInvStorageId(localEvsStorageDoc.getStorageId());
      localEvsInventory.setInvStorageName(localEvsStorageDoc.getStorageName());
      return localEvsInventory;
    }
    return new EvsInventory();
  }
  
  public String updateInventoryByBookId(EvsInventory paramEvsInventory)
  {
    String str = "N";
    if ((Util.isStrEmpty(paramEvsInventory.getInvArea())) && (Util.isStrEmpty(paramEvsInventory.getInvRow())) && (Util.isStrEmpty(paramEvsInventory.getInvColumn())) && (Util.isStrEmpty(paramEvsInventory.getInvLevel())))
    {
      paramEvsInventory.setEnabledFlag("Y");
      ObjectCopyUtils.setWho(paramEvsInventory);
      this.docAccessStorageDAO.updateInventoryByBookId(paramEvsInventory);
      str = "Y";
      return str;
    }
    boolean bool = this.docAccessStorageDAO.findLibraryIsExist(paramEvsInventory);
    if (bool)
    {
      paramEvsInventory.setEnabledFlag("Y");
      ObjectCopyUtils.setWho(paramEvsInventory);
      this.docAccessStorageDAO.updateInventoryByBookId(paramEvsInventory);
      str = "Y";
      return str;
    }
    return str;
  }
  
  public EvsInventory findEvsInventoryByVentoryID(Long paramLong)
  {
    EvsInventory localEvsInventory = this.docAccessStorageDAO.findEvsInventoryByVentoryID(paramLong);
    if (!Util.isNullObject(localEvsInventory))
    {
      EvsCity localEvsCity = this.docAccessStorageDAO.findCityNameByCityId(Long.valueOf(Long.parseLong(localEvsInventory.getInvCityId())));
      EvsStorageDoc localEvsStorageDoc = this.docAccessStorageDAO.findStorageDocNameByStoCode(localEvsInventory.getInvStorageCode());
      localEvsInventory.setInvCityName(localEvsCity.getCityName());
      localEvsInventory.setInvStorageId(localEvsStorageDoc.getStorageId());
      localEvsInventory.setInvStorageName(localEvsStorageDoc.getStorageName());
      return localEvsInventory;
    }
    return new EvsInventory();
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
 * Qualified Name:     com.zte.evs.ebill.business.eBillManage.EvsDocAccessStorageService
 * JD-Core Version:    0.7.0.1
 */