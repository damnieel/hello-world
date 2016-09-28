<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/commonResource.jsp"%>

<%@page isELIgnored="false"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<link href="${basePath}resources/css/zTreeStyle/demo.css"
	rel="stylesheet">
<link href="${basePath}resources/css/pagination/page.css"
	rel="stylesheet">
<link href="${basePath}resources/css/zTreeStyle/zTreeStyle.css"
	rel="stylesheet">
<style>
div#rMenu {
	position: absolute;
	visibility: hidden;
	top: 0;
	background-color: #494F60;
	text-align: left;
	padding-top: 5px;
	padding-bottom: 5px;
	border-radius: 2px;
}

div#rMenu ul li {
	margin: 1px 0;
	padding: 10px 15px;
	cursor: pointer;
	color: #fff;
	list-style: none outside none;
}

div#rMenu ul li:hover {
	background: #DB4055;
}
</style>
<title>系统管理_班级设置</title>
</head>

<body>
	<%@include file="/WEB-INF/views/page/sys/left.jsp"%>
	<div class="main_right">
    <%@include file="/WEB-INF/views/page/sys/top.jsp" %> 
	<!-- 	<div class="clearfix">
			<div class="location">
				<i class="main_icon loca_icon"></i> <span>当前位置：</span> <a
					href="javascript:void(0);">系统管理</a> > <a href="javascript:void(0);">班级设置</a>
			</div>
		</div> -->
		<div class="main_con clearfix">
			<div class="search_condition marb_14 clearfix">
				<div class="search fr marr_20">
					<input type="text" id="searchKey" class="search_box boxbor"
						placeholder="集群、事业部、专业、讲师" /> <a id= "search" href="javascript:void(0);"
						class="search_icon main_icon" ></a>
				</div>

			</div>
			<div class="marb_14 clearfix">
				<div class="frame_left">
					<button type="button" id="toggle_btn" class="toggle_btn bg_blue">展开</button>
					<ul id="treeDemo" class="ztree"></ul>
				</div>
				<div class="frame_right">
				     <div class="marb_14 clearfix" id ="addClass"><a href="javascript:void(0);"  id="add" class="add_btn bg_blue addP"><i class="main_icon add_icon addclass"></i>添加班级信息</a></div>
				     <div id="class"></div>
				     <div id="page" style="width:100%; height:40px; padding-top:10px;border-top:1px solid #ccc;display: none;"></div>
				</div>
			</div>
		</div>
	</div>
	
	<!--新增班级弹出层-->
			<div class="pop_div addClass">
				<div class="pop_content">
					<div class="pop_title">
						<span>添加班级信息</span>
					</div>
					<div class="pop_student">
						<div class="status_con statusCon">
							<p>
								 <span>   专业: </span><select name="selectAge" style="width:
								180px" id="classMajor">
								</select>
							</p>
							<p>
								<span>班级名称：</span><input type="text" class="search_box boxbor"
									id="classname" />
							</p>
							<p>
							<span>班级周期：</span>
								<input type="text" class="text_box boxbor" readonly="readonly" style ="width:102px"
            		                id="startDate" onClick="WdatePicker({maxDate:'#F{$dp.$D(\'endDate\')}',dateFmt:'yyyy-MM-dd'})"  placeholder="开始时间">
            		                <!-- <i class="main_icon data_img"></i> -->
							    <input type="text" class="text_box boxbor" readonly="readonly" style ="width:102px"
            	             	id="endDate" onClick="WdatePicker({minDate:'#F{$dp.$D(\'startDate\')}',dateFmt:'yyyy-MM-dd'})" placeholder="结束时间">
            	             	<!-- <i class="main_icon data_img"></i> -->
							<p>
								<span>讲师:</span><select name="techer" id="teacherCode">
								</select>
								<span>班主任:</span><select name="techer" id="adviserCode">
								</select>
							</p>
						</div>
					</div>
					<div class="pop_btn">
						<a href="javascript:void(0);" class="add_btn bg_blue Sure">确定</a><a
							href="javascript:void(0);" class="add_btn bg_gray marl_20 Quit"
							id="clean">取消</a>
					</div>
				</div>
		</div> 
		
			

</body>
<script type="text/javascript" src="${basePath}resources/js/pagin/jquery.pagination.js"></script>
<script src="${basePath}resources/js/zTree/jquery.ztree.core-3.5.js"></script>
<script src="${basePath}resources/js/zTree/jquery.ztree.excheck-3.5.js"></script>
<script src="${basePath}resources/js/zTree/jquery.ztree.exedit-3.5.js"></script>
<script type="text/javascript" src="${basePath}resources/js/sys/classSetting.js"></script>
<script type="text/javascript" src="${basePath}resources/js/My97DatePicker/WdatePicker.js"></script>
</html>
