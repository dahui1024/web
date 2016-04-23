<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
   <meta charset="utf-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
   <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
   <meta name="description" content="门牙引力波，一张嘴我看到了门牙，一上网我看到了世界。${title }">
   <meta name="keywords" content="引力波,新闻,快报,网易新闻,今日头条,知乎日报,秒拍">
   <link rel="icon" href="/static/favicon.ico">
   <title>
		<c:if test="${empty title }">门牙引力波 - 一张嘴我看到了门牙，一上网我看到了世界。</c:if>
		<c:if test="${!empty title }">${title }</c:if>
   </title>
   <!-- Bootstrap core CSS -->
   <link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">

   <!-- Custom styles for this template -->
   <link href="/static/css/normalize.css" rel="stylesheet">
   <link href="/static/css/main.css" rel="stylesheet">

   <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
   <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
   <script src="/static/assets/js/ie-emulation-modes-warning.js"></script>

   <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
   <!--[if lt IE 9]>
     <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
     <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
   <![endif]-->
 </head>