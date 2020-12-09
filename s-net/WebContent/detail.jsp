<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

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
<link rel="stylesheet" href="css/detail.css" type="text/css"
	media="screen and (min-width: 640px)">
<link rel="stylesheet" href="css/featherlight.css"
	media="screen and (min-width: 640px)">
<link rel="stylesheet" href="css/style_sp.css" type="text/css"
	media="screen and (max-width: 640px)">
<link rel="stylesheet" href="css/detail_sp.css" type="text/css"
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
		<div id="body-layout">
			<div id="global-detailbody-left">
				<p id="headtitle">情報</p>
				<table id="head-table">
					<tr>
						<th id=dailyreport>氏名</th>
						<td>${education.educationName}</td>
					</tr>
					<tr>
						<th>会社名</th>
						<td>${education.corporationName}</td>
					</tr>
					<tr>
						<th>役割【4月】</th>
						<td>${education.dutiesNameNo1}</td>
					</tr>
					<tr>
						<th>&emsp;&emsp;【5月】</th>
						<td>${education.dutiesNameNo2}</td>
					</tr>
					<tr>
						<th>&emsp;&emsp;【6月】</th>
						<td>${education.dutiesNameNo3}</td>
					</tr>
				</table>
				<div class="attendance">
					<p id="headtitle">出退勤一覧</p>
					<form name="defaultLink2" action="attendance.do" method="post">
						<input type="hidden" name="action" />
						<p style="position: relative;">
							<input type="hidden" name="accountNo"
								value="${education.accountNo}"> <input type="hidden"
								name="accountNo" value="${account.accountNo}"> <input
								type="hidden" name="eduName" value="${education.educationName}">
							<input type="image" src="img/attendancelist.png"
								onclick="goSubmit(this.form, this);" name="InfAttendance_btn"
								value="" alt="出退勤一覧">
						</p>
					</form>
				</div>
				<c:if test="${JspFlg == 0 || JspFlg == 2}">
					<div class="technologylevel">
						<p id="headtitle">技術目標一覧</p>
						<form name="defaultLink4" action="mypage.do" method="post">
							<input type="hidden" name="action" />
							<p style="position: relative;">
								<input type="image" src="img/technologylevel.png"
									onclick="goSubmit(this.form, this);"
									name="InfTechnologyLevel_btn" value="" alt="技術目標一覧">
							</p>
						</form>
					</div>
					<c:if test="${account.accountNo == education.accountNo}">
						<div class="interview">
							<p id="headtitle">面談情報</p>
							<form name="defaultLink4" action="interview.do" method="post">
								<input type="hidden" name="action" />
								<p style="position: relative;">
									<input type="image" src="img/interview.png"
										onclick="goSubmit(this.form, this);"
										name="InterviewEducation_btn" value="" alt="面談情報">
								</p>
							</form>
						</div>
					</c:if>
					<div class="duties">
						<p id="headtitle">役割一覧</p>
						<form name="defaultLink4" action="duties.do" method="post">
							<input type="hidden" name="action" />
							<p style="position: relative;">
								<input type="image" src="img/dutieslist2.png"
									onclick="goSubmit(this.form, this);" name="InfDuties_btn"
									value="" alt="役割一覧">
							</p>
						</form>
					</div>
					<c:if test="${questionFlg == '1' }">
						<div class="question">
							<p id="headtitle">アンケート</p>
							<form name="defaultLink4" action="question.do" method="post">
								<input type="hidden" name="action" />
								<p style="position: relative;">
									<input type="image" src="img/question.png"
										onclick="goSubmit(this.form, this);"name="Question_btn"
										 value="" alt="アンケート">
								</p>
							</form>
						</div>
					</c:if>
				</c:if>
			</div>
			<div id="global-detailbody-right">
				<p id="headtitle">テスト＆レポート一覧</p>
				<br />
				<table id="foo-table" class="table table-bordered">
					<thead>
						<tr>
							<th class="header">実施日時</th>
							<th class="header">テスト</th>
							<th class="header"></th>
							<th class="header">レポート</th>
							<th class="header"></th>
							<th class="header">コメント</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="calender" items="${calenderList}" varStatus="loop">
							<tr>
								<td id="a">${calender.calenderOnDate}(${calender.calenderWeek})</td>
								<c:choose>
									<c:when
										test="${account.accountNo == education.accountNo||JspFlg != 2}">
										<c:choose>
											<c:when
												test="${result[loop.index] != '実施済み' && result[loop.index] != '未実施' && result[loop.index] != '無'}">
												<td>${result[loop.index]}</td>
												<td>
													<form name="defaultLink2" action="test.do" method="post"
														style="margin-bottom: 0px;">
														<input type="hidden" name="action" /> <input
															type="hidden" name="eduName"
															value="${education.educationName}"> <input
															type="hidden" name="accountNo"
															value="${education.accountNo}"> <input
															type="hidden" name="impdate"
															value="${calender.calenderOnDate}"> <input
															type="hidden" name="imp" value="1">
														<p style="position: relative;">
															<input type="image" src="img/detail.png"
																style="width: 65px; height: 40px; margin-bottom: 0px;"
																onclick="goSubmit(this.form, this);"
																name="TestDetail_btn" value="" alt="詳細">
														</p>
													</form>
												</td>
											</c:when>
											<c:otherwise>
												<c:choose>
													<c:when test="${result[loop.index] == '未実施'}">
														<td>${result[loop.index]}</td>
														<c:choose>
															<c:when
																test="${account.accountNo == education.accountNo}">
																<td><c:if test="${JspFlg == 2}">
																		<form name="defaultLink2" action="test.do"
																			method="post" style="margin-bottom: 0px;">
																			<input type="hidden" name="action" /> <input
																				type="hidden" name="eduName"
																				value="${education.educationName}"> <input
																				type="hidden" name="accountNo"
																				value="${education.accountNo}"><input
																				type="hidden" name="impdate"
																				value="${calender.calenderOnDate}"> <input
																				type="hidden" name="imp" value="0">
																			<p style="position: relative;">
																				<input type="image" src="img/implementation.png"
																					style="width: 65px; height: 40px; margin-bottom: 0px;"
																					onclick="goSubmit(this.form, this);"
																					name="TestDetail_btn" value="" alt="実施">
																			</p>
																		</form>
																	</c:if></td>
															</c:when>
															<c:otherwise>
																<td></td>
															</c:otherwise>
														</c:choose>
													</c:when>
													<c:otherwise>
														<td></td>
														<td></td>
													</c:otherwise>
												</c:choose>
											</c:otherwise>
										</c:choose>
									</c:when>
									<c:otherwise>
										<td></td>
										<td></td>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${result2[loop.index] != '未実施'}">
										<td>${result2[loop.index]}</td>
										<td>
											<form name="defaultLink2" action="report.do" method="post"
												style="margin-bottom: 0px;">
												<input type="hidden" name="action" /> <input type="hidden"
													name="eduName" value="${education.educationName}">
												<input type="hidden" name="accountNo"
													value="${education.accountNo}"> <input
													type="hidden" name="impdate"
													value="${calender.calenderOnDate}"> <input
													type="hidden" name="imp" value="1">
												<p style="position: relative;">
													<input type="image" src="img/detail.png"
														style="width: 65px; height: 40px; margin-bottom: 0px;"
														onclick="goSubmit(this.form, this);"
														name="ReportDetail_btn" value="" alt="詳細">
												</p>
											</form>
										</td>
									</c:when>
									<c:otherwise>
										<c:choose>
											<c:when test="${result2[loop.index] == '未実施'}">
												<td>${result2[loop.index]}</td>
												<c:choose>
													<c:when test="${account.accountNo == education.accountNo}">
														<td><c:if test="${JspFlg == 2}">
																<form name="defaultLink2" action="report.do"
																	method="post" style="margin-bottom: 0px;">
																	<input type="hidden" name="action" /> <input
																		type="hidden" name="eduName"
																		value="${education.educationName}"> <input
																		type="hidden" name="accountNo"
																		value="${education.accountNo}"> <input
																		type="hidden" name="impdate"
																		value="${calender.calenderOnDate}"> <input
																		type="hidden" name="imp" value="0">
																	<p style="position: relative;">
																		<input type="image" src="img/implementation.png"
																			style="width: 65px; height: 40px;"
																			onclick="goSubmit(this.form, this);"
																			name="ReportDetail_btn" value="" alt="実施">
																	</p>
																</form>
															</c:if></td>
													</c:when>
													<c:otherwise>
														<td></td>
													</c:otherwise>
												</c:choose>
											</c:when>
											<c:otherwise>
												<td></td>
												<td></td>
											</c:otherwise>
										</c:choose>
									</c:otherwise>
								</c:choose>
								<td class="commenttd">${result3[loop.index]}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
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
								"targets" : [ 2, 4 ],
								"orderable" : false,
							} ]
						});
					});
				</script>
			</div>
		</div>
	</div>
	<div class="l_footer"></div>
</body>
</html>