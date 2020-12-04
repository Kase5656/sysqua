<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC>
<html>
<head>
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
			<p id="headtitle">アカウント情報削除</p>
			<ul class="stepBarTwoType clearfix">
				<li class="active"><span class="before"></span>確認 <span
					class="after"></span></li>
				<li><span class="before"></span>完了 <span class="after"></span>
				</li>
			</ul>
			<h3>
				削除するアカウント情報を確認してください。<br> ※アカウント情報を削除すると全ての関連するデータが削除されます※
			</h3>
			<form name="defaultLink2" action="account.do" method="post">
				<input type="hidden" name="action" />
				<table class="list">
					<thead class="scrollHead">
						<tr>
							<th class="educationName">受講生氏名</th>
							<th class="corporation">企業名</th>
							<th class="accountId">アカウントID</th>
							<th class="authority">権限</th>
							<th class="remarks">備考</th>
						</tr>
					</thead>
					<tbody class="scrollBody">
						<c:forEach var="account" items="${accountDeleteList}">
							<tr>
								<td class="educationName">${account.education.educationName}</td>
								<td class="corporation">${account.corporation.corporationName}</td>
								<td class="accountId">${account.accountId}</td>
								<c:if test="${account.accountAuthority==1}">
									<td class="authority">社員</td>
								</c:if>
								<c:if test="${account.accountAuthority==2}">
									<td class="authority">受講生</td>
								</c:if>
								<td class="remarks">${account.accountRemarks}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<br />
				<table class="button">
					<tr>
						<td>
							<p style="position: relative;">
								<input type="image" src="img/complete.png"
									onclick="goSubmit(this.form, this);"
									name="AccountDeleteComplete_btn" value="" alt="完了">
							</p>
						</td>
						<td>
							<p style="position: relative;">
								<input type="image" src="img/back-2.png"
									onclick="goSubmit(this.form, this);" name="InfAccount_btn"
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