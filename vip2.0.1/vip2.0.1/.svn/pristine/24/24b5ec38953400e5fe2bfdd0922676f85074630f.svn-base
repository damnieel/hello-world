<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Strict//EN">
<html lang="en">
<head>
<meta name="Generator" content="EditPlus">
<meta name="Author" content="">
<meta name="Keywords" content="">	
<meta name="Description" content="">
<meta http-equiv="X-UA-Compatible" content="chrome=1;IE=Edge;">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/common/commonResource.jsp" %>
<style>
body{ background:#f4f4f4;}
</style>
<title>登录</title>
</head>
<body>
<div class="login">
  <div class="login_logo"><img src="${basePath}resources/images/logo.png" /></div>
  <div class="login_con">
      <h3>登录</h3>
      <div class="wth_298 box clearfix"><span><i class="main_icon name_icon"></i></span><input type="text" id= "username" placeholder="输入用户名" class="login_box wth_244"></div>
      <div class="wth_298 box clearfix"><span><i class="main_icon password_icon"></i></span><input type="password" id = "password" placeholder="输入密码" class="login_box wth_244"></div>
      <c:if test="${sessionScope.loginCount>=3}">
            <div class="wth_212 box clearfix"><span><i class="main_icon yzm_icon"></i></span><input type="text" id = "code" placeholder="输入验证码" class="login_box wth_158">
            <div class="yzm"><img src="${basePath}admin/code/codeShow.htmls" id="codeImg" style="width:80px; height:39px;">&nbsp;<a class="color_blue" onclick="changeCodeImg()" href="javascript:void(0);">看不清，换一张</a></div></div>
       </c:if>
      <input type="button" value="立即登录" class="login_btn bg_blue" onclick="loginAction();" id="login">
  </div> 
</div>  
<script src="${basePath}resources/js/login/login.js"></script>
<script src="${basePath}resources/js/sys/editCookies.js"></script>
<script src="${basePath}resources/js/md5.js"></script>
<script type="text/javascript">
	var websocket = null;
	if ('WebSocket' in window) {
		websocket = new WebSocket("${socketPath}/websocket/chatMessageServer.htmls");
	} 
	else if ('MozWebSocket' in window) {
		websocket = new MozWebSocket("${socketPath}/websocket/webSocketServer.htmls");
	} 
	else {
		websocket = new SockJS("http://localhost:8080/vip-web/sockjs/webSocketServer.htmls");
	}
	websocket.onopen = onOpen;
	websocket.onmessage = onMessage;
	websocket.onerror = onError;
	websocket.onclose = onClose;
	      	
    function onOpen(openEvt) {
		console.log(openEvt);
	   // alert(openEvt.Data);
	} 
	
	function onMessage(evt) {
		//alert(evt.data);
	}
	function onError() {}
	function onClose() {}
	
	function doSend() {
		if (websocket.readyState == websocket.OPEN) {  		
            var msg = document.getElementById("inputMsg").value;  
            websocket.send(msg);//调用后台handleTextMessage方法
            alert("发送成功!");  
        } else {  
        	alert("连接失败!");  
        }  
	} 
</script>
</body>
</html>

