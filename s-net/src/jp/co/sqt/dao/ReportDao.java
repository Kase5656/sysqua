/*
 *ReportDao.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (社員管理業務)
 *クラス一覧：
 * No クラス名 概要
 * 1 ReportDao 各アクションへ誘導するクラスです。
 *履歴：
 * No 日付 Ver 更新者 内容
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

import jp.co.sqt.entity.Report;

/**
 * <dd>クラス名：レポート情報Daoクラス
 * <dd>クラス説明：データベースのレポートテーブルに対して処理を行います。
 *
 * @version 1.00 2016/06/01
 * @author SQT）加瀬
 */
public class ReportDao {

	/**
	 * <dd>メソッド名：レポート情報取得メソッド
	 * <dd>メソッド説明：レポート情報取得を行う。
	 *
	 * @param reportNo
	 *            レポートNo
	 * @param accountNo
	 *            アカウントNo
	 * @param reportDate
	 *            レポート作成日付
	 * @return report
	 *            レポート情報
	 */
	public static Report findReport(int reportNo, int accountNo, String reportDate) {

		/** レポート情報リスト */
		Report report = new Report();

		/** 全てのレポート情報を取得するSQL文 */
		String sql = "SELECT * FROM t_report"
				+ " WHERE report_no = " + reportNo + ""
				+ " AND account_no = " + accountNo + " AND report_date = '" + reportDate + "';";

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

			report.setReportNo(rs.getInt("report_no"));

			report.setAccountNo(rs.getInt("account_no"));

			report.setReportDate(rs.getString("report_date"));

			report.setReportDateTime(rs.getString("report_datetime"));

			report.setReportLastDateTime(rs.getString("report_lastdatetime"));

			report.setContentsItem1(rs.getString("contents_item1"));

			report.setContentsStartTime1(rs.getString("contents_starttime1"));

			report.setContentsEndTime1(rs.getString("contents_endtime1"));

			report.setContentsProgress1(rs.getInt("contents_progress1"));

			report.setContentsUnderStanding1(rs.getString("contents_understanding1"));

			report.setContentsImpression1(rs.getString("contents_impression1"));

			report.setContentsItem2(rs.getString("contents_item2"));

			report.setContentsStartTime2(rs.getString("contents_starttime2"));

			report.setContentsEndTime2(rs.getString("contents_endtime2"));

			report.setContentsProgress2(rs.getInt("contents_progress2"));

			report.setContentsUnderStanding2(rs.getString("contents_understanding2"));

			report.setContentsImpression2(rs.getString("contents_impression2"));

			report.setContentsItem3(rs.getString("contents_item3"));

			report.setContentsStartTime3(rs.getString("contents_starttime3"));

			report.setContentsEndTime3(rs.getString("contents_endtime3"));

			report.setContentsProgress3(rs.getInt("contents_progress3"));

			report.setContentsUnderStanding3(rs.getString("contents_understanding3"));

			report.setContentsImpression3(rs.getString("contents_impression3"));

			report.setContentsItem4(rs.getString("contents_item4"));

			report.setContentsStartTime4(rs.getString("contents_starttime4"));

			report.setContentsEndTime4(rs.getString("contents_endtime4"));

			report.setContentsProgress4(rs.getInt("contents_progress4"));

			report.setContentsUnderStanding4(rs.getString("contents_understanding4"));

			report.setContentsImpression4(rs.getString("contents_impression4"));

			report.setContentsItem5(rs.getString("contents_item5"));

			report.setContentsStartTime5(rs.getString("contents_starttime5"));

			report.setContentsEndTime5(rs.getString("contents_endtime5"));

			report.setContentsProgress5(rs.getInt("contents_progress5"));

			report.setContentsUnderStanding5(rs.getString("contents_understanding5"));

			report.setContentsImpression5(rs.getString("contents_impression5"));

			report.setMonthGoal1(rs.getString("month_goal1"));

			report.setMonthGoal2(rs.getString("month_goal2"));

			report.setTodayGoal1(rs.getString("today_goal1"));

			report.setTodayGoal2(rs.getString("today_goal2"));

			report.setTodayGoalScore(rs.getInt("today_goalscore"));

			report.setTodaySatisfaction(rs.getString("today_satisfaction"));

			report.setTodayDisSatisfaction(rs.getString("today_dissatisfaction"));

			report.setTodayProblem(rs.getString("today_problem"));

			report.setTodayMeasures(rs.getString("today_measures"));

			report.setNextPlan(rs.getString("next_plan"));

			report.setAllImpression(rs.getString("all_impression"));

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		return report;

	}

	/**
	 * <dd>メソッド名：レポート情報取得メソッド
	 * <dd>メソッド説明：レポート情報取得を行う。
	 *
	 * @param reportDate
	 *            レポート作成日付
	 * @param accountNo
	 *            アカウントNo
	 * @param flg
	 *            フラグ
	 * @return reportNoChk
	 *            レポートNoチェック
	 */
	public static int checkReportCnt(String reportDate, int accountNo, int flg) {

		/** レポートNoチェック */
		int reportNoChk = 0;

		String sql = "SELECT count(*) as cnt FROM t_report WHERE account_no = " + accountNo + "";

		/** 全てのレポート情報を取得するSQL文 */
		if (flg != 0) {

			sql += " AND report_date = '" + reportDate + "';";

		} else {

			sql += ";";

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

			reportNoChk = rs.getInt("cnt");

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		return reportNoChk;

	}

	/**
	 * <dd>メソッド名：各受講生のレポート情報取得メソッド
	 * <dd>メソッド説明：各受講生のレポート情報取得を行う。
	 *
	 * @param reportDate
	 *            レポート作成日付
	 * @param accountNo
	 *            アカウントNo
	 * @param flg
	 *            フラグ
	 * @return report
	 *            レポート情報
	 */
	public static Report checkReportDetail(String reportDate, int accountNo, int flg) {

		/** 各受講生のレポート情報 */
		Report report = new Report();

		String sql = "SELECT * FROM t_report WHERE account_no = " + accountNo + "";

		if (flg == 0) {

			/** 全てのレポート情報を取得するSQL文 */
			sql += " AND SUBSTRING(report_date, 6, 2) = '" + reportDate + "';";

		} else {

			/** 全てのレポート情報を取得するSQL文 */
			sql += " AND report_date = '" + reportDate + "';";

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

			report.setReportNo(rs.getInt("report_no"));

			report.setAccountNo(rs.getInt("account_no"));

			report.setReportDate(rs.getString("report_date"));

			report.setReportDateTime(rs.getString("report_datetime").substring(0, 19));

			report.setReportLastDateTime(rs.getString("report_lastdatetime").substring(0, 19));

			report.setContentsItem1(rs.getString("contents_item1"));

			report.setContentsStartTime1(rs.getString("contents_starttime1"));

			report.setContentsEndTime1(rs.getString("contents_endtime1"));

			report.setContentsProgress1(rs.getInt("contents_progress1"));

			report.setContentsUnderStanding1(rs.getString("contents_understanding1"));

			report.setContentsImpression1(rs.getString("contents_impression1"));

			report.setContentsItem2(rs.getString("contents_item2"));

			report.setContentsStartTime2(rs.getString("contents_starttime2"));

			report.setContentsEndTime2(rs.getString("contents_endtime2"));

			report.setContentsProgress2(rs.getInt("contents_progress2"));

			report.setContentsUnderStanding2(rs.getString("contents_understanding2"));

			report.setContentsImpression2(rs.getString("contents_impression2"));

			report.setContentsItem3(rs.getString("contents_item3"));

			report.setContentsStartTime3(rs.getString("contents_starttime3"));

			report.setContentsEndTime3(rs.getString("contents_endtime3"));

			report.setContentsProgress3(rs.getInt("contents_progress3"));

			report.setContentsUnderStanding3(rs.getString("contents_understanding3"));

			report.setContentsImpression3(rs.getString("contents_impression3"));

			report.setContentsItem4(rs.getString("contents_item4"));

			report.setContentsStartTime4(rs.getString("contents_starttime4"));

			report.setContentsEndTime4(rs.getString("contents_endtime4"));

			report.setContentsProgress4(rs.getInt("contents_progress4"));

			report.setContentsUnderStanding4(rs.getString("contents_understanding4"));

			report.setContentsImpression4(rs.getString("contents_impression4"));

			report.setContentsItem5(rs.getString("contents_item5"));

			report.setContentsStartTime5(rs.getString("contents_starttime5"));

			report.setContentsEndTime5(rs.getString("contents_endtime5"));

			report.setContentsProgress5(rs.getInt("contents_progress5"));

			report.setContentsUnderStanding5(rs.getString("contents_understanding5"));

			report.setContentsImpression5(rs.getString("contents_impression5"));

			report.setMonthGoal1(rs.getString("month_goal1"));

			report.setMonthGoal2(rs.getString("month_goal2"));

			report.setTodayGoal1(rs.getString("today_goal1"));

			report.setTodayGoal2(rs.getString("today_goal2"));

			report.setTodayGoalScore(rs.getInt("today_goalscore"));

			report.setTodaySatisfaction(rs.getString("today_satisfaction"));

			report.setTodayDisSatisfaction(rs.getString("today_dissatisfaction"));

			report.setTodayProblem(rs.getString("today_problem"));

			report.setTodayMeasures(rs.getString("today_measures"));

			report.setNextPlan(rs.getString("next_plan"));

			report.setAllImpression(rs.getString("all_impression"));

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		return report;

	}

	/**
	 * <dd>メソッド名：各受講生のレポート情報取得メソッド
	 * <dd>メソッド説明：各受講生のレポート情報取得を行う。
	 *
	 * @param accountNo
	 *            アカウントNo
	 * @return reportList
	 *            レポート情報
	 */
	public static List<Report> checkReportDetail2(int accountNo) {

		/** 各受講生のレポート情報 */
		List<Report> reportList = new ArrayList<Report>();

		/** 全てのレポート情報を取得するSQL文 */
		String sql = "SELECT * FROM t_report WHERE account_no = " + accountNo + ";";

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

				reportList.add(new Report(rs.getInt("report_no"), rs.getInt("account_no"),
						rs.getString("report_date"), rs.getString("report_datetime"),
						rs.getString("report_lastdatetime"),
						rs.getString("contents_item1"), rs.getString("contents_starttime1"),
						rs.getString("contents_endtime1"), rs.getInt("contents_progress1"),
						rs.getString("contents_understanding1"), rs.getString("contents_impression1"),
						rs.getString("contents_item2"), rs.getString("contents_starttime2"),
						rs.getString("contents_endtime2"), rs.getInt("contents_progress2"),
						rs.getString("contents_understanding2"), rs.getString("contents_impression2"),
						rs.getString("contents_item3"), rs.getString("contents_starttime3"),
						rs.getString("contents_endtime3"), rs.getInt("contents_progress3"),
						rs.getString("contents_understanding3"), rs.getString("contents_impression3"),
						rs.getString("contents_item4"), rs.getString("contents_starttime4"),
						rs.getString("contents_endtime4"), rs.getInt("contents_progress4"),
						rs.getString("contents_understanding4"), rs.getString("contents_impression4"),
						rs.getString("contents_item5"), rs.getString("contents_starttime5"),
						rs.getString("contents_endtime5"), rs.getInt("contents_progress5"),
						rs.getString("contents_understanding5"), rs.getString("contents_impression5"),
						rs.getString("month_goal1"), rs.getString("month_goal2"), rs.getString("today_goal1"),
						rs.getString("today_goal2"), rs.getInt("today_goalscore"), rs.getString("today_satisfaction"),
						rs.getString("today_dissatisfaction"), rs.getString("today_problem"),
						rs.getString("today_measures"), rs.getString("next_plan"), rs.getString("all_impression")));

			}

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		return reportList;

	}

	/**
	 * <dd>メソッド名：レポート結果新規登録メソッド
	 * <dd>メソッド説明：受け取ったレポート結果を新規登録します。
	 *
	 * @param report
	 *            レポート結果
	 */
	public static void insert(Report report) {

		/** レポート情報を登録するSQL文 */
		String sql = "INSERT INTO t_report ("
				+ "report_no, account_no, report_date, report_datetime, report_lastdatetime, contents_item1, contents_starttime1,"
				+ " contents_endtime1, contents_progress1, contents_understanding1, contents_impression1,"
				+ " contents_item2, contents_starttime2, contents_endtime2, contents_progress2, contents_understanding2,"
				+ " contents_impression2, contents_item3, contents_starttime3, contents_endtime3, contents_progress3,"
				+ " contents_understanding3, contents_impression3, contents_item4, contents_starttime4, contents_endtime4,"
				+ " contents_progress4, contents_understanding4, contents_impression4, contents_item5, contents_starttime5,"
				+ " contents_endtime5, contents_progress5, contents_understanding5, contents_impression5, month_goal1,"
				+ " month_goal2, today_goal1, today_goal2, today_goalscore, today_satisfaction, today_dissatisfaction,"
				+ " today_problem, today_measures, next_plan, all_impression)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		/** データソース */
		DataSource ds = null;

		try {

			ds = DataSourceFactory.getDataSource();

		} catch (DaoException e) {

			e.printStackTrace();

		}

		try (Connection conn = ds.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, report.getReportNo());

			stmt.setInt(2, report.getAccountNo());

			stmt.setString(3, report.getReportDate());

			stmt.setString(4, report.getReportDateTime());

			stmt.setString(5, "1001-01-01 00:00:00");

			stmt.setString(6, report.getContentsItem1());

			stmt.setString(7, report.getContentsStartTime1());

			stmt.setString(8, report.getContentsEndTime1());

			stmt.setInt(9, report.getContentsProgress1());

			stmt.setString(10, report.getContentsUnderStanding1());

			stmt.setString(11, report.getContentsImpression1());

			stmt.setString(12, report.getContentsItem2());

			stmt.setString(13, report.getContentsStartTime2());

			stmt.setString(14, report.getContentsEndTime2());

			stmt.setInt(15, report.getContentsProgress2());

			stmt.setString(16, report.getContentsUnderStanding2());

			stmt.setString(17, report.getContentsImpression2());

			stmt.setString(18, report.getContentsItem3());

			stmt.setString(19, report.getContentsStartTime3());

			stmt.setString(20, report.getContentsEndTime3());

			stmt.setInt(21, report.getContentsProgress3());

			stmt.setString(22, report.getContentsUnderStanding3());

			stmt.setString(23, report.getContentsImpression3());

			stmt.setString(24, report.getContentsItem4());

			stmt.setString(25, report.getContentsStartTime4());

			stmt.setString(26, report.getContentsEndTime4());

			stmt.setInt(27, report.getContentsProgress4());

			stmt.setString(28, report.getContentsUnderStanding4());

			stmt.setString(29, report.getContentsImpression4());

			stmt.setString(30, report.getContentsItem5());

			stmt.setString(31, report.getContentsStartTime5());

			stmt.setString(32, report.getContentsEndTime5());

			stmt.setInt(33, report.getContentsProgress5());

			stmt.setString(34, report.getContentsUnderStanding5());

			stmt.setString(35, report.getContentsImpression5());

			stmt.setString(36, report.getMonthGoal1());

			stmt.setString(37, report.getMonthGoal2());

			stmt.setString(38, report.getTodayGoal1());

			stmt.setString(39, report.getTodayGoal2());

			stmt.setInt(40, report.getTodayGoalScore());

			stmt.setString(41, report.getTodaySatisfaction());

			stmt.setString(42, report.getTodayDisSatisfaction());

			stmt.setString(43, report.getTodayProblem());

			stmt.setString(44, report.getTodayMeasures());

			stmt.setString(45, report.getNextPlan());

			stmt.setString(46, report.getAllImpression());

			stmt.executeUpdate();

			conn.commit();

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

	}

	/**
	 * <dd>メソッド名：レポート結果追加登録メソッド
	 * <dd>メソッド説明：受け取ったレポート結果を追加登録します。
	 *
	 * @param report
	 *            レポート結果
	 */
	public static void update(Report report) {

		/** レポート情報を登録するSQL文 */
		String sql = "UPDATE t_report SET report_lastdatetime = ?,"
				+ " contents_item1 = ?, contents_starttime1 = ?, contents_endtime1 = ?, contents_progress1 = ?, contents_understanding1 = ?, contents_impression1 = ?,"
				+ " contents_item2 = ?, contents_starttime2 = ?, contents_endtime2 = ?, contents_progress2 = ?, contents_understanding2 = ?, contents_impression2 = ?,"
				+ " contents_item3 = ?, contents_starttime3 = ?, contents_endtime3 = ?, contents_progress3 = ?, contents_understanding3 = ?, contents_impression3 = ?,"
				+ " contents_item4 = ?, contents_starttime4 = ?, contents_endtime4 = ?, contents_progress4 = ?, contents_understanding4 = ?, contents_impression4 = ?,"
				+ " contents_item5 = ?, contents_starttime5 = ?, contents_endtime5 = ?, contents_progress5 = ?, contents_understanding5 = ?, contents_impression5 = ?,"
				+ " month_goal1 = ?, month_goal2 = ?, today_goal1 = ?, today_goal2 = ?, today_goalscore = ?, today_satisfaction = ?, today_dissatisfaction = ?,"
				+ " today_problem = ?, today_measures = ?, next_plan = ?, all_impression = ?"
				+ " WHERE report_no = ? AND account_no = ? AND report_date = ? ";

		/** データソース */
		DataSource ds = null;

		try {

			ds = DataSourceFactory.getDataSource();

		} catch (DaoException e) {

			e.printStackTrace();

		}

		try (Connection conn = ds.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, report.getReportLastDateTime());

			stmt.setString(2, report.getContentsItem1());

			stmt.setString(3, report.getContentsStartTime1());

			stmt.setString(4, report.getContentsEndTime1());

			stmt.setInt(5, report.getContentsProgress1());

			stmt.setString(6, report.getContentsUnderStanding1());

			stmt.setString(7, report.getContentsImpression1());

			stmt.setString(8, report.getContentsItem2());

			stmt.setString(9, report.getContentsStartTime2());

			stmt.setString(10, report.getContentsEndTime2());

			stmt.setInt(11, report.getContentsProgress2());

			stmt.setString(12, report.getContentsUnderStanding2());

			stmt.setString(13, report.getContentsImpression2());

			stmt.setString(14, report.getContentsItem3());

			stmt.setString(15, report.getContentsStartTime3());

			stmt.setString(16, report.getContentsEndTime3());

			stmt.setInt(17, report.getContentsProgress3());

			stmt.setString(18, report.getContentsUnderStanding3());

			stmt.setString(19, report.getContentsImpression3());

			stmt.setString(20, report.getContentsItem4());

			stmt.setString(21, report.getContentsStartTime4());

			stmt.setString(22, report.getContentsEndTime4());

			stmt.setInt(23, report.getContentsProgress4());

			stmt.setString(24, report.getContentsUnderStanding4());

			stmt.setString(25, report.getContentsImpression4());

			stmt.setString(26, report.getContentsItem5());

			stmt.setString(27, report.getContentsStartTime5());

			stmt.setString(28, report.getContentsEndTime5());

			stmt.setInt(29, report.getContentsProgress5());

			stmt.setString(30, report.getContentsUnderStanding5());

			stmt.setString(31, report.getContentsImpression5());

			stmt.setString(32, report.getMonthGoal1());

			stmt.setString(33, report.getMonthGoal2());

			stmt.setString(34, report.getTodayGoal1());

			stmt.setString(35, report.getTodayGoal2());

			stmt.setInt(36, report.getTodayGoalScore());

			stmt.setString(37, report.getTodaySatisfaction());

			stmt.setString(38, report.getTodayDisSatisfaction());

			stmt.setString(39, report.getTodayProblem());

			stmt.setString(40, report.getTodayMeasures());

			stmt.setString(41, report.getNextPlan());

			stmt.setString(42, report.getAllImpression());

			stmt.setInt(43, report.getReportNo());

			stmt.setInt(44, report.getAccountNo());

			stmt.setString(45, report.getReportDate().replaceAll("/", "-"));

			stmt.executeUpdate();

			conn.commit();

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

	}

	/**
	 * <dd>メソッド名：最大レポートNo取得メソッド
	 * <dd>メソッド説明：レポートNoの最大値を取得します。
	 *
	 * @return maxNo 最大レポートNo
	 */
	public static int getLastNo() {

		/** 現在の最大レポートNoを取得するSQL文 */
		String sql = "SELECT MAX(report_no) AS max_report_no FROM t_report";

		/** レポートNo最大値 */
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

			maxNo = rs.getInt("max_report_no");

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		return maxNo;

	}

}
