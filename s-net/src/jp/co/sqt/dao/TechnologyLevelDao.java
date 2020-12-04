/*
 *TechnologyLevelDao.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (社員管理業務)
 *クラス一覧：
 * No クラス名 概要
 * 1 TechnologyLevelDao 各アクションへ誘導するクラスです。
 *履歴：
 * No 技術目標 Ver 更新者 内容
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

import jp.co.sqt.entity.Education;
import jp.co.sqt.entity.TechnologyLevel;

/**
 * <dd>クラス名：技術目標情報Daoクラス
 * <dd>クラス説明：データベースの技術目標テーブルに対して処理を行います。
 *
 * @version 1.00 2016/06/01
 * @author SQT）加瀬
 */
public class TechnologyLevelDao {

	/**
	 * <dd>メソッド名：技術目標情報取得メソッド
	 * <dd>メソッド説明：全ての技術目標情報を取得します。
	 *
	 * @return technologyLevelList 技術目標情報リスト
	 */
	public static List<TechnologyLevel> findAll() {

		/** 技術目標情報リスト */
		List<TechnologyLevel> technologyLevelList = new ArrayList<TechnologyLevel>();

		/** 全ての技術目標情報を取得するSQL文 */
		String sql = "SELECT * FROM t_technologylevel ORDER BY technologylevel_no ASC;";

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

				technologyLevelList.add(new TechnologyLevel(rs.getInt("technologylevel_no"), rs.getInt("account_no"),
						rs.getString("level4"), rs.getString("level5Goal"), rs.getString("level4Action"),
						rs.getString("level5"), rs.getString("level6Goal"), rs.getString("level5GoalReason"),
						rs.getString("level5Action"), rs.getString("level6"), rs.getString("level7Goal"),
						rs.getString("level6GoalReason"), rs.getString("level6Action")));

			}

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		return technologyLevelList;

	}

	/**
	 * <dd>メソッド名：技術目標情報検索メソッド
	 * <dd>メソッド説明：指定した条件で技術目標情報を取得します。
	 *
	 * @param account
	 *            アカウント情報
	 * @param order
	 *            並び替えする列名
	 * @return technologyLevelList 技術目標情報リスト
	 */
	public static TechnologyLevel search(Education education) {

		/** 技術目標情報 */
		TechnologyLevel technologyLevel = new TechnologyLevel();

		/** 全ての技術目標情報を取得するSQL文 */
		String sql = "SELECT * FROM t_technologylevel"
				+ " WHERE account_no = " + education.getAccountNo() + ";";

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

			if (!rs.equals(null)) {

				technologyLevel.setTechnologyLevelNo(rs.getInt("technologylevel_no"));

				technologyLevel.setAccountNo(rs.getInt("account_no"));

				technologyLevel.setLevel4(rs.getString("level4"));

				technologyLevel.setLevel5Goal(rs.getString("level5Goal"));

				technologyLevel.setLevel4Action(rs.getString("level4Action"));

				technologyLevel.setLevel5(rs.getString("level5"));

				technologyLevel.setLevel6Goal(rs.getString("level6Goal"));

				technologyLevel.setLevel5GoalReason(rs.getString("level5GoalReason"));

				technologyLevel.setLevel5Action(rs.getString("level5Action"));

				technologyLevel.setLevel6(rs.getString("level6"));

				technologyLevel.setLevel7Goal(rs.getString("level7Goal"));

				technologyLevel.setLevel6GoalReason(rs.getString("level6GoalReason"));

				technologyLevel.setLevel6Action(rs.getString("level6Action"));

			}

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		return technologyLevel;

	}

	/**
	 * <dd>メソッド名：最大技術目標No取得メソッド
	 * <dd>メソッド説明：技術目標Noの最大値を取得します。
	 *
	 * @return maxNo 最大技術目標No
	 */
	public static int getLastNo() {

		/** 現在の最大技術目標Noを取得するSQL文 */
		String sql = "SELECT MAX(technologylevel_no) AS max_technologylevel_no FROM t_technologylevel";

		/** 技術目標No最大値 */
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

			maxNo = rs.getInt("max_technologylevel_no");

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		return maxNo;

	}

	/**
	 * <dd>メソッド名：技術目標情報登録メソッド
	 * <dd>メソッド説明：受け取った技術目標情報を登録します。
	 *
	 * @param technologylevel
	 *            技術目標情報
	 */
	public static void insert(TechnologyLevel technologylevel) {

		/** 技術目標情報を登録するSQL文 */
		String sql = "INSERT INTO t_technologylevel (technologylevel_no, account_no, level4,"
				+ " level5Goal, level4Action, level5, level6Goal, level5GoalReason, level5Action,"
				+ " level6, level7Goal, level6GoalReason, level6Action)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		/** データソース */
		DataSource ds = null;

		try {

			ds = DataSourceFactory.getDataSource();

		} catch (DaoException e) {

			e.printStackTrace();

		}

		try (Connection conn = ds.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, technologylevel.getTechnologyLevelNo());

			stmt.setInt(2, technologylevel.getAccountNo());

			stmt.setString(3, technologylevel.getLevel4());

			stmt.setString(4, technologylevel.getLevel5Goal());

			stmt.setString(5, technologylevel.getLevel4Action());

			stmt.setString(6, "");

			stmt.setString(7, "");

			stmt.setString(8, "");

			stmt.setString(9, "");

			stmt.setString(10, "");

			stmt.setString(11, "");

			stmt.setString(12, "");

			stmt.setString(13, "");

			stmt.executeUpdate();

			conn.commit();

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

	}

	/**
	 * <dd>メソッド名：技術目標情報登録メソッド
	 * <dd>メソッド説明：受け取った技術目標情報を登録します。
	 *
	 * @param technologyLevel
	 *            技術目標情報
	 */
	public static void update(TechnologyLevel technologyLevel, int flg) {

		/** 技術目標情報を登録するSQL文 */
		String sql = "UPDATE t_technologylevel SET";

		if (flg == 0) {

			sql += " level4 = ?, level5Goal = ?, level4Action = ?";

		} else if (flg == 1) {

			sql += " level5 = ?, level6Goal = ?, level5GoalReason = ?, level5Action = ?";

		} else {

			sql += " level6 = ?, level7Goal = ?, level6GoalReason = ?, level6Action = ?";

		}

		sql += " WHERE technologylevel_no = ? AND account_no = ? ;";

		/** データソース */
		DataSource ds = null;

		try {

			ds = DataSourceFactory.getDataSource();

		} catch (DaoException e) {

			e.printStackTrace();

		}

		try (Connection conn = ds.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			if (flg == 0) {

				stmt.setString(1, technologyLevel.getLevel4());

				stmt.setString(2, technologyLevel.getLevel5Goal());

				stmt.setString(3, technologyLevel.getLevel4Action());

				stmt.setInt(4, technologyLevel.getTechnologyLevelNo());

				stmt.setInt(5, technologyLevel.getAccountNo());

			} else {

				if (flg == 1) {

					stmt.setString(1, technologyLevel.getLevel5());

					stmt.setString(2, technologyLevel.getLevel6Goal());

					stmt.setString(3, technologyLevel.getLevel5GoalReason());

					stmt.setString(4, technologyLevel.getLevel5Action());

				} else {

					stmt.setString(1, technologyLevel.getLevel6());

					stmt.setString(2, technologyLevel.getLevel7Goal());

					stmt.setString(3, technologyLevel.getLevel6GoalReason());

					stmt.setString(4, technologyLevel.getLevel6Action());
				}

				stmt.setInt(5, technologyLevel.getTechnologyLevelNo());

				stmt.setInt(6, technologyLevel.getAccountNo());

			}

			stmt.executeUpdate();

			conn.commit();

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

	}

}
