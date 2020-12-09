<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC>
<html>
<head>
<meta name="robots" content="noindex">
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css" type="text/css">
<link rel="stylesheet" href="css/account.css" type="text/css">
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
	<div id="scrollframe2">
		<div class="form">
			<br />
			<p id="headtitle">アカウント情報登録</p>
			<ul class="stepBarThreeType clearfix">
				<li><span class="before"></span>入力 <span class="after"></span></li>
				<li><span class="before"></span>確認 <span class="after"></span></li>
				<li class="active"><span class="before"></span>完了 <span
					class="after"></span></li>
			</ul>
			<h3>アカウント情報の登録が完了しました。</h3>
			<c:if test="${buttonflg==0}">
				<form name="defaultLink" action="account.do" method="post">
					<input type="hidden" name="action" />
					<table class="button">
						<tr>
							<td>
								<p style="position: relative;">
									<input type="image" src="" onclick="goSubmit(this.form, this);"
										name="InfAccount_btn" value="" alt="アカウント情報一覧">
								</p>
							</td>
						</tr>
					</table>
				</form>
			</c:if>
			<c:if test="${buttonflg==1}">
				<form name="defaultLink" action="education.do" method="post">
					<input type="hidden" name="action" />
					<table class="button2">
						<tr>
							<td>
								<p style="position: relative;">
									<input type="image" src="img/educationregister.png"
										onclick="goSubmit(this.form, this);"
										name="EducationRegister_btn" value="" alt="受講生情報登録">
								</p>
							</td>
						</tr>
					</table>
				</form>
			</c:if>
		</div>
	</div>
	<div class="l_footer"></div>
</body>
</html>