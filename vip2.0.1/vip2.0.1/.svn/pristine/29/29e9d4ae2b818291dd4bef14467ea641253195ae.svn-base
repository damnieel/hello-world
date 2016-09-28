<%@ page isELIgnored="false"%>
<%
	String path = request.getContextPath(); 
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
	String socketPath = "ws://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
	session.setAttribute("basePath",basePath); 
	session.setAttribute("socketPath", socketPath);
	//String imgBasePath="http://static.tanzhouedu.com/";
	String imgBasePath="http://112.74.133.189/";
	session.setAttribute("imgBasePath",imgBasePath);
%>
<script type="text/javascript">
	var basePath = "${basePath}";
	var socketPath ="${socketPath}";
	var imgBasePath="${imgBasePath}";
	var pauseSecond=3;
	//精确计算浮点乘法
	function accMul(arg1,arg2)
	{
		var m=0,s1=arg1.toString(),s2=arg2.toString();
		try{m+=s1.split(".")[1].length}catch(e){}
		try{m+=s2.split(".")[1].length}catch(e){}
		return Number(s1.replace(".",""))*Number(s2.replace(".",""))/Math.pow(10,m)
	}

	Number.prototype.mul = function (arg){
		return accMul(arg, this);
	}

	//精确计算浮点加法
	function accAdd(arg1,arg2){
		var r1,r2,m;
		try{r1=arg1.toString().split(".")[1].length}catch(e){r1=0}
		try{r2=arg2.toString().split(".")[1].length}catch(e){r2=0}
		m=Math.pow(10,Math.max(r1,r2))
		return (arg1*m+arg2*m)/m
	}

	Number.prototype.add = function (arg){
		return accAdd(arg,this);
	}
	
	/**
	 * 扩展date的format
	 * @param fmt
	 * @returns
	 */
	Date.prototype.Format = function (fmt) { //author: meizz 
	    var o = {
	        "M+": this.getMonth() + 1, //月份 
	        "d+": this.getDate(), //日 
	        "h+": this.getHours(), //小时 
	        "m+": this.getMinutes(), //分 
	        "s+": this.getSeconds(), //秒 
	        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
	        "S": this.getMilliseconds() //毫秒 
	    };
	    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	    for (var k in o)
	    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
	    return fmt;
	}
    
	Date.prototype.Diff = function(date){
		 var day = 24 * 60 * 60 *1000;
		 var cha = (this.getTime() - date.getTime())/day;    
	     return cha;  
	}
	
	// post提交
	function post(url, params){
		var temp = document.createElement("form");  
		temp.action = url;         
		temp.method = "get";          
		temp.style.display = "none";   
		for (var x in params) {          
	        var opt = document.createElement("textarea");   
	        opt.name = x;          
	        opt.value = params[x];            
	        temp.appendChild(opt);          
	    }          
	    document.body.appendChild(temp);          
	    temp.submit();          
	    return temp;  
	}
	
	function triggerDateUtil(id){
		$("#"+id).select();
		$("#"+id).focus();
		document.getElementById(id).click();
	}
</script>
<%@include file="/WEB-INF/common/taglib.jsp" %>
