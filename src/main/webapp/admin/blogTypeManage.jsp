<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <title>博客类别管理</title>
    <%@include file="common/head.jspf" %>
</head>
<script>
	var url;

    $(function () {
        //datagrid初始化
        $('#dg').datagrid({
            //请求数据的url
            url: '/blog/listPage',
            //载入提示信息
            loadMsg: 'loading...',
            //水平自动展开，如果设置此属性，则不会有水平滚动条，演示冻结列时，该参数不要设置
            fitColumns: true,
            //数据多的时候不换行
            nowrap: true,
            //设置分页
            pagination: true,
            //设置每页显示的记录数，默认是10个
            pageSize: 5,
            //每页显示记录数项目
            pageList: [5, 10, 15, 20],
            //指定id为标识字段，在删除，更新的时候有用，如果配置此字段，在翻页时，换页不会影响选中的项
            idField: 'id',
            //上方工具条 添加 修改 删除 刷新按钮
            toolbar:[{
                iconCls: 'icon-add',    //图标
                text: '添加',            //名称
                handler: function () {  //回调函数
                	$("#dlg").dialog("open").dialog("setTitle", "添加博客类型");
                	url = "/blog/saveBlogType";
                }
            },'-',{
                iconCls: 'icon-edit',
                text: '修改',
                handler: function () {
                	var selectRows = $("#dg").datagrid("getSelections");
                	
                	if (selectRows.length != 1) {
                		$.messager.alert("系统提示", "请选择一个要修改的博客类别");
                		return;
                	}
                	
                	var row = selectRows[0];
                	$("#dlg").dialog("open").dialog("setTitle", "修改博客类型");
                	$("#fm").form("load", row);
                	url = "/blog/saveBlogType?id=" + row.id;
                }
            },'-',{
                iconCls: 'icon-edit',
                text: '删除',
                handler: function () {
                	var selectRows = $("#dg").datagrid("getSelections");
                	
                	if (selectRows.length == 0) {
                		$.messager.alert("系统提示", "请选择至少一个博客类型");
                		return;
                	}
                	
                	var ids = []
                	for (var i = 0; i < selectRows.length; i ++)
                		ids.push(selectRows[i].id);
                	var idsStr = ids.join(",");
                	
                	$.messager.confirm("系统提示", "<font color=red>你确定要删除选中的"+selectRows.length+"条数据吗？</font>",
                			function(r) {
								if (r) {
									$.post("/blog/deleteBlogType",
											{idsStr: idsStr}, function(result) {
												if (result.exist) {
													$.messager.alert("系统提示", "删除失败，该博客类别下有博客");
												}
												else if (result.success) {
													$.messager.alert("系统提示", "删除成功");
													$('#dg').datagrid('clearSelections');
													$("#dg").datagrid("reload");
												}
												else {
													$.messager.alert("系统提示", "删除失败");
												}
											}, "json");
								}
							})
                }
            
            },'-',{
                iconCls: 'icon-reload',
                text: '刷新',
                handler: function () {
					$("#dg").datagrid("reload");
                }
            }],
            //同列属性，但是这些列将会冻结在左侧,z大小不会改变，当宽度大于250时，会显示滚动条，但是冻结的列不在滚动条内
            frozenColumns:[[
                {field:'checkbox',checkbox:true},    //复选框
                {field:'id',title:'编号',width:200}    //id字段
            ]],
            columns:[[
                {field:'typeName',title:'博客分类名称',width:300},   //typeName 字段
                {field:'orderNum',title:'博客类别排序',width:300},   //orderNum 字段
            ]],
        });
    });
    
    function saveBlogType() {
    	$("#fm").form("submit", {
    		url: url,
    		onSubmit: function () {
				return $(this).form("validate");
			},
			success: function (result) {
				 var result = eval("(" + result + ")"); //将json格式的result转换成js对象
				 if (result.success) {
					$.messager.alert("系统提示", "博客类别保存成功");
					$("typeName").val("");
					$("orderNum").val("");
					$("#dlg").dialog("close");
					$("#dg").datagrid("reload");
				}
				 else {
					$.messager.alert("系统提示", "博客类别保存失败");
					 return;
				 }
			}
    	});
    }
    
    function closeBlogTypeDialog() {
		$("typeName").val("");
		$("orderNum").val("");
		$("#dlg").dialog("close");
	}
</script>
<body>
<table id="dg"></table>

<div id="dlg" class="easyui-dialog" style="width:500px; height:180px; padding:10px 20px"
     closed="true" buttons="#dlg-buttons">
    <form id="fm" method="post">
        <table cellspacing="8px">
            <tr>
                <td>博客类别名称</td>
                <td>
                    <input type="text" id="typeName" name="typeName" class="easyui-validatebox" required="true">
                </td>
            </tr>
            <tr>
                <td>博客类别排序</td>
                <td>
                    <input type="text" id="orderNum" name="orderNum" class="easyui-numberbox" required="true"
                           style="width:60px">&nbsp;(博客类别会根据序号从小到大排列)
                </td>
            </tr>
        </table>
    </form>
</div>

<div id="dlg-buttons">
    <div>
        <a href="javascript:saveBlogType()" class="easyui-linkbutton" iconCls="icon-ok" plain="true">保存</a>
        <a href="javascript:closeBlogTypeDialog()" class="easyui-linkbutton" iconCls="icon-cancel" plain="true">关闭</a>
    </div>
</div>
</body>
</html>