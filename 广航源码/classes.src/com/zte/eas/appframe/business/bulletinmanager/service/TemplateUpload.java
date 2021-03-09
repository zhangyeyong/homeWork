package com.zte.eas.appframe.business.bulletinmanager.service;

import com.zte.eas.appframe.business.accessory.model.AppFrameCon;
import com.zte.eas.appframe.business.accessory.model.FbpAccessories;
import com.zte.eas.appframe.business.accessory.model.FbpAccessoryPaths;
import com.zte.eas.appframe.business.accessory.model.FbpAccessoryV;
import com.zte.eas.appframe.business.accessory.service.IFbpAccessoriesDS;
import com.zte.eas.appframe.business.util.ObjectCopyUtils;
import com.zte.eas.appframe.business.util.ParsePerportiesTool;
import com.zte.ssb.framework.base.BaseDomainService;
import com.zte.ssb.servicecontainer.business.server.ISession;
import com.zte.ssb.servicecontainer.business.server.RIAContext;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;

public class TemplateUpload
  extends BaseDomainService
  implements ITemplateUpload
{
  private IFbpAccessoriesDS accessoriesDS;
  
  public String uploadTemplate(FbpAccessoryV paramFbpAccessoryV)
  {
    str1 = "success";
    InputStream localInputStream = null;
    FileOutputStream localFileOutputStream = null;
    String str2 = (String)ParsePerportiesTool.ACCESSORYPATHS_MAP.get("importTemplateAccessoryPath");
    try
    {
      RIAContext localRIAContext = RIAContext.getCurrentInstance();
      ISession localISession = localRIAContext.getSession();
      List localList = (List)localRIAContext.getRequest().getAttribute("FileItemList");
      Iterator localIterator = localList.iterator();
      FileItem localFileItem = null;
      localInputStream = null;
      while (localIterator.hasNext())
      {
        Long localLong1 = Long.valueOf(new Random().nextLong());
        String str3 = localLong1.toString().substring(2, 5);
        String str4 = new Date().getTime() + str3;
        byte[] arrayOfByte = new byte[1024];
        localFileItem = (FileItem)localIterator.next();
        String str5 = splitString(localFileItem.getName(), ".");
        String str6 = splitString(localFileItem.getName(), File.separator);
        String str7 = str4;
        if (str5 != null) {
          str7 = str4 + "." + str5;
        }
        paramFbpAccessoryV.setAccessoryActualPath(str2);
        paramFbpAccessoryV.setAccessoryFileName(str7);
        paramFbpAccessoryV.setAccessoryOldFileName(str6);
        Long localLong2 = Long.valueOf(localFileItem.getSize());
        paramFbpAccessoryV.setAccessorySize(new BigInteger(localLong2.toString()));
        paramFbpAccessoryV.setAccessoryType("dataTemplate");
        paramFbpAccessoryV.setEnabledFlag("Y");
        paramFbpAccessoryV.setExtendedName(str5);
        paramFbpAccessoryV.setRelationId(new BigInteger("0"));
        if (localLong2.longValue() == 0L) {
          str1 = "fail";
        } else {
          localISession.setSessionAttribute("accessoryV", paramFbpAccessoryV);
        }
        localInputStream = localFileItem.getInputStream();
        localFileOutputStream = new FileOutputStream(str2 + File.separator + str7);
        int i = 0;
        while ((i = localInputStream.read(arrayOfByte, 0, 1024)) != -1) {
          localFileOutputStream.write(arrayOfByte, 0, i);
        }
      }
      if ((str1 != null) && (!str1.equals("fail"))) {
        str1 = "success";
      }
      return str1;
    }
    catch (Exception localException3)
    {
      localException3.printStackTrace();
      str1 = "fail";
    }
    finally
    {
      if (localInputStream != null) {
        try
        {
          localInputStream.close();
          localInputStream = null;
        }
        catch (Exception localException6) {}
      }
      if (localFileOutputStream != null) {
        try
        {
          localFileOutputStream.close();
          localFileOutputStream = null;
        }
        catch (Exception localException7) {}
      }
    }
  }
  
  public String saveTemplate(FbpAccessoryV paramFbpAccessoryV)
  {
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    ISession localISession = localRIAContext.getSession();
    FbpAccessoryV localFbpAccessoryV = (FbpAccessoryV)localISession.getSessionAttribute("accessoryV");
    if (localFbpAccessoryV == null) {
      return "noAccessory";
    }
    localFbpAccessoryV.setAccessoryTitle(paramFbpAccessoryV.getAccessoryTitle());
    AppFrameCon localAppFrameCon = new AppFrameCon();
    localAppFrameCon.setAccessoryTitle(paramFbpAccessoryV.getAccessoryTitle());
    localAppFrameCon.setAccessoryType("dataTemplate");
    List localList = this.accessoriesDS.findAccessories(localAppFrameCon);
    if (localList.size() > 0) {
      return "fail";
    }
    FbpAccessories localFbpAccessories = new FbpAccessories();
    FbpAccessoryPaths localFbpAccessoryPaths = new FbpAccessoryPaths();
    ObjectCopyUtils.copy(localFbpAccessoryV, localFbpAccessories);
    ObjectCopyUtils.copy(localFbpAccessoryV, localFbpAccessoryPaths);
    ObjectCopyUtils.setWho(localFbpAccessories);
    ObjectCopyUtils.setWho(localFbpAccessoryPaths);
    localFbpAccessories.setAccessoryTitle(paramFbpAccessoryV.getAccessoryTitle());
    this.accessoriesDS.insertFbpAccessories(localFbpAccessories, localFbpAccessoryPaths);
    localISession.removeSessionAttribute("accessoryV");
    return "success";
  }
  
  private String splitString(String paramString1, String paramString2)
  {
    int i = paramString1.lastIndexOf(paramString2);
    return paramString1.substring(i + 1);
  }
  
  public IFbpAccessoriesDS getAccessoriesDS()
  {
    return this.accessoriesDS;
  }
  
  public void setAccessoriesDS(IFbpAccessoriesDS paramIFbpAccessoriesDS)
  {
    this.accessoriesDS = paramIFbpAccessoriesDS;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.business.bulletinmanager.service.TemplateUpload
 * JD-Core Version:    0.7.0.1
 */