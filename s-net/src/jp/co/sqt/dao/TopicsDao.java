/*
 *TopicsDao.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (お知らせ管理業務)
 *クラス一覧：
 * No クラス名 概要
 * 1 TopicsDao 各アクションへ誘導するクラスです。
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

import jp.co.sqt.entity.Topics;

/**
 * <dd>クラス名：
 * <dd>クラス説明：
 *
 * @version 1.00 2016/06/01
 * @author SQT）加瀬
 */
public class TopicsDao {

	/**
	 * <dd>メソッド名：
	 * <dd>メソッド説明：
	 *
	 * @param month
	 *            お知らせ月
	 * @param order
	 *            並び替えする列名
	 * @return topicsList お知らせ情報リスト
	 */
	public static List<Topics> search(String month, String order) {

		/** お知らせ情報リスト */
		List<Topics> topicsList = new ArrayList<Topics>();

		/** お知らせ情報を取得するSQL文 */
		String sql = "SELECT *,date_format(topics_date,'%Y-%m-%d %H:%i:%S') topicsdate FROM t_topics"
				+ " ORDER BY " + order + " ;";

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

				topicsList.add(
						new Topics(rs.getInt("topics_no"), rs.getString("topicsdate"), rs.getString("topics_title"),
								rs.getString("topics_contents"), rs.getInt("topics_flg"), rs.getInt("delete_flg")));

			}

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		return topicsList;

	}

	/**
	 * <dd>メソッド名：
	 * <dd>メソッド説明：
	 *
	 * @param month
	 *            お知らせ月
	 * @param order
	 *            並び替えする列名
	 * @return topicsList お知らせ情報リスト
	 */
	public static List<Topics> findTopics(String month, String order, int flg) {

		/** お知らせ情報リスト */
		List<Topics> topicsList = new ArrayList<Topics>();

		/** お知らせ情報を取得するSQL文 */
		String sql = "SELECT *,date_format(topics_date,'%Y-%m-%d %H:%i:%S') topicsdate FROM t_topics";

		if (!(month.equals(""))) {

			sql += " WHERE topics_date LIKE '____-" + month + "-__'"
					+ " AND topics_flg = " + flg + " AND delete_flg = 0";

		} else {

			sql += " WHERE topics_flg = " + flg + " AND delete_flg = 0";

		}

		sql += " ORDER BY " + order + ";";

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

				topicsList.add(
						new Topics(rs.getInt("topics_no"), rs.getString("topicsdate"), rs.getString("topics_title"),
								rs.getString("topics_contents"), rs.getInt("topics_flg"), rs.getInt("delete_flg")));

			}

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		return topicsList;

	}

	/**
	 * <dd>メソッド名：最大お知らせNo取得メソッド
	 * <dd>メソッド説明：お知らせNoの最大値を取得します。
	 *
	 * @return maxNo 最大お知らせNo
	 */
	public static int getLastNo() {

		/** 現在の最大お知らせNoを取得するSQL文 */
		String sql = "SELECT MAX(topics_no) AS max_topics_no FROM t_topics";

		/** お知らせNo最大値 */
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

			maxNo = rs.getInt("max_topics_no");

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		return maxNo;

	}

	/**
	 * <dd>メソッド名：お知らせ情報登録メソッド
	 * <dd>メソッド説明：受け取ったお知らせ情報を登録します。
	 *
	 * @param topics
	 *            お知らせ情報
	 */
	public static void insert(Topics topics) {

		/** お知らせ情報を登録するSQL文 */
		String sql = "INSERT INTO t_topics ("
				+ " topics_no, topics_date, topics_title, topics_contents, topics_flg, delete_flg)"
				+ " VALUES (?, ?, ?, ?, ?, ?)";

		/** データソース */
		DataSource ds = null;

		try {

			ds = DataSourceFactory.getDataSource();

		} catch (DaoException e) {

			e.printStackTrace();

		}

		try (Connection conn = ds.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, topics.getTopicsNo());

			stmt.setString(2, topics.getTopicsDate());

			stmt.setString(3, topics.getTopicsTitle());

			stmt.setString(4, topics.getTopicsContents());

			stmt.setInt(5, topics.getTopicsFlg());

			stmt.setInt(6, topics.getDeleteFlg());

			stmt.executeUpdate();

			conn.commit();

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

	}

	/**
	 * <dd>メソッド名：お知らせ情報変更メソッド
	 * <dd>メソッド説明：受け取ったお知らせ情報を変更します。
	 *
	 * @param topics
	 *            お知らせ情報
	 */
	public static void update(Topics topics) {

		/** お知らせ情報を変更するSQL文 */
		String sql = "UPDATE t_topics SET topics_title = ?, topics_contents = ?, topics_flg = ?, delete_flg = ?"
				+ " WHERE topics_no = ? ;";

		/** データソース */
		DataSource ds = null;

		try {

			ds = DataSourceFactory.getDataSource();

		} catch (DaoException e) {

			e.printStackTrace();

		}

		try (Connection conn = ds.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, topics.getTopicsTitle());

			stmt.setString(2, topics.getTopicsContents());

			stmt.setInt(3, topics.getTopicsFlg());

			stmt.setInt(4, topics.getDeleteFlg());

			stmt.setInt(5, topics.getTopicsNo());

			stmt.executeUpdate();

			conn.commit();

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

	}

	/**
	 * <dd>メソッド名：お知らせ情報削除メソッド
	 * <dd>メソッド説明：選択したお知らせ情報を論理削除します。
	 *
	 * @param topics
	 *            お知らせ情報
	 */
	public static void delete(List<Topics> topicsList) {

		String sql = "DELETE from t_topics WHERE topics_no = " + topicsList.get(0).getTopicsNo();

		if (topicsList.size() > 1) {

			for (int i = 1; i < topicsList.size(); i++) {

				sql += " OR topics_no = " + topicsList.get(i).getTopicsNo();

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
