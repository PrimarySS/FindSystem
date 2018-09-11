<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width-device-width user-scalable=no initial-scale=1.0 maximum-scale=1.0 minimun-scale=1.0">
<meta name="Description" content="咸鱼阁工作室">
<link rel="stylesheet" href="lib/bootstrap-3.3.7-dist/css/bootstrap.css">
<link rel="stylesheet" href="CSS/style1.css">
<title>无标题文档</title>
</head>

<body>
<div class="container">
	<div class="col-lg-2 col-lg-push-4">
		<ul class="btn-group"  style="margin-left: -3%">
			<li class="d1"><a class="btn btn-success" href="losterRigiter.jsp">寻主登记</a></li>
			<li class="d2"><a class="btn btn-success" href="lostProperty.jsp">寻物登记</a></li>
		</ul>
	</div>
</div>
<script src="lib/Jquery/jquery-3.2.1.js"></script>
<script src="lib/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
</body>
</html>