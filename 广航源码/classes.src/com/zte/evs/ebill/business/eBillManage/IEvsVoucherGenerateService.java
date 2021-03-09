package com.zte.evs.ebill.business.eBillManage;

import com.zte.eas.appframe.business.bulletinmanager.model.FbpBulletinsV;
import com.zte.eimage.business.baseconfig.model.EidImageMemoV;
import com.zte.evs.ebill.model.eBillManage.EvsImage;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherCheckHistories;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherSelect;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherV;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherVSec;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.web.service.client.getUrlServiceSrv.FileModel;
import java.util.List;
import java.util.Map;

public abstract interface IEvsVoucherGenerateService
{
  public abstract TableDataInfo getHeaderList(EvsVoucherSelect paramEvsVoucherSelect, int paramInt1, int paramInt2);
  
  public abstract TableDataInfo getVoucherSubmitList(EvsVoucherSelect paramEvsVoucherSelect, int paramInt1, int paramInt2);
  
  public abstract Map<String, Object> getAllImageByVoucherId(Long paramLong1, Long paramLong2, int paramInt1, int paramInt2);
  
  public abstract String findImageCurPage(Long paramLong1, Long paramLong2, int paramInt1, int paramInt2);
  
  public abstract int updateHeader(List<String> paramList);
  
  public abstract List getImageList(String paramString1, String paramString2);
  
  public abstract List getImage(String paramString);
  
  public abstract List getImageList(List paramList);
  
  public abstract List<EvsVoucherCheckHistories> getEvsVoucherCheckHistories(String paramString);
  
  public abstract TableDataInfo getHeaderList2(EvsVoucherSelect paramEvsVoucherSelect, int paramInt1, int paramInt2);
  
  public abstract PageInfo getImageAccessory(String paramString, int paramInt1, int paramInt2);
  
  public abstract TableDataInfo getPrintHeaderList(EvsVoucherSelect paramEvsVoucherSelect, int paramInt1, int paramInt2);
  
  public abstract PageInfo getImage(Long paramLong, int paramInt1, int paramInt2);
  
  public abstract List<FileModel> getAccess(Long paramLong);
  
  public abstract PageInfo getImageList(String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public abstract List getAllImageByBookId(String paramString);
  
  public abstract List findVoucherByVoucherId(String paramString);
  
  public abstract List<FileModel> getAccessx(String paramString);
  
  public abstract List<EidImageMemoV> getImageMemoInfo(String paramString);
  
  public abstract PageInfo getAllImageByBookId(String paramString, int paramInt1, int paramInt2);
  
  public abstract String getAllInfoPrint(EvsVoucherSelect paramEvsVoucherSelect);
  
  public abstract List<EvsVoucherVSec> importExcel(FbpBulletinsV paramFbpBulletinsV);
  
  public abstract TableDataInfo importExcelData(List<EvsVoucherV> paramList, int paramInt1, int paramInt2);
  
  public abstract TableDataInfo getImageNumber(EvsImage paramEvsImage, int paramInt1, int paramInt2);
  
  public abstract List getImageList(String paramString);
  
  public abstract TableDataInfo getHeaderListForFascicile(EvsVoucherSelect paramEvsVoucherSelect, int paramInt1, int paramInt2);
  
  public abstract void updateVoucherFlag(String[] paramArrayOfString, String paramString);
  
  public abstract List<EvsVoucherV> getHeaderListForFascicileByList(EvsVoucherSelect paramEvsVoucherSelect);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.eBillManage.IEvsVoucherGenerateService
 * JD-Core Version:    0.7.0.1
 */