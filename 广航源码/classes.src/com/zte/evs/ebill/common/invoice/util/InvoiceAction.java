/*   1:    */ package com.zte.evs.ebill.common.invoice.util;
/*   2:    */ 
/*   3:    */ import com.zte.evs.ebill.access.eBillManage.IEvsImageDAO;
/*   4:    */ import com.zte.evs.ebill.access.eBillManage.IEvsVoucherDAO;
/*   5:    */ import com.zte.evs.ebill.business.eBillManage.IEvsBillHistoriesService;
/*   6:    */ import com.zte.evs.ebill.business.eBillManage.IEvsFtpService;
/*   7:    */ import com.zte.evs.ebill.business.eBillManage.IEvsImageService;
/*   8:    */ import com.zte.evs.ebill.business.eBillManage.IEvsVoucherLineQuery;
/*   9:    */ import com.zte.evs.ebill.business.eBillManage.IEvsVoucherQuery;
/*  10:    */ import com.zte.evs.ebill.common.invoice.action.IImageThreadDS;
/*  11:    */ import com.zte.evs.ebill.common.invoice.model.Invoice;
/*  12:    */ import com.zte.evs.ebill.common.invoice.model.InvoiceLine;
/*  13:    */ import com.zte.evs.ebill.common.invoice.model.InvoicePageContext;
/*  14:    */ import com.zte.evs.ebill.model.eBillManage.EvsFtp;
/*  15:    */ import com.zte.evs.ebill.model.eBillManage.EvsImage;
/*  16:    */ import com.zte.evs.ebill.model.eBillManage.EvsVoucher;
/*  17:    */ import com.zte.ssb.AccessPropertiesFile;
/*  18:    */ import com.zte.ssb.framework.SSBBus;
/*  19:    */ import java.awt.Font;
/*  20:    */ import java.awt.Graphics2D;
/*  21:    */ import java.awt.RenderingHints;
/*  22:    */ import java.awt.geom.AffineTransform;
/*  23:    */ import java.awt.image.BufferedImage;
/*  24:    */ import java.awt.image.RenderedImage;
/*  25:    */ import java.io.IOException;
/*  26:    */ import java.io.InputStream;
/*  27:    */ import java.io.OutputStream;
/*  28:    */ import java.io.PrintStream;
/*  29:    */ import java.text.SimpleDateFormat;
/*  30:    */ import java.util.Calendar;
/*  31:    */ import java.util.Date;
/*  32:    */ import java.util.HashMap;
/*  33:    */ import java.util.List;
/*  34:    */ import java.util.Map;
/*  35:    */ import javax.imageio.ImageIO;
/*  36:    */ import org.apache.axis.utils.StringUtils;
/*  37:    */ import org.apache.log4j.Logger;
/*  38:    */ import sun.net.ftp.FtpClient;
/*  39:    */ 
/*  40:    */ public class InvoiceAction
/*  41:    */ {
/*  42: 66 */   private static boolean IS_WORKING = false;
/*  43: 67 */   private Logger log = Logger.getLogger(getClass());
/*  44: 68 */   private static String localPath = null;
/*  45:    */   private EvsFtp ftp;
/*  46:    */   
/*  47:    */   private String getLocalPath()
/*  48:    */   {
/*  49: 71 */     if (localPath == null) {
/*  50: 72 */       localPath = AccessPropertiesFile.getValue("FTP_LOCAL_PATH");
/*  51:    */     }
/*  52: 74 */     if (localPath == null) {
/*  53: 75 */       localPath = "";
/*  54:    */     }
/*  55: 77 */     return localPath;
/*  56:    */   }
/*  57:    */   
/*  58:    */   static enum VoucherType
/*  59:    */   {
/*  60: 82 */     PAY("总账", 2);
/*  61:    */     
/*  62:    */     private int value;
/*  63:    */     private String name;
/*  64:    */     
/*  65:    */     private VoucherType(String name, int value)
/*  66:    */     {
/*  67: 87 */       this.name = name;
/*  68: 88 */       this.value = value;
/*  69:    */     }
/*  70:    */     
/*  71:    */     public int getValue()
/*  72:    */     {
/*  73: 92 */       return this.value;
/*  74:    */     }
/*  75:    */     
/*  76:    */     public void setValue(int value)
/*  77:    */     {
/*  78: 96 */       this.value = value;
/*  79:    */     }
/*  80:    */     
/*  81:    */     public String getName()
/*  82:    */     {
/*  83:100 */       return this.name;
/*  84:    */     }
/*  85:    */     
/*  86:    */     public void setName(String name)
/*  87:    */     {
/*  88:104 */       this.name = name;
/*  89:    */     }
/*  90:    */   }
/*  91:    */   
/*  92:108 */   private FtpClient client = null;
/*  93:110 */   private String ftpDir = "invoice";
/*  94:    */   private static final String ICON = "icon";
/*  95:    */   private static final int ICON_WIDTH = 100;
/*  96:    */   
/*  97:    */   public InvoiceAction()
/*  98:    */   {
/*  99:115 */     if (this.client == null) {
/* 100:116 */       getFtpClient();
/* 101:    */     }
/* 102:    */   }
/* 103:    */   
/* 104:    */   private void initFtp()
/* 105:    */   {
/* 106:125 */     IEvsFtpService evsFtpService = (IEvsFtpService)
/* 107:126 */       SSBBus.findDomainService("evsFtpServiceDS");
/* 108:127 */     this.ftp = evsFtpService.getFtpUser();
/* 109:    */   }
/* 110:    */   
/* 111:    */   private void getFtpClient()
/* 112:    */   {
/* 113:135 */     if (this.ftp == null) {
/* 114:136 */       initFtp();
/* 115:    */     }
/* 116:    */     try
/* 117:    */     {
/* 118:139 */       this.client = new FtpClient(this.ftp.getFtpAddress(), 
/* 119:140 */         this.ftp.getFtpPort().intValue());
/* 120:141 */       this.client.login(this.ftp.getFtpUserName(), this.ftp.getFtpPwd());
/* 121:142 */       this.client.binary();
/* 122:143 */       this.client.sendServer("PASV");
/* 123:    */     }
/* 124:    */     catch (Exception e)
/* 125:    */     {
/* 126:145 */       this.log.error("FTP登录不成功", e);
/* 127:    */     }
/* 128:    */   }
/* 129:    */   
/* 130:    */   private void closeFtpClient()
/* 131:    */   {
/* 132:154 */     if (this.client != null) {
/* 133:    */       try
/* 134:    */       {
/* 135:156 */         this.client.closeServer();
/* 136:    */       }
/* 137:    */       catch (IOException e)
/* 138:    */       {
/* 139:158 */         this.log.error(e.getMessage(), e);
/* 140:    */       }
/* 141:    */     }
/* 142:    */   }
/* 143:    */   
/* 144:    */   public void getInvoiceResult()
/* 145:    */   {
/* 146:170 */     this.log.error("InvoiceAction getInvoiceResult begin");
/* 147:    */     
/* 148:    */ 
/* 149:    */ 
/* 150:    */ 
/* 151:175 */     this.log.error("------InvoiceAction 凭证生成服务 开始---------");
/* 152:176 */     if (IS_WORKING)
/* 153:    */     {
/* 154:177 */       this.log.error("--------------上一任务还未完成。当前任务取消.............");
/* 155:178 */       return;
/* 156:    */     }
/* 157:180 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 158:181 */     this.log.error("启动任务...启动时间=" + sdf.format(new Date()));
/* 159:182 */     IS_WORKING = true;
/* 160:    */     try
/* 161:    */     {
/* 162:184 */       int needCreateCount = 0;
/* 163:    */       try
/* 164:    */       {
/* 165:186 */         needCreateCount = Integer.valueOf(AccessPropertiesFile.getValue("createNeedCount")).intValue();
/* 166:    */       }
/* 167:    */       catch (Exception e)
/* 168:    */       {
/* 169:188 */         needCreateCount = 1000;
/* 170:    */       }
/* 171:191 */       IImageThreadDS imageThreadDS = (IImageThreadDS)SSBBus.findCommonService("imageThreadDS");
/* 172:192 */       imageThreadDS.buildImage();
/* 173:    */     }
/* 174:    */     catch (Exception e)
/* 175:    */     {
/* 176:245 */       this.log.error("生成凭证封面异常:" + e.getMessage(), e);
/* 177:    */     }
/* 178:    */     finally
/* 179:    */     {
/* 180:247 */       IS_WORKING = false;
/* 181:248 */       this.log.error("------InvoiceAction 凭证生成服务 结束--------- 结束时间=" + sdf.format(new Date()));
/* 182:    */     }
/* 183:    */   }
/* 184:    */   
/* 185:    */   public String buildInvoiceById(long voucherId)
/* 186:    */     throws Exception
/* 187:    */   {
/* 188:253 */     this.log.error("InvoiceAction getInvoiceResult begin");
/* 189:    */     
/* 190:    */ 
/* 191:    */ 
/* 192:    */ 
/* 193:258 */     this.log.error("------InvoiceAction 凭证生成服务 开始---------");
/* 194:259 */     IEvsVoucherQuery evsVoucherQuery = (IEvsVoucherQuery)
/* 195:260 */       SSBBus.findDomainService("evsVoucherQueryDS");
/* 196:    */     
/* 197:262 */     Map<String, String> map = evsVoucherQuery.getVoucherById(Long.valueOf(voucherId));
/* 198:    */     
/* 199:264 */     createInvoiceById(map, Long.valueOf(voucherId), null);
/* 200:    */     
/* 201:    */ 
/* 202:267 */     closeFtpClient();
/* 203:    */     
/* 204:269 */     this.log.error("------InvoiceAction 凭证生成服务 结束---------");
/* 205:270 */     return null;
/* 206:    */   }
/* 207:    */   
/* 208:    */   public void getInvoiceHistory()
/* 209:    */   {
/* 210:282 */     IEvsVoucherQuery evsVoucherQuery = (IEvsVoucherQuery)
/* 211:283 */       SSBBus.findDomainService("evsVoucherQueryDS");
/* 212:    */     
/* 213:    */ 
/* 214:    */ 
/* 215:287 */     List<Map<String, String>> list = evsVoucherQuery
/* 216:288 */       .getHistoryWhereNeedCreate(60);
/* 217:    */     
/* 218:    */ 
/* 219:291 */     IEvsBillHistoriesService evsBillHistoryQuery = (IEvsBillHistoriesService)
/* 220:292 */       SSBBus.findDomainService("evsBillHistoriesServiceDS");
/* 221:293 */     List<Map<String, String>> listLine = null;
/* 222:295 */     if ((list != null) && (list.size() > 0))
/* 223:    */     {
/* 224:296 */       Map<String, String> map = new HashMap();
/* 225:    */       
/* 226:298 */       Long voucherId = Long.valueOf(0L);
/* 227:299 */       String boeNum = "";
/* 228:301 */       for (int i = 0; i < list.size(); i++)
/* 229:    */       {
/* 230:302 */         map = (Map)list.get(i);
/* 231:304 */         if ((map != null) && 
/* 232:305 */           (map.containsKey("VOUCHER_ID")) && 
/* 233:306 */           (map.get("VOUCHER_ID") != null) && 
/* 234:307 */           (map.containsKey("BOE_NUM")) && 
/* 235:308 */           (map.get("BOE_NUM") != null))
/* 236:    */         {
/* 237:309 */           voucherId = Long.valueOf(Long.parseLong((String)map.get("VOUCHER_ID")));
/* 238:310 */           boeNum = (String)map.get("BOE_NUM");
/* 239:311 */           listLine = evsBillHistoryQuery
/* 240:312 */             .getHistoryByBoeNum(boeNum);
/* 241:315 */           if ((listLine != null) && (listLine.size() > 0)) {
/* 242:    */             try
/* 243:    */             {
/* 244:317 */               boolean invoiceTag = createInvoiceHis(map, 
/* 245:318 */                 listLine, 
/* 246:319 */                 4, 
/* 247:320 */                 voucherId);
/* 248:322 */               if (invoiceTag) {
/* 249:324 */                 evsVoucherQuery.updateVoucherHisUpdateStatus(
/* 250:325 */                   voucherId, 1);
/* 251:    */               } else {
/* 252:327 */                 evsVoucherQuery.updateVoucherUpdateStatus(
/* 253:328 */                   voucherId, 2);
/* 254:    */               }
/* 255:    */             }
/* 256:    */             catch (Exception e)
/* 257:    */             {
/* 258:331 */               this.log.error(e.getMessage());
/* 259:    */               
/* 260:333 */               evsVoucherQuery.updateVoucherUpdateStatus(
/* 261:334 */                 voucherId, 2);
/* 262:    */             }
/* 263:    */           }
/* 264:    */         }
/* 265:    */       }
/* 266:    */     }
/* 267:343 */     closeFtpClient();
/* 268:    */   }
/* 269:    */   
/* 270:    */   private boolean createInvoice(Map<String, String> map, List<Map<String, String>> listLine, int invoiceType, Long voucherId, String barCode)
/* 271:    */     throws Exception
/* 272:    */   {
/* 273:361 */     return createInvoice(map, listLine, invoiceType, voucherId, barCode, 
/* 274:362 */       null);
/* 275:    */   }
/* 276:    */   
/* 277:    */   private boolean createInvoice(Map<String, String> map, List<Map<String, String>> listLine, int invoiceType, Long voucherId, String barCode, String operate)
/* 278:    */     throws Exception
/* 279:    */   {
/* 280:368 */     boolean invoiceTag = true;
/* 281:    */     
/* 282:    */ 
/* 283:371 */     IEvsImageService evsImageService = (IEvsImageService)
/* 284:372 */       SSBBus.findDomainService("evsImageServiceDS");
/* 285:    */     
/* 286:    */ 
/* 287:    */ 
/* 288:    */ 
/* 289:377 */     InvoiceImage invoiceImage = new InvoiceImage(invoiceType, map, listLine);
/* 290:    */     
/* 291:379 */     List<InvoicePageContext> invoicePageContexts = invoiceImage
/* 292:380 */       .getInvoicePageContext();
/* 293:    */     
/* 294:    */ 
/* 295:383 */     int count = 0;
/* 296:    */     
/* 297:    */ 
/* 298:386 */     IEvsImageDAO evsImageDAO = (IEvsImageDAO)SSBBus.findCommonService("evsImageDAO");
/* 299:387 */     evsImageDAO.deleteImageById(voucherId);
/* 300:388 */     for (InvoicePageContext invoicePageContext : invoicePageContexts) {
/* 301:389 */       if (invoicePageContext != null)
/* 302:    */       {
/* 303:392 */         ImageBuffer pct = new ImageBuffer();
/* 304:393 */         List<Invoice> invoiceList = invoicePageContext.getInvoice();
/* 305:    */         
/* 306:395 */         this.log.error("导入凭证模板" + 
/* 307:396 */           invoicePageContext.getModelUrl());
/* 308:397 */         BufferedImage bufImg = pct.loadImageLocal(
/* 309:398 */           invoicePageContext.getModelUrl());
/* 310:400 */         for (Invoice invoice : invoiceList) {
/* 311:401 */           if (invoice != null)
/* 312:    */           {
/* 313:404 */             pct = new ImageBuffer(invoice.getWriteX(), invoice.getWriteY(), 
/* 314:405 */               invoice.getFont(), invoice.getTag());
/* 315:407 */             if (!invoice.getCodeTag())
/* 316:    */             {
/* 317:408 */               pct.setBufImg(bufImg);
/* 318:    */               
/* 319:410 */               pct.toArray(invoice.getStrValue());
/* 320:411 */               bufImg = pct.getBufImg();
/* 321:    */             }
/* 322:    */           }
/* 323:    */         }
/* 324:430 */         IEvsVoucherDAO evsVoucherDAO = (IEvsVoucherDAO)SSBBus.findDaoService("evsVoucherDAO");
/* 325:431 */         EvsVoucher evsVoucher = evsVoucherDAO.findEvsVoucherVByVoucherId(voucherId);
/* 326:432 */         Date d = evsVoucher.getJournalDate();
/* 327:433 */         if (d == null) {
/* 328:434 */           d = new Date();
/* 329:    */         }
/* 330:436 */         String fileName = createFileNameByDate(d) + "/V" + invoiceType + "_" + voucherId + "_" + count + 
/* 331:437 */           ".jpg";
/* 332:438 */         this.log.error("InvoiceAction  fileName:" + fileName);
/* 333:    */         
/* 334:    */ 
/* 335:    */ 
/* 336:442 */         boolean isTag = uploadFtp(fileName, bufImg);
/* 337:445 */         if (isTag)
/* 338:    */         {
/* 339:446 */           createIcon(this.ftp.getLoaclPath() + this.ftp.getRootList(), "/" + fileName);
/* 340:    */           
/* 341:448 */           EvsImage evsImage = new EvsImage();
/* 342:449 */           evsImage.setVoucherId(voucherId);
/* 343:450 */           evsImage.setImageUrl(this.ftp.getLoaclPath() + this.ftp.getRootList() + "/" + fileName);
/* 344:451 */           evsImage.setCreatedBy(Long.valueOf(-1L));
/* 345:452 */           evsImage.setCreationDate(new Date());
/* 346:453 */           evsImage.setWebhostUrl(this.ftp.getWebAddress());
/* 347:454 */           evsImage.setLastUpdateBy(Long.valueOf(0L));
/* 348:455 */           evsImage.setLastUpdateDate(new Date());
/* 349:456 */           evsImage.setLastUpdateLogin(Long.valueOf(0L));
/* 350:457 */           evsImage.setLocalPath(this.ftp.getLoaclPath());
/* 351:458 */           evsImage.setCompanyCode(evsVoucher.getCompanyCode());
/* 352:    */           
/* 353:    */ 
/* 354:461 */           evsImageService.saveImage(evsImage);
/* 355:    */         }
/* 356:    */         else
/* 357:    */         {
/* 358:463 */           invoiceTag = false;
/* 359:    */         }
/* 360:470 */         count++;
/* 361:    */       }
/* 362:    */     }
/* 363:473 */     this.log.error("凭证生成成功");
/* 364:474 */     return invoiceTag;
/* 365:    */   }
/* 366:    */   
/* 367:    */   private boolean createInvoiceById(Map<String, String> map, Long voucherId, String operate)
/* 368:    */     throws Exception
/* 369:    */   {
/* 370:480 */     IEvsVoucherLineQuery evsVoucherLineQuery = (IEvsVoucherLineQuery)
/* 371:481 */       SSBBus.findDomainService("evsVoucherLineQueryDS");
/* 372:482 */     List<Map<String, String>> listLine = null;
/* 373:483 */     boolean invoiceTag = true;
/* 374:485 */     for (VoucherType voucherType : VoucherType.values())
/* 375:    */     {
/* 376:486 */       listLine = evsVoucherLineQuery.findLineByVoucherId(voucherId, 
/* 377:487 */         voucherType.getName());
/* 378:489 */       if ((listLine != null) && (listLine.size() > 0))
/* 379:    */       {
/* 380:491 */         invoiceTag = createInvoice(map, listLine, 
/* 381:492 */           voucherType.getValue(), voucherId, (String)map.get("barCode"), operate);
/* 382:493 */         if (!invoiceTag) {
/* 383:494 */           return invoiceTag;
/* 384:    */         }
/* 385:    */       }
/* 386:    */     }
/* 387:499 */     return invoiceTag;
/* 388:    */   }
/* 389:    */   
/* 390:    */   private boolean createInvoiceHis(Map<String, String> map, List<Map<String, String>> listLine, int invoiceType, Long voucherId)
/* 391:    */     throws Exception
/* 392:    */   {
/* 393:518 */     boolean invoiceTag = true;
/* 394:    */     
/* 395:    */ 
/* 396:521 */     IEvsImageService evsImageService = (IEvsImageService)
/* 397:522 */       SSBBus.findDomainService("evsImageServiceDS");
/* 398:    */     
/* 399:    */ 
/* 400:    */ 
/* 401:    */ 
/* 402:527 */     InvoiceImage invoiceImage = new InvoiceImage(invoiceType, map, listLine);
/* 403:    */     
/* 404:529 */     List<InvoicePageContext> invoicePageContexts = invoiceImage
/* 405:530 */       .getInvoicePageContext();
/* 406:    */     
/* 407:    */ 
/* 408:533 */     int count = 0;
/* 409:534 */     for (InvoicePageContext invoicePageContext : invoicePageContexts) {
/* 410:535 */       if (invoicePageContext != null)
/* 411:    */       {
/* 412:538 */         ImageBuffer pct = new ImageBuffer();
/* 413:539 */         List<Invoice> invoiceList = invoicePageContext.getInvoice();
/* 414:    */         
/* 415:541 */         BufferedImage bufImg = pct.loadImageLocal(
/* 416:542 */           invoicePageContext.getModelUrl());
/* 417:544 */         for (Invoice invoice : invoiceList) {
/* 418:545 */           if (invoice != null)
/* 419:    */           {
/* 420:548 */             pct = new ImageBuffer(invoice.getWriteX(), invoice.getWriteY(), 
/* 421:549 */               invoice.getFont(), invoice.getTag());
/* 422:550 */             pct.setBufImg(bufImg);
/* 423:551 */             pct.toArray(invoice.getStrValue());
/* 424:552 */             bufImg = pct.getBufImg();
/* 425:    */           }
/* 426:    */         }
/* 427:555 */         List<InvoiceLine> invoiceLines = invoicePageContext
/* 428:556 */           .getInvoiceLine();
/* 429:557 */         int x = 0;
/* 430:558 */         int y = 0;
/* 431:559 */         for (InvoiceLine invoiceLine : invoiceLines) {
/* 432:560 */           if (invoiceLine != null)
/* 433:    */           {
/* 434:563 */             if ((x != 0) && (x > invoiceLine.getStartX())) {
/* 435:564 */               x = invoiceLine.getStartX();
/* 436:565 */             } else if (x == 0) {
/* 437:566 */               x = invoiceLine.getStartX();
/* 438:    */             }
/* 439:568 */             if ((y != 0) && (y < invoiceLine.getEndY())) {
/* 440:569 */               y = invoiceLine.getEndY();
/* 441:570 */             } else if (y == 0) {
/* 442:571 */               y = invoiceLine.getEndY();
/* 443:    */             }
/* 444:573 */             bufImg = pct.pressTable(bufImg, invoiceLine.getStartX(), 
/* 445:574 */               invoiceLine.getStartY(), invoiceLine.getEndX(), 
/* 446:575 */               invoiceLine.getEndY(), invoiceLine.getLineWidth());
/* 447:    */           }
/* 448:    */         }
/* 449:580 */         pct = new ImageBuffer(x, y + 60 + 34, 
/* 450:581 */           new Font("宋体", 1, 34), false);
/* 451:582 */         pct.setBufImg(bufImg);
/* 452:583 */         pct.toArray("收款人签字：");
/* 453:584 */         bufImg = pct.getBufImg();
/* 454:    */         
/* 455:586 */         pct.pressLine(bufImg, x + 204, y + 60 + 38, 240, 4);
/* 456:    */         
/* 457:    */ 
/* 458:    */ 
/* 459:590 */         String fileName = createFileNameByDate(new Date()) + "/V" + invoiceType + "_" + voucherId + "_" + count + 
/* 460:591 */           ".jpg";
/* 461:    */         
/* 462:593 */         boolean isTag = uploadFtp(fileName, bufImg);
/* 463:596 */         if (isTag)
/* 464:    */         {
/* 465:597 */           createIcon(this.ftp.getLoaclPath() + this.ftp.getRootList(), "/" + fileName);
/* 466:    */           
/* 467:599 */           EvsImage evsImage = new EvsImage();
/* 468:600 */           evsImage.setVoucherId(voucherId);
/* 469:601 */           evsImage.setImageUrl(this.ftp.getLoaclPath() + this.ftp.getRootList() + "/" + this.ftpDir + "/" + 
/* 470:602 */             fileName);
/* 471:603 */           evsImage.setCreatedBy(Long.valueOf(-1L));
/* 472:604 */           evsImage.setCreationDate(new Date());
/* 473:605 */           evsImage.setWebhostUrl(this.ftp.getWebAddress());
/* 474:606 */           evsImage.setLastUpdateBy(Long.valueOf(0L));
/* 475:607 */           evsImage.setLastUpdateDate(new Date());
/* 476:608 */           evsImage.setLastUpdateLogin(Long.valueOf(0L));
/* 477:609 */           evsImage.setLocalPath(this.ftp.getLoaclPath());
/* 478:    */           
/* 479:611 */           evsImageService.saveImage(evsImage);
/* 480:    */         }
/* 481:    */         else
/* 482:    */         {
/* 483:613 */           invoiceTag = false;
/* 484:    */         }
/* 485:620 */         count++;
/* 486:    */       }
/* 487:    */     }
/* 488:623 */     this.log.error("历史记录生成成功");
/* 489:624 */     return invoiceTag;
/* 490:    */   }
/* 491:    */   
/* 492:    */   private boolean uploadFtp(String fileName, RenderedImage image)
/* 493:    */   {
/* 494:638 */     if (this.client == null) {
/* 495:639 */       getFtpClient();
/* 496:    */     }
/* 497:642 */     OutputStream os = null;
/* 498:    */     try
/* 499:    */     {
/* 500:646 */       String fileURI = this.ftp.getLoaclPath() + 
/* 501:647 */         this.ftp.getRootList() + "/" + fileName;
/* 502:648 */       String[] fileNames = fileURI.split("/");
/* 503:    */       
/* 504:650 */       this.log.error(fileURI);
/* 505:    */       try
/* 506:    */       {
/* 507:652 */         os = this.client.put(fileURI);
/* 508:    */       }
/* 509:    */       catch (Exception e)
/* 510:    */       {
/* 511:654 */         for (int i = 1; i < fileNames.length - 1; i++)
/* 512:    */         {
/* 513:655 */           System.out.println(fileNames[i] + "========");
/* 514:656 */           if (!isDirExist(fileNames[i], this.client).booleanValue()) {
/* 515:657 */             createDir(fileNames[i], this.client);
/* 516:    */           }
/* 517:    */         }
/* 518:660 */         for (int i = 1; i < fileNames.length - 1; i++) {
/* 519:    */           try
/* 520:    */           {
/* 521:662 */             this.client.cdUp();
/* 522:    */           }
/* 523:    */           catch (IOException e2)
/* 524:    */           {
/* 525:665 */             e2.printStackTrace();
/* 526:    */           }
/* 527:    */         }
/* 528:668 */         os = this.client.put(getLocalPath() + fileURI);
/* 529:    */       }
/* 530:671 */       new TiffImage().createJPGImageFromBuffer(image, os, 300);
/* 531:    */     }
/* 532:    */     catch (Exception e)
/* 533:    */     {
/* 534:673 */       this.log.error(e.getMessage(), e);
/* 535:674 */       return false;
/* 536:    */     }
/* 537:    */     finally
/* 538:    */     {
/* 539:    */       try
/* 540:    */       {
/* 541:677 */         if (os != null) {
/* 542:678 */           os.close();
/* 543:    */         }
/* 544:    */       }
/* 545:    */       catch (IOException e)
/* 546:    */       {
/* 547:680 */         this.log.error(e.getMessage(), e);
/* 548:    */       }
/* 549:    */     }
/* 550:684 */     return true;
/* 551:    */   }
/* 552:    */   
/* 553:    */   private boolean createIcon(String localPath, String fileName)
/* 554:    */   {
/* 555:689 */     if (this.client == null) {
/* 556:690 */       getFtpClient();
/* 557:    */     }
/* 558:693 */     OutputStream os = null;
/* 559:    */     try
/* 560:    */     {
/* 561:698 */       String fileURI = "/icon" + localPath + fileName;
/* 562:699 */       String[] fileNames = fileURI.split("/");
/* 563:700 */       this.log.error(fileURI);
/* 564:701 */       InputStream ins = this.client.get(localPath + fileName);
/* 565:702 */       BufferedImage source = ImageIO.read(ins);
/* 566:703 */       int type = source.getType();
/* 567:704 */       double sx = 100.0D / source.getWidth();
/* 568:705 */       int height = (int)(sx * source.getHeight());
/* 569:706 */       BufferedImage target = new BufferedImage(100, height, type);
/* 570:707 */       Graphics2D g = target.createGraphics();
/* 571:    */       
/* 572:709 */       g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
/* 573:710 */       g.drawRenderedImage(source, AffineTransform.getScaleInstance(sx, sx));
/* 574:711 */       g.dispose();
/* 575:    */       try
/* 576:    */       {
/* 577:714 */         os = this.client.put(fileURI);
/* 578:    */       }
/* 579:    */       catch (Exception e)
/* 580:    */       {
/* 581:716 */         if (!StringUtils.isEmpty(getLocalPath())) {
/* 582:717 */           this.client.cd(getLocalPath());
/* 583:    */         }
/* 584:719 */         for (int i = 1; i < fileNames.length - 1; i++)
/* 585:    */         {
/* 586:720 */           System.out.println(fileNames[i] + "========");
/* 587:721 */           if (!isDirExist(fileNames[i], this.client).booleanValue()) {
/* 588:722 */             createDir(fileNames[i], this.client);
/* 589:    */           }
/* 590:    */         }
/* 591:726 */         for (int i = 1; i < fileNames.length - 1; i++) {
/* 592:    */           try
/* 593:    */           {
/* 594:728 */             this.client.cdUp();
/* 595:    */           }
/* 596:    */           catch (IOException e2)
/* 597:    */           {
/* 598:730 */             e2.printStackTrace();
/* 599:    */           }
/* 600:    */         }
/* 601:733 */         fileURI = getLocalPath() + "/" + "icon" + localPath + fileName;
/* 602:734 */         this.log.error(fileURI);
/* 603:735 */         os = this.client.put(fileURI);
/* 604:    */       }
/* 605:738 */       new TiffImage().createJPGImageFromBuffer(target, os, 72);
/* 606:    */     }
/* 607:    */     catch (Exception e)
/* 608:    */     {
/* 609:740 */       this.log.error(e.getMessage(), e);
/* 610:741 */       return false;
/* 611:    */     }
/* 612:    */     finally
/* 613:    */     {
/* 614:    */       try
/* 615:    */       {
/* 616:744 */         if (os != null) {
/* 617:745 */           os.close();
/* 618:    */         }
/* 619:    */       }
/* 620:    */       catch (IOException e)
/* 621:    */       {
/* 622:747 */         this.log.error(e.getMessage(), e);
/* 623:    */       }
/* 624:    */     }
/* 625:751 */     return true;
/* 626:    */   }
/* 627:    */   
/* 628:    */   private Boolean isDirExist(String dir, FtpClient ftpClient)
/* 629:    */   {
/* 630:    */     try
/* 631:    */     {
/* 632:757 */       ftpClient.cd(dir);
/* 633:    */     }
/* 634:    */     catch (Exception e)
/* 635:    */     {
/* 636:759 */       return Boolean.valueOf(false);
/* 637:    */     }
/* 638:761 */     return Boolean.valueOf(true);
/* 639:    */   }
/* 640:    */   
/* 641:    */   private void createDir(String dir, FtpClient ftpClient)
/* 642:    */   {
/* 643:766 */     ftpClient.sendServer("MKD " + dir + "\r\n");
/* 644:    */     try
/* 645:    */     {
/* 646:769 */       ftpClient.readServerResponse();
/* 647:770 */       ftpClient.cd(dir);
/* 648:    */     }
/* 649:    */     catch (IOException e)
/* 650:    */     {
/* 651:772 */       this.log.error(e.getMessage(), e);
/* 652:    */     }
/* 653:    */   }
/* 654:    */   
/* 655:    */   public static String createFileNameByDate(Date d)
/* 656:    */   {
/* 657:777 */     Calendar c = Calendar.getInstance();
/* 658:778 */     c.setTime(d);
/* 659:779 */     return c.get(1) + "/" + (c.get(2) + 1) + "/" + c.get(5);
/* 660:    */   }
/* 661:    */   
/* 662:    */   public static void main(String[] args) {}
/* 663:    */ }


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.common.invoice.util.InvoiceAction
 * JD-Core Version:    0.7.0.1
 */