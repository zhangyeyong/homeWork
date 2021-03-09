package com.zte.evs.ebill.access.eBillManage;

import com.zte.eas.appframe.business.util.ObjectCopyUtils;
import com.zte.evs.ebill.model.eBillManage.EvsDocAdmin;
import com.zte.evs.ebill.model.eBillManage.EvsLibraryInfo;
import com.zte.evs.ebill.model.eBillManage.EvsStorageDoc;
import com.zte.evs.ebill.model.eBillManage.EvsStorageDocV;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.util.Util;
import com.zte.ssb.zorm.Query;
import com.zte.ssb.zorm.Session;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvsStorageDocDAO
  extends BaseDAO
  implements IEvsStorageDocDAO
{
  public Map findAllStorageDoc(EvsStorageDocV paramEvsStorageDocV, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList();
    localStringBuffer.append("from EvsStorageDocV es where 1=1");
    if (!Util.isStrEmpty(paramEvsStorageDocV.getStorageCode()))
    {
      localStringBuffer.append(" and es.storageCode like ?");
      localArrayList.add("%" + paramEvsStorageDocV.getStorageCode() + "%");
    }
    if (!Util.isStrEmpty(paramEvsStorageDocV.getStorageName()))
    {
      localStringBuffer.append(" and es.storageName like ?");
      localArrayList.add("%" + paramEvsStorageDocV.getStorageName() + "%");
    }
    if (!Util.isNullObject(paramEvsStorageDocV.getCompanyId()))
    {
      localStringBuffer.append(" and es.companyId = ?");
      localArrayList.add(paramEvsStorageDocV.getCompanyId());
    }
    if (!Util.isNullObject(paramEvsStorageDocV.getCityId()))
    {
      localStringBuffer.append(" and es.cityId = ?");
      localArrayList.add(paramEvsStorageDocV.getCityId());
    }
    if (!Util.isStrEmpty(paramEvsStorageDocV.getDocAdminId()))
    {
      localStringBuffer.append(" and exists( from EvsDocAdmin eda where es.storageId = eda.storageId and eda.docAdminId = ? )");
      localArrayList.add(Long.valueOf(paramEvsStorageDocV.getDocAdminId()));
    }
    if (!Util.isStrEmpty(paramEvsStorageDocV.getState()))
    {
      localStringBuffer.append(" and es.state = ?");
      localArrayList.add(paramEvsStorageDocV.getState());
    }
    paramInt1 = paramInt1 / paramInt2 + 1;
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1, paramInt2, localArrayList.toArray());
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", localPageInfo.getResult());
    localHashMap.put("totalCount", Long.valueOf(localPageInfo.getTotalCount()));
    return localHashMap;
  }
  
  public String insertStorageDoc(EvsStorageDocV paramEvsStorageDocV, List<EvsLibraryInfo> paramList)
  {
    EvsStorageDoc localEvsStorageDoc = new EvsStorageDoc();
    try
    {
      ObjectCopyUtils.setWho(localEvsStorageDoc);
      localEvsStorageDoc.setEnabledFlag("Y");
      localEvsStorageDoc.setStorageCode(paramEvsStorageDocV.getStorageCode());
      localEvsStorageDoc.setStorageName(paramEvsStorageDocV.getStorageName());
      if (Util.isStrEmpty(paramEvsStorageDocV.getState())) {
        localEvsStorageDoc.setState("Y");
      } else {
        localEvsStorageDoc.setState(paramEvsStorageDocV.getState());
      }
      localEvsStorageDoc.setCityId(paramEvsStorageDocV.getCityId());
      localEvsStorageDoc.setCompanyId(paramEvsStorageDocV.getCompanyId());
      super.insertObject(localEvsStorageDoc);
      Object localObject1;
      Object localObject2;
      if ((!Util.isStrEmpty(paramEvsStorageDocV.getDocAdminId())) && (!Util.isStrEmpty(paramEvsStorageDocV.getDocAdminName())) && (!Util.isStrEmpty(paramEvsStorageDocV.getDocAdminCode())))
      {
        String[] arrayOfString1 = paramEvsStorageDocV.getDocAdminId().split(",");
        localObject1 = paramEvsStorageDocV.getDocAdminCode().split(",");
        localObject2 = paramEvsStorageDocV.getDocAdminName().split(",");
        for (int j = 0; j < arrayOfString1.length; j++)
        {
          EvsDocAdmin localEvsDocAdmin = new EvsDocAdmin();
          ObjectCopyUtils.setWho(localEvsDocAdmin);
          localEvsDocAdmin.setEnabledFlag("Y");
          localEvsDocAdmin.setDocAdminId(Long.valueOf(arrayOfString1[j]));
          localEvsDocAdmin.setDocAdminCode(localObject1[j]);
          localEvsDocAdmin.setDocAdminName(localObject2[j]);
          localEvsDocAdmin.setStorageId(localEvsStorageDoc.getStorageId());
          super.insertObject(localEvsDocAdmin);
        }
      }
      for (int i = 0; i < paramList.size(); i++)
      {
        localObject1 = (EvsLibraryInfo)paramList.get(i);
        ObjectCopyUtils.setWho(localObject1);
        ((EvsLibraryInfo)localObject1).setEnabledFlag("Y");
        localObject2 = ((EvsLibraryInfo)localObject1).getLibraryCode();
        String[] arrayOfString2 = ((String)localObject2).trim().replace("|", ",").split(",");
        ((EvsLibraryInfo)localObject1).setLibraryCode(arrayOfString2[0]);
        ((EvsLibraryInfo)localObject1).setStorageId(localEvsStorageDoc.getStorageId());
        super.insertObject(localObject1);
      }
      return "Y";
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "N";
  }
  
  public List<EvsLibraryInfo> findEvsLibraryInfoByStoId(Long paramLong)
  {
    String str = "from EvsLibraryInfo s where 1=1 and s.storageId=" + paramLong;
    return getSession().createQuery(str).list();
  }
  
  public EvsStorageDocV findEvsStorageDocV(Long paramLong)
  {
    return (EvsStorageDocV)getObject(EvsStorageDocV.class, paramLong);
  }
  
  public String updateStorageDoc(EvsStorageDocV paramEvsStorageDocV, List<EvsLibraryInfo> paramList)
  {
    EvsStorageDoc localEvsStorageDoc = new EvsStorageDoc();
    try
    {
      ObjectCopyUtils.setWho(localEvsStorageDoc);
      localEvsStorageDoc.setEnabledFlag("Y");
      localEvsStorageDoc.setStorageId(paramEvsStorageDocV.getStorageId());
      localEvsStorageDoc.setStorageCode(paramEvsStorageDocV.getStorageCode());
      localEvsStorageDoc.setStorageName(paramEvsStorageDocV.getStorageName());
      if (Util.isStrEmpty(paramEvsStorageDocV.getState())) {
        localEvsStorageDoc.setState("Y");
      } else {
        localEvsStorageDoc.setState(paramEvsStorageDocV.getState());
      }
      localEvsStorageDoc.setCityId(paramEvsStorageDocV.getCityId());
      localEvsStorageDoc.setCompanyId(paramEvsStorageDocV.getCompanyId());
      super.updateObject(localEvsStorageDoc);
      String str1 = "DELETE FROM EvsDocAdmin DA WHERE DA.storageId=?";
      Query localQuery = super.getSession().createQuery(str1);
      localQuery.setLong(0, paramEvsStorageDocV.getStorageId().longValue());
      localQuery.executeUpdate();
      Object localObject1;
      Object localObject2;
      if ((!Util.isStrEmpty(paramEvsStorageDocV.getDocAdminId())) && (!Util.isStrEmpty(paramEvsStorageDocV.getDocAdminName())) && (!Util.isStrEmpty(paramEvsStorageDocV.getDocAdminCode())))
      {
        String[] arrayOfString1 = paramEvsStorageDocV.getDocAdminId().split(",");
        String[] arrayOfString2 = paramEvsStorageDocV.getDocAdminCode().split(",");
        localObject1 = paramEvsStorageDocV.getDocAdminName().split(",");
        for (int k = 0; k < arrayOfString1.length; k++)
        {
          localObject2 = new EvsDocAdmin();
          ObjectCopyUtils.setWho(localObject2);
          ((EvsDocAdmin)localObject2).setEnabledFlag("Y");
          ((EvsDocAdmin)localObject2).setDocAdminId(Long.valueOf(arrayOfString1[k]));
          ((EvsDocAdmin)localObject2).setDocAdminCode(arrayOfString2[k]);
          ((EvsDocAdmin)localObject2).setDocAdminName(localObject1[k]);
          ((EvsDocAdmin)localObject2).setStorageId(paramEvsStorageDocV.getStorageId());
          super.insertObject(localObject2);
        }
      }
      int i = paramList.size();
      if (i > 0) {
        deleteLibraryInfoByStoId(paramEvsStorageDocV.getStorageId());
      }
      for (int j = 0; j < i; j++)
      {
        localObject1 = (EvsLibraryInfo)paramList.get(j);
        ObjectCopyUtils.setWho(localObject1);
        ((EvsLibraryInfo)localObject1).setEnabledFlag("Y");
        String str2 = ((EvsLibraryInfo)localObject1).getLibraryCode();
        localObject2 = str2.trim().replace("|", ",").split(",");
        ((EvsLibraryInfo)localObject1).setLibraryCode(localObject2[0]);
        ((EvsLibraryInfo)localObject1).setStorageId(paramEvsStorageDocV.getStorageId());
        super.insertObject(localObject1);
      }
      return "Y";
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "N";
  }
  
  private void deleteLibraryInfoByStoId(Long paramLong)
  {
    String str = "DELETE FROM EvsLibraryInfo ei where ei.storageId=? and ei.enabledFlag='Y'";
    Query localQuery = super.getSession().createQuery(str);
    localQuery.setLong(0, paramLong.longValue());
    localQuery.executeUpdate();
  }
  
  public EvsStorageDoc findStorageDocExist(EvsStorageDocV paramEvsStorageDocV)
  {
    String str = "FROM EvsStorageDoc ei where ei.storageCode='" + paramEvsStorageDocV.getStorageCode() + "' and ei.enabledFlag='Y'";
    List localList = getSession().createQuery(str).list();
    if ((localList != null) && (localList.size() > 0)) {
      return (EvsStorageDoc)localList.get(0);
    }
    return null;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.eBillManage.EvsStorageDocDAO
 * JD-Core Version:    0.7.0.1
 */