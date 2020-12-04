/*
 *LoginDao.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (社員管理業務)
 *クラス一覧：
 * NO クラス名 概要
 * 1 LoginDao 各アクションへ誘導するクラスです。
 *履歴：
 * NO 日付 Ver 更新者 内容
 * 1 2016/06/01 V1L1.0 株式アカウントシステムクォート）加瀬 初版。
 */

package jp.co.sqt.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import jp.co.sqt.entity.Account;

/**
 * <dd>クラス名：アカウント情報Daoクラス
 * <dd>クラス説明：データベースのアカウントテーブルに対して処理を行います。
 *
 * @version 1.00 2016/06/01
 * @author SQT）加瀬
 */
public class LoginDao {

	/**
	 * <dd>メソッド名：アカウント情報重複チェックメソッド
	 * <dd>メソッド説明：アカウント情報の重複チェックを行う。
	 *
	 * @param accountId
	 *            アカウントID
	 * @param accountPassword
	 *            アカウントパスワード
	 * @return accountCnt アカウント情報件数
	 */
	public static int findLogin(String accountId, String accountPassword) {

		/** アカウント情報カウント */
		int accountCnt = 0;

		/** 全てのアカウント情報を取得するSQL文 */
		String sql = "SELECT COUNT(*) AS account_cnt FROM m_account"
				+ " WHERE account_id = '" + accountId + "'"
				+ " AND account_password = '" + accountPassword + "';";

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

			accountCnt = rs.getInt("account_cnt");

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		return accountCnt;

	}

	/**
	 * <dd>メソッド名：アカウント情報取得メソッド
	 * <dd>メソッド説明：アカウント情報取得を行う。
	 *
	 * @param accountId
	 *            アカウントID
	 * @return account アカウント情報
	 */
	public static Account findAccount(String accountId, Integer flg) {

		/** アカウント情報リスト */
		Account account = new Account();

		String sql = "";

		/** アカウント情報を取得するSQL文 */
		if (flg == 0) {

			sql = "SELECT *"
					+ "FROM m_account "
					+ "WHERE account_id = '" + accountId + "';";

		} else {

			sql = "SELECT  m_account.*, t_education.enterning_date "
					+ "FROM m_account "
					+ "LEFT JOIN t_education "
					+ "ON m_account.account_no = t_education.account_no "
					+ "WHERE account_id = '" + accountId + "';";

		}

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

			if (flg == 0) {

				account.setAccountNo(rs.getInt("account_no"));

				account.setCorporationNo(rs.getInt("corporation_no"));

				account.setAccountName(rs.getString("account_name"));

				account.setAccountId(rs.getString("account_id"));

				account.setAccountPassword(rs.getString("account_password"));

				account.setAccountRePassword(rs.getString("account_repassword"));

				account.setAccountAuthority(rs.getInt("account_authority"));

				account.setAccountRemarks(rs.getString("account_remarks"));

			} else {

				account.setAccountNo(rs.getInt("account_no"));

				account.setCorporationNo(rs.getInt("corporation_no"));

				account.setAccountName(rs.getString("account_name"));

				account.setAccountId(rs.getString("account_id"));

				account.setAccountPassword(rs.getString("account_password"));

				account.setAccountRePassword(rs.getString("account_repassword"));

				account.setAccountAuthority(rs.getInt("account_authority"));

				account.setAccountRemarks(rs.getString("account_remarks"));

				account.setEnterningDate(rs.getString("enterning_date"));

			}
		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		return account;

	}

	/**
	 * <dd>メソッド名：アカウント情報取得メソッド
	 * <dd>メソッド説明：全てのアカウント情報を取得します。
	 *
	 * @return accountList アカウント情報リスト
	 */
	public static List<Account> findAll() {

		/** アカウント情報リスト */
		List<Account> accountList = new ArrayList<Account>();

		/** 全てのアカウント情報を取得するSQL文 */
		String sql = "SELECT * FROM m_account ORDER BY account_no ASC;";

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

			while (rs.next()) {

				accountList.add(new Account(rs.getInt("account_no"), rs.getInt("corporation_no"),
						rs.getString("account_name"), rs.getString("account_id"),
						rs.getString("account_password"), rs.getString("account_repassword"),
						rs.getInt("account_authority"),
						rs.getString("account_remarks")));

			}

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		return accountList;

	}

	/**
	 * <dd>メソッド名：アカウント情報重複チェックメソッド
	 * <dd>メソッド説明：アカウント情報の重複チェックを行う。
	 *
	 * @param account
	 *            アカウント情報
	 * @param flg
	 *            フラグ
	 * @return accountCnt アカウント情報カウント
	 */
	public static int findLoginCnt(Account account, int flg) {

		/** アカウント情報カウント */
		int accountCnt = 0;

		/** 全てのアカウント情報を取得するSQL文 */
		String sql = "SELECT COUNT(*) AS account_cnt FROM m_account WHERE";

		if (flg == 0) {

			sql += " login_id = '" + account.getAccountId() + "';";

		} else {

			sql += " account_password = '" + account.getAccountPassword() + "'"
					+ " AND account_repassword = '" + account.getAccountRePassword() + "';";

		}

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

			accountCnt = rs.getInt("account_cnt");

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		return accountCnt;

	}

	/**
	 * <dd>メソッド名：アカウント情報検索メソッド
	 * <dd>メソッド説明：指定した条件でアカウント情報を取得します。
	 *
	 * @param order
	 *            並び替え(昇順、降順)
	 * @return accountList アカウント情報リスト
	 */
	public static List<Account> search(String order) {

		/** アカウント情報リスト */
		List<Account> accountList = new ArrayList<Account>();

		/** 全てのアカウント情報を取得するSQL文 */
		String sql = "SELECT * FROM m_account ORDER BY account_no " + order + " ;";

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

			while (rs.next()) {

				accountList.add(new Account(rs.getInt("account_no"), rs.getInt("corporation_no"),
						rs.getString("account_name"), rs.getString("account_id"),
						rs.getString("account_password"), rs.getString("account_repassword"),
						rs.getInt("account_authority"),
						rs.getString("account_remarks")));

			}

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		return accountList;

	}

	/**
	 * <dd>メソッド名：最大アカウントNo取得メソッド
	 * <dd>メソッド説明：アカウントNoの最大値を取得します。
	 *
	 * @return maxNo 最大アカウントNo
	 */
	public static int getLastNo() {

		/** 現在の最大Noを取得するSQL文 */
		String sql = "SELECT MAX(account_no) AS max_account_no FROM m_account";

		/** アカウントNo最大値 */
		int maxNo = 0;

		/** データソース */
		DataSource ds = null;

		try {

			ds = DataSourceFactory.getDataSource();

		} catch (DaoException e) {

			e.printStackTrace();

		}

		try (Connection conn = ds.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			rs.next();

			maxNo = rs.getInt("max_account_no");

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		return maxNo;

	}

}