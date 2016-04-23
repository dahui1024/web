<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="title" value="门牙阅读 - 阅读，帮你更好的认知这个世界！" scope="request"/>
<!DOCTYPE html>
<html lang="zh-CN">
  <c:import url="header.jsp"></c:import>
  <body>
    <c:import url="default.jsp"></c:import>

    <div class="container">
      	<h1 class="text-center">门牙阅读<small>&nbsp;&nbsp;阅读，帮你更好的认知这个世界！</small></h1>
      <div class="row">
        <c:forEach items="${cList }" var="n" varStatus="index">
		  	<div class="col-md-12 col-xs-12">
		  		<h2 class="">
		  			<a href="${n.url }">${n.title }</a>
		  		</h2>
		  		<img src="${n.img }">
		  	<hr>
		  	</div>
		  </c:forEach>
		<div class="col-md-12 col-xs-12">
			<a href="/netease/page/${page }?channel=${channel }" class="btn btn-primary btn-lg btn-block">更多文章</a>
		</div>
      </div><!-- /.row -->

    </div><!-- /.container -->
	<c:import url="ad/ads.jsp"/>
	<c:import url="footer.jsp"/>
  </body>
</html>
