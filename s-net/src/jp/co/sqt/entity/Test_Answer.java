/*
 *Test_Answer.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (受講生管理業務)
 *クラス一覧：
 * NO クラス名 概要
 * 1 Test_Answer データベースから取得した情報を保持するクラスです。
 *履歴：
 * NO 日付 Ver 更新者 内容
 * 1 2017/00/00 V1L1.0 SQT）加瀬 初版。
 */

package jp.co.sqt.entity;

import java.io.Serializable;

/**
 * <dd>クラス名：解答情報エンティティクラス
 * <dd>クラス説明：解答ID、解答名を扱います。 データベースから取得した情報を保持します。
 *
 * @version 1.00 2017/00/00
 * @author SQT）加瀬
 */
public class Test_Answer implements Serializable {

	/** 直列化ID */
	private static final long serialVersionUID = 1L;

	/** 解答AnsNo */
	private int ansNo;

	/** 解答1回答 */
	private String ans1;

	/** 解答2回答 */
	private String ans2;

	/** 解答3回答 */
	private String ans3;

	/** 解答4回答 */
	private String ans4;

	/** 解答5回答 */
	private String ans5;

	/**
	 * <dd>メソッド名：Testデフォルトコンストラクタメソッド
	 * <dd>メソッド説明：インスタンスの生成を可能にします。
	 */
	public Test_Answer() {
	}

	/**
	 * <dd>メソッド名：Testコンストラクタメソッド
	 * <dd>メソッド説明：解答情報を初期化します。
	 *
	 * @param
	 *
	 * @param
	 *
	 */
	public Test_Answer(String ans1, String ans2, String ans3, String ans4, String ans5) {

		super();

		this.ans1 = ans1;

		this.ans2 = ans2;

		this.ans3 = ans3;

		this.ans4 = ans4;

		this.ans5 = ans5;

	}

	/**
	 * <dd>メソッド名：AnsNo取得メソッド
	 * <dd>メソッド説明：AnsNoを取得します。
	 *
	 * @return ansNo AnsNo
	 */
	public int getAnswerNo() {

		return ansNo;

	}

	/**
	 * <dd>メソッド名：AnsNo設定メソッド
	 * <dd>メソッド説明：AnsNoを設定します。
	 *
	 * @param ansNo AnsNo
	 *
	 */
	public void setAnswerNo(int ansNo) {

		this.ansNo = ansNo;

	}

	/**
	 * <dd>メソッド名：解答1取得メソッド
	 * <dd>メソッド説明：解答1を取得します。
	 *
	 * @return ans1 解答1
	 */
	public String getAnswer1() {

		return ans1;

	}

	/**
	 * <dd>メソッド名：解答1設定メソッド
	 * <dd>メソッド説明：解答1を設定します。
	 *
	 * @param ans1
	 *            解答1
	 */
	public void setAnswer1(String ans1) {

		this.ans1 = ans1;

	}

	/**
	 * <dd>メソッド名：解答2取得メソッド
	 * <dd>メソッド説明：解答2を取得します。
	 *
	 * @return ans2 解答2
	 */
	public String getAnswer2() {

		return ans2;

	}

	/**
	 * <dd>メソッド名：解答2設定メソッド
	 * <dd>メソッド説明：解答2を設定します。
	 *
	 * @param ans2
	 *            解答2
	 */
	public void setAnswer2(String ans2) {

		this.ans2 = ans2;

	}

	/**
	 * <dd>メソッド名：解答3取得メソッド
	 * <dd>メソッド説明：解答3を取得します。
	 *
	 * @return ans3 解答3
	 */
	public String getAnswer3() {

		return ans3;

	}

	/**
	 * <dd>メソッド名：解答3設定メソッド
	 * <dd>メソッド説明：解答3を設定します。
	 *
	 * @param ans3
	 *            解答3
	 */
	public void setAnswer3(String ans3) {

		this.ans3 = ans3;

	}

	/**
	 * <dd>メソッド名：解答4取得メソッド
	 * <dd>メソッド説明：解答4を取得します。
	 *
	 * @return ans4 解答4
	 */
	public String getAnswer4() {

		return ans4;

	}

	/**
	 * <dd>メソッド名：解答4設定メソッド
	 * <dd>メソッド説明：解答4を設定します。
	 *
	 * @param ans4
	 *            解答4
	 */
	public void setAnswer4(String ans4) {

		this.ans4 = ans4;

	}

	/**
	 * <dd>メソッド名：解答5取得メソッド
	 * <dd>メソッド説明：解答5を取得します。
	 *
	 * @return ans5 解答5
	 */
	public String getAnswer5() {

		return ans5;

	}

	/**
	 * <dd>メソッド名：解答5設定メソッド
	 * <dd>メソッド説明：解答5を設定します。
	 *
	 * @param ans5
	 *            解答5
	 */
	public void setAnswer5(String ans5) {

		this.ans5 = ans5;

	}

}
