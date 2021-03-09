package com.zte.eas.hnyd.business.print.model;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class CommonPrintModel
  extends FinancePrintModelBase
{
  protected String hApplyNum;
  protected String hApplyDesc;
  protected String lOuName;
  protected Date hApplyDate;
  protected String lSubDocName;
  protected String lJournalNum;
  protected String hAssetFromOrgId;
  protected String hAssetFromOrgName;
  protected String hAssetToOrgId;
  protected String hAssetToOrgName;
  protected String hAssetToDeptId;
  protected String hAssetToDeptName;
  protected String hDescription;
  protected String hAppraiseProjectCode;
  protected String hAppraiseProjectName;
  protected String hPaymentTypeName;
  public String hBrandName;
  public String hReceiptCategoryCode;
  public String hReceiptCategoryName;
  public String hBoeDeptId;
  public String hLastUpdateDate;
  public String hLastUpdatedBy;
  public String hCreationDate;
  public String hCreatedBy;
  public String hLastUpdateLogin;
  public String hBoeHeaderId;
  public String hBoeNum;
  public String hBoeTypeId;
  public String hBoeTypeCode;
  public String hBoeTypeName;
  public String hOrgId;
  public String hCheckUnit;
  public String hCheckUnitName;
  public String hOperationTypeId;
  public String hOperationTypeName;
  public String hEmployeeId;
  public String hEmployeeNumber;
  public String hEmployeeName;
  public String hDeptName;
  public String hDeptStringName;
  public String hBoeDate;
  public String hEmail;
  public String hMobilePhone;
  public String hActionDate;
  public String hPaymentStatusCode;
  public String hPaymentStatus;
  public String hIsUrgentFlag;
  public String hIsProjectFlag;
  public String hHasContractFlag;
  public String hHasReverseAccruedFlag;
  public String hHasAccessoryFlag;
  public String hIsAccruedFlag;
  public String hCurrencyCode;
  public String hCurrencyUnit;
  public String hExchangeRate;
  public String hReverseAccruedCode;
  public String hReverseAccruedName;
  public String hBoeAbstract;
  public String hBpNumber;
  public String hBpCount;
  public String hCustomerBrand;
  public String hCustomerBrandName;
  public String hNetAttribute;
  public String hNetAttributeName;
  public String hApplyAmount;
  public String hBApplyAmount;
  public String hFinanceAuditAmount;
  public String hMultiApproalAmount;
  public String hBalanceAmount;
  public String hStrikeBalanceAmount;
  public String hBoeTotalAmount;
  public String hCavTotalAmount;
  public String hCavAmounts;
  public String hUseableAmounts;
  public String hFiChangeReason;
  public String hFiChangeReasonName;
  public String hUnifyDeptId;
  public String hUnifyDeptName;
  public String hContractHeaderId;
  public String hContractNumber;
  public String hContractName;
  public String hConTotalAmount;
  public String hConPayedAmount;
  public String hVendorId;
  public String hVendorNumber;
  public String hVendorName;
  public String hVendorSiteId;
  public String hVendorSiteCode;
  public String hPoHeaderId;
  public String hPoNumber;
  public String hCostDeptId;
  public String hCostDeptCode;
  public String hCostDeptName;
  public String hCustomerId;
  public String hCustomerNumber;
  public String hCustomerName;
  public String hCustomerSiteId;
  public String hSiteNumber;
  public String hSiteUseMeaning;
  public String hTaskId;
  public String hTaskNumber;
  public String hTaskName;
  public String hReceivablesOrgId;
  public String hReceivablesTrxId;
  public String hReceivablesName;
  public String hReceiptMethodId;
  public String hReceiptMethod;
  public String hReceiptBankAccountId;
  public String hBankAccountNum;
  public String hBankAccountName;
  public String hErpOrgId;
  public String hErpOrgName;
  public String hBrandId;
  public String hCustTrxTypeOrgId;
  public String hCustTrxTypeId;
  public String hCustTrxName;
  public String hProjectCode;
  public String hProjectName;
  public String hBudgetItemsCode;
  public String hBudgetItemName;
  public String hMisAmount;
  public String hStatusChangeReason;
  public String hPaymentFlag;
  public String hInvoiceNumber;
  public String hNeedBillFlag;
  public String hSubmitCancelCode;
  public String hSubmitCancelName;
  public String hSubmitCancelReason;
  public String hCheckReopenFlag;
  public String hFaEnabledFlag;
  public String hPaymentType;
  public String hRegionCode;
  public String hPayHeaderId;
  public String hPayBoeNum;
  public String hBoeCategoryCode;
  public String hBoeCategoryName;
  public String hReceiptTypeCode;
  public String hReceiptTypeName;
  public String hBillAccepter;
  public String hSource;
  public String hSourceBoeNum;
  public String hAttributeCategory;
  public String hAttribute1;
  public String hAttribute2;
  public String hAttribute3;
  public String hAttribute4;
  public String hAttribute5;
  public String hAttribute6;
  public String hAttribute7;
  public String hAttribute8;
  public String hAttribute9;
  public String hAttribute10;
  public String hAttribute11;
  public String hAttribute12;
  public String hAttribute13;
  public String hAttribute14;
  public String hAttribute15;
  public String hAttribute16;
  public String hAttribute17;
  public String hAttribute18;
  public String hAttribute19;
  public String hAttribute20;
  public String hNumberAttribute1;
  public String hNumberAttribute2;
  public String hNumberAttribute3;
  public String hNumberAttribute4;
  public String hNumberAttribute5;
  public String hNumberAttribute6;
  public String hNumberAttribute7;
  public String hNumberAttribute8;
  public String hNumberAttribute9;
  public String hNumberAttribute10;
  public String hNumberAttribute11;
  public String hNumberAttribute12;
  public String hNumberAttribute13;
  public String hNumberAttribute14;
  public String hNumberAttribute15;
  public String hDateAttribute1;
  public String hDateAttribute2;
  public String hDateAttribute3;
  public String hDateAttribute4;
  public String hDateAttribute5;
  public String hDateAttribute6;
  public String hDateAttribute7;
  public String hDateAttribute8;
  public String hDateAttribute9;
  public String hDateAttribute10;
  public String hVersionNum;
  public String hEnabledFlag;
  public String lMemoLinesName;
  public String lLastUpdateDate;
  public String lLastUpdatedBy;
  public String lCreationDate;
  public String lCreatedBy;
  public String lLastUpdateLogin;
  public String lBoeLineId;
  public String lBoeHeaderId;
  public String lLineType;
  public String lLineTypeName;
  public String lCurrencyCode;
  public String lExchangeRate;
  public String lExpenseDate;
  public String lExpenseAmount;
  public String lTaxSort;
  public String lTaxRate;
  public String lTaxAmount;
  public String lOperationTypeId;
  public String lOperationTypeCode;
  public String lOperationTypeName;
  public String lInvoiceNum;
  public String lBpCount;
  public String lAllPaymentAmount;
  public String lActionDate;
  public String lPayoffDate;
  public String lProjectCode;
  public String lProjectName;
  public String lBudgetItemName;
  public String lBudgetItemsCode;
  public String lVendorId;
  public String lVendorNumber;
  public String lVendorName;
  public String lVendorSiteId;
  public String lVendorSiteCode;
  public String lContractHeaderId;
  public String lContractNumber;
  public String lContractName;
  public String lConTotalAmount;
  public String lConPayedAmount;
  public String lTaskId;
  public String lTaskNumber;
  public String lTaskName;
  public String lInceptId;
  public String lCostDeptId;
  public String lCostDeptCode;
  public String lCostDeptName;
  public String lPoHeaderId;
  public String lPoNumber;
  public String lPoAmount;
  public String lReceivedAmount;
  public String lOrderedAmount;
  public String lReceivablesOrgId;
  public String lReceivablesTrxId;
  public String lReceivablesName;
  public String lReceiptMethodId;
  public String lReceiptMethod;
  public String lReceiptBankAccountId;
  public String lBankAccountNum;
  public String lBankAccountName;
  public String lMemoLinesId;
  public String lFromBankAccountId;
  public String lToBankAccountId;
  public String lCustomerBrand;
  public String lCustomerBrandName;
  public String lNetAttribute;
  public String lNetAttributeName;
  public String lLineAbstract;
  public String lAccruedTypeCode;
  public String lAccruedTypeName;
  public String lPrepayType;
  public String lPrepayTypeName;
  public String lTerritoryTypeCode;
  public String lTerritoryTypeName;
  public String lTrafficTypeCode;
  public String lTrafficTypeName;
  public String lLineQuantity;
  public String lUnitPrice;
  public String lDebitAmount;
  public String lLoanAmount;
  public String lAccountSegment1;
  public String lAccountSegment2;
  public String lAccountSegment3;
  public String lAccountSegment4;
  public String lAccountSegment5;
  public String lAccountSegment6;
  public String lAccountSegment7;
  public String lAccountCombinations;
  public String lAccountCombinationsDebt;
  public String lAccountCombinationsPrepay;
  public String lAccountCombinationsPayments;
  public String lAttributeCategory;
  public String lAttribute1;
  public String lAttribute2;
  public String lAttribute3;
  public String lAttribute4;
  public String lAttribute5;
  public String lAttribute6;
  public String lAttribute7;
  public String lAttribute8;
  public String lAttribute9;
  public String lAttribute10;
  public String lAttribute11;
  public String lAttribute12;
  public String lAttribute13;
  public String lAttribute14;
  public String lAttribute15;
  public String lAttribute16;
  public String lAttribute17;
  public String lAttribute18;
  public String lAttribute19;
  public String lAttribute20;
  public String lAttribute21;
  public String lAttribute22;
  public String lAttribute23;
  public String lAttribute24;
  public String lAttribute25;
  public String lAttribute26;
  public String lAttribute27;
  public String lAttribute28;
  public String lAttribute29;
  public String lAttribute30;
  public String lNumberAttribute1;
  public String lNumberAttribute2;
  public String lNumberAttribute3;
  public String lNumberAttribute4;
  public String lNumberAttribute5;
  public String lNumberAttribute6;
  public String lNumberAttribute7;
  public String lNumberAttribute8;
  public String lNumberAttribute9;
  public String lNumberAttribute10;
  public String lNumberAttribute11;
  public String lNumberAttribute12;
  public String lNumberAttribute13;
  public String lNumberAttribute14;
  public String lNumberAttribute15;
  public String lNumberAttribute16;
  public String lNumberAttribute17;
  public String lNumberAttribute18;
  public String lNumberAttribute19;
  public String lNumberAttribute20;
  public String lDateAttribute1;
  public String lDateAttribute2;
  public String lDateAttribute3;
  public String lDateAttribute4;
  public String lDateAttribute5;
  public String lDateAttribute6;
  public String lDateAttribute7;
  public String lDateAttribute8;
  public String lDateAttribute9;
  public String lDateAttribute10;
  public String lVersionNum;
  public String lEnabledFlag;
  public String pLastUpdateDate;
  public String pLastUpdatedBy;
  public String pCreationDate;
  public String pCreatedBy;
  public String pLastUpdateLogin;
  public String pBoePaymentId;
  public String pBoeHeaderId;
  public String pBoeLineId;
  public String pSourceBoeHeaderId;
  public String pPaymentTypeCode;
  public String pPaymentTypeName;
  public String pPaymentAmount;
  public String pPaymentModeCode;
  public String pPaymentModeName;
  public String pPaymentDate;
  public String pCurrencyCode;
  public String pApplyAmount;
  public String pPayee;
  public String pVendorCode;
  public String pVendorName;
  public String pVendorSiteName;
  public String pBankName;
  public String pBankBranchName;
  public String pBankAccountName;
  public String pBankAccountNum;
  public String pBankAccountType;
  public String pCountry;
  public String pProvince;
  public String pCity;
  public String pAddress;
  public String pDescription;
  public String pInvoiceId;
  public String pPaymentStatus;
  public String pAttributeCategory;
  public String pAttribute1;
  public String pAttribute2;
  public String pAttribute3;
  public String pAttribute4;
  public String pAttribute5;
  public String pAttribute6;
  public String pAttribute7;
  public String pAttribute8;
  public String pAttribute9;
  public String pAttribute10;
  public String pNumericalAttribute1;
  public String pNumericalAttribute2;
  public String pNumericalAttribute3;
  public String pNumericalAttribute4;
  public String pNumericalAttribute5;
  public String pNumericalAttribute6;
  public String pNumericalAttribute7;
  public String pNumericalAttribute8;
  public String pNumericalAttribute9;
  public String pNumericalAttribute10;
  public String pMemo;
  public String pEnabledFlag;
  public String pVersionNum;
  public String hErrandTypeCode;
  public String hErrandTypeName;
  public String hAccompanyPersonIds;
  public String hAccompanyPersonName;
  public String commonLineHtml = "";
  public String commonTotal = "";
  public String commonTotal1 = "";
  public String commonTotal2 = "";
  public String commonTotal3 = "";
  public String commonTotal4 = "";
  public String commonTotal5 = "";
  public String commonTotal6 = "";
  
  public CommonPrintModel(String paramString)
  {
    super(paramString);
  }
  
  public String getHActionDate()
  {
    return this.hActionDate;
  }
  
  public void setHActionDate(String paramString)
  {
    if ((paramString != null) && (!"".equals(paramString)))
    {
      int i = paramString.indexOf(" ");
      if (i > 5) {
        paramString = paramString.substring(0, i);
      }
    }
    this.hActionDate = paramString;
  }
  
  public String getHApplyAmount()
  {
    return this.hApplyAmount;
  }
  
  public void setHApplyAmount(String paramString)
  {
    try
    {
      if (paramString.indexOf(",") < 0) {
        this.hApplyAmount = formatMoney(paramString);
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public String getHAttribute1()
  {
    return this.hAttribute1;
  }
  
  public void setHAttribute1(String paramString)
  {
    this.hAttribute1 = paramString;
  }
  
  public String getHAttribute10()
  {
    return this.hAttribute10;
  }
  
  public void setHAttribute10(String paramString)
  {
    this.hAttribute10 = paramString;
  }
  
  public String getHAttribute11()
  {
    return this.hAttribute11;
  }
  
  public void setHAttribute11(String paramString)
  {
    this.hAttribute11 = paramString;
  }
  
  public String getHAttribute12()
  {
    return this.hAttribute12;
  }
  
  public void setHAttribute12(String paramString)
  {
    this.hAttribute12 = paramString;
  }
  
  public String getHAttribute13()
  {
    return this.hAttribute13;
  }
  
  public void setHAttribute13(String paramString)
  {
    this.hAttribute13 = paramString;
  }
  
  public String getHAttribute14()
  {
    return this.hAttribute14;
  }
  
  public void setHAttribute14(String paramString)
  {
    this.hAttribute14 = paramString;
  }
  
  public String getHAttribute15()
  {
    return this.hAttribute15;
  }
  
  public void setHAttribute15(String paramString)
  {
    this.hAttribute15 = paramString;
  }
  
  public String getHAttribute16()
  {
    return this.hAttribute16;
  }
  
  public void setHAttribute16(String paramString)
  {
    this.hAttribute16 = paramString;
  }
  
  public String getHAttribute17()
  {
    return this.hAttribute17;
  }
  
  public void setHAttribute17(String paramString)
  {
    this.hAttribute17 = paramString;
  }
  
  public String getHAttribute18()
  {
    return this.hAttribute18;
  }
  
  public void setHAttribute18(String paramString)
  {
    this.hAttribute18 = paramString;
  }
  
  public String getHAttribute19()
  {
    return this.hAttribute19;
  }
  
  public void setHAttribute19(String paramString)
  {
    this.hAttribute19 = paramString;
  }
  
  public String getHAttribute2()
  {
    return this.hAttribute2;
  }
  
  public void setHAttribute2(String paramString)
  {
    this.hAttribute2 = paramString;
  }
  
  public String getHAttribute20()
  {
    return this.hAttribute20;
  }
  
  public void setHAttribute20(String paramString)
  {
    this.hAttribute20 = paramString;
  }
  
  public String getHAttribute3()
  {
    return this.hAttribute3;
  }
  
  public void setHAttribute3(String paramString)
  {
    this.hAttribute3 = paramString;
  }
  
  public String getHAttribute4()
  {
    return this.hAttribute4;
  }
  
  public void setHAttribute4(String paramString)
  {
    this.hAttribute4 = paramString;
  }
  
  public String getHAttribute5()
  {
    return this.hAttribute5;
  }
  
  public void setHAttribute5(String paramString)
  {
    this.hAttribute5 = paramString;
  }
  
  public String getHAttribute6()
  {
    return this.hAttribute6;
  }
  
  public void setHAttribute6(String paramString)
  {
    this.hAttribute6 = paramString;
  }
  
  public String getHAttribute7()
  {
    return this.hAttribute7;
  }
  
  public void setHAttribute7(String paramString)
  {
    this.hAttribute7 = paramString;
  }
  
  public String getHAttribute8()
  {
    return this.hAttribute8;
  }
  
  public void setHAttribute8(String paramString)
  {
    this.hAttribute8 = paramString;
  }
  
  public String getHAttribute9()
  {
    return this.hAttribute9;
  }
  
  public void setHAttribute9(String paramString)
  {
    this.hAttribute9 = paramString;
  }
  
  public String getHAttributeCategory()
  {
    return this.hAttributeCategory;
  }
  
  public void setHAttributeCategory(String paramString)
  {
    this.hAttributeCategory = paramString;
  }
  
  public String getHBalanceAmount()
  {
    return this.hBalanceAmount;
  }
  
  public void setHBalanceAmount(String paramString)
  {
    this.hBalanceAmount = paramString;
  }
  
  public String getHBankAccountName()
  {
    return this.hBankAccountName;
  }
  
  public void setHBankAccountName(String paramString)
  {
    this.hBankAccountName = paramString;
  }
  
  public String getHBankAccountNum()
  {
    return this.hBankAccountNum;
  }
  
  public void setHBankAccountNum(String paramString)
  {
    this.hBankAccountNum = paramString;
  }
  
  public String getHBillAccepter()
  {
    return this.hBillAccepter;
  }
  
  public void setHBillAccepter(String paramString)
  {
    this.hBillAccepter = paramString;
  }
  
  public String getHBoeAbstract()
  {
    return this.hBoeAbstract;
  }
  
  public void setHBoeAbstract(String paramString)
  {
    this.hBoeAbstract = paramString;
  }
  
  public String getHBoeCategoryCode()
  {
    return this.hBoeCategoryCode;
  }
  
  public void setHBoeCategoryCode(String paramString)
  {
    this.hBoeCategoryCode = paramString;
  }
  
  public String getHBoeCategoryName()
  {
    return this.hBoeCategoryName;
  }
  
  public void setHBoeCategoryName(String paramString)
  {
    this.hBoeCategoryName = paramString;
  }
  
  public String getHBoeDate()
  {
    return this.hBoeDate;
  }
  
  public void setHBoeDate(String paramString)
  {
    try
    {
      this.hBoeDate = formatDate(paramString);
    }
    catch (ParseException localParseException)
    {
      localParseException.printStackTrace();
    }
  }
  
  public String getHBoeDeptId()
  {
    return this.hBoeDeptId;
  }
  
  public void setHBoeDeptId(String paramString)
  {
    this.hBoeDeptId = paramString;
  }
  
  public String getHBoeHeaderId()
  {
    return this.hBoeHeaderId;
  }
  
  public void setHBoeHeaderId(String paramString)
  {
    this.hBoeHeaderId = paramString;
  }
  
  public String getHBoeNum()
  {
    return this.hBoeNum;
  }
  
  public void setHBoeNum(String paramString)
  {
    this.hBoeNum = paramString;
  }
  
  public String getHBoeTotalAmount()
  {
    return this.hBoeTotalAmount;
  }
  
  public void setHBoeTotalAmount(String paramString)
  {
    this.hBoeTotalAmount = paramString;
  }
  
  public String getHBoeTypeCode()
  {
    return this.hBoeTypeCode;
  }
  
  public void setHBoeTypeCode(String paramString)
  {
    this.hBoeTypeCode = paramString;
  }
  
  public String getHBoeTypeId()
  {
    return this.hBoeTypeId;
  }
  
  public void setHBoeTypeId(String paramString)
  {
    this.hBoeTypeId = paramString;
  }
  
  public String getHBoeTypeName()
  {
    return this.hBoeTypeName;
  }
  
  public void setHBoeTypeName(String paramString)
  {
    this.hBoeTypeName = paramString;
  }
  
  public String getHBpCount()
  {
    return this.hBpCount;
  }
  
  public void setHBpCount(String paramString)
  {
    this.hBpCount = paramString;
  }
  
  public String getHBpNumber()
  {
    return this.hBpNumber;
  }
  
  public void setHBpNumber(String paramString)
  {
    this.hBpNumber = paramString;
  }
  
  public String getHBrandId()
  {
    return this.hBrandId;
  }
  
  public void setHBrandId(String paramString)
  {
    this.hBrandId = paramString;
  }
  
  public String getHBudgetItemName()
  {
    return this.hBudgetItemName;
  }
  
  public void setHBudgetItemName(String paramString)
  {
    this.hBudgetItemName = paramString;
  }
  
  public String getHBudgetItemsCode()
  {
    return this.hBudgetItemsCode;
  }
  
  public void setHBudgetItemsCode(String paramString)
  {
    this.hBudgetItemsCode = paramString;
  }
  
  public String getHCavAmounts()
  {
    return this.hCavAmounts;
  }
  
  public void setHCavAmounts(String paramString)
  {
    this.hCavAmounts = paramString;
  }
  
  public String getHCavTotalAmount()
  {
    return this.hCavTotalAmount;
  }
  
  public void setHCavTotalAmount(String paramString)
  {
    try
    {
      this.hCavTotalAmount = formatMoney(paramString);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public String getHCheckReopenFlag()
  {
    return this.hCheckReopenFlag;
  }
  
  public void setHCheckReopenFlag(String paramString)
  {
    this.hCheckReopenFlag = paramString;
  }
  
  public String getHCheckUnit()
  {
    return this.hCheckUnit;
  }
  
  public void setHCheckUnit(String paramString)
  {
    this.hCheckUnit = paramString;
  }
  
  public String getHCheckUnitName()
  {
    return this.hCheckUnitName;
  }
  
  public void setHCheckUnitName(String paramString)
  {
    this.hCheckUnitName = paramString;
  }
  
  public String getHConPayedAmount()
  {
    return this.hConPayedAmount;
  }
  
  public void setHConPayedAmount(String paramString)
  {
    this.hConPayedAmount = paramString;
  }
  
  public String getHConTotalAmount()
  {
    return this.hConTotalAmount;
  }
  
  public void setHConTotalAmount(String paramString)
  {
    try
    {
      this.hConTotalAmount = formatMoney(paramString);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public String getHContractHeaderId()
  {
    return this.hContractHeaderId;
  }
  
  public void setHContractHeaderId(String paramString)
  {
    this.hContractHeaderId = paramString;
  }
  
  public String getHContractName()
  {
    return this.hContractName;
  }
  
  public void setHContractName(String paramString)
  {
    this.hContractName = paramString;
  }
  
  public String getHContractNumber()
  {
    return this.hContractNumber;
  }
  
  public void setHContractNumber(String paramString)
  {
    this.hContractNumber = paramString;
  }
  
  public String getHCostDeptCode()
  {
    return this.hCostDeptCode;
  }
  
  public void setHCostDeptCode(String paramString)
  {
    this.hCostDeptCode = paramString;
  }
  
  public String getHCostDeptId()
  {
    return this.hCostDeptId;
  }
  
  public void setHCostDeptId(String paramString)
  {
    this.hCostDeptId = paramString;
  }
  
  public String getHCostDeptName()
  {
    return this.hCostDeptName;
  }
  
  public void setHCostDeptName(String paramString)
  {
    this.hCostDeptName = paramString;
  }
  
  public String getHCreatedBy()
  {
    return this.hCreatedBy;
  }
  
  public void setHCreatedBy(String paramString)
  {
    this.hCreatedBy = paramString;
  }
  
  public String getHCreationDate()
  {
    return this.hCreationDate;
  }
  
  public void setHCreationDate(String paramString)
  {
    this.hCreationDate = paramString;
  }
  
  public String getHCurrencyCode()
  {
    return this.hCurrencyCode;
  }
  
  public void setHCurrencyCode(String paramString)
  {
    this.hCurrencyCode = paramString;
  }
  
  public String getHCurrencyUnit()
  {
    return this.hCurrencyUnit;
  }
  
  public void setHCurrencyUnit(String paramString)
  {
    this.hCurrencyUnit = paramString;
  }
  
  public String getHCustomerBrand()
  {
    return this.hCustomerBrand;
  }
  
  public void setHCustomerBrand(String paramString)
  {
    this.hCustomerBrand = paramString;
  }
  
  public String getHCustomerBrandName()
  {
    return this.hCustomerBrandName;
  }
  
  public void setHCustomerBrandName(String paramString)
  {
    this.hCustomerBrandName = paramString;
  }
  
  public String getHCustomerId()
  {
    return this.hCustomerId;
  }
  
  public void setHCustomerId(String paramString)
  {
    this.hCustomerId = paramString;
  }
  
  public String getHCustomerName()
  {
    return this.hCustomerName;
  }
  
  public void setHCustomerName(String paramString)
  {
    this.hCustomerName = paramString;
  }
  
  public String getHCustomerNumber()
  {
    return this.hCustomerNumber;
  }
  
  public void setHCustomerNumber(String paramString)
  {
    this.hCustomerNumber = paramString;
  }
  
  public String getHCustomerSiteId()
  {
    return this.hCustomerSiteId;
  }
  
  public void setHCustomerSiteId(String paramString)
  {
    this.hCustomerSiteId = paramString;
  }
  
  public String getHCustTrxName()
  {
    return this.hCustTrxName;
  }
  
  public void setHCustTrxName(String paramString)
  {
    this.hCustTrxName = paramString;
  }
  
  public String getHCustTrxTypeId()
  {
    return this.hCustTrxTypeId;
  }
  
  public void setHCustTrxTypeId(String paramString)
  {
    this.hCustTrxTypeId = paramString;
  }
  
  public String getHCustTrxTypeOrgId()
  {
    return this.hCustTrxTypeOrgId;
  }
  
  public void setHCustTrxTypeOrgId(String paramString)
  {
    this.hCustTrxTypeOrgId = paramString;
  }
  
  public String getHDateAttribute1()
  {
    return this.hDateAttribute1;
  }
  
  public void setHDateAttribute1(String paramString)
  {
    this.hDateAttribute1 = paramString;
  }
  
  public String getHDateAttribute10()
  {
    return this.hDateAttribute10;
  }
  
  public void setHDateAttribute10(String paramString)
  {
    this.hDateAttribute10 = paramString;
  }
  
  public String getHDateAttribute2()
  {
    return this.hDateAttribute2;
  }
  
  public void setHDateAttribute2(String paramString)
  {
    this.hDateAttribute2 = paramString;
  }
  
  public String getHDateAttribute3()
  {
    return this.hDateAttribute3;
  }
  
  public void setHDateAttribute3(String paramString)
  {
    this.hDateAttribute3 = paramString;
  }
  
  public String getHDateAttribute4()
  {
    return this.hDateAttribute4;
  }
  
  public void setHDateAttribute4(String paramString)
  {
    this.hDateAttribute4 = paramString;
  }
  
  public String getHDateAttribute5()
  {
    return this.hDateAttribute5;
  }
  
  public void setHDateAttribute5(String paramString)
  {
    this.hDateAttribute5 = paramString;
  }
  
  public String getHDateAttribute6()
  {
    return this.hDateAttribute6;
  }
  
  public void setHDateAttribute6(String paramString)
  {
    this.hDateAttribute6 = paramString;
  }
  
  public String getHDateAttribute7()
  {
    return this.hDateAttribute7;
  }
  
  public void setHDateAttribute7(String paramString)
  {
    this.hDateAttribute7 = paramString;
  }
  
  public String getHDateAttribute8()
  {
    return this.hDateAttribute8;
  }
  
  public void setHDateAttribute8(String paramString)
  {
    this.hDateAttribute8 = paramString;
  }
  
  public String getHDateAttribute9()
  {
    return this.hDateAttribute9;
  }
  
  public void setHDateAttribute9(String paramString)
  {
    this.hDateAttribute9 = paramString;
  }
  
  public String getHDeptName()
  {
    return this.hDeptName;
  }
  
  public void setHDeptName(String paramString)
  {
    this.hDeptName = paramString;
  }
  
  public String getHDeptStringName()
  {
    return this.hDeptStringName;
  }
  
  public void setHDeptStringName(String paramString)
  {
    this.hDeptStringName = paramString;
  }
  
  public String getHEmail()
  {
    return this.hEmail;
  }
  
  public void setHEmail(String paramString)
  {
    this.hEmail = paramString;
  }
  
  public String getHEmployeeId()
  {
    return this.hEmployeeId;
  }
  
  public void setHEmployeeId(String paramString)
  {
    this.hEmployeeId = paramString;
  }
  
  public String getHEmployeeName()
  {
    return this.hEmployeeName;
  }
  
  public void setHEmployeeName(String paramString)
  {
    this.hEmployeeName = paramString;
  }
  
  public String getHEmployeeNumber()
  {
    return this.hEmployeeNumber;
  }
  
  public void setHEmployeeNumber(String paramString)
  {
    this.hEmployeeNumber = paramString;
  }
  
  public String getHEnabledFlag()
  {
    return this.hEnabledFlag;
  }
  
  public void setHEnabledFlag(String paramString)
  {
    this.hEnabledFlag = paramString;
  }
  
  public String getHErpOrgId()
  {
    return this.hErpOrgId;
  }
  
  public void setHErpOrgId(String paramString)
  {
    this.hErpOrgId = paramString;
  }
  
  public String getHErpOrgName()
  {
    return this.hErpOrgName;
  }
  
  public void setHErpOrgName(String paramString)
  {
    this.hErpOrgName = paramString;
  }
  
  public String getHExchangeRate()
  {
    return this.hExchangeRate;
  }
  
  public void setHExchangeRate(String paramString)
  {
    this.hExchangeRate = paramString;
  }
  
  public String getHFaEnabledFlag()
  {
    return this.hFaEnabledFlag;
  }
  
  public void setHFaEnabledFlag(String paramString)
  {
    this.hFaEnabledFlag = paramString;
  }
  
  public String getHFiChangeReason()
  {
    return this.hFiChangeReason;
  }
  
  public void setHFiChangeReason(String paramString)
  {
    this.hFiChangeReason = paramString;
  }
  
  public String getHFiChangeReasonName()
  {
    return this.hFiChangeReasonName;
  }
  
  public void setHFiChangeReasonName(String paramString)
  {
    this.hFiChangeReasonName = paramString;
  }
  
  public String getHFinanceAuditAmount()
  {
    return this.hFinanceAuditAmount;
  }
  
  public void setHFinanceAuditAmount(String paramString)
  {
    this.hFinanceAuditAmount = paramString;
  }
  
  public String getHHasAccessoryFlag()
  {
    return this.hHasAccessoryFlag;
  }
  
  public void setHHasAccessoryFlag(String paramString)
  {
    this.hHasAccessoryFlag = paramString;
  }
  
  public String getHHasContractFlag()
  {
    return this.hHasContractFlag;
  }
  
  public void setHHasContractFlag(String paramString)
  {
    this.hHasContractFlag = paramString;
  }
  
  public String getHHasReverseAccruedFlag()
  {
    return this.hHasReverseAccruedFlag;
  }
  
  public void setHHasReverseAccruedFlag(String paramString)
  {
    this.hHasReverseAccruedFlag = paramString;
  }
  
  public String getHInvoiceNumber()
  {
    return this.hInvoiceNumber;
  }
  
  public void setHInvoiceNumber(String paramString)
  {
    this.hInvoiceNumber = paramString;
  }
  
  public String getHIsAccruedFlag()
  {
    return this.hIsAccruedFlag;
  }
  
  public void setHIsAccruedFlag(String paramString)
  {
    this.hIsAccruedFlag = paramString;
  }
  
  public String getHIsProjectFlag()
  {
    return this.hIsProjectFlag;
  }
  
  public void setHIsProjectFlag(String paramString)
  {
    this.hIsProjectFlag = paramString;
  }
  
  public String getHIsUrgentFlag()
  {
    return this.hIsUrgentFlag;
  }
  
  public void setHIsUrgentFlag(String paramString)
  {
    this.hIsUrgentFlag = paramString;
  }
  
  public String getHLastUpdateDate()
  {
    return this.hLastUpdateDate;
  }
  
  public void setHLastUpdateDate(String paramString)
  {
    this.hLastUpdateDate = paramString;
  }
  
  public String getHLastUpdatedBy()
  {
    return this.hLastUpdatedBy;
  }
  
  public void setHLastUpdatedBy(String paramString)
  {
    this.hLastUpdatedBy = paramString;
  }
  
  public String getHLastUpdateLogin()
  {
    return this.hLastUpdateLogin;
  }
  
  public void setHLastUpdateLogin(String paramString)
  {
    this.hLastUpdateLogin = paramString;
  }
  
  public String getHMisAmount()
  {
    return this.hMisAmount;
  }
  
  public void setHMisAmount(String paramString)
  {
    this.hMisAmount = paramString;
  }
  
  public String getHMobilePhone()
  {
    return this.hMobilePhone;
  }
  
  public void setHMobilePhone(String paramString)
  {
    this.hMobilePhone = paramString;
  }
  
  public String getHMultiApproalAmount()
  {
    return this.hMultiApproalAmount;
  }
  
  public void setHMultiApproalAmount(String paramString)
  {
    this.hMultiApproalAmount = paramString;
  }
  
  public String getHNeedBillFlag()
  {
    return this.hNeedBillFlag;
  }
  
  public void setHNeedBillFlag(String paramString)
  {
    this.hNeedBillFlag = paramString;
  }
  
  public String getHNetAttribute()
  {
    return this.hNetAttribute;
  }
  
  public void setHNetAttribute(String paramString)
  {
    this.hNetAttribute = paramString;
  }
  
  public String getHNetAttributeName()
  {
    return this.hNetAttributeName;
  }
  
  public void setHNetAttributeName(String paramString)
  {
    this.hNetAttributeName = paramString;
  }
  
  public String getHNumberAttribute1()
  {
    return this.hNumberAttribute1;
  }
  
  public void setHNumberAttribute1(String paramString)
  {
    this.hNumberAttribute1 = paramString;
  }
  
  public String getHNumberAttribute10()
  {
    return this.hNumberAttribute10;
  }
  
  public void setHNumberAttribute10(String paramString)
  {
    this.hNumberAttribute10 = paramString;
  }
  
  public String getHNumberAttribute11()
  {
    return this.hNumberAttribute11;
  }
  
  public void setHNumberAttribute11(String paramString)
  {
    this.hNumberAttribute11 = paramString;
  }
  
  public String getHNumberAttribute12()
  {
    return this.hNumberAttribute12;
  }
  
  public void setHNumberAttribute12(String paramString)
  {
    this.hNumberAttribute12 = paramString;
  }
  
  public String getHNumberAttribute13()
  {
    return this.hNumberAttribute13;
  }
  
  public void setHNumberAttribute13(String paramString)
  {
    this.hNumberAttribute13 = paramString;
  }
  
  public String getHNumberAttribute14()
  {
    return this.hNumberAttribute14;
  }
  
  public void setHNumberAttribute14(String paramString)
  {
    this.hNumberAttribute14 = paramString;
  }
  
  public String getHNumberAttribute15()
  {
    return this.hNumberAttribute15;
  }
  
  public void setHNumberAttribute15(String paramString)
  {
    this.hNumberAttribute15 = paramString;
  }
  
  public String getHNumberAttribute2()
  {
    return this.hNumberAttribute2;
  }
  
  public void setHNumberAttribute2(String paramString)
  {
    this.hNumberAttribute2 = paramString;
  }
  
  public String getHNumberAttribute3()
  {
    return this.hNumberAttribute3;
  }
  
  public void setHNumberAttribute3(String paramString)
  {
    this.hNumberAttribute3 = paramString;
  }
  
  public String getHNumberAttribute4()
  {
    return this.hNumberAttribute4;
  }
  
  public void setHNumberAttribute4(String paramString)
  {
    this.hNumberAttribute4 = paramString;
  }
  
  public String getHNumberAttribute5()
  {
    return this.hNumberAttribute5;
  }
  
  public void setHNumberAttribute5(String paramString)
  {
    this.hNumberAttribute5 = paramString;
  }
  
  public String getHNumberAttribute6()
  {
    return this.hNumberAttribute6;
  }
  
  public void setHNumberAttribute6(String paramString)
  {
    this.hNumberAttribute6 = paramString;
  }
  
  public String getHNumberAttribute7()
  {
    return this.hNumberAttribute7;
  }
  
  public void setHNumberAttribute7(String paramString)
  {
    this.hNumberAttribute7 = paramString;
  }
  
  public String getHNumberAttribute8()
  {
    return this.hNumberAttribute8;
  }
  
  public void setHNumberAttribute8(String paramString)
  {
    this.hNumberAttribute8 = paramString;
  }
  
  public String getHNumberAttribute9()
  {
    return this.hNumberAttribute9;
  }
  
  public void setHNumberAttribute9(String paramString)
  {
    this.hNumberAttribute9 = paramString;
  }
  
  public String getHOperationTypeId()
  {
    return this.hOperationTypeId;
  }
  
  public void setHOperationTypeId(String paramString)
  {
    this.hOperationTypeId = paramString;
  }
  
  public String getHOperationTypeName()
  {
    return this.hOperationTypeName;
  }
  
  public void setHOperationTypeName(String paramString)
  {
    this.hOperationTypeName = paramString;
  }
  
  public String getHOrgId()
  {
    return this.hOrgId;
  }
  
  public void setHOrgId(String paramString)
  {
    this.hOrgId = paramString;
  }
  
  public String getHPayBoeNum()
  {
    return this.hPayBoeNum;
  }
  
  public void setHPayBoeNum(String paramString)
  {
    this.hPayBoeNum = paramString;
  }
  
  public String getHPayHeaderId()
  {
    return this.hPayHeaderId;
  }
  
  public void setHPayHeaderId(String paramString)
  {
    this.hPayHeaderId = paramString;
  }
  
  public String getHPaymentFlag()
  {
    return this.hPaymentFlag;
  }
  
  public void setHPaymentFlag(String paramString)
  {
    this.hPaymentFlag = paramString;
  }
  
  public String getHPaymentStatus()
  {
    return this.hPaymentStatus;
  }
  
  public void setHPaymentStatus(String paramString)
  {
    this.hPaymentStatus = paramString;
  }
  
  public String getHPaymentStatusCode()
  {
    return this.hPaymentStatusCode;
  }
  
  public void setHPaymentStatusCode(String paramString)
  {
    this.hPaymentStatusCode = paramString;
  }
  
  public String getHPaymentType()
  {
    return this.hPaymentType;
  }
  
  public void setHPaymentType(String paramString)
  {
    this.hPaymentType = paramString;
  }
  
  public String getHPoHeaderId()
  {
    return this.hPoHeaderId;
  }
  
  public void setHPoHeaderId(String paramString)
  {
    this.hPoHeaderId = paramString;
  }
  
  public String getHPoNumber()
  {
    return this.hPoNumber;
  }
  
  public void setHPoNumber(String paramString)
  {
    this.hPoNumber = paramString;
  }
  
  public String getHProjectCode()
  {
    return this.hProjectCode;
  }
  
  public void setHProjectCode(String paramString)
  {
    this.hProjectCode = paramString;
  }
  
  public String getHProjectName()
  {
    return this.hProjectName;
  }
  
  public void setHProjectName(String paramString)
  {
    this.hProjectName = paramString;
  }
  
  public String getHReceiptBankAccountId()
  {
    return this.hReceiptBankAccountId;
  }
  
  public void setHReceiptBankAccountId(String paramString)
  {
    this.hReceiptBankAccountId = paramString;
  }
  
  public String getHReceiptCategoryCode()
  {
    return this.hReceiptCategoryCode;
  }
  
  public void setHReceiptCategoryCode(String paramString)
  {
    this.hReceiptCategoryCode = paramString;
  }
  
  public String getHReceiptCategoryName()
  {
    return this.hReceiptCategoryName;
  }
  
  public void setHReceiptCategoryName(String paramString)
  {
    this.hReceiptCategoryName = paramString;
  }
  
  public String getHReceiptMethod()
  {
    return this.hReceiptMethod;
  }
  
  public void setHReceiptMethod(String paramString)
  {
    this.hReceiptMethod = paramString;
  }
  
  public String getHReceiptMethodId()
  {
    return this.hReceiptMethodId;
  }
  
  public void setHReceiptMethodId(String paramString)
  {
    this.hReceiptMethodId = paramString;
  }
  
  public String getHReceiptTypeCode()
  {
    return this.hReceiptTypeCode;
  }
  
  public void setHReceiptTypeCode(String paramString)
  {
    this.hReceiptTypeCode = paramString;
  }
  
  public String getHReceiptTypeName()
  {
    return this.hReceiptTypeName;
  }
  
  public void setHReceiptTypeName(String paramString)
  {
    this.hReceiptTypeName = paramString;
  }
  
  public String getHReceivablesName()
  {
    return this.hReceivablesName;
  }
  
  public void setHReceivablesName(String paramString)
  {
    this.hReceivablesName = paramString;
  }
  
  public String getHReceivablesOrgId()
  {
    return this.hReceivablesOrgId;
  }
  
  public void setHReceivablesOrgId(String paramString)
  {
    this.hReceivablesOrgId = paramString;
  }
  
  public String getHReceivablesTrxId()
  {
    return this.hReceivablesTrxId;
  }
  
  public void setHReceivablesTrxId(String paramString)
  {
    this.hReceivablesTrxId = paramString;
  }
  
  public String getHRegionCode()
  {
    return this.hRegionCode;
  }
  
  public void setHRegionCode(String paramString)
  {
    this.hRegionCode = paramString;
  }
  
  public String getHReverseAccruedCode()
  {
    return this.hReverseAccruedCode;
  }
  
  public void setHReverseAccruedCode(String paramString)
  {
    this.hReverseAccruedCode = paramString;
  }
  
  public String getHReverseAccruedName()
  {
    return this.hReverseAccruedName;
  }
  
  public void setHReverseAccruedName(String paramString)
  {
    this.hReverseAccruedName = paramString;
  }
  
  public String getHSiteNumber()
  {
    return this.hSiteNumber;
  }
  
  public void setHSiteNumber(String paramString)
  {
    this.hSiteNumber = paramString;
  }
  
  public String getHSiteUseMeaning()
  {
    return this.hSiteUseMeaning;
  }
  
  public void setHSiteUseMeaning(String paramString)
  {
    this.hSiteUseMeaning = paramString;
  }
  
  public String getHSource()
  {
    return this.hSource;
  }
  
  public void setHSource(String paramString)
  {
    this.hSource = paramString;
  }
  
  public String getHSourceBoeNum()
  {
    return this.hSourceBoeNum;
  }
  
  public void setHSourceBoeNum(String paramString)
  {
    this.hSourceBoeNum = paramString;
  }
  
  public String getHStatusChangeReason()
  {
    return this.hStatusChangeReason;
  }
  
  public void setHStatusChangeReason(String paramString)
  {
    this.hStatusChangeReason = paramString;
  }
  
  public String getHStrikeBalanceAmount()
  {
    return this.hStrikeBalanceAmount;
  }
  
  public void setHStrikeBalanceAmount(String paramString)
  {
    this.hStrikeBalanceAmount = paramString;
  }
  
  public String getHSubmitCancelCode()
  {
    return this.hSubmitCancelCode;
  }
  
  public void setHSubmitCancelCode(String paramString)
  {
    this.hSubmitCancelCode = paramString;
  }
  
  public String getHSubmitCancelName()
  {
    return this.hSubmitCancelName;
  }
  
  public void setHSubmitCancelName(String paramString)
  {
    this.hSubmitCancelName = paramString;
  }
  
  public String getHSubmitCancelReason()
  {
    return this.hSubmitCancelReason;
  }
  
  public void setHSubmitCancelReason(String paramString)
  {
    this.hSubmitCancelReason = paramString;
  }
  
  public String getHTaskId()
  {
    return this.hTaskId;
  }
  
  public void setHTaskId(String paramString)
  {
    this.hTaskId = paramString;
  }
  
  public String getHTaskName()
  {
    return this.hTaskName;
  }
  
  public void setHTaskName(String paramString)
  {
    this.hTaskName = paramString;
  }
  
  public String getHTaskNumber()
  {
    return this.hTaskNumber;
  }
  
  public void setHTaskNumber(String paramString)
  {
    this.hTaskNumber = paramString;
  }
  
  public String getHUnifyDeptId()
  {
    return this.hUnifyDeptId;
  }
  
  public void setHUnifyDeptId(String paramString)
  {
    this.hUnifyDeptId = paramString;
  }
  
  public String getHUnifyDeptName()
  {
    return this.hUnifyDeptName;
  }
  
  public void setHUnifyDeptName(String paramString)
  {
    this.hUnifyDeptName = paramString;
  }
  
  public String getHUseableAmounts()
  {
    return this.hUseableAmounts;
  }
  
  public void setHUseableAmounts(String paramString)
  {
    try
    {
      this.hUseableAmounts = formatMoney(paramString);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public String getHVendorId()
  {
    return this.hVendorId;
  }
  
  public void setHVendorId(String paramString)
  {
    this.hVendorId = paramString;
  }
  
  public String getHVendorName()
  {
    return this.hVendorName;
  }
  
  public void setHVendorName(String paramString)
  {
    this.hVendorName = paramString;
  }
  
  public String getHVendorNumber()
  {
    return this.hVendorNumber;
  }
  
  public void setHVendorNumber(String paramString)
  {
    this.hVendorNumber = paramString;
  }
  
  public String getHVendorSiteCode()
  {
    return this.hVendorSiteCode;
  }
  
  public void setHVendorSiteCode(String paramString)
  {
    this.hVendorSiteCode = paramString;
  }
  
  public String getHVendorSiteId()
  {
    return this.hVendorSiteId;
  }
  
  public void setHVendorSiteId(String paramString)
  {
    this.hVendorSiteId = paramString;
  }
  
  public String getHVersionNum()
  {
    return this.hVersionNum;
  }
  
  public void setHVersionNum(String paramString)
  {
    this.hVersionNum = paramString;
  }
  
  public String getLAccountCombinations()
  {
    return this.lAccountCombinations;
  }
  
  public void setLAccountCombinations(String paramString)
  {
    this.lAccountCombinations = paramString;
  }
  
  public String getLAccountCombinationsDebt()
  {
    return this.lAccountCombinationsDebt;
  }
  
  public void setLAccountCombinationsDebt(String paramString)
  {
    this.lAccountCombinationsDebt = paramString;
  }
  
  public String getLAccountCombinationsPayments()
  {
    return this.lAccountCombinationsPayments;
  }
  
  public void setLAccountCombinationsPayments(String paramString)
  {
    this.lAccountCombinationsPayments = paramString;
  }
  
  public String getLAccountCombinationsPrepay()
  {
    return this.lAccountCombinationsPrepay;
  }
  
  public void setLAccountCombinationsPrepay(String paramString)
  {
    this.lAccountCombinationsPrepay = paramString;
  }
  
  public String getLAccountSegment1()
  {
    return this.lAccountSegment1;
  }
  
  public void setLAccountSegment1(String paramString)
  {
    this.lAccountSegment1 = paramString;
  }
  
  public String getLAccountSegment2()
  {
    return this.lAccountSegment2;
  }
  
  public void setLAccountSegment2(String paramString)
  {
    this.lAccountSegment2 = paramString;
  }
  
  public String getLAccountSegment3()
  {
    return this.lAccountSegment3;
  }
  
  public void setLAccountSegment3(String paramString)
  {
    this.lAccountSegment3 = paramString;
  }
  
  public String getLAccountSegment4()
  {
    return this.lAccountSegment4;
  }
  
  public void setLAccountSegment4(String paramString)
  {
    this.lAccountSegment4 = paramString;
  }
  
  public String getLAccountSegment5()
  {
    return this.lAccountSegment5;
  }
  
  public void setLAccountSegment5(String paramString)
  {
    this.lAccountSegment5 = paramString;
  }
  
  public String getLAccountSegment6()
  {
    return this.lAccountSegment6;
  }
  
  public void setLAccountSegment6(String paramString)
  {
    this.lAccountSegment6 = paramString;
  }
  
  public String getLAccountSegment7()
  {
    return this.lAccountSegment7;
  }
  
  public void setLAccountSegment7(String paramString)
  {
    this.lAccountSegment7 = paramString;
  }
  
  public String getLAccruedTypeCode()
  {
    return this.lAccruedTypeCode;
  }
  
  public void setLAccruedTypeCode(String paramString)
  {
    this.lAccruedTypeCode = paramString;
  }
  
  public String getLAccruedTypeName()
  {
    return this.lAccruedTypeName;
  }
  
  public void setLAccruedTypeName(String paramString)
  {
    this.lAccruedTypeName = paramString;
  }
  
  public String getLActionDate()
  {
    return this.lActionDate;
  }
  
  public void setLActionDate(String paramString)
  {
    this.lActionDate = paramString;
  }
  
  public String getLAllPaymentAmount()
  {
    return this.lAllPaymentAmount;
  }
  
  public void setLAllPaymentAmount(String paramString)
  {
    this.lAllPaymentAmount = paramString;
  }
  
  public String getLAttribute1()
  {
    return this.lAttribute1;
  }
  
  public void setLAttribute1(String paramString)
  {
    this.lAttribute1 = paramString;
  }
  
  public String getLAttribute10()
  {
    return this.lAttribute10;
  }
  
  public void setLAttribute10(String paramString)
  {
    this.lAttribute10 = paramString;
  }
  
  public String getLAttribute11()
  {
    return this.lAttribute11;
  }
  
  public void setLAttribute11(String paramString)
  {
    this.lAttribute11 = paramString;
  }
  
  public String getLAttribute12()
  {
    return this.lAttribute12;
  }
  
  public void setLAttribute12(String paramString)
  {
    this.lAttribute12 = paramString;
  }
  
  public String getLAttribute13()
  {
    return this.lAttribute13;
  }
  
  public void setLAttribute13(String paramString)
  {
    this.lAttribute13 = paramString;
  }
  
  public String getLAttribute14()
  {
    return this.lAttribute14;
  }
  
  public void setLAttribute14(String paramString)
  {
    this.lAttribute14 = paramString;
  }
  
  public String getLAttribute15()
  {
    return this.lAttribute15;
  }
  
  public void setLAttribute15(String paramString)
  {
    this.lAttribute15 = paramString;
  }
  
  public String getLAttribute16()
  {
    return this.lAttribute16;
  }
  
  public void setLAttribute16(String paramString)
  {
    this.lAttribute16 = paramString;
  }
  
  public String getLAttribute17()
  {
    return this.lAttribute17;
  }
  
  public void setLAttribute17(String paramString)
  {
    this.lAttribute17 = paramString;
  }
  
  public String getLAttribute18()
  {
    return this.lAttribute18;
  }
  
  public void setLAttribute18(String paramString)
  {
    this.lAttribute18 = paramString;
  }
  
  public String getLAttribute19()
  {
    return this.lAttribute19;
  }
  
  public void setLAttribute19(String paramString)
  {
    this.lAttribute19 = paramString;
  }
  
  public String getLAttribute2()
  {
    return this.lAttribute2;
  }
  
  public void setLAttribute2(String paramString)
  {
    this.lAttribute2 = paramString;
  }
  
  public String getLAttribute20()
  {
    return this.lAttribute20;
  }
  
  public void setLAttribute20(String paramString)
  {
    this.lAttribute20 = paramString;
  }
  
  public String getLAttribute21()
  {
    return this.lAttribute21;
  }
  
  public void setLAttribute21(String paramString)
  {
    this.lAttribute21 = paramString;
  }
  
  public String getLAttribute22()
  {
    return this.lAttribute22;
  }
  
  public void setLAttribute22(String paramString)
  {
    this.lAttribute22 = paramString;
  }
  
  public String getLAttribute23()
  {
    return this.lAttribute23;
  }
  
  public void setLAttribute23(String paramString)
  {
    this.lAttribute23 = paramString;
  }
  
  public String getLAttribute24()
  {
    return this.lAttribute24;
  }
  
  public void setLAttribute24(String paramString)
  {
    this.lAttribute24 = paramString;
  }
  
  public String getLAttribute25()
  {
    return this.lAttribute25;
  }
  
  public void setLAttribute25(String paramString)
  {
    this.lAttribute25 = paramString;
  }
  
  public String getLAttribute26()
  {
    return this.lAttribute26;
  }
  
  public void setLAttribute26(String paramString)
  {
    this.lAttribute26 = paramString;
  }
  
  public String getLAttribute27()
  {
    return this.lAttribute27;
  }
  
  public void setLAttribute27(String paramString)
  {
    this.lAttribute27 = paramString;
  }
  
  public String getLAttribute28()
  {
    return this.lAttribute28;
  }
  
  public void setLAttribute28(String paramString)
  {
    this.lAttribute28 = paramString;
  }
  
  public String getLAttribute29()
  {
    return this.lAttribute29;
  }
  
  public void setLAttribute29(String paramString)
  {
    this.lAttribute29 = paramString;
  }
  
  public String getLAttribute3()
  {
    return this.lAttribute3;
  }
  
  public void setLAttribute3(String paramString)
  {
    this.lAttribute3 = paramString;
  }
  
  public String getLAttribute30()
  {
    return this.lAttribute30;
  }
  
  public void setLAttribute30(String paramString)
  {
    this.lAttribute30 = paramString;
  }
  
  public String getLAttribute4()
  {
    return this.lAttribute4;
  }
  
  public void setLAttribute4(String paramString)
  {
    this.lAttribute4 = paramString;
  }
  
  public String getLAttribute5()
  {
    return this.lAttribute5;
  }
  
  public void setLAttribute5(String paramString)
  {
    this.lAttribute5 = paramString;
  }
  
  public String getLAttribute6()
  {
    return this.lAttribute6;
  }
  
  public void setLAttribute6(String paramString)
  {
    this.lAttribute6 = paramString;
  }
  
  public String getLAttribute7()
  {
    return this.lAttribute7;
  }
  
  public void setLAttribute7(String paramString)
  {
    this.lAttribute7 = paramString;
  }
  
  public String getLAttribute8()
  {
    return this.lAttribute8;
  }
  
  public void setLAttribute8(String paramString)
  {
    this.lAttribute8 = paramString;
  }
  
  public String getLAttribute9()
  {
    return this.lAttribute9;
  }
  
  public void setLAttribute9(String paramString)
  {
    this.lAttribute9 = paramString;
  }
  
  public String getLAttributeCategory()
  {
    return this.lAttributeCategory;
  }
  
  public void setLAttributeCategory(String paramString)
  {
    this.lAttributeCategory = paramString;
  }
  
  public String getLBankAccountName()
  {
    return this.lBankAccountName;
  }
  
  public void setLBankAccountName(String paramString)
  {
    this.lBankAccountName = paramString;
  }
  
  public String getLBankAccountNum()
  {
    return this.lBankAccountNum;
  }
  
  public void setLBankAccountNum(String paramString)
  {
    this.lBankAccountNum = paramString;
  }
  
  public String getLBoeHeaderId()
  {
    return this.lBoeHeaderId;
  }
  
  public void setLBoeHeaderId(String paramString)
  {
    this.lBoeHeaderId = paramString;
  }
  
  public String getLBoeLineId()
  {
    return this.lBoeLineId;
  }
  
  public void setLBoeLineId(String paramString)
  {
    this.lBoeLineId = paramString;
  }
  
  public String getLBpCount()
  {
    return this.lBpCount;
  }
  
  public void setLBpCount(String paramString)
  {
    this.lBpCount = paramString;
  }
  
  public String getLBudgetItemName()
  {
    return this.lBudgetItemName;
  }
  
  public void setLBudgetItemName(String paramString)
  {
    this.lBudgetItemName = paramString;
  }
  
  public String getLBudgetItemsCode()
  {
    return this.lBudgetItemsCode;
  }
  
  public void setLBudgetItemsCode(String paramString)
  {
    this.lBudgetItemsCode = paramString;
  }
  
  public String getLConPayedAmount()
  {
    return this.lConPayedAmount;
  }
  
  public void setLConPayedAmount(String paramString)
  {
    this.lConPayedAmount = paramString;
  }
  
  public String getLConTotalAmount()
  {
    return this.lConTotalAmount;
  }
  
  public void setLConTotalAmount(String paramString)
  {
    this.lConTotalAmount = paramString;
  }
  
  public String getLContractHeaderId()
  {
    return this.lContractHeaderId;
  }
  
  public void setLContractHeaderId(String paramString)
  {
    this.lContractHeaderId = paramString;
  }
  
  public String getLContractName()
  {
    return this.lContractName;
  }
  
  public void setLContractName(String paramString)
  {
    this.lContractName = paramString;
  }
  
  public String getLContractNumber()
  {
    return this.lContractNumber;
  }
  
  public void setLContractNumber(String paramString)
  {
    this.lContractNumber = paramString;
  }
  
  public String getLCostDeptCode()
  {
    return this.lCostDeptCode;
  }
  
  public void setLCostDeptCode(String paramString)
  {
    this.lCostDeptCode = paramString;
  }
  
  public String getLCostDeptId()
  {
    return this.lCostDeptId;
  }
  
  public void setLCostDeptId(String paramString)
  {
    this.lCostDeptId = paramString;
  }
  
  public String getLCostDeptName()
  {
    return this.lCostDeptName;
  }
  
  public void setLCostDeptName(String paramString)
  {
    this.lCostDeptName = paramString;
  }
  
  public String getLCreatedBy()
  {
    return this.lCreatedBy;
  }
  
  public void setLCreatedBy(String paramString)
  {
    this.lCreatedBy = paramString;
  }
  
  public String getLCreationDate()
  {
    return this.lCreationDate;
  }
  
  public void setLCreationDate(String paramString)
  {
    this.lCreationDate = paramString;
  }
  
  public String getLCurrencyCode()
  {
    return this.lCurrencyCode;
  }
  
  public void setLCurrencyCode(String paramString)
  {
    this.lCurrencyCode = paramString;
  }
  
  public String getLCustomerBrand()
  {
    return this.lCustomerBrand;
  }
  
  public void setLCustomerBrand(String paramString)
  {
    this.lCustomerBrand = paramString;
  }
  
  public String getLCustomerBrandName()
  {
    return this.lCustomerBrandName;
  }
  
  public void setLCustomerBrandName(String paramString)
  {
    this.lCustomerBrandName = paramString;
  }
  
  public String getLDateAttribute1()
  {
    return this.lDateAttribute1;
  }
  
  public void setLDateAttribute1(String paramString)
  {
    this.lDateAttribute1 = paramString;
  }
  
  public String getLDateAttribute10()
  {
    return this.lDateAttribute10;
  }
  
  public void setLDateAttribute10(String paramString)
  {
    this.lDateAttribute10 = paramString;
  }
  
  public String getLDateAttribute2()
  {
    return this.lDateAttribute2;
  }
  
  public void setLDateAttribute2(String paramString)
  {
    this.lDateAttribute2 = paramString;
  }
  
  public String getLDateAttribute3()
  {
    return this.lDateAttribute3;
  }
  
  public void setLDateAttribute3(String paramString)
  {
    this.lDateAttribute3 = paramString;
  }
  
  public String getLDateAttribute4()
  {
    return this.lDateAttribute4;
  }
  
  public void setLDateAttribute4(String paramString)
  {
    this.lDateAttribute4 = paramString;
  }
  
  public String getLDateAttribute5()
  {
    return this.lDateAttribute5;
  }
  
  public void setLDateAttribute5(String paramString)
  {
    this.lDateAttribute5 = paramString;
  }
  
  public String getLDateAttribute6()
  {
    return this.lDateAttribute6;
  }
  
  public void setLDateAttribute6(String paramString)
  {
    this.lDateAttribute6 = paramString;
  }
  
  public String getLDateAttribute7()
  {
    return this.lDateAttribute7;
  }
  
  public void setLDateAttribute7(String paramString)
  {
    this.lDateAttribute7 = paramString;
  }
  
  public String getLDateAttribute8()
  {
    return this.lDateAttribute8;
  }
  
  public void setLDateAttribute8(String paramString)
  {
    this.lDateAttribute8 = paramString;
  }
  
  public String getLDateAttribute9()
  {
    return this.lDateAttribute9;
  }
  
  public void setLDateAttribute9(String paramString)
  {
    this.lDateAttribute9 = paramString;
  }
  
  public String getLDebitAmount()
  {
    return this.lDebitAmount;
  }
  
  public void setLDebitAmount(String paramString)
  {
    this.lDebitAmount = paramString;
  }
  
  public String getLEnabledFlag()
  {
    return this.lEnabledFlag;
  }
  
  public void setLEnabledFlag(String paramString)
  {
    this.lEnabledFlag = paramString;
  }
  
  public String getLExchangeRate()
  {
    return this.lExchangeRate;
  }
  
  public void setLExchangeRate(String paramString)
  {
    this.lExchangeRate = paramString;
  }
  
  public String getLExpenseAmount()
  {
    return this.lExpenseAmount;
  }
  
  public void setLExpenseAmount(String paramString)
  {
    this.lExpenseAmount = paramString;
  }
  
  public String getLExpenseDate()
  {
    return this.lExpenseDate;
  }
  
  public void setLExpenseDate(String paramString)
  {
    this.lExpenseDate = paramString;
  }
  
  public String getLFromBankAccountId()
  {
    return this.lFromBankAccountId;
  }
  
  public void setLFromBankAccountId(String paramString)
  {
    this.lFromBankAccountId = paramString;
  }
  
  public String getLInceptId()
  {
    return this.lInceptId;
  }
  
  public void setLInceptId(String paramString)
  {
    this.lInceptId = paramString;
  }
  
  public String getLInvoiceNum()
  {
    return this.lInvoiceNum;
  }
  
  public void setLInvoiceNum(String paramString)
  {
    this.lInvoiceNum = paramString;
  }
  
  public String getLLastUpdateDate()
  {
    return this.lLastUpdateDate;
  }
  
  public void setLLastUpdateDate(String paramString)
  {
    this.lLastUpdateDate = paramString;
  }
  
  public String getLLastUpdatedBy()
  {
    return this.lLastUpdatedBy;
  }
  
  public void setLLastUpdatedBy(String paramString)
  {
    this.lLastUpdatedBy = paramString;
  }
  
  public String getLLastUpdateLogin()
  {
    return this.lLastUpdateLogin;
  }
  
  public void setLLastUpdateLogin(String paramString)
  {
    this.lLastUpdateLogin = paramString;
  }
  
  public String getLLineAbstract()
  {
    return this.lLineAbstract;
  }
  
  public void setLLineAbstract(String paramString)
  {
    this.lLineAbstract = paramString;
  }
  
  public String getLLineQuantity()
  {
    return this.lLineQuantity;
  }
  
  public void setLLineQuantity(String paramString)
  {
    this.lLineQuantity = paramString;
  }
  
  public String getLLineType()
  {
    return this.lLineType;
  }
  
  public void setLLineType(String paramString)
  {
    this.lLineType = paramString;
  }
  
  public String getLLineTypeName()
  {
    return this.lLineTypeName;
  }
  
  public void setLLineTypeName(String paramString)
  {
    this.lLineTypeName = paramString;
  }
  
  public String getLLoanAmount()
  {
    return this.lLoanAmount;
  }
  
  public void setLLoanAmount(String paramString)
  {
    this.lLoanAmount = paramString;
  }
  
  public String getLMemoLinesId()
  {
    return this.lMemoLinesId;
  }
  
  public void setLMemoLinesId(String paramString)
  {
    this.lMemoLinesId = paramString;
  }
  
  public String getLMemoLinesName()
  {
    return this.lMemoLinesName;
  }
  
  public void setLMemoLinesName(String paramString)
  {
    this.lMemoLinesName = paramString;
  }
  
  public String getLNetAttribute()
  {
    return this.lNetAttribute;
  }
  
  public void setLNetAttribute(String paramString)
  {
    this.lNetAttribute = paramString;
  }
  
  public String getLNetAttributeName()
  {
    return this.lNetAttributeName;
  }
  
  public void setLNetAttributeName(String paramString)
  {
    this.lNetAttributeName = paramString;
  }
  
  public String getLNumberAttribute1()
  {
    return this.lNumberAttribute1;
  }
  
  public void setLNumberAttribute1(String paramString)
  {
    this.lNumberAttribute1 = paramString;
  }
  
  public String getLNumberAttribute10()
  {
    return this.lNumberAttribute10;
  }
  
  public void setLNumberAttribute10(String paramString)
  {
    this.lNumberAttribute10 = paramString;
  }
  
  public String getLNumberAttribute11()
  {
    return this.lNumberAttribute11;
  }
  
  public void setLNumberAttribute11(String paramString)
  {
    this.lNumberAttribute11 = paramString;
  }
  
  public String getLNumberAttribute12()
  {
    return this.lNumberAttribute12;
  }
  
  public void setLNumberAttribute12(String paramString)
  {
    this.lNumberAttribute12 = paramString;
  }
  
  public String getLNumberAttribute13()
  {
    return this.lNumberAttribute13;
  }
  
  public void setLNumberAttribute13(String paramString)
  {
    this.lNumberAttribute13 = paramString;
  }
  
  public String getLNumberAttribute14()
  {
    return this.lNumberAttribute14;
  }
  
  public void setLNumberAttribute14(String paramString)
  {
    this.lNumberAttribute14 = paramString;
  }
  
  public String getLNumberAttribute15()
  {
    return this.lNumberAttribute15;
  }
  
  public void setLNumberAttribute15(String paramString)
  {
    this.lNumberAttribute15 = paramString;
  }
  
  public String getLNumberAttribute16()
  {
    return this.lNumberAttribute16;
  }
  
  public void setLNumberAttribute16(String paramString)
  {
    this.lNumberAttribute16 = paramString;
  }
  
  public String getLNumberAttribute17()
  {
    return this.lNumberAttribute17;
  }
  
  public void setLNumberAttribute17(String paramString)
  {
    this.lNumberAttribute17 = paramString;
  }
  
  public String getLNumberAttribute18()
  {
    return this.lNumberAttribute18;
  }
  
  public void setLNumberAttribute18(String paramString)
  {
    this.lNumberAttribute18 = paramString;
  }
  
  public String getLNumberAttribute19()
  {
    return this.lNumberAttribute19;
  }
  
  public void setLNumberAttribute19(String paramString)
  {
    this.lNumberAttribute19 = paramString;
  }
  
  public String getLNumberAttribute2()
  {
    return this.lNumberAttribute2;
  }
  
  public void setLNumberAttribute2(String paramString)
  {
    this.lNumberAttribute2 = paramString;
  }
  
  public String getLNumberAttribute20()
  {
    return this.lNumberAttribute20;
  }
  
  public void setLNumberAttribute20(String paramString)
  {
    this.lNumberAttribute20 = paramString;
  }
  
  public String getLNumberAttribute3()
  {
    return this.lNumberAttribute3;
  }
  
  public void setLNumberAttribute3(String paramString)
  {
    this.lNumberAttribute3 = paramString;
  }
  
  public String getLNumberAttribute4()
  {
    return this.lNumberAttribute4;
  }
  
  public void setLNumberAttribute4(String paramString)
  {
    this.lNumberAttribute4 = paramString;
  }
  
  public String getLNumberAttribute5()
  {
    return this.lNumberAttribute5;
  }
  
  public void setLNumberAttribute5(String paramString)
  {
    this.lNumberAttribute5 = paramString;
  }
  
  public String getLNumberAttribute6()
  {
    return this.lNumberAttribute6;
  }
  
  public void setLNumberAttribute6(String paramString)
  {
    this.lNumberAttribute6 = paramString;
  }
  
  public String getLNumberAttribute7()
  {
    return this.lNumberAttribute7;
  }
  
  public void setLNumberAttribute7(String paramString)
  {
    this.lNumberAttribute7 = paramString;
  }
  
  public String getLNumberAttribute8()
  {
    return this.lNumberAttribute8;
  }
  
  public void setLNumberAttribute8(String paramString)
  {
    this.lNumberAttribute8 = paramString;
  }
  
  public String getLNumberAttribute9()
  {
    return this.lNumberAttribute9;
  }
  
  public void setLNumberAttribute9(String paramString)
  {
    this.lNumberAttribute9 = paramString;
  }
  
  public String getLOperationTypeCode()
  {
    return this.lOperationTypeCode;
  }
  
  public void setLOperationTypeCode(String paramString)
  {
    this.lOperationTypeCode = paramString;
  }
  
  public String getLOperationTypeId()
  {
    return this.lOperationTypeId;
  }
  
  public void setLOperationTypeId(String paramString)
  {
    this.lOperationTypeId = paramString;
  }
  
  public String getLOperationTypeName()
  {
    return this.lOperationTypeName;
  }
  
  public void setLOperationTypeName(String paramString)
  {
    this.lOperationTypeName = paramString;
  }
  
  public String getLOrderedAmount()
  {
    return this.lOrderedAmount;
  }
  
  public void setLOrderedAmount(String paramString)
  {
    this.lOrderedAmount = paramString;
  }
  
  public String getLPayoffDate()
  {
    return this.lPayoffDate;
  }
  
  public void setLPayoffDate(String paramString)
  {
    this.lPayoffDate = paramString;
  }
  
  public String getLPoAmount()
  {
    return this.lPoAmount;
  }
  
  public void setLPoAmount(String paramString)
  {
    this.lPoAmount = paramString;
  }
  
  public String getLPoHeaderId()
  {
    return this.lPoHeaderId;
  }
  
  public void setLPoHeaderId(String paramString)
  {
    this.lPoHeaderId = paramString;
  }
  
  public String getLPoNumber()
  {
    return this.lPoNumber;
  }
  
  public void setLPoNumber(String paramString)
  {
    this.lPoNumber = paramString;
  }
  
  public String getLPrepayType()
  {
    return this.lPrepayType;
  }
  
  public void setLPrepayType(String paramString)
  {
    this.lPrepayType = paramString;
  }
  
  public String getLPrepayTypeName()
  {
    return this.lPrepayTypeName;
  }
  
  public void setLPrepayTypeName(String paramString)
  {
    this.lPrepayTypeName = paramString;
  }
  
  public String getLProjectCode()
  {
    return this.lProjectCode;
  }
  
  public void setLProjectCode(String paramString)
  {
    this.lProjectCode = paramString;
  }
  
  public String getLProjectName()
  {
    return this.lProjectName;
  }
  
  public void setLProjectName(String paramString)
  {
    this.lProjectName = paramString;
  }
  
  public String getLReceiptBankAccountId()
  {
    return this.lReceiptBankAccountId;
  }
  
  public void setLReceiptBankAccountId(String paramString)
  {
    this.lReceiptBankAccountId = paramString;
  }
  
  public String getLReceiptMethod()
  {
    return this.lReceiptMethod;
  }
  
  public void setLReceiptMethod(String paramString)
  {
    this.lReceiptMethod = paramString;
  }
  
  public String getLReceiptMethodId()
  {
    return this.lReceiptMethodId;
  }
  
  public void setLReceiptMethodId(String paramString)
  {
    this.lReceiptMethodId = paramString;
  }
  
  public String getLReceivablesName()
  {
    return this.lReceivablesName;
  }
  
  public void setLReceivablesName(String paramString)
  {
    this.lReceivablesName = paramString;
  }
  
  public String getLReceivablesOrgId()
  {
    return this.lReceivablesOrgId;
  }
  
  public void setLReceivablesOrgId(String paramString)
  {
    this.lReceivablesOrgId = paramString;
  }
  
  public String getLReceivablesTrxId()
  {
    return this.lReceivablesTrxId;
  }
  
  public void setLReceivablesTrxId(String paramString)
  {
    this.lReceivablesTrxId = paramString;
  }
  
  public String getLReceivedAmount()
  {
    return this.lReceivedAmount;
  }
  
  public void setLReceivedAmount(String paramString)
  {
    this.lReceivedAmount = paramString;
  }
  
  public String getLTaskId()
  {
    return this.lTaskId;
  }
  
  public void setLTaskId(String paramString)
  {
    this.lTaskId = paramString;
  }
  
  public String getLTaskName()
  {
    return this.lTaskName;
  }
  
  public void setLTaskName(String paramString)
  {
    this.lTaskName = paramString;
  }
  
  public String getLTaskNumber()
  {
    return this.lTaskNumber;
  }
  
  public void setLTaskNumber(String paramString)
  {
    this.lTaskNumber = paramString;
  }
  
  public String getLTaxAmount()
  {
    return this.lTaxAmount;
  }
  
  public void setLTaxAmount(String paramString)
  {
    this.lTaxAmount = paramString;
  }
  
  public String getLTaxRate()
  {
    return this.lTaxRate;
  }
  
  public void setLTaxRate(String paramString)
  {
    this.lTaxRate = paramString;
  }
  
  public String getLTaxSort()
  {
    return this.lTaxSort;
  }
  
  public void setLTaxSort(String paramString)
  {
    this.lTaxSort = paramString;
  }
  
  public String getLTerritoryTypeCode()
  {
    return this.lTerritoryTypeCode;
  }
  
  public void setLTerritoryTypeCode(String paramString)
  {
    this.lTerritoryTypeCode = paramString;
  }
  
  public String getLTerritoryTypeName()
  {
    return this.lTerritoryTypeName;
  }
  
  public void setLTerritoryTypeName(String paramString)
  {
    this.lTerritoryTypeName = paramString;
  }
  
  public String getLToBankAccountId()
  {
    return this.lToBankAccountId;
  }
  
  public void setLToBankAccountId(String paramString)
  {
    this.lToBankAccountId = paramString;
  }
  
  public String getLTrafficTypeCode()
  {
    return this.lTrafficTypeCode;
  }
  
  public void setLTrafficTypeCode(String paramString)
  {
    this.lTrafficTypeCode = paramString;
  }
  
  public String getLTrafficTypeName()
  {
    return this.lTrafficTypeName;
  }
  
  public void setLTrafficTypeName(String paramString)
  {
    this.lTrafficTypeName = paramString;
  }
  
  public String getLUnitPrice()
  {
    return this.lUnitPrice;
  }
  
  public void setLUnitPrice(String paramString)
  {
    this.lUnitPrice = paramString;
  }
  
  public String getLVendorId()
  {
    return this.lVendorId;
  }
  
  public void setLVendorId(String paramString)
  {
    this.lVendorId = paramString;
  }
  
  public String getLVendorName()
  {
    return this.lVendorName;
  }
  
  public void setLVendorName(String paramString)
  {
    this.lVendorName = paramString;
  }
  
  public String getLVendorNumber()
  {
    return this.lVendorNumber;
  }
  
  public void setLVendorNumber(String paramString)
  {
    this.lVendorNumber = paramString;
  }
  
  public String getLVendorSiteCode()
  {
    return this.lVendorSiteCode;
  }
  
  public void setLVendorSiteCode(String paramString)
  {
    this.lVendorSiteCode = paramString;
  }
  
  public String getLVendorSiteId()
  {
    return this.lVendorSiteId;
  }
  
  public void setLVendorSiteId(String paramString)
  {
    this.lVendorSiteId = paramString;
  }
  
  public String getLVersionNum()
  {
    return this.lVersionNum;
  }
  
  public void setLVersionNum(String paramString)
  {
    this.lVersionNum = paramString;
  }
  
  public String getPAddress()
  {
    return this.pAddress;
  }
  
  public void setPAddress(String paramString)
  {
    this.pAddress = paramString;
  }
  
  public String getPApplyAmount()
  {
    return this.pApplyAmount;
  }
  
  public void setPApplyAmount(String paramString)
  {
    this.pApplyAmount = paramString;
  }
  
  public String getPAttribute1()
  {
    return this.pAttribute1;
  }
  
  public void setPAttribute1(String paramString)
  {
    this.pAttribute1 = paramString;
  }
  
  public String getPAttribute10()
  {
    return this.pAttribute10;
  }
  
  public void setPAttribute10(String paramString)
  {
    this.pAttribute10 = paramString;
  }
  
  public String getPAttribute2()
  {
    return this.pAttribute2;
  }
  
  public void setPAttribute2(String paramString)
  {
    this.pAttribute2 = paramString;
  }
  
  public String getPAttribute3()
  {
    return this.pAttribute3;
  }
  
  public void setPAttribute3(String paramString)
  {
    this.pAttribute3 = paramString;
  }
  
  public String getPAttribute4()
  {
    return this.pAttribute4;
  }
  
  public void setPAttribute4(String paramString)
  {
    this.pAttribute4 = paramString;
  }
  
  public String getPAttribute5()
  {
    return this.pAttribute5;
  }
  
  public void setPAttribute5(String paramString)
  {
    this.pAttribute5 = paramString;
  }
  
  public String getPAttribute6()
  {
    return this.pAttribute6;
  }
  
  public void setPAttribute6(String paramString)
  {
    this.pAttribute6 = paramString;
  }
  
  public String getPAttribute7()
  {
    return this.pAttribute7;
  }
  
  public void setPAttribute7(String paramString)
  {
    this.pAttribute7 = paramString;
  }
  
  public String getPAttribute8()
  {
    return this.pAttribute8;
  }
  
  public void setPAttribute8(String paramString)
  {
    this.pAttribute8 = paramString;
  }
  
  public String getPAttribute9()
  {
    return this.pAttribute9;
  }
  
  public void setPAttribute9(String paramString)
  {
    this.pAttribute9 = paramString;
  }
  
  public String getPAttributeCategory()
  {
    return this.pAttributeCategory;
  }
  
  public void setPAttributeCategory(String paramString)
  {
    this.pAttributeCategory = paramString;
  }
  
  public String getPBankAccountName()
  {
    return this.pBankAccountName;
  }
  
  public void setPBankAccountName(String paramString)
  {
    this.pBankAccountName = paramString;
  }
  
  public String getPBankAccountNum()
  {
    return this.pBankAccountNum;
  }
  
  public void setPBankAccountNum(String paramString)
  {
    this.pBankAccountNum = paramString;
  }
  
  public String getPBankAccountType()
  {
    return this.pBankAccountType;
  }
  
  public void setPBankAccountType(String paramString)
  {
    this.pBankAccountType = paramString;
  }
  
  public String getPBankBranchName()
  {
    return this.pBankBranchName;
  }
  
  public void setPBankBranchName(String paramString)
  {
    this.pBankBranchName = paramString;
  }
  
  public String getPBankName()
  {
    return this.pBankName;
  }
  
  public void setPBankName(String paramString)
  {
    this.pBankName = paramString;
  }
  
  public String getPBoeHeaderId()
  {
    return this.pBoeHeaderId;
  }
  
  public void setPBoeHeaderId(String paramString)
  {
    this.pBoeHeaderId = paramString;
  }
  
  public String getPBoeLineId()
  {
    return this.pBoeLineId;
  }
  
  public void setPBoeLineId(String paramString)
  {
    this.pBoeLineId = paramString;
  }
  
  public String getPBoePaymentId()
  {
    return this.pBoePaymentId;
  }
  
  public void setPBoePaymentId(String paramString)
  {
    this.pBoePaymentId = paramString;
  }
  
  public String getPCity()
  {
    return this.pCity;
  }
  
  public void setPCity(String paramString)
  {
    this.pCity = paramString;
  }
  
  public String getPCountry()
  {
    return this.pCountry;
  }
  
  public void setPCountry(String paramString)
  {
    this.pCountry = paramString;
  }
  
  public String getPCreatedBy()
  {
    return this.pCreatedBy;
  }
  
  public void setPCreatedBy(String paramString)
  {
    this.pCreatedBy = paramString;
  }
  
  public String getPCreationDate()
  {
    return this.pCreationDate;
  }
  
  public void setPCreationDate(String paramString)
  {
    this.pCreationDate = paramString;
  }
  
  public String getPCurrencyCode()
  {
    return this.pCurrencyCode;
  }
  
  public void setPCurrencyCode(String paramString)
  {
    this.pCurrencyCode = paramString;
  }
  
  public String getPDescription()
  {
    return this.pDescription;
  }
  
  public void setPDescription(String paramString)
  {
    this.pDescription = paramString;
  }
  
  public String getPEnabledFlag()
  {
    return this.pEnabledFlag;
  }
  
  public void setPEnabledFlag(String paramString)
  {
    this.pEnabledFlag = paramString;
  }
  
  public String getPInvoiceId()
  {
    return this.pInvoiceId;
  }
  
  public void setPInvoiceId(String paramString)
  {
    this.pInvoiceId = paramString;
  }
  
  public String getPLastUpdateDate()
  {
    return this.pLastUpdateDate;
  }
  
  public void setPLastUpdateDate(String paramString)
  {
    this.pLastUpdateDate = paramString;
  }
  
  public String getPLastUpdatedBy()
  {
    return this.pLastUpdatedBy;
  }
  
  public void setPLastUpdatedBy(String paramString)
  {
    this.pLastUpdatedBy = paramString;
  }
  
  public String getPLastUpdateLogin()
  {
    return this.pLastUpdateLogin;
  }
  
  public void setPLastUpdateLogin(String paramString)
  {
    this.pLastUpdateLogin = paramString;
  }
  
  public String getPMemo()
  {
    return this.pMemo;
  }
  
  public void setPMemo(String paramString)
  {
    this.pMemo = paramString;
  }
  
  public String getPNumericalAttribute1()
  {
    return this.pNumericalAttribute1;
  }
  
  public void setPNumericalAttribute1(String paramString)
  {
    this.pNumericalAttribute1 = paramString;
  }
  
  public String getPNumericalAttribute10()
  {
    return this.pNumericalAttribute10;
  }
  
  public void setPNumericalAttribute10(String paramString)
  {
    this.pNumericalAttribute10 = paramString;
  }
  
  public String getPNumericalAttribute2()
  {
    return this.pNumericalAttribute2;
  }
  
  public void setPNumericalAttribute2(String paramString)
  {
    this.pNumericalAttribute2 = paramString;
  }
  
  public String getPNumericalAttribute3()
  {
    return this.pNumericalAttribute3;
  }
  
  public void setPNumericalAttribute3(String paramString)
  {
    this.pNumericalAttribute3 = paramString;
  }
  
  public String getPNumericalAttribute4()
  {
    return this.pNumericalAttribute4;
  }
  
  public void setPNumericalAttribute4(String paramString)
  {
    this.pNumericalAttribute4 = paramString;
  }
  
  public String getPNumericalAttribute5()
  {
    return this.pNumericalAttribute5;
  }
  
  public void setPNumericalAttribute5(String paramString)
  {
    this.pNumericalAttribute5 = paramString;
  }
  
  public String getPNumericalAttribute6()
  {
    return this.pNumericalAttribute6;
  }
  
  public void setPNumericalAttribute6(String paramString)
  {
    this.pNumericalAttribute6 = paramString;
  }
  
  public String getPNumericalAttribute7()
  {
    return this.pNumericalAttribute7;
  }
  
  public void setPNumericalAttribute7(String paramString)
  {
    this.pNumericalAttribute7 = paramString;
  }
  
  public String getPNumericalAttribute8()
  {
    return this.pNumericalAttribute8;
  }
  
  public void setPNumericalAttribute8(String paramString)
  {
    this.pNumericalAttribute8 = paramString;
  }
  
  public String getPNumericalAttribute9()
  {
    return this.pNumericalAttribute9;
  }
  
  public void setPNumericalAttribute9(String paramString)
  {
    this.pNumericalAttribute9 = paramString;
  }
  
  public String getPPayee()
  {
    return this.pPayee;
  }
  
  public void setPPayee(String paramString)
  {
    this.pPayee = paramString;
  }
  
  public String getPPaymentAmount()
  {
    return this.pPaymentAmount;
  }
  
  public void setPPaymentAmount(String paramString)
  {
    this.pPaymentAmount = paramString;
  }
  
  public String getPPaymentDate()
  {
    return this.pPaymentDate;
  }
  
  public void setPPaymentDate(String paramString)
  {
    this.pPaymentDate = paramString;
  }
  
  public String getPPaymentModeCode()
  {
    return this.pPaymentModeCode;
  }
  
  public void setPPaymentModeCode(String paramString)
  {
    this.pPaymentModeCode = paramString;
  }
  
  public String getPPaymentModeName()
  {
    return this.pPaymentModeName;
  }
  
  public void setPPaymentModeName(String paramString)
  {
    this.pPaymentModeName = paramString;
  }
  
  public String getPPaymentStatus()
  {
    return this.pPaymentStatus;
  }
  
  public void setPPaymentStatus(String paramString)
  {
    this.pPaymentStatus = paramString;
  }
  
  public String getPPaymentTypeCode()
  {
    return this.pPaymentTypeCode;
  }
  
  public void setPPaymentTypeCode(String paramString)
  {
    this.pPaymentTypeCode = paramString;
  }
  
  public String getPPaymentTypeName()
  {
    return this.pPaymentTypeName;
  }
  
  public void setPPaymentTypeName(String paramString)
  {
    this.pPaymentTypeName = paramString;
  }
  
  public String getPProvince()
  {
    return this.pProvince;
  }
  
  public void setPProvince(String paramString)
  {
    this.pProvince = paramString;
  }
  
  public String getPSourceBoeHeaderId()
  {
    return this.pSourceBoeHeaderId;
  }
  
  public void setPSourceBoeHeaderId(String paramString)
  {
    this.pSourceBoeHeaderId = paramString;
  }
  
  public String getPVendorCode()
  {
    return this.pVendorCode;
  }
  
  public void setPVendorCode(String paramString)
  {
    this.pVendorCode = paramString;
  }
  
  public String getPVendorName()
  {
    return this.pVendorName;
  }
  
  public void setPVendorName(String paramString)
  {
    this.pVendorName = paramString;
  }
  
  public String getPVendorSiteName()
  {
    return this.pVendorSiteName;
  }
  
  public void setPVendorSiteName(String paramString)
  {
    this.pVendorSiteName = paramString;
  }
  
  public String getPVersionNum()
  {
    return this.pVersionNum;
  }
  
  public void setPVersionNum(String paramString)
  {
    this.pVersionNum = paramString;
  }
  
  public String getCommonLineHtml()
  {
    return this.commonLineHtml;
  }
  
  public void setCommonLineHtml(String paramString)
  {
    this.commonLineHtml = paramString;
  }
  
  public String getCommonTotal()
  {
    return this.commonTotal;
  }
  
  public void setCommonTotal(String paramString)
  {
    this.commonTotal = paramString;
  }
  
  private String formatMoney(String paramString)
    throws Exception
  {
    DecimalFormat localDecimalFormat = new DecimalFormat();
    if ((paramString == null) || ("".equals(paramString))) {
      return "0.00";
    }
    if (paramString.equals("-0.00")) {
      return "0.00";
    }
    Double localDouble = Double.valueOf(Double.parseDouble(paramString));
    localDecimalFormat.applyPattern("#,##0.00");
    return localDecimalFormat.format(localDouble);
  }
  
  public String getCommonTotal1()
  {
    return this.commonTotal1;
  }
  
  public void setCommonTotal1(String paramString)
  {
    this.commonTotal1 = paramString;
  }
  
  public String getCommonTotal2()
  {
    return this.commonTotal2;
  }
  
  public void setCommonTotal2(String paramString)
  {
    this.commonTotal2 = paramString;
  }
  
  public String getCommonTotal3()
  {
    return this.commonTotal3;
  }
  
  public void setCommonTotal3(String paramString)
  {
    this.commonTotal3 = paramString;
  }
  
  public String getHBrandName()
  {
    return this.hBrandName;
  }
  
  public void setHBrandName(String paramString)
  {
    this.hBrandName = paramString;
  }
  
  public String getHAppraiseProjectCode()
  {
    return this.hAppraiseProjectCode;
  }
  
  public void setHAppraiseProjectCode(String paramString)
  {
    this.hAppraiseProjectCode = paramString;
  }
  
  public String getHAppraiseProjectName()
  {
    return this.hAppraiseProjectName;
  }
  
  public void setHAppraiseProjectName(String paramString)
  {
    this.hAppraiseProjectName = paramString;
  }
  
  public String getHAssetFromOrgId()
  {
    return this.hAssetFromOrgId;
  }
  
  public void setHAssetFromOrgId(String paramString)
  {
    this.hAssetFromOrgId = paramString;
  }
  
  public String getHAssetFromOrgName()
  {
    return this.hAssetFromOrgName;
  }
  
  public void setHAssetFromOrgName(String paramString)
  {
    this.hAssetFromOrgName = paramString;
  }
  
  public String getHAssetToDeptId()
  {
    return this.hAssetToDeptId;
  }
  
  public void setHAssetToDeptId(String paramString)
  {
    this.hAssetToDeptId = paramString;
  }
  
  public String getHAssetToDeptName()
  {
    return this.hAssetToDeptName;
  }
  
  public void setHAssetToDeptName(String paramString)
  {
    this.hAssetToDeptName = paramString;
  }
  
  public String getHAssetToOrgId()
  {
    return this.hAssetToOrgId;
  }
  
  public void setHAssetToOrgId(String paramString)
  {
    this.hAssetToOrgId = paramString;
  }
  
  public String getHAssetToOrgName()
  {
    return this.hAssetToOrgName;
  }
  
  public void setHAssetToOrgName(String paramString)
  {
    this.hAssetToOrgName = paramString;
  }
  
  public String getHDescription()
  {
    return this.hDescription;
  }
  
  public void setHDescription(String paramString)
  {
    this.hDescription = paramString;
  }
  
  public String getHAccompanyPersonIds()
  {
    return this.hAccompanyPersonIds;
  }
  
  public void setHAccompanyPersonIds(String paramString)
  {
    this.hAccompanyPersonIds = paramString;
  }
  
  public String getHAccompanyPersonName()
  {
    return this.hAccompanyPersonName;
  }
  
  public void setHAccompanyPersonName(String paramString)
  {
    this.hAccompanyPersonName = paramString;
  }
  
  public String getHErrandTypeCode()
  {
    return this.hErrandTypeCode;
  }
  
  public void setHErrandTypeCode(String paramString)
  {
    this.hErrandTypeCode = paramString;
  }
  
  public String getHErrandTypeName()
  {
    return this.hErrandTypeName;
  }
  
  public void setHErrandTypeName(String paramString)
  {
    this.hErrandTypeName = paramString;
  }
  
  private String formatDate(String paramString)
    throws ParseException
  {
    DateFormat.getDateTimeInstance();
    DateFormat localDateFormat1 = DateFormat.getDateTimeInstance(2, 2, Locale.CHINESE);
    DateFormat localDateFormat2 = null;
    if ((paramString == null) || (paramString.equals(""))) {
      return "";
    }
    localDateFormat2 = DateFormat.getDateInstance(2, Locale.CHINESE);
    localDateFormat1.setLenient(false);
    Date localDate = localDateFormat1.parse(paramString);
    return localDateFormat2.format(localDate);
  }
  
  public String getCommonTotal4()
  {
    return this.commonTotal4;
  }
  
  public void setCommonTotal4(String paramString)
  {
    this.commonTotal4 = paramString;
  }
  
  public String getCommonTotal5()
  {
    return this.commonTotal5;
  }
  
  public void setCommonTotal5(String paramString)
  {
    this.commonTotal5 = paramString;
  }
  
  public String getCommonTotal6()
  {
    return this.commonTotal6;
  }
  
  public void setCommonTotal6(String paramString)
  {
    this.commonTotal6 = paramString;
  }
  
  public String getHPaymentTypeName()
  {
    return this.hPaymentTypeName;
  }
  
  public void setHPaymentTypeName(String paramString)
  {
    this.hPaymentTypeName = paramString;
  }
  
  public String getHBApplyAmount()
  {
    return this.hBApplyAmount;
  }
  
  public void setHBApplyAmount(String paramString)
  {
    try
    {
      paramString = paramString.replaceAll(",", "");
      if (!paramString.equals("")) {}
      Trans2RMB localTrans2RMB = new Trans2RMB();
      this.hBApplyAmount = localTrans2RMB.cleanZero(localTrans2RMB.splitNum(localTrans2RMB.roundString(paramString)));
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public String getHApplyNum()
  {
    return this.hApplyNum;
  }
  
  public void setHApplyNum(String paramString)
  {
    this.hApplyNum = paramString;
  }
  
  public String getHApplyDesc()
  {
    return this.hApplyDesc;
  }
  
  public void setHApplyDesc(String paramString)
  {
    this.hApplyDesc = paramString;
  }
  
  public String getLOuName()
  {
    return this.lOuName;
  }
  
  public void setLOuName(String paramString)
  {
    this.lOuName = paramString;
  }
  
  public String getLSubDocName()
  {
    return this.lSubDocName;
  }
  
  public void setLSubDocName(String paramString)
  {
    this.lSubDocName = paramString;
  }
  
  public String getLJournalNum()
  {
    return this.lJournalNum;
  }
  
  public void setLJournalNum(String paramString)
  {
    this.lJournalNum = paramString;
  }
  
  public Date getHApplyDate()
  {
    return this.hApplyDate;
  }
  
  public void setHApplyDate(Date paramDate)
  {
    this.hApplyDate = paramDate;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.hnyd.business.print.model.CommonPrintModel
 * JD-Core Version:    0.7.0.1
 */