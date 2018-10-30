<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title> 博客管理 </title>
    <%@include file="common/head.jspf" %>   
  </head>
  <body>
  	<script type="text/javascript">
  		function formatBloyType(val, row, index) {
			return val.typeName;
		}
  		
  		function reloadBlogType() {
			$("#tt").datagrid("reload");
		}
  		
  		function removeBlogType() {
			var selectRows = $("#tt").datagrid("getSelections");
			
			if (selectRows.length == 0) {
				$.messager.alert("系统提示", "请选择至少一行数据");
				return ;
			}
			
			var ids = [];
			for (var i = 0; i < selectRows.length; i ++)
				ids.push(selectRows[i].id);
			var idsStr = ids.join(",");
			
			$.messager.confirm("Confirm", "<font color=red>你确定删除这"+selectRows.length+"行数据吗 ？</font>", function(r) {
				if (r) {
					$.post("/blog/delBlog", {idsStr: idsStr}, function(result) {
						if (result.success) {
							$.messager.alert("系统提示", "数据删除成功 ！");
							$("#tt").datagrid("reload");
						}
						else {
							$.messager.alert("系统提示", "数据删除失败！");
						}
					}, "json")
				}
			})
		}
  		
        
  		function updateBlog() {
  			
			var selectRows = $("#tt").datagrid("getSelections");
			
			if (selectRows.length != 1) {
				$.messager.alert("系统提示", "请选择一条数据");
				return ;
			}
			
  			var text="修改博客";
		    var url="/blog/updateBlog?id="+selectRows[0].id;
            //判断当前选项卡是否存在
            var parent$ = self.parent.$;
            if(parent$('#tabs').tabs('exists',text)){
                //如果存在 显示
                parent$("#tabs").tabs("select",text);
            }else{
                //如果不存在 则新建一个
                
                parent$("#tabs").tabs('add',{
                    title:text,
                    closable:true,      //是否允许选项卡摺叠。
/*                     iconCls:icon,    //显示图标 */
                    content:"<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='"+url+"'></iframe>"
                    //url 远程加载所打开的url
                })
            }
			
/* 		    var xmlhttp=new XMLHttpRequest();
		    var url="/blog/updateBlog?id="+selectRows[0].id;
		    xmlhttp.open("GET",url,true); //第三个参数是同步异步,主线程只能异步
		    //xmlhttp.onreadystatechange=favorOK;//发送事件后，收到信息了调用函数 
		    xmlhttp.send(); 
 */  		
 		}
  		
  		function searchBlogByTitle() {
			$("#tt").datagrid("load", {
				"title":$("#s_title").val()
			});
		}
  	</script>
  
  	
  
  	<table id="tt" class="easyui-datagrid" fitColumns="true" pagination="true"
            url="/blog/listBlogPage" title="博客管理" toolbar="#tb">
        <thead>
            <tr>
                <th field="cb" checkbox="true" align="center"></th>
                <th field="id" width="20">编号</th>
                <th field="title" width="200" >标题</th>
                <th field="releaseDate" width="100" align="center">发布日期</th>
                <th data-options="field:'blogType',width:100,align:'center',formatter:formatBloyType">博客类型</th>
<!--                 <th field="blogType" width="100" align="center" formatter="formatBlogType">博客类型</th> -->
            </tr>
        </thead>
    </table>
    
    <div id="tb">
                    标题：<input id="s_title" style="width:100px"type="text">
        <a href="javascript:searchBlogByTitle()" class="easyui-linkbutton" iconCls="icon-search">Search</a>
        <a href="javascript:updateBlog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
        <a href="javascript:removeBlogType()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
        <a href="javascript:reloadBlogType()" class="easyui-linkbutton" iconCls="icon-reload" plain="true">刷新</a>
    </div>

  </body>
</html>