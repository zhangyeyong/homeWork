package com.zte.eas.appframe.access.wfFacade.dao;

import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.zorm.Session;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.apache.log4j.Logger;

public class WfFacadeDAO
  extends BaseDAO
  implements IWfFacadeDAO
{
  Logger log = Logger.getLogger(WfFacadeDAO.class);
  
  public String approve(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Session localSession = getSession();
    Connection localConnection = null;
    CallableStatement localCallableStatement = null;
    PreparedStatement localPreparedStatement = null;
    String str1 = new String();
    String str2 = "{call WFR_RULESENGINE_PKG.approve(?,?,?,?,?)}";
    String str3 = "SELECT wbs.current_status FROM wfr_bill_status wbs WHERE wbs.BOE_HEADER_ID = " + Integer.valueOf(paramString1);
    String str4 = new String();
    try
    {
      localConnection = localSession.connection();
      localConnection.setAutoCommit(false);
      localCallableStatement = localConnection.prepareCall(str2);
      localCallableStatement.setLong(1, new Long(paramString1).longValue());
      localCallableStatement.setString(2, paramString2);
      localCallableStatement.setString(3, paramString3);
      localCallableStatement.setString(4, paramString4);
      localCallableStatement.registerOutParameter(5, 12);
      localCallableStatement.execute();
      str1 = localCallableStatement.getString(5);
      localPreparedStatement = localConnection.prepareStatement(str3);
      ResultSet localResultSet = localPreparedStatement.executeQuery();
      if (localResultSet.next())
      {
        str4 = localResultSet.getString("current_status");
      }
      else
      {
        localConnection.rollback();
        throw new Exception("get bill status error!");
      }
      if (!str1.equals("SUCCESS")) {
        localConnection.rollback();
      }
      localResultSet.close();
      String str5 = str1;
      return str5;
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    finally
    {
      try
      {
        localCallableStatement.close();
        localPreparedStatement.close();
        localConnection.close();
        localSession.flush();
      }
      catch (Exception localException4)
      {
        localConnection = null;
      }
    }
    return str1;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.access.wfFacade.dao.WfFacadeDAO
 * JD-Core Version:    0.7.0.1
 */