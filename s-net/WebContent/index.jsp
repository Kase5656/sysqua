<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jp.co.sqt.entity.*"%>
<%
	//ブラウザのキャッシュを無効にする。
	//Last-Modified(最終更新日) : 本日
	//Expires(有効期限)         : 過去日(1970/01/01)
	//pragma no-cache           : HTTP1.0仕様に基づく「キャッシュ無効指示」
	//Cache-Control no-cache    : HTTP1.1仕様に基づく「キャッシュ無効指示」
	java.util.Calendar objCal1 = java.util.Calendar.getInstance();
	java.util.Calendar objCal2 = java.util.Calendar.getInstance();
	objCal2.set(1970, 0, 1, 0, 0, 0);
	response.setDateHeader("Last-Modified", objCal1.getTime().getTime());
	response.setDateHeader("Expires", objCal2.getTime().getTime());
	response.setHeader("Proama", "no-cache");
	response.setHeader("Cache-Control", "no-cache");

	request.setCharacterEncoding("UTF-8");

	List<Topics> topicsList = new ArrayList<Topics>();

	Class.forName("com.mysql.jdbc.Driver");

	try {
		// データベースに接続
		Connection connect = DriverManager.getConnection(
				"jdbc:mysql://153.126.190.151:3306/rookies?autoReconnect=true&amp;serverTimezone=JST&amp;useSSL=false&amp",
				"intec", "sqt_itmng/3666");

		PreparedStatement ps = connect.prepareStatement(
				"SELECT *,date_format(topics_date,'%Y-%m-%d %H:%i:%S') topicsdate FROM t_topics WHERE topics_flg = 0 AND delete_flg = 0 ORDER BY topics_date DESC");

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			topicsList.add(
					new Topics(rs.getInt("topics_no"), rs.getString("topicsdate"), rs.getString("topics_title"),
							rs.getString("topics_contents"), rs.getInt("topics_flg"), rs.getInt("delete_flg")));

		}

		connect.close();
		ps.close();

	} catch (SQLException e) {

		System.err.println(e.getMessage());

	}
%>

<!DOCTYPE HTML>
<html>
<%
	session.invalidate();
%>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=0">
<link rel="stylesheet" href="css/style.css" type="text/css"
	media="screen and (min-width: 640px)">
<link rel="stylesheet" href="css/index.css" type="text/css"
	media="screen and (min-width: 640px)">
<link rel="stylesheet" href="css/featherlight.css"
	media="screen and (min-width: 640px)">
<link rel="stylesheet" href="css/style_sp.css" type="text/css"
	media="screen and (max-width: 640px)">
<link rel="stylesheet" href="css/index_sp.css" type="text/css"
	media="screen and (max-width: 640px)">
<link rel="stylesheet" href="css/featherlight_sp.css"
	media="screen and (max-width: 640px)">
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="js/featherlight.js"></script>
<script type="text/javascript" charset="UTF-8" src="js/change.js"></script>
<script type="text/javascript" charset="UTF-8" src="js/modal.js"></script>
<script type="text/javascript">
	$(function() {
		$(".l_header").load("inclu/header2.jsp");
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
	<form name="defaultLink2" action="loginout.do" method="post">
		<input type="hidden" name="action" />
		<div id="body-layout">
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
			<div id="global-body-left">
				<br />
				<p id="headtitle">ログイン</p>
				<div id="background-l">
					<table class="text">
						<tr>
							<th class="paragraphbox">ID</th>
							<td class="paragraphbox"><input type="text" name="ID_txt"
								value="${accountId}" maxlength="40" /></td>
						</tr>
						<tr>
							<th class="paragraphbox">パスワード</th>
							<td class="paragraphbox"><input type="password"
								id="password-1" name="Password_txt" value="${accountPassword}"
								class="login-field  login-field-password" maxlength="20" /></td>
						</tr>
					</table>
				</div>
				<table class="button">
					<tr>
						<td class="button1"><a href="passforgetSend.jsp"><font
								size="1">※パスワードをお忘れの方はこちら</font></a></td>
						<td class="button2">
							<p style="position: relative;">
								<input type="image" src="img/login.png"
									style="width: 105px; height: 35px;"
									onclick="goSubmit(this.form, this);" name="Login_btn" value=""
									alt="ログイン">
							</p>
						</td>
					</tr>
				</table>
				<img id="body-img-logo" src="img/systemq.png">
			</div>
			<div id="global-body-right">
				<br />
				<p id="headtitle">お知らせ</p>
				<div id="background-i">
					<div id="information">
						<%
							for (Topics topics : topicsList) {
						%>
						<%=topics.getTopicsDate()%>
						<%=topics.getTopicsTitle()%><br>
						<%=topics.getTopicsContents()%><br> ーーー<br>
						<%
							}
						%>
					</div>
				</div>
				<!--
				<p id="headtitle">ダウンロード</p>
				<div id="background-d">
					<div id="download">
						<a href="">RMS利用マニュアル（企業様向け）</a> <br /> <a href="">RMS利用マニュアル（研修生向け）</a>
					</div>
				</div>  -->
			</div>
		</div>
	</form>
	<div class="l_footer"></div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<!-- including the plugin -->
	<script src="js/hideShowPassword.min.js"></script>
	<script>
		// Example 1:
		// - Password hidden by default
		// - Inner toggle shown
		$('#password-1').hidePassword(true);

		// Example 2:
		// - Password shown by default
		// - Toggle shown on 'focus' of element
		// - Custom toggle class
		$('#password-2').showPassword('focus', {
			toggle : {
				className : 'my-toggle'
			}
		});

		// Example 3:
		// - When checkbox changes, toggle password
		//   visibility based on its 'checked' property
		$('#show-password').change(function() {
			$('#password-3').hideShowPassword($(this).prop('checked'));
		});
	</script>

</body>
</html>