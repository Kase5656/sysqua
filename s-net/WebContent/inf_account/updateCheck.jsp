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
			<p id="headtitle">アカウント情報変更</p>
			<ul class="stepBarThreeType clearfix">
				<li><span class="before"></span>入力 <span class="after"></span></li>
				<li class="active"><span class="before"></span>確認 <span
					class="after"></span></li>
				<li><span class="before"></span>完了 <span class="after"></span>
				</li>
			</ul>
			<h3>アカウント情報を確認してください。</h3>
			<form name="defaultLink2" action="account.do" method="post">
				<input type="hidden" name="action" />
				<table class="search">
					<tr>
						<th><font size="2" color="red">*</font><font size="2">入力必須項目</font></th>
					</tr>
					<tr>
						<th class="paragraphbox">会社名<font color="red">*</font></th>
						<td class="paragraphbox">${accountEditing.corporation.corporationName}</td>
					</tr>
					<tr>
						<th class="paragraphbox">アカウント名<font color="red">*</font></th>
						<td class="paragraphbox">${aName}</td>
					</tr>
					<tr>
						<th class="paragraphbox">ID<font color="red">*</font></th>
						<td class="paragraphbox">${accountEditing.accountId}</td>
					</tr>
					<tr>
						<th class="paragraphbox">パスワード<font color="red">*</font></th>
						<td class="paragraphbox">${aPassword}</td>
					</tr>
					<tr>
						<th class="paragraphbox">権限<font color="red">*</font></th>
						<td class="paragraphbox"><c:if
								test="${accountEditing.accountAuthority == 1}">社員</c:if> <c:if
								test="${accountEditing.accountAuthority == 2}">受講生</c:if></td>
					</tr>
					<tr>
						<th class="paragraphbox">備考</th>
						<td class="paragraphbox"><pre>${accountEditing.accountRemarks}</pre></td>
					</tr>
				</table>
				<br />
				<table class="button">
					<tr>
						<td>
							<p style="position: relative;">
								<input type="image" src="img/complete.png"
									onclick="goSubmit(this.form, this);"
									name="AccountUpdateComplete_btn" value="" alt="完了">
							</p>
						</td>
						<td>
							<p style="position: relative;">
								<input type="image" src="img/back-2.png"
									onclick="goSubmit(this.form, this);"
									name="AccountUpdateInput_btn" value="" alt="戻る">
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