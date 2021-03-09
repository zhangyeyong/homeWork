package com.zte.eas.appframe.access.synrequest.dao;

import com.zte.eas.appframe.business.synrequest.model.FbpSynchRequests;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.zorm.Session;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FbpSynchRequestsDAO
  extends BaseDAO
  implements IFbpSynchRequestsDAO
{
  public void insert(FbpSynchRequests paramFbpSynchRequests)
  {
    super.insertObject(paramFbpSynchRequests);
  }
  
  public void update(FbpSynchRequests paramFbpSynchRequests)
  {
    super.updateObject(paramFbpSynchRequests);
  }
  
  public void syncAttachment()
  {
    Session localSession = getSession();
    Connection localConnection = null;
    CallableStatement localCallableStatement = null;
    Object localObject1 = null;
    String str = "{call EIS_DATA_SYNC_IMAGE_PKG.SYNC_ATTACHMENT()}";
    try
    {
      localConnection = localSession.connection();
      localConnection.setAutoCommit(false);
      localCallableStatement = localConnection.prepareCall(str);
      localCallableStatement.execute();
      return;
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
    finally
    {
      try
      {
        localCallableStatement.close();
        localObject1.close();
        localConnection.close();
        localSession.flush();
      }
      catch (Exception localException4)
      {
        localConnection = null;
      }
    }
  }
  
  public synchronized boolean syncVoucher(java.util.Date paramDate)
  {
    java.sql.Date localDate = null;
    if (paramDate == null)
    {
      localObject1 = new SimpleDateFormat("yyyy-MM-dd");
      try
      {
        paramDate = ((SimpleDateFormat)localObject1).parse("1900-01-01");
      }
      catch (ParseException localParseException)
      {
        localParseException.printStackTrace();
      }
    }
    localDate = new java.sql.Date(paramDate.getTime());
    Object localObject1 = getSession();
    Connection localConnection = null;
    CallableStatement localCallableStatement = null;
    Object localObject2 = null;
    String str = "{call eis_data_sync_image_pkg.SYNC_VOUCHER(?)}";
    try
    {
      localConnection = ((Session)localObject1).connection();
      localConnection.setAutoCommit(false);
      localCallableStatement = localConnection.prepareCall(str);
      localCallableStatement.setDate(1, localDate);
      localCallableStatement.execute();
      boolean bool1 = Boolean.TRUE.booleanValue();
      return bool1;
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
      boolean bool2 = Boolean.FALSE.booleanValue();
      return bool2;
    }
    finally
    {
      try
      {
        if (localObject2 != null) {
          localObject2.close();
        }
        if (localCallableStatement != null) {
          localCallableStatement.close();
        }
        if (localConnection != null)
        {
          localConnection.commit();
          localConnection.close();
        }
        ((Session)localObject1).flush();
      }
      catch (Exception localException4)
      {
        localConnection = null;
      }
    }
  }
  
  public synchronized boolean syncImage()
  {
    Session localSession = getSession();
    Connection localConnection = null;
    CallableStatement localCallableStatement = null;
    Object localObject1 = null;
    String str = "{call eis_data_sync_image_pkg.eid_evs_image}";
    try
    {
      localConnection = localSession.connection();
      localConnection.setAutoCommit(false);
      localCallableStatement = localConnection.prepareCall(str);
      localCallableStatement.execute();
      boolean bool1 = Boolean.TRUE.booleanValue();
      return bool1;
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
      boolean bool2 = Boolean.FALSE.booleanValue();
      return bool2;
    }
    finally
    {
      try
      {
        if (localObject1 != null) {
          localObject1.close();
        }
        if (localCallableStatement != null) {
          localCallableStatement.close();
        }
        if (localConnection != null) {
          localConnection.close();
        }
        localSession.flush();
      }
      catch (Exception localException4)
      {
        localConnection = null;
      }
    }
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.access.synrequest.dao.FbpSynchRequestsDAO
 * JD-Core Version:    0.7.0.1
 */