<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC>
<html>
<head>
<meta name="robots" content="noindex">
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=0">
<link rel="stylesheet" href="css/style.css" type="text/css"
	media="screen and (min-width: 640px)">
<link rel="stylesheet" href="css/attendance.css" type="text/css"
	media="screen and (min-width: 640px)">
<link rel="stylesheet" href="css/featherlight.css"
	media="screen and (min-width: 640px)">
<link rel="stylesheet" href="css/style_sp.css" type="text/css"
	media="screen and (max-width: 640px)">
<link rel="stylesheet" href="css/attendance_sp.css" type="text/css"
	media="screen and (max-width: 640px)">
<link rel="stylesheet" href="css/featherlight_sp.css"
	media="screen and (max-width: 640px)">
<script type="text/javascript" charset="UTF-8" src="js/change.js"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="js/featherlight.js"></script>
<script type="text/javascript">
	$(function() {
		$(".l_header").load("inclu/header.jsp");
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
	<div id="scrollframe">
		<div class="form">
			<br />
			<c:choose>
				<c:when test="${jspId == 0}">
					<p id="headtitle">出勤情報登録</p>
				</c:when>
				<c:otherwise>
					<p id="headtitle">退勤情報登録</p>
				</c:otherwise>
			</c:choose>
			<ul class="stepBarThreeType clearfix">
				<li><span class="before"></span>入力 <span class="after"></span>
				</li>
				<li><span class="before"></span>確認 <span class="after"></span></li>
				<li class="active"><span class="before"></span>完了 <span
					class="after"></span></li>
			</ul>
			<c:choose>
				<c:when test="${jspId == 0}">
					<h3>
						出勤情報の登録が完了しました。<br>ブラウザバックで戻らないでください。
					</h3>
				</c:when>
				<c:otherwise>
					<h3>
						退勤情報の登録が完了しました。<br>ブラウザバックで戻らないでください。
					</h3>
				</c:otherwise>
			</c:choose>
			<form name="defaultLink" action="attendance.do" method="post">
				<input type="hidden" name="action" />
				<table class="button2">
					<tr>
						<td>
							<p style="position: relative;">
								<input type="image" src="img/top.png"
									onclick="goSubmit(this.form, this);"
									name="EducationTopSearch_btn" value="" alt="TOP">
							</p>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="l_footer"></div>
</body>
</html>