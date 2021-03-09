package com.zte.eas.bmsctrl.ws.syn.sieboeheader.ds;

import com.zte.eas.bmsctrl.ws.BOE_SC_CMS_00001.SynboeHeaderImageDS;
import com.zte.eas.bmsctrl.ws.BOE_SC_CMS_00001.SynboeHeaderImageDSServiceLocator;
import com.zte.eas.bmsctrl.ws.BOE_SC_CMS_00002.CreateImageRequest;
import com.zte.eas.bmsctrl.ws.BOE_SC_CMS_00002.CreateImageSrv;
import com.zte.eas.bmsctrl.ws.BOE_SC_CMS_00002.CreateImageSrvServiceLocator;
import com.zte.eas.bmsctrl.ws.BOE_SC_CMS_00002.ImageList;
import com.zte.eimage.business.common.service.IImageDisplayDS;
import com.zte.ssb.framework.SSBBus;
import java.io.PrintStream;
import java.util.List;
import org.apache.log4j.Logger;

public class SynBoeHeadeImgrDS
  implements ISynBoeHeadeImgrDS
{
  SynboeHeaderImageDSServiceLocator sd = new SynboeHeaderImageDSServiceLocator();
  SynboeHeaderImageDS ds;
  private Logger log = Logger.getLogger(getClass());
  
  public boolean createImg(String paramString1, String paramString2)
  {
    boolean bool = false;
    System.out.println("++++++++++++" + bool);
    try
    {
      this.ds = this.sd.getsynboeHeaderImageDS();
      bool = this.ds.createImage(paramString1, paramString2);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    System.out.println("++++++++++++" + bool);
    return bool;
  }
  
  public boolean createImg(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    CreateImageSrvServiceLocator localCreateImageSrvServiceLocator = new CreateImageSrvServiceLocator();
    String str1 = "N";
    this.log.error("---createImg创建影像服务 开始---" + str1);
    try
    {
      this.log.error("@@boeNum:" + paramString2);
      this.log.error("@@date:" + paramString3);
      CreateImageSrv localCreateImageSrv = localCreateImageSrvServiceLocator.getcreateImageSrv();
      CreateImageRequest localCreateImageRequest = new CreateImageRequest();
      ImageList localImageList = new ImageList();
      ImageList[] arrayOfImageList = new ImageList[1];
      localImageList.setBoeNum(paramString1);
      localImageList.setImageStatus(paramString5);
      localImageList.setScanNum(paramString2);
      localImageList.setUpdateBy(paramString4);
      IImageDisplayDS localIImageDisplayDS = (IImageDisplayDS)SSBBus.findDomainService("imageDisplayDS");
      String str2 = String.valueOf(localIImageDisplayDS.getImage(paramString2).size());
      localImageList.setScanCount(str2);
      this.log.error("@@ScanCount:" + str2);
      arrayOfImageList[0] = localImageList;
      localCreateImageRequest.setImageList(arrayOfImageList);
      str1 = localCreateImageSrv.createImage(localCreateImageRequest);
    }
    catch (Exception localException)
    {
      this.log.error("Exception:", localException);
      localException.printStackTrace();
    }
    this.log.error("---createImg创建影像服务 结束---" + str1);
    return str1.equals("Y");
  }
  
  public boolean deleteImg(String paramString)
  {
    boolean bool = false;
    try
    {
      this.ds = this.sd.getsynboeHeaderImageDS();
      bool = this.ds.deleteImage(paramString);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return bool;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.bmsctrl.ws.syn.sieboeheader.ds.SynBoeHeadeImgrDS
 * JD-Core Version:    0.7.0.1
 */