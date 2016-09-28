<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="Generator" content="EditPlus®">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
  <meta http-equiv="X-UA-Compatible" content="chrome=1;IE=Edge;">
  <%@include file="/WEB-INF/common/commonResource.jsp" %>
<script type="text/javascript" src="${basePath}resources/js/main.js"></script>
  <title>教务管理_访谈记录_查看访谈记录</title>
</head>

<body>
<%@include file="/WEB-INF/views/page/sys/left.jsp" %> 
<div class="main_right">
     <%@include file="/WEB-INF/views/page/sys/top.jsp" %>
     <div class="main_con">
         <div class="marb_14">
             <div class="table_record">
             <table width="100%">
             <tr>
             <td width="140" align="right"><b>QQ：</b></td>
             <td>${interviews.qq}</td>
             <td width="140" align="right"><b>学员姓名：</b></td>
             <td>${interviews.studentName}</td>
             </tr>
             <tr>
             <td width="140" align="right"><b>学员职业：</b></td>
             <td>${interviews.occupationName}</td>
             <td width="140" align="right"><b>访谈人：</b></td>
             <td>${interviews.interviewerName}</td>
             </tr>
             <tr>
             <td width="140" align="right"><b>专业名称：</b></td>
             <td>${interviews.professionName}</td>
             <td width="140" align="right"><b>学员编号：</b></td>
             <td>${interviews.codeNo}</td>
             </tr>
             <tr>
             <td width="140" align="right"><b>讲师：</b></td>
             <td>${interviews.teacherName}</td>
             <td width="140" align="right"><b>访谈时间：</b></td>
             <td><fmt:formatDate value="${interviews.interviewTime}" type="both" pattern="yyyy-MM-dd"/></td>
             <td colspan="2">&nbsp;</td>
             </tr>
             <tr>
             <td width="140" align="right" valign="top"><b>学习目的：</b></td>
             <td colspan="3">${interviews.learnAimContent}</td>
             </tr>
             <tr>
             <td width="140" align="right" valign="top"><b>学习建议：</b></td>
             <td colspan="3">${interviews.suggest}</td>
             </tr>
             <tr>
             <td width="140" align="right" valign="top"><b>学习困惑：</b></td>
             <td colspan="3">${interviews.puzzle}</td>
             </tr>
             <tr>
             <td width="140" align="right" valign="top"><b>备注：</b></td>
             <td colspan="3">${interviews.note}</td>
             </tr>
             </table>
             </div>
             <div class="mart_14">
                  <a href="javascript:void(0);" class="add_btn bg_gray" onclick="self.location=document.referrer;">返回</a>
             </div>
         </div>
     </div>
</div>
</body>
</html>