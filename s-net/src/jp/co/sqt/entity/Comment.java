/*
 *Comment.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (社員管理業務)
 *クラス一覧：
 * NO クラス名 概要
 * 1 Comment データベースから取得した情報を保持するクラスです。
 *履歴：
 * NO 日付 Ver 更新者 内容
 * 1 2017/00/00 V1L1.0 SQT）加瀬 初版。
 */

package jp.co.sqt.entity;

import java.io.Serializable;

/**
 * <dd>クラス名：コメント情報エンティティクラス
 * <dd>クラス説明：No、コメント名を扱います。
 * データベースから取得した情報を保持します。
 * @version 1.00 2017/00/00
 * @author SQT）加瀬
 */
public class Comment implements Serializable {

	/**　直列化ID　*/
	private static final long serialVersionUID = 1L;

	/**　No　*/
	private int commentNo;

	/**　レポートNo　*/
	private int reportNo;

	/**　アカウントNo（コメント受けた人）　*/
	private int toAccountNo;

	/**　アカウントNo（コメントした人）　*/
	private int fromAccountNo;

	/**　レポート日付　*/
	private String reportDate;

	/**　アカウントName　*/
	private String accountName;

	/**　コメント日時　*/
	private String commentDate;

	private int commentCnt;

	/**　コメント　*/
	private String comment;

	/**
	 * <dd>メソッド名：Commentデフォルトコンストラクタメソッド
	 * <dd>メソッド説明：インスタンスの生成を可能にします。
	 */
	public Comment() {
	}

	/**
	 * <dd>メソッド名：Commentコンストラクタメソッド
	 * <dd>メソッド説明：コメント情報を初期化します。
	 * @param commentNo No
	 * @param reportNo レポートNo
	 * @param toAccountNo アカウントNo
	 * @param fromAccountNo アカウントNo
	 * @param commentDate コメント日時
	 * @param comment コメント
	 */
	public Comment(int commentNo, int reportNo, int toAccountNo, int fromAccountNo,
			String commentDate, String comment) {

		super();

		this.commentNo = commentNo;

		this.reportNo = reportNo;

		this.toAccountNo = toAccountNo;

		this.fromAccountNo = fromAccountNo;

		this.commentDate = commentDate;

		this.comment = comment;

	}

	/**
	 * <dd>メソッド名：Commentコンストラクタメソッド
	 * <dd>メソッド説明：コメント情報を初期化します。
	 * @param commentNo No
	 * @param reportNo レポートNo
	 * @param toAccountNo アカウントNo
	 * @param fromAccountNo アカウントNo
	 * @param accountName アカウントName
	 * @param commentDate コメント日時
	 * @param comment コメント
	 */
	public Comment(int commentNo, int reportNo, int toAccountNo, int fromAccountNo,
			String accountName, String commentDate, String comment) {

		super();

		this.commentNo = commentNo;

		this.reportNo = reportNo;

		this.toAccountNo = toAccountNo;

		this.fromAccountNo = fromAccountNo;

		this.accountName = accountName;

		this.commentDate = commentDate;

		this.comment = comment;

	}

	/**
	 * <dd>メソッド名：Commentコンストラクタメソッド
	 * <dd>メソッド説明：コメント情報を初期化します。
	 * @param commentNo No
	 * @param reportNo レポートNo
	 * @param reportDate レポート日付
	 * @param toAccountNo アカウントNo
	 * @param fromAccountNo アカウントNo
	 * @param accountName アカウントName
	 * @param commentDate コメント日時
	 * @param comment コメント
	 */
	public Comment(int commentNo, int reportNo, String reportDate, int toAccountNo,
			int fromAccountNo, String accountName, String commentDate, String comment) {

		super();

		this.commentNo = commentNo;

		this.reportNo = reportNo;

		this.reportDate = reportDate;

		this.toAccountNo = toAccountNo;

		this.fromAccountNo = fromAccountNo;

		this.accountName = accountName;

		this.commentDate = commentDate;

		this.comment = comment;

	}

	//テスト
	public Comment(int reportNo, String reportDate, int commentCnt, String commentDate) {

		super();

		this.reportNo = reportNo;

		this.reportDate = reportDate;

		this.commentCnt = commentCnt;

		this.commentDate = commentDate;

	}

	/**
	 * <dd>メソッド名：No取得メソッド
	 * <dd>メソッド説明：Noを取得します。
	 * @return commentNo No
	 */
	public int getCommentNo() {

		return commentNo;

	}

	/**
	 * <dd>メソッド名：No設定メソッド
	 * <dd>メソッド説明：Noを設定します。
	 * @param commentNo No
	 */
	public void setCommentNo(int commentNo) {

		this.commentNo = commentNo;

	}

	/**
	 * <dd>メソッド名：レポートNo取得メソッド
	 * <dd>メソッド説明：レポートNoを取得します。
	 * @return reportNo No
	 */
	public int getReportNo() {

		return reportNo;

	}

	/**
	 * <dd>メソッド名：レポートNo設定メソッド
	 * <dd>メソッド説明：レポートNoを設定します。
	 * @param reportNo レポートNo
	 */
	public void setReportNo(int reportNo) {

		this.reportNo = reportNo;

	}

	/**
	 * <dd>メソッド名：レポート日付取得メソッド
	 * <dd>メソッド説明：レポート日付を取得します。
	 * @return reportDate レポート日付
	 */
	public String getReportDate() {

		return reportDate;

	}

	/**
	 * <dd>メソッド名：レポート日付設定メソッド
	 * <dd>メソッド説明：レポート日付を設定します。
	 * @param reportDate レポート日付
	 */
	public void setReportDate(String reportDate) {

		this.reportDate = reportDate;

	}

	/**
	 * <dd>メソッド名：アカウントNo取得メソッド
	 * <dd>メソッド説明：アカウントNoを取得します。
	 * @return toAccountNo アカウントNo
	 */
	public int getToAccountNo() {

		return toAccountNo;

	}

	/**
	 * <dd>メソッド名：アカウントNo設定メソッド
	 * <dd>メソッド説明：アカウントNoを設定します。
	 * @param toAccountNo アカウントNo
	 */
	public void setToAccountNo(int toAccountNo) {

		this.toAccountNo = toAccountNo;

	}

	/**
	 * <dd>メソッド名：アカウントNo取得メソッド
	 * <dd>メソッド説明：アカウントNoを取得します。
	 * @return fromAccountNo アカウントNo
	 */
	public int getFromAccountNo() {

		return fromAccountNo;

	}

	/**
	 * <dd>メソッド名：アカウントNo設定メソッド
	 * <dd>メソッド説明：アカウントNoを設定します。
	 * @param fromAccountNo アカウントNo
	 */
	public void setFromAccountNo(int fromAccountNo) {

		this.fromAccountNo = fromAccountNo;

	}

	/**
	 * <dd>メソッド名：アカウントName取得メソッド
	 * <dd>メソッド説明：アカウントNameを取得します。
	 * @return accountName アカウントName
	 */
	public String getAccountName() {

		return accountName;

	}

	/**
	 * <dd>メソッド名：アカウントName設定メソッド
	 * <dd>メソッド説明：アカウントNameを設定します。
	 * @param accountName アカウントName
	 */
	public void setAccountName(String accountName) {

		this.accountName = accountName;

	}

	/**
	 * <dd>メソッド名：コメント日時取得メソッド
	 * <dd>メソッド説明：コメント日時を取得します。
	 * @return commentDate コメント日時
	 */
	public String getCommentDate() {

		return commentDate;

	}

	/**
	 * <dd>メソッド名：コメント日時設定メソッド
	 * <dd>メソッド説明：コメント日時を設定します。
	 * @param commentDate コメント日時
	 */
	public void setCommentDate(String commentDate) {

		this.commentDate = commentDate;

	}

	/**
	 * <dd>メソッド名：コメント取得メソッド
	 * <dd>メソッド説明：コメントを取得します。
	 * @return commentCnt コメント
	 */
	public int getCommentCnt() {

		return commentCnt;

	}

	/**
	 * <dd>メソッド名：コメント設定メソッド
	 * <dd>メソッド説明：コメントを設定します。
	 * @param commentCnt コメント
	 */
	public void setCommentCnt(int commentCnt) {

		this.commentCnt = commentCnt;

	}

	/**
	 * <dd>メソッド名：コメント取得メソッド
	 * <dd>メソッド説明：コメントを取得します。
	 * @return comment コメント
	 */
	public String getComment() {

		return comment;

	}

	/**
	 * <dd>メソッド名：コメント設定メソッド
	 * <dd>メソッド説明：コメントを設定します。
	 * @param comment コメント
	 */
	public void setComment(String comment) {

		this.comment = comment;

	}

}
