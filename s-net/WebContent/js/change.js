/**
 *
 */

/*
 * function goSubmitMail(formObj, btnObj, beforePageObj) { formObj.action.value =
 * btnObj.name; formObj.mail.value = beforePageObj; formObj.submit(); };
 */
function goTest(formObj, btnObj) {

	var address = document.getElementById("Address_txt").value;

	alert(address);

	/*
	 * // エラーチェック if (address == "") {
	 *
	 * return false; } else {
	 *
	 * return true;
	 *
	 * formObj.action.value = btnObj.name;
	 *
	 * formObj.submit(); }
	 */
};

function goSubmit(formObj, btnObj) {
	formObj.action.value = btnObj.name;
	formObj.submit();
}

function confirmFunction1() {
	ret = confirm("ログアウトします。よろしいですか？");
	if (ret == true) {
		window.sessionStorage.clear();

		location.href = "https://rms.sqt.co.jp/s-net/";
		//
		// location.replace("http://localhost:8080/s-net/index.jsp");
		//
		jQuery.cookie('sessionFooCookie', null);
	}
}

function confirmFunction2(formObj, btnObj) {
	ret = confirm("コメントを削除します。よろしいですか？");
	if (ret == true) {
		formObj.action.value = btnObj.name;
		formObj.submit();
	}
}

function goSubmit2(formObj, btnObj) {
	location.replace('index.jsp');
	/*
	 * formObj.action.value = btnObj.name; formObj.submit();
	 */
};
