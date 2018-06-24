<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理分区</title>
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

<script
	src="${pageContext.request.contextPath }/js/highcharts/highcharts.js"></script>
<script
	src="${pageContext.request.contextPath }/js/highcharts/modules/exporting.js"></script>


<script type="text/javascript">
	function doAdd() {
		$('#addSubareaWindow').window("open");
	}

	function doEdit() {
		alert("修改...");
	}

	function doDelete() {
		alert("删除...");
	}

	function doSearch() {
		$('#searchWindow').window("open");
	}

	// 点击导出按钮，导出成excel格式的文件
	function doExport() {
		// 为什么不用异步呢？		原因是，用异步并不能够让浏览器弹出弹出窗口
		window.location.href = "${pageContext.request.contextPath}/subarea_exportXls";
	}

	function doImport() {
		alert("导入");
	}

	//工具栏
	var toolbar = [ {
		id : 'button-search',
		text : '查询',
		iconCls : 'icon-search',
		handler : doSearch
	}, {
		id : 'button-add',
		text : '增加',
		iconCls : 'icon-add',
		handler : doAdd
	}, {
		id : 'button-edit',
		text : '修改',
		iconCls : 'icon-edit',
		handler : doEdit
	}, {
		id : 'button-delete',
		text : '删除',
		iconCls : 'icon-cancel',
		handler : doDelete
	}, {
		id : 'button-import',
		text : '导入',
		iconCls : 'icon-redo',
		handler : doImport
	}, {
		id : 'button-export',
		text : '导出',
		iconCls : 'icon-undo',
		handler : doExport
	}, {
		id : 'button-export',
		text : '查看饼状图',
		iconCls : 'icon-search',
		handler : searchBin
	} ];



	// 定义列
	var columns = [ [ {
		field : 'id',
		checkbox : true
	}, {
		field : 'showid',
		title : '分拣编号',
		width : 120,
		align : 'center',
		formatter : function(data, row, index) {
			return row.id;
		}
	}, {
		field : 'province',
		title : '省',
		width : 120,
		align : 'center',
		formatter : function(data, row, index) {
			return row.bcRegion.province;
		/* 			return row.region.province; */
		}
	}, {
		field : 'city',
		title : '市',
		width : 120,
		align : 'center',
		formatter : function(data, row, index) {
			return row.bcRegion.city;
		}
	}, {
		field : 'district',
		title : '区',
		width : 120,
		align : 'center',
		formatter : function(data, row, index) {
			return row.bcRegion.district;
		}
	}, {
		field : 'addresskey',
		title : '关键字',
		width : 120,
		align : 'center'
	}, {
		field : 'startnum',
		title : '起始号',
		width : 100,
		align : 'center'
	}, {
		field : 'endnum',
		title : '终止号',
		width : 100,
		align : 'center'
	}, {
		field : 'single',
		title : '单双号',
		width : 100,
		align : 'center'
	}, {
		field : 'position',
		title : '位置',
		width : 200,
		align : 'center'
	} ] ];

	$(function() {
		// 先将body隐藏，再显示，不会出现页面刷新效果

		$("body").css({
			visibility : "visible"
		});

		// 收派标准数据表格
		$('#grid').datagrid({
			iconCls : 'icon-forward',
			fit : true,
			border : true,
			rownumbers : true,
			striped : true,
			pageList : [ 30, 50, 100 ],
			pagination : true,
			toolbar : toolbar,
			url : "${pageContext.request.contextPath}/subarea_pageQuery",
			idField : 'id',
			columns : columns,
			onDblClickRow : doDblClickRow
		});

		// 添加、修改分区
		$('#addSubareaWindow').window({
			title : '添加修改分区',
			width : 600,
			modal : true,
			shadow : true,
			closed : true,
			height : 400,
			resizable : false
		});

		// 查看饼状图的window初始化
		$('#searchBinWindow').window({
			title : '查看饼状图',
			width : 600,
			modal : true,
			shadow : true,
			closed : true,
			height : 450,
			resizable : false
		});

		// 查询分区
		$('#searchWindow').window({
			title : '查询分区',
			width : 400,
			modal : true,
			shadow : true,
			closed : true,
			height : 400,
			resizable : false
		});

		/**
		 *	将Form对象转换成为json对象，使用方式	var fo = $("#searchForm").serializeJson();	console.info(fo);
		 */
		$.fn.serializeJson = function() {
			var serializeObj = {};
			var array = this.serializeArray();
			$(array).each(function() {
				if (serializeObj[this.name]) {
					if ($.isArray(serializeObj[this.name])) {
						serializeObj[this.name].push(this.value);
					} else {
						serializeObj[this.name] = [ serializeObj[this.name], this.value ];
					}
				} else {
					serializeObj[this.name] = this.value;
				}
			});
			return serializeObj;
		};

		// 点击查询窗口里面的查询按钮
		$("#btn").click(function() {
			var j = $("#searchForm").serializeJson(); // 将查询窗口的表单对相关给转成json格式
			$('#grid').datagrid('load', j); // 重新装载数据
			$("#searchWindow").window("close"); // 记得关闭查询窗口
		});

	});

	function doDblClickRow() {
		alert("双击表格数据...");
	}

	// 用来查看饼状图
	function searchBin() {
		$("#searchBinWindow").window("open");

		$.post('subarea_bing', function(data) {
			$('#container').highcharts({
				chart : {
					plotBackgroundColor : null,
					plotBorderWidth : null,
					plotShadow : false
				},
				title : {
					text : '区域占比饼状图'
				},
				tooltip : {
					headerFormat : '{series.name}<br>',
					pointFormat : '{point.name}: <b>{point.percentage:.1f}%</b>'
				},
				plotOptions : {
					pie : {
						allowPointSelect : true,
						cursor : 'pointer',
						dataLabels : {
							enabled : true,
							format : '<b>{point.name}</b>: {point.percentage:.1f} %',
							style : {
								color : (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
							}
						}
					}
				},
				series : [ {
					type : 'pie',
					name : '浏览器访问量占比',
					data /* 				静态数据是下面这样子的
				data : [
						[ 'Firefox', 45.0 ],
						[ 'IE', 26.8 ],
						[ 'Safari', 8.5 ],
						[ 'Opera', 6.2 ],
						[ '其他', 0.7 ]
					] */
				} ]
			});
		});
	}
</script>
</head>
<body class="easyui-layout" style="visibility:hidden;">
	<div region="center" border="false">
		<table id="grid"></table>
	</div>
	<!-- 添加 修改分区 -->
	<div class="easyui-window" title="分区添加修改" id="addSubareaWindow"
		collapsible="false" minimizable="false" maximizable="false"
		style="top:20px;left:200px">
		<div style="height:31px;overflow:hidden;" split="false" border="false">
			<div class="datagrid-toolbar">
				<a id="save" icon="icon-save" href="#" class="easyui-linkbutton"
					plain="true">保存</a>
				<script type="text/javascript">
					$(function() {
						$("#save").click(function() {
							if ($("#subareaForm").form('validate')) {
								var form = $("#subareaForm").get(0);
								form.action = "${pageContext.request.contextPath}/subarea_saveSubarea";
								form.submit();
							}
						})
					})
				</script>
			</div>
		</div>

		<div style="overflow:auto;padding:5px;" border="false">
			<form id='subareaForm' method="post">
				<table class="table-edit" width="80%" align="center">
					<tr class="title">
						<td colspan="2">分区信息</td>
					</tr>
					<!-- 					<tr>			hbm.xml中uuid了
						<td>分拣编码</td>
						<td><input type="text" name="id" class="easyui-validatebox" required="true"/></td>
					</tr> -->
					<tr>
						<td>选择区域</td>
						<td>
							<!-- 
							由于区域太大，所以将区域里面分成多个区，那么每个分区自然就会属于某个区域
							所以在BcSubarea区域类中有个区域类，属性名就叫bcRegion
							当时到我手里的时候其实是name="region.id"，因为我使用myeclipse的反转引擎没法去掉数据库表名前缀......
							mode:'remote',这个属性默认为local
									在combox中输入内容自动从option中筛选，remote就带着一个q参数去访问服务器
							valueField：就相当于option中的value，真正提交的是value，而不是被option包裹着的内容
							textField：就相当于被option包裹着的文本 --> <input class="easyui-combobox"
							name="bcRegion.id"
							data-options="valueField:'id',
    											textField:'name',
    											mode:'remote',
    											url:'{pageContext.request.contextPath}/region_listRegionShort'" />
						</td>
					</tr>
					<tr>
						<td>关键字</td>
						<td><input type="text" name="addresskey"
							class="easyui-validatebox" required="true" /></td>
					</tr>
					<tr>
						<td>起始号</td>
						<td><input type="text" name="startnum"
							class="easyui-validatebox" required="true" /></td>
					</tr>
					<tr>
						<td>终止号</td>
						<td><input type="text" name="endnum"
							class="easyui-validatebox" required="true" /></td>
					</tr>
					<tr>
						<td>单双号</td>
						<td><select class="easyui-combobox" name="single"
							style="width:150px;">
								<option value="0">单双号</option>
								<option value="1">单号</option>
								<option value="2">双号</option>
						</select></td>
					</tr>
					<tr>
						<td>位置信息</td>
						<td><input type="text" name="position"
							class="easyui-validatebox" required="true" style="width:250px;" /></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<!-- 查询分区 -->
	<div class="easyui-window" title="查询分区窗口" id="searchWindow"
		collapsible="false" minimizable="false" maximizable="false"
		style="top:20px;left:200px">
		<div style="overflow:auto;padding:5px;" border="false">
			<form id="searchForm" method="post">
				<table class="table-edit" width="80%" align="center">
					<tr class="title">
						<td colspan="2">查询条件</td>
					</tr>
					<tr>
						<td>省</td>
						<td><input type="text" name="bcRegion.province" /></td>
					</tr>
					<tr>
						<td>市</td>
						<td><input type="text" name="bcRegion.city" /></td>
					</tr>
					<tr>
						<td>区（县）</td>
						<td><input type="text" name="bcRegion.district" /></td>
					</tr>
					<tr>
						<td>关键字</td>
						<td><input type="text" name="addresskey" /></td>
					</tr>
					<tr>
						<td colspan="2"><a id="btn" href="#"
							class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>

	<!-- 查看饼状图的window -->
	<div class="easyui-window" title="分区添加修改" id="searchBinWindow"
		collapsible="false" minimizable="false" maximizable="false"
		style="top:20px;left:200px">
		<div id="container" style="min-width:400px;height:400px"></div>
	</div>

</body>
</html>