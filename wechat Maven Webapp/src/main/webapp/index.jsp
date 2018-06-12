<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1">
    <meta name="renderer" content="webkit">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/easyui/css/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/easyui/css/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/easyui/css/IconExtension.css">
    <script src="${pageContext.request.contextPath}/back/easyui/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/back/easyui/js/jquery.easyui.min.js"></script>
    <script src="${pageContext.request.contextPath}/back/easyui/js/form.validator.rules.js"></script>
    <script src="${pageContext.request.contextPath}/back/easyui/js/easyui-lang-zh_CN.js"></script>
</head>
<body>
<div style="margin:0 auto;width:400px;height: 300px;margin-top: 20%">
            <span id="message"></span><br/>
            <input id="username"  name="username"  class="easyui-textbox" data-options="required:true,prompt:'请输入用户名'" /><br/>
            <input id="password"  name="password"  class="easyui-textbox" data-options="required:true,prompt:'请输入密码'"/><br/>
            <input id="code"  name="code"  class="easyui-textbox" data-options="required:true,prompt:'请输入下方验证码'"/><br/>
            <img  src="${pageContext.request.contextPath}/image/code" onclick="this.src='${pageContext.request.contextPath}/image/code?'+Math.random()"/>
           <br/> <a href="#" class="easyui-linkbutton" onclick="submit()">登录</a>
</div>
</body>
<script type="text/javascript">
    if(self!=top){
        window.top.location = "${pageContext.request.contextPath}/index.jsp";
    }
    function submit() {
        $.ajax({
            type:"POST",
            url:"${pageContext.request.contextPath}/admin/login",
            dataType:"JSON",
            data:{"name":$("#username").val(),"password":$("#password").val(),
                "code":$("#code").val()
            },
            success:function(message){
                if(message=="success"){
                    top.location='${pageContext.request.contextPath}/back/platform/adminIndex.html';
                }else if(message=="password"){
                    $("#message").html("用户名密码错误");
                }else if(message=="code"){
                    $("#message").html("验证码有误");
                }
            }
        });
    }
</script>
<script type="text/javascript" src="back/platform/js/libs/jquery-1.11.3.min.js"></script>
</html>
