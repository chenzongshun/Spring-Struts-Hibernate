<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>struts2参数获得方式</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/getpraList" method="post">
			List：<input type="text" name = "list"><br>
			List：<input type="text" name = "list[1]"><br><!-- 就跟数组一样，提交第二个 -->
			List：<input type="text" name = "list[3]"><br><!-- 还可以跳着玩... -->
			Map：<input type="text" name = "map['shunkey']"><br><!-- 注意要手动设置键 -->
			<input type="submit" value="提交">
	</form>
</body>
</html>
