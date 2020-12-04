/*
 *DutiesDao.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (社員管理業務)
 *クラス一覧：
 * No クラス名 概要
 * 1 DutiesDao 各アクションへ誘導するクラスです。
 *履歴：
 * No 役割 Ver 更新者 内容
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

import jp.co.sqt.entity.Duties;

/**
 * <dd>クラス名：役割情報Daoクラス
 * <dd>クラス説明：データベースの役割テーブルに対して処理を行います。
 *
 * @version 1.00 2016/06/01
 * @author SQT）加瀬
 */
public class DutiesDao {

	/**
	 * <dd>メソッド名：役割情報取得メソッド
	 * <dd>メソッド説明：全ての役割情報を取得します。
	 *
	 * @return dutiesList 役割情報リスト
	 */
	public static List<Duties> findAll() {

		/** 役割情報リスト */
		List<Duties> dutiesList = new ArrayList<Duties>();

		/** 全ての役割情報を取得するSQL文 */
		String sql = "SELECT * FROM m_duties ORDER BY duties_no ASC;";

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

				dutiesList.add(new Duties(rs.getInt("duties_no"), rs.getString("duties_name"),
						rs.getString("duties_remarks")));

			}

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		return dutiesList;

	}

	/**
	 * <dd>メソッド名：役割情報検索メソッド
	 * <dd>メソッド説明：指定した条件で役割情報を取得します。
	 *
	 * @param dutiesName
	 *            役割名
	 * @param order
	 *            並び替えする列名
	 * @return dutiesList 役割情報リスト
	 */
	public static List<Duties> search(String dutiesName, String order) {

		/** 役割情報リスト */
		List<Duties> dutiesList = new ArrayList<Duties>();

		/** 全ての役割情報を取得するSQL文 */
		String sql = "SELECT * FROM m_duties";

		if (!dutiesName.equals("")) {

			sql += " WHERE duties_name = '" + dutiesName + "'";

		}

		sql += " ORDER BY duties_no " + order + " ;";

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

				dutiesList.add(new Duties(rs.getInt("duties_no"), rs.getString("duties_name"),
						rs.getString("duties_remarks")));

			}

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		return dutiesList;

	}

	/**
	 * <dd>メソッド名：最大役割No取得メソッド
	 * <dd>メソッド説明：役割Noの最大値を取得します。
	 *
	 * @return maxNo 最大役割No
	 */
	public static int getLastNo() {

		/** 現在の最大役割Noを取得するSQL文 */
		String sql = "SELECT MAX(duties_no) AS max_duties_no FROM m_duties";

		/** 役割No最大値 */
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

			maxNo = rs.getInt("max_duties_no");

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		return maxNo;

	}

	/**
	 * <dd>メソッド名：役割情報登録メソッド
	 * <dd>メソッド説明：受け取った役割情報を登録します。
	 *
	 * @param duties
	 *            役割情報
	 */
	public static void insert(Duties duties) {

		/** 役割情報を登録するSQL文 */
		String sql = "INSERT INTO m_duties (duties_no, duties_name, duties_remarks)"
				+ " VALUES (?, ?, ?)";

		/** データソース */
		DataSource ds = null;

		try {

			ds = DataSourceFactory.getDataSource();

		} catch (DaoException e) {

			e.printStackTrace();

		}

		try (Connection conn = ds.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, duties.getDutiesNo());

			stmt.setString(2, duties.getDutiesName());

			stmt.setString(3, duties.getDutiesRemarks());

			stmt.executeUpdate();

			conn.commit();

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

	}

	/**
	 * <dd>メソッド名：役割情報変更メソッド
	 * <dd>メソッド説明：受け取った役割情報を変更します。
	 *
	 * @param duties
	 *            役割情報
	 */
	public static void update(Duties duties) {

		/** 役割情報を変更するSQL文 */
		String sql = "UPDATE m_duties SET duties_name = ?, duties_remarks = ?"
				+ " WHERE duties_no = ? ;";

		/** データソース */
		DataSource ds = null;

		try {

			ds = DataSourceFactory.getDataSource();

		} catch (DaoException e) {

			e.printStackTrace();

		}

		try (Connection conn = ds.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, duties.getDutiesName());

			stmt.setString(2, duties.getDutiesRemarks());

			stmt.setInt(3, duties.getDutiesNo());

			stmt.executeUpdate();

			conn.commit();

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

	}

	/**
	 * <dd>メソッド名：役割情報削除メソッド
	 * <dd>メソッド説明：選択した役割情報を論理削除します。
	 *
	 * @param dutiesList
	 *            役割情報
	 */
	public static void delete(List<Duties> dutiesList) {

		String sql = "DELETE from m_duties WHERE duties_no = " + dutiesList.get(0).getDutiesNo();

		if (dutiesList.size() > 1) {

			for (int i = 1; i < dutiesList.size(); i++) {

				sql += " OR duties_no = " + dutiesList.get(i).getDutiesNo();

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

}
