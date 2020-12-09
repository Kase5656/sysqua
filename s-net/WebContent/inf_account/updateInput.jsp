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
				<li class="active"><span class="before"></span>入力 <span
					class="after"></span></li>
				<li><span class="before"></span>確認 <span class="after"></span>
				</li>
				<li><span class="before"></span>完了 <span class="after"></span>
				</li>
			</ul>
			<h3>アカウント情報を入力してください。</h3>
			<form name="defaultLink2" action="account.do" method="post">
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
				<table class="search">
					<tr>
						<th><font size="2" color="red">*</font><font size="2">入力必須項目</font></th>
					</tr>
					<tr>
						<th class="paragraphbox">会社名</th>
						<td class="paragraphbox"><input type="text"
							name="CorporationName_txt"
							value="${accountEditing.corporation.corporationName}" /></td>
					</tr>
					<tr>
						<th class="paragraphbox">アカウント名<font color="red">*</font></th>
						<td class="paragraphbox"><input type="text"
							placeholder="例) 田中太郎" name="accountName" maxlength="50" size="20"
							value="${aName}" required title="アカウント名は100文字まで入力可能です。" /></td>
					</tr>
					<tr>
						<th class="paragraphbox">ID<font color="red">*</font></th>
						<td class="paragraphbox"><input type="text"
							placeholder="例) SQT001" name="accountId" maxlength="100"
							size="40" value="${accountEditing.accountId}" required
							title="IDは100文字まで入力可能です。" /></td>
					</tr>
					<tr>
						<th class="paragraphbox">パスワード<font color="red">*</font></th>
						<td class="paragraphbox"><input type="password"
							placeholder="例) sqt3666" name="accountPassword" maxlength="50"
							size="20" value="${aPassword}" required
							title="パスワードは100文字まで入力可能です。" /></td>
					</tr>
					<tr>
						<th class="paragraphbox">パスワード再入力<font color="red">*</font></th>
						<td class="paragraphbox"><input type="password"
							placeholder="例) sqt3666" name="accountRePassword" maxlength="50"
							size="20" value="${arePassword}" required
							title="パスワードは100文字まで入力可能です。" /></td>
					</tr>
					<tr>
						<th class="paragraphbox">権限<font color="red">*</font></th>
						<td class="paragraphbox"><select name="accountAuthority"
							size="1">
								<option value="0">-選択してください-</option>
								<option value="1"
									${accountEditing.accountAuthority == "1" ? 'selected="selected"' : ''}>社員</option>
								<option value="2"
									${accountEditing.accountAuthority == "2" ? 'selected="selected"' : ''}>受講生</option>
						</select></td>
					</tr>
					<tr>
						<th class="paragraphbox">備考</th>
						<td class="paragraphbox"><textarea name="Remarks_txt"
								maxlength="300" cols="42" rows="5" aria-describedby=""
								aria-required="true">${accountEditing.accountRemarks}</textarea>
						</td>
					</tr>
				</table>
				<br />
				<table class="button">
					<tr>
						<td>
							<p style="position: relative;">
								<input type="image" src="img/check.png"
									onclick="goSubmit(this.form, this);"
									name="AccountUpdateCheck_btn" value="" alt="確認">
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