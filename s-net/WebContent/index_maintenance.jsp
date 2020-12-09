<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
<%
	session.invalidate();
%>
<head>
<meta name="robots" content="noindex">
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=0">
<link rel="stylesheet" href="css/style.css" type="text/css"
	media="screen and (min-width: 640px)">
<link rel="stylesheet" href="css/index.css" type="text/css"
	media="screen and (min-width: 640px)">
<link rel="stylesheet" href="css/featherlight.css"
	media="screen and (min-width: 640px)">
<link rel="stylesheet" href="css/style_sp.css" type="text/css"
	media="screen and (max-width: 640px)">
<link rel="stylesheet" href="css/index_sp.css" type="text/css"
	media="screen and (max-width: 640px)">
<link rel="stylesheet" href="css/featherlight_sp.css"
	media="screen and (max-width: 640px)">
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="js/featherlight.js"></script>
<script type="text/javascript" charset="UTF-8" src="js/modal.js"></script>
<script type="text/javascript">
	$(function() {
		$(".l_header").load("inclu/header3.jsp");
		$(".l_footer").load("inclu/footer.jsp");
	});
</script>
<title>RMS|新入社員管理システム</title>
</head>
<body>
	<header id="global-header">
		<div id="head-inner">
			<div class="l_header"></div>
		</div>
		<div id="menu-bar"></div>
	</header>
	<div id="maintenance"
		style="position: relative; top: 60px; margin-left: auto; margin-right: auto;">
		<div style="border: 2px solid #000000; text-align: center;">
			<h2 style="color: red;">メンテナンス及びバージョンアップについて</h2>
			現在、メンテナンス及びバージョンアップ対応中です。<br> <br>
			期間：2020年5月15日（土）～5月16日（日）<br> ※日時は予告なく変更する場合がございます。 <br> <br>
			ご利用いただいております皆様にはご不便をおかけいたします。<br> 何卒ご容赦いただきますようお願い申し上げます。<br>
			<br>
		</div>
	</div>
	<div class="l_footer"></div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</body>
</html>