<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>

<%@include file="common/blogviewhead.jspf" %>

<script type="text/javascript" >
	//浏览器加载以后立即执行,初始化
	function executeInstently() {
		
		var blogul = document.getElementById('blogul');
		var tmp = blogul.getElementsByTagName("li");
		for (i = 5; i < tmp.length; i++) {
			tmp[7].setAttribute('style', "display:none");
		}
 	}
	function filters(intag) {
		if (intag.tagName == "DIV" || intag.tagName == "div") {
			var taga = intag.parentNode;
			var present = taga.getElementsByTagName("ul")[0];
			if (present.style.display == "block") {
				help(taga);
			} else {
				help(taga);
				present.style.display = "block";
			}
		}
		function help(intag) {
			var fathertag = intag.parentNode;
			var sontag = fathertag.getElementsByTagName("ul");
			for (i = 0; i < sontag.length; i++) {
				sontag[i].style.display = "none";
			}
		}
	}
/*  	executeInstently();  */

</script>

<article> 
  <!--banner begin-->
 <div class="picsbox"> 
  <div class="banner">
    <div id="banner" class="fader">
      <li class="slide" ><a href="#" target="_blank"><img src="${pageContext.request.contextPath}/static/blogPages/images/banner01.jpg"><span class="imginfo">风起于青萍之末，浪成于微澜之间 !</span></a></li>
      <li class="slide" ><a href="#" target="_blank"><img src="${pageContext.request.contextPath}/static/blogPages/images/blog6.jpg"><span class="imginfo">三分天赋可入津， 七分勤奋入桃园 。</span></a></li>
      <li class="slide" ><a href="#" target="_blank"><img src="${pageContext.request.contextPath}/static/blogPages/images/banner03.jpg"><span class="imginfo">个人博客，属于我的小世界！</span></a></li>
      <div class="fader_controls">
        <div class="page prev" data-target="prev">&lsaquo;</div>
        <div class="page next" data-target="next">&rsaquo;</div>
        <ul class="pager_list">
        </ul>
      </div>
    </div>
  </div>
  <!--banner end-->
  <div class="toppic">
    <li> <a href="#" target="_blank"> <i><img src="${pageContext.request.contextPath}/static/blogPages/images/blog4.jpg"></i>
      <h2>别让这些闹心的套路，毁了你的网页设计!</h2>
      <span>学无止境</span> </a> </li>
    <li> <a href="#" target="_blank"> <i><img src="${pageContext.request.contextPath}/static/blogPages/images/blog2.jpg"></i>
      <h2>个人博客，属于我的小世界！</h2>
      <span>学无止境</span> </a> </li>
  </div>
  </div>
  <div class="blank"></div>
  <!--blogsbox begin-->
  <div class="blogsbox">
  
<!--     <div class="blogs" data-scroll-reveal="enter bottom over 1s" >
      <h3 class="blogtitle"><a href="/" target="_blank">别让这些闹心的套路，毁了你的网页设计!</a></h3>
      <span class="blogpic"><a href="/" title=""><img src="/blog/static/blogPages/images/toppic01.jpg" alt=""></a></span>
      <p class="blogtext">如图，要实现上图效果，我采用如下方法：1、首先在数据库模型，增加字段，分别是图片2，图片3。2、增加标签模板，用if，else if 来判断，输出。思路已打开，样式调用就可以多样化啦！... </p>
      <div class="bloginfo">
        <ul>
          <li class="author"><a href="/">杨青</a></li>
          <li class="lmname"><a href="/">学无止境</a></li>
          <li class="timer">2018-5-13</li>
          <li class="view"><span>34567</span>已阅读</li>
          <li class="like">9999</li>
        </ul>
      </div>
    </div>
 -->    
	<c:forEach items="${pageBlog.result }" var="blog">
	 <div class="blogs" data-scroll-reveal="enter bottom  over 1s" >
	      <h3 class="blogtitle"><a href="${pageContext.request.contextPath}/blogview?id=${blog.id }" target="_blank" >${blog.title }</a></h3>
	      <span class="blogpic"><a href="#" title="">
	      	<img src="${pageContext.request.contextPath}/static/blogPages/images/blog${blog.id % 6 }.jpg" alt=""></a>
	      </span>
	      <p class="blogtext">${blog.summary }</p>
	      <div class="bloginfo">
	        <ul>
	          <li class="author"><a href="#">FlyQi</a></li>
	          <li class="lmname"><a href="${pageContext.request.contextPath}/listClassifyBlog?id=${blog.blogType.id }">${blog.blogType.typeName }</a></li>
	          <li class="timer"><fmt:formatDate value="${blog.releaseDate }" pattern="yyyy-MM-dd" /></li>
	          <li class="view">${blog.clickHit } 已阅读</li>
	          <li class="like">${blog.likes }</li>
	        </ul>
	      </div>
	  </div>
    </c:forEach>
    <div class="pagelist">
    	<a title="Total record">&nbsp;<b>${pageBlog.total }</b> </a>&nbsp;&nbsp;&nbsp;
    		<c:if test="${pageBlog.currPage > 1 }">
	    		<a href="${pageContext.request.contextPath}/pageBlog?page=1">首页</a>
	 			<a href="${pageContext.request.contextPath}/pageBlog?page=${pageBlog.currPage -1 }">上一页</a>&nbsp;
    		</c:if>
    		
    		<c:if test="${pageBlog.currPage > 3 }">
		    		<a href="${pageContext.request.contextPath}/pageBlog?page=${pageBlog.currPage -3 }">${pageBlog.currPage -3 }</a>&nbsp;
    		</c:if>
    		<c:if test="${pageBlog.currPage > 2 }">
		    		<a href="${pageContext.request.contextPath}/pageBlog?page=${pageBlog.currPage -2 }">${pageBlog.currPage -2 }</a>&nbsp;
    		</c:if>
    		<c:if test="${pageBlog.currPage > 1 }">
		    		<a href="${pageContext.request.contextPath}/pageBlog?page=${pageBlog.currPage -1 }">${pageBlog.currPage -1}</a>&nbsp;
    		</c:if>
		    		<a href="#"><b>${pageBlog.currPage }</b></a>&nbsp;
    		<c:if test="${pageBlog.currPage + 1 <= pageBlog.totalPage }">
		    		<a href="${pageContext.request.contextPath}/pageBlog?page=${pageBlog.currPage +1 }">${pageBlog.currPage + 1}</a>&nbsp;
    		</c:if>
<%--     		<c:if test="${pageBlog.currPage +2 } <= ${pageBlog.total }"> --%>
    		<c:if test="${pageBlog.currPage + 2 <= pageBlog.totalPage }">
		    		<a href="${pageContext.request.contextPath}/pageBlog?page=${pageBlog.currPage +2 }">${pageBlog.currPage + 2}</a>&nbsp;
    		</c:if>
    		<c:if test="${pageBlog.currPage + 3 <= pageBlog.totalPage }">
		    		<a href="${pageContext.request.contextPath}/pageBlog?page=${pageBlog.currPage +3 }">${pageBlog.currPage + 3}</a>&nbsp;
    		</c:if>
    	
 
    		<c:if test="${pageBlog.currPage + 1 <= pageBlog.totalPage }">
	 			<a href="${pageContext.request.contextPath}/pageBlog?page=${pageBlog.currPage +1 }">下一页</a>&nbsp;
	    		<a href="${pageContext.request.contextPath}/pageBlog?page=${pageBlog.totalPage }">尾页</a>
    		</c:if>
    </div>
<!--     <div class="blogs" data-scroll-reveal="enter bottom over 1s" >
      <h3 class="blogtitle"><a href="/" target="_blank">别让这些闹心的套路，毁了你的网页设计!</a></h3>
      <span class="bplist"><a href="/" title="">
      <li><img src="/blog/static/blogPages/images/avatar.jpg" alt=""></li>
      <li><img src="/blog/static/blogPages/images/toppic02.jpg" alt=""></li>
      <li><img src="/blog/static/blogPages/images/banner01.jpg" alt=""></li>
      </a></span>
      <p class="blogtext">如图，要实现上图效果，我采用如下方法：1、首先在数据库模型，增加字段，分别是图片2，图片3。2、增加标签模板，用if，else if 来判断，输出。思路已打开，样式调用就可以多样化啦！... </p>
      <div class="bloginfo">
        <ul>
          <li class="author"><a href="/">杨青</a></li>
          <li class="lmname"><a href="/">学无止境</a></li>
          <li class="timer">2018-5-13</li>
          <li class="view"><span>34567</span>已阅读</li>
          <li class="like">9999</li>
        </ul>
      </div>
    </div>
    <div class="blogs" data-scroll-reveal="enter bottom over 1s" >
      <h3 class="blogtitle"><a href="/" target="_blank">别让这些闹心的套路，毁了你的网页设计!</a></h3>
      <span class="bigpic"><a href="/" title=""><img src="/blog/static/blogPages/images/toppic01.jpg" alt=""></a></span>
      <p class="blogtext">如图，要实现上图效果，我采用如下方法：1、首先在数据库模型，增加字段，分别是图片2，图片3。2、增加标签模板，用if，else if 来判断，输出。思路已打开，样式调用就可以多样化啦！... </p>
      <div class="bloginfo">
        <ul>
          <li class="author"><a href="/">杨青</a></li>
          <li class="lmname"><a href="/">学无止境</a></li>
          <li class="timer">2018-5-13</li>
          <li class="view"><span>34567</span>已阅读</li>
          <li class="like">9999</li>
        </ul>
      </div>
    </div>
    <div class="blogs" data-scroll-reveal="enter bottom over 1s" >
      <h3 class="blogtitle"><a href="/" target="_blank">别让这些闹心的套路，毁了你的网页设计!</a></h3>
      <span class="blogpic"><a href="/" title=""><img src="/blog/static/blogPages/images/toppic01.jpg" alt=""></a></span>
      <p class="blogtext">如图，要实现上图效果，我采用如下方法：1、首先在数据库模型，增加字段，分别是图片2，图片3。2、增加标签模板，用if，else if 来判断，输出。思路已打开，样式调用就可以多样化啦！... </p>
      <div class="bloginfo">
        <ul>
          <li class="author"><a href="/">杨青</a></li>
          <li class="lmname"><a href="/">学无止境</a></li>
          <li class="timer">2018-5-13</li>
          <li class="view"><span>34567</span>已阅读</li>
          <li class="like">9999</li>
        </ul>
      </div>
    </div>
    <div class="blogs" data-scroll-reveal="enter bottom over 1s" >
      <h3 class="blogtitle"><a href="/" target="_blank">帝国cms 首页或者列表页 实现图文不同样式调用方法</a></h3>
      <p class="blogtext">如图，要实现上图效果，我采用如下方法：1、首先在数据库模型，增加字段，分别是图片2，图片3。2、增加标签模板，用if，else if 来判断，输出。思路已打开，样式调用就可以多样化啦！...</p>
      <div class="bloginfo">
        <ul>
          <li class="author"><a href="/">杨青</a></li>
          <li class="lmname"><a href="/">学无止境</a></li>
          <li class="timer">2018-5-13</li>
          <li class="view">4567已阅读</li>
          <li class="like">9999</li>
        </ul>
      </div>
    </div>
    <div class="blogs" data-scroll-reveal="enter bottom over 1s" >
      <h3 class="blogtitle"><a href="/" target="_blank">别让这些闹心的套路，毁了你的网页设计!</a></h3>
      <span class="bplist"><a href="/" title="">
      <li><img src="/blog/static/blogPages/images/avatar.jpg" alt=""></li>
      <li><img src="/blog/static/blogPages/images/bi05.jpg" alt=""></li>
      <li><img src="/blog/static/blogPages/images/banner01.jpg" alt=""></li>
      </a></span>
      <p class="blogtext">如图，要实现上图效果，我采用如下方法：1、首先在数据库模型，增加字段，分别是图片2，图片3。2、增加标签模板，用if，else if 来判断，输出。思路已打开，样式调用就可以多样化啦！... </p>
      <div class="bloginfo">
        <ul>
          <li class="author"><a href="/">杨青</a></li>
          <li class="lmname"><a href="/">学无止境</a></li>
          <li class="timer">2018-5-13</li>
          <li class="view"><span>34567</span>已阅读</li>
          <li class="like">9999</li>
        </ul>
      </div>
    </div>
 -->  
  </div>
  
 <%@include file="common/blogviewtail.jspf" %>
</body>
</html>
