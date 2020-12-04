<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css" type="text/css">
<link rel="stylesheet" href="css/password.css" type="text/css">
<link rel="stylesheet" href="css/featherlight.css">
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
			<img id="head-img-logo" src="img/headmain.png">
		</div>
		<div id="menu-bar"></div>
	</header>
	<form name="defaultLink2" action="password.do" method="post">
		<input type="hidden" name="action" />
		<div id="body-layout">
			<c:if test="${errorList != NULL}" var="flg">
				<table class="errbox">
					<tr>
						<td><b>◆入力内容に誤りがあります。</b></td>
					</tr>
				</table>
				<table class="errbox2">
					<c:forEach var="error" items="${errorList}">
						<tr>
							<td><p class="err">&nbsp;・ ${error}</p></td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
			<div id="scrollframe">
				<br />
				<p id="headtitle">パスワード再設定</p>
				<table class="text">
					<tr>
						<th class="paragraphbox">新しいパスワード</th>
						<td class="paragraphbox"><input type="text"
							name="Password_txt" value="${Password}" size="40" /></td>
					</tr>
					<tr>
						<th class="paragraphbox">新しいパスワード（再入力）</th>
						<td class="paragraphbox"><input type="text"
							name="RePassword_txt" value="${RePassword}" size="40" /></td>
					</tr>
				</table>
			</div>
			<table class="button">
				<tr>
					<td>
						<p style="position: relative;">
							<input type="image" src="img/login.png"
								style="width: 105px; height: 35px;"
								onclick="goSubmit(this.form, this);" name="Password_btn"
								value="" alt="再設定">
						</p>
					</td>
				</tr>
			</table>
		</div>
	</form>
	<div class="l_footer"></div>
</body>
</html>