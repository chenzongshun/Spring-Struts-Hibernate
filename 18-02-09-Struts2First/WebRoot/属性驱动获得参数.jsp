<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>属性驱动获得参数</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/getpra">
			<!-- 代表我要提交到user对象的age属性 -->
			用户名：<input type="text" name = "user.name"><br>
			年龄：		<input type="text" name = "user.age"><br>
			生日：		<input type="text" name = "user.birthday"><br>
			<input type="submit" value="提交">
	</form>
</body>
</html>
