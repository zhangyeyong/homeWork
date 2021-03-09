package com.zte.evs.ebill.access.eBillManage;

import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.zorm.Session;
import java.sql.CallableStatement;
import java.sql.Connection;

public class GenerateNumberDAO
  extends BaseDAO
  implements IGenerateNumberDAO
{
  public String generateNumber(GenerateNumberModel paramGenerateNumberModel)
  {
    str = "";
    Session localSession = getSession();
    Connection localConnection = localSession.connection();
    CallableStatement localCallableStatement = null;
    try
    {
      localCallableStatement = localConnection.prepareCall("{call EVS_GENERATION_NUMBER_PKG.get_generation_number(?,?,?,?,?,?,?,?,?)}");
      localCallableStatement.setString(1, paramGenerateNumberModel.getCompanyCode());
      localCallableStatement.setString(2, paramGenerateNumberModel.getDeptCode());
      localCallableStatement.setString(3, paramGenerateNumberModel.getDocType());
      localCallableStatement.setString(4, paramGenerateNumberModel.getSubDocType());
      localCallableStatement.setString(5, paramGenerateNumberModel.getPeriodName());
      localCallableStatement.setString(6, paramGenerateNumberModel.getNumberType());
      localCallableStatement.setString(7, paramGenerateNumberModel.getDepotFold());
      localCallableStatement.setString(8, paramGenerateNumberModel.getDepotMove());
      localCallableStatement.registerOutParameter(9, 12);
      localCallableStatement.execute();
      str = localCallableStatement.getString(9);
      localCallableStatement.close();
      localConnection.close();
      return str;
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
    finally
    {
      try
      {
        if (localCallableStatement != null)
        {
          localCallableStatement.close();
          localCallableStatement = null;
        }
        if (localConnection != null)
        {
          localConnection.close();
          localConnection = null;
        }
      }
      catch (Exception localException4)
      {
        localException4.printStackTrace();
      }
    }
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.eBillManage.GenerateNumberDAO
 * JD-Core Version:    0.7.0.1
 */