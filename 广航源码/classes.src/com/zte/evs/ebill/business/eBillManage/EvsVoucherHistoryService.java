package com.zte.evs.ebill.business.eBillManage;

import com.zte.eas.resconfig.business.lookup.model.FbpLookupValuesV;
import com.zte.evs.ebill.access.eBillManage.IEvsBookDAO;
import com.zte.evs.ebill.access.eBillManage.IEvsDocAccessStorageDAO;
import com.zte.evs.ebill.access.eBillManage.IEvsVoucherHistoryDAO;
import com.zte.evs.ebill.common.JsonUtils;
import com.zte.evs.ebill.model.eBillManage.DepositAddressModel;
import com.zte.evs.ebill.model.eBillManage.EvsCity;
import com.zte.evs.ebill.model.eBillManage.EvsStorageDoc;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherHistoryModel;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherHistoryV;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.util.Util;
import java.util.List;
import java.util.Map;

public class EvsVoucherHistoryService
  implements IEvsVoucherHistoryService
{
  private IEvsVoucherHistoryDAO historyDAO;
  private IEvsBookDAO bookDAO;
  private IEvsDocAccessStorageDAO docAccessStorageDAO;
  
  public IEvsVoucherHistoryDAO getHistoryDAO()
  {
    return this.historyDAO;
  }
  
  public void setHistoryDAO(IEvsVoucherHistoryDAO paramIEvsVoucherHistoryDAO)
  {
    this.historyDAO = paramIEvsVoucherHistoryDAO;
  }
  
  public TableDataInfo findAllHistory(EvsVoucherHistoryModel paramEvsVoucherHistoryModel, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    Map localMap = this.historyDAO.findAllHistory(paramEvsVoucherHistoryModel, paramInt1, paramInt2);
    localTableDataInfo.setData((List)localMap.get("data"));
    localTableDataInfo.setTotalCount(Integer.parseInt(localMap.get("totalCount").toString()));
    return localTableDataInfo;
  }
  
  public TableDataInfo findHistoryByObjectCode(String paramString, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    Map localMap = null;
    localMap = this.historyDAO.findHistoryByObjectCode(paramString, paramInt1, paramInt2);
    localTableDataInfo.setData((List)localMap.get("data"));
    localTableDataInfo.setTotalCount(Integer.parseInt(localMap.get("totalCount").toString()));
    return localTableDataInfo;
  }
  
  public TableDataInfo findHistoryByPackageId(String paramString, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    Map localMap = null;
    localMap = this.historyDAO.findHistoryByPackageId(paramString, paramInt1, paramInt2);
    localTableDataInfo.setData((List)localMap.get("data"));
    localTableDataInfo.setTotalCount(Integer.parseInt(localMap.get("totalCount").toString()));
    return localTableDataInfo;
  }
  
  public TableDataInfo findHistoryByObjectCodeNew(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    PageInfo localPageInfo = this.historyDAO.findHistoryByObjectCodeNew(paramString, paramInt1, paramInt2, paramInt3);
    TableDataInfo localTableDataInfo = new TableDataInfo();
    List localList = (List)localPageInfo.getResult();
    int i = localList.size();
    for (int j = 0; j < i; j++)
    {
      String str = ((EvsVoucherHistoryV)localList.get(j)).getAddress();
      if (!Util.isNullObject(str))
      {
        DepositAddressModel localDepositAddressModel = (DepositAddressModel)JsonUtils.jsonToBean(str, new DepositAddressModel());
        StringBuffer localStringBuffer = new StringBuffer();
        if (localDepositAddressModel != null)
        {
          Object localObject;
          if (!Util.isNullObject(localDepositAddressModel.getInvCityId()))
          {
            localObject = this.docAccessStorageDAO.findCityNameByCityId(Long.valueOf(localDepositAddressModel.getInvCityId()));
            if (!Util.isNullObject(localObject)) {
              localStringBuffer.append(((EvsCity)localObject).getCityName());
            }
          }
          if (!Util.isStrEmpty(localDepositAddressModel.getInvStorageCode()))
          {
            localStringBuffer.append("-");
            localObject = this.docAccessStorageDAO.findStorageDocNameByStoCode(localDepositAddressModel.getInvStorageCode());
            if (!Util.isNullObject(localObject)) {
              localStringBuffer.append(((EvsStorageDoc)localObject).getStorageName());
            }
          }
          if (!Util.isStrEmpty(localDepositAddressModel.getInvArea()))
          {
            localStringBuffer.append("-");
            localObject = this.docAccessStorageDAO.findFbpLookupValues(localDepositAddressModel.getInvArea());
            if (!Util.isNullObject(localObject)) {
              localStringBuffer.append(((FbpLookupValuesV)localObject).getMeaning());
            }
          }
          if (!Util.isStrEmpty(localDepositAddressModel.getInvRow()))
          {
            localStringBuffer.append("-");
            localObject = this.docAccessStorageDAO.findFbpLookupValues(localDepositAddressModel.getInvRow());
            if (!Util.isNullObject(localObject)) {
              localStringBuffer.append(((FbpLookupValuesV)localObject).getMeaning());
            }
          }
          if (!Util.isStrEmpty(localDepositAddressModel.getInvColumn()))
          {
            localStringBuffer.append("-");
            localObject = this.docAccessStorageDAO.findFbpLookupValues(localDepositAddressModel.getInvColumn());
            if (!Util.isNullObject(localObject)) {
              localStringBuffer.append(((FbpLookupValuesV)localObject).getMeaning());
            }
          }
          if (!Util.isStrEmpty(localDepositAddressModel.getInvLevel()))
          {
            localStringBuffer.append("-");
            localObject = this.docAccessStorageDAO.findFbpLookupValues(localDepositAddressModel.getInvLevel());
            if (!Util.isNullObject(localObject)) {
              localStringBuffer.append(((FbpLookupValuesV)localObject).getMeaning());
            }
          }
          ((EvsVoucherHistoryV)localList.get(j)).setArchivesSiteName(localStringBuffer.toString());
        }
      }
    }
    localTableDataInfo.setData(localList);
    localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
    return localTableDataInfo;
  }
  
  public TableDataInfo findHistoryByVoucherId(String paramString, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    Map localMap = null;
    localMap = this.historyDAO.findHistoryByVoucherId(paramString, paramInt1, paramInt2);
    localTableDataInfo.setData((List)localMap.get("data"));
    localTableDataInfo.setTotalCount(Integer.parseInt(localMap.get("totalCount").toString()));
    return localTableDataInfo;
  }
  
  public IEvsDocAccessStorageDAO getDocAccessStorageDAO()
  {
    return this.docAccessStorageDAO;
  }
  
  public void setDocAccessStorageDAO(IEvsDocAccessStorageDAO paramIEvsDocAccessStorageDAO)
  {
    this.docAccessStorageDAO = paramIEvsDocAccessStorageDAO;
  }
  
  public IEvsBookDAO getBookDAO()
  {
    return this.bookDAO;
  }
  
  public void setBookDAO(IEvsBookDAO paramIEvsBookDAO)
  {
    this.bookDAO = paramIEvsBookDAO;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.eBillManage.EvsVoucherHistoryService
 * JD-Core Version:    0.7.0.1
 */