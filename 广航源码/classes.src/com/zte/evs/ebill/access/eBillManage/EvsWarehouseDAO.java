package com.zte.evs.ebill.access.eBillManage;

import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.evs.ebill.common.EvsObjectUtils;
import com.zte.evs.ebill.model.eBillManage.EvsInventoryV;
import com.zte.evs.ebill.model.eBillManage.EvsWarehouse;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.util.Util;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import com.zte.ssb.zorm.Query;
import com.zte.ssb.zorm.Session;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class EvsWarehouseDAO
  extends BaseDAO
  implements IEvsWarehouseDAO
{
  private static final Log log = LogFactory.getLog(EvsWarehouseDAO.class);
  
  public Map findAllWarehouse(EvsWarehouse paramEvsWarehouse, int paramInt1, int paramInt2)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append("from EvsWarehouse ew where 1=1");
    if (!Util.isStrEmpty(paramEvsWarehouse.getWarehouseCode()))
    {
      localStringBuffer.append(" and ew.warehouseCode like ?");
      localArrayList.add("%" + paramEvsWarehouse.getWarehouseCode() + "%");
    }
    if (!Util.isStrEmpty(paramEvsWarehouse.getWarehouseName()))
    {
      localStringBuffer.append(" and ew.warehouseName like ?");
      localArrayList.add("%" + paramEvsWarehouse.getWarehouseName() + "%");
    }
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1 / paramInt2 + 1, paramInt2, localArrayList.toArray());
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", localPageInfo.getResult());
    localHashMap.put("totalCount", Long.valueOf(localPageInfo.getTotalCount()));
    return localHashMap;
  }
  
  public EvsWarehouse getWarehouseCode(String paramString)
  {
    EvsWarehouse localEvsWarehouse = null;
    String str = null;
    log.debug("select EvsWarehouse");
    try
    {
      if (!Util.isStrEmpty(paramString)) {
        str = "from EvsWarehouse pag where pag.warehouseCode = '" + paramString + "'";
      }
      List localList = getSession().createQuery(str).list();
      localEvsWarehouse = localList.size() > 0 ? (EvsWarehouse)localList.get(0) : null;
      log.debug("select EvsWarehouse By code");
      return localEvsWarehouse;
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("select failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public EvsWarehouse getEvsWarehouse(BigInteger paramBigInteger)
  {
    return (EvsWarehouse)super.getObject(EvsWarehouse.class, paramBigInteger);
  }
  
  public List getEvsWarehouses()
  {
    return super.getObjects(EvsWarehouse.class);
  }
  
  public List<EvsWarehouse> getEvsWarehouses(int paramInt1, int paramInt2)
  {
    return super.getObjects(EvsWarehouse.class, paramInt1, paramInt2);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeEvsWarehouse(EvsWarehouse paramEvsWarehouse)
  {
    super.removeObject(paramEvsWarehouse);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertEvsWarehouse(EvsWarehouse paramEvsWarehouse)
  {
    super.insertObject(paramEvsWarehouse);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateEvsWarehouse(EvsWarehouse paramEvsWarehouse)
  {
    super.updateObject(paramEvsWarehouse);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertEvsWarehouses(List<EvsWarehouse> paramList)
  {
    super.insertObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeEvsWarehouses(List<EvsWarehouse> paramList)
  {
    super.removeObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateEvsWarehouses(List<EvsWarehouse> paramList)
  {
    super.updateObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeEvsWarehouse(BigInteger paramBigInteger)
  {
    super.removeObject(EvsWarehouse.class, paramBigInteger);
  }
  
  public Map findAllStorageInfo(EvsInventoryV paramEvsInventoryV, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append("from EvsInventoryV ei where 1=1");
    if (!Util.isStrEmpty(paramEvsInventoryV.getInvCityId()))
    {
      localStringBuffer.append(" and ei.invCityId = ?");
      localArrayList.add(paramEvsInventoryV.getInvCityId());
    }
    if (!Util.isStrEmpty(paramEvsInventoryV.getInvStorageCode()))
    {
      localStringBuffer.append(" and ei.invStorageCode = ?");
      localArrayList.add(paramEvsInventoryV.getInvStorageCode());
    }
    if (!Util.isStrEmpty(paramEvsInventoryV.getAreaName())) {
      if ((paramEvsInventoryV.getBlurQuery() != null) && (paramEvsInventoryV.getBlurQuery().equals("Y")))
      {
        localStringBuffer.append(" and ei.invArea like ?");
        localArrayList.add("%" + paramEvsInventoryV.getAreaName() + "%");
      }
      else
      {
        localStringBuffer.append(" and ei.invArea like ?");
        localArrayList.add(paramEvsInventoryV.getAreaName());
      }
    }
    if (!Util.isStrEmpty(paramEvsInventoryV.getColumnName())) {
      if ((paramEvsInventoryV.getBlurQuery() != null) && (paramEvsInventoryV.getBlurQuery().equals("Y")))
      {
        localStringBuffer.append(" and ei.invColumn like ?");
        localArrayList.add("%" + paramEvsInventoryV.getColumnName() + "%");
      }
      else
      {
        localStringBuffer.append(" and ei.invColumn like ?");
        localArrayList.add(paramEvsInventoryV.getColumnName());
      }
    }
    if (!Util.isStrEmpty(paramEvsInventoryV.getRowName())) {
      if ((paramEvsInventoryV.getBlurQuery() != null) && (paramEvsInventoryV.getBlurQuery().equals("Y")))
      {
        localStringBuffer.append(" and ei.invRow like ?");
        localArrayList.add("%" + paramEvsInventoryV.getRowName() + "%");
      }
      else
      {
        localStringBuffer.append(" and ei.invRow like ?");
        localArrayList.add(paramEvsInventoryV.getRowName());
      }
    }
    if (!Util.isStrEmpty(paramEvsInventoryV.getLevelName())) {
      if ((paramEvsInventoryV.getBlurQuery() != null) && (paramEvsInventoryV.getBlurQuery().equals("Y")))
      {
        localStringBuffer.append(" and ei.invLevel like ?");
        localArrayList.add("%" + paramEvsInventoryV.getLevelName() + "%");
      }
      else
      {
        localStringBuffer.append(" and ei.invLevel like ?");
        localArrayList.add(paramEvsInventoryV.getLevelName());
      }
    }
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1 / paramInt2 + 1, paramInt2, localArrayList.toArray());
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", localPageInfo.getResult());
    localHashMap.put("totalCount", Long.valueOf(localPageInfo.getTotalCount()));
    return localHashMap;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.eBillManage.EvsWarehouseDAO
 * JD-Core Version:    0.7.0.1
 */