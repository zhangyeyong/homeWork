/*   1:    */ package com.zte.eas.appframe.business.syscommon;
/*   2:    */ 
/*   3:    */ public class Base64
/*   4:    */ {
/*   5:  4 */   private static final byte[] encodingTable = {
/*   6:    */   
/*   7:  6 */     65, 66, 67, 68, 69, 
/*   8:    */     
/*   9:  8 */     70, 71, 72, 73, 74, 
/*  10:    */     
/*  11: 10 */     75, 76, 77, 78, 79, 
/*  12:    */     
/*  13: 12 */     80, 81, 82, 83, 84, 
/*  14:    */     
/*  15: 14 */     85, 86, 87, 88, 89, 
/*  16:    */     
/*  17: 16 */     90, 97, 98, 99, 100, 
/*  18:    */     
/*  19: 18 */     101, 102, 103, 104, 105, 
/*  20:    */     
/*  21: 20 */     106, 107, 108, 109, 110, 
/*  22:    */     
/*  23: 22 */     111, 112, 113, 114, 115, 
/*  24:    */     
/*  25: 24 */     116, 117, 118, 119, 120, 
/*  26:    */     
/*  27: 26 */     121, 122, 48, 49, 50, 
/*  28:    */     
/*  29: 28 */     51, 52, 53, 54, 55, 
/*  30:    */     
/*  31: 30 */     56, 57, 43, 47 };
/*  32: 38 */   private static final byte[] decodingTable = new byte[''];
/*  33:    */   
/*  34:    */   static
/*  35:    */   {
/*  36: 40 */     for (int i = 0; i < 128; i++) {
/*  37: 42 */       decodingTable[i] = -1;
/*  38:    */     }
/*  39: 46 */     for (int i = 65; i <= 90; i++) {
/*  40: 48 */       decodingTable[i] = ((byte)(i - 65));
/*  41:    */     }
/*  42: 52 */     for (int i = 97; i <= 122; i++) {
/*  43: 54 */       decodingTable[i] = ((byte)(i - 97 + 26));
/*  44:    */     }
/*  45: 58 */     for (int i = 48; i <= 57; i++) {
/*  46: 60 */       decodingTable[i] = ((byte)(i - 48 + 52));
/*  47:    */     }
/*  48: 64 */     decodingTable[43] = 62;
/*  49:    */     
/*  50: 66 */     decodingTable[47] = 63;
/*  51:    */   }
/*  52:    */   
/*  53:    */   public static byte[] encode(byte[] data, int offset)
/*  54:    */   {
/*  55: 74 */     int realCount = data.length - offset;
/*  56:    */     
/*  57: 76 */     int modulus = realCount % 3;
/*  58:    */     byte[] bytes;
/*  59:    */     byte[] bytes;
/*  60: 78 */     if (modulus == 0) {
/*  61: 80 */       bytes = new byte[4 * realCount / 3];
/*  62:    */     } else {
/*  63: 84 */       bytes = new byte[4 * (realCount / 3 + 1)];
/*  64:    */     }
/*  65: 88 */     int dataLength = data.length - modulus;
/*  66:    */     
/*  67:    */ 
/*  68:    */ 
/*  69:    */ 
/*  70:    */ 
/*  71:    */ 
/*  72:    */ 
/*  73: 96 */     int i = offset;
/*  74: 96 */     for (int j = 0; i < dataLength; j += 4)
/*  75:    */     {
/*  76: 98 */       int a1 = data[i] & 0xFF;
/*  77:    */       
/*  78:100 */       int a2 = data[(i + 1)] & 0xFF;
/*  79:    */       
/*  80:102 */       int a3 = data[(i + 2)] & 0xFF;
/*  81:    */       
/*  82:104 */       bytes[j] = encodingTable[(a1 >>> 2 & 0x3F)];
/*  83:    */       
/*  84:106 */       bytes[(j + 1)] = encodingTable[((a1 << 4 | a2 >>> 4) & 0x3F)];
/*  85:    */       
/*  86:108 */       bytes[(j + 2)] = encodingTable[((a2 << 2 | a3 >>> 6) & 0x3F)];
/*  87:    */       
/*  88:110 */       bytes[(j + 3)] = encodingTable[(a3 & 0x3F)];i += 3;
/*  89:    */     }
/*  90:124 */     switch (modulus)
/*  91:    */     {
/*  92:    */     case 0: 
/*  93:    */       break;
/*  94:    */     case 1: 
/*  95:132 */       int d1 = data[(data.length - 1)] & 0xFF;
/*  96:    */       
/*  97:134 */       int b1 = d1 >>> 2 & 0x3F;
/*  98:    */       
/*  99:136 */       int b2 = d1 << 4 & 0x3F;
/* 100:    */       
/* 101:138 */       bytes[(bytes.length - 4)] = encodingTable[b1];
/* 102:    */       
/* 103:140 */       bytes[(bytes.length - 3)] = encodingTable[b2];
/* 104:    */       
/* 105:142 */       bytes[(bytes.length - 2)] = 61;
/* 106:    */       
/* 107:144 */       bytes[(bytes.length - 1)] = 61;
/* 108:    */       
/* 109:146 */       break;
/* 110:    */     case 2: 
/* 111:150 */       int d1 = data[(data.length - 2)] & 0xFF;
/* 112:    */       
/* 113:152 */       int d2 = data[(data.length - 1)] & 0xFF;
/* 114:    */       
/* 115:154 */       int b1 = d1 >>> 2 & 0x3F;
/* 116:    */       
/* 117:156 */       int b2 = (d1 << 4 | d2 >>> 4) & 0x3F;
/* 118:    */       
/* 119:158 */       int b3 = d2 << 2 & 0x3F;
/* 120:    */       
/* 121:160 */       bytes[(bytes.length - 4)] = encodingTable[b1];
/* 122:    */       
/* 123:162 */       bytes[(bytes.length - 3)] = encodingTable[b2];
/* 124:    */       
/* 125:164 */       bytes[(bytes.length - 2)] = encodingTable[b3];
/* 126:    */       
/* 127:166 */       bytes[(bytes.length - 1)] = 61;
/* 128:    */     }
/* 129:172 */     return bytes;
/* 130:    */   }
/* 131:    */   
/* 132:    */   public static byte[] decode(byte[] data)
/* 133:    */   {
/* 134:188 */     data = discardNonBase64Bytes(data);
/* 135:    */     byte[] bytes;
/* 136:    */     byte[] bytes;
/* 137:190 */     if (data[(data.length - 2)] == 61)
/* 138:    */     {
/* 139:192 */       bytes = new byte[(data.length / 4 - 1) * 3 + 1];
/* 140:    */     }
/* 141:    */     else
/* 142:    */     {
/* 143:    */       byte[] bytes;
/* 144:194 */       if (data[(data.length - 1)] == 61) {
/* 145:196 */         bytes = new byte[(data.length / 4 - 1) * 3 + 2];
/* 146:    */       } else {
/* 147:200 */         bytes = new byte[data.length / 4 * 3];
/* 148:    */       }
/* 149:    */     }
/* 150:204 */     int i = 0;
/* 151:204 */     for (int j = 0; i < data.length - 4; j += 3)
/* 152:    */     {
/* 153:206 */       byte b1 = decodingTable[data[i]];
/* 154:    */       
/* 155:208 */       byte b2 = decodingTable[data[(i + 1)]];
/* 156:    */       
/* 157:210 */       byte b3 = decodingTable[data[(i + 2)]];
/* 158:    */       
/* 159:212 */       byte b4 = decodingTable[data[(i + 3)]];
/* 160:    */       
/* 161:214 */       bytes[j] = ((byte)(b1 << 2 | b2 >> 4));
/* 162:    */       
/* 163:216 */       bytes[(j + 1)] = ((byte)(b2 << 4 | b3 >> 2));
/* 164:    */       
/* 165:218 */       bytes[(j + 2)] = ((byte)(b3 << 6 | b4));i += 4;
/* 166:    */     }
/* 167:222 */     if (data[(data.length - 2)] == 61)
/* 168:    */     {
/* 169:224 */       byte b1 = decodingTable[data[(data.length - 4)]];
/* 170:    */       
/* 171:226 */       byte b2 = decodingTable[data[(data.length - 3)]];
/* 172:    */       
/* 173:228 */       bytes[(bytes.length - 1)] = ((byte)(b1 << 2 | b2 >> 4));
/* 174:    */     }
/* 175:230 */     else if (data[(data.length - 1)] == 61)
/* 176:    */     {
/* 177:232 */       byte b1 = decodingTable[data[(data.length - 4)]];
/* 178:    */       
/* 179:234 */       byte b2 = decodingTable[data[(data.length - 3)]];
/* 180:    */       
/* 181:236 */       byte b3 = decodingTable[data[(data.length - 2)]];
/* 182:    */       
/* 183:238 */       bytes[(bytes.length - 2)] = ((byte)(b1 << 2 | b2 >> 4));
/* 184:    */       
/* 185:240 */       bytes[(bytes.length - 1)] = ((byte)(b2 << 4 | b3 >> 2));
/* 186:    */     }
/* 187:    */     else
/* 188:    */     {
/* 189:244 */       byte b1 = decodingTable[data[(data.length - 4)]];
/* 190:    */       
/* 191:246 */       byte b2 = decodingTable[data[(data.length - 3)]];
/* 192:    */       
/* 193:248 */       byte b3 = decodingTable[data[(data.length - 2)]];
/* 194:    */       
/* 195:250 */       byte b4 = decodingTable[data[(data.length - 1)]];
/* 196:    */       
/* 197:252 */       bytes[(bytes.length - 3)] = ((byte)(b1 << 2 | b2 >> 4));
/* 198:    */       
/* 199:254 */       bytes[(bytes.length - 2)] = ((byte)(b2 << 4 | b3 >> 2));
/* 200:    */       
/* 201:256 */       bytes[(bytes.length - 1)] = ((byte)(b3 << 6 | b4));
/* 202:    */     }
/* 203:260 */     return bytes;
/* 204:    */   }
/* 205:    */   
/* 206:    */   public static byte[] decode(String data)
/* 207:    */   {
/* 208:276 */     data = discardNonBase64Chars(data);
/* 209:    */     byte[] bytes;
/* 210:    */     byte[] bytes;
/* 211:278 */     if (data.charAt(data.length() - 2) == '=')
/* 212:    */     {
/* 213:280 */       bytes = new byte[(data.length() / 4 - 1) * 3 + 1];
/* 214:    */     }
/* 215:    */     else
/* 216:    */     {
/* 217:    */       byte[] bytes;
/* 218:282 */       if (data.charAt(data.length() - 1) == '=') {
/* 219:284 */         bytes = new byte[(data.length() / 4 - 1) * 3 + 2];
/* 220:    */       } else {
/* 221:288 */         bytes = new byte[data.length() / 4 * 3];
/* 222:    */       }
/* 223:    */     }
/* 224:292 */     int i = 0;
/* 225:292 */     for (int j = 0; i < data.length() - 4; j += 3)
/* 226:    */     {
/* 227:294 */       byte b1 = decodingTable[data.charAt(i)];
/* 228:    */       
/* 229:296 */       byte b2 = decodingTable[data.charAt(i + 1)];
/* 230:    */       
/* 231:298 */       byte b3 = decodingTable[data.charAt(i + 2)];
/* 232:    */       
/* 233:300 */       byte b4 = decodingTable[data.charAt(i + 3)];
/* 234:    */       
/* 235:302 */       bytes[j] = ((byte)(b1 << 2 | b2 >> 4));
/* 236:    */       
/* 237:304 */       bytes[(j + 1)] = ((byte)(b2 << 4 | b3 >> 2));
/* 238:    */       
/* 239:306 */       bytes[(j + 2)] = ((byte)(b3 << 6 | b4));i += 4;
/* 240:    */     }
/* 241:310 */     if (data.charAt(data.length() - 2) == '=')
/* 242:    */     {
/* 243:312 */       byte b1 = decodingTable[data.charAt(data.length() - 4)];
/* 244:    */       
/* 245:314 */       byte b2 = decodingTable[data.charAt(data.length() - 3)];
/* 246:    */       
/* 247:316 */       bytes[(bytes.length - 1)] = ((byte)(b1 << 2 | b2 >> 4));
/* 248:    */     }
/* 249:318 */     else if (data.charAt(data.length() - 1) == '=')
/* 250:    */     {
/* 251:320 */       byte b1 = decodingTable[data.charAt(data.length() - 4)];
/* 252:    */       
/* 253:322 */       byte b2 = decodingTable[data.charAt(data.length() - 3)];
/* 254:    */       
/* 255:324 */       byte b3 = decodingTable[data.charAt(data.length() - 2)];
/* 256:    */       
/* 257:326 */       bytes[(bytes.length - 2)] = ((byte)(b1 << 2 | b2 >> 4));
/* 258:    */       
/* 259:328 */       bytes[(bytes.length - 1)] = ((byte)(b2 << 4 | b3 >> 2));
/* 260:    */     }
/* 261:    */     else
/* 262:    */     {
/* 263:332 */       byte b1 = decodingTable[data.charAt(data.length() - 4)];
/* 264:    */       
/* 265:334 */       byte b2 = decodingTable[data.charAt(data.length() - 3)];
/* 266:    */       
/* 267:336 */       byte b3 = decodingTable[data.charAt(data.length() - 2)];
/* 268:    */       
/* 269:338 */       byte b4 = decodingTable[data.charAt(data.length() - 1)];
/* 270:    */       
/* 271:340 */       bytes[(bytes.length - 3)] = ((byte)(b1 << 2 | b2 >> 4));
/* 272:    */       
/* 273:342 */       bytes[(bytes.length - 2)] = ((byte)(b2 << 4 | b3 >> 2));
/* 274:    */       
/* 275:344 */       bytes[(bytes.length - 1)] = ((byte)(b3 << 6 | b4));
/* 276:    */     }
/* 277:347 */     return bytes;
/* 278:    */   }
/* 279:    */   
/* 280:    */   private static byte[] discardNonBase64Bytes(byte[] data)
/* 281:    */   {
/* 282:352 */     byte[] temp = new byte[data.length];
/* 283:    */     
/* 284:354 */     int bytesCopied = 0;
/* 285:356 */     for (int i = 0; i < data.length; i++) {
/* 286:358 */       if (isValidBase64Byte(data[i])) {
/* 287:360 */         temp[(bytesCopied++)] = data[i];
/* 288:    */       }
/* 289:    */     }
/* 290:366 */     byte[] newData = new byte[bytesCopied];
/* 291:    */     
/* 292:368 */     System.arraycopy(temp, 0, newData, 0, bytesCopied);
/* 293:    */     
/* 294:370 */     return newData;
/* 295:    */   }
/* 296:    */   
/* 297:    */   private static String discardNonBase64Chars(String data)
/* 298:    */   {
/* 299:376 */     StringBuffer sb = new StringBuffer();
/* 300:    */     
/* 301:378 */     int length = data.length();
/* 302:380 */     for (int i = 0; i < length; i++) {
/* 303:382 */       if (isValidBase64Byte((byte)data.charAt(i))) {
/* 304:384 */         sb.append(data.charAt(i));
/* 305:    */       }
/* 306:    */     }
/* 307:390 */     return sb.toString();
/* 308:    */   }
/* 309:    */   
/* 310:    */   private static boolean isValidBase64Byte(byte b)
/* 311:    */   {
/* 312:396 */     if (b == 61) {
/* 313:398 */       return true;
/* 314:    */     }
/* 315:400 */     if ((b < 0) || (b >= 128)) {
/* 316:402 */       return false;
/* 317:    */     }
/* 318:404 */     if (decodingTable[b] == -1) {
/* 319:406 */       return false;
/* 320:    */     }
/* 321:410 */     return true;
/* 322:    */   }
/* 323:    */   
/* 324:    */   public static String encode(String data, String charset)
/* 325:    */     throws Exception
/* 326:    */   {
/* 327:420 */     if ((data == null) || (data.length() == 0)) {
/* 328:421 */       return data;
/* 329:    */     }
/* 330:424 */     int offset = 0;
/* 331:    */     
/* 332:    */ 
/* 333:    */ 
/* 334:428 */     byte[] result = encode(data.getBytes(charset), offset);
/* 335:    */     
/* 336:430 */     StringBuffer sb = new StringBuffer(result.length);
/* 337:432 */     for (int i = 0; i < result.length; i++) {
/* 338:433 */       sb.append((char)result[i]);
/* 339:    */     }
/* 340:436 */     return sb.toString();
/* 341:    */   }
/* 342:    */   
/* 343:    */   public static String decode(String data, String charset)
/* 344:    */     throws Exception
/* 345:    */   {
/* 346:444 */     if ((data == null) || (data.length() == 0)) {
/* 347:445 */       return data;
/* 348:    */     }
/* 349:448 */     return new String(decode(data), charset);
/* 350:    */   }
/* 351:    */ }


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.business.syscommon.Base64
 * JD-Core Version:    0.7.0.1
 */