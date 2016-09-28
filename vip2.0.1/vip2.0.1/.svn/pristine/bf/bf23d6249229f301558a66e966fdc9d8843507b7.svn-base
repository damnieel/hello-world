<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Strict//EN">
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
     <input style="display:none" id="opProId"/>
     <input style="display:none" id="studentId"/>
     <input style="display:none" id="techerCode"/>
     <input style="display:none" id="interviewerCode"/>
     <div class="main_con">
         <div class="marb_14">
             <div class="table_record">
             <table width="100%">
             <tr>
             <td width="140" align="right"><b>QQ：</b></td>
             <td><input id="qq" type="text" class="edit_box boxborqq"></td>
             <td width="140" align="right"><b>学员姓名：</b></td>
             <td><input id="studentName" type="text" class="edit_box boxbor" disabled ></td>
             </tr>
             <tr>
             <td width="140" align="right"><b>学员职业：</b></td>
             <td><input id="occupationName" type="text" class="edit_box boxbor" disabled ></td>
             <td width="140" align="right"><b>访谈人：</b></td>
             <td><input id="interviewerName" type="text" class="edit_box boxbor" disabled ></td>
             </tr>
             <tr>
             <td width="140" align="right"><b>专业名称：</b></td>
             <td>
             <select id="professionName" class="select_box boxbor" >
             <option>请选择</option>
             </select>
             </td>           
             <td width="140" align="right"><b>学员编号：</b></td>
             <td><input id="codeNo" type="text" class="edit_box boxbor" disabled></td>
             </tr>
             <tr>
             <td width="140" align="right"><b>讲师：</b></td>
             <td>
             <select id="teacher" class="select_box boxbor">
             <option>请选择</option>
             </select>
             </td>
             <td width="140" align="right"><b>访谈时间：</b></td>
             <td><input type="text" placeholder="请点击选择"  class="edit_box boxbortime" id="interviewTime" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"/></td>
             <td colspan="2">&nbsp;</td>
             </tr>
             <tr>
             <td width="140" align="right" valign="top"><b>学习目的：</b></td>
             <td colspan="3" id="chooseGoal">
             <label class="padr_20"><input type="radio" value="1" name="goal">为了挣钱，找个好工作</label>
             <label class="padr_20"><input type="radio" value="2" name="goal">工作需要</label>
             <label class="padr_20"><input type="radio" value="3" name="goal">创业</label>
             <label class="padr_20"><input type="radio" value="4" name="goal">对课程感兴趣</label>
             <label class="padr_20"><input type="radio" value="5" name="goal">其他</label>
             <div class="other_resion none"><textarea  id="learnAimContent" class="textarea_box boxbor" placeholder="1～100字"></textarea></div></td>
             </tr>
             <tr>
             <td width="140" align="right" valign="top"><b>学习建议：</b></td>
             <td colspan="3"><textarea id="suggest" class="textarea_box boxbor" placeholder="1～100字" style="margin-top:0px;"></textarea></td>
             </tr>
             <tr>
             <td width="140" align="right" valign="top"><b>学习困惑：</b></td>
             <td colspan="3"><textarea id="puzzle" class="textarea_box boxbor" placeholder="1～100字" style="margin-top:0px;"></textarea></td>
             </tr>
             <tr>
             <td width="140" align="right" valign="top"><b>备注：</b></td>
             <td colspan="3"><textarea id="note" class="textarea_box boxbor" placeholder="0～100字" style="margin-top:0px;"></textarea></td>
             </tr>
             </table>
             </div>
             <div class="mart_14">
                  <a href="javascript:void(0);" class="add_btn bg_gray" onclick="self.location=document.referrer;">返回</a>
                  <a href="javascript:void(0);" id="addInfo" class="add_btn bg_blue marl_20">保存</a>
             </div>
         </div>
     </div>
</div>
</body>
<script type="text/javascript" src="${basePath}resources/js/interviews/interviewAdd.js"></script>
<script type="text/javascript" src="${basePath}resources/js/My97DatePicker/WdatePicker.js"></script>
</html>