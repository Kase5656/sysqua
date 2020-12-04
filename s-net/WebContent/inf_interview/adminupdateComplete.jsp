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
			<p id="headtitle">面談情報変更</p>
			<ul class="stepBarThreeType clearfix">
				<li><span class="before"></span>入力 <span class="after"></span></li>
				<li><span class="before"></span>確認 <span class="after"></span></li>
				<li class="active"><span class="before"></span>完了 <span
					class="after"></span></li>
			</ul>
			<h3>${interview.educationName}さんの</h3>
			<h3>面談情報の変更が完了しました。</h3>
			<form name="defaultLink" action="interview.do" method="post">
				<input type="hidden" name="action" />
				<table class="button2">
					<tr>
						<td>
							<p style="position: relative;">
								<input type="image" src="img/interviewlist2.png"
									onclick="goSubmit(this.form, this);" name="InfInterview_btn"
									value="" alt="面談情報一覧">
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