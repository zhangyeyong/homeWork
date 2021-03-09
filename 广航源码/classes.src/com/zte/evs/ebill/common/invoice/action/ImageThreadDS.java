/*   1:    */ package com.zte.evs.ebill.common.invoice.action;
/*   2:    */ 
/*   3:    */ import com.sun.image.codec.jpeg.JPEGCodec;
/*   4:    */ import com.sun.image.codec.jpeg.JPEGEncodeParam;
/*   5:    */ import com.sun.image.codec.jpeg.JPEGImageEncoder;
/*   6:    */ import com.zte.eas.infomap.business.sso.ReportFilter;
/*   7:    */ import com.zte.evs.ebill.access.eBillManage.IEvsFtpDAO;
/*   8:    */ import com.zte.evs.ebill.access.eBillManage.IEvsImageDAO;
/*   9:    */ import com.zte.evs.ebill.common.invoice.util.InvoiceAction;
/*  10:    */ import com.zte.evs.ebill.model.eBillManage.EvsFtp;
/*  11:    */ import com.zte.evs.ebill.model.eBillManage.EvsImage;
/*  12:    */ import com.zte.evs.ebill.model.eBillManage.EvsVoucher;
/*  13:    */ import com.zte.ssb.AccessPropertiesFile;
/*  14:    */ import java.awt.Graphics;
/*  15:    */ import java.awt.Rectangle;
/*  16:    */ import java.awt.image.BufferedImage;
/*  17:    */ import java.io.FileInputStream;
/*  18:    */ import java.io.FileNotFoundException;
/*  19:    */ import java.io.IOException;
/*  20:    */ import java.io.InputStream;
/*  21:    */ import java.io.OutputStream;
/*  22:    */ import java.sql.Connection;
/*  23:    */ import java.util.ArrayList;
/*  24:    */ import java.util.Date;
/*  25:    */ import java.util.List;
/*  26:    */ import java.util.Map;
/*  27:    */ import net.sf.jasperreports.engine.JasperRunManager;
/*  28:    */ import org.apache.commons.lang.StringUtils;
/*  29:    */ import org.apache.commons.net.ftp.FTPClient;
/*  30:    */ import org.apache.log4j.Logger;
/*  31:    */ import org.icepdf.core.pobjects.Document;
/*  32:    */ 
/*  33:    */ public class ImageThreadDS
/*  34:    */   implements IImageThreadDS
/*  35:    */ {
/*  36:    */   private static final String _0 = "0";
/*  37: 45 */   private List<EvsVoucher> evsVoucherList = new ArrayList();
/*  38: 46 */   private Logger log = Logger.getLogger(ImageThreadDS.class);
/*  39:    */   private IEvsImageDAO evsImageDAO;
/*  40:    */   private IEvsFtpDAO evsFtpDAO;
/*  41:    */   private static final String _2 = "2";
/*  42:    */   private static final String _1 = "1";
/*  43:    */   public static final String fileName = "gh_cover.jasper";
/*  44: 55 */   public static EvsFtp ftp = null;
/*  45:    */   public static final String PRE_INFO = "V2_";
/*  46:    */   public static final String ICON = "icon";
/*  47:    */   private List<Map<String, Object>> mapList;
/*  48:    */   
/*  49:    */   public ImageThreadDS() {}
/*  50:    */   
/*  51:    */   public ImageThreadDS(EvsVoucher evsVoucher)
/*  52:    */   {
/*  53: 63 */     this.evsVoucherList.add(evsVoucher);
/*  54:    */   }
/*  55:    */   
/*  56:    */   public ImageThreadDS(List<EvsVoucher> subList)
/*  57:    */   {
/*  58: 67 */     this.evsVoucherList = subList;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public List<Map<String, Object>> getMapList()
/*  62:    */   {
/*  63: 73 */     return this.mapList;
/*  64:    */   }
/*  65:    */   
/*  66:    */   public void setMapList(List<Map<String, Object>> mapList)
/*  67:    */   {
/*  68: 77 */     this.mapList = mapList;
/*  69:    */   }
/*  70:    */   
/*  71:    */   public Integer call()
/*  72:    */     throws Exception
/*  73:    */   {
/*  74: 81 */     buildImage();
/*  75: 82 */     return null;
/*  76:    */   }
/*  77:    */   
/*  78:    */   public void buildImage()
/*  79:    */     throws Exception
/*  80:    */   {
/*  81: 87 */     int needCreateCount = 1000;
/*  82:    */     try
/*  83:    */     {
/*  84: 89 */       needCreateCount = Integer.valueOf(AccessPropertiesFile.getValue("createNeedCount")).intValue();
/*  85:    */     }
/*  86:    */     catch (Exception localException1) {}
/*  87: 94 */     this.mapList = this.evsImageDAO.getVoucherCorverInfo(needCreateCount);
/*  88: 95 */     if (this.mapList.isEmpty()) {
/*  89: 96 */       return;
/*  90:    */     }
/*  91: 99 */     if (ftp == null)
/*  92:    */     {
/*  93:100 */       ftp = this.evsFtpDAO.getFtpUser();
/*  94:101 */       if (StringUtils.isBlank(ftp.getFtpUserName()))
/*  95:    */       {
/*  96:103 */         ftp = null;
/*  97:104 */         return;
/*  98:    */       }
/*  99:    */     }
/* 100:109 */     this.log.error("凭证封面生成开始");
/* 101:    */     
/* 102:111 */     FTPClient ftpClient = new FTPClient();
/* 103:    */     
/* 104:    */ 
/* 105:    */ 
/* 106:115 */     Connection conn = this.evsImageDAO.getConnection();
/* 107:    */     try
/* 108:    */     {
/* 109:118 */       ftpClient.connect(ftp.getFtpAddress(), 
/* 110:119 */         ftp.getFtpPort().intValue());
/* 111:120 */       ftpClient.login(ftp.getFtpUserName(), 
/* 112:121 */         ftp.getFtpPwd());
/* 113:122 */       ftpClient.setFileType(2);
/* 114:126 */       for (int j = 0; j < this.mapList.size(); j++)
/* 115:    */       {
/* 116:130 */         Map<String, Object> paramer = (Map)this.mapList.get(j);
/* 117:131 */         Long voucherId = (Long)paramer.get("VOUCHER_ID");
/* 118:132 */         this.log.error("凭证封面" + voucherId + "生成开始");
/* 119:133 */         EvsVoucher evsVoucher = (EvsVoucher)this.evsImageDAO.getObject(EvsVoucher.class, voucherId);
/* 120:134 */         paramer.put("VOUCHER_ID", voucherId);
/* 121:135 */         InputStream input = new FileInputStream(
/* 122:136 */           ReportFilter.jaserPath + "gh_cover.jasper");
/* 123:    */         
/* 124:    */ 
/* 125:    */ 
/* 126:    */ 
/* 127:    */ 
/* 128:    */ 
/* 129:    */ 
/* 130:    */ 
/* 131:    */ 
/* 132:    */ 
/* 133:    */ 
/* 134:148 */         byte[] bs = JasperRunManager.runReportToPdf(input, paramer, 
/* 135:149 */           conn);
/* 136:    */         
/* 137:151 */         Document document = new Document();
/* 138:152 */         document.setByteArray(bs, 0, bs.length, "");
/* 139:    */         
/* 140:    */ 
/* 141:155 */         int pageCount = document.getNumberOfPages();
/* 142:156 */         String path = ftp.getLoaclPath() + 
/* 143:157 */           ftp.getRootList() + 
/* 144:158 */           "/" + 
/* 145:159 */           InvoiceAction.createFileNameByDate(evsVoucher
/* 146:160 */           .getJournalDate());
/* 147:161 */         mkd(ftpClient, path);
/* 148:162 */         mkd(ftpClient, "/icon" + path);
/* 149:163 */         float scale = 1.3F;
/* 150:164 */         float rotation = 0.0F;
/* 151:165 */         List<EvsImage> list = new ArrayList();
/* 152:    */         try
/* 153:    */         {
/* 154:167 */           for (int i = 0; i < pageCount; i++)
/* 155:    */           {
/* 156:170 */             BufferedImage img = (BufferedImage)
/* 157:171 */               document.getPageImage(i, 1, 2, rotation, scale);
/* 158:    */             
/* 159:    */ 
/* 160:    */ 
/* 161:    */ 
/* 162:176 */             String filePath = path + "/" + "V2_" + 
/* 163:177 */               voucherId + "_" + i + ".jpg";
/* 164:178 */             OutputStream output = ftpClient
/* 165:179 */               .storeFileStream(filePath);
/* 166:180 */             JPEGImageEncoder encoder = 
/* 167:181 */               JPEGCodec.createJPEGEncoder(output);
/* 168:182 */             JPEGEncodeParam param2 = encoder
/* 169:183 */               .getDefaultJPEGEncodeParam(img);
/* 170:184 */             param2.setQuality(1.0F, false);
/* 171:185 */             encoder.setJPEGEncodeParam(param2);
/* 172:186 */             encoder.encode(img);
/* 173:187 */             output.close();
/* 174:188 */             ftpClient.completePendingCommand();
/* 175:    */             
/* 176:    */ 
/* 177:    */ 
/* 178:192 */             int height = img.getHeight();
/* 179:193 */             int width = img.getWidth();
/* 180:194 */             height = height * 100 / width;
/* 181:195 */             Rectangle rect = new Rectangle(0, 0, 100, height);
/* 182:196 */             BufferedImage tag = new BufferedImage(rect.width, 
/* 183:197 */               rect.height, 1);
/* 184:198 */             tag.getGraphics().drawImage(img, 0, 0, rect.width, 
/* 185:199 */               rect.height, null);
/* 186:200 */             output = ftpClient.storeFileStream("/icon" + 
/* 187:201 */               filePath);
/* 188:    */             
/* 189:203 */             encoder = JPEGCodec.createJPEGEncoder(output);
/* 190:204 */             encoder.encode(tag);
/* 191:205 */             output.close();
/* 192:206 */             ftpClient.completePendingCommand();
/* 193:    */             
/* 194:    */ 
/* 195:209 */             EvsImage evsImage = new EvsImage();
/* 196:210 */             evsImage.setVoucherId(voucherId);
/* 197:211 */             evsImage.setImageUrl(filePath);
/* 198:212 */             this.log.error("图片路径为:" + filePath);
/* 199:213 */             evsImage.setCreatedBy(Long.valueOf(-1L));
/* 200:214 */             evsImage.setCreationDate(new Date());
/* 201:215 */             evsImage.setWebhostUrl(
/* 202:216 */               ftp.getWebAddress());
/* 203:217 */             evsImage.setLastUpdateBy(Long.valueOf(0L));
/* 204:218 */             evsImage.setLastUpdateDate(new Date());
/* 205:219 */             evsImage.setLastUpdateLogin(Long.valueOf(0L));
/* 206:220 */             evsImage
/* 207:221 */               .setLocalPath(ftp.getLoaclPath());
/* 208:222 */             list.add(evsImage);
/* 209:    */           }
/* 210:224 */           evsVoucher.setUpdateStatus("1");
/* 211:    */         }
/* 212:    */         catch (FileNotFoundException e2)
/* 213:    */         {
/* 214:227 */           e2.printStackTrace();
/* 215:228 */           this.log.error(e2.getMessage(), e2);
/* 216:229 */           evsVoucher.setUpdateStatus("0");
/* 217:    */         }
/* 218:    */         catch (Exception e1)
/* 219:    */         {
/* 220:232 */           e1.printStackTrace();
/* 221:233 */           this.log.error(e1.getMessage(), e1);
/* 222:234 */           evsVoucher.setUpdateStatus("2");
/* 223:235 */           list = new ArrayList();
/* 224:    */         }
/* 225:238 */         if ("0".equals(evsVoucher.getUpdateStatus())) {
/* 226:    */           break;
/* 227:    */         }
/* 228:239 */         evsVoucher.setLastUpdateBy(Long.valueOf(1L));
/* 229:240 */         evsVoucher.setLastUpdateDate(new Date());
/* 230:241 */         this.log.error("Thread开始修改数据库");
/* 231:242 */         this.evsImageDAO.updateImageInfo(evsVoucher, list);
/* 232:243 */         this.log.error("英文凭证封面" + evsVoucher.getVoucherId() + "生成结束");
/* 233:    */       }
/* 234:    */     }
/* 235:    */     catch (Exception e)
/* 236:    */     {
/* 237:250 */       e.printStackTrace();
/* 238:251 */       this.log.error(e.getMessage(), e);
/* 239:    */     }
/* 240:    */     finally
/* 241:    */     {
/* 242:253 */       conn.close();
/* 243:254 */       if ((ftpClient != null) && (ftpClient.isConnected()))
/* 244:    */       {
/* 245:256 */         ftpClient.disconnect();
/* 246:257 */         ftpClient = null;
/* 247:    */       }
/* 248:    */     }
/* 249:    */   }
/* 250:    */   
/* 251:    */   public static void mkd(FTPClient ftpClient, String filePath)
/* 252:    */     throws IOException
/* 253:    */   {
/* 254:264 */     String str = "";
/* 255:266 */     for (String path : filePath.split("/")) {
/* 256:267 */       if (!StringUtils.isBlank(path))
/* 257:    */       {
/* 258:270 */         str = str + path + "/";
/* 259:271 */         ftpClient.mkd(str);
/* 260:    */       }
/* 261:    */     }
/* 262:    */   }
/* 263:    */   
/* 264:    */   public IEvsImageDAO getEvsImageDAO()
/* 265:    */   {
/* 266:276 */     return this.evsImageDAO;
/* 267:    */   }
/* 268:    */   
/* 269:    */   public void setEvsImageDAO(IEvsImageDAO evsImageDAO)
/* 270:    */   {
/* 271:280 */     this.evsImageDAO = evsImageDAO;
/* 272:    */   }
/* 273:    */   
/* 274:    */   public IEvsFtpDAO getEvsFtpDAO()
/* 275:    */   {
/* 276:284 */     return this.evsFtpDAO;
/* 277:    */   }
/* 278:    */   
/* 279:    */   public void setEvsFtpDAO(IEvsFtpDAO evsFtpDAO)
/* 280:    */   {
/* 281:288 */     this.evsFtpDAO = evsFtpDAO;
/* 282:    */   }
/* 283:    */   
/* 284:    */   public List<EvsVoucher> getEvsVoucherList()
/* 285:    */   {
/* 286:294 */     return this.evsVoucherList;
/* 287:    */   }
/* 288:    */   
/* 289:    */   public void setEvsVoucherList(List<EvsVoucher> evsVoucherList)
/* 290:    */   {
/* 291:298 */     this.evsVoucherList = evsVoucherList;
/* 292:    */   }
/* 293:    */   
/* 294:    */   public Map<String, Object> getMap(Long voucherId)
/* 295:    */   {
/* 296:301 */     return this.evsImageDAO.getMap(voucherId);
/* 297:    */   }
/* 298:    */ }


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.common.invoice.action.ImageThreadDS
 * JD-Core Version:    0.7.0.1
 */