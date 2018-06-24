<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 导入jquery核心类库 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<!-- 导入easyui类库 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/ext/portal.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/default.css">	
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui/ext/jquery.portal.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui/ext/jquery.cookie.js"></script>
<script
	src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"
	type="text/javascript"></script>
<script type="text/javascript">
	function doAdd(){
		//alert("增加...");
		$('#addStaffWindow').window("open");
	}
	
	function doView(){
		alert("查看...");
	}
	
	function doDelete(){
		// 获得被选中的对象们
		var selects = $('#grid').datagrid('getSelections');
		if(selects.length == 0){
			$.messager.alert('提示','您并没有选中任何数据','error');    
		}else{
			$.messager.confirm('删除提示','你真的要删除选中的这些项目？',function(r){    
			    if (r){    
		       		var arr = new Array();
					for(var i = 0; i < selects.length; i++){
						// selects[i]		这是获得json对象	而alert(selects[i])并不能够将它显示出来需要selects[i].name才行
						var id = selects[i].id;		// 获得选中的id
						arr.push(id);				// 将选中的id放置到数组中
					}
					var ids = arr.join(",");		// 将数组中的元素用逗号连接起来赋值给字符串
					// alert(ids);					// 结果将会类似于	asdf,asdf,asdf,asdf
					// 获得好要删除的id们之后就需要提交到服务器删除了，有ajax和原生提交的方式，ajax不会刷新页面，所以弃用
					location.href = "${pageContext.request.contextPath}/Staff_deleteBatch?ids=" + ids;		// Batch：批
			    }    
			});  
		}
	}
	
	function doRestore(){
		alert("将取派员还原...");
	}
	//工具栏
	var toolbar = [ {
		id : 'button-view',	
		text : '查询',
		iconCls : 'icon-search',
		handler : doView
	}, {
		id : 'button-add',
		text : '增加',
		iconCls : 'icon-add',
		handler : doAdd
	}, 
	/* alter+/没有提示...,到html标签里面去联想吧 */
	<shiro:hasPermission name="staff-delete">  
	{
		id : 'button-delete',
		text : '作废',
		iconCls : 'icon-cancel',
		handler : doDelete
	},
	</shiro:hasPermission>
	{
		id : 'button-save',
		text : '还原',
		iconCls : 'icon-save',
		handler : doRestore
	}];
	// 定义列
	var columns = [ [ {
		field : 'id',
		checkbox : true,
	},{
		field : 'name',
		title : '姓名',
		width : 120,
		align : 'center'
	}, {
		field : 'telephone',
		title : '手机号',
		width : 120,
		align : 'center'
	}, {
		field : 'haspda',
		title : '是否有PDA',
		width : 120,
		align : 'center',
		formatter : function(data,row, index){
			if(data=="1"){
				return "有";
			}else{
				return "无";
			}
		}
	}, {
		field : 'deltag',
		title : '是否作废',
		width : 120,
		align : 'center',
		formatter : function(data,row, index){
			if(data=="0"){
				return "正常使用"
			}else{
				return "已作废";
			}
		}
	}, {
		field : 'standard',
		title : '取派标准',
		width : 120,
		align : 'center'
	}, {
		field : 'station',
		title : '所谓单位',
		width : 200,
		align : 'center'
	} ] ];
	
	$(function(){
		// 先将body隐藏，再显示，不会出现页面刷新效果
		$("body").css({visibility:"visible"});
		// 取派员信息表格
		$('#grid').datagrid( {
			iconCls : 'icon-forward',
			fit : true,
			border : false,
			rownumbers : true,
			striped : true,
			pageList: [30,50,100],
			pagination : true,
			toolbar : toolbar,
			url : "${pageContext.request.contextPath}/Staff_queryStaff",
			idField : 'id',
			columns : columns,
			onDblClickRow : doDblClickRow
		});
		
		// 添加取派员窗口
		$('#addStaffWindow').window({
	        title: '添加取派员',
	        width: 400,
	        modal: true,// 遮罩效果
	        shadow: true,// 阴影效果
	        closed: true,// 是否关闭
	        height: 400,
	        resizable:false
	    });
		
		// 修改取派员窗口
		$('#editStaffWindow').window({
	        title: '修改取派员',
	        width: 400,
	        modal: true,// 遮罩效果
	        shadow: true,// 阴影效果
	        closed: true,// 是否关闭
	        height: 400,
	        resizable:false
	    });
		
	});

	function doDblClickRow(rowIndex, rowData){
		//alert(rowData.haspda)
		// 打开id为editStaffWindow的窗口
		$("#editStaffWindow").window("open");
		// 装载数据
		$("#editStaffWindow").form("load",rowData)
		
		if(rowData.haspda == 1){
			$("#editStaffWindow input[type=checkbox]").attr("checked",true);
		}
	}
</script>	
</head>
<body class="easyui-layout" style="visibility:hidden;">
	<div region="center" border="false">
    	<table id="grid"></table>
	</div>
	<div class="easyui-window" title="对收派员进行添加或者修改" id="addStaffWindow" collapsible="false" minimizable="false" maximizable="false" style="top:20px;left:200px">
		<div region="north" style="height:31px;overflow:hidden;" split="false" border="false" >
			<div class="datagrid-toolbar">
				<a id="save" icon="icon-save" href="#" class="easyui-linkbutton" plain="true" >保存</a>
			</div>
		</div>
		<div region="center" style="overflow:auto;padding:5px;" border="false">
			<form id="addStaffForm" action="${pageContext.request.contextPath}/Staff_saveStaff" method="post">
				<table class="table-edit" width="80%" align="center">
					<tr class="title">
						<td colspan="2">收派员信息</td>
					</tr>
					<!-- TODO 这里完善收派员添加 table -->
					<tr><!-- 			不要取派员编号了，用uuid，在staff.hbm.xml文件里面把主键规则变换成为uuid
						<td>取派员编号</td>
						<td><input type="text" name="id" class="easyui-validatebox" required="true"/></td> -->
					</tr>
					<tr>
						<td>姓名</td>
						<td><input type="text" name="name" class="easyui-validatebox" required="true"/></td>
					</tr>
					<tr>
						<td>手机</td>			<!-- 添加手机验证，采用easyUi的自定义验证框 -->
						<td><input id="telephone"  validType='telNum' type="text" name="telephone" class="easyui-validatebox" required="true"/></td>
						<script type="text/javascript">
							$(function() {
								// 添加手机号码验证								
								$.extend($.fn.validatebox.defaults.rules, {
									telNum : { //既验证手机号，又验证座机号  
										validator : function(value, param) {
											return /(^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$)|(^((\d3)|(\d{3}\-))?(1[358]\d{9})$)/.test(value);
										},
										message : '请输入正确的电话号码。'
									}
								});
								
								// 为添加取派员的那个保存按钮实现提交
								$("#save").click(function(){
									var isValid = $("#addStaffForm").form("validate");
									// var isValid = $("#addStaffForm").form("validate");    也可以
									if (isValid){ // 如果验证成功就提交，否则按了没有反应  
										$("#addStaffForm").submit();
									}
								});
						
							})
						</script>
					</tr>
					<tr>
						<td>单位</td>
						<td><input type="text" name="station" class="easyui-validatebox" required="true"/></td>
					</tr>
					<tr>
						<td colspan="2">
						<input type="checkbox" name="haspda" />
						是否有PDA</td>
					</tr>
					<tr>
						<td>取派标准</td>
						<td>
							<input type="text" name="standard" class="easyui-validatebox" required="true"/>  
						</td>
					</tr>
					</table>
			</form>
		</div>
	</div>


<!-- 修改取派员信息的窗口 -->
	<div class="easyui-window" title="对收派员进行添加或者修改" id="editStaffWindow" collapsible="false" minimizable="false" maximizable="false" style="top:20px;left:200px">
		<div region="north" style="height:31px;overflow:hidden;" split="false" border="false" >
			<div class="datagrid-toolbar">
				<a id="edit" icon="icon-edit" href="#" class="easyui-linkbutton" plain="true" >保存</a>
			</div>
		</div>
		
		<div region="center" style="overflow:auto;padding:5px;" border="false">
			<form id="editStaffForm" action="${pageContext.request.contextPath}/Staff_editStaff" method="post">
										
							<!-- 还有一个id -->
							<input type="hidden" name="id"/>
				<table class="table-edit" width="80%" align="center">
					<tr class="title">
						<td colspan="2">收派员信息</td>
					</tr>
					<!-- TODO 这里完善收派员添加 table -->
					<tr><!-- 			不要取派员编号了，用uuid，在staff.hbm.xml文件里面把主键规则变换成为uuid
						<td>取派员编号</td>
						<td><input type="text" name="id" class="easyui-validatebox" required="true"/></td> -->
					</tr>
					<tr>
						<td>姓名</td>
						<td><input type="text" name="name" class="easyui-validatebox" required="true"/></td>
					</tr>
					<tr>
						<td>手机</td>			<!-- 添加手机验证，采用easyUi的自定义验证框 -->
						<td><input id="telephone"  validType='telNum' type="text" name="telephone" class="easyui-validatebox" required="true"/></td>
						<script type="text/javascript">
							$(function() {
								// 添加手机号码验证								
								$.extend($.fn.validatebox.defaults.rules, {
									telNum : { //既验证手机号，又验证座机号  
										validator : function(value, param) {
											return /(^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$)|(^((\d3)|(\d{3}\-))?(1[358]\d{9})$)/.test(value);
										},
										message : '请输入正确的电话号码。'
									}
								});
								
								// 为添加取派员的那个保存按钮实现提交
								$("#edit").click(function(){
									var isValid = $("#editStaffForm").form("validate");
									// var isValid = $("#editStaffForm").form("validate");    也可以
									if (isValid){ // 如果验证成功就提交，否则按了没有反应  
										$("#editStaffForm").submit();
									}
								});
						
							})
						</script>
					</tr>
					<tr>
						<td>单位</td>
						<td><input type="text" name="station" class="easyui-validatebox" required="true"/></td>
					</tr>
					<tr>
						<td colspan="2">
						<input type="checkbox" name="haspda" />
						是否有PDA</td>
					</tr>
					<tr>
						<td>取派标准</td>
						<td>
							<input type="text" name="standard" class="easyui-validatebox" required="true"/>  
						</td>
					</tr>
					</table>
			</form>
		</div>
	</div>


</body>
</html>	