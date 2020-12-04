/*
 *Duties.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (社員管理業務)
 *クラス一覧：
 * NO クラス名 概要
 * 1 Duties データベースから取得した情報を保持するクラスです。
 *履歴：
 * NO 日付 Ver 更新者 内容
 * 1 2017/00/00 V1L1.0 SQT）加瀬 初版。
 */

package jp.co.sqt.entity;

import java.io.Serializable;

/**
 * <dd>クラス名：役割情報エンティティクラス
 * <dd>クラス説明：役割No、役割名を扱います。
 * データベースから取得した情報を保持します。
 *
 * @version 1.00 2017/00/00
 * @author SQT）加瀬
 */
public class Duties implements Serializable {

	/**　直列化ID　*/
	private static final long serialVersionUID = 1L;

	/**　役割No　*/
	private int dutiesNo;

	/**　役割名　*/
	private String dutiesName;

	/**　備考　*/
	private String dutiesRemarks;

	/**
	 * <dd>メソッド名：Dutiesデフォルトコンストラクタメソッド
	 * <dd>メソッド説明：インスタンスの生成を可能にします。
	 */
	public Duties() {
	}

	/**
	 * <dd>メソッド名：Dutiesコンストラクタメソッド
	 * <dd>メソッド説明：役割情報を初期化します。
	 * @param dutiesNo 役割No
	 * @param dutiesName 役割名
	 * @param dutiesRemarks 備考
	 */
	public Duties(int dutiesNo, String dutiesName, String dutiesRemarks) {

		super();

		this.dutiesNo = dutiesNo;

		this.dutiesName = dutiesName;

		this.dutiesRemarks = dutiesRemarks;
	}

	/**
	 * <dd>メソッド名：役割No取得メソッド
	 * <dd>メソッド説明：役割Noを取得します。
	 * @return dutiesNo 役割No
	 */
	public int getDutiesNo() {

		return dutiesNo;

	}

	/**
	 * <dd>メソッド名：役割No設定メソッド
	 * <dd>メソッド説明：役割Noを設定します。
	 * @param dutiesNo 役割No
	 */
	public void setDutiesNo(int dutiesNo) {

		this.dutiesNo = dutiesNo;

	}

	/**
	 * <dd>メソッド名：役割名取得メソッド
	 * <dd>メソッド説明：役割名を取得します。
	 * @return dutiesName 役割名
	 */
	public String getDutiesName() {

		return dutiesName;

	}

	/**
	 * <dd>メソッド名：役割名設定メソッド
	 * <dd>メソッド説明：役割名を設定します。
	 * @param dutiesName 役割名
	 */
	public void setDutiesName(String dutiesName) {

		this.dutiesName = dutiesName;

	}

	/**
	 * <dd>メソッド名：備考取得メソッド
	 * <dd>メソッド説明：備考を取得します。
	 * @return dutiesRemarks 備考
	 */
	public String getDutiesRemarks() {

		return dutiesRemarks;

	}

	/**
	 * <dd>メソッド名：備考設定メソッド
	 * <dd>メソッド説明：備考を設定します。
	 * @param dutiesRemarks 備考
	 */
	public void setDutiesRemarks(String dutiesRemarks) {

		this.dutiesRemarks = dutiesRemarks;

	}

}
