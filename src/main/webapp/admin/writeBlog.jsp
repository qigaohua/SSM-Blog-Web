<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<!-- isELIgnored="false" 这个要加上，否则 c:forEach取不到值-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title> 编写博客 </title>
    <%@include file="common/head.jspf" %>   
    <script type="text/javascript" charset="utf-8"
    				src="${pageContext.request.contextPath}/static/UEditor_1433/ueditor.config.js"></script>
	<script type="text/javascript" charset="utf-8"
    				src="${pageContext.request.contextPath}/static/UEditor_1433/ueditor.all.min.js"></script>
    <script type="text/javascript" charset="utf-8"
    				src="${pageContext.request.contextPath}/static/UEditor_1433/ueditor.all.js"></script>
    				
	<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
	<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
	<script type="text/javascript" charset="utf-8"
	    			src="${pageContext.request.contextPath}/static/UEditor_1433/lang/zh-cn/zh-cn.js"></script>
	    			
    <!-- 实例化编辑器 -->
    <script type="text/javascript">
        var ue = UE.getEditor('editor');
    </script>
    <script type="text/javascript">
        /**
         * 发布博客
          */
        function submitData() {
            var blogid = $("#blogid").val();
            if (blogid > 0) {
            	var successMsg="博客修改成功 !";
            	var failedMsg = "博客修改失败 !";
            } 
            else {
            	var successMsg="博客发布成功 !"
            	var failedMsg = "博客发布失败 !";
            }
            //获取博客标题
            var title = $("#title").val();
            //获取博客类别id
            var blogTypeId = $("#blogTypeId").combobox("getValue");
            //获取博客内容 带标记
            var content = UE.getEditor('editor').getContent();
            //截取博客前155字符 作为博客简介
            var summary = UE.getEditor('editor').getContentTxt().substr(0, 155);
            //博客关键词
           /* var keyWord = $("#keyWord").val();  */
            /* var checkedNum = $("input[name='tags']:checked").length; */
            // 博客标签
           	var tags = $.makeArray($("input[name='tags']:checked"));
           	var tagsArray = []
           	for (var i in tags)
           		tagsArray.push(tags[i].value);
           	var tagsStr = tagsArray.join(",");
            //获取博客内容  不带标签 纯文本
            var contentNoTag = UE.getEditor('editor').getContentTxt();
            //校验
            if (title == null || title == '') {
                $.messager.alert("系统提示", "请输入标题！");
            } else if (blogTypeId == null || blogTypeId == '') {
                $.messager.alert("系统提示", "请选择博客类型！");
            } else if (content == null || content == '') { 
                $.messager.alert("系统提示", "请编辑博客内容！");
            } else {
               //ajax请求 请求后台写博客接口
                $.post("${pageContext.request.contextPath}/saveBlog",
                        {
                			'id' : blogid,
                            'title' : title,
                            'blogType.id' : blogTypeId,
                            'content' : content,
                            'summary' : summary,
                            /*'keyWord' : keyWord,*/
                            'tags'    : tagsStr,
                            'contentNoTag' : contentNoTag
                        }, function(result) {
                            if (result.success) {
	                            $.messager.alert("系统提示", successMsg);
                                clearValues();
                            } else {
                                $.messager.alert("系统提示", failedMsg);
                            }
                        }, "json");
            }
        }
        //清空功能
        function clearValues() {
            $("#title").val("");
            $("#blogTypeId").combobox("setValue", "");
            UE.getEditor("editor").setContent("");
           /*  $("#keyWord").val(""); */
            $("[name='tags']").removeAttr("checked");
        }
    </script>
  
  <body style="margin: 10px; font-family: microsoft yahei">

    <div id="p" class="easyui-panel" title="编写博客" style="padding: 10px;">

        <input type="hidden" id="blogid" name="blogid"  value="${Blog.id }"/> 
        <table cellspacing="20px">
            <tr>
                <td width="80px">博客标题：</td>
                <td><input type="text" id="title" name="title" value="${Blog.title }" style="width:400px" /></td>
            </tr>
            <tr>
                <td>所属类别：</td>
                <td><select id="blogTypeId" class="easyui-combobox"
                    name="blogType.id" style="width:154px" editable="false"
                    panelHeight="auto">
                        <option value="${Blog.blogType.id }">${Blog.blogType.typeName }</option>
                        <c:forEach items="${blogTypeList }" var="blogType">
                            <option value="${blogType.id }">${blogType.typeName }</option>
                        </c:forEach>
                </select></td>
                <td></td>
            </tr>
            <tr>
                <td valign="top">博客内容：</td>
                <td><script id="editor" name="content"  type="text/plain"
                        style="width:95%; height:200px;">${Blog.content }</script></td>
            </tr>
            <tr>
<%--                 <td>关键字：</td>
            <td><input type="text" id="keyWord" name="keyWord" value="${Blog.keyWord }"
                    style="width:400px" />&nbsp;&nbsp;&nbsp;多个关键字的话请用空格隔开</td> --%>
                    <td>标签：</td>
            <td>
            	<c:forEach items="${blogTagsList }" var="blogTags">
					<c:choose>
						<c:when test="${blogTags.isChecked == true }">
							<input type="checkbox" id="tags" name="tags" value="${blogTags.id }" checked="checked" />${blogTags.name }
						</c:when>
						<c:otherwise>
							<input type="checkbox" id="tags" name="tags" value="${blogTags.id }" />${blogTags.name }
						</c:otherwise>
					</c:choose>
            		<%-- <input type="checkbox" id="tags" name="tags" value="${blogTags.id }" />${blogTags.name } --%>
            	</c:forEach>
            </td>
            </tr>
            <tr>
                <td></td>
                <td><a href="javascript:submitData()" class="easyui-linkbutton" data-options="iconCls:'icon-submit'">
                		<c:choose>
                			<c:when test="${Blog.blogType.id > 0}">修改博客</c:when>
                			<c:when test="${Blog.blogType.id == null}">发布博客</c:when>
                		</c:choose>
                	</a>
                </td>
            </tr>
        </table>
    </div>


   </body>
</html>