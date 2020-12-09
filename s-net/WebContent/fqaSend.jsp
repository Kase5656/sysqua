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
<link rel="stylesheet" href="css/featherlight.css"
	media="screen and (min-width: 640px)">
<link rel="stylesheet" href="css/style_sp.css" type="text/css"
	media="screen and (max-width: 640px)">
<link rel="stylesheet" href="css/featherlight_sp.css"
	media="screen and (max-width: 640px)">
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
		<h3>お問い合わせ内容の入力</h3>
		<h5>
			下記を入力し、送信ボタンをクリックしてください。<br>折り返し、担当者よりご連絡いたします。
		</h5>
		<form name="defaultLink2" action="mail.do" method="post">
			<input type="hidden" name="action" />
			<c:if test="${errorList != NULL}" var="flg">
				<div class="errbox">
					<table class="err">
						<tr>
							<td><b>◆入力エラー◆</b></td>
						</tr>
						<c:forEach var="error" items="${errorList}">
							<tr>
								<td><p>&nbsp; ・${error}</p></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</c:if>
			<table class="text">
				<tr>
					<td><font size="2" color="red">※</font><font size="2">入力必須項目</font>
				</tr>
				<tr>
					<th class="paragraphbox">メールアドレス<font color="red">※</font></th>
					<td class="paragraphbox"><input type="text" name="Address_txt"
						value="${mailaddress}" /></td>
				</tr>
				<tr>
					<th class="paragraphbox">お問い合わせ内容<font color="red">※</font></th>
					<td class="paragraphbox"><input type="text" name="Content_txt"
						value="${content}" /></td>
				</tr>
			</table>
			<table class="button">
				<tr>
					<td>
						<p style="position: relative;">
							<input type="image" src="img/send.png"
								onclick="goSubmit(this.form, this);" name="Sendfqa_btn" value=""
								alt="送信">
						</p>
					</td>
					<td>
						<p style="position: relative;">
							<input type="image" src="img/back-2.png"
								onclick="goSubmit(this.form, this);" name="FqaBack_btn" value=""
								alt="戻る">
						</p>
					</td>

				</tr>
			</table>
		</form>
	</div>
	<div class="l_footer"></div>
</body>
</html>