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
<%@include file="/WEB-INF/common/common.jsp" %>
<link href="${basePath}resources/css/global.css" rel="stylesheet">
<link href="${basePath}resources/css/main.css" rel="stylesheet">
<link href="${basePath}resources/css/pagination/page.css" rel="stylesheet">
<script src="${basePath}resources/js/jquery-1.11.1.min.js"></script>
<title>教务管理_学员作业_学员作业考查</title>
</head>

<body>
   <!-- 引用头部和左边菜单栏 -->
   <%@include file="/WEB-INF/views/page/sys/left.jsp" %>
   <!--内容部分-->
    <div class="main_right">
	      <%@include file="/WEB-INF/views/page/sys/top.jsp" %> 
	     <div class="main_con">
	         <div class="marb_14">
	             <table width="100%" class="table_style">
	             <tr>
	             <th colspan="4" class="tab_title">学员作业考查 /  班级：${opClaName}</th>
	             </tr>
	              <c:if test="${operate == 'edit' }">
	             <tr>
	             <td width="128"><b>学员作业考查日期</b></td>
	             <td><b>学员作业考查详情</b></td>
	             <td width="270"><b>备注</b></td>
	             <td width="188"><b>操作</b></td>
	             </tr>
	             <tr>
	             <td><div class="data_box"><input id="checkDate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" type="text" class="text_box boxbor"><i class="main_icon data_img" onclick="triggerDateUtil('checkDate')"></i></div></td>
	             <td id="studentDesc" class="classStu"><span></span></td>
	             <td><input id="note" type="text" class="edit_box1 boxbor" placeholder="0-20个字"></td>
	             <td>
	             <vip:security operType="insert,update" organizationId="${opClaId}">
	             <a href="javascript:saveHmwork();" class="add_btn bg_blue marl_20">保存</a><a href="javascript:unSaveHmwork();" class="add_btn bg_gray marl_20">撤销</a>
	             </vip:security>
	             </td>
	             </tr>
	             </c:if>
	             </table>
	             <input id="itemCount" type="hidden" value=""/>
	             <div id="result" class="mart_14"></div>
	             <div id="page" class="mart_14"></div>
	             <div id="revoke" class="mart_14"><a id="jump" href="javascript:backToClass();" class="add_btn bg_gray"><span id="jumpE">返回</span></a></div>
	         </div>
	     </div>
	</div>
	
	<!--班级学员列表弹出层-->
	<div class="pop_div classStuList">
	     <div class="pop_content1">
	          <div class="pop_title"><span class="textcenter">班级学员列表</span><a href="javascript:void(0);" class="main_icon close_div Quit"></a></div>
	          <div class="pop_class">
	               <div class="class_list clearfix">
	                    <div id="checkStuDiv"><label><input id="checkStu" type="checkbox" onClick="checkStudent();">全选</label></div>    
	                    <div id="stuCheckList"></div>
	               </div>
	          </div>
	          	<div class="pop_btn"><a id="saveStu" href="javascript:void(0);" class="add_btn bg_blue">确定</a>
	          	<a id="cancelStu" href="javascript:void(0);" class="add_btn bg_gray marl_20 Quit">取消</a>
	          	</div>
	     </div>
	</div>
</body>
<script type="text/javascript">
    var studentList = ${students};
	var operate = "${operate}";
 	var opClaId = ${opClaId}; 
	var opProId = ${opProId};
	var searchParam = ${searchParam};
</script>

<script type="text/javascript" src="${basePath}resources/js/tmDialog.js"></script>
<script type="text/javascript" src="${basePath}resources/js/sg.js"></script>
<script type="text/javascript" src="${basePath}resources/js/sgutil.js"></script> 
<script type="text/javascript" src="${basePath}resources/js/jquery.pagination.js"></script>
<script type="text/javascript" src="${basePath}resources/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${basePath}resources/js/pageQuery.js"></script>
<script type="text/javascript" src="${basePath}resources/js/educational/homework.js"></script> 
</html>