package com.zte.eas.infomap.business.common.service;

import com.zte.eas.infomap.business.notice.model.FbpNoticesNew;
import com.zte.eas.organization.access.employeemanage.dao.IFbpEmployeesVDAO;
import com.zte.evs.ebill.access.archives.IFbpArchivesHeadersDAO;
import com.zte.evs.ebill.access.archives.IFbpArchivesHistoriesDAO;
import com.zte.evs.ebill.model.archives.FbpArchivesHeaders;
import com.zte.evs.ebill.model.eBillManage.EvsAllotHeaders;
import com.zte.ssb.XmlCfgParser;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class TemplateBuilder
  implements ITemplateBuilder
{
  private static final String TPDSubmit = "tpdsubmit";
  private static final String PZDspe = "pzdspe";
  private static final String SWPzdspe = "swpzdspe";
  private static final String PZJyddq = "pzjyddq";
  private static final String PZJydtje = "pzjydtje";
  private IFbpArchivesHeadersDAO boeHeadersAllVDAO;
  private IFbpArchivesHistoriesDAO wfrBillHistoriesVDAO;
  private IFbpEmployeesVDAO fbpEmployeesVDAO;
  private static DecimalFormat format = new DecimalFormat("#,##0.00");
  private static XmlCfgParser mailCfgParser = new XmlCfgParser("eas_mail_infomap.xml");
  private static XmlCfgParser smsCfgParser = new XmlCfgParser("eas_notes_infomap.xml");
  
  public String buildText(String paramString, FbpNoticesNew paramFbpNoticesNew)
  {
    try
    {
      String str = null;
      if (NoticeConstant.EMAIL.equals(paramString)) {
        str = buildTextForEmail(paramFbpNoticesNew);
      } else if (NoticeConstant.SMS.equals(paramString)) {
        str = buildTextForSms(paramFbpNoticesNew);
      }
      return str;
    }
    catch (Exception localException)
    {
      System.out.println("TemplateBuilder ==> buildText");
      localException.printStackTrace();
    }
    return null;
  }
  
  private String buildTextForSms(FbpNoticesNew paramFbpNoticesNew)
  {
    try
    {
      String str1 = "";
      String str2 = paramFbpNoticesNew.getTemplateId();
      FbpArchivesHeaders localFbpArchivesHeaders = new FbpArchivesHeaders();
      if ((str2 != null) && (str2.equals("pzjyddq")))
      {
        int i = 0;
        if ((paramFbpNoticesNew != null) && (paramFbpNoticesNew.getBoeHeaderId() != null) && (!paramFbpNoticesNew.getBoeHeaderId().equals(""))) {
          localFbpArchivesHeaders = (FbpArchivesHeaders)this.boeHeadersAllVDAO.getObject(FbpArchivesHeaders.class, Long.valueOf(paramFbpNoticesNew.getBoeHeaderId().longValue()));
        }
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("YYYY/MM/dd");
        String str3 = localSimpleDateFormat.format(localFbpArchivesHeaders.getApplyDate());
        String str4 = localSimpleDateFormat.format(localFbpArchivesHeaders.getGiveBackDate());
        StringBuilder localStringBuilder = new StringBuilder("您好，您").append(str3.substring(0, 4)).append("年").append(str3.substring(5, 7)).append("月").append(str3.substring(8)).append("日").append("申请的凭证借阅单将于").append(str4.substring(0, 4)).append("年").append(str4.substring(5, 7)).append("月").append(str4.substring(8)).append("日").append("到期，请及时归还，否则会影响信用等级。");
        str1 = localStringBuilder.toString();
        System.out.println("短信:" + str1);
      }
      return str1;
    }
    catch (Exception localException)
    {
      System.out.println("buildTextForSms");
      localException.printStackTrace();
    }
    return null;
  }
  
  private String getMailCfg(String paramString)
  {
    return mailCfgParser.getValue(paramString);
  }
  
  private String getSmsCfg(String paramString)
  {
    return smsCfgParser.getValue(paramString);
  }
  
  private String buildTextForEmail(FbpNoticesNew paramFbpNoticesNew)
  {
    try
    {
      String str1 = "";
      String str2 = paramFbpNoticesNew.getTemplateId();
      EvsAllotHeaders localEvsAllotHeaders = new EvsAllotHeaders();
      FbpArchivesHeaders localFbpArchivesHeaders = new FbpArchivesHeaders();
      if ((str2 != null) && (str2.equals("tpdsubmit")) && ((null == paramFbpNoticesNew.getContent()) || ("".equals(paramFbpNoticesNew.getContent()))) && (paramFbpNoticesNew != null) && (paramFbpNoticesNew.getBoeHeaderId() != null) && (!paramFbpNoticesNew.getBoeHeaderId().equals(""))) {
        localEvsAllotHeaders = (EvsAllotHeaders)this.boeHeadersAllVDAO.getObject(EvsAllotHeaders.class, Long.valueOf(paramFbpNoticesNew.getBoeHeaderId().longValue()));
      }
      FbpNoticesNew localFbpNoticesNew = new FbpNoticesNew();
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MM/dd");
      String str3 = localSimpleDateFormat.format(localEvsAllotHeaders.getReceiveDate());
      StringBuilder localStringBuilder1 = new StringBuilder("您好，实物凭证调拨单").append(localEvsAllotHeaders.getAllotNum()).append("已经于").append(str3.substring(0, 2)).append("月").append(str3.substring(3, 5)).append("日").append("，提交，请您在接收到实物凭证后及时进行凭证调拨接收。");
      str1 = localStringBuilder1.toString();
      Object localObject1;
      Object localObject2;
      Object localObject3;
      StringBuilder localStringBuilder2;
      if ((str2 != null) && (str2.equals("pzdspe")))
      {
        localObject1 = "";
        if ((paramFbpNoticesNew != null) && (paramFbpNoticesNew.getBoeHeaderId() != null) && (!paramFbpNoticesNew.getBoeHeaderId().equals(""))) {
          localFbpArchivesHeaders = (FbpArchivesHeaders)this.boeHeadersAllVDAO.getObject(FbpArchivesHeaders.class, Long.valueOf(paramFbpNoticesNew.getBoeHeaderId().longValue()));
        }
        localObject2 = new SimpleDateFormat("YYYY/MM/dd");
        localObject3 = ((SimpleDateFormat)localObject2).format(localFbpArchivesHeaders.getApplyDate());
        localStringBuilder2 = new StringBuilder("您好，您").append(((String)localObject3).substring(0, 4)).append("年").append(str3.substring(5, 7)).append("月").append(((String)localObject3).substring(8)).append("日").append("申请的凭证借阅单已经审批通过，请您在借阅有效期内查阅电子凭证，借阅完毕后及时归还。");
        str1 = localStringBuilder2.toString();
      }
      if ((str2 != null) && ("swpzdspe".equals(str2)))
      {
        if ((paramFbpNoticesNew != null) && (paramFbpNoticesNew.getBoeHeaderId() != null) && (!paramFbpNoticesNew.getBoeHeaderId().equals(""))) {
          localFbpArchivesHeaders = (FbpArchivesHeaders)this.boeHeadersAllVDAO.getObject(FbpArchivesHeaders.class, Long.valueOf(paramFbpNoticesNew.getBoeHeaderId().longValue()));
        }
        localObject1 = new SimpleDateFormat("YYYY/MM/dd");
        localObject2 = ((SimpleDateFormat)localObject1).format(localFbpArchivesHeaders.getApplyDate());
        localObject3 = new StringBuilder("您好，您").append(((String)localObject2).substring(0, 4)).append("年").append(((String)localObject2).substring(5, 7)).append("月").append(((String)localObject2).substring(8)).append("日").append("申请的凭证借阅单已经审批通过，请您及时联系档案管理员领取实物凭证，借阅完毕后及时归还。");
        str1 = ((StringBuilder)localObject3).toString();
      }
      if ((str2 != null) && (str2.equals("pzjyddq")) && ((null == paramFbpNoticesNew.getContent()) || ("".equals(paramFbpNoticesNew.getContent()))))
      {
        if ((paramFbpNoticesNew != null) && (paramFbpNoticesNew.getBoeHeaderId() != null) && (!paramFbpNoticesNew.getBoeHeaderId().equals(""))) {
          localFbpArchivesHeaders = (FbpArchivesHeaders)this.boeHeadersAllVDAO.getObject(FbpArchivesHeaders.class, Long.valueOf(paramFbpNoticesNew.getBoeHeaderId().longValue()));
        }
        localObject1 = new SimpleDateFormat("YYYY/MM/dd");
        localObject2 = ((SimpleDateFormat)localObject1).format(localFbpArchivesHeaders.getApplyDate());
        localObject3 = ((SimpleDateFormat)localObject1).format(localFbpArchivesHeaders.getGiveBackDate());
        localStringBuilder2 = new StringBuilder("您好，您").append(((String)localObject2).substring(0, 4)).append("年").append(((String)localObject2).substring(5, 7)).append("月").append(((String)localObject2).substring(8)).append("日").append("申请的凭证借阅单将于").append(((String)localObject3).substring(0, 4)).append("年").append(((String)localObject3).substring(5, 7)).append("月").append(((String)localObject3).substring(8)).append("日").append("到期，请及时归还，否则会影响信用等级。");
        str1 = localStringBuilder1.toString();
      }
      if ((str2 != null) && (str2.equals("pzjydtje")) && ((null == paramFbpNoticesNew.getContent()) || ("".equals(paramFbpNoticesNew.getContent()))))
      {
        if ((paramFbpNoticesNew != null) && (paramFbpNoticesNew.getBoeHeaderId() != null) && (!paramFbpNoticesNew.getBoeHeaderId().equals(""))) {
          localFbpArchivesHeaders = (FbpArchivesHeaders)this.boeHeadersAllVDAO.getObject(FbpArchivesHeaders.class, Long.valueOf(paramFbpNoticesNew.getBoeHeaderId().longValue()));
        }
        localObject1 = new SimpleDateFormat("YYYY/MM/dd");
        localObject2 = localSimpleDateFormat.format(localFbpArchivesHeaders.getApplyDate());
        localObject3 = new StringBuilder("您好，借阅单").append(localFbpArchivesHeaders.getApplyNum()).append("已经于").append(((String)localObject2).substring(0, 4)).append("年").append(((String)localObject2).substring(5, 7)).append("月").append(((String)localObject2).substring(8)).append("日").append("提交成功，请您及时到系统中进行审批。");
        localFbpNoticesNew.setContent(((StringBuilder)localObject3).toString());
        str1 = ((StringBuilder)localObject3).toString();
      }
      return str1;
    }
    catch (Exception localException)
    {
      System.out.println("buildTextForEmail");
      localException.printStackTrace();
    }
    return null;
  }
  
  public IFbpArchivesHeadersDAO getBoeHeadersAllVDAO()
  {
    return this.boeHeadersAllVDAO;
  }
  
  public void setBoeHeadersAllVDAO(IFbpArchivesHeadersDAO paramIFbpArchivesHeadersDAO)
  {
    this.boeHeadersAllVDAO = paramIFbpArchivesHeadersDAO;
  }
  
  public IFbpArchivesHistoriesDAO getWfrBillHistoriesVDAO()
  {
    return this.wfrBillHistoriesVDAO;
  }
  
  public void setWfrBillHistoriesVDAO(IFbpArchivesHistoriesDAO paramIFbpArchivesHistoriesDAO)
  {
    this.wfrBillHistoriesVDAO = paramIFbpArchivesHistoriesDAO;
  }
  
  public IFbpEmployeesVDAO getFbpEmployeesVDAO()
  {
    return this.fbpEmployeesVDAO;
  }
  
  public void setFbpEmployeesVDAO(IFbpEmployeesVDAO paramIFbpEmployeesVDAO)
  {
    this.fbpEmployeesVDAO = paramIFbpEmployeesVDAO;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.infomap.business.common.service.TemplateBuilder
 * JD-Core Version:    0.7.0.1
 */