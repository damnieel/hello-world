<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglib.jsp"%>
<%@page isELIgnored="false"%>

<tr>
	<th width="80">序号</th>
	<th>学员姓名</th>
	<th>手机</th>
	<th>QQ</th>
	<th>状态</th>
	<th>官网账号(电商账号)</th>
	<th>操作</th>
</tr>
<c:if test="${fn:length(list) == 0}">
	<tr>
		<td colspan="14">暂无数据</td>
	</tr>
</c:if>
<c:forEach items="${list}" var="list" varStatus="status">
	<tr>
		<td>${status.count}</td>
		<td>${list.name}</td>
		<td>${list.telephone}</td>
		<td>${list.qq}</td>
		<c:if test="${list.authStatus == 'N'}">
			<td>未授权</td>
			<td>--</td>
			<td><a class="again_btn bg_blue marl_20 authStu"
				stuid="${list.id}" href="javascript:void(0)">授权</a></td>
		</c:if>
		<c:if test="${list.authStatus == 'Y'}">
			<td>已授权</td>
			<td>${list.account}</td>
			<td><a class="again_btn bg_blue marl_20 cancelauthStu"
				stuid="${list.id}" href="javascript:void(0)">取消授权</a></td>
		</c:if>
	
	<%-- 	<c:if test="${list.authStatus == 'N'}">
			<td><a class="again_btn bg_blue marl_20 authStu"
				stuid="${list.id}" href="javascript:void(0)">授权</a></td>
		</c:if>
		<c:if test="${list.authStatus == 'Y'}">
			<td><a class="again_btn bg_blue marl_20 cancelauthStu"
				stuid="${list.id}" href="javascript:void(0)">取消授权</a></td>
		</c:if> --%>
	</tr>
</c:forEach>



<%-- <script type="text/javascript"
	src="${basePath}resources/js/sys/authManage/authDetail.js"></script> --%>
	
<!-- <script type="text/javascript">
var stuid;
var stuName;
var dom;
$(function(){
	/**授权**/
	$(".authStu").click(function() {
		dom = $(this);
		stuName = $(this).parent().parent().find('td').eq(1).text();
		stuid = $(this).attr("stuid");
		$("#authText").html("请输入学员电商帐号授权访问学员<a><font color= 'red'>["+stuName +"]</font></a>的专业档案：");
		$("#authWin").show();
	
	});
	/**取消授权**/
	$(".cancelauthStu").click(function(){
		$("#cancelWin").show();
		stuName = $(this).parent().parent().find('td').eq(1).text();
		var account = $(this).parent().parent().find('td').eq(5).text();
		$("#cancelText").html("您确定取消帐号<a><font color= 'red'>["+account +"]</font></a>与<a><font color= 'red'>["+stuName +"]</font></a>绑定授权关系吗？");
		stuid = $(this).attr("stuid");
	})
	/**授权确认**/
	$("#authsure").off("click").on("click",function(){
		var account = $("#account").val();
		if(isEmpty(account)){
			tmLoading("请输入官网账号！",2);
			return;
		}
		authStu(account);
	});
	
	/**取消授权确认**/
	$("#cancelsure").off("click").on("click",function(){
		cancelAuth(stuid);
	});
	
	
	$("#alertsure").off("click").on("click",function(){
		$("#alertWin").hide();
	})
	/**取消按钮**/
	$(".Quit").off("click").on("click",function(){
		$(".pop_div").hide();
	});
	
});
</script>
 -->




