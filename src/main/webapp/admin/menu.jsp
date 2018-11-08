<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人博客后台管理</title>
    <%@include file="common/head.jspf" %>
    <style type="text/css">
        body {
            font-family: microsoft yahei;
        }
    </style>
</head>

<script type="text/javascript">
       /**
         * 打开选项卡
         * @param text  选项卡标题
         * @param url   请求打开路径
         * @param icon  选项卡图标
         */
        function openTab(text,url, val) {
            //判断当前选项卡是否存在
            if($('#tabs').tabs('exists',text)){
                //如果存在 显示
                $("#tabs").tabs("select",text);
            }else{
                //如果不存在 则新建一个
                
                if (val == 0) {
	                $("#tabs").tabs('add',{
	                    title:text,
	                    width: $("#tt").parent().width(),  
	                    height: "auto" ,
	                    closable:true,      //是否允许选项卡摺叠。
	/*                     iconCls:icon,    //显示图标 */
	                    content:"<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='admin/"+url+"'></iframe>"
	                    //url 远程加载所打开的url
	                })
                	
                } 
                else {
	                $("#tabs").tabs('add',{
	                    title:text,
	                    width: $("#tt").parent().width(),  
	                    height: "auto" ,
	                    closable:true,      //是否允许选项卡摺叠。
	/*                     iconCls:icon,    //显示图标 */
	                    content:"<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='${pageContext.request.contextPath}/"+url+"'></iframe>"
	                    //url 远程加载所打开的url
	                })
                }
            }
        }

</script>

<body class="easyui-layout">
<div region="north" style="height: 78px; background-color: #E0ECFF">  
	<table style="padding: 5px" width="100%">
        <tr>
            <td width="50%">
                <h2>博客后台系统</h2>
            </td>
            <td valign="bottom" align="right" width="50%">
                <font size="3">&nbsp;&nbsp;<strong>欢迎：</strong>FlyQi</font>
            </td>
        </tr>
    </table>

</div>
<div region="west" style="width: 200px" title="导航菜单" split="true">   
<!-- 	<div id="aa" class="easyui-accordion" style="width:300px;height:200px;">  
	    <div title="Title1" data-options="iconCls:'icon-save'" style="overflow:auto;padding:10px;">  
	        <h3 style="color:#0099FF;">Accordion for jQuery</h3>  
	        <p>Accordion is a part of easyui framework for jQuery.    
	        It lets you define your accordion component on web page more easily.</p>  
	    </div>  
	    <div title="Title2" data-options="iconCls:'icon-reload',selected:true" style="padding:10px;">  
	        content2   
	    </div>  
	    <div title="Title3">  
	        content3   
	    </div>  
	</div>  
 -->
 <div class="easyui-accordion" data-options="fit:true,border:false">
        <div title="常用操作" data-options="selected:true,iconCls:'icon-item'" style="padding: 10px">
            <a href="javascript:openTab('写博客', 'writeBlogOfGetAllBlogType', 1)" class="easyui-linkbutton"
               data-options="plain:true,iconCls:'icon-writeblog'" style="width: 150px">写博客</a>
            <a href="#" class="easyui-linkbutton"
               data-options="plain:true,iconCls:'icon-review'" style="width: 150px">评论审核</a>
        </div>
        <div title="博客管理" data-options="iconCls:'icon-bkgl'" style="padding:10px;">
            <a href="javascript:openTab('写博客', 'writeBlogOfGetAllBlogType', 1)" class="easyui-linkbutton"
               data-options="plain:true,iconCls:'icon-writeblog'" style="width: 150px;">写博客</a>
            <a href="javascript:openTab('博客管理', 'blogManage.jsp', 0)" class="easyui-linkbutton"
               data-options="plain:true,iconCls:'icon-bkgl'" style="width: 150px;">博客信息管理</a>
        </div>
        
        <div title="分类标签管理" data-options="iconCls:'icon-bklb'" style="padding:10px">
            <a href="javascript:openTab('博客分类管理', 'blogTypeManage.jsp', 0)" class="easyui-linkbutton"
               data-options="plain:true,iconCls:'icon-bklb'" style="width: 150px;">博客分类信息管理</a>
            <a href="javascript:openTab('博客标签管理', 'blogTagsManage.jsp', 0)" class="easyui-linkbutton"
               data-options="plain:true,iconCls:'icon-bklb'" style="width: 150px;">博客标签信息管理</a>
        </div>
        <div title="评论管理" data-options="iconCls:'icon-plgl'" style="padding:10px">
            <a href="#" class="easyui-linkbutton"
               data-options="plain:true,iconCls:'icon-review'" style="width: 150px">评论审核</a>
            <a href="#" class="easyui-linkbutton"
               data-options="plain:true,iconCls:'icon-plgl'" style="width: 150px;">评论信息管理</a>
        </div>
        <div title="个人信息管理" data-options="iconCls:'icon-grxx'" style="padding:10px">
            <a href="#" class="easyui-linkbutton"
               data-options="plain:true,iconCls:'icon-grxxxg'" style="width: 150px;">修改个人信息</a>
        </div>
        <div title="系统管理" data-options="iconCls:'icon-system'" style="padding:10px">
            <a href="#" class="easyui-linkbutton"
               data-options="plain:true,iconCls:'icon-link'" style="width: 150px">友情链接管理</a>
            <a href="#" class="easyui-linkbutton"
               data-options="plain:true,iconCls:'icon-modifyPassword'" style="width: 150px;">修改密码</a>
            <a href="#" class="easyui-linkbutton"
               data-options="plain:true,iconCls:'icon-refresh'" style="width: 150px;">刷新系统缓存</a>
            <a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-exit'"
               style="width: 150px;">安全退出</a>
        </div>
    </div>
 </div>
<div data-options="region:'center'" style="background:#eee;">  
<!-- 	<div id="tt" class="easyui-tabs" style="width:500px;height:250px;">  
	    <div title="Tab1" style="padding:20px;display:none;">  
	        tab1   
	    </div>  
	    <div title="Tab2" data-options="closable:true" style="overflow:auto;padding:20px;display:none;">  
	        tab2   
	    </div>  
	    <div title="Tab3" data-options="iconCls:'icon-reload',closable:true" style="padding:20px;display:none;">  
	        tab3   
	    </div>  
	</div>
 -->
    <div class="easyui-tabs" fit="true" border="false" id="tabs">
        <div title="首页" data-options="iconCls:'icon-home'">
            <div align="center" style="padding-top: 100px"><font color="red" size="10">欢迎使用</font></div>
        </div>
    </div>
</div>
 
<div region="south" style="height: 25px;padding: 5px" align="center">  
    Copyright © 2018-2022 FlyQi的SSM博客系统 版权所有
</div>

</body>
</html>