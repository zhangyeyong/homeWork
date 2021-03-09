package com.zte.web.service.mergeBoeSrv.service;

import com.zte.eimage.business.baseconfig.service.IImageCommonDS;
import com.zte.ssb.framework.SSBBus;
import com.zte.web.service.mergeBoeSrv.IMergeBoeSrvDS;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class MergeBoeSrvSoapBindingImpl
  implements MergeBoeSrv
{
  final String MERGE = "M";
  final String CANCEL = "C";
  Logger logger = Logger.getLogger(MergeBoeSrv.class);
  
  public MergeBoeResponse mergeBoeSrv(MergeBoeRequest paramMergeBoeRequest)
  {
    MergeBoeResponse localMergeBoeResponse = new MergeBoeResponse();
    try
    {
      if ((paramMergeBoeRequest.getBOE_NUM() == null) || (paramMergeBoeRequest.getBOE_NUM().trim().length() == 0))
      {
        localMergeBoeResponse.setERROR_FLAG("N");
        localMergeBoeResponse.setERROR_MESSAGE("合并单据编号不能为空!");
      }
      else
      {
        IMergeBoeSrvDS localIMergeBoeSrvDS = (IMergeBoeSrvDS)SSBBus.findDomainService("mergeBoeSrvDS");
        if ((!"M".equalsIgnoreCase(paramMergeBoeRequest.getOperationType())) && (!"C".equalsIgnoreCase(paramMergeBoeRequest.getOperationType())))
        {
          localMergeBoeResponse.setERROR_FLAG("N");
          localMergeBoeResponse.setERROR_MESSAGE("无效的操作标识!operationType=" + paramMergeBoeRequest.getOperationType());
        }
        else
        {
          return localIMergeBoeSrvDS.saveMergeBoeSrv(paramMergeBoeRequest);
        }
      }
    }
    catch (Exception localException)
    {
      localMergeBoeResponse.setERROR_FLAG("N");
      localMergeBoeResponse.setERROR_MESSAGE("系统异常" + localException.getMessage());
      this.logger.error("系统异常" + localException.getMessage(), localException);
    }
    return localMergeBoeResponse;
  }
  
  private MergeBoeResponse calcelMergeBoe(MergeBoeRequest paramMergeBoeRequest)
  {
    MergeBoeResponse localMergeBoeResponse = new MergeBoeResponse();
    String str = "update evs.evs_image ei set ei.BARCODE = DETAIL_BOE_NUM where ei.BARCODE = ?";
    IImageCommonDS localIImageCommonDS = (IImageCommonDS)SSBBus.findDomainService("imageCommonDS");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramMergeBoeRequest.getBOE_NUM());
    localIImageCommonDS.executeSql(str, localArrayList);
    localMergeBoeResponse.setERROR_FLAG("Y");
    localMergeBoeResponse.setERROR_MESSAGE("取消合并单据关系成功!");
    return localMergeBoeResponse;
  }
  
  private MergeBoeResponse mergeBoe(MergeBoeRequest paramMergeBoeRequest)
  {
    MergeBoeResponse localMergeBoeResponse = new MergeBoeResponse();
    String str1 = "update evs.evs_image ei set ei.BARCODE = ? where ei.BARCODE in(";
    IImageCommonDS localIImageCommonDS = (IImageCommonDS)SSBBus.findDomainService("imageCommonDS");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramMergeBoeRequest.getBOE_NUM());
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
        localIImageCommonDS.executeSql(str4, localArrayList);
        localArrayList.clear();
        localArrayList.add(paramMergeBoeRequest.getBOE_NUM());
        i = 0;
        localStringBuffer = new StringBuffer(str1);
      }
    }
    if (i > 0)
    {
      String str2 = localStringBuffer.substring(0, localStringBuffer.length() - 1).concat(")");
      localIImageCommonDS.executeSql(str2, localArrayList);
    }
    localMergeBoeResponse.setERROR_FLAG("Y");
    localMergeBoeResponse.setERROR_MESSAGE("合并单据关系维护成功!");
    return localMergeBoeResponse;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.mergeBoeSrv.service.MergeBoeSrvSoapBindingImpl
 * JD-Core Version:    0.7.0.1
 */