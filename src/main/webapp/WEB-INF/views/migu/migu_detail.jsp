<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="title" value="${video_title } - 直播 -中场快看" scope="request"/>
<!DOCTYPE html>
<html lang="zh-CN">
  <c:import url="../header.jsp"></c:import>
  <body>
    <c:import url="../default.jsp"></c:import>
    <div class="container">
      <div class="blog-header text-center">
			<h1>中场电视直播<small>&nbsp;&nbsp;看抗日神剧、每日7点AV世界，赛过活神仙！</small></h1>
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
    </div><!-- /.container -->
	<c:import url="../ad/ads.jsp"/>
    <c:import url="../footer.jsp"/>
    
  </body>
</html>
