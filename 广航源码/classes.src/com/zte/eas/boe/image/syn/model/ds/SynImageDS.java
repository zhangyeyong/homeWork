package com.zte.eas.boe.image.syn.model.ds;

import com.cmcc.mss.importsrvresponse.ImportSrvResponse;
import com.cmcc.mss.msgheader.MsgHeader;
import com.cmcc.mss.sb_eas_eas_importimageoperationinfosrv.ImportImageOperationInfoSrvInputCollection;
import com.cmcc.mss.sb_eas_eas_importimageoperationinfosrv.ImportImageOperationInfoSrvInputItem;
import com.cmcc.mss.sb_eas_eas_importimageoperationinfosrv.SBEASEASImportImageOperationInfoSrv;
import com.cmcc.mss.sb_eas_eas_importimageoperationinfosrv.SBEASEASImportImageOperationInfoSrvRequest;
import com.cmcc.mss.sb_eas_eas_importimageoperationinfosrv.SBEASEASImportImageOperationInfoSrv_Service;
import java.util.GregorianCalendar;
import java.util.List;
import javax.xml.datatype.XMLGregorianCalendar;
import org.apache.log4j.Logger;

public class SynImageDS
  implements ISynImageDS
{
  private Logger log = Logger.getLogger(getClass());
  
  public ImportSrvResponse synImage(SBEASEASImportImageOperationInfoSrvRequest paramSBEASEASImportImageOperationInfoSrvRequest)
  {
    SBEASEASImportImageOperationInfoSrv_Service localSBEASEASImportImageOperationInfoSrv_Service = new SBEASEASImportImageOperationInfoSrv_Service();
    SBEASEASImportImageOperationInfoSrv localSBEASEASImportImageOperationInfoSrv = localSBEASEASImportImageOperationInfoSrv_Service.getSBEASEASImportImageOperationInfoSrvPort();
    ImportSrvResponse localImportSrvResponse = new ImportSrvResponse();
    try
    {
      this.log.error("----SB_EAS_EAS_ImportImageOperationInfo创建删除服务 开始-----");
      this.log.error("Request MsgHeader SOURCE_SYSTEM_ID:" + paramSBEASEASImportImageOperationInfoSrvRequest.getMsgHeader().getSOURCESYSTEMID());
      this.log.error("Request MsgHeader SOURCE_SYSTEM_NAME:" + paramSBEASEASImportImageOperationInfoSrvRequest.getMsgHeader().getSOURCESYSTEMNAME());
      this.log.error("Request MsgHeader USER_ID:" + paramSBEASEASImportImageOperationInfoSrvRequest.getMsgHeader().getUSERID());
      this.log.error("Request MsgHeader USER_NAME:" + paramSBEASEASImportImageOperationInfoSrvRequest.getMsgHeader().getUSERNAME());
      this.log.error("Request MsgHeader SUBMIT_DATE:" + paramSBEASEASImportImageOperationInfoSrvRequest.getMsgHeader().getSUBMITDATE().toGregorianCalendar().getTime());
      this.log.error("Request size:" + paramSBEASEASImportImageOperationInfoSrvRequest.getImportImageOperationInfoSrvInputCollection().getImportImageOperationInfoSrvInputItem().size());
      for (int i = 0; i < paramSBEASEASImportImageOperationInfoSrvRequest.getImportImageOperationInfoSrvInputCollection().getImportImageOperationInfoSrvInputItem().size(); i++)
      {
        ImportImageOperationInfoSrvInputItem localImportImageOperationInfoSrvInputItem = (ImportImageOperationInfoSrvInputItem)paramSBEASEASImportImageOperationInfoSrvRequest.getImportImageOperationInfoSrvInputCollection().getImportImageOperationInfoSrvInputItem().get(i);
        this.log.error("Request PRI_KEY:" + localImportImageOperationInfoSrvInputItem.getPRIKEY());
        this.log.error("Request BATCH_NAME:" + localImportImageOperationInfoSrvInputItem.getBATCHNAME());
        this.log.error("Request BOE_NUM:" + localImportImageOperationInfoSrvInputItem.getBOENUM());
        this.log.error("Request OPERATION_TYPE:" + localImportImageOperationInfoSrvInputItem.getOPERATIONTYPE());
        this.log.error("Request OPERATION_DATE:" + localImportImageOperationInfoSrvInputItem.getOPERATIONDATE().toGregorianCalendar().getTime());
      }
      localImportSrvResponse = localSBEASEASImportImageOperationInfoSrv.process(paramSBEASEASImportImageOperationInfoSrvRequest);
      this.log.error("Response INSTANCE_ID:" + localImportSrvResponse.getINSTANCEID());
      this.log.error("Response SERVICE_FLAG:" + localImportSrvResponse.getSERVICEFLAG());
      this.log.error("Response SERVICE_MESSAGE:" + localImportSrvResponse.getSERVICEMESSAGE());
      return localImportSrvResponse;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.log.error("Exception:", localException);
      this.log.error("----SB_EAS_EAS_ImportImageOperationInfo创建删除服务 结束-----");
    }
    return null;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.boe.image.syn.model.ds.SynImageDS
 * JD-Core Version:    0.7.0.1
 */