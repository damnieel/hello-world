<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<%@include file="/WEB-INF/common/commonResource.jsp" %>
<title>系统管理_密码修改</title>
</head>
<body>
<%@include file="/WEB-INF/views/page/sys/left.jsp" %>
	<div class="main_right">
<%@include file="/WEB-INF/views/page/sys/top.jsp" %> 
     <div class="clearfix">
        
     </div>
     <div class="main_con">         
         <div class="password_change">
              <table width="100%" height="230">
              <tr>
              <td align="right" width="80"><b>原密码：</b></td>
              <td><input type="password" class="edit_box boxbor" id="oldPwd"></td>
              </tr>
              <tr>
              <td align="right"><b>新密码：</b></td>
              <td><input type="password" class="edit_box boxbor" id="newPwd1"></td>
              </tr>
              <tr>
              <td align="right"><b>确定密码：</b></td>
              <td><input type="password" class="edit_box boxbor" id="newPwd2"></td>
              </tr>
              <tr>
              <td>&nbsp;</td>
              <td><a href="javascript:void(0);" class="add_btn bg_blue" id="save_pwd">确定</a><a href="javascript:void(0);" class="add_btn bg_gray marl_20" id="clean">取消</a></td>
              </tr>
              </table>
         </div>
     </div>
</div>

<script src="${basePath}resources/js/md5.js"></script>
<script type="text/javascript" src="${basePath}resources/js/tmDialog.js"></script>
<script src="${basePath}resources/js/sys/password.js"></script>
</body>
</html>