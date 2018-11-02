<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>

<%@include file="common/blogviewhead.jspf" %>
<!-- ueditor 代码高亮显示 -->
<script src="${pageContext.request.contextPath}/static/UEditor_1433/third-party/SyntaxHighlighter/shCore.js"></script>
<link href="${pageContext.request.contextPath}/static/UEditor_1433/third-party/SyntaxHighlighter/shCoreDefault.css" rel="stylesheet">
<script type="text/javascript">
    SyntaxHighlighter.all();
</script>

<script type="text/javascript">
 	// 点赞
 	function addDianzan(id) {
 	
 	var flag = 0;
 	
 	var value=parseInt(document.getElementById("diggnum").innerHTML);
	var text = document.getElementById("dianzan").innerHTML;
	
	if (text == " 很赞哦  ") {
		value=value + 1;
		flag = 1;	
	}
	else {
		value=value - 1;
		flag = 2;	
	}
		
 	$.ajax({ //一个Ajax过程
 			type: "post", //以post方式与后台沟通
 			url : "${pageContext.request.contextPath}/dianzan?id=" + id + "&value="+value, 
 			dataType:'json',
 			data: {"value":value,"id":id}, 
 			success: function(result) {
				if (result.success) {
					document.getElementById("diggnum").innerHTML=value;
					if (flag == 1) 
						document.getElementById("dianzan").innerHTML=" 取消赞  ";
					else if (flag == 2)
						document.getElementById("dianzan").innerHTML=" 很赞哦  ";
					else {
						
					}
				}
				else {
					alert("失败");
				}
 			}
 		});
	}
</script>
<article>
  <h1 class="t_nav"><span>您现在的位置是：首页 > 慢生活 > 程序人生</span><a href="/" class="n1">网站首页</a><a href="/" class="n2">慢生活</a></h1>
  <div class="infosbox">
    <div class="newsview">
      <h3 class="news_title">${Blog.title }</h3>
      <div class="bloginfo">
        <ul>
          <li class="author"><a href="#">FlyQi</a></li>
          <li class="lmname"><a href="${pageContext.request.contextPath}/listClassifyBlog?id=${Blog.blogType.id }">${Blog.blogType.typeName }</a></li>
          <li class="timer"><fmt:formatDate value="${Blog.releaseDate }" pattern="yyyy-MM-dd" /></li>
          <li class="view">${Blog.clickHit } 已阅读</li>
          <li class="like">${Blog.likes }</li>
        </ul>
      </div>
      <div class="tags">
      	<a href="/" target="_blank">个人博客</a> &nbsp; 
      	<a href="/" target="_blank">小世界</a>
      </div>
      <div class="news_con">${Blog.content }</div>
    </div>
    <div class="share">
      <p class="diggit"><a id="dianzan" href="JavaScript:addDianzan(${Blog.id });"> 很赞哦  </a>(<b id="diggnum">${Blog.likes }</b>)</p>
      <p class="dasbox"><a href="javascript:void(0)" onClick="dashangToggle()" class="dashang" title="打赏，支持一下">打赏本站</a></p>
      <div class="hide_box"></div>
      <div class="shang_box"> <a class="shang_close" href="javascript:void(0)" onclick="dashangToggle()" title="关闭">关闭</a>
        <div class="shang_tit">
          <p>感谢您的支持，我会继续努力的!</p>
        </div>
        <div class="shang_payimg"> <img src="${pageContext.request.contextPath}/static/blogPages/images/alipayimg.jpg" alt="扫码支持" title="扫一扫"> </div>
        <div class="pay_explain">扫码打赏，你说多少就多少</div>
        <div class="shang_payselect">
          <div class="pay_item checked" data-id="alipay"> <span class="radiobox"></span> <span class="pay_logo"><img src="${pageContext.request.contextPath}/static/blogPages/images/alipay.jpg" alt="支付宝"></span> </div>
          <div class="pay_item" data-id="weipay"> <span class="radiobox"></span> <span class="pay_logo"><img src="${pageContext.request.contextPath}/static/blogPages/images/wechat.jpg" alt="微信"></span> </div>
        </div>
       	 <script type="text/javascript">
		    $(function(){
		    	$(".pay_item").click(function(){
		    		$(this).addClass('checked').siblings('.pay_item').removeClass('checked');
		    		var dataid=$(this).attr('data-id');
		    		$(".shang_payimg img").attr("src","${pageContext.request.contextPath}/static/blogPages/images/"+dataid+"img.jpg");
		    		$("#shang_pay_txt").text(dataid=="alipay"?"支付宝":"微信");
		    	});
		    });
		    function dashangToggle(){
		    	$(".hide_box").fadeToggle();
		    	$(".shang_box").fadeToggle();
		    }
   		 </script> 
      </div>
    </div>
    <div class="nextinfo">
      <p>上一篇：<a href="${pageContext.request.contextPath}/blogview?id=${preBlog.id }">${preBlog.title }</a></p>
      <p>下一篇：<a href="${pageContext.request.contextPath}/blogview?id=${afterBlog.id }">${afterBlog.title }</a></p>
    </div>
    <div class="otherlink">
      <h2>相关文章</h2>
      <ul>
        <li><a href="/download/div/2018-04-22/815.html" title="html5个人博客模板《黑色格调》">html5个人博客模板《黑色格调》</a></li>
        <li><a href="/download/div/2018-04-18/814.html" title="html5个人博客模板主题《清雅》">html5个人博客模板主题《清雅》</a></li>
        <li><a href="/download/div/2018-03-18/807.html" title="html5个人博客模板主题《绅士》">html5个人博客模板主题《绅士》</a></li>
        <li><a href="/download/div/2018-02-22/798.html" title="html5时尚个人博客模板-技术门户型">html5时尚个人博客模板-技术门户型</a></li>
        <li><a href="/download/div/2017-09-08/789.html" title="html5个人博客模板主题《心蓝时间轴》">html5个人博客模板主题《心蓝时间轴》</a></li>
        <li><a href="/download/div/2017-07-16/785.html" title="古典个人博客模板《江南墨卷》">古典个人博客模板《江南墨卷》</a></li>
        <li><a href="/download/div/2017-07-13/783.html" title="古典风格-个人博客模板">古典风格-个人博客模板</a></li>
        <li><a href="/download/div/2015-06-28/748.html" title="个人博客《草根寻梦》―手机版模板">个人博客《草根寻梦》―手机版模板</a></li>
        <li><a href="/download/div/2015-04-10/746.html" title="【活动作品】柠檬绿兔小白个人博客模板">【活动作品】柠檬绿兔小白个人博客模板</a></li>
        <li><a href="/jstt/bj/2015-01-09/740.html" title="【匆匆那些年】总结个人博客经历的这四年…">【匆匆那些年】总结个人博客经历的这四年…</a></li>
      </ul>
    </div>
    <div class="news_pl">
      <h2>文章评论</h2>
      <ul>
        <div class="gbko"> </div>
      </ul>
    </div>
  </div>
  
 <%@include file="common/blogviewtail.jspf" %>
</body>
</html>
