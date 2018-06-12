<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
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
    var $dg,$da;
    $(function () {
        $dg = $("#teamDg");
        $da = $("#teamDa");
        $dg.datagrid({
            url: '${pageContext.request.contextPath}/team/queryAll',
            fit:true,
            width:'100%',
            height:'100%',
            columns: [[
                    {title: "球队编号", field: "id", width: 200, align: 'center'},
                    {title: "球队名", field: "name_zh", width: 200, align: 'center'},
                    {title: "球队国旗", field: "country_logo", width: 250, align: 'center'},

                    {title: "操作", field: "options", width: 150, align: 'center',
                    formatter: function (value, row, index) {
                        return "<a class='edit' onClick=\"editSta('" + row.id + "')\"  href='javascript:;'>修改</a>";
                    }
                }
            ]],
            onLoadSuccess: function (data) {
            	$(".edit").linkbutton({
                    plain: true,
                    iconCls: 'icon-edit',
                });
            },
        });
    });

    function editSta(id){
        $da.dialog({
            width:600,
            height:450,
            title:"修改球队信息",
            iconCls:"icon-man",
            href:'${pageContext.request.contextPath}/back/data/team/update.jsp?id='+id,
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:saveSta,
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:closeDa,
            }],
            
        });
        
    }
    
   
    //保存用户
    function saveSta(){
        $("#staUpdateForm").form('submit',{
            url:'${pageContext.request.contextPath}/team/update',
            success:function(){
                $da.dialog('close',true);
                $dg.datagrid('reload');
            }
        });
    }
    //关闭对话框
    function closeDa(){
        $da.dialog('close',true);
    }
</script>

</head>
<body>
<div  class="easyui-layout" data-options="fit:true" style="width: 100%;height: 100%;min-width: 800px;min-height: 3000px">
    <div data-options="region:'center',">
        <table id="teamDg" ></table>
        <div id="teamDa"></div>
    </div>
</div>
</body>
</html>