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
 * <dd>クラス名：アンケート回答内容エンティティクラス
 * <dd>クラス説明：アンケートID、回答内容を扱います。
 *
 * @version 1.00 2019/10/14
 * @author SQT）長谷川
 */
public class Question implements Serializable {

	/** 直列化ID */
	private static final long serialVersionUID = 1L;

	private int no;

	private int accountNo;

	private String date;

	private int ans1_1_1;

	private String ans1_1_2;

	private int ans1_2_1;

	private String ans1_2_2;

	private int ans1_3_1;

	private int ans1_3_2;

	private int ans2_1_1;

	private int ans2_1_2;

	private int ans2_1_3;

	private int ans2_1_4;

	private int ans2_1_5;

	private String ans2_1_6;

	private int ans2_2_1;

	private int ans2_2_2;

	private int ans2_2_3;

	private int ans2_2_4;

	private int ans2_2_5;

	private String ans2_2_6;

	private int ans2_3_1;

	private int ans2_3_2;

	private int ans2_3_3;

	private int ans2_3_4;

	private int ans2_3_5;

	private String ans2_3_6;

	private int ans2_4_1;

	private int ans2_4_2;

	private int ans2_4_3;

	private int ans2_4_4;

	private int ans2_4_5;

	private String ans2_4_6;

	private int ans2_5_1;

	private int ans2_5_2;

	private int ans2_5_3;

	private int ans2_5_4;

	private int ans2_5_5;

	private String ans2_5_6;

	private int ans2_6_1;

	private int ans2_6_2;

	private int ans2_6_3;

	private int ans2_6_4;

	private int ans2_6_5;

	private String ans2_6_6;

	private String ans3_1;

	private String ans3_2;

/**
 * <dd>メソッド名：Testデフォルトコンストラクタメソッド
 * <dd>メソッド説明：インスタンスの生成を可能にします。
 */
	public Question() {

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
	public Question(int no, int accountNo, String date, int ans1_1_1, String ans1_1_2, int ans1_2_1, String ans1_2_2, int ans1_3_1, int ans1_3_2, int ans2_1_1, int ans2_1_2, int ans2_1_3, int ans2_1_4, int ans2_1_5, String ans2_1_6, int ans2_2_1, int ans2_2_2, int ans2_2_3, int ans2_2_4, int ans2_2_5, String ans2_2_6, int ans2_3_1, int ans2_3_2, int ans2_3_3, int ans2_3_4, int ans2_3_5, String ans2_3_6, int ans2_4_1, int ans2_4_2, int ans2_4_3, int ans2_4_4, int ans2_4_5, String ans2_4_6, int ans2_5_1, int ans2_5_2, int ans2_5_3, int ans2_5_4, int ans2_5_5, String ans2_5_6, int ans2_6_1, int ans2_6_2, int ans2_6_3, int ans2_6_4, int ans2_6_5, String ans2_6_6, String ans3_1, String ans3_2) {

		super();

		this.no = no;

		this.accountNo = accountNo;

		this.date = date;

		this.ans1_1_1 = ans1_1_1;

		this.ans1_1_2 = ans1_1_2;

		this.ans1_2_1 = ans1_2_1;

		this.ans1_2_2 = ans1_2_2;

		this.ans1_3_1 = ans1_3_1;

		this.ans1_3_2 = ans1_3_2;

		this.ans2_1_1 = ans2_1_1;

		this.ans2_1_2 = ans2_1_2;

		this.ans2_1_3 = ans2_1_3;

		this.ans2_1_4 = ans2_1_4;

		this.ans2_1_5 = ans2_1_5;

		this.ans2_1_6 = ans2_1_6;

		this.ans2_2_1 = ans2_2_1;

		this.ans2_2_2 = ans2_2_2;

		this.ans2_2_3 = ans2_2_3;

		this.ans2_2_4 = ans2_2_4;

		this.ans2_2_5 = ans2_2_5;

		this.ans2_2_6 = ans2_2_6;

		this.ans2_3_1 = ans2_3_1;

		this.ans2_3_2 = ans2_3_2;

		this.ans2_3_3 = ans2_3_3;

		this.ans2_3_4 = ans2_3_4;

		this.ans2_3_5 = ans2_3_5;

		this.ans2_3_6 = ans2_3_6;

		this.ans2_4_1 = ans2_4_1;

		this.ans2_4_2 = ans2_4_2;

		this.ans2_4_3 = ans2_4_3;

		this.ans2_4_4 = ans2_4_4;

		this.ans2_4_5 = ans2_4_5;

		this.ans2_4_6 = ans2_4_6;

		this.ans2_5_1 = ans2_5_1;

		this.ans2_5_2 = ans2_5_2;

		this.ans2_5_3 = ans2_5_3;

		this.ans2_5_4 = ans2_5_4;

		this.ans2_5_5 = ans2_5_5;

		this.ans2_5_6 = ans2_5_6;

		this.ans2_6_1 = ans2_6_1;

		this.ans2_6_2 = ans2_6_2;

		this.ans2_6_3 = ans2_6_3;

		this.ans2_6_4 = ans2_6_4;

		this.ans2_6_5 = ans2_6_5;

		this.ans2_6_6 = ans2_6_6;

		this.ans3_1 = ans3_1;

		this.ans3_2 = ans3_2;

	}

	public int getNo() {

		return no;

	}

	public void setNo(int no) {

		this.no = no;

	}

	public int getAccountNo() {

		return accountNo;

	}

	public void setAccountNo(int accountNo) {

		this.accountNo = accountNo;

	}

	public String getDate() {

		return date;

	}

	public void setDate(String date) {

		this.date = date;

	}

	public int getAns1_1_1() {

		return ans1_1_1;

	}

	public void setAns1_1_1(int ans1_1_1) {

		this.ans1_1_1 = ans1_1_1;

	}

	public 	String getAns1_1_2() {

		return ans1_1_2;

	}

	public void setAns1_1_2(String ans1_1_2) {

		this.ans1_1_2 = ans1_1_2;

	}

	public int getAns1_2_1() {

		return ans1_2_1;

	}

	public void setAns1_2_1(int ans1_2_1) {

		this.ans1_2_1 = ans1_2_1;
	}

	public String getAns1_2_2() {

		return ans1_2_2;

	}

	public void setAns1_2_2(String ans1_2_2) {

		this.ans1_2_2 = ans1_2_2;

	}

	public int getAns1_3_1() {

		return ans1_3_1;

	}

	public void setAns1_3_1(int ans1_3_1) {

		this.ans1_3_1 = ans1_3_1;
	}

	public int getAns1_3_2() {

		return ans1_3_2;

	}

	public void setAns1_3_2(int ans1_3_2) {

		this.ans1_3_2 = ans1_3_2;

	}

	public int getAns2_1_1() {

		return ans2_1_1;

	}

	public void setAns2_1_1(int ans2_1_1) {

		this.ans2_1_1 = ans2_1_1;

	}

	public int getAns2_1_2() {

		return ans2_1_2;

	}

	public void setAns2_1_2(int ans2_1_2) {

		this.ans2_1_2 = ans2_1_2;

	}

	public int getAns2_1_3() {

		return ans2_1_3;

	}

	public void setAns2_1_3(int ans2_1_3) {

		this.ans2_1_3 = ans2_1_3;

	}

	public int getAns2_1_4() {

		return ans2_1_4;

	}

	public void setAns2_1_4(int ans2_1_4) {

		this.ans2_1_4 = ans2_1_4;

	}

	public int getAns2_1_5() {

		return ans2_1_5;

	}

	public void setAns2_1_5(int ans2_1_5) {

		this.ans2_1_5 = ans2_1_5;

	}

	public String getAns2_1_6() {

		return ans2_1_6;

	}

	public void setAns2_1_6(String ans2_1_6) {

		this.ans2_1_6 = ans2_1_6;

	}

	public int getAns2_2_1() {

		return ans2_2_1;

	}

	public void setAns2_2_1(int ans2_2_1) {

		this.ans2_2_1 = ans2_2_1;

	}

	public int getAns2_2_2() {

		return ans2_2_2;

	}

	public void setAns2_2_2(int ans2_2_2) {

		this.ans2_2_2 = ans2_2_2;

	}

	public int getAns2_2_3() {

		return ans2_2_3;

	}

	public void setAns2_2_3(int ans2_2_3) {

		this.ans2_2_3 = ans2_2_3;

	}

	public int getAns2_2_4() {

		return ans2_2_4;

	}

	public void setAns2_2_4(int ans2_2_4) {

		this.ans2_2_4 = ans2_2_4;

	}

	public int getAns2_2_5() {

		return ans2_2_5;

	}

	public void setAns2_2_5(int ans2_2_5) {

		this.ans2_2_5 = ans2_2_5;

	}

	public String getAns2_2_6() {

		return ans2_2_6;

	}

	public void setAns2_2_6(String ans2_2_6) {

		this.ans2_2_6 = ans2_2_6;

	}

	public int getAns2_3_1() {

		return ans2_3_1;

	}

	public void setAns2_3_1(int ans2_3_1) {

		this.ans2_3_1 = ans2_3_1;

	}

	public int getAns2_3_2() {

		return ans2_3_2;

	}

	public void setAns2_3_2(int ans2_3_2) {

		this.ans2_3_2 = ans2_3_2;

	}

	public int getAns2_3_3() {

		return ans2_3_3;

	}

	public void setAns2_3_3(int ans2_3_3) {

		this.ans2_3_3 = ans2_3_3;

	}

	public int getAns2_3_4() {

		return ans2_3_4;

	}

	public void setAns2_3_4(int ans2_3_4) {

		this.ans2_3_4 = ans2_3_4;

	}

	public int getAns2_3_5() {

		return ans2_3_5;

	}

	public void setAns2_3_5(int ans2_3_5) {

		this.ans2_3_5 = ans2_3_5;

	}

	public String getAns2_3_6() {

		return ans2_3_6;

	}

	public void setAns2_3_6(String ans2_3_6) {

		this.ans2_3_6 = ans2_3_6;

	}

	public int getAns2_4_1() {

		return ans2_4_1;

	}

	public void setAns2_4_1(int ans2_4_1) {

		this.ans2_4_1 = ans2_4_1;

	}

	public int getAns2_4_2() {

		return ans2_4_2;

	}

	public void setAns2_4_2(int ans2_4_2) {

		this.ans2_4_2 = ans2_4_2;

	}

	public int getAns2_4_3() {

		return ans2_4_3;

	}

	public void setAns2_4_3(int ans2_4_3) {

		this.ans2_4_3 = ans2_4_3;

	}

	public int getAns2_4_4() {

		return ans2_4_4;

	}

	public void setAns2_4_4(int ans2_4_4) {

		this.ans2_4_4 = ans2_4_4;

	}

	public int getAns2_4_5() {

		return ans2_4_5;

	}

	public void setAns2_4_5(int ans2_4_5) {

		this.ans2_4_5 = ans2_4_5;

	}

	public String getAns2_4_6() {

		return ans2_4_6;

	}

	public void setAns2_4_6(String ans2_4_6) {

		this.ans2_4_6 = ans2_4_6;

	}

	public int getAns2_5_1() {

		return ans2_5_1;

	}

	public void setAns2_5_1(int ans2_5_1) {

		this.ans2_5_1 = ans2_5_1;

	}

	public int getAns2_5_2() {

		return ans2_5_2;

	}

	public void setAns2_5_2(int ans2_5_2) {

		this.ans2_5_2 = ans2_5_2;

	}

	public int getAns2_5_3() {

		return ans2_5_3;

	}

	public void setAns2_5_3(int ans2_5_3) {

		this.ans2_5_3 = ans2_5_3;

	}

	public int getAns2_5_4() {

		return ans2_5_4;

	}

	public void setAns2_5_4(int ans2_5_4) {

		this.ans2_5_4 = ans2_5_4;

	}

	public int getAns2_5_5() {

		return ans2_5_5;

	}

	public void setAns2_5_5(int ans2_5_5) {

		this.ans2_5_5 = ans2_5_5;

	}

	public String getAns2_5_6() {

		return ans2_5_6;

	}

	public void setAns2_5_6(String ans2_5_6) {

		this.ans2_5_6 = ans2_5_6;

	}

	public int getAns2_6_1() {

		return ans2_6_1;

	}

	public void setAns2_6_1(int ans2_6_1) {

		this.ans2_6_1 = ans2_6_1;

	}

	public int getAns2_6_2() {

		return ans2_6_2;

	}

	public void setAns2_6_2(int ans2_6_2) {

		this.ans2_6_2 = ans2_6_2;

	}

	public int getAns2_6_3() {

		return ans2_6_3;

	}

	public void setAns2_6_3(int ans2_6_3) {

		this.ans2_6_3 = ans2_6_3;

	}

	public int getAns2_6_4() {

		return ans2_6_4;

	}

	public void setAns2_6_4(int ans2_6_4) {

		this.ans2_6_4 = ans2_6_4;

	}

	public int getAns2_6_5() {

		return ans2_6_5;

	}

	public void setAns2_6_5(int ans2_6_5) {

		this.ans2_6_5 = ans2_6_5;

	}

	public String getAns2_6_6() {

		return ans2_6_6;

	}

	public void setAns2_6_6(String ans2_6_6) {

		this.ans2_6_6 = ans2_6_6;

	}

	public String getAns3_1() {

		return ans3_1;

	}

	public void setAns3_1(String ans3_1) {

		this.ans3_1 = ans3_1;

	}

	public 	String getAns3_2() {

		return ans3_2;

	}

	public void setAns3_2(String ans3_2) {

		this.ans3_2 = ans3_2;

	}

}
