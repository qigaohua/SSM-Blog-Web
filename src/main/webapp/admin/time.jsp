<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="common/blogviewhead.jspf" %>

<div class="pagebg timer"> </div>
<div class="container">
  <h1 class="t_nav"><span>时光飞逝，机会就在我们眼前，何时找到了灵感，就要把握机遇，我们需要智慧和勇气去把握机会。</span><a href="/" class="n1">网站首页</a><a href="/" class="n2">时间轴</a></h1>
  <div class="timebox">
  <ul id="list" style="display:none;">
  	<c:forEach items="${timeBlogs }"  var="blog">
  	  <li>
  	  	<span><fmt:formatDate value="${blog.releaseDate }" pattern="yyyy-MM-dd" /></span><a href="${pageContext.request.contextPath}/blogview?id=${blog.id }" title="${blog.title }">${blog.title }</a>
  	  </li>
  	</c:forEach>
  </ul>
  <ul id="list2">
  </ul>
  <script src="/blog/static/blogPages/js/page2.js"></script> 
  </div>
</div>
<footer>
  <p>Design by <a href="http://www.yangqq.com" target="_blank">FlyQi个人博客</a> <a href="/">蜀ICP备11002373号-1</a></p>
</footer>
<a href="#" class="cd-top">Top</a>
</body>
</html>
