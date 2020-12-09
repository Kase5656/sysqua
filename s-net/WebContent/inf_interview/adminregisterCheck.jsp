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
<link rel="stylesheet" href="css/interview.css" type="text/css">
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
			<p id="headtitle">面談情報登録</p>
			<ul class="stepBarThreeType clearfix">
				<li><span class="before"></span>入力 <span class="after"></span>
				</li>
				<li class="active"><span class="before"></span>確認 <span
					class="after"></span></li>
				<li><span class="before"></span>完了 <span class="after"></span>
				</li>
			</ul>
			<h3>登録する面談情報を確認してください。</h3>
			<form name="defaultLink" action="interview.do" method="post">
				<input type="hidden" name="action" />
				<table class="check">
					<tr>
						<th class="paragraphbox">氏名</th>
						<td class="paragraphbox">${interview.educationName}</td>
					</tr>
					<tr>
						<th class="paragraphbox">面談者情報</th>
						<td class="paragraphbox"><pre>${interview.accountInformation}</pre></td>
					</tr>
					<tr>
						<th class="paragraphbox">面談日1</th>
						<td class="paragraphbox">${interview.interviewDate1}</td>
					</tr>
					<tr>
						<th class="paragraphbox">面談相談内容1（受講生）</th>
						<td class="paragraphbox"><pre>${interview.interviewEduContents1}</pre></td>
					</tr>
					<tr>
						<th class="paragraphbox">面談相談内容1（研修担当）</th>
						<td class="paragraphbox"><pre>${interview.interviewTraContents1}</pre></td>
					</tr>
					<tr>
						<th class="paragraphbox">面談内容1</th>
						<td class="paragraphbox"><pre>${interview.interviewContents1}</pre></td>
					</tr>
					<tr>
						<th class="paragraphbox">面談日2</th>
						<td class="paragraphbox">${interview.interviewDate2}</td>
					</tr>
					<tr>
						<th class="paragraphbox">面談相談内容2（受講生）</th>
						<td class="paragraphbox"><pre>${interview.interviewEduContents2}</pre></td>
					</tr>
					<tr>
						<th class="paragraphbox">面談相談内容2（研修担当）</th>
						<td class="paragraphbox"><pre>${interview.interviewTraContents2}</pre></td>
					</tr>
					<tr>
						<th class="paragraphbox">面談内容2</th>
						<td class="paragraphbox"><pre>${interview.interviewContents2}</pre></td>
					</tr>
					<tr>
						<th class="paragraphbox">面談日3</th>
						<td class="paragraphbox">${interview.interviewDate3}</td>
					</tr>
					<tr>
						<th class="paragraphbox">面談相談内容3（受講生）</th>
						<td class="paragraphbox"><pre>${interview.interviewEduContents3}</pre></td>
					</tr>
					<tr>
						<th class="paragraphbox">面談相談内容3（研修担当）</th>
						<td class="paragraphbox"><pre>${interview.interviewTraContents3}</pre></td>
					</tr>
					<tr>
						<th class="paragraphbox">面談内容3</th>
						<td class="paragraphbox"><pre>${interview.interviewContents3}</pre></td>
					</tr>
				</table>
				<br />
				<table class="button">
					<tr>
						<td>
							<p style="position: relative;">
								<input type="image" src="img/back-2.png"
									onclick="goSubmit(this.form, this);"
									name="InterviewRegisterInput_btn" value="" alt="戻る">
							</p>
						</td>
						<td>
							<p style="position: relative;">
								<input type="image" src="img/complete.png"
									onclick="goSubmit(this.form, this);"
									name="InterviewRegisterComplete_btn" value="" alt="完了">
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