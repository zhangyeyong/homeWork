Date.prototype.pattern=function(fmt) {
  var o = {
  "M+" : this.getMonth()+1, //月份
  "d+" : this.getDate(), //日
  "h+" : this.getHours()%12 == 0 ? 12 : this.getHours()%12, //小时
  "H+" : this.getHours(), //小时
  "m+" : this.getMinutes(), //分
  "s+" : this.getSeconds(), //秒
  "q+" : Math.floor((this.getMonth()+3)/3), //季度
  "S" : this.getMilliseconds() //毫秒
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
  "0" : "星期日",
  "1" : "星期一",
  "2" : "星期二",
  "3" : "星期三",
  "4" : "星期四",
  "5" : "星期五",
  "6" : "星期六"
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