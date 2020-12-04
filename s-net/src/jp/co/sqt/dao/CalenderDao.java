/*
 *CalenderDao.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (社員管理業務)
 *クラス一覧：
 * NO クラス名 概要
 * 1 CalenderDao 各アクションへ誘導するクラスです。
 *履歴：
 * NO 日付 Ver 更新者 内容
 * 1 2016/06/01 V1L1.0 SQT）加瀬 初版。
 */

package jp.co.sqt.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import jp.co.sqt.entity.CalendarUnq;

/**
 * <dd>クラス名：日付情報Daoクラス
 * <dd>クラス説明：データベースの日付テーブルに対して処理を行います。
 *
 * @version 1.00 2016/06/01
 * @author SQT）加瀬
 */
public class CalenderDao {

	/**
	 * <dd>メソッド名：日付情報取得メソッド
	 * <dd>メソッド説明：全ての日付情報を取得します。
	 *
	 * @return calenderList 日付情報リスト
	 */
	public static List<CalendarUnq> findAll() {

		/** 日付情報リスト */
		List<CalendarUnq> calenderList = new ArrayList<CalendarUnq>();

		/** 全ての日付情報を取得するSQL文 */
		String sql = "SELECT * FROM m_calender ORDER BY calender_no ASC;";

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

				calenderList.add(new CalendarUnq(rs.getInt("calender_no"), rs.getInt("calender_chk"),
						rs.getString("calender_ondate"), rs.getString("calender_week")));

			}

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		return calenderList;

	}

	/**
	 * <dd>メソッド名：日付情報検索メソッド
	 * <dd>メソッド説明：指定した条件で日付情報を取得します。
	 *
	 * @param calenderOncalender
	 *            日付名
	 * @param order
	 *            並び替えする列名
	 * @return calenderList 日付情報リスト
	 */
	public static List<CalendarUnq> search(String testYear, String testStartMonth, String testEndMonth, String order) {

		/** 日付情報リスト */
		List<CalendarUnq> calenderList = new ArrayList<CalendarUnq>();

		/** 全ての日付情報を取得するSQL文 */
		String sql = "SELECT * FROM m_calender "
				+ "WHERE (SUBSTRING(calender_ondate, 1, 7) BETWEEN '" + testYear + "-" + testStartMonth + "' AND '"
				+ testYear + "-" + testEndMonth + "') "
				+ "AND calender_chk = 0 "
				+ "ORDER BY calender_no " + order + " ;";

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

				calenderList.add(new CalendarUnq(rs.getInt("calender_no"), rs.getInt("calender_chk"),
						rs.getString("calender_ondate").replace("-", "/"),
						rs.getString("calender_week").replace("曜日", "")));

			}

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		return calenderList;

	}

}
