/*
Date *Test.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (受講生管理業務)
 *クラス一覧：
 * NO クラス名 概要
 * 1 Test データベースから取得した情報を保持するクラスです。
 *履歴：
 * NO 日付 Ver 更新者 内容
 * 1 2017/00/00 V1L1.0 SQT）加瀬 初版。
 */

package jp.co.sqt.entity;

import java.io.Serializable;

/**
 * <dd>クラス名：テスト情報エンティティクラス
 * <dd>クラス説明：テストID、テスト名を扱います。 データベースから取得した情報を保持します。
 *
 * @version 1.00 2017/00/00
 * @author SQT）加瀬
 */
public class Test implements Serializable {

	/** 直列化ID */
	private static final long serialVersionUID = 1L;

	/** No */
	private int no;

	/** アカウントNo */
	private int accountNo;

	/** テストNo */
	private int testNo;

	/** テスト回数 */
	private int testCount;

	/** テスト点数 */
	private int testScore;

	/** テスト日 */
	private String testDate;

	/** テスト日時分 */
	private String testDateTime;

	/** テスト1回答 */
	private String testAnswer1;

	/** テスト2回答 */
	private String testAnswer2;

	/** テスト3回答 */
	private String testAnswer3;

	/** テスト4回答 */
	private String testAnswer4;

	/** テスト5回答 */
	private String testAnswer5;

	/**
	 * <dd>メソッド名：Testデフォルトコンストラクタメソッド
	 * <dd>メソッド説明：インスタンスの生成を可能にします。
	 */
	public Test() {
	}

	/**
	 * <dd>メソッド名：Testコンストラクタメソッド
	 * <dd>メソッド説明：テスト情報を初期化します。
	 *
	 * @param
	 *
	 * @param
	 *
	 */
	public Test(int no, int accountNo, int testNo, int testCount, int testScore,
			String testDate, String testDateTime, String testAnswer1, String testAnswer2, String testAnswer3, String testAnswer4, String testAnswer5) {

		super();

		this.no = no;

		this.accountNo = accountNo;

		this.testNo = testNo;

		this.testCount = testCount;

		this.testScore = testScore;

		this.testDate = testDate;

		this.testDateTime = testDateTime;

		this.testAnswer1 = testAnswer1;

		this.testAnswer2 = testAnswer2;

		this.testAnswer3 = testAnswer3;

		this.testAnswer4 = testAnswer4;

		this.testAnswer5 = testAnswer5;

	}

	/**
	 * <dd>メソッド名：No取得メソッド
	 * <dd>メソッド説明：Noを取得します。
	 *
	 * @return no No
	 */
	public int getNo() {

		return no;

	}

	/**
	 * <dd>メソッド名：No設定メソッド
	 * <dd>メソッド説明：Noを設定します。
	 *
	 * @param no
	 *            No
	 */
	public void setNo(int no) {

		this.no = no;

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
	 * <dd>メソッド名：テストNo取得メソッド
	 * <dd>メソッド説明：テストNoを取得します。
	 *
	 * @return testNo テストNo
	 */
	public int getTestNo() {

		return testNo;

	}

	/**
	 * <dd>メソッド名：テストNo設定メソッド
	 * <dd>メソッド説明：テストNoを設定します。
	 *
	 * @param testNo
	 *            テストNo
	 */
	public void setTestNo(int testNo) {

		this.testNo = testNo;

	}

	/**
	 * <dd>メソッド名：テスト点数取得メソッド
	 * <dd>メソッド説明：テスト点数を取得します。
	 *
	 * @return testScore1 テスト点数
	 */
	public int getTestScore() {

		return testScore;

	}

	/**
	 * <dd>メソッド名：テスト点数設定メソッド
	 * <dd>メソッド説明：テスト点数を設定します。
	 *
	 * @param testScore
	 *            テスト点数
	 */
	public void setTestScore(int testScore) {

		this.testScore = testScore;

	}

	/**
	 * <dd>メソッド名：テスト回数取得メソッド
	 * <dd>メソッド説明：テスト回数を取得します。
	 *
	 * @return testCount テスト回数
	 */
	public int getTestCount() {

		return testCount;

	}

	/**
	 * <dd>メソッド名：テスト回数設定メソッド
	 * <dd>メソッド説明：テスト回数を設定します。
	 *
	 * @param testCount
	 *            テスト回数
	 */
	public void setTestCount(int testCount) {

		this.testCount = testCount;

	}

	/**
	 * <dd>メソッド名：テスト日時分取得メソッド
	 * <dd>メソッド説明：テスト日時分を取得します。
	 *
	 * @return testDate テスト日時分
	 */
	public String getTestDate() {

		return testDate;

	}

	/**
	 * <dd>メソッド名：テスト日時分設定メソッド
	 * <dd>メソッド説明：テスト日時分を設定します。
	 *
	 * @param testDate
	 *            テスト日時分
	 */
	public void setTestDate(String testDate) {

		this.testDate = testDate;

	}

	/**
	 * <dd>メソッド名：テスト日時分取得メソッド
	 * <dd>メソッド説明：テスト日時分を取得します。
	 *
	 * @return testDateTime テスト日時分
	 */
	public String getTestDateTime() {

		return testDateTime;

	}

	/**
	 * <dd>メソッド名：テスト日時分設定メソッド
	 * <dd>メソッド説明：テスト日時分を設定します。
	 *
	 * @param testDateTime
	 *            テスト日時分
	 */
	public void setTestDateTime(String testDateTime) {

		this.testDateTime = testDateTime;

	}

	/**
	 * <dd>メソッド名：テスト1取得メソッド
	 * <dd>メソッド説明：テスト1を取得します。
	 *
	 * @return testAnswer1 テスト1
	 */
	public String getTestAnswer1() {

		return testAnswer1;

	}

	/**
	 * <dd>メソッド名：テスト1設定メソッド
	 * <dd>メソッド説明：テスト1を設定します。
	 *
	 * @param testAnswer1
	 *            テスト1
	 */
	public void setTestAnswer1(String testAnswer1) {

		this.testAnswer1 = testAnswer1;

	}

	/**
	 * <dd>メソッド名：テスト2取得メソッド
	 * <dd>メソッド説明：テスト2を取得します。
	 *
	 * @return testAnswer2 テスト2
	 */
	public String getTestAnswer2() {

		return testAnswer2;

	}

	/**
	 * <dd>メソッド名：テスト2設定メソッド
	 * <dd>メソッド説明：テスト2を設定します。
	 *
	 * @param testAnswer2
	 *            テスト2
	 */
	public void setTestAnswer2(String testAnswer2) {

		this.testAnswer2 = testAnswer2;

	}

	/**
	 * <dd>メソッド名：テスト3取得メソッド
	 * <dd>メソッド説明：テスト3を取得します。
	 *
	 * @return testAnswer3 テスト3
	 */
	public String getTestAnswer3() {

		return testAnswer3;

	}

	/**
	 * <dd>メソッド名：テスト3設定メソッド
	 * <dd>メソッド説明：テスト3を設定します。
	 *
	 * @param testAnswer3
	 *            テスト3
	 */
	public void setTestAnswer3(String testAnswer3) {

		this.testAnswer3 = testAnswer3;

	}

	/**
	 * <dd>メソッド名：テスト4取得メソッド
	 * <dd>メソッド説明：テスト4を取得します。
	 *
	 * @return testAnswer4 テスト4
	 */
	public String getTestAnswer4() {

		return testAnswer4;

	}

	/**
	 * <dd>メソッド名：テスト4設定メソッド
	 * <dd>メソッド説明：テスト4を設定します。
	 *
	 * @param testAnswer4
	 *            テスト4
	 */
	public void setTestAnswer4(String testAnswer4) {

		this.testAnswer4 = testAnswer4;

	}

	/**
	 * <dd>メソッド名：テスト5取得メソッド
	 * <dd>メソッド説明：テスト5を取得します。
	 *
	 * @return testAnswer5 テスト5
	 */
	public String getTestAnswer5() {

		return testAnswer5;

	}

	/**
	 * <dd>メソッド名：テスト5設定メソッド
	 * <dd>メソッド説明：テスト5を設定します。
	 *
	 * @param testAnswer5
	 *            テスト5
	 */
	public void setTestAnswer5(String testAnswer5) {

		this.testAnswer5 = testAnswer5;

	}

}
