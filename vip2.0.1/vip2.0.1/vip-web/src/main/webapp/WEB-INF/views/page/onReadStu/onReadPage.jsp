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
<link href="${basePath}resources/css/pagination/page.css" rel="stylesheet" type="text/css"/>
<title>学员管理_在读学员</title>
</head>
<body>
	<%@include file="/WEB-INF/views/page/sys/left.jsp" %>	
	<div class="main_right">	
		<%@include file="/WEB-INF/views/page/sys/top.jsp" %> 
     	<div class="main_con">
     		<div class="search_condition marb_14 clearfix searchBar">
     			<%-- <%@include file="/WEB-INF/views/page/sys/comboBox.jsp" %> --%>
     			<jsp:include page="/WEB-INF/views/page/sys/comboBox.jsp" >
					<jsp:param name="size" value="4" />
			  	</jsp:include> 
            	<div class="marl_20 fl">根据报名日期：</div>
            	<div class="data_box"><input type="text" class="text_box boxbor"
            	id="startDate" onClick="WdatePicker({maxDate:'#F{$dp.$D(\'endDate\')}',dateFmt:'yyyy-MM-dd',onpicking:tzchangeyear})"  placeholder="起始时间"
            		><i class="main_icon data_img"></i></div>
            	<div class="data_box"><input type="text" class="text_box boxbor"
            		id="endDate" onClick="WdatePicker({minDate:'#F{$dp.$D(\'startDate\')}',dateFmt:'yyyy-MM-dd',onpicking:tzchangeyear})"  placeholder="结束时间"
            		><i class="main_icon data_img"></i></div>
            	<select class="choose_box boxbor fl" id="isArrears"><option value="0">是否欠费</option><option value="Y">是</option><option value="N">否</option></select>
            	<select class="choose_box boxbor fl" id="isRefund"><option value="0">是否退费</option><option value="Y">是</option><option value="N">否</option></select>
            	<select class="choose_box boxbor fl" id="gradeStatue"><option value="0">选择学员班级状态</option><option value="reading">开课</option><option value="end">结课</option></select>
            	<div class="search fl"><input type="text" placeholder="学员编号、姓名、手机、QQ" class="search_box boxbor" id="keyWord"><a class="search_icon main_icon" href="javascript:void(0);"></a></div>
     		</div>
			<div class="marb_14">
	             <div class="stu_info">
	                  <ul>
	                      <li class="oncurrent" id="unDivided" >未分班学员</li>
	                      <li id="divided" >已分班学员</li>
	                  </ul>
	             </div>
	             <div class="stuDetail">
					<div class="operate clearfix">
						<vip:deleteSecurity>
							<a class="deletInfo delet_btn deletStu" href="javascript:void(0);" id="deleteStu">删除</a>
						</vip:deleteSecurity>
						<vip:security operType="update,insert">
							<a class="deletInfo divide_btn divideClass" href="javascript:void(0);" id="dividGrade">分班</a>
						</vip:security>
						</div>
					<div id="allUnfinished"></div>
					<div id="page" style="width:100%; height:40px; padding-top:10px;border-top:1px solid #ccc;display: none;"></div>
				</div>			
			</div>
			<!--班级弹出层-->
			<div class="pop_div classPop">
			     <div class="pop_content">
			          <div class="pop_title"><span>所选专业：PHP</span></div>
			          <div class="pop_class">
			               <h3>分配班级</h3>
			               <p id="checkValue">
			              <!--  <label class="padr_20"><input type="checkbox" name="checkbox" value="班级1"> 班级1</label>
			               <label class="padr_20"><input type="checkbox" name="checkbox" value="班级2"> 班级2</label>
			               <label class="padr_20"><input type="checkbox" name="checkbox" value="班级3"> 班级3</label>
			               <label class="padr_20"><input type="checkbox" name="checkbox" value="班级4"> 班级4</label> --></p>
			          </div>
			          <div class="pop_btn"><a href="javascript:void(0);" class="add_btn bg_blue" id="gradeSure">确定</a><a href="javascript:void(0);" class="add_btn bg_gray marl_20 Quit">取消</a></div>
			     </div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="${basePath}resources/js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="${basePath}resources/js/onReadStu/onReadPageFunction.js"></script>
	<script type="text/javascript" src="${basePath}resources/js/pagin/jquery.pagination.js"></script>
	<script type="text/javascript" src="${basePath}resources/js/onReadStu/paging.js"></script>
	<script type="text/javascript" src="${basePath}resources/js/onReadStu/onReadPage.js"></script>
</body>
</html>