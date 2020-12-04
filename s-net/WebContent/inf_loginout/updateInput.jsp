<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css" type="text/css">
<link rel="stylesheet" href="css/loginout.css" type="text/css">
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
			<div class="l_header"></div>
		</div>
		<div id="menu-bar"></div>
	</header>
	<div id="scrollframe">
		<div class="form">
			<br />
			<p id="headtitle">ログイン情報変更</p>
			<ul class="stepBarThreeType clearfix">
				<li class="active"><span class="before"></span>入力 <span
					class="after"></span></li>
				<li><span class="before"></span>確認 <span class="after"></span></li>
				<li><span class="before"></span>完了 <span class="after"></span>
				</li>
			</ul>
			<h3>登録するログイン情報を入力してください。</h3>
			<form name="defaultLink" action="loginout.do" method="post">
				<input type="hidden" name="action" />
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
				<table class="text">
					<tr>
						<td><font size="2" color="red">※</font><font size="2">入力必須項目</font>
					</tr>
					<tr>
						<th class="paragraphbox">ID<font color="red">※</font></th>
						<td class="paragraphbox"><input type="text"
							name="LoginId_txt" value="${login.loginId}" maxlength='8'
							required /></td>
					</tr>
					<tr>
						<th class="paragraphbox">パスワード<font color="red">※</font></th>
						<td class="paragraphbox"><input type="password"
							name="Password_txt" value="${login.loginPassword}" maxlength='12'
							required /></td>
					</tr>
					<tr>
						<th class="paragraphbox">パスワード再入力<font color="red">※</font></th>
						<td class="paragraphbox"><input type="password"
							name="Repassword_txt" value="${login.loginRePassword}"
							maxlength='12' required /></td>
					</tr>
				</table>
				<table class="button">
					<tr>
						<td>
							<p style="position: relative;">
								<input type="image" src="img/check.png"
									onclick="goSubmit(this.form, this);"
									name="LoginRegisterCheck_btn" value="" alt="確認">
							</p>
						</td>
						<td>
							<p style="position: relative;">
								<input type="image" src="img/back-2.png"
									onclick="goSubmit(this.form, this);" name="LoginBack_btn"
									value="" alt="戻る">
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