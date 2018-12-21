function Dialog(config){
	this.init.apply(this,arguments);
	this.boolConfirm=true;
}
Dialog.prototype={
	init:function(config){
		config=config || {};
		var k,defaults={
			target:{},
			width:640,
			height:undefined,
			mask:true,
			zIndex:101,
			showHead:true,
			showYesBtn:true,
			showNoBtn:true,
			yesBtnText:_('确定'),
			noBtnText:_('取消'),
			yesFn:null,
			noFn:null,
			title:_('信息提示')
		}
		this.options={};
		for(k in defaults){
			// 检查自定义参数，若没有则使用默认参数
			this.options[k] = config[k] !== undefined ? config[k] : defaults[k];
		}
	},
	createDialog:function(){
		var dialogBox = document.createElement('div'),header,footer,
		yesBtn='<input type="button" value="'+this.options.yesBtnText+'" class="btnSub">',
		noBtn='<input type="button" value="'+this.options.noBtnText+'" class="btnCancel">';
		dialogBox.className = "DialogBox";
		header='<div class="dia_hd"><a href="#;" title="'+_('关闭窗口')+'" class="close_btn">&times;</a>' + this.options.title + '</div>';
		if(!this.options.showYesBtn){
			yesBtn='';
		}
		if(!this.options.showNoBtn){
			noBtn='';
		}
		if(!this.options.showHead){
			header='';
		}
		footer='<div class="dia_ft">'+noBtn+yesBtn+'</div>';
		if(!this.options.showYesBtn && !this.options.showNoBtn){
			footer='';
		}
		dialogBox.innerHTML = header +'<div class="dialogCon"></div>'+footer;
		dialogBox.id='DialogBox_'+this.options.target[0].id;
		document.body.appendChild(dialogBox);
		this.dialogBox = dialogBox = $(dialogBox);
		var This=this;
		this.dialogBox.find('.close_btn').on('click',function(){
			This.close();
		})
		return this;
	},
	show:function(){
		var btnSub,btnCancel,This=this;
		if(!this.boxHeight){
			this.boxHeight=this.options.target.outerHeight()+70;
		}
		var h=this.options.height || this.boxHeight,
			w=this.options.width;
		this.showMask();
		if($('#DialogBox_'+this.options.target[0].id).length==0){
			this.createDialog();
			btnSub=this.dialogBox.find('.btnSub');
			btnCancel=this.dialogBox.find('.btnCancel');
			btnSub.on('click',function(){
				This.confirm();
			});
			btnCancel.on('click',function(){
				This.close();
			});
		}else{
			this.dialogBox=$('#DialogBox_'+this.options.target[0].id);
		}
		this.options.target.show();
		this.dialogBox.find('.dialogCon').append(this.options.target);
		var xheight=$(window).height(),
		l=Math.round(($(window).width()-w)/2),
		t=Math.round((xheight-h)/3);
		this.dialogBox.css({
			visibility: 'visible',left:l,top:t,width:w,height:h,zIndex:this.options.zIndex,textAlign:'center'
		});
		this.dialogBox.fadeIn();
	},
	close:function(){
		this.dialogBox.fadeOut();
		this.hideMask();
		if(typeof this.options.noFn==='function'){
			this.options.noFn.call(this);
		}
	},
	confirm:function(){
		if(typeof this.options.yesFn==='function'){
			if(this.options.yesFn.call(this) == false){
				return false;
			}
		}
		if(this.boolConfirm){
			this.dialogBox.fadeOut();
			this.hideMask();
		}
	},
	showMask:function(){
		if(!this.options.mask) return false;
		var mask=$('#mask');
		if(mask.length===0){
			var div = document.createElement('div');
			var xheight = $(document).height();
			div.id = 'mask';
			document.body.appendChild(div);
			mask = $(div);
			mask.css({
				height:xheight+'px',opacity:0.3,position:'fixed',background:'#000000',width:'100%',zIndex:this.options.zIndex-1
			});
		}
		mask.show();
		return this;
	},
	hideMask:function(){
		var mask=$('#mask');
		if(mask.length>0){
			mask.hide();
		}
		return this;
	}
}