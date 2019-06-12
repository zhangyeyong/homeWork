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