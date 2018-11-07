<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@include file="common/blogviewhead.jspf" %>

<div class="pagebg sh"></div>
<div class="container">
  <h1 class="t_nav"><span>不要轻易放弃。学习成长的路上，我们长路漫漫，只因学无止境。 </span><a href="/" class="n1">网站首页</a><a href="/" class="n2">学无止境</a></h1>
  <!--blogsbox begin-->
  <div class="blogsbox">
  
	<c:forEach items="${tagsBlogPage.result }" var="blog">
    <div class="blogs" data-scroll-reveal="enter bottom over 1s" >
      <h3 class="blogtitle"><a href="${pageContext.request.contextPath}/blogview?id=${blog.id }" target="_blank">${blog.title }</a></h3>
      <span class="blogpic">
  		<a href="#" title="">
  			<img src="${pageContext.request.contextPath}/static/blogPages/images/blog${blog.id % 6 }.jpg" alt="">
  		</a>
  	  </span>
      <p class="blogtext">${blog.summary }</p>
      <div class="bloginfo">
        <ul>
          <li class="author"><a href="#">FlyQi</a></li>
          <li class="lmname"><a href="${pageContext.request.contextPath}/listTagsBlog?tagsId=${blog.blogType.id }">${blog.blogType.typeName }</a></li>
          <li class="timer"><fmt:formatDate value="${blog.releaseDate }" pattern="yyyy-MM-dd" /></li>
          <li class="view"><span>${blog.clickHit }</span> 已阅读</li>
          <li class="like">${blog.likes }</li>
        </ul>
      </div>
    </div>
    </c:forEach>
    
    <div class="pagelist">
    	<a title="Total record">&nbsp;<b>${tagsBlogPage.total }</b> </a>&nbsp;&nbsp;&nbsp;
    		<c:if test="${tagsBlogPage.currPage > 1 }">
	    		<a href="${pageContext.request.contextPath}/listTagsBlog?tagsId=${blogTypeId }&page=1">首页</a>
	 			<a href="${pageContext.request.contextPath}/listTagsBlog?tagsId=${blogTypeId }&page=${tagsBlogPage.currPage -1 }">上一页</a>&nbsp;
    		</c:if>
    		
    		<c:if test="${tagsBlogPage.currPage > 3 }">
		    		<a href="${pageContext.request.contextPath}/listTagsBlog?tagsId=${blogTypeId }&page=${tagsBlogPage.currPage -3 }">${tagsBlogPage.currPage -3 }</a>&nbsp;
    		</c:if>
    		<c:if test="${tagsBlogPage.currPage > 2 }">
		    		<a href="${pageContext.request.contextPath}/listTagsBlog?tagsId=${blogTypeId }&page=${tagsBlogPage.currPage -2 }">${tagsBlogPage.currPage -2 }</a>&nbsp;
    		</c:if>
    		<c:if test="${tagsBlogPage.currPage > 1 }">
		    		<a href="${pageContext.request.contextPath}/listTagsBlog?tagsId=${blogTypeId }&page=${tagsBlogPage.currPage -1 }">${tagsBlogPage.currPage -1}</a>&nbsp;
    		</c:if>
		    		<a href="#"><b>${tagsBlogPage.currPage }</b></a>&nbsp;
    		<c:if test="${tagsBlogPage.currPage + 1 <= tagsBlogPage.totalPage }">
		    		<a href="${pageContext.request.contextPath}/listTagsBlog?tagsId=${blogTypeId }&page=${tagsBlogPage.currPage +1 }">${tagsBlogPage.currPage + 1}</a>&nbsp;
    		</c:if>
<%--     		<c:if test="${pageBlog.currPage +2 } <= ${pageBlog.total }"> --%>
    		<c:if test="${tagsBlogPage.currPage + 2 <= tagsBlogPage.totalPage }">
		    		<a href="${pageContext.request.contextPath}/listTagsBlog?tagsId=${blogTypeId }&page=${tagsBlogPage.currPage +2 }">${tagsBlogPage.currPage + 2}</a>&nbsp;
    		</c:if>
    		<c:if test="${tagsBlogPage.currPage + 3 <= tagsBlogPage.totalPage }">
		    		<a href="${pageContext.request.contextPath}/listTagsBlog?tagsId=${blogTypeId }&page=${tagsBlogPage.currPage +3 }">${tagsBlogPage.currPage + 3}</a>&nbsp;
    		</c:if>
    	
 
    		<c:if test="${tagsBlogPage.currPage + 1 <= tagsBlogPage.totalPage }">
	 			<a href="${pageContext.request.contextPath}/listTagsBlog?tagsId=${blogTypeId }&page=${tagsBlogPage.currPage +1 }">下一页</a>&nbsp;
	    		<a href="${pageContext.request.contextPath}/listTagsBlog?tagsId=${blogTypeId }&page=${tagsBlogPage.totalPage }">尾页</a>
    		</c:if>
    </div>
  </div>
  
<%@include file="common/blogviewtail.jspf" %>
</body>
</html>
