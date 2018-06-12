<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"  language="java" %>
<div style="text-align: center;">
	<form id="staUpdateForm" method="post">
        <div style="margin-top: 70px;">
             <input name="id" type="hidden" value="${param.id}">
        </div>
        <div style="margin-top: 10px;">
          	  球队名:<input  name="name_zh"  class="easyui-textbox" data-options="required:true"/><br/>
        </div>
        <div style="margin-top: 10px;">
          	  国旗:<input  name="country_logo"  class="easyui-textbox" data-options="required:true"/><br/>
        </div>
    </form>
</div>
<script>
    $(function(){
    	$("#staUpdateForm").form('load','${pageContext.request.contextPath}/team/queryById?id='+'${param.id}');
    });
</script>
