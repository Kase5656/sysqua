<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC>
<html>
<head>
<meta name="robots" content="noindex">
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.datatables.net/t/bs-3.3.6/jqc-1.12.0,dt-1.10.11/datatables.min.css" />
<link rel="stylesheet" href="css/style.css" type="text/css">
<link rel="stylesheet" href="css/calender.css" type="text/css">
<link rel="stylesheet" href="css/featherlight.css">
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
			<p id="headtitle">日付情報</p>
			<form name="defaultLink3" action="calender.do" method="post">
				<input type="hidden" name="action" />
				<table id="foo-table" class="table table-bordered">
					<thead>
						<tr>
							<th class="header"></th>
							<th class="header">日付</th>
							<th class="header">曜日</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="calender" items="${calenderList}" varStatus="loop">
							<tr>
								<td><input type="hidden" name="calenderNo"
									value="${calender.calenderNo}"> <c:if
										test="${calender.calenderChk == 0}">
										<input type="checkbox" name="calenderChk"
											value="${calender.calenderChk}">
									</c:if></td>
								<c:choose>
									<c:when test="${calender.calenderWeek == '土曜日'}">
										<td style="color: blue;">${calender.calenderOnDate}</td>
										<td style="color: blue;">${calender.calenderWeek}</td>
									</c:when>
									<c:when test="${calender.calenderWeek == '日曜日'}">
										<td style="color: red;">${calender.calenderOnDate}</td>
										<td style="color: red;">${calender.calenderWeek}</td>
									</c:when>
									<c:otherwise>
										<td>${calender.calenderOnDate}</td>
										<td>${calender.calenderWeek}</td>
									</c:otherwise>
								</c:choose>
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
									style="width: 65px; height: 40px;"
									onclick="goSubmit(this.form, this);" name="BackMaintenance_btn"
									value="" alt="戻る">
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
						order : [ 1, "asc" ],
						"stateSave" : true,
						"stateDuration" : -1,
						"columnDefs" : [ {
							"targets" : [ 0 ],
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