<#assign base=request.contextPath />
<div class="bjui-pageContent">
	<form action="${base}/admin/sysRole/save" data-toggle="validate" method="post">
	   <div class="form-group">
            <label class="control-label x85">所属平台：</label>
            <select name="platformId" data-toggle="selectpicker" data-width="200">
                <#list sysPlatformList as sysPlatform>
                    <option value="${sysPlatform.id}">${sysPlatform.platformName}</option>
                </#list>
            </select>
        </div>
		<div class="form-group">
            <label class="control-label x85">名称：</label>
            <input type="text" name="roleName" value="" placeholder="名称" size="20">
        </div>
        <div class="form-group">
            <label class="control-label x85">排序：</label>
            <input type="text" name="sort" value="1" placeholder="排序" size="20">
        </div>
        <div class="form-group">
            <label class="control-label x85">备注：</label>
            <textarea name="remark" data-toggle="autoheight" cols="20"></textarea>
        </div>
	</form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">取消</button></li>
        <li><button type="submit" class="btn-default">添加</button></li>
    </ul>
</div>