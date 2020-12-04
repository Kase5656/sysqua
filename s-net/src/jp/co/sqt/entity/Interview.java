/*
 *Interview.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (社員管理業務)
 *クラス一覧：
 * NO クラス名 概要
 * 1 Interview データベースから取得した情報を保持するクラスです。
 *履歴：
 * NO 日付 Ver 更新者 内容
 * 1 2017/00/00 V1L1.0 SQT）加瀬 初版。
 */

package jp.co.sqt.entity;

import java.io.Serializable;

/**
 * <dd>クラス名：面談情報エンティティクラス
 * <dd>クラス説明：面談No、面談名を扱います。
 * データベースから取得した情報を保持します。
 *
 * @version 1.00 2017/00/00
 * @author SQT）加瀬
 */
public class Interview implements Serializable {

	/**　直列化ID　*/
	private static final long serialVersionUID = 1L;

	/**　面談No　*/
	private int interviewNo;

	/**　アカウントNo　*/
	private int accountNo;

	/**　企業No　*/
	private int corporationNo;

	/**　面談者氏名　*/
	private String educationName;

	/**　面談者情報　*/
	private String accountInformation;

	/**　面談日1　*/
	private String interviewDate1;

	/**　面談相談内容1（受講生）　*/
	private String interviewEduContents1;

	/**　面談相談内容1（研修担当）　*/
	private String interviewTraContents1;

	/**　面談内容1　*/
	private String interviewContents1;

	/**　面談日2　*/
	private String interviewDate2;

	/**　面談相談内容2（受講生）　*/
	private String interviewEduContents2;

	/**　面談相談内容2（研修担当）　*/
	private String interviewTraContents2;

	/**　面談内容2　*/
	private String interviewContents2;

	/**　面談日3　*/
	private String interviewDate3;

	/**　面談相談内容3（受講生）　*/
	private String interviewEduContents3;

	/**　面談相談内容3（研修担当）　*/
	private String interviewTraContents3;

	/**　面談内容3　*/
	private String interviewContents3;

	/**
	 * <dd>メソッド名：Dutiesデフォルトコンストラクタメソッド
	 * <dd>メソッド説明：インスタンスの生成を可能にします。
	 */
	public Interview() {
	}

	/**
	 * <dd>メソッド名：Interviewコンストラクタメソッド
	 * <dd>メソッド説明：面談情報を初期化します。
	 * @param interviewNo 面談No
	 * @param accountNo アカウントNo
	 * @param corporationNo 企業No
	 * @param educationName 面談者氏名
	 * @param accountInformation 面談者情報
	 * @param interviewDate1 面談日1
	 * @param interviewEduContents1 面談相談内容1（受講生）
	 * @param interviewTraContents1 面談相談内容1（研修担当）
	 * @param interviewContents1 面談内容1
	 * @param interviewDate2 面談日2
	 * @param interviewEduContents2 面談相談内容2（受講生）
	 * @param interviewTraContents2 面談相談内容2（研修担当）
	 * @param interviewContents2 面談内容2
	 * @param interviewDate3 面談日3
	 * @param interviewEduContents3 面談相談内容3（受講生）
	 * @param interviewTraContents3 面談相談内容3（研修担当）
	 * @param interviewContents3 面談内容3
	 */
	public Interview(int interviewNo, int accountNo, int corporationNo, String educationName, String accountInformation,
			String interviewDate1, String interviewEduContents1, String interviewTraContents1,
			String interviewContents1, String interviewDate2, String interviewEduContents2,
			String interviewTraContents2, String interviewContents2, String interviewDate3,
			String interviewEduContents3, String interviewTraContents3, String interviewContents3) {

		super();

		this.interviewNo = interviewNo;

		this.accountNo = accountNo;

		this.corporationNo = corporationNo;

		this.educationName = educationName;

		this.accountInformation = accountInformation;

		this.interviewDate1 = interviewDate1;

		this.interviewEduContents1 = interviewEduContents1;

		this.interviewTraContents1 = interviewTraContents1;

		this.interviewContents1 = interviewContents1;

		this.interviewDate2 = interviewDate2;

		this.interviewEduContents2 = interviewEduContents2;

		this.interviewTraContents2 = interviewTraContents2;

		this.interviewContents2 = interviewContents2;

		this.interviewDate3 = interviewDate3;

		this.interviewEduContents3 = interviewEduContents3;

		this.interviewTraContents3 = interviewTraContents3;

		this.interviewContents3 = interviewContents3;

	}

	/**
	 * <dd>メソッド名：面談No取得メソッド
	 * <dd>メソッド説明：面談Noを取得します。
	 * @return interviewNo 面談No
	 */
	public int getInterviewNo() {

		return interviewNo;

	}

	/**
	 * <dd>メソッド名：面談No設定メソッド
	 * <dd>メソッド説明：面談Noを設定します。
	 * @param interviewNo 面談No
	 */
	public void setInterviewNo(int interviewNo) {

		this.interviewNo = interviewNo;

	}

	/**
	 * <dd>メソッド名：アカウントNo取得メソッド
	 * <dd>メソッド説明：アカウントNoを取得します。
	 * @return accountNo アカウントNo
	 */
	public int getAccountNo() {

		return accountNo;

	}

	/**
	 * <dd>メソッド名：アカウントNo設定メソッド
	 * <dd>メソッド説明：アカウントNoを設定します。
	 * @param accountNo アカウントNo
	 */
	public void setAccountNo(int accountNo) {

		this.accountNo = accountNo;

	}

	/**
	 * <dd>メソッド名：企業No取得メソッド
	 * <dd>メソッド説明：企業Noを取得します。
	 * @return corporationNo 企業No
	 */
	public int getCorporationNo() {

		return corporationNo;

	}

	/**
	 * <dd>メソッド名：企業No設定メソッド
	 * <dd>メソッド説明：企業Noを設定します。
	 * @param corporationNo 企業No
	 */
	public void setCorporationNo(int corporationNo) {

		this.corporationNo = corporationNo;

	}

	/**
	 * <dd>メソッド名：面談者氏名取得メソッド
	 * <dd>メソッド説明：面談者氏名を取得します。
	 * @return educationName 面談者氏名
	 */
	public String getEducationName() {

		return educationName;

	}

	/**
	 * <dd>メソッド名：面談者氏名設定メソッド
	 * <dd>メソッド説明：面談者氏名を設定します。
	 * @param educationName 面談者氏名
	 */
	public void setEducationName(String educationName) {

		this.educationName = educationName;

	}

	/**
	 * <dd>メソッド名：面談者情報取得メソッド
	 * <dd>メソッド説明：面談者情報を取得します。
	 * @return accountInformation 面談者情報
	 */
	public String getAccountInformation() {

		return accountInformation;

	}

	/**
	 * <dd>メソッド名：面談者情報設定メソッド
	 * <dd>メソッド説明：面談者情報を設定します。
	 * @param accountInformation 面談者情報
	 */
	public void setAccountInformation(String accountInformation) {

		this.accountInformation = accountInformation;

	}

	/**
	 * <dd>メソッド名：面談日1取得メソッド
	 * <dd>メソッド説明：面談日1を取得します。
	 * @return interviewDate1 面談日1
	 */
	public String getInterviewDate1() {

		return interviewDate1;

	}

	/**
	 * <dd>メソッド名：面談日1設定メソッド
	 * <dd>メソッド説明：面談日1を設定します。
	 * @param interviewDate1 面談日1
	 */
	public void setInterviewDate1(String interviewDate1) {

		this.interviewDate1 = interviewDate1;

	}

	/**
	 * <dd>メソッド名：面談相談内容1（受講生）取得メソッド
	 * <dd>メソッド説明：面談相談内容1（受講生）を取得します。
	 * @return interviewEduContents1 面談相談内容1（受講生）
	 */
	public String getInterviewEduContents1() {

		return interviewEduContents1;

	}

	/**
	 * <dd>メソッド名：面談相談内容1（受講生）設定メソッド
	 * <dd>メソッド説明：面談相談内容1（受講生）を設定します。
	 * @param interviewEduContents1 面談相談内容1（受講生）
	 */
	public void setInterviewEduContents1(String interviewEduContents1) {

		this.interviewEduContents1 = interviewEduContents1;

	}

	/**
	 * <dd>メソッド名：面談相談内容1（研修担当）取得メソッド
	 * <dd>メソッド説明：面談相談内容1（研修担当）を取得します。
	 * @return interviewTraContents1 面談相談内容1（研修担当）
	 */
	public String getInterviewTraContents1() {

		return interviewTraContents1;

	}

	/**
	 * <dd>メソッド名：面談相談内容1（研修担当）設定メソッド
	 * <dd>メソッド説明：面談相談内容1（研修担当）を設定します。
	 * @param interviewTraContents1 面談相談内容1（研修担当）
	 */
	public void setInterviewTraContents1(String interviewTraContents1) {

		this.interviewTraContents1 = interviewTraContents1;

	}

	/**
	 * <dd>メソッド名：面談内容1取得メソッド
	 * <dd>メソッド説明：面談内容1を取得します。
	 * @return interviewContents1 面談内容1
	 */
	public String getInterviewContents1() {

		return interviewContents1;

	}

	/**
	 * <dd>メソッド名：面談内容1設定メソッド
	 * <dd>メソッド説明：面談内容1を設定します。
	 * @param interviewContents1 面談内容1
	 */
	public void setInterviewContents1(String interviewContents1) {

		this.interviewContents1 = interviewContents1;

	}

	/**
	 * <dd>メソッド名：面談日2取得メソッド
	 * <dd>メソッド説明：面談日2を取得します。
	 * @return interviewDate2 面談日2
	 */
	public String getInterviewDate2() {

		return interviewDate2;

	}

	/**
	 * <dd>メソッド名：面談日2設定メソッド
	 * <dd>メソッド説明：面談日2を設定します。
	 * @param interviewDate2 面談日2
	 */
	public void setInterviewDate2(String interviewDate2) {

		this.interviewDate2 = interviewDate2;

	}

	/**
	 * <dd>メソッド名：面談相談内容2（受講生）取得メソッド
	 * <dd>メソッド説明：面談相談内容2（受講生）を取得します。
	 * @return interviewEduContents2 面談相談内容2（受講生）
	 */
	public String getInterviewEduContents2() {

		return interviewEduContents2;

	}

	/**
	 * <dd>メソッド名：面談相談内容2（受講生）設定メソッド
	 * <dd>メソッド説明：面談相談内容2（受講生）を設定します。
	 * @param interviewEduContents2 面談相談内容2（受講生）
	 */
	public void setInterviewEduContents2(String interviewEduContents2) {

		this.interviewEduContents2 = interviewEduContents2;

	}

	/**
	 * <dd>メソッド名：面談相談内容2（研修担当）取得メソッド
	 * <dd>メソッド説明：面談相談内容2（研修担当）を取得します。
	 * @return interviewTraContents2 面談相談内容2（研修担当）
	 */
	public String getInterviewTraContents2() {

		return interviewTraContents2;

	}

	/**
	 * <dd>メソッド名：面談相談内容2（研修担当）設定メソッド
	 * <dd>メソッド説明：面談相談内容2（研修担当）を設定します。
	 * @param interviewTraContents2 面談相談内容2（研修担当）
	 */
	public void setInterviewTraContents2(String interviewTraContents2) {

		this.interviewTraContents2 = interviewTraContents2;

	}

	/**
	 * <dd>メソッド名：面談内容2取得メソッド
	 * <dd>メソッド説明：面談内容2を取得します。
	 * @return interviewContents2 面談内容2
	 */
	public String getInterviewContents2() {

		return interviewContents2;

	}

	/**
	 * <dd>メソッド名：面談内容2設定メソッド
	 * <dd>メソッド説明：面談内容2を設定します。
	 * @param interviewContents2 面談内容2
	 */
	public void setInterviewContents2(String interviewContents2) {

		this.interviewContents2 = interviewContents2;

	}

	/**
	 * <dd>メソッド名：面談日3取得メソッド
	 * <dd>メソッド説明：面談日3を取得します。
	 * @return interviewDate3 面談日3
	 */
	public String getInterviewDate3() {

		return interviewDate3;

	}

	/**
	 * <dd>メソッド名：面談日3設定メソッド
	 * <dd>メソッド説明：面談日3を設定します。
	 * @param interviewDate3 面談日3
	 */
	public void setInterviewDate3(String interviewDate3) {

		this.interviewDate3 = interviewDate3;

	}

	/**
	 * <dd>メソッド名：面談相談内容3（受講生）取得メソッド
	 * <dd>メソッド説明：面談相談内容3（受講生）を取得します。
	 * @return interviewEduContents3 面談相談内容3（受講生）
	 */
	public String getInterviewEduContents3() {

		return interviewEduContents3;

	}

	/**
	 * <dd>メソッド名：面談相談内容3（受講生）設定メソッド
	 * <dd>メソッド説明：面談相談内容3（受講生）を設定します。
	 * @param interviewEduContents3 面談相談内容3（受講生）
	 */
	public void setInterviewEduContents3(String interviewEduContents3) {

		this.interviewEduContents3 = interviewEduContents3;

	}

	/**
	 * <dd>メソッド名：面談相談内容3（研修担当）取得メソッド
	 * <dd>メソッド説明：面談相談内容3（研修担当）を取得します。
	 * @return interviewTraContents3 面談相談内容3（研修担当）
	 */
	public String getInterviewTraContents3() {

		return interviewTraContents3;

	}

	/**
	 * <dd>メソッド名：面談相談内容3（研修担当）設定メソッド
	 * <dd>メソッド説明：面談相談内容3（研修担当）を設定します。
	 * @param interviewTraContents3 面談相談内容3（研修担当）
	 */
	public void setInterviewTraContents3(String interviewTraContents3) {

		this.interviewTraContents3 = interviewTraContents3;

	}

	/**
	 * <dd>メソッド名：面談内容3取得メソッド
	 * <dd>メソッド説明：面談内容3を取得します。
	 * @return interviewContents3 面談内容3
	 */
	public String getInterviewContents3() {

		return interviewContents3;

	}

	/**
	 * <dd>メソッド名：面談内容3設定メソッド
	 * <dd>メソッド説明：面談内容3を設定します。
	 * @param interviewContents3 面談内容3
	 */
	public void setInterviewContents3(String interviewContents3) {

		this.interviewContents3 = interviewContents3;

	}

}
