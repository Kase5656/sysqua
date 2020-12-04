/*
 *Attendance.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (社員管理業務)
 *クラス一覧：
 * NO クラス名 概要
 * 1 Attendance データベースから取得した情報を保持するクラスです。
 *履歴：
 * NO 日付 Ver 更新者 内容
 * 1 2017/00/00 V1L1.0 SQT）加瀬 初版。
 */

package jp.co.sqt.entity;

import java.io.Serializable;

/**
 * <dd>クラス名：勤怠情報エンティティクラス
 * <dd>クラス説明：勤怠ID、勤怠名を扱います。
 * データベースから取得した情報を保持します。
 * @version 1.00 2017/00/00
 * @author SQT）t加瀬
 */
public class Attendance implements Serializable {

	/**　直列化ID　*/
	private static final long serialVersionUID = 1L;

	/**　No　*/
	private Integer attendanceNo;

	/**　アカウントNo　*/
	private Integer accountNo;

	/**　勤怠日付　*/
	private String attendanceDate;

	/**　勤怠(出勤)　*/
	private String attendanceStart;

	/**　勤怠(退勤)　*/
	private String attendanceEnd;

	/**　勤怠ステータス(出勤)　*/
	private String attendanceStartStatus;

	/**　勤怠ステータス(退勤)　*/
	private String attendanceEndStatus;

	/**　勤怠備考(出勤)　*/
	private String attendanceStartRemarks;

	/**　勤怠備考(退勤)　*/
	private String attendanceEndRemarks;

	/**
	 * <dd>メソッド名：Attendanceデフォルトコンストラクタメソッド
	 * <dd>メソッド説明：インスタンスの生成を可能にします。
	 */
	public Attendance() {
	}

	/**
	 * <dd>メソッド名：Attendanceコンストラクタメソッド
	 * <dd>メソッド説明：勤怠情報を初期化します。
	 * @param attendanceNo No
	 * @param accountNo アカウントNo
	 * @param attendanceDate 勤怠日付
	 * @param attendanceStart 勤怠(出勤)
	 * @param attendanceEnd 勤怠(退勤)
	 * @param attendanceStartStatus 勤怠ステータス(出勤)
	 * @param attendanceEndStatus 勤怠ステータス(退勤)
	 * @param attendanceStartRemarks 勤怠備考(出勤)
	 * @param attendanceEndRemarks 勤怠備考(退勤)
	 */
	public Attendance(Integer attendanceNo, Integer accountNo, String attendanceDate,
			String attendanceStart, String attendanceEnd, String attendanceStartStatus, String attendanceEndStatus,
			String attendanceStartRemarks, String attendanceEndRemarks) {

		super();

		this.attendanceNo = attendanceNo;

		this.accountNo = accountNo;

		this.attendanceDate = attendanceDate;

		this.attendanceStart = attendanceStart;

		this.attendanceEnd = attendanceEnd;

		this.attendanceStartStatus = attendanceStartStatus;

		this.attendanceEndStatus = attendanceEndStatus;

		this.attendanceStartRemarks = attendanceStartRemarks;

		this.attendanceEndRemarks = attendanceEndRemarks;

	}

	/**
	 * <dd>メソッド名：No取得メソッド
	 * <dd>メソッド説明：Noを取得します。
	 * @return no No
	 */
	public Integer getAttendanceNo() {

		return attendanceNo;

	}

	/**
	 * <dd>メソッド名：No設定メソッド
	 * <dd>メソッド説明：Noを設定します。
	 * @param attendanceNo No
	 */
	public void setAttendanceNo(Integer attendanceNo) {

		this.attendanceNo = attendanceNo;

	}

	/**
	 * <dd>メソッド名：アカウントNo取得メソッド
	 * <dd>メソッド説明：アカウントNoを取得します。
	 * @return accountNo アカウントNo
	 */
	public Integer getAccountNo() {

		return accountNo;

	}

	/**
	 * <dd>メソッド名：アカウントNo設定メソッド
	 * <dd>メソッド説明：アカウントNoを設定します。
	 * @param accountNo アカウントNo
	 */
	public void setAccountNo(Integer accountNo) {

		this.accountNo = accountNo;

	}

	/**
	 * <dd>メソッド名：勤怠日付取得メソッド
	 * <dd>メソッド説明：勤怠日付を取得します。
	 * @return attendanceDate 勤怠日付
	 */
	public String getAttendanceDate() {

		return attendanceDate;

	}

	/**
	 * <dd>メソッド名：勤怠日付設定メソッド
	 * <dd>メソッド説明：勤怠日付を設定します。
	 * @param attendanceDate 勤怠日付
	 */
	public void setAttendanceDate(String attendanceDate) {

		this.attendanceDate = attendanceDate;

	}

	/**
	 * <dd>メソッド名：勤怠(出勤)取得メソッド
	 * <dd>メソッド説明：勤怠(出勤)を取得します。
	 * @return attendanceStart 勤怠(出勤)
	 */
	public String getAttendanceStart() {

		return attendanceStart;

	}

	/**
	 * <dd>メソッド名：勤怠(出勤)設定メソッド
	 * <dd>メソッド説明：勤怠(出勤)を設定します。
	 * @param attendanceStart 勤怠(出勤)
	 */
	public void setAttendanceStart(String attendanceStart) {

		this.attendanceStart = attendanceStart;

	}

	/**
	 * <dd>メソッド名：勤怠(退勤)取得メソッド
	 * <dd>メソッド説明：勤怠(退勤)を取得します。
	 * @return attendanceEnd 勤怠(退勤)
	 */
	public String getAttendanceEnd() {

		return attendanceEnd;

	}

	/**
	 * <dd>メソッド名：勤怠(退勤)設定メソッド
	 * <dd>メソッド説明：勤怠(退勤)を設定します。
	 * @param attendanceEnd 勤怠(退勤)
	 */
	public void setAttendanceEnd(String attendanceEnd) {

		this.attendanceEnd = attendanceEnd;

	}

	/**
	 * <dd>メソッド名：勤怠ステータス(出勤)取得メソッド
	 * <dd>メソッド説明：勤怠ステータス(出勤)を取得します。
	 * @return attendanceStartStatus 勤怠ステータス(出勤)
	 */
	public String getAttendanceStartStatus() {

		return attendanceStartStatus;

	}

	/**
	 * <dd>メソッド名：勤怠ステータス(出勤)設定メソッド
	 * <dd>メソッド説明：勤怠ステータス(出勤)を設定します。
	 * @param attendanceStartStatus 勤怠ステータス(出勤)
	 */
	public void setAttendanceStartStatus(String attendanceStartStatus) {

		this.attendanceStartStatus = attendanceStartStatus;

	}

	/**
	 * <dd>メソッド名：勤怠ステータス(退勤)取得メソッド
	 * <dd>メソッド説明：勤怠ステータス(退勤)を取得します。
	 * @return attendanceEndStatus 勤怠ステータス(退勤)
	 */
	public String getAttendanceEndStatus() {

		return attendanceEndStatus;

	}

	/**
	 * <dd>メソッド名：勤怠ステータス(退勤)設定メソッド
	 * <dd>メソッド説明：勤怠ステータス(退勤)を設定します。
	 * @param attendanceEndStatus 勤怠ステータス(退勤)
	 */
	public void setAttendanceEndStatus(String attendanceEndStatus) {

		this.attendanceEndStatus = attendanceEndStatus;

	}

	/**
	 * <dd>メソッド名：勤怠備考(出勤)取得メソッド
	 * <dd>メソッド説明：勤怠備考(出勤)を取得します。
	 * @return attendanceStartRemarks 勤怠備考(出勤)
	 */
	public String getAttendanceStartRemarks() {

		return attendanceStartRemarks;

	}

	/**
	 * <dd>メソッド名：勤怠備考(出勤)設定メソッド
	 * <dd>メソッド説明：勤怠備考(出勤)を設定します。
	 * @param attendanceStartRemarks 勤怠備考(出勤)
	 */
	public void setAttendanceStartRemarks(String attendanceStartRemarks) {

		this.attendanceStartRemarks = attendanceStartRemarks;

	}

	/**
	 * <dd>メソッド名：勤怠備考(退勤)取得メソッド
	 * <dd>メソッド説明：勤怠備考(退勤)を取得します。
	 * @return attendanceEndRemarks 勤怠備考(退勤)
	 */
	public String getAttendanceEndRemarks() {

		return attendanceEndRemarks;

	}

	/**
	 * <dd>メソッド名：勤怠備考(退勤)設定メソッド
	 * <dd>メソッド説明：勤怠備考(退勤)を設定します。
	 * @param attendanceEndRemarks 勤怠備考(退勤)
	 */
	public void setAttendanceEndRemarks(String attendanceEndRemarks) {

		this.attendanceEndRemarks = attendanceEndRemarks;

	}

}
