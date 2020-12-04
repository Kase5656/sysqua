/*
 *AttendanceDao.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (社員管理業務)
 *クラス一覧：
 * NO クラス名 概要
 * 1 AttendanceDao 各アクションへ誘導するクラスです。
 *履歴：
 * NO 勤怠 Ver 更新者 内容
 * 1 2016/06/01 V1L1.0 SQT）加瀬 初版。
 */

package jp.co.sqt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import jp.co.sqt.entity.Account;
import jp.co.sqt.entity.Attendance;

/**
 * <dd>クラス名：勤怠情報Daoクラス
 * <dd>クラス説明：データベースの勤怠テーブルに対して処理を行います。
 *
 * @version 1.00 2016/06/01
 * @author SQT）加瀬
 */
public class AttendanceDao {

	/**
	 * <dd>メソッド名：勤怠情報取得メソッド
	 * <dd>メソッド説明：全ての勤怠情報を取得します。
	 *
	 * @return attendanceList 勤怠情報リスト
	 */
	public static List<Attendance> findAll(String month, int accountNo) {

		/** 勤怠情報リスト */
		List<Attendance> attendanceList = new ArrayList<Attendance>();

		/** 全ての勤怠情報を取得するSQL文 */
		String sql = "SELECT * FROM t_attendance WHERE account_no = " + accountNo
				+ " ORDER BY attendance_no ASC;";

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

				attendanceList.add(new Attendance(rs.getInt("attendance_no"), rs.getInt("account_no"),
						rs.getString("attendance_date"), rs.getString("attendance_start"),
						rs.getString("attendance_end"), rs.getString("attendance_startstatus"),
						rs.getString("attendance_endstatus"),
						rs.getString("attendance_startremarks"), rs.getString("attendance_endremarks")));

			}

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		return attendanceList;

	}

	/**
	 * <dd>メソッド名：各受講生のテスト情報取得メソッド
	 * <dd>メソッド説明：各受講生のテスト情報取得を行う。
	 *
	 * @return
	 */
	public static List<Attendance> checkAttendanceDate(int accountNo) {

		/** 各受講生の出退勤情報リスト */
		List<Attendance> attendanceList = new ArrayList<Attendance>();

		/** 全ての出退勤情報を取得するSQL文 */
		String sql = "SELECT * FROM t_attendance"
				+ " WHERE account_no = " + accountNo;

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

				attendanceList.add(new Attendance(rs.getInt("attendance_no"), rs.getInt("account_no"),
						rs.getString("attendance_date"), rs.getString("attendance_start"),
						rs.getString("attendance_end"),
						rs.getString("attendance_startstatus"),
						rs.getString("attendance_endstatus"), rs.getString("attendance_startremarks"),
						rs.getString("attendance_endremarks")));

			}

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		return attendanceList;

	}

	/**
	 * <dd>メソッド名：
	 * <dd>メソッド説明：
	 *
	 * @return
	 */
	public static int findAttendanceDate(Account account, int flg) {

		/** 各受講生の出退勤情報カウント */
		int attendanceCnt = 0;

		Date date = new Date();

		String sdf1 = new SimpleDateFormat("yyyy-MM-dd").format(date);

		String sql = "SELECT COUNT(*) AS attendance_cnt FROM t_attendance "
				+ " WHERE account_no = " + account.getAccountNo()
				+ " AND attendance_date = '" + sdf1 + "'";

		/** を取得するSQL文 */
		if (flg == 0) {

			sql += " AND attendance_start <> '';";

		} else if (flg == 1) {

			sql += " AND attendance_end <> '';";

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

			attendanceCnt = rs.getInt("attendance_cnt");

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		return attendanceCnt;

	}

	/**
	 * <dd>メソッド名：出勤情報登録メソッド
	 * <dd>メソッド説明：受け取った出勤情報を登録します。
	 *
	 * @param attendance
	 *            出勤情報
	 */
	public static void insert(Attendance attendance) {

		/** 勤怠情報を登録するSQL文 */
		String sql = "INSERT INTO t_attendance (attendance_no, account_no, attendance_date,"
				+ " attendance_start, attendance_end, attendance_startstatus, attendance_endstatus, attendance_startremarks, attendance_endremarks)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		/** データソース */
		DataSource ds = null;

		try {

			ds = DataSourceFactory.getDataSource();

		} catch (DaoException e) {

			e.printStackTrace();

		}

		try (Connection conn = ds.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, attendance.getAttendanceNo());

			stmt.setInt(2, attendance.getAccountNo());

			stmt.setString(3, attendance.getAttendanceDate());

			stmt.setString(4, attendance.getAttendanceStart());

			stmt.setString(5, "00:00:00");

			stmt.setString(6, attendance.getAttendanceStartStatus());

			stmt.setString(7, "0");

			stmt.setString(8, attendance.getAttendanceStartRemarks());

			stmt.setString(9, "");

			stmt.executeUpdate();

			conn.commit();

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

	}

	/**
	 * <dd>メソッド名：退勤情報登録メソッド
	 * <dd>メソッド説明：受け取った退勤情報を登録します。
	 *
	 * @param attendance
	 *            退勤情報
	 */
	public static void update(Attendance attendance) {

		/** 勤怠情報を登録するSQL文 */
		String sql = "UPDATE t_attendance SET attendance_end = ?, attendance_endstatus = ?, attendance_endremarks = ? "
				+ " WHERE account_no = ? AND attendance_date = ? ;";

		/** データソース */
		DataSource ds = null;

		try {

			ds = DataSourceFactory.getDataSource();

		} catch (DaoException e) {

			e.printStackTrace();

		}

		try (Connection conn = ds.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, attendance.getAttendanceEnd());

			stmt.setString(2, attendance.getAttendanceEndStatus());

			stmt.setString(3, attendance.getAttendanceEndRemarks());

			stmt.setInt(4, attendance.getAccountNo());

			stmt.setString(5, attendance.getAttendanceDate());

			stmt.executeUpdate();

			conn.commit();

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

	}

	/**
	 * <dd>メソッド名：最大出退勤No取得メソッド
	 * <dd>メソッド説明：出退勤Noの最大値を取得します。
	 *
	 * @return maxNo 最大出退勤No
	 */
	public static int getLastNo() {

		/** 現在の最大出退勤Noを取得するSQL文 */
		String sql = "SELECT MAX(attendance_no) AS max_attendance_no FROM t_attendance;";

		/** 出退勤No最大値 */
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

			maxNo = rs.getInt("max_attendance_no");

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		return maxNo;

	}

	/**
	 * <dd>メソッド名：
	 * <dd>メソッド説明：
	 *
	 * @return
	 */
	//kase
	public static int searchStart(Attendance attendance) {

		/**  */
		String sql = "SELECT COUNT(*) AS attendance_no FROM t_attendance"
				+ " WHERE attendance_date = " + attendance.getAttendanceDate() + ""
				+ " AND account_no = " + attendance.getAccountNo() + ";";

		/**  */
		int attendanceCnt = 0;

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

			attendanceCnt = rs.getInt("attendance_no");

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		return attendanceCnt;

	}

}
