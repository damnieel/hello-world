<%@ page language="java" pageEncoding="UTF-8"%>
<div class="fl" id="element_id">
              <div class="marl_20 fl">根据职能：</div>
 <!--              <select class="committee  bdr"></select>
              <select class="cluster  bdr"></select>
 			  <select class="part  bdr"></select>
 			  <select class="professional  bdr"></select>
 			  <select class="class  bdr"></select> -->
</div>
<%
   String size = request.getParameter("size");
%>
<script type="text/javascript">
	var size = "<%=size %>";
	var selects = ['cluster','part','professional','class'];
	if(size < 5) {
		var html = "";
		for(var i=0;i<size;i++) {
			var classVal = selects[i] + ' bdr';
			if(i==0) {
				html = "<select class='"+selects[i]+"'></select>";
			} else {
				html = html + "<select class='"+classVal+"'></select>";
			} 
		}	
		$("#element_id>div").after(html);
		selects = selects.slice(0,size);
		
	} else {
		console.log("级联菜单数目不能超过4");
	}
 	//展示下拉搜索框
	$.ajax({
		type: "get",
		url : basePath + "orgProfessional/showComboBox.htmls",
		dataType : "json",
		success : function(data) {
			/* console.log(data); */
			$('#element_id').cxSelect({ 
				url:data, 
				selects: selects , 
				nodata: 'none' 
			}); 
		}
	}); 
</script>