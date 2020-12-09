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
<link rel="stylesheet" href="css/education.css" type="text/css"
	media="screen and (min-width: 640px)">
<link rel="stylesheet" href="css/featherlight.css"
	media="screen and (min-width: 640px)">
<link rel="stylesheet" href="css/style_sp.css" type="text/css"
	media="screen and (max-width: 640px)">
<link rel="stylesheet" href="css/education_sp.css" type="text/css"
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
			<p id="headtitle">新人研修期間中</p>
			<div class="title">《注意事項》</div>
			<br>
			<div class="title">＜全体について＞</div>
			<ul class="list">
				<li>会社からお金を払ってもらって研修を受けられている意識を常に持つこと。</li>
				<li>携帯電話は、マナーモードにする。（机上に出さない）</li>
				<li>新人研修期間中の提示内（9:00～12:00、13:00～17:30）は禁煙。</li>
				<li>自席での飲み物は自由。</li>
				<li>自習又は自分で作業を進める際のトイレ休憩は適宜。</li>
				<li>昼休憩の12:00～13:00は社外でも可。（但し、5分前までに着席する事）</li>
				<li>定時以降も、社員の方がいる場合は、居残り可。（何もしないで、他の新人を待つなどはNG） <br>定時以降だからといって何でもやっていい訳ではありません。（ヘッドフォンや靴を脱いだりなどはNG）
				</li>
				<li>当然ですが、研修期間中は私語、居眠り厳禁。姿勢・あくびにも注意。 <br>（仕事をしているという意識を持ち、新人同士でも気がついた場合は、注意していく事）
					<br>※頬杖・足を組む等は、ついやってしまいがちですので、気をつけてください。 <br>※男性のワイシャツがズボンから出てきたり、靴を脱いだりとだらしない格好にならないよう注意。
					<br>※椅子の上への正座もNG。
				</li>
				<li>社員の方への挨拶は忘れずに、元気よく。</li>
				<li>朝の掃除等は自分から率先して行い、研修開始5分前までには着席する。</li>
				<li>期限が遅れる等の重要な報告・相談は、なるべく早めに、メールだけでなく、必ず口頭か電話にて伝える事。 <br>※遅刻や緊急時、研修期間中は自社及びSQT総務・研修（office_edu@sqt.co.jp）、加瀬（080-3305-0506）に必ず連絡すること。
				</li>
			</ul>
			<br>
			<div class="title">＜メールについて＞</div>
			<ul class="list">
				<li>最低でも1日1回はチェックする事。 <br>また、可能であれば、なるべく携帯へのメール転送設定を行う事。
				</li>
				<li>返信は定時外になるべく早く行う事。（業前、昼休み、業後） <br>定時内は、基本的にメールは禁止。（ただし、緊急の場合は相談すること）
				</li>
			</ul>
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
									alt="TOP">
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