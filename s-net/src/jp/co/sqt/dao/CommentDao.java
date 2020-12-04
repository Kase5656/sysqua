/*
 *CommentDao.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (社員管理業務)
 *クラス一覧：
 * NO クラス名 概要
 * 1 CommentDao 各アクションへ誘導するクラスです。
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

import jp.co.sqt.entity.Comment;

/**
 * <dd>クラス名：コメント情報Daoクラス
 * <dd>クラス説明：データベースのコメントテーブルに対して処理を行います。
 *
 * @version 1.00 2016/06/01
 * @author SQT）加瀬
 */
public class CommentDao {

	/**
	 * <dd>メソッド名：レポートのコメント情報取得メソッド
	 * <dd>メソッド説明：レポートのコメント情報取得を行う。
	 *
	 * @param reportNo
	 *            レポートNo
	 * @return commentList コメント情報リスト
	 */
	public static List<Comment> checkCommentDetail(int reportNo) {

		/** レポートのコメント情報リスト */
		List<Comment> commentList = new ArrayList<Comment>();

		String sql = "SELECT t_comment.comment_no, t_comment.report_no, t_comment.to_account_no, t_comment.from_account_no,"
				+ " m_account.account_name,t_comment.comment_date, t_comment.comment"
				+ " FROM t_comment LEFT JOIN m_account ON"
				+ " t_comment.from_account_no = m_account.account_no"
				+ " WHERE t_comment.report_no = " + reportNo + " ORDER BY t_comment.comment_no";

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

				commentList.add(new Comment(rs.getInt("comment_no"), rs.getInt("report_no"),
						rs.getInt("to_account_no"), rs.getInt("from_account_no"),
						rs.getString("account_name"), rs.getString("comment_date").substring(0, 19),
						rs.getString("comment")));

			}

			stmt.close();

			conn.close();

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		return commentList;

	}

	/**
	 * <dd>メソッド名：レポートのコメント情報取得メソッド
	 * <dd>メソッド説明：レポートのコメント情報取得を行う。
	 *
	 * @param reportNo
	 *            レポートNo
	 * @return commentList コメント情報リスト
	 */
	public static List<Comment> checkComment(int accountNo) {

		/** レポートのコメント情報リスト */
		List<Comment> commentList = new ArrayList<Comment>();

		String sql = "SELECT t_comment.comment_no, t_report.report_date, t_comment.report_no, t_comment.to_account_no, t_comment.from_account_no,"
				+ " m_account.account_name,t_comment.comment_date, t_comment.comment FROM t_comment "
				+ " LEFT JOIN m_account ON"
				+ " t_comment.from_account_no = m_account.account_no"
				+ " LEFT JOIN t_report ON"
				+ " t_comment.report_no = t_report.report_no"
				+ " WHERE to_account_no = " + accountNo + " ORDER BY comment_date DESC";

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

				commentList
						.add(new Comment(rs.getInt("comment_no"), rs.getInt("report_no"),
								rs.getString("report_date").substring(6, 10).replace("-", "/"),
								rs.getInt("to_account_no"), rs.getInt("from_account_no"), rs.getString("account_name"),
								rs.getString("comment_date").substring(6, 10).replace("-", "/"),
								rs.getString("comment")));

			}

			stmt.close();

			conn.close();

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		return commentList;

	}

	//テスト
	public static List<Comment> checkComment2(int accountNo) {

		/** レポートのコメント情報リスト */
		List<Comment> commentList = new ArrayList<Comment>();

		String sql = "SELECT t_comment.report_no, date_format(t_report.report_date, '%Y/%m/%d') as report_date,"
				+ " COUNT(*) as comment_cnt, MAX(t_comment.comment_date) as comment_date"
				+ " FROM t_comment"
				+ " LEFT JOIN t_report ON"
				+ " t_comment.report_no = t_report.report_no"
				+ " WHERE to_account_no = " + accountNo + " GROUP BY  report_date ORDER BY comment_date ASC";

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

				commentList
						.add(new Comment(rs.getInt("report_no"), rs.getString("report_date"),
								rs.getInt("comment_cnt"),
								rs.getString("comment_date").substring(5, 19).replaceAll("-", "/")));

			}

			stmt.close();

			conn.close();

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		return commentList;

	}

	public static int reSearch(Comment commnet) {

		Integer cnt = 0;

		String sql = "SELECT COUNT(*) AS cnt FROM t_comment"
				+ " WHERE t_comment.report_no = " + commnet.getReportNo()
				+ " AND t_comment.from_account_no = " + commnet.getFromAccountNo()
				+ " AND SUBSTRING(t_comment.comment_date, 1, 10) = '" + commnet.getCommentDate().substring(0, 10) + "'"
				+ " AND t_comment.comment = '" + commnet.getComment() + "';";

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

			cnt = rs.getInt("cnt");

			stmt.close();

			conn.close();

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		return cnt;

	}

	/**
	 * <dd>メソッド名：コメント結果登録メソッド
	 * <dd>メソッド説明：受け取ったコメント結果を登録します。
	 *
	 * @param comment
	 *            コメント結果
	 */
	public static void insert(Comment comment) {

		/** コメント情報を登録するSQL文 */
		String sql = "INSERT INTO t_comment (comment_no, report_no, to_account_no, from_account_no, comment_date, comment)"
				+ " VALUES (?, ?, ?, ?, ?, ?)";

		/** データソース */
		DataSource ds = null;

		try {

			ds = DataSourceFactory.getDataSource();

		} catch (DaoException e) {

			e.printStackTrace();

		}

		try (Connection conn = ds.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, comment.getCommentNo());

			stmt.setInt(2, comment.getReportNo());

			stmt.setInt(3, comment.getToAccountNo());

			stmt.setInt(4, comment.getFromAccountNo());

			stmt.setString(5, comment.getCommentDate());

			stmt.setString(6, comment.getComment());

			stmt.executeUpdate();

			conn.commit();

			stmt.close();

			conn.close();

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

	}

	/**
	 * <dd>メソッド名：コメント削除メソッド
	 * <dd>メソッド説明：コメントを削除します。
	 *
	 * @param commentNo
	 *            コメントNo
	 */
	public static void delete(int commentNo) {

		/** コメント情報を登録するSQL文 */
		String sql = "DELETE FROM t_comment WHERE comment_no = ? ;";

		/** データソース */
		DataSource ds = null;

		try {

			ds = DataSourceFactory.getDataSource();

		} catch (DaoException e) {

			e.printStackTrace();

		}

		try (Connection conn = ds.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, commentNo);

			stmt.executeUpdate();

			conn.commit();

			stmt.close();

			conn.close();

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

	}

	/**
	 * <dd>メソッド名：最大コメントNo取得メソッド
	 * <dd>メソッド説明：コメントNoの最大値を取得します。
	 *
	 * @return maxNo 最大コメントNo
	 */
	public static int getLastNo() {

		/** 現在の最大コメントNoを取得するSQL文 */
		String sql = "SELECT MAX(comment_no) AS max_comment_no FROM t_comment";

		/** コメントNo最大値 */
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

			maxNo = rs.getInt("max_comment_no");

			stmt.close();

			conn.close();

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		return maxNo;

	}

}
