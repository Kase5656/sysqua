<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=0">
<link rel="stylesheet" href="css/style.css" type="text/css"
	media="screen and (min-width: 640px)">
<link rel="stylesheet" href="css/mypage.css" type="text/css"
	media="screen and (min-width: 640px)">
<link rel="stylesheet" href="css/featherlight.css"
	media="screen and (min-width: 640px)">
<link rel="stylesheet" href="css/style_sp.css" type="text/css"
	media="screen and (max-width: 640px)">
<link rel="stylesheet" href="css/mypage_sp.css" type="text/css"
	media="screen and (max-width: 640px)">
<link rel="stylesheet" href="css/featherlight_sp.css"
	media="screen and (max-width: 640px)">
<script type="text/javascript" charset="UTF-8" src="js/change.js"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="js/featherlight.js"></script>
<script type="text/javascript">
	$(function() {
		$(".l_header").load("inclu/header4.jsp");
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
			<p id="headtitle">マイページ</p>
			<h3>以下は現在登録されている情報です。</h3>
			<form name="defaultLink" action="mypage.do" method="post">
				<input type="hidden" name="action" />
				<table class="check">
					<tr>
						<th class="paragraphbox">ID</th>
						<td class="paragraphbox">${account.accountId}</td>
					</tr>
					<tr>
						<th class="paragraphbox">パスワード</th>
						<td class="paragraphbox">****(セキュリティ保護の為、非表示)</td>
					</tr>
				</table>
				<c:if test="${account.accountAuthority == 2}">
					<table class="check">
						<tr>
							<th class="paragraphbox">氏名</th>
							<td class="paragraphbox">${education.educationName}</td>
						</tr>
						<tr>
							<th class="paragraphbox">氏名（カナ）</th>
							<td class="paragraphbox">${education.educationKanaName}</td>
						</tr>
						<tr>
							<th class="paragraphbox">性別</th>
							<c:if test="${education.educationGender == 0}" var="flg" />
							<c:if test="${flg}">
								<td class="paragraphbox">男</td>
							</c:if>
							<c:if test="${!flg}">
								<td class="paragraphbox">女</td>
							</c:if>
						</tr>
						<tr>
							<th class="paragraphbox">生年月日</th>
							<td class="paragraphbox">${education.educationBirthday}</td>
						</tr>
						<tr>
							<th class="paragraphbox">郵便番号</th>
							<td class="paragraphbox">${education.educationPostalcode}</td>
						</tr>
						<tr>
							<th class="paragraphbox">住所</th>
							<td class="paragraphbox">${education.educationAddress}</td>
						</tr>
						<tr>
							<th class="paragraphbox">電話番号</th>
							<td class="paragraphbox">${education.educationPhoneNumber}</td>
						</tr>
						<tr>
							<th class="paragraphbox">メールアドレス</th>
							<td class="paragraphbox">${education.educationEmailAddress}</td>
						</tr>
						<tr>
							<th class="paragraphbox">会社名</th>
							<td class="paragraphbox">${education.corporationName}</td>
						</tr>
						<tr>
							<th class="paragraphbox">入社年月日</th>
							<td class="paragraphbox">${education.enterningDate}</td>
						</tr>
						<tr>
							<th class="paragraphbox">4月役割</th>
							<td class="paragraphbox">${education.dutiesNameNo1}</td>
						</tr>
						<tr>
							<th class="paragraphbox">5月役割</th>
							<td class="paragraphbox">${education.dutiesNameNo2}</td>
						</tr>
						<tr>
							<th class="paragraphbox">6月役割</th>
							<td class="paragraphbox">${education.dutiesNameNo3}</td>
						</tr>
						<tr>
							<th class="paragraphbox">備考</th>
							<td class="paragraphbox"><pre>${education.educationRemarks}</pre></td>
						</tr>
					</table>
				</c:if>
				<br />
				<c:choose>
					<c:when test="${account.accountAuthority == 2}">
						<table class="button">
							<tr>
								<td>
									<p style="position: relative;">
										<input type="image" src="img/idpasschange.png"
											onclick="goSubmit(this.form, this);" name="AccountUpdate_btn"
											value="" alt="ID・パスワード変更">
									</p>
								</td>
								<td>
									<p style="position: relative;">
										<input type="image" src="img/basicinformationchange.png"
											onclick="goSubmit(this.form, this);"
											name="EducationUpdate_btn" value="" alt="基本情報変更">
									</p>
								</td>
							</tr>
						</table>
					</c:when>
					<c:otherwise>
						<table class="button2">
							<tr>
								<td>
									<p style="position: relative;">
										<input type="image" src="img/idpasschange.png"
											onclick="goSubmit(this.form, this);" name="AccountUpdate_btn"
											value="" alt="ID・パスワード変更">
									</p>
								</td>
							</tr>
						</table>
					</c:otherwise>
				</c:choose>
			</form>
		</div>
	</div>
	<div class="l_footer"></div>
</body>
</html>