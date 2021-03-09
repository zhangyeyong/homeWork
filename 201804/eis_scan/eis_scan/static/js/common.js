// select
$(function(){
	var select=$('.myselect');
	select.each(function() {
		var val = $(this).attr("value");
		$(this).find("option").each(function(){
			if(this.value==val){
				this.selected = true;
				return false;
			}
		});
	});
});


function showLoading(){
	var mask=$('#layer');
	if(mask.length==0){
		mask=document.createElement('div');
		mask.id="layer";
		document.body.appendChild(mask);
		mask=$(mask);
	}
	mask.show();
}

function hideLoading(){
	var mask=$('#layer');
	mask.hide();
}





$(document).ready(function(){
		
	// tab代码 start
	$(".tab-section").each(function() {
		if ($(this).children()[1]) {
			new Tabs($(this));
		}
	});
	var mymenu=$("#my_menu div a");
	var mymenu_l=mymenu.length;
	for(var i=0;i<mymenu_l;i++){
		mymenu[i].onmousedown=function(){
			for(var j=0;j<mymenu_l;j++){
				mymenu[j].className="";
				}
			
			this.className="selected";
		};
	}
});


// tab方法
function Tabs(root) {
	this.tabMenus=root.children('.tab-btn').find('li');
	this.tabContents=root.children('.tabcontent').children('.tabc');
	var currIndex=0;
	var This=this;
	
	for(var i=0,len=this.tabMenus.length;i<len;i++){
		this.tabMenus[i].index=i;
		this.tabMenus.eq(i).on('click',function(){
			This.showItem(this.index);
			this.currIndex=this.index;
			$(this).addClass('curr');	
		});	
	}
}
Tabs.prototype={
	showItem:function(n){
		this.tabContents.hide();
		this.tabMenus.removeClass('curr');
		this.tabContents.eq(n).show();
	}
};
// tab end