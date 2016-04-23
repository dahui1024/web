<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="title" value="门牙电视直播 - 看抗日神剧、每日7点AV世界，赛过活神仙！" scope="request"/>
<!DOCTYPE html>
<html lang="zh-CN">
  <c:import url="header.jsp"></c:import>
  <body>
    <c:import url="default.jsp"></c:import>

	<!-- Begin page content -->
	<div class="container">
		<div class="page-header-small">
			<h1 class="text-center">门牙电视直播<small>&nbsp;&nbsp;看抗日神剧、每日7点AV世界，赛过活神仙！</small></h1>
		</div>
		<c:forEach items="${vList }" var="n" varStatus="s">
			<div class="col-xs-6 col-md-4">
				<div class="thumbnail" style="background-color: #FFFFCC;border: 0">
			   		<a href="javascript:void(0)" onclick="view('${n.param}','${n.name }')" >
						<img src="${n.img }" alt="${n.name }" class="img-responsive">
					</a>
			    	<div class="caption">
			    		<p class="lead" style=" overflow: hidden;text-overflow: ellipsis;white-space: nowrap;cursor:pointer" onclick="view('${n.param}','${n.name }')">
			    			${n.name }
			    		</p>
			    	</div>
			    </div>
			</div>
		</c:forEach>
			
	</div>
	<c:import url="ad/ads.jsp"/>
    <c:import url="footer.jsp"/>
  </body>
</html>
