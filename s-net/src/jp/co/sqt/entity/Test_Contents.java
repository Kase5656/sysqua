/*
 *Test_Contents.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (受講生管理業務)
 *クラス一覧：
 * NO クラス名 概要
 * 1 Test_Contents データベースから取得した情報を保持するクラスです。
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
public class Test_Contents implements Serializable {

	/** 直列化ID */
	private static final long serialVersionUID = 1L;

	/** テストNo */
	private int testNo;

	/** 解答No */
	private int ansNo;

	/** テストタイトル */
	private String testTitle;

	/** テスト日付 */
	private String testDate;

	/** テスト1 */
	private String test1;

	/** テスト2 */
	private String test2;

	/** テスト3 */
	private String test3;

	/** テスト4 */
	private String test4;

	/** テスト5 */
	private String test5;

	/**
	 * <dd>メソッド名：Testデフォルトコンストラクタメソッド
	 * <dd>メソッド説明：インスタンスの生成を可能にします。
	 */
	public Test_Contents() {
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
	public Test_Contents(int testNo, int ansNo, String testDate, String testTitle, String test1,
			String test2, String test3, String test4, String test5) {

		super();

		this.testNo = testNo;

		this.ansNo = ansNo;

		this.testDate = testDate;

		this.testTitle = testTitle;

		this.test1 = test1;

		this.test2 = test2;

		this.test3 = test3;

		this.test4 = test4;

		this.test5 = test5;

	}

	/**
	 * <dd>メソッド名：No取得メソッド
	 * <dd>メソッド説明：Noを取得します。
	 *
	 * @return testNo No
	 */
	public int getTestNo() {

		return testNo;

	}

	/**
	 * <dd>メソッド名：No設定メソッド
	 * <dd>メソッド説明：Noを設定します。
	 *
	 * @param testNo
	 *            No
	 */
	public void setTestNo(int testNo) {

		this.testNo = testNo;

	}

	/**
	 * <dd>メソッド名：解答No取得メソッド
	 * <dd>メソッド説明：解答Noを取得します。
	 *
	 * @return ansNo 解答No
	 */
	public int getAnsNo() {

		return ansNo;

	}

	/**
	 * <dd>メソッド名：解答No設定メソッド
	 * <dd>メソッド説明：解答Noを設定します。
	 *
	 * @param ansNo
	 *            解答No
	 */
	public void setAnsNo(int ansNo) {

		this.ansNo = ansNo;

	}

	/**
	 * <dd>メソッド名：テスト日付取得メソッド
	 * <dd>メソッド説明：テスト日付を取得します。
	 *
	 * @return testDate テスト日付
	 */
	public String getTestDate() {

		return testDate;

	}

	/**
	 * <dd>メソッド名：テスト日付設定メソッド
	 * <dd>メソッド説明：テスト日付を設定します。
	 *
	 * @param testDate
	 *            テストタイトル
	 */
	public void setTestDate(String testDate) {

		this.testDate = testDate.replaceAll("/", "-");

	}

	/**
	 * <dd>メソッド名：テストタイトル取得メソッド
	 * <dd>メソッド説明：テストタイトルを取得します。
	 *
	 * @return testTitle テストタイトル
	 */
	public String getTestTitle() {

		return testTitle;

	}

	/**
	 * <dd>メソッド名：テストタイトル設定メソッド
	 * <dd>メソッド説明：テストタイトルを設定します。
	 *
	 * @param testTitle
	 *            テストタイトル
	 */
	public void setTestTitle(String testTitle) {

		this.testTitle = testTitle;

	}

	/**
	 * <dd>メソッド名：テスト1内容取得メソッド
	 * <dd>メソッド説明：テスト1内容を取得します。
	 *
	 * @return test1 テスト1内容
	 */
	public String getTest1() {

		return test1;

	}

	/**
	 * <dd>メソッド名：テスト1内容設定メソッド
	 * <dd>メソッド説明：テスト1内容を設定します。
	 *
	 * @param test1
	 *            テスト1内容
	 */
	public void setTest1(String test1) {

		this.test1 = test1;

	}

	/**
	 * <dd>メソッド名：テスト2内容取得メソッド
	 * <dd>メソッド説明：テスト2内容を取得します。
	 *
	 * @return test2 テスト2内容
	 */
	public String getTest2() {

		return test2;
	}

	/**
	 * <dd>メソッド名：テスト2内容設定メソッド
	 * <dd>メソッド説明：テスト2内容を設定します。
	 *
	 * @param test2
	 *            テスト2内容
	 */
	public void setTest2(String test2) {

		this.test2 = test2;

	}

	/**
	 * <dd>メソッド名：テスト3内容取得メソッド
	 * <dd>メソッド説明：テスト3内容を取得します。
	 *
	 * @return test3 テスト3内容
	 */
	public String getTest3() {

		return test3;

	}

	/**
	 * <dd>メソッド名：テスト3内容設定メソッド
	 * <dd>メソッド説明：テスト3内容を設定します。
	 *
	 * @param test3
	 *            テスト3内容
	 */
	public void setTest3(String test3) {

		this.test3 = test3;

	}

	/**
	 * <dd>メソッド名：テスト4内容取得メソッド
	 * <dd>メソッド説明：テスト4内容を取得します。
	 *
	 * @return test1 テスト4内容
	 */
	public String getTest4() {

		return test4;

	}

	/**
	 * <dd>メソッド名：テスト4内容設定メソッド
	 * <dd>メソッド説明：テスト4内容を設定します。
	 *
	 * @param test4
	 *            テスト4内容
	 */
	public void setTest4(String test4) {

		this.test4 = test4;

	}

	/**
	 * <dd>メソッド名：テスト5内容取得メソッド
	 * <dd>メソッド説明：テスト5内容を取得します。
	 *
	 * @return test5 テスト5内容
	 */
	public String getTest5() {

		return test5;

	}

	/**
	 * <dd>メソッド名：テスト5内容設定メソッド
	 * <dd>メソッド説明：テスト5内容を設定します。
	 *
	 * @param test5
	 *            テスト5内容
	 */
	public void setTest5(String test5) {

		this.test5 = test5;

	}

}
