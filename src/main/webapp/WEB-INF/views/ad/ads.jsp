<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container ads" id="ad_tuijian">
	<div id="disqus_thread"></div>
	<script>
	/**
	* RECOMMENDED CONFIGURATION VARIABLES: EDIT AND UNCOMMENT THE SECTION BELOW TO INSERT DYNAMIC VALUES FROM YOUR PLATFORM OR CMS.
	* LEARN WHY DEFINING THESE VARIABLES IS IMPORTANT: https://disqus.com/admin/universalcode/#configuration-variables
	*/
	/*
	var disqus_config = function () {
	this.page.url = PAGE_URL; // Replace PAGE_URL with your page's canonical URL variable
	this.page.identifier = PAGE_IDENTIFIER; // Replace PAGE_IDENTIFIER with your page's unique identifier variable
	};
	*/
	(function() { // DON'T EDIT BELOW THIS LINE
	var d = document, s = d.createElement('script');
	
	s.src = '//menya.disqus.com/embed.js';
	
	s.setAttribute('data-timestamp', +new Date());
	(d.head || d.body).appendChild(s);
	})();
	</script>
	<noscript>Please enable JavaScript to view the <a href="https://disqus.com/?ref_noscript" rel="nofollow">comments powered by Disqus.</a></noscript>
	<c:if test="${header['Host'] == 'localhost:8010'}">
		<script type="text/javascript">
			var pn = window.location.pathname;
			var baiduImagePlus;
			if(pn.indexOf("netease")>0){
				baiduImagePlus = {
					noLogo : true,
					unionId : 'u2555202',
					formList : [ {
						formId : 10
					}, {
						formId : 3
					} ]
				};
			}
		</script>
		<script src="http://cpro.baidustatic.com/cpro/ui/i.js"></script>
	</c:if>
</div>