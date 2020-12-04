/*
 *DaoException.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (社員管理業務)
 *クラス一覧：
 * NO クラス名 概要
 * 1 DaoException 各アクションへ誘導するクラスです。
 *履歴：
 * NO 日付 Ver 更新者 内容
 * 1 2016/06/01 V1L1.0 SQT）加瀬 初版。
 */

package jp.co.sqt.dao;

/**
 * <dd>クラス名：DaoException処理クラス
 * <dd>クラス説明：DaoExceptionを処理します。
 * @version 1.00 2016/06/01
 * @author SQT）加瀬
 */
public class DaoException extends Exception {

	/**　直列化ＩＤ　*/
	private static final long serialVersionUID = 1L;

	/**
	 * <dd>メソッド名：DaoException処理メソッド
	 * <dd>メソッド説明：例外の発生原因を持つDaoExceptionを構築します。
	 * @param cause 例外の発生原因
	 */
	public DaoException(Throwable cause) {

		super(cause);

	}

	/**
	 * <dd>メソッド名：メッセージ指定DaoException処理メソッド
	 * <dd>メソッド説明：指定された詳細メッセージと例外の発生原因を持つDaoExceptionを構築します。
	 * @param cause 例外の発生原因
	 * @param message 詳細メッセージ
	 */
	public DaoException(Throwable cause, String message) {

		super(message, cause);

	}

}
