/*    1:     */ package com.zte.evs.ebill.access.eBillManage;
/*    2:     */ 
/*    3:     */ import com.zte.eas.appframe.access.syscommon.EasUserInfo;
/*    4:     */ import com.zte.eimage.business.baseconfig.util.EidObjectUtils;
/*    5:     */ import com.zte.evs.ebill.common.EvsObjectUtils;
/*    6:     */ import com.zte.evs.ebill.common.ObjectCopyUtils;
/*    7:     */ import com.zte.evs.ebill.model.eBillManage.EvsBook;
/*    8:     */ import com.zte.evs.ebill.model.eBillManage.EvsBookModel;
/*    9:     */ import com.zte.evs.ebill.model.eBillManage.EvsBookStatisticV;
/*   10:     */ import com.zte.evs.ebill.model.eBillManage.EvsBookV;
/*   11:     */ import com.zte.evs.ebill.model.eBillManage.EvsInventory;
/*   12:     */ import com.zte.evs.ebill.model.eBillManage.EvsStatisticField;
/*   13:     */ import com.zte.evs.ebill.model.eBillManage.EvsStorageDoc;
/*   14:     */ import com.zte.evs.ebill.model.eBillManage.EvsVoucher;
/*   15:     */ import com.zte.evs.ebill.model.eBillManage.EvsVoucherBookPackage;
/*   16:     */ import com.zte.evs.ebill.model.eBillManage.EvsVoucherSelect;
/*   17:     */ import com.zte.evs.ebill.model.eBillManage.EvsVoucherV;
/*   18:     */ import com.zte.evs.ebill.model.eBillManage.FasciculeQueryModel;
/*   19:     */ import com.zte.ssb.framework.base.BaseDAO;
/*   20:     */ import com.zte.ssb.framework.base.util.PageInfo;
/*   21:     */ import com.zte.ssb.framework.util.Util;
/*   22:     */ import com.zte.ssb.orm.zorm.ZormTemplate;
/*   23:     */ import com.zte.ssb.util.Assert;
/*   24:     */ import com.zte.ssb.zorm.Query;
/*   25:     */ import com.zte.ssb.zorm.SQLQuery;
/*   26:     */ import com.zte.ssb.zorm.Session;
/*   27:     */ import java.io.PrintStream;
/*   28:     */ import java.math.BigDecimal;
/*   29:     */ import java.math.BigInteger;
/*   30:     */ import java.sql.CallableStatement;
/*   31:     */ import java.sql.Connection;
/*   32:     */ import java.sql.PreparedStatement;
/*   33:     */ import java.sql.ResultSet;
/*   34:     */ import java.sql.ResultSetMetaData;
/*   35:     */ import java.sql.SQLException;
/*   36:     */ import java.util.ArrayList;
/*   37:     */ import java.util.Date;
/*   38:     */ import java.util.HashMap;
/*   39:     */ import java.util.Iterator;
/*   40:     */ import java.util.List;
/*   41:     */ import java.util.Map;
/*   42:     */ import org.apache.commons.logging.Log;
/*   43:     */ import org.apache.commons.logging.LogFactory;
/*   44:     */ 
/*   45:     */ public class EvsBookDAO
/*   46:     */   extends BaseDAO
/*   47:     */   implements IEvsBookDAO
/*   48:     */ {
/*   49:  54 */   private static final Log log = LogFactory.getLog(EvsBookDAO.class);
/*   50:     */   private EidObjectUtils objectUtils;
/*   51:     */   
/*   52:     */   public String getDocNameBySubName(String subDocName)
/*   53:     */   {
/*   54:  66 */     String query = "";
/*   55:  67 */     if ((subDocName != null) && (!"".equals(subDocName)))
/*   56:     */     {
/*   57:  68 */       String sql = "select a.doc_name from evs_doc_type a where a.doc_id =(  select t.doc_id from evs_sub_doc_type t where t.sub_doc_name='" + 
/*   58:     */       
/*   59:  70 */         subDocName + "')";
/*   60:  71 */       List temp = getSession().createSQLQuery(sql).list();
/*   61:  72 */       if ((temp != null) && (temp.size() > 0)) {
/*   62:  73 */         query = temp.get(0).toString();
/*   63:     */       }
/*   64:     */     }
/*   65:  76 */     return query;
/*   66:     */   }
/*   67:     */   
/*   68:     */   public String getDocName(String subDocCode)
/*   69:     */   {
/*   70:  87 */     String query = "";
/*   71:  88 */     if ((subDocCode != null) && (!"".equals(subDocCode)))
/*   72:     */     {
/*   73:  89 */       String sql = " select a.doc_name from evs.evs_doc_type a where a.doc_id =(  select t.doc_id  from evs.evs_sub_doc_type t  where t.sub_doc_code = '" + 
/*   74:     */       
/*   75:  91 */         subDocCode + "' )";
/*   76:  92 */       List temp = getSession().createSQLQuery(sql).list();
/*   77:  93 */       if ((temp != null) && (temp.size() > 0)) {
/*   78:  94 */         query = temp.get(0).toString();
/*   79:     */       }
/*   80:     */     }
/*   81:  97 */     return query;
/*   82:     */   }
/*   83:     */   
/*   84:     */   public String isVoucherBooked(EvsBookModel bookModel)
/*   85:     */   {
/*   86: 112 */     if ((bookModel.getSubdoccode() != null) && 
/*   87: 113 */       (!"".equals(bookModel.getSubdoccode())))
/*   88:     */     {
/*   89: 116 */       String hql = " select a.sub_doc_name from evs_sub_doc_type a where a.sequence_number <(  select t.sequence_number from evs_sub_doc_type t where t.sub_doc_code='" + 
/*   90:     */       
/*   91: 118 */         bookModel.getSubdoccode() + 
/*   92: 119 */         "' ) " + 
/*   93: 120 */         " and a.sequence_number is not null order by a.sequence_number desc ";
/*   94: 121 */       List query = getSession().createSQLQuery(hql).list();
/*   95: 122 */       String queryValue = null;
/*   96: 123 */       if ((query != null) && (query.size() > 0)) {
/*   97: 124 */         for (int i = 0; i < query.size(); i++)
/*   98:     */         {
/*   99: 125 */           queryValue = query.get(i).toString();
/*  100: 126 */           String sql = "select count(t.voucher_id) from evs.evs_voucher t where t.journal_name = '" + 
/*  101:     */           
/*  102: 128 */             queryValue + 
/*  103: 129 */             "' " + 
/*  104: 130 */             " and t.ou_id = " + 
/*  105: 131 */             bookModel.getCompanyId() + 
/*  106: 132 */             " and t.period_name = '" + 
/*  107: 133 */             bookModel.getPeriodName() + 
/*  108: 134 */             "' " + 
/*  109: 135 */             "  and t.voucher_status = 'BOOKED' ";
/*  110: 136 */           String sql2 = "select count(t.voucher_id) from evs.evs_voucher t where t.journal_name = '" + 
/*  111:     */           
/*  112: 138 */             queryValue + 
/*  113: 139 */             "' " + 
/*  114: 140 */             " and t.ou_id = " + 
/*  115: 141 */             bookModel.getCompanyId() + 
/*  116: 142 */             " and t.period_name = '" + 
/*  117: 143 */             bookModel.getPeriodName() + "' ";
/*  118: 144 */           if (Integer.parseInt(getSession().createSQLQuery(sql)
/*  119: 145 */             .list().get(0).toString()) != 
/*  120: 146 */             Integer.parseInt(getSession().createSQLQuery(sql2).list()
/*  121: 147 */             .get(0).toString())) {
/*  122: 148 */             return "false;" + queryValue;
/*  123:     */           }
/*  124:     */         }
/*  125:     */       }
/*  126:     */     }
/*  127: 155 */     return "true";
/*  128:     */   }
/*  129:     */   
/*  130:     */   public PageInfo findEmployeesByQry(EvsBookModel bookModel, int start, int pageSize)
/*  131:     */   {
/*  132: 171 */     EvsObjectUtils ou = new EvsObjectUtils();
/*  133:     */     
/*  134: 173 */     EasUserInfo user = EvsObjectUtils.getUserInfoBySession();
/*  135: 174 */     StringBuffer sb = new StringBuffer();
/*  136: 175 */     List<Object> paras = new ArrayList(1);
/*  137: 176 */     sb.append("FROM EvsBookV t WHERE 1=1");
/*  138: 177 */     boolean likeSelect = "Y".equals(bookModel.getLikeSelect().trim());
/*  139: 179 */     if (((!Util.isStrEmpty(bookModel.getBeginBookCode().toUpperCase())) || 
/*  140: 180 */       (!Util.isStrEmpty(bookModel.getBeginBookCode().toLowerCase()))) && (!likeSelect))
/*  141:     */     {
/*  142: 181 */       sb.append(" AND t.bookCode >= ?");
/*  143: 182 */       paras.add(bookModel.getBeginBookCode().trim());
/*  144:     */     }
/*  145:     */     else
/*  146:     */     {
/*  147: 184 */       sb.append(" AND t.bookCode like ?");
/*  148: 185 */       paras.add("%" + bookModel.getBeginBookCode().trim() + "%");
/*  149:     */     }
/*  150: 187 */     if (((!Util.isStrEmpty(bookModel.getEndBookCode().toUpperCase())) || 
/*  151: 188 */       (!Util.isStrEmpty(bookModel.getEndBookCode().toLowerCase()))) && (!likeSelect))
/*  152:     */     {
/*  153: 189 */       sb.append(" AND t.bookCode <= ?");
/*  154: 190 */       paras.add(bookModel.getEndBookCode().trim());
/*  155:     */     }
/*  156: 198 */     if ((!Util.isStrEmpty(bookModel.getCompanyCode())) && (!likeSelect))
/*  157:     */     {
/*  158: 199 */       sb.append(" AND t.companyCode = ?");
/*  159: 200 */       paras.add(bookModel.getCompanyCode().toString());
/*  160:     */     }
/*  161:     */     else
/*  162:     */     {
/*  163: 202 */       sb.append(" AND t.companyName like ?");
/*  164: 203 */       paras.add("%" + bookModel.getCompanyName() + "%");
/*  165:     */     }
/*  166: 206 */     if (!Util.isStrEmpty(bookModel.getPeriodName()))
/*  167:     */     {
/*  168: 207 */       sb.append(" AND t.periodName = ?");
/*  169: 208 */       paras.add(bookModel.getPeriodName().toString());
/*  170:     */     }
/*  171: 211 */     if ((!Util.isStrEmpty(bookModel.getSelected())) && 
/*  172: 212 */       (!"change".equals(
/*  173: 213 */       bookModel.getSelected())))
/*  174:     */     {
/*  175: 214 */       sb.append(" AND t.bookStatus = ?");
/*  176: 215 */       paras.add(bookModel.getSelected().toString());
/*  177:     */     }
/*  178: 218 */     if ((!Util.isStrEmpty(bookModel.getBookPeople())) && (!likeSelect))
/*  179:     */     {
/*  180: 219 */       sb.append(" AND t.bookPeople = ?");
/*  181: 220 */       paras.add(bookModel.getBookPeople().toString());
/*  182:     */     }
/*  183:     */     else
/*  184:     */     {
/*  185: 222 */       sb.append(" AND t.bookPeople like ?");
/*  186: 223 */       paras.add("%" + bookModel.getBookPeople().toString() + "%");
/*  187:     */     }
/*  188: 226 */     if (!Util.isStrEmpty(bookModel.getBookDateStart()))
/*  189:     */     {
/*  190: 227 */       sb.append(" AND to_char(t.bookDate, 'yyyy-mm-dd') >= ? ");
/*  191: 228 */       paras.add(bookModel.getBookDateStart().toString());
/*  192:     */     }
/*  193: 230 */     if (!Util.isStrEmpty(bookModel.getBookDateEnd()))
/*  194:     */     {
/*  195: 231 */       sb.append(" AND to_char(t.bookDate, 'yyyy-mm-dd') <= ? ");
/*  196: 232 */       paras.add(bookModel.getBookDateEnd().toString());
/*  197:     */     }
/*  198: 240 */     sb.append(" AND t.bookStatus NOT IN ('UNBOOK') ");
/*  199:     */     
/*  200:     */ 
/*  201: 243 */     sb.append(" ORDER BY t.bookCode asc");
/*  202: 244 */     System.out.println(sb.toString());
/*  203: 245 */     PageInfo page = super.PageInfoQuery(sb.toString(), 
/*  204: 246 */       start / pageSize + 1, pageSize, paras.toArray());
/*  205: 247 */     return page;
/*  206:     */   }
/*  207:     */   
/*  208:     */   public void save(EvsBook transientInstance)
/*  209:     */   {
/*  210: 258 */     log.debug("saving TBook instance");
/*  211:     */     try
/*  212:     */     {
/*  213: 261 */       getSession().save(transientInstance);
/*  214: 262 */       log.debug("save successful");
/*  215:     */     }
/*  216:     */     catch (RuntimeException re)
/*  217:     */     {
/*  218: 264 */       log.error("save failed", re);
/*  219: 265 */       throw re;
/*  220:     */     }
/*  221:     */   }
/*  222:     */   
/*  223:     */   public void update(EvsBook persistentInstance)
/*  224:     */   {
/*  225: 277 */     log.debug("deleting TBook instance");
/*  226:     */     try
/*  227:     */     {
/*  228: 280 */       getSession().update(persistentInstance);
/*  229: 281 */       log.debug("delete successful");
/*  230:     */     }
/*  231:     */     catch (RuntimeException re)
/*  232:     */     {
/*  233: 283 */       log.error("delete failed", re);
/*  234: 284 */       throw re;
/*  235:     */     }
/*  236:     */   }
/*  237:     */   
/*  238:     */   public List<Long> getJournalNum(EvsBookModel bookModel)
/*  239:     */   {
/*  240: 296 */     List<Long> list = null;
/*  241:     */     
/*  242: 298 */     String sql = null;
/*  243: 301 */     if (bookModel.getBeginBookCode().hashCode() > bookModel.getEndBookCode().hashCode()) {
/*  244: 302 */       sql = 
/*  245:     */       
/*  246:     */ 
/*  247:     */ 
/*  248:     */ 
/*  249:     */ 
/*  250:     */ 
/*  251:     */ 
/*  252:     */ 
/*  253:     */ 
/*  254:     */ 
/*  255:     */ 
/*  256:     */ 
/*  257:     */ 
/*  258:     */ 
/*  259:     */ 
/*  260:     */ 
/*  261:     */ 
/*  262:     */ 
/*  263:     */ 
/*  264:     */ 
/*  265: 323 */         " select voucher_Id from Evs_Voucher  where 1=1 and journal_Num is not null  and journal_Num >= '" + bookModel.getEndBookCode() + "' and journal_Num <= '" + bookModel.getBeginBookCode() + "' and voucher_Status in ('" + "UNBOOK" + "','" + "CHECKED" + "')" + " AND ou_Name = (select a.check_unit_name from  FBP_CHECK_UNIT_CONTENTS a where a.erp_org_id='" + bookModel.getCompanyCode() + "' and rownum=1 ) AND ou_Id =" + bookModel.getBookPeople() + " " + " AND period_Name ='" + bookModel.getPeriodName() + "' " + " and  instr((select voucher_Type from Evs_Sub_Doc_Type   where sub_Doc_Name='" + bookModel.getSubdocname() + "'" + " and rownum=1 ),invoice_Type)>0 " + " order by JOURNAL_NUM";
/*  266: 327 */     } else if (bookModel.getBeginBookCode().hashCode() <= bookModel.getEndBookCode().hashCode()) {
/*  267: 328 */       sql = 
/*  268:     */       
/*  269:     */ 
/*  270:     */ 
/*  271:     */ 
/*  272:     */ 
/*  273:     */ 
/*  274:     */ 
/*  275:     */ 
/*  276:     */ 
/*  277:     */ 
/*  278:     */ 
/*  279:     */ 
/*  280:     */ 
/*  281:     */ 
/*  282:     */ 
/*  283:     */ 
/*  284:     */ 
/*  285:     */ 
/*  286:     */ 
/*  287:     */ 
/*  288:     */ 
/*  289:     */ 
/*  290:     */ 
/*  291:     */ 
/*  292:     */ 
/*  293:     */ 
/*  294: 355 */         " select voucher_Id from Evs_Voucher  where 1=1 and journal_Num is not null  and journal_Num >= '" + bookModel.getBeginBookCode() + "' and journal_Num <= '" + bookModel.getEndBookCode() + "' and ((voucher_Status in ('" + "UNBOOK" + "','" + "CHECKED" + "'))" + " or (journal_Num = '" + bookModel.getBeginBookCode() + "') or" + " (journal_Num = '" + bookModel.getEndBookCode() + "'))" + " AND ou_Name = (select a.check_unit_name from  FBP_CHECK_UNIT_CONTENTS a where a.erp_org_id='" + bookModel.getCompanyCode() + "' and rownum=1 ) AND ou_Id =" + bookModel.getBookPeople() + " " + " AND period_Name ='" + bookModel.getPeriodName() + "' " + " and  instr((select voucher_Type from Evs_Sub_Doc_Type   where sub_Doc_Name='" + bookModel.getSubdocname() + "'" + " and rownum=1 ),invoice_Type)>0 " + " order by JOURNAL_NUM";
/*  295:     */     }
/*  296:     */     try
/*  297:     */     {
/*  298: 358 */       SQLQuery query = getSession().createSQLQuery(sql);
/*  299: 359 */       list = query.list();
/*  300:     */     }
/*  301:     */     catch (Exception e)
/*  302:     */     {
/*  303: 362 */       e.printStackTrace();
/*  304:     */     }
/*  305: 364 */     return list;
/*  306:     */   }
/*  307:     */   
/*  308:     */   public Map findEvsHeaderByQry(EvsBookModel evsBookModel, int start, int pageSize)
/*  309:     */   {
/*  310: 379 */     String[] headerNums = (String[])null;
/*  311: 380 */     StringBuffer sb = new StringBuffer();
/*  312: 381 */     List<Object> paras = new ArrayList(1);
/*  313:     */     
/*  314:     */ 
/*  315: 384 */     String bookId = evsBookModel.getBookId();
/*  316: 385 */     Map map = new HashMap();
/*  317: 386 */     if ((bookId != null) && (!"undefined".equals(bookId)))
/*  318:     */     {
/*  319: 387 */       sb.append("from EvsVoucherBookV e where 2>1 ");
/*  320:     */       
/*  321: 389 */       sb.append(" and e.voucherId  in ( select t.voucherId FROM EvsVoucherBookPackage t WHERE 1=1 ");
/*  322: 391 */       if (!Util.isStrEmpty(bookId)) {
/*  323: 392 */         sb.append(" AND t.bookId = " + bookId + ") ");
/*  324:     */       }
/*  325: 396 */       if (!Util.isStrEmpty(evsBookModel.getCompanyCode()))
/*  326:     */       {
/*  327: 397 */         sb.append(" AND e.companyCode = ?");
/*  328: 398 */         paras.add(evsBookModel.getCompanyCode());
/*  329:     */       }
/*  330: 402 */       if (!Util.isStrEmpty(evsBookModel.getPeriodName()))
/*  331:     */       {
/*  332: 403 */         sb.append(" AND e.periodName = ?");
/*  333: 404 */         paras.add(evsBookModel.getPeriodName());
/*  334:     */       }
/*  335: 407 */       if (!Util.isStrEmpty(evsBookModel.getInvoiceType()))
/*  336:     */       {
/*  337: 408 */         sb.append(" AND e.invoiceTypeCode = ?");
/*  338: 409 */         paras.add(evsBookModel.getInvoiceType());
/*  339:     */       }
/*  340: 416 */       sb.append(" ORDER BY  CASE WHEN e.source IN ('GVS', 'HOPE') THEN e.userName   WHEN e.source IN ('U8', 'NC') THEN  DECODE(e.invoiceType, '收', '1', '付', '2', '转', '3', '9') WHEN e.source = 'LES' THEN e.journalNum ELSE e.voucherSeqValue END, CASE WHEN e.source IN ('GVS', 'HOPE') THEN e.journalNum WHEN e.source IN ('U8', 'NC') THEN e.journalNum  END");
/*  341:     */       
/*  342:     */ 
/*  343:     */ 
/*  344:     */ 
/*  345:     */ 
/*  346:     */ 
/*  347: 423 */       PageInfo page = super.PageInfoQuery(sb.toString(), start / pageSize + 
/*  348: 424 */         1, pageSize, paras.toArray());
/*  349: 425 */       map.put("data", page.getResult());
/*  350: 426 */       map.put("totalCount", Long.valueOf(page.getTotalCount()));
/*  351: 427 */       return map;
/*  352:     */     }
/*  353: 430 */     return null;
/*  354:     */   }
/*  355:     */   
/*  356:     */   public EvsBookV getBookInfoByCode(EvsBookModel bookModel)
/*  357:     */   {
/*  358: 441 */     EvsBookV evsBookV = null;
/*  359:     */     
/*  360: 443 */     StringBuffer sb = new StringBuffer();
/*  361: 444 */     List<Object> paras = new ArrayList(1);
/*  362: 445 */     sb.append("FROM EvsBookV t WHERE 1=1");
/*  363: 447 */     if (!bookModel.getBookId().equals(""))
/*  364:     */     {
/*  365: 449 */       sb.append(" AND t.bookId = " + bookModel.getBookId());
/*  366: 450 */       Query query = getSession().createQuery(sb.toString());
/*  367: 451 */       List list = query.list();
/*  368: 452 */       Iterator iterator = list.iterator();
/*  369: 454 */       while (iterator.hasNext()) {
/*  370: 455 */         evsBookV = (EvsBookV)iterator.next();
/*  371:     */       }
/*  372: 458 */       return evsBookV;
/*  373:     */     }
/*  374: 461 */     return null;
/*  375:     */   }
/*  376:     */   
/*  377:     */   public EvsBookV getBookInfoByArchiveNumber(EvsBookModel bookModel)
/*  378:     */   {
/*  379: 473 */     EvsBookV evsBookV = null;
/*  380:     */     
/*  381: 475 */     StringBuffer sb = new StringBuffer();
/*  382: 476 */     List<Object> paras = new ArrayList(1);
/*  383: 477 */     sb.append("FROM EvsBookV t WHERE 1=1");
/*  384: 479 */     if (!bookModel.getArchiveNumber().equals(""))
/*  385:     */     {
/*  386: 481 */       sb.append(" AND t.archiveNumber = " + bookModel.getArchiveNumber());
/*  387: 482 */       Query query = getSession().createQuery(sb.toString());
/*  388: 483 */       List list = query.list();
/*  389: 484 */       if (list.size() > 0) {
/*  390: 485 */         evsBookV = (EvsBookV)list.get(0);
/*  391:     */       }
/*  392: 488 */       return evsBookV;
/*  393:     */     }
/*  394: 491 */     return null;
/*  395:     */   }
/*  396:     */   
/*  397:     */   public EvsBookV getBookInfoByBookId(EvsBookModel bookModel)
/*  398:     */   {
/*  399: 501 */     EvsBookV evsBookV = null;
/*  400:     */     
/*  401: 503 */     StringBuffer sb = new StringBuffer();
/*  402: 504 */     List<Object> paras = new ArrayList(1);
/*  403: 505 */     sb.append("FROM EvsBookV t WHERE 1=1");
/*  404: 507 */     if (bookModel.getBookId() != null)
/*  405:     */     {
/*  406: 509 */       sb.append(" AND t.bookId = ?");
/*  407: 510 */       Query query = getSession().createQuery(sb.toString());
/*  408: 511 */       query.setLong(0, Long.valueOf(bookModel.getBookId()).longValue());
/*  409: 512 */       List list = query.list();
/*  410: 513 */       if (list.size() > 0) {
/*  411: 514 */         evsBookV = (EvsBookV)list.get(0);
/*  412:     */       }
/*  413: 517 */       return evsBookV;
/*  414:     */     }
/*  415: 520 */     return null;
/*  416:     */   }
/*  417:     */   
/*  418:     */   public EvsBook getBookByCode(String bookCode)
/*  419:     */   {
/*  420: 533 */     EvsBook evsBook = null;
/*  421: 535 */     if ((bookCode != null) && (!bookCode.equals("")))
/*  422:     */     {
/*  423: 536 */       log.debug("find TBook instance");
/*  424:     */       try
/*  425:     */       {
/*  426: 538 */         String sql = "FROM EvsBook e where e.bookCode = '" + bookCode + 
/*  427: 539 */           "'";
/*  428: 540 */         Query query = getSession().createQuery(sql);
/*  429: 541 */         List list = query.list();
/*  430: 542 */         Iterator iterate = list.iterator();
/*  431: 544 */         if ((iterate != null) && (!"".equals(iterate))) {
/*  432: 546 */           while (iterate.hasNext()) {
/*  433: 548 */             evsBook = (EvsBook)iterate.next();
/*  434:     */           }
/*  435:     */         }
/*  436: 551 */         log.debug("find successful");
/*  437:     */       }
/*  438:     */       catch (RuntimeException re)
/*  439:     */       {
/*  440: 553 */         log.error("find failed", re);
/*  441: 554 */         throw re;
/*  442:     */       }
/*  443: 556 */       return evsBook;
/*  444:     */     }
/*  445: 559 */     return null;
/*  446:     */   }
/*  447:     */   
/*  448:     */   public EvsBookV getBookVByCode(String bookCode)
/*  449:     */   {
/*  450: 570 */     EvsBookV evsBook = null;
/*  451: 572 */     if ((bookCode != null) && (!bookCode.equals("")))
/*  452:     */     {
/*  453: 573 */       log.debug("find TBook instance");
/*  454:     */       try
/*  455:     */       {
/*  456: 575 */         String sql = "FROM EvsBookV e where e.bookCode = '" + bookCode + "'";
/*  457: 576 */         Query query = getSession().createQuery(sql);
/*  458: 577 */         List list = query.list();
/*  459: 578 */         Iterator iterate = list.iterator();
/*  460: 580 */         if ((iterate != null) && (!"".equals(iterate))) {
/*  461: 582 */           while (iterate.hasNext()) {
/*  462: 584 */             evsBook = (EvsBookV)iterate.next();
/*  463:     */           }
/*  464:     */         }
/*  465: 587 */         log.debug("find successful");
/*  466:     */       }
/*  467:     */       catch (RuntimeException re)
/*  468:     */       {
/*  469: 589 */         log.error("find failed", re);
/*  470: 590 */         throw re;
/*  471:     */       }
/*  472: 592 */       return evsBook;
/*  473:     */     }
/*  474: 595 */     return null;
/*  475:     */   }
/*  476:     */   
/*  477:     */   public EvsBook getBookById(String bookId)
/*  478:     */   {
/*  479: 606 */     EvsBook evsBook = null;
/*  480: 608 */     if ((bookId != null) && (!bookId.equals("")))
/*  481:     */     {
/*  482: 609 */       log.debug("find TBook instance");
/*  483:     */       try
/*  484:     */       {
/*  485: 611 */         String sql = "FROM EvsBook e where e.bookId = '" + bookId + "'";
/*  486: 612 */         Query query = getSession().createQuery(sql);
/*  487: 613 */         List list = query.list();
/*  488: 614 */         Iterator iterate = list.iterator();
/*  489: 616 */         if ((iterate != null) && (!"".equals(iterate))) {
/*  490: 618 */           while (iterate.hasNext()) {
/*  491: 620 */             evsBook = (EvsBook)iterate.next();
/*  492:     */           }
/*  493:     */         }
/*  494: 623 */         log.debug("find successful");
/*  495:     */       }
/*  496:     */       catch (RuntimeException re)
/*  497:     */       {
/*  498: 625 */         log.error("find failed", re);
/*  499: 626 */         throw re;
/*  500:     */       }
/*  501: 629 */       return evsBook;
/*  502:     */     }
/*  503: 632 */     return null;
/*  504:     */   }
/*  505:     */   
/*  506:     */   public EvsVoucher findVoucherById(String id)
/*  507:     */   {
/*  508: 644 */     return (EvsVoucher)super.getObject(EvsVoucher.class, Long.valueOf(id));
/*  509:     */   }
/*  510:     */   
/*  511:     */   public Map findEvsVoucherByNum(EvsBookModel evsBook, int start, int pageSize)
/*  512:     */   {
/*  513: 659 */     StringBuffer sb = new StringBuffer();
/*  514: 660 */     List<Object> paras = new ArrayList(1);
/*  515:     */     
/*  516: 662 */     sb.append("FROM EvsVoucherBookV t where t.voucherId in ( select e.voucherId FROM EvsVoucherBookPackage e WHERE 1=1 ");
/*  517: 664 */     if (!Util.isStrEmpty(evsBook.getBookId()))
/*  518:     */     {
/*  519: 665 */       sb.append(" AND e.bookId  = ? ) ");
/*  520: 666 */       paras.add(Long.valueOf(Long.parseLong(evsBook.getBookId())));
/*  521:     */     }
/*  522:     */     else
/*  523:     */     {
/*  524: 668 */       sb.append(" AND 1>2 ) ");
/*  525:     */     }
/*  526: 670 */     sb.append(" order by t.invoiceTypeCode,t.journalNum");
/*  527:     */     
/*  528:     */ 
/*  529:     */ 
/*  530:     */ 
/*  531:     */ 
/*  532:     */ 
/*  533:     */ 
/*  534:     */ 
/*  535:     */ 
/*  536: 680 */     PageInfo page = super.PageInfoQuery(sb.toString(), 
/*  537: 681 */       start / pageSize + 1, pageSize, paras.toArray());
/*  538:     */     
/*  539: 683 */     Map map = new HashMap();
/*  540: 684 */     map.put("data", page.getResult());
/*  541: 685 */     map.put("totalCount", Long.valueOf(page.getTotalCount()));
/*  542: 686 */     return map;
/*  543:     */   }
/*  544:     */   
/*  545:     */   public List getVoucherInfo(String bookId)
/*  546:     */   {
/*  547: 698 */     List list = null;
/*  548: 699 */     if ((bookId != null) && (!"".equals(bookId)))
/*  549:     */     {
/*  550: 700 */       String bookSql = "select a.voucher_id,a.journal_num from evs.evs_voucher a where a.voucher_id in ( select t.voucher_id from evs.evs_voucher_book_package t where t.book_id =" + 
/*  551:     */       
/*  552: 702 */         bookId + " )";
/*  553: 703 */       list = getSession().createSQLQuery(bookSql).list();
/*  554:     */     }
/*  555: 705 */     return list;
/*  556:     */   }
/*  557:     */   
/*  558:     */   public void update(String status, String headerIds, String journalNums, String bookId)
/*  559:     */   {
/*  560: 719 */     log.debug("update VOUCHER voucher");
/*  561:     */     try
/*  562:     */     {
/*  563: 721 */       String[] headerId = headerIds.split(",");
/*  564: 722 */       String[] journalNum = journalNums.split(",");
/*  565:     */       
/*  566: 724 */       List list = getVoucherInfo(bookId);
/*  567: 725 */       Object[] obj = (Object[])null;
/*  568: 726 */       if ((list != null) && (list.size() > 0))
/*  569:     */       {
/*  570: 727 */         for (int i = 0; i < list.size(); i++)
/*  571:     */         {
/*  572: 728 */           obj = (Object[])list.get(i);
/*  573: 729 */           String sql = "select * from EVS_book t  where t.book_id != " + 
/*  574: 730 */             bookId + 
/*  575: 731 */             " and ( t.begin_num  = '" + obj[1].toString() + 
/*  576: 732 */             "' " + " or t.end_num  = '" + obj[1].toString() + 
/*  577: 733 */             "')";
/*  578: 734 */           Iterator iterator = getSession().createSQLQuery(sql).list()
/*  579: 735 */             .iterator();
/*  580: 736 */           Object count = null;
/*  581: 737 */           if ((iterator != null) && 
/*  582: 738 */             (iterator.hasNext())) {
/*  583: 739 */             count = iterator.next();
/*  584:     */           }
/*  585: 743 */           if (count == null)
/*  586:     */           {
/*  587: 744 */             String hql = " update EVS_VOUCHER set voucher_status ='" + 
/*  588: 745 */               status + 
/*  589: 746 */               "'  where voucher_id = " + 
/*  590: 747 */               obj[0].toString();
/*  591:     */             
/*  592: 749 */             getSession().createSQLQuery(hql).executeUpdate();
/*  593:     */           }
/*  594:     */         }
/*  595: 752 */         log.debug("update successful");
/*  596:     */       }
/*  597:     */     }
/*  598:     */     catch (RuntimeException re)
/*  599:     */     {
/*  600: 756 */       log.error("update failed", re);
/*  601: 757 */       throw re;
/*  602:     */     }
/*  603:     */   }
/*  604:     */   
/*  605:     */   public Map getVoucherHistoryByCode(EvsBookModel bookModel, int start, int pageSize)
/*  606:     */   {
/*  607: 776 */     StringBuffer sb = new StringBuffer();
/*  608: 777 */     List<Object> paras = new ArrayList(1);
/*  609: 779 */     if (!"".equals(bookModel.getBookCode()))
/*  610:     */     {
/*  611: 780 */       sb.append("from EvsVoucherHistory e where 2>1 ");
/*  612: 781 */       sb.append(" AND e.objectCode = '" + bookModel.getBookCode() + "'");
/*  613: 782 */       PageInfo page = super.PageInfoQuery(sb.toString(), start / pageSize + 
/*  614: 783 */         1, pageSize, paras.toArray());
/*  615:     */       
/*  616: 785 */       Map map = new HashMap();
/*  617: 786 */       map.put("data", page.getResult());
/*  618: 787 */       map.put("totalCount", Long.valueOf(page.getTotalCount()));
/*  619:     */       
/*  620: 789 */       return map;
/*  621:     */     }
/*  622: 792 */     return null;
/*  623:     */   }
/*  624:     */   
/*  625:     */   public String isBreakNum(String[] bookModel)
/*  626:     */   {
/*  627: 804 */     StringBuffer sb = new StringBuffer();
/*  628: 805 */     String sql = null;
/*  629: 806 */     String countSql = null;
/*  630:     */     
/*  631: 808 */     BigDecimal count = null;
/*  632: 809 */     BigDecimal count1 = null;
/*  633:     */     try
/*  634:     */     {
/*  635: 812 */       if (bookModel[0].hashCode() > bookModel[1].hashCode())
/*  636:     */       {
/*  637: 813 */         sql = 
/*  638:     */         
/*  639:     */ 
/*  640:     */ 
/*  641:     */ 
/*  642:     */ 
/*  643:     */ 
/*  644:     */ 
/*  645: 821 */           "select (select max(b.journal_num) from evs_voucher b where b.journal_num>='" + bookModel[1] + "' and b.journal_num<= '" + bookModel[0] + "' ) -" + "(select min(b.journal_num) from evs_voucher b where b.journal_num>= '" + bookModel[1] + "' and b.journal_num<= '" + bookModel[0] + "' )+1 from dual";
/*  646:     */         
/*  647: 823 */         countSql = "select count(b.journal_num) from evs_voucher b where b.journal_num>= '" + 
/*  648: 824 */           bookModel[1] + 
/*  649: 825 */           "' and b.journal_num<=  '" + 
/*  650: 826 */           bookModel[0] + "'";
/*  651:     */       }
/*  652:     */       else
/*  653:     */       {
/*  654: 830 */         sql = 
/*  655:     */         
/*  656:     */ 
/*  657:     */ 
/*  658:     */ 
/*  659:     */ 
/*  660:     */ 
/*  661:     */ 
/*  662: 838 */           "select (select max(b.journal_num) from evs_voucher b where b.journal_num >='" + bookModel[0] + "' and b.journal_num<= '" + bookModel[1] + "' ) -" + "(select min(b.journal_num) from evs_voucher b where b.journal_num>= '" + bookModel[0] + "' and b.journal_num<= '" + bookModel[1] + "' )+1 from dual";
/*  663:     */         
/*  664: 840 */         countSql = "select count(b.journal_num) from evs_voucher b where b.journal_num>= '" + 
/*  665: 841 */           bookModel[0] + 
/*  666: 842 */           "' and b.journal_num<=  '" + 
/*  667: 843 */           bookModel[1] + "'";
/*  668:     */       }
/*  669: 846 */       count = 
/*  670: 847 */         (BigDecimal)getSession().createSQLQuery(sql).list().get(0);
/*  671: 848 */       count1 = 
/*  672: 849 */         (BigDecimal)getSession().createSQLQuery(countSql).list().get(0);
/*  673:     */     }
/*  674:     */     catch (RuntimeException re)
/*  675:     */     {
/*  676: 851 */       throw re;
/*  677:     */     }
/*  678: 854 */     if (count.intValue() == count1.intValue()) {
/*  679: 856 */       return "N";
/*  680:     */     }
/*  681: 859 */     return "Y";
/*  682:     */   }
/*  683:     */   
/*  684:     */   public List<String> getJournalNumList(String[] bookModel)
/*  685:     */   {
/*  686: 871 */     List list = null;
/*  687: 872 */     String sql = null;
/*  688: 874 */     if (bookModel[0].hashCode() > bookModel[1].hashCode()) {
/*  689: 875 */       sql = 
/*  690:     */       
/*  691:     */ 
/*  692:     */ 
/*  693: 879 */         "select e.journalNum from EvsVoucher e where 1=1 and e.journalNum >= '" + bookModel[1] + "' and e.journalNum <= '" + bookModel[0] + "'";
/*  694:     */     } else {
/*  695: 883 */       sql = 
/*  696:     */       
/*  697:     */ 
/*  698:     */ 
/*  699: 887 */         "select e.journalNum from EvsVoucher e where 1=1 and e.journalNum >= '" + bookModel[0] + "' and e.journalNum <= '" + bookModel[1] + "'";
/*  700:     */     }
/*  701:     */     try
/*  702:     */     {
/*  703: 890 */       Query query = getSession().createQuery(sql);
/*  704: 891 */       list = query.list();
/*  705:     */     }
/*  706:     */     catch (RuntimeException re)
/*  707:     */     {
/*  708: 894 */       throw re;
/*  709:     */     }
/*  710: 896 */     return list;
/*  711:     */   }
/*  712:     */   
/*  713:     */   public EvsBook insertBook(EvsBookModel evsBookModel)
/*  714:     */   {
/*  715: 909 */     boolean flag = true;
/*  716: 910 */     EvsBook evsBook = new EvsBook();
/*  717:     */     
/*  718: 912 */     EvsObjectUtils loginUser = new EvsObjectUtils();
/*  719: 913 */     EasUserInfo userInfo = EvsObjectUtils.getUserInfoBySession();
/*  720:     */     try
/*  721:     */     {
/*  722: 917 */       if (evsBookModel != null)
/*  723:     */       {
/*  724: 919 */         String bookCode = evsBookModel.getBookCode();
/*  725: 920 */         String voucherid = evsBookModel.getVoucherId();
/*  726:     */         
/*  727: 922 */         String bookId = evsBookModel.getBookId();
/*  728: 923 */         evsBook = getBookById(bookId);
/*  729:     */         
/*  730:     */ 
/*  731: 926 */         Map map = getVoucherMaxMinJournalNum(voucherid);
/*  732: 958 */         if (!bookCode.equals("")) {
/*  733: 959 */           evsBook.setBookCode(bookCode);
/*  734:     */         }
/*  735:1000 */         evsBook.setBookDate(new Date());
/*  736:1003 */         if (userInfo != null)
/*  737:     */         {
/*  738:1005 */           if ((userInfo.getUserInfoPk() != null) && 
/*  739:1006 */             (!"".equals(userInfo.getUserInfoPk())))
/*  740:     */           {
/*  741:1007 */             System.out.println("~~~~~~~~~~~获取当前用户信息~~~~~~~~~~~~~");
/*  742:1008 */             evsBook.setBookEmployeeId(Long.valueOf(
/*  743:1009 */               userInfo.getUserInfoPk().toString()));
/*  744:1010 */             evsBook.setCreatedBy(Long.valueOf(
/*  745:1011 */               userInfo.getUserInfoPk().toString()));
/*  746:1012 */             evsBook.setLastUpdateBy(Long.valueOf(
/*  747:1013 */               userInfo.getUserInfoPk().toString()));
/*  748:1014 */             evsBook.setLastUpdateLogin(Long.valueOf(
/*  749:1015 */               userInfo.getUserInfoPk().toString()));
/*  750:     */           }
/*  751:     */         }
/*  752:     */         else
/*  753:     */         {
/*  754:1018 */           evsBook.setBookEmployeeId(Long.valueOf("82".toString()));
/*  755:1019 */           evsBook.setCreatedBy(Long.valueOf("82".toString()));
/*  756:1020 */           evsBook.setLastUpdateBy(Long.valueOf("82".toString()));
/*  757:1021 */           evsBook.setLastUpdateLogin(Long.valueOf("82".toString()));
/*  758:     */         }
/*  759:1024 */         if ((evsBook.getBeginNum() != null) && 
/*  760:1025 */           (!"".equals(evsBook.getBeginNum())) && 
/*  761:1026 */           (evsBook.getEndNum() != null) && 
/*  762:1027 */           (!"".equals(evsBook.getEndNum())))
/*  763:     */         {
/*  764:1029 */           String sql = " select get_interval('" + 
/*  765:1030 */             evsBook.getBeginNum() + "','" + 
/*  766:1031 */             evsBook.getEndNum() + "','" + evsBook.getCompanyCode() + 
/*  767:1032 */             "','" + evsBook.getPeriodName() + "','" + 
/*  768:1033 */             evsBook.getInvoiceType() + "') from dual ";
/*  769:     */           
/*  770:1035 */           List list = getLogicUserInfo(sql);
/*  771:1037 */           if (list.size() > 0)
/*  772:     */           {
/*  773:1038 */             String temp = null;
/*  774:1040 */             for (int i = 0; i < list.size(); i++) {
/*  775:1041 */               temp = (String)list.get(i);
/*  776:     */             }
/*  777:1044 */             if (temp != null) {
/*  778:1046 */               evsBook.setBookBreakFlag("Y");
/*  779:     */             } else {
/*  780:1051 */               evsBook.setBookBreakFlag("N");
/*  781:     */             }
/*  782:     */           }
/*  783:     */         }
/*  784:1056 */         evsBook.setPeriodName(evsBookModel.getPeriodName());
/*  785:1057 */         evsBook.setCompanyCode(evsBookModel.getCompanyCode());
/*  786:1058 */         evsBook.setBookId(Long.valueOf(evsBookModel.getBookId()));
/*  787:1059 */         evsBook.setCreationDate(new Date());
/*  788:1060 */         evsBook.setLastUpdateDate(new Date());
/*  789:1061 */         evsBook.setBookStatus("BOOKED");
/*  790:     */         
/*  791:     */ 
/*  792:1064 */         update(evsBook);
/*  793:     */       }
/*  794:     */     }
/*  795:     */     catch (Exception e)
/*  796:     */     {
/*  797:1069 */       e.printStackTrace();
/*  798:     */     }
/*  799:1075 */     return evsBook;
/*  800:     */   }
/*  801:     */   
/*  802:     */   public String getGenerarionNmber(EvsBookModel params)
/*  803:     */   {
/*  804:1097 */     String rtnStr = "";
/*  805:1098 */     Session s = getSession();
/*  806:1099 */     Connection con = s.connection();
/*  807:1100 */     CallableStatement cstm = null;
/*  808:     */     try
/*  809:     */     {
/*  810:1103 */       cstm = 
/*  811:1104 */         con.prepareCall("{call EVS_GENERATION_NUMBER_PKG.get_generation_number(?,?,?,?,?,?,?,?,?)}");
/*  812:     */       
/*  813:1106 */       cstm.setString(1, params.getCompanyCode());
/*  814:1107 */       cstm.setString(2, params.getDoccode());
/*  815:1108 */       cstm.setString(3, params.getSubdoccode());
/*  816:1109 */       cstm.setString(4, params.getPeriodDate());
/*  817:1110 */       cstm.setString(5, params.getBoeTypeCode());
/*  818:1111 */       cstm.setString(6, params.getUnitCode());
/*  819:1112 */       cstm.setString(7, "");
/*  820:1113 */       cstm.setString(8, "");
/*  821:1114 */       cstm.registerOutParameter(9, 12);
/*  822:1115 */       cstm.execute();
/*  823:1116 */       rtnStr = cstm.getString(9);
/*  824:1117 */       cstm.close();
/*  825:1118 */       con.close();
/*  826:     */     }
/*  827:     */     catch (Exception e)
/*  828:     */     {
/*  829:1121 */       e.printStackTrace();
/*  830:     */       try
/*  831:     */       {
/*  832:1125 */         if (cstm != null)
/*  833:     */         {
/*  834:1126 */           cstm.close();
/*  835:1127 */           cstm = null;
/*  836:     */         }
/*  837:1130 */         if (con != null)
/*  838:     */         {
/*  839:1131 */           con.close();
/*  840:1132 */           con = null;
/*  841:     */         }
/*  842:     */       }
/*  843:     */       catch (Exception e)
/*  844:     */       {
/*  845:1135 */         e.printStackTrace();
/*  846:     */       }
/*  847:     */     }
/*  848:     */     finally
/*  849:     */     {
/*  850:     */       try
/*  851:     */       {
/*  852:1125 */         if (cstm != null)
/*  853:     */         {
/*  854:1126 */           cstm.close();
/*  855:1127 */           cstm = null;
/*  856:     */         }
/*  857:1130 */         if (con != null)
/*  858:     */         {
/*  859:1131 */           con.close();
/*  860:1132 */           con = null;
/*  861:     */         }
/*  862:     */       }
/*  863:     */       catch (Exception e)
/*  864:     */       {
/*  865:1135 */         e.printStackTrace();
/*  866:     */       }
/*  867:     */     }
/*  868:1138 */     return rtnStr;
/*  869:     */   }
/*  870:     */   
/*  871:     */   public String getGenerarionNmberYB(EvsVoucherSelect params)
/*  872:     */   {
/*  873:1145 */     String rtnStr = "";
/*  874:1146 */     Session s = getSession();
/*  875:1147 */     Connection con = s.connection();
/*  876:1148 */     CallableStatement cstm = null;
/*  877:     */     try
/*  878:     */     {
/*  879:1151 */       cstm = 
/*  880:1152 */         con.prepareCall("{call EVS_GENERATION_NUMBER_PKG.get_generation_number(?,?,?,?,?,?,?,?,?)}");
/*  881:     */       
/*  882:1154 */       cstm.setString(1, params.getCompanyCode());
/*  883:1155 */       cstm.setString(2, params.getDoccode());
/*  884:1156 */       cstm.setString(3, params.getSubdoccode());
/*  885:1157 */       cstm.setString(4, params.getPeriodDate());
/*  886:1158 */       cstm.setString(5, params.getBoeTypeCode());
/*  887:1159 */       cstm.setString(6, params.getUnitCode());
/*  888:1160 */       cstm.setString(7, "");
/*  889:1161 */       cstm.setString(8, "");
/*  890:1162 */       cstm.registerOutParameter(9, 12);
/*  891:1163 */       cstm.execute();
/*  892:1164 */       rtnStr = cstm.getString(9);
/*  893:1165 */       cstm.close();
/*  894:1166 */       con.close();
/*  895:     */     }
/*  896:     */     catch (Exception e)
/*  897:     */     {
/*  898:1169 */       e.printStackTrace();
/*  899:     */       try
/*  900:     */       {
/*  901:1173 */         if (cstm != null)
/*  902:     */         {
/*  903:1174 */           cstm.close();
/*  904:1175 */           cstm = null;
/*  905:     */         }
/*  906:1178 */         if (con != null)
/*  907:     */         {
/*  908:1179 */           con.close();
/*  909:1180 */           con = null;
/*  910:     */         }
/*  911:     */       }
/*  912:     */       catch (Exception e)
/*  913:     */       {
/*  914:1183 */         e.printStackTrace();
/*  915:     */       }
/*  916:     */     }
/*  917:     */     finally
/*  918:     */     {
/*  919:     */       try
/*  920:     */       {
/*  921:1173 */         if (cstm != null)
/*  922:     */         {
/*  923:1174 */           cstm.close();
/*  924:1175 */           cstm = null;
/*  925:     */         }
/*  926:1178 */         if (con != null)
/*  927:     */         {
/*  928:1179 */           con.close();
/*  929:1180 */           con = null;
/*  930:     */         }
/*  931:     */       }
/*  932:     */       catch (Exception e)
/*  933:     */       {
/*  934:1183 */         e.printStackTrace();
/*  935:     */       }
/*  936:     */     }
/*  937:1186 */     return rtnStr;
/*  938:     */   }
/*  939:     */   
/*  940:     */   public List getJournalNumByVoucherId(String journalNums)
/*  941:     */   {
/*  942:1197 */     List list = new ArrayList();
/*  943:1198 */     StringBuffer sb = new StringBuffer();
/*  944:1199 */     sb.append("select e.journalNum from EvsVoucher e where 2>1 ");
/*  945:1200 */     sb.append(" AND e.voucherId in( " + journalNums + ")");
/*  946:1201 */     sb.append(" AND e.voucherStatus = 'BOOKED'");
/*  947:     */     try
/*  948:     */     {
/*  949:1203 */       Query query = getSession().createQuery(sb.toString());
/*  950:1204 */       list = query.list();
/*  951:     */     }
/*  952:     */     catch (Exception e)
/*  953:     */     {
/*  954:1206 */       e.printStackTrace();
/*  955:     */     }
/*  956:1209 */     return list;
/*  957:     */   }
/*  958:     */   
/*  959:     */   public String getBookTotal(EvsBookModel bookModel)
/*  960:     */   {
/*  961:1220 */     String hql = " select count(*)  from EvsBook e where 1=1 ";
/*  962:1221 */     long total = 0L;
/*  963:     */     try
/*  964:     */     {
/*  965:1224 */       if (bookModel != null)
/*  966:     */       {
/*  967:1226 */         if ((!"".equals(bookModel.getSetBookName())) && 
/*  968:1227 */           (bookModel.getSetBookName() != null)) {
/*  969:1228 */           hql = 
/*  970:1229 */             hql + " and e.setBookName = '" + bookModel.getSetBookName() + "'";
/*  971:     */         }
/*  972:1232 */         if ((!"".equals(bookModel.getCompanyCode())) && 
/*  973:1233 */           (bookModel.getCompanyCode() != null)) {
/*  974:1234 */           hql = hql + " and e.ouName = '" + bookModel.getCompanyCode() + "'";
/*  975:     */         }
/*  976:1237 */         if ((!"".equals(bookModel.getPeriodName())) && 
/*  977:1238 */           (bookModel.getPeriodName() != null)) {
/*  978:1239 */           hql = 
/*  979:1240 */             hql + " and e.periodName = '" + bookModel.getPeriodName() + "'";
/*  980:     */         }
/*  981:1242 */         Query query = getSession().createQuery(hql);
/*  982:1243 */         Iterator iterator = query.list().iterator();
/*  983:1244 */         Long totals = null;
/*  984:1246 */         while (iterator.hasNext())
/*  985:     */         {
/*  986:1247 */           totals = (Long)iterator.next();
/*  987:1248 */           total = totals.longValue();
/*  988:     */         }
/*  989:     */       }
/*  990:     */     }
/*  991:     */     catch (Exception e)
/*  992:     */     {
/*  993:1253 */       e.printStackTrace();
/*  994:     */     }
/*  995:1255 */     return String.valueOf(total);
/*  996:     */   }
/*  997:     */   
/*  998:     */   public Map getVoucherMaxMinJournalNum(String voucherIds)
/*  999:     */   {
/* 1000:1266 */     Map map = new HashMap();
/* 1001:1267 */     String hql = null;
/* 1002:     */     try
/* 1003:     */     {
/* 1004:1270 */       if ((voucherIds != null) && (!"".equals(voucherIds))) {
/* 1005:1271 */         hql = 
/* 1006:1272 */           "select max(t.journalNum),min(t.journalNum) from EvsVoucher t where  t.voucherId in (" + voucherIds + ")";
/* 1007:     */       }
/* 1008:1275 */       Query query = getSession().createQuery(hql);
/* 1009:1276 */       Iterator iterator = query.list().iterator();
/* 1010:1277 */       Object[] object = (Object[])null;
/* 1011:1279 */       while (iterator.hasNext())
/* 1012:     */       {
/* 1013:1280 */         object = (Object[])iterator.next();
/* 1014:1281 */         map.put("max", object[0]);
/* 1015:1282 */         map.put("min", object[1]);
/* 1016:     */       }
/* 1017:     */     }
/* 1018:     */     catch (Exception e)
/* 1019:     */     {
/* 1020:1285 */       e.printStackTrace();
/* 1021:     */     }
/* 1022:1288 */     return map;
/* 1023:     */   }
/* 1024:     */   
/* 1025:     */   public void saveVoucherBookPackage(EvsVoucherBookPackage evsVoucherBookPackage)
/* 1026:     */   {
/* 1027:1300 */     log.debug("saving EvsVoucherBookPackage instance");
/* 1028:     */     try
/* 1029:     */     {
/* 1030:1303 */       getSession().save(evsVoucherBookPackage);
/* 1031:     */       
/* 1032:1305 */       log.debug("save successful 增加关联信息");
/* 1033:     */     }
/* 1034:     */     catch (RuntimeException re)
/* 1035:     */     {
/* 1036:1307 */       log.error("save EvsVoucherBookPackage Exception", re);
/* 1037:1308 */       throw re;
/* 1038:     */     }
/* 1039:     */   }
/* 1040:     */   
/* 1041:     */   public void deleteVoucherBookPackage(String bookId, String voucherIds)
/* 1042:     */   {
/* 1043:1320 */     log.debug("saving EvsVoucherBookPackage instance");
/* 1044:     */     try
/* 1045:     */     {
/* 1046:1324 */       if ((bookId != null) && (!"".equals(bookId)))
/* 1047:     */       {
/* 1048:1325 */         String hql = "delete EvsVoucherBookPackage t where t.bookId =" + 
/* 1049:1326 */           bookId;
/* 1050:1327 */         if ((voucherIds != null) && (!"".equals(voucherIds))) {
/* 1051:1328 */           hql = hql + " and t.voucherId in (" + voucherIds + ")";
/* 1052:     */         }
/* 1053:1330 */         Query query = getSession().createQuery(hql);
/* 1054:1331 */         query.executeUpdate();
/* 1055:     */       }
/* 1056:1334 */       log.debug("save successful 增加关联信息");
/* 1057:     */     }
/* 1058:     */     catch (RuntimeException re)
/* 1059:     */     {
/* 1060:1336 */       log.error("save EvsVoucherBookPackage Exception", re);
/* 1061:1337 */       throw re;
/* 1062:     */     }
/* 1063:     */   }
/* 1064:     */   
/* 1065:     */   public void saveVoucherBookPackages(EvsBook evsBook, String voucherids)
/* 1066:     */   {
/* 1067:1351 */     String[] voucherid = voucherids.split(",");
/* 1068:1352 */     EvsObjectUtils loginUser = new EvsObjectUtils();
/* 1069:1353 */     EasUserInfo userInfo = EvsObjectUtils.getUserInfoBySession();
/* 1070:     */     try
/* 1071:     */     {
/* 1072:1355 */       EvsVoucherBookPackage vb = null;
/* 1073:1357 */       if (userInfo == null)
/* 1074:     */       {
/* 1075:1358 */         System.out.println("~~~~~~~~~~未能取得当前对象~~~~~~~~~~~~~~~~");
/* 1076:1360 */         for (int i = 0; i < voucherid.length; i++)
/* 1077:     */         {
/* 1078:1362 */           deleteVoucherBookPackage(evsBook.getBookId().toString(), voucherid[i]);
/* 1079:1363 */           vb = new EvsVoucherBookPackage();
/* 1080:1364 */           vb.setVoucherId(Long.valueOf(voucherid[i]));
/* 1081:1365 */           vb.setBookId(evsBook.getBookId());
/* 1082:1366 */           vb.setPackageId(Long.valueOf(Long.parseLong("0")));
/* 1083:1367 */           vb.setCreationDate(new Date());
/* 1084:1368 */           vb.setCreatedBy(Long.valueOf(Long.parseLong("110")));
/* 1085:1369 */           vb.setLastUpdateDate(new Date());
/* 1086:1370 */           vb.setLastUpdateBy(Long.valueOf(Long.parseLong("110")));
/* 1087:1371 */           vb.setLastUpdateLogin(Long.valueOf(Long.parseLong("110")));
/* 1088:1372 */           saveVoucherBookPackage(vb);
/* 1089:     */         }
/* 1090:     */       }
/* 1091:1377 */       else if (userInfo != null)
/* 1092:     */       {
/* 1093:1378 */         System.out.println("~~~~~~~~~~已取得当前对象~~~~~~~~~~~~~~~~");
/* 1094:1380 */         for (int i = 0; i < voucherid.length; i++)
/* 1095:     */         {
/* 1096:1382 */           deleteVoucherBookPackage(evsBook.getBookId().toString(), voucherid[i]);
/* 1097:1383 */           vb = new EvsVoucherBookPackage();
/* 1098:1384 */           vb.setVoucherId(Long.valueOf(voucherid[i]));
/* 1099:1385 */           vb.setBookId(evsBook.getBookId());
/* 1100:1386 */           vb.setPackageId(Long.valueOf(Long.parseLong("0")));
/* 1101:1387 */           vb.setCreationDate(new Date());
/* 1102:1389 */           if ((userInfo.getUserInfoPk() != null) && 
/* 1103:1390 */             (!"".equals(userInfo.getUserInfoPk())))
/* 1104:     */           {
/* 1105:1391 */             vb.setCreatedBy(Long.valueOf(Long.parseLong(
/* 1106:1392 */               userInfo.getUserInfoPk().toString())));
/* 1107:1393 */             vb.setLastUpdateBy(Long.valueOf(Long.parseLong(
/* 1108:1394 */               userInfo.getUserInfoPk().toString())));
/* 1109:1395 */             vb.setLastUpdateLogin(Long.valueOf(Long.parseLong(
/* 1110:1396 */               userInfo.getUserInfoPk().toString())));
/* 1111:     */           }
/* 1112:1398 */           vb.setLastUpdateDate(new Date());
/* 1113:     */           
/* 1114:1400 */           saveVoucherBookPackage(vb);
/* 1115:     */         }
/* 1116:     */       }
/* 1117:     */     }
/* 1118:     */     catch (RuntimeException re)
/* 1119:     */     {
/* 1120:1407 */       re.getStackTrace();
/* 1121:     */     }
/* 1122:     */   }
/* 1123:     */   
/* 1124:     */   public List isBreakNums(EvsBookModel bookModel)
/* 1125:     */   {
/* 1126:1419 */     StringBuffer hql = new StringBuffer();
/* 1127:1420 */     hql.append(" select e.journalNum from  EvsVoucher e where 1=1 ");
/* 1128:1421 */     hql.append(" AND e.ouName ='" + bookModel.getCompanyCode() + "' ");
/* 1129:1422 */     hql.append(" AND e.periodName ='" + bookModel.getPeriodName() + "' ");
/* 1130:     */     
/* 1131:1424 */     hql.append(" AND e.invoiceType ='" + bookModel.getSubdocname() + "' ");
/* 1132:1425 */     hql.append(" AND e.journalNum >='" + bookModel.getBeginBookCode() + 
/* 1133:1426 */       "' ");
/* 1134:1427 */     hql.append(" AND e.journalNum <='" + bookModel.getEndBookCode() + "' ");
/* 1135:1428 */     hql.append(" AND e.voucherStatus in('CHECKED','UNBOOK')");
/* 1136:     */     
/* 1137:1430 */     hql.append(" order by e.journalNum");
/* 1138:1431 */     return getSession().createQuery(hql.toString()).list();
/* 1139:     */   }
/* 1140:     */   
/* 1141:     */   public List<String> getLogicUserInfo(String params)
/* 1142:     */   {
/* 1143:1442 */     List<String> list = new ArrayList();
/* 1144:     */     try
/* 1145:     */     {
/* 1146:1445 */       if (params != null)
/* 1147:     */       {
/* 1148:1446 */         SQLQuery query = getSession().createSQLQuery(params);
/* 1149:1447 */         list = query.list();
/* 1150:     */       }
/* 1151:     */     }
/* 1152:     */     catch (RuntimeException re)
/* 1153:     */     {
/* 1154:1450 */       re.getStackTrace();
/* 1155:     */     }
/* 1156:1452 */     return list;
/* 1157:     */   }
/* 1158:     */   
/* 1159:     */   public List<String> getNextJournalNum(EvsBookModel bookModel)
/* 1160:     */   {
/* 1161:1463 */     String sql = null;
/* 1162:1464 */     List<String> list = new ArrayList();
/* 1163:     */     try
/* 1164:     */     {
/* 1165:1467 */       sql = 
/* 1166:     */       
/* 1167:     */ 
/* 1168:     */ 
/* 1169:     */ 
/* 1170:     */ 
/* 1171:     */ 
/* 1172:     */ 
/* 1173:     */ 
/* 1174:     */ 
/* 1175:     */ 
/* 1176:     */ 
/* 1177:     */ 
/* 1178:     */ 
/* 1179:     */ 
/* 1180:     */ 
/* 1181:     */ 
/* 1182:     */ 
/* 1183:     */ 
/* 1184:     */ 
/* 1185:     */ 
/* 1186:     */ 
/* 1187:     */ 
/* 1188:     */ 
/* 1189:     */ 
/* 1190:     */ 
/* 1191:     */ 
/* 1192:     */ 
/* 1193:     */ 
/* 1194:     */ 
/* 1195:     */ 
/* 1196:     */ 
/* 1197:     */ 
/* 1198:     */ 
/* 1199:     */ 
/* 1200:     */ 
/* 1201:     */ 
/* 1202:     */ 
/* 1203:     */ 
/* 1204:     */ 
/* 1205:     */ 
/* 1206:1508 */         " select JOURNAL_NUM from evs_voucher where JOURNAL_NUM =  ( select replace(journal_num, substr(journal_num,length(journal_num) - 7, length(journal_num))) ||  (substr(journal_num, length(journal_num) - 7, length(journal_num)) + 1)  from evs_voucher t WHERE JOURNAL_NUM = '" + bookModel.getEndBookCode() + "' and voucher_Status in ('" + "UNBOOK" + "','" + "CHECKED" + "')" + " AND ou_Name ='" + bookModel.getCompanyCode() + "' " + " AND ou_Id ='" + bookModel.getBookPeople() + "' " + " AND period_Name ='" + bookModel.getPeriodName() + "' " + " and  instr((select voucher_Type from Evs_Sub_Doc_Type   where sub_Doc_Name='" + bookModel.getSubdocname() + "'" + " and rownum=1 ),invoice_Type)>0 and rownum=1)" + " and voucher_Status in ('" + "UNBOOK" + "','" + "CHECKED" + "')" + " AND ou_Name ='" + bookModel.getCompanyCode() + "' " + " AND ou_Id ='" + bookModel.getBookPeople() + "' " + " AND period_Name ='" + bookModel.getPeriodName() + "' " + " and  instr((select voucher_Type from Evs_Sub_Doc_Type  where sub_Doc_Name='" + bookModel.getSubdocname() + "'" + " and rownum=1 ),invoice_Type)>0 ";
/* 1207:     */       
/* 1208:1510 */       SQLQuery query = getSession().createSQLQuery(sql);
/* 1209:1511 */       list = query.list();
/* 1210:     */     }
/* 1211:     */     catch (Exception e)
/* 1212:     */     {
/* 1213:1513 */       e.printStackTrace();
/* 1214:     */     }
/* 1215:1515 */     return list;
/* 1216:     */   }
/* 1217:     */   
/* 1218:     */   public List<String> isVoucherByParam(String params)
/* 1219:     */   {
/* 1220:1527 */     if (params != null) {
/* 1221:1529 */       return getLogicUserInfo(params);
/* 1222:     */     }
/* 1223:1531 */     return null;
/* 1224:     */   }
/* 1225:     */   
/* 1226:     */   public List<String> lookBreakNums(EvsBookModel bookModel)
/* 1227:     */   {
/* 1228:1542 */     List<String> list = new ArrayList();
/* 1229:     */     try
/* 1230:     */     {
/* 1231:1546 */       if ((bookModel.getBeginBookCode() != null) && 
/* 1232:1547 */         (!"".equals(bookModel.getBeginBookCode())) && 
/* 1233:1548 */         (bookModel.getEndBookCode() != null) && 
/* 1234:1549 */         (!"".equals(bookModel.getEndBookCode())))
/* 1235:     */       {
/* 1236:1550 */         String hql = "select get_interval('" + 
/* 1237:1551 */           bookModel.getBeginBookCode() + "','" + 
/* 1238:1552 */           bookModel.getEndBookCode() + "','" + 
/* 1239:1553 */           bookModel.getCompanyCode() + "','" + 
/* 1240:1554 */           bookModel.getPeriodName() + "','" + 
/* 1241:1555 */           bookModel.getSubdoccode() + "') from dual ";
/* 1242:1557 */         if ((!"".equals(hql)) && (hql != null))
/* 1243:     */         {
/* 1244:1558 */           SQLQuery sqlquery = getSession().createSQLQuery(hql);
/* 1245:1559 */           list = sqlquery.list();
/* 1246:     */         }
/* 1247:     */       }
/* 1248:     */     }
/* 1249:     */     catch (Exception e)
/* 1250:     */     {
/* 1251:1563 */       e.printStackTrace();
/* 1252:     */     }
/* 1253:1565 */     return list;
/* 1254:     */   }
/* 1255:     */   
/* 1256:     */   public List<String> getBreakNum(EvsBookModel bookModel)
/* 1257:     */   {
/* 1258:1576 */     List<String> list = new ArrayList();
/* 1259:     */     try
/* 1260:     */     {
/* 1261:1580 */       if ((bookModel.getBeginBookCode() != null) && 
/* 1262:1581 */         (!"".equals(bookModel.getBeginBookCode())) && 
/* 1263:1582 */         (bookModel.getEndBookCode() != null) && 
/* 1264:1583 */         (!"".equals(bookModel.getEndBookCode())))
/* 1265:     */       {
/* 1266:1584 */         String hql = "select get_book_interval('" + 
/* 1267:1585 */           bookModel.getBeginBookCode() + "','" + 
/* 1268:1586 */           bookModel.getEndBookCode() + "','" + 
/* 1269:1587 */           bookModel.getCompanyCode() + "','" + 
/* 1270:1588 */           bookModel.getPeriodName() + "','" + 
/* 1271:1589 */           bookModel.getSubdoccode() + "','" + 
/* 1272:1590 */           bookModel.getBookCode() + "') from dual ";
/* 1273:1592 */         if ((!"".equals(hql)) && (hql != null))
/* 1274:     */         {
/* 1275:1593 */           SQLQuery sqlquery = getSession().createSQLQuery(hql);
/* 1276:1594 */           list = sqlquery.list();
/* 1277:     */         }
/* 1278:     */       }
/* 1279:     */     }
/* 1280:     */     catch (Exception e)
/* 1281:     */     {
/* 1282:1598 */       e.printStackTrace();
/* 1283:     */     }
/* 1284:1600 */     return list;
/* 1285:     */   }
/* 1286:     */   
/* 1287:     */   public List<String> getBreakNums(EvsBookV bookModel)
/* 1288:     */   {
/* 1289:1611 */     List<String> list = new ArrayList();
/* 1290:     */     try
/* 1291:     */     {
/* 1292:1614 */       if ((bookModel.getBeginNum() != null) && 
/* 1293:1615 */         (!"".equals(bookModel.getBeginNum())) && 
/* 1294:1616 */         (bookModel.getEndNum() != null) && 
/* 1295:1617 */         (!"".equals(bookModel.getEndNum())))
/* 1296:     */       {
/* 1297:1618 */         String hql = "select get_book_interval('" + 
/* 1298:1619 */           bookModel.getBeginNum() + "','" + 
/* 1299:1620 */           bookModel.getEndNum() + "','" + bookModel.getCompanyCode() + 
/* 1300:1621 */           "','" + bookModel.getPeriodName() + "','" + 
/* 1301:1622 */           bookModel.getInvoiceType() + "','" + 
/* 1302:1623 */           bookModel.getBookId() + "') from dual ";
/* 1303:1625 */         if ((!"".equals(hql)) && (hql != null))
/* 1304:     */         {
/* 1305:1626 */           SQLQuery sqlquery = getSession().createSQLQuery(hql);
/* 1306:1627 */           list = sqlquery.list();
/* 1307:     */         }
/* 1308:     */       }
/* 1309:     */     }
/* 1310:     */     catch (Exception e)
/* 1311:     */     {
/* 1312:1631 */       e.printStackTrace();
/* 1313:     */     }
/* 1314:1633 */     return list;
/* 1315:     */   }
/* 1316:     */   
/* 1317:     */   public String findVoucherByIsVoucherStatus(String voucherId)
/* 1318:     */   {
/* 1319:1643 */     log.debug("selecet VoucherStatus");
/* 1320:1644 */     String count = null;
/* 1321:1645 */     String sql = null;
/* 1322:     */     try
/* 1323:     */     {
/* 1324:1648 */       String[] vouchers = voucherId.split(",");
/* 1325:1650 */       if (vouchers.length > 2)
/* 1326:     */       {
/* 1327:1652 */         sql = 
/* 1328:     */         
/* 1329:1654 */           "select COUNT(*) from evs_voucher where voucher_id in (" + voucherId + ") and voucher_status != '" + "BOOKED" + "'";
/* 1330:1655 */         List list = getSession().createSQLQuery(sql).list();
/* 1331:1657 */         if ((list != null) && (list.size() > 0)) {
/* 1332:1658 */           count = list.get(0).toString();
/* 1333:     */         }
/* 1334:1661 */         log.debug("select VoucherStatus");
/* 1335:     */       }
/* 1336:1664 */       return count;
/* 1337:     */     }
/* 1338:     */     catch (RuntimeException re)
/* 1339:     */     {
/* 1340:1666 */       log.error("select failed", re);
/* 1341:1667 */       throw re;
/* 1342:     */     }
/* 1343:     */   }
/* 1344:     */   
/* 1345:     */   public Map findQueryBookStatistic(EvsBookStatisticV evsBookStatisticv, int start, int pageSize)
/* 1346:     */   {
/* 1347:1673 */     StringBuilder sql = new StringBuilder();
/* 1348:1674 */     StringBuilder sbl = new StringBuilder();
/* 1349:1675 */     Connection cn = null;
/* 1350:1676 */     PreparedStatement ps = null;
/* 1351:1677 */     ResultSet rs = null;
/* 1352:1678 */     int count = 0;
/* 1353:     */     
/* 1354:1680 */     List list = new ArrayList();
/* 1355:1681 */     Map map = new HashMap();
/* 1356:     */     try
/* 1357:     */     {
/* 1358:1685 */       sbl.append("select get_book_lost(eb.begin_num,eb.end_num,eb.book_id) cu from evs_book eb where eb.book_break_flag='Y'");
/* 1359:     */       
/* 1360:1687 */       cn = getSession().connection();
/* 1361:1688 */       ps = cn.prepareStatement(sbl.toString());
/* 1362:1689 */       rs = ps.executeQuery();
/* 1363:1690 */       String[] str = (String[])null;
/* 1364:1691 */       String ids = "";
/* 1365:     */       int i;
/* 1366:1692 */       for (; rs.next(); i < str.length)
/* 1367:     */       {
/* 1368:1693 */         str = rs.getString(1).split(",");
/* 1369:1694 */         i = 0; continue;
/* 1370:1695 */         ids = ids + "'" + str[i] + "',";i++;
/* 1371:     */       }
/* 1372:1698 */       if (ids.endsWith(",")) {
/* 1373:1699 */         ids = ids.substring(0, ids.length() - 1);
/* 1374:     */       }
/* 1375:1701 */       sql = new StringBuilder();
/* 1376:1702 */       if (ids != "") {
/* 1377:1704 */         sql.append("SELECT e.ou_id,e.ou_name,max(to_char(eb.book_date,'YYYY-MM')) lastBookMonth, COUNT(distinct e.voucher_id) voucherNum,count(distinct a.voucher_id) voucherLostNum,COUNT(distinct b.voucher_id) voucherNoimageNum,count(distinct c.voucher_id) voucherManualNum FROM (select v.voucher_id from evs_voucher v where  v.journal_num in(" + 
/* 1378:     */         
/* 1379:     */ 
/* 1380:     */ 
/* 1381:     */ 
/* 1382:     */ 
/* 1383:     */ 
/* 1384:1711 */           ids + 
/* 1385:1712 */           ")) a," + 
/* 1386:1713 */           "(select * from evs_voucher vc " + 
/* 1387:1714 */           "where  vc.VOUCHER_STATUS ='UNMATCH')  b," + 
/* 1388:1715 */           "(select * from evs_voucher vc " + 
/* 1389:1716 */           "where vc.match_mode ='手动匹配') c," + 
/* 1390:1717 */           "evs_voucher e," + 
/* 1391:1718 */           "(select book_id,to_char(book_date,'YYYY-MM') book_date " + 
/* 1392:1719 */           "from evs_book eb group by book_id,book_date) lbm," + 
/* 1393:1720 */           "evs_book eb,evs_voucher_book_package ep," + 
/* 1394:1721 */           "fbp_check_unit_contents cu " + 
/* 1395:1722 */           "where  e.voucher_id=b.voucher_id(+) " + 
/* 1396:1723 */           "and e.voucher_id=a.voucher_id(+) " + 
/* 1397:1724 */           "and e.voucher_id=c.voucher_id(+) " + 
/* 1398:1725 */           "and e.ou_id=b.ou_id(+) " + 
/* 1399:1726 */           "and e.ou_id=c.ou_id(+) " + 
/* 1400:1727 */           "and e.voucher_id=ep.voucher_id(+) " + 
/* 1401:1728 */           "and ep.book_id=eb.book_id(+) " + 
/* 1402:1729 */           "and eb.book_id=lbm.Book_id(+) " + 
/* 1403:1730 */           "and to_char(eb.book_date,'YYYY-MM')=lbm.book_date(+) " + 
/* 1404:1731 */           "and e.ou_id=cu.erp_org_id");
/* 1405:     */       } else {
/* 1406:1734 */         sql.append("SELECT e.ou_id,e.ou_name,max(to_char(eb.book_date,'YYYY-MM')) lastBookMonth, COUNT(distinct e.voucher_id) voucherNum,0 voucherLostNum,COUNT(distinct b.voucher_id) voucherNoimageNum,count(distinct c.voucher_id) voucherManualNum (select * from evs_voucher vc where  vc.VOUCHER_STATUS ='UNMATCH')  b,(select * from evs_voucher vc where vc.match_mode ='手动匹配') c,evs_voucher e,(select book_id,to_char(book_date,'YYYY-MM') book_date from evs_book eb group by book_id,book_date) lbm,evs_book eb,evs_voucher_book_package ep,fbp_check_unit_contents cu where  e.voucher_id=b.voucher_id(+) and e.voucher_id=c.voucher_id(+) and e.ou_id=b.ou_id(+) and e.ou_id=c.ou_id(+) and e.voucher_id=ep.voucher_id(+) and ep.book_id=eb.book_id(+) and eb.book_id=lbm.Book_id(+) and to_char(eb.book_date,'YYYY-MM')=lbm.book_date(+) and e.ou_id=cu.erp_org_id");
/* 1407:     */       }
/* 1408:1761 */       if ((!"".equals(evsBookStatisticv.getPeriodName())) && 
/* 1409:1762 */         (evsBookStatisticv.getPeriodName() != null)) {
/* 1410:1763 */         sql.append(" AND e.period_Name='" + 
/* 1411:1764 */           evsBookStatisticv.getPeriodName() + "'");
/* 1412:     */       }
/* 1413:1767 */       if ((!"".equals(evsBookStatisticv.getOuId())) && 
/* 1414:1768 */         (evsBookStatisticv.getOuId() != null)) {
/* 1415:1770 */         sql.append(" AND e.ou_Id='" + evsBookStatisticv.getOuId() + 
/* 1416:1771 */           "'");
/* 1417:     */       }
/* 1418:1774 */       if ((!"".equals(evsBookStatisticv.getSetBookName())) && 
/* 1419:1775 */         (evsBookStatisticv.getSetBookName() != null)) {
/* 1420:1776 */         sql.append(" AND e.set_Book_Name='" + 
/* 1421:1777 */           evsBookStatisticv.getSetBookName() + "'");
/* 1422:     */       }
/* 1423:1780 */       if ((!"".equals(evsBookStatisticv.getJournalName())) && 
/* 1424:1781 */         (evsBookStatisticv.getJournalName() != null)) {
/* 1425:1782 */         sql.append(" AND e.JOURNAL_NAME='" + 
/* 1426:1783 */           evsBookStatisticv.getJournalName() + "'");
/* 1427:     */       }
/* 1428:1786 */       if ((!"".equals(evsBookStatisticv.getSource())) && 
/* 1429:1787 */         (evsBookStatisticv.getSource() != null)) {
/* 1430:1788 */         sql.append(" AND e.source='" + evsBookStatisticv.getSource() + 
/* 1431:1789 */           "'");
/* 1432:     */       }
/* 1433:1792 */       if ((!"".equals(evsBookStatisticv.getInvoiceType())) && 
/* 1434:1793 */         (evsBookStatisticv.getInvoiceType() != null)) {
/* 1435:1794 */         sql.append(" AND e.invoice_type='" + 
/* 1436:1795 */           evsBookStatisticv.getInvoiceType() + "'");
/* 1437:     */       }
/* 1438:1798 */       if ((!"".equals(evsBookStatisticv.getBeginDate())) && 
/* 1439:1799 */         (evsBookStatisticv.getBeginDate() != null)) {
/* 1440:1800 */         sql.append(" AND eb.book_Date >=to_date('" + 
/* 1441:1801 */           evsBookStatisticv.getBeginDate() + "'" + 
/* 1442:1802 */           ",'yyyy-mm-dd')");
/* 1443:     */       }
/* 1444:1805 */       if ((!"".equals(evsBookStatisticv.getEndDate())) && 
/* 1445:1806 */         (evsBookStatisticv.getEndDate() != null)) {
/* 1446:1807 */         sql.append(" AND eb.book_Date <=to_date('" + 
/* 1447:1808 */           evsBookStatisticv.getEndDate() + "'" + 
/* 1448:1809 */           ",'yyyy-mm-dd')");
/* 1449:     */       }
/* 1450:1812 */       if ((!"".equals(evsBookStatisticv.getBookEmployeeId())) && 
/* 1451:1813 */         (evsBookStatisticv.getBookEmployeeId() != null)) {
/* 1452:1814 */         sql.append(" AND eb.book_Employee_Id='" + 
/* 1453:1815 */           evsBookStatisticv.getBookEmployeeId() + "'");
/* 1454:     */       }
/* 1455:1817 */       List<String> checkLists = this.objectUtils
/* 1456:1818 */         .getCheckUnit("BOOK_QUERY", "");
/* 1457:     */       Map localMap1;
/* 1458:1819 */       if ((checkLists != null) && (checkLists.size() > 0))
/* 1459:     */       {
/* 1460:1820 */         sql.append(" and (cu.check_Unit in ('");
/* 1461:1821 */         int counts = 0;
/* 1462:1822 */         int i = 0;
/* 1463:1822 */         for (int size = checkLists.size(); i < size; i++)
/* 1464:     */         {
/* 1465:1823 */           counts++;
/* 1466:1824 */           if (counts > 1) {
/* 1467:1825 */             sql.append("', '");
/* 1468:     */           }
/* 1469:1827 */           if (counts < 1000)
/* 1470:     */           {
/* 1471:1828 */             sql.append((String)checkLists.get(i));
/* 1472:     */           }
/* 1473:     */           else
/* 1474:     */           {
/* 1475:1830 */             count = 0;
/* 1476:1831 */             sql.append("') or cu.checkUnit in ('");
/* 1477:1832 */             sql.append((String)checkLists.get(i));
/* 1478:     */           }
/* 1479:     */         }
/* 1480:1835 */         sql.append("'))");
/* 1481:     */       }
/* 1482:     */       else
/* 1483:     */       {
/* 1484:1837 */         Map maps = null;
/* 1485:1838 */         localMap1 = maps;return localMap1;
/* 1486:     */       }
/* 1487:1840 */       sql.append(" group by e.ou_Id,e.ou_Name");
/* 1488:1841 */       System.out.println(sql);
/* 1489:1842 */       cn = getSession().connection();
/* 1490:1843 */       ps = cn.prepareStatement(sql.toString());
/* 1491:1844 */       rs = ps.executeQuery();
/* 1492:1845 */       while (rs.next())
/* 1493:     */       {
/* 1494:1846 */         count++;
/* 1495:1847 */         ResultSetMetaData metaData = rs.getMetaData();
/* 1496:1848 */         int ncolumns = metaData.getColumnCount();
/* 1497:     */         
/* 1498:1850 */         HashMap properties = new HashMap();
/* 1499:1851 */         for (int i = 1; i <= ncolumns; i++)
/* 1500:     */         {
/* 1501:1852 */           String dateType = metaData.getColumnTypeName(i);
/* 1502:1853 */           if (dateType.equalsIgnoreCase("NUMBER"))
/* 1503:     */           {
/* 1504:1854 */             properties.put(sql2javaName(metaData.getColumnName(i)), 
/* 1505:1855 */               Long.valueOf(rs.getLong(i)));
/* 1506:1856 */             System.out.println("rs=" + rs.getDouble(i));
/* 1507:     */           }
/* 1508:     */           else
/* 1509:     */           {
/* 1510:1858 */             properties.put(sql2javaName(metaData.getColumnName(i)), 
/* 1511:1859 */               rs.getString(i));
/* 1512:     */           }
/* 1513:     */         }
/* 1514:1862 */         EvsStatisticField aft = new EvsStatisticField();
/* 1515:1863 */         aft.setOuName(properties.get("ouname").toString());
/* 1516:1864 */         if ((!"".equals(properties.get("lastbookmonth"))) && 
/* 1517:1865 */           (properties.get("lastbookmonth") != null)) {
/* 1518:1866 */           aft.setLastBookMonth(
/* 1519:1867 */             properties.get("lastbookmonth").toString());
/* 1520:     */         }
/* 1521:1869 */         aft.setVoucherNum(BigInteger.valueOf(Long.parseLong(
/* 1522:1870 */           properties.get("vouchernum").toString())));
/* 1523:1871 */         aft.setVoucherLostNum(
/* 1524:1872 */           BigInteger.valueOf(Long.parseLong(properties
/* 1525:1873 */           .get("voucherlostnum").toString())));
/* 1526:1874 */         aft.setVoucherNoimageNum(BigInteger.valueOf(
/* 1527:1875 */           Long.parseLong(properties.get("vouchernoimagenum")
/* 1528:1876 */           .toString())));
/* 1529:1877 */         aft.setVoucherManualNum(BigInteger.valueOf(
/* 1530:1878 */           Long.parseLong(properties.get("vouchermanualnum")
/* 1531:1879 */           .toString())));
/* 1532:1880 */         aft.setOuId(properties.get("ouid").toString());
/* 1533:1881 */         list.add(aft);
/* 1534:     */       }
/* 1535:1883 */       PageInfo page = new PageInfo(start / pageSize + 1, count, pageSize, 
/* 1536:1884 */         list);
/* 1537:1885 */       if (page == null)
/* 1538:     */       {
/* 1539:1886 */         Map maps = null;
/* 1540:1887 */         localMap1 = maps;return localMap1;
/* 1541:     */       }
/* 1542:1889 */       map.put("data", page.getResult());
/* 1543:1890 */       map.put("totalCount", Long.valueOf(page.getTotalCount()));
/* 1544:     */     }
/* 1545:     */     catch (Exception e)
/* 1546:     */     {
/* 1547:1893 */       e.printStackTrace();
/* 1548:     */       try
/* 1549:     */       {
/* 1550:1896 */         if (ps != null) {
/* 1551:1897 */           ps.close();
/* 1552:     */         }
/* 1553:1898 */         if (rs != null) {
/* 1554:1899 */           rs.close();
/* 1555:     */         }
/* 1556:     */       }
/* 1557:     */       catch (SQLException e)
/* 1558:     */       {
/* 1559:1901 */         e.printStackTrace();
/* 1560:     */       }
/* 1561:     */     }
/* 1562:     */     finally
/* 1563:     */     {
/* 1564:     */       try
/* 1565:     */       {
/* 1566:1896 */         if (ps != null) {
/* 1567:1897 */           ps.close();
/* 1568:     */         }
/* 1569:1898 */         if (rs != null) {
/* 1570:1899 */           rs.close();
/* 1571:     */         }
/* 1572:     */       }
/* 1573:     */       catch (SQLException e)
/* 1574:     */       {
/* 1575:1901 */         e.printStackTrace();
/* 1576:     */       }
/* 1577:     */     }
/* 1578:1904 */     return map;
/* 1579:     */   }
/* 1580:     */   
/* 1581:     */   private String sql2javaName(String name)
/* 1582:     */   {
/* 1583:1909 */     String column = "";
/* 1584:1910 */     for (int i = 0; i < name.length(); i++) {
/* 1585:1911 */       if ((name.charAt(i) == '_') || (name.charAt(i) == '-')) {
/* 1586:1912 */         column = 
/* 1587:1913 */           column + (++i < name.length() ? String.valueOf(name.charAt(i)).toUpperCase() : "");
/* 1588:     */       } else {
/* 1589:1915 */         column = column + name.charAt(i);
/* 1590:     */       }
/* 1591:     */     }
/* 1592:1918 */     return column.toLowerCase();
/* 1593:     */   }
/* 1594:     */   
/* 1595:     */   public PageInfo findEvsBookBySubDocName(String subDocName, String ouId, String date, int start, int pageSize)
/* 1596:     */   {
/* 1597:1923 */     StringBuffer sql = new StringBuffer();
/* 1598:1924 */     sql
/* 1599:1925 */       .append("select e2.BOOK_ID,e2.BOOK_CODE,e2.ARCHIVE_NUMBER,e2.BEGIN_NUM,e2.END_NUM,e2.BOOK_DATE,e2.BOOK_BREAK_FLAG,(select f.meaning from apps.fbp_lookup_values_v f where f.lookup_code=e2.BOOK_STATUS) as book_status ");
/* 1600:1926 */     sql.append("from Evs_book e2 ");
/* 1601:1927 */     sql.append("where e2.book_id in ");
/* 1602:1928 */     sql.append("(select distinct ee.book_id ");
/* 1603:1929 */     sql.append(" from EVS_VOUCHER_BOOK_PACKAGE ee ");
/* 1604:1930 */     sql.append(" where ee.voucher_id in ");
/* 1605:1931 */     sql.append("(select e.voucher_id ");
/* 1606:1932 */     sql.append(" from Evs_Voucher e ");
/* 1607:1933 */     sql.append("where e.journal_name = '" + subDocName + 
/* 1608:1934 */       "')) and e2.period_name='" + date + "' and e2.ou_name=" + 
/* 1609:1935 */       ouId);
/* 1610:     */     
/* 1611:1937 */     System.out.println(sql.toString());
/* 1612:1938 */     PageInfo pageInfo = PageInfoFromArrayBySQL(sql.toString(), start, 
/* 1613:1939 */       pageSize, null);
/* 1614:1940 */     return pageInfo;
/* 1615:     */   }
/* 1616:     */   
/* 1617:     */   public List getOuId(String checkUnit)
/* 1618:     */   {
/* 1619:1944 */     Connection cn = null;
/* 1620:1945 */     PreparedStatement ps = null;
/* 1621:1946 */     ResultSet rs = null;
/* 1622:1947 */     cn = getSession().connection();
/* 1623:1948 */     List<FasciculeQueryModel> tt1 = new ArrayList();
/* 1624:1949 */     String hql = "select tt.erp_org_id from fbp_check_unit_contents tt where tt.check_unit='" + 
/* 1625:1950 */       checkUnit + "'";
/* 1626:     */     try
/* 1627:     */     {
/* 1628:1952 */       ps = cn.prepareStatement(hql.toString());
/* 1629:1953 */       rs = ps.executeQuery();
/* 1630:1954 */       while (rs.next())
/* 1631:     */       {
/* 1632:1955 */         FasciculeQueryModel fasciculeQueryModel = new FasciculeQueryModel();
/* 1633:1956 */         fasciculeQueryModel.setErpId(rs.getString("erp_org_id"));
/* 1634:1957 */         tt1.add(fasciculeQueryModel);
/* 1635:     */       }
/* 1636:1959 */       ps.close();
/* 1637:1960 */       cn.close();
/* 1638:1961 */       rs.close();
/* 1639:     */     }
/* 1640:     */     catch (SQLException e)
/* 1641:     */     {
/* 1642:1963 */       e.printStackTrace();
/* 1643:     */     }
/* 1644:1965 */     System.out.println(hql);
/* 1645:1966 */     return tt1;
/* 1646:     */   }
/* 1647:     */   
/* 1648:     */   public EidObjectUtils getObjectUtils()
/* 1649:     */   {
/* 1650:1970 */     return this.objectUtils;
/* 1651:     */   }
/* 1652:     */   
/* 1653:     */   public void setObjectUtils(EidObjectUtils objectUtils)
/* 1654:     */   {
/* 1655:1974 */     this.objectUtils = objectUtils;
/* 1656:     */   }
/* 1657:     */   
/* 1658:     */   public PageInfo PageInfoFromArrayBySQL(String hql, int rangeStart, int fetchSize, Object[] para)
/* 1659:     */   {
/* 1660:1982 */     return PageInfoQueryForArraySQL(hql, 
/* 1661:1983 */       fixRangeStart(rangeStart, fetchSize), fetchSize, para);
/* 1662:     */   }
/* 1663:     */   
/* 1664:     */   public int fixRangeStart(int rangeStart, int fetchSize)
/* 1665:     */   {
/* 1666:1994 */     return rangeStart / fetchSize + 1;
/* 1667:     */   }
/* 1668:     */   
/* 1669:     */   private PageInfo PageInfoQueryForArraySQL(String hql, int PageInfoNo, int PageInfoSize, Object[] values)
/* 1670:     */   {
/* 1671:2010 */     if (hql != null) {
/* 1672:2011 */       Assert.hasText(hql);
/* 1673:     */     }
/* 1674:2012 */     if (PageInfoNo < 1) {
/* 1675:2013 */       PageInfoNo = 1;
/* 1676:     */     }
/* 1677:2014 */     String countQueryString = 
/* 1678:2015 */       " select count (*) " + new StringBuilder(" from (").append(hql).append(") s").toString();
/* 1679:     */     
/* 1680:     */ 
/* 1681:2018 */     long totalCount = 0L;
/* 1682:2019 */     long begin = System.currentTimeMillis();
/* 1683:2020 */     totalCount = getMyDataTotal(countQueryString, values).longValue();
/* 1684:2021 */     long end = System.currentTimeMillis();
/* 1685:2022 */     System.out.println("total spend time :" + (end - begin) / 1000L);
/* 1686:2023 */     if (totalCount < 1L) {
/* 1687:2024 */       return new PageInfo();
/* 1688:     */     }
/* 1689:2025 */     int startIndex = PageInfo.getStartOfPageInfo(PageInfoNo, PageInfoSize);
/* 1690:2026 */     Query query = getSession().createSQLQuery(hql);
/* 1691:2027 */     if (values != null) {
/* 1692:2028 */       for (int i = 0; i < values.length; i++) {
/* 1693:2029 */         query.setParameter(i, values[i]);
/* 1694:     */       }
/* 1695:     */     }
/* 1696:2032 */     List<Object[]> listTmp = query.setFirstResult(startIndex)
/* 1697:2033 */       .setMaxResults(PageInfoSize).list();
/* 1698:2034 */     return new PageInfo(startIndex, totalCount, PageInfoSize, listTmp);
/* 1699:     */   }
/* 1700:     */   
/* 1701:     */   private Long getMyDataTotal(String hql, Object[] values)
/* 1702:     */   {
/* 1703:2042 */     Query query = getSession().createSQLQuery(hql);
/* 1704:2043 */     if (values != null)
/* 1705:     */     {
/* 1706:2044 */       for (int i = 0; i < values.length; i++) {
/* 1707:2045 */         query.setParameter(i, values[i]);
/* 1708:     */       }
/* 1709:2047 */       List list = query.list();
/* 1710:2048 */       BigDecimal count = (list == null) || (list.size() <= 0) ? new BigDecimal(0) : 
/* 1711:2049 */         (BigDecimal)list.get(0);
/* 1712:2050 */       return Long.valueOf(count.longValue());
/* 1713:     */     }
/* 1714:2052 */     return Long.valueOf(0L);
/* 1715:     */   }
/* 1716:     */   
/* 1717:     */   public void deltempFence(String fance)
/* 1718:     */   {
/* 1719:2059 */     log.debug("delete evs_book ");
/* 1720:     */     try
/* 1721:     */     {
/* 1722:2063 */       if ((fance != null) && (!"".equals(fance)))
/* 1723:     */       {
/* 1724:2064 */         String hql = "delete EvsBook t where t.bookId =" + 
/* 1725:2065 */           fance;
/* 1726:     */         
/* 1727:2067 */         Query query = getSession().createQuery(hql);
/* 1728:2068 */         query.executeUpdate();
/* 1729:     */       }
/* 1730:2071 */       log.debug("delete successful ");
/* 1731:     */     }
/* 1732:     */     catch (RuntimeException re)
/* 1733:     */     {
/* 1734:2073 */       log.error("delete evs_book Exception", re);
/* 1735:2074 */       throw re;
/* 1736:     */     }
/* 1737:     */   }
/* 1738:     */   
/* 1739:     */   public void deleteVoucherByBook(String bookCode)
/* 1740:     */   {
/* 1741:2085 */     log.debug("DELETE Evs_Voucher_Book_Package ");
/* 1742:2086 */     StringBuffer sql = new StringBuffer();
/* 1743:2087 */     String bookCodeStr = bookCode.trim();
/* 1744:     */     try
/* 1745:     */     {
/* 1746:2090 */       sql.append("DELETE FROM EVS_VOUCHER_BOOK_PACKAGE P WHERE P.BOOK_ID IN ");
/* 1747:     */       
/* 1748:2092 */       sql.append(" (SELECT B.BOOK_ID FROM EVS_BOOK B WHERE B.BOOK_CODE IN ('" + bookCodeStr + "'))");
/* 1749:     */       
/* 1750:2094 */       getSession().createSQLQuery(sql.toString()).executeUpdate();
/* 1751:     */       
/* 1752:2096 */       log.error("DELETE Evs_Voucher_Book_Package By BOOK_ID");
/* 1753:     */     }
/* 1754:     */     catch (RuntimeException re)
/* 1755:     */     {
/* 1756:2098 */       log.error("DELETE failed", re);
/* 1757:2099 */       throw re;
/* 1758:     */     }
/* 1759:     */   }
/* 1760:     */   
/* 1761:     */   public EvsBook getBookByCodeAndEmployee(String bookCode, String employee)
/* 1762:     */   {
/* 1763:2109 */     EvsBook evsBook = null;
/* 1764:2111 */     if ((bookCode != null) && (!bookCode.equals("")))
/* 1765:     */     {
/* 1766:2112 */       log.debug("find TBook instance");
/* 1767:     */       try
/* 1768:     */       {
/* 1769:2114 */         String sql = "FROM EvsBook e where 1=1 and e.bookCode = '" + bookCode + 
/* 1770:2115 */           "' and e.bookEmployeeId ='" + employee + "'";
/* 1771:2116 */         Query query = getSession().createQuery(sql);
/* 1772:2117 */         List list = query.list();
/* 1773:2118 */         Iterator iterate = list.iterator();
/* 1774:2120 */         if ((iterate != null) && (!"".equals(iterate))) {
/* 1775:2122 */           while (iterate.hasNext()) {
/* 1776:2124 */             evsBook = (EvsBook)iterate.next();
/* 1777:     */           }
/* 1778:     */         }
/* 1779:2127 */         log.debug("find successful");
/* 1780:     */       }
/* 1781:     */       catch (RuntimeException re)
/* 1782:     */       {
/* 1783:2129 */         log.error("find failed", re);
/* 1784:2130 */         throw re;
/* 1785:     */       }
/* 1786:2132 */       return evsBook;
/* 1787:     */     }
/* 1788:2135 */     return null;
/* 1789:     */   }
/* 1790:     */   
/* 1791:     */   public void updateVoucherStatus(String status, String voucherId)
/* 1792:     */   {
/* 1793:2149 */     log.debug("update VOUCHER voucher_status");
/* 1794:     */     try
/* 1795:     */     {
/* 1796:2152 */       String hql = " update EVS_VOUCHER set voucher_status ='" + 
/* 1797:2153 */         status + 
/* 1798:2154 */         "'  where voucher_id in ('" + 
/* 1799:2155 */         voucherId + "')";
/* 1800:     */       
/* 1801:2157 */       getSession().createSQLQuery(hql).executeUpdate();
/* 1802:2158 */       log.debug("update successful");
/* 1803:     */     }
/* 1804:     */     catch (RuntimeException re)
/* 1805:     */     {
/* 1806:2161 */       log.error("update failed", re);
/* 1807:2162 */       throw re;
/* 1808:     */     }
/* 1809:     */   }
/* 1810:     */   
/* 1811:     */   public String getUnBookCode(EvsBookModel bookModel)
/* 1812:     */   {
/* 1813:2173 */     String boeCode = "";
/* 1814:2174 */     log.debug("find TBook instance");
/* 1815:     */     try
/* 1816:     */     {
/* 1817:2176 */       String sql = "select e.book_Code FROM Evs_Book e where e.company_Code = '" + bookModel.getCompanyCode() + 
/* 1818:2177 */         "' and e.period_Name ='" + bookModel.getPeriodName() + "'" + 
/* 1819:2178 */         " and e.book_Status = '" + "UNBOOK" + "' and e.book_Code not in (select b.book_Code from " + 
/* 1820:2179 */         " Evs_Book b where b.company_Code = '" + bookModel.getCompanyCode() + 
/* 1821:2180 */         "' and b.period_Name ='" + bookModel.getPeriodName() + "'" + 
/* 1822:2181 */         " and b.book_Status not in '" + "UNBOOK" + "') order by e.book_Code asc";
/* 1823:     */       
/* 1824:2183 */       List list = getSession().createSQLQuery(sql).list();
/* 1825:2184 */       if ((list != null) && (list.size() > 0)) {
/* 1826:2185 */         boeCode = list.get(0).toString();
/* 1827:     */       }
/* 1828:2187 */       log.debug("find successful");
/* 1829:     */     }
/* 1830:     */     catch (RuntimeException re)
/* 1831:     */     {
/* 1832:2189 */       log.error("find failed", re);
/* 1833:2190 */       throw re;
/* 1834:     */     }
/* 1835:2192 */     return boeCode;
/* 1836:     */   }
/* 1837:     */   
/* 1838:     */   public List<EvsVoucherV> findFascicule(String periodName, String companyCode, String fasciculetype, String[] bookCodes)
/* 1839:     */   {
/* 1840:2197 */     StringBuffer sb = new StringBuffer();
/* 1841:2198 */     List<Object> paras = new ArrayList();
/* 1842:2199 */     sb.append("FROM EvsVoucherV e WHERE 1=1  ");
/* 1843:2201 */     if (!Util.isStrEmpty(periodName))
/* 1844:     */     {
/* 1845:2202 */       sb.append(" AND e.periodName= ?");
/* 1846:2203 */       paras.add(periodName);
/* 1847:     */     }
/* 1848:2205 */     if (!Util.isStrEmpty(companyCode))
/* 1849:     */     {
/* 1850:2206 */       sb.append(" AND e.companyCode= ?");
/* 1851:2207 */       paras.add(companyCode);
/* 1852:     */     }
/* 1853:2209 */     if (!Util.isStrEmpty(fasciculetype))
/* 1854:     */     {
/* 1855:2210 */       sb.append(" AND e.fasciculetype= ?");
/* 1856:2211 */       paras.add(fasciculetype);
/* 1857:     */     }
/* 1858:2213 */     if (!Util.isNullObject(bookCodes))
/* 1859:     */     {
/* 1860:2214 */       sb.append(" and e.journalNum in ( ");
/* 1861:2215 */       if (bookCodes.length > 0) {
/* 1862:2216 */         for (int i = 0; i < bookCodes.length; i++)
/* 1863:     */         {
/* 1864:2217 */           String boeNum = bookCodes[i];
/* 1865:2219 */           if (i == 0) {
/* 1866:2220 */             sb.append("'" + boeNum + "'");
/* 1867:     */           } else {
/* 1868:2223 */             sb.append(",'" + boeNum + "'");
/* 1869:     */           }
/* 1870:     */         }
/* 1871:     */       }
/* 1872:2227 */       sb.append(")");
/* 1873:     */     }
/* 1874:2230 */     List list = getZormTemplate().find(sb.toString(), paras.toArray());
/* 1875:2231 */     return list;
/* 1876:     */   }
/* 1877:     */   
/* 1878:     */   public void insertBookPackage(EvsVoucherV evsVoucherV) {}
/* 1879:     */   
/* 1880:     */   public EvsBook insertBooks(String periodName, String companyCode, String fasciculetype, String thebookCodes)
/* 1881:     */   {
/* 1882:2242 */     EvsBook evsBook = new EvsBook();
/* 1883:     */     
/* 1884:2244 */     EvsObjectUtils loginUser = new EvsObjectUtils();
/* 1885:2245 */     EasUserInfo userInfo = EvsObjectUtils.getUserInfoBySession();
/* 1886:     */     try
/* 1887:     */     {
/* 1888:2248 */       if (!thebookCodes.equals("")) {
/* 1889:2249 */         evsBook.setBookCode(thebookCodes);
/* 1890:     */       }
/* 1891:2251 */       evsBook.setBookDate(new Date());
/* 1892:2253 */       if (userInfo != null)
/* 1893:     */       {
/* 1894:2255 */         if ((userInfo.getUserInfoPk() != null) && 
/* 1895:2256 */           (!"".equals(userInfo.getUserInfoPk())))
/* 1896:     */         {
/* 1897:2257 */           System.out.println("~~~~~~~~~~~获取当前用户信息~~~~~~~~~~~~~");
/* 1898:2258 */           evsBook.setBookEmployeeId(Long.valueOf(
/* 1899:2259 */             userInfo.getUserInfoPk().toString()));
/* 1900:2260 */           evsBook.setCreatedBy(Long.valueOf(
/* 1901:2261 */             userInfo.getUserInfoPk().toString()));
/* 1902:2262 */           evsBook.setLastUpdateBy(Long.valueOf(
/* 1903:2263 */             userInfo.getUserInfoPk().toString()));
/* 1904:2264 */           evsBook.setLastUpdateLogin(Long.valueOf(
/* 1905:2265 */             userInfo.getUserInfoPk().toString()));
/* 1906:     */         }
/* 1907:     */       }
/* 1908:     */       else
/* 1909:     */       {
/* 1910:2268 */         evsBook.setBookEmployeeId(Long.valueOf("82".toString()));
/* 1911:2269 */         evsBook.setCreatedBy(Long.valueOf("82".toString()));
/* 1912:2270 */         evsBook.setLastUpdateBy(Long.valueOf("82".toString()));
/* 1913:2271 */         evsBook.setLastUpdateLogin(Long.valueOf("82".toString()));
/* 1914:     */       }
/* 1915:2273 */       evsBook.setPeriodName(periodName);
/* 1916:2274 */       evsBook.setCompanyCode(companyCode);
/* 1917:2275 */       evsBook.setCreationDate(new Date());
/* 1918:2276 */       evsBook.setLastUpdateDate(new Date());
/* 1919:2277 */       evsBook.setBookStatus("");
/* 1920:2278 */       evsBook.setBookBreakFlag("Y");
/* 1921:2279 */       evsBook.setInvoiceType(fasciculetype);
/* 1922:     */       
/* 1923:2281 */       getSession().saveOrUpdate(evsBook);
/* 1924:     */     }
/* 1925:     */     catch (Exception e)
/* 1926:     */     {
/* 1927:2283 */       e.printStackTrace();
/* 1928:     */     }
/* 1929:2286 */     return evsBook;
/* 1930:     */   }
/* 1931:     */   
/* 1932:     */   public void insertBookPackage(EvsBook evsBook, String[] voucherid)
/* 1933:     */   {
/* 1934:2290 */     EvsObjectUtils loginUser = new EvsObjectUtils();
/* 1935:2291 */     EasUserInfo userInfo = EvsObjectUtils.getUserInfoBySession();
/* 1936:     */     try
/* 1937:     */     {
/* 1938:2293 */       EvsVoucherBookPackage vb = null;
/* 1939:2295 */       if (userInfo == null)
/* 1940:     */       {
/* 1941:2296 */         System.out.println("~~~~~~~~~~未能取得当前对象~~~~~~~~~~~~~~~~");
/* 1942:2298 */         for (int i = 0; i < voucherid.length; i++)
/* 1943:     */         {
/* 1944:2300 */           deleteVoucherBookPackage(evsBook.getBookId().toString(), voucherid[i]);
/* 1945:2301 */           vb = new EvsVoucherBookPackage();
/* 1946:2302 */           vb.setVoucherId(Long.valueOf(voucherid[i]));
/* 1947:2303 */           vb.setBookId(evsBook.getBookId());
/* 1948:2304 */           vb.setPackageId(Long.valueOf(Long.parseLong("0")));
/* 1949:2305 */           vb.setCreationDate(new Date());
/* 1950:2306 */           vb.setCreatedBy(Long.valueOf(Long.parseLong("110")));
/* 1951:2307 */           vb.setLastUpdateDate(new Date());
/* 1952:2308 */           vb.setLastUpdateBy(Long.valueOf(Long.parseLong("110")));
/* 1953:2309 */           vb.setLastUpdateLogin(Long.valueOf(Long.parseLong("110")));
/* 1954:2310 */           vb.setEnabledFlag("T");
/* 1955:2311 */           getSession().saveOrUpdate(vb);
/* 1956:     */         }
/* 1957:     */       }
/* 1958:2316 */       else if (userInfo != null)
/* 1959:     */       {
/* 1960:2317 */         System.out.println("~~~~~~~~~~已取得当前对象~~~~~~~~~~~~~~~~");
/* 1961:2319 */         for (int i = 0; i < voucherid.length; i++)
/* 1962:     */         {
/* 1963:2321 */           deleteVoucherBookPackage(evsBook.getBookId().toString(), voucherid[i]);
/* 1964:2322 */           vb = new EvsVoucherBookPackage();
/* 1965:2323 */           vb.setVoucherId(Long.valueOf(voucherid[i]));
/* 1966:2324 */           vb.setBookId(evsBook.getBookId());
/* 1967:2325 */           vb.setPackageId(Long.valueOf(Long.parseLong("0")));
/* 1968:2326 */           vb.setCreationDate(new Date());
/* 1969:2328 */           if ((userInfo.getUserInfoPk() != null) && 
/* 1970:2329 */             (!"".equals(userInfo.getUserInfoPk())))
/* 1971:     */           {
/* 1972:2330 */             vb.setCreatedBy(Long.valueOf(Long.parseLong(
/* 1973:2331 */               userInfo.getUserInfoPk().toString())));
/* 1974:2332 */             vb.setLastUpdateBy(Long.valueOf(Long.parseLong(
/* 1975:2333 */               userInfo.getUserInfoPk().toString())));
/* 1976:2334 */             vb.setLastUpdateLogin(Long.valueOf(Long.parseLong(
/* 1977:2335 */               userInfo.getUserInfoPk().toString())));
/* 1978:     */           }
/* 1979:2337 */           vb.setLastUpdateDate(new Date());
/* 1980:2338 */           vb.setEnabledFlag("T");
/* 1981:2339 */           getSession().saveOrUpdate(vb);
/* 1982:     */         }
/* 1983:     */       }
/* 1984:     */     }
/* 1985:     */     catch (RuntimeException re)
/* 1986:     */     {
/* 1987:2346 */       re.getStackTrace();
/* 1988:     */     }
/* 1989:     */   }
/* 1990:     */   
/* 1991:     */   public EvsBook findBookById(Long bookId)
/* 1992:     */   {
/* 1993:2351 */     String hql = "FROM EvsBook t WHERE 1=1 and t.bookId=" + bookId;
/* 1994:2352 */     List<EvsBook> list = getZormTemplate().find(hql);
/* 1995:2353 */     return (EvsBook)list.get(0);
/* 1996:     */   }
/* 1997:     */   
/* 1998:     */   public List<EvsBook> findBookByArchiveNumber(String current)
/* 1999:     */   {
/* 2000:2362 */     String hql = "FROM EvsBook t WHERE 1=1 and t.archiveNumber='" + current + "' order by bookId";
/* 2001:     */     
/* 2002:2364 */     List<EvsBook> list = getSession().createQuery(hql).list();
/* 2003:2365 */     return list;
/* 2004:     */   }
/* 2005:     */   
/* 2006:     */   public List<EvsBookV> findBookVByArchiveNumber(String current)
/* 2007:     */   {
/* 2008:2374 */     String hql = "FROM EvsBookV t WHERE 1=1 and t.archiveNumber=? order by bookId";
/* 2009:     */     
/* 2010:2376 */     List<EvsBookV> list = getSession().createQuery(hql).setString(0, current).list();
/* 2011:2377 */     return list;
/* 2012:     */   }
/* 2013:     */   
/* 2014:     */   public List<EvsVoucherBookPackage> findEvsVoucherBookPackage(Long bookId)
/* 2015:     */   {
/* 2016:2381 */     String hql = "FROM EvsVoucherBookPackage t WHERE 1=1 and t.enabledFlag='T' and t.bookId=" + bookId;
/* 2017:2382 */     List<EvsVoucherBookPackage> list = getZormTemplate().find(hql);
/* 2018:2383 */     return list;
/* 2019:     */   }
/* 2020:     */   
/* 2021:     */   public List<EvsVoucher> findEvsVoucher(String voucherIds, EvsBookModel evsBookModel)
/* 2022:     */   {
/* 2023:2388 */     String[] voucherId = voucherIds.split(",");
/* 2024:2389 */     StringBuffer sb = new StringBuffer();
/* 2025:2390 */     List<Object> paras = new ArrayList();
/* 2026:     */     
/* 2027:     */ 
/* 2028:2393 */     String bookId = evsBookModel.getBookId();
/* 2029:2394 */     if ((bookId != null) && (!"undefined".equals(bookId)))
/* 2030:     */     {
/* 2031:2395 */       sb.append("from EvsVoucher e where 1=1 ");
/* 2032:2396 */       if (!Util.isNullObject(voucherId))
/* 2033:     */       {
/* 2034:2397 */         sb.append(" and e.voucherId in ( ");
/* 2035:2398 */         if (voucherId.length > 0) {
/* 2036:2399 */           for (int i = 0; i < voucherId.length; i++)
/* 2037:     */           {
/* 2038:2400 */             String boeNum = voucherId[i];
/* 2039:2402 */             if (i == 0) {
/* 2040:2403 */               sb.append("'" + boeNum + "'");
/* 2041:     */             } else {
/* 2042:2406 */               sb.append(",'" + boeNum + "'");
/* 2043:     */             }
/* 2044:     */           }
/* 2045:     */         }
/* 2046:2410 */         sb.append(")");
/* 2047:     */       }
/* 2048:2413 */       if (!Util.isStrEmpty(evsBookModel.getCompanyCode()))
/* 2049:     */       {
/* 2050:2414 */         sb.append(" AND e.companyCode = ?");
/* 2051:2415 */         paras.add(evsBookModel.getCompanyCode());
/* 2052:     */       }
/* 2053:2418 */       if (!Util.isStrEmpty(evsBookModel.getPeriodName()))
/* 2054:     */       {
/* 2055:2419 */         sb.append(" AND e.periodName = ?");
/* 2056:2420 */         paras.add(evsBookModel.getPeriodName());
/* 2057:     */       }
/* 2058:2423 */       if (!Util.isStrEmpty(evsBookModel.getInvoiceType()))
/* 2059:     */       {
/* 2060:2424 */         sb.append(" AND e.invoiceTypeCode = ?");
/* 2061:2425 */         paras.add(evsBookModel.getInvoiceType());
/* 2062:     */       }
/* 2063:     */     }
/* 2064:2428 */     List<EvsVoucher> list = getZormTemplate().find(sb.toString(), paras.toArray());
/* 2065:     */     
/* 2066:2430 */     return list;
/* 2067:     */   }
/* 2068:     */   
/* 2069:     */   public List<EvsVoucherV> findVouchersList(String voucherIds)
/* 2070:     */   {
/* 2071:2435 */     String[] voucherId = voucherIds.split(",");
/* 2072:2436 */     StringBuffer sb = new StringBuffer();
/* 2073:2437 */     List<Object> paras = new ArrayList();
/* 2074:2439 */     if (voucherIds.length() > 0)
/* 2075:     */     {
/* 2076:2440 */       sb.append("from EvsVoucher e where 1=1 ");
/* 2077:2441 */       if (!Util.isNullObject(voucherId))
/* 2078:     */       {
/* 2079:2442 */         sb.append(" and e.voucherId in ( ");
/* 2080:2443 */         if (voucherId.length > 0) {
/* 2081:2444 */           for (int i = 0; i < voucherId.length; i++)
/* 2082:     */           {
/* 2083:2446 */             String boeNum = voucherId[i];
/* 2084:2449 */             if (i == 0) {
/* 2085:2450 */               sb.append("'" + boeNum + "'");
/* 2086:     */             } else {
/* 2087:2453 */               sb.append(",'" + boeNum + "'");
/* 2088:     */             }
/* 2089:     */           }
/* 2090:     */         }
/* 2091:2457 */         sb.append(")");
/* 2092:     */       }
/* 2093:     */     }
/* 2094:2460 */     List<EvsVoucherV> list = getZormTemplate().find(sb.toString(), paras.toArray());
/* 2095:     */     
/* 2096:2462 */     return list;
/* 2097:     */   }
/* 2098:     */   
/* 2099:     */   public List<EvsVoucher> findEvsVoucherYB(String voucherIds, EvsVoucherSelect evsBookModel)
/* 2100:     */   {
/* 2101:2467 */     String[] voucherId = voucherIds.split(",");
/* 2102:2468 */     StringBuffer sb = new StringBuffer();
/* 2103:2469 */     List<Object> paras = new ArrayList();
/* 2104:     */     
/* 2105:     */ 
/* 2106:2472 */     long bookId = evsBookModel.getBookId().longValue();
/* 2107:2473 */     if (!"undefined".equals(Long.valueOf(bookId)))
/* 2108:     */     {
/* 2109:2474 */       sb.append("from EvsVoucher e where 1=1 ");
/* 2110:2475 */       if (!Util.isNullObject(voucherId))
/* 2111:     */       {
/* 2112:2476 */         sb.append(" and e.voucherId in ( ");
/* 2113:2477 */         if (voucherId.length > 0) {
/* 2114:2478 */           for (int i = 0; i < voucherId.length; i++)
/* 2115:     */           {
/* 2116:2479 */             String boeNum = voucherId[i];
/* 2117:2481 */             if (i == 0) {
/* 2118:2482 */               sb.append("'" + boeNum + "'");
/* 2119:     */             } else {
/* 2120:2485 */               sb.append(",'" + boeNum + "'");
/* 2121:     */             }
/* 2122:     */           }
/* 2123:     */         }
/* 2124:2489 */         sb.append(")");
/* 2125:     */       }
/* 2126:2492 */       if (!Util.isStrEmpty(evsBookModel.getCompanyCode()))
/* 2127:     */       {
/* 2128:2493 */         sb.append(" AND e.companyCode = ?");
/* 2129:2494 */         paras.add(evsBookModel.getCompanyCode());
/* 2130:     */       }
/* 2131:2497 */       if (!Util.isStrEmpty(evsBookModel.getPeriod_name()))
/* 2132:     */       {
/* 2133:2498 */         sb.append(" AND e.periodName = ?");
/* 2134:2499 */         paras.add(evsBookModel.getPeriod_name());
/* 2135:     */       }
/* 2136:2502 */       if (!Util.isStrEmpty(evsBookModel.getInvoiceType()))
/* 2137:     */       {
/* 2138:2503 */         sb.append(" AND e.invoiceTypeCode = ?");
/* 2139:2504 */         paras.add(evsBookModel.getInvoiceType());
/* 2140:     */       }
/* 2141:     */     }
/* 2142:2507 */     List<EvsVoucher> list = getZormTemplate().find(sb.toString(), paras.toArray());
/* 2143:     */     
/* 2144:2509 */     return list;
/* 2145:     */   }
/* 2146:     */   
/* 2147:     */   public void updateEvsVoucher(EvsVoucher evsVoucher)
/* 2148:     */   {
/* 2149:2513 */     getSession().update(evsVoucher);
/* 2150:     */   }
/* 2151:     */   
/* 2152:     */   public List<EvsVoucherBookPackage> isVoucherDelet(String bookId, String voucherIds)
/* 2153:     */   {
/* 2154:2517 */     String[] voucherId = voucherIds.split(",");
/* 2155:2518 */     StringBuffer sb = new StringBuffer();
/* 2156:2519 */     List<Object> paras = new ArrayList();
/* 2157:2521 */     if ((bookId != null) && (!"undefined".equals(bookId)))
/* 2158:     */     {
/* 2159:2522 */       sb.append("from EvsVoucherBookPackage e where 1=1 ");
/* 2160:2523 */       if (!Util.isNullObject(voucherId))
/* 2161:     */       {
/* 2162:2524 */         sb.append(" and e.voucherId not in ( ");
/* 2163:2525 */         if (voucherId.length > 0) {
/* 2164:2526 */           for (int i = 0; i < voucherId.length; i++)
/* 2165:     */           {
/* 2166:2527 */             String boeNum = voucherId[i];
/* 2167:2529 */             if (i == 0) {
/* 2168:2530 */               sb.append("'" + boeNum + "'");
/* 2169:     */             } else {
/* 2170:2533 */               sb.append(",'" + boeNum + "'");
/* 2171:     */             }
/* 2172:     */           }
/* 2173:     */         }
/* 2174:2537 */         sb.append(")");
/* 2175:     */       }
/* 2176:2539 */       if (!Util.isStrEmpty(bookId))
/* 2177:     */       {
/* 2178:2540 */         sb.append(" AND e.bookId = ?");
/* 2179:2541 */         paras.add(Long.valueOf(bookId));
/* 2180:     */       }
/* 2181:     */     }
/* 2182:2544 */     List<EvsVoucherBookPackage> list = getZormTemplate().find(sb.toString(), paras.toArray());
/* 2183:2545 */     return list;
/* 2184:     */   }
/* 2185:     */   
/* 2186:     */   public List<EvsVoucherBookPackage> findEvsVoucherBookPackageForD(Long bookId)
/* 2187:     */   {
/* 2188:2550 */     String hql = "FROM EvsVoucherBookPackage t WHERE 1=1 and t.enabledFlag='N' and t.bookId=" + bookId;
/* 2189:2551 */     List<EvsVoucherBookPackage> list = getZormTemplate().find(hql);
/* 2190:2552 */     return list;
/* 2191:     */   }
/* 2192:     */   
/* 2193:     */   public List<EvsVoucherBookPackage> findEvsVoucherBookPackageForYB(Long bookId)
/* 2194:     */   {
/* 2195:2556 */     String hql = "FROM EvsVoucherBookPackage t WHERE 1=1 and t.enabledFlag='T' and t.bookId=" + bookId;
/* 2196:2557 */     List<EvsVoucherBookPackage> list = getZormTemplate().find(hql);
/* 2197:2558 */     return list;
/* 2198:     */   }
/* 2199:     */   
/* 2200:     */   public List<EvsVoucherBookPackage> findEvsVoucherBookPackageForYBByVouId(Long voucherId)
/* 2201:     */   {
/* 2202:2563 */     String hql = "FROM EvsVoucherBookPackage t WHERE 1=1 and t.enabledFlag='Y' and t.voucherId=" + voucherId;
/* 2203:2564 */     List<EvsVoucherBookPackage> list = getZormTemplate().find(hql);
/* 2204:2565 */     return list;
/* 2205:     */   }
/* 2206:     */   
/* 2207:     */   public void deleteVoucherBookPackages(List<EvsVoucherBookPackage> listTemp)
/* 2208:     */   {
/* 2209:2569 */     getZormTemplate().deleteAll(listTemp);
/* 2210:     */   }
/* 2211:     */   
/* 2212:     */   public String isBreakNumForL(EvsBookModel evsBookModel, EvsBookModel evsBookModel2)
/* 2213:     */   {
/* 2214:2580 */     String sql = "SELECT * FROM evs_voucher ev WHERE to_number(SUBSTR(ev.journal_num,2)) >= to_number('" + evsBookModel2.getBeginNum().substring(1);
/* 2215:2581 */     sql = sql + "') AND to_number(SUBSTR(ev.journal_num,2)) <= to_number('" + evsBookModel2.getEndNum().substring(1) + "') AND ev.period_name='" + evsBookModel.getPeriodName();
/* 2216:     */     
/* 2217:2583 */     sql = sql + "' AND ev.company_code='" + evsBookModel.getCompanyCode() + "'";
/* 2218:2584 */     sql = sql + " AND ev.invoice_type_code='" + evsBookModel.getInvoiceType() + "'";
/* 2219:2585 */     if ((evsBookModel2.getRealtionId() == null) || ("".equals(evsBookModel2.getRealtionId()))) {
/* 2220:2586 */       sql = sql + " and ev.voucher_Status in('MATCHED','UNBOOK')";
/* 2221:     */     } else {
/* 2222:2588 */       sql = sql + " and ev.voucher_Status in('BOOKED','MATCHED')";
/* 2223:     */     }
/* 2224:2590 */     List<EvsVoucher> list = getSession().createSQLQuery(sql).list();
/* 2225:2591 */     Long count = Long.valueOf(Long.valueOf(evsBookModel2.getEndNum()).longValue() + 1L - Long.valueOf(evsBookModel2.getBeginNum()).longValue());
/* 2226:2592 */     if (list.size() != count.longValue()) {
/* 2227:2593 */       return "fail";
/* 2228:     */     }
/* 2229:2595 */     return "true";
/* 2230:     */   }
/* 2231:     */   
/* 2232:     */   public Map findFasciculeForL(EvsBook evsBookModel, int start, int pageSize)
/* 2233:     */   {
/* 2234:2599 */     StringBuffer sb = new StringBuffer();
/* 2235:2600 */     List<Object> paras = new ArrayList();
/* 2236:2601 */     Map map = new HashMap();
/* 2237:2602 */     sb.append("FROM EvsVoucherV e WHERE 1=1  ");
/* 2238:2604 */     if (!Util.isStrEmpty(evsBookModel.getPeriodName()))
/* 2239:     */     {
/* 2240:2605 */       sb.append(" AND e.periodName= ?");
/* 2241:2606 */       paras.add(evsBookModel.getPeriodName());
/* 2242:     */     }
/* 2243:2608 */     if (!Util.isStrEmpty(evsBookModel.getCompanyCode()))
/* 2244:     */     {
/* 2245:2609 */       sb.append(" AND e.companyCode= ?");
/* 2246:2610 */       paras.add(evsBookModel.getCompanyCode());
/* 2247:     */     }
/* 2248:2612 */     if (!Util.isStrEmpty(evsBookModel.getInvoiceType()))
/* 2249:     */     {
/* 2250:2613 */       sb.append(" AND e.invoiceTypeCode= ?");
/* 2251:2614 */       paras.add(evsBookModel.getInvoiceType());
/* 2252:     */     }
/* 2253:2616 */     if (!Util.isNullObject(evsBookModel.getBeginNum()))
/* 2254:     */     {
/* 2255:2617 */       sb.append(" and e.journalNum >= ?");
/* 2256:2618 */       paras.add(evsBookModel.getBeginNum());
/* 2257:     */     }
/* 2258:2620 */     if (!Util.isNullObject(evsBookModel.getEndNum()))
/* 2259:     */     {
/* 2260:2621 */       sb.append(" and e.journalNum <= ?");
/* 2261:2622 */       paras.add(evsBookModel.getEndNum());
/* 2262:     */     }
/* 2263:2624 */     sb.append(" order by e.invoiceTypeCode,e.journalNum");
/* 2264:2625 */     PageInfo page = super.PageInfoQuery(sb.toString(), start / pageSize + 
/* 2265:2626 */       1, pageSize, paras.toArray());
/* 2266:2627 */     map.put("data", page.getResult());
/* 2267:2628 */     map.put("totalCount", Long.valueOf(page.getTotalCount()));
/* 2268:2629 */     return map;
/* 2269:     */   }
/* 2270:     */   
/* 2271:     */   public Map findFasciculeForLYB(EvsBook evsBookModel, String[] voucherId, int start, int pageSize)
/* 2272:     */   {
/* 2273:2637 */     List paramList = new ArrayList();
/* 2274:2638 */     StringBuffer sb = new StringBuffer();
/* 2275:2639 */     String sql = null;
/* 2276:2640 */     String str = "";
/* 2277:2642 */     for (int i = 0; i < voucherId.length; i++) {
/* 2278:2644 */       if (i != voucherId.length - 1) {
/* 2279:2645 */         str = str + voucherId[i] + ",";
/* 2280:     */       } else {
/* 2281:2648 */         str = str + voucherId[i];
/* 2282:     */       }
/* 2283:     */     }
/* 2284:2653 */     sb.append("From EvsVoucherV t  where t.voucherId in (" + str + ")");
/* 2285:2654 */     sb.append(" order by t.invoiceTypeCode,t.journalNum");
/* 2286:2655 */     PageInfo p = PageInfoQuery(sb.toString(), start / pageSize + 1, pageSize, new Object[0]);
/* 2287:2656 */     Map map = new HashMap();
/* 2288:2657 */     map.put("data", p.getResult());
/* 2289:2658 */     map.put("totalCount", Long.valueOf(p.getTotalCount()));
/* 2290:2659 */     return map;
/* 2291:     */   }
/* 2292:     */   
/* 2293:     */   public void insertBookPackageList(List<EvsBookModel> list, Long bookId)
/* 2294:     */   {
/* 2295:2663 */     EvsObjectUtils loginUser = new EvsObjectUtils();
/* 2296:2664 */     EasUserInfo userInfo = EvsObjectUtils.getUserInfoBySession();
/* 2297:     */     try
/* 2298:     */     {
/* 2299:2666 */       EvsVoucherBookPackage vb = null;
/* 2300:2668 */       if (userInfo != null)
/* 2301:     */       {
/* 2302:2669 */         System.out.println("~~~~~~~~~~已取得当前对象~~~~~~~~~~~~~~~~");
/* 2303:2671 */         for (EvsBookModel evsBookModel : list)
/* 2304:     */         {
/* 2305:2674 */           vb = new EvsVoucherBookPackage();
/* 2306:2675 */           vb.setBookId(bookId);
/* 2307:2676 */           vb.setPackageId(Long.valueOf(Long.parseLong("0")));
/* 2308:2677 */           vb.setCreationDate(new Date());
/* 2309:2679 */           if ((userInfo.getUserInfoPk() != null) && 
/* 2310:2680 */             (!"".equals(userInfo.getUserInfoPk())))
/* 2311:     */           {
/* 2312:2681 */             vb.setCreatedBy(Long.valueOf(Long.parseLong(
/* 2313:2682 */               userInfo.getUserInfoPk().toString())));
/* 2314:2683 */             vb.setLastUpdateBy(Long.valueOf(Long.parseLong(
/* 2315:2684 */               userInfo.getUserInfoPk().toString())));
/* 2316:2685 */             vb.setLastUpdateLogin(Long.valueOf(Long.parseLong(
/* 2317:2686 */               userInfo.getUserInfoPk().toString())));
/* 2318:     */           }
/* 2319:2688 */           vb.setLastUpdateDate(new Date());
/* 2320:2689 */           vb.setEnabledFlag("T");
/* 2321:2690 */           vb.setSerialNum(evsBookModel.getSerialNum());
/* 2322:2691 */           vb.setBeginNum(evsBookModel.getBeginNum());
/* 2323:2692 */           vb.setEndNum(evsBookModel.getEndNum());
/* 2324:2693 */           vb.setBookSum(Long.valueOf(evsBookModel.getBookSum()));
/* 2325:2694 */           vb.setBookCount(Long.valueOf(evsBookModel.getBookCount()));
/* 2326:2695 */           vb.setVoucherId(Long.valueOf(0L));
/* 2327:2696 */           getSession().saveOrUpdate(vb);
/* 2328:     */         }
/* 2329:     */       }
/* 2330:     */     }
/* 2331:     */     catch (RuntimeException re)
/* 2332:     */     {
/* 2333:2700 */       re.getStackTrace();
/* 2334:     */     }
/* 2335:     */   }
/* 2336:     */   
/* 2337:     */   public void insertBookPackageList(EvsBookModel bookModel, Long bookId)
/* 2338:     */   {
/* 2339:2710 */     EvsObjectUtils loginUser = new EvsObjectUtils();
/* 2340:2711 */     EasUserInfo userInfo = EvsObjectUtils.getUserInfoBySession();
/* 2341:     */     try
/* 2342:     */     {
/* 2343:2713 */       EvsVoucherBookPackage vb = null;
/* 2344:2715 */       if (userInfo != null)
/* 2345:     */       {
/* 2346:2716 */         System.out.println("~~~~~~~~~~已取得当前对象~~~~~~~~~~~~~~~~");
/* 2347:     */         
/* 2348:     */ 
/* 2349:     */ 
/* 2350:     */ 
/* 2351:2721 */         vb = new EvsVoucherBookPackage();
/* 2352:2722 */         vb.setBookId(bookId);
/* 2353:2723 */         vb.setPackageId(Long.valueOf(Long.parseLong("0")));
/* 2354:2724 */         vb.setCreationDate(new Date());
/* 2355:2726 */         if ((userInfo.getUserInfoPk() != null) && 
/* 2356:2727 */           (!"".equals(userInfo.getUserInfoPk())))
/* 2357:     */         {
/* 2358:2728 */           vb.setCreatedBy(Long.valueOf(Long.parseLong(
/* 2359:2729 */             userInfo.getUserInfoPk().toString())));
/* 2360:2730 */           vb.setLastUpdateBy(Long.valueOf(Long.parseLong(
/* 2361:2731 */             userInfo.getUserInfoPk().toString())));
/* 2362:2732 */           vb.setLastUpdateLogin(Long.valueOf(Long.parseLong(
/* 2363:2733 */             userInfo.getUserInfoPk().toString())));
/* 2364:     */         }
/* 2365:2735 */         vb.setLastUpdateDate(new Date());
/* 2366:2736 */         vb.setEnabledFlag("T");
/* 2367:2737 */         vb.setSerialNum(bookModel.getSerialNum());
/* 2368:2738 */         vb.setBeginNum(bookModel.getBeginNum());
/* 2369:2739 */         vb.setEndNum(bookModel.getEndNum());
/* 2370:2740 */         vb.setBookSum(Long.valueOf(bookModel.getBookSum()));
/* 2371:2741 */         vb.setBookCount(Long.valueOf(bookModel.getBookCount()));
/* 2372:2742 */         vb.setVoucherId(Long.valueOf(0L));
/* 2373:2743 */         getSession().saveOrUpdate(vb);
/* 2374:     */       }
/* 2375:     */     }
/* 2376:     */     catch (RuntimeException re)
/* 2377:     */     {
/* 2378:2747 */       re.getStackTrace();
/* 2379:     */     }
/* 2380:     */   }
/* 2381:     */   
/* 2382:     */   public EvsBook insertBooksForL(String periodName, String companyCode, String invoiceType, String thebookCodes, EvsBookModel evsBookModel)
/* 2383:     */   {
/* 2384:2753 */     EvsBook evsBook = new EvsBook();
/* 2385:     */     
/* 2386:2755 */     EvsObjectUtils loginUser = new EvsObjectUtils();
/* 2387:2756 */     EasUserInfo userInfo = EvsObjectUtils.getUserInfoBySession();
/* 2388:     */     try
/* 2389:     */     {
/* 2390:2759 */       if (!thebookCodes.equals("")) {
/* 2391:2760 */         evsBook.setBookCode(thebookCodes);
/* 2392:     */       }
/* 2393:2762 */       if ((!"".equals(evsBookModel.getBookId())) && (evsBookModel.getBookId() != null)) {
/* 2394:2763 */         evsBook.setBookId(Long.valueOf(evsBookModel.getBookId()));
/* 2395:     */       }
/* 2396:2765 */       evsBook.setBookDate(new Date());
/* 2397:2767 */       if (userInfo != null)
/* 2398:     */       {
/* 2399:2769 */         if ((userInfo.getUserInfoPk() != null) && 
/* 2400:2770 */           (!"".equals(userInfo.getUserInfoPk())))
/* 2401:     */         {
/* 2402:2771 */           System.out.println("~~~~~~~~~~~获取当前用户信息~~~~~~~~~~~~~");
/* 2403:2772 */           evsBook.setBookEmployeeId(Long.valueOf(
/* 2404:2773 */             userInfo.getUserInfoPk().toString()));
/* 2405:2774 */           evsBook.setCreatedBy(Long.valueOf(
/* 2406:2775 */             userInfo.getUserInfoPk().toString()));
/* 2407:2776 */           evsBook.setLastUpdateBy(Long.valueOf(
/* 2408:2777 */             userInfo.getUserInfoPk().toString()));
/* 2409:2778 */           evsBook.setLastUpdateLogin(Long.valueOf(
/* 2410:2779 */             userInfo.getUserInfoPk().toString()));
/* 2411:     */         }
/* 2412:     */       }
/* 2413:     */       else
/* 2414:     */       {
/* 2415:2782 */         evsBook.setBookEmployeeId(Long.valueOf("82".toString()));
/* 2416:2783 */         evsBook.setCreatedBy(Long.valueOf("82".toString()));
/* 2417:2784 */         evsBook.setLastUpdateBy(Long.valueOf("82".toString()));
/* 2418:2785 */         evsBook.setLastUpdateLogin(Long.valueOf("82".toString()));
/* 2419:     */       }
/* 2420:2787 */       evsBook.setPeriodName(periodName);
/* 2421:2788 */       evsBook.setBeginNum(evsBookModel.getBeginBookCode());
/* 2422:2789 */       evsBook.setEndNum(evsBookModel.getEndBookCode());
/* 2423:2790 */       evsBook.setCompanyCode(companyCode);
/* 2424:2791 */       evsBook.setCreationDate(new Date());
/* 2425:2792 */       evsBook.setLastUpdateDate(new Date());
/* 2426:2793 */       evsBook.setBookStatus("");
/* 2427:2794 */       evsBook.setBookBreakFlag("N");
/* 2428:2795 */       evsBook.setInvoiceType(invoiceType);
/* 2429:     */       
/* 2430:2797 */       getSession().saveOrUpdate(evsBook);
/* 2431:     */     }
/* 2432:     */     catch (Exception e)
/* 2433:     */     {
/* 2434:2799 */       e.printStackTrace();
/* 2435:     */     }
/* 2436:2802 */     return evsBook;
/* 2437:     */   }
/* 2438:     */   
/* 2439:     */   public EvsBook insertBooksForL(String periodName, String companyCode, String invoiceType, String thebookCodes, EvsBookModel evsBookModel, EvsBookModel bookModel)
/* 2440:     */   {
/* 2441:2819 */     EvsBook evsBook = new EvsBook();
/* 2442:     */     
/* 2443:2821 */     EvsObjectUtils loginUser = new EvsObjectUtils();
/* 2444:2822 */     EasUserInfo userInfo = EvsObjectUtils.getUserInfoBySession();
/* 2445:     */     try
/* 2446:     */     {
/* 2447:2826 */       if (!thebookCodes.equals("")) {
/* 2448:2827 */         evsBook.setBookCode(thebookCodes);
/* 2449:     */       }
/* 2450:2829 */       if ((!"".equals(evsBookModel.getBookId())) && (evsBookModel.getBookId() != null)) {
/* 2451:2830 */         evsBook.setBookId(Long.valueOf(evsBookModel.getBookId()));
/* 2452:     */       }
/* 2453:2832 */       evsBook.setBookDate(new Date());
/* 2454:2834 */       if (userInfo != null)
/* 2455:     */       {
/* 2456:2836 */         if ((userInfo.getUserInfoPk() != null) && 
/* 2457:2837 */           (!"".equals(userInfo.getUserInfoPk())))
/* 2458:     */         {
/* 2459:2838 */           System.out.println("~~~~~~~~~~~获取当前用户信息~~~~~~~~~~~~~");
/* 2460:2839 */           evsBook.setBookEmployeeId(Long.valueOf(
/* 2461:2840 */             userInfo.getUserInfoPk().toString()));
/* 2462:2841 */           evsBook.setCreatedBy(Long.valueOf(
/* 2463:2842 */             userInfo.getUserInfoPk().toString()));
/* 2464:2843 */           evsBook.setLastUpdateBy(Long.valueOf(
/* 2465:2844 */             userInfo.getUserInfoPk().toString()));
/* 2466:2845 */           evsBook.setLastUpdateLogin(Long.valueOf(
/* 2467:2846 */             userInfo.getUserInfoPk().toString()));
/* 2468:     */         }
/* 2469:     */       }
/* 2470:     */       else
/* 2471:     */       {
/* 2472:2849 */         evsBook.setBookEmployeeId(Long.valueOf("82".toString()));
/* 2473:2850 */         evsBook.setCreatedBy(Long.valueOf("82".toString()));
/* 2474:2851 */         evsBook.setLastUpdateBy(Long.valueOf("82".toString()));
/* 2475:2852 */         evsBook.setLastUpdateLogin(Long.valueOf("82".toString()));
/* 2476:     */       }
/* 2477:2854 */       evsBook.setPeriodName(periodName);
/* 2478:2855 */       evsBook.setBeginNum(bookModel.getBeginNum());
/* 2479:2856 */       evsBook.setEndNum(bookModel.getEndNum());
/* 2480:2857 */       evsBook.setCompanyCode(companyCode);
/* 2481:2858 */       evsBook.setCreationDate(new Date());
/* 2482:2859 */       evsBook.setLastUpdateDate(new Date());
/* 2483:2860 */       evsBook.setBookStatus("UNBOOK");
/* 2484:2861 */       evsBook.setBookBreakFlag("N");
/* 2485:2862 */       evsBook.setInvoiceType(invoiceType);
/* 2486:2863 */       evsBook.setBookCount(Long.valueOf(Long.parseLong(bookModel.getBookCount())));
/* 2487:2864 */       evsBook.setBookSum(Long.valueOf(Long.parseLong(bookModel.getBookSum())));
/* 2488:2865 */       evsBook.setArchiveNumber(evsBookModel.getArchiveNumber());
/* 2489:     */       
/* 2490:2867 */       super.insertObject(evsBook);
/* 2491:     */     }
/* 2492:     */     catch (Exception e)
/* 2493:     */     {
/* 2494:2869 */       e.printStackTrace();
/* 2495:     */     }
/* 2496:2872 */     return evsBook;
/* 2497:     */   }
/* 2498:     */   
/* 2499:     */   public EvsBook insertBooksForYB(String periodName, String companyCode, String invoiceType, String thebookCodes, EvsVoucherSelect evsBookModel, EvsVoucherV voucherV, String beginNum, String endNum)
/* 2500:     */   {
/* 2501:2889 */     EvsBook evsBook = new EvsBook();
/* 2502:     */     
/* 2503:2891 */     EvsObjectUtils loginUser = new EvsObjectUtils();
/* 2504:2892 */     EasUserInfo userInfo = EvsObjectUtils.getUserInfoBySession();
/* 2505:     */     try
/* 2506:     */     {
/* 2507:2896 */       if (!thebookCodes.equals("")) {
/* 2508:2897 */         evsBook.setBookCode(thebookCodes);
/* 2509:     */       }
/* 2510:2899 */       if ((!"".equals(evsBookModel.getBookId())) && (evsBookModel.getBookId() != null)) {
/* 2511:2900 */         evsBook.setBookId(Long.valueOf(evsBookModel.getBookId().longValue()));
/* 2512:     */       }
/* 2513:2902 */       evsBook.setBookDate(new Date());
/* 2514:2904 */       if (userInfo != null)
/* 2515:     */       {
/* 2516:2906 */         if ((userInfo.getUserInfoPk() != null) && 
/* 2517:2907 */           (!"".equals(userInfo.getUserInfoPk())))
/* 2518:     */         {
/* 2519:2908 */           System.out.println("~~~~~~~~~~~获取当前用户信息~~~~~~~~~~~~~");
/* 2520:2909 */           evsBook.setBookEmployeeId(Long.valueOf(
/* 2521:2910 */             userInfo.getUserInfoPk().toString()));
/* 2522:2911 */           evsBook.setCreatedBy(Long.valueOf(
/* 2523:2912 */             userInfo.getUserInfoPk().toString()));
/* 2524:2913 */           evsBook.setLastUpdateBy(Long.valueOf(
/* 2525:2914 */             userInfo.getUserInfoPk().toString()));
/* 2526:2915 */           evsBook.setLastUpdateLogin(Long.valueOf(
/* 2527:2916 */             userInfo.getUserInfoPk().toString()));
/* 2528:     */         }
/* 2529:     */       }
/* 2530:     */       else
/* 2531:     */       {
/* 2532:2919 */         evsBook.setBookEmployeeId(Long.valueOf("82".toString()));
/* 2533:2920 */         evsBook.setCreatedBy(Long.valueOf("82".toString()));
/* 2534:2921 */         evsBook.setLastUpdateBy(Long.valueOf("82".toString()));
/* 2535:2922 */         evsBook.setLastUpdateLogin(Long.valueOf("82".toString()));
/* 2536:     */       }
/* 2537:2924 */       evsBook.setPeriodName(periodName);
/* 2538:2925 */       evsBook.setBeginNum(beginNum);
/* 2539:2926 */       evsBook.setEndNum(endNum);
/* 2540:2927 */       evsBook.setCompanyCode(companyCode);
/* 2541:2928 */       evsBook.setCreationDate(new Date());
/* 2542:2929 */       evsBook.setLastUpdateDate(new Date());
/* 2543:2930 */       evsBook.setBookStatus("UNBOOK");
/* 2544:2931 */       evsBook.setBookBreakFlag("S");
/* 2545:2932 */       evsBook.setInvoiceType(voucherV.getInvoiceTypeCode());
/* 2546:2933 */       evsBook.setBookCount(evsBookModel.getBookCount());
/* 2547:2934 */       evsBook.setBookSum(evsBookModel.getBookSum());
/* 2548:2935 */       evsBook.setArchiveNumber(evsBookModel.getArchiveNumber());
/* 2549:2936 */       evsBook.setRemark(evsBookModel.getRemark());
/* 2550:     */       
/* 2551:2938 */       super.insertObject(evsBook);
/* 2552:     */     }
/* 2553:     */     catch (Exception e)
/* 2554:     */     {
/* 2555:2940 */       e.printStackTrace();
/* 2556:     */     }
/* 2557:2943 */     return evsBook;
/* 2558:     */   }
/* 2559:     */   
/* 2560:     */   public void insertBookPackageList(EvsVoucherSelect bookModel, Long bookId)
/* 2561:     */   {
/* 2562:2954 */     EvsObjectUtils loginUser = new EvsObjectUtils();
/* 2563:2955 */     EasUserInfo userInfo = EvsObjectUtils.getUserInfoBySession();
/* 2564:     */     try
/* 2565:     */     {
/* 2566:2957 */       EvsVoucherBookPackage vb = null;
/* 2567:2959 */       if (userInfo != null)
/* 2568:     */       {
/* 2569:2960 */         System.out.println("~~~~~~~~~~已取得当前对象~~~~~~~~~~~~~~~~");
/* 2570:     */         
/* 2571:     */ 
/* 2572:     */ 
/* 2573:     */ 
/* 2574:2965 */         vb = new EvsVoucherBookPackage();
/* 2575:2966 */         vb.setBookId(bookId);
/* 2576:2967 */         vb.setPackageId(Long.valueOf(Long.parseLong("0")));
/* 2577:2968 */         vb.setCreationDate(new Date());
/* 2578:2970 */         if ((userInfo.getUserInfoPk() != null) && 
/* 2579:2971 */           (!"".equals(userInfo.getUserInfoPk())))
/* 2580:     */         {
/* 2581:2972 */           vb.setCreatedBy(Long.valueOf(Long.parseLong(
/* 2582:2973 */             userInfo.getUserInfoPk().toString())));
/* 2583:2974 */           vb.setLastUpdateBy(Long.valueOf(Long.parseLong(
/* 2584:2975 */             userInfo.getUserInfoPk().toString())));
/* 2585:2976 */           vb.setLastUpdateLogin(Long.valueOf(Long.parseLong(
/* 2586:2977 */             userInfo.getUserInfoPk().toString())));
/* 2587:     */         }
/* 2588:2979 */         vb.setLastUpdateDate(new Date());
/* 2589:2980 */         vb.setEnabledFlag("T");
/* 2590:2981 */         vb.setSerialNum(bookModel.getSerialNum());
/* 2591:2982 */         vb.setBookSum(bookModel.getBookSum());
/* 2592:2983 */         vb.setBeginNum(bookModel.getBeginNum());
/* 2593:2984 */         vb.setEndNum(bookModel.getEndNum());
/* 2594:2985 */         vb.setBookCount(bookModel.getBookCount());
/* 2595:2986 */         vb.setVoucherId(bookModel.getVoucherId());
/* 2596:2987 */         getSession().saveOrUpdate(vb);
/* 2597:     */       }
/* 2598:     */     }
/* 2599:     */     catch (RuntimeException re)
/* 2600:     */     {
/* 2601:2991 */       re.getStackTrace();
/* 2602:     */     }
/* 2603:     */   }
/* 2604:     */   
/* 2605:     */   void saveOrUpdate(EvsBook evsBook)
/* 2606:     */   {
/* 2607:2996 */     if ((evsBook != null) && (evsBook.getBookId() != null))
/* 2608:     */     {
/* 2609:2997 */       EvsBook book = (EvsBook)super.getObject(EvsBook.class, evsBook.getBookId());
/* 2610:2998 */       ObjectCopyUtils.copy(evsBook, book);
/* 2611:2999 */       super.updateObject(book);
/* 2612:     */     }
/* 2613:     */     else
/* 2614:     */     {
/* 2615:3001 */       super.insertObject(evsBook);
/* 2616:     */     }
/* 2617:     */   }
/* 2618:     */   
/* 2619:     */   public List<EvsVoucher> findEvsVoucherForL(EvsBook evsBookModel)
/* 2620:     */   {
/* 2621:3007 */     StringBuffer sb = new StringBuffer();
/* 2622:3008 */     List<Object> paras = new ArrayList();
/* 2623:     */     
/* 2624:     */ 
/* 2625:3011 */     Long bookId = evsBookModel.getBookId();
/* 2626:3012 */     if ((bookId != null) && (!"undefined".equals(bookId)))
/* 2627:     */     {
/* 2628:3013 */       sb.append("from EvsVoucher e where 1=1 ");
/* 2629:3014 */       if (!Util.isNullObject(evsBookModel.getBeginNum()))
/* 2630:     */       {
/* 2631:3015 */         sb.append(" AND e.journalNum >= ?");
/* 2632:3016 */         paras.add(evsBookModel.getBeginNum());
/* 2633:     */       }
/* 2634:3018 */       if (!Util.isNullObject(evsBookModel.getEndNum()))
/* 2635:     */       {
/* 2636:3019 */         sb.append(" AND e.journalNum <= ?");
/* 2637:3020 */         paras.add(evsBookModel.getEndNum());
/* 2638:     */       }
/* 2639:3023 */       if (!Util.isStrEmpty(evsBookModel.getCompanyCode()))
/* 2640:     */       {
/* 2641:3024 */         sb.append(" AND e.companyCode = ?");
/* 2642:3025 */         paras.add(evsBookModel.getCompanyCode());
/* 2643:     */       }
/* 2644:3028 */       if (!Util.isStrEmpty(evsBookModel.getPeriodName()))
/* 2645:     */       {
/* 2646:3029 */         sb.append(" AND e.periodName = ?");
/* 2647:3030 */         paras.add(evsBookModel.getPeriodName());
/* 2648:     */       }
/* 2649:3033 */       if (!Util.isStrEmpty(evsBookModel.getInvoiceType()))
/* 2650:     */       {
/* 2651:3034 */         sb.append(" AND e.invoiceTypeCode = ?");
/* 2652:3035 */         paras.add(evsBookModel.getInvoiceType());
/* 2653:     */       }
/* 2654:     */     }
/* 2655:3038 */     List<EvsVoucher> list = getZormTemplate().find(sb.toString(), paras.toArray());
/* 2656:     */     
/* 2657:3040 */     return list;
/* 2658:     */   }
/* 2659:     */   
/* 2660:     */   public List<EvsVoucherBookPackage> findBooksForL(String bookId)
/* 2661:     */   {
/* 2662:3044 */     String hql = "FROM EvsVoucherBookPackage t WHERE 1=1 and t.bookId=" + bookId;
/* 2663:3045 */     List<EvsVoucherBookPackage> list = getZormTemplate().find(hql);
/* 2664:3046 */     return list;
/* 2665:     */   }
/* 2666:     */   
/* 2667:     */   public List<EvsVoucherBookPackage> checkVoucherForS(Long voucherId)
/* 2668:     */   {
/* 2669:3054 */     String hql = "FROM EvsVoucherBookPackage t WHERE 1=1 and t.enabledFlag!='N' and t.voucherId=" + voucherId;
/* 2670:3055 */     List<EvsVoucherBookPackage> list = getZormTemplate().find(hql);
/* 2671:3056 */     return list;
/* 2672:     */   }
/* 2673:     */   
/* 2674:     */   public EvsVoucher getVoucherForS(Long voucherId)
/* 2675:     */   {
/* 2676:3064 */     String hql = "FROM EvsVoucher t WHERE 1=1  and t.voucherId=" + voucherId;
/* 2677:3065 */     List<EvsVoucher> listEvs = getZormTemplate().find(hql);
/* 2678:3066 */     if (listEvs.size() > 0) {
/* 2679:3067 */       return (EvsVoucher)listEvs.get(0);
/* 2680:     */     }
/* 2681:3069 */     return null;
/* 2682:     */   }
/* 2683:     */   
/* 2684:     */   public void deleteEvsBook(EvsBook e)
/* 2685:     */   {
/* 2686:3072 */     getSession().delete(e);
/* 2687:     */   }
/* 2688:     */   
/* 2689:     */   public List<EvsVoucher> findEvsVoucherForD(EvsBook e)
/* 2690:     */   {
/* 2691:3077 */     return null;
/* 2692:     */   }
/* 2693:     */   
/* 2694:     */   public void saveEvsInventory(EvsInventory evsInventory)
/* 2695:     */   {
/* 2696:3085 */     super.getZormTemplate().saveOrUpdate(evsInventory);
/* 2697:     */   }
/* 2698:     */   
/* 2699:     */   public EvsInventory findEvsInventory(EvsBook book)
/* 2700:     */   {
/* 2701:3093 */     List<EvsInventory> list = new ArrayList();
/* 2702:3094 */     StringBuffer sb = new StringBuffer("from EvsInventory ev where 1=1");
/* 2703:3095 */     if ((book != null) && 
/* 2704:3096 */       (book.getBookId() != null)) {
/* 2705:3097 */       sb.append(" and ev.bookId=").append(book.getBookId());
/* 2706:     */     }
/* 2707:3100 */     list = super.getZormTemplate().find(sb.toString());
/* 2708:3101 */     if (list.size() > 0) {
/* 2709:3102 */       return (EvsInventory)list.get(0);
/* 2710:     */     }
/* 2711:3104 */     return null;
/* 2712:     */   }
/* 2713:     */   
/* 2714:     */   public EvsStorageDoc findEvsStorageDoc(Long storageId)
/* 2715:     */   {
/* 2716:3113 */     EvsStorageDoc doc = null;
/* 2717:3114 */     List<EvsStorageDoc> list = new ArrayList();
/* 2718:3115 */     StringBuffer sb = new StringBuffer("from EvsStorageDoc ev where storageId=").append(storageId);
/* 2719:3116 */     list = super.getZormTemplate().find(sb.toString());
/* 2720:3117 */     if (list.size() > 0) {
/* 2721:3118 */       return (EvsStorageDoc)list.get(0);
/* 2722:     */     }
/* 2723:3120 */     return doc;
/* 2724:     */   }
/* 2725:     */   
/* 2726:     */   public EvsStorageDoc findEvsStorageDocByEvsStorageDoc(EvsStorageDoc evsStorageDoc)
/* 2727:     */   {
/* 2728:3123 */     EvsStorageDoc doc = null;
/* 2729:3124 */     List<EvsStorageDoc> list = new ArrayList();
/* 2730:3125 */     StringBuffer sb = new StringBuffer("from EvsStorageDoc ev where 1=1 ");
/* 2731:3126 */     if (evsStorageDoc != null)
/* 2732:     */     {
/* 2733:3127 */       if (!Util.isStrEmpty(evsStorageDoc.getStorageCode())) {
/* 2734:3128 */         sb.append(" and ev.storageCode='").append(evsStorageDoc.getStorageCode()).append("'");
/* 2735:     */       }
/* 2736:3130 */       if ((evsStorageDoc.getStorageId() != null) && (evsStorageDoc.getStorageId().longValue() > 0L)) {
/* 2737:3131 */         sb.append(" and ev.storageId=").append(evsStorageDoc.getStorageId());
/* 2738:     */       }
/* 2739:     */     }
/* 2740:3134 */     list = super.getZormTemplate().find(sb.toString());
/* 2741:3135 */     if (list.size() > 0) {
/* 2742:3136 */       return (EvsStorageDoc)list.get(0);
/* 2743:     */     }
/* 2744:3138 */     return doc;
/* 2745:     */   }
/* 2746:     */   
/* 2747:     */   public EvsBook getEvsBookById(Long bookid)
/* 2748:     */   {
/* 2749:3141 */     String hql = "from EvsBook where bookId=" + bookid;
/* 2750:3142 */     List<EvsBook> list = super.getZormTemplate().find(hql);
/* 2751:3143 */     if (list.size() > 0) {
/* 2752:3144 */       return (EvsBook)list.get(0);
/* 2753:     */     }
/* 2754:3146 */     return null;
/* 2755:     */   }
/* 2756:     */   
/* 2757:     */   public void updateEvsBook(EvsBook e)
/* 2758:     */   {
/* 2759:3154 */     e.setBookStatus("UNBOOK");
/* 2760:3155 */     update(e);
/* 2761:     */   }
/* 2762:     */   
/* 2763:     */   public EvsBook getBookByStatus()
/* 2764:     */   {
/* 2765:3163 */     EvsBook book = null;
/* 2766:3164 */     String hql = "from EvsBook b where b.bookStatus = 'UNBOOK'";
/* 2767:3165 */     List<EvsBook> list = super.getZormTemplate().find(hql);
/* 2768:3166 */     if (list.size() > 0) {
/* 2769:3167 */       book = (EvsBook)list.get(0);
/* 2770:     */     }
/* 2771:3169 */     return book;
/* 2772:     */   }
/* 2773:     */   
/* 2774:     */   public EvsBook getBookByStatusNew(String companyCode, String periodName)
/* 2775:     */   {
/* 2776:3180 */     EvsBook book = null;
/* 2777:3181 */     String hql = "from EvsBook b where b.bookStatus = 'UNBOOK' and companyCode = ? and periodName =? order by bookId";
/* 2778:3182 */     Query query = super.getSession().createQuery(hql);
/* 2779:3183 */     query.setString(0, companyCode);
/* 2780:3184 */     query.setString(1, periodName);
/* 2781:     */     
/* 2782:3186 */     List<EvsBook> list = query.list();
/* 2783:3187 */     if (list.size() > 0) {
/* 2784:3188 */       book = (EvsBook)list.get(0);
/* 2785:     */     }
/* 2786:3190 */     return book;
/* 2787:     */   }
/* 2788:     */   
/* 2789:     */   public EvsBook getBookByStatusNewYB(String companyCode, String periodName)
/* 2790:     */   {
/* 2791:3200 */     EvsBook book = null;
/* 2792:3201 */     String hql = "from EvsBook b where 1 = 1 and b.companyCode = ? and b.periodName =? order by b.bookId";
/* 2793:3202 */     Query query = super.getSession().createQuery(hql);
/* 2794:3203 */     query.setString(0, companyCode);
/* 2795:3204 */     query.setString(1, periodName);
/* 2796:     */     
/* 2797:3206 */     List<EvsBook> list = query.list();
/* 2798:3207 */     if (list.size() > 0) {
/* 2799:3208 */       book = (EvsBook)list.get(0);
/* 2800:     */     }
/* 2801:3210 */     return book;
/* 2802:     */   }
/* 2803:     */   
/* 2804:     */   public EvsBook getBookByStatus2(String s)
/* 2805:     */   {
/* 2806:3219 */     EvsBook book = null;
/* 2807:3220 */     String hql = "from EvsBook b where b.bookStatus = 'UNBOOK'";
/* 2808:3221 */     if ((s != null) && (!"".equals(s))) {
/* 2809:3222 */       hql = hql + " and b.bookCode not in(" + s + ")";
/* 2810:     */     }
/* 2811:3224 */     List<EvsBook> list = super.getZormTemplate().find(hql);
/* 2812:3225 */     if (list.size() > 0) {
/* 2813:3226 */       book = (EvsBook)list.get(0);
/* 2814:     */     }
/* 2815:3228 */     return book;
/* 2816:     */   }
/* 2817:     */   
/* 2818:     */   public List<EvsBookV> getEvsBookVByBookCodes(String bookCode)
/* 2819:     */   {
/* 2820:3236 */     String hql = "from EvsBookV e where 1=1 ";
/* 2821:3237 */     hql = hql + " and e.bookCode in (" + bookCode + ")";
/* 2822:3238 */     return getZormTemplate().find(hql);
/* 2823:     */   }
/* 2824:     */   
/* 2825:     */   public List<EvsBookV> getEvsBookVByBookCode(String bookCode)
/* 2826:     */   {
/* 2827:3246 */     String hql = "from EvsBookV e where 1=1 ";
/* 2828:3247 */     hql = hql + " and e.bookCode in (" + bookCode + ")";
/* 2829:3248 */     return getZormTemplate().find(hql);
/* 2830:     */   }
/* 2831:     */   
/* 2832:     */   public void deleteBookPackageVoucherByBookId(Long bookId, String[] voucherArr)
/* 2833:     */   {
/* 2834:3254 */     List<EvsVoucherBookPackage> list = queryBookPackageVoucherByBookId(voucherArr, bookId);
/* 2835:3255 */     List<Long> tempList = new ArrayList();
/* 2836:3256 */     String sql = "delete from EvsVoucherBookPackage e where 1=1";
/* 2837:3257 */     if ((bookId != null) && (!bookId.toString().equals(""))) {
/* 2838:3258 */       sql = sql + " and e.bookId<>" + bookId;
/* 2839:     */     }
/* 2840:3260 */     sql = sql + " and e.enabledFlag='T'";
/* 2841:3261 */     String voucherId = "";
/* 2842:3262 */     if (voucherArr.length > 0)
/* 2843:     */     {
/* 2844:3263 */       sql = sql + " and e.voucherId in (";
/* 2845:3264 */       for (int i = 0; i < voucherArr.length; i++) {
/* 2846:3265 */         if (i == voucherArr.length - 1) {
/* 2847:3266 */           sql = sql + voucherArr[i];
/* 2848:     */         } else {
/* 2849:3269 */           sql = sql + voucherArr[i] + ",";
/* 2850:     */         }
/* 2851:     */       }
/* 2852:3272 */       sql = sql + ")";
/* 2853:     */     }
/* 2854:3276 */     Query query = getSession().createQuery(sql);
/* 2855:3277 */     query.executeUpdate();
/* 2856:     */     
/* 2857:3279 */     EvsBook e = null;
/* 2858:3280 */     for (int i = 0; i < list.size(); i++)
/* 2859:     */     {
/* 2860:3281 */       if ((list.get(i) != null) && (((EvsVoucherBookPackage)list.get(i)).getBookId() != null)) {
/* 2861:3282 */         e = (EvsBook)getObject(EvsBook.class, ((EvsVoucherBookPackage)list.get(i)).getBookId());
/* 2862:     */       }
/* 2863:3284 */       if (e != null) {
/* 2864:3285 */         removeObject(e);
/* 2865:     */       }
/* 2866:     */     }
/* 2867:     */   }
/* 2868:     */   
/* 2869:     */   public List<EvsVoucherBookPackage> queryBookPackageVoucherByBookId(String[] voucherArr, Long bookId)
/* 2870:     */   {
/* 2871:3291 */     String sql = "from EvsVoucherBookPackage e where 1=1";
/* 2872:3292 */     sql = sql + " and e.enabledFlag='T'";
/* 2873:3293 */     if (voucherArr.length > 0)
/* 2874:     */     {
/* 2875:3294 */       sql = sql + " and e.voucherId in (";
/* 2876:3295 */       for (int i = 0; i < voucherArr.length; i++) {
/* 2877:3296 */         if (i == voucherArr.length - 1) {
/* 2878:3297 */           sql = sql + voucherArr[i];
/* 2879:     */         } else {
/* 2880:3300 */           sql = sql + voucherArr[i] + ",";
/* 2881:     */         }
/* 2882:     */       }
/* 2883:3303 */       sql = sql + ")";
/* 2884:     */     }
/* 2885:3305 */     sql = sql + " and e.bookId <> " + bookId;
/* 2886:3306 */     List<EvsVoucherBookPackage> list = getZormTemplate().find(sql);
/* 2887:3307 */     return list;
/* 2888:     */   }
/* 2889:     */   
/* 2890:     */   public EvsVoucherV findEvsVoucherVByJournalNum(String journalNum)
/* 2891:     */   {
/* 2892:3317 */     String hql = "FROM EvsVoucherV e where 1=1";
/* 2893:3318 */     if ((journalNum != null) && (!"".equals(journalNum))) {
/* 2894:3320 */       hql = hql + " and e.journalNum = '" + journalNum + "'";
/* 2895:     */     }
/* 2896:3322 */     List<EvsVoucherV> list = getZormTemplate().find(hql);
/* 2897:3323 */     if (list.size() > 0)
/* 2898:     */     {
/* 2899:3326 */       if (list.size() == 1) {
/* 2900:3327 */         return (EvsVoucherV)list.get(0);
/* 2901:     */       }
/* 2902:3329 */       return (EvsVoucherV)list.get(1);
/* 2903:     */     }
/* 2904:3333 */     return null;
/* 2905:     */   }
/* 2906:     */   
/* 2907:     */   public static void main(String[] args)
/* 2908:     */   {
/* 2909:3337 */     System.out.println("记10001".substring(1));
/* 2910:     */   }
/* 2911:     */ }


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.eBillManage.EvsBookDAO
 * JD-Core Version:    0.7.0.1
 */