
$(document).keydown(function(event){ 
	var keycode=document.all?event.keyCode:event.which;
	if(keycode==13){
		$("#login").click();
	}
}); 

$(function() {
	var br = navigator.userAgent.toLowerCase();
	var browserVer = (br.match(/.+(?:rv|it|ra|ie)[\/: ]([\d.]+)/) || [ 0, '0' ])[1];
	if ((!!window.ActiveXObject || "ActiveXObject" in window)
			&& browserVer < 9.0) {
		$.tmDialog
				.confirm({
					title : "IE版本过低",
					height : "180px",
					sureText : "好的",
					cancleText : "放弃",
					content : "本系统需要在IE9以上的浏览器运行<br/>推荐使用<a href='http://www.google.cn/chrome/browser'><fontcolor='blue'>chrome</font></a>或<a href='http://www.firefox.com.cn/download'><fontcolor='blue'>firefox</font>！</a>",
					callback : function(ok) {
						if (ok) {
							location.href = "http://www.firefox.com.cn/download";
						} else {
							window.close();
						}
					}
				});
	}
	;
	$("#username").focus();
	$("#code").val("");
});
function loginAction() {
	var username = $("#username").val();
	var password = $("#password").val();
	var code = $("#code").val();
	if (isEmpty(username)) {
		tmLoading("请输入用户名.", 2);
		$("#username").focus();
		return;
	}
	if (!username.match(/^[0-9]{5,12}$/)) {
		$("#username").select();
		tmLoading("账号为数字组合,长度5位到12位.", 1);
		changeCodeImg();
		return;
	}
	if (isEmpty(password)) {
		tmLoading("请输入密码.", 2);
		$("#password").focus();
		return;
	}
	if (loginCountMuch()) {
		if (isEmpty(code)) {
			tmLoading("请输入验证码！", 2);
			$("#code").focus();
			return false;
		}
		if (code.length != 4) {
			tmLoading("请正确输入验证码！", 2);
			$("#code").select();
			changeCodeImg();
			return false;
		}
	}
	password = b64_md5(password); // md5加密
	$.ajax({
		type : "post",
		url : basePath + "admin/employee/loginAction.htmls",
		data : {
			"employeeCode" : username,
			"password" : password,
			"code" : code
		},
		beforeSend : function() {
			tmLoading("正在登录...");
			$("#login").attr("class", "login_btn bg_blue").removeAttr("onclick")
					.text("正在登录");
			$("#login").prop("disabled", true);
		},
		success : function(msg) {
			var msg = eval("(" + msg + ")");
			if (msg.result) {
				loginSuccess();
			} else {
				tmLoading(msg.msg, 1);
				console.log(msg.code);
				
				setTimeout(function(){
					$("#code").val("");
					$("#login").attr("class", "login_btn bg_blue").attr("onclick",
							"loginAction();").text("立即登录");					
					$("#login").prop("disabled", false);
					
					$("#password").val("");
					$("#username").focus();
					changeCodeImg();
					if(loginCountMuch()){
						window.location.reload();
					}
				}, 1000);			
			}
		},
		error : function() {
			tmLoading("系统错误！请联系管理员！", 2);
			$("#login").attr("class", "login_btn bg_blue").attr("onclick",
					"loginAction();").text("立即登录");				
			$("#login").prop("disabled", false);
		}
	});
}
// 登录验证成功
function loginSuccess() {
	tmLoading("登录成功！", 1);
	setCookie("menu", "studentInfoPages");//设置登陆后显示的页面
	setCookie("menuData", "");
	window.location.href = basePath + "student/studentDetail/studentList.htmls";//设置登陆后显示的页面
}
// 修改验证码
function changeCodeImg() {
	var imgSrc = $("#codeImg");
	var src = basePath + "admin/code/codeShow.htmls";
	imgSrc.attr("src", addData(src));
}
// 时间戳
// 为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳
function addData(url) {
	var timetamp = (new Date()).valueOf();
	if ((url.indexOf("&") >= 0)) {
		url = url + "×tamp=" + timetamp;
	} else {
		url = url + "?timestamp=" + timetamp;
	}
	return url;
}
function loginCountMuch() {
	var loginCount = getLoginCount();
	if (Number(loginCount) >= 3) {
		return true;
	}
	return false;
};
function getLoginCount(){
	var count = 0;
	$.ajax({
		type:'GET',
		async: false,
		url:basePath + "admin/employee/getLoginCount.htmls",
		success:function(data){
		 count=eval("("+data+")");
		},
	});
	return count;
};