/**
 *
 */

window.onbeforeunload = function() {
	// IE用。ここは空でOKです
};

window.onunload = function() {
	// IE以外用。ここは空でOKです
};

window.addEventListener("pageshow", function(event) {
	if (event.persisted) {
		// ここにキャッシュ有効時の処理を書く
		window.location.reload();
	}
});