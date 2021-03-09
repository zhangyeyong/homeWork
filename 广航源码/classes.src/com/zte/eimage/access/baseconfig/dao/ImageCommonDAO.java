package com.zte.eimage.access.baseconfig.dao;

import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.zorm.SQLQuery;
import com.zte.ssb.zorm.Session;
import java.io.BufferedReader;
import java.io.Reader;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import org.apache.commons.logging.Log;

public class ImageCommonDAO
  extends BaseDAO
  implements IImageCommonDAO
{
  public static final String PAGE_COUNT = "PAGE_COUNT";
  public static final String DATA_COUNT = "DATA_COUNT";
  public static final String DATA = "DATA";
  
  public List<Object> findObjectBySQL(String paramString, List paramList, Class paramClass)
  {
    SQLQuery localSQLQuery = super.getSession().createSQLQuery(paramString);
    if ((paramList != null) && (!paramList.isEmpty())) {
      for (int i = 0; i < paramList.size(); i++) {
        localSQLQuery.setParameter(i, paramList.get(i));
      }
    }
    if (paramClass != null) {
      localSQLQuery.addEntity(paramClass);
    }
    return localSQLQuery.list();
  }
  
  public Object findObject(String paramString, List paramList, Class paramClass)
  {
    SQLQuery localSQLQuery = super.getSession().createSQLQuery(paramString);
    if ((paramList != null) && (!paramList.isEmpty())) {
      for (int i = 0; i < paramList.size(); i++) {
        localSQLQuery.setParameter(i, paramList.get(i));
      }
    }
    if (paramClass != null) {
      localSQLQuery.addEntity(paramClass);
    }
    List localList = localSQLQuery.list();
    if ((localList != null) && (!localList.isEmpty())) {
      return localList.get(0);
    }
    return null;
  }
  
  public List<Object[]> findObjectBySQL(String paramString, List paramList)
  {
    SQLQuery localSQLQuery = super.getSession().createSQLQuery(paramString);
    if ((paramList != null) && (!paramList.isEmpty())) {
      for (int i = 0; i < paramList.size(); i++) {
        localSQLQuery.setParameter(i, paramList.get(i));
      }
    }
    return localSQLQuery.list();
  }
  
  public void executeSql(String paramString, List paramList)
  {
    SQLQuery localSQLQuery = super.getSession().createSQLQuery(paramString);
    if ((paramList != null) && (!paramList.isEmpty())) {
      for (int i = 0; i < paramList.size(); i++) {
        localSQLQuery.setParameter(i, paramList.get(i));
      }
    }
    localSQLQuery.executeUpdate();
  }
  
  public Map<String, Object> pageObjectBySql(String paramString, List paramList, Class paramClass, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PAGE_COUNT", Integer.valueOf(0));
    localHashMap.put("DATA_COUNT", Integer.valueOf(0));
    localHashMap.put("DATA", new ArrayList());
    if ((paramInt1 < 1) || (paramInt2 < -1) || (paramString == null) || (paramString.trim().length() == 0)) {
      return localHashMap;
    }
    String str1 = "select count(*) t_count " + paramString.substring(paramString.toLowerCase().indexOf("from"));
    List localList1 = findObjectBySQL(str1, paramList, null);
    if ((localList1 == null) || (localList1.isEmpty())) {
      return localHashMap;
    }
    Object localObject = localList1.get(0);
    if ((localObject == null) || (Integer.valueOf(localObject.toString()).intValue() == 0)) {
      return localHashMap;
    }
    Integer localInteger1 = Integer.valueOf(localObject.toString());
    Integer localInteger2 = Integer.valueOf(0);
    if (paramInt2 < 1) {
      paramInt2 = localInteger1.intValue();
    }
    localInteger2 = Integer.valueOf(localInteger1.intValue() % paramInt2 == 0 ? localInteger1.intValue() / paramInt2 : localInteger1.intValue() / paramInt2 + 1);
    int i = (paramInt1 - 1) * paramInt2;
    int j = 0;
    if (paramInt1 < localInteger2.intValue()) {
      j = paramInt1 * paramInt2;
    } else {
      j = localInteger1.intValue();
    }
    String str2 = paramString;
    String str3 = new Date().getTime() + "";
    if (paramInt2 > 0)
    {
      paramString = "select t.*,rownum rn_" + str3 + " FROM (" + paramString + ") t where rownum <= ?";
      str2 = "select * FROM (" + paramString + ") where rn_" + str3 + " > ?";
      if (paramList == null) {
        paramList = new ArrayList();
      }
      paramList.add(Integer.valueOf(j));
      paramList.add(Integer.valueOf(i));
    }
    List localList2 = findObjectBySQL(str2, paramList, paramClass);
    localHashMap.put("PAGE_COUNT", localInteger2);
    localHashMap.put("DATA_COUNT", localInteger1);
    localHashMap.put("DATA", localList2);
    return localHashMap;
  }
  
  public PageInfo pageInfoObjectBySql(String paramString, List paramList, Class paramClass, int paramInt1, int paramInt2)
  {
    PageInfo localPageInfo = new PageInfo(PageInfo.getStartOfPageInfo(paramInt1 / paramInt2 + 1, paramInt2), 0L, paramInt2, new ArrayList());
    if ((paramInt1 < 1) || (paramInt2 < -1) || (paramString == null) || (paramString.trim().length() == 0)) {
      return localPageInfo;
    }
    String str1 = "select count(*) t_count " + paramString.substring(paramString.toLowerCase().indexOf("from"));
    List localList1 = findObjectBySQL(str1, paramList, null);
    if ((localList1 == null) || (localList1.isEmpty())) {
      return localPageInfo;
    }
    Object localObject = localList1.get(0);
    if ((localObject == null) || (Integer.valueOf(localObject.toString()).intValue() == 0)) {
      return localPageInfo;
    }
    Integer localInteger1 = Integer.valueOf(localObject.toString());
    Integer localInteger2 = Integer.valueOf(0);
    if (paramInt2 < 1) {
      paramInt2 = localInteger1.intValue();
    }
    localInteger2 = Integer.valueOf(localInteger1.intValue() % paramInt2 == 0 ? localInteger1.intValue() / paramInt2 : localInteger1.intValue() / paramInt2 + 1);
    int i = (paramInt1 - 1) * paramInt2;
    int j = 0;
    if (paramInt1 < localInteger2.intValue()) {
      j = paramInt1 * paramInt2;
    } else {
      j = localInteger1.intValue();
    }
    String str2 = paramString;
    String str3 = new Date().getTime() + "";
    if (paramInt2 > 0)
    {
      paramString = "select t.*,rownum rn_" + str3 + " FROM (" + paramString + ") t where rownum <= ?";
      str2 = "select * FROM (" + paramString + ") where rn_" + str3 + " > ?";
      if (paramList == null) {
        paramList = new ArrayList();
      }
      paramList.add(Integer.valueOf(j));
      paramList.add(Integer.valueOf(i));
    }
    List localList2 = findObjectBySQL(str2, paramList, paramClass);
    localList2 = localList2 == null ? new ArrayList() : localList2;
    localPageInfo = new PageInfo(PageInfo.getStartOfPageInfo(paramInt1 / paramInt2 + 1, paramInt2), localInteger1.intValue(), paramInt2, localList2);
    return localPageInfo;
  }
  
  public String[] getClobToString(String paramString, List paramList, int paramInt)
  {
    Connection localConnection = null;
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    localConnection = getSession().connection();
    try
    {
      localPreparedStatement = localConnection.prepareStatement(paramString.toString());
      if ((paramList != null) && (!paramList.isEmpty())) {
        for (int i = 0; i < paramList.size(); i++) {
          localPreparedStatement.setObject(i, paramList.get(i));
        }
      }
      localResultSet = localPreparedStatement.executeQuery();
      String[] arrayOfString1 = null;
      arrayOfString1 = new String[paramInt];
      while (localResultSet.next()) {
        for (int j = 0; j < arrayOfString1.length; j++)
        {
          Clob localClob = (Clob)localResultSet.getObject(j + 1);
          arrayOfString1[j] = ClobToString(localClob);
        }
      }
      String[] arrayOfString2 = arrayOfString1;
      return arrayOfString2;
    }
    catch (SQLException localSQLException)
    {
      localSQLException.printStackTrace();
    }
    finally
    {
      try
      {
        if (localResultSet != null) {
          localResultSet.close();
        }
        if (localPreparedStatement != null) {
          localPreparedStatement.close();
        }
        if (localConnection != null) {
          localConnection.close();
        }
      }
      catch (Exception localException3)
      {
        localException3.printStackTrace();
      }
    }
    return null;
  }
  
  private String ClobToString(Clob paramClob)
  {
    String str1 = "";
    try
    {
      Reader localReader = paramClob.getCharacterStream();
      BufferedReader localBufferedReader = new BufferedReader(localReader);
      String str2 = localBufferedReader.readLine();
      StringBuffer localStringBuffer = new StringBuffer();
      while (str2 != null)
      {
        localStringBuffer.append(str2);
        str2 = localBufferedReader.readLine();
      }
      str1 = localStringBuffer.toString();
    }
    catch (Exception localException)
    {
      this.logger.error("ImageCommonDAO.ClobToString exception:" + localException.getMessage(), localException);
    }
    return str1;
  }
  
  public String callMergeBoeSrv(String paramString1, String[] paramArrayOfString, String paramString2, String paramString3, String paramString4)
  {
    Connection localConnection = super.getSession().connection();
    CallableStatement localCallableStatement = null;
    str1 = null;
    try
    {
      String str2 = "{call eis_util_pkg.merge_boe_srv(?,?,?,?,?,?)}";
      ArrayDescriptor localArrayDescriptor = ArrayDescriptor.createDescriptor("TY_STR_TABLE", localConnection.getMetaData().getConnection());
      ARRAY localARRAY = new ARRAY(localArrayDescriptor, localConnection.getMetaData().getConnection(), paramArrayOfString);
      localCallableStatement = localConnection.prepareCall(str2);
      localCallableStatement.setString(1, paramString1);
      localCallableStatement.setArray(2, localARRAY);
      localCallableStatement.setString(3, paramString2.toUpperCase());
      localCallableStatement.setString(4, paramString3);
      localCallableStatement.setString(5, paramString4);
      localCallableStatement.registerOutParameter(6, 12);
      localCallableStatement.execute();
      str1 = localCallableStatement.getString(6);
      localConnection.commit();
      return str1;
    }
    catch (Exception localException2)
    {
      this.logger.error("执行时产生异常" + localException2.getMessage(), localException2);
      try
      {
        localConnection.rollback();
      }
      catch (SQLException localSQLException)
      {
        localSQLException.printStackTrace();
      }
    }
    finally
    {
      try
      {
        if (localCallableStatement != null) {
          localCallableStatement.close();
        }
        if (localConnection != null) {
          localConnection.close();
        }
      }
      catch (Exception localException4)
      {
        this.logger.error("关闭资源时产生异常" + localException4.getMessage(), localException4);
        localCallableStatement = null;
        localConnection = null;
      }
    }
  }
  
  public List<String> getDetailBoeNumber(String paramString)
  {
    String str = "select br.detailBoeNum from EvsBoeRelation br where br.enabledFlag = 'Y' and br.boeNum = ?";
    List localList = find(str, new Object[] { paramString });
    localList.add(0, paramString);
    return localList;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.access.baseconfig.dao.ImageCommonDAO
 * JD-Core Version:    0.7.0.1
 */