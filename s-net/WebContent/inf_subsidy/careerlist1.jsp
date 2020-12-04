<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css" type="text/css">
<link rel="stylesheet" href="css/subsidy.css" type="text/css">
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
			<p id="headtitle">助成金カテゴリ</p>
			<br />
			<p id="headtitle">キャリア形成促進助成金ー若年人材育成訓練</p>
			<br />
			<p id="headtitle">OJTカリキュラム</p>
			<table class="">
				<tr>
					<td><a href="https://rms.sqt.co.jp/s-net/Subsidy/uptest.zip">カリキュラムDownload</a></td>
				</tr>
			</table>
			<br />
			<p id="headtitle">01_実践型（大臣認定）</p>
			<table class="">
				<tr>
					<td><a href="https://rms.sqt.co.jp/s-net/Subsidy/uptest.zip">資料一式Download</a></td>
				</tr>
			</table>
			<br />
			<p id="headtitle">02_訓練実施計画届</p>
			<table class="">
				<tr>
					<td><a href="https://rms.sqt.co.jp/s-net/Subsidy/uptest.zip">資料一式Download</a></td>
				</tr>
			</table>
			<br />
			<p id="headtitle">03_支給申請</p>
			<table class="">
				<tr>
					<td><a href="https://rms.sqt.co.jp/s-net/Subsidy/uptest.zip">資料一式Download</a></td>
				</tr>
			</table>
			<form name="defaultLink" action="menu.do" method="post">
				<input type="hidden" name="action" />
				<table class="button2">
					<tr>
						<td>
							<p style="position: relative;">
								<input type="image" src="img/back-2.png"
									onclick="goSubmit(this.form, this);" name="BackTop_btn"
									value="" alt="戻る">
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