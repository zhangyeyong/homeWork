package com.zte.ssb;

import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.ssbext.lang.LangUtil;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp.BasicDataSource;

public class EasDataSource
  extends BasicDataSource
{
  static final String ZH = "zh";
  static final String EN = "en";
  static final String TH = "th";
  static final String JA = "ja";
  
  public Connection getConnection()
    throws SQLException
  {
    localConnection = super.getConnection();
    CallableStatement localCallableStatement = null;
    String str1 = "ZHS";
    try
    {
      String str2 = LangUtil.getLocale();
      if ("zh".equals(str2)) {
        str1 = "ZHS";
      } else if ("en".equals(str2)) {
        str1 = "US";
      } else if ("th".equals(str2)) {
        str1 = "TH";
      } else if ("ja".equals(str2)) {
        str1 = "JA";
      }
    }
    catch (Exception localException1) {}
    try
    {
      String str3 = "{call ZAS_ENV_PKG.setLang('" + str1 + "')}";
      localCallableStatement = localConnection.prepareCall(str3);
      localCallableStatement.execute();
      return localConnection;
    }
    catch (SQLException localSQLException2)
    {
      SSBBus.getLog("com.zte.ssb.EasDataSource").error("EasDataSource.getConnection:", localSQLException2);
      try
      {
        if (localConnection != null) {
          localConnection.close();
        }
      }
      catch (Exception localException2)
      {
        SSBBus.getLog("com.zte.ssb.EasDataSource").error("EasDataSource.getConnection:", localSQLException2);
      }
      localConnection = null;
    }
    finally
    {
      try
      {
        if (localCallableStatement != null) {
          localCallableStatement.close();
        }
      }
      catch (SQLException localSQLException4)
      {
        SSBBus.getLog("com.zte.ssb.EasDataSource").error("EasDataSource.getConnection:", localSQLException4);
      }
    }
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.ssb.EasDataSource
 * JD-Core Version:    0.7.0.1
 */