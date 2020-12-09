<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML>
<html>
<head>
<meta name="robots" content="noindex">
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=0">
<link rel="stylesheet"
	href="https://cdn.datatables.net/t/bs-3.3.6/jqc-1.12.0,dt-1.10.11/datatables.min.css" />
<link rel="stylesheet" href="css/style.css" type="text/css"
	media="screen and (min-width: 640px)">
<link rel="stylesheet" href="css/attendance.css" type="text/css"
	media="screen and (min-width: 640px)">
<link rel="stylesheet" href="css/featherlight.css"
	media="screen and (min-width: 640px)">
<link rel="stylesheet" href="css/style_sp.css" type="text/css"
	media="screen and (max-width: 640px)">
<link rel="stylesheet" href="css/attendance_sp.css" type="text/css"
	media="screen and (max-width: 640px)">
<link rel="stylesheet" href="css/featherlight_sp.css"
	media="screen and (max-width: 640px)">
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
			<p id="headtitle">ログイン・ログアウト一覧</p>
			<form name="defaultLink4" action="attendance.do" method="post">
				<input type="hidden" name="action" />
				<table id="foo-table" class="table table-bordered">
					<thead>
						<tr>
							<th class="header">日付</th>
							<th class="header">ログイン</th>
							<th class="header">ステータス</th>
							<th>備考</th>
							<th class="header">ログアウト</th>
							<th class="header">ステータス</th>
							<th>備考</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="attendance" items="${attendanceList}"
							varStatus="loop">
							<tr>
								<td>${attendance.attendanceDate}</td>
								<td>${attendance.attendanceStart}</td>
								<c:choose>
									<c:when test="${attendance.attendanceStartStatus == 0}">
										<td></td>
									</c:when>
									<c:when test="${attendance.attendanceStartStatus == 1}">
										<td>通常</td>
									</c:when>
									<c:when test="${attendance.attendanceStartStatus == 2}">
										<td>遅刻</td>
									</c:when>
									<c:when test="${attendance.attendanceStartStatus == 3}">
										<td>全休</td>
									</c:when>
									<c:when test="${attendance.attendanceStartStatus == 4}">
										<td>AM休</td>
									</c:when>
									<c:otherwise>
										<td>その他</td>
									</c:otherwise>
								</c:choose>
								<%-- 								<td>${attendance.attendanceStartRemarks}</td>
 --%>
								<td></td>
								<td>${attendance.attendanceEnd}</td>
								<c:choose>
									<c:when test="${attendance.attendanceEndStatus == 0}">
										<td></td>
									</c:when>
									<c:when test="${attendance.attendanceEndStatus == 1}">
										<td>通常</td>
									</c:when>
									<c:when test="${attendance.attendanceEndStatus == 2}">
										<td>早退</td>
									</c:when>
									<c:when test="${attendance.attendanceEndStatus == 3}">
										<td>PM休</td>
									</c:when>
									<c:otherwise>
										<td>その他</td>
									</c:otherwise>
								</c:choose>
								<%-- 								<td>${attendance.attendanceEndRemarks}</td>
 --%>
								<td></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<br />
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
			<script type="text/javascript">
				jQuery(function($) {
					// デフォルトの設定を変更
					$
							.extend(
									$.fn.dataTable.defaults,
									{
										language : {
											url : "https://cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Japanese.json"
										}
									});

					$("#foo-table").DataTable({
						order : [ 0, "asc" ],
						"stateSave" : true,
						"stateDuration" : -1,
						"columnDefs" : [ {
							"targets" : [ 3, 6 ],
							"orderable" : false,
						} ]
					});
				});
			</script>
		</div>
	</div>
	<div class="l_footer"></div>
</body>
</html>