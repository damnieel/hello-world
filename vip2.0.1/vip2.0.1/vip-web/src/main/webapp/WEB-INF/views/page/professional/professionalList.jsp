<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="Generator" content="EditPlus">
<meta name="Author" content="">
<meta name="Keywords" content="">	
<meta name="Description" content="">
<meta http-equiv="X-UA-Compatible" content="chrome=1;IE=Edge;">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/common/commonResource.jsp" %>
<link href="${basePath}resources/css/pagination/page.css" rel="stylesheet">
<title>系统管理_职业数据</title>
</head>
<body>
	<%@include file="/WEB-INF/views/page/sys/left.jsp" %>	
	<div class="main_right">	
		<%@include file="/WEB-INF/views/page/sys/top.jsp" %> 
     <div class="main_con clearfix">
         <div class="marb_14 clearfix">
              <a href="javascript:void(0);" class="add_btn bg_blue addP"><i class="main_icon add_icon addvocation"></i>添加职业</a>
              <a href="javascript:void(0);" class="deletInfo delet_btn marl_20">删除</a>
         </div>
         <div class="marb_14 clearfix">
            <div id="professional"></div>
            <div id="page" class="mart_14"></div>
         </div>
     </div>
</div>

<!--新增职业弹出层-->
<div class="pop_div addProfession">
     <div class="pop_content">
          <div class="pop_title"><span>添加职业</span></div>
          <div class="pop_student">
               <div class="status_con statusCon">
                    <p><span>职业名称：</span><input type="text" class="search_box boxbor" id="codeValue"  placeholder="请输入1~20个字符"/></p>
               </div>
          </div>
          <div class="pop_btn"><a href="javascript:void(0);" class="add_btn bg_blue Sure">确定</a><a href="javascript:void(0);" class="add_btn bg_gray marl_20 Quit">取消</a></div>
     </div>
</div>
<script type="text/javascript" src="${basePath}resources/js/student/professional.js"></script>
<script type="text/javascript" src="${basePath}resources/js/student/professionalDelete.js"></script>
<script type="text/javascript" src="${basePath}resources/js/pagin/jquery.pagination.js"></script>
</body>
</html>