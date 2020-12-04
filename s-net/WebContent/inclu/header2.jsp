<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div id="head-inner">
	<img id="head-img-logo" src="img/headmain.png">
</div>
<a href="javascript:void(0)" data-featherlight="#inner"><img
	id="head-img-loginidman" src="img/qicone.png" alt="よくあるご質問"> </a>
<div class="featherlight-sample" id="inner">
	<p>
		Q.パスワードを忘れた場合はどうしたら良いですか？<br>
		A.ログインページの「※パスワードをお忘れの方はこちら」からお問合せください。
	</p>
	<p>
		Q.ユーザIDを忘れた場合はどうしたら良いですか？<br>
		A.左記RMSサポートまでメールよりお問い合わせください。rms_support@sqt.co.jp
	</p>
	<br>
	<!-- 	<p>
		Q.ユーザIDを忘れた場合はどうしたら良いですか？<br>
		A.最下部のお問合せフォームよりご連絡ください。その後担当者よりご連絡いたします。
	</p>
 -->
	<%-- 	<h3>お問い合わせ内容の入力</h3>
	<pre style="text-align: center;">下記を入力し、送信ボタンをクリックしてください。<br>折り返し、担当者よりご連絡いたします。
			</pre>
	<form name="defaultLink" action="mail.do" method="post">
		<input type="hidden" name="action" />
		<table class="textfqa">
			<tr>
				<td><font size="2" color="red">※</font><font size="2">入力必須項目</font>
			</tr>
			<tr>
				<th class="paragraphbox">メールアドレス<font color="red">※</font></th>
				<td class="paragraphbox"><input type="text" id="input01"
					name="Address_txt" value="${mailaddress}"
					placeholder="systemtaro@aaa.co.jp" required /></td>
			</tr>
			<tr>
				<th class="paragraphbox">お問い合わせ内容<font color="red">※</font></th>
				<td class="paragraphbox"><textarea name="Content_txt"
						id="input02" maxlength="300" cols="40" rows="5"
						aria-describedby="" aria-required="true"
						placeholder="パスワードを忘れたから教えてほしい" required>${content}</textarea>
			</tr>
		</table>
		<table class="button2">
			<tr>
				<td>
					<p style="position: relative;">
						<input type="image" src="img/send.png" class="send"
							onclick="goSubmit(this.form, this);" name="Sendfqa_btn" value=""
							alt="送信">
					</p>
				</td>
			</tr>
		</table>
	</form>
 --%>
</div>