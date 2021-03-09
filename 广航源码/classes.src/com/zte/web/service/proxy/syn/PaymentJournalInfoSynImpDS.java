package com.zte.web.service.proxy.syn;

import com.cmcc.mss.msgheader.MsgHeader;
import com.cmcc.mss.sb_fi_ap_inquirypaymentjournalinfosrv.InquiryPaymentJournalInfoSrvOutputCollection;
import com.cmcc.mss.sb_fi_ap_inquirypaymentjournalinfosrv.InquiryPaymentJournalInfoSrvOutputItem;
import com.cmcc.mss.sb_fi_ap_inquirypaymentjournalinfosrv.SBFIAPInquiryPaymentJournalInfoSrvRequest;
import com.cmcc.mss.sb_fi_ap_inquirypaymentjournalinfosrv.SBFIAPInquiryPaymentJournalInfoSrvResponse;
import com.zte.eas.appframe.business.synrequest.model.FbpSynchRequestsV;
import com.zte.evs.ebill.access.eBillManage.IEvsVoucherDAO;
import com.zte.evs.ebill.access.eBillManage.IEvsVoucherLineDAO;
import com.zte.evs.ebill.model.eBillManage.EvsVoucher;
import com.zte.web.service.common.ObjectCommon;
import com.zte.web.service.proxy.PaymentJournalInfoClientImp;
import com.zte.web.service.proxy.voucherSer.PaymentVoucherFactorImp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.apache.log4j.Logger;

public class PaymentJournalInfoSynImpDS
  implements PaymentJournalInfoSynDS, DataSynDS
{
  Logger log = Logger.getLogger(getClass());
  private IEvsVoucherDAO evsVoucherDAO;
  private IEvsVoucherLineDAO evsVoucherLineDAO;
  
  public IEvsVoucherLineDAO getEvsVoucherLineDAO()
  {
    return this.evsVoucherLineDAO;
  }
  
  public void setEvsVoucherLineDAO(IEvsVoucherLineDAO paramIEvsVoucherLineDAO)
  {
    this.evsVoucherLineDAO = paramIEvsVoucherLineDAO;
  }
  
  public IEvsVoucherDAO getEvsVoucherDAO()
  {
    return this.evsVoucherDAO;
  }
  
  public void setEvsVoucherDAO(IEvsVoucherDAO paramIEvsVoucherDAO)
  {
    this.evsVoucherDAO = paramIEvsVoucherDAO;
  }
  
  public void qry()
    throws Exception
  {
    qry(null, null, null);
  }
  
  public boolean qry(String paramString, Calendar paramCalendar1, Calendar paramCalendar2)
    throws Exception
  {
    MsgHeader localMsgHeader = new MsgHeader();
    localMsgHeader.setSOURCESYSTEMID("EVS");
    localMsgHeader.setSOURCESYSTEMNAME("EVS");
    localMsgHeader.setUSERID("10000");
    localMsgHeader.setUSERNAME("EVS");
    GregorianCalendar localGregorianCalendar = new GregorianCalendar();
    XMLGregorianCalendar localXMLGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(localGregorianCalendar);
    localMsgHeader.setSUBMITDATE(localXMLGregorianCalendar);
    SBFIAPInquiryPaymentJournalInfoSrvRequest localSBFIAPInquiryPaymentJournalInfoSrvRequest = new SBFIAPInquiryPaymentJournalInfoSrvRequest();
    localSBFIAPInquiryPaymentJournalInfoSrvRequest.setMsgHeader(localMsgHeader);
    localSBFIAPInquiryPaymentJournalInfoSrvRequest.setJOURNALNUM(paramString);
    localSBFIAPInquiryPaymentJournalInfoSrvRequest.setSTARTLASTUPDATEDATE(ObjectCommon.calendarToXmlCalendar(paramCalendar1));
    localSBFIAPInquiryPaymentJournalInfoSrvRequest.setENDLASTUPDATEDATE(ObjectCommon.calendarToXmlCalendar(paramCalendar2));
    PaymentJournalInfoClientImp localPaymentJournalInfoClientImp = new PaymentJournalInfoClientImp();
    SBFIAPInquiryPaymentJournalInfoSrvResponse localSBFIAPInquiryPaymentJournalInfoSrvResponse = localPaymentJournalInfoClientImp.doProccess(localSBFIAPInquiryPaymentJournalInfoSrvRequest);
    PaymentVoucherFactorImp localPaymentVoucherFactorImp = new PaymentVoucherFactorImp();
    if (localSBFIAPInquiryPaymentJournalInfoSrvResponse != null)
    {
      if ("Y".equals(localSBFIAPInquiryPaymentJournalInfoSrvResponse.getSERVICEFLAG()))
      {
        List localList1 = localSBFIAPInquiryPaymentJournalInfoSrvResponse.getInquiryPaymentJournalInfoSrvOutputCollection().getInquiryPaymentJournalInfoSrvOutputItem();
        Iterator localIterator = localList1.iterator();
        while (localIterator.hasNext())
        {
          InquiryPaymentJournalInfoSrvOutputItem localInquiryPaymentJournalInfoSrvOutputItem = (InquiryPaymentJournalInfoSrvOutputItem)localIterator.next();
          EvsVoucher localEvsVoucher1 = localPaymentVoucherFactorImp.impVoucherToEvsVocher(localInquiryPaymentJournalInfoSrvOutputItem);
          EvsVoucher localEvsVoucher2 = this.evsVoucherDAO.getEvsVoucherByCode(localEvsVoucher1.getJournalNum());
          if (localEvsVoucher2 == null) {
            try
            {
              this.evsVoucherDAO.insertObject(localEvsVoucher1);
              List localList2 = localPaymentVoucherFactorImp.impVoucherLineToEvsVocherLine(localInquiryPaymentJournalInfoSrvOutputItem, localEvsVoucher1.getVoucherId().longValue());
              this.evsVoucherLineDAO.inserEvsVoucherLines(localList2);
            }
            catch (Exception localException) {}
          }
        }
      }
    }
    else {
      return false;
    }
    return true;
  }
  
  public boolean syn(FbpSynchRequestsV paramFbpSynchRequestsV)
    throws Exception
  {
    Calendar localCalendar = Calendar.getInstance();
    if (paramFbpSynchRequestsV.getLastRunTime() != null) {
      localCalendar.setTime(paramFbpSynchRequestsV.getLastRunTime());
    }
    Date localDate1 = localCalendar.getTime();
    localCalendar.add(5, -1);
    Date localDate2 = localCalendar.getTime();
    localDate2.setHours(0);
    localDate2.setMinutes(0);
    localDate2.setSeconds(0);
    localDate1.setHours(0);
    localDate1.setMinutes(0);
    localDate1.setSeconds(0);
    return qry(null, ObjectCommon.dateToCalendar(localDate2), ObjectCommon.dateToCalendar(localDate1));
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.proxy.syn.PaymentJournalInfoSynImpDS
 * JD-Core Version:    0.7.0.1
 */