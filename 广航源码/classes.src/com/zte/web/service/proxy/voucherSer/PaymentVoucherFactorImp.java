package com.zte.web.service.proxy.voucherSer;

import com.cmcc.mss.sb_fi_ap_inquirypaymentjournalinfosrv.InquiryPaymentJournalInfoSrvOutputItem;
import com.cmcc.mss.sb_fi_ap_inquirypaymentjournalinfosrv.JournalAccountingInfoCollection;
import com.cmcc.mss.sb_fi_ap_inquirypaymentjournalinfosrv.JournalAccountingInfoItem;
import com.zte.evs.ebill.model.eBillManage.EvsVoucher;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherLine;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import javax.xml.datatype.XMLGregorianCalendar;

public class PaymentVoucherFactorImp
  implements PaymentVoucherFactor
{
  public static final String sourceStr = "接口平台导入";
  public static final String UNMATCH = "UNMATCH";
  
  public EvsVoucher impVoucherToEvsVocher(InquiryPaymentJournalInfoSrvOutputItem paramInquiryPaymentJournalInfoSrvOutputItem)
  {
    EvsVoucher localEvsVoucher = new EvsVoucher();
    if (paramInquiryPaymentJournalInfoSrvOutputItem.getORGID() != null) {
      localEvsVoucher.setOuId(Long.valueOf(paramInquiryPaymentJournalInfoSrvOutputItem.getORGID().longValue()));
    }
    localEvsVoucher.setOuName(paramInquiryPaymentJournalInfoSrvOutputItem.getORGNAME());
    localEvsVoucher.setSetBookName(paramInquiryPaymentJournalInfoSrvOutputItem.getSETOFBOOKS());
    localEvsVoucher.setPeriodName(paramInquiryPaymentJournalInfoSrvOutputItem.getPERIODNAME());
    localEvsVoucher.setVendorNumber(paramInquiryPaymentJournalInfoSrvOutputItem.getVENDORNUMBER());
    localEvsVoucher.setVendorName(paramInquiryPaymentJournalInfoSrvOutputItem.getVENDORNAME());
    localEvsVoucher.setVendorLocation(paramInquiryPaymentJournalInfoSrvOutputItem.getVENDORSITECODE());
    localEvsVoucher.setJournalNum(paramInquiryPaymentJournalInfoSrvOutputItem.getJOURNALNUM());
    localEvsVoucher.setJournalName(paramInquiryPaymentJournalInfoSrvOutputItem.getJOURNALNAME());
    localEvsVoucher.setInvoiceType(paramInquiryPaymentJournalInfoSrvOutputItem.getJOURNALTYPE());
    if (paramInquiryPaymentJournalInfoSrvOutputItem.getCHECKID() != null) {
      localEvsVoucher.setCheckId(Long.valueOf(paramInquiryPaymentJournalInfoSrvOutputItem.getCHECKID().longValue()));
    }
    if (paramInquiryPaymentJournalInfoSrvOutputItem.getCHECKNUM() != null) {
      localEvsVoucher.setCheckNumber(new Long(paramInquiryPaymentJournalInfoSrvOutputItem.getCHECKNUM()));
    }
    localEvsVoucher.setChequeNumber(paramInquiryPaymentJournalInfoSrvOutputItem.getCHEQUENUM());
    localEvsVoucher.setApJournalNum(paramInquiryPaymentJournalInfoSrvOutputItem.getAPJOURNALNUM());
    localEvsVoucher.setCurrencyCode(paramInquiryPaymentJournalInfoSrvOutputItem.getCURRENCYCODE());
    localEvsVoucher.setSource("接口平台导入");
    localEvsVoucher.setSourceCode(paramInquiryPaymentJournalInfoSrvOutputItem.getSOURCECODE());
    localEvsVoucher.setOrgCharge(paramInquiryPaymentJournalInfoSrvOutputItem.getORGCHARGE());
    localEvsVoucher.setUserName(paramInquiryPaymentJournalInfoSrvOutputItem.getCREATEDBY());
    if (paramInquiryPaymentJournalInfoSrvOutputItem.getCREATEDDATE() != null) {
      localEvsVoucher.setCreatedDate(paramInquiryPaymentJournalInfoSrvOutputItem.getCREATEDDATE().toGregorianCalendar().getTime());
    }
    if (paramInquiryPaymentJournalInfoSrvOutputItem.getACCOUNTINGDATE() != null) {
      localEvsVoucher.setJournalDate(paramInquiryPaymentJournalInfoSrvOutputItem.getACCOUNTINGDATE().toGregorianCalendar().getTime());
    }
    localEvsVoucher.setApprover(paramInquiryPaymentJournalInfoSrvOutputItem.getAPPROVER());
    if (paramInquiryPaymentJournalInfoSrvOutputItem.getAPPROVEDDATE() != null) {
      localEvsVoucher.setApproverDate(paramInquiryPaymentJournalInfoSrvOutputItem.getAPPROVEDDATE().toGregorianCalendar().getTime());
    }
    if (paramInquiryPaymentJournalInfoSrvOutputItem.getATTACHMENTNUM() != null) {
      localEvsVoucher.setBillNum(paramInquiryPaymentJournalInfoSrvOutputItem.getATTACHMENTNUM().toString());
    }
    if (paramInquiryPaymentJournalInfoSrvOutputItem.getLASTUPDATEDATE() != null) {
      localEvsVoucher.setLastUpdateDate(paramInquiryPaymentJournalInfoSrvOutputItem.getLASTUPDATEDATE().toGregorianCalendar().getTime());
    }
    localEvsVoucher.setCreatedBy(Long.valueOf(-1L));
    localEvsVoucher.setLastUpdateBy(Long.valueOf(-1L));
    localEvsVoucher.setVoucherStatus("UNMATCH");
    localEvsVoucher.setUpdateStatus("0");
    localEvsVoucher.setUpdateHistoryStatus("0");
    return localEvsVoucher;
  }
  
  public List<EvsVoucherLine> impVoucherLineToEvsVocherLine(InquiryPaymentJournalInfoSrvOutputItem paramInquiryPaymentJournalInfoSrvOutputItem, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInquiryPaymentJournalInfoSrvOutputItem.getJOURNALACCOUNTINGINFO() != null)
    {
      Iterator localIterator = paramInquiryPaymentJournalInfoSrvOutputItem.getJOURNALACCOUNTINGINFO().getJOURNALACCOUNTINGINFOITEM().iterator();
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
        localEvsVoucherLine.setVoucherType("付款");
        localArrayList.add(localEvsVoucherLine);
      }
    }
    return localArrayList;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.proxy.voucherSer.PaymentVoucherFactorImp
 * JD-Core Version:    0.7.0.1
 */