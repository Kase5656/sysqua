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
<link rel="stylesheet" href="css/education.css" type="text/css">
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
			<p id="headtitle">受講生情報</p>
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
			<form name="defaultLink3" action="education.do" method="post">
				<input type="hidden" name="action" />
				<table id="foo-table" class="table table-bordered">
					<thead>
						<tr>
							<th></th>
							<th class="header">受講生氏名</th>
							<th class="header">受講生氏名カナ</th>
							<th class="header">企業名</th>
							<th class="header">入社日</th>
							<th>4月役割</th>
							<th>5月役割</th>
							<th>6月役割</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="education" items="${educationList}"
							varStatus="loop">
							<tr>
								<td><c:choose>
										<c:when test="${selectedCheckList != null}">
											<c:set var="doneLoop" value="false" />
											<c:forEach var="check" items="${selectedCheckList}"
												varStatus="status">
												<c:if test="${!doneLoop}">
													<c:choose>
														<c:when test="${education.educationNo == check}">
															<c:set var="checked" value="checked" />
															<c:set var="doneLoop" value="true" />
														</c:when>
														<c:otherwise>
															<c:remove var="checked" />
														</c:otherwise>
													</c:choose>
												</c:if>
											</c:forEach>
											<input type="checkbox" name="InfEducation_chk"
												value="${education.educationNo}" ${checked}>
										</c:when>
										<c:otherwise>
											<input type="checkbox" name="InfEducation_chk"
												value="${education.educationNo}">
										</c:otherwise>
									</c:choose></td>
								<td>${education.educationName}</td>
								<td>${education.educationKanaName}</td>
								<td>${education.corporation.corporationName}</td>
								<td>${education.enterningDate}</td>
								<td>${education.dutiesNameNo1}</td>
								<td>${education.dutiesNameNo2}</td>
								<td>${education.dutiesNameNo3}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<br />
				<table class="button">
					<tr>
						<td>
							<p style="position: relative;">
								<input type="image" src="img/update.png"
									style="width: 65px; height: 40px;"
									onclick="goSubmit(this.form, this);" name="EducationUpdate_btn"
									value="" alt="変更">
							</p>
						</td>
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
							"targets" : [ 0, 5, 6, 7 ],
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