/*
 *PasswordAction.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (パスワード再設定管理業務)
 *クラス一覧：
 * NO クラス名 概要
 * 1 PasswordAction 各アクションへ誘導するクラスです。
 *履歴：
 * NO 日付 Ver 更新者 内容
 * 1 2016/06/01 V1L1.0 SQT）加瀬 初版。
 */

package jp.co.sqt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <dd>クラス名：パスワード再設定検索情報受け渡しクラス
 * <dd>クラス説明：検索条件入力/検索一覧画面より受け取った検索条件をDaoへ受け渡します。 検索条件を正しい値かチェックします。
 *
 * @version 1.00 2016/06/01
 * @author SQT）加瀬
 */
public class PasswordAction implements Action {

	/**
	 * <dd>メソッド名：パスワード再設定検索情報受け渡しメソッド
	 * <dd>メソッド説明：指定された検索条件を、Daoへ受け渡すメソッドです。 検索条件を正しい値かチェックします。
	 *
	 * @param request
	 *            リクエスト
	 * @param response
	 *            レスポンス
	 * @return servletPath 遷移する画面のサーブレットパス
	 */
	@Override
	public String doService(HttpServletRequest request, HttpServletResponse response) {

		/** セッション */
		HttpSession session = request.getSession(false);

		/** サーブレットパス */
		String servletPath = request.getServletPath();

		if (session == null || session.getAttribute("accountId") == null) {

			servletPath = "sessionLost.jsp";

		} else {

			if ("Passwordregister_btn".equals(request.getParameter("action"))) {

			} else {

				servletPath = "/inf_password/index.jsp";

			}

		}

		return servletPath;

	}

}
