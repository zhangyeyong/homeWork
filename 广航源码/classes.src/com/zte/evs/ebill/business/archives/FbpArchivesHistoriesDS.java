package com.zte.evs.ebill.business.archives;

import com.zte.evs.ebill.access.archives.IFbpArchivesHistoriesDAO;
import com.zte.evs.ebill.model.archives.FbpArchivesHistories;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.BaseDomainService;
import com.zte.ssb.framework.base.util.PageInfo;
import java.util.ArrayList;
import java.util.List;

public class FbpArchivesHistoriesDS
  extends BaseDomainService
  implements IFbpArchivesHistoriesDS
{
  private IFbpArchivesHistoriesDAO fbpArchivesHistoriesDAO;
  static final String DO = "同意";
  static final String BAN = "不同意";
  static final String SUBMIT = "COMMIT";
  static final String SUBMIT_ZH = "提交";
  static final String WAIT_REVERT_ZH = "领用";
  static final String ALREADY_REVERT_ZH = "归还";
  static final String ALREADY_CANCEL_ZH = "作废";
  static final String DIS_AGREE = "DIS_AGREE";
  static final String AGREE = "AGREE";
  static final String WAIT_REVERT = "ARCHIVES_WAIT_REVERT";
  static final String ALREADY_REVERT = "ARCHIVES_ALREADY_REVERT";
  static final String ALREADY_CANCEL = "ARCHIVES_ALREADY_CANCEL";
  
  public void setFbpArchivesHistoriesDAO(IFbpArchivesHistoriesDAO paramIFbpArchivesHistoriesDAO)
  {
    super.setDao(paramIFbpArchivesHistoriesDAO);
    this.fbpArchivesHistoriesDAO = paramIFbpArchivesHistoriesDAO;
  }
  
  public TableDataInfo findFbpArchivesHistories(FbpArchivesHistories paramFbpArchivesHistories, int paramInt1, int paramInt2)
  {
    String str = "";
    TableDataInfo localTableDataInfo = new TableDataInfo();
    PageInfo localPageInfo = this.fbpArchivesHistoriesDAO.findFbpArchivesHistories(paramFbpArchivesHistories, paramInt1, paramInt2);
    List localList = (List)localPageInfo.getResult();
    for (int i = 0; i < localList.size(); i++)
    {
      FbpArchivesHistories localFbpArchivesHistories = (FbpArchivesHistories)localList.get(i);
      if (localFbpArchivesHistories.getApproveComment() == null) {
        str = "";
      } else {
        str = localFbpArchivesHistories.getApproveComment();
      }
      if (localFbpArchivesHistories.getApproveCommand() == null)
      {
        if (localFbpArchivesHistories.getArchivesStatus().equalsIgnoreCase("ARCHIVES_WAIT_REVERT")) {
          if (str != "") {
            localFbpArchivesHistories.setApproveCommand("领用," + str);
          } else {
            localFbpArchivesHistories.setApproveCommand("领用");
          }
        }
        if (localFbpArchivesHistories.getArchivesStatus().equalsIgnoreCase("ARCHIVES_ALREADY_REVERT")) {
          if (str != "") {
            localFbpArchivesHistories.setApproveCommand("归还," + str);
          } else {
            localFbpArchivesHistories.setApproveCommand("归还");
          }
        }
        if (localFbpArchivesHistories.getArchivesStatus().equalsIgnoreCase("ARCHIVES_ALREADY_CANCEL")) {
          if (str != "") {
            localFbpArchivesHistories.setApproveCommand("作废," + str);
          } else {
            localFbpArchivesHistories.setApproveCommand("作废");
          }
        }
      }
      if ((localFbpArchivesHistories.getApproveCommand() != null) && (localFbpArchivesHistories.getApproveCommand().equalsIgnoreCase("DIS_AGREE"))) {
        if (str != "") {
          localFbpArchivesHistories.setApproveCommand("不同意," + str);
        } else {
          localFbpArchivesHistories.setApproveCommand("不同意");
        }
      }
      if ((localFbpArchivesHistories.getApproveCommand() != null) && (localFbpArchivesHistories.getApproveCommand().equalsIgnoreCase("AGREE"))) {
        if (str != "") {
          localFbpArchivesHistories.setApproveCommand("同意," + str);
        } else {
          localFbpArchivesHistories.setApproveCommand("同意");
        }
      }
      if ((localFbpArchivesHistories.getApproveCommand() != null) && (localFbpArchivesHistories.getApproveCommand().equalsIgnoreCase("COMMIT"))) {
        if (str != "") {
          localFbpArchivesHistories.setApproveCommand("提交," + str);
        } else {
          localFbpArchivesHistories.setApproveCommand("提交");
        }
      }
    }
    localTableDataInfo.setData((List)localPageInfo.getResult());
    localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
    return localTableDataInfo;
  }
  
  public List<FbpArchivesHistories> getFbpArchivesHistoriess(int paramInt1, int paramInt2)
  {
    return this.fbpArchivesHistoriesDAO.getFbpArchivesHistoriess(paramInt1, paramInt2);
  }
  
  public List<FbpArchivesHistories> getFbpArchivesHistoriess()
  {
    return this.fbpArchivesHistoriesDAO.getFbpArchivesHistoriess();
  }
  
  public FbpArchivesHistories getFbpArchivesHistories(Long paramLong)
  {
    return this.fbpArchivesHistoriesDAO.getFbpArchivesHistories(paramLong);
  }
  
  public void removeFbpArchivesHistories(Long paramLong)
  {
    this.fbpArchivesHistoriesDAO.removeFbpArchivesHistories(paramLong);
  }
  
  public void removeFbpArchivesHistories(FbpArchivesHistories paramFbpArchivesHistories)
  {
    this.fbpArchivesHistoriesDAO.removeFbpArchivesHistories(paramFbpArchivesHistories);
  }
  
  public void insertFbpArchivesHistories(FbpArchivesHistories paramFbpArchivesHistories)
  {
    this.fbpArchivesHistoriesDAO.insertFbpArchivesHistories(paramFbpArchivesHistories);
  }
  
  public void updateFbpArchivesHistories(FbpArchivesHistories paramFbpArchivesHistories)
  {
    this.fbpArchivesHistoriesDAO.updateFbpArchivesHistories(paramFbpArchivesHistories);
  }
  
  public void insertFbpArchivesHistoriess(List<FbpArchivesHistories> paramList)
  {
    this.fbpArchivesHistoriesDAO.insertFbpArchivesHistoriess(paramList);
  }
  
  public void removeFbpArchivesHistoriess(List<FbpArchivesHistories> paramList)
  {
    this.fbpArchivesHistoriesDAO.removeFbpArchivesHistoriess(paramList);
  }
  
  public void updateFbpArchivesHistoriess(List<FbpArchivesHistories> paramList)
  {
    this.fbpArchivesHistoriesDAO.updateFbpArchivesHistoriess(paramList);
  }
  
  public List<FbpArchivesHistories> findFbpArchivesHistories(Long paramLong)
  {
    Object localObject = new ArrayList();
    localObject = this.fbpArchivesHistoriesDAO.findFbpArchivesHistories(paramLong);
    return localObject;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.archives.FbpArchivesHistoriesDS
 * JD-Core Version:    0.7.0.1
 */