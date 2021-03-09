package com.zte.eimage.business.baseconfig.service;

import com.zte.eimage.business.baseconfig.model.CompanyInfo;
import com.zte.eimage.business.baseconfig.model.EidSites;
import com.zte.eimage.business.baseconfig.model.FrontUser;
import com.zte.eimage.business.baseconfig.model.FrontUserV;
import com.zte.eimage.business.baseconfig.model.OperationTypeInfo;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import java.util.List;

public abstract interface IFrontUserService
{
  public abstract void insertFrontUser(FrontUser paramFrontUser);
  
  public abstract FrontUserV findFrontUserById(Integer paramInteger);
  
  public abstract FrontUserV findFrontUserByEmpId(Integer paramInteger);
  
  public abstract EidSites findFrontUserByEid(Integer paramInteger);
  
  public abstract List findFrontUserByEmpIds(Integer paramInteger);
  
  public abstract void updateFrontUser(FrontUser paramFrontUser);
  
  public abstract TableDataInfo findFrontUser(FrontUserV paramFrontUserV, Integer paramInteger1, Integer paramInteger2);
  
  public abstract Integer isExistsEmployeeId(Integer paramInteger);
  
  public abstract String isExistsCompanyId(String paramString);
  
  public abstract CompanyInfo[] findCompanyInfos(Long paramLong, String paramString);
  
  public abstract OperationTypeInfo[] findOperationTypeInfos(Long paramLong, String paramString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.service.IFrontUserService
 * JD-Core Version:    0.7.0.1
 */