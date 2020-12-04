/*
 *MailDao.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (お知らせ管理業務)
 *クラス一覧：
 * No クラス名 概要
 * 1 MailDao 各アクションへ誘導するクラスです。
 *履歴：
 * No 日付 Ver 更新者 内容
 * 1 2016/06/01 V1L1.0 株式会社システムクォート）加瀬 初版。
 */

package jp.co.sqt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

/**
 * <dd>クラス名：
 * <dd>クラス説明：
 *
 * @version 1.00 2016/06/01
 * @author SQT）加瀬
 */
public class MailDao {

	/**
	 * <dd>メソッド名：
	 * <dd>メソッド説明：
	 *
	 * @param id
	 *            アカウントID
	 * @return flg フラグ
	 */
	public static int search(String id) {

		/** フラグ */
		int flg = 0;

		/** お知らせ情報を取得するSQL文 */
		String sql = "SELECT COUNT(*) as account_count FROM m_account WHERE account_id = '" + id + "' ;";

		/** データソース */
		DataSource ds = null;

		try {

			ds = DataSourceFactory.getDataSource();

		} catch (DaoException e1) {

			e1.printStackTrace();

		}

		try (Connection conn = ds.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			rs.next();

			flg = rs.getInt("account_count");

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		return flg;

	}

	/**
	 * <dd>メソッド名：パスワード再設定情報変更メソッド
	 * <dd>メソッド説明：受け取ったパスワード再設定情報を変更します。
	 *
	 * @param accountId
	 *            アカウントID
	 * @param password
	 *            パスワード
	 */
	public static void update(String accountId, String password) {

		/** パスワード再設定情報を変更するSQL文 */
		String sql = "UPDATE m_account SET account_password = ?, account_repassword = ?"
				+ " WHERE account_id = ? ;";

		/** データソース */
		DataSource ds = null;

		try {

			ds = DataSourceFactory.getDataSource();

		} catch (DaoException e) {

			e.printStackTrace();

		}

		try (Connection conn = ds.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, password);

			stmt.setString(2, password);

			stmt.setString(3, accountId);

			stmt.executeUpdate();

			conn.commit();

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

	}

}
