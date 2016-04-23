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
        <c:forEach items="${news }" var="n" varStatus="index">
		  	<div class="col-md-12 col-xs-12">
		  		<h2 class="">
		  			<c:if test='${empty n.url}'><a href="/netease/photo/${n.photosetID}.html">${n.title }</a></c:if>
		  			<c:if test='${!empty n.url}'><a href="/netease/post/${n.postid}.html">${n.title }</a></c:if>
		  		</h2>
		  		<p class="">
		  			<small>${n.ptime}</small>
		  			<small>${n.source}</small>
		  			<small>【关注度：${n.votecount}】</small>
		  		</p>
		  		<c:if test='${!empty n.digest}'>
			  			<h4>
			  				<c:if test='${empty n.url}'><a href="/netease/photo/${n.photosetID}.html">${n.digest }</a></c:if>
			  				<c:if test='${!empty n.url}'><a href="/netease/post/${n.postid}.html">${n.digest }</a></c:if>
			  			</h4>
	            </c:if>
	            <c:if test='${empty n.url}'><a href="/netease/photo/${n.photosetID}.html"><img src="${n.imgsrc}" alt="${n.title }" class="img-responsive"></a></c:if>
		  		<c:if test='${!empty n.url}'><a href="/netease/post/${n.postid}.html"><img src="${n.imgsrc}" alt="${n.title }" class="img-responsive"></a></c:if>
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
