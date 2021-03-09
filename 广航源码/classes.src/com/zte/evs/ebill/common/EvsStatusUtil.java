package com.zte.evs.ebill.common;

import com.zte.ssb.ssbext.resource.ComResUtil;

public class EvsStatusUtil
{
  public static final String NOT_CHECKED = "NOT_CHECKED";
  public static final String HAS_CHECKED = "CHECKED";
  public static final String MANUAL = "手动匹配";
  public static final String UNMATCH = "UNMATCH";
  public static final String MATCHED = "MATCHED";
  public static final String SUBMITED = "SUBMITED";
  public static final String CHECKED = "CHECKED";
  public static final String BACKED = "BACKED";
  public static final String BOOKED = "BOOKED";
  public static final String UNBOOK = "UNBOOK";
  public static final String PACKAGED = "PACKAGED";
  public static final String PACKAGED_NO_INCOME = "PACKAGED_NO_INCOME";
  public static final String UNPACKAG = "UNPACKAG";
  public static final String NOT_PACKAGED = "NOT_PACKAGED";
  public static final String BOOKED_NO_BOX = "BOOKED_NO_BOX";
  public static final String UNWAREHOUSE = "UNWAREHOUSE";
  public static final String WAREHOUSE = "WAREHOUSE";
  public static final String CHECKED_NO_BOOKED = "CHECKED_NO_BOOKED";
  public static final String UPDATEVOUCHER = "UPDATEVOUCHER";
  public static final String INSERTVOUCHER = "INSERTVOUCHER";
  public static final String MATCH = "MATCH";
  public static final String SUBMIT = "SUBMIT";
  public static final String CHECK = "CHECK";
  public static final String BACK = "BACK";
  public static final String PACKAG = "PACKAG";
  public static final String UNPACK = "UNPACK";
  public static final String STATUS_ENABLED_CODE_YES = "Y";
  public static final String STATUS_ENABLED_CODE_NO = "N";
  public static final String STATUS_ENABLED_VALUE_YES = "启用";
  public static final String STATUS_ENABLED_VALUE_NO = "禁用";
  public static final String NOBARCODE = "无影像附件";
  public static final String BOOK_BREAK_FLAG_YES = "Y";
  public static final String BOOK_BREAK_FLAG_NO = "N";
  public static final String SELECTED_STATUS = "change";
  public static final String VOUCHER_END_FLAG_YES = "1";
  public static final String VOUCHER_END_FLAG_NO = "0";
  public static final String ALREADY_RECEIVE = "ALREADY_RECEIVE";
  public static final String NOT_RECEIVE = "NOT_RECEIVE";
  public static final String ALREADY_FLITTING = "ALREADY_FLITTING";
  public static final String NOW_FLITTING = "NOW_FLITTING";
  public static final String REMOVE_FLITTING = "REMOVE_FLITTING";
  public static final String ALREADY_RETURN = "ALREADY_RETURN";
  public static final String BORROWING = "BORROWING";
  public static final String FLITTING_FOR_BOX = "FLITTING_FOR_BOX";
  public static final String FLITTING_FOR_BOOKLET = "FLITTING_FOR_BOOK";
  public static final String FLITTING_FOR_VOUCHER = "FLITTING_FOR_VOUCHER";
  public static final String ALLOT_WAY = "ALLOTWAY";
  public static final String ALLOT = "ALLOT";
  public static final String INCEPT = "INCEPT";
  public static final String UNTREAD = "UNTREAD";
  public static final String FLITTING = "FLITTING";
  public static final String RECEIVE = "RECEIVE";
  public static final String REJECT = "REJECT";
  public static final String INCEPT_STR = "接收";
  public static final String REMOVE_STR = "撤销";
  public static final String FLITTING_STR = "调拨";
  public static final String RECEIVE_STR = "接收";
  public static final String REJECT_STR = "退回";
  public static final String MUST_IS_NULL = "MUST_IS_NULL";
  public static final String MUST_NOT_NULL = "MUST_NOT_NULL";
  public static final String MAX = "MAX";
  public static final String MIN = "MIN";
  public static final String HIS_BOOLED = "HIS_BOOLED";
  public static final String NOT_DATA = "NOT_DATA";
  public static final String ARCHIVE_NUMBER = "ARCHIVE_NUMBER";
  public static final String ARCHIVES_WAIT_REVERT = "ARCHIVES_WAIT_REVERT";
  public static final String ARCHIVES_ALREADY_REVERT = "ARCHIVES_ALREADY_REVERT";
  
  public static String getBarcode(String paramString1, String paramString2)
  {
    if ("UNMATCH".equals(paramString1)) {
      return "";
    }
    return ComResUtil.getMessage("vocher.check.msg1");
  }
  
  public static String getbookBreakFlag(String paramString)
  {
    if ("Y".equals(paramString)) {
      return ComResUtil.getMessage("vocher.check.yes");
    }
    if ("N".equals(paramString)) {
      return ComResUtil.getMessage("vocher.check.no");
    }
    return ComResUtil.getMessage("vocher.check.no");
  }
  
  public static String getVoucherStatusName(String paramString)
  {
    if ("MATCHED".equals(paramString)) {
      return ComResUtil.getMessage("vocher.check.matched");
    }
    if ("UNMATCH".equals(paramString)) {
      return ComResUtil.getMessage("vocher.check.unmatch");
    }
    if ("SUBMITED".equals(paramString)) {
      return ComResUtil.getMessage("vocher.check.submited");
    }
    if ("CHECKED".equals(paramString)) {
      return ComResUtil.getMessage("vocher.check.checked");
    }
    if ("BACKED".equals(paramString)) {
      return ComResUtil.getMessage("vocher.check.backed");
    }
    if ("BOOKED".equals(paramString)) {
      return ComResUtil.getMessage("vocher.check.booked");
    }
    if ("UNBOOK".equals(paramString)) {
      return ComResUtil.getMessage("vocher.check.unbook");
    }
    if ("PACKAGED".equals(paramString)) {
      return ComResUtil.getMessage("vocher.check.packaged");
    }
    if ("UNPACKAG".equals(paramString)) {
      return ComResUtil.getMessage("vocher.check.unpackag");
    }
    if ("ALREADY_RECEIVE".equals(paramString)) {
      return ComResUtil.getMessage("vocher.check.already_receive");
    }
    if ("NOT_RECEIVE".equals(paramString)) {
      return ComResUtil.getMessage("vocher.check.not_receive");
    }
    if ("ALREADY_FLITTING".equals(paramString)) {
      return ComResUtil.getMessage("vocher.check.already_flitting");
    }
    if ("NOW_FLITTING".equals(paramString)) {
      return ComResUtil.getMessage("vocher.check.now_flitting");
    }
    if ("BOOKED_NO_BOX".equals(paramString)) {
      return ComResUtil.getMessage("vocher.check.booked_no_box");
    }
    if ("WAREHOUSE".equals(paramString)) {
      return ComResUtil.getMessage("vocher.check.warehouse");
    }
    if ("BORROWING".equals(paramString)) {
      return ComResUtil.getMessage("vocher.check.borrowing");
    }
    if ("PACKAGED_NO_INCOME".equals(paramString)) {
      return ComResUtil.getMessage("vocher.check.packaged_no_income");
    }
    if ("NOT_PACKAGED".equals(paramString)) {
      return ComResUtil.getMessage("vocher.check.not_packaged");
    }
    if ("CHECKED_NO_BOOKED".equals(paramString)) {
      return ComResUtil.getMessage("vocher.check.checked_no_booked");
    }
    if ("REMOVE_FLITTING".equals(paramString)) {
      return ComResUtil.getMessage("vocher.check.remove_flitting");
    }
    if ("ALREADY_RETURN".equals(paramString)) {
      return ComResUtil.getMessage("vocher.check.backed");
    }
    return ComResUtil.getMessage("vocher.check.rests");
  }
  
  public static String getOperName(String paramString)
  {
    if (paramString.equals("MATCH")) {
      return ComResUtil.getMessage("vocher.check.match");
    }
    if (paramString.equals("BOOKED")) {
      return ComResUtil.getMessage("vocher.check.bookeds");
    }
    if (paramString.equals("UNBOOK")) {
      return ComResUtil.getMessage("vocher.check.unbooks");
    }
    if (paramString.equals("UPDATEVOUCHER")) {
      return ComResUtil.getMessage("vocher.check.updatevoucher");
    }
    if (paramString.equals("INSERTVOUCHER")) {
      return ComResUtil.getMessage("vocher.check.insertvoucher");
    }
    if ("SUBMIT".equals(paramString)) {
      return ComResUtil.getMessage("vocher.check.submit");
    }
    if (paramString.equals("CHECK")) {
      return ComResUtil.getMessage("vocher.check.check");
    }
    if (paramString.equals("BACK")) {
      return ComResUtil.getMessage("vocher.check.back");
    }
    if (paramString.equals("PACKAG")) {
      return ComResUtil.getMessage("vocher.check.packag");
    }
    if (paramString.equals("UNPACK")) {
      return ComResUtil.getMessage("vocher.check.unpack");
    }
    if (paramString.equals("ALREADY_RECEIVE")) {
      return ComResUtil.getMessage("vocher.check.already_receive");
    }
    if (paramString.equals("NOT_RECEIVE")) {
      return ComResUtil.getMessage("vocher.check.not_receive");
    }
    if (paramString.equals("ALREADY_FLITTING")) {
      return ComResUtil.getMessage("vocher.check.already_flitting");
    }
    if (paramString.equals("CHECKED")) {
      return ComResUtil.getMessage("vocher.check.checked");
    }
    if (paramString.equals("WAREHOUSE")) {
      return ComResUtil.getMessage("vocher.check.warehouse");
    }
    if (paramString.equals("NOT_PACKAGED")) {
      return ComResUtil.getMessage("vocher.check.not_packaged");
    }
    if (paramString.equals("UNWAREHOUSE")) {
      return ComResUtil.getMessage("vocher.check.unwarehouse");
    }
    return ComResUtil.getMessage("vocher.check.rests");
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.common.EvsStatusUtil
 * JD-Core Version:    0.7.0.1
 */