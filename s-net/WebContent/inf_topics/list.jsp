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
<link rel="stylesheet" href="css/topics.css" type="text/css">
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
		<br />
		<p id="headtitle">お知らせ情報</p>
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
		<form name="defaultLink2" action="topics.do" method="post">
			<input type="hidden" name="action" />
			<table id="foo-table" class="table table-bordered">
				<thead>
					<tr>
						<th></th>
						<th class="header">日時</th>
						<th>タイトル</th>
						<th>内容</th>
						<th class="header">表示<br>ステータス
						</th>
						<th class="header">表示・非表示<br>ステータス
						</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="topics" items="${topicsList}" varStatus="loop">
						<tr>
							<td><c:choose>
									<c:when test="${selectedCheckList != null}">
										<c:set var="doneLoop" value="false" />
										<c:forEach var="check" items="${selectedCheckList}"
											varStatus="status">
											<c:if test="${!doneLoop}">
												<c:choose>
													<c:when test="${topics.topicsNo == check}">
														<c:set var="checked" value="checked" />
														<c:set var="doneLoop" value="true" />
													</c:when>
													<c:otherwise>
														<c:remove var="checked" />
													</c:otherwise>
												</c:choose>
											</c:if>
										</c:forEach>
										<input type="checkbox" name="InfTopics_chk"
											value="${topics.topicsNo}" ${checked}>
									</c:when>
									<c:otherwise>
										<input type="checkbox" name="InfTopics_chk"
											value="${topics.topicsNo}">
									</c:otherwise>
								</c:choose></td>
							<td>${topics.topicsDate}</td>
							<td>${topics.topicsTitle}</td>
							<td>${topics.topicsContents}</td>
							<td>${topics.topicsFlg}</td>
							<td>${topics.deleteFlg}</td>
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
								onclick="goSubmit(this.form, this);" name="TopicsRegister_btn"
								value="" alt="登録">
						</p>
					</td>
					<td>
						<p style="position: relative;">
							<input type="image" src="img/update.png"
								style="width: 65px; height: 40px;"
								onclick="goSubmit(this.form, this);" name="TopicsUpdate_btn"
								value="" alt="変更">
						</p>
					</td>
					<td>
						<p style="position: relative;">
							<input type="image" src="img/delete.png"
								style="width: 65px; height: 40px;"
								onclick="goSubmit(this.form, this);" name="TopicsDelete_btn"
								value="" alt="削除">
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
						"targets" : [ 0, 3 ],
						"orderable" : false,
					} ]
				});
			});
		</script>
	</div>
	<div class="l_footer"></div>
</body>
</html>