<%@ page  contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<div style="text-align: center;">
    <form id="matchUpdateForm" method="post">
            <div style="margin-top: 70px;">
                <input name="id" type="hidden" value="${param.id}">
            </div>
        <div style="margin-top: 10px;">
          	  比赛状态:<input  name="status" class="easyui-textbox" data-options="required:true"/><br/>
        </div>
        <div style="margin-top: 10px;">
          	  主队得分:<input name="home_grade"  class="easyui-textbox" data-options="required:true"><br>
        </div>

        <div style="margin-top: 10px;">
          	  客队得分:<input name="visit_grade"  class="easyui-textbox" data-options="required:true">
        </div>
    </form>
</div>
<script>
    $(function(){
        //构建子页面元素的操作
    	$("#matchUpdateForm").form('load','${pageContext.request.contextPath}/match/queryById?id='+'${param.id}');
    });
</script>