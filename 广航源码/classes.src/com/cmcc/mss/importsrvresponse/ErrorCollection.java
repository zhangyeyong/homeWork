

java.util.ArrayList
java.util.List
javax.xml.bind.annotation.XmlAccessType
javax.xml.bind.annotation.XmlAccessorType
javax.xml.bind.annotation.XmlElement
javax.xml.bind.annotation.XmlType

FIELD
"ErrorCollection", "errorItem"
ErrorCollection

  "ErrorItem", 
  errorItem
  
  getErrorItem
  
     (errorItem == null) {
      this.errorItem = new ArrayList();
    }
    return this.errorItem;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.importsrvresponse.ErrorCollection
 * JD-Core Version:    0.7.0.1
 */