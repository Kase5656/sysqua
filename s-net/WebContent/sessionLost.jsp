<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.util.*"%>
<%
	//ブラウザのキャッシュを無効にする。
	//Last-Modified(最終更新日) : 本日
	//Expires(有効期限)         : 過去日(1970/01/01)
	//pragma no-cache           : HTTP1.0仕様に基づく「キャッシュ無効指示」
	//Cache-Control no-cache    : HTTP1.1仕様に基づく「キャッシュ無効指示」
	java.util.Calendar objCal1 = java.util.Calendar.getInstance();
	java.util.Calendar objCal2 = java.util.Calendar.getInstance();
	objCal2.set(1970, 0, 1, 0, 0, 0);
	response.setDateHeader("Last-Modified", objCal1.getTime().getTime());
	response.setDateHeader("Expires", objCal2.getTime().getTime());
	response.setHeader("Proama", "no-cache");
	response.setHeader("Cache-Control", "no-cache");
	session.invalidate();
%>
<!DOCTYPE HTML PUBLIC>
<html>
<head>
<meta name="robots" content="noindex">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=0">
<link rel="stylesheet" href="css/style.css" type="text/css" media="screen and (min-width: 640px)">
<link rel="stylesheet" href="css/featherlight.css" media="screen and (min-width: 640px)">
<link rel="stylesheet" href="css/style_sp.css" type="text/css" media="screen and (max-width: 640px)">
<link rel="stylesheet" href="css/featherlight_sp.css" media="screen and (max-width: 640px)">
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
	<div id="scrollframe2">
		<br />
		<p id="headtitle">エラー</p>
		<br>
		<h3>
			セッションが無効です。お手数ですが、再度ログインしてください。<br> <br> 考えられる原因：<br>
			ログイン後操作をしないまま30分以上が経過した<br> 通常とは異なる操作でこのページにアクセスした
		</h3>
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