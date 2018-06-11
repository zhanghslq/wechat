<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/easyui/css/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/easyui/css/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/easyui/css/IconExtension.css">
    <script src="${pageContext.request.contextPath}/back/easyui/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/back/easyui/js/jquery.easyui.min.js"></script>
    <script src="${pageContext.request.contextPath}/back/easyui/js/form.validator.rules.js"></script>
    <script src="${pageContext.request.contextPath}/back/easyui/js/easyui-lang-zh_CN.js"></script>
    <script>
        var $dgteam, $dateam;
        $(function () {
            $dgteam = $("#teamDg");
             $dateam = $("#teamDa");
            $dgteam.datagrid({
                url: '${pageContext.request.contextPath}/match/queryMatchDone',
                fit:true,
                columns: [[
                    {title: "比赛编号", field: "id", width: 200, align: 'center'},
                    {title: "比赛时间", field: "timeDesc", width: 200, align: 'center'},
                    {title: "主队得分", field: "homeGrade", width: 200, align: 'center'},
                    {title: "客队得分", field: "visitGrade", width: 200, align: 'center'},
                    {
                        title: "操作", field: "options", width: 250, align: 'center',
                        formatter: function (value, row, index) {
                            return "<a class='del' onClick=\"delteam('" + row.id + "')\" href='javascript:;'>删除</a>&nbsp;&nbsp;" +
                                    "<a class='edit' onClick=\"editteam('" + row.id + "')\"  href='javascript:;'>修改</a>";
                        }
                    }
                ]],
                onLoadSuccess: function (data) {
                    $(".del").linkbutton({
                        plain: true,
                        iconCls: 'icon-remove',
                    });
                    $(".edit").linkbutton({
                        plain: true,
                        iconCls: 'icon-edit',
                    });
                },
                toolbar:'#teamtb',
            });
        });
        //删除的操作
        function delteam(id){
            $.messager.confirm("提示","您确定要删除吗?",function(r){
                if(r){
                	 $.ajax({
                     	url:"${pageContext.request.contextPath}/team/delete",
                     	data:{"id":id},
                     	async:false
                     });
                    $dgteam.datagrid('reload');
                }
            });
        }
        //修改的操作
        function editteam(id){
             $dateam.dialog({
                width:600,
                height:300,
                title:"修改角色",
                iconCls:"icon-man",
                href:'${pageContext.request.contextPath}/back/main/team/update.jsp?id='+id,
                buttons:[{
                    text:'保存',
                    iconCls:'icon-save',
                    handler:saveUpdateteam,
                },{
                    text:'关闭',
                    iconCls:'icon-cancel',
                    handler:closeDa,
                }],
            });
             
             
        }

        function saveGrant() {
        	var nodes = $('#tree').tree('getChecked');//获取:checked的结点.
			var s = '';
			for(var i=0; i<nodes.length; i++){
    				if (s != '') s += ',';
    				s += nodes[i].id;//例如:菜单的menuID
			}
        	$.ajax({
        		type:"POST",
        		async:false,
        		url:'${pageContext.request.contextPath}/team/grantPermission',
        		dataType:"JSON",
        		data:{"rid":$("#teamId").attr("value"),"pid":s},
        		success:function(message){
        			$dateam.dialog('close',true);
        			alert(message);
        		}
        	});
		}
        function addteam() {
             $dateam.dialog({
                width:600,
                height:300,
                title:"添加角色",
                iconCls:"icon-man",
                href:'${pageContext.request.contextPath}/back/main/team/add.jsp',
                buttons:[{
                    text:'保存',
                    iconCls:'icon-save',
                    handler:saveAddteam,
                },{
                    text:'关闭',
                    iconCls:'icon-cancel',
                    handler:closeDa,
                }],
            });
        
        }
        //保存添加
        function saveAddteam(){
            $("#addteamForm").form('submit',{
                url:'${pageContext.request.contextPath}/team/insert',
                success:function(){
                     $dateam.dialog('close',true);
                     $dgteam.datagrid('reload');
                }
            });
        }
        //保存修改
        function saveUpdateteam(){
            $("#teamUpdateForm").form('submit',{
                url:'${pageContext.request.contextPath}/team/update',
                success:function(){
                    $dateam.dialog('close',true);
                    $dgteam.datagrid('reload');
                }
            });
        }
        //关闭对话框
        function closeDa(){
             $dateam.dialog('close',true);
        }
    </script>
    </head>
    <body>
    <div  class="easyui-layout" data-options="fit:true" style="width: 100%;height: 80%;min-width: 800px;min-height: 1000px">
        <div data-options="region:'center',">
            <table id="teamDg" ></table>
            <div id="teamDa"></div>
            <div id="teamtb">
                <a  onclick="addteam()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
            </div>
        </div>
    </div>
    </body>
</html>