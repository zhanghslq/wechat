<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" import="java.util.*" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1">
    <meta name="renderer" content="webkit">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <title>猜球管理平台</title>
    <link rel="stylesheet" href="css/common.css"/>
    <link rel="stylesheet" href="css/index.css"/>
</head>
<body>
  	<div class="content">
    <!--左边 开始-->
    <div class="contentLeft">
        <!--logo-->
        <div class="logoMain">
            <div class="logoText">
                猜球后台管理
            </div>
        </div>
        <!--中间导航-->
        <ul class="downMenu" id="downMenu">
            <li class="menuItem">
                <a href="javascript:void(0);"  class="headline"><i class="navIcon icon_2"></i><span>比赛管理</span></a>
                    <ul>
                    <li><a href="../data/match/showAll.jsp" target="contentFrame">比赛管理</a></li>
                   <li><a href="../data/team/showAll.jsp" target="contentFrame">球队管理</a></li>
                </ul>
            </li>
        </ul>
        <!--底部导航-->
        <ul class="footermenu">
            <li><a onclick="LogOut()"><i class="signOut"></i><span>退出登录</span></a></li>
        </ul>
        <!--收缩箭头-->
        <div class="shrink" id="mini"><i class="open"></i></div>
    </div>
   </div>

</body>
<script type="text/javascript">
	function LogOut() {
		top.location.href="${pageContext.request.contextPath}/admin/logout";
	}
</script>
<script type="text/javascript" src="js/libs/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript">navLeft();</script>
</html>
