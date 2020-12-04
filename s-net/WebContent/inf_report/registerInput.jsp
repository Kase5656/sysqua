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
<link rel="stylesheet" href="css/report.css" type="text/css"
	media="screen and (min-width: 640px)">
<link rel="stylesheet" href="css/featherlight.css"
	media="screen and (min-width: 640px)">
<link rel="stylesheet" href="css/style_sp.css" type="text/css"
	media="screen and (max-width: 640px)">
<link rel="stylesheet" href="css/report_sp.css" type="text/css"
	media="screen and (max-width: 640px)">
<link rel="stylesheet" href="css/featherlight_sp.css"
	media="screen and (max-width: 640px)">
<script type="text/javascript" charset="UTF-8" src="js/change.js"></script>
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
			<p id="headtitle">日報登録</p>
			<h3>${date}分の日報を入力してください。</h3>
			<p></p>
			<ul class="stepBarThreeType clearfix">
				<li class="active"><span class="before"></span>入力 <span
					class="after"></span></li>
				<li><span class="before"></span>確認 <span class="after"></span>
				</li>
				<li><span class="before"></span>完了 <span class="after"></span>
				</li>
			</ul>
			<form name="defaultLink2" action="report.do" method="post">
				<input type="hidden" name="action" />
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
				<br>
				<table class="content">
					<tr>
						<th class="header" colspan="2">■研修内容</th>
					</tr>
					<tr>
						<th class="time">実施時間</th>
						<th class="contentsItem">研修項目</th>
						<th class="progress">進捗度(%)</th>
						<th class="understanding">理解度</th>
						<th class="impression">所感</th>
					</tr>
					<tr>
						<td class="time"><input type="time" name="starttime_txt1"
							value="${report.contentsStartTime1}" min="09:00" max="21:00" />～<input
							type="time" name="endtime_txt1"
							value="${report.contentsEndTime1}" min="09:00" max="21:00"
							step="900" /></td>
						<td class="contentsItem"><textarea name="item_txt1"
								class="item" maxlength="200" cols="40" rows="4"
								aria-describedby="" aria-required="true" wrap="soft">${report.contentsItem1}</textarea></td>
						<td class="progress"><select name="progress_cmb1"
							class="progress" size="1">
								<c:choose>
									<c:when test="${report.contentsProgress1 != null}">
										<option value="100"
											${report.contentsProgress1 == 100 ? 'selected="selected"' : ''}>100%</option>
										<option value="90"
											${report.contentsProgress1 == 90 ? 'selected="selected"' : ''}>90%</option>
										<option value="80"
											${report.contentsProgress1 == 80 ? 'selected="selected"' : ''}>80%</option>
										<option value="70"
											${report.contentsProgress1 == 70 ? 'selected="selected"' : ''}>70%</option>
										<option value="60"
											${report.contentsProgress1 == 60 ? 'selected="selected"' : ''}>60%</option>
										<option value="50"
											${report.contentsProgress1 == 50 ? 'selected="selected"' : ''}>50%</option>
										<option value="40"
											${report.contentsProgress1 == 40 ? 'selected="selected"' : ''}>40%</option>
										<option value="30"
											${report.contentsProgress1 == 30 ? 'selected="selected"' : ''}>30%</option>
										<option value="20"
											${report.contentsProgress1 == 20 ? 'selected="selected"' : ''}>20%</option>
										<option value="10"
											${report.contentsProgress1 == 10 ? 'selected="selected"' : ''}>10%</option>
										<option value="0"
											${report.contentsProgress1 == 0 ? 'selected="selected"' : ''}>0%</option>
									</c:when>
									<c:otherwise>
										<option value="100" selected>100%</option>
										<option value="90">90%</option>
										<option value="80">80%</option>
										<option value="70">70%</option>
										<option value="60">60%</option>
										<option value="50">50%</option>
										<option value="40">40%</option>
										<option value="30">30%</option>
										<option value="20">20%</option>
										<option value="10">10%</option>
										<option value="0">0%</option>
									</c:otherwise>
								</c:choose>
						</select></td>
						<td class="understanding"><select name="understanding_cmb1"
							class="understanding" size="1">
								<c:choose>
									<c:when test="${report.contentsUnderStanding1 != null}">
										<option value="◎"
											${report.contentsUnderStanding1 == "◎" ? 'selected="selected"' : ''}>◎</option>
										<option value="〇"
											${report.contentsUnderStanding1 == "〇" ? 'selected="selected"' : ''}>〇</option>
										<option value="△"
											${report.contentsUnderStanding1 == "△" ? 'selected="selected"' : ''}>△</option>
										<option value="×"
											${report.contentsUnderStanding1 == "×" ? 'selected="selected"' : ''}>×</option>
									</c:when>
									<c:otherwise>
										<option value="◎" selected>◎</option>
										<option value="〇">〇</option>
										<option value="△">△</option>
										<option value="×">×</option>
									</c:otherwise>
								</c:choose>
						</select></td>
						<td class="impression"><textarea name="impression_txt1"
								class="impression" maxlength="1000" cols="40" rows="4"
								aria-describedby="" aria-required="true" wrap="soft">${report.contentsImpression1}</textarea></td>
					</tr>
					<tr>
						<td class="time"><input type="time" name="starttime_txt2"
							value="${report.contentsStartTime2}" min="09:00" max="21:00" />～<input
							type="time" name="endtime_txt2"
							value="${report.contentsEndTime2}" min="09:00" max="21:00"
							step="900" /></td>
						<td class="contentsItem"><textarea name="item_txt2"
								class="item" maxlength="200" cols="40" rows="4"
								aria-describedby="" aria-required="true" wrap="soft">${report.contentsItem2}</textarea></td>
						<td class="progress"><select name="progress_cmb2"
							class="progress" size="1">
								<c:choose>
									<c:when test="${report.contentsProgress2 != null}">
										<option value="100"
											${report.contentsProgress2 == 100 ? 'selected="selected"' : ''}>100%</option>
										<option value="90"
											${report.contentsProgress2 == 90 ? 'selected="selected"' : ''}>90%</option>
										<option value="80"
											${report.contentsProgress2 == 80 ? 'selected="selected"' : ''}>80%</option>
										<option value="70"
											${report.contentsProgress2 == 70 ? 'selected="selected"' : ''}>70%</option>
										<option value="60"
											${report.contentsProgress2 == 60 ? 'selected="selected"' : ''}>60%</option>
										<option value="50"
											${report.contentsProgress2 == 50 ? 'selected="selected"' : ''}>50%</option>
										<option value="40"
											${report.contentsProgress2 == 40 ? 'selected="selected"' : ''}>40%</option>
										<option value="30"
											${report.contentsProgress2 == 30 ? 'selected="selected"' : ''}>30%</option>
										<option value="20"
											${report.contentsProgress2 == 20 ? 'selected="selected"' : ''}>20%</option>
										<option value="10"
											${report.contentsProgress2 == 10 ? 'selected="selected"' : ''}>10%</option>
										<option value="0"
											${report.contentsProgress2 == 0 ? 'selected="selected"' : ''}>0%</option>
									</c:when>
									<c:otherwise>
										<option value="100" selected>100%</option>
										<option value="90">90%</option>
										<option value="80">80%</option>
										<option value="70">70%</option>
										<option value="60">60%</option>
										<option value="50">50%</option>
										<option value="40">40%</option>
										<option value="30">30%</option>
										<option value="20">20%</option>
										<option value="10">10%</option>
										<option value="0">0%</option>
									</c:otherwise>
								</c:choose>
						</select></td>
						<td class="understanding"><select name="understanding_cmb2"
							class="understanding" size="1">
								<c:choose>
									<c:when test="${report.contentsUnderStanding2 != null}">
										<option value="◎"
											${report.contentsUnderStanding2 == "◎" ? 'selected="selected"' : ''}>◎</option>
										<option value="〇"
											${report.contentsUnderStanding2 == "〇" ? 'selected="selected"' : ''}>〇</option>
										<option value="△"
											${report.contentsUnderStanding2 == "△" ? 'selected="selected"' : ''}>△</option>
										<option value="×"
											${report.contentsUnderStanding2 == "×" ? 'selected="selected"' : ''}>×</option>
									</c:when>
									<c:otherwise>
										<option value="◎" selected>◎</option>
										<option value="〇">〇</option>
										<option value="△">△</option>
										<option value="×">×</option>
									</c:otherwise>
								</c:choose>
						</select></td>
						<td class="impression"><textarea name="impression_txt2"
								class="impression" maxlength="1000" cols="40" rows="4"
								aria-describedby="" aria-required="true" wrap="soft">${report.contentsImpression2}</textarea></td>
					</tr>
					<tr>
						<td class="time"><input type="time" name="starttime_txt3"
							value="${report.contentsStartTime3}" min="09:00" max="21:00" />～<input
							type="time" name="endtime_txt3"
							value="${report.contentsEndTime3}" min="09:00" max="21:00"
							step="900" /></td>
						<td class="contentsItem"><textarea name="item_txt3"
								class="item" maxlength="200" cols="40" rows="4"
								aria-describedby="" aria-required="true" wrap="soft">${report.contentsItem3}</textarea></td>
						<td class="progress"><select name="progress_cmb3"
							class="progress" size="1">
								<c:choose>
									<c:when test="${report.contentsProgress3 != null}">
										<option value="100"
											${report.contentsProgress3 == 100 ? 'selected="selected"' : ''}>100%</option>
										<option value="90"
											${report.contentsProgress3 == 90 ? 'selected="selected"' : ''}>90%</option>
										<option value="80"
											${report.contentsProgress3 == 80 ? 'selected="selected"' : ''}>80%</option>
										<option value="70"
											${report.contentsProgress3 == 70 ? 'selected="selected"' : ''}>70%</option>
										<option value="60"
											${report.contentsProgress3 == 60 ? 'selected="selected"' : ''}>60%</option>
										<option value="50"
											${report.contentsProgress3 == 50 ? 'selected="selected"' : ''}>50%</option>
										<option value="40"
											${report.contentsProgress3 == 40 ? 'selected="selected"' : ''}>40%</option>
										<option value="30"
											${report.contentsProgress3 == 30 ? 'selected="selected"' : ''}>30%</option>
										<option value="20"
											${report.contentsProgress3 == 20 ? 'selected="selected"' : ''}>20%</option>
										<option value="10"
											${report.contentsProgress3 == 10 ? 'selected="selected"' : ''}>10%</option>
										<option value="0"
											${report.contentsProgress3 == 0 ? 'selected="selected"' : ''}>0%</option>
									</c:when>
									<c:otherwise>
										<option value="100" selected>100%</option>
										<option value="90">90%</option>
										<option value="80">80%</option>
										<option value="70">70%</option>
										<option value="60">60%</option>
										<option value="50">50%</option>
										<option value="40">40%</option>
										<option value="30">30%</option>
										<option value="20">20%</option>
										<option value="10">10%</option>
										<option value="0">0%</option>
									</c:otherwise>
								</c:choose>
						</select></td>
						<td class="understanding"><select name="understanding_cmb3"
							class="understanding" size="1">
								<c:choose>
									<c:when test="${report.contentsUnderStanding3 != null}">
										<option value="◎"
											${report.contentsUnderStanding3 == "◎" ? 'selected="selected"' : ''}>◎</option>
										<option value="〇"
											${report.contentsUnderStanding3 == "〇" ? 'selected="selected"' : ''}>〇</option>
										<option value="△"
											${report.contentsUnderStanding3 == "△" ? 'selected="selected"' : ''}>△</option>
										<option value="×"
											${report.contentsUnderStanding3 == "×" ? 'selected="selected"' : ''}>×</option>
									</c:when>
									<c:otherwise>
										<option value="◎" selected>◎</option>
										<option value="〇">〇</option>
										<option value="△">△</option>
										<option value="×">×</option>
									</c:otherwise>
								</c:choose>
						</select></td>
						<td class="impression"><textarea name="impression_txt3"
								class="impression" maxlength="1000" cols="40" rows="4"
								aria-describedby="" aria-required="true" wrap="soft">${report.contentsImpression3}</textarea></td>
					</tr>
					<tr>
						<td class="time"><input type="time" name="starttime_txt4"
							value="${report.contentsStartTime4}" min="09:00" max="21:00" />～<input
							type="time" name="endtime_txt4"
							value="${report.contentsEndTime4}" min="09:00" max="21:00"
							step="900" /></td>
						<td class="contentsItem"><textarea name="item_txt4"
								class="item" maxlength="200" cols="40" rows="4"
								aria-describedby="" aria-required="true" wrap="soft">${report.contentsItem4}</textarea></td>
						<td class="progress"><select name="progress_cmb4"
							class="progress" size="1">
								<c:choose>
									<c:when test="${report.contentsProgress4 != null}">
										<option value="100"
											${report.contentsProgress4 == 100 ? 'selected="selected"' : ''}>100%</option>
										<option value="90"
											${report.contentsProgress4 == 90 ? 'selected="selected"' : ''}>90%</option>
										<option value="80"
											${report.contentsProgress4 == 80 ? 'selected="selected"' : ''}>80%</option>
										<option value="70"
											${report.contentsProgress4 == 70 ? 'selected="selected"' : ''}>70%</option>
										<option value="60"
											${report.contentsProgress4 == 60 ? 'selected="selected"' : ''}>60%</option>
										<option value="50"
											${report.contentsProgress4 == 50 ? 'selected="selected"' : ''}>50%</option>
										<option value="40"
											${report.contentsProgress4 == 40 ? 'selected="selected"' : ''}>40%</option>
										<option value="30"
											${report.contentsProgress4 == 30 ? 'selected="selected"' : ''}>30%</option>
										<option value="20"
											${report.contentsProgress4 == 20 ? 'selected="selected"' : ''}>20%</option>
										<option value="10"
											${report.contentsProgress4 == 10 ? 'selected="selected"' : ''}>10%</option>
										<option value="0"
											${report.contentsProgress4 == 0 ? 'selected="selected"' : ''}>0%</option>
									</c:when>
									<c:otherwise>
										<option value="100" selected>100%</option>
										<option value="90">90%</option>
										<option value="80">80%</option>
										<option value="70">70%</option>
										<option value="60">60%</option>
										<option value="50">50%</option>
										<option value="40">40%</option>
										<option value="30">30%</option>
										<option value="20">20%</option>
										<option value="10">10%</option>
										<option value="0">0%</option>
									</c:otherwise>
								</c:choose>
						</select></td>
						<td class="understanding"><select name="understanding_cmb4"
							class="understanding" size="1">
								<c:choose>
									<c:when test="${report.contentsUnderStanding4 != null}">
										<option value="◎"
											${report.contentsUnderStanding4 == "◎" ? 'selected="selected"' : ''}>◎</option>
										<option value="〇"
											${report.contentsUnderStanding4 == "〇" ? 'selected="selected"' : ''}>〇</option>
										<option value="△"
											${report.contentsUnderStanding4 == "△" ? 'selected="selected"' : ''}>△</option>
										<option value="×"
											${report.contentsUnderStanding4 == "×" ? 'selected="selected"' : ''}>×</option>
									</c:when>
									<c:otherwise>
										<option value="◎" selected>◎</option>
										<option value="〇">〇</option>
										<option value="△">△</option>
										<option value="×">×</option>
									</c:otherwise>
								</c:choose>
						</select></td>
						<td class="impression"><textarea name="impression_txt4"
								class="impression" maxlength="1000" cols="40" rows="4"
								aria-describedby="" aria-required="true" wrap="soft">${report.contentsImpression4}</textarea></td>
					</tr>
					<tr>
						<td class="time"><input type="time" name="starttime_txt5"
							value="${report.contentsStartTime5}" min="09:00" max="21:00" />～<input
							type="time" name="endtime_txt5"
							value="${report.contentsEndTime5}" min="09:00" max="21:00"
							step="900" /></td>
						<td class="contentsItem"><textarea name="item_txt5"
								class="item" maxlength="200" cols="40" rows="4"
								aria-describedby="" aria-required="true" wrap="soft">${report.contentsItem5}</textarea></td>
						<td class="progress"><select name="progress_cmb5"
							class="progress" size="1">
								<c:choose>
									<c:when test="${report.contentsProgress5 != null}">
										<option value="100"
											${report.contentsProgress5 == 100 ? 'selected="selected"' : ''}>100%</option>
										<option value="90"
											${report.contentsProgress5 == 90 ? 'selected="selected"' : ''}>90%</option>
										<option value="80"
											${report.contentsProgress5 == 80 ? 'selected="selected"' : ''}>80%</option>
										<option value="70"
											${report.contentsProgress5 == 70 ? 'selected="selected"' : ''}>70%</option>
										<option value="60"
											${report.contentsProgress5 == 60 ? 'selected="selected"' : ''}>60%</option>
										<option value="50"
											${report.contentsProgress5 == 50 ? 'selected="selected"' : ''}>50%</option>
										<option value="40"
											${report.contentsProgress5 == 40 ? 'selected="selected"' : ''}>40%</option>
										<option value="30"
											${report.contentsProgress5 == 30 ? 'selected="selected"' : ''}>30%</option>
										<option value="20"
											${report.contentsProgress5 == 20 ? 'selected="selected"' : ''}>20%</option>
										<option value="10"
											${report.contentsProgress5 == 10 ? 'selected="selected"' : ''}>10%</option>
										<option value="0"
											${report.contentsProgress5 == 0 ? 'selected="selected"' : ''}>0%</option>
									</c:when>
									<c:otherwise>
										<option value="100" selected>100%</option>
										<option value="90">90%</option>
										<option value="80">80%</option>
										<option value="70">70%</option>
										<option value="60">60%</option>
										<option value="50">50%</option>
										<option value="40">40%</option>
										<option value="30">30%</option>
										<option value="20">20%</option>
										<option value="10">10%</option>
										<option value="0">0%</option>
									</c:otherwise>
								</c:choose>
						</select></td>
						<td class="understanding"><select name="understanding_cmb5"
							class="understanding" size="1">
								<c:choose>
									<c:when test="${report.contentsUnderStanding5 != null}">
										<option value="◎"
											${report.contentsUnderStanding5 == "◎" ? 'selected="selected"' : ''}>◎</option>
										<option value="〇"
											${report.contentsUnderStanding5 == "〇" ? 'selected="selected"' : ''}>〇</option>
										<option value="△"
											${report.contentsUnderStanding5 == "△" ? 'selected="selected"' : ''}>△</option>
										<option value="×"
											${report.contentsUnderStanding5 == "×" ? 'selected="selected"' : ''}>×</option>
									</c:when>
									<c:otherwise>
										<option value="◎" selected>◎</option>
										<option value="〇">〇</option>
										<option value="△">△</option>
										<option value="×">×</option>
									</c:otherwise>
								</c:choose>
						</select></td>
						<td class="impression"><textarea name="impression_txt5"
								class="impression" maxlength="1000" cols="40" rows="4"
								aria-describedby="" aria-required="true" wrap="soft">${report.contentsImpression5}</textarea></td>
					</tr>
				</table>
				<table class="content">
					<tr>
						<th class="header" colspan="2">■今月の目標</th>
					</tr>
					<tr>
						<th class="monthgoal">今月の目標①</th>
						<td class="monthgoal"><textarea name="monthgoal_txt1"
								class="monthgoal" maxlength="1000" cols="40" rows="4"
								aria-describedby="" aria-required="true" wrap="soft">${report.monthGoal1}</textarea></td>
					</tr>
					<tr>
						<th class="monthgoal">今月の目標②</th>
						<td class="monthgoal"><textarea name="monthgoal_txt2"
								class="monthgoal" maxlength="1000" cols="40" rows="4"
								aria-describedby="" aria-required="true" wrap="soft">${report.monthGoal2}</textarea></td>
					</tr>
				</table>
				<table class="content">
					<tr>
						<th class="header" colspan="2">■今日の目標</th>
					</tr>
					<tr>
						<th class="todaygoal">今日の目標①</th>
						<td class="todaygoal"><textarea name="todaygoal_txt1"
								class="todaygoal" maxlength="1000" cols="40" rows="4"
								aria-describedby="" aria-required="true" wrap="soft">${report.todayGoal1}</textarea></td>
					</tr>
					<tr>
						<th class="todaygoal">今日の目標②</th>
						<td class="todaygoal"><textarea name="todaygoal_txt2"
								class="todaygoal" maxlength="1000" cols="40" rows="4"
								aria-describedby="" aria-required="true" wrap="soft">${report.todayGoal2}</textarea></td>
					</tr>
					<tr>
						<th class="todaygoalscore">今日の目標達成度</th>
						<td class="todaygoalscore"><select name="todaygoalscore_cmb"
							class="todaygoalscore" size="1">
								<c:choose>
									<c:when test="${report.todayGoalScore != null}">
										<option value="5"
											${report.todayGoalScore == 5 ? 'selected="selected"' : ''}>5</option>
										<option value="4"
											${report.todayGoalScore == 4 ? 'selected="selected"' : ''}>4</option>
										<option value="3"
											${report.todayGoalScore == 3 ? 'selected="selected"' : ''}>3</option>
										<option value="2"
											${report.todayGoalScore == 2 ? 'selected="selected"' : ''}>2</option>
										<option value="1"
											${report.todayGoalScore == 1 ? 'selected="selected"' : ''}>1</option>
									</c:when>
									<c:otherwise>
										<option value="5" selected>5</option>
										<option value="4">4</option>
										<option value="3">3</option>
										<option value="2">2</option>
										<option value="1">1</option>
									</c:otherwise>
								</c:choose>
						</select></td>
					</tr>
					<tr>
						<th class="todaysatisfaction">満足だった点</th>
						<td class="todaysatisfaction"><textarea
								name="todaysatisfaction_txt" class="todaysatisfaction"
								maxlength="1000" cols="40" rows="4" aria-describedby=""
								aria-required="true" wrap="soft">${report.todaySatisfaction}</textarea></td>
					</tr>
					<tr>
						<th class="todaysatisfaction">不満を残した点</th>
						<td class="todaysatisfaction"><textarea
								name="todaydissatisfaction_txt" class="todaysatisfaction"
								maxlength="1000" cols="40" rows="4" aria-describedby=""
								aria-required="true" wrap="soft">${report.todayDisSatisfaction}</textarea></td>
					</tr>
				</table>
				<table class="content">
					<tr>
						<th class="header" colspan="2">■本日の問題点と対策</th>
					</tr>
					<tr>
						<th class="todayproblem">本日の問題点</th>
						<td class="todayproblem"><textarea name="todayproblem_txt"
								class="todayproblem" maxlength="1000" cols="40" rows="4"
								aria-describedby="" aria-required="true" wrap="soft">${report.todayProblem}</textarea></td>
					</tr>
					<tr>
						<th class="todaymeasures">対策</th>
						<td class="todaymeasures"><textarea name="todaymeasures_txt"
								class="todaymeasures" maxlength="1000" cols="40" rows="4"
								aria-describedby="" aria-required="true" wrap="soft">${report.todayMeasures}</textarea></td>
					</tr>
				</table>
				<table class="content">
					<tr>
						<th class="header" colspan="2">■明日(次週)の予定</th>
					</tr>
					<tr>
						<th class="nextplan">明日(次週)の予定</th>
						<td class="nextplan"><textarea name="nextplan_txt"
								class="nextplan" maxlength="1000" cols="40" rows="4"
								aria-describedby="" aria-required="true" wrap="soft">${report.nextPlan}</textarea></td>
					</tr>
				</table>
				<table class="content">
					<tr>
						<th class="header" colspan="2">■全体の所感・疑問点等</th>
					</tr>
					<tr>
						<th class="allimpression">全体の所感・疑問点等</th>
						<td class="allimpression"><textarea name="allimpression_txt"
								class="allimpression" maxlength="1000" cols="40" rows="4"
								aria-describedby="" aria-required="true" wrap="soft">${report.allImpression}</textarea></td>
					</tr>
				</table>
				<br />
				<table class="button">
					<tr>
						<td>
							<p style="position: relative;">
								<input type="image" src="img/check.png"
									onclick="goSubmit(this.form, this);"
									name="ReportRegisterCheck_btn" value="" alt="確認">
							</p>
						</td>
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
		</div>
	</div>
	<div class="l_footer"></div>
</body>
</html>