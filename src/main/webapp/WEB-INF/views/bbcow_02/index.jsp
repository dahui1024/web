<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="title" value="门牙阅读 - 阅读，帮你更好的认知这个世界！" scope="request"/>
<!DOCTYPE html>
<html lang="zh-CN">
  <c:import url="../header.jsp"></c:import>
  <body>
    <c:import url="../default.jsp"></c:import>

    <div class="container-fluid">
      <div class="row text-center">
      	<h1>门牙阅读<small>&nbsp;&nbsp;阅读，帮你更好的认知这个世界！</small></h1>
      </div>
      <div class="row">
      	<c:forEach items="${list }" var="obj" varStatus="ss">
	  	<div class="col-md-6 col-xs-12">
	  		<div class="col-md-12 col-xs-12 lead">
	  			<b>${obj.name }</b>
	  			<a href="/netease/page/1?channel=${obj.id }" class="btn btn-link btn-lg">MORE</a>
	  		</div>
	        <c:forEach items="${obj.articles }" var="n" varStatus="s">
			  	<div class="col-md-12 col-xs-12 lead less_text <c:if test='${s.index<3 }'>bg-info</c:if>">
			  		<c:if test='${!empty n.photosetID}'><a href="/netease/photo/${n.photosetID}.html">${n.title }</a></c:if>
			  		<c:if test='${empty n.photosetID && !empty n.postid}'><a href="/netease/post/${n.postid}.html">${n.title }</a></c:if>
			  	</div>
			</c:forEach>
	  	</div>
	  	</c:forEach>
      </div><!-- /.row -->

    </div><!-- /.container -->
    <c:import url="../ad/ads.jsp"/>
	<c:import url="../footer.jsp"/>
  </body>
</html>
