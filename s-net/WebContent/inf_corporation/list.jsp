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
<link rel="stylesheet" href="css/corporation.css" type="text/css">
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
			<p id="headtitle">企業情報</p>
			<br />
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
			<form name="defaultLink3" action="corporation.do" method="post">
				<input type="hidden" name="action" />
				<table id="foo-table" class="table table-bordered">
					<thead>
						<tr>
							<th></th>
							<th class="header">企業名</th>
							<th class="header">郵便番号</th>
							<th class="header">住所</th>
							<th class="header">電話番号</th>
							<th class="header">FAX番号</th>
							<th class="header">代表者名</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="corporation" items="${corporationList}"
							varStatus="loop">
							<tr>
								<td><c:choose>
										<c:when test="${selectedCheckList != null}">
											<c:set var="doneLoop" value="false" />
											<c:forEach var="check" items="${selectedCheckList}"
												varStatus="status">
												<c:if test="${!doneLoop}">
													<c:choose>
														<c:when test="${corporation.corporationNo == check}">
															<c:set var="checked" value="checked" />
															<c:set var="doneLoop" value="true" />
														</c:when>
														<c:otherwise>
															<c:remove var="checked" />
														</c:otherwise>
													</c:choose>
												</c:if>
											</c:forEach>
											<input type="checkbox" name="InfCorporation_chk"
												value="${corporation.corporationNo}" ${checked}>
										</c:when>
										<c:otherwise>
											<input type="checkbox" name="InfCorporation_chk"
												value="${corporation.corporationNo}">
										</c:otherwise>
									</c:choose></td>
								<td>${corporation.corporationName}</td>
								<td>${corporation.corporationPostalcode}</td>
								<td>${corporation.corporationAddress}</td>
								<td>${corporation.corporationTel}</td>
								<td>${corporation.corporationFax}</td>
								<td>${corporation.corporationRepresentativeName}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<br />
				<table class="button">
					<tr>
						<td>
							<p style="position: relative;">
								<input type="image" src="img/registration.png"
									style="width: 65px; height: 40px;"
									onclick="goSubmit(this.form, this);"
									name="CorporationRegister_btn" value="" alt="登録">
							</p>
						</td>
						<td>
							<p style="position: relative;">
								<input type="image" src="img/update.png"
									style="width: 65px; height: 40px;"
									onclick="goSubmit(this.form, this);"
									name="CorporationUpdate_btn" value="" alt="変更">
							</p>
						</td>
						<td>
							<p style="position: relative;">
								<input type="image" src="img/delete.png"
									style="width: 65px; height: 40px;"
									onclick="goSubmit(this.form, this);"
									name="CorporationDelete_btn" value="" alt="削除">
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