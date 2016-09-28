<%@ page language="java" pageEncoding="UTF-8"%>
 <div class="right_top clearfix">
     <div class="fr">
          <span><i class="main_icon user_name"></i>用户名：${sessionScope.employee.nickName}[${sessionScope.employee.name}] </span>
          <span><i class="main_icon duty"></i>角色：${sessionScope.employee.roleName}</span>
      	   <a href="javascript:void(0);" class="main_icon" id="loginOut"></a>
      </div>
 </div>    
 <div class="clearfix">
	<div class="location">
	<i class="main_icon loca_icon"></i>
	<span>当前位置：</span>
	<a href="javascript:void(0);" id="curParentMenuLableName"></a> &gt;
	<a href="javascript:void(0);" id="curMenuLableName"></a>
	</div>
</div>
<script type="text/javascript">
$(function(){
	var menu = getCookie("menu");
	var subMenuInfo = getSubMenuInfo(menu);
	$("#curParentMenuLableName").text(subMenuInfo.parentMenuLableName);
	$("#curMenuLableName").text(subMenuInfo.name);
	$("#curMenuLableName").attr("href", subMenuInfo.url);
});
</script>