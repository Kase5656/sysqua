<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC>
<html>
<head>
<meta name="robots" content="noindex">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=0">
<link rel="stylesheet" href="css/style.css" type="text/css" media="screen and (min-width: 640px)">
<link rel="stylesheet" href="css/top.css" type="text/css" media="screen and (min-width: 640px)">
<link rel="stylesheet" href="css/featherlight.css" media="screen and (min-width: 640px)">
<link rel="stylesheet" href="css/style_sp.css" type="text/css" media="screen and (max-width: 640px)">
<link rel="stylesheet" href="css/top_sp.css" type="text/css" media="screen and (max-width: 640px)">
<link rel="stylesheet" href="css/featherlight_sp.css" media="screen and (max-width: 640px)">
<script type="text/javascript" charset="UTF-8" src="js/change.js"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="js/featherlight.js"></script>
<script type="text/javascript">
	$(function() {
		$(".l_header").load("inclu/header2.jsp");
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
		<br />
		<p id="headtitle">パスワード再設定</p>
		<h3>パスワードの再設定が完了いたしました。再度ログインをしてください。</h3>
		<form name="defaultLink2" action="mail.do" method="post">
			<input type="hidden" name="action" />
			<table class="button2">
				<tr>
					<td>
						<p style="position: relative;">
							<input type="image" src="img/login.png"
								onclick="goSubmit(this.form, this);" name="Login_btn" value=""
								alt="ログイン">
						</p>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div class="l_footer"></div>
</body>
</html>