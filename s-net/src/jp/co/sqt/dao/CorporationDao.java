/*
 *CorporationDao.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (社員管理業務)
 *クラス一覧：
 * NO クラス名 概要
 * 1 CorporationDao 各アクションへ誘導するクラスです。
 *履歴：
 * NO 日付 Ver 更新者 内容
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

import jp.co.sqt.entity.Corporation;

/**
 * <dd>クラス名：企業情報Daoクラス
 * <dd>クラス説明：データベースの企業テーブルに対して処理を行います。
 *
 * @version 1.00 2016/06/01
 * @author SQT）加瀬
 */
public class CorporationDao {

	/**
	 * <dd>メソッド名：企業情報取得メソッド
	 * <dd>メソッド説明：全ての企業情報を取得します。
	 *
	 * @return corporationList 企業情報リスト
	 */
	public static List<Corporation> findAll() {

		/** 企業情報リスト */
		List<Corporation> corporationList = new ArrayList<Corporation>();

		/** 全ての企業情報を取得するSQL文 */
		String sql = "SELECT * FROM m_corporation ORDER BY corporation_no ASC;";

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

				corporationList.add(new Corporation(rs.getInt("corporation_no"),
						rs.getString("corporation_name"), rs.getString("corporation_kananame"),
						rs.getString("corporation_postalcode"), rs.getString("corporation_address"),
						rs.getString("corporation_tel"), rs.getString("corporation_fax"),
						rs.getString("corporation_representative"), rs.getString("corporation_representativename")));

			}

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		return corporationList;

	}

	/**
	 * <dd>メソッド名：企業情報検索メソッド
	 * <dd>メソッド説明：指定した条件で企業情報を取得します。
	 *
	 * @param corporationName
	 *            企業名
	 * @param order
	 *            並び替えする列名
	 * @return corporationList 企業情報リスト
	 */
	public static List<Corporation> search(String corporationName, String order) {

		/** 企業情報リスト */
		List<Corporation> corporationList = new ArrayList<Corporation>();

		/** 全ての企業情報を取得するSQL文 */
		String sql = "SELECT * FROM m_corporation ";

		if (!(corporationName.equals(""))) {

			sql += "WHERE ";

			if (!(corporationName.equals(""))) {

				sql += "corporation_name LIKE '%" + corporationName + "%'";

			}

		}
		sql += "ORDER BY corporation_name " + order + " ;";

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

				corporationList.add(new Corporation(rs.getInt("corporation_no"),
						rs.getString("corporation_name"), rs.getString("corporation_kananame"),
						rs.getString("corporation_postalcode"), rs.getString("corporation_address"),
						rs.getString("corporation_tel"), rs.getString("corporation_fax"),
						rs.getString("corporation_representative"), rs.getString("corporation_representativename")));

			}

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		return corporationList;

	}

	/**
	 * <dd>メソッド名：最大企業No取得メソッド
	 * <dd>メソッド説明：企業Noの最大値を取得します。
	 *
	 * @return maxNo 最大企業No
	 */
	public static int getLastNo() {

		/** 現在の最大企業Noを取得するSQL文 */
		String sql = "SELECT MAX(corporation_no) AS max_corporation_no FROM m_corporation";

		/** 企業No最大値 */
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

			maxNo = rs.getInt("max_corporation_no");

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		return maxNo;

	}

	/**
	 * <dd>メソッド名：企業情報登録メソッド
	 * <dd>メソッド説明：受け取った企業情報を登録します。
	 *
	 * @param corporation
	 *            企業情報
	 */
	public static void insert(Corporation corporation) {

		/** 企業情報を登録するSQL文 */
		String sql = "INSERT INTO m_corporation ("
				+ "corporation_no, corporation_name, corporationkananame,"
				+ " corporation_postalcode, corporation_address, corporation_tel,"
				+ " corporation_fax, corporation_representative,"
				+ " corporation_representativename)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		/** データソース */
		DataSource ds = null;

		try {

			ds = DataSourceFactory.getDataSource();

		} catch (DaoException e) {

			e.printStackTrace();

		}

		try (Connection conn = ds.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, corporation.getCorporationNo());

			stmt.setString(2, corporation.getCorporationName());

			stmt.setString(3, corporation.getCorporationKanaName());

			stmt.setString(4, corporation.getCorporationPostalcode());

			stmt.setString(5, corporation.getCorporationAddress());

			stmt.setString(6, corporation.getCorporationTel());

			stmt.setString(7, corporation.getCorporationFax());

			stmt.setString(8, corporation.getCorporationRepresentative());

			stmt.setString(9, corporation.getCorporationRepresentativeName());

			stmt.executeUpdate();

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

	}

	/**
	 * <dd>メソッド名：企業情報変更メソッド
	 * <dd>メソッド説明：受け取った企業情報を変更します。
	 *
	 * @param corporation
	 *            企業情報
	 */
	public static void update(Corporation corporation) {

		/** お知らせ情報を変更するSQL文 */
		String sql = "UPDATE m_corporation SET corporation_name = ?, corporation_kananame = ?, corporation_postalcode = ?, "
				+ " corporation_address = ?, corporation_tel = ?, corporation_fax = ?, corporation_representative = ?, corporation_representativename = ?"
				+ " WHERE corporation_no = ? ;";

		/** データソース */
		DataSource ds = null;

		try {

			ds = DataSourceFactory.getDataSource();

		} catch (DaoException e) {

			e.printStackTrace();

		}

		try (Connection conn = ds.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, corporation.getCorporationName());

			stmt.setString(2, corporation.getCorporationKanaName());

			stmt.setString(3, corporation.getCorporationPostalcode());

			stmt.setString(4, corporation.getCorporationAddress());

			stmt.setString(5, corporation.getCorporationTel());

			stmt.setString(6, corporation.getCorporationFax());

			stmt.setString(7, corporation.getCorporationRepresentative());

			stmt.setString(8, corporation.getCorporationRepresentativeName());

			stmt.setInt(9, corporation.getCorporationNo());

			stmt.executeUpdate();

			conn.commit();

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

	}

	/**
	 * <dd>メソッド名：企業情報削除メソッド
	 * <dd>メソッド説明：選択した企業情報を論理削除します。
	 *
	 * @param corporationList
	 *            企業情報
	 */
	public static void delete(List<Corporation> corporationList) {

		String sql = "DELETE from m_corporation WHERE corporation_no = " + corporationList.get(0).getCorporationNo();

		if (corporationList.size() > 1) {

			for (int i = 1; i < corporationList.size(); i++) {

				sql += " OR corporation_no = " + corporationList.get(i).getCorporationNo();

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
