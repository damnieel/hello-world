<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8">
<link href="${basePath}resources/css/zTreeStyle/demo.css"
	rel="stylesheet">
<link href="${basePath}resources/css/pagination/page.css"
	rel="stylesheet">
<link href="${basePath}resources/css/zTreeStyle/zTreeStyle.css"
	rel="stylesheet">
<%@ include file="/WEB-INF/common/commonResource.jsp"%>
<title>系统管理_专业框架</title>
</head>
<style>
div#rMenu {
	position: absolute;
	visibility: hidden;
	top: 0;
	background-color: #ccc;
	text-align: left;
	padding-top: 5px;
	padding-bottom: 5px;
	border-radius: 2px;
}

div#rMenu ul li {
	margin: 1px 0;
	padding: 10px 15px;
	cursor: pointer;
	color: #000;
	list-style: none outside none;
}

div#rMenu ul li:hover {
	background: #04B4B3;
	color: #fff;
}
</style>
<body>
	<input type="hidden" id="type" />
	<%@include file="/WEB-INF/views/page/sys/left.jsp"%>
	<div class="main_right">
		<%@include file="/WEB-INF/views/page/sys/top.jsp"%>

		<div class="main_con clearfix">
			<div class="search_condition marb_14 clearfix">
				<div class="search fr marr_20">
					<input type="text" class="search_box boxbor" id="content"
						placeholder="专业、讲师" /> <a href="javascript:void(0);"
						id="searchContent" class="search_icon main_icon"></a>
				</div>
			</div>
			<div class="marb_14 clearfix">
				<div class="frame_left">
					<button type="button" id="toggle_btn" class="toggle_btn add_btn bg_blue">展开</button>
					<ul id="treeDemo" class="ztree"></ul>
					<div id="rMenu">
						<ul>
							<li id="m_add" onclick="addTreeNode();">1:新增职能</li>
							<li id="m_del" onclick="delTreeNode();">2:删除职能</li>
							<li id="m_mod" onclick="editTreeNode();">3:重命名</li>
							<li id="m_app" onclick="appointPerson();">4:指定负责人</li>
						</ul>
					</div>
				</div>

				<div id="showPage" class="frame_right ">
					<div class="marb_14 clearfix">
						<a href="javascript:void(0);" id="addP"
							class="add_btn bg_blue addP"><i
							class="main_icon add_icon addprofession"></i>新增专业</a>
					</div>
					<div id="result"></div>
					<div id="page"></div>
				</div>
			</div>
		</div>
	</div>
	<!--新增职能弹出层 -->
	<div class="pop_div addFunction">
		<div class="pop_content">
			<div class="pop_title">
				<span>新增职能</span>
			</div>
			<div class="pop_student">
				<div class="status_con statusCon">
					<p>
						<span>职能名称：</span><input type="text" id="functionName"
							class="search_box boxbor" />
					</p>
				</div>
			</div>
			<div class="pop_btn">
				<a href="javascript:void(0);" class="add_btn bg_blue Sure">确定</a><a
					href="javascript:void(0);" class="add_btn bg_gray marl_20 Quit">取消</a>
			</div>
		</div>
	</div>
	<!--修改职能弹出层 -->
	<div class="pop_div rename">
		<div class="pop_content">
			<div class="pop_title">
				<span>重命名职能</span>
			</div>
			<div class="pop_student">
				<div class="status_con statusCon">
					<p>
						<span>职能名称：</span><input type="text" id="renameFunctionName"
							class="search_box boxbor" />
					</p>
				</div>
			</div>
			<div class="pop_btn">
				<a href="javascript:void(0);" class="add_btn bg_blue Ok">确定</a><a
					href="javascript:void(0);" class="add_btn bg_gray marl_20 Quit">取消</a>
			</div>
		</div>
	</div>

	<!-- 新增专业弹出层 -->
	<div class="pop_div addProfession" id="addProfession">
		<div class="pop_content">
			<div class="pop_title">
				<span>新增专业</span>
			</div>
			<div class="pop_student">
				<div class="status_con statusCon">
					<!-- <p>
						<span>当前职能：</span><input type="text" id="addColony"
							class="text_box boxbor" disabled>&nbsp;&nbsp;&nbsp;<input
							type="text" class="text_box boxbor" id="addBranch" disabled>
					</p> -->
					<p>
						<span>专业名称：</span><input id="addMajorName" type="text"
							class="search_box boxbor" placeholder="1~15个 字符，支持汉字、字母" />
					</p>
					<p>
						<span>专业代码：</span><input id="addMajorCode" type="text"
							class="search_box boxbor" placeholder="1~10个 字母" />
					</p>
					<p>
						<span>讲师：</span><input type="text" id="teacherCode" readonly="readonly" class="search_box boxbor addT" />
					</p>
					<p>
						<span>班主任：</span><input type="text" id="adviserCode" readonly="readonly" class="search_box boxbor addA" />
					</p>
				</div>
			</div>
			<div class="pop_btn">
				<a href="javascript:void(0);" class="add_btn bg_blue addOk">确定</a><a
					href="javascript:void(0);" class="add_btn bg_gray marl_20 Quit">取消</a>
			</div>
		</div>
	</div>


	<!-- 修改专业弹出层 -->
	<div class="pop_div updateProfession" id="updateProfession">
		<div class="pop_content">
			<div class="pop_title">
				<span>修改专业</span>
			</div>
			<div class="pop_student">
				<div class="status_con statusCon">
					<!-- <p>
						<span>当前职能：</span><input type="text" id="updateColony"
							class="text_box boxbor" disabled>&nbsp;&nbsp;&nbsp;<input
							type="text" class="text_box boxbor" id="updateBranch" disabled>
					</p> -->
					<p>
						<span>专业名称：</span><input id="updateMajorName" type="text"
							class="search_box boxbor" />
					</p>
					<p>
						<span>专业代码：</span><input id="updateMajorCode"   type="text"
							class="search_box boxbor" />
					</p>
					<p>
						<span>讲师：</span><input type="text" id="updateTeacherCode" readonly="readonly" class="search_box boxbor updateT" />
					</p>
					<p>
						<span>班主任：</span><input type="text" id="updateAdviserCode" readonly="readonly" class="search_box boxbor updateA" />
					</p>
				</div>
			</div>
			<div class="pop_btn">
				<a href="javascript:void(0);" id="updateOk"
					class="add_btn bg_blue updateOk">确定</a><a
					href="javascript:void(0);" class="add_btn bg_gray marl_20 Quit">取消</a>
			</div>
		</div>
	</div>


	<!--新增讲师弹出层-->
	<div class="pop_div addProfes">
		<div class="pop_content1">
			<div class="pop_title">
				<span>配置讲师</span>
			</div>
			<div class="teacher_popup_cont">
				<div class="clearfix">
					<div class="fl">
						<p>讲师列表：</p>
						<div class="teacher_list_box bdr_gray">
							<p class="teacher_list_title bgd_white bdr_btm_gray">
								<input type="text" class="teacher_list_input"
									placeholder="真名、昵称" id="addTeacherSearchContent">
								<a class="search_icon main_icon " href="javascript:void(0);" id="addTeacherSearch"></a>
							</p>
							<div class="teacher_list_cont" id="teacherList">
							</div>
						</div>
					</div>
					<div class="teacher_btn_box fl">
						<!-- 没有选择老师 -->
						<a class="teacher_btn_add bg_gray" style="display: none;" href="javascript:void(0)">添加</a>
						<a class="teacher_btn_del bg_gray" style="display: none;" href="javascript:void(0)">移除</a>
						<!-- 选择老师后 -->
						<a class="teacher_btn_add bg_blue" href="javascript:void(0)" id="addTeacher">添加</a>
						<a class="teacher_btn_del bg_blue" href="javascript:void(0)" id="removeTeacher">移除</a>
					</div>
					<div class="fr">
						<p>已选择讲师：</p>
						<div class="teacher_list_box bdr_gray">
							<div class="teacher_list_cont" id="chooseTeacher">
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="pop_btn">
				<a href="javascript:void(0);" class="add_btn bg_blue addTeacherOK">确定</a><a
					href="javascript:void(0);" class="add_btn bg_gray marl_20 teacherBack">取消</a>
			</div>
		</div>
	</div>
	
	
	<!--新增班主任弹出层-->
	<div class="pop_div addAdviser">
		<div class="pop_content1">
			<div class="pop_title">
				<span>配置班主任</span>
			</div>
			<div class="teacher_popup_cont">
				<div class="clearfix">
					<div class="fl">
						<p>班主任列表：</p>
						<div class="teacher_list_box bdr_gray">
							<p class="teacher_list_title bgd_white bdr_btm_gray">
								<input type="text" class="teacher_list_input"
									placeholder="真名、昵称" id="addAdviserSearchContent">
								<a class="search_icon main_icon " href="javascript:void(0); " id="addAdviserSearch"></a>
							</p>
							<div class="teacher_list_cont" id="adviserList">
							</div>
						</div>
					</div>
					<div class="teacher_btn_box fl">
						<!-- 没有选择老师 -->
						<a class="teacher_btn_add bg_gray" href="javascript:void(0)" id="addAdviser">添加</a>
						<a class="teacher_btn_del bg_gray" href="javascript:void(0)" id="removeAdviser">移除</a>
						<a style="display: none;" class="teacher_btn_add bg_blue"
							href="javascript:void(0)">添加</a> <a style="display: none;"
							class="teacher_btn_del bg_blue" href="javascript:void(0)">移除</a>
					</div>
					<div class="fr">
						<p>已选择班主任：</p>
						<div class="teacher_list_box bdr_gray">
							<div class="teacher_list_cont" id="chooseAdviser">
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="pop_btn">
				<a href="javascript:void(0);" class="add_btn bg_blue addAdviserOk">确定</a><a
					href="javascript:void(0);" class="add_btn bg_gray marl_20 adviserBack">取消</a>
			</div>
		</div>
	</div>
	
<div class="pop_div addSuperior">
     <div class="pop_content">
          <div class="pop_title"><span>指定负责人</span></div>
          <div class="pop_student">
               <p class="superior_name">负责人列表</p>
               <div class="superior clearfix">
                    <ul id="superiorList">
                    </ul>
               </div>
               <p class="superior_name"><span>当前职能：</span><input type="text" id="superiorBranchName" class="text_box boxbor"  disabled></p>
          </div>
          <div class="pop_btn"><a href="javascript:void(0);" class="add_btn bg_blue addSuperiorOk">确定</a><a href="javascript:void(0);" class="add_btn bg_gray marl_20 Quit">取消</a></div>
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
							<span>专业：</span><input   type="text" id="classMajor"
							class="text_box boxbor" disabled>
							</p>
							<p>
								<span>班级名称：</span><input  type="text" class="search_box boxbor"
									id="addClassName" />
							</p>
							<p>
							<span>班级周期：</span>
								<input  type="text" class="text_box boxbor" readonly="readonly" style ="width:92px;margin-left:4px;"
            		                id="startDate" onClick="WdatePicker({maxDate:'#F{$dp.$D(\'endDate\')}',dateFmt:'yyyy-MM-dd'})"  placeholder="开始时间">
            		                <!-- <i class="main_icon data_img"></i> -->
							    <input type="text" class="text_box boxbor" readonly="readonly" style ="width:92px"
            	             	id="endDate" onClick="WdatePicker({minDate:'#F{$dp.$D(\'startDate\')}',dateFmt:'yyyy-MM-dd'})" placeholder="结束时间">
            	             	<!-- <i class="main_icon data_img"></i> -->
							<p>
								<span>讲师：</span><select  style="margin-left:8px;width:92px"  name="techer" id="chooseClassTeacher">
								</select>
							</p>
							<p>
								<span>班主任：</span><select  style="margin-left:8px;width:92px" name="adviser" id="chooseClassAdviser">
								</select>
							</p>
							
						</div>
					</div>
					<div class="pop_btn">
						<a href="javascript:void(0);" class="add_btn bg_blue addClassOk">确定</a><a
							href="javascript:void(0);" class="add_btn bg_gray marl_20 Quit"
							id="clean">取消</a>
					</div>
				</div>
		</div> 
</body>
<script type="text/javascript" src="${basePath}resources/js/jquery.pagination.js"></script>
<script type="text/javascript" src="${basePath}resources/js/pageQuery.js"></script>
<script src="${basePath}resources/js/zTree/jquery.ztree.core-3.5.js"></script>
<script src="${basePath}resources/js/zTree/jquery.ztree.excheck-3.5.js"></script>
<script src="${basePath}resources/js/zTree/jquery.ztree.exedit-3.5.js"></script>
<%-- <script type="text/javascript" src="${basePath}resources/js/My97DatePicker/WdatePicker.js"></script> --%>
<script type="text/javascript" src="${basePath}resources/js/major/major.js"></script>
</html>
