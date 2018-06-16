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
        var $dgmatch, $damatch;
        $(function () {
            $dgmatch = $("#matchDg");
             $damatch = $("#matchDa");
            $dgmatch.datagrid({
                url: '${pageContext.request.contextPath}/match/queryStartedMatch',
                fit:true,
                columns: [[
                    {title: "比赛编号", field: "id", width: 150, align: 'center'},
                    {title: "比赛时间", field: "timeDesc", width: 150, align: 'center'},
                    {title: "主队id", field: "homeid", width: 150, align: 'center'},
                    {title: "主队得分", field: "home_grade", width: 100, align: 'center'},
                    {title: "客队id", field: "visitid", width: 150, align: 'center'},
                    {title: "客队得分", field: "visit_grade", width: 100, align: 'center'},
                    {
                        title: "操作", field: "options", width: 250, align: 'center',
                        formatter: function (value, row, index) {
                            return "<a class='edit' onClick=\"editmatch('" + row.id + "')\"  href='javascript:;'>修改</a>";
                        }
                    }
                ]],
                onLoadSuccess: function (data) {

                    $(".edit").linkbutton({
                        plain: true,
                        iconCls: 'icon-edit',
                    });
                },
                toolbar:'#matchtb',
            });
        });

        //修改的操作
        function editmatch(id){
             $damatch.dialog({
                width:600,
                height:300,
                title:"修改比赛信息",
                iconCls:"icon-man",
                href:'${pageContext.request.contextPath}/back/data/handMatch/update.jsp?id='+id,
                buttons:[{
                    text:'保存',
                    iconCls:'icon-save',
                    handler:saveUpdatematch,
                },{
                    text:'关闭',
                    iconCls:'icon-cancel',
                    handler:closeDa,
                }],
            });

        }
        //保存修改
        function saveUpdatematch(){
            $("#matchUpdateForm").form('submit',{
                url:'${pageContext.request.contextPath}/match/handResult',
                success:function(){
                    $damatch.dialog('close',true);
                    $dgmatch.datagrid('reload');
                }
            });
        }
        //关闭对话框
        function closeDa(){
             $damatch.dialog('close',true);
        }
    </script>
    </head>
    <body>
    <div  class="easyui-layout" data-options="fit:true" style="width: 100%;height: 80%;min-width: 800px;min-height: 1000px">
        <div data-options="region:'center',">
            <table id="matchDg" ></table>
            <div id="matchDa"></div>
            <div id="matchtb">
            </div>
        </div>
    </div>
    </body>
</html>