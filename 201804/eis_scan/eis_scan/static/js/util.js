function validateNum(value,min,max) {
	var reg = new RegExp("^[0-9]*$");
	if( reg.test(value)) {
		var num = parseInt(value,0);
		if(min <= num && num <= max) {
			return true;
		}
		return false;
	}
	return false;
}
function isBlank(val){
	if(val==null||val==""){
		return true;
	}else{
		return true;
	}
}
function UrlEncode(str) {
	var i, temp, p, q;
	var result = "";
	for (i = 0; i < str.length; i++) {
		temp = str.charCodeAt(i);
		if (temp >= 0x4e00) {
			execScript("ascCode=hex(asc(\"" + str.charAt(i) + "\"))",
					"vbscript");
			result += ascCode.replace(/(.{ 2 })/g, "%$1");
		} else {
			result += escape(str.charAt(i));
		}
	}
	return result;
}
function UrlDecode(zipStr) {
	var uzipStr = "";
	for ( var i = 0; i < zipStr.length; i++) {
		var chr = zipStr.charAt(i);
		if (chr == "+") {
			uzipStr += " ";
		} else if (chr == "%") {
			var asc = zipStr.substring(i + 1, i + 3);
			if (parseInt("0x" + asc) > 0x7f) {
				uzipStr += decodeURI("%" + asc.toString()
						+ zipStr.substring(i + 3, i + 9).toString());
				i += 8;
			} else {
				uzipStr += AsciiToString(parseInt("0x" + asc));
				i += 2;
			}
		} else {
			uzipStr += chr;
		}
	}

	return uzipStr;
}

function StringToAscii(str) {
	return str.charCodeAt(0).toString(16);
}
function AsciiToString(asccode) {
	return String.fromCharCode(asccode);
}
String.prototype.replaceAll = function(reallyDo, replaceWith, ignoreCase) {  
    if (!RegExp.prototype.isPrototypeOf(reallyDo)) {  
        return this.replace(new RegExp(reallyDo, (ignoreCase ? "gi": "g")), replaceWith);  
    } else {  
        return this.replace(reallyDo, replaceWith);  
    }  
};