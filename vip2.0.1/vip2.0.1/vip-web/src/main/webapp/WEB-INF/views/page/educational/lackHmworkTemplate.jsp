<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@include file="/WEB-INF/common/taglib.jsp" %>
</head>
<body>
	  <table width="100%" class="table_style">
          <tr>
          <th width="80">序号</th>
          <th><span class="color_red">*</span>学员编号</th>
          <th>学员班级</th>
          <th>学员姓名</th>
          <th>手机</th>
          <th>QQ</th>
          <th>缺交作业总次数</th>
          </tr>
          <c:if test="${fn:length(lackHmworkVOs) == 0}">
                  <tr><td colspan="7">暂无数据</td></tr>
          </c:if>
          <c:forEach var="lchw" items="${lackHmworkVOs}" varStatus="status">
          <tr>
          <td>${status.index+1}</td>
          <td>${lchw.professionCode}</td>
          <td>${lchw.claName}</td>
          <td>${lchw.name}</td>
          <td>${lchw.telephone}</td>
          <td>${lchw.qq}</td>
          <td>${lchw.lackNumber}</td>
          </tr>
          </c:forEach>
       </table>
</body>