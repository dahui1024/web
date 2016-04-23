<%@ page language="java" pageEncoding="UTF-8" %>
<div class="container ads" id="ad_tuijian">
	<script type="text/javascript">
		/* alert(window.location.pathname+"---"+window.location.href) */
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
	
</div>