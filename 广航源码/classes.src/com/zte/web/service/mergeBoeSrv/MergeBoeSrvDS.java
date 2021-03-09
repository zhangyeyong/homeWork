package com.zte.web.service.mergeBoeSrv;

import com.zte.eas.getData.util.EisConsts;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployees;
import com.zte.eimage.access.baseconfig.dao.IImageCommonDAO;
import com.zte.eimage.business.baseconfig.model.EidImageInfos;
import com.zte.eimage.business.baseconfig.model.EidImages;
import com.zte.evs.ebill.common.ObjectCopyUtils;
import com.zte.evs.ebill.model.eBillManage.EvsBoeRelation;
import com.zte.ssb.AccessPropertiesFile;
import com.zte.ssb.framework.base.BaseDomainService;
import com.zte.web.service.client.createImage.client.CreateImageRequest;
import com.zte.web.service.client.createImage.client.ImageList;
import com.zte.web.service.client.createImage.ds.CreateImageSrv;
import com.zte.web.service.mergeBoeSrv.service.MergeBoeRequest;
import com.zte.web.service.mergeBoeSrv.service.MergeBoeResponse;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;

public class MergeBoeSrvDS
  extends BaseDomainService
  implements IMergeBoeSrvDS
{
  private IImageCommonDAO imageCommonDAO;
  Logger logger = Logger.getLogger(getClass());
  final String ERROR_CODE1 = "employee_not_exists";
  final String ERROR_CODE2 = "O";
  
  public MergeBoeResponse saveMergeBoeSrv(MergeBoeRequest paramMergeBoeRequest)
  {
    MergeBoeResponse localMergeBoeResponse = new MergeBoeResponse();
    String str1 = AccessPropertiesFile.getValue("showImageUrl") + "?system=EVS&userID=EvsUser&scanNumber=" + paramMergeBoeRequest.getBOE_NUM();
    String str2 = this.imageCommonDAO.callMergeBoeSrv(paramMergeBoeRequest.getBOE_NUM(), paramMergeBoeRequest.getDETAIL_BOE_NUM(), paramMergeBoeRequest.getOperationType(), paramMergeBoeRequest.getEmployeeNumber(), "LMS");
    if ("Y".equalsIgnoreCase(str2))
    {
      localMergeBoeResponse.setERROR_FLAG("Y");
      localMergeBoeResponse.setERROR_MESSAGE(str1);
      try
      {
        CreateImageSrv localCreateImageSrv = new CreateImageSrv();
        localObject1 = new CreateImageRequest();
        localObject2 = new ImageList();
        ((ImageList)localObject2).setBoeNum(paramMergeBoeRequest.getBOE_NUM());
        ((ImageList)localObject2).setImageSource("EIS");
        ((ImageList)localObject2).setImageStatus("FOR_FILING");
        ((ImageList)localObject2).setScanNum(paramMergeBoeRequest.getBOE_NUM());
        ((ImageList)localObject2).setScanUrl(str1);
        ((ImageList)localObject2).setUpdateBy(paramMergeBoeRequest.getEmployeeNumber());
        ((CreateImageRequest)localObject1).setImageList(new ImageList[] { localObject2 });
        localCreateImageSrv.createImage((CreateImageRequest)localObject1);
        this.logger.error("合并单调用影像创建服务成功!");
      }
      catch (Exception localException)
      {
        this.logger.error("合并单调用影像创建服务失败!" + localException.getMessage(), localException);
        Object localObject1 = "update eid.eid_image_infos set eas_image_flag = 'N' where enabled_flag = 'Y' and task_num = ?";
        Object localObject2 = new ArrayList();
        ((List)localObject2).add(paramMergeBoeRequest.getBOE_NUM());
        this.imageCommonDAO.executeSql((String)localObject1, (List)localObject2);
      }
    }
    else if ("employee_not_exists".equalsIgnoreCase(str2))
    {
      localMergeBoeResponse.setERROR_FLAG("N");
      localMergeBoeResponse.setERROR_MESSAGE("员工编号[" + paramMergeBoeRequest.getEmployeeNumber() + "]在影像系统不存在!");
    }
    else
    {
      localMergeBoeResponse.setERROR_FLAG("N");
      localMergeBoeResponse.setERROR_MESSAGE("合并失败!");
    }
    return localMergeBoeResponse;
  }
  
  public MergeBoeResponse createMergeBoeRelation(MergeBoeRequest paramMergeBoeRequest)
  {
    EisConsts.printMsg(paramMergeBoeRequest, this.logger);
    MergeBoeResponse localMergeBoeResponse = new MergeBoeResponse();
    String str1 = "select * from fbp_employees emp where emp.employee_number = ?";
    ArrayList localArrayList1 = new ArrayList();
    localArrayList1.add(paramMergeBoeRequest.getEmployeeNumber());
    List localList1 = this.imageCommonDAO.findObjectBySQL(str1, localArrayList1, FbpEmployees.class);
    FbpEmployees localFbpEmployees = null;
    if ((localList1 != null) && (!localList1.isEmpty())) {
      localFbpEmployees = (FbpEmployees)localList1.get(0);
    }
    if ((localFbpEmployees == null) || (localFbpEmployees.getEmployeeId() == null))
    {
      localMergeBoeResponse.setERROR_FLAG("N");
      localMergeBoeResponse.setERROR_MESSAGE("员工编号不存在=" + paramMergeBoeRequest.getEmployeeNumber());
      this.logger.error("员工编号不存在=" + paramMergeBoeRequest.getEmployeeNumber());
      return localMergeBoeResponse;
    }
    ArrayList localArrayList2 = new ArrayList();
    String str2 = "select company_id,operation_type_id,upload_employee_id from eid.eid_image_infos where enabled_flag ='Y' and task_num = ?";
    localArrayList2.add(paramMergeBoeRequest.getDETAIL_BOE_NUM()[0]);
    List localList2 = this.imageCommonDAO.findObjectBySQL(str2, localArrayList2);
    Long localLong1 = null;
    Long localLong2 = null;
    Long localLong3 = null;
    if ((localList2 != null) && (!localList2.isEmpty()))
    {
      localObject1 = (Object[])localList2.get(0);
      if ((localObject1 != null) && (localObject1.length == 3))
      {
        localLong1 = localObject1[0] == null ? null : Long.valueOf(localObject1[0].toString());
        localLong2 = localObject1[1] == null ? null : Long.valueOf(localObject1[1].toString());
        localLong3 = localObject1[2] == null ? null : Long.valueOf(localObject1[2].toString());
      }
    }
    if ((localLong1 == null) || (localLong2 == null))
    {
      localMergeBoeResponse.setERROR_FLAG("N");
      localMergeBoeResponse.setERROR_MESSAGE("影像编号不存在=" + paramMergeBoeRequest.getDETAIL_BOE_NUM()[0]);
      this.logger.error("影像编号不存在=" + paramMergeBoeRequest.getDETAIL_BOE_NUM()[0]);
      return localMergeBoeResponse;
    }
    Object localObject1 = null;
    EidImageInfos localEidImageInfos = new EidImageInfos();
    localEidImageInfos.setCompanyId(localLong1);
    localEidImageInfos.setOperationTypeId(localLong2);
    localEidImageInfos.setCreatedBy(Long.valueOf(localFbpEmployees.getEmployeeId().longValue()));
    localEidImageInfos.setCreationDate(new Date());
    localEidImageInfos.setLastUpdatedBy(Long.valueOf(localFbpEmployees.getEmployeeId().longValue()));
    localEidImageInfos.setLastUpdateDate(new Date());
    localEidImageInfos.setLastUpdateLogin(Long.valueOf(localFbpEmployees.getEmployeeId().longValue()));
    localEidImageInfos.setEnabledFlag("Y");
    localEidImageInfos.setAppraiseNode("FOR_FILING");
    localEidImageInfos.setIsBoe("Y");
    localEidImageInfos.setImageNumber(paramMergeBoeRequest.getBOE_NUM());
    localEidImageInfos.setTaskNum(paramMergeBoeRequest.getBOE_NUM());
    localEidImageInfos.setImageStatus("FOR_FILING");
    localEidImageInfos.setMemo("通过合并单据关系接口创建");
    localEidImageInfos.setUploadDate(new Date());
    localEidImageInfos.setUploadEmployeeId(localLong3);
    localEidImageInfos.setSynchFlag("N");
    this.imageCommonDAO.insertObject(localEidImageInfos);
    this.logger.error("创建合并单成功!");
    Integer localInteger = Integer.valueOf(0);
    ArrayList localArrayList4;
    Object localObject6;
    Object localObject7;
    Object localObject8;
    for (Object localObject5 : paramMergeBoeRequest.getDETAIL_BOE_NUM())
    {
      String str3 = "select * from eid.eid_images where image_info_id = (select image_info_id from eid.eid_image_infos ei where ei.enabled_flag = 'Y' and ei.task_num = ?)";
      localArrayList4 = new ArrayList();
      localArrayList4.add(localObject5);
      localObject6 = this.imageCommonDAO.findObjectBySQL(str3, localArrayList4, EidImages.class);
      if ((localObject6 != null) && (!((List)localObject6).isEmpty()))
      {
        localInteger = Integer.valueOf(localInteger.intValue() + ((List)localObject6).size());
        localObject7 = ((List)localObject6).iterator();
        while (((Iterator)localObject7).hasNext())
        {
          localObject8 = ((Iterator)localObject7).next();
          EidImages localEidImages1 = (EidImages)localObject8;
          EidImages localEidImages2 = new EidImages();
          ObjectCopyUtils.copy(localEidImages1, localEidImages2);
          localEidImages2.setCreatedBy(Long.valueOf(localFbpEmployees.getEmployeeId().longValue()));
          localEidImages2.setCreationDate(new Date());
          localEidImages2.setLastUpdatedBy(Long.valueOf(localFbpEmployees.getEmployeeId().longValue()));
          localEidImages2.setLastUpdateDate(new Date());
          localEidImages2.setLastUpdateLogin(Long.valueOf(localFbpEmployees.getEmployeeId().longValue()));
          localEidImages2.setImageId(null);
          localEidImages2.setImageInfoId(localEidImageInfos.getImageInfoId());
          this.imageCommonDAO.insertObject(localEidImages2);
        }
      }
    }
    this.logger.error("创建合并单图片成功!");
    localEidImageInfos.setImageCount(Long.valueOf(localInteger.longValue()));
    localObject1 = AccessPropertiesFile.getValue("showImageUrl") + "?system=EVS&userID=EvsUser&scanNumber=" + localEidImageInfos.getImageNumber();
    Object localObject4;
    try
    {
      ??? = new CreateImageSrv();
      localObject3 = new CreateImageRequest();
      localObject4 = new ImageList();
      ((ImageList)localObject4).setBoeNum(localEidImageInfos.getTaskNum());
      ((ImageList)localObject4).setImageSource("EIS");
      ((ImageList)localObject4).setImageStatus(localEidImageInfos.getImageStatus());
      ((ImageList)localObject4).setScanNum(localEidImageInfos.getImageNumber());
      ((ImageList)localObject4).setScanUrl((String)localObject1);
      ((ImageList)localObject4).setUpdateBy(paramMergeBoeRequest.getEmployeeNumber());
      ((CreateImageRequest)localObject3).setImageList(new ImageList[] { localObject4 });
      ((CreateImageSrv)???).createImage((CreateImageRequest)localObject3);
      this.logger.error("合并单调用影像创建服务成功!");
    }
    catch (Exception localException)
    {
      this.logger.error("合并单调用影像创建服务失败!" + localException.getMessage(), localException);
      localEidImageInfos.setEasImageFlag("N");
      this.imageCommonDAO.updateObject(localEidImageInfos);
    }
    ArrayList localArrayList3 = new ArrayList();
    Object localObject3 = "select * from evs.evs_boe_relations where boe_num = ? and detail_boe_num = ?";
    for (localArrayList4 : paramMergeBoeRequest.getDETAIL_BOE_NUM())
    {
      localObject6 = new ArrayList();
      ((List)localObject6).add(paramMergeBoeRequest.getBOE_NUM());
      ((List)localObject6).add(localArrayList4);
      localObject7 = this.imageCommonDAO.findObjectBySQL((String)localObject3, (List)localObject6, EvsBoeRelation.class);
      if ((localObject7 == null) || (((List)localObject7).isEmpty()))
      {
        localObject8 = new EvsBoeRelation();
        ((EvsBoeRelation)localObject8).setCreatedBy(Long.valueOf(localFbpEmployees.getEmployeeId().longValue()));
        ((EvsBoeRelation)localObject8).setCreationDate(new Date());
        ((EvsBoeRelation)localObject8).setLastUpdateBy(Long.valueOf(localFbpEmployees.getEmployeeId().longValue()));
        ((EvsBoeRelation)localObject8).setLastUpdateDate(new Date());
        ((EvsBoeRelation)localObject8).setLastUpdateLogin(Long.valueOf(localFbpEmployees.getEmployeeId().longValue()));
        ((EvsBoeRelation)localObject8).setEnabledFlag("Y");
        ((EvsBoeRelation)localObject8).setBoeNum(paramMergeBoeRequest.getBOE_NUM());
        ((EvsBoeRelation)localObject8).setDetailBoeNum(localArrayList4);
        ((EvsBoeRelation)localObject8).setOperatorUser(paramMergeBoeRequest.getEmployeeNumber());
        ((EvsBoeRelation)localObject8).setSynchFlag("N");
        localArrayList3.add(localObject8);
      }
      else
      {
        localObject8 = (EvsBoeRelation)((List)localObject7).get(0);
        ((EvsBoeRelation)localObject8).setLastUpdateBy(Long.valueOf(localFbpEmployees.getEmployeeId().longValue()));
        ((EvsBoeRelation)localObject8).setLastUpdateDate(new Date());
        ((EvsBoeRelation)localObject8).setLastUpdateLogin(Long.valueOf(localFbpEmployees.getEmployeeId().longValue()));
        ((EvsBoeRelation)localObject8).setEnabledFlag("Y");
        ((EvsBoeRelation)localObject8).setOperatorUser(paramMergeBoeRequest.getEmployeeNumber());
        this.imageCommonDAO.updateObject(localObject8);
      }
    }
    this.imageCommonDAO.insertObjects(localArrayList3);
    this.logger.error("写入合并单与明细单关系成功!");
    updateSynchFlag(paramMergeBoeRequest, "Y");
    localMergeBoeResponse.setERROR_FLAG("Y");
    localMergeBoeResponse.setERROR_MESSAGE((String)localObject1);
    EisConsts.printMsg(localMergeBoeResponse, this.logger);
    return localMergeBoeResponse;
  }
  
  public MergeBoeResponse calcelMergeBoeRelation(MergeBoeRequest paramMergeBoeRequest)
  {
    MergeBoeResponse localMergeBoeResponse = new MergeBoeResponse();
    String str1 = "select * from fbp_employees emp where emp.employee_number = ?";
    ArrayList localArrayList1 = new ArrayList();
    localArrayList1.add(paramMergeBoeRequest.getEmployeeNumber());
    List localList1 = this.imageCommonDAO.findObjectBySQL(str1, localArrayList1, FbpEmployees.class);
    FbpEmployees localFbpEmployees = null;
    if ((localList1 != null) && (!localList1.isEmpty())) {
      localFbpEmployees = (FbpEmployees)localList1.get(0);
    }
    if ((localFbpEmployees == null) || (localFbpEmployees.getEmployeeId() == null))
    {
      localMergeBoeResponse.setERROR_FLAG("N");
      localMergeBoeResponse.setERROR_MESSAGE("员工编号不存在=" + paramMergeBoeRequest.getEmployeeNumber());
      return localMergeBoeResponse;
    }
    String str2 = "select * from eid.eid_image_infos where enabled_flag = 'Y' and task_num = ?";
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(paramMergeBoeRequest.getBOE_NUM());
    List localList2 = this.imageCommonDAO.findObjectBySQL(str2, localArrayList2, EidImageInfos.class);
    if ((localList2 == null) || (localList2.isEmpty()))
    {
      localMergeBoeResponse.setERROR_FLAG("N");
      localMergeBoeResponse.setERROR_MESSAGE("报账单编号不存在=" + paramMergeBoeRequest.getBOE_NUM());
      return localMergeBoeResponse;
    }
    EidImageInfos localEidImageInfos = (EidImageInfos)localList2.get(0);
    localEidImageInfos.setEnabledFlag("N");
    this.imageCommonDAO.updateObject(localEidImageInfos);
    String str3 = "update evs.evs_boe_relations set enabled_flag = 'N' where boe_num = ?";
    ArrayList localArrayList3 = new ArrayList();
    localArrayList3.add(paramMergeBoeRequest.getBOE_NUM());
    this.imageCommonDAO.executeSql(str3, localArrayList3);
    try
    {
      CreateImageSrv localCreateImageSrv = new CreateImageSrv();
      CreateImageRequest localCreateImageRequest = new CreateImageRequest();
      ImageList localImageList = new ImageList();
      localImageList.setBoeNum(localEidImageInfos.getTaskNum());
      localImageList.setImageSource("EIS");
      localImageList.setImageStatus("BACKED");
      localImageList.setScanNum(localEidImageInfos.getImageNumber());
      localImageList.setUpdateBy(paramMergeBoeRequest.getEmployeeNumber());
      localCreateImageRequest.setImageList(new ImageList[] { localImageList });
      localCreateImageSrv.deleteImage(localCreateImageRequest);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localEidImageInfos.setDeleteImageFlag("N");
      this.imageCommonDAO.updateObject(localEidImageInfos);
    }
    updateSynchFlag(paramMergeBoeRequest, "N");
    localMergeBoeResponse.setERROR_FLAG("Y");
    localMergeBoeResponse.setERROR_MESSAGE("取消合并单据关系成功");
    return localMergeBoeResponse;
  }
  
  private void updateSynchFlag(MergeBoeRequest paramMergeBoeRequest, String paramString)
  {
    String str1 = "update eid_image_infos ei set ei.synch_flag = ? where ei.task_num in(";
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    int i = 0;
    StringBuffer localStringBuffer = new StringBuffer(str1);
    int j = 1000;
    for (int k = 0; k < paramMergeBoeRequest.getDETAIL_BOE_NUM().length; k++)
    {
      String str3 = paramMergeBoeRequest.getDETAIL_BOE_NUM()[k];
      i++;
      if (i <= j)
      {
        localStringBuffer.append("?,");
        localArrayList.add(str3);
      }
      if (i == j)
      {
        String str4 = localStringBuffer.substring(0, localStringBuffer.length() - 1).concat(")");
        this.imageCommonDAO.executeSql(str4, localArrayList);
        localArrayList.clear();
        localArrayList.add(paramMergeBoeRequest.getBOE_NUM());
        i = 0;
        localStringBuffer = new StringBuffer(str1);
      }
    }
    if (i > 0)
    {
      String str2 = localStringBuffer.substring(0, localStringBuffer.length() - 1).concat(")");
      this.imageCommonDAO.executeSql(str2, localArrayList);
    }
  }
  
  public IImageCommonDAO getImageCommonDAO()
  {
    return this.imageCommonDAO;
  }
  
  public void setImageCommonDAO(IImageCommonDAO paramIImageCommonDAO)
  {
    this.imageCommonDAO = paramIImageCommonDAO;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.mergeBoeSrv.MergeBoeSrvDS
 * JD-Core Version:    0.7.0.1
 */