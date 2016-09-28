<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="UTF-8">
  <meta name="Generator" content="EditPlus®">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
  <meta http-equiv="X-UA-Compatible" content="chrome=1;IE=Edge;">
<title>学员管理_学员信息详情页</title>
<%@include file="/WEB-INF/common/commonResource.jsp" %>
</head>
<body>
<%@include file="/WEB-INF/views/page/sys/left.jsp" %>
<div class="main_right">
     <%@include file="/WEB-INF/views/page/sys/top.jsp" %>
     <div class="main_con">
         <div class="marb_14">
             <div class="stu_info">
                  <ul>
                      <li >学员信息</li><!-- class="oncurrent" -->
                      <!-- <li>专业信息</li> -->
                  </ul>
             </div>
             <div class="stuDetail">
                 <table width="100%" class="student">
                 <tr>
                 <td width="9%"><span class="color_red">*</span>学员姓名</td>
                 <td width="13%">${student.stuName}</td>
                 <td width="9%">姓名拼音</td>
                 <td width="13%">${student.nameSpell}</td>
                 <td width="9%">学历</td>
                 <td width="13%">${student.educationBackgroundValue}</td>
                 <td width="9%">出生日期</td>
                 <td><fmt:formatDate value="${student.birthday}" type="date" /></td>
                 <td rowspan="6" width="190" style="padding-left:0px; padding-right:0px; background:#ececec;">
                 <c:if test="${student.stuPictureUrl == null || empty student.stuPictureUrl }">
                      <!--上传前样式-->
                      <a href="javascript:void(0);" class="upload_head" ><span class="font24">暂无上传照片</span><i class="main_icon"></i></a>
                 </c:if>
                 <c:if test="${ !empty student.stuPictureUrl  }">
                  <!--上传后样式-->
                      <a href="javascript:void(0);" class="upload_head"><img src="${imgBasePath}/${student.stuPictureUrl}" title="学员头像" /></a> 
                 </c:if>
                 </td>
                 </tr>
                 <tr>
                 <td>职业</td>
                 <td>${student.occupationCodeValue}</td>
                 <td>性别</td>
                 <td>${student.sex}</td>
                 <td>籍贯</td>
                 <td>${student.nativePlace}</td>
                 <td><span class="color_red">*</span>QQ</td>
                 <td>${student.QQ}</td>
                 </tr>
                 <tr>
                 <td>YY</td>
                 <td>${student.YY}</td>
                 <td>身份证号</td>
                 <td>${student.idCard}</td>
                 <td><span class="color_red">*</span>手机号码</td>
                 <td>${student.telephone}</td>
                 <td>邮箱</td>
                 <td>${student.email}</td>
                 </tr>
                 <tr>
                 <td>邮编</td>
                 <td>${student.postalCode}</td>
                 <td>紧急联系人</td>
                 <td>${student.emergencyPerson}</td>
                 <td>与其关系</td>
                 <td>${student.contratRelationshipsCode}</td>
                 <td>紧急联系人电话</td>
                 <td>${student.emergencyTelephone}</td>
                 </tr>
                 <tr>
                 <td>毕业学校</td>
                 <td>${student.school}</td>
                 <td>费用来源</td>
                 <td>
	                 <c:choose>
	                      <c:when test="${student.costResources == 'home'}">
	                         <label class="padr_20"><input type="radio" name="cost" checked disabled>家庭</label>
	                         <label class="padr_20"><input type="radio" name="cost"  disabled>自费</label>
	                      </c:when>
	                      <c:when test="${student.costResources == 'self'}">
	                          <label class="padr_20"><input type="radio" name="cost"  disabled>家庭</label>
	                          <label class="padr_20"><input type="radio" name="cost" checked disabled>自费</label>
	                      </c:when>
	                 </c:choose>
                 </td>
                 <td>家庭住址</td>
                 <td colspan="3">${student.address}</td>
                 </tr>
                 <tr>
                 <td>学习工作状态</td>
                 <td colspan="3">
	                    <c:choose>
	                       <c:when test="${student.componentCode=='s'}">
	                           <label class="padr_20"><input type="radio" name="state" checked disabled>在读</label>
	                           <label class="padr_20"><input type="radio" name="state" disabled>在职</label>
	                           <label class="padr_20"><input type="radio" name="state" disabled>待业</label>
	                       </c:when>
                           <c:when test="${student.componentCode=='w'}">
                               <label class="padr_20"><input type="radio" name="state"  disabled>在读</label>
                               <label class="padr_20"><input type="radio" name="state" checked disabled>在职</label>
                               <label class="padr_20"><input type="radio" name="state" disabled>待业</label>
                           </c:when>
                           <c:when test="${student.componentCode=='u'}">
                               <label class="padr_20"><input type="radio" name="state"  disabled>在读</label>
                               <label class="padr_20"><input type="radio" name="state"  disabled>在职</label>
                               <label class="padr_20"><input type="radio" name="state"  checked disabled>待业</label>
                           </c:when>
	                    </c:choose>
	             </td>
                 <td>信息来源</td>
                 <td colspan="3" id="chooseSource">
                        <c:choose>
                           <c:when test="${student.studentResources == 'net'}">
                                <label class="padr_20"><input type="radio" name="source" checked disabled>网络</label>
		                        <label class="padr_20"><input type="radio" name="source" disabled>朋友介绍</label>
		                        <label class="padr_20"><input type="radio" name="source" disabled>其他</label>
		                        <input type="text" class="edit_box boxbor" id="sourceBox" style="width:40%;" disabled />
                           </c:when>
                           <c:when test="${student.studentResources == 'friend'}">
                                <label class="padr_20"><input type="radio" name="source" disabled>网络</label>
		                        <label class="padr_20"><input type="radio" name="source" checked disabled>朋友介绍</label>
		                        <label class="padr_20"><input type="radio" name="source" disabled>其他</label>
		                        <input type="text" class="edit_box boxbor" id="sourceBox" style="width:40%;" disabled />
                           </c:when>
                           <c:when test="${student.studentResources == 'other'}">
                                <label class="padr_20"><input type="radio" name="source" disabled>网络</label>
		                        <label class="padr_20"><input type="radio" name="source" disabled>朋友介绍</label>
		                        <label class="padr_20"><input type="radio" name="source" checked disabled>其他</label>
		                        <input type="text" class="edit_box boxbor" id="sourceBox" value = "${student.otherResources}"style="width:40%;" disabled />
                           </c:when>
                        </c:choose>
                 </td>
                 </tr>
                 <tr>
                 <td>兴趣爱好特长</td>
                 <td colspan="8">${student.hobbies}</td>
                 </tr>
                 <tr>
                 <td>备注</td>
                 <td colspan="8">${student.note}</td>
                 </tr>
                 <tr>
                 <td>身份证信息</td>
                 <td colspan="8">
                 <script type="text/javascript">
                          $(function(){
                              var cardFrontAddress="${student.cardFrontAddress}";
                              var cardReverseAddress = "${student.cardReverseAddress}";
                              if(cardFrontAddress.indexOf("p")>0 || cardFrontAddress.indexOf("g") > 0){
                            	  $("#cIDImgA").attr('style','display:none');
                            	  $("#cIDImgAA").removeAttr("style");
                              } 
                             if(cardReverseAddress.indexOf("p")>0 || cardReverseAddress.indexOf("g") > 0){
                            	  $("#cIDImgB").attr('style','display:none');
                            	  $("#cIDImgBB").removeAttr("style");
                              } 
                        });
                     </script> 
                     <!--上传前样式-->
                     <div class="clearfix" >
                          <div class="upload_img" id="cIDImgA" >
                               <div class="upload_area" >
                                   <a href="javascript:void(0);"  id="AA" class="upload_pic"><span class="font24">暂无上传照片</span></a>
                                   <p>身份证正面</p>
                               </div>
                          </div> 
                           <div class="upload_img" style="display:none;" id="cIDImgAA">
                               <div class="upload_area" >
                                   <input type="file" id="idcardA" name="idcardA" style="display:none">
                                   <a href="javascript:void(0);"   id="iAA" class="upload_pic"><img src="${imgBasePath}/${student.cardFrontAddress}" id="imgIdcardA" title="身份证正面" /></a>
                                   <p>身份证正面</p>
                               </div>
                          </div>
                          <div class="upload_img" id="cIDImgB" >
                               <div class="upload_area">
                                   <a href="javascript:void(0);"  id="BB" class="upload_pic"><span class="font24">暂无上传照片</span></a>
                                   <p>身份证反面</p>
                               </div>
                          </div> 
                          <div class="upload_img" style="display:none;" id="cIDImgBB">
                               <div class="upload_area">
                                   <input type="file" id="idcardB" name="idcardB" style="display:none">
                                   <a href="javascript:void(0);" id="iBB" class="upload_pic"><img src="${imgBasePath}/${student.cardReverseAddress}" id="imgIdcardB" title="身份证反面" /></a>
                                   <p>身份证反面</p>
                               </div>
                          </div>
                      </div> 
                 </td>
                 </tr>
                 </table>
                <!--  <div class="mart_14">
                          <a href="javascript:history.go(-1);" class="add_btn bg_gray">返回</a>
                 </div>  -->
             </div>
             <div class="stu_info" style="margin-top:20px;">
                  <ul>
                      <li>专业信息</li>
                  </ul>
             </div>
             <div class="stuDetail" ><!-- style="display:none;" -->
                 <table width="100%" class="specialty">
                 <tr>
                 <th>序号</th>
                 <th><span class="color_red">*</span>学员编号</th>
                 <th><span class="color_red">*</span>专业名称</th>
                 <th><span class="color_red">*</span>报名日期</th>
                 <th><span class="color_red">*</span>专业价格</th>
                 <th><span class="color_red">*</span>支付方式</th>
                 <th><span class="color_red">*</span>实付金额</th>
                 <th>尾款</th>
                 <th>学员专业状态</th>
                 <th>是否退费</th>
                 <th>退费金额</th>
                 <th>退费原因</th>
                 <th>备注</th>
                 <th width="66">操作</th>
                 </tr>
			     <c:if test="${fn:length(course) == 0}">
			             <tr><td colspan="14">暂无学员专业数据</td></tr>
			     </c:if>
			     <c:forEach items="${course}" var="s" varStatus="status">
			          <tr>
		                 <td>${status.index+1}</td>
		                 <td>${s.professionCode}</td>
		                 <td>${s.courseName}</td>
		                 <td><fmt:formatDate value="${s.enterDate}" type="date" /></td>
		                 <td>${s.amountPayable}</td>
		                 <td>${s.payMethodValue}</td>
		                 <td>${s.payment}</td>
		                 <td>${s.arrears}</td>
		                 <c:choose>
		                    <c:when test="${s.statues == 'reading'}">
		                      <td class ="stuStatues">在读</td>
		                    </c:when>
		                     <c:when test="${s.statues == 'stay'}">
		                      <td class ="stuStatues" data-reasons="${s.changeReason}" data-times="<fmt:formatDate value="${s.changeTime}" type="date" pattern="yyyy-MM-dd"/>">留级</td>
		                    </c:when>
		                    <c:when test="${s.statues == 'drop'}">
		                      <td class ="stuStatues" data-reasons="${s.changeReason}" data-times="<fmt:formatDate value="${s.changeTime}" type="date" pattern="yyyy-MM-dd"/>" >退学</td>
		                    </c:when>
		                    <c:when test="${s.statues == 'pause'}">
		                      <td class ="stuStatues" data-reasons="${s.changeReason}" data-times="<fmt:formatDate value="${s.changeTime}" type="date" pattern="yyyy-MM-dd"/>"" >休学</td>
		                    </c:when>
		                    <c:when test="${s.statues == 'continues'}">
		                      <td class ="stuStatues">复学</td>
		                    </c:when>
		                    <c:when test="${s.statues == 'end'}">
		                      <td class ="stuStatues">结束</td>
		                    </c:when>
		                 </c:choose>
		                 <c:choose>
		                    <c:when test="${s.isRefund == 'Y'}">
		                      <td>是</td>
		                    </c:when>
		                    <c:when test="${s.isRefund == 'N'}">
		                      <td>否</td>
		                    </c:when>
		                 </c:choose>
		                 <td>${s.refundMonetary}</td>
		                 <td>${s.refundReasonVlaue}</td>
		                 <td>${s.remark}</td>
		                 <td><a href="javascript:void(0);" class="check_icon main_icon stuStatus1"></a></td>
	                 </tr>
			     </c:forEach>
                 </table>
                 <div class="mart_14"><a href="javascript:history.go(-1);" class="add_btn bg_gray">返回</a></div>
             </div>
         </div>
     </div>
</div>
<!--学员状态弹出层-->
<div class="pop_div studentPop">
     <div class="pop_content">
          <div class="pop_title"><span>学员专业状态：</span></div>
          <div class="pop_student">
               <div class="status">
                   <label class="padr_20"><input type="radio" name="status" value="在读"  disabled>在读</label>
                   <label class="padr_20"><input type="radio" name="status" value="留级"  disabled>留级</label>
                   <label class="padr_20"><input type="radio" name="status" value="退学"  disabled>退学</label>
                   <label class="padr_20"><input type="radio" name="status" value="休学"  disabled>休学</label>
                   <label class="padr_20"><input type="radio" name="status" value="复学"  disabled>复学</label>
                   <label class="padr_20"><input type="radio" name="status" value="结束"  disabled>结束</label>
              </div>
              <div class="status_con " id ="statuesReason" ></div>
                     <div class="status_con profStatus"  id = "drop" style="display:none;">
	                    <p><span>退学日期：</span><input type="text" class="search_box boxbor" disabled/></p>
	                    <p><span>退学原因：</span><textarea class="textarea_box1 boxbor" disabled></textarea></p>
	                 </div>
                     <div class="status_con profStatus" id = "pause" style="display:none;">
	                    <p><span>休学日期：</span><input type="text" class="search_box boxbor" disabled/></p>
	                    <p><span>休学原因：</span><textarea class="textarea_box1 boxbor" disabled></textarea></p>
	                 </div>
                     <div class="status_con profStatus" id="stay" style="display:none;">
	                    <p><span>留级日期：</span><input type="text" class="search_box boxbor" disabled/></p>
	                    <p><span>留级原因：</span><textarea class="textarea_box1 boxbor" disabled></textarea></p>
	                 </div>
          </div>
          <div class="pop_btn"><a href="javascript:void(0);" class="add_btn bg_gray marl_20 Quit">取消</a></div>
     </div>
</div>

<script type="text/javascript">
//点击学员状态弹出窗、点击查看图标 js
$(".stuStatus1").on("click",function(){
	var dom =$(this);
	$(".studentPop").fadeIn();
	var givenStatus = dom.parent().siblings().eq(8).text();
	var times = dom.parent().siblings().eq(8).data("times"); 
	var reasons = dom.parent().siblings().eq(8).data("reasons");
	$("input[name=status]").each(function(n, em){
		if($(em).val() == givenStatus) {
			$(em).prop("checked", true);
			if(givenStatus=="留级"){
				$(".profStatus input").val(times);
				$(".profStatus textarea").val(reasons);
				$("#stay").removeAttr("style");
				$("#drop").attr("style","display:none;");
				$("#pause").attr("style","display:none;");
			}else if(givenStatus=="休学"){
				$(".profStatus input").val(times);
				$(".profStatus textarea").val(reasons);
				$("#pause").removeAttr("style");
				$("#drop").attr("style","display:none;");
				$("#stay").attr("style","display:none;");
			}else if(givenStatus=="退学"){
				$(".profStatus input").val(times);
				$(".profStatus textarea").val(reasons);
				$("#drop").removeAttr("style");
				$("#pause").attr("style","display:none;");
				$("#stay").attr("style","display:none;");
			}else if(givenStatus=="在读" || givenStatus=="复学" || givenStatus=="结束"){
				$("#stay").attr("style","display:none;");
				$("#pause").attr("style","display:none;");
				$("#drop").attr("style","display:none;");
			}
			$(em).click();
		}
	});
});
	
	/***取消影藏框***/
	$(".Quit").click(function(){
		$(".studentPop").hide();
	});
	
	//轮换 js
/* 	$(".stu_info li").click(function(){
		$(this).addClass("oncurrent").siblings().removeClass("oncurrent");
		var ind = $(this).index();
		$(this).parents(".stu_info").nextAll(".stuDetail").hide().filter(":eq("+ind+")").slideDown(200);
		$(this).parents(".marb_14").prevAll(".searchBar").hide().filter(":eq("+ind+")").show();
	});
	$("#Scale a").click(function(){
		$(this).addClass("divide_btnon").removeClass("divide_btn").siblings().removeClass("divide_btnon").addClass("divide_btn");
		var scal = $(this).index();
		$(this).parents("#Scale").nextAll(".statistic_con").hide().filter(":eq("+scal+")").fadeIn(200);
	}); */
	$("#curMenuLableName").after("&gt; <a href='javascript:void(0);'>学员信息详情</a>");
</script>
</body>
</html>