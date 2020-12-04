/*
 *InterviewDao.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (社員管理業務)
 *クラス一覧：
 * No クラス名 概要
 * 1 InterviewDao 各アクションへ誘導するクラスです。
 *履歴：
 * No 技術目標 Ver 更新者 内容
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

import jp.co.sqt.entity.Interview;

/**
 * <dd>クラス名：面談情報Daoクラス
 * <dd>クラス説明：データベースの技術目標テーブルに対して処理を行います。
 *
 * @version 1.00 2016/06/01
 * @author SQT）加瀬
 */
public class InterviewDao {

	/** レポート作成日時 */
	static final Date date = new Date();

	static final String sdf1 = new SimpleDateFormat("yyyy-MM-dd").format(date);

	/**
	 * <dd>メソッド名：面談情報取得メソッド
	 * <dd>メソッド説明：全ての面談情報を取得します。
	 *
	 * @return interview 面談情報
	 */
	public static Interview findSearch(int accountNo) {

		/** 面談情報 */
		Interview interview = new Interview();

		/** 全ての面談情報を取得するSQL文 */
		String sql = "SELECT * FROM t_interview"
				+ " WHERE account_no = " + accountNo + ""
				+ " ORDER BY interview_no ASC;";

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

			interview.setInterviewNo(rs.getInt("interview_no"));

			interview.setAccountNo(rs.getInt("account_no"));

			interview.setInterviewDate1(rs.getString("interview_date1"));

			interview.setInterviewEduContents1(rs.getString("interview_educontents1"));

			interview.setInterviewDate2(rs.getString("interview_date2"));

			interview.setInterviewEduContents2(rs.getString("interview_educontents2"));

			interview.setInterviewDate3(rs.getString("interview_date3"));

			interview.setInterviewEduContents3(rs.getString("interview_educontents3"));

		} catch (

		Exception e) {

			System.err.println(e.getMessage());

		}

		return interview;

	}

	/**
	 * <dd>メソッド名：面談情報検索メソッド
	 * <dd>メソッド説明：指定した条件で面談情報を取得します。
	 *
	 * @param corporationNo
	 *            企業No
	 * @param order
	 *            並び替えする列名
	 * @return interviewList 面談情報リスト
	 */
	public static List<Interview> search(String corporationNo, String order) {

		/** 面談情報リスト */
		List<Interview> interviewList = new ArrayList<Interview>();

		/** 全ての面談情報を取得するSQL文 */
		String sql = "SELECT *,"
				+ " (SELECT D1.education_name FROM t_education AS D1 WHERE D1.account_no = b.account_no) AS education_name,"
				+ " (SELECT D1.corporation_no FROM t_education AS D1 WHERE D1.account_no = b.account_no) AS corporation_no"
				+ " FROM t_interview AS b";

		if (!corporationNo.equals("")) {

			sql += " WHERE corporation_no = '" + corporationNo + "'";

		}

		sql += " ORDER BY interview_no " + order + " ;";

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

				interviewList.add(
						new Interview(rs.getInt("interview_no"), rs.getInt("account_no"), rs.getInt("corporation_no"),
								rs.getString("education_name"), rs.getString("account_information"),
								rs.getString("interview_date1"), rs.getString("interview_educontents1"),
								rs.getString("interview_tracontents1"), rs.getString("interview_contents1"),
								rs.getString("interview_date2"), rs.getString("interview_educontents2"),
								rs.getString("interview_tracontents2"), rs.getString("interview_contents2"),
								rs.getString("interview_date3"), rs.getString("interview_educontents3"),
								rs.getString("interview_tracontents3"), rs.getString("interview_contents3")));

			}

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		return interviewList;

	}

	/**
	 * <dd>メソッド名：最大面談No取得メソッド
	 * <dd>メソッド説明：面談Noの最大値を取得します。
	 *
	 * @return maxNo 最大面談No
	 */
	public static int getLastNo() {

		/** 現在の最大面談Noを取得するSQL文 */
		String sql = "SELECT MAX(interview_no) AS max_interview_no FROM t_interview";

		/** 面談No最大値 */
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

			maxNo = rs.getInt("max_interview_no");

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		return maxNo;

	}

	/**
	 * <dd>メソッド名：件数取得メソッド
	 * <dd>メソッド説明：件数を取得します。
	 *
	 * @param accountNo
	 *            アカウントNo
	 * @return cnt 件数
	 */
	public static int getCnt(int accountNo) {

		/** 件数を取得するSQL文 */
		String sql = "SELECT COUNT(interview_no) AS cnt_interview_no"
				+ " FROM t_interview"
				+ " WHERE account_no = " + accountNo + ";";

		/** 件数 */
		int cnt = 0;

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

			cnt = rs.getInt("cnt_interview_no");

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		return cnt;

	}

	/**
	 * <dd>メソッド名：面談情報登録メソッド
	 * <dd>メソッド説明：受け取った面談情報を登録します。
	 *
	 * @param interview
	 *            面談情報
	 */
	public static void insert(Interview interview) {

		/** 面談情報を登録するSQL文 */
		String sql = "INSERT INTO t_interview (interview_no, account_no, corporation_no, account_information, interview_date1,"
				+ " interview_educontents1, interview_tracontents1, interview_contents1, interview_date2, interview_educontents2,"
				+ " interview_tracontents2, interview_contents2, interview_date3, interview_educontents3, interview_tracontents3, interview_contents3)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		/** データソース */
		DataSource ds = null;

		try {

			ds = DataSourceFactory.getDataSource();

		} catch (DaoException e) {

			e.printStackTrace();

		}

		try (Connection conn = ds.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, interview.getInterviewNo());

			stmt.setInt(2, interview.getAccountNo());

			stmt.setInt(3, interview.getCorporationNo());

			stmt.setString(4, interview.getAccountInformation());

			if (!interview.getInterviewDate1().equals("")) {

				stmt.setString(5, interview.getInterviewDate1());

			} else {

				stmt.setString(5, sdf1);

			}
			stmt.setString(6, interview.getInterviewEduContents1());

			stmt.setString(7, interview.getInterviewTraContents1());

			stmt.setString(8, interview.getInterviewContents1());

			if (!interview.getInterviewDate2().equals("")) {

				stmt.setString(9, interview.getInterviewDate2());

			} else {

				stmt.setString(9, sdf1);

			}

			stmt.setString(10, interview.getInterviewEduContents2());

			stmt.setString(11, interview.getInterviewTraContents2());

			stmt.setString(12, interview.getInterviewContents2());

			if (!interview.getInterviewDate3().equals("")) {

				stmt.setString(13, interview.getInterviewDate3());

			} else {

				stmt.setString(13, sdf1);

			}

			stmt.setString(14, interview.getInterviewEduContents3());

			stmt.setString(15, interview.getInterviewTraContents3());

			stmt.setString(16, interview.getInterviewContents3());

			stmt.executeUpdate();

			conn.commit();

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

	}

	/**
	 * <dd>メソッド名：面談情報登録メソッド
	 * <dd>メソッド説明：受け取った面談情報を登録します。
	 *
	 * @param interview
	 *            面談情報
	 */
	public static void update(Interview interview, int flg) {

		/** 面談情報を登録するSQL文 */
		String sql = "UPDATE t_interview SET";

		if (flg == 0) {

			sql += " account_information = ?, interview_date1 = ?,"
					+ " interview_tracontents1 = ?, interview_contents1 = ?, interview_date2 = ?,"
					+ " interview_tracontents2 = ?, interview_contents2 = ?, interview_date3 = ?,"
					+ " interview_tracontents3 = ?, interview_contents3 = ?";

		} else {

			sql += " interview_date1 = ?, interview_educontents1 = ?,"
					+ " interview_date2 = ?, interview_educontents2 = ?,"
					+ " interview_date3 = ?, interview_educontents3 = ?";

		}

		sql += " WHERE interview_no = ? AND account_no = ? ;";

		/** データソース */
		DataSource ds = null;

		try {

			ds = DataSourceFactory.getDataSource();

		} catch (DaoException e) {

			e.printStackTrace();

		}

		try (Connection conn = ds.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			if (flg == 0) {

				stmt.setString(1, interview.getAccountInformation());

				if (!interview.getInterviewDate1().equals("")) {

					stmt.setString(2, interview.getInterviewDate1());

				} else {

					stmt.setString(2, sdf1);

				}

				stmt.setString(3, interview.getInterviewTraContents1());

				stmt.setString(4, interview.getInterviewContents1());

				if (!interview.getInterviewDate2().equals("")) {

					stmt.setString(5, interview.getInterviewDate2());

				} else {

					stmt.setString(5, sdf1);

				}

				stmt.setString(6, interview.getInterviewTraContents2());

				stmt.setString(7, interview.getInterviewContents2());

				if (!interview.getInterviewDate3().equals("")) {

					stmt.setString(8, interview.getInterviewDate3());

				} else {

					stmt.setString(8, sdf1);

				}

				stmt.setString(9, interview.getInterviewTraContents3());

				stmt.setString(10, interview.getInterviewContents3());

				stmt.setInt(11, interview.getInterviewNo());

				stmt.setInt(12, interview.getAccountNo());

			} else {

				if (!interview.getInterviewDate1().equals("")) {

					stmt.setString(1, interview.getInterviewDate1());

				} else {

					stmt.setString(1, sdf1);
				}

				stmt.setString(2, interview.getInterviewEduContents1());

				if (!interview.getInterviewDate1().equals("")) {

					stmt.setString(3, interview.getInterviewDate2());

				} else {

					stmt.setString(3, sdf1);

				}

				stmt.setString(4, interview.getInterviewEduContents2());

				if (!interview.getInterviewDate1().equals("")) {

					stmt.setString(5, interview.getInterviewDate3());

				} else {

					stmt.setString(5, sdf1);

				}

				stmt.setString(6, interview.getInterviewEduContents3());

				stmt.setInt(7, interview.getInterviewNo());

				stmt.setInt(8, interview.getAccountNo());

			}

			stmt.executeUpdate();

			conn.commit();

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

	}

	/**
	 * <dd>メソッド名：面談情報削除メソッド
	 * <dd>メソッド説明：選択した面談情報を論理削除します。
	 *
	 * @param interviewList
	 *            面談情報
	 */
	public static void delete(List<Interview> interviewList) {

		String sql = "DELETE from t_interview WHERE interview_no = " + interviewList.get(0).getInterviewNo();

		if (interviewList.size() > 1) {

			for (int i = 1; i < interviewList.size(); i++) {

				sql += " OR interview_no = " + interviewList.get(i).getInterviewNo();

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
