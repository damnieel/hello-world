<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include  file="/WEB-INF/common/taglib.jsp"%>
<%@page isELIgnored="false"%> 
	<table width="100%" class="specialty">
		<tbody>
			<tr>
				<th width="40" class="notread undiv"><input type="checkbox"></th>
				<th width="40" class="dived"></th>
				<th>序号</th>
				<th><span class="color_red">*</span>学员编号</th>
				<th>学员姓名</th>
				<th><span class="color_red">*</span>专业名称</th>
				<th class="dived"><span class="color_red">*</span>班级</th>
				<th><span class="color_red">*</span>专业价格</th>
				<th>实付金额</th>
				<th>尾款</th>
				<th>手机</th>
				<th>QQ</th>
				<th>报名日期</th>
				<th class="notread">退、休学日期</th>
				<th>是否欠款</th>
				<th class="dived undiv">是否退费</th>
				<th class="dived">学员班级状态</th>
				<th class="notread">学员专业状态</th>
				<th class="notread">退、休学原因</th>
				<th class="undiv">备注</th>
				<th class="dived">操作</th>
			</tr>
		</tbody>
		<c:if test="${fn:length(studentlist) == 0}">
			<tr id="tz_items_"><td colspan="16">暂无数据</td></tr>
		</c:if>
		<c:forEach items="${studentlist}" var="student" varStatus="status">
			<tr>
				<td><input type="checkbox" 
					data-id="${student.id}" data-name="${student.name}" 
					data-gradeorgid="${student.gradeOrgId}"
					data-profname="${student.professionName}" data-gradeid="${student.gradeId}"
					data-profid="${student.professionId}" data-proforgid="${student.professionOrgId}"
					data-status="${student.status}" ></td>
				<c:if test="${not empty student.onReadList}">
					<td width="62" class="dived"><div class="fl number">${status.count}</div>
					<a class="fr operate_btn showStuInfo" href="javascript:void(0);" data-id="${student.id}" data-profid="${student.professionId}"><i class="main_icon packup"></i></a></td>	
				</c:if>
				<c:if test="${empty student.onReadList}">
					<td class="dived"><div class="fl number">${status.count}</div>
					</td>
				</c:if>				
				<td class="notread undiv">${status.count}</td>
				<td>${student.codeNo}</td>
				<td>${student.name}</td>
				<td>${student.professionName}</td>
				
				<c:if test="${not empty student.onReadList}">
					<td class="dived">--</td>
				</c:if>
				<c:if test="${empty student.onReadList}">	
					<td class="dived">${student.gradeName}</td>
				</c:if>
				<td>${student.amountPayable}</td>
				<td>${student.payment}</td>
				<td>${student.arrears}</td>
				<td>${student.telephone}</td>
				<td>${student.QQ}</td>
				<td><fmt:formatDate value="${student.enterDate}"/></td>
				<td class="notread">
					<fmt:formatDate value="${student.changeTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>${student.isArrears}</td>
				<td class="dived undiv">${student.isRefund}</td>
				
				<c:if test="${not empty student.onReadList}">
					<td class="dived">--</td>
				</c:if>
				<c:if test="${empty student.onReadList}">
					<td class="dived">${student.gradeStatue}</td>
				</c:if>
				<td class="notread">${student.codeStatus}</td>
				<td class="notread">${student.changeReason}</td>
				<td class="undiv">${student.remark}</td>
				<td class="dived">
				<vip:security operType="update,insert" organizationId="${student.professionOrgId}">
				<a class="again_btn bg_blue divideClass reDivideGrade" href="javascript:void(0);">重新分班</a>
				</vip:security>
				</td>
			</tr>
			<c:if test="${not empty student.onReadList}">
				<c:forEach items="${student.onReadList}" var="onRead" varStatus="instatus">
				<tr data-id="${onRead.id}" data-profid="${student.professionId}"
						style="display:none">
					<td><input type="checkbox" 
						data-id="${onRead.id}" data-name="${onRead.name}" 
						data-profname="${onRead.professionName}" data-gradeid="${onRead.gradeId}" 
						data-gradeorgid="${onRead.gradeOrgId}"
						data-profid="${onRead.professionId}" data-profOrgid="${onRead.professionOrgId}"
						data-status="${onRead.status}"
						></td>
					<td style="font-size:12px">${status.count}.${instatus.count}</td>
					<td>${onRead.codeNo}</td>
					<td>${onRead.name}</td>
					<td>${onRead.professionName}</td>
					<td class="dived">${onRead.gradeName}</td>
					<td>${onRead.amountPayable}</td>
					<td>${onRead.payment}</td>
					<td>${onRead.arrears}</td>
					<td>${onRead.telephone}</td>
					<td>${onRead.QQ}</td>
					<td><fmt:formatDate value="${onRead.enterDate}"/></td>
					<td>${onRead.isArrears}</td>
					<td class="dived undiv">${onRead.isRefund}</td>
					<td class="dived">${onRead.gradeStatue}</td>
					<td class="dived">--
						<!-- <a class="again_btn bg_blue divideClass reDivideGrade" href="javascript:void(0);"></a> -->
						</td>
				</tr>	
				</c:forEach>
			</c:if>
		</c:forEach>	
	</table>
<script type="text/javascript">
	var firstCheckBox = "table tbody tr th input:first";
	$(firstCheckBox).on("click",function(){
	  if(!$(this).prop("checked")) {
		 $("table input").prop("checked", false);
	  } else {
	     $("table input").prop("checked", true);
	  }
	});
	$("table input:not(:first)").on("click",function() {
		var a = $("table input:not(:checked)");
		if(a.length != 0) {
			$(firstCheckBox).prop("checked", false);
		} else {
			$(firstCheckBox).prop("checked", true);
		}
	});
	var type = "${type}";
	if(type == "undiv") {
		$(".dived").hide();
		$(".notread").hide();
		$(".undiv").show();
	} else if(type == "dived"){
		$(".undiv").hide();
		$(".notread").hide();
		$(".dived").show();
		$(".showStuInfo").click(function(){	
		   var $tr = $(this).parent().parent();
		   var id = $(this).data("id");
		   var profId = $(this).data("profid");
		   while($tr.next("tr").length == 1) {
		    	var $next = $tr.next("tr");
			    if(id == $next.data("id") && profId == $next.data("profid")) {
				  $next.children().children("input").prop("checked", false);
			      $next.toggle();
			      if($next.is(":hidden")){
			    	  $(this).children("i").attr("class","main_icon packup");
			      } else {
			    	  $(this).children("i").attr("class","main_icon packdown");
			      }
			    }
			    $tr = $next;
		   }   
			   
		});
	} else if(type == "notread"){
		$(".undiv").hide();
		$(".dived").hide();
		$(".notread").show();
	}
</script>
