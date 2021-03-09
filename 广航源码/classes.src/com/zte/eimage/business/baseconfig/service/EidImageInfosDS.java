package com.zte.eimage.business.baseconfig.service;

import com.cmcc.mss.msgheader.MsgHeader;
import com.cmcc.mss.sb_eas_eas_importimageoperationinfosrv.ImportImageOperationInfoSrvInputCollection;
import com.cmcc.mss.sb_eas_eas_importimageoperationinfosrv.ImportImageOperationInfoSrvInputItem;
import com.cmcc.mss.sb_eas_eas_importimageoperationinfosrv.SBEASEASImportImageOperationInfoSrvRequest;
import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.eas.boe.image.syn.model.ds.ISynImageDS;
import com.zte.eas.getData.util.EisConsts;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesV;
import com.zte.eimage.access.baseconfig.dao.IEidAppraiseHistoriesDAO;
import com.zte.eimage.access.baseconfig.dao.IEidImageInfosDAO;
import com.zte.eimage.access.baseconfig.dao.IEidImagesDAO;
import com.zte.eimage.access.baseconfig.dao.IEidPatrolDAO;
import com.zte.eimage.access.baseconfig.dao.IImageCommonDAO;
import com.zte.eimage.business.baseconfig.model.EidAppraiseHistories;
import com.zte.eimage.business.baseconfig.model.EidAppraiseHistoryV;
import com.zte.eimage.business.baseconfig.model.EidApprovalImageInfosV;
import com.zte.eimage.business.baseconfig.model.EidImageInfos;
import com.zte.eimage.business.baseconfig.model.EidImageInfosV;
import com.zte.eimage.business.baseconfig.model.EidImages;
import com.zte.eimage.business.baseconfig.model.EidMyApprovalImageInfosV;
import com.zte.eimage.business.baseconfig.model.EidMyboeImageInfosV;
import com.zte.eimage.business.baseconfig.model.EidOrgeImageInfosV;
import com.zte.eimage.business.baseconfig.model.EidPatrol;
import com.zte.eimage.business.baseconfig.util.EidObjectUtils;
import com.zte.evs.ebill.model.eBillManage.SpecialAttachmentV;
import com.zte.ssb.AccessPropertiesFile;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.util.Util;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import com.zte.web.service.client.createImage.client.CreateImageRequest;
import com.zte.web.service.client.createImage.client.ImageList;
import com.zte.web.service.client.createImage.ds.CreateImageSrv;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.apache.axis.utils.StringUtils;

public class EidImageInfosDS
  implements IEidImageInfosDS
{
  private IEidImageInfosDAO imageInfosDAO;
  private IEidAppraiseHistoriesDAO appraiseHistoriesDAO;
  private IEidImagesDAO imagesDAO;
  private IEidPatrolDAO patrolDAO;
  
  public EidImageInfos findEidImageInfoByImageNumber(String paramString)
  {
    return this.imageInfosDAO.findEidImageInfoByImageNumber(paramString);
  }
  
  public TableDataInfo queryImageInfosV(EidImageInfosV paramEidImageInfosV, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    try
    {
      PageInfo localPageInfo = this.imageInfosDAO.findImageInfosVByQry(paramEidImageInfosV, paramInt1, paramInt2, "IMAGE_QUERY");
      localTableDataInfo.setData((List)localPageInfo.getResult());
      localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
      return localTableDataInfo;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localTableDataInfo;
  }
  
  public TableDataInfo appraiseImageInfosV(EidImageInfosV paramEidImageInfosV, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    try
    {
      PageInfo localPageInfo = this.imageInfosDAO.findImageInfosVByQry(paramEidImageInfosV, paramInt1, paramInt2, "IMAGE_APPRAISE");
      localTableDataInfo.setData((List)localPageInfo.getResult());
      localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
      return localTableDataInfo;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localTableDataInfo;
  }
  
  public String checkDataContran(List<String> paramList)
  {
    String str1 = "fail";
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < paramList.size(); i++)
    {
      String str3 = ((String)paramList.get(i)).toString();
      if (localArrayList.size() == 0)
      {
        localArrayList.add(str3);
      }
      else if (localArrayList.contains(str3))
      {
        localArrayList.add(str3);
      }
      else
      {
        str1 = "fail";
        return str1;
      }
    }
    if (localArrayList.size() > 0)
    {
      String str2 = ((String)localArrayList.get(0)).substring(((String)localArrayList.get(0)).length() - 2, ((String)localArrayList.get(0)).length());
      if ((str2.equals("U8")) || (str2.equals("NC"))) {
        str1 = "U8NC";
      } else {
        str1 = "other";
      }
    }
    return str1;
  }
  
  public TableDataInfo patrolImageInfosV(EidAppraiseHistoryV paramEidAppraiseHistoryV, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    try
    {
      PageInfo localPageInfo = this.appraiseHistoriesDAO.findAppraiseHistoriesVLByQry(paramEidAppraiseHistoryV, paramInt1, paramInt2, "IMAGE_PATROL");
      localTableDataInfo.setData((List)localPageInfo.getResult());
      localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
      return localTableDataInfo;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localTableDataInfo;
  }
  
  public String getAttachmentUrl(String paramString)
  {
    String str1 = null;
    if (!StringUtils.isEmpty(paramString))
    {
      EidImageInfos localEidImageInfos = this.imageInfosDAO.findEidImageInfoByImageNumber(paramString);
      String str2 = null;
      if ((localEidImageInfos != null) && (!StringUtils.isEmpty(localEidImageInfos.getTaskNum()))) {
        str2 = EisConsts.isEvsBoe(localEidImageInfos.getTaskNum());
      }
      if (!StringUtils.isEmpty(str2))
      {
        String str3 = "_ATTACHMENT_URL";
        str1 = AccessPropertiesFile.getValue(str2 + str3);
        if (!StringUtils.isEmpty(str1)) {
          str1 = str1 + localEidImageInfos.getTaskNum();
        }
      }
      else
      {
        str1 = "N";
      }
    }
    return str1;
  }
  
  public String getBoeDetailUrl(String paramString)
  {
    String str1 = null;
    if ((null != paramString) && (!StringUtils.isEmpty(paramString)))
    {
      EasUserInfo localEasUserInfo = EisConsts.getCurrentUser();
      String str2 = null;
      str2 = EisConsts.isEvsBoe(paramString);
      if ((!StringUtils.isEmpty(str2)) && (str2 == "FSSC"))
      {
        String str3 = "_BOE_DETAIL_URL";
        str1 = AccessPropertiesFile.getValue(str2 + str3);
        if (!StringUtils.isEmpty(str1)) {
          str1 = str1.replace("#boeNum#", paramString).replace("#userId#", localEasUserInfo.getUserId());
        }
      }
      else
      {
        str1 = "N";
      }
    }
    return str1;
  }
  
  public List<EidAppraiseHistoryV> findHistoryVByImageNumber(String paramString)
  {
    Object localObject = new ArrayList();
    if ((paramString != null) && (!paramString.equals(""))) {
      try
      {
        localObject = this.appraiseHistoriesDAO.findHistoryVByImageNumber(paramString);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return localObject;
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public boolean rejectAppraiseHistory(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str1 = "N";
    try
    {
      String[] arrayOfString = null;
      if (paramString1.indexOf(",") == -1) {
        arrayOfString = new String[] { paramString1 };
      } else {
        arrayOfString = paramString1.split(",");
      }
      IEvsAppraiseHistorisesDS localIEvsAppraiseHistorisesDS = (IEvsAppraiseHistorisesDS)SSBBus.findDaoService("evsAppraiseHistorisesDS");
      EidObjectUtils localEidObjectUtils = (EidObjectUtils)SSBBus.findDaoService("eidObjectUtils");
      String str2 = localEidObjectUtils.getEmployeeBySession().getEmployeeNumber();
      if ((str2 == null) || (str2.equals(""))) {
        return false;
      }
      IEidImageInfosDAO localIEidImageInfosDAO = (IEidImageInfosDAO)SSBBus.findDaoService("eidImageInfosDAO");
      ImageList[] arrayOfImageList = new ImageList[arrayOfString.length];
      ArrayList localArrayList = new ArrayList();
      String str3 = EisConsts.SHOW_IMAGE_URL;
      for (int i = 0; i < arrayOfString.length; i++)
      {
        String str4 = arrayOfString[i];
        str1 = localIEvsAppraiseHistorisesDS.remarkVideo(str4, paramString2, paramString3, paramString4, str2);
        if (str1 != "Y") {
          return false;
        }
      }
      if (str1 != "Y") {
        return false;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return false;
    }
    return true;
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public boolean rejectAppraiseHistoryNeed(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str1 = "N";
    try
    {
      String[] arrayOfString = null;
      if (paramString1.indexOf(",") == -1) {
        arrayOfString = new String[] { paramString1 };
      } else {
        arrayOfString = paramString1.split(",");
      }
      IEvsAppraiseHistorisesDS localIEvsAppraiseHistorisesDS = (IEvsAppraiseHistorisesDS)SSBBus.findDaoService("evsAppraiseHistorisesDS");
      EidObjectUtils localEidObjectUtils = (EidObjectUtils)SSBBus.findDaoService("eidObjectUtils");
      String str2 = localEidObjectUtils.getEmployeeBySession().getEmployeeNumber();
      if ((str2 == null) || (str2.equals(""))) {
        return false;
      }
      for (int i = 0; i < arrayOfString.length; i++)
      {
        String str3 = arrayOfString[i];
        str1 = localIEvsAppraiseHistorisesDS.remarkVideoAppNeed(str3, paramString2, paramString3, paramString4, str2);
      }
      if (str1 != "Y") {
        return false;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return false;
    }
    return true;
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public boolean addAppraiseHistory(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    boolean bool = false;
    IEidAppraiseHistoriesDAO localIEidAppraiseHistoriesDAO = (IEidAppraiseHistoriesDAO)SSBBus.findDaoService("eidAppraiseHistoriesDAO");
    IEidImageInfosDAO localIEidImageInfosDAO = (IEidImageInfosDAO)SSBBus.findDaoService("eidImageInfosDAO");
    EidObjectUtils localEidObjectUtils = (EidObjectUtils)SSBBus.findDaoService("eidObjectUtils");
    String[] arrayOfString = null;
    if (paramString1.indexOf(",") == -1) {
      arrayOfString = new String[] { paramString1 };
    } else {
      arrayOfString = paramString1.split(",");
    }
    ImageList[] arrayOfImageList = new ImageList[arrayOfString.length];
    ArrayList localArrayList = new ArrayList();
    String str = EisConsts.SHOW_IMAGE_URL;
    Object localObject1;
    Object localObject2;
    for (int i = 0; i < arrayOfString.length; i++)
    {
      localObject1 = arrayOfString[i];
      localObject2 = new EidAppraiseHistories();
      EidImageInfos localEidImageInfos = localIEidImageInfosDAO.findEidImageInfoByImageNumber((String)localObject1);
      Long localLong = Long.valueOf(Long.parseLong(localEidObjectUtils.getEmployeeBySession().getEmployeeId().toString()));
      if ((localLong == null) || (localLong.equals(""))) {
        bool = false;
      }
      if (localEidImageInfos != null)
      {
        if (paramString2.equals("sign"))
        {
          localObject2 = cteateAppraiseHistory(localEidImageInfos.getImageInfoId(), paramString2, paramString3, paramString4, localLong);
          localEidImageInfos = updateImageInfo(localEidImageInfos, localLong);
        }
        else
        {
          localObject2 = cteateAppraiseHistoryFile(localEidImageInfos.getImageInfoId(), paramString2, paramString3, paramString4, localLong);
          localEidImageInfos = updateImageInfoS(localEidImageInfos, localLong);
        }
        localIEidAppraiseHistoriesDAO.insertEidAppraiseHistories((EidAppraiseHistories)localObject2);
        localIEidImageInfosDAO.updateEidImageInfos(localEidImageInfos);
        ImageList localImageList = new ImageList();
        localImageList.setBoeNum(localEidImageInfos.getTaskNum());
        localImageList.setImageSource("EIS");
        localImageList.setImageStatus(localEidImageInfos.getImageStatus());
        localImageList.setScanNum((String)localObject1);
        localImageList.setScanUrl(str + (String)localObject1);
        localImageList.setUpdateBy(localEidObjectUtils.getUserInfoBySession().getUserId());
        arrayOfImageList[i] = localImageList;
        localArrayList.add(localEidImageInfos);
        bool = true;
      }
      else
      {
        bool = false;
      }
    }
    try
    {
      if (("NORMAL_THROUGH".equals(paramString3)) && ("sign".equals(paramString2)))
      {
        CreateImageSrv localCreateImageSrv = new CreateImageSrv();
        localObject1 = new CreateImageRequest();
        ((CreateImageRequest)localObject1).setImageList(arrayOfImageList);
        localCreateImageSrv.createImage((CreateImageRequest)localObject1);
      }
    }
    catch (Exception localException)
    {
      if ((localArrayList != null) && (!localArrayList.isEmpty()))
      {
        localObject1 = localArrayList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (EidImageInfos)((Iterator)localObject1).next();
          ((EidImageInfos)localObject2).setEasImageFlag("N");
        }
        localIEidImageInfosDAO.updateEidImageInfoss(localArrayList);
      }
    }
    return bool;
  }
  
  public EidImageInfos findEidImageInfoByTaskNumber(String paramString)
  {
    return this.imageInfosDAO.findEidImageInfoByTaskNumber(paramString);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public boolean addAppraiseHistoryss(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    boolean bool = false;
    IEidAppraiseHistoriesDAO localIEidAppraiseHistoriesDAO = (IEidAppraiseHistoriesDAO)SSBBus.findDaoService("eidAppraiseHistoriesDAO");
    IEvsAppraiseHistorisesDS localIEvsAppraiseHistorisesDS = (IEvsAppraiseHistorisesDS)SSBBus.findDomainService("evsAppraiseHistorisesDS");
    IEidImageInfosDAO localIEidImageInfosDAO = (IEidImageInfosDAO)SSBBus.findDaoService("eidImageInfosDAO");
    EidObjectUtils localEidObjectUtils = (EidObjectUtils)SSBBus.findDaoService("eidObjectUtils");
    String[] arrayOfString1 = null;
    String[] arrayOfString2 = null;
    if (paramString1.indexOf(",") == -1)
    {
      arrayOfString1 = new String[] { paramString1 };
      arrayOfString2 = new String[] { paramString7 };
    }
    else
    {
      arrayOfString1 = paramString1.split(",");
      arrayOfString2 = paramString7.split(",");
    }
    for (int i = 0; i < arrayOfString1.length; i++)
    {
      String str1 = arrayOfString1[i];
      EidAppraiseHistories localEidAppraiseHistories = new EidAppraiseHistories();
      EidImageInfos localEidImageInfos1 = localIEidImageInfosDAO.findEidImageInfoByImageNumber(str1);
      Object localObject = null;
      if (paramString2.equals("sign"))
      {
        localObject = new ArrayList();
        ((List)localObject).add(str1);
      }
      else
      {
        localObject = localIEvsAppraiseHistorisesDS.getDetailBoeNumber(localEidImageInfos1.getTaskNum());
      }
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        if ((paramString5 != null) && (paramString5.length() > 2)) {
          str2 = paramString5.substring(paramString5.length() - 2);
        } else {
          str2 = paramString5;
        }
        if ((paramString6 != null) && (paramString6.length() > 2)) {
          str3 = paramString6.substring(paramString6.length() - 2);
        } else {
          str3 = paramString6;
        }
        if ((paramString9 != null) && (paramString9.length() > 2)) {
          str4 = paramString9.substring(paramString9.length() - 2);
        } else {
          str4 = paramString9;
        }
        if ((paramString8 != null) && (paramString8.length() > 6)) {
          str5 = paramString8.substring(paramString8.length() - 6);
        } else {
          str5 = paramString8;
        }
        Iterator localIterator = ((List)localObject).iterator();
        while (localIterator.hasNext())
        {
          String str6 = (String)localIterator.next();
          Long localLong = Long.valueOf(Long.parseLong(localEidObjectUtils.getEmployeeBySession().getEmployeeId().toString()));
          if ((localLong == null) || (localLong.equals(""))) {
            bool = false;
          }
          EidImageInfos localEidImageInfos2 = localIEidImageInfosDAO.findEidImageInfoByTaskNumber(str6);
          if ((!"ALREADY_FILING".equals(localEidImageInfos1.getImageStatus())) || (paramString2.equals("sign")))
          {
            StringBuffer localStringBuffer = new StringBuffer();
            if ((paramString8 == null) || (paramString8.trim().length() == 0))
            {
              localStringBuffer = null;
            }
            else
            {
              if ((arrayOfString2[i] != null) && (arrayOfString2[i].length() > 7)) {
                localStringBuffer.append(arrayOfString2[i].substring(arrayOfString2[i].length() - 7));
              } else {
                localStringBuffer.append(arrayOfString2[i]);
              }
              localStringBuffer.append(str2);
              localStringBuffer.append(str3);
              localStringBuffer.append(str4);
              localStringBuffer.append(str5);
            }
            System.out.println("sb 值是： " + localStringBuffer);
            if (localEidImageInfos2 != null)
            {
              if (paramString2.equals("sign"))
              {
                localEidAppraiseHistories = cteateAppraiseHistory(localEidImageInfos2.getImageInfoId(), paramString2, paramString3, paramString4, localLong);
                localEidImageInfos2 = updateImageInfo(localEidImageInfos2, localLong);
              }
              else
              {
                localEidAppraiseHistories = cteateAppraiseHistoryFile(localEidImageInfos2.getImageInfoId(), paramString2, paramString3, paramString4, localLong);
                if ((localStringBuffer != null) && (localStringBuffer.toString().trim().length() > 0)) {
                  localEidImageInfos2.setTaskNum(localStringBuffer.toString());
                }
                localEidImageInfos2 = updateImageInfoS(localEidImageInfos2, localLong);
              }
              localIEidAppraiseHistoriesDAO.insertEidAppraiseHistories(localEidAppraiseHistories);
              localIEidImageInfosDAO.updateEidImageInfos(localEidImageInfos2);
              bool = true;
            }
            else
            {
              bool = false;
            }
          }
        }
      }
    }
    return bool;
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public boolean addAppraiseHistory(List<String> paramList)
  {
    try
    {
      IEidAppraiseHistoriesDAO localIEidAppraiseHistoriesDAO = (IEidAppraiseHistoriesDAO)SSBBus.findDaoService("eidAppraiseHistoriesDAO");
      IEidImageInfosDAO localIEidImageInfosDAO1 = (IEidImageInfosDAO)SSBBus.findDaoService("eidImageInfosDAO");
      EidObjectUtils localEidObjectUtils = (EidObjectUtils)SSBBus.findDaoService("eidObjectUtils");
      Long localLong = Long.valueOf(Long.parseLong(localEidObjectUtils.getEmployeeBySession().getEmployeeId().toString()));
      if ((localLong == null) || (localLong.equals(""))) {
        return false;
      }
      if ((paramList == null) || (paramList.size() == 0)) {
        return false;
      }
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      String str1 = "APPRAISE";
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        IEidImageInfosDAO localIEidImageInfosDAO2 = (IEidImageInfosDAO)SSBBus.findDaoService("eidImageInfosDAO");
        EidImageInfos localEidImageInfos = localIEidImageInfosDAO2.findEidImageInfoByImageNumber(str2);
        if (localEidImageInfos != null)
        {
          EidAppraiseHistories localEidAppraiseHistories = cteateAppraiseHistory(localEidImageInfos.getImageInfoId(), str1, null, null, localLong);
          localArrayList1.add(localEidAppraiseHistories);
          localEidImageInfos = updateImageInfo(localEidImageInfos, localLong);
          localArrayList2.add(localEidImageInfos);
        }
      }
      if ((localArrayList1 != null) && (localArrayList1.size() > 0) && (localArrayList2 != null) && (localArrayList2.size() > 0))
      {
        localIEidAppraiseHistoriesDAO.insertEidAppraiseHistoriess(localArrayList1);
        localIEidImageInfosDAO1.updateEidImageInfoss(localArrayList2);
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  private EidAppraiseHistories cteateAppraiseHistory(Long paramLong1, String paramString1, String paramString2, String paramString3, Long paramLong2)
  {
    EidAppraiseHistories localEidAppraiseHistories = new EidAppraiseHistories();
    Date localDate = new Date();
    if (Util.isStrEmpty(paramString1)) {
      paramString1 = "APPRAISE";
    }
    localEidAppraiseHistories.setLastUpdateDate(localDate);
    localEidAppraiseHistories.setLastUpdatedBy(paramLong2);
    localEidAppraiseHistories.setCreationDate(localDate);
    localEidAppraiseHistories.setCreatedBy(paramLong2);
    localEidAppraiseHistories.setLastUpdateLogin(paramLong2);
    localEidAppraiseHistories.setEnabledFlag("Y");
    localEidAppraiseHistories.setImageInfoId(paramLong1);
    localEidAppraiseHistories.setAppraiseEmployeeId(paramLong2);
    localEidAppraiseHistories.setAppraiseDate(localDate);
    localEidAppraiseHistories.setAppraiseNode("SIGN_IN");
    localEidAppraiseHistories.setAppraiseType(paramString2);
    localEidAppraiseHistories.setAppraiseDesc(paramString3);
    localEidAppraiseHistories.setImageStatus("FOR_FILING");
    localEidAppraiseHistories.setActionCode("SIGN_IN");
    return localEidAppraiseHistories;
  }
  
  private EidAppraiseHistories cteateAppraiseHistoryFile(Long paramLong1, String paramString1, String paramString2, String paramString3, Long paramLong2)
  {
    EidAppraiseHistories localEidAppraiseHistories = new EidAppraiseHistories();
    Date localDate = new Date();
    if (Util.isStrEmpty(paramString1)) {
      paramString1 = "APPRAISE";
    }
    localEidAppraiseHistories.setLastUpdateDate(localDate);
    localEidAppraiseHistories.setLastUpdatedBy(paramLong2);
    localEidAppraiseHistories.setCreationDate(localDate);
    localEidAppraiseHistories.setCreatedBy(paramLong2);
    localEidAppraiseHistories.setLastUpdateLogin(paramLong2);
    localEidAppraiseHistories.setEnabledFlag("Y");
    localEidAppraiseHistories.setImageInfoId(paramLong1);
    localEidAppraiseHistories.setAppraiseEmployeeId(paramLong2);
    localEidAppraiseHistories.setAppraiseDate(localDate);
    localEidAppraiseHistories.setAppraiseNode("FILING");
    localEidAppraiseHistories.setAppraiseType(paramString2);
    localEidAppraiseHistories.setAppraiseDesc(paramString3);
    localEidAppraiseHistories.setImageStatus("ALREADY_FILING");
    localEidAppraiseHistories.setActionCode("FILING");
    return localEidAppraiseHistories;
  }
  
  private EidImageInfos updateImageInfo(EidImageInfos paramEidImageInfos, Long paramLong)
  {
    Date localDate = new Date();
    paramEidImageInfos.setLastUpdateDate(new Date());
    paramEidImageInfos.setLastUpdatedBy(paramLong);
    paramEidImageInfos.setLastUpdateLogin(paramLong);
    paramEidImageInfos.setAppraiseNode("SIGN_IN");
    paramEidImageInfos.setImageStatus("FOR_FILING");
    paramEidImageInfos.setSignDate(localDate);
    return paramEidImageInfos;
  }
  
  private EidImageInfos updateImageInfoS(EidImageInfos paramEidImageInfos, Long paramLong)
  {
    Date localDate = new Date();
    paramEidImageInfos.setLastUpdateDate(new Date());
    paramEidImageInfos.setLastUpdatedBy(paramLong);
    paramEidImageInfos.setLastUpdateLogin(paramLong);
    paramEidImageInfos.setAppraiseNode("FILING");
    paramEidImageInfos.setImageStatus("ALREADY_FILING");
    paramEidImageInfos.setSignDate(localDate);
    return paramEidImageInfos;
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public boolean removeEidImageInfos(List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      try
      {
        ISynImageDS localISynImageDS = (ISynImageDS)SSBBus.findDaoService("synImageDS");
        EidObjectUtils localEidObjectUtils = (EidObjectUtils)SSBBus.findDaoService("eidObjectUtils");
        Long localLong1 = Long.valueOf(Long.parseLong(localEidObjectUtils.getEmployeeBySession().getEmployeeId().toString()));
        String str = localEidObjectUtils.getEmployeeBySession().getEmployeeName();
        if ((localLong1 == null) || (localLong1.equals(""))) {
          return false;
        }
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        ArrayList localArrayList3 = new ArrayList();
        Date localDate = new Date();
        Object localObject1 = paramList.iterator();
        Object localObject2;
        Object localObject3;
        Object localObject4;
        Object localObject5;
        Object localObject6;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          localObject3 = Long.valueOf(Long.parseLong((String)localObject2));
          localObject4 = this.imageInfosDAO.getEidImageInfos((Long)localObject3);
          ((EidImageInfos)localObject4).setEnabledFlag("N");
          ((EidImageInfos)localObject4).setLastUpdateDate(localDate);
          ((EidImageInfos)localObject4).setLastUpdatedBy(localLong1);
          ((EidImageInfos)localObject4).setLastUpdateLogin(localLong1);
          localObject5 = this.imagesDAO.findEidImagesByImageInfoId(((EidImageInfos)localObject4).getImageInfoId());
          localObject6 = ((List)localObject5).iterator();
          while (((Iterator)localObject6).hasNext())
          {
            EidImages localEidImages = (EidImages)((Iterator)localObject6).next();
            localEidImages.setEnabledFlag("N");
            localEidImages.setLastUpdatedBy(localLong1);
            localEidImages.setLastUpdateLogin(localLong1);
            localEidImages.setLastUpdateDate(localDate);
            localArrayList2.add(localEidImages);
          }
          localArrayList3.add(((EidImageInfos)localObject4).getImageNumber());
          localArrayList1.add(localObject4);
        }
        if ((null != localArrayList1) && (localArrayList1.size() > 0) && (null != localArrayList3) && (localArrayList3.size() > 0))
        {
          this.imageInfosDAO.updateEidImageInfoss(localArrayList1);
          if ((null != localArrayList2) && (localArrayList2.size() > 0)) {
            this.imagesDAO.updateEidImagess(localArrayList2);
          }
          localObject1 = new MsgHeader();
          ((MsgHeader)localObject1).setUSERID(localLong1.toString());
          ((MsgHeader)localObject1).setUSERNAME(str);
          localObject2 = new GregorianCalendar();
          localObject3 = DatatypeFactory.newInstance().newXMLGregorianCalendar((GregorianCalendar)localObject2);
          ((MsgHeader)localObject1).setSUBMITDATE((XMLGregorianCalendar)localObject3);
          ((MsgHeader)localObject1).setSOURCESYSTEMID("EVS");
          ((MsgHeader)localObject1).setSOURCESYSTEMNAME("EVS");
          localObject4 = Long.valueOf(1000L);
          localObject5 = new SBEASEASImportImageOperationInfoSrvRequest();
          localObject6 = new ArrayList();
          for (int i = 0; i < localArrayList3.size(); i++)
          {
            Object localObject7 = localObject4;
            Long localLong2 = localObject4 = Long.valueOf(((Long)localObject4).longValue() + 1L);
            localObject7 = new ImportImageOperationInfoSrvInputItem();
            ((ImportImageOperationInfoSrvInputItem)localObject7).setBOENUM((String)localArrayList3.get(i));
            ((ImportImageOperationInfoSrvInputItem)localObject7).setPRIKEY(((Long)localObject4).toString());
            ((ImportImageOperationInfoSrvInputItem)localObject7).setOPERATIONTYPE("D");
            ((ImportImageOperationInfoSrvInputItem)localObject7).setBATCHNAME("imageDelete");
            ((List)localObject6).add(localObject7);
          }
          ImportImageOperationInfoSrvInputCollection localImportImageOperationInfoSrvInputCollection = new ImportImageOperationInfoSrvInputCollection();
          localImportImageOperationInfoSrvInputCollection.setImportImageOperationInfoSrvInputItem((List)localObject6);
          ((SBEASEASImportImageOperationInfoSrvRequest)localObject5).setMsgHeader((MsgHeader)localObject1);
          ((SBEASEASImportImageOperationInfoSrvRequest)localObject5).setImportImageOperationInfoSrvInputCollection(localImportImageOperationInfoSrvInputCollection);
          localISynImageDS.synImage((SBEASEASImportImageOperationInfoSrvRequest)localObject5);
          return true;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return false;
      }
    }
    return false;
  }
  
  public boolean findImageStatusByImageInfoId(String paramString)
  {
    if ((paramString != null) && (!paramString.equals(""))) {
      try
      {
        Long localLong = Long.valueOf(Long.parseLong(paramString));
        EidImageInfos localEidImageInfos = this.imageInfosDAO.getEidImageInfos(localLong);
        if ((localEidImageInfos != null) && (localEidImageInfos.getImageStatus().equals("IMG_APPRAISE"))) {
          return true;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return false;
      }
    }
    return false;
  }
  
  public TableDataInfo findMyApprovalInfosV(EidMyApprovalImageInfosV paramEidMyApprovalImageInfosV, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    try
    {
      EidObjectUtils localEidObjectUtils = (EidObjectUtils)SSBBus.findDaoService("eidObjectUtils");
      Long localLong = Long.valueOf(Long.parseLong(localEidObjectUtils.getEmployeeBySession().getEmployeeId().toString()));
      paramEidMyApprovalImageInfosV.setAppraiseEmployeeId(localLong);
      PageInfo localPageInfo = this.imageInfosDAO.findMyApprovalInfosVByQry(paramEidMyApprovalImageInfosV, paramInt1, paramInt2, "IMAGE_QUERY");
      localTableDataInfo.setData((List)localPageInfo.getResult());
      localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
      return localTableDataInfo;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localTableDataInfo;
  }
  
  public TableDataInfo queryMyBoeInfosV(EidMyboeImageInfosV paramEidMyboeImageInfosV, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    try
    {
      EidObjectUtils localEidObjectUtils = (EidObjectUtils)SSBBus.findDaoService("eidObjectUtils");
      Long localLong = Long.valueOf(Long.parseLong(localEidObjectUtils.getEmployeeBySession().getEmployeeId().toString()));
      paramEidMyboeImageInfosV.setUploadEmployeeId(localLong);
      PageInfo localPageInfo = this.imageInfosDAO.findMyBoeInfosVByQry(paramEidMyboeImageInfosV, paramInt1, paramInt2);
      localTableDataInfo.setData((List)localPageInfo.getResult());
      localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
      return localTableDataInfo;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localTableDataInfo;
  }
  
  public List<EidImages> findEidImages(String paramString)
  {
    String str = "select ei.* from eid.eid_images ei,eid.eid_image_infos e where e.image_info_id = ei.image_info_id and e.enabled_flag = 'Y' and e.image_number = ?";
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    IImageCommonDAO localIImageCommonDAO = (IImageCommonDAO)SSBBus.findDomainService("imageCommonDAO");
    List localList = localIImageCommonDAO.findObjectBySQL(str, localArrayList, EidImages.class);
    return localList;
  }
  
  public TableDataInfo queryOrgeInfosV(EidOrgeImageInfosV paramEidOrgeImageInfosV, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    try
    {
      PageInfo localPageInfo = this.imageInfosDAO.findOrgeInfosVByQry(paramEidOrgeImageInfosV, paramInt1, paramInt2, "IMAGE_QUERY");
      localTableDataInfo.setData((List)localPageInfo.getResult());
      localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
      return localTableDataInfo;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localTableDataInfo;
  }
  
  public TableDataInfo findNeedApprovalInfosVByQry(EidApprovalImageInfosV paramEidApprovalImageInfosV, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    try
    {
      PageInfo localPageInfo = this.imageInfosDAO.findNeedApprovalInfosVByQry(paramEidApprovalImageInfosV, paramInt1, paramInt2, "IMAGE_QUERY");
      localTableDataInfo.setData((List)localPageInfo.getResult());
      localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
      return localTableDataInfo;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localTableDataInfo;
  }
  
  public List<EidImageInfos> findEidImageInfoByFlag()
  {
    return this.imageInfosDAO.findEidImageInfoByFlag();
  }
  
  public List<EidImageInfos> findWaitDeleteImageInfo()
  {
    return this.imageInfosDAO.findWaitDeleteImageInfo();
  }
  
  public void updateEidImageInfos(List<EidImageInfos> paramList)
  {
    this.imageInfosDAO.updateEidImageInfoss(paramList);
  }
  
  public void deleteMyImage(Long paramLong)
  {
    if ((paramLong == null) || (paramLong.equals("")) || (paramLong.equals("0"))) {
      return;
    }
    this.imageInfosDAO.deleteMyImage(paramLong);
    EidImageInfos localEidImageInfos = this.imageInfosDAO.getEidImageInfos(paramLong);
    String str1 = "update eid_appraise_tasks task set task.enabled_flag = 'N',task.task_desc = '用户删除影像',task.task_status = 'COMPLETE' where task.task_status = 'NONCOMPLETE' and task.image_num = ?";
    IImageCommonDS localIImageCommonDS = (IImageCommonDS)SSBBus.findDomainService("imageCommonDS");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localEidImageInfos.getImageNumber());
    localIImageCommonDS.executeSql(str1, localArrayList);
    EidAppraiseHistories localEidAppraiseHistories = new EidAppraiseHistories();
    EasUserInfo localEasUserInfo = new EidObjectUtils().getUserInfoBySession();
    localEidAppraiseHistories.setLastUpdateDate(new Date());
    localEidAppraiseHistories.setLastUpdatedBy(Long.valueOf(localEasUserInfo.getUserInfoPk().longValue()));
    localEidAppraiseHistories.setCreationDate(new Date());
    localEidAppraiseHistories.setCreatedBy(Long.valueOf(localEasUserInfo.getUserInfoPk().longValue()));
    localEidAppraiseHistories.setLastUpdateLogin(Long.valueOf(localEasUserInfo.getUserInfoPk().longValue()));
    localEidAppraiseHistories.setEnabledFlag("Y");
    localEidAppraiseHistories.setImageInfoId(paramLong);
    localEidAppraiseHistories.setAppraiseEmployeeId(Long.valueOf(localEasUserInfo.getUserInfoPk().longValue()));
    localEidAppraiseHistories.setAppraiseDate(new Date());
    localEidAppraiseHistories.setAppraiseType("");
    localEidAppraiseHistories.setAppraiseDesc("删除影像");
    this.imageInfosDAO.insertObject(localEidAppraiseHistories);
    try
    {
      String str2 = EisConsts.SHOW_IMAGE_URL + localEidImageInfos.getImageNumber();
      CreateImageSrv localCreateImageSrv = new CreateImageSrv();
      CreateImageRequest localCreateImageRequest = new CreateImageRequest();
      ImageList localImageList = new ImageList();
      localImageList.setBoeNum(localEidImageInfos.getTaskNum());
      localImageList.setImageSource("EIS");
      localImageList.setImageStatus("DELETE");
      localImageList.setScanNum(localEidImageInfos.getImageNumber());
      localImageList.setScanUrl(str2);
      localImageList.setUpdateBy(localEasUserInfo.getUserId());
      localCreateImageRequest.setImageList(new ImageList[] { localImageList });
      localCreateImageSrv.deleteImage(localCreateImageRequest);
    }
    catch (Exception localException)
    {
      localEidImageInfos.setEasImageFlag("N");
      this.imageInfosDAO.updateObject(localEidImageInfos);
    }
  }
  
  public TableDataInfo fetchSpecialAttachments(SpecialAttachmentV paramSpecialAttachmentV, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    try
    {
      PageInfo localPageInfo = this.imageInfosDAO.fetchSpecialAttachments(paramSpecialAttachmentV, paramInt1, paramInt2);
      localTableDataInfo.setData((List)localPageInfo.getResult());
      localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
      return localTableDataInfo;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localTableDataInfo;
  }
  
  public TableDataInfo findEspecialInfosVByQry(EidImageInfosV paramEidImageInfosV, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    try
    {
      PageInfo localPageInfo = this.imageInfosDAO.findEspecialInfosVByQry(paramEidImageInfosV, paramInt1, paramInt2, "IMAGE_QUERY");
      localTableDataInfo.setData((List)localPageInfo.getResult());
      localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
      return localTableDataInfo;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localTableDataInfo;
  }
  
  public void updateImageInfoReject(String paramString1, String paramString2)
  {
    this.imageInfosDAO.updateImageInfoReject(paramString1, paramString2);
  }
  
  public List<EidPatrol> findPatrolByImageInfoId(Integer paramInteger)
  {
    return this.patrolDAO.findPatrolByImageInfoId(paramInteger);
  }
  
  public String insertForUpdatePatrol(List<EidPatrol> paramList)
  {
    return this.patrolDAO.insertForUpdatePatrol(paramList);
  }
  
  public String operationTypeInLimit(String paramString)
  {
    String str = this.imageInfosDAO.operationTypeInLimit(paramString);
    return str;
  }
  
  public IEidImageInfosDAO getImageInfosDAO()
  {
    return this.imageInfosDAO;
  }
  
  public void setImageInfosDAO(IEidImageInfosDAO paramIEidImageInfosDAO)
  {
    this.imageInfosDAO = paramIEidImageInfosDAO;
  }
  
  public IEidAppraiseHistoriesDAO getAppraiseHistoriesDAO()
  {
    return this.appraiseHistoriesDAO;
  }
  
  public void setAppraiseHistoriesDAO(IEidAppraiseHistoriesDAO paramIEidAppraiseHistoriesDAO)
  {
    this.appraiseHistoriesDAO = paramIEidAppraiseHistoriesDAO;
  }
  
  public IEidImagesDAO getImagesDAO()
  {
    return this.imagesDAO;
  }
  
  public void setImagesDAO(IEidImagesDAO paramIEidImagesDAO)
  {
    this.imagesDAO = paramIEidImagesDAO;
  }
  
  public IEidPatrolDAO getPatrolDAO()
  {
    return this.patrolDAO;
  }
  
  public void setPatrolDAO(IEidPatrolDAO paramIEidPatrolDAO)
  {
    this.patrolDAO = paramIEidPatrolDAO;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.service.EidImageInfosDS
 * JD-Core Version:    0.7.0.1
 */