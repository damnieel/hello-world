<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ include file="/WEB-INF/common/taglib.jsp"%>
<script type="text/javascript" src="${basePath}resources/js/My97DatePicker/WdatePicker.js"></script>
<table width="100%" class="table_style">
	<tr>
		<th width="80">序号</th>
		<th>专业</th>
		<th>班级信息</th>
		<th>起始日期</th>
		<th>结束日期</th>
		<th>讲师</th>
		<th>班主任</th>
		<th>操作</th>
	</tr>
		<c:if test="${fn:length(list) == 0}">
		<tr><td colspan="8">暂无数据</td></tr>
		</c:if>
			<c:forEach items="${list}" var="s" varStatus="status">
				<tr>
					<td>${offset+status.index+1}</td>
					<td>${s.majorName}</td>
				    <td>${s.className}</td>
					<td><fmt:formatDate value="${s.startDate}" type="Date" pattern="yyyy-MM-dd"/></td>
                    <td><fmt:formatDate value="${s.endDate}" type="Date" pattern="yyyy-MM-dd"/></td>
                    <td style="display:none">${s.majorId}</td>
				    <td>${s.teacher}</td>
					<td>${s.adviser}</td>
					<c:if test="${s.isEnd == 'Y'}">
	             	<td>
	             	  <a  class="edit_icon main_icon" disabled="true" ></a>
				      <a  class="delet_specialty main_icon"  disabled="true" ></a>
				      <a  class="again_btn bg_gray marl_20"  disabled="true" >已结课</a>
				    </td>
		            </c:if>
		            <c:if test="${s.isEnd == 'N'}">
					<td>
				   	<vip:updateSecurity organizationId="${s.id}">
					  <a href="javascript:void(0);" class="update edit_icon main_icon"  claId="${s.id}"></a>
					 </vip:updateSecurity>
				   	 <vip:deleteSecurity organizationId="${s.id}">
					  <a href="javascript:void(0);" class="del delet_specialty main_icon" claId="${s.id}" ></a>
					 </vip:deleteSecurity>
					  <vip:updateSecurity organizationId="${s.id}">
					  <a href="javascript:void(0);" class="endClass again_btn bg_blue marl_20" claId="${s.id}" >结课</a>
					  </vip:updateSecurity>
					</td>
				    </c:if>
			</c:forEach>
</table>
	<!--修改班级弹出层-->
			<div class="pop_div" id="updateClaDeatil">
				<div class="pop_content">
					<div class="pop_title">
						<span>修改班级信息</span>
					</div>
					<div class="pop_student">
						<div class="status_con statusCon">
							<p>
								<span>班级名称：</span><input type="text" class="search_box boxbor"
									id="className" style="margin-left: 1px;"/>
							</p>
							<p>
							<span>班级周期：</span>
								<input type="text" class="text_box boxbor" readonly="readonly" style ="width:92px;margin-left:-3px;"
            		                id="nstartDate" onClick="WdatePicker({maxDate:'#F{$dp.$D(\'nendDate\')}',dateFmt:'yyyy-MM-dd'})"  placeholder="开始时间">
            		               <!--  <i class="main_icon data_img"></i> -->
							    <input type="text" class="text_box boxbor" readonly="readonly" style ="width:92px"
            	             	id="nendDate" onClick="WdatePicker({minDate:'#F{$dp.$D(\'nstartDate\')}',dateFmt:'yyyy-MM-dd'})" placeholder="结束时间">
            	             	<!-- <i class="main_icon data_img"></i> -->
							<p>
								<span>讲师：</span><select name="techer" id="nteacherCode" style="width: 92px;">
								</select>
							</p>
							<p>
								<span>班主任：</span><select name="techer" id="nadviserCode" style="width: 92px;">
								</select>
							</p>
						</div>
					</div>
					<div class="pop_btn">
						<a href="javascript:void(0);" id = "summits" class="add_btn bg_blue">确定</a>
						<a href="javascript:void(0);" class="add_btn bg_gray marl_20 Quit" id="cleanData">取消</a>
					</div>
				</div>
		</div>


<script type="text/javascript" src="${basePath}resources/js/sys/updateClass.js"></script>
<%-- <script type="text/javascript" src="${basePath}resources/js/sys/classSetting.js"></script> --%>





