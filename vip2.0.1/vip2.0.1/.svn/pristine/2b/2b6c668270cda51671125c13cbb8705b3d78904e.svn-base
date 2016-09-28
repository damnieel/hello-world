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
<body>
<%@include file="/WEB-INF/views/page/sys/left.jsp" %>

<div class="main_right">
     <%@include file="/WEB-INF/views/page/sys/top.jsp" %>
     <div class="person_page">
          <ul>
              <li id="firstPage">第一页</li>
              <li id="secondPage">第二页</li>
              <li class="onpage" id="thirdPage">第三页</li>
              <li id="fourthPage">第四页</li>
              <li id="fifthPage">第五页</li>
          </ul>
	</div>
     <input style="display:none" id="studentId" value ="${studentId}"/>
	 <input style="display:none" id="stuId" value ="${stuId}"/>
	 <input style="display:none" id="opProId" value ="${opProId}"/>
     <div class="main_con marb_90">
          <div class="marb_14 clearfix">
              <a href="${basePath}studentFile/showPage.htmls" class="add_btn bg_blue">返回</a>
              <a href="javascript:void(0);" class="add_btn bg_blue marl_20" id="preview">预览</a>
              <a href="javascript:void(0);" class="add_btn bg_blue marl_20" id="print">直接打印</a>
         </div>
         <!--startprint-->
         <div class="personal_info clearfix">
              <div class="person_title font24">身份证信息</div>
              <table width="100%" class="student_archives" style="margin:0 auto;">
                 <tr>
                 <td>
                     <div class="clearfix">
                     <c:choose> 
		  				<c:when test="${empty(requestScope.idCard.cardFrontAddress)}">   
		  				<div class="upload_img" style="padding-left:0;">
                               <div class="upload_area">
                                   <a class="upload_pic"><img src="${basePath}resources/images/nocard.png" title="身份证正面" /></a>
                                   <p>身份证正面</p>
                               </div>
                          </div>
		 			 	</c:when> 
					    <c:otherwise>   
			   			 <div class="upload_img" style="padding-left:0;">
                               <div class="upload_area">
                                   <a class="upload_pic"><img src="${imgBasePath}${idCard.cardFrontAddress}" title="身份证正面" /></a>
                                   <p>身份证正面</p>
                               </div>
                          </div>
			  			</c:otherwise> 
					 </c:choose> 
					 
					 <c:choose> 
		  				<c:when test="${empty(requestScope.idCard.cardReverseAddress)}">   
                          <div class="upload_img" style="padding-left:0;">
                               <div class="upload_area">
                                   <a class="upload_pic"><img src="${basePath}resources/images/nocard.png" title="身份证反面" /></a>
                                   <p>身份证反面</p>
                               </div>
                          </div>
		 			 	</c:when> 
					    <c:otherwise>   
                          <div class="upload_img" style="padding-left:0;">
                               <div class="upload_area">
                                   <a class="upload_pic"><img src="${imgBasePath}${idCard.cardReverseAddress}" title="身份证反面" /></a>
                                   <p>身份证反面</p>
                               </div>
                          </div>
			  			</c:otherwise> 
					 </c:choose> 
                     </div>
                 </td>
                 </tr>
              </table>
         </div>
         <!--endprint-->
     </div>
</div>

</body>
</html>
