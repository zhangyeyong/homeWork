<div class="bjui-pageContent">
	<div class="form-group">
        <div class="col-lg-6">
            <label class="control-label ">产品名称：</label>${bean.productName}
        </div>
    </div>
    <br/>
    <br/>
    <div class="form-group">
		<div class="col-lg-6">
			<label class="control-label ">产品类型：</label>${bean.productType}
		</div>
        <div class="col-lg-6">
            <label class="control-label ">状态：</label>
            <#list statusIdEnums as statusId>
                <#if bean.statusId == statusId.code>${statusId.desc}</#if>
            </#list>
        </div>
    </div>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">取消</button></li>
    </ul>
</div>