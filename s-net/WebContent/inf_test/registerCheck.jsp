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
<link rel="stylesheet" href="css/test.css" type="text/css"
	media="screen and (min-width: 640px)">
<link rel="stylesheet" href="css/featherlight.css"
	media="screen and (min-width: 640px)">
<link rel="stylesheet" href="css/style_sp.css" type="text/css"
	media="screen and (max-width: 640px)">
<link rel="stylesheet" href="css/test_sp.css" type="text/css"
	media="screen and (max-width: 640px)">
<link rel="stylesheet" href="css/featherlight_sp.css"
	media="screen and (max-width: 640px)">
<script type="text/javascript" charset="UTF-8" src="js/change.js"></script>
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
			<p id="headtitle">理解度確認テスト</p>
			<form name="defaultLink2" action="test.do" method="post">
				<input type="hidden" name="action" />
				<p style="text-align: center;">${testDate}</p>
				<c:choose>
					<c:when test="${errorList != NULL}">
						<div class="errbox">
							<table class="err">
								<tr>
									<td><b>◆試験結果◆</b></td>
								</tr>
								<c:forEach var="error" items="${errorList}">
									<tr>
										<td><p>&nbsp; ・${error}</p></td>
									</tr>
								</c:forEach>
							</table>
						</div>
						<table class="button2">
							<tr>
								<td>
									<p style="position: relative;">
										<input type="image" src="img/retry.png"
											onclick="goSubmit(this.form, this);" name="TestContents_btn"
											value="" alt="リトライ">
									</p>
								</td>
							</tr>
						</table>
					</c:when>
					<c:otherwise>
						<h3 style="text-align: center;">合格</h3>
						<c:choose>
							<c:when test="${attendanceflg}">
								<c:choose>
									<c:when test="${date == commentary4Date1}">
										<iframe src="pdf/1.pdf" style="width: 100%; height: 100vh;"></iframe>
									</c:when>
									<c:when test="${date == commentary4Date2}">
										<iframe src="pdf/2.pdf" style="width: 100%; height: 100vh;"></iframe>
									</c:when>
									<c:when test="${date == commentary4Date3}">
										<iframe src="pdf/3.pdf" style="width: 100%; height: 100vh;"></iframe>
									</c:when>
									<c:when test="${date == commentary4Date4}">
										<iframe src="pdf/4.pdf" style="width: 100%; height: 100vh;"></iframe>
									</c:when>
									<c:when test="${date == commentary4Date5}">
										<iframe src="pdf/5.pdf" style="width: 100%; height: 100vh;"></iframe>
									</c:when>
									<c:when test="${date == commentary4Date6}">
										<iframe src="pdf/6.pdf" style="width: 100%; height: 100vh;"></iframe>
									</c:when>
									<c:when test="${date == commentary4Date7}">
										<iframe src="pdf/7.pdf" style="width: 100%; height: 100vh;"></iframe>
									</c:when>
									<c:when test="${date == commentary4Date8}">
										<iframe src="pdf/8.pdf" style="width: 100%; height: 100vh;"></iframe>
									</c:when>
									<c:when test="${date == commentary4Date9}">
										<iframe src="pdf/9.pdf" style="width: 100%; height: 100vh;"></iframe>
									</c:when>
									<c:when test="${date == commentary4Date10}">
										<iframe src="pdf/10.pdf" style="width: 100%; height: 100vh;"></iframe>
									</c:when>
									<c:when test="${date == commentary4Date11}">
										<iframe src="pdf/11.pdf" style="width: 100%; height: 100vh;"></iframe>
									</c:when>
									<c:when test="${date == commentary4Date12}">
										<iframe src="pdf/12.pdf" style="width: 100%; height: 100vh;"></iframe>
									</c:when>
									<c:when test="${date == commentary4Date13}">
										<iframe src="pdf/13.pdf" style="width: 100%; height: 100vh;"></iframe>
									</c:when>
									<c:when test="${date == commentary4Date14}">
										<iframe src="pdf/14.pdf" style="width: 100%; height: 100vh;"></iframe>
									</c:when>
									<c:otherwise>
										<iframe src="pdf/15.pdf" style="width: 100%; height: 100vh;"></iframe>
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:otherwise>
								<c:choose>
									<c:when test="${date == commentary10Date1}">
										<iframe src="pdf/1.pdf" style="width: 100%; height: 100vh;"></iframe>
									</c:when>
									<c:when test="${date == commentary10Date2}">
										<iframe src="pdf/2.pdf" style="width: 100%; height: 100vh;"></iframe>
									</c:when>
									<c:when test="${date == commentary10Date3}">
										<iframe src="pdf/3.pdf" style="width: 100%; height: 100vh;"></iframe>
									</c:when>
									<c:when test="${date == commentary10Date4}">
										<iframe src="pdf/4.pdf" style="width: 100%; height: 100vh;"></iframe>
									</c:when>
									<c:when test="${date == commentary10Date5}">
										<iframe src="pdf/5.pdf" style="width: 100%; height: 100vh;"></iframe>
									</c:when>
									<c:when test="${date == commentary10Date6}">
										<iframe src="pdf/6.pdf" style="width: 100%; height: 100vh;"></iframe>
									</c:when>
									<c:when test="${date == commentary10Date7}">
										<iframe src="pdf/7.pdf" style="width: 100%; height: 100vh;"></iframe>
									</c:when>
									<c:when test="${date == commentary10Date8}">
										<iframe src="pdf/8.pdf" style="width: 100%; height: 100vh;"></iframe>
									</c:when>
									<c:when test="${date == commentary10Date9}">
										<iframe src="pdf/9.pdf" style="width: 100%; height: 100vh;"></iframe>
									</c:when>
									<c:when test="${date == commentary10Date10}">
										<iframe src="pdf/10.pdf" style="width: 100%; height: 100vh;"></iframe>
									</c:when>
									<c:when test="${date == commentary10Date11}">
										<iframe src="pdf/11.pdf" style="width: 100%; height: 100vh;"></iframe>
									</c:when>
									<c:when test="${date == commentary10Date12}">
										<iframe src="pdf/12.pdf" style="width: 100%; height: 100vh;"></iframe>
									</c:when>
									<c:when test="${date == commentary10Date13}">
										<iframe src="pdf/13.pdf" style="width: 100%; height: 100vh;"></iframe>
									</c:when>
									<c:when test="${date == commentary10Date14}">
										<iframe src="pdf/14.pdf" style="width: 100%; height: 100vh;"></iframe>
									</c:when>
									<c:otherwise>
										<iframe src="pdf/15.pdf" style="width: 100%; height: 100vh;"></iframe>
									</c:otherwise>
								</c:choose>
							</c:otherwise>
						</c:choose>
						<table class="button2">
							<tr>
								<td>
									<p style="position: relative;">
										<input type="image" src="img/pass.png"
											onclick="goSubmit(this.form, this);"
											name="EducationDetailSearch_btn" value="" alt="合格">
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