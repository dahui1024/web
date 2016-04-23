<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <c:import url="header.jsp"></c:import>
  <body>
    <c:import url="default.jsp"></c:import>

    <div class="container">
		<div class="row">
			<div class="page-header-small">
				<h1>门牙真理<small>&nbsp;&nbsp;实践是唯一的真理！</small></h1>
			</div>
 		 	<c:forEach items="${list }" var="n" varStatus="index">
				<h2>${index.index+1 }：
					<a href="/zhihu/story/${n.index}.html">${n.title }</a>
				</h2>
  			</c:forEach>
		</div>
	</div>
	<c:import url="ad/ads.jsp"/>
	<c:import url="footer.jsp"/>
  </body>
</html>
