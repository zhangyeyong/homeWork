package com.zte.web.service.proxy.syn;

import com.cmcc.mss.msgheader.MsgHeader;
import com.cmcc.mss.sb_fi_gl_pageinquirygljournalinfosrv.PageInquiryGLJournalInfoSrvOutputCollection;
import com.cmcc.mss.sb_fi_gl_pageinquirygljournalinfosrv.PageInquiryGLJournalInfoSrvOutputItem;
import com.cmcc.mss.sb_fi_gl_pageinquirygljournalinfosrv.SBFIGLPageInquiryGLJournalInfoSrvRequest;
import com.cmcc.mss.sb_fi_gl_pageinquirygljournalinfosrv.SBFIGLPageInquiryGLJournalInfoSrvResponse;
import com.zte.eas.appframe.business.synrequest.model.FbpSynchRequestsV;
import com.zte.evs.ebill.access.eBillManage.IEvsVoucherDAO;
import com.zte.evs.ebill.access.eBillManage.IEvsVoucherLineDAO;
import com.zte.evs.ebill.model.eBillManage.EvsVoucher;
import com.zte.web.service.common.ObjectCommon;
import com.zte.web.service.proxy.GLJournalInfoClientImp;
import com.zte.web.service.proxy.voucherSer.GLVoucherFactorImp;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.apache.log4j.Logger;

public class GLJournalInfoSynImpDS
  implements GLJournalInfoSynDS, DataSynDS
{
  Logger log = Logger.getLogger(getClass());
  private IEvsVoucherDAO evsVoucherDAO;
  private IEvsVoucherLineDAO evsVoucherLineDAO;
  private static final BigDecimal TOTAL_RECORD = BigDecimal.valueOf(-1L);
  private static final BigDecimal CURRENT_PAGE = BigDecimal.valueOf(1L);
  private static final BigDecimal PAGE_SIZE = BigDecimal.valueOf(100L);
  
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
    localMsgHeader.setTOTALRECORD(TOTAL_RECORD);
    localMsgHeader.setCURRENTPAGE(CURRENT_PAGE);
    localMsgHeader.setPAGESIZE(PAGE_SIZE);
    SBFIGLPageInquiryGLJournalInfoSrvRequest localSBFIGLPageInquiryGLJournalInfoSrvRequest = new SBFIGLPageInquiryGLJournalInfoSrvRequest();
    localSBFIGLPageInquiryGLJournalInfoSrvRequest.setMsgHeader(localMsgHeader);
    localSBFIGLPageInquiryGLJournalInfoSrvRequest.setJOURNALNUM(paramString);
    localSBFIGLPageInquiryGLJournalInfoSrvRequest.setSTARTLASTUPDATEDATE(ObjectCommon.calendarToXmlCalendar(paramCalendar1));
    localSBFIGLPageInquiryGLJournalInfoSrvRequest.setENDLASTUPDATEDATE(ObjectCommon.calendarToXmlCalendar(paramCalendar2));
    GLJournalInfoClientImp localGLJournalInfoClientImp = new GLJournalInfoClientImp();
    SBFIGLPageInquiryGLJournalInfoSrvResponse localSBFIGLPageInquiryGLJournalInfoSrvResponse = localGLJournalInfoClientImp.doProccess(localSBFIGLPageInquiryGLJournalInfoSrvRequest);
    GLVoucherFactorImp localGLVoucherFactorImp = new GLVoucherFactorImp();
    if (localSBFIGLPageInquiryGLJournalInfoSrvResponse != null)
    {
      Object localObject1;
      Object localObject2;
      Object localObject3;
      Object localObject4;
      Object localObject5;
      if ("Y".equals(localSBFIGLPageInquiryGLJournalInfoSrvResponse.getSERVICEFLAG()))
      {
        List localList1 = localSBFIGLPageInquiryGLJournalInfoSrvResponse.getPageInquiryGLJournalInfoSrvOutputCollection().getPageInquiryGLJournalInfoSrvOutputItem();
        localObject1 = localList1.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (PageInquiryGLJournalInfoSrvOutputItem)((Iterator)localObject1).next();
          localObject3 = localGLVoucherFactorImp.impVoucherToEvsVocher((PageInquiryGLJournalInfoSrvOutputItem)localObject2);
          localObject4 = this.evsVoucherDAO.getEvsVoucherByCode(((EvsVoucher)localObject3).getJournalNum());
          if (localObject4 == null)
          {
            this.evsVoucherDAO.insertObject((EvsVoucher)localObject3);
            localObject5 = localGLVoucherFactorImp.impVoucherLineToEvsVocherLine((PageInquiryGLJournalInfoSrvOutputItem)localObject2, ((EvsVoucher)localObject3).getVoucherId().longValue());
            this.evsVoucherLineDAO.inserEvsVoucherLines((List)localObject5);
          }
        }
      }
      localMsgHeader.setTOTALRECORD(localSBFIGLPageInquiryGLJournalInfoSrvResponse.getTOTALRECORD());
      for (int i = 1; i < localSBFIGLPageInquiryGLJournalInfoSrvResponse.getPAGESIZE().intValue(); i++)
      {
        localMsgHeader.setCURRENTPAGE(BigDecimal.valueOf(CURRENT_PAGE.intValue() + i));
        localSBFIGLPageInquiryGLJournalInfoSrvRequest.setMsgHeader(localMsgHeader);
        localSBFIGLPageInquiryGLJournalInfoSrvResponse = localGLJournalInfoClientImp.doProccess(localSBFIGLPageInquiryGLJournalInfoSrvRequest);
        localObject1 = new GLVoucherFactorImp();
        if (localSBFIGLPageInquiryGLJournalInfoSrvResponse != null)
        {
          if ("Y".equals(localSBFIGLPageInquiryGLJournalInfoSrvResponse.getSERVICEFLAG()))
          {
            localObject2 = localSBFIGLPageInquiryGLJournalInfoSrvResponse.getPageInquiryGLJournalInfoSrvOutputCollection().getPageInquiryGLJournalInfoSrvOutputItem();
            localObject3 = ((List)localObject2).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (PageInquiryGLJournalInfoSrvOutputItem)((Iterator)localObject3).next();
              localObject5 = ((GLVoucherFactorImp)localObject1).impVoucherToEvsVocher((PageInquiryGLJournalInfoSrvOutputItem)localObject4);
              EvsVoucher localEvsVoucher = this.evsVoucherDAO.getEvsVoucherByCode(((EvsVoucher)localObject5).getJournalNum());
              if (localEvsVoucher == null) {
                try
                {
                  this.evsVoucherDAO.insertObject((EvsVoucher)localObject5);
                  List localList2 = ((GLVoucherFactorImp)localObject1).impVoucherLineToEvsVocherLine((PageInquiryGLJournalInfoSrvOutputItem)localObject4, ((EvsVoucher)localObject5).getVoucherId().longValue());
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
      }
    }
    else
    {
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
 * Qualified Name:     com.zte.web.service.proxy.syn.GLJournalInfoSynImpDS
 * JD-Core Version:    0.7.0.1
 */