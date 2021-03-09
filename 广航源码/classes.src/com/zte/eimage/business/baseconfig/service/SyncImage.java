package com.zte.eimage.business.baseconfig.service;

import com.zte.eimage.business.baseconfig.model.IsExistsResponse;
import com.zte.eimage.business.baseconfig.model.UserInfo;
import com.zte.ssb.framework.SSBBus;
import org.apache.log4j.Logger;

public class SyncImage
{
  private ICommonDS commonDs = (ICommonDS)SSBBus.findDomainService("commonDS");
  Logger logger = Logger.getLogger(getClass());
  
  public String GetSpecialTimeSpan(String paramString)
  {
    return this.commonDs.GetSpecialTimeSpan(paramString);
  }
  
  public String getImageSeqNo(String paramString)
  {
    return this.commonDs.checkImageSeqNo(paramString);
  }
  
  public String FtpInfo(String paramString1, String paramString2, int paramInt)
  {
    return this.commonDs.FtpInfo(paramString1, paramString2, paramInt);
  }
  
  public int GetImageCount(String paramString1, String paramString2)
  {
    return this.commonDs.GetImageCount(paramString1, paramString2);
  }
  
  public String GetScanConfig(String paramString)
  {
    return this.commonDs.GetScanConfig(paramString);
  }
  
  public String GetServCmdInfo(String paramString1, String paramString2)
  {
    return this.commonDs.GetServCmdInfo(paramString1, paramString2);
  }
  
  public IsExistsResponse[] IsExist(String paramString1, String paramString2, String paramString3)
  {
    return this.commonDs.IsExist(paramString1, paramString2, paramString3);
  }
  
  public String IsFinishByID(int paramInt)
  {
    return this.commonDs.IsFinishByID(paramInt);
  }
  
  public boolean IsLogin(String paramString)
  {
    return this.commonDs.IsLogin(paramString);
  }
  
  public UserInfo Login(String paramString1, String paramString2, String paramString3)
  {
    return this.commonDs.Login(paramString1, paramString2, paramString3);
  }
  
  public void Logout(String paramString)
  {
    this.commonDs.Logout(paramString);
  }
  
  public boolean RealTimeAllow(String paramString1, String paramString2)
  {
    return this.commonDs.RealTimeAllow(paramString1, paramString2);
  }
  
  public String RelativePath(String paramString1, String paramString2, int paramInt)
  {
    return this.commonDs.RelativePath(paramString1, paramString2, paramInt);
  }
  
  public int UploadLog(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, String paramString5, String paramString6, String paramString7)
  {
    try
    {
      return this.commonDs.UploadLog(paramString1, paramInt1, paramString2, paramString3, paramString4, paramInt2, paramString5, paramString6, paramString7);
    }
    catch (Exception localException)
    {
      this.logger.error("上传影像失败：" + localException.getMessage(), localException);
    }
    return 1;
  }
  
  public String CurrentTime(String paramString)
  {
    return this.commonDs.CurrentTime(paramString);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.service.SyncImage
 * JD-Core Version:    0.7.0.1
 */