package com.zte.eas.appframe.business.synrequest.service;

import com.zte.eas.appframe.access.synrequest.dao.FbpSynchRequestsVDAO;
import com.zte.eas.appframe.access.synrequest.dao.IFbpSynchRequestsVDAO;
import com.zte.eas.appframe.business.synrequest.model.FbpSynchRequestsV;
import com.zte.eas.getData.util.EisConsts;
import com.zte.eas.organization.access.employeemanage.dao.IFbpEmployeesDAO;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployees;
import com.zte.eimage.business.baseconfig.model.EidImageInfos;
import com.zte.eimage.business.baseconfig.service.IEidImageInfosDS;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;
import com.zte.web.service.client.createImage.client.CreateImageRequest;
import com.zte.web.service.client.createImage.client.ImageList;
import com.zte.web.service.client.createImage.ds.CreateImageSrv;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;

public class SynchTimer
{
  private IFbpSynchRequestsDS fbpSynchRequestsDS;
  private IFbpSynchRequestsVDAO fbpSynchRequestsVDAO;
  Log log = SSBBus.getLog(SynchTimer.class);
  
  public void timeSynch()
  {
    try
    {
      this.fbpSynchRequestsDS = ((IFbpSynchRequestsDS)SSBBus.findDaoService("fbpSynchRequestsDS"));
      this.fbpSynchRequestsVDAO = ((FbpSynchRequestsVDAO)SSBBus.findDaoService("fbpSynchRequestsVDAO"));
      List localList = this.fbpSynchRequestsVDAO.findAllFbpSynchRequestsV();
      if ((localList != null) && (localList.size() > 0))
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          FbpSynchRequestsV localFbpSynchRequestsV = (FbpSynchRequestsV)localIterator.next();
          if (localFbpSynchRequestsV != null)
          {
            String str = this.fbpSynchRequestsDS.autoRunSynchRequest(localFbpSynchRequestsV);
            this.log.info("executing syn SynchType-> " + localFbpSynchRequestsV.getSynchType());
          }
        }
      }
    }
    catch (Exception localException)
    {
      this.log.error(localException);
      localException.printStackTrace();
    }
  }
  
  public void timeSynchAP()
  {
    try
    {
      this.fbpSynchRequestsDS = ((IFbpSynchRequestsDS)SSBBus.findDaoService("fbpSynchRequestsDS"));
      this.fbpSynchRequestsVDAO = ((FbpSynchRequestsVDAO)SSBBus.findDaoService("fbpSynchRequestsVDAO"));
      List localList = this.fbpSynchRequestsVDAO.findFbpSynchRequestsByAP();
      if ((localList != null) && (localList.size() > 0))
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          FbpSynchRequestsV localFbpSynchRequestsV = (FbpSynchRequestsV)localIterator.next();
          if (localFbpSynchRequestsV != null)
          {
            String str = this.fbpSynchRequestsDS.autoRunSynchRequest(localFbpSynchRequestsV);
            this.log.info("executing syn SynchType-> " + localFbpSynchRequestsV.getSynchType());
          }
        }
      }
    }
    catch (Exception localException)
    {
      this.log.error(localException);
    }
  }
  
  public void timeSynchAR()
  {
    try
    {
      this.fbpSynchRequestsDS = ((IFbpSynchRequestsDS)SSBBus.findDaoService("fbpSynchRequestsDS"));
      this.fbpSynchRequestsVDAO = ((FbpSynchRequestsVDAO)SSBBus.findDaoService("fbpSynchRequestsVDAO"));
      List localList = this.fbpSynchRequestsVDAO.findFbpSynchRequestsByAR();
      if ((localList != null) && (localList.size() > 0))
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          FbpSynchRequestsV localFbpSynchRequestsV = (FbpSynchRequestsV)localIterator.next();
          if (localFbpSynchRequestsV != null)
          {
            String str = this.fbpSynchRequestsDS.autoRunSynchRequest(localFbpSynchRequestsV);
            this.log.info("executing syn SynchType-> " + localFbpSynchRequestsV.getSynchType());
          }
        }
      }
    }
    catch (Exception localException)
    {
      this.log.error(localException);
    }
  }
  
  public void timeSynchGL()
  {
    try
    {
      this.fbpSynchRequestsDS = ((IFbpSynchRequestsDS)SSBBus.findDaoService("fbpSynchRequestsDS"));
      this.fbpSynchRequestsVDAO = ((FbpSynchRequestsVDAO)SSBBus.findDaoService("fbpSynchRequestsVDAO"));
      List localList = this.fbpSynchRequestsVDAO.findFbpSynchRequestsByGL();
      if ((localList != null) && (localList.size() > 0))
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          FbpSynchRequestsV localFbpSynchRequestsV = (FbpSynchRequestsV)localIterator.next();
          if (localFbpSynchRequestsV != null)
          {
            String str = this.fbpSynchRequestsDS.autoRunSynchRequest(localFbpSynchRequestsV);
            this.log.info("executing syn SynchType-> " + localFbpSynchRequestsV.getSynchType());
          }
        }
      }
    }
    catch (Exception localException)
    {
      this.log.error(localException);
    }
  }
  
  public void timeSynchRC()
  {
    try
    {
      this.fbpSynchRequestsDS = ((IFbpSynchRequestsDS)SSBBus.findDaoService("fbpSynchRequestsDS"));
      this.fbpSynchRequestsVDAO = ((FbpSynchRequestsVDAO)SSBBus.findDaoService("fbpSynchRequestsVDAO"));
      List localList = this.fbpSynchRequestsVDAO.findFbpSynchRequestsByRC();
      if ((localList != null) && (localList.size() > 0))
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          FbpSynchRequestsV localFbpSynchRequestsV = (FbpSynchRequestsV)localIterator.next();
          if (localFbpSynchRequestsV != null)
          {
            String str = this.fbpSynchRequestsDS.autoRunSynchRequest(localFbpSynchRequestsV);
            this.log.info("executing syn SynchType-> " + localFbpSynchRequestsV.getSynchType());
          }
        }
      }
    }
    catch (Exception localException)
    {
      this.log.error(localException);
    }
  }
  
  public void createImage()
  {
    IEidImageInfosDS localIEidImageInfosDS = (IEidImageInfosDS)SSBBus.findDaoService("imageInfosDS");
    IFbpEmployeesDAO localIFbpEmployeesDAO = (IFbpEmployeesDAO)SSBBus.findDomainService("fbpEmployeesDAO");
    String str = EisConsts.SHOW_IMAGE_URL;
    CreateImageSrv localCreateImageSrv = new CreateImageSrv();
    List localList1 = null;
    Object localObject3;
    Object localObject4;
    Object localObject1;
    try
    {
      localList1 = localIEidImageInfosDS.findEidImageInfoByFlag();
      if ((localList1 != null) && (!localList1.isEmpty()))
      {
        ImageList[] arrayOfImageList = new ImageList[localList1.size()];
        for (int i = 0; i < localList1.size(); i++)
        {
          localEidImageInfos = (EidImageInfos)localList1.get(i);
          if (localEidImageInfos != null)
          {
            localObject3 = localIFbpEmployeesDAO.getFbpEmployees(BigInteger.valueOf(localEidImageInfos.getUploadEmployeeId().longValue()));
            localObject4 = new ImageList();
            ((ImageList)localObject4).setBoeNum(localEidImageInfos.getTaskNum());
            ((ImageList)localObject4).setImageSource("EIS");
            ((ImageList)localObject4).setImageStatus(localEidImageInfos.getImageStatus());
            ((ImageList)localObject4).setScanNum(localEidImageInfos.getImageNumber());
            ((ImageList)localObject4).setScanUrl(str + localEidImageInfos.getImageNumber());
            ((ImageList)localObject4).setUpdateBy(localObject3 == null ? "10000" : ((FbpEmployees)localObject3).getEmployeeNumber());
            ((ImageList)localObject4).setImageCount(localEidImageInfos.getImageCount());
            arrayOfImageList[i] = localObject4;
          }
        }
        localObject1 = new CreateImageRequest();
        ((CreateImageRequest)localObject1).setImageList(arrayOfImageList);
        localCreateImageSrv.createImage((CreateImageRequest)localObject1);
      }
    }
    catch (Exception localException1)
    {
      EidImageInfos localEidImageInfos;
      this.log.error(localException1.getMessage(), localException1);
      if ((localList1 != null) && (!localList1.isEmpty()))
      {
        localObject1 = localList1.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localEidImageInfos = (EidImageInfos)((Iterator)localObject1).next();
          localEidImageInfos.setEasImageFlag("N");
        }
        localIEidImageInfosDS.updateEidImageInfos(localList1);
      }
    }
    List localList2 = null;
    try
    {
      localList2 = localIEidImageInfosDS.findWaitDeleteImageInfo();
      if ((localList2 != null) && (!localList2.isEmpty()))
      {
        localObject1 = new ImageList[localList2.size()];
        for (int j = 0; j < localList2.size(); j++)
        {
          localObject3 = (EidImageInfos)localList2.get(j);
          if (localObject3 != null)
          {
            localObject4 = localIFbpEmployeesDAO.getFbpEmployees(BigInteger.valueOf(((EidImageInfos)localObject3).getUploadEmployeeId().longValue()));
            ImageList localImageList = new ImageList();
            localImageList.setBoeNum(((EidImageInfos)localObject3).getTaskNum());
            localImageList.setImageSource("EIS");
            localImageList.setImageStatus(((EidImageInfos)localObject3).getImageStatus());
            localImageList.setScanNum(((EidImageInfos)localObject3).getImageNumber());
            localImageList.setScanUrl(str + ((EidImageInfos)localObject3).getImageNumber());
            localImageList.setUpdateBy(localObject4 == null ? "10000" : ((FbpEmployees)localObject4).getEmployeeNumber());
            localObject1[j] = localImageList;
          }
        }
        localObject2 = new CreateImageRequest();
        ((CreateImageRequest)localObject2).setImageList((ImageList[])localObject1);
        localCreateImageSrv.deleteImage((CreateImageRequest)localObject2);
      }
    }
    catch (Exception localException2)
    {
      Object localObject2;
      this.log.error(localException2.getMessage(), localException2);
      if ((localList2 != null) && (!localList2.isEmpty()))
      {
        localObject2 = localList2.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (EidImageInfos)((Iterator)localObject2).next();
          ((EidImageInfos)localObject3).setDeleteImageFlag("N");
        }
        localIEidImageInfosDS.updateEidImageInfos(localList2);
      }
    }
  }
  
  public IFbpSynchRequestsDS getFbpSynchRequestsDS()
  {
    return this.fbpSynchRequestsDS;
  }
  
  public void setFbpSynchRequestsDS(IFbpSynchRequestsDS paramIFbpSynchRequestsDS)
  {
    this.fbpSynchRequestsDS = paramIFbpSynchRequestsDS;
  }
  
  public IFbpSynchRequestsVDAO getFbpSynchRequestsVDAO()
  {
    return this.fbpSynchRequestsVDAO;
  }
  
  public void setFbpSynchRequestsVDAO(IFbpSynchRequestsVDAO paramIFbpSynchRequestsVDAO)
  {
    this.fbpSynchRequestsVDAO = paramIFbpSynchRequestsVDAO;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.business.synrequest.service.SynchTimer
 * JD-Core Version:    0.7.0.1
 */