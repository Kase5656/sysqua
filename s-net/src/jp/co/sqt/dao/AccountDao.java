/*
 *AccountDao.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (社員管理業務)
 *クラス一覧：
 * No クラス名 概要
 * 1 AccountDao 各アクションへ誘導するクラスです。
 *履歴：
 * No アカウント Ver 更新者 内容
 * 1 2016/06/01 V1L1.0 SQT）加瀬 初版。
 */

package jp.co.sqt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import jp.co.sqt.entity.Account;
import jp.co.sqt.entity.Corporation;
import jp.co.sqt.entity.Education;

/**
 * <dd>クラス名：アカウント情報Daoクラス
 * <dd>クラス説明：データベースのアカウントマスタに対して処理を行います。
 *
 * @version 1.00 2016/06/01
 * @author SQT）加瀬
 */
public class AccountDao {

	/**
	 * <dd>メソッド名：アカウント情報取得メソッド
	 * <dd>メソッド説明：全てのアカウント情報を取得します。
	 *
	 * @return accountList アカウント情報リスト
	 */
	public static List<Account> search(String educationKananame, int corporationNo, String order) {

		/** アカウント情報リスト */
		List<Account> accountList = new ArrayList<Account>();

		/** 全てのアカウント情報を取得するSQL文 */
		String sql = "SELECT * FROM m_account a  LEFT OUTER JOIN m_corporation b USING (corporation_no) "
				+ "LEFT OUTER JOIN t_education c USING(account_no)";

		if (!(educationKananame.equals(""))) {

			sql += " WHERE (c.education_kananame LIKE '%" + educationKananame + "%')";

		}

		if (!(corporationNo == 0)) {

			sql += " WHERE b.corporation_no = " + corporationNo;

		}

		sql += " ORDER BY " + order + " ASC ;";

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

				if (rs.getInt("no") == 0
						&& (rs.getInt("account_authority") == 0 || rs.getInt("account_authority") == 1)) {

					accountList.add(new Account(rs.getInt("account_no"), rs.getInt("corporation_no"),
							rs.getString("account_id"), rs.getString("account_name"),
							rs.getString("account_password"), rs.getString("account_repassword"),
							rs.getInt("account_authority"), rs.getString("account_remarks"),
							new Corporation(rs.getInt("corporation_no"), rs.getString("corporation_name"),
									rs.getString("corporation_kananame")),
							new Education(rs.getInt("no"), "ーーー", rs.getString("education_kananame"))));

				} else {

					accountList.add(new Account(rs.getInt("account_no"), rs.getInt("corporation_no"),
							rs.getString("account_id"), rs.getString("account_name"),
							rs.getString("account_password"), rs.getString("account_repassword"),
							rs.getInt("account_authority"), rs.getString("account_remarks"),
							new Corporation(rs.getInt("corporation_no"), rs.getString("corporation_name"),
									rs.getString("corporation_kananame")),
							new Education(rs.getInt("no"), rs.getString("education_name"),
									rs.getString("education_kananame"))));

				}

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

		/** 現在の最大アカウントNoを取得するSQL文 */
		String sql = "SELECT MAX(account_no) AS max_account_no FROM m_account;";

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

	/**
	 * <dd>メソッド名：アカウント情報重複チェックメソッド
	 * <dd>メソッド説明：アカウント情報の重複チェックを行う。
	 *
	 * @param accountId
	 *            アカウントID
	 * @param accountNo
	 *            アカウントNo
	 * @return accountCnt アカウント情報カウント
	 */
	public static int findAccountCnt(String accountId, int accountNo) {

		/** アカウント情報カウント */
		int accountCnt = 0;

		/** 全てのアカウント情報を取得するSQL文 */
		String sql = "SELECT COUNT(*) AS account_cnt FROM m_account "
				+ "WHERE account_id = '" + accountId + "' AND account_no <> " + accountNo + ";";

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
	 * <dd>メソッド名：アカウント情報登録メソッド
	 * <dd>メソッド説明：受け取ったアカウント情報を登録します。
	 *
	 * @param account
	 *            アカウント情報
	 * @param accountName
	 *            アカウント名
	 * @param accountPassword
	 *            アカウントパスワード
	 * @param accountRePassword
	 *            アカウント再入力パスワード
	 */
	public static void insert(Account account, String accountName, String accountPassword, String accountRePassword) {

		/** アカウント情報を登録するSQL文 */
		String sql = "INSERT INTO m_account (account_no, corporation_no, account_name, account_id, account_password,"
				+ " account_repassword, account_authority, account_remarks)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		/** データソース */
		DataSource ds = null;

		try {

			ds = DataSourceFactory.getDataSource();

		} catch (DaoException e) {

			e.printStackTrace();

		}

		try (Connection conn = ds.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, account.getAccountNo());

			stmt.setInt(2, account.getCorporation().getCorporationNo());

			stmt.setString(3, accountName);

			stmt.setString(4, account.getAccountId());

			stmt.setString(5, accountPassword);

			stmt.setString(6, accountRePassword);

			stmt.setInt(7, account.getAccountAuthority());

			stmt.setString(8, account.getAccountRemarks());

			stmt.executeUpdate();

			conn.commit();

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

	}

	/**
	 * <dd>メソッド名：アカウント情報変更メソッド
	 * <dd>メソッド説明：受け取ったアカウント情報を変更します。
	 *
	 * @param account
	 *            アカウント情報
	 * @param accountName
	 *            アカウント名
	 * @param accountPassword
	 *            アカウントパスワード
	 * @param accountRePassword
	 *            アカウント再入力パスワード
	 */
	public static void update(Account account, String accountName, String accountPassword, String accountRePassword) {

		/** アカウント情報を変更するSQL文 */
		String sql = "UPDATE m_account SET corporation_no = ?, account_name = ?, account_id = ?,"
				+ " account_password = ?, account_repassword = ?, account_authority = ?, account_remarks = ?"
				+ " WHERE account_no = ?	;";

		/** データソース */
		DataSource ds = null;

		try {

			ds = DataSourceFactory.getDataSource();

		} catch (DaoException e) {

			e.printStackTrace();

		}

		try (Connection conn = ds.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, account.getCorporation().getCorporationNo());

			stmt.setString(2, accountName);

			stmt.setString(3, account.getAccountId());

			stmt.setString(4, accountPassword);

			stmt.setString(5, accountRePassword);

			stmt.setInt(6, account.getAccountAuthority());

			stmt.setString(7, account.getAccountRemarks());

			stmt.setInt(8, account.getAccountNo());

			stmt.executeUpdate();

			conn.commit();

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

	}

	public static void update2(Account account) {

		/** アカウント情報を変更するSQL文 */
		String sql = "UPDATE t_education SET corporation_no = ?"
				+ " WHERE account_no = ?	;";

		/** データソース */
		DataSource ds = null;

		try {

			ds = DataSourceFactory.getDataSource();

		} catch (DaoException e) {

			e.printStackTrace();

		}

		try (Connection conn = ds.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, account.getCorporation().getCorporationNo());

			stmt.setInt(2, account.getAccountNo());

			stmt.executeUpdate();

			conn.commit();

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

	}

	/**
	 * <dd>メソッド名：アカウント情報変更メソッド
	 * <dd>メソッド説明：受け取ったアカウント情報を変更します。
	 *
	 * @param account
	 *            アカウント情報
	 */
	public static void update(Account account) {

		/** アカウント情報を変更するSQL文 */
		String sql = "UPDATE m_account SET account_id = ?, account_password = ?, account_repassword = ?"
				+ " WHERE account_no = ?	;";

		/** データソース */
		DataSource ds = null;

		try {

			ds = DataSourceFactory.getDataSource();

		} catch (DaoException e) {

			e.printStackTrace();

		}

		try (Connection conn = ds.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, account.getAccountId());

			stmt.setString(2, account.getAccountPassword());

			stmt.setString(3, account.getAccountRePassword());

			stmt.setInt(4, account.getAccountNo());

			stmt.executeUpdate();

			conn.commit();

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

	}

	/**
	 * <dd>メソッド名：アカウント情報変更メソッド
	 * <dd>メソッド説明：受け取ったアカウント情報を変更します。
	 *
	 * @param account
	 *            アカウント情報
	 */
	public static void update(Integer accountNo, String password, String repassword) {

		/** アカウント情報を変更するSQL文 */
		String sql = "UPDATE m_account SET account_password = ?, account_repassword = ?"
				+ " WHERE account_no = ?	;";

		/** データソース */
		DataSource ds = null;

		try {

			ds = DataSourceFactory.getDataSource();

		} catch (DaoException e) {

			e.printStackTrace();

		}

		try (Connection conn = ds.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, password);

			stmt.setString(2, repassword);

			stmt.setInt(3, accountNo);

			stmt.executeUpdate();

			conn.commit();

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

	}

	/**
	 * <dd>メソッド名：アカウント情報削除メソッド
	 * <dd>メソッド説明：選択したアカウント情報を論理削除します。
	 *
	 * @param accountList
	 *            アカウント情報
	 */
	public static void deleteAccount(List<Account> accountList) {

		String sql = "DELETE FROM m_account WHERE account_no = " + accountList.get(0).getAccountNo();

		if (accountList.size() > 1) {

			for (int i = 1; i < accountList.size(); i++) {

				sql += " OR account_no = " + accountList.get(i).getAccountNo();

			}

			sql += ";";

		}

		/** データソース */
		DataSource ds = null;

		try {

			ds = DataSourceFactory.getDataSource();

		} catch (DaoException e1) {

			e1.printStackTrace();

		}

		try (Connection conn = ds.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();

			conn.commit();

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

	}

	public static void deleteAttendance(int accountNo) {

		String sql = "DELETE FROM t_attendance WHERE account_no = ? ;";

		/** データソース */
		DataSource ds = null;

		try {

			ds = DataSourceFactory.getDataSource();

		} catch (DaoException e1) {

			e1.printStackTrace();

		}

		try (Connection conn = ds.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, accountNo);

			stmt.executeUpdate();

			conn.commit();

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

	}

	public static void deleteCommnet(int accountNo) {

		String sql = "DELETE FROM t_commnet WHERE account_no = ? ;";

		/** データソース */
		DataSource ds = null;

		try {

			ds = DataSourceFactory.getDataSource();

		} catch (DaoException e1) {

			e1.printStackTrace();

		}

		try (Connection conn = ds.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, accountNo);

			stmt.executeUpdate();

			conn.commit();

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

	}

	public static void deleteEducation(int accountNo) {

		String sql = "DELETE FROM t_education WHERE account_no = ? ;";

		/** データソース */
		DataSource ds = null;

		try {

			ds = DataSourceFactory.getDataSource();

		} catch (DaoException e1) {

			e1.printStackTrace();

		}

		try (Connection conn = ds.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, accountNo);

			stmt.executeUpdate();

			conn.commit();

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

	}

	public static void deleteInterview(int accountNo) {

		String sql = "DELETE FROM t_interview WHERE account_no = ? ;";

		/** データソース */
		DataSource ds = null;

		try {

			ds = DataSourceFactory.getDataSource();

		} catch (DaoException e1) {

			e1.printStackTrace();

		}

		try (Connection conn = ds.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, accountNo);

			stmt.executeUpdate();

			conn.commit();

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

	}

	public static void deleteQuestion(int accountNo) {

		String sql = "DELETE FROM t_question WHERE account_no = ? ;";

		/** データソース */
		DataSource ds = null;

		try {

			ds = DataSourceFactory.getDataSource();

		} catch (DaoException e1) {

			e1.printStackTrace();

		}

		try (Connection conn = ds.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, accountNo);

			stmt.executeUpdate();

			conn.commit();

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

	}

	public static void deleteReport(int accountNo) {

		String sql = "DELETE FROM t_report WHERE account_no = ? ;";

		/** データソース */
		DataSource ds = null;

		try {

			ds = DataSourceFactory.getDataSource();

		} catch (DaoException e1) {

			e1.printStackTrace();

		}

		try (Connection conn = ds.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, accountNo);

			stmt.executeUpdate();

			conn.commit();

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

	}

	public static void deleteTechnologyLevel(int accountNo) {

		String sql = "DELETE FROM t_technologylevel WHERE account_no = ? ;";

		/** データソース */
		DataSource ds = null;

		try {

			ds = DataSourceFactory.getDataSource();

		} catch (DaoException e1) {

			e1.printStackTrace();

		}

		try (Connection conn = ds.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, accountNo);

			stmt.executeUpdate();

			conn.commit();

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

	}

	public static void deleteTest(int accountNo) {

		String sql = "DELETE FROM t_test WHERE account_no = ? ;";

		/** データソース */
		DataSource ds = null;

		try {

			ds = DataSourceFactory.getDataSource();

		} catch (DaoException e1) {

			e1.printStackTrace();

		}

		try (Connection conn = ds.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, accountNo);

			stmt.executeUpdate();

			conn.commit();

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

	}

}
