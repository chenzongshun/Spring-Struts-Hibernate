<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>03-tabs选项卡</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>

</head>
<body class="easyui-layout">
	<!-- 使用div元素描述每个区域 -->
	<div title="XXX管理系统" style="height: 100px" data-options="region:'north'">北部区域</div>
	<div title="系统菜单" style="width: 200px" data-options="region:'west'">
		<!-- 制作accordion折叠面板 
			fit:true----自适应(填充父容器)
		-->
		<div class="easyui-accordion" data-options="fit:true">
			<!-- 使用子div表示每个面板 -->
			<div data-options="iconCls:'icon-cut'" title="面板一">
				<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" id="btnAddTab">Add</a>
				<script>
					$(function(){
						// 页面加载完成后为上面的按钮绑定一个单击事件
						$("#btnAddTab").click(function(){
							// 判断"系统管理"这个选项卡是否已经存在
							var e = $("#mytabs").tabs("exists","系统管理");
							if(e){	// 如果存在就让选项卡获得焦点就好了
								$("#mytabs").tabs("select","系统管理");
							}else{  // 调用tabs对象的add方法动态的添加一个选项卡
								$("#mytabs").tabs("add",{
									title: "系统管理",/* 标题 */
									iconCls: "icon-edit",/* 图标 */
									closable: "true",/* 是否显示关闭 */
									content: '<iframe frameborder="0" height="100%" width="100%" src="https://www.baidu.com"/>'/* 显示内容 */
								});
							}
						})
					})
				</script>
			</div>
			<div title="面板二">2222</div>
			<div title="面板三">3333</div>
		</div>
	</div>
	<div data-options="region:'center'">
		<!-- 制作一个tabs选项卡面板 -->
		<div class="easyui-tabs" data-options="fit:true" id="mytabs">
			<!-- 使用子div表示每个面板 -->
			<div data-options="iconCls:'icon-cut'" title="面板一">1111</div>
			<div data-options="closable:true" title="面板二">2222</div>
			<div title="面板三">3333</div>
		</div>
	</div>
	<div style="width: 100px" data-options="region:'east'">东部区域</div>
	<div style="height: 50px" data-options="region:'south'">南部区域</div>
</body>
</html>