<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <c:import url="header.jsp"></c:import>
  <body>
    <c:import url="default.jsp"></c:import>
	<!-- Begin page content -->
	<div class="container">
		<h1 class="text-center">门牙引力波<small>&nbsp;&nbsp;一张嘴我看到了门牙，一上网我看到了世界。</small></h1>
		<div class="row">
			<div class="page-header-small col-xs-12 col-md-12">
				<h2>精彩娱乐视频</h2>
			</div>
			<c:forEach items="${topVideoList }" var="n" varStatus="s">
				<div class="col-xs-6 col-md-3">
					<a href="javascript:void(0)" class="" onclick="viewVideo('${n.id}','${n.title }','${n.length }')">
						<img src="${n.img }" alt="${n.title }" class="thumbnail index-top">
					</a>
				</div>
			</c:forEach>
		</div>
		<div class="row">
			<div class="col-xs-12 col-md-12">
				<div class="row index-header">
					<div class="col-xs-4 col-md-4">
						<h2>精彩阅读</h2>
					</div>
					<div class="col-xs-8 col-md-8 tags">
						<a class="col-md-3 col-xs-3 label label-warning" href="/netease/T1387970173334">看客</a>
						<a class="col-md-3  col-xs-3 label label-warning" href="/netease/T1374539968172">科技</a>
						<a class="col-md-3 col-xs-3 label label-warning" href="/netease/T1374539990324">解答</a>
						<a class="col-md-3 col-xs-3 label label-warning" href="/netease/T1348654756909">回声</a>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12 col-md-8">
						<a href="/netease/photo/${readTop.photosetID}.html">
							<img alt="${readTop.title}" src="${readTop.imgsrc}" class="img-responsive">
							<h3>${readTop.title}</h3>
						</a>
					</div>
					<div class="col-xs-12 col-md-4">
						<c:forEach items="${readList }" var="read" varStatus="s">
							<a href="/netease/photo/${read.photosetID}.html">
								<img alt="${read.title}" src="${read.imgsrc}" class="img-responsive">
								<h3>${read.title}</h3>
							</a>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12 col-md-6">
				<div class="row">
					<div class="index-header col-xs-12 col-md-12">
						<h2>最新视频</h2>
					</div>
					<div class="index-header col-xs-12 col-md-12">
						<a class="col-md-3 col-xs-3 label label-warning" href="/miaopai/nima">暴走大事件</a>
						<a class="col-md-3 col-xs-3 label label-warning" href="/miaopai/baoman">暴走漫画</a>
						<a class="col-md-3 col-xs-3 label label-warning" href="/miaopai/chenxiang">陈翔六点半</a>
						<a class="col-md-3 col-xs-3 label label-warning" href="/miaopai/feidie">飞碟说</a>
					</div>
					<c:forEach items="${newVideoList }" var="n" varStatus="s">
						<div class="col-xs-6 col-md-4">
							<a href="javascript:void(0)" class="" onclick="viewVideo('${n.id}','${n.title }','${n.length }')">
								<img src="${n.img }" alt="${n.title }" class="thumbnail index-other">
							</a>
						</div>
					</c:forEach>
				</div>
			</div>
			<div class="col-xs-12 col-md-6">
				<div class="page-header-small col-xs-12 col-md-12">
					<h2>新闻热点</h2>
				</div>
				<c:forEach items="${news }" var="n" varStatus="index">
					<div class="col-xs-12 col-md-12">
					<div class="media">
						<div class="media-left media-middle">
							<c:if test='${empty n.url}'>
								<a href="/netease/photo/${n.photosetID}.html">
									<img class="media-object" src="${n.imgsrc}" alt="${n.title }" style="width: 64px; height: 64px;" class="img-responsive">
								</a>
							</c:if>
							<c:if test='${!empty n.url}'>
								<a href="/netease/post/${n.postid}.html">
									<img class="media-object" src="${n.imgsrc}" alt="${n.title }" style="width: 64px; height: 64px;" class="img-responsive">
								</a>
							</c:if>
						</div>
						<div class="media-body">
							<h4 class="media-heading">
								<c:if test='${empty n.url}'><a href="/netease/photo/${n.photosetID}.html">${n.title }</a></c:if>
					  			<c:if test='${!empty n.url}'><a href="/netease/post/${n.postid}.html">${n.title }</a></c:if>
					  			<small>【${n.votecount}】</small>
							</h4>
							<small>${n.ptime}</small>
							<small>${n.source}</small>
							<p>
								<c:if test='${empty n.url}'><a href="/netease/photo/${n.photosetID}.html">${n.digest }</a></c:if>
					  			<c:if test='${!empty n.url}'><a href="/netease/post/${n.postid}.html">${n.digest }</a></c:if>
							</p>
						</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<c:import url="footer.jsp"/>
	</body>
</html>
