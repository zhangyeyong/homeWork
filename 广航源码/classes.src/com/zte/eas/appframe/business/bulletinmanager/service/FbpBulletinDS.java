package com.zte.eas.appframe.business.bulletinmanager.service;

import com.zte.eas.appframe.access.bulletinmanager.dao.IFbpBulletinsDAO;
import com.zte.eas.appframe.access.bulletinmanager.dao.IFbpBulletinsDeptDAO;
import com.zte.eas.appframe.access.bulletinmanager.dao.IFbpBulletinsVDAO;
import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.eas.appframe.access.syscommon.dao.IFbpEmployeesLoginVDAO;
import com.zte.eas.appframe.business.accessory.model.AppFrameCon;
import com.zte.eas.appframe.business.accessory.model.FbpAccessoryV;
import com.zte.eas.appframe.business.accessory.service.IFbpAccessoriesDS;
import com.zte.eas.appframe.business.bulletinmanager.model.FbpBulletins;
import com.zte.eas.appframe.business.bulletinmanager.model.FbpBulletinsDept;
import com.zte.eas.appframe.business.bulletinmanager.model.FbpBulletinsV;
import com.zte.eas.appframe.business.syscommon.model.FbpEmployeesLoginV;
import com.zte.eas.appframe.business.util.ObjectCopyUtils;
import com.zte.eas.appframe.business.util.ParsePerportiesTool;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.BaseDomainService;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.servicecontainer.business.server.ISession;
import com.zte.ssb.servicecontainer.business.server.RIAContext;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.lang.StringUtils;

public class FbpBulletinDS
  extends BaseDomainService
  implements IFbpBulletinDS
{
  private IFbpBulletinsVDAO fbpBulletinsVDAO;
  private IFbpBulletinsDAO fbpBulletinsDAO;
  private IFbpEmployeesLoginVDAO fbpEmployeesLoginVDAO;
  private IFbpBulletinsDeptDAO fbpBulletinsDeptDAO;
  static final String LOGIN_USERINFO = "loginuserinfo";
  static final String EASLOGIN_USERINFO = "easloginuserinfo";
  static final String DELSUCESS = "delsuess";
  static final String DELFAILD = "delfaild";
  static final String UPLOADFILESUCESS = "uploadsucess";
  static final String UPLOADFILEFAILD = "uploadfaild";
  static final String FILEDBIG = "filebig";
  static final String SAVESUCCESS = "savesuccess";
  static final String SAVEFAILD = "savefaild";
  static final String DELETESUCESS = "deletesucess";
  private IFbpAccessoriesDS accessoriesDS = null;
  private String fileSize = null;
  private String fileNames = null;
  List sessionList = new ArrayList();
  Log log = SSBBus.getLog(getClass());
  
  public FbpBulletinsV findFbpBulletinsVById(String paramString)
  {
    FbpBulletinsV localFbpBulletinsV = this.fbpBulletinsVDAO.findFbpBulletinsVById(Long.valueOf(Long.parseLong(paramString)));
    if ((localFbpBulletinsV.getIsRollFlag() != null) && (localFbpBulletinsV.getIsRollFlag().equals("Y"))) {
      localFbpBulletinsV.setIsRollFlag(localFbpBulletinsV.getEnabledFlagMeaning());
    } else {
      localFbpBulletinsV.setIsRollFlag(localFbpBulletinsV.getEnabledFlagMeaning());
    }
    SimpleDateFormat localSimpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat localSimpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
    localFbpBulletinsV.setAttribute1(localSimpleDateFormat2.format(localFbpBulletinsV.getStartDateActive()));
    localFbpBulletinsV.setAttribute2(localSimpleDateFormat2.format(localFbpBulletinsV.getEndDateActive()));
    localFbpBulletinsV.setAttribute3(localSimpleDateFormat1.format(localFbpBulletinsV.getCreationDate()));
    return localFbpBulletinsV;
  }
  
  public TableDataInfo findFbpBulletinsVByCon(FbpBulletinsV paramFbpBulletinsV, String paramString1, String paramString2)
  {
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    ISession localISession = localRIAContext.getSession();
    EasUserInfo localEasUserInfo = (EasUserInfo)localISession.getSessionAttribute("easloginuserinfo");
    FbpEmployeesLoginV localFbpEmployeesLoginV = new FbpEmployeesLoginV();
    localFbpEmployeesLoginV = this.fbpEmployeesLoginVDAO.findEmployeeByUserId(localEasUserInfo.getUserId());
    String str1 = this.fbpBulletinsVDAO.findDeptId(Long.valueOf(localFbpEmployeesLoginV.getDeptId().toString()));
    if (StringUtils.isBlank(str1)) {
      str1 = "-1";
    }
    paramFbpBulletinsV.setAttribute2(str1);
    localISession.removeSessionAttribute("boeTemplateAcc");
    PageInfo localPageInfo = this.fbpBulletinsVDAO.findFbpBulletinsVByCon(paramFbpBulletinsV, new Integer(paramString1).intValue(), new Integer(paramString2).intValue());
    List localList = (List)localPageInfo.getResult();
    for (int i = 0; i < localList.size(); i++)
    {
      FbpBulletinsV localFbpBulletinsV = (FbpBulletinsV)localList.get(i);
      String str2 = localFbpBulletinsV.getBulletinTitle();
      if (str2.length() > 25) {
        str2 = str2.substring(0, 24) + ".....";
      }
      localFbpBulletinsV.setBulletinTitle(str2);
      localFbpBulletinsV.setCreatedById(localFbpEmployeesLoginV.getEmployeeId().toString());
    }
    TableDataInfo localTableDataInfo = new TableDataInfo();
    localTableDataInfo.setData((List)localPageInfo.getResult());
    localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
    return localTableDataInfo;
  }
  
  public TableDataInfo findFbpBulletinsVByCons(FbpBulletinsV paramFbpBulletinsV, String paramString1, String paramString2)
  {
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    ISession localISession = localRIAContext.getSession();
    EasUserInfo localEasUserInfo = (EasUserInfo)localISession.getSessionAttribute("easloginuserinfo");
    FbpEmployeesLoginV localFbpEmployeesLoginV = new FbpEmployeesLoginV();
    localFbpEmployeesLoginV = this.fbpEmployeesLoginVDAO.findEmployeeByUserId(localEasUserInfo.getUserId());
    String str = this.fbpBulletinsVDAO.findDeptId(Long.valueOf(localFbpEmployeesLoginV.getDeptId().toString()));
    paramFbpBulletinsV.setAttribute2(str);
    paramFbpBulletinsV.setAttribute10(localFbpEmployeesLoginV.getEmployeeId().toString());
    localISession.removeSessionAttribute("boeTemplateAcc");
    PageInfo localPageInfo = this.fbpBulletinsVDAO.findFbpBulletinsVByCons(paramFbpBulletinsV, new Integer(paramString1).intValue(), new Integer(paramString2).intValue());
    List localList = (List)localPageInfo.getResult();
    for (int i = 0; i < localList.size(); i++)
    {
      FbpBulletinsV localFbpBulletinsV = (FbpBulletinsV)localList.get(i);
      localFbpBulletinsV.setCreatedById(localFbpEmployeesLoginV.getEmployeeId().toString());
    }
    TableDataInfo localTableDataInfo = new TableDataInfo();
    localTableDataInfo.setData((List)localPageInfo.getResult());
    localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
    return localTableDataInfo;
  }
  
  public FbpEmployeesLoginV findEmployees()
  {
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    ISession localISession = localRIAContext.getSession();
    EasUserInfo localEasUserInfo = (EasUserInfo)localISession.getSessionAttribute("easloginuserinfo");
    FbpEmployeesLoginV localFbpEmployeesLoginV = new FbpEmployeesLoginV();
    localFbpEmployeesLoginV = this.fbpEmployeesLoginVDAO.findEmployeeByUserId(localEasUserInfo.getUserId());
    return localFbpEmployeesLoginV;
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public String saveFbpBulletin(FbpBulletinsV paramFbpBulletinsV)
  {
    FbpBulletins localFbpBulletins = new FbpBulletins();
    FbpAccessoryV localFbpAccessoryV = new FbpAccessoryV();
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    ISession localISession = localRIAContext.getSession();
    EasUserInfo localEasUserInfo = (EasUserInfo)localISession.getSessionAttribute("easloginuserinfo");
    localFbpBulletins.setCreatedBy(Long.valueOf(localEasUserInfo.getUserInfoPk().longValue()));
    localFbpBulletins.setCreationDate(new Date());
    localFbpBulletins.setLastUpdateDate(new Date());
    localFbpBulletins.setLastUpdatedBy(Long.valueOf(localEasUserInfo.getUserInfoPk().longValue()));
    localFbpBulletins.setLastUpdateLogin(Long.valueOf(localEasUserInfo.getUserInfoPk().longValue()));
    localFbpBulletins.setEnabledFlag("Y");
    localFbpBulletins.setStartDateActive(paramFbpBulletinsV.getStartDateActive());
    localFbpBulletins.setEndDateActive(paramFbpBulletinsV.getEndDateActive());
    localFbpBulletins.setDocument(paramFbpBulletinsV.getDocument());
    localFbpBulletins.setEmployeeName(paramFbpBulletinsV.getBulletinsEmployeeName());
    localFbpBulletins.setExtentId(paramFbpBulletinsV.getExtentId());
    localFbpBulletins.setExtentName(paramFbpBulletinsV.getExtentName());
    localFbpBulletins.setDeptLongName(paramFbpBulletinsV.getDeptLongName());
    localFbpBulletins.setIsRollFlag(paramFbpBulletinsV.getIsRollFlag());
    localFbpBulletins.setBulletinCatagoryCode(paramFbpBulletinsV.getBulletinCatagoryCode());
    localFbpBulletins.setBulletinContent(paramFbpBulletinsV.getBulletinContent());
    localFbpBulletins.setBulletinTitle(paramFbpBulletinsV.getBulletinTitle());
    try
    {
      this.fbpBulletinsDAO.insertFbpBulletins(localFbpBulletins);
      String str = paramFbpBulletinsV.getExtentIds();
      String[] arrayOfString = str.split(",");
      if (arrayOfString.length > 0)
      {
        for (int i = 0; i < arrayOfString.length; i++)
        {
          FbpBulletinsDept localFbpBulletinsDept = new FbpBulletinsDept();
          ObjectCopyUtils.setWho(localFbpBulletinsDept);
          localFbpBulletinsDept.setBulletinId(localFbpBulletins.getBulletinId());
          localFbpBulletinsDept.setAttribute1(arrayOfString[i]);
          localFbpBulletinsDept.setEnabledFlag("Y");
          this.fbpBulletinsDeptDAO.insertFbpBulletinsDept(localFbpBulletinsDept);
        }
      }
      else
      {
        localObject = new FbpBulletinsDept();
        ObjectCopyUtils.setWho(localObject);
        ((FbpBulletinsDept)localObject).setBulletinId(localFbpBulletins.getBulletinId());
        ((FbpBulletinsDept)localObject).setAttribute1(str);
        ((FbpBulletinsDept)localObject).setEnabledFlag("Y");
        this.fbpBulletinsDeptDAO.insertFbpBulletinsDept((FbpBulletinsDept)localObject);
      }
      Object localObject = new ArrayList();
      localObject = (List)localISession.getSessionAttribute("boeTemplateAcc");
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        for (int j = 0; j < ((List)localObject).size(); j++)
        {
          localFbpAccessoryV = (FbpAccessoryV)((List)localObject).get(j);
          localFbpAccessoryV.setRelationId(BigInteger.valueOf(localFbpBulletins.getBulletinId().longValue()));
          localFbpAccessoryV.setEmployeeId(localEasUserInfo.getUserInfoPk());
          localFbpAccessoryV.setAccessoryActualPath(localFbpAccessoryV.getAccessoryActualPath());
          this.accessoriesDS = ((IFbpAccessoriesDS)SSBBus.findCommonService("accessoriesDS"));
          this.accessoriesDS.insertFbpAccessories(localFbpAccessoryV);
        }
      }
      localISession.removeSessionAttribute("boeTemplateAcc");
      return "savesuccess";
    }
    catch (Exception localException)
    {
      this.log.error(localException.getMessage(), localException);
    }
    return "savefaild";
  }
  
  public String uploadfile(FbpBulletinsV paramFbpBulletinsV)
  {
    Object localObject1 = null;
    InputStream localInputStream = null;
    FileOutputStream localFileOutputStream = null;
    Object localObject2 = null;
    String str1 = (String)ParsePerportiesTool.ACCESSORYPATHS_MAP.get("accessoriesPath");
    FbpAccessoryV localFbpAccessoryV = new FbpAccessoryV();
    String str2 = null;
    try
    {
      RIAContext localRIAContext = RIAContext.getCurrentInstance();
      localObject3 = localRIAContext.getSession();
      EasUserInfo localEasUserInfo = (EasUserInfo)((ISession)localObject3).getSessionAttribute("easloginuserinfo");
      List localList = (List)localRIAContext.getRequest().getAttribute("FileItemList");
      Iterator localIterator = localList.iterator();
      FileItem localFileItem = null;
      localInputStream = null;
      while (localIterator.hasNext())
      {
        localObject4 = Long.valueOf(new Random().nextLong());
        String str3 = ((Long)localObject4).toString().substring(2, 5);
        String str4 = new Date().getTime() + str3;
        byte[] arrayOfByte = new byte[1024];
        localFileItem = (FileItem)localIterator.next();
        String str5 = splitString(localFileItem.getName(), ".");
        String str6 = splitString(localFileItem.getName(), "\\");
        String str7 = str4;
        if (str5 != null) {
          str7 = str4 + "." + str5;
        }
        localFbpAccessoryV.setAccessoryActualPath(str1);
        localFbpAccessoryV.setAccessoryFileName(str7);
        localFbpAccessoryV.setAccessoryOldFileName(str6);
        Long localLong = Long.valueOf(localFileItem.getSize());
        String str8 = localLong.toString();
        if (localLong.longValue() == 0L) {
          str2 = "uploadfaild";
        }
        int i = localLong.intValue() / 1024;
        if (i <= 0) {
          i = 1;
        }
        localFbpAccessoryV.setEmployeeName(localEasUserInfo.getUserName());
        localFbpAccessoryV.setCreationDate(new Date());
        localFbpAccessoryV.setAccessorySize(new BigInteger(String.valueOf(i)));
        localFbpAccessoryV.setAttribute10(localFbpAccessoryV.getAccessorySize().toString() + "KB");
        localFbpAccessoryV.setAccessoryTitle(str6);
        localFbpAccessoryV.setAccessoryType("bulletin");
        localFbpAccessoryV.setEnabledFlag("Y");
        localFbpAccessoryV.setExtendedName(str5);
        localFbpAccessoryV.setRelationId(new BigInteger("0"));
        localInputStream = localFileItem.getInputStream();
        localFileOutputStream = new FileOutputStream(str1 + File.separator + str7);
        int j = 0;
        while ((j = localInputStream.read(arrayOfByte, 0, 1024)) != -1) {
          localFileOutputStream.write(arrayOfByte, 0, j);
        }
      }
      if ((str2 != null) && (str2.length() > 0))
      {
        localObject4 = str2;
        return localObject4;
      }
      if ((((ISession)localObject3).getSessionAttribute("boeTemplateAcc") != null) && (((List)((ISession)localObject3).getSessionAttribute("boeTemplateAcc")).size() > 0))
      {
        localObject2 = (List)((ISession)localObject3).getSessionAttribute("boeTemplateAcc");
        ((List)localObject2).add(localFbpAccessoryV);
      }
      else
      {
        localObject2 = new ArrayList();
        ((List)localObject2).add(localFbpAccessoryV);
        if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
          ((ISession)localObject3).setSessionAttribute("boeTemplateAcc", localObject2);
        }
      }
      Object localObject4 = "uploadsucess";
      return localObject4;
    }
    catch (Exception localException1)
    {
      this.log.error(localException1.getMessage(), localException1);
      Object localObject3 = "uploadfaild";
      return localObject3;
    }
    finally
    {
      if (localInputStream != null) {
        try
        {
          localInputStream.close();
          localInputStream = null;
        }
        catch (Exception localException8)
        {
          this.log.error(localException8.getMessage(), localException8);
        }
      }
      if (localFileOutputStream != null) {
        try
        {
          localFileOutputStream.close();
          localFileOutputStream = null;
        }
        catch (Exception localException9)
        {
          this.log.error(localException9.getMessage(), localException9);
        }
      }
    }
  }
  
  public String downloadTemplet(String paramString)
  {
    String str = "";
    AppFrameCon localAppFrameCon = new AppFrameCon();
    localAppFrameCon.setRelationId(new BigInteger(paramString));
    List localList = this.accessoriesDS.findAccessories(localAppFrameCon);
    if (localList.size() > 0)
    {
      FbpAccessoryV localFbpAccessoryV = (FbpAccessoryV)localList.get(0);
      this.accessoriesDS = ((IFbpAccessoriesDS)SSBBus.findCommonService("accessoriesDS"));
    }
    return str;
  }
  
  public List sessionList()
  {
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    ISession localISession = localRIAContext.getSession();
    List localList = null;
    localList = (List)localISession.getSessionAttribute("boeTemplateAcc");
    if ((localList != null) && (localList.size() > 0)) {
      localList.get(0);
    }
    return localList;
  }
  
  public String deleteSession(String paramString)
  {
    String str = null;
    List localList = null;
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    ISession localISession = localRIAContext.getSession();
    if ((localISession.getSessionAttribute("boeTemplateAcc") != null) && (((List)localISession.getSessionAttribute("boeTemplateAcc")).size() > 0))
    {
      localList = (List)localISession.getSessionAttribute("boeTemplateAcc");
      for (int i = localList.size(); i > 0; i--)
      {
        FbpAccessoryV localFbpAccessoryV = (FbpAccessoryV)localList.get(i - 1);
        if (localFbpAccessoryV.getAccessoryFileName().equals(paramString))
        {
          localList.remove(i - 1);
          str = "deletesucess";
        }
      }
    }
    return str;
  }
  
  public List<FbpAccessoryV> getFbpAccessories(String paramString)
  {
    this.accessoriesDS = ((IFbpAccessoriesDS)SSBBus.findCommonService("accessoriesDS"));
    AppFrameCon localAppFrameCon = new AppFrameCon();
    localAppFrameCon.setRelationId(BigInteger.valueOf(Long.valueOf(paramString).longValue()));
    List localList = this.accessoriesDS.findAccessories(localAppFrameCon);
    return localList;
  }
  
  private String splitString(String paramString1, String paramString2)
  {
    int i = paramString1.lastIndexOf(paramString2);
    return paramString1.substring(i + 1);
  }
  
  public String removeFbpBulletinById(String paramString)
  {
    FbpBulletins localFbpBulletins = this.fbpBulletinsDAO.findById(paramString);
    try
    {
      this.fbpBulletinsDAO.removeFbpBulletins(localFbpBulletins);
      return "delsuess";
    }
    catch (Exception localException)
    {
      this.log.error(localException.getMessage(), localException);
    }
    return "delfaild";
  }
  
  public IFbpBulletinsVDAO getFbpBulletinsVDAO()
  {
    return this.fbpBulletinsVDAO;
  }
  
  public void setFbpBulletinsVDAO(IFbpBulletinsVDAO paramIFbpBulletinsVDAO)
  {
    this.fbpBulletinsVDAO = paramIFbpBulletinsVDAO;
  }
  
  public IFbpBulletinsDAO getFbpBulletinsDAO()
  {
    return this.fbpBulletinsDAO;
  }
  
  public void setFbpBulletinsDAO(IFbpBulletinsDAO paramIFbpBulletinsDAO)
  {
    this.fbpBulletinsDAO = paramIFbpBulletinsDAO;
  }
  
  public IFbpEmployeesLoginVDAO getFbpEmployeesLoginVDAO()
  {
    return this.fbpEmployeesLoginVDAO;
  }
  
  public void setFbpEmployeesLoginVDAO(IFbpEmployeesLoginVDAO paramIFbpEmployeesLoginVDAO)
  {
    this.fbpEmployeesLoginVDAO = paramIFbpEmployeesLoginVDAO;
  }
  
  public IFbpBulletinsDeptDAO getFbpBulletinsDeptDAO()
  {
    return this.fbpBulletinsDeptDAO;
  }
  
  public void setFbpBulletinsDeptDAO(IFbpBulletinsDeptDAO paramIFbpBulletinsDeptDAO)
  {
    this.fbpBulletinsDeptDAO = paramIFbpBulletinsDeptDAO;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.business.bulletinmanager.service.FbpBulletinDS
 * JD-Core Version:    0.7.0.1
 */