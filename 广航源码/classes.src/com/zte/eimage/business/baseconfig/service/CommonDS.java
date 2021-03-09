package com.zte.eimage.business.baseconfig.service;

import com.zte.eas.getData.util.EisConsts;
import com.zte.eimage.access.baseconfig.dao.IEidImageInfosDAO;
import com.zte.eimage.business.baseconfig.model.IsExistsResponse;
import com.zte.eimage.business.baseconfig.model.UserInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.BaseDomainService;

public class CommonDS
  extends BaseDomainService
  implements ICommonDS
{
  IGetSpecialTimeSpans spans;
  IFtpInfos ftpInfo;
  IGetImageCounts imageCounts;
  IGetScanConfig scanConfig;
  IGetServCmdInfos cmdInfo;
  IIsExists isExist;
  IIsFinishByIDs isFinishById;
  IIsLogin isLogin;
  ILogin login;
  ILogout logout;
  IRealTimeAllows realTimeAllow;
  IRelativePaths relativePath;
  IEvsImageInfoDS imageInfo;
  ICurrentTime currentTime;
  
  public String GetSpecialTimeSpan(String paramString)
  {
    return getSpans().GetSpecialTimeSpan(paramString);
  }
  
  public String FtpInfo(String paramString1, String paramString2, int paramInt)
  {
    return getFtpInfo().FtpInfo(paramString1, paramString2, paramInt);
  }
  
  public int GetImageCount(String paramString1, String paramString2)
  {
    return getImageCounts().GetImageCount(paramString1, paramString2);
  }
  
  public String GetScanConfig(String paramString)
  {
    return getScanConfig().GetScanConfig(paramString);
  }
  
  public String GetServCmdInfo(String paramString1, String paramString2)
  {
    return getCmdInfo().GetServCmdInfo(paramString1, getLanguage(paramString2));
  }
  
  public String checkImageSeqNo(String paramString)
  {
    return getIsExist().getImageSeqNo(paramString);
  }
  
  public IsExistsResponse[] IsExist(String paramString1, String paramString2, String paramString3)
  {
    return getIsExist().IsExist(paramString1, paramString2, getLanguage(paramString3));
  }
  
  public String IsFinishByID(int paramInt)
  {
    return getIsFinishById().IsFinishByID(paramInt);
  }
  
  public boolean IsLogin(String paramString)
  {
    return getIsLogin().IsLogin(paramString);
  }
  
  public UserInfo Login(String paramString1, String paramString2, String paramString3)
  {
    return getLogin().Login(paramString1, paramString2, getLanguage(paramString3));
  }
  
  public void Logout(String paramString)
  {
    getLogout().Logout(paramString);
  }
  
  public boolean RealTimeAllow(String paramString1, String paramString2)
  {
    return getRealTimeAllow().RealTimeAllow(paramString1, paramString2);
  }
  
  public String RelativePath(String paramString1, String paramString2, int paramInt)
  {
    return getRelativePath().RelativePath(paramString1, paramString2, paramInt);
  }
  
  public int UploadLog(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, String paramString5, String paramString6, String paramString7)
  {
    return getImageInfo().UploadLog(paramString1, paramInt1, paramString2, paramString3, paramString4, paramInt2, paramString5, paramString6, getLanguage(paramString7));
  }
  
  public String CurrentTime(String paramString)
  {
    return getCurrentTime().CurrentTime(paramString);
  }
  
  private String getLanguage(String paramString)
  {
    if ((paramString != null) && (paramString.trim().length() > 0)) {
      for (Object localObject2 : EisConsts.LANGUAGE_LIST) {
        if (paramString.equals(localObject2)) {
          return paramString;
        }
      }
    }
    ??? = (IEidImageInfosDAO)SSBBus.findDaoService("eidImageInfosDAO");
    return ((IEidImageInfosDAO)???).getLanguage();
  }
  
  public IGetSpecialTimeSpans getSpans()
  {
    return (IGetSpecialTimeSpans)SSBBus.findDomainService("GetSpecialTimeSpan");
  }
  
  public IFtpInfos getFtpInfo()
  {
    return (IFtpInfos)SSBBus.findDomainService("ftpInfoDS");
  }
  
  public IGetImageCounts getImageCounts()
  {
    return (IGetImageCounts)SSBBus.findDomainService("GetImageCount");
  }
  
  public IGetScanConfig getScanConfig()
  {
    return (IGetScanConfig)SSBBus.findDomainService("GetScanConfig");
  }
  
  public IGetServCmdInfos getCmdInfo()
  {
    return (IGetServCmdInfos)SSBBus.findDomainService("GetServCmdInfo");
  }
  
  public IIsExists getIsExist()
  {
    return (IIsExists)SSBBus.findDomainService("IsExist");
  }
  
  public IIsFinishByIDs getIsFinishById()
  {
    return (IIsFinishByIDs)SSBBus.findCommonService("IsFinishByID");
  }
  
  public IIsLogin getIsLogin()
  {
    return (IIsLogin)SSBBus.findDomainService("IsLogin");
  }
  
  public ILogin getLogin()
  {
    return (ILogin)SSBBus.findDomainService("Login");
  }
  
  public ILogout getLogout()
  {
    return (ILogout)SSBBus.findDomainService("Logout");
  }
  
  public IRealTimeAllows getRealTimeAllow()
  {
    return (IRealTimeAllows)SSBBus.findDomainService("RealTimeAllow");
  }
  
  public IRelativePaths getRelativePath()
  {
    return (IRelativePaths)SSBBus.findDomainService("RelativePath");
  }
  
  public IEvsImageInfoDS getImageInfo()
  {
    return (IEvsImageInfoDS)SSBBus.findDomainService("imageInfo");
  }
  
  public ICurrentTime getCurrentTime()
  {
    return (ICurrentTime)SSBBus.findDomainService("currentTime");
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.service.CommonDS
 * JD-Core Version:    0.7.0.1
 */