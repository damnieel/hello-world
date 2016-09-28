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
<script type="text/javascript" src="${basePath}resources/js/jquery.form.js"></script>
<script type="text/javascript" src="${basePath}resources/js/student/personInfo.js"></script>
  <title>学员管理_学员档案</title>
</head>

<body>
<%@include file="/WEB-INF/views/page/sys/left.jsp" %>
<div class="main_right">
     <%@include file="/WEB-INF/views/page/sys/top.jsp" %>
      <div class="person_page">
          <ul>
              <li id="firstPage">第一页</li>
              <li id="secondPage">第二页</li>
              <li id="thirdPage">第三页</li>
              <li class="onpage" id="fourthPage">第四页</li>
              <li id="fifthPage">第五页</li>
          </ul>
	</div>
     <input style="display:none" id="studentId" value ="${studentId}"/>
     <input style="display:none" id="stuId" value ="${stuId}"/>
     <input style="display:none" id="opProId" value ="${opProId}"/>
	 <input style="display:none" id="type" value ="contract"/>
     <div class="main_con marb_90">
          <div class="marb_14 clearfix">
              <a href="${basePath}studentFile/showPage.htmls" class="add_btn bg_blue">返回</a>
              <vip:security operType="update" organizationId="${opProId}">
              <a href="javascript:void(0);" class="add_btn bg_blue marl_20 editBtn">编辑</a>
              </vip:security>
         </div>
         <div class="personal_info clearfix">
              <div class="person_title font24">合同信息</div>
              
              <form id="attachForm"  enctype="multipart/form-data">
              <table width="100%" class="student_archives">
                 <tr>
                 <td>
                     <div class="show_file">
                          <div class="clearfix IdentifyEdit"><p class="fl">添加附件：</p><p class="fl"><input type="file" id="file" name="file" class="search_box boxbor"></p></div>
                          <c:if test="${empty(requestScope.attachList)}">
                          <p>暂无上传附件</p>
                          </c:if>
                          <c:forEach items="${attachList}" var="item" varStatus="status">
                          <div class="clearfix"><p class="fl">附件：</p><p class="fl"><a href="${imgBasePath}${item.urlAddress}">${item.name}</a></p><p class="fl"><a href="javascript:void(0);" class="color_red deleteAttach"  data-attachid="${item.id}">删除</a></p><p class="fl">上传时间：<fmt:formatDate value="${item.createTime}" type="both" pattern="yyyy-MM-dd HH:mm"/></p></div>
                          </c:forEach>
                     </div>
                 </td>
                 </tr>
              </table>
            
              <div class="mart_14 editSave"><input type="submit" class="add_btn bg_blue marl_510" value="保存"/></div>
              </form>
         </div>
     </div>
</div>

</body>
</html>
