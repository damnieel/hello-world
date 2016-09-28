<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Strict//EN">
<html lang="en">
<head>
<meta name="Generator" content="EditPlus">
<meta name="Author" content="">
<meta name="Keywords" content="">	
<meta name="Description" content="">
<meta http-equiv="X-UA-Compatible" content="chrome=1;IE=Edge;">
<style>.divcss5-right{width:320px; height:120px;border:1px solid #F00;float:right} </style>
<%@include file="/WEB-INF/common/commonResource.jsp" %>
<link href="${basePath}resources/css/pagination/page.css" rel="stylesheet">
<script type="text/javascript" src="${basePath}resources/js/searchStudent/studentSearch.js"></script>
<title>系统管理_学员数据上传</title>
</head>
<body>
	<%@include file="/WEB-INF/views/page/sys/left.jsp" %>	
	<div class="main_right">	
		<%@include file="/WEB-INF/views/page/sys/top.jsp" %> 
		<div class="main_con">
			<div class="password_change">
				<form action="${basePath}admin/upload/uploadStudentData.htmls"  
					method="post" id="myForm" enctype="multipart/form-data"> 
					<p class="data_upload"><input type="file" name="file">
					<p class="data_upload clearfix"><input type="button" id="upload" class="add_btn bg_blue" value="确认上传"></p>
		              <p class="data_upload color_red font12">VIP2.0数据上传要求：<br>
		              1、专业名称如有字母，字母大小写要和VIP系统里大小写一致。<br>
		              2、Excel表格格式必须为2003版,后缀为xls或xlt等<br>
		              3、Excel表格中（学员姓名、手机、QQ、专业名称、专业价格、实付金额、报名日期）必填字段。<br>
		              4、报名日期统一（YYYY/MM/DD）斜杠格式。<br>
		              5、上传数据除了必要字段的黄色不要加任何样式，直接用原始的Excel2003<br>
		              6、上传失败后，所有的数据都未上传，请更改数据后重新上传<br></p>
				</form>
			</div>
		  
		<!-- start for xiangui -->
		<div class="search_condition marb_14 clearfix">
	              <div class="marl_20 fl">学员上传错误信息查询：</div> 
	              <div class="search fl">
	                 <input type="text" id="keyword" class="search_box boxbor"  placeholder="QQ" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" />
	                 <a href="javascript:void(0);" class="search_icon main_icon"></a>
	              </div>
	    </div>
	    <div class="marb_14">
             <div id="studentList"></div>
             <div id="page" class="mart_14"></div>
        </div>
	    <!-- end -->
		  
		</div>
	</div>
    
    
	<script type="text/javascript">
	$("#upload").click(function(){
		var file = $("input[name='file']").val();
		if(isEmpty(file)) {
			tmLoading("您没有选择文件...", 1);
			return false;
		} 
		tm_dialoag.confirm({content:"你确定上传学员数据么？",callback:function(ok){
			if(!ok){
				return false;
			} else {
				$("#myForm").submit();
				return true;
			}
		}
	});
	});
	</script>
</body>
</html>