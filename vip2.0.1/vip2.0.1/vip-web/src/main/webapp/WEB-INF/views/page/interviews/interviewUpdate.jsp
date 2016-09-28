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

  <title>教务管理_访谈记录_添加访谈记录</title>
</head>

<body>
<%@include file="/WEB-INF/views/page/sys/left.jsp" %> 
<div class="main_right">
     <%@include file="/WEB-INF/views/page/sys/top.jsp" %>
     <input style="display:none" id="interviewId" value ="${interview.id}"/>
     <div class="main_con">
         <div class="marb_14">
             <div class="table_record">
             <table width="100%">
             <tr>
             <td width="140" align="right"><b>QQ：</b></td>
             <td><input type="text" id="qq" class="edit_box boxbor" disabled value="${interview.qq}"></td>
             <td width="140" align="right"><b>学员姓名：</b></td>
             <td><input type="text" id="studentName" class="edit_box boxbor" disabled value="${interview.studentName}"></td>
             </tr>
             <tr>
             <td width="140" align="right"><b>学员职业：</b></td>
             <td><input type="text" id="occupationName" class="edit_box boxbor" disabled value="${interview.occupationName}"></td>
             <td width="140" align="right"><b>访谈人：</b></td>
             <td><input type="text" id="interviewerName" class="edit_box boxbor" disabled value="${interview.interviewerName}"></td>
             </tr>
             <tr>
             <td width="140" align="right"><b>专业名称：</b></td>
             <td><input type="text" id="professionName" class="edit_box boxbor" disabled value="${interview.professionName}"></td>
             <td width="140" align="right"><b>学员编号：</b></td>
             <td><input type="text" id="codeNo" class="edit_box boxbor" disabled value="${interview.codeNo}"></td>
             </tr>
             <tr>
             <td width="140" align="right"><b>讲师：</b></td>
             <td><input type="text" id="teacherName" class="edit_box boxbor" disabled value="${interview.teacherName}"></td>
             <td width="140" align="right"><b>访谈时间：</b></td>
             <td><input type="text" id="interviewTime" class="edit_box boxbor" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="<fmt:formatDate value="${interview.interviewTime}" type="both" pattern="yyyy-MM-dd"/>"></td>
             <td colspan="2">&nbsp;</td>
             </tr>
             <tr>
             <td width="140" align="right" valign="top"><b>学习目的：</b></td>
             <td colspan="3" id="chooseGoal">
             <label class="padr_20"><input type="radio" id="learnAimNumber" name="goal" value="1" data-number="${interview.learnAimCode}">为了挣钱，找个好工作</label>
             <label class="padr_20"><input type="radio" id="workNeed" name="goal" value="2" >工作需要</label>
             <label class="padr_20"><input type="radio" id="carveOut" name="goal" value="3" >创业</label>
             <label class="padr_20"><input type="radio" id="interesting"name="goal" value="4" >对课程感兴趣</label>
             <label class="padr_20"><input type="radio" id="otherWork" name="goal" value="5" >其他</label>
             <div class="other_resion none"><textarea  id="learnAimContent" class="textarea_box boxbor" placeholder="1～100字">${interview.learnAimContent}</textarea></div></td>
             </tr>
             <tr>
             <td width="140" align="right" valign="top"><b>学习建议：</b></td>
             <td colspan="3"><textarea  id="suggest" class="textarea_box boxbor" placeholder="1～100字" style="margin-top:0px;">${interview.suggest}</textarea></td>
             </tr>
             <tr>
             <td width="140" align="right" valign="top"><b>学习困惑：</b></td>
             <td colspan="3"><textarea  id="puzzle" class="textarea_box boxbor" placeholder="1～100字" style="margin-top:0px;">${interview.puzzle}</textarea></td>
             </tr>
             <tr>
             <td width="140" align="right" valign="top"><b>备注：</b></td>
             <td colspan="3"><textarea id="note" class="textarea_box boxbor" placeholder="1～100字" style="margin-top:0px;">${interview.note}</textarea></td>
             </tr>
             </table>
             </div>
             <div class="mart_14">
                  <a href="javascript:void(0);" class="add_btn bg_gray" onclick="self.location=document.referrer;">返回</a>
                  <a href="javascript:void(0);" class="add_btn bg_blue marl_20" id="saveInfo">保存</a>
             </div>
         </div>
     </div>
</div>
</body>
<script type="text/javascript" src="${basePath}resources/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${basePath}resources/js/interviews/interviewUpdate.js"></script>
</html>