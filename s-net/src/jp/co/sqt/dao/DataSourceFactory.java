/*
 *DaoSourceFactory.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (社員管理業務)
 *クラス一覧：
 * NO クラス名 概要
 * 1 DataSourceFactory 各アクションへ誘導するクラスです。
 *履歴：
 * NO 日付 Ver 更新者 内容
 * 1 2016/06/01 V1L1.0 SQT）加瀬 初版。
 */

package jp.co.sqt.dao;

import java.util.ResourceBundle;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * <dd>クラス名：データベース接続クラス
 * <dd>クラス説明：データベースに接続します。
 *
 * @version 1.00 2016/06/01
 * @author SQT）加瀬
 */
public class DataSourceFactory {

	/** 接続情報 */
	private static InitialContext context;

	/** データソース */
	private static DataSource ds;

	/** デフォルトコンストラクタ */
	private DataSourceFactory() {
	}

	/**
	 * <dd>メソッド名：データベース接続メソッド
	 * <dd>メソッド説明：データーソースを取得し、データベースに接続します。
	 *
	 * @return データソース
	 * @exception DaoException
	 *                context.xmlから指定した情報が取得できなかった場合
	 */
	public static DataSource getDataSource() throws DaoException {

		//ms.propertiesファイルよりseverFlgを取得
		ResourceBundle rb = ResourceBundle.getBundle("rms");

		try {

			if (context == null) {

				context = new InitialContext();

			}
			if (ds == null) {

				if (Integer.parseInt(rb.getString("serverFlg")) == 0) {
					//本番環境
					ds = (DataSource) context.lookup("java:/comp/env/jdbc/mysql/rookies");

				} else {
					//自端末環境
					ds = (DataSource) context.lookup("java:/comp/env/jdbc/mysql/test_rookies");

				}

			}

			if (ds == null) {

			}

		} catch (NamingException e) {

			throw new DaoException(e);

		}

		return ds;

	}

}
