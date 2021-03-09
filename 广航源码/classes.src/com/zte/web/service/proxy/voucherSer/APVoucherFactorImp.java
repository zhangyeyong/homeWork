package com.zte.web.service.proxy.voucherSer;

import com.cmcc.mss.sb_fi_ap_inquiryapjournalinfosrv.InquiryAPJournalInfoSrvOutputItem;
import com.cmcc.mss.sb_fi_ap_inquiryapjournalinfosrv.JournalAccountingInfoCollection;
import com.cmcc.mss.sb_fi_ap_inquiryapjournalinfosrv.JournalAccountingInfoItem;
import com.zte.evs.ebill.model.eBillManage.EvsVoucher;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherLine;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import javax.xml.datatype.XMLGregorianCalendar;

public class APVoucherFactorImp
  implements APVoucherFactor
{
  public static final String sourceStr = "接口平台导入";
  public static final String UNMATCH = "UNMATCH";
  
  public EvsVoucher impApVoucherBeanToEvsVocher(InquiryAPJournalInfoSrvOutputItem paramInquiryAPJournalInfoSrvOutputItem)
  {
    EvsVoucher localEvsVoucher = new EvsVoucher();
    if (paramInquiryAPJournalInfoSrvOutputItem.getORGID() != null) {
      localEvsVoucher.setOuId(Long.valueOf(paramInquiryAPJournalInfoSrvOutputItem.getORGID().longValue()));
    }
    localEvsVoucher.setOuName(paramInquiryAPJournalInfoSrvOutputItem.getORGNAME());
    localEvsVoucher.setSetBookName(paramInquiryAPJournalInfoSrvOutputItem.getSETOFBOOKS());
    localEvsVoucher.setPeriodName(paramInquiryAPJournalInfoSrvOutputItem.getPERIODNAME());
    localEvsVoucher.setVendorNumber(paramInquiryAPJournalInfoSrvOutputItem.getVENDORNUMBER());
    localEvsVoucher.setVendorName(paramInquiryAPJournalInfoSrvOutputItem.getVENDORNAME());
    localEvsVoucher.setVendorLocation(paramInquiryAPJournalInfoSrvOutputItem.getVENDORSITECODE());
    localEvsVoucher.setJournalNum(paramInquiryAPJournalInfoSrvOutputItem.getJOURNALNUM());
    localEvsVoucher.setJournalName(paramInquiryAPJournalInfoSrvOutputItem.getJOURNALNAME());
    localEvsVoucher.setInvoiceType(paramInquiryAPJournalInfoSrvOutputItem.getJOURNALTYPE());
    localEvsVoucher.setEventTypeName(paramInquiryAPJournalInfoSrvOutputItem.getEVENTTYPENAME());
    localEvsVoucher.setBatchName(paramInquiryAPJournalInfoSrvOutputItem.getBATCHNAME());
    if (paramInquiryAPJournalInfoSrvOutputItem.getINVOICEID() != null) {
      localEvsVoucher.setInvoiceId(Long.valueOf(paramInquiryAPJournalInfoSrvOutputItem.getINVOICEID().longValue()));
    }
    localEvsVoucher.setInvoiceNum(paramInquiryAPJournalInfoSrvOutputItem.getINVOICENUM());
    localEvsVoucher.setBoeNum(paramInquiryAPJournalInfoSrvOutputItem.getBOENUM());
    localEvsVoucher.setCurrencyCode(paramInquiryAPJournalInfoSrvOutputItem.getCURRENCYCODE());
    localEvsVoucher.setSource(paramInquiryAPJournalInfoSrvOutputItem.getSOURCE());
    localEvsVoucher.setSourceCode(paramInquiryAPJournalInfoSrvOutputItem.getSOURCECODE());
    localEvsVoucher.setOrgCharge(paramInquiryAPJournalInfoSrvOutputItem.getORGCHARGE());
    localEvsVoucher.setUserName(paramInquiryAPJournalInfoSrvOutputItem.getCREATEDBY());
    if (paramInquiryAPJournalInfoSrvOutputItem.getCREATEDDATE() != null) {
      localEvsVoucher.setCreatedDate(paramInquiryAPJournalInfoSrvOutputItem.getCREATEDDATE().toGregorianCalendar().getTime());
    }
    if (paramInquiryAPJournalInfoSrvOutputItem.getACCOUNTINGDATE() != null) {
      localEvsVoucher.setJournalDate(paramInquiryAPJournalInfoSrvOutputItem.getACCOUNTINGDATE().toGregorianCalendar().getTime());
    }
    localEvsVoucher.setApprover(paramInquiryAPJournalInfoSrvOutputItem.getAPPROVER());
    if (paramInquiryAPJournalInfoSrvOutputItem.getAPPROVEDDATE() != null) {
      localEvsVoucher.setApproverDate(paramInquiryAPJournalInfoSrvOutputItem.getAPPROVEDDATE().toGregorianCalendar().getTime());
    }
    if (paramInquiryAPJournalInfoSrvOutputItem.getATTACHMENTNUM() != null) {
      localEvsVoucher.setBillNum(paramInquiryAPJournalInfoSrvOutputItem.getATTACHMENTNUM().toString());
    }
    if (paramInquiryAPJournalInfoSrvOutputItem.getLASTUPDATEDATE() != null) {
      localEvsVoucher.setLastUpdateDate(paramInquiryAPJournalInfoSrvOutputItem.getLASTUPDATEDATE().toGregorianCalendar().getTime());
    }
    localEvsVoucher.setCreatedBy(Long.valueOf(-1L));
    localEvsVoucher.setLastUpdateBy(Long.valueOf(-1L));
    localEvsVoucher.setVoucherStatus("UNMATCH");
    localEvsVoucher.setUpdateStatus("0");
    localEvsVoucher.setUpdateHistoryStatus("0");
    return localEvsVoucher;
  }
  
  public List<EvsVoucherLine> impApVoucherLineToEvsVocherLine(InquiryAPJournalInfoSrvOutputItem paramInquiryAPJournalInfoSrvOutputItem, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInquiryAPJournalInfoSrvOutputItem.getJOURNALACCOUNTINGINFO() != null)
    {
      Iterator localIterator = paramInquiryAPJournalInfoSrvOutputItem.getJOURNALACCOUNTINGINFO().getJOURNALACCOUNTINGINFOITEM().iterator();
      while (localIterator.hasNext())
      {
        JournalAccountingInfoItem localJournalAccountingInfoItem = (JournalAccountingInfoItem)localIterator.next();
        EvsVoucherLine localEvsVoucherLine = new EvsVoucherLine();
        if (localJournalAccountingInfoItem.getLINENUM() != null) {
          localEvsVoucherLine.setLineNum(Long.valueOf(localJournalAccountingInfoItem.getLINENUM().longValue()));
        }
        localEvsVoucherLine.setLineDesc(localJournalAccountingInfoItem.getLINEDESC());
        if (localJournalAccountingInfoItem.getCODECOMBINATIONID() != null) {
          localEvsVoucherLine.setCodeId(Long.valueOf(localJournalAccountingInfoItem.getCODECOMBINATIONID().longValue()));
        }
        localEvsVoucherLine.setAccountDesc(localJournalAccountingInfoItem.getACCOUNTDESC());
        if (localJournalAccountingInfoItem.getEXCHANGERATE() != null) {
          localEvsVoucherLine.setConverRate(new Long(localJournalAccountingInfoItem.getEXCHANGERATE()));
        }
        localEvsVoucherLine.setAccCr(localJournalAccountingInfoItem.getACCOUNTEDCR());
        localEvsVoucherLine.setAccDr(localJournalAccountingInfoItem.getACCOUNTEDDR());
        if (localJournalAccountingInfoItem.getLASTUPDATEDATE() != null) {
          localEvsVoucherLine.setLastUpdateDate(localJournalAccountingInfoItem.getLASTUPDATEDATE().toGregorianCalendar().getTime());
        }
        localEvsVoucherLine.setVoucherId(Long.valueOf(paramLong));
        localEvsVoucherLine.setVoucherType("应付");
        localArrayList.add(localEvsVoucherLine);
      }
    }
    return localArrayList;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.proxy.voucherSer.APVoucherFactorImp
 * JD-Core Version:    0.7.0.1
 */