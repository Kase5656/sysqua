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
			<c:choose>
				<c:when test="${jspId == 0}">
					<p id="headtitle">出勤情報登録</p>
				</c:when>
				<c:otherwise>
					<p id="headtitle">退勤情報登録</p>
				</c:otherwise>
			</c:choose>
			<ul class="stepBarThreeType clearfix">
				<li class="active"><span class="before"></span>入力 <span
					class="after"></span></li>
				<li><span class="before"></span>確認 <span class="after"></span>
				</li>
				<li><span class="before"></span>完了 <span class="after"></span>
				</li>
			</ul>
			<c:choose>
				<c:when test="${jspId == 0}">
					<h3>出勤情報を入力してください。</h3>
				</c:when>
				<c:otherwise>
					<h3>退勤情報を入力してください。</h3>
				</c:otherwise>
			</c:choose>
			<form name="defaultLink" action="attendance.do" method="post">
				<input type="hidden" name="action" /> <input type="hidden"
					name="jspId" value="${jspId}">
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
				<table class="search">
					<tr>
						<td><font size="2" color="red">※</font><font size="2">入力・選択必須項目</font>
					<tr>
						<th class="paragraphbox">日付</th>
						<td class="paragraphbox">${attendance.attendanceDate}</td>
					</tr>
					<tr>
						<th class="paragraphbox">時刻</th>
						<c:choose>
							<c:when test="${jspId == 0}">
								<td class="paragraphbox">${attendance.attendanceStart}</td>
							</c:when>
							<c:otherwise>
								<td class="paragraphbox">${attendance.attendanceEnd}</td>
							</c:otherwise>
						</c:choose>
					</tr>
					<tr>
						<th class="paragraphbox">ステータス<font color="red">※</font></th>
						<td class="paragraphbox"><c:choose>
								<c:when test="${jspId == 0}">
									<select name="Status_cmb" size="1">
										<c:choose>
											<c:when test="${cmbFlg == 0}">
												<option value="0" selected>-選択してください-</option>
											</c:when>
											<c:otherwise>
												<option value="0">-選択してください-</option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${cmbFlg == 1}">
												<option value="1" selected>-通常-</option>
											</c:when>
											<c:otherwise>
												<option value="1">-通常-</option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${cmbFlg == 2}">
												<option value="2" selected>-遅刻-</option>
											</c:when>
											<c:otherwise>
												<option value="2">-遅刻-</option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${cmbFlg == 3}">
												<option value="3" selected>-全休-</option>
											</c:when>
											<c:otherwise>
												<option value="3">-全休-</option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${cmbFlg == 4}">
												<option value="4" selected>-AM休-</option>
											</c:when>
											<c:otherwise>
												<option value="4">-AM休-</option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${cmbFlg == 5}">
												<option value="5" selected>-その他-</option>
											</c:when>
											<c:otherwise>
												<option value="5">-その他-</option>
											</c:otherwise>
										</c:choose>
									</select>
								</c:when>
								<c:otherwise>
									<select name="Status_cmb" size="1">
										<c:choose>
											<c:when test="${cmbFlg == 0}">
												<option value="0" selected>-選択してください-</option>
											</c:when>
											<c:otherwise>
												<option value="0" selected>-選択してください-</option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${cmbFlg == 1}">
												<option value="1" selected>-通常-</option>
											</c:when>
											<c:otherwise>
												<option value="1">-通常-</option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${cmbFlg == 2}">
												<option value="2" selected>-早退-</option>
											</c:when>
											<c:otherwise>
												<option value="2">-早退-</option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${cmbFlg == 3}">
												<option value="3" selected>-PM休-</option>
											</c:when>
											<c:otherwise>
												<option value="3">-PM休-</option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${cmbFlg == 4}">
												<option value="4" selected>-その他-</option>
											</c:when>
											<c:otherwise>
												<option value="4">-その他-</option>
											</c:otherwise>
										</c:choose>
									</select>
								</c:otherwise>
							</c:choose></td>
					</tr>
					<tr>
						<th class="paragraphbox">備考</th>
						<c:choose>
							<c:when test="${jspId == 0}">
								<td class="paragraphbox"><textarea name="Remarks_txt"
										maxlength="300" cols="40" rows="5" aria-describedby=""
										aria-required="true" wrap="hard"
										placeholder="ステータスが'通常'以外の場合、状況を記載してください。">${attendance.attendanceStartRemarks}</textarea></td>
							</c:when>
							<c:otherwise>
								<td class="paragraphbox"><textarea name="Remarks_txt"
										maxlength="300" cols="40" rows="5" aria-describedby=""
										aria-required="true" wrap="hard"
										placeholder="ステータスが'通常'以外の場合、状況を記載してください。">${attendance.attendanceEndRemarks}</textarea></td>
							</c:otherwise>
						</c:choose>
					</tr>
				</table>
				<br />
				<table class="button">
					<tr>
						<td>
							<p style="position: relative;">
								<input type="image" src="img/check.png"
									onclick="goSubmit(this.form, this);"
									name="AttendanceRegisterCheck_btn" value="" alt="確認">
							</p>
						</td>
						<td>
							<p style="position: relative;">
								<input type="image" src="img/back-2.png"
									onclick="goSubmit(this.form, this);"
									name="EducationTopSearch_btn" value="" alt="戻る">
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