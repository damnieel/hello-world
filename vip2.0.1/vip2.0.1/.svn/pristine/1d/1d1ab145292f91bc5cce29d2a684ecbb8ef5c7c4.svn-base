var oldStudentList = new Array(); //班级中的学生列表
var editRow = new Array();
var viewStudentList = ""; //临时存储当前查看行的学生列表

var hwsearchopts = {
		"startNumber" : 0,
		"pageSize": 10,
		"countUrl" : basePath + "educational/homework/getCountHomework.htmls",
		"dataUrl" : basePath + "educational/homework/listHomework.htmls?operate="+operate,
		"orgProCalId": Number(opClaId),
		 callback : function (){
				diableEditRow(editRow[5]);
			}
};

$(function(){
	$("#curMenuLableName").after("&gt; <a href='javascript:void(0);'>学员作业考查</a>");
	pageQuery(hwsearchopts);
	var dateStr = new Date().Format('yyyy-MM-dd');
	$("#checkDate").val(dateStr);
	cpStuList(studentList,oldStudentList); // 临时存储编辑用的学生列表
	if('edit' == operate){
		$("#studentDesc").click(function(){
			var students = studentList;
			drawStudentListDiv(students);
		});
	}
	
	$("#checkStu").prop("checked",false);
	
	//点击作业考查弹出 js
	$(".classStu").click(function(){
		$(".classStuList").fadeIn(200);
		$(".classStuList").click(function(){
			var totalnum =0;
			var submitnum = 0;
			$("ul input[type=checkbox]").each(function() {
				totalnum ++;
				var stuId = $(this).val();
				if ($(this).prop("checked")) {
					submitnum ++;
				} 
			});
			if(totalnum > submitnum){
				$("#checkStu").prop("checked",false);
			}else{
				$("#checkStu").prop("checked",true);
			}
		})
	});
	
	$(".Quit").click(function(){
		hideStudentList();
	});
});

function hideStudentList(){
	$(".pop_div").hide();
}

/**
 * 绘制班级提交作业的学生列表
 * @param stuList
 */
function drawStudentListDiv(stuList){
	var unchecked = 0;
	var htmls = "<ul>";
	for(var i=0; i < stuList.length; i++){
		htmls = htmls + "<li><label><input type=\"checkbox\"";
		if(stuList[i].checkStatus==1){
			htmls = htmls + "checked='checked'";
		}else{
			unchecked ++;
		}
		htmls = htmls + " value="+stuList[i].studentId+">" + stuList[i].professionCode + "-" + stuList[i].studentName +"</label></li>";
	}
	htmls = htmls + "</ul>";
	$("#stuCheckList").html(htmls);
	if(unchecked > 0) {
		$("#checkStu").prop("checked",false);
	} else {
		$("#checkStu").prop("checked",true);
	}
	$("#saveStu").attr("href","javascript:saveStuList();");
	$("#cancelStu").show();
	$("#checkStuDiv").show();
};


function drawViewStudentListDiv(stuList){
	var unchecked = 0;
	var htmls = "<ul>";
	for(var i=0; i < stuList.length; i++){
		htmls = htmls + "<li><label><input type=\"checkbox\"";
		if(stuList[i].checkStatus==1){
			htmls = htmls + "checked='checked'";
		}else{
			unchecked ++;
		}
		htmls = htmls + " value="+stuList[i].studentId+" disabled>" + stuList[i].professionCode + "-" + stuList[i].studentName +"</label></li>";
	}
	htmls = htmls + "</ul>";
	$("#stuCheckList").html(htmls);
	if(unchecked > 0) {
		$("#checkStu").prop("checked",false);
	} else {
		$("#checkStu").prop("checked",true);
	}
	$("#saveStu").attr("href","javascript:hideStudentList();");
	$("#cancelStu").hide();
	$("#checkStuDiv").hide();
}

/**
 * 全选，全部取消
 */
function checkStudent(){
	var check = $("#checkStu").prop("checked");
	if(check) {
		$("ul input[type=checkbox]").prop("checked", true);
	} else {
		$("ul input[type=checkbox]").prop("checked", false);
	}
};

/**
 * 临时保存学生提交作业情况
 */
function saveStuList() {
	var totalnum = 0;
	var submitnum = 0;
	$("ul input[type=checkbox]").each(function() {
		totalnum ++;
		var stuId = $(this).val();
		if ($(this).prop("checked")) {
			setCheckStatus(studentList, stuId , 1);
			submitnum = submitnum +1;
		} else {
			setCheckStatus(studentList, stuId , 0);
		}
	});
	var htmls = "已交作业人数：<span class=\"color_red padr_20\">"+submitnum+"</span> 未交作业人数：<span class=\"color_red\">"+(totalnum-submitnum)+"</span>";
	$("#studentDesc").html(htmls);
	$(".classStuList").hide();
};

/**
 * 设置摸个学生为选中状态
 * 
 * @param stuList
 * @param stuId
 */
function setCheckStatus(stuList, stuId , status) {
	for (var i = 0; i < stuList.length; i++) {
		if (stuList[i].studentId == stuId) {
			stuList[i].checkStatus = status;
		}
	}
};

/**
 * 查看当前作业提交详细学生信息
 */
function viewHmworkRecord(trId) {
	getCurrentRowStudentList(trId,"view");
	drawViewStudentListDiv(viewStudentList);
	$(".classStuList").show();
};

/**
 * 将当前行的学生作业提交情况数据放入(查看或者编辑)临时列表
 */
function getCurrentRowStudentList(rowId,type){
	var stuList = new Array();
	var j = 0;
	for (var i = 0; i < stuHmworkVOList.length; i++) {
		if (rowId == stuHmworkVOList[i].sacId) {
			var stu = {
				"studentId" : stuHmworkVOList[i].studentId,
				"professionCode" : stuHmworkVOList[i].professionCode,
				"studentName" : stuHmworkVOList[i].studentName,
				"sacId" : stuHmworkVOList[i].sacId,
				"checkStatus" : stuHmworkVOList[i].checkStatus
			};
			stuList[j] = stu;
			j ++;
		}
	}
	if(type == "view"){
		viewStudentList = stuList;
	} else {
		studentList = stuList;
	}
	
	
};

/**
 * 编辑，将数据移到编辑区域
 */
function editHmworkRecord(trId) {
	if(editRow.length > 0){
		recoverEditStatus(editRow[5]);
	}
	// 取得当前行的学生列表
	getCurrentRowStudentList(trId,"edit");
	// 取得当前行的基本数据
	$("#"+trId).find("td").each(function(index, e) {
	  editRow[index] = $(this).text();
	});
	editRow[5] = trId;
	$("#checkDate").val(editRow[1]);
	$("#studentDesc").text(editRow[2]);
	$("#note").val(editRow[3]);
	// 禁用编辑行
	diableEditRow(trId);
	drawStudentListDiv(studentList);
};



/**
 * 删除一行记录
 */
function removeHmworkRecord(sacId,checkdate) {
	tm_dialoag.confirm({
		sureText : "确定",
		canceText : "取消",
		content : "你确定删除“"+checkdate+"”作业记录吗?",
		callback : function(ok) {
			$.ajax({
				url : basePath + "educational/homework/removeHomeworkRecord.htmls",
				type:"POST",
				data : {
					"id" : sacId
				},
				success : function(data) {
					var res = eval("("+data+")");
					if(res.result){
						var itemCount = $("#itemCount").val();
						if(itemCount > 0);{
							itemCount --;
							$("#itemCount").val(itemCount);
						}
						
						hwsearchopts.startNumber = hwsearchopts.startNumber < itemCount ?  hwsearchopts.startNumber : 
									(hwsearchopts.startNumber - 10 > 0 ? hwsearchopts.startNumber - 10 : 0);
						 
						pageQuery(hwsearchopts);
						if(editRow.length > 0){
							diableEditRow(editRow[5]);
						}
					}else{
						tmLoading(res.msg,2);
					}
				},
				error : function() {
					tmLoading("加载失败，请稍后再试", 2);
				}
			});
		}
	});
};

/**
 * 撤销编辑内容
 */
function unSaveHmwork(){
	// 清空编辑输入
	var dateStr = new Date().Format('yyyy-MM-dd');
	$("#checkDate").val(dateStr);
	$("#studentDesc").text("");
	$("#note").val("");
	$("#checkStu").prop("checked",false);
	// 恢复学生列表为当前班级学生列表
	studentList = new Array();
	cpStuList(oldStudentList,studentList);
	
	// 恢复编辑选中行
	recoverEditStatus(editRow[5]);
	
	drawStudentListDiv(studentList);
	editRow = new Array();
};

function diableEditRow(trId){
	// 禁用编辑行
	$("#"+trId).attr("class", "bgdisable");
	$("#"+trId).find("a").each(function(index, e){
		$(this).removeAttr("href");
	});
}

function recoverEditStatus(trId){
	// 恢复编辑选中行a编辑的js响应事件
	$("#"+trId).find("a").each(function(index, e){
		if(index == 0) {
			$(this).attr("href","javascript:viewHmworkRecord("+trId+");");
		} else if (index == 1){
			$(this).attr("href","javascript:editHmworkRecord("+trId+");");
		} else if (index == 2){
			$(this).attr("href","javascript:removeHmworkRecord("+trId+");");
		}
	});
	// 恢复编辑选中行样式
	$("#"+trId).removeAttr("class");
}


function deal_error(parameter){
	// 选中错误的输入框中的内容
	$(parameter).select();
	// 将鼠标定位到错误内容的输入框中
	$(parameter).focus();
}

/**
 * 保存编辑内容
 */
function saveHmwork() {
	
	var checkDate = $("#checkDate").val();
	checkDate = checkDate.replace(/^(\s|\xA0)+|(\s|\xA0)+$/g, ''); 
	var stuIds = new Array();
	var chkStatus = new Array();
	for(var i = 0; i < studentList.length; i++){
		stuIds[i] = studentList[i].studentId;
		chkStatus[i] = studentList[i].checkStatus;
	};
	var note = $("#note").val();
	if(note.length > 20){
		deal_error("#note");
		tmLoading("备注字段限制在0-20个字符", 2);
		return;
	}
	
	tm_dialoag.confirm({
		sureText : "确定",
		canceText : "取消",
		content : "您确定保存作业记录吗?",
		callback : function(ok) {
			if (ok) {
				
				$.ajax({
					url : basePath + "educational/homework/updateHomeworkRecord.htmls",
					type:"POST",
					data : {
						"checkDate" : checkDate,
						"stuIds" : stuIds,
						"chkStatus": chkStatus,
						"note" : note,
						"classId" : hwsearchopts.orgProCalId,
						"professionId" : opProId,
						"id" : editRow[5]
					},
					success : function(data) {
						var res = eval("("+data+")");
						if(res.result){
							pageQuery(hwsearchopts);
							unSaveHmwork();
						}else{
							tmLoading(res.msg,2);
						}
					},
					error : function() {
						tmLoading("加载失败，请稍后再试", 2);
					}
				});  
			}
		}
	});
	
};

/**
 * 复制list[{
			"studentId" : studentId,
			"professionCode" : professionCode,
			"studentName" : studentName,
			"sacId" : sacId,
			"checkStatus" : checkStatus
			};]
 * 将sArry的内容复制到tArray
 * @param sArry
 * @param tArry
 */
function cpStuList(sArry,tArry){
	for(var i = 0; i < sArry.length; i ++){
		var stu = {
				"studentId" : sArry[i].studentId,
				"professionCode" : sArry[i].professionCode,
				"studentName" : sArry[i].studentName,
				"sacId" : sArry[i].sacId,
				"checkStatus" : sArry[i].checkStatus
			};
		tArry[i] =  stu; 
	}
}

/**
 * 返回班级列表页面
 */
function backToClass(){
	var checkDate = $("#checkDate").val();
	var note = $("#note").val();
	var studDesc = $("#studentDesc").text();
	var dateStr = new Date().Format('yyyy-MM-dd');
	if(( checkDate!= undefined && checkDate != dateStr) 
			|| (studDesc != undefined && !isEmpty(studDesc)) 
			|| (note != undefined && !isEmpty(note))){
		tm_dialoag.confirm({
			sureText : "确定",
			canceText : "取消",
			content : "您录入的作业考查记录未保存，确定返回吗?",
			callback : function(ok) {
				
				exeJump();
			}
		});
	}else{
		exeJump();
	}
	
}

// 执行返回跳转
function exeJump(){
	var url = basePath + "educational/homework/showClasses.htmls";
	var params = searchParam;
    post(url,params);
}
