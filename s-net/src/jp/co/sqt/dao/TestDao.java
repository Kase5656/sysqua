/*
 *TestDao.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (テスト管理業務)
 *クラス一覧：
 * No クラス名 概要
 * 1 TestDao 各アクションへ誘導するクラスです。
 *履歴：
 * No 日付 Ver 更新者 内容
 * 1 2016/06/01 V1L1.0 株式会社システムクォート）加瀬 初版。
 */

package jp.co.sqt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import jp.co.sqt.entity.Test;
import jp.co.sqt.entity.Test_Contents;

/**
 * <dd>クラス名：テスト情報Daoクラス
 * <dd>クラス説明：データベースのテストテーブルに対して処理を行います。
 *
 * @version 1.00 2016/06/01
 * @author SQT）加瀬
 */
public class TestDao {

	/**
	 * <dd>メソッド名：テスト情報取得メソッド
	 * <dd>メソッド説明：テスト情報取得を行う。
	 *
	 * @param testDate
	 *            テスト実施日付
	 * @return test_contentsCnt
	 *            テスト情報貨運t
	 */
	public static int findTestCnt(String testDate) {

		/** テスト情報カウント */
		int test_contentsCnt = 0;

		/** 全てのテスト情報を取得するSQL文 */
		String sql = "SELECT count(*) as cnt FROM m_test WHERE test_date = '" + testDate + "';";

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

			test_contentsCnt = rs.getInt("cnt");

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		return test_contentsCnt;

	}

	/**
	 * <dd>メソッド名：テスト情報取得メソッド
	 * <dd>メソッド説明：テスト情報取得を行う。
	 *
	 * @param testDate
	 *            テスト実施日付
	 * @return test_contentsList
	 *            テスト情報リスト
	 */
	public static List<Test_Contents> findTest(String testDate) {

		/** テスト情報リスト */
		List<Test_Contents> test_contentsList = new ArrayList<Test_Contents>();

		/** 全てのテスト情報を取得するSQL文 */
		String sql = "SELECT * FROM m_test WHERE test_date = '" + testDate + "';";

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

			test_contentsList.add(new Test_Contents(rs.getInt("test_no"), rs.getInt("ans_no"),
					rs.getString("test_date"), rs.getString("test_title"), rs.getString("test1"), rs.getString("test2"),
					rs.getString("test3"), rs.getString("test4"), rs.getString("test5")));

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		return test_contentsList;

	}

	/**
	 * <dd>メソッド名：テスト情報取得メソッド
	 * <dd>メソッド説明：テスト情報取得を行う。
	 *
	 * @param testNo
	 *            テストNo
	 * @return test_answerList
	 *            テスト情報リスト
	 */
	public static List<String> findTestAns(int testNo) {

		/** テスト情報リスト */
		List<String> test_answerList = new ArrayList<String>();

		/** 全てのテスト情報を取得するSQL文 */
		String sql = "SELECT ans1, ans2, ans3, ans4, ans5 FROM m_answer"
				+ " WHERE ans_no = '" + testNo + "';";

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

			test_answerList.add(rs.getString("ans1"));

			test_answerList.add(rs.getString("ans2"));

			test_answerList.add(rs.getString("ans3"));

			test_answerList.add(rs.getString("ans4"));

			test_answerList.add(rs.getString("ans5"));

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		return test_answerList;

	}

	/**
	 * <dd>メソッド名：テスト情報取得メソッド
	 * <dd>メソッド説明：テスト情報取得を行う。
	 *
	 * @param chkAns
	 *            テスト結果件数
	 * @return chkcnt
	 *            テスト件数
	 */
	public static int checkTestAns(String[] chkAns) {

		String ans = String.join(",", chkAns);

		/** テスト情報リスト */
		int chkcnt = 0;

		/** 全てのテスト情報を取得するSQL文 */
		String sql = "SELECT count(*) AS chk_cnt FROM m_testanswer"
				+ " WHERE test1_ans = '" + ans + "';";

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

			chkcnt = rs.getInt("chk_cnt");

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		return chkcnt;

	}

	/**
	 * <dd>メソッド名：テスト情報取得メソッド
	 * <dd>メソッド説明：テスト情報取得を行う。
	 *
	 * @param testNo
	 *            テストNo
	 * @param testDate
	 *            テスト実施日付
	 * @param accountNo
	 *            アカウントNo
	 * @param flg
	 *            フラグ
	 * @return chkcnt
	 *            テスト件数
	 */
	public static int checkTestCnt(int testNo, String testDate, int accountNo, int flg) {

		/** テスト情報件数 */
		int chkcnt = 0;

		String sql = "SELECT count(*) AS chk_cnt FROM t_test WHERE account_no = " + accountNo + "";

		if (flg == 0) {

			/** 全てのテスト情報を取得するSQL文 */
			sql += " AND test_no = '" + testNo + "';";

		} else {

			sql += " AND test_date = '" + testDate + "';";

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

			chkcnt = rs.getInt("chk_cnt");

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		return chkcnt;

	}

	/**
	 * <dd>メソッド名：各受講生のテスト情報取得メソッド
	 * <dd>メソッド説明：各受講生のテスト情報取得を行う。
	 *
	 * @param testDate
	 *            テスト実施日付
	 * @param accountNo
	 *            アカウントNo
	 * @param flg
	 *            フラグ
	 * @return testList
	 *            テスト情報
	 */
	public static List<Test> checkTestDetail(String testDate, int accountNo, int flg) {

		/** 各受講生のテスト情報リスト */
		List<Test> testList = new ArrayList<Test>();

		String sql = "SELECT *,date_format(test_date,'%Y-%m-%d %H:%i:%S') testdate FROM t_test WHERE account_no = "
				+ accountNo + "";

		/** 全てのテスト情報を取得するSQL文 */
		if (flg == 0) {

			sql += " AND SUBSTRING(test_date, 1, 7) = '" + testDate + "';";

		} else {

			sql += " AND test_date = '" + testDate + "';";

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

			while (rs.next()) {

				testList.add(new Test(rs.getInt("no"), rs.getInt("account_no"),
						rs.getInt("test_no"), rs.getInt("test_count"), rs.getInt("test_score"),
						rs.getString("test_date"), rs.getString("test_datetime"),
						rs.getString("test_ans1"), rs.getString("test_ans2"), rs.getString("test_ans3"),
						rs.getString("test_ans4"), rs.getString("test_ans5")));

			}

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		return testList;

	}

	/**
	 * <dd>メソッド名：各受講生のテスト情報取得メソッド
	 * <dd>メソッド説明：各受講生のテスト情報取得を行う。
	 *
	 * @param testDate
	 *            テスト実施日付
	 * @param accountNo
	 *            アカウントNo
	 * @param flg
	 *            フラグ
	 * @return testList
	 *            テスト情報
	 */
	public static List<Test> checkTestDetail2(String testYear, String testStartMonth, String testEndMonth,
			int accountNo) {

		/** 各受講生のテスト情報リスト */
		List<Test> testList = new ArrayList<Test>();

		String sql = "SELECT * FROM t_test WHERE account_no = " + accountNo + "";

		/** 全てのテスト情報を取得するSQL文 */
		sql += " AND (SUBSTRING(test_date, 1, 7)  BETWEEN '" + testYear + "-" + testStartMonth + "' AND '" + testYear
				+ "-" + testEndMonth + "');";

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

				testList.add(new Test(rs.getInt("no"), rs.getInt("account_no"),
						rs.getInt("test_no"), rs.getInt("test_count"), rs.getInt("test_score"),
						rs.getString("test_date"), rs.getString("test_datetime"),
						rs.getString("test_ans1"), rs.getString("test_ans2"), rs.getString("test_ans3"),
						rs.getString("test_ans4"), rs.getString("test_ans5")));

			}

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		return testList;

	}

	/**
	 * <dd>メソッド名：テスト結果登録メソッド
	 * <dd>メソッド説明：受け取ったテスト結果を登録します。
	 *
	 * @param test
	 *            テスト結果
	 */
	public static void insert(Test test) {

		/** テスト情報を登録するSQL文 */
		String sql = "INSERT INTO t_test ("
				+ " no, account_no, test_no, test_count, test_score,"
				+ " test_date, test_datetime, test_ans1, test_ans2, test_ans3, test_ans4, test_ans5)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		/** データソース */
		DataSource ds = null;

		try {

			ds = DataSourceFactory.getDataSource();

		} catch (DaoException e) {

			e.printStackTrace();

		}

		try (Connection conn = ds.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, test.getNo());

			stmt.setInt(2, test.getAccountNo());

			stmt.setInt(3, test.getTestNo());

			stmt.setInt(4, test.getTestCount());

			stmt.setInt(5, test.getTestScore());

			stmt.setString(6, test.getTestDate());

			stmt.setString(7, test.getTestDateTime());

			stmt.setString(8, test.getTestAnswer1());

			stmt.setString(9, test.getTestAnswer2());

			stmt.setString(10, test.getTestAnswer3());

			stmt.setString(11, test.getTestAnswer4());

			stmt.setString(12, test.getTestAnswer5());

			stmt.executeUpdate();

			conn.commit();

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

	}

	/**
	 * <dd>メソッド名：最大テストNo取得メソッド
	 * <dd>メソッド説明：テストNoの最大値を取得します。
	 *
	 * @return maxNo 最大テストNo
	 */
	public static int getLastNo() {

		/** 現在の最大テストNoを取得するSQL文 */
		String sql = "SELECT MAX(no) AS max_test_no FROM t_test";

		/** テストNo最大値 */
		int maxNo = 0;

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

			maxNo = rs.getInt("max_test_no");

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		return maxNo;

	}

}
