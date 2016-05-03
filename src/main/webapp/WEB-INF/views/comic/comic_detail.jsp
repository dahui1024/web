<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="title" value="${cTitle } - 漫画 - 中场快看" scope="request" />
<!DOCTYPE html>
<html lang="zh-CN">
<c:import url="../header.jsp"></c:import>
<body>
	<c:import url="../default.jsp"></c:import>
	<div class="container">
		<h1 class="text-center">${cTitle }<br>
			<small>&nbsp;&nbsp;${desc }！</small>
		</h1>
		<c:import url="../share.jsp"></c:import>
		<div class="row">
			<%-- <p class="lead">
      		<a href="/comic/catalog/${cid }">查看目录</a>
      	</p> --%>
		</div>
		<div class="row">
			<c:forEach items="${cList }" var="n" varStatus="index">
				<div class="col-md-12 col-xs-12">
					<img class="img-responsive center-block" alt="${cTitle }"
						src="${n }">
				</div>
			</c:forEach>
		</div>
		<!-- /.row -->
		<div class="row">
			<c:forEach items="${cMoreList }" var="n" varStatus="index">
				<div class="col-md-4 col-xs-12">
					<p class="lead less_text">
						<a href="/comic/detail/${n.subId }?cid=${n.id }">${n.subTitle }</a>
					</p>
				</div>
			</c:forEach>
		</div>
	</div>
	<!-- /.container -->
	<c:import url="../ad/ads.jsp" />
	<c:import url="../footer.jsp" />
</body>
</html>
