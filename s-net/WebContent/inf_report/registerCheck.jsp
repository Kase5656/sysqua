<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML>
<html>
<head>
<meta name="robots" content="noindex">
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
			<h3>入力内容を確認してください。</h3>
			<ul class="stepBarThreeType clearfix">
				<li><span class="before"></span> 入力 <span class="after"></span></li>
				<li class="active"><span class="before"></span>確認 <span
					class="after"></span></li>
				<li><span class="before"></span>完了 <span class="after"></span>
				</li>
			</ul>
			<form name="defaultLink2" action="report.do" method="post">
				<input type="hidden" name="action" />
				<table class="reportcheck">
					<tr>
						<th class="reportchecktitlehead" colspan="9">研修報告書</th>
					</tr>
					<tr>
						<th class="paragraphbox">作成日時</th>
						<td class="paragraphbox">${report.reportDateTime}</td>
						<th class="paragraphbox">会社名</th>
						<td class="paragraphbox" colspan="2">${education.corporationName}</td>
						<th class="paragraphbox">氏名</th>
						<td class="paragraphbox">${education.educationName}</td>
					</tr>
					<tr>
						<th class="reportchecktitle" colspan="9">■研修内容</th>
					</tr>
					<tr>
						<th class="paragraphbox">実施時間</th>
						<th class="paragraphbox">研修項目</th>
						<th class="paragraphbox">進捗度</th>
						<th class="paragraphbox">理解度</th>
						<th class="paragraphbox" colspan="4">所感</th>
					</tr>
					<tr>
						<td class="paragraphbox">${report.contentsStartTime1}-${report.contentsEndTime1}</td>
						<td class="paragraphbox">${report.contentsItem1}</td>
						<td class="paragraphbox">${report.contentsProgress1}%</td>
						<td class="paragraphbox">${report.contentsUnderStanding1}</td>
						<td class="paragraphbox" colspan="4">${report.contentsImpression1}</td>
					</tr>
					<tr>
						<td class="paragraphbox">${report.contentsStartTime2}-${report.contentsEndTime2}</td>
						<td class="paragraphbox">${report.contentsItem2}</td>
						<td class="paragraphbox">${report.contentsProgress2}%</td>
						<td class="paragraphbox">${report.contentsUnderStanding2}</td>
						<td class="paragraphbox" colspan="4">${report.contentsImpression2}</td>
					</tr>
					<tr>
						<td class="paragraphbox">${report.contentsStartTime3}-${report.contentsEndTime3}</td>
						<td class="paragraphbox">${report.contentsItem3}</td>
						<td class="paragraphbox">${report.contentsProgress3}%</td>
						<td class="paragraphbox">${report.contentsUnderStanding3}</td>
						<td class="paragraphbox" colspan="5">${report.contentsImpression3}</td>
					</tr>
					<tr>
						<td class="paragraphbox">${report.contentsStartTime4}-${report.contentsEndTime4}</td>
						<td class="paragraphbox">${report.contentsItem4}</td>
						<td class="paragraphbox">${report.contentsProgress4}%</td>
						<td class="paragraphbox">${report.contentsUnderStanding4}</td>
						<td class="paragraphbox" colspan="4">${report.contentsImpression4}</td>
					</tr>
					<tr>
						<td class="paragraphbox">${report.contentsStartTime5}-${report.contentsEndTime5}</td>
						<td class="paragraphbox">${report.contentsItem5}</td>
						<td class="paragraphbox">${report.contentsProgress5}%</td>
						<td class="paragraphbox">${report.contentsUnderStanding5}</td>
						<td class="paragraphbox" colspan="4">${report.contentsImpression5}</td>
					</tr>
					<tr>
						<th class="reportchecktitle" colspan="9">■今月の目標</th>
					</tr>
					<tr>
						<th class="paragraphbox">今月の目標①</th>
						<td class="paragraphbox" colspan="8">${report.monthGoal1}</td>
					</tr>
					<tr>
						<th class="paragraphbox">今月の目標②</th>
						<td class="paragraphbox" colspan="8">${report.monthGoal2}</td>
					</tr>
					<tr>
						<th class="reportchecktitle" colspan="8">■今日の目標</th>
					</tr>
					<tr>
						<th class="paragraphbox">今日の目標①</th>
						<td class="paragraphbox" colspan="8">${report.todayGoal1}</td>
					</tr>
					<tr>
						<th class="paragraphbox">今日の目標②</th>
						<td class="paragraphbox" colspan="8">${report.todayGoal2}</td>
					</tr>
					<tr>
						<th class="paragraphbox">今日の目標は達成できたか</th>
						<td class="paragraphbox" colspan="8">${report.todayGoalScore}</td>
					</tr>
					<tr>
						<th class="paragraphbox">満足だった点</th>
						<td class="paragraphbox" colspan="8">${report.todaySatisfaction}</td>
					</tr>
					<tr>
						<th class="paragraphbox">不満を残した点</th>
						<td class="paragraphbox" colspan="8">${report.todayDisSatisfaction}</td>
					</tr>
					<tr>
						<th class="reportchecktitle" colspan="8">■本日の問題点と対策</th>
					<tr>
						<th class="paragraphbox">本日の問題点</th>
						<td class="paragraphbox" colspan="8">${report.todayProblem}</td>
					</tr>
					<tr>
						<th class="paragraphbox">対策</th>
						<td class="paragraphbox" colspan="8">${report.todayMeasures}</td>
					</tr>
					<tr>
						<th class="reportchecktitle" colspan="8">■明日(次週)の予定</th>
					</tr>
					<tr>
						<th class="paragraphbox">明日(次週)の予定</th>
						<td class="paragraphbox" colspan="8">${report.nextPlan}</td>
					</tr>
					<tr>
						<th class="reportchecktitle" colspan="8">■全体の所感・疑問点等</th>
					<tr>
						<th class="paragraphbox">全体の所感・疑問点等</th>
						<td class="paragraphbox" colspan="8">${report.allImpression}</td>
					</tr>
				</table>
				<br />
				<table class="button">
					<tr>
						<td>
							<p style="position: relative;">
								<input type="image" src="img/complete.png"
									onclick="goSubmit(this.form, this);"
									name="ReportRegisterComplete_btn" value="" alt="完了">
							</p>
						</td>
						<td>
							<p style="position: relative;">
								<input type="image" src="img/back-2.png"
									onclick="goSubmit(this.form, this);"
									name="ReportRegisterInput_btn" value="" alt="戻る">
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