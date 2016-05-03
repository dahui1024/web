<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<footer class="footer">
	<div class="container">
		<p class="text-muted lead text-center">中场快看</p>
		<p class="text-muted lead text-center"><small>特别声明：本站不提供任何内容上传服务，所有内容均来自分享站点所提供的公开引用资源</small></p>
		<p class="text-muted lead text-center"><small>Powered by MidRead © Copyright 2016. All rights reserved. </small></p>
	</div>
</footer>
<!-- Bootstrap core JavaScript
   ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="/static/js/main.js"></script>
<script src="/static/assets/js/ie10-viewport-bug-workaround.js"></script>
<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','https://www.google-analytics.com/analytics.js','ga');
  
  <c:if test="${header['Host'] == 'localhost:8010'}">
  	ga('create', 'UA-76381147-1', 'auto');
  </c:if>
  <c:if test="${header['Host'] == '101.200.136.202:8010'}">
	ga('create', 'UA-77279918-1', 'auto');
  </c:if>
  
  ga('send', 'pageview');

</script>
<a id="scrollUp" href="#top" style="position: fixed; z-index: 2147483647; display: block;"><i class="glyphicon glyphicon-triangle-top"></i></a>
  
