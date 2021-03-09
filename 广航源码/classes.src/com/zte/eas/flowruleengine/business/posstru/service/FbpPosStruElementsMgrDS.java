package com.zte.eas.flowruleengine.business.posstru.service;

import com.zte.eas.appframe.business.util.ObjectCopyUtils;
import com.zte.eas.flowruleengine.access.posstru.dao.IFbpEmployeesQryVDAO;
import com.zte.eas.flowruleengine.access.posstru.dao.IFbpPosStruElementsDAO;
import com.zte.eas.flowruleengine.access.posstru.dao.IFbpPosStruElementsVDAO;
import com.zte.eas.flowruleengine.access.posstru.dao.IFbpPseHoldersDAO;
import com.zte.eas.flowruleengine.access.posstru.dao.IFbpPseHoldersVDAO;
import com.zte.eas.flowruleengine.business.posstru.model.FbpEmployeesQryV;
import com.zte.eas.flowruleengine.business.posstru.model.FbpPosStruElements;
import com.zte.eas.flowruleengine.business.posstru.model.FbpPosStruElementsV;
import com.zte.eas.flowruleengine.business.posstru.model.FbpPseHolders;
import com.zte.eas.flowruleengine.business.posstru.model.FbpPseHoldersV;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.BaseDomainService;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

public class FbpPosStruElementsMgrDS
  extends BaseDomainService
  implements IFbpPosStruElementsMgrDS
{
  private IFbpPosStruElementsDAO fbpPosStruElementsDAO;
  private IFbpPosStruElementsVDAO fbpPosStruElementsVDAO;
  private IFbpPseHoldersDAO fbpPseHoldersDAO;
  private IFbpPseHoldersVDAO fbpPseHoldersVDAO;
  private IFbpEmployeesQryVDAO fbpEmployeesQryVDAO;
  static final int DATA_COUNT = 400;
  static final String LOGIN_USERINFO = "loginuserinfo";
  static final String INSERTSUCCEED = "INSERTSUCCEED";
  static final String UPDATESUCCEED = "UPDATESUCCEED";
  static final String SAVEFAIL = "SAVEFAIL";
  static final String DELSUCCEED = "DELSUCCEED";
  static final String DELFAIL = "DELFAIL";
  
  public List findPosStruElementsVByQry(String paramString1, String paramString2, String paramString3)
  {
    if (paramString2 == null) {
      paramString2 = "0";
    }
    if ((paramString1 == null) || (paramString1.trim().length() == 0)) {
      return new ArrayList();
    }
    FbpPosStruElementsV localFbpPosStruElementsV = new FbpPosStruElementsV();
    localFbpPosStruElementsV.setPosStructureCode(paramString1);
    localFbpPosStruElementsV.setEnabledFlag(paramString3);
    localFbpPosStruElementsV.setParentPosStruElementId(Long.valueOf(Long.parseLong(paramString2)));
    return this.fbpPosStruElementsVDAO.findPosStruElementsVByQry(localFbpPosStruElementsV);
  }
  
  public Long findVirtualCompanyId(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.trim().length() == 0) || (paramString2 == null) || (paramString2.trim().length() == 0)) {
      return Long.valueOf(0L);
    }
    FbpPosStruElements localFbpPosStruElements = this.fbpPosStruElementsVDAO.findVirtualCompanyId(paramString1, paramString2);
    if (null != localFbpPosStruElements) {
      return localFbpPosStruElements.getPosStruElementId();
    }
    return null;
  }
  
  public FbpPosStruElementsV findPosStruElementsVById(String paramString)
  {
    return this.fbpPosStruElementsVDAO.findPosStruElementsVById(paramString);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public String savePosStruElements(FbpPosStruElementsV paramFbpPosStruElementsV)
  {
    String str = "";
    FbpPosStruElementsV localFbpPosStruElementsV = new FbpPosStruElementsV();
    localFbpPosStruElementsV.setPosStructureCode(paramFbpPosStruElementsV.getPosStructureCode());
    localFbpPosStruElementsV.setPositionId(paramFbpPosStruElementsV.getPositionId());
    localFbpPosStruElementsV.setDeterminer(paramFbpPosStruElementsV.getDeterminer());
    List localList = this.fbpPosStruElementsVDAO.findPosStruElementsVByQry(localFbpPosStruElementsV);
    int i = localList.size();
    if (i > 1) {
      return "has";
    }
    FbpPosStruElements localFbpPosStruElements = new FbpPosStruElements();
    ObjectCopyUtils.copy(paramFbpPosStruElementsV, localFbpPosStruElements);
    ObjectCopyUtils.setWho(localFbpPosStruElements);
    if (localFbpPosStruElements.getParentPosStruElementId() == null) {
      localFbpPosStruElements.setParentPosStruElementId(Long.valueOf(0L));
    }
    try
    {
      if ((paramFbpPosStruElementsV.getPosStruElementId() == null) || (paramFbpPosStruElementsV.getPosStruElementId().longValue() == 0L))
      {
        if (i == 1) {
          return "has";
        }
        this.fbpPosStruElementsDAO.insert(localFbpPosStruElements);
        str = "INSERTSUCCEED";
      }
      else
      {
        if (i == 1)
        {
          localObject = (FbpPosStruElementsV)localList.get(0);
          if (((FbpPosStruElementsV)localObject).getPosStruElementId().intValue() != paramFbpPosStruElementsV.getPosStruElementId().intValue()) {
            return "has";
          }
        }
        Object localObject = new ArrayList();
        ArrayList localArrayList = new ArrayList();
        localObject = getAllChildId((List)localObject, localArrayList, localFbpPosStruElements.getPosStructureCode(), localFbpPosStruElements.getPosStruElementId());
        if ((((List)localObject).indexOf(localFbpPosStruElements.getParentPosStruElementId()) != -1) || (localFbpPosStruElements.getPosStruElementId().intValue() == localFbpPosStruElements.getParentPosStruElementId().intValue()))
        {
          str = "fail";
        }
        else if ((localFbpPosStruElements.getEnabledFlag().equals("N")) && (localArrayList.size() > 0))
        {
          str = "haschild";
        }
        else
        {
          this.fbpPosStruElementsDAO.update(localFbpPosStruElements);
          str = "UPDATESUCCEED";
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      str = "SAVEFAIL";
    }
    return str;
  }
  
  private List getAllChildId(List paramList1, List paramList2, String paramString, Long paramLong)
  {
    FbpPosStruElementsV localFbpPosStruElementsV1 = new FbpPosStruElementsV();
    localFbpPosStruElementsV1.setParentPosStruElementId(paramLong);
    localFbpPosStruElementsV1.setPosStructureCode(paramString);
    List localList = this.fbpPosStruElementsVDAO.findPosStruElementsVByQry(localFbpPosStruElementsV1);
    for (int i = 0; i < localList.size(); i++)
    {
      FbpPosStruElementsV localFbpPosStruElementsV2 = (FbpPosStruElementsV)localList.get(i);
      paramList1.add(localFbpPosStruElementsV2.getPosStruElementId());
      if (localFbpPosStruElementsV2.getEnabledFlag().equals("Y")) {
        paramList2.add(localFbpPosStruElementsV2.getPosStruElementId());
      }
      getAllChildId(paramList1, paramList2, paramString, localFbpPosStruElementsV2.getPosStruElementId());
    }
    return paramList1;
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public String savePseHolders(String paramString, List<FbpEmployeesQryV> paramList)
  {
    FbpPseHoldersV localFbpPseHoldersV1 = new FbpPseHoldersV();
    localFbpPseHoldersV1.setPosStruElementId(Long.valueOf(Long.parseLong(paramString)));
    List localList = this.fbpPseHoldersVDAO.findPseHoldersVByElementId(localFbpPseHoldersV1);
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < localList.size(); i++)
    {
      FbpPseHoldersV localFbpPseHoldersV2 = (FbpPseHoldersV)localList.get(i);
      localArrayList.add(localFbpPseHoldersV2.getEmployeeId());
    }
    try
    {
      FbpEmployeesQryV localFbpEmployeesQryV = new FbpEmployeesQryV();
      for (int j = 0; j < paramList.size(); j++)
      {
        FbpPseHolders localFbpPseHolders = new FbpPseHolders();
        localFbpEmployeesQryV = (FbpEmployeesQryV)paramList.get(j);
        ObjectCopyUtils.setWho(localFbpPseHolders);
        localFbpPseHolders.setPosStruElementId(Long.valueOf(Long.parseLong(paramString)));
        localFbpPseHolders.setEmployeeId(localFbpEmployeesQryV.getEmployeeId());
        localFbpPseHolders.setEnabledFlag("Y");
        if (localArrayList.indexOf(localFbpEmployeesQryV.getEmployeeId()) == -1) {
          this.fbpPseHoldersDAO.insertObject(localFbpPseHolders);
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public TableDataInfo findPseHoldersVByElementId(String paramString1, String paramString2, String paramString3)
  {
    FbpPseHoldersV localFbpPseHoldersV = new FbpPseHoldersV();
    localFbpPseHoldersV.setPosStruElementId(Long.valueOf(Long.parseLong(paramString1)));
    List localList = this.fbpPseHoldersVDAO.findPseHoldersVByElementId(localFbpPseHoldersV);
    int i = localList.size();
    Object localObject = new ArrayList();
    int j = Integer.parseInt(paramString2);
    int k = Integer.parseInt(paramString3);
    k = k > 400 ? 400 : k;
    int m = j + k;
    m = m > i ? i : m;
    localObject = localList.subList(j, m);
    TableDataInfo localTableDataInfo = new TableDataInfo();
    localTableDataInfo.setData((List)localObject);
    localTableDataInfo.setTotalCount(i);
    return localTableDataInfo;
  }
  
  public String saveRelations(String paramString, List<FbpPseHoldersV> paramList)
  {
    return this.fbpPosStruElementsVDAO.saveRelations(paramString, paramList);
  }
  
  public String removePseHolders(String paramString)
  {
    this.fbpPseHoldersDAO.remove(Long.valueOf(Long.parseLong(paramString)));
    return null;
  }
  
  public String deletePseHolders(String paramString1, String paramString2, Long paramLong)
  {
    this.fbpPseHoldersDAO.remove(Long.valueOf(Long.parseLong(paramString1)));
    this.fbpPosStruElementsVDAO.delOldRelations(paramString2, paramLong, Long.valueOf(paramString1));
    return null;
  }
  
  public TableDataInfo getFbpEmployeesQryVByQry(FbpEmployeesQryV paramFbpEmployeesQryV, String paramString1, String paramString2)
  {
    Object localObject1 = new ArrayList();
    try
    {
      localObject1 = this.fbpEmployeesQryVDAO.getFbpEmployeesQryVs(paramFbpEmployeesQryV);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    int i = ((List)localObject1).size();
    Object localObject2 = new ArrayList();
    int j = Integer.parseInt(paramString1);
    int k = Integer.parseInt(paramString2);
    k = k > 400 ? 400 : k;
    int m = j + k;
    m = m > i ? i : m;
    localObject2 = ((List)localObject1).subList(j, m);
    TableDataInfo localTableDataInfo = new TableDataInfo();
    localTableDataInfo.setData((List)localObject2);
    localTableDataInfo.setTotalCount(i);
    return localTableDataInfo;
  }
  
  public IFbpPosStruElementsDAO getFbpPosStruElementsDAO()
  {
    return this.fbpPosStruElementsDAO;
  }
  
  public void setFbpPosStruElementsDAO(IFbpPosStruElementsDAO paramIFbpPosStruElementsDAO)
  {
    this.fbpPosStruElementsDAO = paramIFbpPosStruElementsDAO;
  }
  
  public IFbpPosStruElementsVDAO getFbpPosStruElementsVDAO()
  {
    return this.fbpPosStruElementsVDAO;
  }
  
  public void setFbpPosStruElementsVDAO(IFbpPosStruElementsVDAO paramIFbpPosStruElementsVDAO)
  {
    this.fbpPosStruElementsVDAO = paramIFbpPosStruElementsVDAO;
  }
  
  public IFbpPseHoldersDAO getFbpPseHoldersDAO()
  {
    return this.fbpPseHoldersDAO;
  }
  
  public void setFbpPseHoldersDAO(IFbpPseHoldersDAO paramIFbpPseHoldersDAO)
  {
    this.fbpPseHoldersDAO = paramIFbpPseHoldersDAO;
  }
  
  public IFbpPseHoldersVDAO getFbpPseHoldersVDAO()
  {
    return this.fbpPseHoldersVDAO;
  }
  
  public void setFbpPseHoldersVDAO(IFbpPseHoldersVDAO paramIFbpPseHoldersVDAO)
  {
    this.fbpPseHoldersVDAO = paramIFbpPseHoldersVDAO;
  }
  
  public IFbpEmployeesQryVDAO getFbpEmployeesQryVDAO()
  {
    return this.fbpEmployeesQryVDAO;
  }
  
  public void setFbpEmployeesQryVDAO(IFbpEmployeesQryVDAO paramIFbpEmployeesQryVDAO)
  {
    this.fbpEmployeesQryVDAO = paramIFbpEmployeesQryVDAO;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.flowruleengine.business.posstru.service.FbpPosStruElementsMgrDS
 * JD-Core Version:    0.7.0.1
 */