<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC>
<html>
<head>
<meta name="robots" content="noindex">
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css" type="text/css">
<link rel="stylesheet" href="css/maintenance.css" type="text/css">
<link rel="stylesheet" href="css/featherlight.css">
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
			<p id="headtitle">管理者メニュー</p>
			<div id="divtable">
				<div>
					<form name="defaultLink" action="account.do" method="post">
						<input type="hidden" name="action" />
						<table class="buttonmaintenace">
							<tr>
								<td>
									<p style="position: relative;">
										<input type="image" src="img/accountlist.png"
											onclick="goSubmit(this.form, this);" name="InfAccount_btn"
											value="" alt="アカウント管理">
									</p>
								</td>
							</tr>
						</table>
					</form>
				</div>
				<div>
					<form name="defaultLink" action="education.do" method="post">
						<input type="hidden" name="action" />
						<table class="buttonmaintenace">
							<tr>
								<td>
									<p style="position: relative;">
										<input type="image" src="img/educationlist.png"
											onclick="goSubmit(this.form, this);" name="InfEducation_btn"
											value="" alt="受講生管理">
									</p>
								</td>
							</tr>
						</table>
					</form>
				</div>
				<div>
					<form name="defaultLink" action="corporation.do" method="post">
						<input type="hidden" name="action" />
						<table class="buttonmaintenace">
							<tr>
								<td>
									<p style="position: relative;">
										<input type="image" src="img/corporationlist.png"
											onclick="goSubmit(this.form, this);"
											name="InfCorporation_btn" value="" alt="企業管理">
									</p>
								</td>
							</tr>
						</table>
					</form>
				</div>
			</div>
			<div id="divtable">
				<div>
					<form name="defaultLink" action="duties.do" method="post">
						<input type="hidden" name="action" />
						<table class="buttonmaintenace">
							<tr>
								<td>
									<p style="position: relative;">
										<input type="image" src="img/dutieslist.png"
											onclick="goSubmit(this.form, this);" name="InfDuties_btn"
											value="" alt="役割管理">
									</p>
								</td>
							</tr>
						</table>
					</form>
				</div>
				<div>
					<form name="defaultLink" action="calender.do" method="post">
						<input type="hidden" name="action" />
						<table class="buttonmaintenace">
							<tr>
								<td>
									<p style="position: relative;">
										<input type="image" src="img/calenderlist.png"
											onclick="goSubmit(this.form, this);" name="InfCalender_btn"
											value="" alt="日付管理">
									</p>
								</td>
							</tr>
						</table>
					</form>
				</div>
				<div>
					<form name="defaultLink" action="topics.do" method="post">
						<input type="hidden" name="action" />
						<table class="buttonmaintenace">
							<tr>
								<td>
									<p style="position: relative;">
										<input type="image" src="img/topicslist.png"
											onclick="goSubmit(this.form, this);" name="InfTopics_btn"
											value="" alt="お知らせ管理">
									</p>
								</td>
							</tr>
						</table>
					</form>
				</div>
			</div>
			<div>
				<form name="defaultLink" action="interview.do" method="post">
					<input type="hidden" name="action" />
					<table class="buttonmaintenace">
						<tr>
							<td>
								<p style="position: relative;">
									<input type="image" src="img/interviewlist.png"
										onclick="goSubmit(this.form, this);" name="InfInterview_btn"
										value="" alt="面談情報管理">
								</p>
							</td>
						</tr>
					</table>
				</form>
			</div>
			<div></div>
		</div>
		<form name="defaultLink" action="menu.do" method="post">
			<input type="hidden" name="action" /> <input type="hidden"
				name="NowloginId" value="${account.accountId}" /> <input
				type="hidden" name="NowloginNo" value="${account.accountNo}" />
			<table class="button2">
				<tr>
					<td>
						<p style="position: relative;">
							<input type="image" src="img/back-2.png"
								onclick="goSubmit(this.form, this);" name="Menu_btn" value=""
								alt="戻る">
						</p>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div class="l_footer"></div>
</body>
</html>