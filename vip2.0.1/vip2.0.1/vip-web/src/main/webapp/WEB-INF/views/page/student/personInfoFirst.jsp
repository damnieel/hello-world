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
<script type="text/javascript" src="${basePath}resources/js/student/personInfo.js"></script>
  <title>学员管理_学员档案</title>
</head>

<body id="personalInfo">
<%@include file="/WEB-INF/views/page/sys/left.jsp" %>
<div class="main_right">
    <%@include file="/WEB-INF/views/page/sys/top.jsp" %> 
     <div class="person_page">
          <ul>
              <li  class="onpage" id="firstPage">第一页</li>
              <li id="secondPage">第二页</li>
              <li id="thirdPage">第三页</li>
              <li id="fourthPage">第四页</li>
              <li id="fifthPage">第五页</li>
          </ul>
	</div>
     <input style="display:none" id="studentId" value ="${studentId}"/>
     <input style="display:none" id="stuId" value ="${studentFile.stuId}"/>
     <input style="display:none" id="opProId" value ="${studentFile.opProId}"/>
     <!--第一页-->
    
     <div class="main_con marb_90">
          <div class="marb_14 clearfix">
              <a href="${basePath}studentFile/showPage.htmls" class="add_btn bg_blue">返回</a>
             <vip:security operType="update" organizationId="${studentFile.opProId}">
              <a href="javascript:void(0);" class="add_btn bg_blue marl_20 editBtn">编辑</a>
             </vip:security>
              <a href="javascript:void(0);" class="add_btn bg_blue marl_20" id="preview">预览</a>
              <a href="javascript:void(0);" class="add_btn bg_blue marl_20" id="print">打印或导出PDF</a>
         </div>
         <!--startprint-->
         <div class="personal_info clearfix" id="pvContent">
              <div class="person_title font24">个人信息</div>
              <div class="person_time"><span class="padr_20">入学日期：<fmt:formatDate value="${studentFile.createTime}" type="both" pattern="yyyy-MM-dd"/></span>学员编号：${studentFile.professionCode}</div>
              <table width="96%" class="student_archives" style="margin:0 auto;">
                 <tr>
                 <td width="15%">姓名</td>
                 <td><span>${studentFile.studentName}</span><input type="text" class="edit_box boxbor editState" value="${studentFile.studentName}" disabled /></td>
                 <td width="15%">姓名拼音</td>
                 <td><span>${studentFile.studentNameSpell}</span><input type="text" class="edit_box boxbor editState" value="${studentFile.studentNameSpell}" disabled /></td>
                 <td rowspan="5" width="190" style="padding-left:0px; padding-right:0px; background:#ececec;">
                   <div class="upload_head">
                     <c:choose> 
		  				<c:when test="${empty(requestScope.studentFile.stuPictureUrl)}">   
		   			 		<img src="${basePath}resources/images/nohead.jpg" title="学员头像" />
		 			 	</c:when> 
					    <c:otherwise>   
			   			 <img src="${imgBasePath}${studentFile.stuPictureUrl}" title="学员头像" />
			  			</c:otherwise> 
					 </c:choose> 
                   </div>
                 </td>
                 </tr>
                 <tr>
                 <td>性别</td>
                 <td><span>${studentFile.sex}</span><input type="text" class="edit_box boxbor editState" value="${studentFile.sex}" disabled /></td>
                 <td>出生日期</td>
                 <td><span>${studentFile.birthday}</span><input type="text" class="edit_box boxbor editState" value="${studentFile.birthday}" disabled /></td>
                 </tr>
                 <tr>
                 <td>身份证号</td>
                 <td colspan="3"><span>${studentFile.idCard}</span><input type="text" class="edit_box boxbor editState" value="${studentFile.idCard}" disabled /></td>
                 </tr>
                 <tr>
                 <td>学历</td>
                 <td><span>${studentFile.educationBackground}</span><input type="text" class="edit_box boxbor editState" value="${studentFile.educationBackground}" disabled /></td>
                 <td>专业</td>
                 <td><span>${studentFile.professionName}</span><input type="text" class="edit_box boxbor editState" value="${studentFile.professionName}" disabled /></td>
                 </tr>
                 <tr>
                 <td>籍贯</td>
                 <td><span>${studentFile.nativePlace}</span><input type="text" class="edit_box boxbor editState" value="${studentFile.nativePlace}" disabled /></td>
                 <td>邮编</td>
                 <td><span>${studentFile.postalCode}</span><input type="text" class="edit_box boxbor editState" value="${studentFile.postalCode}" disabled /></td>
                 </tr>
                 <tr>
                 <td>毕业学校</td>
                 <td colspan="4"><span>${studentFile.school}</span><input type="text" class="edit_box boxbor editState" value="${studentFile.school}" disabled /></td>
                 </tr>
                 <tr>
                 <td>家庭住址</td>
                 <td colspan="4"><span>${studentFile.address}</span><input type="text" class="edit_box boxbor editState" value="${studentFile.address}" disabled /></td>
                 </tr>
                 <tr>
                 <td>费用来源</td>
                 <td>
                 <label class="padr_20"><input type="radio" name="cost" disabled value="${studentFile.costResources }" ${studentFile.costResources =='home'?'checked':'' }>家庭</label>
                 <label class="padr_20"><input type="radio" name="cost" disabled value="${studentFile.costResources }" ${studentFile.costResources =='self'?'checked':'' }>自费</label>
                 </td>
                 <td>信息来源</td>
                  <td colspan="2" id="chooseSource">
	                 <label class="padr_20"><input type="radio" name="source" disabled value="${studentFile.studentResources }" ${studentFile.studentResources =='net'?'checked':'' }>网络</label>
	                 <label class="padr_20"><input type="radio" name="source" disabled value="${studentFile.studentResources }" ${studentFile.studentResources =='friend'?'checked':'' }>朋友介绍</label>
	                 <label class="padr_20"><input type="radio" name="source" disabled value="${studentFile.studentResources }" ${studentFile.studentResources =='other'?'checked':'' }>其他</label>
                 </td>
                 </tr>
                 <tr>
                 <td>本人电话</td>
                 <td><span>${studentFile.telephone}</span><input type="text" class="edit_box boxbor editState" value="${studentFile.telephone}" disabled /></td>
                 <td>QQ号码</td>
                 <td colspan="2"><span>${studentFile.qq}</span><input type="text" class="edit_box boxbor editState" value="${studentFile.qq}" disabled /></td>
                 </tr>
                 <tr>
                 <td>电子邮箱</td>
                 <td colspan="4"><span>${studentFile.email}</span><input type="text" class="edit_box boxbor editState" value="${studentFile.email}" disabled /></td>
                 </tr>
                 <tr>
                 <td>学习工作状态</td>
                 <td colspan="4">
                 <label class="padr_20"><input type="radio" name="state" disabled value="${studentFile.componentCode }" ${studentFile.componentCode =='s'?'checked':'' }>在读</label>
                 <label class="padr_20"><input type="radio" name="state" disabled value="${studentFile.componentCode }" ${studentFile.componentCode =='w'?'checked':'' }>在职</label>
                 <label class="padr_20"><input type="radio" name="state" disabled value="${studentFile.componentCode }" ${studentFile.componentCode =='u'?'checked':'' }>待业</label>
                 </td>
                 </tr>
                 <tr>
                 <td>兴趣爱好特长</td>
                 <td colspan="4" style="height:110px;"><span>${studentFile.hobbies}</span><textarea class="textarea_box boxbor editState" id="stuBasis" disabled>${studentFile.hobbies}</textarea></td>
                 </tr>
                 <tr>
                 <td>学习基础</td>
                 <td colspan="4" style="height:110px;"><span>${studentFile.studyBasis}</span><textarea class="textarea_box boxbor editState" placeholder="1～100字" id="stuBasis"></textarea></td>
                 </tr>
              </table>
              <div class="mart_14 editSave"><a href="javascript:void(0);" class="add_btn bg_blue marl_510" id="savaStudyBasis">保存</a></div>
         </div>
          <!--endprint-->
     </div>
</div>

</body>
</html>
