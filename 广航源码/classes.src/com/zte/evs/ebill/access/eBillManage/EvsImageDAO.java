/*   1:    */ package com.zte.evs.ebill.access.eBillManage;
/*   2:    */ 
/*   3:    */ import com.zte.evs.ebill.common.invoice.util.StringUtils;
/*   4:    */ import com.zte.evs.ebill.model.eBillManage.EvsImage;
/*   5:    */ import com.zte.evs.ebill.model.eBillManage.EvsVoucher;
/*   6:    */ import com.zte.ssb.framework.base.BaseDAO;
/*   7:    */ import com.zte.ssb.zorm.Query;
/*   8:    */ import com.zte.ssb.zorm.SQLQuery;
/*   9:    */ import com.zte.ssb.zorm.Session;
/*  10:    */ import java.io.PrintStream;
/*  11:    */ import java.sql.Connection;
/*  12:    */ import java.text.DecimalFormat;
/*  13:    */ import java.text.SimpleDateFormat;
/*  14:    */ import java.util.ArrayList;
/*  15:    */ import java.util.Date;
/*  16:    */ import java.util.HashMap;
/*  17:    */ import java.util.List;
/*  18:    */ import java.util.Map;
/*  19:    */ 
/*  20:    */ public class EvsImageDAO
/*  21:    */   extends BaseDAO
/*  22:    */   implements IEvsImageDAO
/*  23:    */ {
/*  24:    */   public void saveImage(EvsImage evsImage)
/*  25:    */   {
/*  26: 46 */     getSession().save(evsImage);
/*  27:    */   }
/*  28:    */   
/*  29:    */   public void updateImage(EvsImage evsImage)
/*  30:    */   {
/*  31: 56 */     getSession().update(evsImage);
/*  32:    */   }
/*  33:    */   
/*  34:    */   public EvsImage findImageByImageUrl(String imageUrl, Long voucherId)
/*  35:    */   {
/*  36: 70 */     List<EvsImage> list = getSession().createQuery(
/*  37: 71 */       "from EvsImage m where m.voucherId =" + voucherId + 
/*  38: 72 */       " and m.imageUrl='" + imageUrl + "'").list();
/*  39: 73 */     if ((list != null) && (list.size() > 0)) {
/*  40: 74 */       return (EvsImage)list.get(0);
/*  41:    */     }
/*  42: 76 */     return new EvsImage();
/*  43:    */   }
/*  44:    */   
/*  45:    */   public void deleteImageById(Long voucherId)
/*  46:    */   {
/*  47: 81 */     String sql = "delete from EvsImage t where t.voucherId=? and t.barcode is null";
/*  48: 82 */     Query query = super.getSession().createQuery(sql);
/*  49: 83 */     query.setLong(0, voucherId.longValue());
/*  50: 84 */     query.executeUpdate();
/*  51:    */   }
/*  52:    */   
/*  53:    */   public int updateVideoAbate(Long imageInfoId)
/*  54:    */   {
/*  55: 94 */     int returnNum = 1;
/*  56: 95 */     String sql = "select * from evs.evs_image i where i.voucher_id is not null and i.image_info_id= ?";
/*  57: 96 */     List<EvsImage> liste = getSession().createSQLQuery(sql).setLong(0, imageInfoId.longValue()).list();
/*  58: 97 */     if (liste.size() == 0)
/*  59:    */     {
/*  60: 98 */       String sql2 = "update  eid.eid_image_infos i set i.enabled_flag='N' where i.image_info_id = ?";
/*  61: 99 */       returnNum = getSession().createSQLQuery(sql2).setLong(0, imageInfoId.longValue()).executeUpdate();
/*  62:100 */       String sql3 = "delete from evs.evs_image i where i.image_info_id = ?";
/*  63:101 */       getSession().createSQLQuery(sql3).setLong(0, imageInfoId.longValue()).executeUpdate();
/*  64:102 */       return returnNum;
/*  65:    */     }
/*  66:104 */     returnNum = 0;
/*  67:105 */     return returnNum;
/*  68:    */   }
/*  69:    */   
/*  70:    */   public Connection getConnection()
/*  71:    */   {
/*  72:110 */     return super.getSession().connection();
/*  73:    */   }
/*  74:    */   
/*  75:    */   public void updateImageInfo(EvsVoucher evsVoucher, List<EvsImage> list)
/*  76:    */   {
/*  77:113 */     String sql = "UPDATE evs_voucher t SET t.update_status=?,t.last_update_date=SYSDATE WHERE t.voucher_id=?";
/*  78:114 */     Query query = super.getSession().createSQLQuery(sql);
/*  79:115 */     query.setString(0, evsVoucher.getUpdateStatus());
/*  80:116 */     query.setLong(1, evsVoucher.getVoucherId().longValue());
/*  81:117 */     query.executeUpdate();
/*  82:118 */     if (!list.isEmpty())
/*  83:    */     {
/*  84:119 */       sql = "delete from Evs_Image t where t.voucher_Id=? and t.barcode is null";
/*  85:120 */       query = super.getSession().createSQLQuery(sql);
/*  86:121 */       query.setLong(0, evsVoucher.getVoucherId().longValue());
/*  87:122 */       query.executeUpdate();
/*  88:123 */       super.insertObjects(list);
/*  89:    */     }
/*  90:    */   }
/*  91:    */   
/*  92:126 */   private static final SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
/*  93:127 */   private static final DecimalFormat numberFormat = new DecimalFormat("#,##0.00");
/*  94:    */   
/*  95:    */   public List<Map<String, Object>> getVoucherCorverInfo(int num)
/*  96:    */   {
/*  97:129 */     StringBuilder sql = new StringBuilder();
/*  98:130 */     List<Map<String, Object>> list = new ArrayList();
/*  99:131 */     sql.append("SELECT v.voucher_id,C.COMPANY_NAME,V.JOURNAL_DATE,V.BILL_NUM,");
/* 100:132 */     sql.append("(SELECT NVL(SUM(L.ACC_DR), 0) FROM EVS_VOUCHER_LINE L WHERE L.VOUCHER_ID = V.VOUCHER_ID) DR_TOTAL,");
/* 101:133 */     sql.append("(SELECT NVL(SUM(L.ACC_CR), 0) FROM EVS_VOUCHER_LINE L WHERE L.VOUCHER_ID = V.VOUCHER_ID) CR_TOTAL,");
/* 102:134 */     sql.append("V.FINANCE_EXECUTIVE,V.Cashier,V.APPROVER,V.USER_NAME");
/* 103:135 */     sql.append(" FROM EVS_VOUCHER V,");
/* 104:136 */     sql.append(" (SELECT C.COMPANY_CODE, CL.COMPANY_NAME FROM FBP_COMPANY C, FBP_COMPANY_TL CL WHERE C.COMPANY_ID = CL.COMPANY_ID AND CL.LANGUAGE = ZAS_ENV_PKG.GETLANG) C");
/* 105:137 */     sql.append(" WHERE V.COMPANY_CODE = C.COMPANY_CODE(+)");
/* 106:138 */     sql.append(" AND V.UPDATE_STATUS = '0'");
/* 107:139 */     sql.append(" AND EXISTS (SELECT 1 FROM EVS_VOUCHER_LINE L WHERE L.VOUCHER_ID = V.VOUCHER_ID)");
/* 108:140 */     sql.append(" AND ROWNUM<=?");
/* 109:141 */     SQLQuery query = super.getSession().createSQLQuery(sql.toString());
/* 110:142 */     query.setInteger(0, num);
/* 111:143 */     List<Object[]> objectList = query.list();
/* 112:144 */     for (Object[] objs : objectList)
/* 113:    */     {
/* 114:145 */       Map<String, Object> map = new HashMap();
/* 115:146 */       map.put("VOUCHER_ID", Long.valueOf(objs[0]));
/* 116:147 */       map.put("companyName", objs[1]);
/* 117:148 */       map.put("journalDate", df.format(objs[2] == null ? new Date() : (Date)objs[2]));
/* 118:149 */       map.put("billNum", objs[3]);
/* 119:150 */       map.put("totalStr", StringUtils.numberToChinese(new Double(objs[4]).doubleValue()));
/* 120:151 */       map.put("drTotal", numberFormat.format(new Double(objs[4])));
/* 121:152 */       map.put("crTotal", numberFormat.format(new Double(objs[5])));
/* 122:153 */       map.put("financeExecutive", objs[6]);
/* 123:154 */       map.put("cashier", objs[7]);
/* 124:155 */       map.put("approver", objs[8]);
/* 125:156 */       map.put("userName", objs[9]);
/* 126:    */       
/* 127:158 */       list.add(map);
/* 128:    */     }
/* 129:161 */     return list;
/* 130:    */   }
/* 131:    */   
/* 132:    */   public Map<String, Object> getMap(Long voucherId)
/* 133:    */   {
/* 134:164 */     StringBuilder sql = new StringBuilder();
/* 135:165 */     List<Map<String, Object>> list = new ArrayList();
/* 136:166 */     sql.append("SELECT v.voucher_id,C.COMPANY_NAME,V.JOURNAL_DATE,V.BILL_NUM,");
/* 137:167 */     sql.append("(SELECT NVL(SUM(L.ACC_DR), 0) FROM EVS_VOUCHER_LINE L WHERE L.VOUCHER_ID = V.VOUCHER_ID) DR_TOTAL,");
/* 138:168 */     sql.append("(SELECT NVL(SUM(L.ACC_CR), 0) FROM EVS_VOUCHER_LINE L WHERE L.VOUCHER_ID = V.VOUCHER_ID) CR_TOTAL,");
/* 139:169 */     sql.append("V.FINANCE_EXECUTIVE,V.Cashier,V.APPROVER,V.USER_NAME");
/* 140:170 */     sql.append(" FROM EVS_VOUCHER V,");
/* 141:171 */     sql.append(" (SELECT C.COMPANY_CODE, CL.COMPANY_NAME FROM FBP_COMPANY C, FBP_COMPANY_TL CL WHERE C.COMPANY_ID = CL.COMPANY_ID AND CL.LANGUAGE = ZAS_ENV_PKG.GETLANG) C");
/* 142:172 */     sql.append(" WHERE V.COMPANY_CODE = C.COMPANY_CODE(+)");
/* 143:    */     
/* 144:174 */     sql.append(" AND EXISTS (SELECT 1 FROM EVS_VOUCHER_LINE L WHERE L.VOUCHER_ID = V.VOUCHER_ID)");
/* 145:175 */     sql.append(" AND voucher_id=?");
/* 146:176 */     SQLQuery query = super.getSession().createSQLQuery(sql.toString());
/* 147:177 */     query.setLong(0, voucherId.longValue());
/* 148:178 */     List<Object[]> objectList = query.list();
/* 149:179 */     for (Object[] objs : objectList)
/* 150:    */     {
/* 151:180 */       Map<String, Object> map = new HashMap();
/* 152:181 */       map.put("VOUCHER_ID", Long.valueOf(objs[0]));
/* 153:182 */       map.put("companyName", objs[1]);
/* 154:183 */       map.put("journalDate", df.format(objs[2] == null ? new Date() : (Date)objs[2]));
/* 155:184 */       map.put("billNum", objs[3]);
/* 156:185 */       map.put("totalStr", StringUtils.numberToChinese(new Double(objs[4]).doubleValue()));
/* 157:186 */       map.put("drTotal", numberFormat.format(new Double(objs[4])));
/* 158:187 */       map.put("crTotal", numberFormat.format(new Double(objs[5])));
/* 159:188 */       map.put("financeExecutive", objs[6]);
/* 160:189 */       map.put("cashier", objs[7]);
/* 161:190 */       map.put("approver", objs[8]);
/* 162:191 */       map.put("userName", objs[9]);
/* 163:    */       
/* 164:193 */       list.add(map);
/* 165:    */     }
/* 166:196 */     return (Map)list.get(0);
/* 167:    */   }
/* 168:    */   
/* 169:    */   public static void main(String[] args)
/* 170:    */   {
/* 171:199 */     System.out.println("dfdf");
/* 172:    */   }
/* 173:    */ }


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.eBillManage.EvsImageDAO
 * JD-Core Version:    0.7.0.1
 */