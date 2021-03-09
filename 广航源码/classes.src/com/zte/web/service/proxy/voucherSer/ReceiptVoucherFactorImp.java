package com.zte.web.service.proxy.voucherSer;

import com.cmcc.mss.sb_fi_ar_inquiryreceiptjournalinfosrv.InquiryReceiptJournalInfoSrvOutputItem;
import com.cmcc.mss.sb_fi_ar_inquiryreceiptjournalinfosrv.JournalAccountingInfoCollection;
import com.cmcc.mss.sb_fi_ar_inquiryreceiptjournalinfosrv.JournalAccountingInfoItem;
import com.zte.evs.ebill.model.eBillManage.EvsVoucher;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherLine;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import javax.xml.datatype.XMLGregorianCalendar;

public class ReceiptVoucherFactorImp
  implements ReceiptVoucherFactor
{
  public static final String sourceStr = "接口平台导入";
  public static final String UNMATCH = "UNMATCH";
  
  public EvsVoucher impVoucherToEvsVocher(InquiryReceiptJournalInfoSrvOutputItem paramInquiryReceiptJournalInfoSrvOutputItem)
  {
    EvsVoucher localEvsVoucher = new EvsVoucher();
    if (paramInquiryReceiptJournalInfoSrvOutputItem.getORGID() != null) {
      localEvsVoucher.setOuId(Long.valueOf(paramInquiryReceiptJournalInfoSrvOutputItem.getORGID().longValue()));
    }
    localEvsVoucher.setOuName(paramInquiryReceiptJournalInfoSrvOutputItem.getORGNAME());
    localEvsVoucher.setSetBookName(paramInquiryReceiptJournalInfoSrvOutputItem.getSETOFBOOKS());
    localEvsVoucher.setPeriodName(paramInquiryReceiptJournalInfoSrvOutputItem.getPERIODNAME());
    localEvsVoucher.setVendorNumber(paramInquiryReceiptJournalInfoSrvOutputItem.getCUSTOMERNUMBER());
    localEvsVoucher.setVendorName(paramInquiryReceiptJournalInfoSrvOutputItem.getCUSTOMERNAME());
    localEvsVoucher.setVendorLocation(paramInquiryReceiptJournalInfoSrvOutputItem.getADDRESS());
    localEvsVoucher.setJournalNum(paramInquiryReceiptJournalInfoSrvOutputItem.getJOURNALNUM());
    localEvsVoucher.setJournalName(paramInquiryReceiptJournalInfoSrvOutputItem.getJOURNALNAME());
    localEvsVoucher.setInvoiceType(paramInquiryReceiptJournalInfoSrvOutputItem.getJOURNALTYPE());
    localEvsVoucher.setReceiptNumber(paramInquiryReceiptJournalInfoSrvOutputItem.getRECEIPTNUMBER());
    localEvsVoucher.setBoeNum(paramInquiryReceiptJournalInfoSrvOutputItem.getBOENUM());
    localEvsVoucher.setCurrencyCode(paramInquiryReceiptJournalInfoSrvOutputItem.getCURRENCYCODE());
    localEvsVoucher.setSource("接口平台导入");
    localEvsVoucher.setSourceCode(paramInquiryReceiptJournalInfoSrvOutputItem.getSOURCECODE());
    localEvsVoucher.setOrgCharge(paramInquiryReceiptJournalInfoSrvOutputItem.getORGCHARGE());
    localEvsVoucher.setUserName(paramInquiryReceiptJournalInfoSrvOutputItem.getUSERNAME());
    if (paramInquiryReceiptJournalInfoSrvOutputItem.getCREATEDDATE() != null) {
      localEvsVoucher.setCreatedDate(paramInquiryReceiptJournalInfoSrvOutputItem.getCREATEDDATE().toGregorianCalendar().getTime());
    }
    if (paramInquiryReceiptJournalInfoSrvOutputItem.getACCOUNTINGDATE() != null) {
      localEvsVoucher.setJournalDate(paramInquiryReceiptJournalInfoSrvOutputItem.getACCOUNTINGDATE().toGregorianCalendar().getTime());
    }
    localEvsVoucher.setApprover(paramInquiryReceiptJournalInfoSrvOutputItem.getAPPROVER());
    if (paramInquiryReceiptJournalInfoSrvOutputItem.getAPPROVEDDATE() != null) {
      localEvsVoucher.setApproverDate(paramInquiryReceiptJournalInfoSrvOutputItem.getAPPROVEDDATE().toGregorianCalendar().getTime());
    }
    if (paramInquiryReceiptJournalInfoSrvOutputItem.getATTACHMENTNUM() != null) {
      localEvsVoucher.setBillNum(paramInquiryReceiptJournalInfoSrvOutputItem.getATTACHMENTNUM().toString());
    }
    if (paramInquiryReceiptJournalInfoSrvOutputItem.getLASTUPDATEDATE() != null) {
      localEvsVoucher.setLastUpdateDate(paramInquiryReceiptJournalInfoSrvOutputItem.getLASTUPDATEDATE().toGregorianCalendar().getTime());
    }
    localEvsVoucher.setCreatedBy(Long.valueOf(-1L));
    localEvsVoucher.setLastUpdateBy(Long.valueOf(-1L));
    localEvsVoucher.setVoucherStatus("UNMATCH");
    localEvsVoucher.setUpdateStatus("0");
    localEvsVoucher.setUpdateHistoryStatus("0");
    return localEvsVoucher;
  }
  
  public List<EvsVoucherLine> impVoucherLineToEvsVocherLine(InquiryReceiptJournalInfoSrvOutputItem paramInquiryReceiptJournalInfoSrvOutputItem, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInquiryReceiptJournalInfoSrvOutputItem.getJOURNALACCOUNTINGINFO() != null)
    {
      Iterator localIterator = paramInquiryReceiptJournalInfoSrvOutputItem.getJOURNALACCOUNTINGINFO().getJOURNALACCOUNTINGINFOITEM().iterator();
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
        localEvsVoucherLine.setVoucherType("收款");
        localArrayList.add(localEvsVoucherLine);
      }
    }
    return localArrayList;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.proxy.voucherSer.ReceiptVoucherFactorImp
 * JD-Core Version:    0.7.0.1
 */