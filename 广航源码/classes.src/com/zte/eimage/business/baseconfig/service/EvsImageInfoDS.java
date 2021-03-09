package com.zte.eimage.business.baseconfig.service;

import com.zte.eas.bmsctrl.ws.syn.sieboeheader.ds.ISynBoeHeadeImgrDS;
import com.zte.eas.organization.business.countcompanymanage.model.FbpCompany;
import com.zte.eimage.access.baseconfig.dao.IEidAppraiseHistoriesDAO;
import com.zte.eimage.access.baseconfig.dao.IEidAppraiseTasksDAO;
import com.zte.eimage.access.baseconfig.dao.IEidImageInfosDAO;
import com.zte.eimage.access.baseconfig.dao.IEidImagesDAO;
import com.zte.eimage.access.baseconfig.dao.IFrontUserDao;
import com.zte.eimage.access.baseconfig.dao.ISiteDao;
import com.zte.eimage.business.baseconfig.model.EidAppraiseHistories;
import com.zte.eimage.business.baseconfig.model.EidAppraiseTasks;
import com.zte.eimage.business.baseconfig.model.EidImageInfos;
import com.zte.eimage.business.baseconfig.model.EidImages;
import com.zte.eimage.business.baseconfig.model.FbpOperationTypes;
import com.zte.eimage.business.baseconfig.model.FrontUser;
import com.zte.eimage.business.baseconfig.model.Message;
import com.zte.eimage.business.baseconfig.model.Site;
import com.zte.eimage.business.common.model.Fbplogins;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.BaseDomainService;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class EvsImageInfoDS
  extends BaseDomainService
  implements IEvsImageInfoDS
{
  Log log = LogFactory.getLog(EvsImageInfoDS.class);
  final Integer paramLength = Integer.valueOf(9);
  
  public Message findEidImageInfoByImageNumber(String paramString)
  {
    Message localMessage = new Message();
    try
    {
      IEidImageInfosDAO localIEidImageInfosDAO = (IEidImageInfosDAO)SSBBus.findDaoService("eidImageInfosDAO");
      EidImageInfos localEidImageInfos = localIEidImageInfosDAO.findEidImageInfoByImageNumber(paramString);
      if (localEidImageInfos != null)
      {
        IEidImagesDAO localIEidImagesDAO = (IEidImagesDAO)SSBBus.findDaoService("eidImagesDAO");
        List localList = localIEidImagesDAO.findEidImagesByImageInfoId(localEidImageInfos.getImageInfoId());
        if ((localList != null) && (localList.size() > 0))
        {
          EidImages[] arrayOfEidImages = new EidImages[localList.size()];
          for (int i = 0; i < localList.size(); i++) {
            arrayOfEidImages[i] = ((EidImages)localList.get(i));
          }
          localEidImageInfos.setEidImages(arrayOfEidImages);
        }
        localMessage.setEidImageInfo(localEidImageInfos);
        localMessage.setFlag(true);
        localMessage.setMsg("执行成功");
      }
      else
      {
        localMessage.setEidImageInfo(null);
        localMessage.setFlag(false);
        localMessage.setMsg("没有对于的影像文件");
      }
    }
    catch (Exception localException)
    {
      localMessage.setEidImageInfo(null);
      localMessage.setFlag(false);
      localMessage.setMsg(localException.getMessage());
    }
    return localMessage;
  }
  
  public int UploadLog(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, String paramString5, String paramString6, String paramString7)
  {
    this.log.error("\n\n++++++++++++++++++++++++++++ UploadLog 上传影像服务 begin +++++++++++++++++++++++++++++++++++++++++++++");
    this.log.error("sessionID:  " + paramString1);
    this.log.error("iScanType:  " + paramInt1);
    this.log.error("sRoot:  " + paramString2);
    this.log.error("sIP:  " + paramString3);
    this.log.error("param:  " + paramString4);
    Fbplogins localFbplogins = EvsServiceSessionMap.getLoginInfo(paramString1);
    if (localFbplogins == null)
    {
      this.log.error("获取登录信息失败!");
      return 1;
    }
    Long localLong = Long.valueOf(localFbplogins.getUserId().toString());
    String str1 = localFbplogins.getUserName();
    String str2 = "FOR_FILING";
    IFrontUserDao localIFrontUserDao = (IFrontUserDao)SSBBus.findDomainService("frontUserDao");
    IEidAppraiseHistoriesDAO localIEidAppraiseHistoriesDAO = (IEidAppraiseHistoriesDAO)SSBBus.findDaoService("eidAppraiseHistoriesDAO");
    String str3 = "from FrontUser where employeeId=" + localLong;
    FrontUser localFrontUser = (FrontUser)localIFrontUserDao.getObject(str3);
    if ((localFrontUser != null) && (localFrontUser.getUploadGroup() != null) && (localFrontUser.getUploadGroup().trim().length() > 0)) {}
    IEidImageInfosDAO localIEidImageInfosDAO = (IEidImageInfosDAO)SSBBus.findDaoService("eidImageInfosDAO");
    IEidImagesDAO localIEidImagesDAO = (IEidImagesDAO)SSBBus.findDaoService("eidImagesDAO");
    String[] arrayOfString = new String[0];
    if ((null != paramString4) && (!"".equals(paramString4)))
    {
      paramString4 = paramString4.replace("[", "");
      arrayOfString = paramString4.split("]");
      if ((arrayOfString == null) || (arrayOfString.length <= this.paramLength.intValue()))
      {
        this.log.error("param参数长度不对，长度应为" + (this.paramLength.intValue() + 1));
        return 1;
      }
      EidImageInfos localEidImageInfos1 = localIEidImageInfosDAO.findEidImageInfoByImageNumber(arrayOfString[0].toString());
      EidImageInfos localEidImageInfos2 = localIEidImageInfosDAO.findEidImageInfoByTaskNumber(arrayOfString[1].toString());
      if (paramInt1 == 0)
      {
        if ((localEidImageInfos1 != null) && (localEidImageInfos1.getImageInfoId() != null))
        {
          this.log.error("returnValue: 2");
          return 2;
        }
        if ((localEidImageInfos2 != null) && (localEidImageInfos2.getImageInfoId() != null))
        {
          this.log.error("returnValue: 3");
          return 3;
        }
      }
      int i = 0;
      if ((localEidImageInfos1 != null) && (paramInt1 == 6))
      {
        localEidImageInfos1.setEnabledFlag("N");
        localIEidImageInfosDAO.updateEidImageInfos(localEidImageInfos1);
      }
      else if (localEidImageInfos1 != null)
      {
        i = localEidImageInfos1.getImageCount().intValue();
      }
      EidImageInfos localEidImageInfos3 = new EidImageInfos();
      localEidImageInfos3.setLastUpdateDate(new Date());
      localEidImageInfos3.setLastUpdatedBy(localLong);
      localEidImageInfos3.setCreationDate(new Date());
      localEidImageInfos3.setCreatedBy(localLong);
      localEidImageInfos3.setLastUpdateLogin(localLong);
      localEidImageInfos3.setAppraiseNode("RESET_UPLOAD");
      Date localDate = new Date();
      localEidImageInfos3.setImageCount(Long.valueOf(arrayOfString[2]));
      localEidImageInfos3.setImageNumber(arrayOfString[0].toString());
      localEidImageInfos3.setMemo(arrayOfString[8]);
      localEidImageInfos3.setTaskNum(arrayOfString[1]);
      String str4 = "RESET_UPLOAD";
      if ((paramInt1 != 3) && (paramInt1 != 15))
      {
        localEidImageInfos3.setImageStatus(str2);
        localEidImageInfos3.setEnabledFlag("Y");
        localEidImageInfos3.setUploadDate(localDate);
        localEidImageInfos3.setUploadEmployeeId(Long.valueOf(localLong.longValue()));
        localObject1 = (FbpCompany)localIEidImageInfosDAO.findEidImageInfoByCode("FbpCompany", "companyCode", paramString5);
        localEidImageInfos3.setCompanyId(((FbpCompany)localObject1).getCompanyId());
        localObject2 = (FbpOperationTypes)localIEidImageInfosDAO.findEidImageInfoByCode("FbpOperationTypes", "operationTypeCode", paramString6);
        localEidImageInfos3.setOperationTypeId(((FbpOperationTypes)localObject2).getOperationTypeId());
        localEidImageInfos3.setIsBoe(arrayOfString[9]);
        localIEidImageInfosDAO.insertObject(localEidImageInfos3);
      }
      else if ((paramInt1 == 3) || (paramInt1 == 15))
      {
        if (localEidImageInfos1 == null)
        {
          this.log.error("找不到待补扫的影像");
          return 1;
        }
        if ((arrayOfString[4] != null) && (!arrayOfString[4].trim().equals("")))
        {
          localObject1 = arrayOfString[4].split(";");
          localEidImageInfos1.setImageCount(Long.valueOf((localEidImageInfos1.getImageCount() == null ? 0L : localEidImageInfos1.getImageCount().longValue()) + localObject1.length));
        }
        localEidImageInfos1.setImageStatus("COMPLEMENT_FOR_FILING");
        localEidImageInfos1.setSynchFlag("N");
        str4 = "COMPLEMENT_FOR_FILING";
        localIEidImageInfosDAO.updateEidImageInfos(localEidImageInfos1);
      }
      Object localObject1 = Long.valueOf(paramInt2);
      Object localObject2 = (ISiteDao)SSBBus.findDaoService("siteDao");
      Site localSite = null;
      if (localObject1 == null) {
        localSite = ((ISiteDao)localObject2).findSiteByEmployeeId(localEidImageInfos3.getUploadEmployeeId());
      } else {
        localSite = ((ISiteDao)localObject2).getSiteById(Integer.valueOf(((Long)localObject1).intValue()));
      }
      if ((arrayOfString[4] != null) && (!arrayOfString[4].trim().equals("")))
      {
        localObject3 = arrayOfString[4].split(";");
        for (int j = 0; j < localObject3.length; j++)
        {
          localObject4 = new EidImages();
          ((EidImages)localObject4).setCreatedBy(localLong);
          ((EidImages)localObject4).setCreationDate(new Date());
          ((EidImages)localObject4).setEnabledFlag("Y");
          ((EidImages)localObject4).setImageInfoId((localEidImageInfos1 != null) && (localEidImageInfos1.getImageInfoId() != null) ? localEidImageInfos1.getImageInfoId() : localEidImageInfos3.getImageInfoId() != null ? localEidImageInfos3.getImageInfoId() : localEidImageInfos3.getImageInfoId());
          if (arrayOfString[8] != null) {
            ((EidImages)localObject4).setImageMemo(arrayOfString[8].toString());
          }
          if (null != localSite)
          {
            if (!"/".equals(paramString2.substring(0, 1))) {
              paramString2 = "/" + paramString2;
            }
            ((EidImages)localObject4).setImagePath(paramString2 + "/" + ++i + "." + arrayOfString[3]);
            localObject5 = localSite.getRootDirectory();
            if ((localObject5 != null) && (((String)localObject5).indexOf("..") != -1))
            {
              localObject5 = ((String)localObject5).replace("../", "");
              localObject5 = "/" + (String)localObject5;
            }
            ((EidImages)localObject4).setLocalPath((String)localObject5);
            ((EidImages)localObject4).setWebhostUrl(localSite.getWebSite());
          }
          ((EidImages)localObject4).setLastUpdateDate(localDate);
          ((EidImages)localObject4).setLastUpdatedBy(localLong);
          ((EidImages)localObject4).setLastUpdateLogin(localLong);
          localIEidImagesDAO.insertEidImages((EidImages)localObject4);
        }
      }
      Object localObject3 = new EidAppraiseHistories();
      ((EidAppraiseHistories)localObject3).setLastUpdateDate(new Date());
      ((EidAppraiseHistories)localObject3).setLastUpdatedBy(localLong);
      ((EidAppraiseHistories)localObject3).setCreationDate(new Date());
      ((EidAppraiseHistories)localObject3).setCreatedBy(localLong);
      ((EidAppraiseHistories)localObject3).setLastUpdateLogin(localLong);
      ((EidAppraiseHistories)localObject3).setEnabledFlag("Y");
      ((EidAppraiseHistories)localObject3).setImageInfoId((localEidImageInfos1 != null) && (localEidImageInfos1.getImageInfoId() != null) ? localEidImageInfos1.getImageInfoId() : localEidImageInfos3.getImageInfoId() != null ? localEidImageInfos3.getImageInfoId() : localEidImageInfos3.getImageInfoId());
      ((EidAppraiseHistories)localObject3).setAppraiseEmployeeId(localLong);
      ((EidAppraiseHistories)localObject3).setAppraiseDate(new Date());
      ((EidAppraiseHistories)localObject3).setAppraiseNode(str4);
      ((EidAppraiseHistories)localObject3).setImageStatus(str2);
      ((EidAppraiseHistories)localObject3).setActionCode(str4);
      localIEidAppraiseHistoriesDAO.insertEidAppraiseHistories((EidAppraiseHistories)localObject3);
      ISynBoeHeadeImgrDS localISynBoeHeadeImgrDS = (ISynBoeHeadeImgrDS)SSBBus.findDomainService("synBoeHeadeImgrDS");
      Object localObject4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      localISynBoeHeadeImgrDS.createImg(localEidImageInfos3.getTaskNum(), localEidImageInfos3.getImageNumber(), ((SimpleDateFormat)localObject4).format(localDate), localFbplogins.getUserCode(), "RESET_UPLOAD");
      Object localObject5 = (IEidAppraiseTasksDAO)SSBBus.findDaoService("eidAppraiseTasksDAO");
      EidAppraiseTasks localEidAppraiseTasks = ((IEidAppraiseTasksDAO)localObject5).findEidAppraiseTasksByImageNum(localEidImageInfos3.getImageNumber());
      if (localEidAppraiseTasks != null)
      {
        localEidAppraiseTasks.setEnabledFlag("N");
        localEidAppraiseTasks.setLastUpdateDate(new Date());
        localEidAppraiseTasks.setTaskStatus("COMPLETE");
        ((IEidAppraiseTasksDAO)localObject5).updateEidAppraiseTasks(localEidAppraiseTasks);
      }
    }
    this.log.error("returnValue:  0");
    this.log.error("++++++++++++++++++++++++++++ UploadLog 上传影像服务 end +++++++++++++++++++++++++++++++++++++++++++++\n\n");
    return 0;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.service.EvsImageInfoDS
 * JD-Core Version:    0.7.0.1
 */