<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<meta name="viewport" content="width-device-width user-scalable=no initial-scale=1.0 maximum-scale=1.0 minimun-scale=1.0">
<meta name="Description" content="咸鱼阁工作室">
<link rel="stylesheet" href="lib/bootstrap-3.3.7-dist/css/bootstrap.css">
<title>无标题文档</title>
</head>

<script type="text/javascript">
  	function onJump(index){
  	
  		window.location.href="${pageContext.request.contextPath}/List?currentPageIndex="+index+"&op=find";
  	}
</script>

<body>
<a href="${pageContext.request.contextPath }/index.jsp" class="btn btn-success btn-xs">回首页</a>
<c:if test="${empty page.listLost }">
    	<h1><font color="red">当前没有人发布信息</font></h1>
</c:if>

<c:if test="${not empty page.listLost }">

<div class="container">
	<div class="col-md-6 col-md-offset-3" style="margin-top: 25px">
		
		<c:forEach items="${page.listLost }" var="Thing">
		<div  class="panel panel-default">

		
		  <div class="panel-heading" style="background-color: #5CB85C;color: aliceblue;text-align: center">寻找失物</div>
		  <div class="panel-body">
			<span style="float: left"><img alt="这是一张图片" src="${pageContext.request.contextPath }/${Thing.photo }" width="200" height="200"></span>
			<label style="display: block;float: right;font-weight: 100;color: gray;">发布时间:${Thing.date }</label>
		  </div>
		  <ul class="list-group">
			<li class="list-group-item">失物类别:<span>${Thing.thing }</span></li>
			<li class="list-group-item">丢失时间:<span>${Thing.time }</span></li>
			<li class="list-group-item">丢失地点:<span>${Thing.where }</span></li>
			<li class="list-group-item">联系电话:<span>${Thing.phone }</span></li>
			<li class="list-group-item">备注补充:<span>${Thing.description }</span></li>
		  </ul>

		  

		</div>
		
		</c:forEach>
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				
				<a href="${pageContext.request.contextPath }/List?currentPageIndex=${page.currentPageIndex-1 }&op=lost" class="btn btn-success btn-xs">上一页</a>
					<span>第${page.currentPageIndex+1 }页/共${page.pageCount }页</span>
					<select name="select" onchange="onJump(this.value)">
					<c:forEach begin="0" end="${page.pageCount-1 }" var="n">
						<option value="${n }" ${page.currentPageIndex==n?"selected":"" }>${n+1 }</option>
					</c:forEach>
				</select>
				<a href="${pageContext.request.contextPath }/List?currentPageIndex=${page.currentPageIndex+1 }&op=lost" class="btn btn-success btn-xs">下一页</a>
			</div>
		</div>	
	</div>
</div>
<script src="lib/Jquery/jquery-3.2.1.js"></script>
<script src="lib/bootstrap-3.3.7-dist/js/bootstrap.js"></script>

</c:if>
</body>
</html>
