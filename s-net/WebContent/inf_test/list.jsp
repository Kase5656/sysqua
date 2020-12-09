<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC>
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
			<form name="defaultLink2" action="test.do" method="post">
				<input type="hidden" name="action" />
				<p id="headtitle">試験結果</p>
				<table id="foo-table" class="table table-bordered">
					<thead>
						<tr>
							<th class="header">回数</th>
							<th class="header">点数</th>
							<th class="header">実施日時</th>
							<th>詳細</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="test" items="${testList}" varStatus="loop">
							<tr>
								<td class="test">${test.testCount}</td>
								<td class="test">${test.testScore}</td>
								<td class="test">${test.testModified}</td>
								<td class="test">
									<p style="position: relative;">
										<input type="image" src=""
											onclick="goSubmit(this.form, this);" name="TestContents_btn"
											value="" alt="テスト実施">
									</p>
								</td>
							</tr>
						</c:forEach>
					</tbody>
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
											url : "http://cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Japanese.json"
										}
									});

					$("#foo-table").DataTable();
				});
			</script>
		</div>
	</div>
	<div class="l_footer"></div>
</body>
</html>