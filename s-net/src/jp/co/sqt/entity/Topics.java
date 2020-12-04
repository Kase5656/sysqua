/*
 *Topics.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (社員管理業務)
 *クラス一覧：
 * NO クラス名 概要
 * 1 Topics データベースから取得した情報を保持するクラスです。
 *履歴：
 * NO 日付 Ver 更新者 内容
 * 1 2017/00/00 V1L1.0 SQT）加瀬 初版。
 */

package jp.co.sqt.entity;

import java.io.Serializable;

/**
 * <dd>クラス名：お知らせ情報エンティティクラス
 * <dd>クラス説明：No、会社名を扱います。
 * データベースから取得した情報を保持します。
 * @version 1.00 2017/00/00
 * @author SQT）加瀬
 */
public class Topics implements Serializable {

	/**　直列化ID　*/
	private static final long serialVersionUID = 1L;

	/**　お知らせNo　*/
	private int topicsNo;

	/**　お知らせ日時　*/
	private String topicsDate;

	/**　お知らせタイトル　*/
	private String topicsTitle;

	/**　お知らせ内容　*/
	private String topicsContents;

	/**　お知らせフラグ　*/
	private int topicsFlg;

	/**　削除フラグ　*/
	private int deleteFlg;

	/**
	 * <dd>メソッド名：Topicsデフォルトコンストラクタメソッド
	 * <dd>メソッド説明：インスタンスの生成を可能にします。
	 */
	public Topics() {
	}

	/**
	 * <dd>メソッド名：Topicsコンストラクタメソッド
	 * <dd>メソッド説明：会社情報を初期化します。
	 * @param topicsNo お知らせNo
	 * @param topicsDate お知らせ日時
	 * @param topicsTitle お知らせタイトル
	 * @param topicsContents お知らせ内容
	 * @param topicsFlg お知らせフラグ
	 */
	public Topics(int topicsNo, String topicsDate, String topicsTitle,
			String topicsContents, int topicsFlg, int deleteFlg) {

		super();

		this.topicsNo = topicsNo;

		this.topicsDate = topicsDate;

		this.topicsTitle = topicsTitle;

		this.topicsContents = topicsContents;

		this.topicsFlg = topicsFlg;

		this.deleteFlg = deleteFlg;

	}

	/**
	 * <dd>メソッド名：お知らせNo取得メソッド
	 * <dd>メソッド説明：お知らせNoを取得します。
	 * @return topicsNo お知らせNo
	 */
	public int getTopicsNo() {

		return topicsNo;

	}

	/**
	 * <dd>メソッド名：お知らせNo設定メソッド
	 * <dd>メソッド説明：お知らせNoを設定します。
	 * @param topicsNo お知らせNo
	 */
	public void setTopicsNo(int topicsNo) {

		this.topicsNo = topicsNo;

	}

	/**
	 * <dd>メソッド名：お知らせ日時取得メソッド
	 * <dd>メソッド説明：お知らせ日時を取得します。
	 * @return topicsDate お知らせ日時
	 */
	public String getTopicsDate() {

		return topicsDate;

	}

	/**
	 * <dd>メソッド名：お知らせ日時設定メソッド
	 * <dd>メソッド説明：お知らせ日時を設定します。
	 * @param topicsDate お知らせ日時
	 */
	public void setTopicsDate(String topicsDate) {

		this.topicsDate = topicsDate;

	}

	/**
	 * <dd>メソッド名：お知らせタイトル取得メソッド
	 * <dd>メソッド説明：お知らせタイトルを取得します。
	 * @return topicsTitle お知らせタイトル
	 */
	public String getTopicsTitle() {

		return topicsTitle;

	}

	/**
	 * <dd>メソッド名：お知らせタイトル設定メソッド
	 * <dd>メソッド説明：お知らせタイトルを設定します。
	 * @param topicsTitle お知らせタイトル
	 */
	public void setTopicsTitle(String topicsTitle) {

		this.topicsTitle = topicsTitle;

	}

	/**
	 * <dd>メソッド名：お知らせ内容取得メソッド
	 * <dd>メソッド説明：お知らせ内容を取得します。
	 * @return topicsContents お知らせ内容
	 */
	public String getTopicsContents() {

		return topicsContents;

	}

	/**
	 * <dd>メソッド名：お知らせ内容設定メソッド
	 * <dd>メソッド説明：お知らせ内容を設定します。
	 * @param topicsContents お知らせ内容
	 */
	public void setTopicsContents(String topicsContents) {

		this.topicsContents = topicsContents;

	}

	/**
	 * <dd>メソッド名：お知らせフラグ取得メソッド
	 * <dd>メソッド説明：お知らせフラグを取得します。
	 * @return topicsFlg お知らせフラグ
	 */
	public int getTopicsFlg() {

		return topicsFlg;

	}

	/**
	 * <dd>メソッド名：お知らせフラグ設定メソッド
	 * <dd>メソッド説明：お知らせフラグを設定します。
	 * @param topicsFlg お知らせフラグ
	 */
	public void setTopicsFlg(int topicsFlg) {

		this.topicsFlg = topicsFlg;

	}

	/**
	 * <dd>メソッド名：削除フラグ取得メソッド
	 * <dd>メソッド説明：削除フラグを取得します。
	 * @return deleteFlg 削除フラグ
	 */
	public int getDeleteFlg() {

		return deleteFlg;

	}

	/**
	 * <dd>メソッド名：削除フラグ設定メソッド
	 * <dd>メソッド説明：削除フラグを設定します。
	 * @param deleteFlg 削除フラグ
	 */
	public void setDeleteFlg(int deleteFlg) {

		this.deleteFlg = deleteFlg;

	}

}
