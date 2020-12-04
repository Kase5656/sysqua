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
<link rel="stylesheet" href="css/interview.css" type="text/css"
	media="screen and (min-width: 640px)">
<link rel="stylesheet" href="css/featherlight.css"
	media="screen and (min-width: 640px)">
<link rel="stylesheet" href="css/style_sp.css" type="text/css"
	media="screen and (max-width: 640px)">
<link rel="stylesheet" href="css/interview_sp.css" type="text/css"
	media="screen and (max-width: 640px)">
<link rel="stylesheet" href="css/featherlight_sp.css"
	media="screen and (max-width: 640px)">
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
						<th class="paragraphbox">面談日1</th>
						<td class="paragraphbox"><input type="date"
							name="InterviewDate1_txt" value="${interview.interviewDate1}"
							required title="面談日1を入力してください。" /></td>
					</tr>
					<tr>
						<th class="paragraphbox">面談相談内容1</th>
						<td class="paragraphbox"><textarea
								name="InterviewEduContents1_txt" maxlength="500" cols="40"
								rows="5" aria-describedby="" aria-required="true">${interview.interviewEduContents1}</textarea></td>
					</tr>
					<tr>
						<th class="paragraphbox">面談日2</th>
						<td class="paragraphbox"><input type="date"
							name="InterviewDate2_txt" value="${interview.interviewDate2}"
							required title="面談日2を入力してください。" /></td>
					</tr>
					<tr>
						<th class="paragraphbox">面談相談内容2</th>
						<td class="paragraphbox"><textarea
								name="InterviewEduContents2_txt" maxlength="500" cols="40"
								rows="5" aria-describedby="" aria-required="true">${interview.interviewEduContents2}</textarea></td>
					</tr>
					<tr>
						<th class="paragraphbox">面談日3</th>
						<td class="paragraphbox"><input type="date"
							name="InterviewDate3_txt" value="${interview.interviewDate3}"
							required title="面談日3を入力してください。" /></td>
					</tr>
					<tr>
						<th class="paragraphbox">面談相談内容3</th>
						<td class="paragraphbox"><textarea
								name="InterviewEduContents3_txt" maxlength="500" cols="40"
								rows="5" aria-describedby="" aria-required="true">${interview.interviewEduContents3}</textarea></td>
					</tr>
				</table>
				<br />
				<table class="button">
					<tr>
						<td>
							<p style="position: relative;">
								<input type="image" src="img/check.png"
									onclick="goSubmit(this.form, this);"
									name="InterviewEducationRegisterCheck_btn" value="" alt="確認">
							</p>
						</td>
						<td>
							<p style="position: relative;">
								<input type="image" src="img/back-2.png"
									onclick="goSubmit(this.form, this);"
									name="EducationDetailSearch_btn" value="" alt="戻る">
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