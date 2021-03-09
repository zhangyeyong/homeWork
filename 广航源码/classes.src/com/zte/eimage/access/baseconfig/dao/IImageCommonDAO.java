package com.zte.eimage.access.baseconfig.dao;

import com.zte.ssb.framework.base.DAO;
import com.zte.ssb.framework.base.util.PageInfo;
import java.util.List;
import java.util.Map;

public abstract interface IImageCommonDAO
  extends DAO
{
  public abstract List<Object> findObjectBySQL(String paramString, List paramList, Class paramClass);
  
  public abstract Object findObject(String paramString, List paramList, Class paramClass);
  
  public abstract List<Object[]> findObjectBySQL(String paramString, List paramList);
  
  public abstract void executeSql(String paramString, List paramList);
  
  public abstract Map<String, Object> pageObjectBySql(String paramString, List paramList, Class paramClass, int paramInt1, int paramInt2);
  
  public abstract PageInfo pageInfoObjectBySql(String paramString, List paramList, Class paramClass, int paramInt1, int paramInt2);
  
  public abstract String[] getClobToString(String paramString, List paramList, int paramInt);
  
  public abstract String callMergeBoeSrv(String paramString1, String[] paramArrayOfString, String paramString2, String paramString3, String paramString4);
  
  public abstract List<String> getDetailBoeNumber(String paramString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.access.baseconfig.dao.IImageCommonDAO
 * JD-Core Version:    0.7.0.1
 */