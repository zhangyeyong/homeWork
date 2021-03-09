package com.zte.evs.ebill.business.archives;

import com.zte.evs.ebill.model.archives.FbpCheckPerson;
import com.zte.evs.ebill.model.archives.FbpCheckPersonV;
import com.zte.evs.ebill.model.eBillManage.EvsSubDocType;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.DomainService;
import java.util.List;

public abstract interface IFbpCheckPersonDS
  extends DomainService
{
  public abstract List<FbpCheckPersonV> getFbpCheckPersonV(Long paramLong);
  
  public abstract TableDataInfo getFbpCheckPerson(FbpCheckPersonV paramFbpCheckPersonV, int paramInt1, int paramInt2);
  
  public abstract String addFbpCheckPerson(FbpCheckPerson paramFbpCheckPerson);
  
  public abstract TableDataInfo fbpCheckPersonByQuery(EvsSubDocType paramEvsSubDocType, int paramInt1, int paramInt2);
  
  public abstract FbpCheckPerson getFbpCheckPerson(Long paramLong);
  
  public abstract List<FbpCheckPerson> getFbpCheckPersons(int paramInt1, int paramInt2);
  
  public abstract List<FbpCheckPerson> getFbpCheckPersons();
  
  public abstract String findVoucherCheckConfigIsExists(List<FbpCheckPerson> paramList);
  
  public abstract String addFbpCheckPersons(List<FbpCheckPerson> paramList);
  
  public abstract TableDataInfo findFbpCheckPersonByQuery(FbpCheckPersonV paramFbpCheckPersonV, int paramInt1, int paramInt2);
  
  public abstract void removeFbpCheckPerson(Long paramLong);
  
  public abstract void removeFbpCheckPerson(FbpCheckPerson paramFbpCheckPerson);
  
  public abstract void insertFbpCheckPerson(FbpCheckPerson paramFbpCheckPerson);
  
  public abstract void insertFbpCheckPersons(List<FbpCheckPerson> paramList);
  
  public abstract void removeFbpCheckPersons(List<FbpCheckPerson> paramList);
  
  public abstract String updateFbpCheckPersons(List<FbpCheckPersonV> paramList);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.archives.IFbpCheckPersonDS
 * JD-Core Version:    0.7.0.1
 */