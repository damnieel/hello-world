var setting = {
	view : {
		selectedMulti : false,
		dblClickExpand : false
	},
	edit : {
		enable : true,
		showRemoveBtn : false,
		showRenameBtn : false,
		drag : {
			autoExpandTrigger : true,
			isCopy : false,
			isMove : true,
		},
	},
	data : {
		simpleData : {
			enable : true
		}
	},
	callback : {
		onDblClick : zTreeOnDblClick,
		onRightClick : OnRightClick,
		onDrag : onDrag,
		beforeDrop : beforeDrop,
		onDrop : onDrop
	}

};
// 加载页面消除新增弹框的值
$(function() {
	$("#addMajorName").val("");
	$("#addMajorCode").val("");
	$("#showPage").hide();
	$("#adviserCode").val("");
	$("#teacherCode").val("");
	teacherArray = new Array();
	adviserArray = new Array();
	cleanAdviser();
	cleanTeacher();
});


//拖拽前创建临时变量获取此时选中节点的父节点，以备将来跟拖拽后的父节点比较来判断是否只是顺序发生了变化
var parentNode1;
function onDrag(event, treeId, treeNodes) {
	parentNode1 = zTree.getSelectedNodes()[0].getParentNode();
	return true;
}

// 拖拽落地前确认是否要如此操作
function beforeDrop(treeId, treeNodes) {
	var nodes = zTree.getSelectedNodes();
	var node=zTree.getSelectedNodes()[0];
	if (nodes && nodes.length > 0) {
		var msg = "是否确定更改["+node.name+"]的位置？\n\n请确认！";
		return confirm(msg);
	}
}
// 拖拽落地后的回调函数，交互数据库
var parentNode2, pId, dragNode, dragId, layer;
function onDrop() {
	dragNode = zTree.getSelectedNodes()[0];
	parentNode2 = dragNode.getParentNode();
	// 通过getParentNode()方法判断父节点是否变化，没变化就不要交互数据库
	if (parentNode1 == parentNode2) {
		hint("您没有修改该机构的层级！");
		return;
	} else {
		dragId = dragNode.id;//得到要拖拽的数据的Id
		if (parentNode2 != null) {
			pId = parentNode2.id;
			$.ajax({
				type : "POST",
				url : basePath+ "majorFrame/updateOrganizationPid.htmls",
				data : {
					"pId" : pId,
					"id" : dragId
				},
				dataType : "json",
				success : function(data) {
					if (data >0) {
						hint("拖拽修改成功！");
						setTimeout(function(){location.reload();},1500);
					} else if(data==0){
						hint("父部门为空，暂时不能拖拽");
					}else{
						hint("拖拽修改失败！");
					}
				}
		    });
		} else {
			hint("警告：非法操作！");
			zTree.moveNode(parentNode1, dragNode, "inner");
		}
	}
}
function hint(param) {
	layer = document.createElement("div");
	layer.id = "layer";
	var style = {
		background : "#DB4056",
		color : "#fff",
		position : "absolute",
		zIndex : 10,
		padding : "10px",
		left : "340px",
		top : "250px"
	}
	for ( var i in style) {
		layer.style[i] = style[i];
	}
	layer.innerHTML = param;
	document.body.appendChild(layer);
	setTimeout("document.body.removeChild(layer)",1500);
}

/* 查找机构初始化树 */
var zTree, rMenu;
$.ajax({
	type : "POST",
	url : basePath + "majorFrame/allMajorFrameInfo.htmls",
	dataType : "json",
	success : function(data) {
		$.fn.zTree.init($("#treeDemo"), setting, data);
		zTree = $.fn.zTree.getZTreeObj("treeDemo");
		rMenu = $("#rMenu");
	},
});

// 双击绑定的事件
function zTreeOnDblClick(event, treeId, treeNode) {
	onDbClick();
};

function onDbClick(){
	$("#showPage").hide();
	$("#addP").show();
	var departMentId = zTree.getSelectedNodes()[0].id;
	var nodes = zTree.getSelectedNodes()[0];
	var bool = false;
	var type=zTree.getSelectedNodes()[0].type;
	var childNodes=null;
	if(null!=zTree.getSelectedNodes()[0].children){ //获得选中节点的子节点
		childNodes=zTree.getSelectedNodes()[0].children;
	}
	if ("org"== type) {
		var isMajor=false;
		if(null!=childNodes){
			for (var i=0;i<childNodes.length;i++){
				if("pro"==childNodes[i].type){//如果是专业
					isMajor=true;
					break;
				}
			}
		}
		if(!isMajor&&null!=childNodes){
			zTree.expandNode(nodes);
		}else{
			getPro(departMentId,type)
		}
	} else if ("pro"== type) {
		getClass(departMentId,type);
	} 
}
function getPro(departMentId,type){
	var majorSearchopts = {
			"startNumber" : 0,
			"pagesize" : 10,
			"id" : departMentId,
			"countUrl" : basePath + "majorFrame/getSearchCount.htmls",
			"dataUrl" : basePath + "majorFrame/searchContent.htmls",
			callback : function() {
				$("#type").val(type);
				$("#addP").html("新增专业");
				$("#showPage").fadeIn(200);
			}
		};
		pageQuery(majorSearchopts);
}

function getClass(departMentId,type){
	var majorSearchopts = {
			"startNumber" : 0,
			"pagesize" : 10,
			"id" : departMentId,
			"countUrl" : basePath + "majorFrame/getClassCount.htmls",
			"dataUrl" : basePath + "majorFrame/getClassInfo.htmls",
			callback : function() {
				$("#type").val(type);
				$("#addP").html("新增班级");
				$("#showPage").fadeIn(200);
			}
		};
	pageQuery(majorSearchopts);
}
/*//双击部门获得专业
function getMajor(departMentId,type){
	
}*/
function addTreeNode() {
	var majorId = zTree.getSelectedNodes()[0].id;
	var childNodes=null;
	var isMajor=false;
	if(null!=zTree.getSelectedNodes()[0].children){ //获得选中节点的子节点
		childNodes=zTree.getSelectedNodes()[0].children;
	}
	if(null!=childNodes){
		for (var i=0;i<childNodes.length;i++){
			if("pro"==childNodes[i].type){//如果是专业
				isMajor=true;
				break;
			}
		}
	}
	if(isMajor){
		tmLoading("你选中的菜单下已有专业,不可新增职能!", 2);
		hideRMenu();
		return;
	}
//	var level = zTree.getSelectedNodes()[0].level;
	/*if (level == 1 || level == 0) {
		$("#functionName").val("").focus().val("");
		$(".addFunction").fadeIn(200);
		hideRMenu();
	} else if (level == 2) {
		hideRMenu();
		tmLoading("你选中的菜单为二级菜单,不可新增子节点!", 2);
	}*/
	$("#functionName").val("").focus().val("");
	$(".addFunction").fadeIn(200);
	hideRMenu();
}

// 新增职能点击确定触发的弹出框
$(".Sure").click(function() {
	var name = $("#functionName").val();
	if (isEmpty(name)) {
		tmLoading("职能名称不能为空", 2);
		$("#functionName").val("").focus();
		return;
	} else if (name.length > 8) {
		tmLoading("职能名称超出限制", 2);
		$("#functionName").val("").focus().val(name);
		return;
	}

	if (/[@#\$%\^&\*]+/g.test(name)) {
		tmLoading("职能名称不能输入非法字符", 2);
		$("#functionName").val("").focus().val(name);
		return;
	}
	var majorId = zTree.getSelectedNodes()[0].id;
	$.ajax({
		type : "POST",
		url : basePath + "majorFrame/add.htmls",
		dataType : "json",
		data : {
			"pId" : majorId,
			"name" : name
		},
		success : function(data) {
			if (data >= 1) {
				tmLoading("添加成功", 2);
				$(".pop_div").hide();
				var newNode = {
					id : data,
					name : name,
					type:"org"
				};
				newNode.checked = zTree.getSelectedNodes()[0].checked;
				zTree.addNodes(zTree.getSelectedNodes()[0], newNode);
				return;
			} else if (data == -1) {
				tmLoading("该职能名称已存在,请重新输入", 2);
				$("#functionName").val("").focus().val(name);
				return;
			} else if (isEmpty(data)) {
				tmLoading("该职能名称已存在,请重新输入", 2);
				$("#functionName").val("").focus().val(name);
				return;
			} else {
				tmLoading("添加失败");
				$(".pop_div").hide();
				return;
			}
		}
	});
});

function delTreeNode() {
	hideRMenu();
	tm_dialoag.confirm({
		content : "你确定删除该职能？",
		callback : function(ok) {
			if (ok) {
				var majorId = zTree.getSelectedNodes()[0].id;
				$.ajax({
					type : "POST",
					url : basePath + "majorFrame/delete.htmls",
					dataType : "json",
					data : {
						"id" : majorId
					},
					success : function(data) {
						if (data > 0) {
							tmLoading("删除成功", 2);
							var nodes = zTree.getSelectedNodes();
							zTree.removeNode(nodes[0]);
							return;
						} else {
							tmLoading("你选择的职能可能有相关的部门或者专业,不可删除", 2);
							return;
						}
					}
				});
			}
		}
	});
}

// 重命名
var name;
function editTreeNode() {
	$(".rename").fadeIn(200);
	name = zTree.getSelectedNodes()[0].name;
	$("#renameFunctionName").val("").focus().val(name);
	$("#renameFunctionName").select();
	hideRMenu();
}

$(".Ok").click(function() {
	var newName = $("#renameFunctionName").val();
	if (isEmpty(newName)) {
		tmLoading("职能名称不能为空", 2);
		$("#renameFunctionName").val("").focus();
		return;
	} else if (newName.length > 8) {
		tmLoading("职能名称超出限制", 2);
		$("#renameFunctionName").val("").focus().val(newName);
		return;
	} else if (name == newName) {
		tmLoading("修改职能名称成功", 2);
		$(".pop_div").hide();
		return;
	}
	if (/[@#\$%\^&\*]+/g.test(newName)) {
		tmLoading("职能名称不能输入非法字符", 2);
		$("#renameFunctionName").val("").focus().val(newName);
		return;
	}

	var majorId = zTree.getSelectedNodes()[0].id;
	$.ajax({
		type : "POST",
		url : basePath + "majorFrame/rename.htmls",
		dataType : "json",
		data : {
			"id" : majorId,
			"name" : newName
		},
		success : function(data) {
			if (data == 1) {
				var newNode = zTree.getSelectedNodes();
				newNode[0].name = newName;
				zTree.updateNode(newNode[0]);
				tmLoading("修改职能名称成功", 2);
				$(".pop_div").hide();
				var majorSearchopts = {
					"startNumber" : 0,
					"pageize" : 10,
					"id" : majorId,
					"countUrl" : basePath
							+ "majorFrame/getSearchCount.htmls",
					"dataUrl" : basePath
							+ "majorFrame/searchContent.htmls",
					callback : function() {
						$("#showPage").fadeIn(200);
					}
				};
				pageQuery(majorSearchopts);
				return;
			} else if (data == -1) {
				tmLoading("该职能名称已存在,请重新输入", 2);
				$("#renameFunctionName").val("").focus().val(newName);
				return;
			} else {
				tmLoading("修改失败", 2);
				$(".pop_div").hide();
				return;
			}
		}
	});
});

// 一键操作按钮
$(document).ready(function() {
	var boolean = true;
	$("#toggle_btn").click(function() {
		if (boolean == true) {
			zTree.expandAll(true);
			$("#toggle_btn").text("折叠");
			boolean = !boolean;
		} else if (boolean == false) {
			zTree.expandAll(false);
			$("#toggle_btn").text("展开");
			boolean = !boolean;
		}
	})
});

var updateMajorId, oldName, oldCode,branchId; // 修改专业 记录专业ID
$("body").on("click", "#updateMajor", function() {
	updateMajorId = $(this).data("uid");
	branchId = $(this).data("bid");
	var majorName = $(this).parent().parent().children("#majorName").html();
	oldName = majorName;
	var majorCode = $(this).parent().parent().children("#majorCode").html();
	oldCode = majorCode;
	var colonyName = $("#colonyName").html();
	var branchName = $("#branchName").html();
	$("#updateTeacherCode").val("");
	$("#updateAdviserCode").val("");
	$("#updateColony").val(colonyName);
	$("#updateBranch").val(branchName);
	$("#updateMajorName").val("").focus().val(majorName);
	$("#updateMajorCode").val("").focus().val(majorCode);
	$("#teacherList").html("");
	$("#adviserList").html("");
	$("#chooseTeacher").html("");
	$("#chooseAdviser").html("");
	$.ajax({
		type:"POST",
		url:basePath+"majorFrame/getTeacherAndAdviser.htmls",
		data:{
			"id":updateMajorId
		},
		success:function(data){
			data=eval("("+data+")")
			$("#updateTeacherCode").val(data.teacher);
			$("#updateAdviserCode").val(data.adviser);
		}
	});
	
	$.ajax({
		type:"POST",
		url:basePath+"majorFrame/getChooseTeacherListOrAdviserList.htmls",
		data:{
			"id":updateMajorId,
			"type" : "teacher"
		},
		success:function(data){
			teacherArray=new Array();
			$.each(eval(data),function(index,teacherList) {
				teacherArray.push(teacherList.employeeCode);
			});	
		}
	});
	$.ajax({
		type:"POST",
		url:basePath+"majorFrame/getChooseTeacherListOrAdviserList.htmls",
		data:{
			"id":updateMajorId,
			"type" : "adviser"
		},
		success:function(data){
			adviserArray=new Array();
			$.each(eval(data),function(index,adviserList) {
				var checkBoxValue = adviserList.name;
				var adviserId =adviserList.employeeCode;
				adviserArray.push(adviserId);
			});	
		}
	});
	
	$.ajax({
		type:"POST",
		url:basePath+"majorFrame/getChooseTeacherListOrAdviserList.htmls",
		data:{
			"id":updateMajorId,
			"type" : "teacher"
		},
		success:function(data){
			$.each(eval(data),function(index,teacherList) {
				$("#chooseTeacher").append("<p id=\"chooseTeacher"+ teacherList.employeeCode+ "\" "
				+ "class=\"teacher_list\"><input type=\"checkbox\" class=\"mr5\"  name=\"chooseTeacher\" checked=\"true\" title=\""+teacherList.name+"\" value=\""+ teacherList.employeeCode
				+ "\" />"+ teacherList.name+ "</p>");
			});	
		}
	});
	
	$.ajax({
		type:"POST",
		url:basePath+"majorFrame/getChooseTeacherListOrAdviserList.htmls",
		data:{
			"id":updateMajorId,
			"type" : "adviser"
		},
		success:function(data){
			$.each(eval(data),function(index,adviserList) {
				var checkBoxValue = adviserList.name;
				var adviserId =adviserList.employeeCode;
				$("#chooseAdviser").append("<p class=\"teacher_list\" id=\"chooseAdviser"
						+ adviserId+ "\">"+ "<input type=\"checkbox\" title=\""+checkBoxValue+"\" name=\"chooseAdviser\" class=\"mr5\" checked=\"true\"  value=\""
						+ adviserId+ "\"/>"+ checkBoxValue+ "</p>");
			});	
		}
	});
	
	$("#adviserList").html("");
	$.ajax({
		type : "POST",
		url : basePath+"majorFrame/getUpdateTeacherListOrAdviserList.htmls",
		data : {
			"id":updateMajorId,
			"type" : "adviser"
		},
		success : function(data) {
			$.each(eval(data),function(index, adviserList) {
				$("#adviserList").append("<p id=\"noChooseAdviser"
				+ adviserList.employeeCode+ "\"  class=\"teacher_list\"><input type=\"checkbox\" class=\"mr5\" title=\""+adviserList.name+"\"  name=\"noChooseAdviser\" value=\""
				+ adviserList.employeeCode+ "\" />"
				+ adviserList.name+ "</p>");
			});
			
		}
	});
	
	$("#teacherList").html("");
	$.ajax({
		type : "POST",
		url : basePath+"majorFrame/getUpdateTeacherListOrAdviserList.htmls",
		data : {
			"id":updateMajorId,
			"type" : "teacher"
		},
		success : function(data) {
			$.each(eval(data),function(index, adviserList) {
				$("#teacherList").append("<p id=\"noChooseTeacher"
				+ adviserList.employeeCode+ "\" class=\"teacher_list\"><input type=\"checkbox\" title=\""+adviserList.name+"\" class=\"mr5\" name=\"noChooseTeacher\" value=\""
				+ adviserList.employeeCode+ "\" />"
				+ adviserList.name+ "</p>");
			});
			
		}
	});
	
	$("#updateProfession").fadeIn(200);
});

$("body").on("click","#updateOk",function() {
	var majorName = $("#updateMajorName").val();
	var majorCode = $("#updateMajorCode").val();
	if (majorName == "null") {
		$("#updateMajorName").val("").focus().val(majorName);
		tmLoading("专业名称不能为空", 2);
		return;
	}
	if (majorName.length > 15) {
		$("#updateMajorName").val("").focus().val(majorName);
		tmLoading("专业名称输入超出限制", 2);
		return;
	}
	if (/[@#\$%\^&\*]+/g.test(majorName)) {
		tmLoading("专业名称不能输入非法字符", 2);
		$("#updateMajorName").val("").focus().val(majorName);
		return;
	}
	majorCode = $("#updateMajorCode").val();
	if (isEmpty(majorCode)) {
		$("#updateMajorCode").val("").focus().val(majorCode);
		tmLoading("专业代码不能为空", 2);
		return;
	}

	if (majorCode.length > 10 || !(/^[A-Za-z]+$/.test(majorCode))) {
		tmLoading("专业代码必须为字母,且长度不能超过10位", 2);
		$("#updateMajorCode").val("").focus().val(majorCode);
		return;
	}
	$.ajax({
		type : "POST",
		url : basePath + "majorFrame/updateMajor.htmls",
		dataType : "json",
		data : {
			"id" : updateMajorId,
			"name" : majorName,
			"majorName" : oldName,
			"oldCode":oldCode,
			"majorCodeValue" : majorCode,
			"teacherArray" : teacherArray,
			"adviserArray" : adviserArray
		},
		success : function(data) {
			if (data == -1) {
				tmLoading("该专业名称已存在,请重新输入", 2);
				$("#updateMajorName").val("").focus().val(majorName);
				return;
			} else if (data == -2) {
				tmLoading("该专业代码已存在,请重新输入", 2);
				$("#updateMajorCode").val("").focus().val(majorCode);
				return;
			}else if (data==-10){
				tmLoading("必须选择讲师或者班主任", 2);
				return;
			};
			$.ajax({
				type : "POST",
				url : basePath
						+ "majorFrame/updateMajorCode.htmls",
				dataType : "json",
				data : {
					"majorCodeKey" : updateMajorId,
					"majorCodeValue" : majorCode,
					"oldCode" : oldCode
				},
				success : function(data) {
					if (data >= 0) {
						tmLoading("修改专业成功", 2);
						$(".pop_div").hide();
						$("#updateMajorCode")
								.val("");
						$("#updateMajorCode")
								.val("");
						/*var majorSearchopts = {
							"startNumber" : 0,
							"pageize" : 10,
							"id" : branchId,
							"countUrl" : basePath
									+ "majorFrame/getSearchCount.htmls",
							"dataUrl" : basePath
									+ "majorFrame/searchContent.htmls",
							callback : function() {
								$("#showPage").fadeIn(200);
							}
						};
						pageQuery(majorSearchopts);*/
//						window.location.href=window.location.href;
//						zTree.getSelectedNodes()[0].name=majorName;
						var newNode = zTree.getNodeByParam("id", updateMajorId, null);
						newNode.name = majorName;
						var pId=newNode.pId;
						zTree.updateNode(newNode);
						getPro(pId,"pro");	
						return;
					} else if (data == -1) {
						tmLoading("该专业代码已存在,请重新输入",2);
						$("#updateMajorCode").val("").focus().val(majorCode);
						return;
					} else {
						tmLoading("修改失败", 2);
						$(".pop_div").hide();
						return;
					}
				}
			});
		}
	});
});

$(".addQuit").click(function() {
	$("#addMajorName").val("");
	$("#addMajorCode").val("");
	$("#teacherList").html("");
	$("#chooseTeacher").html("");
	$("#adviserCode").val("");
	$("#teacherCode").val("");
	$(".addProfession").hide();
});

function cleanTeacher(){
	$("#teacherList").html("");
	$("#chooseTeacher").html("");
	$("#addTeacherSearchContent").val("");
}
$(".addT").click(function() {
	$("#teacherList").html("");
	$("#addTeacherSearchContent").val("");
	$.ajax({
		type : "POST",
		url : basePath
				+ "majorFrame/selectTeacherOrAdviser.htmls",
		data : {
			type : "teacher"
		},
		success : function(data) {
			$.each(eval(data),function(index, teacherList) {
				$("#teacherList").append("<p id=\"noChooseTeacher"
				+ teacherList.employeeCode+ "\" class=\"teacher_list\"><input type=\"checkbox\" title=\""+teacherList.teacherName+"\" class=\"mr5\"  name=\"noChooseTeacher\" value=\""
				+ teacherList.employeeCode+ "\" />"
				+ teacherList.teacherName+ "</p>");
			});
		}
	});
	$(".addProfes").fadeIn(200);
});

function cleanAdviser(){
	$("#adviserList").html("");
	$("#chooseAdviser").html("");
	$("#addAdviserSearchContent").val("");
}
$(".addA").click(function() {
	$("#adviserList").html("");
	$("#addAdviserSearchContent").val("");
	$.ajax({
		type : "POST",
		url : basePath
				+ "majorFrame/selectTeacherOrAdviser.htmls",
		data : {
			"type" : "adviser"
		},
		success : function(data) {
			$.each(eval(data),function(index, adviserList) {
				$("#adviserList").append("<p id=\"noChooseAdviser"
				+ adviserList.employeeCode+ "\" class=\"teacher_list\"><input type=\"checkbox\" class=\"mr5\" title=\""+adviserList.teacherName+"\" name=\"noChooseAdviser\" value=\""
				+ adviserList.employeeCode+ "\" />"
				+ adviserList.teacherName+ "</p>");
			});
		}
	});
	$(".addAdviser").fadeIn(200);
});

$(".updateTeacherBack").click(function(){
	$(".addProfes").hide();
});
$(".updateT").click(function() {
	$(".addProfes").fadeIn(200);
});

$(".updateA").click(function(){
	$(".addAdviser").fadeIn(200);
});

$(".Quit").click(function() {
	$("#addMajorName").val("");
	$("#addMajorCode").val("");
	$("#updateMajorName").val("");
	$("#updateMajorCode").val("");
	$("#startDate").val("");
	$("#endDate").val("");
	$("#className").val("");
	$(".pop_div").hide();
	cleanTeacher();
	cleanAdviser();
});

$("#addTeacherSearch").click(function() {
	var content = $("#addTeacherSearchContent").val();
	$.ajax({
		type : "POST",
		url : basePath + "majorFrame/searchTeacherOrAdviser.htmls",
		data : {
			"content" : content,
			"type":"teacher"
		},
		success : function(data) {
			$("#teacherList").html("");
			$(eval("("+data+")")).each(function(index,list){
				$("#teacherList").append("<p id=\"noChooseTeacher"
				+ list.employeeCode+ "\" class=\"teacher_list\"><input title=\""+list.name+"\" type=\"checkbox\" class=\"mr5\" name=\"noChooseTeacher\" value=\""
				+ list.employeeCode+ "\" />"+ list.name+ "</p>");
			});
		}
	});
});


$("#addAdviserSearch").click(function() {
	var content = $("#addAdviserSearchContent").val();
	$.ajax({
		type : "POST",
		url : basePath + "majorFrame/searchTeacherOrAdviser.htmls",
		data : {
			"content" : content,
			"type":"adviser"
		},
		success : function(data) {
			$("#adviserList").html("");
			$(eval("("+data+")")).each(function(index,list){
				var checkBoxValue = list.name;
				var teacherId = list.employeeCode;
				$("#adviserList").append("<p id=\"noChooseAdviser"+ teacherId+ "\" class=\"teacher_list\"><input type=\"checkbox\" class=\"mr5\" " +
				" name=\"noChooseAdviser\" title=\""+checkBoxValue+"\" value=\""+ teacherId
				+ "\" />"+ checkBoxValue+ "</p>");
			});
		}
	});
});

var teacherArray;
$(".addTeacher").click(function() {
	teacherArray = new Array();
	$("input:checkbox[name='chooseTeacher']").each(function(index, element) {
		var teacherCode = $(element).val();
		teacherArray.push(teacherCode);
	});
	$(".addProfes").hide();
});

var adviserArray;
$(".addAdviserOk").click(function() {
	adviserArray = new Array();
	adviserStr = "";
	$("input:checkbox[name='chooseAdviser']").each(function(index, element) {
				var adviserCode = $(element).val();
				adviserArray.push(adviserCode);
	});
	$.ajax({
		type : "POST",
		url : basePath + "majorFrame/selectTeacherOrAdviserByCode.htmls",
		data : {
			"type" : "adviser",
			"adviserArray" : adviserArray
		},
		success : function(data) {
			if(null==data||"null"==data){
				$("#adviserCode").val("");
				$("#updateAdviserCode").val("");
				$(".addAdviser").hide();
				return;
			}
			data = eval("(" + data + ")");
			$("#adviserCode").val(data.adviserName);
			$("#adviserCode").attr("title", data.adviser);
			$("#updateAdviserCode").val(data.adviserName);
			$("#updateAdviserCode").attr("title", data.adviser);
		}
	});
	$(".addAdviser").hide();
})

$("#addAdviser").click(function() {
	$("input:checkbox[name='noChooseAdviser']:checked").each(function(index, element) {
			var checkBoxValue = element.title;
			var adviserCode = $(element).val();
			var chooseCode;
			var flag=-1;
			$("input:checkbox[name='chooseAdviser']").each(function(index, chooseList) {
				chooseCode=$(chooseList).val();
				if(adviserCode==chooseCode){
					flag=1;
				}
			});
			if(flag<0){
				addChooseAdviser(adviserCode,checkBoxValue);
			}else{
				var parent = document.getElementById("noChooseAdviser" + adviserCode);
				parent.parentNode.removeChild(parent);
			}
	});
});

function addChooseAdviser(adviserCode,checkBoxValue){
	var parent = document.getElementById("noChooseAdviser"+ adviserCode);
	parent.parentNode.removeChild(parent);
	$("#chooseAdviser").append("<p class=\"teacher_list\" id=\"chooseAdviser"
	+ adviserCode+ "\">"+ "<input type=\"checkbox\" name=\"chooseAdviser\" title=\""+checkBoxValue+"\" class=\"mr5\" checked=\"true\"  value=\""
	+ adviserCode+ "\"/>"+ checkBoxValue+ "</p>");
}

$("#removeAdviser").click(function() {
	$("input:checkbox[name='chooseAdviser']:checked").each(function(index, element) {
		var checkBoxValue = element.title;
		var adviserCode = $(element).val();
		var parent = document.getElementById("chooseAdviser"+adviserCode);
		parent.parentNode.removeChild(parent);
		$("#adviserList").append("<p id=\"noChooseAdviser"+ adviserCode+ "\" class=\"teacher_list\"><input type=\"checkbox\" " +
		"class=\"mr5\" title=\""+checkBoxValue+"\" name=\"noChooseAdviser\" value=\""+ adviserCode+ "\" />"+ checkBoxValue+ "</p>");
	});
	adviserArray=new Array();
	$("input:checkbox[name='chooseAdviser']").each(function(index, element) {
		var adviserCode = $(element).val();
		adviserArray.push(adviserCode);
	});
});

var teacherArray;
$(".addTeacherOK").click(function() {
	teacherArray = new Array();
	$("input:checkbox[name='chooseTeacher']").each(function(index, element) {
		var teacherCode = $(element).val();
		teacherArray.push(teacherCode);
	});
	$.ajax({
		type : "POST",
		url : basePath + "majorFrame/selectTeacherOrAdviserByCode.htmls",
		data : {
			"type" : "teacher",
			"teacherArray" : teacherArray
		},
		success : function(data) {
			if(null==data||"null"==data){
				$("#teacherCode").val("");
				$("#updateTeacherCode").val("");
				$(".addProfes").hide();
				return;
			}
			data = eval("(" + data + ")");
			$("#teacherCode").val(data.teacherName);
			$("#teacherCode").attr("title", data.teacher);
			$("#updateTeacherCode").val(data.teacherName);
			$("#updateTeacherCode").attr("title", data.teacher);
			$(".addProfes").hide();
		}
	});
	
})
var bool=true;
$("#addTeacher").click(function() {
	$("input:checkbox[name='noChooseTeacher']:checked").each(function(index, element) {
		var checkBoxValue =element.title;
		var teacherId = $(element).val();
		var chooseCode;
		var flag=-1;
		$("input:checkbox[name='chooseTeacher']").each(function(index, chooseList) {
			chooseCode=$(chooseList).val();
			if(teacherId==chooseCode){
				flag=1;
			}
		});
		if(flag<0){
			addChooseTeacher(teacherId,checkBoxValue);
		}else{
			var parent = document.getElementById("noChooseTeacher" + teacherId);
			parent.parentNode.removeChild(parent);
		}
		
   });
});

function addChooseTeacher(teacherId,checkBoxValue){
	var parent = document.getElementById("noChooseTeacher" + teacherId);
	parent.parentNode.removeChild(parent);
	$("#chooseTeacher").append("<p class=\"teacher_list\" id=\"chooseTeacher"+teacherId+"\" ><input type=\"checkbox\" name=\"chooseTeacher\" title=\""+checkBoxValue+"\" class=\"mr5\" checked=\"true\"  value=\""
	+ teacherId+ "\"/>"+ checkBoxValue+ "</p>");
}
	
function removeTeacher(teacherId,checkBoxValue){
	var parent = document.getElementById("chooseTeacher" + teacherId);
	parent.parentNode.removeChild(parent);
	$("#teacherList").append("<p id=\"noChooseTeacher"+ teacherId+ "\" "
	+ "class=\"teacher_list\"><input type=\"checkbox\" class=\"mr5\" name=\"noChooseTeacher\" title=\""+checkBoxValue+"\" value=\""+ teacherId
	+ "\" />"+ checkBoxValue+ "</p>");
	teacherArray=new Array();
	$("input:checkbox[name='chooseTeacher']").each(function(index, element) {
		var teacherId = $(element).val();
		teacherArray.push(teacherId);
	});
}
$("#removeTeacher").click(function() {
	$("input:checkbox[name='chooseTeacher']:checked").each(function(index, element) {
		var checkBoxValue = element.title;
		var teacherId = $(element).val();
		removeTeacher(teacherId,checkBoxValue);
	});
});

$(".teacherBack").click(function() {
	$(".addProfes").hide();
});

$(".adviserBack").click(function() {
	$(".addAdviser").hide();
});

$(".addP").click(function() {
	if(undefined==zTree.getSelectedNodes()[0]){
		tmLoading("请选择事业部", 3);
		return;
	}
	var branchId = zTree.getSelectedNodes()[0].id;
	var name = zTree.getSelectedNodes()[0].name;
	var type=$("#type").val();
	if("org"==type){
		$("#addMajorName").val("");
		$("#addMajorCode").val("");
		$("#adviserCode").val("");
		$("#teacherCode").val("");
		teacherArray = new Array();
		adviserArray = new Array();
		$("#addProfession").show();
	}else{
		$("#classMajor").val(name);
		getTeacherOrAdviser(branchId,"teacher");
		getTeacherOrAdviser(branchId,"adviser");
		cleanClassInfo();
		$(".addClass").show();
	}
	
});

function getTeacherOrAdviser(id,type){
	$.ajax({
		url:basePath+"classinfo/classinfo/getProManager.htmls",
		type:'POST',
		async:false,
		data:{
			"type":type,
			"proId":id
		},
		success:function(data){
		  var tdata = eval("("+data+")");
		  if(tdata.length == 0){
			  tmLoading("该专业下未找到讲师或班主任",2);
		  }
		  var html = ""
		  for(var i =0;i < tdata.length ;i++){
			 html +="<option value='"+tdata[i].empCode +"'>" +tdata[i].nickName+ "</option>";
		  }
		  if("teacher"==type){
			 $("#chooseClassTeacher").html(html);
		  }else if ("adviser"==type){
			 $("#chooseClassAdviser").html(html);
		  }
		}
	});
}
function cleanClassInfo(){
	$("#addClassName").val("");
	$("#startDate").val("");
	$("#endDate").val("");
}
$(".addClassOk").click(function(){
	var proId=zTree.getSelectedNodes()[0].id;
	var type=zTree.getSelectedNodes()[0].type;
	var className=$("#addClassName").val();
	var chooseClassTeacher=$("#chooseClassTeacher").val();
	var chooseClassAdviser=$("#chooseClassAdviser").val();
	var start=null;
	var end=null;
	if(className.length==0){
		tmLoading("请输入班级名称",2);
		return;
	}
	if(className.length>15){
		tmLoading("班级名称输入不合法",2);
		return;
	}
	if(!isEmpty($("#startDate").val())){		
		/**开始时间**/
		start=$("#startDate").val();
	}
	if(!isEmpty($("#endDate").val())){
		/**结束时间**/
		end=$("#endDate").val();
	}
	
	if(null==start||null==end){
		tmLoading("请选择一个正确的时间段", 2);
		return;
	}
	$.ajax({
		type:"POST",
		url:basePath+"majorFrame/addClass.htmls",
		data:{
			"majorId":proId,
			"className":className,
			"startDate":start,
			"endDate":end,
			"teacher":chooseClassTeacher,
			"adviser":chooseClassAdviser
		},
		success:function(data){
			data=eval("("+data+")");
			var bool=data.result;
			if(bool){
				tmLoading(data.msg, 2);
				$(".addClass").hide();
				getClass(proId,type);
				return;
			}else{
				tmLoading(data.msg, 2);
//				$(".addClass").hide();
				return;
			}
			
		}
	});
});
$(".addOk").click(function() {
	majorName = $("#addMajorName").val();
	majorCode = $("#addMajorCode").val();
	if (isEmpty(majorName)) {
		$("#addMajorName").val("").focus().val(majorName);
		tmLoading("专业名称不能为空", 2);
		return;
	}
	if (/[@#\$%\^&\*]+/g.test(majorName)) {
		$("#addMajorName").val("").focus().val(majorName);
		tmLoading("专业名称不能输入非法字符", 2);
		return;
	}
	if (majorName.length > 15) {
		tmLoading("专业名称输入超出限制", 2);

		$("#addMajorName").val("").focus().val(majorName);
		return;
	}

	if (isEmpty(majorCode)) {
		tmLoading("专业代码不能为空", 2);
		$("#addMajorCode").val("").focus().val(majorCode);
		return;
	}

	if (/[@#\$%\^&\*]+/g.test(majorCode)) {
		tmLoading("专业代码不能输入非法字符", 2);
		$("#addMajorCode").val("").focus().val(majorCode);
		return;
	}
	if (!(/^[A-Za-z]+$/.test(majorCode))) {
		tmLoading("专业代码必须为字母", 2);
		$("#addMajorCode").val("").focus().val(majorCode);
		return;
	}
	if (majorCode.length > 10) {
		tmLoading("专业代码长度不能超过10位", 2);
		$("#addMajorCode").val("").focus().val(majorCode);
		return;
	}
	var departMentId = zTree.getSelectedNodes()[0].id;
	var addMajorUrl = basePath + "majorFrame/addMajor.htmls";
	var majorId=null;
	$.ajax({
		type : "POST",
		url : addMajorUrl,
		dataType : "json",
		data : {
			"id" : departMentId,
			"name" : majorName,
			"majorCodeValue" : majorCode,
			"teacherList" : teacherArray,
			"adviserList" : adviserArray
		},
		success : function(data) {
			majorId=data;
			if (data == -1) {
				tmLoading("该专业名称已存在,请重新添加", 2);
				$("#addMajorName").val("").focus().val(majorName);
				return;
			} else if (data == -2) {
				tmLoading("专业代码已存在,请重新输入", 2);
				$("#addMajorName").val("").focus().val(majorCode);
				return;
			} else if (data == -5) {
				tmLoading("添加失败", 2);
				return;
			}else if(data==-10){
				tmLoading("必须选择班主任或讲师",2);
				return;
			}
			$.ajax({
				type : "POST",
				url : basePath
						+ "majorFrame/addMajorCode.htmls",
				dataType : "json",
				data : {
					"majorCodeKey" : data,
					"majorCodeValue" : majorCode
				},
				success : function(data) {
					if (data>0) {
						$(".pop_div").hide();
						cleanTeacher();
						cleanAdviser();
						tmLoading("增加专业成功", 2);
						$("#addMajorName").val("");
						$("#addMajorCode").val("");
						$("#adviserCode").val("");
						$("#teacherCode").val("");
						teacherArray = new Array();
						adviserArray = new Array();
						/*var majorSearchopts = {
							"startNumber" : 0,
							"pageize" : 10,
							"id" : departMentId,
							"countUrl" : basePath
									+ "majorFrame/getSearchCount.htmls",
							"dataUrl" : basePath
									+ "majorFrame/searchContent.htmls",
							callback : function() {
								$("#showPage").fadeIn(200);
							}
						};
						pageQuery(majorSearchopts);*/
//						window.location.href=window.location.href;
						var newNode = {
							id : majorId,
							name : majorName,
							type:"pro"
						};
						newNode.checked = zTree.getSelectedNodes()[0].checked;
						zTree.addNodes(zTree.getSelectedNodes()[0], newNode);
						getPro(departMentId,"pro");
						return;
					} else if (data == -1) {
						tmLoading("该专业代码已存在,请重新输入",2);
						$("#addMajorCode").val("").focus().val(majorCode);
						return;
					}
				}
			});
		}
	});

});
// 右键菜单的绑定
function OnRightClick(event, treeId, treeNode) {
	var treeType=treeNode.type;
	if (!treeNode && event.target.tagName.toLowerCase() != "button"
			&& $(event.target).parents("a").length == 0) {
		zTree.cancelSelectedNode();
		showRMenu("root", event.clientX, event.clientY,treeType);
	} else if (treeNode && !treeNode.noR) {
		zTree.selectNode(treeNode);
		showRMenu("node", event.clientX, event.clientY,treeType);
	}
}
function showRMenu(type, x, y,treeType) {
//	alert(treeType);
	if("pro"==treeType){
		$("#rMenu ul").hide();
		return;
	}
	$("#rMenu ul").show();
	if (type == "root") {
		$("#m_add").hide();
		$("#m_del").hide();
		$("#m_mod").hide();
		$("#m_app").hide();
	} else {
		$("#m_add").show();
		$("#m_del").show();
		$("#m_mod").show();
		$("#m_app").show();
	}
	rMenu.css({
		"top" : y + "px",
		"left" : x - 140 + "px",
		"visibility" : "visible"
	});

	$("body").bind("mousedown", onBodyMouseDown);
}
function hideRMenu() {
	if (rMenu)
		rMenu.css({
			"visibility" : "hidden"
		});
	$("body").unbind("mousedown", onBodyMouseDown);
}

function onBodyMouseDown(event) {
	if (!(event.target.id == "rMenu" || $(event.target).parents("#rMenu").length > 0)) {
		rMenu.css({
			"visibility" : "hidden"
		});
	}
}

$("body").on("click","#deleteMajor",function() {
	var majorId = $(this).data("mid");
	var branchId = zTree.getSelectedNodes()[0].id;
	tm_dialoag.confirm({
		content : "你确定删除该专业？",
		callback : function(ok) {
			if (ok) {
				$.ajax({
					type : "POST",
					url : basePath
							+ "majorFrame/deleteMajorById.htmls",
					dataType : "json",
					data : {
						"id" : majorId
					},
					success : function(data) {
						if (data > 0) {
							var majorSearchopts = {
								"startNumber" : 0,
								"pageize" : 10,
								"id" : branchId,
								"countUrl" : basePath
										+ "majorFrame/getSearchCount.htmls",
								"dataUrl" : basePath
										+ "majorFrame/searchContent.htmls",
								callback : function() {
									$("#showPage").fadeIn(200);
									tmLoading("删除成功",2);
								}
							};
							pageQuery(majorSearchopts);
							return;
						} else {
							tmLoading("删除失败", 2);
							return;
						}
					}
				});
			}
		}
	});
});

$("body").on("click", "#searchContent", function() {
	var content = $("#content").val();
	$(".addP").hide();
	if (/[@#\$%\^&\*]+/g.test(content)) {
		tmLoading("输入非法字符", 2);
		return;
	}
	var type=null;
	if(undefined!=zTree.getSelectedNodes()[0]){
		type=zTree.getSelectedNodes()[0].type;
	}
	if("org"==type){
		var majorSearchopts = {
			"startNumber" : 0,
			"pageize" : 10,
			"content" : content,
			"countUrl" : basePath + "majorFrame/getSearchCount.htmls",
			"dataUrl" : basePath + "majorFrame/searchContent.htmls",
			callback : function() {
				$("#showPage").fadeIn(200);
			}
		};
		pageQuery(majorSearchopts);
	}else if("pro"==type){
		var majorSearchopts = {
			"startNumber" : 0,
			"pageize" : 10,
			"content" : content,
			"countUrl" : basePath + "majorFrame/getClassCount.htmls",
			"dataUrl" : basePath + "majorFrame/getClassInfo.htmls",
			callback : function() {
				$("#showPage").fadeIn(200);
			}
		};
		pageQuery(majorSearchopts);
	}else{
		tmLoading("请选择部门或专业后再进行搜索", 2);
		return;
	}
	

});

function appointPerson() {
	var level = zTree.getSelectedNodes()[0].level;
	if (level == 0) {
		tmLoading("\"全部集群\"层级不可指定负责人", 2);
		hideRMenu();
		return;
	}
	$("#superiorList").html("");
	var branchId = zTree.getSelectedNodes()[0].id;
	var branchName = zTree.getSelectedNodes()[0].name;
	$.ajax({
		type : "POST",
		url : basePath + "majorFrame/selectAppointPerson.htmls",
		success : function(data) {
			$("#superiorBranchName").val(branchName);
			$.each(eval(data), function(index, list) {
				$("#superiorList").append("<li><label><input name=\"superiorCheckBox\" id=\""
				+ list.employeeCode + "\" type=\"checkbox\">"+ list.name + "</label></li>");
			});
			$.ajax({
				type : "POST",
				url : basePath + "majorFrame/selectAppointPersonById.htmls",
				data : {
					"id" : branchId
				},
				success : function(data) {
					$.each(eval(data), function(index, list) {
						$("#" + list.employeeCode).attr("checked", true);
					});
				}
			});
		}
	});
	hideRMenu();
	$(".addSuperior").show();
}
var superiorArray;
$(".addSuperiorOk").click(function() {
	superiorArray = new Array();
	var branchId = zTree.getSelectedNodes()[0].id;
	$("input:checkbox[name='superiorCheckBox']:checked").each(function(index, element) {
		var superior = element.id;
		superiorArray.push(superior);
	});
	/*if (superiorArray.length <= 0) {
		tmLoading("请选择负责人", 2);
		return;
	}*/
	$.ajax({
		type : "POST",
		url : basePath + "majorFrame/addSuperior.htmls",
		data : {
			"superiorArray" : superiorArray,
			"id" : branchId
		},
		success : function(data) {
			if (data < 0) {
				tmLoading("指定负责人失败", 2);
				return;
			}
			tmLoading("指定负责人成功", 2);
			$(".addSuperior").hide();
		}
	});
});

$(function() {
	setCookie("menu", "majorFrame");
});
