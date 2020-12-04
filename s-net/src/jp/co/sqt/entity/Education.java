/*
 *Education.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (受講生管理業務)
 *クラス一覧：
 * NO クラス名 概要
 * 1 Education データベースから取得した情報を保持するクラスです。
 *履歴：
 * NO 日付 Ver 更新者 内容
 * 1 2017/00/00 V1L1.0 SQT）加瀬 初版。
 */

package jp.co.sqt.entity;

import java.io.Serializable;

/**
 * <dd>クラス名：受講生情報エンティティクラス
 * <dd>クラス説明：アカウントNo、氏名、氏名（カナ）、性別、入社日、企業情報、電話番号、備考情報リストを扱います。
 * データベースから取得した情報を保持します。
 *
 * @version 1.00 2017/00/00
 * @author SQT）加瀬
 */
public class Education implements Serializable {

	/** 直列化ID */
	private static final long serialVersionUID = 1L;

	/** educationNo */
	private int educationNo;

	/** アカウントNo */
	private int accountNo;

	/** 受講生氏名 */
	private String educationName;

	/** 受講生氏名（カナ） */
	private String educationKanaName;

	/** 性別 */
	private int educationGender;

	/** 生年月日  */
	private String educationBirthday;

	/** 郵便番号  */
	private String educationPostalcode;

	/** 住所  */
	private String educationAddress;

	/** 電話番号  */
	private String educationPhoneNumber;

	/** メールアドレス  */
	private String educationEmailAddress;

	/** 企業情報 */
	private Corporation corporation;

	/** 企業No */
	private int corporationNo;

	/** 企業名  */
	private String corporationName;

	/**  入社月日*/
	private String enterningDate;

	/** 役割情報 */
	private Duties duties;

	/** 役割No1 */
	private int dutiesNo1;

	/** 役割No2 */
	private int dutiesNo2;

	/** 役割No3 */
	private int dutiesNo3;

	/** 役割Name1 */
	private String dutiesNameNo1;

	/** 役割Name2 */
	private String dutiesNameNo2;

	/** 役割Name3 */
	private String dutiesNameNo3;

	/** 備考 */
	private String educationRemarks;

	/**
	 * <dd>メソッド名：Rookiesデフォルトコンストラクタメソッド
	 * <dd>メソッド説明：インスタンスの生成を可能にします。
	 */
	public Education() {
	}

	/**
	 * <dd>メソッド名：Educationコンストラクタメソッド
	 * <dd>メソッド説明：受講生情報を初期化します。
	 *
	 * @param educationNo
	 *            educationNo
	 * @param accountNo
	 *            アカウントNo
	 * @param educationName
	 *            受講生氏名
	 * @param educationKanaName
	 *            受講生氏名（カナ）
	 * @param educationGender
	 *            性別
	 * @param educationBirthday
	 *            生年月日
	 * @param educationPostalcode
	 *            郵便番号
	 * @param educationAddress
	 *            住所
	 * @param educationPhoneNumber
	 *            電話番号
	 * @param educationEmailAddress
	 *            メールアドレス
	 * @param corporationNo
	 *            企業No
	 * @param enterningDate
	 *            入社月日
	 * @param dutiesNo1
	 *            役割No1
	 * @param dutiesNo2
	 *            役割No2
	 * @param dutiesNo3
	 *            役割No3
	 * @param educationRemarks
	 *            備考
	 */
	public Education(int educationNo, int accountNo, String educationName, String educationKanaName,
			int educationGender,
			String educationBirthday, String educationPostalcode, String educationAddress, String educationPhoneNumber,
			String educationEmailAddress, int corporationNo, String enterningDate, int dutiesNo1, int dutiesNo2,
			int dutiesNo3, String educationRemarks) {

		super();

		this.educationNo = educationNo;

		this.accountNo = accountNo;

		this.educationName = educationName;

		this.educationKanaName = educationKanaName;

		this.educationGender = educationGender;

		this.educationBirthday = educationBirthday;

		this.educationPostalcode = educationPostalcode;

		this.educationAddress = educationAddress;

		this.educationPhoneNumber = educationPhoneNumber;

		this.educationEmailAddress = educationEmailAddress;

		this.corporationNo = corporationNo;

		this.enterningDate = enterningDate;

		this.dutiesNo1 = dutiesNo1;

		this.dutiesNo2 = dutiesNo2;

		this.dutiesNo3 = dutiesNo3;

		this.educationRemarks = educationRemarks;

	}

	/**
	 * <dd>メソッド名：Educationコンストラクタメソッド
	 * <dd>メソッド説明：受講生情報を初期化します。
	 *
	 * @param educationNo
	 *            educationNo
	 * @param accountNo
	 *            アカウントNo
	 * @param educationName
	 *            受講生氏名
	 * @param educationKanaName
	 *            受講生氏名（カナ）
	 * @param corporation
	 *            企業
	 * @param enterningDate
	 *            入社月日
	 * @param duties
	 *            役割
	 */
	public Education(int educationNo, int accountNo, String educationName, String educationKanaName,
			Corporation corporation, String enterningDate, Duties duties) {

		super();

		this.educationNo = educationNo;

		this.accountNo = accountNo;

		this.educationName = educationName;

		this.educationKanaName = educationKanaName;

		this.corporation = corporation;

		this.enterningDate = enterningDate;

		this.duties = duties;

	}

	/**
	 * <dd>メソッド名：Educationコンストラクタメソッド
	 * <dd>メソッド説明：受講生情報を初期化します。
	 *
	 * @param educationName
	 *            受講生氏名
	 * @param educationNo
	 *            educationNo
	 * @param accountNo
	 *            アカウントNo
	 * @param educationName
	 *            受講生氏名
	 * @param educationKanaName
	 *            受講生氏名（カナ）
	 * @param educationGender
	 *            性別
	 * @param educationBirthday
	 *            生年月日
	 * @param educationPostalcode
	 *            郵便番号
	 * @param educationAddress
	 *            住所
	 * @param educationPhoneNumber
	 *            電話番号
	 * @param educationEmailAddress
	 *            メールアドレス
	 * @param corporation
	 *            企業情報
	 * @param enterningDate
	 *            入社月日
	 * @param dutiesNo1
	 *            役割No1
	 * @param dutiesNameNo1
	 *            役割名No1
	 * @param dutiesNo2
	 *            役割No2
	 * @param dutiesNameNo2
	 *            役割名No2
	 * @param dutiesNo3
	 *            役割No3
	 * @param dutiesNameNo3
	 *            役割名No3
	 * @param educationRemarks
	 *            備考
	 */
	public Education(int educationNo, int accountNo, String educationName,
			String educationKanaName, int educationGender, String educationBirthday,
			String educationPostalcode, String educationAddress, String educationPhoneNumber,
			String educationEmailAddress, Corporation corporation, String enterningDate,
			int dutiesNo1, String dutiesNameNo1, int dutiesNo2, String dutiesNameNo2,
			int dutiesNo3, String dutiesNameNo3, String educationRemarks) {

		super();

		this.educationNo = educationNo;

		this.accountNo = accountNo;

		this.educationName = educationName;

		this.educationKanaName = educationKanaName;

		this.educationGender = educationGender;

		this.educationBirthday = educationBirthday;

		this.educationPostalcode = educationPostalcode;

		this.educationAddress = educationAddress;

		this.educationPhoneNumber = educationPhoneNumber;

		this.educationEmailAddress = educationEmailAddress;

		this.corporation = corporation;

		this.enterningDate = enterningDate;

		this.dutiesNo1 = dutiesNo1;

		this.dutiesNameNo1 = dutiesNameNo1;

		this.dutiesNo2 = dutiesNo2;

		this.dutiesNameNo2 = dutiesNameNo2;

		this.dutiesNameNo3 = dutiesNameNo3;

		this.dutiesNo3 = dutiesNo3;

		this.educationRemarks = educationRemarks;

	}

	/**
	 * <dd>メソッド名：Educationコンストラクタメソッド
	 * <dd>メソッド説明：受講生情報を初期化します。
	 *
	 * @param educationNo
	 *            educationNo
	 * @param educationName
	 *            受講生氏名
	 * @param educationKanaName
	 *            受講生氏名（カナ）
	 */
	public Education(int educationNo, String educationName, String educationKanaName) {

		super();

		this.educationNo = educationNo;

		this.educationName = educationName;

		this.educationKanaName = educationKanaName;

	}

	/**
	 * <dd>メソッド名：No取得メソッド
	 * <dd>メソッド説明：Noを取得します。
	 *
	 * @return educationNo No
	 */
	public int getEducationNo() {

		return educationNo;

	}

	/**
	 * <dd>メソッド名：No設定メソッド
	 * <dd>メソッド説明：Noを設定します。
	 *
	 * @param educationNo No
	 */
	public void setEducationNo(int educationNo) {

		this.educationNo = educationNo;

	}

	/**
	 * <dd>メソッド名：アカウントNo取得メソッド
	 * <dd>メソッド説明：アカウントNoを取得します。
	 *
	 * @return accountNo アカウントNo
	 */
	public int getAccountNo() {

		return accountNo;

	}

	/**
	 * <dd>メソッド名：アカウントNo設定メソッド
	 * <dd>メソッド説明：アカウントNoを設定します。
	 *
	 * @param accountNo
	 *            アカウントNo
	 */
	public void setAccountNo(int accountNo) {

		this.accountNo = accountNo;

	}

	/**
	 * <dd>メソッド名：受講生氏名取得メソッド
	 * <dd>メソッド説明：受講生氏名を取得します。
	 *
	 * @return educationName 受講生氏名
	 */
	public String getEducationName() {

		return educationName;

	}

	/**
	 * <dd>メソッド名：受講生氏名設定メソッド
	 * <dd>メソッド説明：受講生氏名を設定します。
	 *
	 * @param educationName
	 *            受講生氏名
	 */
	public void setEducationName(String educationName) {

		this.educationName = educationName;

	}

	/**
	 * <dd>メソッド名：受講生氏名（カナ）取得メソッド
	 * <dd>メソッド説明：受講生氏名（カナ）を取得します。
	 *
	 * @return educationKanaName 受講生氏名（カナ）
	 */
	public String getEducationKanaName() {

		return educationKanaName;

	}

	/**
	 * <dd>メソッド名：受講生氏名（カナ）設定メソッド
	 * <dd>メソッド説明：受講生氏名（カナ）を設定します。
	 *
	 * @param educationKanaName
	 *            受講生氏名（カナ）
	 */
	public void setEducationKanaName(String educationKanaName) {

		this.educationKanaName = educationKanaName;

	}

	/**
	 * <dd>メソッド名：性別取得メソッド
	 * <dd>メソッド説明：性別を取得します。
	 *
	 * @return educationGender 性別
	 */
	public int getEducationGender() {

		return educationGender;

	}

	/**
	 * <dd>メソッド名：性別設定メソッド
	 * <dd>メソッド説明：性別を設定します。
	 *
	 * @param educationGender
	 *            性別
	 */
	public void setEducationGender(int educationGender) {

		this.educationGender = educationGender;

	}

	/**
	 * <dd>メソッド名：生年月日取得メソッド
	 * <dd>メソッド説明：生年月日を取得します。
	 *
	 * @return educationBirthday 生年月日
	 */
	public String getEducationBirthday() {

		return educationBirthday;

	}

	/**
	 * <dd>メソッド名：生年月日設定メソッド
	 * <dd>メソッド説明：生年月日を設定します。
	 *
	 * @param educationBirthday
	 *            生年月日
	 */
	public void setEducationBirthday(String educationBirthday) {

		this.educationBirthday = educationBirthday;

	}

	/**
	 * <dd>メソッド名：郵便番号取得メソッド
	 * <dd>メソッド説明：郵便番号を取得します。
	 *
	 * @return educationPostalcode 郵便番号
	 */
	public String getEducationPostalcode() {

		return educationPostalcode;

	}

	/**
	 * <dd>メソッド名：郵便番号設定メソッド
	 * <dd>メソッド説明：郵便番号を設定します。
	 *
	 * @param educationPostalcode
	 *            郵便番号
	 */
	public void setEducationPostalcode(String educationPostalcode) {

		this.educationPostalcode = educationPostalcode;

	}

	/**
	 * <dd>メソッド名：住所取得メソッド
	 * <dd>メソッド説明：住所を取得します。
	 *
	 * @return educationAddress 住所
	 */
	public String getEducationAddress() {

		return educationAddress;

	}

	/**
	 * <dd>メソッド名：住所設定メソッド
	 * <dd>メソッド説明：住所を設定します。
	 *
	 * @param educationAddress
	 *            住所
	 */
	public void setEducationAddress(String educationAddress) {

		this.educationAddress = educationAddress;

	}

	/**
	 * <dd>メソッド名：電話番号取得メソッド
	 * <dd>メソッド説明：電話番号を取得します。
	 *
	 * @return educationPhoneNumber 電話番号
	 */
	public String getEducationPhoneNumber() {

		return educationPhoneNumber;

	}

	/**
	 * <dd>メソッド名：電話番号設定メソッド
	 * <dd>メソッド説明：電話番号を設定します。
	 *
	 * @param educationPhoneNumber
	 *            電話番号
	 */
	public void setEducationPhoneNumber(String educationPhoneNumber) {

		this.educationPhoneNumber = educationPhoneNumber;

	}

	/**
	 * <dd>メソッド名：メールアドレス取得メソッド
	 * <dd>メソッド説明：メールアドレスを取得します。
	 *
	 * @return educationEmailAddress メールアドレス
	 */
	public String getEducationEmailAddress() {

		return educationEmailAddress;

	}

	/**
	 * <dd>メソッド名：メールアドレス設定メソッド
	 * <dd>メソッド説明：メールアドレスを設定します。
	 *
	 * @param educationEmailAddress
	 *            メールアドレス
	 */
	public void setEducationEmailAddress(String educationEmailAddress) {

		this.educationEmailAddress = educationEmailAddress;

	}

	/**
	 * <dd>メソッド名：企業取得メソッド
	 * <dd>メソッド説明：企業を取得します。
	 *
	 * @return corporation 企業
	 */
	public Corporation getCorporation() {

		return corporation;

	}

	/**
	 * <dd>メソッド名：企業設定メソッド
	 * <dd>メソッド説明：企業を設定します。
	 *
	 * @param corporation
	 *            企業
	 */
	public void setCorporation(Corporation corporation) {

		this.corporation = corporation;

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
	 * <dd>メソッド名：入社月日取得メソッド
	 * <dd>メソッド説明：入社月日を取得します。
	 *
	 * @return enterningDate 入社月日
	 */
	public String getEnterningDate() {

		return enterningDate;

	}

	/**
	 * <dd>メソッド名：入社月日設定メソッド
	 * <dd>メソッド説明：入社月日を設定します。
	 *
	 * @param enterningDate
	 *            入社月日
	 */
	public void setEnterningDate(String enterningDate) {

		this.enterningDate = enterningDate;

	}

	/**
	 * <dd>メソッド名：役割取得メソッド
	 * <dd>メソッド説明：役割を取得します。
	 *
	 * @return duties
	 *            役割
	 */
	public Duties getDuties() {

		return duties;

	}

	/**
	 * <dd>メソッド名：役割設定メソッド
	 * <dd>メソッド説明：役割を設定します。
	 *
	 * @param duties
	 *            役割
	 */
	public void setDuties(Duties duties) {

		this.duties = duties;

	}

	/**
	 * <dd>メソッド名：役割No1取得メソッド
	 * <dd>メソッド説明：役割No1を取得します。
	 *
	 * @return dutiesNo1
	 *            役割No1
	 */
	public int getDutiesNo1() {

		return dutiesNo1;

	}

	/**
	 * <dd>メソッド名：役割No1設定メソッド
	 * <dd>メソッド説明：役割No1を設定します。
	 *
	 * @param dutiesNo1
	 *            役割No1
	 */
	public void setDutiesNo1(int dutiesNo1) {

		this.dutiesNo1 = dutiesNo1;

	}

	/**
	 * <dd>メソッド名：役割No2取得メソッド
	 * <dd>メソッド説明：役割No2を取得します。
	 *
	 * @return dutiesNo2
	 *            役割No2
	 */
	public int getDutiesNo2() {

		return dutiesNo2;

	}

	/**
	 * <dd>メソッド名：役割No2設定メソッド
	 * <dd>メソッド説明：役割No2を設定します。
	 *
	 * @param dutiesNo2
	 *            役割No2
	 */
	public void setDutiesNo2(int dutiesNo2) {

		this.dutiesNo2 = dutiesNo2;

	}

	/**
	 * <dd>メソッド名：役割No3取得メソッド
	 * <dd>メソッド説明：役割No3を取得します。
	 *
	 * @return dutiesNo3
	 *            役割No3
	 */
	public int getDutiesNo3() {

		return dutiesNo3;

	}

	/**
	 * <dd>メソッド名：役割No3設定メソッド
	 * <dd>メソッド説明：役割No3を設定します。
	 *
	 * @param dutiesNo3
	 *            役割No3
	 */
	public void setDutiesNo3(int dutiesNo3) {

		this.dutiesNo3 = dutiesNo3;

	}

	/**
	 * <dd>メソッド名：役割名No1取得メソッド
	 * <dd>メソッド説明：役割名No1を取得します。
	 *
	 * @return dutiesNameNo1
	 *            役割名No1
	 */
	public String getDutiesNameNo1() {

		return dutiesNameNo1;

	}

	/**
	 * <dd>メソッド名：役割名No1設定メソッド
	 * <dd>メソッド説明：役割名No1を設定します。
	 *
	 * @param dutiesNameNo1
	 *            役割名No1
	 */
	public void setDutiesNameNo1(String dutiesNameNo1) {

		this.dutiesNameNo1 = dutiesNameNo1;

	}

	/**
	 * <dd>メソッド名：役割名No2取得メソッド
	 * <dd>メソッド説明：役割名No2を取得します。
	 *
	 * @return dutiesNameNo2
	 *            役割名No2
	 */
	public String getDutiesNameNo2() {

		return dutiesNameNo2;

	}

	/**
	 * <dd>メソッド名：役割名No2設定メソッド
	 * <dd>メソッド説明：役割名No2を設定します。
	 *
	 * @param dutiesNameNo2
	 *            役割名No2
	 */
	public void setDutiesNameNo2(String dutiesNameNo2) {

		this.dutiesNameNo2 = dutiesNameNo2;

	}

	/**
	 * <dd>メソッド名：役割名No3取得メソッド
	 * <dd>メソッド説明：役割名No3を取得します。
	 *
	 * @return dutiesNameNo3
	 *            役割名No3
	 */
	public String getDutiesNameNo3() {

		return dutiesNameNo3;

	}

	/**
	 * <dd>メソッド名：役割名No3設定メソッド
	 * <dd>メソッド説明：役割名No3を設定します。
	 *
	 * @param dutiesNameNo3
	 *            役割名No3
	 */
	public void setDutiesNameNo3(String dutiesNameNo3) {

		this.dutiesNameNo3 = dutiesNameNo3;

	}

	/**
	 * <dd>メソッド名：備考取得メソッド
	 * <dd>メソッド説明：備考を取得します。
	 *
	 * @return educationRemarks
	 *            備考
	 */
	public String getEducationRemarks() {

		return educationRemarks;

	}

	/**
	 * <dd>メソッド名：備考設定メソッド
	 * <dd>メソッド説明：備考を設定します。
	 *
	 * @param educationRemarks
	 *            備考
	 */
	public void setEducationRemarks(String educationRemarks) {

		this.educationRemarks = educationRemarks;

	}

}
