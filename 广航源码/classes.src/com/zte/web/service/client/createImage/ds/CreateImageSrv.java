package com.zte.web.service.client.createImage.ds;

import com.zte.eas.getData.util.EisConsts;
import com.zte.eas.login.SSOLogin.EASLoginProxy;
import com.zte.eas.login.SSOLogin.EASLoginProxyService;
import com.zte.eas.login.SSOLogin.EASLoginProxyServiceLocator;
import com.zte.eas.login.SSOLogin.WSContext;
import com.zte.eimage.business.baseconfig.model.EidImageInfos;
import com.zte.eimage.business.baseconfig.service.IEidImageInfosDS;
import com.zte.eimage.business.baseconfig.service.IImageCommonDS;
import com.zte.esb.bean.fssc.GetEisRequest;
import com.zte.esb.client.FsscNewImageRequestSender;
import com.zte.ssb.AccessPropertiesFile;
import com.zte.ssb.framework.SSBBus;
import com.zte.web.service.client.WSImgSystemInterfaceFacade.WSImgSystemInterfaceFacadeSrvProxy;
import com.zte.web.service.client.WSImgSystemInterfaceFacade.WSImgSystemInterfaceFacadeSrvProxyService;
import com.zte.web.service.client.WSImgSystemInterfaceFacade.WSImgSystemInterfaceFacadeSrvProxyServiceLocator;
import com.zte.web.service.client.createImage.client.CreateImageRequest;
import com.zte.web.service.client.createImage.client.CreateImageSrvServiceLocator;
import com.zte.web.service.client.createImage.client.ImageList;
import com.zte.web.service.client.createImage.client.bcc.EIS_BCC_EAI_YXLocator;
import com.zte.web.service.client.createImage.client.bcc.EIS_BCC_EAI_YXSoap_PortType;
import com.zte.web.service.client.createImage.client.bcc.ModEIS;
import com.zte.web.service.client.createImage.client.gems.EIS_Rewrite;
import com.zte.web.service.client.createImage.client.gems.EIS_Rewrite_SrvLocator;
import com.zte.web.service.client.createImage.client.gems.EIS_Rewrite_SrvRequest;
import com.zte.web.service.client.createImage.client.gems.EIS_Rewrite_SrvResponse;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.xml.rpc.ServiceException;
import org.apache.log4j.Logger;

public class CreateImageSrv
{
  Logger logger = Logger.getLogger(CreateImageSrv.class);
  private final String IMAGE_STATUS_ALREADY_FILING = "ALREADY_FILING";
  private final String IMAGE_STATUS_BACKED = "BACKED";
  private final String IMAGE_STATUS_COMPLEMENT_FOR_FILING = "COMPLEMENT_FOR_FILING";
  private final String IMAGE_STATUS_FOR_FILING = "FOR_FILING";
  private final String IMAGE_STATUS_TO_SIGN_FOR = "TO_SIGN_FOR";
  private final String IMAGE_STATUS_DELETE = "DELETE";
  private String userName = AccessPropertiesFile.getValue("SSO_userName");
  private String password = AccessPropertiesFile.getValue("SSO_password");
  private String slnName = AccessPropertiesFile.getValue("SSO_slnName");
  private String dcName = AccessPropertiesFile.getValue("SSO_dcName");
  private String language = AccessPropertiesFile.getValue("SSO_language");
  private int dbType = new Integer(AccessPropertiesFile.getValue("SSO_dbType")).intValue();
  
  private String getImageStatus(String paramString)
  {
    String str = null;
    if (("FOR_FILING".equals(paramString)) || ("COMPLEMENT_FOR_FILING".equals(paramString)) || ("TO_SIGN_FOR".equals(paramString)))
    {
      str = "FOR_FILING";
    }
    else
    {
      if ("ALREADY_FILING".equals(paramString)) {
        return "ALREADY_FILING";
      }
      if ("BACKED".equals(paramString)) {
        str = "BACKED";
      } else {
        str = "DELETE";
      }
    }
    return str;
  }
  
  public void createImage(CreateImageRequest paramCreateImageRequest)
    throws Exception
  {
    ImageList[] arrayOfImageList = paramCreateImageRequest.getImageList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    HashMap localHashMap = new HashMap();
    if ((arrayOfImageList != null) && (arrayOfImageList.length > 0))
    {
      String str1 = EisConsts.SHOW_IMAGE_URL;
      String str2 = "select count(1) from eid.eid_images where image_info_id =(select image_info_id from eid.eid_image_infos e where e.enabled_flag = 'Y' and image_number = ?)";
      ArrayList localArrayList4 = new ArrayList();
      IImageCommonDS localIImageCommonDS = (IImageCommonDS)SSBBus.findDomainService("imageCommonDS");
      for (Object localObject2 : arrayOfImageList)
      {
        String str3 = EisConsts.isEvsBoe(localObject2.getBoeNum());
        str1 = str1.replace("system=#SYSTEM#", "system=" + str3).replace("scanNumber=#scanNumber#", "scanNumber=" + localObject2.getScanNum());
        localArrayList4.clear();
        localArrayList4.add(localObject2.getScanNum());
        Object localObject3 = localIImageCommonDS.findObject(str2, localArrayList4, null);
        Long localLong = Long.valueOf(localObject3 == null ? 0L : Long.valueOf(localObject3.toString()).longValue());
        localObject2.setImageCount(localLong);
        if ("EVS".equals(str3))
        {
          localArrayList1.add(localObject2);
        }
        else
        {
          Object localObject4;
          Object localObject5;
          if ("LMS".equals(str3))
          {
            str1 = str1.replace("userID=#userID#", "userID=LmsUser");
            localObject4 = localObject2.getImageStatus();
            localObject5 = new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            ((StringBuffer)localObject5).append("<otherBill><billHead><imgNumber>");
            ((StringBuffer)localObject5).append(localObject2.getScanNum().toString());
            ((StringBuffer)localObject5).append("</imgNumber><billNumber>");
            ((StringBuffer)localObject5).append(localObject2.getBoeNum());
            ((StringBuffer)localObject5).append("</billNumber><imgStatus>");
            ((StringBuffer)localObject5).append((String)localObject4);
            ((StringBuffer)localObject5).append("</imgStatus><imgCount>");
            ((StringBuffer)localObject5).append(localObject2.getImageCount());
            ((StringBuffer)localObject5).append("</imgCount><updater>");
            ((StringBuffer)localObject5).append(localObject2.getUpdateBy());
            ((StringBuffer)localObject5).append("</updater><url>");
            ((StringBuffer)localObject5).append(str1);
            ((StringBuffer)localObject5).append("</url></billHead></otherBill>");
            this.logger.error("\n\ncreate lms image begin................");
            this.logger.error(((StringBuffer)localObject5).toString());
            this.logger.error("create lms image end................\n\n");
            localHashMap.put(localObject2.getBoeNum().toString(), ((StringBuffer)localObject5).toString());
          }
          else if ("FSSC".equals(str3))
          {
            str1 = str1.replace("userID=#userID#", "userID=fsscUser");
            localObject4 = (FsscNewImageRequestSender)SSBBus.findDomainService("fsscNewImageRequestSender");
            localObject5 = new GetEisRequest();
            ((GetEisRequest)localObject5).setLastModifyPerson(localObject2.getUpdateBy());
            ((GetEisRequest)localObject5).setEISFileNo(localObject2.getScanNum());
            ((GetEisRequest)localObject5).setEISTaskNo(localObject2.getBoeNum());
            ((GetEisRequest)localObject5).setEISStatus(getImageStatus(localObject2.getImageStatus()));
            ((GetEisRequest)localObject5).setEISFileAccount(localObject2.getImageCount().toString());
            ((GetEisRequest)localObject5).setEISUrl(str1);
            ((FsscNewImageRequestSender)localObject4).send((GetEisRequest)localObject5);
          }
        }
      }
      ??? = new HashMap();
      if ((localHashMap != null) && (!localHashMap.isEmpty()))
      {
        Map localMap = createImageToLMS(localHashMap);
        ??? = getNewMap((Map)???, localMap);
      }
      updateFlag((Map)???);
    }
  }
  
  public void deleteImage(CreateImageRequest paramCreateImageRequest)
    throws Exception
  {
    createImage(paramCreateImageRequest);
  }
  
  public Map<String, List<String>> getNewMap(Map<String, List<String>> paramMap1, Map<String, List<String>> paramMap2)
  {
    if (paramMap1 == null)
    {
      paramMap1.put("Y", new ArrayList());
      paramMap1.put("N", new ArrayList());
    }
    if (paramMap1.get("Y") == null) {
      paramMap1.put("Y", new ArrayList());
    }
    if (paramMap1.get("N") == null) {
      paramMap1.put("N", new ArrayList());
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramMap1.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = (List)paramMap1.get(str);
      if (paramMap2.containsKey(str))
      {
        List localList = (List)paramMap2.get(str);
        if (localObject == null) {
          localObject = new ArrayList();
        }
        if ((localList != null) && (!localList.isEmpty())) {
          ((List)localObject).addAll(localList);
        }
        paramMap1.put(str, localObject);
      }
    }
    localHashMap.putAll(paramMap1);
    return localHashMap;
  }
  
  public void updateFlag(Map<String, List<String>> paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      String str1 = "select * from eid.eid_image_infos ei where ei.task_num = ? and rownum = 1 order by last_update_date desc";
      IImageCommonDS localIImageCommonDS = (IImageCommonDS)SSBBus.findDomainService("imageCommonDS");
      IEidImageInfosDS localIEidImageInfosDS = (IEidImageInfosDS)SSBBus.findDomainService("imageInfosDS");
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        List localList1 = (List)paramMap.get(str2);
        if ((localList1 != null) && (!localList1.isEmpty())) {
          for (int i = 0; i < localList1.size(); i++)
          {
            localArrayList1.clear();
            localArrayList1.add(localList1.get(i));
            List localList2 = localIImageCommonDS.findObjectBySQL(str1, localArrayList1, EidImageInfos.class);
            if ((localList2 != null) && (!localList2.isEmpty()))
            {
              EidImageInfos localEidImageInfos = (EidImageInfos)localList2.get(0);
              if (localEidImageInfos != null)
              {
                String str3 = "N".equals(localEidImageInfos.getEnabledFlag()) ? "DELETE" : getImageStatus(localEidImageInfos.getImageStatus());
                if (("BACKED".equals(str3)) && ("DELETE".equals(str3))) {
                  localEidImageInfos.setDeleteImageFlag(str2);
                } else {
                  localEidImageInfos.setEasImageFlag(str2);
                }
                localArrayList2.add(localEidImageInfos);
              }
            }
          }
        }
      }
      if ((localArrayList2 != null) && (!localArrayList2.isEmpty())) {
        localIEidImageInfosDS.updateEidImageInfos(localArrayList2);
      }
    }
  }
  
  public Map<String, List<String>> createImageToEVS(CreateImageRequest paramCreateImageRequest)
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    try
    {
      for (Object localObject2 : paramCreateImageRequest.getImageList()) {
        localArrayList.add(localObject2.getScanNum());
      }
      ??? = new CreateImageSrvServiceLocator();
      com.zte.web.service.client.createImage.client.CreateImageSrv localCreateImageSrv = ((CreateImageSrvServiceLocator)???).getcreateImageSrv();
      String str = localCreateImageSrv.createImage(paramCreateImageRequest);
      if ("Y".equals(str))
      {
        localHashMap.put("Y", localArrayList);
        localHashMap.put("N", null);
      }
      else
      {
        localHashMap.put("N", localArrayList);
        localHashMap.put("Y", null);
      }
    }
    catch (ServiceException localServiceException)
    {
      this.logger.error("connect evs createImage service fail  " + localServiceException.getMessage(), localServiceException);
      localHashMap.put("Y", null);
      localHashMap.put("N", localArrayList);
    }
    catch (RemoteException localRemoteException)
    {
      this.logger.error("invok evs createImage service fail  " + localRemoteException.getMessage(), localRemoteException);
      localHashMap.put("Y", null);
      localHashMap.put("N", localArrayList);
    }
    return localHashMap;
  }
  
  public Map<String, List<String>> deleteImageToEVS(CreateImageRequest paramCreateImageRequest)
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    try
    {
      for (Object localObject2 : paramCreateImageRequest.getImageList()) {
        localArrayList.add(localObject2.getScanNum());
      }
      ??? = new CreateImageSrvServiceLocator();
      com.zte.web.service.client.createImage.client.CreateImageSrv localCreateImageSrv = ((CreateImageSrvServiceLocator)???).getcreateImageSrv();
      String str = localCreateImageSrv.deleteImage(paramCreateImageRequest);
      if ("Y".equals(str))
      {
        localHashMap.put("Y", localArrayList);
        localHashMap.put("N", null);
      }
      else
      {
        localHashMap.put("N", localArrayList);
        localHashMap.put("Y", null);
      }
    }
    catch (ServiceException localServiceException)
    {
      this.logger.error("connect evs createImage service fail  " + localServiceException.getMessage(), localServiceException);
      localHashMap.put("N", localArrayList);
      localHashMap.put("Y", null);
    }
    catch (RemoteException localRemoteException)
    {
      this.logger.error("invok evs createImage service fail  " + localRemoteException.getMessage(), localRemoteException);
      localHashMap.put("N", localArrayList);
      localHashMap.put("Y", null);
    }
    return localHashMap;
  }
  
  private Map<String, List<String>> createGemsImageSrv(List<EIS_Rewrite_SrvRequest> paramList)
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    EIS_Rewrite_SrvLocator localEIS_Rewrite_SrvLocator = new EIS_Rewrite_SrvLocator();
    try
    {
      EIS_Rewrite localEIS_Rewrite = localEIS_Rewrite_SrvLocator.getEIS_RewritePort();
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          localObject1 = (EIS_Rewrite_SrvRequest)localIterator.next();
          EisConsts.printMsg(localObject1, this.logger);
          localObject2 = localEIS_Rewrite.rewriteImageURL((EIS_Rewrite_SrvRequest)localObject1);
          EisConsts.printMsg(localObject2, this.logger);
          if ((localObject2 != null) && (((EIS_Rewrite_SrvResponse)localObject2).getO_FLAG() != null) && ((((EIS_Rewrite_SrvResponse)localObject2).getO_FLAG().equals("Y")) || (((EIS_Rewrite_SrvResponse)localObject2).getO_FLAG().equalsIgnoreCase("True"))))
          {
            localArrayList1.add(((EIS_Rewrite_SrvRequest)localObject1).getI_SCAN_NUM());
          }
          else
          {
            this.logger.error("+++++++=++=+++++++++++++++=create gems image error:  error_bill_code=" + ((EIS_Rewrite_SrvRequest)localObject1).getI_BOE_NUM() + ", error_message=" + (localObject2 == null ? "没有返回值" : ((EIS_Rewrite_SrvResponse)localObject2).getO_MESSAGE()));
            localArrayList2.add(((EIS_Rewrite_SrvRequest)localObject1).getI_SCAN_NUM());
          }
        }
      }
      localHashMap.put("Y", localArrayList1);
      localHashMap.put("N", localArrayList2);
      return localHashMap;
    }
    catch (ServiceException localServiceException)
    {
      localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (EIS_Rewrite_SrvRequest)((Iterator)localObject1).next();
        localArrayList2.add(((EIS_Rewrite_SrvRequest)localObject2).getI_SCAN_NUM());
      }
      localHashMap.put("N", localArrayList2);
      localHashMap.put("Y", null);
      this.logger.error("connect gems createImage service fail  " + localServiceException.getMessage(), localServiceException);
    }
    catch (RemoteException localRemoteException)
    {
      Object localObject2;
      Object localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (EIS_Rewrite_SrvRequest)((Iterator)localObject1).next();
        localArrayList2.add(((EIS_Rewrite_SrvRequest)localObject2).getI_SCAN_NUM());
      }
      localHashMap.put("N", localArrayList2);
      localHashMap.put("Y", null);
      this.logger.error("invok gems createImage service fail  " + localRemoteException.getMessage(), localRemoteException);
    }
    return localHashMap;
  }
  
  public Map<String, List<String>> createImageToBCC(List<ModEIS> paramList)
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    try
    {
      if ((paramList == null) || (paramList.isEmpty())) {
        return null;
      }
      EIS_BCC_EAI_YXLocator localEIS_BCC_EAI_YXLocator = new EIS_BCC_EAI_YXLocator();
      localObject1 = localEIS_BCC_EAI_YXLocator.getEIS_BCC_EAI_YXSoap();
      localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ModEIS localModEIS = (ModEIS)((Iterator)localObject2).next();
        EisConsts.printMsg(localModEIS, this.logger);
        String str = ((EIS_BCC_EAI_YXSoap_PortType)localObject1).createImage(localModEIS);
        if ("Y".equals(str))
        {
          localArrayList1.add(localModEIS.getScanNum());
        }
        else
        {
          this.logger.error("+++++++=++=+++++++++++++++=create bcc image error:  error_bill_code=" + localModEIS.getBILLCODE() + ", error_message=" + str);
          localArrayList2.add(localModEIS.getScanNum());
        }
      }
      localHashMap.put("Y", localArrayList1);
      localHashMap.put("N", localArrayList2);
      return localHashMap;
    }
    catch (ServiceException localServiceException)
    {
      this.logger.error("connect bcc createImage service fail  " + localServiceException.getMessage(), localServiceException);
      localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ModEIS)((Iterator)localObject1).next();
        localArrayList2.add(((ModEIS)localObject2).getScanNum());
      }
      localHashMap.put("N", localArrayList2);
      localHashMap.put("Y", null);
    }
    catch (RemoteException localRemoteException)
    {
      Object localObject2;
      this.logger.error("invok bcc createImage service fail  " + localRemoteException.getMessage(), localRemoteException);
      Object localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ModEIS)((Iterator)localObject1).next();
        localArrayList2.add(((ModEIS)localObject2).getScanNum());
      }
      localHashMap.put("N", localArrayList2);
      localHashMap.put("Y", null);
    }
    return localHashMap;
  }
  
  public Map<String, List<String>> createImageToLMS(Map<String, String> paramMap)
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    try
    {
      if ((paramMap == null) || (paramMap.isEmpty())) {
        return null;
      }
      EASLoginProxyServiceLocator localEASLoginProxyServiceLocator = new EASLoginProxyServiceLocator();
      EASLoginProxy localEASLoginProxy = localEASLoginProxyServiceLocator.getEASLogin();
      WSContext localWSContext = localEASLoginProxy.login(this.userName, this.password, this.slnName, this.dcName, this.language, this.dbType);
      if (localWSContext != null)
      {
        Iterator localIterator = paramMap.entrySet().iterator();
        WSImgSystemInterfaceFacadeSrvProxyServiceLocator localWSImgSystemInterfaceFacadeSrvProxyServiceLocator = new WSImgSystemInterfaceFacadeSrvProxyServiceLocator();
        WSImgSystemInterfaceFacadeSrvProxy localWSImgSystemInterfaceFacadeSrvProxy = localWSImgSystemInterfaceFacadeSrvProxyServiceLocator.getWSImgSystemInterfaceFacade();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          String str1 = (String)localEntry.getKey();
          String str2 = (String)localEntry.getValue();
          String[] arrayOfString = localWSImgSystemInterfaceFacadeSrvProxy.imgCreateOrUpdate(str2);
          if (arrayOfString[0].equals("T")) {
            localArrayList1.add(str1);
          } else {
            localArrayList2.add(str1);
          }
        }
        localHashMap.put("Y", localArrayList1);
        localHashMap.put("N", localArrayList2);
      }
    }
    catch (ServiceException localServiceException)
    {
      localServiceException.printStackTrace();
    }
    catch (RemoteException localRemoteException)
    {
      this.logger.error("invok lms createImage service fail  " + localRemoteException.getMessage(), localRemoteException);
      localHashMap.put("N", localArrayList2);
      localHashMap.put("Y", null);
    }
    return localHashMap;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.client.createImage.ds.CreateImageSrv
 * JD-Core Version:    0.7.0.1
 */