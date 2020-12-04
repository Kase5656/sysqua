<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css" type="text/css">
<link rel="stylesheet" href="css/education.css" type="text/css">
<link rel="stylesheet" href="css/featherlight.css">
<script type="text/javascript" charset="UTF-8" src="js/change.js"></script>
<script src="https://ajaxzip3.github.io/ajaxzip3.js" charset="UTF-8"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="js/featherlight.js"></script>
<script type="text/javascript">
	$(function() {
		$(".l_header").load("inclu/header2.jsp");
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
			<p id="headtitle">受講生情報登録</p>
			<ul class="stepBarThreeType clearfix">
				<li class="active"><span class="before"></span>入力 <span
					class="after"></span></li>
				<li><span class="before"></span>確認 <span class="after"></span>
				</li>
				<li><span class="before"></span>完了 <span class="after"></span>
				</li>
			</ul>
			<h3>登録する受講生情報を入力してください。</h3>
			<form name="defaultLink" action="education.do" method="post">
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
						<th class="paragraphbox">氏名<font color="red">※</font></th>
						<td class="paragraphbox"><input type="text"
							placeholder="例) 田中太郎" name="EducationName_txt" maxlength="50"
							size="20" value="${education.educationName}" required
							title="氏名は100文字まで入力可能です。" /></td>
					</tr>
					<tr>
						<th class="paragraphbox">氏名(カナ)<font color="red">※</font></th>
						<td class="paragraphbox"><input type="text"
							placeholder="例) タナカタロウ" name="EducationKanaName_txt"
							maxlength="100" size="40" value="${education.educationKanaName}"
							required title="氏名（カナ）は100文字まで入力可能です。" /></td>
					</tr>
					<tr>
						<th class="paragraphbox">性別</th>
						<td class="paragraphbox"><c:choose>
								<c:when test="${education.educationGender == 0}">
									<input type="radio" name="Gender_rdo" value="0" checked>男
								</c:when>
								<c:otherwise>
									<input type="radio" name="Gender_rdo" value="0">男
								</c:otherwise>
							</c:choose> <c:choose>
								<c:when test="${education.educationGender == 1}">
									<input type="radio" name="Gender_rdo" value="1" checked>女
								</c:when>
								<c:otherwise>
									<input type="radio" name="Gender_rdo" value="1">女
								</c:otherwise>
							</c:choose></td>
					</tr>
					<tr>
						<th class="paragraphbox">生年月日<font color="red">※</font></th>
						<td class="paragraphbox"><input type="date"
							name="Birthday_txt" value="${education.educationBirthday}"
							required title="生年月日を入力してください。" /></td>
					</tr>
					<tr>
						<th class="paragraphbox">郵便番号<font color="red">※</font></th>
						<td class="paragraphbox"><input type="text"
							placeholder="例) 000-0000" name="PostalCode_txt" maxlength="8"
							size="10"
							onKeyUp="AjaxZip3.zip2addr(this,'','Address_txt','Address_txt');"
							value="${education.educationPostalcode}" required /></td>
					</tr>
					<tr>
						<th class="paragraphbox">住所<font color="red">※</font></th>
						<td class="paragraphbox"><input type="text"
							placeholder="例) 東京都○○区○○町" name="Address_txt" maxlength="50"
							size="40" value="${education.educationAddress}" required /></td>
					</tr>
					<tr>
						<th class="paragraphbox">電話番号<font color="red">※</font></th>
						<td class="paragraphbox"><input type="tel"
							style="width: 14em" name="Phone_txt" maxlength="13" size="14"
							placeholder="例) 080-1234-5678"
							value="${education.educationPhoneNumber}" required
							title="電話番号を入力してください。" /></td>
					</tr>
					<tr>
						<th class="paragraphbox">メールアドレス<font color="red">※</font></th>
						<td class="paragraphbox"><input type="text"
							placeholder="例) xxx@xxx.xxx" name="EmailAddress_txt"
							maxlength="100" size="30"
							value="${education.educationEmailAddress}" required
							title="メールアドレスは100文字まで入力可能です。" /></td>
					</tr>
					<tr>
						<th class="paragraphbox">企業名</th>
						<td class="paragraphbox"><input type="text"
							name="CorporationName_txt"
							value="${education.corporation.corporationName}" disabled /></td>
					</tr>
					<tr>
						<th class="paragraphbox">入社年月日<font color="red">※</font></th>
						<td class="paragraphbox"><input type="date"
							name="EnterningDate_txt" value="${education.enterningDate}"
							required title="入社年月日を入力してください。" /></td>
					</tr>
					<tr>
						<th class="paragraphbox">4月役割</th>
						<td class="paragraphbox"><select name="Duties_cmb1" size="1">
								<option value="0">-選択してください-</option>
								<c:forEach var="duties" items="${dutiesList}" varStatus="loop">
									<option value="${duties.dutiesNo}/${duties.dutiesName}"
										${education.dutiesNo1 == duties.dutiesNo ?
										'selected="selected"' : ''}>${duties.dutiesName}
									</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<th class="paragraphbox">5月役割</th>
						<td class="paragraphbox"><select name="Duties_cmb2" size="1">
								<option value="0">-選択してください-</option>
								<c:forEach var="duties" items="${dutiesList}" varStatus="loop">
									<option value="${duties.dutiesNo}/${duties.dutiesName}"
										${education.dutiesNo2 == duties.dutiesNo ?
										'selected="selected"' : ''}>${duties.dutiesName}
									</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<th class="paragraphbox">6月役割</th>
						<td class="paragraphbox"><select name="Duties_cmb3" size="1">
								<option value="0">-選択してください-</option>
								<c:forEach var="duties" items="${dutiesList}" varStatus="loop">
									<option value="${duties.dutiesNo}/${duties.dutiesName}"
										${education.dutiesNo3 == duties.dutiesNo ?
										'selected="selected"' : ''}>${duties.dutiesName}
									</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<th class="paragraphbox">備考</th>
						<td class="paragraphbox"><textarea name="Remarks_txt"
								maxlength="300" cols="40" rows="5" aria-describedby=""
								aria-required="true">${education.educationRemarks}</textarea></td>
					</tr>
				</table>
				<br />
				<table class="button2">
					<tr>
						<td>
							<p style="position: relative;">
								<input type="image" src="img/check.png"
									onclick="goSubmit(this.form, this);"
									name="EducationRegisterCheck_btn" value="" alt="確認">
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