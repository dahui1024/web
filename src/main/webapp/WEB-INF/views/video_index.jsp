<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="title" value="门牙娱乐 - 你愚我乐，你乐我疯！" scope="request"/>
<!DOCTYPE html>
<html lang="zh-CN">
  <c:import url="header.jsp"></c:import>
  <body>
    <c:import url="default.jsp"></c:import>

	<!-- Begin page content -->
	<div class="container">
		<h1 class="text-center">门牙娱乐<small>&nbsp;&nbsp;你愚我乐，你乐我疯！</small></h1>
		<c:forEach items="${vList }" var="n" varStatus="s">
			<div class="col-xs-12 col-md-4">
				<div class="thumbnail" style="background-color: #FFFFCC;border: 0">
			   		<a href="javascript:void(0)" onclick="viewVideo('${n.id}','${n.title }','${n.length }')">
						<img src="${n.img }" alt="${n.title }" class="" style="height: 300px">
					</a>
			    	<div class="caption">
			    		<small class="text-right">${n.length }</small>
			    		<p class="lead" style="overflow: hidden;text-overflow: ellipsis;white-space: nowrap;cursor:pointer" onclick="view('${n.id}','${n.title }','${n.length }')">
			    			${n.title }
			    		</p>
			    	</div>
			    </div>
			</div>
			<c:if test="${s.index%3==2 && s.index>0 }">
			<div class="row"></div></c:if>
		</c:forEach>
		<div class="col-md-12 col-xs-12">
			<a href="/miaopai/page/${page }?type=${type }" class="btn btn-primary btn-lg btn-block">更多视频</a>
		</div>
	</div>
	
    <c:import url="footer.jsp"/>
  </body>
</html>
