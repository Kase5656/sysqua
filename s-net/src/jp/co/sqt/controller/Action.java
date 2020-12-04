/*
 *Action.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (s-net) 業務区分名 (社員管理業務)
 *クラス一覧：
 * NO クラス名 概要
 * 1 Action 各アクションへ誘導するクラスです。
 *履歴：
 * NO 日付 Ver 更新者 内容
 * 1 2016/06/01 V1L1.0 SQT）加瀬 初版。
 */

package jp.co.sqt.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <dd>クラス名：Actionインターフェース
 * <dd>クラス説明：各アクションのdoServiceメソッドのインターフェースです。
 *
 * @version 1.00 2016/06/01
 * @author SQT）加瀬
 */
public interface Action {

	/**
	 * <dd>メソッド名：doService抽象メソッド
	 * <dd>メソッド説明：各Actionで実装させる抽象メソッドです。
	 *
	 * @param request
	 *            リクエスト
	 * @param response
	 *            レスポンス
	 * @return 文字列
	 * @exception IOException
	 *                入出力処理でエラーが発生した場合
	 * @exception ServletException
	 *                サーブレット内でエラーが発生した場合
	 */
	public String doService(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException;
}
