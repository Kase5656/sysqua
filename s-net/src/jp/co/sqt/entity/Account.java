/*
 *Account.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (社員管理業務)
 *クラス一覧：
 * NO クラス名 概要
 * 1 Account データベースから取得した情報を保持するクラスです。
 *履歴：
 * NO 日付 Ver 更新者 内容
 * 1 2017/00/00 V1L1.0 SQT）加瀬 初版。
 */

package jp.co.sqt.entity;

import java.io.Serializable;

/**
 * <dd>クラス名：アカウント情報エンティティクラス
 * <dd>クラス説明：アカウントID、アカウント名を扱います。 データベースから取得した情報を保持します。
 *
 * @version 1.00 2017/00/00
 * @author SQT）加瀬
 */
public class Account implements Serializable {

	/** 直列化ID */
	private static final long serialVersionUID = 1L;

	/** アカウントNo */
	private int accountNo;

	/** 企業No */
	private int corporationNo;

	/** アカウントID */
	private String accountId;

	/** アカウント名 */
	private String accountName;

	/** パスワード */
	private String accountPassword;

	/** 再パスワード */
	private String accountRePassword;

	/** 権限 */
	private int accountAuthority;

	/** 備考 */
	private String accountRemarks;

	/**  入社月日*/
	private String enterningDate;

	/** 会社情報 */
	private Corporation corporation;

	/** 受講生情報 */
	private Education education;

	/**
	 * <dd>メソッド名：Accountデフォルトコンストラクタメソッド
	 * <dd>メソッド説明：インスタンスの生成を可能にします。
	 */
	public Account() {
	}

	/**
	 * <dd>メソッド名：Accountコンストラクタメソッド
	 * <dd>メソッド説明：アカウント情報を初期化します。
	 *
	 * @param accountNo
	 *            アカウントNo
	 * @param accountPassword
	 *            パスワード
	 * @param accountRePassword
	 *            再パスワード
	 */
	public Account(int accountNo, String accountPassword, String accountRePassword) {

		super();

		this.accountNo = accountNo;

		this.accountPassword = accountPassword;

		this.accountRePassword = accountRePassword;

	}

	/**
	 * <dd>メソッド名：Accountコンストラクタメソッド
	 * <dd>メソッド説明：アカウント情報を初期化します。
	 *
	 * @param accountNo
	 *            アカウントNo
	 * @param corporationNo
	 *            企業No
	 * @param accountId
	 *            アカウントID
	 * @param accountName
	 *            アカウント名
	 * @param accountPassword
	 *            パスワード
	 * @param accountRePassword
	 *            再パスワード
	 * @param accountAuthority
	 *            権限
	 * @param accountRemarks
	 *            備考
	 */
	public Account(int accountNo, int corporationNo, String accountId, String accountName,
			String accountPassword, String accountRePassword, int accountAuthority, String accountRemarks) {

		super();

		this.accountNo = accountNo;

		this.corporationNo = corporationNo;

		this.accountId = accountId;

		this.accountName = accountName;

		this.accountPassword = accountPassword;

		this.accountRePassword = accountRePassword;

		this.accountAuthority = accountAuthority;

		this.accountRemarks = accountRemarks;

	}

	/**
	 * <dd>メソッド名：Accountコンストラクタメソッド
	 * <dd>メソッド説明：アカウント情報を初期化します。
	 *
	 * @param accountNo
	 *            アカウントNo
	 * @param corporationNo
	 *            企業No
	 * @param educationId
	 *            受講生ID
	 * @param accountId
	 *            アカウントID
	 * @param accountName
	 *            アカウント名
	 * @param accountPassword
	 *            パスワード
	 * @param accountRePassword
	 *            再パスワード
	 * @param accountAuthority
	 *            権限
	 * @param accountRemarks
	 *            備考
	 * @param corporation
	 *            会社情報
	 * @param education
	 *            受講生情報
	 */

	public Account(int accountNo, int corporationNo, String accountId, String accountName,
			String accountPassword, String accountRePassword, int accountAuthority, String accountRemarks,
			Corporation corporation, Education education) {

		super();

		this.accountNo = accountNo;

		this.corporationNo = corporationNo;

		this.accountId = accountId;

		this.accountName = accountName;

		this.accountPassword = accountPassword;

		this.accountRePassword = accountRePassword;

		this.accountAuthority = accountAuthority;

		this.accountRemarks = accountRemarks;

		this.corporation = corporation;

		this.education = education;

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
	 * <dd>メソッド名：アカウントID取得メソッド
	 * <dd>メソッド説明：アカウントIDを取得します。
	 *
	 * @return accountUseId アカウントID
	 */
	public String getAccountId() {

		return accountId;

	}

	/**
	 * <dd>メソッド名：アカウントID設定メソッド
	 * <dd>メソッド説明：アカウントIDを設定します。
	 *
	 * @param accountUserId
	 *            アカウントID
	 */
	public void setAccountId(String accountId) {

		this.accountId = accountId;

	}

	/**
	 * <dd>メソッド名：アカウント名取得メソッド
	 * <dd>メソッド説明：アカウント名を取得します。
	 *
	 * @return accountName アカウント名
	 */
	public String getAccountName() {

		return accountName;

	}

	/**
	 * <dd>メソッド名：アカウント名設定メソッド
	 * <dd>メソッド説明：アカウント名を設定します。
	 *
	 * @param accountName
	 *            アカウント名
	 */
	public void setAccountName(String accountName) {

		this.accountName = accountName;

	}

	/**
	 * <dd>メソッド名：パスワード取得メソッド
	 * <dd>メソッド説明：パスワードを取得します。
	 *
	 * @return accountPassword パスワード
	 */
	public String getAccountPassword() {

		return accountPassword;

	}

	/**
	 * <dd>メソッド名：パスワード設定メソッド
	 * <dd>メソッド説明：パスワードを設定します。
	 *
	 * @param accountPassword
	 *            パスワード
	 */
	public void setAccountPassword(String accountPassword) {

		this.accountPassword = accountPassword;

	}

	/**
	 * <dd>メソッド名：再アカウント名取得メソッド
	 * <dd>メソッド説明：再アカウント名を取得します。
	 *
	 * @return accountRePassword 再アカウント名
	 */
	public String getAccountRePassword() {

		return accountRePassword;

	}

	/**
	 * <dd>メソッド名：再アカウント名設定メソッド
	 * <dd>メソッド説明：再アカウント名を設定します。
	 *
	 * @param accountRePassword
	 *            再アカウント名
	 */
	public void setAccountRePassword(String accountRePassword) {

		this.accountRePassword = accountRePassword;

	}

	/**
	 * <dd>メソッド名：権限取得メソッド
	 * <dd>メソッド説明：権限を取得します。
	 *
	 * @return accountAuthority 権限
	 */
	public int getAccountAuthority() {

		return accountAuthority;

	}

	/**
	 * <dd>メソッド名：権限設定メソッド
	 * <dd>メソッド説明：権限を設定します。
	 *
	 * @param accountAuthority
	 *            権限
	 */
	public void setAccountAuthority(int accountAuthority) {

		this.accountAuthority = accountAuthority;

	}

	/**
	 * <dd>メソッド名：備考取得メソッド
	 * <dd>メソッド説明：備考を取得します。
	 *
	 * @return accountRemarks 備考
	 */
	public String getAccountRemarks() {

		return accountRemarks;

	}

	/**
	 * <dd>メソッド名：備考設定メソッド
	 * <dd>メソッド説明：備考を設定します。
	 *
	 * @param accountRemarks
	 *            備考
	 */
	public void setAccountRemarks(String accountRemarks) {

		this.accountRemarks = accountRemarks;

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
	 * <dd>メソッド名：会社情報取得メソッド
	 * <dd>メソッド説明：会社情報を取得します。
	 *
	 * @return corporation 会社情報
	 */
	public Corporation getCorporation() {

		return corporation;

	}

	/**
	 * <dd>メソッド名：会社情報設定メソッド
	 * <dd>メソッド説明：会社情報を設定します。
	 *
	 * @param corporation
	 *            会社情報
	 */
	public void setCorp(Corporation corporation) {

		this.corporation = corporation;

	}

	/**
	 * <dd>メソッド名：受講生情報取得メソッド
	 * <dd>メソッド説明：受講生情報を取得します。
	 *
	 * @return education 受講生情報
	 */
	public Education getEducation() {

		return education;

	}

	/**
	 * <dd>メソッド名：受講生情報設定メソッド
	 * <dd>メソッド説明：受講生情報を設定します。
	 *
	 * @param education
	 *            受講生情報
	 */
	public void setEducation(Education education) {

		this.education = education;

	}

}
