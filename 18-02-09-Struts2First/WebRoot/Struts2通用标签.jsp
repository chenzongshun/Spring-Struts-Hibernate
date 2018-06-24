<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Struts2通用标签</title>
</head>
<body>
	<!-- 遍历标签iterator -->
	<s:iterator value="#list">
		<s:property />
	</s:iterator><hr>
	
	<!-- 遍历标签iterator加var属性 -->
	<s:iterator value="#list" var = "name">
		<s:property value = "#name"/>
	</s:iterator><hr>
	
	<!-- 遍历标签iterator也能数数 -->
	<s:iterator  begin="1" end="50" step="1">
		<s:property/>
	</s:iterator><hr>
	
	<!-- if  else else if  -->
	<s:if test="#list.size() == 4">
		list长度为4
	</s:if>
	<s:elseif test="#list.size() == 3">
		list长度为3	
	</s:elseif>
	<s:else>
		list不三不四	
	</s:else><br>
	
	<!-- property配合OGNL表达式取值 -->
	<s:property value="#list.size()"/>
	<s:property value="#session.user.name"/><!-- 假设取用户名 --><br>
	
	
	
	
</body>
</html>