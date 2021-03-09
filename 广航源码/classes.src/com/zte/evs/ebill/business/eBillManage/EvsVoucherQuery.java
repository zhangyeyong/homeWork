/*   1:    */ package com.zte.evs.ebill.business.eBillManage;
/*   2:    */ 
/*   3:    */ import com.zte.eas.appframe.access.syscommon.EasUserInfo;
/*   4:    */ import com.zte.evs.ebill.access.eBillManage.IEvsVoucherDAO;
/*   5:    */ import com.zte.evs.ebill.common.EvsObjectUtils;
/*   6:    */ import com.zte.evs.ebill.common.invoice.util.StringUtils;
/*   7:    */ import com.zte.evs.ebill.model.eBillManage.EvsBookVoucherDetailV;
/*   8:    */ import com.zte.evs.ebill.model.eBillManage.EvsVoucher;
/*   9:    */ import com.zte.evs.ebill.model.eBillManage.EvsVoucherHistory;
/*  10:    */ import com.zte.evs.ebill.model.eBillManage.EvsVoucherLineV;
/*  11:    */ import com.zte.evs.ebill.model.eBillManage.EvsVoucherV;
/*  12:    */ import com.zte.evs.ebill.model.eBillManage.EvsVoucherVo;
/*  13:    */ import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
/*  14:    */ import com.zte.ssb.framework.base.util.PageInfo;
/*  15:    */ import java.math.BigInteger;
/*  16:    */ import java.text.ParseException;
/*  17:    */ import java.text.SimpleDateFormat;
/*  18:    */ import java.util.ArrayList;
/*  19:    */ import java.util.Calendar;
/*  20:    */ import java.util.HashMap;
/*  21:    */ import java.util.List;
/*  22:    */ import java.util.Map;
/*  23:    */ import org.apache.log4j.Logger;
/*  24:    */ 
/*  25:    */ public class EvsVoucherQuery
/*  26:    */   implements IEvsVoucherQuery
/*  27:    */ {
/*  28:    */   private IEvsVoucherDAO evsVoucherDAO;
/*  29: 47 */   Logger logger = Logger.getLogger(EvsVoucherQuery.class);
/*  30: 48 */   static Map<String, String> m = null;
/*  31:    */   
/*  32:    */   public List<EvsVoucherV> getBoeInfo(String boeNumStr, String periodName)
/*  33:    */   {
/*  34: 53 */     List<EvsVoucherV> list = new ArrayList();
/*  35: 54 */     List<EvsVoucherV> newList = new ArrayList();
/*  36: 55 */     List<String> newBoeNums = new ArrayList();
/*  37: 56 */     List<String> boeNums = new ArrayList();
/*  38: 57 */     list = this.evsVoucherDAO.getBoeInfo(boeNumStr, periodName);
/*  39: 58 */     if (list.size() > 0)
/*  40:    */     {
/*  41: 59 */       for (EvsVoucherV e : list) {
/*  42: 60 */         boeNums.add(e.getBoeNum());
/*  43:    */       }
/*  44: 63 */       for (String boeNum : boeNums)
/*  45:    */       {
/*  46: 64 */         String boeNumTemp = boeNum;
/*  47: 65 */         if (!newBoeNums.contains(boeNumTemp)) {
/*  48: 68 */           newBoeNums.add(boeNumTemp);
/*  49:    */         }
/*  50:    */       }
/*  51:    */     }
/*  52: 72 */     if (newBoeNums.size() > 0) {
/*  53: 73 */       for (String newBoeNum : newBoeNums)
/*  54:    */       {
/*  55: 74 */         EvsVoucherV e = new EvsVoucherV();
/*  56: 75 */         e.setBoeNum(newBoeNum);
/*  57: 76 */         newList.add(e);
/*  58:    */       }
/*  59:    */     }
/*  60: 79 */     return newList;
/*  61:    */   }
/*  62:    */   
/*  63:    */   public List<EvsVoucherV> getApVouchers(String boeNumStr)
/*  64:    */   {
/*  65: 87 */     List<EvsVoucherV> list = new ArrayList();
/*  66:    */     
/*  67: 89 */     List<String> boeList = new ArrayList();
/*  68:    */     
/*  69: 91 */     List<String> boeNumList = new ArrayList();
/*  70:    */     
/*  71: 93 */     List<String> newList = new ArrayList();
/*  72:    */     
/*  73: 95 */     list = this.evsVoucherDAO.getApVouchers(boeNumStr);
/*  74: 96 */     String[] boeNums = boeNumStr.split(",");
/*  75: 98 */     if (list.size() > 0) {
/*  76: 99 */       for (EvsVoucherV e : list) {
/*  77:100 */         boeList.add(e.getBoeNum());
/*  78:    */       }
/*  79:    */     }
/*  80:104 */     if (boeNums.length > 0) {
/*  81:105 */       for (String boeNum : boeNums) {
/*  82:106 */         newList.add(boeNum);
/*  83:    */       }
/*  84:    */     }
/*  85:110 */     for (String boeNum : newList) {
/*  86:111 */       if (!boeList.contains(boeNum)) {
/*  87:112 */         boeNumList.add(boeNum);
/*  88:    */       }
/*  89:    */     }
/*  90:116 */     if (boeNumList.size() > 0)
/*  91:    */     {
/*  92:117 */       EvsVoucherV e = null;
/*  93:118 */       for (String boeNum : boeNumList)
/*  94:    */       {
/*  95:119 */         e = new EvsVoucherV();
/*  96:120 */         e.setBoeNum(boeNum);
/*  97:121 */         list.add(e);
/*  98:    */       }
/*  99:    */     }
/* 100:124 */     return list;
/* 101:    */   }
/* 102:    */   
/* 103:    */   public List<EvsVoucherV> getPaymentVouchers(String boeNumStr, String journalNumStr)
/* 104:    */   {
/* 105:135 */     List<EvsVoucherV> newList = new ArrayList();
/* 106:136 */     if (journalNumStr.equals("tempstr")) {
/* 107:137 */       journalNumStr = "-100000";
/* 108:    */     }
/* 109:140 */     List<String> newJournalNums = new ArrayList();
/* 110:    */     
/* 111:142 */     String[] journalNums = journalNumStr.split(",");
/* 112:143 */     if (journalNums.length > 0) {
/* 113:144 */       for (String j : journalNums)
/* 114:    */       {
/* 115:145 */         if ("tempstr".equals(j)) {
/* 116:146 */           j = "-100000";
/* 117:    */         }
/* 118:148 */         newJournalNums.add(j);
/* 119:    */       }
/* 120:    */     }
/* 121:151 */     String[] nums = boeNumStr.split(",");
/* 122:152 */     for (int i = 0; i < nums.length; i++)
/* 123:    */     {
/* 124:153 */       Object tempList = this.evsVoucherDAO
/* 125:154 */         .getPaymentVouchers((String)newJournalNums.get(i));
/* 126:155 */       if ((tempList != null) && (((List)tempList).size() > 0))
/* 127:    */       {
/* 128:156 */         for (int j = 0; j < ((List)tempList).size(); j++)
/* 129:    */         {
/* 130:157 */           EvsVoucherV ev = (EvsVoucherV)((List)tempList).get(j);
/* 131:158 */           EvsVoucherV evs = new EvsVoucherV();
/* 132:159 */           evs.setBoeNum(nums[i]);
/* 133:160 */           evs.setJournalNum(ev == null ? "" : ev.getJournalNum());
/* 134:161 */           newList.add(evs);
/* 135:    */         }
/* 136:    */       }
/* 137:    */       else
/* 138:    */       {
/* 139:164 */         EvsVoucherV evs = new EvsVoucherV();
/* 140:165 */         evs.setBoeNum(nums[i]);
/* 141:166 */         evs.setJournalNum("");
/* 142:167 */         newList.add(evs);
/* 143:    */       }
/* 144:    */     }
/* 145:172 */     return newList;
/* 146:    */   }
/* 147:    */   
/* 148:    */   public TableDataInfo getVoucherList(EvsVoucherVo evsVoucherVo, int rangeStarts, int fetchSizes)
/* 149:    */   {
/* 150:191 */     TableDataInfo data = new TableDataInfo();
/* 151:    */     
/* 152:193 */     Map map = this.evsVoucherDAO.findVoucherByQry(evsVoucherVo, rangeStarts, 
/* 153:194 */       fetchSizes);
/* 154:195 */     data.setData((List)map.get("data"));
/* 155:196 */     data.setTotalCount(Integer.parseInt(map.get("totalCount").toString()));
/* 156:197 */     return data;
/* 157:    */   }
/* 158:    */   
/* 159:    */   public TableDataInfo findVoucherQueryV(EvsVoucherVo evsVoucherVo, int rangeStarts, int fetchSizes)
/* 160:    */   {
/* 161:215 */     TableDataInfo data = new TableDataInfo();
/* 162:    */     
/* 163:217 */     Map map = this.evsVoucherDAO.findVoucherQueryV(evsVoucherVo, rangeStarts, 
/* 164:218 */       fetchSizes);
/* 165:219 */     data.setData((List)map.get("data"));
/* 166:220 */     data.setTotalCount(Integer.parseInt(map.get("totalCount").toString()));
/* 167:221 */     return data;
/* 168:    */   }
/* 169:    */   
/* 170:    */   public TableDataInfo getVoucherFasciculeList(EvsVoucherVo evsVoucherVo, int rangeStarts, int fetchSizes)
/* 171:    */   {
/* 172:239 */     TableDataInfo data = new TableDataInfo();
/* 173:    */     
/* 174:241 */     Map map = this.evsVoucherDAO.findVoucherByQry(evsVoucherVo, rangeStarts, 
/* 175:242 */       fetchSizes);
/* 176:243 */     data.setData((List)map.get("data"));
/* 177:244 */     data.setTotalCount(Integer.parseInt(map.get("totalCount").toString()));
/* 178:245 */     return data;
/* 179:    */   }
/* 180:    */   
/* 181:    */   public List<Map<String, String>> getVoucherWhereNeedCreate(int pageSize)
/* 182:    */   {
/* 183:257 */     List<Map<String, String>> listMap = new ArrayList();
/* 184:258 */     List<EvsVoucherLineV> list = this.evsVoucherDAO
/* 185:259 */       .findVoucherWhereNeedCreate(pageSize);
/* 186:260 */     m = EvsVoucherCheckService.getCurrencyCodeLabel();
/* 187:263 */     if ((list != null) && (list.size() > 0))
/* 188:    */     {
/* 189:265 */       EvsVoucherLineV evsVoucherLineV = null;
/* 190:268 */       for (int i = 0; i < list.size(); i++)
/* 191:    */       {
/* 192:269 */         evsVoucherLineV = (EvsVoucherLineV)list.get(i);
/* 193:272 */         if (evsVoucherLineV != null)
/* 194:    */         {
/* 195:273 */           Map<String, String> map = evsVoucherLineV2Map(evsVoucherLineV);
/* 196:274 */           if (map != null) {
/* 197:275 */             listMap.add(map);
/* 198:    */           }
/* 199:    */         }
/* 200:    */       }
/* 201:    */     }
/* 202:280 */     return listMap;
/* 203:    */   }
/* 204:    */   
/* 205:    */   public Map<String, String> getVoucherById(Long voucherId)
/* 206:    */   {
/* 207:283 */     EvsVoucherLineV evsVoucherLineV = this.evsVoucherDAO.findVoucherVById(voucherId.longValue());
/* 208:284 */     if (evsVoucherLineV != null) {
/* 209:285 */       return evsVoucherLineV2Map(evsVoucherLineV);
/* 210:    */     }
/* 211:287 */     return null;
/* 212:    */   }
/* 213:    */   
/* 214:    */   public Map evsVoucherLineV2Map(EvsVoucherLineV evsVoucherLineV)
/* 215:    */   {
/* 216:    */     try
/* 217:    */     {
/* 218:292 */       Map<String, String> map = new HashMap();
/* 219:    */       
/* 220:294 */       map.put("VOUCHER_ID", evsVoucherLineV.getVoucherId());
/* 221:295 */       map.put("VENDOR_NUMBER", evsVoucherLineV.getVendorNumber());
/* 222:296 */       Calendar c = Calendar.getInstance();
/* 223:297 */       c.setTime(evsVoucherLineV.getJournalDate());
/* 224:298 */       map.put("JOURNAL_DATE", 
/* 225:299 */         evsVoucherLineV.getJournalDate());
/* 226:300 */       map.put("JOURNAL_YEAR", 
/* 227:301 */         c.get(1) + "-" + (c.get(2) + 1) + "-" + c.get(5));
/* 228:    */       
/* 229:    */ 
/* 230:    */ 
/* 231:    */ 
/* 232:    */ 
/* 233:    */ 
/* 234:308 */       map.put("JOURNAL_NUM", evsVoucherLineV.getJournalNum());
/* 235:    */       
/* 236:310 */       map.put("BOE_NUM", EvsVoucherCheckService.getBoeNum(evsVoucherLineV.getBoeNum()));
/* 237:311 */       map.put("USER_NUMBER", evsVoucherLineV.getUserNumber());
/* 238:312 */       map.put("VENDOR_NAME", evsVoucherLineV.getVendorName());
/* 239:313 */       map.put("INVOICE_TYPE", evsVoucherLineV.getInvoiceType());
/* 240:314 */       map.put("CHEQUE_NUMBER", evsVoucherLineV.getChequeNumber());
/* 241:315 */       map.put("ACCESSORY", evsVoucherLineV.getBillNum());
/* 242:316 */       map.put("APPROVER_NUMBER", null);
/* 243:317 */       map.put("VENDOR_LOCATION", evsVoucherLineV
/* 244:318 */         .getVendorLocation());
/* 245:319 */       map.put("PAY_NUMBER", evsVoucherLineV.getPayNumber());
/* 246:320 */       map.put("CHECK_NUMBER", 
/* 247:321 */         evsVoucherLineV.getCheckNumber());
/* 248:322 */       map.put("CURRENCY_CODE", evsVoucherLineV.getCurrencyCode());
/* 249:323 */       map.put("ORG_CHARGE", evsVoucherLineV.getOrgCharge());
/* 250:324 */       map.put("USER_NAME", evsVoucherLineV.getUserName());
/* 251:325 */       map.put("APPROVER", evsVoucherLineV.getApprover());
/* 252:326 */       map.put("FINANCE_EXECUTIVE", evsVoucherLineV.getFinanceExecutive());
/* 253:327 */       map.put("FINANCE_CONTROLLER", evsVoucherLineV.getFinanceController());
/* 254:328 */       map.put("CASHIER", evsVoucherLineV.getCashier());
/* 255:329 */       map.put("CHAMBERLAIN", evsVoucherLineV.getChamberlain());
/* 256:330 */       map.put("BILL_NUM", evsVoucherLineV.getBillNum());
/* 257:331 */       map.put("ACC_CR_COUNT", 
/* 258:332 */         evsVoucherLineV.getAccCrCount());
/* 259:333 */       map.put("ACC_DR_COUNT", 
/* 260:334 */         evsVoucherLineV.getAccDrCount());
/* 261:    */       
/* 262:336 */       map.put("ACC_CR_CN", 
/* 263:337 */         evsVoucherLineV.getAccCrCount());
/* 264:338 */       map.put("ACC_DR_CN", 
/* 265:339 */         evsVoucherLineV.getAccDrCount());
/* 266:    */       
/* 267:341 */       map.put("BATCH_NAME", evsVoucherLineV.getBatchName());
/* 268:342 */       map.put("JOURNAL_SUB_NAME", 
/* 269:343 */         evsVoucherLineV.getJournalSubName());
/* 270:344 */       map.put("SOURCE", evsVoucherLineV.getSource());
/* 271:345 */       map
/* 272:346 */         .put("PERIOD_NAME", 
/* 273:347 */         evsVoucherLineV.getPeriodName());
/* 274:348 */       map.put("CATEGORY_NAME", 
/* 275:349 */         evsVoucherLineV.getCategoryName());
/* 276:350 */       map.put("DOC_SEQUENCE_VALUE", 
/* 277:351 */         evsVoucherLineV.getDocSequenceValue());
/* 278:352 */       map.put("DOC_SEQUENCE_CODE", 
/* 279:353 */         evsVoucherLineV.getDocSequenceValue());
/* 280:354 */       map
/* 281:355 */         .put("INVOICE_NUM", 
/* 282:356 */         evsVoucherLineV.getInvoiceNum());
/* 283:357 */       map.put("barCode", evsVoucherLineV.getVoucherSeqValue());
/* 284:358 */       map.put("VOUCHER_SEQ_VALUE", evsVoucherLineV.getVoucherSeqValue());
/* 285:359 */       map.put("COMPANY_NAME", evsVoucherLineV.getCompanyTitleName());
/* 286:360 */       map.put("COMPANY_CODE", evsVoucherLineV.getCompanyCode());
/* 287:361 */       map.put("SET_OF_BOOK_NAME", evsVoucherLineV.getCompanyName());
/* 288:362 */       map.put("USER_NUMBER", null);
/* 289:363 */       map.put("CASHIER_NUMBER", evsVoucherLineV.getCashierNumber());
/* 290:364 */       map.put("CONVERT_RATE", evsVoucherLineV.getConvertRate());
/* 291:368 */       if ("RMB".equals(evsVoucherLineV.getCurrencyCode()))
/* 292:    */       {
/* 293:369 */         map.put("CURRENCY_AMOUNT_COUNT", null);
/* 294:370 */         if (evsVoucherLineV.getAccCrCount() != null) {
/* 295:371 */           map.put("CURRENCY_AMOUNT_CN", 
/* 296:372 */             (m.get(evsVoucherLineV.getCurrencyCode()) == null ? "" : (String)m.get(evsVoucherLineV.getCurrencyCode())) + StringUtils.numberToChinese(Double.parseDouble(evsVoucherLineV.getAccCrCount())));
/* 297:    */         }
/* 298:    */       }
/* 299:375 */       else if ((evsVoucherLineV.getCurrencyAmountCount() != null) && (evsVoucherLineV.getCurrencyAmountCount().trim().length() > 0) && (!evsVoucherLineV.getCurrencyAmountCount().trim().toLowerCase().equals("null")))
/* 300:    */       {
/* 301:376 */         map.put("CURRENCY_AMOUNT_COUNT", 
/* 302:377 */           evsVoucherLineV.getCurrencyAmountCount());
/* 303:378 */         map.put("CURRENCY_AMOUNT_CN", (m.get(evsVoucherLineV.getCurrencyCode()) == null ? "" : (String)m.get(evsVoucherLineV.getCurrencyCode())) + StringUtils.numberToChinese(Double.parseDouble(evsVoucherLineV.getCurrencyAmountCount())));
/* 304:    */       }
/* 305:    */       else
/* 306:    */       {
/* 307:380 */         map.put("CURRENCY_AMOUNT_COUNT", "0");
/* 308:381 */         map.put("CURRENCY_AMOUNT_CN", "");
/* 309:    */       }
/* 310:384 */       return map;
/* 311:    */     }
/* 312:    */     catch (Exception e)
/* 313:    */     {
/* 314:386 */       this.logger.error("VOUCHER_ID为" + evsVoucherLineV.getVoucherId() + "的凭证装载数据异常：" + e.getMessage(), e);
/* 315:    */     }
/* 316:388 */     return null;
/* 317:    */   }
/* 318:    */   
/* 319:    */   public List<Map<String, String>> getHistoryWhereNeedCreate(int pageSize)
/* 320:    */   {
/* 321:399 */     List<Map<String, String>> listMap = new ArrayList();
/* 322:400 */     List<EvsVoucher> list = this.evsVoucherDAO
/* 323:401 */       .findHistoryWhereNeedCreate(pageSize);
/* 324:404 */     if ((list != null) && (list.size() > 0))
/* 325:    */     {
/* 326:405 */       Map<String, String> map = null;
/* 327:406 */       EvsVoucher evsVoucher = null;
/* 328:409 */       for (int i = 0; i < list.size(); i++)
/* 329:    */       {
/* 330:410 */         evsVoucher = (EvsVoucher)list.get(i);
/* 331:413 */         if (evsVoucher != null)
/* 332:    */         {
/* 333:414 */           map = new HashMap();
/* 334:    */           
/* 335:416 */           map.put("VOUCHER_ID", evsVoucher.getVoucherId());
/* 336:417 */           map.put("BOE_NUM", evsVoucher.getBoeNum());
/* 337:418 */           map.put("INVOICE_ID", evsVoucher.getInvoiceId());
/* 338:419 */           map.put("INVOICE_DATE", " " + evsVoucher.getInvoiceDate());
/* 339:420 */           map.put("INVOICE_NUM", evsVoucher.getInvoiceNum());
/* 340:421 */           map.put("VENDOR_NAME", "供应商名称：" + 
/* 341:422 */             evsVoucher.getVendorName());
/* 342:423 */           map.put("VENDOR_LOCATION", "供应商地点：" + 
/* 343:424 */             evsVoucher.getVendorLocation());
/* 344:425 */           map.put("barCode", evsVoucher.getBarcode());
/* 345:    */           
/* 346:427 */           listMap.add(map);
/* 347:    */         }
/* 348:    */       }
/* 349:    */     }
/* 350:431 */     return listMap;
/* 351:    */   }
/* 352:    */   
/* 353:    */   public void updateVoucherUpdateStatus(Long voucherId, int updateStauts)
/* 354:    */   {
/* 355:443 */     this.evsVoucherDAO.updateVoucherUpdateStatus(voucherId, updateStauts);
/* 356:    */   }
/* 357:    */   
/* 358:    */   public void updateVoucherHisUpdateStatus(Long voucherId, int hisUpdateStatus)
/* 359:    */   {
/* 360:455 */     this.evsVoucherDAO.updateVoucherHisUpdateStatus(voucherId, hisUpdateStatus);
/* 361:    */   }
/* 362:    */   
/* 363:    */   public TableDataInfo getAllHistoryForVoucher(EvsVoucherHistory evsVoucherHistory, int rangeStarts, int fetchSizes)
/* 364:    */   {
/* 365:473 */     TableDataInfo data = new TableDataInfo();
/* 366:474 */     String voucherId = evsVoucherHistory.getObjectCode();
/* 367:475 */     Map map = this.evsVoucherDAO.findAllHistoryForVoucher(voucherId, 
/* 368:476 */       rangeStarts, fetchSizes);
/* 369:477 */     data.setData((List)map.get("data"));
/* 370:478 */     data.setTotalCount(Integer.parseInt(map.get("totalCount").toString()));
/* 371:479 */     return data;
/* 372:    */   }
/* 373:    */   
/* 374:    */   public TableDataInfo getVoucherListByCondition(EvsBookVoucherDetailV evsBookVoucherDetailV, int type, int rangeStarts, int fetchSizes)
/* 375:    */   {
/* 376:486 */     TableDataInfo data = new TableDataInfo();
/* 377:487 */     List list = new ArrayList();
/* 378:488 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
/* 379:489 */     PageInfo page = this.evsVoucherDAO.findVoucherByQryCondition(
/* 380:490 */       evsBookVoucherDetailV, type, rangeStarts, fetchSizes);
/* 381:491 */     if (page == null) {
/* 382:492 */       return data;
/* 383:    */     }
/* 384:494 */     for (Object[] obj : (List)page.getResult()) {
/* 385:495 */       if (obj != null)
/* 386:    */       {
/* 387:496 */         evsBookVoucherDetailV = new EvsBookVoucherDetailV();
/* 388:497 */         if (obj[0] != null) {
/* 389:498 */           evsBookVoucherDetailV.setNum(
/* 390:499 */             BigInteger.valueOf(Long.parseLong(obj[0].toString())));
/* 391:    */         }
/* 392:501 */         if (obj[1] != null) {
/* 393:502 */           evsBookVoucherDetailV.setVoucherId(
/* 394:503 */             BigInteger.valueOf(Long.parseLong(obj[1].toString())));
/* 395:    */         }
/* 396:505 */         if (obj[2] != null) {
/* 397:506 */           evsBookVoucherDetailV.setBookCode(obj[2].toString());
/* 398:    */         }
/* 399:509 */         if (obj[4] != null) {
/* 400:510 */           evsBookVoucherDetailV.setPackageCode(obj[4].toString());
/* 401:    */         }
/* 402:512 */         if (obj[5] != null) {
/* 403:513 */           evsBookVoucherDetailV.setJournalNum(obj[5].toString());
/* 404:    */         }
/* 405:515 */         if (obj[6] != null) {
/* 406:516 */           evsBookVoucherDetailV.setSubDocName(obj[6].toString());
/* 407:    */         }
/* 408:518 */         if (obj[7] != null) {
/* 409:519 */           evsBookVoucherDetailV.setSetBookName(obj[7].toString());
/* 410:    */         }
/* 411:521 */         if (obj[8] != null) {
/* 412:522 */           evsBookVoucherDetailV.setSource(obj[8].toString());
/* 413:    */         }
/* 414:524 */         if (obj[9] != null) {
/* 415:525 */           evsBookVoucherDetailV.setOuId(obj[9].toString());
/* 416:    */         }
/* 417:527 */         if (obj[11] != null) {
/* 418:528 */           evsBookVoucherDetailV.setOuName(obj[11].toString());
/* 419:    */         }
/* 420:530 */         if (obj[12] != null) {
/* 421:531 */           evsBookVoucherDetailV.setPeriodName(obj[12].toString());
/* 422:    */         }
/* 423:533 */         if (obj[13] != null) {
/* 424:534 */           evsBookVoucherDetailV.setInvoiceType(obj[13].toString());
/* 425:    */         }
/* 426:536 */         if (obj[14] != null) {
/* 427:537 */           evsBookVoucherDetailV.setMatchMode(obj[14].toString());
/* 428:    */         }
/* 429:539 */         if (obj[15] != null) {
/* 430:540 */           evsBookVoucherDetailV.setUserName(obj[15].toString());
/* 431:    */         }
/* 432:542 */         if (obj[16] != null) {
/* 433:543 */           evsBookVoucherDetailV.setApprover(obj[16].toString());
/* 434:    */         }
/* 435:546 */         if (obj[17] != null) {
/* 436:    */           try
/* 437:    */           {
/* 438:548 */             evsBookVoucherDetailV.setCreatedDate(sdf.parse(obj[17]
/* 439:549 */               .toString()));
/* 440:    */           }
/* 441:    */           catch (ParseException e)
/* 442:    */           {
/* 443:551 */             e.printStackTrace();
/* 444:    */           }
/* 445:    */         }
/* 446:555 */         if (obj[18] != null) {
/* 447:    */           try
/* 448:    */           {
/* 449:557 */             evsBookVoucherDetailV.setApproverDate(sdf.parse(obj[18]
/* 450:558 */               .toString()));
/* 451:    */           }
/* 452:    */           catch (ParseException e)
/* 453:    */           {
/* 454:560 */             e.printStackTrace();
/* 455:    */           }
/* 456:    */         }
/* 457:563 */         if (obj[19] != null) {
/* 458:564 */           evsBookVoucherDetailV.setBarcode(obj[19].toString());
/* 459:    */         }
/* 460:566 */         if (obj[20] != null) {
/* 461:567 */           evsBookVoucherDetailV.setVoucherStatus(obj[20].toString());
/* 462:    */         }
/* 463:569 */         if (obj[23] != null) {
/* 464:570 */           evsBookVoucherDetailV.setArchiveNumber(obj[23].toString());
/* 465:    */         }
/* 466:572 */         if (obj[24] != null) {
/* 467:573 */           evsBookVoucherDetailV.setBarName(obj[24].toString());
/* 468:    */         } else {
/* 469:575 */           evsBookVoucherDetailV.setBarName(evsBookVoucherDetailV
/* 470:576 */             .getBarName());
/* 471:    */         }
/* 472:578 */         list.add(evsBookVoucherDetailV);
/* 473:    */       }
/* 474:    */     }
/* 475:581 */     if (list.size() != 0)
/* 476:    */     {
/* 477:582 */       data.setData(list);
/* 478:583 */       data.setTotalCount((int)page.getTotalCount());
/* 479:    */     }
/* 480:585 */     return data;
/* 481:    */   }
/* 482:    */   
/* 483:    */   public TableDataInfo getAddFasciculeList(EvsVoucherVo evsVoucherVo, int rangeStarts, int fetchSizes)
/* 484:    */   {
/* 485:597 */     TableDataInfo data = new TableDataInfo();
/* 486:598 */     Map map = this.evsVoucherDAO.findFasciculeByQry(evsVoucherVo, rangeStarts, 
/* 487:599 */       fetchSizes);
/* 488:600 */     data.setData((List)map.get("data"));
/* 489:601 */     data.setTotalCount(Integer.parseInt(map.get("totalCount").toString()));
/* 490:602 */     return data;
/* 491:    */   }
/* 492:    */   
/* 493:    */   public TableDataInfo getAddVoucherList(EvsVoucherVo evsVoucherVo, int rangeStarts, int fetchSizes)
/* 494:    */   {
/* 495:613 */     TableDataInfo data = new TableDataInfo();
/* 496:614 */     Map map = this.evsVoucherDAO.findVoucherList(evsVoucherVo, rangeStarts, 
/* 497:615 */       fetchSizes);
/* 498:616 */     data.setData((List)map.get("data"));
/* 499:617 */     data.setTotalCount(Integer.parseInt(map.get("totalCount").toString()));
/* 500:618 */     return data;
/* 501:    */   }
/* 502:    */   
/* 503:    */   public int findBookCountByQry(EvsVoucherVo evsVoucherVo)
/* 504:    */   {
/* 505:626 */     return this.evsVoucherDAO.findBookCountByQry(evsVoucherVo);
/* 506:    */   }
/* 507:    */   
/* 508:    */   public TableDataInfo getVoucherInspect(EvsVoucherVo evsVoucherVo, int rangeStarts, int fetchSizes)
/* 509:    */   {
/* 510:637 */     TableDataInfo data = new TableDataInfo();
/* 511:638 */     List list = new ArrayList();
/* 512:639 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
/* 513:640 */     PageInfo page = this.evsVoucherDAO.findVoucherInspect(evsVoucherVo, rangeStarts, fetchSizes);
/* 514:641 */     if (page == null) {
/* 515:642 */       return data;
/* 516:    */     }
/* 517:644 */     VoucherInspect vi = null;
/* 518:645 */     for (Object[] obj : (List)page.getResult()) {
/* 519:646 */       if (obj != null)
/* 520:    */       {
/* 521:647 */         vi = new VoucherInspect();
/* 522:648 */         if (obj[0] != null) {
/* 523:649 */           vi.setCompanyCode(obj[0].toString());
/* 524:    */         }
/* 525:651 */         if (obj[1] != null) {
/* 526:652 */           vi.setCompanyName(obj[1].toString());
/* 527:    */         }
/* 528:654 */         if (obj[2] != null) {
/* 529:655 */           vi.setA1(obj[2].toString());
/* 530:    */         }
/* 531:657 */         if (obj[3] != null) {
/* 532:658 */           vi.setA2(obj[3].toString());
/* 533:    */         }
/* 534:660 */         if (obj[4] != null) {
/* 535:661 */           vi.setA3(obj[4].toString());
/* 536:    */         }
/* 537:663 */         if (obj[5] != null) {
/* 538:664 */           vi.setA4(obj[5].toString());
/* 539:    */         }
/* 540:666 */         if (obj[6] != null) {
/* 541:667 */           vi.setA5(obj[6].toString());
/* 542:    */         }
/* 543:669 */         if (obj[7] != null) {
/* 544:670 */           vi.setA6(obj[7].toString());
/* 545:    */         }
/* 546:672 */         if (obj[8] != null) {
/* 547:673 */           vi.setA7(obj[8].toString());
/* 548:    */         }
/* 549:675 */         if (obj[9] != null) {
/* 550:676 */           vi.setCOUNTS(obj[9].toString());
/* 551:    */         }
/* 552:686 */         list.add(vi);
/* 553:    */       }
/* 554:    */     }
/* 555:689 */     if (list.size() != 0)
/* 556:    */     {
/* 557:690 */       data.setData(list);
/* 558:691 */       data.setTotalCount((int)page.getTotalCount());
/* 559:    */     }
/* 560:693 */     return data;
/* 561:    */   }
/* 562:    */   
/* 563:    */   public String fetchCurrentUserInfoPK()
/* 564:    */   {
/* 565:698 */     EvsObjectUtils ou = new EvsObjectUtils();
/* 566:    */     
/* 567:700 */     EasUserInfo user = EvsObjectUtils.getUserInfoBySession();
/* 568:701 */     return user.getUserInfoPk().toString();
/* 569:    */   }
/* 570:    */   
/* 571:    */   public IEvsVoucherDAO getEvsVoucherDAO()
/* 572:    */   {
/* 573:710 */     return this.evsVoucherDAO;
/* 574:    */   }
/* 575:    */   
/* 576:    */   public void setEvsVoucherDAO(IEvsVoucherDAO evsVoucherDAO)
/* 577:    */   {
/* 578:718 */     this.evsVoucherDAO = evsVoucherDAO;
/* 579:    */   }
/* 580:    */ }


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.eBillManage.EvsVoucherQuery
 * JD-Core Version:    0.7.0.1
 */