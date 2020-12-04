<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css" type="text/css">
<link rel="stylesheet" href="css/corporation.css" type="text/css">
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
			<p id="headtitle">企業情報変更</p>
			<ul class="stepBarThreeType clearfix">
				<li class="active"><span class="before"></span>入力 <span
					class="after"></span></li>
				<li><span class="before"></span>確認 <span class="after"></span>
				</li>
				<li><span class="before"></span>完了 <span class="after"></span>
				</li>
			</ul>
			<h3>変更する企業情報を入力してください。</h3>
			<form name="defaultLink2" action="corporation.do" method="post">
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
						<td><font size="2" color="red">※</font><font size="2">入力必須項目</font>
					</tr>
					<tr>
						<th class="paragraphbox">企業名<font color="red">※</font></th>
						<td class="paragraphbox"><input type="text"
							placeholder="例) 株式企業システムクォート" name="CorporationName_txt"
							maxlength="50" size="40" value="${corporation.corporationName}"
							required /></td>
					</tr>
					<tr>
						<th class="paragraphbox">企業名（カナ）<font color="red">※</font></th>
						<td class="paragraphbox"><input type="text"
							placeholder="例) カブシキガイシャシステムクォート" name="CorporationKanaName_txt"
							maxlength="50" size="40"
							value="${corporation.corporationKanaName}" required /></td>
					</tr>
					<tr>
						<th class="paragraphbox">郵便番号<font color="red">※</font></th>
						<td class="paragraphbox"><input type="text"
							placeholder="例) 102-0071" name="CorporationPostalcode_txt"
							maxlength="10" size="10"
							value="${corporation.corporationPostalcode}" required /></td>
					</tr>
					<tr>
						<th class="paragraphbox">住所<font color="red">※</font></th>
						<td class="paragraphbox"><input type="text"
							placeholder="例) 東京都千代田区富士見1丁目1番8号" name="CorporationAddress_txt"
							maxlength="50" size="50"
							value="${corporation.corporationAddress}" required /></td>
					</tr>
					<tr>
						<th class="paragraphbox">電話番号<font color="red">※</font></th>
						<td class="paragraphbox"><input type="text"
							placeholder="例) 03-3239-3666" name="CorporationTel_txt"
							maxlength="10" size="11" value="${corporation.corporationTel}"
							required /></td>
					</tr>
					<tr>
						<th class="paragraphbox">FAX番号</th>
						<td class="paragraphbox"><input type="text"
							placeholder="例) 03-3239-3677" name="CorporationFax_txt"
							maxlength="10" size="11" value="${corporation.corporationFax}" /></td>
					</tr>
					<tr>
						<th class="paragraphbox">役職</th>
						<td class="paragraphbox"><input type="text"
							placeholder="例) 代表取締役" name="CorporationRepresentative_txt"
							maxlength="50" size="40"
							value="${corporation.corporationRepresentative}" /></td>
					</tr>
					<tr>
						<th class="paragraphbox">代表者名<font color="red">※</font></th>
						<td class="paragraphbox"><input type="text"
							placeholder="例) システム太郎" name="CorporationRepresentativeName_txt"
							maxlength="50" size="40"
							value="${corporation.corporationRepresentativeName}" required /></td>
					</tr>
				</table>
				<br />
				<table class="button">
					<tr>
						<td>
							<p style="position: relative;">
								<input type="image" src="img/check.png"
									onclick="goSubmit(this.form, this);"
									name="CorporationUpdateCheck_btn" value="" alt="確認">
							</p>
						</td>
						<td>
							<p style="position: relative;">
								<input type="image" src="img/back-2.png"
									onclick="goSubmit(this.form, this);" name="InfCorporation_btn"
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