<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=0">
<link rel="stylesheet" href="css/style.css" type="text/css"
	media="screen and (min-width: 640px)">
<link rel="stylesheet" href="css/top.css" type="text/css"
	media="screen and (min-width: 640px)">
<link rel="stylesheet" href="css/featherlight.css"
	media="screen and (min-width: 640px)">
<link rel="stylesheet" href="css/style_sp.css" type="text/css"
	media="screen and (max-width: 640px)">
<link rel="stylesheet" href="css/top_sp.css" type="text/css"
	media="screen and (max-width: 640px)">
<link rel="stylesheet" href="css/featherlight_sp.css"
	media="screen and (max-width: 640px)">
<script type="text/javascript" charset="UTF-8" src="js/change.js"></script>
<script type="text/javascript" charset="UTF-8" src="js/modal.js"></script>
<script type="text/javascript" charset="UTF-8" src="js/button.js"></script>
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
		<br />
		<form name="defaultLink2" action="menu.do" method="post">
			<input type="hidden" name="action" />
			<p id="headtitle">お知らせ</p>
			<table id="head-table">
				<thead class="scrollHead">
					<tr>
						<th>公開日</th>
						<th>タイトル</th>
						<th>内容</th>
					</tr>
				</thead>
				<tbody class="scrollBody">
					<c:forEach var="topics" items="${topicsList}" varStatus="loop">
						<tr>
							<td class="topics">${topics.topicsDate}</td>
							<td class="topics">${topics.topicsTitle}</td>
							<td class="topics">${topics.topicsContents}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
	</div>
	<div id="body-layout">
		<div id="global-body-left">
			<br />
			<p id="headtitle">受講生検索</p>
			<div id="background-d">
				<form name="defaultLink3" action="education.do" method="post">
					<input type="hidden" name="action" />
					<c:if test="${errorList != NULL}" var="flg">
						<table class="errbox">
							<tr>
								<td><b>◆選択内容に誤りがあります。</b></td>
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
					<table style="float: left;">
						<tr>
							<td><select name="Education_cmb" id = "education" size="1"
							onchange="Education()">
									<option value="0">-選択してください-</option>
									<option value="1">佐々木</option>
									<c:forEach var="education" items="${education}"
										varStatus="loop">
										<option
											value="${education.accountNo}/${education.educationName}"
											${education.accountNo == account.accountNo ?
											'selected="selected"' : ''}>${education.educationName}
										</option>
									</c:forEach>
							</select></td>
							<td>
								<p style="position: relative;">
									<input type="image" id="btn" src="img/search.png"
										style="width: 65px; height: 40px;"
										onclick="goSubmit(this.form, this);"
										name="EducationTopSearch_btn" value="" alt="詳細"disabled/>
								</p>
							</td>
						</tr>

					</table>
				</form>
			</div>
			<br />
			<c:if test="${account.accountAuthority == 2}">
				<c:if test="${attendanceflg}">
					<p id="headtitle">出退勤</p>
					<div id="background-d">
						<form name="defaultLink4" action="attendance.do" method="post">
							<input type="hidden" name="action" /> <input type="hidden"
								name="education" value="${education}" />
							<c:if test="${errorList2 != NULL}" var="flg">
								<table class="errbox">
									<tr>
										<td><b>◆選択内容に誤りがあります。</b></td>
									</tr>
								</table>
								<table class="errbox2">
									<c:forEach var="error" items="${errorList2}">
										<tr>
											<td><p class="err">&nbsp;・ ${error}</p></td>
										</tr>
									</c:forEach>
								</table>
							</c:if>
							<table>
								<tr>
									<td class="button3">
										<p style="position: relative;">
											<input type="image" src="img/gowork.png"
												onclick="goSubmit(this.form, this);"
												name="AttendanceStart_btn" value="" alt="出勤">
										</p>
									</td>
									<td class="button3">
										<p style="position: relative;">
											<input type="image" src="img/leavwork.png"
												onclick="goSubmit(this.form, this);"
												name="AttendanceEnd_btn" value="" alt="退勤">
										</p>
									</td>
								</tr>
							</table>
						</form>
					</div>
				</c:if>
				<p id="headtitle">新人研修マニュアル</p>
				<div id="background-d">
					<form name="defaultLink4" action="education.do" method="post">
						<input type="hidden" name="action" />
						<table>
							<tr>
								<td class="button3">
									<p style="position: relative;">
										<input type="image" src="img/trainingmanual.png"
											onclick="goSubmit(this.form, this);" name="Training_btn"
											value="" alt="研修">
									</p>
								</td>
								<td class="button3">
									<p style="position: relative;">
										<input type="image" src="img/meetingmanual.png"
											onclick="goSubmit(this.form, this);" name="Meeting_btn"
											value="" alt="会議">
									</p>
								</td>
							</tr>
						</table>
					</form>
				</div>
			</c:if>
		</div>
		<div id="global-body-right">
			<br />
			<c:if test="${account.accountAuthority == 2}">
				<p id="headtitle">各残日数</p>
				<div id="background">
					<p id="head-char">研修成果発表会まで残り</p>
					<p id="body-char">${end1date}日</p>
				</div>
				<div id="background">
					<p id="head-char">研修終了まで残り</p>
					<p id="body-char">${end2date}日</p>
				</div>
				<div id="background">
					<p id="head-char">現場配属まで残り</p>
					<p id="body-char">${end3date}日</p>
				</div>
			</c:if>
		</div>
	</div>
	<div class="l_footer"></div>
</body>
</html>