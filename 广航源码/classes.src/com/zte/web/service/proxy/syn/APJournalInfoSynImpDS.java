package com.zte.web.service.proxy.syn;

import com.cmcc.mss.msgheader.MsgHeader;
import com.cmcc.mss.sb_fi_ap_inquiryapjournalinfosrv.InquiryAPJournalInfoSrvOutputCollection;
import com.cmcc.mss.sb_fi_ap_inquiryapjournalinfosrv.InquiryAPJournalInfoSrvOutputItem;
import com.cmcc.mss.sb_fi_ap_inquiryapjournalinfosrv.SBFIAPInquiryAPJournalInfoSrvRequest;
import com.cmcc.mss.sb_fi_ap_inquiryapjournalinfosrv.SBFIAPInquiryAPJournalInfoSrvResponse;
import com.zte.eas.appframe.business.synrequest.model.FbpSynchRequestsV;
import com.zte.evs.ebill.access.eBillManage.IEvsVoucherDAO;
import com.zte.evs.ebill.access.eBillManage.IEvsVoucherLineDAO;
import com.zte.evs.ebill.model.eBillManage.EvsVoucher;
import com.zte.web.service.common.ObjectCommon;
import com.zte.web.service.proxy.APJournalInfoClientImp;
import com.zte.web.service.proxy.voucherSer.APVoucherFactorImp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.apache.log4j.Logger;

public class APJournalInfoSynImpDS
  implements APJournalInfoSynDS, DataSynDS
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
    SBFIAPInquiryAPJournalInfoSrvRequest localSBFIAPInquiryAPJournalInfoSrvRequest = new SBFIAPInquiryAPJournalInfoSrvRequest();
    localSBFIAPInquiryAPJournalInfoSrvRequest.setMsgHeader(localMsgHeader);
    localSBFIAPInquiryAPJournalInfoSrvRequest.setJOURNALNUM(paramString);
    localSBFIAPInquiryAPJournalInfoSrvRequest.setSTARTLASTUPDATEDATE(calendarToXmlCalendar(paramCalendar1));
    localSBFIAPInquiryAPJournalInfoSrvRequest.setENDLASTUPDATEDATE(calendarToXmlCalendar(paramCalendar2));
    APJournalInfoClientImp localAPJournalInfoClientImp = new APJournalInfoClientImp();
    SBFIAPInquiryAPJournalInfoSrvResponse localSBFIAPInquiryAPJournalInfoSrvResponse = localAPJournalInfoClientImp.doProccess(localSBFIAPInquiryAPJournalInfoSrvRequest);
    APVoucherFactorImp localAPVoucherFactorImp = new APVoucherFactorImp();
    if (localSBFIAPInquiryAPJournalInfoSrvResponse != null)
    {
      if ("Y".equals(localSBFIAPInquiryAPJournalInfoSrvResponse.getSERVICEFLAG()))
      {
        List localList1 = localSBFIAPInquiryAPJournalInfoSrvResponse.getInquiryAPJournalInfoSrvOutputCollection().getInquiryAPJournalInfoSrvOutputItem();
        Iterator localIterator = localList1.iterator();
        while (localIterator.hasNext())
        {
          InquiryAPJournalInfoSrvOutputItem localInquiryAPJournalInfoSrvOutputItem = (InquiryAPJournalInfoSrvOutputItem)localIterator.next();
          EvsVoucher localEvsVoucher1 = localAPVoucherFactorImp.impApVoucherBeanToEvsVocher(localInquiryAPJournalInfoSrvOutputItem);
          EvsVoucher localEvsVoucher2 = this.evsVoucherDAO.getEvsVoucherByCode(localEvsVoucher1.getJournalNum());
          if (localEvsVoucher2 == null) {
            try
            {
              this.evsVoucherDAO.insertObject(localEvsVoucher1);
              List localList2 = localAPVoucherFactorImp.impApVoucherLineToEvsVocherLine(localInquiryAPJournalInfoSrvOutputItem, localEvsVoucher1.getVoucherId().longValue());
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
  
  private XMLGregorianCalendar calendarToXmlCalendar(Calendar paramCalendar)
  {
    try
    {
      DatatypeFactory localDatatypeFactory = DatatypeFactory.newInstance();
      return localDatatypeFactory.newXMLGregorianCalendar(paramCalendar.get(1), paramCalendar.get(2) + 1, paramCalendar.get(5), paramCalendar.get(10), paramCalendar.get(12), paramCalendar.get(13), paramCalendar.get(14), paramCalendar.get(15) / 60000);
    }
    catch (DatatypeConfigurationException localDatatypeConfigurationException)
    {
      localDatatypeConfigurationException.printStackTrace();
    }
    return null;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.proxy.syn.APJournalInfoSynImpDS
 * JD-Core Version:    0.7.0.1
 */