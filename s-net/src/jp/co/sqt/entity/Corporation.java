/*
 *Corporation.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (社員管理業務)
 *クラス一覧：
 * NO クラス名 概要
 * 1 Corporation データベースから取得した情報を保持するクラスです。
 *履歴：
 * NO 日付 Ver 更新者 内容
 * 1 2017/00/00 V1L1.0 SQT）加瀬 初版。
 */

package jp.co.sqt.entity;

import java.io.Serializable;

/**
 * <dd>クラス名：企業情報エンティティクラス
 * <dd>クラス説明：企業No、企業名を扱います。 データベースから取得した情報を保持します。
 *
 * @version 1.00 2017/00/00
 * @author SQT）加瀬
 */
public class Corporation implements Serializable {

	/** 直列化ID */
	private static final long serialVersionUID = 1L;

	/** 企業No */
	private int corporationNo;

	/** 企業名 */
	private String corporationName;

	/** 企業名（カナ） */
	private String corporationKanaName;

	/** 郵便番号 */
	private String corporationPostalcode;

	/** 住所 */
	private String corporationAddress;

	/** 電話番号 */
	private String corporationTel;

	/** FAX番号 */
	private String corporationFax;

	/** 代表者役職 */
	private String corporationRepresentative;

	/** 代表者氏名 */
	private String corporationRepresentativeName;

	/**
	 * <dd>メソッド名：Corporationデフォルトコンストラクタメソッド
	 * <dd>メソッド説明：インスタンスの生成を可能にします。
	 */
	public Corporation() {
	}

	/**
	 * <dd>メソッド名：Corporationコンストラクタメソッド
	 * <dd>メソッド説明：企業情報を初期化します。
	 *
	 * @param corporationId
	 *            企業No
	 * @param corporationName
	 *            企業名
	 */
	public Corporation(int corporationNo, String corporationName, String corporationKanaName,
			String corporationPostalcode, String corporationAddress, String corporationTel, String corporationFax,
			String corporationRepresentative, String corporationRepresentativeName) {

		super();

		this.corporationNo = corporationNo;

		this.corporationName = corporationName;

		this.corporationKanaName = corporationKanaName;

		this.corporationPostalcode = corporationPostalcode;

		this.corporationAddress = corporationAddress;

		this.corporationTel = corporationTel;

		this.corporationFax = corporationFax;

		this.corporationRepresentative = corporationRepresentative;

		this.corporationRepresentativeName = corporationRepresentativeName;

	}

	/**
	 * <dd>メソッド名：Corporationコンストラクタメソッド
	 * <dd>メソッド説明：企業情報を初期化します。
	 *
	 * @param corporationName
	 *            企業名
	 * @param corporationKanaName
	 *            企業カナ名
	 */
	public Corporation(int corporationNo, String corporationName, String corporationKanaName) {

		super();

		this.corporationNo = corporationNo;

		this.corporationName = corporationName;

		this.corporationKanaName = corporationKanaName;

	}

	/**
	 * <dd>メソッド名：Corporationコンストラクタメソッド
	 * <dd>メソッド説明：企業情報を初期化します。
	 *
	 * @param corporationNo
	 *            企業No
	 * @param corporationName
	 *            企業名
	 */

	public Corporation(int corporationNo, String corporationName) {

		super();

		this.corporationNo = corporationNo;

		this.corporationName = corporationName;

	}

	/**
	 * <dd>メソッド名：企業No取得メソッド
	 * <dd>メソッド説明：企業Noを取得します。
	 *
	 * @return corporationNo 企業No
	 */
	public int getCorporationNo() {

		return corporationNo;

	}

	/**
	 * <dd>メソッド名：企業No設定メソッド
	 * <dd>メソッド説明：企業Noを設定します。
	 *
	 * @param corporationNo
	 *            企業No
	 */
	public void setCorporationNo(int corporationNo) {

		this.corporationNo = corporationNo;

	}

	/**
	 * <dd>メソッド名：企業名取得メソッド
	 * <dd>メソッド説明：企業名を取得します。
	 *
	 * @return corporationName 企業名
	 */
	public String getCorporationName() {

		return corporationName;

	}

	/**
	 * <dd>メソッド名：企業名設定メソッド
	 * <dd>メソッド説明：企業名を設定します。
	 *
	 * @param corporationName
	 *            企業名
	 */
	public void setCorporationName(String corporationName) {

		this.corporationName = corporationName;

	}

	/**
	 * <dd>メソッド名：企業名（カナ）取得メソッド
	 * <dd>メソッド説明：企業名（カナ）を取得します。
	 *
	 * @return corporationKanaName 企業名（カナ）
	 */
	public String getCorporationKanaName() {

		return corporationKanaName;

	}

	/**
	 * <dd>メソッド名：企業名（カナ）設定メソッド
	 * <dd>メソッド説明：企業名（カナ）を設定します。
	 *
	 * @param corporationKanaName
	 *            企業名（カナ）
	 */
	public void setCorporationKanaName(String corporationKanaName) {

		this.corporationKanaName = corporationKanaName;

	}

	/**
	 * <dd>メソッド名：郵便番号取得メソッド
	 * <dd>メソッド説明：郵便番号を取得します。
	 *
	 * @return corporationPostalcode 郵便番号
	 */
	public String getCorporationPostalcode() {

		return corporationPostalcode;

	}

	/**
	 * <dd>メソッド名：郵便番号設定メソッド
	 * <dd>メソッド説明：郵便番号を設定します。
	 *
	 * @param corporationPostalcode
	 *            郵便番号
	 */
	public void setCorporationPostalcode(String corporationPostalcode) {

		this.corporationPostalcode = corporationPostalcode;

	}

	/**
	 * <dd>メソッド名：住所取得メソッド
	 * <dd>メソッド説明：住所を取得します。
	 *
	 * @return corporationAddress 住所
	 */
	public String getCorporationAddress() {

		return corporationAddress;

	}

	/**
	 * <dd>メソッド名：住所設定メソッド
	 * <dd>メソッド説明：住所を設定します。
	 *
	 * @param corporationAddress
	 *            住所
	 */
	public void setCorporationAddress(String corporationAddress) {

		this.corporationAddress = corporationAddress;

	}

	/**
	 * <dd>メソッド名：電話番号取得メソッド
	 * <dd>メソッド説明：電話番号を取得します。
	 *
	 * @return corporationTel 電話番号
	 */
	public String getCorporationTel() {

		return corporationTel;

	}

	/**
	 * <dd>メソッド名：電話番号設定メソッド
	 * <dd>メソッド説明：電話番号を設定します。
	 *
	 * @param corporationTel
	 *            電話番号
	 */
	public void setCorporationTel(String corporationTel) {

		this.corporationTel = corporationTel;

	}

	/**
	 * <dd>メソッド名：FAX番号取得メソッド
	 * <dd>メソッド説明：FAX番号を取得します。
	 *
	 * @return corporationFax FAX番号
	 */
	public String getCorporationFax() {

		return corporationFax;

	}

	/**
	 * <dd>メソッド名：FAX番号設定メソッド
	 * <dd>メソッド説明：FAX番号を設定します。
	 *
	 * @param corporationFax
	 *            FAX番号
	 */
	public void setCorporationFax(String corporationFax) {

		this.corporationFax = corporationFax;

	}

	/**
	 * <dd>メソッド名：代表者役職取得メソッド
	 * <dd>メソッド説明：代表者役職を取得します。
	 *
	 * @return corporationRepresentative 代表者役職
	 */
	public String getCorporationRepresentative() {

		return corporationRepresentative;

	}

	/**
	 * <dd>メソッド名：代表者役職設定メソッド
	 * <dd>メソッド説明：代表者役職を設定します。
	 *
	 * @param corporationRepresentative
	 *            代表者役職
	 */
	public void setCorporationRepresentative(String corporationRepresentative) {

		this.corporationRepresentative = corporationRepresentative;

	}

	/**
	 * <dd>メソッド名：代表者氏名取得メソッド
	 * <dd>メソッド説明：代表者氏名を取得します。
	 *
	 * @return corporationRepresentativeName 代表者氏名
	 */
	public String getCorporationRepresentativeName() {

		return corporationRepresentativeName;

	}

	/**
	 * <dd>メソッド名：代表者氏名設定メソッド
	 * <dd>メソッド説明：代表者氏名を設定します。
	 *
	 * @param corporationRepresentativeName
	 *            代表者氏名
	 */
	public void setCorporationRepresentativeName(String corporationRepresentativeName) {

		this.corporationRepresentativeName = corporationRepresentativeName;

	}

}
