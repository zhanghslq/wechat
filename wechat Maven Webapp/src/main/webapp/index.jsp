<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1">
    <meta name="renderer" content="webkit">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <title>登录</title>
</head>
<body>
<div class="loginContent">
            <input type="text" placeholder="请输入用户名" id="username">
            <input type="password" placeholder="请输入密码" id="password">
            <input type="text" placeholder="请输入验证码" class="verification" id="code">
        <a href="#" onclick="submit()" class="loginBtn">登录</a>
    </div>
</div>
</body>
<script type="text/javascript">
    if(self!=top){
        window.top.location = "/sysmanager/back/platform2/login.html";
    }

    function submit() {
        $.ajax({
            type:"POST",
            url:"/sysmanager/admin/login",
            dataType:"JSON",
            data:{"name":$("#username").val(),"password":$("#password").val(),
                "code":$("#code").val()
            },
            success:function(message){
                if(message=="success"){
                    top.location='/sysmanager/back/platform2/adminIndex.html';
                }else if(message=="name"){
                    $("#usermes").html("用户名不存在");
                    $("#pwdmes").html("");
                    $("#codemes").html("");
                }else if(message=="password"){
                    $("#pwdmes").html("密码错误");
                    $("#usermes").html("");
                    $("#codemes").html("");
                }else if(message=="code"){
                    $("#usermes").html("");
                    $("#pwdmes").html("");
                    $("#codemes").html("验证码有误");
                }
            }
        });
    }
</script>
<script type="text/javascript" src="/sysmanager/back/platform2/js/libs/jquery-1.11.3.min.js"></script>
</html>
