package com.zte.eas.appframe.business.accessory.service;

import com.zte.eas.appframe.access.accessory.dao.IFbpAccessoriesDAO;
import com.zte.eas.appframe.access.accessory.dao.IFbpAccessoryPathsDAO;
import com.zte.eas.appframe.access.accessory.dao.IFbpAccessoryVDAO;
import com.zte.eas.appframe.business.accessory.model.AppFrameCon;
import com.zte.eas.appframe.business.accessory.model.FbpAccessories;
import com.zte.eas.appframe.business.accessory.model.FbpAccessoryPaths;
import com.zte.eas.appframe.business.accessory.model.FbpAccessoryV;
import com.zte.eas.appframe.business.util.ObjectCopyUtils;
import com.zte.eas.appframe.business.util.ParsePerportiesTool;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.BaseDomainService;
import com.zte.ssb.servicecontainer.business.server.RIAContext;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;

public class FbpAccessoriesDS
  extends BaseDomainService
  implements IFbpAccessoriesDS
{
  private IFbpAccessoriesDAO accessoriesDAO;
  private IFbpAccessoryPathsDAO accessoryPathsDAO;
  private IFbpAccessoryVDAO accessoryVDAO;
  static final int DATA_COUNT = 40;
  static final String ISUSER = "CURRENTLYTYPE";
  static final String ISUSER2 = "SCANTYPE";
  static final String currently = "一般附件";
  static final String scan = "扫描附件";
  
  public List<FbpAccessoryV> findAccessories(AppFrameCon paramAppFrameCon)
  {
    List localList = this.accessoryVDAO.findAccessories(paramAppFrameCon);
    ArrayList localArrayList = new ArrayList();
    if (localList.size() != 0) {
      for (int i = 0; i < localList.size(); i++)
      {
        FbpAccessoryV localFbpAccessoryV = (FbpAccessoryV)localList.get(i);
        int j = localFbpAccessoryV.getAccessorySize().intValue();
        if (j <= 0) {
          j = 1;
        }
        localFbpAccessoryV.setAccessorySize(new BigInteger(String.valueOf(j)));
        if ((localFbpAccessoryV.getAccessoryType() != null) && (localFbpAccessoryV.getAccessoryType().equalsIgnoreCase("CURRENTLYTYPE"))) {
          localFbpAccessoryV.setAccessoryType("一般附件");
        } else if ((localFbpAccessoryV.getAccessoryType() != null) && (localFbpAccessoryV.getAccessoryType().equalsIgnoreCase("SCANTYPE"))) {
          localFbpAccessoryV.setAccessoryType("扫描附件");
        }
        localArrayList.add(localFbpAccessoryV);
      }
    }
    return localArrayList;
  }
  
  public TableDataInfo findAccessories(AppFrameCon paramAppFrameCon, String paramString1, String paramString2)
  {
    List localList = findAccessories(paramAppFrameCon);
    int i = localList.size();
    Object localObject = new ArrayList();
    int j = Integer.parseInt(paramString1);
    int k = Integer.parseInt(paramString2);
    k = k > 40 ? 40 : k;
    int m = j + k;
    m = m > i ? i : m;
    localObject = localList.subList(j, m);
    TableDataInfo localTableDataInfo = new TableDataInfo();
    localTableDataInfo.setData((List)localObject);
    localTableDataInfo.setTotalCount(i);
    return localTableDataInfo;
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeAccessories(String paramString)
  {
    FbpAccessories localFbpAccessories = this.accessoriesDAO.getFbpAccessories(new BigInteger(paramString));
    FbpAccessoryPaths localFbpAccessoryPaths = this.accessoryPathsDAO.getFbpAccessoryPaths(localFbpAccessories.getAccessoryPathId());
    localFbpAccessories.setEnabledFlag("N");
    localFbpAccessoryPaths.setEnabledFlag("N");
    this.accessoriesDAO.updateFbpAccessories(localFbpAccessories);
    this.accessoryPathsDAO.updateFbpAccessoryPaths(localFbpAccessoryPaths);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpAccessories(AppFrameCon paramAppFrameCon) {}
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpAccessorie(String paramString)
  {
    FbpAccessories localFbpAccessories = this.accessoriesDAO.getFbpAccessories(new BigInteger(paramString));
    FbpAccessoryPaths localFbpAccessoryPaths = this.accessoryPathsDAO.getFbpAccessoryPaths(localFbpAccessories.getAccessoryPathId());
    this.accessoriesDAO.removeFbpAccessories(localFbpAccessories);
    this.accessoryPathsDAO.removeFbpAccessoryPaths(localFbpAccessoryPaths);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertFbpAccessories(FbpAccessories paramFbpAccessories, FbpAccessoryPaths paramFbpAccessoryPaths)
  {
    this.accessoryPathsDAO.insertFbpAccessoryPaths(paramFbpAccessoryPaths);
    paramFbpAccessories.setAccessoryPathId(paramFbpAccessoryPaths.getAccessoryPathId());
    this.accessoriesDAO.insertFbpAccessories(paramFbpAccessories);
  }
  
  public void insertFbpAccessories(FbpAccessoryV paramFbpAccessoryV)
  {
    FbpAccessories localFbpAccessories = new FbpAccessories();
    FbpAccessoryPaths localFbpAccessoryPaths = new FbpAccessoryPaths();
    ObjectCopyUtils.copy(paramFbpAccessoryV, localFbpAccessories);
    ObjectCopyUtils.copy(paramFbpAccessoryV, localFbpAccessoryPaths);
    ObjectCopyUtils.setWho(localFbpAccessories);
    ObjectCopyUtils.setWho(localFbpAccessoryPaths);
    localFbpAccessories.setAccessoryPathId(paramFbpAccessoryV.getRelationId());
    localFbpAccessoryPaths.setAccessoryPathId(paramFbpAccessoryV.getRelationId());
    insertFbpAccessories(localFbpAccessories, localFbpAccessoryPaths);
  }
  
  public void updateFbpAccessories(String paramString1, String paramString2) {}
  
  private ByteArrayOutputStream dowoLoadFile(String paramString)
    throws IOException
  {
    FileInputStream localFileInputStream = new FileInputStream(paramString);
    BufferedInputStream localBufferedInputStream = new BufferedInputStream(localFileInputStream);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(localByteArrayOutputStream);
    int i;
    while ((i = localBufferedInputStream.read()) != -1) {
      localBufferedOutputStream.write(i);
    }
    localBufferedOutputStream.flush();
    localBufferedInputStream.close();
    return localByteArrayOutputStream;
  }
  
  public String updateValue(String paramString1, String paramString2, String paramString3)
  {
    String str = null;
    try
    {
      FbpAccessories localFbpAccessories = this.accessoriesDAO.getFbpAccessories(new BigInteger(paramString1));
      if (localFbpAccessories != null)
      {
        localFbpAccessories.setAccessoryTitle(paramString2);
        localFbpAccessories.setMemo(paramString3);
        this.accessoriesDAO.updateFbpAccessories(localFbpAccessories);
        str = "success";
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      str = "fail";
    }
    return str;
  }
  
  public FbpAccessories uploadAccessoryPublic(FbpAccessoryV paramFbpAccessoryV)
  {
    String str1 = null;
    InputStream localInputStream = null;
    FileOutputStream localFileOutputStream = null;
    String str2 = (String)ParsePerportiesTool.ACCESSORYPATHS_MAP.get("boeTemplateAccessoryPath");
    localFbpAccessories = new FbpAccessories();
    FbpAccessoryPaths localFbpAccessoryPaths = new FbpAccessoryPaths();
    try
    {
      RIAContext localRIAContext = RIAContext.getCurrentInstance();
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
        String str6 = splitStringPath(localFileItem.getName());
        String str7 = str4;
        if (str5 != null) {
          str7 = str4 + "." + str5;
        }
        paramFbpAccessoryV.setAccessoryActualPath(str2);
        paramFbpAccessoryV.setAccessoryFileName(str7);
        paramFbpAccessoryV.setAccessoryOldFileName(str6);
        Long localLong2 = Long.valueOf(localFileItem.getSize());
        paramFbpAccessoryV.setAccessorySize(new BigInteger(localLong2.toString()));
        paramFbpAccessoryV.setEnabledFlag("Y");
        paramFbpAccessoryV.setExtendedName(str5);
        paramFbpAccessoryV.setAttribute9("true");
        if ((paramFbpAccessoryV.getAccessoryTitle() == null) || ("".equals(paramFbpAccessoryV.getAccessoryTitle()))) {
          paramFbpAccessoryV.setAccessoryTitle("test");
        }
        ObjectCopyUtils.copy(paramFbpAccessoryV, localFbpAccessories);
        ObjectCopyUtils.copy(paramFbpAccessoryV, localFbpAccessoryPaths);
        ObjectCopyUtils.setWho(localFbpAccessories);
        ObjectCopyUtils.setWho(localFbpAccessoryPaths);
        insertFbpAccessories(localFbpAccessories, localFbpAccessoryPaths);
        localInputStream = localFileItem.getInputStream();
        localFileOutputStream = new FileOutputStream(str2 + File.separator + str7);
        int i = 0;
        while ((i = localInputStream.read(arrayOfByte, 0, 1024)) != -1) {
          localFileOutputStream.write(arrayOfByte, 0, i);
        }
      }
      str1 = "success";
      return localFbpAccessories;
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
  
  private String splitString(String paramString1, String paramString2)
  {
    int i = paramString1.lastIndexOf(paramString2);
    return paramString1.substring(i + 1);
  }
  
  private String splitStringPath(String paramString)
  {
    paramString = paramString.replace("/", "\\");
    int i = paramString.lastIndexOf("\\");
    return paramString.substring(i + 1);
  }
  
  public IFbpAccessoriesDAO getAccessoriesDAO()
  {
    return this.accessoriesDAO;
  }
  
  public void setAccessoriesDAO(IFbpAccessoriesDAO paramIFbpAccessoriesDAO)
  {
    this.accessoriesDAO = paramIFbpAccessoriesDAO;
  }
  
  public IFbpAccessoryPathsDAO getAccessoryPathsDAO()
  {
    return this.accessoryPathsDAO;
  }
  
  public void setAccessoryPathsDAO(IFbpAccessoryPathsDAO paramIFbpAccessoryPathsDAO)
  {
    this.accessoryPathsDAO = paramIFbpAccessoryPathsDAO;
  }
  
  public IFbpAccessoryVDAO getAccessoryVDAO()
  {
    return this.accessoryVDAO;
  }
  
  public void setAccessoryVDAO(IFbpAccessoryVDAO paramIFbpAccessoryVDAO)
  {
    this.accessoryVDAO = paramIFbpAccessoryVDAO;
  }
  
  public void updateFbpAccessoriess(AppFrameCon paramAppFrameCon)
  {
    List localList = this.accessoriesDAO.getFbpAccessoriesByBudgetHeaderId(paramAppFrameCon);
    if ((localList == null) || (localList.size() < 1)) {
      return;
    }
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      FbpAccessories localFbpAccessories = (FbpAccessories)localIterator.next();
      localFbpAccessories.setAttribute9("");
    }
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.business.accessory.service.FbpAccessoriesDS
 * JD-Core Version:    0.7.0.1
 */