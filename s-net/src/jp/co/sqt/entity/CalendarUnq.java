/*
 *CalenderUnq.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (社員管理業務)
 *クラス一覧：
 * NO クラス名 概要
 * 1 CalenderUnq データベースから取得した情報を保持するクラスです。
 *履歴：
 * NO 日付 Ver 更新者 内容
 * 1 2017/00/00 V1L1.0 SQT）加瀬 初版。
 */

package jp.co.sqt.entity;

import java.io.Serializable;

/**
 * <dd>クラス名：日付情報エンティティクラス
 * <dd>クラス説明：データベースから取得した情報を保持します。
 *
 * @version 1.00 2017/00/00
 * @author SQT）加瀬
 */
public class CalendarUnq implements Serializable {

	/** 直列化ID */
	private static final long serialVersionUID = 1L;

	/** 日付NO */
	private int calenderNo;

	/** 日付ONOFFチェック */
	private int calenderChk;

	/** 日付 */
	private String calenderOnDate;

	/** 曜日 */
	private String calenderWeek;

	/** 祝日 */
//	private String calenderHoliday;

	/**
	 * <dd>メソッド名：Calenderデフォルトコンストラクタメソッド
	 * <dd>メソッド説明：インスタンスの生成を可能にします。
	 */
	public CalendarUnq() {
	}

	/**
	 * <dd>メソッド名：Calenderコンストラクタメソッド
	 * <dd>メソッド説明：日付情報を初期化します。
	 * @param calenderNo 日付NO
	 * @param calenderChk 日付ONOFFチェック
	 * @param calenderOnDate 日付
	 * @param calenderWeek 曜日
	 * @param calenderHoliday 祝日
	 */
	public CalendarUnq(int calenderNo, int calenderChk, String calenderOnDate,
			String calenderWeek) {

		super();

		this.calenderNo = calenderNo;

		this.calenderChk = calenderChk;

		this.calenderOnDate = calenderOnDate;

		this.calenderWeek = calenderWeek;

	}

	/**
	 * <dd>メソッド名：日付No取得メソッド
	 * <dd>メソッド説明：日付Noを取得します。
	 *
	 * @return calenderNo 日付No
	 */
	public int getCalenderNo() {

		return calenderNo;

	}

	/**
	 * <dd>メソッド名：日付No設定メソッド
	 * <dd>メソッド説明：日付Noを設定します。
	 *
	 * @param calenderNo
	 *            日付No
	 */
	public void setCalenderNo(int calenderNo) {

		this.calenderNo = calenderNo;

	}

	/**
	 * <dd>メソッド名：日付ONOFFチェック取得メソッド
	 * <dd>メソッド説明：日付ONOFFチェックを取得します。
	 *
	 * @return calenderChk 日付ONOFFチェック
	 */
	public int getCalenderChk() {

		return calenderChk;

	}

	/**
	 * <dd>メソッド名：日付ONOFFチェック設定メソッド
	 * <dd>メソッド説明：日付ONOFFチェックを設定します。
	 *
	 * @param calenderChk
	 *            日付ONOFFチェック
	 */
	public void setCalenderChk(int calenderChk) {

		this.calenderChk = calenderChk;

	}

	/**
	 * <dd>メソッド名：日付取得メソッド
	 * <dd>メソッド説明：日付を取得します。
	 *
	 * @return calenderOnDate 日付
	 */
	public String getCalenderOnDate() {

		return calenderOnDate;

	}

	/**
	 * <dd>メソッド名：日付設定メソッド
	 * <dd>メソッド説明：日付を設定します。
	 *
	 * @param calenderOnDate
	 *            日付
	 */
	public void setCalenderOnDate(String calenderOnDate) {

		this.calenderOnDate = calenderOnDate;

	}

	/**
	 * <dd>メソッド名：曜日取得メソッド
	 * <dd>メソッド説明：曜日を取得します。
	 *
	 * @return calenderWeek 曜日
	 */
	public String getCalenderWeek() {

		return calenderWeek;

	}

	/**
	 * <dd>メソッド名：曜日設定メソッド
	 * <dd>メソッド説明：曜日を設定します。
	 *
	 * @param calenderWeek
	 *            曜日
	 */
	public void setCalenderWeek(String calenderWeek) {

		this.calenderWeek = calenderWeek;

	}

/*	*//**
	 * <dd>メソッド名：休日取得メソッド
	 * <dd>メソッド説明：休日を取得します。
	 *
	 * @return calenderHoliday 休日
	 *//*
	public String getCalenderHoliday() {

		return calenderHoliday;

	}

	*//**
	 * <dd>メソッド名：休日設定メソッド
	 * <dd>メソッド説明：休日を設定します。
	 *
	 * @param calenderHoliday
	 *            休日
	 *//*
	public void setCalenderHoliday(String calenderHoliday) {

		this.calenderHoliday = calenderHoliday;

	}
*/
}
