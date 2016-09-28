<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="Generator" content="EditPlus">
<meta name="Author" content="">
<meta name="Keywords" content="">	
<meta name="Description" content="">
<meta http-equiv="X-UA-Compatible" content="chrome=1;IE=Edge;">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/common/commonResource.jsp" %>
<title>问卷调查-查看详情页面</title>
</head>
<body>
	<%@include file="/WEB-INF/views/page/sys/left.jsp" %>	
	<div class="main_right">	
		<%@include file="/WEB-INF/views/page/sys/top.jsp" %> 
     <div class="main_con">
         <div class="marb_14">
             <div class="table_record">
             <table width="100%">
             <tr style="margin-left: 30px;">
             <td width="140" align="right"><b>集群：</b></td>
             <td>${questionnaire.courseName}</td>
             <td width="140" align="right"><b>部门：</b></td>
             <td>${questionnaire.keyword}</td>
             </tr>
             <tr>
             <td width="140" align="right"><b>专业：</b></td> 
             <td>${questionnaire.employeeCode}</td>
             <td width="140" align="right"><b>讲师昵称：</b></td>
             <td>${questionnaire.nickName}</td>
             </tr>
             <tr>
	             <td width="140" align="right"><b>调查学员数：</b></td>
	             <td>${questionnaire.investigationsNumber}</td>
	             <td width="140" align="right"><b>调查日期：</b></td>
	             <td width="196">
		             <div class="data_box" style="width:196px;">
		                <fmt:formatDate value='${questionnaire.investigationsDate}' type="date" />
		              </div>
		         </td>
             </tr>
             <tr>
             <td width="140" align="right"><b>评优比例：</b></td>
             <td>${questionnaire.excellent}%</td>
             <td width="140" align="right"><b>评良比例：</b></td>
             <td>${questionnaire.good}%</td>
             </tr>
             <tr>
             <td width="140" align="right"><b>评中比例：</b></td>
             <td>${questionnaire.medium}%</td>
             <td width="140" align="right"><b>评差比例：</b></td>
             <td>${questionnaire.bad}%</td>
             </tr>
             <tr>
             <td width="140" align="right" valign="top"><b>学员问题：</b></td>
             <td colspan="3">
	             <textarea class="textarea_box boxbor" disabled placeholder="1～100字" id = "question" style="margin-top:0px;">
	             ${questionnaire.question}
	             </textarea>
             </td>
             </tr>
             <tr>
             <td width="140" align="right" valign="top"><b>解决措施：</b></td>
             <td colspan="3">
                 <textarea class="textarea_box boxbor" disabled placeholder="1～100字" style="margin-top:0px;">
                  ${questionnaire.solution}
                 </textarea>
             </td>
             </tr>
             <tr>
             <td width="140" align="right" valign="top"><b>附件：</b></td>
             <td colspan="3"><span class="color_red"><a href="${imgBasePath}${questionnaire.annexAddress}">${questionnaire.annexName}</a></span></td>
             </tr>
             </table>
             </div>
             <div class="mart_14">
                  <a href="javascript:void(0);" onClick="javascript :history.back(-1);" class="add_btn bg_gray">返回</a>
             </div>
         </div>
     </div>
</div>
<script type="text/javascript" src="${basePath}resources/js/questionnaire/questionnaireAdd.js"></script>
<script type="text/javascript">
function tzchangeyear(dp){
    $("#keybirthday").val(dp.cal.getNewDateStr());
}
$("#curMenuLableName").after("&gt; <a href='javascript:void(0);'>问卷详情</a>");
</script>
<script language="JavaScript" >  
function excellent(obj){ // 值允许输入一个小数点和数字 
	obj.value = obj.value.replace(/[^\d.]/g,""); //先把非数字的都替换掉，除了数字和. 
	obj.value = obj.value.replace(/^\./g,""); //必须保证第一个为数字而不是. 
	obj.value = obj.value.replace(/\.{2,}/g,"."); //保证只有出现一个.而没有多个. 
	obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$","."); //保证.只出现一次，而不能出现两次以上 

	}  
</script>  

</body>
</html>