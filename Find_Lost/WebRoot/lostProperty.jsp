<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
<link rel="stylesheet" href="CSS/style1.css">
<title>无标题文档</title>
<style>
	@media screen and (max-width: 500px) {
    	#responsive {
        	margin-right: 25px;
   		}
}
	
	</style>
</head>

<body>
<div class="container">
	<div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-3">
		<div style="border: 1px solid #AFEC96; border-radius: 25px;padding: 20px 10px; margin-top: 25px;">
			<label style="display: block;margin-bottom: 15px;">寻找失物:</label>

			<form class="form-horizontal" role="form"  action="${pageContext.request.contextPath }/lost?op=lost" enctype="multipart/form-data" method="post">
				<div class="form-group">
					<div class="col-md-6 col-lg-12 has-success">
						<div class="input-group">
							<span class="input-group-addon">遗失物品</span>
							<input type="text" class="form-control" name="thing" id="wupin">
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-md-6 col-lg-12 has-success">
						<div class="input-group">
							<span class="input-group-addon">遗失时间</span>
							<input type="text" class="form-control" name="date" id="time">
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-md-6 col-lg-12 has-success">
						<div class="input-group">
							<span class="input-group-addon">大致地点</span>
							<input type="text" class="form-control" name="where" id="place">
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-md-6 col-lg-12 has-success">
						<div class="input-group">
							<span class="input-group-addon">联系电话</span>
							<input type="text" class="form-control" name="phone" id="tel">
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2" for="other">备注补充:</label>
					<div class="clearfix"></div>
					<div class="col-md-6 col-lg-12 has-success">
						<textarea class="form-control" name="description" id="other"></textarea>
					</div>
				</div>
					<div class="row">
							<input id="file_upload" type="file" name="file" style="display: none;">
							<div class="col-lg-3 col-xs-4" id="responsive">
								<button type="button" style="width: 90px;height: 90px" onClick="fileOpen()">
									<span class="glyphicon glyphicon-plus" style="font-size: 35px;color:rgba(107,102,102,1.00)"></span>
								</button>
							</div>
						<div class="col-lg-3 col-xs-4 col-sm-3" style="width:90px;height: 90px;">
							<img id="preview" style="width: 90px;height: 90px">
						</div>
					</div>
					<small style="color:rgba(107,s102,102,1.00);display: block;margin-right: 10px">上传图片一张</small>
					<div class="row">
						<div class="col-lg-1 col-lg-push-5 col-xs-4 col-xs-push-3">
							<div class="btn-group">
								<button type="submit" class="btn btn-success">&nbsp;&nbsp;&nbsp;提交&nbsp;&nbsp;&nbsp;</button>
								<div style="color:red">${error_msg }</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
<script src="lib/Jquery/jquery-3.2.1.js"></script>
<script src="lib/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<script>
	function fileOpen(){
		document.getElementById('file_upload').click();
	} 
	$(function() {
		$("#file_upload").change(function() {
			var $file = $(this);
			var fileObj = $file[0];
			var windowURL = window.URL || window.webkitURL;
			var dataURL;
			var $img = $("#preview");

			if(fileObj && fileObj.files && fileObj.files[0]){
				dataURL = windowURL.createObjectURL(fileObj.files[0]);
				$img.attr('src',dataURL);
			}
			else{
				dataURL = $file.val();
				var imgObj = document.getElementById("preview");
				imgObj.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
				imgObj.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = dataURL;
			}
		});
	});
</script>
</body>
</html>
