<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="title" value="${photo_title } - 阅读 -中场快看" scope="request"/>
<!DOCTYPE html>
<html lang="zh-CN">
<c:import url="../header.jsp"></c:import>
  <body>
    <c:import url="../default.jsp"></c:import>

	<div class="container">
		<div class="blog-header text-center">
      		<h1>中场阅读<small>&nbsp;&nbsp;阅读，帮你更好的认知这个世界！</small></h1>
		</div>
      	<c:import url="../share.jsp"></c:import>
		<div class="row">
			<div class="col-md-12 col-xs-12 lead"><h2>${photo_title }</h2></div>
			<c:forEach items="${detail }" var="d" varStatus="s">
				<div class="col-md-12 col-xs-12 blog-main">
					<div class="blog-post">
						<img src="${d[0] }" alt="${dkeys }" class="img-responsive">
						<p class="blog-post-meta">${d[1] }</p>
					</div>
				</div>
				<!-- /.blog-main -->
			</c:forEach>
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container -->
	<c:import url="../ad/ads.jsp"/>
	<c:import url="../footer.jsp" />

</body>
</html>
