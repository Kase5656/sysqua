<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC>
<html>
<head>
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
			<p id="headtitle">6月技術目標</p>
			<form name="defaultLink2" action="technologylevel.do" method="post">
				<input type="hidden" name="action" /> <input type="hidden"
					name="AccountNo" value="${account.accountNo}" />
				<div>
					<div id="body-layout">
						<c:if test="${errorList != NULL}" var="flg">
							<table class="errboxlong">
								<tr>
									<td><b>◆入力内容に誤りがあります。</b></td>
								</tr>
							</table>
							<table class="errboxlong2">
								<c:forEach var="error" items="${errorList}">
									<tr>
										<td><p class="err">&nbsp;・ ${error}</p></td>
									</tr>
								</c:forEach>
							</table>
						</c:if>
						<div id="global-body-left1">
							<h3>技術レベル</h3>
							<table>
								<tr>
									<th class="level1">技術レベル<font color="red">※</font></th>
									<th class="level1">7月目標技術レベル<font color="red">※</font></th>
								</tr>
								<tr>
									<c:choose>
										<c:when test="${JspFlg == 2 }">
											<td class="levelbox1"><input type="text" placeholder=""
												name="level6_txt" maxlength="1" size="1"
												value="${technologylevel.level6}" required title="" /></td>
											<td class="levelbox1"><input type="text" placeholder=""
												name="level7Goal_txt" maxlength="1" size="1"
												value="${technologylevel.level7Goal}" required title="" /></td>
										</c:when>
										<c:otherwise>
											<td class="levelbox1"><input type="text" placeholder=""
												name="level6_txt" maxlength="1" size="1"
												value="${technologylevel.level6}" required title=""
												readonly="readonly" /></td>
											<td class="levelbox1"><input type="text" placeholder=""
												name="level7Goal_txt" maxlength="1" size="1"
												value="${technologylevel.level7Goal}" required title=""
												readonly="readonly" /></td>
										</c:otherwise>
									</c:choose>
								</tr>
							</table>
							<table>
								<tr>
									<th>今月の目標は何故達成できた（できなかった）のか<br>※箇条書きで具体的に記載
									</th>
								</tr>
								<tr>
									<c:choose>
										<c:when test="${JspFlg == 2 }">
											<td><textarea name="level6GoalReason_txt"
													maxlength="300" cols="86" rows="10" aria-describedby=""
													aria-required="true" wrap="soft">${technologylevel.level6GoalReason}</textarea></td>
										</c:when>
										<c:otherwise>
											<td><textarea readonly name="level6GoalReason_txt"
													maxlength="300" cols="86" rows="10" aria-describedby=""
													aria-required="true" wrap="soft">${technologylevel.level6GoalReason}</textarea></td>
										</c:otherwise>
									</c:choose>
								</tr>
							</table>
							<table>
								<tr>
									<th>7月目標技術レベルに対しての行動目標<br>※箇条書きで具体的に記載
									</th>
								</tr>
								<tr>
									<c:choose>
										<c:when test="${JspFlg == 2 }">
											<td><textarea name="level6Action_txt" maxlength="300"
													cols="86" rows="10" aria-describedby=""
													aria-required="true" wrap="soft">${technologylevel.level6Action}</textarea></td>
										</c:when>
										<c:otherwise>
											<td><textarea readonly name="level6Action_txt"
													maxlength="300" cols="86" rows="10" aria-describedby=""
													aria-required="true" wrap="soft">${technologylevel.level6Action}</textarea></td>
										</c:otherwise>
									</c:choose>
								</tr>
							</table>
							<c:choose>
								<c:when test="${JspFlg == 2 }">

									<table class="button">
										<tr>
											<td>
												<p style="position: relative;">
													<input type="image" src="img/complete.png"
														onclick="goSubmit(this.form, this);"
														name="TechnologyJuneRegisterInput_btn" value="" alt="完了">
												</p>
											</td>
											<td>
												<p style="position: relative;">
													<input type="image" src="img/back-2.png"
														onclick="goSubmit(this.form, this);"
														name="InfTechnologyLevel_btn" value="" alt="戻る">
												</p>
											</td>
										</tr>
									</table>
								</c:when>
								<c:otherwise>
									<table class="button2">
										<tr>
											<td>
												<p style="position: relative;">
													<input type="image" src="img/back-2.png"
														onclick="goSubmit(this.form, this);"
														name="InfTechnologyLevel_btn" value="" alt="戻る">
												</p>
											</td>
										</tr>
									</table>
								</c:otherwise>
							</c:choose>
						</div>
						<div id="global-body-right1">
							<h3>技術レベル指標</h3>
							<table>
								<tr>
									<th id="levelhead1">指標レベル</th>
									<th id="levelhead2">指標内容</th>
								</tr>
								<tr>
									<td id="Ftd1">F</td>
									<td id="td2">Javaを学習中、SQLも学習中。SEとしての全体的な内容を学習している段階。</td>
								</tr>
								<tr>
									<td id="Etd1">E</td>
									<td id="td2">JavaやSQLの基礎知識は、変数や基礎的用語など聞けば分かるが、何かを見なければ自身ではif文やfor文等書けない。</td>
								</tr>
								<tr>
									<td id="Dtd1">D</td>
									<td id="td2">JavaやSQLの基礎知識は、変数や基礎的用語など分かる、少しヒントがあれば自身でif文やfor文等書ける。</td>
								</tr>
								<tr>
									<td id="Ctd1">C</td>
									<td id="td2">JavaやSQLの基礎知識はあり、if文やfor文等の基本的な構文を何も見ずに書くことができる。</td>
								</tr>
								<tr>
									<td id="Btd1">B</td>
									<td id="td2">JavaやSQLの基礎知識がある。一人ではWebアプリケーションを作成することは難しいが、システム構成は理解している。</td>
								</tr>
								<tr>
									<td id="Atd1">A</td>
									<td id="td2">JavaやSQLなど学んだ知識を応用でき、一人でWebアプリケーションが作成できる</td>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="l_footer"></div>
</body>
</html>