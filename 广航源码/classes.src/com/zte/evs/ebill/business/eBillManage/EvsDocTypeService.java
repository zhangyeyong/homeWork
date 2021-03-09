package com.zte.evs.ebill.business.eBillManage;

import com.zte.evs.ebill.access.eBillManage.IEvsDocTypeDAO;
import com.zte.evs.ebill.access.eBillManage.IEvsSubDocTypeDAO;
import com.zte.evs.ebill.model.eBillManage.EvsDocType;
import com.zte.evs.ebill.model.eBillManage.EvsDocTypeV;
import com.zte.evs.ebill.model.eBillManage.EvsDocTypeVo;
import com.zte.evs.ebill.model.eBillManage.FbfLookupValues;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.ssbext.resource.ComResUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class EvsDocTypeService
  implements IEvsDocTypeService
{
  private IEvsDocTypeDAO evsDocTypeDAO;
  private IEvsSubDocTypeDAO evsSubDocTypeDAO;
  
  public TableDataInfo getDocTypeQuery(EvsDocTypeVo paramEvsDocTypeVo, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    Map localMap = this.evsDocTypeDAO.findDocTypeByQry(paramEvsDocTypeVo, paramInt1, paramInt2);
    List localList = (List)localMap.get("data");
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      EvsDocTypeV localEvsDocTypeV = (EvsDocTypeV)localIterator.next();
      localEvsDocTypeV.setDocDeadline(this.evsDocTypeDAO.findDeadline(localEvsDocTypeV.getDocDeadline()));
    }
    localTableDataInfo.setData(localList);
    localTableDataInfo.setTotalCount(Integer.parseInt(localMap.get("totalCount").toString()));
    return localTableDataInfo;
  }
  
  public String saveDocType(EvsDocTypeVo paramEvsDocTypeVo)
  {
    String str = "0";
    EvsDocType localEvsDocType = new EvsDocType();
    localEvsDocType.setDocCode(paramEvsDocTypeVo.getDocCode());
    localEvsDocType.setDocName(paramEvsDocTypeVo.getDocName());
    localEvsDocType.setDocDeadline(paramEvsDocTypeVo.getDocDeadline());
    localEvsDocType.setEnabledFlag(paramEvsDocTypeVo.getEnabledFlag());
    localEvsDocType.setDocMemo(paramEvsDocTypeVo.getDocMemo());
    str = this.evsDocTypeDAO.save(localEvsDocType);
    return str;
  }
  
  public String updateDocType(EvsDocTypeVo paramEvsDocTypeVo)
  {
    int i = 0;
    EvsDocType localEvsDocType1 = this.evsDocTypeDAO.findById(Long.valueOf(Long.parseLong(paramEvsDocTypeVo.getDocId())));
    if (!localEvsDocType1.getDocName().equals(paramEvsDocTypeVo.getDocName().trim()))
    {
      i = this.evsDocTypeDAO.getCountName(paramEvsDocTypeVo.getDocName());
      if (i != 0) {
        return "1";
      }
    }
    if (("N".equals(paramEvsDocTypeVo.getEnabledFlag())) && (this.evsSubDocTypeDAO.getCountByDocId(Long.valueOf(Long.parseLong(paramEvsDocTypeVo.getDocId()))) > 0)) {
      return "2";
    }
    EvsDocType localEvsDocType2 = new EvsDocType();
    localEvsDocType2.setDocId(Long.valueOf(Long.parseLong(paramEvsDocTypeVo.getDocId())));
    localEvsDocType2.setDocCode(paramEvsDocTypeVo.getDocCode());
    localEvsDocType2.setDocName(paramEvsDocTypeVo.getDocName().trim());
    localEvsDocType2.setDocDeadline(paramEvsDocTypeVo.getDocDeadline());
    localEvsDocType2.setEnabledFlag(paramEvsDocTypeVo.getEnabledFlag());
    localEvsDocType2.setDocMemo(paramEvsDocTypeVo.getDocMemo());
    this.evsDocTypeDAO.update(localEvsDocType2);
    return "0";
  }
  
  public EvsDocType findById(Long paramLong)
  {
    return this.evsDocTypeDAO.findById(paramLong);
  }
  
  public Map getDocTypeForSelect()
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    List localList = this.evsDocTypeDAO.findDocTypeForSelect();
    localArrayList1.add(ComResUtil.getMessage("fbp.lookup.select"));
    localArrayList2.add("");
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        EvsDocType localEvsDocType = (EvsDocType)localIterator.next();
        if (localEvsDocType != null)
        {
          localArrayList1.add(localEvsDocType.getDocName() == null ? "" : localEvsDocType.getDocName().trim());
          localArrayList2.add(localEvsDocType.getDocId());
        }
      }
    }
    localHashMap.put("selectText", localArrayList1);
    localHashMap.put("selectValue", localArrayList2);
    return localHashMap;
  }
  
  public Map getDocTypeForDeadline()
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    List localList = this.evsDocTypeDAO.findDocTypeForDeadline();
    localArrayList1.add(ComResUtil.getMessage("fbp.lookup.select"));
    localArrayList2.add("");
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        FbfLookupValues localFbfLookupValues = (FbfLookupValues)localIterator.next();
        if (localFbfLookupValues != null)
        {
          localArrayList1.add(localFbfLookupValues.getMeaning() == null ? "" : localFbfLookupValues.getMeaning().trim());
          localArrayList2.add(localFbfLookupValues.getLookupCode());
        }
      }
    }
    localHashMap.put("selectText", localArrayList1);
    localHashMap.put("selectValue", localArrayList2);
    return localHashMap;
  }
  
  public String getDocTypeDeadline(Long paramLong)
  {
    String str = "";
    EvsDocType localEvsDocType = this.evsDocTypeDAO.findById(paramLong);
    str = localEvsDocType.getDocDeadline();
    return str;
  }
  
  public String getDeadlineName(String paramString)
  {
    return this.evsDocTypeDAO.findDeadline(paramString);
  }
  
  public IEvsDocTypeDAO getEvsDocTypeDAO()
  {
    return this.evsDocTypeDAO;
  }
  
  public void setEvsDocTypeDAO(IEvsDocTypeDAO paramIEvsDocTypeDAO)
  {
    this.evsDocTypeDAO = paramIEvsDocTypeDAO;
  }
  
  public IEvsSubDocTypeDAO getEvsSubDocTypeDAO()
  {
    return this.evsSubDocTypeDAO;
  }
  
  public void setEvsSubDocTypeDAO(IEvsSubDocTypeDAO paramIEvsSubDocTypeDAO)
  {
    this.evsSubDocTypeDAO = paramIEvsSubDocTypeDAO;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.eBillManage.EvsDocTypeService
 * JD-Core Version:    0.7.0.1
 */