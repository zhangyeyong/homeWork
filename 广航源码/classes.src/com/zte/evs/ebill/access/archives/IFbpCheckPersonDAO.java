package com.zte.evs.ebill.access.archives;

import com.zte.evs.ebill.model.archives.FbpCheckPerson;
import com.zte.evs.ebill.model.archives.FbpCheckPersonV;
import com.zte.ssb.framework.base.DAO;
import com.zte.ssb.framework.base.util.PageInfo;
import java.util.List;

public abstract interface IFbpCheckPersonDAO
  extends DAO
{
  public abstract PageInfo getFbpCheckPerson(FbpCheckPersonV paramFbpCheckPersonV, int paramInt1, int paramInt2);
  
  public abstract PageInfo fbpCheckPersonByQuery(int paramInt1, int paramInt2);
  
  public abstract FbpCheckPerson getFbpCheckPerson(Long paramLong);
  
  public abstract List<FbpCheckPerson> getFbpCheckPersons(int paramInt1, int paramInt2);
  
  public abstract List queryCheckPersonV(long paramLong);
  
  public abstract List<FbpCheckPerson> getFbpCheckPersons();
  
  public abstract void removeFbpCheckPerson(Long paramLong);
  
  public abstract void removeFbpCheckPerson(FbpCheckPerson paramFbpCheckPerson);
  
  public abstract void insertFbpCheckPerson(FbpCheckPerson paramFbpCheckPerson);
  
  public abstract PageInfo findFbpCheckPersonByQuery(FbpCheckPersonV paramFbpCheckPersonV, int paramInt1, int paramInt2);
  
  public abstract void updateFbpCheckPerson(FbpCheckPerson paramFbpCheckPerson);
  
  public abstract void insertFbpCheckPersons(List<FbpCheckPerson> paramList);
  
  public abstract void removeFbpCheckPersons(List<FbpCheckPerson> paramList);
  
  public abstract void updateFbpCheckPersons(List<FbpCheckPerson> paramList);
  
  public abstract FbpCheckPerson getFbpCheckPerson(String paramString1, String paramString2);
  
  public abstract void updateCheckPerson(FbpCheckPerson paramFbpCheckPerson);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.archives.IFbpCheckPersonDAO
 * JD-Core Version:    0.7.0.1
 */