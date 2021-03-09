package com.zte.web.service.proxy.voucherSer;

import com.cmcc.mss.sb_fi_ar_inquiryarjournalinfosrv.InquiryARJournalInfoSrvOutputItem;
import com.cmcc.mss.sb_fi_ar_inquiryarjournalinfosrv.JournalAccountingInfoCollection;
import com.cmcc.mss.sb_fi_ar_inquiryarjournalinfosrv.JournalAccountingInfoItem;
import com.zte.evs.ebill.model.eBillManage.EvsVoucher;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherLine;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import javax.xml.datatype.XMLGregorianCalendar;

public class ARVoucherFactorImp
  implements ARVoucherFactor
{
  public static final String sourceStr = "接口平台导入";
  public static final String UNMATCH = "UNMATCH";
  
  public EvsVoucher impVoucherToEvsVocher(InquiryARJournalInfoSrvOutputItem paramInquiryARJournalInfoSrvOutputItem)
  {
    EvsVoucher localEvsVoucher = new EvsVoucher();
    if (paramInquiryARJournalInfoSrvOutputItem.getORGID() != null) {
      localEvsVoucher.setOuId(Long.valueOf(paramInquiryARJournalInfoSrvOutputItem.getORGID().longValue()));
    }
    localEvsVoucher.setOuName(paramInquiryARJournalInfoSrvOutputItem.getORGNAME());
    localEvsVoucher.setSetBookName(paramInquiryARJournalInfoSrvOutputItem.getSETOFBOOKS());
    localEvsVoucher.setPeriodName(paramInquiryARJournalInfoSrvOutputItem.getPERIODNAME());
    localEvsVoucher.setVendorNumber(paramInquiryARJournalInfoSrvOutputItem.getCUSTOMERNUMBER());
    localEvsVoucher.setVendorName(paramInquiryARJournalInfoSrvOutputItem.getCUSTOMERNAME());
    localEvsVoucher.setVendorLocation(paramInquiryARJournalInfoSrvOutputItem.getADDRESS());
    localEvsVoucher.setJournalNum(paramInquiryARJournalInfoSrvOutputItem.getJOURNALNUM());
    localEvsVoucher.setJournalName(paramInquiryARJournalInfoSrvOutputItem.getJOURNALNAME());
    localEvsVoucher.setInvoiceType(paramInquiryARJournalInfoSrvOutputItem.getJOURNALTYPE());
    localEvsVoucher.setBoeNum(paramInquiryARJournalInfoSrvOutputItem.getBOENUM());
    localEvsVoucher.setCurrencyCode(paramInquiryARJournalInfoSrvOutputItem.getCURRENCYCODE());
    localEvsVoucher.setSource(paramInquiryARJournalInfoSrvOutputItem.getSOURCE());
    localEvsVoucher.setSourceCode(paramInquiryARJournalInfoSrvOutputItem.getSOURCECODE());
    localEvsVoucher.setOrgCharge(paramInquiryARJournalInfoSrvOutputItem.getORGCHARGE());
    localEvsVoucher.setUserName(paramInquiryARJournalInfoSrvOutputItem.getCREATEDBY());
    if (paramInquiryARJournalInfoSrvOutputItem.getCREATEDDATE() != null) {
      localEvsVoucher.setCreatedDate(paramInquiryARJournalInfoSrvOutputItem.getCREATEDDATE().toGregorianCalendar().getTime());
    }
    if (paramInquiryARJournalInfoSrvOutputItem.getACCOUNTINGDATE() != null) {
      localEvsVoucher.setJournalDate(paramInquiryARJournalInfoSrvOutputItem.getACCOUNTINGDATE().toGregorianCalendar().getTime());
    }
    localEvsVoucher.setApprover(paramInquiryARJournalInfoSrvOutputItem.getAPPROVER());
    if (paramInquiryARJournalInfoSrvOutputItem.getAPPROVEDDATE() != null) {
      localEvsVoucher.setApproverDate(paramInquiryARJournalInfoSrvOutputItem.getAPPROVEDDATE().toGregorianCalendar().getTime());
    }
    if (paramInquiryARJournalInfoSrvOutputItem.getATTACHMENTNUM() != null) {
      localEvsVoucher.setBillNum(paramInquiryARJournalInfoSrvOutputItem.getATTACHMENTNUM().toString());
    }
    if (paramInquiryARJournalInfoSrvOutputItem.getLASTUPDATEDATE() != null) {
      localEvsVoucher.setLastUpdateDate(paramInquiryARJournalInfoSrvOutputItem.getLASTUPDATEDATE().toGregorianCalendar().getTime());
    }
    localEvsVoucher.setCreatedBy(Long.valueOf(-1L));
    localEvsVoucher.setLastUpdateBy(Long.valueOf(-1L));
    localEvsVoucher.setVoucherStatus("UNMATCH");
    localEvsVoucher.setUpdateStatus("0");
    localEvsVoucher.setUpdateHistoryStatus("0");
    return localEvsVoucher;
  }
  
  public List<EvsVoucherLine> impVoucherLineToEvsVocherLine(InquiryARJournalInfoSrvOutputItem paramInquiryARJournalInfoSrvOutputItem, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInquiryARJournalInfoSrvOutputItem.getJOURNALACCOUNTINGINFO() != null)
    {
      Iterator localIterator = paramInquiryARJournalInfoSrvOutputItem.getJOURNALACCOUNTINGINFO().getJOURNALACCOUNTINGINFOITEM().iterator();
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
        localEvsVoucherLine.setVoucherType("应收");
        localArrayList.add(localEvsVoucherLine);
      }
    }
    return localArrayList;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.proxy.voucherSer.ARVoucherFactorImp
 * JD-Core Version:    0.7.0.1
 */