<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <!-- Fixed navbar -->
<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">中场快看</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/">中场快看</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="/01">中场视频</a></li>
				<li><a href="/02">中场阅读</a></li>
				<li style="background: #d9edf7"><a href="/comic">中场漫画（不兼容ios）</a></li>
				<li><a href="/netease/page/0?channel=T1348647909107">中场新闻</a></li>
				<li><a href="/migu/province">中场卫视直播（移动端）</a></li>
				<li><a href="/migu/country">中场央视直播（移动端）</a></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
</nav>