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
<link rel="stylesheet"
	href="https://cdn.datatables.net/t/bs-3.3.6/jqc-1.12.0,dt-1.10.11/datatables.min.css" />
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
<script
	src="https://cdn.datatables.net/t/bs-3.3.6/jqc-1.12.0,dt-1.10.11/datatables.min.js"></script>
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
			<p id="headtitle">理解度確認テスト結果</p>
			<form name="defaultLink" action="test.do" method="post">
				<input type="hidden" name="action" />
				<table id="foo-table" class="table table-bordered">
					<thead>
						<tr>
							<th class="header">回数</th>
							<th class="header">点数</th>
							<th class="header">実施日時</th>
							<th class="header">問１</th>
							<th class="header">問２</th>
							<th class="header">問３</th>
							<th class="header">問４</th>
							<th class="header">問５</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="testList" items="${testList}" varStatus="loop">
							<tr>
								<td>${testList.testCount}</td>
								<td>${testList.testScore}</td>
								<td>${testList.testDateTime}</td>
								<td>${testList.testAnswer1}</td>
								<td>${testList.testAnswer2}</td>
								<td>${testList.testAnswer3}</td>
								<td>${testList.testAnswer4}</td>
								<td>${testList.testAnswer5}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
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