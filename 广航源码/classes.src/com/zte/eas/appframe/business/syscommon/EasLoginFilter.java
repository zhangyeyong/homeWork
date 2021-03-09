/*   1:    */ package com.zte.eas.appframe.business.syscommon;
/*   2:    */ 
/*   3:    */ import com.zte.eas.appframe.business.syscommon.model.FbpEmployeesLoginV;
/*   4:    */ import com.zte.eas.infomap.business.sso.SSOLoginServlet;
/*   5:    */ import com.zte.eas.organization.business.employeemanage.service.IFbpEmployeesVDS;
/*   6:    */ import com.zte.eimage.business.baseconfig.model.EidImageInfos;
/*   7:    */ import com.zte.eimage.business.baseconfig.service.IEidImageInfosDS;
/*   8:    */ import com.zte.ssb.framework.SSBBus;
/*   9:    */ import com.zte.ssb.framework.common.log.Log;
/*  10:    */ import com.zte.ssb.servicecontainer.business.server.IRIAContextFactory;
/*  11:    */ import com.zte.ssb.servicecontainer.business.server.RIAConfiguration;
/*  12:    */ import com.zte.ssb.servicecontainer.business.server.RIAContext;
/*  13:    */ import com.zte.ssb.ui.uiloader.model.UserInfo;
/*  14:    */ import java.io.IOException;
/*  15:    */ import java.io.InputStream;
/*  16:    */ import java.io.PrintWriter;
/*  17:    */ import javax.servlet.Filter;
/*  18:    */ import javax.servlet.FilterChain;
/*  19:    */ import javax.servlet.FilterConfig;
/*  20:    */ import javax.servlet.ServletException;
/*  21:    */ import javax.servlet.ServletOutputStream;
/*  22:    */ import javax.servlet.ServletRequest;
/*  23:    */ import javax.servlet.ServletResponse;
/*  24:    */ import javax.servlet.http.HttpServletRequest;
/*  25:    */ import javax.servlet.http.HttpServletResponse;
/*  26:    */ import javax.servlet.http.HttpSession;
/*  27:    */ import org.apache.axis.utils.StringUtils;
/*  28:    */ 
/*  29:    */ public class EasLoginFilter
/*  30:    */   implements Filter
/*  31:    */ {
/*  32:    */   private static final String UNICODE = "Unicode";
/*  33:    */   private String userId;
/*  34:    */   private static IFbpEmployeesVDS _FbpEmployeesVDS;
/*  35: 38 */   private final String INDEX_PAGE = "./uiloader/index.html";
/*  36: 39 */   private final String IMAGE_URL = "apps/eimage/myboe/myNeedApprovalImageDetail.html?imageNumber=";
/*  37: 40 */   private final String APP_IMAGE_URL = "apps/ebill/commn/imageDisplay.html?imageNumber=";
/*  38: 41 */   protected Log log = SSBBus.getLog(getClass());
/*  39: 42 */   private FilterConfig filterConfig = null;
/*  40: 43 */   private final String ALREADY_FILING = "ALREADY_FILING";
/*  41: 44 */   private final String COMPLEMENT_FOR_FILING = "COMPLEMENT_FOR_FILING";
/*  42: 45 */   private final String FOR_FILING = "FOR_FILING";
/*  43: 46 */   private RIAConfiguration configuration = null;
/*  44: 47 */   private final String APPROVE = "APPROVE";
/*  45:    */   
/*  46:    */   public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
/*  47:    */     throws IOException, ServletException
/*  48:    */   {
/*  49: 51 */     IRIAContextFactory riaContextFactory = this.configuration.getRiaContextFactory();
/*  50: 52 */     riaContextFactory.getRIAContext(this.filterConfig.getServletContext(), req, resp);
/*  51:    */     
/*  52: 54 */     HttpServletRequest request = (HttpServletRequest)req;
/*  53: 55 */     HttpServletResponse response = (HttpServletResponse)resp;
/*  54: 56 */     HttpSession session = request.getSession();
/*  55: 57 */     response.setContentType("text/html;charset=UTF-8");
/*  56: 58 */     String imageNumber = request.getParameter("scanNumber");
/*  57: 59 */     if ((imageNumber == null) || (imageNumber.trim().length() == 0)) {
/*  58: 60 */       imageNumber = request.getParameter("imageNumber");
/*  59:    */     }
/*  60: 62 */     this.userId = req.getParameter("userID");
/*  61: 63 */     String operate = request.getParameter("operator");
/*  62:    */     try
/*  63:    */     {
/*  64: 66 */       if (isBase64Encode(this.userId)) {
/*  65: 67 */         this.userId = Base64.decode(this.userId, "Unicode");
/*  66:    */       } else {
/*  67: 69 */         this.userId = "";
/*  68:    */       }
/*  69: 71 */       if (isBase64Encode(imageNumber)) {
/*  70: 72 */         imageNumber = Base64.decode(imageNumber, "Unicode");
/*  71:    */       } else {
/*  72: 74 */         imageNumber = "";
/*  73:    */       }
/*  74:    */     }
/*  75:    */     catch (Exception e)
/*  76:    */     {
/*  77: 78 */       this.log.error(e.getMessage(), e);
/*  78:    */     }
/*  79: 81 */     if ((this.userId == null) || ("".equals(this.userId.trim())))
/*  80:    */     {
/*  81: 82 */       this.log.error("userid is null");
/*  82:    */       
/*  83: 84 */       printMst(response, "用户不存在!", "./uiloader/index.html");
/*  84:    */       
/*  85: 86 */       return;
/*  86:    */     }
/*  87: 87 */     if ((imageNumber == null) || (imageNumber.trim().length() == 0))
/*  88:    */     {
/*  89: 88 */       this.log.error("imageNumber is null");
/*  90:    */       
/*  91: 90 */       printMst(response, "影像编号(单据编号)不存在!", "./uiloader/index.html");
/*  92:    */       
/*  93: 92 */       return;
/*  94:    */     }
/*  95: 94 */     IEidImageInfosDS eidImageInfosDS = (IEidImageInfosDS)SSBBus.findDomainService("imageInfosDS");
/*  96: 95 */     EidImageInfos eidImageInfos = eidImageInfosDS.findEidImageInfoByImageNumber(imageNumber);
/*  97: 97 */     if ((eidImageInfos == null) || (eidImageInfos.getImageInfoId() == null)) {
/*  98: 98 */       eidImageInfos = eidImageInfosDS.findEidImageInfoByTaskNumber(imageNumber);
/*  99:    */     }
/* 100:101 */     UserInfo userinfo = getUserInfo(this.userId, session, request);
/* 101:102 */     if (userinfo != null)
/* 102:    */     {
/* 103:103 */       String url = "";
/* 104:104 */       if ((eidImageInfos == null) || (eidImageInfos.getImageInfoId() == null))
/* 105:    */       {
/* 106:105 */         this.log.error("imageinfo is null");
/* 107:    */         
/* 108:107 */         printMst(response, "影像信息不存在!", "./uiloader/index.html");
/* 109:108 */         return;
/* 110:    */       }
/* 111:111 */       imageNumber = eidImageInfos.getImageNumber();
/* 112:113 */       if ((!"APPROVE".equals(operate)) || ((!"COMPLEMENT_FOR_FILING".equals(eidImageInfos.getImageStatus())) && (!"FOR_FILING".equals(eidImageInfos.getImageStatus())))) {
/* 113:114 */         url = "apps/ebill/commn/imageDisplay.html?imageNumber=" + imageNumber;
/* 114:    */       } else {
/* 115:116 */         url = "apps/eimage/myboe/myNeedApprovalImageDetail.html?imageNumber=" + imageNumber + "&APPROVE=N";
/* 116:    */       }
/* 117:118 */       FbpEmployeesLoginV fbpEmployeesV = getFbpEmployeesVDS()
/* 118:119 */         .findEmployeeByUserId(userinfo.getUserId());
/* 119:    */       
/* 120:121 */       UserInfo easUserInfo = (UserInfo)session
/* 121:122 */         .getAttribute("loginuserinfo");
/* 122:123 */       if ((easUserInfo == null) || (easUserInfo.getUserId() == null)) {
/* 123:124 */         EasLoginUtil.afterLoginSuccess(userinfo, fbpEmployeesV, 
/* 124:125 */           session, RIAContext.getCurrentInstance().getRequest());
/* 125:    */       }
/* 126:127 */       this.log.error("++++++++++++++++___+++url:  " + url);
/* 127:128 */       response.sendRedirect(url);
/* 128:    */     }
/* 129:    */     else
/* 130:    */     {
/* 131:131 */       printMst(response, "用户不存在!", "./uiloader/index.html");
/* 132:    */       
/* 133:133 */       return;
/* 134:    */     }
/* 135:    */   }
/* 136:    */   
/* 137:    */   void printMst(HttpServletResponse response, String msg, String url)
/* 138:    */     throws IOException
/* 139:    */   {
/* 140:137 */     String message = "<script language='javascript'>alert('#msg#');window.location.href='" + url + "';</script>";
/* 141:138 */     message = message.replace("#msg#", msg);
/* 142:139 */     response.getWriter().write(message);
/* 143:    */   }
/* 144:    */   
/* 145:    */   public UserInfo getUserInfo(String name, HttpSession session, HttpServletRequest request)
/* 146:    */   {
/* 147:    */     try
/* 148:    */     {
/* 149:144 */       if ((name != null) && (!"".equals(name)))
/* 150:    */       {
/* 151:146 */         FbpEmployeesLoginV fbpEmployeesV = getFbpEmployeesVDS()
/* 152:147 */           .findEmployeeByUserId(name);
/* 153:148 */         if (fbpEmployeesV != null)
/* 154:    */         {
/* 155:149 */           UserInfo userinfo = new UserInfo();
/* 156:150 */           userinfo.setUserId(name);
/* 157:    */           
/* 158:    */ 
/* 159:153 */           return userinfo;
/* 160:    */         }
/* 161:155 */         return null;
/* 162:    */       }
/* 163:    */     }
/* 164:    */     catch (Exception e)
/* 165:    */     {
/* 166:159 */       this.log.error("统一登录出错：" + e.getClass() + "--" + e.getMessage(), e);
/* 167:160 */       e.printStackTrace();
/* 168:    */     }
/* 169:162 */     return null;
/* 170:    */   }
/* 171:    */   
/* 172:    */   protected static synchronized IFbpEmployeesVDS getFbpEmployeesVDS()
/* 173:    */   {
/* 174:166 */     if (_FbpEmployeesVDS == null) {
/* 175:167 */       _FbpEmployeesVDS = (IFbpEmployeesVDS)
/* 176:168 */         SSBBus.findCommonService("fbpEmployeesVDS");
/* 177:    */     }
/* 178:170 */     return _FbpEmployeesVDS;
/* 179:    */   }
/* 180:    */   
/* 181:    */   public void destroy() {}
/* 182:    */   
/* 183:    */   public void init(FilterConfig cfg)
/* 184:    */     throws ServletException
/* 185:    */   {
/* 186:178 */     this.filterConfig = cfg;
/* 187:    */     try
/* 188:    */     {
/* 189:181 */       InputStream in = SSOLoginServlet.class.getClassLoader()
/* 190:182 */         .getResourceAsStream("ria-config.config");
/* 191:183 */       this.configuration = new RIAConfiguration(in);
/* 192:184 */       in.close();
/* 193:    */     }
/* 194:    */     catch (Exception e)
/* 195:    */     {
/* 196:186 */       e.printStackTrace();
/* 197:    */     }
/* 198:    */   }
/* 199:    */   
/* 200:    */   private void output(String msg, HttpServletResponse response)
/* 201:    */   {
/* 202:192 */     if (StringUtils.isEmpty(msg)) {
/* 203:193 */       return;
/* 204:    */     }
/* 205:    */     try
/* 206:    */     {
/* 207:196 */       response.setContentType("text/xml; charset=utf-8");
/* 208:197 */       response.setCharacterEncoding("utf-8");
/* 209:198 */       ServletOutputStream o = response.getOutputStream();
/* 210:199 */       o.print("<script>alert(" + msg + ");widnow.close();</script>");
/* 211:200 */       o.close();
/* 212:    */     }
/* 213:    */     catch (IOException e)
/* 214:    */     {
/* 215:202 */       e.printStackTrace();
/* 216:    */     }
/* 217:    */   }
/* 218:    */   
/* 219:    */   private boolean isBase64Encode(String value)
/* 220:    */   {
/* 221:    */     try
/* 222:    */     {
/* 223:208 */       String deocdeVal = Base64.decode(value, "Unicode");
/* 224:209 */       return value.equals(Base64.encode(deocdeVal, "Unicode"));
/* 225:    */     }
/* 226:    */     catch (Exception e)
/* 227:    */     {
/* 228:211 */       this.log.error(e.getMessage(), e);
/* 229:    */     }
/* 230:212 */     return false;
/* 231:    */   }
/* 232:    */ }


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.business.syscommon.EasLoginFilter
 * JD-Core Version:    0.7.0.1
 */