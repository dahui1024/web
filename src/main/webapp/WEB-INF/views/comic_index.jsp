<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="title" value="中场漫画 - 漫动人生！" scope="request"/>
<!DOCTYPE html>
<html lang="zh-CN">
  <c:import url="header.jsp"></c:import>
  <body>
    <c:import url="default.jsp"></c:import>

    <div class="container">
      <h1 class="text-center">中场漫画<small>&nbsp;&nbsp;漫动人生！</small></h1>
      <div class="row">
      	<p class="lead">${desc }</p>
      </div>
      <div class="row">
        <c:forEach items="${cList }" var="n" varStatus="index">
		  	<div class="col-md-12 col-xs-12">
		  		<h2 class="">
		  			<c:if test="${!empty n.label }">【${n.label }】</c:if>
		  			<a href="/comic/detail/${n.subId }?cid=${n.id }" target="_blank">${n.subTitle } - ${n.title }</a>
		  		</h2>
		  		<%-- <small>${n.desc }</small> --%>
		  		<img src="${n.subImg }" alt="${n.subTitle } - ${n.title }" class="img-responsive  center-block">
		  	<hr>
		  	</div>
		  </c:forEach>
		<div class="col-md-12 col-xs-12">
			<a href="/comic/page/${page }" class="btn btn-primary btn-lg btn-block">更多更新</a>
		</div>
      </div><!-- /.row -->

    </div><!-- /.container -->
	<c:import url="ad/ads.jsp"/>
	<c:import url="footer.jsp"/>
  </body>
</html>
