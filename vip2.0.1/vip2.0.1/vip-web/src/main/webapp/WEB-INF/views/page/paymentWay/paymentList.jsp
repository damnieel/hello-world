<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@include file="/WEB-INF/common/taglib.jsp" %>
        <table width="100%" class="table_style" >
             <tr>
             <th width="40"><input type="checkbox" id="selectAll" onclick="SelectAll();"></th>
             <th width="80">序号</th>
             <th>支付方式</th>
             <th>操作</th>
             </tr>
             
             <c:if test="${fn:length(paymentList) == 0}">
	             <tr>
	             	<td colspan="4">暂无数据</td>
	             </tr>
	         </c:if>
             <c:forEach var="payment" items="${paymentList}" varStatus="status">
             <tr>
             <td><input name ="items" type="checkbox" class="items" data-id ="${payment.id}"></td>
             <td>${offset+status.index+1}</td>
             <td>${payment.codeValue}</td>
             <td><a href="javascript:void(0);" class="edit_icon main_icon"  data-id ="${payment.id}"></a></td>
             </tr>
             </c:forEach>
         </table>
   
<!--修改支付方式弹出层-->
<div class="pop_div updatePayment">
     <div class="pop_content">
          <div class="pop_title"><span>修改支付方式</span></div>
          <div class="pop_student">
               <div class="status_con statusCon">
                    <p><span>支付方式：</span><input type="text" class="search_box boxbor" id="value"/></p>
               </div>
          </div>
          <div class="pop_btn"><a  href="javascript:void(0);" class="add_btn bg_blue sure">保存</a><a  href="javascript:void(0);" class="add_btn bg_gray marl_20 No">取消</a></div>
     </div>
</div>
<input type="hidden" id="itemCount" value="${count}" />
<%-- <script type="text/javascript" src="${basePath}resources/js/jquery.pagination.js"></script> --%>
<script type="text/javascript">
	var codeValue=" ";
	$(function(){
		$(".edit_icon").click(function(){
			var id =$(this).data("id");
			 $.ajax({
					url:basePath+"admin/payment/showPayment/"+id+".htmls",
					data:{"id":id},
					success:function(data){
						var data =eval("("+data+")");
						$("#value").val(data[1]);
						codeValue=$("#value").val();
						$("#value").attr("data-cid",data[2]);
						$(".updatePayment").fadeIn(200);
					}
				}); 
		});
		
		$(".No").click(function(){
			$(".updatePayment").hide();
		});
		
		/** 修改支付方式 **/
		$(".sure").click(function(){
			var id =$("#value").data("cid");
			var value =$("#value").val();
			/** 判断是否为空**/ 
			if(isEmpty(value)){
				tmLoading("请输入支付方式",2); 
				return;
			}
			
			if(codeValue==value){
				tmLoading("修改成功",1);
				setTimeout(function(){
					tm_refreash();
				},1000);
				return;
			}else{
				 $.ajax({
						url:basePath+"admin/payment/updatePayment.htmls",
						data:{"id":id,"codeValue":value},
						success:function(data){
							var data =eval("("+data+")");
							if(data.msg=="true"){
								tmLoading("修改成功",1);
								setTimeout(function(){
									tm_refreash();
								},1000);
							}else if(data.msg=="equals"){
								tmLoading("已存在该支付方式",2);  
							}else{
								tmLoading("修改失败",1);
							}
						}
					});
			}
			
		});
	});
	
</script>