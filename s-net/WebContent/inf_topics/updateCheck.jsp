<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css" type="text/css">
<link rel="stylesheet" href="css/topics.css" type="text/css">
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
			<p id="headtitle">お知らせ情報変更</p>
			<ul class="stepBarThreeType clearfix">
				<li><span class="before"></span>入力 <span class="after"></span>
				</li>
				<li class="active"><span class="before"></span>確認 <span
					class="after"></span></li>
				<li><span class="before"></span>完了 <span class="after"></span>
				</li>
			</ul>
			<h3>変更したお知らせ情報を確認してください。</h3>
			<form name="defaultLink" action="topics.do" method="post">
				<input type="hidden" name="action" />
				<table class="search">
					<tr>
						<th class="paragraphbox">お知らせ日時</th>
						<td class="paragraphbox">${topics.topicsDate}</td>
					</tr>
					<tr>
						<th class="paragraphbox">お知らせタイトル</th>
						<td class="paragraphbox">${topics.topicsTitle}</td>
					</tr>
					<tr>
						<th class="paragraphbox">お知らせ内容</th>
						<td class="paragraphbox">${topics.topicsContents}</td>
					</tr>
					<tr>
						<th class="paragraphbox">お知らせ表示ステータス</th>
						<td class="paragraphbox">${topics.topicsFlg}</td>
					</tr>
					<tr>
						<th class="paragraphbox">表示・非表示ステータス</th>
						<td class="paragraphbox">${topics.deleteFlg}</td>
					</tr>
				</table>
				<br />
				<table class="button">
					<tr>
						<td>
							<p style="position: relative;">
								<input type="image" src="img/complete.png"
									onclick="goSubmit(this.form, this);"
									name="TopicsUpdateComplete_btn" value="" alt="完了">
							</p>
						</td>
						<td>
							<p style="position: relative;">
								<input type="image" src="img/back-2.png"
									onclick="goSubmit(this.form, this);"
									name="TopicsUpdateInput_btn" value="" alt="戻る">
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