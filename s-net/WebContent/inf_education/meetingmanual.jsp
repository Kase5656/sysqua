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
			<p id="headtitle">朝夕会</p>
			<div class="title">《注意事項》</div>
			<br>
			<div class="title">＜全体について＞</div>
			<ul class="list">
				<li>時間を守る。（朝夕ミーティングは、基本的に30分） <br>※どうしても時間が足りない場合は、加瀬・加藤に相談。
				</li>
				<li>会議前に必要な準備は、完了しておく。 <br>必要であれば、議題や自分の発言内容について、事前に確認・相談等を行う。
				</li>
				<li>各議題について、ゴールを決める。</li>
				<li>当会議における決定事項について、話を戻さない。（基本的にNG）</li>
			</ul>
			<br>
			<div class="title">＜司会にやっていただきたいこと＞</div>
			<ul class="list">
				<li>議題の確認⇒優先順位決定⇒時間配分 <br>※上記は、できれば会議前に完了できていた方がベター
				</li>
				<li>最後に、結果（決定事項）を共有。</li>
			</ul>
			<br>
			<div class="title">＜司会の心得10＞</div>
			<ul class="list">
				<li>定刻に開催できるようにチェックと指導を行う。</li>
				<li>会議の目的を理解し、中心テーマの線に沿って討議を導き整理する。</li>
				<li>参加者全員に討議に参加させるように誘導する。</li>
				<li>討議が乱れてきたときには発言者を指名する。</li>
				<li>討議がテーマを外れた場合、静かに理由を話し、打ち切らせる。 <br>一人が発言中は他のものの発言を差し控えさせる。
				</li>
				<li>各人の意見を自由に述べさせる。 <br>特定の人の意見を無視しない、同じ人に長く話させない。
				</li>
				<li>議事進行、秩序維持については、はっきりと発言すべき、 <br>しかし、討議の内容については個人的意見や感情を入れてはならない。
				</li>
				<li>会議の進行中、随時それまでの討議内容をまとめ、討議の整理進行を行う。 <br>議案の一つひとつについて可否決、修正可決か保留か多数決により決めていく。
				</li>
				<li>会議の結論、解決をはっきりと確認するため、最終段階で本会議の決定事項を発表する。</li>
			</ul>
			<br>
			<div class="title">＜参加者の心得8＞</div>
			<ul class="list">
				<li>開催時間を厳守し、５分前には出席する。欠席の時には必ず事前に報告する。</li>
				<li>発言は簡潔にタイミング良く積極的に。</li>
				<li>全般に関係しない事は努めて避ける、横道にそれないようにする。</li>
				<li>意見の違う人の言葉にも耳を傾ける。</li>
				<li>反対意見を述べる場合にも親しみを込めて個人感情を入れたり反対のための反対は慎む。</li>
				<li>感情に走って判断を誤ったり、枝葉末節の論争は避ける。</li>
				<li>一人で会議を独占せず、参加者全員が意見を発表できるようにする。</li>
				<li>自分と反対の意見でも決定されたことは快く服し実行する。</li>
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