<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/util.tld" prefix="util"%>

<!DOCTYPE HTML PUBLIC>
<html>
<head>
<meta name="robots" content="noindex">
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=0">
<link rel="stylesheet" href="css/style.css" type="text/css"
	media="screen and (min-width: 640px)">
<link rel="stylesheet" href="css/question.css" type="text/css"
	media="screen and (min-width: 640px)">
<link rel="stylesheet" href="css/question_sp.css" type="text/css"
	media="screen and (max-width: 640px)">
<link rel="stylesheet" href="css/featherlight.css"
	media="screen and (min-width: 640px)">
<link rel="stylesheet" href="css/featherlight_sp.css"
	media="screen and (max-width: 640px)">
<script type="text/javascript" charset="UTF-8" src="js/change.js"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="https://cdn.datatables.net/t/bs-3.3.6/jqc-1.12.0,dt-1.10.11/datatables.min.js"></script>
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
			<p id="questionHeader">アンケート</p>
			<form name="defaultLink2" action="question.do" method="post">
				<input type="hidden" name="action" />
				<p id="questionIntroduction">
					弊社システムクォートでは、よりよい研修を実施していくために、受講者全員にアンケートをお願いしております。<br />
					今回受講した新入社員研修について意見や感想をお聞かせください。 &nbsp;<span style="color: red">*</span>入力必須項目
				</p>
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
				<div class="questionTitle1">
					1. 研修全般についてお聞きします。<span class="questionSmall">（該当する項目を選択して、その理由等を記入してください。）</span><br />
				</div>
				<div class="questionTitle2">
					(1)今回の研修についてどのような印象をお持ちですか。<span style="color: red">*</span><br />
				</div>
				<div class="questionContent">
					<div class="questionSelect">
						<c:choose>
							<c:when test="${question.ans1_1_1 == 5}">
								<div>
									<label><input class="questionInput" type="radio"
										name="a1_1_1" value="5" checked> 大変有意義であった</label>
								</div>
							</c:when>
							<c:otherwise>
								<div>
									<label><input class="questionInput" type="radio"
										name="a1_1_1" value="5"> 大変有意義であった</label>
								</div>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${question.ans1_1_1 == 4}">
								<div>
									<label><input class="questionInput" type="radio"
										name="a1_1_1" value="4" checked> 有意義であった</label>
								</div>
							</c:when>
							<c:otherwise>
								<div>
									<label><input class="questionInput" type="radio"
										name="a1_1_1" value="4"> 有意義であった</label>
								</div>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${question.ans1_1_1 == 3}">
								<div>
									<label><input class="questionInput" type="radio"
										name="a1_1_1" value="3" checked> まあまあだった</label>
								</div>
							</c:when>
							<c:otherwise>
								<div>
									<label><input class="questionInput" type="radio"
										name="a1_1_1" value="3"> まあまあだった</label>
								</div>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${question.ans1_1_1 == 2}">
								<div>
									<label><input class="questionInput" type="radio"
										name="a1_1_1" value="2" checked> 物足りなかった</label>
								</div>
							</c:when>
							<c:otherwise>
								<div>
									<label><input class="questionInput" type="radio"
										name="a1_1_1" value="2"> 物足りなかった</label>
								</div>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${question.ans1_1_1 == 1}">
								<div>
									<label><input class="questionInput" type="radio"
										name="a1_1_1" value="1" checked> 非常に不満足</label>
								</div>
							</c:when>
							<c:otherwise>
								<div>
									<label><input class="questionInput" type="radio"
										name="a1_1_1" value="1"> 非常に不満足</label>
								</div>
							</c:otherwise>
						</c:choose>
					</div>
					<br />
					<textarea class="questionTextarea" name="a1_1_2" rows="4" cols="40"
						placeholder="感想を自由にお書きください。" maxlength="300">${question.ans1_1_2}</textarea>
				</div>
				<div class="questionTitle2">
					(2)今回の研修は今後の職務に活かせると感じましたか。<span style="color: red">*</span><br />
				</div>
				<div class="questionContent">
					<div class="questionSelect">
						<c:choose>
							<c:when test="${question.ans1_2_1 == 3}">
								<div>
									<label><input class="questionInput" type="radio"
										name="a1_2_1" value="3" checked>大いに活かせる</label>
								</div>
							</c:when>
							<c:otherwise>
								<div>
									<label><input class="questionInput" type="radio"
										name="a1_2_1" value="3">大いに活かせる</label>
								</div>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${question.ans1_2_1 == 2}">
								<div>
									<label><input class="questionInput" type="radio"
										name="a1_2_1" value="2" checked>いくらか活かせる</label>
								</div>
							</c:when>
							<c:otherwise>
								<div>
									<label><input class="questionInput" type="radio"
										name="a1_2_1" value="2">いくらか活かせる</label>
								</div>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${question.ans1_2_1 == 1}">
								<div>
									<label><input class="questionInput" type="radio"
										name="a1_2_1" value="1" checked>ほとんど活かせない</label>
								</div>
							</c:when>
							<c:otherwise>
								<div>
									<label><input class="questionInput" type="radio"
										name="a1_2_1" value="1">ほとんど活かせない</label>
								</div>
							</c:otherwise>
						</c:choose>
					</div>
					<br />
					<textarea class="questionTextarea" name="a1_2_2" rows="4" cols="40"
						placeholder="感想を自由にお書きください。" maxlength="300">${question.ans1_2_2}</textarea>
				</div>
				<div class="questionTitle2">
					(3)研修期間はどうでしたか。<span style="color: red">*</span><br />
				</div>
				<div class="questionContent">
					<div class="questionSelect">
						<c:choose>
							<c:when test="${question.ans1_3_1 == 3}">
								<div>
									<label><input class="questionInput" type="radio"
										name="a1_3_1" value="3" checked>適切だった</label>
								</div>
							</c:when>
							<c:otherwise>
								<div>
									<label><input class="questionInput" type="radio"
										name="a1_3_1" value="3">適切だった</label>
								</div>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${question.ans1_3_1 == 2}">
								<div>
									<label><input class="questionInput" type="radio"
										name="a1_3_1" value="2" checked>長すぎる</label>
								</div>
							</c:when>
							<c:otherwise>
								<div>
									<label><input class="questionInput" type="radio"
										name="a1_3_1" value="2">長すぎる</label>
								</div>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${question.ans1_3_1 == 1}">
								<div>
									<label><input class="questionInput" type="radio"
										name="a1_3_1" value="1" checked>短すぎる</label>
								</div>
							</c:when>
							<c:otherwise>
								<div>
									<label><input class="questionInput" type="radio"
										name="a1_3_1" value="1">短すぎる</label>
								</div>
							</c:otherwise>
						</c:choose>
					</div>
					<div class="appropriate">
						※「長すぎる」「短すぎる」を選択した場合のみお答えください。 <br /> <input
							class="questionInput" type="number" min="0" max="99"
							name="a1_3_2" maxlength="2" value="${question.ans1_3_2}" />日間が適切<br />
					</div>
				</div>
				<div class="questionTitle1">
					2. 各研修項目についてお聞きします。｛〇日間｝は今回の研修での日数が記載されています。<br />
				</div>
				<div class="questionTitle2">(1)ITリテラシー｛4日間｝</div>
				<div class="questionContent">
					<table class="questionTable">
						<tr>
							<th>項目</th>
							<th>良</th>
							<th>←</th>
							<th>並</th>
							<th>→</th>
							<th>悪</th>
						</tr>
						<tr class="last">
							<td class= "item1">①講義は今後に役立つ内容でしたか。<span style="color: red">*</span></td>
							<td class= "cell item1-2"><c:choose>
									<c:when test="${question.ans2_1_1 == 5}">
										<input type="radio" name="a2_1_1" value="5" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_1_1" value="5">
									</c:otherwise>
								</c:choose></td>
							<td class= "cell item1-3"><c:choose>
									<c:when test="${question.ans2_1_1 == 4}">
										<input type="radio" name="a2_1_1" value="4" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_1_1" value="4">
									</c:otherwise>
								</c:choose></td>
							<td class= "cell item1-4"><c:choose>
									<c:when test="${question.ans2_1_1 == 3}">
										<input type="radio" name="a2_1_1" value="3" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_1_1" value="3">
									</c:otherwise>
								</c:choose></td>
							<td class= "cell item1-5"><c:choose>
									<c:when test="${question.ans2_1_1 == 2}">
										<input type="radio" name="a2_1_1" value="2" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_1_1" value="2">
									</c:otherwise>
								</c:choose></td>
							<td class= "cell item1-6"><c:choose>
									<c:when test="${question.ans2_1_1 == 1}">
										<input type="radio" name="a2_1_1" value="1" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_1_1" value="1">
									</c:otherwise>
								</c:choose></td>
						</tr>
						<tr>
							<td class= "item1">②講師の説明は分かりやすかったですか。<span style="color: red">*</span></td>
							<td><c:choose>
									<c:when test="${question.ans2_1_2 == 5}">
										<input type="radio" name="a2_1_2" value="5" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_1_2" value="5">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_1_2 == 4}">
										<input type="radio" name="a2_1_2" value="4" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_1_2" value="4">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_1_2 == 3}">
										<input type="radio" name="a2_1_2" value="3" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_1_2" value="3">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_1_2 == 2}">
										<input type="radio" name="a2_1_2" value="2" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_1_2" value="2">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_1_2 == 1}">
										<input type="radio" name="a2_1_2" value="1" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_1_2" value="1">
									</c:otherwise>
								</c:choose></td>
						</tr>
						<tr>
							<td class= "item1">③講義資料は分かりやすかったですか。<span style="color: red">*</span></td>
							<td><c:choose>
									<c:when test="${question.ans2_1_3 == 5}">
										<input type="radio" name="a2_1_3" value="5" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_1_3" value="5">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_1_3 == 4}">
										<input type="radio" name="a2_1_3" value="4" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_1_3" value="4">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_1_3 == 3}">
										<input type="radio" name="a2_1_3" value="3" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_1_3" value="3">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_1_3 == 2}">
										<input type="radio" name="a2_1_3" value="2" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_1_3" value="2">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_1_3 == 1}">
										<input type="radio" name="a2_1_3" value="1" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_1_3" value="1">
									</c:otherwise>
								</c:choose></td>
						</tr>
						<tr>
							<td class= "item1">④この科目の時間数は適切でしたか。<span style="color: red">*</span></td>
							<td><c:choose>
									<c:when test="${question.ans2_1_4 == 5}">
										<input type="radio" name="a2_1_4" value="5" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_1_4" value="5">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_1_4 == 4}">
										<input type="radio" name="a2_1_4" value="4" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_1_4" value="4">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_1_4 == 3}">
										<input type="radio" name="a2_1_4" value="3" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_1_4" value="3">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_1_4 == 2}">
										<input type="radio" name="a2_1_4" value="2" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_1_4" value="2">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_1_4 == 1}">
										<input type="radio" name="a2_1_4" value="1" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_1_4" value="1">
									</c:otherwise>
								</c:choose></td>
						</tr>
					</table>
					<div class="appropriate">
						※時間数について、「思わない」「全く思わない」を選択した場合のみお答えください。<br />⑤適切と思う日数を記入してください。<br />
						<input type="number" min="0" max="99" name="a2_1_5" maxlength="2"
							value="${question.ans2_1_5}">日間が適切
					</div>
					<div class="impression">
						⑥感想を自由にお書きください。 <br />
						<textarea class="questionTextarea" name="a2_1_6" rows="4"
							cols="80" maxlength="300">${question.ans2_1_6}</textarea>
					</div>
				</div>
				<div class="questionTitle2">(2)Java｛7日間｝</div>
				<div class="questionContent">
					<table class="questionTable">
						<tr>
							<th>項目</th>
							<th>良</th>
							<th>←</th>
							<th>並</th>
							<th>→</th>
							<th>悪</th>
						<tr>
							<td class= "item1">①講義は今後に役立つ内容でしたか。<span style="color: red">*</span></td>
							<td><c:choose>
									<c:when test="${question.ans2_2_1 == 5}">
										<input type="radio" name="a2_2_1" value="5" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_2_1" value="5">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_2_1 == 4}">
										<input type="radio" name="a2_2_1" value="4" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_2_1" value="4">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_2_1 == 3}">
										<input type="radio" name="a2_2_1" value="3" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_2_1" value="3">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_2_1 == 2}">
										<input type="radio" name="a2_2_1" value="2" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_2_1" value="2">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_2_1 == 1}">
										<input type="radio" name="a2_2_1" value="1" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_2_1" value="1">
									</c:otherwise>
								</c:choose></td>
						</tr>
						<tr>
							<td class= "item1">②講師の説明は分かりやすかったですか。<span style="color: red">*</span></td>
							<td><c:choose>
									<c:when test="${question.ans2_2_2 == 5}">
										<input type="radio" name="a2_2_2" value="5" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_2_2" value="5">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_2_2 == 4}">
										<input type="radio" name="a2_2_2" value="4" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_2_2" value="4">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_2_2 == 3}">
										<input type="radio" name="a2_2_2" value="3" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_2_2" value="3">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_2_2 == 2}">
										<input type="radio" name="a2_2_2" value="2" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_2_2" value="2">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_2_2 == 1}">
										<input type="radio" name="a2_2_2" value="1" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_2_2" value="1">
									</c:otherwise>
								</c:choose></td>
						</tr>
						<tr>
							<td class= "item1">③講義資料は分かりやすかったですか。<span style="color: red">*</span></td>
							<td><c:choose>
									<c:when test="${question.ans2_2_3 == 5}">
										<input type="radio" name="a2_2_3" value="5" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_2_3" value="5">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_2_3 == 4}">
										<input type="radio" name="a2_2_3" value="4" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_2_3" value="4">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_2_3 == 3}">
										<input type="radio" name="a2_2_3" value="3" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_2_3" value="3">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_2_3 == 2}">
										<input type="radio" name="a2_2_3" value="2" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_2_3" value="2">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_2_3 == 1}">
										<input type="radio" name="a2_2_3" value="1" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_2_3" value="1">
									</c:otherwise>
								</c:choose></td>
						</tr>
						<tr>
							<td class= "item1">④この科目の時間数は適切でしたか。<span style="color: red">*</span></td>
							<td><c:choose>
									<c:when test="${question.ans2_2_4 == 5}">
										<input type="radio" name="a2_2_4" value="5" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_2_4" value="5">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_2_4 == 4}">
										<input type="radio" name="a2_2_4" value="4" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_2_4" value="4">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_2_4 == 3}">
										<input type="radio" name="a2_2_4" value="3" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_2_4" value="3">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_2_4 == 2}">
										<input type="radio" name="a2_2_4" value="2" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_2_4" value="2">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_2_4 == 1}">
										<input type="radio" name="a2_2_4" value="1" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_2_4" value="1">
									</c:otherwise>
								</c:choose></td>
						</tr>
					</table>
					<div class="appropriate">
						※時間数について、「思わない」「全く思わない」を選択した場合のみお答えください。<br />⑤適切と思う日数を記入してください。<br />
						<input type="number" min="0" max="99" name="a2_2_5" maxlength="2"
							value="${question.ans2_2_5}">日間が適切
					</div>
					<div class="impression">
						⑥感想を自由にお書きください。 <br />
						<textarea class="questionTextarea" name="a2_2_6" rows="4"
							cols="80" maxlength="300">${question.ans2_2_6}</textarea>
					</div>
				</div>
				<div class="questionTitle2">(3)Webアプリケーション｛10日間｝</div>
				<div class="questionContent">
					<table class="questionTable">
						<tr>
							<th>項目</th>
							<th>良</th>
							<th>←</th>
							<th>並</th>
							<th>→</th>
							<th>悪</th>
						<tr>
							<td class= "item1">①講義は今後に役立つ内容でしたか。<span style="color: red">*</span></td>
							<td><c:choose>
									<c:when test="${question.ans2_3_1 == 5}">
										<input type="radio" name="a2_3_1" value="5" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_3_1" value="5">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_3_1 == 4}">
										<input type="radio" name="a2_3_1" value="4" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_3_1" value="4">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_3_1 == 3}">
										<input type="radio" name="a2_3_1" value="3" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_3_1" value="3">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_3_1 == 2}">
										<input type="radio" name="a2_3_1" value="2" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_3_1" value="2">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_3_1 == 1}">
										<input type="radio" name="a2_3_1" value="1" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_3_1" value="1">
									</c:otherwise>
								</c:choose></td>
						</tr>
						<tr>
							<td class= "item1">②講師の説明は分かりやすかったですか。<span style="color: red">*</span></td>
							<td><c:choose>
									<c:when test="${question.ans2_3_2 == 5}">
										<input type="radio" name="a2_3_2" value="5" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_3_2" value="5">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_3_2 == 4}">
										<input type="radio" name="a2_3_2" value="4" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_3_2" value="4">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_3_2 == 3}">
										<input type="radio" name="a2_3_2" value="3" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_3_2" value="3">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_3_2 == 2}">
										<input type="radio" name="a2_3_2" value="2" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_3_2" value="2">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_3_2 == 1}">
										<input type="radio" name="a2_3_2" value="1" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_3_2" value="1">
									</c:otherwise>
								</c:choose></td>
						</tr>
						<tr>
							<td class= "item1">③講義資料は分かりやすかったですか。<span style="color: red">*</span></td>
							<td><c:choose>
									<c:when test="${question.ans2_3_3 == 5}">
										<input type="radio" name="a2_3_3" value="5" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_3_3" value="5">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_3_3 == 4}">
										<input type="radio" name="a2_3_3" value="4" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_3_3" value="4">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_3_3 == 3}">
										<input type="radio" name="a2_3_3" value="3" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_3_3" value="3">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_3_3 == 2}">
										<input type="radio" name="a2_3_3" value="2" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_3_3" value="2">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_3_3 == 1}">
										<input type="radio" name="a2_3_3" value="1" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_3_3" value="1">
									</c:otherwise>
								</c:choose></td>
						</tr>
						<tr>
							<td class= "item1">④この科目の時間数は適切でしたか。<span style="color: red">*</span></td>
							<td><c:choose>
									<c:when test="${question.ans2_3_4 == 5}">
										<input type="radio" name="a2_3_4" value="5" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_3_4" value="5">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_3_4 == 4}">
										<input type="radio" name="a2_3_4" value="4" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_3_4" value="4">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_3_4 == 3}">
										<input type="radio" name="a2_3_4" value="3" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_3_4" value="3">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_3_4 == 2}">
										<input type="radio" name="a2_3_4" value="2" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_3_4" value="2">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_3_4 == 1}">
										<input type="radio" name="a2_3_4" value="1" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_3_4" value="1">
									</c:otherwise>
								</c:choose></td>
						</tr>
					</table>
					<div class="appropriate">
						※時間数について、「思わない」「全く思わない」を選択した場合のみお答えください。<br /> ⑤適切と思う日数を記入してください。<br />
						<input type="number" min="0" max="99" name="a2_3_5" maxlength="2"
							value="${question.ans2_3_5}">日間が適切
					</div>
					<div class="impression">
						⑥感想を自由にお書きください。 <br />
						<textarea class="questionTextarea" name="a2_3_6" rows="4"
							cols="80" maxlength="300">${question.ans2_3_6}</textarea>
					</div>
				</div>
				<div class="questionTitle2">(4)仕事の進め方｛1日間｝</div>
				<div class="questionContent">
					<table class="questionTable">
						<tr>
							<th>項目</th>
							<th>良</th>
							<th>←</th>
							<th>並</th>
							<th>→</th>
							<th>悪</th>
						<tr>
							<td class= "item1">①講義は今後に役立つ内容でしたか。<span style="color: red">*</span></td>
							<td><c:choose>
									<c:when test="${question.ans2_4_1 == 5}">
										<input type="radio" name="a2_4_1" value="5" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_4_1" value="5">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_4_1 == 4}">
										<input type="radio" name="a2_4_1" value="4" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_4_1" value="4">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_4_1 == 3}">
										<input type="radio" name="a2_4_1" value="3" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_4_1" value="3">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_4_1 == 2}">
										<input type="radio" name="a2_4_1" value="2" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_4_1" value="2">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_4_1 == 1}">
										<input type="radio" name="a2_4_1" value="1" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_4_1" value="1">
									</c:otherwise>
								</c:choose></td>
						</tr>
						<tr>
							<td class= "item1">②講師の説明は分かりやすかったですか。<span style="color: red">*</span></td>
							<td><c:choose>
									<c:when test="${question.ans2_4_2 == 5}">
										<input type="radio" name="a2_4_2" value="5" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_4_2" value="5">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_4_2 == 4}">
										<input type="radio" name="a2_4_2" value="4" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_4_2" value="4">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_4_2 == 3}">
										<input type="radio" name="a2_4_2" value="3" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_4_2" value="3">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_4_2 == 2}">
										<input type="radio" name="a2_4_2" value="2" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_4_2" value="2">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_4_2 == 1}">
										<input type="radio" name="a2_4_2" value="1" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_4_2" value="1">
									</c:otherwise>
								</c:choose></td>
						</tr>
						<tr>
							<td class= "item1">③講義資料は分かりやすかったですか。<span style="color: red">*</span></td>
							<td><c:choose>
									<c:when test="${question.ans2_4_3 == 5}">
										<input type="radio" name="a2_4_3" value="5" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_4_3" value="5">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_4_3 == 4}">
										<input type="radio" name="a2_4_3" value="4" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_4_3" value="4">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_4_3 == 3}">
										<input type="radio" name="a2_4_3" value="3" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_4_3" value="3">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_4_3 == 2}">
										<input type="radio" name="a2_4_3" value="2" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_4_3" value="2">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_4_3 == 1}">
										<input type="radio" name="a2_4_3" value="1" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_4_3" value="1">
									</c:otherwise>
								</c:choose></td>
						</tr>
						<tr>
							<td class= "item1">④この科目の時間数は適切でしたか。<span style="color: red">*</span></td>
							<td><c:choose>
									<c:when test="${question.ans2_4_4 == 5}">
										<input type="radio" name="a2_4_4" value="5" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_4_4" value="5">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_4_4 == 4}">
										<input type="radio" name="a2_4_4" value="4" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_4_4" value="4">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_4_4 == 3}">
										<input type="radio" name="a2_4_4" value="3" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_4_4" value="3">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_4_4 == 2}">
										<input type="radio" name="a2_4_4" value="2" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_4_4" value="2">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_4_4 == 1}">
										<input type="radio" name="a2_4_4" value="1" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_4_4" value="1">
									</c:otherwise>
								</c:choose></td>
						</tr>
					</table>
					<div class="appropriate">
						※時間数について、「思わない」「全く思わない」を選択した場合のみお答えください。 <br />
						⑤適切と思う日数を記入してください。<br /> <input type="number" min="0" max="99"
							name="a2_4_5" maxlength="2" value="${question.ans2_4_5}">日間が適切
					</div>
					<div class="impression">
						⑥感想を自由にお書きください。 <br />
						<textarea class="questionTextarea" name="a2_4_6" rows="4"
							cols="80" maxlength="300">${question.ans2_4_6}</textarea>
					</div>
				</div>
				<div class="questionTitle2">(5)Webアプリケーション演習｛13日間｝</div>
				<div class="questionContent">
					<table class="questionTable">
						<tr>
							<th>項目</th>
							<th>良</th>
							<th>←</th>
							<th>並</th>
							<th>→</th>
							<th>悪</th>
						<tr>
							<td class= "item1">①講義は今後に役立つ内容でしたか。<span style="color: red">*</span></td>
							<td><c:choose>
									<c:when test="${question.ans2_5_1 == 5}">
										<input type="radio" name="a2_5_1" value="5" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_5_1" value="5">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_5_1 == 4}">
										<input type="radio" name="a2_5_1" value="4" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_5_1" value="4">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_5_1 == 3}">
										<input type="radio" name="a2_5_1" value="3" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_5_1" value="3">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_5_1 == 2}">
										<input type="radio" name="a2_5_1" value="2" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_5_1" value="2">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_5_1 == 1}">
										<input type="radio" name="a2_5_1" value="1" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_5_1" value="1">
									</c:otherwise>
								</c:choose></td>
						</tr>
						<tr>
							<td class= "item1">②講師の説明は分かりやすかったですか。<span style="color: red">*</span></td>
							<td><c:choose>
									<c:when test="${question.ans2_5_2 == 5}">
										<input type="radio" name="a2_5_2" value="5" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_5_2" value="5">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_5_2 == 4}">
										<input type="radio" name="a2_5_2" value="4" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_5_2" value="4">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_5_2 == 3}">
										<input type="radio" name="a2_5_2" value="3" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_5_2" value="3">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_5_2 == 2}">
										<input type="radio" name="a2_5_2" value="2" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_5_2" value="2">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_5_2 == 1}">
										<input type="radio" name="a2_5_2" value="1" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_5_2" value="1">
									</c:otherwise>
								</c:choose></td>
						</tr>
						<tr>
							<td class= "item1">③講義資料は分かりやすかったですか。<span style="color: red">*</span></td>
							<td><c:choose>
									<c:when test="${question.ans2_5_3 == 5}">
										<input type="radio" name="a2_5_3" value="5" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_5_3" value="5">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_5_3 == 4}">
										<input type="radio" name="a2_5_3" value="4" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_5_3" value="4">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_5_3 == 3}">
										<input type="radio" name="a2_5_3" value="3" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_5_3" value="3">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_5_3 == 2}">
										<input type="radio" name="a2_5_3" value="2" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_5_3" value="2">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_5_3 == 1}">
										<input type="radio" name="a2_5_3" value="1" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_5_3" value="1">
									</c:otherwise>
								</c:choose></td>
						</tr>
						<tr>
							<td class= "item1">④この科目の時間数は適切でしたか。<span style="color: red">*</span></td>
							<td><c:choose>
									<c:when test="${question.ans2_5_4 == 5}">
										<input type="radio" name="a2_5_4" value="5" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_5_4" value="5">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_5_4 == 4}">
										<input type="radio" name="a2_5_4" value="4" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_5_4" value="4">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_5_4 == 3}">
										<input type="radio" name="a2_5_4" value="3" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_5_4" value="3">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_5_4 == 2}">
										<input type="radio" name="a2_5_4" value="2" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_5_4" value="2">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_5_4 == 1}">
										<input type="radio" name="a2_5_4" value="1" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_5_4" value="1">
									</c:otherwise>
								</c:choose></td>
						</tr>
					</table>
					<div class="appropriate">
						※時間数について、「思わない」「全く思わない」を選択した場合のみお答えください。 <br />
						⑤適切と思う日数を記入してください。<br /> <input type="number" min="0" max="99"
							name="a2_5_5" maxlength="2" value="${question.ans2_5_5}">日間が適切
					</div>
					<div class="impression">
						⑥感想を自由にお書きください。 <br />
						<textarea class="questionTextarea" name="a2_5_6" rows="4"
							cols="80" maxlength="300">${question.ans2_5_6}</textarea>
					</div>
				</div>
				<div class="questionTitle2">(6)システム開発演習｛20日間｝</div>
				<div class="questionContent">
					<table class="questionTable">
						<tr>
							<th>項目</th>
							<th>良</th>
							<th>←</th>
							<th>並</th>
							<th>→</th>
							<th>悪</th>
						<tr>
							<td class= "item1">①講義は今後に役立つ内容でしたか。<span style="color: red">*</span></td>
							<td><c:choose>
									<c:when test="${question.ans2_6_1 == 5}">
										<input type="radio" name="a2_6_1" value="5" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_6_1" value="5">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_6_1 == 4}">
										<input type="radio" name="a2_6_1" value="4" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_6_1" value="4">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_6_1 == 3}">
										<input type="radio" name="a2_6_1" value="3" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_6_1" value="3">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_6_1 == 2}">
										<input type="radio" name="a2_6_1" value="2" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_6_1" value="2">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_6_1 == 1}">
										<input type="radio" name="a2_6_1" value="1" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_6_1" value="1">
									</c:otherwise>
								</c:choose></td>
						</tr>
						<tr>
							<td class= "item1">②講師の説明は分かりやすかったですか。<span style="color: red">*</span></td>
							<td><c:choose>
									<c:when test="${question.ans2_6_2 == 5}">
										<input type="radio" name="a2_6_2" value="5" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_6_2" value="5">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_6_2 == 4}">
										<input type="radio" name="a2_6_2" value="4" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_6_2" value="4">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_6_2 == 3}">
										<input type="radio" name="a2_6_2" value="3" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_6_2" value="3">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_6_2 == 2}">
										<input type="radio" name="a2_6_2" value="2" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_6_2" value="2">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_6_2 == 1}">
										<input type="radio" name="a2_6_2" value="1" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_6_2" value="1">
									</c:otherwise>
								</c:choose></td>
						</tr>
						<tr>
							<td class= "item1">③講義資料は分かりやすかったですか。<span style="color: red">*</span></td>
							<td><c:choose>
									<c:when test="${question.ans2_6_3 == 5}">
										<input type="radio" name="a2_6_3" value="5" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_6_3" value="5">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_6_3 == 4}">
										<input type="radio" name="a2_6_3" value="4" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_6_3" value="4">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_6_3 == 3}">
										<input type="radio" name="a2_6_3" value="3" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_6_3" value="3">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_6_3 == 2}">
										<input type="radio" name="a2_6_3" value="2" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_6_3" value="2">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_6_3 == 1}">
										<input type="radio" name="a2_6_3" value="1" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_6_3" value="1">
									</c:otherwise>
								</c:choose></td>
						</tr>
						<tr>
							<td class= "item1">④この科目の時間数は適切でしたか。<span style="color: red">*</span></td>
							<td><c:choose>
									<c:when test="${question.ans2_6_4 == 5}">
										<input type="radio" name="a2_6_4" value="5" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_6_4" value="5">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_6_4 == 4}">
										<input type="radio" name="a2_6_4" value="4" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_6_4" value="4">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_6_4 == 3}">
										<input type="radio" name="a2_6_4" value="3" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_6_4" value="3">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_6_4 == 2}">
										<input type="radio" name="a2_6_4" value="2" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_6_4" value="2">
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${question.ans2_6_4 == 1}">
										<input type="radio" name="a2_6_4" value="1" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" name="a2_6_4" value="1">
									</c:otherwise>
								</c:choose></td>
						</tr>
					</table>
					<div class="appropriate">
						※時間数について、「思わない」「全く思わない」を選択した場合のみお答えください。 <br /> 適切と思う日数を記入してください。<br />
						<input type="number" min="0" max="99" name="a2_6_5" maxlength="2"
							value="${question.ans2_6_5}">日間が適切 <br />
					</div>
					<div class="impression">
						⑥感想を自由にお書きください。 <br />
						<textarea class="questionTextarea" name="a2_6_6" rows="4"
							cols="80" maxlength="300">${question.ans2_6_6}</textarea>
					</div>
				</div>
				<div class="questionTitle1">3. その他についてお聞きします。</div>
				<div class="questionTitle2">(1)今後受けてみたい研修があればお聞かせください。</div>
				<div class="questionContent">
					<textarea class="questionTextarea" name="a3_1" rows="4" cols="80"
						maxlength="300">${question.ans3_1}</textarea>
				</div>
				<div class="questionTitle2">
					(2)新入社員研修全般に関する意見・要望等についてご自由にお書きください。</div>
				<div class="questionContent">
					<textarea class="questionTextarea" name="a3_2" rows="4" cols="80"
						maxlength="300">${question.ans3_2}</textarea>
				</div>
				<p>ご協力ありがとうございました。</p>
				<table class="button2">
					<tr>
						<td>
							<p style="position: relative;">
								<input type="image" src="img/answer.png"
									onclick="goSubmit(this.form, this);" name="Answer_btn" value=""
									alt="回答する">
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