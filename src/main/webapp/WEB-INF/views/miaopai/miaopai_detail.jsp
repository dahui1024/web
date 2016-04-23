<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="title" value="${video_title } - 娱乐 -门牙引力波" scope="request"/>
<!DOCTYPE html>
<html lang="zh-CN">
  <c:import url="../header.jsp"></c:import>
  <body>
    <c:import url="../default.jsp"></c:import>
    <div class="container">
      <div class="blog-header text-center">
			<h1>门牙娱乐<small>&nbsp;&nbsp;你愚我乐，你乐我疯！</small></h1>
      </div>
      <c:import url="../share.jsp"></c:import>
      <div class="row">
      	<div class="col-md-12 col-xs-12 lead"><h2>${video_title }</h2></div>
        <div class="col-md-12 col-xs-12">
	  		<div class="embed-responsive embed-responsive-16by9">
			  <video controls="true" autoplay="false" name="media">
			  	<source src="${video_url }" type="video/mp4">
			  </video>
			</div>
        </div><!-- /.blog-main -->
      </div><!-- /.row -->
      <div class="row">
      	<h2>推荐视频</h2>
      	<hr>
      	<c:forEach items="${videoList }" var="n" varStatus="s">
		  	<div class="col-md-6 col-xs-12 lead less_text">
		  		<a href="javascript:viewVideo('${n.id}','${n.title }','${n.length }')">${n.title }</a>
		  	</div>
		</c:forEach>
      </div>
    </div><!-- /.container -->
	<c:import url="../ad/ads.jsp"/>
    <c:import url="../footer.jsp"/>
    
  </body>
</html>
