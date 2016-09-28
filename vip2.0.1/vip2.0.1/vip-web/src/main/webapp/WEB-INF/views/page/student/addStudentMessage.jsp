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
<title>学员管理_添加学员信息页面</title>
<script type="text/javascript" src="${basePath}resources/js/student/autocomplete.js"></script>
<%@include file="/WEB-INF/common/commonResource.jsp" %>
<%@include file="/WEB-INF/common/taglib.jsp" %>
<%@page isELIgnored="false"%> 
<script type="text/javascript" src="${basePath}/resources/js/My97DatePicker/WdatePicker.js"></script>
	 
</head>
<body>
	<%@include file="/WEB-INF/views/page/sys/left.jsp" %>	
	<div class="main_right">	
		<%@include file="/WEB-INF/views/page/sys/top.jsp" %> 
     <div class="main_con">
         <div class="marb_14">
             <div class="stu_info">
                  <ul>
                      <li data-stu="${student.id}" id="stuId">学员信息</li> <!-- class="oncurrent" -->
                     <!--  <li id="courseetail">专业信息</li> -->
                  </ul>
             </div>
             <form id="studentForm"  method="post" enctype="multipart/form-data">
             <div class="stuDetail">
                 <table width="100%" class="student">
                 <tr>
                 <td width="9%"><span class="color_red">*</span>学员姓名</td>
                 <td width="13%"><input type="text" class="edit_box boxbor" name = "stuName" id="stuName" value="${student.stuName}"/></td>
                 <td width="9%">姓名拼音</td>
                 <td width="13%"><input type="text" class="edit_box boxbor" name ="nameSpell" id="nameSpell" value="${student.nameSpell}" onKeyUp="value=value.replace(/[^a-zA-Z]/g,'')"/></td>
                 <td width="9%">学历</td>
                 <td width="13%">
                       <select class="select_box boxbor" name ="degree" id="degree">
                               <option value="">请选择</option>
                          <c:forEach  items="${professional}" var="s" varStatus="status">
                             <c:if test="${s.type =='degree'}">
	                           <option value="${s.codeKey}" <c:if test="${s.codeKey == student.educationBackgroundKey}">selected="selected"</c:if>>${s.codeValue}</option>
                             </c:if>
                          </c:forEach>
                        </select>
                 </td>
                 <td width="9%">出生日期</td>
                 <td><input type="text" class="edit_box boxbor" id="birthday" name = "birthday" value="<fmt:formatDate value="${student.birthday}" type="date"/>" readonly="readonly" autocomplete="off"  onClick="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'new Data'})"  placeholder="出生时间"/></td>
                 <td rowspan="6" width="190" style="padding-left:0px; padding-right:0px; background:#ececec;">
                  <script type="text/javascript">
                        $(function(){
                          var ss="${student.stuPictureUrl}";
                          if(ss.indexOf("g") > 0 || ss.indexOf("p") > 0){
                        	  $("#IconImgA").attr('style','display:none');
                        	  $("#IconImgB").removeAttr("style");
                          }
                        });
                   </script> 
	               <!--上传前样式-->
	               <a href="javascript:void(0);" onclick="IconImgClick()" id="IconImgA" class="upload_head"><span class="font24">上传头像</span><i class="main_icon"></i></a>
	               <!--上传后样式-->
	               <input type="file" id="IconImg" name="IconImg" style="display:none">
	               <a href="javascript:void(0);" onclick="IconImgClick()" id="IconImgB" class="upload_head" style="display:none;"><img src="${imgBasePath}/${student.stuPictureUrl}" id ="IconImages" title="学员头像" /></a>
                 </td>
                 </tr>
                 <tr>
                 <td><!-- <span class="color_red">*</span> -->职业</td>
                 <td>
                      <select class="select_box boxbor" name = "professional" id="professional" >
                          <option value="">请选择</option>
                          <c:forEach  items="${professional}" var="s" varStatus="status">
                             <c:if test="${s.type =='professional'}">
	                           <option value="${s.codeKey}" <c:if test="${s.codeKey == student.occupationCodeKey}">selected="selected"</c:if>>${s.codeValue}</option>
                             </c:if>
                          </c:forEach>
                      </select>
                 </td>
                 <td>性别</td>
                 <td>
                      <select class="select_box boxbor" name ="sex" id="sex">
                               <option value = "" <c:if test="${student.sex ==''}">selected="selected"</c:if>>请选择</option>
                               <option value = "男" <c:if test="${student.sex =='男'}">selected="selected"</c:if>>男</option>
                               <option value = "女" <c:if test="${student.sex =='女'}">selected="selected"</c:if>>女</option>
                      </select>
                 </td>
                 <td>籍贯</td>
                 <td><input type="text" class="edit_box boxbor" name="nativePlace" id="nativePlace" value = "${student.nativePlace}"/></td>
                 <td><span class="color_red">*</span>QQ</td>
                 <td><input type="text" class="edit_box boxbor" name="QQ" id="QQ"  value = "${student.QQ}" onkeyup="this.value=this.value.replace(/[^\d]/g,'') " onafterpaste="this.value=this.value.replace(/[^\d]/g,'') "/></td>
                 </tr>
                 <tr>
                 <td>YY</td>
                 <td><input type="text" class="edit_box boxbor" name="YY" id="YY" value="${student.YY}" onkeyup="this.value=this.value.replace(/[\W]/g,'')" onpaste="this.value=this.value.replace(/[\W]/g,'')"/></td>
                 <td>身份证号</td>
                 <td><input type="text" class="edit_box boxbor" name="idCard" id="idCard" value="${student.idCard}" onkeyup="this.value=this.value.replace(/[\W]/g,'')" onpaste="this.value=this.value.replace(/[\W]/g,'')"></td>
                 <td><span class="color_red">*</span>手机号码</td>
                 <td><input type="text" class="edit_box boxbor" name="telephone" value="${student.telephone}" id="telephone"  onkeyup="this.value=this.value.replace(/[^\d]/g,'') " onafterpaste="this.value=this.value.replace(/[^\d]/g,'') "/></td>
                 <td>邮箱</td>
                 <td><input type="text" class="edit_box boxbor" name="email" id="email" value="${student.email}"/></td>
                 </tr>
                 <tr>
                 <td>邮编</td>
                 <td><input type="text" class="edit_box boxbor" name="postalCode" id="postalCode" value="${student.postalCode}" onkeyup="this.value=this.value.replace(/[^\d]/g,'') " onafterpaste="this.value=this.value.replace(/[^\d]/g,'') " /></td>
                 <td>紧急联系人</td>
                 <td><input type="text" class="edit_box boxbor" name="emergencyPerson" id="emergencyPerson" value="${student.emergencyPerson}" /></td>
                 <td>与其关系</td>
                 <td><input type="text" class="edit_box boxbor" name="contratRelationshipsCode" value="${student.contratRelationshipsCode}" id="contratRelationshipsCode"/></td>
                 <td>紧急联系人电话</td>
                 <td><input type="text" class="edit_box boxbor" name = "emergencyTelephone" value="${student.emergencyTelephone}" id="emergencyTelephone" onkeyup="this.value=this.value.replace(/[^\d]/g,'') " onafterpaste="this.value=this.value.replace(/[^\d]/g,'') "/></td>
                 </tr>
                 <tr>
                 <td>毕业学校</td>
                 <td><input type="text" class="edit_box boxbor" name="school" id="school" value="${student.school}"/></td>
                 <td>费用来源</td>
                 <td>
	                      <label class="padr_20"><input type="radio" name="costR" value="home">家庭</label>
	                      <label class="padr_20"><input type="radio" name="costR" value="self">自费</label>
                       <script type="text/javascript">
	                            var superiorRole = "${student.costResources}";
								if(superiorRole == "self") {
									$('input:radio[name="costR"]:last').attr('checked', 'checked'); 
								} else {
									$('input:radio[name="costR"]:first').attr('checked', 'checked'); 
								}
                       </script>
                 </td>
                 <td>家庭住址</td>
                 <td colspan="3"><input type="text" class="edit_box boxbor" name="address" id="address" value="${student.address}"/></td>
                 </tr>
                 <tr>
                 <td>学习工作状态</td>
                 <td colspan="3">
	                       <label class="padr_20"><input type="radio" name="component" value="s" checked="checked">在读</label>
	                       <label class="padr_20"><input type="radio" name="component" value="w">在职</label>
	                       <label class="padr_20"><input type="radio" name="component" value="u">待业</label>
                       <script type="text/javascript">
	                            var superiorRole = "${student.componentCode}";
								if(superiorRole == "s") {
									$('input[name="component"]:eq(0)').prop("checked","checked");
								} else if(superiorRole =="w"){
									$('input:radio[name="component"]:eq(1)').attr('checked', "checked"); 
								}else if(superiorRole == "u"){
									$('input:radio[name="component"]:eq(2)').attr('checked', "checked"); 
								}
                       </script>
                 </td>
                 <td>信息来源</td>
                 <td colspan="3" id="chooseSource">
                       <label class="padr_20"><input type="radio" name="Resources" value="net" checked="checked">网络</label>
                       <label class="padr_20"><input type="radio" name="Resources" value="friend">朋友介绍</label>
                       <label class="padr_20"><input type="radio" name="Resources" value="other" >其他</label>
                       <input type="text" class="edit_box boxbor" id="sourceBox" value="${student.otherResources}" style="width:40%;" disabled /></td>
                       <script type="text/javascript">
	                            var superiorRole = "${student.studentResources}";
								if(superiorRole == "net") {
									$('input[name="Resources"]:eq(0)').attr("checked",true);
								} else if(superiorRole =="friend"){
									$('input:radio[name="Resources"]:eq(1)').attr('checked', true); 
								}else if(superiorRole == "other"){
									$('input:radio[name="Resources"]:eq(2)').attr('checked', true); 
								}
                       </script>
                 </tr>
                 <tr>
                 <td>兴趣爱好特长</td>
                 <td colspan="8"><textarea class="textarea_box boxbor" style="height: 48px;line-height: 24px;" placeholder="1～100字" name="hobbies" id="hobbies" >${student.hobbies}</textarea></td>
                 </tr>
                 <tr>
                 <td>备注</td>
                 <td colspan="8"><textarea class="textarea_box boxbor" style="height: 48px;line-height: 24px;" placeholder="1～100字" name="note" id="note">${student.note}</textarea></td>
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
                                   <a href="javascript:void(0);" onclick="idcardAClick()" id="AA" class="upload_pic"><span class="font24">点击上传</span><i class="main_icon"></i></a>
                                   <p>身份证正面</p>
                               </div>
                          </div> 
                           <div class="upload_img" style="display:none;" id="cIDImgAA">
                               <div class="upload_area" >
                                   <input type="file" id="idcardA" name="idcardA" style="display:none">
                                   <a href="javascript:void(0);"  onclick="idcardAClick()" id="iAA" class="upload_pic"><img src="${imgBasePath}/${student.cardFrontAddress}" id="imgIdcardA" title="身份证正面" /><p>点击编辑</p></a>
                                   <p>身份证正面</p>
                               </div>
                               <a href="javascript:void(0);" class="delet delet_btn" onclick="deleteImg('imgIdcardA')">删除</a>
                          </div>
                          <div class="upload_img" id="cIDImgB" >
                               <div class="upload_area">
                                   <a href="javascript:void(0);" onclick="idcardBClick()" id="BB" class="upload_pic"><span class="font24">点击上传</span><i class="main_icon"></i></a>
                                   <p>身份证反面</p>
                               </div>
                          </div> 
                          <div class="upload_img" style="display:none;" id="cIDImgBB">
                               <div class="upload_area">
                                   <input type="file" id="idcardB" name="idcardB" style="display:none">
                                   <a href="javascript:void(0);" onclick="idcardBClick()" id="iBB" class="upload_pic"><img src="${imgBasePath}/${student.cardReverseAddress}" id="imgIdcardB" title="身份证反面" /><p>点击编辑</p></a>
                                   <p>身份证反面</p>
                               </div>
                               <a href="javascript:void(0);" class="delet delet_btn" onclick="deleteImg('imgIdcardB')">删除</a>
                          </div>
                      </div> 
                 </td>
                 </tr>
                 </table>
                 
                <%--  <div class="mart_14">
                          <a href="javascript:history.go(-1);" class="add_btn bg_gray">返回</a>
                          <input  class="add_btn bg_blue marl_20 Conserve saveStudentDetail" type="submit" data-id="${student.id}" value="保存"  >
                 </div>  --%>
                 
             </div>
             <div class="stu_info" style="margin-top:20px;">
                  <ul>
                      <li>专业信息</li>
                  </ul>
             </div>
             <div class="stuDetail" ><!-- style="display:none;" -->
                 <table width="100%" id= "add" class="specialty">
                 <tr>
                 <th width="50">序号</th>
                 <th><span class="color_red">*</span>学员编号</th>
                 <th><span class="color_red">*</span>专业名称</th>
                 <th><span class="color_red">*</span>报名日期</th>
                 <th><span class="color_red">*</span>专业价格</th>
                 <th width="80"><span class="color_red">*</span>支付方式</th>
                 <th><span class="color_red">*</span>实付金额</th>
                 <th>尾款</th>
                 <th>学员专业状态</th>
                 <th width="80">是否退费</th>
                 <th>退费金额</th>
                 <th>退费原因</th>
                 <th>备注</th>
                 <th width="66"><a href="javascript:void(0);" class="add_specialty main_icon" onclick="addRecord();"></a></th>
                 </tr>
                 <c:forEach items="${courseVO}" var ="courses" varStatus="index"> 
                     <tr>
	                 <td data-pid="${courses.pId}" class="courseID">${index.index+1}</td>
	                 <td><input type="text" class="edit_box1 boxbor professionCode" value="${courses.professionCode}" /></td>
	              <%--     <td style="display: none;">
	                      <select class="select_box1 boxbor courseName" >
	                          <option value = "">请选择</option>
	                          <c:forEach items="${course}" var="s">
	                             <option value="${s.id}" data-id="${s.id}" data-qid = "${s.codeValue}" <c:if test="${s.id == courses.opProId}">selected="selected"</c:if>>${s.courseName}</option>
	                          </c:forEach>
	                      </select>
	                 </td>  --%>
	                  <td style="position:relative;">
		                  <input type="text" class="edit_box1 boxbor courseName majorName"  value="${courses.courseName}"   placeholder="请填写专业名称" />
			              <div class="auto_hidden majorbox" id = "auto"></div>
			    <!--       <script>
		                    var  autoComplete  = new AutoComplete('majorName${index.index}','auto${index.index}',['123','b12','b22','b3','b4','b5','b6','b7','b8','b2','abd','ab','acd','accd','b1','cd','ccd','cbcv','cxf']);
		                 </script>  -->
		              </td>
	                 
	                 <td>
	                    <input type="text" class="edit_box1 boxbor enterDate"  readonly="readonly" value="<fmt:formatDate value="${courses.enterDate}" type="date" pattern="yyyy-MM-dd"/>" onClick="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'new Data'})"  placeholder="报名时间">
	                 </td>
	                 <td><input type="text" class="edit_box1 boxbor amountPayable" value="${courses.amountPayable}" onclick="changeMoney()" onkeyup="this.value=this.value.replace(/[^\d]/g,'') " onafterpaste="this.value=this.value.replace(/[^\d]/g,'') "/>
	                 </td>
	                 <td>
	                      <select class="select_box1 boxbor payMethod">
	                          <option value = "">请选择</option>
	                          <c:forEach  items="${professional}" var="s" varStatus="status">
	                             <c:if test="${s.type =='payment'}">
		                           <option value="${s.codeKey}" data-id="${s.codeKey}" <c:if test="${s.codeKey == courses.payMethodKey}">selected="selected"</c:if>>${s.codeValue}</option>
	                             </c:if>
	                          </c:forEach>
	                      </select>
	                 </td>
	                 <td><input type="text" class="edit_box1 boxbor payment" onclick="changeMoney()" value = "${courses.payment}" onkeyup="this.value=this.value.replace(/[^\d]/g,'') " onafterpaste="this.value=this.value.replace(/[^\d]/g,'') "/>
	                 </td>
	                 <td><input type="text" class="boxbor arrears"  value="${courses.arrears}" disabled="disabled"/></td>
	                 <td><input type="text" class="edit_box1 boxbor stuStatus statues" data-keys = "${courses.statues}" data-value ="${courses.statues}" data-reasons="${courses.changeReason}" data-times="<fmt:formatDate value="${courses.changeTime}" type="date" pattern="yyyy-MM-dd"/>" value="${courses.statuesValue}"/>
	                 </td>
	                 <td>
	                      <select class="select_box1 boxbor isRefund" >
			                      <option value="" <c:if test="${courses.isRefund =='' }">selected="selected"</c:if>>请选择</option>
	                              <option value="Y" <c:if test="${courses.isRefund =='Y' }">selected="selected"</c:if>>是</option>
	                              <option value="N" <c:if test="${courses.isRefund =='N' }">selected="selected"</c:if>>否</option>
	                      </select>
	                 </td>
	                 <td><input type="text" class="edit_box1 boxbor refundMonetary" value="${courses.refundMonetary}" onkeyup="this.value=this.value.replace(/[^\d]/g,'') " onafterpaste="this.value=this.value.replace(/[^\d]/g,'') "/>
	                 </td>
	                 <td>
	                      <select class="select_box1 boxbor refundReason" >
	                         <option value="">请选择</option><
	                         <c:forEach  items="${professional}" var="s">
	                             <c:if test="${s.type =='refund_reason'}">
		                           <option value="${s.codeKey}" data-id="${s.codeKey}" <c:if test="${courses.refundReasonKey == s.codeKey }">selected="selected"</c:if>>${s.codeValue}</option>
	                             </c:if>
	                         </c:forEach>
	                      </select>
	                 </td>
	                 <td><input type="text" class="edit_box1 boxbor remark"  value="${courses.remark}" /></td>
	                 <td><a href="javascript:void(0);" class="delet_specialty main_icon  deleteCourse" data-course="${courses.pId}"></a></td>
                   </tr>
                     </c:forEach>
<!--学员状态弹出层-->
<div class="pop_div studentPop">
     <div class="pop_content">
          <div class="pop_title"><span>学员专业状态：</span></div>
          <div class="pop_student">
               <div class="status">
                   <label class="padr_20"><input type="radio" name="status" data-key="reading" value="在读">在读</label>
                   <label class="padr_20"><input type="radio" name="status" data-key="stay" value="留级">留级</label>
                   <label class="padr_20"><input type="radio" name="status" data-key="drop" value="退学">退学</label>
                   <label class="padr_20"><input type="radio" name="status" data-key="pause" value="休学">休学</label>
                   <label class="padr_20"><input type="radio" name="status" data-key="continues" value="复学">复学</label>
                   <label class="padr_20"><input type="radio" name="status" data-key="end" value="结束">结束</label>
                  
               </div>
               <div class="status_con statusCon" style="display:none;"></div>
               <div class="status_con statusCon" id="profStatus" style="display:none;">
                    <p><span>留级日期：</span><input type="text" class="search_box boxbor changeTime" autocomplete="off"  onClick="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'new Data'})"  value="<fmt:formatDate value="${courses.changeTime}" type="date"/>"/></p>
                    <p><span>留级原因：</span><textarea class="textarea_box1 boxbor changeReason" autocomplete="off" ></textarea></p>
               </div>
               <div class="status_con statusCon" style="display:none;"></div>
               <div class="status_con statusCon" style="display:none;"></div>
          </div>
          <div class="pop_btn"><a href="javascript:void(0);" class="add_btn bg_blue Sure">确定</a><a href="javascript:void(0);" class="add_btn bg_gray marl_20 Quit">取消</a></div>
     </div>
</div>

                 </table>
                 <div class="mart_14">
                       <a href="javascript:history.go(-1);" class="add_btn bg_gray">返回</a>
                      <%--  <a href="javascript:void(0);" class="add_btn saveStudent bg_blue marl_20 Conserve saveStudentCourse" data-id="${courses.studentId}">保存</a> --%>
                       <input  class="add_btn bg_blue marl_20 Conserve saveStudentDetail" type="submit" data-id="${student.id}" data-id="${courses.studentId}" value="保存"  >
                 </div>
             </div>
         </form>
         </div>
     </div>
</div>

<script type="text/javascript" src="${basePath}resources/js/upload/uploadPreview.js"></script>
<script type="text/javascript" src="${basePath}resources/js/jquery.form.js"></script>
<script type="text/javascript" src="${basePath}resources/js/student/addStudentUpdate.js"></script>
<%-- <script type="text/javascript" src="${basePath}resources/js/student/addStudent.js"></script> --%>
<script type="text/javascript">
$(function(){
	  var course = '${course}'; 
	course = eval(course);
	var  a = new Array();
	for(var i =0; i< course.length ;i++){
		a[i] = course[i].courseName;
	}
//alert(a);
	$(".majorName").keyup(function(){
		  var  autoComplete  = new AutoComplete($(this),$(this).next()[0],a);
		  autoComplete.start(this); 
	}) 
	
	
	
	//单选按钮 js
	$("#chooseSource label").click(function(){
		var ind = $(this).index();
		if(ind == 2){
			$("#sourceBox").removeAttr("disabled");
		}else{
			$("#sourceBox").attr({disabled:true});
		}
	});
	
	var isRefunds = "${courses.isRefund}";
	/**删除学员专业记录**/
	$("body").on("click",".deleteCourse",function(){
		var pId=$(this).data("course");
		tm_dialoag.confirm({title:"删除",content:"您确定删除吗?",height:170,callback:function(ok){
			if(ok){
			if(isEmpty(pId)){
				tmLoading("删除失败",1);
			}
			 $.tpAjax.request({
				url:basePath + "student/studentDetail/deleteCourse/" + pId + ".htmls",
				callback:function(data){
					var data =eval("("+data+")");
					if(data == "success"){
						tmLoading("删除成功",1);
						$(this).parents(".removetr").slideUp("1000",function(){
						  $(this).remove();
						});
						tm_refreash();
					}else{
						tmLoading("删除失败",1);
					}
				}
			},{"pId":pId});}
		}});
	});
	
	$("#curMenuLableName").after("&gt; <a href='javascript:void(0);'>添加学员信息</a>");	
});



</script>

</body>
</html>