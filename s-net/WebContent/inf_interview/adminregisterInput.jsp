<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css" type="text/css">
<link rel="stylesheet" href="css/interview.css" type="text/css">
<link rel="stylesheet" href="css/featherlight.css">
<script type="text/javascript" charset="UTF-8" src="js/change.js"></script>
<script src="https://ajaxzip3.github.io/ajaxzip3.js" charset="UTF-8"></script>
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
			<p id="headtitle">面談情報登録</p>
			<ul class="stepBarThreeType clearfix">
				<li class="active"><span class="before"></span>入力 <span
					class="after"></span></li>
				<li><span class="before"></span>確認 <span class="after"></span>
				</li>
				<li><span class="before"></span>完了 <span class="after"></span>
				</li>
			</ul>
			<h3>登録する面談情報を入力してください。</h3>
			<form name="defaultLink" action="interview.do" method="post">
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
						<th class="paragraphbox">氏名</th>
						<td class="paragraphbox"><select name="Education_cmb"
							size="1">
								<option value="0">-選択してください-</option>
								<c:forEach var="education" items="${education}" varStatus="loop">
									<option
										value="${education.accountNo}/${education.corporationNo}/${education.educationName}"
										${education.accountNo == interview.accountNo ?
											'selected="selected"' : ''}>${education.educationName}
									</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<th class="paragraphbox">面談者情報</th>
						<td class="paragraphbox"><textarea
								name="AccountInformation_txt" maxlength="500" cols="40" rows="5"
								aria-describedby="" aria-required="true">${interview.accountInformation}</textarea></td>
					</tr>
					<tr>
						<th class="paragraphbox">面談日1</th>
						<td class="paragraphbox"><input type="date"
							name="InterviewDate1_txt" value="${interview.interviewDate1}"
							required title="面談日1を入力してください。" /></td>
					</tr>
					<tr>
						<th class="paragraphbox">面談相談内容1（受講生）</th>
						<td class="paragraphbox"><textarea
								name="InterviewEduContents1_txt" maxlength="500" cols="40"
								rows="5" aria-describedby="" aria-required="true"
								disabled="disabled">${interview.interviewEduContents1}</textarea></td>
					</tr>
					<tr>
						<th class="paragraphbox">面談相談内容1（研修担当）</th>
						<td class="paragraphbox"><textarea
								name="InterviewTraContents1_txt" maxlength="500" cols="40"
								rows="5" aria-describedby="" aria-required="true">${interview.interviewTraContents1}</textarea></td>
					</tr>
					<tr>
						<th class="paragraphbox">面談内容1</th>
						<td class="paragraphbox"><textarea
								name="InterviewContents1_txt" maxlength="500" cols="40" rows="5"
								aria-describedby="" aria-required="true">${interview.interviewContents1}</textarea></td>
					</tr>
					<tr>
						<th class="paragraphbox">面談日2</th>
						<td class="paragraphbox"><input type="date"
							name="InterviewDate2_txt" value="${interview.interviewDate2}"
							required title="面談日2を入力してください。" /></td>
					</tr>
					<tr>
						<th class="paragraphbox">面談相談内容2（受講生）</th>
						<td class="paragraphbox"><textarea
								name="InterviewEduContents2_txt" maxlength="500" cols="40"
								rows="5" aria-describedby="" aria-required="true"
								disabled="disabled">${interview.interviewEduContents2}</textarea></td>
					</tr>
					<tr>
						<th class="paragraphbox">面談相談内容2（研修担当）</th>
						<td class="paragraphbox"><textarea
								name="InterviewTraContents2_txt" maxlength="500" cols="40"
								rows="5" aria-describedby="" aria-required="true">${interview.interviewTraContents2}</textarea></td>
					</tr>
					<tr>
						<th class="paragraphbox">面談内容2</th>
						<td class="paragraphbox"><textarea
								name="InterviewContents2_txt" maxlength="500" cols="40" rows="5"
								aria-describedby="" aria-required="true">${interview.interviewContents2}</textarea></td>
					</tr>
					<tr>
						<th class="paragraphbox">面談日3</th>
						<td class="paragraphbox"><input type="date"
							name="InterviewDate3_txt" value="${interview.interviewDate3}"
							required title="面談日3を入力してください。" /></td>
					</tr>
					<tr>
						<th class="paragraphbox">面談相談内容3（受講生）</th>
						<td class="paragraphbox"><textarea
								name="InterviewEduContents3_txt" maxlength="500" cols="40"
								rows="5" aria-describedby="" aria-required="true"
								disabled="disabled">${interview.interviewEduContents3}</textarea></td>
					</tr>
					<tr>
						<th class="paragraphbox">面談相談内容3（研修担当）</th>
						<td class="paragraphbox"><textarea
								name="InterviewTraContents3_txt" maxlength="500" cols="40"
								rows="5" aria-describedby="" aria-required="true">${interview.interviewTraContents3}</textarea></td>
					</tr>
					<tr>
						<th class="paragraphbox">面談内容3</th>
						<td class="paragraphbox"><textarea
								name="InterviewContents3_txt" maxlength="500" cols="40" rows="5"
								aria-describedby="" aria-required="true">${interview.interviewContents3}</textarea></td>
					</tr>
				</table>
				<br />
				<table class="button">
					<tr>
						<td>
							<p style="position: relative;">
								<input type="image" src="img/back-2.png"
									onclick="goSubmit(this.form, this);" name="InfInterview_btn"
									value="" alt="戻る">
							</p>
						</td>
						<td>
							<p style="position: relative;">
								<input type="image" src="img/check.png"
									onclick="goSubmit(this.form, this);"
									name="InterviewRegisterCheck_btn" value="" alt="確認">
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