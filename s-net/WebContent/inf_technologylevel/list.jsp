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
<link rel="stylesheet" href="css/technologylevel.css" type="text/css"
	media="screen and (min-width: 640px)">
<link rel="stylesheet" href="css/featherlight.css"
	media="screen and (min-width: 640px)">
<link rel="stylesheet" href="css/style_sp.css" type="text/css"
	media="screen and (max-width: 640px)">
<link rel="stylesheet" href="css/technologylevel_sp.css" type="text/css"
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
			<p id="headtitle">技術目標</p>
			<form name="defaultLink2" action="technologylevel.do" method="post">
				<input type="hidden" name="action" />
				<table class="list">
					<thead>
						<tr>
							<th class="null"></th>
							<th class="levelStart">月初技術レベル</th>
							<th class="levelEnd">月初到達目標技術レベル</th>
							<th class="GoalReason">到達目標は何故達成できたのか(できなかったのか)</th>
							<th class="Goal">到達目標レベルに対しての行動目標</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="null">4月</td>
							<c:choose>
								<c:when test="${technologylevel.level4 == 'F'}">
									<td class="levelStartf">${technologylevel.level4}</td>
								</c:when>
								<c:when test="${technologylevel.level4 == 'E'}">
									<td class="levelStarte">${technologylevel.level4}</td>
								</c:when>
								<c:when test="${technologylevel.level4 == 'D'}">
									<td class="levelStartd">${technologylevel.level4}</td>
								</c:when>
								<c:when test="${technologylevel.level4 == 'C'}">
									<td class="levelStartc">${technologylevel.level4}</td>
								</c:when>
								<c:when test="${technologylevel.level4 == 'B'}">
									<td class="levelStartb">${technologylevel.level4}</td>
								</c:when>
								<c:when test="${technologylevel.level4 == 'A'}">
									<td class="levelStarta">${technologylevel.level4}</td>
								</c:when>
								<c:otherwise>
									<td class="levelStart"></td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${technologylevel.level5Goal == 'F'}">
									<td class="levelEndf">${technologylevel.level5Goal}</td>
								</c:when>
								<c:when test="${technologylevel.level5Goal == 'E'}">
									<td class="levelEnde">${technologylevel.level5Goal}</td>
								</c:when>
								<c:when test="${technologylevel.level5Goal == 'D'}">
									<td class="levelEndd">${technologylevel.level5Goal}</td>
								</c:when>
								<c:when test="${technologylevel.level5Goal == 'C'}">
									<td class="levelEndc">${technologylevel.level5Goal}</td>
								</c:when>
								<c:when test="${technologylevel.level5Goal == 'B'}">
									<td class="levelEndb">${technologylevel.level5Goal}</td>
								</c:when>
								<c:when test="${technologylevel.level5Goal == 'A'}">
									<td class="levelEnda">${technologylevel.level5Goal}</td>
								</c:when>
								<c:otherwise>
									<td class="levelEnd"></td>
								</c:otherwise>
							</c:choose>
							<td class="GoalReason"></td>
							<c:choose>
								<c:when test="${technologylevel.level4Action != ''}">
									<td class="Goal">${technologylevel.level4Action}</td>
								</c:when>
								<c:otherwise>
									<td class="Goal"></td>
								</c:otherwise>
							</c:choose>
						</tr>
						<tr>
							<td class="null">5月</td>
							<c:choose>
								<c:when test="${technologylevel.level5 == 'F'}">
									<td class="levelStartf">${technologylevel.level5}</td>
								</c:when>
								<c:when test="${technologylevel.level5 == 'E'}">
									<td class="levelStarte">${technologylevel.level5}</td>
								</c:when>
								<c:when test="${technologylevel.level5 == 'D'}">
									<td class="levelStartd">${technologylevel.level5}</td>
								</c:when>
								<c:when test="${technologylevel.level5 == 'C'}">
									<td class="levelStartc">${technologylevel.level5}</td>
								</c:when>
								<c:when test="${technologylevel.level5 == 'B'}">
									<td class="levelStartb">${technologylevel.level5}</td>
								</c:when>
								<c:when test="${technologylevel.level5 == 'A'}">
									<td class="levelStarta">${technologylevel.level5}</td>
								</c:when>
								<c:otherwise>
									<td class="levelStart"></td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${technologylevel.level6Goal == 'F'}">
									<td class="levelEndf">${technologylevel.level6Goal}</td>
								</c:when>
								<c:when test="${technologylevel.level6Goal == 'E'}">
									<td class="levelEnde">${technologylevel.level6Goal}</td>
								</c:when>
								<c:when test="${technologylevel.level6Goal == 'D'}">
									<td class="levelEndd">${technologylevel.level6Goal}</td>
								</c:when>
								<c:when test="${technologylevel.level6Goal == 'C'}">
									<td class="levelEndc">${technologylevel.level6Goal}</td>
								</c:when>
								<c:when test="${technologylevel.level6Goal == 'B'}">
									<td class="levelEndb">${technologylevel.level6Goal}</td>
								</c:when>
								<c:when test="${technologylevel.level6Goal == 'A'}">
									<td class="levelEnda">${technologylevel.level6Goal}</td>
								</c:when>
								<c:otherwise>
									<td class="levelEnd"></td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${technologylevel.level5GoalReason != ''}">
									<td class="GoalReason">${technologylevel.level5GoalReason}</td>
								</c:when>
								<c:otherwise>
									<td class="GoalReason"></td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${technologylevel.level5Action != ''}">
									<td class="Goal">${technologylevel.level5Action}</td>
								</c:when>
								<c:otherwise>
									<td class="Goal"></td>
								</c:otherwise>
							</c:choose>
						</tr>
						<tr>
							<td class="null">6月</td>
							<c:choose>
								<c:when test="${technologylevel.level6 == 'F'}">
									<td class="levelStartf">${technologylevel.level6}</td>
								</c:when>
								<c:when test="${technologylevel.level6 == 'E'}">
									<td class="levelStarte">${technologylevel.level6}</td>
								</c:when>
								<c:when test="${technologylevel.level6 == 'D'}">
									<td class="levelStartd">${technologylevel.level6}</td>
								</c:when>
								<c:when test="${technologylevel.level6 == 'C'}">
									<td class="levelStartc">${technologylevel.level6}</td>
								</c:when>
								<c:when test="${technologylevel.level6 == 'B'}">
									<td class="levelStartb">${technologylevel.level6}</td>
								</c:when>
								<c:when test="${technologylevel.level6 == 'A'}">
									<td class="levelStarta">${technologylevel.level6}</td>
								</c:when>
								<c:otherwise>
									<td class="levelStart"></td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${technologylevel.level7Goal == 'F'}">
									<td class="levelEndf">${technologylevel.level7Goal}</td>
								</c:when>
								<c:when test="${technologylevel.level7Goal == 'E'}">
									<td class="levelEnde">${technologylevel.level7Goal}</td>
								</c:when>
								<c:when test="${technologylevel.level7Goal == 'D'}">
									<td class="levelEndd">${technologylevel.level7Goal}</td>
								</c:when>
								<c:when test="${technologylevel.level7Goal == 'C'}">
									<td class="levelEndc">${technologylevel.level7Goal}</td>
								</c:when>
								<c:when test="${technologylevel.level7Goal == 'B'}">
									<td class="levelEndb">${technologylevel.level7Goal}</td>
								</c:when>
								<c:when test="${technologylevel.level7Goal == 'A'}">
									<td class="levelEnda">${technologylevel.level7Goal}</td>
								</c:when>
								<c:otherwise>
									<td class="levelEnd"></td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${technologylevel.level6GoalReason != ''}">
									<td class="GoalReason">${technologylevel.level6GoalReason}</td>
								</c:when>
								<c:otherwise>
									<td class="GoalReason"></td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${technologylevel.level6Action != ''}">
									<td class="Goal">${technologylevel.level6Action}</td>
								</c:when>
								<c:otherwise>
									<td class="Goal"></td>
								</c:otherwise>
							</c:choose>
						</tr>
					</tbody>
				</table>
				<table class="button">
					<tr>
						<td>
							<p style="position: relative;">
								<input type="image" src="img/april.png"
									onclick="goSubmit(this.form, this);" name="TechnologyApril_btn"
									value="" alt="4月編集">
							</p>
						</td>
						<td>
							<p style="position: relative;">
								<input type="image" src="img/may.png"
									onclick="goSubmit(this.form, this);" name="TechnologyMay_btn"
									value="" alt="5月編集">
							</p>
						</td>
						<td>
							<p style="position: relative;">
								<input type="image" src="img/june.png"
									onclick="goSubmit(this.form, this);" name="TechnologyJune_btn"
									value="" alt="6月編集">
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