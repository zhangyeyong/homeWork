package com.zte.evs.ebill.business.eBillManage;

import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.eas.appframe.business.bulletinmanager.model.FbpBulletinsV;
import com.zte.eas.appframe.business.util.ParsePerportiesTool;
import com.zte.eimage.access.baseconfig.dao.IEidImageInfosDAO;
import com.zte.eimage.access.baseconfig.dao.IEidImageMemoVDAO;
import com.zte.eimage.access.baseconfig.dao.IImageCommonDAO;
import com.zte.eimage.access.common.dao.IImageDisplayDAO;
import com.zte.eimage.business.baseconfig.model.EidImageInfos;
import com.zte.eimage.business.baseconfig.model.EidImageMemoV;
import com.zte.evs.ebill.access.eBillManage.EvsVoucherCheckFindDAO;
import com.zte.evs.ebill.access.eBillManage.IEvsPackageDAO;
import com.zte.evs.ebill.access.eBillManage.IEvsVoucherDAO;
import com.zte.evs.ebill.access.eBillManage.IEvsVoucherGenerateDAO;
import com.zte.evs.ebill.access.eBillManage.IEvsVoucherHistoryDAO;
import com.zte.evs.ebill.common.EvsObjectUtils;
import com.zte.evs.ebill.model.eBillManage.EvsImage;
import com.zte.evs.ebill.model.eBillManage.EvsVoucher;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherCheckHistories;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherSelect;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherV;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherVSec;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.util.Util;
import com.zte.ssb.servicecontainer.business.server.RIAContext;
import com.zte.web.service.client.getUrlServiceSrv.FileModel;
import com.zte.web.service.client.getUrlServiceSrv.GetFileAndContractUrlDS;
import com.zte.web.service.client.getUrlServiceSrv.GetFileAndContractUrlDSServiceLocator;
import com.zte.web.service.client.getUrlServiceSrv.RequestModel;
import com.zte.web.service.client.getUrlServiceSrv.ResponseModel;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;

public class EvsVoucherGenerateService
  implements IEvsVoucherGenerateService
{
  private IEvsVoucherGenerateDAO evsVoucherGenerateDAO;
  private IEvsVoucherHistoryDAO evsVoucherHistoryDAO;
  private EvsVoucherCheckFindDAO evsVoucherCheckFindDAO;
  private IEvsVoucherDAO evsVoucherDAO;
  private IEidImageMemoVDAO eidImageMemoVDAO;
  Logger logger = Logger.getLogger(EvsVoucherGenerateService.class);
  DecimalFormat formatter = new DecimalFormat("#############.##");
  private static List<EvsVoucherVSec> imptRates = new ArrayList();
  
  public TableDataInfo getHeaderList(EvsVoucherSelect paramEvsVoucherSelect, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    Map localMap = this.evsVoucherGenerateDAO.findEmployeeHeaderByQry(paramEvsVoucherSelect, paramInt1, paramInt2);
    localTableDataInfo.setData((List)localMap.get("data"));
    localTableDataInfo.setTotalCount(Integer.parseInt(localMap.get("totalCount").toString()));
    return localTableDataInfo;
  }
  
  public TableDataInfo getHeaderListForFascicile(EvsVoucherSelect paramEvsVoucherSelect, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    Map localMap = this.evsVoucherGenerateDAO.findVoucherForFascicule(paramEvsVoucherSelect, paramInt1, paramInt2);
    localTableDataInfo.setData((List)localMap.get("data"));
    localTableDataInfo.setTotalCount(Integer.parseInt(localMap.get("totalCount").toString()));
    return localTableDataInfo;
  }
  
  public List<EvsVoucherV> getHeaderListForFascicileByList(EvsVoucherSelect paramEvsVoucherSelect)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    List localList = this.evsVoucherGenerateDAO.findVoucherForFasciculeByList(paramEvsVoucherSelect);
    return localList;
  }
  
  public void updateVoucherFlag(String[] paramArrayOfString, String paramString)
  {
    for (int i = 0; i < paramArrayOfString.length; i++)
    {
      Long localLong = Long.valueOf(paramArrayOfString[i]);
      this.evsVoucherGenerateDAO.updateVoucherFlag(localLong.longValue(), paramString);
    }
  }
  
  public TableDataInfo getHeaderList2(EvsVoucherSelect paramEvsVoucherSelect, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    Map localMap = this.evsVoucherGenerateDAO.findEmployeeHeaderByPyVc(paramEvsVoucherSelect, paramInt1, paramInt2);
    localTableDataInfo.setData((List)localMap.get("data"));
    localTableDataInfo.setTotalCount(Integer.parseInt(localMap.get("totalCount").toString()));
    return localTableDataInfo;
  }
  
  public int updateHeader(List<String> paramList)
  {
    int i = 0;
    StringBuffer localStringBuffer = new StringBuffer();
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    for (int j = 0; j < paramList.size(); j++) {
      if (j == 0) {
        localStringBuffer.append("(" + (String)paramList.get(j));
      } else {
        localStringBuffer.append("," + (String)paramList.get(j));
      }
    }
    if ((localStringBuffer != null) && (localStringBuffer.length() > 0)) {
      localStringBuffer.append(")");
    }
    try
    {
      Object localObject = null;
      String str1 = "";
      this.logger.error("headerIds.size=" + paramList.size());
      for (int k = 0; k < paramList.size(); k++)
      {
        this.logger.error("headerIds.get(i)=" + (String)paramList.get(k));
        String str2 = this.evsVoucherGenerateDAO.getsubDocName((String)paramList.get(k));
        this.logger.error("subDocName=" + str2);
        if (!Util.isStrEmpty(str2))
        {
          str1 = this.evsVoucherGenerateDAO.getCheckPersonName(str2);
          this.logger.error("checkPersonId=" + str1);
          if (!Util.isStrEmpty(str1))
          {
            this.evsVoucherGenerateDAO.update("SUBMITED", ((String)paramList.get(k)).toString());
            this.logger.error("update--------" + str1);
            this.evsVoucherGenerateDAO.saveVoucherByVoucherId(str1, ((String)paramList.get(k)).toString());
            this.logger.error("saveVoucherByVoucherId--------" + str1);
            i++;
          }
        }
      }
    }
    catch (Exception localException) {}
    this.logger.error("count--------" + i);
    return i;
  }
  
  public Map<String, Object> getAllImageByVoucherId(Long paramLong1, Long paramLong2, int paramInt1, int paramInt2)
  {
    return this.evsVoucherGenerateDAO.getAllImageByVoucherId(paramLong1, paramLong2, paramInt1, paramInt2);
  }
  
  public String findImageCurPage(Long paramLong1, Long paramLong2, int paramInt1, int paramInt2)
  {
    return this.evsVoucherGenerateDAO.findImageCurPage(paramLong1, paramLong2, paramInt1, paramInt2);
  }
  
  public IEvsVoucherGenerateDAO getEvsVoucherGenerateDAO()
  {
    return this.evsVoucherGenerateDAO;
  }
  
  public void setEvsVoucherGenerateDAO(IEvsVoucherGenerateDAO paramIEvsVoucherGenerateDAO)
  {
    this.evsVoucherGenerateDAO = paramIEvsVoucherGenerateDAO;
  }
  
  public TableDataInfo getVoucherSubmitList(EvsVoucherSelect paramEvsVoucherSelect, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    Map localMap = this.evsVoucherGenerateDAO.findVoucherSubmit(paramEvsVoucherSelect, paramInt1, paramInt2);
    localTableDataInfo.setData((List)localMap.get("data"));
    localTableDataInfo.setTotalCount(Integer.parseInt(localMap.get("totalCount").toString()));
    return localTableDataInfo;
  }
  
  public List getImageList(String paramString1, String paramString2)
  {
    List localList = this.evsVoucherGenerateDAO.findImage(Long.valueOf(Long.parseLong(paramString1)), paramString2);
    return localList;
  }
  
  public PageInfo getImageList(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (paramInt2 <= 0) {
      paramInt2 = 10000000;
    }
    PageInfo localPageInfo = this.evsVoucherGenerateDAO.findImage(Long.valueOf(Long.parseLong(paramString1)), "ALL", paramInt1, paramInt2);
    return localPageInfo;
  }
  
  public List getAllImageByBookId(String paramString)
  {
    Object localObject1 = new ArrayList();
    IEvsPackageDAO localIEvsPackageDAO = (IEvsPackageDAO)SSBBus.findDomainService("packageDAO");
    List localList = localIEvsPackageDAO.getVoucherById(paramString);
    if ((localList == null) || (localList.isEmpty())) {
      return localObject1;
    }
    IImageDisplayDAO localIImageDisplayDAO = (IImageDisplayDAO)SSBBus.findDomainService("imageDisplayDAO");
    String str = "select v.journal_num,i.webhost_url,i.image_url,i.local_path from evs_voucher v,evs_image i where i.voucher_id = v.voucher_id";
    StringBuffer localStringBuffer = new StringBuffer(" and (v.voucher_id in (");
    for (int i = 0; i < localList.size(); i++)
    {
      localStringBuffer.append("?,");
      if ((i > 0) && (i % 999 == 0) && (i < localList.size() - 1))
      {
        localStringBuffer = new StringBuffer(localStringBuffer.substring(0, localStringBuffer.length() - 1));
        localStringBuffer.append(") or v.voucher_id in(");
      }
    }
    localStringBuffer = new StringBuffer(localStringBuffer.substring(0, localStringBuffer.length() - 1) + ")) ");
    str = str + localStringBuffer;
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    if (localRIAContext != null)
    {
      localObject2 = localIImageDisplayDAO.getRoleId();
      if ((localObject2 == null) || (((String)localObject2).equals("")) || ((localObject2 != null) && (!((String)localObject2).equals("100000")))) {
        str = str + " and ( i.is_Show_Image is null or i.is_Show_Image = 'Y')";
      }
    }
    str = str + " order by i.voucher_id,i.barcode desc,i.origin_image_id,i.image_id";
    Object localObject2 = (IImageCommonDAO)SSBBus.findDomainService("imageCommonDAO");
    localObject1 = ((IImageCommonDAO)localObject2).findObjectBySQL(str, localList);
    return localObject1;
  }
  
  public PageInfo getAllImageByBookId(String paramString, int paramInt1, int paramInt2)
  {
    PageInfo localPageInfo = this.evsVoucherGenerateDAO.getAllImageByBookIdNew(Long.valueOf(paramString), paramInt1, paramInt2);
    return localPageInfo;
  }
  
  public List getImage(String paramString)
  {
    List localList = this.evsVoucherGenerateDAO.findImageByVoucherId(Long.valueOf(Long.parseLong(paramString)));
    return localList;
  }
  
  public List findVoucherByVoucherId(String paramString)
  {
    List localList = this.evsVoucherGenerateDAO.findVoucherByVoucherId(Long.valueOf(Long.parseLong(paramString)));
    return localList;
  }
  
  public PageInfo getImage(Long paramLong, int paramInt1, int paramInt2)
  {
    PageInfo localPageInfo = this.evsVoucherGenerateDAO.findImageByVoucherId(paramLong, paramInt1, paramInt2);
    return localPageInfo;
  }
  
  public IEvsVoucherHistoryDAO getEvsVoucherHistoryDAO()
  {
    return this.evsVoucherHistoryDAO;
  }
  
  public void setEvsVoucherHistoryDAO(IEvsVoucherHistoryDAO paramIEvsVoucherHistoryDAO)
  {
    this.evsVoucherHistoryDAO = paramIEvsVoucherHistoryDAO;
  }
  
  public EvsVoucherCheckFindDAO getEvsVoucherCheckFindDAO()
  {
    return this.evsVoucherCheckFindDAO;
  }
  
  public void setEvsVoucherCheckFindDAO(EvsVoucherCheckFindDAO paramEvsVoucherCheckFindDAO)
  {
    this.evsVoucherCheckFindDAO = paramEvsVoucherCheckFindDAO;
  }
  
  public List getImageList(List paramList)
  {
    return this.evsVoucherGenerateDAO.getImageList(paramList);
  }
  
  public List<EvsVoucherCheckHistories> getEvsVoucherCheckHistories(String paramString)
  {
    List localList = null;
    if (paramString != null)
    {
      long l = Long.parseLong(paramString);
      localList = this.evsVoucherGenerateDAO.findVoucherId(Long.valueOf(l));
    }
    return localList;
  }
  
  public PageInfo getImageAccessory(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramString != null) && (!"".equals(paramString))) {
      return this.evsVoucherGenerateDAO.getImageAccessory(paramString, paramInt1, paramInt2);
    }
    return new PageInfo();
  }
  
  public TableDataInfo getPrintHeaderList(EvsVoucherSelect paramEvsVoucherSelect, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    Map localMap = this.evsVoucherGenerateDAO.findPrintVoucher(paramEvsVoucherSelect, paramInt1, paramInt2);
    localTableDataInfo.setData((List)localMap.get("data"));
    localTableDataInfo.setTotalCount(Integer.parseInt(localMap.get("totalCount").toString()));
    return localTableDataInfo;
  }
  
  public List<FileModel> getAccess(Long paramLong)
  {
    EvsVoucher localEvsVoucher = this.evsVoucherDAO.findEvsVoucherVByVoucherId(paramLong);
    String str = localEvsVoucher.getBoeNum();
    return getAccessx(str);
  }
  
  public List<FileModel> getAccessx(String paramString)
  {
    this.logger.error("getAccessx begin");
    ArrayList localArrayList = new ArrayList();
    try
    {
      if (StringUtils.isNotBlank(paramString))
      {
        int i = paramString.indexOf("#");
        if (i > -1) {
          paramString = paramString.substring(0, i);
        }
        this.logger.error("boeNum = " + paramString);
        IEidImageInfosDAO localIEidImageInfosDAO = (IEidImageInfosDAO)SSBBus.findDaoService("eidImageInfosDAO");
        EidImageInfos localEidImageInfos = localIEidImageInfosDAO.findEidImageInfoByImageNumber(paramString);
        if (localEidImageInfos == null) {
          return localArrayList;
        }
        GetFileAndContractUrlDS localGetFileAndContractUrlDS = new GetFileAndContractUrlDSServiceLocator().getGetUrlService();
        RequestModel localRequestModel = new RequestModel();
        this.logger.error("task = " + localEidImageInfos.getTaskNum());
        localRequestModel.setBoeNum(localEidImageInfos.getTaskNum());
        ResponseModel localResponseModel = localGetFileAndContractUrlDS.getUrl(localRequestModel);
        if ((localResponseModel != null) && (localResponseModel.getFile() != null))
        {
          localArrayList.addAll(Arrays.asList(localResponseModel.getFile()));
          this.logger.error("获取附件信息成功!");
        }
        else
        {
          this.logger.error("该报账单没有附件信息");
        }
      }
      else
      {
        this.logger.error("boeNum is null");
      }
    }
    catch (Exception localException)
    {
      this.logger.error(paramString + ",获取附件信息错误:", localException);
    }
    return localArrayList;
  }
  
  public List<EidImageMemoV> getImageMemoInfo(String paramString)
  {
    this.logger.error("getAccessx begin");
    Object localObject = new ArrayList();
    try
    {
      if (StringUtils.isNotBlank(paramString))
      {
        int i = paramString.indexOf("#");
        if (i > -1) {
          paramString = paramString.substring(0, i);
        }
        this.logger.error("ImageNumber= " + paramString);
        localObject = this.eidImageMemoVDAO.getImageMemoInfo(paramString);
      }
      else
      {
        this.logger.error("ImageNumber is null");
      }
    }
    catch (Exception localException)
    {
      this.logger.error(paramString + ",获取影像信息错误:", localException);
    }
    return localObject;
  }
  
  public IEvsVoucherDAO getEvsVoucherDAO()
  {
    return this.evsVoucherDAO;
  }
  
  public void setEvsVoucherDAO(IEvsVoucherDAO paramIEvsVoucherDAO)
  {
    this.evsVoucherDAO = paramIEvsVoucherDAO;
  }
  
  public IEidImageMemoVDAO getEidImageMemoVDAO()
  {
    return this.eidImageMemoVDAO;
  }
  
  public void setEidImageMemoVDAO(IEidImageMemoVDAO paramIEidImageMemoVDAO)
  {
    this.eidImageMemoVDAO = paramIEidImageMemoVDAO;
  }
  
  public String getAllInfoPrint(EvsVoucherSelect paramEvsVoucherSelect)
  {
    List localList = this.evsVoucherGenerateDAO.getAllInfoPrint(paramEvsVoucherSelect);
    String str = "";
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      EvsVoucherV localEvsVoucherV = (EvsVoucherV)localIterator.next();
      str = str + localEvsVoucherV.getVoucherId() + ",";
    }
    return str;
  }
  
  private Object getSheetValue(HSSFCell paramHSSFCell)
  {
    int i = paramHSSFCell.getCellType();
    Object localObject = null;
    switch (i)
    {
    case 4: 
      localObject = Boolean.valueOf(paramHSSFCell.getBooleanCellValue());
      break;
    case 5: 
      localObject = Byte.valueOf(paramHSSFCell.getErrorCellValue());
      break;
    case 2: 
      localObject = paramHSSFCell.getCellFormula();
      break;
    case 0: 
      if (HSSFDateUtil.isCellDateFormatted(paramHSSFCell)) {
        localObject = paramHSSFCell.getDateCellValue();
      } else {
        localObject = this.formatter.format(paramHSSFCell.getNumericCellValue());
      }
      break;
    case 1: 
      localObject = paramHSSFCell.getStringCellValue();
      break;
    case 3: 
      localObject = "";
    }
    return localObject;
  }
  
  public List<EvsVoucherVSec> importExcel(FbpBulletinsV paramFbpBulletinsV)
  {
    imptRates.clear();
    EvsVoucherVSec localEvsVoucherVSec = null;
    String str1 = paramFbpBulletinsV.getAttribute1();
    String str2 = "";
    InputStream localInputStream = null;
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    String str3 = (String)ParsePerportiesTool.ACCESSORYPATHS_MAP.get("boeTemplateAccessoryPath");
    List localList = (List)localRIAContext.getRequest().getAttribute("FileItemList");
    if (localList == null)
    {
      str2 = "获取文件资源出错";
      System.out.print(str2);
    }
    Iterator localIterator = localList.iterator();
    FileItem localFileItem = null;
    while (localIterator.hasNext())
    {
      localFileItem = (FileItem)localIterator.next();
      try
      {
        localInputStream = localFileItem.getInputStream();
      }
      catch (IOException localIOException1)
      {
        localIOException1.printStackTrace();
      }
    }
    Workbook localWorkbook = null;
    try
    {
      localWorkbook = Workbook.getWorkbook(localInputStream);
    }
    catch (IOException localIOException2)
    {
      localIOException2.printStackTrace();
    }
    catch (BiffException localBiffException)
    {
      localBiffException.printStackTrace();
    }
    Sheet localSheet = localWorkbook.getSheet(0);
    if (localSheet == null) {
      return null;
    }
    int i = localSheet.getRows();
    if (i > 0) {
      for (int j = 0; j < i; j++)
      {
        localEvsVoucherVSec = new EvsVoucherVSec();
        Cell localCell1 = localSheet.getCell(0, j);
        if ((localCell1 != null) && (localCell1.getContents() != null) && (!"".equals(localCell1.getContents())))
        {
          Cell localCell2;
          if (str1.equals("imageNumber"))
          {
            localCell2 = localSheet.getCell(0, j);
            localEvsVoucherVSec.setImageNumber(localCell2.getContents());
            imptRates.add(localEvsVoucherVSec);
          }
          if (str1.equals("taskNum"))
          {
            localCell2 = localSheet.getCell(0, j);
            localEvsVoucherVSec.setTaskNum(localCell2.getContents());
            imptRates.add(localEvsVoucherVSec);
          }
        }
      }
    }
    try
    {
      localWorkbook.close();
      localInputStream.close();
    }
    catch (IOException localIOException3)
    {
      localIOException3.printStackTrace();
    }
    return imptRates;
  }
  
  public TableDataInfo importExcelData(List<EvsVoucherV> paramList, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    Map localMap = this.evsVoucherGenerateDAO.findByTaskNumOrImageNum(paramList, paramInt1, paramInt2);
    localTableDataInfo.setData((List)localMap.get("data"));
    localTableDataInfo.setTotalCount(Integer.parseInt(localMap.get("totalCount").toString()));
    return localTableDataInfo;
  }
  
  public TableDataInfo getImageNumber(EvsImage paramEvsImage, int paramInt1, int paramInt2)
  {
    if (paramInt2 <= 0) {
      paramInt2 = 10000;
    }
    TableDataInfo localTableDataInfo = new TableDataInfo();
    PageInfo localPageInfo = this.evsVoucherGenerateDAO.getImageNuberList(paramEvsImage.getVoucherId(), paramInt1, paramInt2);
    localTableDataInfo.setData((List)localPageInfo.getResult());
    if (localTableDataInfo.getData() == null) {
      localTableDataInfo.setData(new ArrayList());
    }
    localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
    return localTableDataInfo;
  }
  
  public List getImageList(String paramString)
  {
    List localList = this.evsVoucherGenerateDAO.findImage(Long.valueOf(Long.parseLong(paramString)));
    return localList;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.eBillManage.EvsVoucherGenerateService
 * JD-Core Version:    0.7.0.1
 */