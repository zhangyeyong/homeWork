package com.zte.evs.ebill.business.eBillManage;

import com.zte.evs.ebill.access.eBillManage.EvsPackageDAO;
import com.zte.evs.ebill.access.eBillManage.EvsVoucherDAO;
import com.zte.evs.ebill.access.eBillManage.IEvsPackageDAO;
import com.zte.evs.ebill.access.eBillManage.IVoucherFlittingDAO;
import com.zte.evs.ebill.model.eBillManage.EvsAllotDetails;
import com.zte.evs.ebill.model.eBillManage.EvsAllotHeadersV;
import com.zte.evs.ebill.model.eBillManage.EvsPackage;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherV;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.util.Util;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class FlittingPrintService
{
  public String printPackage(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (Util.isStrEmpty(paramString)) {
      return "";
    }
    String[] arrayOfString = paramString.split(",");
    String str = arrayOfString[(arrayOfString.length - 1)];
    if ((arrayOfString.length < 2) || (Util.isStrEmpty(str))) {
      return "";
    }
    for (int i = 0; i < arrayOfString.length - 1; i++) {
      localArrayList.add(arrayOfString[i]);
    }
    IVoucherFlittingDAO localIVoucherFlittingDAO = (IVoucherFlittingDAO)SSBBus.findDomainService("voucherFlittingDAO");
    IEvsPackageDAO localIEvsPackageDAO = (IEvsPackageDAO)SSBBus.findDomainService("packageDAO");
    List localList1 = localIVoucherFlittingDAO.findAllotByNum(localArrayList);
    StringBuffer localStringBuffer = new StringBuffer();
    if ((localList1 == null) || (localList1.size() == 0)) {
      return "";
    }
    EvsPackageDAO localEvsPackageDAO = (EvsPackageDAO)SSBBus.findDaoService("packageDAO");
    for (int j = 0; j < localList1.size(); j++)
    {
      EvsAllotHeadersV localEvsAllotHeadersV = (EvsAllotHeadersV)localList1.get(j);
      List localList2 = localIVoucherFlittingDAO.findRelationIdByAllotNum(Long.valueOf(Long.parseLong(localEvsAllotHeadersV.getAllotHeaderId().toString())));
      List localList3 = localIVoucherFlittingDAO.findAllotDetailsByAllotHeaderId(Long.valueOf(Long.parseLong(localEvsAllotHeadersV.getAllotHeaderId().toString())), "FLITTING_FOR_BOX");
      EvsAllotDetails localEvsAllotDetails = null;
      if (localList3.size() > 0) {
        localEvsAllotDetails = (EvsAllotDetails)localList3.get(0);
      }
      Object localObject = new ArrayList();
      if (localEvsAllotDetails != null) {
        localObject = localEvsPackageDAO.getPackageMsg(localEvsAllotDetails.getRelationId());
      }
      localStringBuffer.append("<table style='width:100%;border:0px;text-align:center'  cellspacing='0' cellpadding='0' class='tabp'> <tr  class='tableHeader'>   <td width='3%' >NO.   </td >    <td width='7%'>调拨类型   </td>    <td width='8%'>编号  </td width='8%'>  <td width='8%'>结算单位    </td>     <td width='5%'>操作人    </td>   <td colspan='2' width='10%' >日期   </td>   <td width='5%'>装箱号  </td>   <td width='6%'> 库位  </td> <td width='8%'>凭证号  </td>  <td width='8%'>凭证类型 </td> </tr>  ");
      for (int k = 0; k < ((List)localObject).size(); k++)
      {
        Object[] arrayOfObject = (Object[])((List)localObject).get(j);
        localStringBuffer.append(" <tr>   <td >" + (k + 1) + "   </td >" + "    <td>" + localEvsAllotHeadersV.getAllotModeMeaning() + "   </td>" + "    <td>" + localEvsAllotHeadersV.getAllotNum() + "  </td>" + "        <td >" + localEvsAllotHeadersV.getCompanyName() + "    </td>" + "     <td >" + localEvsAllotHeadersV.getEmployeeName() + "    </td>" + "   <td colspan='2' width='10%' >" + localEvsAllotHeadersV.getAllotDate() + "   </td>" + "   <td>" + arrayOfObject[0] + "  </td>" + "   <td>" + arrayOfObject[1] + "  </td>" + " <td >" + arrayOfObject[2] + "  </td>" + "  <td >" + arrayOfObject[3] + " </td>" + " </tr>  ");
      }
      localStringBuffer.append("</table>");
      localStringBuffer.append("<p>");
    }
    return localStringBuffer.toString();
  }
  
  public String printBooked(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (Util.isStrEmpty(paramString)) {
      return "";
    }
    String[] arrayOfString = paramString.split(",");
    String str1 = arrayOfString[(arrayOfString.length - 1)];
    if ((arrayOfString.length < 2) || (Util.isStrEmpty(str1))) {
      return "";
    }
    for (int i = 0; i < arrayOfString.length - 1; i++) {
      localArrayList.add(arrayOfString[i]);
    }
    IVoucherFlittingDAO localIVoucherFlittingDAO = (IVoucherFlittingDAO)SSBBus.findDomainService("voucherFlittingDAO");
    List localList1 = localIVoucherFlittingDAO.findAllotByNum(localArrayList);
    StringBuffer localStringBuffer = new StringBuffer();
    if ((localList1 == null) || (localList1.size() == 0)) {
      return "";
    }
    EvsPackageDAO localEvsPackageDAO = (EvsPackageDAO)SSBBus.findDaoService("packageDAO");
    for (int j = 0; j < localList1.size(); j++)
    {
      EvsAllotHeadersV localEvsAllotHeadersV = (EvsAllotHeadersV)localList1.get(j);
      List localList2 = localIVoucherFlittingDAO.findRelationIdByAllotNum(Long.valueOf(Long.parseLong(localEvsAllotHeadersV.getAllotHeaderId().toString())));
      List localList3 = localIVoucherFlittingDAO.findAllotDetailsByAllotHeaderId(Long.valueOf(Long.parseLong(localEvsAllotHeadersV.getAllotHeaderId().toString())), "FLITTING_FOR_BOOK");
      EvsAllotDetails localEvsAllotDetails = null;
      String str2 = "";
      String str3 = "";
      if (localList3.size() > 0) {
        localEvsAllotDetails = (EvsAllotDetails)localList3.get(0);
      }
      Object localObject = new ArrayList();
      if (localEvsAllotDetails != null) {
        localObject = localEvsPackageDAO.getBookMsg(localEvsAllotDetails.getRelationId());
      }
      localStringBuffer.append("<table style='width:100%;border:0px;text-align:center'  cellspacing='0' cellpadding='0' class='tabp'> <tr  class='tableHeader'>   <td width='3%' >NO.   </td >    <td width='7%'>调拨类型   </td>    <td width='8%'>编号  </td width='8%'>  <td width='8%'>结算单位    </td>     <td width='5%'>操作人    </td>   <td colspan='2' width='10%' >日期   </td>   <td width='5%'>分册号  </td>   <td width='6%'> 库位  </td> <td width='8%'>凭证号  </td>  <td width='8%'>凭证类型 </td> </tr>  ");
      for (int k = 0; k < ((List)localObject).size(); k++)
      {
        Object[] arrayOfObject = (Object[])((List)localObject).get(j);
        localStringBuffer.append(" <tr>   <td >" + (k + 1) + "   </td >" + "    <td>" + localEvsAllotHeadersV.getAllotModeMeaning() + "   </td>" + "    <td>" + localEvsAllotHeadersV.getAllotNum() + "  </td>" + "        <td >" + localEvsAllotHeadersV.getCompanyName() + "    </td>" + "     <td >" + localEvsAllotHeadersV.getEmployeeName() + "    </td>" + "   <td colspan='2' width='10%' >" + localEvsAllotHeadersV.getAllotDate() + "   </td>" + "   <td>" + arrayOfObject[0] + "  </td>" + "   <td>" + "" + "  </td>" + " <td >" + arrayOfObject[1] + "  </td>" + "  <td >" + arrayOfObject[2] + " </td>" + " </tr>  ");
      }
      localStringBuffer.append("</table>");
      localStringBuffer.append("<p>");
    }
    return localStringBuffer.toString();
  }
  
  public String printAllotBoes(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    if (Util.isStrEmpty(paramString1)) {
      return "";
    }
    String[] arrayOfString1 = paramString1.split(",");
    String str1 = arrayOfString1[(arrayOfString1.length - 1)];
    if ((arrayOfString1.length < 2) || (Util.isStrEmpty(str1)) || (Util.isStrEmpty(paramString2))) {
      return "";
    }
    String[] arrayOfString2 = paramString2.split(",");
    for (int i = 0; i < arrayOfString1.length - 1; i++) {
      localArrayList.add(arrayOfString1[i]);
    }
    IVoucherFlittingDAO localIVoucherFlittingDAO = (IVoucherFlittingDAO)SSBBus.findDomainService("voucherFlittingDAO");
    IEvsPackageDAO localIEvsPackageDAO = (IEvsPackageDAO)SSBBus.findDomainService("packageDAO");
    List localList1 = localIVoucherFlittingDAO.findAllotByNum(localArrayList);
    StringBuffer localStringBuffer = new StringBuffer();
    if ((localList1 == null) || (localList1.size() == 0)) {
      return "";
    }
    EvsPackageDAO localEvsPackageDAO = (EvsPackageDAO)SSBBus.findDaoService("packageDAO");
    EvsVoucherDAO localEvsVoucherDAO = (EvsVoucherDAO)SSBBus.findDaoService("evsVoucherDAO");
    for (int j = 0; j < localList1.size(); j++)
    {
      EvsAllotHeadersV localEvsAllotHeadersV = (EvsAllotHeadersV)localList1.get(j);
      List localList2 = localIVoucherFlittingDAO.findRelationIdByAllotNum(Long.valueOf(Long.parseLong(localEvsAllotHeadersV.getAllotHeaderId().toString())));
      List localList3 = localIVoucherFlittingDAO.findAllotDetailsByAllotHeaderId(Long.valueOf(Long.parseLong(localEvsAllotHeadersV.getAllotHeaderId().toString())), "FLITTING_FOR_BOX");
      EvsAllotDetails localEvsAllotDetails = null;
      String str2 = "";
      String str3 = "";
      if (localList3.size() > 0) {
        localEvsAllotDetails = (EvsAllotDetails)localList3.get(0);
      }
      EvsPackage localEvsPackage = null;
      if (localEvsAllotDetails != null) {
        localEvsPackage = localEvsPackageDAO.getPackageById(localEvsAllotDetails.getRelationId());
      }
      if (localEvsPackage != null)
      {
        str2 = localEvsPackage.getPackageCode();
        str3 = localEvsPackage.getWarehouseCode();
        if ((str3 == null) || (str3.equals(""))) {
          str3 = "";
        }
      }
      localStringBuffer.append("<table style='width:100%;border:0px;text-align:center'  cellspacing='0' cellpadding='0' class='tabp'> <tr  class='tableHeader'>   <td width='3%' >NO.   </td >    <td width='7%'>调拨类型   </td>    <td width='8%'>编号  </td width='8%'>  <td width='8%'>结算单位    </td>     <td width='5%'>操作人    </td>   <td colspan='2' width='10%' >日期   </td>   <td width='5%'>装箱号  </td>   <td width='6%'> 库位  </td> <td width='8%'>凭证号  </td>  <td width='8%'>凭证类型 </td> </tr>  ");
      for (int k = 0; k < arrayOfString2.length; k++)
      {
        EvsVoucherV localEvsVoucherV = localEvsVoucherDAO.findEvsVoucherVByJournalNum(arrayOfString2[j]);
        localStringBuffer.append(" <tr>   <td >" + (k + 1) + "   </td >" + "    <td>" + localEvsAllotHeadersV.getAllotModeMeaning() + "   </td>" + "    <td>" + localEvsAllotHeadersV.getAllotNum() + "  </td>" + "        <td >" + localEvsAllotHeadersV.getCompanyName() + "    </td>" + "     <td >" + localEvsAllotHeadersV.getEmployeeName() + "    </td>" + "   <td colspan='2' width='10%' >" + localEvsAllotHeadersV.getAllotDate() + "   </td>" + "   <td>" + str2 + "  </td>" + "   <td>" + str3 + "  </td>" + " <td >" + arrayOfString2[k] + "  </td>" + "  <td >" + localEvsVoucherV.getInvoiceType() + " </td>" + " </tr>  ");
      }
      localStringBuffer.append("</table>");
      localStringBuffer.append("<p>");
    }
    return localStringBuffer.toString();
  }
  
  public String printAllotBoe(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (Util.isStrEmpty(paramString)) {
      return "";
    }
    String[] arrayOfString = paramString.split(",");
    String str1 = arrayOfString[(arrayOfString.length - 1)];
    if ((arrayOfString.length < 2) || (Util.isStrEmpty(str1))) {
      return "";
    }
    for (int i = 0; i < arrayOfString.length - 1; i++) {
      localArrayList.add(arrayOfString[i]);
    }
    IVoucherFlittingDAO localIVoucherFlittingDAO = (IVoucherFlittingDAO)SSBBus.findDomainService("voucherFlittingDAO");
    IEvsPackageDAO localIEvsPackageDAO = (IEvsPackageDAO)SSBBus.findDomainService("packageDAO");
    List localList1 = localIVoucherFlittingDAO.findAllotByNum(localArrayList);
    StringBuffer localStringBuffer = new StringBuffer();
    if ((localList1 == null) || (localList1.size() == 0)) {
      return "";
    }
    EvsPackageDAO localEvsPackageDAO = (EvsPackageDAO)SSBBus.findDaoService("packageDAO");
    for (int j = 0; j < localList1.size(); j++)
    {
      EvsAllotHeadersV localEvsAllotHeadersV = (EvsAllotHeadersV)localList1.get(j);
      List localList2 = localIVoucherFlittingDAO.findRelationIdByAllotNum(Long.valueOf(Long.parseLong(localEvsAllotHeadersV.getAllotHeaderId().toString())));
      List localList3 = localIVoucherFlittingDAO.findAllotDetailsByAllotHeaderId(Long.valueOf(Long.parseLong(localEvsAllotHeadersV.getAllotHeaderId().toString())), "FLITTING_FOR_BOX");
      EvsAllotDetails localEvsAllotDetails = null;
      String str2 = "";
      String str3 = "";
      if (localList3.size() > 0) {
        localEvsAllotDetails = (EvsAllotDetails)localList3.get(0);
      }
      EvsPackage localEvsPackage = null;
      if (localEvsAllotDetails != null) {
        localEvsPackage = localEvsPackageDAO.getPackageById(localEvsAllotDetails.getRelationId());
      }
      if (localEvsPackage != null)
      {
        str2 = localEvsPackage.getPackageCode();
        str3 = localEvsPackage.getWarehouseCode();
        if ((str3 == null) || (str3.equals(""))) {
          str3 = "";
        }
      }
      localStringBuffer.append("<table style='width:100%;border:0px;text-align:center'  cellspacing='0' cellpadding='0' class='tabp'> <tr  class='tableHeader'>   <td width='3%' >NO.   </td >    <td width='7%'>调拨类型   </td>    <td width='8%'>编号  </td width='8%'>     <td width='5%'>操作人    </td>   <td colspan='2' width='10%' >日期   </td>   <td width='5%'>装箱号  </td>   <td width='6%'> 库位  </td> <td width='8%'>凭证号  </td>  <td width='8%'>凭证类型 </td> </tr>  ");
      localStringBuffer.append(" <tr>   <td >" + (j + 1) + "   </td >" + "    <td>" + localEvsAllotHeadersV.getAllotModeMeaning() + "   </td>" + "    <td>" + localEvsAllotHeadersV.getAllotNum() + "  </td>" + "     <td >" + localEvsAllotHeadersV.getEmployeeName() + "    </td>" + "   <td colspan='2' width='10%' >" + localEvsAllotHeadersV.getAllotDate() + "   </td>" + "   <td>" + str2 + "  </td>" + "   <td>" + str3 + "  </td>" + " <td >" + "" + "  </td>" + "  <td >" + "" + " </td>" + " </tr>  ");
      localStringBuffer.append("</table>");
      localStringBuffer.append("<p>");
    }
    return localStringBuffer.toString();
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.eBillManage.FlittingPrintService
 * JD-Core Version:    0.7.0.1
 */