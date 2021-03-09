package com.zte.evs.business.month.service;

import com.zte.evs.access.month.IEvsVoucherMonthVDAO;
import com.zte.evs.business.month.model.EvsVoucherMonthV;
import com.zte.ssb.framework.base.BaseDomainService;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EvsVoucherMonthVDS
  extends BaseDomainService
  implements IEvsVoucherMonthVDS
{
  private IEvsVoucherMonthVDAO evsVoucherMonthVDAO;
  
  public void setEvsVoucherMonthVDAO(IEvsVoucherMonthVDAO paramIEvsVoucherMonthVDAO)
  {
    super.setDao(paramIEvsVoucherMonthVDAO);
    this.evsVoucherMonthVDAO = paramIEvsVoucherMonthVDAO;
  }
  
  public List<EvsVoucherMonthV> getEvsVoucherMonthVs(int paramInt1, int paramInt2)
  {
    return this.evsVoucherMonthVDAO.getEvsVoucherMonthVs(paramInt1, paramInt2);
  }
  
  public List<EvsVoucherMonthV> getEvsVoucherMonthVs()
  {
    return this.evsVoucherMonthVDAO.getEvsVoucherMonthVs();
  }
  
  public EvsVoucherMonthV getEvsVoucherMonthV(BigInteger paramBigInteger)
  {
    return this.evsVoucherMonthVDAO.getEvsVoucherMonthV(paramBigInteger);
  }
  
  public void removeEvsVoucherMonthV(BigInteger paramBigInteger)
  {
    this.evsVoucherMonthVDAO.removeEvsVoucherMonthV(paramBigInteger);
  }
  
  public void removeEvsVoucherMonthV(EvsVoucherMonthV paramEvsVoucherMonthV)
  {
    this.evsVoucherMonthVDAO.removeEvsVoucherMonthV(paramEvsVoucherMonthV);
  }
  
  public void insertEvsVoucherMonthV(EvsVoucherMonthV paramEvsVoucherMonthV)
  {
    this.evsVoucherMonthVDAO.insertEvsVoucherMonthV(paramEvsVoucherMonthV);
  }
  
  public void updateEvsVoucherMonthV(EvsVoucherMonthV paramEvsVoucherMonthV)
  {
    this.evsVoucherMonthVDAO.updateEvsVoucherMonthV(paramEvsVoucherMonthV);
  }
  
  public void insertEvsVoucherMonthVs(List<EvsVoucherMonthV> paramList)
  {
    this.evsVoucherMonthVDAO.insertEvsVoucherMonthVs(paramList);
  }
  
  public void removeEvsVoucherMonthVs(List<EvsVoucherMonthV> paramList)
  {
    this.evsVoucherMonthVDAO.removeEvsVoucherMonthVs(paramList);
  }
  
  public void updateEvsVoucherMonthVs(List<EvsVoucherMonthV> paramList)
  {
    this.evsVoucherMonthVDAO.updateEvsVoucherMonthVs(paramList);
  }
  
  public void removeEvsVoucherMonthV() {}
  
  public IEvsVoucherMonthVDAO getEvsVoucherMonthVDAO()
  {
    return this.evsVoucherMonthVDAO;
  }
  
  public List findDownDeptsVl(String paramString)
  {
    if (paramString == null) {
      paramString = "0";
    }
    return this.evsVoucherMonthVDAO.findDownDeptsVl(new BigInteger(paramString));
  }
  
  public List findMonthById(String paramString1, String paramString2, String paramString3)
  {
    return this.evsVoucherMonthVDAO.findMonthById(paramString1, paramString2, paramString3);
  }
  
  public List findById(String paramString)
  {
    return this.evsVoucherMonthVDAO.findById(new BigInteger(paramString));
  }
  
  public List findMonthFasciculeByQry()
  {
    ArrayList localArrayList = new ArrayList();
    EvsVoucherMonthV localEvsVoucherMonthV1 = new EvsVoucherMonthV();
    localEvsVoucherMonthV1.setPosStruElementId("2011");
    localEvsVoucherMonthV1.setPosStruElementName("2011");
    EvsVoucherMonthV localEvsVoucherMonthV2 = new EvsVoucherMonthV();
    localEvsVoucherMonthV2.setPosStruElementId("01");
    localEvsVoucherMonthV2.setPosStruElementName("1月");
    localEvsVoucherMonthV2.setParentDeptId(BigInteger.valueOf(2011L));
    localEvsVoucherMonthV2.setParentDeptName("2011");
    EvsVoucherMonthV localEvsVoucherMonthV3 = new EvsVoucherMonthV();
    localEvsVoucherMonthV3.setPosStruElementId("02");
    localEvsVoucherMonthV3.setPosStruElementName("2月");
    localEvsVoucherMonthV3.setParentDeptId(BigInteger.valueOf(2011L));
    localEvsVoucherMonthV3.setParentDeptName("2011");
    EvsVoucherMonthV localEvsVoucherMonthV4 = new EvsVoucherMonthV();
    localEvsVoucherMonthV4.setPosStruElementId("03");
    localEvsVoucherMonthV4.setPosStruElementName("3月");
    localEvsVoucherMonthV4.setParentDeptId(BigInteger.valueOf(2011L));
    localEvsVoucherMonthV4.setParentDeptName("2011");
    EvsVoucherMonthV localEvsVoucherMonthV5 = new EvsVoucherMonthV();
    localEvsVoucherMonthV5.setPosStruElementId("04");
    localEvsVoucherMonthV5.setPosStruElementName("4月");
    localEvsVoucherMonthV5.setParentDeptId(BigInteger.valueOf(2011L));
    localEvsVoucherMonthV5.setParentDeptName("2011");
    EvsVoucherMonthV localEvsVoucherMonthV6 = new EvsVoucherMonthV();
    localEvsVoucherMonthV6.setPosStruElementId("05");
    localEvsVoucherMonthV6.setPosStruElementName("5月");
    localEvsVoucherMonthV6.setParentDeptId(BigInteger.valueOf(2011L));
    localEvsVoucherMonthV6.setParentDeptName("2011");
    EvsVoucherMonthV localEvsVoucherMonthV7 = new EvsVoucherMonthV();
    localEvsVoucherMonthV7.setPosStruElementId("06");
    localEvsVoucherMonthV7.setPosStruElementName("6月");
    localEvsVoucherMonthV7.setParentDeptId(BigInteger.valueOf(2011L));
    localEvsVoucherMonthV7.setParentDeptName("2011");
    EvsVoucherMonthV localEvsVoucherMonthV8 = new EvsVoucherMonthV();
    localEvsVoucherMonthV8.setPosStruElementId("07");
    localEvsVoucherMonthV8.setPosStruElementName("7月");
    localEvsVoucherMonthV8.setParentDeptId(BigInteger.valueOf(2011L));
    localEvsVoucherMonthV8.setParentDeptName("2011");
    EvsVoucherMonthV localEvsVoucherMonthV9 = new EvsVoucherMonthV();
    localEvsVoucherMonthV9.setPosStruElementId("08");
    localEvsVoucherMonthV9.setPosStruElementName("8月");
    localEvsVoucherMonthV9.setParentDeptId(BigInteger.valueOf(2011L));
    localEvsVoucherMonthV9.setParentDeptName("2011");
    EvsVoucherMonthV localEvsVoucherMonthV10 = new EvsVoucherMonthV();
    localEvsVoucherMonthV10.setPosStruElementId("09");
    localEvsVoucherMonthV10.setPosStruElementName("9月");
    localEvsVoucherMonthV10.setParentDeptId(BigInteger.valueOf(2011L));
    localEvsVoucherMonthV10.setParentDeptName("2011");
    EvsVoucherMonthV localEvsVoucherMonthV11 = new EvsVoucherMonthV();
    localEvsVoucherMonthV11.setPosStruElementId("10");
    localEvsVoucherMonthV11.setPosStruElementName("10月");
    localEvsVoucherMonthV11.setParentDeptId(BigInteger.valueOf(2011L));
    localEvsVoucherMonthV11.setParentDeptName("2011");
    EvsVoucherMonthV localEvsVoucherMonthV12 = new EvsVoucherMonthV();
    localEvsVoucherMonthV12.setPosStruElementId("11");
    localEvsVoucherMonthV12.setPosStruElementName("11月");
    localEvsVoucherMonthV12.setParentDeptId(BigInteger.valueOf(2011L));
    localEvsVoucherMonthV12.setParentDeptName("2011");
    EvsVoucherMonthV localEvsVoucherMonthV13 = new EvsVoucherMonthV();
    localEvsVoucherMonthV13.setPosStruElementId("12");
    localEvsVoucherMonthV13.setPosStruElementName("12月");
    localEvsVoucherMonthV13.setParentDeptId(BigInteger.valueOf(2011L));
    localEvsVoucherMonthV13.setParentDeptName("2011");
    localArrayList.add(localEvsVoucherMonthV2);
    localArrayList.add(localEvsVoucherMonthV3);
    localArrayList.add(localEvsVoucherMonthV4);
    localArrayList.add(localEvsVoucherMonthV5);
    localArrayList.add(localEvsVoucherMonthV6);
    localArrayList.add(localEvsVoucherMonthV7);
    localArrayList.add(localEvsVoucherMonthV8);
    localArrayList.add(localEvsVoucherMonthV9);
    localArrayList.add(localEvsVoucherMonthV10);
    localArrayList.add(localEvsVoucherMonthV11);
    localArrayList.add(localEvsVoucherMonthV12);
    localArrayList.add(localEvsVoucherMonthV13);
    return localArrayList;
  }
  
  public List findDeptsVById()
  {
    List localList = this.evsVoucherMonthVDAO.findDeptsVById();
    return localList;
  }
  
  public List findEvsVoucherMonthVById(String paramString)
  {
    List localList = this.evsVoucherMonthVDAO.findEvsVoucherMonthVById(paramString);
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      EvsVoucherMonthV localEvsVoucherMonthV = (EvsVoucherMonthV)localIterator.next();
      if (localEvsVoucherMonthV.getBookNumber() == null) {
        localEvsVoucherMonthV.setBookNumber(BigDecimal.valueOf(0L));
      }
      if (localEvsVoucherMonthV.getMarkNumber() == null) {
        localEvsVoucherMonthV.setMarkNumber(BigDecimal.valueOf(0L));
      }
      if (localEvsVoucherMonthV.getBooknotNumber() == null) {
        localEvsVoucherMonthV.setBooknotNumber(BigDecimal.valueOf(0L));
      }
    }
    return localList;
  }
  
  public List findAllEvsVoucherMonthV()
  {
    List localList = this.evsVoucherMonthVDAO.findAllEvsVoucherMonthV();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      EvsVoucherMonthV localEvsVoucherMonthV = (EvsVoucherMonthV)localIterator.next();
      if (localEvsVoucherMonthV.getBookNumber() == null) {
        localEvsVoucherMonthV.setBookNumber(BigDecimal.valueOf(0L));
      }
      if (localEvsVoucherMonthV.getMarkNumber() == null) {
        localEvsVoucherMonthV.setMarkNumber(BigDecimal.valueOf(0L));
      }
      if (localEvsVoucherMonthV.getBooknotNumber() == null) {
        localEvsVoucherMonthV.setBooknotNumber(BigDecimal.valueOf(0L));
      }
    }
    return localList;
  }
  
  public List findById(String paramString1, String paramString2, String paramString3)
  {
    return null;
  }
  
  public List findEvsVoucherByMonthV(String paramString1, String paramString2)
  {
    List localList = this.evsVoucherMonthVDAO.findEvsVoucherByMonthV(paramString1, paramString2);
    return localList;
  }
  
  public List findEvsVoucherByYearV(String paramString1, String paramString2)
  {
    List localList = this.evsVoucherMonthVDAO.findEvsVoucherByYearV(paramString1, paramString2);
    return localList;
  }
  
  public List fasciculeQuaryInfoByPZ(String paramString1, String paramString2, String paramString3)
  {
    return this.evsVoucherMonthVDAO.fasciculeQuaryInfoByPZ(paramString1, paramString2, paramString3);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.business.month.service.EvsVoucherMonthVDS
 * JD-Core Version:    0.7.0.1
 */