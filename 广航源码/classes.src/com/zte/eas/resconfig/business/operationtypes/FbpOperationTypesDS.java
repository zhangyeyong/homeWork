package com.zte.eas.resconfig.business.operationtypes;

import com.zte.eas.appframe.business.util.ObjectCopyUtils;
import com.zte.eas.resconfig.access.operationtypes.IFbpOperationTypesDAO;
import com.zte.eas.resconfig.access.operationtypes.IFbpOperationTypesTlDAO;
import com.zte.eas.resconfig.access.operationtypes.model.FbpOperationTypesTl;
import com.zte.eas.resconfig.access.operationtypes.model.FbpOperationTypesV;
import com.zte.eimage.business.baseconfig.model.FbpOperationTypes;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.BaseDomainService;
import com.zte.ssb.framework.base.util.PageInfo;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang.StringUtils;

public class FbpOperationTypesDS
  extends BaseDomainService
  implements IFbpOperationTypesDS
{
  private IFbpOperationTypesDAO fbpOperationTypesDAO;
  private IFbpOperationTypesTlDAO fbpOperationTypesTlDAO;
  static final String LANGUAGE_US = "US";
  static final String LANGUAGE_ZHS = "ZHS";
  
  public void setFbpOperationTypesDAO(IFbpOperationTypesDAO paramIFbpOperationTypesDAO)
  {
    this.fbpOperationTypesDAO = paramIFbpOperationTypesDAO;
  }
  
  public void setFbpOperationTypesTlDAO(IFbpOperationTypesTlDAO paramIFbpOperationTypesTlDAO)
  {
    this.fbpOperationTypesTlDAO = paramIFbpOperationTypesTlDAO;
  }
  
  public TableDataInfo findOperationTypes(FbpOperationTypes paramFbpOperationTypes, int paramInt1, int paramInt2)
  {
    PageInfo localPageInfo = this.fbpOperationTypesDAO.findOperationTypes(paramFbpOperationTypes, paramInt1, paramInt2);
    List localList = (List)localPageInfo.getResult();
    TableDataInfo localTableDataInfo = new TableDataInfo();
    localTableDataInfo.setData((List)localPageInfo.getResult());
    localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
    return localTableDataInfo;
  }
  
  public FbpOperationTypesV findOperationTypeV(String paramString)
  {
    if (StringUtils.isNotEmpty(paramString)) {
      return this.fbpOperationTypesDAO.findOperationTypeV(Long.valueOf(paramString));
    }
    return new FbpOperationTypesV();
  }
  
  public Integer existsOperationTypesCode(String paramString)
  {
    return this.fbpOperationTypesDAO.existsOperationTypesCode(paramString);
  }
  
  public FbpOperationTypesV createOperationType(FbpOperationTypesV paramFbpOperationTypesV)
  {
    FbpOperationTypes localFbpOperationTypes = null;
    FbpOperationTypesTl localFbpOperationTypesTl1 = null;
    FbpOperationTypesTl localFbpOperationTypesTl2 = null;
    Long localLong = paramFbpOperationTypesV.getOperationTypeId();
    localFbpOperationTypes = new FbpOperationTypes();
    ObjectCopyUtils.setWho(localFbpOperationTypes);
    localFbpOperationTypesTl1 = new FbpOperationTypesTl();
    localFbpOperationTypesTl1.setLastUpdateDate(localFbpOperationTypes.getLastUpdateDate());
    localFbpOperationTypesTl1.setLastUpdatedBy(localFbpOperationTypes.getLastUpdatedBy());
    localFbpOperationTypesTl1.setCreationDate(localFbpOperationTypes.getCreationDate());
    localFbpOperationTypesTl1.setCreatedBy(localFbpOperationTypes.getCreatedBy());
    localFbpOperationTypesTl1.setLastUpdateLogin(localFbpOperationTypes.getLastUpdateLogin());
    localFbpOperationTypes.setAttribute1(paramFbpOperationTypesV.getAttribute1());
    localFbpOperationTypes.setAttribute2(paramFbpOperationTypesV.getAttribute2());
    localFbpOperationTypes.setAttribute3(paramFbpOperationTypesV.getAttribute3());
    localFbpOperationTypes.setEnabledFlag(paramFbpOperationTypesV.getEnabledFlag());
    localFbpOperationTypes.setOperationTypeCode(paramFbpOperationTypesV.getOperationTypeCode());
    localFbpOperationTypesTl1.setOperationTypeName(paramFbpOperationTypesV.getOperationTypeName());
    this.fbpOperationTypesDAO.createOperationType(localFbpOperationTypes);
    localLong = localFbpOperationTypes.getOperationTypeId();
    localFbpOperationTypesTl1.setOperationTypeId(localLong);
    localFbpOperationTypesTl2 = localFbpOperationTypesTl1.clone();
    localFbpOperationTypesTl1.setLanguage("US");
    localFbpOperationTypesTl1.setSourceLang("US");
    localFbpOperationTypesTl2.setOperationTypeId(localLong);
    localFbpOperationTypesTl2.setLanguage("ZHS");
    localFbpOperationTypesTl2.setSourceLang("ZHS");
    this.fbpOperationTypesTlDAO.insertFbpOperationTypesTl(localFbpOperationTypesTl1);
    this.fbpOperationTypesTlDAO.insertFbpOperationTypesTl(localFbpOperationTypesTl2);
    FbpOperationTypesV localFbpOperationTypesV = this.fbpOperationTypesDAO.findOperationTypeV(Long.valueOf(localLong.longValue()));
    return localFbpOperationTypesV;
  }
  
  public Integer modifyOperationType(FbpOperationTypesV paramFbpOperationTypesV)
  {
    FbpOperationTypes localFbpOperationTypes = null;
    List localList = null;
    Long localLong = paramFbpOperationTypesV.getOperationTypeId();
    if (null == localLong) {
      return Integer.valueOf(0);
    }
    localFbpOperationTypes = this.fbpOperationTypesDAO.findFbpOperationTypes(localLong);
    localList = this.fbpOperationTypesTlDAO.findFbpOperationTypesTls(localLong);
    localFbpOperationTypes.setAttribute1(paramFbpOperationTypesV.getAttribute1());
    localFbpOperationTypes.setAttribute2(paramFbpOperationTypesV.getAttribute2());
    localFbpOperationTypes.setAttribute3(paramFbpOperationTypesV.getAttribute3());
    localFbpOperationTypes.setEnabledFlag(paramFbpOperationTypesV.getEnabledFlag());
    localFbpOperationTypes.setOperationTypeCode(paramFbpOperationTypesV.getOperationTypeCode());
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      FbpOperationTypesTl localFbpOperationTypesTl = (FbpOperationTypesTl)localIterator.next();
      localFbpOperationTypesTl.setOperationTypeName(paramFbpOperationTypesV.getOperationTypeName());
    }
    this.fbpOperationTypesDAO.modifyOperationType(localFbpOperationTypes);
    this.fbpOperationTypesTlDAO.updateFbpOperationTypesTls(localList);
    return Integer.valueOf(1);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.resconfig.business.operationtypes.FbpOperationTypesDS
 * JD-Core Version:    0.7.0.1
 */