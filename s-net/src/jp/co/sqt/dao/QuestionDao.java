/*

*TestDao.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (アンケート管理業務)
 *クラス一覧：
 * No クラス名 概要
 * 1 QuestionDao 各アクションへ誘導するクラスです。
 *履歴：
 * No 日付 Ver 更新者 内容
 * 1 2019/09/07 V1L1.0 株式会社システムクォート）長谷川
 */

package jp.co.sqt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import jp.co.sqt.entity.Question;

/**
 * <dd>クラス名：アンケ―ト情報Daoクラス
 * <dd>クラス説明：データベースのアンケートテーブルに対して処理を行います。
 *
 * @version 1.00 2019/09/07
 * @author SQT）長谷川
 */
public class QuestionDao {

	public static int getLastNo() {

		int maxNo = 0;

		// SQL文を作成
		String sql = "SELECT COUNT(*) AS cnt FROM t_question;";

		// DBに接続、SQL実行
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

			maxNo = rs.getInt("cnt");

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		// 結果を返却

		return maxNo;

	}

	/**
	 * <dd>メソッド名：アンケート回答登録メソッド
	 * <dd>メソッド説明：受け取ったアンケートの回答を登録します。
	 *
	 * @param question
	 *            アンケートの回答
	 */
	public static void insert(Question question) {

		/** テスト情報を登録するSQL文 */
		String sql = "INSERT INTO t_question ("
				+ "no, account_no, answer_date, answer1_1_1, answer1_1_2, answer1_2_1, answer1_2_2, answer1_3_1, answer1_3_2,"
				+ " answer2_1_1, answer2_1_2, answer2_1_3, answer2_1_4, answer2_1_5, answer2_1_6,"
				+ " answer2_2_1, answer2_2_2, answer2_2_3, answer2_2_4, answer2_2_5, answer2_2_6,"
				+ " answer2_3_1, answer2_3_2, answer2_3_3, answer2_3_4, answer2_3_5, answer2_3_6,"
				+ " answer2_4_1, answer2_4_2, answer2_4_3, answer2_4_4, answer2_4_5, answer2_4_6,"
				+ " answer2_5_1, answer2_5_2, answer2_5_3, answer2_5_4, answer2_5_5, answer2_5_6,"
				+ " answer2_6_1, answer2_6_2, answer2_6_3, answer2_6_4, answer2_6_5, answer2_6_6,"
				+ " answer3_1, answer3_2)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		/** データソース */
		DataSource ds = null;

		try {

			ds = DataSourceFactory.getDataSource();

		} catch (DaoException e) {

			e.printStackTrace();

		}

		try (Connection conn = ds.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, question.getNo());

			stmt.setInt(2, question.getAccountNo());

			stmt.setString(3, question.getDate());

			stmt.setInt(4, question.getAns1_1_1());

			stmt.setString(5, question.getAns1_1_2());

			stmt.setInt(6, question.getAns1_2_1());

			stmt.setString(7, question.getAns1_2_2());

			stmt.setInt(8, question.getAns1_3_1());

			stmt.setInt(9, question.getAns1_3_2());

			stmt.setInt(10, question.getAns2_1_1());

			stmt.setInt(11, question.getAns2_1_2());

			stmt.setInt(12, question.getAns2_1_3());

			stmt.setInt(13, question.getAns2_1_4());

			stmt.setInt(14, question.getAns2_1_5());

			stmt.setString(15, question.getAns2_1_6());

			stmt.setInt(16, question.getAns2_2_1());

			stmt.setInt(17, question.getAns2_2_2());

			stmt.setInt(18, question.getAns2_2_3());

			stmt.setInt(19, question.getAns2_2_4());

			stmt.setInt(20, question.getAns2_2_5());

			stmt.setString(21, question.getAns2_2_6());

			stmt.setInt(22, question.getAns2_3_1());

			stmt.setInt(23, question.getAns2_3_2());

			stmt.setInt(24, question.getAns2_3_3());

			stmt.setInt(25, question.getAns2_3_4());

			stmt.setInt(26, question.getAns2_3_5());

			stmt.setString(27, question.getAns2_3_6());

			stmt.setInt(28, question.getAns2_4_1());

			stmt.setInt(29, question.getAns2_4_2());

			stmt.setInt(30, question.getAns2_4_3());

			stmt.setInt(31, question.getAns2_4_4());

			stmt.setInt(32, question.getAns2_4_5());

			stmt.setString(33, question.getAns2_4_6());

			stmt.setInt(34, question.getAns2_5_1());

			stmt.setInt(35, question.getAns2_5_2());

			stmt.setInt(36, question.getAns2_5_3());

			stmt.setInt(37, question.getAns2_5_4());

			stmt.setInt(38, question.getAns2_5_5());

			stmt.setString(39, question.getAns2_5_6());

			stmt.setInt(40, question.getAns2_6_1());

			stmt.setInt(41, question.getAns2_6_2());

			stmt.setInt(42, question.getAns2_6_3());

			stmt.setInt(43, question.getAns2_6_4());

			stmt.setInt(44, question.getAns2_6_5());

			stmt.setString(45, question.getAns2_6_6());

			stmt.setString(46, question.getAns3_1());

			stmt.setString(47, question.getAns3_2());

			stmt.executeUpdate();

			conn.commit();

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

	}


}