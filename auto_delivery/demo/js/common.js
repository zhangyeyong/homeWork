Date.prototype.pattern=function(fmt) {
  var o = {
  "M+" : this.getMonth()+1, //�·�
  "d+" : this.getDate(), //��
  "h+" : this.getHours()%12 == 0 ? 12 : this.getHours()%12, //Сʱ
  "H+" : this.getHours(), //Сʱ
  "m+" : this.getMinutes(), //��
  "s+" : this.getSeconds(), //��
  "q+" : Math.floor((this.getMonth()+3)/3), //����
  "S" : this.getMilliseconds() //����
  };
  
  /*
  
    "0" : "\u661f\u671f\u65e5",
  "1" : "\u661f\u671f\u4e00",
  "2" : "\u661f\u671f\u4e8c",
  "3" : "\u661f\u671f\u4e09",
  "4" : "\u661f\u671f\u56db",
  "5" : "\u661f\u671f\u4e94",
  "6" : "\u661f\u671f\u516d"
  */
  var week = {
  "0" : "������",
  "1" : "����һ",
  "2" : "���ڶ�",
  "3" : "������",
  "4" : "������",
  "5" : "������",
  "6" : "������"
  };
  if(/(y+)/.test(fmt)){
    fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
  }
  if(/(E+)/.test(fmt)){
    fmt=fmt.replace(RegExp.$1, ((RegExp.$1.length>1) ? (RegExp.$1.length>2 ? "/u661f/u671f" : "/u5468") : "")+week[this.getDay()+""]);
  }
  for(var k in o){
    if(new RegExp("("+ k +")").test(fmt)){
      fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
    }
  }
  return fmt;
}