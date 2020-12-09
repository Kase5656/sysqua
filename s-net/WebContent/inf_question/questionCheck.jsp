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
<link rel="stylesheet" href="css/question.css" type="text/css">
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
			<p id="headtitle">アンケート</p>
			<p>以下の内容で回答します。</p>
			<div>
				<div class="questionTitle1">1．研修全般についてお聞きします。</div>
				<table class="questionCheckTable">
					<tr>
						<td>(1)今回の研修についてどのような印象をお持ちですか。</td>
						<td></td>
						<td><c:choose>
								<c:when test="${question.ans1_1_1 == 5}">大変有意義であった</c:when>
								<c:when test="${question.ans1_1_1 == 4}">有意義だった</c:when>
								<c:when test="${question.ans1_1_1 == 3}">まあまあだった</c:when>
								<c:when test="${question.ans1_1_1 == 2}">物足りなかった</c:when>
								<c:when test="${question.ans1_1_1 == 1}">非常に不満足</c:when>
							</c:choose></td>
					</tr>
					<c:if test="${!empty question.ans1_1_2}">
						<tr>
							<td></td>
							<td></td>
							<td>${question.ans1_1_2}</td>
						</tr>
					</c:if>
					<tr>
						<td>(2)今回の研修は今後の職務に活かせると感じましたか。</td>
						<td></td>
						<td><c:choose>
								<c:when test="${question.ans1_2_1 == 3}">大いに活かせる</c:when>
								<c:when test="${question.ans1_2_1 == 2}">いくらか活かせる</c:when>
								<c:when test="${question.ans1_2_1 == 1}">ほとんど活かせない</c:when>
							</c:choose></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td>${question.ans1_2_2}</td>
					</tr>
					<tr>
						<td>(3)研修期間はどうでしたか。</td>
						<td></td>
						<td><c:choose>
								<c:when test="${question.ans1_2_1 == 3}">適切だった</c:when>
								<c:when test="${question.ans1_2_1 == 2}">長すぎる</c:when>
								<c:when test="${question.ans1_2_1 == 1}">短すぎる</c:when>
							</c:choose></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td>${question.ans1_3_2}日間が適切</td>
					</tr>
				</table>
				<div>
					<div class="questionTitle1">2．各研修項目についてお聞きします。</div>
					<div class="questionTitle2">(1)ITリテラシー｛4日間｝</div>
					<table class="questionCheckTable2">
						<tr>
							<td></td>
							<td>①講義は今後に役立つ内容でしたか</td>
							<td></td>
							<td><c:choose>
									<c:when test="${question.ans2_1_1 == 5}">非常にそう思う</c:when>
									<c:when test="${question.ans2_1_1 == 4}">そう思う</c:when>
									<c:when test="${question.ans2_1_1 == 3}">どちらともいえない</c:when>
									<c:when test="${question.ans2_1_1 == 2}">思わない</c:when>
									<c:when test="${question.ans2_1_1 == 1}">全く思わない</c:when>
								</c:choose></td>
						</tr>
						<tr>
							<td class="topAndBottomBorderDelete"></td>
							<td>②講師の説明はわかりやすかったですか</td>
							<td></td>
							<td><c:choose>
									<c:when test="${question.ans2_1_2 == 5}">非常にそう思う</c:when>
									<c:when test="${question.ans2_1_2 == 4}">そう思う</c:when>
									<c:when test="${question.ans2_1_2 == 3}">どちらともいえない</c:when>
									<c:when test="${question.ans2_1_2 == 2}">思わない</c:when>
									<c:when test="${question.ans2_1_2 == 1}">全く思わない</c:when>
								</c:choose></td>
						</tr>
						<tr>
							<td class="topAndBottomBorderDelete"></td>
							<td>③講義資料はわかりやすかったですか</td>
							<td></td>
							<td><c:choose>
									<c:when test="${question.ans2_1_3 == 5}">非常にそう思う</c:when>
									<c:when test="${question.ans2_1_3 == 4}">そう思う</c:when>
									<c:when test="${question.ans2_1_3 == 3}">どちらともいえない</c:when>
									<c:when test="${question.ans2_1_3 == 2}">思わない</c:when>
									<c:when test="${question.ans2_1_3 == 1}">全く思わない</c:when>
								</c:choose></td>
						</tr>
						<tr>
							<td class="topAndBottomBorderDelete"></td>
							<td>④この科目の時間数は適切でしたか</td>
							<td></td>
							<td><c:choose>
									<c:when test="${question.ans2_1_4 == 5}">非常にそう思う</c:when>
									<c:when test="${question.ans2_1_4 == 4}">そう思う</c:when>
									<c:when test="${question.ans2_1_4 == 3}">どちらともいえない</c:when>
									<c:when test="${question.ans2_1_4 == 2}">思わない</c:when>
									<c:when test="${question.ans2_1_4 == 1}">全く思わない</c:when>
								</c:choose></td>
						</tr>
						<tr>
							<td class="topAndBottomBorderDelete"></td>
							<td>⑤適切と思う日数を記入してください</td>
							<td></td>
							<td>${question.ans2_1_5}日間が適切</td>
						</tr>
						<tr>
							<td></td>
							<td>⑥感想を自由にお書きください</td>
							<td></td>
							<td>${question.ans2_1_6}</td>
						</tr>
					</table>
					<div class="questionTitle2">(2)Java｛7日間｝</div>
					<table class="questionCheckTable2">
						<tr>
							<td></td>
							<td>①講義は今後に役立つ内容でしたか</td>
							<td></td>
							<td><c:choose>
									<c:when test="${question.ans2_2_1 == 5}">非常にそう思う</c:when>
									<c:when test="${question.ans2_2_1 == 4}">そう思う</c:when>
									<c:when test="${question.ans2_2_1 == 3}">どちらともいえない</c:when>
									<c:when test="${question.ans2_2_1 == 2}">思わない</c:when>
									<c:when test="${question.ans2_2_1 == 1}">全く思わない</c:when>
								</c:choose></td>
						</tr>
						<tr>
							<td class="topAndBottomBorderDelete"></td>
							<td>②講師の説明はわかりやすかったですか</td>
							<td></td>
							<td><c:choose>
									<c:when test="${question.ans2_2_2 == 5}">非常にそう思う</c:when>
									<c:when test="${question.ans2_2_2 == 4}">そう思う</c:when>
									<c:when test="${question.ans2_2_2 == 3}">どちらともいえない</c:when>
									<c:when test="${question.ans2_2_2 == 2}">思わない</c:when>
									<c:when test="${question.ans2_2_2 == 1}">全く思わない</c:when>
								</c:choose></td>
						</tr>
						<tr>
							<td class="topAndBottomBorderDelete"></td>
							<td>③講義資料はわかりやすかったですか</td>
							<td></td>
							<td><c:choose>
									<c:when test="${question.ans2_2_3 == 5}">非常にそう思う</c:when>
									<c:when test="${question.ans2_2_3 == 4}">そう思う</c:when>
									<c:when test="${question.ans2_2_3 == 3}">どちらともいえない</c:when>
									<c:when test="${question.ans2_2_3 == 2}">思わない</c:when>
									<c:when test="${question.ans2_2_3 == 1}">全く思わない</c:when>
								</c:choose></td>
						</tr>
						<tr>
							<td class="topAndBottomBorderDelete"></td>
							<td>④この科目の時間数は適切でしたか</td>
							<td></td>
							<td><c:choose>
									<c:when test="${question.ans2_2_4 == 5}">非常にそう思う</c:when>
									<c:when test="${question.ans2_2_4 == 4}">そう思う</c:when>
									<c:when test="${question.ans2_2_4 == 3}">どちらともいえない</c:when>
									<c:when test="${question.ans2_2_4 == 2}">思わない</c:when>
									<c:when test="${question.ans2_2_4 == 1}">全く思わない</c:when>
								</c:choose></td>
						</tr>
						<tr>
							<td class="topAndBottomBorderDelete"></td>
							<td>⑤適切と思う日数を記入してください</td>
							<td></td>
							<td>${question.ans2_2_5}日間が適切</td>
						</tr>
						<tr>
							<td></td>
							<td>⑥感想を自由にお書きください</td>
							<td></td>
							<td>${question.ans2_2_6}</td>
						</tr>
					</table>
					<div class="questionTitle2">(3)Webアプリケーション｛10日間｝</div>
					<table class="questionCheckTable2">
						<tr>
							<td></td>
							<td>①講義は今後に役立つ内容でしたか</td>
							<td></td>
							<td><c:choose>
									<c:when test="${question.ans2_3_1 == 5}">非常にそう思う</c:when>
									<c:when test="${question.ans2_3_1 == 4}">そう思う</c:when>
									<c:when test="${question.ans2_3_1 == 3}">どちらともいえない</c:when>
									<c:when test="${question.ans2_3_1 == 2}">思わない</c:when>
									<c:when test="${question.ans2_3_1 == 1}">全く思わない</c:when>
								</c:choose></td>
						</tr>
						<tr>
							<td class="topAndBottomBorderDelete"></td>
							<td>②講師の説明はわかりやすかったですか</td>
							<td></td>
							<td><c:choose>
									<c:when test="${question.ans2_3_2 == 5}">非常にそう思う</c:when>
									<c:when test="${question.ans2_3_2 == 4}">そう思う</c:when>
									<c:when test="${question.ans2_3_2 == 3}">どちらともいえない</c:when>
									<c:when test="${question.ans2_3_2 == 2}">思わない</c:when>
									<c:when test="${question.ans2_3_2 == 1}">全く思わない</c:when>
								</c:choose></td>
						</tr>
						<tr>
							<td class="topAndBottomBorderDelete"></td>
							<td>③講義資料はわかりやすかったですか</td>
							<td></td>
							<td><c:choose>
									<c:when test="${question.ans2_3_3 == 5}">非常にそう思う</c:when>
									<c:when test="${question.ans2_3_3 == 4}">そう思う</c:when>
									<c:when test="${question.ans2_3_3 == 3}">どちらともいえない</c:when>
									<c:when test="${question.ans2_3_3 == 2}">思わない</c:when>
									<c:when test="${question.ans2_3_3 == 1}">全く思わない</c:when>
								</c:choose></td>
						</tr>
						<tr>
							<td class="topAndBottomBorderDelete"></td>
							<td>④この科目の時間数は適切でしたか</td>
							<td></td>
							<td><c:choose>
									<c:when test="${question.ans2_3_4 == 5}">非常にそう思う</c:when>
									<c:when test="${question.ans2_3_4 == 4}">そう思う</c:when>
									<c:when test="${question.ans2_3_4 == 3}">どちらともいえない</c:when>
									<c:when test="${question.ans2_3_4 == 2}">思わない</c:when>
									<c:when test="${question.ans2_3_4 == 1}">全く思わない</c:when>
								</c:choose></td>
						</tr>
						<tr>
							<td class="topAndBottomBorderDelete"></td>
							<td>⑤適切と思う日数を記入してください</td>
							<td></td>
							<td>${question.ans2_3_5}日間が適切</td>
						</tr>
						<tr>
							<td></td>
							<td>⑥感想を自由にお書きください</td>
							<td></td>
							<td>${question.ans2_3_6}</td>
						</tr>
					</table>
					<div class="questionTitle2">(4)仕事の進め方｛1日間｝</div>
					<table class="questionCheckTable2">
						<tr>
							<td></td>
							<td>①講義は今後に役立つ内容でしたか</td>
							<td></td>
							<td><c:choose>
									<c:when test="${question.ans2_4_1 == 5}">非常にそう思う</c:when>
									<c:when test="${question.ans2_4_1 == 4}">そう思う</c:when>
									<c:when test="${question.ans2_4_1 == 3}">どちらともいえない</c:when>
									<c:when test="${question.ans2_4_1 == 2}">思わない</c:when>
									<c:when test="${question.ans2_4_1 == 1}">全く思わない</c:when>
								</c:choose></td>
						</tr>
						<tr>
							<td class="topAndBottomBorderDelete"></td>
							<td>②講師の説明はわかりやすかったですか</td>
							<td></td>
							<td><c:choose>
									<c:when test="${question.ans2_4_2 == 5}">非常にそう思う</c:when>
									<c:when test="${question.ans2_4_2 == 4}">そう思う</c:when>
									<c:when test="${question.ans2_4_2 == 3}">どちらともいえない</c:when>
									<c:when test="${question.ans2_4_2 == 2}">思わない</c:when>
									<c:when test="${question.ans2_4_2 == 1}">全く思わない</c:when>
								</c:choose></td>
						</tr>
						<tr>
							<td class="topAndBottomBorderDelete"></td>
							<td>③講義資料はわかりやすかったですか</td>
							<td></td>
							<td><c:choose>
									<c:when test="${question.ans2_4_3 == 5}">非常にそう思う</c:when>
									<c:when test="${question.ans2_4_3 == 4}">そう思う</c:when>
									<c:when test="${question.ans2_4_3 == 3}">どちらともいえない</c:when>
									<c:when test="${question.ans2_4_3 == 2}">思わない</c:when>
									<c:when test="${question.ans2_4_3 == 1}">全く思わない</c:when>
								</c:choose></td>
						</tr>
						<tr>
							<td class="topAndBottomBorderDelete"></td>
							<td>④この科目の時間数は適切でしたか</td>
							<td></td>
							<td><c:choose>
									<c:when test="${question.ans2_4_4 == 5}">非常にそう思う</c:when>
									<c:when test="${question.ans2_4_4 == 4}">そう思う</c:when>
									<c:when test="${question.ans2_4_4 == 3}">どちらともいえない</c:when>
									<c:when test="${question.ans2_4_4 == 2}">思わない</c:when>
									<c:when test="${question.ans2_4_4 == 1}">全く思わない</c:when>
								</c:choose></td>
						</tr>
						<tr>
							<td class="topAndBottomBorderDelete"></td>
							<td>⑤適切と思う日数を記入してください</td>
							<td></td>
							<td>${question.ans2_4_5}日間が適切</td>
						</tr>
						<tr>
							<td></td>
							<td>⑥感想を自由にお書きください</td>
							<td></td>
							<td>${question.ans2_4_6}</td>
						</tr>
					</table>
					<div class="questionTitle2">(5)Webアプリケーション演習｛13日間｝</div>
					<table class="questionCheckTable2">
						<tr>
							<td></td>
							<td>①講義は今後に役立つ内容でしたか</td>
							<td></td>
							<td><c:choose>
									<c:when test="${question.ans2_5_1 == 5}">非常にそう思う</c:when>
									<c:when test="${question.ans2_5_1 == 4}">そう思う</c:when>
									<c:when test="${question.ans2_5_1 == 3}">どちらともいえない</c:when>
									<c:when test="${question.ans2_5_1 == 2}">思わない</c:when>
									<c:when test="${question.ans2_5_1 == 1}">全く思わない</c:when>
								</c:choose></td>
						</tr>
						<tr>
							<td class="topAndBottomBorderDelete"></td>
							<td>②講師の説明はわかりやすかったですか</td>
							<td></td>
							<td><c:choose>
									<c:when test="${question.ans2_5_2 == 5}">非常にそう思う</c:when>
									<c:when test="${question.ans2_5_2 == 4}">そう思う</c:when>
									<c:when test="${question.ans2_5_2 == 3}">どちらともいえない</c:when>
									<c:when test="${question.ans2_5_2 == 2}">思わない</c:when>
									<c:when test="${question.ans2_5_2 == 1}">全く思わない</c:when>
								</c:choose></td>
						</tr>
						<tr>
							<td class="topAndBottomBorderDelete"></td>
							<td>③講義資料はわかりやすかったですか</td>
							<td></td>
							<td><c:choose>
									<c:when test="${question.ans2_5_3 == 5}">非常にそう思う</c:when>
									<c:when test="${question.ans2_5_3 == 4}">そう思う</c:when>
									<c:when test="${question.ans2_5_3 == 3}">どちらともいえない</c:when>
									<c:when test="${question.ans2_5_3 == 2}">思わない</c:when>
									<c:when test="${question.ans2_5_3 == 1}">全く思わない</c:when>
								</c:choose></td>
						</tr>
						<tr>
							<td class="topAndBottomBorderDelete"></td>
							<td>④この科目の時間数は適切でしたか</td>
							<td></td>
							<td><c:choose>
									<c:when test="${question.ans2_5_4 == 5}">非常にそう思う</c:when>
									<c:when test="${question.ans2_5_4 == 4}">そう思う</c:when>
									<c:when test="${question.ans2_5_4 == 3}">どちらともいえない</c:when>
									<c:when test="${question.ans2_5_4 == 2}">思わない</c:when>
									<c:when test="${question.ans2_5_4 == 1}">全く思わない</c:when>
								</c:choose></td>
						</tr>
						<tr>
							<td class="topAndBottomBorderDelete"></td>
							<td>⑤適切と思う日数を記入してください</td>
							<td></td>
							<td>${question.ans2_5_5}日間が適切</td>
						</tr>
						<tr>
							<td></td>
							<td>⑥感想を自由にお書きください</td>
							<td></td>
							<td>${question.ans2_5_6}</td>
						</tr>
					</table>
					<div class="questionTitle2">(6)システム開発演習｛20日間｝</div>
					<table class="questionCheckTable2">
						<tr>
							<td></td>
							<td>①講義は今後に役立つ内容でしたか</td>
							<td></td>
							<td><c:choose>
									<c:when test="${question.ans2_6_1 == 5}">非常にそう思う</c:when>
									<c:when test="${question.ans2_6_1 == 4}">そう思う</c:when>
									<c:when test="${question.ans2_6_1 == 3}">どちらともいえない</c:when>
									<c:when test="${question.ans2_6_1 == 2}">思わない</c:when>
									<c:when test="${question.ans2_6_1 == 1}">全く思わない</c:when>
								</c:choose></td>
						</tr>
						<tr>
							<td class="topAndBottomBorderDelete"></td>
							<td>②講師の説明はわかりやすかったですか</td>
							<td></td>
							<td><c:choose>
									<c:when test="${question.ans2_6_2 == 5}">非常にそう思う</c:when>
									<c:when test="${question.ans2_6_2 == 4}">そう思う</c:when>
									<c:when test="${question.ans2_6_2 == 3}">どちらともいえない</c:when>
									<c:when test="${question.ans2_6_2 == 2}">思わない</c:when>
									<c:when test="${question.ans2_6_2 == 1}">全く思わない</c:when>
								</c:choose></td>
						</tr>
						<tr>
							<td class="topAndBottomBorderDelete"></td>
							<td>③講義資料はわかりやすかったですか</td>
							<td></td>
							<td><c:choose>
									<c:when test="${question.ans2_6_3 == 5}">非常にそう思う</c:when>
									<c:when test="${question.ans2_6_3 == 4}">そう思う</c:when>
									<c:when test="${question.ans2_6_3 == 3}">どちらともいえない</c:when>
									<c:when test="${question.ans2_6_3 == 2}">思わない</c:when>
									<c:when test="${question.ans2_6_3 == 1}">全く思わない</c:when>
								</c:choose></td>
						</tr>
						<tr>
							<td class="topAndBottomBorderDelete"></td>
							<td>④この科目の時間数は適切でしたか</td>
							<td></td>
							<td><c:choose>
									<c:when test="${question.ans2_6_4 == 5}">非常にそう思う</c:when>
									<c:when test="${question.ans2_6_4 == 4}">そう思う</c:when>
									<c:when test="${question.ans2_6_4 == 3}">どちらともいえない</c:when>
									<c:when test="${question.ans2_6_4 == 2}">思わない</c:when>
									<c:when test="${question.ans2_6_4 == 1}">全く思わない</c:when>
								</c:choose></td>
						</tr>
						<tr>
							<td class="topAndBottomBorderDelete"></td>
							<td>⑤適切と思う日数を記入してください</td>
							<td></td>
							<td>${question.ans2_6_5}日間が適切</td>
						</tr>
						<tr>
							<td></td>
							<td>⑥感想を自由にお書きください</td>
							<td></td>
							<td>${question.ans2_6_6}</td>
						</tr>
					</table>
				</div>
				<div>
					<div class="questionTitle1">3．その他についてお聞きします。</div>
					<table class="questionCheckTable">
						<tr>
							<td>(1)今後受けてみたい研修があればお聞かせください。</td>
							<td></td>
							<td>${question.ans3_1}</td>
						</tr>
						<tr>
							<td>(2)新入社員研修全般に関する意見・要望等についてご自由にお書きください。</td>
							<td></td>
							<td>${question.ans3_2}</td>
						</tr>
					</table>
				</div>
			</div>
			<form name="defaultLink2" action="question.do" method="post">
				<input type="hidden" name="action" />
				<table class="button">
					<tr>
						<td>
							<p style="position: relative;">
								<input type="image" src="img/complete.png"
									onclick="goSubmit(this.form, this);"
									name="QuestionComplete_btn" value="" alt="回答する">
							</p>
						</td>
						<td>
							<p style="position: relative;">
								<input type="image" src="img/back-2.png"
									onclick="goSubmit(this.form, this);" name="QuestionBack_btn"
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