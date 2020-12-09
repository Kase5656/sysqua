<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC>
<html>
<head>
<meta name="robots" content="noindex">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="0">
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=0">
<link rel="stylesheet" href="css/style.css" type="text/css" media="screen and (min-width: 640px)">
<link rel="stylesheet" href="css/style_sp.css" type="text/css" media="screen and (max-width: 640px)">
<link rel="stylesheet" href="css/style.css" type="text/css">
<script type="text/javascript" charset="UTF-8" src="js/load.js"></script>
<link rel="stylesheet" href="css/featherlight.css">
<script type="text/javascript" charset="UTF-8" src="js/change.js"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="js/featherlight.js"></script>
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
	<div id="scrollframe">
		<div class="search">
			<br />
			<p id="headtitle">ログアウト</p>
			<br />
			<ul class="stepBarOneType clearfix">
				<li class="active"><span class="before"></span>完了 <span
					class="after"></span></li>
			</ul>
			<h3>
				ログアウトしました。再度ログインする場合は、<br /> 下記ボタンよりログイン画面へ進んでください。
			</h3>
			<form name="defaultLink" action="loginout.do" method="post">
				<input type="hidden" name="action" />
				<table class="button2">
					<tr>
						<td>
							<p style="position: relative;">
								<input type="image" src="img/login.png"
									onclick="goSubmit2(this.form, this);" name="LoginBack_btn"
									value="" alt="ログイン">
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