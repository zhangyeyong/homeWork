package com.zte.eas.wsf.ssc;

import com.zte.eas.login.EASLogin.EASLoginProxy;
import com.zte.eas.login.EASLogin.EASLoginProxyServiceLocator;
import com.zte.eas.login.EASLogin.WSContext;
import com.zte.eas.organization.business.countcompanymanage.model.FbpCompanyV;
import com.zte.ssb.AccessPropertiesFile;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.rpc.ServiceException;
import org.apache.axis.utils.StringUtils;
import org.apache.log4j.Logger;

public class SynBalanceCompany
{
  Logger logger = Logger.getLogger(getClass());
  private String userName = AccessPropertiesFile.getValue("WSFSSC_userName");
  private String password = AccessPropertiesFile.getValue("WSFSSC_password");
  private String slnName = AccessPropertiesFile.getValue("WSFSSC_slnName");
  private String dcName = AccessPropertiesFile.getValue("WSFSSC_dcName");
  private String language = AccessPropertiesFile.getValue("WSFSSC_language");
  private String dbType = AccessPropertiesFile.getValue("WSFSSC_dbType");
  
  public List<FbpCompanyV> getFinCompany(String paramString1, String paramString2)
    throws RemoteException
  {
    ArrayList localArrayList = new ArrayList();
    EASLoginProxyServiceLocator localEASLoginProxyServiceLocator = new EASLoginProxyServiceLocator();
    EASLoginProxy localEASLoginProxy = null;
    try
    {
      int i = 2;
      if (!StringUtils.isEmpty(this.dbType)) {
        i = Integer.valueOf(this.dbType).intValue();
      }
      localEASLoginProxy = localEASLoginProxyServiceLocator.getEASLogin();
      WSContext localWSContext = localEASLoginProxy.login(this.userName, this.password, this.slnName, this.dcName, this.language, i);
      if (localWSContext != null)
      {
        WSFSSCWebSericeFacadeSrvProxyServiceLocator localWSFSSCWebSericeFacadeSrvProxyServiceLocator = new WSFSSCWebSericeFacadeSrvProxyServiceLocator();
        WSFSSCWebSericeFacadeSrvProxy localWSFSSCWebSericeFacadeSrvProxy = localWSFSSCWebSericeFacadeSrvProxyServiceLocator.getWSFSSCWebSericeFacade();
        String[][] arrayOfString = localWSFSSCWebSericeFacadeSrvProxy.getFinCompany(paramString1, paramString2);
        if (arrayOfString != null) {
          for (int j = 0; j < arrayOfString.length; j++)
          {
            String[] arrayOfString1 = arrayOfString[j];
            String str1 = arrayOfString1[0];
            String str2 = arrayOfString1[1];
            String str3 = "0".equals(arrayOfString1[2]) ? "Y" : "N";
            String str4 = arrayOfString1[3];
            String str5 = arrayOfString1[4];
            String str6 = arrayOfString1[5];
            FbpCompanyV localFbpCompanyV = new FbpCompanyV();
            localFbpCompanyV.setCompanyCode(str1);
            localFbpCompanyV.setEnabledFlag(str3);
            localFbpCompanyV.setCompany(str2);
            localFbpCompanyV.setCompanyName(str2);
            localFbpCompanyV.setSuperCompanyName(str6);
            localFbpCompanyV.setSetOfBooksCode(str4);
            localFbpCompanyV.setSetOfBooksName(str5);
            localArrayList.add(localFbpCompanyV);
          }
        }
      }
    }
    catch (ServiceException localServiceException)
    {
      this.logger.error(localServiceException.getMessage(), localServiceException);
    }
    return localArrayList;
  }
  
  public Logger getLogger()
  {
    return this.logger;
  }
  
  public void setLogger(Logger paramLogger)
  {
    this.logger = paramLogger;
  }
  
  public String getUserName()
  {
    return this.userName;
  }
  
  public void setUserName(String paramString)
  {
    this.userName = paramString;
  }
  
  public String getPassword()
  {
    return this.password;
  }
  
  public void setPassword(String paramString)
  {
    this.password = paramString;
  }
  
  public String getSlnName()
  {
    return this.slnName;
  }
  
  public void setSlnName(String paramString)
  {
    this.slnName = paramString;
  }
  
  public String getDcName()
  {
    return this.dcName;
  }
  
  public void setDcName(String paramString)
  {
    this.dcName = paramString;
  }
  
  public String getLanguage()
  {
    return this.language;
  }
  
  public void setLanguage(String paramString)
  {
    this.language = paramString;
  }
  
  public String getDbType()
  {
    return this.dbType;
  }
  
  public void setDbType(String paramString)
  {
    this.dbType = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.wsf.ssc.SynBalanceCompany
 * JD-Core Version:    0.7.0.1
 */