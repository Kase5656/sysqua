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
			<p id="headtitle">面談情報管理</p>
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
			<form name="defaultLink3" action="interview.do" method="post">
				<input type="hidden" name="action" />
				<table id="foo-table" class="table table-bordered">
					<thead>
						<tr>
							<th></th>
							<th class="header">面談者氏名</th>
							<th>面談者情報</th>
							<th class="header">面談日<br>1回目
							</th>
							<th>面談内容<br>1回目
							</th>
							<th class="header">面談日<br>2回目
							</th>
							<th>面談内容<br>2回目
							</th>
							<th class="header">面談日<br>3回目
							</th>
							<th>面談内容<br>3回目
							</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="interview" items="${interviewList}"
							varStatus="loop">
							<tr>
								<td><c:choose>
										<c:when test="${selectedCheckList != null}">
											<c:set var="doneLoop" value="false" />
											<c:forEach var="check" items="${selectedCheckList}"
												varStatus="status">
												<c:if test="${!doneLoop}">
													<c:choose>
														<c:when test="${interview.interviewNo == check}">
															<c:set var="checked" value="checked" />
															<c:set var="doneLoop" value="true" />
														</c:when>
														<c:otherwise>
															<c:remove var="checked" />
														</c:otherwise>
													</c:choose>
												</c:if>
											</c:forEach>
											<input type="checkbox" name="InfInterview_chk"
												value="${interview.interviewNo}" ${checked}>
										</c:when>
										<c:otherwise>
											<input type="checkbox" name="InfInterview_chk"
												value="${interview.interviewNo}">
										</c:otherwise>
									</c:choose></td>
								<td>${interview.educationName}</td>
								<td>${interview.accountInformation}</td>
								<td>${interview.interviewDate1}</td>
								<td>${interview.interviewContents1}</td>
								<td>${interview.interviewDate2}</td>
								<td>${interview.interviewContents2}</td>
								<td>${interview.interviewDate3}</td>
								<td>${interview.interviewContents3}</td>
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
									onclick="goSubmit(this.form, this);"
									name="InterviewRegister_btn" value="" alt="登録">
							</p>
						</td>
						<td>
							<p style="position: relative;">
								<input type="image" src="img/update.png"
									onclick="goSubmit(this.form, this);" name="InterviewUpdate_btn"
									value="" alt="変更">
							</p>
						</td>
						<td>
							<p style="position: relative;">
								<input type="image" src="img/delete.png"
									onclick="goSubmit(this.form, this);" name="InterviewDelete_btn"
									value="" alt="削除">
							</p>
						</td>
						<td>
							<p style="position: relative;">
								<input type="image" src="img/back-2.png"
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

					$("#foo-table").DataTable();
				});
			</script>
		</div>
	</div>
	<div class="l_footer"></div>
</body>
</html>