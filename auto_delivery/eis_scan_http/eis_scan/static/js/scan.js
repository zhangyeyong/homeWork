function Scan(config) {
	this.init.apply(this, arguments);
	this.hasError = false;
	this.checkScanClient();
	this.funs = {};
	setTimeout(function() {
		if (!scanSelf.isAlive) {
			alert(_("扫描客户端未成功启动"));
		}
	}, 1000);
	this.showGroups("dailyScanM");
}
Scan.prototype = {
	init : function(config) {
		scanSelf = this;
		config = config || {};
		var defaults = {
			curMenu : "dailyScan",// 当前菜单,dailyScan,appraiseTask,noTask
			curPage : "groups"// groups,images
		};
		this.urls = {
			dailyScan : "/dailyScan",
			rescan : "/rescan",
			replaceScan : "/replaceScan",
			addScan : "/addScan",
			deleteImg : "/deleteImg",
			moveImg : "/moveImg",
			delTask : "/delTask",
			getTask : "/getTask",
			showGroups : "/scan",
			showImages : "/showImages",
			uploadFile : "/uploadFile"
		};
		this.isAlive = false;
		this.curFn = "";
		this.curHead = "";
		this.selected = [];
		this.map = {};
		for ( var k in defaults) {
			// 检查自定义参数，若没有则使用默认参数
			this[k] = config[k] !== undefined ? config[k] : defaults[k];
		}
	},
	getUrl : function() {
		return this.urls[this.curFn];
	},
	execute : function(fnType, destHeadId) {
		this.curFn = fnType;
		// 检查是否选中，返回请求参数
		var cond = this.handleFnType(this.curFn);
		if (this.hasError) {
			return false;
		}
		// 刷新功能栏状态
		this.refreshToolbar();
		if (destHeadId) {
			// 移动图片的目标headId
			cond.destHeadId = destHeadId;
		}
		cond.belong = this.curMenu;
		cond.curPage = this.curPage;
		if (this.curFn == "showGroups" || this.curFn == "showImages"
				|| this.curFn == "deleteImg" || this.curFn == "delTask"
				|| this.curFn == "moveImg") {
			if (this.curFn == "showImages") {
				cond.headId = this.curHead;
			}
			showLoading();
			jQuery.ajax({
				url : scanSelf.getUrl(),
				type : "post",
				async : true,
				data : cond,
				success : function(d) {
					$(".main").html(d);
				},
				error : function(e) {
					alert(_("未知错误"));
				},
				complete : function() {
					hideLoading();
				}
			});
		} else if (this.curFn == "dailyScan" || this.curFn == "rescan"
				|| this.curFn == "addScan" || this.curFn == "replaceScan") {
			this.commonScan(function(data) {
				cond.data = JSON.stringify(data);
				jQuery.ajax({
					url : scanSelf.getUrl(),
					type : "post",
					async : true,
					data : cond,
					success : function(d) {
						d = eval("(" + d + ")");
						if (d.isSuccess) {
							$(".main").html(d.info.__body__);
						} else {
							alert(d.msg);
						}
					},
					error : function(e) {
						alert(_("未知错误"));
					},
					complete : function() {
						hideLoading();
					}
				});
			});
		} else if (fnType == "importImg") {
			var imgFiles = $("#importFrame").contents().find("#imgFiles");
			$("#importFrame").contents().find("#headId").val(cond.headId);
			$("#importFrame").contents().find("#curPage").val(cond.curPage);
			$("#importFrame").contents().find("#belong").val(cond.belong);
			imgFiles.click();
		} else if (fnType == "uploadFile") {
			this.uploadFile(cond);
		} else if (fnType == "getTask"){
			showLoading();
			jQuery.ajax({
				url : scanSelf.getUrl(),
				type : "post",
				async : true,
				data : cond,
				success : function(d) {
					d = eval("(" + d + ")");
					if (d.isSuccess) {
						$(".main").html(d.info.__body__);
					} else {
						alert(d.msg);
					}
				},
				error : function(e) {
					alert(_("未知错误"));
				},
				complete : function() {
					hideLoading();
				}
			});
		}
	},
	showGroups : function(menu) {
		this.curFn = "showGroups";
		this.refreshMenu(menu);
		this.curPage = "groups";
		this.curHead = "";
		this.execute(this.curFn);
	},
	showImages : function(headId) {
		this.curFn = "showImages";
		this.curPage = "images";
		this.curHead = headId || this.curHead;
		this.execute(this.curFn);
	},
	editNum : function() {
		if (this.curPage == "groups") {
			var headList = $(".bills_list input:checked");
			if (headList.length == 0) {
				alert(_("请选择扫描组！"));
				return false;
			}
			if (headList.length > 1) {
				alert(_("只能选择一个扫描组！"));
				return false;
			}
			var i = $(headList[0]);
			this.gBox.headId = i.attr("data");
			this.gBox.headNum = i.attr("headNum");
			$("#headNum").val(this.gBox.headNum);
			this.gBox.show();
		}
	},
	confirmEditNum : function() {
		var headNum = $.trim($("#headNum").val());
		var headId = this.gBox.headId;
		if (!headNum) {
			alert(_("编号不能为空！"));
			$("#headNum").val(this.gBox.headNum);
			return false;
		}
		jQuery.ajax({
			url : "/editNum",
			type : "post",
			async : true,
			data : {
				"headId" : headId,
				"headNum" : headNum,
				"oldNum" : this.gBox.headNum,
				"belong" : this.curMenu
			},
			success : function(d) {
				d = eval("(" + d + ")");
				if (d.isSuccess) {
					$(".main").html(d.info.__body__);
					scanSelf.gBox.close();
				} else {
					alert(d.msg);
					$("#headNum").val(scanSelf.gBox.headNum);
				}
			}
		});
		return false;
	},
	addTask : function() {
		$("#taskNum").val("");
		this.nBox.show();
	},
	confirmAddTask : function() {
		var headNum = $.trim($("#taskNum").val());
		if (!headNum) {
			alert(_("编号不能为空！"));
			return false;
		}
		jQuery.ajax({
			url : "/addTask",
			type : "post",
			async : true,
			data : {
				"headNum" : headNum,
				"belong" : this.curMenu
			},
			success : function(d) {
				d = eval("(" + d + ")");
				if (d.isSuccess) {
					$(".main").html(d.info.__body__);
					scanSelf.nBox.close();
				} else {
					alert(d.msg);
				}
			}
		});
		return false;
	},
	appraiseTaskQuery : function(groupFieldValue, pageNum) {
		groupFieldValue = groupFieldValue || "";
		pageNum = pageNum || 1;
		jQuery.ajax({
			url : "/appraiseTaskQuery",
			type : "post",
			async : true,
			data : {
				"groupFieldValue" : groupFieldValue,
				"pageNum" : pageNum
			},
			success : function(d) {
				$("#appraiseTaskBox").html(d);
			}
		});
	},
	appraiseTaskAddScan : function() {
		this.appraiseTaskQuery();
		this.appraiseTaskBox.show();
	},
	confirmAppraiseTaskAddScan : function() {
		var appraiseTaskList = $("#tasks input:checked");
		var appraiseTasks = [];
		for(var i =0;i<appraiseTaskList.length;i++){
			appraiseTasks.push(appraiseTaskList[i].value);
		}
		jQuery.ajax({
			url : "/appraiseTaskAddScan",
			type : "post",
			async : true,
			data : {
				"appraiseTasks" : JSON.stringify(appraiseTasks)
			},
			success : function(d) {
				d = eval("(" + d + ")");
				if (!d.isSuccess){
					alert(d.info);
				}
				scanSelf.showGroups("appraiseTaskM");
			}
		});
	},
	noTaskQuery : function(groupFieldValue, pageNum) {
		groupFieldValue = groupFieldValue || "";
		pageNum = pageNum || 1;
		jQuery.ajax({
			url : "/noTaskQuery",
			type : "post",
			async : true,
			data : {
				"groupFieldValue" : groupFieldValue,
				"pageNum" : pageNum
			},
			success : function(d) {
				$("#mboxWork").html(d);
			}
		});
	},
	noTaskAddScan : function() {
		this.noTaskQuery();
		this.tBox.show();
	},
	confirmNoTaskAddScan : function() {
		var noTaskList = $("#notasks input:checked");
		var noTasks = [];
		for(var i =0;i<noTaskList.length;i++){
			noTasks.push(noTaskList[i].value);
		}
		jQuery.ajax({
			url : "/noTaskAddScan",
			type : "post",
			async : true,
			data : {
				"noTasks" : JSON.stringify(noTasks)
			},
			success : function(d) {
				scanSelf.showGroups("noTaskM");
			}
		});
	},
	editImg : function() {
		if (this.curPage == "images") {
			var imgList = $(".bill_list input:checked");
			if (imgList.length == 0) {
				alert(_("请选择图片！"));
				return false;
			}
			if (imgList.length > 1) {
				alert(_("只能选择一张图片！"));
				return false;
			}
			var i = $(imgList[0]);
			this.mBox.lineId = i.attr("data");
			this.mBox.imgOrd = i.attr("imgOrd");
			this.mBox.imgName = i.attr("imgName");
			this.mBox.imgExt = i.attr("imgExt");
			$("#fileName").val(this.mBox.imgName);
			$("#fileOrd").val(this.mBox.imgOrd);
			this.mBox.show();
		}
	},
	confirmEditImg : function() {
		var imgName = $("#fileName").val();
		var imgOrd = $("#fileOrd").val();
		imgOrd = parseInt(imgOrd, 10);
		if (isNaN(imgOrd) || imgOrd < 1) {
			alert(_("序号必须是大于0的整数！"));
			return false;
		}
		if (this.mBox.imgOrd != imgOrd || this.mBox.imgName != imgName) {
			jQuery.ajax({
				url : "/editImg",
				type : "post",
				async : true,
				data : {
					"lineId" : this.mBox.lineId,
					"imgOrd" : this.mBox.imgOrd == imgOrd ? null : imgOrd,
					"imgNameS" : this.mBox.imgName == imgName ? null : imgName
							+ "." + this.mBox.imgExt
				},
				success : function(d) {
					// clearSortImg();
					$(".main").html(d);
				}
			});
		}
	},
	showBigImg : function(e) {
		var $e = $(e);
		$("#photoDetail img").attr("src", $e.attr('imgPath'));
		this.pBox.imgPath = $e.attr('imgPath');
		this.pBox.hasEdit = false;
		this.pBox.curE = $e;
		this.pBox.show();
	},
	rotateImg : function(angle) {
		jQuery.ajax({
			url : "/rotateImg",
			type : "post",
			async : true,
			data : {
				"imgPath" : this.pBox.imgPath,
				"angle" : angle
			},
			success : function(imgPath) {
				$("#photoDetail img").attr("src", imgPath);
			}
		});
		this.pBox.hasEdit = true;
	},
	goToImg : function(type) {
		var oldE = this.pBox.curE;
		if(type=='next'){
			var nextE = oldE.closest('li').next();
			if(!nextE || nextE.length==0){
				nextE = oldE.closest('ul').find('li').first();
			}
			this.pBox.curE = nextE;
			var img = nextE.find('span').eq(0);
			this.pBox.imgPath = img.attr('imgPath');
			$("#photoDetail img").attr("src", img.attr('imgPath'));
			
		}else if(type=='prev'){
			var preE = oldE.closest('li').prev();
			if(!preE || preE.length==0){
				preE = oldE.closest('ul').find('li').last();
			}
			this.pBox.curE = preE;
			var img = preE.find('span').eq(0);
			this.pBox.imgPath = img.attr('imgPath');
			$("#photoDetail img").attr("src", img.attr('imgPath'));
		}
	},

	// 根据功能类型，更改菜单选中状态，及检查相关信息
	handleFnType : function(fnType) {
		this.hasError = false;
		var cond = {};
		if (fnType == "dailyScan" || fnType == "") {
			this.refreshMenu("dailyScanM");
			this.curPage = "groups";
			this.curHead = "";
		}else if (fnType == "getTask") {
			this.refreshMenu("appraiseTaskM");
			this.curPage = "groups";
			this.curHead = "";
		} else if (fnType == "rescan" || fnType == "addScan"
				|| fnType == "importImg") {
//			if(this.curMenu=='noTaskM'){
//				if(fnType == "rescan"  ){
//					this.hasError = true;
//					return false;
//				}
//			}
			
			if (this.curPage == "groups") {
				this.findSelected();
				if (this.selected.length == 0) {
					alert(_("请选择扫描组！"));
					this.hasError = true;
					return false;
				} else if (this.selected.length > 1) {
					alert(_("只能选择一个扫描组！"));
					this.hasError = true;
					return false;
				}
				cond.headId = this.selected[0];
			} else {
				cond.headId = this.curHead;
			}
			
			if(fnType == "rescan" && this.checkImgHeadStatusIsAddOnly()){
				alert(_("所选任务只能添加影像！"));
				this.hasError = true;
				return false;
			}
		} else if (fnType == "delTask") {
			if (this.curPage != "groups") {
				this.hasError = true;
				return false;
			}
			this.findSelected();
			if (this.selected.length == 0) {
				alert(_("请选扫描组！"));
				this.hasError = true;
				return false;
			}
			cond.headIds = JSON.stringify(this.selected);
		} else if (fnType == "replaceScan" || fnType == "deleteImg"
				|| fnType == "moveImg") {
			if( !this.checkDeleteAble()){
				var opt = "";
				if(fnType == "replaceScan"){
					opt = "替扫";
				}
				if(fnType == "deleteImg"){
					opt = "删除";
				}
				if(fnType == "moveImg"){
					opt = "移动";
				}
				alert(_("不能"+opt+"影像["+scanSelf.map["errorImageName"]+"]！"));
				this.hasError = true;
				return false;
			}

			
			if (this.curPage != "images") {
				
				this.hasError = true;
				return false;
			}
			this.findSelected();
			if (this.selected.length == 0) {
				alert(_("请选择影像！"));
				this.hasError = true;
				return false;
			}
			cond.headId = this.curHead;
			cond.lineIds = JSON.stringify(this.selected);
		} else if (fnType == "uploadFile") {
			this.findSelected();
			if (this.selected.length == 0) {
				alert(_("请选择扫描组！"));
				this.hasError = true;
				return false;
			}
			//检查图片数量
			var imgQtyFlag = true;
			var errorMsg = "";
			jQuery(".bills_list input:checked").each(function(i, e) {
				var imgQty = jQuery(e).attr("imgQty");
				var headNum = jQuery(e).attr("headNum");
				if(Number(imgQty)<1){
					errorMsg = "["+headNum+"]"+_("没有图片");
					imgQtyFlag = false;
					return false;
				}
			});
			if(!imgQtyFlag){
				alert(errorMsg);
				this.hasError = true;
				return false;
			}
			cond.headIds = JSON.stringify(this.selected);
		}
		return cond;
	},
	refreshMenu : function(menu) {
		menu = menu || this.curMenu;
		this.curMenu = menu;
		$(".subMenu li").each(function() {
			if (this.id == menu) {
				this.className = "current";
			} else {
				this.className = "";
			}
		});
	},
	backupToolbarFuns : function() {
		var funs = this.funs;
		$(".toolbar a").each(function(i, e) {
			var aE = $(e);
			var fName = aE.find("span").attr("class");
			var f = funs[fName]?funs[fName]:aE.attr("onclick");
			funs[fName]=f;
			aE.attr("onclick",f);
		});
	},
	refreshToolbar : function() {
		$(".toolbar a").removeClass("disable");
		
//		var exportE = $(".toolbar .export").parent();//重扫
		var replaceE = $(".toolbar .replace").parent();//替扫
		var editImgE = $(".toolbar .editImg").parent();//编辑图像
		var deleteE = $(".toolbar .delete").parent();//删除图像
		var editNumE = $(".toolbar .editNum").parent();//修改编号
		var addTaskE = $(".toolbar .addTask").parent();//添加任务
		var delTaskE = $(".toolbar .delTask").parent();//删除任务
		var upGroupE = $(".toolbar .upGroup").parent();//上传
		
		if (this.curPage == "groups") {
			replaceE.addClass("disable");
			editImgE.addClass("disable");
			deleteE.addClass("disable");
		} else {
			editNumE.addClass("disable");
			addTaskE.addClass("disable");
			delTaskE.addClass("disable");
			upGroupE.addClass("disable");
		}
		
		//还原、备份onclick
		this.backupToolbarFuns();
		
		//新建任务不可用
		if(this.curMenu=="appraiseTaskM"||this.curMenu=="noTaskM"){
			addTaskE.addClass("disable");
			//addTaskE.removeAttr('onclick');
		}
//		//重扫不可用
//		if(this.curMenu=="noTaskM"){
//			exportE.addClass("disable");
//			//exportE.removeAttr('onclick');
//		}
//		//替扫不可用
//		if(this.curMenu=="noTaskM"){
//			replaceE.addClass("disable");
//			//replaceE.removeAttr('onclick');
//		}
		
		//删除所有 disable的  onchick
		$(".toolbar .disable").each(function(i, e) {
			$(e).removeAttr('onclick');
		});
		

	},
	// 扫描组：headId，图片明细：imageId
	findSelected : function() {
		this.selected = [];
		if (this.curPage == "groups") {
			$(".bills_list input:checked").each(function(i, e) {
				var d = $(e).attr("data");
				scanSelf.selected.push(d);
			});
		} else if (this.curPage == "images") {
			$(".bill_list input:checked").each(function(i, e) {
				var d = $(e).attr("data");
				scanSelf.selected.push(d);
			});
		}
	},
	commonScan : function(fn) {
		showLoading();
		jQuery.ajax({
			url : "/getClientParams",
			type : "post",
			async : true,
			success : function(params) {
				if (-1 == params.indexOf("method")) {
					alert(params);
					window.location.href = "/configure";
				}
				var url = "http://127.0.0.1:8001/?" + UrlEncode(params);
				jQuery.ajax({
					type : "get",
					async : true,
					url : url,
					dataType : "jsonp",
					jsonp : "callback",// 传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(一般默认为:callback)
					jsonpCallback : "success_jsonpCallback",// 自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名，也可以写"?"，jQuery会自动为你处理数据
					success : function(rtn) {
						if (rtn.isSuccess) {
							fn.call(this, rtn.data);
						} else {
							alert(rtn.info);
							hideLoading();
						}
					},
					error : function(e) {
						alert(_("未知错误"));
					}
				});
			}
		});
	},
	checkScanClient : function() {
		var url = "http://127.0.0.1:8001/?" + UrlEncode("method=isAlive");
		jQuery.getJSON(url + "&callback=?", function(rtn) {
			scanSelf.isAlive = true;
		});
	},
	
	checkDeleteAble: function() {
		var checkFlag = true;
		$(".bill_list input:checked").each(function(i, e) {
			if($(e).attr("deleteAble")===0||$(e).attr("deleteAble")==='0'){
				checkFlag=false;
				scanSelf.map["errorImageName"]=$(e).attr("imgOrd");
				return false;
			}
		});
		return checkFlag;
	},
	checkImgHeadStatusIsAddOnly: function() {
		var isAddOnly = false;
		$(".bills_list input:checked").each(function(i, e) {
			if($(e).attr("headStatus")=='ADD_ONLY'){
				isAddOnly=true;
				return false;
			}
		});
		if($("#headStatus").val()=="ADD_ONLY"){
				isAddOnly=true;
		}
		return isAddOnly;
	},
	uploadFile : function(cond) {
		showLoading();
		jQuery.ajax({
			url : scanSelf.getUrl(),
			type : "post",
			async : true,
			data : cond,
			success : function(d) {
				$(".main").html(d);
			},
			error : function(e) {
				alert(_("未知错误"));
			},
			complete : function() {
				hideLoading();
			}
		});
	},
	changeapp : function(appCode) {
		showLoading();
		jQuery.ajax({
			type : "post",
			async : false,
			url : "/changeapp",
			data:{"appCode":appCode},
			dataType:"json",
			success : function(data) {
				if(data.isSuccess){
					window.location.reload();
				}else{
					alert(data.info);
				}
			},
			error : function() {
				alert(_("未知错误"));
			},complete : function (){
				hideLoading();
			}
		});
	},
	saveUserForm : function(cond) {
		var userform = jQuery("#userForm");
		if(jQuery("#appCode").val()==""){
			alert(_("应用不能为空！"));
			jQuery("#app").focus();
			return;
		}
		var checkFlag = true;
		$("input").each(function(i,e){
			if(!$(e).attr("required")){
				return true;
			}
			if($(e).val()==""){
				alert("["+$(e).attr("label")+_("] 是必输项！"));
				$(e).focus();
				checkFlag =false;
				return;
			}
		});
		if(!checkFlag){
			return false;
		}
		showLoading();
		jQuery.ajax({
			type : "post",
			async : false,
			url : "/saveUserForm",
			data:userform.serialize(),
			dataType:"json",
			success : function(data) {
				if(cond&&cond.type&&cond.type=="autoSaveUserForm"){
					return;
				}
				if(data.isSuccess){
					alert(_("保存成功"));
				}else{
					alert(data.info);
				}
			},
			error : function() {
				alert(_("未知错误"));
			},complete : function (){
				hideLoading();
			}
		});
	},
	saveUserFormByHead : function(cond) {
		var userform = jQuery("#userForm");
		if(jQuery("#appCode").val()==""){
			alert(_("应用不能为空！"));
			jQuery("#app").focus();
			return;
		}
		var checkFlag = true;
		$("input").each(function(i,e){
			if(!$(e).attr("required")){
				return true;
			}
			if($(e).val()==""){
				alert("["+$(e).attr("label")+_("] 是必输项！"));
				$(e).focus();
				checkFlag =false;
				return;
			}
			
		});
		if(!checkFlag){
			return false;
		}
		showLoading();
		jQuery.ajax({
			type : "post",
			async : false,
			url : "/saveUserFormByHead",
			data:userform.serialize(),
			dataType:"json",
			success : function(data) {
				if(data.isSuccess){
					alert(_("保存成功"));
				}else{
					alert(data.info);
				}
			},
			error : function() {
				alert(_("未知错误"));
			},complete : function (){
				hideLoading();
			}
		});
	}
};
