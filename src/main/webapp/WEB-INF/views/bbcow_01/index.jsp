<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="title" value="中场视频 - 你愚我乐，你乐我疯！" scope="request"/>
<!DOCTYPE html>
<html lang="zh-CN">
  <c:import url="../header.jsp"></c:import>
  <body>
    <c:import url="../default.jsp"></c:import>
	
	<!-- Begin page content -->
	<div class="container-fluid">
		<div class="row text-center">
	      	<h1>中场视频 <small>&nbsp;&nbsp;你愚我乐，你乐我疯！</small></h1>
	      </div>
	      <div class="row">
	      	<c:forEach items="${videoList }" var="obj" varStatus="ss">
		  	<div class="col-md-6 col-xs-12">
		  		<div class="col-md-12 col-xs-12 lead">
		  			<b>${obj.name }</b>
		  			<a href="/miaopai/page/1?type=${obj.id }" class="btn btn-link btn-lg">MORE</a>
		  		</div>
		        <c:forEach items="${obj.videos }" var="n" varStatus="s">
				  	<div class="col-md-12 col-xs-12 lead less_text <c:if test='${s.index<3 }'>bg-info</c:if>">
				  		【${s.index+1 }】<a href="javascript:viewVideo('${n.id}','${n.title }','${n.length }')">${n.title }</a>
				  	</div>
				</c:forEach>
		  	</div>
		  	</c:forEach>
	      </div><!-- /.row -->
	</div>
	<c:import url="../ad/ads.jsp"/>
    <c:import url="../footer.jsp"/>
  </body>
</html>
